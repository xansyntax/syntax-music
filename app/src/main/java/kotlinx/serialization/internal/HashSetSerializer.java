package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class HashSetSerializer extends CollectionLikeSerializer {
    public final /* synthetic */ byte $r8$classId;
    public final ListLikeDescriptor descriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashSetSerializer(KSerializer kSerializer, byte b) {
        super(kSerializer);
        this.$r8$classId = b;
        kSerializer.getClass();
        switch (b) {
            case 1:
                super(kSerializer);
                SerialDescriptor descriptor = kSerializer.getDescriptor();
                descriptor.getClass();
                this.descriptor = new ArrayClassDesc(descriptor, (byte) 1);
                break;
            case 2:
                super(kSerializer);
                SerialDescriptor descriptor2 = kSerializer.getDescriptor();
                descriptor2.getClass();
                this.descriptor = new ArrayClassDesc(descriptor2, (byte) 3);
                break;
            default:
                SerialDescriptor descriptor3 = kSerializer.getDescriptor();
                descriptor3.getClass();
                this.descriptor = new ArrayClassDesc(descriptor3, (byte) 2);
                break;
        }
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object builder() {
        switch (this.$r8$classId) {
            case 0:
                return new HashSet();
            case 1:
                return new ArrayList();
            default:
                return new LinkedHashSet();
        }
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int builderSize(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                HashSet hashSet = (HashSet) obj;
                hashSet.getClass();
                return hashSet.size();
            case 1:
                ArrayList arrayList = (ArrayList) obj;
                arrayList.getClass();
                return arrayList.size();
            default:
                LinkedHashSet linkedHashSet = (LinkedHashSet) obj;
                linkedHashSet.getClass();
                return linkedHashSet.size();
        }
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void checkCapacity(int i, Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((HashSet) obj).getClass();
                break;
            case 1:
                ArrayList arrayList = (ArrayList) obj;
                arrayList.getClass();
                arrayList.ensureCapacity(i);
                break;
            default:
                ((LinkedHashSet) obj).getClass();
                break;
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        byte b = this.$r8$classId;
        ListLikeDescriptor listLikeDescriptor = this.descriptor;
        switch (b) {
            case 0:
                break;
            case 1:
                break;
        }
        return (ArrayClassDesc) listLikeDescriptor;
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public final void insert(int i, Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                HashSet hashSet = (HashSet) obj;
                hashSet.getClass();
                hashSet.add(obj2);
                break;
            case 1:
                ArrayList arrayList = (ArrayList) obj;
                arrayList.getClass();
                arrayList.add(i, obj2);
                break;
            default:
                LinkedHashSet linkedHashSet = (LinkedHashSet) obj;
                linkedHashSet.getClass();
                linkedHashSet.add(obj2);
                break;
        }
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                throw null;
            case 1:
                throw null;
            default:
                throw null;
        }
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toResult(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                HashSet hashSet = (HashSet) obj;
                hashSet.getClass();
                return hashSet;
            case 1:
                ArrayList arrayList = (ArrayList) obj;
                arrayList.getClass();
                return arrayList;
            default:
                LinkedHashSet linkedHashSet = (LinkedHashSet) obj;
                linkedHashSet.getClass();
                return linkedHashSet;
        }
    }
}
