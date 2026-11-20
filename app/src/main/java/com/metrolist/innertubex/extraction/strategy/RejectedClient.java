package com.metrolist.innertubex.extraction.strategy;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RejectedClient {
    public final PlaybackClientManifest manifest;
    public final List reasons;

    public RejectedClient(PlaybackClientManifest playbackClientManifest, List list) {
        list.getClass();
        this.manifest = playbackClientManifest;
        this.reasons = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RejectedClient)) {
            return false;
        }
        RejectedClient rejectedClient = (RejectedClient) obj;
        return this.manifest.equals(rejectedClient.manifest) && Intrinsics.areEqual(this.reasons, rejectedClient.reasons);
    }

    public final int hashCode() {
        return this.reasons.hashCode() + (this.manifest.hashCode() * 31);
    }

    public final String toString() {
        return "RejectedClient(manifest=" + this.manifest + ", reasons=" + this.reasons + ")";
    }
}
