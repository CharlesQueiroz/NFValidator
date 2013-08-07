package br.com.dazen.model;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.dazen.model.types.Operation;
import br.com.dazen.model.types.Ranking;

/**
 * Classe que representa uma Nota Fiscal de entrada a partir do arquivo fornecido.
 * Essa classe modela os campos e informações sobre uma Nota Fiscal que é
 * fornecida pelo cliente via arquivo de entrada.
 * 
 * @author Charles Queiroz - charles@dazen.com.br | (85) 9933-1585
 * 
 */
public class Invoice implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer number;
	private Operation operation;
	private Ranking ranking;
	private BigDecimal amount;
	private BigDecimal amountOfInvoicePaid;

	/**
	 * Recupera o valor do número da Nota Fiscal.
	 * 
	 * @return O valor do numero da nota fiscal.
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * Altera o valor do numero da Nota Fiscal.
	 * 
	 * @param number
	 *                O novo valor para o numero da Nota Fiscal.
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * Recupera o valor da Operação da Nota Fiscal.
	 * 
	 * @return O valor da operação da Nota Fiscal.
	 */
	public Operation getOperation() {
		return operation;
	}

	/**
	 * Altera o valor da operação da Nota Fiscal.
	 * 
	 * @param operation
	 *                O novo valor para a operação da Nota Fiscal.
	 */
	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	/**
	 * Recupera o valor da classificação da Nota Fiscal.
	 * 
	 * @return O valor da classificação da Nota Fiscal.
	 */
	public Ranking getRanking() {
		return ranking;
	}

	/**
	 * Altera o valor da classificação da Nota Fiscal.
	 * 
	 * @param ranking
	 *                O novo valor para a classificação da Nota Fiscal.
	 */
	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}

	/**
	 * Recupera o valor da Nota Fiscal.
	 * 
	 * @return O valor da Nota Fiscal.
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * Altera o valor da Nota Fiscal.
	 * 
	 * @param amount
	 *                O novo valor para a Nota Fiscal.
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * Recupera o valor pago de impostos da Nota Fiscal.
	 * 
	 * @return O valor pago em impostos da Nota Fiscal.
	 */
	public BigDecimal getAmountOfInvoicePaid() {
		return amountOfInvoicePaid;
	}

	/**
	 * Altera o valor pago em impostos da Nota Fiscal.
	 * 
	 * @param amountOfInvoicePaid
	 *                O novo valor para o valor pago em impostos da Nota Fiscal.
	 */
	public void setAmountOfInvoicePaid(BigDecimal amountOfInvoicePaid) {
		this.amountOfInvoicePaid = amountOfInvoicePaid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((number == null) ? 0 : number.hashCode());
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
		Invoice other = (Invoice) obj;
		if (number == null) {
			if (other.getNumber() != null) {
				return false;
			}
		} else if (!number.equals(other.getNumber())) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Invoice [number=" + number + ", operation=" + operation + ", ranking=" + ranking + ", amount=" + amount + ", amountOfInvoicePaid=" + amountOfInvoicePaid + "]";
	}
}
