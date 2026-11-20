package androidx.datastore.core;

import com.metrolist.music.discord.DiscordRpcManager;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.sync.Mutex;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreImpl$InitDataStore$doRun$initData$1$api$1 {
    public final /* synthetic */ Ref$ObjectRef $currentData;
    public final /* synthetic */ Ref$BooleanRef $initializationComplete;
    public final /* synthetic */ Mutex $updateLock;
    public final /* synthetic */ DataStoreImpl this$0;

    public DataStoreImpl$InitDataStore$doRun$initData$1$api$1(Mutex mutex, Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef ref$ObjectRef, DataStoreImpl dataStoreImpl) {
        this.$updateLock = mutex;
        this.$initializationComplete = ref$BooleanRef;
        this.$currentData = ref$ObjectRef;
        this.this$0 = dataStoreImpl;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00b0 A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:21:0x004e, B:35:0x00a8, B:37:0x00b0), top: B:52:0x004e }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object updateData(DiscordRpcManager.AnonymousClass4 anonymousClass4, ContinuationImpl continuationImpl) throws Throwable {
        DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1;
        Mutex mutex;
        Ref$BooleanRef ref$BooleanRef;
        Ref$ObjectRef ref$ObjectRef;
        DataStoreImpl dataStoreImpl;
        Function2 function2;
        Mutex mutex2;
        Mutex mutex3;
        Ref$ObjectRef ref$ObjectRef2;
        Object obj;
        if (continuationImpl instanceof DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) {
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 = (DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) continuationImpl;
            int i = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = i - Integer.MIN_VALUE;
            } else {
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 = new DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1(this, continuationImpl);
            }
        } else {
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 = new DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1(this, continuationImpl);
        }
        Object obj2 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.result;
        int i2 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj2);
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0 = anonymousClass4;
                mutex = this.$updateLock;
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1 = mutex;
                ref$BooleanRef = this.$initializationComplete;
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2 = ref$BooleanRef;
                ref$ObjectRef = this.$currentData;
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$3 = ref$ObjectRef;
                dataStoreImpl = this.this$0;
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$4 = dataStoreImpl;
                dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = 1;
                if (mutex.lock(dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) != coroutineSingletons) {
                }
                function2 = anonymousClass4;
                return coroutineSingletons;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    obj = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2;
                    ref$ObjectRef2 = (Ref$ObjectRef) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1;
                    mutex2 = (Mutex) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        ref$ObjectRef2.element = obj;
                        Object obj3 = ref$ObjectRef2.element;
                        mutex2.unlock(null);
                        return obj3;
                    } catch (Throwable th) {
                        th = th;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                dataStoreImpl = (DataStoreImpl) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2;
                ref$ObjectRef2 = (Ref$ObjectRef) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1;
                mutex3 = (Mutex) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj2);
                    if (!Intrinsics.areEqual(obj2, ref$ObjectRef2.element)) {
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0 = mutex3;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1 = ref$ObjectRef2;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2 = obj2;
                        dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = 3;
                        if (dataStoreImpl.writeData$datastore_core(obj2, false, dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) != coroutineSingletons) {
                            obj = obj2;
                            mutex2 = mutex3;
                            ref$ObjectRef2.element = obj;
                        }
                        function2 = anonymousClass4;
                        return coroutineSingletons;
                    }
                    mutex2 = mutex3;
                    Object obj4 = ref$ObjectRef2.element;
                    mutex2.unlock(null);
                    return obj4;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2 = mutex3;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            dataStoreImpl = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$4;
            Ref$ObjectRef ref$ObjectRef3 = dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$3;
            ref$BooleanRef = (Ref$BooleanRef) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2;
            Mutex mutex4 = (Mutex) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1;
            Function2 function3 = (Function2) dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0;
            ResultKt.throwOnFailure(obj2);
            ref$ObjectRef = ref$ObjectRef3;
            function2 = function3;
            mutex = mutex4;
            function2 = anonymousClass4;
            if (ref$BooleanRef.element) {
                throw new IllegalStateException("InitializerApi.updateData should not be called after initialization is complete.");
            }
            Object obj5 = ref$ObjectRef.element;
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0 = mutex;
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1 = ref$ObjectRef;
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2 = dataStoreImpl;
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$3 = null;
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$4 = null;
            dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = 2;
            Object objInvoke = function2.invoke(obj5, dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1);
            if (objInvoke != coroutineSingletons) {
                mutex3 = mutex;
                obj2 = objInvoke;
                ref$ObjectRef2 = ref$ObjectRef;
                if (!Intrinsics.areEqual(obj2, ref$ObjectRef2.element)) {
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$0 = mutex3;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$1 = ref$ObjectRef2;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.L$2 = obj2;
                    dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1.label = 3;
                    if (dataStoreImpl.writeData$datastore_core(obj2, false, dataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) != coroutineSingletons) {
                        obj = obj2;
                        mutex2 = mutex3;
                        ref$ObjectRef2.element = obj;
                    }
                } else {
                    mutex2 = mutex3;
                }
                Object obj6 = ref$ObjectRef2.element;
                mutex2.unlock(null);
                return obj6;
            }
            function2 = anonymousClass4;
            return coroutineSingletons;
        } catch (Throwable th3) {
            th = th3;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }
}
