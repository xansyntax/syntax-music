package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MapFieldSchemaLite {
    public static MapFieldLite mergeFrom(Object obj, Object obj2) {
        MapFieldLite mapFieldLiteMutableCopy = (MapFieldLite) obj;
        MapFieldLite mapFieldLite = (MapFieldLite) obj2;
        if (!mapFieldLite.isEmpty()) {
            if (!mapFieldLiteMutableCopy.isMutable) {
                mapFieldLiteMutableCopy = mapFieldLiteMutableCopy.mutableCopy();
            }
            mapFieldLiteMutableCopy.ensureMutable();
            if (!mapFieldLite.isEmpty()) {
                mapFieldLiteMutableCopy.putAll(mapFieldLite);
            }
        }
        return mapFieldLiteMutableCopy;
    }
}
