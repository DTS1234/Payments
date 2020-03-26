package uo.mp.ex.retailer;

public abstract class Payment {
	
	private String transactionId;
	private double amount;
	private boolean isValid;
	
	public Payment(String transactionId, double amount) {
		this.transactionId = transactionId;
		this.amount = amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public abstract void process();
	
	public abstract boolean isValid();

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	public boolean getValid() {
		return isValid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		return true;
	}
	
	
		
}
