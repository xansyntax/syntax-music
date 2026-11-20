package androidx.datastore.core;

import com.metrolist.music.constants.MyTopFilter;
import com.metrolist.music.models.MediaMetadata;
import java.io.IOException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreImpl$data$1$5 extends SuspendLambda implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$data$1$5(DataStoreImpl dataStoreImpl, Continuation continuation) {
        super(3, continuation);
        this.$r8$classId = (byte) 0;
        this.this$0 = dataStoreImpl;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        byte b2 = 3;
        switch (b) {
            case 0:
                return new DataStoreImpl$data$1$5((DataStoreImpl) this.this$0, (Continuation) obj3).invokeSuspend(unit);
            case 1:
                ((Boolean) obj2).getClass();
                DataStoreImpl$data$1$5 dataStoreImpl$data$1$5 = new DataStoreImpl$data$1$5(b2, (Continuation) obj3, (byte) 1);
                dataStoreImpl$data$1$5.this$0 = (FileReadScope) obj;
                return dataStoreImpl$data$1$5.invokeSuspend(unit);
            case 2:
                boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                DataStoreImpl$data$1$5 dataStoreImpl$data$1$6 = new DataStoreImpl$data$1$5(b2, (Continuation) obj3, (byte) 2);
                dataStoreImpl$data$1$6.this$0 = (MediaMetadata) obj;
                dataStoreImpl$data$1$6.label = zBooleanValue;
                return dataStoreImpl$data$1$6.invokeSuspend(unit);
            default:
                boolean zBooleanValue2 = ((Boolean) obj2).booleanValue();
                DataStoreImpl$data$1$5 dataStoreImpl$data$1$7 = new DataStoreImpl$data$1$5(b2, (Continuation) obj3, b2);
                dataStoreImpl$data$1$7.this$0 = (MyTopFilter) obj;
                dataStoreImpl$data$1$7.label = zBooleanValue2;
                return dataStoreImpl$data$1$7.invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Continuation continuation = null;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    DataStoreImpl dataStoreImpl = (DataStoreImpl) this.this$0;
                    this.label = true;
                    if (dataStoreImpl.decrementCollector(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    FileReadScope fileReadScope = (FileReadScope) this.this$0;
                    this.label = true;
                    if (!fileReadScope.closed.get()) {
                        Object objRunFileDiagnosticsIfNotCorruption = FileStorageKt.runFileDiagnosticsIfNotCorruption(fileReadScope.file, new FileReadScope$readData$2(fileReadScope, continuation, (byte) 0), this);
                        return objRunFileDiagnosticsIfNotCorruption == coroutineSingletons ? coroutineSingletons : objRunFileDiagnosticsIfNotCorruption;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This scope has already been closed.");
                } else {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                }
                return null;
            case 2:
                MediaMetadata mediaMetadata = (MediaMetadata) this.this$0;
                boolean z3 = this.label;
                ResultKt.throwOnFailure(obj);
                return new Pair(mediaMetadata, Boolean.valueOf(z3));
            default:
                MyTopFilter myTopFilter = (MyTopFilter) this.this$0;
                boolean z4 = this.label;
                ResultKt.throwOnFailure(obj);
                return new Pair(myTopFilter, Boolean.valueOf(z4));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataStoreImpl$data$1$5(int i, Continuation continuation, byte b) {
        super(i, continuation);
        this.$r8$classId = b;
    }
}
