package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ListFieldSchemaLite {
    public static Internal.ProtobufList mutableListAt(long j, Object obj) {
        Internal.ProtobufList protobufList = (Internal.ProtobufList) UnsafeUtil.getObject(j, obj);
        if (((ProtobufArrayList) protobufList).isMutable) {
            return protobufList;
        }
        ProtobufArrayList protobufArrayList = (ProtobufArrayList) protobufList;
        int i = protobufArrayList.size;
        ProtobufArrayList protobufArrayListMutableCopyWithCapacity = protobufArrayList.mutableCopyWithCapacity(i == 0 ? 10 : i * 2);
        UnsafeUtil.putObject(obj, j, protobufArrayListMutableCopyWithCapacity);
        return protobufArrayListMutableCopyWithCapacity;
    }
}
