package com.metrolist.music.listentogether;

import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.YouTubeQueue;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ListenTogetherManager$syncToTrack$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $generation;
    public final /* synthetic */ List $queue;
    public final /* synthetic */ Listentogether.TrackInfo $track;
    public int I$0;
    public /* synthetic */ Object L$0;
    public PlayerConnection L$1;
    public byte label;
    public final /* synthetic */ ListenTogetherManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListenTogetherManager$syncToTrack$1$1$1(ListenTogetherManager listenTogetherManager, int i, Listentogether.TrackInfo trackInfo, List list, Continuation continuation) {
        super(2, continuation);
        this.this$0 = listenTogetherManager;
        this.$generation = i;
        this.$track = trackInfo;
        this.$queue = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ListenTogetherManager$syncToTrack$1$1$1 listenTogetherManager$syncToTrack$1$1$1 = new ListenTogetherManager$syncToTrack$1$1$1(this.this$0, this.$generation, this.$track, this.$queue, continuation);
        listenTogetherManager$syncToTrack$1$1$1.L$0 = obj;
        return listenTogetherManager$syncToTrack$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ListenTogetherManager$syncToTrack$1$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0093  */
    /* JADX WARN: Code duplicated, block: B:31:0x009b  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ba A[Catch: Exception -> 0x00d8, TRY_LEAVE, TryCatch #0 {Exception -> 0x00d8, blocks: (B:33:0x00af, B:35:0x00ba), top: B:47:0x00af }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:47:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d3, code lost:
    
        if (kotlinx.coroutines.AwaitKt.delay(50, r18) == r2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x012a, code lost:
    
        if (kotlinx.coroutines.AwaitKt.delay(100, r18) == r2) goto L44;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00d3 -> B:40:0x00d6). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        PlayerConnection playerConnection;
        int i;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        byte b = this.label;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            ListenTogetherManager listenTogetherManager = this.this$0;
            if (listenTogetherManager.currentTrackGeneration != this.$generation) {
                Timber.Forest.tag("ListenTogetherManager");
                this.$track.getId();
                ConnectionPool.d(new Object[0]);
                this.this$0.isSyncing = false;
                return unit;
            }
            playerConnection = listenTogetherManager.playerConnection;
            if (playerConnection == null) {
                listenTogetherManager.isSyncing = false;
                return unit;
            }
            listenTogetherManager.isSyncing = true;
            playerConnection.allowInternalSync = true;
            WatchEndpoint watchEndpoint = new WatchEndpoint(62, this.$track.getId(), null, null);
            SongItem songItem = (SongItem) CollectionsKt.firstOrNull(this.$queue);
            playerConnection.playQueue(new YouTubeQueue(watchEndpoint, songItem != null ? HexFormatKt.toMediaMetadata(songItem) : null));
            try {
                playerConnection.service.queueTitle = "Listen Together";
            } catch (Exception unused) {
                Timber.Forest.tag("ListenTogetherManager");
                ConnectionPool.e$1(new Object[0]);
            }
            playerConnection.allowInternalSync = false;
            i = 0;
            if (i >= 40) {
                playerConnection.pause();
                this.this$0.pendingSyncState = ProtocolKt.SyncStatePayload(this.$track, false, 0L, 0L, null, null, (112 & 64) != 0 ? 0L : 0L);
                this.this$0.applyPendingSyncIfReady();
                ListenTogetherClient listenTogetherClient = this.this$0.client;
                String id = this.$track.getId();
                id.getClass();
                listenTogetherClient.sendBufferReady(id);
                Timber.Forest.tag("ListenTogetherManager");
                this.$track.getId();
                ConnectionPool.d(new Object[0]);
                this.L$0 = null;
                this.L$1 = null;
                this.I$0 = i;
                this.label = (byte) 2;
            } else {
                if (this.this$0.currentTrackGeneration != this.$generation) {
                    Timber.Forest.tag("ListenTogetherManager");
                    this.$track.getId();
                    ConnectionPool.d(new Object[0]);
                    this.this$0.isSyncing = false;
                    return unit;
                }
                if (playerConnection.getPlayerSafe().getPlaybackState() == 3) {
                    Timber.Forest.tag("ListenTogetherManager");
                    ConnectionPool.d(new Object[0]);
                    playerConnection.pause();
                    this.this$0.pendingSyncState = ProtocolKt.SyncStatePayload(this.$track, false, 0L, 0L, null, null, (112 & 64) != 0 ? 0L : 0L);
                    this.this$0.applyPendingSyncIfReady();
                    ListenTogetherClient listenTogetherClient2 = this.this$0.client;
                    String id2 = this.$track.getId();
                    id2.getClass();
                    listenTogetherClient2.sendBufferReady(id2);
                    Timber.Forest.tag("ListenTogetherManager");
                    this.$track.getId();
                    ConnectionPool.d(new Object[0]);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.I$0 = i;
                    this.label = (byte) 2;
                } else {
                    this.L$0 = null;
                    this.L$1 = playerConnection;
                    this.I$0 = i;
                    this.label = (byte) 1;
                }
            }
            return coroutineSingletons;
        }
        if (b == 1) {
            i = this.I$0;
            playerConnection = this.L$1;
            ResultKt.throwOnFailure(obj);
            i++;
            if (i >= 40) {
                playerConnection.pause();
                this.this$0.pendingSyncState = ProtocolKt.SyncStatePayload(this.$track, false, 0L, 0L, null, null, (112 & 64) != 0 ? 0L : 0L);
                this.this$0.applyPendingSyncIfReady();
                ListenTogetherClient listenTogetherClient3 = this.this$0.client;
                String id3 = this.$track.getId();
                id3.getClass();
                listenTogetherClient3.sendBufferReady(id3);
                Timber.Forest.tag("ListenTogetherManager");
                this.$track.getId();
                ConnectionPool.d(new Object[0]);
                this.L$0 = null;
                this.L$1 = null;
                this.I$0 = i;
                this.label = (byte) 2;
            } else {
                if (this.this$0.currentTrackGeneration != this.$generation) {
                    Timber.Forest.tag("ListenTogetherManager");
                    this.$track.getId();
                    ConnectionPool.d(new Object[0]);
                    this.this$0.isSyncing = false;
                    return unit;
                }
                try {
                    if (playerConnection.getPlayerSafe().getPlaybackState() == 3) {
                        Timber.Forest.tag("ListenTogetherManager");
                        ConnectionPool.d(new Object[0]);
                        playerConnection.pause();
                        this.this$0.pendingSyncState = ProtocolKt.SyncStatePayload(this.$track, false, 0L, 0L, null, null, (112 & 64) != 0 ? 0L : 0L);
                        this.this$0.applyPendingSyncIfReady();
                        ListenTogetherClient listenTogetherClient4 = this.this$0.client;
                        String id4 = this.$track.getId();
                        id4.getClass();
                        listenTogetherClient4.sendBufferReady(id4);
                        Timber.Forest.tag("ListenTogetherManager");
                        this.$track.getId();
                        ConnectionPool.d(new Object[0]);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.I$0 = i;
                        this.label = (byte) 2;
                    } else {
                        this.L$0 = null;
                        this.L$1 = playerConnection;
                        this.I$0 = i;
                        this.label = (byte) 1;
                    }
                } catch (Exception unused2) {
                    Timber.Forest.tag("ListenTogetherManager");
                    ConnectionPool.e$1(new Object[0]);
                }
            }
            return coroutineSingletons;
        }
        if (b != 2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.isSyncing = false;
        return unit;
    }
}
