package androidx.media3.exoplayer.drm;

import android.os.Handler;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.Util$$ExternalSyntheticLambda1;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.extractor.text.CueDecoder;
import androidx.profileinstaller.DeviceProfileWriter$$ExternalSyntheticLambda0;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface DrmSessionEventListener {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class EventDispatcher {
        public final CopyOnWriteArrayList listenerAndHandlers;
        public final MediaSource$MediaPeriodId mediaPeriodId;
        public final int windowIndex;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class ListenerAndHandler {
            public Handler handler;
            public DrmSessionEventListener listener;
        }

        public EventDispatcher(CopyOnWriteArrayList copyOnWriteArrayList, int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
            this.listenerAndHandlers = copyOnWriteArrayList;
            this.windowIndex = i;
            this.mediaPeriodId = mediaSource$MediaPeriodId;
        }

        public final void drmKeysLoaded(CueDecoder cueDecoder) {
            for (ListenerAndHandler listenerAndHandler : this.listenerAndHandlers) {
                Util.postOrRun(listenerAndHandler.handler, new Util$$ExternalSyntheticLambda1((Object) this, (Object) listenerAndHandler.listener, (Object) cueDecoder, (byte) 11));
            }
        }

        public final void drmKeysRestored() {
            for (ListenerAndHandler listenerAndHandler : this.listenerAndHandlers) {
                Util.postOrRun(listenerAndHandler.handler, new DrmSessionEventListener$EventDispatcher$$ExternalSyntheticLambda2(this, listenerAndHandler.listener, (byte) 1));
            }
        }

        public final void drmSessionAcquired(int i) {
            for (ListenerAndHandler listenerAndHandler : this.listenerAndHandlers) {
                Util.postOrRun(listenerAndHandler.handler, new DeviceProfileWriter$$ExternalSyntheticLambda0(this, listenerAndHandler.listener, i, (byte) 2));
            }
        }

        public final void drmSessionManagerError(Exception exc) {
            for (ListenerAndHandler listenerAndHandler : this.listenerAndHandlers) {
                Util.postOrRun(listenerAndHandler.handler, new Util$$ExternalSyntheticLambda1((Object) this, (Object) listenerAndHandler.listener, (Object) exc, (byte) 10));
            }
        }

        public final void drmSessionReleased() {
            for (ListenerAndHandler listenerAndHandler : this.listenerAndHandlers) {
                Util.postOrRun(listenerAndHandler.handler, new DrmSessionEventListener$EventDispatcher$$ExternalSyntheticLambda2(this, listenerAndHandler.listener, (byte) 0));
            }
        }
    }

    void onDrmKeysLoaded(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, CueDecoder cueDecoder);

    void onDrmKeysRestored(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId);

    void onDrmSessionAcquired(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, int i2);

    void onDrmSessionManagerError(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Exception exc);

    void onDrmSessionReleased(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId);
}
