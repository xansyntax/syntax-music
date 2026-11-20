package kotlinx.coroutines.flow;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1;
import com.metrolist.music.db.DatabaseDao$songs$$inlined$map$1;
import com.metrolist.music.utils.DataStoreKt$get$2;
import com.metrolist.music.viewmodels.HomeViewModel$2$1;
import com.metrolist.music.viewmodels.StatsViewModel$special$$inlined$map$3$2;
import com.metrolist.music.widget.PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$1$1;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.flow.internal.FlowCoroutine;
import kotlinx.coroutines.flow.internal.SafeCollector;
import kotlinx.coroutines.flow.internal.SubscriptionCountStateFlow;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class SafeFlow implements Flow {
    public final /* synthetic */ byte $r8$classId;
    public final Object block;

    public /* synthetic */ SafeFlow(byte b, Object obj) {
        this.$r8$classId = b;
        this.block = obj;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0083  */
    /* JADX WARN: Code duplicated, block: B:50:0x00de  */
    /* JADX WARN: Code duplicated, block: B:70:0x012a  */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) throws Throwable {
        AbstractFlow$collect$1 abstractFlow$collect$1;
        SafeCollector safeCollector;
        Throwable th;
        PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$1$1 playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$1;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1 flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1;
        int i;
        Iterator it;
        int i2;
        StartedLazily$command$$inlined$unsafeFlow$1$1 startedLazily$command$$inlined$unsafeFlow$1$1;
        byte b = this.$r8$classId;
        Continuation continuation2 = null;
        Unit unit = Unit.INSTANCE;
        byte b2 = 1;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Object obj = this.block;
        switch (b) {
            case 0:
                if (continuation instanceof AbstractFlow$collect$1) {
                    abstractFlow$collect$1 = (AbstractFlow$collect$1) continuation;
                    int i3 = abstractFlow$collect$1.label;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        abstractFlow$collect$1.label = i3 - Integer.MIN_VALUE;
                    } else {
                        abstractFlow$collect$1 = new AbstractFlow$collect$1(this, continuation);
                    }
                } else {
                    abstractFlow$collect$1 = new AbstractFlow$collect$1(this, continuation);
                }
                Object obj2 = abstractFlow$collect$1.result;
                int i4 = abstractFlow$collect$1.label;
                if (i4 != 0) {
                    if (i4 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    safeCollector = abstractFlow$collect$1.L$1;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        safeCollector.releaseIntercepted();
                        return unit;
                    } catch (Throwable th2) {
                        th = th2;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                }
                ResultKt.throwOnFailure(obj2);
                SafeCollector safeCollector2 = new SafeCollector(flowCollector, abstractFlow$collect$1.getContext());
                try {
                    abstractFlow$collect$1.L$1 = safeCollector2;
                    abstractFlow$collect$1.label = 1;
                    Object objInvoke = ((Function2) obj).invoke(safeCollector2, abstractFlow$collect$1);
                    if (objInvoke != coroutineSingletons) {
                        objInvoke = unit;
                    }
                    if (objInvoke == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    safeCollector = safeCollector2;
                    safeCollector.releaseIntercepted();
                    return unit;
                } catch (Throwable th3) {
                    safeCollector = safeCollector2;
                    th = th3;
                    safeCollector.releaseIntercepted();
                    throw th;
                }
            case 1:
                Object objCollect = ((FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1) obj).collect(new DatabaseDao$songs$$inlined$map$1.AnonymousClass2(flowCollector, b2), continuation);
                return objCollect == coroutineSingletons ? objCollect : unit;
            case 2:
                if (continuation instanceof PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$1$1) {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$1 = (PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$1$1) continuation;
                    int i5 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$1.label;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$1.label = i5 - Integer.MIN_VALUE;
                    } else {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$1$1(this, continuation);
                }
                Object obj3 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$1.result;
                int i6 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$1.label;
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj3);
                    StatsViewModel$special$$inlined$map$3$2 statsViewModel$special$$inlined$map$3$2 = new StatsViewModel$special$$inlined$map$3$2(flowCollector, (byte) 3);
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$1.label = 1;
                    if (((FlowUtil$createFlow$$inlined$map$1) obj).collect(statsViewModel$special$$inlined$map$3$2, playlistWidgetManager$observeQuickPickChanges$$inlined$map$1$1) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i6 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj3);
                }
                return unit;
            case 3:
                if (continuation instanceof FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1) {
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1) continuation;
                    int i7 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1.label;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1.label = i7 - Integer.MIN_VALUE;
                    } else {
                        flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1 = new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1(this, continuation);
                    }
                } else {
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1 = new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1(this, continuation);
                }
                Object obj4 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1.result;
                int i8 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1.label;
                if (i8 == 0) {
                    ResultKt.throwOnFailure(obj4);
                    i = 0;
                    it = ((Iterable) obj).iterator();
                    i2 = 0;
                } else {
                    if (i8 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    int i9 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1.I$1;
                    int i10 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1.I$0;
                    it = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1.L$4;
                    FlowCollector flowCollector2 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1.L$2;
                    ResultKt.throwOnFailure(obj4);
                    i2 = i10;
                    i = i9;
                    flowCollector = flowCollector2;
                }
                while (it.hasNext()) {
                    Object next = it.next();
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1.L$2 = flowCollector;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1.L$4 = it;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1.I$0 = i2;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1.I$1 = i;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1.label = 1;
                    if (flowCollector.emit(next, flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return unit;
            case 4:
                Object objEmit = flowCollector.emit(obj, continuation);
                return objEmit == coroutineSingletons ? objEmit : unit;
            case 5:
                if (continuation instanceof StartedLazily$command$$inlined$unsafeFlow$1$1) {
                    startedLazily$command$$inlined$unsafeFlow$1$1 = (StartedLazily$command$$inlined$unsafeFlow$1$1) continuation;
                    int i11 = startedLazily$command$$inlined$unsafeFlow$1$1.label;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        startedLazily$command$$inlined$unsafeFlow$1$1.label = i11 - Integer.MIN_VALUE;
                    } else {
                        startedLazily$command$$inlined$unsafeFlow$1$1 = new StartedLazily$command$$inlined$unsafeFlow$1$1(this, continuation);
                    }
                } else {
                    startedLazily$command$$inlined$unsafeFlow$1$1 = new StartedLazily$command$$inlined$unsafeFlow$1$1(this, continuation);
                }
                Object obj5 = startedLazily$command$$inlined$unsafeFlow$1$1.result;
                int i12 = startedLazily$command$$inlined$unsafeFlow$1$1.label;
                if (i12 != 0) {
                    if (i12 == 1) {
                        throw Fragment$5$$ExternalSyntheticOutline0.m(obj5);
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj5);
                HomeViewModel$2$1 homeViewModel$2$1 = new HomeViewModel$2$1(new Ref$BooleanRef(), flowCollector, (byte) 13);
                startedLazily$command$$inlined$unsafeFlow$1$1.label = 1;
                ((SubscriptionCountStateFlow) obj).collect(homeViewModel$2$1, startedLazily$command$$inlined$unsafeFlow$1$1);
                return coroutineSingletons;
            default:
                DataStoreKt$get$2 dataStoreKt$get$2 = new DataStoreKt$get$2((FlowKt__DelayKt$debounceInternal$1) obj, flowCollector, continuation2, (byte) 27);
                FlowCoroutine flowCoroutine = new FlowCoroutine(continuation, continuation.getContext());
                Object objStartUndispatched = Okio__OkioKt.startUndispatched(flowCoroutine, true, flowCoroutine, dataStoreKt$get$2);
                return objStartUndispatched == coroutineSingletons ? objStartUndispatched : unit;
        }
    }
}
