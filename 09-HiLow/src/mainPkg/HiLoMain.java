
package mainPkg;

import setup.Deck;
import Images.ImageList;
import setup.Card;
import setup.JOP;

public class HiLoMain {
	private static JOP _j = new JOP();
	private static Card card;
	private static Card card2;
	/********\
	**	int	**
	\********/
	private static int loss;
	private static int wins;
	private static int max;
	private static int cardCount;
	
	/************\
	**	Arrays	**
	\************/
	static int[] pointValue = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
	static String[] Rank = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	static String[] Suit = new String[] { "\u2663", "\u2666", "\u2660", "\u2665" };
	static String[] option1 = new String[] { "\u2191", "EXIT", "\u2193" };
	static String[] option2 = new String[] { "Easy", "Medium", "Hard" };

	/*
	 * This is the main method which runs the logic for the HiLow game.
	 */
	public static void main(String[] args) {
		loss = 0;
		wins = 0;
		cardCount = 0;
		int diff = _j.option(option2,
				"Easy Mode: 8 Guesses\n"
				+ "Medium Mode: 6 Guesses\n"
				+ "Hard Mode: 4 Guesses", "Difficulty", ImageList.emh);
		if (diff == 0) {
			max = 8;
		} else if (diff == 1) {
			max = 6;
		} else if (diff == 2) {
			max = 4;
		}
		_j.msg(
				"The High Low Card Game is a Game in which the player \n"
				+ "is tasked to guess whether the next card is: \n"
				+ "'HIGHER' or 'LOWER' than the following card.\n "
				+ "\n"
				+ "You have THREE guesses before you lose.",
				"High-Low Card Game!", ImageList.hilo);
		System.out.println(max);
		Deck deck = new Deck(Rank, Suit, pointValue);
		while (cardCount < 26 && loss < max) {
			card = deck.deal();
			card2 = deck.deal();
			int x = _j.option(option1,
					"Current Card: " + card + "\n" + "Is Your Card 'Higher' or 'Lower' than the upcoming card?"
							+ "\nCorrect Guesses: " + wins + "\nWrong Guesses: " + loss,
					"HIGH OR LOW!!");
			if (x == 0) {
				if (card.pointValue() == card2.pointValue()) {
					_j.msg("They were the same so nothing happens!", "Same Card!");
				} else if (card.pointValue() > card2.pointValue()) {
					_j.msg("Correct Guess!, the following card was a " + card2, "Correct");
					++wins;
				} else {
					_j.msg("Wrong Guess!, the following card was a " + card2, "Wrong");
					++loss;
				}
			}
			if (x == 2) {
				if (card.pointValue() == card2.pointValue()) {
					_j.msg("They were the same so nothing happens!");
				}
				if (card.pointValue() < card2.pointValue()) {
					_j.msg("Correct Guess!, the following card was a " + card2, "Correct");
					++wins;
				} else {
					_j.msg("Wrong Guess!, the following card was a " + card2, "Wrong");
					++loss;
				}
			}
			if (x == 1) {
				System.exit(0);
			}
		}
		if (loss >= max) {
			System.out.println(loss + "," + max);
			_j.msg("You have Guessed the Max Number of times, you LOSE", "LOST");
		}
		if (cardCount == 26) {
			_j.msg(
					"You did it! You went through all 52 cards and got " + loss + " wrong! congratulations!");
		}
	}
}
