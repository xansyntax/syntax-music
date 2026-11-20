package com.metrolist.innertubex.cipher;

import coil3.RealImageLoader;
import coil3.compose.AsyncImagePainter;
import com.dokar.quickjs.QuickJs;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.metrolist.music.App;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QuickJsEngine {
    public static final Regex JS_IDENTIFIER = new Regex("[A-Za-z_$][A-Za-z0-9_$]*");
    public final MutexImpl mutex = new MutexImpl();
    public Runtime runtime;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Runtime {
        public final QuickJs js;
        public final ExecutorCoroutineDispatcher thread;

        public Runtime(QuickJs quickJs, ExecutorCoroutineDispatcher executorCoroutineDispatcher) {
            quickJs.getClass();
            executorCoroutineDispatcher.getClass();
            this.js = quickJs;
            this.thread = executorCoroutineDispatcher;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.QuickJsEngine$execute$1, reason: invalid class name */
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
            return QuickJsEngine.this.execute(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.QuickJsEngine$initialize$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00971 extends ContinuationImpl {
        public Mutex L$0;
        public int label;
        public /* synthetic */ Object result;

        public C00971(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QuickJsEngine.this.initialize(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.QuickJsEngine$withRuntime$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00981 extends ContinuationImpl {
        public SuspendLambda L$0;
        public Mutex L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00981(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QuickJsEngine.this.withRuntime(null, this);
        }
    }

    public final Object callFunction(String str, String str2, ContinuationImpl continuationImpl) {
        Continuation continuation = null;
        if (!JS_IDENTIFIER.matches(str)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Invalid JavaScript function name");
            return null;
        }
        if (str2.length() > 65536) {
            return null;
        }
        return withRuntime(new InnerTube$feedback$2(str, CharsKt.jsStringLiteral$com_github_MetrolistGroup_innertubex(str2), continuation, (byte) 10), continuationImpl);
    }

    public final Object dispose(ContinuationImpl continuationImpl) {
        Object objWithContext = AwaitKt.withContext(NonCancellable.INSTANCE, new AsyncImagePainter.AnonymousClass1(this, null, (byte) 10), continuationImpl);
        return objWithContext == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithContext : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object execute(String str, ContinuationImpl continuationImpl) {
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
        Continuation continuation = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 anonymousClass2 = new RealImageLoader.AnonymousClass2(str, continuation, (byte) 29);
            anonymousClass1.label = 1;
            Object objWithRuntime = withRuntime(anonymousClass2, anonymousClass1);
            Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithRuntime == obj2) {
                return obj2;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0061, code lost:
    
        if (kotlinx.coroutines.AwaitKt.withContext(r1, r3, r0) == r5) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object initialize(ContinuationImpl continuationImpl) throws Throwable {
        C00971 c00971;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        if (continuationImpl instanceof C00971) {
            c00971 = (C00971) continuationImpl;
            int i = c00971.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00971.label = i - Integer.MIN_VALUE;
            } else {
                c00971 = new C00971(continuationImpl);
            }
        } else {
            c00971 = new C00971(continuationImpl);
        }
        Object obj = c00971.result;
        int i2 = c00971.label;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.mutex;
                c00971.L$0 = mutex;
                c00971.label = 1;
                if (mutex.lock(c00971) != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mutex2 = c00971.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Unit unit = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return unit;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = c00971.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            if (this.runtime == null) {
                NonCancellable nonCancellable = NonCancellable.INSTANCE;
                App.C01391 c01391 = new App.C01391((Object) this, continuation, (byte) 12);
                c00971.L$0 = mutex;
                c00971.label = 2;
            }
            mutex2 = mutex;
            Unit unit2 = Unit.INSTANCE;
            mutex2.unlock(null);
            return unit2;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object withRuntime(Function2 function2, ContinuationImpl continuationImpl) throws Throwable {
        C00981 c00981;
        Object obj;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        if (continuationImpl instanceof C00981) {
            c00981 = (C00981) continuationImpl;
            int i = c00981.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00981.label = i - Integer.MIN_VALUE;
            } else {
                c00981 = new C00981(continuationImpl);
            }
        } else {
            c00981 = new C00981(continuationImpl);
        }
        Object objWithContext = c00981.result;
        int i2 = c00981.label;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithContext);
                c00981.L$0 = (SuspendLambda) function2;
                MutexImpl mutexImpl = this.mutex;
                c00981.L$1 = mutexImpl;
                c00981.label = 1;
                if (mutexImpl.lock(c00981) != coroutineSingletons) {
                    obj = function2;
                    mutex = mutexImpl;
                }
                return coroutineSingletons;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mutex2 = c00981.L$1;
                try {
                    ResultKt.throwOnFailure(objWithContext);
                    mutex2.unlock(null);
                    return objWithContext;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            mutex = c00981.L$1;
            Object obj2 = (Function2) c00981.L$0;
            ResultKt.throwOnFailure(objWithContext);
            obj = obj2;
            Runtime runtime = this.runtime;
            if (runtime == null) {
                throw new IllegalStateException("QuickJS not initialized");
            }
            ExecutorCoroutineDispatcher executorCoroutineDispatcher = runtime.thread;
            App.C01391 c01391 = new App.C01391(obj, runtime, continuation, (byte) 13);
            c00981.L$0 = null;
            c00981.L$1 = mutex;
            c00981.label = 2;
            objWithContext = AwaitKt.withContext(executorCoroutineDispatcher, c01391, c00981);
            if (objWithContext != coroutineSingletons) {
                mutex2 = mutex;
                mutex2.unlock(null);
                return objWithContext;
            }
            return coroutineSingletons;
        } catch (Throwable th3) {
            Mutex mutex3 = mutex;
            th = th3;
            mutex2 = mutex3;
            mutex2.unlock(null);
            throw th;
        }
    }
}
