package com.metrolist.innertubex.extraction.strategy;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ClientSelectionResult {
    public final List candidates;
    public final List rejected;

    public ClientSelectionResult(List list, List list2) {
        list2.getClass();
        this.candidates = list;
        this.rejected = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientSelectionResult)) {
            return false;
        }
        ClientSelectionResult clientSelectionResult = (ClientSelectionResult) obj;
        return this.candidates.equals(clientSelectionResult.candidates) && Intrinsics.areEqual(this.rejected, clientSelectionResult.rejected);
    }

    public final int hashCode() {
        return this.rejected.hashCode() + (this.candidates.hashCode() * 31);
    }

    public final String toString() {
        return "ClientSelectionResult(candidates=" + this.candidates + ", rejected=" + this.rejected + ")";
    }
}
