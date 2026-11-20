package androidx.media3.common.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.audio.AudioCapabilities;
import androidx.media3.exoplayer.audio.AudioCapabilitiesReceiver;
import androidx.media3.exoplayer.scheduler.RequirementsWatcher;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter$$ExternalSyntheticLambda0;
import androidx.media3.session.AndroidAutoConnectionStateObserver;
import androidx.media3.session.AndroidAutoConnectionStateObserver$$ExternalSyntheticLambda0;
import androidx.media3.session.MediaSessionLegacyStub;
import androidx.media3.session.legacy.MediaControllerCompat$MediaControllerImplApi23;
import com.metrolist.music.playback.MusicService;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlinx.coroutines.StandaloneCoroutine;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NetworkTypeObserver {
    public static NetworkTypeObserver staticInstance;
    public final Executor backgroundExecutor;
    public boolean isInitialized;
    public final CopyOnWriteArrayList listeners;
    public final Object lock;
    public int networkType;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api31 {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class DisplayInfoCallback extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {
            public final NetworkTypeObserver instance;

            public DisplayInfoCallback(NetworkTypeObserver networkTypeObserver) {
                this.instance = networkTypeObserver;
            }

            public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
                this.instance.updateNetworkType(overrideNetworkType == 3 || overrideNetworkType == 4 || overrideNetworkType == 5 ? 10 : 5);
            }
        }

        public static void disambiguate4gAnd5gNsa(Context context, NetworkTypeObserver networkTypeObserver) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                telephonyManager.getClass();
                DisplayInfoCallback displayInfoCallback = new DisplayInfoCallback(networkTypeObserver);
                telephonyManager.registerTelephonyCallback(networkTypeObserver.backgroundExecutor, displayInfoCallback);
                telephonyManager.unregisterTelephonyCallback(displayInfoCallback);
            } catch (RuntimeException unused) {
                networkTypeObserver.updateNetworkType(5);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ListenerHolder {
        public final Executor executor;
        public final WeakReference listener;

        public ListenerHolder(DefaultBandwidthMeter$$ExternalSyntheticLambda0 defaultBandwidthMeter$$ExternalSyntheticLambda0, Executor executor) {
            this.listener = new WeakReference(defaultBandwidthMeter$$ExternalSyntheticLambda0);
            this.executor = executor;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Receiver extends BroadcastReceiver {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ Receiver(byte b, Object obj) {
            this.$r8$classId = b;
            this.this$0 = obj;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            KeyEvent keyEvent;
            switch (this.$r8$classId) {
                case 0:
                    ((NetworkTypeObserver) this.this$0).backgroundExecutor.execute(new ComponentActivity$$ExternalSyntheticLambda10(this, context, (byte) 8));
                    break;
                case 1:
                    ((BaseMenuWrapper) this.this$0).onChange();
                    break;
                case 2:
                    ((RulerTrackingMap) ((RulerTrackingMap) this.this$0).accessFlags).runInBackground(new ActivityCompat$$ExternalSyntheticLambda0((byte) 18, (Object) this));
                    break;
                case 3:
                    AudioCapabilitiesReceiver audioCapabilitiesReceiver = (AudioCapabilitiesReceiver) this.this$0;
                    if (!isInitialStickyBroadcast()) {
                        audioCapabilitiesReceiver.onNewAudioCapabilities(AudioCapabilities.getCapabilitiesInternal(context, intent, audioCapabilitiesReceiver.audioAttributes, audioCapabilitiesReceiver.routedDevice, audioCapabilitiesReceiver.getSpatializerChannelMasks()));
                    }
                    break;
                case 4:
                    if (!isInitialStickyBroadcast()) {
                        ((RequirementsWatcher) this.this$0).checkRequirements();
                    }
                    break;
                case 5:
                    AndroidAutoConnectionStateObserver androidAutoConnectionStateObserver = (AndroidAutoConnectionStateObserver) this.this$0;
                    androidAutoConnectionStateObserver.backgroundExecutor.execute(new AndroidAutoConnectionStateObserver$$ExternalSyntheticLambda0(androidAutoConnectionStateObserver, (byte) 2));
                    break;
                case 6:
                    if (Objects.equals(intent.getAction(), "android.intent.action.MEDIA_BUTTON") && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null) {
                        ((MediaControllerCompat$MediaControllerImplApi23) ((CallbackWrapper) ((MediaSessionLegacyStub) this.this$0).sessionCompat.mExecutor).mCallback).controllerFwk.dispatchMediaButtonEvent(keyEvent);
                    }
                    break;
                default:
                    context.getClass();
                    intent.getClass();
                    String action = intent.getAction();
                    if (action != null) {
                        int iHashCode = action.hashCode();
                        if (iHashCode != -2128145023) {
                            if (iHashCode == -1454123155 && action.equals("android.intent.action.SCREEN_ON")) {
                                ((MusicService) this.this$0).isScreenOff = false;
                                ExoPlayerImpl exoPlayerImpl = ((MusicService) this.this$0).player;
                                if (exoPlayerImpl != null && exoPlayerImpl.isPlaying()) {
                                    ((MusicService) this.this$0).startWidgetUpdates();
                                }
                                Timber.Forest.tag("DiscordSvc");
                                ConnectionPool.i(new Object[0]);
                                MusicService musicService = (MusicService) this.this$0;
                                musicService.screenOffHandler.removeCallbacks(musicService.screenOffTimeout);
                                MusicService musicService2 = (MusicService) this.this$0;
                                musicService2.screenOffHandler.removeCallbacks(musicService2.pauseTimeout);
                                ((MusicService) this.this$0).discordIntentionalDisconnect = false;
                                ((MusicService) this.this$0).syncDiscordState();
                            }
                            break;
                        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                            ((MusicService) this.this$0).isScreenOff = true;
                            MusicService musicService3 = (MusicService) this.this$0;
                            StandaloneCoroutine standaloneCoroutine = musicService3.widgetUpdateJob;
                            if (standaloneCoroutine != null) {
                                standaloneCoroutine.cancel(null);
                            }
                            musicService3.widgetUpdateJob = null;
                            Timber.Forest.tag("DiscordSvc");
                            ConnectionPool.i(new Object[0]);
                            MusicService musicService4 = (MusicService) this.this$0;
                            musicService4.screenOffHandler.removeCallbacks(musicService4.pauseTimeout);
                            MusicService musicService5 = (MusicService) this.this$0;
                            musicService5.screenOffHandler.postDelayed(musicService5.screenOffTimeout, 600000L);
                            break;
                        }
                    }
                    break;
            }
        }
    }

    public NetworkTypeObserver(Context context) {
        Executor executor = Log.get();
        this.backgroundExecutor = executor;
        this.listeners = new CopyOnWriteArrayList();
        this.lock = new Object();
        this.networkType = 0;
        executor.execute(new ComponentActivity$$ExternalSyntheticLambda10(this, context, (byte) 7));
    }

    public static synchronized NetworkTypeObserver getInstance(Context context) {
        NetworkTypeObserver networkTypeObserver;
        networkTypeObserver = staticInstance;
        if (networkTypeObserver == null) {
            networkTypeObserver = new NetworkTypeObserver(context);
            staticInstance = networkTypeObserver;
        }
        return networkTypeObserver;
    }

    public final int getNetworkType() {
        int i;
        synchronized (this.lock) {
            i = this.networkType;
        }
        return i;
    }

    public final void updateNetworkType(int i) {
        CopyOnWriteArrayList<ListenerHolder> copyOnWriteArrayList = this.listeners;
        for (ListenerHolder listenerHolder : copyOnWriteArrayList) {
            if (listenerHolder.listener.get() == null) {
                copyOnWriteArrayList.remove(listenerHolder);
            }
        }
        synchronized (this.lock) {
            try {
                if (this.isInitialized && this.networkType == i) {
                    return;
                }
                this.isInitialized = true;
                this.networkType = i;
                for (ListenerHolder listenerHolder2 : this.listeners) {
                    listenerHolder2.executor.execute(new ActivityCompat$$ExternalSyntheticLambda0((byte) 14, (Object) listenerHolder2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
