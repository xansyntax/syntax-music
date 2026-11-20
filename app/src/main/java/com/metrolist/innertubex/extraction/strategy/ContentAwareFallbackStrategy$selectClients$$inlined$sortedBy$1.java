package com.metrolist.innertubex.extraction.strategy;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ContentAwareFallbackStrategy$selectClients$$inlined$sortedBy$1 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((RejectedClient) obj).manifest.id.compareTo(((RejectedClient) obj2).manifest.id);
    }
}
