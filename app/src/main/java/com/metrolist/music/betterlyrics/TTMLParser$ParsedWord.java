package com.metrolist.music.betterlyrics;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TTMLParser$ParsedWord {
    public final double endTime;
    public final boolean hasTrailingSpace;
    public final double startTime;
    public final String text;

    public TTMLParser$ParsedWord(String str, double d, double d2, boolean z) {
        this.text = str;
        this.startTime = d;
        this.endTime = d2;
        this.hasTrailingSpace = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TTMLParser$ParsedWord)) {
            return false;
        }
        TTMLParser$ParsedWord tTMLParser$ParsedWord = (TTMLParser$ParsedWord) obj;
        return this.text.equals(tTMLParser$ParsedWord.text) && Double.compare(this.startTime, tTMLParser$ParsedWord.startTime) == 0 && Double.compare(this.endTime, tTMLParser$ParsedWord.endTime) == 0 && this.hasTrailingSpace == tTMLParser$ParsedWord.hasTrailingSpace;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.hasTrailingSpace) + Fragment$5$$ExternalSyntheticOutline0.m(this.endTime, Fragment$5$$ExternalSyntheticOutline0.m(this.startTime, this.text.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ParsedWord(text=");
        sb.append(this.text);
        sb.append(", startTime=");
        sb.append(this.startTime);
        sb.append(", endTime=");
        sb.append(this.endTime);
        sb.append(", hasTrailingSpace=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.hasTrailingSpace, ")");
    }
}
