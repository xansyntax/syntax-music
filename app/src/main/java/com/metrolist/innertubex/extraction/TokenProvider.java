package com.metrolist.innertubex.extraction;

import kotlin.collections.EmptySet;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface TokenProvider {
    default TokenProviderCapabilities getCapabilities() {
        return new TokenProviderCapabilities(EmptySet.INSTANCE, false);
    }

    Object getPoToken(String str, String str2, Continuation continuation);
}
