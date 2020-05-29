
package setup;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

/*
 * This class is used to store an array of card objects in a single
 * location such as a real deck of cards would
 */
public class Deck{
	
    private List<Card> cards;
    private int size;
    
    //Constructor
    public Deck(String[] ranks, String[] suits, int[] pointValues) {
        cards = new ArrayList<Card>();
        for (int i = 0; i < ranks.length; ++i) {
            for (int s = 0; s < suits.length; ++s) {
                ++size;
                Card obj = new Card(ranks[i], suits[s], pointValues[i]);
                cards.add(obj);
            }
        }
        Collections.shuffle(cards);
    }
    
    /*
     * This method is used to return true when the size of the deck is equal to 0
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    
    /*
     * This method is a getter for the size variable
     */
    public int size() {
        return size;
    }
    
    /*
     * This method is used to shuffle the deck of cards
     */
    public void randomShuffle() {
        Collections.shuffle(cards);
    }
    
    /*
     * This method is used to 'Deal' the cards by looping through the array and adding them to a deck
     */
    public Card deal() {
        if (size > 0) {
            --size;
            Collections.shuffle(cards);
            return cards.get(size);
        }
        return null;
    }
    
    @Override
    public String toString() {
        String rtn = "size = " + size + "\nUndealt cards: \n";
        for (int k = size - 1; k >= 0; --k) {
            rtn = String.valueOf(rtn) + cards.get(k);
            if (k != 0) {
                rtn = String.valueOf(rtn) + ", ";
            }
            if ((size - k) % 2 == 0) {
                rtn = String.valueOf(rtn) + "\n";
            }
        }
        rtn = String.valueOf(rtn) + "\nDealt cards: \n";
        for (int k = cards.size() - 1; k >= size; --k) {
            rtn = String.valueOf(rtn) + cards.get(k);
            if (k != size) {
                rtn = String.valueOf(rtn) + ", ";
            }
            if ((k - cards.size()) % 2 == 0) {
                rtn = String.valueOf(rtn) + "\n";
            }
        }
        rtn = String.valueOf(rtn) + "\n";
        return rtn;
    }
}
