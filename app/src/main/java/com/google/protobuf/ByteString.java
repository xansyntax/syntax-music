package com.google.protobuf;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ByteString implements Iterable, Serializable {
    public static final LiteralByteString EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
    public static final ExtensionSchemaLite byteArrayCopier;
    public int hash = 0;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class BoundedByteString extends LeafByteString {
        public final byte[] bytes;
        public final int length;
        public final int offset;

        public BoundedByteString(byte[] bArr, int i, int i2) {
            ByteString.checkRange(i, i + i2, bArr.length);
            this.bytes = bArr;
            this.offset = i;
            this.length = i2;
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.protobuf.ByteString
        public final void copyToInternal(byte[] bArr, int i) {
            System.arraycopy(this.bytes, this.offset, bArr, 0, i);
        }

        @Override // com.google.protobuf.ByteString
        public final boolean equalsInternal(ByteString byteString) {
            boolean z = byteString instanceof LiteralByteString;
            if (!z && !(byteString instanceof BoundedByteString)) {
                return byteString.equalsInternal(this);
            }
            int size = byteString.size();
            int i = this.length;
            if (i > size) {
                throw new IllegalArgumentException("Length too large: " + i + i);
            }
            if (i > byteString.size()) {
                StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Ran off end of other: 0, ", ", ");
                sbM2m.append(byteString.size());
                throw new IllegalArgumentException(sbM2m.toString());
            }
            byte[] bArr = this.bytes;
            int i2 = this.offset;
            if (z) {
                return ByteString.subArrayEquals(i2, 0, i, bArr, ((LiteralByteString) byteString).bytes);
            }
            if (!(byteString instanceof BoundedByteString)) {
                return byteString.substringNoCopy(0, i).equals(substringNoCopy(i2, i + i2));
            }
            BoundedByteString boundedByteString = (BoundedByteString) byteString;
            return ByteString.subArrayEquals(i2, boundedByteString.offset, i, bArr, boundedByteString.bytes);
        }

        @Override // com.google.protobuf.ByteString
        public final byte internalByteAt(int i) {
            return this.bytes[this.offset + i];
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isValidUtf8() {
            int i = this.length;
            int i2 = this.offset;
            return Utf8.isValidUtf8Internal(this.bytes, i2, i + i2);
        }

        @Override // com.google.protobuf.ByteString
        public final CodedInputStream.ArrayDecoderOldVarint newCodedInput() {
            return CodedInputStream.newInstance(this.bytes, this.offset, this.length, true);
        }

        @Override // com.google.protobuf.ByteString
        public final int partialHash(int i, int i2) {
            return Internal.partialHash(i, this.offset, i2, this.bytes);
        }

        @Override // com.google.protobuf.ByteString
        public final int size() {
            return this.length;
        }

        @Override // com.google.protobuf.ByteString
        public final LeafByteString substringNoCopy(int i, int i2) {
            int iCheckRange = ByteString.checkRange(i, i2, this.length);
            if (iCheckRange == 0) {
                return ByteString.EMPTY;
            }
            return new BoundedByteString(this.bytes, this.offset + i, iCheckRange);
        }

        @Override // com.google.protobuf.ByteString
        public final String toStringInternal() {
            Charset charset = StandardCharsets.UTF_8;
            return new String(this.bytes, this.offset, this.length, charset);
        }

        @Override // com.google.protobuf.ByteString
        public final void writeTo$1(CodedOutputStream codedOutputStream) {
            codedOutputStream.writeLazy(this.bytes, this.offset, this.length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class LeafByteString extends ByteString {
        @Override // java.lang.Iterable
        public final Iterator iterator() {
            return new AnonymousClass1(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LiteralByteString extends LeafByteString {
        public final byte[] bytes;

        public LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.bytes = bArr;
        }

        @Override // com.google.protobuf.ByteString
        public final void copyToInternal(byte[] bArr, int i) {
            System.arraycopy(this.bytes, 0, bArr, 0, i);
        }

        @Override // com.google.protobuf.ByteString
        public final boolean equalsInternal(ByteString byteString) {
            boolean z = byteString instanceof LiteralByteString;
            byte[] bArr = this.bytes;
            if (z) {
                return Arrays.equals(bArr, ((LiteralByteString) byteString).bytes);
            }
            if (!(byteString instanceof BoundedByteString)) {
                return byteString.equalsInternal(this);
            }
            int length = bArr.length;
            BoundedByteString boundedByteString = (BoundedByteString) byteString;
            int i = boundedByteString.length;
            if (length > i) {
                throw new IllegalArgumentException("Length too large: " + length + bArr.length);
            }
            if (length > i) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m(length, i, "Ran off end of other: 0, ", ", "));
                return false;
            }
            if (byteString instanceof LiteralByteString) {
                return ByteString.subArrayEquals(0, 0, length, bArr, ((LiteralByteString) byteString).bytes);
            }
            return ByteString.subArrayEquals(0, boundedByteString.offset, length, bArr, boundedByteString.bytes);
        }

        @Override // com.google.protobuf.ByteString
        public final byte internalByteAt(int i) {
            return this.bytes[i];
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isValidUtf8() {
            Utf8.MobileProcessor mobileProcessor = Utf8.processor;
            byte[] bArr = this.bytes;
            return Utf8.isValidUtf8Internal(bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.ByteString
        public final CodedInputStream.ArrayDecoderOldVarint newCodedInput() {
            byte[] bArr = this.bytes;
            return CodedInputStream.newInstance(bArr, 0, bArr.length, true);
        }

        @Override // com.google.protobuf.ByteString
        public final int partialHash(int i, int i2) {
            return Internal.partialHash(i, 0, i2, this.bytes);
        }

        @Override // com.google.protobuf.ByteString
        public final int size() {
            return this.bytes.length;
        }

        @Override // com.google.protobuf.ByteString
        public final LeafByteString substringNoCopy(int i, int i2) {
            byte[] bArr = this.bytes;
            int iCheckRange = ByteString.checkRange(0, i2, bArr.length);
            return iCheckRange == 0 ? ByteString.EMPTY : new BoundedByteString(bArr, 0, iCheckRange);
        }

        @Override // com.google.protobuf.ByteString
        public final String toStringInternal() {
            return new String(this.bytes, StandardCharsets.UTF_8);
        }

        @Override // com.google.protobuf.ByteString
        public final void writeTo$1(CodedOutputStream codedOutputStream) {
            byte[] bArr = this.bytes;
            codedOutputStream.writeLazy(bArr, 0, bArr.length);
        }
    }

    static {
        byteArrayCopier = Android.isOnAndroidDevice() ? new ExtensionSchemaLite((byte) 3) : new ExtensionSchemaLite((byte) 2);
    }

    public static int checkRange(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m(i, "Beginning index: ", " < 0"));
            return 0;
        }
        if (i2 < i) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(i, i2, "Beginning index larger than ending index: ", ", "));
            return 0;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(i2, i3, "End index: ", " >= "));
        return 0;
    }

    public static LiteralByteString copyFrom(byte[] bArr, int i, int i2) {
        try {
            return copyFrom$1(bArr, i, i2);
        } catch (InvalidProtocolBufferException e) {
            throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e);
        }
    }

    public static LiteralByteString copyFrom$1(byte[] bArr, int i, int i2) {
        byte[] bArrCopyOfRange;
        if (i2 == 0) {
            return EMPTY;
        }
        checkRange(i, i + i2, bArr.length);
        switch (byteArrayCopier.$r8$classId) {
            case 2:
                bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i2 + i);
                break;
            default:
                bArrCopyOfRange = new byte[i2];
                System.arraycopy(bArr, i, bArrCopyOfRange, 0, i2);
                break;
        }
        return new LiteralByteString(bArrCopyOfRange);
    }

    public static LiteralByteString copyFromUtf8(String str) {
        return str.isEmpty() ? EMPTY : new LiteralByteString(str.getBytes(StandardCharsets.UTF_8));
    }

    public static boolean subArrayEquals(int i, int i2, int i3, byte[] bArr, byte[] bArr2) {
        int i4 = i + i3;
        checkRange(i, i4, bArr.length);
        checkRange(i2, i3 + i2, bArr2.length);
        while (i < i4) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public abstract void copyToInternal(byte[] bArr, int i);

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        int size = size();
        if (size != byteString.size()) {
            return false;
        }
        if (size == 0) {
            return true;
        }
        int i = this.hash;
        int i2 = byteString.hash;
        if (i == 0 || i2 == 0 || i == i2) {
            return equalsInternal(byteString);
        }
        return false;
    }

    public abstract boolean equalsInternal(ByteString byteString);

    public final int hashCode() {
        int iPartialHash = this.hash;
        if (iPartialHash == 0) {
            int size = size();
            iPartialHash = partialHash(size, size);
            if (iPartialHash == 0) {
                iPartialHash = 1;
            }
            this.hash = iPartialHash;
        }
        return iPartialHash;
    }

    public abstract byte internalByteAt(int i);

    public abstract boolean isValidUtf8();

    public abstract CodedInputStream.ArrayDecoderOldVarint newCodedInput();

    public abstract int partialHash(int i, int i2);

    public abstract int size();

    public abstract LeafByteString substringNoCopy(int i, int i2);

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        copyToInternal(bArr, size);
        return bArr;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        String strEscapeBytes = size() <= 50 ? Utf8.MobileProcessor.escapeBytes(toByteArray()) : Utf8.MobileProcessor.escapeBytes(substringNoCopy(0, 47).toByteArray()).concat("...");
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(size);
        sb.append(" contents=\"");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, strEscapeBytes, "\">");
    }

    public abstract String toStringInternal();

    public final String toStringUtf8() {
        Charset charset = StandardCharsets.UTF_8;
        return size() == 0 ? "" : toStringInternal();
    }

    public abstract void writeTo$1(CodedOutputStream codedOutputStream);

    /* JADX INFO: renamed from: com.google.protobuf.ByteString$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Iterator {
        public final int limit;
        public final /* synthetic */ Object this$0;
        public final /* synthetic */ byte $r8$classId = 1;
        public int position = 0;

        public AnonymousClass1(androidx.datastore.preferences.protobuf.ByteString$LiteralByteString byteString$LiteralByteString) {
            this.this$0 = byteString$LiteralByteString;
            this.limit = byteString$LiteralByteString.size();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            switch (this.$r8$classId) {
                case 0:
                    return this.position < this.limit;
                default:
                    return this.position < this.limit;
            }
        }

        @Override // java.util.Iterator
        public final Object next() {
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            int i = this.limit;
            switch (b) {
                case 0:
                    int i2 = this.position;
                    if (i2 < i) {
                        this.position = i2 + 1;
                        return Byte.valueOf(((LeafByteString) obj).internalByteAt(i2));
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                    return null;
                default:
                    int i3 = this.position;
                    if (i3 < i) {
                        this.position = i3 + 1;
                        return Byte.valueOf(((androidx.datastore.preferences.protobuf.ByteString$LiteralByteString) obj).internalByteAt(i3));
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                    return null;
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            switch (this.$r8$classId) {
                case 0:
                    throw new UnsupportedOperationException();
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public AnonymousClass1(LeafByteString leafByteString) {
            this.this$0 = leafByteString;
            this.limit = leafByteString.size();
        }
    }
}
