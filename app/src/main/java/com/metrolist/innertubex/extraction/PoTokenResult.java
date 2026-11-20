package com.metrolist.innertubex.extraction;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PoTokenResult {
    public final String playerRequestToken;
    public final String streamingDataToken;
    public final String visitorData;

    public PoTokenResult(String str, String str2, String str3) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.playerRequestToken = str;
        this.streamingDataToken = str2;
        this.visitorData = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PoTokenResult)) {
            return false;
        }
        PoTokenResult poTokenResult = (PoTokenResult) obj;
        return Intrinsics.areEqual(this.playerRequestToken, poTokenResult.playerRequestToken) && Intrinsics.areEqual(this.streamingDataToken, poTokenResult.streamingDataToken) && Intrinsics.areEqual(this.visitorData, poTokenResult.visitorData);
    }

    public final int hashCode() {
        return this.visitorData.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.playerRequestToken.hashCode() * 31, 31, this.streamingDataToken);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("PoTokenResult(playerRequestToken=", StringsKt.isBlank(this.playerRequestToken) ? "missing" : "present", ", streamingDataToken=", StringsKt.isBlank(this.streamingDataToken) ? "missing" : "present", ", visitorData="), StringsKt.isBlank(this.visitorData) ? "missing" : "present", ")");
    }
}
