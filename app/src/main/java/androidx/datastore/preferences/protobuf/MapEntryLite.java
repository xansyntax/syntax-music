package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.PreferencesProto$Value;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MapEntryLite {
    public final Metadata metadata;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Metadata {
        public final Object defaultValue;
        public final WireFormat$FieldType keyType;
        public final WireFormat$FieldType valueType;

        public Metadata(WireFormat$FieldType wireFormat$FieldType, WireFormat$FieldType wireFormat$FieldType2, Object obj) {
            this.keyType = wireFormat$FieldType;
            this.valueType = wireFormat$FieldType2;
            this.defaultValue = obj;
        }
    }

    public MapEntryLite(WireFormat$FieldType wireFormat$FieldType, WireFormat$FieldType wireFormat$FieldType2, PreferencesProto$Value preferencesProto$Value) {
        this.metadata = new Metadata(wireFormat$FieldType, wireFormat$FieldType2, preferencesProto$Value);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0100  */
    /* JADX WARN: Code duplicated, block: B:41:0x0109  */
    /* JADX WARN: Code duplicated, block: B:43:0x010f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0120  */
    /* JADX WARN: Code duplicated, block: B:45:0x0131  */
    /* JADX WARN: Code duplicated, block: B:47:0x0139  */
    /* JADX WARN: Code duplicated, block: B:49:0x0141  */
    /* JADX WARN: Code duplicated, block: B:50:0x014e  */
    /* JADX WARN: Code duplicated, block: B:51:0x015a  */
    /* JADX WARN: Code duplicated, block: B:53:0x015e  */
    /* JADX WARN: Code duplicated, block: B:55:0x016c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0174  */
    /* JADX WARN: Code duplicated, block: B:57:0x0181  */
    /* JADX WARN: Code duplicated, block: B:58:0x018a  */
    /* JADX WARN: Code duplicated, block: B:60:0x018e  */
    /* JADX WARN: Code duplicated, block: B:61:0x0199  */
    /* JADX WARN: Code duplicated, block: B:62:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:63:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:64:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:65:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:66:0x01be  */
    /* JADX WARN: Code duplicated, block: B:67:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:68:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:69:0x01db  */
    public static int computeSerializedSize(Metadata metadata, Object obj, Object obj2) {
        int iComputeUInt64SizeNoTag;
        int size;
        int iComputeUInt32SizeNoTag;
        int i;
        WireFormat$FieldType wireFormat$FieldType;
        int iComputeTagSize;
        int size2;
        int iComputeUInt32SizeNoTag2;
        WireFormat$FieldType wireFormat$FieldType2 = metadata.keyType;
        int i2 = FieldSet.$r8$clinit;
        int iComputeUInt64SizeNoTag2 = 1;
        int iComputeTagSize2 = CodedOutputStream$OutputStreamEncoder.computeTagSize(1);
        WireFormat$FieldType.AnonymousClass2 anonymousClass2 = WireFormat$FieldType.GROUP;
        if (wireFormat$FieldType2 == anonymousClass2) {
            iComputeTagSize2 *= 2;
        }
        switch (wireFormat$FieldType2.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                iComputeUInt64SizeNoTag = 8;
                i = iComputeUInt64SizeNoTag + iComputeTagSize2;
                wireFormat$FieldType = metadata.valueType;
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(2);
                if (wireFormat$FieldType == anonymousClass2) {
                    iComputeTagSize *= 2;
                }
                switch (wireFormat$FieldType.ordinal()) {
                    case 0:
                        ((Double) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 1:
                        ((Float) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 2:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 3:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 4:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 5:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 6:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 7:
                        ((Boolean) obj2).getClass();
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 8:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                            iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        } else {
                            iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj2);
                        }
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 9:
                        iComputeUInt64SizeNoTag2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 10:
                        size2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 11:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        } else {
                            size2 = ((byte[]) obj2).length;
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        }
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 13:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 14:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 15:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 16:
                        int iIntValue = ((Integer) obj2).intValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue >> 31) ^ (iIntValue << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 17:
                        long jLongValue = ((Long) obj2).longValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue >> 63) ^ (jLongValue << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    default:
                        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                }
            case 1:
                ((Float) obj).getClass();
                iComputeUInt64SizeNoTag = 4;
                i = iComputeUInt64SizeNoTag + iComputeTagSize2;
                wireFormat$FieldType = metadata.valueType;
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(2);
                if (wireFormat$FieldType == anonymousClass2) {
                    iComputeTagSize *= 2;
                }
                switch (wireFormat$FieldType.ordinal()) {
                    case 0:
                        ((Double) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 1:
                        ((Float) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 2:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 3:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 4:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 5:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 6:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 7:
                        ((Boolean) obj2).getClass();
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 8:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                            iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        } else {
                            iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj2);
                        }
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 9:
                        iComputeUInt64SizeNoTag2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 10:
                        size2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 11:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        } else {
                            size2 = ((byte[]) obj2).length;
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        }
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 13:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 14:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 15:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 16:
                        int iIntValue2 = ((Integer) obj2).intValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue2 >> 31) ^ (iIntValue2 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 17:
                        long jLongValue2 = ((Long) obj2).longValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue2 >> 63) ^ (jLongValue2 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    default:
                        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                }
            case 2:
                iComputeUInt64SizeNoTag = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj).longValue());
                i = iComputeUInt64SizeNoTag + iComputeTagSize2;
                wireFormat$FieldType = metadata.valueType;
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(2);
                if (wireFormat$FieldType == anonymousClass2) {
                    iComputeTagSize *= 2;
                }
                switch (wireFormat$FieldType.ordinal()) {
                    case 0:
                        ((Double) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 1:
                        ((Float) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 2:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 3:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 4:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 5:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 6:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 7:
                        ((Boolean) obj2).getClass();
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 8:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                            iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        } else {
                            iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj2);
                        }
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 9:
                        iComputeUInt64SizeNoTag2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 10:
                        size2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 11:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        } else {
                            size2 = ((byte[]) obj2).length;
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        }
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 13:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 14:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 15:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 16:
                        int iIntValue3 = ((Integer) obj2).intValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue3 >> 31) ^ (iIntValue3 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 17:
                        long jLongValue3 = ((Long) obj2).longValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue3 >> 63) ^ (jLongValue3 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    default:
                        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                }
            case 3:
                iComputeUInt64SizeNoTag = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj).longValue());
                i = iComputeUInt64SizeNoTag + iComputeTagSize2;
                wireFormat$FieldType = metadata.valueType;
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(2);
                if (wireFormat$FieldType == anonymousClass2) {
                    iComputeTagSize *= 2;
                }
                switch (wireFormat$FieldType.ordinal()) {
                    case 0:
                        ((Double) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 1:
                        ((Float) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 2:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 3:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 4:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 5:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 6:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 7:
                        ((Boolean) obj2).getClass();
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 8:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                            iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        } else {
                            iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj2);
                        }
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 9:
                        iComputeUInt64SizeNoTag2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 10:
                        size2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 11:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        } else {
                            size2 = ((byte[]) obj2).length;
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        }
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 13:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 14:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 15:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 16:
                        int iIntValue4 = ((Integer) obj2).intValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue4 >> 31) ^ (iIntValue4 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 17:
                        long jLongValue4 = ((Long) obj2).longValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue4 >> 63) ^ (jLongValue4 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    default:
                        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                }
            case 4:
                iComputeUInt64SizeNoTag = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj).intValue());
                i = iComputeUInt64SizeNoTag + iComputeTagSize2;
                wireFormat$FieldType = metadata.valueType;
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(2);
                if (wireFormat$FieldType == anonymousClass2) {
                    iComputeTagSize *= 2;
                }
                switch (wireFormat$FieldType.ordinal()) {
                    case 0:
                        ((Double) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 1:
                        ((Float) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 2:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 3:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 4:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 5:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 6:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 7:
                        ((Boolean) obj2).getClass();
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 8:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                            iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        } else {
                            iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj2);
                        }
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 9:
                        iComputeUInt64SizeNoTag2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 10:
                        size2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 11:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        } else {
                            size2 = ((byte[]) obj2).length;
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        }
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 13:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 14:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 15:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 16:
                        int iIntValue5 = ((Integer) obj2).intValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue5 >> 31) ^ (iIntValue5 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 17:
                        long jLongValue5 = ((Long) obj2).longValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue5 >> 63) ^ (jLongValue5 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    default:
                        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                }
            case 5:
                ((Long) obj).getClass();
                iComputeUInt64SizeNoTag = 8;
                i = iComputeUInt64SizeNoTag + iComputeTagSize2;
                wireFormat$FieldType = metadata.valueType;
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(2);
                if (wireFormat$FieldType == anonymousClass2) {
                    iComputeTagSize *= 2;
                }
                switch (wireFormat$FieldType.ordinal()) {
                    case 0:
                        ((Double) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 1:
                        ((Float) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 2:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 3:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 4:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 5:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 6:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 7:
                        ((Boolean) obj2).getClass();
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 8:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                            iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        } else {
                            iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj2);
                        }
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 9:
                        iComputeUInt64SizeNoTag2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 10:
                        size2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 11:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        } else {
                            size2 = ((byte[]) obj2).length;
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        }
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 13:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 14:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 15:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 16:
                        int iIntValue6 = ((Integer) obj2).intValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue6 >> 31) ^ (iIntValue6 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 17:
                        long jLongValue6 = ((Long) obj2).longValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue6 >> 63) ^ (jLongValue6 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    default:
                        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                }
            case 6:
                ((Integer) obj).getClass();
                iComputeUInt64SizeNoTag = 4;
                i = iComputeUInt64SizeNoTag + iComputeTagSize2;
                wireFormat$FieldType = metadata.valueType;
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(2);
                if (wireFormat$FieldType == anonymousClass2) {
                    iComputeTagSize *= 2;
                }
                switch (wireFormat$FieldType.ordinal()) {
                    case 0:
                        ((Double) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 1:
                        ((Float) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 2:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 3:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 4:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 5:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 6:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 7:
                        ((Boolean) obj2).getClass();
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 8:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                            iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        } else {
                            iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj2);
                        }
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 9:
                        iComputeUInt64SizeNoTag2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 10:
                        size2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 11:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        } else {
                            size2 = ((byte[]) obj2).length;
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        }
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 13:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 14:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 15:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 16:
                        int iIntValue7 = ((Integer) obj2).intValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue7 >> 31) ^ (iIntValue7 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 17:
                        long jLongValue7 = ((Long) obj2).longValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue7 >> 63) ^ (jLongValue7 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    default:
                        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                }
            case 7:
                ((Boolean) obj).getClass();
                iComputeUInt64SizeNoTag = 1;
                i = iComputeUInt64SizeNoTag + iComputeTagSize2;
                wireFormat$FieldType = metadata.valueType;
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(2);
                if (wireFormat$FieldType == anonymousClass2) {
                    iComputeTagSize *= 2;
                }
                switch (wireFormat$FieldType.ordinal()) {
                    case 0:
                        ((Double) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 1:
                        ((Float) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 2:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 3:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 4:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 5:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 6:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 7:
                        ((Boolean) obj2).getClass();
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 8:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                            iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        } else {
                            iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj2);
                        }
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 9:
                        iComputeUInt64SizeNoTag2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 10:
                        size2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 11:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        } else {
                            size2 = ((byte[]) obj2).length;
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        }
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 13:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 14:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 15:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 16:
                        int iIntValue8 = ((Integer) obj2).intValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue8 >> 31) ^ (iIntValue8 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 17:
                        long jLongValue8 = ((Long) obj2).longValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue8 >> 63) ^ (jLongValue8 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    default:
                        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                }
            case 8:
                if (obj instanceof ByteString$LiteralByteString) {
                    size = ((ByteString$LiteralByteString) obj).size();
                    iComputeUInt32SizeNoTag = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size);
                    iComputeUInt64SizeNoTag = size + iComputeUInt32SizeNoTag;
                } else {
                    iComputeUInt64SizeNoTag = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj);
                }
                i = iComputeUInt64SizeNoTag + iComputeTagSize2;
                wireFormat$FieldType = metadata.valueType;
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(2);
                if (wireFormat$FieldType == anonymousClass2) {
                    iComputeTagSize *= 2;
                }
                switch (wireFormat$FieldType.ordinal()) {
                    case 0:
                        ((Double) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 1:
                        ((Float) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 2:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 3:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 4:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 5:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 6:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 7:
                        ((Boolean) obj2).getClass();
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 8:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                            iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        } else {
                            iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj2);
                        }
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 9:
                        iComputeUInt64SizeNoTag2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 10:
                        size2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 11:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        } else {
                            size2 = ((byte[]) obj2).length;
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        }
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 13:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 14:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 15:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 16:
                        int iIntValue9 = ((Integer) obj2).intValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue9 >> 31) ^ (iIntValue9 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 17:
                        long jLongValue9 = ((Long) obj2).longValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue9 >> 63) ^ (jLongValue9 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    default:
                        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                }
            case 9:
                iComputeUInt64SizeNoTag = ((GeneratedMessageLite) ((AbstractMessageLite) obj)).getSerializedSize(null);
                i = iComputeUInt64SizeNoTag + iComputeTagSize2;
                wireFormat$FieldType = metadata.valueType;
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(2);
                if (wireFormat$FieldType == anonymousClass2) {
                    iComputeTagSize *= 2;
                }
                switch (wireFormat$FieldType.ordinal()) {
                    case 0:
                        ((Double) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 1:
                        ((Float) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 2:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 3:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 4:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 5:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 6:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 7:
                        ((Boolean) obj2).getClass();
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 8:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                            iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        } else {
                            iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj2);
                        }
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 9:
                        iComputeUInt64SizeNoTag2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 10:
                        size2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 11:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        } else {
                            size2 = ((byte[]) obj2).length;
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        }
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 13:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 14:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 15:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 16:
                        int iIntValue10 = ((Integer) obj2).intValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue10 >> 31) ^ (iIntValue10 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 17:
                        long jLongValue10 = ((Long) obj2).longValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue10 >> 63) ^ (jLongValue10 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    default:
                        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                }
            case 10:
                size = ((GeneratedMessageLite) ((AbstractMessageLite) obj)).getSerializedSize(null);
                iComputeUInt32SizeNoTag = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size);
                iComputeUInt64SizeNoTag = size + iComputeUInt32SizeNoTag;
                i = iComputeUInt64SizeNoTag + iComputeTagSize2;
                wireFormat$FieldType = metadata.valueType;
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(2);
                if (wireFormat$FieldType == anonymousClass2) {
                    iComputeTagSize *= 2;
                }
                switch (wireFormat$FieldType.ordinal()) {
                    case 0:
                        ((Double) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 1:
                        ((Float) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 2:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 3:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 4:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 5:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 6:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 7:
                        ((Boolean) obj2).getClass();
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 8:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                            iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        } else {
                            iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj2);
                        }
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 9:
                        iComputeUInt64SizeNoTag2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 10:
                        size2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 11:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        } else {
                            size2 = ((byte[]) obj2).length;
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        }
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 13:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 14:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 15:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 16:
                        int iIntValue11 = ((Integer) obj2).intValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue11 >> 31) ^ (iIntValue11 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 17:
                        long jLongValue11 = ((Long) obj2).longValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue11 >> 63) ^ (jLongValue11 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    default:
                        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                }
            case 11:
                if (obj instanceof ByteString$LiteralByteString) {
                    size = ((ByteString$LiteralByteString) obj).size();
                    iComputeUInt32SizeNoTag = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size);
                } else {
                    size = ((byte[]) obj).length;
                    iComputeUInt32SizeNoTag = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size);
                }
                iComputeUInt64SizeNoTag = size + iComputeUInt32SizeNoTag;
                i = iComputeUInt64SizeNoTag + iComputeTagSize2;
                wireFormat$FieldType = metadata.valueType;
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(2);
                if (wireFormat$FieldType == anonymousClass2) {
                    iComputeTagSize *= 2;
                }
                switch (wireFormat$FieldType.ordinal()) {
                    case 0:
                        ((Double) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 1:
                        ((Float) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 2:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 3:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 4:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 5:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 6:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 7:
                        ((Boolean) obj2).getClass();
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 8:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                            iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        } else {
                            iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj2);
                        }
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 9:
                        iComputeUInt64SizeNoTag2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 10:
                        size2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 11:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        } else {
                            size2 = ((byte[]) obj2).length;
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        }
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 13:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 14:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 15:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 16:
                        int iIntValue12 = ((Integer) obj2).intValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue12 >> 31) ^ (iIntValue12 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 17:
                        long jLongValue12 = ((Long) obj2).longValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue12 >> 63) ^ (jLongValue12 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    default:
                        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                }
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                iComputeUInt64SizeNoTag = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj).intValue());
                i = iComputeUInt64SizeNoTag + iComputeTagSize2;
                wireFormat$FieldType = metadata.valueType;
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(2);
                if (wireFormat$FieldType == anonymousClass2) {
                    iComputeTagSize *= 2;
                }
                switch (wireFormat$FieldType.ordinal()) {
                    case 0:
                        ((Double) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 1:
                        ((Float) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 2:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 3:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 4:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 5:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 6:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 7:
                        ((Boolean) obj2).getClass();
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 8:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                            iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        } else {
                            iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj2);
                        }
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 9:
                        iComputeUInt64SizeNoTag2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 10:
                        size2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 11:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        } else {
                            size2 = ((byte[]) obj2).length;
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        }
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 13:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 14:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 15:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 16:
                        int iIntValue13 = ((Integer) obj2).intValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue13 >> 31) ^ (iIntValue13 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 17:
                        long jLongValue13 = ((Long) obj2).longValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue13 >> 63) ^ (jLongValue13 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    default:
                        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                }
            case 13:
                iComputeUInt64SizeNoTag = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj).intValue());
                i = iComputeUInt64SizeNoTag + iComputeTagSize2;
                wireFormat$FieldType = metadata.valueType;
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(2);
                if (wireFormat$FieldType == anonymousClass2) {
                    iComputeTagSize *= 2;
                }
                switch (wireFormat$FieldType.ordinal()) {
                    case 0:
                        ((Double) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 1:
                        ((Float) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 2:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 3:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 4:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 5:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 6:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 7:
                        ((Boolean) obj2).getClass();
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 8:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                            iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        } else {
                            iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj2);
                        }
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 9:
                        iComputeUInt64SizeNoTag2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 10:
                        size2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 11:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        } else {
                            size2 = ((byte[]) obj2).length;
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        }
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 13:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 14:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 15:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 16:
                        int iIntValue14 = ((Integer) obj2).intValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue14 >> 31) ^ (iIntValue14 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 17:
                        long jLongValue14 = ((Long) obj2).longValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue14 >> 63) ^ (jLongValue14 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    default:
                        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                }
            case 14:
                ((Integer) obj).getClass();
                iComputeUInt64SizeNoTag = 4;
                i = iComputeUInt64SizeNoTag + iComputeTagSize2;
                wireFormat$FieldType = metadata.valueType;
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(2);
                if (wireFormat$FieldType == anonymousClass2) {
                    iComputeTagSize *= 2;
                }
                switch (wireFormat$FieldType.ordinal()) {
                    case 0:
                        ((Double) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 1:
                        ((Float) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 2:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 3:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 4:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 5:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 6:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 7:
                        ((Boolean) obj2).getClass();
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 8:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                            iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        } else {
                            iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj2);
                        }
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 9:
                        iComputeUInt64SizeNoTag2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 10:
                        size2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 11:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        } else {
                            size2 = ((byte[]) obj2).length;
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        }
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 13:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 14:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 15:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 16:
                        int iIntValue15 = ((Integer) obj2).intValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue15 >> 31) ^ (iIntValue15 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 17:
                        long jLongValue15 = ((Long) obj2).longValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue15 >> 63) ^ (jLongValue15 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    default:
                        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                }
            case 15:
                ((Long) obj).getClass();
                iComputeUInt64SizeNoTag = 8;
                i = iComputeUInt64SizeNoTag + iComputeTagSize2;
                wireFormat$FieldType = metadata.valueType;
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(2);
                if (wireFormat$FieldType == anonymousClass2) {
                    iComputeTagSize *= 2;
                }
                switch (wireFormat$FieldType.ordinal()) {
                    case 0:
                        ((Double) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 1:
                        ((Float) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 2:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 3:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 4:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 5:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 6:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 7:
                        ((Boolean) obj2).getClass();
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 8:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                            iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        } else {
                            iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj2);
                        }
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 9:
                        iComputeUInt64SizeNoTag2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 10:
                        size2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 11:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        } else {
                            size2 = ((byte[]) obj2).length;
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        }
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 13:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 14:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 15:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 16:
                        int iIntValue16 = ((Integer) obj2).intValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue16 >> 31) ^ (iIntValue16 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 17:
                        long jLongValue16 = ((Long) obj2).longValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue16 >> 63) ^ (jLongValue16 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    default:
                        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                }
            case 16:
                int iIntValue17 = ((Integer) obj).intValue();
                iComputeUInt64SizeNoTag = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue17 >> 31) ^ (iIntValue17 << 1));
                i = iComputeUInt64SizeNoTag + iComputeTagSize2;
                wireFormat$FieldType = metadata.valueType;
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(2);
                if (wireFormat$FieldType == anonymousClass2) {
                    iComputeTagSize *= 2;
                }
                switch (wireFormat$FieldType.ordinal()) {
                    case 0:
                        ((Double) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 1:
                        ((Float) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 2:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 3:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 4:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 5:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 6:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 7:
                        ((Boolean) obj2).getClass();
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 8:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                            iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        } else {
                            iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj2);
                        }
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 9:
                        iComputeUInt64SizeNoTag2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 10:
                        size2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 11:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        } else {
                            size2 = ((byte[]) obj2).length;
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        }
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 13:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 14:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 15:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 16:
                        int iIntValue18 = ((Integer) obj2).intValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue18 >> 31) ^ (iIntValue18 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 17:
                        long jLongValue17 = ((Long) obj2).longValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue17 >> 63) ^ (jLongValue17 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    default:
                        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                }
            case 17:
                long jLongValue18 = ((Long) obj).longValue();
                iComputeUInt64SizeNoTag = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue18 >> 63) ^ (jLongValue18 << 1));
                i = iComputeUInt64SizeNoTag + iComputeTagSize2;
                wireFormat$FieldType = metadata.valueType;
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(2);
                if (wireFormat$FieldType == anonymousClass2) {
                    iComputeTagSize *= 2;
                }
                switch (wireFormat$FieldType.ordinal()) {
                    case 0:
                        ((Double) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 1:
                        ((Float) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 2:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 3:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Long) obj2).longValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 4:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 5:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 6:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 7:
                        ((Boolean) obj2).getClass();
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 8:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                            iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        } else {
                            iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeStringSizeNoTag((String) obj2);
                        }
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 9:
                        iComputeUInt64SizeNoTag2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 10:
                        size2 = ((GeneratedMessageLite) ((AbstractMessageLite) obj2)).getSerializedSize(null);
                        iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 11:
                        if (obj2 instanceof ByteString$LiteralByteString) {
                            size2 = ((ByteString$LiteralByteString) obj2).size();
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        } else {
                            size2 = ((byte[]) obj2).length;
                            iComputeUInt32SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(size2);
                        }
                        iComputeUInt64SizeNoTag2 = iComputeUInt32SizeNoTag2 + size2;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 13:
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(((Integer) obj2).intValue());
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 14:
                        ((Integer) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 4;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 15:
                        ((Long) obj2).getClass();
                        iComputeUInt64SizeNoTag2 = 8;
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 16:
                        int iIntValue19 = ((Integer) obj2).intValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt32SizeNoTag((iIntValue19 >> 31) ^ (iIntValue19 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    case 17:
                        long jLongValue19 = ((Long) obj2).longValue();
                        iComputeUInt64SizeNoTag2 = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag((jLongValue19 >> 63) ^ (jLongValue19 << 1));
                        return iComputeUInt64SizeNoTag2 + iComputeTagSize + i;
                    default:
                        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                }
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}
