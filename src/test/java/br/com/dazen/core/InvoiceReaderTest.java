package br.com.dazen.core;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.math.BigDecimal;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.dazen.model.Invoice;
import br.com.dazen.model.types.Operation;
import br.com.dazen.model.types.Ranking;

public class InvoiceReaderTest {

	private static final File FILE = new File("src/test/resources/Invoices.csv");
	private static InvoiceReader invoiceReader;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		invoiceReader = new InvoiceReader(FILE);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		invoiceReader = null;
	}

	@Test
	public void testTamanhoDaLista() {
		assertEquals(5, invoiceReader.getInvoices().size());
	}

	@Test
	public void testPrimeiraNotaDaLista() {
		Invoice invoice = invoiceReader.getInvoices().get(0);

		assertEquals(new Integer(1), invoice.getNumber());
		assertEquals(Operation.VENDA, invoice.getOperation());
		assertEquals(Ranking.A, invoice.getRanking());
		assertEquals(new BigDecimal("1000.00"), invoice.getAmount());
		assertEquals(new BigDecimal("180.00"), invoice.getAmountOfInvoicePaid());
	}

	@Test
	public void testNotaComOperacaoDeTransferencia() {
		Invoice invoice = invoiceReader.getInvoices().get(1);

		assertEquals(new Integer(2), invoice.getNumber());
		assertEquals(Operation.TRANSFERENCIA, invoice.getOperation());
		assertEquals(Ranking.A, invoice.getRanking());
		assertEquals(new BigDecimal("2000.00"), invoice.getAmount());
		assertEquals(new BigDecimal("360.00"), invoice.getAmountOfInvoicePaid());
	}

	@Test
	public void testNotaComOperacaoDeDoacao() {
		Invoice invoice = invoiceReader.getInvoices().get(2);

		assertEquals(new Integer(3), invoice.getNumber());
		assertEquals(Operation.DOACAO, invoice.getOperation());
		assertEquals(Ranking.B, invoice.getRanking());
		assertEquals(new BigDecimal("500.00"), invoice.getAmount());
		assertEquals(new BigDecimal("0.00"), invoice.getAmountOfInvoicePaid());
	}

}
