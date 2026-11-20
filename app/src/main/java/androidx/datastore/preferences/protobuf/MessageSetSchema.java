package androidx.datastore.preferences.protobuf;

import androidx.compose.ui.text.input.GapBuffer;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MessageSetSchema implements Schema {
    public final AbstractMessageLite defaultInstance;
    public final ExtensionSchemaLite extensionSchema;
    public final UnknownFieldSetLiteSchema unknownFieldSchema;

    public MessageSetSchema(UnknownFieldSetLiteSchema unknownFieldSetLiteSchema, ExtensionSchemaLite extensionSchemaLite, AbstractMessageLite abstractMessageLite) {
        this.unknownFieldSchema = unknownFieldSetLiteSchema;
        extensionSchemaLite.getClass();
        this.extensionSchema = extensionSchemaLite;
        this.defaultInstance = abstractMessageLite;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final boolean equals(GeneratedMessageLite generatedMessageLite, GeneratedMessageLite generatedMessageLite2) {
        this.unknownFieldSchema.getClass();
        return generatedMessageLite.unknownFields.equals(generatedMessageLite2.unknownFields);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final int getSerializedSize(GeneratedMessageLite generatedMessageLite) {
        this.unknownFieldSchema.getClass();
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        int i = unknownFieldSetLite.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeBytesSize = 0;
        for (int i2 = 0; i2 < unknownFieldSetLite.count; i2++) {
            int i3 = unknownFieldSetLite.tags[i2] >>> 3;
            iComputeBytesSize += CodedOutputStream$OutputStreamEncoder.computeBytesSize(3, (ByteString$LiteralByteString) unknownFieldSetLite.objects[i2]) + CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(i3) + CodedOutputStream$OutputStreamEncoder.computeTagSize(2) + (CodedOutputStream$OutputStreamEncoder.computeTagSize(1) * 2);
        }
        unknownFieldSetLite.memoizedSerializedSize = iComputeBytesSize;
        return iComputeBytesSize;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final int hashCode(GeneratedMessageLite generatedMessageLite) {
        this.unknownFieldSchema.getClass();
        return generatedMessageLite.unknownFields.hashCode();
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final boolean isInitialized(Object obj) {
        this.extensionSchema.getClass();
        Fragment$5$$ExternalSyntheticOutline0.m833m(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final void makeImmutable(Object obj) {
        this.unknownFieldSchema.getClass();
        UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite) obj).unknownFields;
        if (unknownFieldSetLite.isMutable) {
            unknownFieldSetLite.isMutable = false;
        }
        this.extensionSchema.getClass();
        Fragment$5$$ExternalSyntheticOutline0.m833m(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final void mergeFrom(Object obj, GapBuffer gapBuffer, ExtensionRegistryLite extensionRegistryLite) {
        this.unknownFieldSchema.getClass();
        UnknownFieldSetLiteSchema.getBuilderFromMessage(obj);
        this.extensionSchema.getClass();
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final GeneratedMessageLite newInstance() {
        AbstractMessageLite abstractMessageLite = this.defaultInstance;
        return abstractMessageLite instanceof GeneratedMessageLite ? ((GeneratedMessageLite) abstractMessageLite).newMutableInstance$1() : ((GeneratedMessageLite.Builder) ((GeneratedMessageLite) abstractMessageLite).dynamicMethod(5)).buildPartial();
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final void writeTo(Object obj, ManifestSchemaFactory manifestSchemaFactory) {
        this.extensionSchema.getClass();
        Fragment$5$$ExternalSyntheticOutline0.m833m(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final void mergeFrom(Object obj, Object obj2) {
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, obj, obj2);
    }
}
