package com.metrolist.music.ui.screens;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusRequester;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StatsScreenKt$StatsScreen$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ FocusRequester $focusRequester;
    public final /* synthetic */ MutableState $isSearching$delegate;
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StatsScreenKt$StatsScreen$1$1(FocusRequester focusRequester, MutableState mutableState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$focusRequester = focusRequester;
        this.$isSearching$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        MutableState mutableState = this.$isSearching$delegate;
        FocusRequester focusRequester = this.$focusRequester;
        switch (b) {
            case 0:
                return new StatsScreenKt$StatsScreen$1$1(focusRequester, mutableState, continuation, (byte) 0);
            case 1:
                return new StatsScreenKt$StatsScreen$1$1(focusRequester, mutableState, continuation, (byte) 1);
            case 2:
                return new StatsScreenKt$StatsScreen$1$1(focusRequester, mutableState, continuation, (byte) 2);
            case 3:
                return new StatsScreenKt$StatsScreen$1$1(focusRequester, mutableState, continuation, (byte) 3);
            case 4:
                return new StatsScreenKt$StatsScreen$1$1(focusRequester, mutableState, continuation, (byte) 4);
            case 5:
                return new StatsScreenKt$StatsScreen$1$1(focusRequester, mutableState, continuation, (byte) 5);
            case 6:
                return new StatsScreenKt$StatsScreen$1$1(focusRequester, mutableState, continuation, (byte) 6);
            default:
                return new StatsScreenKt$StatsScreen$1$1(focusRequester, mutableState, continuation, (byte) 7);
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
                ((StatsScreenKt$StatsScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            case 1:
                ((StatsScreenKt$StatsScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            case 2:
                ((StatsScreenKt$StatsScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            case 3:
                ((StatsScreenKt$StatsScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            case 4:
                ((StatsScreenKt$StatsScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            case 5:
                ((StatsScreenKt$StatsScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            case 6:
                ((StatsScreenKt$StatsScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((StatsScreenKt$StatsScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        FocusRequester focusRequester = this.$focusRequester;
        MutableState mutableState = this.$isSearching$delegate;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                    FocusRequester.m415requestFocus3ESFkO8$default(focusRequester);
                }
                break;
            case 1:
                ResultKt.throwOnFailure(obj);
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                    FocusRequester.m415requestFocus3ESFkO8$default(focusRequester);
                }
                break;
            case 2:
                ResultKt.throwOnFailure(obj);
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                    FocusRequester.m415requestFocus3ESFkO8$default(focusRequester);
                }
                break;
            case 3:
                ResultKt.throwOnFailure(obj);
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                    FocusRequester.m415requestFocus3ESFkO8$default(focusRequester);
                }
                break;
            case 4:
                ResultKt.throwOnFailure(obj);
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                    FocusRequester.m415requestFocus3ESFkO8$default(focusRequester);
                }
                break;
            case 5:
                ResultKt.throwOnFailure(obj);
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                    FocusRequester.m415requestFocus3ESFkO8$default(focusRequester);
                }
                break;
            case 6:
                ResultKt.throwOnFailure(obj);
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                    FocusRequester.m415requestFocus3ESFkO8$default(focusRequester);
                }
                break;
            default:
                ResultKt.throwOnFailure(obj);
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                    FocusRequester.m415requestFocus3ESFkO8$default(focusRequester);
                }
                break;
        }
        return unit;
    }
}
