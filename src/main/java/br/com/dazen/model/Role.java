package br.com.dazen.model;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.dazen.model.types.Operation;
import br.com.dazen.model.types.Ranking;

/**
 * Classe que representa uma <strong>Regra</strong> de entrada a partir do arquivo fornecido.
 * Essa classe modela os campos e informações sobre uma <strong>Regra</strong> que é
 * fornecida pelo cliente via arquivo de entrada.
 * 
 * @author Charles Queiroz - charles@dazen.com.br | (85) 9933-1585
 * 
 */
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Operation operation;
	private Ranking ranking;
	private BigDecimal aliquot;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public Ranking getRanking() {
		return ranking;
	}

	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}

	public BigDecimal getAliquot() {
		return aliquot;
	}

	public void setAliquot(BigDecimal aliquot) {
		this.aliquot = aliquot;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Role other = (Role) obj;
		if (id == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!id.equals(other.getId())) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", operation=" + operation + ", ranking=" + ranking + ", aliquot=" + aliquot + "]";
	}

}
