package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ConscryptSocketAdapter$Companion$factory$1 implements DeferredSocketAdapter.Factory {
    @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
    public final SocketAdapter create(SSLSocket sSLSocket) {
        return new ConscryptSocketAdapter();
    }

    @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
    public final boolean matchesSocket(SSLSocket sSLSocket) {
        return ConscryptSocketAdapter.isSupported && Conscrypt.isConscrypt(sSLSocket);
    }
}
