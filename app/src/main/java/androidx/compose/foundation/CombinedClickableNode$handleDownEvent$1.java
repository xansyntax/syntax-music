package androidx.compose.foundation;

import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CombinedClickableNode$handleDownEvent$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ CombinedClickableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CombinedClickableNode$handleDownEvent$1(CombinedClickableNode combinedClickableNode, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = combinedClickableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        CombinedClickableNode combinedClickableNode = this.this$0;
        switch (b) {
            case 0:
                return new CombinedClickableNode$handleDownEvent$1(combinedClickableNode, continuation, (byte) 0);
            case 1:
                return new CombinedClickableNode$handleDownEvent$1(combinedClickableNode, continuation, (byte) 1);
            default:
                return new CombinedClickableNode$handleDownEvent$1(combinedClickableNode, continuation, (byte) 2);
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
        return ((CombinedClickableNode$handleDownEvent$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        CombinedClickableNode combinedClickableNode = this.this$0;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    long longPressTimeoutMillis = ((ViewConfiguration) HitTestResultKt.currentValueOf(combinedClickableNode, CompositionLocalsKt.LocalViewConfiguration)).getLongPressTimeoutMillis();
                    this.label = true;
                    if (AwaitKt.delay(longPressTimeoutMillis, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Function0 function0 = combinedClickableNode.onLongClick;
                if (function0 != null) {
                    function0.invoke();
                }
                if (combinedClickableNode.hapticFeedbackEnabled) {
                    ((PlatformHapticFeedback) ((HapticFeedback) HitTestResultKt.currentValueOf(combinedClickableNode, CompositionLocalsKt.LocalHapticFeedback))).m578performHapticFeedbackCdsT49E(0);
                }
                combinedClickableNode.longPressTriggered = true;
                StandaloneCoroutine standaloneCoroutine = combinedClickableNode.tapJob;
                if (standaloneCoroutine != null) {
                    standaloneCoroutine.cancel(null);
                }
                combinedClickableNode.tapJob = null;
                combinedClickableNode.longPressJob = null;
                return unit;
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    long longPressTimeoutMillis2 = ((ViewConfiguration) HitTestResultKt.currentValueOf(combinedClickableNode, CompositionLocalsKt.LocalViewConfiguration)).getLongPressTimeoutMillis();
                    this.label = true;
                    if (AwaitKt.delay(longPressTimeoutMillis2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Function0 function1 = combinedClickableNode.onLongClick;
                if (function1 != null) {
                    function1.invoke();
                }
                if (combinedClickableNode.hapticFeedbackEnabled) {
                    ((PlatformHapticFeedback) ((HapticFeedback) HitTestResultKt.currentValueOf(combinedClickableNode, CompositionLocalsKt.LocalHapticFeedback))).m578performHapticFeedbackCdsT49E(0);
                }
                combinedClickableNode.indirectLongPressTriggered = true;
                StandaloneCoroutine standaloneCoroutine2 = combinedClickableNode.indirectTapJob;
                if (standaloneCoroutine2 != null) {
                    standaloneCoroutine2.cancel(null);
                }
                combinedClickableNode.indirectTapJob = null;
                combinedClickableNode.indirectLongPressJob = null;
                return unit;
            default:
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    long longPressTimeoutMillis3 = ((ViewConfiguration) HitTestResultKt.currentValueOf(combinedClickableNode, CompositionLocalsKt.LocalViewConfiguration)).getLongPressTimeoutMillis();
                    this.label = true;
                    if (AwaitKt.delay(longPressTimeoutMillis3, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Function0 function2 = combinedClickableNode.onLongClick;
                if (function2 == null) {
                    return unit;
                }
                function2.invoke();
                return unit;
        }
    }
}
