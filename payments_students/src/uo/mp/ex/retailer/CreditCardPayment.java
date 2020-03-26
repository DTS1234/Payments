package uo.mp.ex.retailer;

import ruralvia.PaymentGateway;
import ruralvia.Transaction;

public class CreditCardPayment extends Payment implements Transaction {

	private static final String MERCHANT_ID = "1111-22";
	private String cardNumber;
	private int cardEndMonth;
	private int cardEndYear;
	private String merchantId;
	
	public CreditCardPayment(String transactionId, double amount, String cardNumber, 
			int cardEndMonth, int cardEndYear, String merchantId) {
		
		super(transactionId, amount);		
		this.cardNumber = cardNumber;
		this.cardEndMonth = cardEndMonth;
		this.cardEndYear= cardEndYear;
		this.merchantId = merchantId;
		
	}

	@Override
	public void process() {
		
		PaymentGateway paymentGateaway = new PaymentGateway();
		
		if(!paymentGateaway.isValid(this)) {
			messageFailedPayment();	
		}else if(merchantId != MERCHANT_ID) {
			messageWrongMerchantId();
		}else {
			setValid(true);
			messageSucessPayment();
		}
		
	}

	@Override
	public boolean isValid() {
		return getValid();
	}

	@Override
	public String getMerchantId() {
		return MERCHANT_ID;
	}

	@Override
	public String getCreditCardNumber() {
		return cardNumber;
	}

	@Override
	public int getMonth() {
		return cardEndMonth;
	}

	@Override
	public int getYear() {
		return cardEndYear;
	}

	@Override
	public String toString() {
		return "CreditCardPayment [cardNumber=" + cardNumber + ", cardEndMonth=" + cardEndMonth + ", cardEndYear="
				+ cardEndYear + ", Transaction Id=" + getTransactionId() + ", amount =" + getAmount() + "]";
	}
	
	private void messageSucessPayment() {
		System.out.println("PAYMENT DONE : " + this);
	}
	
	private void messageFailedPayment() {
		System.out.println("FAILED PAYMENT : " + this);
		System.out.println("ERROR CAUSED BY INVALID CARD DATA");
	}
	
	private void messageWrongMerchantId() {
		System.out.println("FAILED PAYMENT : " + this);
		System.out.println("ERROR CAUSED BY INVALID MERCHANT_ID");
	}
	
	
}
