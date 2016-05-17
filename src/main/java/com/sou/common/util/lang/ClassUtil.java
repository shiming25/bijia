package com.sou.common.util.lang;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sou.common.util.lang.exception.NullArgumentException;

public class ClassUtil {
	private static final Map abbreviationMap = new HashMap();
	public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
	public static final char PACKAGE_SEPARATOR_CHAR = '.';
	private static final Map primitiveWrapperMap = new HashMap();

	private static final Map reverseAbbreviationMap = new HashMap();

	private static final Map wrapperPrimitiveMap = new HashMap();

	static {
		primitiveWrapperMap.put(Boolean.TYPE, Boolean.class);
		primitiveWrapperMap.put(Byte.TYPE, Byte.class);
		primitiveWrapperMap.put(Character.TYPE, Character.class);
		primitiveWrapperMap.put(Short.TYPE, Short.class);
		primitiveWrapperMap.put(Integer.TYPE, Integer.class);
		primitiveWrapperMap.put(Long.TYPE, Long.class);
		primitiveWrapperMap.put(Double.TYPE, Double.class);
		primitiveWrapperMap.put(Float.TYPE, Float.class);
		primitiveWrapperMap.put(Void.TYPE, Void.TYPE);

		for (Iterator it = primitiveWrapperMap.keySet().iterator(); it
				.hasNext();) {
			Class primitiveClass = (Class) it.next();
			Class wrapperClass = (Class) primitiveWrapperMap
					.get(primitiveClass);
			if (!primitiveClass.equals(wrapperClass)) {
				wrapperPrimitiveMap.put(wrapperClass, primitiveClass);
			}

		}

		addAbbreviation("int", "I");
		addAbbreviation("boolean", "Z");
		addAbbreviation("float", "F");
		addAbbreviation("long", "J");
		addAbbreviation("short", "S");
		addAbbreviation("byte", "B");
		addAbbreviation("double", "D");
		addAbbreviation("char", "C");
	}

	private static void addAbbreviation(String primitive, String abbreviation) {
		abbreviationMap.put(primitive, abbreviation);
		reverseAbbreviationMap.put(abbreviation, primitive);
	}

	public static List convertClassesToClassNames(List classes) {
		if (classes == null) {
			return null;
		}
		List classNames = new ArrayList(classes.size());
		for (Iterator it = classes.iterator(); it.hasNext();) {
			Class cls = (Class) it.next();
			if (cls == null)
				classNames.add(null);
			else {
				classNames.add(cls.getName());
			}
		}
		return classNames;
	}

	public static List convertClassNamesToClasses(List classNames) {
		if (classNames == null) {
			return null;
		}
		List classes = new ArrayList(classNames.size());
		for (Iterator it = classNames.iterator(); it.hasNext();) {
			String className = (String) it.next();
			try {
				classes.add(Class.forName(className));
			} catch (Exception ex) {
				classes.add(null);
			}
		}
		return classes;
	}

	public static List getAllInterfaces(Class cls) {
		if (cls == null) {
			return null;
		}
		List interfacesFound = new ArrayList();
		getAllInterfaces(cls, interfacesFound);
		return interfacesFound;
	}

	private static void getAllInterfaces(Class cls, List interfacesFound) {
		while (cls != null) {
			Class[] interfaces = cls.getInterfaces();
			for (int i = 0; i < interfaces.length; i++) {
				if (!interfacesFound.contains(interfaces[i])) {
					interfacesFound.add(interfaces[i]);
					getAllInterfaces(interfaces[i], interfacesFound);
				}
			}
			cls = cls.getSuperclass();
		}
	}

	public static List getAllSuperclasses(Class cls) {
		if (cls == null) {
			return null;
		}
		List classes = new ArrayList();
		Class superclass = cls.getSuperclass();
		while (superclass != null) {
			classes.add(superclass);
			superclass = superclass.getSuperclass();
		}
		return classes;
	}

	public static Class getClass(ClassLoader classLoader, String className)
			throws ClassNotFoundException {
		return getClass(classLoader, className, true);
	}

	public static Class getClass(ClassLoader classLoader, String className,
			boolean initialize) throws ClassNotFoundException {
		Class clazz;
		if (abbreviationMap.containsKey(className)) {
			String clsName = "[" + abbreviationMap.get(className);
			clazz = Class.forName(clsName, initialize, classLoader)
					.getComponentType();
		} else {
			clazz = Class.forName(toCanonicalName(className), initialize,
					classLoader);
		}
		return clazz;
	}

	public static Class getClass(String className)
			throws ClassNotFoundException {
		return getClass(className, true);
	}

	public static Class getClass(String className, boolean initialize)
			throws ClassNotFoundException {
		ClassLoader contextCL = Thread.currentThread().getContextClassLoader();
		ClassLoader loader = contextCL == null ? ClassUtil.class
				.getClassLoader() : contextCL;
		return getClass(loader, className, initialize);
	}

	public static String getPackageName(Class cls) {
		if (cls == null) {
			return "";
		}
		return getPackageName(cls.getName());
	}

	public static String getPackageName(Object object, String valueIfNull) {
		if (object == null) {
			return valueIfNull;
		}
		return getPackageName(object.getClass());
	}

