package kotlinx.serialization.json.internal;

import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ArrayAsSequence implements CharSequence {
    public final char[] buffer;
    public int length;

    public ArrayAsSequence(char[] cArr) {
        this.buffer = cArr;
        this.length = cArr.length;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.buffer[i];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.length;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return StringsKt__StringsJVMKt.concatToString(this.buffer, i, Math.min(i2, this.length));
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        int i = this.length;
        return StringsKt__StringsJVMKt.concatToString(this.buffer, 0, Math.min(i, i));
    }
}
