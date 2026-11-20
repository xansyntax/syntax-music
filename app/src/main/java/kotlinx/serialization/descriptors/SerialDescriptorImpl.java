package kotlinx.serialization.descriptors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.IndexingIterator;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.CachedNames;
import kotlinx.serialization.internal.EnumsKt;
import okio.Okio__OkioKt;
import okio.internal.ResourceFileSystem$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class SerialDescriptorImpl implements SerialDescriptor, CachedNames {
    public final SynchronizedLazyImpl _hashCode$delegate;
    public final List annotations;
    public final List[] elementAnnotations;
    public final SerialDescriptor[] elementDescriptors;
    public final String[] elementNames;
    public final boolean[] elementOptionality;
    public final int elementsCount;
    public final Okio__OkioKt kind;
    public final Map name2Index;
    public final String serialName;
    public final HashSet serialNames;
    public final SerialDescriptor[] typeParametersDescriptors;

    public SerialDescriptorImpl(String str, Okio__OkioKt okio__OkioKt, int i, List list, ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        this.serialName = str;
        this.kind = okio__OkioKt;
        this.elementsCount = i;
        this.annotations = classSerialDescriptorBuilder.annotations;
        ArrayList arrayList = classSerialDescriptorBuilder.elementNames;
        HashSet hashSet = new HashSet(MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 12)));
        CollectionsKt.toCollection(arrayList, hashSet);
        this.serialNames = hashSet;
        byte b = 0;
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        this.elementNames = strArr;
        this.elementDescriptors = EnumsKt.compactArray(classSerialDescriptorBuilder.elementDescriptors);
        this.elementAnnotations = (List[]) classSerialDescriptorBuilder.elementAnnotations.toArray(new List[0]);
        ArrayList arrayList2 = classSerialDescriptorBuilder.elementOptionality;
        boolean[] zArr = new boolean[arrayList2.size()];
        Iterator it = arrayList2.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            zArr[i2] = ((Boolean) it.next()).booleanValue();
            i2++;
        }
        this.elementOptionality = zArr;
        strArr.getClass();
        IndexingIterable indexingIterable = new IndexingIterable(b, new ResourceFileSystem$$ExternalSyntheticLambda0((byte) 1, strArr));
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(indexingIterable, 10));
        Iterator it2 = indexingIterable.iterator();
        while (true) {
            IndexingIterator indexingIterator = (IndexingIterator) it2;
            if (!indexingIterator.iterator.hasNext()) {
                this.name2Index = MapsKt__MapsKt.toMap(arrayList3);
                this.typeParametersDescriptors = EnumsKt.compactArray(list);
                this._hashCode$delegate = new SynchronizedLazyImpl(new ResourceFileSystem$$ExternalSyntheticLambda0((byte) 6, this));
                return;
            }
            IndexedValue indexedValue = (IndexedValue) indexingIterator.next();
            arrayList3.add(new Pair(indexedValue.value, Integer.valueOf(indexedValue.index)));
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SerialDescriptorImpl) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (this.serialName.equals(serialDescriptor.getSerialName()) && Arrays.equals(this.typeParametersDescriptors, ((SerialDescriptorImpl) obj).typeParametersDescriptors)) {
                int elementsCount = serialDescriptor.getElementsCount();
                int i = this.elementsCount;
                if (i == elementsCount) {
                    for (int i2 = 0; i2 < i; i2++) {
                        SerialDescriptor[] serialDescriptorArr = this.elementDescriptors;
                        if (Intrinsics.areEqual(serialDescriptorArr[i2].getSerialName(), serialDescriptor.getElementDescriptor(i2).getSerialName()) && Intrinsics.areEqual(serialDescriptorArr[i2].getKind(), serialDescriptor.getElementDescriptor(i2).getKind())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List getAnnotations() {
        return this.annotations;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List getElementAnnotations(int i) {
        return this.elementAnnotations[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor getElementDescriptor(int i) {
        return this.elementDescriptors[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementIndex(String str) {
        str.getClass();
        Integer num = (Integer) this.name2Index.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getElementName(int i) {
        return this.elementNames[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementsCount() {
        return this.elementsCount;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final Okio__OkioKt getKind() {
        return this.kind;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String getSerialName() {
        return this.serialName;
    }

    @Override // kotlinx.serialization.internal.CachedNames
    public final Set getSerialNames() {
        return this.serialNames;
    }

    public final int hashCode() {
        return ((Number) this._hashCode$delegate.getValue()).intValue();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isElementOptional(int i) {
        return this.elementOptionality[i];
    }

    public final String toString() {
        return EnumsKt.toStringImpl(this);
    }
}
