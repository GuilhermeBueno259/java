package com.softgraf.farmacia.dominio;

public class Cep {
	final public static int MAX = 9;

	public static String formatar(String cep) {
		StringBuilder sb = new StringBuilder();
		cep.trim().chars().forEach(c -> {
			if (c >= '0' && c <= '9') {
				sb.append((char) c);
			}

			if (sb.length() == 5) {
				sb.append('-');
			}
		});

		return (sb.length() == 9) ? sb.toString() : "";
	}
}
