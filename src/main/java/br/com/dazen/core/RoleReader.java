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
import br.com.dazen.model.Role;
import br.com.dazen.processors.ParseOperation;
import br.com.dazen.processors.ParseRanking;

public class RoleReader {

	private ICsvBeanReader roleReader;
	private Role role;
	private final List<Role> roles;

	public RoleReader(File fileToParse) throws ParserException {
		roles = new ArrayList<>();
		try {
			roleReader = new CsvBeanReader(new FileReader(fileToParse.getAbsoluteFile()), CsvPreference.STANDARD_PREFERENCE);
			String[] header = getHeaders();
			CellProcessor[] processors = getProcessors();
			roleReader.getHeader(false);

			while ((role = roleReader.read(Role.class, header, processors)) != null) {
				roles.add(role);
			}
		} catch (IOException e) {
			throw new ParserException(e.getMessage());
		} finally {
			if (roleReader != null) {
				try {
					roleReader.close();
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
	public List<Role> getRoles() {
		return roles;
	}

	private CellProcessor[] getProcessors() {
		return new CellProcessor[] {
						new UniqueHashCode(new ParseInt()),
						new ParseOperation(),
						new ParseRanking(),
						new ParseBigDecimal()
		};
	}

	private String[] getHeaders() {
		return new String[] { "id", "operation", "ranking", "aliquot" };
	}
}
