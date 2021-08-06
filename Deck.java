import java.util.Random;

public class Deck extends CardStack
{
	public Deck() {
		super();
		for (int i = Card.CLUBS; i <= Card.SPADES; i++) {
			for (int j = Card.ACE; j <= Card.KING; j++) {
				Card card = new Card(j, i);
				super.addCard(card);
			}
		}
		//print size of deck before removing cards
		System.out.println("The size of Deck before removing a random card is "+super.getSize());
		System.out.println();
		//print removed card
		System.out.println("Selecting random Old Maid Card...");
		System.out.println("The Old Maid card removed is: "+super.randomDeal());
		System.out.println();
		//print size of deck after removing the card
		System.out.println("The size of Deck after removing the Old Maid card is: "+super.getSize());
		System.out.println();
		//print shuffled cards
		System.out.println("Shuffling the cards...");
		System.out.println();
		this.shuffle();
	}

	//method to shuffle cards
	public void shuffle() {
		Random index = new Random();
		for (int i = 0; i < super.getSize(); i++) {
			swap(i, index.nextInt(super.getSize()));
		}
	}
}

