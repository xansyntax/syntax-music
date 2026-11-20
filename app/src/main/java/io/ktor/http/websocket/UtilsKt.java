package io.ktor.http.websocket;

import io.ktor.util.CryptoKt;
import io.ktor.utils.io.core.StringsKt;
import kotlin.Metadata;
import kotlin.io.encoding.Base64;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u0015\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "nonce", "websocketServerAccept", "(Ljava/lang/String;)Ljava/lang/String;", "WEBSOCKET_SERVER_ACCEPT_TAIL", "Ljava/lang/String;", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UtilsKt {
    private static final String WEBSOCKET_SERVER_ACCEPT_TAIL = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

    public static final String websocketServerAccept(String str) {
        str.getClass();
        return Base64.encode$default(Base64.Default, CryptoKt.sha1(StringsKt.toByteArray(kotlin.text.StringsKt.trim(str).toString() + WEBSOCKET_SERVER_ACCEPT_TAIL, Charsets.ISO_8859_1)));
    }
}
