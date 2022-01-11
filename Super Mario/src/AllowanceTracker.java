
public class AllowanceTracker {
	double allowance,balance;
	int exD;
	public AllowanceTracker(double allow) {
		allowance=allow;
		balance=allowance;
		exD=0;
	}
	public void spend(double spent) {
		balance-=spent;
		if(spent/allowance>=.2) {
			exD++;
		}
	}
	public double getBalance() {
		return balance;
	}
	public void earn(double gained) {
		balance+=gained;
	}
	public void replenish() {
		balance+=allowance;
	}
	public int numExcessiveDays() {
		return exD;
	}


	
}
