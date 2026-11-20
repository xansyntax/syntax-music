package com.metrolist.innertubex.extraction.strategy;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.extraction.ContentHints;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ClientSelectionRequest {
    public final boolean authenticated;
    public final Set availablePoTokenProviders;
    public final Set excludedClients;
    public final boolean fastPathOnly;
    public final ContentHints hints;
    public final boolean javaScriptRuntimeAvailable;
    public final PlaybackTransportPreference transportPreference;
    public final boolean webViewAvailable;

    public ClientSelectionRequest(ContentHints contentHints, boolean z, Set set, boolean z2, boolean z3, boolean z4, PlaybackTransportPreference playbackTransportPreference, Set set2) {
        contentHints.getClass();
        set.getClass();
        set2.getClass();
        this.hints = contentHints;
        this.authenticated = z;
        this.availablePoTokenProviders = set;
        this.javaScriptRuntimeAvailable = z2;
        this.webViewAvailable = z3;
        this.fastPathOnly = z4;
        this.transportPreference = playbackTransportPreference;
        this.excludedClients = set2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientSelectionRequest)) {
            return false;
        }
        ClientSelectionRequest clientSelectionRequest = (ClientSelectionRequest) obj;
        return Intrinsics.areEqual(this.hints, clientSelectionRequest.hints) && this.authenticated == clientSelectionRequest.authenticated && Intrinsics.areEqual(this.availablePoTokenProviders, clientSelectionRequest.availablePoTokenProviders) && this.javaScriptRuntimeAvailable == clientSelectionRequest.javaScriptRuntimeAvailable && this.webViewAvailable == clientSelectionRequest.webViewAvailable && this.fastPathOnly == clientSelectionRequest.fastPathOnly && this.transportPreference == clientSelectionRequest.transportPreference && Intrinsics.areEqual(this.excludedClients, clientSelectionRequest.excludedClients);
    }

    public final int hashCode() {
        return this.excludedClients.hashCode() + ((this.transportPreference.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((this.availablePoTokenProviders.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.hints.hashCode() * 31, this.authenticated, 31), false, 31)) * 31, this.javaScriptRuntimeAvailable, 31), this.webViewAvailable, 31), this.fastPathOnly, 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ClientSelectionRequest(hints=");
        sb.append(this.hints);
        sb.append(", authenticated=");
        sb.append(this.authenticated);
        sb.append(", premium=false, availablePoTokenProviders=");
        sb.append(this.availablePoTokenProviders);
        sb.append(", javaScriptRuntimeAvailable=");
        sb.append(this.javaScriptRuntimeAvailable);
        sb.append(", webViewAvailable=");
        Fragment$5$$ExternalSyntheticOutline0.m(sb, this.webViewAvailable, ", fastPathOnly=", this.fastPathOnly, ", transportPreference=");
        sb.append(this.transportPreference);
        sb.append(", excludedClients=");
        sb.append(this.excludedClients);
        sb.append(")");
        return sb.toString();
    }
}
