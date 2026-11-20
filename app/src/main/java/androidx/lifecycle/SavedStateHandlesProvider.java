package androidx.lifecycle;

import android.os.Bundle;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda5;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.savedstate.SavedStateRegistry;
import coil3.util.UtilsKt;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import kotlin.SynchronizedLazyImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {
    public boolean restored;
    public Bundle restoredState;
    public final SavedStateRegistry savedStateRegistry;
    public final SynchronizedLazyImpl viewModel$delegate;

    public SavedStateHandlesProvider(SavedStateRegistry savedStateRegistry, ViewModelStoreOwner viewModelStoreOwner) {
        savedStateRegistry.getClass();
        this.savedStateRegistry = savedStateRegistry;
        this.viewModel$delegate = new SynchronizedLazyImpl(new RoomDatabase$$ExternalSyntheticLambda0((byte) 22, viewModelStoreOwner));
    }

    public final void performRestore() {
        if (this.restored) {
            return;
        }
        Bundle bundleConsumeRestoredStateForKey = this.savedStateRegistry.consumeRestoredStateForKey("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            bundleBundleOf.putAll(bundle);
        }
        if (bundleConsumeRestoredStateForKey != null) {
            bundleBundleOf.putAll(bundleConsumeRestoredStateForKey);
        }
        this.restoredState = bundleBundleOf;
        this.restored = true;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        Bundle bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            bundleBundleOf.putAll(bundle);
        }
        for (Map.Entry entry : ((SavedStateHandlesVM) this.viewModel$delegate.getValue()).handles.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleSaveState = ((ComponentActivity$$ExternalSyntheticLambda5) ((SavedStateHandle) entry.getValue()).impl.extras).saveState();
            if (!bundleSaveState.isEmpty()) {
                str.getClass();
                bundleBundleOf.putBundle(str, bundleSaveState);
            }
        }
        this.restored = false;
        return bundleBundleOf;
    }
}
