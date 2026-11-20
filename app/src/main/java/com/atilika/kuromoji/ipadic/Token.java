package com.atilika.kuromoji.ipadic;

import com.atilika.kuromoji.TokenBase;
import com.atilika.kuromoji.dict.Dictionary;
import com.atilika.kuromoji.viterbi.ViterbiNode;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class Token extends TokenBase {
    public Token(int i, String str, ViterbiNode.Type type, int i2, Dictionary dictionary) {
        super(i, str, type, i2, dictionary);
    }

    public String getBaseForm() {
        return getFeature(10);
    }

    public String getConjugationForm() {
        return getFeature(9);
    }

    public String getConjugationType() {
        return getFeature(8);
    }

    public String getPartOfSpeechLevel1() {
        return getFeature(4);
    }

    public String getPartOfSpeechLevel2() {
        return getFeature(5);
    }

    public String getPartOfSpeechLevel3() {
        return getFeature(6);
    }

    public String getPartOfSpeechLevel4() {
        return getFeature(7);
    }

    public String getPronunciation() {
        return getFeature(12);
    }

    public String getReading() {
        return getFeature(11);
    }
}
