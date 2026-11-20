package com.metrolist.music.ui.screens.search;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.platform.DelegatingSoftwareKeyboardController;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SearchScreenKt$SearchScreen$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ FocusOwner $focusManager;
    public final /* synthetic */ FocusRequester $focusRequester;
    public final /* synthetic */ MutableState $isHandlingScrollToTop$delegate;
    public final /* synthetic */ boolean $isPlayerExpanded;
    public final /* synthetic */ SoftwareKeyboardController $keyboardController;
    public final /* synthetic */ ParcelableSnapshotMutableIntState $lastHandledCount$delegate;
    public final /* synthetic */ MutableState $scrollToTopCount$delegate;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchScreenKt$SearchScreen$2$1(boolean z, FocusOwner focusOwner, FocusRequester focusRequester, SoftwareKeyboardController softwareKeyboardController, MutableState mutableState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.$isPlayerExpanded = z;
        this.$focusManager = focusOwner;
        this.$focusRequester = focusRequester;
        this.$keyboardController = softwareKeyboardController;
        this.$scrollToTopCount$delegate = mutableState;
        this.$lastHandledCount$delegate = parcelableSnapshotMutableIntState;
        this.$isHandlingScrollToTop$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SearchScreenKt$SearchScreen$2$1(this.$isPlayerExpanded, this.$focusManager, this.$focusRequester, this.$keyboardController, this.$scrollToTopCount$delegate, this.$lastHandledCount$delegate, this.$isHandlingScrollToTop$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((SearchScreenKt$SearchScreen$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
    
        if (kotlinx.coroutines.AwaitKt.delay(50, r8) == r5) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
    
        if (kotlinx.coroutines.AwaitKt.delay(500, r8) == r5) goto L27;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        byte b = this.label;
        MutableState mutableState = this.$isHandlingScrollToTop$delegate;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            MutableState mutableState2 = this.$scrollToTopCount$delegate;
            int iIntValue = ((Number) mutableState2.getValue()).intValue();
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.$lastHandledCount$delegate;
            if (iIntValue > parcelableSnapshotMutableIntState.getIntValue()) {
                parcelableSnapshotMutableIntState.setIntValue(((Number) mutableState2.getValue()).intValue());
                mutableState.setValue(Boolean.TRUE);
                this.label = (byte) 1;
                if (AwaitKt.delay(100L, this) != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            return Unit.INSTANCE;
        }
        if (b == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (b == 2) {
            ResultKt.throwOnFailure(obj);
            try {
                FocusRequester.m415requestFocus3ESFkO8$default(this.$focusRequester);
                SoftwareKeyboardController softwareKeyboardController = this.$keyboardController;
                if (softwareKeyboardController != null) {
                    ((DelegatingSoftwareKeyboardController) softwareKeyboardController).show();
                }
            } catch (Exception unused) {
            }
            this.label = (byte) 3;
        } else {
            if (b != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        mutableState.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
        if (this.$isPlayerExpanded) {
            this.label = (byte) 3;
        } else {
            ((FocusOwnerImpl) this.$focusManager).m409clearFocusI7lrPNg(8, true, true);
            this.label = (byte) 2;
        }
        return coroutineSingletons;
    }
}
