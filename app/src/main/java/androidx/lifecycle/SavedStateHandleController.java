package androidx.lifecycle;

import androidx.activity.ComponentActivity$$ExternalSyntheticLambda5;
import androidx.savedstate.SavedStateRegistry;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleController implements LifecycleEventObserver, AutoCloseable {
    public final SavedStateHandle handle;
    public boolean isAttached;
    public final String key;

    public SavedStateHandleController(String str, SavedStateHandle savedStateHandle) {
        this.key = str;
        this.handle = savedStateHandle;
    }

    public final void attachToLifecycle(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        savedStateRegistry.getClass();
        lifecycle.getClass();
        if (this.isAttached) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Already attached to lifecycleOwner");
            return;
        }
        this.isAttached = true;
        lifecycle.addObserver(this);
        savedStateRegistry.registerSavedStateProvider(this.key, (ComponentActivity$$ExternalSyntheticLambda5) this.handle.impl.extras);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.isAttached = false;
            lifecycleOwner.getLifecycle().removeObserver(this);
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
    }
}
