package androidx.activity;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.navigationevent.DirectNavigationEventInput;
import androidx.navigationevent.NavigationEventDispatcher;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import com.yalantis.ucrop.R;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ComponentDialog extends Dialog implements LifecycleOwner, OnBackPressedDispatcherOwner, NavigationEventDispatcherOwner, SavedStateRegistryOwner {
    public LifecycleRegistry _lifecycleRegistry;
    public final SynchronizedLazyImpl onBackPressedDispatcher$delegate;
    public final SynchronizedLazyImpl onBackPressedInput$delegate;
    public final SavedStateRegistryController savedStateRegistryController;

    public ComponentDialog(ContextThemeWrapper contextThemeWrapper, int i) {
        super(contextThemeWrapper, i);
        this.savedStateRegistryController = new SavedStateRegistryController(new SavedStateRegistryImpl(this, new RoomDatabase$$ExternalSyntheticLambda0((byte) 27, this)));
        final byte b = 0;
        this.onBackPressedInput$delegate = new SynchronizedLazyImpl(new Function0(this) { // from class: androidx.activity.ComponentDialog$$ExternalSyntheticLambda0
            public final /* synthetic */ ComponentDialog f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b2 = b;
                ComponentDialog componentDialog = this.f$0;
                switch (b2) {
                    case 0:
                        DirectNavigationEventInput directNavigationEventInput = new DirectNavigationEventInput();
                        componentDialog.getNavigationEventDispatcher().addInput(directNavigationEventInput);
                        return directNavigationEventInput;
                    default:
                        return new OnBackPressedDispatcher(new ActivityCompat$$ExternalSyntheticLambda0((byte) 2, componentDialog));
                }
            }
        });
        final byte b2 = 1;
        this.onBackPressedDispatcher$delegate = new SynchronizedLazyImpl(new Function0(this) { // from class: androidx.activity.ComponentDialog$$ExternalSyntheticLambda0
            public final /* synthetic */ ComponentDialog f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b3 = b2;
                ComponentDialog componentDialog = this.f$0;
                switch (b3) {
                    case 0:
                        DirectNavigationEventInput directNavigationEventInput = new DirectNavigationEventInput();
                        componentDialog.getNavigationEventDispatcher().addInput(directNavigationEventInput);
                        return directNavigationEventInput;
                    default:
                        return new OnBackPressedDispatcher(new ActivityCompat$$ExternalSyntheticLambda0((byte) 2, componentDialog));
                }
            }
        });
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        view.getClass();
        initializeViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    public final LifecycleRegistry getLifecycleRegistry() {
        LifecycleRegistry lifecycleRegistry = this._lifecycleRegistry;
        if (lifecycleRegistry != null) {
            return lifecycleRegistry;
        }
        LifecycleRegistry lifecycleRegistry2 = new LifecycleRegistry(this, true);
        this._lifecycleRegistry = lifecycleRegistry2;
        return lifecycleRegistry2;
    }

    @Override // androidx.navigationevent.NavigationEventDispatcherOwner
    public final NavigationEventDispatcher getNavigationEventDispatcher() {
        return getOnBackPressedDispatcher().getEventInput().dispatcher;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return (OnBackPressedDispatcher) this.onBackPressedDispatcher$delegate.getValue();
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.savedStateRegistry;
    }

    public final void initializeViewTreeOwners() {
        Window window = getWindow();
        window.getClass();
        View decorView = window.getDecorView();
        decorView.getClass();
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        Window window2 = getWindow();
        window2.getClass();
        View decorView2 = window2.getDecorView();
        decorView2.getClass();
        decorView2.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        Window window3 = getWindow();
        window3.getClass();
        View decorView3 = window3.getDecorView();
        decorView3.getClass();
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        Window window4 = getWindow();
        window4.getClass();
        View decorView4 = window4.getDecorView();
        decorView4.getClass();
        decorView4.setTag(R.id.view_tree_navigation_event_dispatcher_owner, this);
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        ((DirectNavigationEventInput) this.onBackPressedInput$delegate.getValue()).dispatchOnBackCompleted();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            onBackInvokedDispatcher.getClass();
            onBackPressedDispatcher.setOnBackInvokedDispatcher(onBackInvokedDispatcher);
        }
        this.savedStateRegistryController.performRestore(bundle);
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        bundleOnSaveInstanceState.getClass();
        this.savedStateRegistryController.performSave(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this._lifecycleRegistry = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        view.getClass();
        initializeViewTreeOwners();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        initializeViewTreeOwners();
        super.setContentView(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        view.getClass();
        initializeViewTreeOwners();
        super.setContentView(view, layoutParams);
    }
}
