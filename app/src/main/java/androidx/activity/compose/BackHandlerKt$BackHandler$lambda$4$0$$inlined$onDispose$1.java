package androidx.activity.compose;

import android.view.View;
import androidx.activity.compose.internal.BackHandlerDispatcherCompat;
import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticLambda1;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.layout.LazySaveableStateHolder;
import androidx.compose.foundation.text.TextLinkScope;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda1;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.compose.ComposeNavigator;
import androidx.navigation.compose.DialogHostKt$$ExternalSyntheticLambda4;
import androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda3;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.MainActivity;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda41;
import com.metrolist.music.MainActivity$MetrolistApp$6$1$1$6$1$listener$1;
import com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda8;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1 implements DisposableEffectResult {
    public final /* synthetic */ Object $dispatcher$inlined;
    public final /* synthetic */ Object $handler$inlined;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.$dispatcher$inlined = obj;
        this.$handler$inlined = obj2;
    }

    @Override // androidx.compose.runtime.DisposableEffectResult
    public final void dispose() throws Exception {
        byte b = this.$r8$classId;
        Object obj = this.$handler$inlined;
        Object obj2 = this.$dispatcher$inlined;
        switch (b) {
            case 0:
                ((BackHandlerDispatcherCompat) obj2).removeHandler((ComposeBackHandler) obj);
                break;
            case 1:
                ((BackHandlerDispatcherCompat) obj2).removeHandler((ComposePredictiveBackHandler) obj);
                break;
            case 2:
                ((InfiniteTransition) obj2)._animations.remove((InfiniteTransition.TransitionAnimationState) obj);
                break;
            case 3:
                ((Transition) obj2)._transitions.remove((TransitionInstance) obj);
                break;
            case 4:
                Transition transition = (Transition) obj2;
                transition.getClass();
                Transition.DeferredAnimation.DeferredAnimationData deferredAnimationData = (Transition.DeferredAnimation.DeferredAnimationData) ((Transition.DeferredAnimation) obj).data$delegate.getValue();
                if (deferredAnimationData != null) {
                    transition._animations.remove(deferredAnimationData.animation);
                }
                break;
            case 5:
                ((Transition) obj2)._animations.remove((Transition.TransitionAnimationState) obj);
                break;
            case 6:
                WindowInsetsHolder windowInsetsHolder = (WindowInsetsHolder) obj2;
                View view = (View) obj;
                int i = windowInsetsHolder.accessCount - 1;
                windowInsetsHolder.accessCount = i;
                if (i == 0) {
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(view, null);
                    WindowInsetsAnimationCompat.setCallback(view, null);
                    view.removeOnAttachStateChangeListener(windowInsetsHolder.insetsListener);
                }
                break;
            case 7:
                ((LazySaveableStateHolder) obj2).previouslyComposedKeys.plusAssign(obj);
                break;
            case 8:
                MutableState mutableState = (MutableState) obj2;
                PressInteraction.Press press = (PressInteraction.Press) mutableState.getValue();
                if (press != null) {
                    PressInteraction.Cancel cancel = new PressInteraction.Cancel(press);
                    MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) obj;
                    if (mutableInteractionSourceImpl != null) {
                        mutableInteractionSourceImpl.tryEmit(cancel);
                    }
                    mutableState.setValue(null);
                }
                break;
            case 9:
                ((TextLinkScope) obj2).annotators.remove((Function1) obj);
                break;
            case 10:
                ((NavBackStackEntry) obj2).impl.lifecycle.removeObserver((DialogHostKt$$ExternalSyntheticLambda4) obj);
                break;
            case 11:
                Iterator it = ((List) ((State) obj2).getValue()).iterator();
                while (it.hasNext()) {
                    ((ComposeNavigator) obj).getState().markTransitionComplete((NavBackStackEntry) it.next());
                }
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((ExoPlayerImpl) obj2).removeListener((MainActivity$MetrolistApp$6$1$1$6$1$listener$1) obj);
                break;
            case 13:
                ((MainActivity) obj2).removeOnNewIntentListener((MainActivity$$ExternalSyntheticLambda41) obj);
                break;
            case 14:
                ((LifecycleOwner) obj2).getLifecycle().removeObserver((ActivityResultRegistry$$ExternalSyntheticLambda1) obj);
                break;
            case 15:
                ((Lifecycle) obj2).removeObserver((MenuHostHelper$$ExternalSyntheticLambda1) obj);
                break;
            case 16:
                ((LifecycleOwner) obj2).getLifecycle().removeObserver((NavControllerImpl$$ExternalSyntheticLambda3) obj);
                break;
            default:
                ((LifecycleOwner) obj2).getLifecycle().removeObserver((SearchScreenKt$$ExternalSyntheticLambda8) obj);
                break;
        }
    }
}
