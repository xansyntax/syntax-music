package com.atilika.kuromoji.buffer;

import com.atilika.kuromoji.io.IntegerArrayIO;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class WordIdMap {
    private final int[] empty = new int[0];
    private final int[] indices;
    private final int[] wordIds;

    public WordIdMap(InputStream inputStream) {
        this.indices = IntegerArrayIO.readArray(inputStream);
        this.wordIds = IntegerArrayIO.readArray(inputStream);
    }

    public int[] lookUp(int i) {
        int i2 = this.indices[i];
        if (i2 == -1) {
            return this.empty;
        }
        int[] iArr = this.wordIds;
        int i3 = i2 + 1;
        return Arrays.copyOfRange(iArr, i3, iArr[i2] + i3);
    }
}
