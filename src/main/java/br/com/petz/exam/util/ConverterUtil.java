package br.com.petz.exam.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class ConverterUtil {
	
	private static final String PATTERN_PADRAO = "dd/MM/yyyy";
	private static final String PATTERN_ISO_DATE = "yyyy-MM-dd";
	private static final String PATTERN_ISO_DATETIME = "yyyy-MM-dd HH:mm:ss";
	
	private static SimpleDateFormat dateFormat;
	
	static {
		dateFormat = new SimpleDateFormat(PATTERN_PADRAO);
	}
	
	public static String replaceNotNumericos(String field) {
		if (field == null) {
			return null;
		}
		return field.replaceAll("[^0-9]", "");
	}
	
	public static String toIsoDateTime(LocalDateTime datetime) {
		return datetime.format(DateTimeFormatter.ofPattern(PATTERN_ISO_DATETIME));
	}
	
	public static String toIsoDate(LocalDateTime datetime) {
		
		return datetime.format(DateTimeFormatter.ofPattern(PATTERN_ISO_DATE));
	}
	
	public static Date converteData(String data) throws ParseException {
		if(data == null) {
			return null;
		}
		return dateFormat.parse(data);
	}
	
	public static String converteCpf(Long cpf) {
		if (cpf != null) {
			return StringUtils.leftPad(String.valueOf(cpf), 11, "0");
		} else {
			return null;
		}
	}

	public static String converteCnpj(Long cnpj) {
		if (cnpj != null) {
			return StringUtils.leftPad(String.valueOf(cnpj), 14, "0");
		} else {
			return null;
		}
	}


}
