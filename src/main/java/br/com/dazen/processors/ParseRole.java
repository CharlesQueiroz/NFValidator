package br.com.dazen.processors;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.util.CsvContext;

import br.com.dazen.model.Role;

/**
 * Classe responsável ṕor realizar o parser de uma Regra para o formato correto esperado
 * pelo sistema.
 * 
 * @author Charles Queiroz - charles@dazen.com.br | (85) 9933-1585
 * 
 */
public class ParseRole extends CellProcessorAdaptor {

	public ParseRole() {
		super();
	}

	public ParseRole(CellProcessor next) {
		super(next);
	}

	@Override
	public Object execute(Object value, CsvContext context) {
		validateInputNotNull(value, context);
		Role role = (Role) value;
		return next.execute(role.getId(), context);
	}

}
