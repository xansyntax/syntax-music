package okhttp3.internal.platform.android;

import coil3.util.FileSystemsKt;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.platform.Platform;
import okio.ByteString;
import okio.Path;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class BouncyCastleSocketAdapter implements SocketAdapter {
    public static final BouncyCastleSocketAdapter$Companion$factory$1 factory = new BouncyCastleSocketAdapter$Companion$factory$1();
    public static final boolean isSupported;

    static {
        boolean z = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, FileSystemsKt.class.getClassLoader());
            z = true;
        } catch (ClassNotFoundException unused) {
        }
        isSupported = z;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List list, ByteString byteString) {
        if (matchesSocket(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            Platform platform = Platform.platform;
            parameters.setApplicationProtocols((String[]) Path.Companion.alpnProtocolNames(list).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null || applicationProtocol.equals("")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean isSupported() {
        return isSupported;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean matchesSocket(SSLSocket sSLSocket) {
        return false;
    }
}
