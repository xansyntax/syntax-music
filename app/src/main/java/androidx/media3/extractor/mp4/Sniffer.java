package androidx.media3.extractor.mp4;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.decoder.Buffer;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.SniffFailure;
import androidx.media3.extractor.metadata.id3.ApicFrame;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.Id3Frame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import androidx.media3.extractor.ts.MpeghUtil$MhasPacketHeader;
import com.google.common.collect.ImmutableList;
import com.metrolist.music.playback.StreamUrlCache;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Sniffer {
    public static final int[] COMPATIBLE_BRANDS = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static byte[] buildPsshAtom(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.putInt(1886614376);
        byteBufferAllocate.putInt(uuidArr != null ? 16777216 : 0);
        byteBufferAllocate.putLong(uuid.getMostSignificantBits());
        byteBufferAllocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            byteBufferAllocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                byteBufferAllocate.putLong(uuid2.getMostSignificantBits());
                byteBufferAllocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr == null || bArr.length == 0) {
            byteBufferAllocate.putInt(0);
        } else {
            byteBufferAllocate.putInt(bArr.length);
            byteBufferAllocate.put(bArr);
        }
        return byteBufferAllocate.array();
    }

    public static String getContainerMimeType(ArrayList arrayList) {
        int size = arrayList.size();
        boolean z = false;
        String str = null;
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str2 = ((TrackSampleTable) obj).track.format.sampleMimeType;
            if (MimeTypes.isVideo(str2)) {
                return "video/mp4";
            }
            if (MimeTypes.isAudio(str2)) {
                z = true;
            } else if (MimeTypes.isImage(str2)) {
                if (Objects.equals(str2, "image/heic")) {
                    str = "image/heif";
                } else if (Objects.equals(str2, "image/avif")) {
                    str = "image/avif";
                }
            }
        }
        if (z) {
            return "audio/mp4";
        }
        return str != null ? str : "application/mp4";
    }

    public static boolean isCompatibleBrand(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 = 0; i2 < 29; i2++) {
            if (COMPATIBLE_BRANDS[i2] == i) {
                return true;
            }
        }
        return false;
    }

    public static ApicFrame parseCoverArt(ParsableByteArray parsableByteArray) {
        String str;
        int i = parsableByteArray.readInt();
        if (parsableByteArray.readInt() != 1684108385) {
            Log.w("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int i2 = parsableByteArray.readInt();
        byte[] bArr = BoxParser.opusMagic;
        int i3 = i2 & 16777215;
        if (i3 == 13) {
            str = "image/jpeg";
        } else {
            str = i3 == 14 ? "image/png" : null;
        }
        if (str == null) {
            Format$$ExternalSyntheticOutline0.m(i3, "Unrecognized cover art flags: ", "MetadataUtil");
            return null;
        }
        parsableByteArray.skipBytes(4);
        int i4 = i - 16;
        byte[] bArr2 = new byte[i4];
        parsableByteArray.readBytes(bArr2, 0, i4);
        return new ApicFrame(str, null, 3, bArr2);
    }

    public static TextInformationFrame parseIndexAndCountAttribute(int i, ParsableByteArray parsableByteArray, String str) {
        int i2 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385 && i2 >= 22) {
            parsableByteArray.skipBytes(10);
            int unsignedShort = parsableByteArray.readUnsignedShort();
            if (unsignedShort > 0) {
                String strM = IntIntPair$$ExternalSyntheticOutline0.m(unsignedShort, "");
                int unsignedShort2 = parsableByteArray.readUnsignedShort();
                if (unsignedShort2 > 0) {
                    strM = strM + "/" + unsignedShort2;
                }
                return new TextInformationFrame(str, null, ImmutableList.of((Object) strM));
            }
        }
        Log.w("MetadataUtil", "Failed to parse index/count attribute: ".concat(Buffer.getBoxTypeString(i)));
        return null;
    }

    public static int parseIntegerAttribute(ParsableByteArray parsableByteArray) {
        int i = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            int i2 = i - 16;
            if (i2 == 1) {
                return parsableByteArray.readUnsignedByte();
            }
            if (i2 == 2) {
                return parsableByteArray.readUnsignedShort();
            }
            if (i2 == 3) {
                return parsableByteArray.readUnsignedInt24();
            }
            if (i2 == 4 && (parsableByteArray.peekUnsignedByte() & 128) == 0) {
                return parsableByteArray.readUnsignedIntToInt();
            }
        }
        Log.w("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    public static StreamUrlCache parsePsshAtom(byte[] bArr) {
        UUID[] uuidArr;
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        if (parsableByteArray.limit < 32) {
            return null;
        }
        parsableByteArray.setPosition(0);
        int iBytesLeft = parsableByteArray.bytesLeft();
        int i = parsableByteArray.readInt();
        if (i != iBytesLeft) {
            Log.w("PsshAtomUtil", "Advertised atom size (" + i + ") does not match buffer size: " + iBytesLeft);
            return null;
        }
        int i2 = parsableByteArray.readInt();
        if (i2 != 1886614376) {
            Format$$ExternalSyntheticOutline0.m(i2, "Atom type is not pssh: ", "PsshAtomUtil");
            return null;
        }
        int fullBoxVersion = BoxParser.parseFullBoxVersion(parsableByteArray.readInt());
        if (fullBoxVersion > 1) {
            Format$$ExternalSyntheticOutline0.m(fullBoxVersion, "Unsupported pssh version: ", "PsshAtomUtil");
            return null;
        }
        UUID uuid = new UUID(parsableByteArray.readLong(), parsableByteArray.readLong());
        if (fullBoxVersion == 1) {
            int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            uuidArr = new UUID[unsignedIntToInt];
            for (int i3 = 0; i3 < unsignedIntToInt; i3++) {
                uuidArr[i3] = new UUID(parsableByteArray.readLong(), parsableByteArray.readLong());
            }
        } else {
            uuidArr = null;
        }
        int unsignedIntToInt2 = parsableByteArray.readUnsignedIntToInt();
        int iBytesLeft2 = parsableByteArray.bytesLeft();
        if (unsignedIntToInt2 == iBytesLeft2) {
            byte[] bArr2 = new byte[unsignedIntToInt2];
            parsableByteArray.readBytes(bArr2, 0, unsignedIntToInt2);
            return new StreamUrlCache(uuid, fullBoxVersion, bArr2, uuidArr);
        }
        Log.w("PsshAtomUtil", "Atom data size (" + unsignedIntToInt2 + ") does not match the bytes left: " + iBytesLeft2);
        return null;
    }

    public static byte[] parseSchemeSpecificData(UUID uuid, byte[] bArr) {
        StreamUrlCache psshAtom = parsePsshAtom(bArr);
        if (psshAtom == null) {
            return null;
        }
        UUID uuid2 = (UUID) psshAtom.currentTimeMillis;
        if (uuid.equals(uuid2)) {
            return (byte[]) psshAtom.entries;
        }
        Log.w("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + uuid2 + ".");
        return null;
    }

    public static TextInformationFrame parseTextAttribute(int i, ParsableByteArray parsableByteArray, String str) {
        int i2 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            return new TextInformationFrame(str, null, ImmutableList.of((Object) parsableByteArray.readNullTerminatedString(i2 - 16)));
        }
        Log.w("MetadataUtil", "Failed to parse text attribute: ".concat(Buffer.getBoxTypeString(i)));
        return null;
    }

    public static void setFormatMetadata(int i, Metadata metadata, Format.Builder builder, Metadata metadata2, Metadata... metadataArr) {
        if (metadata2 == null) {
            metadata2 = new Metadata(new Metadata.Entry[0]);
        }
        if (metadata != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (Metadata.Entry entry : metadata.entries) {
                if (MdtaMetadataEntry.class.isAssignableFrom(entry.getClass())) {
                    builder2.add(MdtaMetadataEntry.class.cast(entry));
                }
            }
            ImmutableList.Itr itrListIterator = builder2.build().listIterator(0);
            while (itrListIterator.hasNext()) {
                MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) itrListIterator.next();
                if (!mdtaMetadataEntry.key.equals("com.android.capture.fps") || i == 2) {
                    metadata2 = metadata2.copyWithAppendedEntries(mdtaMetadataEntry);
                }
            }
        }
        for (Metadata metadata3 : metadataArr) {
            metadata2 = metadata2.copyWithAppendedEntriesFrom(metadata3);
        }
        if (metadata2.entries.length > 0) {
            builder.metadata = metadata2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x016e  */
    /* JADX WARN: Code duplicated, block: B:102:0x0172 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:103:0x0174  */
    /* JADX WARN: Code duplicated, block: B:105:0x0177  */
    /* JADX WARN: Code duplicated, block: B:107:0x017a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:98:0x016b  */
    /* JADX WARN: Multi-variable type inference failed */
    public static SniffFailure sniffInternal(ExtractorInput extractorInput, boolean z, boolean z2) {
        SniffFailure sniffFailure;
        int i;
        long j;
        int i2;
        long j2;
        int i3;
        boolean z3;
        int[] iArr;
        long length = extractorInput.getLength();
        long j3 = -1;
        int i4 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        long j4 = 4096;
        if (i4 != 0 && length <= 4096) {
            j4 = length;
        }
        int i5 = (int) j4;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        int i6 = 0;
        int i7 = 0;
        boolean z4 = false;
        while (true) {
            if (i7 < i5) {
                parsableByteArray.reset(8);
                if (extractorInput.peekFully(parsableByteArray.data, i6, 8, true)) {
                    long unsignedInt = parsableByteArray.readUnsignedInt();
                    int i8 = parsableByteArray.readInt();
                    if (unsignedInt == 1) {
                        j3 = j3;
                        extractorInput.peekFully(parsableByteArray.data, 8, 8);
                        i2 = 16;
                        parsableByteArray.setLimit(16);
                        j = parsableByteArray.readLong();
                    } else {
                        j3 = j3;
                        if (unsignedInt == 0) {
                            long length2 = extractorInput.getLength();
                            if (length2 != j3) {
                                unsignedInt = (length2 - extractorInput.getPeekPosition()) + 8;
                            }
                        }
                        j = unsignedInt;
                        i2 = 8;
                    }
                    long j5 = i2;
                    if (j < j5) {
                        sniffFailure = null;
                        if (i8 != 1718773093 || i2 != 8) {
                            return new MpeghUtil$MhasPacketHeader(i8, i2, j);
                        }
                        j = j5;
                    } else {
                        sniffFailure = null;
                    }
                    int i9 = i7 + i2;
                    if (i8 == 1836019574 || i8 == 1970628964) {
                        i5 += (int) j;
                        if (i4 != 0 && i5 > length) {
                            i5 = (int) length;
                        }
                        if (i8 == 1836019574) {
                            i7 = i9;
                            i6 = 0;
                        }
                    }
                    if (i8 == 1953653099 || i8 == 1835297121 || i8 == 1835626086) {
                        j2 = length;
                        i3 = 0;
                        i7 = i9;
                    } else if (i8 == 1836019558 || i8 == 1836475768) {
                        i = 1;
                    } else {
                        if (i8 == 1835295092) {
                            z4 = true;
                        }
                        if (i8 != 1937007212 || j <= 1000000) {
                            j2 = length;
                            if ((((long) i9) + j) - j5 < i5) {
                                int i10 = (int) (j - j5);
                                i7 = i9 + i10;
                                if (i8 != 1718909296) {
                                    i3 = 0;
                                    if (i10 != 0) {
                                        extractorInput.advancePeekPosition(i10);
                                    }
                                } else {
                                    if (i10 < 8) {
                                        return new MpeghUtil$MhasPacketHeader(i8, 8, i10);
                                    }
                                    parsableByteArray.reset(i10);
                                    i3 = 0;
                                    extractorInput.peekFully(parsableByteArray.data, 0, i10);
                                    int i11 = parsableByteArray.readInt();
                                    if (isCompatibleBrand(i11, z2)) {
                                        z4 = true;
                                    }
                                    parsableByteArray.skipBytes(4);
                                    int iBytesLeft = parsableByteArray.bytesLeft() / 4;
                                    if (!z4 && iBytesLeft > 0) {
                                        int[] iArr2 = new int[iBytesLeft];
                                        int i12 = 0;
                                        while (true) {
                                            if (i12 >= iBytesLeft) {
                                                z3 = z4;
                                                iArr = iArr2;
                                                break;
                                            }
                                            int i13 = parsableByteArray.readInt();
                                            iArr2[i12] = i13;
                                            if (isCompatibleBrand(i13, z2)) {
                                                z3 = true;
                                                iArr = iArr2;
                                                break;
                                            }
                                            i12++;
                                        }
                                    } else {
                                        z3 = z4;
                                        iArr = sniffFailure;
                                    }
                                    if (!z3) {
                                        return new PriorityQueue(i11, iArr);
                                    }
                                    z4 = z3;
                                }
                            }
                        }
                        i = 0;
                    }
                    i6 = i3;
                    length = j2;
                }
                if (!z4) {
                    return NoDeclaredBrandSniffFailure.INSTANCE;
                }
                if (z != i) {
                    return i != 0 ? IncorrectFragmentationSniffFailure.FILE_FRAGMENTED : IncorrectFragmentationSniffFailure.FILE_NOT_FRAGMENTED;
                }
                return sniffFailure;
            }
            sniffFailure = null;
            i = i6;
            if (!z4) {
                return NoDeclaredBrandSniffFailure.INSTANCE;
            }
            if (z != i) {
                if (i != 0) {
                }
            }
            return sniffFailure;
        }
    }

    public static Id3Frame parseIntegerAttribute(int i, String str, ParsableByteArray parsableByteArray, boolean z, boolean z2) {
        int integerAttribute = parseIntegerAttribute(parsableByteArray);
        if (z2) {
            integerAttribute = Math.min(1, integerAttribute);
        }
        if (integerAttribute < 0) {
            Log.w("MetadataUtil", "Failed to parse uint8 attribute: ".concat(Buffer.getBoxTypeString(i)));
            return null;
        }
        if (z) {
            return new TextInformationFrame(str, null, ImmutableList.of((Object) Integer.toString(integerAttribute)));
        }
        return new CommentFrame("und", str, Integer.toString(integerAttribute));
    }
}
