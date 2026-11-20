package okhttp3.internal.platform.android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.Platform;
import okio.ByteString;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public class AndroidSocketAdapter implements SocketAdapter {
    public static final Path.Companion playProviderFactory = new Path.Companion(16);
    public final Method getAlpnSelectedProtocol;
    public final Method setAlpnProtocols;
    public final Method setUseSessionTickets;
    public final Class sslSocketClass;

    public AndroidSocketAdapter(Class cls) throws NoSuchMethodException {
        this.sslSocketClass = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        declaredMethod.getClass();
        this.setUseSessionTickets = declaredMethod;
        cls.getMethod("setHostname", String.class);
        this.getAlpnSelectedProtocol = cls.getMethod("getAlpnSelectedProtocol", null);
        this.setAlpnProtocols = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List list, ByteString byteString) {
        if (this.sslSocketClass.isInstance(sSLSocket)) {
            try {
                this.setUseSessionTickets.invoke(sSLSocket, Boolean.TRUE);
                Method method = this.setAlpnProtocols;
                Platform platform = Platform.platform;
                method.invoke(sSLSocket, Path.Companion.concatLengthPrefixed(list));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        if (this.sslSocketClass.isInstance(sSLSocket)) {
            try {
                byte[] bArr = (byte[]) this.getAlpnSelectedProtocol.invoke(sSLSocket, null);
                if (bArr != null) {
                    return new String(bArr, Charsets.UTF_8);
                }
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (!(cause instanceof NullPointerException) || !Intrinsics.areEqual(((NullPointerException) cause).getMessage(), "ssl == null")) {
                    throw new AssertionError(e2);
                }
            }
        }
        return null;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean isSupported() {
        boolean z = AndroidPlatform.isSupported;
        return AndroidPlatform.isSupported;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean matchesSocket(SSLSocket sSLSocket) {
        return this.sslSocketClass.isInstance(sSLSocket);
    }
}
