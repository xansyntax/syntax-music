package androidx.datastore.core;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreImpl$InitDataStore$doRun$initData$1 extends SuspendLambda implements Function1 {
    public int I$0;
    public Object L$0;
    public Serializable L$1;
    public Object L$2;
    public Object L$3;
    public Iterator L$4;
    public byte label;
    public final /* synthetic */ DataStoreImpl this$0;
    public final /* synthetic */ Dispatcher this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$InitDataStore$doRun$initData$1(DataStoreImpl dataStoreImpl, Dispatcher dispatcher, Continuation continuation) {
        super(1, continuation);
        this.this$0 = dataStoreImpl;
        this.this$1 = dispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new DataStoreImpl$InitDataStore$doRun$initData$1(this.this$0, this.this$1, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((DataStoreImpl$InitDataStore$doRun$initData$1) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:31:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:40:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:49:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:? A[LOOP:0: B:21:0x009f->B:51:?, LOOP_END, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Mutex mutexImpl;
        Ref$BooleanRef ref$BooleanRef;
        Ref$ObjectRef ref$ObjectRef;
        Ref$ObjectRef ref$ObjectRef2;
        Mutex mutex;
        Iterator it;
        Mutex mutex2;
        Ref$BooleanRef ref$BooleanRef2;
        Ref$ObjectRef ref$ObjectRef3;
        DataStoreImpl$InitDataStore$doRun$initData$1$api$1 dataStoreImpl$InitDataStore$doRun$initData$1$api$1;
        Ref$ObjectRef ref$ObjectRef4;
        Ref$BooleanRef ref$BooleanRef3;
        Function2 function2;
        Object obj2;
        int iHashCode;
        Integer version;
        Object obj3;
        byte b = this.label;
        Dispatcher dispatcher = this.this$1;
        DataStoreImpl dataStoreImpl = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            mutexImpl = new MutexImpl();
            ref$BooleanRef = new Ref$BooleanRef();
            ref$ObjectRef = new Ref$ObjectRef();
            this.L$0 = mutexImpl;
            this.L$1 = ref$BooleanRef;
            this.L$2 = ref$ObjectRef;
            this.L$3 = ref$ObjectRef;
            this.label = (byte) 1;
            obj = dataStoreImpl.readDataOrHandleCorruption(true, this);
            if (obj != coroutineSingletons) {
                ref$ObjectRef2 = ref$ObjectRef;
            }
            return coroutineSingletons;
        }
        if (b == 1) {
            ref$ObjectRef = (Ref$ObjectRef) this.L$3;
            ref$ObjectRef2 = (Ref$ObjectRef) this.L$2;
            ref$BooleanRef = (Ref$BooleanRef) this.L$1;
            mutexImpl = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (b == 2) {
                it = this.L$4;
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1 = (DataStoreImpl$InitDataStore$doRun$initData$1$api$1) this.L$3;
                ref$ObjectRef3 = (Ref$ObjectRef) this.L$2;
                ref$BooleanRef2 = (Ref$BooleanRef) this.L$1;
                mutex2 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                while (it.hasNext()) {
                    function2 = (Function2) it.next();
                    this.L$0 = mutex2;
                    this.L$1 = ref$BooleanRef2;
                    this.L$2 = ref$ObjectRef3;
                    this.L$3 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1;
                    this.L$4 = it;
                    this.label = (byte) 2;
                    if (function2.invoke(dataStoreImpl$InitDataStore$doRun$initData$1$api$1, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                ref$ObjectRef2 = ref$ObjectRef3;
                ref$BooleanRef = ref$BooleanRef2;
                mutex = mutex2;
                dispatcher.runningAsyncCalls = null;
                this.L$0 = ref$BooleanRef;
                this.L$1 = ref$ObjectRef2;
                this.L$2 = mutex;
                this.L$3 = null;
                this.L$4 = null;
                this.label = (byte) 3;
                if (mutex.lock(this) != coroutineSingletons) {
                    ref$ObjectRef4 = ref$ObjectRef2;
                    ref$BooleanRef3 = ref$BooleanRef;
                    ref$BooleanRef3.element = true;
                    mutex.unlock(null);
                    obj2 = ref$ObjectRef4.element;
                    if (obj2 != null) {
                        iHashCode = obj2.hashCode();
                    } else {
                        iHashCode = 0;
                    }
                    SingleProcessCoordinator coordinator = dataStoreImpl.getCoordinator();
                    this.L$0 = obj2;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.I$0 = iHashCode;
                    this.label = (byte) 4;
                    version = coordinator.getVersion();
                    if (version != coroutineSingletons) {
                        obj = version;
                        obj3 = obj2;
                    }
                }
                return coroutineSingletons;
            }
            if (b == 3) {
                mutex = (Mutex) this.L$2;
                ref$ObjectRef4 = (Ref$ObjectRef) this.L$1;
                ref$BooleanRef3 = (Ref$BooleanRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                try {
                    ref$BooleanRef3.element = true;
                    mutex.unlock(null);
                    obj2 = ref$ObjectRef4.element;
                    if (obj2 != null) {
                        iHashCode = obj2.hashCode();
                    } else {
                        iHashCode = 0;
                    }
                    SingleProcessCoordinator coordinator2 = dataStoreImpl.getCoordinator();
                    this.L$0 = obj2;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.I$0 = iHashCode;
                    this.label = (byte) 4;
                    version = coordinator2.getVersion();
                    if (version != coroutineSingletons) {
                        obj = version;
                        obj3 = obj2;
                    }
                    return coroutineSingletons;
                } catch (Throwable th) {
                    mutex.unlock(null);
                    throw th;
                }
            }
            if (b != 4) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            iHashCode = this.I$0;
            obj3 = this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return new Data(iHashCode, ((Number) obj).intValue(), obj3);
        ref$ObjectRef.element = ((Data) obj).value;
        DataStoreImpl$InitDataStore$doRun$initData$1$api$1 dataStoreImpl$InitDataStore$doRun$initData$1$api$2 = new DataStoreImpl$InitDataStore$doRun$initData$1$api$1(mutexImpl, ref$BooleanRef, ref$ObjectRef2, dataStoreImpl);
        List list = (List) dispatcher.runningAsyncCalls;
        if (list != null) {
            it = list.iterator();
            mutex2 = mutexImpl;
            ref$BooleanRef2 = ref$BooleanRef;
            ref$ObjectRef3 = ref$ObjectRef2;
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1 = dataStoreImpl$InitDataStore$doRun$initData$1$api$2;
            while (it.hasNext()) {
                function2 = (Function2) it.next();
                this.L$0 = mutex2;
                this.L$1 = ref$BooleanRef2;
                this.L$2 = ref$ObjectRef3;
                this.L$3 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1;
                this.L$4 = it;
                this.label = (byte) 2;
                if (function2.invoke(dataStoreImpl$InitDataStore$doRun$initData$1$api$1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            ref$ObjectRef2 = ref$ObjectRef3;
            ref$BooleanRef = ref$BooleanRef2;
            mutex = mutex2;
        } else {
            mutex = mutexImpl;
        }
        dispatcher.runningAsyncCalls = null;
        this.L$0 = ref$BooleanRef;
        this.L$1 = ref$ObjectRef2;
        this.L$2 = mutex;
        this.L$3 = null;
        this.L$4 = null;
        this.label = (byte) 3;
        if (mutex.lock(this) != coroutineSingletons) {
            ref$ObjectRef4 = ref$ObjectRef2;
            ref$BooleanRef3 = ref$BooleanRef;
            ref$BooleanRef3.element = true;
            mutex.unlock(null);
            obj2 = ref$ObjectRef4.element;
            if (obj2 != null) {
                iHashCode = obj2.hashCode();
            } else {
                iHashCode = 0;
            }
            SingleProcessCoordinator coordinator3 = dataStoreImpl.getCoordinator();
            this.L$0 = obj2;
            this.L$1 = null;
            this.L$2 = null;
            this.I$0 = iHashCode;
            this.label = (byte) 4;
            version = coordinator3.getVersion();
            if (version != coroutineSingletons) {
                obj = version;
                obj3 = obj2;
                return new Data(iHashCode, ((Number) obj).intValue(), obj3);
            }
        }
        return coroutineSingletons;
    }
}
