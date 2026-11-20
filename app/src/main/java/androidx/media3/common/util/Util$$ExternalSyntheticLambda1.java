package androidx.media3.common.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioTrack;
import android.media.metrics.LogSessionId;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.ActionMode;
import android.view.KeyEvent;
import androidx.compose.animation.core.FloatTweenSpec;
import androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider;
import androidx.compose.foundation.text.contextmenu.internal.FloatingTextActionModeCallback;
import androidx.compose.ui.scrollcapture.ScrollCapture;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.app.ActivityRecreator;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.MediaPeriodQueue;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.analytics.MediaMetricsListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioTrackAudioOutput;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.session.CommandButton;
import androidx.media3.session.LegacyConversions;
import androidx.media3.session.LibraryResult;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaLibraryServiceLegacyStub;
import androidx.media3.session.MediaLibrarySessionImpl;
import androidx.media3.session.MediaNotificationManager;
import androidx.media3.session.MediaSession$ControllerInfo;
import androidx.media3.session.MediaSession$MediaItemsWithStartPosition;
import androidx.media3.session.MediaSessionImpl$MediaPlayPauseKeyHandler;
import androidx.media3.session.MediaSessionLegacyStub;
import androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda1;
import androidx.media3.session.MediaUtils;
import androidx.media3.session.SessionCommand;
import androidx.media3.session.SessionCommands;
import androidx.media3.session.SessionResult;
import androidx.media3.session.legacy.MediaSessionManager$RemoteUserInfo;
import androidx.navigation.internal.NavContext;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil3.size.SizeKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.DirectExecutor;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.materialkolor.quantize.QuantizerWu;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.InternalDatabase;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.MusicDatabase$$ExternalSyntheticLambda0;
import java.util.Collection;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.jvm.functions.Function1;
import kotlin.uuid.UuidKt;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Util$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ Util$$ExternalSyntheticLambda1(MediaNotificationManager mediaNotificationManager, MediaController mediaController, String str, Bundle bundle) {
        this.$r8$classId = (byte) 17;
        this.f$0 = mediaController;
        this.f$1 = str;
        this.f$2 = bundle;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00df  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e4  */
    @Override // java.lang.Runnable
    public final void run() {
        SessionCommand sessionCommand;
        ListenableFuture immediateFuture;
        Bitmap bitmap = null;
        SessionCommand sessionCommand2 = null;
        byte b = 0;
        byte b2 = 1;
        switch (this.$r8$classId) {
            case 0:
                ListenableFuture listenableFuture = (ListenableFuture) this.f$0;
                SettableFuture settableFuture = (SettableFuture) this.f$1;
                try {
                    try {
                        settableFuture.setFuture(((AsyncFunction) this.f$2).apply(UuidKt.getDone(listenableFuture)));
                        return;
                    } catch (Throwable th) {
                        settableFuture.setException(th);
                        return;
                    }
                } catch (Error e) {
                    e = e;
                    settableFuture.setException(e);
                    return;
                } catch (CancellationException unused) {
                    settableFuture.cancel(false);
                    return;
                } catch (RuntimeException e2) {
                    e = e2;
                    settableFuture.setException(e);
                    return;
                } catch (ExecutionException e3) {
                    e = e3;
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        e = cause;
                    }
                    settableFuture.setException(e);
                    return;
                }
            case 1:
                AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider = (AndroidTextContextMenuToolbarProvider) this.f$0;
                AndroidTextContextMenuToolbarProvider.TextActionModeCallbackImpl textActionModeCallbackImpl = (AndroidTextContextMenuToolbarProvider.TextActionModeCallbackImpl) this.f$1;
                AndroidTextContextMenuToolbarProvider.TextContextMenuSessionImpl textContextMenuSessionImpl = (AndroidTextContextMenuToolbarProvider.TextContextMenuSessionImpl) this.f$2;
                ActionMode actionModeStartActionMode = androidTextContextMenuToolbarProvider.view.startActionMode(new FloatingTextActionModeCallback(textActionModeCallbackImpl), 1);
                androidTextContextMenuToolbarProvider.actionMode = actionModeStartActionMode;
                if (actionModeStartActionMode == null) {
                    textContextMenuSessionImpl.close();
                    return;
                }
                return;
            case 2:
                NavContext navContext = (NavContext) this.f$0;
                final SizeKt sizeKt = (SizeKt) this.f$1;
                final ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f$2;
                try {
                    FontRequestEmojiCompatConfig fontRequestEmojiCompatConfigCreate = DatabaseDao_Impl.AnonymousClass17.create(navContext.context);
                    if (fontRequestEmojiCompatConfigCreate == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader = (FontRequestEmojiCompatConfig.FontRequestMetadataLoader) fontRequestEmojiCompatConfigCreate.mMetadataLoader;
                    synchronized (fontRequestMetadataLoader.mLock) {
                        fontRequestMetadataLoader.mExecutor = threadPoolExecutor;
                        break;
                    }
                    fontRequestEmojiCompatConfigCreate.mMetadataLoader.load(new SizeKt() { // from class: androidx.emoji2.text.EmojiCompatInitializer$BackgroundDefaultLoader$1
                        @Override // coil3.size.SizeKt
                        public final void onFailed(Throwable th2) {
                            ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                            try {
                                sizeKt.onFailed(th2);
                            } finally {
                                threadPoolExecutor2.shutdown();
                            }
                        }

                        @Override // coil3.size.SizeKt
                        public final void onLoaded(Dispatcher dispatcher) {
                            ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                            try {
                                sizeKt.onLoaded(dispatcher);
                            } finally {
                                threadPoolExecutor2.shutdown();
                            }
                        }
                    });
                    return;
                } catch (Throwable th2) {
                    sizeKt.onFailed(th2);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 3:
                SettableFuture settableFuture2 = (SettableFuture) this.f$1;
                TransactionExecutor$$ExternalSyntheticLambda0 transactionExecutor$$ExternalSyntheticLambda0 = (TransactionExecutor$$ExternalSyntheticLambda0) this.f$0;
                SessionResult sessionResult = (SessionResult) this.f$2;
                try {
                    if (settableFuture2.isCancelled()) {
                        return;
                    }
                    transactionExecutor$$ExternalSyntheticLambda0.run();
                    settableFuture2.set(sessionResult);
                    return;
                } catch (Throwable th3) {
                    settableFuture2.setException(th3);
                    return;
                }
            case 4:
                Context context = (Context) this.f$0;
                ExoPlayerImpl exoPlayerImpl = (ExoPlayerImpl) this.f$1;
                PlayerId playerId = (PlayerId) this.f$2;
                MediaMetricsListener mediaMetricsListenerCreate = MediaMetricsListener.create(context);
                if (mediaMetricsListenerCreate == null) {
                    Log.w("ExoPlayerImpl", "MediaMetricsService unavailable.");
                    return;
                }
                DefaultAnalyticsCollector defaultAnalyticsCollector = exoPlayerImpl.analyticsCollector;
                defaultAnalyticsCollector.getClass();
                defaultAnalyticsCollector.listeners.add(mediaMetricsListenerCreate);
                LogSessionId logSessionId = mediaMetricsListenerCreate.getLogSessionId();
                synchronized (playerId) {
                    ScrollCapture scrollCapture = playerId.logSessionIdApi31;
                    scrollCapture.getClass();
                    scrollCapture.setLogSessionId(logSessionId);
                }
                return;
            case 5:
                MediaPeriodQueue mediaPeriodQueue = (MediaPeriodQueue) this.f$0;
                ImmutableList.Builder builder = (ImmutableList.Builder) this.f$1;
                MediaSource$MediaPeriodId mediaSource$MediaPeriodId = (MediaSource$MediaPeriodId) this.f$2;
                DefaultAnalyticsCollector defaultAnalyticsCollector2 = mediaPeriodQueue.analyticsCollector;
                RegularImmutableList regularImmutableListBuild = builder.build();
                QuantizerWu quantizerWu = defaultAnalyticsCollector2.mediaPeriodQueueTracker;
                Player player = defaultAnalyticsCollector2.player;
                player.getClass();
                quantizerWu.momentsR = ImmutableList.copyOf((Collection) regularImmutableListBuild);
                if (!regularImmutableListBuild.isEmpty()) {
                    quantizerWu.moments = (MediaSource$MediaPeriodId) regularImmutableListBuild.get(0);
                    mediaSource$MediaPeriodId.getClass();
                    quantizerWu.cubes = mediaSource$MediaPeriodId;
                }
                if (((MediaSource$MediaPeriodId) quantizerWu.momentsB) == null) {
                    quantizerWu.momentsB = QuantizerWu.findCurrentPlayerMediaPeriodInQueue(player, (ImmutableList) quantizerWu.momentsR, (MediaSource$MediaPeriodId) quantizerWu.moments, (Timeline.Period) quantizerWu.weights);
                }
                quantizerWu.updateMediaPeriodTimelines(player.getCurrentTimeline());
                return;
            case 6:
                MediaSourceList.ForwardingEventListener forwardingEventListener = (MediaSourceList.ForwardingEventListener) this.f$0;
                Pair pair = (Pair) this.f$1;
                MediaSourceList.this.eventListener.onDownstreamFormatChanged(((Integer) pair.first).intValue(), (MediaSource$MediaPeriodId) pair.second, (FloatTweenSpec) this.f$2);
                return;
            case 7:
                MediaSourceList.ForwardingEventListener forwardingEventListener2 = (MediaSourceList.ForwardingEventListener) this.f$0;
                Pair pair2 = (Pair) this.f$1;
                MediaSourceList.this.eventListener.onDrmSessionManagerError(((Integer) pair2.first).intValue(), (MediaSource$MediaPeriodId) pair2.second, (Exception) this.f$2);
                return;
            case 8:
                MediaSourceList.ForwardingEventListener forwardingEventListener3 = (MediaSourceList.ForwardingEventListener) this.f$0;
                Pair pair3 = (Pair) this.f$1;
                MediaSourceList.this.eventListener.onDrmKeysLoaded(((Integer) pair3.first).intValue(), (MediaSource$MediaPeriodId) pair3.second, (CueDecoder) this.f$2);
                return;
            case 9:
                AudioTrack audioTrack = (AudioTrack) this.f$0;
                Handler handler = (Handler) this.f$1;
                ListenerSet listenerSet = (ListenerSet) this.f$2;
                byte b3 = 21;
                try {
                    audioTrack.flush();
                    audioTrack.release();
                    if (handler.getLooper().getThread().isAlive()) {
                        handler.post(new ActivityCompat$$ExternalSyntheticLambda0(b3, listenerSet));
                    }
                    synchronized (AudioTrackAudioOutput.releaseExecutorLock) {
                        try {
                            int i = AudioTrackAudioOutput.pendingReleaseCount - 1;
                            AudioTrackAudioOutput.pendingReleaseCount = i;
                            if (i == 0) {
                                ScheduledExecutorService scheduledExecutorService = AudioTrackAudioOutput.releaseExecutor;
                                scheduledExecutorService.getClass();
                                scheduledExecutorService.shutdown();
                                AudioTrackAudioOutput.releaseExecutor = null;
                            }
                        } catch (Throwable th4) {
                            throw th4;
                        }
                        break;
                    }
                    return;
                } catch (Throwable th5) {
                    if (handler.getLooper().getThread().isAlive()) {
                        handler.post(new ActivityCompat$$ExternalSyntheticLambda0(b3, listenerSet));
                    }
                    synchronized (AudioTrackAudioOutput.releaseExecutorLock) {
                        try {
                            int i2 = AudioTrackAudioOutput.pendingReleaseCount - 1;
                            AudioTrackAudioOutput.pendingReleaseCount = i2;
                            if (i2 == 0) {
                                ScheduledExecutorService scheduledExecutorService2 = AudioTrackAudioOutput.releaseExecutor;
                                scheduledExecutorService2.getClass();
                                scheduledExecutorService2.shutdown();
                                AudioTrackAudioOutput.releaseExecutor = null;
                            }
                            throw th5;
                        } catch (Throwable th6) {
                            throw th6;
                        }
                    }
                }
            case 10:
                DrmSessionEventListener.EventDispatcher eventDispatcher = (DrmSessionEventListener.EventDispatcher) this.f$0;
                ((DrmSessionEventListener) this.f$1).onDrmSessionManagerError(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, (Exception) this.f$2);
                return;
            case 11:
                DrmSessionEventListener.EventDispatcher eventDispatcher2 = (DrmSessionEventListener.EventDispatcher) this.f$0;
                ((DrmSessionEventListener) this.f$1).onDrmKeysLoaded(eventDispatcher2.windowIndex, eventDispatcher2.mediaPeriodId, (CueDecoder) this.f$2);
                return;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ListenableFuture listenableFuture2 = (ListenableFuture) this.f$0;
                SettableFuture settableFuture3 = (SettableFuture) this.f$1;
                MediaItem mediaItem = (MediaItem) this.f$2;
                try {
                    bitmap = (Bitmap) UuidKt.getDone(listenableFuture2);
                } catch (CancellationException | ExecutionException e4) {
                    Log.d("failed to get bitmap", e4);
                }
                settableFuture3.set(LegacyConversions.convertToBrowserItem(mediaItem, bitmap));
                return;
            case 13:
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = (MediaLibraryServiceLegacyStub) this.f$0;
                MediaSession$ControllerInfo mediaSession$ControllerInfo = (MediaSession$ControllerInfo) this.f$1;
                String str = (String) this.f$2;
                if (mediaLibraryServiceLegacyStub.connectedControllersManager.isSessionCommandAvailable(mediaSession$ControllerInfo, 50002)) {
                    mediaLibraryServiceLegacyStub.librarySessionImpl.onUnsubscribeOnHandler(mediaSession$ControllerInfo, str);
                    return;
                }
                return;
            case 14:
                MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) this.f$1;
                ListenableFuture listenableFuture3 = (ListenableFuture) this.f$0;
                MediaSession$ControllerInfo mediaSession$ControllerInfo2 = (MediaSession$ControllerInfo) this.f$2;
                mediaLibrarySessionImpl.getClass();
                LibraryResult libraryResult = (LibraryResult) MediaLibrarySessionImpl.tryGetFutureResult(listenableFuture3);
                if (libraryResult != null) {
                    mediaLibrarySessionImpl.maybeUpdateLegacyErrorState(mediaSession$ControllerInfo2, libraryResult);
                    return;
                }
                return;
            case 15:
                MediaLibrarySessionImpl mediaLibrarySessionImpl2 = (MediaLibrarySessionImpl) this.f$0;
                ImmediateFuture immediateFuture2 = (ImmediateFuture) this.f$1;
                MediaSession$ControllerInfo mediaSession$ControllerInfo3 = (MediaSession$ControllerInfo) this.f$2;
                mediaLibrarySessionImpl2.getClass();
                LibraryResult libraryResult2 = (LibraryResult) MediaLibrarySessionImpl.tryGetFutureResult(immediateFuture2);
                if (libraryResult2 != null) {
                    mediaLibrarySessionImpl2.maybeUpdateLegacyErrorState(mediaSession$ControllerInfo3, libraryResult2);
                    return;
                }
                return;
            case 16:
                ((MediaLibrarySessionImpl) this.f$0).removeSubscription((MediaSession$ControllerInfo) this.f$1, (String) this.f$2);
                return;
            case 17:
                MediaController mediaController = (MediaController) this.f$0;
                String str2 = (String) this.f$1;
                Bundle bundle = (Bundle) this.f$2;
                mediaController.verifyApplicationThread$2();
                MediaController.MediaControllerImpl mediaControllerImpl = mediaController.impl;
                UnmodifiableIterator it = (!mediaControllerImpl.isConnected() ? SessionCommands.EMPTY : mediaControllerImpl.getAvailableSessionCommands()).commands.iterator();
                while (it.hasNext()) {
                    SessionCommand sessionCommand3 = (SessionCommand) it.next();
                    if (sessionCommand3.commandCode == 0 && sessionCommand3.customAction.equals(str2)) {
                        sessionCommand2 = sessionCommand3;
                        if (sessionCommand2 == null || CommandButton.isPredefinedCustomCommandButtonCode(str2)) {
                            sessionCommand = new SessionCommand(str2, bundle);
                            mediaController.verifyApplicationThread$2();
                            if (mediaControllerImpl.isConnected()) {
                                immediateFuture = mediaControllerImpl.sendCustomCommand(sessionCommand, bundle);
                            } else {
                                immediateFuture = new ImmediateFuture(new SessionResult(-100));
                            }
                            immediateFuture.addListener(new ActivityRecreator.AnonymousClass1(immediateFuture, new Joiner(str2, (byte) 3), b2), DirectExecutor.INSTANCE);
                            return;
                        }
                        return;
                    }
                }
                if (sessionCommand2 == null) {
                }
                sessionCommand = new SessionCommand(str2, bundle);
                mediaController.verifyApplicationThread$2();
                if (mediaControllerImpl.isConnected()) {
                    immediateFuture = mediaControllerImpl.sendCustomCommand(sessionCommand, bundle);
                } else {
                    immediateFuture = new ImmediateFuture(new SessionResult(-100));
                }
                immediateFuture.addListener(new ActivityRecreator.AnonymousClass1(immediateFuture, new Joiner(str2, (byte) 3), b2), DirectExecutor.INSTANCE);
                return;
            case 18:
                MediaSessionImpl$MediaPlayPauseKeyHandler mediaSessionImpl$MediaPlayPauseKeyHandler = (MediaSessionImpl$MediaPlayPauseKeyHandler) this.f$0;
                MediaSession$ControllerInfo mediaSession$ControllerInfo4 = (MediaSession$ControllerInfo) this.f$1;
                KeyEvent keyEvent = (KeyEvent) this.f$2;
                MediaLibrarySessionImpl mediaLibrarySessionImpl3 = (MediaLibrarySessionImpl) mediaSessionImpl$MediaPlayPauseKeyHandler.this$0;
                if (mediaLibrarySessionImpl3.isMediaNotificationController(mediaSession$ControllerInfo4)) {
                    mediaLibrarySessionImpl3.applyMediaButtonKeyEvent(keyEvent, false, false);
                } else {
                    MediaSessionLegacyStub mediaSessionLegacyStub = mediaLibrarySessionImpl3.sessionLegacyStub;
                    MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo = mediaSession$ControllerInfo4.remoteUserInfo;
                    mediaSessionManager$RemoteUserInfo.getClass();
                    mediaSessionLegacyStub.getClass();
                    mediaSessionLegacyStub.dispatchSessionTaskWithPlayerCommand(1, new MediaSessionLegacyStub$$ExternalSyntheticLambda1(mediaSessionLegacyStub, b2), mediaSessionManager$RemoteUserInfo, true);
                }
                mediaSessionImpl$MediaPlayPauseKeyHandler.playPauseTask = null;
                return;
            case 19:
                MediaLibrarySessionImpl mediaLibrarySessionImpl4 = (MediaLibrarySessionImpl) this.f$0;
                MediaSession$MediaItemsWithStartPosition mediaSession$MediaItemsWithStartPosition = (MediaSession$MediaItemsWithStartPosition) this.f$2;
                if (mediaLibrarySessionImpl4.isReleased()) {
                    return;
                }
                MediaUtils.setMediaItemsWithStartIndexAndPosition(mediaLibrarySessionImpl4.playerWrapper, mediaSession$MediaItemsWithStartPosition);
                return;
            default:
                InternalDatabase internalDatabase = (InternalDatabase) this.f$0;
                RoomDatabase$$ExternalSyntheticLambda0 roomDatabase$$ExternalSyntheticLambda0 = new RoomDatabase$$ExternalSyntheticLambda0(b, new MusicDatabase$$ExternalSyntheticLambda0((Function1) this.f$1, (MusicDatabase) this.f$2, (byte) 1));
                if (!internalDatabase.inCompatibilityMode()) {
                    DatabaseDao_Impl.AnonymousClass17.performBlocking(internalDatabase, false, true, new DiskLruCache$$ExternalSyntheticLambda0((byte) 15, roomDatabase$$ExternalSyntheticLambda0));
                    return;
                }
                internalDatabase.beginTransaction();
                try {
                    roomDatabase$$ExternalSyntheticLambda0.invoke();
                    internalDatabase.getOpenHelper().getWritableDatabase().setTransactionSuccessful();
                    return;
                } finally {
                    internalDatabase.internalEndTransaction();
                }
        }
    }

    public /* synthetic */ Util$$ExternalSyntheticLambda1(byte b, Object obj, Object obj2, Object obj3, boolean z) {
        this.$r8$classId = b;
        this.f$1 = obj;
        this.f$0 = obj2;
        this.f$2 = obj3;
    }

    public /* synthetic */ Util$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }
}
