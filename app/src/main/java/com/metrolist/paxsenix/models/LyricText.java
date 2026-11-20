package com.metrolist.paxsenix.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/paxsenix/models/LyricText;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class LyricText {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final long duration;
    public final long endtime;
    public final boolean part;
    public final String text;
    public final long timestamp;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/paxsenix/models/LyricText$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/paxsenix/models/LyricText;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return LyricText$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ LyricText(int i, String str, long j, long j2, long j3, boolean z) {
        if (15 != (i & 15)) {
            EnumsKt.throwMissingFieldException(LyricText$$serializer.INSTANCE.getDescriptor(), i, 15);
            throw null;
        }
        this.text = str;
        this.timestamp = j;
        this.endtime = j2;
        this.duration = j3;
        if ((i & 16) == 0) {
            this.part = false;
        } else {
            this.part = z;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LyricText)) {
            return false;
        }
        LyricText lyricText = (LyricText) obj;
        return Intrinsics.areEqual(this.text, lyricText.text) && this.timestamp == lyricText.timestamp && this.endtime == lyricText.endtime && this.duration == lyricText.duration && this.part == lyricText.part;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.part) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.text.hashCode() * 31, 31, this.timestamp), 31, this.endtime), 31, this.duration);
    }

    public final String toString() {
        return "LyricText(text=" + this.text + ", timestamp=" + this.timestamp + ", endtime=" + this.endtime + ", duration=" + this.duration + ", part=" + this.part + ")";
    }
}
