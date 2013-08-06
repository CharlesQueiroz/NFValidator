package br.com.dazen.core;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
import br.com.dazen.processors.ParseOperation;
import br.com.dazen.processors.ParseRanking;

public class InvoiceReader {

	private ICsvBeanReader invoiceReader;

	private Invoice invoice;
	private final List<Invoice> invoices;

	public InvoiceReader(File fileToParse) throws ParserException {
		invoices = new ArrayList<>();

		try {
			invoiceReader = new CsvBeanReader(new FileReader(fileToParse.getAbsoluteFile()), CsvPreference.STANDARD_PREFERENCE);
			String[] header = getHeaders();

			CellProcessor[] processors = getProcessors();

			invoiceReader.getHeader(false);

			while ((invoice = invoiceReader.read(Invoice.class, header, processors)) != null) {
				invoices.add(invoice);
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
	 * Método que recupera todas as Regras definidas no arquivo.
	 * 
	 * @return Uma lista com todas as regras recuperadas do arquivo informado.
	 */
	public List<Invoice> getInvoices() {
		return invoices;
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
