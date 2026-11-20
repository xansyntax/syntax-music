package androidx.datastore.preferences.protobuf;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class UnknownFieldSetLite {
    public static final UnknownFieldSetLite DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
    public int count;
    public boolean isMutable;
    public int memoizedSerializedSize = -1;
    public Object[] objects;
    public int[] tags;

    public UnknownFieldSetLite(int i, int[] iArr, Object[] objArr, boolean z) {
        this.count = i;
        this.tags = iArr;
        this.objects = objArr;
        this.isMutable = z;
    }

    public final void ensureCapacity(int i) {
        int[] iArr = this.tags;
        if (i > iArr.length) {
            int i2 = this.count;
            int i3 = (i2 / 2) + i2;
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.tags = Arrays.copyOf(iArr, i);
            this.objects = Arrays.copyOf(this.objects, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int i = this.count;
        if (i == unknownFieldSetLite.count) {
            int[] iArr = this.tags;
            int[] iArr2 = unknownFieldSetLite.tags;
            for (int i2 = 0; i2 < i; i2++) {
                if (iArr[i2] == iArr2[i2]) {
                }
            }
            Object[] objArr = this.objects;
            Object[] objArr2 = unknownFieldSetLite.objects;
            int i3 = this.count;
            for (int i4 = 0; i4 < i3; i4++) {
                if (objArr[i4].equals(objArr2[i4])) {
                }
            }
            return true;
        }
        return false;
    }

    public final int getSerializedSize() {
        int iComputeTagSize;
        int iComputeUInt64SizeNoTag;
        int iComputeTagSize2;
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            int i4 = this.tags[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.objects[i3]).getClass();
                    iComputeTagSize2 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i5) + 8;
                } else if (i6 == 2) {
                    iComputeTagSize2 = CodedOutputStream$OutputStreamEncoder.computeBytesSize(i5, (ByteString$LiteralByteString) this.objects[i3]);
                } else if (i6 == 3) {
                    iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(i5) * 2;
                    iComputeUInt64SizeNoTag = ((UnknownFieldSetLite) this.objects[i3]).getSerializedSize();
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
                    }
                    ((Integer) this.objects[i3]).getClass();
                    iComputeTagSize2 = CodedOutputStream$OutputStreamEncoder.computeTagSize(i5) + 4;
                }
                i2 = iComputeTagSize2 + i2;
            } else {
                long jLongValue = ((Long) this.objects[i3]).longValue();
                iComputeTagSize = CodedOutputStream$OutputStreamEncoder.computeTagSize(i5);
                iComputeUInt64SizeNoTag = CodedOutputStream$OutputStreamEncoder.computeUInt64SizeNoTag(jLongValue);
            }
            i2 = iComputeUInt64SizeNoTag + iComputeTagSize + i2;
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public final int hashCode() {
        int i = this.count;
        int i2 = (527 + i) * 31;
        int[] iArr = this.tags;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.objects;
        int i6 = this.count;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final void storeField(int i, Object obj) {
        if (!this.isMutable) {
            throw new UnsupportedOperationException();
        }
        ensureCapacity(this.count + 1);
        int[] iArr = this.tags;
        int i2 = this.count;
        iArr[i2] = i;
        this.objects[i2] = obj;
        this.count = i2 + 1;
    }

    public final void writeTo(ManifestSchemaFactory manifestSchemaFactory) {
        if (this.count == 0) {
            return;
        }
        manifestSchemaFactory.getClass();
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = (CodedOutputStream$OutputStreamEncoder) manifestSchemaFactory.messageInfoFactory;
        for (int i = 0; i < this.count; i++) {
            int i2 = this.tags[i];
            Object obj = this.objects[i];
            int i3 = i2 >>> 3;
            int i4 = i2 & 7;
            if (i4 == 0) {
                codedOutputStream$OutputStreamEncoder.writeUInt64(i3, ((Long) obj).longValue());
            } else if (i4 == 1) {
                codedOutputStream$OutputStreamEncoder.writeFixed64(i3, ((Long) obj).longValue());
            } else if (i4 == 2) {
                codedOutputStream$OutputStreamEncoder.writeBytes(i3, (ByteString$LiteralByteString) obj);
            } else if (i4 == 3) {
                codedOutputStream$OutputStreamEncoder.writeTag(i3, 3);
                ((UnknownFieldSetLite) obj).writeTo(manifestSchemaFactory);
                codedOutputStream$OutputStreamEncoder.writeTag(i3, 4);
            } else {
                if (i4 != 5) {
                    throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
                }
                codedOutputStream$OutputStreamEncoder.writeFixed32(i3, ((Integer) obj).intValue());
            }
        }
    }
}
