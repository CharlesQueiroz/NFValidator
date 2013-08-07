package br.com.dazen.processors;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.util.CsvContext;

import br.com.dazen.model.types.Operation;

/**
 * Classe responsável ṕor realizar o parser de uma Operação para o formato correto esperado
 * pelo sistema.
 * 
 * @author Charles Queiroz - charles@dazen.com.br | (85) 9933-1585
 * 
 */
public class ParseOperation extends CellProcessorAdaptor {

	public ParseOperation() {
		super();
	}

	public ParseOperation(CellProcessor next) {
		super(next);
	}

	@Override
	public Object execute(Object value, CsvContext context) {
		validateInputNotNull(value, context);

		for (Operation operation : Operation.values()) {
			if (operation.name().equalsIgnoreCase(value.toString())) {
				return next.execute(operation, context);
			} else if (value.toString().equals("*")) {
				return next.execute(Operation.ANY, context);
			}
		}

		throw new SuperCsvCellProcessorException(String.format("Não pode ser formatado como uma Operação: '%s'", value), context, this);

	}

}
