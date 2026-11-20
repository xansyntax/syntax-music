package androidx.compose.runtime.saveable;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SaveableStateRegistryWrapper implements SaveableStateRegistry, SavedStateRegistryOwner {
    public final /* synthetic */ SaveableStateRegistryImpl $$delegate_0;
    public SavedStateRegistryController _controller;
    public LifecycleRegistry _lifecycle;

    public SaveableStateRegistryWrapper(SaveableStateRegistryImpl saveableStateRegistryImpl) {
        this.$$delegate_0 = saveableStateRegistryImpl;
        Object objConsumeRestored = saveableStateRegistryImpl.consumeRestored("androidx.savedstate.SavedStateRegistry");
        Bundle bundle = objConsumeRestored instanceof Bundle ? (Bundle) objConsumeRestored : null;
        if (bundle != null && this._controller == null) {
            SavedStateRegistryController savedStateRegistryController = new SavedStateRegistryController(new SavedStateRegistryImpl(this, new RoomDatabase$$ExternalSyntheticLambda0((byte) 27, this)));
            this._controller = savedStateRegistryController;
            savedStateRegistryController.performRestore(bundle);
        }
        saveableStateRegistryImpl.registerProvider("androidx.savedstate.SavedStateRegistry", new RoomDatabase$$ExternalSyntheticLambda0((byte) 4, this));
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final boolean canBeSaved(Object obj) {
        return this.$$delegate_0.canBeSaved(obj);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final Object consumeRestored(String str) {
        return this.$$delegate_0.consumeRestored(str);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        LifecycleRegistry lifecycleRegistry = this._lifecycle;
        if (lifecycleRegistry != null) {
            return lifecycleRegistry;
        }
        LifecycleRegistry lifecycleRegistry2 = new LifecycleRegistry(this, false);
        this._lifecycle = lifecycleRegistry2;
        return lifecycleRegistry2;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        SavedStateRegistryController savedStateRegistryController = this._controller;
        if (savedStateRegistryController == null) {
            SavedStateRegistryController savedStateRegistryController2 = new SavedStateRegistryController(new SavedStateRegistryImpl(this, new RoomDatabase$$ExternalSyntheticLambda0((byte) 27, this)));
            this._controller = savedStateRegistryController2;
            savedStateRegistryController2.performRestore(null);
            savedStateRegistryController = savedStateRegistryController2;
        }
        return savedStateRegistryController.savedStateRegistry;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final Map performSave() {
        return this.$$delegate_0.performSave();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final SaveableStateRegistry.Entry registerProvider(String str, Function0 function0) {
        return this.$$delegate_0.registerProvider(str, function0);
    }
}
