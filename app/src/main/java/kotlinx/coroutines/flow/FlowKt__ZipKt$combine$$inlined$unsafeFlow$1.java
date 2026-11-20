package kotlinx.coroutines.flow;

import com.metrolist.music.utils.DataStoreKt$rememberPreference$lambda$0$$inlined$map$1$1;
import com.metrolist.music.viewmodels.LocalSearchViewModel$result$lambda$1$$inlined$map$2$1;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.flow.internal.CombineKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$1 implements Flow {
    public final /* synthetic */ Object $flow$inlined;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Flow $this_combine$inlined;
    public final /* synthetic */ Object $transform$inlined;

    public /* synthetic */ FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(Flow flow, Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.$this_combine$inlined = flow;
        this.$flow$inlined = obj;
        this.$transform$inlined = obj2;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0064  */
    /* JADX WARN: Code duplicated, block: B:9:0x0026  */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) throws Throwable {
        DataStoreKt$rememberPreference$lambda$0$$inlined$map$1$1 dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$1;
        LocalSearchViewModel$result$lambda$1$$inlined$map$2$1 localSearchViewModel$result$lambda$1$$inlined$map$2$1;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj = this.$transform$inlined;
        Object obj2 = this.$flow$inlined;
        Flow flow = this.$this_combine$inlined;
        Continuation continuation2 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                Object objCombineInternal = CombineKt.combineInternal(continuation, new FlowKt__ZipKt$combine$1$1((Function) obj, continuation2, (byte) 0), flowCollector, new Flow[]{flow, (Flow) obj2});
                return objCombineInternal == coroutineSingletons ? objCombineInternal : unit;
            case 1:
                if (continuation instanceof DataStoreKt$rememberPreference$lambda$0$$inlined$map$1$1) {
                    dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$1 = (DataStoreKt$rememberPreference$lambda$0$$inlined$map$1$1) continuation;
                    int i = dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$1.label = i - Integer.MIN_VALUE;
                    } else {
                        dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$1 = new DataStoreKt$rememberPreference$lambda$0$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$1 = new DataStoreKt$rememberPreference$lambda$0$$inlined$map$1$1(this, continuation);
                }
                Object obj3 = dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$1.result;
                int i2 = dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj3);
                    FlowKt__LimitKt$take$2$1 flowKt__LimitKt$take$2$1 = new FlowKt__LimitKt$take$2$1(flowCollector, obj2, obj, (byte) 6);
                    dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$1.label = 1;
                    return flow.collect(flowKt__LimitKt$take$2$1, dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(obj3);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                if (continuation instanceof LocalSearchViewModel$result$lambda$1$$inlined$map$2$1) {
                    localSearchViewModel$result$lambda$1$$inlined$map$2$1 = (LocalSearchViewModel$result$lambda$1$$inlined$map$2$1) continuation;
                    int i3 = localSearchViewModel$result$lambda$1$$inlined$map$2$1.label;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        localSearchViewModel$result$lambda$1$$inlined$map$2$1.label = i3 - Integer.MIN_VALUE;
                    } else {
                        localSearchViewModel$result$lambda$1$$inlined$map$2$1 = new LocalSearchViewModel$result$lambda$1$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    localSearchViewModel$result$lambda$1$$inlined$map$2$1 = new LocalSearchViewModel$result$lambda$1$$inlined$map$2$1(this, continuation);
                }
                Object obj4 = localSearchViewModel$result$lambda$1$$inlined$map$2$1.result;
                int i4 = localSearchViewModel$result$lambda$1$$inlined$map$2$1.label;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj4);
                    FlowKt__LimitKt$take$2$1 flowKt__LimitKt$take$2$2 = new FlowKt__LimitKt$take$2$1(flowCollector, obj2, obj, (byte) 7);
                    localSearchViewModel$result$lambda$1$$inlined$map$2$1.label = 1;
                    return flow.collect(flowKt__LimitKt$take$2$2, localSearchViewModel$result$lambda$1$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj4);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
