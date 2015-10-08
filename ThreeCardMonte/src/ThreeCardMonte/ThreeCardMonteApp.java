package ThreeCardMonte;
import java.util.Scanner;

public class ThreeCardMonteApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("You slide up to Fast Eddie's card table and plop down your cash.");
		System.out.println("He glances at you out of the corner of his eye and starts shuffling.");
		System.out.println("He lays down three cards.");
		
		int input;
		Gamer gamer = new Gamer();
		
		System.out.print("\nPlease set a bet: ");
		while(!gamer.setBetAmount(scan.nextInt())){
			System.out.print("\nMin bet is 5. Please set a bet: ");
		}
		
		while(!gamer.isGameOver()){
			if(gamer.isEnoughBlance()){
				System.out.println("\nWhich one is the ace?\n");
				System.out.println(gamer.placeABet());
				input = scan.nextInt();
				if(gamer.isWon(input)){
					System.out.println("\nYou nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n");
				}else{
					System.out.printf("\nHa! Fast Eddie wins again! The ace was card number %d.\n", gamer.getMatchLoation());
				}
				
				System.out.println(gamer.showResult());
				System.out.println("Current Balance: " + gamer.getCurrentBalance());
			}else{
				System.out.println("Out of Blance. Game Over.");
				break;
			}
			
			System.out.print("Continue to play? y or n: ");
			if (scan.next().equalsIgnoreCase("n")){
				break;
			}
			
		}
		
		//print history
		System.out.println("\nRecords");
		System.out.println("bet\toutcome");
		for (int i = 0; i < gamer.getRecords().size(); i++){
			System.out.println(gamer.getRecords().get(i).getBet() + "\t" + gamer.getRecords().get(i).getOutcome());
		}
		
		scan.close();
	}
}
