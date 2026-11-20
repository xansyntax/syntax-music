package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SnackbarHostState {
    public final MutexImpl mutex = new MutexImpl();
    public final ParcelableSnapshotMutableState currentSnackbarData$delegate = Stack.mutableStateOf$default(null);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SnackbarDataImpl {
        public final CancellableContinuationImpl continuation;
        public final SnackbarVisualsImpl visuals;

        public SnackbarDataImpl(SnackbarVisualsImpl snackbarVisualsImpl, CancellableContinuationImpl cancellableContinuationImpl) {
            this.visuals = snackbarVisualsImpl;
            this.continuation = cancellableContinuationImpl;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && SnackbarDataImpl.class == obj.getClass()) {
                SnackbarDataImpl snackbarDataImpl = (SnackbarDataImpl) obj;
                return Intrinsics.areEqual(this.visuals, snackbarDataImpl.visuals) && this.continuation == snackbarDataImpl.continuation;
            }
            return false;
        }

        public final int hashCode() {
            return this.continuation.hashCode() + (this.visuals.hashCode() * 31);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SnackbarVisualsImpl {
        public final String actionLabel;
        public final SnackbarDuration duration;
        public final String message;

        public SnackbarVisualsImpl(String str, String str2, SnackbarDuration snackbarDuration) {
            this.message = str;
            this.actionLabel = str2;
            this.duration = snackbarDuration;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SnackbarVisualsImpl.class != obj.getClass()) {
                return false;
            }
            SnackbarVisualsImpl snackbarVisualsImpl = (SnackbarVisualsImpl) obj;
            return Intrinsics.areEqual(this.message, snackbarVisualsImpl.message) && Intrinsics.areEqual(this.actionLabel, snackbarVisualsImpl.actionLabel) && this.duration == snackbarVisualsImpl.duration;
        }

        public final int hashCode() {
            int iHashCode = this.message.hashCode() * 31;
            String str = this.actionLabel;
            return this.duration.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m((iHashCode + (str != null ? str.hashCode() : 0)) * 31, false, 31);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SnackbarHostState$showSnackbar$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends ContinuationImpl {
        public SnackbarVisualsImpl L$0;
        public Mutex L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass2(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnackbarHostState.this.showSnackbar(null, this);
        }
    }

    public static Object showSnackbar$default(SnackbarHostState snackbarHostState, String str, String str2, SuspendLambda suspendLambda, int i) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        int i2 = i & 8;
        SnackbarDuration snackbarDuration = SnackbarDuration.Short;
        if (i2 != 0 && str2 != null) {
            snackbarDuration = SnackbarDuration.Indefinite;
        }
        snackbarHostState.getClass();
        return snackbarHostState.showSnackbar(new SnackbarVisualsImpl(str, str2, snackbarDuration), suspendLambda);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
    
        if (r9 == r6) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [androidx.compose.material3.SnackbarHostState] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r7v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object showSnackbar(SnackbarVisualsImpl snackbarVisualsImpl, ContinuationImpl continuationImpl) {
        AnonymousClass2 anonymousClass2;
        MutexImpl mutexImpl;
        Mutex mutex;
        if (continuationImpl instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuationImpl;
            int i = anonymousClass2.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuationImpl);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(continuationImpl);
        }
        Object result = anonymousClass2.result;
        int i2 = anonymousClass2.label;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.currentSnackbarData$delegate;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(result);
                    anonymousClass2.L$0 = snackbarVisualsImpl;
                    mutexImpl = this.mutex;
                    anonymousClass2.L$1 = mutexImpl;
                    anonymousClass2.label = 1;
                    if (mutexImpl.lock(anonymousClass2) != coroutineSingletons) {
                    }
                    mutex = mutexImpl;
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    Mutex mutex2 = anonymousClass2.L$1;
                    snackbarVisualsImpl = anonymousClass2.L$0;
                    ResultKt.throwOnFailure(result);
                    mutex = mutex2;
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Mutex mutex3 = anonymousClass2.L$1;
                    ResultKt.throwOnFailure(result);
                    this = mutex3;
                }
                parcelableSnapshotMutableState.setValue(null);
                this.unlock(null);
                return result;
                mutex = mutexImpl;
                anonymousClass2.L$0 = snackbarVisualsImpl;
                anonymousClass2.L$1 = mutex;
                anonymousClass2.label = 2;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(anonymousClass2));
                cancellableContinuationImpl.initCancellability();
                parcelableSnapshotMutableState.setValue(new SnackbarDataImpl(snackbarVisualsImpl, cancellableContinuationImpl));
                result = cancellableContinuationImpl.getResult();
                this = mutex;
            } catch (Throwable th) {
                parcelableSnapshotMutableState.setValue(null);
                throw th;
            }
        } catch (Throwable th2) {
            this.unlock(null);
            throw th2;
        }
    }
}
