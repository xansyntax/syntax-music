package com.metrolist.innertubex.extraction.strategy;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.YouTubeClient;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SelectedClient {
    public final YouTubeClient client;
    public final PlaybackClientManifest manifest;
    public final List reasons;
    public final int score;

    public SelectedClient(YouTubeClient youTubeClient, PlaybackClientManifest playbackClientManifest, int i, List list) {
        youTubeClient.getClass();
        this.client = youTubeClient;
        this.manifest = playbackClientManifest;
        this.score = i;
        this.reasons = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectedClient)) {
            return false;
        }
        SelectedClient selectedClient = (SelectedClient) obj;
        return Intrinsics.areEqual(this.client, selectedClient.client) && Intrinsics.areEqual(this.manifest, selectedClient.manifest) && this.score == selectedClient.score && this.reasons.equals(selectedClient.reasons);
    }

    public final int hashCode() {
        int iHashCode = this.client.hashCode() * 31;
        PlaybackClientManifest playbackClientManifest = this.manifest;
        return this.reasons.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.score, (iHashCode + (playbackClientManifest == null ? 0 : playbackClientManifest.hashCode())) * 31, 31);
    }

    public final String toString() {
        return "SelectedClient(client=" + this.client + ", manifest=" + this.manifest + ", score=" + this.score + ", reasons=" + this.reasons + ")";
    }
}
