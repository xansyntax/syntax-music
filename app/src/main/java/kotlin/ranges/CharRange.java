package kotlin.ranges;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class CharRange implements Iterable, KMappedMarker {
    public final char first;
    public final char last;

    static {
        new CharRange((char) 1, (char) 0);
    }

    public CharRange(char c, char c2) {
        this.first = c;
        this.last = (char) UuidKt.getProgressionLastElement(c, c2, 1);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CharRange)) {
            return false;
        }
        char c = this.first;
        char c2 = this.last;
        if (c > c2) {
            CharRange charRange = (CharRange) obj;
            if (charRange.first > charRange.last) {
                return true;
            }
        }
        CharRange charRange2 = (CharRange) obj;
        return c == charRange2.first && c2 == charRange2.last;
    }

    public final int hashCode() {
        char c = this.first;
        char c2 = this.last;
        if (c > c2) {
            return -1;
        }
        return (c * 31) + c2;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new CharProgressionIterator(this.first, this.last);
    }

    public final String toString() {
        return this.first + ".." + this.last;
    }
}
