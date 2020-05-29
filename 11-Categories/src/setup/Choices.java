
package setup;
/*
 * This Enum class creates custom variables that store a name and number
 */
public enum Choices{
	
    SWORD("SWORD", 0), 
    PEN("PEN", 1), 
    SCROLL("SCROLL", 2), 
    SHIELD("SHIELD", 3), 
    MACE("MACE", 4);
    
    public static boolean tie;
    
    private Choices(String name, int num) {
    }
    
    /*
     * This method is used to determine whether or not a specific object beats another or if it is
     * a tie(if tie the method returns true)
     */
    public boolean beats(Choices p) {
        if (this == p) {
            tie = true;
        }
        boolean win = false;
        if (this == SWORD && (p == SCROLL || p == MACE)) {
            win = true;
        }
        if (this == PEN && (p == SWORD || p == SCROLL)) {
            win = true;
        }
        if (this == SCROLL && (p == MACE || p == SHIELD)) {
            win = true;
        }
        if (this == SHIELD && (p == SHIELD || p == PEN)) {
            win = true;
        }
        if (this == MACE && (p == SHIELD || p == PEN)) {
            win = true;
        }
        return win;
    }
}
