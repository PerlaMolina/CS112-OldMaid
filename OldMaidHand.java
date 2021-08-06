import java.util.ArrayList;
import java.util.Random;

public class OldMaidHand extends CardStack
{
	private String name;

	public OldMaidHand(String name) {
		super();
		this.name = name;
	}

	//remove pairs cards
	public void removePairs() {
		int i = 0;
		int j = 0;
		int removed = 0;
		while (i < super.getSize()) {
			j = i + 1;
			while (j < super.getSize()) {
				if (super.getCard(i).getFace() == super.getCard(j).getFace()) {
					System.out.println("removing from stack ... "+super.getCard(j));
					super.removeCard(super.getCard(j));
					removed++;
					break;
				}
				j++;
			}
			if (removed == 1) {
				System.out.println("removing from stack ... "+super.getCard(i));
				super.removeCard(super.getCard(i));
				removed = 0;
			}
			else {
				i++;
			}
		}
		System.out.println("No more pairs removed.");
		System.out.println("==============================");
	}

	//display the stack of each player
	public void display() {
		System.out.println(name + "'s hand: " + super.toString());
		System.out.println();
	}

	//draw a card from one player
	public Card drawCard() {
		Random rand = new Random();
		int index = rand.nextInt(super.getSize());
		System.out.println("Draw a card from "+this.getName()+"'s stack: "+this.toString());
		System.out.print("\nDrawing random card... ");
		Card card = super.getCard(index);
		System.out.println(card);
		super.removeCard(card);
		return card;
	}

	//shuffle the stack
	public void shuffle() {
		Random index = new Random();
		for (int i = 0; i < super.getSize(); i++) {
			swap(i, index.nextInt(super.getSize()));
		}
	}

	public String getName() {
		return name;
	}
}

