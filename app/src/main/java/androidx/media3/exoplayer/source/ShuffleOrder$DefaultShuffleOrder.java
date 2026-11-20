package androidx.media3.exoplayer.source;

import java.util.Arrays;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ShuffleOrder$DefaultShuffleOrder {
    public final int[] indexInShuffled;
    public final Random random;
    public final int[] shuffled;

    public ShuffleOrder$DefaultShuffleOrder(int[] iArr, Random random) {
        this.shuffled = iArr;
        this.random = random;
        this.indexInShuffled = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            this.indexInShuffled[iArr[i]] = i;
        }
    }

    public final ShuffleOrder$DefaultShuffleOrder cloneAndInsert(int i, int i2) {
        int[] iArr;
        Random random;
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[i2];
        int i3 = 0;
        while (true) {
            iArr = this.shuffled;
            random = this.random;
            if (i3 >= i2) {
                break;
            }
            iArr2[i3] = random.nextInt(iArr.length + 1);
            int i4 = i3 + 1;
            int iNextInt = random.nextInt(i4);
            iArr3[i3] = iArr3[iNextInt];
            iArr3[iNextInt] = i3 + i;
            i3 = i4;
        }
        Arrays.sort(iArr2);
        int[] iArr4 = new int[iArr.length + i2];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < iArr.length + i2; i7++) {
            if (i5 >= i2 || i6 != iArr2[i5]) {
                int i8 = i6 + 1;
                int i9 = iArr[i6];
                iArr4[i7] = i9;
                if (i9 >= i) {
                    iArr4[i7] = i9 + i2;
                }
                i6 = i8;
            } else {
                iArr4[i7] = iArr3[i5];
                i5++;
            }
        }
        return new ShuffleOrder$DefaultShuffleOrder(iArr4, new Random(random.nextLong()));
    }

    public ShuffleOrder$DefaultShuffleOrder(int[] iArr, long j) {
        this(Arrays.copyOf(iArr, iArr.length), new Random(j));
    }

    public ShuffleOrder$DefaultShuffleOrder() {
        this(new Random());
    }

    public ShuffleOrder$DefaultShuffleOrder(Random random) {
        this(new int[0], random);
    }
}
