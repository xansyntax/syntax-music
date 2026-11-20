package androidx.compose.material3;

import androidx.activity.compose.BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.DelegatingSoftwareKeyboardController;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.internal.NavControllerImpl;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MenuKt$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 2;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda2(LifecycleOwner lifecycleOwner, boolean z, SoftwareKeyboardController softwareKeyboardController, FocusOwner focusOwner, MutableState mutableState) {
        this.f$1 = lifecycleOwner;
        this.f$0 = z;
        this.f$2 = softwareKeyboardController;
        this.f$3 = focusOwner;
        this.f$4 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        float fFloatValue;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$4;
        Object obj3 = this.f$3;
        Object obj4 = this.f$2;
        final boolean z = this.f$0;
        Object obj5 = this.f$1;
        switch (b) {
            case 0:
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = ((MutableTransitionState) obj5).targetState$delegate;
                Function0 function0 = (Function0) obj4;
                State state = (State) obj3;
                State state2 = (State) obj2;
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                float fFloatValue2 = 0.8f;
                float fFloatValue3 = 1.0f;
                if (z) {
                    fFloatValue = ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue() ? 1.0f : 0.8f;
                } else {
                    fFloatValue = ((Number) state.getValue()).floatValue();
                }
                reusableGraphicsLayerScope.setScaleX(fFloatValue);
                if (!z) {
                    fFloatValue2 = ((Number) state.getValue()).floatValue();
                } else if (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
                    fFloatValue2 = 1.0f;
                }
                reusableGraphicsLayerScope.setScaleY(fFloatValue2);
                if (!z) {
                    fFloatValue3 = ((Number) state2.getValue()).floatValue();
                } else if (!((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
                    fFloatValue3 = CropImageView.DEFAULT_ASPECT_RATIO;
                }
                reusableGraphicsLayerScope.setAlpha(fFloatValue3);
                reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(((TransformOrigin) function0.invoke()).packedValue);
                return unit;
            case 1:
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                navBackStackEntry.getClass();
                ((Ref$BooleanRef) obj5).element = true;
                ((Ref$BooleanRef) obj4).element = true;
                ((NavControllerImpl) obj3).popEntryFromBackStack$navigation_runtime_release(navBackStackEntry, z, (ArrayDeque) obj2);
                return unit;
            default:
                LifecycleOwner lifecycleOwner = (LifecycleOwner) obj5;
                final SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) obj4;
                final FocusOwner focusOwner = (FocusOwner) obj3;
                final MutableState mutableState = (MutableState) obj2;
                ((DisposableEffectScope) obj).getClass();
                LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda8
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                        int i = SearchScreenKt.WhenMappings.$EnumSwitchMapping$1[event.ordinal()];
                        SoftwareKeyboardController softwareKeyboardController2 = softwareKeyboardController;
                        FocusOwner focusOwner2 = focusOwner;
                        MutableState mutableState2 = mutableState;
                        if (i == 1) {
                            if (!((Boolean) mutableState2.getValue()).booleanValue() && z) {
                                if (softwareKeyboardController2 != null) {
                                    ((DelegatingSoftwareKeyboardController) softwareKeyboardController2).hide();
                                }
                                ((FocusOwnerImpl) focusOwner2).m409clearFocusI7lrPNg(8, false, true);
                                return;
                            }
                            return;
                        }
                        if (i == 2 && !((Boolean) mutableState2.getValue()).booleanValue()) {
                            ((FocusOwnerImpl) focusOwner2).m409clearFocusI7lrPNg(8, false, true);
                            if (softwareKeyboardController2 != null) {
                                ((DelegatingSoftwareKeyboardController) softwareKeyboardController2).hide();
                            }
                        }
                    }
                };
                lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
                if (z) {
                    if (softwareKeyboardController != null) {
                        ((DelegatingSoftwareKeyboardController) softwareKeyboardController).hide();
                    }
                    ((FocusOwnerImpl) focusOwner).m409clearFocusI7lrPNg(8, false, true);
                }
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1(lifecycleOwner, lifecycleEventObserver, (byte) 17);
        }
    }

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda2(Ref$BooleanRef ref$BooleanRef, Ref$BooleanRef ref$BooleanRef2, NavControllerImpl navControllerImpl, boolean z, ArrayDeque arrayDeque) {
        this.f$1 = ref$BooleanRef;
        this.f$2 = ref$BooleanRef2;
        this.f$3 = navControllerImpl;
        this.f$0 = z;
        this.f$4 = arrayDeque;
    }

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda2(boolean z, MutableTransitionState mutableTransitionState, Function0 function0, Transition.TransitionAnimationState transitionAnimationState, Transition.TransitionAnimationState transitionAnimationState2) {
        this.f$0 = z;
        this.f$1 = mutableTransitionState;
        this.f$2 = function0;
        this.f$3 = transitionAnimationState;
        this.f$4 = transitionAnimationState2;
    }
}
