package androidx.compose.runtime;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableIntList;
import androidx.collection.MutableObjectList;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.sse.ServerSentEventKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SequenceScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposePausableCompositionException$operationsSequence$1 extends RestrictedSuspendLambda implements Function2 {
    public int I$0;
    public int I$1;
    public int I$2;
    public /* synthetic */ Object L$0;
    public boolean label;
    public final /* synthetic */ ComposePausableCompositionException this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposePausableCompositionException$operationsSequence$1(ComposePausableCompositionException composePausableCompositionException, Continuation continuation) {
        super(2, continuation);
        this.this$0 = composePausableCompositionException;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ComposePausableCompositionException$operationsSequence$1 composePausableCompositionException$operationsSequence$1 = new ComposePausableCompositionException$operationsSequence$1(this.this$0, continuation);
        composePausableCompositionException$operationsSequence$1.L$0 = obj;
        return composePausableCompositionException$operationsSequence$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ComposePausableCompositionException$operationsSequence$1) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        int i;
        int i2;
        int i3;
        String strM;
        int i4;
        int i5;
        String str;
        ComposePausableCompositionException composePausableCompositionException = this.this$0;
        MutableObjectList mutableObjectList = composePausableCompositionException.instances;
        MutableIntList mutableIntList = composePausableCompositionException.operations;
        boolean z = this.label;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.L$0;
            i = 0;
            i2 = 0;
            i3 = 0;
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = this.I$2;
            i2 = this.I$1;
            i3 = this.I$0;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (i3 >= Math.min(composePausableCompositionException.lastOperation + 10, mutableIntList._size)) {
            return Unit.INSTANCE;
        }
        int i6 = i3 + 1;
        int i7 = mutableIntList.get(i3);
        switch (i7) {
            case 0:
                strM = "up";
                break;
            case 1:
                Object obj2 = mutableObjectList.get(i2);
                i2++;
                strM = "down " + obj2;
                break;
            case 2:
                strM = Fragment$5$$ExternalSyntheticOutline0.m(mutableIntList.get(i6), mutableIntList.get(i3 + 2), "remove ", ServerSentEventKt.SPACE);
                i6 = i3 + 3;
                break;
            case 3:
                int i8 = mutableIntList.get(i6);
                int i9 = mutableIntList.get(i3 + 2);
                int i10 = mutableIntList.get(i3 + 3);
                StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(i8, "move ", ServerSentEventKt.SPACE, i9, ServerSentEventKt.SPACE);
                sbM3m.append(i10);
                strM = sbM3m.toString();
                i6 = i3 + 4;
                break;
            case 4:
                strM = "clear";
                break;
            case 5:
                i4 = i3 + 2;
                int i11 = mutableIntList.get(i6);
                i5 = i2 + 1;
                str = "insertBottomUp " + i11 + ServerSentEventKt.SPACE + mutableObjectList.get(i2);
                int i12 = i4;
                strM = str;
                i6 = i12;
                i2 = i5;
                break;
            case 6:
                i4 = i3 + 2;
                int i13 = mutableIntList.get(i6);
                i5 = i2 + 1;
                str = "insertTopDown " + i13 + ServerSentEventKt.SPACE + mutableObjectList.get(i2);
                int i14 = i4;
                strM = str;
                i6 = i14;
                i2 = i5;
                break;
            case 7:
                Object obj3 = mutableObjectList.get(i2);
                obj3.getClass();
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, obj3);
                i2 += 2;
                strM = "apply " + ((Function2) obj3);
                break;
            case 8:
                strM = "reuse " + composePausableCompositionException.reused.get(i);
                i++;
                break;
            case 9:
                strM = "recompose pending";
                break;
            default:
                strM = IntIntPair$$ExternalSyntheticOutline0.m(i7, "unknown op: ");
                break;
        }
        this.L$0 = sequenceScope;
        this.I$0 = i6;
        this.I$1 = i2;
        this.I$2 = i;
        this.label = true;
        sequenceScope.yield(i3 + ": " + strM, this);
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }
}
