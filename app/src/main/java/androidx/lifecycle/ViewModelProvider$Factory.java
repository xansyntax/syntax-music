package androidx.lifecycle;

import androidx.lifecycle.viewmodel.MutableCreationExtras;
import kotlin.jvm.internal.ClassReference;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface ViewModelProvider$Factory {
    default ViewModel create(ClassReference classReference, MutableCreationExtras mutableCreationExtras) {
        return create(Okio__OkioKt.getJavaClass(classReference), mutableCreationExtras);
    }

    default ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
        return create(cls);
    }

    default ViewModel create(Class cls) {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }
}
