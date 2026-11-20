package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Density;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PressGestureScopeImpl implements Density {
    public final /* synthetic */ Density $$delegate_0;
    public boolean isCanceled;
    public boolean isReleased;
    public final MutexImpl mutex = new MutexImpl();

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PressGestureScopeImpl.this.reset(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00211 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C00211(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PressGestureScopeImpl.this.tryAwaitRelease(this);
        }
    }

    public PressGestureScopeImpl(Density density) {
        this.$$delegate_0 = density;
    }

    public final void cancel() {
        this.isCanceled = true;
        MutexImpl mutexImpl = this.mutex;
        if (mutexImpl.isLocked()) {
            mutexImpl.unlock(null);
        }
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    public final void release() {
        this.isReleased = true;
        MutexImpl mutexImpl = this.mutex;
        if (mutexImpl.isLocked()) {
            mutexImpl.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object reset(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            anonymousClass1.label = 1;
            Object objLock = this.mutex.lock(anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objLock == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        this.isReleased = false;
        this.isCanceled = false;
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
    public final int mo74roundToPxR2X_6o(long j) {
        return this.$$delegate_0.mo74roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
    public final int mo75roundToPx0680j_4(float f) {
        return this.$$delegate_0.mo75roundToPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
    public final float mo76toDpGaN1DYA(long j) {
        return this.$$delegate_0.mo76toDpGaN1DYA(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
    public final float mo77toDpu2uoSUM(float f) {
        return this.$$delegate_0.mo77toDpu2uoSUM(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public final long mo79toDpSizekrfVVM(long j) {
        return this.$$delegate_0.mo79toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
    public final float mo80toPxR2X_6o(long j) {
        return this.$$delegate_0.mo80toPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
    public final float mo81toPx0680j_4(float f) {
        return this.$$delegate_0.mo81toPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public final long mo82toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.mo82toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
    public final long mo83toSp0xMU5do(float f) {
        return this.$$delegate_0.mo83toSp0xMU5do(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public final long mo84toSpkPz2Gy4(float f) {
        return this.$$delegate_0.mo84toSpkPz2Gy4(f);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object tryAwaitRelease(ContinuationImpl continuationImpl) {
        C00211 c00211;
        if (continuationImpl instanceof C00211) {
            c00211 = (C00211) continuationImpl;
            int i = c00211.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00211.label = i - Integer.MIN_VALUE;
            } else {
                c00211 = new C00211(continuationImpl);
            }
        } else {
            c00211 = new C00211(continuationImpl);
        }
        Object obj = c00211.result;
        int i2 = c00211.label;
        MutexImpl mutexImpl = this.mutex;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.isReleased && !this.isCanceled) {
                c00211.label = 1;
                Object objLock = mutexImpl.lock(c00211);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objLock == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Boolean.valueOf(this.isReleased);
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        mutexImpl.unlock(null);
        return Boolean.valueOf(this.isReleased);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
    public final float mo78toDpu2uoSUM(int i) {
        return this.$$delegate_0.mo78toDpu2uoSUM(i);
    }
}
