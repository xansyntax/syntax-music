package com.atilika.kuromoji.dict;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DictionaryEntryBase {
    protected final short leftId;
    protected final short rightId;
    protected final String surface;
    protected final short wordCost;

    public DictionaryEntryBase(String str, short s, short s2, short s3) {
        this.surface = str;
        this.leftId = s;
        this.rightId = s2;
        this.wordCost = s3;
    }

    public short getLeftId() {
        return this.leftId;
    }

    public short getRightId() {
        return this.rightId;
    }

    public String getSurface() {
        return this.surface;
    }

    public short getWordCost() {
        return this.wordCost;
    }
}
