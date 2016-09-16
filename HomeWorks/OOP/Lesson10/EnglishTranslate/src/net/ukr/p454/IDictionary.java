package net.ukr.p454;

/**
 * Created by user on 16.09.2016.
 */
public interface IDictionary {

    void addWord(String key, String value);
    void removeWord(String key);
    void saveDictionary(IDictionaryDAO dictionary);
    Dictionary loadDictionary(IDictionaryDAO dictionary);
    String searchWord(String word);

}
