# OldMaid
Perla Molina
pamolina@dons.usfca.edu
Project 03 Completed: April 29, 2020, 10:26pm

WHAT WORKS:
- Asking how many players betweeen 3-5.
- Asking to enter the names of all the players.
- Dealing a random card that is the Old Maid card.
- Shuffling the deck.
- Dealing the cards one by one to each player.
- Selecting a random player to go first.
- Having a player draw a card from the player on their right and adding it to their hand and then discarding a pair if one gets made from the drawn card. (SIDE NOTE: I kept having trouble trying to implement this part when I asked the user to draw a card as an input. Like I kept getting errors with the Scanner system, so I instead just decided to have the program itself select a random draw for the current player, as you'll see in my program.)
- Adding points to winned players.
- Completeing entire game until one final card is left from one player.
- Asking if the players want to play again.

IRREGULARITIES/SMALL BUGS:
- When the user inputs 5 players, there will be times, for some unknown reason, where the program will stop towards the end and display an error about Index Out of Bounds. I don't really know for which part and which array the index is referring to. But if you try to start the program again and go for 5 players again, the program will execute fine after that. I don't know, that was just something I noticed as I did test runs and it's an error that only happens when there are 5 players.
- When there is either 4 or 5 players, sometimes, if the current player has one card left and the player they are drawing a card from also only has one card left, for some reason, the program will mark the current player as the winner and then add their cards to next player, leaving the other player empty-handed but still in the game. For example, let's say John has one card left (Ten of Spades) and will draw a card from Bill who also has one card left (Eight of Diamonds). John now has two cards (Ten of Spades and Eight of Diamonds) and Bill is empty-handed, which means Bill won.  However, my program ends up marking John as the winner and ends up adding his hand to the next player Patricia and Bill is still in the game with an empyt hand. It's weird, but it doesn't happen often and only occurrs with 4 or 5 players, and only in the situation of the current player and other player having one card.
- There are also times when there are two players left and the program will incorrectly mark the player with the Old Maid card as the winner or safe from the game.

**These are bugs that don't happen with every game or every execution of the program. There are times it'll execute the program and run the game completely fine and correctly without any mishaps. I tried fixing as many bugs as I could without completely disrupting my entire code, since it took so long to get it complete to where I got it. Any feedback or pointers is entirely appreciated and welcomed! *