package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$LongRef;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollingLogic$doFlingAnimation$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ long $available;
    public final /* synthetic */ Ref$LongRef $result;
    public long J$0;
    public /* synthetic */ Object L$0;
    public ScrollingLogic L$1;
    public Ref$LongRef L$2;
    public boolean label;
    public final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$doFlingAnimation$2(ScrollingLogic scrollingLogic, Ref$LongRef ref$LongRef, long j, Continuation continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
        this.$result = ref$LongRef;
        this.$available = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ScrollingLogic$doFlingAnimation$2 scrollingLogic$doFlingAnimation$2 = new ScrollingLogic$doFlingAnimation$2(this.this$0, this.$result, this.$available, continuation);
        scrollingLogic$doFlingAnimation$2.L$0 = obj;
        return scrollingLogic$doFlingAnimation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ScrollingLogic$doFlingAnimation$2) create((ScrollingLogic$nestedScrollScope$1) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ScrollingLogic scrollingLogic;
        Ref$LongRef ref$LongRef;
        ScrollingLogic scrollingLogic2;
        long j;
        boolean z = this.label;
        Orientation orientation = Orientation.Horizontal;
        byte b = 1;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1 = (ScrollingLogic$nestedScrollScope$1) this.L$0;
            scrollingLogic = this.this$0;
            AnchoredDraggableNode$fling$2$scrollScope$1 anchoredDraggableNode$fling$2$scrollScope$1 = new AnchoredDraggableNode$fling$2$scrollScope$1(scrollingLogic, scrollingLogic$nestedScrollScope$1, b);
            FlingBehavior flingBehavior = scrollingLogic.flingBehavior;
            Ref$LongRef ref$LongRef2 = this.$result;
            long j2 = ref$LongRef2.element;
            Orientation orientation2 = scrollingLogic.orientation;
            long j3 = this.$available;
            float fReverseIfNeeded = scrollingLogic.reverseIfNeeded(orientation2 == orientation ? Velocity.m819getXimpl(j3) : Velocity.m820getYimpl(j3));
            this.L$0 = scrollingLogic;
            this.L$1 = scrollingLogic;
            this.L$2 = ref$LongRef2;
            this.J$0 = j2;
            this.label = true;
            obj = flingBehavior.performFling(anchoredDraggableNode$fling$2$scrollScope$1, fReverseIfNeeded, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
            ref$LongRef = ref$LongRef2;
            scrollingLogic2 = scrollingLogic;
            j = j2;
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j = this.J$0;
            ref$LongRef = this.L$2;
            scrollingLogic = this.L$1;
            scrollingLogic2 = (ScrollingLogic) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        float fReverseIfNeeded2 = scrollingLogic2.reverseIfNeeded(((Number) obj).floatValue());
        ref$LongRef.element = scrollingLogic.orientation == orientation ? Velocity.m818copyOhffZ5M$default(j, fReverseIfNeeded2, CropImageView.DEFAULT_ASPECT_RATIO, 2) : Velocity.m818copyOhffZ5M$default(j, CropImageView.DEFAULT_ASPECT_RATIO, fReverseIfNeeded2, 1);
        return Unit.INSTANCE;
    }
}
