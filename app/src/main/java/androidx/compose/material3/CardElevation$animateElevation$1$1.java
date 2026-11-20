package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CardElevation$animateElevation$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ InteractionSource $interactionSource;
    public final /* synthetic */ SnapshotStateList $interactions;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardElevation$animateElevation$1$1(InteractionSource interactionSource, SnapshotStateList snapshotStateList, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$interactionSource = interactionSource;
        this.$interactions = snapshotStateList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        SnapshotStateList snapshotStateList = this.$interactions;
        InteractionSource interactionSource = this.$interactionSource;
        switch (b) {
            case 0:
                return new CardElevation$animateElevation$1$1(interactionSource, snapshotStateList, continuation, (byte) 0);
            case 1:
                return new CardElevation$animateElevation$1$1(interactionSource, snapshotStateList, continuation, (byte) 1);
            case 2:
                return new CardElevation$animateElevation$1$1(interactionSource, snapshotStateList, continuation, (byte) 2);
            case 3:
                return new CardElevation$animateElevation$1$1(interactionSource, snapshotStateList, continuation, (byte) 3);
            default:
                return new CardElevation$animateElevation$1$1(interactionSource, snapshotStateList, continuation, (byte) 4);
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
            case 2:
                break;
            case 3:
                break;
        }
        return ((CardElevation$animateElevation$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SnapshotStateList snapshotStateList = this.$interactions;
        InteractionSource interactionSource = this.$interactionSource;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
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
                Flow interactions = interactionSource.getInteractions();
                SliderKt$ThumbContent$1$1$1 sliderKt$ThumbContent$1$1$1 = new SliderKt$ThumbContent$1$1$1(snapshotStateList, (byte) 2);
                this.label = true;
                return interactions.collect(sliderKt$ThumbContent$1$1$1, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 1:
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Flow interactions2 = interactionSource.getInteractions();
                SliderKt$ThumbContent$1$1$1 sliderKt$ThumbContent$1$1$2 = new SliderKt$ThumbContent$1$1$1(snapshotStateList, (byte) 1);
                this.label = true;
                return interactions2.collect(sliderKt$ThumbContent$1$1$2, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                Flow interactions3 = interactionSource.getInteractions();
                SliderKt$ThumbContent$1$1$1 sliderKt$ThumbContent$1$1$3 = new SliderKt$ThumbContent$1$1$1(snapshotStateList, (byte) 3);
                this.label = true;
                return interactions3.collect(sliderKt$ThumbContent$1$1$3, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 3:
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
                Flow interactions4 = interactionSource.getInteractions();
                SliderKt$ThumbContent$1$1$1 sliderKt$ThumbContent$1$1$4 = new SliderKt$ThumbContent$1$1$1(snapshotStateList, (byte) 4);
                this.label = true;
                return interactions4.collect(sliderKt$ThumbContent$1$1$4, this) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                boolean z5 = this.label;
                if (z5) {
                    if (z5) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Flow interactions5 = interactionSource.getInteractions();
                SliderKt$ThumbContent$1$1$1 sliderKt$ThumbContent$1$1$5 = new SliderKt$ThumbContent$1$1$1(snapshotStateList, (byte) 5);
                this.label = true;
                return interactions5.collect(sliderKt$ThumbContent$1$1$5, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }
}
