package com.metrolist.paxsenix.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/paxsenix/models/AppleMusicSongAttributes;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class AppleMusicSongAttributes {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String albumName;
    public final String artistName;
    public final AppleMusicArtwork artwork;
    public final Long durationInMillis;
    public final String name;
    public final String url;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/paxsenix/models/AppleMusicSongAttributes$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/paxsenix/models/AppleMusicSongAttributes;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return AppleMusicSongAttributes$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AppleMusicSongAttributes(int i, String str, String str2, String str3, AppleMusicArtwork appleMusicArtwork, String str4, Long l) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(AppleMusicSongAttributes$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.name = str;
        this.artistName = str2;
        if ((i & 4) == 0) {
            this.albumName = null;
        } else {
            this.albumName = str3;
        }
        if ((i & 8) == 0) {
            this.artwork = null;
        } else {
            this.artwork = appleMusicArtwork;
        }
        if ((i & 16) == 0) {
            this.url = null;
        } else {
            this.url = str4;
        }
        if ((i & 32) == 0) {
            this.durationInMillis = null;
        } else {
            this.durationInMillis = l;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppleMusicSongAttributes)) {
            return false;
        }
        AppleMusicSongAttributes appleMusicSongAttributes = (AppleMusicSongAttributes) obj;
        return Intrinsics.areEqual(this.name, appleMusicSongAttributes.name) && Intrinsics.areEqual(this.artistName, appleMusicSongAttributes.artistName) && Intrinsics.areEqual(this.albumName, appleMusicSongAttributes.albumName) && Intrinsics.areEqual(this.artwork, appleMusicSongAttributes.artwork) && Intrinsics.areEqual(this.url, appleMusicSongAttributes.url) && Intrinsics.areEqual(this.durationInMillis, appleMusicSongAttributes.durationInMillis);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.name.hashCode() * 31, 31, this.artistName);
        String str = this.albumName;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        AppleMusicArtwork appleMusicArtwork = this.artwork;
        int iHashCode2 = (iHashCode + (appleMusicArtwork == null ? 0 : appleMusicArtwork.url.hashCode())) * 31;
        String str2 = this.url;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.durationInMillis;
        return iHashCode3 + (l != null ? l.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("AppleMusicSongAttributes(name=", this.name, ", artistName=", this.artistName, ", albumName=");
        sbM.append(this.albumName);
        sbM.append(", artwork=");
        sbM.append(this.artwork);
        sbM.append(", url=");
        sbM.append(this.url);
        sbM.append(", durationInMillis=");
        sbM.append(this.durationInMillis);
        sbM.append(")");
        return sbM.toString();
    }
}
