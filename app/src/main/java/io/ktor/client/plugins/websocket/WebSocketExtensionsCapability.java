package io.ktor.client.plugins.websocket;

import io.ktor.client.engine.HttpClientEngineCapability;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0083\u0004¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u00020\nHÖ\u0081\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u00020\rHÖ\u0081\u0004¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSocketExtensionsCapability;", "Lio/ktor/client/engine/HttpClientEngineCapability;", "", "<init>", "()V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class WebSocketExtensionsCapability implements HttpClientEngineCapability<Unit> {
    public static final WebSocketExtensionsCapability INSTANCE = new WebSocketExtensionsCapability();

    private WebSocketExtensionsCapability() {
    }

    public boolean equals(Object other) {
        return this == other || (other instanceof WebSocketExtensionsCapability);
    }

    public int hashCode() {
        return 806573237;
    }

    public String toString() {
        return "WebSocketExtensionsCapability";
    }
}
