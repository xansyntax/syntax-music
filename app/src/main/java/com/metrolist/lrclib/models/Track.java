package com.metrolist.lrclib.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/lrclib/models/Track;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class Track {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String artistName;
    public final double duration;
    public final int id;
    public final String plainLyrics;
    public final String syncedLyrics;
    public final String trackName;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/lrclib/models/Track$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/lrclib/models/Track;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return Track$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Track(int i, int i2, String str, String str2, double d, String str3, String str4) {
        if (63 != (i & 63)) {
            EnumsKt.throwMissingFieldException(Track$$serializer.INSTANCE.getDescriptor(), i, 63);
            throw null;
        }
        this.id = i2;
        this.trackName = str;
        this.artistName = str2;
        this.duration = d;
        this.plainLyrics = str3;
        this.syncedLyrics = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Track)) {
            return false;
        }
        Track track = (Track) obj;
        return this.id == track.id && Intrinsics.areEqual(this.trackName, track.trackName) && Intrinsics.areEqual(this.artistName, track.artistName) && Double.compare(this.duration, track.duration) == 0 && Intrinsics.areEqual(this.plainLyrics, track.plainLyrics) && Intrinsics.areEqual(this.syncedLyrics, track.syncedLyrics);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.duration, Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Integer.hashCode(this.id) * 31, 31, this.trackName), 31, this.artistName), 31);
        String str = this.plainLyrics;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.syncedLyrics;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Track(id=");
        sb.append(this.id);
        sb.append(", trackName=");
        sb.append(this.trackName);
        sb.append(", artistName=");
        sb.append(this.artistName);
        sb.append(", duration=");
        sb.append(this.duration);
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, ", plainLyrics=", this.plainLyrics, ", syncedLyrics=", this.syncedLyrics);
        sb.append(")");
        return sb.toString();
    }
}
