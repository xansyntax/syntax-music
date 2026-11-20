package com.metrolist.music.betterlyrics;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class TTMLParser$ParsedLine {
    public final String agent;
    public final List backgroundLines;
    public final boolean isBackground;
    public final double startTime;
    public final String text;
    public final List words;

    public TTMLParser$ParsedLine(String str, double d, List list, String str2, boolean z, List list2) {
        str.getClass();
        this.text = str;
        this.startTime = d;
        this.words = list;
        this.agent = str2;
        this.isBackground = z;
        this.backgroundLines = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TTMLParser$ParsedLine)) {
            return false;
        }
        TTMLParser$ParsedLine tTMLParser$ParsedLine = (TTMLParser$ParsedLine) obj;
        return Intrinsics.areEqual(this.text, tTMLParser$ParsedLine.text) && Double.compare(this.startTime, tTMLParser$ParsedLine.startTime) == 0 && Intrinsics.areEqual(this.words, tTMLParser$ParsedLine.words) && Intrinsics.areEqual(this.agent, tTMLParser$ParsedLine.agent) && this.isBackground == tTMLParser$ParsedLine.isBackground && Intrinsics.areEqual(this.backgroundLines, tTMLParser$ParsedLine.backgroundLines);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.startTime, this.text.hashCode() * 31, 31), 31, this.words);
        String str = this.agent;
        return this.backgroundLines.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m((iM + (str == null ? 0 : str.hashCode())) * 31, this.isBackground, 31);
    }

    public final String toString() {
        return "ParsedLine(text=" + this.text + ", startTime=" + this.startTime + ", words=" + this.words + ", agent=" + this.agent + ", isBackground=" + this.isBackground + ", backgroundLines=" + this.backgroundLines + ")";
    }
}
