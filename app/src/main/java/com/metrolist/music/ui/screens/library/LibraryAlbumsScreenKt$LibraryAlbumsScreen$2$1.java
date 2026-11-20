package com.metrolist.music.ui.screens.library;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.core.provider.CallbackWrapper;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavBackStackEntry;
import com.metrolist.music.constants.LibraryViewType;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
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
public final class LibraryAlbumsScreenKt$LibraryAlbumsScreen$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableState $backStackEntry$delegate;
    public final /* synthetic */ LazyGridState $lazyGridState;
    public final /* synthetic */ LazyListState $lazyListState;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ State $scrollToTop;
    public final /* synthetic */ MutableState $viewType$delegate;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LibraryAlbumsScreenKt$LibraryAlbumsScreen$2$1(State state, LazyListState lazyListState, LazyGridState lazyGridState, MutableState mutableState, MutableState mutableState2, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$scrollToTop = state;
        this.$lazyListState = lazyListState;
        this.$lazyGridState = lazyGridState;
        this.$viewType$delegate = mutableState;
        this.$backStackEntry$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new LibraryAlbumsScreenKt$LibraryAlbumsScreen$2$1(this.$scrollToTop, this.$lazyListState, this.$lazyGridState, this.$viewType$delegate, this.$backStackEntry$delegate, continuation, (byte) 0);
            default:
                return new LibraryAlbumsScreenKt$LibraryAlbumsScreen$2$1(this.$scrollToTop, this.$lazyListState, this.$lazyGridState, this.$viewType$delegate, this.$backStackEntry$delegate, continuation, (byte) 1);
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
        return ((LibraryAlbumsScreenKt$LibraryAlbumsScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        if (androidx.compose.foundation.lazy.grid.LazyGridState.animateScrollToItem$default(r5, 0, r14) == r9) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0060, code lost:
    
        if (r4.animateScrollToItem(0, r14) == r9) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ae, code lost:
    
        if (androidx.compose.foundation.lazy.grid.LazyGridState.animateScrollToItem$default(r5, 0, r14) == r9) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00bd, code lost:
    
        if (r4.animateScrollToItem(0, r14) == r9) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:?, code lost:
    
        return r9;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SavedStateHandle savedStateHandle;
        SavedStateHandle savedStateHandle2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.$backStackEntry$delegate;
        LazyListState lazyListState = this.$lazyListState;
        LazyGridState lazyGridState = this.$lazyGridState;
        MutableState mutableState2 = this.$viewType$delegate;
        State state = this.$scrollToTop;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                byte b2 = this.label;
                if (b2 != 0) {
                    if (b2 != 1 && b2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    NavBackStackEntry navBackStackEntry = (NavBackStackEntry) mutableState.getValue();
                    if (navBackStackEntry == null || (savedStateHandle = navBackStackEntry.getSavedStateHandle()) == null) {
                        return unit;
                    }
                    savedStateHandle.set(Boolean.FALSE, "scrollToTop");
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                if (state == null || !((Boolean) state.getValue()).booleanValue()) {
                    return unit;
                }
                int iOrdinal = ((LibraryViewType) mutableState2.getValue()).ordinal();
                if (iOrdinal == 0) {
                    this.label = (byte) 1;
                    CallbackWrapper callbackWrapper = LazyListState.Saver;
                } else {
                    if (iOrdinal != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    this.label = (byte) 2;
                }
                break;
            default:
                byte b3 = this.label;
                if (b3 != 0) {
                    if (b3 != 1 && b3 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) mutableState.getValue();
                    if (navBackStackEntry2 == null || (savedStateHandle2 = navBackStackEntry2.getSavedStateHandle()) == null) {
                        return unit;
                    }
                    savedStateHandle2.set(Boolean.FALSE, "scrollToTop");
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                if (state == null || !((Boolean) state.getValue()).booleanValue()) {
                    return unit;
                }
                int iOrdinal2 = ((LibraryViewType) mutableState2.getValue()).ordinal();
                if (iOrdinal2 == 0) {
                    this.label = (byte) 1;
                    CallbackWrapper callbackWrapper2 = LazyListState.Saver;
                } else {
                    if (iOrdinal2 != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    this.label = (byte) 2;
                }
                break;
        }
    }
}
