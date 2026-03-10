package Bai3;

public class OverdraftAccount extends Account {
	private double odLimit; // Hạn mức thấu chi
	private double overdraft; // Số tiền thấu chi đang sử dụng
	private double availableBalance; // Số dư khả dụng

	public OverdraftAccount() {
		super();
	}

	public OverdraftAccount(String acct_id, double balance, double odLimit) {
		super(acct_id);
		this.odLimit = odLimit;
		this.overdraft = 0;
		this.availableBalance = balance + odLimit;
	}

	// Getter và Setter cho odLimit
	public double getODLimit() {
		return odLimit;
	}

	public void setODLimit(double odLimit) {
		this.odLimit = odLimit;
		updateAvailableBalance();
	}

	// Getter và Setter cho availableBalance
	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	// Cập nhật số dư khả dụng
	private void updateAvailableBalance() {
		this.availableBalance = this.balance + this.odLimit - this.overdraft;
	}

	@Override
	public boolean withdraw(double amount) {
		// Cho phép rút nếu số tiền <= số dư + hạn mức
		if (amount > 0 && amount <= (this.balance + this.odLimit)) {
			this.balance -= amount;
			// Cập nhật số tiền thấu chi nếu số dư âm
			if (this.balance < 0) {
				this.overdraft = -this.balance;
			} else {
				this.overdraft = 0;
			}
			updateAvailableBalance();
			return true;
		}
		return false;
	}

	// Getter cho overdraft (số tiền thấu chi đang sử dụng)
	public double getOverdraft() {
		return overdraft;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" | Han muc: %.2f | Thau chi: %.2f | Kha dung: %.2f", odLimit,
				overdraft, availableBalance);
	}
}
