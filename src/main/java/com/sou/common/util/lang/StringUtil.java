package com.sou.common.util.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class StringUtil {
	public static final String EMPTY = "";
	private static final int PAD_LIMIT = 8192;

	public static String capitalize(String str) {
		int strLen;
		if ((str == null) || ((strLen = str.length()) == 0))
			return str;

		return strLen + Character.toTitleCase(str.charAt(0)) + str.substring(1);
	}

	public static String center(String str, int size) {
		return center(str, size, ' ');
	}

	public static String center(String str, int size, char padChar) {
		if ((str == null) || (size <= 0)) {
			return str;
		}
		int strLen = str.length();
		int pads = size - strLen;
		if (pads <= 0) {
			return str;
		}
		str = leftPad(str, strLen + pads / 2, padChar);
		str = rightPad(str, size, padChar);
		return str;
	}

	public static String center(String str, int size, String padStr) {
		if ((str == null) || (size <= 0)) {
			return str;
		}
		if (isEmpty(padStr)) {
			padStr = " ";
		}
		int strLen = str.length();
		int pads = size - strLen;
		if (pads <= 0) {
			return str;
		}
		str = leftPad(str, strLen + pads / 2, padStr);
		str = rightPad(str, size, padStr);
		return str;
	}

	public static String clean(String str) {
		return str == null ? "" : str.trim();
	}

	public static boolean contains(String str, char searchChar) {
		if (isEmpty(str)) {
			return false;
		}
		return str.indexOf(searchChar) >= 0;
	}

	public static boolean contains(String str, String searchStr) {
		if ((str == null) || (searchStr == null)) {
			return false;
		}
		return str.indexOf(searchStr) >= 0;
	}

	public static boolean containsAny(String str, char[] searchChars) {
		if ((str == null) || (str.length() == 0) || (searchChars == null)
				|| (searchChars.length == 0)) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			for (char searchChar : searchChars) {
				if (searchChar == ch) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean containsAny(String str, String searchChars) {
		if (searchChars == null) {
			return false;
		}
		return containsAny(str, searchChars.toCharArray());
	}

	public static boolean containsIgnoreCase(String str, String searchStr) {
		if ((str == null) || (searchStr == null)) {
			return false;
		}
		int len = searchStr.length();
		int max = str.length() - len;
		for (int i = 0; i <= max; i++) {
			if (str.regionMatches(true, i, searchStr, 0, len)) {
				return true;
			}
		}
		return false;
	}

	public static boolean containsNone(String str, char[] invalidChars) {
		if ((str == null) || (invalidChars == null)) {
			return true;
		}
		int strSize = str.length();
		int validSize = invalidChars.length;
		for (int i = 0; i < strSize; i++) {
			char ch = str.charAt(i);
			for (int j = 0; j < validSize; j++) {
				if (invalidChars[j] == ch) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean containsNone(String str, String invalidStrs) {
		if ((str == null) || (invalidStrs == null)) {
			return true;
		}
		return containsNone(str, invalidStrs.toCharArray());
	}

	public static int countMatches(String str, String sub) {
		if ((isEmpty(str)) || (isEmpty(sub))) {
			return 0;
		}
		int count = 0;
		int idx = 0;
		while ((idx = str.indexOf(sub, idx)) != -1) {
			count++;
			idx += sub.length();
		}
		return count;
	}

	public static String defaultIfEmpty(String str, String defaultStr) {
		return isEmpty(str) ? defaultStr : str;
	}

	public static String defaultString(String str) {
		return str == null ? "" : str;
	}

	public static String defaultString(String str, String defaultStr) {
		return str == null ? defaultStr : str;
	}

	public static String deleteWhitespace(String str) {
		if (isEmpty(str)) {
			return str;
		}
		int sz = str.length();
		char[] chs = new char[sz];
		int count = 0;
		for (int i = 0; i < sz; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				chs[(count++)] = str.charAt(i);
			}
		}
		if (count == sz) {
			return str;
		}
		return new String(chs, 0, count);
	}

	public static String difference(String str1, String str2) {
		if (str1 == null) {
			return str2;
		}
		if (str2 == null) {
			return str1;
		}
		int at = indexOfDifference(str1, str2);
		if (at == -1) {
			return "";
		}
		return str2.substring(at);
	}

	public static boolean endsWith(String str, String suffix) {
		return endsWith(str, suffix, false);
	}

	private static boolean endsWith(String str, String suffix,
			boolean ignoreCase) {
		if ((str == null) || (suffix == null)) {
			return (str == null) && (suffix == null);
		}
		if (suffix.length() > str.length()) {
			return false;
		}
		int strOffset = str.length() - suffix.length();
		return str.regionMatches(ignoreCase, strOffset, suffix, 0,
				suffix.length());
	}

	public static boolean endsWithIgnoreCase(String str, String suffix) {
		return endsWith(str, suffix, true);
	}

	public static boolean equals(String str1, String str2) {
		return str1 == null ? false : str2 == null ? true : str1.equals(str2);
	}

	public static boolean equalsIgnoreCase(String str1, String str2) {
		return str1 == null ? false : str2 == null ? true : str1
				.equalsIgnoreCase(str2);
	}

	public static String getCommonPrefix(String[] strs) {
		if ((strs == null) || (strs.length == 0)) {
			return "";
		}
		int smallestIndexOfDiff = indexOfDifference(strs);
		if (smallestIndexOfDiff == -1) {
			if (strs[0] == null) {
				return "";
			}
			return strs[0];
		}
		if (smallestIndexOfDiff == 0) {
			return "";
		}
		return strs[0].substring(0, smallestIndexOfDiff);
	}

	public static int indexOf(String str, char searchChar) {
		if (isEmpty(str)) {
			return -1;
		}
		return str.indexOf(searchChar);
	}

	public static int indexOf(String str, char searchChar, int startPos) {
		if (isEmpty(str)) {
			return -1;
		}
		return str.indexOf(searchChar, startPos);
	}

	public static int indexOf(String str, String searchStr) {
		if ((str == null) || (searchStr == null)) {
			return -1;
		}
		return str.indexOf(searchStr);
	}

	public static int indexOf(String str, String searchStr, int startPos) {
		if ((str == null) || (searchStr == null)) {
			return -1;
		}
		if ((searchStr.length() == 0) && (startPos >= str.length())) {
			return str.length();
		}
		return str.indexOf(searchStr, startPos);
	}

	public static int indexOfAny(String str, char[] searchChars) {
		if ((isEmpty(str)) || (ArrayUtil.isEmpty(searchChars))) {
			return -1;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			for (char searchChar : searchChars) {
				if (searchChar == ch) {
					return i;
				}
			}
		}
		return -1;
	}

	public static int indexOfAny(String str, String searchChars) {
		if ((isEmpty(str)) || (isEmpty(searchChars))) {
			return -1;
		}
		return indexOfAny(str, searchChars.toCharArray());
	}

	public static int indexOfDifference(String str1, String str2) {
		if (str1 == str2) {
			return -1;
		}
		if ((str1 == null) || (str2 == null)) {
			return 0;
		}

		for (int i = 0; (i < str1.length()) && (i < str2.length()); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				break;
			}
			if ((i < str2.length()) || (i < str1.length())) {
				return i;
			}
		}

		return -1;
	}

	public static int indexOfDifference(String[] strs) {
		if ((strs == null) || (strs.length <= 1)) {
			return -1;
		}
		boolean anyStringNull = false;
		boolean allStringsNull = true;
		int arrayLen = strs.length;
		int shortestStrLen = 2147483647;
		int longestStrLen = 0;
		for (int i = 0; i < arrayLen; i++) {
			if (strs[i] == null) {
				anyStringNull = true;
				shortestStrLen = 0;
			} else {
				allStringsNull = false;
				shortestStrLen = Math.min(strs[i].length(), shortestStrLen);
				longestStrLen = Math.max(strs[i].length(), longestStrLen);
			}
		}

		if ((allStringsNull) || ((longestStrLen == 0) && (!anyStringNull))) {
			return -1;
		}

		if (shortestStrLen == 0) {
			return 0;
		}

		int firstDiff = -1;
		for (int stringPos = 0; stringPos < shortestStrLen; stringPos++) {
			char comparisonChar = strs[0].charAt(stringPos);
			for (int arrayPos = 1; arrayPos < arrayLen; arrayPos++) {
				if (strs[arrayPos].charAt(stringPos) != comparisonChar) {
					firstDiff = stringPos;
					break;
				}
			}
			if (firstDiff != -1) {
				break;
			}
		}
		if ((firstDiff == -1) && (shortestStrLen != longestStrLen)) {
			return shortestStrLen;
		}
		return firstDiff;
	}

	public static boolean isAllLowerCase(String str) {
		if ((str == null) || (isEmpty(str))) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isLowerCase(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAllUpperCase(String str) {
		if ((str == null) || (isEmpty(str))) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isUpperCase(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAlpha(String str) {
		if (str == null) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isLetter(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAlphanumeric(String str) {
		if (str == null) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isLetterOrDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAlphanumericSpace(String str) {
		if (str == null) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if ((!Character.isLetterOrDigit(str.charAt(i)))
					&& (str.charAt(i) != ' ')) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAlphaSpace(String str) {
		if (str == null) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if ((!Character.isLetter(str.charAt(i))) && (str.charAt(i) != ' ')) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAsciiPrintable(String str) {
		if (str == null) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if (!CharUtil.isAsciiPrintable(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isBlank(String str) {
		int strLen;
		if ((str == null) || ((strLen = str.length()) == 0))
			return true;

		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEmpty(String str) {
		return (str == null) || (str.length() == 0);
	}

	public static boolean isNumeric(String str) {
		if (str == null) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNumericSpace(String str) {
		if (str == null) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if ((!Character.isDigit(str.charAt(i))) && (str.charAt(i) != ' ')) {
				return false;
			}
		}
		return true;
	}

	public static boolean isWhitespace(String str) {
		if (str == null) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static String join(Collection collection, char separator) {
		if (collection == null) {
			return null;
		}
		return join(collection.iterator(), separator);
	}

	public static String join(Collection collection, String separator) {
		if (collection == null) {
			return null;
		}
		return join(collection.iterator(), separator);
	}

	public static String join(Iterator iterator, char separator) {
		if (iterator == null) {
			return null;
		}
		if (!iterator.hasNext()) {
			return "";
		}
		Object first = iterator.next();
		if (!iterator.hasNext()) {
			return ObjectUtil.toString(first);
		}

		StringBuffer buf = new StringBuffer(256);
		if (first != null) {
			buf.append(first);
		}

		while (iterator.hasNext()) {
			buf.append(separator);
			Object obj = iterator.next();
			if (obj != null) {
				buf.append(obj);
			}
		}

		return buf.toString();
	}

	public static String join(Iterator iterator, String separator) {
		if (iterator == null) {
			return null;
		}
		if (!iterator.hasNext()) {
			return "";
		}
		Object first = iterator.next();
		if (!iterator.hasNext()) {
			return ObjectUtil.toString(first);
		}

		StringBuffer buf = new StringBuffer(256);
		if (first != null) {
			buf.append(first);
		}

		while (iterator.hasNext()) {
			if (separator != null) {
				buf.append(separator);
			}
			Object obj = iterator.next();
			if (obj != null) {
				buf.append(obj);
			}
		}
		return buf.toString();
	}

	public static String join(Object[] array) {
		return join(array, null);
	}

	public static String join(Object[] array, char separator) {
		if (array == null) {
			return null;
		}

		return join(array, separator, 0, array.length);
	}

	public static String join(Object[] array, char separator, int startIndex,
			int endIndex) {
		if (array == null) {
			return null;
		}
		int bufSize = endIndex - startIndex;
		if (bufSize <= 0) {
			return "";
		}

		bufSize = bufSize
				* ((array[startIndex] == null ? 16 : array[startIndex]
						.toString().length()) + 1);
		StringBuffer buf = new StringBuffer(bufSize);

		for (int i = startIndex; i < endIndex; i++) {
			if (i > startIndex) {
				buf.append(separator);
			}
			if (array[i] != null) {
				buf.append(array[i]);
			}
		}
		return buf.toString();
	}

	public static String join(Object[] array, String separator) {
		if (array == null) {
			return null;
		}
		return join(array, separator, 0, array.length);
	}

	public static String join(Object[] array, String separator, int startIndex,
			int endIndex) {
		if (array == null) {
			return null;
		}
		if (separator == null) {
			separator = "";
		}
		int bufSize = endIndex - startIndex;
		if (bufSize <= 0) {
			return "";
		}

		bufSize = bufSize
				* ((array[startIndex] == null ? 16 : array[startIndex]
						.toString().length()) + separator.length());

		StringBuffer buf = new StringBuffer(bufSize);

		for (int i = startIndex; i < endIndex; i++) {
			if (i > startIndex) {
				buf.append(separator);
			}
			if (array[i] != null) {
				buf.append(array[i]);
			}
		}
		return buf.toString();
	}

	public static int lastIndexOf(String str, char searchChar) {
		if (isEmpty(str)) {
			return -1;
		}
		return str.lastIndexOf(searchChar);
	}

	public static int lastIndexOf(String str, char searchChar, int startPos) {
		if (isEmpty(str)) {
			return -1;
		}
		return str.lastIndexOf(searchChar, startPos);
	}

	public static int lastIndexOf(String str, String searchStr) {
		if ((str == null) || (searchStr == null)) {
			return -1;
		}
		return str.lastIndexOf(searchStr);
	}

	public static int lastIndexOf(String str, String searchStr, int startPos) {
		if ((str == null) || (searchStr == null)) {
			return -1;
		}
		return str.lastIndexOf(searchStr, startPos);
	}

	public static int lastIndexOfIgnoreCase(String str, String searchStr) {
		if ((str == null) || (searchStr == null)) {
			return -1;
		}
		return lastIndexOfIgnoreCase(str, searchStr, str.length());
	}

	public static int lastIndexOfIgnoreCase(String str, String searchStr,
			int startPos) {
		if ((str == null) || (searchStr == null)) {
			return -1;
		}
		if (startPos > str.length() - searchStr.length()) {
			startPos = str.length() - searchStr.length();
		}
		if (startPos < 0) {
			return -1;
		}
		if (searchStr.length() == 0) {
			return startPos;
		}

		for (int i = startPos; i >= 0; i--) {
			if (str.regionMatches(true, i, searchStr, 0, searchStr.length())) {
				return i;
			}
		}
		return -1;
	}

	public static String left(String str, int len) {
		if (str == null) {
			return null;
		}
		if (len < 0) {
			return "";
		}
		if (str.length() <= len) {
			return str;
		}
		return str.substring(0, len);
	}

	public static String leftPad(String str, int size) {
		return leftPad(str, size, ' ');
	}

	public static String leftPad(String str, int size, char padChar) {
		if (str == null) {
			return null;
		}
		int pads = size - str.length();
		if (pads <= 0) {
			return str;
		}
		if (pads > 8192) {
			return leftPad(str, size, String.valueOf(padChar));
		}
		return padding(pads, padChar).concat(str);
	}

	public static String leftPad(String str, int size, String padStr) {
		if (str == null) {
			return null;
		}
		if (isEmpty(padStr)) {
			padStr = " ";
		}
		int padLen = padStr.length();
		int strLen = str.length();
		int pads = size - strLen;
		if (pads <= 0) {
			return str;
		}
		if ((padLen == 1) && (pads <= 8192)) {
			return leftPad(str, size, padStr.charAt(0));
		}

		if (pads == padLen)
			return padStr.concat(str);
		if (pads < padLen) {
			return padStr.substring(0, pads).concat(str);
		}
		char[] padding = new char[pads];
		char[] padChars = padStr.toCharArray();
		for (int i = 0; i < pads; i++) {
			padding[i] = padChars[(i % padLen)];
		}
		return new String(padding).concat(str);
	}

	public static int length(String str) {
		return str == null ? 0 : str.length();
	}

	public static String lowerCase(String str) {
		if (str == null) {
			return null;
		}
		return str.toLowerCase();
	}

	public static String lowerCase(String str, Locale locale) {
		if (str == null) {
			return null;
		}
		return str.toLowerCase(locale);
	}

	public static String mid(String str, int pos, int len) {
		if (str == null) {
			return null;
		}
		if ((len < 0) || (pos > str.length())) {
			return "";
		}
		if (pos < 0) {
			pos = 0;
		}
		if (str.length() <= pos + len) {
			return str.substring(pos);
		}
		return str.substring(pos, pos + len);
	}

	public static String overlay(String str, String overlay, int start, int end) {
		if (str == null) {
			return null;
		}
		if (overlay == null) {
			overlay = "";
		}
		int len = str.length();
		if (start < 0) {
			start = 0;
		}
		if (start > len) {
			start = len;
		}
		if (end < 0) {
			end = 0;
		}
		if (end > len) {
			end = len;
		}
		if (start > end) {
			int temp = start;
			start = end;
			end = temp;
		}
		return len + start - end + overlay.length() + 1
				+ str.substring(0, start) + overlay + str.substring(end);
	}

	private static String padding(int repeat, char padChar)
			throws IndexOutOfBoundsException {
		if (repeat < 0) {
			throw new IndexOutOfBoundsException(
					"Cannot pad a negative amount: " + repeat);
		}
		char[] buf = new char[repeat];
		for (int i = 0; i < buf.length; i++) {
			buf[i] = padChar;
		}
		return new String(buf);
	}

	public static String remove(String str, char remove) {
		if ((isEmpty(str)) || (str.indexOf(remove) == -1)) {
			return str;
		}
		char[] chars = str.toCharArray();
		int pos = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != remove) {
				chars[(pos++)] = chars[i];
			}
		}
		return new String(chars, 0, pos);
	}

	public static String remove(String str, String remove) {
		if ((isEmpty(str)) || (isEmpty(remove))) {
			return str;
		}
		return replace(str, remove, "", -1);
	}

	public static String removeEnd(String str, String remove) {
		if ((isEmpty(str)) || (isEmpty(remove))) {
			return str;
		}
		if (str.endsWith(remove)) {
			return str.substring(0, str.length() - remove.length());
		}
		return str;
	}

	public static String removeEndIgnoreCase(String str, String remove) {
		if ((isEmpty(str)) || (isEmpty(remove))) {
			return str;
		}
		if (endsWithIgnoreCase(str, remove)) {
			return str.substring(0, str.length() - remove.length());
		}
		return str;
	}

	public static String removeStart(String str, String remove) {
		if ((isEmpty(str)) || (isEmpty(remove))) {
			return str;
		}
		if (str.startsWith(remove)) {
			return str.substring(remove.length());
		}
		return str;
	}

	public static String removeStartIgnoreCase(String str, String remove) {
		if ((isEmpty(str)) || (isEmpty(remove))) {
			return str;
		}
		if (startsWithIgnoreCase(str, remove)) {
			return str.substring(remove.length());
		}
		return str;
	}

	public static String repeat(String str, int repeat) {
		if (str == null) {
			return null;
		}
		if (repeat <= 0) {
			return "";
		}
		int inputLength = str.length();
		if ((repeat == 1) || (inputLength == 0)) {
			return str;
		}
		if ((inputLength == 1) && (repeat <= 8192)) {
			return padding(repeat, str.charAt(0));
		}

		int outputLength = inputLength * repeat;
		switch (inputLength) {
		case 1:
			char ch = str.charAt(0);
			char[] output1 = new char[outputLength];
			for (int i = repeat - 1; i >= 0; i--) {
				output1[i] = ch;
			}
			return new String(output1);
		case 2:
			char ch0 = str.charAt(0);
			char ch1 = str.charAt(1);
			char[] output2 = new char[outputLength];
			for (int i = repeat * 2 - 2; i >= 0; i--) {
				output2[i] = ch0;
				output2[(i + 1)] = ch1;

				i--;
			}

			return new String(output2);
		}
		StringBuffer buf = new StringBuffer(outputLength);
		for (int i = 0; i < repeat; i++) {
			buf.append(str);
		}
		return buf.toString();
	}

	public static String repeat(String str, String separator, int repeat) {
		if ((str == null) || (separator == null)) {
			return repeat(str, repeat);
		}
		String result = repeat(str + separator, repeat);
		return removeEnd(result, separator);
	}

	public static String replace(String text, String searchString,
			String replacement) {
		return replace(text, searchString, replacement, -1);
	}

	public static String replace(String text, String searchString,
			String replacement, int max) {
		if ((isEmpty(text)) || (isEmpty(searchString)) || (replacement == null)
				|| (max == 0)) {
			return text;
		}
		int start = 0;
		int end = text.indexOf(searchString, start);
		if (end == -1) {
			return text;
		}
		int replLength = searchString.length();
		int increase = replacement.length() - replLength;
		increase = increase < 0 ? 0 : increase;
		increase *= (max > 64 ? 64 : max < 0 ? 16 : max);
		StringBuffer buf = new StringBuffer(text.length() + increase);
		while (end != -1) {
			buf.append(text.substring(start, end)).append(replacement);
			start = end + replLength;
			max--;
			if (max == 0) {
				break;
			}
			end = text.indexOf(searchString, start);
		}
		buf.append(text.substring(start));
		return buf.toString();
	}

	public static String replaceChars(String str, char searchChar,
			char replaceChar) {
		if (str == null) {
			return null;
		}
		return str.replace(searchChar, replaceChar);
	}

	public static String replaceOnce(String text, String searchString,
			String replacement) {
		return replace(text, searchString, replacement, 1);
	}

	public static String reverse(String str) {
		if (str == null) {
			return null;
		}
		return new StringBuffer(str).reverse().toString();
	}

	public static String right(String str, int len) {
		if (str == null) {
			return null;
		}
		if (len < 0) {
			return "";
		}
		if (str.length() <= len) {
			return str;
		}
		return str.substring(str.length() - len);
	}

	public static String rightPad(String str, int size) {
		return rightPad(str, size, ' ');
	}

	public static String rightPad(String str, int size, char padChar) {
		if (str == null) {
			return null;
		}
		int pads = size - str.length();
		if (pads <= 0) {
			return str;
		}
		if (pads > 8192) {
			return rightPad(str, size, String.valueOf(padChar));
		}
		return str.concat(padding(pads, padChar));
	}

	public static String rightPad(String str, int size, String padStr) {
		if (str == null) {
			return null;
		}
		if (isEmpty(padStr)) {
			padStr = " ";
		}
		int padLen = padStr.length();
		int strLen = str.length();
		int pads = size - strLen;
		if (pads <= 0) {
			return str;
		}
		if ((padLen == 1) && (pads <= 8192)) {
			return rightPad(str, size, padStr.charAt(0));
		}
		if (pads == padLen)
			return str.concat(padStr);
		if (pads < padLen) {
			return str.concat(padStr.substring(0, pads));
		}
		char[] padding = new char[pads];
		char[] padChars = padStr.toCharArray();
		for (int i = 0; i < pads; i++) {
			padding[i] = padChars[(i % padLen)];
		}
		return str.concat(new String(padding));
	}

	public static String[] split(String str) {
		return split(str, null, -1);
	}

	public static String[] split(String str, char separatorChar) {
		return splitWorker(str, separatorChar, false);
	}

	public static String[] split(String str, String separatorChars) {
		return splitWorker(str, separatorChars, -1, false);
	}

	public static String[] split(String str, String separatorChars, int max) {
		return splitWorker(str, separatorChars, max, false);
	}

	private static String[] splitWorker(String str, char separatorChar,
			boolean preserveAllTokens) {
		if (str == null) {
			return null;
		}
		int len = str.length();
		if (len == 0) {
			return ArrayUtil.EMPTY_STRING_ARRAY;
		}
		List list = new ArrayList();
		int i = 0;
		int start = 0;
		boolean match = false;
		boolean lastMatch = false;
		while (i < len)
			if (str.charAt(i) == separatorChar) {
				if ((match) || (preserveAllTokens)) {
					list.add(str.substring(start, i));
					match = false;
					lastMatch = true;
				}
				i++;
				start = i;
			} else {
				lastMatch = false;
				match = true;
				i++;
			}
		if ((match) || ((preserveAllTokens) && (lastMatch))) {
			list.add(str.substring(start, i));
		}
		return (String[]) list.toArray(new String[list.size()]);
	}

	private static String[] splitWorker(String str, String separatorChars,
			int max, boolean preserveAllTokens) {
		if (str == null) {
			return null;
		}
		int len = str.length();
		if (len == 0) {
			return ArrayUtil.EMPTY_STRING_ARRAY;
		}
		List list = new ArrayList();
		int sizePlus1 = 1;
		int i = 0;
		int start = 0;
		boolean match = false;
		boolean lastMatch = false;
		if (separatorChars == null) {
			while (i < len)
				if (Character.isWhitespace(str.charAt(i))) {
					if ((match) || (preserveAllTokens)) {
						lastMatch = true;
						if (sizePlus1++ == max) {
							i = len;
							lastMatch = false;
						}
						list.add(str.substring(start, i));
						match = false;
					}
					i++;
					start = i;
				} else {
					lastMatch = false;
					match = true;
					i++;
				}
		} else if (separatorChars.length() == 1) {
			char sep = separatorChars.charAt(0);
			while (i < len)
				if (str.charAt(i) == sep) {
					if ((match) || (preserveAllTokens)) {
						lastMatch = true;
						if (sizePlus1++ == max) {
							i = len;
							lastMatch = false;
						}
						list.add(str.substring(start, i));
						match = false;
					}
					i++;
					start = i;
				} else {
					lastMatch = false;
					match = true;
					i++;
				}
		} else {
			do
				if (separatorChars.indexOf(str.charAt(i)) >= 0) {
					if ((match) || (preserveAllTokens)) {
						lastMatch = true;
						if (sizePlus1++ == max) {
							i = len;
							lastMatch = false;
						}
						list.add(str.substring(start, i));
						match = false;
					}
					i++;
					start = i;
				} else {
					lastMatch = false;
					match = true;
					i++;
				}
			while (i < len);
		}

		if ((match) || ((preserveAllTokens) && (lastMatch))) {
			list.add(str.substring(start, i));
		}
		return (String[]) list.toArray(new String[list.size()]);
	}

	public static boolean startsWith(String str, String prefix) {
		return startsWith(str, prefix, false);
	}

	private static boolean startsWith(String str, String prefix,
			boolean ignoreCase) {
		if ((str == null) || (prefix == null)) {
			return (str == null) && (prefix == null);
		}
		if (prefix.length() > str.length()) {
			return false;
		}
		return str.regionMatches(ignoreCase, 0, prefix, 0, prefix.length());
	}

	public static boolean startsWithAny(String string, String[] searchStrings) {
		if ((isEmpty(string)) || (ArrayUtil.isEmpty(searchStrings))) {
			return false;
		}
		for (String searchString : searchStrings) {
			if (startsWith(string, searchString)) {
				return true;
			}
		}
		return false;
	}

	public static boolean startsWithIgnoreCase(String str, String prefix) {
		return startsWith(str, prefix, true);
	}

	public static String strip(String str) {
		return strip(str, null);
	}

	public static String strip(String str, String stripChars) {
		if (isEmpty(str)) {
			return str;
		}
		str = stripStart(str, stripChars);
		return stripEnd(str, stripChars);
	}

	public static String[] stripAll(String[] strs) {
		return stripAll(strs, null);
	}

	protected static String[] stripAll(String[] strs, String stripChars) {
		int strsLen;
		if ((strs == null) || ((strsLen = strs.length) == 0))
			return strs;

		String[] newArr = new String[strsLen];
		for (int i = 0; i < strsLen; i++) {
			newArr[i] = strip(strs[i], stripChars);
		}
		return newArr;
	}

	public static String stripEnd(String str, String stripChars) {
		int end;
		if ((str == null) || ((end = str.length()) == 0))
			return str;

		if (stripChars == null) {
			do {
				end--;

				if (end == 0)
					break;
			} while (Character.isWhitespace(str.charAt(end - 1)));
		} else {
			if (stripChars.length() == 0) {
				return str;
			}
			do {
				end--;
			} while ((end != 0)
					&& (stripChars.indexOf(str.charAt(end - 1)) != -1));
		}

		return str.substring(0, end);
	}

	public static String stripStart(String str, String stripChars) {
		int strLen;
		if ((str == null) || ((strLen = str.length()) == 0))
			return str;

		int start = 0;
		if (stripChars == null) {
			do {
				start++;

				if (start == strLen)
					break;
			} while (Character.isWhitespace(str.charAt(start)));
		} else {
			if (stripChars.length() == 0) {
				return str;
			}
			do {
				start++;
			} while ((start != strLen)
					&& (stripChars.indexOf(str.charAt(start)) != -1));
		}

		return str.substring(start);
	}

	public static String stripToEmpty(String str) {
		return str == null ? "" : strip(str, null);
	}

	public static String stripToNull(String str) {
		if (str == null) {
			return null;
		}
		str = strip(str, null);
		return str.length() == 0 ? null : str;
	}

	public static String substring(String str, int start) {
		if (str == null) {
			return null;
		}
		if (start < 0) {
			start = str.length() + start;
		}
		if (start < 0) {
			start = 0;
		}
		if (start > str.length()) {
			return "";
		}
		return str.substring(start);
	}

	public static String substring(String str, int start, int end) {
		if (str == null) {
			return null;
		}
		if (end < 0) {
			end = str.length() + end;
		}
		if (start < 0) {
			start = str.length() + start;
		}
		if (end > str.length()) {
			end = str.length();
		}
		if (start > end) {
			return "";
		}
		if (start < 0) {
			start = 0;
		}
		if (end < 0) {
			end = 0;
		}
		return str.substring(start, end);
	}

	public static String substringAfter(String str, String separator) {
		if (isEmpty(str)) {
			return str;
		}
		if (separator == null) {
			return "";
		}
		int pos = str.indexOf(separator);
		if (pos == -1) {
			return "";
		}
		return str.substring(pos + separator.length());
	}

	public static String substringAfterLast(String str, String separator) {
		if (isEmpty(str)) {
			return str;
		}
		if (isEmpty(separator)) {
			return "";
		}
		int pos = str.lastIndexOf(separator);
		if ((pos == -1) || (pos == str.length() - separator.length())) {
			return "";
		}
		return str.substring(pos + separator.length());
	}

	public static String substringBefore(String str, String separator) {
		if ((isEmpty(str)) || (separator == null)) {
			return str;
		}
		if (separator.length() == 0) {
			return "";
		}
		int pos = str.indexOf(separator);
		if (pos == -1) {
			return str;
		}
		return str.substring(0, pos);
	}

	public static String substringBeforeLast(String str, String separator) {
		if ((isEmpty(str)) || (isEmpty(separator))) {
			return str;
		}
		int pos = str.lastIndexOf(separator);
		if (pos == -1) {
			return str;
		}
		return str.substring(0, pos);
	}

	public static String substringBetween(String str, String tag) {
		return substringBetween(str, tag, tag);
	}

	public static String substringBetween(String str, String open, String close) {
		if ((str == null) || (open == null) || (close == null)) {
			return null;
		}
		int start = str.indexOf(open);
		if (start != -1) {
			int end = str.indexOf(close, start + open.length());
			if (end != -1) {
				return str.substring(start + open.length(), end);
			}
		}
		return null;
	}

	public static String swapCase(String str) {
		int strLen;
		if ((str == null) || ((strLen = str.length()) == 0))
			return str;

		StringBuffer buffer = new StringBuffer(strLen);

		char ch = '\000';
		for (int i = 0; i < strLen; i++) {
			ch = str.charAt(i);
			if (Character.isUpperCase(ch))
				ch = Character.toLowerCase(ch);
			else if (Character.isTitleCase(ch))
				ch = Character.toLowerCase(ch);
			else if (Character.isLowerCase(ch)) {
				ch = Character.toUpperCase(ch);
			}
			buffer.append(ch);
		}
		return buffer.toString();
	}

	public static String trim(String str) {
		return str == null ? null : str.trim();
	}

	public static String trimToEmpty(String str) {
		return str == null ? "" : str.trim();
	}

	public static String trimToNull(String str) {
		String ts = trim(str);
		return isEmpty(ts) ? null : ts;
	}

	public static String uncapitalize(String str) {
		int strLen;
		if ((str == null) || ((strLen = str.length()) == 0))
			return str;

		return strLen + Character.toLowerCase(str.charAt(0)) + str.substring(1);
	}

	public static String upperCase(String str) {
		if (str == null) {
			return null;
		}
		return str.toUpperCase();
	}

	public static String upperCase(String str, Locale locale) {
		if (str == null) {
			return null;
		}
		return str.toUpperCase(locale);
	}
}
