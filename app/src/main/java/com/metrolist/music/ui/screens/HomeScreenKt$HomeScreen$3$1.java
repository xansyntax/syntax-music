package com.metrolist.music.ui.screens;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.core.provider.CallbackWrapper;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavBackStackEntry;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HomeScreenKt$HomeScreen$3$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableState $backStackEntry$delegate;
    public final /* synthetic */ LazyListState $lazylistState;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ State $scrollToTop;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeScreenKt$HomeScreen$3$1(State state, LazyListState lazyListState, MutableState mutableState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$scrollToTop = state;
        this.$lazylistState = lazyListState;
        this.$backStackEntry$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new HomeScreenKt$HomeScreen$3$1(this.$scrollToTop, this.$lazylistState, this.$backStackEntry$delegate, continuation, (byte) 0);
            case 1:
                return new HomeScreenKt$HomeScreen$3$1(this.$scrollToTop, this.$lazylistState, this.$backStackEntry$delegate, continuation, (byte) 1);
            case 2:
                return new HomeScreenKt$HomeScreen$3$1(this.$scrollToTop, this.$lazylistState, this.$backStackEntry$delegate, continuation, (byte) 2);
            default:
                return new HomeScreenKt$HomeScreen$3$1(this.$scrollToTop, this.$lazylistState, this.$backStackEntry$delegate, continuation, (byte) 3);
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
            case 1:
                break;
            case 2:
                break;
        }
        return ((HomeScreenKt$HomeScreen$3$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SavedStateHandle savedStateHandle;
        SavedStateHandle savedStateHandle2;
        SavedStateHandle savedStateHandle3;
        SavedStateHandle savedStateHandle4;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.$backStackEntry$delegate;
        LazyListState lazyListState = this.$lazylistState;
        State state = this.$scrollToTop;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    if (state == null || !((Boolean) state.getValue()).booleanValue()) {
                        return unit;
                    }
                    this.label = true;
                    CallbackWrapper callbackWrapper = LazyListState.Saver;
                    if (lazyListState.animateScrollToItem(0, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                List list = HomeScreenKt.DailyDiscoverMessages;
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) mutableState.getValue();
                if (navBackStackEntry == null || (savedStateHandle = navBackStackEntry.getSavedStateHandle()) == null) {
                    return unit;
                }
                savedStateHandle.set(Boolean.FALSE, "scrollToTop");
                return unit;
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    if (state == null || !((Boolean) state.getValue()).booleanValue()) {
                        return unit;
                    }
                    this.label = true;
                    CallbackWrapper callbackWrapper2 = LazyListState.Saver;
                    if (lazyListState.animateScrollToItem(0, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) mutableState.getValue();
                if (navBackStackEntry2 == null || (savedStateHandle2 = navBackStackEntry2.getSavedStateHandle()) == null) {
                    return unit;
                }
                savedStateHandle2.set(Boolean.FALSE, "scrollToTop");
                return unit;
            case 2:
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    if (state == null || !((Boolean) state.getValue()).booleanValue()) {
                        return unit;
                    }
                    this.label = true;
                    CallbackWrapper callbackWrapper3 = LazyListState.Saver;
                    if (lazyListState.animateScrollToItem(0, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) mutableState.getValue();
                if (navBackStackEntry3 == null || (savedStateHandle3 = navBackStackEntry3.getSavedStateHandle()) == null) {
                    return unit;
                }
                savedStateHandle3.set(Boolean.FALSE, "scrollToTop");
                return unit;
            default:
                boolean z4 = this.label;
                if (!z4) {
                    ResultKt.throwOnFailure(obj);
                    if (state == null || !((Boolean) state.getValue()).booleanValue()) {
                        return unit;
                    }
                    this.label = true;
                    CallbackWrapper callbackWrapper4 = LazyListState.Saver;
                    if (lazyListState.animateScrollToItem(0, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                NavBackStackEntry navBackStackEntry4 = (NavBackStackEntry) mutableState.getValue();
                if (navBackStackEntry4 == null || (savedStateHandle4 = navBackStackEntry4.getSavedStateHandle()) == null) {
                    return unit;
                }
                savedStateHandle4.set(Boolean.FALSE, "scrollToTop");
                return unit;
        }
    }
}
