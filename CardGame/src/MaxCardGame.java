import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Random;

public class MaxCardGame {

	public void giveCards(People player1, People player2, Map<Integer,Card> cardAfterShuffle) {
		Random random = new Random();
		for(int i = 0; i < 2; i++) {
			int k;
			do {
				k = random.nextInt(52);
			}while(!cardAfterShuffle.containsKey(k));
			System.out.println("player1 拿第"+ (i+1) +"张牌！");
			player1.cardInHand[i] = cardAfterShuffle.get(k);
			cardAfterShuffle.remove(k);
			do {
				k = random.nextInt(52);
			}while(!cardAfterShuffle.containsKey(k));
			System.out.println("player2 拿第"+ (i+1) +"张牌！");
			player2.cardInHand[i] = cardAfterShuffle.get(k);
			cardAfterShuffle.remove(k);
			System.out.println("");
		}
		System.out.println("发牌结束！");
		System.out.println("");
	}
	public void compareCardInHand(People player1, People player2) {
		Arrays.sort(player1.cardInHand);
		Arrays.sort(player2.cardInHand);
		if(player1.cardInHand[1].compareTo(player1.cardInHand[1]) > 0) {
			System.out.println("玩家： "+ player1.name + "获胜！");
		} else {
			System.out.println("玩家： "+ player2.name + "获胜！");
		}
	}

	public void showCardInHand(People people) {
		System.out.print("玩家：" + people.name + "手牌为：");
		
		for(int i = 0; i < 2; i++) {
			System.out.print(people.cardInHand[i] +" ");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardCollection cardCollection = new CardCollection();
		System.out.println("牌局开始！");
		cardCollection.shuffle();
		People player1 = new People("楠宝宝");
		
		People player2 = new People("彤哥哥");
		MaxCardGame game = new MaxCardGame();
		game.giveCards(player1 ,player2, cardCollection.cardAfterShuffle);
		game.showCardInHand(player1);
		game.showCardInHand(player2);
		game.compareCardInHand(player1, player2);
	}

}
