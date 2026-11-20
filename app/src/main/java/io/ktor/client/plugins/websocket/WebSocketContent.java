package io.ktor.client.plugins.websocket;

import io.ktor.client.request.ClientUpgradeContent;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.websocket.UtilsKt;
import io.ktor.util.CryptoKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u00020\tH\u0096\u0080\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSocketContent;", "Lio/ktor/client/request/ClientUpgradeContent;", "<init>", "()V", "Lio/ktor/http/Headers;", "headers", "", "verify", "(Lio/ktor/http/Headers;)V", "", "toString", "()Ljava/lang/String;", "nonce", "Ljava/lang/String;", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WebSocketContent extends ClientUpgradeContent {
    private final Headers headers;
    private final String nonce;

    public WebSocketContent() {
        String strEncode$default = Base64.encode$default(Base64.Default, CryptoKt.generateNonce(16));
        this.nonce = strEncode$default;
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        headersBuilder.append(HttpHeaders.Upgrade, "websocket");
        headersBuilder.append(HttpHeaders.Connection, HttpHeaders.Upgrade);
        headersBuilder.append(HttpHeaders.SecWebSocketKey, strEncode$default);
        headersBuilder.append(HttpHeaders.SecWebSocketVersion, "13");
        this.headers = headersBuilder.build();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Headers getHeaders() {
        return this.headers;
    }

    public String toString() {
        return "WebSocketContent";
    }

    @Override // io.ktor.client.request.ClientUpgradeContent
    public void verify(Headers headers) {
        headers.getClass();
        String str = headers.get(HttpHeaders.SecWebSocketAccept);
        if (str == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Server should specify header Sec-WebSocket-Accept");
            return;
        }
        String strWebsocketServerAccept = UtilsKt.websocketServerAccept(this.nonce);
        if (Intrinsics.areEqual(strWebsocketServerAccept, str)) {
            return;
        }
        PathKt$$ExternalSyntheticBUOutline0.m("Failed to verify server accept header. Expected: ", strWebsocketServerAccept, ", received: ", str);
    }
}
