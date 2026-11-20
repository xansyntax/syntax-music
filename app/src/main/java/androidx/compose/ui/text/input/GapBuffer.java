package androidx.compose.ui.text.input;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.runtime.composer.gapbuffer.changelist.Operations;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.datastore.preferences.protobuf.ByteString$LiteralByteString;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.Protobuf;
import androidx.datastore.preferences.protobuf.ProtobufArrayList;
import androidx.datastore.preferences.protobuf.WireFormat$FieldType;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.upstream.Allocation;
import coil3.memory.RealStrongMemoryCache$cache$1;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.protobuf.BooleanArrayList;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DoubleArrayList;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatArrayList;
import com.google.protobuf.IntArrayList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LongArrayList;
import com.google.protobuf.Schema;
import com.metrolist.music.db.DatabaseDao_Impl;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.CharArrayPoolBase;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GapBuffer {
    public final /* synthetic */ byte $r8$classId;
    public Object buffer;
    public int capacity;
    public int gapEnd;
    public int gapStart;

    public GapBuffer(byte b) {
        this.$r8$classId = b;
        switch (b) {
            case 5:
                this.gapEnd = 7;
                this.buffer = new int[8];
                break;
            case 6:
                this.gapEnd = 0;
                this.buffer = new Allocation[100];
                break;
        }
    }

    public static void verifyPackedFixed32Length(int i) throws InvalidProtocolBufferException {
        if ((i & 3) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    public static void verifyPackedFixed64Length(int i) throws InvalidProtocolBufferException {
        if ((i & 7) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    public void addLast(int i) {
        int[] iArr = (int[]) this.buffer;
        int i2 = this.gapStart;
        iArr[i2] = i;
        int i3 = this.gapEnd & (i2 + 1);
        this.gapStart = i3;
        int i4 = this.capacity;
        if (i3 == i4) {
            int length = iArr.length;
            int i5 = length - i4;
            int i6 = length << 1;
            int[] iArr2 = new int[i6];
            System.arraycopy(iArr, i4, iArr2, 0, i5);
            System.arraycopy((int[]) this.buffer, 0, iArr2, i5, this.capacity);
            this.buffer = iArr2;
            this.capacity = 0;
            this.gapStart = length;
            this.gapEnd = i6 - 1;
        }
    }

    public synchronized Allocation allocate() {
        Allocation allocation;
        try {
            int i = this.gapStart + 1;
            this.gapStart = i;
            int i2 = this.gapEnd;
            if (i2 > 0) {
                Allocation[] allocationArr = (Allocation[]) this.buffer;
                int i3 = i2 - 1;
                this.gapEnd = i3;
                allocation = allocationArr[i3];
                allocation.getClass();
                ((Allocation[]) this.buffer)[this.gapEnd] = null;
            } else {
                Allocation allocation2 = new Allocation(new byte[65536], 0);
                Allocation[] allocationArr2 = (Allocation[]) this.buffer;
                if (i > allocationArr2.length) {
                    this.buffer = (Allocation[]) Arrays.copyOf(allocationArr2, allocationArr2.length * 2);
                }
                allocation = allocation2;
            }
        } catch (Throwable th) {
            throw th;
        }
        return allocation;
    }

    public Selection.AnchorInfo anchorForOffset(int i) {
        return new Selection.AnchorInfo(DatabaseDao_Impl.AnonymousClass17.getTextDirectionForOffset((TextLayoutResult) this.buffer, i), i, 1L);
    }

    public DeviceInfo build() {
        UtilsKt.checkArgument(this.gapStart <= this.gapEnd);
        return new DeviceInfo(this);
    }

    public int gapLength() {
        return this.gapEnd - this.gapStart;
    }

    public int getFieldNumber() {
        switch (this.$r8$classId) {
            case 3:
                int tag = this.gapEnd;
                if (tag != 0) {
                    this.capacity = tag;
                    this.gapEnd = 0;
                } else {
                    tag = ((CharArrayPoolBase) this.buffer).readTag();
                    this.capacity = tag;
                }
                if (tag == 0 || tag == this.gapStart) {
                    return Integer.MAX_VALUE;
                }
                return tag >>> 3;
            default:
                int tag2 = this.gapEnd;
                if (tag2 != 0) {
                    this.capacity = tag2;
                    this.gapEnd = 0;
                } else {
                    tag2 = ((CodedInputStream) this.buffer).readTag();
                    this.capacity = tag2;
                }
                if (tag2 == 0 || tag2 == this.gapStart) {
                    return Integer.MAX_VALUE;
                }
                return tag2 >>> 3;
        }
    }

    public int getInt(int i) {
        return ((Operations) this.buffer).intArgs[this.gapStart + i];
    }

    /* JADX INFO: renamed from: getObject-PtL-UHM, reason: not valid java name */
    public Object m758getObjectPtLUHM(int i) {
        return ((Operations) this.buffer).objectArgs[this.gapEnd + i];
    }

    public void mergeGroupFieldInternal(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream codedInputStream = (CodedInputStream) this.buffer;
        codedInputStream.checkRecursionLimit();
        int i = this.gapStart;
        this.gapStart = ((this.capacity >>> 3) << 3) | 4;
        codedInputStream.groupDepth++;
        try {
            schema.mergeFrom(obj, this, extensionRegistryLite);
            if (this.capacity != this.gapStart) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            codedInputStream.groupDepth--;
            this.gapStart = i;
        } catch (Throwable th) {
            codedInputStream.groupDepth--;
            this.gapStart = i;
            throw th;
        }
    }

    public void mergeMessageFieldInternal(Object obj, androidx.datastore.preferences.protobuf.Schema schema, androidx.datastore.preferences.protobuf.ExtensionRegistryLite extensionRegistryLite) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        int uInt32 = charArrayPoolBase.readUInt32();
        if (charArrayPoolBase.charsTotal >= 100) {
            throw new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iPushLimit = charArrayPoolBase.pushLimit(uInt32);
        charArrayPoolBase.charsTotal++;
        schema.mergeFrom(obj, this, extensionRegistryLite);
        charArrayPoolBase.checkLastTagWas(0);
        charArrayPoolBase.charsTotal--;
        charArrayPoolBase.popLimit(iPushLimit);
    }

    public void readBoolList(List list) throws InvalidProtocolBufferException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        int tag2;
        CodedInputStream codedInputStream = (CodedInputStream) this.buffer;
        boolean z = list instanceof BooleanArrayList;
        int i = this.capacity;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(codedInputStream.readBool()));
                    if (codedInputStream.isAtEnd()) {
                        return;
                    } else {
                        tag = codedInputStream.readTag();
                    }
                } while (tag == this.capacity);
                this.gapEnd = tag;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
            do {
                list.add(Boolean.valueOf(codedInputStream.readBool()));
            } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) list;
        int i3 = i & 7;
        if (i3 == 0) {
            do {
                booleanArrayList.addBoolean(codedInputStream.readBool());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    tag2 = codedInputStream.readTag();
                }
            } while (tag2 == this.capacity);
            this.gapEnd = tag2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int totalBytesRead2 = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
        do {
            booleanArrayList.addBoolean(codedInputStream.readBool());
        } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
        requirePosition(totalBytesRead2);
    }

    /* JADX INFO: renamed from: readBytes, reason: collision with other method in class */
    public ByteString m759readBytes() throws InvalidProtocolBufferException.InvalidWireTypeException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(2);
        return ((CodedInputStream) this.buffer).readBytes();
    }

    public void readBytesList(Internal.ProtobufList protobufList) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException {
        int tag;
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        if ((this.capacity & 7) != 2) {
            throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidWireType();
        }
        do {
            ((ProtobufArrayList) protobufList).add(readBytes());
            if (charArrayPoolBase.isAtEnd()) {
                return;
            } else {
                tag = charArrayPoolBase.readTag();
            }
        } while (tag == this.capacity);
        this.gapEnd = tag;
    }

    public void readDoubleList(List list) throws InvalidProtocolBufferException {
        int tag;
        int tag2;
        CodedInputStream codedInputStream = (CodedInputStream) this.buffer;
        boolean z = list instanceof DoubleArrayList;
        int i = this.capacity;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(codedInputStream.readDouble()));
                    if (codedInputStream.isAtEnd()) {
                        return;
                    } else {
                        tag = codedInputStream.readTag();
                    }
                } while (tag == this.capacity);
                this.gapEnd = tag;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int uInt32 = codedInputStream.readUInt32();
            verifyPackedFixed64Length(uInt32);
            int totalBytesRead = codedInputStream.getTotalBytesRead() + uInt32;
            do {
                list.add(Double.valueOf(codedInputStream.readDouble()));
            } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
            return;
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) list;
        int i3 = i & 7;
        if (i3 == 1) {
            do {
                doubleArrayList.addDouble(codedInputStream.readDouble());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    tag2 = codedInputStream.readTag();
                }
            } while (tag2 == this.capacity);
            this.gapEnd = tag2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int uInt33 = codedInputStream.readUInt32();
        verifyPackedFixed64Length(uInt33);
        int totalBytesRead2 = codedInputStream.getTotalBytesRead() + uInt33;
        do {
            doubleArrayList.addDouble(codedInputStream.readDouble());
        } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
    }

    public void readEnumList(List list) throws InvalidProtocolBufferException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        int tag2;
        CodedInputStream codedInputStream = (CodedInputStream) this.buffer;
        boolean z = list instanceof IntArrayList;
        int i = this.capacity;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(codedInputStream.readEnum()));
                    if (codedInputStream.isAtEnd()) {
                        return;
                    } else {
                        tag = codedInputStream.readTag();
                    }
                } while (tag == this.capacity);
                this.gapEnd = tag;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
            do {
                list.add(Integer.valueOf(codedInputStream.readEnum()));
            } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int i3 = i & 7;
        if (i3 == 0) {
            do {
                intArrayList.addInt(codedInputStream.readEnum());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    tag2 = codedInputStream.readTag();
                }
            } while (tag2 == this.capacity);
            this.gapEnd = tag2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int totalBytesRead2 = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
        do {
            intArrayList.addInt(codedInputStream.readEnum());
        } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
        requirePosition(totalBytesRead2);
    }

    public Object readField(WireFormat$FieldType wireFormat$FieldType, Class cls, androidx.datastore.preferences.protobuf.ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        switch (wireFormat$FieldType.ordinal()) {
            case 0:
                requireWireType(1);
                return Double.valueOf(charArrayPoolBase.readDouble());
            case 1:
                requireWireType(5);
                return Float.valueOf(charArrayPoolBase.readFloat());
            case 2:
                requireWireType(0);
                return Long.valueOf(charArrayPoolBase.readInt64());
            case 3:
                requireWireType(0);
                return Long.valueOf(charArrayPoolBase.readUInt64());
            case 4:
                requireWireType(0);
                return Integer.valueOf(charArrayPoolBase.readInt32());
            case 5:
                requireWireType(1);
                return Long.valueOf(charArrayPoolBase.readFixed64());
            case 6:
                requireWireType(5);
                return Integer.valueOf(charArrayPoolBase.readFixed32());
            case 7:
                requireWireType(0);
                return Boolean.valueOf(charArrayPoolBase.readBool());
            case 8:
                requireWireType(2);
                return charArrayPoolBase.readStringRequireUtf8();
            case 9:
            default:
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("unsupported field type.");
                return null;
            case 10:
                requireWireType(2);
                androidx.datastore.preferences.protobuf.Schema schemaSchemaFor = Protobuf.INSTANCE.schemaFor(cls);
                GeneratedMessageLite generatedMessageLiteNewInstance = schemaSchemaFor.newInstance();
                mergeMessageFieldInternal(generatedMessageLiteNewInstance, schemaSchemaFor, extensionRegistryLite);
                schemaSchemaFor.makeImmutable(generatedMessageLiteNewInstance);
                return generatedMessageLiteNewInstance;
            case 11:
                return readBytes();
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                requireWireType(0);
                return Integer.valueOf(charArrayPoolBase.readUInt32());
            case 13:
                requireWireType(0);
                return Integer.valueOf(charArrayPoolBase.readEnum());
            case 14:
                requireWireType(5);
                return Integer.valueOf(charArrayPoolBase.readSFixed32());
            case 15:
                requireWireType(1);
                return Long.valueOf(charArrayPoolBase.readSFixed64());
            case 16:
                requireWireType(0);
                return Integer.valueOf(charArrayPoolBase.readSInt32());
            case 17:
                requireWireType(0);
                return Long.valueOf(charArrayPoolBase.readSInt64());
        }
    }

    public void readFixed32List(List list) throws InvalidProtocolBufferException {
        int tag;
        int tag2;
        CodedInputStream codedInputStream = (CodedInputStream) this.buffer;
        boolean z = list instanceof IntArrayList;
        int i = this.capacity;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 2) {
                int uInt32 = codedInputStream.readUInt32();
                verifyPackedFixed32Length(uInt32);
                int totalBytesRead = codedInputStream.getTotalBytesRead() + uInt32;
                do {
                    list.add(Integer.valueOf(codedInputStream.readFixed32()));
                } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
                return;
            }
            if (i2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(codedInputStream.readFixed32()));
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    tag = codedInputStream.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int i3 = i & 7;
        if (i3 == 2) {
            int uInt33 = codedInputStream.readUInt32();
            verifyPackedFixed32Length(uInt33);
            int totalBytesRead2 = codedInputStream.getTotalBytesRead() + uInt33;
            do {
                intArrayList.addInt(codedInputStream.readFixed32());
            } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        if (i3 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            intArrayList.addInt(codedInputStream.readFixed32());
            if (codedInputStream.isAtEnd()) {
                return;
            } else {
                tag2 = codedInputStream.readTag();
            }
        } while (tag2 == this.capacity);
        this.gapEnd = tag2;
    }

    public void readFixed64List(List list) throws InvalidProtocolBufferException {
        int tag;
        int tag2;
        CodedInputStream codedInputStream = (CodedInputStream) this.buffer;
        boolean z = list instanceof LongArrayList;
        int i = this.capacity;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(codedInputStream.readFixed64()));
                    if (codedInputStream.isAtEnd()) {
                        return;
                    } else {
                        tag = codedInputStream.readTag();
                    }
                } while (tag == this.capacity);
                this.gapEnd = tag;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int uInt32 = codedInputStream.readUInt32();
            verifyPackedFixed64Length(uInt32);
            int totalBytesRead = codedInputStream.getTotalBytesRead() + uInt32;
            do {
                list.add(Long.valueOf(codedInputStream.readFixed64()));
            } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int i3 = i & 7;
        if (i3 == 1) {
            do {
                longArrayList.addLong(codedInputStream.readFixed64());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    tag2 = codedInputStream.readTag();
                }
            } while (tag2 == this.capacity);
            this.gapEnd = tag2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int uInt33 = codedInputStream.readUInt32();
        verifyPackedFixed64Length(uInt33);
        int totalBytesRead2 = codedInputStream.getTotalBytesRead() + uInt33;
        do {
            longArrayList.addLong(codedInputStream.readFixed64());
        } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
    }

    public void readFloatList(List list) throws InvalidProtocolBufferException {
        int tag;
        int tag2;
        CodedInputStream codedInputStream = (CodedInputStream) this.buffer;
        boolean z = list instanceof FloatArrayList;
        int i = this.capacity;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 2) {
                int uInt32 = codedInputStream.readUInt32();
                verifyPackedFixed32Length(uInt32);
                int totalBytesRead = codedInputStream.getTotalBytesRead() + uInt32;
                do {
                    list.add(Float.valueOf(codedInputStream.readFloat()));
                } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
                return;
            }
            if (i2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Float.valueOf(codedInputStream.readFloat()));
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    tag = codedInputStream.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        FloatArrayList floatArrayList = (FloatArrayList) list;
        int i3 = i & 7;
        if (i3 == 2) {
            int uInt33 = codedInputStream.readUInt32();
            verifyPackedFixed32Length(uInt33);
            int totalBytesRead2 = codedInputStream.getTotalBytesRead() + uInt33;
            do {
                floatArrayList.addFloat(codedInputStream.readFloat());
            } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        if (i3 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            floatArrayList.addFloat(codedInputStream.readFloat());
            if (codedInputStream.isAtEnd()) {
                return;
            } else {
                tag2 = codedInputStream.readTag();
            }
        } while (tag2 == this.capacity);
        this.gapEnd = tag2;
    }

    public void readInt32List(List list) throws InvalidProtocolBufferException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        int tag2;
        CodedInputStream codedInputStream = (CodedInputStream) this.buffer;
        boolean z = list instanceof IntArrayList;
        int i = this.capacity;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(codedInputStream.readInt32()));
                    if (codedInputStream.isAtEnd()) {
                        return;
                    } else {
                        tag = codedInputStream.readTag();
                    }
                } while (tag == this.capacity);
                this.gapEnd = tag;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
            do {
                list.add(Integer.valueOf(codedInputStream.readInt32()));
            } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int i3 = i & 7;
        if (i3 == 0) {
            do {
                intArrayList.addInt(codedInputStream.readInt32());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    tag2 = codedInputStream.readTag();
                }
            } while (tag2 == this.capacity);
            this.gapEnd = tag2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int totalBytesRead2 = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
        do {
            intArrayList.addInt(codedInputStream.readInt32());
        } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
        requirePosition(totalBytesRead2);
    }

    public void readInt64List(List list) throws InvalidProtocolBufferException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        int tag2;
        CodedInputStream codedInputStream = (CodedInputStream) this.buffer;
        boolean z = list instanceof LongArrayList;
        int i = this.capacity;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(codedInputStream.readInt64()));
                    if (codedInputStream.isAtEnd()) {
                        return;
                    } else {
                        tag = codedInputStream.readTag();
                    }
                } while (tag == this.capacity);
                this.gapEnd = tag;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
            do {
                list.add(Long.valueOf(codedInputStream.readInt64()));
            } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int i3 = i & 7;
        if (i3 == 0) {
            do {
                longArrayList.addLong(codedInputStream.readInt64());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    tag2 = codedInputStream.readTag();
                }
            } while (tag2 == this.capacity);
            this.gapEnd = tag2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int totalBytesRead2 = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
        do {
            longArrayList.addLong(codedInputStream.readInt64());
        } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
        requirePosition(totalBytesRead2);
    }

    public void readSFixed32List(List list) throws InvalidProtocolBufferException {
        int tag;
        int tag2;
        CodedInputStream codedInputStream = (CodedInputStream) this.buffer;
        boolean z = list instanceof IntArrayList;
        int i = this.capacity;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 2) {
                int uInt32 = codedInputStream.readUInt32();
                verifyPackedFixed32Length(uInt32);
                int totalBytesRead = codedInputStream.getTotalBytesRead() + uInt32;
                do {
                    list.add(Integer.valueOf(codedInputStream.readSFixed32()));
                } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
                return;
            }
            if (i2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(codedInputStream.readSFixed32()));
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    tag = codedInputStream.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int i3 = i & 7;
        if (i3 == 2) {
            int uInt33 = codedInputStream.readUInt32();
            verifyPackedFixed32Length(uInt33);
            int totalBytesRead2 = codedInputStream.getTotalBytesRead() + uInt33;
            do {
                intArrayList.addInt(codedInputStream.readSFixed32());
            } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        if (i3 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            intArrayList.addInt(codedInputStream.readSFixed32());
            if (codedInputStream.isAtEnd()) {
                return;
            } else {
                tag2 = codedInputStream.readTag();
            }
        } while (tag2 == this.capacity);
        this.gapEnd = tag2;
    }

    public void readSFixed64List(List list) throws InvalidProtocolBufferException {
        int tag;
        int tag2;
        CodedInputStream codedInputStream = (CodedInputStream) this.buffer;
        boolean z = list instanceof LongArrayList;
        int i = this.capacity;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(codedInputStream.readSFixed64()));
                    if (codedInputStream.isAtEnd()) {
                        return;
                    } else {
                        tag = codedInputStream.readTag();
                    }
                } while (tag == this.capacity);
                this.gapEnd = tag;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int uInt32 = codedInputStream.readUInt32();
            verifyPackedFixed64Length(uInt32);
            int totalBytesRead = codedInputStream.getTotalBytesRead() + uInt32;
            do {
                list.add(Long.valueOf(codedInputStream.readSFixed64()));
            } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int i3 = i & 7;
        if (i3 == 1) {
            do {
                longArrayList.addLong(codedInputStream.readSFixed64());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    tag2 = codedInputStream.readTag();
                }
            } while (tag2 == this.capacity);
            this.gapEnd = tag2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int uInt33 = codedInputStream.readUInt32();
        verifyPackedFixed64Length(uInt33);
        int totalBytesRead2 = codedInputStream.getTotalBytesRead() + uInt33;
        do {
            longArrayList.addLong(codedInputStream.readSFixed64());
        } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
    }

    public void readSInt32List(List list) throws InvalidProtocolBufferException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        int tag2;
        CodedInputStream codedInputStream = (CodedInputStream) this.buffer;
        boolean z = list instanceof IntArrayList;
        int i = this.capacity;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(codedInputStream.readSInt32()));
                    if (codedInputStream.isAtEnd()) {
                        return;
                    } else {
                        tag = codedInputStream.readTag();
                    }
                } while (tag == this.capacity);
                this.gapEnd = tag;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
            do {
                list.add(Integer.valueOf(codedInputStream.readSInt32()));
            } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int i3 = i & 7;
        if (i3 == 0) {
            do {
                intArrayList.addInt(codedInputStream.readSInt32());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    tag2 = codedInputStream.readTag();
                }
            } while (tag2 == this.capacity);
            this.gapEnd = tag2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int totalBytesRead2 = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
        do {
            intArrayList.addInt(codedInputStream.readSInt32());
        } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
        requirePosition(totalBytesRead2);
    }

    public void readSInt64List(List list) throws InvalidProtocolBufferException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        int tag2;
        CodedInputStream codedInputStream = (CodedInputStream) this.buffer;
        boolean z = list instanceof LongArrayList;
        int i = this.capacity;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(codedInputStream.readSInt64()));
                    if (codedInputStream.isAtEnd()) {
                        return;
                    } else {
                        tag = codedInputStream.readTag();
                    }
                } while (tag == this.capacity);
                this.gapEnd = tag;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
            do {
                list.add(Long.valueOf(codedInputStream.readSInt64()));
            } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int i3 = i & 7;
        if (i3 == 0) {
            do {
                longArrayList.addLong(codedInputStream.readSInt64());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    tag2 = codedInputStream.readTag();
                }
            } while (tag2 == this.capacity);
            this.gapEnd = tag2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int totalBytesRead2 = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
        do {
            longArrayList.addLong(codedInputStream.readSInt64());
        } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
        requirePosition(totalBytesRead2);
    }

    public void readStringListInternal(Internal.ProtobufList protobufList, boolean z) throws InvalidProtocolBufferException.InvalidWireTypeException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException {
        String string;
        int tag;
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        if ((this.capacity & 7) != 2) {
            throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidWireType();
        }
        do {
            if (z) {
                requireWireType(2);
                string = charArrayPoolBase.readStringRequireUtf8();
            } else {
                requireWireType(2);
                string = charArrayPoolBase.readString();
            }
            ((ProtobufArrayList) protobufList).add(string);
            if (charArrayPoolBase.isAtEnd()) {
                return;
            } else {
                tag = charArrayPoolBase.readTag();
            }
        } while (tag == this.capacity);
        this.gapEnd = tag;
    }

    public void readUInt32List(List list) throws InvalidProtocolBufferException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        int tag2;
        CodedInputStream codedInputStream = (CodedInputStream) this.buffer;
        boolean z = list instanceof IntArrayList;
        int i = this.capacity;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(codedInputStream.readUInt32()));
                    if (codedInputStream.isAtEnd()) {
                        return;
                    } else {
                        tag = codedInputStream.readTag();
                    }
                } while (tag == this.capacity);
                this.gapEnd = tag;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
            do {
                list.add(Integer.valueOf(codedInputStream.readUInt32()));
            } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int i3 = i & 7;
        if (i3 == 0) {
            do {
                intArrayList.addInt(codedInputStream.readUInt32());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    tag2 = codedInputStream.readTag();
                }
            } while (tag2 == this.capacity);
            this.gapEnd = tag2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int totalBytesRead2 = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
        do {
            intArrayList.addInt(codedInputStream.readUInt32());
        } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
        requirePosition(totalBytesRead2);
    }

    public void readUInt64List(List list) throws InvalidProtocolBufferException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        int tag2;
        CodedInputStream codedInputStream = (CodedInputStream) this.buffer;
        boolean z = list instanceof LongArrayList;
        int i = this.capacity;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(codedInputStream.readUInt64()));
                    if (codedInputStream.isAtEnd()) {
                        return;
                    } else {
                        tag = codedInputStream.readTag();
                    }
                } while (tag == this.capacity);
                this.gapEnd = tag;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
            do {
                list.add(Long.valueOf(codedInputStream.readUInt64()));
            } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int i3 = i & 7;
        if (i3 == 0) {
            do {
                longArrayList.addLong(codedInputStream.readUInt64());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    tag2 = codedInputStream.readTag();
                }
            } while (tag2 == this.capacity);
            this.gapEnd = tag2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int totalBytesRead2 = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
        do {
            longArrayList.addLong(codedInputStream.readUInt64());
        } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
        requirePosition(totalBytesRead2);
    }

    public synchronized void release(RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1) {
        while (realStrongMemoryCache$cache$1 != null) {
            Allocation[] allocationArr = (Allocation[]) this.buffer;
            int i = this.gapEnd;
            this.gapEnd = i + 1;
            Allocation allocation = (Allocation) realStrongMemoryCache$cache$1.map;
            allocation.getClass();
            allocationArr[i] = allocation;
            this.gapStart--;
            realStrongMemoryCache$cache$1 = (RealStrongMemoryCache$cache$1) realStrongMemoryCache$cache$1.this$0;
            if (realStrongMemoryCache$cache$1 == null || ((Allocation) realStrongMemoryCache$cache$1.map) == null) {
                realStrongMemoryCache$cache$1 = null;
            }
        }
    }

    public void requirePosition(int i) throws InvalidProtocolBufferException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        switch (this.$r8$classId) {
            case 3:
                if (((CharArrayPoolBase) this.buffer).getTotalBytesRead() != i) {
                    throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage();
                }
                return;
            default:
                if (((CodedInputStream) this.buffer).getTotalBytesRead() != i) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                return;
        }
    }

    public void requireWireType(int i) throws InvalidProtocolBufferException.InvalidWireTypeException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException {
        switch (this.$r8$classId) {
            case 3:
                if ((this.capacity & 7) != i) {
                    throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidWireType();
                }
                return;
            default:
                if ((this.capacity & 7) != i) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                return;
        }
    }

    public synchronized void setTargetBufferSize(int i) {
        boolean z = i < this.capacity;
        this.capacity = i;
        if (z) {
            trim();
        }
    }

    public boolean skipField() {
        int i;
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        if (charArrayPoolBase.isAtEnd() || (i = this.capacity) == this.gapStart) {
            return false;
        }
        return charArrayPoolBase.skipField(i);
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                return "";
            case 1:
                int i = this.capacity;
                TextLayoutResult textLayoutResult = (TextLayoutResult) this.buffer;
                ResolvedTextDirection textDirectionForOffset = DatabaseDao_Impl.AnonymousClass17.getTextDirectionForOffset(textLayoutResult, i);
                int i2 = this.gapStart;
                ResolvedTextDirection textDirectionForOffset2 = DatabaseDao_Impl.AnonymousClass17.getTextDirectionForOffset(textLayoutResult, i2);
                int i3 = this.gapEnd;
                StringBuilder sb = new StringBuilder("SelectionInfo(id=1, range=(");
                sb.append(i);
                sb.append("-");
                sb.append(textDirectionForOffset);
                sb.append(",");
                sb.append(i2);
                sb.append("-");
                sb.append(textDirectionForOffset2);
                sb.append("), prevOffset=");
                return Fragment$5$$ExternalSyntheticOutline0.m(sb, i3, ")");
            default:
                return super.toString();
        }
    }

    public synchronized void trim() {
        int iMax = Math.max(0, Util.ceilDivide(this.capacity, 65536) - this.gapStart);
        int i = this.gapEnd;
        if (iMax >= i) {
            return;
        }
        Arrays.fill((Allocation[]) this.buffer, iMax, i, (Object) null);
        this.gapEnd = iMax;
    }

    public ByteString$LiteralByteString readBytes() throws InvalidProtocolBufferException.InvalidWireTypeException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(2);
        return ((CharArrayPoolBase) this.buffer).readBytes();
    }

    public GapBuffer(CodedInputStream codedInputStream) {
        this.$r8$classId = (byte) 7;
        this.gapEnd = 0;
        byte[] bArr = com.google.protobuf.Internal.EMPTY_BYTE_ARRAY;
        if (codedInputStream != null) {
            this.buffer = codedInputStream;
            codedInputStream.wrapper = this;
        } else {
            PathKt$$ExternalSyntheticBUOutline0.m("input");
            throw null;
        }
    }

    public GapBuffer(CharArrayPoolBase charArrayPoolBase) {
        this.$r8$classId = (byte) 3;
        this.gapEnd = 0;
        Charset charset = Internal.UTF_8;
        this.buffer = charArrayPoolBase;
        charArrayPoolBase.arrays = this;
    }

    public void readBytesList(com.google.protobuf.Internal.ProtobufList protobufList) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int tag;
        CodedInputStream codedInputStream = (CodedInputStream) this.buffer;
        if ((this.capacity & 7) == 2) {
            do {
                protobufList.add(m759readBytes());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    tag = codedInputStream.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public GapBuffer(int i) {
        this.$r8$classId = (byte) 4;
        this.capacity = i;
    }

    public GapBuffer(Operations operations) {
        this.$r8$classId = (byte) 2;
        this.buffer = operations;
    }

    public GapBuffer(int i, int i2, int i3, TextLayoutResult textLayoutResult) {
        this.$r8$classId = (byte) 1;
        this.capacity = i;
        this.gapStart = i2;
        this.gapEnd = i3;
        this.buffer = textLayoutResult;
    }

    public void mergeMessageFieldInternal(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream codedInputStream = (CodedInputStream) this.buffer;
        int uInt32 = codedInputStream.readUInt32();
        codedInputStream.checkRecursionLimit();
        int iPushLimit = codedInputStream.pushLimit(uInt32);
        codedInputStream.messageDepth++;
        schema.mergeFrom(obj, this, extensionRegistryLite);
        codedInputStream.checkLastTagWas(0);
        codedInputStream.messageDepth--;
        codedInputStream.popLimit(iPushLimit);
    }

    public void readStringListInternal(com.google.protobuf.Internal.ProtobufList protobufList, boolean z) throws InvalidProtocolBufferException.InvalidWireTypeException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException {
        String string;
        int tag;
        CodedInputStream codedInputStream = (CodedInputStream) this.buffer;
        if ((this.capacity & 7) == 2) {
            do {
                if (z) {
                    requireWireType(2);
                    string = codedInputStream.readStringRequireUtf8();
                } else {
                    requireWireType(2);
                    string = codedInputStream.readString();
                }
                protobufList.add(string);
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    tag = codedInputStream.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public void mergeGroupFieldInternal(Object obj, androidx.datastore.preferences.protobuf.Schema schema, androidx.datastore.preferences.protobuf.ExtensionRegistryLite extensionRegistryLite) {
        int i = this.gapStart;
        this.gapStart = ((this.capacity >>> 3) << 3) | 4;
        try {
            schema.mergeFrom(obj, this, extensionRegistryLite);
            if (this.capacity == this.gapStart) {
                this.gapStart = i;
                return;
            }
            throw new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException("Failed to parse the message.");
        } catch (Throwable th) {
            this.gapStart = i;
            throw th;
        }
    }

    public void readBoolList(Internal.ProtobufList protobufList) throws InvalidProtocolBufferException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        int i = this.capacity & 7;
        if (i == 0) {
            do {
                ((ProtobufArrayList) protobufList).add(Boolean.valueOf(charArrayPoolBase.readBool()));
                if (charArrayPoolBase.isAtEnd()) {
                    return;
                } else {
                    tag = charArrayPoolBase.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        if (i == 2) {
            int totalBytesRead = charArrayPoolBase.getTotalBytesRead() + charArrayPoolBase.readUInt32();
            do {
                ((ProtobufArrayList) protobufList).add(Boolean.valueOf(charArrayPoolBase.readBool()));
            } while (charArrayPoolBase.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidWireType();
    }

    public void readEnumList(Internal.ProtobufList protobufList) throws InvalidProtocolBufferException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        int i = this.capacity & 7;
        if (i == 0) {
            do {
                ((ProtobufArrayList) protobufList).add(Integer.valueOf(charArrayPoolBase.readEnum()));
                if (charArrayPoolBase.isAtEnd()) {
                    return;
                } else {
                    tag = charArrayPoolBase.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        if (i == 2) {
            int totalBytesRead = charArrayPoolBase.getTotalBytesRead() + charArrayPoolBase.readUInt32();
            do {
                ((ProtobufArrayList) protobufList).add(Integer.valueOf(charArrayPoolBase.readEnum()));
            } while (charArrayPoolBase.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidWireType();
    }

    public void readInt32List(Internal.ProtobufList protobufList) throws InvalidProtocolBufferException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        int i = this.capacity & 7;
        if (i == 0) {
            do {
                ((ProtobufArrayList) protobufList).add(Integer.valueOf(charArrayPoolBase.readInt32()));
                if (charArrayPoolBase.isAtEnd()) {
                    return;
                } else {
                    tag = charArrayPoolBase.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        if (i == 2) {
            int totalBytesRead = charArrayPoolBase.getTotalBytesRead() + charArrayPoolBase.readUInt32();
            do {
                ((ProtobufArrayList) protobufList).add(Integer.valueOf(charArrayPoolBase.readInt32()));
            } while (charArrayPoolBase.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidWireType();
    }

    public void readInt64List(Internal.ProtobufList protobufList) throws InvalidProtocolBufferException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        int i = this.capacity & 7;
        if (i == 0) {
            do {
                ((ProtobufArrayList) protobufList).add(Long.valueOf(charArrayPoolBase.readInt64()));
                if (charArrayPoolBase.isAtEnd()) {
                    return;
                } else {
                    tag = charArrayPoolBase.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        if (i == 2) {
            int totalBytesRead = charArrayPoolBase.getTotalBytesRead() + charArrayPoolBase.readUInt32();
            do {
                ((ProtobufArrayList) protobufList).add(Long.valueOf(charArrayPoolBase.readInt64()));
            } while (charArrayPoolBase.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidWireType();
    }

    public void readSInt32List(Internal.ProtobufList protobufList) throws InvalidProtocolBufferException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        int i = this.capacity & 7;
        if (i == 0) {
            do {
                ((ProtobufArrayList) protobufList).add(Integer.valueOf(charArrayPoolBase.readSInt32()));
                if (charArrayPoolBase.isAtEnd()) {
                    return;
                } else {
                    tag = charArrayPoolBase.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        if (i == 2) {
            int totalBytesRead = charArrayPoolBase.getTotalBytesRead() + charArrayPoolBase.readUInt32();
            do {
                ((ProtobufArrayList) protobufList).add(Integer.valueOf(charArrayPoolBase.readSInt32()));
            } while (charArrayPoolBase.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidWireType();
    }

    public void readSInt64List(Internal.ProtobufList protobufList) throws InvalidProtocolBufferException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        int i = this.capacity & 7;
        if (i == 0) {
            do {
                ((ProtobufArrayList) protobufList).add(Long.valueOf(charArrayPoolBase.readSInt64()));
                if (charArrayPoolBase.isAtEnd()) {
                    return;
                } else {
                    tag = charArrayPoolBase.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        if (i == 2) {
            int totalBytesRead = charArrayPoolBase.getTotalBytesRead() + charArrayPoolBase.readUInt32();
            do {
                ((ProtobufArrayList) protobufList).add(Long.valueOf(charArrayPoolBase.readSInt64()));
            } while (charArrayPoolBase.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidWireType();
    }

    public void readUInt32List(Internal.ProtobufList protobufList) throws InvalidProtocolBufferException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        int i = this.capacity & 7;
        if (i == 0) {
            do {
                ((ProtobufArrayList) protobufList).add(Integer.valueOf(charArrayPoolBase.readUInt32()));
                if (charArrayPoolBase.isAtEnd()) {
                    return;
                } else {
                    tag = charArrayPoolBase.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        if (i == 2) {
            int totalBytesRead = charArrayPoolBase.getTotalBytesRead() + charArrayPoolBase.readUInt32();
            do {
                ((ProtobufArrayList) protobufList).add(Integer.valueOf(charArrayPoolBase.readUInt32()));
            } while (charArrayPoolBase.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidWireType();
    }

    public void readUInt64List(Internal.ProtobufList protobufList) throws InvalidProtocolBufferException, androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        int i = this.capacity & 7;
        if (i == 0) {
            do {
                ((ProtobufArrayList) protobufList).add(Long.valueOf(charArrayPoolBase.readUInt64()));
                if (charArrayPoolBase.isAtEnd()) {
                    return;
                } else {
                    tag = charArrayPoolBase.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        if (i == 2) {
            int totalBytesRead = charArrayPoolBase.getTotalBytesRead() + charArrayPoolBase.readUInt32();
            do {
                ((ProtobufArrayList) protobufList).add(Long.valueOf(charArrayPoolBase.readUInt64()));
            } while (charArrayPoolBase.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidWireType();
    }

    public void readDoubleList(Internal.ProtobufList protobufList) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        int i = this.capacity & 7;
        if (i == 1) {
            do {
                ((ProtobufArrayList) protobufList).add(Double.valueOf(charArrayPoolBase.readDouble()));
                if (charArrayPoolBase.isAtEnd()) {
                    return;
                } else {
                    tag = charArrayPoolBase.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        if (i == 2) {
            int uInt32 = charArrayPoolBase.readUInt32();
            if ((uInt32 & 7) == 0) {
                int totalBytesRead = charArrayPoolBase.getTotalBytesRead() + uInt32;
                do {
                    ((ProtobufArrayList) protobufList).add(Double.valueOf(charArrayPoolBase.readDouble()));
                } while (charArrayPoolBase.getTotalBytesRead() < totalBytesRead);
                return;
            }
            throw new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException("Failed to parse the message.");
        }
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidWireType();
    }

    public void readFixed64List(Internal.ProtobufList protobufList) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        int i = this.capacity & 7;
        if (i == 1) {
            do {
                ((ProtobufArrayList) protobufList).add(Long.valueOf(charArrayPoolBase.readFixed64()));
                if (charArrayPoolBase.isAtEnd()) {
                    return;
                } else {
                    tag = charArrayPoolBase.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        if (i == 2) {
            int uInt32 = charArrayPoolBase.readUInt32();
            if ((uInt32 & 7) == 0) {
                int totalBytesRead = charArrayPoolBase.getTotalBytesRead() + uInt32;
                do {
                    ((ProtobufArrayList) protobufList).add(Long.valueOf(charArrayPoolBase.readFixed64()));
                } while (charArrayPoolBase.getTotalBytesRead() < totalBytesRead);
                return;
            }
            throw new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException("Failed to parse the message.");
        }
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidWireType();
    }

    public void readSFixed64List(Internal.ProtobufList protobufList) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        int i = this.capacity & 7;
        if (i == 1) {
            do {
                ((ProtobufArrayList) protobufList).add(Long.valueOf(charArrayPoolBase.readSFixed64()));
                if (charArrayPoolBase.isAtEnd()) {
                    return;
                } else {
                    tag = charArrayPoolBase.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        if (i == 2) {
            int uInt32 = charArrayPoolBase.readUInt32();
            if ((uInt32 & 7) == 0) {
                int totalBytesRead = charArrayPoolBase.getTotalBytesRead() + uInt32;
                do {
                    ((ProtobufArrayList) protobufList).add(Long.valueOf(charArrayPoolBase.readSFixed64()));
                } while (charArrayPoolBase.getTotalBytesRead() < totalBytesRead);
                return;
            }
            throw new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException("Failed to parse the message.");
        }
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidWireType();
    }

    public void readFixed32List(Internal.ProtobufList protobufList) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        int i = this.capacity & 7;
        if (i == 2) {
            int uInt32 = charArrayPoolBase.readUInt32();
            if ((uInt32 & 3) == 0) {
                int totalBytesRead = charArrayPoolBase.getTotalBytesRead() + uInt32;
                do {
                    ((ProtobufArrayList) protobufList).add(Integer.valueOf(charArrayPoolBase.readFixed32()));
                } while (charArrayPoolBase.getTotalBytesRead() < totalBytesRead);
                return;
            }
            throw new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException("Failed to parse the message.");
        }
        if (i == 5) {
            do {
                ((ProtobufArrayList) protobufList).add(Integer.valueOf(charArrayPoolBase.readFixed32()));
                if (charArrayPoolBase.isAtEnd()) {
                    return;
                } else {
                    tag = charArrayPoolBase.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidWireType();
    }

    public void readFloatList(Internal.ProtobufList protobufList) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        int i = this.capacity & 7;
        if (i == 2) {
            int uInt32 = charArrayPoolBase.readUInt32();
            if ((uInt32 & 3) == 0) {
                int totalBytesRead = charArrayPoolBase.getTotalBytesRead() + uInt32;
                do {
                    ((ProtobufArrayList) protobufList).add(Float.valueOf(charArrayPoolBase.readFloat()));
                } while (charArrayPoolBase.getTotalBytesRead() < totalBytesRead);
                return;
            }
            throw new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException("Failed to parse the message.");
        }
        if (i == 5) {
            do {
                ((ProtobufArrayList) protobufList).add(Float.valueOf(charArrayPoolBase.readFloat()));
                if (charArrayPoolBase.isAtEnd()) {
                    return;
                } else {
                    tag = charArrayPoolBase.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidWireType();
    }

    public void readSFixed32List(Internal.ProtobufList protobufList) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        int tag;
        CharArrayPoolBase charArrayPoolBase = (CharArrayPoolBase) this.buffer;
        int i = this.capacity & 7;
        if (i == 2) {
            int uInt32 = charArrayPoolBase.readUInt32();
            if ((uInt32 & 3) == 0) {
                int totalBytesRead = charArrayPoolBase.getTotalBytesRead() + uInt32;
                do {
                    ((ProtobufArrayList) protobufList).add(Integer.valueOf(charArrayPoolBase.readSFixed32()));
                } while (charArrayPoolBase.getTotalBytesRead() < totalBytesRead);
                return;
            }
            throw new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException("Failed to parse the message.");
        }
        if (i == 5) {
            do {
                ((ProtobufArrayList) protobufList).add(Integer.valueOf(charArrayPoolBase.readSFixed32()));
                if (charArrayPoolBase.isAtEnd()) {
                    return;
                } else {
                    tag = charArrayPoolBase.readTag();
                }
            } while (tag == this.capacity);
            this.gapEnd = tag;
            return;
        }
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidWireType();
    }
}
