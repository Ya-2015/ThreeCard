package ThreeCardMonte;

import java.util.Random;

public class Card {
	private final String AA = "AA";
	private final int NUM = 3;
	private int index = 0;
	Random random;
	private String[] strCards = {"##","##","##","##","##","##","1","2","3"};
	private final String[] strCardsOriginal = {"##","##","##","##","##","##","1","2","3"};;
	private String strOriginal = "";
	
	public Card(){
		random = new Random();
		strOriginal = arrangeCards();
	}
	
	public String shuffleCards(){
		shuffle();
		return strOriginal;
	}
	
	private String arrangeCards(){
		String str1 = "\t";
		String str2 = "\t";
		String str3 = "\t";
		
		for (int i = 0; i < NUM; i++){
			if (i == NUM - 1){
				str1 += strCards[i] + "\n";
				str2 += strCards[i+NUM] + "\n";
				str3 += strCards[i+NUM*2] + "\n";
			}else{
				str1 += strCards[i] + "  ";
				str2 += strCards[i+NUM] + "  ";
				str3 += strCards[i+NUM*2] + "   ";
			}
		}
		
		return str1+str2+str3;
	}
	
	public String displayCards(){
		int idx = index;
		
		strCards = strCardsOriginal.clone();
		
		strCards[idx] = AA;
		strCards[idx + NUM] = AA;
		
		return arrangeCards();
	}
	
	private void shuffle(){
		index = random.nextInt(NUM);
	}
	
	public int getPosition(){
		return index + 1;
	}
	
}
