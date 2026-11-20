package kotlinx.coroutines.flow;

import com.metrolist.music.widget.PlaylistWidgetManager$observeQuickPickChanges$6;
import java.util.List;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class FlowKt__ZipKt$combine$1$1 extends SuspendLambda implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function $transform;
    public /* synthetic */ FlowCollector L$0;
    public /* synthetic */ Object L$1;
    public FlowCollector L$2;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlowKt__ZipKt$combine$1$1(Function function, Continuation continuation, byte b) {
        super(3, continuation);
        this.$r8$classId = b;
        this.$transform = function;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function function = this.$transform;
        FlowCollector flowCollector = (FlowCollector) obj;
        switch (b) {
            case 0:
                FlowKt__ZipKt$combine$1$1 flowKt__ZipKt$combine$1$1 = new FlowKt__ZipKt$combine$1$1(function, (Continuation) obj3, (byte) 0);
                flowKt__ZipKt$combine$1$1.L$0 = flowCollector;
                flowKt__ZipKt$combine$1$1.L$1 = (Object[]) obj2;
                return flowKt__ZipKt$combine$1$1.invokeSuspend(unit);
            case 1:
                FlowKt__ZipKt$combine$1$1 flowKt__ZipKt$combine$1$2 = new FlowKt__ZipKt$combine$1$1(function, (Continuation) obj3, (byte) 1);
                flowKt__ZipKt$combine$1$2.L$0 = flowCollector;
                flowKt__ZipKt$combine$1$2.L$1 = obj2;
                return flowKt__ZipKt$combine$1$2.invokeSuspend(unit);
            case 2:
                FlowKt__ZipKt$combine$1$1 flowKt__ZipKt$combine$1$3 = new FlowKt__ZipKt$combine$1$1((Continuation) obj3, function, (byte) 2);
                flowKt__ZipKt$combine$1$3.L$0 = flowCollector;
                flowKt__ZipKt$combine$1$3.L$1 = (Object[]) obj2;
                return flowKt__ZipKt$combine$1$3.invokeSuspend(unit);
            case 3:
                FlowKt__ZipKt$combine$1$1 flowKt__ZipKt$combine$1$4 = new FlowKt__ZipKt$combine$1$1((Continuation) obj3, function, (byte) 3);
                flowKt__ZipKt$combine$1$4.L$0 = flowCollector;
                flowKt__ZipKt$combine$1$4.L$1 = (Object[]) obj2;
                return flowKt__ZipKt$combine$1$4.invokeSuspend(unit);
            default:
                FlowKt__ZipKt$combine$1$1 flowKt__ZipKt$combine$1$5 = new FlowKt__ZipKt$combine$1$1((Continuation) obj3, function, (byte) 4);
                flowKt__ZipKt$combine$1$5.L$0 = flowCollector;
                flowKt__ZipKt$combine$1$5.L$1 = (Object[]) obj2;
                return flowKt__ZipKt$combine$1$5.invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objInvoke;
        Object objInvoke2;
        Object objInvoke3;
        Object objInvoke4;
        Object objInvokeSuspend;
        byte b = this.$r8$classId;
        Function function = this.$transform;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                FlowCollector flowCollector = this.L$0;
                Object[] objArr = (Object[]) this.L$1;
                byte b2 = this.label;
                if (b2 != 0) {
                    if (b2 == 1) {
                        flowCollector = this.L$2;
                        ResultKt.throwOnFailure(obj);
                        objInvoke = obj;
                    } else {
                        if (b2 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = flowCollector;
                this.label = (byte) 1;
                objInvoke = ((Function3) function).invoke(obj2, obj3, this);
                if (objInvoke == coroutineSingletons) {
                    return coroutineSingletons;
                }
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = (byte) 2;
                if (flowCollector.emit(objInvoke, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return unit;
            case 1:
                FlowCollector flowCollector2 = this.L$0;
                Object obj4 = this.L$1;
                byte b3 = this.label;
                if (b3 != 0) {
                    if (b3 == 1) {
                        flowCollector2 = this.L$2;
                        ResultKt.throwOnFailure(obj);
                        objInvoke2 = obj;
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
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = flowCollector2;
                this.label = (byte) 1;
                objInvoke2 = ((Function2) function).invoke(obj4, this);
                if (objInvoke2 == coroutineSingletons) {
                    return coroutineSingletons;
                }
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = (byte) 2;
                if (flowCollector2.emit(objInvoke2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return unit;
            case 2:
                FlowCollector flowCollector3 = this.L$0;
                Object[] objArr2 = (Object[]) this.L$1;
                byte b4 = this.label;
                if (b4 != 0) {
                    if (b4 == 1) {
                        flowCollector3 = this.L$2;
                        ResultKt.throwOnFailure(obj);
                        objInvoke3 = obj;
                    } else {
                        if (b4 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                Object obj5 = objArr2[0];
                Object obj6 = objArr2[1];
                Object obj7 = objArr2[2];
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = flowCollector3;
                this.label = (byte) 1;
                objInvoke3 = ((Function4) function).invoke(obj5, obj6, obj7, this);
                if (objInvoke3 == coroutineSingletons) {
                    return coroutineSingletons;
                }
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = (byte) 2;
                if (flowCollector3.emit(objInvoke3, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return unit;
            case 3:
                FlowCollector flowCollector4 = this.L$0;
                Object[] objArr3 = (Object[]) this.L$1;
                byte b5 = this.label;
                if (b5 != 0) {
                    if (b5 == 1) {
                        flowCollector4 = this.L$2;
                        ResultKt.throwOnFailure(obj);
                        objInvoke4 = obj;
                    } else {
                        if (b5 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                Function5 function5 = (Function5) function;
                Object obj8 = objArr3[0];
                Object obj9 = objArr3[1];
                Object obj10 = objArr3[2];
                Object obj11 = objArr3[3];
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = flowCollector4;
                this.label = (byte) 1;
                objInvoke4 = function5.invoke(obj8, obj9, obj10, obj11, this);
                if (objInvoke4 == coroutineSingletons) {
                    return coroutineSingletons;
                }
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = (byte) 2;
                if (flowCollector4.emit(objInvoke4, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return unit;
            default:
                FlowCollector flowCollector5 = this.L$0;
                Object[] objArr4 = (Object[]) this.L$1;
                byte b6 = this.label;
                if (b6 != 0) {
                    if (b6 == 1) {
                        flowCollector5 = this.L$2;
                        ResultKt.throwOnFailure(obj);
                        objInvokeSuspend = obj;
                    } else {
                        if (b6 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                Object obj12 = objArr4[0];
                Object obj13 = objArr4[1];
                Object obj14 = objArr4[2];
                Object obj15 = objArr4[3];
                Object obj16 = objArr4[4];
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = flowCollector5;
                this.label = (byte) 1;
                PlaylistWidgetManager$observeQuickPickChanges$6 playlistWidgetManager$observeQuickPickChanges$6 = new PlaylistWidgetManager$observeQuickPickChanges$6(this);
                playlistWidgetManager$observeQuickPickChanges$6.L$0 = (List) obj12;
                playlistWidgetManager$observeQuickPickChanges$6.L$1 = (List) obj13;
                playlistWidgetManager$observeQuickPickChanges$6.L$2 = (List) obj14;
                playlistWidgetManager$observeQuickPickChanges$6.L$3 = (List) obj15;
                playlistWidgetManager$observeQuickPickChanges$6.L$4 = (List) obj16;
                objInvokeSuspend = playlistWidgetManager$observeQuickPickChanges$6.invokeSuspend(unit);
                if (objInvokeSuspend == coroutineSingletons) {
                    return coroutineSingletons;
                }
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = (byte) 2;
                if (flowCollector5.emit(objInvokeSuspend, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlowKt__ZipKt$combine$1$1(Continuation continuation, Function function, byte b) {
        super(3, continuation);
        this.$r8$classId = b;
        this.$transform = function;
    }
}
