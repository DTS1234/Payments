package retailertests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.ex.retailer.CashPayment;
import uo.mp.ex.retailer.CreditCardPayment;
import uo.mp.ex.retailer.PayPalPayment;
import uo.mp.ex.retailer.Payment;
import uo.mp.ex.retailer.Retailer;

public class GetTotalSalesTest {
	
	private Retailer retailerTest;
	private Payment p1;
	private Payment p2;
	private Payment p3;
	private Payment p4;
	private Payment p5;
	private Payment p6;

	
	@Before
	public void setUp() {
		
		retailerTest = new Retailer();
		
		p1 = new CreditCardPayment("100", 20.05, "1111-1111-1111-1111-1111", 12, 2018, "1111-22");
		p2 = new CreditCardPayment("100", 20.05, "1111-1111-1111-1111-1111", 12, 2018, "1111-22");
		p3 = new CashPayment("101", 220);
		p4 = new PayPalPayment("102", 20.05, "mary@w3c.org", "dD_66%j");
		p5 = new PayPalPayment("103", 40.05, "mary@w3c.org", "dD_66%jXX");
		p6 = new CreditCardPayment("104", 20.05, "1111-1111-1111-1111-1111", 12, 2018, "1111-23");
	
		retailerTest.addPayment(p1);
		retailerTest.addPayment(p3);
		retailerTest.addPayment(p4);
		
	}
	
	
	//GIVEN : payments valid and processed
	//WHEN : calling getTotalPayments()
	//THEN : totalSales are equal 241
	@Test
	public void validPaymentsTest() {
		retailerTest.processAllPayments();
		assertEquals(20.05+20.05+220, retailerTest.getTotalSales(), 0.001);
	}
	
	//GIVEN : payments unprocessed
	//WHEN : calling getTotalPayments()
	//THEN : totalSales are equal 0
	@Test
	public void unProcessedvalidPaymentsTest() {
		assertEquals(0, retailerTest.getTotalSales(), 0.001);
	}
	
	//GIVEN : payments with sam transaction Id 
	//WHEN : adding payments
	//THEN : totalSales do not include duplicated value 
	@Test
	public void samePaymentsTest() {
		
		retailerTest.addPayment(p2);
		retailerTest.processAllPayments();
		assertEquals(20.05+20.05+220, retailerTest.getTotalSales(), 0.001);
	
	}
	
	//GIVEN : invalid payments 
	//WHEN : calling getTotalPayments()
	//THEN : totalSales do not include wrong payments
	@Test
	public void inValidProcessedPaymentsTest() {
		
		retailerTest.addPayment(p5);
		retailerTest.addPayment(p6);
		retailerTest.processAllPayments();
		assertEquals(20.05+20.05+220, retailerTest.getTotalSales(), 0.001);
	
	}
	

}
