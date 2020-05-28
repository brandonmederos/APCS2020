package controller;

public class Question
{
    private String Answer;
    private String Question;
    
    public Question(final String a, final String q) {
        this.Answer = "";
        this.Question = "";
        this.Answer = a;
        this.Question = q;
    }
    
    public String getQuestion() {
        return this.Question;
    }
    
    public String getAnswer() {
        return this.Answer;
    }
}
