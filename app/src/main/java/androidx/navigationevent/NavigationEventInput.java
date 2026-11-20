package androidx.navigationevent;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavigationEventInput {
    public NavigationEventDispatcher dispatcher;
    public boolean isPredictiveBackInProgress;

    public final void dispatchOnBackCompleted() {
        NavigationEventDispatcher navigationEventDispatcher = this.dispatcher;
        if (navigationEventDispatcher == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This input is not added to any dispatcher.");
            return;
        }
        if (!this.isPredictiveBackInProgress) {
            navigationEventDispatcher.dispatchOnStarted$navigationevent(this, null);
        }
        NavigationEventProcessor navigationEventProcessor = navigationEventDispatcher.sharedProcessor;
        OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 = navigationEventDispatcher.onBackCompletedFallback;
        if (equals(navigationEventProcessor.inProgressInput) && -1 == navigationEventProcessor.inProgressDirection) {
            NavigationEventHandler navigationEventHandlerResolveEnabledHandler = navigationEventProcessor.inProgressHandler;
            if (navigationEventHandlerResolveEnabledHandler == null) {
                navigationEventHandlerResolveEnabledHandler = navigationEventProcessor.resolveEnabledHandler(-1);
            }
            navigationEventProcessor.inProgressHandler = null;
            navigationEventProcessor.inProgressDirection = 0;
            navigationEventProcessor.inProgressInput = null;
            if (navigationEventHandlerResolveEnabledHandler == null) {
                ((OnBackPressedDispatcher) onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0.f$0).fallbackOnBackPressed.run();
            } else {
                navigationEventHandlerResolveEnabledHandler.onBackCompleted();
            }
            navigationEventProcessor._transitionState.updateState(null, NavigationEventTransitionState$Idle.INSTANCE);
        }
        this.isPredictiveBackInProgress = false;
    }

    public void onHasEnabledHandlersChanged(boolean z) {
    }
}
