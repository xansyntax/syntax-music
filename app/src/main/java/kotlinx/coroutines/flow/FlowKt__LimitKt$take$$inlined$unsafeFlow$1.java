package kotlinx.coroutines.flow;

import com.metrolist.music.viewmodels.StatsViewModel$special$$inlined$map$3$2;
import com.metrolist.music.widget.PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$2$1;
import com.metrolist.music.widget.PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$3$1;
import com.metrolist.music.widget.PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$4$1;
import com.metrolist.music.widget.PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$5$1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class FlowKt__LimitKt$take$$inlined$unsafeFlow$1 implements Flow {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Flow $this_take$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1, reason: invalid class name */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Object L$3;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__LimitKt$take$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public /* synthetic */ FlowKt__LimitKt$take$$inlined$unsafeFlow$1(Flow flow, byte b) {
        this.$r8$classId = b;
        this.$this_take$inlined = flow;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0096  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:69:0x010a  */
    /* JADX WARN: Code duplicated, block: B:9:0x0022  */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Object obj;
        AbortFlowException e;
        PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$2$1 playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$1;
        PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$3$1 playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$1;
        PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$4$1 playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$1;
        PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$5$1 playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$1;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Flow flow = this.$this_take$inlined;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
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
                Object obj2 = anonymousClass1.result;
                int i2 = anonymousClass1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    Object obj3 = new Object();
                    try {
                        FlowKt__LimitKt$take$2$1 flowKt__LimitKt$take$2$1 = new FlowKt__LimitKt$take$2$1((Object) new Ref$IntRef(), (Object) flowCollector, obj3, (byte) 0);
                        anonymousClass1.L$3 = obj3;
                        anonymousClass1.label = 1;
                        return flow.collect(flowKt__LimitKt$take$2$1, anonymousClass1) == coroutineSingletons ? coroutineSingletons : unit;
                    } catch (AbortFlowException e2) {
                        obj = obj3;
                        e = e2;
                    }
                } else {
                    if (i2 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    obj = anonymousClass1.L$3;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        return unit;
                    } catch (AbortFlowException e3) {
                        e = e3;
                    }
                }
                if (e.owner == obj) {
                    return unit;
                }
                throw e;
            case 1:
                if (continuation instanceof PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$2$1) {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$1 = (PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$2$1) continuation;
                    int i3 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$1.label;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$1.label = i3 - Integer.MIN_VALUE;
                    } else {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$2$1(this, continuation);
                }
                Object obj4 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$1.result;
                int i4 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$1.label;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj4);
                    StatsViewModel$special$$inlined$map$3$2 statsViewModel$special$$inlined$map$3$2 = new StatsViewModel$special$$inlined$map$3$2(flowCollector, (byte) 4);
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$1.label = 1;
                    return flow.collect(statsViewModel$special$$inlined$map$3$2, playlistWidgetManager$observeQuickPickChanges$$inlined$map$2$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj4);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 2:
                if (continuation instanceof PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$3$1) {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$1 = (PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$3$1) continuation;
                    int i5 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$1.label;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$1.label = i5 - Integer.MIN_VALUE;
                    } else {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$3$1(this, continuation);
                    }
                } else {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$3$1(this, continuation);
                }
                Object obj5 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$1.result;
                int i6 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$1.label;
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj5);
                    StatsViewModel$special$$inlined$map$3$2 statsViewModel$special$$inlined$map$3$3 = new StatsViewModel$special$$inlined$map$3$2(flowCollector, (byte) 5);
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$1.label = 1;
                    return flow.collect(statsViewModel$special$$inlined$map$3$3, playlistWidgetManager$observeQuickPickChanges$$inlined$map$3$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i6 == 1) {
                    ResultKt.throwOnFailure(obj5);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 3:
                if (continuation instanceof PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$4$1) {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$1 = (PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$4$1) continuation;
                    int i7 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$1.label;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$1.label = i7 - Integer.MIN_VALUE;
                    } else {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$4$1(this, continuation);
                    }
                } else {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$4$1(this, continuation);
                }
                Object obj6 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$1.result;
                int i8 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$1.label;
                if (i8 == 0) {
                    ResultKt.throwOnFailure(obj6);
                    StatsViewModel$special$$inlined$map$3$2 statsViewModel$special$$inlined$map$3$4 = new StatsViewModel$special$$inlined$map$3$2(flowCollector, (byte) 6);
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$1.label = 1;
                    return flow.collect(statsViewModel$special$$inlined$map$3$4, playlistWidgetManager$observeQuickPickChanges$$inlined$map$4$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i8 == 1) {
                    ResultKt.throwOnFailure(obj6);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                if (continuation instanceof PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$5$1) {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$1 = (PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$5$1) continuation;
                    int i9 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$1.label;
                    if ((i9 & Integer.MIN_VALUE) != 0) {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$1.label = i9 - Integer.MIN_VALUE;
                    } else {
                        playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$5$1(this, continuation);
                    }
                } else {
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$1 = new PlaylistWidgetManager$observeQuickPickChanges$$inlined$map$5$1(this, continuation);
                }
                Object obj7 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$1.result;
                int i10 = playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$1.label;
                if (i10 == 0) {
                    ResultKt.throwOnFailure(obj7);
                    StatsViewModel$special$$inlined$map$3$2 statsViewModel$special$$inlined$map$3$5 = new StatsViewModel$special$$inlined$map$3$2(flowCollector, (byte) 7);
                    playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$1.label = 1;
                    return flow.collect(statsViewModel$special$$inlined$map$3$5, playlistWidgetManager$observeQuickPickChanges$$inlined$map$5$1) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (i10 == 1) {
                    ResultKt.throwOnFailure(obj7);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
