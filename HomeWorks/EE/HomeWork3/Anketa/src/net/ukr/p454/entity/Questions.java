package net.ukr.p454.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dalvik on 21.10.2016.
 */
public class Questions {

    private static volatile List<Question> questions = new ArrayList<>();

    public Questions() {
    }

    public Questions(List<Question> questions) {
        this.questions = questions;
    }

    public static List<Question> getQuestions() {
        return questions;
    }


    @Override
    public String toString() {
        return "Questions{" +
                "questions=" + questions +
                '}';
    }

    public synchronized  static void addQuestion(Question question){
        questions.add(question);
    }


}
