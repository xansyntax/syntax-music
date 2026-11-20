package com.metrolist.music.ui.component;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HyphenGroupWord {
    public final long groupEndMs;
    public final long groupStartMs;
    public final boolean isLast;
    public final int pos;
    public final int size;

    public HyphenGroupWord(int i, int i2, boolean z, long j, long j2) {
        this.pos = i;
        this.size = i2;
        this.isLast = z;
        this.groupStartMs = j;
        this.groupEndMs = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HyphenGroupWord)) {
            return false;
        }
        HyphenGroupWord hyphenGroupWord = (HyphenGroupWord) obj;
        return this.pos == hyphenGroupWord.pos && this.size == hyphenGroupWord.size && this.isLast == hyphenGroupWord.isLast && this.groupStartMs == hyphenGroupWord.groupStartMs && this.groupEndMs == hyphenGroupWord.groupEndMs;
    }

    public final int hashCode() {
        return Long.hashCode(this.groupEndMs) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.size, Integer.hashCode(this.pos) * 31, 31), this.isLast, 31), 31, this.groupStartMs);
    }

    public final String toString() {
        StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(this.pos, "HyphenGroupWord(pos=", ", size=", this.size, ", isLast=");
        sbM3m.append(this.isLast);
        sbM3m.append(", groupStartMs=");
        sbM3m.append(this.groupStartMs);
        sbM3m.append(", groupEndMs=");
        sbM3m.append(this.groupEndMs);
        sbM3m.append(")");
        return sbM3m.toString();
    }
}
