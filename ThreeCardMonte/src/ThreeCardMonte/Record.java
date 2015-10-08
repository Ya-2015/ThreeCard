package ThreeCardMonte;

public class Record {
	private int bet;
	private int outcome;
	
	public Record(int bet, int outcome){
		this.bet = bet;
		this.outcome = outcome;
	}
	
	public int getBet() {
		return bet;
	}
	public void setBet(int bet) {
		this.bet = bet;
	}
	public int getOutcome() {
		return outcome;
	}
	public void setOutcome(int outcome) {
		this.outcome = outcome;
	}
	
	

}
