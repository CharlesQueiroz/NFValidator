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

	/**
	 * Recupera o valor do ID da regra.
	 * 
	 * @return O valor do ID da regra.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Altera o valor do ID da Regra.
	 * 
	 * @param id
	 *                O novo valor para o ID da Regra.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Recupera o valor da Operação da Regra.
	 * 
	 * @return O valor da Operação da Regra.
	 */
	public Operation getOperation() {
		return operation;
	}

	/**
	 * Altera o valor da Operação para a Regra.
	 * 
	 * @param operation
	 *                O novo valor para a operação da Regra.
	 */
	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	/**
	 * Recupera o valor da classificação da Regra.
	 * 
	 * @return O valor da classificação da Regra.
	 */
	public Ranking getRanking() {
		return ranking;
	}

	/**
	 * Altera o valor da classificação da Regra.
	 * 
	 * @param ranking
	 *                O novo valor para a classificação da Regra.
	 */
	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}

	/**
	 * Recupera o valor da Aliquota da Regra.
	 * 
	 * @return O valor da Aliquota da Regra.
	 */
	public BigDecimal getAliquot() {
		return aliquot;
	}

	/**
	 * Altera o valor da Aliquota da Regra.
	 * 
	 * @param aliquot
	 *                O novo valor para a Aliquota da Regra.
	 */
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
