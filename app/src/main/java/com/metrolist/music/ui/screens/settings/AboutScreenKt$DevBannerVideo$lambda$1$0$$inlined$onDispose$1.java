package com.metrolist.music.ui.screens.settings;

import androidx.activity.compose.BackHandlerKt$BackHandler$lambda$3$0$$inlined$onStopOrDispose$1;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.saveable.SaveableStateRegistryWrapper;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda0;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.compose.DialogNavigator;
import androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda3;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AboutScreenKt$DevBannerVideo$lambda$1$0$$inlined$onDispose$1 implements DisposableEffectResult {
    public final /* synthetic */ Object $lifecycleOwner$inlined;
    public final /* synthetic */ Object $observer$inlined;
    public final /* synthetic */ Object $player$inlined;
    public final /* synthetic */ byte $r8$classId;

    public AboutScreenKt$DevBannerVideo$lambda$1$0$$inlined$onDispose$1(Function0 function0, LifecycleOwner lifecycleOwner, NavControllerImpl$$ExternalSyntheticLambda3 navControllerImpl$$ExternalSyntheticLambda3) {
        this.$r8$classId = (byte) 2;
        this.$observer$inlined = function0;
        this.$lifecycleOwner$inlined = lifecycleOwner;
        this.$player$inlined = navControllerImpl$$ExternalSyntheticLambda3;
    }

    @Override // androidx.compose.runtime.DisposableEffectResult
    public final void dispose() {
        byte b = this.$r8$classId;
        Object obj = this.$player$inlined;
        Object obj2 = this.$observer$inlined;
        Object obj3 = this.$lifecycleOwner$inlined;
        switch (b) {
            case 0:
                ((LifecycleOwner) obj3).getLifecycle().removeObserver((NavControllerImpl$$ExternalSyntheticLambda3) obj2);
                ExoPlayerImpl exoPlayerImpl = (ExoPlayerImpl) obj;
                if (exoPlayerImpl != null) {
                    exoPlayerImpl.release();
                }
                break;
            case 1:
                ((SnapshotStateList) obj3).remove(obj2);
                ((AnimatedContentTransitionScopeImpl) obj).targetSizeMap.remove(obj2);
                break;
            case 2:
                ((Function0) obj2).invoke();
                ((LifecycleOwner) obj3).getLifecycle().removeObserver((NavControllerImpl$$ExternalSyntheticLambda3) obj);
                break;
            case 3:
                SaveableStateHolderImpl saveableStateHolderImpl = (SaveableStateHolderImpl) obj3;
                SaveableStateRegistryWrapper saveableStateRegistryWrapper = (SaveableStateRegistryWrapper) obj;
                if (saveableStateHolderImpl.registries.remove(obj2) == saveableStateRegistryWrapper) {
                    saveableStateHolderImpl.savedStates.put(obj2, saveableStateRegistryWrapper.$$delegate_0.performSave());
                }
                break;
            case 4:
                ((LifecycleOwner) obj3).getLifecycle().removeObserver((MenuHostHelper$$ExternalSyntheticLambda0) obj2);
                BackHandlerKt$BackHandler$lambda$3$0$$inlined$onStopOrDispose$1 backHandlerKt$BackHandler$lambda$3$0$$inlined$onStopOrDispose$1 = (BackHandlerKt$BackHandler$lambda$3$0$$inlined$onStopOrDispose$1) ((Ref$ObjectRef) obj).element;
                if (backHandlerKt$BackHandler$lambda$3$0$$inlined$onStopOrDispose$1 != null) {
                    backHandlerKt$BackHandler$lambda$3$0$$inlined$onStopOrDispose$1.runStopOrDisposeEffect();
                }
                break;
            default:
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj2;
                ((DialogNavigator) obj3).getState().markTransitionComplete(navBackStackEntry);
                ((SnapshotStateList) obj).remove(navBackStackEntry);
                break;
        }
    }

    public /* synthetic */ AboutScreenKt$DevBannerVideo$lambda$1$0$$inlined$onDispose$1(Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.$lifecycleOwner$inlined = obj;
        this.$observer$inlined = obj2;
        this.$player$inlined = obj3;
    }
}
