package br.com.dazen.core;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.ParseBigDecimal;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import br.com.dazen.exceptions.ParserException;
import br.com.dazen.model.Invoice;
import br.com.dazen.model.InvoiceReport;
import br.com.dazen.model.Role;
import br.com.dazen.model.types.Operation;
import br.com.dazen.model.types.Ranking;
import br.com.dazen.processors.ParseOperation;
import br.com.dazen.processors.ParseRanking;

public class InvoiceReader {

	private ICsvBeanReader invoiceReader;
	private Integer idReport = 0;
	private Invoice invoice;
	private final List<InvoiceReport> reports;

	public InvoiceReader(File fileToParse, List<Role> roles) throws ParserException {
		reports = new ArrayList<>();

		try {
			invoiceReader = new CsvBeanReader(new FileReader(fileToParse.getAbsoluteFile()), CsvPreference.STANDARD_PREFERENCE);
			String[] header = getHeaders();

			CellProcessor[] processors = getProcessors();

			invoiceReader.getHeader(false);

			InvoiceReport report = null;
			while ((invoice = invoiceReader.read(Invoice.class, header, processors)) != null) {
				for (Role role : roles) {
					if (role.getOperation().equals(Operation.ANY) || invoice.getOperation().equals(Operation.ANY) || role.getOperation().equals(invoice.getOperation())) {
						if (invoice.getRanking().equals(Ranking.ANY) || role.getRanking().equals(Ranking.ANY) || role.getRanking().equals(invoice.getRanking())) {
							report = new InvoiceReport();
							report.setNumber(++idReport);
							report.setRole(role);
							report.setCorrect(invoice.getAmountOfInvoicePaid().equals(calculateInvoice(invoice.getAmount(), role.getAliquot())));
							break;
						}
					}
				}
				reports.add(report);
			}

		} catch (IOException e) {
			throw new ParserException(e.getMessage());
		} finally {
			if (invoiceReader != null) {
				try {
					invoiceReader.close();
				} catch (IOException e) {
					throw new ParserException(e.getMessage());
				}
			}
		}
	}

	/**
	 * Método que recupera uma lista de resultados já processados durante a carga das notas fiscais.
	 * A validação dos calculos é feita <strong>DURANTE</strong> a carga do arquivo de Notas Fiscais
	 * visando "poupar tempo."
	 * 
	 * @return Uma lista com os registros que irão compor o arquivo final.
	 */
	public List<InvoiceReport> getReports() {
		return reports;
	}

	private BigDecimal calculateInvoice(BigDecimal amount, BigDecimal aliquot) {
		return amount.multiply(aliquot).divide(new BigDecimal("100.00")).setScale(2, RoundingMode.HALF_UP);
	}

	private CellProcessor[] getProcessors() {
		return new CellProcessor[] {
						new UniqueHashCode(new ParseInt()),
						new ParseOperation(),
						new ParseRanking(),
						new ParseBigDecimal(),
						new ParseBigDecimal()
		};
	}

	private String[] getHeaders() {
		return new String[] { "number", "operation", "ranking", "amount", "amountOfInvoicePaid" };
	}

}
