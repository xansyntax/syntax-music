package androidx.room;

import android.content.Intent;
import android.media.session.MediaController;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ResultReceiver;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.CodecParameters;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda4;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.session.IMediaController;
import androidx.media3.session.LegacyConversions;
import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.MediaControllerImplLegacy;
import androidx.media3.session.MediaControllerStub;
import androidx.media3.session.MediaLibraryServiceLegacyStub;
import androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda7;
import androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda8;
import androidx.media3.session.MediaLibrarySessionImpl;
import androidx.media3.session.MediaSession$ControllerInfo;
import androidx.media3.session.MediaSessionService;
import androidx.media3.session.MediaSessionStub;
import androidx.media3.session.PlayerWrapper;
import androidx.media3.session.SessionResult;
import androidx.media3.session.legacy.IMediaSession;
import androidx.media3.session.legacy.MediaBrowserServiceCompat$2;
import androidx.media3.session.legacy.MediaControllerCompat$Callback$CallbackStub;
import androidx.media3.session.legacy.MediaControllerCompat$Callback$MediaControllerCallback;
import androidx.media3.session.legacy.MediaControllerCompat$MediaControllerImplApi23;
import androidx.media3.session.legacy.MediaSessionCompat$Token;
import androidx.room.concurrent.FileLock;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.util.concurrent.DirectExecutor;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.metrolist.music.playback.MusicService;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.selects.OnTimeout;
import kotlinx.coroutines.selects.SelectImplementation;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TransactionExecutor$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ TransactionExecutor$$ExternalSyntheticLambda0(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, Runnable runnable) {
        this.$r8$classId = (byte) 9;
        this.f$1 = mediaLibrarySessionImpl;
        this.f$0 = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        SessionResult sessionResult;
        byte b = 0;
        byte b2 = 1;
        switch (this.$r8$classId) {
            case 0:
                Runnable runnable = (Runnable) this.f$0;
                TransactionExecutor transactionExecutor = (TransactionExecutor) this.f$1;
                try {
                    runnable.run();
                    return;
                } finally {
                    transactionExecutor.scheduleNext();
                }
            case 1:
                AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = (AudioRendererEventListener$EventDispatcher) this.f$0;
                CodecParameters codecParameters = (CodecParameters) this.f$1;
                ExoPlayerImpl.ComponentListener componentListener = audioRendererEventListener$EventDispatcher.listener;
                String str = Util.DEVICE_DEBUG_INFO;
                ExoPlayerImpl.this.videoListenerManager.onParametersChanged(codecParameters);
                return;
            case 2:
                AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher2 = (AudioRendererEventListener$EventDispatcher) this.f$0;
                VideoSize videoSize = (VideoSize) this.f$1;
                ExoPlayerImpl.ComponentListener componentListener2 = audioRendererEventListener$EventDispatcher2.listener;
                String str2 = Util.DEVICE_DEBUG_INFO;
                ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
                exoPlayerImpl.videoSize = videoSize;
                exoPlayerImpl.listeners.sendEvent(25, new ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda4(videoSize));
                return;
            case 3:
                AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher3 = (AudioRendererEventListener$EventDispatcher) this.f$0;
                DecoderCounters decoderCounters = (DecoderCounters) this.f$1;
                synchronized (decoderCounters) {
                }
                ExoPlayerImpl.ComponentListener componentListener3 = audioRendererEventListener$EventDispatcher3.listener;
                String str3 = Util.DEVICE_DEBUG_INFO;
                DefaultAnalyticsCollector defaultAnalyticsCollector = ExoPlayerImpl.this.analyticsCollector;
                AnalyticsListener.EventTime eventTimeGenerateEventTime = defaultAnalyticsCollector.generateEventTime((MediaSource$MediaPeriodId) defaultAnalyticsCollector.mediaPeriodQueueTracker.moments);
                defaultAnalyticsCollector.sendEvent(eventTimeGenerateEventTime, 1020, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0(eventTimeGenerateEventTime, (Object) decoderCounters, (byte) 12));
                return;
            case 4:
                MediaControllerImplLegacy mediaControllerImplLegacy = (MediaControllerImplLegacy) this.f$0;
                CallbackWrapper callbackWrapper = new CallbackWrapper(mediaControllerImplLegacy.context, (MediaSessionCompat$Token) this.f$1);
                mediaControllerImplLegacy.controllerCompat = callbackWrapper;
                MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback = mediaControllerImplLegacy.controllerCompatCallback;
                Handler handler = mediaControllerImplLegacy.instance.applicationHandler;
                if (!((Set) callbackWrapper.mExecutor).add(controllerCompatCallback)) {
                    Log.w("MediaControllerCompat", "the callback has already been registered");
                    return;
                }
                if (handler == null) {
                    handler = new Handler();
                }
                controllerCompatCallback.setHandler(handler);
                MediaControllerCompat$MediaControllerImplApi23 mediaControllerCompat$MediaControllerImplApi23 = (MediaControllerCompat$MediaControllerImplApi23) callbackWrapper.mCallback;
                MediaController mediaController = mediaControllerCompat$MediaControllerImplApi23.controllerFwk;
                MediaControllerCompat$Callback$MediaControllerCallback mediaControllerCompat$Callback$MediaControllerCallback = controllerCompatCallback.callbackFwk;
                mediaControllerCompat$Callback$MediaControllerCallback.getClass();
                mediaController.registerCallback(mediaControllerCompat$Callback$MediaControllerCallback, handler);
                synchronized (mediaControllerCompat$MediaControllerImplApi23.lock) {
                    IMediaSession extraBinder = mediaControllerCompat$MediaControllerImplApi23.sessionToken.getExtraBinder();
                    if (extraBinder != null) {
                        MediaControllerCompat$Callback$CallbackStub mediaControllerCompat$Callback$CallbackStub = new MediaControllerCompat$Callback$CallbackStub(controllerCompatCallback);
                        mediaControllerCompat$MediaControllerImplApi23.callbackMap.put(controllerCompatCallback, mediaControllerCompat$Callback$CallbackStub);
                        controllerCompatCallback.iControllerCallback = mediaControllerCompat$Callback$CallbackStub;
                        try {
                            extraBinder.registerCallbackListener(mediaControllerCompat$Callback$CallbackStub);
                            controllerCompatCallback.postToHandler(13, null);
                        } catch (RemoteException | SecurityException e) {
                            Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                        }
                    } else {
                        controllerCompatCallback.iControllerCallback = null;
                        mediaControllerCompat$MediaControllerImplApi23.pendingCallbacks.add(controllerCompatCallback);
                    }
                    break;
                }
                return;
            case 5:
                MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) this.f$0;
                MediaControllerStub.ControllerTask controllerTask = (MediaControllerStub.ControllerTask) this.f$1;
                if (mediaControllerImplBase.released) {
                    return;
                }
                controllerTask.run(mediaControllerImplBase);
                return;
            case 6:
                ImmediateFuture immediateFuture = (ImmediateFuture) this.f$0;
                MediaBrowserServiceCompat$2 mediaBrowserServiceCompat$2 = (MediaBrowserServiceCompat$2) this.f$1;
                try {
                    SessionResult sessionResult2 = (SessionResult) immediateFuture.value;
                    UtilsKt.checkNotNull(sessionResult2, "SessionResult must not be null");
                    mediaBrowserServiceCompat$2.sendResult(sessionResult2.extras);
                    return;
                } catch (InterruptedException | CancellationException | ExecutionException e2) {
                    Log.w("MLSLegacyStub", "Custom action failed", e2);
                    mediaBrowserServiceCompat$2.sendError();
                    return;
                }
            case 7:
                SettableFuture settableFuture = (SettableFuture) this.f$0;
                ArrayList arrayList = (ArrayList) this.f$1;
                if (settableFuture.isCancelled()) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (arrayList.get(i3) != null) {
                            ((ListenableFuture) arrayList.get(i3)).cancel(false);
                        }
                    }
                    return;
                }
                return;
            case 8:
                MediaLibraryServiceLegacyStub.BrowserLegacyCb browserLegacyCb = (MediaLibraryServiceLegacyStub.BrowserLegacyCb) this.f$0;
                ArrayList arrayList2 = (ArrayList) this.f$1;
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = MediaLibraryServiceLegacyStub.this;
                MediaLibrarySessionImpl mediaLibrarySessionImpl = mediaLibraryServiceLegacyStub.librarySessionImpl;
                for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                    MediaLibraryServiceLegacyStub.SearchRequest searchRequest = (MediaLibraryServiceLegacyStub.SearchRequest) arrayList2.get(i4);
                    Bundle bundle = searchRequest.extras;
                    MediaBrowserServiceCompat$2 mediaBrowserServiceCompat$3 = searchRequest.result;
                    int i5 = Integer.MAX_VALUE;
                    if (bundle != null) {
                        try {
                            bundle.setClassLoader(mediaLibrarySessionImpl.context.getClassLoader());
                            i = bundle.getInt("android.media.browse.extra.PAGE", -1);
                            i2 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                        } catch (BadParcelableException unused) {
                            mediaBrowserServiceCompat$3.sendResult(null);
                            return;
                        }
                    } else {
                        i = 0;
                        i2 = Integer.MAX_VALUE;
                    }
                    if (i >= 0 && i2 >= 1) {
                        i5 = i2;
                    }
                    SettableFuture settableFutureTransformFutureAsync = Util.transformFutureAsync(mediaLibrarySessionImpl.onGetSearchResultOnHandler(searchRequest.controller, searchRequest.query, i5, LegacyConversions.convertToLibraryParams(mediaLibrarySessionImpl.context, bundle)), new MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda8(mediaLibraryServiceLegacyStub, b));
                    settableFutureTransformFutureAsync.addListener(new MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda7(settableFutureTransformFutureAsync, mediaBrowserServiceCompat$3, b2), DirectExecutor.INSTANCE);
                    break;
                }
                return;
            case 9:
                MediaLibrarySessionImpl mediaLibrarySessionImpl2 = (MediaLibrarySessionImpl) this.f$1;
                Runnable runnable2 = (Runnable) this.f$0;
                mediaLibrarySessionImpl2.getClass();
                runnable2.run();
                return;
            case 10:
                ((CallbackToFutureAdapter$Completer) this.f$1).set(Boolean.valueOf(((MediaLibrarySessionImpl) this.f$0).onPlayRequested()));
                return;
            case 11:
                ((MediaLibrarySessionImpl) this.f$0).setPlayerInternal(null, (PlayerWrapper) this.f$1);
                return;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ImmediateFuture immediateFuture2 = (ImmediateFuture) this.f$0;
                ResultReceiver resultReceiver = (ResultReceiver) this.f$1;
                try {
                    sessionResult = (SessionResult) immediateFuture2.value;
                    UtilsKt.checkNotNull(sessionResult, "SessionResult must not be null");
                    break;
                } catch (InterruptedException e3) {
                    e = e3;
                    Log.w("MediaSessionLegacyStub", "Custom command failed", e);
                    sessionResult = new SessionResult(-1);
                } catch (CancellationException e4) {
                    Log.w("MediaSessionLegacyStub", "Custom command cancelled", e4);
                    sessionResult = new SessionResult(1);
                } catch (ExecutionException e5) {
                    e = e5;
                    Log.w("MediaSessionLegacyStub", "Custom command failed", e);
                    sessionResult = new SessionResult(-1);
                }
                resultReceiver.send(sessionResult.resultCode, sessionResult.extras);
                return;
            case 13:
                MediaLibrarySessionImpl mediaLibrarySessionImpl3 = (MediaLibrarySessionImpl) this.f$0;
                Intent intent = (Intent) this.f$1;
                int i6 = MediaSessionService.$r8$clinit;
                MediaSession$ControllerInfo mediaNotificationControllerInfo = mediaLibrarySessionImpl3.getMediaNotificationControllerInfo();
                if (mediaNotificationControllerInfo == null) {
                    mediaNotificationControllerInfo = MediaSessionService.createFallbackMediaButtonCaller(intent);
                }
                if (mediaLibrarySessionImpl3.onMediaButtonEvent(mediaNotificationControllerInfo, intent)) {
                    return;
                }
                Log.d("Ignored unrecognized media button intent.");
                return;
            case 14:
                MusicService musicService = (MusicService) this.f$0;
                FileLock fileLock = (FileLock) this.f$1;
                int i7 = MediaSessionService.$r8$clinit;
                musicService.getMediaNotificationManager(fileLock).mediaNotificationProvider = fileLock;
                return;
            case 15:
                MediaSessionStub mediaSessionStub = (MediaSessionStub) this.f$0;
                IMediaController iMediaController = (IMediaController) this.f$1;
                Dispatcher dispatcher = mediaSessionStub.connectedControllersManager;
                MediaSession$ControllerInfo controller = dispatcher.getController(iMediaController.asBinder());
                if (controller != null) {
                    dispatcher.removeController(controller);
                    return;
                }
                return;
            case 16:
                ((MediaSessionStub) this.f$0).connectedControllersManager.flushCommandQueue((MediaSession$ControllerInfo) this.f$1);
                return;
            case 17:
                ((CancellableContinuationImpl) this.f$0).resumeUndispatched((HandlerContext) this.f$1);
                return;
            default:
                ((SelectImplementation) this.f$0).trySelectInternal((OnTimeout) this.f$1, Unit.INSTANCE);
                return;
        }
    }

    public /* synthetic */ TransactionExecutor$$ExternalSyntheticLambda0(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }
}
