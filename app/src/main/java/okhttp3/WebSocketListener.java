package okhttp3;

import okio.ByteString;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WebSocketListener {
    public abstract void onClosed(WebSocket webSocket, int i, String str);

    public abstract void onClosing(WebSocket webSocket, int i, String str);

    public abstract void onFailure(WebSocket webSocket, Throwable th, Response response);

    public void onMessage(WebSocket webSocket, ByteString byteString) {
        Timber.Forest.tag("DiscordSvc");
        ConnectionPool.w(Integer.valueOf(byteString.getSize$okio()));
    }

    public abstract void onOpen(WebSocket webSocket, Response response);

    public void onMessage(WebSocket webSocket, String str) {
    }
}
