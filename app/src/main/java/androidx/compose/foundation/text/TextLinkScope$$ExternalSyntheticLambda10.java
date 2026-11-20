package androidx.compose.foundation.text;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.compose.animation.core.FloatTweenSpec;
import androidx.compose.foundation.lazy.layout.Averages;
import androidx.compose.foundation.lazy.layout.PrefetchHandleProvider$HandleAndRequestImpl;
import androidx.compose.runtime.ShouldPauseCallback;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda5;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.jpeg.JpegExtractor;
import androidx.media3.extractor.text.SubtitleExtractor;
import androidx.media3.session.CommandButton;
import androidx.media3.session.IMediaSession;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda3;
import androidx.media3.session.MediaControllerStub;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaLibrarySessionImpl;
import androidx.media3.session.MediaNotification$Provider;
import androidx.media3.session.MediaSession$ControllerInfo;
import androidx.media3.session.MediaSessionLegacyStub;
import androidx.media3.session.MediaSessionStub;
import androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda8;
import androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda81;
import androidx.media3.session.PlayerInfo;
import androidx.media3.session.PlayerWrapper;
import androidx.media3.session.SessionCommand;
import androidx.media3.session.SessionCommands;
import androidx.media3.session.SessionResult;
import androidx.media3.session.legacy.MediaDescriptionCompat;
import androidx.navigation.NavHostController;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.materialkolor.quantize.QuantizerWu;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.MusicService$performCrossfadeSwap$6;
import com.metrolist.music.playback.MusicService$secondaryPlayerListener$1;
import com.metrolist.music.playback.SleepTimer;
import com.metrolist.music.ui.component.ArtistLink;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.ConnectionPool;
import okhttp3.internal.http.StatusLine;
import okio.PriorityQueue;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextLinkScope$$ExternalSyntheticLambda10 implements ShouldPauseCallback, ListenerSet.IterationFinishedEvent, ListenerSet.Event, MediaCodecUtil.ScoreProvider, ExtractorsFactory, Consumer, MediaControllerImplBase.RemoteSessionTask, MediaControllerStub.ControllerTask, MediaSessionLegacyStub.SessionTask, MediaSessionStub.SessionTask, PlayerMessage.Target, MediaNotification$Provider.Callback {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ TextLinkScope$$ExternalSyntheticLambda10(boolean z, SessionCommand sessionCommand, Bundle bundle) {
        this.$r8$classId = (byte) 19;
        this.f$0 = sessionCommand;
        this.f$1 = bundle;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        byte b = this.$r8$classId;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        switch (b) {
            case 7:
                StatusLine statusLine = (StatusLine) obj3;
                ((MediaSourceEventListener) obj).onDownstreamFormatChanged(statusLine.code, (MediaSource$MediaPeriodId) statusLine.protocol, (FloatTweenSpec) obj2);
                break;
            case 18:
                MediaSessionStub mediaSessionStub = (MediaSessionStub) obj3;
                TrackSelectionParameters trackSelectionParametersBuild = (TrackSelectionParameters) obj2;
                PlayerWrapper playerWrapper = (PlayerWrapper) obj;
                ImmutableMap immutableMap = trackSelectionParametersBuild.overrides;
                if (!immutableMap.isEmpty()) {
                    TrackSelectionParameters.Builder builderClearOverrides = trackSelectionParametersBuild.buildUpon().clearOverrides();
                    UnmodifiableIterator it = immutableMap.values().iterator();
                    while (it.hasNext()) {
                        TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) it.next();
                        TrackGroup trackGroup = (TrackGroup) mediaSessionStub.trackGroupIdMap.inverse.get(trackSelectionOverride.mediaTrackGroup.id);
                        if (trackGroup == null || trackSelectionOverride.mediaTrackGroup.length != trackGroup.length) {
                            builderClearOverrides.addOverride(trackSelectionOverride);
                        } else {
                            builderClearOverrides.addOverride(new TrackSelectionOverride(trackGroup, trackSelectionOverride.trackIndices));
                        }
                    }
                    trackSelectionParametersBuild = builderClearOverrides.build();
                }
                playerWrapper.setTrackSelectionParameters(trackSelectionParametersBuild);
                break;
            case 20:
                MediaSession$ControllerInfo mediaSession$ControllerInfo = (MediaSession$ControllerInfo) obj2;
                MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) ((MediaSessionStub) obj3).sessionImpl.get();
                if (mediaLibrarySessionImpl != null && !mediaLibrarySessionImpl.isReleased()) {
                    mediaLibrarySessionImpl.handleMediaControllerPlayRequest(mediaSession$ControllerInfo, false);
                    break;
                }
                break;
            default:
                MediaSessionStub mediaSessionStub2 = (MediaSessionStub) obj3;
                Surface surface = (Surface) obj2;
                PlayerWrapper playerWrapper2 = (PlayerWrapper) obj;
                ((MediaLibrarySessionImpl) mediaSessionStub2.sessionImpl.get()).getClass();
                if (surface != null) {
                    MediaSessionStub.SurfaceHolderWithSize surfaceHolderWithSize = new MediaSessionStub.SurfaceHolderWithSize(surface);
                    mediaSessionStub2.surfaceHolderWithSize = surfaceHolderWithSize;
                    playerWrapper2.setVideoSurfaceHolder(surfaceHolderWithSize);
                } else {
                    playerWrapper2.setVideoSurfaceHolder(null);
                    mediaSessionStub2.surfaceHolderWithSize = null;
                }
                break;
        }
    }

    @Override // androidx.media3.extractor.ExtractorsFactory
    public Extractor[] createExtractors() {
        DefaultMediaSourceFactory defaultMediaSourceFactory = (DefaultMediaSourceFactory) this.f$0;
        Format format = (Format) this.f$1;
        return new Extractor[]{defaultMediaSourceFactory.subtitleParserFactory.supportsFormat(format) ? new SubtitleExtractor(defaultMediaSourceFactory.subtitleParserFactory.create(format)) : new JpegExtractor(format)};
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.ScoreProvider
    public int getScore(Object obj) {
        Context context = (Context) this.f$0;
        Format format = (Format) this.f$1;
        MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) obj;
        String str = mediaCodecInfo.mimeType;
        return ((str.equals(format.sampleMimeType) || str.equals(MediaCodecUtil.getAlternativeCodecMimeType(format))) && mediaCodecInfo.isCodecProfileAndLevelSupported(context, format, false) && mediaCodecInfo.isCompressedAudioBitDepthSupported(format)) ? 1 : 0;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.media3.exoplayer.PlayerMessage.Target
    public void handleMessage(int i, Object obj) throws Throwable {
        int currentMediaItemIndex;
        ExoPlayerImpl exoPlayerImpl;
        final MusicService musicService = (MusicService) this.f$0;
        String str = (String) this.f$1;
        SleepTimer sleepTimer = musicService.sleepTimer;
        if (musicService.player.isPlaying()) {
            MediaItem currentMediaItem = musicService.player.getCurrentMediaItem();
            if (Intrinsics.areEqual(currentMediaItem != null ? currentMediaItem.mediaId : null, str)) {
                if (sleepTimer == null || !sleepTimer.getPauseWhenSongEnd()) {
                    MusicService$secondaryPlayerListener$1 musicService$secondaryPlayerListener$1 = musicService.secondaryPlayerListener;
                    if (musicService.isCrossfading) {
                        return;
                    }
                    ExoPlayerImpl exoPlayerImpl2 = musicService.player;
                    exoPlayerImpl2.verifyApplicationThread();
                    int i2 = exoPlayerImpl2.repeatMode;
                    ExoPlayerImpl exoPlayerImpl3 = musicService.player;
                    exoPlayerImpl3.verifyApplicationThread();
                    boolean z = exoPlayerImpl3.shuffleModeEnabled;
                    ExoPlayerImpl exoPlayerImpl4 = musicService.player;
                    int currentMediaItemIndex2 = i2 == 1 ? exoPlayerImpl4.getCurrentMediaItemIndex() : exoPlayerImpl4.getNextMediaItemIndex();
                    if (currentMediaItemIndex2 == -1) {
                        return;
                    }
                    ExoPlayerImpl exoPlayerImplCreateExoPlayer = musicService.createExoPlayer(null);
                    musicService.secondaryPlayer = exoPlayerImplCreateExoPlayer;
                    exoPlayerImplCreateExoPlayer.addListener(musicService$secondaryPlayerListener$1);
                    int mediaItemCount = musicService.player.getMediaItemCount();
                    ArrayList arrayList = new ArrayList();
                    int iIntValue = 0;
                    for (int i3 = 0; i3 < mediaItemCount; i3++) {
                        MediaItem mediaItemAt = musicService.player.getMediaItemAt(i3);
                        mediaItemAt.getClass();
                        arrayList.add(mediaItemAt);
                    }
                    exoPlayerImplCreateExoPlayer.setMediaItems(arrayList);
                    exoPlayerImplCreateExoPlayer.seekTo(currentMediaItemIndex2, 0L, false);
                    exoPlayerImplCreateExoPlayer.setVolume(CropImageView.DEFAULT_ASPECT_RATIO);
                    exoPlayerImplCreateExoPlayer.setPlaybackParameters(musicService.player.getPlaybackParameters());
                    exoPlayerImplCreateExoPlayer.setRepeatMode(i2);
                    exoPlayerImplCreateExoPlayer.setShuffleModeEnabled(z);
                    ExoPlayerImpl exoPlayerImpl5 = musicService.player;
                    exoPlayerImpl5.verifyApplicationThread();
                    exoPlayerImplCreateExoPlayer.setShuffleOrder(exoPlayerImpl5.shuffleOrder);
                    exoPlayerImplCreateExoPlayer.setPlaybackParameters(musicService.player.getPlaybackParameters());
                    try {
                        exoPlayerImplCreateExoPlayer.prepare();
                        exoPlayerImplCreateExoPlayer.setPlayWhenReady(true);
                        musicService.isCrossfading = true;
                        ExoPlayerImpl exoPlayerImpl6 = musicService.secondaryPlayer;
                        if (exoPlayerImpl6 == null) {
                            return;
                        }
                        ListenerSet listenerSet = exoPlayerImpl6.listeners;
                        musicService.fadingPlayer = musicService.player;
                        musicService.player = exoPlayerImpl6;
                        StateFlowImpl stateFlowImpl = musicService._playerFlow;
                        stateFlowImpl.getClass();
                        stateFlowImpl.updateState(null, exoPlayerImpl6);
                        musicService.secondaryPlayer = null;
                        ExoPlayerImpl exoPlayerImpl7 = musicService.fadingPlayer;
                        if (exoPlayerImpl7 != null) {
                            exoPlayerImpl7.removeListener(musicService);
                        }
                        SleepTimer sleepTimer2 = musicService.sleepTimer;
                        if (sleepTimer2 != null && (exoPlayerImpl = musicService.fadingPlayer) != null) {
                            exoPlayerImpl.removeListener(sleepTimer2);
                        }
                        ExoPlayerImpl exoPlayerImpl8 = musicService.fadingPlayer;
                        if (exoPlayerImpl8 != null) {
                            exoPlayerImpl8.setRepeatMode(0);
                        }
                        ExoPlayerImpl exoPlayerImpl9 = musicService.fadingPlayer;
                        if (exoPlayerImpl9 != null && (currentMediaItemIndex = exoPlayerImpl9.getCurrentMediaItemIndex()) < exoPlayerImpl9.getMediaItemCount() - 1) {
                            exoPlayerImpl9.removeMediaItems(currentMediaItemIndex + 1, exoPlayerImpl9.getMediaItemCount());
                        }
                        musicService.player.listeners.add(new Player.Listener() { // from class: com.metrolist.music.playback.MusicService$performCrossfadeSwap$3
                            @Override // androidx.media3.common.Player.Listener
                            public final void onIsPlayingChanged(boolean z2) {
                                ExoPlayerImpl exoPlayerImpl10;
                                MusicService musicService2 = musicService;
                                if (!musicService2.isCrossfading || (exoPlayerImpl10 = musicService2.fadingPlayer) == null) {
                                    musicService2.player.removeListener(this);
                                } else if (z2) {
                                    exoPlayerImpl10.setPlayWhenReady(true);
                                } else {
                                    exoPlayerImpl10.setPlayWhenReady(false);
                                }
                            }
                        });
                        exoPlayerImpl6.removeListener(musicService$secondaryPlayerListener$1);
                        listenerSet.add(musicService);
                        SleepTimer sleepTimer3 = musicService.sleepTimer;
                        if (sleepTimer3 != null) {
                            listenerSet.add(sleepTimer3);
                        }
                        SleepTimer sleepTimer4 = musicService.sleepTimer;
                        if (sleepTimer4 != null) {
                            ExoPlayerImpl exoPlayerImpl10 = musicService.player;
                            exoPlayerImpl10.getClass();
                            sleepTimer4.player = exoPlayerImpl10;
                        }
                        try {
                            MediaLibraryService.MediaLibrarySession mediaLibrarySession = musicService.mediaSession;
                            if (mediaLibrarySession != null) {
                                mediaLibrarySession.setPlayer(musicService.player);
                            }
                        } catch (Exception unused) {
                            Timber.Forest.getClass();
                            ConnectionPool.e$1(new Object[0]);
                        }
                        musicService.onMediaItemTransition(1, musicService.player.getCurrentMediaItem());
                        ExoPlayerImpl exoPlayerImpl11 = musicService.fadingPlayer;
                        if (exoPlayerImpl11 != null) {
                            exoPlayerImpl11.verifyApplicationThread();
                            iIntValue = ((Integer) exoPlayerImpl11.audioSessionIdState.get()).intValue();
                        }
                        musicService.openAudioEffectSession();
                        musicService.crossfadeJob = AwaitKt.launch$default(musicService.scope, null, null, new MusicService$performCrossfadeSwap$6(musicService, iIntValue, null), 3);
                    } catch (Exception unused2) {
                        Timber.Forest.tag("MusicService");
                        ConnectionPool.e$1(new Object[0]);
                        exoPlayerImplCreateExoPlayer.removeListener(musicService$secondaryPlayerListener$1);
                        musicService.releaseExoPlayer(exoPlayerImplCreateExoPlayer);
                        musicService.secondaryPlayer = null;
                    }
                }
            }
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        byte b = this.$r8$classId;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        switch (b) {
            case 3:
                ((AnalyticsListener) obj).onDownstreamFormatChanged((AnalyticsListener.EventTime) obj3, (FloatTweenSpec) obj2);
                break;
            case 4:
                ((AnalyticsListener) obj).onLoadError((FloatTweenSpec) obj3, (IOException) obj2);
                break;
            case 11:
                ((Player.Listener) obj).onMediaItemTransition(((Integer) obj2).intValue(), (MediaItem) obj3);
                break;
            default:
                ((Player.Listener) obj).onMediaItemTransition(((Integer) obj2).intValue(), ((PlayerInfo) ((QuantizerWu) obj3).weights).getCurrentMediaItem());
                break;
        }
    }

    public void onClick(LinkAnnotation linkAnnotation) {
        NavHostController navHostController = (NavHostController) this.f$0;
        ArtistLink artistLink = (ArtistLink) this.f$1;
        linkAnnotation.getClass();
        Format$$ExternalSyntheticOutline0.m("artist/", artistLink.id, navHostController);
    }

    @Override // androidx.media3.session.MediaNotification$Provider.Callback
    public void onNotificationChanged(PriorityQueue priorityQueue) {
        MusicService musicService = (MusicService) this.f$0;
        ExoPlayerImpl$$ExternalSyntheticLambda5 exoPlayerImpl$$ExternalSyntheticLambda5 = (ExoPlayerImpl$$ExternalSyntheticLambda5) this.f$1;
        if (musicService.taskCleared) {
            return;
        }
        musicService.latestMediaNotification = (Notification) priorityQueue.array;
        exoPlayerImpl$$ExternalSyntheticLambda5.onNotificationChanged(priorityQueue);
    }

    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
    public void run(MediaControllerImplBase mediaControllerImplBase) {
        boolean z;
        boolean z2;
        boolean z3;
        byte b = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (b) {
            case 14:
                mediaControllerImplBase.onPlayerInfoChanged((PlayerInfo) obj2, (PlayerInfo.BundlingExclusions) obj);
                break;
            default:
                SessionCommands sessionCommands = (SessionCommands) obj2;
                Player.Commands commands = (Player.Commands) obj;
                MediaController mediaController = mediaControllerImplBase.instance;
                if (mediaControllerImplBase.isConnected()) {
                    boolean zEquals = Objects.equals(mediaControllerImplBase.playerCommandsFromSession, commands);
                    boolean zEquals2 = Objects.equals(mediaControllerImplBase.sessionCommands, sessionCommands);
                    if (!zEquals || !zEquals2) {
                        mediaControllerImplBase.sessionCommands = sessionCommands;
                        char c = 1;
                        if (zEquals) {
                            z = false;
                        } else {
                            mediaControllerImplBase.playerCommandsFromSession = commands;
                            Player.Commands commands2 = mediaControllerImplBase.intersectedPlayerCommands;
                            Player.Commands commandsCreateIntersectedCommandsWithControllerOverrides = mediaControllerImplBase.createIntersectedCommandsWithControllerOverrides(commands, mediaControllerImplBase.playerCommandsFromPlayer);
                            mediaControllerImplBase.intersectedPlayerCommands = commandsCreateIntersectedCommandsWithControllerOverrides;
                            z = !commandsCreateIntersectedCommandsWithControllerOverrides.equals(commands2);
                        }
                        if (!zEquals2 || z) {
                            RegularImmutableList regularImmutableList = mediaControllerImplBase.resolvedMediaButtonPreferences;
                            RegularImmutableList regularImmutableList2 = mediaControllerImplBase.resolvedCustomLayout;
                            RegularImmutableList regularImmutableListResolveMediaButtonPreferences = MediaControllerImplBase.resolveMediaButtonPreferences(mediaControllerImplBase.mediaButtonPreferencesOriginal, mediaControllerImplBase.customLayoutOriginal, sessionCommands, mediaControllerImplBase.intersectedPlayerCommands, mediaControllerImplBase.sessionExtras);
                            mediaControllerImplBase.resolvedMediaButtonPreferences = regularImmutableListResolveMediaButtonPreferences;
                            mediaControllerImplBase.resolvedCustomLayout = MediaControllerImplBase.resolveCustomLayout(regularImmutableListResolveMediaButtonPreferences, mediaControllerImplBase.customLayoutOriginal, mediaControllerImplBase.sessionExtras, sessionCommands, mediaControllerImplBase.intersectedPlayerCommands, mediaControllerImplBase.getSessionInterfaceVersion());
                            z2 = !mediaControllerImplBase.resolvedMediaButtonPreferences.equals(regularImmutableList);
                            z3 = !mediaControllerImplBase.resolvedCustomLayout.equals(regularImmutableList2);
                        } else {
                            z2 = false;
                            z3 = false;
                        }
                        if (z) {
                            mediaControllerImplBase.listeners.sendEvent(13, new MediaControllerImplBase$$ExternalSyntheticLambda3(mediaControllerImplBase, c == true ? 1 : 0));
                        }
                        if (!zEquals2) {
                            mediaController.getClass();
                            UtilsKt.checkState(Looper.myLooper() == mediaController.applicationHandler.getLooper());
                            mediaController.listener.onAvailableSessionCommandsChanged();
                        }
                        if (z3) {
                            mediaController.getClass();
                            UtilsKt.checkState(Looper.myLooper() == mediaController.applicationHandler.getLooper());
                            mediaController.listener.getClass();
                        }
                        if (z2) {
                            mediaController.getClass();
                            UtilsKt.checkState(Looper.myLooper() == mediaController.applicationHandler.getLooper());
                            mediaController.listener.onMediaButtonPreferencesChanged();
                        }
                    }
                    break;
                }
                break;
        }
    }

    @Override // androidx.compose.runtime.ShouldPauseCallback
    public boolean shouldPause() {
        PrefetchHandleProvider$HandleAndRequestImpl prefetchHandleProvider$HandleAndRequestImpl = (PrefetchHandleProvider$HandleAndRequestImpl) this.f$0;
        Averages averages = (Averages) this.f$1;
        boolean z = prefetchHandleProvider$HandleAndRequestImpl.pauseRequested;
        if (z) {
            return z;
        }
        prefetchHandleProvider$HandleAndRequestImpl.updateElapsedAndAvailableTime();
        long jCalculateAverageTime = Averages.calculateAverageTime(prefetchHandleProvider$HandleAndRequestImpl.elapsedTimeNanos, averages.resumeTimeNanos);
        averages.resumeTimeNanos = jCalculateAverageTime;
        boolean z2 = !prefetchHandleProvider$HandleAndRequestImpl.shouldExecute(prefetchHandleProvider$HandleAndRequestImpl.availableTimeNanos, jCalculateAverageTime + averages.pauseTimeNanos);
        prefetchHandleProvider$HandleAndRequestImpl.pauseRequested = z2;
        return z2;
    }

    public /* synthetic */ TextLinkScope$$ExternalSyntheticLambda10(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    public /* synthetic */ TextLinkScope$$ExternalSyntheticLambda10(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec, IOException iOException, boolean z) {
        this.$r8$classId = (byte) 4;
        this.f$0 = floatTweenSpec;
        this.f$1 = iOException;
    }

    @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
    public void invoke(Object obj, FlagSet flagSet) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        analyticsListener.onEvents((Player) this.f$1, new CallbackWrapper(flagSet, ((DefaultAnalyticsCollector) this.f$0).eventTimes));
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object run(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        byte b = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (b) {
            case 19:
                return mediaLibrarySessionImpl.onCustomCommandOnHandler(mediaSession$ControllerInfo, (SessionCommand) obj2, (Bundle) obj);
            case 22:
                MediaSessionStub.SessionTask sessionTask = (MediaSessionStub.SessionTask) obj2;
                MediaSessionStub$$ExternalSyntheticLambda8 mediaSessionStub$$ExternalSyntheticLambda8 = (MediaSessionStub$$ExternalSyntheticLambda8) obj;
                if (mediaLibrarySessionImpl.isReleased()) {
                    return new ImmediateFuture(new SessionResult(-100));
                }
                return Util.transformFutureAsync((ListenableFuture) sessionTask.run(mediaLibrarySessionImpl, mediaSession$ControllerInfo, i), new MediaSessionStub$$ExternalSyntheticLambda81(mediaLibrarySessionImpl, mediaSession$ControllerInfo, mediaSessionStub$$ExternalSyntheticLambda8, (byte) 0));
            default:
                MediaSessionStub.SessionTask sessionTask2 = (MediaSessionStub.SessionTask) obj2;
                MediaSessionStub.MediaItemPlayerTask mediaItemPlayerTask = (MediaSessionStub.MediaItemPlayerTask) obj;
                if (mediaLibrarySessionImpl.isReleased()) {
                    return new ImmediateFuture(new SessionResult(-100));
                }
                return Util.transformFutureAsync((ListenableFuture) sessionTask2.run(mediaLibrarySessionImpl, mediaSession$ControllerInfo, i), new MediaSessionStub$$ExternalSyntheticLambda81(mediaLibrarySessionImpl, mediaSession$ControllerInfo, mediaItemPlayerTask, (byte) 4));
        }
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void run(IMediaSession iMediaSession, int i) {
        byte b = this.$r8$classId;
        Object obj = this.f$1;
        MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) this.f$0;
        switch (b) {
            case 8:
                iMediaSession.setVideoSurface(mediaControllerImplBase.controllerStub, i, (Surface) obj);
                break;
            case 9:
                iMediaSession.setPlaylistMetadata(mediaControllerImplBase.controllerStub, i, ((MediaMetadata) obj).toBundle(mediaControllerImplBase.getSessionInterfaceVersion()));
                break;
            case 10:
                PlaybackParameters playbackParameters = (PlaybackParameters) obj;
                MediaControllerStub mediaControllerStub = mediaControllerImplBase.controllerStub;
                playbackParameters.getClass();
                Bundle bundle = new Bundle();
                bundle.putFloat(PlaybackParameters.FIELD_SPEED, playbackParameters.speed);
                bundle.putFloat(PlaybackParameters.FIELD_PITCH, playbackParameters.pitch);
                iMediaSession.setPlaybackParameters(mediaControllerStub, i, bundle);
                break;
            default:
                iMediaSession.setTrackSelectionParameters(mediaControllerImplBase.controllerStub, i, ((TrackSelectionParameters) obj).toBundle());
                break;
        }
    }

    @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
    public void run(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        byte b = this.$r8$classId;
        Object obj = this.f$1;
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.f$0;
        switch (b) {
            case 16:
                ((CommandButton) obj).executePlayerAction(mediaSessionLegacyStub.sessionImpl.playerWrapper);
                break;
            default:
                String str = ((MediaDescriptionCompat) obj).mediaId;
                if (TextUtils.isEmpty(str)) {
                    Log.w("MediaSessionLegacyStub", "onRemoveQueueItem(): Media ID shouldn't be null");
                } else {
                    PlayerWrapper playerWrapper = mediaSessionLegacyStub.sessionImpl.playerWrapper;
                    if (!playerWrapper.isCommandAvailable(17)) {
                        Log.w("MediaSessionLegacyStub", "Can't remove item by ID without COMMAND_GET_TIMELINE being available");
                    } else {
                        Timeline currentTimeline = playerWrapper.getCurrentTimeline();
                        Timeline.Window window = new Timeline.Window();
                        for (int i = 0; i < currentTimeline.getWindowCount(); i++) {
                            if (TextUtils.equals(currentTimeline.getWindow(i, window, 0L).mediaItem.mediaId, str)) {
                                playerWrapper.removeMediaItem(i);
                            }
                        }
                    }
                }
                break;
        }
    }
}
