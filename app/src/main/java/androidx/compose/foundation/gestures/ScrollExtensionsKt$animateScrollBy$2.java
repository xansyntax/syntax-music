package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollExtensionsKt$animateScrollBy$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ AnimationSpec $animationSpec;
    public final /* synthetic */ Ref$FloatRef $previousValue;
    public final /* synthetic */ float $value;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollExtensionsKt$animateScrollBy$2(float f, AnimationSpec animationSpec, Ref$FloatRef ref$FloatRef, Continuation continuation) {
        super(2, continuation);
        this.$value = f;
        this.$animationSpec = animationSpec;
        this.$previousValue = ref$FloatRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ScrollExtensionsKt$animateScrollBy$2 scrollExtensionsKt$animateScrollBy$2 = new ScrollExtensionsKt$animateScrollBy$2(this.$value, this.$animationSpec, this.$previousValue, continuation);
        scrollExtensionsKt$animateScrollBy$2.L$0 = obj;
        return scrollExtensionsKt$animateScrollBy$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ScrollExtensionsKt$animateScrollBy$2) create((ScrollScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z = this.label;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            ButtonKt$$ExternalSyntheticLambda1 buttonKt$$ExternalSyntheticLambda1 = new ButtonKt$$ExternalSyntheticLambda1(this.$previousValue, (ScrollScope) this.L$0, (byte) 4);
            this.label = true;
            Object objAnimate$default = ArcSplineKt.animate$default(CropImageView.DEFAULT_ASPECT_RATIO, this.$value, this.$animationSpec, buttonKt$$ExternalSyntheticLambda1, this, 4);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAnimate$default == coroutineSingletons) {
                return coroutineSingletons;
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
