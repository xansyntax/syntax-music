package com.google.protobuf;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Utf8 {
    public static final MobileProcessor processor;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ServerProcessorWithEncodedLength extends MobileProcessor {
        public static final Method encodedLengthMethod;

        static {
            Method method;
            try {
                method = String.class.getMethod("encodedLength", Charset.class);
            } catch (ReflectiveOperationException unused) {
                method = null;
            }
            encodedLengthMethod = method;
        }

        @Override // com.google.protobuf.Utf8.MobileProcessor
        public final int encodedLength(String str) {
            try {
                return ((Integer) encodedLengthMethod.invoke(str, StandardCharsets.UTF_8)).intValue();
            } catch (ReflectiveOperationException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UnpairedSurrogateException extends Exception {
    }

    static {
        MobileProcessor serverProcessorWithEncodedLength;
        if (Android.isOnAndroidDevice()) {
            serverProcessorWithEncodedLength = new MobileProcessor((byte) 0);
        } else {
            serverProcessorWithEncodedLength = ServerProcessorWithEncodedLength.encodedLengthMethod != null ? new ServerProcessorWithEncodedLength((byte) 1) : new MobileProcessor((byte) 1);
        }
        processor = serverProcessorWithEncodedLength;
    }

    public static int encodedLengthGeneral(int i, String str) throws UnpairedSurrogateException {
        int length = str.length();
        int i2 = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 2048) {
                i2 += (127 - cCharAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(str, i) < 65536) {
                        throw new UnpairedSurrogateException(Fragment$5$$ExternalSyntheticOutline0.m(i, length, "Unpaired surrogate at index ", " of "));
                    }
                    i++;
                }
            }
            i++;
        }
        return i2;
    }

    public static boolean isValidUtf8Internal(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] >= 0) {
            i++;
        }
        if (i >= i2) {
            return true;
        }
        while (i < i2) {
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                i = i3;
            } else if (b < -32) {
                if (i3 >= i2 || b < -62) {
                    return false;
                }
                i += 2;
                if (bArr[i3] > -65) {
                    return false;
                }
            } else if (b < -16) {
                if (i3 >= i2 - 1) {
                    return false;
                }
                int i4 = i + 2;
                byte b2 = bArr[i3];
                if (b2 > -65) {
                    return false;
                }
                if (b == -32 && b2 < -96) {
                    return false;
                }
                if (b == -19 && b2 >= -96) {
                    return false;
                }
                i += 3;
                if (bArr[i4] > -65) {
                    return false;
                }
            } else {
                if (i3 >= i2 - 2) {
                    return false;
                }
                int i5 = i + 2;
                byte b3 = bArr[i3];
                if (b3 > -65) {
                    return false;
                }
                if ((((b3 + 112) + (b << 28)) >> 30) != 0) {
                    return false;
                }
                int i6 = i + 3;
                if (bArr[i5] > -65) {
                    return false;
                }
                i += 4;
                if (bArr[i6] > -65) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class MobileProcessor {
        public static final ExtensionSchemaLite LITE_SCHEMA = new ExtensionSchemaLite(0);
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ MobileProcessor(byte b) {
            this.$r8$classId = b;
        }

        public static int decodeBytes(byte[] bArr, int i, ArrayDecoders$Registers arrayDecoders$Registers) throws InvalidProtocolBufferException {
            int iDecodeVarint32 = decodeVarint32(bArr, i, arrayDecoders$Registers);
            int i2 = arrayDecoders$Registers.int1;
            if (i2 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i2 > bArr.length - iDecodeVarint32) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i2 == 0) {
                arrayDecoders$Registers.object1 = ByteString.EMPTY;
                return iDecodeVarint32;
            }
            arrayDecoders$Registers.object1 = ByteString.copyFrom(bArr, iDecodeVarint32, i2);
            return iDecodeVarint32 + i2;
        }

        public static int decodeFixed32(byte[] bArr, int i) {
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        public static long decodeFixed64(byte[] bArr, int i) {
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }

        public static int decodeGroupField(Schema schema, byte[] bArr, int i, int i2, int i3, ArrayDecoders$Registers arrayDecoders$Registers) throws InvalidProtocolBufferException {
            Object objNewInstance = schema.newInstance();
            int iMergeGroupField = mergeGroupField(objNewInstance, schema, bArr, i, i2, i3, arrayDecoders$Registers);
            schema.makeImmutable(objNewInstance);
            arrayDecoders$Registers.object1 = objNewInstance;
            return iMergeGroupField;
        }

        public static int decodeMessageList(Schema schema, int i, byte[] bArr, int i2, int i3, Internal.ProtobufList protobufList, ArrayDecoders$Registers arrayDecoders$Registers) throws InvalidProtocolBufferException {
            Object objNewInstance = schema.newInstance();
            Schema schema2 = schema;
            byte[] bArr2 = bArr;
            int i4 = i3;
            ArrayDecoders$Registers arrayDecoders$Registers2 = arrayDecoders$Registers;
            int iMergeMessageField = mergeMessageField(objNewInstance, schema2, bArr2, i2, i4, arrayDecoders$Registers2);
            schema2.makeImmutable(objNewInstance);
            arrayDecoders$Registers2.object1 = objNewInstance;
            protobufList.add(objNewInstance);
            while (iMergeMessageField < i4) {
                ArrayDecoders$Registers arrayDecoders$Registers3 = arrayDecoders$Registers2;
                int i5 = i4;
                int iDecodeVarint32 = decodeVarint32(bArr2, iMergeMessageField, arrayDecoders$Registers3);
                if (i != arrayDecoders$Registers3.int1) {
                    break;
                }
                byte[] bArr3 = bArr2;
                Schema schema3 = schema2;
                Object objNewInstance2 = schema3.newInstance();
                iMergeMessageField = mergeMessageField(objNewInstance2, schema3, bArr3, iDecodeVarint32, i5, arrayDecoders$Registers3);
                schema2 = schema3;
                bArr2 = bArr3;
                i4 = i5;
                arrayDecoders$Registers2 = arrayDecoders$Registers3;
                schema2.makeImmutable(objNewInstance2);
                arrayDecoders$Registers2.object1 = objNewInstance2;
                protobufList.add(objNewInstance2);
            }
            return iMergeMessageField;
        }

        public static int decodePackedVarint32List(byte[] bArr, int i, Internal.ProtobufList protobufList, ArrayDecoders$Registers arrayDecoders$Registers) throws InvalidProtocolBufferException {
            IntArrayList intArrayList = (IntArrayList) protobufList;
            int iDecodeVarint32 = decodeVarint32(bArr, i, arrayDecoders$Registers);
            int i2 = arrayDecoders$Registers.int1;
            if (i2 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i2 > bArr.length - iDecodeVarint32) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i3 = i2 + iDecodeVarint32;
            while (iDecodeVarint32 < i3) {
                iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint32, arrayDecoders$Registers);
                intArrayList.addInt(arrayDecoders$Registers.int1);
            }
            if (iDecodeVarint32 == i3) {
                return iDecodeVarint32;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public static int decodeUnknownField(int i, byte[] bArr, int i2, int i3, UnknownFieldSetLite unknownFieldSetLite, ArrayDecoders$Registers arrayDecoders$Registers) throws InvalidProtocolBufferException {
            if ((i >>> 3) == 0) {
                throw InvalidProtocolBufferException.invalidTag();
            }
            int i4 = i & 7;
            if (i4 == 0) {
                int iDecodeVarint64 = decodeVarint64(bArr, i2, arrayDecoders$Registers);
                unknownFieldSetLite.storeField(i, Long.valueOf(arrayDecoders$Registers.long1));
                return iDecodeVarint64;
            }
            if (i4 == 1) {
                unknownFieldSetLite.storeField(i, Long.valueOf(decodeFixed64(bArr, i2)));
                return i2 + 8;
            }
            if (i4 == 2) {
                int iDecodeVarint32 = decodeVarint32(bArr, i2, arrayDecoders$Registers);
                int i5 = arrayDecoders$Registers.int1;
                if (i5 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                if (i5 > bArr.length - iDecodeVarint32) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                if (i5 == 0) {
                    unknownFieldSetLite.storeField(i, ByteString.EMPTY);
                } else {
                    unknownFieldSetLite.storeField(i, ByteString.copyFrom(bArr, iDecodeVarint32, i5));
                }
                return iDecodeVarint32 + i5;
            }
            if (i4 != 3) {
                if (i4 != 5) {
                    throw InvalidProtocolBufferException.invalidTag();
                }
                unknownFieldSetLite.storeField(i, Integer.valueOf(decodeFixed32(bArr, i2)));
                return i2 + 4;
            }
            UnknownFieldSetLite unknownFieldSetLite2 = new UnknownFieldSetLite();
            int i6 = (i & (-8)) | 4;
            int i7 = arrayDecoders$Registers.recursionDepth + 1;
            arrayDecoders$Registers.recursionDepth = i7;
            if (i7 >= 100) {
                throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            }
            int i8 = 0;
            while (i2 < i3) {
                int iDecodeVarint33 = decodeVarint32(bArr, i2, arrayDecoders$Registers);
                i8 = arrayDecoders$Registers.int1;
                if (i8 == i6) {
                    i2 = iDecodeVarint33;
                    break;
                }
                i2 = decodeUnknownField(i8, bArr, iDecodeVarint33, i3, unknownFieldSetLite2, arrayDecoders$Registers);
            }
            arrayDecoders$Registers.recursionDepth--;
            if (i2 > i3 || i8 != i6) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            unknownFieldSetLite.storeField(i, unknownFieldSetLite2);
            return i2;
        }

        public static int decodeVarint32(int i, byte[] bArr, int i2, ArrayDecoders$Registers arrayDecoders$Registers) {
            int i3 = i & 127;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                arrayDecoders$Registers.int1 = i3 | (b << 7);
                return i4;
            }
            int i5 = i3 | ((b & 127) << 7);
            int i6 = i2 + 2;
            byte b2 = bArr[i4];
            if (b2 >= 0) {
                arrayDecoders$Registers.int1 = i5 | (b2 << 14);
                return i6;
            }
            int i7 = i5 | ((b2 & 127) << 14);
            int i8 = i2 + 3;
            byte b3 = bArr[i6];
            if (b3 >= 0) {
                arrayDecoders$Registers.int1 = i7 | (b3 << 21);
                return i8;
            }
            int i9 = i7 | ((b3 & 127) << 21);
            int i10 = i2 + 4;
            byte b4 = bArr[i8];
            if (b4 >= 0) {
                arrayDecoders$Registers.int1 = i9 | (b4 << 28);
                return i10;
            }
            int i11 = i9 | ((b4 & 127) << 28);
            while (true) {
                int i12 = i10 + 1;
                if (bArr[i10] >= 0) {
                    arrayDecoders$Registers.int1 = i11;
                    return i12;
                }
                i10 = i12;
            }
        }

        public static int decodeVarint32List(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList protobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
            IntArrayList intArrayList = (IntArrayList) protobufList;
            int iDecodeVarint32 = decodeVarint32(bArr, i2, arrayDecoders$Registers);
            intArrayList.addInt(arrayDecoders$Registers.int1);
            while (iDecodeVarint32 < i3) {
                int iDecodeVarint33 = decodeVarint32(bArr, iDecodeVarint32, arrayDecoders$Registers);
                if (i != arrayDecoders$Registers.int1) {
                    break;
                }
                iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint33, arrayDecoders$Registers);
                intArrayList.addInt(arrayDecoders$Registers.int1);
            }
            return iDecodeVarint32;
        }

        public static int decodeVarint64(byte[] bArr, int i, ArrayDecoders$Registers arrayDecoders$Registers) {
            int i2 = i + 1;
            long j = bArr[i];
            if (j >= 0) {
                arrayDecoders$Registers.long1 = j;
                return i2;
            }
            int i3 = i + 2;
            byte b = bArr[i2];
            long j2 = (j & 127) | (((long) (b & 127)) << 7);
            int i4 = 7;
            while (b < 0) {
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                i4 += 7;
                j2 |= ((long) (b2 & 127)) << i4;
                b = b2;
                i3 = i5;
            }
            arrayDecoders$Registers.long1 = j2;
            return i3;
        }

        public static int encodeUtf8Naive(String str, byte[] bArr, int i, int i2) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            if (bytes.length - i > i2) {
                throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
            }
            System.arraycopy(bytes, 0, bArr, i, bytes.length);
            return i + bytes.length;
        }

        public static String escapeBytes(byte[] bArr) {
            StringBuilder sb = new StringBuilder(bArr.length);
            for (byte b : bArr) {
                if (b == 34) {
                    sb.append("\\\"");
                } else if (b == 39) {
                    sb.append("\\'");
                } else if (b != 92) {
                    switch (b) {
                        case 7:
                            sb.append("\\a");
                            break;
                        case 8:
                            sb.append("\\b");
                            break;
                        case 9:
                            sb.append("\\t");
                            break;
                        case 10:
                            sb.append("\\n");
                            break;
                        case 11:
                            sb.append("\\v");
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            sb.append("\\f");
                            break;
                        case 13:
                            sb.append("\\r");
                            break;
                        default:
                            if (b < 32 || b > 126) {
                                sb.append('\\');
                                sb.append((char) (((b >>> 6) & 3) + 48));
                                sb.append((char) (((b >>> 3) & 7) + 48));
                                sb.append((char) ((b & 7) + 48));
                            } else {
                                sb.append((char) b);
                            }
                            break;
                    }
                } else {
                    sb.append("\\\\");
                }
            }
            return sb.toString();
        }

        public static boolean isNotTrailingByte(byte b) {
            return b > -65;
        }

        public static MapFieldLite mergeFrom(Object obj, Object obj2) {
            MapFieldLite mapFieldLiteMutableCopy = (MapFieldLite) obj;
            MapFieldLite mapFieldLite = (MapFieldLite) obj2;
            if (!mapFieldLite.isEmpty()) {
                if (!mapFieldLiteMutableCopy.isMutable) {
                    mapFieldLiteMutableCopy = mapFieldLiteMutableCopy.mutableCopy();
                }
                mapFieldLiteMutableCopy.ensureMutable();
                if (!mapFieldLite.isEmpty()) {
                    mapFieldLiteMutableCopy.putAll(mapFieldLite);
                }
            }
            return mapFieldLiteMutableCopy;
        }

        public static int mergeGroupField(Object obj, Schema schema, byte[] bArr, int i, int i2, int i3, ArrayDecoders$Registers arrayDecoders$Registers) throws InvalidProtocolBufferException {
            MessageSchema messageSchema = (MessageSchema) schema;
            int i4 = arrayDecoders$Registers.recursionDepth + 1;
            arrayDecoders$Registers.recursionDepth = i4;
            if (i4 >= 100) {
                throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            }
            int message = messageSchema.parseMessage(obj, bArr, i, i2, i3, arrayDecoders$Registers);
            arrayDecoders$Registers.recursionDepth--;
            arrayDecoders$Registers.object1 = obj;
            return message;
        }

        public static int mergeMessageField(Object obj, Schema schema, byte[] bArr, int i, int i2, ArrayDecoders$Registers arrayDecoders$Registers) throws InvalidProtocolBufferException {
            int iDecodeVarint32 = i + 1;
            int i3 = bArr[i];
            if (i3 < 0) {
                iDecodeVarint32 = decodeVarint32(i3, bArr, iDecodeVarint32, arrayDecoders$Registers);
                i3 = arrayDecoders$Registers.int1;
            }
            int i4 = iDecodeVarint32;
            if (i3 < 0 || i3 > i2 - i4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i5 = arrayDecoders$Registers.recursionDepth + 1;
            arrayDecoders$Registers.recursionDepth = i5;
            if (i5 >= 100) {
                throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            }
            int i6 = i4 + i3;
            schema.mergeFrom(obj, bArr, i4, i6, arrayDecoders$Registers);
            arrayDecoders$Registers.recursionDepth--;
            arrayDecoders$Registers.object1 = obj;
            return i6;
        }

        public static Internal.ProtobufList mutableListAt(long j, Object obj) {
            Internal.ProtobufList protobufList = (Internal.ProtobufList) UnsafeUtil.getObject(j, obj);
            if (((AbstractProtobufList) protobufList).isMutable) {
                return protobufList;
            }
            int size = protobufList.size();
            Internal.ProtobufList protobufListMutableCopyWithCapacity = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            UnsafeUtil.putObject(obj, j, protobufListMutableCopyWithCapacity);
            return protobufListMutableCopyWithCapacity;
        }

        /* JADX WARN: Code duplicated, block: B:107:0x0064 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:20:0x004a  */
        /* JADX WARN: Code duplicated, block: B:24:0x0057  */
        /* JADX WARN: Code duplicated, block: B:26:0x005b A[LOOP:2: B:23:0x0055->B:26:0x005b, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:31:0x006d  */
        /* JADX WARN: Code duplicated, block: B:44:0x009b  */
        /* JADX WARN: Code duplicated, block: B:61:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:63:0x00f1  */
        /* JADX WARN: Code duplicated, block: B:81:0x0067 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:84:0x0050 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:85:0x0093 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:86:0x008e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:87:0x00d9 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:88:0x00d4 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:93:0x006b A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:97:0x0097 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:98:0x0132 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:99:0x012d A[SYNTHETIC] */
        public final String decodeUtf8(byte[] bArr, int i, int i2) {
            int i3;
            byte b;
            int i4;
            byte b2;
            byte b3;
            byte b4;
            switch (this.$r8$classId) {
                case 0:
                    if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
                        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
                    }
                    int i5 = i + i2;
                    char[] cArr = new char[i2];
                    int i6 = 0;
                    while (i < i5) {
                        byte b5 = bArr[i];
                        if (b5 < 0) {
                            while (i < i5) {
                                i3 = i + 1;
                                b = bArr[i];
                                if (b < 0) {
                                    i4 = i6 + 1;
                                    cArr[i6] = (char) b;
                                    while (i3 < i5) {
                                        b2 = bArr[i3];
                                        if (b2 >= 0) {
                                            i3++;
                                            cArr[i4] = (char) b2;
                                            i4++;
                                        } else {
                                            i6 = i4;
                                            i = i3;
                                        }
                                    }
                                    i6 = i4;
                                    i = i3;
                                } else if (b < -32) {
                                    if (i3 < i5) {
                                        throw InvalidProtocolBufferException.invalidUtf8();
                                    }
                                    i += 2;
                                    byte b6 = bArr[i3];
                                    int i7 = i6 + 1;
                                    if (b >= -62 || isNotTrailingByte(b6)) {
                                        throw InvalidProtocolBufferException.invalidUtf8();
                                    }
                                    cArr[i6] = (char) ((b6 & 63) | ((b & 31) << 6));
                                    i6 = i7;
                                } else {
                                    if (b >= -16) {
                                        if (i3 < i5 - 2) {
                                            throw InvalidProtocolBufferException.invalidUtf8();
                                        }
                                        b4 = bArr[i3];
                                        int i8 = i + 3;
                                        byte b7 = bArr[i + 2];
                                        i += 4;
                                        byte b8 = bArr[i8];
                                        int i9 = i6 + 1;
                                        if (!isNotTrailingByte(b4)) {
                                            if ((((b4 + 112) + (b << 28)) >> 30) != 0 && !isNotTrailingByte(b7) && !isNotTrailingByte(b8)) {
                                                int i10 = ((b4 & 63) << 12) | ((b & 7) << 18) | ((b7 & 63) << 6) | (b8 & 63);
                                                cArr[i6] = (char) ((i10 >>> 10) + 55232);
                                                cArr[i9] = (char) ((i10 & 1023) + 56320);
                                                i6 += 2;
                                            }
                                        }
                                        throw InvalidProtocolBufferException.invalidUtf8();
                                    }
                                    if (i3 < i5 - 1) {
                                        throw InvalidProtocolBufferException.invalidUtf8();
                                    }
                                    int i11 = i + 2;
                                    b3 = bArr[i3];
                                    i += 3;
                                    byte b9 = bArr[i11];
                                    int i12 = i6 + 1;
                                    if (!isNotTrailingByte(b3) || ((b == -32 && b3 < -96) || ((b == -19 && b3 >= -96) || isNotTrailingByte(b9)))) {
                                        throw InvalidProtocolBufferException.invalidUtf8();
                                    }
                                    cArr[i6] = (char) (((b3 & 63) << 6) | ((b & 15) << 12) | (b9 & 63));
                                    i6 = i12;
                                }
                            }
                            return new String(cArr, 0, i6);
                        }
                        i++;
                        cArr[i6] = (char) b5;
                        i6++;
                    }
                    while (i < i5) {
                        i3 = i + 1;
                        b = bArr[i];
                        if (b < 0) {
                            if (b < -32) {
                                if (i3 < i5) {
                                    throw InvalidProtocolBufferException.invalidUtf8();
                                }
                                i += 2;
                                byte b10 = bArr[i3];
                                int i13 = i6 + 1;
                                if (b >= -62) {
                                }
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                            if (b >= -16) {
                                if (i3 < i5 - 1) {
                                    throw InvalidProtocolBufferException.invalidUtf8();
                                }
                                int i14 = i + 2;
                                b3 = bArr[i3];
                                i += 3;
                                byte b11 = bArr[i14];
                                int i15 = i6 + 1;
                                if (isNotTrailingByte(b3)) {
                                }
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                            if (i3 < i5 - 2) {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                            b4 = bArr[i3];
                            int i16 = i + 3;
                            byte b12 = bArr[i + 2];
                            i += 4;
                            byte b13 = bArr[i16];
                            int i17 = i6 + 1;
                            if (!isNotTrailingByte(b4)) {
                                if ((((b4 + 112) + (b << 28)) >> 30) != 0) {
                                }
                            }
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        i4 = i6 + 1;
                        cArr[i6] = (char) b;
                        while (i3 < i5) {
                            b2 = bArr[i3];
                            if (b2 >= 0) {
                                i3++;
                                cArr[i4] = (char) b2;
                                i4++;
                            } else {
                                i6 = i4;
                                i = i3;
                            }
                        }
                        i6 = i4;
                        i = i3;
                    }
                    return new String(cArr, 0, i6);
                default:
                    Charset charset = StandardCharsets.UTF_8;
                    String str = new String(bArr, i, i2, charset);
                    if (str.indexOf(65533) >= 0 && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i, i2 + i))) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    return str;
            }
        }

        public final int encodeUtf8(String str, byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            char cCharAt;
            switch (this.$r8$classId) {
                case 0:
                    int length = str.length();
                    int i5 = i + i2;
                    int i6 = 0;
                    while (i6 < length && (i4 = i6 + i) < i5 && (cCharAt = str.charAt(i6)) < 128) {
                        bArr[i4] = (byte) cCharAt;
                        i6++;
                    }
                    if (i6 == length) {
                        return i + length;
                    }
                    int i7 = i + i6;
                    while (i6 < length) {
                        char cCharAt2 = str.charAt(i6);
                        if (cCharAt2 < 128 && i7 < i5) {
                            bArr[i7] = (byte) cCharAt2;
                            i7++;
                        } else if (cCharAt2 < 2048 && i7 <= i5 - 2) {
                            int i8 = i7 + 1;
                            bArr[i7] = (byte) ((cCharAt2 >>> 6) | 960);
                            i7 += 2;
                            bArr[i8] = (byte) ((cCharAt2 & '?') | 128);
                        } else {
                            if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i7 > i5 - 3) {
                                if (i7 > i5 - 4) {
                                    if (55296 > cCharAt2 || cCharAt2 > 57343 || ((i3 = i6 + 1) != str.length() && Character.isSurrogatePair(cCharAt2, str.charAt(i3)))) {
                                        throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
                                    }
                                    return encodeUtf8Naive(str, bArr, i, i2);
                                }
                                i6++;
                                if (i6 != str.length()) {
                                    char cCharAt3 = str.charAt(i6);
                                    if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                        int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                        bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                                        bArr[i7 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                        int i9 = i7 + 3;
                                        bArr[i7 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                        i7 += 4;
                                        bArr[i9] = (byte) ((codePoint & 63) | 128);
                                    }
                                }
                                return encodeUtf8Naive(str, bArr, i, i2);
                            }
                            bArr[i7] = (byte) ((cCharAt2 >>> '\f') | 480);
                            int i10 = i7 + 2;
                            bArr[i7 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                            i7 += 3;
                            bArr[i10] = (byte) ((cCharAt2 & '?') | 128);
                        }
                        i6++;
                    }
                    return i7;
                default:
                    return encodeUtf8Naive(str, bArr, i, i2);
            }
        }

        public int encodedLength(String str) {
            int length = str.length();
            int i = 0;
            while (i < length && str.charAt(i) < 128) {
                i++;
            }
            int iEncodedLengthGeneral = length;
            while (i < length) {
                char cCharAt = str.charAt(i);
                if (cCharAt >= 2048) {
                    try {
                        iEncodedLengthGeneral += Utf8.encodedLengthGeneral(i, str);
                        break;
                    } catch (UnpairedSurrogateException unused) {
                        return str.getBytes(StandardCharsets.UTF_8).length;
                    }
                }
                iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
                i++;
            }
            if (iEncodedLengthGeneral >= length) {
                return iEncodedLengthGeneral;
            }
            throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iEncodedLengthGeneral) + 4294967296L));
        }

        public static int decodeVarint32(byte[] bArr, int i, ArrayDecoders$Registers arrayDecoders$Registers) {
            int i2 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                arrayDecoders$Registers.int1 = b;
                return i2;
            }
            return decodeVarint32(b, bArr, i2, arrayDecoders$Registers);
        }
    }
}
