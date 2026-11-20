package com.atilika.kuromoji.compile;

import com.atilika.kuromoji.io.IntegerArrayIO;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class WordIdMapCompiler implements Compiler {
    private int[] indices;
    private int[][] wordIds = new int[1][];
    private GrowableIntArray wordIdArray = new GrowableIntArray();

    public void addMapping(int i, int i2) {
        int[] iArr;
        int[][] iArr2 = this.wordIds;
        if (iArr2.length <= i) {
            int[][] iArr3 = new int[i + 1][];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            this.wordIds = iArr3;
            iArr2 = iArr3;
        }
        int[] iArr4 = iArr2[i];
        if (iArr4 == null) {
            iArr = new int[1];
        } else {
            int[] iArr5 = new int[iArr4.length + 1];
            System.arraycopy(iArr4, 0, iArr5, 0, iArr4.length);
            iArr = iArr5;
        }
        this.wordIds[i] = iArr;
        iArr[iArr.length - 1] = i2;
    }

    @Override // com.atilika.kuromoji.compile.Compiler
    public void compile() {
        this.indices = new int[this.wordIds.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            int[][] iArr = this.wordIds;
            if (i >= iArr.length) {
                return;
            }
            int[] iArr2 = iArr[i];
            int[] iArr3 = this.indices;
            if (iArr2 == null) {
                iArr3[i] = -1;
            } else {
                iArr3[i] = i2;
                this.wordIdArray.set(i2, iArr2.length);
                int i3 = 0;
                i2++;
                while (i3 < iArr2.length) {
                    this.wordIdArray.set(i2, iArr2[i3]);
                    i3++;
                    i2++;
                }
            }
            i++;
        }
    }

    public void write(OutputStream outputStream) throws IOException {
        compile();
        IntegerArrayIO.writeArray(outputStream, this.indices);
        IntegerArrayIO.writeArray(outputStream, this.wordIdArray.getArray());
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static class GrowableIntArray {
        private static final float ARRAY_GROWTH_RATE = 1.25f;
        private static final int ARRAY_INITIAL_SIZE = 1024;
        private int[] array;
        private int maxIndex;

        public GrowableIntArray(int i) {
            this.array = new int[i];
            this.maxIndex = 0;
        }

        private int getNewLength(int i) {
            return (int) Math.max(i + 1, this.array.length * ARRAY_GROWTH_RATE);
        }

        private void grow(int i) {
            int[] iArr = new int[i];
            System.arraycopy(this.array, 0, iArr, 0, this.maxIndex + 1);
            this.array = iArr;
        }

        public int[] getArray() {
            int i = this.maxIndex + 1;
            int[] iArr = new int[i];
            System.arraycopy(this.array, 0, iArr, 0, i);
            return iArr;
        }

        public void set(int i, int i2) {
            if (i >= this.array.length) {
                grow(getNewLength(i));
            }
            if (i > this.maxIndex) {
                this.maxIndex = i;
            }
            this.array[i] = i2;
        }

        public GrowableIntArray() {
            this(ARRAY_INITIAL_SIZE);
        }
    }
}
