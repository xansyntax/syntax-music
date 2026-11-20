package com.atilika.kuromoji;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.dict.Dictionary;
import com.atilika.kuromoji.viterbi.ViterbiNode;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TokenBase {
    private static final int META_DATA_SIZE = 4;
    private final Dictionary dictionary;
    private final int position;
    private final String surface;
    private final ViterbiNode.Type type;
    private final int wordId;

    public TokenBase(int i, String str, ViterbiNode.Type type, int i2, Dictionary dictionary) {
        this.wordId = i;
        this.surface = str;
        this.type = type;
        this.position = i2;
        this.dictionary = dictionary;
    }

    public String getAllFeatures() {
        return this.dictionary.getAllFeatures(this.wordId);
    }

    public String[] getAllFeaturesArray() {
        return this.dictionary.getAllFeaturesArray(this.wordId);
    }

    public String getFeature(int i) {
        return this.dictionary.getFeature(this.wordId, i - 4);
    }

    public int getPosition() {
        return this.position;
    }

    public String getSurface() {
        return this.surface;
    }

    public boolean isKnown() {
        return this.type == ViterbiNode.Type.KNOWN;
    }

    public boolean isUser() {
        return this.type == ViterbiNode.Type.USER;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Token{surface='");
        sb.append(this.surface);
        sb.append("', position=");
        sb.append(this.position);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", dictionary=");
        sb.append(this.dictionary);
        sb.append(", wordId=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.wordId, '}');
    }
}
