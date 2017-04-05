import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Card implements Comparable<Card>  {
	Integer number;
	String color;
	public Card(int number, String color) {
		this.number = number;
		this.color = color;
	}
	public String toString(){
		return color+number+"";
	}
	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		return this.number.compareTo(o.number);
	}
}

class CardCollection {
	 List<Card> cardCollection;
	 Map<Integer,Card> cardAfterShuffle;
	 public CardCollection() {
		cardCollection = new ArrayList<Card>();
		cardAfterShuffle = new HashMap<Integer, Card>();
		Card[] card= {new Card(1,"����"),new Card(2,"����"),new Card(3,"����"),new Card(4,"����"),new Card(5,"����"),new Card(6,"����"),new Card(7,"����")};
		cardCollection.addAll(Arrays.asList(card));
	 }
	 
	 public void shuffle() {
		 Random random = new Random();
		 System.out.println("ϴ�ƣ�");
		 for(Card c : cardCollection) {
			 int k;
			 do {
				 k = random.nextInt(52);
			 }while(cardAfterShuffle.containsKey(k));
			 cardAfterShuffle.put((Integer)k,(Card)c);
		 }
	 }
}
