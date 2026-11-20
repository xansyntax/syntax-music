package androidx.datastore.preferences.protobuf;

import androidx.compose.ui.text.input.GapBuffer;
import kotlinx.serialization.json.internal.CharArrayPoolBase;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class UnknownFieldSetLiteSchema {
    public static UnknownFieldSetLite getBuilderFromMessage(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.DEFAULT_INSTANCE) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLite2 = new UnknownFieldSetLite(0, new int[8], new Object[8], true);
        generatedMessageLite.unknownFields = unknownFieldSetLite2;
        return unknownFieldSetLite2;
    }

    public static boolean mergeOneFieldFrom(int i, GapBuffer gapBuffer, Object obj) throws com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException, InvalidProtocolBufferException {
        int i2 = gapBuffer.capacity;
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) gapBuffer.buffer;
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            gapBuffer.requireWireType(0);
            ((UnknownFieldSetLite) obj).storeField(i3 << 3, Long.valueOf(charArrayPoolBase.readInt64()));
            return true;
        }
        if (i4 == 1) {
            gapBuffer.requireWireType(1);
            ((UnknownFieldSetLite) obj).storeField((i3 << 3) | 1, Long.valueOf(charArrayPoolBase.readFixed64()));
            return true;
        }
        if (i4 == 2) {
            ((UnknownFieldSetLite) obj).storeField((i3 << 3) | 2, gapBuffer.readBytes());
            return true;
        }
        if (i4 != 3) {
            if (i4 == 4) {
                return false;
            }
            if (i4 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            gapBuffer.requireWireType(5);
            ((UnknownFieldSetLite) obj).storeField(5 | (i3 << 3), Integer.valueOf(charArrayPoolBase.readFixed32()));
            return true;
        }
        UnknownFieldSetLite unknownFieldSetLite = new UnknownFieldSetLite(0, new int[8], new Object[8], true);
        int i5 = i3 << 3;
        int i6 = i5 | 4;
        int i7 = i + 1;
        if (i7 >= 100) {
            throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (gapBuffer.getFieldNumber() != Integer.MAX_VALUE && mergeOneFieldFrom(i7, gapBuffer, unknownFieldSetLite)) {
        }
        if (i6 != gapBuffer.capacity) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
        if (unknownFieldSetLite.isMutable) {
            unknownFieldSetLite.isMutable = false;
        }
        ((UnknownFieldSetLite) obj).storeField(i5 | 3, unknownFieldSetLite);
        return true;
    }
}
