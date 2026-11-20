package kotlin.text;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LinesIterator implements Iterator, KMappedMarker {
    public int delimiterLength;
    public int delimiterStartIndex;
    public byte state;
    public final CharSequence string;
    public int tokenStartIndex;

    public LinesIterator(CharSequence charSequence) {
        charSequence.getClass();
        this.string = charSequence;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        int i2;
        byte b = this.state;
        if (b != 0) {
            return b == 1;
        }
        if (this.delimiterLength < 0) {
            this.state = (byte) 2;
            return false;
        }
        CharSequence charSequence = this.string;
        int length = charSequence.length();
        int length2 = charSequence.length();
        for (int i3 = this.tokenStartIndex; i3 < length2; i3++) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i = (cCharAt == '\r' && (i2 = i3 + 1) < charSequence.length() && charSequence.charAt(i2) == '\n') ? 2 : 1;
                length = i3;
                this.state = (byte) 1;
                this.delimiterLength = i;
                this.delimiterStartIndex = length;
                return true;
            }
        }
        i = -1;
        this.state = (byte) 1;
        this.delimiterLength = i;
        this.delimiterStartIndex = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
            return null;
        }
        this.state = (byte) 0;
        int i = this.delimiterStartIndex;
        int i2 = this.tokenStartIndex;
        this.tokenStartIndex = this.delimiterLength + i;
        return this.string.subSequence(i2, i).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
