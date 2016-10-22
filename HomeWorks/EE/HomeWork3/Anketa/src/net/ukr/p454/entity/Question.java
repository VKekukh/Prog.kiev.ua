package net.ukr.p454.entity;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dalvik on 21.10.2016.
 */
public class Question {
    private String question;
    private String answer;
    private List<String> variants = new ArrayList<>();

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<String> getVariants() {
        return variants;
    }

    public void addVariants(String ... list){
        List<String> arList = new ArrayList<>();

        for (String s : list) {
            arList.add(s);
        }
        variants = arList;
    }

    public void addVariant(String variant) {
        variants.add(variant);
    }


    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer=" + answer +
                '}';
    }
}
