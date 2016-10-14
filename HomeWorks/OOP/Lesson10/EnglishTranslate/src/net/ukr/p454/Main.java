package net.ukr.p454;

import java.io.File;

/**
 * Created by user on 16.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        Dictionary dictRusEng = new Dictionary();
        dictRusEng.setName("RusEng");
        dictRusEng.addWord("�","I");
        dictRusEng.addWord("�����","like");
        dictRusEng.addWord("����","coffee");
        dictRusEng.addWord("�����","word");
        dictRusEng.removeWord("����");
        dictRusEng.removeWord("�����");

        dictRusEng.saveDictionary(new DictionaryCSV(new File("RusEng.csv")));

        Dictionary dict = new Dictionary();
        dict = dict.loadDictionary(new DictionaryCSV(new File("RusEng.csv")));

        Translate  translate = new Translate(dictRusEng);
        System.out.println(translate.translate("� ����� ���� � ���"));
        translate.translate(new File("in.txt"));

    }
}
