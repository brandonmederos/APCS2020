
package setup;

/*
 * This class is the card object which stores the suit, rank, and value of the card
 */
public class Card{
    private String suit;
    private String rank;
    private int pointValue;
    
    //Constructor
    public Card(String cardRank, String cardSuit, int cardPointValue) {
        this.rank = cardRank;
        this.suit = cardSuit;
        this.pointValue = cardPointValue;
    }
    /*
     * These 3 methods are used as getters for the suit, rank, and value of the card.
     */
    public String suit() {
        return suit;
    }
    
    public String rank() {
        return rank;
    }
    
    public int pointValue() {
        return pointValue;
    }
    
    /*
     * This method is used to compare another card to the next or previous card in the 
     * theoretical deck
     */
    public boolean matches(Card otherCard) {
        return suit.equals(otherCard.suit) && pointValue == otherCard.pointValue && rank.equals(otherCard.rank);
    }
    
    @Override
    public String toString() {
        return this.rank + " " + this.suit;
    }
}
