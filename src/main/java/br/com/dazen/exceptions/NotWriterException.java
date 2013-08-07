package br.com.dazen.exceptions;

/**
 * Excessão que representa um erro durante a escrita do arquivo de relatório.
 * 
 * @author Charles Queiroz - charles@dazen.com.br | (85) 9933-1585
 * 
 */
public class NotWriterException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Construtor que cria um <strong>NotWriterException</strong> já com a mensagem de erro a ser exibida.
	 * 
	 * @param message
	 *                A mensagem de erro durante o lançamento da excessão.
	 */
	public NotWriterException(String message) {
		super(message);
	}

}
