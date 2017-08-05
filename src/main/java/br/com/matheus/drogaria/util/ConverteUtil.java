package br.com.matheus.drogaria.util;

public class ConverteUtil {
	public static String sigla(String sigla){
		return sigla.toUpperCase();
	}
	
	public static Integer getId(String codigo){
		return Integer.parseInt(codigo);
	}

}
