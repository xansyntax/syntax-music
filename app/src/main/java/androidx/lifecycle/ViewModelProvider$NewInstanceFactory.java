package androidx.lifecycle;

import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.sqlite.SQLite;
import kotlin.jvm.internal.ClassReference;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ViewModelProvider$NewInstanceFactory implements ViewModelProvider$Factory {
    public static ViewModelProvider$NewInstanceFactory _instance;

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(ClassReference classReference, MutableCreationExtras mutableCreationExtras) {
        return create(Okio__OkioKt.getJavaClass(classReference), mutableCreationExtras);
    }

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
        return create(cls);
    }

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public ViewModel create(Class cls) {
        return SQLite.createViewModel(cls);
    }
}
