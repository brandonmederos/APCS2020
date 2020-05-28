package controller;

import java.util.Arrays;
import java.util.ArrayList;

public class QuestionList {
	
	//The list of given questions with their answers 
	public static Question[] qList1 = new Question[] {
			new Question("USA", "What's the most common Acrynym for The United States of America *DO NOT USE: . *"),
			new Question("Go", "What do you do at Green Traffic Light"),
			new Question("Mitochondria", "What is the Powerhouse of the Cell?"),
			new Question("BC", "What is the Highest Calculus offered at TERRA"),
			new Question("3", "What is x in: 5 = x + 2 "), 
			new Question("10", "What is the greater number 5 or 10"),
			new Question("Homo", "Pane and Pain are? _._._._phone"),
			new Question("iffel", "Fill in the Blank: The E_._._._._ tower"),
			new Question("Place", "Fill in the Blank: Wizards of Waverly _._._._._"),
			new Question("line", "The Quickest way from point A to B is a straight _._._._"),
			new Question("1", "The First Positive Integer is"),
			new Question("no", "Is Negative greater than Positive: YES or NO"),
			new Question("pisa", "Fill in the Blank: Leaning Tower of _._._._"),
			new Question("YES", "Should Med get an A: YES or YES *ps this is Q13") };
	
	private static ArrayList<Question> qList2= new ArrayList<Question>(Arrays.asList(QuestionList.qList1));

	//Getter for the qList2 variable
	public static ArrayList<Question> getQList() {
		return QuestionList.qList2;
	}

	public QuestionList() {
		getQList();
	}
}
