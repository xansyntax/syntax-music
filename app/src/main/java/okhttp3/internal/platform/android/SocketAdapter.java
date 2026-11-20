package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public interface SocketAdapter {
    void configureTlsExtensions(SSLSocket sSLSocket, String str, List list, ByteString byteString);

    String getSelectedProtocol(SSLSocket sSLSocket);

    boolean isSupported();

    boolean matchesSocket(SSLSocket sSLSocket);
}
