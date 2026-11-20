package com.metrolist.paxsenix.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.shazamkit.Shazam$$ExternalSyntheticLambda0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/paxsenix/models/LyricsContent;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class LyricsContent {
    public static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final boolean background;
    public final List backgroundText;
    public final long duration;
    public final long endtime;
    public final boolean oppositeTurn;
    public final String structure;
    public final List text;
    public final long timestamp;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/paxsenix/models/LyricsContent$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/paxsenix/models/LyricsContent;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return LyricsContent$$serializer.INSTANCE;
        }
    }

    static {
        Shazam$$ExternalSyntheticLambda0 shazam$$ExternalSyntheticLambda0 = new Shazam$$ExternalSyntheticLambda0((byte) 2);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, null, ResultKt.lazy(lazyThreadSafetyMode, shazam$$ExternalSyntheticLambda0), null, ResultKt.lazy(lazyThreadSafetyMode, new Shazam$$ExternalSyntheticLambda0((byte) 3)), null};
    }

    public /* synthetic */ LyricsContent(int i, long j, long j2, long j3, String str, List list, boolean z, List list2, boolean z2) {
        if (7 != (i & 7)) {
            EnumsKt.throwMissingFieldException(LyricsContent$$serializer.INSTANCE.getDescriptor(), i, 7);
            throw null;
        }
        this.timestamp = j;
        this.endtime = j2;
        this.duration = j3;
        if ((i & 8) == 0) {
            this.structure = null;
        } else {
            this.structure = str;
        }
        int i2 = i & 16;
        EmptyList emptyList = EmptyList.INSTANCE;
        if (i2 == 0) {
            this.text = emptyList;
        } else {
            this.text = list;
        }
        if ((i & 32) == 0) {
            this.background = false;
        } else {
            this.background = z;
        }
        if ((i & 64) == 0) {
            this.backgroundText = emptyList;
        } else {
            this.backgroundText = list2;
        }
        if ((i & 128) == 0) {
            this.oppositeTurn = false;
        } else {
            this.oppositeTurn = z2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LyricsContent)) {
            return false;
        }
        LyricsContent lyricsContent = (LyricsContent) obj;
        return this.timestamp == lyricsContent.timestamp && this.endtime == lyricsContent.endtime && this.duration == lyricsContent.duration && Intrinsics.areEqual(this.structure, lyricsContent.structure) && Intrinsics.areEqual(this.text, lyricsContent.text) && this.background == lyricsContent.background && Intrinsics.areEqual(this.backgroundText, lyricsContent.backgroundText) && this.oppositeTurn == lyricsContent.oppositeTurn;
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.timestamp) * 31, 31, this.endtime), 31, this.duration);
        String str = this.structure;
        return Boolean.hashCode(this.oppositeTurn) + Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m((iM + (str == null ? 0 : str.hashCode())) * 31, 31, this.text), this.background, 31), 31, this.backgroundText);
    }

    public final String toString() {
        StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(this.timestamp, "LyricsContent(timestamp=", ", endtime=");
        sbM.append(this.endtime);
        sbM.append(", duration=");
        sbM.append(this.duration);
        sbM.append(", structure=");
        sbM.append(this.structure);
        sbM.append(", text=");
        sbM.append(this.text);
        sbM.append(", background=");
        sbM.append(this.background);
        sbM.append(", backgroundText=");
        sbM.append(this.backgroundText);
        sbM.append(", oppositeTurn=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.oppositeTurn, ")");
    }
}
