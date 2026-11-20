package androidx.activity;

import android.window.OnBackInvokedDispatcher;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.DefaultLifecycleObserverAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.navigationevent.NavigationEventDispatcher;
import androidx.navigationevent.NavigationEventInput;
import androidx.navigationevent.OnBackInvokedDefaultInput;
import kotlin.SynchronizedLazyImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    public final SynchronizedLazyImpl eventInput$delegate = new SynchronizedLazyImpl(new SliderState$$ExternalSyntheticLambda0(1, this));
    public final Runnable fallbackOnBackPressed;

    public OnBackPressedDispatcher(Runnable runnable) {
        this.fallbackOnBackPressed = runnable;
    }

    public final void addCallback(FragmentManager.AnonymousClass1 anonymousClass1, LifecycleOwner lifecycleOwner) {
        anonymousClass1.getClass();
        final Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (((LifecycleRegistry) lifecycle).state == Lifecycle.State.DESTROYED) {
            return;
        }
        OnBackPressedCallback$OnBackPressedEventHandler onBackPressedCallback$OnBackPressedEventHandler = new OnBackPressedCallback$OnBackPressedEventHandler(anonymousClass1, new OnBackPressedCallbackInfo(anonymousClass1, lifecycleOwner));
        anonymousClass1.eventHandlers.add(onBackPressedCallback$OnBackPressedEventHandler);
        onBackPressedCallback$OnBackPressedEventHandler.setLifecycleActive(false);
        NavigationEventDispatcher.addHandler$default(getEventInput().dispatcher, onBackPressedCallback$OnBackPressedEventHandler);
        final DefaultLifecycleObserverAdapter defaultLifecycleObserverAdapter = new DefaultLifecycleObserverAdapter(onBackPressedCallback$OnBackPressedEventHandler, this, lifecycle);
        lifecycle.addObserver(defaultLifecycleObserverAdapter);
        anonymousClass1.closeables.add(new AutoCloseable() { // from class: androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda1
            @Override // java.lang.AutoCloseable
            public final void close() {
                lifecycle.removeObserver(defaultLifecycleObserverAdapter);
            }
        });
    }

    public final OnBackPressedEventInput getEventInput() {
        return (OnBackPressedEventInput) this.eventInput$delegate.getValue();
    }

    public final void setOnBackInvokedDispatcher(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        getEventInput().dispatcher.addInput(new OnBackInvokedDefaultInput(onBackInvokedDispatcher, 0), 1);
        getEventInput().dispatcher.addInput(new OnBackInvokedDefaultInput(onBackInvokedDispatcher, 1000000), 0);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class OnBackPressedEventInput extends NavigationEventInput {
        public final NavigationEventDispatcher dispatcher;

        public OnBackPressedEventInput(OnBackPressedDispatcher onBackPressedDispatcher) {
            NavigationEventDispatcher navigationEventDispatcher = new NavigationEventDispatcher(new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 0, (Object) onBackPressedDispatcher));
            navigationEventDispatcher.addInput(this);
            this.dispatcher = navigationEventDispatcher;
        }

        @Override // androidx.navigationevent.NavigationEventInput
        public final void onHasEnabledHandlersChanged(boolean z) {
        }
    }
}
