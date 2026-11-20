package com.metrolist.music.lyrics;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/lyrics/LyricLine;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
final /* data */ class LyricLine {
    public final long duration;
    public final LineElement element;
    public final List syllabus;
    public final String text;
    public final long time;
    public final Translation translation;
    public final Transliteration transliteration;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new LyricLine$$ExternalSyntheticLambda0((byte) 0)), null, null, null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/lyrics/LyricLine$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/lyrics/LyricLine;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return LyricLine$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ LyricLine(int i, long j, long j2, String str, List list, LineElement lineElement, Translation translation, Transliteration transliteration) {
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
            this.syllabus = null;
        } else {
            this.syllabus = list;
        }
        if ((i & 16) == 0) {
            this.element = null;
        } else {
            this.element = lineElement;
        }
        if ((i & 32) == 0) {
            this.translation = null;
        } else {
            this.translation = translation;
        }
        if ((i & 64) == 0) {
            this.transliteration = null;
        } else {
            this.transliteration = transliteration;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LyricLine)) {
            return false;
        }
        LyricLine lyricLine = (LyricLine) obj;
        return this.time == lyricLine.time && this.duration == lyricLine.duration && Intrinsics.areEqual(this.text, lyricLine.text) && Intrinsics.areEqual(this.syllabus, lyricLine.syllabus) && Intrinsics.areEqual(this.element, lyricLine.element) && Intrinsics.areEqual(this.translation, lyricLine.translation) && Intrinsics.areEqual(this.transliteration, lyricLine.transliteration);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.time) * 31, 31, this.duration), 31, this.text);
        List list = this.syllabus;
        int iHashCode = (iM + (list == null ? 0 : list.hashCode())) * 31;
        LineElement lineElement = this.element;
        int iHashCode2 = (iHashCode + (lineElement == null ? 0 : lineElement.hashCode())) * 31;
        Translation translation = this.translation;
        int iHashCode3 = (iHashCode2 + (translation == null ? 0 : translation.hashCode())) * 31;
        Transliteration transliteration = this.transliteration;
        return iHashCode3 + (transliteration != null ? transliteration.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(this.time, "LyricLine(time=", ", duration=");
        sbM.append(this.duration);
        sbM.append(", text=");
        sbM.append(this.text);
        sbM.append(", syllabus=");
        sbM.append(this.syllabus);
        sbM.append(", element=");
        sbM.append(this.element);
        sbM.append(", translation=");
        sbM.append(this.translation);
        sbM.append(", transliteration=");
        sbM.append(this.transliteration);
        sbM.append(")");
        return sbM.toString();
    }
}
