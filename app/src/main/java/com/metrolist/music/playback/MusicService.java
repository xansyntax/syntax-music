package com.metrolist.music.playback;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.renderscript.Allocation;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ScrollNode$$ExternalSyntheticLambda2;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2$$ExternalSyntheticLambda0;
import androidx.compose.foundation.pager.PagerState$scrollToPage$2;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda14;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.platform.DelegatingSoftwareKeyboardController;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.text.input.GapBuffer;
import androidx.compose.ui.unit.Dp;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.provider.CallbackWrapper;
import androidx.core.view.DisplayCompat;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreImpl$data$1$5;
import androidx.datastore.core.DataStoreImpl$writeData$2;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.emoji2.text.EmojiProcessor;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.audio.BaseAudioProcessor;
import androidx.media3.common.audio.SonicAudioProcessor;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceBitmapLoader;
import androidx.media3.datasource.HttpDataSource$InvalidResponseCodeException;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.datasource.cache.ContentMetadata;
import androidx.media3.datasource.cache.SimpleCache;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.ExoPlayer$Builder;
import androidx.media3.exoplayer.ExoPlayer$Builder$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.analytics.PlaybackStatsListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.audio.MediaCodecAudioRenderer;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.ShuffleOrder$DefaultShuffleOrder;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.session.CommandButton;
import androidx.media3.session.DefaultMediaNotificationProvider;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaControllerHolder;
import androidx.media3.session.MediaControllerHolder$$ExternalSyntheticLambda0;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaLibrarySessionImpl;
import androidx.media3.session.MediaSession$ControllerInfo;
import androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda1;
import androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda81;
import androidx.media3.session.SessionToken;
import androidx.navigation.internal.NavContext;
import androidx.room.RoomDatabase$closeBarrier$1;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import androidx.room.concurrent.FileLock;
import coil3.ImageLoader$Builder;
import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.dokar.quickjs.QuickJs$$ExternalSyntheticLambda1;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.math.IntMath;
import com.google.common.primitives.ImmutableIntArray;
import com.google.common.util.concurrent.DirectExecutor;
import com.metrolist.innertube.InnerTube;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.models.response.PlayerResponse$VideoDetails;
import com.metrolist.innertube.pages.ArtistPage;
import com.metrolist.innertube.pages.NextResult;
import com.metrolist.innertube.pages.RelatedPage;
import com.metrolist.music.App;
import com.metrolist.music.App$Companion$forgetAccount$2;
import com.metrolist.music.MainActivity;
import com.metrolist.music.MainActivity$MetrolistApp$4$1;
import com.metrolist.music.constants.AudioQuality;
import com.metrolist.music.constants.LoudnessLevel;
import com.metrolist.music.constants.MediaSessionConstants;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda7;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.FormatEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.SetVideoIdEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.discord.DiscordActivity;
import com.metrolist.music.discord.DiscordRpcManager;
import com.metrolist.music.discord.PresenceStatus;
import com.metrolist.music.eq.EqualizerService;
import com.metrolist.music.eq.audio.CustomEqualizerAudioProcessor;
import com.metrolist.music.eq.data.EQProfileRepository;
import com.metrolist.music.eq.data.SavedEQProfile;
import com.metrolist.music.extensions.CoroutineExtKt;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.lyrics.LyricsWithProvider;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.models.PersistPlayerState;
import com.metrolist.music.models.PersistQueue;
import com.metrolist.music.playback.audio.SilenceDetectorAudioProcessor;
import com.metrolist.music.playback.audio.VolumeNormalizationAudioProcessor;
import com.metrolist.music.playback.queues.EmptyQueue;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.playback.queues.Queue;
import com.metrolist.music.playback.queues.QueueKt;
import com.metrolist.music.playback.queues.YouTubePlaylistQueue;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.LensController;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda13;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda75;
import com.metrolist.music.ui.utils.YouTubeUtilsKt;
import com.metrolist.music.utils.DataStoreKt$get$2;
import com.metrolist.music.utils.InnerTubeXPlayer;
import com.metrolist.music.utils.NetworkConnectivityObserver;
import com.metrolist.music.utils.ScrobbleManager;
import com.metrolist.music.utils.ScrobbleManager$scrobbleSong$1;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$createPlaylist$1;
import com.metrolist.music.utils.SyncUtils$executeLikeSong$2$1;
import com.metrolist.music.utils.SyncUtils$executeSaveEpisode$2$3;
import com.metrolist.music.utils.SyncUtils$special$$inlined$map$1;
import com.metrolist.music.utils.Updater$checkForUpdate$2;
import com.metrolist.music.utils.Updater$getLatestRelease$2;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.viewmodels.HomeViewModel;
import com.metrolist.music.viewmodels.LocalFilter;
import com.metrolist.music.viewmodels.LocalPlaylistViewModel$2$page$1;
import com.metrolist.music.widget.MetrolistWidgetManager;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import dagger.hilt.EntryPoints;
import dev.chrisbanes.haze.RenderScriptContext;
import io.ktor.http.ContentType;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.UIntArray;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.collections.ReversedListReadOnly;
import kotlin.comparisons.NaturalOrderComparator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntriesList;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.random.AbstractPlatformRandom;
import kotlin.random.Random;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.serialization.json.internal.JsonTreeReader;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.ws.RealWebSocket$$ExternalSyntheticLambda2;
import okio.FileMetadata;
import okio.PriorityQueue;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicService extends Hilt_MusicService implements Player.Listener {
    public static volatile boolean isRunning;
    public static volatile CompletableDeferredImpl shutdownDeferred;
    public final byte MAX_RETRY_PER_SONG;
    public final short RETRY_DELAY_MS;
    public final StateFlowImpl _playerFlow;
    public final MusicService$audioDeviceCallback$1 audioDeviceCallback;
    public AudioFocusRequest audioFocusRequest;
    public final StateFlowImpl audioFocusVolumeMultiplier;
    public AudioManager audioManager;
    public AudioQuality audioQuality;
    public final StateFlowImpl automixItems;
    public final MusicBinder binder;
    public final LinkedHashSet bypassCacheForQualityChange;
    public volatile boolean cachedAutoLoadMore;
    public volatile boolean cachedAutoplay;
    public volatile boolean cachedDisableLoadMoreWhenRepeatAll;
    public volatile boolean cachedHideExplicit;
    public volatile boolean cachedHideVideoSongs;
    public boolean cachedNormalizationEnabled;
    public Integer cachedNormalizationGainMb;
    public String cachedNormalizationMediaId;
    public volatile boolean cachedPersistentQueue;
    public volatile boolean cachedShufflePlaylistFirst;
    public CastConnectionHandler castConnectionHandler;
    public ConnectivityManager connectivityManager;
    public NetworkConnectivityObserver connectivityObserver;
    public int consecutivePlaybackErr;
    public MediaControllerHolder controllerFuture;
    public boolean crossfadeEnabled;
    public StandaloneCoroutine crossfadeJob;
    public PlayerMessage crossfadeMessage;
    public final ChannelFlowTransformLatest currentFormat;
    public final LinkedHashMap currentMediaIdRetryCount;
    public final StateFlowImpl currentMediaMetadata;
    public Queue currentQueue;
    public final ReadonlyStateFlow currentSong;
    public final StateFlowImpl currentStreamClient;
    public MusicDatabase database;
    public volatile boolean discordIntentionalDisconnect;
    public volatile boolean discordRpcEnabled;
    public SimpleCache downloadCache;
    public DownloadUtil downloadUtil;
    public EQProfileRepository eqProfileRepository;
    public EqualizerService equalizerService;
    public ExoPlayerImpl fadingPlayer;
    public StandaloneCoroutine failedSongsClearJob;
    public boolean hasAudioFocus;
    public String initialBufferRecoveryAttemptedMediaId;
    public StandaloneCoroutine initialBufferRecoveryJob;
    public final StateFlowImpl instantSilenceSkipEnabled;
    public boolean isAudioEffectSessionOpened;
    public boolean isCrossfading;
    public final StateFlowImpl isMuted;
    public final StateFlowImpl isNetworkConnected;
    public boolean isPausedByVolumeMute;
    public final ReadonlyStateFlow isPlayerReady;
    public volatile boolean isScreenOff;
    public boolean isSilenceSkipping;
    public volatile long lastDiscordReconnectAttemptAtMs;
    public float lastPlaybackSpeed;
    public PersistPlayerState lastSavedPlayerState;
    public String lastTransitionedMediaId;
    public volatile Notification latestMediaNotification;
    public ListenTogetherManager listenTogetherManager;
    public volatile LoudnessLevel loudnessLevelCached;
    public long loudnessSetupGeneration;
    public StandaloneCoroutine loudnessSetupJob;
    public ImageLoader$Builder lyricsHelper;
    public MediaLibrarySessionCallback mediaLibrarySessionCallback;
    public MediaLibraryService.MediaLibrarySession mediaSession;
    public volatile boolean normalizationEnabledCached;
    public int openedAudioEffectSessionId;
    public int originalQueueSize;
    public final MusicService$$ExternalSyntheticLambda0 pauseTimeout;
    public boolean pausedDueToNetworkError;
    public Pair pendingWidgetUpdate;
    public final Map playbackUrlCache;
    public ExoPlayerImpl player;
    public SimpleCache playerCache;
    public final HashMap playerEqualizerProcessors;
    public final ReadonlyStateFlow playerFlow;
    public final StateFlowImpl playerInitialized;
    public final HashMap playerNormalizationProcessors;
    public final HashMap playerSilenceProcessors;
    public StateFlowImpl playerVolume;
    public String previousEpisodeId;
    public long previousEpisodePosition;
    public int previousMediaItemIndex;
    public String queueTitle;
    public final LinkedHashSet recentlyFailedSongs;
    public final Set recoveringSongs;
    public boolean reentrantFocusGain;
    public int retryCount;
    public StandaloneCoroutine retryJob;
    public final ContextScope scope;
    public final Handler screenOffHandler;
    public final MusicService$$ExternalSyntheticLambda0 screenOffTimeout;
    public final NetworkTypeObserver.Receiver screenStateReceiver;
    public ScrobbleManager scrobbleManager;
    public ExoPlayerImpl secondaryPlayer;
    public StandaloneCoroutine silenceSkipJob;
    public SleepTimer sleepTimer;
    public final StateFlowImpl sleepTimerVolumeMultiplier;
    public final StreamUrlCache songUrlCache;
    public volatile MutablePreferences startupPrefs;
    public SyncUtils syncUtils;
    public boolean taskCleared;
    public final StateFlowImpl waitingForNetworkConnection;
    public boolean wasPlayingBeforeAudioFocusLoss;
    public boolean wasPlayingBeforeVolumeMute;
    public MetrolistWidgetManager widgetManager;
    public boolean widgetUpdateInFlight;
    public StandaloneCoroutine widgetUpdateJob;
    public float crossfadeDuration = 5000.0f;
    public boolean crossfadeGapless = true;
    public final MusicService$secondaryPlayerListener$1 secondaryPlayerListener = new Player.Listener() { // from class: com.metrolist.music.playback.MusicService$secondaryPlayerListener$1
        @Override // androidx.media3.common.Player.Listener
        public final void onPlayerError(PlaybackException playbackException) {
            playbackException.getClass();
            Timber.Forest.tag("MusicService");
            ConnectionPool.e$1(new Object[0]);
            MusicService musicService = this.this$0;
            ExoPlayerImpl exoPlayerImpl = musicService.secondaryPlayer;
            if (exoPlayerImpl != null) {
                exoPlayerImpl.removeListener(this);
                exoPlayerImpl.stop();
                exoPlayerImpl.clearMediaItems();
                musicService.releaseExoPlayer(exoPlayerImpl);
            }
            musicService.secondaryPlayer = null;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MusicBinder extends Binder {
        public MusicBinder() {
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$buildPlaylistWidgetQueue$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public String L$2;
        public String L$3;
        public Object L$4;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            MusicService musicService = MusicService.this;
            boolean z = MusicService.isRunning;
            return musicService.buildPlaylistWidgetQueue(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$fetchArtistThumbnail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01661 extends ContinuationImpl {
        public Song L$0;
        public ArtistEntity L$1;
        public int label;
        public /* synthetic */ Object result;

        public C01661(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            MusicService musicService = MusicService.this;
            boolean z = MusicService.isRunning;
            return musicService.fetchArtistThumbnail(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$getAutomix$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01671 extends SuspendLambda implements Function2 {
        public final /* synthetic */ String $playlistId;
        public Object L$0;
        public MusicService L$1;
        public NextResult L$2;
        public MediaMetadata L$3;
        public Object L$4;
        public byte label;
        public final /* synthetic */ MusicService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01671(String str, MusicService musicService, Continuation continuation) {
            super(2, continuation);
            this.$playlistId = str;
            this.this$0 = musicService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C01671(this.$playlistId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C01671) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:102:0x0254 A[Catch: Exception -> 0x025c, TRY_LEAVE, TryCatch #0 {Exception -> 0x025c, blocks: (B:10:0x0028, B:90:0x0203, B:92:0x0207, B:94:0x0217, B:96:0x022a, B:97:0x022e, B:99:0x023e, B:100:0x024e, B:102:0x0254, B:15:0x0045, B:79:0x01df, B:82:0x01e4, B:84:0x01e8, B:86:0x01ec, B:18:0x005f, B:59:0x015f, B:61:0x0163, B:62:0x0171, B:64:0x0177, B:66:0x0188, B:67:0x018c, B:69:0x019c, B:70:0x01ac, B:72:0x01b2, B:73:0x01ba, B:75:0x01c0, B:21:0x0074, B:34:0x00c4, B:36:0x00c8, B:37:0x00dc, B:39:0x00e2, B:40:0x00f0, B:41:0x00f6, B:43:0x00fc, B:45:0x0104, B:46:0x0115, B:48:0x011b, B:49:0x0129, B:51:0x0130, B:53:0x0136, B:55:0x013e, B:22:0x007e, B:28:0x009e, B:30:0x00a2, B:25:0x008b), top: B:106:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:109:0x022a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:111:0x0215 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:114:0x0188 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:117:0x0171 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:36:0x00c8 A[Catch: Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:10:0x0028, B:90:0x0203, B:92:0x0207, B:94:0x0217, B:96:0x022a, B:97:0x022e, B:99:0x023e, B:100:0x024e, B:102:0x0254, B:15:0x0045, B:79:0x01df, B:82:0x01e4, B:84:0x01e8, B:86:0x01ec, B:18:0x005f, B:59:0x015f, B:61:0x0163, B:62:0x0171, B:64:0x0177, B:66:0x0188, B:67:0x018c, B:69:0x019c, B:70:0x01ac, B:72:0x01b2, B:73:0x01ba, B:75:0x01c0, B:21:0x0074, B:34:0x00c4, B:36:0x00c8, B:37:0x00dc, B:39:0x00e2, B:40:0x00f0, B:41:0x00f6, B:43:0x00fc, B:45:0x0104, B:46:0x0115, B:48:0x011b, B:49:0x0129, B:51:0x0130, B:53:0x0136, B:55:0x013e, B:22:0x007e, B:28:0x009e, B:30:0x00a2, B:25:0x008b), top: B:106:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:39:0x00e2 A[Catch: Exception -> 0x025c, LOOP:4: B:37:0x00dc->B:39:0x00e2, LOOP_END, TryCatch #0 {Exception -> 0x025c, blocks: (B:10:0x0028, B:90:0x0203, B:92:0x0207, B:94:0x0217, B:96:0x022a, B:97:0x022e, B:99:0x023e, B:100:0x024e, B:102:0x0254, B:15:0x0045, B:79:0x01df, B:82:0x01e4, B:84:0x01e8, B:86:0x01ec, B:18:0x005f, B:59:0x015f, B:61:0x0163, B:62:0x0171, B:64:0x0177, B:66:0x0188, B:67:0x018c, B:69:0x019c, B:70:0x01ac, B:72:0x01b2, B:73:0x01ba, B:75:0x01c0, B:21:0x0074, B:34:0x00c4, B:36:0x00c8, B:37:0x00dc, B:39:0x00e2, B:40:0x00f0, B:41:0x00f6, B:43:0x00fc, B:45:0x0104, B:46:0x0115, B:48:0x011b, B:49:0x0129, B:51:0x0130, B:53:0x0136, B:55:0x013e, B:22:0x007e, B:28:0x009e, B:30:0x00a2, B:25:0x008b), top: B:106:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:48:0x011b A[Catch: Exception -> 0x025c, LOOP:5: B:46:0x0115->B:48:0x011b, LOOP_END, TryCatch #0 {Exception -> 0x025c, blocks: (B:10:0x0028, B:90:0x0203, B:92:0x0207, B:94:0x0217, B:96:0x022a, B:97:0x022e, B:99:0x023e, B:100:0x024e, B:102:0x0254, B:15:0x0045, B:79:0x01df, B:82:0x01e4, B:84:0x01e8, B:86:0x01ec, B:18:0x005f, B:59:0x015f, B:61:0x0163, B:62:0x0171, B:64:0x0177, B:66:0x0188, B:67:0x018c, B:69:0x019c, B:70:0x01ac, B:72:0x01b2, B:73:0x01ba, B:75:0x01c0, B:21:0x0074, B:34:0x00c4, B:36:0x00c8, B:37:0x00dc, B:39:0x00e2, B:40:0x00f0, B:41:0x00f6, B:43:0x00fc, B:45:0x0104, B:46:0x0115, B:48:0x011b, B:49:0x0129, B:51:0x0130, B:53:0x0136, B:55:0x013e, B:22:0x007e, B:28:0x009e, B:30:0x00a2, B:25:0x008b), top: B:106:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:53:0x0136 A[Catch: Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:10:0x0028, B:90:0x0203, B:92:0x0207, B:94:0x0217, B:96:0x022a, B:97:0x022e, B:99:0x023e, B:100:0x024e, B:102:0x0254, B:15:0x0045, B:79:0x01df, B:82:0x01e4, B:84:0x01e8, B:86:0x01ec, B:18:0x005f, B:59:0x015f, B:61:0x0163, B:62:0x0171, B:64:0x0177, B:66:0x0188, B:67:0x018c, B:69:0x019c, B:70:0x01ac, B:72:0x01b2, B:73:0x01ba, B:75:0x01c0, B:21:0x0074, B:34:0x00c4, B:36:0x00c8, B:37:0x00dc, B:39:0x00e2, B:40:0x00f0, B:41:0x00f6, B:43:0x00fc, B:45:0x0104, B:46:0x0115, B:48:0x011b, B:49:0x0129, B:51:0x0130, B:53:0x0136, B:55:0x013e, B:22:0x007e, B:28:0x009e, B:30:0x00a2, B:25:0x008b), top: B:106:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:57:0x0157  */
        /* JADX WARN: Code duplicated, block: B:58:0x0159  */
        /* JADX WARN: Code duplicated, block: B:61:0x0163 A[Catch: Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:10:0x0028, B:90:0x0203, B:92:0x0207, B:94:0x0217, B:96:0x022a, B:97:0x022e, B:99:0x023e, B:100:0x024e, B:102:0x0254, B:15:0x0045, B:79:0x01df, B:82:0x01e4, B:84:0x01e8, B:86:0x01ec, B:18:0x005f, B:59:0x015f, B:61:0x0163, B:62:0x0171, B:64:0x0177, B:66:0x0188, B:67:0x018c, B:69:0x019c, B:70:0x01ac, B:72:0x01b2, B:73:0x01ba, B:75:0x01c0, B:21:0x0074, B:34:0x00c4, B:36:0x00c8, B:37:0x00dc, B:39:0x00e2, B:40:0x00f0, B:41:0x00f6, B:43:0x00fc, B:45:0x0104, B:46:0x0115, B:48:0x011b, B:49:0x0129, B:51:0x0130, B:53:0x0136, B:55:0x013e, B:22:0x007e, B:28:0x009e, B:30:0x00a2, B:25:0x008b), top: B:106:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:64:0x0177 A[Catch: Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:10:0x0028, B:90:0x0203, B:92:0x0207, B:94:0x0217, B:96:0x022a, B:97:0x022e, B:99:0x023e, B:100:0x024e, B:102:0x0254, B:15:0x0045, B:79:0x01df, B:82:0x01e4, B:84:0x01e8, B:86:0x01ec, B:18:0x005f, B:59:0x015f, B:61:0x0163, B:62:0x0171, B:64:0x0177, B:66:0x0188, B:67:0x018c, B:69:0x019c, B:70:0x01ac, B:72:0x01b2, B:73:0x01ba, B:75:0x01c0, B:21:0x0074, B:34:0x00c4, B:36:0x00c8, B:37:0x00dc, B:39:0x00e2, B:40:0x00f0, B:41:0x00f6, B:43:0x00fc, B:45:0x0104, B:46:0x0115, B:48:0x011b, B:49:0x0129, B:51:0x0130, B:53:0x0136, B:55:0x013e, B:22:0x007e, B:28:0x009e, B:30:0x00a2, B:25:0x008b), top: B:106:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:69:0x019c A[Catch: Exception -> 0x025c, LOOP:3: B:68:0x019a->B:69:0x019c, LOOP_END, TryCatch #0 {Exception -> 0x025c, blocks: (B:10:0x0028, B:90:0x0203, B:92:0x0207, B:94:0x0217, B:96:0x022a, B:97:0x022e, B:99:0x023e, B:100:0x024e, B:102:0x0254, B:15:0x0045, B:79:0x01df, B:82:0x01e4, B:84:0x01e8, B:86:0x01ec, B:18:0x005f, B:59:0x015f, B:61:0x0163, B:62:0x0171, B:64:0x0177, B:66:0x0188, B:67:0x018c, B:69:0x019c, B:70:0x01ac, B:72:0x01b2, B:73:0x01ba, B:75:0x01c0, B:21:0x0074, B:34:0x00c4, B:36:0x00c8, B:37:0x00dc, B:39:0x00e2, B:40:0x00f0, B:41:0x00f6, B:43:0x00fc, B:45:0x0104, B:46:0x0115, B:48:0x011b, B:49:0x0129, B:51:0x0130, B:53:0x0136, B:55:0x013e, B:22:0x007e, B:28:0x009e, B:30:0x00a2, B:25:0x008b), top: B:106:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:72:0x01b2 A[Catch: Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:10:0x0028, B:90:0x0203, B:92:0x0207, B:94:0x0217, B:96:0x022a, B:97:0x022e, B:99:0x023e, B:100:0x024e, B:102:0x0254, B:15:0x0045, B:79:0x01df, B:82:0x01e4, B:84:0x01e8, B:86:0x01ec, B:18:0x005f, B:59:0x015f, B:61:0x0163, B:62:0x0171, B:64:0x0177, B:66:0x0188, B:67:0x018c, B:69:0x019c, B:70:0x01ac, B:72:0x01b2, B:73:0x01ba, B:75:0x01c0, B:21:0x0074, B:34:0x00c4, B:36:0x00c8, B:37:0x00dc, B:39:0x00e2, B:40:0x00f0, B:41:0x00f6, B:43:0x00fc, B:45:0x0104, B:46:0x0115, B:48:0x011b, B:49:0x0129, B:51:0x0130, B:53:0x0136, B:55:0x013e, B:22:0x007e, B:28:0x009e, B:30:0x00a2, B:25:0x008b), top: B:106:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:75:0x01c0 A[Catch: Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:10:0x0028, B:90:0x0203, B:92:0x0207, B:94:0x0217, B:96:0x022a, B:97:0x022e, B:99:0x023e, B:100:0x024e, B:102:0x0254, B:15:0x0045, B:79:0x01df, B:82:0x01e4, B:84:0x01e8, B:86:0x01ec, B:18:0x005f, B:59:0x015f, B:61:0x0163, B:62:0x0171, B:64:0x0177, B:66:0x0188, B:67:0x018c, B:69:0x019c, B:70:0x01ac, B:72:0x01b2, B:73:0x01ba, B:75:0x01c0, B:21:0x0074, B:34:0x00c4, B:36:0x00c8, B:37:0x00dc, B:39:0x00e2, B:40:0x00f0, B:41:0x00f6, B:43:0x00fc, B:45:0x0104, B:46:0x0115, B:48:0x011b, B:49:0x0129, B:51:0x0130, B:53:0x0136, B:55:0x013e, B:22:0x007e, B:28:0x009e, B:30:0x00a2, B:25:0x008b), top: B:106:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:77:0x01db  */
        /* JADX WARN: Code duplicated, block: B:78:0x01dc  */
        /* JADX WARN: Code duplicated, block: B:81:0x01e3  */
        /* JADX WARN: Code duplicated, block: B:84:0x01e8 A[Catch: Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:10:0x0028, B:90:0x0203, B:92:0x0207, B:94:0x0217, B:96:0x022a, B:97:0x022e, B:99:0x023e, B:100:0x024e, B:102:0x0254, B:15:0x0045, B:79:0x01df, B:82:0x01e4, B:84:0x01e8, B:86:0x01ec, B:18:0x005f, B:59:0x015f, B:61:0x0163, B:62:0x0171, B:64:0x0177, B:66:0x0188, B:67:0x018c, B:69:0x019c, B:70:0x01ac, B:72:0x01b2, B:73:0x01ba, B:75:0x01c0, B:21:0x0074, B:34:0x00c4, B:36:0x00c8, B:37:0x00dc, B:39:0x00e2, B:40:0x00f0, B:41:0x00f6, B:43:0x00fc, B:45:0x0104, B:46:0x0115, B:48:0x011b, B:49:0x0129, B:51:0x0130, B:53:0x0136, B:55:0x013e, B:22:0x007e, B:28:0x009e, B:30:0x00a2, B:25:0x008b), top: B:106:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:89:0x0202  */
        /* JADX WARN: Code duplicated, block: B:92:0x0207 A[Catch: Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:10:0x0028, B:90:0x0203, B:92:0x0207, B:94:0x0217, B:96:0x022a, B:97:0x022e, B:99:0x023e, B:100:0x024e, B:102:0x0254, B:15:0x0045, B:79:0x01df, B:82:0x01e4, B:84:0x01e8, B:86:0x01ec, B:18:0x005f, B:59:0x015f, B:61:0x0163, B:62:0x0171, B:64:0x0177, B:66:0x0188, B:67:0x018c, B:69:0x019c, B:70:0x01ac, B:72:0x01b2, B:73:0x01ba, B:75:0x01c0, B:21:0x0074, B:34:0x00c4, B:36:0x00c8, B:37:0x00dc, B:39:0x00e2, B:40:0x00f0, B:41:0x00f6, B:43:0x00fc, B:45:0x0104, B:46:0x0115, B:48:0x011b, B:49:0x0129, B:51:0x0130, B:53:0x0136, B:55:0x013e, B:22:0x007e, B:28:0x009e, B:30:0x00a2, B:25:0x008b), top: B:106:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:94:0x0217 A[Catch: Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:10:0x0028, B:90:0x0203, B:92:0x0207, B:94:0x0217, B:96:0x022a, B:97:0x022e, B:99:0x023e, B:100:0x024e, B:102:0x0254, B:15:0x0045, B:79:0x01df, B:82:0x01e4, B:84:0x01e8, B:86:0x01ec, B:18:0x005f, B:59:0x015f, B:61:0x0163, B:62:0x0171, B:64:0x0177, B:66:0x0188, B:67:0x018c, B:69:0x019c, B:70:0x01ac, B:72:0x01b2, B:73:0x01ba, B:75:0x01c0, B:21:0x0074, B:34:0x00c4, B:36:0x00c8, B:37:0x00dc, B:39:0x00e2, B:40:0x00f0, B:41:0x00f6, B:43:0x00fc, B:45:0x0104, B:46:0x0115, B:48:0x011b, B:49:0x0129, B:51:0x0130, B:53:0x0136, B:55:0x013e, B:22:0x007e, B:28:0x009e, B:30:0x00a2, B:25:0x008b), top: B:106:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:99:0x023e A[Catch: Exception -> 0x025c, LOOP:1: B:98:0x023c->B:99:0x023e, LOOP_END, TryCatch #0 {Exception -> 0x025c, blocks: (B:10:0x0028, B:90:0x0203, B:92:0x0207, B:94:0x0217, B:96:0x022a, B:97:0x022e, B:99:0x023e, B:100:0x024e, B:102:0x0254, B:15:0x0045, B:79:0x01df, B:82:0x01e4, B:84:0x01e8, B:86:0x01ec, B:18:0x005f, B:59:0x015f, B:61:0x0163, B:62:0x0171, B:64:0x0177, B:66:0x0188, B:67:0x018c, B:69:0x019c, B:70:0x01ac, B:72:0x01b2, B:73:0x01ba, B:75:0x01c0, B:21:0x0074, B:34:0x00c4, B:36:0x00c8, B:37:0x00dc, B:39:0x00e2, B:40:0x00f0, B:41:0x00f6, B:43:0x00fc, B:45:0x0104, B:46:0x0115, B:48:0x011b, B:49:0x0129, B:51:0x0130, B:53:0x0136, B:55:0x013e, B:22:0x007e, B:28:0x009e, B:30:0x00a2, B:25:0x008b), top: B:106:0x0014 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM1024next0E7RQCE;
            Object obj2;
            NextResult nextResult;
            Object obj3;
            MusicService musicService;
            MediaMetadata currentMetadata;
            Object objM1024next0E7RQCE2;
            Object obj4;
            Object obj5;
            MusicService musicService2;
            ArrayList arrayList;
            Iterator it;
            ArrayList arrayList2;
            Iterator it2;
            Object objM1024next0E7RQCE3;
            Object obj6;
            MediaMetadata mediaMetadata;
            MusicService musicService3;
            ArrayList arrayList3;
            ArrayList arrayList4;
            int size;
            int i;
            NextResult nextResult2;
            BrowseEndpoint browseEndpoint;
            Object objM1031relatedgIAlus;
            MusicService musicService4;
            ArrayList arrayList5;
            ArrayList arrayList6;
            int size2;
            int i2;
            ArrayList arrayList7;
            int size3;
            int i3;
            Object obj7;
            byte b = this.label;
            MusicService musicService5 = this.this$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            try {
                if (b == 0) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube = YouTube.INSTANCE;
                    WatchEndpoint watchEndpoint = new WatchEndpoint(61, null, this.$playlistId, null);
                    this.label = (byte) 1;
                    objM1024next0E7RQCE = youTube.m1024next0E7RQCE(watchEndpoint, null, this);
                    if (objM1024next0E7RQCE == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM1024next0E7RQCE = ((Result) obj).value;
                } else {
                    if (b == 2) {
                        nextResult = this.L$2;
                        musicService = this.L$1;
                        obj2 = this.L$0;
                        ResultKt.throwOnFailure(obj);
                        obj3 = ((Result) obj).value;
                        if (!(obj3 instanceof Result.Failure)) {
                            StateFlowImpl stateFlowImpl = musicService.automixItems;
                            List list = ((NextResult) obj3).items;
                            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                            it2 = list.iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(UuidKt.toMediaItem((SongItem) it2.next()));
                            }
                            stateFlowImpl.getClass();
                            stateFlowImpl.updateState(null, arrayList2);
                        }
                        if (Result.m1866exceptionOrNullimpl(obj3) != null && !nextResult.items.isEmpty()) {
                            StateFlowImpl stateFlowImpl2 = musicService.automixItems;
                            List list2 = nextResult.items;
                            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                            it = list2.iterator();
                            while (it.hasNext()) {
                                arrayList.add(UuidKt.toMediaItem((SongItem) it.next()));
                            }
                            stateFlowImpl2.getClass();
                            stateFlowImpl2.updateState(null, arrayList);
                        }
                        objM1024next0E7RQCE = obj2;
                        if (Result.m1866exceptionOrNullimpl(objM1024next0E7RQCE) != null && (currentMetadata = IntMath.getCurrentMetadata(musicService5.player)) != null) {
                            YouTube youTube2 = YouTube.INSTANCE;
                            WatchEndpoint watchEndpoint2 = new WatchEndpoint(62, currentMetadata.id, null, null);
                            this.L$0 = objM1024next0E7RQCE;
                            this.L$1 = musicService5;
                            this.L$2 = null;
                            this.L$3 = currentMetadata;
                            this.label = (byte) 3;
                            objM1024next0E7RQCE2 = youTube2.m1024next0E7RQCE(watchEndpoint2, null, this);
                            if (objM1024next0E7RQCE2 != coroutineSingletons) {
                                obj4 = objM1024next0E7RQCE;
                                obj5 = objM1024next0E7RQCE2;
                                musicService2 = musicService5;
                                if (!(obj5 instanceof Result.Failure)) {
                                    List list3 = ((NextResult) obj5).items;
                                    arrayList3 = new ArrayList();
                                    for (Object obj8 : list3) {
                                        if (!Intrinsics.areEqual(((SongItem) obj8).id, currentMetadata.id)) {
                                            arrayList3.add(obj8);
                                        }
                                    }
                                    arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
                                    size = arrayList3.size();
                                    i = 0;
                                    while (i < size) {
                                        Object obj9 = arrayList3.get(i);
                                        i++;
                                        arrayList4.add(UuidKt.toMediaItem((SongItem) obj9));
                                    }
                                    if (!arrayList4.isEmpty()) {
                                        StateFlowImpl stateFlowImpl3 = musicService2.automixItems;
                                        stateFlowImpl3.getClass();
                                        stateFlowImpl3.updateState(null, arrayList4);
                                    }
                                }
                                if (Result.m1866exceptionOrNullimpl(obj5) != null) {
                                    YouTube youTube3 = YouTube.INSTANCE;
                                    WatchEndpoint watchEndpoint3 = new WatchEndpoint(62, currentMetadata.id, null, null);
                                    this.L$0 = obj4;
                                    this.L$1 = musicService2;
                                    this.L$2 = null;
                                    this.L$3 = currentMetadata;
                                    this.L$4 = obj5;
                                    this.label = (byte) 4;
                                    objM1024next0E7RQCE3 = youTube3.m1024next0E7RQCE(watchEndpoint3, null, this);
                                    if (objM1024next0E7RQCE3 == coroutineSingletons) {
                                        obj6 = obj5;
                                        mediaMetadata = currentMetadata;
                                        musicService3 = musicService2;
                                        if (objM1024next0E7RQCE3 instanceof Result.Failure) {
                                            objM1024next0E7RQCE3 = null;
                                        }
                                        nextResult2 = (NextResult) objM1024next0E7RQCE3;
                                        if (nextResult2 != null) {
                                            YouTube youTube4 = YouTube.INSTANCE;
                                            this.L$0 = obj4;
                                            this.L$1 = musicService3;
                                            this.L$2 = null;
                                            this.L$3 = mediaMetadata;
                                            this.L$4 = obj6;
                                            this.label = (byte) 5;
                                            objM1031relatedgIAlus = youTube4.m1031relatedgIAlus(browseEndpoint, this);
                                            if (objM1031relatedgIAlus != coroutineSingletons) {
                                                musicService4 = musicService3;
                                            }
                                        }
                                    }
                                }
                            }
                            return coroutineSingletons;
                        }
                        return Unit.INSTANCE;
                    }
                    if (b == 3) {
                        MediaMetadata mediaMetadata2 = this.L$3;
                        MusicService musicService6 = this.L$1;
                        Object obj10 = this.L$0;
                        ResultKt.throwOnFailure(obj);
                        musicService2 = musicService6;
                        obj4 = obj10;
                        currentMetadata = mediaMetadata2;
                        obj5 = ((Result) obj).value;
                        if (!(obj5 instanceof Result.Failure)) {
                            List list4 = ((NextResult) obj5).items;
                            arrayList3 = new ArrayList();
                            while (r6.hasNext()) {
                                if (!Intrinsics.areEqual(((SongItem) obj8).id, currentMetadata.id)) {
                                    arrayList3.add(obj8);
                                }
                            }
                            arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
                            size = arrayList3.size();
                            i = 0;
                            while (i < size) {
                                Object obj11 = arrayList3.get(i);
                                i++;
                                arrayList4.add(UuidKt.toMediaItem((SongItem) obj11));
                            }
                            if (!arrayList4.isEmpty()) {
                                StateFlowImpl stateFlowImpl4 = musicService2.automixItems;
                                stateFlowImpl4.getClass();
                                stateFlowImpl4.updateState(null, arrayList4);
                            }
                        }
                        if (Result.m1866exceptionOrNullimpl(obj5) != null) {
                            YouTube youTube5 = YouTube.INSTANCE;
                            WatchEndpoint watchEndpoint4 = new WatchEndpoint(62, currentMetadata.id, null, null);
                            this.L$0 = obj4;
                            this.L$1 = musicService2;
                            this.L$2 = null;
                            this.L$3 = currentMetadata;
                            this.L$4 = obj5;
                            this.label = (byte) 4;
                            objM1024next0E7RQCE3 = youTube5.m1024next0E7RQCE(watchEndpoint4, null, this);
                            if (objM1024next0E7RQCE3 == coroutineSingletons) {
                                obj6 = obj5;
                                mediaMetadata = currentMetadata;
                                musicService3 = musicService2;
                                if (objM1024next0E7RQCE3 instanceof Result.Failure) {
                                    objM1024next0E7RQCE3 = null;
                                }
                                nextResult2 = (NextResult) objM1024next0E7RQCE3;
                                if (nextResult2 != null) {
                                    YouTube youTube6 = YouTube.INSTANCE;
                                    this.L$0 = obj4;
                                    this.L$1 = musicService3;
                                    this.L$2 = null;
                                    this.L$3 = mediaMetadata;
                                    this.L$4 = obj6;
                                    this.label = (byte) 5;
                                    objM1031relatedgIAlus = youTube6.m1031relatedgIAlus(browseEndpoint, this);
                                    if (objM1031relatedgIAlus != coroutineSingletons) {
                                        musicService4 = musicService3;
                                    }
                                }
                            }
                            return coroutineSingletons;
                        }
                        return Unit.INSTANCE;
                    }
                    if (b == 4) {
                        Object obj12 = this.L$4;
                        MediaMetadata mediaMetadata3 = this.L$3;
                        musicService3 = this.L$1;
                        obj4 = this.L$0;
                        ResultKt.throwOnFailure(obj);
                        objM1024next0E7RQCE3 = ((Result) obj).value;
                        obj6 = obj12;
                        mediaMetadata = mediaMetadata3;
                        if (objM1024next0E7RQCE3 instanceof Result.Failure) {
                            objM1024next0E7RQCE3 = null;
                        }
                        nextResult2 = (NextResult) objM1024next0E7RQCE3;
                        if (nextResult2 != null && (browseEndpoint = nextResult2.relatedEndpoint) != null) {
                            YouTube youTube7 = YouTube.INSTANCE;
                            this.L$0 = obj4;
                            this.L$1 = musicService3;
                            this.L$2 = null;
                            this.L$3 = mediaMetadata;
                            this.L$4 = obj6;
                            this.label = (byte) 5;
                            objM1031relatedgIAlus = youTube7.m1031relatedgIAlus(browseEndpoint, this);
                            if (objM1031relatedgIAlus != coroutineSingletons) {
                                musicService4 = musicService3;
                            }
                            return coroutineSingletons;
                        }
                        return Unit.INSTANCE;
                    }
                    if (b != 5) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    mediaMetadata = this.L$3;
                    musicService4 = this.L$1;
                    ResultKt.throwOnFailure(obj);
                    objM1031relatedgIAlus = ((Result) obj).value;
                }
                if (!(objM1031relatedgIAlus instanceof Result.Failure)) {
                    arrayList5 = ((RelatedPage) objM1031relatedgIAlus).songs;
                    arrayList6 = new ArrayList();
                    size2 = arrayList5.size();
                    i2 = 0;
                    while (i2 < size2) {
                        obj7 = arrayList5.get(i2);
                        i2++;
                        if (!Intrinsics.areEqual(((SongItem) obj7).id, mediaMetadata.id)) {
                            arrayList6.add(obj7);
                        }
                    }
                    arrayList7 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList6, 10));
                    size3 = arrayList6.size();
                    i3 = 0;
                    while (i3 < size3) {
                        Object obj13 = arrayList6.get(i3);
                        i3++;
                        arrayList7.add(UuidKt.toMediaItem((SongItem) obj13));
                    }
                    if (!arrayList7.isEmpty()) {
                        StateFlowImpl stateFlowImpl5 = musicService4.automixItems;
                        stateFlowImpl5.getClass();
                        stateFlowImpl5.updateState(null, arrayList7);
                    }
                }
                return Unit.INSTANCE;
                if (objM1024next0E7RQCE instanceof Result.Failure) {
                    if (Result.m1866exceptionOrNullimpl(objM1024next0E7RQCE) != null) {
                        YouTube youTube8 = YouTube.INSTANCE;
                        WatchEndpoint watchEndpoint5 = new WatchEndpoint(62, currentMetadata.id, null, null);
                        this.L$0 = objM1024next0E7RQCE;
                        this.L$1 = musicService5;
                        this.L$2 = null;
                        this.L$3 = currentMetadata;
                        this.label = (byte) 3;
                        objM1024next0E7RQCE2 = youTube8.m1024next0E7RQCE(watchEndpoint5, null, this);
                        if (objM1024next0E7RQCE2 != coroutineSingletons) {
                            obj4 = objM1024next0E7RQCE;
                            obj5 = objM1024next0E7RQCE2;
                            musicService2 = musicService5;
                            if (!(obj5 instanceof Result.Failure)) {
                                List list5 = ((NextResult) obj5).items;
                                arrayList3 = new ArrayList();
                                while (r6.hasNext()) {
                                    if (!Intrinsics.areEqual(((SongItem) obj8).id, currentMetadata.id)) {
                                        arrayList3.add(obj8);
                                    }
                                }
                                arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
                                size = arrayList3.size();
                                i = 0;
                                while (i < size) {
                                    Object obj14 = arrayList3.get(i);
                                    i++;
                                    arrayList4.add(UuidKt.toMediaItem((SongItem) obj14));
                                }
                                if (!arrayList4.isEmpty()) {
                                    StateFlowImpl stateFlowImpl6 = musicService2.automixItems;
                                    stateFlowImpl6.getClass();
                                    stateFlowImpl6.updateState(null, arrayList4);
                                }
                            }
                            if (Result.m1866exceptionOrNullimpl(obj5) != null) {
                                YouTube youTube9 = YouTube.INSTANCE;
                                WatchEndpoint watchEndpoint6 = new WatchEndpoint(62, currentMetadata.id, null, null);
                                this.L$0 = obj4;
                                this.L$1 = musicService2;
                                this.L$2 = null;
                                this.L$3 = currentMetadata;
                                this.L$4 = obj5;
                                this.label = (byte) 4;
                                objM1024next0E7RQCE3 = youTube9.m1024next0E7RQCE(watchEndpoint6, null, this);
                                if (objM1024next0E7RQCE3 == coroutineSingletons) {
                                    obj6 = obj5;
                                    mediaMetadata = currentMetadata;
                                    musicService3 = musicService2;
                                    if (objM1024next0E7RQCE3 instanceof Result.Failure) {
                                        objM1024next0E7RQCE3 = null;
                                    }
                                    nextResult2 = (NextResult) objM1024next0E7RQCE3;
                                    if (nextResult2 != null) {
                                        YouTube youTube10 = YouTube.INSTANCE;
                                        this.L$0 = obj4;
                                        this.L$1 = musicService3;
                                        this.L$2 = null;
                                        this.L$3 = mediaMetadata;
                                        this.L$4 = obj6;
                                        this.label = (byte) 5;
                                        objM1031relatedgIAlus = youTube10.m1031relatedgIAlus(browseEndpoint, this);
                                        if (objM1031relatedgIAlus != coroutineSingletons) {
                                            musicService4 = musicService3;
                                            if (!(objM1031relatedgIAlus instanceof Result.Failure)) {
                                                arrayList5 = ((RelatedPage) objM1031relatedgIAlus).songs;
                                                arrayList6 = new ArrayList();
                                                size2 = arrayList5.size();
                                                i2 = 0;
                                                while (i2 < size2) {
                                                    obj7 = arrayList5.get(i2);
                                                    i2++;
                                                    if (!Intrinsics.areEqual(((SongItem) obj7).id, mediaMetadata.id)) {
                                                        arrayList6.add(obj7);
                                                    }
                                                }
                                                arrayList7 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList6, 10));
                                                size3 = arrayList6.size();
                                                i3 = 0;
                                                while (i3 < size3) {
                                                    Object obj15 = arrayList6.get(i3);
                                                    i3++;
                                                    arrayList7.add(UuidKt.toMediaItem((SongItem) obj15));
                                                }
                                                if (!arrayList7.isEmpty()) {
                                                    StateFlowImpl stateFlowImpl7 = musicService4.automixItems;
                                                    stateFlowImpl7.getClass();
                                                    stateFlowImpl7.updateState(null, arrayList7);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
                NextResult nextResult3 = (NextResult) objM1024next0E7RQCE;
                YouTube youTube11 = YouTube.INSTANCE;
                WatchEndpoint watchEndpoint7 = new WatchEndpoint(61, null, nextResult3.endpoint.playlistId, null);
                this.L$0 = objM1024next0E7RQCE;
                this.L$1 = musicService5;
                this.L$2 = nextResult3;
                this.label = (byte) 2;
                Object objM1024next0E7RQCE4 = youTube11.m1024next0E7RQCE(watchEndpoint7, null, this);
                if (objM1024next0E7RQCE4 != coroutineSingletons) {
                    obj2 = objM1024next0E7RQCE;
                    nextResult = nextResult3;
                    obj3 = objM1024next0E7RQCE4;
                    musicService = musicService5;
                    if (!(obj3 instanceof Result.Failure)) {
                        StateFlowImpl stateFlowImpl8 = musicService.automixItems;
                        List list6 = ((NextResult) obj3).items;
                        arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10));
                        it2 = list6.iterator();
                        while (it2.hasNext()) {
                            arrayList2.add(UuidKt.toMediaItem((SongItem) it2.next()));
                        }
                        stateFlowImpl8.getClass();
                        stateFlowImpl8.updateState(null, arrayList2);
                    }
                    if (Result.m1866exceptionOrNullimpl(obj3) != null) {
                        StateFlowImpl stateFlowImpl9 = musicService.automixItems;
                        List list7 = nextResult.items;
                        arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list7, 10));
                        it = list7.iterator();
                        while (it.hasNext()) {
                            arrayList.add(UuidKt.toMediaItem((SongItem) it.next()));
                        }
                        stateFlowImpl9.getClass();
                        stateFlowImpl9.updateState(null, arrayList);
                    }
                    objM1024next0E7RQCE = obj2;
                    if (Result.m1866exceptionOrNullimpl(objM1024next0E7RQCE) != null) {
                        YouTube youTube12 = YouTube.INSTANCE;
                        WatchEndpoint watchEndpoint8 = new WatchEndpoint(62, currentMetadata.id, null, null);
                        this.L$0 = objM1024next0E7RQCE;
                        this.L$1 = musicService5;
                        this.L$2 = null;
                        this.L$3 = currentMetadata;
                        this.label = (byte) 3;
                        objM1024next0E7RQCE2 = youTube12.m1024next0E7RQCE(watchEndpoint8, null, this);
                        if (objM1024next0E7RQCE2 != coroutineSingletons) {
                            obj4 = objM1024next0E7RQCE;
                            obj5 = objM1024next0E7RQCE2;
                            musicService2 = musicService5;
                            if (!(obj5 instanceof Result.Failure)) {
                                List list8 = ((NextResult) obj5).items;
                                arrayList3 = new ArrayList();
                                while (r6.hasNext()) {
                                    if (!Intrinsics.areEqual(((SongItem) obj8).id, currentMetadata.id)) {
                                        arrayList3.add(obj8);
                                    }
                                }
                                arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
                                size = arrayList3.size();
                                i = 0;
                                while (i < size) {
                                    Object obj16 = arrayList3.get(i);
                                    i++;
                                    arrayList4.add(UuidKt.toMediaItem((SongItem) obj16));
                                }
                                if (!arrayList4.isEmpty()) {
                                    StateFlowImpl stateFlowImpl10 = musicService2.automixItems;
                                    stateFlowImpl10.getClass();
                                    stateFlowImpl10.updateState(null, arrayList4);
                                }
                            }
                            if (Result.m1866exceptionOrNullimpl(obj5) != null) {
                                YouTube youTube13 = YouTube.INSTANCE;
                                WatchEndpoint watchEndpoint9 = new WatchEndpoint(62, currentMetadata.id, null, null);
                                this.L$0 = obj4;
                                this.L$1 = musicService2;
                                this.L$2 = null;
                                this.L$3 = currentMetadata;
                                this.L$4 = obj5;
                                this.label = (byte) 4;
                                objM1024next0E7RQCE3 = youTube13.m1024next0E7RQCE(watchEndpoint9, null, this);
                                if (objM1024next0E7RQCE3 == coroutineSingletons) {
                                    obj6 = obj5;
                                    mediaMetadata = currentMetadata;
                                    musicService3 = musicService2;
                                    if (objM1024next0E7RQCE3 instanceof Result.Failure) {
                                        objM1024next0E7RQCE3 = null;
                                    }
                                    nextResult2 = (NextResult) objM1024next0E7RQCE3;
                                    if (nextResult2 != null) {
                                        YouTube youTube14 = YouTube.INSTANCE;
                                        this.L$0 = obj4;
                                        this.L$1 = musicService3;
                                        this.L$2 = null;
                                        this.L$3 = mediaMetadata;
                                        this.L$4 = obj6;
                                        this.label = (byte) 5;
                                        objM1031relatedgIAlus = youTube14.m1031relatedgIAlus(browseEndpoint, this);
                                        if (objM1031relatedgIAlus != coroutineSingletons) {
                                            musicService4 = musicService3;
                                            if (!(objM1031relatedgIAlus instanceof Result.Failure)) {
                                                arrayList5 = ((RelatedPage) objM1031relatedgIAlus).songs;
                                                arrayList6 = new ArrayList();
                                                size2 = arrayList5.size();
                                                i2 = 0;
                                                while (i2 < size2) {
                                                    obj7 = arrayList5.get(i2);
                                                    i2++;
                                                    if (!Intrinsics.areEqual(((SongItem) obj7).id, mediaMetadata.id)) {
                                                        arrayList6.add(obj7);
                                                    }
                                                }
                                                arrayList7 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList6, 10));
                                                size3 = arrayList6.size();
                                                i3 = 0;
                                                while (i3 < size3) {
                                                    Object obj17 = arrayList6.get(i3);
                                                    i3++;
                                                    arrayList7.add(UuidKt.toMediaItem((SongItem) obj17));
                                                }
                                                if (!arrayList7.isEmpty()) {
                                                    StateFlowImpl stateFlowImpl11 = musicService4.automixItems;
                                                    stateFlowImpl11.getClass();
                                                    stateFlowImpl11.updateState(null, arrayList7);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
                return coroutineSingletons;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$markCachedIfFullyDownloaded$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01681 extends ContinuationImpl {
        public long J$0;
        public String L$0;
        public Song L$1;
        public int label;
        public /* synthetic */ Object result;

        public C01681(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            MusicService musicService = MusicService.this;
            boolean z = MusicService.isRunning;
            return musicService.markCachedIfFullyDownloaded(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$onCreate$12, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass12 extends SuspendLambda implements Function5 {
        public /* synthetic */ float F$0;
        public /* synthetic */ float F$1;
        public /* synthetic */ float F$2;
        public /* synthetic */ boolean Z$0;

        public AnonymousClass12(Continuation continuation) {
            super(5, continuation);
        }

        @Override // kotlin.jvm.functions.Function5
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            float fFloatValue = ((Number) obj).floatValue();
            boolean zBooleanValue = ((Boolean) obj2).booleanValue();
            float fFloatValue2 = ((Number) obj3).floatValue();
            float fFloatValue3 = ((Number) obj4).floatValue();
            AnonymousClass12 anonymousClass12 = MusicService.this.new AnonymousClass12((Continuation) obj5);
            anonymousClass12.F$0 = fFloatValue;
            anonymousClass12.Z$0 = zBooleanValue;
            anonymousClass12.F$1 = fFloatValue2;
            anonymousClass12.F$2 = fFloatValue3;
            return anonymousClass12.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            float f = this.F$0;
            boolean z = this.Z$0;
            float f2 = this.F$1;
            float f3 = this.F$2;
            ResultKt.throwOnFailure(obj);
            boolean z2 = MusicService.isRunning;
            float fCoerceIn = CropImageView.DEFAULT_ASPECT_RATIO;
            if (!z) {
                fCoerceIn = UuidKt.coerceIn(f * f2 * f3, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
            }
            return new Float(fCoerceIn);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$onCreate$15, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass15 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ MusicService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass15(byte b, MusicService musicService, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = musicService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            MusicService musicService = this.this$0;
            switch (b) {
                case 0:
                    return new AnonymousClass15((byte) 0, musicService, continuation);
                case 1:
                    return new AnonymousClass15((byte) 1, musicService, continuation);
                case 2:
                    return new AnonymousClass15((byte) 2, musicService, continuation);
                case 3:
                    return new AnonymousClass15((byte) 3, musicService, continuation);
                case 4:
                    return new AnonymousClass15((byte) 4, musicService, continuation);
                case 5:
                    return new AnonymousClass15((byte) 5, musicService, continuation);
                case 6:
                    return new AnonymousClass15((byte) 6, musicService, continuation);
                default:
                    return new AnonymousClass15((byte) 7, musicService, continuation);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) throws Throwable {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    ((AnonymousClass15) create((Song) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 1:
                    ((AnonymousClass15) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 2:
                    ((AnonymousClass15) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 3:
                    ((AnonymousClass15) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 4:
                    return ((AnonymousClass15) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 5:
                    return ((AnonymousClass15) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 6:
                    return ((AnonymousClass15) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                default:
                    return ((AnonymousClass15) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            MusicService musicService = this.this$0;
            switch (b) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    MusicService.updateNotification$default(musicService);
                    MusicService.updateWidgetUI$default(musicService, musicService.player.isPlaying());
                    return unit;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    try {
                        DisplayCompat.scheduleFromPreferences(musicService);
                        break;
                    } catch (Throwable unused) {
                        Timber.Forest.tag("MusicService");
                        ConnectionPool.e$1(new Object[0]);
                    }
                    return unit;
                case 2:
                    ResultKt.throwOnFailure(obj);
                    DisplayCompat.scheduleFromPreferences(musicService);
                    return unit;
                case 3:
                    ResultKt.throwOnFailure(obj);
                    DiscordRpcManager discordRpcManager = DiscordRpcManager.INSTANCE;
                    if (!discordRpcManager.isInitialized()) {
                        Timber.Forest.tag("DiscordSvc");
                        ConnectionPool.i(new Object[0]);
                        discordRpcManager.init(musicService);
                    }
                    String accessToken = discordRpcManager.getAccessToken();
                    accessToken.getClass();
                    discordRpcManager.reconnectWithToken(accessToken);
                    return unit;
                case 4:
                    ResultKt.throwOnFailure(obj);
                    MediaItem currentMediaItem = musicService.player.getCurrentMediaItem();
                    if (currentMediaItem != null) {
                        return currentMediaItem.mediaId;
                    }
                    return null;
                case 5:
                    ResultKt.throwOnFailure(obj);
                    MediaMetadata currentMetadata = IntMath.getCurrentMetadata(musicService.player);
                    return new Pair(currentMetadata != null ? currentMetadata.id : null, Boolean.valueOf(musicService.player.isPlaying()));
                case 6:
                    ResultKt.throwOnFailure(obj);
                    return new Pair(new Long(musicService.player.getCurrentPosition()), new Float(musicService.player.getPlaybackParameters().speed));
                default:
                    ResultKt.throwOnFailure(obj);
                    return new Triple(new Long(musicService.player.getCurrentPosition()), new Float(musicService.player.getPlaybackParameters().speed), Boolean.valueOf(musicService.player.isPlaying()));
            }
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public boolean label;
        public final /* synthetic */ MusicService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(byte b, MusicService musicService, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = musicService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            MusicService musicService = this.this$0;
            switch (b) {
                case 0:
                    return new AnonymousClass2((byte) 0, musicService, continuation);
                case 1:
                    return new AnonymousClass2((byte) 1, musicService, continuation);
                case 2:
                    return new AnonymousClass2((byte) 2, musicService, continuation);
                case 3:
                    return new AnonymousClass2((byte) 3, musicService, continuation);
                case 4:
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2((byte) 4, musicService, continuation);
                    anonymousClass2.label = ((Boolean) obj).booleanValue();
                    return anonymousClass2;
                case 5:
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2((byte) 5, musicService, continuation);
                    anonymousClass3.label = ((Boolean) obj).booleanValue();
                    return anonymousClass3;
                case 6:
                    return new AnonymousClass2((byte) 6, musicService, continuation);
                case 7:
                    return new AnonymousClass2((byte) 7, musicService, continuation);
                case 8:
                    AnonymousClass2 anonymousClass4 = new AnonymousClass2((byte) 8, musicService, continuation);
                    anonymousClass4.label = ((Boolean) obj).booleanValue();
                    return anonymousClass4;
                case 9:
                    AnonymousClass2 anonymousClass5 = new AnonymousClass2((byte) 9, musicService, continuation);
                    anonymousClass5.label = ((Boolean) obj).booleanValue();
                    return anonymousClass5;
                case 10:
                    return new AnonymousClass2((byte) 10, musicService, continuation);
                case 11:
                    return new AnonymousClass2((byte) 11, musicService, continuation);
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return new AnonymousClass2((byte) 12, musicService, continuation);
                case 13:
                    return new AnonymousClass2((byte) 13, musicService, continuation);
                case 14:
                    return new AnonymousClass2((byte) 14, musicService, continuation);
                case 15:
                    return new AnonymousClass2((byte) 15, musicService, continuation);
                case 16:
                    return new AnonymousClass2((byte) 16, musicService, continuation);
                case 17:
                    return new AnonymousClass2((byte) 17, musicService, continuation);
                case 18:
                    return new AnonymousClass2((byte) 18, musicService, continuation);
                case 19:
                    return new AnonymousClass2((byte) 19, musicService, continuation);
                case 20:
                    return new AnonymousClass2((byte) 20, musicService, continuation);
                case 21:
                    return new AnonymousClass2((byte) 21, musicService, continuation);
                default:
                    return new AnonymousClass2((byte) 22, musicService, continuation);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) throws Throwable {
            byte b = this.$r8$classId;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 1:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 2:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 3:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return coroutineSingletons;
                case 4:
                    Boolean bool = (Boolean) obj;
                    bool.booleanValue();
                    ((AnonymousClass2) create(bool, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 5:
                    Boolean bool2 = (Boolean) obj;
                    bool2.booleanValue();
                    ((AnonymousClass2) create(bool2, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 6:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return coroutineSingletons;
                case 7:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return coroutineSingletons;
                case 8:
                    Boolean bool3 = (Boolean) obj;
                    bool3.booleanValue();
                    ((AnonymousClass2) create(bool3, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 9:
                    Boolean bool4 = (Boolean) obj;
                    bool4.booleanValue();
                    ((AnonymousClass2) create(bool4, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 10:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 11:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 13:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 14:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 15:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 16:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 17:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return coroutineSingletons;
                case 18:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 19:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 20:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 21:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                default:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            }
        }

        /* JADX WARN: Code duplicated, block: B:31:0x0097  */
        /* JADX WARN: Code duplicated, block: B:32:0x009b A[Catch: all -> 0x0084, Exception -> 0x0088, TRY_ENTER, TryCatch #3 {Exception -> 0x0088, all -> 0x0084, blocks: (B:22:0x007c, B:29:0x0093, B:32:0x009b, B:34:0x00b5, B:37:0x00bb, B:41:0x00cb, B:43:0x00cf, B:46:0x00e8, B:49:0x00f5, B:51:0x00f9, B:53:0x0108, B:55:0x0111, B:45:0x00de, B:39:0x00bf), top: B:322:0x007c }] */
        /* JADX WARN: Code duplicated, block: B:34:0x00b5 A[Catch: all -> 0x0084, Exception -> 0x0088, TryCatch #3 {Exception -> 0x0088, all -> 0x0084, blocks: (B:22:0x007c, B:29:0x0093, B:32:0x009b, B:34:0x00b5, B:37:0x00bb, B:41:0x00cb, B:43:0x00cf, B:46:0x00e8, B:49:0x00f5, B:51:0x00f9, B:53:0x0108, B:55:0x0111, B:45:0x00de, B:39:0x00bf), top: B:322:0x007c }] */
        /* JADX WARN: Code duplicated, block: B:35:0x00b8  */
        /* JADX WARN: Code duplicated, block: B:37:0x00bb A[Catch: all -> 0x0084, Exception -> 0x0088, TryCatch #3 {Exception -> 0x0088, all -> 0x0084, blocks: (B:22:0x007c, B:29:0x0093, B:32:0x009b, B:34:0x00b5, B:37:0x00bb, B:41:0x00cb, B:43:0x00cf, B:46:0x00e8, B:49:0x00f5, B:51:0x00f9, B:53:0x0108, B:55:0x0111, B:45:0x00de, B:39:0x00bf), top: B:322:0x007c }] */
        /* JADX WARN: Code duplicated, block: B:39:0x00bf A[Catch: all -> 0x0084, Exception -> 0x0088, TryCatch #3 {Exception -> 0x0088, all -> 0x0084, blocks: (B:22:0x007c, B:29:0x0093, B:32:0x009b, B:34:0x00b5, B:37:0x00bb, B:41:0x00cb, B:43:0x00cf, B:46:0x00e8, B:49:0x00f5, B:51:0x00f9, B:53:0x0108, B:55:0x0111, B:45:0x00de, B:39:0x00bf), top: B:322:0x007c }] */
        /* JADX WARN: Code duplicated, block: B:41:0x00cb A[Catch: all -> 0x0084, Exception -> 0x0088, TryCatch #3 {Exception -> 0x0088, all -> 0x0084, blocks: (B:22:0x007c, B:29:0x0093, B:32:0x009b, B:34:0x00b5, B:37:0x00bb, B:41:0x00cb, B:43:0x00cf, B:46:0x00e8, B:49:0x00f5, B:51:0x00f9, B:53:0x0108, B:55:0x0111, B:45:0x00de, B:39:0x00bf), top: B:322:0x007c }] */
        /* JADX WARN: Code duplicated, block: B:45:0x00de A[Catch: all -> 0x0084, Exception -> 0x0088, TryCatch #3 {Exception -> 0x0088, all -> 0x0084, blocks: (B:22:0x007c, B:29:0x0093, B:32:0x009b, B:34:0x00b5, B:37:0x00bb, B:41:0x00cb, B:43:0x00cf, B:46:0x00e8, B:49:0x00f5, B:51:0x00f9, B:53:0x0108, B:55:0x0111, B:45:0x00de, B:39:0x00bf), top: B:322:0x007c }] */
        /* JADX WARN: Code duplicated, block: B:48:0x00f3 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:49:0x00f5 A[Catch: all -> 0x0084, Exception -> 0x0088, TryCatch #3 {Exception -> 0x0088, all -> 0x0084, blocks: (B:22:0x007c, B:29:0x0093, B:32:0x009b, B:34:0x00b5, B:37:0x00bb, B:41:0x00cb, B:43:0x00cf, B:46:0x00e8, B:49:0x00f5, B:51:0x00f9, B:53:0x0108, B:55:0x0111, B:45:0x00de, B:39:0x00bf), top: B:322:0x007c }] */
        /* JADX WARN: Code duplicated, block: B:50:0x00f8  */
        /* JADX WARN: Code duplicated, block: B:53:0x0108 A[Catch: all -> 0x0084, Exception -> 0x0088, TryCatch #3 {Exception -> 0x0088, all -> 0x0084, blocks: (B:22:0x007c, B:29:0x0093, B:32:0x009b, B:34:0x00b5, B:37:0x00bb, B:41:0x00cb, B:43:0x00cf, B:46:0x00e8, B:49:0x00f5, B:51:0x00f9, B:53:0x0108, B:55:0x0111, B:45:0x00de, B:39:0x00bf), top: B:322:0x007c }] */
        /* JADX WARN: Code duplicated, block: B:54:0x010f  */
        /* JADX WARN: Code duplicated, block: B:59:0x012b  */
        /* JADX WARN: Code duplicated, block: B:63:0x0135 A[Catch: all -> 0x0133, Exception -> 0x0141, TryCatch #4 {Exception -> 0x0141, all -> 0x0133, blocks: (B:57:0x0125, B:63:0x0135, B:64:0x013d), top: B:320:0x0125 }] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v93, types: [com.metrolist.music.widget.MetrolistWidgetManager] */
        /* JADX WARN: Type inference failed for: r13v21, types: [java.lang.Throwable] */
        /* JADX WARN: Type inference failed for: r5v14 */
        /* JADX WARN: Type inference failed for: r5v7 */
        /* JADX WARN: Type inference failed for: r5v8, types: [com.metrolist.music.db.entities.SongEntity] */
        /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.String] */
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
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0129 -> B:60:0x012d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 1726
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.playback.MusicService.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$onCreate$21, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass21 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public /* synthetic */ Object L$0;
        public final /* synthetic */ MusicService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass21(byte b, MusicService musicService, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = musicService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            MusicService musicService = this.this$0;
            switch (b) {
                case 0:
                    AnonymousClass21 anonymousClass21 = new AnonymousClass21((byte) 0, musicService, continuation);
                    anonymousClass21.L$0 = obj;
                    return anonymousClass21;
                case 1:
                    AnonymousClass21 anonymousClass22 = new AnonymousClass21((byte) 1, musicService, continuation);
                    anonymousClass22.L$0 = obj;
                    return anonymousClass22;
                case 2:
                    AnonymousClass21 anonymousClass23 = new AnonymousClass21((byte) 2, musicService, continuation);
                    anonymousClass23.L$0 = obj;
                    return anonymousClass23;
                case 3:
                    AnonymousClass21 anonymousClass24 = new AnonymousClass21((byte) 3, musicService, continuation);
                    anonymousClass24.L$0 = obj;
                    return anonymousClass24;
                default:
                    AnonymousClass21 anonymousClass25 = new AnonymousClass21((byte) 4, musicService, continuation);
                    anonymousClass25.L$0 = obj;
                    return anonymousClass25;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    ((AnonymousClass21) create((Pair) obj, (Continuation) obj2)).invokeSuspend(unit);
                    break;
                case 1:
                    ((AnonymousClass21) create((Triple) obj, (Continuation) obj2)).invokeSuspend(unit);
                    break;
                case 2:
                    ((AnonymousClass21) create((String) obj, (Continuation) obj2)).invokeSuspend(unit);
                    break;
                case 3:
                    ((AnonymousClass21) create((Triple) obj, (Continuation) obj2)).invokeSuspend(unit);
                    break;
                default:
                    ((AnonymousClass21) create((Triple) obj, (Continuation) obj2)).invokeSuspend(unit);
                    break;
            }
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            StandaloneCoroutine standaloneCoroutine;
            switch (this.$r8$classId) {
                case 0:
                    Pair pair = (Pair) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    boolean zBooleanValue = ((Boolean) pair.first).booleanValue();
                    boolean zBooleanValue2 = ((Boolean) pair.second).booleanValue();
                    this.this$0.player.setSkipSilenceEnabled(zBooleanValue);
                    ExoPlayerImpl exoPlayerImpl = this.this$0.secondaryPlayer;
                    if (exoPlayerImpl != null) {
                        exoPlayerImpl.setSkipSilenceEnabled(zBooleanValue);
                    }
                    boolean z = zBooleanValue && zBooleanValue2;
                    StateFlowImpl stateFlowImpl = this.this$0.instantSilenceSkipEnabled;
                    Boolean boolValueOf = Boolean.valueOf(z);
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, boolValueOf);
                    Collection<SilenceDetectorAudioProcessor> collectionValues = this.this$0.playerSilenceProcessors.values();
                    collectionValues.getClass();
                    for (SilenceDetectorAudioProcessor silenceDetectorAudioProcessor : collectionValues) {
                        silenceDetectorAudioProcessor.instantModeEnabled = z;
                        if (!z) {
                            silenceDetectorAudioProcessor.clearSilenceState();
                        }
                    }
                    if (!z && (standaloneCoroutine = this.this$0.silenceSkipJob) != null) {
                        standaloneCoroutine.cancel(null);
                    }
                    return Unit.INSTANCE;
                case 1:
                    Triple triple = (Triple) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    boolean zBooleanValue3 = ((Boolean) triple.second).booleanValue();
                    LoudnessLevel loudnessLevel = (LoudnessLevel) triple.third;
                    this.this$0.normalizationEnabledCached = zBooleanValue3;
                    this.this$0.loudnessLevelCached = loudnessLevel;
                    this.this$0.setupAudioNormalization();
                    return Unit.INSTANCE;
                case 2:
                    Unit unit = Unit.INSTANCE;
                    String str = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    ConnectionPool connectionPool = Timber.Forest;
                    connectionPool.tag("DiscordSvc");
                    Boolean boolValueOf2 = Boolean.valueOf(str != null);
                    DiscordRpcManager discordRpcManager = DiscordRpcManager.INSTANCE;
                    ConnectionPool.i(boolValueOf2, Boolean.valueOf(discordRpcManager.isInitialized()), Boolean.valueOf(discordRpcManager.isAuthorized()), Boolean.valueOf(this.this$0.discordRpcEnabled));
                    if (str == null) {
                        if (discordRpcManager.isReady()) {
                            connectionPool.tag("DiscordSvc");
                            ConnectionPool.i(new Object[0]);
                            discordRpcManager.disconnect();
                        }
                    } else if (this.this$0.discordRpcEnabled) {
                        if (!discordRpcManager.isInitialized()) {
                            connectionPool.tag("DiscordSvc");
                            ConnectionPool.i(new Object[0]);
                            discordRpcManager.init(this.this$0);
                        }
                        if (discordRpcManager.isAuthorized()) {
                            connectionPool.tag("DiscordSvc");
                            ConnectionPool.i(new Object[0]);
                        } else {
                            connectionPool.tag("DiscordSvc");
                            ConnectionPool.i(new Object[0]);
                            discordRpcManager.reconnectWithToken(str);
                        }
                    } else {
                        connectionPool.tag("DiscordSvc");
                        ConnectionPool.i(new Object[0]);
                    }
                    return unit;
                case 3:
                    Triple triple2 = (Triple) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    float fFloatValue = ((Number) triple2.first).floatValue();
                    int iIntValue = ((Number) triple2.second).intValue();
                    int iIntValue2 = ((Number) triple2.third).intValue();
                    ScrobbleManager scrobbleManager = this.this$0.scrobbleManager;
                    if (scrobbleManager != null) {
                        scrobbleManager.scrobbleDelayPercent = fFloatValue;
                        scrobbleManager.minSongDuration = iIntValue;
                        scrobbleManager.scrobbleDelaySeconds = iIntValue2;
                    }
                    return Unit.INSTANCE;
                default:
                    Triple triple3 = (Triple) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    boolean zBooleanValue4 = ((Boolean) triple3.first).booleanValue();
                    float fFloatValue2 = ((Number) triple3.second).floatValue();
                    boolean zBooleanValue5 = ((Boolean) triple3.third).booleanValue();
                    MusicService musicService = this.this$0;
                    musicService.crossfadeEnabled = zBooleanValue4;
                    musicService.crossfadeDuration = fFloatValue2 * 1000.0f;
                    musicService.crossfadeGapless = zBooleanValue5;
                    return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$onCreate$24, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass24 extends SuspendLambda implements Function4 {
        public final /* synthetic */ byte $r8$classId;
        public /* synthetic */ Object L$0;
        public /* synthetic */ Enum L$1;
        public /* synthetic */ boolean Z$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass24(int i, Continuation continuation, byte b) {
            super(i, continuation);
            this.$r8$classId = b;
        }

        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            int i = 4;
            switch (b) {
                case 0:
                    boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                    AnonymousClass24 anonymousClass24 = new AnonymousClass24(i, (Continuation) obj4, (byte) 0);
                    anonymousClass24.L$0 = (FormatEntity) obj;
                    anonymousClass24.Z$0 = zBooleanValue;
                    anonymousClass24.L$1 = (LoudnessLevel) obj3;
                    return anonymousClass24.invokeSuspend(unit);
                default:
                    boolean zBooleanValue2 = ((Boolean) obj3).booleanValue();
                    AnonymousClass24 anonymousClass25 = new AnonymousClass24(i, (Continuation) obj4, (byte) 1);
                    anonymousClass25.L$0 = (String) obj;
                    anonymousClass25.L$1 = (LocalFilter) obj2;
                    anonymousClass25.Z$0 = zBooleanValue2;
                    return anonymousClass25.invokeSuspend(unit);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    FormatEntity formatEntity = (FormatEntity) this.L$0;
                    boolean z = this.Z$0;
                    LoudnessLevel loudnessLevel = (LoudnessLevel) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    return new Triple(formatEntity, Boolean.valueOf(z), loudnessLevel);
                default:
                    String str = (String) this.L$0;
                    LocalFilter localFilter = (LocalFilter) this.L$1;
                    boolean z2 = this.Z$0;
                    ResultKt.throwOnFailure(obj);
                    return new Triple(str, localFilter, Boolean.valueOf(z2));
            }
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$onCreate$28, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass28 extends SuspendLambda implements Function3 {
        public /* synthetic */ boolean Z$0;
        public /* synthetic */ boolean Z$1;

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            boolean zBooleanValue2 = ((Boolean) obj2).booleanValue();
            AnonymousClass28 anonymousClass28 = new AnonymousClass28(3, (Continuation) obj3);
            anonymousClass28.Z$0 = zBooleanValue;
            anonymousClass28.Z$1 = zBooleanValue2;
            return anonymousClass28.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z = this.Z$0;
            boolean z2 = this.Z$1;
            ResultKt.throwOnFailure(obj);
            if (z2) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$onCreate$37, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass37 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public /* synthetic */ Object L$0;
        public boolean label;
        public final /* synthetic */ MusicService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass37(byte b, MusicService musicService, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = musicService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            MusicService musicService = this.this$0;
            switch (b) {
                case 0:
                    AnonymousClass37 anonymousClass37 = new AnonymousClass37((byte) 0, musicService, continuation);
                    anonymousClass37.L$0 = obj;
                    return anonymousClass37;
                case 1:
                    AnonymousClass37 anonymousClass38 = new AnonymousClass37((byte) 1, musicService, continuation);
                    anonymousClass38.L$0 = obj;
                    return anonymousClass38;
                case 2:
                    AnonymousClass37 anonymousClass39 = new AnonymousClass37((byte) 2, musicService, continuation);
                    anonymousClass39.L$0 = obj;
                    return anonymousClass39;
                default:
                    AnonymousClass37 anonymousClass310 = new AnonymousClass37((byte) 3, musicService, continuation);
                    anonymousClass310.L$0 = obj;
                    return anonymousClass310;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
            return ((AnonymousClass37) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        /* JADX WARN: Code duplicated, block: B:105:0x0245  */
        /* JADX WARN: Code duplicated, block: B:107:0x0251  */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v2, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r6v3 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x024f -> B:108:0x0253). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003b -> B:15:0x0040). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0183 -> B:63:0x0187). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0210 -> B:92:0x0214). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r23) {
            /*
                Method dump skipped, instruction units count: 630
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.playback.MusicService.AnonymousClass37.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$onCreate$45, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass45 extends SuspendLambda implements Function3 {
        public /* synthetic */ Triple L$0;
        public /* synthetic */ Listentogether.RoomState L$1;

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            AnonymousClass45 anonymousClass45 = new AnonymousClass45(3, (Continuation) obj3);
            anonymousClass45.L$0 = (Triple) obj;
            anonymousClass45.L$1 = (Listentogether.RoomState) obj2;
            return anonymousClass45.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Triple triple = this.L$0;
            Listentogether.RoomState roomState = this.L$1;
            ResultKt.throwOnFailure(obj);
            boolean zBooleanValue = ((Boolean) triple.first).booleanValue();
            float fFloatValue = ((Number) triple.second).floatValue();
            Boolean bool = (Boolean) triple.third;
            bool.getClass();
            return new Triple(Boolean.valueOf(zBooleanValue && roomState == null), new Float(fFloatValue), bool);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$performInstantSilenceSkip$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01691 extends ContinuationImpl {
        public int I$0;
        public long J$0;
        public SilenceDetectorAudioProcessor L$0;
        public int label;
        public /* synthetic */ Object result;

        public C01691(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            MusicService musicService = MusicService.this;
            boolean z = MusicService.isRunning;
            return musicService.performInstantSilenceSkip(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$playQueue$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01712 extends SuspendLambda implements Function2 {
        public final /* synthetic */ boolean $playWhenReady;
        public final /* synthetic */ Queue $queue;
        public boolean label;
        public final /* synthetic */ MusicService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01712(MusicService musicService, Queue queue, Continuation continuation, boolean z) {
            super(2, continuation);
            this.$queue = queue;
            this.this$0 = musicService;
            this.$playWhenReady = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C01712(this.this$0, this.$queue, continuation, this.$playWhenReady);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C01712) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z = this.label;
            Queue queue = this.$queue;
            MusicService musicService = this.this$0;
            if (!z) {
                ResultKt.throwOnFailure(obj);
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                MusicService$playQueue$2$initialStatus$1 musicService$playQueue$2$initialStatus$1 = new MusicService$playQueue$2$initialStatus$1(queue, musicService, null);
                this.label = true;
                obj = AwaitKt.withContext(defaultIoScheduler, musicService$playQueue$2$initialStatus$1, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            Queue.Status status = (Queue.Status) obj;
            MediaMetadata preloadItem = queue.getPreloadItem();
            Unit unit = Unit.INSTANCE;
            if (preloadItem == null || musicService.player.getPlaybackState() != 1) {
                if (status.getTitle() != null) {
                    musicService.queueTitle = status.getTitle();
                }
                if (!status.getItems().isEmpty()) {
                    musicService.originalQueueSize = status.getItems().size();
                    MediaMetadata preloadItem2 = queue.getPreloadItem();
                    ExoPlayerImpl exoPlayerImpl = musicService.player;
                    if (preloadItem2 != null) {
                        exoPlayerImpl.addMediaItems(0, status.getItems().subList(0, status.getMediaItemIndex()));
                        musicService.player.addMediaItems(status.getItems().subList(status.getMediaItemIndex() + 1, status.getItems().size()));
                    } else {
                        exoPlayerImpl.setMediaItems(status.getItems(), status.getMediaItemIndex() > 0 ? status.getMediaItemIndex() : 0, status.getPosition());
                        musicService.player.prepare();
                        musicService.player.setPlayWhenReady(this.$playWhenReady);
                    }
                    ExoPlayerImpl exoPlayerImpl2 = musicService.player;
                    exoPlayerImpl2.verifyApplicationThread();
                    if (exoPlayerImpl2.shuffleModeEnabled) {
                        musicService.applyShuffleOrder(musicService.player.getCurrentMediaItemIndex(), ((Boolean) UtilsKt.get(UtilsKt.getDataStore(musicService), PreferenceKeysKt.ShufflePlaylistFirstKey, Boolean.FALSE)).booleanValue(), musicService.player.getMediaItemCount());
                    }
                }
            }
            return unit;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$recoverSong$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01721 extends ContinuationImpl {
        public int I$0;
        public String L$0;
        public InnerTubeXPlayer.PlaybackData L$1;
        public Song L$2;
        public int label;
        public /* synthetic */ Object result;

        public C01721(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            MusicService musicService = MusicService.this;
            boolean z = MusicService.isRunning;
            return musicService.recoverSong(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$refreshStreamAndRetry$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass3 extends SuspendLambda implements Function2 {
        public final /* synthetic */ String $mediaId;
        public final /* synthetic */ int $retryIndex;
        public final /* synthetic */ boolean $retryPlayWhenReady;
        public final /* synthetic */ long $retryPosition;
        public final /* synthetic */ String $retryReason;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, int i, long j, boolean z, String str2, Continuation continuation) {
            super(2, continuation);
            this.$mediaId = str;
            this.$retryIndex = i;
            this.$retryPosition = j;
            this.$retryPlayWhenReady = z;
            this.$retryReason = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MusicService.this.new AnonymousClass3(this.$mediaId, this.$retryIndex, this.$retryPosition, this.$retryPlayWhenReady, this.$retryReason, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z = this.label;
            MusicService musicService = MusicService.this;
            if (!z) {
                ResultKt.throwOnFailure(obj);
                long j = musicService.RETRY_DELAY_MS;
                this.label = true;
                Object objDelay = AwaitKt.delay(j, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objDelay == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            MediaItem currentMediaItem = musicService.player.getCurrentMediaItem();
            boolean zAreEqual = Intrinsics.areEqual(currentMediaItem != null ? currentMediaItem.mediaId : null, this.$mediaId);
            Unit unit = Unit.INSTANCE;
            if (zAreEqual) {
                int currentMediaItemIndex = musicService.player.getCurrentMediaItemIndex();
                int i = this.$retryIndex;
                if (currentMediaItemIndex == i) {
                    long currentPosition = musicService.player.getCurrentPosition();
                    long j2 = this.$retryPosition;
                    if (currentPosition == j2 && musicService.player.getPlayWhenReady() == this.$retryPlayWhenReady) {
                        musicService.retryJob = null;
                        musicService.player.seekTo(i, j2, false);
                        musicService.player.prepare();
                        Timber.Forest.tag("MusicService");
                        ConnectionPool.d(new Object[0]);
                        return unit;
                    }
                }
            }
            Timber.Forest.tag("MusicService");
            ConnectionPool.d(new Object[0]);
            return unit;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$setupAudioNormalization$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01731 extends SuspendLambda implements Function2 {
        public final /* synthetic */ long $requestGeneration;
        public String L$0;
        public boolean Z$0;
        public byte label;
        public final /* synthetic */ MusicService this$0;

        /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$setupAudioNormalization$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class C00071 extends SuspendLambda implements Function2 {
            public final /* synthetic */ String $currentMediaId;
            public final /* synthetic */ FormatEntity $format;
            public final /* synthetic */ long $requestGeneration;
            public /* synthetic */ Object L$0;
            public final /* synthetic */ MusicService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00071(long j, MusicService musicService, String str, FormatEntity formatEntity, Continuation continuation) {
                super(2, continuation);
                this.$requestGeneration = j;
                this.this$0 = musicService;
                this.$currentMediaId = str;
                this.$format = formatEntity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                C00071 c00071 = new C00071(this.$requestGeneration, this.this$0, this.$currentMediaId, this.$format, continuation);
                c00071.L$0 = obj;
                return c00071;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                C00071 c00071 = (C00071) create((CoroutineScope) obj, (Continuation) obj2);
                Unit unit = Unit.INSTANCE;
                c00071.invokeSuspend(unit);
                return unit;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                VolumeNormalizationAudioProcessor volumeNormalizationAudioProcessor;
                FormatEntity formatEntity;
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                boolean zIsActive = AwaitKt.isActive(coroutineScope);
                Unit unit = Unit.INSTANCE;
                if (zIsActive) {
                    long j = this.$requestGeneration;
                    MusicService musicService = this.this$0;
                    if (j == musicService.loudnessSetupGeneration) {
                        MediaItem currentMediaItem = musicService.player.getCurrentMediaItem();
                        String str = currentMediaItem != null ? currentMediaItem.mediaId : null;
                        String str2 = this.$currentMediaId;
                        if (Intrinsics.areEqual(str, str2) && (volumeNormalizationAudioProcessor = (VolumeNormalizationAudioProcessor) musicService.playerNormalizationProcessors.get(musicService.player)) != null && ((formatEntity = this.$format) != null || !Intrinsics.areEqual(musicService.cachedNormalizationMediaId, str2))) {
                            musicService.applyAudioNormalization(volumeNormalizationAudioProcessor, this.$currentMediaId, formatEntity != null ? formatEntity.loudnessDb : null, formatEntity != null ? formatEntity.perceptualLoudnessDb : null, true);
                        }
                    }
                }
                return unit;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01731(long j, MusicService musicService, Continuation continuation) {
            super(2, continuation);
            this.this$0 = musicService;
            this.$requestGeneration = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C01731(this.$requestGeneration, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C01731) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x009b  */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00b3, code lost:
        
            if (kotlinx.coroutines.AwaitKt.withContext(r2, r5, r16) == r0) goto L34;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objWithContext;
            Object objWithContext2;
            String str;
            boolean z;
            HandlerContext handlerContext;
            C00071 c00071;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            byte b = this.label;
            byte b2 = 4;
            Continuation continuation = null;
            try {
                if (b == 0) {
                    ResultKt.throwOnFailure(obj);
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    HandlerContext handlerContext2 = MainDispatcherLoader.dispatcher;
                    AnonymousClass15 anonymousClass15 = new AnonymousClass15(b2, this.this$0, continuation);
                    this.label = (byte) 1;
                    objWithContext = AwaitKt.withContext(handlerContext2, anonymousClass15, this);
                    if (objWithContext == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b == 1) {
                    ResultKt.throwOnFailure(obj);
                    objWithContext = obj;
                } else if (b == 2) {
                    z = this.Z$0;
                    String str2 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    str = str2;
                    objWithContext2 = obj;
                    FormatEntity formatEntity = (FormatEntity) objWithContext2;
                    Timber.Forest.tag("MusicService");
                    ConnectionPool.d(new Object[0]);
                    DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                    handlerContext = MainDispatcherLoader.dispatcher;
                    c00071 = new C00071(this.$requestGeneration, this.this$0, str, formatEntity, null);
                    this.L$0 = null;
                    this.Z$0 = z;
                    this.label = (byte) 3;
                    if (AwaitKt.withContext(handlerContext, c00071, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (b != 3 && b != 4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
                String str3 = (String) objWithContext;
                boolean z2 = this.this$0.normalizationEnabledCached;
                if (!z2 || str3 == null) {
                    DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                    HandlerContext handlerContext3 = MainDispatcherLoader.dispatcher;
                    MainActivity$MetrolistApp$4$1 mainActivity$MetrolistApp$4$1 = new MainActivity$MetrolistApp$4$1(this.$requestGeneration, this.this$0, null);
                    this.L$0 = null;
                    this.Z$0 = z2;
                    this.label = (byte) 4;
                } else {
                    DefaultScheduler defaultScheduler4 = Dispatchers.Default;
                    DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                    MusicService$handleAlarmTrigger$2 musicService$handleAlarmTrigger$2 = new MusicService$handleAlarmTrigger$2(this.this$0, str3, continuation, (byte) 11);
                    this.L$0 = str3;
                    this.Z$0 = z2;
                    this.label = (byte) 2;
                    objWithContext2 = AwaitKt.withContext(defaultIoScheduler, musicService$handleAlarmTrigger$2, this);
                    if (objWithContext2 != coroutineSingletons) {
                        str = str3;
                        z = z2;
                        FormatEntity formatEntity2 = (FormatEntity) objWithContext2;
                        Timber.Forest.tag("MusicService");
                        ConnectionPool.d(new Object[0]);
                        DefaultScheduler defaultScheduler5 = Dispatchers.Default;
                        handlerContext = MainDispatcherLoader.dispatcher;
                        c00071 = new C00071(this.$requestGeneration, this.this$0, str, formatEntity2, null);
                        this.L$0 = null;
                        this.Z$0 = z;
                        this.label = (byte) 3;
                        if (AwaitKt.withContext(handlerContext, c00071, this) == coroutineSingletons) {
                        }
                        return Unit.INSTANCE;
                    }
                }
                return coroutineSingletons;
            } catch (CancellationException e) {
                throw e;
            } catch (Exception e2) {
                e2.printStackTrace();
                Collection collectionValues = this.this$0.playerNormalizationProcessors.values();
                collectionValues.getClass();
                Iterator it = collectionValues.iterator();
                while (it.hasNext()) {
                    ((VolumeNormalizationAudioProcessor) it.next()).setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$startRadioSeamlessly$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01741 extends SuspendLambda implements Function2 {
        public final /* synthetic */ int $currentIndex;
        public final /* synthetic */ String $currentMediaId;
        public int I$0;
        public YouTubeQueue L$0;
        public MusicService L$3;
        public String L$4;
        public byte label;
        public final /* synthetic */ MusicService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01741(String str, MusicService musicService, int i, Continuation continuation) {
            super(2, continuation);
            this.$currentMediaId = str;
            this.this$0 = musicService;
            this.$currentIndex = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C01741(this.$currentMediaId, this.this$0, this.$currentIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C01741) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            BrowseEndpoint browseEndpoint;
            MusicService musicService;
            int i;
            String str;
            YouTubeQueue youTubeQueue;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            byte b = this.label;
            int i2 = 0;
            Object[] objArr = 0;
            int i3 = 2;
            Continuation continuation = null;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            try {
                try {
                    if (b == 0) {
                        ResultKt.throwOnFailure(obj);
                        youTubeQueue = new YouTubeQueue(new WatchEndpoint(62, this.$currentMediaId, null, null), objArr3 == true ? 1 : 0, i3, objArr2 == true ? 1 : 0);
                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                        MusicService$startRadioSeamlessly$1$initialStatus$1 musicService$startRadioSeamlessly$1$initialStatus$1 = new MusicService$startRadioSeamlessly$1$initialStatus$1(youTubeQueue, this.this$0, null);
                        this.L$0 = youTubeQueue;
                        this.label = (byte) 1;
                        obj = AwaitKt.withContext(defaultIoScheduler, musicService$startRadioSeamlessly$1$initialStatus$1, this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (b != 1) {
                            if (b == 2) {
                                ResultKt.throwOnFailure(obj);
                                NextResult nextResult = (NextResult) obj;
                                if (nextResult != null && (browseEndpoint = nextResult.relatedEndpoint) != null) {
                                    MusicService musicService2 = this.this$0;
                                    int i4 = this.$currentIndex;
                                    String str2 = this.$currentMediaId;
                                    DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                                    DefaultIoScheduler defaultIoScheduler2 = DefaultIoScheduler.INSTANCE;
                                    MusicService$startRadioSeamlessly$1$1$relatedPage$1 musicService$startRadioSeamlessly$1$1$relatedPage$1 = new MusicService$startRadioSeamlessly$1$1$relatedPage$1(browseEndpoint, continuation, objArr == true ? 1 : 0);
                                    this.L$0 = null;
                                    this.L$3 = musicService2;
                                    this.L$4 = str2;
                                    this.I$0 = i4;
                                    this.label = (byte) 3;
                                    obj = AwaitKt.withContext(defaultIoScheduler2, musicService$startRadioSeamlessly$1$1$relatedPage$1, this);
                                    if (obj != coroutineSingletons) {
                                        musicService = musicService2;
                                        i = i4;
                                        str = str2;
                                    }
                                    return coroutineSingletons;
                                }
                                return Unit.INSTANCE;
                            }
                            if (b != 3) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            i = this.I$0;
                            str = this.L$4;
                            musicService = this.L$3;
                            ResultKt.throwOnFailure(obj);
                            RelatedPage relatedPage = (RelatedPage) obj;
                            if (relatedPage != null) {
                                ArrayList arrayList = relatedPage.songs;
                                ArrayList arrayList2 = new ArrayList();
                                int size = arrayList.size();
                                int i5 = 0;
                                while (i5 < size) {
                                    Object obj2 = arrayList.get(i5);
                                    i5++;
                                    if (!Intrinsics.areEqual(((SongItem) obj2).id, str)) {
                                        arrayList2.add(obj2);
                                    }
                                }
                                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
                                int size2 = arrayList2.size();
                                while (i2 < size2) {
                                    Object obj3 = arrayList2.get(i2);
                                    i2++;
                                    arrayList3.add(UuidKt.toMediaItem((SongItem) obj3));
                                }
                                List<MediaItem> listFilterVideoSongs = QueueKt.filterVideoSongs(QueueKt.filterExplicit(arrayList3, musicService.cachedHideExplicit), musicService.cachedHideVideoSongs);
                                if (!listFilterVideoSongs.isEmpty()) {
                                    int mediaItemCount = musicService.player.getMediaItemCount();
                                    int i6 = i + 1;
                                    if (mediaItemCount > i6) {
                                        musicService.player.removeMediaItems(i6, mediaItemCount);
                                    }
                                    musicService.player.addMediaItems(i6, listFilterVideoSongs);
                                    ExoPlayerImpl exoPlayerImpl = musicService.player;
                                    exoPlayerImpl.verifyApplicationThread();
                                    if (exoPlayerImpl.shuffleModeEnabled) {
                                        musicService.applyShuffleOrder(musicService.player.getCurrentMediaItemIndex(), musicService.cachedShufflePlaylistFirst, musicService.player.getMediaItemCount());
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        youTubeQueue = this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    Queue.Status status = (Queue.Status) obj;
                    if (status.getTitle() != null) {
                        this.this$0.queueTitle = status.getTitle();
                    }
                    List<MediaItem> items = status.getItems();
                    String str3 = this.$currentMediaId;
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj4 : items) {
                        if (!Intrinsics.areEqual(((MediaItem) obj4).mediaId, str3)) {
                            arrayList4.add(obj4);
                        }
                    }
                    if (!arrayList4.isEmpty()) {
                        int mediaItemCount2 = this.this$0.player.getMediaItemCount();
                        int i7 = this.$currentIndex + 1;
                        if (mediaItemCount2 > i7) {
                            this.this$0.player.removeMediaItems(i7, mediaItemCount2);
                        }
                        this.this$0.player.addMediaItems(this.$currentIndex + 1, arrayList4);
                        ExoPlayerImpl exoPlayerImpl2 = this.this$0.player;
                        exoPlayerImpl2.verifyApplicationThread();
                        if (exoPlayerImpl2.shuffleModeEnabled) {
                            boolean zBooleanValue = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(this.this$0), PreferenceKeysKt.ShufflePlaylistFirstKey, Boolean.FALSE)).booleanValue();
                            MusicService musicService3 = this.this$0;
                            musicService3.applyShuffleOrder(musicService3.player.getCurrentMediaItemIndex(), zBooleanValue, this.this$0.player.getMediaItemCount());
                        }
                    }
                    this.this$0.currentQueue = youTubeQueue;
                } catch (Exception unused) {
                    DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                    DefaultIoScheduler defaultIoScheduler3 = DefaultIoScheduler.INSTANCE;
                    MusicService$startRadioSeamlessly$1$nextResult$1 musicService$startRadioSeamlessly$1$nextResult$1 = new MusicService$startRadioSeamlessly$1$nextResult$1(this.$currentMediaId, null);
                    this.L$0 = null;
                    this.label = (byte) 2;
                    obj = AwaitKt.withContext(defaultIoScheduler3, musicService$startRadioSeamlessly$1$nextResult$1, this);
                    if (obj == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
            } catch (Exception unused2) {
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$toggleEpisodeSaveForLater$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01751 extends ContinuationImpl {
        public int I$1;
        public SongEntity L$0;
        public int label;
        public /* synthetic */ Object result;

        public C01751(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            MusicService musicService = MusicService.this;
            boolean z = MusicService.isRunning;
            return musicService.toggleEpisodeSaveForLater(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$toggleLike$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01761 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public byte label;
        public final /* synthetic */ MusicService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C01761(byte b, MusicService musicService, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = musicService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            MusicService musicService = this.this$0;
            switch (b) {
                case 0:
                    return new C01761((byte) 0, musicService, continuation);
                default:
                    return new C01761((byte) 1, musicService, continuation);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    break;
            }
            return ((C01761) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
        
            if (r8.performInstantSilenceSkip(r7) == r0) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0077, code lost:
        
            if (r0.toggleEpisodeSaveForLater(r8, r7) == r5) goto L35;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    MusicService musicService = this.this$0;
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    byte b = this.label;
                    if (b == 0) {
                        ResultKt.throwOnFailure(obj);
                        ReadonlyStateFlow readonlyStateFlow = musicService.currentSong;
                        this.label = (byte) 1;
                        obj = StateFlowKt.first(readonlyStateFlow, this);
                        if (obj != coroutineSingletons) {
                        }
                        return coroutineSingletons;
                    }
                    if (b == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (b != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                    Song song = (Song) obj;
                    if (song != null) {
                        SongEntity songEntity = song.song;
                        if (songEntity.isEpisode) {
                            this.label = (byte) 2;
                            boolean z = MusicService.isRunning;
                        } else {
                            SongEntity songEntity2 = songEntity.toggleLike(false);
                            boolean z2 = songEntity2.liked;
                            Boolean boolValueOf = Boolean.valueOf(z2);
                            boolean z3 = MusicService.isRunning;
                            musicService.updateNotification(boolValueOf);
                            musicService.updateWidgetUI(musicService.player.isPlaying(), Boolean.valueOf(z2));
                            musicService.getDatabase().query(new QuickJs$$ExternalSyntheticLambda1(songEntity2, musicService, (byte) 24));
                            musicService.currentMediaMetadata.setValue(IntMath.getCurrentMetadata(musicService.player));
                        }
                        break;
                    }
                    return Unit.INSTANCE;
                default:
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    byte b2 = this.label;
                    if (b2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = (byte) 1;
                        if (AwaitKt.delay(200L, this) != coroutineSingletons2) {
                        }
                        return coroutineSingletons2;
                    }
                    if (b2 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (b2 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                    MusicService musicService2 = this.this$0;
                    this.label = (byte) 2;
                    boolean z4 = MusicService.isRunning;
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$updateDiscordRPC$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01771 extends ContinuationImpl {
        public float F$0;
        public int I$0;
        public long J$0;
        public long J$1;
        public long J$2;
        public long J$3;
        public Song L$0;
        public String L$10;
        public String L$11;
        public String L$12;
        public String L$13;
        public String L$14;
        public String L$15;
        public PresenceStatus L$18;
        public Song L$19;
        public String L$20;
        public String L$21;
        public String L$22;
        public String L$7;
        public String L$9;
        public boolean Z$0;
        public boolean Z$1;
        public boolean Z$2;
        public boolean Z$3;
        public int label;
        public /* synthetic */ Object result;

        public C01771(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            MusicService musicService = MusicService.this;
            boolean z = MusicService.isRunning;
            return musicService.updateDiscordRPC(null, false, this);
        }
    }

    static {
        CompletableDeferredImpl completableDeferredImplCompletableDeferred$default = AwaitKt.CompletableDeferred$default();
        completableDeferredImplCompletableDeferred$default.makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
        shutdownDeferred = completableDeferredImplCompletableDeferred$default;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.metrolist.music.playback.MusicService$secondaryPlayerListener$1] */
    public MusicService() {
        byte b = 1;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        ContextScope contextScopeCoroutineScope = AwaitKt.CoroutineScope(MainDispatcherLoader.dispatcher.plus(AwaitKt.SupervisorJob$default()));
        this.scope = contextScopeCoroutineScope;
        this.binder = new MusicBinder();
        Boolean bool = Boolean.FALSE;
        this.waitingForNetworkConnection = StateFlowKt.MutableStateFlow(bool);
        this.isNetworkConnected = StateFlowKt.MutableStateFlow(bool);
        Continuation continuation = null;
        this.currentStreamClient = StateFlowKt.MutableStateFlow(null);
        this.currentQueue = EmptyQueue.INSTANCE;
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.currentMediaMetadata = stateFlowImplMutableStateFlow;
        byte b2 = 0;
        this.currentSong = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(stateFlowImplMutableStateFlow, new MusicService$special$$inlined$flatMapLatest$1(b2, this, continuation)), contextScopeCoroutineScope, SharingStarted.Companion.Lazily, null);
        this.currentFormat = FlowKt__MergeKt.transformLatest(stateFlowImplMutableStateFlow, new MusicService$special$$inlined$flatMapLatest$1(b, this, continuation));
        this.isMuted = StateFlowKt.MutableStateFlow(bool);
        Float fValueOf = Float.valueOf(1.0f);
        this.sleepTimerVolumeMultiplier = StateFlowKt.MutableStateFlow(fValueOf);
        this.audioFocusVolumeMultiplier = StateFlowKt.MutableStateFlow(fValueOf);
        StateFlowImpl stateFlowImplMutableStateFlow2 = StateFlowKt.MutableStateFlow(bool);
        this.playerInitialized = stateFlowImplMutableStateFlow2;
        this.isPlayerReady = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
        StateFlowImpl stateFlowImplMutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this._playerFlow = stateFlowImplMutableStateFlow3;
        this.playerFlow = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow3);
        this.playerSilenceProcessors = new HashMap();
        this.instantSilenceSkipEnabled = StateFlowKt.MutableStateFlow(bool);
        this.playerNormalizationProcessors = new HashMap();
        this.playerEqualizerProcessors = new HashMap();
        this.loudnessLevelCached = LoudnessLevel.BALANCED;
        this.screenOffHandler = new Handler(Looper.getMainLooper());
        this.screenOffTimeout = new MusicService$$ExternalSyntheticLambda0(this, b2);
        this.pauseTimeout = new MusicService$$ExternalSyntheticLambda0(this, b);
        this.lastPlaybackSpeed = 1.0f;
        this.automixItems = StateFlowKt.MutableStateFlow(EmptyList.INSTANCE);
        this.cachedPersistentQueue = true;
        this.cachedAutoplay = true;
        this.cachedAutoLoadMore = true;
        this.songUrlCache = new StreamUrlCache();
        this.recoveringSongs = Collections.synchronizedSet(new LinkedHashSet());
        this.playbackUrlCache = Collections.synchronizedMap(new MusicService$playbackUrlCache$1(0, 0.75f, true));
        this.bypassCacheForQualityChange = new LinkedHashSet();
        this.currentMediaIdRetryCount = new LinkedHashMap();
        this.MAX_RETRY_PER_SONG = (byte) 3;
        this.RETRY_DELAY_MS = (short) 1000;
        this.recentlyFailedSongs = new LinkedHashSet();
        this.screenStateReceiver = new NetworkTypeObserver.Receiver((byte) 7, this);
        this.audioDeviceCallback = new MusicService$audioDeviceCallback$1(b2, this);
        this.previousMediaItemIndex = -1;
    }

    public static String cacheKey(String str) {
        YouTube youTube = YouTube.INSTANCE;
        InnerTube innerTube = YouTube.innerTube;
        String str2 = ((com.metrolist.innertubex.InnerTube.SessionSnapshot) innerTube.innerTubeX.session.get()).dataSyncId;
        String str3 = null;
        if (str2 == null || StringsKt.isBlank(str2)) {
            str2 = null;
        }
        if (str2 == null) {
            String str4 = ((com.metrolist.innertubex.InnerTube.SessionSnapshot) innerTube.innerTubeX.session.get()).visitorData;
            if (str4 != null && !StringsKt.isBlank(str4)) {
                str3 = str4;
            }
            str2 = str3 == null ? "" : str3;
        }
        return IntIntPair$$ExternalSyntheticOutline0.m(str2, ServerSentEventKt.COLON, str);
    }

    public static boolean isPageReloadError(PlaybackException playbackException) {
        String lowerCase;
        String lowerCase2;
        Throwable cause;
        String message;
        String message2;
        String message3 = playbackException.getMessage();
        String lowerCase3 = "";
        if (message3 != null) {
            lowerCase = message3.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
        } else {
            lowerCase = "";
        }
        Throwable cause2 = playbackException.getCause();
        if (cause2 == null || (message2 = cause2.getMessage()) == null) {
            lowerCase2 = "";
        } else {
            lowerCase2 = message2.toLowerCase(Locale.ROOT);
            lowerCase2.getClass();
        }
        Throwable cause3 = playbackException.getCause();
        if (cause3 != null && (cause = cause3.getCause()) != null && (message = cause.getMessage()) != null) {
            lowerCase3 = message.toLowerCase(Locale.ROOT);
            lowerCase3.getClass();
        }
        List<String> listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"page needs to be reloaded", "pagina deve essere ricaricata", "la pagina deve essere ricaricata", "page must be reloaded", "reload", "ricaricata"});
        if (!listListOf.isEmpty()) {
            for (String str : listListOf) {
                if (StringsKt.contains(lowerCase, str, false) || StringsKt.contains(lowerCase2, str, false) || StringsKt.contains(lowerCase3, str, false)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static /* synthetic */ void playQueue$default(MusicService musicService, Queue queue, boolean z, int i) throws IOException {
        if ((i & 2) != 0) {
            z = true;
        }
        musicService.playQueue(queue, z, false);
    }

    public static void updateNotification$default(MusicService musicService) {
        Boolean boolValueOf;
        SongEntity songEntity;
        boolean z;
        Song song = (Song) musicService.currentSong.$$delegate_0.getValue();
        if (song == null || (songEntity = song.song) == null) {
            boolValueOf = null;
        } else {
            if (songEntity.isEpisode) {
                z = songEntity.inLibrary != null;
            } else {
                z = songEntity.liked;
            }
            boolValueOf = Boolean.valueOf(z);
        }
        musicService.updateNotification(boolValueOf);
    }

    public static void updateWidgetUI$default(MusicService musicService, boolean z) {
        Boolean boolValueOf;
        SongEntity songEntity;
        boolean z2;
        Song song = (Song) musicService.currentSong.$$delegate_0.getValue();
        if (song == null || (songEntity = song.song) == null) {
            boolValueOf = null;
        } else {
            if (songEntity.isEpisode) {
                z2 = songEntity.inLibrary != null;
            } else {
                z2 = songEntity.liked;
            }
            boolValueOf = Boolean.valueOf(z2);
        }
        musicService.updateWidgetUI(z, boolValueOf);
    }

    public final void abandonAudioFocus() {
        AudioFocusRequest audioFocusRequest;
        if (!this.hasAudioFocus || (audioFocusRequest = this.audioFocusRequest) == null) {
            return;
        }
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioManager");
            throw null;
        }
        audioManager.abandonAudioFocusRequest(audioFocusRequest);
        this.hasAudioFocus = false;
    }

    public final void addToQueue(List list) {
        if (((Boolean) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.PreventDuplicateTracksInQueueKey, Boolean.FALSE)).booleanValue()) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((MediaItem) it.next()).mediaId);
            }
            Set set = CollectionsKt.toSet(arrayList);
            ArrayList arrayList2 = new ArrayList();
            int currentMediaItemIndex = this.player.getCurrentMediaItemIndex();
            int mediaItemCount = this.player.getMediaItemCount();
            for (int i = 0; i < mediaItemCount; i++) {
                if (i != currentMediaItemIndex && set.contains(this.player.getMediaItemAt(i).mediaId)) {
                    arrayList2.add(Integer.valueOf(i));
                }
            }
            Iterator it2 = CollectionsKt.sortedWith(arrayList2, NaturalOrderComparator.INSTANCE$1).iterator();
            while (it2.hasNext()) {
                this.player.removeMediaItem(((Number) it2.next()).intValue());
            }
        }
        this.player.addMediaItems(list);
        ExoPlayerImpl exoPlayerImpl = this.player;
        exoPlayerImpl.verifyApplicationThread();
        if (exoPlayerImpl.shuffleModeEnabled) {
            applyShuffleOrder(this.player.getCurrentMediaItemIndex(), ((Boolean) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.ShufflePlaylistFirstKey, Boolean.FALSE)).booleanValue(), this.player.getMediaItemCount());
        }
        this.player.prepare();
    }

    public final void addToQueueAutomix(int i, MediaItem mediaItem) {
        mediaItem.getClass();
        StateFlowImpl stateFlowImpl = this.automixItems;
        ArrayList mutableList = CollectionsKt.toMutableList((Collection) stateFlowImpl.getValue());
        mutableList.remove(i);
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, mutableList);
        addToQueue(CollectionsKt__IterablesKt.listOf(mediaItem));
    }

    public final void applyAudioNormalization(VolumeNormalizationAudioProcessor volumeNormalizationAudioProcessor, String str, Double d, Double d2, boolean z) {
        Integer numValueOf = null;
        if (this.normalizationEnabledCached) {
            float f = this.loudnessLevelCached.targetLufs;
            if (d2 == null) {
                d2 = d != null ? Double.valueOf(d.doubleValue() - 7.0d) : null;
            }
            if (d2 != null) {
                numValueOf = Integer.valueOf(UuidKt.coerceIn((int) ((-(d2.doubleValue() - ((double) f))) * 100.0d), -1500, 300));
            }
        }
        if (numValueOf != null) {
            volumeNormalizationAudioProcessor.setTargetGain(numValueOf.intValue());
            volumeNormalizationAudioProcessor.setEnabled(true);
        } else {
            volumeNormalizationAudioProcessor.setTargetGain(0);
            volumeNormalizationAudioProcessor.setEnabled(false);
        }
        if (z) {
            this.cachedNormalizationMediaId = str;
            this.cachedNormalizationGainMb = numValueOf;
            this.cachedNormalizationEnabled = numValueOf != null;
        }
    }

    public final void applyCachedAudioNormalizationNow() {
        VolumeNormalizationAudioProcessor volumeNormalizationAudioProcessor;
        if (this.isCrossfading || (volumeNormalizationAudioProcessor = (VolumeNormalizationAudioProcessor) this.playerNormalizationProcessors.get(this.player)) == null) {
            return;
        }
        try {
            Integer num = this.cachedNormalizationGainMb;
            String str = this.cachedNormalizationMediaId;
            MediaItem currentMediaItem = this.player.getCurrentMediaItem();
            if (!Intrinsics.areEqual(str, currentMediaItem != null ? currentMediaItem.mediaId : null) || !this.cachedNormalizationEnabled || num == null) {
                volumeNormalizationAudioProcessor.setEnabled(false);
            } else {
                volumeNormalizationAudioProcessor.setTargetGain(num.intValue());
                volumeNormalizationAudioProcessor.setEnabled(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            volumeNormalizationAudioProcessor.setEnabled(false);
        }
    }

    public final void applyEffectiveVolume() {
        ExoPlayerImpl exoPlayerImpl = this.player;
        if (exoPlayerImpl == null || this.isCrossfading) {
            return;
        }
        float fFloatValue = ((Number) ((StateFlowImpl) getPlayerVolume()).getValue()).floatValue();
        boolean zBooleanValue = ((Boolean) this.isMuted.getValue()).booleanValue();
        float fFloatValue2 = ((Number) this.sleepTimerVolumeMultiplier.getValue()).floatValue();
        float fFloatValue3 = ((Number) this.audioFocusVolumeMultiplier.getValue()).floatValue();
        float fCoerceIn = CropImageView.DEFAULT_ASPECT_RATIO;
        if (!zBooleanValue) {
            fCoerceIn = UuidKt.coerceIn(fFloatValue * fFloatValue2 * fFloatValue3, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        }
        exoPlayerImpl.setVolume(fCoerceIn);
    }

    public final void applyShuffleOrder(int i, boolean z, int i2) {
        int i3;
        if (i2 == 0) {
            return;
        }
        int i4 = 0;
        if (!z || (i3 = this.originalQueueSize) <= 0 || i3 >= i2) {
            int[] iArr = new int[i2];
            for (int i5 = 0; i5 < i2; i5++) {
                iArr[i5] = i5;
            }
            AbstractPlatformRandom abstractPlatformRandom = Random.defaultRandom;
            for (int i6 = i2 - 1; i6 > 0; i6--) {
                int iNextInt = Random.defaultRandom.nextInt(i6 + 1);
                int i7 = iArr[i6];
                iArr[i6] = iArr[iNextInt];
                iArr[iNextInt] = i7;
            }
            int i8 = 0;
            while (true) {
                if (i8 >= i2) {
                    i8 = -1;
                    break;
                } else if (i == iArr[i8]) {
                    break;
                } else {
                    i8++;
                }
            }
            if (i8 != -1) {
                int i9 = iArr[0];
                iArr[0] = iArr[i8];
                iArr[i8] = i9;
            }
            this.player.setShuffleOrder(new ShuffleOrder$DefaultShuffleOrder(iArr, System.currentTimeMillis()));
            return;
        }
        IntRange intRangeUntil = UuidKt.until(0, i3);
        ArrayList arrayList = new ArrayList();
        Iterator it = intRangeUntil.iterator();
        while (((IntProgressionIterator) it).hasNext) {
            Object next = ((IntIterator) it).next();
            if (((Number) next).intValue() != i) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        IntRange intRangeUntil2 = UuidKt.until(this.originalQueueSize, i2);
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = intRangeUntil2.iterator();
        while (((IntProgressionIterator) it2).hasNext) {
            Object next2 = ((IntIterator) it2).next();
            if (((Number) next2).intValue() != i) {
                arrayList3.add(next2);
            }
        }
        ArrayList arrayList4 = new ArrayList(arrayList3);
        Collections.shuffle(arrayList2);
        Collections.shuffle(arrayList4);
        int[] iArr2 = new int[i2];
        iArr2[0] = i;
        int i10 = this.originalQueueSize;
        int i11 = 1;
        if (i < i10) {
            int size = arrayList2.size();
            int i12 = 0;
            while (i12 < size) {
                Object obj = arrayList2.get(i12);
                i12++;
                iArr2[i11] = ((Number) obj).intValue();
                i11++;
            }
            int size2 = arrayList4.size();
            while (i4 < size2) {
                Object obj2 = arrayList4.get(i4);
                i4++;
                iArr2[i11] = ((Number) obj2).intValue();
                i11++;
            }
        } else {
            ArrayList arrayList5 = (ArrayList) CollectionsKt__IterablesKt.shuffled(UuidKt.until(0, i10));
            int size3 = arrayList5.size();
            int i13 = 0;
            while (i13 < size3) {
                Object obj3 = arrayList5.get(i13);
                i13++;
                iArr2[i11] = ((Number) obj3).intValue();
                i11++;
            }
            int size4 = arrayList4.size();
            while (i4 < size4) {
                Object obj4 = arrayList4.get(i4);
                i4++;
                iArr2[i11] = ((Number) obj4).intValue();
                i11++;
            }
        }
        this.player.setShuffleOrder(new ShuffleOrder$DefaultShuffleOrder(iArr2, System.currentTimeMillis()));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:117:0x0289  */
    /* JADX WARN: Code duplicated, block: B:120:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:123:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:125:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:128:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:129:0x02be  */
    /* JADX WARN: Code duplicated, block: B:133:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:137:0x02db A[LOOP:3: B:135:0x02d5->B:137:0x02db, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:140:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:55:0x0125  */
    /* JADX WARN: Code duplicated, block: B:58:0x013e  */
    /* JADX WARN: Code duplicated, block: B:61:0x0147  */
    /* JADX WARN: Code duplicated, block: B:65:0x0150  */
    /* JADX WARN: Code duplicated, block: B:69:0x0164 A[LOOP:4: B:67:0x015e->B:69:0x0164, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00af, code lost:
    
        if (r2 == r7) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a3, code lost:
    
        if (r2 == r7) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x021c, code lost:
    
        if (r2 == r7) goto L119;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object buildPlaylistWidgetQueue(Intent intent, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        String stringExtra;
        String stringExtra2;
        List list;
        Object objFirst;
        List list2;
        Playlist playlist;
        String str;
        ArrayList arrayList;
        Iterator it;
        String str2;
        Playlist playlist2;
        String str3;
        Object objFirst2;
        Playlist playlist3;
        String str4;
        String str5;
        String str6;
        ArrayList arrayList2;
        Iterator it2;
        String str7;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object objFirst3 = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        List list3 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (i2) {
            case 0:
                ResultKt.throwOnFailure(objFirst3);
                String stringExtra3 = intent.getStringExtra("playlist_widget_target_type");
                if (stringExtra3 != null) {
                    stringExtra = intent.getStringExtra("playlist_widget_target_id");
                    if (stringExtra == null) {
                        stringExtra = "";
                    }
                    stringExtra2 = intent.getStringExtra("playlist_widget_target_title");
                    switch (stringExtra3.hashCode()) {
                        case -1012222381:
                            if (stringExtra3.equals("online") && !StringsKt.isBlank(stringExtra)) {
                                Flow flowPlaylistByBrowseId = getDatabase().$$delegate_0.playlistByBrowseId(stringExtra);
                                anonymousClass1.L$2 = stringExtra;
                                anonymousClass1.L$3 = stringExtra2;
                                anonymousClass1.label = 3;
                                objFirst3 = StateFlowKt.first(flowPlaylistByBrowseId, anonymousClass1);
                                if (objFirst3 != coroutineSingletons) {
                                    playlist2 = (Playlist) objFirst3;
                                    if (playlist2 != null) {
                                        Flow flowPlaylistSongs = getDatabase().playlistSongs(playlist2.playlist.id);
                                        anonymousClass1.L$2 = stringExtra;
                                        anonymousClass1.L$3 = stringExtra2;
                                        anonymousClass1.L$4 = playlist2;
                                        anonymousClass1.label = 4;
                                        objFirst2 = StateFlowKt.first(flowPlaylistSongs, anonymousClass1);
                                        if (objFirst2 != coroutineSingletons) {
                                            objFirst3 = objFirst2;
                                            playlist3 = playlist2;
                                            str4 = stringExtra;
                                            list3 = (List) objFirst3;
                                            playlist2 = playlist3;
                                            str3 = str4;
                                        }
                                    } else {
                                        str3 = stringExtra;
                                    }
                                    str5 = stringExtra2;
                                    if (list3 == null) {
                                        list3 = EmptyList.INSTANCE;
                                    }
                                    if (list3.isEmpty()) {
                                        return new YouTubePlaylistQueue(str3, str5, null, null, 0, null, 60, null);
                                    }
                                    if (playlist2 != null || (str7 = playlist2.playlist.name) == null) {
                                        str6 = str5;
                                    } else {
                                        str6 = str7;
                                    }
                                    arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
                                    it2 = list3.iterator();
                                    while (it2.hasNext()) {
                                        arrayList2.add(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(((PlaylistSong) it2.next()).song)));
                                    }
                                    return new ListQueue(str6, arrayList2, 0, 0L, 12, null);
                                }
                                return coroutineSingletons;
                            }
                            break;
                        case 115029:
                            if (stringExtra3.equals("top")) {
                                Integer intOrNull = StringsKt__StringsJVMKt.toIntOrNull(10, stringExtra);
                                int iIntValue = intOrNull != null ? intOrNull.intValue() : 50;
                                MusicDatabase database = getDatabase();
                                LocalDateTime localDateTimeOf = LocalDateTime.of(1970, 1, 1, 0, 0);
                                localDateTimeOf.getClass();
                                Flow flowMostPlayedSongs$default = DatabaseDao.mostPlayedSongs$default(database, localDateTimeOf, iIntValue, null, 12);
                                anonymousClass1.L$2 = null;
                                anonymousClass1.L$3 = null;
                                anonymousClass1.label = 7;
                                objFirst3 = StateFlowKt.first(flowMostPlayedSongs$default, anonymousClass1);
                            }
                            break;
                        case 102974381:
                            if (stringExtra3.equals("liked")) {
                                Flow flowLikedSongsByCreateDateAsc = getDatabase().$$delegate_0.likedSongsByCreateDateAsc();
                                anonymousClass1.L$2 = null;
                                anonymousClass1.L$3 = null;
                                anonymousClass1.label = 5;
                                objFirst3 = StateFlowKt.first(flowLikedSongsByCreateDateAsc, anonymousClass1);
                            }
                            break;
                        case 103145323:
                            if (stringExtra3.equals("local") && !StringsKt.isBlank(stringExtra)) {
                                Flow flowPlaylistSongs2 = getDatabase().$$delegate_0.playlistSongs(stringExtra);
                                anonymousClass1.L$2 = stringExtra;
                                anonymousClass1.L$3 = stringExtra2;
                                anonymousClass1.label = 1;
                                objFirst3 = StateFlowKt.first(flowPlaylistSongs2, anonymousClass1);
                                if (objFirst3 != coroutineSingletons) {
                                    list = (List) objFirst3;
                                    if (!list.isEmpty()) {
                                        Flow flowPlaylist = getDatabase().playlist(stringExtra);
                                        anonymousClass1.L$2 = null;
                                        anonymousClass1.L$3 = stringExtra2;
                                        anonymousClass1.L$4 = list;
                                        anonymousClass1.label = 2;
                                        objFirst = StateFlowKt.first(flowPlaylist, anonymousClass1);
                                        if (objFirst != coroutineSingletons) {
                                            objFirst3 = objFirst;
                                            list2 = list;
                                            playlist = (Playlist) objFirst3;
                                            if (playlist != null || (str2 = playlist.playlist.name) == null) {
                                                str = stringExtra2;
                                            } else {
                                                str = str2;
                                            }
                                            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                                            it = list2.iterator();
                                            while (it.hasNext()) {
                                                arrayList.add(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(((PlaylistSong) it.next()).song)));
                                            }
                                            return new ListQueue(str, arrayList, 0, 0L, 12, null);
                                        }
                                    }
                                }
                                return coroutineSingletons;
                            }
                            break;
                        case 2039141159:
                            if (stringExtra3.equals("downloaded")) {
                                Flow flowDownloadedSongsByCreateDateAsc = getDatabase().$$delegate_0.downloadedSongsByCreateDateAsc();
                                anonymousClass1.L$2 = null;
                                anonymousClass1.L$3 = null;
                                anonymousClass1.label = 6;
                                objFirst3 = StateFlowKt.first(flowDownloadedSongsByCreateDateAsc, anonymousClass1);
                            }
                            break;
                    }
                }
                return null;
            case 1:
                stringExtra2 = anonymousClass1.L$3;
                stringExtra = anonymousClass1.L$2;
                ResultKt.throwOnFailure(objFirst3);
                list = (List) objFirst3;
                if (!list.isEmpty()) {
                    Flow flowPlaylist2 = getDatabase().playlist(stringExtra);
                    anonymousClass1.L$2 = null;
                    anonymousClass1.L$3 = stringExtra2;
                    anonymousClass1.L$4 = list;
                    anonymousClass1.label = 2;
                    objFirst = StateFlowKt.first(flowPlaylist2, anonymousClass1);
                    if (objFirst != coroutineSingletons) {
                        objFirst3 = objFirst;
                        list2 = list;
                        playlist = (Playlist) objFirst3;
                        if (playlist != null) {
                            str = stringExtra2;
                        } else {
                            str = stringExtra2;
                        }
                        arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                        it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(((PlaylistSong) it.next()).song)));
                        }
                        return new ListQueue(str, arrayList, 0, 0L, 12, null);
                    }
                    return coroutineSingletons;
                }
                return null;
            case 2:
                list2 = (List) anonymousClass1.L$4;
                stringExtra2 = anonymousClass1.L$3;
                ResultKt.throwOnFailure(objFirst3);
                playlist = (Playlist) objFirst3;
                if (playlist != null) {
                    str = stringExtra2;
                } else {
                    str = stringExtra2;
                }
                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(((PlaylistSong) it.next()).song)));
                }
                return new ListQueue(str, arrayList, 0, 0L, 12, null);
            case 3:
                stringExtra2 = anonymousClass1.L$3;
                stringExtra = anonymousClass1.L$2;
                ResultKt.throwOnFailure(objFirst3);
                playlist2 = (Playlist) objFirst3;
                if (playlist2 != null) {
                    Flow flowPlaylistSongs3 = getDatabase().playlistSongs(playlist2.playlist.id);
                    anonymousClass1.L$2 = stringExtra;
                    anonymousClass1.L$3 = stringExtra2;
                    anonymousClass1.L$4 = playlist2;
                    anonymousClass1.label = 4;
                    objFirst2 = StateFlowKt.first(flowPlaylistSongs3, anonymousClass1);
                    if (objFirst2 != coroutineSingletons) {
                        objFirst3 = objFirst2;
                        playlist3 = playlist2;
                        str4 = stringExtra;
                        list3 = (List) objFirst3;
                        playlist2 = playlist3;
                        str3 = str4;
                    }
                    return coroutineSingletons;
                }
                str3 = stringExtra;
                str5 = stringExtra2;
                if (list3 == null) {
                    list3 = EmptyList.INSTANCE;
                }
                if (list3.isEmpty()) {
                    return new YouTubePlaylistQueue(str3, str5, null, null, 0, null, 60, null);
                }
                if (playlist2 != null) {
                    str6 = str5;
                } else {
                    str6 = str5;
                }
                arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
                it2 = list3.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(((PlaylistSong) it2.next()).song)));
                }
                return new ListQueue(str6, arrayList2, 0, 0L, 12, null);
            case 4:
                playlist3 = (Playlist) anonymousClass1.L$4;
                stringExtra2 = anonymousClass1.L$3;
                str4 = anonymousClass1.L$2;
                ResultKt.throwOnFailure(objFirst3);
                list3 = (List) objFirst3;
                playlist2 = playlist3;
                str3 = str4;
                str5 = stringExtra2;
                if (list3 == null) {
                    list3 = EmptyList.INSTANCE;
                }
                if (list3.isEmpty()) {
                    return new YouTubePlaylistQueue(str3, str5, null, null, 0, null, 60, null);
                }
                if (playlist2 != null) {
                    str6 = str5;
                } else {
                    str6 = str5;
                }
                arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
                it2 = list3.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(((PlaylistSong) it2.next()).song)));
                }
                return new ListQueue(str6, arrayList2, 0, 0L, 12, null);
            case 5:
                ResultKt.throwOnFailure(objFirst3);
                List list4 = (List) objFirst3;
                if (!list4.isEmpty()) {
                    String string = getString(R.string.liked_songs);
                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                    Iterator it3 = list4.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(UuidKt.toMediaItem((Song) it3.next()));
                    }
                    return new ListQueue(string, arrayList3, 0, 0L, 12, null);
                }
                return null;
            case 6:
                ResultKt.throwOnFailure(objFirst3);
                List list5 = (List) objFirst3;
                if (!list5.isEmpty()) {
                    String string2 = getString(R.string.downloaded_songs);
                    ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10));
                    Iterator it4 = list5.iterator();
                    while (it4.hasNext()) {
                        arrayList4.add(UuidKt.toMediaItem((Song) it4.next()));
                    }
                    return new ListQueue(string2, arrayList4, 0, 0L, 12, null);
                }
                return null;
            case 7:
                ResultKt.throwOnFailure(objFirst3);
                List list6 = (List) objFirst3;
                if (!list6.isEmpty()) {
                    String string3 = getString(R.string.my_top);
                    ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10));
                    Iterator it5 = list6.iterator();
                    while (it5.hasNext()) {
                        arrayList5.add(UuidKt.toMediaItem((Song) it5.next()));
                    }
                    return new ListQueue(string3, arrayList5, 0, 0L, 12, null);
                }
                return null;
            default:
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    public final void clearPersistedQueueFiles() {
        try {
            File filesDir = getFilesDir();
            filesDir.getClass();
            FilesKt.resolve(filesDir, "persistent_queue.data").delete();
        } catch (Throwable unused) {
        }
        try {
            File filesDir2 = getFilesDir();
            filesDir2.getClass();
            FilesKt.resolve(filesDir2, "persistent_automix.data").delete();
        } catch (Throwable unused2) {
        }
        try {
            File filesDir3 = getFilesDir();
            filesDir3.getClass();
            FilesKt.resolve(filesDir3, "persistent_player_state.data").delete();
        } catch (Throwable unused3) {
        }
        this.lastSavedPlayerState = null;
    }

    public final void closeAudioEffectSession(Integer num) {
        int i;
        int iIntValue = num != null ? num.intValue() : this.openedAudioEffectSessionId;
        this.loudnessSetupGeneration++;
        StandaloneCoroutine standaloneCoroutine = this.loudnessSetupJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.loudnessSetupJob = null;
        if (this.isAudioEffectSessionOpened && (i = this.openedAudioEffectSessionId) != 0 && iIntValue == i) {
            this.isAudioEffectSessionOpened = false;
            this.openedAudioEffectSessionId = 0;
        }
        if (iIntValue == 0 || iIntValue <= 0) {
            return;
        }
        Intent intent = new Intent("android.media.action.CLOSE_AUDIO_EFFECT_CONTROL_SESSION");
        intent.putExtra("android.media.extra.AUDIO_SESSION", iIntValue);
        intent.putExtra("android.media.extra.PACKAGE_NAME", getPackageName());
        sendBroadcast(intent);
    }

    public final ExoPlayerImpl createExoPlayer(MutablePreferences mutablePreferences) throws Throwable {
        boolean zBooleanValue;
        Continuation continuation;
        final VolumeNormalizationAudioProcessor volumeNormalizationAudioProcessor = new VolumeNormalizationAudioProcessor();
        volumeNormalizationAudioProcessor.currentGain = new VolumeNormalizationAudioProcessor.GainState(0, 1.0d);
        final CustomEqualizerAudioProcessor customEqualizerAudioProcessor = new CustomEqualizerAudioProcessor();
        customEqualizerAudioProcessor.filters = EmptyList.INSTANCE;
        customEqualizerAudioProcessor.preampGain = 1.0d;
        final SilenceDetectorAudioProcessor silenceDetectorAudioProcessor = new SilenceDetectorAudioProcessor(new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 7, this));
        Continuation continuation2 = null;
        byte b = 1;
        if (mutablePreferences != null) {
            Boolean bool = (Boolean) mutablePreferences.get(PreferenceKeysKt.SkipSilenceKey);
            boolean zBooleanValue2 = bool != null ? bool.booleanValue() : false;
            Boolean bool2 = (Boolean) mutablePreferences.get(PreferenceKeysKt.SkipSilenceInstantKey);
            silenceDetectorAudioProcessor.instantModeEnabled = zBooleanValue2 && (bool2 != null ? bool2.booleanValue() : false);
            Boolean bool3 = (Boolean) mutablePreferences.get(PreferenceKeysKt.AudioTrackPlaybackParamsKey);
            zBooleanValue = bool3 != null ? bool3.booleanValue() : true;
        } else {
            zBooleanValue = ((Boolean) AwaitKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new DownloadUtil.AnonymousClass2(this, silenceDetectorAudioProcessor, continuation2, (byte) 18))).booleanValue();
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ExoPlayer$Builder exoPlayer$Builder = new ExoPlayer$Builder(this);
        RealWebSocket$$ExternalSyntheticLambda2 realWebSocket$$ExternalSyntheticLambda2 = new RealWebSocket$$ExternalSyntheticLambda2(ref$ObjectRef, b);
        CacheDataSource.Factory factory = new CacheDataSource.Factory();
        factory.cache = getDownloadCache();
        CacheDataSource.Factory factory2 = new CacheDataSource.Factory();
        factory2.cache = getPlayerCache();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.proxy(YouTube.innerTube.configuredProxy);
        final boolean z = zBooleanValue;
        builder.proxyAuthenticator(new PathKt$$ExternalSyntheticBUOutline0((byte) 16));
        factory2.upstreamDataSourceFactory = new WeakCache(this, new CallbackWrapper(new OkHttpClient(builder)));
        factory.upstreamDataSourceFactory = factory2;
        factory.cacheIsReadOnly = true;
        factory.flags = (byte) 2;
        DefaultMediaSourceFactory defaultMediaSourceFactory = new DefaultMediaSourceFactory(new WeakCache((Object) factory, (Object) new MediaSessionStub$$ExternalSyntheticLambda81(this, volumeNormalizationAudioProcessor, realWebSocket$$ExternalSyntheticLambda2, (byte) 5), (byte) 20), new PathKt$$ExternalSyntheticBUOutline0((byte) 15));
        coil3.util.UtilsKt.checkState(!exoPlayer$Builder.buildCalled);
        exoPlayer$Builder.mediaSourceFactorySupplier = new ExoPlayer$Builder$$ExternalSyntheticLambda0((byte) 1, defaultMediaSourceFactory);
        DefaultRenderersFactory defaultRenderersFactory = new DefaultRenderersFactory() { // from class: com.metrolist.music.playback.MusicService$createRenderersFactory$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(this.this$0);
            }

            @Override // androidx.media3.exoplayer.DefaultRenderersFactory
            public final void buildAudioRenderers(Context context, AudioSink audioSink, Handler handler, ExoPlayerImpl.ComponentListener componentListener, ArrayList arrayList) {
                context.getClass();
                super.buildAudioRenderers(context, audioSink, handler, componentListener, arrayList);
                int size = arrayList.size();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = -1;
                        break;
                    }
                    Object obj = arrayList.get(i3);
                    i3++;
                    if (((BaseRenderer) obj) instanceof MediaCodecAudioRenderer) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == -1) {
                    return;
                }
                arrayList.set(i2, new MusicService$createRenderersFactory$1$buildAudioRenderers$1(context, new NavContext(context, i), handler, componentListener, audioSink));
            }

            @Override // androidx.media3.exoplayer.DefaultRenderersFactory
            public final DefaultAudioSink buildAudioSink(Context context) {
                context.getClass();
                FileMetadata fileMetadata = new FileMetadata(this.this$0);
                fileMetadata.isRegularFile = z;
                fileMetadata.createdAtMillis = new EmojiProcessor(new BaseAudioProcessor[]{volumeNormalizationAudioProcessor, customEqualizerAudioProcessor, silenceDetectorAudioProcessor}, new SilenceSkippingAudioProcessor(2000000L, 0.01f, 0, (short) 256), new SonicAudioProcessor());
                return fileMetadata.build();
            }
        };
        coil3.util.UtilsKt.checkState(!exoPlayer$Builder.buildCalled);
        exoPlayer$Builder.renderersFactorySupplier = new ExoPlayer$Builder$$ExternalSyntheticLambda0((byte) 2, defaultRenderersFactory);
        HashMap map = new HashMap();
        map.put(PlayerId.PRELOAD.name, 144179200);
        DefaultLoadControl.assertGreaterOrEqual(750, 0, "bufferForPlaybackMs", "0");
        DefaultLoadControl.assertGreaterOrEqual(2000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        DefaultLoadControl.assertGreaterOrEqual(50000, 750, "minBufferMs", "bufferForPlaybackMs");
        DefaultLoadControl.assertGreaterOrEqual(50000, 2000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        DefaultLoadControl.assertGreaterOrEqual(50000, 50000, "maxBufferMs", "minBufferMs");
        DefaultLoadControl defaultLoadControl = new DefaultLoadControl(new GapBuffer((byte) 6), 50000, 750, 750, 2000, false, map);
        coil3.util.UtilsKt.checkState(!exoPlayer$Builder.buildCalled);
        exoPlayer$Builder.loadControlSupplier = new ExoPlayer$Builder$$ExternalSyntheticLambda0((byte) 0, defaultLoadControl);
        coil3.util.UtilsKt.checkState(!exoPlayer$Builder.buildCalled);
        exoPlayer$Builder.handleAudioBecomingNoisy = true;
        coil3.util.UtilsKt.checkState(!exoPlayer$Builder.buildCalled);
        exoPlayer$Builder.wakeMode = (byte) 2;
        exoPlayer$Builder.wakeModeSet = true;
        AudioAttributes audioAttributes = new AudioAttributes(2, 0, 1, 1, 0, false, true);
        coil3.util.UtilsKt.checkState(!exoPlayer$Builder.buildCalled);
        exoPlayer$Builder.audioAttributes = audioAttributes;
        coil3.util.UtilsKt.checkState(!exoPlayer$Builder.buildCalled);
        coil3.util.UtilsKt.checkState(!exoPlayer$Builder.buildCalled);
        exoPlayer$Builder.seekForwardIncrementMs = (short) 5000;
        coil3.util.UtilsKt.checkState(!exoPlayer$Builder.buildCalled);
        exoPlayer$Builder.deviceVolumeControlEnabled = true;
        coil3.util.UtilsKt.checkState(!exoPlayer$Builder.buildCalled);
        exoPlayer$Builder.buildCalled = true;
        ExoPlayerImpl exoPlayerImpl = new ExoPlayerImpl(exoPlayer$Builder);
        ref$ObjectRef.element = exoPlayerImpl;
        this.playerNormalizationProcessors.put(exoPlayerImpl, volumeNormalizationAudioProcessor);
        this.playerSilenceProcessors.put(exoPlayerImpl, silenceDetectorAudioProcessor);
        this.playerEqualizerProcessors.put(exoPlayerImpl, customEqualizerAudioProcessor);
        EqualizerService equalizerService = this.equalizerService;
        if (equalizerService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("equalizerService");
            throw null;
        }
        ArrayList arrayList = equalizerService.audioProcessors;
        arrayList.add(customEqualizerAudioProcessor);
        Timber.Forest.tag("EqualizerService");
        arrayList.size();
        ConnectionPool.d(new Object[0]);
        if (equalizerService.shouldDisable) {
            customEqualizerAudioProcessor.disable();
        } else {
            SavedEQProfile savedEQProfile = equalizerService.pendingProfile;
            if (savedEQProfile != null) {
                EqualizerService.applyProfileToProcessor(customEqualizerAudioProcessor, savedEQProfile);
            }
        }
        if (mutablePreferences != null) {
            Boolean bool4 = (Boolean) mutablePreferences.get(PreferenceKeysKt.AudioOffload);
            boolean zBooleanValue3 = bool4 != null ? bool4.booleanValue() : false;
            Boolean bool5 = (Boolean) mutablePreferences.get(PreferenceKeysKt.CrossfadeEnabledKey);
            if (bool5 != null ? bool5.booleanValue() : false) {
                zBooleanValue3 = false;
            }
            IntMath.setOffloadEnabled(exoPlayerImpl, zBooleanValue3);
            Boolean bool6 = (Boolean) mutablePreferences.get(PreferenceKeysKt.SkipSilenceKey);
            exoPlayerImpl.setSkipSilenceEnabled(bool6 != null ? bool6.booleanValue() : false);
            continuation = null;
        } else {
            continuation = null;
            AwaitKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new DownloadUtil.AnonymousClass2(this, exoPlayerImpl, continuation, (byte) 17));
        }
        PlaybackStatsListener playbackStatsListener = new PlaybackStatsListener(this);
        DefaultAnalyticsCollector defaultAnalyticsCollector = exoPlayerImpl.analyticsCollector;
        defaultAnalyticsCollector.getClass();
        defaultAnalyticsCollector.listeners.add(playbackStatsListener);
        StateFlowImpl stateFlowImpl = this._playerFlow;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(continuation, exoPlayerImpl);
        return exoPlayerImpl;
    }

    public final Notification createFallbackForegroundNotification() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(new NotificationChannel("music_channel_01", getString(R.string.music_player), 2));
        }
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) MainActivity.class), 67108864);
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this, "music_channel_01");
        notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(getString(R.string.music_player));
        notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength("");
        notificationCompat$Builder.mNotification.icon = R.drawable.small_icon;
        notificationCompat$Builder.mContentIntent = activity;
        notificationCompat$Builder.setFlag(2, true);
        Notification notificationBuild = notificationCompat$Builder.build();
        notificationBuild.getClass();
        return notificationBuild;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0124, code lost:
    
        if (r1 == r12) goto L62;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchArtistThumbnail(Song song, ContinuationImpl continuationImpl) {
        C01661 c01661;
        MusicService musicService;
        ArtistEntity artistEntity;
        Song song2;
        Song song3;
        ArtistEntity artistEntity2;
        String str;
        ArtistEntity artistEntity3 = song;
        if (continuationImpl instanceof C01661) {
            c01661 = (C01661) continuationImpl;
            int i = c01661.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01661.label = i - Integer.MIN_VALUE;
                musicService = this;
            } else {
                musicService = this;
                c01661 = musicService.new C01661(continuationImpl);
            }
        } else {
            musicService = this;
            c01661 = musicService.new C01661(continuationImpl);
        }
        Object songById = c01661.result;
        int i2 = c01661.label;
        byte b = 1;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 != 0) {
                    if (i2 == 1) {
                        ArtistEntity artistEntity4 = c01661.L$1;
                        Song song4 = c01661.L$0;
                        ResultKt.throwOnFailure(songById);
                        artistEntity = artistEntity4;
                        song2 = song4;
                    } else if (i2 == 2) {
                        ArtistEntity artistEntity5 = c01661.L$1;
                        Song song5 = c01661.L$0;
                        ResultKt.throwOnFailure(songById);
                        artistEntity2 = artistEntity5;
                        song3 = song5;
                        MusicDatabase database = getDatabase();
                        String str2 = song3.song.id;
                        c01661.L$0 = null;
                        c01661.L$1 = artistEntity2;
                        c01661.label = 3;
                        songById = database.$$delegate_0.getSongById(str2, c01661);
                        artistEntity3 = artistEntity2;
                    } else {
                        if (i2 != 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ArtistEntity artistEntity6 = c01661.L$1;
                        ResultKt.throwOnFailure(songById);
                        artistEntity3 = artistEntity6;
                    }
                    return (Song) songById;
                }
                ResultKt.throwOnFailure(songById);
                ArtistEntity artistEntity7 = (ArtistEntity) CollectionsKt.firstOrNull(artistEntity3.artists);
                if (artistEntity7 == null) {
                    Timber.Forest.tag("DiscordSvc");
                    ConnectionPool.d(new Object[0]);
                    return null;
                }
                String str3 = artistEntity7.name;
                String str4 = artistEntity7.id;
                String str5 = artistEntity7.channelId;
                if (artistEntity7.thumbnailUrl != null) {
                    Timber.Forest.tag("DiscordSvc");
                    ConnectionPool.d(new Object[0]);
                    return null;
                }
                if (str5 != null && !StringsKt__StringsJVMKt.startsWith(str5, "LA", false) && !StringsKt__StringsJVMKt.startsWith(str5, "FEmusic_library_privately_owned", false)) {
                    str4 = str5;
                } else if (StringsKt__StringsJVMKt.startsWith(str4, "LA", false) || StringsKt__StringsJVMKt.startsWith(str4, "FEmusic_library_privately_owned", false)) {
                    Timber.Forest.tag("DiscordSvc");
                    ConnectionPool.d(str3);
                    return null;
                }
                Timber.Forest.tag("DiscordSvc");
                ConnectionPool.d(str3, str4);
                try {
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                    LocalPlaylistViewModel$2$page$1 localPlaylistViewModel$2$page$1 = new LocalPlaylistViewModel$2$page$1(str4, continuation, b);
                    c01661.L$0 = artistEntity3;
                    c01661.L$1 = artistEntity7;
                    c01661.label = 1;
                    Object objWithContext = AwaitKt.withContext(defaultIoScheduler, localPlaylistViewModel$2$page$1, c01661);
                    if (objWithContext != coroutineSingletons) {
                        artistEntity = artistEntity7;
                        songById = objWithContext;
                        song2 = artistEntity3;
                    }
                    return coroutineSingletons;
                } catch (Exception unused) {
                    artistEntity3 = artistEntity7;
                    Timber.Forest.tag("DiscordSvc");
                    ConnectionPool.w$1(artistEntity3.name);
                    return null;
                }
                ArtistPage artistPage = (ArtistPage) songById;
                String strResize = (artistPage == null || (str = artistPage.artist.thumbnail) == null) ? null : YouTubeUtilsKt.resize(str, new Integer(1080), new Integer(1080));
                if (strResize == null) {
                    Timber.Forest.tag("DiscordSvc");
                    ConnectionPool.d(artistEntity.name);
                    return null;
                }
                Timber.Forest.tag("DiscordSvc");
                ConnectionPool.d(artistEntity.name);
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                DefaultIoScheduler defaultIoScheduler2 = DefaultIoScheduler.INSTANCE;
                SyncUtils$createPlaylist$1.AnonymousClass1 anonymousClass1 = new SyncUtils$createPlaylist$1.AnonymousClass1((Object) musicService, (Object) artistEntity, (Object) strResize, continuation, (byte) 7);
                c01661.L$0 = song2;
                c01661.L$1 = artistEntity;
                c01661.label = 2;
                if (AwaitKt.withContext(defaultIoScheduler2, anonymousClass1, c01661) != coroutineSingletons) {
                    song3 = song2;
                    artistEntity2 = artistEntity;
                    MusicDatabase database2 = getDatabase();
                    String str6 = song3.song.id;
                    c01661.L$0 = null;
                    c01661.L$1 = artistEntity2;
                    c01661.label = 3;
                    songById = database2.$$delegate_0.getSongById(str6, c01661);
                    artistEntity3 = artistEntity2;
                }
                return coroutineSingletons;
            } catch (Exception unused2) {
                artistEntity3 = artistEntity;
                Timber.Forest.tag("DiscordSvc");
                ConnectionPool.w$1(artistEntity3.name);
                return null;
            }
        } catch (Exception unused3) {
        }
    }

    public final void getAutomix(String str) {
        str.getClass();
        if (((Boolean) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.SimilarContent, Boolean.TRUE)).booleanValue()) {
            if (((Boolean) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.DisableLoadMoreWhenRepeatAllKey, Boolean.FALSE)).booleanValue()) {
                ExoPlayerImpl exoPlayerImpl = this.player;
                exoPlayerImpl.verifyApplicationThread();
                if (exoPlayerImpl.repeatMode == 2) {
                    return;
                }
            }
            AwaitKt.launch$default(this.scope, CoroutineExtKt.SilentHandler, null, new C01671(str, this, null), 2);
        }
    }

    public final MusicDatabase getDatabase() {
        MusicDatabase musicDatabase = this.database;
        if (musicDatabase != null) {
            return musicDatabase;
        }
        Intrinsics.throwUninitializedPropertyAccessException("database");
        throw null;
    }

    public final SimpleCache getDownloadCache() {
        SimpleCache simpleCache = this.downloadCache;
        if (simpleCache != null) {
            return simpleCache;
        }
        Intrinsics.throwUninitializedPropertyAccessException("downloadCache");
        throw null;
    }

    public final SimpleCache getPlayerCache() {
        SimpleCache simpleCache = this.playerCache;
        if (simpleCache != null) {
            return simpleCache;
        }
        Intrinsics.throwUninitializedPropertyAccessException("playerCache");
        throw null;
    }

    public final MutableStateFlow getPlayerVolume() {
        StateFlowImpl stateFlowImpl = this.playerVolume;
        if (stateFlowImpl != null) {
            return stateFlowImpl;
        }
        Intrinsics.throwUninitializedPropertyAccessException("playerVolume");
        throw null;
    }

    public final void handleFinalFailure() {
        boolean zBooleanValue = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.AutoSkipNextOnErrorKey, Boolean.FALSE)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.AutoplayKey, Boolean.TRUE)).booleanValue();
        boolean zHasNextMediaItem = this.player.hasNextMediaItem();
        if (zBooleanValue || (zBooleanValue2 && zHasNextMediaItem)) {
            Timber.Forest.tag("MusicService");
            ConnectionPool.d(new Object[0]);
            skipOnError();
        } else {
            Timber.Forest.tag("MusicService");
            ConnectionPool.d(new Object[0]);
            this.player.setPlayWhenReady(false);
        }
    }

    public final void handleForegroundServiceStartNotAllowed(IllegalStateException illegalStateException) {
        ConnectionPool connectionPool;
        Object failure;
        if (illegalStateException != null) {
            connectionPool = Timber.Forest;
            connectionPool.tag("MusicService");
            ConnectionPool.w$1(new Object[0]);
        } else {
            connectionPool = Timber.Forest;
            connectionPool.tag("MusicService");
            ConnectionPool.w(new Object[0]);
        }
        Notification notificationCreateFallbackForegroundNotification = this.latestMediaNotification;
        if (notificationCreateFallbackForegroundNotification == null) {
            notificationCreateFallbackForegroundNotification = createFallbackForegroundNotification();
        }
        if (startForegroundSafely(notificationCreateFallbackForegroundNotification, false)) {
            return;
        }
        ExoPlayerImpl exoPlayerImpl = this.player;
        if (exoPlayerImpl == null) {
            stopSelf();
            return;
        }
        if (exoPlayerImpl.isPlaying()) {
            connectionPool.tag("MusicService");
            ConnectionPool.w(new Object[0]);
            return;
        }
        try {
            pauseAllPlayersAndStopSelf();
            failure = Unit.INSTANCE;
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (Result.m1866exceptionOrNullimpl(failure) != null) {
            Timber.Forest.tag("MusicService");
            ConnectionPool.w$1(new Object[0]);
            stopSelf();
        }
    }

    public final void incrementRetryCount(String str) {
        LinkedHashMap linkedHashMap = this.currentMediaIdRetryCount;
        Integer num = (Integer) linkedHashMap.get(str);
        linkedHashMap.put(str, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
        Timber.Forest.tag("MusicService");
        ConnectionPool.d(new Object[0]);
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00c4 A[PHI: r14
      0x00c4: PHI (r14v4 com.metrolist.music.db.entities.Song) = (r14v3 com.metrolist.music.db.entities.Song), (r14v5 com.metrolist.music.db.entities.Song) binds: [B:38:0x00a2, B:44:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object markCachedIfFullyDownloaded(String str, ContinuationImpl continuationImpl) {
        C01681 c01681;
        Song song;
        long jLongValue;
        long j;
        String str2;
        if (continuationImpl instanceof C01681) {
            c01681 = (C01681) continuationImpl;
            int i = c01681.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01681.label = i - Integer.MIN_VALUE;
            } else {
                c01681 = new C01681(continuationImpl);
            }
        } else {
            c01681 = new C01681(continuationImpl);
        }
        Object objFirst = c01681.result;
        int i2 = c01681.label;
        byte b = 1;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFirst);
            Flow flowSong = getDatabase().$$delegate_0.song(str);
            c01681.L$0 = str;
            c01681.label = 1;
            objFirst = StateFlowKt.first(flowSong, c01681);
            if (objFirst != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            str = c01681.L$0;
            ResultKt.throwOnFailure(objFirst);
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            long j2 = c01681.J$0;
            song = c01681.L$1;
            String str3 = c01681.L$0;
            ResultKt.throwOnFailure(objFirst);
            str2 = str3;
            j = j2;
        }
        if (getPlayerCache().isCached(0L, j, str2)) {
            getDatabase().query(new SongMenuKt$$ExternalSyntheticLambda75(song, b));
        }
        return unit;
        String str4 = str;
        song = (Song) objFirst;
        if (song != null) {
            SongEntity songEntity = song.song;
            if (songEntity.dateDownload == null && !songEntity.isDownloaded) {
                FormatEntity formatEntity = song.format;
                if (formatEntity != null) {
                    jLongValue = formatEntity.contentLength;
                } else {
                    Long l = new Long(ContentMetadata.getContentLength(getPlayerCache().getContentMetadata(str4)));
                    Long l2 = l.longValue() > 0 ? l : null;
                    if (l2 != null) {
                        jLongValue = l2.longValue();
                    }
                }
                long j3 = jLongValue;
                if (!getPlayerCache().isCached(0L, j3, str4)) {
                    c01681.L$0 = str4;
                    c01681.L$1 = song;
                    c01681.J$0 = j3;
                    c01681.label = 2;
                    if (AwaitKt.delay(1000L, c01681) != coroutineSingletons) {
                        j = j3;
                        str2 = str4;
                        if (getPlayerCache().isCached(0L, j, str2)) {
                            getDatabase().query(new SongMenuKt$$ExternalSyntheticLambda75(song, b));
                        }
                    }
                    return coroutineSingletons;
                }
                getDatabase().query(new SongMenuKt$$ExternalSyntheticLambda75(song, b));
            }
        }
        return unit;
    }

    public final void markSongAsFailed(String str) {
        this.recentlyFailedSongs.add(str);
        this.currentMediaIdRetryCount.remove(str);
        StandaloneCoroutine standaloneCoroutine = this.failedSongsClearJob;
        Continuation continuation = null;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.failedSongsClearJob = AwaitKt.launch$default(this.scope, null, null, new AnonymousClass2((byte) 2, this, continuation), 3);
    }

    @Override // androidx.media3.session.MediaLibraryService, androidx.media3.session.MediaSessionService, androidx.lifecycle.LifecycleService, android.app.Service
    public final IBinder onBind(Intent intent) {
        IBinder iBinderOnBind = super.onBind(intent);
        if (iBinderOnBind != null) {
            return iBinderOnBind;
        }
        this.taskCleared = false;
        return this.binder;
    }

    /* JADX WARN: Code duplicated, block: B:83:0x03e8  */
    @Override // com.metrolist.music.playback.Hilt_MusicService, androidx.media3.session.MediaSessionService, androidx.lifecycle.LifecycleService, android.app.Service
    public final void onCreate() throws Throwable {
        BitmapLoader dataSourceBitmapLoader;
        byte b;
        AudioQuality audioQuality;
        Object failure;
        Object failure2;
        Object failure3;
        Object failure4;
        Object failure5;
        Object next;
        super.onCreate();
        isRunning = true;
        shutdownDeferred = AwaitKt.CompletableDeferred$default();
        ConnectionPool connectionPool = new ConnectionPool(this);
        synchronized (this.lock) {
            this.listener = connectionPool;
        }
        StateFlowImpl stateFlowImpl = this.playerInitialized;
        Boolean bool = Boolean.FALSE;
        stateFlowImpl.getClass();
        Continuation continuation = null;
        stateFlowImpl.updateState(null, bool);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(new NotificationChannel("music_channel_01", getString(R.string.music_player), 2));
        }
        if (startForegroundSafely(createFallbackForegroundNotification(), true)) {
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            byte b2 = 0;
            this.startupPrefs = (MutablePreferences) AwaitKt.runBlockingK(DefaultIoScheduler.INSTANCE, new AnonymousClass2(b2, this, continuation));
            MutablePreferences mutablePreferences = this.startupPrefs;
            mutablePreferences.getClass();
            Boolean bool2 = (Boolean) mutablePreferences.get(PreferenceKeysKt.AudioNormalizationKey);
            this.normalizationEnabledCached = bool2 != null ? bool2.booleanValue() : true;
            String str = (String) mutablePreferences.get(PreferenceKeysKt.LoudnessLevelKey);
            LoudnessLevel loudnessLevelValueOf = LoudnessLevel.BALANCED;
            if (str != null) {
                try {
                    loudnessLevelValueOf = LoudnessLevel.valueOf(str);
                } catch (IllegalArgumentException unused) {
                }
            }
            this.loudnessLevelCached = loudnessLevelValueOf;
            ConnectionPool connectionPool2 = Timber.Forest;
            connectionPool2.tag("MusicService");
            Objects.toString(this.loudnessLevelCached);
            ConnectionPool.d(new Object[0]);
            byte b3 = 17;
            DefaultMediaNotificationProvider defaultMediaNotificationProvider = new DefaultMediaNotificationProvider(this, new PathKt$$ExternalSyntheticBUOutline0(b3), "music_channel_01", R.string.music_player);
            defaultMediaNotificationProvider.smallIconResourceId = R.drawable.small_icon;
            Util.postOrRun(this.mainHandler, new TransactionExecutor$$ExternalSyntheticLambda0((Object) this, (Object) new FileLock(defaultMediaNotificationProvider, this), (byte) 14));
            MutablePreferences mutablePreferences2 = this.startupPrefs;
            mutablePreferences2.getClass();
            ExoPlayerImpl exoPlayerImplCreateExoPlayer = createExoPlayer(mutablePreferences2);
            this.player = exoPlayerImplCreateExoPlayer;
            exoPlayerImplCreateExoPlayer.listeners.add(this);
            SleepTimer sleepTimer = new SleepTimer(this.scope, this.player, new DiskLruCache$$ExternalSyntheticLambda0((byte) 23, this));
            this.sleepTimer = sleepTimer;
            this.player.listeners.add(sleepTimer);
            StateFlowImpl stateFlowImpl2 = this.playerInitialized;
            Boolean bool3 = Boolean.TRUE;
            stateFlowImpl2.getClass();
            stateFlowImpl2.updateState(null, bool3);
            connectionPool2.tag("MusicService");
            ConnectionPool.d(new Object[0]);
            Object systemService = getSystemService(ContentType.Audio.TYPE);
            systemService.getClass();
            this.audioManager = (AudioManager) systemService;
            this.audioFocusRequest = new AudioFocusRequest.Builder(1).setAudioAttributes(new android.media.AudioAttributes.Builder().setUsage(1).setContentType(2).build()).setOnAudioFocusChangeListener(new MusicService$$ExternalSyntheticLambda6(b2, this)).setAcceptsDelayedFocusGain(true).build();
            MediaLibrarySessionCallback mediaLibrarySessionCallback = this.mediaLibrarySessionCallback;
            if (mediaLibrarySessionCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaLibrarySessionCallback");
                throw null;
            }
            mediaLibrarySessionCallback.service = this;
            Class<MusicService> cls = MusicService.class;
            int i = 0;
            int i2 = 0;
            mediaLibrarySessionCallback.toggleLike = new RoomDatabase$closeBarrier$1(i2, this, cls, "toggleLike", "toggleLike()V", i, (byte) 6);
            mediaLibrarySessionCallback.toggleStartRadio = new RoomDatabase$closeBarrier$1(i2, this, cls, "toggleStartRadio", "toggleStartRadio()V", i, (byte) 7);
            mediaLibrarySessionCallback.toggleLibrary = new RoomDatabase$closeBarrier$1(i2, this, cls, "toggleLibrary", "toggleLibrary()V", i, (byte) 8);
            mediaLibrarySessionCallback.addToTargetPlaylist = new RoomDatabase$closeBarrier$1(i2, this, cls, "addToTargetPlaylist", "addToTargetPlaylist()V", i, (byte) 9);
            ExoPlayerImpl exoPlayerImpl = this.player;
            MediaLibrarySessionCallback mediaLibrarySessionCallback2 = this.mediaLibrarySessionCallback;
            if (mediaLibrarySessionCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaLibrarySessionCallback");
                throw null;
            }
            MediaLibraryService.MediaLibrarySession.Builder builder = new MediaLibraryService.MediaLibrarySession.Builder(this, exoPlayerImpl, mediaLibrarySessionCallback2);
            PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) MainActivity.class), 67108864);
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 31) {
                coil3.util.UtilsKt.checkArgument(DisplayCompat.isActivity(activity));
            }
            activity.getClass();
            builder.sessionActivity = activity;
            builder.bitmapLoader = new Splitter(this, this.scope);
            coil3.util.UtilsKt.checkState(!builder.buildCalled);
            builder.buildCalled = true;
            Context context = builder.context;
            Object obj = MediaLibraryService.MediaLibrarySession.STATIC_LOCK;
            int iIntValue = ((Integer) MediaLibrarySessionImpl.mediaMetadataBitmapMaxSize.get()).intValue();
            if (i3 < 27) {
                iIntValue = Math.max(iIntValue, (int) TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()));
            }
            BitmapLoader bitmapLoader = builder.bitmapLoader;
            byte b4 = 9;
            if (bitmapLoader == null) {
                JsonTreeReader jsonTreeReader = new JsonTreeReader(context);
                jsonTreeReader.stackDepth = iIntValue;
                jsonTreeReader.isLenient = true;
                dataSourceBitmapLoader = new DataSourceBitmapLoader(jsonTreeReader);
                builder.bitmapLoader = dataSourceBitmapLoader;
            } else {
                BitmapLoader priorityQueue = new PriorityQueue(bitmapLoader, iIntValue, b4);
                builder.bitmapLoader = priorityQueue;
                dataSourceBitmapLoader = priorityQueue;
            }
            byte b5 = 3;
            if (i3 == 29) {
                AtomicReference atomicReference = MediaLibraryService.MediaLibrarySession.Builder.bitmapSizesToAvoidApi29;
                ImmutableIntArray immutableIntArray = (ImmutableIntArray) atomicReference.get();
                if (immutableIntArray != null) {
                    b = 6;
                } else {
                    Display defaultDisplay = ((WindowManager) context.getSystemService(WindowManager.class)).getDefaultDisplay();
                    Point point = new Point();
                    defaultDisplay.getSize(point);
                    Point point2 = new Point();
                    defaultDisplay.getRealSize(point2);
                    b = 6;
                    int i4 = point2.y;
                    int i5 = point2.x;
                    Point point3 = new Point(i4 - (i5 - point.x), i5 - (i4 - point.y));
                    ImmutableIntArray immutableIntArray2 = new ImmutableIntArray(new int[]{Math.max(point.x / 6, point.y / 6), Math.max(point3.x / 6, point3.y / 6)});
                    atomicReference.set(immutableIntArray2);
                    immutableIntArray = immutableIntArray2;
                }
                BitmapLoader splitter = new Splitter(dataSourceBitmapLoader, immutableIntArray, b5);
                builder.bitmapLoader = splitter;
                dataSourceBitmapLoader = splitter;
            } else {
                b = 6;
            }
            builder.bitmapLoader = new CallbackWrapper((byte) 26, (Object) dataSourceBitmapLoader);
            this.mediaSession = new MediaLibraryService.MediaLibrarySession(builder.context, builder.id, builder.player, builder.sessionActivity, builder.customLayout, builder.mediaButtonPreferences, builder.commandButtonsForMediaItems, builder.callback, builder.tokenExtras, builder.sessionExtras, builder.bitmapLoader, builder.playIfSuppressed, builder.isPeriodicPositionUpdateEnabled, builder.libraryErrorReplicationMode);
            ExoPlayerImpl exoPlayerImpl2 = this.player;
            MutablePreferences mutablePreferences3 = this.startupPrefs;
            mutablePreferences3.getClass();
            Integer num = (Integer) mutablePreferences3.get(PreferenceKeysKt.RepeatModeKey);
            exoPlayerImpl2.setRepeatMode(num != null ? num.intValue() : 0);
            MutablePreferences mutablePreferences4 = this.startupPrefs;
            mutablePreferences4.getClass();
            Boolean bool4 = (Boolean) mutablePreferences4.get(PreferenceKeysKt.RememberShuffleAndRepeatKey);
            if (bool4 != null ? bool4.booleanValue() : true) {
                ExoPlayerImpl exoPlayerImpl3 = this.player;
                MutablePreferences mutablePreferences5 = this.startupPrefs;
                mutablePreferences5.getClass();
                Boolean bool5 = (Boolean) mutablePreferences5.get(PreferenceKeysKt.ShuffleModeKey);
                exoPlayerImpl3.setShuffleModeEnabled(bool5 != null ? bool5.booleanValue() : false);
            }
            SessionToken sessionToken = new SessionToken(this, new ComponentName(this, (Class<?>) MusicService.class));
            Bundle bundle = Bundle.EMPTY;
            CueDecoder cueDecoder = new CueDecoder(b3);
            Looper currentOrMainLooper = Util.getCurrentOrMainLooper();
            MediaControllerHolder mediaControllerHolder = new MediaControllerHolder(currentOrMainLooper);
            byte b6 = 3;
            Util.postOrRun(new Handler(currentOrMainLooper), new MediaControllerHolder$$ExternalSyntheticLambda0(mediaControllerHolder, new MediaController(this, sessionToken, bundle, cueDecoder, currentOrMainLooper, mediaControllerHolder, sessionToken.impl.isLegacySession() ? new CallbackWrapper((byte) 26, (Object) new DataSourceBitmapLoader(new JsonTreeReader(this))) : null), (byte) 1));
            this.controllerFuture = mediaControllerHolder;
            mediaControllerHolder.addListener(new MusicService$$ExternalSyntheticLambda0(this, (byte) 2), DirectExecutor.INSTANCE);
            Object systemService2 = getSystemService((Class<Object>) ConnectivityManager.class);
            systemService2.getClass();
            this.connectivityManager = (ConnectivityManager) systemService2;
            this.connectivityObserver = new NetworkConnectivityObserver(this);
            PowerManager powerManager = (PowerManager) getSystemService(PowerManager.class);
            this.isScreenOff = (powerManager == null || powerManager.isInteractive()) ? false : true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            registerReceiver(this.screenStateReceiver, intentFilter);
            AudioManager audioManager = this.audioManager;
            if (audioManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audioManager");
                throw null;
            }
            audioManager.registerAudioDeviceCallback(this.audioDeviceCallback, null);
            MutablePreferences mutablePreferences6 = this.startupPrefs;
            mutablePreferences6.getClass();
            String str2 = (String) mutablePreferences6.get(PreferenceKeysKt.AudioQualityKey);
            byte b7 = 5;
            if (str2 == null) {
                audioQuality = AudioQuality.AUTO;
            } else {
                if (str2.equals("VERY_HIGH")) {
                    audioQuality = AudioQuality.HIGH;
                } else {
                    EnumEntriesList enumEntriesList = AudioQuality.$ENTRIES;
                    enumEntriesList.getClass();
                    UIntArray.Iterator iterator = new UIntArray.Iterator((byte) 5, enumEntriesList);
                    do {
                        if (!iterator.hasNext()) {
                            next = null;
                            break;
                        }
                        next = iterator.next();
                    } while (!Intrinsics.areEqual(((AudioQuality) next).name(), str2));
                    audioQuality = (AudioQuality) next;
                }
                if (audioQuality == null) {
                    audioQuality = AudioQuality.AUTO;
                }
            }
            this.audioQuality = audioQuality;
            MutablePreferences mutablePreferences7 = this.startupPrefs;
            mutablePreferences7.getClass();
            Float f = (Float) mutablePreferences7.get(PreferenceKeysKt.PlayerVolumeKey);
            this.playerVolume = StateFlowKt.MutableStateFlow(Float.valueOf(UuidKt.coerceIn(f != null ? f.floatValue() : 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f)));
            if (((Boolean) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.EnableGoogleCastKey, Boolean.TRUE)).booleanValue()) {
                try {
                    this.castConnectionHandler = new CastConnectionHandler(this, this.scope, this);
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                } catch (Exception unused2) {
                    Timber.Forest.getClass();
                    ConnectionPool.e$1(new Object[0]);
                }
            }
            ImageLoader$Builder imageLoader$Builder = this.lyricsHelper;
            if (imageLoader$Builder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lyricsHelper");
                throw null;
            }
            Continuation continuation2 = null;
            CoroutineExtKt.collectLatest((Flow) imageLoader$Builder.memoryCacheLazy, this.scope, new App$Companion$forgetAccount$2(2, continuation2, (byte) 9));
            AwaitKt.launch$default(this.scope, null, null, new AnonymousClass2(b3, this, continuation2), 3);
            AwaitKt.launch$default(this.scope, null, null, new AnonymousClass2(b6, this, continuation2), 3);
            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            ref$BooleanRef.element = true;
            byte b8 = 19;
            AwaitKt.launch$default(this.scope, null, null, new App.C01391(this, ref$BooleanRef, continuation2, b8), 3);
            byte b9 = 4;
            byte b10 = 10;
            Continuation continuation3 = null;
            CoroutineExtKt.collectLatest(new DownloadUtil$getDownload$$inlined$map$1(new Flow[]{getPlayerVolume(), this.isMuted, this.sleepTimerVolumeMultiplier, this.audioFocusVolumeMultiplier}, new AnonymousClass12(null), b10), this.scope, new AnonymousClass13(this, (Continuation) null));
            byte b11 = 0;
            CoroutineExtKt.collect(StateFlowKt.debounce(getPlayerVolume(), 1000L), this.scope, new AnonymousClass14(this, continuation3, b11));
            CoroutineExtKt.collect(StateFlowKt.debounce(this.currentSong, 1000L), this.scope, new AnonymousClass15(b11, this, continuation3));
            Continuation continuation4 = null;
            CoroutineExtKt.collectLatest(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(StateFlowKt.distinctUntilChangedBy$FlowKt__DistinctKt(this.currentMediaMetadata, new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 28), StateFlowKt.defaultAreEquivalent), StateFlowKt.distinctUntilChanged(new SyncUtils$special$$inlined$map$1(UtilsKt.getDataStore(this).getData(), b7)), new DataStoreImpl$data$1$5(b6, continuation4, (byte) 2), (byte) 0), this.scope, new AnonymousClass19(this, null));
            CoroutineExtKt.collectLatest(StateFlowKt.distinctUntilChanged(new SyncUtils$special$$inlined$map$1(UtilsKt.getDataStore(this).getData(), b)), this.scope, new AnonymousClass21((byte) 0, this, continuation4));
            byte b12 = 7;
            byte b13 = 8;
            Continuation continuation5 = null;
            CoroutineExtKt.collectLatest(StateFlowKt.combine(this.currentFormat, StateFlowKt.distinctUntilChanged(new SyncUtils$special$$inlined$map$1(UtilsKt.getDataStore(this).getData(), b12)), StateFlowKt.distinctUntilChanged(new SyncUtils$special$$inlined$map$1(UtilsKt.getDataStore(this).getData(), b13)), new AnonymousClass24(b9, continuation5, (byte) 0)), this.scope, new AnonymousClass21((byte) 1, this, continuation5));
            CoroutineExtKt.collectLatest(StateFlowKt.distinctUntilChanged(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(new SyncUtils$special$$inlined$map$1(UtilsKt.getDataStore(this).getData(), (byte) 9), new SyncUtils$special$$inlined$map$1(UtilsKt.getDataStore(this).getData(), b10), new AnonymousClass28(3, null), (byte) 0)), this.scope, new AnonymousClass2(b9, this, continuation5));
            Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
            ref$BooleanRef2.element = true;
            byte b14 = 11;
            CoroutineExtKt.collectLatest(StateFlowKt.distinctUntilChanged(new SyncUtils$special$$inlined$map$1(UtilsKt.getDataStore(this).getData(), b14)), this.scope, new DownloadUtil.AnonymousClass2(ref$BooleanRef2, this, null, b8));
            DiscordRpcManager discordRpcManager = DiscordRpcManager.INSTANCE;
            if (!discordRpcManager.isInitialized()) {
                discordRpcManager.init(this);
            }
            byte b15 = 12;
            Continuation continuation6 = null;
            CoroutineExtKt.collect(StateFlowKt.distinctUntilChanged(StateFlowKt.debounce(new SyncUtils$special$$inlined$map$1(UtilsKt.getDataStore(this).getData(), b15), 300L)), this.scope, new AnonymousClass2(b7, this, continuation6));
            CoroutineExtKt.collectLatest(discordRpcManager.getAccessTokenFlow(), this.scope, new AnonymousClass21((byte) 2, this, continuation6));
            AwaitKt.launch$default(this.scope, null, null, new AnonymousClass2((byte) 6, this, continuation6), 3);
            AwaitKt.launch$default(this.scope, null, null, new AnonymousClass2(b12, this, continuation6), 3);
            AwaitKt.launch$default(this.scope, null, null, new AnonymousClass37((byte) 0, this, continuation6), 3);
            byte b16 = 13;
            CoroutineExtKt.collect(StateFlowKt.distinctUntilChanged(StateFlowKt.debounce(new SyncUtils$special$$inlined$map$1(UtilsKt.getDataStore(this).getData(), b16), 300L)), this.scope, new AnonymousClass2(b13, this, continuation6));
            CoroutineExtKt.collectLatest(StateFlowKt.distinctUntilChanged(new SyncUtils$special$$inlined$map$1(UtilsKt.getDataStore(this).getData(), (byte) 2)), this.scope, new AnonymousClass2((byte) 9, this, continuation6));
            CoroutineExtKt.collect(StateFlowKt.distinctUntilChanged(new SyncUtils$special$$inlined$map$1(UtilsKt.getDataStore(this).getData(), b6)), this.scope, new AnonymousClass21(b6, this, continuation6));
            SyncUtils$special$$inlined$map$1 syncUtils$special$$inlined$map$1 = new SyncUtils$special$$inlined$map$1(UtilsKt.getDataStore(this).getData(), b9);
            ListenTogetherManager listenTogetherManager = this.listenTogetherManager;
            if (listenTogetherManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listenTogetherManager");
                throw null;
            }
            CoroutineExtKt.collect(StateFlowKt.distinctUntilChanged(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(syncUtils$special$$inlined$map$1, listenTogetherManager.roomState, new AnonymousClass45(3, null), (byte) 0)), this.scope, new AnonymousClass21(b9, this, continuation6));
            AwaitKt.launch$default(this.scope, null, null, new AnonymousClass2(b10, this, continuation6), 3);
            AwaitKt.launch$default(this.scope, null, null, new AnonymousClass2(b14, this, continuation6), 3);
            AwaitKt.launch$default(this.scope, null, null, new AnonymousClass2(b15, this, continuation6), 3);
            AwaitKt.launch$default(this.scope, null, null, new AnonymousClass2(b16, this, continuation6), 3);
            AwaitKt.launch$default(this.scope, null, null, new AnonymousClass2((byte) 14, this, continuation6), 3);
            AwaitKt.launch$default(this.scope, null, null, new AnonymousClass2((byte) 15, this, continuation6), 3);
            AwaitKt.launch$default(this.scope, null, null, new AnonymousClass2((byte) 16, this, continuation6), 3);
            MutablePreferences mutablePreferences8 = this.startupPrefs;
            mutablePreferences8.getClass();
            Boolean bool6 = (Boolean) mutablePreferences8.get(PreferenceKeysKt.PersistentQueueKey);
            if (bool6 != null ? bool6.booleanValue() : true) {
                File filesDir = getFilesDir();
                filesDir.getClass();
                File fileResolve = FilesKt.resolve(filesDir, "persistent_queue.data");
                if (fileResolve.exists()) {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(fileResolve);
                        try {
                            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                            try {
                                Object object = objectInputStream.readObject();
                                object.getClass();
                                PersistQueue persistQueue = (PersistQueue) object;
                                objectInputStream.close();
                                fileInputStream.close();
                                failure = persistQueue;
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    CharsKt.closeFinally(objectInputStream, th);
                                    throw th2;
                                }
                            }
                        } catch (Throwable th3) {
                            try {
                                throw th3;
                            } catch (Throwable th4) {
                                CharsKt.closeFinally(fileInputStream, th3);
                                throw th4;
                            }
                        }
                    } catch (Throwable th5) {
                        failure = new Result.Failure(th5);
                    }
                    if (!(failure instanceof Result.Failure)) {
                        try {
                            failure2 = AwaitKt.launch$default(this.scope, null, null, new DataStoreKt$get$2(this, EntryPoints.toQueue((PersistQueue) failure), null, b9), 3);
                        } catch (Throwable th6) {
                            failure2 = new Result.Failure(th6);
                        }
                        if (Result.m1866exceptionOrNullimpl(failure2) != null) {
                            Timber.Forest.tag("MusicService");
                            ConnectionPool.w$1(new Object[0]);
                            clearPersistedQueueFiles();
                        }
                    }
                    if (Result.m1866exceptionOrNullimpl(failure) != null) {
                        Timber.Forest.tag("MusicService");
                        ConnectionPool.w$1(new Object[0]);
                        clearPersistedQueueFiles();
                    }
                }
                File filesDir2 = getFilesDir();
                filesDir2.getClass();
                File fileResolve2 = FilesKt.resolve(filesDir2, "persistent_automix.data");
                if (fileResolve2.exists()) {
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(fileResolve2);
                        try {
                            ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);
                            try {
                                Object object2 = objectInputStream2.readObject();
                                object2.getClass();
                                PersistQueue persistQueue2 = (PersistQueue) object2;
                                objectInputStream2.close();
                                fileInputStream2.close();
                                failure3 = persistQueue2;
                            } catch (Throwable th7) {
                                try {
                                    throw th7;
                                } catch (Throwable th8) {
                                    CharsKt.closeFinally(objectInputStream2, th7);
                                    throw th8;
                                }
                            }
                        } catch (Throwable th9) {
                            try {
                                throw th9;
                            } catch (Throwable th10) {
                                CharsKt.closeFinally(fileInputStream2, th9);
                                throw th10;
                            }
                        }
                    } catch (Throwable th11) {
                        failure3 = new Result.Failure(th11);
                    }
                    if (!(failure3 instanceof Result.Failure)) {
                        PersistQueue persistQueue3 = (PersistQueue) failure3;
                        try {
                            StateFlowImpl stateFlowImpl3 = this.automixItems;
                            List<MediaMetadata> items = persistQueue3.getItems();
                            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(items, 10));
                            Iterator<T> it = items.iterator();
                            while (it.hasNext()) {
                                arrayList.add(UuidKt.toMediaItem((MediaMetadata) it.next()));
                            }
                            stateFlowImpl3.getClass();
                            stateFlowImpl3.updateState(null, arrayList);
                            failure4 = Unit.INSTANCE;
                        } catch (Throwable th12) {
                            failure4 = new Result.Failure(th12);
                        }
                        if (Result.m1866exceptionOrNullimpl(failure4) != null) {
                            Timber.Forest.tag("MusicService");
                            ConnectionPool.w$1(new Object[0]);
                            clearPersistedQueueFiles();
                        }
                    }
                    if (Result.m1866exceptionOrNullimpl(failure3) != null) {
                        Timber.Forest.tag("MusicService");
                        ConnectionPool.w$1(new Object[0]);
                        clearPersistedQueueFiles();
                    }
                }
                File filesDir3 = getFilesDir();
                filesDir3.getClass();
                File fileResolve3 = FilesKt.resolve(filesDir3, "persistent_player_state.data");
                if (fileResolve3.exists()) {
                    try {
                        FileInputStream fileInputStream3 = new FileInputStream(fileResolve3);
                        try {
                            ObjectInputStream objectInputStream3 = new ObjectInputStream(fileInputStream3);
                            try {
                                Object object3 = objectInputStream3.readObject();
                                object3.getClass();
                                failure5 = (PersistPlayerState) object3;
                                objectInputStream3.close();
                                fileInputStream3.close();
                            } catch (Throwable th13) {
                                try {
                                    throw th13;
                                } catch (Throwable th14) {
                                    CharsKt.closeFinally(objectInputStream3, th13);
                                    throw th14;
                                }
                            }
                        } catch (Throwable th15) {
                            try {
                                throw th15;
                            } catch (Throwable th16) {
                                CharsKt.closeFinally(fileInputStream3, th15);
                                throw th16;
                            }
                        }
                    } catch (Throwable th17) {
                        failure5 = new Result.Failure(th17);
                    }
                    if (!(failure5 instanceof Result.Failure)) {
                        AwaitKt.launch$default(this.scope, null, null, new App.C01391(this, (PersistPlayerState) failure5, null, (byte) 20), 3);
                    }
                    if (Result.m1866exceptionOrNullimpl(failure5) != null) {
                        Timber.Forest.tag("MusicService");
                        ConnectionPool.w$1(new Object[0]);
                        clearPersistedQueueFiles();
                    }
                }
            }
            Continuation continuation7 = null;
            AwaitKt.launch$default(this.scope, null, null, new AnonymousClass37((byte) 1, this, continuation7), 3);
            AwaitKt.launch$default(this.scope, null, null, new AnonymousClass37((byte) 2, this, continuation7), 3);
        }
    }

    @Override // androidx.media3.session.MediaSessionService, androidx.lifecycle.LifecycleService, android.app.Service
    public final void onDestroy() throws Throwable {
        isRunning = false;
        ExoPlayerImpl exoPlayerImpl = this.player;
        Continuation continuation = null;
        if (exoPlayerImpl == null) {
            try {
                AwaitKt.cancel(this.scope, (CancellationException) null);
            } catch (Exception unused) {
            }
            super.onDestroy();
            shutdownDeferred.makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
            return;
        }
        MediaItem currentMediaItem = exoPlayerImpl.getCurrentMediaItem();
        MediaMetadata metadata = currentMediaItem != null ? UuidKt.getMetadata(currentMediaItem) : null;
        if (metadata != null && metadata.isEpisode && this.player.getCurrentPosition() > 0) {
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            AwaitKt.runBlockingK(DefaultIoScheduler.INSTANCE, new DownloadUtil.AnonymousClass2(this, metadata, continuation, (byte) 20));
        }
        try {
            unregisterReceiver(this.screenStateReceiver);
        } catch (Exception unused2) {
        }
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioManager");
            throw null;
        }
        audioManager.unregisterAudioDeviceCallback(this.audioDeviceCallback);
        if (((Boolean) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.PersistentQueueKey, Boolean.TRUE)).booleanValue()) {
            saveQueueToDisk();
            savePlayerStateToDisk();
        }
        this.screenOffHandler.removeCallbacks(this.screenOffTimeout);
        this.screenOffHandler.removeCallbacks(this.pauseTimeout);
        DiscordRpcManager discordRpcManager = DiscordRpcManager.INSTANCE;
        if (discordRpcManager.isReady()) {
            Timber.Forest.tag("DiscordSvc");
            ConnectionPool.i(new Object[0]);
            discordRpcManager.disconnect();
        }
        discordRpcManager.destroy();
        NetworkConnectivityObserver networkConnectivityObserver = this.connectivityObserver;
        if (networkConnectivityObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectivityObserver");
            throw null;
        }
        networkConnectivityObserver.connectivityManager.unregisterNetworkCallback(networkConnectivityObserver.networkCallback);
        abandonAudioFocus();
        closeAudioEffectSession(null);
        MediaLibrarySessionCallback mediaLibrarySessionCallback = this.mediaLibrarySessionCallback;
        if (mediaLibrarySessionCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaLibrarySessionCallback");
            throw null;
        }
        AwaitKt.cancel(mediaLibrarySessionCallback.scope, (CancellationException) null);
        MediaLibraryService.MediaLibrarySession mediaLibrarySession = this.mediaSession;
        if (mediaLibrarySession != null) {
            try {
                synchronized (MediaLibraryService.MediaLibrarySession.STATIC_LOCK) {
                    MediaLibraryService.MediaLibrarySession.SESSION_ID_TO_SESSION_MAP.remove(mediaLibrarySession.impl.sessionId);
                }
                mediaLibrarySession.impl.release();
            } catch (Exception unused3) {
            }
        }
        PlayerMessage playerMessage = this.crossfadeMessage;
        if (playerMessage != null) {
            playerMessage.cancel();
        }
        this.crossfadeMessage = null;
        StandaloneCoroutine standaloneCoroutine = this.crossfadeJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.crossfadeJob = null;
        ExoPlayerImpl exoPlayerImpl2 = this.secondaryPlayer;
        if (exoPlayerImpl2 != null) {
            exoPlayerImpl2.removeListener(this.secondaryPlayerListener);
            releaseExoPlayer(exoPlayerImpl2);
        }
        this.secondaryPlayer = null;
        ExoPlayerImpl exoPlayerImpl3 = this.fadingPlayer;
        if (exoPlayerImpl3 != null) {
            releaseExoPlayer(exoPlayerImpl3);
        }
        this.fadingPlayer = null;
        this.isCrossfading = false;
        this.player.removeListener(this);
        SleepTimer sleepTimer = this.sleepTimer;
        if (sleepTimer != null) {
            this.player.removeListener(sleepTimer);
        }
        StandaloneCoroutine standaloneCoroutine2 = this.initialBufferRecoveryJob;
        if (standaloneCoroutine2 != null) {
            standaloneCoroutine2.cancel(null);
        }
        MediaControllerHolder mediaControllerHolder = this.controllerFuture;
        if (mediaControllerHolder != null) {
            MediaController.releaseFuture(mediaControllerHolder);
        }
        this.controllerFuture = null;
        releaseExoPlayer(this.player);
        AwaitKt.cancel(this.scope, (CancellationException) null);
        super.onDestroy();
        shutdownDeferred.makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onDeviceVolumeChanged(int i, boolean z) {
        boolean zBooleanValue = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.PauseOnMute, Boolean.FALSE)).booleanValue();
        if ((i == 0 || z) && zBooleanValue) {
            if (this.player.isPlaying()) {
                this.wasPlayingBeforeVolumeMute = true;
                this.isPausedByVolumeMute = true;
                this.player.setPlayWhenReady(false);
                return;
            }
            return;
        }
        if (i <= 0 || z || !zBooleanValue || !this.wasPlayingBeforeVolumeMute || this.player.isPlaying()) {
            return;
        }
        CastConnectionHandler castConnectionHandler = this.castConnectionHandler;
        if (castConnectionHandler == null || !((Boolean) castConnectionHandler.isCasting.getValue()).booleanValue()) {
            this.wasPlayingBeforeVolumeMute = false;
            this.isPausedByVolumeMute = false;
            this.player.setPlayWhenReady(true);
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onEvents(Player player, Player.Events events) {
        ScrobbleManager scrobbleManager;
        boolean z;
        player.getClass();
        byte b = 1;
        Continuation continuation = null;
        if (events.flags.containsAny(4, 5)) {
            scheduleCrossfade();
            if ((player.getPlaybackState() == 2 || player.getPlaybackState() == 3) && player.getPlayWhenReady()) {
                if (this.hasAudioFocus) {
                    z = true;
                } else {
                    AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
                    if (audioFocusRequest != null) {
                        AudioManager audioManager = this.audioManager;
                        if (audioManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("audioManager");
                            throw null;
                        }
                        z = audioManager.requestAudioFocus(audioFocusRequest) == 1;
                        this.hasAudioFocus = z;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    openAudioEffectSession();
                }
            } else if (player.getPlaybackState() == 1) {
                closeAudioEffectSession(null);
            }
        }
        if (events.flags.containsAny(0, 11)) {
            this.currentMediaMetadata.setValue(IntMath.getCurrentMetadata(player));
        }
        if (events.flags.containsAny(7)) {
            updateWidgetUI$default(this, player.isPlaying());
            if (player.isPlaying()) {
                this.discordIntentionalDisconnect = false;
                this.screenOffHandler.removeCallbacks(this.screenOffTimeout);
                this.screenOffHandler.removeCallbacks(this.pauseTimeout);
                startWidgetUpdates();
            } else {
                StandaloneCoroutine standaloneCoroutine = this.widgetUpdateJob;
                if (standaloneCoroutine != null) {
                    standaloneCoroutine.cancel(null);
                }
                this.widgetUpdateJob = null;
                boolean z2 = this.isScreenOff;
                Handler handler = this.screenOffHandler;
                if (z2) {
                    handler.removeCallbacks(this.screenOffTimeout);
                    this.screenOffHandler.postDelayed(this.screenOffTimeout, 600000L);
                } else {
                    handler.postDelayed(this.pauseTimeout, 60000L);
                }
            }
        }
        if (events.flags.containsAny(1, 7)) {
            syncDiscordState();
        }
        if (!events.flags.containsAny(7) || (scrobbleManager = this.scrobbleManager) == null) {
            return;
        }
        boolean zIsPlaying = player.isPlaying();
        MediaMetadata currentMetadata = IntMath.getCurrentMetadata(player);
        Long lValueOf = Long.valueOf(player.getDuration());
        if (currentMetadata == null) {
            return;
        }
        if (zIsPlaying) {
            if (!scrobbleManager.songStarted) {
                scrobbleManager.onSongStart(currentMetadata, lValueOf);
                return;
            }
            if (scrobbleManager.scrobbleRemainingMillis <= 0) {
                return;
            }
            StandaloneCoroutine standaloneCoroutine2 = scrobbleManager.scrobbleJob;
            if (standaloneCoroutine2 != null) {
                standaloneCoroutine2.cancel(null);
            }
            scrobbleManager.scrobbleTimerStartedAt = System.currentTimeMillis();
            scrobbleManager.scrobbleJob = AwaitKt.launch$default(scrobbleManager.scope, null, null, new ScrobbleManager$scrobbleSong$1(scrobbleManager, currentMetadata, continuation, b), 3);
            return;
        }
        StandaloneCoroutine standaloneCoroutine3 = scrobbleManager.scrobbleJob;
        if (standaloneCoroutine3 != null) {
            standaloneCoroutine3.cancel(null);
        }
        if (scrobbleManager.scrobbleTimerStartedAt != 0) {
            long jCurrentTimeMillis = scrobbleManager.scrobbleRemainingMillis - (System.currentTimeMillis() - scrobbleManager.scrobbleTimerStartedAt);
            scrobbleManager.scrobbleRemainingMillis = jCurrentTimeMillis;
            if (jCurrentTimeMillis < 0) {
                scrobbleManager.scrobbleRemainingMillis = 0L;
            }
            scrobbleManager.scrobbleTimerStartedAt = 0L;
        }
    }

    @Override // androidx.media3.session.MediaLibraryService, androidx.media3.session.MediaSessionService
    /* JADX INFO: renamed from: onGetSession$1 */
    public final MediaLibraryService.MediaLibrarySession onGetSession(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        if (!Intrinsics.areEqual(mediaSession$ControllerInfo.remoteUserInfo.impl.packageName, getPackageName())) {
            this.taskCleared = false;
        }
        return this.mediaSession;
    }

    /* JADX WARN: Code duplicated, block: B:75:0x0128  */
    @Override // androidx.media3.common.Player.Listener
    public final void onMediaItemTransition(int i, MediaItem mediaItem) {
        String str;
        MediaMetadata metadata;
        ScrobbleManager scrobbleManager;
        int i2;
        Continuation continuation = null;
        if ((i == 0 || i == 1) && (str = this.lastTransitionedMediaId) != null) {
            ContextScope contextScope = this.scope;
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            AwaitKt.launch$default(contextScope, DefaultIoScheduler.INSTANCE, null, new MusicService$handleAlarmTrigger$2(this, str, continuation, (byte) 8), 2);
        }
        this.lastTransitionedMediaId = mediaItem != null ? mediaItem.mediaId : null;
        StandaloneCoroutine standaloneCoroutine = this.initialBufferRecoveryJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.initialBufferRecoveryJob = null;
        this.initialBufferRecoveryAttemptedMediaId = null;
        StandaloneCoroutine standaloneCoroutine2 = this.retryJob;
        if (standaloneCoroutine2 != null) {
            standaloneCoroutine2.cancel(null);
        }
        this.retryJob = null;
        updateInitialBufferRecovery(this.player.getPlaybackState());
        String str2 = this.previousEpisodeId;
        if (str2 != null) {
            long j = this.previousEpisodePosition;
            if (j > 0) {
                saveEpisodePosition(j, str2);
            }
        }
        this.previousEpisodeId = null;
        this.previousEpisodePosition = 0L;
        MediaMetadata metadata2 = mediaItem != null ? UuidKt.getMetadata(mediaItem) : null;
        if (metadata2 != null && metadata2.isEpisode) {
            this.previousEpisodeId = metadata2.id;
            AwaitKt.launch$default(this.scope, null, null, new App.C01391(this, metadata2, continuation, (byte) 21), 3);
        }
        if (i == 1) {
            ExoPlayerImpl exoPlayerImpl = this.player;
            exoPlayerImpl.verifyApplicationThread();
            if (exoPlayerImpl.repeatMode == 1 && (i2 = this.previousMediaItemIndex) != -1 && i2 != this.player.getCurrentMediaItemIndex()) {
                this.player.seekTo(this.previousMediaItemIndex, 0L, false);
            }
        }
        this.previousMediaItemIndex = this.player.getCurrentMediaItemIndex();
        this.lastPlaybackSpeed = -1.0f;
        setupAudioNormalization();
        ScrobbleManager scrobbleManager2 = this.scrobbleManager;
        if (scrobbleManager2 != null) {
            StandaloneCoroutine standaloneCoroutine3 = scrobbleManager2.scrobbleJob;
            if (standaloneCoroutine3 != null) {
                standaloneCoroutine3.cancel(null);
            }
            scrobbleManager2.scrobbleJob = null;
            scrobbleManager2.scrobbleRemainingMillis = 0L;
            scrobbleManager2.songStarted = false;
        }
        if (this.player.getPlayWhenReady() && this.player.getPlaybackState() == 3 && (scrobbleManager = this.scrobbleManager) != null) {
            scrobbleManager.onSongStart(IntMath.getCurrentMetadata(this.player), Long.valueOf(this.player.getDuration()));
        }
        CastConnectionHandler castConnectionHandler = this.castConnectionHandler;
        if (castConnectionHandler != null && ((Boolean) castConnectionHandler.isCasting.getValue()).booleanValue() && mediaItem != null && (metadata = UuidKt.getMetadata(mediaItem)) != null && this.castConnectionHandler != null) {
            metadata.id.getClass();
        }
        if (this.cachedAutoLoadMore && i != 0 && this.player.getMediaItemCount() - this.player.getCurrentMediaItemIndex() <= 5 && this.currentQueue.hasNextPage()) {
            if (this.cachedDisableLoadMoreWhenRepeatAll) {
                ExoPlayerImpl exoPlayerImpl2 = this.player;
                exoPlayerImpl2.verifyApplicationThread();
                if (exoPlayerImpl2.repeatMode != 2) {
                    AwaitKt.launch$default(this.scope, CoroutineExtKt.SilentHandler, null, new AnonymousClass2((byte) 19, this, continuation), 2);
                }
            } else {
                AwaitKt.launch$default(this.scope, CoroutineExtKt.SilentHandler, null, new AnonymousClass2((byte) 19, this, continuation), 2);
            }
        }
        if (this.cachedPersistentQueue) {
            saveQueueToDisk();
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlayWhenReadyChanged(int i, boolean z) {
        CastConnectionHandler castConnectionHandler;
        if (z && (castConnectionHandler = this.castConnectionHandler) != null && ((Boolean) castConnectionHandler.isCasting.getValue()).booleanValue()) {
            this.player.setPlayWhenReady(false);
            return;
        }
        if (i == 1) {
            if (z) {
                this.isPausedByVolumeMute = false;
            }
            if (!z && !this.isPausedByVolumeMute) {
                this.wasPlayingBeforeVolumeMute = false;
            }
        }
        if (!z) {
            MediaItem currentMediaItem = this.player.getCurrentMediaItem();
            MediaMetadata metadata = currentMediaItem != null ? UuidKt.getMetadata(currentMediaItem) : null;
            if (metadata != null && metadata.isEpisode && this.player.getCurrentPosition() > 0) {
                saveEpisodePosition(this.player.getCurrentPosition(), metadata.id);
                this.previousEpisodePosition = this.player.getCurrentPosition();
            }
        }
        if (z) {
            applyCachedAudioNormalizationNow();
        }
        updateInitialBufferRecovery(this.player.getPlaybackState());
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        playbackParameters.getClass();
        float f = playbackParameters.speed;
        if (f == this.lastPlaybackSpeed) {
            return;
        }
        Timber.Forest.tag("DiscordSvc");
        ConnectionPool.d(Float.valueOf(this.lastPlaybackSpeed), Float.valueOf(f));
        this.lastPlaybackSpeed = f;
        DiscordRpcManager.INSTANCE.notifySettingsChanged();
        AwaitKt.launch$default(this.scope, null, null, new AnonymousClass2((byte) 20, this, null), 3);
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlaybackStateChanged(int i) {
        ScrobbleManager scrobbleManager;
        String str;
        String str2;
        updateInitialBufferRecovery(i);
        Continuation continuation = null;
        if (i == 4) {
            MediaItem currentMediaItem = this.player.getCurrentMediaItem();
            if (currentMediaItem != null && (str2 = currentMediaItem.mediaId) != null) {
                ContextScope contextScope = this.scope;
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                AwaitKt.launch$default(contextScope, DefaultIoScheduler.INSTANCE, null, new MusicService$handleAlarmTrigger$2(this, str2, continuation, (byte) 9), 2);
            }
            SleepTimer sleepTimer = this.sleepTimer;
            if (sleepTimer == null) {
                return;
            }
            if (sleepTimer.isActive() && sleepTimer.getPauseWhenSongEnd()) {
                return;
            }
            ExoPlayerImpl exoPlayerImpl = this.player;
            exoPlayerImpl.verifyApplicationThread();
            int i2 = exoPlayerImpl.repeatMode;
            if (this.player.getPlayWhenReady() && i2 == 2 && this.player.getMediaItemCount() > 0) {
                this.player.seekTo(0, 0L, false);
                this.player.prepare();
                this.player.setPlayWhenReady(true);
                return;
            }
            if (this.player.getPlayWhenReady() && i2 == 1) {
                ExoPlayerImpl exoPlayerImpl2 = this.player;
                exoPlayerImpl2.seekTo(exoPlayerImpl2.getCurrentMediaItemIndex(), 0L, false);
                this.player.prepare();
                this.player.setPlayWhenReady(true);
                return;
            }
            if (this.player.getPlayWhenReady() && this.cachedAutoplay && this.player.hasNextMediaItem()) {
                this.player.seekToNextMediaItem();
                this.player.prepare();
                CastConnectionHandler castConnectionHandler = this.castConnectionHandler;
                if (castConnectionHandler == null || !((Boolean) castConnectionHandler.isCasting.getValue()).booleanValue()) {
                    this.player.setPlayWhenReady(true);
                }
            }
        }
        if (this.cachedPersistentQueue && !this.isSilenceSkipping) {
            saveQueueToDisk();
        }
        if (i == 3) {
            this.consecutivePlaybackErr = 0;
            this.retryCount = 0;
            StateFlowImpl stateFlowImpl = this.waitingForNetworkConnection;
            Boolean bool = Boolean.FALSE;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, bool);
            StandaloneCoroutine standaloneCoroutine = this.retryJob;
            if (standaloneCoroutine != null) {
                standaloneCoroutine.cancel(null);
            }
            MediaItem currentMediaItem2 = this.player.getCurrentMediaItem();
            if (currentMediaItem2 != null && (str = currentMediaItem2.mediaId) != null) {
                this.currentMediaIdRetryCount.remove(str);
                this.recentlyFailedSongs.remove(str);
                Timber.Forest.tag("MusicService");
                ConnectionPool.d(new Object[0]);
            }
            scheduleCrossfade();
        }
        if ((i == 1 || i == 4) && (scrobbleManager = this.scrobbleManager) != null) {
            StandaloneCoroutine standaloneCoroutine2 = scrobbleManager.scrobbleJob;
            if (standaloneCoroutine2 != null) {
                standaloneCoroutine2.cancel(null);
            }
            scrobbleManager.scrobbleJob = null;
            scrobbleManager.scrobbleRemainingMillis = 0L;
            scrobbleManager.songStarted = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:174:0x0263, code lost:
    
        if (r1.errorCode == 2001) goto L175;
     */
    @Override // androidx.media3.common.Player.Listener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onPlayerError(PlaybackException playbackException) {
        Integer numValueOf;
        Integer numValueOf2;
        Integer numValueOf3;
        Integer numValueOf4;
        playbackException.getClass();
        int i = playbackException.errorCode;
        byte b = 0;
        if (!((Boolean) this.playerInitialized.getValue()).booleanValue()) {
            Timber.Forest.tag("MusicService");
            ConnectionPool.e$1(new Object[0]);
            return;
        }
        MediaItem currentMediaItem = this.player.getCurrentMediaItem();
        Continuation continuation = null;
        String str = currentMediaItem != null ? currentMediaItem.mediaId : null;
        String strClientName = str != null ? this.songUrlCache.clientName(str) : null;
        ConnectionPool connectionPool = Timber.Forest;
        connectionPool.tag("MusicService");
        playbackException.getMessage();
        ConnectionPool.w$1(new Object[0]);
        playbackException.printStackTrace();
        if (str != null) {
            Integer num = (Integer) this.currentMediaIdRetryCount.get(str);
            if ((num != null ? num.intValue() : 0) >= this.MAX_RETRY_PER_SONG) {
                connectionPool.tag("MusicService");
                ConnectionPool.w(new Object[0]);
                markSongAsFailed(str);
                handleFinalFailure();
                return;
            }
        }
        if (str != null) {
            performAggressiveCacheClear(str);
        }
        ContextScope contextScope = this.scope;
        if (i != 5002 && i != 5001) {
            Throwable cause = playbackException.getCause();
            PlaybackException playbackException2 = cause instanceof PlaybackException ? (PlaybackException) cause : null;
            if (playbackException2 == null || playbackException2.errorCode != 5002) {
                Throwable cause2 = playbackException.getCause();
                PlaybackException playbackException3 = cause2 instanceof PlaybackException ? (PlaybackException) cause2 : null;
                if (playbackException3 == null || playbackException3.errorCode != 5001) {
                    Throwable cause3 = playbackException.getCause();
                    while (true) {
                        if (cause3 == null) {
                            numValueOf = null;
                            break;
                        } else {
                            if (cause3 instanceof HttpDataSource$InvalidResponseCodeException) {
                                numValueOf = Integer.valueOf(((HttpDataSource$InvalidResponseCodeException) cause3).responseCode);
                                break;
                            }
                            cause3 = cause3.getCause();
                        }
                    }
                    if (numValueOf != null && numValueOf.intValue() == 416) {
                        connectionPool.tag("MusicService");
                        ConnectionPool.d(new Object[0]);
                        if (str == null) {
                            handleFinalFailure();
                            return;
                        }
                        incrementRetryCount(str);
                        StandaloneCoroutine standaloneCoroutine = this.retryJob;
                        if (standaloneCoroutine != null) {
                            standaloneCoroutine.cancel(null);
                        }
                        this.retryJob = AwaitKt.launch$default(contextScope, null, null, new MusicService$handleAlarmTrigger$2(this, str, continuation, (byte) 7), 3);
                        return;
                    }
                    if (isPageReloadError(playbackException)) {
                        connectionPool.tag("MusicService");
                        ConnectionPool.d(new Object[0]);
                        if (str == null) {
                            handleFinalFailure();
                            return;
                        }
                        incrementRetryCount(str);
                        StandaloneCoroutine standaloneCoroutine2 = this.retryJob;
                        if (standaloneCoroutine2 != null) {
                            standaloneCoroutine2.cancel(null);
                        }
                        this.retryJob = AwaitKt.launch$default(contextScope, null, null, new MusicService$handleAlarmTrigger$2(str, this, null), 3);
                        return;
                    }
                    Throwable cause4 = playbackException.getCause();
                    while (true) {
                        if (cause4 == null) {
                            numValueOf2 = null;
                            break;
                        } else {
                            if (cause4 instanceof HttpDataSource$InvalidResponseCodeException) {
                                numValueOf2 = Integer.valueOf(((HttpDataSource$InvalidResponseCodeException) cause4).responseCode);
                                break;
                            }
                            cause4 = cause4.getCause();
                        }
                    }
                    byte b2 = 1;
                    if ((numValueOf2 != null && numValueOf2.intValue() == 403) || (numValueOf2 != null && numValueOf2.intValue() == 410)) {
                        connectionPool.tag("MusicService");
                        ConnectionPool.d(new Object[0]);
                        if (str == null) {
                            handleFinalFailure();
                            return;
                        } else {
                            refreshStreamAndRetry(str, strClientName, "expired URL error", true);
                            return;
                        }
                    }
                    if (i != 2005) {
                        Throwable cause5 = playbackException.getCause();
                        PlaybackException playbackException4 = cause5 instanceof PlaybackException ? (PlaybackException) cause5 : null;
                        if (playbackException4 == null || playbackException4.errorCode != 2005) {
                            if (i == 1001) {
                                connectionPool.tag("MusicService");
                                ConnectionPool.d(new Object[0]);
                                if (str == null) {
                                    handleFinalFailure();
                                    return;
                                } else {
                                    refreshStreamAndRetry(str, strClientName, "expired URL error", true);
                                    return;
                                }
                            }
                            if (!((Boolean) this.isNetworkConnected.getValue()).booleanValue()) {
                                connectionPool.tag("MusicService");
                                ConnectionPool.d(new Object[0]);
                                StateFlowImpl stateFlowImpl = this.waitingForNetworkConnection;
                                if (((Boolean) stateFlowImpl.getValue()).booleanValue()) {
                                    return;
                                }
                                stateFlowImpl.updateState(null, Boolean.TRUE);
                                this.pausedDueToNetworkError = false;
                                if (this.retryCount < 10) {
                                    StandaloneCoroutine standaloneCoroutine3 = this.retryJob;
                                    if (standaloneCoroutine3 != null) {
                                        standaloneCoroutine3.cancel(null);
                                    }
                                    this.retryJob = AwaitKt.launch$default(contextScope, null, null, new AnonymousClass2((byte) 22, this, continuation), 3);
                                    return;
                                }
                                connectionPool.tag("MusicService");
                                ConnectionPool.w(new Object[0]);
                                this.pausedDueToNetworkError = true;
                                this.player.setPlayWhenReady(false);
                                this.retryCount = 0;
                                StandaloneCoroutine standaloneCoroutine4 = this.retryJob;
                                if (standaloneCoroutine4 != null) {
                                    standaloneCoroutine4.cancel(null);
                                    return;
                                }
                                return;
                            }
                            Throwable cause6 = playbackException.getCause();
                            while (true) {
                                if (cause6 == null) {
                                    numValueOf3 = null;
                                    break;
                                } else {
                                    if (cause6 instanceof HttpDataSource$InvalidResponseCodeException) {
                                        numValueOf3 = Integer.valueOf(((HttpDataSource$InvalidResponseCodeException) cause6).responseCode);
                                        break;
                                    }
                                    cause6 = cause6.getCause();
                                }
                            }
                            if ((numValueOf3 == null || numValueOf3.intValue() != 403) && (numValueOf3 == null || numValueOf3.intValue() != 410)) {
                                Throwable cause7 = playbackException.getCause();
                                while (true) {
                                    if (cause7 == null) {
                                        numValueOf4 = null;
                                        break;
                                    } else {
                                        if (cause7 instanceof HttpDataSource$InvalidResponseCodeException) {
                                            numValueOf4 = Integer.valueOf(((HttpDataSource$InvalidResponseCodeException) cause7).responseCode);
                                            break;
                                        }
                                        cause7 = cause7.getCause();
                                    }
                                }
                                if ((numValueOf4 == null || numValueOf4.intValue() != 416) && !isPageReloadError(playbackException)) {
                                    if (i != 2001 && i != 2002 && !(playbackException.getCause() instanceof ConnectException) && !(playbackException.getCause() instanceof UnknownHostException)) {
                                        Throwable cause8 = playbackException.getCause();
                                        PlaybackException playbackException5 = cause8 instanceof PlaybackException ? (PlaybackException) cause8 : null;
                                        if (playbackException5 != null) {
                                        }
                                    }
                                    connectionPool.tag("MusicService");
                                    ConnectionPool.d(new Object[0]);
                                    if (str == null) {
                                        handleFinalFailure();
                                        return;
                                    }
                                    incrementRetryCount(str);
                                    StandaloneCoroutine standaloneCoroutine5 = this.retryJob;
                                    if (standaloneCoroutine5 != null) {
                                        standaloneCoroutine5.cancel(null);
                                    }
                                    this.retryJob = AwaitKt.launch$default(contextScope, null, null, new MusicService$handleAlarmTrigger$2(this, str, continuation, (byte) 5), 3);
                                    return;
                                }
                            }
                            if (i == 2000 || i == 2003 || i == 2004 || i == 3001 || i == 3003 || i == 3002 || i == 3004) {
                                connectionPool.tag("MusicService");
                                ConnectionPool.d(new Object[0]);
                                if (str == null) {
                                    handleFinalFailure();
                                    return;
                                } else {
                                    refreshStreamAndRetry(str, strClientName, "stream client error", false);
                                    return;
                                }
                            }
                            if (((Boolean) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.AutoSkipNextOnErrorKey, Boolean.FALSE)).booleanValue()) {
                                connectionPool.tag("MusicService");
                                ConnectionPool.d(new Object[0]);
                                skipOnError();
                                return;
                            } else {
                                connectionPool.tag("MusicService");
                                ConnectionPool.d(new Object[0]);
                                this.player.setPlayWhenReady(false);
                                return;
                            }
                        }
                    }
                    connectionPool.tag("MusicService");
                    ConnectionPool.d(new Object[0]);
                    if (str == null) {
                        handleFinalFailure();
                        return;
                    }
                    incrementRetryCount(str);
                    StandaloneCoroutine standaloneCoroutine6 = this.retryJob;
                    if (standaloneCoroutine6 != null) {
                        standaloneCoroutine6.cancel(null);
                    }
                    this.retryJob = AwaitKt.launch$default(contextScope, null, null, new MusicService$onCreate$11$2$1(this, str, continuation, b2), 3);
                    return;
                }
            }
        }
        connectionPool.tag("MusicService");
        ConnectionPool.d(new Object[0]);
        if (str == null) {
            handleFinalFailure();
            return;
        }
        incrementRetryCount(str);
        StandaloneCoroutine standaloneCoroutine7 = this.retryJob;
        if (standaloneCoroutine7 != null) {
            standaloneCoroutine7.cancel(null);
        }
        this.retryJob = AwaitKt.launch$default(contextScope, null, null, new MusicService$handleAudioRendererError$1(this, str, continuation, b), 3);
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPositionDiscontinuity(int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        positionInfo.getClass();
        positionInfo2.getClass();
        if (i == 1) {
            scheduleCrossfade();
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onRepeatModeChanged(int i) {
        updateNotification$default(this);
        AwaitKt.launch$default(this.scope, null, null, new PagerState$scrollToPage$2(this, i, null, (byte) 3), 3);
        if (this.cachedPersistentQueue) {
            saveQueueToDisk();
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onShuffleModeEnabledChanged(boolean z) {
        updateNotification$default(this);
        if (z) {
            if (this.player.getMediaItemCount() == 0) {
                return;
            }
            applyShuffleOrder(this.player.getCurrentMediaItemIndex(), ((Boolean) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.ShufflePlaylistFirstKey, Boolean.FALSE)).booleanValue(), this.player.getMediaItemCount());
        }
        if (((Boolean) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.RememberShuffleAndRepeatKey, Boolean.TRUE)).booleanValue()) {
            AwaitKt.launch$default(this.scope, null, null, new Updater$checkForUpdate$2((Object) this, z, (Continuation) null, (byte) 2), 3);
        }
        if (this.cachedPersistentQueue) {
            saveQueueToDisk();
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00cc  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.media3.session.MediaSessionService, android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        byte b = 0;
        Continuation continuation = null;
        if (this.taskCleared) {
            if (!Intrinsics.areEqual(intent != null ? intent.getAction() : null, "android.intent.action.MEDIA_BUTTON")) {
                stopSelf();
                return 2;
            }
            this.taskCleared = false;
        }
        byte b2 = 1;
        if (intent == null || !intent.getBooleanExtra("androidx.media3.session.NOTIFICATION_DISMISSED_EVENT_KEY", false)) {
            Notification notificationCreateFallbackForegroundNotification = this.latestMediaNotification;
            if (notificationCreateFallbackForegroundNotification == null) {
                notificationCreateFallbackForegroundNotification = createFallbackForegroundNotification();
            }
            if (!startForegroundSafely(notificationCreateFallbackForegroundNotification, true)) {
                return 2;
            }
        }
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            switch (action.hashCode()) {
                case -1761542520:
                    if (action.equals("com.metrolist.music.widget.PLAY_PAUSE")) {
                        boolean zIsPlaying = this.player.isPlaying();
                        ExoPlayerImpl exoPlayerImpl = this.player;
                        if (zIsPlaying) {
                            exoPlayerImpl.setPlayWhenReady(false);
                        } else {
                            exoPlayerImpl.setPlayWhenReady(true);
                        }
                        updateWidgetUI$default(this, this.player.isPlaying());
                    }
                    break;
                case -402585676:
                    if (action.equals("com.metrolist.music.widget.PREVIOUS")) {
                        this.player.seekToPrevious();
                        updateWidgetUI$default(this, this.player.isPlaying());
                    }
                    break;
                case -60233004:
                    if (action.equals("com.metrolist.music.widget.LIKE")) {
                        toggleLike();
                    }
                    break;
                case -60176848:
                    if (action.equals("com.metrolist.music.widget.NEXT")) {
                        this.player.seekToNext();
                        updateWidgetUI$default(this, this.player.isPlaying());
                    }
                    break;
                case 637149648:
                    if (action.equals("com.metrolist.music.widget.playlists.UPDATE_WIDGET")) {
                        updateWidgetUI$default(this, this.player.isPlaying());
                    }
                    break;
                case 1257025375:
                    if (action.equals("com.metrolist.music.action.ALARM_TRIGGER")) {
                        ContextScope contextScope = this.scope;
                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                        AwaitKt.launch$default(contextScope, defaultIoScheduler, null, new AnonymousClass15(b2, this, continuation), 2);
                        String stringExtra = intent.getStringExtra("extra_alarm_playlist_id");
                        if (stringExtra == null) {
                            stringExtra = "";
                        }
                        String stringExtra2 = intent.getStringExtra("extra_alarm_id");
                        String str = stringExtra2 != null ? stringExtra2 : "";
                        if (!StringsKt.isBlank(stringExtra)) {
                            AwaitKt.launch$default(contextScope, null, null, new DataStoreImpl$writeData$2(str, intent.getBooleanExtra("extra_alarm_random_song", false), this, stringExtra, (Continuation) null), 3);
                        } else if (!StringsKt.isBlank(str)) {
                            AwaitKt.launch$default(contextScope, defaultIoScheduler, null, new MusicService$handleAlarmTrigger$2(this, str, continuation, b), 2);
                        }
                    }
                    break;
                case 1522909650:
                    if (action.equals("com.metrolist.music.widget.playlists.PLAY_TARGET")) {
                        AwaitKt.launch$default(this.scope, null, null, new MusicService$handlePlaylistWidgetPlay$1(this, intent, continuation, b), 3);
                    }
                    break;
                case 2081418205:
                    if (action.equals("com.metrolist.music.widget.UPDATE_WIDGET")) {
                        updateWidgetUI$default(this, this.player.isPlaying());
                    }
                    break;
            }
        }
        super.onStartCommand(intent, i, i2);
        return 1;
    }

    @Override // androidx.media3.session.MediaSessionService, android.app.Service
    public final void onTaskRemoved(Intent intent) {
        Object failure;
        if (!((Boolean) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.StopMusicOnTaskClearKey, Boolean.FALSE)).booleanValue()) {
            super.onTaskRemoved(intent);
            return;
        }
        Object failure2 = Unit.INSTANCE;
        if (this.taskCleared) {
            return;
        }
        this.taskCleared = true;
        StandaloneCoroutine standaloneCoroutine = this.crossfadeJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.crossfadeJob = null;
        PlayerMessage playerMessage = this.crossfadeMessage;
        if (playerMessage != null) {
            playerMessage.cancel();
        }
        try {
            CastConnectionHandler castConnectionHandler = this.castConnectionHandler;
            if (castConnectionHandler != null) {
                ((Boolean) castConnectionHandler.isCasting.getValue()).getClass();
            }
            ExoPlayerImpl exoPlayerImpl = this.player;
            if (exoPlayerImpl != null) {
                ArrayList arrayListFilterNotNull = ArraysKt.filterNotNull(new ExoPlayerImpl[]{exoPlayerImpl, this.secondaryPlayer, this.fadingPlayer});
                int size = arrayListFilterNotNull.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayListFilterNotNull.get(i);
                    i++;
                    ExoPlayerImpl exoPlayerImpl2 = (ExoPlayerImpl) obj;
                    exoPlayerImpl2.setPlayWhenReady(false);
                    exoPlayerImpl2.stop();
                }
                this.wasPlayingBeforeAudioFocusLoss = false;
                abandonAudioFocus();
            }
            failure = failure2;
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (Result.m1866exceptionOrNullimpl(failure) != null) {
            Timber.Forest.tag("MusicService");
            ConnectionPool.e$1(new Object[0]);
        }
        MediaControllerHolder mediaControllerHolder = this.controllerFuture;
        if (mediaControllerHolder != null) {
            MediaController.releaseFuture(mediaControllerHolder);
        }
        this.controllerFuture = null;
        this.latestMediaNotification = null;
        stopForeground(1);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.cancel(888);
        }
        try {
            pauseAllPlayersAndStopSelf();
        } catch (Throwable th2) {
            failure2 = new Result.Failure(th2);
        }
        if (Result.m1866exceptionOrNullimpl(failure2) != null) {
            stopSelf();
        }
    }

    @Override // androidx.media3.session.MediaSessionService
    public final void onUpdateNotification(MediaLibraryService.MediaLibrarySession mediaLibrarySession, boolean z) {
        mediaLibrarySession.getClass();
        if (this.taskCleared) {
            return;
        }
        try {
            super.onUpdateNotification(mediaLibrarySession, z);
        } catch (ForegroundServiceStartNotAllowedException e) {
            handleForegroundServiceStartNotAllowed(e);
        } catch (IllegalStateException e2) {
            if (Build.VERSION.SDK_INT < 31 || !e2.getClass().getName().equals(ForegroundServiceStartNotAllowedException.class.getName())) {
                throw e2;
            }
            handleForegroundServiceStartNotAllowed(e2);
        }
    }

    public final void openAudioEffectSession() {
        int i;
        ExoPlayerImpl exoPlayerImpl = this.player;
        exoPlayerImpl.verifyApplicationThread();
        int iIntValue = ((Integer) exoPlayerImpl.audioSessionIdState.get()).intValue();
        if (iIntValue == 0 || iIntValue <= 0) {
            return;
        }
        boolean z = this.isAudioEffectSessionOpened;
        if (z && this.openedAudioEffectSessionId == iIntValue) {
            return;
        }
        if (z && (i = this.openedAudioEffectSessionId) > 0) {
            closeAudioEffectSession(Integer.valueOf(i));
        }
        this.isAudioEffectSessionOpened = true;
        this.openedAudioEffectSessionId = iIntValue;
        Intent intent = new Intent("android.media.action.OPEN_AUDIO_EFFECT_CONTROL_SESSION");
        intent.putExtra("android.media.extra.AUDIO_SESSION", iIntValue);
        intent.putExtra("android.media.extra.PACKAGE_NAME", getPackageName());
        intent.putExtra("android.media.extra.CONTENT_TYPE", 0);
        sendBroadcast(intent);
    }

    public final void openPlaylistWidgetTarget(Intent intent) {
        Intent intent2 = new Intent(this, (Class<?>) MainActivity.class);
        intent2.setAction("com.metrolist.music.action.OPEN_WIDGET_TARGET");
        intent2.setFlags(805306368);
        intent2.putExtra("widget_target_type", intent.getStringExtra("playlist_widget_target_type"));
        intent2.putExtra("widget_target_id", intent.getStringExtra("playlist_widget_target_id"));
        try {
            startActivity(intent2);
        } catch (Throwable unused) {
            Timber.Forest.tag("MusicService");
            ConnectionPool.e$1(new Object[0]);
        }
    }

    public final void performAggressiveCacheClear(String str) {
        ConnectionPool connectionPool = Timber.Forest;
        connectionPool.tag("MusicService");
        ConnectionPool.d(new Object[0]);
        this.songUrlCache.invalidate(str);
        try {
            getPlayerCache().removeResource(str);
            connectionPool.tag("MusicService");
            ConnectionPool.d(new Object[0]);
        } catch (Exception e) {
            Timber.Forest.tag("MusicService");
            String simpleName = Reflection.getOrCreateKotlinClass(e.getClass()).getSimpleName();
            if (simpleName == null) {
                simpleName = "unknown";
            }
            "Failed to clear player cache type=".concat(simpleName);
            ConnectionPool.e(new Object[0]);
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b8 A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:12:0x0033, B:33:0x0084, B:35:0x008e, B:37:0x009c, B:39:0x00a0, B:45:0x00b8, B:50:0x00cb, B:56:0x00e2, B:28:0x0072), top: B:62:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00e2 A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #0 {all -> 0x0039, blocks: (B:12:0x0033, B:33:0x0084, B:35:0x008e, B:37:0x009c, B:39:0x00a0, B:45:0x00b8, B:50:0x00cb, B:56:0x00e2, B:28:0x0072), top: B:62:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00d9 -> B:13:0x0036). Please report as a decompilation issue!!! */
    public final Object performInstantSilenceSkip(ContinuationImpl continuationImpl) {
        C01691 c01691;
        long j;
        SilenceDetectorAudioProcessor silenceDetectorAudioProcessor;
        int i;
        long currentPosition;
        long j2;
        long j3;
        long j4;
        int i2;
        Unit unit = Unit.INSTANCE;
        if (continuationImpl instanceof C01691) {
            c01691 = (C01691) continuationImpl;
            int i3 = c01691.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c01691.label = i3 - Integer.MIN_VALUE;
            } else {
                c01691 = new C01691(continuationImpl);
            }
        } else {
            c01691 = new C01691(continuationImpl);
        }
        Object obj = c01691.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i4 = c01691.label;
        Long l = null;
        long j5 = 15000;
        try {
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                Long l2 = new Long(this.player.getDuration());
                long jLongValue = l2.longValue();
                if (jLongValue != -9223372036854775807L && jLongValue > 0) {
                    l = l2;
                }
                if (l != null) {
                    long jLongValue2 = l.longValue();
                    if (jLongValue2 > 15000) {
                        this.isSilenceSkipping = true;
                        SilenceDetectorAudioProcessor silenceDetectorAudioProcessor2 = (SilenceDetectorAudioProcessor) this.playerSilenceProcessors.get(this.player);
                        if (silenceDetectorAudioProcessor2 == null) {
                            this.isSilenceSkipping = false;
                            return unit;
                        }
                        j = jLongValue2;
                        silenceDetectorAudioProcessor = silenceDetectorAudioProcessor2;
                        i = 0;
                        if (AwaitKt.isActive(c01691.getContext()) && ((Boolean) this.instantSilenceSkipEnabled.getValue()).booleanValue() && silenceDetectorAudioProcessor.inSilence) {
                            currentPosition = this.player.getCurrentPosition();
                            j2 = currentPosition + j5;
                            j3 = j - 500;
                            if (j2 > j3) {
                                j4 = j3;
                            } else {
                                j4 = j2;
                            }
                            if (j4 > currentPosition) {
                                silenceDetectorAudioProcessor.clearSilenceState();
                                this.player.seekToCurrentItem(j4);
                                i2 = i + 1;
                                if (i2 < 80 || j4 >= j3) {
                                    i = i2;
                                } else {
                                    c01691.L$0 = silenceDetectorAudioProcessor;
                                    c01691.J$0 = j;
                                    c01691.I$0 = i2;
                                    c01691.label = 1;
                                    if (AwaitKt.delay(350L, c01691) == coroutineSingletons) {
                                        return coroutineSingletons;
                                    }
                                }
                            }
                        }
                        if (i > 0) {
                            Timber.Forest.tag("MusicService");
                            ConnectionPool.d(new Object[0]);
                        }
                        this.isSilenceSkipping = false;
                        return unit;
                    }
                }
                return unit;
            }
            if (i4 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i2 = c01691.I$0;
            j = c01691.J$0;
            silenceDetectorAudioProcessor = c01691.L$0;
            ResultKt.throwOnFailure(obj);
            i = i2;
            j5 = 15000;
            if (AwaitKt.isActive(c01691.getContext())) {
                currentPosition = this.player.getCurrentPosition();
                j2 = currentPosition + j5;
                j3 = j - 500;
                if (j2 > j3) {
                    j4 = j3;
                } else {
                    j4 = j2;
                }
                if (j4 > currentPosition) {
                    silenceDetectorAudioProcessor.clearSilenceState();
                    this.player.seekToCurrentItem(j4);
                    i2 = i + 1;
                    if (i2 < 80) {
                    }
                    i = i2;
                }
            }
            if (i > 0) {
                Timber.Forest.tag("MusicService");
                ConnectionPool.d(new Object[0]);
            }
            this.isSilenceSkipping = false;
            return unit;
        } catch (Throwable th) {
            this.isSilenceSkipping = false;
            throw th;
        }
    }

    public final void playNext(List list) {
        if (this.player.getMediaItemCount() == 0 || this.player.getPlaybackState() == 1) {
            this.player.setMediaItems(list);
            this.player.prepare();
            CastConnectionHandler castConnectionHandler = this.castConnectionHandler;
            if (castConnectionHandler == null || !((Boolean) castConnectionHandler.isCasting.getValue()).booleanValue()) {
                this.player.setPlayWhenReady(true);
                return;
            }
            return;
        }
        if (((Boolean) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.PreventDuplicateTracksInQueueKey, Boolean.FALSE)).booleanValue()) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((MediaItem) it.next()).mediaId);
            }
            Set set = CollectionsKt.toSet(arrayList);
            ArrayList arrayList2 = new ArrayList();
            int currentMediaItemIndex = this.player.getCurrentMediaItemIndex();
            int mediaItemCount = this.player.getMediaItemCount();
            for (int i = 0; i < mediaItemCount; i++) {
                if (i != currentMediaItemIndex && set.contains(this.player.getMediaItemAt(i).mediaId)) {
                    arrayList2.add(Integer.valueOf(i));
                }
            }
            Iterator it2 = CollectionsKt.sortedWith(arrayList2, NaturalOrderComparator.INSTANCE$1).iterator();
            while (it2.hasNext()) {
                this.player.removeMediaItem(((Number) it2.next()).intValue());
            }
        }
        int currentMediaItemIndex2 = this.player.getCurrentMediaItemIndex() + 1;
        ExoPlayerImpl exoPlayerImpl = this.player;
        exoPlayerImpl.verifyApplicationThread();
        boolean z = exoPlayerImpl.shuffleModeEnabled;
        this.player.addMediaItems(currentMediaItemIndex2, list);
        this.player.prepare();
        if (z) {
            Timeline currentTimeline = this.player.getCurrentTimeline();
            currentTimeline.getClass();
            if (currentTimeline.isEmpty()) {
                return;
            }
            int windowCount = currentTimeline.getWindowCount();
            int currentMediaItemIndex3 = this.player.getCurrentMediaItemIndex();
            Set set2 = CollectionsKt.toSet(UuidKt.until(currentMediaItemIndex2, list.size() + currentMediaItemIndex2));
            ArrayList arrayList3 = new ArrayList();
            int nextWindowIndex = currentMediaItemIndex3;
            while (true) {
                nextWindowIndex = currentTimeline.getNextWindowIndex(nextWindowIndex, true, 0);
                if (nextWindowIndex == -1) {
                    break;
                } else if (nextWindowIndex != currentMediaItemIndex3) {
                    arrayList3.add(Integer.valueOf(nextWindowIndex));
                }
            }
            ArrayList arrayList4 = new ArrayList();
            int previousWindowIndex = currentMediaItemIndex3;
            while (true) {
                previousWindowIndex = currentTimeline.getPreviousWindowIndex(previousWindowIndex, true, 0);
                if (previousWindowIndex == -1) {
                    break;
                } else if (previousWindowIndex != currentMediaItemIndex3) {
                    arrayList4.add(Integer.valueOf(previousWindowIndex));
                }
            }
            Collections.reverse(arrayList4);
            ArrayList arrayListPlus = CollectionsKt.plus((Iterable) arrayList3, (Collection) arrayList4);
            ArrayList arrayList5 = new ArrayList();
            int size = arrayListPlus.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayListPlus.get(i2);
                i2++;
                int iIntValue = ((Number) obj).intValue();
                if (iIntValue != currentMediaItemIndex3 && !set2.contains(Integer.valueOf(iIntValue))) {
                    arrayList5.add(obj);
                }
            }
            List list2 = CollectionsKt.toList(UuidKt.until(currentMediaItemIndex2, list.size() + currentMediaItemIndex2));
            int[] iArr = new int[windowCount];
            ArrayList arrayList6 = new ArrayList();
            int size2 = arrayList4.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj2 = arrayList4.get(i3);
                i3++;
                if (!set2.contains(Integer.valueOf(((Number) obj2).intValue()))) {
                    arrayList6.add(obj2);
                }
            }
            int size3 = arrayList6.size();
            int i4 = 0;
            int i5 = 0;
            while (i5 < size3) {
                Object obj3 = arrayList6.get(i5);
                i5++;
                int iIntValue2 = ((Number) obj3).intValue();
                if (iIntValue2 >= 0 && iIntValue2 < windowCount) {
                    iArr[i4] = iIntValue2;
                    i4++;
                }
            }
            int i6 = i4 + 1;
            iArr[i4] = currentMediaItemIndex3;
            Iterator it3 = list2.iterator();
            while (it3.hasNext()) {
                int iIntValue3 = ((Number) it3.next()).intValue();
                if (iIntValue3 >= 0 && iIntValue3 < windowCount) {
                    iArr[i6] = iIntValue3;
                    i6++;
                }
            }
            ArrayList arrayList7 = new ArrayList();
            int size4 = arrayList3.size();
            int i7 = 0;
            while (i7 < size4) {
                Object obj4 = arrayList3.get(i7);
                i7++;
                if (!set2.contains(Integer.valueOf(((Number) obj4).intValue()))) {
                    arrayList7.add(obj4);
                }
            }
            int size5 = arrayList7.size();
            int i8 = 0;
            while (i8 < size5) {
                Object obj5 = arrayList7.get(i8);
                i8++;
                int iIntValue4 = ((Number) obj5).intValue();
                if (i6 < windowCount) {
                    iArr[i6] = iIntValue4;
                    i6++;
                }
            }
            if (i6 < windowCount) {
                for (int i9 = 0; i9 < windowCount; i9++) {
                    int i10 = 0;
                    while (true) {
                        if (i10 >= windowCount) {
                            i10 = -1;
                            break;
                        } else if (i9 == iArr[i10]) {
                            break;
                        } else {
                            i10++;
                        }
                    }
                    if (i10 < 0) {
                        int i11 = i6 + 1;
                        iArr[i6] = i9;
                        if (i11 == windowCount) {
                            break;
                        } else {
                            i6 = i11;
                        }
                    }
                }
            }
            this.player.setShuffleOrder(new ShuffleOrder$DefaultShuffleOrder(iArr, System.currentTimeMillis()));
        }
    }

    public final void playQueue(Queue queue, boolean z, boolean z2) throws IOException {
        queue.getClass();
        if (this.taskCleared) {
            return;
        }
        boolean zBooleanValue = ((Boolean) this.playerInitialized.getValue()).booleanValue();
        ContextScope contextScope = this.scope;
        if (!zBooleanValue) {
            Timber.Forest.tag("MusicService");
            ConnectionPool.w(new Object[0]);
            AwaitKt.launch$default(contextScope, null, null, new C01701(this, queue, (Continuation) null, z), 3);
            return;
        }
        this.currentQueue = queue;
        this.queueTitle = null;
        if (!((Boolean) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.PersistentShuffleAcrossQueuesKey, Boolean.FALSE)).booleanValue() && !z2) {
            this.player.setShuffleModeEnabled(false);
        }
        this.originalQueueSize = 0;
        if (queue.getPreloadItem() != null) {
            ExoPlayerImpl exoPlayerImpl = this.player;
            MediaMetadata preloadItem = queue.getPreloadItem();
            preloadItem.getClass();
            exoPlayerImpl.setMediaItem(UuidKt.toMediaItem(preloadItem));
            this.player.prepare();
            this.player.setPlayWhenReady(z);
        }
        AwaitKt.launch$default(contextScope, CoroutineExtKt.SilentHandler, null, new C01712(this, queue, null, z), 2);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:40:0x00bc A[PHI: r9
      0x00bc: PHI (r9v3 java.lang.Integer) = (r9v1 java.lang.Integer), (r9v5 java.lang.Integer) binds: [B:46:0x00d2, B:39:0x00ba] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:41:0x00c1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:57:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:60:0x0108  */
    /* JADX WARN: Code duplicated, block: B:63:0x0122  */
    /* JADX WARN: Code duplicated, block: B:66:0x0127  */
    /* JADX WARN: Code duplicated, block: B:69:0x012c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0141, code lost:
    
        if (r13 == r8) goto L74;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object recoverSong(String str, InnerTubeXPlayer.PlaybackData playbackData, ContinuationImpl continuationImpl) {
        C01721 c01721;
        String str2;
        Song song;
        MediaMetadata mediaMetadata;
        Integer num;
        Integer num2;
        int iIntValue;
        PlayerResponse$VideoDetails playerResponse$VideoDetails;
        String str3;
        Object objM1024next0E7RQCE;
        String str4;
        SongEntity songEntity;
        NextResult nextResult;
        BrowseEndpoint browseEndpoint;
        Object objM1031relatedgIAlus;
        if (continuationImpl instanceof C01721) {
            c01721 = (C01721) continuationImpl;
            int i = c01721.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01721.label = i - Integer.MIN_VALUE;
            } else {
                c01721 = new C01721(continuationImpl);
            }
        } else {
            c01721 = new C01721(continuationImpl);
        }
        Object objFirst = c01721.result;
        int i2 = c01721.label;
        byte b = 4;
        byte b2 = 2;
        Unit unit = Unit.INSTANCE;
        Object[] objArr = 0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFirst);
            Flow flowSong = getDatabase().$$delegate_0.song(str);
            c01721.L$0 = str;
            c01721.L$1 = playbackData;
            c01721.label = 1;
            objFirst = StateFlowKt.first(flowSong, c01721);
            if (objFirst != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            playbackData = c01721.L$1;
            str = c01721.L$0;
            ResultKt.throwOnFailure(objFirst);
        } else {
            if (i2 == 2) {
                song = c01721.L$2;
                playbackData = c01721.L$1;
                str2 = c01721.L$0;
                ResultKt.throwOnFailure(objFirst);
                mediaMetadata = (MediaMetadata) objFirst;
                if (mediaMetadata == null || song != null) {
                    if (song != null || (songEntity = song.song) == null) {
                        if (mediaMetadata != null) {
                            num = new Integer(mediaMetadata.duration);
                            if (num.intValue() == -1) {
                                num = null;
                            }
                        } else {
                            num = null;
                        }
                        if (num != null) {
                            iIntValue = num.intValue();
                        } else {
                            if (playbackData != null || (playerResponse$VideoDetails = playbackData.videoDetails) == null || (str3 = playerResponse$VideoDetails.lengthSeconds) == null) {
                                num2 = null;
                            } else {
                                num2 = new Integer(Integer.parseInt(str3));
                            }
                            if (num2 != null) {
                                iIntValue = num2.intValue();
                            } else {
                                iIntValue = -1;
                            }
                        }
                    } else {
                        num = new Integer(songEntity.duration);
                        if (num.intValue() == -1) {
                            num = null;
                        }
                        if (num != null) {
                            iIntValue = num.intValue();
                        } else {
                            if (mediaMetadata != null) {
                                num = new Integer(mediaMetadata.duration);
                                if (num.intValue() == -1) {
                                    num = null;
                                }
                            } else {
                                num = null;
                            }
                            if (num != null) {
                                iIntValue = num.intValue();
                            } else {
                                if (playbackData != null) {
                                    num2 = null;
                                } else {
                                    num2 = null;
                                }
                                if (num2 != null) {
                                    iIntValue = num2.intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            }
                        }
                    }
                    getDatabase().query(new ScrollNode$$ExternalSyntheticLambda2(mediaMetadata, song, iIntValue, b));
                    if (!getDatabase().hasRelatedSongs(str2)) {
                        YouTube youTube = YouTube.INSTANCE;
                        WatchEndpoint watchEndpoint = new WatchEndpoint(62, str2, null, null);
                        c01721.L$0 = str2;
                        c01721.L$1 = null;
                        c01721.L$2 = null;
                        c01721.I$0 = iIntValue;
                        c01721.label = 3;
                        objM1024next0E7RQCE = youTube.m1024next0E7RQCE(watchEndpoint, null, c01721);
                        if (objM1024next0E7RQCE != coroutineSingletons) {
                            str4 = str2;
                            if (objM1024next0E7RQCE instanceof Result.Failure) {
                                objM1024next0E7RQCE = null;
                            }
                            nextResult = (NextResult) objM1024next0E7RQCE;
                            if (nextResult != null) {
                                YouTube youTube2 = YouTube.INSTANCE;
                                c01721.L$0 = str4;
                                c01721.L$1 = null;
                                c01721.L$2 = null;
                                c01721.I$0 = iIntValue;
                                c01721.label = 4;
                                objM1031relatedgIAlus = youTube2.m1031relatedgIAlus(browseEndpoint, c01721);
                            }
                        }
                        return coroutineSingletons;
                    }
                }
                return unit;
            }
            if (i2 == 3) {
                int i3 = c01721.I$0;
                String str5 = c01721.L$0;
                ResultKt.throwOnFailure(objFirst);
                objM1024next0E7RQCE = ((Result) objFirst).value;
                iIntValue = i3;
                str4 = str5;
                if (objM1024next0E7RQCE instanceof Result.Failure) {
                    objM1024next0E7RQCE = null;
                }
                nextResult = (NextResult) objM1024next0E7RQCE;
                if (nextResult != null && (browseEndpoint = nextResult.relatedEndpoint) != null) {
                    YouTube youTube3 = YouTube.INSTANCE;
                    c01721.L$0 = str4;
                    c01721.L$1 = null;
                    c01721.L$2 = null;
                    c01721.I$0 = iIntValue;
                    c01721.label = 4;
                    objM1031relatedgIAlus = youTube3.m1031relatedgIAlus(browseEndpoint, c01721);
                }
                return unit;
            }
            if (i2 != 4) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str4 = c01721.L$0;
            ResultKt.throwOnFailure(objFirst);
            objM1031relatedgIAlus = ((Result) objFirst).value;
        }
        RelatedPage relatedPage = (RelatedPage) (objM1031relatedgIAlus instanceof Result.Failure ? null : objM1031relatedgIAlus);
        if (relatedPage != null) {
            getDatabase().query(new QuickJs$$ExternalSyntheticLambda1(relatedPage, str4, (byte) 22));
        }
        return unit;
        Song song2 = (Song) objFirst;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        HandlerContext handlerContext = MainDispatcherLoader.dispatcher;
        MusicService$onCreate$11$2$1 musicService$onCreate$11$2$1 = new MusicService$onCreate$11$2$1(this, str, objArr == true ? 1 : 0, b2);
        c01721.L$0 = str;
        c01721.L$1 = playbackData;
        c01721.L$2 = song2;
        c01721.label = 2;
        Object objWithContext = AwaitKt.withContext(handlerContext, musicService$onCreate$11$2$1, c01721);
        if (objWithContext != coroutineSingletons) {
            str2 = str;
            song = song2;
            objFirst = objWithContext;
            mediaMetadata = (MediaMetadata) objFirst;
            if (mediaMetadata == null) {
                if (song != null) {
                    if (mediaMetadata != null) {
                        num = new Integer(mediaMetadata.duration);
                        if (num.intValue() == -1) {
                            num = null;
                        }
                    } else {
                        num = null;
                    }
                    if (num != null) {
                        iIntValue = num.intValue();
                    } else {
                        if (playbackData != null) {
                            num2 = null;
                        } else {
                            num2 = null;
                        }
                        if (num2 != null) {
                            iIntValue = num2.intValue();
                        } else {
                            iIntValue = -1;
                        }
                    }
                } else {
                    if (mediaMetadata != null) {
                        num = new Integer(mediaMetadata.duration);
                        if (num.intValue() == -1) {
                            num = null;
                        }
                    } else {
                        num = null;
                    }
                    if (num != null) {
                        iIntValue = num.intValue();
                    } else {
                        if (playbackData != null) {
                            num2 = null;
                        } else {
                            num2 = null;
                        }
                        if (num2 != null) {
                            iIntValue = num2.intValue();
                        } else {
                            iIntValue = -1;
                        }
                    }
                }
                getDatabase().query(new ScrollNode$$ExternalSyntheticLambda2(mediaMetadata, song, iIntValue, b));
                if (!getDatabase().hasRelatedSongs(str2)) {
                    YouTube youTube4 = YouTube.INSTANCE;
                    WatchEndpoint watchEndpoint2 = new WatchEndpoint(62, str2, null, null);
                    c01721.L$0 = str2;
                    c01721.L$1 = null;
                    c01721.L$2 = null;
                    c01721.I$0 = iIntValue;
                    c01721.label = 3;
                    objM1024next0E7RQCE = youTube4.m1024next0E7RQCE(watchEndpoint2, null, c01721);
                    if (objM1024next0E7RQCE != coroutineSingletons) {
                        str4 = str2;
                        if (objM1024next0E7RQCE instanceof Result.Failure) {
                            objM1024next0E7RQCE = null;
                        }
                        nextResult = (NextResult) objM1024next0E7RQCE;
                        if (nextResult != null) {
                            YouTube youTube5 = YouTube.INSTANCE;
                            c01721.L$0 = str4;
                            c01721.L$1 = null;
                            c01721.L$2 = null;
                            c01721.I$0 = iIntValue;
                            c01721.label = 4;
                            objM1031relatedgIAlus = youTube5.m1031relatedgIAlus(browseEndpoint, c01721);
                        }
                    }
                }
            } else {
                if (song != null) {
                    if (mediaMetadata != null) {
                        num = new Integer(mediaMetadata.duration);
                        if (num.intValue() == -1) {
                            num = null;
                        }
                    } else {
                        num = null;
                    }
                    if (num != null) {
                        iIntValue = num.intValue();
                    } else {
                        if (playbackData != null) {
                            num2 = null;
                        } else {
                            num2 = null;
                        }
                        if (num2 != null) {
                            iIntValue = num2.intValue();
                        } else {
                            iIntValue = -1;
                        }
                    }
                } else {
                    if (mediaMetadata != null) {
                        num = new Integer(mediaMetadata.duration);
                        if (num.intValue() == -1) {
                            num = null;
                        }
                    } else {
                        num = null;
                    }
                    if (num != null) {
                        iIntValue = num.intValue();
                    } else {
                        if (playbackData != null) {
                            num2 = null;
                        } else {
                            num2 = null;
                        }
                        if (num2 != null) {
                            iIntValue = num2.intValue();
                        } else {
                            iIntValue = -1;
                        }
                    }
                }
                getDatabase().query(new ScrollNode$$ExternalSyntheticLambda2(mediaMetadata, song, iIntValue, b));
                if (!getDatabase().hasRelatedSongs(str2)) {
                    YouTube youTube6 = YouTube.INSTANCE;
                    WatchEndpoint watchEndpoint3 = new WatchEndpoint(62, str2, null, null);
                    c01721.L$0 = str2;
                    c01721.L$1 = null;
                    c01721.L$2 = null;
                    c01721.I$0 = iIntValue;
                    c01721.label = 3;
                    objM1024next0E7RQCE = youTube6.m1024next0E7RQCE(watchEndpoint3, null, c01721);
                    if (objM1024next0E7RQCE != coroutineSingletons) {
                        str4 = str2;
                        if (objM1024next0E7RQCE instanceof Result.Failure) {
                            objM1024next0E7RQCE = null;
                        }
                        nextResult = (NextResult) objM1024next0E7RQCE;
                        if (nextResult != null) {
                            YouTube youTube7 = YouTube.INSTANCE;
                            c01721.L$0 = str4;
                            c01721.L$1 = null;
                            c01721.L$2 = null;
                            c01721.I$0 = iIntValue;
                            c01721.label = 4;
                            objM1031relatedgIAlus = youTube7.m1031relatedgIAlus(browseEndpoint, c01721);
                        }
                    }
                }
            }
            return unit;
        }
        return coroutineSingletons;
    }

    public final void refreshStreamAndRetry(String str, String str2, String str3, boolean z) {
        Integer num = (Integer) this.currentMediaIdRetryCount.get(str);
        if ((num != null ? num.intValue() : 0) >= this.MAX_RETRY_PER_SONG) {
            Timber.Forest.tag("MusicService");
            ConnectionPool.w(new Object[0]);
            markSongAsFailed(str);
            handleFinalFailure();
            return;
        }
        incrementRetryCount(str);
        this.songUrlCache.invalidate(str);
        if (str2 != null) {
            InnerTubeXPlayer innerTubeXPlayer = InnerTubeXPlayer.INSTANCE;
            long jCurrentTimeMillis = System.currentTimeMillis();
            ConcurrentHashMap concurrentHashMap = InnerTubeXPlayer.streamClientFailures;
            final ListItemKt$$ExternalSyntheticLambda14 listItemKt$$ExternalSyntheticLambda14 = new ListItemKt$$ExternalSyntheticLambda14(jCurrentTimeMillis, str2);
            concurrentHashMap.compute(str, new BiFunction() { // from class: com.metrolist.music.utils.InnerTubeXPlayer$$ExternalSyntheticLambda5
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return (InnerTubeXPlayer.FailedStreamClients) listItemKt$$ExternalSyntheticLambda14.invoke(obj, obj2);
                }
            });
        }
        Timber.Forest.tag("MusicService");
        ConnectionPool.d(new Object[0]);
        ContextScope contextScope = this.scope;
        Continuation continuation = null;
        if (z) {
            AwaitKt.launch$default(contextScope, null, null, new DiscordRpcManager.C01441(2, continuation, (byte) 5), 3);
        }
        long currentPosition = this.player.getCurrentPosition();
        int currentMediaItemIndex = this.player.getCurrentMediaItemIndex();
        boolean playWhenReady = this.player.getPlayWhenReady();
        StandaloneCoroutine standaloneCoroutine = this.retryJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.retryJob = AwaitKt.launch$default(contextScope, null, null, new AnonymousClass3(str, currentMediaItemIndex, currentPosition, playWhenReady, str3, null), 3);
    }

    public final void releaseExoPlayer(ExoPlayerImpl exoPlayerImpl) {
        this.playerNormalizationProcessors.remove(exoPlayerImpl);
        this.playerSilenceProcessors.remove(exoPlayerImpl);
        CustomEqualizerAudioProcessor customEqualizerAudioProcessor = (CustomEqualizerAudioProcessor) this.playerEqualizerProcessors.remove(exoPlayerImpl);
        if (customEqualizerAudioProcessor != null) {
            EqualizerService equalizerService = this.equalizerService;
            if (equalizerService == null) {
                Intrinsics.throwUninitializedPropertyAccessException("equalizerService");
                throw null;
            }
            equalizerService.audioProcessors.remove(customEqualizerAudioProcessor);
        }
        exoPlayerImpl.release();
    }

    public final void saveEpisodePosition(long j, String str) {
        if (j < 3000) {
            return;
        }
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        AwaitKt.launch$default(this.scope, DefaultIoScheduler.INSTANCE.plus(CoroutineExtKt.SilentHandler), null, new MainActivity$MetrolistApp$4$1(this, str, j, (Continuation) null), 2);
    }

    public final void savePlayerStateToDisk() {
        Object failure;
        if (this.player.getMediaItemCount() == 0) {
            return;
        }
        boolean playWhenReady = this.player.getPlayWhenReady();
        ExoPlayerImpl exoPlayerImpl = this.player;
        exoPlayerImpl.verifyApplicationThread();
        int i = exoPlayerImpl.repeatMode;
        ExoPlayerImpl exoPlayerImpl2 = this.player;
        exoPlayerImpl2.verifyApplicationThread();
        PersistPlayerState persistPlayerState = new PersistPlayerState(playWhenReady, i, exoPlayerImpl2.shuffleModeEnabled, ((Number) ((StateFlowImpl) getPlayerVolume()).getValue()).floatValue(), this.player.getCurrentPosition(), this.player.getCurrentMediaItemIndex(), this.player.getPlaybackState(), 0L, 128, null);
        if (persistPlayerState.equals(this.lastSavedPlayerState)) {
            return;
        }
        try {
            File filesDir = getFilesDir();
            filesDir.getClass();
            FileOutputStream fileOutputStream = new FileOutputStream(FilesKt.resolve(filesDir, "persistent_player_state.data"));
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                try {
                    objectOutputStream.writeObject(persistPlayerState);
                    objectOutputStream.close();
                    fileOutputStream.close();
                    this.lastSavedPlayerState = persistPlayerState;
                    Timber.Forest.tag("MusicService");
                    ConnectionPool.d(new Object[0]);
                    failure = Unit.INSTANCE;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CharsKt.closeFinally(objectOutputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CharsKt.closeFinally(fileOutputStream, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            failure = new Result.Failure(th5);
        }
        Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(failure);
        if (thM1866exceptionOrNullimpl != null) {
            Timber.Forest.tag("MusicService");
            ConnectionPool.e$1(new Object[0]);
            thM1866exceptionOrNullimpl.printStackTrace();
        }
    }

    public final void saveQueueToDisk() {
        Object failure;
        Object failure2 = Unit.INSTANCE;
        if (this.player.getMediaItemCount() == 0) {
            Timber.Forest.tag("MusicService");
            ConnectionPool.d(new Object[0]);
            return;
        }
        try {
            Queue queue = this.currentQueue;
            String str = this.queueTitle;
            ExoPlayerImpl exoPlayerImpl = this.player;
            exoPlayerImpl.getClass();
            ReversedListReadOnly reversedListReadOnly = new ReversedListReadOnly((byte) 1, exoPlayerImpl);
            ArrayList arrayList = new ArrayList();
            UIntArray.Iterator iterator = new UIntArray.Iterator((byte) 5, reversedListReadOnly);
            while (iterator.hasNext()) {
                MediaMetadata metadata = UuidKt.getMetadata((MediaItem) iterator.next());
                if (metadata != null) {
                    arrayList.add(metadata);
                }
            }
            PersistQueue persistQueue = EntryPoints.toPersistQueue(queue, str, arrayList, this.player.getCurrentMediaItemIndex(), this.player.getCurrentPosition());
            String str2 = "automix";
            Iterable iterable = (Iterable) this.automixItems.getValue();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                MediaMetadata metadata2 = UuidKt.getMetadata((MediaItem) it.next());
                if (metadata2 != null) {
                    arrayList2.add(metadata2);
                }
            }
            PersistQueue persistQueue2 = new PersistQueue(str2, arrayList2, 0, 0L, null, null, 48, null);
            try {
                File filesDir = getFilesDir();
                filesDir.getClass();
                FileOutputStream fileOutputStream = new FileOutputStream(FilesKt.resolve(filesDir, "persistent_queue.data"));
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    try {
                        objectOutputStream.writeObject(persistQueue);
                        objectOutputStream.close();
                        fileOutputStream.close();
                        Timber.Forest.tag("MusicService");
                        ConnectionPool.d(new Object[0]);
                        failure = failure2;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CharsKt.closeFinally(objectOutputStream, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CharsKt.closeFinally(fileOutputStream, th3);
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                failure = new Result.Failure(th5);
            }
            Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(failure);
            if (thM1866exceptionOrNullimpl != null) {
                Timber.Forest.tag("MusicService");
                ConnectionPool.e$1(new Object[0]);
                thM1866exceptionOrNullimpl.printStackTrace();
            }
            try {
                File filesDir2 = getFilesDir();
                filesDir2.getClass();
                FileOutputStream fileOutputStream2 = new FileOutputStream(FilesKt.resolve(filesDir2, "persistent_automix.data"));
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream2);
                    try {
                        objectOutputStream2.writeObject(persistQueue2);
                        objectOutputStream2.close();
                        fileOutputStream2.close();
                        Timber.Forest.tag("MusicService");
                        ConnectionPool.d(new Object[0]);
                        Throwable thM1866exceptionOrNullimpl2 = Result.m1866exceptionOrNullimpl(failure2);
                        if (thM1866exceptionOrNullimpl2 != null) {
                            Timber.Forest.tag("MusicService");
                            ConnectionPool.e$1(new Object[0]);
                            thM1866exceptionOrNullimpl2.printStackTrace();
                        }
                    } catch (Throwable th6) {
                        try {
                            throw th6;
                        } catch (Throwable th7) {
                            CharsKt.closeFinally(objectOutputStream2, th6);
                            throw th7;
                        }
                    }
                } catch (Throwable th8) {
                    try {
                        throw th8;
                    } catch (Throwable th9) {
                        CharsKt.closeFinally(fileOutputStream2, th8);
                        throw th9;
                    }
                }
            } catch (Throwable th10) {
                failure2 = new Result.Failure(th10);
            }
        } catch (Exception e) {
            Timber.Forest.tag("MusicService");
            ConnectionPool.e$1(new Object[0]);
            e.printStackTrace();
        }
    }

    public final void scheduleCrossfade() {
        MediaItem currentMediaItem;
        androidx.media3.common.MediaMetadata mediaMetadata;
        int nextMediaItemIndex;
        PlayerMessage playerMessage = this.crossfadeMessage;
        if (playerMessage != null) {
            playerMessage.cancel();
        }
        this.crossfadeMessage = null;
        float f = this.crossfadeDuration;
        long j = (long) f;
        if (!this.crossfadeEnabled || f <= CropImageView.DEFAULT_ASPECT_RATIO || this.player.getDuration() == -9223372036854775807L || this.player.getDuration() <= j) {
            return;
        }
        if (this.crossfadeGapless && (currentMediaItem = this.player.getCurrentMediaItem()) != null && (mediaMetadata = currentMediaItem.mediaMetadata) != null && (nextMediaItemIndex = this.player.getNextMediaItemIndex()) != -1) {
            androidx.media3.common.MediaMetadata mediaMetadata2 = this.player.getMediaItemAt(nextMediaItemIndex).mediaMetadata;
            mediaMetadata2.getClass();
            CharSequence charSequence = mediaMetadata.albumTitle;
            if (charSequence != null && charSequence.equals(mediaMetadata2.albumTitle)) {
                return;
            }
        }
        if (!this.player.hasNextMediaItem()) {
            ExoPlayerImpl exoPlayerImpl = this.player;
            exoPlayerImpl.verifyApplicationThread();
            if (exoPlayerImpl.repeatMode != 1) {
                return;
            }
        }
        long duration = this.player.getDuration() - j;
        if (duration - this.player.getCurrentPosition() <= 0) {
            return;
        }
        MediaItem currentMediaItem2 = this.player.getCurrentMediaItem();
        String str = currentMediaItem2 != null ? currentMediaItem2.mediaId : null;
        ExoPlayerImpl exoPlayerImpl2 = this.player;
        TextLinkScope$$ExternalSyntheticLambda10 textLinkScope$$ExternalSyntheticLambda10 = new TextLinkScope$$ExternalSyntheticLambda10((Object) this, (Object) str, (byte) 24);
        exoPlayerImpl2.verifyApplicationThread();
        PlayerMessage playerMessageCreateMessageInternal = exoPlayerImpl2.createMessageInternal(textLinkScope$$ExternalSyntheticLambda10);
        Looper mainLooper = Looper.getMainLooper();
        coil3.util.UtilsKt.checkState(!playerMessageCreateMessageInternal.isSent);
        playerMessageCreateMessageInternal.looper = mainLooper;
        coil3.util.UtilsKt.checkState(!playerMessageCreateMessageInternal.isSent);
        playerMessageCreateMessageInternal.positionMs = duration;
        playerMessageCreateMessageInternal.send();
        this.crossfadeMessage = playerMessageCreateMessageInternal;
    }

    public final void setupAudioNormalization() {
        long j = this.loudnessSetupGeneration + 1;
        this.loudnessSetupGeneration = j;
        StandaloneCoroutine standaloneCoroutine = this.loudnessSetupJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.loudnessSetupJob = AwaitKt.launch$default(this.scope, null, null, new C01731(j, this, null), 3);
    }

    public final void skipOnError() {
        this.consecutivePlaybackErr += 2;
        int nextMediaItemIndex = this.player.getNextMediaItemIndex();
        if (this.consecutivePlaybackErr > 5 || nextMediaItemIndex == -1) {
            this.player.setPlayWhenReady(false);
            this.consecutivePlaybackErr = 0;
            return;
        }
        this.player.seekTo(nextMediaItemIndex, -9223372036854775807L, false);
        this.player.prepare();
        CastConnectionHandler castConnectionHandler = this.castConnectionHandler;
        if (castConnectionHandler == null || !((Boolean) castConnectionHandler.isCasting.getValue()).booleanValue()) {
            this.player.setPlayWhenReady(true);
        }
    }

    public final boolean startForegroundSafely(Notification notification, boolean z) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                startForeground(888, notification, 2);
                return true;
            }
            startForeground(888, notification);
            return true;
        } catch (ForegroundServiceStartNotAllowedException unused) {
            Timber.Forest.tag("MusicService");
            ConnectionPool.w$1(new Object[0]);
            if (z) {
                stopSelf();
            }
            return false;
        } catch (Exception e) {
            Timber.Forest.tag("MusicService");
            ConnectionPool.e$1(new Object[0]);
            e.printStackTrace();
            if (z) {
                stopSelf();
            }
            return false;
        }
    }

    public final void startRadioSeamlessly() {
        if (!((Boolean) this.playerInitialized.getValue()).booleanValue()) {
            Timber.Forest.tag("MusicService");
            ConnectionPool.w(new Object[0]);
            return;
        }
        MediaMetadata currentMetadata = IntMath.getCurrentMetadata(this.player);
        if (currentMetadata == null) {
            return;
        }
        int currentMediaItemIndex = this.player.getCurrentMediaItemIndex();
        String str = currentMetadata.id;
        AwaitKt.launch$default(this.scope, CoroutineExtKt.SilentHandler, null, new C01741(str, this, currentMediaItemIndex, null), 2);
    }

    public final void startWidgetUpdates() {
        StandaloneCoroutine standaloneCoroutine = this.widgetUpdateJob;
        Continuation continuation = null;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        if (this.isScreenOff) {
            this.widgetUpdateJob = null;
        } else {
            this.widgetUpdateJob = AwaitKt.launch$default(this.scope, null, null, new AnonymousClass37((byte) 3, this, continuation), 3);
        }
    }

    public final void syncDiscordState() {
        if (this.discordRpcEnabled) {
            MediaMetadata currentMetadata = IntMath.getCurrentMetadata(this.player);
            Continuation continuation = null;
            String str = currentMetadata != null ? currentMetadata.id : null;
            if (str == null) {
                Timber.Forest.tag("DiscordSvc");
                ConnectionPool.d(new Object[0]);
                DiscordRpcManager.INSTANCE.clear();
                return;
            }
            DiscordRpcManager discordRpcManager = DiscordRpcManager.INSTANCE;
            if (discordRpcManager.isReady()) {
                boolean zIsPlaying = this.player.isPlaying();
                if (discordRpcManager.isShowingSong(str, zIsPlaying)) {
                    Timber.Forest.tag("DiscordSvc");
                    ConnectionPool.d(str, Boolean.valueOf(zIsPlaying));
                    return;
                } else {
                    ContextScope contextScope = this.scope;
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    AwaitKt.launch$default(contextScope, DefaultIoScheduler.INSTANCE, null, new Updater$getLatestRelease$2(this, (Continuation) null), 2);
                    return;
                }
            }
            if (this.discordIntentionalDisconnect) {
                Timber.Forest.tag("DiscordSvc");
                ConnectionPool.d(new Object[0]);
                return;
            }
            String accessToken = discordRpcManager.getAccessToken();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (accessToken == null || jCurrentTimeMillis - this.lastDiscordReconnectAttemptAtMs <= 30000) {
                return;
            }
            this.lastDiscordReconnectAttemptAtMs = jCurrentTimeMillis;
            Timber.Forest.tag("DiscordSvc");
            ConnectionPool.i(new Object[0]);
            ContextScope contextScope2 = this.scope;
            DefaultScheduler defaultScheduler2 = Dispatchers.Default;
            AwaitKt.launch$default(contextScope2, DefaultIoScheduler.INSTANCE, null, new MusicService$onCreate$11$2$1(this, accessToken, continuation, (byte) 3), 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x008a A[PHI: r1 r8
      0x008a: PHI (r1v2 ??) = (r1v12 ??), (r1v13 ??) binds: [B:19:0x006a, B:24:0x0085] A[DONT_GENERATE, DONT_INLINE]
      0x008a: PHI (r8v1 com.metrolist.music.db.entities.SongEntity) = (r8v0 com.metrolist.music.db.entities.SongEntity), (r8v4 com.metrolist.music.db.entities.SongEntity) binds: [B:19:0x006a, B:24:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:29:0x008f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0093  */
    /* JADX WARN: Code duplicated, block: B:34:0x009a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v9 */
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
    public final Object toggleEpisodeSaveForLater(SongEntity songEntity, ContinuationImpl continuationImpl) {
        C01751 c01751;
        boolean z;
        ?? r1;
        String str;
        ?? r2;
        SyncUtils syncUtils;
        ?? r3;
        if (continuationImpl instanceof C01751) {
            c01751 = (C01751) continuationImpl;
            int i = c01751.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01751.label = i - Integer.MIN_VALUE;
            } else {
                c01751 = new C01751(continuationImpl);
            }
        } else {
            c01751 = new C01751(continuationImpl);
        }
        Object setVideoId = c01751.result;
        int i2 = c01751.label;
        boolean z2 = false;
        if (i2 == 0) {
            ResultKt.throwOnFailure(setVideoId);
            boolean z3 = songEntity.inLibrary != null;
            z = !z3;
            updateNotification(Boolean.valueOf(z));
            updateWidgetUI(this.player.isPlaying(), Boolean.valueOf(z));
            getDatabase().query(new MusicService$$ExternalSyntheticLambda7(songEntity, z3, z2 ? 1 : 0));
            this.currentMediaMetadata.setValue(IntMath.getCurrentMetadata(this.player));
            r1 = z;
            if (z3) {
                MusicDatabase database = getDatabase();
                String str2 = songEntity.id;
                c01751.L$0 = songEntity;
                c01751.I$1 = z ? 1 : 0;
                c01751.label = 1;
                setVideoId = database.$$delegate_0.getSetVideoId(str2, c01751);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (setVideoId == coroutineSingletons) {
                    r3 = z;
                    return coroutineSingletons;
                }
            } else {
                str = null;
                r2 = r1;
            }
            syncUtils = this.syncUtils;
            if (syncUtils != null) {
                syncUtils.saveEpisode(songEntity.id, str, r2 != 0);
                return Unit.INSTANCE;
            }
            Intrinsics.throwUninitializedPropertyAccessException("syncUtils");
            throw null;
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        int i3 = c01751.I$1;
        SongEntity songEntity2 = c01751.L$0;
        ResultKt.throwOnFailure(setVideoId);
        r3 = i3;
        songEntity = songEntity2;
        r3 = z;
        SetVideoIdEntity setVideoIdEntity = (SetVideoIdEntity) setVideoId;
        r1 = r3;
        if (setVideoIdEntity != null) {
            str = setVideoIdEntity.setVideoId;
            r2 = r3;
        } else {
            str = null;
            r2 = r1;
        }
        syncUtils = this.syncUtils;
        if (syncUtils != null) {
            syncUtils.saveEpisode(songEntity.id, str, r2 != 0);
            return Unit.INSTANCE;
        }
        Intrinsics.throwUninitializedPropertyAccessException("syncUtils");
        throw null;
    }

    public final void toggleLike() {
        AwaitKt.launch$default(this.scope, null, null, new C01761((byte) 0, this, null), 3);
    }

    public final void triggerRetry() {
        Boolean bool = Boolean.FALSE;
        StateFlowImpl stateFlowImpl = this.waitingForNetworkConnection;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, bool);
        StandaloneCoroutine standaloneCoroutine = this.retryJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        boolean z = this.pausedDueToNetworkError;
        this.pausedDueToNetworkError = false;
        if (this.player.getCurrentMediaItem() != null) {
            if (this.retryCount > 3) {
                Timber.Forest.tag("MusicService");
                ConnectionPool.d(new Object[0]);
                long currentPosition = this.player.getCurrentPosition();
                ExoPlayerImpl exoPlayerImpl = this.player;
                exoPlayerImpl.seekTo(exoPlayerImpl.getCurrentMediaItemIndex(), currentPosition, false);
            }
            this.player.prepare();
            if (z) {
                this.player.setPlayWhenReady(true);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x049e  */
    /* JADX WARN: Code duplicated, block: B:103:0x04a4  */
    /* JADX WARN: Code duplicated, block: B:105:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:108:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:109:0x04b8  */
    /* JADX WARN: Code duplicated, block: B:113:0x052a  */
    /* JADX WARN: Code duplicated, block: B:116:0x056f  */
    /* JADX WARN: Code duplicated, block: B:117:0x0574  */
    /* JADX WARN: Code duplicated, block: B:121:0x0586  */
    /* JADX WARN: Code duplicated, block: B:123:0x0589  */
    /* JADX WARN: Code duplicated, block: B:124:0x0596  */
    /* JADX WARN: Code duplicated, block: B:126:0x0599  */
    /* JADX WARN: Code duplicated, block: B:128:0x05a2  */
    /* JADX WARN: Code duplicated, block: B:130:0x05aa  */
    /* JADX WARN: Code duplicated, block: B:132:0x05ad  */
    /* JADX WARN: Code duplicated, block: B:133:0x05ba  */
    /* JADX WARN: Code duplicated, block: B:138:0x05ce  */
    /* JADX WARN: Code duplicated, block: B:143:0x05eb  */
    /* JADX WARN: Code duplicated, block: B:144:0x05ed  */
    /* JADX WARN: Code duplicated, block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    /* JADX WARN: Code duplicated, block: B:83:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:98:0x0473  */
    public final Object updateDiscordRPC(Song song, boolean z, ContinuationImpl continuationImpl) throws IOException {
        C01771 c01771;
        long j;
        boolean z2;
        Object objWithContext;
        Long l;
        String str;
        String str2;
        long j2;
        String str3;
        String str4;
        String str5;
        String str6;
        PresenceStatus presenceStatus;
        CoroutineSingletons coroutineSingletons;
        boolean z3;
        String str7;
        float f;
        int i;
        boolean z4;
        long j3;
        String str8;
        long j4;
        boolean z5;
        Object obj;
        PresenceStatus presenceStatus2;
        String str9;
        Song song2;
        long j5;
        Song song3;
        boolean z6;
        long j6;
        String strJoinToString$default;
        AlbumEntity albumEntity;
        String str10;
        ArtistEntity artistEntity;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        boolean z7;
        int i2;
        Object objWithContext2;
        CoroutineSingletons coroutineSingletons2;
        int i3;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        Song song4;
        String str22;
        String str23;
        String str24;
        String str25;
        boolean z8;
        boolean z9;
        boolean z10;
        String str26;
        Song song5;
        PresenceStatus presenceStatus3;
        long jLongValue;
        float fFloatValue;
        boolean zBooleanValue;
        long j7;
        long jCurrentTimeMillis;
        long j8;
        Integer num;
        Long l2;
        Long l3;
        Long l4;
        Long l5;
        long jLongValue2;
        MusicService musicService = this;
        Song song6 = song;
        PresenceStatus presenceStatus4 = PresenceStatus.Online;
        Unit unit = Unit.INSTANCE;
        if (continuationImpl instanceof C01771) {
            c01771 = (C01771) continuationImpl;
            int i4 = c01771.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c01771.label = i4 - Integer.MIN_VALUE;
            } else {
                c01771 = musicService.new C01771(continuationImpl);
            }
        } else {
            c01771 = musicService.new C01771(continuationImpl);
        }
        Object obj2 = c01771.result;
        CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i5 = c01771.label;
        if (i5 != 0) {
            if (i5 == 1) {
                j = 0;
                boolean z11 = c01771.Z$0;
                Song song7 = c01771.L$0;
                ResultKt.throwOnFailure(obj2);
                z2 = z11;
                song6 = song7;
                objWithContext = obj2;
            } else {
                if (i5 == 2) {
                    j = 0;
                    boolean z12 = c01771.Z$3;
                    boolean z13 = c01771.Z$2;
                    int i6 = c01771.I$0;
                    boolean z14 = c01771.Z$1;
                    long j9 = c01771.J$3;
                    long j10 = c01771.J$2;
                    long j11 = c01771.J$1;
                    float f2 = c01771.F$0;
                    z5 = z12;
                    obj = obj2;
                    long j12 = c01771.J$0;
                    boolean z15 = c01771.Z$0;
                    PresenceStatus presenceStatus5 = c01771.L$18;
                    String str27 = c01771.L$15;
                    String str28 = c01771.L$14;
                    String str29 = c01771.L$13;
                    String str30 = c01771.L$12;
                    String str31 = c01771.L$11;
                    String str32 = c01771.L$10;
                    String str33 = c01771.L$9;
                    String str34 = c01771.L$7;
                    Song song8 = c01771.L$0;
                    ResultKt.throwOnFailure(obj);
                    j3 = j10;
                    coroutineSingletons = coroutineSingletons3;
                    str5 = str31;
                    str2 = str34;
                    song2 = song8;
                    str9 = str29;
                    str3 = str33;
                    z3 = z14;
                    z2 = z15;
                    i = i6;
                    presenceStatus2 = presenceStatus5;
                    z4 = z13;
                    j5 = j12;
                    str7 = str27;
                    f = f2;
                    str8 = str30;
                    j4 = j11;
                    str6 = str28;
                    str4 = str32;
                    j2 = j9;
                    song3 = (Song) obj;
                    if (song3 != null && DiscordRpcManager.INSTANCE.isReady()) {
                        j6 = j5;
                        if (musicService.discordRpcEnabled) {
                            Timber.Forest.tag("DiscordSvc");
                            ConnectionPool.i(new Object[0]);
                            strJoinToString$default = CollectionsKt.joinToString$default(song3.artists, null, null, null, new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 1), 31);
                            if (strJoinToString$default.length() == 0) {
                                strJoinToString$default = "Unknown Artist";
                            }
                            albumEntity = song3.album;
                            if (albumEntity != null) {
                                str10 = albumEntity.title;
                            } else {
                                str10 = null;
                            }
                            boolean z16 = z2;
                            artistEntity = (ArtistEntity) CollectionsKt.firstOrNull(song3.artists);
                            if (artistEntity != null) {
                                str11 = artistEntity.thumbnailUrl;
                            } else {
                                str11 = null;
                            }
                            DefaultScheduler defaultScheduler = Dispatchers.Default;
                            str12 = str11;
                            HandlerContext handlerContext = MainDispatcherLoader.dispatcher.immediate;
                            str13 = str10;
                            str14 = strJoinToString$default;
                            AnonymousClass15 anonymousClass15 = new AnonymousClass15((byte) 7, musicService, null);
                            c01771.L$0 = song2;
                            c01771.L$7 = str2;
                            c01771.L$9 = str3;
                            c01771.L$10 = str4;
                            c01771.L$11 = str5;
                            c01771.L$12 = str8;
                            c01771.L$13 = str9;
                            c01771.L$14 = str6;
                            c01771.L$15 = str7;
                            c01771.L$18 = presenceStatus2;
                            c01771.L$19 = song3;
                            c01771.L$20 = str14;
                            c01771.L$21 = str13;
                            c01771.L$22 = str12;
                            c01771.Z$0 = z16;
                            str15 = str9;
                            c01771.J$0 = j6;
                            c01771.F$0 = f;
                            c01771.J$1 = j4;
                            c01771.J$2 = j3;
                            c01771.J$3 = j2;
                            z7 = z3;
                            c01771.Z$1 = z7;
                            i2 = i;
                            c01771.I$0 = i2;
                            c01771.Z$2 = z4;
                            c01771.Z$3 = z5;
                            c01771.label = 3;
                            objWithContext2 = AwaitKt.withContext(handlerContext, anonymousClass15, c01771);
                            coroutineSingletons2 = coroutineSingletons;
                            if (objWithContext2 == coroutineSingletons2) {
                                return coroutineSingletons2;
                            }
                            i3 = i2;
                            str16 = str12;
                            str17 = str13;
                            str18 = str2;
                            str19 = str5;
                            str20 = str7;
                            str21 = str3;
                            song4 = song2;
                            str22 = str6;
                            str23 = str4;
                            str24 = str8;
                            str25 = str15;
                            z8 = z7;
                            z9 = z5;
                            z10 = z4;
                            str26 = str14;
                            song5 = song3;
                            presenceStatus3 = presenceStatus2;
                            obj2 = objWithContext2;
                        }
                    }
                    Timber.Forest.tag("DiscordSvc");
                    if (song3 != null) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    ConnectionPool.i(Boolean.valueOf(z6));
                    return unit;
                }
                if (i5 != 3) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                boolean z17 = c01771.Z$3;
                boolean z18 = c01771.Z$2;
                int i7 = c01771.I$0;
                boolean z19 = c01771.Z$1;
                String str35 = c01771.L$22;
                String str36 = c01771.L$21;
                String str37 = c01771.L$20;
                song5 = c01771.L$19;
                presenceStatus3 = c01771.L$18;
                String str38 = c01771.L$15;
                String str39 = c01771.L$14;
                j = 0;
                String str40 = c01771.L$13;
                String str41 = c01771.L$12;
                String str42 = c01771.L$11;
                String str43 = c01771.L$10;
                String str44 = c01771.L$9;
                String str45 = c01771.L$7;
                song4 = c01771.L$0;
                ResultKt.throwOnFailure(obj2);
                str19 = str42;
                str23 = str43;
                str21 = str44;
                str18 = str45;
                z10 = z18;
                i3 = i7;
                unit = unit;
                z8 = z19;
                str16 = str35;
                str17 = str36;
                str26 = str37;
                str24 = str41;
                str20 = str38;
                str22 = str39;
                str25 = str40;
                z9 = z17;
            }
            Triple triple = (Triple) obj2;
            jLongValue = ((Number) triple.first).longValue();
            fFloatValue = ((Number) triple.second).floatValue();
            zBooleanValue = ((Boolean) triple.third).booleanValue();
            j7 = (long) (jLongValue / fFloatValue);
            jCurrentTimeMillis = System.currentTimeMillis();
            if (zBooleanValue) {
                j8 = jCurrentTimeMillis - j7;
            } else {
                j8 = j;
            }
            num = new Integer(song5.song.duration);
            if (num.intValue() <= 0) {
                num = null;
            }
            if (num != null) {
                l2 = new Long(((long) num.intValue()) * 1000);
            } else {
                l2 = null;
            }
            if (l2 != null) {
                jLongValue2 = l2.longValue() - jLongValue;
                if (jLongValue2 < j) {
                    jLongValue2 = j;
                }
                l3 = new Long(jLongValue2);
            } else {
                l3 = null;
            }
            if (l3 != null) {
                l4 = new Long((long) (l3.longValue() / fFloatValue));
            } else {
                l4 = null;
            }
            if (zBooleanValue || l4 == null) {
                l5 = null;
            } else {
                l5 = new Long(l4.longValue() + jCurrentTimeMillis);
            }
            DiscordRpcManager.INSTANCE.setActivity(EntryPoints.build(song5, str26, str17, str16, str18, j8, l5, z8, i3, str21, str23, str19, z10, str24, str25, z9, str22, str20), song4.song.id, zBooleanValue, presenceStatus3);
            return unit;
        }
        Continuation continuation = null;
        j = 0;
        ResultKt.throwOnFailure(obj2);
        if (!DiscordRpcManager.INSTANCE.isReady()) {
            Timber.Forest.tag("DiscordSvc");
            ConnectionPool.w(new Object[0]);
            return unit;
        }
        if (!musicService.discordRpcEnabled) {
            Timber.Forest.tag("DiscordSvc");
            ConnectionPool.w(new Object[0]);
            return unit;
        }
        Timber.Forest.tag("DiscordSvc");
        ConnectionPool.i(song6.song.title, Boolean.valueOf(z));
        DefaultScheduler defaultScheduler2 = Dispatchers.Default;
        HandlerContext handlerContext2 = MainDispatcherLoader.dispatcher.immediate;
        AnonymousClass15 anonymousClass16 = new AnonymousClass15((byte) 6, musicService, continuation);
        c01771.L$0 = song6;
        z2 = z;
        c01771.Z$0 = z2;
        c01771.label = 1;
        objWithContext = AwaitKt.withContext(handlerContext2, anonymousClass16, c01771);
        if (objWithContext == coroutineSingletons3) {
            return coroutineSingletons3;
        }
        Pair pair = (Pair) objWithContext;
        long jLongValue3 = ((Number) pair.first).longValue();
        float fFloatValue2 = ((Number) pair.second).floatValue();
        long j13 = (long) (jLongValue3 / fFloatValue2);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        long j14 = z2 ? jCurrentTimeMillis2 - j13 : j;
        Integer num2 = new Integer(song6.song.duration);
        if (num2.intValue() <= 0) {
            num2 = null;
        }
        Long l6 = num2 != null ? new Long(((long) num2.intValue()) * 1000) : null;
        if (l6 != null) {
            long jLongValue4 = l6.longValue() - jLongValue3;
            if (jLongValue4 < j) {
                jLongValue4 = j;
            }
            l = new Long(jLongValue4);
        } else {
            l = null;
        }
        Long l7 = l != null ? new Long((long) (l.longValue() / fFloatValue2)) : null;
        Long l8 = (!z2 || l7 == null) ? null : new Long(l7.longValue() + jCurrentTimeMillis2);
        String strJoinToString$default2 = CollectionsKt.joinToString$default(song6.artists, null, null, null, new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 29), 31);
        String str46 = strJoinToString$default2.length() == 0 ? r2 : strJoinToString$default2;
        AlbumEntity albumEntity2 = song6.album;
        String str47 = albumEntity2 != null ? albumEntity2.title : null;
        SongEntity songEntity = song6.song;
        if (fFloatValue2 == 1.0f) {
            str = songEntity.title;
        } else {
            str = songEntity.title + " [" + String.format("%.2fx", Arrays.copyOf(new Object[]{new Float(fFloatValue2)}, 1)) + "]";
        }
        String str48 = str;
        ArtistEntity artistEntity2 = (ArtistEntity) CollectionsKt.firstOrNull(song6.artists);
        String str49 = artistEntity2 != null ? artistEntity2.thumbnailUrl : null;
        Boolean bool = (Boolean) UtilsKt.get(UtilsKt.getDataStore(musicService), PreferenceKeysKt.DiscordAdvancedModeKey, Boolean.FALSE);
        boolean zBooleanValue2 = bool.booleanValue();
        Song song9 = song6;
        Integer intOrNull = StringsKt__StringsJVMKt.toIntOrNull((String) UtilsKt.get(UtilsKt.getDataStore(musicService), PreferenceKeysKt.DiscordActivityTypeKey, "2"));
        int iIntValue = intOrNull != null ? intOrNull.intValue() : 2;
        String str50 = (String) UtilsKt.get(UtilsKt.getDataStore(musicService), PreferenceKeysKt.DiscordActivityNameKey, "");
        String str51 = (String) UtilsKt.get(UtilsKt.getDataStore(musicService), PreferenceKeysKt.DiscordStateTemplateKey, "{artist.name}");
        String str52 = (String) UtilsKt.get(UtilsKt.getDataStore(musicService), PreferenceKeysKt.DiscordDetailsTemplateKey, "{song.name}");
        DataStore dataStore = UtilsKt.getDataStore(musicService);
        Preferences$Key preferences$Key = PreferenceKeysKt.DiscordButton1EnabledKey;
        Boolean bool2 = Boolean.TRUE;
        boolean zBooleanValue3 = ((Boolean) UtilsKt.get(dataStore, preferences$Key, bool2)).booleanValue();
        String str53 = (String) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.DiscordButton1LabelKey, "Listen on YouTube Music");
        String str54 = (String) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.DiscordButton1UrlKey, "https://music.youtube.com/watch?v={song.id}");
        boolean zBooleanValue4 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.DiscordButton2EnabledKey, bool2)).booleanValue();
        String str55 = (String) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.DiscordButton2LabelKey, "DAPZ.DEV");
        String str56 = (String) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.DiscordButton2UrlKey, "https://www.tiktok.com/@dappxml29");
        ConnectionPool connectionPool = Timber.Forest;
        connectionPool.tag("DiscordSvc");
        ConnectionPool.d(bool, new Integer(iIntValue), str50, str51, str52);
        int i8 = iIntValue;
        DiscordActivity discordActivityBuild = EntryPoints.build(song9, str46, str47, str49, str48, j14, l8, zBooleanValue2, i8, str50, str51, str52, zBooleanValue3, str53, str54, zBooleanValue4, str55, str56);
        str2 = str48;
        j2 = j14;
        str3 = str50;
        str4 = str51;
        str5 = str52;
        str6 = str55;
        connectionPool.tag("DiscordSvc");
        ConnectionPool.i(new Integer(discordActivityBuild.activityType), discordActivityBuild.name, discordActivityBuild.state, discordActivityBuild.details, new Long(j2), new Long(l8 != null ? l8.longValue() : j), Boolean.valueOf(z2));
        String str57 = (String) UtilsKt.get(UtilsKt.getDataStore(this), PreferenceKeysKt.DiscordUserStatusKey, "online");
        if (Intrinsics.areEqual(str57, "idle")) {
            if (zBooleanValue2) {
                presenceStatus = PresenceStatus.Idle;
            } else {
                presenceStatus = presenceStatus4;
            }
        } else if (Intrinsics.areEqual(str57, "dnd") && zBooleanValue2) {
            presenceStatus = PresenceStatus.Dnd;
        } else {
            presenceStatus = presenceStatus4;
        }
        DiscordRpcManager.INSTANCE.setActivity(discordActivityBuild, song9.song.id, z2, presenceStatus);
        c01771.L$0 = song9;
        c01771.L$7 = str2;
        c01771.L$9 = str3;
        c01771.L$10 = str4;
        c01771.L$11 = str5;
        c01771.L$12 = str53;
        c01771.L$13 = str54;
        c01771.L$14 = str6;
        c01771.L$15 = str56;
        c01771.L$18 = presenceStatus;
        c01771.Z$0 = z2;
        c01771.J$0 = jLongValue3;
        c01771.F$0 = fFloatValue2;
        c01771.J$1 = j13;
        c01771.J$2 = jCurrentTimeMillis2;
        c01771.J$3 = j2;
        c01771.Z$1 = zBooleanValue2;
        c01771.I$0 = i8;
        c01771.Z$2 = zBooleanValue3;
        c01771.Z$3 = zBooleanValue4;
        c01771.label = 2;
        musicService = this;
        Object objFetchArtistThumbnail = musicService.fetchArtistThumbnail(song9, c01771);
        if (objFetchArtistThumbnail == coroutineSingletons3) {
            return coroutineSingletons3;
        }
        coroutineSingletons = coroutineSingletons3;
        z3 = zBooleanValue2;
        str7 = str56;
        f = fFloatValue2;
        i = i8;
        z4 = zBooleanValue3;
        j3 = jCurrentTimeMillis2;
        str8 = str53;
        j4 = j13;
        z5 = zBooleanValue4;
        obj = objFetchArtistThumbnail;
        presenceStatus2 = presenceStatus;
        str9 = str54;
        song2 = song9;
        j5 = jLongValue3;
        song3 = (Song) obj;
        if (song3 != null) {
            j6 = j5;
            if (musicService.discordRpcEnabled) {
                Timber.Forest.tag("DiscordSvc");
                ConnectionPool.i(new Object[0]);
                strJoinToString$default = CollectionsKt.joinToString$default(song3.artists, null, null, null, new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 1), 31);
                if (strJoinToString$default.length() == 0) {
                    strJoinToString$default = "Unknown Artist";
                }
                albumEntity = song3.album;
                if (albumEntity != null) {
                    str10 = albumEntity.title;
                } else {
                    str10 = null;
                }
                boolean z110 = z2;
                artistEntity = (ArtistEntity) CollectionsKt.firstOrNull(song3.artists);
                if (artistEntity != null) {
                    str11 = artistEntity.thumbnailUrl;
                } else {
                    str11 = null;
                }
                DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                str12 = str11;
                HandlerContext handlerContext3 = MainDispatcherLoader.dispatcher.immediate;
                str13 = str10;
                str14 = strJoinToString$default;
                AnonymousClass15 anonymousClass17 = new AnonymousClass15((byte) 7, musicService, null);
                c01771.L$0 = song2;
                c01771.L$7 = str2;
                c01771.L$9 = str3;
                c01771.L$10 = str4;
                c01771.L$11 = str5;
                c01771.L$12 = str8;
                c01771.L$13 = str9;
                c01771.L$14 = str6;
                c01771.L$15 = str7;
                c01771.L$18 = presenceStatus2;
                c01771.L$19 = song3;
                c01771.L$20 = str14;
                c01771.L$21 = str13;
                c01771.L$22 = str12;
                c01771.Z$0 = z110;
                str15 = str9;
                c01771.J$0 = j6;
                c01771.F$0 = f;
                c01771.J$1 = j4;
                c01771.J$2 = j3;
                c01771.J$3 = j2;
                z7 = z3;
                c01771.Z$1 = z7;
                i2 = i;
                c01771.I$0 = i2;
                c01771.Z$2 = z4;
                c01771.Z$3 = z5;
                c01771.label = 3;
                objWithContext2 = AwaitKt.withContext(handlerContext3, anonymousClass17, c01771);
                coroutineSingletons2 = coroutineSingletons;
                if (objWithContext2 == coroutineSingletons2) {
                    return coroutineSingletons2;
                }
                i3 = i2;
                str16 = str12;
                str17 = str13;
                str18 = str2;
                str19 = str5;
                str20 = str7;
                str21 = str3;
                song4 = song2;
                str22 = str6;
                str23 = str4;
                str24 = str8;
                str25 = str15;
                z8 = z7;
                z9 = z5;
                z10 = z4;
                str26 = str14;
                song5 = song3;
                presenceStatus3 = presenceStatus2;
                obj2 = objWithContext2;
                Triple triple2 = (Triple) obj2;
                jLongValue = ((Number) triple2.first).longValue();
                fFloatValue = ((Number) triple2.second).floatValue();
                zBooleanValue = ((Boolean) triple2.third).booleanValue();
                j7 = (long) (jLongValue / fFloatValue);
                jCurrentTimeMillis = System.currentTimeMillis();
                if (zBooleanValue) {
                    j8 = jCurrentTimeMillis - j7;
                } else {
                    j8 = j;
                }
                num = new Integer(song5.song.duration);
                if (num.intValue() <= 0) {
                    num = null;
                }
                if (num != null) {
                    l2 = new Long(((long) num.intValue()) * 1000);
                } else {
                    l2 = null;
                }
                if (l2 != null) {
                    jLongValue2 = l2.longValue() - jLongValue;
                    if (jLongValue2 < j) {
                        jLongValue2 = j;
                    }
                    l3 = new Long(jLongValue2);
                } else {
                    l3 = null;
                }
                if (l3 != null) {
                    l4 = new Long((long) (l3.longValue() / fFloatValue));
                } else {
                    l4 = null;
                }
                if (zBooleanValue) {
                    l5 = null;
                } else {
                    l5 = null;
                }
                DiscordRpcManager.INSTANCE.setActivity(EntryPoints.build(song5, str26, str17, str16, str18, j8, l5, z8, i3, str21, str23, str19, z10, str24, str25, z9, str22, str20), song4.song.id, zBooleanValue, presenceStatus3);
                return unit;
            }
        }
        Timber.Forest.tag("DiscordSvc");
        if (song3 != null) {
            z6 = true;
        } else {
            z6 = false;
        }
        ConnectionPool.i(Boolean.valueOf(z6));
        return unit;
    }

    public final void updateInitialBufferRecovery(int i) {
        MediaItem currentMediaItem = this.player.getCurrentMediaItem();
        Continuation continuation = null;
        String str = currentMediaItem != null ? currentMediaItem.mediaId : null;
        if (i != 2 || !this.player.getPlayWhenReady() || this.player.getCurrentPosition() >= 5000 || str == null || Intrinsics.areEqual(this.initialBufferRecoveryAttemptedMediaId, str)) {
            StandaloneCoroutine standaloneCoroutine = this.initialBufferRecoveryJob;
            if (standaloneCoroutine != null) {
                standaloneCoroutine.cancel(null);
            }
            this.initialBufferRecoveryJob = null;
            return;
        }
        StandaloneCoroutine standaloneCoroutine2 = this.initialBufferRecoveryJob;
        if (standaloneCoroutine2 == null || !standaloneCoroutine2.isActive()) {
            this.initialBufferRecoveryJob = AwaitKt.launch$default(this.scope, null, null, new MusicService$handleAlarmTrigger$2(this, str, continuation, (byte) 12), 3);
        }
    }

    public final void updateNotification(Boolean bool) {
        int i;
        int i2;
        MediaLibraryService.MediaLibrarySession mediaLibrarySession = this.mediaSession;
        if (mediaLibrarySession != null) {
            CommandButton.Builder builder = new CommandButton.Builder(0);
            ExoPlayerImpl exoPlayerImpl = this.player;
            exoPlayerImpl.verifyApplicationThread();
            builder.displayName = getString(exoPlayerImpl.shuffleModeEnabled ? R.string.action_shuffle_off : R.string.action_shuffle_on);
            ExoPlayerImpl exoPlayerImpl2 = this.player;
            exoPlayerImpl2.verifyApplicationThread();
            builder.iconResId = exoPlayerImpl2.shuffleModeEnabled ? R.drawable.shuffle_on : R.drawable.shuffle;
            builder.setSessionCommand(MediaSessionConstants.CommandToggleShuffle);
            CommandButton commandButtonBuild = builder.build();
            CommandButton.Builder builder2 = new CommandButton.Builder(0);
            Boolean bool2 = Boolean.TRUE;
            builder2.displayName = getString(Intrinsics.areEqual(bool, bool2) ? R.string.action_remove_like : R.string.action_like);
            builder2.iconResId = Intrinsics.areEqual(bool, bool2) ? R.drawable.ic_heart : R.drawable.ic_heart_outline;
            builder2.setSessionCommand(MediaSessionConstants.CommandToggleLike);
            ReadonlyStateFlow readonlyStateFlow = this.currentSong;
            builder2.enabled = readonlyStateFlow.$$delegate_0.getValue() != null;
            CommandButton commandButtonBuild2 = builder2.build();
            CommandButton.Builder builder3 = new CommandButton.Builder(0);
            ExoPlayerImpl exoPlayerImpl3 = this.player;
            exoPlayerImpl3.verifyApplicationThread();
            int i3 = exoPlayerImpl3.repeatMode;
            if (i3 == 0) {
                i = R.string.repeat_mode_off;
            } else if (i3 == 1) {
                i = R.string.repeat_mode_one;
            } else {
                if (i3 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                    return;
                }
                i = R.string.repeat_mode_all;
            }
            builder3.displayName = getString(i);
            ExoPlayerImpl exoPlayerImpl4 = this.player;
            exoPlayerImpl4.verifyApplicationThread();
            int i4 = exoPlayerImpl4.repeatMode;
            if (i4 == 0) {
                i2 = R.drawable.repeat;
            } else if (i4 == 1) {
                i2 = R.drawable.repeat_one_on;
            } else {
                if (i4 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                    return;
                }
                i2 = R.drawable.repeat_on;
            }
            builder3.iconResId = i2;
            builder3.setSessionCommand(MediaSessionConstants.CommandToggleRepeatMode);
            CommandButton commandButtonBuild3 = builder3.build();
            CommandButton.Builder builder4 = new CommandButton.Builder(0);
            builder4.displayName = getString(R.string.start_radio);
            builder4.iconResId = R.drawable.radio;
            builder4.setSessionCommand(MediaSessionConstants.CommandToggleStartRadio);
            builder4.enabled = readonlyStateFlow.$$delegate_0.getValue() != null;
            CommandButton commandButtonBuild4 = builder4.build();
            CommandButton.Builder builder5 = new CommandButton.Builder(0);
            builder5.displayName = getString(R.string.android_auto_target_playlist);
            builder5.iconResId = R.drawable.playlist_add;
            builder5.setSessionCommand(MediaSessionConstants.CommandAddToTargetPlaylist);
            builder5.enabled = readonlyStateFlow.$$delegate_0.getValue() != null;
            List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new CommandButton[]{commandButtonBuild, commandButtonBuild2, commandButtonBuild3, commandButtonBuild4, builder5.build()});
            MediaLibrarySessionImpl mediaLibrarySessionImpl = mediaLibrarySession.impl;
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) listListOf);
            mediaLibrarySessionImpl.customLayout = immutableListCopyOf;
            mediaLibrarySessionImpl.sessionLegacyStub.customLayout = immutableListCopyOf;
            mediaLibrarySessionImpl.dispatchRemoteControllerTaskWithoutReturn(new MediaSessionImpl$$ExternalSyntheticLambda1(immutableListCopyOf));
        }
    }

    public final void updateWidgetUI(boolean z, Boolean bool) {
        this.pendingWidgetUpdate = new Pair(Boolean.valueOf(z), bool);
        if (this.widgetUpdateInFlight) {
            return;
        }
        this.widgetUpdateInFlight = true;
        AwaitKt.launch$default(this.scope, null, null, new AnonymousClass2((byte) 21, this, null), 3);
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$onCreate$14, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass14 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public /* synthetic */ float F$0;
        public boolean label;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass14(Object obj, float f, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = obj;
            this.F$0 = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj2 = this.this$0;
            switch (b) {
                case 0:
                    AnonymousClass14 anonymousClass14 = new AnonymousClass14((MusicService) obj2, continuation, (byte) 0);
                    anonymousClass14.F$0 = ((Number) obj).floatValue();
                    return anonymousClass14;
                case 1:
                    AnonymousClass14 anonymousClass15 = new AnonymousClass14((ComposeScrollCaptureCallback) obj2, continuation, (byte) 1);
                    anonymousClass15.F$0 = ((Number) obj).floatValue();
                    return anonymousClass15;
                case 2:
                    return new AnonymousClass14((LensController) obj2, this.F$0, continuation, (byte) 2);
                default:
                    return new AnonymousClass14((BottomSheetState) obj2, this.F$0, continuation, (byte) 3);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    return ((AnonymousClass14) create(Float.valueOf(((Number) obj).floatValue()), (Continuation) obj2)).invokeSuspend(unit);
                case 1:
                    return ((AnonymousClass14) create(Float.valueOf(((Number) obj).floatValue()), (Continuation) obj2)).invokeSuspend(unit);
                case 2:
                    return ((AnonymousClass14) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                default:
                    return ((AnonymousClass14) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            Object obj2 = this.this$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (b) {
                case 0:
                    float f = this.F$0;
                    boolean z = this.label;
                    if (z) {
                        if (z) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass13 anonymousClass13 = new AnonymousClass13(f, (Continuation) null);
                    this.F$0 = f;
                    this.label = true;
                    return UtilsKt.safeDataStoreEdit((MusicService) obj2, anonymousClass13, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 1:
                    ComposeScrollCaptureCallback composeScrollCaptureCallback = (ComposeScrollCaptureCallback) obj2;
                    boolean z2 = this.label;
                    if (!z2) {
                        ResultKt.throwOnFailure(obj);
                        float f2 = this.F$0;
                        Object obj3 = composeScrollCaptureCallback.node.unmergedConfig.props.get(SemanticsActions.ScrollByOffset);
                        Function2 function2 = (Function2) (obj3 != null ? obj3 : null);
                        if (function2 == null) {
                            throw Fragment$5$$ExternalSyntheticOutline0.m$2("Required value was null.");
                        }
                        Offset offset = new Offset((((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
                        this.label = true;
                        obj = function2.invoke(offset, this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return new Float(Float.intBitsToFloat((int) (((Offset) obj).packedValue & 4294967295L)));
                case 2:
                    boolean z3 = this.label;
                    if (z3) {
                        if (z3) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = ((LensController) obj2).pos;
                    Float f3 = new Float(this.F$0);
                    this.label = true;
                    return animatable.snapTo(f3, this) == coroutineSingletons ? coroutineSingletons : unit;
                default:
                    boolean z4 = this.label;
                    if (z4) {
                        if (z4) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable2 = ((BottomSheetState) obj2).animatable;
                    Dp dp = new Dp(this.F$0);
                    this.label = true;
                    return animatable2.snapTo(dp, this) == coroutineSingletons ? coroutineSingletons : unit;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass14(Object obj, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = obj;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$onCreate$13, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass13 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId = 1;
        public /* synthetic */ float F$0;
        public /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass13(RenderScriptContext renderScriptContext, float f, Continuation continuation) {
            super(2, continuation);
            this.this$0 = renderScriptContext;
            this.F$0 = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    AnonymousClass13 anonymousClass13 = new AnonymousClass13((MusicService) this.this$0, continuation);
                    anonymousClass13.F$0 = ((Number) obj).floatValue();
                    return anonymousClass13;
                case 1:
                    AnonymousClass13 anonymousClass14 = new AnonymousClass13(this.F$0, continuation);
                    anonymousClass14.this$0 = obj;
                    return anonymousClass14;
                default:
                    return new AnonymousClass13((RenderScriptContext) this.this$0, this.F$0, continuation);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    ((AnonymousClass13) create(Float.valueOf(((Number) obj).floatValue()), (Continuation) obj2)).invokeSuspend(unit);
                    break;
                case 1:
                    ((AnonymousClass13) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(unit);
                    break;
                default:
                    ((AnonymousClass13) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    break;
            }
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    float f = this.F$0;
                    ResultKt.throwOnFailure(obj);
                    MusicService musicService = (MusicService) this.this$0;
                    if (!musicService.isCrossfading) {
                        musicService.player.setVolume(f);
                    }
                    break;
                case 1:
                    MutablePreferences mutablePreferences = (MutablePreferences) this.this$0;
                    ResultKt.throwOnFailure(obj);
                    mutablePreferences.set(PreferenceKeysKt.PlayerVolumeKey, new Float(this.F$0));
                    break;
                default:
                    ResultKt.throwOnFailure(obj);
                    RenderScriptContext renderScriptContext = (RenderScriptContext) this.this$0;
                    float f2 = this.F$0;
                    Allocation allocation = renderScriptContext.outputAlloc;
                    ScriptIntrinsicBlur scriptIntrinsicBlur = renderScriptContext.blurScript;
                    if (!renderScriptContext.isDestroyed) {
                        if (f2 > 25.0f) {
                            f2 = 25.0f;
                        }
                        scriptIntrinsicBlur.setRadius(f2);
                        scriptIntrinsicBlur.forEach(allocation);
                        if (!renderScriptContext.isDestroyed) {
                            allocation.copyTo(renderScriptContext.outputBitmap);
                        }
                    }
                    break;
            }
            return unit;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass13(MusicService musicService, Continuation continuation) {
            super(2, continuation);
            this.this$0 = musicService;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass13(float f, Continuation continuation) {
            super(2, continuation);
            this.F$0 = f;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$playQueue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01701 extends SuspendLambda implements Function2 {
        public final /* synthetic */ boolean $playWhenReady;
        public final /* synthetic */ Object $queue;
        public final /* synthetic */ byte $r8$classId = 1;
        public boolean label;
        public Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01701(Animatable animatable, boolean z, AnimationSpec animationSpec, Continuation continuation) {
            super(2, continuation);
            this.this$0 = animatable;
            this.$playWhenReady = z;
            this.$queue = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            boolean z = this.$playWhenReady;
            Object obj2 = this.$queue;
            switch (b) {
                case 0:
                    return new C01701((MusicService) this.this$0, (Queue) obj2, continuation, z);
                case 1:
                    return new C01701((Animatable) this.this$0, z, (AnimationSpec) obj2, continuation);
                case 2:
                    return new C01701(z, (FocusRequester) this.this$0, (SoftwareKeyboardController) obj2, continuation);
                default:
                    return new C01701((HomeViewModel) obj2, z, continuation);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
            return ((C01701) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            StateFlowImpl stateFlowImpl;
            Object objFirst;
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            boolean z = this.$playWhenReady;
            Object obj2 = this.$queue;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            Continuation continuation = null;
            switch (b) {
                case 0:
                    MusicService musicService = (MusicService) this.this$0;
                    boolean z2 = this.label;
                    byte b2 = 4;
                    if (!z2) {
                        ResultKt.throwOnFailure(obj);
                        StateFlowImpl stateFlowImpl2 = musicService.playerInitialized;
                        DiscordRpcManager.C01441 c01441 = new DiscordRpcManager.C01441(2, continuation, b2);
                        this.label = true;
                        if (StateFlowKt.first(stateFlowImpl2, c01441, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    MusicService.playQueue$default(musicService, (Queue) obj2, z, 4);
                    return unit;
                case 1:
                    boolean z3 = this.label;
                    if (z3) {
                        if (z3) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = (Animatable) this.this$0;
                    float f = z ? 1.0f : 0.8f;
                    this.label = true;
                    return Animatable.animateTo$default(animatable, new Float(f), (AnimationSpec) obj2, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
                case 2:
                    boolean z4 = this.label;
                    if (!z4) {
                        ResultKt.throwOnFailure(obj);
                        if (z) {
                            return unit;
                        }
                        this.label = true;
                        if (AwaitKt.delay(100L, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    try {
                        FocusRequester.m415requestFocus3ESFkO8$default((FocusRequester) this.this$0);
                        SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) obj2;
                        if (softwareKeyboardController == null) {
                            return unit;
                        }
                        ((DelegatingSoftwareKeyboardController) softwareKeyboardController).show();
                        return unit;
                    } catch (Exception unused) {
                        return unit;
                    }
                default:
                    boolean z5 = this.label;
                    if (!z5) {
                        ResultKt.throwOnFailure(obj);
                        HomeViewModel homeViewModel = (HomeViewModel) obj2;
                        stateFlowImpl = homeViewModel.forgottenFavorites;
                        Flow flowForgottenFavorites = homeViewModel.database.forgottenFavorites(System.currentTimeMillis());
                        this.this$0 = stateFlowImpl;
                        this.label = true;
                        objFirst = StateFlowKt.first(flowForgottenFavorites, this);
                        if (objFirst == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z5) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        stateFlowImpl = (StateFlowImpl) this.this$0;
                        ResultKt.throwOnFailure(obj);
                        objFirst = obj;
                    }
                    List mutableList = CollectionsKt.toMutableList((Iterable) CollectionsKt__IterablesKt.filterVideoSongs((List) objFirst, z));
                    Collections.shuffle(mutableList);
                    List listTake = CollectionsKt.take(mutableList, 20);
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, listTake);
                    return unit;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01701(MusicService musicService, Queue queue, Continuation continuation, boolean z) {
            super(2, continuation);
            this.this$0 = musicService;
            this.$queue = queue;
            this.$playWhenReady = z;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01701(HomeViewModel homeViewModel, boolean z, Continuation continuation) {
            super(2, continuation);
            this.$queue = homeViewModel;
            this.$playWhenReady = z;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01701(boolean z, FocusRequester focusRequester, SoftwareKeyboardController softwareKeyboardController, Continuation continuation) {
            super(2, continuation);
            this.$playWhenReady = z;
            this.this$0 = focusRequester;
            this.$queue = softwareKeyboardController;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.MusicService$onCreate$19, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass19 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId = 0;
        public /* synthetic */ Object L$0;
        public Object L$1;
        public boolean Z$0;
        public byte label;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass19(SyncUtils syncUtils, boolean z, String str, String str2, Continuation continuation) {
            super(2, continuation);
            this.L$1 = syncUtils;
            this.Z$0 = z;
            this.L$0 = str;
            this.this$0 = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj2 = this.this$0;
            switch (b) {
                case 0:
                    AnonymousClass19 anonymousClass19 = new AnonymousClass19((MusicService) obj2, continuation);
                    anonymousClass19.L$0 = obj;
                    return anonymousClass19;
                case 1:
                    return new AnonymousClass19(this.Z$0, (LazyLayoutItemAnimation) this.L$1, (FiniteAnimationSpec) this.L$0, (GraphicsLayer) obj2, continuation);
                default:
                    return new AnonymousClass19((SyncUtils) this.L$1, this.Z$0, (String) this.L$0, (String) obj2, continuation);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    return ((AnonymousClass19) create((Pair) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 1:
                    return ((AnonymousClass19) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                default:
                    return ((AnonymousClass19) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            }
        }

        /* JADX WARN: Code duplicated, block: B:27:0x007b  */
        /* JADX WARN: Code duplicated, block: B:35:0x00a0  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objFirst;
            boolean z;
            MediaMetadata mediaMetadata;
            Object lyrics;
            Object objAnimateTo$default;
            Object objIsLoggedIn;
            Object objM1522withRetryBWLJW6A;
            Object objM1522withRetryBWLJW6A2;
            byte b = this.$r8$classId;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            Object obj2 = this.this$0;
            Unit unit = Unit.INSTANCE;
            byte b2 = 0;
            Continuation continuation = null;
            switch (b) {
                case 0:
                    MusicService musicService = (MusicService) obj2;
                    Pair pair = (Pair) this.L$0;
                    byte b3 = this.label;
                    if (b3 != 0) {
                        if (b3 == 1) {
                            boolean z2 = this.Z$0;
                            MediaMetadata mediaMetadata2 = (MediaMetadata) this.L$1;
                            ResultKt.throwOnFailure(obj);
                            z = z2;
                            mediaMetadata = mediaMetadata2;
                            objFirst = obj;
                        } else {
                            if (b3 != 2) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            mediaMetadata = (MediaMetadata) this.L$1;
                            ResultKt.throwOnFailure(obj);
                            lyrics = obj;
                        }
                        musicService.getDatabase().query(new MusicService$onCreate$19$$ExternalSyntheticLambda0(mediaMetadata, (LyricsWithProvider) lyrics, b2));
                        return unit;
                    }
                    ResultKt.throwOnFailure(obj);
                    MediaMetadata mediaMetadata3 = (MediaMetadata) pair.first;
                    boolean zBooleanValue = ((Boolean) pair.second).booleanValue();
                    if (zBooleanValue && mediaMetadata3 != null) {
                        MusicDatabase database = musicService.getDatabase();
                        Flow flowLyrics = database.$$delegate_0.lyrics(mediaMetadata3.id);
                        this.L$0 = null;
                        this.L$1 = mediaMetadata3;
                        this.Z$0 = zBooleanValue;
                        this.label = (byte) 1;
                        objFirst = StateFlowKt.first(flowLyrics, this);
                        if (objFirst == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        z = zBooleanValue;
                        mediaMetadata = mediaMetadata3;
                    }
                    return unit;
                    if (objFirst == null) {
                        ImageLoader$Builder imageLoader$Builder = musicService.lyricsHelper;
                        if (imageLoader$Builder == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("lyricsHelper");
                            throw null;
                        }
                        this.L$0 = null;
                        this.L$1 = mediaMetadata;
                        this.Z$0 = z;
                        this.label = (byte) 2;
                        lyrics = imageLoader$Builder.getLyrics(mediaMetadata, this);
                        if (lyrics == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        musicService.getDatabase().query(new MusicService$onCreate$19$$ExternalSyntheticLambda0(mediaMetadata, (LyricsWithProvider) lyrics, b2));
                    }
                    return unit;
                case 1:
                    LazyLayoutItemAnimation lazyLayoutItemAnimation = (LazyLayoutItemAnimation) this.L$1;
                    ParcelableSnapshotMutableState parcelableSnapshotMutableState = lazyLayoutItemAnimation.isAppearanceAnimationInProgress$delegate;
                    Animatable animatable = lazyLayoutItemAnimation.visibilityAnimation;
                    byte b4 = this.label;
                    try {
                        if (b4 != 0) {
                            if (b4 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                if (b4 != 2) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                    return null;
                                }
                                ResultKt.throwOnFailure(obj);
                                objAnimateTo$default = obj;
                            }
                            parcelableSnapshotMutableState.setValue(Boolean.FALSE);
                            return unit;
                        }
                        ResultKt.throwOnFailure(obj);
                        if (this.Z$0) {
                            Float f = new Float(CropImageView.DEFAULT_ASPECT_RATIO);
                            this.label = (byte) 1;
                            if (animatable.snapTo(f, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        Float f2 = new Float(1.0f);
                        FiniteAnimationSpec finiteAnimationSpec = (FiniteAnimationSpec) this.L$0;
                        LazyLayoutItemAnimation$animateAppearance$2$$ExternalSyntheticLambda0 lazyLayoutItemAnimation$animateAppearance$2$$ExternalSyntheticLambda0 = new LazyLayoutItemAnimation$animateAppearance$2$$ExternalSyntheticLambda0((GraphicsLayer) obj2, lazyLayoutItemAnimation, b2);
                        this.label = (byte) 2;
                        objAnimateTo$default = Animatable.animateTo$default(animatable, f2, finiteAnimationSpec, null, lazyLayoutItemAnimation$animateAppearance$2$$ExternalSyntheticLambda0, this, 4);
                        if (objAnimateTo$default == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        parcelableSnapshotMutableState.setValue(Boolean.FALSE);
                        return unit;
                    } catch (Throwable th) {
                        parcelableSnapshotMutableState.setValue(Boolean.FALSE);
                        throw th;
                    }
                default:
                    SyncUtils syncUtils = (SyncUtils) this.L$1;
                    String str = (String) obj2;
                    byte b5 = this.label;
                    if (b5 == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = (byte) 1;
                        int i = SyncUtils.$r8$clinit;
                        objIsLoggedIn = syncUtils.isLoggedIn(this);
                        if (objIsLoggedIn == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (b5 != 1) {
                            if (b5 == 2) {
                                ResultKt.throwOnFailure(obj);
                                objM1522withRetryBWLJW6A2 = ((Result) obj).value;
                                if (Result.m1866exceptionOrNullimpl(objM1522withRetryBWLJW6A2) != null) {
                                    Timber.Forest.getClass();
                                    ConnectionPool.e$1(new Object[0]);
                                }
                                return unit;
                            }
                            if (b5 != 3) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ResultKt.throwOnFailure(obj);
                            objM1522withRetryBWLJW6A = ((Result) obj).value;
                            if (Result.m1866exceptionOrNullimpl(objM1522withRetryBWLJW6A) != null) {
                                Timber.Forest.getClass();
                                ConnectionPool.e$1(new Object[0]);
                            }
                            return unit;
                        }
                        ResultKt.throwOnFailure(obj);
                        objIsLoggedIn = obj;
                    }
                    if (!((Boolean) objIsLoggedIn).booleanValue()) {
                        Timber.Forest.getClass();
                        ConnectionPool.d(new Object[0]);
                    } else if (this.Z$0) {
                        SyncUtils$executeLikeSong$2$1 syncUtils$executeLikeSong$2$1 = new SyncUtils$executeLikeSong$2$1(str, continuation, (byte) 4);
                        this.label = (byte) 2;
                        objM1522withRetryBWLJW6A2 = syncUtils.m1522withRetryBWLJW6A(3, 1000L, syncUtils$executeLikeSong$2$1, this);
                        if (objM1522withRetryBWLJW6A2 == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        if (Result.m1866exceptionOrNullimpl(objM1522withRetryBWLJW6A2) != null) {
                            Timber.Forest.getClass();
                            ConnectionPool.e$1(new Object[0]);
                        }
                    } else {
                        String str2 = (String) this.L$0;
                        if (str2 != null) {
                            SyncUtils$executeSaveEpisode$2$3 syncUtils$executeSaveEpisode$2$3 = new SyncUtils$executeSaveEpisode$2$3(str, str2, continuation, b2);
                            this.label = (byte) 3;
                            objM1522withRetryBWLJW6A = syncUtils.m1522withRetryBWLJW6A(3, 1000L, syncUtils$executeSaveEpisode$2$3, this);
                            if (objM1522withRetryBWLJW6A == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            if (Result.m1866exceptionOrNullimpl(objM1522withRetryBWLJW6A) != null) {
                                Timber.Forest.getClass();
                                ConnectionPool.e$1(new Object[0]);
                            }
                        }
                    }
                    return unit;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass19(MusicService musicService, Continuation continuation) {
            super(2, continuation);
            this.this$0 = musicService;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass19(boolean z, LazyLayoutItemAnimation lazyLayoutItemAnimation, FiniteAnimationSpec finiteAnimationSpec, GraphicsLayer graphicsLayer, Continuation continuation) {
            super(2, continuation);
            this.Z$0 = z;
            this.L$1 = lazyLayoutItemAnimation;
            this.L$0 = finiteAnimationSpec;
            this.this$0 = graphicsLayer;
        }
    }
}
