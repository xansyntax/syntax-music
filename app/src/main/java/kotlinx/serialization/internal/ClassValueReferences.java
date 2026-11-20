package kotlinx.serialization.internal;

import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ClassValueReferences extends ClassValue {
    @Override // java.lang.ClassValue
    public final Object computeValue(Class cls) {
        cls.getClass();
        MutableSoftReference mutableSoftReference = new MutableSoftReference();
        mutableSoftReference.reference = new SoftReference(null);
        return mutableSoftReference;
    }
}
