package com.metrolist.music.playback;

import android.content.Context;
import androidx.core.view.DisplayCompat;
import androidx.media3.common.MediaItem;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.playback.alarm.MusicAlarmEntry;
import com.metrolist.music.playback.alarm.MusicAlarmStore;
import com.metrolist.music.utils.SyncUtils$createPlaylist$1;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicService$handleAlarmTrigger$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $alarmId;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ MusicService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicService$handleAlarmTrigger$2(String str, MusicService musicService, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 6;
        this.$alarmId = str;
        this.this$0 = musicService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        String str = this.$alarmId;
        MusicService musicService = this.this$0;
        switch (b) {
            case 0:
                return new MusicService$handleAlarmTrigger$2(musicService, str, continuation, (byte) 0);
            case 1:
                return new MusicService$handleAlarmTrigger$2(musicService, str, continuation, (byte) 1);
            case 2:
                return new MusicService$handleAlarmTrigger$2(musicService, str, continuation, (byte) 2);
            case 3:
                return new MusicService$handleAlarmTrigger$2(musicService, str, continuation, (byte) 3);
            case 4:
                return new MusicService$handleAlarmTrigger$2(musicService, str, continuation, (byte) 4);
            case 5:
                return new MusicService$handleAlarmTrigger$2(musicService, str, continuation, (byte) 5);
            case 6:
                return new MusicService$handleAlarmTrigger$2(str, musicService, continuation);
            case 7:
                return new MusicService$handleAlarmTrigger$2(musicService, str, continuation, (byte) 7);
            case 8:
                return new MusicService$handleAlarmTrigger$2(musicService, str, continuation, (byte) 8);
            case 9:
                return new MusicService$handleAlarmTrigger$2(musicService, str, continuation, (byte) 9);
            case 10:
                return new MusicService$handleAlarmTrigger$2(musicService, str, continuation, (byte) 10);
            case 11:
                return new MusicService$handleAlarmTrigger$2(musicService, str, continuation, (byte) 11);
            default:
                return new MusicService$handleAlarmTrigger$2(musicService, str, continuation, (byte) 12);
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
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
        }
        return ((MusicService$handleAlarmTrigger$2) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objLoad;
        Object objLoad2;
        Object objFirst;
        switch (this.$r8$classId) {
            case 0:
                MusicService musicService = this.this$0;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z = this.label;
                try {
                    if (!z) {
                        ResultKt.throwOnFailure(obj);
                        MusicAlarmStore musicAlarmStore = MusicAlarmStore.INSTANCE;
                        this.label = true;
                        objLoad = musicAlarmStore.load(musicService, this);
                        if (objLoad == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objLoad = obj;
                    }
                    List<MusicAlarmEntry> list = (List) objLoad;
                    String str = this.$alarmId;
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    for (MusicAlarmEntry musicAlarmEntryCopy$default : list) {
                        if (musicAlarmEntryCopy$default.id.equals(str)) {
                            musicAlarmEntryCopy$default = MusicAlarmEntry.copy$default(musicAlarmEntryCopy$default, false, 0, 0, null, false, -1L, 61);
                        }
                        arrayList.add(musicAlarmEntryCopy$default);
                    }
                    DisplayCompat.scheduleAll(musicService, arrayList);
                    break;
                } catch (Throwable unused) {
                    Timber.Forest.tag("MusicService");
                    ConnectionPool.e$1(new Object[0]);
                }
                return Unit.INSTANCE;
            case 1:
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Flow flow = this.this$0.getDatabase().$$delegate_0.format(this.$alarmId);
                this.label = true;
                Object objFirst2 = StateFlowKt.first(flow, this);
                return objFirst2 == coroutineSingletons2 ? coroutineSingletons2 : objFirst2;
            case 2:
                MusicService musicService2 = this.this$0;
                CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    MusicAlarmStore musicAlarmStore2 = MusicAlarmStore.INSTANCE;
                    this.label = true;
                    objLoad2 = musicAlarmStore2.load(musicService2, this);
                    if (objLoad2 == coroutineSingletons3) {
                        return coroutineSingletons3;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objLoad2 = obj;
                }
                List<MusicAlarmEntry> list2 = (List) objLoad2;
                String str2 = this.$alarmId;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                for (MusicAlarmEntry musicAlarmEntryCopy$default2 : list2) {
                    if (musicAlarmEntryCopy$default2.id.equals(str2)) {
                        musicAlarmEntryCopy$default2 = MusicAlarmEntry.copy$default(musicAlarmEntryCopy$default2, false, 0, 0, null, false, -1L, 61);
                    }
                    arrayList2.add(musicAlarmEntryCopy$default2);
                }
                DisplayCompat.scheduleAll(musicService2, arrayList2);
                return Unit.INSTANCE;
            case 3:
                CoroutineSingletons coroutineSingletons4 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z4 = this.label;
                if (!z4) {
                    ResultKt.throwOnFailure(obj);
                    Flow flowPlaylist = this.this$0.getDatabase().$$delegate_0.playlist(this.$alarmId);
                    this.label = true;
                    objFirst = StateFlowKt.first(flowPlaylist, this);
                    if (objFirst == coroutineSingletons4) {
                        return coroutineSingletons4;
                    }
                } else {
                    if (!z4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objFirst = obj;
                }
                Playlist playlist = (Playlist) objFirst;
                if (playlist != null) {
                    return playlist.playlist.name;
                }
                return null;
            case 4:
                CoroutineSingletons coroutineSingletons5 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z5 = this.label;
                if (z5) {
                    if (z5) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Flow flowPlaylistSongs = this.this$0.getDatabase().$$delegate_0.playlistSongs(this.$alarmId);
                this.label = true;
                Object objFirst3 = StateFlowKt.first(flowPlaylistSongs, this);
                return objFirst3 == coroutineSingletons5 ? coroutineSingletons5 : objFirst3;
            case 5:
                String str3 = this.$alarmId;
                MusicService musicService3 = this.this$0;
                CoroutineSingletons coroutineSingletons6 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z6 = this.label;
                if (!z6) {
                    ResultKt.throwOnFailure(obj);
                    boolean z7 = MusicService.isRunning;
                    musicService3.performAggressiveCacheClear(str3);
                    long j = musicService3.RETRY_DELAY_MS;
                    this.label = true;
                    if (AwaitKt.delay(j, this) == coroutineSingletons6) {
                        return coroutineSingletons6;
                    }
                } else {
                    if (!z6) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                long currentPosition = musicService3.player.getCurrentPosition();
                int currentMediaItemIndex = musicService3.player.getCurrentMediaItemIndex();
                if (currentMediaItemIndex != -1) {
                    musicService3.player.seekTo(currentMediaItemIndex, currentPosition, false);
                }
                musicService3.player.prepare();
                Timber.Forest.tag("MusicService");
                ConnectionPool.d(new Object[0]);
                return Unit.INSTANCE;
            case 6:
                String str4 = this.$alarmId;
                MusicService musicService4 = this.this$0;
                CoroutineSingletons coroutineSingletons7 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z8 = this.label;
                if (!z8) {
                    ResultKt.throwOnFailure(obj);
                    Timber.Forest.tag("MusicService");
                    ConnectionPool.d(new Object[0]);
                    boolean z9 = MusicService.isRunning;
                    musicService4.performAggressiveCacheClear(str4);
                    long j2 = ((long) musicService4.RETRY_DELAY_MS) * 2;
                    this.label = true;
                    if (AwaitKt.delay(j2, this) == coroutineSingletons7) {
                        return coroutineSingletons7;
                    }
                } else {
                    if (!z8) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                musicService4.player.seekTo(musicService4.player.getCurrentMediaItemIndex(), musicService4.player.getCurrentPosition(), false);
                musicService4.player.prepare();
                Timber.Forest.tag("MusicService");
                ConnectionPool.d(new Object[0]);
                return Unit.INSTANCE;
            case 7:
                String str5 = this.$alarmId;
                MusicService musicService5 = this.this$0;
                CoroutineSingletons coroutineSingletons8 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z10 = this.label;
                if (!z10) {
                    ResultKt.throwOnFailure(obj);
                    boolean z11 = MusicService.isRunning;
                    musicService5.performAggressiveCacheClear(str5);
                    long j3 = musicService5.RETRY_DELAY_MS;
                    this.label = true;
                    if (AwaitKt.delay(j3, this) == coroutineSingletons8) {
                        return coroutineSingletons8;
                    }
                } else {
                    if (!z10) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                musicService5.player.seekTo(musicService5.player.getCurrentMediaItemIndex(), 0L, false);
                musicService5.player.prepare();
                Timber.Forest.tag("MusicService");
                ConnectionPool.d(new Object[0]);
                return Unit.INSTANCE;
            case 8:
                CoroutineSingletons coroutineSingletons9 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z12 = this.label;
                if (!z12) {
                    ResultKt.throwOnFailure(obj);
                    MusicService musicService6 = this.this$0;
                    String str6 = this.$alarmId;
                    this.label = true;
                    boolean z13 = MusicService.isRunning;
                    if (musicService6.markCachedIfFullyDownloaded(str6, this) == coroutineSingletons9) {
                        return coroutineSingletons9;
                    }
                } else {
                    if (!z12) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 9:
                CoroutineSingletons coroutineSingletons10 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z14 = this.label;
                if (!z14) {
                    ResultKt.throwOnFailure(obj);
                    MusicService musicService7 = this.this$0;
                    String str7 = this.$alarmId;
                    this.label = true;
                    boolean z15 = MusicService.isRunning;
                    if (musicService7.markCachedIfFullyDownloaded(str7, this) == coroutineSingletons10) {
                        return coroutineSingletons10;
                    }
                } else {
                    if (!z14) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 10:
                String str8 = this.$alarmId;
                MusicService musicService8 = this.this$0;
                CoroutineSingletons coroutineSingletons11 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z16 = this.label;
                if (!z16) {
                    ResultKt.throwOnFailure(obj);
                    Long playbackPosition = musicService8.getDatabase().getPlaybackPosition(str8);
                    if (playbackPosition != null && playbackPosition.longValue() > 0) {
                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                        HandlerContext handlerContext = MainDispatcherLoader.dispatcher;
                        SyncUtils$createPlaylist$1.AnonymousClass1 anonymousClass1 = new SyncUtils$createPlaylist$1.AnonymousClass1((Context) musicService8, str8, (Object) playbackPosition, (Continuation) null, (byte) 8);
                        this.label = true;
                        if (AwaitKt.withContext(handlerContext, anonymousClass1, this) == coroutineSingletons11) {
                            return coroutineSingletons11;
                        }
                    }
                } else {
                    if (!z16) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 11:
                CoroutineSingletons coroutineSingletons12 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z17 = this.label;
                if (z17) {
                    if (z17) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Flow flow2 = this.this$0.getDatabase().$$delegate_0.format(this.$alarmId);
                this.label = true;
                Object objFirst4 = StateFlowKt.first(flow2, this);
                return objFirst4 == coroutineSingletons12 ? coroutineSingletons12 : objFirst4;
            default:
                Unit unit = Unit.INSTANCE;
                String str9 = this.$alarmId;
                MusicService musicService9 = this.this$0;
                CoroutineSingletons coroutineSingletons13 = CoroutineSingletons.COROUTINE_SUSPENDED;
                boolean z18 = this.label;
                if (!z18) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    if (AwaitKt.delay(15000L, this) == coroutineSingletons13) {
                        return coroutineSingletons13;
                    }
                } else {
                    if (!z18) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (musicService9.player.getPlaybackState() == 2 && musicService9.player.getPlayWhenReady() && musicService9.player.getCurrentPosition() < 5000) {
                    MediaItem currentMediaItem = musicService9.player.getCurrentMediaItem();
                    if (Intrinsics.areEqual(currentMediaItem != null ? currentMediaItem.mediaId : null, str9)) {
                        musicService9.initialBufferRecoveryAttemptedMediaId = str9;
                        String strClientName = musicService9.songUrlCache.clientName(str9);
                        Timber.Forest.tag("MusicService");
                        ConnectionPool.w(str9, strClientName == null ? "unknown" : strClientName);
                        musicService9.performAggressiveCacheClear(str9);
                        musicService9.refreshStreamAndRetry(str9, strClientName, "initial buffer stall", false);
                    }
                }
                return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MusicService$handleAlarmTrigger$2(MusicService musicService, String str, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = musicService;
        this.$alarmId = str;
    }
}
