package androidx.lifecycle;

import androidx.lifecycle.viewmodel.MutableCreationExtras;
import kotlin.jvm.internal.ClassReference;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleSupport$savedStateHandlesVM$1 implements ViewModelProvider$Factory {
    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(ClassReference classReference, MutableCreationExtras mutableCreationExtras) {
        return new SavedStateHandlesVM();
    }
}