	public static String getPackageName(String className) {
		if ((className == null) || (className.length() == 0)) {
			return "";
		}
		do
			className = className.substring(1);
		while (className.charAt(0) == '[');

		if ((className.charAt(0) == 'L')
				&& (className.charAt(className.length() - 1) == ';')) {
			className = className.substring(1);
		}
		int i = className.lastIndexOf('.');
		if (i == -1) {
			return "";
		}
		return className.substring(0, i);
	}

	public static Method getPublicMethod(Class cls, String methodName,
			Class[] parameterTypes) throws SecurityException,
			NoSuchMethodException {
		Method declaredMethod = cls.getMethod(methodName, parameterTypes);

		if (Modifier
				.isPublic(declaredMethod.getDeclaringClass().getModifiers())) {
			return declaredMethod;
		}

		List candidateClasses = new ArrayList();
		candidateClasses.addAll(getAllInterfaces(cls));
		candidateClasses.addAll(getAllSuperclasses(cls));
		Method candidateMethod;
		for (Iterator it = candidateClasses.iterator(); it.hasNext();) {
			Class candidateClass = (Class) it.next();
			if (!Modifier.isPublic(candidateClass.getModifiers())) {
				continue;
			}
			try {
				candidateMethod = candidateClass.getMethod(methodName,
						parameterTypes);
			} catch (NoSuchMethodException ex) {

				continue;
			}

			if (Modifier.isPublic(candidateMethod.getDeclaringClass()
					.getModifiers())) {
				return candidateMethod;
			}
		}

		throw new NoSuchMethodException("Can't find a public method for "
				+ methodName);
	}

	public static String getShortClassName(Class cls) {
		if (cls == null) {
			return "";
		}
		return getShortClassName(cls.getName());
	}

	public static String getShortClassName(Object object, String valueIfNull) {
		if (object == null) {
			return valueIfNull;
		}
		return getShortClassName(object.getClass());
	}

	public static String getShortClassName(String className) {
		if (className == null) {
			return "";
		}
		if (className.length() == 0) {
			return "";
		}

		StringBuffer arrayPrefix = new StringBuffer();

		if (className.startsWith("[")) {
			while (className.charAt(0) == '[') {
				className = className.substring(1);
				arrayPrefix.append("[]");
			}
			if ((className.charAt(0) == 'L')
					&& (className.charAt(className.length() - 1) == ';')) {
				className = className.substring(1, className.length() - 1);
			}
		}

		if (reverseAbbreviationMap.containsKey(className)) {
			className = (String) reverseAbbreviationMap.get(className);
		}

		int lastDotIdx = className.lastIndexOf('.');
		int innerIdx = className.indexOf('$', lastDotIdx == -1 ? 0
				: lastDotIdx + 1);
		String out = className.substring(lastDotIdx + 1);
		if (innerIdx != -1) {
			out = out.replace('$', '.');
		}
		return out + arrayPrefix;
	}

	public static boolean isInnerClass(Class cls) {
		if (cls == null) {
			return false;
		}
		return cls.getName().indexOf('$') >= 0;
	}

	public static Class[] primitivesToWrappers(Class[] classes) {
		if (classes == null) {
			return null;
		}
		if (classes.length == 0) {
			return classes;
		}
		Class[] convertedClasses = new Class[classes.length];
		for (int i = 0; i < classes.length; i++) {
			convertedClasses[i] = primitiveToWrapper(classes[i]);
		}
		return convertedClasses;
	}

	public static Class primitiveToWrapper(Class cls) {
		Class convertedClass = cls;
		if ((cls != null) && (cls.isPrimitive())) {
			convertedClass = (Class) primitiveWrapperMap.get(cls);
		}
		return convertedClass;
	}

	private static String toCanonicalName(String className) {
		className = StringUtil.deleteWhitespace(className);
		if (className == null)
			throw new NullArgumentException("className");
		if (className.endsWith("[]")) {
			StringBuffer classNameBuffer = new StringBuffer();
			while (className.endsWith("[]")) {
				className = className.substring(0, className.length() - 2);
				classNameBuffer.append("[");
			}
			String abbreviation = (String) abbreviationMap.get(className);
			if (abbreviation != null)
				classNameBuffer.append(abbreviation);
			else {
				classNameBuffer.append("L").append(className).append(";");
			}
			className = classNameBuffer.toString();
		}
		return className;
	}

	public static Class[] toClass(Object[] array) {
		if (array == null)
			return null;
		if (array.length == 0) {
			return ArrayUtil.EMPTY_CLASS_ARRAY;
		}
		Class[] classes = new Class[array.length];
		for (int i = 0; i < array.length; i++) {
			classes[i] = (array[i] == null ? null : array[i].getClass());
		}
		return classes;
	}

	public static Class[] wrappersToPrimitives(Class[] classes) {
		if (classes == null) {
			return null;
		}

		if (classes.length == 0) {
			return classes;
		}

		Class[] convertedClasses = new Class[classes.length];
		for (int i = 0; i < classes.length; i++) {
			convertedClasses[i] = wrapperToPrimitive(classes[i]);
		}
		return convertedClasses;
	}

	public static Class wrapperToPrimitive(Class cls) {
		return (Class) wrapperPrimitiveMap.get(cls);
	}
}
