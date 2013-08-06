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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmountOfInvoicePaid() {
		return amountOfInvoicePaid;
	}

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
