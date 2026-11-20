package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SchemaUtil {
    public static final Class GENERATED_MESSAGE_CLASS;
    public static final UnknownFieldSetLiteSchema UNKNOWN_FIELD_SET_FULL_SCHEMA;
    public static final UnknownFieldSetLiteSchema UNKNOWN_FIELD_SET_LITE_SCHEMA;

    static {
        Class<?> cls;
        Class<?> cls2;
        Protobuf protobuf = Protobuf.INSTANCE;
        UnknownFieldSetLiteSchema unknownFieldSetLiteSchema = null;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        GENERATED_MESSAGE_CLASS = cls;
        try {
            Protobuf protobuf2 = Protobuf.INSTANCE;
            try {
                cls2 = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
            } catch (Throwable unused2) {
                cls2 = null;
            }
            if (cls2 != null) {
                unknownFieldSetLiteSchema = (UnknownFieldSetLiteSchema) cls2.getConstructor(null).newInstance(null);
            }
        } catch (Throwable unused3) {
        }
        UNKNOWN_FIELD_SET_FULL_SCHEMA = unknownFieldSetLiteSchema;
        UNKNOWN_FIELD_SET_LITE_SCHEMA = new UnknownFieldSetLiteSchema();
    }

    public static int computeSizeEnumListNoTag(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeUInt64SizeNoTag = 0;
        for (int i = 0; i < size; i++) {
            iComputeUInt64SizeNoTag += CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) list.get(i)).intValue());
        }
        return iComputeUInt64SizeNoTag;
    }

    public static int computeSizeFixed32List(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream$OutputStreamEncoder.computeTagSize(i) + 4) * size;
    }

    public static int computeSizeFixed64List(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream$OutputStreamEncoder.computeTagSize(i) + 8) * size;
    }

    public static int computeSizeInt32ListNoTag(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeUInt64SizeNoTag = 0;
        for (int i = 0; i < size; i++) {
            iComputeUInt64SizeNoTag += CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) list.get(i)).intValue());
        }
        return iComputeUInt64SizeNoTag;
    }

    public static int computeSizeInt64ListNoTag(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeUInt64SizeNoTag = 0;
        for (int i = 0; i < size; i++) {
            iComputeUInt64SizeNoTag += CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) list.get(i)).longValue());
        }
        return iComputeUInt64SizeNoTag;
    }

    public static int computeSizeSInt32ListNoTag(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeUInt32SizeNoTag = 0;
        for (int i = 0; i < size; i++) {
            int iIntValue = ((Integer) list.get(i)).intValue();
            iComputeUInt32SizeNoTag += CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue >> 31) ^ (iIntValue << 1));
        }
        return iComputeUInt32SizeNoTag;
    }

    public static int computeSizeSInt64ListNoTag(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeUInt64SizeNoTag = 0;
        for (int i = 0; i < size; i++) {
            long jLongValue = ((Long) list.get(i)).longValue();
            iComputeUInt64SizeNoTag += CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue >> 63) ^ (jLongValue << 1));
        }
        return iComputeUInt64SizeNoTag;
    }

    public static int computeSizeUInt32ListNoTag(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeUInt32SizeNoTag = 0;
        for (int i = 0; i < size; i++) {
            iComputeUInt32SizeNoTag += CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) list.get(i)).intValue());
        }
        return iComputeUInt32SizeNoTag;
    }

    public static int computeSizeUInt64ListNoTag(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeUInt64SizeNoTag = 0;
        for (int i = 0; i < size; i++) {
            iComputeUInt64SizeNoTag += CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) list.get(i)).longValue());
        }
        return iComputeUInt64SizeNoTag;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void mergeUnknownFields(UnknownFieldSetLiteSchema unknownFieldSetLiteSchema, Object obj, Object obj2) {
        unknownFieldSetLiteSchema.getClass();
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        UnknownFieldSetLite unknownFieldSetLite2 = ((GeneratedMessageLite) obj2).unknownFields;
        UnknownFieldSetLite unknownFieldSetLite3 = UnknownFieldSetLite.DEFAULT_INSTANCE;
        if (!unknownFieldSetLite3.equals(unknownFieldSetLite2)) {
            if (unknownFieldSetLite3.equals(unknownFieldSetLite)) {
                int i = unknownFieldSetLite.count + unknownFieldSetLite2.count;
                int[] iArrCopyOf = Arrays.copyOf(unknownFieldSetLite.tags, i);
                System.arraycopy(unknownFieldSetLite2.tags, 0, iArrCopyOf, unknownFieldSetLite.count, unknownFieldSetLite2.count);
                Object[] objArrCopyOf = Arrays.copyOf(unknownFieldSetLite.objects, i);
                System.arraycopy(unknownFieldSetLite2.objects, 0, objArrCopyOf, unknownFieldSetLite.count, unknownFieldSetLite2.count);
                unknownFieldSetLite = new UnknownFieldSetLite(i, iArrCopyOf, objArrCopyOf, true);
            } else {
                unknownFieldSetLite.getClass();
                if (!unknownFieldSetLite2.equals(unknownFieldSetLite3)) {
                    if (!unknownFieldSetLite.isMutable) {
                        throw new UnsupportedOperationException();
                    }
                    int i2 = unknownFieldSetLite.count + unknownFieldSetLite2.count;
                    unknownFieldSetLite.ensureCapacity(i2);
                    System.arraycopy(unknownFieldSetLite2.tags, 0, unknownFieldSetLite.tags, unknownFieldSetLite.count, unknownFieldSetLite2.count);
                    System.arraycopy(unknownFieldSetLite2.objects, 0, unknownFieldSetLite.objects, unknownFieldSetLite.count, unknownFieldSetLite2.count);
                    unknownFieldSetLite.count = i2;
                }
            }
        }
        generatedMessageLite.unknownFields = unknownFieldSetLite;
    }

    public static boolean safeEquals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void writeBoolList(int i, List list, ManifestSchemaFactory manifestSchemaFactory, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = (CodedOutputStream$OutputStreamEncoder) manifestSchemaFactory.messageInfoFactory;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                codedOutputStream$OutputStreamEncoder.writeBool(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        codedOutputStream$OutputStreamEncoder.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).getClass();
            i3++;
        }
        codedOutputStream$OutputStreamEncoder.writeUInt32NoTag(i3);
        while (i2 < list.size()) {
            codedOutputStream$OutputStreamEncoder.write(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public static void writeDoubleList(int i, List list, ManifestSchemaFactory manifestSchemaFactory, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = (CodedOutputStream$OutputStreamEncoder) manifestSchemaFactory.messageInfoFactory;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                codedOutputStream$OutputStreamEncoder.writeFixed64(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        codedOutputStream$OutputStreamEncoder.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            i3 += 8;
        }
        codedOutputStream$OutputStreamEncoder.writeUInt32NoTag(i3);
        while (i2 < list.size()) {
            codedOutputStream$OutputStreamEncoder.writeFixed64NoTag(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    public static void writeEnumList(int i, List list, ManifestSchemaFactory manifestSchemaFactory, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = (CodedOutputStream$OutputStreamEncoder) manifestSchemaFactory.messageInfoFactory;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                codedOutputStream$OutputStreamEncoder.writeInt32(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        codedOutputStream$OutputStreamEncoder.writeTag(i, 2);
        int iComputeUInt64SizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeUInt64SizeNoTag += CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) list.get(i3)).intValue());
        }
        codedOutputStream$OutputStreamEncoder.writeUInt32NoTag(iComputeUInt64SizeNoTag);
        while (i2 < list.size()) {
            codedOutputStream$OutputStreamEncoder.writeInt32NoTag(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void writeFixed32List(int i, List list, ManifestSchemaFactory manifestSchemaFactory, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = (CodedOutputStream$OutputStreamEncoder) manifestSchemaFactory.messageInfoFactory;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                codedOutputStream$OutputStreamEncoder.writeFixed32(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        codedOutputStream$OutputStreamEncoder.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            i3 += 4;
        }
        codedOutputStream$OutputStreamEncoder.writeUInt32NoTag(i3);
        while (i2 < list.size()) {
            codedOutputStream$OutputStreamEncoder.writeFixed32NoTag(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void writeFixed64List(int i, List list, ManifestSchemaFactory manifestSchemaFactory, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = (CodedOutputStream$OutputStreamEncoder) manifestSchemaFactory.messageInfoFactory;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                codedOutputStream$OutputStreamEncoder.writeFixed64(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        codedOutputStream$OutputStreamEncoder.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            i3 += 8;
        }
        codedOutputStream$OutputStreamEncoder.writeUInt32NoTag(i3);
        while (i2 < list.size()) {
            codedOutputStream$OutputStreamEncoder.writeFixed64NoTag(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void writeFloatList(int i, List list, ManifestSchemaFactory manifestSchemaFactory, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = (CodedOutputStream$OutputStreamEncoder) manifestSchemaFactory.messageInfoFactory;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                codedOutputStream$OutputStreamEncoder.writeFixed32(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        codedOutputStream$OutputStreamEncoder.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).getClass();
            i3 += 4;
        }
        codedOutputStream$OutputStreamEncoder.writeUInt32NoTag(i3);
        while (i2 < list.size()) {
            codedOutputStream$OutputStreamEncoder.writeFixed32NoTag(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    public static void writeInt32List(int i, List list, ManifestSchemaFactory manifestSchemaFactory, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = (CodedOutputStream$OutputStreamEncoder) manifestSchemaFactory.messageInfoFactory;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                codedOutputStream$OutputStreamEncoder.writeInt32(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        codedOutputStream$OutputStreamEncoder.writeTag(i, 2);
        int iComputeUInt64SizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeUInt64SizeNoTag += CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) list.get(i3)).intValue());
        }
        codedOutputStream$OutputStreamEncoder.writeUInt32NoTag(iComputeUInt64SizeNoTag);
        while (i2 < list.size()) {
            codedOutputStream$OutputStreamEncoder.writeInt32NoTag(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void writeInt64List(int i, List list, ManifestSchemaFactory manifestSchemaFactory, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = (CodedOutputStream$OutputStreamEncoder) manifestSchemaFactory.messageInfoFactory;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                codedOutputStream$OutputStreamEncoder.writeUInt64(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        codedOutputStream$OutputStreamEncoder.writeTag(i, 2);
        int iComputeUInt64SizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeUInt64SizeNoTag += CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) list.get(i3)).longValue());
        }
        codedOutputStream$OutputStreamEncoder.writeUInt32NoTag(iComputeUInt64SizeNoTag);
        while (i2 < list.size()) {
            codedOutputStream$OutputStreamEncoder.writeUInt64NoTag(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void writeSFixed32List(int i, List list, ManifestSchemaFactory manifestSchemaFactory, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = (CodedOutputStream$OutputStreamEncoder) manifestSchemaFactory.messageInfoFactory;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                codedOutputStream$OutputStreamEncoder.writeFixed32(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        codedOutputStream$OutputStreamEncoder.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            i3 += 4;
        }
        codedOutputStream$OutputStreamEncoder.writeUInt32NoTag(i3);
        while (i2 < list.size()) {
            codedOutputStream$OutputStreamEncoder.writeFixed32NoTag(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void writeSFixed64List(int i, List list, ManifestSchemaFactory manifestSchemaFactory, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = (CodedOutputStream$OutputStreamEncoder) manifestSchemaFactory.messageInfoFactory;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                codedOutputStream$OutputStreamEncoder.writeFixed64(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        codedOutputStream$OutputStreamEncoder.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            i3 += 8;
        }
        codedOutputStream$OutputStreamEncoder.writeUInt32NoTag(i3);
        while (i2 < list.size()) {
            codedOutputStream$OutputStreamEncoder.writeFixed64NoTag(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void writeSInt32List(int i, List list, ManifestSchemaFactory manifestSchemaFactory, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = (CodedOutputStream$OutputStreamEncoder) manifestSchemaFactory.messageInfoFactory;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                codedOutputStream$OutputStreamEncoder.writeUInt32(i, (iIntValue >> 31) ^ (iIntValue << 1));
                i2++;
            }
            return;
        }
        codedOutputStream$OutputStreamEncoder.writeTag(i, 2);
        int iComputeUInt32SizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int iIntValue2 = ((Integer) list.get(i3)).intValue();
            iComputeUInt32SizeNoTag += CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue2 >> 31) ^ (iIntValue2 << 1));
        }
        codedOutputStream$OutputStreamEncoder.writeUInt32NoTag(iComputeUInt32SizeNoTag);
        while (i2 < list.size()) {
            int iIntValue3 = ((Integer) list.get(i2)).intValue();
            codedOutputStream$OutputStreamEncoder.writeUInt32NoTag((iIntValue3 >> 31) ^ (iIntValue3 << 1));
            i2++;
        }
    }

    public static void writeSInt64List(int i, List list, ManifestSchemaFactory manifestSchemaFactory, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = (CodedOutputStream$OutputStreamEncoder) manifestSchemaFactory.messageInfoFactory;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                long jLongValue = ((Long) list.get(i2)).longValue();
                codedOutputStream$OutputStreamEncoder.writeUInt64(i, (jLongValue >> 63) ^ (jLongValue << 1));
                i2++;
            }
            return;
        }
        codedOutputStream$OutputStreamEncoder.writeTag(i, 2);
        int iComputeUInt64SizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iComputeUInt64SizeNoTag += CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue2 >> 63) ^ (jLongValue2 << 1));
        }
        codedOutputStream$OutputStreamEncoder.writeUInt32NoTag(iComputeUInt64SizeNoTag);
        while (i2 < list.size()) {
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            codedOutputStream$OutputStreamEncoder.writeUInt64NoTag((jLongValue3 >> 63) ^ (jLongValue3 << 1));
            i2++;
        }
    }

    public static void writeUInt32List(int i, List list, ManifestSchemaFactory manifestSchemaFactory, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = (CodedOutputStream$OutputStreamEncoder) manifestSchemaFactory.messageInfoFactory;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                codedOutputStream$OutputStreamEncoder.writeUInt32(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        codedOutputStream$OutputStreamEncoder.writeTag(i, 2);
        int iComputeUInt32SizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeUInt32SizeNoTag += CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) list.get(i3)).intValue());
        }
        codedOutputStream$OutputStreamEncoder.writeUInt32NoTag(iComputeUInt32SizeNoTag);
        while (i2 < list.size()) {
            codedOutputStream$OutputStreamEncoder.writeUInt32NoTag(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void writeUInt64List(int i, List list, ManifestSchemaFactory manifestSchemaFactory, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = (CodedOutputStream$OutputStreamEncoder) manifestSchemaFactory.messageInfoFactory;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                codedOutputStream$OutputStreamEncoder.writeUInt64(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        codedOutputStream$OutputStreamEncoder.writeTag(i, 2);
        int iComputeUInt64SizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeUInt64SizeNoTag += CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) list.get(i3)).longValue());
        }
        codedOutputStream$OutputStreamEncoder.writeUInt32NoTag(iComputeUInt64SizeNoTag);
        while (i2 < list.size()) {
            codedOutputStream$OutputStreamEncoder.writeUInt64NoTag(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static Object filterUnknownEnumList(Object obj, int i, Internal.ProtobufList protobufList, Object obj2, UnknownFieldSetLiteSchema unknownFieldSetLiteSchema) {
        return obj2;
    }
}
