package com.coc.cuongnb.preprocess;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuongnb on 26/07/2017.
 */
public class DataProcess {
    private String[] stopword = ("anh va em").split(" ");
    public List<String> vocab = new ArrayList<String>();
    public List<List<Integer>> docs = new ArrayList<List<Integer>>();

    public void readDoc(String[] doc) {
        List<Integer> ids = new ArrayList<Integer>();
        for (String word : doc) {
            if (!isStopWord(word)) {
                int index = getIdWord(word);
                if (index == vocab.size()) {
                    vocab.add(word);
                }
                ids.add(index);
            }
        }
        docs.add(ids);
    }

    private Boolean isStopWord(String word) {
        for (String sWord : stopword) {
            if (sWord.equalsIgnoreCase(word))
                return true;
        }
        return false;
    }

    private int getIdWord(String word) {
        int n = 0;
        for (n = 0; n < vocab.size(); n++) {
            if (word.equalsIgnoreCase(vocab.get(n)))
                return n;
        }
        return n;
    }

    public List<String> getVocab() {
        return vocab;
    }
}
