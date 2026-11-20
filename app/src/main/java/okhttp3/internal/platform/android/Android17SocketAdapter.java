package okhttp3.internal.platform.android;

import android.net.ssl.EchConfigList;
import android.net.ssl.InvalidEchDataException;
import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.platform.Platform;
import okio.ByteString;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Android17SocketAdapter implements SocketAdapter {
    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List list, ByteString byteString) throws IOException {
        EchConfigList echConfigListFromBytes;
        SSLSockets.setUseSessionTickets(sSLSocket, true);
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            Platform platform = Platform.platform;
            sSLParameters.setApplicationProtocols((String[]) Path.Companion.alpnProtocolNames(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
            if (str == null || byteString == null) {
                return;
            }
            try {
                echConfigListFromBytes = EchConfigList.fromBytes(byteString.toByteArray());
            } catch (InvalidEchDataException unused) {
                echConfigListFromBytes = null;
            }
            if (echConfigListFromBytes != null) {
                SSLSockets.setEchConfigList(sSLSocket, echConfigListFromBytes);
            }
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || applicationProtocol.equals("")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean isSupported() {
        Platform platform = Platform.platform;
        return Build.VERSION.SDK_INT >= 37;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean matchesSocket(SSLSocket sSLSocket) {
        return SSLSockets.isSupportedSocket(sSLSocket);
    }
}
