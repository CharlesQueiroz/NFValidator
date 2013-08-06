package br.com.dazen.processors;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.util.CsvContext;

import br.com.dazen.model.types.Ranking;

public class ParseRanking extends CellProcessorAdaptor {

	public ParseRanking() {
		super();
	}

	public ParseRanking(CellProcessor next) {
		super(next);
	}

	@Override
	public Object execute(Object value, CsvContext context) {
		validateInputNotNull(value, context);

		for (Ranking ranking : Ranking.values()) {
			if (ranking.name().equalsIgnoreCase(value.toString())) {
				return next.execute(ranking, context);
			} else if (value.toString().equals("*")) {
				return next.execute(Ranking.ANY, context);
			}
		}

		throw new SuperCsvCellProcessorException(String.format("Não pode ser formatado como um Ranking: '%s'", value), context, this);

	}

}
