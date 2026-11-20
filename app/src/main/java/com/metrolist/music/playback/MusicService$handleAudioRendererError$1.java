package com.metrolist.music.playback;

import android.net.ConnectivityManager;
import com.metrolist.innertubex.extraction.ContentHints;
import com.metrolist.music.constants.AudioQuality;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.utils.InnerTubeXPlayer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicService$handleAudioRendererError$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $mediaId;
    public final /* synthetic */ byte $r8$classId;
    public byte label;
    public final /* synthetic */ MusicService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MusicService$handleAudioRendererError$1(MusicService musicService, String str, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = musicService;
        this.$mediaId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        String str = this.$mediaId;
        MusicService musicService = this.this$0;
        switch (b) {
            case 0:
                return new MusicService$handleAudioRendererError$1(musicService, str, continuation, (byte) 0);
            default:
                return new MusicService$handleAudioRendererError$1(musicService, str, continuation, (byte) 1);
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
        return ((MusicService$handleAudioRendererError$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0074, code lost:
    
        if (r0 == r6) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0114, code lost:
    
        if (kotlinx.coroutines.AwaitKt.delay(500, r16) == r8) goto L56;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CastConnectionHandler castConnectionHandler;
        Object objSongEntity;
        Object objM1519playerResponseForPlaybackbMdYcbs;
        switch (this.$r8$classId) {
            case 0:
                Unit unit = Unit.INSTANCE;
                MusicService musicService = this.this$0;
                StateFlowImpl stateFlowImpl = musicService.playerInitialized;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                byte b = this.label;
                try {
                    if (b == 0) {
                        ResultKt.throwOnFailure(obj);
                        musicService.player.setPlayWhenReady(false);
                        Timber.Forest.tag("MusicService");
                        ConnectionPool.d(new Object[0]);
                        long j = ((long) musicService.RETRY_DELAY_MS) * 3;
                        this.label = (byte) 1;
                        if (AwaitKt.delay(j, this) == coroutineSingletons) {
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
                    if (musicService.hasAudioFocus && ((Boolean) stateFlowImpl.getValue()).booleanValue() && ((castConnectionHandler = musicService.castConnectionHandler) == null || !((Boolean) castConnectionHandler.isCasting.getValue()).booleanValue())) {
                        musicService.player.setPlayWhenReady(true);
                    }
                    return unit;
                    if (((Boolean) stateFlowImpl.getValue()).booleanValue()) {
                        int currentMediaItemIndex = musicService.player.getCurrentMediaItemIndex();
                        if (currentMediaItemIndex != -1) {
                            musicService.player.seekTo(currentMediaItemIndex, musicService.player.getCurrentPosition(), false);
                            musicService.player.prepare();
                            Timber.Forest.tag("MusicService");
                            ConnectionPool.d(new Object[0]);
                            if (musicService.wasPlayingBeforeAudioFocusLoss) {
                                this.label = (byte) 2;
                            }
                        } else {
                            Timber.Forest.tag("MusicService");
                            ConnectionPool.w(new Object[0]);
                            musicService.handleFinalFailure();
                        }
                    } else {
                        Timber.Forest.tag("MusicService");
                        ConnectionPool.w(new Object[0]);
                    }
                    break;
                } catch (Exception unused) {
                    Timber.Forest.tag("MusicService");
                    ConnectionPool.e$1(new Object[0]);
                    boolean z = MusicService.isRunning;
                    musicService.handleFinalFailure();
                }
                return unit;
            default:
                MusicService musicService2 = this.this$0;
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                byte b2 = this.label;
                if (b2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    MusicDatabase database = musicService2.getDatabase();
                    String str = this.$mediaId;
                    this.label = (byte) 1;
                    objSongEntity = database.$$delegate_0.songEntity(str, this);
                    if (objSongEntity != coroutineSingletons2) {
                    }
                    return coroutineSingletons2;
                }
                if (b2 == 1) {
                    ResultKt.throwOnFailure(obj);
                    objSongEntity = obj;
                } else {
                    if (b2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM1519playerResponseForPlaybackbMdYcbs = ((Result) obj).value;
                }
                return new Result(objM1519playerResponseForPlaybackbMdYcbs);
                SongEntity songEntity = (SongEntity) objSongEntity;
                InnerTubeXPlayer innerTubeXPlayer = InnerTubeXPlayer.INSTANCE;
                String str2 = this.$mediaId;
                AudioQuality audioQuality = musicService2.audioQuality;
                if (audioQuality == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("audioQuality");
                    throw null;
                }
                ConnectivityManager connectivityManager = musicService2.connectivityManager;
                if (connectivityManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("connectivityManager");
                    throw null;
                }
                ContentHints contentHints = new ContentHints(songEntity != null ? Boolean.valueOf(songEntity.explicit) : null, songEntity != null ? Boolean.valueOf(songEntity.isUploaded) : null, 2030);
                this.label = (byte) 2;
                objM1519playerResponseForPlaybackbMdYcbs = InnerTubeXPlayer.INSTANCE.m1519playerResponseForPlaybackbMdYcbs(str2, audioQuality, connectivityManager, contentHints, (34 & 32) != 0, this);
                break;
                break;
        }
    }
}
