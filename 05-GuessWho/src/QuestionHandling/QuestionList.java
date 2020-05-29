package QuestionHandling;

import CharacterHandler.Aspects;
import QuestionHandling.Question;
import java.util.ArrayList;
import java.util.Arrays;
/*
 * This Class is all the questions and answers
 * for the players
 */
public class QuestionList {
	public static Question[] qList1 = new Question[] { new Question(Aspects.MALE, "Are they a man?"),
			new Question(Aspects.BLUE_EYES, "Do they have blue eyes?"),
			new Question(Aspects.BLONDE, "Do they have blonde hair?"), new Question(Aspects.BALD, "Are they bald?"),
			new Question(Aspects.BEARDED, "Do they have a beard?"),
			new Question(Aspects.MUSTACHE, "Do they have a mustache?"),
			new Question(Aspects.HATTED, "Are they wearing a hat?"),
			new Question(Aspects.GLASSES, "Do they have glasses?"),
			new Question(Aspects.WHITE_HAIR, "Do they have white hair?") };
	private static ArrayList<Question> qList2 = new ArrayList<Question>(Arrays.asList(qList1));

	public QuestionList() {
		QuestionList.getQList();
	}

	public static ArrayList<Question> getQList() {
		return qList2;
	}
}
