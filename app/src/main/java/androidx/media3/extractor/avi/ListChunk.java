package androidx.media3.extractor.avi;

import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ListChunk implements AviChunk {
    public final ImmutableList children;
    public final int type;

    public ListChunk(int i, RegularImmutableList regularImmutableList) {
        this.type = i;
        this.children = regularImmutableList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static ListChunk parseFrom(int i, ParsableByteArray parsableByteArray) {
        String str;
        AviChunk streamFormatChunk;
        String str2;
        int i2 = 4;
        Maps.checkNonnegative(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        int i3 = parsableByteArray.limit;
        int trackType = -2;
        int i4 = 0;
        while (parsableByteArray.bytesLeft() > 8) {
            int littleEndianInt = parsableByteArray.readLittleEndianInt();
            int littleEndianInt2 = parsableByteArray.position + parsableByteArray.readLittleEndianInt();
            parsableByteArray.setLimit(littleEndianInt2);
            if (littleEndianInt != 1414744396) {
                AviStreamHeaderChunk aviStreamHeaderChunk = null;
                switch (littleEndianInt) {
                    case 1718776947:
                        if (trackType != 2) {
                            if (trackType == 1) {
                                int littleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                                if (littleEndianUnsignedShort == 1) {
                                    str = "audio/raw";
                                } else if (littleEndianUnsignedShort == 85) {
                                    str = "audio/mpeg";
                                } else if (littleEndianUnsignedShort == 255) {
                                    str = "audio/mp4a-latm";
                                } else if (littleEndianUnsignedShort != 8192) {
                                    str = littleEndianUnsignedShort != 8193 ? null : "audio/vnd.dts";
                                } else {
                                    str = "audio/ac3";
                                }
                                if (str != null) {
                                    int littleEndianUnsignedShort2 = parsableByteArray.readLittleEndianUnsignedShort();
                                    int littleEndianInt3 = parsableByteArray.readLittleEndianInt();
                                    parsableByteArray.skipBytes(6);
                                    int littleEndianUnsignedShort3 = parsableByteArray.readLittleEndianUnsignedShort();
                                    String str3 = Util.DEVICE_DEBUG_INFO;
                                    int pcmEncoding = Util.getPcmEncoding(littleEndianUnsignedShort3, ByteOrder.LITTLE_ENDIAN);
                                    int littleEndianUnsignedShort4 = parsableByteArray.bytesLeft() > 0 ? parsableByteArray.readLittleEndianUnsignedShort() : 0;
                                    Format.Builder builder = new Format.Builder();
                                    builder.sampleMimeType = MimeTypes.normalizeMimeType(str);
                                    builder.channelCount = littleEndianUnsignedShort2;
                                    builder.sampleRate = littleEndianInt3;
                                    if (str.equals("audio/raw") && pcmEncoding != 0) {
                                        builder.pcmEncoding = pcmEncoding;
                                    }
                                    if (str.equals("audio/mp4a-latm") && littleEndianUnsignedShort4 > 0) {
                                        byte[] bArr = new byte[littleEndianUnsignedShort4];
                                        parsableByteArray.readBytes(bArr, 0, littleEndianUnsignedShort4);
                                        builder.initializationData = ImmutableList.of((Object) bArr);
                                    }
                                    streamFormatChunk = new StreamFormatChunk(new Format(builder));
                                } else {
                                    Format$$ExternalSyntheticOutline0.m(littleEndianUnsignedShort, "Ignoring track with unsupported format tag ", "StreamFormatChunk");
                                }
                            } else {
                                Log.w("StreamFormatChunk", "Ignoring strf box for unsupported track type: ".concat(Util.getTrackTypeString(trackType)));
                            }
                            streamFormatChunk = aviStreamHeaderChunk;
                            break;
                        } else {
                            parsableByteArray.skipBytes(i2);
                            int littleEndianInt4 = parsableByteArray.readLittleEndianInt();
                            int littleEndianInt5 = parsableByteArray.readLittleEndianInt();
                            parsableByteArray.skipBytes(i2);
                            int littleEndianInt6 = parsableByteArray.readLittleEndianInt();
                            switch (littleEndianInt6) {
                                case 808802372:
                                case 877677894:
                                case 1145656883:
                                case 1145656920:
                                case 1482049860:
                                case 1684633208:
                                case 2021026148:
                                    str2 = "video/mp4v-es";
                                    break;
                                case 826496577:
                                case 828601953:
                                case 875967048:
                                    str2 = "video/avc";
                                    break;
                                case 842289229:
                                    str2 = "video/mp42";
                                    break;
                                case 859066445:
                                    str2 = "video/mp43";
                                    break;
                                case 1196444237:
                                case 1735420525:
                                    str2 = "video/mjpeg";
                                    break;
                                default:
                                    str2 = null;
                                    break;
                            }
                            if (str2 != null) {
                                Format.Builder builder2 = new Format.Builder();
                                builder2.width = littleEndianInt4;
                                builder2.height = littleEndianInt5;
                                builder2.sampleMimeType = MimeTypes.normalizeMimeType(str2);
                                streamFormatChunk = new StreamFormatChunk(new Format(builder2));
                            } else {
                                Format$$ExternalSyntheticOutline0.m(littleEndianInt6, "Ignoring track with unsupported compression ", "StreamFormatChunk");
                                streamFormatChunk = aviStreamHeaderChunk;
                            }
                        }
                        break;
                    case 1751742049:
                        int littleEndianInt7 = parsableByteArray.readLittleEndianInt();
                        parsableByteArray.skipBytes(8);
                        int littleEndianInt8 = parsableByteArray.readLittleEndianInt();
                        int littleEndianInt9 = parsableByteArray.readLittleEndianInt();
                        parsableByteArray.skipBytes(i2);
                        parsableByteArray.readLittleEndianInt();
                        parsableByteArray.skipBytes(12);
                        streamFormatChunk = new AviMainHeaderChunk(littleEndianInt7, littleEndianInt8, littleEndianInt9);
                        break;
                    case 1752331379:
                        int littleEndianInt10 = parsableByteArray.readLittleEndianInt();
                        parsableByteArray.skipBytes(12);
                        parsableByteArray.readLittleEndianInt();
                        int littleEndianInt11 = parsableByteArray.readLittleEndianInt();
                        int littleEndianInt12 = parsableByteArray.readLittleEndianInt();
                        parsableByteArray.skipBytes(i2);
                        int littleEndianInt13 = parsableByteArray.readLittleEndianInt();
                        int littleEndianInt14 = parsableByteArray.readLittleEndianInt();
                        parsableByteArray.skipBytes(i2);
                        aviStreamHeaderChunk = new AviStreamHeaderChunk(littleEndianInt10, littleEndianInt11, littleEndianInt12, littleEndianInt13, littleEndianInt14, parsableByteArray.readLittleEndianInt());
                        streamFormatChunk = aviStreamHeaderChunk;
                        break;
                    case 1852994675:
                        streamFormatChunk = new StreamNameChunk(parsableByteArray.readString(parsableByteArray.bytesLeft(), StandardCharsets.UTF_8));
                        break;
                    default:
                        streamFormatChunk = aviStreamHeaderChunk;
                        break;
                }
            } else {
                streamFormatChunk = parseFrom(parsableByteArray.readLittleEndianInt(), parsableByteArray);
            }
            if (streamFormatChunk != null) {
                if (streamFormatChunk.getType() == 1752331379) {
                    trackType = ((AviStreamHeaderChunk) streamFormatChunk).getTrackType();
                }
                int i5 = i4 + 1;
                int iExpandedCapacity = ImmutableCollection.Builder.expandedCapacity(objArrCopyOf.length, i5);
                if (iExpandedCapacity > objArrCopyOf.length) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, iExpandedCapacity);
                }
                objArrCopyOf[i4] = streamFormatChunk;
                i4 = i5;
            }
            parsableByteArray.setPosition(littleEndianInt2);
            parsableByteArray.setLimit(i3);
            i2 = 4;
        }
        return new ListChunk(i, ImmutableList.asImmutableList(i4, objArrCopyOf));
    }

    public final AviChunk getChild(Class cls) {
        ImmutableList.Itr itrListIterator = this.children.listIterator(0);
        while (itrListIterator.hasNext()) {
            AviChunk aviChunk = (AviChunk) itrListIterator.next();
            if (aviChunk.getClass() == cls) {
                return aviChunk;
            }
        }
        return null;
    }

    @Override // androidx.media3.extractor.avi.AviChunk
    public final int getType() {
        return this.type;
    }
}
