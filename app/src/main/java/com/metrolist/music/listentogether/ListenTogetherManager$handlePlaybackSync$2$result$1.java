package com.metrolist.music.listentogether;

import com.metrolist.innertube.YouTube;
import com.metrolist.music.listentogether.proto.Listentogether;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ListenTogetherManager$handlePlaybackSync$2$result$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Listentogether.TrackInfo $track;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListenTogetherManager$handlePlaybackSync$2$result$1(Listentogether.TrackInfo trackInfo, Continuation continuation) {
        super(2, continuation);
        this.$track = trackInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ListenTogetherManager$handlePlaybackSync$2$result$1(this.$track, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ListenTogetherManager$handlePlaybackSync$2$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM989queue0E7RQCE$default;
        boolean z = this.label;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            YouTube youTube = YouTube.INSTANCE;
            List listListOf = CollectionsKt__IterablesKt.listOf(this.$track.getId());
            this.label = true;
            objM989queue0E7RQCE$default = YouTube.m989queue0E7RQCE$default(listListOf, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
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
        return new Result(objM989queue0E7RQCE$default);
    }
}
