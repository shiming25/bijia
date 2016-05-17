package com.sou.common.util.lang;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

public class NumberUtil {
	public static int compare(double lhs, double rhs) {
		if (lhs < rhs) {
			return -1;
		}
		if (lhs > rhs) {
			return 1;
		}
		long lhsBits = Double.doubleToLongBits(lhs);
		long rhsBits = Double.doubleToLongBits(rhs);
		if (lhsBits == rhsBits) {
			return 0;
		}
		if (lhsBits < rhsBits) {
			return -1;
		}
		return 1;
	}

	public static int compare(float lhs, float rhs) {
		if (lhs < rhs) {
			return -1;
		}
		if (lhs > rhs) {
			return 1;
		}
		int lhsBits = Float.floatToIntBits(lhs);
		int rhsBits = Float.floatToIntBits(rhs);
		if (lhsBits == rhsBits) {
			return 0;
		}
		if (lhsBits < rhsBits) {
			return -1;
		}
		return 1;
	}

	public static BigDecimal createBigDecimal(String str) {
		if (str == null) {
			return null;
		}
		if (StringUtil.isBlank(str)) {
			throw new NumberFormatException(
					"A blank string is not a valid number");
		}
		return new BigDecimal(str);
	}

	public static BigInteger createBigInteger(String str) {
		if (str == null) {
			return null;
		}
		return new BigInteger(str);
	}

	public static Double createDouble(String str) {
		if (str == null) {
			return null;
		}
		return Double.valueOf(str);
	}

	public static Float createFloat(String str) {
		if (str == null) {
			return null;
		}
		return Float.valueOf(str);
	}

	public static Integer createInteger(String str) {
		if (str == null) {
			return null;
		}
		return Integer.decode(str);
	}

	public static Long createLong(String str) {
		if (str == null) {
			return null;
		}
		return Long.valueOf(str);
	}

	public static Number createNumber(String str) throws NumberFormatException {
		if (str == null) {
			return null;
		}
		if (StringUtil.isBlank(str)) {
			throw new NumberFormatException(
					"A blank string is not a valid number");
		}
		if (str.startsWith("--")) {
			return null;
		}
		if ((str.startsWith("0x")) || (str.startsWith("-0x"))) {
			return createInteger(str);
		}
		char lastChar = str.charAt(str.length() - 1);

		int decPos = str.indexOf('.');
		int expPos = str.indexOf('e') + str.indexOf('E') + 1;
		String mant;

		String dec;
		if (decPos > -1) {

			if (expPos > -1) {
				if (expPos < decPos) {
					throw new NumberFormatException(str
							+ " is not a valid number.");
				}
				dec = str.substring(decPos + 1, expPos);
			} else {
				dec = str.substring(decPos + 1);
			}
			mant = str.substring(0, decPos);
		} else {

			if (expPos > -1)
				mant = str.substring(0, expPos);
			else {
				mant = str;
			}
			dec = null;
		}
		if ((!Character.isDigit(lastChar)) && (lastChar != '.')) {
			String exp;

			if ((expPos > -1) && (expPos < str.length() - 1))
				exp = str.substring(expPos + 1, str.length() - 1);
			else {
				exp = null;
			}

			String numeric = str.substring(0, str.length() - 1);
			boolean allZeros = (isAllZeros(mant)) && (isAllZeros(exp));
			switch (lastChar) {
			case 'L':
			case 'l':
				if ((dec == null)
						&& (exp == null)
						&& (((numeric.charAt(0) == '-') && (isDigits(numeric
								.substring(1)))) || (isDigits(numeric)))) {
					try {
						return createLong(numeric);
					} catch (NumberFormatException localNumberFormatException) {
						return createBigInteger(numeric);
					}
				}
				throw new NumberFormatException(str + " is not a valid number.");
			case 'F':
			case 'f':
				try {
					Float f = createFloat(numeric);
					if ((!f.isInfinite())
							&& ((f.floatValue() != 0.0F) || (allZeros)))
						return f;
				} catch (NumberFormatException localNumberFormatException1) {
				}
			case 'D':
			case 'd':
				try {
					Double d = createDouble(numeric);
					if ((!d.isInfinite())
							&& ((d.floatValue() != 0.0D) || (allZeros)))
						return d;
				} catch (NumberFormatException localNumberFormatException3) {
					try {
						return createBigDecimal(numeric);
					} catch (NumberFormatException localNumberFormatException32) {
					}
				}
			}
			throw new NumberFormatException(str + " is not a valid number.");
		}
		String exp;
		if ((expPos > -1) && (expPos < str.length() - 1))
			exp = str.substring(expPos + 1, str.length());
		else {
			exp = null;
		}
		if ((dec == null) && (exp == null))
			try {
				return createInteger(str);
			} catch (NumberFormatException localNumberFormatException5) {
				try {
					return createLong(str);
				} catch (NumberFormatException localNumberFormatException52) {
					return createBigInteger(str);
				}
			}
		boolean allZeros = (isAllZeros(mant)) && (isAllZeros(exp));
		try {
			Float f = createFloat(str);
			if ((!f.isInfinite()) && ((f.floatValue() != 0.0F) || (allZeros)))
				return f;
		} catch (NumberFormatException localNumberFormatException7) {
			try {
				Double d = createDouble(str);
				if ((!d.isInfinite())
						&& ((d.doubleValue() != 0.0D) || (allZeros)))
					return d;
			} catch (NumberFormatException localNumberFormatException72) {
			}
		}
		return createBigDecimal(str);
	}

