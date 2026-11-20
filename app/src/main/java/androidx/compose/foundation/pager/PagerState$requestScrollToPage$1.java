package androidx.compose.foundation.pager;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.MutatePriority;
import com.metrolist.music.App$Companion$forgetAccount$2;
import com.yalantis.ucrop.view.CropImageView;
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
public final class PagerState$requestScrollToPage$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ PagerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagerState$requestScrollToPage$1(PagerState pagerState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = pagerState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        PagerState pagerState = this.this$0;
        switch (b) {
            case 0:
                return new PagerState$requestScrollToPage$1(pagerState, continuation, (byte) 0);
            case 1:
                return new PagerState$requestScrollToPage$1(pagerState, continuation, (byte) 1);
            default:
                return new PagerState$requestScrollToPage$1(pagerState, continuation, (byte) 2);
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
        return ((PagerState$requestScrollToPage$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objAnimateScrollToPage;
        Object objAnimateScrollToPage2;
        byte b = this.$r8$classId;
        PagerState pagerState = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    Object objScroll$suspendImpl = PagerState.scroll$suspendImpl(pagerState, MutatePriority.Default, new App$Companion$forgetAccount$2(2, null, (byte) 2), this);
                    if (objScroll$suspendImpl != coroutineSingletons) {
                        objScroll$suspendImpl = unit;
                    }
                    if (objScroll$suspendImpl == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return unit;
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    PagerStateKt$UnitDensity$1 pagerStateKt$UnitDensity$1 = PagerStateKt.UnitDensity;
                    if (pagerState.getCurrentPage() - 1 < 0 || (objAnimateScrollToPage = pagerState.animateScrollToPage(pagerState.getCurrentPage() - 1, ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, 7), this)) != coroutineSingletons) {
                        objAnimateScrollToPage = unit;
                    }
                    if (objAnimateScrollToPage == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return unit;
            default:
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    PagerStateKt$UnitDensity$1 pagerStateKt$UnitDensity$2 = PagerStateKt.UnitDensity;
                    if (pagerState.getCurrentPage() + 1 >= pagerState.getPageCount() || (objAnimateScrollToPage2 = pagerState.animateScrollToPage(pagerState.getCurrentPage() + 1, ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, 7), this)) != coroutineSingletons) {
                        objAnimateScrollToPage2 = unit;
                    }
                    if (objAnimateScrollToPage2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return unit;
        }
    }
}
