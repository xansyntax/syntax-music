package com.metrolist.music.utils;

import com.metrolist.innertube.YouTube;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SyncUtils$executeSaveEpisode$2$3 extends SuspendLambda implements Function1 {
    public final /* synthetic */ String $episodeId;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String $setVideoId;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SyncUtils$executeSaveEpisode$2$3(String str, String str2, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.$episodeId = str;
        this.$setVideoId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new SyncUtils$executeSaveEpisode$2$3(this.$episodeId, this.$setVideoId, continuation, (byte) 0);
            default:
                return new SyncUtils$executeSaveEpisode$2$3(this.$episodeId, this.$setVideoId, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = (Continuation) obj;
        switch (b) {
            case 0:
                break;
        }
        return ((SyncUtils$executeSaveEpisode$2$3) create(continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM1032removeEpisodeFromSavedEpisodes0E7RQCE;
        Object objM995addToPlaylist0E7RQCE;
        byte b = this.$r8$classId;
        String str = this.$setVideoId;
        String str2 = this.$episodeId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube = YouTube.INSTANCE;
                    this.label = true;
                    objM1032removeEpisodeFromSavedEpisodes0E7RQCE = youTube.m1032removeEpisodeFromSavedEpisodes0E7RQCE(str2, str, this);
                    if (objM1032removeEpisodeFromSavedEpisodes0E7RQCE == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM1032removeEpisodeFromSavedEpisodes0E7RQCE = ((Result) obj).value;
                }
                return new Result(objM1032removeEpisodeFromSavedEpisodes0E7RQCE);
            default:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube2 = YouTube.INSTANCE;
                    this.label = true;
                    objM995addToPlaylist0E7RQCE = youTube2.m995addToPlaylist0E7RQCE(str2, str, this);
                    if (objM995addToPlaylist0E7RQCE == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM995addToPlaylist0E7RQCE = ((Result) obj).value;
                }
                ResultKt.throwOnFailure(objM995addToPlaylist0E7RQCE);
                return Unit.INSTANCE;
        }
    }
}
