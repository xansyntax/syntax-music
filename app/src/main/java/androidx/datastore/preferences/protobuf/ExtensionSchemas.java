package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ExtensionSchemas {
    public static final ExtensionSchemaLite FULL_SCHEMA;
    public static final ExtensionSchemaLite LITE_SCHEMA = new ExtensionSchemaLite();

    static {
        Protobuf protobuf = Protobuf.INSTANCE;
        ExtensionSchemaLite extensionSchemaLite = null;
        try {
            extensionSchemaLite = (ExtensionSchemaLite) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        FULL_SCHEMA = extensionSchemaLite;
    }
}
