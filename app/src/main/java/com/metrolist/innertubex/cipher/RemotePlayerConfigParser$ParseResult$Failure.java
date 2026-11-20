package com.metrolist.innertubex.cipher;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RemotePlayerConfigParser$ParseResult$Failure extends HexFormatKt {
    public final String reason;

    public RemotePlayerConfigParser$ParseResult$Failure(String str) {
        this.reason = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RemotePlayerConfigParser$ParseResult$Failure) && this.reason.equals(((RemotePlayerConfigParser$ParseResult$Failure) obj).reason);
    }

    public final int hashCode() {
        return this.reason.hashCode();
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m("Failure(reason=", this.reason, ")");
    }
}
