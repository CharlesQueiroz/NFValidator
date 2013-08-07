package br.com.dazen.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.supercsv.cellprocessor.FmtBool;
import org.supercsv.cellprocessor.FmtNumber;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import br.com.dazen.exceptions.NotWriterException;
import br.com.dazen.model.InvoiceReport;
import br.com.dazen.processors.ParseRole;

/**
 * Classe responsável por gerar o relatório final com os dados já processados.
 * 
 * @author Charles Queiroz - charles@dazen.com.br | (85) 9933-1585
 * 
 */
public class InvoiceReportGenerator {

	private ICsvBeanWriter writer = null;
	private final List<InvoiceReport> reports;

	private final File file;

	/**
	 * Construtor que cria um <strong>InvoiceReportGenerator</strong> já com todas as suas dependencias.
	 * 
	 * @param reports
	 *                A lista de registros que irão compor o relatório final. Cada item da lista,
	 *                corresponde a uma linha do relatório.
	 * @param file
	 *                O arquivo no qual serão gravados os registros do relatório. Ou seja, é o relatório em si.
	 */
	public InvoiceReportGenerator(List<InvoiceReport> reports, File file) {
		this.reports = reports;
		this.file = file;
	}

	/**
	 * Método que de fato <strong>Gera</strong> o arquivo fisico do relatório.
	 * 
	 * @throws NotWriterException
	 *                 Caso o sistema não consiga gerar o arquivo.
	 */
	public void generateReport() throws NotWriterException {
		try {
			writer = new CsvBeanWriter(new FileWriter(file), CsvPreference.STANDARD_PREFERENCE);
			String[] header = getHeaders();
			CellProcessor[] processors = getProcessors();

			writer.writeHeader(new String[] { "NUMERO", "REGRA", "CORRETO" });

			for (InvoiceReport report : reports) {
				writer.write(report, header, processors);
			}

		} catch (Exception e) {
			throw new NotWriterException(e.getMessage());
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					throw new NotWriterException(e.getMessage());
				}
			}
		}
	}

	private CellProcessor[] getProcessors() {
		return new CellProcessor[] {
						new UniqueHashCode(new FmtNumber("000")),
						new ParseRole(),
						new FmtBool("S", "N")
		};
	}

	private String[] getHeaders() {
		return new String[] { "number", "role", "isCorrect" };
	}
}
