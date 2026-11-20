package com.metrolist.innertubex.extraction.strategy;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.YouTubeClient;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaybackClientOption {
    public final YouTubeClient client;
    public final String displayName;
    public final String id;
    public final PlaybackClientManifest manifest;

    public PlaybackClientOption(String str, String str2, YouTubeClient youTubeClient, PlaybackClientManifest playbackClientManifest) {
        youTubeClient.getClass();
        this.id = str;
        this.displayName = str2;
        this.client = youTubeClient;
        this.manifest = playbackClientManifest;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaybackClientOption)) {
            return false;
        }
        PlaybackClientOption playbackClientOption = (PlaybackClientOption) obj;
        return this.id.equals(playbackClientOption.id) && this.displayName.equals(playbackClientOption.displayName) && Intrinsics.areEqual(this.client, playbackClientOption.client) && this.manifest.equals(playbackClientOption.manifest);
    }

    public final int hashCode() {
        return this.manifest.hashCode() + ((this.client.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.displayName)) * 31);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("PlaybackClientOption(id=", this.id, ", displayName=", this.displayName, ", client=");
        sbM.append(this.client);
        sbM.append(", manifest=");
        sbM.append(this.manifest);
        sbM.append(")");
        return sbM.toString();
    }
}
