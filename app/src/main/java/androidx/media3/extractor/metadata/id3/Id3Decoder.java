package androidx.media3.extractor.metadata.id3;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticLambda0;
import androidx.media3.extractor.VorbisBitArray;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.sqlite.SQLite;
import coil3.util.LifecyclesKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Id3Decoder extends SQLite {
    public static final FrameworkMediaDrm$$ExternalSyntheticLambda0 NO_FRAMES_PREDICATE = new FrameworkMediaDrm$$ExternalSyntheticLambda0((byte) 18);
    public final FrameworkMediaDrm$$ExternalSyntheticLambda0 framePredicate;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Id3Header {
        public final int framesSize;
        public final boolean isUnsynchronized;
        public final short majorVersion;

        /* JADX WARN: Multi-variable type inference failed */
        public Id3Header(int i, boolean z, int i2) {
            this.majorVersion = i;
            this.isUnsynchronized = z;
            this.framesSize = i2;
        }
    }

    public Id3Decoder(FrameworkMediaDrm$$ExternalSyntheticLambda0 frameworkMediaDrm$$ExternalSyntheticLambda0) {
        this.framePredicate = frameworkMediaDrm$$ExternalSyntheticLambda0;
    }

    public static ApicFrame decodeApicFrame(ParsableByteArray parsableByteArray, int i, int i2) {
        int iIndexOfZeroByte;
        String strConcat;
        int unsignedByte = parsableByteArray.readUnsignedByte();
        Charset charset = getCharset(unsignedByte);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.readBytes(bArr, 0, i3);
        if (i2 == 2) {
            strConcat = "image/" + LifecyclesKt.toLowerCase(new String(bArr, 0, 3, StandardCharsets.ISO_8859_1));
            if ("image/jpg".equals(strConcat)) {
                strConcat = "image/jpeg";
            }
            iIndexOfZeroByte = 2;
        } else {
            iIndexOfZeroByte = indexOfZeroByte(bArr, 0);
            String lowerCase = LifecyclesKt.toLowerCase(new String(bArr, 0, iIndexOfZeroByte, StandardCharsets.ISO_8859_1));
            strConcat = lowerCase.indexOf(47) == -1 ? "image/".concat(lowerCase) : lowerCase;
        }
        int i4 = bArr[iIndexOfZeroByte + 1] & 255;
        int i5 = iIndexOfZeroByte + 2;
        int iIndexOfTerminator = indexOfTerminator(bArr, i5, unsignedByte);
        String str = new String(bArr, i5, iIndexOfTerminator - i5, charset);
        int iDelimiterLength = delimiterLength(unsignedByte) + iIndexOfTerminator;
        return new ApicFrame(strConcat, str, i4, i3 <= iDelimiterLength ? Util.EMPTY_BYTE_ARRAY : Arrays.copyOfRange(bArr, iDelimiterLength, i3));
    }

    public static ChapterFrame decodeChapterFrame(ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, FrameworkMediaDrm$$ExternalSyntheticLambda0 frameworkMediaDrm$$ExternalSyntheticLambda0) throws Throwable {
        int i4 = parsableByteArray.position;
        int iIndexOfZeroByte = indexOfZeroByte(parsableByteArray.data, i4);
        String str = new String(parsableByteArray.data, i4, iIndexOfZeroByte - i4, StandardCharsets.ISO_8859_1);
        parsableByteArray.setPosition(iIndexOfZeroByte + 1);
        int i5 = parsableByteArray.readInt();
        int i6 = parsableByteArray.readInt();
        long unsignedInt = parsableByteArray.readUnsignedInt();
        if (unsignedInt == 4294967295L) {
            unsignedInt = -1;
        }
        long unsignedInt2 = parsableByteArray.readUnsignedInt();
        long j = unsignedInt2 == 4294967295L ? -1L : unsignedInt2;
        ArrayList arrayList = new ArrayList();
        int i7 = i4 + i;
        while (parsableByteArray.position < i7) {
            Id3Frame id3FrameDecodeFrame = decodeFrame(i2, parsableByteArray, z, i3, frameworkMediaDrm$$ExternalSyntheticLambda0);
            if (id3FrameDecodeFrame != null) {
                arrayList.add(id3FrameDecodeFrame);
            }
        }
        return new ChapterFrame(str, i5, i6, unsignedInt, j, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    public static ChapterTocFrame decodeChapterTOCFrame(ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, FrameworkMediaDrm$$ExternalSyntheticLambda0 frameworkMediaDrm$$ExternalSyntheticLambda0) throws Throwable {
        int i4 = parsableByteArray.position;
        int iIndexOfZeroByte = indexOfZeroByte(parsableByteArray.data, i4);
        String str = new String(parsableByteArray.data, i4, iIndexOfZeroByte - i4, StandardCharsets.ISO_8859_1);
        parsableByteArray.setPosition(iIndexOfZeroByte + 1);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        boolean z2 = (unsignedByte & 2) != 0;
        boolean z3 = (unsignedByte & 1) != 0;
        int unsignedByte2 = parsableByteArray.readUnsignedByte();
        String[] strArr = new String[unsignedByte2];
        for (int i5 = 0; i5 < unsignedByte2; i5++) {
            int i6 = parsableByteArray.position;
            int iIndexOfZeroByte2 = indexOfZeroByte(parsableByteArray.data, i6);
            strArr[i5] = new String(parsableByteArray.data, i6, iIndexOfZeroByte2 - i6, StandardCharsets.ISO_8859_1);
            parsableByteArray.setPosition(iIndexOfZeroByte2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i7 = i4 + i;
        while (parsableByteArray.position < i7) {
            Id3Frame id3FrameDecodeFrame = decodeFrame(i2, parsableByteArray, z, i3, frameworkMediaDrm$$ExternalSyntheticLambda0);
            if (id3FrameDecodeFrame != null) {
                arrayList.add(id3FrameDecodeFrame);
            }
        }
        return new ChapterTocFrame(str, z2, z3, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    public static CommentFrame decodeCommentFrame(int i, ParsableByteArray parsableByteArray) {
        if (i < 4) {
            return null;
        }
        int unsignedByte = parsableByteArray.readUnsignedByte();
        Charset charset = getCharset(unsignedByte);
        byte[] bArr = new byte[3];
        parsableByteArray.readBytes(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        parsableByteArray.readBytes(bArr2, 0, i2);
        int iIndexOfTerminator = indexOfTerminator(bArr2, 0, unsignedByte);
        String str2 = new String(bArr2, 0, iIndexOfTerminator, charset);
        int iDelimiterLength = delimiterLength(unsignedByte) + iIndexOfTerminator;
        return new CommentFrame(str, str2, decodeStringIfValid(bArr2, iDelimiterLength, indexOfTerminator(bArr2, iDelimiterLength, unsignedByte), charset));
    }

    /* JADX WARN: Code duplicated, block: B:116:0x014d A[Catch: all -> 0x0142, Exception -> 0x0145, OutOfMemoryError -> 0x0149, TryCatch #0 {all -> 0x0142, blocks: (B:107:0x013b, B:116:0x014d, B:123:0x0162, B:125:0x0169, B:133:0x0182, B:142:0x0197, B:153:0x01af, B:160:0x01c0, B:182:0x0200, B:193:0x0219, B:194:0x021e), top: B:205:0x012d }] */
    /* JADX WARN: Code duplicated, block: B:117:0x0156  */
    /* JADX WARN: Code duplicated, block: B:124:0x0167 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:125:0x0169 A[Catch: all -> 0x0142, Exception -> 0x0145, OutOfMemoryError -> 0x0149, TryCatch #0 {all -> 0x0142, blocks: (B:107:0x013b, B:116:0x014d, B:123:0x0162, B:125:0x0169, B:133:0x0182, B:142:0x0197, B:153:0x01af, B:160:0x01c0, B:182:0x0200, B:193:0x0219, B:194:0x021e), top: B:205:0x012d }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0172  */
    /* JADX WARN: Code duplicated, block: B:128:0x0178  */
    /* JADX WARN: Code duplicated, block: B:134:0x0187  */
    /* JADX WARN: Code duplicated, block: B:136:0x018b  */
    /* JADX WARN: Code duplicated, block: B:143:0x019c  */
    /* JADX WARN: Code duplicated, block: B:145:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:146:0x01a2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:149:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:150:0x01a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:154:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:155:0x01b6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:163:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:176:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:178:0x01f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:187:0x0209  */
    /* JADX WARN: Code duplicated, block: B:189:0x0211  */
    /* JADX WARN: Code duplicated, block: B:194:0x021e A[Catch: all -> 0x0142, Exception -> 0x0205, OutOfMemoryError -> 0x0207, TRY_LEAVE, TryCatch #0 {all -> 0x0142, blocks: (B:107:0x013b, B:116:0x014d, B:123:0x0162, B:125:0x0169, B:133:0x0182, B:142:0x0197, B:153:0x01af, B:160:0x01c0, B:182:0x0200, B:193:0x0219, B:194:0x021e), top: B:205:0x012d }] */
    /* JADX WARN: Code duplicated, block: B:201:0x0240  */
    /* JADX WARN: Instruction removed from duplicated block: B:201:0x0240, please report this as an issue */
    public static Id3Frame decodeFrame(int i, ParsableByteArray parsableByteArray, boolean z, int i2, FrameworkMediaDrm$$ExternalSyntheticLambda0 frameworkMediaDrm$$ExternalSyntheticLambda0) throws Throwable {
        int unsignedIntToInt;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i3;
        Id3Frame id3Frame;
        Id3Frame binaryFrame;
        boolean z7;
        int i4 = i;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int unsignedByte = parsableByteArray2.readUnsignedByte();
        int unsignedByte2 = parsableByteArray2.readUnsignedByte();
        int unsignedByte3 = parsableByteArray2.readUnsignedByte();
        int unsignedByte4 = i4 >= 3 ? parsableByteArray2.readUnsignedByte() : 0;
        if (i4 == 4) {
            unsignedIntToInt = parsableByteArray2.readUnsignedIntToInt();
            if (!z) {
                unsignedIntToInt = (((unsignedIntToInt >> 24) & 255) << 21) | (unsignedIntToInt & 255) | (((unsignedIntToInt >> 8) & 255) << 7) | (((unsignedIntToInt >> 16) & 255) << 14);
            }
        } else {
            unsignedIntToInt = i4 == 3 ? parsableByteArray2.readUnsignedIntToInt() : parsableByteArray2.readUnsignedInt24();
        }
        int unsignedShort = i4 >= 3 ? parsableByteArray2.readUnsignedShort() : 0;
        if (unsignedByte == 0 && unsignedByte2 == 0 && unsignedByte3 == 0 && unsignedByte4 == 0 && unsignedIntToInt == 0 && unsignedShort == 0) {
            parsableByteArray2.setPosition(parsableByteArray2.limit);
            return null;
        }
        int i5 = parsableByteArray2.position + unsignedIntToInt;
        if (i5 > parsableByteArray2.limit) {
            Log.w("Id3Decoder", "Frame size exceeds remaining tag data");
            parsableByteArray2.setPosition(parsableByteArray2.limit);
            return null;
        }
        if (frameworkMediaDrm$$ExternalSyntheticLambda0 != null) {
            switch (frameworkMediaDrm$$ExternalSyntheticLambda0.$r8$classId) {
                default:
                    if ((unsignedByte == 67 && unsignedByte2 == 79 && unsignedByte3 == 77 && (unsignedByte4 == 77 || i4 == 2)) || (unsignedByte == 77 && unsignedByte2 == 76 && unsignedByte3 == 76 && (unsignedByte4 == 84 || i4 == 2))) {
                        z7 = true;
                        break;
                    }
                case 18:
                    z7 = false;
                    break;
            }
            if (!z7) {
                parsableByteArray2.setPosition(i5);
                return null;
            }
        }
        if (i4 == 3) {
            z3 = (unsignedShort & 128) != 0;
            boolean z8 = (unsignedShort & 64) != 0;
            z2 = (unsignedShort & 32) != 0;
            z5 = z8;
            z6 = false;
            z4 = z3;
        } else if (i4 == 4) {
            boolean z9 = (unsignedShort & 64) != 0;
            boolean z10 = (unsignedShort & 8) != 0;
            z5 = (unsignedShort & 4) != 0;
            z6 = (unsignedShort & 2) != 0;
            boolean z11 = z10;
            z4 = (unsignedShort & 1) != 0;
            z2 = z9;
            z3 = z11;
        } else {
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
        }
        if (z3 || z5) {
            Log.w("Id3Decoder", "Skipping unsupported compressed or encrypted frame");
            parsableByteArray2.setPosition(i5);
            return null;
        }
        if (z2) {
            unsignedIntToInt--;
            parsableByteArray2.skipBytes(1);
        }
        if (z4) {
            unsignedIntToInt -= 4;
            parsableByteArray2.skipBytes(4);
        }
        if (z6) {
            unsignedIntToInt = removeUnsynchronization(unsignedIntToInt, parsableByteArray2);
        }
        int i6 = 84;
        try {
            try {
                if (unsignedByte != 84) {
                    if (unsignedByte == i6) {
                        binaryFrame = decodeTextInformationFrame(unsignedIntToInt, parsableByteArray2, getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                    } else if (unsignedByte != 87 && unsignedByte2 == 88 && unsignedByte3 == 88 && (i4 == 2 || unsignedByte4 == 88)) {
                        binaryFrame = decodeWxxxFrame(unsignedIntToInt, parsableByteArray2);
                    } else if (unsignedByte == 87) {
                        binaryFrame = decodeUrlLinkFrame(unsignedIntToInt, parsableByteArray2, getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                    } else if (unsignedByte != 80 && unsignedByte2 == 82 && unsignedByte3 == 73 && unsignedByte4 == 86) {
                        binaryFrame = decodePrivFrame(unsignedIntToInt, parsableByteArray2);
                    } else if (unsignedByte != 71 && unsignedByte2 == 69 && unsignedByte3 == 79 && (unsignedByte4 == 66 || i4 == 2)) {
                        binaryFrame = decodeGeobFrame(unsignedIntToInt, parsableByteArray2);
                    } else if (i4 == 2) {
                        if (unsignedByte != 80 && unsignedByte2 == 73 && unsignedByte3 == 67) {
                            binaryFrame = decodeApicFrame(parsableByteArray2, unsignedIntToInt, i4);
                        } else if (unsignedByte != 67 && unsignedByte2 == 79 && unsignedByte3 == 77 && (unsignedByte4 == 77 || i4 == 2)) {
                            binaryFrame = decodeCommentFrame(unsignedIntToInt, parsableByteArray2);
                        } else if (unsignedByte != 67 && unsignedByte2 == 72 && unsignedByte3 == 65 && unsignedByte4 == 80) {
                            i3 = unsignedIntToInt;
                            try {
                                binaryFrame = decodeChapterFrame(parsableByteArray2, i3, i4, z, i2, frameworkMediaDrm$$ExternalSyntheticLambda0);
                                i4 = i;
                                parsableByteArray2 = parsableByteArray;
                            } catch (Exception e) {
                                e = e;
                                i4 = i;
                                parsableByteArray2 = parsableByteArray;
                                parsableByteArray2.setPosition(i5);
                                id3Frame = null;
                            } catch (OutOfMemoryError e2) {
                                e = e2;
                                i4 = i;
                                parsableByteArray2 = parsableByteArray;
                                parsableByteArray2.setPosition(i5);
                                id3Frame = null;
                            } catch (Throwable th) {
                                th = th;
                                parsableByteArray2 = parsableByteArray;
                                parsableByteArray2.setPosition(i5);
                                throw th;
                            }
                        } else {
                            i3 = unsignedIntToInt;
                            try {
                                if (unsignedByte != 67 && unsignedByte2 == 84 && unsignedByte3 == 79 && unsignedByte4 == 67) {
                                    i4 = i;
                                    parsableByteArray2 = parsableByteArray;
                                    binaryFrame = decodeChapterTOCFrame(parsableByteArray2, i3, i4, z, i2, frameworkMediaDrm$$ExternalSyntheticLambda0);
                                } else {
                                    i4 = i;
                                    parsableByteArray2 = parsableByteArray;
                                    if (unsignedByte != 77 && unsignedByte2 == 76 && unsignedByte3 == 76 && unsignedByte4 == 84) {
                                        binaryFrame = decodeMlltFrame(i3, parsableByteArray2);
                                    } else {
                                        String frameId = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                        byte[] bArr = new byte[i3];
                                        parsableByteArray2.readBytes(bArr, 0, i3);
                                        binaryFrame = new BinaryFrame(frameId, bArr);
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                parsableByteArray2.setPosition(i5);
                                id3Frame = null;
                            } catch (OutOfMemoryError e4) {
                                e = e4;
                                parsableByteArray2.setPosition(i5);
                                id3Frame = null;
                            }
                        }
                        parsableByteArray2.setPosition(i5);
                        id3Frame = binaryFrame;
                        e = null;
                    } else if (unsignedByte != 65 && unsignedByte2 == 80 && unsignedByte3 == 73 && unsignedByte4 == 67) {
                        binaryFrame = decodeApicFrame(parsableByteArray2, unsignedIntToInt, i4);
                    } else {
                        if (unsignedByte != 67) {
                        }
                        if (unsignedByte != 67) {
                            i3 = unsignedIntToInt;
                            if (unsignedByte != 67) {
                                i4 = i;
                                parsableByteArray2 = parsableByteArray;
                                if (unsignedByte != 77) {
                                    String frameId2 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                    byte[] bArr2 = new byte[i3];
                                    parsableByteArray2.readBytes(bArr2, 0, i3);
                                    binaryFrame = new BinaryFrame(frameId2, bArr2);
                                } else {
                                    String frameId3 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                    byte[] bArr3 = new byte[i3];
                                    parsableByteArray2.readBytes(bArr3, 0, i3);
                                    binaryFrame = new BinaryFrame(frameId3, bArr3);
                                }
                            } else {
                                i4 = i;
                                parsableByteArray2 = parsableByteArray;
                                if (unsignedByte != 77) {
                                    String frameId4 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                    byte[] bArr4 = new byte[i3];
                                    parsableByteArray2.readBytes(bArr4, 0, i3);
                                    binaryFrame = new BinaryFrame(frameId4, bArr4);
                                } else {
                                    String frameId5 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                    byte[] bArr5 = new byte[i3];
                                    parsableByteArray2.readBytes(bArr5, 0, i3);
                                    binaryFrame = new BinaryFrame(frameId5, bArr5);
                                }
                            }
                            parsableByteArray2.setPosition(i5);
                            id3Frame = binaryFrame;
                            e = null;
                        } else {
                            i3 = unsignedIntToInt;
                            if (unsignedByte != 67) {
                                i4 = i;
                                parsableByteArray2 = parsableByteArray;
                                if (unsignedByte != 77) {
                                    String frameId6 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                    byte[] bArr6 = new byte[i3];
                                    parsableByteArray2.readBytes(bArr6, 0, i3);
                                    binaryFrame = new BinaryFrame(frameId6, bArr6);
                                } else {
                                    String frameId7 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                    byte[] bArr7 = new byte[i3];
                                    parsableByteArray2.readBytes(bArr7, 0, i3);
                                    binaryFrame = new BinaryFrame(frameId7, bArr7);
                                }
                            } else {
                                i4 = i;
                                parsableByteArray2 = parsableByteArray;
                                if (unsignedByte != 77) {
                                    String frameId8 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                    byte[] bArr8 = new byte[i3];
                                    parsableByteArray2.readBytes(bArr8, 0, i3);
                                    binaryFrame = new BinaryFrame(frameId8, bArr8);
                                } else {
                                    String frameId9 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                    byte[] bArr9 = new byte[i3];
                                    parsableByteArray2.readBytes(bArr9, 0, i3);
                                    binaryFrame = new BinaryFrame(frameId9, bArr9);
                                }
                            }
                            parsableByteArray2.setPosition(i5);
                            id3Frame = binaryFrame;
                            e = null;
                        }
                    }
                    i3 = unsignedIntToInt;
                    parsableByteArray2.setPosition(i5);
                    id3Frame = binaryFrame;
                    e = null;
                } else {
                    if (unsignedByte2 == 88 && unsignedByte3 == 88 && (i4 == 2 || unsignedByte4 == 88)) {
                        binaryFrame = decodeTxxxFrame(unsignedIntToInt, parsableByteArray2);
                    } else {
                        i6 = 84;
                        if (unsignedByte == i6) {
                            binaryFrame = decodeTextInformationFrame(unsignedIntToInt, parsableByteArray2, getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                        } else if (unsignedByte != 87) {
                            if (unsignedByte == 87) {
                                binaryFrame = decodeUrlLinkFrame(unsignedIntToInt, parsableByteArray2, getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                            } else if (unsignedByte != 80) {
                                if (unsignedByte != 71) {
                                    if (i4 == 2) {
                                        if (unsignedByte != 80) {
                                        }
                                        if (unsignedByte != 67) {
                                        }
                                        if (unsignedByte != 67) {
                                            i3 = unsignedIntToInt;
                                            if (unsignedByte != 67) {
                                                i4 = i;
                                                parsableByteArray2 = parsableByteArray;
                                                if (unsignedByte != 77) {
                                                    String frameId10 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                    byte[] bArr10 = new byte[i3];
                                                    parsableByteArray2.readBytes(bArr10, 0, i3);
                                                    binaryFrame = new BinaryFrame(frameId10, bArr10);
                                                } else {
                                                    String frameId11 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                    byte[] bArr11 = new byte[i3];
                                                    parsableByteArray2.readBytes(bArr11, 0, i3);
                                                    binaryFrame = new BinaryFrame(frameId11, bArr11);
                                                }
                                            } else {
                                                i4 = i;
                                                parsableByteArray2 = parsableByteArray;
                                                if (unsignedByte != 77) {
                                                    String frameId12 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                    byte[] bArr12 = new byte[i3];
                                                    parsableByteArray2.readBytes(bArr12, 0, i3);
                                                    binaryFrame = new BinaryFrame(frameId12, bArr12);
                                                } else {
                                                    String frameId13 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                    byte[] bArr13 = new byte[i3];
                                                    parsableByteArray2.readBytes(bArr13, 0, i3);
                                                    binaryFrame = new BinaryFrame(frameId13, bArr13);
                                                }
                                            }
                                            parsableByteArray2.setPosition(i5);
                                            id3Frame = binaryFrame;
                                            e = null;
                                        } else {
                                            i3 = unsignedIntToInt;
                                            if (unsignedByte != 67) {
                                                i4 = i;
                                                parsableByteArray2 = parsableByteArray;
                                                if (unsignedByte != 77) {
                                                    String frameId14 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                    byte[] bArr14 = new byte[i3];
                                                    parsableByteArray2.readBytes(bArr14, 0, i3);
                                                    binaryFrame = new BinaryFrame(frameId14, bArr14);
                                                } else {
                                                    String frameId15 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                    byte[] bArr15 = new byte[i3];
                                                    parsableByteArray2.readBytes(bArr15, 0, i3);
                                                    binaryFrame = new BinaryFrame(frameId15, bArr15);
                                                }
                                            } else {
                                                i4 = i;
                                                parsableByteArray2 = parsableByteArray;
                                                if (unsignedByte != 77) {
                                                    String frameId16 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                    byte[] bArr16 = new byte[i3];
                                                    parsableByteArray2.readBytes(bArr16, 0, i3);
                                                    binaryFrame = new BinaryFrame(frameId16, bArr16);
                                                } else {
                                                    String frameId17 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                    byte[] bArr17 = new byte[i3];
                                                    parsableByteArray2.readBytes(bArr17, 0, i3);
                                                    binaryFrame = new BinaryFrame(frameId17, bArr17);
                                                }
                                            }
                                            parsableByteArray2.setPosition(i5);
                                            id3Frame = binaryFrame;
                                            e = null;
                                        }
                                    } else {
                                        if (unsignedByte != 65) {
                                        }
                                        if (unsignedByte != 67) {
                                        }
                                        if (unsignedByte != 67) {
                                            i3 = unsignedIntToInt;
                                            if (unsignedByte != 67) {
                                                i4 = i;
                                                parsableByteArray2 = parsableByteArray;
                                                if (unsignedByte != 77) {
                                                    String frameId18 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                    byte[] bArr18 = new byte[i3];
                                                    parsableByteArray2.readBytes(bArr18, 0, i3);
                                                    binaryFrame = new BinaryFrame(frameId18, bArr18);
                                                } else {
                                                    String frameId19 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                    byte[] bArr19 = new byte[i3];
                                                    parsableByteArray2.readBytes(bArr19, 0, i3);
                                                    binaryFrame = new BinaryFrame(frameId19, bArr19);
                                                }
                                            } else {
                                                i4 = i;
                                                parsableByteArray2 = parsableByteArray;
                                                if (unsignedByte != 77) {
                                                    String frameId110 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                    byte[] bArr110 = new byte[i3];
                                                    parsableByteArray2.readBytes(bArr110, 0, i3);
                                                    binaryFrame = new BinaryFrame(frameId110, bArr110);
                                                } else {
                                                    String frameId111 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                    byte[] bArr111 = new byte[i3];
                                                    parsableByteArray2.readBytes(bArr111, 0, i3);
                                                    binaryFrame = new BinaryFrame(frameId111, bArr111);
                                                }
                                            }
                                            parsableByteArray2.setPosition(i5);
                                            id3Frame = binaryFrame;
                                            e = null;
                                        } else {
                                            i3 = unsignedIntToInt;
                                            if (unsignedByte != 67) {
                                                i4 = i;
                                                parsableByteArray2 = parsableByteArray;
                                                if (unsignedByte != 77) {
                                                    String frameId112 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                    byte[] bArr112 = new byte[i3];
                                                    parsableByteArray2.readBytes(bArr112, 0, i3);
                                                    binaryFrame = new BinaryFrame(frameId112, bArr112);
                                                } else {
                                                    String frameId113 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                    byte[] bArr113 = new byte[i3];
                                                    parsableByteArray2.readBytes(bArr113, 0, i3);
                                                    binaryFrame = new BinaryFrame(frameId113, bArr113);
                                                }
                                            } else {
                                                i4 = i;
                                                parsableByteArray2 = parsableByteArray;
                                                if (unsignedByte != 77) {
                                                    String frameId114 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                    byte[] bArr114 = new byte[i3];
                                                    parsableByteArray2.readBytes(bArr114, 0, i3);
                                                    binaryFrame = new BinaryFrame(frameId114, bArr114);
                                                } else {
                                                    String frameId115 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                    byte[] bArr115 = new byte[i3];
                                                    parsableByteArray2.readBytes(bArr115, 0, i3);
                                                    binaryFrame = new BinaryFrame(frameId115, bArr115);
                                                }
                                            }
                                            parsableByteArray2.setPosition(i5);
                                            id3Frame = binaryFrame;
                                            e = null;
                                        }
                                    }
                                } else if (i4 == 2) {
                                    if (unsignedByte != 80) {
                                    }
                                    if (unsignedByte != 67) {
                                    }
                                    if (unsignedByte != 67) {
                                        i3 = unsignedIntToInt;
                                        if (unsignedByte != 67) {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId116 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr116 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr116, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId116, bArr116);
                                            } else {
                                                String frameId117 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr117 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr117, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId117, bArr117);
                                            }
                                        } else {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId118 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr118 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr118, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId118, bArr118);
                                            } else {
                                                String frameId119 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr119 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr119, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId119, bArr119);
                                            }
                                        }
                                        parsableByteArray2.setPosition(i5);
                                        id3Frame = binaryFrame;
                                        e = null;
                                    } else {
                                        i3 = unsignedIntToInt;
                                        if (unsignedByte != 67) {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId1110 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr1110 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr1110, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId1110, bArr1110);
                                            } else {
                                                String frameId1111 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr1111 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr1111, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId1111, bArr1111);
                                            }
                                        } else {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId1112 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr1112 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr1112, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId1112, bArr1112);
                                            } else {
                                                String frameId1113 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr1113 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr1113, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId1113, bArr1113);
                                            }
                                        }
                                        parsableByteArray2.setPosition(i5);
                                        id3Frame = binaryFrame;
                                        e = null;
                                    }
                                } else {
                                    if (unsignedByte != 65) {
                                    }
                                    if (unsignedByte != 67) {
                                    }
                                    if (unsignedByte != 67) {
                                        i3 = unsignedIntToInt;
                                        if (unsignedByte != 67) {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId1114 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr1114 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr1114, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId1114, bArr1114);
                                            } else {
                                                String frameId1115 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr1115 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr1115, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId1115, bArr1115);
                                            }
                                        } else {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId1116 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr1116 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr1116, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId1116, bArr1116);
                                            } else {
                                                String frameId1117 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr1117 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr1117, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId1117, bArr1117);
                                            }
                                        }
                                        parsableByteArray2.setPosition(i5);
                                        id3Frame = binaryFrame;
                                        e = null;
                                    } else {
                                        i3 = unsignedIntToInt;
                                        if (unsignedByte != 67) {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId1118 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr1118 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr1118, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId1118, bArr1118);
                                            } else {
                                                String frameId1119 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr1119 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr1119, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId1119, bArr1119);
                                            }
                                        } else {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId11110 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr11110 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr11110, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId11110, bArr11110);
                                            } else {
                                                String frameId11111 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr11111 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr11111, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId11111, bArr11111);
                                            }
                                        }
                                        parsableByteArray2.setPosition(i5);
                                        id3Frame = binaryFrame;
                                        e = null;
                                    }
                                }
                            } else if (unsignedByte != 71) {
                                if (i4 == 2) {
                                    if (unsignedByte != 80) {
                                    }
                                    if (unsignedByte != 67) {
                                    }
                                    if (unsignedByte != 67) {
                                        i3 = unsignedIntToInt;
                                        if (unsignedByte != 67) {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId11112 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr11112 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr11112, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId11112, bArr11112);
                                            } else {
                                                String frameId11113 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr11113 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr11113, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId11113, bArr11113);
                                            }
                                        } else {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId11114 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr11114 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr11114, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId11114, bArr11114);
                                            } else {
                                                String frameId11115 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr11115 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr11115, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId11115, bArr11115);
                                            }
                                        }
                                        parsableByteArray2.setPosition(i5);
                                        id3Frame = binaryFrame;
                                        e = null;
                                    } else {
                                        i3 = unsignedIntToInt;
                                        if (unsignedByte != 67) {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId11116 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr11116 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr11116, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId11116, bArr11116);
                                            } else {
                                                String frameId11117 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr11117 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr11117, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId11117, bArr11117);
                                            }
                                        } else {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId11118 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr11118 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr11118, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId11118, bArr11118);
                                            } else {
                                                String frameId11119 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr11119 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr11119, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId11119, bArr11119);
                                            }
                                        }
                                        parsableByteArray2.setPosition(i5);
                                        id3Frame = binaryFrame;
                                        e = null;
                                    }
                                } else {
                                    if (unsignedByte != 65) {
                                    }
                                    if (unsignedByte != 67) {
                                    }
                                    if (unsignedByte != 67) {
                                        i3 = unsignedIntToInt;
                                        if (unsignedByte != 67) {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId111110 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr111110 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr111110, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId111110, bArr111110);
                                            } else {
                                                String frameId111111 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr111111 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr111111, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId111111, bArr111111);
                                            }
                                        } else {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId111112 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr111112 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr111112, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId111112, bArr111112);
                                            } else {
                                                String frameId111113 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr111113 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr111113, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId111113, bArr111113);
                                            }
                                        }
                                        parsableByteArray2.setPosition(i5);
                                        id3Frame = binaryFrame;
                                        e = null;
                                    } else {
                                        i3 = unsignedIntToInt;
                                        if (unsignedByte != 67) {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId111114 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr111114 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr111114, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId111114, bArr111114);
                                            } else {
                                                String frameId111115 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr111115 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr111115, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId111115, bArr111115);
                                            }
                                        } else {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId111116 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr111116 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr111116, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId111116, bArr111116);
                                            } else {
                                                String frameId111117 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr111117 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr111117, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId111117, bArr111117);
                                            }
                                        }
                                        parsableByteArray2.setPosition(i5);
                                        id3Frame = binaryFrame;
                                        e = null;
                                    }
                                }
                            } else if (i4 == 2) {
                                if (unsignedByte != 80) {
                                }
                                if (unsignedByte != 67) {
                                }
                                if (unsignedByte != 67) {
                                    i3 = unsignedIntToInt;
                                    if (unsignedByte != 67) {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId111118 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr111118 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr111118, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId111118, bArr111118);
                                        } else {
                                            String frameId111119 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr111119 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr111119, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId111119, bArr111119);
                                        }
                                    } else {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId1111110 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111110 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111110, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111110, bArr1111110);
                                        } else {
                                            String frameId1111111 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111111 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111111, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111111, bArr1111111);
                                        }
                                    }
                                    parsableByteArray2.setPosition(i5);
                                    id3Frame = binaryFrame;
                                    e = null;
                                } else {
                                    i3 = unsignedIntToInt;
                                    if (unsignedByte != 67) {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId1111112 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111112 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111112, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111112, bArr1111112);
                                        } else {
                                            String frameId1111113 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111113 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111113, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111113, bArr1111113);
                                        }
                                    } else {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId1111114 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111114 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111114, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111114, bArr1111114);
                                        } else {
                                            String frameId1111115 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111115 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111115, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111115, bArr1111115);
                                        }
                                    }
                                    parsableByteArray2.setPosition(i5);
                                    id3Frame = binaryFrame;
                                    e = null;
                                }
                            } else {
                                if (unsignedByte != 65) {
                                }
                                if (unsignedByte != 67) {
                                }
                                if (unsignedByte != 67) {
                                    i3 = unsignedIntToInt;
                                    if (unsignedByte != 67) {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId1111116 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111116 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111116, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111116, bArr1111116);
                                        } else {
                                            String frameId1111117 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111117 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111117, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111117, bArr1111117);
                                        }
                                    } else {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId1111118 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111118 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111118, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111118, bArr1111118);
                                        } else {
                                            String frameId1111119 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111119 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111119, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111119, bArr1111119);
                                        }
                                    }
                                    parsableByteArray2.setPosition(i5);
                                    id3Frame = binaryFrame;
                                    e = null;
                                } else {
                                    i3 = unsignedIntToInt;
                                    if (unsignedByte != 67) {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId11111110 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr11111110 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr11111110, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId11111110, bArr11111110);
                                        } else {
                                            String frameId11111111 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr11111111 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr11111111, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId11111111, bArr11111111);
                                        }
                                    } else {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId11111112 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr11111112 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr11111112, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId11111112, bArr11111112);
                                        } else {
                                            String frameId11111113 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr11111113 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr11111113, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId11111113, bArr11111113);
                                        }
                                    }
                                    parsableByteArray2.setPosition(i5);
                                    id3Frame = binaryFrame;
                                    e = null;
                                }
                            }
                        } else if (unsignedByte == 87) {
                            binaryFrame = decodeUrlLinkFrame(unsignedIntToInt, parsableByteArray2, getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                        } else if (unsignedByte != 80) {
                            if (unsignedByte != 71) {
                                if (i4 == 2) {
                                    if (unsignedByte != 80) {
                                    }
                                    if (unsignedByte != 67) {
                                    }
                                    if (unsignedByte != 67) {
                                        i3 = unsignedIntToInt;
                                        if (unsignedByte != 67) {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId11111114 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr11111114 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr11111114, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId11111114, bArr11111114);
                                            } else {
                                                String frameId11111115 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr11111115 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr11111115, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId11111115, bArr11111115);
                                            }
                                        } else {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId11111116 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr11111116 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr11111116, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId11111116, bArr11111116);
                                            } else {
                                                String frameId11111117 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr11111117 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr11111117, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId11111117, bArr11111117);
                                            }
                                        }
                                        parsableByteArray2.setPosition(i5);
                                        id3Frame = binaryFrame;
                                        e = null;
                                    } else {
                                        i3 = unsignedIntToInt;
                                        if (unsignedByte != 67) {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId11111118 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr11111118 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr11111118, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId11111118, bArr11111118);
                                            } else {
                                                String frameId11111119 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr11111119 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr11111119, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId11111119, bArr11111119);
                                            }
                                        } else {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId111111110 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr111111110 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr111111110, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId111111110, bArr111111110);
                                            } else {
                                                String frameId111111111 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr111111111 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr111111111, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId111111111, bArr111111111);
                                            }
                                        }
                                        parsableByteArray2.setPosition(i5);
                                        id3Frame = binaryFrame;
                                        e = null;
                                    }
                                } else {
                                    if (unsignedByte != 65) {
                                    }
                                    if (unsignedByte != 67) {
                                    }
                                    if (unsignedByte != 67) {
                                        i3 = unsignedIntToInt;
                                        if (unsignedByte != 67) {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId111111112 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr111111112 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr111111112, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId111111112, bArr111111112);
                                            } else {
                                                String frameId111111113 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr111111113 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr111111113, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId111111113, bArr111111113);
                                            }
                                        } else {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId111111114 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr111111114 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr111111114, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId111111114, bArr111111114);
                                            } else {
                                                String frameId111111115 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr111111115 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr111111115, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId111111115, bArr111111115);
                                            }
                                        }
                                        parsableByteArray2.setPosition(i5);
                                        id3Frame = binaryFrame;
                                        e = null;
                                    } else {
                                        i3 = unsignedIntToInt;
                                        if (unsignedByte != 67) {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId111111116 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr111111116 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr111111116, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId111111116, bArr111111116);
                                            } else {
                                                String frameId111111117 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr111111117 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr111111117, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId111111117, bArr111111117);
                                            }
                                        } else {
                                            i4 = i;
                                            parsableByteArray2 = parsableByteArray;
                                            if (unsignedByte != 77) {
                                                String frameId111111118 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr111111118 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr111111118, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId111111118, bArr111111118);
                                            } else {
                                                String frameId111111119 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                                byte[] bArr111111119 = new byte[i3];
                                                parsableByteArray2.readBytes(bArr111111119, 0, i3);
                                                binaryFrame = new BinaryFrame(frameId111111119, bArr111111119);
                                            }
                                        }
                                        parsableByteArray2.setPosition(i5);
                                        id3Frame = binaryFrame;
                                        e = null;
                                    }
                                }
                            } else if (i4 == 2) {
                                if (unsignedByte != 80) {
                                }
                                if (unsignedByte != 67) {
                                }
                                if (unsignedByte != 67) {
                                    i3 = unsignedIntToInt;
                                    if (unsignedByte != 67) {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId1111111110 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111111110 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111111110, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111111110, bArr1111111110);
                                        } else {
                                            String frameId1111111111 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111111111 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111111111, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111111111, bArr1111111111);
                                        }
                                    } else {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId1111111112 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111111112 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111111112, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111111112, bArr1111111112);
                                        } else {
                                            String frameId1111111113 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111111113 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111111113, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111111113, bArr1111111113);
                                        }
                                    }
                                    parsableByteArray2.setPosition(i5);
                                    id3Frame = binaryFrame;
                                    e = null;
                                } else {
                                    i3 = unsignedIntToInt;
                                    if (unsignedByte != 67) {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId1111111114 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111111114 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111111114, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111111114, bArr1111111114);
                                        } else {
                                            String frameId1111111115 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111111115 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111111115, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111111115, bArr1111111115);
                                        }
                                    } else {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId1111111116 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111111116 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111111116, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111111116, bArr1111111116);
                                        } else {
                                            String frameId1111111117 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111111117 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111111117, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111111117, bArr1111111117);
                                        }
                                    }
                                    parsableByteArray2.setPosition(i5);
                                    id3Frame = binaryFrame;
                                    e = null;
                                }
                            } else {
                                if (unsignedByte != 65) {
                                }
                                if (unsignedByte != 67) {
                                }
                                if (unsignedByte != 67) {
                                    i3 = unsignedIntToInt;
                                    if (unsignedByte != 67) {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId1111111118 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111111118 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111111118, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111111118, bArr1111111118);
                                        } else {
                                            String frameId1111111119 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111111119 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111111119, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111111119, bArr1111111119);
                                        }
                                    } else {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId11111111110 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr11111111110 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr11111111110, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId11111111110, bArr11111111110);
                                        } else {
                                            String frameId11111111111 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr11111111111 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr11111111111, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId11111111111, bArr11111111111);
                                        }
                                    }
                                    parsableByteArray2.setPosition(i5);
                                    id3Frame = binaryFrame;
                                    e = null;
                                } else {
                                    i3 = unsignedIntToInt;
                                    if (unsignedByte != 67) {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId11111111112 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr11111111112 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr11111111112, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId11111111112, bArr11111111112);
                                        } else {
                                            String frameId11111111113 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr11111111113 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr11111111113, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId11111111113, bArr11111111113);
                                        }
                                    } else {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId11111111114 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr11111111114 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr11111111114, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId11111111114, bArr11111111114);
                                        } else {
                                            String frameId11111111115 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr11111111115 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr11111111115, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId11111111115, bArr11111111115);
                                        }
                                    }
                                    parsableByteArray2.setPosition(i5);
                                    id3Frame = binaryFrame;
                                    e = null;
                                }
                            }
                        } else if (unsignedByte != 71) {
                            if (i4 == 2) {
                                if (unsignedByte != 80) {
                                }
                                if (unsignedByte != 67) {
                                }
                                if (unsignedByte != 67) {
                                    i3 = unsignedIntToInt;
                                    if (unsignedByte != 67) {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId11111111116 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr11111111116 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr11111111116, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId11111111116, bArr11111111116);
                                        } else {
                                            String frameId11111111117 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr11111111117 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr11111111117, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId11111111117, bArr11111111117);
                                        }
                                    } else {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId11111111118 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr11111111118 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr11111111118, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId11111111118, bArr11111111118);
                                        } else {
                                            String frameId11111111119 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr11111111119 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr11111111119, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId11111111119, bArr11111111119);
                                        }
                                    }
                                    parsableByteArray2.setPosition(i5);
                                    id3Frame = binaryFrame;
                                    e = null;
                                } else {
                                    i3 = unsignedIntToInt;
                                    if (unsignedByte != 67) {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId111111111110 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr111111111110 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr111111111110, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId111111111110, bArr111111111110);
                                        } else {
                                            String frameId111111111111 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr111111111111 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr111111111111, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId111111111111, bArr111111111111);
                                        }
                                    } else {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId111111111112 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr111111111112 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr111111111112, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId111111111112, bArr111111111112);
                                        } else {
                                            String frameId111111111113 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr111111111113 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr111111111113, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId111111111113, bArr111111111113);
                                        }
                                    }
                                    parsableByteArray2.setPosition(i5);
                                    id3Frame = binaryFrame;
                                    e = null;
                                }
                            } else {
                                if (unsignedByte != 65) {
                                }
                                if (unsignedByte != 67) {
                                }
                                if (unsignedByte != 67) {
                                    i3 = unsignedIntToInt;
                                    if (unsignedByte != 67) {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId111111111114 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr111111111114 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr111111111114, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId111111111114, bArr111111111114);
                                        } else {
                                            String frameId111111111115 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr111111111115 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr111111111115, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId111111111115, bArr111111111115);
                                        }
                                    } else {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId111111111116 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr111111111116 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr111111111116, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId111111111116, bArr111111111116);
                                        } else {
                                            String frameId111111111117 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr111111111117 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr111111111117, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId111111111117, bArr111111111117);
                                        }
                                    }
                                    parsableByteArray2.setPosition(i5);
                                    id3Frame = binaryFrame;
                                    e = null;
                                } else {
                                    i3 = unsignedIntToInt;
                                    if (unsignedByte != 67) {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId111111111118 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr111111111118 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr111111111118, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId111111111118, bArr111111111118);
                                        } else {
                                            String frameId111111111119 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr111111111119 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr111111111119, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId111111111119, bArr111111111119);
                                        }
                                    } else {
                                        i4 = i;
                                        parsableByteArray2 = parsableByteArray;
                                        if (unsignedByte != 77) {
                                            String frameId1111111111110 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111111111110 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111111111110, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111111111110, bArr1111111111110);
                                        } else {
                                            String frameId1111111111111 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                            byte[] bArr1111111111111 = new byte[i3];
                                            parsableByteArray2.readBytes(bArr1111111111111, 0, i3);
                                            binaryFrame = new BinaryFrame(frameId1111111111111, bArr1111111111111);
                                        }
                                    }
                                    parsableByteArray2.setPosition(i5);
                                    id3Frame = binaryFrame;
                                    e = null;
                                }
                            }
                        } else if (i4 == 2) {
                            if (unsignedByte != 80) {
                            }
                            if (unsignedByte != 67) {
                            }
                            if (unsignedByte != 67) {
                                i3 = unsignedIntToInt;
                                if (unsignedByte != 67) {
                                    i4 = i;
                                    parsableByteArray2 = parsableByteArray;
                                    if (unsignedByte != 77) {
                                        String frameId1111111111112 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                        byte[] bArr1111111111112 = new byte[i3];
                                        parsableByteArray2.readBytes(bArr1111111111112, 0, i3);
                                        binaryFrame = new BinaryFrame(frameId1111111111112, bArr1111111111112);
                                    } else {
                                        String frameId1111111111113 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                        byte[] bArr1111111111113 = new byte[i3];
                                        parsableByteArray2.readBytes(bArr1111111111113, 0, i3);
                                        binaryFrame = new BinaryFrame(frameId1111111111113, bArr1111111111113);
                                    }
                                } else {
                                    i4 = i;
                                    parsableByteArray2 = parsableByteArray;
                                    if (unsignedByte != 77) {
                                        String frameId1111111111114 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                        byte[] bArr1111111111114 = new byte[i3];
                                        parsableByteArray2.readBytes(bArr1111111111114, 0, i3);
                                        binaryFrame = new BinaryFrame(frameId1111111111114, bArr1111111111114);
                                    } else {
                                        String frameId1111111111115 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                        byte[] bArr1111111111115 = new byte[i3];
                                        parsableByteArray2.readBytes(bArr1111111111115, 0, i3);
                                        binaryFrame = new BinaryFrame(frameId1111111111115, bArr1111111111115);
                                    }
                                }
                                parsableByteArray2.setPosition(i5);
                                id3Frame = binaryFrame;
                                e = null;
                            } else {
                                i3 = unsignedIntToInt;
                                if (unsignedByte != 67) {
                                    i4 = i;
                                    parsableByteArray2 = parsableByteArray;
                                    if (unsignedByte != 77) {
                                        String frameId1111111111116 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                        byte[] bArr1111111111116 = new byte[i3];
                                        parsableByteArray2.readBytes(bArr1111111111116, 0, i3);
                                        binaryFrame = new BinaryFrame(frameId1111111111116, bArr1111111111116);
                                    } else {
                                        String frameId1111111111117 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                        byte[] bArr1111111111117 = new byte[i3];
                                        parsableByteArray2.readBytes(bArr1111111111117, 0, i3);
                                        binaryFrame = new BinaryFrame(frameId1111111111117, bArr1111111111117);
                                    }
                                } else {
                                    i4 = i;
                                    parsableByteArray2 = parsableByteArray;
                                    if (unsignedByte != 77) {
                                        String frameId1111111111118 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                        byte[] bArr1111111111118 = new byte[i3];
                                        parsableByteArray2.readBytes(bArr1111111111118, 0, i3);
                                        binaryFrame = new BinaryFrame(frameId1111111111118, bArr1111111111118);
                                    } else {
                                        String frameId1111111111119 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                        byte[] bArr1111111111119 = new byte[i3];
                                        parsableByteArray2.readBytes(bArr1111111111119, 0, i3);
                                        binaryFrame = new BinaryFrame(frameId1111111111119, bArr1111111111119);
                                    }
                                }
                                parsableByteArray2.setPosition(i5);
                                id3Frame = binaryFrame;
                                e = null;
                            }
                        } else {
                            if (unsignedByte != 65) {
                            }
                            if (unsignedByte != 67) {
                            }
                            if (unsignedByte != 67) {
                                i3 = unsignedIntToInt;
                                if (unsignedByte != 67) {
                                    i4 = i;
                                    parsableByteArray2 = parsableByteArray;
                                    if (unsignedByte != 77) {
                                        String frameId11111111111110 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                        byte[] bArr11111111111110 = new byte[i3];
                                        parsableByteArray2.readBytes(bArr11111111111110, 0, i3);
                                        binaryFrame = new BinaryFrame(frameId11111111111110, bArr11111111111110);
                                    } else {
                                        String frameId11111111111111 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                        byte[] bArr11111111111111 = new byte[i3];
                                        parsableByteArray2.readBytes(bArr11111111111111, 0, i3);
                                        binaryFrame = new BinaryFrame(frameId11111111111111, bArr11111111111111);
                                    }
                                } else {
                                    i4 = i;
                                    parsableByteArray2 = parsableByteArray;
                                    if (unsignedByte != 77) {
                                        String frameId11111111111112 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                        byte[] bArr11111111111112 = new byte[i3];
                                        parsableByteArray2.readBytes(bArr11111111111112, 0, i3);
                                        binaryFrame = new BinaryFrame(frameId11111111111112, bArr11111111111112);
                                    } else {
                                        String frameId11111111111113 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                        byte[] bArr11111111111113 = new byte[i3];
                                        parsableByteArray2.readBytes(bArr11111111111113, 0, i3);
                                        binaryFrame = new BinaryFrame(frameId11111111111113, bArr11111111111113);
                                    }
                                }
                                parsableByteArray2.setPosition(i5);
                                id3Frame = binaryFrame;
                                e = null;
                            } else {
                                i3 = unsignedIntToInt;
                                if (unsignedByte != 67) {
                                    i4 = i;
                                    parsableByteArray2 = parsableByteArray;
                                    if (unsignedByte != 77) {
                                        String frameId11111111111114 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                        byte[] bArr11111111111114 = new byte[i3];
                                        parsableByteArray2.readBytes(bArr11111111111114, 0, i3);
                                        binaryFrame = new BinaryFrame(frameId11111111111114, bArr11111111111114);
                                    } else {
                                        String frameId11111111111115 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                        byte[] bArr11111111111115 = new byte[i3];
                                        parsableByteArray2.readBytes(bArr11111111111115, 0, i3);
                                        binaryFrame = new BinaryFrame(frameId11111111111115, bArr11111111111115);
                                    }
                                } else {
                                    i4 = i;
                                    parsableByteArray2 = parsableByteArray;
                                    if (unsignedByte != 77) {
                                        String frameId11111111111116 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                        byte[] bArr11111111111116 = new byte[i3];
                                        parsableByteArray2.readBytes(bArr11111111111116, 0, i3);
                                        binaryFrame = new BinaryFrame(frameId11111111111116, bArr11111111111116);
                                    } else {
                                        String frameId11111111111117 = getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4);
                                        byte[] bArr11111111111117 = new byte[i3];
                                        parsableByteArray2.readBytes(bArr11111111111117, 0, i3);
                                        binaryFrame = new BinaryFrame(frameId11111111111117, bArr11111111111117);
                                    }
                                }
                                parsableByteArray2.setPosition(i5);
                                id3Frame = binaryFrame;
                                e = null;
                            }
                        }
                    }
                    i3 = unsignedIntToInt;
                    parsableByteArray2.setPosition(i5);
                    id3Frame = binaryFrame;
                    e = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
            i3 = unsignedIntToInt;
            parsableByteArray2.setPosition(i5);
            id3Frame = null;
            if (id3Frame == null) {
                Log.w("Id3Decoder", "Failed to decode frame: id=" + getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4) + ", frameSize=" + i3, e);
            }
            return id3Frame;
        } catch (OutOfMemoryError e6) {
            e = e6;
            i3 = unsignedIntToInt;
            parsableByteArray2.setPosition(i5);
            id3Frame = null;
            if (id3Frame == null) {
                Log.w("Id3Decoder", "Failed to decode frame: id=" + getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4) + ", frameSize=" + i3, e);
            }
            return id3Frame;
        }
        if (id3Frame == null) {
            Log.w("Id3Decoder", "Failed to decode frame: id=" + getFrameId(i4, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4) + ", frameSize=" + i3, e);
        }
        return id3Frame;
    }

    public static GeobFrame decodeGeobFrame(int i, ParsableByteArray parsableByteArray) {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        Charset charset = getCharset(unsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int iIndexOfZeroByte = indexOfZeroByte(bArr, 0);
        String strNormalizeMimeType = MimeTypes.normalizeMimeType(new String(bArr, 0, iIndexOfZeroByte, StandardCharsets.ISO_8859_1));
        int i3 = iIndexOfZeroByte + 1;
        int iIndexOfTerminator = indexOfTerminator(bArr, i3, unsignedByte);
        String strDecodeStringIfValid = decodeStringIfValid(bArr, i3, iIndexOfTerminator, charset);
        int iDelimiterLength = delimiterLength(unsignedByte) + iIndexOfTerminator;
        int iIndexOfTerminator2 = indexOfTerminator(bArr, iDelimiterLength, unsignedByte);
        String strDecodeStringIfValid2 = decodeStringIfValid(bArr, iDelimiterLength, iIndexOfTerminator2, charset);
        int iDelimiterLength2 = delimiterLength(unsignedByte) + iIndexOfTerminator2;
        return new GeobFrame(strNormalizeMimeType, strDecodeStringIfValid, strDecodeStringIfValid2, i2 <= iDelimiterLength2 ? Util.EMPTY_BYTE_ARRAY : Arrays.copyOfRange(bArr, iDelimiterLength2, i2));
    }

    public static MlltFrame decodeMlltFrame(int i, ParsableByteArray parsableByteArray) {
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedInt24 = parsableByteArray.readUnsignedInt24();
        int unsignedInt25 = parsableByteArray.readUnsignedInt24();
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int unsignedByte2 = parsableByteArray.readUnsignedByte();
        VorbisBitArray vorbisBitArray = new VorbisBitArray();
        vorbisBitArray.reset(parsableByteArray);
        int i2 = ((i - 10) * 8) / (unsignedByte + unsignedByte2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int bits = vorbisBitArray.readBits(unsignedByte);
            int bits2 = vorbisBitArray.readBits(unsignedByte2);
            iArr[i3] = bits;
            iArr2[i3] = bits2;
        }
        return new MlltFrame(unsignedShort, unsignedInt24, unsignedInt25, iArr, iArr2);
    }

    public static PrivFrame decodePrivFrame(int i, ParsableByteArray parsableByteArray) {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        int iIndexOfZeroByte = indexOfZeroByte(bArr, 0);
        String str = new String(bArr, 0, iIndexOfZeroByte, StandardCharsets.ISO_8859_1);
        int i2 = iIndexOfZeroByte + 1;
        return new PrivFrame(str, i <= i2 ? Util.EMPTY_BYTE_ARRAY : Arrays.copyOfRange(bArr, i2, i));
    }

    public static String decodeStringIfValid(byte[] bArr, int i, int i2, Charset charset) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, charset);
    }

    public static TextInformationFrame decodeTextInformationFrame(int i, ParsableByteArray parsableByteArray, String str) {
        if (i < 1) {
            return null;
        }
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        return new TextInformationFrame(str, null, decodeTextInformationFrameValues(bArr, unsignedByte, 0));
    }

    public static RegularImmutableList decodeTextInformationFrameValues(byte[] bArr, int i, int i2) {
        if (i2 >= bArr.length) {
            return ImmutableList.of((Object) "");
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        int iIndexOfTerminator = indexOfTerminator(bArr, i2, i);
        while (i2 < iIndexOfTerminator) {
            builder.add((Object) new String(bArr, i2, iIndexOfTerminator - i2, getCharset(i)));
            i2 = delimiterLength(i) + iIndexOfTerminator;
            iIndexOfTerminator = indexOfTerminator(bArr, i2, i);
        }
        RegularImmutableList regularImmutableListBuild = builder.build();
        return regularImmutableListBuild.isEmpty() ? ImmutableList.of((Object) "") : regularImmutableListBuild;
    }

    public static TextInformationFrame decodeTxxxFrame(int i, ParsableByteArray parsableByteArray) {
        if (i < 1) {
            return null;
        }
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int iIndexOfTerminator = indexOfTerminator(bArr, 0, unsignedByte);
        return new TextInformationFrame("TXXX", new String(bArr, 0, iIndexOfTerminator, getCharset(unsignedByte)), decodeTextInformationFrameValues(bArr, unsignedByte, delimiterLength(unsignedByte) + iIndexOfTerminator));
    }

    public static UrlLinkFrame decodeUrlLinkFrame(int i, ParsableByteArray parsableByteArray, String str) {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, indexOfZeroByte(bArr, 0), StandardCharsets.ISO_8859_1));
    }

    public static UrlLinkFrame decodeWxxxFrame(int i, ParsableByteArray parsableByteArray) {
        if (i < 1) {
            return null;
        }
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int iIndexOfTerminator = indexOfTerminator(bArr, 0, unsignedByte);
        String str = new String(bArr, 0, iIndexOfTerminator, getCharset(unsignedByte));
        int iDelimiterLength = delimiterLength(unsignedByte) + iIndexOfTerminator;
        return new UrlLinkFrame("WXXX", str, decodeStringIfValid(bArr, iDelimiterLength, indexOfZeroByte(bArr, iDelimiterLength), StandardCharsets.ISO_8859_1));
    }

    public static int delimiterLength(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public static Charset getCharset(int i) {
        if (i == 1) {
            return StandardCharsets.UTF_16;
        }
        if (i != 2) {
            return i != 3 ? StandardCharsets.ISO_8859_1 : StandardCharsets.UTF_8;
        }
        return StandardCharsets.UTF_16BE;
    }

    public static String getFrameId(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static int indexOfTerminator(byte[] bArr, int i, int i2) {
        int iIndexOfZeroByte = indexOfZeroByte(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iIndexOfZeroByte;
        }
        while (iIndexOfZeroByte < bArr.length - 1) {
            if ((iIndexOfZeroByte - i) % 2 == 0 && bArr[iIndexOfZeroByte + 1] == 0) {
                return iIndexOfZeroByte;
            }
            iIndexOfZeroByte = indexOfZeroByte(bArr, iIndexOfZeroByte + 1);
        }
        return bArr.length;
    }

    public static int indexOfZeroByte(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    public static int removeUnsynchronization(int i, ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.data;
        int i2 = parsableByteArray.position;
        int i3 = i2;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= i2 + i) {
                return i;
            }
            if ((bArr[i3] & 255) == 255 && bArr[i4] == 0) {
                System.arraycopy(bArr, i3 + 2, bArr, i4, (i - (i3 - i2)) - 2);
                i--;
            }
            i3 = i4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x007a A[PHI: r3
      0x007a: PHI (r3v16 int) = (r3v5 int), (r3v19 int) binds: [B:42:0x0087, B:33:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    public static boolean validateFrames(ParsableByteArray parsableByteArray, int i, int i2, boolean z) {
        int unsignedInt24;
        long unsignedInt25;
        int unsignedShort;
        int i3;
        int i4 = parsableByteArray.position;
        while (true) {
            try {
                boolean z2 = true;
                if (parsableByteArray.bytesLeft() < i2) {
                    parsableByteArray.setPosition(i4);
                    return true;
                }
                if (i >= 3) {
                    unsignedInt24 = parsableByteArray.readInt();
                    unsignedInt25 = parsableByteArray.readUnsignedInt();
                    unsignedShort = parsableByteArray.readUnsignedShort();
                } else {
                    unsignedInt24 = parsableByteArray.readUnsignedInt24();
                    unsignedInt25 = parsableByteArray.readUnsignedInt24();
                    unsignedShort = 0;
                }
                if (unsignedInt24 == 0 && unsignedInt25 == 0 && unsignedShort == 0) {
                    parsableByteArray.setPosition(i4);
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & unsignedInt25) != 0) {
                        parsableByteArray.setPosition(i4);
                        return false;
                    }
                    unsignedInt25 = (((unsignedInt25 >> 24) & 255) << 21) | (unsignedInt25 & 255) | (((unsignedInt25 >> 8) & 255) << 7) | (((unsignedInt25 >> 16) & 255) << 14);
                }
                if (i == 4) {
                    i3 = (unsignedShort & 64) != 0 ? 1 : 0;
                    if ((unsignedShort & 1) == 0) {
                        z2 = false;
                    }
                } else if (i == 3) {
                    i3 = (unsignedShort & 32) != 0 ? 1 : 0;
                    if ((unsignedShort & 128) == 0) {
                        z2 = false;
                    }
                } else {
                    i3 = 0;
                    z2 = false;
                }
                if (z2) {
                    i3 += 4;
                }
                if (unsignedInt25 < i3) {
                    parsableByteArray.setPosition(i4);
                    return false;
                }
                if (parsableByteArray.bytesLeft() < unsignedInt25) {
                    parsableByteArray.setPosition(i4);
                    return false;
                }
                parsableByteArray.skipBytes((int) unsignedInt25);
            } catch (Throwable th) {
                parsableByteArray.setPosition(i4);
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x008c  */
    /* JADX WARN: Code duplicated, block: B:34:0x009b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x009c  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:51:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00c7 A[SYNTHETIC] */
    public final Metadata decode(byte[] bArr, int i) {
        boolean z;
        Id3Header id3Header;
        short s;
        int i2;
        int iRemoveUnsynchronization;
        Id3Frame id3FrameDecodeFrame;
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        boolean z2 = false;
        if (parsableByteArray.bytesLeft() < 10) {
            Log.w("Id3Decoder", "Data too short to be an ID3 tag");
        } else {
            int unsignedInt24 = parsableByteArray.readUnsignedInt24();
            if (unsignedInt24 == 4801587) {
                int unsignedByte = parsableByteArray.readUnsignedByte();
                parsableByteArray.skipBytes(1);
                int unsignedByte2 = parsableByteArray.readUnsignedByte();
                int synchSafeInt = parsableByteArray.readSynchSafeInt();
                if (unsignedByte != 2) {
                    if (unsignedByte == 3) {
                        if ((unsignedByte2 & 64) != 0) {
                            int i3 = parsableByteArray.readInt();
                            parsableByteArray.skipBytes(i3);
                            synchSafeInt -= i3 + 4;
                        }
                    } else if (unsignedByte == 4) {
                        if ((unsignedByte2 & 64) != 0) {
                            int synchSafeInt2 = parsableByteArray.readSynchSafeInt();
                            parsableByteArray.skipBytes(synchSafeInt2 - 4);
                            synchSafeInt -= synchSafeInt2;
                        }
                        if ((unsignedByte2 & 16) != 0) {
                            synchSafeInt -= 10;
                        }
                    } else {
                        Format$$ExternalSyntheticOutline0.m(unsignedByte, "Skipped ID3 tag with unsupported majorVersion=", "Id3Decoder");
                    }
                    if (unsignedByte < 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    id3Header = new Id3Header(unsignedByte, z, synchSafeInt);
                } else if ((unsignedByte2 & 64) != 0) {
                    Log.w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                } else {
                    if (unsignedByte < 4 || (unsignedByte2 & 128) == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    id3Header = new Id3Header(unsignedByte, z, synchSafeInt);
                }
                if (id3Header == null) {
                    return null;
                }
                s = id3Header.majorVersion;
                int i4 = parsableByteArray.position;
                i2 = s == 2 ? 6 : 10;
                iRemoveUnsynchronization = id3Header.framesSize;
                if (id3Header.isUnsynchronized) {
                    iRemoveUnsynchronization = removeUnsynchronization(iRemoveUnsynchronization, parsableByteArray);
                }
                parsableByteArray.setLimit(i4 + iRemoveUnsynchronization);
                if (!validateFrames(parsableByteArray, s, i2, false)) {
                    if (s == 4 || !validateFrames(parsableByteArray, 4, i2, true)) {
                        Format$$ExternalSyntheticOutline0.m(s, "Failed to validate ID3 tag with majorVersion=", "Id3Decoder");
                        return null;
                    }
                    z2 = true;
                }
                while (parsableByteArray.bytesLeft() >= i2) {
                    id3FrameDecodeFrame = decodeFrame(s, parsableByteArray, z2, i2, this.framePredicate);
                    if (id3FrameDecodeFrame != null) {
                        arrayList.add(id3FrameDecodeFrame);
                    }
                }
                return new Metadata(arrayList);
            }
            Log.w("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x".concat(String.format("%06X", Integer.valueOf(unsignedInt24))));
        }
        id3Header = null;
        if (id3Header == null) {
            return null;
        }
        s = id3Header.majorVersion;
        int i5 = parsableByteArray.position;
        if (s == 2) {
        }
        iRemoveUnsynchronization = id3Header.framesSize;
        if (id3Header.isUnsynchronized) {
            iRemoveUnsynchronization = removeUnsynchronization(iRemoveUnsynchronization, parsableByteArray);
        }
        parsableByteArray.setLimit(i5 + iRemoveUnsynchronization);
        if (!validateFrames(parsableByteArray, s, i2, false)) {
            if (s == 4) {
            }
            Format$$ExternalSyntheticOutline0.m(s, "Failed to validate ID3 tag with majorVersion=", "Id3Decoder");
            return null;
        }
        while (parsableByteArray.bytesLeft() >= i2) {
            id3FrameDecodeFrame = decodeFrame(s, parsableByteArray, z2, i2, this.framePredicate);
            if (id3FrameDecodeFrame != null) {
                arrayList.add(id3FrameDecodeFrame);
            }
        }
        return new Metadata(arrayList);
    }

    @Override // androidx.sqlite.SQLite
    public final Metadata decode(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        return decode(byteBuffer.array(), byteBuffer.limit());
    }
}