	private static boolean isAllZeros(String str) {
		if (str == null) {
			return true;
		}
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) != '0') {
				return false;
			}
		}
		return str.length() > 0;
	}

	public static boolean isDigits(String str) {
		if (StringUtil.isEmpty(str)) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNumber(String str) {
		if (StringUtil.isEmpty(str)) {
			return false;
		}
		char[] chars = str.toCharArray();
		int sz = chars.length;
		boolean hasExp = false;
		boolean hasDecPoint = false;
		boolean allowSigns = false;
		boolean foundDigit = false;
		int start = chars[0] == '-' ? 1 : 0;
		if ((sz > start + 1) && (chars[start] == '0')
				&& (chars[(start + 1)] == 'x')) {
			int i = start + 2;
			if (i == sz)
				return false;
			do {
				if (((chars[i] < '0') || (chars[i] > '9'))
						&& ((chars[i] < 'a') || (chars[i] > 'f'))
						&& ((chars[i] < 'A') || (chars[i] > 'F')))
					return false;
				i++;
			} while (i < chars.length);

			return true;
		}

		sz--;
		int i = start;
		while ((i < sz) || ((i < sz + 1) && (allowSigns) && (!foundDigit))) {
			if ((chars[i] >= '0') && (chars[i] <= '9')) {
				foundDigit = true;
				allowSigns = false;
			} else if (chars[i] == '.') {
				if ((hasDecPoint) || (hasExp)) {
					return false;
				}
				hasDecPoint = true;
			} else if ((chars[i] == 'e') || (chars[i] == 'E')) {
				if (hasExp) {
					return false;
				}
				if (!foundDigit) {
					return false;
				}
				hasExp = true;
				allowSigns = true;
			} else if ((chars[i] == '+') || (chars[i] == '-')) {
				if (!allowSigns) {
					return false;
				}
				allowSigns = false;
				foundDigit = false;
			} else {
				return false;
			}
			i++;
		}
		if (i < chars.length) {
			if ((chars[i] >= '0') && (chars[i] <= '9')) {
				return true;
			}
			if ((chars[i] == 'e') || (chars[i] == 'E')) {
				return false;
			}
			if (chars[i] == '.') {
				if ((hasDecPoint) || (hasExp)) {
					return false;
				}
				return foundDigit;
			}
			if ((!allowSigns)
					&& ((chars[i] == 'd') || (chars[i] == 'D')
							|| (chars[i] == 'f') || (chars[i] == 'F'))) {
				return foundDigit;
			}
			if ((chars[i] == 'l') || (chars[i] == 'L')) {
				return (foundDigit) && (!hasExp);
			}
			return false;
		}
		return (!allowSigns) && (foundDigit);
	}

	public static byte max(byte a, byte b, byte c) {
		if (b > a) {
			a = b;
		}
		if (c > a) {
			a = c;
		}
		return a;
	}

	public static byte max(byte[] array) {
		if (array == null)
			throw new IllegalArgumentException("The Array must not be null");
		if (array.length == 0) {
			throw new IllegalArgumentException("Array cannot be empty.");
		}
		byte max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	public static double max(double a, double b, double c) {
		return Math.max(Math.max(a, b), c);
	}

	public static double max(double[] array) {
		if (array == null)
			throw new IllegalArgumentException("The Array must not be null");
		if (array.length == 0) {
			throw new IllegalArgumentException("Array cannot be empty.");
		}
		double max = array[0];
		for (int j = 1; j < array.length; j++) {
			if (Double.isNaN(array[j])) {
				return (0.0D / 0.0D);
			}
			if (array[j] > max) {
				max = array[j];
			}
		}
		return max;
	}

	public static float max(float a, float b, float c) {
		return Math.max(Math.max(a, b), c);
	}

	public static float max(float[] array) {
		if (array == null)
			throw new IllegalArgumentException("The Array must not be null");
		if (array.length == 0) {
			throw new IllegalArgumentException("Array cannot be empty.");
		}
		float max = array[0];
		for (int j = 1; j < array.length; j++) {
			if (Float.isNaN(array[j])) {
				return (0.0F / 0.0F);
			}
			if (array[j] > max) {
				max = array[j];
			}
		}
		return max;
	}

	public static int max(int a, int b, int c) {
		if (b > a) {
			a = b;
		}
		if (c > a) {
			a = c;
		}
		return a;
	}

	public static int max(int[] array) {
		if (array == null)
			throw new IllegalArgumentException("The Array must not be null");
		if (array.length == 0) {
			throw new IllegalArgumentException("Array cannot be empty.");
		}
		int max = array[0];
		for (int j = 1; j < array.length; j++) {
			if (array[j] > max) {
				max = array[j];
			}
		}
		return max;
	}

	public static long max(long a, long b, long c) {
		if (b > a) {
			a = b;
		}
		if (c > a) {
			a = c;
		}
		return a;
	}

	public static long max(long[] array) {
		if (array == null)
			throw new IllegalArgumentException("The Array must not be null");
		if (array.length == 0) {
			throw new IllegalArgumentException("Array cannot be empty.");
		}
		long max = array[0];
		for (int j = 1; j < array.length; j++) {
			if (array[j] > max) {
				max = array[j];
			}
		}
		return max;
	}

	public static short max(short a, short b, short c) {
		if (b > a) {
			a = b;
		}
		if (c > a) {
			a = c;
		}
		return a;
	}

	public static short max(short[] array) {
		if (array == null)
			throw new IllegalArgumentException("The Array must not be null");
		if (array.length == 0) {
			throw new IllegalArgumentException("Array cannot be empty.");
		}
		short max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	public static byte min(byte a, byte b, byte c) {
		if (b < a) {
			a = b;
		}
		if (c < a) {
			a = c;
		}
		return a;
	}

	public static byte min(byte[] array) {
		if (array == null)
			throw new IllegalArgumentException("The Array must not be null");
		if (array.length == 0) {
			throw new IllegalArgumentException("Array cannot be empty.");
		}
		byte min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	public static double min(double a, double b, double c) {
		return Math.min(Math.min(a, b), c);
	}

	public static double min(double[] array) {
		if (array == null)
			throw new IllegalArgumentException("The Array must not be null");
		if (array.length == 0) {
			throw new IllegalArgumentException("Array cannot be empty.");
		}
		double min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (Double.isNaN(array[i])) {
				return (0.0D / 0.0D);
			}
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	public static float min(float a, float b, float c) {
		return Math.min(Math.min(a, b), c);
	}

	public static float min(float[] array) {
		if (array == null)
			throw new IllegalArgumentException("The Array must not be null");
		if (array.length == 0) {
			throw new IllegalArgumentException("Array cannot be empty.");
		}
		float min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (Float.isNaN(array[i])) {
				return (0.0F / 0.0F);
			}
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	public static int min(int a, int b, int c) {
		if (b < a) {
			a = b;
		}
		if (c < a) {
			a = c;
		}
		return a;
	}

	public static int min(int[] array) {
		if (array == null)
			throw new IllegalArgumentException("The Array must not be null");
		if (array.length == 0) {
			throw new IllegalArgumentException("Array cannot be empty.");
		}
		int min = array[0];
		for (int j = 1; j < array.length; j++) {
			if (array[j] < min) {
				min = array[j];
			}
		}
		return min;
	}

	public static long min(long a, long b, long c) {
		if (b < a) {
			a = b;
		}
		if (c < a) {
			a = c;
		}
		return a;
	}

	public static long min(long[] array) {
		if (array == null)
			throw new IllegalArgumentException("The Array must not be null");
		if (array.length == 0) {
			throw new IllegalArgumentException("Array cannot be empty.");
		}
		long min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	public static short min(short a, short b, short c) {
		if (b < a) {
			a = b;
		}
		if (c < a) {
			a = c;
		}
		return a;
	}

	public static short min(short[] array) {
		if (array == null)
			throw new IllegalArgumentException("The Array must not be null");
		if (array.length == 0) {
			throw new IllegalArgumentException("Array cannot be empty.");
		}
		short min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	public static byte toPrimitiveByte(Object object) {
		if (object == null) {
			throw new IllegalArgumentException("The object must not be null");
		}
		if ((object instanceof String)) {
			try {
				return Byte.parseByte((String) object);
			} catch (NumberFormatException nfe) {
				throw new NumberFormatException(object
						+ "is not a valid string.");
			}
		}
		if ((object instanceof Number)) {
			return ((Number) object).byteValue();
		}
		if ((object instanceof Boolean)) {
			if (((Boolean) object).booleanValue()) {
				return 1;
			}
			return 0;
		}
		if (((object instanceof Date)) || ((object instanceof Calendar))) {
			return (byte) (int) toPrimitiveLong(object);
		}
		throw new IllegalArgumentException("can to convert type:"
				+ object.getClass().getName() + " to byte!");
	}

	public static Byte toByte(Object object) {
		if ((object instanceof Byte)) {
			return (Byte) object;
		}
		return new Byte(toPrimitiveByte(object));
	}

	public static byte toPrimitiveByte(String str) {
		return toPrimitiveByte(str, (byte) 0);
	}

	public static byte toPrimitiveByte(String str, byte defaultValue) {
		if (str == null)
			return defaultValue;
		try {
			return Byte.parseByte(str);
		} catch (NumberFormatException nfe) {
		}
		return defaultValue;
	}

	public static double toPrimitiveDouble(Object object) {
		if (object == null) {
			throw new IllegalArgumentException("The object must not be null");
		}
		if ((object instanceof String)) {
			try {
				return Double.parseDouble((String) object);
			} catch (NumberFormatException nfe) {
				throw new NumberFormatException(object
						+ "is not a valid string.");
			}
		}
		if ((object instanceof Number)) {
			return ((Number) object).doubleValue();
		}
		if ((object instanceof Boolean)) {
			if (((Boolean) object).booleanValue()) {
				return 1.0D;
			}
			return 0.0D;
		}
		if (((object instanceof Date)) || ((object instanceof Calendar))) {
			return Double.valueOf(toPrimitiveLong(object)).doubleValue();
		}
		throw new IllegalArgumentException("can to convert type:"
				+ object.getClass().getName() + " to double!");
	}

	public static Double toDouble(Object o) {
		if ((o instanceof Double)) {
			return (Double) o;
		}
		return new Double(toPrimitiveDouble(o));
	}

	public static double toPrimitiveDouble(String str) {
		return toPrimitiveDouble(str, 0.0D);
	}

	public static double toPrimitiveDouble(String str, double defaultValue) {
		if (str == null)
			return defaultValue;
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
		}
		return defaultValue;
	}

	public static float toPrimitiveFloat(Object object) {
		if (object == null) {
			throw new IllegalArgumentException("The object must not be null");
		}
		if ((object instanceof String)) {
			try {
				return Float.parseFloat((String) object);
			} catch (NumberFormatException nfe) {
				throw new NumberFormatException(object
						+ "is not a valid number");
			}
		}
		if ((object instanceof Number)) {
			return ((Number) object).floatValue();
		}
		if ((object instanceof Boolean)) {
			if (((Boolean) object).booleanValue()) {
				return 1.0F;
			}
			return 0.0F;
		}
		if (((object instanceof Date)) || ((object instanceof Calendar))) {
			return Float.valueOf((float) toPrimitiveLong(object)).floatValue();
		}

		throw new IllegalArgumentException("can to convert type:"
				+ object.getClass().getName() + " to float!");
	}

	public static Float toFloat(Object object) {
		if ((object instanceof Float)) {
			return (Float) object;
		}
		return new Float(toPrimitiveFloat(object));
	}

	public static float toPrimitiveFloat(String str) {
		return toPrimitiveFloat(str, 0.0F);
	}

	public static float toPrimitiveFloat(String str, float defaultValue) {
		if (str == null)
			return defaultValue;
		try {
			return Float.parseFloat(str);
		} catch (NumberFormatException nfe) {
		}
		return defaultValue;
	}

	public static int toPrimitiveInt(Object o) {
		if (o == null) {
			throw new IllegalArgumentException("The object must not be null");
		}
		if ((o instanceof String)) {
			try {
				return Integer.parseInt((String) o);
			} catch (NumberFormatException nfe) {
				throw new NumberFormatException(o + "is not a valid string.");
			}
		}
		if ((o instanceof Number)) {
			return ((Number) o).intValue();
		}
		if ((o instanceof Boolean)) {
			if (((Boolean) o).booleanValue()) {
				return 1;
			}
			return 0;
		}
		if (((o instanceof Date)) || ((o instanceof Calendar))) {
			return (int) toPrimitiveLong(o);
		}
		throw new IllegalArgumentException("can to convert type:"
				+ o.getClass().getName() + " to Integer!");
	}

	public static Integer toIngeter(Object o) {
		if ((o instanceof Integer)) {
			return (Integer) o;
		}
		return new Integer(toPrimitiveInt(o));
	}

	public static int toPrimitiveInt(String str) {
		return toPrimitiveInt(str, 0);
	}

	public static int toPrimitiveInt(String str, int defaultValue) {
		if (str == null)
			return defaultValue;
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
		}
		return defaultValue;
	}

	public static Long toLong(Object o) {
		if ((o instanceof Long)) {
			return (Long) o;
		}
		return new Long(toPrimitiveLong(o));
	}

	public static long toPrimitiveLong(Object object) {
		if (object == null) {
			throw new IllegalArgumentException("The parameter object is null!");
		}

		if ((object instanceof Long)) {
			return ((Long) object).longValue();
		}

		if ((object instanceof String)) {
			try {
				return Long.parseLong((String) object);
			} catch (NumberFormatException nfe) {
				throw new NumberFormatException(object
						+ "is not a valid string.");
			}
		}

		if ((object instanceof Number)) {
			return ((Number) object).longValue();
		}

		if ((object instanceof Boolean)) {
			if (((Boolean) object).booleanValue()) {
				return 1L;
			}
			return 0L;
		}

		if ((object instanceof Date)) {
			return ((Date) object).getTime();
		}

		if ((object instanceof Calendar)) {
			return ((Calendar) object).getTimeInMillis();
		}

		throw new IllegalArgumentException("can to convert type:"
				+ object.getClass().getName() + " to long!");
	}

	public static long toPrimitiveLong(String str) {
		return toPrimitiveLong(str, 0L);
	}

	public static long toPrimitiveLong(String str, long defaultValue) {
		if (str == null)
			return defaultValue;
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException nfe) {
		}
		return defaultValue;
	}

	public static short toPrimitiveShort(Object o) {
		if (o == null) {
			throw new IllegalArgumentException("The parameter object is null!");
		}
		if ((o instanceof String)) {
			try {
				return Short.parseShort((String) o);
			} catch (NumberFormatException nfe) {
				throw new NumberFormatException(o + "is not a valid string.");
			}
		}
		if ((o instanceof Number)) {
			return ((Number) o).shortValue();
		}
		if ((o instanceof Boolean)) {
			if (((Boolean) o).booleanValue()) {
				return 1;
			}
			return 0;
		}
		if (((o instanceof Date)) || ((o instanceof Calendar))) {
			return (short) (int) toPrimitiveLong(o);
		}
		throw new IllegalArgumentException("can to convert type:"
				+ o.getClass().getName() + " to short!");
	}

	public static Short toShort(Object o) {
		if ((o instanceof Short)) {
			return (Short) o;
		}
		return new Short(toPrimitiveShort(o));
	}

	public static short toPrimitiveShort(String str) {
		return toPrimitiveShort(str, (byte) 0);
	}

	public static short toPrimitiveShort(String str, short defaultValue) {
		if (str == null)
			return defaultValue;
		try {
			return Short.parseShort(str);
		} catch (NumberFormatException nfe) {
		}
		return defaultValue;
	}

	public static BigDecimal toBigDecimal(Object object) {
		if (object == null) {
			throw new IllegalArgumentException("The parameter object is null.");
		}

		if ((object instanceof BigDecimal)) {
			return (BigDecimal) object;
		}

		if ((object instanceof String)) {
			try {
				return new BigDecimal((String) object);
			} catch (NumberFormatException nfe) {
				throw new NumberFormatException(object
						+ " is not a valid string.");
			}
		}

		if ((object instanceof Number)) {
			try {
				return new BigDecimal(((Number) object).doubleValue());
			} catch (NumberFormatException nfe) {
				throw new NumberFormatException(object
						+ " is not a valid number.");
			}
		}

		if ((object instanceof Boolean)) {
			if (((Boolean) object).booleanValue()) {
				return BigDecimal.ONE;
			}
			return BigDecimal.ZERO;
		}
		if (((object instanceof Date)) || ((object instanceof Calendar))) {
			return new BigDecimal(toPrimitiveLong(object));
		}

		throw new IllegalArgumentException("can to convert type:"
				+ object.getClass().getName() + " to BigDecimal!");
	}

	public static BigInteger toBigInteger(Object object) {
		if (object == null) {
			throw new IllegalArgumentException("The parameter object is null.");
		}
		if ((object instanceof BigInteger)) {
			return (BigInteger) object;
		}

		if ((object instanceof String)) {
			try {
				return new BigInteger((String) object);
			} catch (NumberFormatException nfe) {
				throw new NumberFormatException(object
						+ " is not a valid string.");
			}
		}
		if ((object instanceof Number)) {
			return BigInteger.valueOf(((Number) object).longValue());
		}
		if ((object instanceof Boolean)) {
			if (((Boolean) object).booleanValue()) {
				return BigInteger.ONE;
			}
			return BigInteger.ZERO;
		}
		if (((object instanceof Date)) || ((object instanceof Calendar))) {
			return BigInteger.valueOf(toPrimitiveLong(object));
		}
		throw new IllegalArgumentException("can to convert type:"
				+ object.getClass().getName() + " to BigInteger!");
	}

	public static boolean toPrimitiveBoolean(Object object) {
		if (object == null) {
			throw new IllegalArgumentException("The parameter object is null.");
		}
		if ((object instanceof Boolean)) {
			return ((Boolean) object).booleanValue();
		}
		if ((object instanceof String)) {
			return Boolean.parseBoolean((String) object);
		}
		if ((object instanceof Number)) {
			return 0L != ((Number) object).longValue();
		}
		if (((object instanceof Date)) || ((object instanceof Calendar))) {
			return 0L != toPrimitiveLong(object);
		}
		throw new IllegalArgumentException("can to convert type:"
				+ object.getClass().getName() + " to boolean!");
	}

	public static Boolean toBoolean(Object object) {
		if ((object instanceof Boolean)) {
			return (Boolean) object;
		}
		return new Boolean(toPrimitiveBoolean(object));
	}
}
