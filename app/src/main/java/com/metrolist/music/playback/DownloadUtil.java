package com.metrolist.music.playback;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.os.Build;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.SharedMutableTransformState;
import androidx.compose.animation.SharedMutableTransformState$startCatchUp$2$1;
import androidx.compose.animation.TransformScopeImpl;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.material3.SwipeToDismissBoxState;
import androidx.compose.material3.SwipeToDismissBoxValue;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.scrollcapture.ScrollCapture;
import androidx.core.provider.CallbackWrapper;
import androidx.datastore.core.Data;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.SimpleActor$offer$2;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.database.StandaloneDatabaseProvider;
import androidx.media3.datasource.HttpDataSource$InvalidResponseCodeException;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.datasource.cache.SimpleCache;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.offline.DefaultDownloadIndex;
import androidx.media3.exoplayer.offline.Download;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.offline.DownloadRequest;
import androidx.media3.exoplayer.source.ShuffleOrder$DefaultShuffleOrder;
import androidx.media3.session.MediaLibraryService;
import androidx.navigation.NavHostController;
import coil3.RealImageLoader;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter$$ExternalSyntheticLambda0;
import com.google.common.math.IntMath;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.pages.ChartsPage;
import com.metrolist.music.MainActivity;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.DatabaseDao$$ExternalSyntheticLambda0;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.eq.data.EQProfileRepository;
import com.metrolist.music.eq.data.Entry;
import com.metrolist.music.eq.data.SavedEQProfile;
import com.metrolist.music.listentogether.ListenTogetherClient;
import com.metrolist.music.lyrics.LyricsUtils;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.alarm.MusicAlarmEntry;
import com.metrolist.music.playback.alarm.MusicAlarmStore;
import com.metrolist.music.playback.audio.SilenceDetectorAudioProcessor;
import com.metrolist.music.playback.queues.LocalAlbumRadio;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.component.LensController;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.viewmodels.ChartsViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.reflect.KProperty;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.SemaphoreImpl;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.json.JsonImpl;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DownloadUtil {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {new PropertyReference1Impl(DownloadUtil.class, "audioQuality", "getAudioQuality()Lcom/metrolist/music/constants/AudioQuality;")};
    public static final byte $stable = 8;
    public final Splitter audioQuality$delegate;
    public final ConnectivityManager connectivityManager;
    public final Context context;
    public final MusicDatabase database;
    public final DownloadManager downloadManager;
    public final ScrollCapture downloadNotificationHelper;
    public final SemaphoreImpl downloadPreparations;
    public final StateFlowImpl downloads;
    public final SimpleCache playerCache;
    public final ContextScope scope;
    public final StreamUrlCache songUrlCache;
    public final OkHttpClient streamHttpClient;

    public DownloadUtil(Context context, MusicDatabase musicDatabase, StandaloneDatabaseProvider standaloneDatabaseProvider, SimpleCache simpleCache, SimpleCache simpleCache2) {
        musicDatabase.getClass();
        standaloneDatabaseProvider.getClass();
        simpleCache.getClass();
        simpleCache2.getClass();
        this.context = context;
        this.database = musicDatabase;
        this.playerCache = simpleCache2;
        Object systemService = context.getSystemService((Class<Object>) ConnectivityManager.class);
        systemService.getClass();
        this.connectivityManager = (ConnectivityManager) systemService;
        this.audioQuality$delegate = new Splitter(context, PreferenceKeysKt.AudioQualityKey);
        this.songUrlCache = new StreamUrlCache();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.proxy(YouTube.innerTube.configuredProxy);
        builder.proxyAuthenticator(new PathKt$$ExternalSyntheticBUOutline0((byte) 14));
        OkHttpClient okHttpClient = new OkHttpClient(builder);
        this.streamHttpClient = okHttpClient;
        this.scope = AwaitKt.CoroutineScope(StringsKt__IndentKt.plus(AwaitKt.SupervisorJob$default(), DefaultIoScheduler.INSTANCE));
        this.downloadPreparations = new SemaphoreImpl(3);
        this.downloads = StateFlowKt.MutableStateFlow(EmptyMap.INSTANCE);
        CacheDataSource.Factory factory = new CacheDataSource.Factory();
        factory.cache = simpleCache2;
        factory.cacheIsReadOnly = true;
        factory.upstreamDataSourceFactory = new CallbackWrapper(okHttpClient);
        WeakCache weakCache = new WeakCache((Object) factory, (Object) new Splitter$$ExternalSyntheticLambda0((byte) 8, this), (byte) 20);
        this.downloadNotificationHelper = new ScrollCapture(context);
        byte b = 0;
        DownloadManager downloadManager = new DownloadManager(context, standaloneDatabaseProvider, simpleCache, weakCache, new DownloadUtil$$ExternalSyntheticLambda2((byte) 0));
        if (downloadManager.maxParallelDownloads != 3) {
            downloadManager.maxParallelDownloads = (byte) 3;
            downloadManager.pendingMessages++;
            downloadManager.internalHandler.obtainMessage(5, 3, 0).sendToTarget();
        }
        downloadManager.listeners.add(new DownloadManager.Listener() { // from class: com.metrolist.music.playback.DownloadUtil$downloadManager$2$1
            @Override // androidx.media3.exoplayer.offline.DownloadManager.Listener
            public final void onDownloadChanged(DownloadManager downloadManager2, Download download, Exception exc) {
                Object value;
                LinkedHashMap mutableMap;
                int i;
                download.getClass();
                DownloadRequest downloadRequest = download.request;
                int i2 = download.state;
                DownloadUtil downloadUtil = this.this$0;
                if (i2 == 4) {
                    for (Throwable cause = exc; cause != null; cause = cause.getCause()) {
                        if ((cause instanceof HttpDataSource$InvalidResponseCodeException) && ((i = ((HttpDataSource$InvalidResponseCodeException) cause).responseCode) == 403 || i == 410 || i == 416)) {
                            StreamUrlCache streamUrlCache = downloadUtil.songUrlCache;
                            String str = downloadRequest.id;
                            str.getClass();
                            streamUrlCache.invalidate(str);
                            break;
                        }
                    }
                }
                StateFlowImpl stateFlowImpl = downloadUtil.downloads;
                do {
                    value = stateFlowImpl.getValue();
                    mutableMap = MapsKt__MapsKt.toMutableMap((Map) value);
                    mutableMap.put(downloadRequest.id, download);
                } while (!stateFlowImpl.compareAndSet(value, mutableMap));
                AwaitKt.launch$default(downloadUtil.scope, null, null, new DownloadUtil.AnonymousClass2(download, downloadUtil, null, (byte) 16), 3);
            }

            @Override // androidx.media3.exoplayer.offline.DownloadManager.Listener
            public final void onDownloadRemoved(DownloadManager downloadManager2, Download download) {
                Object failure;
                Object value;
                LinkedHashMap mutableMap;
                download.getClass();
                String str = download.request.id;
                str.getClass();
                DownloadUtil downloadUtil = this.this$0;
                downloadUtil.songUrlCache.invalidate(str);
                try {
                    MusicDatabase musicDatabase2 = downloadUtil.database;
                    musicDatabase2.getClass();
                    musicDatabase2.$$delegate_0.updateDownloadedInfo(str, false, null);
                    failure = Unit.INSTANCE;
                } catch (Throwable th) {
                    failure = new Result.Failure(th);
                }
                if (!(failure instanceof Result.Failure)) {
                    StateFlowImpl stateFlowImpl = downloadUtil.downloads;
                    do {
                        value = stateFlowImpl.getValue();
                        mutableMap = MapsKt__MapsKt.toMutableMap((Map) value);
                        mutableMap.remove(str);
                    } while (!stateFlowImpl.compareAndSet(value, mutableMap));
                    Timber.Forest.tag("DownloadUtil");
                    ConnectionPool.d(new Object[0]);
                }
                if (Result.m1866exceptionOrNullimpl(failure) != null) {
                    Timber.Forest.tag("DownloadUtil");
                    ConnectionPool.e$1(new Object[0]);
                }
            }
        });
        this.downloadManager = downloadManager;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DefaultDownloadIndex defaultDownloadIndex = downloadManager.downloadIndex;
        defaultDownloadIndex.ensureInitialized();
        Continuation continuation = null;
        Cursor cursor = defaultDownloadIndex.getCursor(DefaultDownloadIndex.getStateQuery(new int[0]), null);
        DefaultDownloadIndex.DownloadCursorImpl downloadCursorImpl = new DefaultDownloadIndex.DownloadCursorImpl(cursor);
        while (true) {
            try {
                Cursor cursor2 = downloadCursorImpl.cursor;
                if (!cursor2.moveToPosition(cursor2.getPosition() + 1)) {
                    downloadCursorImpl.close();
                    StateFlowImpl stateFlowImpl = this.downloads;
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, linkedHashMap);
                    AwaitKt.launch$default(this.scope, null, null, new AnonymousClass2(linkedHashMap, this, continuation, b), 3);
                    return;
                }
                linkedHashMap.put(DefaultDownloadIndex.getDownloadForCurrentRow(cursor).request.id, DefaultDownloadIndex.getDownloadForCurrentRow(cursor));
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CharsKt.closeFinally(downloadCursorImpl, th);
                    throw th2;
                }
            }
        }
    }

    public final void download(MediaMetadata mediaMetadata) {
        mediaMetadata.getClass();
        AwaitKt.launch$default(this.scope, null, null, new AnonymousClass1(this, mediaMetadata, null), 3);
    }

    public final DownloadUtil$getDownload$$inlined$map$1 getDownload(String str) {
        str.getClass();
        return new DownloadUtil$getDownload$$inlined$map$1(this.downloads, str, (byte) 0);
    }

    public final void removeFromPlayerCache(String str) {
        Object failure;
        try {
            this.playerCache.removeResource(str);
            failure = Unit.INSTANCE;
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (Result.m1866exceptionOrNullimpl(failure) != null) {
            Timber.Forest.tag("DownloadUtil");
            ConnectionPool.w$1(new Object[0]);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.DownloadUtil$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public /* synthetic */ Object $result;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(DownloadUtil downloadUtil, String str, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 15;
            this.this$0 = downloadUtil;
            this.$result = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj2 = this.this$0;
            switch (b) {
                case 0:
                    return new AnonymousClass2((LinkedHashMap) this.$result, (DownloadUtil) obj2, continuation, (byte) 0);
                case 1:
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(obj2, continuation, (byte) 1);
                    anonymousClass2.$result = obj;
                    return anonymousClass2;
                case 2:
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2(obj2, continuation, (byte) 2);
                    anonymousClass3.$result = obj;
                    return anonymousClass3;
                case 3:
                    return new AnonymousClass2((SwipeToDismissBoxState) this.$result, (Function1) obj2, continuation, (byte) 3);
                case 4:
                    AnonymousClass2 anonymousClass4 = new AnonymousClass2(obj2, continuation, (byte) 4);
                    anonymousClass4.$result = obj;
                    return anonymousClass4;
                case 5:
                    AnonymousClass2 anonymousClass5 = new AnonymousClass2(obj2, continuation, (byte) 5);
                    anonymousClass5.$result = obj;
                    return anonymousClass5;
                case 6:
                    AnonymousClass2 anonymousClass6 = new AnonymousClass2(obj2, continuation, (byte) 6);
                    anonymousClass6.$result = obj;
                    return anonymousClass6;
                case 7:
                    return new AnonymousClass2((MainActivity) this.$result, (DataStoreKt$rememberPreference$1$1) obj2, continuation, (byte) 7);
                case 8:
                    return new AnonymousClass2((MainActivity) this.$result, (NavHostController) obj2, continuation, (byte) 8);
                case 9:
                    return new AnonymousClass2((NavHostController) this.$result, (String) obj2, continuation, (byte) 9);
                case 10:
                    return new AnonymousClass2((EQProfileRepository) this.$result, (SavedEQProfile) obj2, continuation, (byte) 10);
                case 11:
                    return new AnonymousClass2((EQProfileRepository) this.$result, (List) obj2, continuation, (byte) 11);
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return new AnonymousClass2((TextDelegate) this.$result, (Entry) obj2, continuation, (byte) 12);
                case 13:
                    AnonymousClass2 anonymousClass7 = new AnonymousClass2(obj2, continuation, (byte) 13);
                    anonymousClass7.$result = obj;
                    return anonymousClass7;
                case 14:
                    return new AnonymousClass2((String) this.$result, (String) obj2, continuation, (byte) 14);
                case 15:
                    return new AnonymousClass2((DownloadUtil) obj2, (String) this.$result, continuation);
                case 16:
                    return new AnonymousClass2((Download) this.$result, (DownloadUtil) obj2, continuation, (byte) 16);
                case 17:
                    return new AnonymousClass2((MusicService) this.$result, (ExoPlayerImpl) obj2, continuation, (byte) 17);
                case 18:
                    return new AnonymousClass2((MusicService) this.$result, (SilenceDetectorAudioProcessor) obj2, continuation, (byte) 18);
                case 19:
                    AnonymousClass2 anonymousClass8 = new AnonymousClass2((Ref$BooleanRef) this.$result, (MusicService) obj2, continuation, (byte) 19);
                    ((Boolean) obj).booleanValue();
                    return anonymousClass8;
                case 20:
                    return new AnonymousClass2((MusicService) this.$result, (MediaMetadata) obj2, continuation, (byte) 20);
                case 21:
                    AnonymousClass2 anonymousClass9 = new AnonymousClass2(obj2, continuation, (byte) 21);
                    anonymousClass9.$result = obj;
                    return anonymousClass9;
                case 22:
                    return new AnonymousClass2((LensController) this.$result, (HapticFeedback) obj2, continuation, (byte) 22);
                case 23:
                    return new AnonymousClass2((Context) this.$result, (MutableState) obj2, continuation, (byte) 23);
                case 24:
                    return new AnonymousClass2((PlayerConnection) this.$result, (AlbumWithSongs) obj2, continuation, (byte) 24);
                case 25:
                    return new AnonymousClass2((Function0) this.$result, (ParcelableSnapshotMutableIntState) obj2, continuation, (byte) 25);
                case 26:
                    return new AnonymousClass2((PlayerConnection) this.$result, (WatchEndpoint) obj2, continuation, (byte) 26);
                case 27:
                    return new AnonymousClass2((PlayerConnection) this.$result, (MutableState) obj2, continuation, (byte) 27);
                case 28:
                    AnonymousClass2 anonymousClass10 = new AnonymousClass2(obj2, continuation, (byte) 28);
                    anonymousClass10.$result = obj;
                    return anonymousClass10;
                default:
                    return new AnonymousClass2((ChartsViewModel) this.$result, (State) obj2, continuation, (byte) 29);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) throws Throwable {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 1:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 2:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 3:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 4:
                    return ((AnonymousClass2) create((androidx.datastore.core.State) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 5:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 6:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 7:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 8:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 9:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 10:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 11:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 13:
                    ((AnonymousClass2) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 14:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 15:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 16:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 17:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 18:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 19:
                    Boolean bool = (Boolean) obj;
                    bool.getClass();
                    ((AnonymousClass2) create(bool, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 20:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 21:
                    ((AnonymousClass2) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 22:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 23:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 24:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 25:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 26:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 27:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 28:
                    ((AnonymousClass2) create((MusicDatabase) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                default:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:120:0x03a9  */
        /* JADX WARN: Code duplicated, block: B:180:0x04a8  */
        /* JADX WARN: Code duplicated, block: B:181:0x04ad  */
        /* JADX WARN: Code duplicated, block: B:183:0x04b3  */
        /* JADX WARN: Code duplicated, block: B:184:0x04b8  */
        /* JADX WARN: Code duplicated, block: B:186:0x04be  */
        /* JADX WARN: Code duplicated, block: B:187:0x04c3  */
        /* JADX WARN: Code duplicated, block: B:189:0x04c9  */
        /* JADX WARN: Code duplicated, block: B:190:0x04ce  */
        /* JADX WARN: Code duplicated, block: B:192:0x04d4  */
        /* JADX WARN: Code duplicated, block: B:193:0x04d9  */
        /* JADX WARN: Code duplicated, block: B:195:0x04df  */
        /* JADX WARN: Code duplicated, block: B:196:0x04e4  */
        /* JADX WARN: Code duplicated, block: B:198:0x04ea  */
        /* JADX WARN: Code duplicated, block: B:251:0x0659  */
        /* JADX WARN: Code duplicated, block: B:252:0x065d  */
        /* JADX WARN: Code duplicated, block: B:255:0x0668  */
        /* JADX WARN: Code duplicated, block: B:256:0x066b  */
        /* JADX WARN: Code duplicated, block: B:259:0x0672  */
        /* JADX WARN: Code duplicated, block: B:71:0x01d0  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v5 */
        /* JADX WARN: Type inference failed for: r4v6, types: [kotlin.coroutines.Continuation, kotlin.coroutines.CoroutineContext, kotlinx.coroutines.CoroutineStart] */
        /* JADX WARN: Type inference failed for: r4v7 */
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
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ?? r4;
            Display.Mode mode;
            Display.Mode mode2;
            SavedEQProfile savedEQProfile;
            String str;
            Long l;
            long jLongValue;
            int i = -1;
            byte b = 2;
            byte b2 = 3;
            boolean z = true;
            int i2 = 1;
            byte b3 = 0;
            int i3 = 0;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            switch (this.$r8$classId) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Collection collectionValues = ((LinkedHashMap) this.$result).values();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : collectionValues) {
                        if (((Download) obj2).state == 3) {
                            arrayList.add(obj2);
                        }
                    }
                    DownloadUtil downloadUtil = (DownloadUtil) this.this$0;
                    int size = arrayList.size();
                    while (b3 < size) {
                        String str2 = ((Download) arrayList.get(b3)).request.id;
                        str2.getClass();
                        KProperty[] kPropertyArr = DownloadUtil.$$delegatedProperties;
                        downloadUtil.removeFromPlayerCache(str2);
                        b3++;
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.$result;
                    SharedMutableTransformState sharedMutableTransformState = (SharedMutableTransformState) this.this$0;
                    TransformScopeImpl transformScopeImpl = sharedMutableTransformState.transformScope;
                    TransformScopeImpl transformScopeImpl2 = sharedMutableTransformState.transformScope;
                    if (transformScopeImpl.isAlphaMutated()) {
                        r4 = 0;
                        AwaitKt.launch$default(coroutineScope, null, null, new SharedMutableTransformState$startCatchUp$2$1(sharedMutableTransformState, false ? 1 : 0, (byte) 0), 3);
                    } else {
                        r4 = 0;
                    }
                    if (transformScopeImpl2.isScaleMutated()) {
                        AwaitKt.launch$default(coroutineScope, r4, r4, new SharedMutableTransformState$startCatchUp$2$1(sharedMutableTransformState, r4, z ? (byte) 1 : (byte) 0), 3);
                    }
                    if (transformScopeImpl2.isVeilMutated()) {
                        AwaitKt.launch$default(coroutineScope, r4, r4, new SharedMutableTransformState$startCatchUp$2$1(sharedMutableTransformState, r4, b), 3);
                    }
                    if (((Boolean) transformScopeImpl2.isTransformOriginMutated$delegate.getValue()).booleanValue()) {
                        AwaitKt.launch$default(coroutineScope, r4, r4, new SharedMutableTransformState$startCatchUp$2$1(sharedMutableTransformState, r4, b2), 3);
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope2 = (CoroutineScope) this.$result;
                    CursorAnimationState cursorAnimationState = (CursorAnimationState) this.this$0;
                    Continuation continuation = null;
                    Job job = (Job) cursorAnimationState.animationJob.getAndSet(null);
                    AtomicReference atomicReference = cursorAnimationState.animationJob;
                    StandaloneCoroutine standaloneCoroutineLaunch$default = AwaitKt.launch$default(coroutineScope2, null, null, new SimpleActor$offer$2(job, cursorAnimationState, continuation, (byte) 6), 3);
                    while (!atomicReference.compareAndSet(continuation, standaloneCoroutineLaunch$default)) {
                        if (atomicReference.get() != null) {
                            z = false;
                            return Boolean.valueOf(z);
                        }
                        continuation = null;
                    }
                    return Boolean.valueOf(z);
                case 3:
                    ResultKt.throwOnFailure(obj);
                    NodeChain nodeChain = ((SwipeToDismissBoxState) this.$result).anchoredDraggableState;
                    SwipeToDismissBoxValue swipeToDismissBoxValue = (SwipeToDismissBoxValue) ((ParcelableSnapshotMutableState) nodeChain.outerCoordinator).getValue();
                    SwipeToDismissBoxValue swipeToDismissBoxValue2 = SwipeToDismissBoxValue.Settled;
                    if (swipeToDismissBoxValue != swipeToDismissBoxValue2) {
                        Function1 function1 = (Function1) this.this$0;
                        if (((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue() != CropImageView.DEFAULT_ASPECT_RATIO && !Float.isNaN(((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue())) {
                            swipeToDismissBoxValue2 = ((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue() > CropImageView.DEFAULT_ASPECT_RATIO ? SwipeToDismissBoxValue.StartToEnd : SwipeToDismissBoxValue.EndToStart;
                        }
                        function1.invoke(swipeToDismissBoxValue2);
                    }
                    return Unit.INSTANCE;
                case 4:
                    ResultKt.throwOnFailure(obj);
                    androidx.datastore.core.State state = (androidx.datastore.core.State) this.$result;
                    return Boolean.valueOf((state instanceof Data) && ((Data) state).version <= ((Data) ((androidx.datastore.core.State) this.this$0)).version);
                case 5:
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope3 = (CoroutineScope) this.$result;
                    LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl = (LifecycleCoroutineScopeImpl) this.this$0;
                    Lifecycle lifecycle = lifecycleCoroutineScopeImpl.lifecycle;
                    if (((LifecycleRegistry) lifecycle).state.compareTo(Lifecycle.State.INITIALIZED) >= 0) {
                        lifecycle.addObserver(lifecycleCoroutineScopeImpl);
                    } else {
                        AwaitKt.cancel(coroutineScope3.getCoroutineContext(), (CancellationException) null);
                    }
                    return Unit.INSTANCE;
                case 6:
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext.Element element = ((CoroutineScope) this.$result).getCoroutineContext().get(ContinuationInterceptor$Key.$$INSTANCE);
                    element.getClass();
                    CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) element;
                    CompletableDeferredImpl completableDeferredImplCompletableDeferred$default = AwaitKt.CompletableDeferred$default();
                    Continuation continuation2 = null;
                    AwaitKt.launch(GlobalScope.INSTANCE, coroutineDispatcher, CoroutineStart.UNDISPATCHED, new RealImageLoader.AnonymousClass2(completableDeferredImplCompletableDeferred$default, (Function2) this.this$0, continuation2, (byte) 28));
                    while (!completableDeferredImplCompletableDeferred$default.isCompleted()) {
                        try {
                            return AwaitKt.runBlockingK(coroutineDispatcher, new SyncUtils.AnonymousClass2(completableDeferredImplCompletableDeferred$default, continuation2, (byte) 18));
                        } catch (InterruptedException unused) {
                            continuation2 = null;
                        }
                    }
                    return completableDeferredImplCompletableDeferred$default.getCompletedInternal$kotlinx_coroutines_core();
                case 7:
                    State state2 = ((DataStoreKt$rememberPreference$1$1) this.this$0).$state;
                    ResultKt.throwOnFailure(obj);
                    Window window = ((MainActivity) this.$result).getWindow();
                    if (Build.VERSION.SDK_INT >= 30) {
                        WindowManager.LayoutParams attributes = window.getAttributes();
                        if (((Boolean) state2.getValue()).booleanValue()) {
                            attributes.preferredDisplayModeId = 0;
                        } else {
                            Display.Mode[] supportedModes = window.getWindowManager().getDefaultDisplay().getSupportedModes();
                            supportedModes.getClass();
                            int length = supportedModes.length;
                            int i4 = 0;
                            while (true) {
                                if (i4 < length) {
                                    mode = supportedModes[i4];
                                    if (Math.abs(mode.getRefreshRate() - 60.0f) >= 1.0f) {
                                        i4++;
                                    }
                                } else {
                                    mode = null;
                                }
                            }
                            if (mode != null) {
                                mode2 = mode;
                            } else if (supportedModes.length == 0) {
                                mode2 = null;
                            } else {
                                mode2 = supportedModes[0];
                                int length2 = supportedModes.length - 1;
                                if (length2 != 0) {
                                    float fAbs = Math.abs(mode2.getRefreshRate() - 60.0f);
                                    if (1 <= length2) {
                                        while (true) {
                                            Display.Mode mode3 = supportedModes[i2];
                                            float fAbs2 = Math.abs(mode3.getRefreshRate() - 60.0f);
                                            if (Float.compare(fAbs, fAbs2) > 0) {
                                                mode2 = mode3;
                                                fAbs = fAbs2;
                                            }
                                            if (i2 != length2) {
                                                i2++;
                                            }
                                        }
                                    }
                                }
                            }
                            if (mode2 != null) {
                                attributes.preferredDisplayModeId = mode2.getModeId();
                            }
                        }
                        window.setAttributes(attributes);
                    } else {
                        WindowManager.LayoutParams attributes2 = window.getAttributes();
                        if (((Boolean) state2.getValue()).booleanValue()) {
                            attributes2.preferredRefreshRate = CropImageView.DEFAULT_ASPECT_RATIO;
                        } else {
                            attributes2.preferredRefreshRate = 60.0f;
                        }
                        window.setAttributes(attributes2);
                    }
                    return Unit.INSTANCE;
                case 8:
                    NavHostController navHostController = (NavHostController) this.this$0;
                    ResultKt.throwOnFailure(obj);
                    MainActivity mainActivity = (MainActivity) this.$result;
                    Intent intent = mainActivity.pendingIntent;
                    if (intent != null) {
                        MainActivity.handleWidgetTargetIntent(intent, navHostController);
                        Intent intent2 = mainActivity.pendingIntent;
                        intent2.getClass();
                        MainActivity.handleRecognitionIntent(intent2, navHostController);
                        Intent intent3 = mainActivity.pendingIntent;
                        intent3.getClass();
                        mainActivity.handleDeepLinkIntent(intent3, navHostController);
                        mainActivity.pendingIntent = null;
                    } else {
                        Intent intent4 = mainActivity.getIntent();
                        intent4.getClass();
                        MainActivity.handleWidgetTargetIntent(intent4, navHostController);
                        Intent intent5 = mainActivity.getIntent();
                        intent5.getClass();
                        MainActivity.handleRecognitionIntent(intent5, navHostController);
                        Intent intent6 = mainActivity.getIntent();
                        intent6.getClass();
                        mainActivity.handleDeepLinkIntent(intent6, navHostController);
                    }
                    return Unit.INSTANCE;
                case 9:
                    ResultKt.throwOnFailure(obj);
                    NavHostController.navigate$default((NavHostController) this.$result, "album/" + ((String) this.this$0));
                    return Unit.INSTANCE;
                case 10:
                    ResultKt.throwOnFailure(obj);
                    EQProfileRepository eQProfileRepository = (EQProfileRepository) this.$result;
                    StateFlowImpl stateFlowImpl = eQProfileRepository._profiles;
                    StateFlowImpl stateFlowImpl2 = eQProfileRepository._activeProfile;
                    ArrayList mutableList = CollectionsKt.toMutableList((Collection) stateFlowImpl.getValue());
                    SavedEQProfile savedEQProfile2 = (SavedEQProfile) this.this$0;
                    String str3 = savedEQProfile2.id;
                    int size2 = mutableList.size();
                    int i5 = 0;
                    int i6 = 0;
                    while (i6 < size2) {
                        Object obj3 = mutableList.get(i6);
                        i6++;
                        if (Intrinsics.areEqual(((SavedEQProfile) obj3).id, str3)) {
                            i = i5;
                            if (i >= 0) {
                                mutableList.set(i, savedEQProfile2);
                            } else {
                                mutableList.add(savedEQProfile2);
                            }
                            savedEQProfile = (SavedEQProfile) stateFlowImpl2.getValue();
                            if (savedEQProfile != null) {
                                str = savedEQProfile.id;
                            } else {
                                str = null;
                            }
                            if (Intrinsics.areEqual(str3, str)) {
                                stateFlowImpl2.getClass();
                                stateFlowImpl2.updateState(null, savedEQProfile2);
                            }
                            JsonImpl jsonImpl = eQProfileRepository.json;
                            jsonImpl.getClass();
                            String strEncodeToString = jsonImpl.encodeToString(new HashSetSerializer(SavedEQProfile.INSTANCE.serializer(), (byte) 1), mutableList);
                            SharedPreferences.Editor editorEdit = eQProfileRepository.prefs.edit();
                            editorEdit.putString("eq_profiles", strEncodeToString);
                            editorEdit.apply();
                            StateFlowImpl stateFlowImpl3 = eQProfileRepository._profiles;
                            stateFlowImpl3.getClass();
                            stateFlowImpl3.updateState(null, mutableList);
                            return Unit.INSTANCE;
                        }
                        i5++;
                    }
                    if (i >= 0) {
                        mutableList.set(i, savedEQProfile2);
                    } else {
                        mutableList.add(savedEQProfile2);
                    }
                    savedEQProfile = (SavedEQProfile) stateFlowImpl2.getValue();
                    if (savedEQProfile != null) {
                        str = savedEQProfile.id;
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str3, str)) {
                        stateFlowImpl2.getClass();
                        stateFlowImpl2.updateState(null, savedEQProfile2);
                    }
                    JsonImpl jsonImpl2 = eQProfileRepository.json;
                    jsonImpl2.getClass();
                    String strEncodeToString2 = jsonImpl2.encodeToString(new HashSetSerializer(SavedEQProfile.INSTANCE.serializer(), (byte) 1), mutableList);
                    SharedPreferences.Editor editorEdit2 = eQProfileRepository.prefs.edit();
                    editorEdit2.putString("eq_profiles", strEncodeToString2);
                    editorEdit2.apply();
                    StateFlowImpl stateFlowImpl4 = eQProfileRepository._profiles;
                    stateFlowImpl4.getClass();
                    stateFlowImpl4.updateState(null, mutableList);
                    return Unit.INSTANCE;
                case 11:
                    ResultKt.throwOnFailure(obj);
                    EQProfileRepository eQProfileRepository2 = (EQProfileRepository) this.$result;
                    ArrayList mutableList2 = CollectionsKt.toMutableList((Collection) eQProfileRepository2._profiles.getValue());
                    StateFlowImpl stateFlowImpl5 = eQProfileRepository2._activeProfile;
                    SavedEQProfile savedEQProfile3 = (SavedEQProfile) stateFlowImpl5.getValue();
                    String str4 = savedEQProfile3 != null ? savedEQProfile3.id : null;
                    for (SavedEQProfile savedEQProfile4 : (List) this.this$0) {
                        int size3 = mutableList2.size();
                        int i7 = 0;
                        int i8 = 0;
                        while (true) {
                            if (i8 < size3) {
                                Object obj4 = mutableList2.get(i8);
                                i8++;
                                if (!Intrinsics.areEqual(((SavedEQProfile) obj4).id, savedEQProfile4.id)) {
                                    i7++;
                                }
                            } else {
                                i7 = -1;
                            }
                        }
                        if (i7 >= 0) {
                            mutableList2.set(i7, savedEQProfile4);
                        } else {
                            mutableList2.add(savedEQProfile4);
                        }
                        if (Intrinsics.areEqual(savedEQProfile4.id, str4)) {
                            stateFlowImpl5.getClass();
                            stateFlowImpl5.updateState(null, savedEQProfile4);
                        }
                    }
                    JsonImpl jsonImpl3 = eQProfileRepository2.json;
                    jsonImpl3.getClass();
                    String strEncodeToString3 = jsonImpl3.encodeToString(new HashSetSerializer(SavedEQProfile.INSTANCE.serializer(), (byte) 1), mutableList2);
                    SharedPreferences.Editor editorEdit3 = eQProfileRepository2.prefs.edit();
                    editorEdit3.putString("eq_profiles", strEncodeToString3);
                    editorEdit3.apply();
                    StateFlowImpl stateFlowImpl6 = eQProfileRepository2._profiles;
                    stateFlowImpl6.getClass();
                    stateFlowImpl6.updateState(null, mutableList2);
                    return Unit.INSTANCE;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    Entry entry = (Entry) this.this$0;
                    TextDelegate textDelegate = (TextDelegate) this.$result;
                    ResultKt.throwOnFailure(obj);
                    try {
                        textDelegate.getClass();
                        String str5 = entry.source;
                        String str6 = entry.formDirectory;
                        String str7 = entry.label;
                        String strFetchRawFile = textDelegate.fetchRawFile(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("results/", str5, "/", str6, "/"), str7, "/", str7, " ParametricEQ.txt"));
                        if (strFetchRawFile != null) {
                            return RegexKt.parseText(strFetchRawFile);
                        }
                    } catch (Exception unused2) {
                        Timber.Forest.tag("GitHubAutoEqSearch");
                        ConnectionPool.e$1(entry.label);
                    }
                    return null;
                case 13:
                    MutablePreferences mutablePreferences = (MutablePreferences) this.$result;
                    ResultKt.throwOnFailure(obj);
                    ListenTogetherClient listenTogetherClient = (ListenTogetherClient) this.this$0;
                    String str8 = listenTogetherClient.sessionToken;
                    if (str8 != null) {
                        mutablePreferences.set(PreferenceKeysKt.ListenTogetherSessionTokenKey, str8);
                        Preferences$Key preferences$Key = PreferenceKeysKt.ListenTogetherRoomCodeKey;
                        String str9 = listenTogetherClient.storedRoomCode;
                        if (str9 == null) {
                            str9 = "";
                        }
                        mutablePreferences.set(preferences$Key, str9);
                        Preferences$Key preferences$Key2 = PreferenceKeysKt.ListenTogetherUserIdKey;
                        String str10 = (String) listenTogetherClient._userId.getValue();
                        mutablePreferences.set(preferences$Key2, str10 != null ? str10 : "");
                        mutablePreferences.set(PreferenceKeysKt.ListenTogetherIsHostKey, Boolean.valueOf(listenTogetherClient.wasHost));
                        mutablePreferences.set(PreferenceKeysKt.ListenTogetherSessionTimestampKey, new Long(System.currentTimeMillis()));
                    }
                    return Unit.INSTANCE;
                case 14:
                    ResultKt.throwOnFailure(obj);
                    String str11 = (String) this.$result;
                    if (str11.length() != 0) {
                        StringBuilder sb = new StringBuilder();
                        int length3 = str11.length();
                        for (int i9 = 0; i9 < length3; i9++) {
                            char cCharAt = str11.charAt(i9);
                            if (1024 <= cCharAt && cCharAt < 1280) {
                                sb.append(cCharAt);
                            }
                        }
                        String string = sb.toString();
                        if (string.length() != 0 && (string.length() != 1 || (string.charAt(0) != 1077 && string.charAt(0) != 1045))) {
                            String str12 = (String) this.this$0;
                            switch (str12) {
                                case "Kyrgyz":
                                    LyricsUtils lyricsUtils = LyricsUtils.INSTANCE;
                                    return LyricsUtils.romanizeKyrgyzInternal(str11);
                                case "Bulgarian":
                                    LyricsUtils lyricsUtils2 = LyricsUtils.INSTANCE;
                                    return LyricsUtils.romanizeBulgarianInternal(str11);
                                case "Russian":
                                    LyricsUtils lyricsUtils3 = LyricsUtils.INSTANCE;
                                    return LyricsUtils.romanizeRussianInternal(str11);
                                case "Serbian":
                                    LyricsUtils lyricsUtils4 = LyricsUtils.INSTANCE;
                                    return LyricsUtils.romanizeSerbianInternal(str11);
                                case "Ukrainian":
                                    LyricsUtils lyricsUtils5 = LyricsUtils.INSTANCE;
                                    return LyricsUtils.romanizeUkrainianInternal(str11);
                                case "Belarusian":
                                    LyricsUtils lyricsUtils6 = LyricsUtils.INSTANCE;
                                    return LyricsUtils.romanizeBelarusianInternal(str11);
                                case "Macedonian":
                                    LyricsUtils lyricsUtils7 = LyricsUtils.INSTANCE;
                                    return LyricsUtils.romanizeMacedonianInternal(str11);
                                default:
                                    if (str12.equals("Kyrgyz")) {
                                        LyricsUtils lyricsUtils8 = LyricsUtils.INSTANCE;
                                        return LyricsUtils.romanizeKyrgyzInternal(str11);
                                    }
                                    LyricsUtils lyricsUtils9 = LyricsUtils.INSTANCE;
                                    if (LyricsUtils.isRussian(str11)) {
                                        return LyricsUtils.romanizeRussianInternal(str11);
                                    }
                                    if (LyricsUtils.isUkrainian(str11)) {
                                        return LyricsUtils.romanizeUkrainianInternal(str11);
                                    }
                                    if (LyricsUtils.isSerbian(str11)) {
                                        return LyricsUtils.romanizeSerbianInternal(str11);
                                    }
                                    if (LyricsUtils.isBulgarian(str11)) {
                                        return LyricsUtils.romanizeBulgarianInternal(str11);
                                    }
                                    if (LyricsUtils.isBelarusian(str11)) {
                                        return LyricsUtils.romanizeBelarusianInternal(str11);
                                    }
                                    if (LyricsUtils.isKyrgyz(str11)) {
                                        return LyricsUtils.romanizeKyrgyzInternal(str11);
                                    }
                                    if (LyricsUtils.isMacedonian(str11)) {
                                        return LyricsUtils.romanizeMacedonianInternal(str11);
                                    }
                                    break;
                            }
                        }
                    }
                    return null;
                case 15:
                    ResultKt.throwOnFailure(obj);
                    DownloadUtil downloadUtil2 = (DownloadUtil) this.this$0;
                    Song songByIdBlocking = downloadUtil2.database.getSongByIdBlocking((String) this.$result);
                    if (songByIdBlocking != null) {
                        downloadUtil2.download(songByIdBlocking);
                    }
                    return Unit.INSTANCE;
                case 16:
                    DownloadUtil downloadUtil3 = (DownloadUtil) this.this$0;
                    MusicDatabase musicDatabase = downloadUtil3.database;
                    ResultKt.throwOnFailure(obj);
                    Download download = (Download) this.$result;
                    int i10 = download.state;
                    DownloadRequest downloadRequest = download.request;
                    if (i10 == 1) {
                        String str13 = downloadRequest.id;
                        str13.getClass();
                        musicDatabase.getClass();
                        musicDatabase.$$delegate_0.updateDownloadedInfo(str13, false, null);
                    } else if (i10 == 3) {
                        String str14 = downloadRequest.id;
                        str14.getClass();
                        KProperty[] kPropertyArr2 = DownloadUtil.$$delegatedProperties;
                        downloadUtil3.removeFromPlayerCache(str14);
                        String str15 = downloadRequest.id;
                        str15.getClass();
                        LocalDateTime localDateTimeNow = LocalDateTime.now();
                        musicDatabase.getClass();
                        musicDatabase.$$delegate_0.updateDownloadedInfo(str15, true, localDateTimeNow);
                    } else if (i10 == 4 || i10 == 5) {
                        String str16 = downloadRequest.id;
                        str16.getClass();
                        musicDatabase.getClass();
                        musicDatabase.$$delegate_0.updateDownloadedInfo(str16, false, null);
                    }
                    return Unit.INSTANCE;
                case 17:
                    ResultKt.throwOnFailure(obj);
                    MusicService musicService = (MusicService) this.$result;
                    DataStore dataStore = UtilsKt.getDataStore(musicService);
                    Preferences$Key preferences$Key3 = PreferenceKeysKt.AudioOffload;
                    Boolean bool = Boolean.FALSE;
                    boolean zBooleanValue = ((Boolean) UtilsKt.get(dataStore, preferences$Key3, bool)).booleanValue();
                    boolean zBooleanValue2 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(musicService), PreferenceKeysKt.CrossfadeEnabledKey, bool)).booleanValue();
                    ExoPlayerImpl exoPlayerImpl = (ExoPlayerImpl) this.this$0;
                    IntMath.setOffloadEnabled(exoPlayerImpl, zBooleanValue2 ? false : zBooleanValue);
                    exoPlayerImpl.setSkipSilenceEnabled(((Boolean) UtilsKt.get(UtilsKt.getDataStore(musicService), PreferenceKeysKt.SkipSilenceKey, bool)).booleanValue());
                    return Unit.INSTANCE;
                case 18:
                    ResultKt.throwOnFailure(obj);
                    DataStore dataStore2 = UtilsKt.getDataStore((MusicService) this.$result);
                    Preferences$Key preferences$Key4 = PreferenceKeysKt.SkipSilenceKey;
                    Boolean bool2 = Boolean.FALSE;
                    ((SilenceDetectorAudioProcessor) this.this$0).instantModeEnabled = ((Boolean) UtilsKt.get(dataStore2, preferences$Key4, bool2)).booleanValue() && ((Boolean) UtilsKt.get(UtilsKt.getDataStore((MusicService) this.$result), PreferenceKeysKt.SkipSilenceInstantKey, bool2)).booleanValue();
                    return UtilsKt.get(UtilsKt.getDataStore((MusicService) this.$result), PreferenceKeysKt.AudioTrackPlaybackParamsKey, Boolean.TRUE);
                case 19:
                    Unit unit = Unit.INSTANCE;
                    MusicService musicService2 = (MusicService) this.this$0;
                    ResultKt.throwOnFailure(obj);
                    Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) this.$result;
                    if (!ref$BooleanRef.element) {
                        Timber.Forest.tag("MusicService");
                        ConnectionPool.i(new Object[0]);
                        int currentMediaItemIndex = musicService2.player.getCurrentMediaItemIndex();
                        long currentPosition = musicService2.player.getCurrentPosition();
                        boolean playWhenReady = musicService2.player.getPlayWhenReady();
                        ExoPlayerImpl exoPlayerImpl2 = musicService2.player;
                        exoPlayerImpl2.verifyApplicationThread();
                        int i11 = exoPlayerImpl2.repeatMode;
                        ExoPlayerImpl exoPlayerImpl3 = musicService2.player;
                        exoPlayerImpl3.verifyApplicationThread();
                        boolean z6 = exoPlayerImpl3.shuffleModeEnabled;
                        ExoPlayerImpl exoPlayerImpl4 = musicService2.player;
                        exoPlayerImpl4.verifyApplicationThread();
                        ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder = exoPlayerImpl4.shuffleOrder;
                        shuffleOrder$DefaultShuffleOrder.getClass();
                        PlaybackParameters playbackParameters = musicService2.player.getPlaybackParameters();
                        playbackParameters.getClass();
                        ExoPlayerImpl exoPlayerImpl5 = musicService2.player;
                        exoPlayerImpl5.verifyApplicationThread();
                        float f = exoPlayerImpl5.volume;
                        int mediaItemCount = musicService2.player.getMediaItemCount();
                        ArrayList arrayList2 = new ArrayList(mediaItemCount);
                        while (true) {
                            ExoPlayerImpl exoPlayerImpl6 = musicService2.player;
                            if (i3 < mediaItemCount) {
                                arrayList2.add(exoPlayerImpl6.getMediaItemAt(i3));
                                i3++;
                            } else {
                                exoPlayerImpl6.removeListener(musicService2);
                                SleepTimer sleepTimer = musicService2.sleepTimer;
                                if (sleepTimer != null) {
                                    musicService2.player.removeListener(sleepTimer);
                                }
                                musicService2.releaseExoPlayer(musicService2.player);
                                ExoPlayerImpl exoPlayerImplCreateExoPlayer = musicService2.createExoPlayer(null);
                                ListenerSet listenerSet = exoPlayerImplCreateExoPlayer.listeners;
                                listenerSet.add(musicService2);
                                SleepTimer sleepTimer2 = musicService2.sleepTimer;
                                if (sleepTimer2 != null) {
                                    listenerSet.add(sleepTimer2);
                                }
                                SleepTimer sleepTimer3 = musicService2.sleepTimer;
                                if (sleepTimer3 != null) {
                                    sleepTimer3.player = exoPlayerImplCreateExoPlayer;
                                }
                                try {
                                    MediaLibraryService.MediaLibrarySession mediaLibrarySession = musicService2.mediaSession;
                                    if (mediaLibrarySession != null) {
                                        mediaLibrarySession.setPlayer(exoPlayerImplCreateExoPlayer);
                                    }
                                } catch (Exception unused3) {
                                    Timber.Forest.tag("MusicService");
                                    ConnectionPool.e$1(new Object[0]);
                                }
                                exoPlayerImplCreateExoPlayer.setMediaItems(arrayList2, currentMediaItemIndex, currentPosition);
                                exoPlayerImplCreateExoPlayer.setRepeatMode(i11);
                                exoPlayerImplCreateExoPlayer.setShuffleModeEnabled(z6);
                                exoPlayerImplCreateExoPlayer.setShuffleOrder(shuffleOrder$DefaultShuffleOrder);
                                exoPlayerImplCreateExoPlayer.setPlaybackParameters(playbackParameters);
                                exoPlayerImplCreateExoPlayer.setVolume(f);
                                exoPlayerImplCreateExoPlayer.setPlayWhenReady(playWhenReady);
                                exoPlayerImplCreateExoPlayer.prepare();
                                musicService2.player = exoPlayerImplCreateExoPlayer;
                                StateFlowImpl stateFlowImpl7 = musicService2._playerFlow;
                                stateFlowImpl7.getClass();
                                stateFlowImpl7.updateState(null, exoPlayerImplCreateExoPlayer);
                                Timber.Forest.tag("MusicService");
                                ConnectionPool.i(new Object[0]);
                            }
                            break;
                        }
                    } else {
                        ref$BooleanRef.element = false;
                    }
                    return unit;
                case 20:
                    ResultKt.throwOnFailure(obj);
                    MusicService musicService3 = (MusicService) this.$result;
                    musicService3.getDatabase().updatePlaybackPosition(((MediaMetadata) this.this$0).id, new Long(musicService3.player.getCurrentPosition()));
                    return Unit.INSTANCE;
                case 21:
                    MutablePreferences mutablePreferences2 = (MutablePreferences) this.$result;
                    ResultKt.throwOnFailure(obj);
                    Preferences$Key preferences$Key5 = PreferenceKeysKt.AlarmEntriesKey;
                    List list = (List) this.this$0;
                    mutablePreferences2.set(preferences$Key5, MusicAlarmStore.serialize(list));
                    Preferences$Key preferences$Key6 = PreferenceKeysKt.AlarmNextTriggerAtKey;
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj5 : list) {
                        if (((MusicAlarmEntry) obj5).enabled) {
                            arrayList3.add(obj5);
                        }
                    }
                    Iterator it = arrayList3.iterator();
                    if (it.hasNext()) {
                        Long l2 = new Long(((MusicAlarmEntry) it.next()).nextTriggerAt);
                        if (l2.longValue() <= 0) {
                            l2 = null;
                        }
                        l = new Long(l2 != null ? l2.longValue() : Long.MAX_VALUE);
                        while (it.hasNext()) {
                            Long l3 = new Long(((MusicAlarmEntry) it.next()).nextTriggerAt);
                            if (l3.longValue() <= 0) {
                                l3 = null;
                            }
                            Long l4 = new Long(l3 != null ? l3.longValue() : Long.MAX_VALUE);
                            if (l.compareTo(l4) > 0) {
                                l = l4;
                            }
                        }
                    } else {
                        l = null;
                    }
                    if (l == null) {
                        jLongValue = -1;
                    } else {
                        Long l5 = l.longValue() != Long.MAX_VALUE ? l : null;
                        if (l5 != null) {
                            jLongValue = l5.longValue();
                        } else {
                            jLongValue = -1;
                        }
                    }
                    mutablePreferences2.set(preferences$Key6, new Long(jLongValue));
                    return Unit.INSTANCE;
                case 22:
                    ResultKt.throwOnFailure(obj);
                    if (((LensController) this.$result).getDragging()) {
                        ((PlatformHapticFeedback) ((HapticFeedback) this.this$0)).m578performHapticFeedbackCdsT49E(9);
                    }
                    return Unit.INSTANCE;
                case 23:
                    ResultKt.throwOnFailure(obj);
                    MutableState mutableState = (MutableState) this.this$0;
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        Context context = (Context) this.$result;
                        Toast.makeText(context, context.getString(R.string.max_selection_limit, new Integer(5)), 0).show();
                        mutableState.setValue(Boolean.FALSE);
                    }
                    return Unit.INSTANCE;
                case 24:
                    ResultKt.throwOnFailure(obj);
                    ((PlayerConnection) this.$result).playQueue(new LocalAlbumRadio((AlbumWithSongs) this.this$0, b3, b, z2 ? 1 : 0));
                    return Unit.INSTANCE;
                case 25:
                    ResultKt.throwOnFailure(obj);
                    ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) this.this$0;
                    SongEntity songEntity = (SongEntity) ((Function0) this.$result).invoke();
                    parcelableSnapshotMutableIntState.setIntValue(songEntity != null ? songEntity.lyricsOffset : 0);
                    return Unit.INSTANCE;
                case 26:
                    ResultKt.throwOnFailure(obj);
                    ((PlayerConnection) this.$result).playQueue(new YouTubeQueue((WatchEndpoint) this.this$0, z4 ? 1 : 0, b, z3 ? 1 : 0));
                    return Unit.INSTANCE;
                case 27:
                    ResultKt.throwOnFailure(obj);
                    PlayerConnection playerConnection = (PlayerConnection) this.$result;
                    List list2 = (List) ((MutableState) this.this$0).getValue();
                    ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        arrayList4.add(UuidKt.toMediaItem((Song) it2.next()));
                    }
                    playerConnection.playNext(arrayList4);
                    return Unit.INSTANCE;
                case 28:
                    MusicDatabase musicDatabase2 = (MusicDatabase) this.$result;
                    ResultKt.throwOnFailure(obj);
                    musicDatabase2.insert(HexFormatKt.toMediaMetadata((SongItem) this.this$0), new DatabaseDao$$ExternalSyntheticLambda0(b3));
                    return Unit.INSTANCE;
                default:
                    ResultKt.throwOnFailure(obj);
                    if (((ChartsPage) ((State) this.this$0).getValue()) == null) {
                        ChartsViewModel chartsViewModel = (ChartsViewModel) this.$result;
                        AwaitKt.launch$default(ViewModelKt.getViewModelScope(chartsViewModel), null, null, new SyncUtils.AnonymousClass2(chartsViewModel, z5 ? 1 : 0, (byte) 29), 3);
                    }
                    return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Object obj2, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$result = obj;
            this.this$0 = obj2;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = obj;
        }
    }

    public final void download(Song song) {
        song.getClass();
        download(HexFormatKt.toMediaMetadata(song));
    }

    /* JADX INFO: renamed from: com.metrolist.music.playback.DownloadUtil$download$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Object $mediaMetadata;
        public final /* synthetic */ byte $r8$classId = 0;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public Object L$7;
        public byte label;
        public Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, MusicDatabase musicDatabase, Song song, Context context, Function0 function0, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
            super(2, continuation);
            this.L$1 = str;
            this.L$2 = musicDatabase;
            this.this$0 = song;
            this.L$3 = context;
            this.$mediaMetadata = function0;
            this.L$4 = mutableState;
            this.L$7 = mutableState2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj2 = this.$mediaMetadata;
            switch (b) {
                case 0:
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1((DownloadUtil) this.this$0, (MediaMetadata) obj2, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                case 1:
                    return new AnonymousClass1((String) this.L$1, (MusicDatabase) this.L$2, (Song) this.this$0, (Context) this.L$3, (Function0) obj2, (MutableState) this.L$4, (MutableState) this.L$7, continuation);
                default:
                    return new AnonymousClass1((Mutex) this.L$3, (Function1) obj2, (Context) this.L$4, (MutableState) this.L$7, continuation);
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
            }
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        /* JADX WARN: Code duplicated, block: B:150:0x0387 A[Catch: all -> 0x03c6, TRY_LEAVE, TryCatch #4 {all -> 0x03c6, blocks: (B:148:0x0381, B:150:0x0387), top: B:175:0x0381 }] */
        /* JADX WARN: Code duplicated, block: B:185:0x03c9 A[SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v42 */
        /* JADX WARN: Type inference failed for: r2v43, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r2v44 */
        /* JADX WARN: Type inference failed for: r2v45 */
        /* JADX WARN: Type inference failed for: r2v46 */
        /* JADX WARN: Type inference failed for: r2v47, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r2v53, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r2v54 */
        /* JADX WARN: Type inference failed for: r5v29 */
        /* JADX WARN: Type inference failed for: r5v30 */
        /* JADX WARN: Type inference failed for: r5v31, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v37, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r5v38 */
        /* JADX WARN: Type inference failed for: r7v18 */
        /* JADX WARN: Type inference failed for: r7v23, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v29 */
        /* JADX WARN: Type inference failed for: r7v30 */
        /* JADX WARN: Type inference failed for: r7v31 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:154:0x03bd -> B:156:0x03c1). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:150:0x0387
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                Method dump skipped, instruction units count: 986
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.playback.DownloadUtil.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DownloadUtil downloadUtil, MediaMetadata mediaMetadata, Continuation continuation) {
            super(2, continuation);
            this.this$0 = downloadUtil;
            this.$mediaMetadata = mediaMetadata;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Mutex mutex, Function1 function1, Context context, MutableState mutableState, Continuation continuation) {
            super(2, continuation);
            this.L$3 = mutex;
            this.$mediaMetadata = function1;
            this.L$4 = context;
            this.L$7 = mutableState;
        }
    }
}
