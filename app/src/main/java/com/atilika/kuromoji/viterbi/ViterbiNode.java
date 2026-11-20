package com.atilika.kuromoji.viterbi;

import com.atilika.kuromoji.dict.Dictionary;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ViterbiNode {
    private final int leftId;
    private ViterbiNode leftNode;
    private int pathCost;
    private final int rightId;
    private final int startIndex;
    private final String surface;
    private final Type type;
    private final int wordCost;
    private final int wordId;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public enum Type {
        KNOWN,
        UNKNOWN,
        USER,
        INSERTED
    }

    public ViterbiNode(int i, String str, Dictionary dictionary, int i2, Type type) {
        this(i, str, dictionary.getLeftId(i), dictionary.getRightId(i), dictionary.getWordCost(i), i2, type);
    }

    public int getLeftId() {
        return this.leftId;
    }

    public ViterbiNode getLeftNode() {
        return this.leftNode;
    }

    public int getPathCost() {
        return this.pathCost;
    }

    public int getRightId() {
        return this.rightId;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public String getSurface() {
        return this.surface;
    }

    public Type getType() {
        return this.type;
    }

    public int getWordCost() {
        return this.wordCost;
    }

    public int getWordId() {
        return this.wordId;
    }

    public void setLeftNode(ViterbiNode viterbiNode) {
        this.leftNode = viterbiNode;
    }

    public void setPathCost(int i) {
        this.pathCost = i;
    }

    public ViterbiNode(int i, String str, int i2, int i3, int i4, int i5, Type type) {
        this.wordId = i;
        this.surface = str;
        this.leftId = i2;
        this.rightId = i3;
        this.wordCost = i4;
        this.startIndex = i5;
        this.type = type;
    }
}
