package com.metrolist.innertubex.extraction.strategy;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.YouTubeClient;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaybackClientManifest {
    public final AuthenticationPolicy authentication;
    public final ClientContentCapabilities benchmarkContent;
    public final YouTubeClient client;
    public final ClientContentCapabilities content;
    public final String displayName;
    public final Set evidence;
    public final String id;
    public final ClientLifecycle lifecycle;
    public final String notes;
    public final ClientPoTokenCapabilities poTokens;
    public final byte priority;
    public final ClientRequestCapabilities request;
    public final ClientSelectionMode selectionMode;
    public final Set transports;

    /* JADX WARN: Multi-variable type inference failed */
    public PlaybackClientManifest(int i, AuthenticationPolicy authenticationPolicy, ClientContentCapabilities clientContentCapabilities, ClientContentCapabilities clientContentCapabilities2, ClientLifecycle clientLifecycle, ClientPoTokenCapabilities clientPoTokenCapabilities, ClientRequestCapabilities clientRequestCapabilities, ClientSelectionMode clientSelectionMode, YouTubeClient youTubeClient, String str, String str2, String str3, Set set, Set set2) {
        youTubeClient.getClass();
        authenticationPolicy.getClass();
        clientPoTokenCapabilities.getClass();
        clientRequestCapabilities.getClass();
        clientContentCapabilities2.getClass();
        this.id = str;
        this.displayName = str2;
        this.client = youTubeClient;
        this.lifecycle = clientLifecycle;
        this.selectionMode = clientSelectionMode;
        this.authentication = authenticationPolicy;
        this.transports = set;
        this.poTokens = clientPoTokenCapabilities;
        this.request = clientRequestCapabilities;
        this.content = clientContentCapabilities;
        this.benchmarkContent = clientContentCapabilities2;
        this.priority = i;
        this.evidence = set2;
        this.notes = str3;
        Pattern patternCompile = Pattern.compile("[A-Z0-9_]+");
        patternCompile.getClass();
        if (!patternCompile.matcher(str).matches()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) "Client manifest ID must be stable and uppercase: ".concat(str));
            throw null;
        }
        if (set.isEmpty() && clientSelectionMode != ClientSelectionMode.API_ONLY) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m("Playback client ", str, " must declare at least one transport"));
            throw null;
        }
        if (set.contains(PlaybackTransport.SABR) != youTubeClient.useSabr) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m("Client ", str, " disagrees with its SABR request profile"));
            throw null;
        }
        if ((authenticationPolicy != AuthenticationPolicy.UNSUPPORTED) != youTubeClient.loginSupported) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m("Client ", str, " disagrees with its login request profile"));
            throw null;
        }
        if ((authenticationPolicy == AuthenticationPolicy.REQUIRED) != youTubeClient.loginRequired) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m("Client ", str, " disagrees with its required-login request profile"));
            throw null;
        }
        if (clientRequestCapabilities.signatureTimestamp != youTubeClient.useSignatureTimestamp) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m("Client ", str, " disagrees with its signature timestamp request profile"));
            throw null;
        }
        boolean z = clientRequestCapabilities.embedded;
        if (z != youTubeClient.isEmbedded) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m("Client ", str, " disagrees with its embedded request profile"));
            throw null;
        }
        if (!clientRequestCapabilities.encryptedHostFlags || z) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m("Client ", str, " requests encrypted host flags without an embedded player context"));
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaybackClientManifest)) {
            return false;
        }
        PlaybackClientManifest playbackClientManifest = (PlaybackClientManifest) obj;
        return this.id.equals(playbackClientManifest.id) && this.displayName.equals(playbackClientManifest.displayName) && Intrinsics.areEqual(this.client, playbackClientManifest.client) && this.lifecycle == playbackClientManifest.lifecycle && this.selectionMode == playbackClientManifest.selectionMode && this.authentication == playbackClientManifest.authentication && this.transports.equals(playbackClientManifest.transports) && Intrinsics.areEqual(this.poTokens, playbackClientManifest.poTokens) && Intrinsics.areEqual(this.request, playbackClientManifest.request) && this.content.equals(playbackClientManifest.content) && Intrinsics.areEqual(this.benchmarkContent, playbackClientManifest.benchmarkContent) && this.priority == playbackClientManifest.priority && this.evidence.equals(playbackClientManifest.evidence) && this.notes.equals(playbackClientManifest.notes);
    }

    public final int hashCode() {
        return this.notes.hashCode() + ((this.evidence.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m((int) this.priority, (this.benchmarkContent.hashCode() + ((this.content.hashCode() + ((this.request.hashCode() + ((this.poTokens.hashCode() + ((this.transports.hashCode() + ((this.authentication.hashCode() + ((this.selectionMode.hashCode() + ((this.lifecycle.hashCode() + ((this.client.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.displayName)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31, 31)) * 31);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("PlaybackClientManifest(id=", this.id, ", displayName=", this.displayName, ", client=");
        sbM.append(this.client);
        sbM.append(", lifecycle=");
        sbM.append(this.lifecycle);
        sbM.append(", selectionMode=");
        sbM.append(this.selectionMode);
        sbM.append(", authentication=");
        sbM.append(this.authentication);
        sbM.append(", transports=");
        sbM.append(this.transports);
        sbM.append(", poTokens=");
        sbM.append(this.poTokens);
        sbM.append(", request=");
        sbM.append(this.request);
        sbM.append(", content=");
        sbM.append(this.content);
        sbM.append(", benchmarkContent=");
        sbM.append(this.benchmarkContent);
        sbM.append(", priority=");
        sbM.append((int) this.priority);
        sbM.append(", evidence=");
        sbM.append(this.evidence);
        sbM.append(", notes=");
        sbM.append(this.notes);
        sbM.append(")");
        return sbM.toString();
    }
}
