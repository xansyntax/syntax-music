package coil3.compose;

import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import coil3.size.Dimension;
import coil3.size.Size;
import coil3.size.SizeResolver;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ConstraintsSizeResolver implements SizeResolver, LayoutModifier {
    public ArrayList continuations;
    public long latestConstraints;

    /* JADX INFO: renamed from: coil3.compose.ConstraintsSizeResolver$size$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Ref$ObjectRef L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConstraintsSizeResolver.this.size(this);
        }
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo195measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        m853setConstraintsBRTryo0(j);
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(j);
        return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 23));
    }

    /* JADX INFO: renamed from: setConstraints-BRTryo0, reason: not valid java name */
    public final void m853setConstraintsBRTryo0(long j) {
        this.latestConstraints = j;
        if (Constraints.m787isZeroimpl(j)) {
            return;
        }
        ArrayList arrayList = this.continuations;
        if (arrayList.isEmpty()) {
            return;
        }
        this.continuations = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Continuation) obj).resumeWith(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // coil3.size.SizeResolver
    public final Object size(Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Ref$ObjectRef ref$ObjectRef;
        Throwable th;
        Dimension pixels;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1((ContinuationImpl) continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1((ContinuationImpl) continuation);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (Constraints.m787isZeroimpl(this.latestConstraints)) {
                Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                try {
                    anonymousClass1.L$0 = ref$ObjectRef2;
                    anonymousClass1.label = 1;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(anonymousClass1));
                    cancellableContinuationImpl.initCancellability();
                    ref$ObjectRef2.element = cancellableContinuationImpl;
                    this.continuations.add(cancellableContinuationImpl);
                    Object result = cancellableContinuationImpl.getResult();
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (result == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    ref$ObjectRef = ref$ObjectRef2;
                    ArrayList arrayList = this.continuations;
                    TypeIntrinsics.asMutableCollection(arrayList).remove(ref$ObjectRef.element);
                } catch (Throwable th2) {
                    ref$ObjectRef = ref$ObjectRef2;
                    th = th2;
                    ArrayList arrayList2 = this.continuations;
                    TypeIntrinsics.asMutableCollection(arrayList2).remove(ref$ObjectRef.element);
                    throw th;
                }
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ref$ObjectRef = anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList3 = this.continuations;
                TypeIntrinsics.asMutableCollection(arrayList3).remove(ref$ObjectRef.element);
            } catch (Throwable th3) {
                th = th3;
                ArrayList arrayList4 = this.continuations;
                TypeIntrinsics.asMutableCollection(arrayList4).remove(ref$ObjectRef.element);
                throw th;
            }
        }
        long j = this.latestConstraints;
        int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(j);
        Dimension pixels2 = Dimension.Undefined.INSTANCE;
        if (iM784getMaxWidthimpl != Integer.MAX_VALUE) {
            Dimension.Pixels.m859constructorimpl(iM784getMaxWidthimpl);
            pixels = new Dimension.Pixels(iM784getMaxWidthimpl);
        } else {
            pixels = pixels2;
        }
        int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j);
        if (iM783getMaxHeightimpl != Integer.MAX_VALUE) {
            Dimension.Pixels.m859constructorimpl(iM783getMaxHeightimpl);
            pixels2 = new Dimension.Pixels(iM783getMaxHeightimpl);
        }
        return new Size(pixels, pixels2);
    }
}
