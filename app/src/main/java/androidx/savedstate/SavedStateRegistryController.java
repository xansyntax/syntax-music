package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.media3.extractor.text.CueDecoder;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateRegistryController {
    public final SavedStateRegistryImpl impl;
    public final SavedStateRegistry savedStateRegistry;

    public SavedStateRegistryController(SavedStateRegistryImpl savedStateRegistryImpl) {
        this.impl = savedStateRegistryImpl;
        this.savedStateRegistry = new SavedStateRegistry(savedStateRegistryImpl);
    }

    public final void performRestore(Bundle bundle) {
        SavedStateRegistryImpl savedStateRegistryImpl = this.impl;
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) savedStateRegistryImpl.owner;
        if (!savedStateRegistryImpl.attached) {
            savedStateRegistryImpl.performAttach();
        }
        if (((LifecycleRegistry) savedStateRegistryOwner.getLifecycle()).state.compareTo(Lifecycle.State.STARTED) >= 0) {
            PathKt$$ExternalSyntheticBUOutline0.m$2(((LifecycleRegistry) savedStateRegistryOwner.getLifecycle()).state, "performRestore cannot be called when owner is ");
            return;
        }
        if (savedStateRegistryImpl.isRestored) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("SavedStateRegistry was already restored.");
            return;
        }
        Bundle bundle2 = null;
        if (bundle != null && bundle.containsKey("androidx.lifecycle.BundlableSavedStateRegistry.key")) {
            Bundle bundle3 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            if (bundle3 == null) {
                FileSystemsKt.keyOrValueNotFoundError("androidx.lifecycle.BundlableSavedStateRegistry.key");
                throw null;
            }
            bundle2 = bundle3;
        }
        savedStateRegistryImpl.restoredState = bundle2;
        savedStateRegistryImpl.isRestored = true;
    }

    public final void performSave(Bundle bundle) {
        bundle.getClass();
        SavedStateRegistryImpl savedStateRegistryImpl = this.impl;
        Bundle bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
        Bundle bundle2 = (Bundle) savedStateRegistryImpl.restoredState;
        if (bundle2 != null) {
            bundleBundleOf.putAll(bundle2);
        }
        synchronized (((CueDecoder) savedStateRegistryImpl.lock)) {
            for (Map.Entry entry : ((LinkedHashMap) savedStateRegistryImpl.keyToProviders).entrySet()) {
                String str = (String) entry.getKey();
                Bundle bundleSaveState = ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState();
                str.getClass();
                bundleBundleOf.putBundle(str, bundleSaveState);
            }
        }
        if (bundleBundleOf.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundleBundleOf);
    }
}
