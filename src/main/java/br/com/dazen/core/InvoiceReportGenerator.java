package br.com.dazen.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.supercsv.cellprocessor.ParseBigDecimal;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import br.com.dazen.exceptions.NotWriterException;
import br.com.dazen.model.InvoiceReport;

public class InvoiceReportGenerator {

	private ICsvBeanWriter writer = null;
	private final List<InvoiceReport> reports;

	private final File file;

	public InvoiceReportGenerator(List<InvoiceReport> reports, File file) {
		this.reports = reports;
		this.file = file;
	}

	public void generateReport() throws NotWriterException {
		try {
			writer = new CsvBeanWriter(new FileWriter(file), CsvPreference.STANDARD_PREFERENCE);
			String[] header = getHeaders();
			CellProcessor[] processors = getProcessors();

			writer.writeHeader(header);

			for (InvoiceReport report : reports) {
				writer.write(report, header, processors);
			}

		} catch (IOException e) {
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
						new UniqueHashCode(new ParseInt()),
						new ParseInt(),
						new NotNull(),
						new ParseBigDecimal(),
						new ParseBigDecimal()
		};
	}

	private String[] getHeaders() {
		return new String[] { "number", "role", "isCorrect" };
	}
}
