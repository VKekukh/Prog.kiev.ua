package net.ukr.p454;

/**
 * Created by user on 16.09.2016.
 */
public interface IDictionaryDAO {

    void saveDictionary(Dictionary dictionary);
    Dictionary loadDictionary();

}
