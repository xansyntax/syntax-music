package kotlin.text;

import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class MatchGroup {
    public final IntRange range;
    public final String value;

    public MatchGroup(String str, IntRange intRange) {
        this.value = str;
        this.range = intRange;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchGroup)) {
            return false;
        }
        MatchGroup matchGroup = (MatchGroup) obj;
        return this.value.equals(matchGroup.value) && this.range.equals(matchGroup.range);
    }

    public final int hashCode() {
        return this.range.hashCode() + (this.value.hashCode() * 31);
    }

    public final String toString() {
        return "MatchGroup(value=" + this.value + ", range=" + this.range + ')';
    }
}
