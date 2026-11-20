package okhttp3.internal.platform;

import android.os.Build;
import android.os.StrictMode;
import android.security.NetworkSecurityPolicy;
import android.util.Log;
import dagger.hilt.EntryPoints;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.ech.EchRetryPlan;
import okhttp3.internal.platform.android.AndroidLog;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Platform {
    public static final Logger logger;
    public static volatile Platform platform;

    static {
        try {
            for (Map.Entry entry : AndroidLog.knownLoggers.entrySet()) {
                AndroidLog.enableLogging((String) entry.getKey(), (String) entry.getValue());
            }
        } catch (RuntimeException e) {
            System.err.println("Possibly running android unit test without robolectric");
            e.printStackTrace();
        } catch (UnsatisfiedLinkError e2) {
            System.err.println("Possibly running android unit test without robolectric");
            e2.printStackTrace();
        }
        Platform android10Platform = Android10Platform.isSupported ? new Android10Platform() : null;
        if (android10Platform == null) {
            android10Platform = AndroidPlatform.isSupported ? new AndroidPlatform() : null;
        }
        if (android10Platform == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3(Build.VERSION.SDK_INT, "Expected Android API level 21+ but was ");
        } else {
            platform = android10Platform;
            logger = Logger.getLogger(OkHttpClient.class.getName());
        }
    }

    public abstract EntryPoints buildCertificateChainCleaner(X509TrustManager x509TrustManager);

    public abstract void configureTlsExtensions(SSLSocket sSLSocket, String str, List list, ByteString byteString);

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        inetSocketAddress.getClass();
        socket.connect(inetSocketAddress, i);
    }

    public EchRetryPlan echRetryPlan(SSLException sSLException) {
        return null;
    }

    public abstract String getSelectedProtocol(SSLSocket sSLSocket);

    public Object getStackTraceForCloseable() {
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable("response.body().close()");
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(String str) {
        str.getClass();
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }

    public void log(int i, String str, Throwable th) {
        if (i == 5) {
            boolean z = AndroidPlatform.isSupported;
            Log.w("OkHttp", str, th);
        } else {
            boolean z2 = AndroidPlatform.isSupported;
            Log.i("OkHttp", str, th);
        }
    }

    public void logCloseableLeak(Object obj, String str) {
        if (obj == null) {
            str = str.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        log(5, str, (Throwable) obj);
    }

    public SSLContext newSSLContext() {
        StrictMode.noteSlowCall("newSSLContext");
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.getClass();
        return sSLContext;
    }

    public final String toString() {
        return getClass().getSimpleName();
    }
}
