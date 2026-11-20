package androidx.media3.exoplayer.drm;

import androidx.media3.common.C;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ErrorStateDrmSession implements DrmSession {
    public final DrmSession.DrmSessionException error;

    public ErrorStateDrmSession(DrmSession.DrmSessionException drmSessionException) {
        this.error = drmSessionException;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final FrameworkCryptoConfig getCryptoConfig() {
        return null;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final DrmSession.DrmSessionException getError() {
        return this.error;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final UUID getSchemeUuid() {
        return C.UUID_NIL;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final int getState() {
        return 1;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final boolean playClearSamplesWithoutKeys() {
        return false;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final boolean requiresSecureDecoder(String str) {
        return false;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final void acquire(DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final void release(DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }
}
