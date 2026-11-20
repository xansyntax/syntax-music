package com.google.protobuf;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.input.GapBuffer;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.ConnectionPool;
import okio.Path$$ExternalSyntheticBUOutline0;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MessageSchema implements Schema {
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    public static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();
    public final int[] buffer;
    public final int checkInitializedCount;
    public final MessageLite defaultInstance;
    public final int[] intArray;
    public final boolean lite;
    public final int maxFieldNumber;
    public final int minFieldNumber;
    public final Object[] objects;
    public final int oneofFieldPositionsStart;
    public final ExtensionSchemaLite unknownFieldSchema;

    public MessageSchema(int[] iArr, Object[] objArr, int i, int i2, MessageLite messageLite, int[] iArr2, int i3, int i4, ExtensionSchemaLite extensionSchemaLite, ExtensionSchemaLite extensionSchemaLite2) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i;
        this.maxFieldNumber = i2;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.intArray = iArr2;
        this.checkInitializedCount = i3;
        this.oneofFieldPositionsStart = i4;
        this.unknownFieldSchema = extensionSchemaLite;
        this.defaultInstance = messageLite;
    }

    public static void checkMutable(Object obj) {
        if (isMutable(obj)) {
            return;
        }
        PathKt$$ExternalSyntheticBUOutline0.m$3(obj, "Mutating immutable message: ");
    }

    public static boolean isMutable(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    public static long offset(int i) {
        return i & 1048575;
    }

    public static int oneofIntAt(long j, Object obj) {
        return ((Integer) UnsafeUtil.getObject(j, obj)).intValue();
    }

    public static long oneofLongAt(long j, Object obj) {
        return ((Long) UnsafeUtil.getObject(j, obj)).longValue();
    }

    public static Field reflectField(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("Field ", str, " for ");
            sbM4m.append(cls.getName());
            sbM4m.append(" not found. Known fields are ");
            sbM4m.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbM4m.toString(), e);
        }
    }

    public static int type(int i) {
        return (i & 267386880) >>> 20;
    }

    public final boolean arePresentForEquals(GeneratedMessageLite generatedMessageLite, GeneratedMessageLite generatedMessageLite2, int i) {
        return isFieldPresent(i, generatedMessageLite) == isFieldPresent(i, generatedMessageLite2);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0044  */
    @Override // com.google.protobuf.Schema
    public final boolean equals(GeneratedMessageLite generatedMessageLite, GeneratedMessageLite generatedMessageLite2) {
        int[] iArr = this.buffer;
        int length = iArr.length;
        int i = 0;
        while (true) {
            boolean zSafeEquals = true;
            if (i < length) {
                int iTypeAndOffsetAt = typeAndOffsetAt(i);
                int iType = type(iTypeAndOffsetAt);
                if (iType <= 50 || iType >= 69) {
                    long j = iTypeAndOffsetAt & 1048575;
                    switch (iType) {
                        case 0:
                            if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i)) {
                                zSafeEquals = false;
                            } else {
                                UnsafeUtil.MemoryAccessor memoryAccessor = UnsafeUtil.MEMORY_ACCESSOR;
                                if (Double.doubleToLongBits(memoryAccessor.getDouble(j, generatedMessageLite)) != Double.doubleToLongBits(memoryAccessor.getDouble(j, generatedMessageLite2))) {
                                    zSafeEquals = false;
                                }
                            }
                            break;
                        case 1:
                            if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i)) {
                                zSafeEquals = false;
                            } else {
                                UnsafeUtil.MemoryAccessor memoryAccessor2 = UnsafeUtil.MEMORY_ACCESSOR;
                                if (Float.floatToIntBits(memoryAccessor2.getFloat(j, generatedMessageLite)) != Float.floatToIntBits(memoryAccessor2.getFloat(j, generatedMessageLite2))) {
                                    zSafeEquals = false;
                                }
                            }
                            break;
                        case 2:
                            if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getLong(j, generatedMessageLite) != UnsafeUtil.getLong(j, generatedMessageLite2)) {
                                zSafeEquals = false;
                            }
                            break;
                        case 3:
                            if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getLong(j, generatedMessageLite) != UnsafeUtil.getLong(j, generatedMessageLite2)) {
                                zSafeEquals = false;
                            }
                            break;
                        case 4:
                            if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getInt(j, generatedMessageLite) != UnsafeUtil.getInt(j, generatedMessageLite2)) {
                                zSafeEquals = false;
                            }
                            break;
                        case 5:
                            if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getLong(j, generatedMessageLite) != UnsafeUtil.getLong(j, generatedMessageLite2)) {
                                zSafeEquals = false;
                            }
                            break;
                        case 6:
                            if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getInt(j, generatedMessageLite) != UnsafeUtil.getInt(j, generatedMessageLite2)) {
                                zSafeEquals = false;
                            }
                            break;
                        case 7:
                            if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i)) {
                                zSafeEquals = false;
                            } else {
                                UnsafeUtil.MemoryAccessor memoryAccessor3 = UnsafeUtil.MEMORY_ACCESSOR;
                                if (memoryAccessor3.getBoolean(j, generatedMessageLite) != memoryAccessor3.getBoolean(j, generatedMessageLite2)) {
                                    zSafeEquals = false;
                                }
                            }
                            break;
                        case 8:
                            if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(j, generatedMessageLite), UnsafeUtil.getObject(j, generatedMessageLite2))) {
                                zSafeEquals = false;
                            }
                            break;
                        case 9:
                            if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(j, generatedMessageLite), UnsafeUtil.getObject(j, generatedMessageLite2))) {
                                zSafeEquals = false;
                            }
                            break;
                        case 10:
                            if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(j, generatedMessageLite), UnsafeUtil.getObject(j, generatedMessageLite2))) {
                                zSafeEquals = false;
                            }
                            break;
                        case 11:
                            if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getInt(j, generatedMessageLite) != UnsafeUtil.getInt(j, generatedMessageLite2)) {
                                zSafeEquals = false;
                            }
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getInt(j, generatedMessageLite) != UnsafeUtil.getInt(j, generatedMessageLite2)) {
                                zSafeEquals = false;
                            }
                            break;
                        case 13:
                            if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getInt(j, generatedMessageLite) != UnsafeUtil.getInt(j, generatedMessageLite2)) {
                                zSafeEquals = false;
                            }
                            break;
                        case 14:
                            if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getLong(j, generatedMessageLite) != UnsafeUtil.getLong(j, generatedMessageLite2)) {
                                zSafeEquals = false;
                            }
                            break;
                        case 15:
                            if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getInt(j, generatedMessageLite) != UnsafeUtil.getInt(j, generatedMessageLite2)) {
                                zSafeEquals = false;
                            }
                            break;
                        case 16:
                            if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || UnsafeUtil.getLong(j, generatedMessageLite) != UnsafeUtil.getLong(j, generatedMessageLite2)) {
                                zSafeEquals = false;
                            }
                            break;
                        case 17:
                            if (!arePresentForEquals(generatedMessageLite, generatedMessageLite2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(j, generatedMessageLite), UnsafeUtil.getObject(j, generatedMessageLite2))) {
                                zSafeEquals = false;
                            }
                            break;
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            zSafeEquals = SchemaUtil.safeEquals(UnsafeUtil.getObject(j, generatedMessageLite), UnsafeUtil.getObject(j, generatedMessageLite2));
                            break;
                        case 50:
                            zSafeEquals = SchemaUtil.safeEquals(UnsafeUtil.getObject(j, generatedMessageLite), UnsafeUtil.getObject(j, generatedMessageLite2));
                            break;
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                        case 68:
                            long j2 = 1048575 & iArr[i + 2];
                            if (UnsafeUtil.getInt(j2, generatedMessageLite) != UnsafeUtil.getInt(j2, generatedMessageLite2) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(j, generatedMessageLite), UnsafeUtil.getObject(j, generatedMessageLite2))) {
                                zSafeEquals = false;
                            }
                            break;
                    }
                    if (!zSafeEquals) {
                    }
                }
                i += 3;
            } else {
                int i2 = this.oneofFieldPositionsStart;
                while (true) {
                    int[] iArr2 = this.intArray;
                    if (i2 < iArr2.length) {
                        int i3 = iArr2[i2];
                        long j3 = iArr[i3 + 2] & 1048575;
                        if (UnsafeUtil.getInt(j3, generatedMessageLite) != UnsafeUtil.getInt(j3, generatedMessageLite2)) {
                            return false;
                        }
                        if (!isOneofPresent(0, i3, generatedMessageLite)) {
                            long jTypeAndOffsetAt = typeAndOffsetAt(i3) & 1048575;
                            if (!SchemaUtil.safeEquals(UnsafeUtil.getObject(jTypeAndOffsetAt, generatedMessageLite), UnsafeUtil.getObject(jTypeAndOffsetAt, generatedMessageLite2))) {
                            }
                        }
                        i2++;
                    } else {
                        this.unknownFieldSchema.getClass();
                        if (generatedMessageLite.unknownFields.equals(generatedMessageLite2.unknownFields)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void filterMapUnknownEnumValues(int i, Object obj, Object obj2) {
        int i2 = this.buffer[i];
        if (UnsafeUtil.getObject(typeAndOffsetAt(i) & 1048575, obj) == null) {
            return;
        }
        getEnumFieldVerifier(i);
    }

    public final void getEnumFieldVerifier(int i) {
        if (this.objects[((i / 3) * 2) + 1] == null) {
            return;
        }
        PathKt$$ExternalSyntheticBUOutline0.m();
    }

    public final Object getMapFieldDefaultEntry(int i) {
        return this.objects[(i / 3) * 2];
    }

    public final Schema getMessageFieldSchema(int i) {
        int i2 = (i / 3) * 2;
        Object[] objArr = this.objects;
        Schema schema = (Schema) objArr[i2];
        if (schema != null) {
            return schema;
        }
        Schema schemaSchemaFor = Protobuf.INSTANCE.schemaFor((Class) objArr[i2 + 1]);
        objArr[i2] = schemaSchemaFor;
        return schemaSchemaFor;
    }

    /* JADX WARN: Code duplicated, block: B:148:0x0376  */
    @Override // com.google.protobuf.Schema
    public final int getSerializedSize(GeneratedMessageLite generatedMessageLite) {
        int i;
        int iComputeTagSize;
        int iComputeTagSize2;
        int iComputeTagSize3;
        int iComputeUInt64SizeNoTag;
        int iComputeTagSize4;
        int iComputeUInt64SizeNoTag2;
        int iComputeTagSize5;
        int iComputeTagSize6;
        int iComputeTagSize7;
        int serializedSize;
        int iComputeUInt32SizeNoTag;
        int iComputeBytesSize;
        int iComputeTagSize8;
        int serializedSize2;
        int iComputeSizeFixed64List;
        int iComputeTagSize9;
        int size;
        int iComputeSizeUInt64ListNoTag;
        int iComputeTagSize10;
        int iEncodedLength;
        int iComputeUInt32SizeNoTag2;
        int iComputeTagSize11;
        int size2;
        int iComputeTagSize12;
        int iComputeUInt32SizeNoTag3;
        int serializedSize3;
        int iComputeTagSize13;
        int iComputeTagSize14;
        int iComputeUInt64SizeNoTag3;
        int iComputeTagSize15;
        int iComputeUInt64SizeNoTag4;
        int i2;
        MessageSchema messageSchema = this;
        GeneratedMessageLite generatedMessageLite2 = generatedMessageLite;
        int i3 = 0;
        int i4 = 0;
        int iComputeUInt32SizeNoTag4 = 0;
        int i5 = 1048575;
        while (true) {
            int[] iArr = messageSchema.buffer;
            if (i3 >= iArr.length) {
                messageSchema.unknownFieldSchema.getClass();
                return generatedMessageLite2.unknownFields.getSerializedSize() + iComputeUInt32SizeNoTag4;
            }
            int iTypeAndOffsetAt = messageSchema.typeAndOffsetAt(i3);
            int iType = type(iTypeAndOffsetAt);
            int i6 = iArr[i3];
            int i7 = iArr[i3 + 2];
            int i8 = i7 & 1048575;
            Unsafe unsafe = UNSAFE;
            if (iType <= 17) {
                if (i8 != i5) {
                    i4 = i8 == 1048575 ? 0 : unsafe.getInt(generatedMessageLite2, i8);
                    i5 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            long j = iTypeAndOffsetAt & 1048575;
            if (iType >= FieldType.DOUBLE_LIST_PACKED.id) {
                byte b = FieldType.SINT64_LIST_PACKED.id;
            }
            switch (iType) {
                case 0:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        iComputeTagSize = CodedOutputStream.computeTagSize(i6);
                        iComputeSizeFixed64List = iComputeTagSize + 8;
                        iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    }
                    i3 += 3;
                    break;
                case 1:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        iComputeTagSize2 = CodedOutputStream.computeTagSize(i6);
                        iComputeTagSize6 = iComputeTagSize2 + 4;
                        iComputeUInt32SizeNoTag4 += iComputeTagSize6;
                    }
                    messageSchema = this;
                    generatedMessageLite2 = generatedMessageLite;
                    i3 += 3;
                    break;
                case 2:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        long j2 = unsafe.getLong(generatedMessageLite2, j);
                        iComputeTagSize3 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt64SizeNoTag = CodedOutputStream.computeUInt64SizeNoTag(j2);
                        iComputeUInt32SizeNoTag4 += iComputeUInt64SizeNoTag + iComputeTagSize3;
                    }
                    messageSchema = this;
                    i3 += 3;
                    break;
                case 3:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        long j3 = unsafe.getLong(generatedMessageLite2, j);
                        iComputeTagSize3 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt64SizeNoTag = CodedOutputStream.computeUInt64SizeNoTag(j3);
                        iComputeUInt32SizeNoTag4 += iComputeUInt64SizeNoTag + iComputeTagSize3;
                    }
                    messageSchema = this;
                    i3 += 3;
                    break;
                case 4:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        int i9 = unsafe.getInt(generatedMessageLite2, j);
                        iComputeTagSize4 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt64SizeNoTag2 = CodedOutputStream.computeUInt64SizeNoTag(i9);
                        iComputeBytesSize = iComputeUInt64SizeNoTag2 + iComputeTagSize4;
                        iComputeUInt32SizeNoTag4 += iComputeBytesSize;
                    }
                    messageSchema = this;
                    i3 += 3;
                    break;
                case 5:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        iComputeTagSize5 = CodedOutputStream.computeTagSize(i6);
                        iComputeTagSize6 = iComputeTagSize5 + 8;
                        iComputeUInt32SizeNoTag4 += iComputeTagSize6;
                    }
                    messageSchema = this;
                    generatedMessageLite2 = generatedMessageLite;
                    i3 += 3;
                    break;
                case 6:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        iComputeTagSize2 = CodedOutputStream.computeTagSize(i6);
                        iComputeTagSize6 = iComputeTagSize2 + 4;
                        iComputeUInt32SizeNoTag4 += iComputeTagSize6;
                    }
                    messageSchema = this;
                    generatedMessageLite2 = generatedMessageLite;
                    i3 += 3;
                    break;
                case 7:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        iComputeTagSize6 = CodedOutputStream.computeTagSize(i6) + 1;
                        iComputeUInt32SizeNoTag4 += iComputeTagSize6;
                    }
                    messageSchema = this;
                    generatedMessageLite2 = generatedMessageLite;
                    i3 += 3;
                    break;
                case 8:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        Object object = unsafe.getObject(generatedMessageLite2, j);
                        if (object instanceof ByteString) {
                            iComputeUInt32SizeNoTag4 = CodedOutputStream.computeBytesSize(i6, (ByteString) object) + iComputeUInt32SizeNoTag4;
                        } else {
                            int iComputeTagSize16 = CodedOutputStream.computeTagSize(i6);
                            int iEncodedLength2 = Utf8.processor.encodedLength((String) object);
                            iComputeUInt32SizeNoTag4 = CodedOutputStream.computeUInt32SizeNoTag(iEncodedLength2) + iEncodedLength2 + iComputeTagSize16 + iComputeUInt32SizeNoTag4;
                        }
                    }
                    messageSchema = this;
                    i3 += 3;
                    break;
                case 9:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        Object object2 = unsafe.getObject(generatedMessageLite2, j);
                        Schema messageFieldSchema = messageSchema.getMessageFieldSchema(i3);
                        Class cls = SchemaUtil.GENERATED_MESSAGE_CLASS;
                        iComputeTagSize7 = CodedOutputStream.computeTagSize(i6);
                        serializedSize = ((AbstractMessageLite) object2).getSerializedSize(messageFieldSchema);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(serializedSize);
                        i2 = iComputeUInt32SizeNoTag + serializedSize + iComputeTagSize7;
                        iComputeUInt32SizeNoTag4 += i2;
                    }
                    i3 += 3;
                    break;
                case 10:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        iComputeBytesSize = CodedOutputStream.computeBytesSize(i6, (ByteString) unsafe.getObject(generatedMessageLite2, j));
                        iComputeUInt32SizeNoTag4 += iComputeBytesSize;
                    }
                    messageSchema = this;
                    i3 += 3;
                    break;
                case 11:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        int i10 = unsafe.getInt(generatedMessageLite2, j);
                        iComputeTagSize4 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt64SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(i10);
                        iComputeBytesSize = iComputeUInt64SizeNoTag2 + iComputeTagSize4;
                        iComputeUInt32SizeNoTag4 += iComputeBytesSize;
                    }
                    messageSchema = this;
                    i3 += 3;
                    break;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        int i11 = unsafe.getInt(generatedMessageLite2, j);
                        iComputeTagSize4 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt64SizeNoTag2 = CodedOutputStream.computeUInt64SizeNoTag(i11);
                        iComputeBytesSize = iComputeUInt64SizeNoTag2 + iComputeTagSize4;
                        iComputeUInt32SizeNoTag4 += iComputeBytesSize;
                    }
                    messageSchema = this;
                    i3 += 3;
                    break;
                case 13:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        iComputeTagSize2 = CodedOutputStream.computeTagSize(i6);
                        iComputeTagSize6 = iComputeTagSize2 + 4;
                        iComputeUInt32SizeNoTag4 += iComputeTagSize6;
                    }
                    messageSchema = this;
                    generatedMessageLite2 = generatedMessageLite;
                    i3 += 3;
                    break;
                case 14:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        iComputeTagSize5 = CodedOutputStream.computeTagSize(i6);
                        iComputeTagSize6 = iComputeTagSize5 + 8;
                        iComputeUInt32SizeNoTag4 += iComputeTagSize6;
                    }
                    messageSchema = this;
                    generatedMessageLite2 = generatedMessageLite;
                    i3 += 3;
                    break;
                case 15:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        int i12 = unsafe.getInt(generatedMessageLite2, j);
                        iComputeTagSize4 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt64SizeNoTag2 = CodedOutputStream.computeSInt32SizeNoTag(i12);
                        iComputeBytesSize = iComputeUInt64SizeNoTag2 + iComputeTagSize4;
                        iComputeUInt32SizeNoTag4 += iComputeBytesSize;
                    }
                    messageSchema = this;
                    i3 += 3;
                    break;
                case 16:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        long j4 = unsafe.getLong(generatedMessageLite2, j);
                        iComputeTagSize3 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt64SizeNoTag = CodedOutputStream.computeSInt64SizeNoTag(j4);
                        iComputeUInt32SizeNoTag4 += iComputeUInt64SizeNoTag + iComputeTagSize3;
                    }
                    messageSchema = this;
                    i3 += 3;
                    break;
                case 17:
                    if (messageSchema.isFieldPresent(generatedMessageLite2, i3, i5, i4, i)) {
                        MessageLite messageLite = (MessageLite) unsafe.getObject(generatedMessageLite2, j);
                        Schema messageFieldSchema2 = messageSchema.getMessageFieldSchema(i3);
                        Class cls2 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                        iComputeTagSize8 = CodedOutputStream.computeTagSize(i6) * 2;
                        serializedSize2 = ((AbstractMessageLite) messageLite).getSerializedSize(messageFieldSchema2);
                        iComputeSizeFixed64List = serializedSize2 + iComputeTagSize8;
                        iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    }
                    i3 += 3;
                    break;
                case 18:
                    iComputeSizeFixed64List = SchemaUtil.computeSizeFixed64List(i6, (List) unsafe.getObject(generatedMessageLite2, j));
                    iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    i3 += 3;
                    break;
                case 19:
                    iComputeSizeFixed64List = SchemaUtil.computeSizeFixed32List(i6, (List) unsafe.getObject(generatedMessageLite2, j));
                    iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    i3 += 3;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls3 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    if (list.size() == 0) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeTagSize9 = (CodedOutputStream.computeTagSize(i6) * list.size()) + SchemaUtil.computeSizeInt64ListNoTag(list);
                    }
                    iComputeUInt32SizeNoTag4 += iComputeTagSize9;
                    i3 += 3;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls4 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size = list2.size();
                    if (size == 0) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag(list2);
                        iComputeTagSize10 = CodedOutputStream.computeTagSize(i6);
                        iComputeTagSize9 = (iComputeTagSize10 * size) + iComputeSizeUInt64ListNoTag;
                    }
                    iComputeUInt32SizeNoTag4 += iComputeTagSize9;
                    i3 += 3;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls5 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size = list3.size();
                    if (size == 0) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag(list3);
                        iComputeTagSize10 = CodedOutputStream.computeTagSize(i6);
                        iComputeTagSize9 = (iComputeTagSize10 * size) + iComputeSizeUInt64ListNoTag;
                    }
                    iComputeUInt32SizeNoTag4 += iComputeTagSize9;
                    i3 += 3;
                    break;
                case 23:
                    iComputeSizeFixed64List = SchemaUtil.computeSizeFixed64List(i6, (List) unsafe.getObject(generatedMessageLite2, j));
                    iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    i3 += 3;
                    break;
                case 24:
                    iComputeSizeFixed64List = SchemaUtil.computeSizeFixed32List(i6, (List) unsafe.getObject(generatedMessageLite2, j));
                    iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    i3 += 3;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls6 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    int size3 = list4.size();
                    iComputeUInt32SizeNoTag4 += size3 == 0 ? 0 : (CodedOutputStream.computeTagSize(i6) + 1) * size3;
                    i3 += 3;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls7 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    int size4 = list5.size();
                    if (size4 == 0) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeTagSize9 = CodedOutputStream.computeTagSize(i6) * size4;
                        for (int i13 = 0; i13 < size4; i13++) {
                            Object obj = list5.get(i13);
                            if (obj instanceof ByteString) {
                                iEncodedLength = ((ByteString) obj).size();
                                iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(iEncodedLength);
                            } else {
                                iEncodedLength = Utf8.processor.encodedLength((String) obj);
                                iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(iEncodedLength);
                            }
                            iComputeTagSize9 = iComputeUInt32SizeNoTag2 + iEncodedLength + iComputeTagSize9;
                        }
                    }
                    iComputeUInt32SizeNoTag4 += iComputeTagSize9;
                    i3 += 3;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Schema messageFieldSchema3 = messageSchema.getMessageFieldSchema(i3);
                    Class cls8 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    int size5 = list6.size();
                    if (size5 == 0) {
                        iComputeTagSize11 = 0;
                    } else {
                        iComputeTagSize11 = CodedOutputStream.computeTagSize(i6) * size5;
                        for (int i14 = 0; i14 < size5; i14++) {
                            int serializedSize4 = ((AbstractMessageLite) list6.get(i14)).getSerializedSize(messageFieldSchema3);
                            iComputeTagSize11 += CodedOutputStream.computeUInt32SizeNoTag(serializedSize4) + serializedSize4;
                        }
                    }
                    iComputeUInt32SizeNoTag4 += iComputeTagSize11;
                    i3 += 3;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls9 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    int size6 = list7.size();
                    if (size6 == 0) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeTagSize9 = CodedOutputStream.computeTagSize(i6) * size6;
                        for (int i15 = 0; i15 < list7.size(); i15++) {
                            int size7 = ((ByteString) list7.get(i15)).size();
                            iComputeTagSize9 += CodedOutputStream.computeUInt32SizeNoTag(size7) + size7;
                        }
                    }
                    iComputeUInt32SizeNoTag4 += iComputeTagSize9;
                    i3 += 3;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls10 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size = list8.size();
                    if (size == 0) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag(list8);
                        iComputeTagSize10 = CodedOutputStream.computeTagSize(i6);
                        iComputeTagSize9 = (iComputeTagSize10 * size) + iComputeSizeUInt64ListNoTag;
                    }
                    iComputeUInt32SizeNoTag4 += iComputeTagSize9;
                    i3 += 3;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls11 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size = list9.size();
                    if (size == 0) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeEnumListNoTag(list9);
                        iComputeTagSize10 = CodedOutputStream.computeTagSize(i6);
                        iComputeTagSize9 = (iComputeTagSize10 * size) + iComputeSizeUInt64ListNoTag;
                    }
                    iComputeUInt32SizeNoTag4 += iComputeTagSize9;
                    i3 += 3;
                    break;
                case 31:
                    iComputeSizeFixed64List = SchemaUtil.computeSizeFixed32List(i6, (List) unsafe.getObject(generatedMessageLite2, j));
                    iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    i3 += 3;
                    break;
                case 32:
                    iComputeSizeFixed64List = SchemaUtil.computeSizeFixed64List(i6, (List) unsafe.getObject(generatedMessageLite2, j));
                    iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    i3 += 3;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls12 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size = list10.size();
                    if (size == 0) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag(list10);
                        iComputeTagSize10 = CodedOutputStream.computeTagSize(i6);
                        iComputeTagSize9 = (iComputeTagSize10 * size) + iComputeSizeUInt64ListNoTag;
                    }
                    iComputeUInt32SizeNoTag4 += iComputeTagSize9;
                    i3 += 3;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls13 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size = list11.size();
                    if (size == 0) {
                        iComputeTagSize9 = 0;
                    } else {
                        iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag(list11);
                        iComputeTagSize10 = CodedOutputStream.computeTagSize(i6);
                        iComputeTagSize9 = (iComputeTagSize10 * size) + iComputeSizeUInt64ListNoTag;
                    }
                    iComputeUInt32SizeNoTag4 += iComputeTagSize9;
                    i3 += 3;
                    break;
                case 35:
                    List list12 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls14 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size2 = list12.size() * 8;
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt32SizeNoTag3 = CodedOutputStream.computeUInt32SizeNoTag(size2);
                        iComputeUInt32SizeNoTag4 += iComputeUInt32SizeNoTag3 + iComputeTagSize12 + size2;
                    }
                    i3 += 3;
                    break;
                case 36:
                    List list13 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls15 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size2 = list13.size() * 4;
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt32SizeNoTag3 = CodedOutputStream.computeUInt32SizeNoTag(size2);
                        iComputeUInt32SizeNoTag4 += iComputeUInt32SizeNoTag3 + iComputeTagSize12 + size2;
                    }
                    i3 += 3;
                    break;
                case 37:
                    size2 = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(generatedMessageLite2, j));
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt32SizeNoTag3 = CodedOutputStream.computeUInt32SizeNoTag(size2);
                        iComputeUInt32SizeNoTag4 += iComputeUInt32SizeNoTag3 + iComputeTagSize12 + size2;
                    }
                    i3 += 3;
                    break;
                case 38:
                    size2 = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(generatedMessageLite2, j));
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt32SizeNoTag3 = CodedOutputStream.computeUInt32SizeNoTag(size2);
                        iComputeUInt32SizeNoTag4 += iComputeUInt32SizeNoTag3 + iComputeTagSize12 + size2;
                    }
                    i3 += 3;
                    break;
                case 39:
                    size2 = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(generatedMessageLite2, j));
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt32SizeNoTag3 = CodedOutputStream.computeUInt32SizeNoTag(size2);
                        iComputeUInt32SizeNoTag4 += iComputeUInt32SizeNoTag3 + iComputeTagSize12 + size2;
                    }
                    i3 += 3;
                    break;
                case 40:
                    List list14 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls16 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size2 = list14.size() * 8;
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt32SizeNoTag3 = CodedOutputStream.computeUInt32SizeNoTag(size2);
                        iComputeUInt32SizeNoTag4 += iComputeUInt32SizeNoTag3 + iComputeTagSize12 + size2;
                    }
                    i3 += 3;
                    break;
                case 41:
                    List list15 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls17 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size2 = list15.size() * 4;
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt32SizeNoTag3 = CodedOutputStream.computeUInt32SizeNoTag(size2);
                        iComputeUInt32SizeNoTag4 += iComputeUInt32SizeNoTag3 + iComputeTagSize12 + size2;
                    }
                    i3 += 3;
                    break;
                case 42:
                    List list16 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls18 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size2 = list16.size();
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt32SizeNoTag3 = CodedOutputStream.computeUInt32SizeNoTag(size2);
                        iComputeUInt32SizeNoTag4 += iComputeUInt32SizeNoTag3 + iComputeTagSize12 + size2;
                    }
                    i3 += 3;
                    break;
                case 43:
                    size2 = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(generatedMessageLite2, j));
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt32SizeNoTag3 = CodedOutputStream.computeUInt32SizeNoTag(size2);
                        iComputeUInt32SizeNoTag4 += iComputeUInt32SizeNoTag3 + iComputeTagSize12 + size2;
                    }
                    i3 += 3;
                    break;
                case 44:
                    size2 = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(generatedMessageLite2, j));
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt32SizeNoTag3 = CodedOutputStream.computeUInt32SizeNoTag(size2);
                        iComputeUInt32SizeNoTag4 += iComputeUInt32SizeNoTag3 + iComputeTagSize12 + size2;
                    }
                    i3 += 3;
                    break;
                case 45:
                    List list17 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls19 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size2 = list17.size() * 4;
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt32SizeNoTag3 = CodedOutputStream.computeUInt32SizeNoTag(size2);
                        iComputeUInt32SizeNoTag4 += iComputeUInt32SizeNoTag3 + iComputeTagSize12 + size2;
                    }
                    i3 += 3;
                    break;
                case 46:
                    List list18 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Class cls20 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    size2 = list18.size() * 8;
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt32SizeNoTag3 = CodedOutputStream.computeUInt32SizeNoTag(size2);
                        iComputeUInt32SizeNoTag4 += iComputeUInt32SizeNoTag3 + iComputeTagSize12 + size2;
                    }
                    i3 += 3;
                    break;
                case 47:
                    size2 = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(generatedMessageLite2, j));
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt32SizeNoTag3 = CodedOutputStream.computeUInt32SizeNoTag(size2);
                        iComputeUInt32SizeNoTag4 += iComputeUInt32SizeNoTag3 + iComputeTagSize12 + size2;
                    }
                    i3 += 3;
                    break;
                case 48:
                    size2 = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(generatedMessageLite2, j));
                    if (size2 > 0) {
                        iComputeTagSize12 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt32SizeNoTag3 = CodedOutputStream.computeUInt32SizeNoTag(size2);
                        iComputeUInt32SizeNoTag4 += iComputeUInt32SizeNoTag3 + iComputeTagSize12 + size2;
                    }
                    i3 += 3;
                    break;
                case 49:
                    List list19 = (List) unsafe.getObject(generatedMessageLite2, j);
                    Schema messageFieldSchema4 = messageSchema.getMessageFieldSchema(i3);
                    Class cls21 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    int size8 = list19.size();
                    if (size8 == 0) {
                        serializedSize3 = 0;
                    } else {
                        serializedSize3 = 0;
                        for (int i16 = 0; i16 < size8; i16++) {
                            serializedSize3 += ((AbstractMessageLite) ((MessageLite) list19.get(i16))).getSerializedSize(messageFieldSchema4) + (CodedOutputStream.computeTagSize(i6) * 2);
                        }
                    }
                    iComputeUInt32SizeNoTag4 += serializedSize3;
                    i3 += 3;
                    break;
                case 50:
                    MapFieldLite mapFieldLite = (MapFieldLite) unsafe.getObject(generatedMessageLite2, j);
                    if (messageSchema.getMapFieldDefaultEntry(i3) != null) {
                        PathKt$$ExternalSyntheticBUOutline0.m();
                        return 0;
                    }
                    if (mapFieldLite.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = mapFieldLite.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i3 += 3;
                    break;
                case 51:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        iComputeTagSize = CodedOutputStream.computeTagSize(i6);
                        iComputeSizeFixed64List = iComputeTagSize + 8;
                        iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    }
                    i3 += 3;
                    break;
                case 52:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        iComputeTagSize13 = CodedOutputStream.computeTagSize(i6);
                        iComputeSizeFixed64List = iComputeTagSize13 + 4;
                        iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    }
                    i3 += 3;
                    break;
                case 53:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        long jOneofLongAt = oneofLongAt(j, generatedMessageLite2);
                        iComputeTagSize14 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt64SizeNoTag3 = CodedOutputStream.computeUInt64SizeNoTag(jOneofLongAt);
                        i2 = iComputeUInt64SizeNoTag3 + iComputeTagSize14;
                        iComputeUInt32SizeNoTag4 += i2;
                    }
                    i3 += 3;
                    break;
                case 54:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        long jOneofLongAt2 = oneofLongAt(j, generatedMessageLite2);
                        iComputeTagSize14 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt64SizeNoTag3 = CodedOutputStream.computeUInt64SizeNoTag(jOneofLongAt2);
                        i2 = iComputeUInt64SizeNoTag3 + iComputeTagSize14;
                        iComputeUInt32SizeNoTag4 += i2;
                    }
                    i3 += 3;
                    break;
                case 55:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        int iOneofIntAt = oneofIntAt(j, generatedMessageLite2);
                        iComputeTagSize15 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt64SizeNoTag4 = CodedOutputStream.computeUInt64SizeNoTag(iOneofIntAt);
                        iComputeSizeFixed64List = iComputeUInt64SizeNoTag4 + iComputeTagSize15;
                        iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    }
                    i3 += 3;
                    break;
                case 56:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        iComputeTagSize = CodedOutputStream.computeTagSize(i6);
                        iComputeSizeFixed64List = iComputeTagSize + 8;
                        iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    }
                    i3 += 3;
                    break;
                case 57:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        iComputeTagSize13 = CodedOutputStream.computeTagSize(i6);
                        iComputeSizeFixed64List = iComputeTagSize13 + 4;
                        iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    }
                    i3 += 3;
                    break;
                case 58:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        iComputeSizeFixed64List = CodedOutputStream.computeTagSize(i6) + 1;
                        iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    }
                    i3 += 3;
                    break;
                case 59:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        Object object3 = unsafe.getObject(generatedMessageLite2, j);
                        if (object3 instanceof ByteString) {
                            iComputeUInt32SizeNoTag4 = CodedOutputStream.computeBytesSize(i6, (ByteString) object3) + iComputeUInt32SizeNoTag4;
                        } else {
                            int iComputeTagSize17 = CodedOutputStream.computeTagSize(i6);
                            int iEncodedLength3 = Utf8.processor.encodedLength((String) object3);
                            iComputeUInt32SizeNoTag4 = CodedOutputStream.computeUInt32SizeNoTag(iEncodedLength3) + iEncodedLength3 + iComputeTagSize17 + iComputeUInt32SizeNoTag4;
                        }
                    }
                    i3 += 3;
                    break;
                case 60:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        Object object4 = unsafe.getObject(generatedMessageLite2, j);
                        Schema messageFieldSchema5 = messageSchema.getMessageFieldSchema(i3);
                        Class cls22 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                        iComputeTagSize7 = CodedOutputStream.computeTagSize(i6);
                        serializedSize = ((AbstractMessageLite) object4).getSerializedSize(messageFieldSchema5);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(serializedSize);
                        i2 = iComputeUInt32SizeNoTag + serializedSize + iComputeTagSize7;
                        iComputeUInt32SizeNoTag4 += i2;
                    }
                    i3 += 3;
                    break;
                case 61:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        iComputeSizeFixed64List = CodedOutputStream.computeBytesSize(i6, (ByteString) unsafe.getObject(generatedMessageLite2, j));
                        iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    }
                    i3 += 3;
                    break;
                case 62:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        int iOneofIntAt2 = oneofIntAt(j, generatedMessageLite2);
                        iComputeTagSize15 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt64SizeNoTag4 = CodedOutputStream.computeUInt32SizeNoTag(iOneofIntAt2);
                        iComputeSizeFixed64List = iComputeUInt64SizeNoTag4 + iComputeTagSize15;
                        iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    }
                    i3 += 3;
                    break;
                case 63:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        int iOneofIntAt3 = oneofIntAt(j, generatedMessageLite2);
                        iComputeTagSize15 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt64SizeNoTag4 = CodedOutputStream.computeUInt64SizeNoTag(iOneofIntAt3);
                        iComputeSizeFixed64List = iComputeUInt64SizeNoTag4 + iComputeTagSize15;
                        iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    }
                    i3 += 3;
                    break;
                case 64:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        iComputeTagSize13 = CodedOutputStream.computeTagSize(i6);
                        iComputeSizeFixed64List = iComputeTagSize13 + 4;
                        iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    }
                    i3 += 3;
                    break;
                case 65:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        iComputeTagSize = CodedOutputStream.computeTagSize(i6);
                        iComputeSizeFixed64List = iComputeTagSize + 8;
                        iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    }
                    i3 += 3;
                    break;
                case 66:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        int iOneofIntAt4 = oneofIntAt(j, generatedMessageLite2);
                        iComputeTagSize15 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt64SizeNoTag4 = CodedOutputStream.computeSInt32SizeNoTag(iOneofIntAt4);
                        iComputeSizeFixed64List = iComputeUInt64SizeNoTag4 + iComputeTagSize15;
                        iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    }
                    i3 += 3;
                    break;
                case 67:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        long jOneofLongAt3 = oneofLongAt(j, generatedMessageLite2);
                        iComputeTagSize14 = CodedOutputStream.computeTagSize(i6);
                        iComputeUInt64SizeNoTag3 = CodedOutputStream.computeSInt64SizeNoTag(jOneofLongAt3);
                        i2 = iComputeUInt64SizeNoTag3 + iComputeTagSize14;
                        iComputeUInt32SizeNoTag4 += i2;
                    }
                    i3 += 3;
                    break;
                case 68:
                    if (messageSchema.isOneofPresent(i6, i3, generatedMessageLite2)) {
                        MessageLite messageLite2 = (MessageLite) unsafe.getObject(generatedMessageLite2, j);
                        Schema messageFieldSchema6 = messageSchema.getMessageFieldSchema(i3);
                        Class cls23 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                        iComputeTagSize8 = CodedOutputStream.computeTagSize(i6) * 2;
                        serializedSize2 = ((AbstractMessageLite) messageLite2).getSerializedSize(messageFieldSchema6);
                        iComputeSizeFixed64List = serializedSize2 + iComputeTagSize8;
                        iComputeUInt32SizeNoTag4 += iComputeSizeFixed64List;
                    }
                    i3 += 3;
                    break;
                default:
                    i3 += 3;
                    break;
            }
        }
    }

    @Override // com.google.protobuf.Schema
    public final int hashCode(GeneratedMessageLite generatedMessageLite) {
        int i;
        int iHashLong;
        int length = this.buffer.length;
        int iHashCode = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i2);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 50 || iType >= 69) {
                long j = 1048575 & iTypeAndOffsetAt;
                int iHashCode2 = 37;
                switch (iType) {
                    case 0:
                        i = iHashCode * 53;
                        iHashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.MEMORY_ACCESSOR.getDouble(j, generatedMessageLite)));
                        iHashCode = i + iHashLong;
                        break;
                    case 1:
                        i = iHashCode * 53;
                        iHashLong = Float.floatToIntBits(UnsafeUtil.MEMORY_ACCESSOR.getFloat(j, generatedMessageLite));
                        iHashCode = i + iHashLong;
                        break;
                    case 2:
                        i = iHashCode * 53;
                        iHashLong = Internal.hashLong(UnsafeUtil.getLong(j, generatedMessageLite));
                        iHashCode = i + iHashLong;
                        break;
                    case 3:
                        i = iHashCode * 53;
                        iHashLong = Internal.hashLong(UnsafeUtil.getLong(j, generatedMessageLite));
                        iHashCode = i + iHashLong;
                        break;
                    case 4:
                        i = iHashCode * 53;
                        iHashLong = UnsafeUtil.getInt(j, generatedMessageLite);
                        iHashCode = i + iHashLong;
                        break;
                    case 5:
                        i = iHashCode * 53;
                        iHashLong = Internal.hashLong(UnsafeUtil.getLong(j, generatedMessageLite));
                        iHashCode = i + iHashLong;
                        break;
                    case 6:
                        i = iHashCode * 53;
                        iHashLong = UnsafeUtil.getInt(j, generatedMessageLite);
                        iHashCode = i + iHashLong;
                        break;
                    case 7:
                        i = iHashCode * 53;
                        boolean z = UnsafeUtil.MEMORY_ACCESSOR.getBoolean(j, generatedMessageLite);
                        byte[] bArr = Internal.EMPTY_BYTE_ARRAY;
                        iHashLong = z ? 1231 : 1237;
                        iHashCode = i + iHashLong;
                        break;
                    case 8:
                        i = iHashCode * 53;
                        iHashLong = ((String) UnsafeUtil.getObject(j, generatedMessageLite)).hashCode();
                        iHashCode = i + iHashLong;
                        break;
                    case 9:
                        Object object = UnsafeUtil.getObject(j, generatedMessageLite);
                        if (object != null) {
                            iHashCode2 = object.hashCode();
                        }
                        iHashCode = (iHashCode * 53) + iHashCode2;
                        break;
                    case 10:
                        i = iHashCode * 53;
                        iHashLong = UnsafeUtil.getObject(j, generatedMessageLite).hashCode();
                        iHashCode = i + iHashLong;
                        break;
                    case 11:
                        i = iHashCode * 53;
                        iHashLong = UnsafeUtil.getInt(j, generatedMessageLite);
                        iHashCode = i + iHashLong;
                        break;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        i = iHashCode * 53;
                        iHashLong = UnsafeUtil.getInt(j, generatedMessageLite);
                        iHashCode = i + iHashLong;
                        break;
                    case 13:
                        i = iHashCode * 53;
                        iHashLong = UnsafeUtil.getInt(j, generatedMessageLite);
                        iHashCode = i + iHashLong;
                        break;
                    case 14:
                        i = iHashCode * 53;
                        iHashLong = Internal.hashLong(UnsafeUtil.getLong(j, generatedMessageLite));
                        iHashCode = i + iHashLong;
                        break;
                    case 15:
                        i = iHashCode * 53;
                        iHashLong = UnsafeUtil.getInt(j, generatedMessageLite);
                        iHashCode = i + iHashLong;
                        break;
                    case 16:
                        i = iHashCode * 53;
                        iHashLong = Internal.hashLong(UnsafeUtil.getLong(j, generatedMessageLite));
                        iHashCode = i + iHashLong;
                        break;
                    case 17:
                        Object object2 = UnsafeUtil.getObject(j, generatedMessageLite);
                        if (object2 != null) {
                            iHashCode2 = object2.hashCode();
                        }
                        iHashCode = (iHashCode * 53) + iHashCode2;
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        i = iHashCode * 53;
                        iHashLong = UnsafeUtil.getObject(j, generatedMessageLite).hashCode();
                        iHashCode = i + iHashLong;
                        break;
                    case 50:
                        i = iHashCode * 53;
                        iHashLong = UnsafeUtil.getObject(j, generatedMessageLite).hashCode();
                        iHashCode = i + iHashLong;
                        break;
                }
            }
        }
        int i3 = this.oneofFieldPositionsStart;
        while (true) {
            int[] iArr = this.intArray;
            if (i3 >= iArr.length) {
                this.unknownFieldSchema.getClass();
                return generatedMessageLite.unknownFields.hashCode() + (iHashCode * 53);
            }
            int i4 = iArr[i3];
            if (!isOneofPresent(0, i4, generatedMessageLite)) {
                iHashCode = UnsafeUtil.getObject(typeAndOffsetAt(i4) & 1048575, generatedMessageLite).hashCode() + (iHashCode * 53);
            }
            i3++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:69:0x00f0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x00f1 A[RETURN] */
    public final boolean isFieldPresent(int i, Object obj) {
        int i2 = this.buffer[i + 2];
        long j = i2 & 1048575;
        if (j != 1048575) {
            if (((1 << (i2 >>> 20)) & UnsafeUtil.getInt(j, obj)) != 0) {
                return true;
            }
            return false;
        }
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long j2 = iTypeAndOffsetAt & 1048575;
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (Double.doubleToRawLongBits(UnsafeUtil.MEMORY_ACCESSOR.getDouble(j2, obj)) != 0) {
                    return true;
                }
                return false;
            case 1:
                if (Float.floatToRawIntBits(UnsafeUtil.MEMORY_ACCESSOR.getFloat(j2, obj)) != 0) {
                    return true;
                }
                return false;
            case 2:
                if (UnsafeUtil.getLong(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 3:
                if (UnsafeUtil.getLong(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 4:
                if (UnsafeUtil.getInt(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 5:
                if (UnsafeUtil.getLong(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 6:
                if (UnsafeUtil.getInt(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 7:
                return UnsafeUtil.MEMORY_ACCESSOR.getBoolean(j2, obj);
            case 8:
                Object object = UnsafeUtil.getObject(j2, obj);
                if (object instanceof String) {
                    return !((String) object).isEmpty();
                }
                if (object instanceof ByteString) {
                    return !ByteString.EMPTY.equals(object);
                }
                Path$$ExternalSyntheticBUOutline0.m();
                return false;
            case 9:
                if (UnsafeUtil.getObject(j2, obj) != null) {
                    return true;
                }
                return false;
            case 10:
                return !ByteString.EMPTY.equals(UnsafeUtil.getObject(j2, obj));
            case 11:
                if (UnsafeUtil.getInt(j2, obj) != 0) {
                    return true;
                }
                return false;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                if (UnsafeUtil.getInt(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 13:
                if (UnsafeUtil.getInt(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 14:
                if (UnsafeUtil.getLong(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 15:
                if (UnsafeUtil.getInt(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 16:
                if (UnsafeUtil.getLong(j2, obj) != 0) {
                    return true;
                }
                return false;
            case 17:
                if (UnsafeUtil.getObject(j2, obj) != null) {
                    return true;
                }
                return false;
            default:
                Path$$ExternalSyntheticBUOutline0.m();
                return false;
        }
    }

    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(Object obj) {
        int i;
        int i2;
        MessageSchema messageSchema;
        Object obj2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < this.checkInitializedCount) {
            int i6 = this.intArray[i4];
            int iTypeAndOffsetAt = this.typeAndOffsetAt(i6);
            int[] iArr = this.buffer;
            int i7 = iArr[i6 + 2];
            int i8 = i7 & 1048575;
            int i9 = 1 << (i7 >>> 20);
            if (i8 != i3) {
                if (i8 != 1048575) {
                    i5 = UNSAFE.getInt(obj, i8);
                }
                i2 = i5;
                i = i8;
            } else {
                i = i3;
                i2 = i5;
            }
            if ((268435456 & iTypeAndOffsetAt) != 0) {
                messageSchema = this;
                obj2 = obj;
                if (!messageSchema.isFieldPresent(obj2, i6, i, i2, i9)) {
                }
                return false;
            }
            messageSchema = this;
            obj2 = obj;
            int iType = type(iTypeAndOffsetAt);
            if (iType == 9 || iType == 17) {
                if (messageSchema.isFieldPresent(obj2, i6, i, i2, i9) && !messageSchema.getMessageFieldSchema(i6).isInitialized(UnsafeUtil.getObject(iTypeAndOffsetAt & 1048575, obj2))) {
                    return false;
                }
                i4++;
                this = messageSchema;
                obj = obj2;
                i3 = i;
                i5 = i2;
            } else {
                if (iType != 27) {
                    if (iType == 60 || iType == 68) {
                        if (messageSchema.isOneofPresent(iArr[i6], i6, obj2) && !messageSchema.getMessageFieldSchema(i6).isInitialized(UnsafeUtil.getObject(iTypeAndOffsetAt & 1048575, obj2))) {
                            return false;
                        }
                    } else if (iType != 49) {
                        if (iType == 50 && !((MapFieldLite) UnsafeUtil.getObject(iTypeAndOffsetAt & 1048575, obj2)).isEmpty()) {
                            Fragment$5$$ExternalSyntheticOutline0.m833m(messageSchema.getMapFieldDefaultEntry(i6));
                            throw null;
                        }
                    }
                    i4++;
                    this = messageSchema;
                    obj = obj2;
                    i3 = i;
                    i5 = i2;
                }
                List list = (List) UnsafeUtil.getObject(iTypeAndOffsetAt & 1048575, obj2);
                if (list.isEmpty()) {
                    continue;
                } else {
                    Schema messageFieldSchema = messageSchema.getMessageFieldSchema(i6);
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        if (!messageFieldSchema.isInitialized(list.get(i10))) {
                            return false;
                        }
                    }
                }
                i4++;
                this = messageSchema;
                obj = obj2;
                i3 = i;
                i5 = i2;
            }
        }
        return true;
    }

    public final boolean isOneofPresent(int i, int i2, Object obj) {
        return UnsafeUtil.getInt((long) (this.buffer[i2 + 2] & 1048575), obj) == i;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0070  */
    /* JADX WARN: Code duplicated, block: B:29:0x0076  */
    /* JADX WARN: Code duplicated, block: B:43:0x0081 A[SYNTHETIC] */
    @Override // com.google.protobuf.Schema
    public final void makeImmutable(Object obj) {
        if (isMutable(obj)) {
            if (obj instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int[] iArr = this.buffer;
            int length = iArr.length;
            for (int i = 0; i < length; i += 3) {
                int iTypeAndOffsetAt = typeAndOffsetAt(i);
                long j = 1048575 & iTypeAndOffsetAt;
                int iType = type(iTypeAndOffsetAt);
                Unsafe unsafe = UNSAFE;
                if (iType != 9) {
                    if (iType != 60 && iType != 68) {
                        switch (iType) {
                            case 17:
                                if (isFieldPresent(i, obj)) {
                                    getMessageFieldSchema(i).makeImmutable(unsafe.getObject(obj, j));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                AbstractProtobufList abstractProtobufList = (AbstractProtobufList) ((Internal.ProtobufList) UnsafeUtil.getObject(j, obj));
                                if (abstractProtobufList.isMutable) {
                                    abstractProtobufList.isMutable = false;
                                }
                                break;
                            case 50:
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((MapFieldLite) object).isMutable = false;
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (isOneofPresent(iArr[i], i, obj)) {
                        getMessageFieldSchema(i).makeImmutable(unsafe.getObject(obj, j));
                    }
                } else if (isFieldPresent(i, obj)) {
                    getMessageFieldSchema(i).makeImmutable(unsafe.getObject(obj, j));
                }
            }
            this.unknownFieldSchema.getClass();
            UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite) obj).unknownFields;
            if (unknownFieldSetLite.isMutable) {
                unknownFieldSetLite.isMutable = false;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:151:0x072b A[Catch: all -> 0x0465, TryCatch #2 {all -> 0x0465, blocks: (B:149:0x0726, B:151:0x072b, B:152:0x0730, B:105:0x0450, B:106:0x0459, B:109:0x0468, B:110:0x047b, B:111:0x048e, B:112:0x04a1, B:113:0x04b4, B:114:0x04c7, B:115:0x04da, B:116:0x04ed, B:117:0x0500, B:118:0x051c, B:119:0x053a, B:120:0x0558, B:121:0x0576, B:122:0x0595, B:123:0x05b6, B:124:0x05d4, B:125:0x05eb, B:126:0x0608, B:127:0x0617, B:128:0x0637, B:129:0x0656, B:130:0x0674, B:131:0x0692, B:132:0x06b0, B:133:0x06ce, B:134:0x06ef, B:140:0x070e), top: B:173:0x0726 }] */
    /* JADX WARN: Code duplicated, block: B:155:0x0738 A[LOOP:2: B:154:0x0736->B:155:0x0738, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:163:0x0753 A[LOOP:3: B:162:0x0751->B:163:0x0753, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:165:0x075d  */
    /* JADX WARN: Code duplicated, block: B:195:0x0736 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:208:? A[RETURN, SYNTHETIC] */
    @Override // com.google.protobuf.Schema
    public final void mergeFrom(Object obj, GapBuffer gapBuffer, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        MessageSchema messageSchema;
        ExtensionSchemaLite extensionSchemaLite;
        int[] iArr;
        ExtensionRegistryLite extensionRegistryLite2;
        GapBuffer gapBuffer2;
        MessageSchema messageSchema2 = this;
        Object obj2 = obj;
        GapBuffer gapBuffer3 = gapBuffer;
        ExtensionRegistryLite extensionRegistryLite3 = extensionRegistryLite;
        byte[] bArr = Internal.EMPTY_BYTE_ARRAY;
        extensionRegistryLite3.getClass();
        checkMutable(obj2);
        ExtensionSchemaLite extensionSchemaLite2 = messageSchema2.unknownFieldSchema;
        int[] iArr2 = messageSchema2.intArray;
        int i = messageSchema2.oneofFieldPositionsStart;
        int i2 = messageSchema2.checkInitializedCount;
        UnknownFieldSetLite builderFromMessage = null;
        while (true) {
            try {
                int fieldNumber = gapBuffer3.getFieldNumber();
                int iSlowPositionForFieldNumber = (fieldNumber < messageSchema2.minFieldNumber || fieldNumber > messageSchema2.maxFieldNumber) ? -1 : messageSchema2.slowPositionForFieldNumber(fieldNumber, 0);
                if (iSlowPositionForFieldNumber >= 0) {
                    int iTypeAndOffsetAt = messageSchema2.typeAndOffsetAt(iSlowPositionForFieldNumber);
                    try {
                        switch (type(iTypeAndOffsetAt)) {
                            case 0:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                long jOffset = offset(iTypeAndOffsetAt);
                                gapBuffer2.requireWireType(1);
                                try {
                                    try {
                                        UnsafeUtil.MEMORY_ACCESSOR.putDouble(obj, jOffset, ((CodedInputStream) gapBuffer2.buffer).readDouble());
                                        obj2 = obj;
                                        messageSchema.setFieldPresent(iSlowPositionForFieldNumber, obj2);
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                        obj2 = obj;
                                        try {
                                            extensionSchemaLite.getClass();
                                            if (builderFromMessage == null) {
                                                builderFromMessage = ExtensionSchemaLite.getBuilderFromMessage(obj2);
                                            }
                                            if (!ExtensionSchemaLite.mergeOneFieldFrom(0, gapBuffer2, builderFromMessage)) {
                                                while (i2 < i) {
                                                    messageSchema.filterMapUnknownEnumValues(iArr[i2], obj2, builderFromMessage);
                                                    i2++;
                                                }
                                                if (builderFromMessage == null) {
                                                    return;
                                                }
                                                ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            while (i2 < i) {
                                                messageSchema.filterMapUnknownEnumValues(iArr[i2], obj2, builderFromMessage);
                                                i2++;
                                            }
                                            if (builderFromMessage != null) {
                                                extensionSchemaLite.getClass();
                                                ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        obj2 = obj;
                                        while (i2 < i) {
                                            messageSchema.filterMapUnknownEnumValues(iArr[i2], obj2, builderFromMessage);
                                            i2++;
                                        }
                                        if (builderFromMessage != null) {
                                            extensionSchemaLite.getClass();
                                            ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                        }
                                        throw th;
                                    }
                                } catch (InvalidProtocolBufferException.InvalidWireTypeException unused2) {
                                    obj2 = obj;
                                } catch (Throwable th3) {
                                    th = th3;
                                    obj2 = obj;
                                }
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 1:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                long jOffset2 = offset(iTypeAndOffsetAt);
                                gapBuffer2.requireWireType(5);
                                UnsafeUtil.MEMORY_ACCESSOR.putFloat(obj2, jOffset2, ((CodedInputStream) gapBuffer2.buffer).readFloat());
                                messageSchema.setFieldPresent(iSlowPositionForFieldNumber, obj2);
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 2:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                long jOffset3 = offset(iTypeAndOffsetAt);
                                gapBuffer2.requireWireType(0);
                                UnsafeUtil.putLong(obj2, jOffset3, ((CodedInputStream) gapBuffer2.buffer).readInt64());
                                messageSchema.setFieldPresent(iSlowPositionForFieldNumber, obj2);
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 3:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                long jOffset4 = offset(iTypeAndOffsetAt);
                                gapBuffer2.requireWireType(0);
                                UnsafeUtil.putLong(obj2, jOffset4, ((CodedInputStream) gapBuffer2.buffer).readUInt64());
                                messageSchema.setFieldPresent(iSlowPositionForFieldNumber, obj2);
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 4:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                long jOffset5 = offset(iTypeAndOffsetAt);
                                gapBuffer2.requireWireType(0);
                                UnsafeUtil.putInt(((CodedInputStream) gapBuffer2.buffer).readInt32(), jOffset5, obj2);
                                messageSchema.setFieldPresent(iSlowPositionForFieldNumber, obj2);
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 5:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                long jOffset6 = offset(iTypeAndOffsetAt);
                                gapBuffer2.requireWireType(1);
                                UnsafeUtil.putLong(obj2, jOffset6, ((CodedInputStream) gapBuffer2.buffer).readFixed64());
                                messageSchema.setFieldPresent(iSlowPositionForFieldNumber, obj2);
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 6:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                long jOffset7 = offset(iTypeAndOffsetAt);
                                gapBuffer2.requireWireType(5);
                                UnsafeUtil.putInt(((CodedInputStream) gapBuffer2.buffer).readFixed32(), jOffset7, obj2);
                                messageSchema.setFieldPresent(iSlowPositionForFieldNumber, obj2);
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 7:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                long jOffset8 = offset(iTypeAndOffsetAt);
                                gapBuffer2.requireWireType(0);
                                UnsafeUtil.MEMORY_ACCESSOR.putBoolean(obj2, jOffset8, ((CodedInputStream) gapBuffer2.buffer).readBool());
                                messageSchema.setFieldPresent(iSlowPositionForFieldNumber, obj2);
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 8:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema.readString(iTypeAndOffsetAt, gapBuffer2, obj2);
                                messageSchema.setFieldPresent(iSlowPositionForFieldNumber, obj2);
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 9:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                MessageLite messageLite = (MessageLite) messageSchema.mutableMessageFieldForMerge(iSlowPositionForFieldNumber, obj2);
                                Schema messageFieldSchema = messageSchema.getMessageFieldSchema(iSlowPositionForFieldNumber);
                                gapBuffer2.requireWireType(2);
                                gapBuffer2.mergeMessageFieldInternal(messageLite, messageFieldSchema, extensionRegistryLite2);
                                messageSchema.storeMessageField(iSlowPositionForFieldNumber, obj2, messageLite);
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 10:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                UnsafeUtil.putObject(obj2, offset(iTypeAndOffsetAt), gapBuffer2.m759readBytes());
                                messageSchema.setFieldPresent(iSlowPositionForFieldNumber, obj2);
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 11:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                long jOffset9 = offset(iTypeAndOffsetAt);
                                gapBuffer2.requireWireType(0);
                                UnsafeUtil.putInt(((CodedInputStream) gapBuffer2.buffer).readUInt32(), jOffset9, obj2);
                                messageSchema.setFieldPresent(iSlowPositionForFieldNumber, obj2);
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                gapBuffer2.requireWireType(0);
                                int i3 = ((CodedInputStream) gapBuffer2.buffer).readEnum();
                                messageSchema.getEnumFieldVerifier(iSlowPositionForFieldNumber);
                                UnsafeUtil.putInt(i3, offset(iTypeAndOffsetAt), obj2);
                                messageSchema.setFieldPresent(iSlowPositionForFieldNumber, obj2);
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 13:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                long jOffset10 = offset(iTypeAndOffsetAt);
                                gapBuffer2.requireWireType(5);
                                UnsafeUtil.putInt(((CodedInputStream) gapBuffer2.buffer).readSFixed32(), jOffset10, obj2);
                                messageSchema.setFieldPresent(iSlowPositionForFieldNumber, obj2);
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 14:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                long jOffset11 = offset(iTypeAndOffsetAt);
                                gapBuffer2.requireWireType(1);
                                UnsafeUtil.putLong(obj2, jOffset11, ((CodedInputStream) gapBuffer2.buffer).readSFixed64());
                                messageSchema.setFieldPresent(iSlowPositionForFieldNumber, obj2);
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 15:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                long jOffset12 = offset(iTypeAndOffsetAt);
                                gapBuffer2.requireWireType(0);
                                UnsafeUtil.putInt(((CodedInputStream) gapBuffer2.buffer).readSInt32(), jOffset12, obj2);
                                messageSchema.setFieldPresent(iSlowPositionForFieldNumber, obj2);
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 16:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                long jOffset13 = offset(iTypeAndOffsetAt);
                                gapBuffer2.requireWireType(0);
                                UnsafeUtil.putLong(obj2, jOffset13, ((CodedInputStream) gapBuffer2.buffer).readSInt64());
                                messageSchema.setFieldPresent(iSlowPositionForFieldNumber, obj2);
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 17:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                MessageLite messageLite2 = (MessageLite) messageSchema.mutableMessageFieldForMerge(iSlowPositionForFieldNumber, obj2);
                                Schema messageFieldSchema2 = messageSchema.getMessageFieldSchema(iSlowPositionForFieldNumber);
                                gapBuffer2.requireWireType(3);
                                gapBuffer2.mergeGroupFieldInternal(messageLite2, messageFieldSchema2, extensionRegistryLite2);
                                messageSchema.storeMessageField(iSlowPositionForFieldNumber, obj2, messageLite2);
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 18:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                gapBuffer2.readDoubleList(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 19:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                gapBuffer2.readFloatList(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 20:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                gapBuffer2.readInt64List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 21:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                gapBuffer2.readUInt64List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 22:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                gapBuffer2.readInt32List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 23:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                gapBuffer2.readFixed64List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 24:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                gapBuffer2.readFixed32List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 25:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                gapBuffer2.readBoolList(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 26:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                if ((536870912 & iTypeAndOffsetAt) != 0) {
                                    try {
                                        gapBuffer2.readStringListInternal(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2), true);
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused3) {
                                        extensionSchemaLite.getClass();
                                        if (builderFromMessage == null) {
                                            builderFromMessage = ExtensionSchemaLite.getBuilderFromMessage(obj2);
                                        }
                                        if (!ExtensionSchemaLite.mergeOneFieldFrom(0, gapBuffer2, builderFromMessage)) {
                                            while (i2 < i) {
                                                messageSchema.filterMapUnknownEnumValues(iArr[i2], obj2, builderFromMessage);
                                                i2++;
                                            }
                                            if (builderFromMessage == null) {
                                                return;
                                            }
                                            ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                        }
                                    }
                                } else {
                                    gapBuffer2.readStringListInternal(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2), false);
                                }
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 27:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                messageSchema2.readMessageList(obj2, iTypeAndOffsetAt, gapBuffer3, messageSchema2.getMessageFieldSchema(iSlowPositionForFieldNumber), extensionRegistryLite);
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 28:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readBytesList(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 29:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readUInt32List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 30:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readEnumList(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                messageSchema2.getEnumFieldVerifier(iSlowPositionForFieldNumber);
                                Class cls = SchemaUtil.GENERATED_MESSAGE_CLASS;
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 31:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readSFixed32List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 32:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readSFixed64List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 33:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readSInt32List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 34:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readSInt64List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 35:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readDoubleList(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 36:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readFloatList(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 37:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readInt64List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 38:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readUInt64List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 39:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readInt32List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 40:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readFixed64List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 41:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readFixed32List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 42:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readBoolList(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 43:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readUInt32List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 44:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readEnumList(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                messageSchema2.getEnumFieldVerifier(iSlowPositionForFieldNumber);
                                Class cls2 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 45:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readSFixed32List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 46:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readSFixed64List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 47:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readSInt32List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 48:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.readSInt64List(Utf8.MobileProcessor.mutableListAt(iTypeAndOffsetAt & 1048575, obj2));
                                extensionRegistryLite2 = extensionRegistryLite;
                                messageSchema = messageSchema2;
                                gapBuffer2 = gapBuffer3;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 49:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                try {
                                    GapBuffer gapBuffer4 = gapBuffer3;
                                    try {
                                        messageSchema2.readGroupList(obj2, iTypeAndOffsetAt & 1048575, gapBuffer4, messageSchema2.getMessageFieldSchema(iSlowPositionForFieldNumber), extensionRegistryLite);
                                        gapBuffer3 = gapBuffer4;
                                        extensionRegistryLite2 = extensionRegistryLite;
                                        messageSchema = messageSchema2;
                                        gapBuffer2 = gapBuffer3;
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused4) {
                                        extensionRegistryLite2 = extensionRegistryLite;
                                        messageSchema = messageSchema2;
                                        gapBuffer2 = gapBuffer4;
                                        extensionSchemaLite.getClass();
                                        if (builderFromMessage == null) {
                                            builderFromMessage = ExtensionSchemaLite.getBuilderFromMessage(obj2);
                                        }
                                        if (!ExtensionSchemaLite.mergeOneFieldFrom(0, gapBuffer2, builderFromMessage)) {
                                            while (i2 < i) {
                                                messageSchema.filterMapUnknownEnumValues(iArr[i2], obj2, builderFromMessage);
                                                i2++;
                                            }
                                            if (builderFromMessage == null) {
                                                return;
                                            }
                                            ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                        }
                                    }
                                } catch (InvalidProtocolBufferException.InvalidWireTypeException unused5) {
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    messageSchema = messageSchema2;
                                    gapBuffer2 = gapBuffer3;
                                }
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 50:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                messageSchema2.mergeMap(iSlowPositionForFieldNumber, obj2, messageSchema2.getMapFieldDefaultEntry(iSlowPositionForFieldNumber));
                                throw null;
                            case 51:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.requireWireType(1);
                                UnsafeUtil.putObject(obj2, iTypeAndOffsetAt & 1048575, Double.valueOf(((CodedInputStream) gapBuffer3.buffer).readDouble()));
                                messageSchema2.setOneofPresent(fieldNumber, iSlowPositionForFieldNumber, obj2);
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 52:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.requireWireType(5);
                                UnsafeUtil.putObject(obj2, iTypeAndOffsetAt & 1048575, Float.valueOf(((CodedInputStream) gapBuffer3.buffer).readFloat()));
                                messageSchema2.setOneofPresent(fieldNumber, iSlowPositionForFieldNumber, obj2);
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 53:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.requireWireType(0);
                                UnsafeUtil.putObject(obj2, iTypeAndOffsetAt & 1048575, Long.valueOf(((CodedInputStream) gapBuffer3.buffer).readInt64()));
                                messageSchema2.setOneofPresent(fieldNumber, iSlowPositionForFieldNumber, obj2);
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 54:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.requireWireType(0);
                                UnsafeUtil.putObject(obj2, iTypeAndOffsetAt & 1048575, Long.valueOf(((CodedInputStream) gapBuffer3.buffer).readUInt64()));
                                messageSchema2.setOneofPresent(fieldNumber, iSlowPositionForFieldNumber, obj2);
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 55:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.requireWireType(0);
                                UnsafeUtil.putObject(obj2, iTypeAndOffsetAt & 1048575, Integer.valueOf(((CodedInputStream) gapBuffer3.buffer).readInt32()));
                                messageSchema2.setOneofPresent(fieldNumber, iSlowPositionForFieldNumber, obj2);
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 56:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.requireWireType(1);
                                UnsafeUtil.putObject(obj2, iTypeAndOffsetAt & 1048575, Long.valueOf(((CodedInputStream) gapBuffer3.buffer).readFixed64()));
                                messageSchema2.setOneofPresent(fieldNumber, iSlowPositionForFieldNumber, obj2);
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 57:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.requireWireType(5);
                                UnsafeUtil.putObject(obj2, iTypeAndOffsetAt & 1048575, Integer.valueOf(((CodedInputStream) gapBuffer3.buffer).readFixed32()));
                                messageSchema2.setOneofPresent(fieldNumber, iSlowPositionForFieldNumber, obj2);
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 58:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.requireWireType(0);
                                UnsafeUtil.putObject(obj2, iTypeAndOffsetAt & 1048575, Boolean.valueOf(((CodedInputStream) gapBuffer3.buffer).readBool()));
                                messageSchema2.setOneofPresent(fieldNumber, iSlowPositionForFieldNumber, obj2);
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 59:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                messageSchema2.readString(iTypeAndOffsetAt, gapBuffer3, obj2);
                                messageSchema2.setOneofPresent(fieldNumber, iSlowPositionForFieldNumber, obj2);
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 60:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                MessageLite messageLite3 = (MessageLite) messageSchema2.mutableOneofMessageFieldForMerge(fieldNumber, iSlowPositionForFieldNumber, obj2);
                                Schema messageFieldSchema3 = messageSchema2.getMessageFieldSchema(iSlowPositionForFieldNumber);
                                gapBuffer3.requireWireType(2);
                                gapBuffer3.mergeMessageFieldInternal(messageLite3, messageFieldSchema3, extensionRegistryLite3);
                                messageSchema2.storeOneofMessageField(fieldNumber, iSlowPositionForFieldNumber, obj2, messageLite3);
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 61:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                UnsafeUtil.putObject(obj2, iTypeAndOffsetAt & 1048575, gapBuffer3.m759readBytes());
                                messageSchema2.setOneofPresent(fieldNumber, iSlowPositionForFieldNumber, obj2);
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 62:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.requireWireType(0);
                                UnsafeUtil.putObject(obj2, iTypeAndOffsetAt & 1048575, Integer.valueOf(((CodedInputStream) gapBuffer3.buffer).readUInt32()));
                                messageSchema2.setOneofPresent(fieldNumber, iSlowPositionForFieldNumber, obj2);
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 63:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.requireWireType(0);
                                int i4 = ((CodedInputStream) gapBuffer3.buffer).readEnum();
                                messageSchema2.getEnumFieldVerifier(iSlowPositionForFieldNumber);
                                UnsafeUtil.putObject(obj2, iTypeAndOffsetAt & 1048575, Integer.valueOf(i4));
                                messageSchema2.setOneofPresent(fieldNumber, iSlowPositionForFieldNumber, obj2);
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 64:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.requireWireType(5);
                                UnsafeUtil.putObject(obj2, iTypeAndOffsetAt & 1048575, Integer.valueOf(((CodedInputStream) gapBuffer3.buffer).readSFixed32()));
                                messageSchema2.setOneofPresent(fieldNumber, iSlowPositionForFieldNumber, obj2);
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 65:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.requireWireType(1);
                                UnsafeUtil.putObject(obj2, iTypeAndOffsetAt & 1048575, Long.valueOf(((CodedInputStream) gapBuffer3.buffer).readSFixed64()));
                                messageSchema2.setOneofPresent(fieldNumber, iSlowPositionForFieldNumber, obj2);
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 66:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer3.requireWireType(0);
                                UnsafeUtil.putObject(obj2, iTypeAndOffsetAt & 1048575, Integer.valueOf(((CodedInputStream) gapBuffer3.buffer).readSInt32()));
                                messageSchema2.setOneofPresent(fieldNumber, iSlowPositionForFieldNumber, obj2);
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 67:
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                long j = iTypeAndOffsetAt & 1048575;
                                try {
                                    try {
                                        gapBuffer3.requireWireType(0);
                                        UnsafeUtil.putObject(obj2, j, Long.valueOf(((CodedInputStream) gapBuffer3.buffer).readSInt64()));
                                        messageSchema2.setOneofPresent(fieldNumber, iSlowPositionForFieldNumber, obj2);
                                        gapBuffer2 = gapBuffer3;
                                        extensionRegistryLite2 = extensionRegistryLite3;
                                        messageSchema = messageSchema2;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        messageSchema = messageSchema2;
                                        while (i2 < i) {
                                            messageSchema.filterMapUnknownEnumValues(iArr[i2], obj2, builderFromMessage);
                                            i2++;
                                        }
                                        if (builderFromMessage != null) {
                                            extensionSchemaLite.getClass();
                                            ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                        }
                                        throw th;
                                    }
                                } catch (InvalidProtocolBufferException.InvalidWireTypeException unused6) {
                                    gapBuffer2 = gapBuffer3;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    messageSchema = messageSchema2;
                                    extensionSchemaLite.getClass();
                                    if (builderFromMessage == null) {
                                        builderFromMessage = ExtensionSchemaLite.getBuilderFromMessage(obj2);
                                    }
                                    if (!ExtensionSchemaLite.mergeOneFieldFrom(0, gapBuffer2, builderFromMessage)) {
                                        while (i2 < i) {
                                            messageSchema.filterMapUnknownEnumValues(iArr[i2], obj2, builderFromMessage);
                                            i2++;
                                        }
                                        if (builderFromMessage == null) {
                                            return;
                                        }
                                        ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                    }
                                }
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            case 68:
                                MessageLite messageLite4 = (MessageLite) messageSchema2.mutableOneofMessageFieldForMerge(fieldNumber, iSlowPositionForFieldNumber, obj2);
                                Schema messageFieldSchema4 = messageSchema2.getMessageFieldSchema(iSlowPositionForFieldNumber);
                                gapBuffer3.requireWireType(3);
                                gapBuffer3.mergeGroupFieldInternal(messageLite4, messageFieldSchema4, extensionRegistryLite3);
                                messageSchema2.storeOneofMessageField(fieldNumber, iSlowPositionForFieldNumber, obj2, messageLite4);
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                            default:
                                if (builderFromMessage == null) {
                                    try {
                                        extensionSchemaLite2.getClass();
                                        builderFromMessage = ExtensionSchemaLite.getBuilderFromMessage(obj2);
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused7) {
                                        extensionSchemaLite = extensionSchemaLite2;
                                        iArr = iArr2;
                                        gapBuffer2 = gapBuffer3;
                                        extensionRegistryLite2 = extensionRegistryLite3;
                                        messageSchema = messageSchema2;
                                        extensionSchemaLite.getClass();
                                        if (builderFromMessage == null) {
                                            builderFromMessage = ExtensionSchemaLite.getBuilderFromMessage(obj2);
                                        }
                                        if (!ExtensionSchemaLite.mergeOneFieldFrom(0, gapBuffer2, builderFromMessage)) {
                                            while (i2 < i) {
                                                messageSchema.filterMapUnknownEnumValues(iArr[i2], obj2, builderFromMessage);
                                                i2++;
                                            }
                                            if (builderFromMessage == null) {
                                                return;
                                            }
                                            ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
                                        }
                                    }
                                }
                                extensionSchemaLite2.getClass();
                                if (!ExtensionSchemaLite.mergeOneFieldFrom(0, gapBuffer3, builderFromMessage)) {
                                    while (i2 < i) {
                                        messageSchema2.filterMapUnknownEnumValues(iArr2[i2], obj2, builderFromMessage);
                                        i2++;
                                    }
                                    if (builderFromMessage == null) {
                                        return;
                                    }
                                }
                                extensionSchemaLite = extensionSchemaLite2;
                                iArr = iArr2;
                                gapBuffer2 = gapBuffer3;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                messageSchema = messageSchema2;
                                messageSchema2 = messageSchema;
                                gapBuffer3 = gapBuffer2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                extensionSchemaLite2 = extensionSchemaLite;
                                iArr2 = iArr;
                                break;
                        }
                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused8) {
                        extensionSchemaLite = extensionSchemaLite2;
                        iArr = iArr2;
                    }
                } else if (fieldNumber == Integer.MAX_VALUE) {
                    while (i2 < i) {
                        messageSchema2.filterMapUnknownEnumValues(iArr2[i2], obj2, builderFromMessage);
                        i2++;
                    }
                    if (builderFromMessage == null) {
                        return;
                    } else {
                        extensionSchemaLite2.getClass();
                    }
                } else {
                    extensionSchemaLite2.getClass();
                    if (builderFromMessage == null) {
                        builderFromMessage = ExtensionSchemaLite.getBuilderFromMessage(obj2);
                    }
                    if (!ExtensionSchemaLite.mergeOneFieldFrom(0, gapBuffer3, builderFromMessage)) {
                        while (i2 < i) {
                            messageSchema2.filterMapUnknownEnumValues(iArr2[i2], obj2, builderFromMessage);
                            i2++;
                        }
                        if (builderFromMessage == null) {
                            return;
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                messageSchema = messageSchema2;
                extensionSchemaLite = extensionSchemaLite2;
                iArr = iArr2;
            }
        }
        ((GeneratedMessageLite) obj2).unknownFields = builderFromMessage;
    }

    public final void mergeMap(int i, Object obj, Object obj2) {
        long jTypeAndOffsetAt = typeAndOffsetAt(i) & 1048575;
        Object object = UnsafeUtil.getObject(jTypeAndOffsetAt, obj);
        if (object == null) {
            object = MapFieldLite.EMPTY_MAP_FIELD.mutableCopy();
            UnsafeUtil.putObject(obj, jTypeAndOffsetAt, object);
        } else if (!((MapFieldLite) object).isMutable) {
            Object objMutableCopy = MapFieldLite.EMPTY_MAP_FIELD.mutableCopy();
            Utf8.MobileProcessor.mergeFrom(objMutableCopy, object);
            UnsafeUtil.putObject(obj, jTypeAndOffsetAt, objMutableCopy);
            object = objMutableCopy;
        }
        Fragment$5$$ExternalSyntheticOutline0.m833m(obj2);
        throw null;
    }

    public final void mergeMessage(int i, Object obj, Object obj2) {
        if (isFieldPresent(i, obj2)) {
            long jTypeAndOffsetAt = typeAndOffsetAt(i) & 1048575;
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(obj2, jTypeAndOffsetAt);
            if (object == null) {
                PathKt$$ExternalSyntheticBUOutline0.m(this.buffer[i], obj2);
                return;
            }
            Schema messageFieldSchema = getMessageFieldSchema(i);
            if (!isFieldPresent(i, obj)) {
                if (isMutable(object)) {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(obj, jTypeAndOffsetAt, objNewInstance);
                } else {
                    unsafe.putObject(obj, jTypeAndOffsetAt, object);
                }
                setFieldPresent(i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jTypeAndOffsetAt);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(obj, jTypeAndOffsetAt, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    public final void mergeOneofMessage(int i, Object obj, Object obj2) {
        int[] iArr = this.buffer;
        int i2 = iArr[i];
        if (isOneofPresent(i2, i, obj2)) {
            long jTypeAndOffsetAt = typeAndOffsetAt(i) & 1048575;
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(obj2, jTypeAndOffsetAt);
            if (object == null) {
                PathKt$$ExternalSyntheticBUOutline0.m(iArr[i], obj2);
                return;
            }
            Schema messageFieldSchema = getMessageFieldSchema(i);
            if (!isOneofPresent(i2, i, obj)) {
                if (isMutable(object)) {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(obj, jTypeAndOffsetAt, objNewInstance);
                } else {
                    unsafe.putObject(obj, jTypeAndOffsetAt, object);
                }
                setOneofPresent(i2, i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jTypeAndOffsetAt);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(obj, jTypeAndOffsetAt, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    public final Object mutableMessageFieldForMerge(int i, Object obj) {
        Schema messageFieldSchema = getMessageFieldSchema(i);
        long jTypeAndOffsetAt = typeAndOffsetAt(i) & 1048575;
        if (!isFieldPresent(i, obj)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(obj, jTypeAndOffsetAt);
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    public final Object mutableOneofMessageFieldForMerge(int i, int i2, Object obj) {
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        if (!isOneofPresent(i, i2, obj)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(obj, typeAndOffsetAt(i2) & 1048575);
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    @Override // com.google.protobuf.Schema
    public final Object newInstance() {
        return ((GeneratedMessageLite) this.defaultInstance).newMutableInstance();
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 34681. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final int parseMessage(java.lang.Object r33, byte[] r34, int r35, int r36, int r37, com.google.protobuf.ArrayDecoders$Registers r38) {
        /*
            Method dump skipped, instruction units count: 3468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.parseMessage(java.lang.Object, byte[], int, int, int, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    public final void readGroupList(Object obj, long j, GapBuffer gapBuffer, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        int tag;
        Internal.ProtobufList protobufListMutableListAt = Utf8.MobileProcessor.mutableListAt(j, obj);
        CodedInputStream codedInputStream = (CodedInputStream) gapBuffer.buffer;
        int i = gapBuffer.capacity;
        if ((i & 7) != 3) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            Object objNewInstance = schema.newInstance();
            gapBuffer.mergeGroupFieldInternal(objNewInstance, schema, extensionRegistryLite);
            schema.makeImmutable(objNewInstance);
            protobufListMutableListAt.add(objNewInstance);
            if (codedInputStream.isAtEnd() || gapBuffer.gapEnd != 0) {
                return;
            } else {
                tag = codedInputStream.readTag();
            }
        } while (tag == i);
        gapBuffer.gapEnd = tag;
    }

    public final void readMessageList(Object obj, int i, GapBuffer gapBuffer, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        int tag;
        Internal.ProtobufList protobufListMutableListAt = Utf8.MobileProcessor.mutableListAt(1048575 & i, obj);
        CodedInputStream codedInputStream = (CodedInputStream) gapBuffer.buffer;
        int i2 = gapBuffer.capacity;
        if ((i2 & 7) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            Object objNewInstance = schema.newInstance();
            gapBuffer.mergeMessageFieldInternal(objNewInstance, schema, extensionRegistryLite);
            schema.makeImmutable(objNewInstance);
            protobufListMutableListAt.add(objNewInstance);
            if (codedInputStream.isAtEnd() || gapBuffer.gapEnd != 0) {
                return;
            } else {
                tag = codedInputStream.readTag();
            }
        } while (tag == i2);
        gapBuffer.gapEnd = tag;
    }

    public final void readString(int i, GapBuffer gapBuffer, Object obj) throws InvalidProtocolBufferException.InvalidWireTypeException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException {
        if ((536870912 & i) != 0) {
            gapBuffer.requireWireType(2);
            UnsafeUtil.putObject(obj, i & 1048575, ((CodedInputStream) gapBuffer.buffer).readStringRequireUtf8());
        } else if (!this.lite) {
            UnsafeUtil.putObject(obj, i & 1048575, gapBuffer.m759readBytes());
        } else {
            gapBuffer.requireWireType(2);
            UnsafeUtil.putObject(obj, i & 1048575, ((CodedInputStream) gapBuffer.buffer).readString());
        }
    }

    public final void setFieldPresent(int i, Object obj) {
        int i2 = this.buffer[i + 2];
        long j = 1048575 & i2;
        if (j == 1048575) {
            return;
        }
        UnsafeUtil.putInt((1 << (i2 >>> 20)) | UnsafeUtil.getInt(j, obj), j, obj);
    }

    public final void setOneofPresent(int i, int i2, Object obj) {
        UnsafeUtil.putInt(i, this.buffer[i2 + 2] & 1048575, obj);
    }

    public final int slowPositionForFieldNumber(int i, int i2) {
        int[] iArr = this.buffer;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final void storeMessageField(int i, Object obj, Object obj2) {
        UNSAFE.putObject(obj, typeAndOffsetAt(i) & 1048575, obj2);
        setFieldPresent(i, obj);
    }

    public final void storeOneofMessageField(int i, int i2, Object obj, Object obj2) {
        UNSAFE.putObject(obj, typeAndOffsetAt(i2) & 1048575, obj2);
        setOneofPresent(i, i2, obj);
    }

    public final int typeAndOffsetAt(int i) {
        return this.buffer[i + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Schema
    public final void writeTo(Object obj, ConnectionPool connectionPool) {
        char c;
        int i;
        boolean z;
        MessageSchema messageSchema = this;
        CodedOutputStream codedOutputStream = (CodedOutputStream) connectionPool.delegate;
        int[] iArr = messageSchema.buffer;
        int length = iArr.length;
        int i2 = 1048575;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iTypeAndOffsetAt = messageSchema.typeAndOffsetAt(i4);
            int i5 = iArr[i4];
            int iType = type(iTypeAndOffsetAt);
            Unsafe unsafe = UNSAFE;
            if (iType <= 17) {
                int i6 = iArr[i4 + 2];
                c = 1;
                int i7 = i6 & 1048575;
                if (i7 != i2) {
                    i3 = i7 == 1048575 ? 0 : unsafe.getInt(obj, i7);
                    i2 = i7;
                }
                i = 1 << (i6 >>> 20);
            } else {
                c = 1;
                i = 0;
            }
            long j = iTypeAndOffsetAt & 1048575;
            switch (iType) {
                case 0:
                    if (messageSchema.isFieldPresent(obj, i4, i2, i3, i)) {
                        double d = UnsafeUtil.MEMORY_ACCESSOR.getDouble(j, obj);
                        codedOutputStream.getClass();
                        codedOutputStream.writeFixed64(i5, Double.doubleToRawLongBits(d));
                    }
                    break;
                case 1:
                    if (messageSchema.isFieldPresent(obj, i4, i2, i3, i)) {
                        float f = UnsafeUtil.MEMORY_ACCESSOR.getFloat(j, obj);
                        codedOutputStream.getClass();
                        codedOutputStream.writeFixed32(i5, Float.floatToRawIntBits(f));
                    }
                    messageSchema = this;
                    break;
                case 2:
                    if (messageSchema.isFieldPresent(obj, i4, i2, i3, i)) {
                        codedOutputStream.writeUInt64(i5, unsafe.getLong(obj, j));
                    }
                    messageSchema = this;
                    break;
                case 3:
                    if (messageSchema.isFieldPresent(obj, i4, i2, i3, i)) {
                        codedOutputStream.writeUInt64(i5, unsafe.getLong(obj, j));
                    }
                    messageSchema = this;
                    break;
                case 4:
                    if (messageSchema.isFieldPresent(obj, i4, i2, i3, i)) {
                        codedOutputStream.writeInt32(i5, unsafe.getInt(obj, j));
                    }
                    messageSchema = this;
                    break;
                case 5:
                    if (messageSchema.isFieldPresent(obj, i4, i2, i3, i)) {
                        codedOutputStream.writeFixed64(i5, unsafe.getLong(obj, j));
                    }
                    messageSchema = this;
                    break;
                case 6:
                    if (messageSchema.isFieldPresent(obj, i4, i2, i3, i)) {
                        codedOutputStream.writeFixed32(i5, unsafe.getInt(obj, j));
                    }
                    messageSchema = this;
                    break;
                case 7:
                    if (messageSchema.isFieldPresent(obj, i4, i2, i3, i)) {
                        codedOutputStream.writeBool(i5, UnsafeUtil.MEMORY_ACCESSOR.getBoolean(j, obj));
                    }
                    messageSchema = this;
                    break;
                case 8:
                    if (messageSchema.isFieldPresent(obj, i4, i2, i3, i)) {
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof String) {
                            codedOutputStream.writeString(i5, (String) object);
                        } else {
                            codedOutputStream.writeBytes(i5, (ByteString) object);
                        }
                    }
                    messageSchema = this;
                    break;
                case 9:
                    if (messageSchema.isFieldPresent(obj, i4, i2, i3, i)) {
                        connectionPool.writeMessage(i5, unsafe.getObject(obj, j), messageSchema.getMessageFieldSchema(i4));
                    }
                    break;
                case 10:
                    if (messageSchema.isFieldPresent(obj, i4, i2, i3, i)) {
                        codedOutputStream.writeBytes(i5, (ByteString) unsafe.getObject(obj, j));
                    }
                    messageSchema = this;
                    break;
                case 11:
                    if (messageSchema.isFieldPresent(obj, i4, i2, i3, i)) {
                        codedOutputStream.writeUInt32(i5, unsafe.getInt(obj, j));
                    }
                    messageSchema = this;
                    break;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    if (messageSchema.isFieldPresent(obj, i4, i2, i3, i)) {
                        codedOutputStream.writeInt32(i5, unsafe.getInt(obj, j));
                    }
                    messageSchema = this;
                    break;
                case 13:
                    if (messageSchema.isFieldPresent(obj, i4, i2, i3, i)) {
                        codedOutputStream.writeFixed32(i5, unsafe.getInt(obj, j));
                    }
                    messageSchema = this;
                    break;
                case 14:
                    if (messageSchema.isFieldPresent(obj, i4, i2, i3, i)) {
                        codedOutputStream.writeFixed64(i5, unsafe.getLong(obj, j));
                    }
                    messageSchema = this;
                    break;
                case 15:
                    if (messageSchema.isFieldPresent(obj, i4, i2, i3, i)) {
                        int i8 = unsafe.getInt(obj, j);
                        codedOutputStream.writeUInt32(i5, (i8 >> 31) ^ (i8 << 1));
                    }
                    messageSchema = this;
                    break;
                case 16:
                    if (messageSchema.isFieldPresent(obj, i4, i2, i3, i)) {
                        long j2 = unsafe.getLong(obj, j);
                        codedOutputStream.writeUInt64(i5, (j2 << 1) ^ (j2 >> 63));
                    }
                    messageSchema = this;
                    break;
                case 17:
                    if (messageSchema.isFieldPresent(obj, i4, i2, i3, i)) {
                        connectionPool.writeGroup(i5, unsafe.getObject(obj, j), messageSchema.getMessageFieldSchema(i4));
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, false);
                    break;
                case 26:
                    int i9 = iArr[i4];
                    List list = (List) unsafe.getObject(obj, j);
                    Class cls = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    if (list != null && !list.isEmpty()) {
                        for (int i10 = 0; i10 < list.size(); i10++) {
                            codedOutputStream.writeString(i9, (String) list.get(i10));
                        }
                    }
                    break;
                case 27:
                    int i11 = iArr[i4];
                    List list2 = (List) unsafe.getObject(obj, j);
                    Schema messageFieldSchema = messageSchema.getMessageFieldSchema(i4);
                    Class cls2 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i12 = 0; i12 < list2.size(); i12++) {
                            connectionPool.writeMessage(i11, list2.get(i12), messageFieldSchema);
                        }
                    }
                    break;
                case 28:
                    int i13 = iArr[i4];
                    List list3 = (List) unsafe.getObject(obj, j);
                    Class cls3 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    if (list3 != null && !list3.isEmpty()) {
                        for (int i14 = 0; i14 < list3.size(); i14++) {
                            codedOutputStream.writeBytes(i13, (ByteString) list3.get(i14));
                        }
                    }
                    break;
                case 29:
                    z = false;
                    SchemaUtil.writeUInt32List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, false);
                    break;
                case 30:
                    z = false;
                    SchemaUtil.writeEnumList(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, false);
                    break;
                case 31:
                    z = false;
                    SchemaUtil.writeSFixed32List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, false);
                    break;
                case 32:
                    z = false;
                    SchemaUtil.writeSFixed64List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, false);
                    break;
                case 33:
                    z = false;
                    SchemaUtil.writeSInt32List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, false);
                    break;
                case 34:
                    z = false;
                    SchemaUtil.writeSInt64List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, c);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, c);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, c);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, c);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, c);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, c);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, c);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, c);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, c);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, c);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, c);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, c);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, c);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(iArr[i4], (List) unsafe.getObject(obj, j), connectionPool, c);
                    break;
                case 49:
                    int i15 = iArr[i4];
                    List list4 = (List) unsafe.getObject(obj, j);
                    Schema messageFieldSchema2 = messageSchema.getMessageFieldSchema(i4);
                    Class cls4 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i16 = 0; i16 < list4.size(); i16++) {
                            connectionPool.writeGroup(i15, list4.get(i16), messageFieldSchema2);
                        }
                    }
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        Fragment$5$$ExternalSyntheticOutline0.m833m(messageSchema.getMapFieldDefaultEntry(i4));
                        throw null;
                    }
                    break;
                case 51:
                    if (messageSchema.isOneofPresent(i5, i4, obj)) {
                        double dDoubleValue = ((Double) UnsafeUtil.getObject(j, obj)).doubleValue();
                        codedOutputStream.getClass();
                        codedOutputStream.writeFixed64(i5, Double.doubleToRawLongBits(dDoubleValue));
                    }
                    break;
                case 52:
                    if (messageSchema.isOneofPresent(i5, i4, obj)) {
                        float fFloatValue = ((Float) UnsafeUtil.getObject(j, obj)).floatValue();
                        codedOutputStream.getClass();
                        codedOutputStream.writeFixed32(i5, Float.floatToRawIntBits(fFloatValue));
                    }
                    break;
                case 53:
                    if (messageSchema.isOneofPresent(i5, i4, obj)) {
                        codedOutputStream.writeUInt64(i5, oneofLongAt(j, obj));
                    }
                    break;
                case 54:
                    if (messageSchema.isOneofPresent(i5, i4, obj)) {
                        codedOutputStream.writeUInt64(i5, oneofLongAt(j, obj));
                    }
                    break;
                case 55:
                    if (messageSchema.isOneofPresent(i5, i4, obj)) {
                        codedOutputStream.writeInt32(i5, oneofIntAt(j, obj));
                    }
                    break;
                case 56:
                    if (messageSchema.isOneofPresent(i5, i4, obj)) {
                        codedOutputStream.writeFixed64(i5, oneofLongAt(j, obj));
                    }
                    break;
                case 57:
                    if (messageSchema.isOneofPresent(i5, i4, obj)) {
                        codedOutputStream.writeFixed32(i5, oneofIntAt(j, obj));
                    }
                    break;
                case 58:
                    if (messageSchema.isOneofPresent(i5, i4, obj)) {
                        codedOutputStream.writeBool(i5, ((Boolean) UnsafeUtil.getObject(j, obj)).booleanValue());
                    }
                    break;
                case 59:
                    if (messageSchema.isOneofPresent(i5, i4, obj)) {
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof String) {
                            codedOutputStream.writeString(i5, (String) object2);
                        } else {
                            codedOutputStream.writeBytes(i5, (ByteString) object2);
                        }
                    }
                    break;
                case 60:
                    if (messageSchema.isOneofPresent(i5, i4, obj)) {
                        connectionPool.writeMessage(i5, unsafe.getObject(obj, j), messageSchema.getMessageFieldSchema(i4));
                    }
                    break;
                case 61:
                    if (messageSchema.isOneofPresent(i5, i4, obj)) {
                        codedOutputStream.writeBytes(i5, (ByteString) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (messageSchema.isOneofPresent(i5, i4, obj)) {
                        codedOutputStream.writeUInt32(i5, oneofIntAt(j, obj));
                    }
                    break;
                case 63:
                    if (messageSchema.isOneofPresent(i5, i4, obj)) {
                        codedOutputStream.writeInt32(i5, oneofIntAt(j, obj));
                    }
                    break;
                case 64:
                    if (messageSchema.isOneofPresent(i5, i4, obj)) {
                        codedOutputStream.writeFixed32(i5, oneofIntAt(j, obj));
                    }
                    break;
                case 65:
                    if (messageSchema.isOneofPresent(i5, i4, obj)) {
                        codedOutputStream.writeFixed64(i5, oneofLongAt(j, obj));
                    }
                    break;
                case 66:
                    if (messageSchema.isOneofPresent(i5, i4, obj)) {
                        int iOneofIntAt = oneofIntAt(j, obj);
                        codedOutputStream.writeUInt32(i5, (iOneofIntAt >> 31) ^ (iOneofIntAt << 1));
                    }
                    break;
                case 67:
                    if (messageSchema.isOneofPresent(i5, i4, obj)) {
                        long jOneofLongAt = oneofLongAt(j, obj);
                        codedOutputStream.writeUInt64(i5, (jOneofLongAt << c) ^ (jOneofLongAt >> 63));
                    }
                    break;
                case 68:
                    if (messageSchema.isOneofPresent(i5, i4, obj)) {
                        connectionPool.writeGroup(i5, unsafe.getObject(obj, j), messageSchema.getMessageFieldSchema(i4));
                    }
                    break;
                default:
                    break;
            }
        }
        messageSchema.unknownFieldSchema.getClass();
        ((GeneratedMessageLite) obj).unknownFields.writeTo(connectionPool);
    }

    public final boolean isFieldPresent(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return isFieldPresent(i, obj);
        }
        return (i3 & i4) != 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:9:0x0024  */
    @Override // com.google.protobuf.Schema
    public final void mergeFrom(Object obj, Object obj2) {
        Object obj3;
        checkMutable(obj);
        byte[] bArr = Internal.EMPTY_BYTE_ARRAY;
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.buffer;
            if (i < iArr.length) {
                int iTypeAndOffsetAt = typeAndOffsetAt(i);
                long j = 1048575 & iTypeAndOffsetAt;
                int i2 = iArr[i];
                switch (type(iTypeAndOffsetAt)) {
                    case 0:
                        if (!isFieldPresent(i, obj2)) {
                            obj3 = obj;
                        } else {
                            UnsafeUtil.MemoryAccessor memoryAccessor = UnsafeUtil.MEMORY_ACCESSOR;
                            obj3 = obj;
                            memoryAccessor.putDouble(obj3, j, memoryAccessor.getDouble(j, obj2));
                            setFieldPresent(i, obj3);
                        }
                        break;
                    case 1:
                        if (isFieldPresent(i, obj2)) {
                            UnsafeUtil.MemoryAccessor memoryAccessor2 = UnsafeUtil.MEMORY_ACCESSOR;
                            memoryAccessor2.putFloat(obj, j, memoryAccessor2.getFloat(j, obj2));
                            setFieldPresent(i, obj);
                        }
                        obj3 = obj;
                        break;
                    case 2:
                        if (isFieldPresent(i, obj2)) {
                            UnsafeUtil.putLong(obj, j, UnsafeUtil.getLong(j, obj2));
                            setFieldPresent(i, obj);
                        }
                        obj3 = obj;
                        break;
                    case 3:
                        if (isFieldPresent(i, obj2)) {
                            UnsafeUtil.putLong(obj, j, UnsafeUtil.getLong(j, obj2));
                            setFieldPresent(i, obj);
                        }
                        obj3 = obj;
                        break;
                    case 4:
                        if (isFieldPresent(i, obj2)) {
                            UnsafeUtil.putInt(UnsafeUtil.getInt(j, obj2), j, obj);
                            setFieldPresent(i, obj);
                        }
                        obj3 = obj;
                        break;
                    case 5:
                        if (isFieldPresent(i, obj2)) {
                            UnsafeUtil.putLong(obj, j, UnsafeUtil.getLong(j, obj2));
                            setFieldPresent(i, obj);
                        }
                        obj3 = obj;
                        break;
                    case 6:
                        if (isFieldPresent(i, obj2)) {
                            UnsafeUtil.putInt(UnsafeUtil.getInt(j, obj2), j, obj);
                            setFieldPresent(i, obj);
                        }
                        obj3 = obj;
                        break;
                    case 7:
                        if (isFieldPresent(i, obj2)) {
                            UnsafeUtil.MemoryAccessor memoryAccessor3 = UnsafeUtil.MEMORY_ACCESSOR;
                            memoryAccessor3.putBoolean(obj, j, memoryAccessor3.getBoolean(j, obj2));
                            setFieldPresent(i, obj);
                        }
                        obj3 = obj;
                        break;
                    case 8:
                        if (isFieldPresent(i, obj2)) {
                            UnsafeUtil.putObject(obj, j, UnsafeUtil.getObject(j, obj2));
                            setFieldPresent(i, obj);
                        }
                        obj3 = obj;
                        break;
                    case 9:
                        mergeMessage(i, obj, obj2);
                        obj3 = obj;
                        break;
                    case 10:
                        if (isFieldPresent(i, obj2)) {
                            UnsafeUtil.putObject(obj, j, UnsafeUtil.getObject(j, obj2));
                            setFieldPresent(i, obj);
                        }
                        obj3 = obj;
                        break;
                    case 11:
                        if (isFieldPresent(i, obj2)) {
                            UnsafeUtil.putInt(UnsafeUtil.getInt(j, obj2), j, obj);
                            setFieldPresent(i, obj);
                        }
                        obj3 = obj;
                        break;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        if (isFieldPresent(i, obj2)) {
                            UnsafeUtil.putInt(UnsafeUtil.getInt(j, obj2), j, obj);
                            setFieldPresent(i, obj);
                        }
                        obj3 = obj;
                        break;
                    case 13:
                        if (isFieldPresent(i, obj2)) {
                            UnsafeUtil.putInt(UnsafeUtil.getInt(j, obj2), j, obj);
                            setFieldPresent(i, obj);
                        }
                        obj3 = obj;
                        break;
                    case 14:
                        if (isFieldPresent(i, obj2)) {
                            UnsafeUtil.putLong(obj, j, UnsafeUtil.getLong(j, obj2));
                            setFieldPresent(i, obj);
                        }
                        obj3 = obj;
                        break;
                    case 15:
                        if (isFieldPresent(i, obj2)) {
                            UnsafeUtil.putInt(UnsafeUtil.getInt(j, obj2), j, obj);
                            setFieldPresent(i, obj);
                        }
                        obj3 = obj;
                        break;
                    case 16:
                        if (isFieldPresent(i, obj2)) {
                            UnsafeUtil.putLong(obj, j, UnsafeUtil.getLong(j, obj2));
                            setFieldPresent(i, obj);
                        }
                        obj3 = obj;
                        break;
                    case 17:
                        mergeMessage(i, obj, obj2);
                        obj3 = obj;
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        Internal.ProtobufList protobufListMutableCopyWithCapacity = (Internal.ProtobufList) UnsafeUtil.getObject(j, obj);
                        Internal.ProtobufList protobufList = (Internal.ProtobufList) UnsafeUtil.getObject(j, obj2);
                        int size = protobufListMutableCopyWithCapacity.size();
                        int size2 = protobufList.size();
                        if (size > 0 && size2 > 0) {
                            if (!((AbstractProtobufList) protobufListMutableCopyWithCapacity).isMutable) {
                                protobufListMutableCopyWithCapacity = protobufListMutableCopyWithCapacity.mutableCopyWithCapacity(size2 + size);
                            }
                            protobufListMutableCopyWithCapacity.addAll(protobufList);
                        }
                        if (size > 0) {
                            protobufList = protobufListMutableCopyWithCapacity;
                        }
                        UnsafeUtil.putObject(obj, j, protobufList);
                        obj3 = obj;
                        break;
                    case 50:
                        Class cls = SchemaUtil.GENERATED_MESSAGE_CLASS;
                        UnsafeUtil.putObject(obj, j, Utf8.MobileProcessor.mergeFrom(UnsafeUtil.getObject(j, obj), UnsafeUtil.getObject(j, obj2)));
                        obj3 = obj;
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (isOneofPresent(i2, i, obj2)) {
                            UnsafeUtil.putObject(obj, j, UnsafeUtil.getObject(j, obj2));
                            setOneofPresent(i2, i, obj);
                        }
                        obj3 = obj;
                        break;
                    case 60:
                        mergeOneofMessage(i, obj, obj2);
                        obj3 = obj;
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (isOneofPresent(i2, i, obj2)) {
                            UnsafeUtil.putObject(obj, j, UnsafeUtil.getObject(j, obj2));
                            setOneofPresent(i2, i, obj);
                        }
                        obj3 = obj;
                        break;
                    case 68:
                        mergeOneofMessage(i, obj, obj2);
                        obj3 = obj;
                        break;
                    default:
                        obj3 = obj;
                        break;
                }
                i += 3;
                obj = obj3;
            } else {
                SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, obj, obj2);
                return;
            }
        }
    }

    @Override // com.google.protobuf.Schema
    public final void mergeFrom(Object obj, byte[] bArr, int i, int i2, ArrayDecoders$Registers arrayDecoders$Registers) {
        parseMessage(obj, bArr, i, i2, 0, arrayDecoders$Registers);
    }
}
