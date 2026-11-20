package okhttp3.internal.platform;

import android.content.Context;
import android.net.http.X509TrustManagerExtensions;
import android.net.ssl.EchConfigList;
import android.net.ssl.EchConfigMismatchException;
import android.os.Build;
import android.os.StrictMode;
import android.util.CloseGuard;
import dagger.hilt.EntryPoints;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.ArraysKt;
import kotlin.text.Regex;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal.ech.EchRetryPlan;
import okhttp3.internal.platform.android.Android10SocketAdapter;
import okhttp3.internal.platform.android.Android17SocketAdapter;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okio.ByteString;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Android10Platform extends Platform implements ContextAwarePlatform {
    public static final boolean isSupported;
    public Context applicationContext;
    public final ArrayList socketAdapters;

    static {
        isSupported = Build.VERSION.SDK_INT >= 29;
    }

    public Android10Platform() {
        int i = Build.VERSION.SDK_INT;
        int i2 = 0;
        ArrayList arrayListFilterNotNull = ArraysKt.filterNotNull(new SocketAdapter[]{i >= 37 ? new Android17SocketAdapter() : null, i >= 29 ? new Android10SocketAdapter() : null, new DeferredSocketAdapter(AndroidSocketAdapter.playProviderFactory), new DeferredSocketAdapter(ConscryptSocketAdapter.factory), new DeferredSocketAdapter(BouncyCastleSocketAdapter.factory)});
        ArrayList arrayList = new ArrayList();
        int size = arrayListFilterNotNull.size();
        while (i2 < size) {
            Object obj = arrayListFilterNotNull.get(i2);
            i2++;
            if (((SocketAdapter) obj).isSupported()) {
                arrayList.add(obj);
            }
        }
        this.socketAdapters = arrayList;
    }

    @Override // okhttp3.internal.platform.Platform
    public final EntryPoints buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        AndroidCertificateChainCleaner androidCertificateChainCleaner = x509TrustManagerExtensions != null ? new AndroidCertificateChainCleaner(x509TrustManager, x509TrustManagerExtensions) : null;
        if (androidCertificateChainCleaner != null) {
            return androidCertificateChainCleaner;
        }
        StrictMode.noteSlowCall("buildTrustRootIndex");
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        return new BasicCertificateChainCleaner(new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length)));
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
    public final EchRetryPlan echRetryPlan(SSLException sSLException) {
        EchConfigMismatchException echConfigMismatchException;
        String publicHostname;
        ByteString byteStringOf$default;
        byte[] bytes;
        if (Build.VERSION.SDK_INT >= 37 && (sSLException instanceof EchConfigMismatchException) && (publicHostname = (echConfigMismatchException = (EchConfigMismatchException) sSLException).getPublicHostname()) != null) {
            Regex regex = EchRetryPlan.INVALID_PUBLIC_NAME;
            EchConfigList retryConfigList = echConfigMismatchException.getRetryConfigList();
            if (retryConfigList == null || (bytes = retryConfigList.toBytes()) == null) {
                byteStringOf$default = null;
            } else {
                ByteString byteString = ByteString.EMPTY;
                byteStringOf$default = Path.Companion.of$default(bytes);
            }
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(publicHostname);
            if (canonicalHost != null && !_HostnamesCommonKt.VERIFY_AS_IP_ADDRESS.matches(canonicalHost) && !EchRetryPlan.INVALID_PUBLIC_NAME.matches(canonicalHost)) {
                return new EchRetryPlan(publicHostname, byteStringOf$default);
            }
        }
        return null;
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
    public final Object getStackTraceForCloseable() {
        if (Build.VERSION.SDK_INT < 30) {
            return super.getStackTraceForCloseable();
        }
        CloseGuard closeGuard = new CloseGuard();
        closeGuard.open("response.body().close()");
        return closeGuard;
    }

    @Override // okhttp3.internal.platform.Platform
    public final void logCloseableLeak(Object obj, String str) {
        if (Build.VERSION.SDK_INT < 30) {
            super.logCloseableLeak(obj, str);
        } else {
            obj.getClass();
            ((CloseGuard) obj).warnIfOpen();
        }
    }

    @Override // okhttp3.internal.platform.ContextAwarePlatform
    public final void setApplicationContext(Context context) {
        this.applicationContext = context;
    }
}
