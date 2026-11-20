package com.metrolist.music.ui.screens.search;

import androidx.compose.foundation.lazy.LazyListKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.platform.DelegatingSoftwareKeyboardController;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import com.metrolist.music.viewmodels.HomeViewModel$2$1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SafeFlow;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LocalSearchScreenKt$LocalSearchScreen$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ SoftwareKeyboardController $keyboardController;
    public final /* synthetic */ LazyListState $lazyListState;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocalSearchScreenKt$LocalSearchScreen$1$1(LazyListState lazyListState, SoftwareKeyboardController softwareKeyboardController, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$lazyListState = lazyListState;
        this.$keyboardController = softwareKeyboardController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new LocalSearchScreenKt$LocalSearchScreen$1$1(this.$lazyListState, this.$keyboardController, continuation, (byte) 0);
            default:
                return new LocalSearchScreenKt$LocalSearchScreen$1$1(this.$lazyListState, this.$keyboardController, continuation, (byte) 1);
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
        return ((LocalSearchScreenKt$LocalSearchScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        byte b = this.$r8$classId;
        final SoftwareKeyboardController softwareKeyboardController = this.$keyboardController;
        LazyListState lazyListState = this.$lazyListState;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Unit unit = Unit.INSTANCE;
        final byte b2 = 1;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    SafeFlow safeFlowSnapshotFlow = Stack.snapshotFlow(new LazyListKt$$ExternalSyntheticLambda0(lazyListState, (byte) 7));
                    final byte b3 = 0;
                    FlowCollector flowCollector = new FlowCollector() { // from class: com.metrolist.music.ui.screens.search.LocalSearchScreenKt$LocalSearchScreen$1$1.2
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj2, Continuation continuation) {
                            byte b4 = b3;
                            Unit unit2 = Unit.INSTANCE;
                            SoftwareKeyboardController softwareKeyboardController2 = softwareKeyboardController;
                            switch (b4) {
                                case 0:
                                    ((Number) obj2).intValue();
                                    if (softwareKeyboardController2 != null) {
                                        ((DelegatingSoftwareKeyboardController) softwareKeyboardController2).hide();
                                    }
                                    break;
                                default:
                                    ((Number) obj2).intValue();
                                    if (softwareKeyboardController2 != null) {
                                        ((DelegatingSoftwareKeyboardController) softwareKeyboardController2).hide();
                                    }
                                    break;
                            }
                            return unit2;
                        }
                    };
                    this.label = true;
                    Object objCollect = safeFlowSnapshotFlow.collect(new HomeViewModel$2$1(new Ref$IntRef(), flowCollector, (byte) 10), this);
                    if (objCollect != coroutineSingletons) {
                        objCollect = unit;
                    }
                    if (objCollect == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return unit;
            default:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    SafeFlow safeFlowSnapshotFlow2 = Stack.snapshotFlow(new LazyListKt$$ExternalSyntheticLambda0(lazyListState, (byte) 9));
                    FlowCollector flowCollector2 = new FlowCollector() { // from class: com.metrolist.music.ui.screens.search.LocalSearchScreenKt$LocalSearchScreen$1$1.2
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj2, Continuation continuation) {
                            byte b4 = b2;
                            Unit unit2 = Unit.INSTANCE;
                            SoftwareKeyboardController softwareKeyboardController2 = softwareKeyboardController;
                            switch (b4) {
                                case 0:
                                    ((Number) obj2).intValue();
                                    if (softwareKeyboardController2 != null) {
                                        ((DelegatingSoftwareKeyboardController) softwareKeyboardController2).hide();
                                    }
                                    break;
                                default:
                                    ((Number) obj2).intValue();
                                    if (softwareKeyboardController2 != null) {
                                        ((DelegatingSoftwareKeyboardController) softwareKeyboardController2).hide();
                                    }
                                    break;
                            }
                            return unit2;
                        }
                    };
                    this.label = true;
                    Object objCollect2 = safeFlowSnapshotFlow2.collect(new HomeViewModel$2$1(new Ref$IntRef(), flowCollector2, (byte) 10), this);
                    if (objCollect2 != coroutineSingletons) {
                        objCollect2 = unit;
                    }
                    if (objCollect2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return unit;
        }
    }
}
