package com.google.protobuf;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.input.GapBuffer;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MessageSetSchema implements Schema {
    public final MessageLite defaultInstance;
    public final ExtensionSchemaLite unknownFieldSchema;

    public MessageSetSchema(ExtensionSchemaLite extensionSchemaLite, MessageLite messageLite) {
        this.unknownFieldSchema = extensionSchemaLite;
        this.defaultInstance = messageLite;
    }

    @Override // com.google.protobuf.Schema
    public final boolean equals(GeneratedMessageLite generatedMessageLite, GeneratedMessageLite generatedMessageLite2) {
        this.unknownFieldSchema.getClass();
        return generatedMessageLite.unknownFields.equals(generatedMessageLite2.unknownFields);
    }

    @Override // com.google.protobuf.Schema
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
            iComputeBytesSize += CodedOutputStream.computeBytesSize(3, (ByteString) unknownFieldSetLite.objects[i2]) + CodedOutputStream.computeUInt32SizeNoTag(i3) + CodedOutputStream.computeTagSize(2) + (CodedOutputStream.computeTagSize(1) * 2);
        }
        unknownFieldSetLite.memoizedSerializedSize = iComputeBytesSize;
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.Schema
    public final int hashCode(GeneratedMessageLite generatedMessageLite) {
        this.unknownFieldSchema.getClass();
        return generatedMessageLite.unknownFields.hashCode();
    }

    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(Object obj) {
        Fragment$5$$ExternalSyntheticOutline0.m833m(obj);
        throw null;
    }

    @Override // com.google.protobuf.Schema
    public final void makeImmutable(Object obj) {
        this.unknownFieldSchema.getClass();
        UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite) obj).unknownFields;
        if (unknownFieldSetLite.isMutable) {
            unknownFieldSetLite.isMutable = false;
        }
        Fragment$5$$ExternalSyntheticOutline0.m833m(obj);
        throw null;
    }

    @Override // com.google.protobuf.Schema
    public final void mergeFrom(Object obj, byte[] bArr, int i, int i2, ArrayDecoders$Registers arrayDecoders$Registers) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        if (generatedMessageLite.unknownFields == UnknownFieldSetLite.DEFAULT_INSTANCE) {
            generatedMessageLite.unknownFields = new UnknownFieldSetLite();
        }
        throw IntIntPair$$ExternalSyntheticOutline0.m(obj);
    }

    @Override // com.google.protobuf.Schema
    public final Object newInstance() {
        MessageLite messageLite = this.defaultInstance;
        return messageLite instanceof GeneratedMessageLite ? ((GeneratedMessageLite) messageLite).newMutableInstance() : messageLite.newBuilderForType().buildPartial();
    }

    @Override // com.google.protobuf.Schema
    public final void writeTo(Object obj, ConnectionPool connectionPool) {
        Fragment$5$$ExternalSyntheticOutline0.m833m(obj);
        throw null;
    }

    @Override // com.google.protobuf.Schema
    public final void mergeFrom(Object obj, Object obj2) {
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, obj, obj2);
    }

    @Override // com.google.protobuf.Schema
    public final void mergeFrom(Object obj, GapBuffer gapBuffer, ExtensionRegistryLite extensionRegistryLite) {
        this.unknownFieldSchema.getClass();
        ExtensionSchemaLite.getBuilderFromMessage(obj);
        obj.getClass();
        throw new ClassCastException();
    }
}
