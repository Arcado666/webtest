package com.webtest.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class IDCardUtil {
	public static final Map<String, Integer> areaCode = new HashMap();

	public static String generate() {
		StringBuilder generater = new StringBuilder();
		generater.append(randomAreaCode());
		generater.append(randomBirthday());
		generater.append(randomCode());
		generater.append(calcTrailingNumber(generater.toString().toCharArray()));
		return generater.toString();
	}

	private static int randomAreaCode() {
		int index = (int) (Math.random() * areaCode.size());
		Collection values = areaCode.values();
		Iterator it = values.iterator();
		int i = 0;
		int code = 0;
		while ((i < index) && (it.hasNext())) {
			i++;
			code = ((Integer) it.next()).intValue();
		}
		return code;
	}

	private static String randomBirthday() {
		Calendar birthday = Calendar.getInstance();
		birthday.set(1, (int) (Math.random() * 60.0D) + 1950);
		birthday.set(2, (int) (Math.random() * 12.0D));
		birthday.set(5, (int) (Math.random() * 31.0D));

		StringBuilder builder = new StringBuilder();
		builder.append(birthday.get(1));
		long month = birthday.get(2) + 1;
		if (month < 10L) {
			builder.append("0");
		}
		builder.append(month);
		long date = birthday.get(5);
		if (date < 10L) {
			builder.append("0");
		}
		builder.append(date);
		return builder.toString();
	}

	private static char calcTrailingNumber(char[] chars) {
		if (chars.length < 17) {
			return ' ';
		}
		int[] c = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
		char[] r = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
		int[] n = new int[17];
		int result = 0;
		for (int i = 0; i < n.length; i++) {
			n[i] = Integer.parseInt(new StringBuilder().append(chars[i]).append("").toString());
		}
		for (int i = 0; i < n.length; i++) {
			result += c[i] * n[i];
		}
		return r[(result % 11)];
	}

	private static String randomCode() {
		int code = (int) (Math.random() * 1000.0D);
		if (code < 10)
			return new StringBuilder().append("00").append(code).toString();
		if (code < 100) {
			return new StringBuilder().append("0").append(code).toString();
		}
		return new StringBuilder().append("").append(code).toString();
	}

	static {
		Properties pro = new Properties();
		ClassLoader idClassLoader = IDCardUtil.class.getClassLoader();
		
		try {
			InputStream idInput = idClassLoader.getResourceAsStream("data/id_card_area.properties");
			Throwable localThrowable3 = null;
			try {
				if (idInput == null) {
					throw new RuntimeException("Can not found idCard area data file.");
				}

				pro.load(idInput);

				Iterator localIterator;

				for (localIterator = pro.keySet().iterator(); localIterator.hasNext();) {
					Object key = localIterator.next();

					Integer code = null;
					try {
						code = Integer.valueOf(Integer.parseInt(pro.get(key).toString()));
					} catch (NumberFormatException localNumberFormatException) {
					}
					if (code == null) {
						continue;
					}
					areaCode.put(key.toString(), code);
				}
			} catch (Throwable localThrowable5) {
				localThrowable3 = localThrowable5;

			} finally {
				if (idInput != null)
					if (localThrowable3 != null)
						try {
							idInput.close();
						} catch (Throwable localThrowable2) {
							localThrowable3.addSuppressed(localThrowable2);
						}
					else
						idInput.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}