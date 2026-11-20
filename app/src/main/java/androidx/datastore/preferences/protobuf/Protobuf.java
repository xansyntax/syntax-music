package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Protobuf {
    public static final Protobuf INSTANCE = new Protobuf();
    public final ConcurrentHashMap schemaCache = new ConcurrentHashMap();
    public final ManifestSchemaFactory schemaFactory = new ManifestSchemaFactory();

    public final Schema schemaFor(Class cls) {
        ExtensionSchemaLite extensionSchemaLite;
        Schema schemaNewSchema;
        Class cls2;
        Internal.checkNotNull(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.schemaCache;
        Schema schema = (Schema) concurrentHashMap.get(cls);
        if (schema != null) {
            return schema;
        }
        Class cls3 = SchemaUtil.GENERATED_MESSAGE_CLASS;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = SchemaUtil.GENERATED_MESSAGE_CLASS) != null && !cls2.isAssignableFrom(cls)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            return null;
        }
        RawMessageInfo rawMessageInfoMessageInfoFor = ((ManifestSchemaFactory.CompositeMessageInfoFactory) this.schemaFactory.messageInfoFactory).messageInfoFor(cls);
        if ((rawMessageInfoMessageInfoFor.flags & 2) == 2) {
            if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
                schemaNewSchema = new MessageSetSchema(SchemaUtil.UNKNOWN_FIELD_SET_LITE_SCHEMA, ExtensionSchemas.LITE_SCHEMA, rawMessageInfoMessageInfoFor.defaultInstance);
            } else {
                UnknownFieldSetLiteSchema unknownFieldSetLiteSchema = SchemaUtil.UNKNOWN_FIELD_SET_FULL_SCHEMA;
                ExtensionSchemaLite extensionSchemaLite2 = ExtensionSchemas.FULL_SCHEMA;
                if (extensionSchemaLite2 == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Protobuf runtime is not correctly loaded.");
                    return null;
                }
                schemaNewSchema = new MessageSetSchema(unknownFieldSetLiteSchema, extensionSchemaLite2, rawMessageInfoMessageInfoFor.defaultInstance);
            }
        } else if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            schemaNewSchema = MessageSchema.newSchema(rawMessageInfoMessageInfoFor, NewInstanceSchemas.LITE_SCHEMA, ListFieldSchemas.LITE_SCHEMA, SchemaUtil.UNKNOWN_FIELD_SET_LITE_SCHEMA, PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility.ordinal(rawMessageInfoMessageInfoFor.getSyntax()) != 1 ? ExtensionSchemas.LITE_SCHEMA : null, MapFieldSchemas.LITE_SCHEMA);
        } else {
            NewInstanceSchemaLite newInstanceSchemaLite = NewInstanceSchemas.FULL_SCHEMA;
            ListFieldSchemaLite listFieldSchemaLite = ListFieldSchemas.FULL_SCHEMA;
            UnknownFieldSetLiteSchema unknownFieldSetLiteSchema2 = SchemaUtil.UNKNOWN_FIELD_SET_FULL_SCHEMA;
            if (PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility.ordinal(rawMessageInfoMessageInfoFor.getSyntax()) != 1) {
                ExtensionSchemaLite extensionSchemaLite3 = ExtensionSchemas.FULL_SCHEMA;
                if (extensionSchemaLite3 == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Protobuf runtime is not correctly loaded.");
                    return null;
                }
                extensionSchemaLite = extensionSchemaLite3;
            } else {
                extensionSchemaLite = null;
            }
            schemaNewSchema = MessageSchema.newSchema(rawMessageInfoMessageInfoFor, newInstanceSchemaLite, listFieldSchemaLite, unknownFieldSetLiteSchema2, extensionSchemaLite, MapFieldSchemas.FULL_SCHEMA);
        }
        Schema schema2 = (Schema) concurrentHashMap.putIfAbsent(cls, schemaNewSchema);
        return schema2 != null ? schema2 : schemaNewSchema;
    }
}
