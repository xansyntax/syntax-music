package kotlinx.serialization.internal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.UIntArray;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ReferenceArraySerializer extends CollectionLikeSerializer {
    public final ArrayClassDesc descriptor;
    public final KClass kClass;

    public ReferenceArraySerializer(KClass kClass, KSerializer kSerializer) {
        super(kSerializer);
        this.kClass = kClass;
        SerialDescriptor descriptor = kSerializer.getDescriptor();
        descriptor.getClass();
        this.descriptor = new ArrayClassDesc(descriptor, (byte) 0);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int builderSize(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        arrayList.getClass();
        return arrayList.size();
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void checkCapacity(int i, Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        arrayList.getClass();
        arrayList.ensureCapacity(i);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Iterator collectionIterator(Object obj) {
        Object[] objArr = (Object[]) obj;
        objArr.getClass();
        return new UIntArray.Iterator(objArr);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        Object[] objArr = (Object[]) obj;
        objArr.getClass();
        return objArr.length;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public final void insert(int i, Object obj, Object obj2) {
        ArrayList arrayList = (ArrayList) obj;
        arrayList.getClass();
        arrayList.add(i, obj2);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        throw null;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toResult(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        arrayList.getClass();
        Object objNewInstance = Array.newInstance((Class<?>) Okio__OkioKt.getJavaClass(this.kClass), arrayList.size());
        objNewInstance.getClass();
        Object[] array = arrayList.toArray((Object[]) objNewInstance);
        array.getClass();
        return array;
    }
}
