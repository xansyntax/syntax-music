package com.metrolist.music.viewmodels;

import com.metrolist.innertube.YouTube;
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
public final class LocalPlaylistViewModel$2$page$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $browseId;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocalPlaylistViewModel$2$page$1(String str, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$browseId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        String str = this.$browseId;
        switch (b) {
            case 0:
                return new LocalPlaylistViewModel$2$page$1(str, continuation, (byte) 0);
            case 1:
                return new LocalPlaylistViewModel$2$page$1(str, continuation, (byte) 1);
            default:
                return new LocalPlaylistViewModel$2$page$1(str, continuation, (byte) 2);
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
        return ((LocalPlaylistViewModel$2$page$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM1025playlistgIAlus;
        Object objM998artistgIAlus;
        byte b = this.$r8$classId;
        String str = this.$browseId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        objM1025playlistgIAlus = ((Result) obj).value;
                    } else {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    }
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                YouTube youTube = YouTube.INSTANCE;
                this.label = true;
                objM1025playlistgIAlus = youTube.m1025playlistgIAlus(str, this);
                if (objM1025playlistgIAlus == coroutineSingletons) {
                    return coroutineSingletons;
                }
                Object obj2 = objM1025playlistgIAlus;
                if (!(obj2 instanceof Result.Failure)) {
                    return obj2;
                }
                return null;
            case 1:
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        objM998artistgIAlus = ((Result) obj).value;
                    } else {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    }
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                YouTube youTube2 = YouTube.INSTANCE;
                this.label = true;
                objM998artistgIAlus = youTube2.m998artistgIAlus(str, this);
                if (objM998artistgIAlus == coroutineSingletons) {
                    return coroutineSingletons;
                }
                Object obj3 = objM998artistgIAlus;
                if (!(obj3 instanceof Result.Failure)) {
                    return obj3;
                }
                return null;
            default:
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube3 = YouTube.INSTANCE;
                    List listListOf = CollectionsKt__IterablesKt.listOf(str);
                    this.label = true;
                    if (youTube3.m1006feedbackgIAlus(listListOf, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Object obj4 = ((Result) obj).value;
                }
                return Unit.INSTANCE;
        }
    }
}
