package com.metrolist.music.db.entities;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SetVideoIdEntity {
    public final String setVideoId;
    public final String videoId;

    public SetVideoIdEntity(String str, String str2) {
        str.getClass();
        this.videoId = str;
        this.setVideoId = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetVideoIdEntity)) {
            return false;
        }
        SetVideoIdEntity setVideoIdEntity = (SetVideoIdEntity) obj;
        return Intrinsics.areEqual(this.videoId, setVideoIdEntity.videoId) && Intrinsics.areEqual(this.setVideoId, setVideoIdEntity.setVideoId);
    }

    public final int hashCode() {
        int iHashCode = this.videoId.hashCode() * 31;
        String str = this.setVideoId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("SetVideoIdEntity(videoId=", this.videoId, ", setVideoId=", this.setVideoId, ")");
    }
}
