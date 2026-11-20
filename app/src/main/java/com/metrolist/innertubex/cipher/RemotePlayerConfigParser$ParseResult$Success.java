package com.metrolist.innertubex.cipher;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RemotePlayerConfigParser$ParseResult$Success extends HexFormatKt {
    public final LinkedHashMap configs;
    public final ArrayList skippedEntries;

    public RemotePlayerConfigParser$ParseResult$Success(LinkedHashMap linkedHashMap, ArrayList arrayList) {
        this.configs = linkedHashMap;
        this.skippedEntries = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemotePlayerConfigParser$ParseResult$Success)) {
            return false;
        }
        RemotePlayerConfigParser$ParseResult$Success remotePlayerConfigParser$ParseResult$Success = (RemotePlayerConfigParser$ParseResult$Success) obj;
        return this.configs.equals(remotePlayerConfigParser$ParseResult$Success.configs) && this.skippedEntries.equals(remotePlayerConfigParser$ParseResult$Success.skippedEntries);
    }

    public final int hashCode() {
        return this.skippedEntries.hashCode() + (this.configs.hashCode() * 31);
    }

    public final String toString() {
        return "Success(configs=" + this.configs + ", skippedEntries=" + this.skippedEntries + ")";
    }
}
