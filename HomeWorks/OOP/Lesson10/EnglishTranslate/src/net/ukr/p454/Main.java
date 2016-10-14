package net.ukr.p454;

import java.io.File;

/**
 * Created by user on 16.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        Dictionary dictRusEng = new Dictionary();
        dictRusEng.setName("RusEng");
        dictRusEng.addWord("Я","I");
        dictRusEng.addWord("люблю","like");
        dictRusEng.addWord("кофе","coffee");
        dictRusEng.addWord("слово","word");
        dictRusEng.removeWord("слов");
        dictRusEng.removeWord("слово");

        dictRusEng.saveDictionary(new DictionaryCSV(new File("RusEng.csv")));

        Dictionary dict = new Dictionary();
        dict = dict.loadDictionary(new DictionaryCSV(new File("RusEng.csv")));

        Translate  translate = new Translate(dictRusEng);
        System.out.println(translate.translate("я люблю кофе и чай"));
        translate.translate(new File("in.txt"));

    }
}
