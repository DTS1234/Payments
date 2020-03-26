package uo.mp.ex.retailer;

public class CashPayment extends Payment {

	public CashPayment(String transactionId, double amount) {
		super(transactionId, amount);
	}

	@Override
	public void process() {
		sendPaymentSucessMsg();
		setValid(true);
	}

	@Override
	public boolean isValid() {
		return getValid();
	}

	@Override
	public String toString() {
		return "CashPayment [Transaction Id = " + getTransactionId() + ", amount = " + getAmount() + "]";
	}

	private void sendPaymentSucessMsg() {
		System.out.println("PAYMENT DONE : " + this);
	}

}
