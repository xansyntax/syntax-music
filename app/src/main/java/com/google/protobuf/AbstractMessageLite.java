package com.google.protobuf;

import android.R;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractMessageLite implements MessageLite {
    protected int memoizedHashCode;

    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        Builder.addAll((Iterable) iterable, (List) list);
    }

    public static void checkByteStringIsUtf8(ByteString byteString) {
        if (byteString.isValidUtf8()) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Byte string is not UTF-8.");
    }

    public abstract int getSerializedSize(Schema schema);

    public final String getSerializingExceptionMessage(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException();
    }

    @Override // com.google.protobuf.MessageLite
    public byte[] toByteArray() {
        try {
            int serializedSize = getSerializedSize();
            byte[] bArr = new byte[serializedSize];
            CodedOutputStream.ArrayEncoder arrayEncoder = new CodedOutputStream.ArrayEncoder(bArr, serializedSize);
            writeTo(arrayEncoder);
            arrayEncoder.checkNoSpaceLeft();
            return bArr;
        } catch (IOException e) {
            PathKt$$ExternalSyntheticBUOutline0.m(getSerializingExceptionMessage("byte array"), (Throwable) e);
            return null;
        }
    }

    public ByteString toByteString() {
        try {
            int serializedSize = getSerializedSize();
            ByteString.LiteralByteString literalByteString = ByteString.EMPTY;
            byte[] bArr = new byte[serializedSize];
            CodedOutputStream.ArrayEncoder arrayEncoder = new CodedOutputStream.ArrayEncoder(bArr, serializedSize);
            writeTo(arrayEncoder);
            arrayEncoder.checkNoSpaceLeft();
            return new ByteString.LiteralByteString(bArr);
        } catch (IOException e) {
            PathKt$$ExternalSyntheticBUOutline0.m(getSerializingExceptionMessage("ByteString"), (Throwable) e);
            return null;
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(serializedSize) + serializedSize;
        if (iComputeUInt32SizeNoTag > 4096) {
            iComputeUInt32SizeNoTag = 4096;
        }
        CodedOutputStream.OutputStreamEncoder outputStreamEncoder = new CodedOutputStream.OutputStreamEncoder(outputStream, iComputeUInt32SizeNoTag);
        outputStreamEncoder.writeUInt32NoTag(serializedSize);
        writeTo(outputStreamEncoder);
        if (outputStreamEncoder.position > 0) {
            outputStreamEncoder.doFlush();
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        if (serializedSize > 4096) {
            serializedSize = 4096;
        }
        CodedOutputStream.OutputStreamEncoder outputStreamEncoder = new CodedOutputStream.OutputStreamEncoder(outputStream, serializedSize);
        writeTo(outputStreamEncoder);
        if (outputStreamEncoder.position > 0) {
            outputStreamEncoder.doFlush();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Builder implements MessageLite.Builder {
        public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
            byte[] bArr = Internal.EMPTY_BYTE_ARRAY;
            iterable.getClass();
            if (iterable instanceof LazyStringList) {
                List underlyingElements = ((LazyStringList) iterable).getUnderlyingElements();
                if (list != null) {
                    PathKt$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                list.size();
                Iterator it = underlyingElements.iterator();
                if (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    if (next instanceof ByteString) {
                        throw null;
                    }
                    if (!(next instanceof byte[])) {
                        throw null;
                    }
                    byte[] bArr2 = (byte[]) next;
                    ByteString.copyFrom(bArr2, 0, bArr2.length);
                    throw null;
                }
                return;
            }
            if (iterable instanceof PrimitiveNonBoxingCollection) {
                list.addAll((Collection) iterable);
                return;
            }
            if (iterable instanceof Collection) {
                int size = ((Collection) iterable).size();
                if (list instanceof ArrayList) {
                    ((ArrayList) list).ensureCapacity(list.size() + size);
                } else if (list instanceof ProtobufArrayList) {
                    ProtobufArrayList protobufArrayList = (ProtobufArrayList) list;
                    int i = protobufArrayList.size + size;
                    Object[] objArr = protobufArrayList.array;
                    if (i > objArr.length) {
                        if (objArr.length == 0) {
                            protobufArrayList.array = new Object[Math.max(i, 10)];
                        } else {
                            int length = objArr.length;
                            while (length < i) {
                                length = Format$$ExternalSyntheticOutline0.m(length, 3, 2, 1, 10);
                            }
                            protobufArrayList.array = Arrays.copyOf(protobufArrayList.array, length);
                        }
                    }
                }
            }
            int size2 = list.size();
            if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
                for (Object obj : iterable) {
                    if (obj == null) {
                        resetListAndThrow(size2, list);
                        throw null;
                    }
                    list.add(obj);
                }
                return;
            }
            List list2 = (List) iterable;
            int size3 = list2.size();
            for (int i2 = 0; i2 < size3; i2++) {
                R.attr attrVar = (Object) list2.get(i2);
                if (attrVar == null) {
                    resetListAndThrow(size2, list);
                    throw null;
                }
                list.add(attrVar);
            }
        }

        public static UninitializedMessageException newUninitializedMessageException(MessageLite messageLite) {
            return new UninitializedMessageException();
        }

        public static void resetListAndThrow(int i, List list) {
            String str = "Element at index " + (list.size() - i) + " is null.";
            for (int size = list.size() - 1; size >= i; size--) {
                list.remove(size);
            }
            throw new NullPointerException(str);
        }

        public final String getReadingExceptionMessage() {
            return "Reading " + getClass().getName() + " from a ByteString threw an IOException (should never happen).";
        }

        public abstract Builder internalMergeFrom(AbstractMessageLite abstractMessageLite);

        public boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i = inputStream.read();
            if (i == -1) {
                return false;
            }
            int rawVarint32 = CodedInputStream.readRawVarint32(inputStream, i);
            if (rawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            m910mergeFrom((InputStream) new LimitedInputStream(inputStream, rawVarint32), extensionRegistryLite);
            return true;
        }

        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public Builder m905mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            try {
                CodedInputStream.ArrayDecoderOldVarint arrayDecoderOldVarintNewCodedInput = byteString.newCodedInput();
                m907mergeFrom((CodedInputStream) arrayDecoderOldVarintNewCodedInput);
                arrayDecoderOldVarintNewCodedInput.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                PathKt$$ExternalSyntheticBUOutline0.m(getReadingExceptionMessage(), (Throwable) e2);
                return null;
            }
        }

        /* JADX INFO: renamed from: mergeFrom */
        public abstract Builder m920mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

        /* JADX INFO: renamed from: mergeFrom */
        public abstract Builder m921mergeFrom(byte[] bArr, int i, int i2);

        /* JADX INFO: renamed from: mergeFrom */
        public abstract Builder m922mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite);

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class LimitedInputStream extends FilterInputStream implements InputStreamRetargetInterface {
            public int limit;

            public LimitedInputStream(InputStream inputStream, int i) {
                super(inputStream);
                this.limit = i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public final int available() {
                return Math.min(super.available(), this.limit);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public final int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = this.limit;
                if (i3 <= 0) {
                    return -1;
                }
                int i4 = super.read(bArr, i, Math.min(i2, i3));
                if (i4 >= 0) {
                    this.limit -= i4;
                }
                return i4;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public final long skip(long j) {
                int iSkip = (int) super.skip(Math.min(j, this.limit));
                if (iSkip >= 0) {
                    this.limit -= iSkip;
                }
                return iSkip;
            }

            @Override // java.io.InputStream, j$.io.InputStreamRetargetInterface
            public /* synthetic */ long transferTo(OutputStream outputStream) {
                return DesugarInputStream.transferTo(this, outputStream);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public final int read() throws IOException {
                if (this.limit <= 0) {
                    return -1;
                }
                int i = super.read();
                if (i >= 0) {
                    this.limit--;
                }
                return i;
            }
        }

        public boolean mergeDelimitedFrom(InputStream inputStream) {
            return mergeDelimitedFrom(inputStream, ExtensionRegistryLite.getEmptyRegistry());
        }

        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public Builder m907mergeFrom(CodedInputStream codedInputStream) {
            return m920mergeFrom(codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
        }

        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public Builder m906mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            try {
                CodedInputStream.ArrayDecoderOldVarint arrayDecoderOldVarintNewCodedInput = byteString.newCodedInput();
                m920mergeFrom(arrayDecoderOldVarintNewCodedInput, extensionRegistryLite);
                arrayDecoderOldVarintNewCodedInput.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                PathKt$$ExternalSyntheticBUOutline0.m(getReadingExceptionMessage(), (Throwable) e2);
                return null;
            }
        }

        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public Builder m911mergeFrom(byte[] bArr) {
            return m921mergeFrom(bArr, 0, bArr.length);
        }

        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public Builder m912mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return m922mergeFrom(bArr, 0, bArr.length, extensionRegistryLite);
        }

        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public Builder m909mergeFrom(InputStream inputStream) {
            CodedInputStream codedInputStreamNewInstance = CodedInputStream.newInstance(inputStream);
            m907mergeFrom(codedInputStreamNewInstance);
            codedInputStreamNewInstance.checkLastTagWas(0);
            return this;
        }

        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public Builder m910mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            CodedInputStream codedInputStreamNewInstance = CodedInputStream.newInstance(inputStream);
            m920mergeFrom(codedInputStreamNewInstance, extensionRegistryLite);
            codedInputStreamNewInstance.checkLastTagWas(0);
            return this;
        }

        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public Builder m908mergeFrom(MessageLite messageLite) {
            return internalMergeFrom((AbstractMessageLite) messageLite);
        }

        @Deprecated
        public static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
            addAll((Iterable) iterable, (List) collection);
        }
    }
}
