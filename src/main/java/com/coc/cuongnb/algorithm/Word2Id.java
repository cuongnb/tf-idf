package com.coc.cuongnb.algorithm;

import java.util.List;

/**
 * Created by cuongnb on 26/07/2017.
 */
public class Word2Id {
    List<String> vocab;

    public Word2Id(List<String> vocab) {
        this.vocab = vocab;
    }

    public int[] getId(String[] doc) {
        int[] result = new int[doc.length];
        for (int n = 0; n < doc.length; n++) {
            result[n] = vocab.indexOf(doc[n]);
        }
        return result;
    }

    public String[] getDoc(int[] ids) {
        String[] doc = new String[ids.length];
        for (int n = 0; n < ids.length; n++) {
            doc[n] = vocab.get(n);
        }
        return doc;
    }
}
