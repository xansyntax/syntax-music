package com.metrolist.music.playback;

import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.BrowseEndpoint;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicService$startRadioSeamlessly$1$1$relatedPage$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ BrowseEndpoint $relatedEndpoint;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MusicService$startRadioSeamlessly$1$1$relatedPage$1(BrowseEndpoint browseEndpoint, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$relatedEndpoint = browseEndpoint;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new MusicService$startRadioSeamlessly$1$1$relatedPage$1(this.$relatedEndpoint, continuation, (byte) 0);
            default:
                return new MusicService$startRadioSeamlessly$1$1$relatedPage$1(this.$relatedEndpoint, continuation, (byte) 1);
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
        return ((MusicService$startRadioSeamlessly$1$1$relatedPage$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM1031relatedgIAlus;
        Object objM999artistItemsgIAlus;
        byte b = this.$r8$classId;
        BrowseEndpoint browseEndpoint = this.$relatedEndpoint;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        objM1031relatedgIAlus = ((Result) obj).value;
                    } else {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    }
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                YouTube youTube = YouTube.INSTANCE;
                this.label = true;
                objM1031relatedgIAlus = youTube.m1031relatedgIAlus(browseEndpoint, this);
                if (objM1031relatedgIAlus == coroutineSingletons) {
                    return coroutineSingletons;
                }
                Object obj2 = objM1031relatedgIAlus;
                if (!(obj2 instanceof Result.Failure)) {
                    return obj2;
                }
                return null;
            default:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube2 = YouTube.INSTANCE;
                    this.label = true;
                    objM999artistItemsgIAlus = youTube2.m999artistItemsgIAlus(browseEndpoint, this);
                    if (objM999artistItemsgIAlus == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM999artistItemsgIAlus = ((Result) obj).value;
                }
                return new Result(objM999artistItemsgIAlus);
        }
    }
}
