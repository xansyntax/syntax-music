package com.metrolist.music.lyrics;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/lyrics/LyricWord;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
final /* data */ class LyricWord {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final long duration;
    public final boolean isBackground;
    public final String text;
    public final long time;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/lyrics/LyricWord$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/lyrics/LyricWord;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return LyricWord$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ LyricWord(int i, long j, long j2, String str, boolean z) {
        if ((i & 1) == 0) {
            this.time = 0L;
        } else {
            this.time = j;
        }
        if ((i & 2) == 0) {
            this.duration = 0L;
        } else {
            this.duration = j2;
        }
        if ((i & 4) == 0) {
            this.text = "";
        } else {
            this.text = str;
        }
        if ((i & 8) == 0) {
            this.isBackground = false;
        } else {
            this.isBackground = z;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LyricWord)) {
            return false;
        }
        LyricWord lyricWord = (LyricWord) obj;
        return this.time == lyricWord.time && this.duration == lyricWord.duration && Intrinsics.areEqual(this.text, lyricWord.text) && this.isBackground == lyricWord.isBackground;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.isBackground) + Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.time) * 31, 31, this.duration), 31, this.text);
    }

    public final String toString() {
        StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(this.time, "LyricWord(time=", ", duration=");
        sbM.append(this.duration);
        sbM.append(", text=");
        sbM.append(this.text);
        sbM.append(", isBackground=");
        sbM.append(this.isBackground);
        sbM.append(")");
        return sbM.toString();
    }
}
