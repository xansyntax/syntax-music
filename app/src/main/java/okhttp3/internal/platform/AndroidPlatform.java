package okhttp3.internal.platform;

import android.content.Context;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.os.StrictMode;
import android.security.NetworkSecurityPolicy;
import android.util.Log;
import dagger.hilt.EntryPoints;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.ArraysKt;
import okhttp3.OkHttpClient;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidLog;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.TrustRootIndex;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class AndroidPlatform extends Platform implements ContextAwarePlatform {
    public static final boolean isSupported;
    public Context applicationContext;
    public final ArrayList socketAdapters;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CustomTrustRootIndex implements TrustRootIndex {
        public final Method findByIssuerAndSignatureMethod;
        public final X509TrustManager trustManager;

        public CustomTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
            this.trustManager = x509TrustManager;
            this.findByIssuerAndSignatureMethod = method;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomTrustRootIndex)) {
                return false;
            }
            CustomTrustRootIndex customTrustRootIndex = (CustomTrustRootIndex) obj;
            return this.trustManager.equals(customTrustRootIndex.trustManager) && this.findByIssuerAndSignatureMethod.equals(customTrustRootIndex.findByIssuerAndSignatureMethod);
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public final X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            try {
                Object objInvoke = this.findByIssuerAndSignatureMethod.invoke(this.trustManager, x509Certificate);
                objInvoke.getClass();
                return ((TrustAnchor) objInvoke).getTrustedCert();
            } catch (IllegalAccessException e) {
                throw new AssertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public final int hashCode() {
            return this.findByIssuerAndSignatureMethod.hashCode() + (this.trustManager.hashCode() * 31);
        }

        public final String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.trustManager + ", findByIssuerAndSignatureMethod=" + this.findByIssuerAndSignatureMethod + ')';
        }
    }

    static {
        isSupported = Build.VERSION.SDK_INT < 29;
    }

    public AndroidPlatform() {
        StandardAndroidSocketAdapter standardAndroidSocketAdapter;
        try {
            Class<?> cls = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            Class.forName("com.android.org.conscrypt.OpenSSLSocketFactoryImpl");
            Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            standardAndroidSocketAdapter = new StandardAndroidSocketAdapter(cls);
        } catch (Exception e) {
            CopyOnWriteArraySet copyOnWriteArraySet = AndroidLog.configuredLoggers;
            AndroidLog.androidLog$okhttp(OkHttpClient.class.getName(), 5, "unable to load android socket classes", e);
            standardAndroidSocketAdapter = null;
        }
        int i = 0;
        ArrayList arrayListFilterNotNull = ArraysKt.filterNotNull(new SocketAdapter[]{standardAndroidSocketAdapter, new DeferredSocketAdapter(AndroidSocketAdapter.playProviderFactory), new DeferredSocketAdapter(ConscryptSocketAdapter.factory), new DeferredSocketAdapter(BouncyCastleSocketAdapter.factory)});
        ArrayList arrayList = new ArrayList();
        int size = arrayListFilterNotNull.size();
        while (i < size) {
            Object obj = arrayListFilterNotNull.get(i);
            i++;
            if (((SocketAdapter) obj).isSupported()) {
                arrayList.add(obj);
            }
        }
        this.socketAdapters = arrayList;
    }

    @Override // okhttp3.internal.platform.Platform
    public final EntryPoints buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        TrustRootIndex basicTrustRootIndex;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        AndroidCertificateChainCleaner androidCertificateChainCleaner = x509TrustManagerExtensions != null ? new AndroidCertificateChainCleaner(x509TrustManager, x509TrustManagerExtensions) : null;
        if (androidCertificateChainCleaner != null) {
            return androidCertificateChainCleaner;
        }
        try {
            StrictMode.noteSlowCall("buildTrustRootIndex");
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            basicTrustRootIndex = new CustomTrustRootIndex(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused2) {
            X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
            basicTrustRootIndex = new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
        }
        return new BasicCertificateChainCleaner(basicTrustRootIndex);
    }

    @Override // okhttp3.internal.platform.Platform
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List list, ByteString byteString) {
        Object obj;
        ArrayList arrayList = this.socketAdapters;
        int size = arrayList.size();
        int i = 0;
        do {
            if (i >= size) {
                obj = null;
                break;
            } else {
                obj = arrayList.get(i);
                i++;
            }
        } while (!((SocketAdapter) obj).matchesSocket(sSLSocket));
        SocketAdapter socketAdapter = (SocketAdapter) obj;
        if (socketAdapter != null) {
            socketAdapter.configureTlsExtensions(sSLSocket, str, list, byteString);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        inetSocketAddress.getClass();
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e;
            }
            throw new IOException("Exception in connect", e);
        }
    }

    @Override // okhttp3.internal.platform.ContextAwarePlatform
    public final Context getApplicationContext() {
        return this.applicationContext;
    }

    @Override // okhttp3.internal.platform.Platform
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        Object obj;
        ArrayList arrayList = this.socketAdapters;
        int size = arrayList.size();
        int i = 0;
        do {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
        } while (!((SocketAdapter) obj).matchesSocket(sSLSocket));
        SocketAdapter socketAdapter = (SocketAdapter) obj;
        if (socketAdapter != null) {
            return socketAdapter.getSelectedProtocol(sSLSocket);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    public final boolean isCleartextTrafficPermitted(String str) {
        str.getClass();
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }

    @Override // okhttp3.internal.platform.Platform
    public final void log(int i, String str, Throwable th) {
        if (i == 5) {
            Log.w("OkHttp", str, th);
        } else {
            Log.i("OkHttp", str, th);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final SSLContext newSSLContext() throws NoSuchAlgorithmException {
        StrictMode.noteSlowCall("newSSLContext");
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.getClass();
        return sSLContext;
    }

    @Override // okhttp3.internal.platform.ContextAwarePlatform
    public final void setApplicationContext(Context context) {
        this.applicationContext = context;
    }
}
