package br.com.dazen.main;

import java.io.File;
import java.util.List;

import br.com.dazen.core.InvoiceProcessor;
import br.com.dazen.core.InvoiceReportGenerator;
import br.com.dazen.core.RoleReader;
import br.com.dazen.exceptions.NotWriterException;
import br.com.dazen.exceptions.ParserException;
import br.com.dazen.model.Role;

/**
 * Classe principal da aplicação. É por aqui que o processo começa.
 * 
 * @author Charles Queiroz - charles@dazen.com.br | (85) 9933-1585
 * 
 */
public class App {

	private static final File FILE_INVOICES = new File("src/test/resources/Invoices.csv");
	private static final File FILE_ROLES = new File("src/test/resources/Roles.csv");
	private static final File FILE_REPORT = new File("InvoiceReport.txt");

	/**
	 * Método principal da aplicação. É nele que tudo acontece.
	 * 
	 * @param args
	 *                Uma lista de parametros que são fornecidos por linha de comando. Todos estão sendo ignorados.
	 */
	public static void main(String[] args) {
		System.out.println("Executando em modo padão.. ");
		System.out.println("Assumindo locais e arquivos default...");

		List<Role> roles;
		try {
			roles = new RoleReader(FILE_ROLES).getRoles();
			InvoiceProcessor invoiceProcessor = new InvoiceProcessor(FILE_INVOICES, roles);
			InvoiceReportGenerator generator = new InvoiceReportGenerator(invoiceProcessor.getReports(), FILE_REPORT);
			generator.generateReport();
			System.out.println("Arquivo [" + FILE_REPORT.getAbsolutePath() + " ] gerado com sucesso!");
		} catch (ParserException e) {
			System.out.println("Não foi possivel realizar o parser do arquivo.\nMensagem de erro:\n [" + e.getMessage() + "].");
		} catch (NotWriterException e) {
			System.out.println("Não foi possivel gerar o arquivo [ " + FILE_REPORT.getAbsolutePath() + "]. Por favor, verificar a mensagem de erro:\n" + e.getMessage());
			e.printStackTrace();
		}
	}
}
