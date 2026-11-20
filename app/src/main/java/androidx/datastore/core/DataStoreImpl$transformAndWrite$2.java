package androidx.datastore.core;

import com.metrolist.music.App;
import java.io.Serializable;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.AwaitKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreImpl$transformAndWrite$2 extends SuspendLambda implements Function1 {
    public final /* synthetic */ Object $callerContext;
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object $transform;
    public Object L$0;
    public byte label;
    public final /* synthetic */ DataStoreImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$transformAndWrite$2(DataStoreImpl dataStoreImpl, CoroutineContext coroutineContext, Function2 function2, Continuation continuation) {
        super(1, continuation);
        this.this$0 = dataStoreImpl;
        this.$callerContext = coroutineContext;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj = this.$transform;
        DataStoreImpl dataStoreImpl = this.this$0;
        Object obj2 = this.$callerContext;
        switch (b) {
            case 0:
                return new DataStoreImpl$transformAndWrite$2(dataStoreImpl, (CoroutineContext) obj2, (Function2) obj, continuation);
            default:
                return new DataStoreImpl$transformAndWrite$2((Ref$ObjectRef) obj2, dataStoreImpl, (Ref$IntRef) obj, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = (Continuation) obj;
        switch (b) {
            case 0:
                break;
        }
        return ((DataStoreImpl$transformAndWrite$2) create(continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:62:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Data data;
        Object obj2;
        int iHashCode;
        Ref$ObjectRef ref$ObjectRef;
        Ref$IntRef ref$IntRef;
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        DataStoreImpl dataStoreImpl = this.this$0;
        int i = 3;
        Object obj3 = this.$callerContext;
        Object obj4 = this.$transform;
        byte b2 = 1;
        byte b3 = 2;
        Continuation continuation = null;
        switch (b) {
            case 0:
                byte b4 = this.label;
                if (b4 != 0) {
                    if (b4 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else if (b4 == 2) {
                        data = (Data) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        obj2 = data.value;
                        if (obj2 != null) {
                            iHashCode = obj2.hashCode();
                        } else {
                            iHashCode = 0;
                        }
                        if (iHashCode != data.hashCode) {
                            if (!Intrinsics.areEqual(data.value, obj)) {
                                this.L$0 = obj;
                                this.label = (byte) 3;
                                if (dataStoreImpl.writeData$datastore_core(obj, true, this) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            }
                            return obj;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Data in DataStore was mutated but DataStore is only compatible with Immutable types.");
                    } else {
                        if (b4 == 3) {
                            Object obj5 = this.L$0;
                            ResultKt.throwOnFailure(obj);
                            return obj5;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    }
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                this.label = (byte) 1;
                obj = dataStoreImpl.readDataOrHandleCorruption(true, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
                data = (Data) obj;
                App.C01391 c01391 = new App.C01391((Function2) obj4, data, continuation, b3);
                this.L$0 = data;
                this.label = (byte) 2;
                obj = AwaitKt.withContext((CoroutineContext) obj3, c01391, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
                obj2 = data.value;
                if (obj2 != null) {
                    iHashCode = obj2.hashCode();
                } else {
                    iHashCode = 0;
                }
                if (iHashCode != data.hashCode) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Data in DataStore was mutated but DataStore is only compatible with Immutable types.");
                    return null;
                }
                if (!Intrinsics.areEqual(data.value, obj)) {
                    this.L$0 = obj;
                    this.label = (byte) 3;
                    if (dataStoreImpl.writeData$datastore_core(obj, true, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return obj;
            default:
                Ref$IntRef ref$IntRef2 = (Ref$IntRef) obj4;
                Ref$ObjectRef ref$ObjectRef2 = (Ref$ObjectRef) obj3;
                byte b5 = this.label;
                try {
                    if (b5 != 0) {
                        if (b5 == 1) {
                            ref$ObjectRef = (Ref$ObjectRef) ((Serializable) this.L$0);
                            ResultKt.throwOnFailure(obj);
                        } else {
                            if (b5 != 2) {
                                if (b5 != 3) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                    return null;
                                }
                                ref$IntRef2 = (Ref$IntRef) ((Serializable) this.L$0);
                                ResultKt.throwOnFailure(obj);
                                ref$IntRef2.element = ((Number) obj).intValue();
                                return Unit.INSTANCE;
                            }
                            ref$IntRef = (Ref$IntRef) ((Serializable) this.L$0);
                            ResultKt.throwOnFailure(obj);
                        }
                        ref$IntRef.element = ((Number) obj).intValue();
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = ref$ObjectRef2;
                    this.label = (byte) 1;
                    obj = ((FileStorageConnection) dataStoreImpl.storageConnectionDelegate.getValue()).readScope(new DataStoreImpl$data$1$5(i, continuation, b2), this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    ref$ObjectRef = ref$ObjectRef2;
                    ref$ObjectRef.element = obj;
                    SingleProcessCoordinator coordinator = dataStoreImpl.getCoordinator();
                    this.L$0 = ref$IntRef2;
                    this.label = (byte) 2;
                    obj = coordinator.getVersion();
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    ref$IntRef = ref$IntRef2;
                    ref$IntRef.element = ((Number) obj).intValue();
                    return Unit.INSTANCE;
                } catch (CorruptionException unused) {
                    Object obj6 = ref$ObjectRef2.element;
                    this.L$0 = ref$IntRef2;
                    this.label = (byte) 3;
                    obj = dataStoreImpl.writeData$datastore_core(obj6, true, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$transformAndWrite$2(Ref$ObjectRef ref$ObjectRef, DataStoreImpl dataStoreImpl, Ref$IntRef ref$IntRef, Continuation continuation) {
        super(1, continuation);
        this.$callerContext = ref$ObjectRef;
        this.this$0 = dataStoreImpl;
        this.$transform = ref$IntRef;
    }
}
