package androidx.compose.foundation.relocation;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BringIntoViewRequesterImpl {
    public final MutableVector nodes = new MutableVector(new BringIntoViewRequesterNode[16]);

    /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int I$0;
        public int I$1;
        public Rect L$0;
        public Object[] L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BringIntoViewRequesterImpl.this.bringIntoView(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    /* JADX WARN: Code duplicated, block: B:18:0x0062 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0060 -> B:19:0x0063). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object bringIntoView(androidx.compose.ui.geometry.Rect r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.relocation.BringIntoViewRequesterImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 r0 = (androidx.compose.foundation.relocation.BringIntoViewRequesterImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 r0 = new androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2e
            int r7 = r0.I$1
            int r8 = r0.I$0
            java.lang.Object[] r1 = r0.L$1
            androidx.compose.ui.geometry.Rect r3 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r3
            goto L63
        L2e:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r7)
            r7 = 0
            return r7
        L35:
            kotlin.ResultKt.throwOnFailure(r9)
            androidx.compose.runtime.collection.MutableVector r7 = r7.nodes
            java.lang.Object[] r9 = r7.content
            int r7 = r7.size
            r1 = 0
            r6 = r9
            r9 = r8
            r8 = r1
            r1 = r6
        L43:
            if (r8 >= r7) goto L65
            r3 = r1[r8]
            androidx.compose.foundation.relocation.BringIntoViewRequesterNode r3 = (androidx.compose.foundation.relocation.BringIntoViewRequesterNode) r3
            androidx.compose.material3.SliderState$$ExternalSyntheticLambda0 r4 = new androidx.compose.material3.SliderState$$ExternalSyntheticLambda0
            r5 = 10
            r4.<init>(r5, r9)
            r0.L$0 = r9
            r0.L$1 = r1
            r0.I$0 = r8
            r0.I$1 = r7
            r0.label = r2
            java.lang.Object r3 = coil3.size.SizeKt.bringIntoView(r3, r4, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r3 != r4) goto L63
            return r4
        L63:
            int r8 = r8 + r2
            goto L43
        L65:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.relocation.BringIntoViewRequesterImpl.bringIntoView(androidx.compose.ui.geometry.Rect, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
