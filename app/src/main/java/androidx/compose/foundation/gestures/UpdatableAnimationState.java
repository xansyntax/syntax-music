package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Function;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class UpdatableAnimationState {
    public static final AnimationVector1D ZeroVector = new AnimationVector1D(CropImageView.DEFAULT_ASPECT_RATIO);
    public boolean isRunning;
    public long lastFrameTime = Long.MIN_VALUE;
    public AnimationVector1D lastVelocity = ZeroVector;
    public float value;
    public final VectorizedAnimationSpec vectorizedSpec;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public float F$0;
        public Function L$0;
        public Function0 L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UpdatableAnimationState.this.animateToZero(null, null, this);
        }
    }

    public UpdatableAnimationState(AnimationSpec animationSpec) {
        this.vectorizedSpec = animationSpec.vectorize(ArcSplineKt.FloatToVector);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007d A[Catch: all -> 0x003a, PHI: r0 r2 r3 r13
      0x007d: PHI (r0v16 kotlin.jvm.functions.Function1) = (r0v9 kotlin.jvm.functions.Function1), (r0v17 kotlin.jvm.functions.Function1) binds: [B:29:0x0075, B:37:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x007d: PHI (r2v5 kotlin.jvm.functions.Function0) = (r2v3 kotlin.jvm.functions.Function0), (r2v6 kotlin.jvm.functions.Function0) binds: [B:29:0x0075, B:37:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x007d: PHI (r3v4 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1) = 
      (r3v2 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
      (r3v5 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
     binds: [B:29:0x0075, B:37:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x007d: PHI (r13v1 float) = (r13v0 float), (r13v2 float) binds: [B:29:0x0075, B:37:0x00ac] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {all -> 0x003a, blocks: (B:13:0x0035, B:44:0x00d5, B:20:0x004b, B:36:0x00a7, B:30:0x007d, B:33:0x008b, B:38:0x00ae, B:41:0x00b9), top: B:49:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:32:0x008a  */
    /* JADX WARN: Code duplicated, block: B:33:0x008b A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:13:0x0035, B:44:0x00d5, B:20:0x004b, B:36:0x00a7, B:30:0x007d, B:33:0x008b, B:38:0x00ae, B:41:0x00b9), top: B:49:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a7 A[Catch: all -> 0x003a, PHI: r0 r2 r3 r13
      0x00a7: PHI (r0v17 kotlin.jvm.functions.Function1) = (r0v16 kotlin.jvm.functions.Function1), (r0v20 kotlin.jvm.functions.Function1) binds: [B:34:0x00a4, B:21:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x00a7: PHI (r2v6 kotlin.jvm.functions.Function0) = (r2v5 kotlin.jvm.functions.Function0), (r2v8 kotlin.jvm.functions.Function0) binds: [B:34:0x00a4, B:21:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x00a7: PHI (r3v5 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1) = 
      (r3v4 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
      (r3v7 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
     binds: [B:34:0x00a4, B:21:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x00a7: PHI (r13v2 float) = (r13v1 float), (r13v4 float) binds: [B:34:0x00a4, B:21:0x004e] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x003a, blocks: (B:13:0x0035, B:44:0x00d5, B:20:0x004b, B:36:0x00a7, B:30:0x007d, B:33:0x008b, B:38:0x00ae, B:41:0x00b9), top: B:49:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ae A[Catch: all -> 0x003a, PHI: r0 r2 r3
      0x00ae: PHI (r0v12 kotlin.jvm.functions.Function1) = (r0v16 kotlin.jvm.functions.Function1), (r0v17 kotlin.jvm.functions.Function1) binds: [B:32:0x008a, B:37:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x00ae: PHI (r2v4 kotlin.jvm.functions.Function0) = (r2v5 kotlin.jvm.functions.Function0), (r2v6 kotlin.jvm.functions.Function0) binds: [B:32:0x008a, B:37:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x00ae: PHI (r3v3 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1) = 
      (r3v4 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
      (r3v5 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
     binds: [B:32:0x008a, B:37:0x00ac] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x003a, blocks: (B:13:0x0035, B:44:0x00d5, B:20:0x004b, B:36:0x00a7, B:30:0x007d, B:33:0x008b, B:38:0x00ae, B:41:0x00b9), top: B:49:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b9 A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:13:0x0035, B:44:0x00d5, B:20:0x004b, B:36:0x00a7, B:30:0x007d, B:33:0x008b, B:38:0x00ae, B:41:0x00b9), top: B:49:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00a4 -> B:36:0x00a7). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object animateToZero(coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0 r17, androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0 r18, kotlin.coroutines.jvm.internal.ContinuationImpl r19) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.UpdatableAnimationState.animateToZero(coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0, androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
