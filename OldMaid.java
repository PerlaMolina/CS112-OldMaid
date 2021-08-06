import java.util.*;

public class OldMaid
{
    public static void main(String[] args) {
        boolean done = false;
        Scanner scan = new Scanner(System.in);

        System.out.println("==============================");
		System.out.println("LET'S PLAY OLD MAID!");
		System.out.println("==============================");
		System.out.println("==============================");
		System.out.println("INSTRUCTIONS & RULES:");
		System.out.println("The standard 52-card pack is used, however, one random card is removed, leaving a total of 51 cards.");
		System.out.println("Then, any player shuffles the pack and deals them around, one at a time to each player, until all the cards have been handed out. Players do not need to have an equal number of cards.");
		System.out.println("After that, each player removes all pairs from their hand face down. If a player has three-of-a-kind, they remove only two of those three cards.");
		System.out.println("After all pairs have been removed from each player's deck, a random player will be choosen to go first.");
		System.out.println("That player will then get to draw a random card from the player to their right. Then this player discards any pair that may have been formed by the drawn card.");
		System.out.println("The player then offers their own hand to the player on their left.");
		System.out.println("The game proceeds in this way until all cards have been paired except one - the odd random card that was taken out from the beginning, which cannot be paired - and the player who has that card is the Old Maid! (and looses)");
		System.out.println("==============================");
		System.out.println("==============================");
		System.out.println("LET THE GAMES BEGIN!");
		System.out.println("==============================");

        //Deck of cards
        Deck deckOfCard;
        //arraylist for players
        ArrayList<OldMaidPlayer> data = new ArrayList<OldMaidPlayer>();

        //arraylist for card stack
        ArrayList<CardStack> players = new ArrayList<CardStack>();
        //initialize the game
        OldMaid game = new OldMaid();
        game.getPlayers(scan, players, data);
        while (!done) {
            //arraylist to store the players
            ArrayList<CardStack> winnedPlayers = new ArrayList<>();
            deckOfCard = new Deck();
            game.getHands(deckOfCard, players);
            //prompt the removed pairs
            System.out.println();
            for (int z = 0; z < players.size(); z++) {
            	System.out.println(((OldMaidHand) players.get(z)).getName()+" is removing their pairs...\n");
                ((OldMaidHand) players.get(z)).removePairs();
                System.out.println();
            }
            System.out.println();
            //print the remaining stack on each player hand
            System.out.println("The remaining stack on each hand are:");
            System.out.println();
            for (int i = 0; i < players.size(); i++) {
                ((OldMaidHand) players.get(i)).display();
            }
            //randomly chooses who get's to play first
            Random rand = new Random();
            int i = rand.nextInt(players.size());
            System.out.println("==============================");
            System.out.println(((OldMaidHand) players.get(i)).getName() + " plays first.");
            System.out.println();
            int count = 0;
            Card card;
            while (players.size() != 1) {
                if (i >= (players.size())) {
                    i = 0;
                }
                //draw a card from one player
                if (i == 0) {
                	System.out.println(((OldMaidHand) players.get(0)).getName() + "'s turn.");
                	((OldMaidHand) players.get(0)).display();
                    card = ((OldMaidHand) players.get(players.size() - 1)).drawCard();
                    System.out.println();

                    if (players.get(players.size() - 1).getSize() == 0) {
                        count++;
                        game.update(players.get(0), data, count);
                        winnedPlayers.add(players.get(0));
                        players.remove(players.get(0));
                    }
                    players.get(0).addCard(card);

                    //remove pairs after adding card
                    System.out.println("Remove pairs from " + ((OldMaidHand) players.get(0)).getName() + "'s stack...");
                    System.out.println();
                    ((OldMaidHand) players.get(0)).removePairs();
                    ((OldMaidHand) players.get(0)).display();
                    ((OldMaidHand) players.get(players.size() - 1)).display();		//problematic line here
                    System.out.println("==============================");
                    if (players.get(0).getSize() != 0) {
                        ((OldMaidHand) players.get(0)).shuffle();
                    }
                    if (players.get(0).getSize() == 0) {
                        count++;
                        game.update(players.get(0), data, count);
                        winnedPlayers.add(players.get(0));
                        players.remove(players.get(0));
                    } else {
                        i++;
                    }
                } else {
                	System.out.println(((OldMaidHand) players.get(i)).getName() + "'s turn.");
                	((OldMaidHand) players.get(i)).display();
                    card = ((OldMaidHand) players.get(i - 1)).drawCard();
                    System.out.println();
                    if (players.get(i - 1).getSize() == 0) {
                        count++;
                        game.update(players.get(i - 1), data, count);
                        winnedPlayers.add(players.get(i - 1));
                        players.remove(players.get(i - 1));
                    }
                    if (i >= players.size()) {
                        i = players.size() - 1;
                    }
                    players.get(i).addCard(card);
                    //remove pair cards
                    System.out.println("Remove pairs from " + ((OldMaidHand) players.get(i)).getName() + "'s stack...");
                    System.out.println();
                    ((OldMaidHand) players.get(i)).removePairs();
                    ((OldMaidHand) players.get(i)).display();
                    ((OldMaidHand) players.get(i-1)).display();
                    System.out.println("==============================");
                    if (players.get(i).getSize() != 0) {
                        ((OldMaidHand) players.get(i)).shuffle();
                    }
                    if (players.get(i).getSize() == 0) {
                        count++;
                        game.update(players.get(i), data, count);
                        winnedPlayers.add(players.get(i));
                        players.remove(players.get(i));
                    } else {
                        i++;
                    }
                }
            }

            //updating the score of player
            game.update(players.get(0), data);
            System.out.println();

            //prompt player score
            System.out.println("The scores are: ");
            //play the result of score.
            for (int x = 0; x < data.size(); x++) {
                System.out.println(data.get(x));
            }
            System.out.println("Do you want to play again? (y/n)");
            String again = scan.nextLine();
            if (again.equals("n")) {
                done = true;
            }
            else {
                for (int h = 0; h < winnedPlayers.size(); h++) {
                    players.add(winnedPlayers.get(h));
                }
            }
        }
    }

