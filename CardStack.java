//********************************************************************
//  CardStack.java       
//
//  
//********************************************************************

import java.util.*;
import java.lang.*; 
import java.io.*; 

public class CardStack
{
    private ArrayList<Card> stack;


    //-----------------------------------------------------------------
    //  Creates a full deck with the cards initially "in order".
    //-----------------------------------------------------------------
    public CardStack()
    {
        stack = new ArrayList<Card>();

    }

    //-----------------------------------------------------------------
    //  Adds a card to the collection.
    //-----------------------------------------------------------------
    public void addCard(Card c)
    {
        stack.add(c);

    }
    //-----------------------------------------------------------------
    //  Deals the first card from the collection.
    //-----------------------------------------------------------------
    public Card deal()
    {
        if (stack.size() > 0) {
            return stack.remove(0);
        } else {
            return null;
        }
    }

    //-----------------------------------------------------------------
    //  Deals a random card from the collection.
    //-----------------------------------------------------------------
    public Card randomDeal()
    {
        Random generator = new Random();
        int index = generator.nextInt(stack.size());

        if (stack.size() > 0) {
            return stack.remove(index);
        } else {
            return null;
        }       
    }

    //-----------------------------------------------------------------
    //  Removes a card from the stack of cards.
    //-----------------------------------------------------------------
    public boolean removeCard(Card c)
    {
        //System.out.println("removing from stack ... "+c);
        return stack.remove(c);
    }
    
    //Overloaded removing by index:
    public void removeCard(int i)
    {
        //System.out.println("removing from stack ... "+stack.get(i));
        stack.remove(i);
    }

    //-----------------------------------------------------------------
    //  Returns the ith card from the stack of cards.
    //-----------------------------------------------------------------
    public Card getCard(int i)
    {
       
        return stack.get(i);

    }

    //-----------------------------------------------------------------
    //  Returns the number of cards left in the deck.
    //-----------------------------------------------------------------
    public int getSize()
    {
        return stack.size();
    }

    //-----------------------------------------------------------------
    //  Returns true is the deck has cards in it, else false.
    //-----------------------------------------------------------------
    public boolean hasMoreCards()
    {
        return (stack.size() > 0);
    }

    //-----------------------------------------------------------------
    //  Swaps two cards in the Stack of Cards
    //-----------------------------------------------------------------
    public void swap(int position1, int position2)
    {
        Card temp;  
        temp = stack.get(position1);
        stack.set(position1, stack.get(position2));
        stack.set(position2, temp);
    }

    //-----------------------------------------------------------------
    //  String representation of the Stack of Cards
    //-----------------------------------------------------------------
    public String toString()
    {
        String result = "";
        for(int i=0; i<stack.size(); i++)
        {
            result+="["+stack.get(i).toString()+"] ";
        }
        return result;
    }

    //-----------------------------------------------------------------
    // Shuffles card order 
    //-----------------------------------------------------------------
    public void shuffle()
    {
        int random;
        for (int i=0; i<stack.size(); i++)
        {
            random = (int)(Math.random()*stack.size());
            swap(i,random);
        }
    }
    
    //-----------------------------------------------------------------
    // Checks to see if the card exists in the group
    //-----------------------------------------------------------------
    public boolean hasCard(Card c)
    {
        return stack.contains(c);
    }

    //makes a deck of 52 cards//
    public void fillDeck()
    {
        Card card;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                card = new Card(j, i);
                stack.add(card);
            }
        }
    }
}
