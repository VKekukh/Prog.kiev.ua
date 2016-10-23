package net.ukr.p454.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dalvik on 22.10.2016.
 */

public class Answers {

    private static volatile  Map<Question, Map<String,Integer>> answers = new HashMap<>();

    public synchronized static void addAnswer (Question question, String answer){
        Map<String,Integer> map  = answers.get(question);
        map.put(answer, map.get(answer)+1);
        answers.put(question, map);
    }

    public static void init (){
        List<Question> list = Questions.getQuestions();

        for (Question question : list) {
            Map<String,Integer> maps = new HashMap<>();
            for (String s : question.getVariants()) {
                maps.put(s,0);
            }
            answers.put(question,maps);
        }
    }

    public static Map<Question, Map<String, Integer>> getAnswers() {
        return answers;
    }
}
