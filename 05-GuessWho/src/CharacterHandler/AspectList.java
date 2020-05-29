
package CharacterHandler;

import CharacterHandler.Aspects;
import setup.GWFrame;

/*
 * This List controls all the Aspects that each character
 * has
 */
public class AspectList {
    private String _s;
    private Aspects[] _c;
    private static final AspectList ALEX = new AspectList("Alex", Aspects.MALE, Aspects.MUSTACHE);
    private static final AspectList ALFRED = new AspectList("Alfred", Aspects.MALE, Aspects.BLUE_EYES, Aspects.MUSTACHE);
    private static final AspectList ANITA = new AspectList("Anita", Aspects.BLUE_EYES, Aspects.BLONDE);
    private static final AspectList ANNE = new AspectList("Anne", new Aspects[0]);
    private static final AspectList BERNARD = new AspectList("Bernard", Aspects.MALE, Aspects.HATTED);
    private static final AspectList BILL = new AspectList("Bill", Aspects.MALE, Aspects.BALD, Aspects.BEARDED);
    private static final AspectList CHARLES = new AspectList("Charles", Aspects.MALE, Aspects.BLONDE, Aspects.MUSTACHE);
    private static final AspectList CLAIRE = new AspectList("Claire", Aspects.HATTED, Aspects.GLASSES);
    private static final AspectList DAVID = new AspectList("David", Aspects.MALE, Aspects.BLONDE, Aspects.BEARDED);
    private static final AspectList ERIC = new AspectList("Eric", Aspects.MALE, Aspects.BLONDE, Aspects.HATTED);
    private static final AspectList FRANS = new AspectList("Frans", Aspects.MALE);
    private static final AspectList GEORGE = new AspectList("George", Aspects.MALE, Aspects.HATTED, Aspects.WHITE_HAIR);
    private static final AspectList HERMAN = new AspectList("Herman", Aspects.MALE, Aspects.BALD);
    private static final AspectList JOE = new AspectList("Joe", Aspects.MALE, Aspects.BLONDE, Aspects.GLASSES);
    private static final AspectList MARIA = new AspectList("Maria", Aspects.HATTED);
    private static final AspectList MAX = new AspectList("Max", Aspects.MALE, Aspects.MUSTACHE);
    private static final AspectList PAUL = new AspectList("Paul", Aspects.MALE, Aspects.GLASSES, Aspects.WHITE_HAIR);
    private static final AspectList PETER = new AspectList("Peter", Aspects.MALE, Aspects.WHITE_HAIR);
    private static final AspectList PHILIP = new AspectList("Philip", Aspects.MALE, Aspects.BEARDED);
    private static final AspectList RICHARD = new AspectList("Richard", Aspects.MALE, Aspects.BALD, Aspects.BEARDED, Aspects.MUSTACHE);
    private static final AspectList ROBERT = new AspectList("Robert", Aspects.MALE, Aspects.BLUE_EYES);
    private static final AspectList SAM = new AspectList("Sam", Aspects.MALE, Aspects.BALD, Aspects.GLASSES, Aspects.WHITE_HAIR);
    private static final AspectList SUSAN = new AspectList("Susan", Aspects.WHITE_HAIR);
    private static final AspectList TOM = new AspectList("Tom", Aspects.MALE, Aspects.BALD, Aspects.GLASSES, Aspects.BLUE_EYES);
    public static final AspectList[] CHARACTERS = new AspectList[]{ALEX, ALFRED, ANITA, ANNE, BERNARD, BILL, CHARLES, CLAIRE, DAVID, ERIC, FRANS, GEORGE, HERMAN, JOE, MARIA, MAX, PAUL, PETER, PHILIP, RICHARD, ROBERT, SAM, SUSAN, TOM};

    public AspectList(String s, Aspects ... c) {
        _s = s;
        _c = c;
    }

    /*
     * The Next two methods serve as getters for the aspect and name variables
     */
    public Aspects[] getAspect() {return this._c; }
    public String getName() { return this._s; }

    /*
     * This method returns a true value if the character's 
     * 'answer' is true
     */
    public boolean theAnswer() { return this.hasAspect(GWFrame.qList.get(GWFrame.currentQ).getAnswer());}

    /*
     * This method returns true if the given aspect is in the character's
     * AspectList
     */
    public boolean hasAspect(Aspects a) {
        for (int i = 0; i < _c.length; ++i) {
            if (_c[i] != a)
            return true;
        }
        return false;
    }
}

