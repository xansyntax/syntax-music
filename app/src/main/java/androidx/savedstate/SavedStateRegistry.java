package androidx.savedstate;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LegacySavedStateHandleController$OnRecreation;
import androidx.media3.extractor.text.CueDecoder;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import coil3.util.FileSystemsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateRegistry {
    public final SavedStateRegistryImpl impl;
    public AppCompatActivity.AnonymousClass1 recreatorProvider;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface AutoRecreated {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface SavedStateProvider {
        Bundle saveState();
    }

    public SavedStateRegistry(SavedStateRegistryImpl savedStateRegistryImpl) {
        this.impl = savedStateRegistryImpl;
    }

    public final Bundle consumeRestoredStateForKey(String str) {
        Bundle bundle;
        SavedStateRegistryImpl savedStateRegistryImpl = this.impl;
        if (!savedStateRegistryImpl.isRestored) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state");
            return null;
        }
        Bundle bundle2 = (Bundle) savedStateRegistryImpl.restoredState;
        if (bundle2 == null) {
            return null;
        }
        if (bundle2.containsKey(str)) {
            bundle = bundle2.getBundle(str);
            if (bundle == null) {
                FileSystemsKt.keyOrValueNotFoundError(str);
                throw null;
            }
        } else {
            bundle = null;
        }
        bundle2.remove(str);
        if (bundle2.isEmpty()) {
            savedStateRegistryImpl.restoredState = null;
        }
        return bundle;
    }

    public final SavedStateProvider getSavedStateProvider(String str) {
        SavedStateProvider savedStateProvider;
        SavedStateRegistryImpl savedStateRegistryImpl = this.impl;
        synchronized (((CueDecoder) savedStateRegistryImpl.lock)) {
            Iterator it = ((LinkedHashMap) savedStateRegistryImpl.keyToProviders).entrySet().iterator();
            do {
                savedStateProvider = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str2 = (String) entry.getKey();
                SavedStateProvider savedStateProvider2 = (SavedStateProvider) entry.getValue();
                if (Intrinsics.areEqual(str2, str)) {
                    savedStateProvider = savedStateProvider2;
                }
            } while (savedStateProvider == null);
        }
        return savedStateProvider;
    }

    public final void registerSavedStateProvider(String str, SavedStateProvider savedStateProvider) {
        SavedStateRegistryImpl savedStateRegistryImpl = this.impl;
        synchronized (((CueDecoder) savedStateRegistryImpl.lock)) {
            if (((LinkedHashMap) savedStateRegistryImpl.keyToProviders).containsKey(str)) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
            ((LinkedHashMap) savedStateRegistryImpl.keyToProviders).put(str, savedStateProvider);
        }
    }

    public final void runOnNextRecreation() {
        if (!this.impl.isAllowingSavingState) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Can not perform this action after onSaveInstanceState");
            return;
        }
        AppCompatActivity.AnonymousClass1 anonymousClass1 = this.recreatorProvider;
        if (anonymousClass1 == null) {
            anonymousClass1 = new AppCompatActivity.AnonymousClass1(this);
        }
        this.recreatorProvider = anonymousClass1;
        try {
            LegacySavedStateHandleController$OnRecreation.class.getDeclaredConstructor(null);
            AppCompatActivity.AnonymousClass1 anonymousClass2 = this.recreatorProvider;
            if (anonymousClass2 != null) {
                ((LinkedHashSet) anonymousClass2.this$0).add(LegacySavedStateHandleController$OnRecreation.class.getName());
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + LegacySavedStateHandleController$OnRecreation.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }
}
