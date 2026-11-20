package com.metrolist.music.ui.component;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.platform.ViewConfiguration;
import com.metrolist.music.ui.screens.Screens;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.AwaitKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AppNavigationKt$NavLongPress$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ HapticFeedback $haptics;
    public final /* synthetic */ boolean $isHomeHoldItem;
    public final /* synthetic */ Ref$BooleanRef $isLongClick;
    public final /* synthetic */ Function0 $onHomeLongHold;
    public final /* synthetic */ Function2 $onItemClick;
    public final /* synthetic */ Function0 $onSearchLongClick;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Screens $screen;
    public final /* synthetic */ MutableState $selectedNow$delegate;
    public final /* synthetic */ ViewConfiguration $viewConfiguration;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AppNavigationKt$NavLongPress$1$1$1(Ref$BooleanRef ref$BooleanRef, boolean z, ViewConfiguration viewConfiguration, HapticFeedback hapticFeedback, Function0 function0, Function0 function1, Function2 function2, Screens screens, MutableState mutableState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$isLongClick = ref$BooleanRef;
        this.$isHomeHoldItem = z;
        this.$viewConfiguration = viewConfiguration;
        this.$haptics = hapticFeedback;
        this.$onHomeLongHold = function0;
        this.$onSearchLongClick = function1;
        this.$onItemClick = function2;
        this.$screen = screens;
        this.$selectedNow$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                AppNavigationKt$NavLongPress$1$1$1 appNavigationKt$NavLongPress$1$1$1 = new AppNavigationKt$NavLongPress$1$1$1(this.$isLongClick, this.$isHomeHoldItem, this.$viewConfiguration, this.$haptics, this.$onHomeLongHold, this.$onSearchLongClick, this.$onItemClick, this.$screen, this.$selectedNow$delegate, continuation, (byte) 0);
                appNavigationKt$NavLongPress$1$1$1.L$0 = obj;
                return appNavigationKt$NavLongPress$1$1$1;
            default:
                AppNavigationKt$NavLongPress$1$1$1 appNavigationKt$NavLongPress$1$1$2 = new AppNavigationKt$NavLongPress$1$1$1(this.$isLongClick, this.$isHomeHoldItem, this.$viewConfiguration, this.$haptics, this.$onHomeLongHold, this.$onSearchLongClick, this.$onItemClick, this.$screen, this.$selectedNow$delegate, continuation, (byte) 1);
                appNavigationKt$NavLongPress$1$1$2.L$0 = obj;
                return appNavigationKt$NavLongPress$1$1$2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Interaction interaction = (Interaction) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
        }
        return ((AppNavigationKt$NavLongPress$1$1$1) create(interaction, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.$selectedNow$delegate;
        Screens screens = this.$screen;
        Function2 function2 = this.$onItemClick;
        Function0 function0 = this.$onSearchLongClick;
        Function0 function1 = this.$onHomeLongHold;
        HapticFeedback hapticFeedback = this.$haptics;
        ViewConfiguration viewConfiguration = this.$viewConfiguration;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Ref$BooleanRef ref$BooleanRef = this.$isLongClick;
        boolean z = this.$isHomeHoldItem;
        switch (b) {
            case 0:
                Interaction interaction = (Interaction) this.L$0;
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    if (interaction == null) {
                        return unit;
                    }
                    if (!(interaction instanceof PressInteraction.Press)) {
                        if (!(interaction instanceof PressInteraction.Release)) {
                            if (!(interaction instanceof PressInteraction.Cancel)) {
                                return unit;
                            }
                            ref$BooleanRef.element = false;
                            return unit;
                        }
                        if (ref$BooleanRef.element) {
                            return unit;
                        }
                        Boolean bool = (Boolean) mutableState.getValue();
                        bool.getClass();
                        function2.invoke(screens, bool);
                        return unit;
                    }
                    ref$BooleanRef.element = false;
                    long longPressTimeoutMillis = z ? 15000L : viewConfiguration.getLongPressTimeoutMillis();
                    this.L$0 = null;
                    this.label = true;
                    if (AwaitKt.delay(longPressTimeoutMillis, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ref$BooleanRef.element = true;
                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                if (z) {
                    if (function1 == null) {
                        return unit;
                    }
                    function1.invoke();
                    return unit;
                }
                if (function0 == null) {
                    return unit;
                }
                function0.invoke();
                return unit;
            default:
                Interaction interaction2 = (Interaction) this.L$0;
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    if (interaction2 == null) {
                        return unit;
                    }
                    if (!(interaction2 instanceof PressInteraction.Press)) {
                        if (!(interaction2 instanceof PressInteraction.Release)) {
                            if (!(interaction2 instanceof PressInteraction.Cancel)) {
                                return unit;
                            }
                            ref$BooleanRef.element = false;
                            return unit;
                        }
                        if (ref$BooleanRef.element) {
                            return unit;
                        }
                        Boolean bool2 = (Boolean) mutableState.getValue();
                        bool2.booleanValue();
                        function2.invoke(screens, bool2);
                        return unit;
                    }
                    ref$BooleanRef.element = false;
                    long longPressTimeoutMillis2 = z ? 15000L : viewConfiguration.getLongPressTimeoutMillis();
                    this.L$0 = null;
                    this.label = true;
                    if (AwaitKt.delay(longPressTimeoutMillis2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ref$BooleanRef.element = true;
                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                if (z) {
                    function1.invoke();
                    return unit;
                }
                if (function0 == null) {
                    return unit;
                }
                function0.invoke();
                return unit;
        }
    }
}
