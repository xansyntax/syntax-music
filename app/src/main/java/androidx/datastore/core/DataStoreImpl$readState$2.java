package androidx.datastore.core;

import androidx.room.ObservedTableVersions;
import com.metrolist.music.viewmodels.ArtistViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreImpl$readState$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public byte label;
    public final /* synthetic */ DataStoreImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataStoreImpl$readState$2(DataStoreImpl dataStoreImpl, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = dataStoreImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        DataStoreImpl dataStoreImpl = this.this$0;
        switch (b) {
            case 0:
                return new DataStoreImpl$readState$2(dataStoreImpl, continuation, (byte) 0);
            default:
                return new DataStoreImpl$readState$2(dataStoreImpl, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
        }
        return ((DataStoreImpl$readState$2) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
    
        if (r10.collect(r0, r9) == r4) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008e, code lost:
    
        if (r10 == r4) goto L40;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        DataStoreImpl dataStoreImpl = this.this$0;
        switch (b) {
            case 0:
                ObservedTableVersions observedTableVersions = dataStoreImpl.inMemoryCache;
                byte b2 = this.label;
                try {
                    if (b2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        if (observedTableVersions.getCurrentState() instanceof Final) {
                            return observedTableVersions.getCurrentState();
                        }
                        this.label = (byte) 1;
                        if (dataStoreImpl.readAndInitOrPropagateAndThrowFailure(this) != coroutineSingletons) {
                        }
                        return coroutineSingletons;
                    }
                    if (b2 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (b2 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return (State) obj;
                    this.label = (byte) 2;
                    obj = dataStoreImpl.readDataAndUpdateCache(false, this);
                } catch (Throwable th) {
                    return new ReadException(th, -1);
                }
                break;
            default:
                byte b3 = this.label;
                Unit unit = Unit.INSTANCE;
                if (b3 != 0) {
                    if (b3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (b3 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                Dispatcher dispatcher = dataStoreImpl.readAndInit;
                this.label = (byte) 1;
                Object objAwaitInternal = ((CompletableDeferredImpl) dispatcher.readyAsyncCalls).awaitInternal(this);
                if (objAwaitInternal != coroutineSingletons) {
                    objAwaitInternal = unit;
                }
                if (objAwaitInternal != coroutineSingletons) {
                }
                return coroutineSingletons;
                Flow flowBuffer$default = StateFlowKt.buffer$default(dataStoreImpl.getCoordinator().updateNotifications, -1);
                ArtistViewModel.AnonymousClass1.AnonymousClass2 anonymousClass2 = new ArtistViewModel.AnonymousClass1.AnonymousClass2((byte) 5, dataStoreImpl);
                this.label = (byte) 2;
                break;
        }
    }
}