    //add players to arraylist
    public void getPlayers(Scanner scan, ArrayList<CardStack> players, ArrayList<OldMaidPlayer> data) {
        boolean done = false;
        int totalPlayers = 0;
        while (!done) {
            //prompt user to enter the number of players
            System.out.println("Enter the number of players from 3-5: ");
            totalPlayers = scan.nextInt();
            String sp = scan.nextLine();
            if (totalPlayers < 3 || totalPlayers > 5) {
                System.out.println("Please enter at least 3 or at most 5 players: ");
                continue;
            } else {
                break;
            }
        }
        System.out.println();
        System.out.println("==============================");
		System.out.println(totalPlayers+" PLAYER OLD MAID GAME STARTING...");
		System.out.println("==============================");
        String name;
        for (int i = 0; i < totalPlayers; i++) {
            //prompt user to enter the name ofplayer
            System.out.println("> Enter the name of Player " + (i + 1)+": ");
            name = scan.nextLine();
            players.add(new OldMaidHand(name));
            data.add(new OldMaidPlayer(name));
            System.out.println();
        }
    }

    //method to get hands
    public void getHands(Deck deckOfCard, ArrayList<CardStack> players) {
        int j = 0;
        while (deckOfCard.getSize() != 0) {
            players.get(j).addCard(deckOfCard.deal());
            j++;

            if (j == players.size()) {
                j = 0;
            }
        }
        for (int i = 0; i < players.size(); i++) {
            ((OldMaidHand) players.get(i)).display();
        }
    }

    //method to update hands & set points for winned players
    public void update(CardStack player, ArrayList<OldMaidPlayer> data, int count) {
        for (int i = 0; i < data.size(); i++) {
            if (((OldMaidHand) player).getName() == data.get(i).getName() && count == 1) {
                data.get(i).won();
                data.get(i).setPoints(3);
                System.out.println(data.get(i).getName()+" won!");
            } else if (((OldMaidHand) player).getName() == data.get(i).getName() && count < data.size()) {
                data.get(i).setPoints(1);
                System.out.println(data.get(i).getName()+" is now safe from the game!");
            }
        }
    }

    public void update(CardStack player, ArrayList<OldMaidPlayer> data) {
        for (int i = 0; i < data.size(); i++) {
            if (((OldMaidHand) player).getName() == data.get(i).getName()) {
                data.get(i).lost();
                System.out.println(((OldMaidHand) player).getName()+" lost. :(");
            }
        }
    }
}