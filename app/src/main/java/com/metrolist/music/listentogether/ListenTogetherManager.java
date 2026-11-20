package com.metrolist.music.listentogether;

import android.content.Context;
import android.os.SystemClock;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.ExoPlayerImpl;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import com.google.common.math.IntMath;
import com.google.protobuf.GeneratedMessageLite;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda7;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda117;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.utils.potoken.PoTokenGenerator;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.utils.CIOKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.LinesSequence;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.TransformingSequence;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.ReadonlySharedFlow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.ws.RealWebSocket;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ListenTogetherManager {
    public StandaloneCoroutine activeSyncJob;
    public boolean applyNextHostSnapshot;
    public final ReadonlyStateFlow blockedUsernames;
    public String bufferCompleteReceivedForTrack;
    public String bufferingTrackId;
    public final ListenTogetherClient client;
    public final ReadonlyStateFlow connectionState;
    public final Context context;
    public int currentTrackGeneration;
    public PlaybackParameters driftAppliedPlaybackParameters;
    public PlaybackParameters driftBasePlaybackParameters;
    public ExoPlayerImpl driftCorrectedPlayer;
    public int driftCorrectionGeneration;
    public StandaloneCoroutine driftCorrectionJob;
    public StandaloneCoroutine eventCollectorJob;
    public final ReadonlySharedFlow events;
    public StandaloneCoroutine heartbeatJob;
    public volatile boolean isSyncing;
    public long lastAppliedRevision;
    public RoomRole lastRole;
    public Boolean lastSyncedIsPlaying;
    public String lastSyncedTrackId;
    public Float lastSyncedVolume;
    public final ReadonlyStateFlow logs;
    public final ReadonlyStateFlow pendingJoinRequests;
    public final ReadonlyStateFlow pendingSuggestions;
    public Listentogether.SyncStatePayload pendingSyncState;
    public PlayerConnection playerConnection;
    public final ListenTogetherManager$playerListener$1 playerListener;
    public boolean playerListenerRegistered;
    public Boolean previousMuteState;
    public StandaloneCoroutine queueMutationJob;
    public StandaloneCoroutine queueObserverJob;
    public int queueSyncGeneration;
    public final ReadonlyStateFlow role;
    public final ReadonlyStateFlow roomState;
    public final ContextScope scope;
    public final StateFlowImpl syncHostVolumeEnabled;
    public final ReadonlyStateFlow userId;
    public StandaloneCoroutine volumeObserverJob;

    /* JADX INFO: renamed from: com.metrolist.music.listentogether.ListenTogetherManager$applyPlaybackState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ PlayerConnection $connection;
        public final /* synthetic */ int $generation;
        public final /* synthetic */ ExoPlayerImpl $player;
        public final /* synthetic */ List $queue;
        public final /* synthetic */ String $queueTitle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, PlayerConnection playerConnection, ExoPlayerImpl exoPlayerImpl, List list, String str, Continuation continuation) {
            super(2, continuation);
            this.$generation = i;
            this.$connection = playerConnection;
            this.$player = exoPlayerImpl;
            this.$queue = list;
            this.$queueTitle = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ListenTogetherManager.this.new AnonymousClass1(this.$generation, this.$connection, this.$player, this.$queue, this.$queueTitle, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = (AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2);
            Unit unit = Unit.INSTANCE;
            anonymousClass1.invokeSuspend(unit);
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit = Unit.INSTANCE;
            ResultKt.throwOnFailure(obj);
            ListenTogetherManager listenTogetherManager = ListenTogetherManager.this;
            if (listenTogetherManager.currentTrackGeneration != this.$generation) {
                Timber.Forest.tag("ListenTogetherManager");
                ConnectionPool.d(new Object[0]);
                return unit;
            }
            if (listenTogetherManager.playerConnection != this.$connection) {
                return unit;
            }
            listenTogetherManager.isSyncing = true;
            this.$connection.allowInternalSync = true;
            this.$player.setShuffleModeEnabled(false);
            List list = this.$queue;
            if (list == null || list.isEmpty()) {
                this.$player.clearMediaItems();
            } else {
                List list2 = this.$queue;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(UuidKt.toMediaItem(ListenTogetherManager.toMediaMetadata((Listentogether.TrackInfo) it.next())));
                }
                this.$player.setMediaItems(arrayList);
            }
            this.$connection.pause();
            try {
                this.$connection.service.queueTitle = this.$queueTitle;
            } catch (Exception unused) {
                Timber.Forest.tag("ListenTogetherManager");
                ConnectionPool.e$1(new Object[0]);
            }
            this.$connection.allowInternalSync = false;
            ListenTogetherManager.this.isSyncing = false;
            return unit;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.listentogether.ListenTogetherManager$applyPlaybackState$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ boolean $bypassBuffer;
        public final /* synthetic */ PlayerConnection $connection;
        public final /* synthetic */ Listentogether.TrackInfo $currentTrack;
        public final /* synthetic */ Long $effectiveAtServerTime;
        public final /* synthetic */ int $generation;
        public final /* synthetic */ long $initialPosition;
        public final /* synthetic */ boolean $isPlaying;
        public final /* synthetic */ ExoPlayerImpl $player;
        public final /* synthetic */ long $position;
        public final /* synthetic */ List $queue;
        public final /* synthetic */ String $queueTitle;
        public int I$0;
        public Object L$0;
        public byte label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i, Listentogether.TrackInfo trackInfo, PlayerConnection playerConnection, ExoPlayerImpl exoPlayerImpl, List list, long j, String str, boolean z, boolean z2, long j2, Long l, Continuation continuation) {
            super(2, continuation);
            this.$generation = i;
            this.$currentTrack = trackInfo;
            this.$connection = playerConnection;
            this.$player = exoPlayerImpl;
            this.$queue = list;
            this.$initialPosition = j;
            this.$queueTitle = str;
            this.$bypassBuffer = z;
            this.$isPlaying = z2;
            this.$position = j2;
            this.$effectiveAtServerTime = l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ListenTogetherManager.this.new AnonymousClass2(this.$generation, this.$currentTrack, this.$connection, this.$player, this.$queue, this.$initialPosition, this.$queueTitle, this.$bypassBuffer, this.$isPlaying, this.$position, this.$effectiveAtServerTime, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:54:0x0110  */
        /* JADX WARN: Code duplicated, block: B:62:0x012e A[Catch: all -> 0x003e, Exception -> 0x01eb, TRY_LEAVE, TryCatch #1 {Exception -> 0x01eb, blocks: (B:14:0x0039, B:59:0x0124, B:52:0x0108, B:56:0x0114, B:60:0x0126, B:62:0x012e, B:65:0x0151, B:68:0x018c, B:66:0x0176, B:67:0x0182, B:27:0x0072, B:29:0x007f, B:35:0x009e, B:37:0x00a4, B:38:0x00a6, B:39:0x00b9, B:41:0x00c2, B:42:0x00d4, B:49:0x00f9, B:51:0x00fd, B:69:0x0195, B:71:0x01a6, B:74:0x01b0, B:48:0x00ef), top: B:91:0x0013, outer: #2 }] */
        /* JADX WARN: Code duplicated, block: B:65:0x0151 A[Catch: all -> 0x003e, Exception -> 0x01eb, TRY_ENTER, TryCatch #1 {Exception -> 0x01eb, blocks: (B:14:0x0039, B:59:0x0124, B:52:0x0108, B:56:0x0114, B:60:0x0126, B:62:0x012e, B:65:0x0151, B:68:0x018c, B:66:0x0176, B:67:0x0182, B:27:0x0072, B:29:0x007f, B:35:0x009e, B:37:0x00a4, B:38:0x00a6, B:39:0x00b9, B:41:0x00c2, B:42:0x00d4, B:49:0x00f9, B:51:0x00fd, B:69:0x0195, B:71:0x01a6, B:74:0x01b0, B:48:0x00ef), top: B:91:0x0013, outer: #2 }] */
        /* JADX WARN: Code duplicated, block: B:66:0x0176 A[Catch: all -> 0x003e, Exception -> 0x01eb, TryCatch #1 {Exception -> 0x01eb, blocks: (B:14:0x0039, B:59:0x0124, B:52:0x0108, B:56:0x0114, B:60:0x0126, B:62:0x012e, B:65:0x0151, B:68:0x018c, B:66:0x0176, B:67:0x0182, B:27:0x0072, B:29:0x007f, B:35:0x009e, B:37:0x00a4, B:38:0x00a6, B:39:0x00b9, B:41:0x00c2, B:42:0x00d4, B:49:0x00f9, B:51:0x00fd, B:69:0x0195, B:71:0x01a6, B:74:0x01b0, B:48:0x00ef), top: B:91:0x0013, outer: #2 }] */
        /* JADX WARN: Code duplicated, block: B:67:0x0182 A[Catch: all -> 0x003e, Exception -> 0x01eb, TryCatch #1 {Exception -> 0x01eb, blocks: (B:14:0x0039, B:59:0x0124, B:52:0x0108, B:56:0x0114, B:60:0x0126, B:62:0x012e, B:65:0x0151, B:68:0x018c, B:66:0x0176, B:67:0x0182, B:27:0x0072, B:29:0x007f, B:35:0x009e, B:37:0x00a4, B:38:0x00a6, B:39:0x00b9, B:41:0x00c2, B:42:0x00d4, B:49:0x00f9, B:51:0x00fd, B:69:0x0195, B:71:0x01a6, B:74:0x01b0, B:48:0x00ef), top: B:91:0x0013, outer: #2 }] */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0095, code lost:
        
            if (kotlinx.coroutines.AwaitKt.delay(200, r26) == r2) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x01e3, code lost:
        
            if (kotlinx.coroutines.AwaitKt.delay(200, r26) == r2) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0203, code lost:
        
            if (kotlinx.coroutines.AwaitKt.delay(200, r26) == r2) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x0216, code lost:
        
            if (kotlinx.coroutines.AwaitKt.delay(200, r26) == r2) goto L86;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0120 -> B:59:0x0124). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            int i;
            ConnectionPool connectionPool;
            boolean z;
            PlayerConnection playerConnection;
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            byte b = this.label;
            try {
                try {
                    if (b == 0) {
                        ResultKt.throwOnFailure(obj);
                        ListenTogetherManager listenTogetherManager = ListenTogetherManager.this;
                        if (listenTogetherManager.currentTrackGeneration != this.$generation) {
                            Timber.Forest.tag("ListenTogetherManager");
                            this.$currentTrack.getId();
                            ConnectionPool.d(new Object[0]);
                            return unit;
                        }
                        if (listenTogetherManager.playerConnection == this.$connection) {
                            listenTogetherManager.isSyncing = true;
                            this.$connection.allowInternalSync = true;
                            this.$player.setShuffleModeEnabled(false);
                            if (ListenTogetherManager.this.currentTrackGeneration != this.$generation) {
                                Timber.Forest.tag("ListenTogetherManager");
                                ConnectionPool.d(new Object[0]);
                                this.$connection.allowInternalSync = false;
                                this.L$0 = unit;
                                this.label = (byte) 1;
                            } else {
                                Listentogether.TrackInfo trackInfo = this.$currentTrack;
                                List list = this.$queue;
                                if (list == null) {
                                    list = EmptyList.INSTANCE;
                                }
                                ListBuilder listBuilderCanonicalPlaybackQueue = ListenTogetherManagerKt.canonicalPlaybackQueue(trackInfo, list);
                                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listBuilderCanonicalPlaybackQueue, 10));
                                ListIterator listIterator = listBuilderCanonicalPlaybackQueue.listIterator(0);
                                while (true) {
                                    ListBuilder.Itr itr = (ListBuilder.Itr) listIterator;
                                    if (!itr.hasNext()) {
                                        break;
                                    }
                                    arrayList.add(UuidKt.toMediaItem(ListenTogetherManager.toMediaMetadata((Listentogether.TrackInfo) itr.next())));
                                }
                                this.$player.setMediaItems(arrayList, 0, this.$initialPosition);
                                this.$connection.seekTo(this.$initialPosition);
                                try {
                                    MusicService musicService = this.$connection.service;
                                    String str = this.$queueTitle;
                                    if (str == null) {
                                        str = "Listen Together";
                                    }
                                    musicService.queueTitle = str;
                                } catch (Exception unused) {
                                    Timber.Forest.tag("ListenTogetherManager");
                                    ConnectionPool.e$1(new Object[0]);
                                }
                                if (this.$bypassBuffer) {
                                    Timber.Forest.tag("ListenTogetherManager");
                                    ConnectionPool.d(new Object[0]);
                                    i = 0;
                                    if (this.$player.getPlaybackState() != 3) {
                                    }
                                    if (this.$player.getPlaybackState() == 3) {
                                        long jPositionAtServerTime$app = ListenTogetherManager.this.client.positionAtServerTime$app(this.$position, this.$effectiveAtServerTime, this.$isPlaying);
                                        connectionPool = Timber.Forest;
                                        connectionPool.tag("ListenTogetherManager");
                                        ConnectionPool.d(new Object[0]);
                                        this.$player.seekToCurrentItem(jPositionAtServerTime$app);
                                        z = this.$isPlaying;
                                        playerConnection = this.$connection;
                                        if (z) {
                                            playerConnection.play();
                                            ListenTogetherManager.this.startDriftCorrection(this.$connection, this.$currentTrack.getId(), this.$position, this.$effectiveAtServerTime);
                                            connectionPool.tag("ListenTogetherManager");
                                            ConnectionPool.d(new Object[0]);
                                        } else {
                                            playerConnection.pause();
                                            connectionPool.tag("ListenTogetherManager");
                                            ConnectionPool.d(new Object[0]);
                                        }
                                    } else {
                                        Timber.Forest.tag("ListenTogetherManager");
                                        ConnectionPool.w(new Object[0]);
                                    }
                                    ListenTogetherManager listenTogetherManager2 = ListenTogetherManager.this;
                                    listenTogetherManager2.pendingSyncState = null;
                                    listenTogetherManager2.bufferingTrackId = null;
                                    listenTogetherManager2.bufferCompleteReceivedForTrack = null;
                                } else {
                                    this.$connection.pause();
                                    ListenTogetherManager listenTogetherManager3 = ListenTogetherManager.this;
                                    Listentogether.TrackInfo trackInfo2 = this.$currentTrack;
                                    boolean z2 = this.$isPlaying;
                                    long j = this.$position;
                                    Long l = this.$effectiveAtServerTime;
                                    listenTogetherManager3.pendingSyncState = ProtocolKt.SyncStatePayload(trackInfo2, z2, j, l != null ? l.longValue() : 0L, null, null, (112 & 64) != 0 ? 0L : 0L);
                                    ListenTogetherManager.this.applyPendingSyncIfReady();
                                    ListenTogetherClient listenTogetherClient = ListenTogetherManager.this.client;
                                    String id = this.$currentTrack.getId();
                                    id.getClass();
                                    listenTogetherClient.sendBufferReady(id);
                                }
                                this.$connection.allowInternalSync = false;
                                this.L$0 = null;
                                this.label = (byte) 3;
                            }
                            return coroutineSingletons;
                        }
                        return unit;
                    }
                    if (b != 1) {
                        if (b == 2) {
                            i = this.I$0;
                            ResultKt.throwOnFailure(obj);
                            i++;
                            if (this.$player.getPlaybackState() != 3 || i >= 100) {
                                if (this.$player.getPlaybackState() == 3) {
                                    long jPositionAtServerTime$app2 = ListenTogetherManager.this.client.positionAtServerTime$app(this.$position, this.$effectiveAtServerTime, this.$isPlaying);
                                    connectionPool = Timber.Forest;
                                    connectionPool.tag("ListenTogetherManager");
                                    ConnectionPool.d(new Object[0]);
                                    this.$player.seekToCurrentItem(jPositionAtServerTime$app2);
                                    z = this.$isPlaying;
                                    playerConnection = this.$connection;
                                    if (z) {
                                        playerConnection.play();
                                        ListenTogetherManager.this.startDriftCorrection(this.$connection, this.$currentTrack.getId(), this.$position, this.$effectiveAtServerTime);
                                        connectionPool.tag("ListenTogetherManager");
                                        ConnectionPool.d(new Object[0]);
                                    } else {
                                        playerConnection.pause();
                                        connectionPool.tag("ListenTogetherManager");
                                        ConnectionPool.d(new Object[0]);
                                    }
                                } else {
                                    Timber.Forest.tag("ListenTogetherManager");
                                    ConnectionPool.w(new Object[0]);
                                }
                                ListenTogetherManager listenTogetherManager4 = ListenTogetherManager.this;
                                listenTogetherManager4.pendingSyncState = null;
                                listenTogetherManager4.bufferingTrackId = null;
                                listenTogetherManager4.bufferCompleteReceivedForTrack = null;
                                this.$connection.allowInternalSync = false;
                                this.L$0 = null;
                                this.label = (byte) 3;
                            } else {
                                this.L$0 = null;
                                this.I$0 = i;
                                this.label = (byte) 2;
                                if (AwaitKt.delay(50L, this) != coroutineSingletons) {
                                    i++;
                                    if (this.$player.getPlaybackState() != 3) {
                                    }
                                    if (this.$player.getPlaybackState() == 3) {
                                        long jPositionAtServerTime$app3 = ListenTogetherManager.this.client.positionAtServerTime$app(this.$position, this.$effectiveAtServerTime, this.$isPlaying);
                                        connectionPool = Timber.Forest;
                                        connectionPool.tag("ListenTogetherManager");
                                        ConnectionPool.d(new Object[0]);
                                        this.$player.seekToCurrentItem(jPositionAtServerTime$app3);
                                        z = this.$isPlaying;
                                        playerConnection = this.$connection;
                                        if (z) {
                                            playerConnection.play();
                                            ListenTogetherManager.this.startDriftCorrection(this.$connection, this.$currentTrack.getId(), this.$position, this.$effectiveAtServerTime);
                                            connectionPool.tag("ListenTogetherManager");
                                            ConnectionPool.d(new Object[0]);
                                        } else {
                                            playerConnection.pause();
                                            connectionPool.tag("ListenTogetherManager");
                                            ConnectionPool.d(new Object[0]);
                                        }
                                    } else {
                                        Timber.Forest.tag("ListenTogetherManager");
                                        ConnectionPool.w(new Object[0]);
                                    }
                                    ListenTogetherManager listenTogetherManager5 = ListenTogetherManager.this;
                                    listenTogetherManager5.pendingSyncState = null;
                                    listenTogetherManager5.bufferingTrackId = null;
                                    listenTogetherManager5.bufferCompleteReceivedForTrack = null;
                                    this.$connection.allowInternalSync = false;
                                    this.L$0 = null;
                                    this.label = (byte) 3;
                                }
                            }
                            return coroutineSingletons;
                        }
                        if (b != 3 && b != 4) {
                            if (b != 5) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            th = (Throwable) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            ListenTogetherManager.this.isSyncing = false;
                            throw th;
                        }
                        ResultKt.throwOnFailure(obj);
                        ListenTogetherManager.this.isSyncing = false;
                        return unit;
                    }
                    unit = (Unit) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    ListenTogetherManager.this.isSyncing = false;
                    return unit;
                } catch (Exception unused2) {
                    Timber.Forest.tag("ListenTogetherManager");
                    ConnectionPool.e$1(new Object[0]);
                    this.$connection.allowInternalSync = false;
                    this.L$0 = null;
                    this.label = (byte) 4;
                }
            } catch (Throwable th) {
                th = th;
                this.$connection.allowInternalSync = false;
                this.L$0 = th;
                this.label = (byte) 5;
            }
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.listentogether.ListenTogetherManager$enqueueQueueMutation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01511 extends SuspendLambda implements Function2 {
        public final /* synthetic */ int $generation;
        public final /* synthetic */ Function1 $mutation;
        public final /* synthetic */ Job $previous;
        public byte label;
        public final /* synthetic */ ListenTogetherManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01511(Job job, int i, ListenTogetherManager listenTogetherManager, Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.$previous = job;
            this.$generation = i;
            this.this$0 = listenTogetherManager;
            this.$mutation = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C01511(this.$previous, this.$generation, this.this$0, this.$mutation, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C01511) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.label;
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (b == 0) {
                ResultKt.throwOnFailure(obj);
                Job job = this.$previous;
                if (job != null) {
                    this.label = (byte) 1;
                    if (job.join(this) != coroutineSingletons) {
                    }
                }
                return coroutineSingletons;
            }
            if (b != 1) {
                if (b == 2) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            if (this.$generation == this.this$0.queueSyncGeneration) {
                this.label = (byte) 2;
                if (this.$mutation.invoke(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return unit;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.listentogether.ListenTogetherManager$handlePlaybackSync$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01522 extends SuspendLambda implements Function1 {
        public final /* synthetic */ Listentogether.PlaybackActionPayload $action;
        public final /* synthetic */ int $actionQueueGeneration;
        public final /* synthetic */ PlayerConnection $connection;
        public final /* synthetic */ Listentogether.TrackInfo $track;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01522(int i, PlayerConnection playerConnection, Listentogether.TrackInfo trackInfo, Listentogether.PlaybackActionPayload playbackActionPayload, Continuation continuation) {
            super(1, continuation);
            this.$actionQueueGeneration = i;
            this.$connection = playerConnection;
            this.$track = trackInfo;
            this.$action = playbackActionPayload;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ListenTogetherManager.this.new C01522(this.$actionQueueGeneration, this.$connection, this.$track, this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return ((C01522) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            boolean z = this.label;
            MediaItem mediaItem = null;
            if (!z) {
                ResultKt.throwOnFailure(obj);
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                ListenTogetherManager$handlePlaybackSync$2$result$1 listenTogetherManager$handlePlaybackSync$2$result$1 = new ListenTogetherManager$handlePlaybackSync$2$result$1(this.$track, null);
                this.label = true;
                obj = AwaitKt.withContext(defaultIoScheduler, listenTogetherManager$handlePlaybackSync$2$result$1, this);
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
            Object obj2 = ((Result) obj).value;
            ListenTogetherManager listenTogetherManager = ListenTogetherManager.this;
            if (listenTogetherManager.queueSyncGeneration == this.$actionQueueGeneration) {
                PlayerConnection playerConnection = listenTogetherManager.playerConnection;
                PlayerConnection playerConnection2 = this.$connection;
                if (playerConnection == playerConnection2) {
                    Listentogether.TrackInfo trackInfo = this.$track;
                    Listentogether.PlaybackActionPayload playbackActionPayload = this.$action;
                    if (!(obj2 instanceof Result.Failure)) {
                        SongItem songItem = (SongItem) CollectionsKt.firstOrNull((List) obj2);
                        if (songItem != null) {
                            MediaMetadata mediaMetadata = HexFormatKt.toMediaMetadata(songItem);
                            String suggestedBy = trackInfo.getSuggestedBy();
                            if (!(suggestedBy.length() > 0)) {
                                suggestedBy = null;
                            }
                            mediaItem = UuidKt.toMediaItem(MediaMetadata.copy$default(mediaMetadata, null, 0, suggestedBy, 114687));
                        }
                        if (mediaItem != null) {
                            playerConnection2.allowInternalSync = true;
                            try {
                                if (playbackActionPayload.getInsertNext()) {
                                    playerConnection2.playNext(CollectionsKt__IterablesKt.listOf(mediaItem));
                                } else {
                                    playerConnection2.addToQueue(CollectionsKt__IterablesKt.listOf(mediaItem));
                                }
                                playerConnection2.allowInternalSync = false;
                            } catch (Throwable th) {
                                playerConnection2.allowInternalSync = false;
                                throw th;
                            }
                        } else {
                            Timber.Forest.tag("ListenTogetherManager");
                            trackInfo.getId();
                            ConnectionPool.w(new Object[0]);
                        }
                    }
                    if (Result.m1866exceptionOrNullimpl(obj2) != null) {
                        Timber.Forest.tag("ListenTogetherManager");
                        ConnectionPool.e$1(new Object[0]);
                    }
                }
            }
            return unit;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.listentogether.ListenTogetherManager$handlePlaybackSync$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass3 extends SuspendLambda implements Function1 {
        public final /* synthetic */ PlayerConnection $connection;
        public final /* synthetic */ ExoPlayerImpl $player;
        public final /* synthetic */ String $removeId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(PlayerConnection playerConnection, ExoPlayerImpl exoPlayerImpl, String str, Continuation continuation) {
            super(1, continuation);
            this.$connection = playerConnection;
            this.$player = exoPlayerImpl;
            this.$removeId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ListenTogetherManager.this.new AnonymousClass3(this.$connection, this.$player, this.$removeId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            AnonymousClass3 anonymousClass3 = (AnonymousClass3) create((Continuation) obj);
            Unit unit = Unit.INSTANCE;
            anonymousClass3.invokeSuspend(unit);
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ResultKt.throwOnFailure(obj);
            PlayerConnection playerConnection = ListenTogetherManager.this.playerConnection;
            PlayerConnection playerConnection2 = this.$connection;
            Unit unit = Unit.INSTANCE;
            if (playerConnection != playerConnection2) {
                return unit;
            }
            ExoPlayerImpl exoPlayerImpl = this.$player;
            int currentMediaItemIndex = exoPlayerImpl.getCurrentMediaItemIndex() + 1;
            int mediaItemCount = exoPlayerImpl.getMediaItemCount();
            while (true) {
                if (currentMediaItemIndex >= mediaItemCount) {
                    currentMediaItemIndex = -1;
                    break;
                }
                String str = exoPlayerImpl.getMediaItemAt(currentMediaItemIndex).mediaId;
                str.getClass();
                if (str.equals(this.$removeId)) {
                    break;
                }
                currentMediaItemIndex++;
            }
            if (currentMediaItemIndex < 0) {
                Timber.Forest.tag("ListenTogetherManager");
                ConnectionPool.w(new Object[0]);
                return unit;
            }
            Timber.Forest.tag("ListenTogetherManager");
            ConnectionPool.d(new Object[0]);
            exoPlayerImpl.removeMediaItem(currentMediaItemIndex);
            return unit;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.listentogether.ListenTogetherManager$handlePlaybackSync$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass4 extends SuspendLambda implements Function1 {
        public final /* synthetic */ PlayerConnection $connection;
        public final /* synthetic */ ExoPlayerImpl $player;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(PlayerConnection playerConnection, ExoPlayerImpl exoPlayerImpl, Continuation continuation) {
            super(1, continuation);
            this.$connection = playerConnection;
            this.$player = exoPlayerImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ListenTogetherManager.this.new AnonymousClass4(this.$connection, this.$player, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            AnonymousClass4 anonymousClass4 = (AnonymousClass4) create((Continuation) obj);
            Unit unit = Unit.INSTANCE;
            anonymousClass4.invokeSuspend(unit);
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ResultKt.throwOnFailure(obj);
            PlayerConnection playerConnection = ListenTogetherManager.this.playerConnection;
            PlayerConnection playerConnection2 = this.$connection;
            Unit unit = Unit.INSTANCE;
            if (playerConnection == playerConnection2) {
                ExoPlayerImpl exoPlayerImpl = this.$player;
                int currentMediaItemIndex = exoPlayerImpl.getCurrentMediaItemIndex() + 1;
                int mediaItemCount = exoPlayerImpl.getMediaItemCount() - currentMediaItemIndex;
                if (mediaItemCount > 0) {
                    Timber.Forest.tag("ListenTogetherManager");
                    ConnectionPool.d(new Object[0]);
                    exoPlayerImpl.removeMediaItems(currentMediaItemIndex, mediaItemCount);
                }
            }
            return unit;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.listentogether.ListenTogetherManager$handlePlaybackSync$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass6 extends SuspendLambda implements Function2 {
        public boolean label;

        public AnonymousClass6(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ListenTogetherManager.this.new AnonymousClass6(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass6) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            boolean z = this.label;
            if (!z) {
                ResultKt.throwOnFailure(obj);
                this.label = true;
                if (AwaitKt.delay(200L, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            ListenTogetherManager.this.isSyncing = false;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.listentogether.ListenTogetherManager$startDriftCorrection$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01531 extends SuspendLambda implements Function2 {
        public final /* synthetic */ PlaybackParameters $baseParameters;
        public final /* synthetic */ PlayerConnection $connection;
        public final /* synthetic */ Long $effectiveAtServerTime;
        public final /* synthetic */ int $generation;
        public final /* synthetic */ ExoPlayerImpl $player;
        public final /* synthetic */ long $position;
        public final /* synthetic */ String $trackId;
        public boolean label;
        public final /* synthetic */ ListenTogetherManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01531(int i, ListenTogetherManager listenTogetherManager, PlayerConnection playerConnection, ExoPlayerImpl exoPlayerImpl, String str, long j, Long l, PlaybackParameters playbackParameters, Continuation continuation) {
            super(2, continuation);
            this.$generation = i;
            this.this$0 = listenTogetherManager;
            this.$connection = playerConnection;
            this.$player = exoPlayerImpl;
            this.$trackId = str;
            this.$position = j;
            this.$effectiveAtServerTime = l;
            this.$baseParameters = playbackParameters;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C01531(this.$generation, this.this$0, this.$connection, this.$player, this.$trackId, this.$position, this.$effectiveAtServerTime, this.$baseParameters, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C01531) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0042  */
        /* JADX WARN: Code duplicated, block: B:27:0x005c  */
        /* JADX WARN: Code duplicated, block: B:30:0x0066  */
        /* JADX WARN: Code duplicated, block: B:36:0x007a  */
        /* JADX WARN: Code duplicated, block: B:37:0x007e  */
        /* JADX WARN: Code duplicated, block: B:51:0x009f A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:52:0x0062 A[SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            long jPositionAtServerTime$app;
            long currentPosition;
            long jAbs;
            PlaybackParameters playbackParameters;
            float f;
            Object objDelay;
            CoroutineSingletons coroutineSingletons;
            boolean z = this.label;
            if (z && !z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            do {
                ListenTogetherManager listenTogetherManager = this.this$0;
                int i = listenTogetherManager.driftCorrectionGeneration;
                int i2 = this.$generation;
                if (i2 == i) {
                    PlayerConnection playerConnection = listenTogetherManager.playerConnection;
                    PlayerConnection playerConnection2 = this.$connection;
                    if (playerConnection == playerConnection2 && !listenTogetherManager.isHost()) {
                        ExoPlayerImpl exoPlayerImpl = this.$player;
                        if (exoPlayerImpl.getPlayWhenReady()) {
                            String str = this.$trackId;
                            if (str == null) {
                                jPositionAtServerTime$app = listenTogetherManager.client.positionAtServerTime$app(this.$position, this.$effectiveAtServerTime, true);
                                currentPosition = jPositionAtServerTime$app - exoPlayerImpl.getCurrentPosition();
                                jAbs = Math.abs(currentPosition);
                                if (jAbs <= 50) {
                                    if (jAbs >= 750) {
                                        playerConnection2.seekTo(jPositionAtServerTime$app);
                                    } else {
                                        playbackParameters = listenTogetherManager.driftAppliedPlaybackParameters;
                                        if (playbackParameters != null || Intrinsics.areEqual(exoPlayerImpl.getPlaybackParameters(), playbackParameters)) {
                                            if (currentPosition > 0) {
                                                f = 1.02f;
                                            } else {
                                                f = 0.98f;
                                            }
                                            PlaybackParameters playbackParameters2 = this.$baseParameters;
                                            PlaybackParameters playbackParameters3 = new PlaybackParameters(playbackParameters2.speed * f, playbackParameters2.pitch);
                                            exoPlayerImpl.setPlaybackParameters(playbackParameters3);
                                            listenTogetherManager.driftAppliedPlaybackParameters = playbackParameters3;
                                            this.label = true;
                                            objDelay = AwaitKt.delay(250L, this);
                                            coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                        }
                                    }
                                }
                            } else {
                                MediaItem currentMediaItem = exoPlayerImpl.getCurrentMediaItem();
                                if (Intrinsics.areEqual(currentMediaItem != null ? currentMediaItem.mediaId : null, str)) {
                                    jPositionAtServerTime$app = listenTogetherManager.client.positionAtServerTime$app(this.$position, this.$effectiveAtServerTime, true);
                                    currentPosition = jPositionAtServerTime$app - exoPlayerImpl.getCurrentPosition();
                                    jAbs = Math.abs(currentPosition);
                                    if (jAbs <= 50) {
                                        if (jAbs >= 750) {
                                            playerConnection2.seekTo(jPositionAtServerTime$app);
                                        } else {
                                            playbackParameters = listenTogetherManager.driftAppliedPlaybackParameters;
                                            if (playbackParameters != null) {
                                            }
                                            if (currentPosition > 0) {
                                                f = 1.02f;
                                            } else {
                                                f = 0.98f;
                                            }
                                            PlaybackParameters playbackParameters4 = this.$baseParameters;
                                            PlaybackParameters playbackParameters5 = new PlaybackParameters(playbackParameters4.speed * f, playbackParameters4.pitch);
                                            exoPlayerImpl.setPlaybackParameters(playbackParameters5);
                                            listenTogetherManager.driftAppliedPlaybackParameters = playbackParameters5;
                                            this.label = true;
                                            objDelay = AwaitKt.delay(250L, this);
                                            coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (i2 == listenTogetherManager.driftCorrectionGeneration) {
                    listenTogetherManager.restoreDriftCorrectionSpeed();
                    listenTogetherManager.driftCorrectionJob = null;
                }
                return Unit.INSTANCE;
            } while (objDelay != coroutineSingletons);
            return coroutineSingletons;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.listentogether.ListenTogetherManager$startHeartbeat$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01541 extends SuspendLambda implements Function2 {
        public boolean label;

        public C01541(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ListenTogetherManager.this.new C01541(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C01541) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0039 -> B:20:0x003c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            StandaloneCoroutine standaloneCoroutine;
            ExoPlayerImpl playerSafe;
            ListenTogetherManager listenTogetherManager = ListenTogetherManager.this;
            ListenTogetherClient listenTogetherClient = listenTogetherManager.client;
            boolean z = this.label;
            if (!z) {
                ResultKt.throwOnFailure(obj);
                standaloneCoroutine = listenTogetherManager.heartbeatJob;
                if (standaloneCoroutine != null || !standaloneCoroutine.isActive() || !listenTogetherClient.isInRoom() || !listenTogetherManager.isHost()) {
                    return Unit.INSTANCE;
                }
                this.label = true;
                Object objDelay = AwaitKt.delay(PoTokenGenerator.POTOKEN_TIMEOUT_MS, this);
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
            PlayerConnection playerConnection = listenTogetherManager.playerConnection;
            if (playerConnection != null && (playerSafe = playerConnection.getPlayerSafe()) != null && playerSafe.getPlayWhenReady() && playerSafe.getPlaybackState() == 3) {
                long currentPosition = playerSafe.getCurrentPosition();
                MediaItem currentMediaItem = playerSafe.getCurrentMediaItem();
                String str = currentMediaItem != null ? currentMediaItem.mediaId : null;
                Timber.Forest.tag("ListenTogetherManager");
                ConnectionPool.d(new Object[0]);
                ListenTogetherClient.sendPlaybackAction$default(listenTogetherClient, "play", str, new Long(currentPosition), null, null, null, null, 248);
            }
            standaloneCoroutine = listenTogetherManager.heartbeatJob;
            if (standaloneCoroutine != null) {
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.listentogether.ListenTogetherManager$startQueueSyncObservation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01551 extends SuspendLambda implements Function2 {
        public boolean label;

        /* JADX INFO: renamed from: com.metrolist.music.listentogether.ListenTogetherManager$startQueueSyncObservation$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class AnonymousClass2 extends SuspendLambda implements Function2 {
            public /* synthetic */ Object L$0;
            public boolean label;
            public final /* synthetic */ ListenTogetherManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(ListenTogetherManager listenTogetherManager, Continuation continuation) {
                super(2, continuation);
                this.this$0 = listenTogetherManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ((AnonymousClass2) create((List) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                StateFlowImpl stateFlowImpl;
                Unit unit = Unit.INSTANCE;
                List list = (List) this.L$0;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z = this.label;
                String str = null;
                try {
                    if (!z) {
                        ResultKt.throwOnFailure(obj);
                        if (this.this$0.isHost() && this.this$0.client.isInRoom() && !this.this$0.isSyncing) {
                            this.L$0 = list;
                            this.label = true;
                            if (AwaitKt.delay(500L, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        return unit;
                    }
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    PlayerConnection playerConnection = this.this$0.playerConnection;
                    if (playerConnection != null && (stateFlowImpl = playerConnection.queueTitle) != null) {
                        str = (String) stateFlowImpl.getValue();
                    }
                } catch (Exception unused) {
                    Timber.Forest.tag("ListenTogetherManager");
                    ConnectionPool.e$1(new Object[0]);
                }
                Timber.Forest.tag("ListenTogetherManager");
                list.size();
                ConnectionPool.d(new Object[0]);
                ListenTogetherClient.sendPlaybackAction$default(this.this$0.client, "sync_queue", null, null, null, list, str, null, 158);
                return unit;
            }
        }

        public C01551(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ListenTogetherManager.this.new C01551(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C01551) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z = this.label;
            if (!z) {
                ResultKt.throwOnFailure(obj);
                ListenTogetherManager listenTogetherManager = ListenTogetherManager.this;
                PlayerConnection playerConnection = listenTogetherManager.playerConnection;
                if (playerConnection != null) {
                    Flow flowDistinctUntilChanged = StateFlowKt.distinctUntilChanged(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(playerConnection.queueWindows, playerConnection.currentWindowIndex, new ListenTogetherManager$startQueueSyncObservation$1$1$1(listenTogetherManager, null), (byte) 0));
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(listenTogetherManager, null);
                    this.label = true;
                    Object objCollectLatest = StateFlowKt.collectLatest(flowDistinctUntilChanged, anonymousClass2, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objCollectLatest == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            } else {
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.listentogether.ListenTogetherManager$syncToTrack$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01561 extends SuspendLambda implements Function2 {
        public final /* synthetic */ int $generation;
        public final /* synthetic */ Listentogether.TrackInfo $track;
        public /* synthetic */ Object L$0;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01561(int i, Listentogether.TrackInfo trackInfo, Continuation continuation) {
            super(2, continuation);
            this.$generation = i;
            this.$track = trackInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C01561 c01561 = ListenTogetherManager.this.new C01561(this.$generation, this.$track, continuation);
            c01561.L$0 = obj;
            return c01561;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C01561) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM989queue0E7RQCE$default;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            boolean z = this.label;
            try {
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    if (ListenTogetherManager.this.currentTrackGeneration != this.$generation) {
                        Timber.Forest.tag("ListenTogetherManager");
                        this.$track.getId();
                        ConnectionPool.d(new Object[0]);
                        ListenTogetherManager.this.isSyncing = false;
                        return unit;
                    }
                    YouTube youTube = YouTube.INSTANCE;
                    List listListOf = CollectionsKt__IterablesKt.listOf(this.$track.getId());
                    this.L$0 = coroutineScope;
                    this.label = true;
                    objM989queue0E7RQCE$default = YouTube.m989queue0E7RQCE$default(listListOf, this);
                    if (objM989queue0E7RQCE$default == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM989queue0E7RQCE$default = ((Result) obj).value;
                }
                Listentogether.TrackInfo trackInfo = this.$track;
                ListenTogetherManager listenTogetherManager = ListenTogetherManager.this;
                int i = this.$generation;
                if (!(objM989queue0E7RQCE$default instanceof Result.Failure)) {
                    Timber.Forest.tag("ListenTogetherManager");
                    trackInfo.getId();
                    ConnectionPool.d(new Object[0]);
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    AwaitKt.launch$default(coroutineScope, MainDispatcherLoader.dispatcher, null, new ListenTogetherManager$syncToTrack$1$1$1(listenTogetherManager, i, trackInfo, (List) objM989queue0E7RQCE$default, null), 2);
                }
                Listentogether.TrackInfo trackInfo2 = this.$track;
                ListenTogetherManager listenTogetherManager2 = ListenTogetherManager.this;
                if (Result.m1866exceptionOrNullimpl(objM989queue0E7RQCE$default) != null) {
                    Timber.Forest.tag("ListenTogetherManager");
                    trackInfo2.getId();
                    ConnectionPool.e$1(new Object[0]);
                    PlayerConnection playerConnection = listenTogetherManager2.playerConnection;
                    if (playerConnection != null) {
                        playerConnection.allowInternalSync = false;
                    }
                    listenTogetherManager2.isSyncing = false;
                }
                return unit;
            } catch (Exception unused) {
                Timber.Forest.tag("ListenTogetherManager");
                ConnectionPool.e$1(new Object[0]);
                PlayerConnection playerConnection2 = ListenTogetherManager.this.playerConnection;
                if (playerConnection2 != null) {
                    playerConnection2.allowInternalSync = false;
                }
                ListenTogetherManager.this.isSyncing = false;
                return unit;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.metrolist.music.listentogether.ListenTogetherManager$playerListener$1] */
    public ListenTogetherManager(ListenTogetherClient listenTogetherClient, Context context) {
        this.client = listenTogetherClient;
        this.context = context;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        ContextScope contextScopeCoroutineScope = AwaitKt.CoroutineScope(MainDispatcherLoader.dispatcher.plus(AwaitKt.SupervisorJob$default()));
        this.scope = contextScopeCoroutineScope;
        AwaitKt.launch$default(contextScopeCoroutineScope, null, null, new ListenTogetherManager$initialize$1(this, null, (byte) 3), 3);
        this.syncHostVolumeEnabled = StateFlowKt.MutableStateFlow(Boolean.TRUE);
        this.lastRole = RoomRole.NONE;
        this.connectionState = listenTogetherClient.connectionState;
        this.roomState = listenTogetherClient.roomState;
        this.role = listenTogetherClient.role;
        this.userId = listenTogetherClient.userId;
        this.pendingJoinRequests = listenTogetherClient.pendingJoinRequests;
        this.logs = listenTogetherClient.logs;
        this.events = listenTogetherClient.events;
        this.blockedUsernames = listenTogetherClient.blockedUsernames;
        this.pendingSuggestions = listenTogetherClient.pendingSuggestions;
        this.playerListener = new Player.Listener() { // from class: com.metrolist.music.listentogether.ListenTogetherManager$playerListener$1
            @Override // androidx.media3.common.Player.Listener
            public final void onMediaItemTransition(int i, MediaItem mediaItem) {
                PlayerConnection playerConnection;
                try {
                    if (!this.this$0.isSyncing && this.this$0.isHost() && this.this$0.client.isInRoom() && mediaItem != null && (playerConnection = this.this$0.playerConnection) != null && !playerConnection.allowInternalSync) {
                        ExoPlayerImpl playerSafe = playerConnection.getPlayerSafe();
                        String str = mediaItem.mediaId;
                        str.getClass();
                        if (str.equals(this.this$0.lastSyncedTrackId)) {
                            return;
                        }
                        MediaMetadata currentMetadata = IntMath.getCurrentMetadata(playerSafe);
                        if (currentMetadata == null) {
                            Timber.Forest.tag("ListenTogetherManager");
                            ConnectionPool.w(new Object[0]);
                            return;
                        }
                        ListenTogetherManager listenTogetherManager = this.this$0;
                        listenTogetherManager.lastSyncedTrackId = str;
                        listenTogetherManager.lastSyncedIsPlaying = Boolean.FALSE;
                        ConnectionPool connectionPool = Timber.Forest;
                        connectionPool.tag("ListenTogetherManager");
                        ConnectionPool.d(new Object[0]);
                        listenTogetherManager.sendTrackChangeInternal(currentMetadata);
                        if (playerSafe.getPlayWhenReady()) {
                            connectionPool.tag("ListenTogetherManager");
                            ConnectionPool.d(new Object[0]);
                            listenTogetherManager.lastSyncedIsPlaying = Boolean.TRUE;
                            ListenTogetherClient.sendPlaybackAction$default(listenTogetherManager.client, "play", str, Long.valueOf(playerSafe.getCurrentPosition()), null, null, null, null, 248);
                        }
                    }
                } catch (Exception unused) {
                    Timber.Forest.tag("ListenTogetherManager");
                    ConnectionPool.e$1(new Object[0]);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onPlayWhenReadyChanged(int i, boolean z) {
                PlayerConnection playerConnection;
                try {
                    if (!this.this$0.isSyncing && this.this$0.isHost() && this.this$0.client.isInRoom() && (playerConnection = this.this$0.playerConnection) != null && !playerConnection.allowInternalSync) {
                        ExoPlayerImpl playerSafe = playerConnection.getPlayerSafe();
                        ConnectionPool connectionPool = Timber.Forest;
                        connectionPool.tag("ListenTogetherManager");
                        ConnectionPool.d(new Object[0]);
                        MediaItem currentMediaItem = playerSafe.getCurrentMediaItem();
                        String str = currentMediaItem != null ? currentMediaItem.mediaId : null;
                        if (str == null || str.equals(this.this$0.lastSyncedTrackId)) {
                            sendPlayState(z, playerSafe);
                            return;
                        }
                        connectionPool.tag("ListenTogetherManager");
                        "[SYNC] Sending track change before play state: track = ".concat(str);
                        ConnectionPool.d(new Object[0]);
                        MediaMetadata currentMetadata = IntMath.getCurrentMetadata(playerSafe);
                        if (currentMetadata != null) {
                            ListenTogetherManager listenTogetherManager = this.this$0;
                            listenTogetherManager.sendTrackChangeInternal(currentMetadata);
                            listenTogetherManager.lastSyncedTrackId = str;
                            listenTogetherManager.lastSyncedIsPlaying = Boolean.FALSE;
                        }
                        if (z) {
                            connectionPool.tag("ListenTogetherManager");
                            ConnectionPool.d(new Object[0]);
                            ListenTogetherManager listenTogetherManager2 = this.this$0;
                            listenTogetherManager2.lastSyncedIsPlaying = Boolean.TRUE;
                            ListenTogetherClient.sendPlaybackAction$default(listenTogetherManager2.client, "play", str, Long.valueOf(playerSafe.getCurrentPosition()), null, null, null, null, 248);
                        }
                    }
                } catch (Exception unused) {
                    Timber.Forest.tag("ListenTogetherManager");
                    ConnectionPool.e$1(new Object[0]);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onPositionDiscontinuity(int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
                ExoPlayerImpl playerSafe;
                MediaItem currentMediaItem;
                positionInfo.getClass();
                positionInfo2.getClass();
                try {
                    if (!this.this$0.isSyncing && this.this$0.isHost() && this.this$0.client.isInRoom()) {
                        PlayerConnection playerConnection = this.this$0.playerConnection;
                        if ((playerConnection == null || !playerConnection.allowInternalSync) && i == 1) {
                            PlayerConnection playerConnection2 = this.this$0.playerConnection;
                            String str = (playerConnection2 == null || (playerSafe = playerConnection2.getPlayerSafe()) == null || (currentMediaItem = playerSafe.getCurrentMediaItem()) == null) ? null : currentMediaItem.mediaId;
                            Timber.Forest.tag("ListenTogetherManager");
                            ConnectionPool.d(new Object[0]);
                            ListenTogetherClient.sendPlaybackAction$default(this.this$0.client, "seek", str, Long.valueOf(positionInfo2.positionMs), null, null, null, null, 248);
                        }
                    }
                } catch (Exception unused) {
                    Timber.Forest.tag("ListenTogetherManager");
                    ConnectionPool.e$1(new Object[0]);
                }
            }

            public final void sendPlayState(boolean z, ExoPlayerImpl exoPlayerImpl) {
                ListenTogetherManager listenTogetherManager = this.this$0;
                ListenTogetherClient listenTogetherClient2 = listenTogetherManager.client;
                try {
                    long currentPosition = exoPlayerImpl.getCurrentPosition();
                    MediaItem currentMediaItem = exoPlayerImpl.getCurrentMediaItem();
                    String str = currentMediaItem != null ? currentMediaItem.mediaId : null;
                    if (z) {
                        Timber.Forest.tag("ListenTogetherManager");
                        ConnectionPool.d(new Object[0]);
                        ListenTogetherClient.sendPlaybackAction$default(listenTogetherClient2, "play", str, Long.valueOf(currentPosition), null, null, null, null, 248);
                        listenTogetherManager.lastSyncedIsPlaying = Boolean.TRUE;
                        return;
                    }
                    String str2 = str;
                    if (z || !Intrinsics.areEqual(listenTogetherManager.lastSyncedIsPlaying, Boolean.TRUE)) {
                        return;
                    }
                    Timber.Forest.tag("ListenTogetherManager");
                    ConnectionPool.d(new Object[0]);
                    ListenTogetherClient.sendPlaybackAction$default(listenTogetherClient2, "pause", str2, Long.valueOf(currentPosition), null, null, null, null, 248);
                    listenTogetherManager.lastSyncedIsPlaying = Boolean.FALSE;
                } catch (Exception unused) {
                    Timber.Forest.tag("ListenTogetherManager");
                    ConnectionPool.e$1(new Object[0]);
                }
            }
        };
    }

    public static /* synthetic */ void applyPlaybackState$default(ListenTogetherManager listenTogetherManager, Listentogether.TrackInfo trackInfo, boolean z, long j, List list, String str, Long l, int i) {
        if ((i & 16) != 0) {
            str = null;
        }
        if ((i & 32) != 0) {
            l = null;
        }
        listenTogetherManager.applyPlaybackState(trackInfo, z, j, list, str, l, (i & 64) == 0);
    }

    public static boolean guestNeedsTrackReconcile(String str, String str2) {
        if (str == null) {
            return false;
        }
        if (str.length() <= 0) {
            str = null;
        }
        if (str == null) {
            return false;
        }
        return str2 == null || !str2.equals(str);
    }

    public static MediaMetadata toMediaMetadata(Listentogether.TrackInfo trackInfo) {
        String id = trackInfo.getId();
        id.getClass();
        String title = trackInfo.getTitle();
        title.getClass();
        String artist = trackInfo.getArtist();
        artist.getClass();
        List listListOf = CollectionsKt__IterablesKt.listOf(new MediaMetadata.Artist("", artist));
        String album = trackInfo.getAlbum();
        if (album.length() <= 0) {
            album = null;
        }
        MediaMetadata.Album album2 = album != null ? new MediaMetadata.Album("", album) : null;
        int duration = (int) (trackInfo.getDuration() / 1000);
        String thumbnail = trackInfo.getThumbnail();
        if (thumbnail.length() <= 0) {
            thumbnail = null;
        }
        String suggestedBy = trackInfo.getSuggestedBy();
        return new MediaMetadata(id, title, listListOf, duration, thumbnail, album2, null, null, false, null, null, suggestedBy.length() > 0 ? suggestedBy : null, false, null, 114624);
    }

    public final void applyCanonicalUpcomingQueue(PlayerConnection playerConnection, String str, List list) {
        invalidatePendingQueueMutations();
        if (this.playerConnection != playerConnection) {
            return;
        }
        ExoPlayerImpl playerSafe = playerConnection.getPlayerSafe();
        Listentogether.RoomState roomState = (Listentogether.RoomState) this.roomState.$$delegate_0.getValue();
        Listentogether.TrackInfo currentTrackOrNull = roomState != null ? ProtocolKt.getCurrentTrackOrNull(roomState) : null;
        if (currentTrackOrNull != null) {
            MediaItem currentMediaItem = playerSafe.getCurrentMediaItem();
            if (!Intrinsics.areEqual(currentMediaItem != null ? currentMediaItem.mediaId : null, currentTrackOrNull.getId())) {
                applyPlaybackState(currentTrackOrNull, roomState.getIsPlaying(), roomState.getPosition(), list, str, Long.valueOf(roomState.getLastUpdate()), true);
                return;
            }
        }
        int currentMediaItemIndex = playerSafe.getCurrentMediaItemIndex();
        if (currentMediaItemIndex < 0) {
            return;
        }
        List listDrop = currentTrackOrNull != null ? CollectionsKt.drop(ListenTogetherManagerKt.canonicalPlaybackQueue(currentTrackOrNull, list), 1) : null;
        if (listDrop == null) {
            listDrop = EmptyList.INSTANCE;
        }
        List list2 = SequencesKt.toList(new TransformingSequence(new LinesSequence((byte) 2, listDrop), new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 16, this)));
        playerConnection.allowInternalSync = true;
        try {
            playerSafe.setShuffleModeEnabled(false);
            int i = currentMediaItemIndex + 1;
            if (playerSafe.getMediaItemCount() > i) {
                playerSafe.removeMediaItems(i, playerSafe.getMediaItemCount());
            }
            if (!list2.isEmpty()) {
                playerSafe.addMediaItems(i, list2);
            }
            if (str != null) {
                playerConnection.service.queueTitle = str;
            }
        } finally {
            playerConnection.allowInternalSync = false;
        }
    }

    public final void applyHostVolumeIfNeeded(Float f) {
        PlayerConnection playerConnection;
        if (!((Boolean) this.syncHostVolumeEnabled.getValue()).booleanValue() || isHost() || !this.client.isInRoom() || (playerConnection = this.playerConnection) == null || f == null) {
            return;
        }
        ((StateFlowImpl) playerConnection.service.getPlayerVolume()).updateState(null, Float.valueOf(UuidKt.coerceIn(f.floatValue(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f)));
    }

    public final void applyPendingSyncIfReady() {
        String id;
        PlayerConnection playerConnection;
        Listentogether.SyncStatePayload syncStatePayload = this.pendingSyncState;
        if (syncStatePayload == null) {
            return;
        }
        Listentogether.TrackInfo currentTrackOrNull = ProtocolKt.getCurrentTrackOrNull(syncStatePayload);
        if (((currentTrackOrNull == null || (id = currentTrackOrNull.getId()) == null) && (id = this.bufferingTrackId) == null) || !Intrinsics.areEqual(this.bufferCompleteReceivedForTrack, id) || (playerConnection = this.playerConnection) == null) {
            return;
        }
        ExoPlayerImpl playerSafe = playerConnection.getPlayerSafe();
        ConnectionPool connectionPool = Timber.Forest;
        connectionPool.tag("ListenTogetherManager");
        syncStatePayload.getPosition();
        syncStatePayload.getIsPlaying();
        ConnectionPool.d(new Object[0]);
        byte b = 1;
        this.isSyncing = true;
        ListenTogetherClient listenTogetherClient = this.client;
        long position = syncStatePayload.getPosition();
        long lastUpdate = syncStatePayload.getLastUpdate();
        Long lValueOf = Long.valueOf(lastUpdate);
        Continuation continuation = null;
        if (lastUpdate <= 0) {
            lValueOf = null;
        }
        long jPositionAtServerTime$app = listenTogetherClient.positionAtServerTime$app(position, lValueOf, syncStatePayload.getIsPlaying());
        long jAbs = Math.abs(playerSafe.getCurrentPosition() - jPositionAtServerTime$app);
        boolean isPlaying = syncStatePayload.getIsPlaying();
        if (jAbs > 50) {
            connectionPool.tag("ListenTogetherManager");
            playerSafe.getCurrentPosition();
            ConnectionPool.d(new Object[0]);
            playerConnection.seekTo(jPositionAtServerTime$app);
        }
        if (isPlaying && !playerSafe.getPlayWhenReady()) {
            connectionPool.tag("ListenTogetherManager");
            ConnectionPool.d(new Object[0]);
            playerConnection.play();
        } else if (!isPlaying && playerSafe.getPlayWhenReady()) {
            connectionPool.tag("ListenTogetherManager");
            ConnectionPool.d(new Object[0]);
            playerConnection.pause();
        }
        if (isPlaying) {
            long position2 = syncStatePayload.getPosition();
            long lastUpdate2 = syncStatePayload.getLastUpdate();
            startDriftCorrection(playerConnection, id, position2, lastUpdate2 > 0 ? Long.valueOf(lastUpdate2) : null);
        } else {
            cancelDriftCorrection();
        }
        AwaitKt.launch$default(this.scope, null, null, new ListenTogetherManager$initialize$1(this, continuation, b), 3);
        this.bufferingTrackId = null;
        this.pendingSyncState = null;
        this.bufferCompleteReceivedForTrack = null;
    }

    public final void applyPlaybackState(Listentogether.TrackInfo trackInfo, boolean z, long j, List list, String str, Long l, boolean z2) {
        invalidatePendingQueueMutations();
        PlayerConnection playerConnection = this.playerConnection;
        if (playerConnection == null) {
            Timber.Forest.tag("ListenTogetherManager");
            ConnectionPool.w(new Object[0]);
            return;
        }
        ExoPlayerImpl playerSafe = playerConnection.getPlayerSafe();
        cancelDriftCorrection();
        long jPositionAtServerTime$app = this.client.positionAtServerTime$app(j, l, z);
        ConnectionPool connectionPool = Timber.Forest;
        connectionPool.tag("ListenTogetherManager");
        if (trackInfo != null) {
            trackInfo.getId();
        }
        if (list != null) {
            list.size();
        }
        ConnectionPool.d(new Object[0]);
        StandaloneCoroutine standaloneCoroutine = this.activeSyncJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        ContextScope contextScope = this.scope;
        if (trackInfo != null) {
            this.bufferingTrackId = trackInfo.getId();
            int i = this.currentTrackGeneration + 1;
            this.currentTrackGeneration = i;
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            AwaitKt.launch$default(contextScope, MainDispatcherLoader.dispatcher, null, new AnonymousClass2(i, trackInfo, playerConnection, playerSafe, list, jPositionAtServerTime$app, str, z2, z, j, l, null), 2);
            return;
        }
        connectionPool.tag("ListenTogetherManager");
        ConnectionPool.d(new Object[0]);
        int i2 = this.currentTrackGeneration + 1;
        this.currentTrackGeneration = i2;
        DefaultScheduler defaultScheduler2 = Dispatchers.Default;
        AwaitKt.launch$default(contextScope, MainDispatcherLoader.dispatcher, null, new AnonymousClass1(i2, playerConnection, playerSafe, list, str, null), 2);
    }

    public final void blockUser(String str) {
        ListenTogetherClient listenTogetherClient = this.client;
        StateFlowImpl stateFlowImpl = listenTogetherClient._blockedUsernames;
        Set mutableSet = CollectionsKt.toMutableSet((Iterable) stateFlowImpl.getValue());
        mutableSet.add(str);
        Continuation continuation = null;
        stateFlowImpl.updateState(null, mutableSet);
        StateFlowImpl stateFlowImpl2 = listenTogetherClient._pendingJoinRequests;
        Iterable iterable = (Iterable) stateFlowImpl2.getValue();
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (!((Set) stateFlowImpl.getValue()).contains(((Listentogether.JoinRequestPayload) obj).getUsername())) {
                arrayList.add(obj);
            }
        }
        stateFlowImpl2.updateState(null, arrayList);
        StateFlowImpl stateFlowImpl3 = listenTogetherClient._pendingSuggestions;
        Iterable iterable2 = (Iterable) stateFlowImpl3.getValue();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : iterable2) {
            if (!((Set) stateFlowImpl.getValue()).contains(((Listentogether.SuggestionReceivedPayload) obj2).getFromUsername())) {
                arrayList2.add(obj2);
            }
        }
        stateFlowImpl3.updateState(null, arrayList2);
        AwaitKt.launch$default(listenTogetherClient.scope, null, null, new ListenTogetherClient$blockUser$3(listenTogetherClient, continuation, (byte) 0), 3);
        listenTogetherClient.log(LogLevel.INFO, "User blocked", str);
    }

    public final void cancelDriftCorrection() {
        this.driftCorrectionGeneration++;
        StandaloneCoroutine standaloneCoroutine = this.driftCorrectionJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.driftCorrectionJob = null;
        restoreDriftCorrectionSpeed();
    }

    public final void cleanup() {
        ExoPlayerImpl playerSafe;
        if (this.lastRole == RoomRole.GUEST) {
            restoreGuestMuteState();
        }
        if (this.playerListenerRegistered) {
            PlayerConnection playerConnection = this.playerConnection;
            if (playerConnection != null && (playerSafe = playerConnection.getPlayerSafe()) != null) {
                playerSafe.removeListener(this.playerListener);
            }
            this.playerListenerRegistered = false;
        }
        StandaloneCoroutine standaloneCoroutine = this.queueObserverJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.queueObserverJob = null;
        stopHeartbeat();
        stopVolumeSyncObservation();
        cancelDriftCorrection();
        this.lastSyncedIsPlaying = null;
        this.lastSyncedTrackId = null;
        this.bufferingTrackId = null;
        this.isSyncing = false;
        this.bufferCompleteReceivedForTrack = null;
        this.lastRole = RoomRole.NONE;
        this.lastAppliedRevision = 0L;
        this.applyNextHostSnapshot = false;
        invalidatePendingQueueMutations();
        this.currentTrackGeneration++;
    }

    public final void connect() {
        Timber.Forest.tag("ListenTogetherManager");
        ConnectionPool.d(new Object[0]);
        this.client.connect();
    }

    public final void createRoom(String str) {
        str.getClass();
        Timber.Forest.tag("ListenTogetherManager");
        "Creating room with username: ".concat(str);
        ConnectionPool.d(new Object[0]);
        ListenTogetherClient listenTogetherClient = this.client;
        listenTogetherClient.sessionApplyGeneration.incrementAndGet();
        listenTogetherClient.lastPlaybackRevision.set(0L);
        listenTogetherClient.clearPersistedSession();
        listenTogetherClient.sessionToken = null;
        listenTogetherClient.storedRoomCode = null;
        listenTogetherClient.wasHost = false;
        listenTogetherClient.storedUsername = str;
        StateFlowImpl stateFlowImpl = listenTogetherClient._connectionState;
        if (stateFlowImpl.getValue() == ConnectionState.CONNECTED) {
            GeneratedMessageLite generatedMessageLiteM915build = Listentogether.CreateRoomPayload.newBuilder().setUsername(str).m915build();
            generatedMessageLiteM915build.getClass();
            listenTogetherClient.sendMessage("create_room", (Listentogether.CreateRoomPayload) generatedMessageLiteM915build);
            return;
        }
        listenTogetherClient.log(LogLevel.INFO, "Not connected, queueing create room action", null);
        listenTogetherClient.pendingAction = new PendingAction$CreateRoom(str);
        listenTogetherClient.evaluateBackgroundDisconnectPolicy("create_room_queued");
        if (stateFlowImpl.getValue() == ConnectionState.DISCONNECTED || stateFlowImpl.getValue() == ConnectionState.ERROR) {
            listenTogetherClient.connect();
        }
    }

    public final void disconnect() {
        Timber.Forest.tag("ListenTogetherManager");
        ConnectionPool.d(new Object[0]);
        cleanup();
        this.client.disconnect();
    }

    public final void enqueueQueueMutation(int i, Function1 function1) {
        this.queueMutationJob = AwaitKt.launch$default(this.scope, null, null, new C01511(this.queueMutationJob, i, this, function1, null), 3);
    }

    public final void forceReconnect() {
        Timber.Forest.tag("ListenTogetherManager");
        ConnectionPool.d(new Object[0]);
        String str = ListenTogetherClient.DEFAULT_SERVER_URL;
        ListenTogetherClient listenTogetherClient = this.client;
        Continuation continuation = null;
        listenTogetherClient.log(LogLevel.INFO, "Forcing reconnection to server", null);
        listenTogetherClient.reconnectAttempts = 0;
        RealWebSocket realWebSocket = listenTogetherClient.webSocket;
        if (realWebSocket != null) {
            try {
                realWebSocket.close(CIOKt.DEFAULT_HTTP_POOL_SIZE, "Forcing reconnection");
            } catch (Exception e) {
                listenTogetherClient.log(LogLevel.DEBUG, "Error closing WebSocket", e.getMessage());
            }
            listenTogetherClient.webSocket = null;
        }
        StateFlowImpl stateFlowImpl = listenTogetherClient._connectionState;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, ConnectionState.DISCONNECTED);
        listenTogetherClient.evaluateBackgroundDisconnectPolicy("force_reconnect");
        AwaitKt.launch$default(listenTogetherClient.scope, null, null, new ListenTogetherClient$blockUser$3(listenTogetherClient, continuation, (byte) 3), 3);
    }

    public final void handleEvent(ListenTogetherEvent listenTogetherEvent) throws Throwable {
        ExoPlayerImpl playerSafe;
        MediaItem currentMediaItem;
        ExoPlayerImpl playerSafe2;
        MediaItem currentMediaItem2;
        MediaMetadata currentMetadata;
        MediaItem currentMediaItem3;
        if (listenTogetherEvent == null) {
            return;
        }
        boolean z = listenTogetherEvent instanceof ListenTogetherEvent.RoomCreated;
        ListenTogetherClient listenTogetherClient = this.client;
        boolean z2 = true;
        ListenTogetherManager$playerListener$1 listenTogetherManager$playerListener$1 = this.playerListener;
        str = null;
        String str = null;
        str = null;
        str = null;
        String str2 = null;
        if (z) {
            ConnectionPool connectionPool = Timber.Forest;
            connectionPool.tag("ListenTogetherManager");
            ConnectionPool.d(new Object[0]);
            try {
                PlayerConnection playerConnection = this.playerConnection;
                ExoPlayerImpl playerSafe3 = playerConnection != null ? playerConnection.getPlayerSafe() : null;
                if (playerSafe3 != null && !this.playerListenerRegistered) {
                    try {
                        playerSafe3.addListener(listenTogetherManager$playerListener$1);
                        this.playerListenerRegistered = true;
                        connectionPool.tag("ListenTogetherManager");
                        ConnectionPool.d(new Object[0]);
                    } catch (Exception unused) {
                        connectionPool = Timber.Forest;
                        connectionPool.tag("ListenTogetherManager");
                        ConnectionPool.e$1(new Object[0]);
                    }
                }
                this.lastSyncedIsPlaying = playerSafe3 != null ? Boolean.valueOf(playerSafe3.getPlayWhenReady()) : null;
                if (playerSafe3 != null && (currentMediaItem3 = playerSafe3.getCurrentMediaItem()) != null) {
                    str = currentMediaItem3.mediaId;
                }
                this.lastSyncedTrackId = str;
                if (playerSafe3 != null && (currentMetadata = IntMath.getCurrentMetadata(playerSafe3)) != null) {
                    connectionPool.tag("ListenTogetherManager");
                    ConnectionPool.d(new Object[0]);
                    sendTrackChangeInternal(currentMetadata);
                    if (playerSafe3.getPlayWhenReady()) {
                        this.lastSyncedIsPlaying = Boolean.TRUE;
                        connectionPool.tag("ListenTogetherManager");
                        ConnectionPool.d(new Object[0]);
                        ListenTogetherClient.sendPlaybackAction$default(listenTogetherClient, "play", currentMetadata.id, Long.valueOf(playerSafe3.getCurrentPosition()), null, null, null, null, 248);
                    }
                }
                startQueueSyncObservation();
                startHeartbeat();
                startVolumeSyncObservation();
                return;
            } catch (Exception unused2) {
                Timber.Forest.tag("ListenTogetherManager");
                ConnectionPool.e$1(new Object[0]);
                return;
            }
        }
        if (listenTogetherEvent instanceof ListenTogetherEvent.JoinApproved) {
            ConnectionPool connectionPool2 = Timber.Forest;
            connectionPool2.tag("ListenTogetherManager");
            Listentogether.RoomState roomState = ((ListenTogetherEvent.JoinApproved) listenTogetherEvent).state;
            ConnectionPool.d(new Object[0]);
            PlayerConnection playerConnection2 = this.playerConnection;
            if (playerConnection2 != null && this.previousMuteState == null) {
                this.previousMuteState = (Boolean) playerConnection2.isMuted.getValue();
                connectionPool2.tag("ListenTogetherManager");
                ConnectionPool.d(new Object[0]);
            }
            this.lastAppliedRevision = roomState.getRevision();
            Listentogether.TrackInfo currentTrackOrNull = ProtocolKt.getCurrentTrackOrNull(roomState);
            boolean isPlaying = roomState.getIsPlaying();
            long position = roomState.getPosition();
            List<Listentogether.TrackInfo> queueList = roomState.getQueueList();
            queueList.getClass();
            applyPlaybackState$default(this, currentTrackOrNull, isPlaying, position, queueList, null, Long.valueOf(roomState.getLastUpdate()), 80);
            applyHostVolumeIfNeeded(Float.valueOf(roomState.getVolume()));
            if (this.playerConnection == null) {
                return;
            }
            restoreGuestMuteState();
            return;
        }
        if (listenTogetherEvent instanceof ListenTogetherEvent.PlaybackSync) {
            Timber.Forest.tag("ListenTogetherManager");
            Listentogether.PlaybackActionPayload playbackActionPayload = ((ListenTogetherEvent.PlaybackSync) listenTogetherEvent).action;
            playbackActionPayload.getAction();
            ConnectionPool.d(new Object[0]);
            String action = playbackActionPayload.getAction();
            if (!Intrinsics.areEqual(action, "queue_add") && !Intrinsics.areEqual(action, "queue_remove") && !Intrinsics.areEqual(action, "queue_clear")) {
                z2 = false;
            }
            if (!isHost() || z2) {
                handlePlaybackSync(playbackActionPayload);
                return;
            }
            return;
        }
        if (listenTogetherEvent instanceof ListenTogetherEvent.UserJoined) {
            Timber.Forest.tag("ListenTogetherManager");
            ConnectionPool.d(new Object[0]);
            return;
        }
        if (listenTogetherEvent instanceof ListenTogetherEvent.BufferWait) {
            Timber.Forest.tag("ListenTogetherManager");
            ((ListenTogetherEvent.BufferWait) listenTogetherEvent).waitingFor.size();
            ConnectionPool.d(new Object[0]);
            return;
        }
        if (listenTogetherEvent instanceof ListenTogetherEvent.BufferComplete) {
            Timber.Forest.tag("ListenTogetherManager");
            String str3 = ((ListenTogetherEvent.BufferComplete) listenTogetherEvent).trackId;
            ConnectionPool.d(new Object[0]);
            if (isHost() || !Intrinsics.areEqual(this.bufferingTrackId, str3)) {
                return;
            }
            this.bufferCompleteReceivedForTrack = str3;
            applyPendingSyncIfReady();
            return;
        }
        if (listenTogetherEvent instanceof ListenTogetherEvent.SyncStateReceived) {
            ConnectionPool connectionPool3 = Timber.Forest;
            connectionPool3.tag("ListenTogetherManager");
            Listentogether.SyncStatePayload syncStatePayload = ((ListenTogetherEvent.SyncStateReceived) listenTogetherEvent).state;
            syncStatePayload.getIsPlaying();
            syncStatePayload.getPosition();
            Listentogether.TrackInfo currentTrackOrNull2 = ProtocolKt.getCurrentTrackOrNull(syncStatePayload);
            if (currentTrackOrNull2 != null) {
                currentTrackOrNull2.getId();
            }
            ConnectionPool.d(new Object[0]);
            if (!isHost() || this.applyNextHostSnapshot) {
                boolean z3 = this.applyNextHostSnapshot;
                this.applyNextHostSnapshot = false;
                if (syncStatePayload.getRevision() > 0 && syncStatePayload.getRevision() < this.lastAppliedRevision) {
                    connectionPool3.tag("ListenTogetherManager");
                    syncStatePayload.getRevision();
                    ConnectionPool.d(new Object[0]);
                    return;
                }
                this.lastAppliedRevision = Math.max(this.lastAppliedRevision, syncStatePayload.getRevision());
                Listentogether.TrackInfo currentTrackOrNull3 = ProtocolKt.getCurrentTrackOrNull(syncStatePayload);
                connectionPool3.tag("ListenTogetherManager");
                syncStatePayload.getIsPlaying();
                syncStatePayload.getPosition();
                if (currentTrackOrNull3 != null) {
                    currentTrackOrNull3.getId();
                }
                ConnectionPool.d(new Object[0]);
                if (!z3 && currentTrackOrNull3 != null && Intrinsics.areEqual(this.bufferingTrackId, currentTrackOrNull3.getId())) {
                    this.pendingSyncState = syncStatePayload;
                    applyPendingSyncIfReady();
                    applyHostVolumeIfNeeded(Float.valueOf(syncStatePayload.getVolume()));
                    return;
                }
                PlayerConnection playerConnection3 = this.playerConnection;
                if (playerConnection3 != null && (playerSafe2 = playerConnection3.getPlayerSafe()) != null && (currentMediaItem2 = playerSafe2.getCurrentMediaItem()) != null) {
                    str2 = currentMediaItem2.mediaId;
                }
                if (z3 || currentTrackOrNull3 == null || !Intrinsics.areEqual(str2, currentTrackOrNull3.getId()) || this.bufferingTrackId != null) {
                    applyPlaybackState$default(this, currentTrackOrNull3, syncStatePayload.getIsPlaying(), syncStatePayload.getPosition(), syncStatePayload.getQueueList(), null, Long.valueOf(syncStatePayload.getLastUpdate()), 16);
                    applyHostVolumeIfNeeded(Float.valueOf(syncStatePayload.getVolume()));
                    return;
                } else {
                    handlePlaybackSync(ProtocolKt.PlaybackActionPayload$default(syncStatePayload.getIsPlaying() ? "play" : "pause", currentTrackOrNull3.getId(), Long.valueOf(syncStatePayload.getPosition()), null, null, null, null, Long.valueOf(syncStatePayload.getLastUpdate()), syncStatePayload.getRevision(), null, 1272));
                    applyHostVolumeIfNeeded(Float.valueOf(syncStatePayload.getVolume()));
                    return;
                }
            }
            return;
        }
        if (listenTogetherEvent instanceof ListenTogetherEvent.Kicked) {
            Timber.Forest.tag("ListenTogetherManager");
            ConnectionPool.d(new Object[0]);
            cleanup();
            return;
        }
        if (listenTogetherEvent instanceof ListenTogetherEvent.Disconnected) {
            Timber.Forest.tag("ListenTogetherManager");
            ConnectionPool.d(new Object[0]);
            return;
        }
        if (listenTogetherEvent instanceof ListenTogetherEvent.Reconnecting) {
            Timber.Forest.tag("ListenTogetherManager");
            ConnectionPool.d(new Object[0]);
            return;
        }
        if (listenTogetherEvent instanceof ListenTogetherEvent.Reconnected) {
            ConnectionPool connectionPool4 = Timber.Forest;
            connectionPool4.tag("ListenTogetherManager");
            ConnectionPool.d(new Object[0]);
            try {
                PlayerConnection playerConnection4 = this.playerConnection;
                ExoPlayerImpl playerSafe4 = playerConnection4 != null ? playerConnection4.getPlayerSafe() : null;
                if (playerSafe4 != null && !this.playerListenerRegistered) {
                    try {
                        playerSafe4.addListener(listenTogetherManager$playerListener$1);
                        this.playerListenerRegistered = true;
                        connectionPool4.tag("ListenTogetherManager");
                        ConnectionPool.d(new Object[0]);
                    } catch (Exception unused3) {
                        connectionPool4 = Timber.Forest;
                        connectionPool4.tag("ListenTogetherManager");
                        ConnectionPool.e$1(new Object[0]);
                    }
                }
                if (!((ListenTogetherEvent.Reconnected) listenTogetherEvent).isHost) {
                    connectionPool4.tag("ListenTogetherManager");
                    ConnectionPool.d(new Object[0]);
                    this.lastAppliedRevision = ((ListenTogetherEvent.Reconnected) listenTogetherEvent).state.getRevision();
                    Listentogether.TrackInfo currentTrackOrNull4 = ProtocolKt.getCurrentTrackOrNull(((ListenTogetherEvent.Reconnected) listenTogetherEvent).state);
                    boolean isPlaying2 = ((ListenTogetherEvent.Reconnected) listenTogetherEvent).state.getIsPlaying();
                    long position2 = ((ListenTogetherEvent.Reconnected) listenTogetherEvent).state.getPosition();
                    List<Listentogether.TrackInfo> queueList2 = ((ListenTogetherEvent.Reconnected) listenTogetherEvent).state.getQueueList();
                    queueList2.getClass();
                    applyPlaybackState$default(this, currentTrackOrNull4, isPlaying2, position2, queueList2, null, Long.valueOf(((ListenTogetherEvent.Reconnected) listenTogetherEvent).state.getLastUpdate()), 16);
                    applyHostVolumeIfNeeded(Float.valueOf(((ListenTogetherEvent.Reconnected) listenTogetherEvent).state.getVolume()));
                    return;
                }
                this.lastSyncedIsPlaying = playerSafe4 != null ? Boolean.valueOf(playerSafe4.getPlayWhenReady()) : null;
                this.lastSyncedTrackId = (playerSafe4 == null || (currentMediaItem = playerSafe4.getCurrentMediaItem()) == null) ? null : currentMediaItem.mediaId;
                MediaMetadata currentMetadata2 = playerSafe4 != null ? IntMath.getCurrentMetadata(playerSafe4) : null;
                if (currentMetadata2 != null) {
                    Listentogether.TrackInfo currentTrackOrNull5 = ProtocolKt.getCurrentTrackOrNull(((ListenTogetherEvent.Reconnected) listenTogetherEvent).state);
                    if (Intrinsics.areEqual(currentTrackOrNull5 != null ? currentTrackOrNull5.getId() : null, currentMetadata2.id)) {
                        connectionPool4.tag("ListenTogetherManager");
                        ConnectionPool.d(new Object[0]);
                    } else {
                        connectionPool4.tag("ListenTogetherManager");
                        ConnectionPool.d(new Object[0]);
                        sendTrackChangeInternal(currentMetadata2);
                    }
                    if (playerSafe4.getPlayWhenReady()) {
                        long currentPosition = playerSafe4.getCurrentPosition();
                        MediaItem currentMediaItem4 = playerSafe4.getCurrentMediaItem();
                        String str4 = currentMediaItem4 != null ? currentMediaItem4.mediaId : null;
                        connectionPool4.tag("ListenTogetherManager");
                        ConnectionPool.d(new Object[0]);
                        ListenTogetherClient.sendPlaybackAction$default(listenTogetherClient, "play", str4, Long.valueOf(currentPosition), null, null, null, null, 248);
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception unused4) {
                Timber.Forest.tag("ListenTogetherManager");
                ConnectionPool.e$1(new Object[0]);
                return;
            }
        }
        if (listenTogetherEvent instanceof ListenTogetherEvent.UserReconnected) {
            Timber.Forest.tag("ListenTogetherManager");
            ConnectionPool.d(new Object[0]);
            return;
        }
        if (listenTogetherEvent instanceof ListenTogetherEvent.UserDisconnected) {
            Timber.Forest.tag("ListenTogetherManager");
            ConnectionPool.d(new Object[0]);
            return;
        }
        if (!(listenTogetherEvent instanceof ListenTogetherEvent.HostChanged)) {
            if (listenTogetherEvent instanceof ListenTogetherEvent.ConnectionError) {
                Timber.Forest.tag("ListenTogetherManager");
                ConnectionPool.e(new Object[0]);
                cleanup();
                return;
            }
            return;
        }
        ConnectionPool connectionPool5 = Timber.Forest;
        connectionPool5.tag("ListenTogetherManager");
        ConnectionPool.d(new Object[0]);
        boolean zIsHost = isHost();
        boolean zEquals = ((ListenTogetherEvent.HostChanged) listenTogetherEvent).newHostId.equals(this.userId.$$delegate_0.getValue());
        if (zIsHost && !zEquals) {
            connectionPool5.tag("ListenTogetherManager");
            ConnectionPool.d(new Object[0]);
            StandaloneCoroutine standaloneCoroutine = this.queueObserverJob;
            if (standaloneCoroutine != null) {
                standaloneCoroutine.cancel(null);
            }
            this.queueObserverJob = null;
            stopVolumeSyncObservation();
            if (this.playerListenerRegistered) {
                PlayerConnection playerConnection5 = this.playerConnection;
                if (playerConnection5 != null && (playerSafe = playerConnection5.getPlayerSafe()) != null) {
                    playerSafe.removeListener(listenTogetherManager$playerListener$1);
                }
                this.playerListenerRegistered = false;
            }
            if (this.playerConnection == null) {
                return;
            }
            restoreGuestMuteState();
            return;
        }
        if (zIsHost || !zEquals) {
            return;
        }
        connectionPool5.tag("ListenTogetherManager");
        ConnectionPool.d(new Object[0]);
        if (this.playerConnection != null) {
            restoreGuestMuteState();
        }
        PlayerConnection playerConnection6 = this.playerConnection;
        ExoPlayerImpl playerSafe5 = playerConnection6 != null ? playerConnection6.getPlayerSafe() : null;
        if (playerSafe5 != null && !this.playerListenerRegistered) {
            try {
                playerSafe5.addListener(listenTogetherManager$playerListener$1);
                this.playerListenerRegistered = true;
                connectionPool5.tag("ListenTogetherManager");
                ConnectionPool.d(new Object[0]);
            } catch (Exception unused5) {
                connectionPool5 = Timber.Forest;
                connectionPool5.tag("ListenTogetherManager");
                ConnectionPool.e$1(new Object[0]);
            }
        }
        startQueueSyncObservation();
        startVolumeSyncObservation();
        MediaMetadata currentMetadata3 = playerSafe5 != null ? IntMath.getCurrentMetadata(playerSafe5) : null;
        if (currentMetadata3 != null) {
            connectionPool5.tag("ListenTogetherManager");
            ConnectionPool.d(new Object[0]);
            sendTrackChangeInternal(currentMetadata3);
            if (playerSafe5.getPlayWhenReady()) {
                connectionPool5.tag("ListenTogetherManager");
                ConnectionPool.d(new Object[0]);
                ListenTogetherClient.sendPlaybackAction$default(listenTogetherClient, "play", currentMetadata3.id, Long.valueOf(playerSafe5.getCurrentPosition()), null, null, null, null, 248);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:324:0x05f6  */
    public final void handlePlaybackSync(Listentogether.PlaybackActionPayload playbackActionPayload) throws Throwable {
        int i;
        int i2;
        long position;
        Listentogether.TrackInfo currentTrackOrNull;
        long j;
        long j2;
        List queue;
        EmptyList emptyList = EmptyList.INSTANCE;
        boolean z = false;
        if (playbackActionPayload.getRevision() > 0 && playbackActionPayload.getRevision() < this.lastAppliedRevision) {
            Timber.Forest.tag("ListenTogetherManager");
            playbackActionPayload.getRevision();
            ConnectionPool.d(new Object[0]);
            return;
        }
        this.lastAppliedRevision = Math.max(this.lastAppliedRevision, playbackActionPayload.getRevision());
        PlayerConnection playerConnection = this.playerConnection;
        if (playerConnection == null) {
            Timber.Forest.tag("ListenTogetherManager");
            ConnectionPool.w(new Object[0]);
            return;
        }
        ExoPlayerImpl playerSafe = playerConnection.getPlayerSafe();
        Long positionOrNull = ProtocolKt.getPositionOrNull(playbackActionPayload);
        String trackId = playbackActionPayload.getTrackId();
        if (trackId.length() <= 0) {
            trackId = null;
        }
        Listentogether.TrackInfo trackInfoOrNull = ProtocolKt.getTrackInfoOrNull(playbackActionPayload);
        Long serverTimeOrNull = ProtocolKt.getServerTimeOrNull(playbackActionPayload);
        String queueTitle = playbackActionPayload.getQueueTitle();
        if (queueTitle.length() <= 0) {
            queueTitle = null;
        }
        ConnectionPool connectionPool = Timber.Forest;
        connectionPool.tag("ListenTogetherManager");
        playbackActionPayload.getAction();
        ConnectionPool.d(new Object[0]);
        this.isSyncing = true;
        try {
            String action = playbackActionPayload.getAction();
            if (action != null) {
                try {
                    switch (action.hashCode()) {
                        case -1851001235:
                            if (action.equals("sync_queue")) {
                                invalidatePendingQueueMutations();
                                List queue2 = ProtocolKt.getQueue(playbackActionPayload);
                                if (queue2 != null) {
                                    connectionPool.tag("ListenTogetherManager");
                                    queue2.size();
                                    ConnectionPool.d(new Object[0]);
                                    if (playbackActionPayload.getRevision() > 0) {
                                        applyCanonicalUpcomingQueue(playerConnection, queueTitle, queue2);
                                        AwaitKt.launch$default(this.scope, null, null, new AnonymousClass6(null), 3);
                                        return;
                                    }
                                    StandaloneCoroutine standaloneCoroutine = this.activeSyncJob;
                                    if (standaloneCoroutine != null) {
                                        standaloneCoroutine.cancel(null);
                                    }
                                    if (this.playerConnection != playerConnection) {
                                        AwaitKt.launch$default(this.scope, null, null, new AnonymousClass6(null), 3);
                                        return;
                                    }
                                    ExoPlayerImpl playerSafe2 = playerConnection.getPlayerSafe();
                                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(queue2, 10));
                                    Iterator it = queue2.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(UuidKt.toMediaItem(toMediaMetadata((Listentogether.TrackInfo) it.next())));
                                    }
                                    MediaItem currentMediaItem = playerSafe2.getCurrentMediaItem();
                                    String str = currentMediaItem != null ? currentMediaItem.mediaId : null;
                                    int i3 = -1;
                                    if (str != null) {
                                        int size = arrayList.size();
                                        i2 = 0;
                                        int i4 = 0;
                                        while (true) {
                                            if (i4 < size) {
                                                Object obj = arrayList.get(i4);
                                                i4++;
                                                if (!Intrinsics.areEqual(((MediaItem) obj).mediaId, str)) {
                                                    i2++;
                                                }
                                            } else {
                                                i2 = -1;
                                            }
                                        }
                                    } else {
                                        i2 = -1;
                                    }
                                    long currentPosition = playerSafe2.getCurrentPosition();
                                    boolean zIsPlaying = playerSafe2.isPlaying();
                                    playerConnection.allowInternalSync = true;
                                    try {
                                        if (i2 != -1) {
                                            playerSafe2.setMediaItems(arrayList, i2, currentPosition);
                                        } else {
                                            Listentogether.RoomState roomState = (Listentogether.RoomState) this.roomState.getValue();
                                            String id = (roomState == null || (currentTrackOrNull = ProtocolKt.getCurrentTrackOrNull(roomState)) == null) ? null : currentTrackOrNull.getId();
                                            if (id != null) {
                                                int size2 = arrayList.size();
                                                int i5 = 0;
                                                int i6 = 0;
                                                while (i6 < size2) {
                                                    Object obj2 = arrayList.get(i6);
                                                    i6++;
                                                    if (Intrinsics.areEqual(((MediaItem) obj2).mediaId, id)) {
                                                        i3 = i5;
                                                    } else {
                                                        i5++;
                                                    }
                                                }
                                            }
                                            Listentogether.RoomState roomState2 = (Listentogether.RoomState) this.roomState.getValue();
                                            if (roomState2 != null) {
                                                position = roomState2.getPosition();
                                                if (position < 0) {
                                                    position = 0;
                                                }
                                            } else {
                                                position = 0;
                                            }
                                            if (i3 >= 0) {
                                                Timber.Forest.tag("ListenTogetherManager");
                                                ConnectionPool.d(new Object[0]);
                                                playerSafe2.setMediaItems(arrayList, i3, position);
                                            } else {
                                                Timber.Forest.tag("ListenTogetherManager");
                                                ConnectionPool.w(new Object[0]);
                                                playerSafe2.setMediaItems(arrayList, 0, 0L);
                                            }
                                        }
                                        playerConnection.allowInternalSync = false;
                                        if (zIsPlaying && !playerSafe2.isPlaying()) {
                                            playerConnection.play();
                                        }
                                        try {
                                            playerConnection.service.queueTitle = queueTitle;
                                        } catch (Exception unused) {
                                            Timber.Forest.tag("ListenTogetherManager");
                                            ConnectionPool.e$1(new Object[0]);
                                        }
                                    } catch (Throwable th) {
                                        playerConnection.allowInternalSync = false;
                                        throw th;
                                    }
                                }
                            }
                            break;
                        case -1739141005:
                            if (action.equals("queue_add")) {
                                if (playbackActionPayload.getRevision() > 0) {
                                    List queue3 = ProtocolKt.getQueue(playbackActionPayload);
                                    if (queue3 == null) {
                                        queue3 = emptyList;
                                    }
                                    applyCanonicalUpcomingQueue(playerConnection, queueTitle, queue3);
                                } else if (trackInfoOrNull != null) {
                                    connectionPool.tag("ListenTogetherManager");
                                    trackInfoOrNull.getTitle();
                                    playbackActionPayload.getInsertNext();
                                    ConnectionPool.d(new Object[0]);
                                    int i7 = this.queueSyncGeneration;
                                    enqueueQueueMutation(i7, new C01522(i7, playerConnection, trackInfoOrNull, playbackActionPayload, null));
                                } else {
                                    connectionPool.tag("ListenTogetherManager");
                                    ConnectionPool.w(new Object[0]);
                                }
                            }
                            break;
                        case -1088367209:
                            if (action.equals("set_volume")) {
                                Float fValueOf = Float.valueOf(playbackActionPayload.getVolume());
                                if (!Intrinsics.areEqual(playbackActionPayload.getAction(), "set_volume")) {
                                    fValueOf = null;
                                }
                                applyHostVolumeIfNeeded(fValueOf);
                            }
                            break;
                        case -570138209:
                            if (action.equals("queue_clear")) {
                                if (playbackActionPayload.getRevision() <= 0) {
                                    enqueueQueueMutation(this.queueSyncGeneration, new AnonymousClass4(playerConnection, playerSafe, null));
                                } else {
                                    List queue4 = ProtocolKt.getQueue(playbackActionPayload);
                                    if (queue4 == null) {
                                        queue4 = emptyList;
                                    }
                                    applyCanonicalUpcomingQueue(playerConnection, queueTitle, queue4);
                                }
                            }
                            break;
                        case -71190670:
                            String str2 = trackId;
                            if (action.equals("queue_remove")) {
                                if (playbackActionPayload.getRevision() > 0) {
                                    List queue5 = ProtocolKt.getQueue(playbackActionPayload);
                                    if (queue5 == null) {
                                        queue5 = emptyList;
                                    }
                                    applyCanonicalUpcomingQueue(playerConnection, queueTitle, queue5);
                                } else if (str2 == null || str2.length() == 0) {
                                    connectionPool.tag("ListenTogetherManager");
                                    ConnectionPool.w(new Object[0]);
                                } else {
                                    enqueueQueueMutation(this.queueSyncGeneration, new AnonymousClass3(playerConnection, playerSafe, str2, null));
                                }
                            }
                            break;
                        case 3443508:
                            String str3 = trackId;
                            if (action.equals("play")) {
                                long jLongValue = positionOrNull != null ? positionOrNull.longValue() : 0L;
                                SystemClock.elapsedRealtime();
                                long jPositionAtServerTime$app = this.client.positionAtServerTime$app(jLongValue, serverTimeOrNull, true);
                                connectionPool.tag("ListenTogetherManager");
                                playerSafe.getPlayWhenReady();
                                ConnectionPool.d(new Object[0]);
                                String str4 = this.bufferingTrackId;
                                if (str4 != null && str3 != null && !Intrinsics.areEqual(str3, str4)) {
                                    connectionPool.tag("ListenTogetherManager");
                                    ConnectionPool.w(new Object[0]);
                                    this.pendingSyncState = null;
                                    this.bufferCompleteReceivedForTrack = null;
                                    this.bufferingTrackId = null;
                                    reconcileGuestToHostTrack(jPositionAtServerTime$app, str3, true);
                                    AwaitKt.launch$default(this.scope, null, null, new AnonymousClass6(null), 3);
                                    return;
                                }
                                if (this.bufferingTrackId != null) {
                                    Listentogether.SyncStatePayload SyncStatePayload = this.pendingSyncState;
                                    if (SyncStatePayload == null) {
                                        Listentogether.RoomState roomState3 = (Listentogether.RoomState) this.roomState.getValue();
                                        j = jLongValue;
                                        SyncStatePayload = ProtocolKt.SyncStatePayload(roomState3 != null ? ProtocolKt.getCurrentTrackOrNull(roomState3) : null, true, j, serverTimeOrNull != null ? serverTimeOrNull.longValue() : 0L, null, null, (112 & 64) != 0 ? 0L : playbackActionPayload.getRevision());
                                    } else {
                                        j = jLongValue;
                                    }
                                    this.pendingSyncState = ProtocolKt.copy$default(SyncStatePayload, true, j, serverTimeOrNull != null ? serverTimeOrNull.longValue() : 0L, playbackActionPayload.getRevision(), 49);
                                    applyPendingSyncIfReady();
                                    AwaitKt.launch$default(this.scope, null, null, new AnonymousClass6(null), 3);
                                    return;
                                }
                                MediaItem currentMediaItem2 = playerSafe.getCurrentMediaItem();
                                if (guestNeedsTrackReconcile(str3, currentMediaItem2 != null ? currentMediaItem2.mediaId : null)) {
                                    str3.getClass();
                                    reconcileGuestToHostTrack(jPositionAtServerTime$app, str3, true);
                                    AwaitKt.launch$default(this.scope, null, null, new AnonymousClass6(null), 3);
                                    return;
                                }
                                long jAbs = Math.abs(playerSafe.getCurrentPosition() - jPositionAtServerTime$app);
                                if (!playerSafe.getPlayWhenReady()) {
                                    cancelDriftCorrection();
                                    if (jAbs > 50) {
                                        playerConnection.seekTo(jPositionAtServerTime$app);
                                    }
                                    playerConnection.play();
                                } else if ((playerSafe.getPlaybackState() == 3) && jAbs > 2000) {
                                    cancelDriftCorrection();
                                    connectionPool.tag("ListenTogetherManager");
                                    playerSafe.getCurrentPosition();
                                    ConnectionPool.d(new Object[0]);
                                    playerConnection.seekTo(jPositionAtServerTime$app);
                                }
                            }
                            break;
                        case 3526264:
                            if (action.equals("seek")) {
                                long jLongValue2 = positionOrNull != null ? positionOrNull.longValue() : 0L;
                                SystemClock.elapsedRealtime();
                                Listentogether.RoomState roomState4 = (Listentogether.RoomState) this.roomState.getValue();
                                if (roomState4 != null && roomState4.getIsPlaying()) {
                                    z = true;
                                }
                                long jPositionAtServerTime$app2 = this.client.positionAtServerTime$app(jLongValue2, serverTimeOrNull, z);
                                String str5 = this.bufferingTrackId;
                                if (str5 == null || (trackId != null && !Intrinsics.areEqual(trackId, str5))) {
                                    boolean z2 = z;
                                    MediaItem currentMediaItem3 = playerSafe.getCurrentMediaItem();
                                    if (guestNeedsTrackReconcile(trackId, currentMediaItem3 != null ? currentMediaItem3.mediaId : null)) {
                                        if (trackId != null) {
                                            reconcileGuestToHostTrack(jPositionAtServerTime$app2, trackId, playerSafe.getPlayWhenReady());
                                        } else {
                                            this.client.requestSync();
                                        }
                                        AwaitKt.launch$default(this.scope, null, null, new AnonymousClass6(null), 3);
                                        return;
                                    }
                                    cancelDriftCorrection();
                                    if (Math.abs(playerSafe.getCurrentPosition() - jPositionAtServerTime$app2) > 50) {
                                        playerConnection.seekTo(jPositionAtServerTime$app2);
                                    }
                                    if (z2) {
                                        startDriftCorrection(playerConnection, trackId, jLongValue2, serverTimeOrNull);
                                    }
                                    break;
                                }
                                Listentogether.SyncStatePayload SyncStatePayload2 = this.pendingSyncState;
                                if (SyncStatePayload2 == null) {
                                    Listentogether.RoomState roomState5 = (Listentogether.RoomState) this.roomState.getValue();
                                    SyncStatePayload2 = ProtocolKt.SyncStatePayload(roomState5 != null ? ProtocolKt.getCurrentTrackOrNull(roomState5) : null, z, jLongValue2, serverTimeOrNull != null ? serverTimeOrNull.longValue() : 0L, null, null, (112 & 64) != 0 ? 0L : playbackActionPayload.getRevision());
                                }
                                this.pendingSyncState = ProtocolKt.copy$default(SyncStatePayload2, false, jLongValue2, serverTimeOrNull != null ? serverTimeOrNull.longValue() : 0L, playbackActionPayload.getRevision(), 51);
                                AwaitKt.launch$default(this.scope, null, null, new AnonymousClass6(null), 3);
                                return;
                            }
                            break;
                        case 106440182:
                            if (action.equals("pause")) {
                                long jLongValue3 = positionOrNull != null ? positionOrNull.longValue() : 0L;
                                SystemClock.elapsedRealtime();
                                cancelDriftCorrection();
                                connectionPool.tag("ListenTogetherManager");
                                playerSafe.getPlayWhenReady();
                                ConnectionPool.d(new Object[0]);
                                String str6 = this.bufferingTrackId;
                                if (str6 != null && trackId != null && !Intrinsics.areEqual(trackId, str6)) {
                                    this.pendingSyncState = null;
                                    this.bufferCompleteReceivedForTrack = null;
                                    this.bufferingTrackId = null;
                                    reconcileGuestToHostTrack(jLongValue3, trackId, false);
                                    AwaitKt.launch$default(this.scope, null, null, new AnonymousClass6(null), 3);
                                    return;
                                }
                                long j3 = jLongValue3;
                                if (this.bufferingTrackId != null) {
                                    Listentogether.SyncStatePayload SyncStatePayload3 = this.pendingSyncState;
                                    if (SyncStatePayload3 == null) {
                                        Listentogether.RoomState roomState6 = (Listentogether.RoomState) this.roomState.getValue();
                                        j2 = j3;
                                        SyncStatePayload3 = ProtocolKt.SyncStatePayload(roomState6 != null ? ProtocolKt.getCurrentTrackOrNull(roomState6) : null, false, j2, serverTimeOrNull != null ? serverTimeOrNull.longValue() : 0L, null, null, (112 & 64) != 0 ? 0L : playbackActionPayload.getRevision());
                                    } else {
                                        j2 = j3;
                                    }
                                    this.pendingSyncState = ProtocolKt.copy$default(SyncStatePayload3, false, j2, serverTimeOrNull != null ? serverTimeOrNull.longValue() : 0L, playbackActionPayload.getRevision(), 49);
                                    applyPendingSyncIfReady();
                                    AwaitKt.launch$default(this.scope, null, null, new AnonymousClass6(null), 3);
                                    return;
                                }
                                MediaItem currentMediaItem4 = playerSafe.getCurrentMediaItem();
                                if (guestNeedsTrackReconcile(trackId, currentMediaItem4 != null ? currentMediaItem4.mediaId : null)) {
                                    trackId.getClass();
                                    reconcileGuestToHostTrack(j3, trackId, false);
                                    AwaitKt.launch$default(this.scope, null, null, new AnonymousClass6(null), 3);
                                    return;
                                }
                                long jAbs2 = Math.abs(playerSafe.getCurrentPosition() - j3);
                                if (playerSafe.getPlayWhenReady()) {
                                    connectionPool.tag("ListenTogetherManager");
                                    ConnectionPool.d(new Object[0]);
                                    playerConnection.pause();
                                }
                                if (jAbs2 > 50) {
                                    connectionPool.tag("ListenTogetherManager");
                                    playerSafe.getCurrentPosition();
                                    ConnectionPool.d(new Object[0]);
                                    playerConnection.seekTo(j3);
                                }
                            }
                            break;
                        case 251257852:
                            if (action.equals("change_track")) {
                                cancelDriftCorrection();
                                if (trackInfoOrNull != null) {
                                    connectionPool.tag("ListenTogetherManager");
                                    trackInfoOrNull.getTitle();
                                    List queue6 = ProtocolKt.getQueue(playbackActionPayload);
                                    if (queue6 != null) {
                                        queue6.size();
                                    }
                                    ConnectionPool.d(new Object[0]);
                                    if (playbackActionPayload.getRevision() <= 0 && ((queue = ProtocolKt.getQueue(playbackActionPayload)) == null || queue.isEmpty())) {
                                        this.bufferingTrackId = trackInfoOrNull.getId();
                                        syncToTrack(trackInfoOrNull);
                                    } else {
                                        List queue7 = ProtocolKt.getQueue(playbackActionPayload);
                                        applyPlaybackState$default(this, trackInfoOrNull, false, 0L, queue7 == null ? emptyList : queue7, queueTitle, null, 96);
                                    }
                                }
                            }
                            break;
                        case 2094462387:
                            if (action.equals("skip_next")) {
                                connectionPool.tag("ListenTogetherManager");
                                ConnectionPool.d(new Object[0]);
                                playerConnection.seekToNext();
                            }
                            break;
                        case 2094533875:
                            if (action.equals("skip_prev")) {
                                connectionPool.tag("ListenTogetherManager");
                                ConnectionPool.d(new Object[0]);
                                playerConnection.seekToPrevious();
                            }
                            break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i = 3;
                    AwaitKt.launch$default(this.scope, null, null, new AnonymousClass6(null), i);
                    throw th;
                }
            }
            AwaitKt.launch$default(this.scope, null, null, new AnonymousClass6(null), 3);
        } catch (Throwable th3) {
            th = th3;
            i = 3;
        }
    }

    public final void invalidatePendingQueueMutations() {
        this.queueSyncGeneration++;
        StandaloneCoroutine standaloneCoroutine = this.queueMutationJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.queueMutationJob = null;
    }

    public final boolean isHost() {
        return this.client._role.getValue() == RoomRole.HOST;
    }

    public final void joinRoom(String str, String str2) {
        str.getClass();
        str2.getClass();
        Timber.Forest.tag("ListenTogetherManager");
        ConnectionPool.d(new Object[0]);
        this.client.joinRoom(str, str2);
    }

    public final void kickUser(String str, String str2) {
        ListenTogetherClient listenTogetherClient = this.client;
        if (listenTogetherClient._role.getValue() != RoomRole.HOST) {
            listenTogetherClient.log(LogLevel.ERROR, "Cannot kick user", "Not host");
            return;
        }
        Listentogether.KickUserPayload.Builder userId = Listentogether.KickUserPayload.newBuilder().setUserId(str);
        if (str2 == null) {
            str2 = "";
        }
        GeneratedMessageLite generatedMessageLiteM915build = userId.setReason(str2).m915build();
        generatedMessageLiteM915build.getClass();
        listenTogetherClient.sendMessage("kick_user", (Listentogether.KickUserPayload) generatedMessageLiteM915build);
    }

    public final void leaveRoom() {
        Timber.Forest.tag("ListenTogetherManager");
        ConnectionPool.d(new Object[0]);
        cleanup();
        ListenTogetherClient listenTogetherClient = this.client;
        listenTogetherClient.sendMessage("leave_room", null);
        listenTogetherClient.sessionToken = null;
        listenTogetherClient.storedRoomCode = null;
        listenTogetherClient.storedUsername = null;
        listenTogetherClient.pendingAction = null;
        listenTogetherClient._roomState.setValue(null);
        StateFlowImpl stateFlowImpl = listenTogetherClient._role;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, RoomRole.NONE);
        listenTogetherClient._userId.setValue(null);
        StateFlowImpl stateFlowImpl2 = listenTogetherClient._pendingJoinRequests;
        stateFlowImpl2.getClass();
        EmptyList emptyList = EmptyList.INSTANCE;
        stateFlowImpl2.updateState(null, emptyList);
        StateFlowImpl stateFlowImpl3 = listenTogetherClient._bufferingUsers;
        stateFlowImpl3.getClass();
        stateFlowImpl3.updateState(null, emptyList);
        listenTogetherClient.lastPlaybackRevision.set(0L);
        listenTogetherClient.clearPersistedSession();
        listenTogetherClient.releaseWakeLock();
        listenTogetherClient.evaluateBackgroundDisconnectPolicy("leave_room");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    public final void reconcileGuestToHostTrack(long j, String str, boolean z) {
        List<Listentogether.TrackInfo> list;
        Listentogether.RoomState roomState = (Listentogether.RoomState) this.roomState.$$delegate_0.getValue();
        Listentogether.TrackInfo currentTrackOrNull = roomState != null ? ProtocolKt.getCurrentTrackOrNull(roomState) : null;
        if (roomState != null) {
            List<Listentogether.TrackInfo> queueList = roomState.getQueueList();
            queueList.getClass();
            if (queueList.isEmpty()) {
                list = null;
            } else {
                list = queueList;
            }
        } else {
            list = null;
        }
        if (Intrinsics.areEqual(currentTrackOrNull != null ? currentTrackOrNull.getId() : null, str)) {
            Timber.Forest.tag("ListenTogetherManager");
            currentTrackOrNull.getTitle();
            ConnectionPool.w(new Object[0]);
            applyPlaybackState$default(this, currentTrackOrNull, z, j, list, null, null, 48);
            return;
        }
        Listentogether.TrackInfo trackInfo = currentTrackOrNull;
        Timber.Forest.tag("ListenTogetherManager");
        if (trackInfo != null) {
            trackInfo.getId();
        }
        ConnectionPool.w(new Object[0]);
        this.client.requestSync();
    }

    public final void restoreDriftCorrectionSpeed() {
        ExoPlayerImpl exoPlayerImpl = this.driftCorrectedPlayer;
        PlaybackParameters playbackParameters = this.driftBasePlaybackParameters;
        PlaybackParameters playbackParameters2 = this.driftAppliedPlaybackParameters;
        if (exoPlayerImpl != null && playbackParameters != null && playbackParameters2 != null && Intrinsics.areEqual(exoPlayerImpl.getPlaybackParameters(), playbackParameters2)) {
            exoPlayerImpl.setPlaybackParameters(playbackParameters);
        }
        this.driftBasePlaybackParameters = null;
        this.driftAppliedPlaybackParameters = null;
        this.driftCorrectedPlayer = null;
    }

    public final void restoreGuestMuteState() {
        PlayerConnection playerConnection = this.playerConnection;
        if (playerConnection == null) {
            return;
        }
        MusicService musicService = playerConnection.service;
        StateFlowImpl stateFlowImpl = playerConnection.isMuted;
        Boolean bool = this.previousMuteState;
        if (bool != null) {
            Timber.Forest.tag("ListenTogetherManager");
            Objects.toString(stateFlowImpl.getValue());
            ConnectionPool.d(new Object[0]);
            StateFlowImpl stateFlowImpl2 = musicService.isMuted;
            stateFlowImpl2.getClass();
            stateFlowImpl2.updateState(null, bool);
            musicService.applyEffectiveVolume();
        } else if (((Boolean) stateFlowImpl.getValue()).booleanValue()) {
            Timber.Forest.tag("ListenTogetherManager");
            ConnectionPool.d(new Object[0]);
            StateFlowImpl stateFlowImpl3 = musicService.isMuted;
            Boolean bool2 = Boolean.FALSE;
            stateFlowImpl3.getClass();
            stateFlowImpl3.updateState(null, bool2);
            musicService.applyEffectiveVolume();
        }
        this.previousMuteState = null;
    }

    public final void sendTrackChangeInternal(MediaMetadata mediaMetadata) throws IOException {
        ArrayList arrayList;
        StateFlowImpl stateFlowImpl;
        ArrayList arrayList2;
        if (isHost()) {
            int i = mediaMetadata.duration;
            long j = i > 0 ? ((long) i) * 1000 : 180000L;
            String str = mediaMetadata.id;
            String str2 = mediaMetadata.title;
            String strJoinToArtistString = UtilsKt.joinToArtistString(mediaMetadata.artists, UtilsKt.getArtistSeparator(this.context), new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 15));
            MediaMetadata.Album album = mediaMetadata.album;
            String str3 = null;
            Listentogether.TrackInfo TrackInfo = ProtocolKt.TrackInfo(str, str2, strJoinToArtistString, album != null ? album.title : null, j, mediaMetadata.thumbnailUrl, mediaMetadata.suggestedBy);
            Timber.Forest.tag("ListenTogetherManager");
            TrackInfo.getTitle();
            ConnectionPool.d(new Object[0]);
            try {
                PlayerConnection playerConnection = this.playerConnection;
                if (playerConnection != null) {
                    List list = (List) playerConnection.queueWindows.getValue();
                    int iIntValue = ((Number) playerConnection.currentWindowIndex.getValue()).intValue();
                    list.getClass();
                    Iterable iterableDrop = (iIntValue < 0 || iIntValue >= list.size()) ? EmptyList.INSTANCE : CollectionsKt.drop(list, iIntValue + 1);
                    arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterableDrop, 10));
                    Iterator it = iterableDrop.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(toTrackInfo((Timeline.Window) it.next()));
                    }
                } else {
                    arrayList2 = null;
                }
                arrayList = arrayList2;
            } catch (Exception unused) {
                Timber.Forest.tag("ListenTogetherManager");
                ConnectionPool.e$1(new Object[0]);
                arrayList = null;
            }
            try {
                PlayerConnection playerConnection2 = this.playerConnection;
                if (playerConnection2 != null && (stateFlowImpl = playerConnection2.queueTitle) != null) {
                    str3 = (String) stateFlowImpl.getValue();
                }
            } catch (Exception unused2) {
                Timber.Forest.tag("ListenTogetherManager");
                ConnectionPool.e$1(new Object[0]);
            }
            ListenTogetherClient.sendPlaybackAction$default(this.client, "change_track", null, null, TrackInfo, arrayList, str3, null, 150);
        }
    }

    public final void setPlayerConnection(PlayerConnection playerConnection) {
        ConnectionPool connectionPool = Timber.Forest;
        connectionPool.tag("ListenTogetherManager");
        ListenTogetherClient listenTogetherClient = this.client;
        listenTogetherClient.isInRoom();
        ConnectionPool.d(new Object[0]);
        try {
            PlayerConnection playerConnection2 = this.playerConnection;
            boolean z = this.playerListenerRegistered;
            ListenTogetherManager$playerListener$1 listenTogetherManager$playerListener$1 = this.playerListener;
            if (z && playerConnection2 != null) {
                try {
                    playerConnection2.getPlayerSafe().removeListener(listenTogetherManager$playerListener$1);
                } catch (Exception unused) {
                    connectionPool = Timber.Forest;
                    connectionPool.tag("ListenTogetherManager");
                    ConnectionPool.e$1(new Object[0]);
                }
                this.playerListenerRegistered = false;
            }
            if (playerConnection2 != null) {
                playerConnection2.shouldBlockPlaybackChanges = null;
            }
            if (playerConnection2 != null) {
                playerConnection2.onRestartSong = null;
            }
            cancelDriftCorrection();
            invalidatePendingQueueMutations();
            this.playerConnection = playerConnection;
            byte b = 1;
            if (playerConnection != null) {
                playerConnection.shouldBlockPlaybackChanges = new PlayerMenuKt$$ExternalSyntheticLambda117(this, b);
            }
            if (playerConnection != null && listenTogetherClient.isInRoom()) {
                try {
                    playerConnection.getPlayerSafe().addListener(listenTogetherManager$playerListener$1);
                    this.playerListenerRegistered = true;
                    connectionPool.tag("ListenTogetherManager");
                    ConnectionPool.d(new Object[0]);
                } catch (Exception unused2) {
                    Timber.Forest.tag("ListenTogetherManager");
                    ConnectionPool.e$1(new Object[0]);
                    this.playerListenerRegistered = false;
                }
                playerConnection.onRestartSong = new ComponentRegistry$Builder$$ExternalSyntheticLambda2((Object) this, (Object) playerConnection, (byte) 9);
            }
            if (playerConnection != null && listenTogetherClient.isInRoom() && isHost()) {
                startQueueSyncObservation();
                startHeartbeat();
                startVolumeSyncObservation();
            } else {
                StandaloneCoroutine standaloneCoroutine = this.queueObserverJob;
                if (standaloneCoroutine != null) {
                    standaloneCoroutine.cancel(null);
                }
                this.queueObserverJob = null;
                stopHeartbeat();
                stopVolumeSyncObservation();
            }
            if (playerConnection != null && playerConnection2 != playerConnection && listenTogetherClient.isInRoom() && (!isHost() || playerConnection2 != null)) {
                this.applyNextHostSnapshot = isHost();
                listenTogetherClient.requestSync();
            }
            if (this.playerConnection == null) {
                return;
            }
            restoreGuestMuteState();
        } catch (Exception unused3) {
            Timber.Forest.tag("ListenTogetherManager");
            ConnectionPool.e$1(new Object[0]);
        }
    }

    public final void startDriftCorrection(PlayerConnection playerConnection, String str, long j, Long l) {
        cancelDriftCorrection();
        ExoPlayerImpl playerSafe = playerConnection.getPlayerSafe();
        if (!playerSafe.getPlayWhenReady() || l == null || this.client.serverClock.now() == null) {
            return;
        }
        PlaybackParameters playbackParameters = playerSafe.getPlaybackParameters();
        playbackParameters.getClass();
        this.driftBasePlaybackParameters = playbackParameters;
        this.driftCorrectedPlayer = playerSafe;
        this.driftCorrectionJob = AwaitKt.launch$default(this.scope, null, null, new C01531(this.driftCorrectionGeneration, this, playerConnection, playerSafe, str, j, l, playbackParameters, null), 3);
    }

    public final void startHeartbeat() {
        StandaloneCoroutine standaloneCoroutine = this.heartbeatJob;
        if (standaloneCoroutine == null || !standaloneCoroutine.isActive()) {
            this.heartbeatJob = AwaitKt.launch$default(this.scope, null, null, new C01541(null), 3);
            Timber.Forest.tag("ListenTogetherManager");
            ConnectionPool.d(new Object[0]);
        }
    }

    public final void startQueueSyncObservation() {
        StandaloneCoroutine standaloneCoroutine = this.queueObserverJob;
        if (standaloneCoroutine == null || !standaloneCoroutine.isActive()) {
            Timber.Forest.tag("ListenTogetherManager");
            ConnectionPool.d(new Object[0]);
            this.queueObserverJob = AwaitKt.launch$default(this.scope, null, null, new C01551(null), 3);
        }
    }

    public final void startVolumeSyncObservation() {
        StandaloneCoroutine standaloneCoroutine = this.volumeObserverJob;
        if (standaloneCoroutine == null || !standaloneCoroutine.isActive()) {
            Timber.Forest.tag("ListenTogetherManager");
            ConnectionPool.d(new Object[0]);
            this.volumeObserverJob = AwaitKt.launch$default(this.scope, null, null, new ListenTogetherManager$initialize$1(this, null, (byte) 4), 3);
        }
    }

    public final void stopHeartbeat() {
        StandaloneCoroutine standaloneCoroutine = this.heartbeatJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.heartbeatJob = null;
        Timber.Forest.tag("ListenTogetherManager");
        ConnectionPool.d(new Object[0]);
    }

    public final void stopVolumeSyncObservation() {
        StandaloneCoroutine standaloneCoroutine = this.volumeObserverJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.volumeObserverJob = null;
        this.lastSyncedVolume = null;
    }

    public final void suggestTrack(Listentogether.TrackInfo trackInfo) {
        ListenTogetherClient listenTogetherClient = this.client;
        if (!listenTogetherClient.isInRoom()) {
            listenTogetherClient.log(LogLevel.ERROR, "Cannot suggest track", "Not in room");
            return;
        }
        if (listenTogetherClient._role.getValue() == RoomRole.HOST) {
            listenTogetherClient.log(LogLevel.WARNING, "Host should not suggest tracks", null);
            return;
        }
        GeneratedMessageLite generatedMessageLiteM915build = Listentogether.SuggestTrackPayload.newBuilder().setTrackInfo(trackInfo).m915build();
        generatedMessageLiteM915build.getClass();
        listenTogetherClient.sendMessage("suggest_track", (Listentogether.SuggestTrackPayload) generatedMessageLiteM915build);
        ContextScope contextScope = listenTogetherClient.scope;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        AwaitKt.launch$default(contextScope, MainDispatcherLoader.dispatcher, null, new ListenTogetherClient$suggestTrack$1(listenTogetherClient, null), 2);
    }

    public final void syncToTrack(Listentogether.TrackInfo trackInfo) {
        Timber.Forest.tag("ListenTogetherManager");
        trackInfo.getTitle();
        ConnectionPool.d(new Object[0]);
        this.bufferingTrackId = trackInfo.getId();
        int i = this.currentTrackGeneration;
        StandaloneCoroutine standaloneCoroutine = this.activeSyncJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        this.activeSyncJob = AwaitKt.launch$default(this.scope, DefaultIoScheduler.INSTANCE, null, new C01561(i, trackInfo, null), 2);
    }

    public final Listentogether.TrackInfo toTrackInfo(Timeline.Window window) throws IOException {
        MediaItem mediaItem = window.mediaItem;
        mediaItem.getClass();
        MediaMetadata metadata = UuidKt.getMetadata(mediaItem);
        if (metadata == null) {
            return ProtocolKt.TrackInfo("unknown", "Unknown", "Unknown", "", 0L, "", null);
        }
        int i = metadata.duration;
        long j = i > 0 ? ((long) i) * 1000 : 180000L;
        String str = metadata.id;
        String str2 = metadata.title;
        String strJoinToArtistString = UtilsKt.joinToArtistString(metadata.artists, UtilsKt.getArtistSeparator(this.context), new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 14));
        MediaMetadata.Album album = metadata.album;
        return ProtocolKt.TrackInfo(str, str2, strJoinToArtistString, album != null ? album.title : null, j, metadata.thumbnailUrl, metadata.suggestedBy);
    }

    public final void transferHost(String str) {
        ListenTogetherClient listenTogetherClient = this.client;
        if (listenTogetherClient._role.getValue() != RoomRole.HOST) {
            listenTogetherClient.log(LogLevel.ERROR, "Cannot transfer host", "Not host");
            return;
        }
        GeneratedMessageLite generatedMessageLiteM915build = Listentogether.TransferHostPayload.newBuilder().setNewHostId(str).m915build();
        generatedMessageLiteM915build.getClass();
        listenTogetherClient.sendMessage("transfer_host", (Listentogether.TransferHostPayload) generatedMessageLiteM915build);
    }
}
