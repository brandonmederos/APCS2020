
package QuestionHandling;

import CharacterHandler.Aspects;

/*
 * This class creates a custom Question object which contains the answer
 * and a String 'question' 
 */
public class Question {
    private Aspects _c;
    private String Question = "";

    public Question(Aspects ans, String q) {
        _c = ans;
        Question = q;
    }

    public String getQuestion() {
        return Question;
    }

    public Aspects getAnswer() {
        return _c;
    }
}

