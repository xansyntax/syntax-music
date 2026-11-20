package androidx.compose.foundation.pager;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListState$scrollToItem$2;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode;
import androidx.compose.material3.internal.DeterminateLinearWavyProgressNode;
import androidx.compose.material3.internal.DeterminateLinearWavyProgressNode$$ExternalSyntheticLambda0;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.utils.UtilsKt;
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
public final class PagerState$scrollToPage$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $page;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagerState$scrollToPage$2(Object obj, int i, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = obj;
        this.$page = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        int i = this.$page;
        Object obj2 = this.this$0;
        switch (b) {
            case 0:
                return new PagerState$scrollToPage$2((PagerState) obj2, i, continuation, (byte) 0);
            case 1:
                return new PagerState$scrollToPage$2((LazyLayoutSemanticsModifierNode) obj2, i, continuation, (byte) 1);
            case 2:
                return new PagerState$scrollToPage$2((DeterminateLinearWavyProgressNode) obj2, i, continuation, (byte) 2);
            case 3:
                return new PagerState$scrollToPage$2((MusicService) obj2, i, continuation, (byte) 3);
            default:
                return new PagerState$scrollToPage$2((LazyListState) obj2, i, continuation, (byte) 4);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((PagerState$scrollToPage$2) create((ScrollScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                return ((PagerState$scrollToPage$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 2:
                return ((PagerState$scrollToPage$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 3:
                return ((PagerState$scrollToPage$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            default:
                return ((PagerState$scrollToPage$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Object obj2 = Unit.INSTANCE;
        int i = this.$page;
        Object obj3 = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        byte b2 = 1;
        switch (b) {
            case 0:
                PagerState pagerState = (PagerState) obj3;
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    if (pagerState.awaitScrollDependencies(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                pagerState.snapToItem$foundation(pagerState.coerceInPageRange(i), CropImageView.DEFAULT_ASPECT_RATIO, true);
                return obj2;
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    LazyLayoutSemanticState lazyLayoutSemanticState = ((LazyLayoutSemanticsModifierNode) obj3).state;
                    this.label = true;
                    return lazyLayoutSemanticState.scrollToItem(i, this) == coroutineSingletons ? coroutineSingletons : obj2;
                }
                if (z2) {
                    ResultKt.throwOnFailure(obj);
                    return obj2;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 2:
                DeterminateLinearWavyProgressNode determinateLinearWavyProgressNode = (DeterminateLinearWavyProgressNode) obj3;
                boolean z3 = this.label;
                if (z3) {
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return obj2;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                float floatValue = determinateLinearWavyProgressNode.waveOffset.getFloatValue();
                Animatable animatableAnimatable$default = ArcSplineKt.Animatable$default(floatValue);
                float f = 1.0f + floatValue;
                animatableAnimatable$default.updateBounds(new Float(floatValue), new Float(f));
                Float f2 = new Float(f);
                InfiniteRepeatableSpec infiniteRepeatableSpecM19infiniteRepeatable9IiC70o$default = ArcSplineKt.m19infiniteRepeatable9IiC70o$default(ArcSplineKt.tween$default(i, 0, EasingKt.LinearEasing, 2), RepeatMode.Restart, 0L, 4);
                DeterminateLinearWavyProgressNode$$ExternalSyntheticLambda0 determinateLinearWavyProgressNode$$ExternalSyntheticLambda0 = new DeterminateLinearWavyProgressNode$$ExternalSyntheticLambda0(determinateLinearWavyProgressNode, b2);
                this.label = true;
                return Animatable.animateTo$default(animatableAnimatable$default, f2, infiniteRepeatableSpecM19infiniteRepeatable9IiC70o$default, null, determinateLinearWavyProgressNode$$ExternalSyntheticLambda0, this, 4) == coroutineSingletons ? coroutineSingletons : obj2;
            case 3:
                boolean z4 = this.label;
                if (!z4) {
                    ResultKt.throwOnFailure(obj);
                    LazyListState$scrollToItem$2 lazyListState$scrollToItem$2 = new LazyListState$scrollToItem$2(i, null);
                    this.label = true;
                    return UtilsKt.safeDataStoreEdit((MusicService) obj3, lazyListState$scrollToItem$2, this) == coroutineSingletons ? coroutineSingletons : obj2;
                }
                if (z4) {
                    ResultKt.throwOnFailure(obj);
                    return obj2;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                boolean z5 = this.label;
                try {
                    if (!z5) {
                        ResultKt.throwOnFailure(obj);
                        this.label = true;
                        if (((LazyListState) obj3).animateScrollToItem(i, this) == coroutineSingletons) {
                            obj2 = coroutineSingletons;
                        }
                    } else {
                        if (!z5) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return obj2;
                } catch (Exception unused) {
                    return obj2;
                }
        }
    }
}
