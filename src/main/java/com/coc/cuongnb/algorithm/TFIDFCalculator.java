package com.coc.cuongnb.algorithm;

import java.util.List;

/**
 * Created by cuongnb on 26/07/2017.
 */
public class TFIDFCalculator {
    int V;

    public TFIDFCalculator(int V) {
        this.V = V;
    }

    public double tf(List<Integer> doc, int term) {
        double result = 0;
        for (int word : doc) {
            if (term == word)
                result++;
        }
        return result / (doc.size() * 1.0);
    }


    public double[] idf(List<List<Integer>> docs) {
        double[] result = new double[V];
        for (int n = 0; n < result.length; n++) {
            result[n] = 0;
        }

        for (int term = 0; term < V; term++) {
            for (List<Integer> doc : docs) {
                for (int word : doc) {
                    if (term == word) {
                        result[term]++;
                        break;
                    }
                }
            }
        }

        for (int n = 0; n < result.length; n++) {
            result[n] /= (docs.size() * 1.0);
        }
        return result;
    }
}
