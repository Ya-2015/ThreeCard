package ThreeCardMonte;

import java.util.ArrayList;

public class Gamer {
	private final int MAX = 500;
	private int currentBalance = 0;
	private int currentBet = 0;
	private final int MIN_BET = 5;
	Card card;
	private ArrayList<Record> record = new ArrayList<Record>();
	
	public Gamer(){
		currentBalance = 100;
		currentBet = 55;
		card = new Card();
	}

	public ArrayList<Record> getRecords(){
		return record;
	}
	
	public int getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}

	public int getBetAmount() {
		return currentBet;
	}

	public boolean setBetAmount(int betAmount) {
		
		if (betAmount >= MIN_BET)
		{
			this.currentBet = betAmount;
			
			return true;
		}else{
			return false;
		}
		
	}

	public String placeABet(){

		currentBalance -= currentBet;

		return card.shuffleCards();
	}
	
	public boolean isEnoughBlance(){
		boolean isEnough = true;
		
		if (currentBalance - currentBet < 0){
			isEnough = false;
		}
		
		return isEnough;
	}
	
	public boolean isWon(int pos){
		int matchLoc = card.getPosition();
		
		//
		record.add(new Record(pos, matchLoc));
		
		if(matchLoc == pos){
			currentBalance += currentBet *2;
			return true;
		}else{
			return false;
		}

		
	}
	
	public int getMatchLoation()
	{
		return card.getPosition();
	}
	
	public boolean isGameOver(){
		
		if (currentBalance >= MAX || currentBalance <= 0){
			return true;
		}else{
			return false;
		}
		
	}
	
	public String showResult(){
		return card.displayCards();
	}
}
