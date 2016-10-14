package net.ukr.p454;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 16.09.2016.
 */
public class Dictionary implements IDictionary{

    private Map<String,String> dictionary = new HashMap<>();
    private String name;

    public Dictionary() {

    }

    public Dictionary(Map<String, String> dictionary, String name) {
        this.dictionary = dictionary;
        this.name = name;
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addWord(String key, String value) {
        dictionary.put(key.toUpperCase(),value.toUpperCase());
    }

    @Override
    public void removeWord(String key) {
        if (dictionary.containsKey(key.toUpperCase())){
        dictionary.remove(key.toUpperCase());
        }else {
            System.err.println(key + " isn't in the dicionary " + name);
        }
    }

    @Override
    public void saveDictionary(IDictionaryDAO dictionary) {
        dictionary.saveDictionary(this);
    }

    @Override
    public Dictionary loadDictionary(IDictionaryDAO dictionary) {
        return dictionary.loadDictionary();
    }

    @Override
    public String searchWord(String word) {
        return dictionary.get(word.toUpperCase());
    }

    @Override
    public String toString() {
        return dictionary.toString();
    }
}
