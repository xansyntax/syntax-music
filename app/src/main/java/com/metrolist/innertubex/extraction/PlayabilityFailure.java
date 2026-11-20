package com.metrolist.innertubex.extraction;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.extraction.strategy.ClientFailureKind;
import java.util.Locale;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayabilityFailure {
    public final ClientFailureKind category;
    public final String reason;
    public final String status;

    public PlayabilityFailure(String str, String str2) {
        String upperCase = (str == null ? "" : str).toUpperCase(Locale.ROOT);
        upperCase.getClass();
        ClientFailureKind clientFailureKind = (ArraysKt.toSet(new String[]{"AGE_CHECK_REQUIRED", "AGE_VERIFICATION_REQUIRED", "CONTENT_CHECK_REQUIRED"}).contains(upperCase) || ArraysKt.toSet(new String[]{"UNPLAYABLE", "VIDEO_UNAVAILABLE", "LIVE_STREAM_OFFLINE"}).contains(upperCase) || !upperCase.equals("LOGIN_REQUIRED")) ? ClientFailureKind.PLAYABILITY : ClientFailureKind.TOKEN;
        this.status = str;
        this.reason = str2;
        this.category = clientFailureKind;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayabilityFailure)) {
            return false;
        }
        PlayabilityFailure playabilityFailure = (PlayabilityFailure) obj;
        return Intrinsics.areEqual(this.status, playabilityFailure.status) && Intrinsics.areEqual(this.reason, playabilityFailure.reason) && this.category == playabilityFailure.category;
    }

    public final int hashCode() {
        String str = this.status;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.reason;
        return this.category.hashCode() + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("PlayabilityFailure(status=", this.status, ", reason=", this.reason, ", category=");
        sbM.append(this.category);
        sbM.append(")");
        return sbM.toString();
    }
}
