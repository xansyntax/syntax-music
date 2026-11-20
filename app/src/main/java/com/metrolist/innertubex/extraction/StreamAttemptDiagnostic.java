package com.metrolist.innertubex.extraction;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StreamAttemptDiagnostic {
    public final String clientName;
    public final String outcome;
    public final String profileId;
    public final String userAgent;

    public StreamAttemptDiagnostic(String str, String str2, String str3, String str4) {
        str.getClass();
        str3.getClass();
        this.clientName = str;
        this.profileId = str2;
        this.userAgent = str3;
        this.outcome = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreamAttemptDiagnostic)) {
            return false;
        }
        StreamAttemptDiagnostic streamAttemptDiagnostic = (StreamAttemptDiagnostic) obj;
        return Intrinsics.areEqual(this.clientName, streamAttemptDiagnostic.clientName) && Intrinsics.areEqual(this.profileId, streamAttemptDiagnostic.profileId) && Intrinsics.areEqual(this.userAgent, streamAttemptDiagnostic.userAgent) && this.outcome.equals(streamAttemptDiagnostic.outcome);
    }

    public final int hashCode() {
        int iHashCode = this.clientName.hashCode() * 31;
        String str = this.profileId;
        return this.outcome.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.userAgent);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("StreamAttemptDiagnostic(clientName=", this.clientName, ", profileId=", this.profileId, ", userAgent="), this.userAgent, ", outcome=", this.outcome, ")");
    }
}
