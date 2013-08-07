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

	/**
	 * Altera o valor do número da linha do relatório.
	 * 
	 * @param number
	 *                O novo valor do número da linha do relatório.
	 * 
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	/**
	 * Recupera o valor do número da linha do relatório.
	 * 
	 * @return O número da linha no relatório.
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * Recupera a regra que definiu se o calculo foi feito corretamente ou não.
	 * 
	 * @return A regra que definiu se o calculo foi feito corretamente ou não.
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Altera a regra de definição do calculo para a linha do relatório.
	 * 
	 * @param role
	 *                A nova regra para a linha do relatório.
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Informa se o calculo do imposto foi feito corretamente ou não.
	 * 
	 * @return true caso tenha sido feito corretamente o cálculo ou false caso contrário.
	 */
	public Boolean getIsCorrect() {
		return isCorrect;
	}

	/**
	 * Altera o valor que indica se o calculo foi feito corretamente ou não.
	 * 
	 * @param isCorrect
	 *                O novo valor para a indicar se foi feito o calculo corretamente ou nao.
	 */
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
