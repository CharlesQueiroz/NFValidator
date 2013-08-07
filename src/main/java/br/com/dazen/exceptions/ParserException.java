package br.com.dazen.exceptions;

/**
 * Exception que representa o erro quando o sistema não conseguir realizar
 * o parser do arquivo a ser lido.
 * 
 * @author Charles Queiroz - charles@dazen.com.br | (85) 9933-1585
 * 
 */
public class ParserException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Construtor que cria um <strong>ParserException</strong> já com a mensagem de erro a ser exibida.
	 * 
	 * @param message
	 *                A mensagem de erro durante o lançamento da excessão.
	 */
	public ParserException(String message) {
		super(message);
	}

}
