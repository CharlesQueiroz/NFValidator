package br.com.dazen.model;

import java.io.Serializable;

/**
 * Classe que representa uma linha no relatório de saida que será gerado.
 * 
 * @author Charles Queiroz - charles@dazen.com.br | (85) 9933-1585
 * 
 */
public class InvoiceReport implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer number;
	private Role role;
	private Boolean isCorrect;

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getNumber() {
		return number;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Boolean IsCorrect() {
		return isCorrect;
	}

	public void setCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((number == null) ? 0 : number.hashCode());
		result = (prime * result) + ((role == null) ? 0 : role.hashCode());
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
		InvoiceReport other = (InvoiceReport) obj;
		if (number == null) {
			if (other.getNumber() != null) {
				return false;
			}
		} else if (!number.equals(other.getNumber())) {
			return false;
		}
		if (role == null) {
			if (other.getRole() != null) {
				return false;
			}
		} else if (!role.equals(other.getRole())) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "InvoiceReport [number=" + number + ", role=" + role + ", isCorrect=" + isCorrect + "]";
	}
}
