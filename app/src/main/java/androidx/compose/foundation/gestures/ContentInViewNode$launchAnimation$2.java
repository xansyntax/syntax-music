package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import com.metrolist.music.MainActivity$MetrolistApp$5$1;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ContentInViewNode$launchAnimation$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ UpdatableAnimationState $animationState;
    public final /* synthetic */ BringIntoViewSpec $bringIntoViewSpec;
    public final /* synthetic */ long $viewportAdjustmentForReverseScroll;
    public /* synthetic */ Object L$0;
    public boolean label;
    public final /* synthetic */ ContentInViewNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentInViewNode$launchAnimation$2(ContentInViewNode contentInViewNode, UpdatableAnimationState updatableAnimationState, BringIntoViewSpec bringIntoViewSpec, long j, Continuation continuation) {
        super(2, continuation);
        this.this$0 = contentInViewNode;
        this.$animationState = updatableAnimationState;
        this.$bringIntoViewSpec = bringIntoViewSpec;
        this.$viewportAdjustmentForReverseScroll = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ContentInViewNode$launchAnimation$2 contentInViewNode$launchAnimation$2 = new ContentInViewNode$launchAnimation$2(this.this$0, this.$animationState, this.$bringIntoViewSpec, this.$viewportAdjustmentForReverseScroll, continuation);
        contentInViewNode$launchAnimation$2.L$0 = obj;
        return contentInViewNode$launchAnimation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ContentInViewNode$launchAnimation$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ContentInViewNode contentInViewNode = this.this$0;
        LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo = contentInViewNode.bringIntoViewRequests;
        boolean z = this.label;
        try {
            try {
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    Job job = AwaitKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext());
                    contentInViewNode.isAnimationRunning = true;
                    ScrollingLogic scrollingLogic = contentInViewNode.scrollingLogic;
                    MutatePriority mutatePriority = MutatePriority.Default;
                    MainActivity$MetrolistApp$5$1 mainActivity$MetrolistApp$5$1 = new MainActivity$MetrolistApp$5$1(this.$animationState, contentInViewNode, this.$bringIntoViewSpec, this.$viewportAdjustmentForReverseScroll, job, null);
                    this.label = true;
                    Object objScroll = scrollingLogic.scroll(mutatePriority, mainActivity$MetrolistApp$5$1, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objScroll == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                lazyLayoutBeyondBoundsInfo.resumeAndRemoveAll();
                contentInViewNode.isAnimationRunning = false;
                lazyLayoutBeyondBoundsInfo.cancelAndRemoveAll(null);
                contentInViewNode.trackingFocusedChild = false;
                return Unit.INSTANCE;
            } catch (CancellationException e) {
                throw e;
            }
        } catch (Throwable th) {
            contentInViewNode.isAnimationRunning = false;
            lazyLayoutBeyondBoundsInfo.cancelAndRemoveAll(null);
            contentInViewNode.trackingFocusedChild = false;
            throw th;
        }
    }
}
