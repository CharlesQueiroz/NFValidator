package br.com.dazen.exceptions;

/**
 * Exception que representa o erro quando o sistema não conseguir realizar
 * o parser do arquivo a ser lido.
 * 
 * @author Charles Queiroz - charles@dazen.com.br | (85) 9933-1585
 * 
 */
public class ParserException extends Exception {

	public ParserException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
