package com.coc.cuongnb;

import com.coc.cuongnb.algorithm.TFIDFCalculator;
import com.coc.cuongnb.algorithm.Word2Id;
import com.coc.cuongnb.preprocess.DataProcess;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cuongnb on 26/07/2017.
 */
public class Main {
    public static void main(String[] args) {
        String doc1 = "Lorem ipsum dolor ipsum sit ipsum";
        String doc2 = "Vituperata  incorrupte  at  ipsum  pro  quo";
        String doc3 = "Has  persius  disputationi  id  simul";
        String[] doc1s = doc1.split(" ");
        String[] doc2s = doc2.split(" ");
        String[] doc3s = doc3.split(" ");
        DataProcess dataProcess = new DataProcess();
        dataProcess.readDoc(doc1s);
        dataProcess.readDoc(doc2s);
        dataProcess.readDoc(doc3s);

        TFIDFCalculator calculator = new TFIDFCalculator(dataProcess.vocab.size());
        Word2Id word2Id = new Word2Id(dataProcess.vocab);

        double[] idf = calculator.idf(dataProcess.docs);
        double tf = calculator.tf(dataProcess.docs.get(0), 1);
        double tfidf = tf * idf[1];
        int[] ids1 = word2Id.getId(doc1s);
        for (int n = 0; n < ids1.length; n++) {
            System.out.println("TF-IDF " + doc1s[n] + " = " + (calculator.tf(dataProcess.docs.get(0), n) * idf[n]));
        }

    }
}
