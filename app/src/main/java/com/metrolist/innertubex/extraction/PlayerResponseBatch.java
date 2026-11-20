package com.metrolist.innertubex.extraction;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayerResponseBatch {
    public final List attempts;
    public final List failures;
    public final List playableResponses;
    public final List requestFailures;

    public PlayerResponseBatch(List list, List list2, List list3, List list4) {
        list2.getClass();
        list3.getClass();
        list4.getClass();
        this.playableResponses = list;
        this.failures = list2;
        this.requestFailures = list3;
        this.attempts = list4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerResponseBatch)) {
            return false;
        }
        PlayerResponseBatch playerResponseBatch = (PlayerResponseBatch) obj;
        return this.playableResponses.equals(playerResponseBatch.playableResponses) && Intrinsics.areEqual(this.failures, playerResponseBatch.failures) && Intrinsics.areEqual(this.requestFailures, playerResponseBatch.requestFailures) && Intrinsics.areEqual(this.attempts, playerResponseBatch.attempts);
    }

    public final int hashCode() {
        return this.attempts.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.playableResponses.hashCode() * 31, 31, this.failures), 31, this.requestFailures);
    }

    public final String toString() {
        return "PlayerResponseBatch(playableResponses=" + this.playableResponses + ", failures=" + this.failures + ", requestFailures=" + this.requestFailures + ", attempts=" + this.attempts + ")";
    }
}
