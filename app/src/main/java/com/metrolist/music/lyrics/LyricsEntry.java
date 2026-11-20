package com.metrolist.music.lyrics;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsEntry implements Comparable {
    public static final LyricsEntry HEAD_LYRICS_ENTRY = new LyricsEntry(0, "", null, null, false, 124);
    public final String agent;
    public final boolean isBackground;
    public final MutableStateFlow romanizedTextFlow;
    public final String text;
    public final long time;
    public final MutableStateFlow translatedTextFlow;
    public final List words;

    public LyricsEntry(long j, String str, List list, String str2, boolean z, int i) {
        list = (i & 4) != 0 ? null : list;
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(null);
        StateFlowImpl stateFlowImplMutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        str2 = (i & 32) != 0 ? null : str2;
        z = (i & 64) != 0 ? false : z;
        str.getClass();
        this.time = j;
        this.text = str;
        this.words = list;
        this.romanizedTextFlow = stateFlowImplMutableStateFlow;
        this.translatedTextFlow = stateFlowImplMutableStateFlow2;
        this.agent = str2;
        this.isBackground = z;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        LyricsEntry lyricsEntry = (LyricsEntry) obj;
        lyricsEntry.getClass();
        return (int) (this.time - lyricsEntry.time);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LyricsEntry)) {
            return false;
        }
        LyricsEntry lyricsEntry = (LyricsEntry) obj;
        return this.time == lyricsEntry.time && Intrinsics.areEqual(this.text, lyricsEntry.text) && Intrinsics.areEqual(this.words, lyricsEntry.words) && this.romanizedTextFlow.equals(lyricsEntry.romanizedTextFlow) && this.translatedTextFlow.equals(lyricsEntry.translatedTextFlow) && Intrinsics.areEqual(this.agent, lyricsEntry.agent) && this.isBackground == lyricsEntry.isBackground;
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Long.hashCode(this.time) * 31, 31, this.text);
        List list = this.words;
        int iHashCode = (this.translatedTextFlow.hashCode() + ((this.romanizedTextFlow.hashCode() + ((iM + (list == null ? 0 : list.hashCode())) * 31)) * 31)) * 31;
        String str = this.agent;
        return Boolean.hashCode(this.isBackground) + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "LyricsEntry(time=" + this.time + ", text=" + this.text + ", words=" + this.words + ", romanizedTextFlow=" + this.romanizedTextFlow + ", translatedTextFlow=" + this.translatedTextFlow + ", agent=" + this.agent + ", isBackground=" + this.isBackground + ")";
    }
}
