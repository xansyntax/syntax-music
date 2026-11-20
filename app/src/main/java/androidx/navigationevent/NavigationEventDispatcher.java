package androidx.navigationevent;

import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.LinkedHashSet;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavigationEventDispatcher {
    public final LinkedHashSet handlers;
    public final LinkedHashSet inputs;
    public final OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackCompletedFallback;
    public final NavigationEventProcessor sharedProcessor = new NavigationEventProcessor();

    public NavigationEventDispatcher(OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0) {
        this.onBackCompletedFallback = onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
        new LinkedHashSet();
        this.handlers = new LinkedHashSet();
        this.inputs = new LinkedHashSet();
    }

    public static void addHandler$default(NavigationEventDispatcher navigationEventDispatcher, NavigationEventHandler navigationEventHandler) {
        navigationEventDispatcher.getClass();
        navigationEventHandler.getClass();
        if (navigationEventDispatcher.handlers.add(navigationEventHandler)) {
            NavigationEventProcessor navigationEventProcessor = navigationEventDispatcher.sharedProcessor;
            if (navigationEventHandler.dispatcher != null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m("Handler '", navigationEventHandler, "' is already registered with a dispatcher");
                return;
            }
            navigationEventProcessor.defaultHandlers.addFirst(navigationEventHandler);
            navigationEventHandler.dispatcher = navigationEventDispatcher;
            navigationEventProcessor.refreshEnabledHandlers();
        }
    }

    public final void addInput(OnBackInvokedInput onBackInvokedInput, int i) {
        if (i != 1 && i != 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Unsupported priority value: "));
        } else if (this.inputs.add(onBackInvokedInput)) {
            this.sharedProcessor.addInput(this, onBackInvokedInput, i);
        }
    }

    public final void dispatchOnStarted$navigationevent(NavigationEventInput navigationEventInput, NavigationEvent navigationEvent) {
        NavigationEventProcessor navigationEventProcessor = this.sharedProcessor;
        if (navigationEventProcessor.inProgressDirection != 0) {
            return;
        }
        NavigationEventHandler navigationEventHandlerResolveEnabledHandler = navigationEventProcessor.resolveEnabledHandler(-1);
        navigationEventProcessor.inProgressHandler = navigationEventHandlerResolveEnabledHandler;
        navigationEventProcessor.inProgressDirection = -1;
        navigationEventProcessor.inProgressInput = navigationEventInput;
        if (navigationEvent != null) {
            if (navigationEventHandlerResolveEnabledHandler != null) {
                navigationEventHandlerResolveEnabledHandler.onBackStarted(navigationEvent);
            }
            navigationEventProcessor._transitionState.updateState(null, new NavigationEventTransitionState$InProgress(navigationEvent));
        }
    }

    public final void addInput(NavigationEventInput navigationEventInput) {
        if (this.inputs.add(navigationEventInput)) {
            this.sharedProcessor.addInput(this, navigationEventInput, -1);
        }
    }
}
