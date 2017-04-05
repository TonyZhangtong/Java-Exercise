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
			System.out.println("player1 �õ�"+ (i+1) +"���ƣ�");
			player1.cardInHand[i] = cardAfterShuffle.get(k);
			cardAfterShuffle.remove(k);
			do {
				k = random.nextInt(52);
			}while(!cardAfterShuffle.containsKey(k));
			System.out.println("player2 �õ�"+ (i+1) +"���ƣ�");
			player2.cardInHand[i] = cardAfterShuffle.get(k);
			cardAfterShuffle.remove(k);
			System.out.println("");
		}
		System.out.println("���ƽ�����");
		System.out.println("");
	}
	public void compareCardInHand(People player1, People player2) {
		Arrays.sort(player1.cardInHand);
		Arrays.sort(player2.cardInHand);
		if(player1.cardInHand[1].compareTo(player1.cardInHand[1]) > 0) {
			System.out.println("��ң� "+ player1.name + "��ʤ��");
		} else {
			System.out.println("��ң� "+ player2.name + "��ʤ��");
		}
	}

	public void showCardInHand(People people) {
		System.out.print("��ң�" + people.name + "����Ϊ��");
		
		for(int i = 0; i < 2; i++) {
			System.out.print(people.cardInHand[i] +" ");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardCollection cardCollection = new CardCollection();
		System.out.println("�ƾֿ�ʼ��");
		cardCollection.shuffle();
		People player1 = new People("骱���");
		
		People player2 = new People("ͮ���");
		MaxCardGame game = new MaxCardGame();
		game.giveCards(player1 ,player2, cardCollection.cardAfterShuffle);
		game.showCardInHand(player1);
		game.showCardInHand(player2);
		game.compareCardInHand(player1, player2);
	}

}
