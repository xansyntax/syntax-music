package androidx.navigation.compose;

import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.WeakReference;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BackStackEntryIdViewModel extends ViewModel {
    public final String id;
    public WeakReference saveableStateHolderRef;

    public BackStackEntryIdViewModel(SavedStateHandle savedStateHandle) {
        String string = (String) savedStateHandle.get("SaveableStateHolder_BackStackEntryKey");
        if (string == null) {
            string = UUID.randomUUID().toString();
            savedStateHandle.set(string, "SaveableStateHolder_BackStackEntryKey");
        }
        this.id = string;
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        WeakReference weakReference = this.saveableStateHolderRef;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveableStateHolderRef");
            throw null;
        }
        SaveableStateHolder saveableStateHolder = (SaveableStateHolder) weakReference.delegate.get();
        if (saveableStateHolder != null) {
            saveableStateHolder.removeState(this.id);
        }
        WeakReference weakReference2 = this.saveableStateHolderRef;
        if (weakReference2 != null) {
            weakReference2.delegate.clear();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("saveableStateHolderRef");
            throw null;
        }
    }
}
