package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ListFieldSchemas {
    public static final ListFieldSchemaLite FULL_SCHEMA;
    public static final ListFieldSchemaLite LITE_SCHEMA;

    static {
        Protobuf protobuf = Protobuf.INSTANCE;
        ListFieldSchemaLite listFieldSchemaLite = null;
        try {
            listFieldSchemaLite = (ListFieldSchemaLite) Class.forName("androidx.datastore.preferences.protobuf.ListFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        FULL_SCHEMA = listFieldSchemaLite;
        LITE_SCHEMA = new ListFieldSchemaLite();
    }
}
