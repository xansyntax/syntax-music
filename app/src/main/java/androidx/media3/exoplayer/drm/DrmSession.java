package androidx.media3.exoplayer.drm;

import java.io.IOException;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface DrmSession {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DrmSessionException extends IOException {
        public final int errorCode;

        public DrmSessionException(Throwable th, int i) {
            super(th);
            this.errorCode = i;
        }
    }

    void acquire(DrmSessionEventListener.EventDispatcher eventDispatcher);

    FrameworkCryptoConfig getCryptoConfig();

    DrmSessionException getError();

    UUID getSchemeUuid();

    int getState();

    boolean playClearSamplesWithoutKeys();

    void release(DrmSessionEventListener.EventDispatcher eventDispatcher);

    boolean requiresSecureDecoder(String str);
}
