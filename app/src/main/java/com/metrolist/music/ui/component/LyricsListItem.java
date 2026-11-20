package com.metrolist.music.ui.component;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.metrolist.music.lyrics.LyricsEntry;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LyricsListItem {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Indicator extends LyricsListItem {
        public final int afterLineIndex;
        public final long gapEndMs;
        public final long gapMs;
        public final long gapStartMs;
        public final String nextAgent;

        public Indicator(int i, long j, long j2, long j3, String str) {
            this.afterLineIndex = i;
            this.gapMs = j;
            this.gapStartMs = j2;
            this.gapEndMs = j3;
            this.nextAgent = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Indicator)) {
                return false;
            }
            Indicator indicator = (Indicator) obj;
            return this.afterLineIndex == indicator.afterLineIndex && this.gapMs == indicator.gapMs && this.gapStartMs == indicator.gapStartMs && this.gapEndMs == indicator.gapEndMs && Intrinsics.areEqual(this.nextAgent, indicator.nextAgent);
        }

        public final int hashCode() {
            int iM = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Integer.hashCode(this.afterLineIndex) * 31, 31, this.gapMs), 31, this.gapStartMs), 31, this.gapEndMs);
            String str = this.nextAgent;
            return iM + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            return "Indicator(afterLineIndex=" + this.afterLineIndex + ", gapMs=" + this.gapMs + ", gapStartMs=" + this.gapStartMs + ", gapEndMs=" + this.gapEndMs + ", nextAgent=" + this.nextAgent + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Line extends LyricsListItem {
        public final LyricsEntry entry;
        public final int index;

        static {
            LyricsEntry lyricsEntry = LyricsEntry.HEAD_LYRICS_ENTRY;
        }

        public Line(int i, LyricsEntry lyricsEntry) {
            this.index = i;
            this.entry = lyricsEntry;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Line)) {
                return false;
            }
            Line line = (Line) obj;
            return this.index == line.index && this.entry.equals(line.entry);
        }

        public final int hashCode() {
            return this.entry.hashCode() + (Integer.hashCode(this.index) * 31);
        }

        public final String toString() {
            return "Line(index=" + this.index + ", entry=" + this.entry + ")";
        }
    }
}
