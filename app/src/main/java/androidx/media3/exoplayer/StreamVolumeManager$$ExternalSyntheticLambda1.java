package androidx.media3.exoplayer;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Looper;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.collection.ArraySet;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.media3.common.Timeline$$ExternalSyntheticLambda0;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.common.util.SystemHandlerWrapper;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher;
import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda52;
import androidx.media3.session.SessionToken;
import coil3.util.UtilsKt;
import io.ktor.http.ContentType;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StreamVolumeManager$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ StreamVolumeManager$$ExternalSyntheticLambda1(Object obj, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        byte b2 = 1;
        int i = this.f$1;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                RulerTrackingMap rulerTrackingMap = (RulerTrackingMap) obj;
                Context context = (Context) rulerTrackingMap.rulers;
                AudioManager audioManager = (AudioManager) context.getSystemService(ContentType.Audio.TYPE);
                audioManager.getClass();
                rulerTrackingMap.layoutNodes = audioManager;
                NetworkTypeObserver.Receiver receiver = new NetworkTypeObserver.Receiver((byte) 2, rulerTrackingMap);
                try {
                    context.registerReceiver(receiver, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
                    rulerTrackingMap.newRulers = receiver;
                } catch (RuntimeException e) {
                    Log.w("StreamVolumeManager", "Error registering stream volume receiver", e);
                }
                ((RulerTrackingMap) rulerTrackingMap.accessFlags).setStateInBackground(rulerTrackingMap.generateState(i));
                break;
            case 1:
                ((IntConsumer) obj).accept(i);
                break;
            case 2:
                ExoPlayerImpl.ComponentListener componentListener = ((AudioRendererEventListener$EventDispatcher) obj).listener;
                String str = Util.DEVICE_DEBUG_INFO;
                RulerTrackingMap rulerTrackingMap2 = ExoPlayerImpl.this.audioSessionIdState;
                Timeline$$ExternalSyntheticLambda0 timeline$$ExternalSyntheticLambda0 = new Timeline$$ExternalSyntheticLambda0((byte) 2, i);
                rulerTrackingMap2.getClass();
                UtilsKt.checkState(Looper.myLooper() == ((SystemHandlerWrapper) rulerTrackingMap2.values).handler.getLooper());
                rulerTrackingMap2.size++;
                rulerTrackingMap2.runInBackground(new ComponentActivity$$ExternalSyntheticLambda10(rulerTrackingMap2, timeline$$ExternalSyntheticLambda0, (byte) 6));
                rulerTrackingMap2.updateStateInForeground(Integer.valueOf(i));
                break;
            default:
                MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) obj;
                ArraySet arraySet = mediaControllerImplBase.pendingMaskingSequencedFutureNumbers;
                arraySet.remove(Integer.valueOf(i));
                mediaControllerImplBase.pendingCustomActionProgressListeners.delete(i);
                SessionToken sessionToken = mediaControllerImplBase.connectedToken;
                if (sessionToken != null && sessionToken.impl.getInterfaceVersion() < 5 && arraySet.isEmpty()) {
                    mediaControllerImplBase.fallbackPlaybackInfoUpdateHandler.postDelayed(new MediaControllerImplBase$$ExternalSyntheticLambda52(mediaControllerImplBase, b2), 500L);
                    break;
                }
                break;
        }
    }
}
