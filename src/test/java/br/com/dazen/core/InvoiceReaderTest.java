package br.com.dazen.core;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.dazen.model.InvoiceReport;
import br.com.dazen.model.Role;

public class InvoiceReaderTest {

	private static final File FILE_INVOICES = new File("src/test/resources/Invoices.csv");
	private static final File FILE_ROLES = new File("src/test/resources/Roles.csv");
	private static InvoiceReader invoiceReader;
	private static List<Role> roles;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		roles = new RoleReader(FILE_ROLES).getRoles();
		invoiceReader = new InvoiceReader(FILE_INVOICES, roles);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		invoiceReader = null;
	}

	@Test
	public void testTamanhoDaLista() {
		assertEquals(5, invoiceReader.getReports().size());
	}

	@Test
	public void testValidacaoPrimeiroRegistro() {
		InvoiceReport report = new InvoiceReport();
		report.setNumber(1);
		report.setRole(roles.get(0));
		report.setCorrect(true);
		assertEquals(report, invoiceReader.getReports().get(0));
	}

	@Test
	public void testValidacaoSegundoRegistro() {
		InvoiceReport report = new InvoiceReport();
		report.setNumber(2);
		report.setRole(roles.get(3));
		report.setCorrect(false);
		assertEquals(report, invoiceReader.getReports().get(1));
	}

	@Test
	public void testValidacaoTerceiroRegistro() {
		InvoiceReport report = new InvoiceReport();
		report.setNumber(3);
		report.setRole(roles.get(4));
		report.setCorrect(true);
		assertEquals(report, invoiceReader.getReports().get(2));
	}

	@Test
	public void testValidacaoQuartoRegistro() {
		InvoiceReport report = new InvoiceReport();
		report.setNumber(4);
		report.setRole(roles.get(1));
		report.setCorrect(false);
		assertEquals(report, invoiceReader.getReports().get(3));
	}

	@Test
	public void testValidacaoQuintoRegistro() {
		InvoiceReport report = new InvoiceReport();
		report.setNumber(5);
		report.setRole(roles.get(0));
		report.setCorrect(false);
		assertEquals(report, invoiceReader.getReports().get(4));
	}
}
