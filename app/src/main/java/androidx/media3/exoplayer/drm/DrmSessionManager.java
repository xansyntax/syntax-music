package androidx.media3.exoplayer.drm;

import android.os.Looper;
import androidx.media3.common.Format;
import androidx.media3.exoplayer.analytics.PlayerId;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface DrmSessionManager {
    public static final AnonymousClass1 DRM_UNSUPPORTED = new AnonymousClass1();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface DrmSessionReference {
        public static final FrameworkMediaDrm$$ExternalSyntheticLambda0 EMPTY = new FrameworkMediaDrm$$ExternalSyntheticLambda0(8);

        void release();
    }

    DrmSession acquireSession(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    int getCryptoType(Format format);

    default DrmSessionReference preacquireSession(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        return DrmSessionReference.EMPTY;
    }

    void setPlayer(Looper looper, PlayerId playerId);

    default void prepare() {
    }

    default void release() {
    }

    /* JADX INFO: renamed from: androidx.media3.exoplayer.drm.DrmSessionManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements DrmSessionManager {
        @Override // androidx.media3.exoplayer.drm.DrmSessionManager
        public final DrmSession acquireSession(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
            if (format.drmInitData == null) {
                return null;
            }
            return new ErrorStateDrmSession(new DrmSession.DrmSessionException(new UnsupportedDrmException(), 6001));
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionManager
        public final int getCryptoType(Format format) {
            return format.drmInitData != null ? 1 : 0;
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionManager
        public final void setPlayer(Looper looper, PlayerId playerId) {
        }
    }
}
