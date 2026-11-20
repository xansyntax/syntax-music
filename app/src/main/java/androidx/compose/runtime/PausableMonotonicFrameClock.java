package androidx.compose.runtime;

import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PausableMonotonicFrameClock implements MonotonicFrameClock {
    public final MonotonicFrameClock frameClock;
    public final Latch latch = new Latch();

    /* JADX INFO: renamed from: androidx.compose.runtime.PausableMonotonicFrameClock$withFrameNanos$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Function1 L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PausableMonotonicFrameClock.this.withFrameNanos(null, this);
        }
    }

    public PausableMonotonicFrameClock(MonotonicFrameClock monotonicFrameClock) {
        this.frameClock = monotonicFrameClock;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return function2.invoke(obj, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return StringsKt__IndentKt.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return StringsKt__IndentKt.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return StringsKt__IndentKt.plus(this, coroutineContext);
    }

    public final void resume() {
        boolean z;
        Latch latch = this.latch;
        synchronized (latch.lock) {
            try {
                synchronized (latch.lock) {
                    z = latch._isOpen;
                }
                if (z) {
                    return;
                }
                ArrayList arrayList = (ArrayList) latch.awaiters;
                latch.awaiters = (ArrayList) latch.spareList;
                latch.spareList = arrayList;
                latch._isOpen = true;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((Continuation) arrayList.get(i)).resumeWith(Unit.INSTANCE);
                }
                arrayList.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.runtime.MonotonicFrameClock
    public final Object withFrameNanos(Function1 function1, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        boolean z;
        Object result;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Latch latch = this.latch;
            anonymousClass1.L$0 = function1;
            anonymousClass1.label = 1;
            synchronized (latch.lock) {
                z = latch._isOpen;
            }
            if (z) {
                result = Unit.INSTANCE;
            } else {
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(anonymousClass1));
                cancellableContinuationImpl.initCancellability();
                synchronized (latch.lock) {
                    ((ArrayList) latch.awaiters).add(cancellableContinuationImpl);
                }
                cancellableContinuationImpl.invokeOnCancellation(new Latch$await$2$2(latch, cancellableContinuationImpl, (byte) 0));
                result = cancellableContinuationImpl.getResult();
                if (result != coroutineSingletons) {
                    result = Unit.INSTANCE;
                }
            }
            if (result != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        function1 = anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj);
        MonotonicFrameClock monotonicFrameClock = this.frameClock;
        anonymousClass1.L$0 = null;
        anonymousClass1.label = 2;
        Object objWithFrameNanos = monotonicFrameClock.withFrameNanos(function1, anonymousClass1);
        return objWithFrameNanos == coroutineSingletons ? coroutineSingletons : objWithFrameNanos;
    }
}
