package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.ui.geometry.Offset;
import com.metrolist.music.utils.SyncUtils$tryAutoSync$1;
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
public final class ScrollableNode$onKeyEvent$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ long $scrollAmount;
    public boolean label;
    public final /* synthetic */ ScrollableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScrollableNode$onKeyEvent$1(ScrollableNode scrollableNode, long j, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = scrollableNode;
        this.$scrollAmount = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new ScrollableNode$onKeyEvent$1(this.this$0, this.$scrollAmount, continuation, (byte) 0);
            case 1:
                ScrollableNode$onKeyEvent$1 scrollableNode$onKeyEvent$1 = new ScrollableNode$onKeyEvent$1(this.this$0, continuation);
                scrollableNode$onKeyEvent$1.$scrollAmount = ((Offset) obj).packedValue;
                return scrollableNode$onKeyEvent$1;
            case 2:
                return new ScrollableNode$onKeyEvent$1(this.this$0, this.$scrollAmount, continuation, (byte) 2);
            default:
                return new ScrollableNode$onKeyEvent$1(this.this$0, this.$scrollAmount, continuation, (byte) 3);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((ScrollableNode$onKeyEvent$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                long j = ((Offset) obj).packedValue;
                ScrollableNode$onKeyEvent$1 scrollableNode$onKeyEvent$1 = new ScrollableNode$onKeyEvent$1(this.this$0, (Continuation) obj2);
                scrollableNode$onKeyEvent$1.$scrollAmount = j;
                return scrollableNode$onKeyEvent$1.invokeSuspend(unit);
            case 2:
                return ((ScrollableNode$onKeyEvent$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            default:
                return ((ScrollableNode$onKeyEvent$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ScrollableNode scrollableNode = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Continuation continuation = null;
        byte b2 = 1;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                ScrollingLogic scrollingLogic = scrollableNode.scrollLogic;
                SyncUtils$tryAutoSync$1.AnonymousClass1 anonymousClass1 = new SyncUtils$tryAutoSync$1.AnonymousClass1(this.$scrollAmount, continuation, b2);
                this.label = true;
                return scrollingLogic.scroll(MutatePriority.UserInput, anonymousClass1, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 1:
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                long j = this.$scrollAmount;
                this.label = true;
                Object objM97semanticsScrollByd4ec7I = ScrollableKt.m97semanticsScrollByd4ec7I(scrollableNode.scrollLogic, j, this);
                return objM97semanticsScrollByd4ec7I == coroutineSingletons ? coroutineSingletons : objM97semanticsScrollByd4ec7I;
            case 2:
                boolean z3 = this.label;
                if (z3) {
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                ScrollingLogic scrollingLogic2 = scrollableNode.scrollLogic;
                long j2 = this.$scrollAmount;
                this.label = true;
                return scrollingLogic2.m102onScrollStoppedBMRW4eQ(j2, true, this) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                boolean z4 = this.label;
                if (z4) {
                    if (z4) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                ScrollingLogic scrollingLogic3 = scrollableNode.scrollLogic;
                long j3 = this.$scrollAmount;
                this.label = true;
                return scrollingLogic3.m102onScrollStoppedBMRW4eQ(j3, false, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableNode$onKeyEvent$1(ScrollableNode scrollableNode, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 1;
        this.this$0 = scrollableNode;
    }
}
