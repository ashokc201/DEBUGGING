
public class Player {
	private String name;
	private int balance;
	private int limit;
	
	public Player(String name, int balance) {
		if (name == null || name .isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
		if (balance < 0) throw new IllegalArgumentException("Balance cannot be negative");
		this.name = name;
		this.balance = balance;
		this.limit = 0;
	}
	public String getName() { return name; }
	public int getBalance() { 
		//System.out.println(" getBalance()::"+ balance);
		
		return balance; }
	public int getLimit() { return limit; }
	
	public void setLimit(int limit) {
		if (limit < 0) throw new IllegalArgumentException("Limit cannot be negative.");
		if (limit > balance)  throw new IllegalArgumentException("Limit cannot be greater than balance.");
		this.limit = limit;
	}
	     public void setBalance(int balance) {
		 this.balance =this.balance;////**************changed***********//
	  }
	 
 
	public boolean balanceExceedsLimit() {
		return (balance > limit);  
	}
	  
	public boolean balanceExceedsLimitBy(int amount) {
		//System.out.println("balance::++"+balance+"amount::"+amount);  
		return (balance - amount >= limit); //**************changed***********//
	}
	
	public void takeBet(int bet) {
		if (bet < 0) throw new IllegalArgumentException("Bet cannot be negative.");
		if (!balanceExceedsLimitBy(bet)) throw new IllegalArgumentException("Placing bet would go below limit.");
		balance = getBalance() - bet;
		setBalance( balance);////**************changed***********//
	}
	
	public void receiveWinnings(int winnings) {
		if (winnings < 0) throw new IllegalArgumentException("Winnings cannot be negative.");
		//System.out.println("WWWWinnings::"+winnings);
		
		//System.out.println("balance::"+getBalance());
		
		balance = getBalance() + winnings;
		//System.out.println("BBBalance::"+balance);
		setBalance( balance);////**************changed***********//


	}
	
	public String toString() {
		return String.format("Player: %s, Balance: %d, Limit: %d", name, balance, limit);
	}
}
