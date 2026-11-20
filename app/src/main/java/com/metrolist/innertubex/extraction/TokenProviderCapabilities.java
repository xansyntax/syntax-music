package com.metrolist.innertubex.extraction;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TokenProviderCapabilities {
    public final Set providers;
    public final boolean usesWebView;

    public TokenProviderCapabilities(Set set, boolean z) {
        set.getClass();
        this.providers = set;
        this.usesWebView = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TokenProviderCapabilities)) {
            return false;
        }
        TokenProviderCapabilities tokenProviderCapabilities = (TokenProviderCapabilities) obj;
        return Intrinsics.areEqual(this.providers, tokenProviderCapabilities.providers) && this.usesWebView == tokenProviderCapabilities.usesWebView;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.usesWebView) + (this.providers.hashCode() * 31);
    }

    public final String toString() {
        return "TokenProviderCapabilities(providers=" + this.providers + ", usesWebView=" + this.usesWebView + ")";
    }
}
