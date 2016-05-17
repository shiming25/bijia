package com.sou.common.util.lang;

public class ObjectUtil {
	public static Object defaultIfNull(Object object, Object defaultValue) {
		return object != null ? object : defaultValue;
	}

	public static boolean equals(Object object1, Object object2) {
		if (object1 == object2) {
			return true;
		}
		if ((object1 == null) || (object2 == null)) {
			return false;
		}
		return object1.equals(object2);
	}

	public static int hashCode(Object obj) {
		return obj == null ? 0 : obj.hashCode();
	}

	public static Object max(Comparable c1, Comparable c2) {
		if ((c1 != null) && (c2 != null)) {
			return c1.compareTo(c2) >= 0 ? c1 : c2;
		}
		return c1 != null ? c1 : c2;
	}

	public static Object min(Comparable c1, Comparable c2) {
		if ((c1 != null) && (c2 != null)) {
			return c1.compareTo(c2) < 1 ? c1 : c2;
		}
		return c1 != null ? c1 : c2;
	}

	public static String toString(Object obj) {
		return obj == null ? "" : obj.toString();
	}

	public static String toString(Object obj, String nullStr) {
		return obj == null ? nullStr : obj.toString();
	}
}
