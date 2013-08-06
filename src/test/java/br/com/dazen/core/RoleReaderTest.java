package br.com.dazen.core;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.math.BigDecimal;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.dazen.model.Role;
import br.com.dazen.model.types.Operation;
import br.com.dazen.model.types.Ranking;

public class RoleReaderTest {

	private static final File FILE = new File("src/test/resources/Roles.csv");
	private static RoleReader roleReader;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		roleReader = new RoleReader(FILE);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		roleReader = null;
	}

	@Test
	public void testTamanhoDaLista() {
		assertEquals(6, roleReader.getRoles().size());
	}

	@Test
	public void testPrimeiraRegraDaLista() {
		Role role = roleReader.getRoles().get(0);

		assertEquals(new Integer(1), role.getId());
		assertEquals(Operation.VENDA, role.getOperation());
		assertEquals(Ranking.A, role.getRanking());
		assertEquals(new BigDecimal("18.00"), role.getAliquot());
	}

	@Test
	public void testRegraComOperacaoDeTransferencia() {
		Role role = roleReader.getRoles().get(3);

		assertEquals(new Integer(4), role.getId());
		assertEquals(Operation.TRANSFERENCIA, role.getOperation());
		assertEquals(Ranking.ANY, role.getRanking());
		assertEquals(new BigDecimal("15.00"), role.getAliquot());
	}

	@Test
	public void testRegraComTodasAsOperacoes() {
		Role role = roleReader.getRoles().get(5);

		assertEquals(new Integer(6), role.getId());
		assertEquals(Operation.ANY, role.getOperation());
		assertEquals(Ranking.D, role.getRanking());
		assertEquals(new BigDecimal("1.50"), role.getAliquot());
	}
}
