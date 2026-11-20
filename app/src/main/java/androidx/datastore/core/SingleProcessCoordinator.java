package androidx.datastore.core;

import com.metrolist.music.App$Companion$forgetAccount$2;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SingleProcessCoordinator {
    public final MutexImpl mutex = new MutexImpl();
    public final AtomicInt version = new AtomicInt((byte) 0);
    public final SafeFlow updateNotifications = new SafeFlow((byte) 0, new App$Companion$forgetAccount$2(2, null, 6));

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessCoordinator$lock$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public MutexImpl L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SingleProcessCoordinator.this.lock(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessCoordinator$tryLock$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00451 extends ContinuationImpl {
        public MutexImpl L$0;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C00451(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SingleProcessCoordinator.this.tryLock(null, this);
        }
    }

    public SingleProcessCoordinator(String str) {
    }

    public final Integer getVersion() {
        return new Integer(((AtomicInteger) this.version.delegate).get());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
    
        if (r8 == r5) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.datastore.core.SingleProcessCoordinator] */
    /* JADX WARN: Type inference failed for: r6v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object lock(Function1 function1, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        MutexImpl mutexImpl;
        MutexImpl mutexImpl2;
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
        Object objInvoke = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objInvoke);
                anonymousClass1.L$0 = function1;
                mutexImpl = this.mutex;
                anonymousClass1.L$1 = mutexImpl;
                anonymousClass1.label = 1;
                if (mutexImpl.lock(anonymousClass1) != coroutineSingletons) {
                }
                mutexImpl2 = mutexImpl;
                return coroutineSingletons;
            }
            if (i2 == 1) {
                MutexImpl mutexImpl3 = anonymousClass1.L$1;
                function1 = (Function1) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objInvoke);
                mutexImpl2 = mutexImpl3;
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                Mutex mutex = (Mutex) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objInvoke);
                this = mutex;
            }
            this.unlock(null);
            return objInvoke;
            mutexImpl2 = mutexImpl;
            anonymousClass1.L$0 = mutexImpl2;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 2;
            objInvoke = function1.invoke(anonymousClass1);
            this = mutexImpl2;
        } catch (Throwable th) {
            this.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0054  */
    /* JADX WARN: Code duplicated, block: B:30:0x005f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object tryLock(Function2 function2, ContinuationImpl continuationImpl) {
        C00451 c00451;
        MutexImpl mutexImpl;
        boolean z;
        Throwable th;
        if (continuationImpl instanceof C00451) {
            c00451 = (C00451) continuationImpl;
            int i = c00451.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00451.label = i - Integer.MIN_VALUE;
            } else {
                c00451 = new C00451(continuationImpl);
            }
        } else {
            c00451 = new C00451(continuationImpl);
        }
        Object obj = c00451.result;
        int i2 = c00451.label;
        if (i2 != 0) {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            z = c00451.Z$0;
            mutexImpl = c00451.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                if (z) {
                    mutexImpl.unlock(null);
                }
                return obj;
            } catch (Throwable th2) {
                th = th2;
                if (z) {
                    mutexImpl.unlock(null);
                }
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        MutexImpl mutexImpl2 = this.mutex;
        boolean zTryLock = mutexImpl2.tryLock();
        try {
            Object objValueOf = Boolean.valueOf(zTryLock);
            c00451.L$0 = mutexImpl2;
            c00451.Z$0 = zTryLock;
            c00451.label = 1;
            Object objInvoke = function2.invoke(objValueOf, c00451);
            Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objInvoke == obj2) {
                return obj2;
            }
            mutexImpl = mutexImpl2;
            z = zTryLock;
            obj = objInvoke;
            if (z) {
                mutexImpl.unlock(null);
            }
            return obj;
        } catch (Throwable th3) {
            mutexImpl = mutexImpl2;
            z = zTryLock;
            th = th3;
            if (z) {
                mutexImpl.unlock(null);
            }
            throw th;
        }
    }
}
