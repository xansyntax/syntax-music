package androidx.media3.extractor.mp4;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda0;
import androidx.core.app.NotificationCompat$Builder;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4AlternateGroupData;
import androidx.media3.container.Mp4Box$ContainerBox;
import androidx.media3.container.Mp4Box$LeafBox;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4TimestampData;
import androidx.media3.container.OpusUtil;
import androidx.media3.decoder.Buffer;
import androidx.media3.exoplayer.audio.AudioOffloadSupport;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.Ac4Util$Ac4Presentation;
import androidx.media3.extractor.AvcConfig;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.HevcConfig;
import androidx.media3.extractor.VorbisBitArray;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.Id3Util;
import androidx.media3.extractor.metadata.id3.InternalFrame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import androidx.media3.extractor.metadata.mp4.SmtaMetadataEntry;
import androidx.media3.extractor.mp4.BoxParser;
import androidx.media3.session.MediaNotification$Provider;
import androidx.navigation.NavOptions;
import coil3.memory.RealStrongMemoryCache$cache$1;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.metrolist.music.recognition.VibraSignature;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.utils.CIOKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http2.Huffman;
import okio.PriorityQueue;
import okio.internal.EocdRecord;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BoxParser {
    public static final byte[] opusMagic;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ChunkIterator {
        public final ParsableByteArray chunkOffsets;
        public final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        public int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        public int remainingSamplesPerChunkChanges;
        public final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) throws ParserException {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            AacUtil.checkContainerInput("first_chunk must be 1", parsableByteArray.readInt() == 1);
            this.index = -1;
        }

        public final boolean moveNext() {
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            boolean z = this.chunkOffsetsAreLongs;
            ParsableByteArray parsableByteArray = this.chunkOffsets;
            this.offset = z ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                ParsableByteArray parsableByteArray2 = this.stsc;
                this.numSamples = parsableByteArray2.readUnsignedIntToInt();
                parsableByteArray2.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? parsableByteArray2.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface SampleSizeBox {
        int getFixedSampleSize();

        int getSampleCount();

        int readNextSampleSize();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class StriData {
        public boolean eyeViewsReversed;
        public boolean hasLeftEyeView;
        public boolean hasRightEyeView;

        public AudioOffloadSupport build() {
            if (this.hasLeftEyeView || !(this.hasRightEyeView || this.eyeViewsReversed)) {
                return new AudioOffloadSupport(this);
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Secondary offload attribute fields are true but primary isFormatSupported is false");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Stz2SampleSizeBox implements SampleSizeBox {
        public short currentByte;
        public final ParsableByteArray data;
        public final int fieldSize;
        public final int sampleCount;
        public int sampleIndex;

        public Stz2SampleSizeBox(Mp4Box$LeafBox mp4Box$LeafBox) {
            ParsableByteArray parsableByteArray = mp4Box$LeafBox.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public final int getFixedSampleSize() {
            return -1;
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public final int getSampleCount() {
            return this.sampleCount;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [int, short] */
        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public final int readNextSampleSize() {
            ParsableByteArray parsableByteArray = this.data;
            int i = this.fieldSize;
            if (i == 8) {
                return parsableByteArray.readUnsignedByte();
            }
            if (i == 16) {
                return parsableByteArray.readUnsignedShort();
            }
            int i2 = this.sampleIndex;
            this.sampleIndex = i2 + 1;
            if (i2 % 2 != 0) {
                return this.currentByte & 15;
            }
            ?? unsignedByte = parsableByteArray.readUnsignedByte();
            this.currentByte = unsignedByte;
            return (unsignedByte & 240) >> 4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TkhdData {
        public final int alternateGroup;
        public final int height;
        public final int id;
        public final int rotationDegrees;
        public final int width;

        public TkhdData(int i, int i2, int i3, int i4, int i5, long j) {
            this.id = i;
            this.alternateGroup = i2;
            this.rotationDegrees = i3;
            this.width = i4;
            this.height = i5;
        }
    }

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        opusMagic = "OpusHead".getBytes(StandardCharsets.UTF_8);
    }

    public static void maybeSkipRemainingMetaBoxHeaderBytes(ParsableByteArray parsableByteArray) {
        int i = parsableByteArray.position;
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() != 1751411826) {
            i += 4;
        }
        parsableByteArray.setPosition(i);
    }

    /* JADX WARN: Code duplicated, block: B:203:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:274:0x0598  */
    /* JADX WARN: Code duplicated, block: B:286:0x05bf  */
    /* JADX WARN: Code duplicated, block: B:292:0x05cc  */
    /* JADX WARN: Code duplicated, block: B:366:0x06d0  */
    /* JADX WARN: Code duplicated, block: B:39:0x009f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0178  */
    public static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, StsdData stsdData, int i5) throws ParserException {
        int unsignedShort;
        int i6;
        int i7;
        int unsignedShort2;
        int i8;
        int i9;
        int i10;
        int i11;
        DrmInitData drmInitDataCopyWithSchemeType;
        String str2;
        int i12;
        int i13;
        int i14;
        int i15;
        int pcmEncoding;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        boolean bit;
        int bits;
        int bits2;
        int i24;
        int i25;
        boolean z2;
        boolean bit2;
        int i26;
        int bits3;
        String str3;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int iIntValue = i;
        int i27 = i3;
        int[] iArr = AacUtil.CHANNEL_COUNT_BY_ACMOD;
        int[] iArr2 = AacUtil.SAMPLE_RATE_BY_FSCOD;
        parsableByteArray2.setPosition(i2 + 16);
        if (z) {
            unsignedShort = parsableByteArray2.readUnsignedShort();
            parsableByteArray2.skipBytes(6);
        } else {
            parsableByteArray2.skipBytes(8);
            unsignedShort = 0;
        }
        if (unsignedShort == 0 || unsignedShort == 1) {
            i6 = 2;
            i7 = 4;
            unsignedShort2 = parsableByteArray2.readUnsignedShort();
            parsableByteArray2.skipBytes(6);
            int unsignedFixedPoint1616 = parsableByteArray2.readUnsignedFixedPoint1616();
            parsableByteArray2.setPosition(parsableByteArray2.position - 4);
            i8 = parsableByteArray2.readInt();
            if (unsignedShort == 1) {
                parsableByteArray2.skipBytes(16);
            }
            i9 = unsignedFixedPoint1616;
            i10 = -1;
        } else {
            if (unsignedShort != 2) {
                return;
            }
            parsableByteArray2.skipBytes(16);
            i6 = 2;
            int iRound = (int) Math.round(Double.longBitsToDouble(parsableByteArray2.readLong()));
            int unsignedIntToInt = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray2.skipBytes(4);
            i7 = 4;
            int unsignedIntToInt2 = parsableByteArray2.readUnsignedIntToInt();
            int unsignedIntToInt3 = parsableByteArray2.readUnsignedIntToInt();
            boolean z3 = (unsignedIntToInt3 & 1) != 0;
            boolean z4 = (unsignedIntToInt3 & 2) != 0;
            if (z3) {
                if (z4 || unsignedIntToInt2 != 32) {
                    i10 = -1;
                } else {
                    i10 = 4;
                }
            } else if (unsignedIntToInt2 == 8) {
                i10 = 3;
            } else if (unsignedIntToInt2 == 16) {
                i10 = z4 ? WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE : 2;
            } else if (unsignedIntToInt2 == 24) {
                i10 = z4 ? 1342177280 : 21;
            } else if (unsignedIntToInt2 == 32) {
                i10 = z4 ? 1610612736 : 22;
            } else {
                i10 = -1;
            }
            parsableByteArray2.skipBytes(8);
            i9 = iRound;
            unsignedShort2 = unsignedIntToInt;
            i8 = 0;
        }
        if (iIntValue == 1767992678) {
            unsignedShort2 = -1;
            i9 = -1;
        } else {
            if (iIntValue != 1935764850) {
                i11 = iIntValue == 1935767394 ? VibraSignature.REQUIRED_SAMPLE_RATE : 8000;
            }
            i9 = i11;
            unsignedShort2 = 1;
        }
        int i28 = parsableByteArray2.position;
        if (iIntValue == 1701733217) {
            Pair sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray2, i2, i27);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitData == null ? null : drmInitData.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                ((TrackEncryptionBox[]) stsdData.trackEncryptionBoxes)[i5] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            } else {
                drmInitDataCopyWithSchemeType = drmInitData;
            }
            parsableByteArray2.setPosition(i28);
        } else {
            drmInitDataCopyWithSchemeType = drmInitData;
        }
        String str4 = "audio/mhm1";
        if (iIntValue == 1633889587) {
            str2 = "audio/ac3";
        } else if (iIntValue == 1700998451) {
            str2 = "audio/eac3";
        } else if (iIntValue == 1633889588) {
            str2 = "audio/ac4";
        } else if (iIntValue == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (iIntValue == 1685353320 || iIntValue == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (iIntValue == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (iIntValue == 1685353336) {
            str2 = "audio/vnd.dts.uhd;profile=p2";
        } else if (iIntValue == 1935764850) {
            str2 = "audio/3gpp";
        } else if (iIntValue == 1935767394) {
            str2 = "audio/amr-wb";
        } else if (iIntValue == 1936684916) {
            i10 = i6;
            str2 = "audio/raw";
        } else if (iIntValue == 1953984371) {
            str2 = "audio/raw";
            i10 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        } else if (iIntValue == 1819304813) {
            if (i10 == -1) {
                i10 = i6;
            }
            str2 = "audio/raw";
        } else if (iIntValue == 778924082 || iIntValue == 778924083) {
            str2 = "audio/mpeg";
        } else if (iIntValue == 1835557169) {
            str2 = "audio/mha1";
        } else if (iIntValue == 1835560241) {
            str2 = "audio/mhm1";
        } else if (iIntValue == 1634492771) {
            str2 = "audio/alac";
        } else if (iIntValue == 1634492791) {
            str2 = "audio/g711-alaw";
        } else if (iIntValue == 1970037111) {
            str2 = "audio/g711-mlaw";
        } else if (iIntValue == 1332770163) {
            str2 = "audio/opus";
        } else if (iIntValue == 1716281667) {
            str2 = "audio/flac";
        } else if (iIntValue == 1835823201) {
            str2 = "audio/true-hd";
        } else {
            str2 = iIntValue == 1767992678 ? "audio/iamf" : null;
        }
        RealStrongMemoryCache$cache$1 esdsFromParent = null;
        String strM = null;
        List listOf = null;
        EocdRecord eocdRecord = null;
        while (i28 - i2 < i27) {
            parsableByteArray2.setPosition(i28);
            int i29 = parsableByteArray2.readInt();
            int i30 = i10;
            AacUtil.checkContainerInput("childAtomSize must be positive", i29 > 0);
            int i31 = parsableByteArray2.readInt();
            strM = strM;
            if (i31 == 1835557187) {
                parsableByteArray2.setPosition(i28 + 8);
                parsableByteArray2.skipBytes(1);
                int unsignedByte = parsableByteArray2.readUnsignedByte();
                parsableByteArray2.skipBytes(1);
                String str5 = Objects.equals(str2, str4) ? String.format("mhm1.%02X", Integer.valueOf(unsignedByte)) : String.format("mha1.%02X", Integer.valueOf(unsignedByte));
                int unsignedShort3 = parsableByteArray2.readUnsignedShort();
                byte[] bArr = new byte[unsignedShort3];
                String str6 = str5;
                parsableByteArray2.readBytes(bArr, 0, unsignedShort3);
                strM = str6;
                listOf = listOf == null ? ImmutableList.of((Object) bArr) : ImmutableList.of((Object) bArr, listOf.get(0));
            } else if (i31 == 1835557200) {
                parsableByteArray2.setPosition(i28 + 8);
                int unsignedByte2 = parsableByteArray2.readUnsignedByte();
                if (unsignedByte2 > 0) {
                    byte[] bArr2 = new byte[unsignedByte2];
                    parsableByteArray2.readBytes(bArr2, 0, unsignedByte2);
                    listOf = listOf == null ? ImmutableList.of((Object) bArr2) : ImmutableList.of(listOf.get(0), (Object) bArr2);
                }
                listOf = listOf;
                strM = strM;
            } else {
                if (i31 == 1702061171 || (z && i31 == 2002876005)) {
                    String str7 = str2;
                    listOf = listOf;
                    int i32 = i29;
                    int i33 = i28;
                    int i34 = unsignedShort2;
                    str4 = str4;
                    i12 = iIntValue;
                    if (i31 == 1702061171) {
                        i14 = i32;
                        i13 = i33;
                        i28 = i13;
                    } else {
                        i13 = parsableByteArray2.position;
                        i28 = i33;
                        AacUtil.checkContainerInput(null, i13 >= i28);
                        while (true) {
                            i14 = i32;
                            if (i13 - i28 < i14) {
                                parsableByteArray2.setPosition(i13);
                                int i35 = parsableByteArray2.readInt();
                                AacUtil.checkContainerInput("childAtomSize must be positive", i35 > 0);
                                if (parsableByteArray2.readInt() != 1702061171) {
                                    i13 += i35;
                                    i32 = i14;
                                }
                            } else {
                                i13 = -1;
                            }
                        }
                    }
                    if (i13 != -1) {
                        esdsFromParent = parseEsdsFromParent(i13, parsableByteArray2);
                        String str8 = (String) esdsFromParent.map;
                        byte[] bArr3 = (byte[]) esdsFromParent.this$0;
                        if (bArr3 == null) {
                            i29 = i14;
                        } else if ("audio/vorbis".equals(str8)) {
                            ParsableByteArray parsableByteArray3 = new ParsableByteArray(bArr3);
                            parsableByteArray3.skipBytes(1);
                            int i36 = 0;
                            while (parsableByteArray3.bytesLeft() > 0 && parsableByteArray3.peekUnsignedByte() == 255) {
                                i36 += 255;
                                parsableByteArray3.skipBytes(1);
                            }
                            int unsignedByte3 = parsableByteArray3.readUnsignedByte() + i36;
                            int i37 = 0;
                            while (true) {
                                if (parsableByteArray3.bytesLeft() > 0) {
                                    i29 = i14;
                                    if (parsableByteArray3.peekUnsignedByte() == 255) {
                                        i37 += 255;
                                        parsableByteArray3.skipBytes(1);
                                        i14 = i29;
                                    }
                                } else {
                                    i29 = i14;
                                }
                            }
                            int unsignedByte4 = parsableByteArray3.readUnsignedByte() + i37;
                            byte[] bArr4 = new byte[unsignedByte3];
                            int i38 = parsableByteArray3.position;
                            System.arraycopy(bArr3, i38, bArr4, 0, unsignedByte3);
                            int i39 = i38 + unsignedByte3 + unsignedByte4;
                            int length = bArr3.length - i39;
                            byte[] bArr5 = new byte[length];
                            System.arraycopy(bArr3, i39, bArr5, 0, length);
                            listOf = ImmutableList.of((Object) bArr4, (Object) bArr5);
                        } else {
                            i29 = i14;
                            if ("audio/mp4a-latm".equals(str8)) {
                                NavOptions.Builder audioSpecificConfig = AacUtil.parseAudioSpecificConfig(new VorbisBitArray(bArr3, bArr3.length), false);
                                i9 = audioSpecificConfig.enterAnim;
                                unsignedShort2 = audioSpecificConfig.exitAnim;
                                strM = audioSpecificConfig.popUpToRoute;
                            } else {
                                unsignedShort2 = i34;
                                strM = strM;
                            }
                            listOf = ImmutableList.of((Object) bArr3);
                            str2 = str8;
                        }
                        str2 = str8;
                        unsignedShort2 = i34;
                        strM = strM;
                    } else {
                        i29 = i14;
                        esdsFromParent = esdsFromParent;
                        unsignedShort2 = i34;
                        strM = strM;
                        str2 = str7;
                    }
                } else if (i31 == 1651798644) {
                    parsableByteArray2.setPosition(i28 + 8);
                    parsableByteArray2.skipBytes(i7);
                    eocdRecord = new EocdRecord(parsableByteArray2.readUnsignedInt(), parsableByteArray2.readUnsignedInt());
                    listOf = listOf;
                    strM = strM;
                    str2 = str2;
                } else {
                    str2 = str2;
                    str4 = str4;
                    if (i31 == 1684103987) {
                        parsableByteArray2.setPosition(i28 + 8);
                        String string = Integer.toString(i4);
                        VorbisBitArray vorbisBitArray = new VorbisBitArray();
                        vorbisBitArray.reset(parsableByteArray2);
                        int i40 = iArr2[vorbisBitArray.readBits(i6)];
                        vorbisBitArray.skipBits(8);
                        int i41 = iArr[vorbisBitArray.readBits(3)];
                        if (vorbisBitArray.readBits(1) != 0) {
                            i41++;
                        }
                        int i42 = AacUtil.BITRATE_BY_HALF_FRMSIZECOD[vorbisBitArray.readBits(5)] * CIOKt.DEFAULT_HTTP_POOL_SIZE;
                        vorbisBitArray.byteAlign();
                        parsableByteArray2.setPosition(vorbisBitArray.getBytePosition());
                        Format.Builder builder = new Format.Builder();
                        builder.id = string;
                        builder.sampleMimeType = MimeTypes.normalizeMimeType("audio/ac3");
                        builder.channelCount = i41;
                        builder.sampleRate = i40;
                        builder.drmInitData = drmInitDataCopyWithSchemeType;
                        builder.language = str;
                        builder.averageBitrate = i42;
                        builder.peakBitrate = i42;
                        stsdData.format = new Format(builder);
                        listOf = listOf;
                        i29 = i29;
                        i28 = i28;
                        i15 = unsignedShort2;
                        i12 = iIntValue;
                    } else if (i31 == 1684366131) {
                        parsableByteArray2.setPosition(i28 + 8);
                        String string2 = Integer.toString(i4);
                        VorbisBitArray vorbisBitArray2 = new VorbisBitArray();
                        vorbisBitArray2.reset(parsableByteArray2);
                        int bits4 = vorbisBitArray2.readBits(13) * CIOKt.DEFAULT_HTTP_POOL_SIZE;
                        vorbisBitArray2.skipBits(3);
                        int i43 = iArr2[vorbisBitArray2.readBits(2)];
                        vorbisBitArray2.skipBits(10);
                        int i44 = iArr[vorbisBitArray2.readBits(3)];
                        if (vorbisBitArray2.readBits(1) != 0) {
                            i44++;
                        }
                        int i45 = i44;
                        vorbisBitArray2.skipBits(3);
                        int bits5 = vorbisBitArray2.readBits(4);
                        vorbisBitArray2.skipBits(1);
                        if (bits5 > 0) {
                            vorbisBitArray2.skipBits(6);
                            if (vorbisBitArray2.readBits(1) != 0) {
                                i45 += 2;
                            }
                            vorbisBitArray2.skipBits(1);
                        }
                        int i46 = i45;
                        i29 = i29;
                        if (vorbisBitArray2.bitsLeft() > 7) {
                            vorbisBitArray2.skipBits(7);
                            if (vorbisBitArray2.readBits(1) != 0) {
                                str3 = "audio/eac3-joc";
                            } else {
                                str3 = "audio/eac3";
                            }
                        } else {
                            str3 = "audio/eac3";
                        }
                        vorbisBitArray2.byteAlign();
                        parsableByteArray2.setPosition(vorbisBitArray2.getBytePosition());
                        Format.Builder builder2 = new Format.Builder();
                        builder2.id = string2;
                        builder2.sampleMimeType = MimeTypes.normalizeMimeType(str3);
                        builder2.channelCount = i46;
                        builder2.sampleRate = i43;
                        builder2.drmInitData = drmInitDataCopyWithSchemeType;
                        builder2.language = str;
                        builder2.peakBitrate = bits4;
                        stsdData.format = new Format(builder2);
                        i12 = iIntValue;
                        i15 = unsignedShort2;
                    } else {
                        listOf = listOf;
                        i29 = i29;
                        if (i31 == 1684103988) {
                            parsableByteArray2.setPosition(i28 + 8);
                            String string3 = Integer.toString(i4);
                            VorbisBitArray vorbisBitArray3 = new VorbisBitArray();
                            vorbisBitArray3.reset(parsableByteArray2);
                            int iBitsLeft = vorbisBitArray3.bitsLeft();
                            int bits6 = vorbisBitArray3.readBits(3);
                            if (bits6 > 1) {
                                throw ParserException.createForUnsupportedContainerFeature("Unsupported AC-4 DSI version: " + bits6);
                            }
                            int bits7 = vorbisBitArray3.readBits(7);
                            int i47 = vorbisBitArray3.readBit() ? 48000 : 44100;
                            vorbisBitArray3.skipBits(4);
                            int bits8 = vorbisBitArray3.readBits(9);
                            if (bits7 > 1) {
                                if (bits6 == 0) {
                                    throw ParserException.createForUnsupportedContainerFeature("Invalid AC-4 DSI version: " + bits6);
                                }
                                if (vorbisBitArray3.readBit()) {
                                    vorbisBitArray3.skipBits(16);
                                    if (vorbisBitArray3.readBit()) {
                                        vorbisBitArray3.skipBits(128);
                                    }
                                }
                            }
                            if (bits6 == 1) {
                                if (vorbisBitArray3.bitsLeft() < 66) {
                                    throw ParserException.createForUnsupportedContainerFeature("Invalid AC-4 DSI bitrate.");
                                }
                                vorbisBitArray3.skipBits(66);
                                vorbisBitArray3.byteAlign();
                            }
                            Ac4Util$Ac4Presentation ac4Util$Ac4Presentation = new Ac4Util$Ac4Presentation();
                            ac4Util$Ac4Presentation.isChannelCoded = true;
                            ac4Util$Ac4Presentation.channelMode = -1;
                            ac4Util$Ac4Presentation.numOfUmxObjects = -1;
                            ac4Util$Ac4Presentation.hasBackChannels = true;
                            ac4Util$Ac4Presentation.topChannelPairs = 2;
                            ac4Util$Ac4Presentation.version = 1;
                            ac4Util$Ac4Presentation.level = 0;
                            int i48 = 0;
                            while (true) {
                                if (i48 < bits8) {
                                    if (bits6 == 0) {
                                        i19 = i9;
                                        bit = vorbisBitArray3.readBit();
                                        bits = vorbisBitArray3.readBits(5);
                                        bits2 = vorbisBitArray3.readBits(5);
                                        i24 = 0;
                                        i25 = 0;
                                        z2 = false;
                                    } else {
                                        int i49 = bits8;
                                        int bits9 = vorbisBitArray3.readBits(8);
                                        i19 = i9;
                                        int bits10 = vorbisBitArray3.readBits(8);
                                        int bits11 = bits10 == 255 ? vorbisBitArray3.readBits(16) + bits10 : bits10;
                                        if (bits9 > 2) {
                                            vorbisBitArray3.skipBits(bits11 * 8);
                                            i48++;
                                            bits8 = i49;
                                            i9 = i19;
                                        } else {
                                            int iBitsLeft2 = (iBitsLeft - vorbisBitArray3.bitsLeft()) / 8;
                                            int bits12 = vorbisBitArray3.readBits(5);
                                            i25 = iBitsLeft2;
                                            z2 = bits12 == 31;
                                            bit = false;
                                            bits2 = bits9;
                                            bits = bits12;
                                            i24 = bits11;
                                        }
                                    }
                                    ac4Util$Ac4Presentation.version = bits2;
                                    i18 = unsignedShort2;
                                    if (bit || z2 || bits != 6) {
                                        ac4Util$Ac4Presentation.level = vorbisBitArray3.readBits(3);
                                        if (vorbisBitArray3.readBit()) {
                                            vorbisBitArray3.skipBits(5);
                                        }
                                        vorbisBitArray3.skipBits(2);
                                        int i50 = 1;
                                        if (bits6 == 1 && (bits2 == 1 || bits2 == 2)) {
                                            vorbisBitArray3.skipBits(2);
                                        }
                                        vorbisBitArray3.skipBits(5);
                                        vorbisBitArray3.skipBits(10);
                                        if (bits6 == 1) {
                                            if (bits2 > 0) {
                                                ac4Util$Ac4Presentation.isChannelCoded = vorbisBitArray3.readBit();
                                            }
                                            if (ac4Util$Ac4Presentation.isChannelCoded) {
                                                if (bits2 != 1) {
                                                    i26 = 2;
                                                    if (bits2 == 2) {
                                                        bits3 = vorbisBitArray3.readBits(5);
                                                        if (bits3 >= 0 && bits3 <= 15) {
                                                            ac4Util$Ac4Presentation.channelMode = bits3;
                                                        }
                                                        if (bits3 >= 11 || bits3 > 14) {
                                                            i26 = 2;
                                                        } else {
                                                            ac4Util$Ac4Presentation.hasBackChannels = vorbisBitArray3.readBit();
                                                            i26 = 2;
                                                            ac4Util$Ac4Presentation.topChannelPairs = vorbisBitArray3.readBits(2);
                                                        }
                                                    }
                                                } else {
                                                    bits3 = vorbisBitArray3.readBits(5);
                                                    if (bits3 >= 0) {
                                                        ac4Util$Ac4Presentation.channelMode = bits3;
                                                    }
                                                    if (bits3 >= 11) {
                                                        i26 = 2;
                                                    } else {
                                                        i26 = 2;
                                                    }
                                                }
                                                vorbisBitArray3.skipBits(24);
                                                i50 = 1;
                                            } else {
                                                i26 = 2;
                                            }
                                            if (bits2 == i50 || bits2 == i26) {
                                                if (vorbisBitArray3.readBit() && vorbisBitArray3.readBit()) {
                                                    vorbisBitArray3.skipBits(i26);
                                                }
                                                if (vorbisBitArray3.readBit()) {
                                                    vorbisBitArray3.skipBit();
                                                    int i51 = 8;
                                                    int bits13 = vorbisBitArray3.readBits(8);
                                                    int i52 = 0;
                                                    while (i52 < bits13) {
                                                        vorbisBitArray3.skipBits(i51);
                                                        i52++;
                                                        i51 = 8;
                                                    }
                                                }
                                            }
                                        }
                                        if (!bit && !z2) {
                                            vorbisBitArray3.skipBit();
                                            if (bits == 0 || bits == 1 || bits == 2) {
                                                if (bits2 == 0) {
                                                    for (int i53 = 0; i53 < 2; i53++) {
                                                        AacUtil.parseDsiSubstream(vorbisBitArray3, ac4Util$Ac4Presentation);
                                                    }
                                                } else {
                                                    for (int i54 = 0; i54 < 2; i54++) {
                                                        AacUtil.parseDsiSubstreamGroup(vorbisBitArray3, ac4Util$Ac4Presentation);
                                                    }
                                                }
                                            } else if (bits == 3 || bits == 4) {
                                                if (bits2 == 0) {
                                                    for (int i55 = 0; i55 < 3; i55++) {
                                                        AacUtil.parseDsiSubstream(vorbisBitArray3, ac4Util$Ac4Presentation);
                                                    }
                                                } else {
                                                    for (int i56 = 0; i56 < 3; i56++) {
                                                        AacUtil.parseDsiSubstreamGroup(vorbisBitArray3, ac4Util$Ac4Presentation);
                                                    }
                                                }
                                            } else if (bits != 5) {
                                                int bits14 = vorbisBitArray3.readBits(7);
                                                for (int i57 = 0; i57 < bits14; i57++) {
                                                    vorbisBitArray3.skipBits(8);
                                                }
                                            } else if (bits2 == 0) {
                                                AacUtil.parseDsiSubstream(vorbisBitArray3, ac4Util$Ac4Presentation);
                                            } else {
                                                int bits15 = vorbisBitArray3.readBits(3);
                                                for (int i58 = 0; i58 < bits15 + 2; i58++) {
                                                    AacUtil.parseDsiSubstreamGroup(vorbisBitArray3, ac4Util$Ac4Presentation);
                                                }
                                            }
                                        } else if (bits2 == 0) {
                                            AacUtil.parseDsiSubstream(vorbisBitArray3, ac4Util$Ac4Presentation);
                                        } else {
                                            AacUtil.parseDsiSubstreamGroup(vorbisBitArray3, ac4Util$Ac4Presentation);
                                        }
                                        vorbisBitArray3.skipBit();
                                        bit2 = vorbisBitArray3.readBit();
                                    } else {
                                        bits2 = bits2;
                                        bit2 = true;
                                    }
                                    if (bit2) {
                                        int bits16 = vorbisBitArray3.readBits(7);
                                        for (int i59 = 0; i59 < bits16; i59++) {
                                            vorbisBitArray3.skipBits(15);
                                        }
                                    }
                                    if (bits2 <= 0) {
                                        i20 = 8;
                                    } else {
                                        if (vorbisBitArray3.readBit()) {
                                            if (vorbisBitArray3.bitsLeft() < 66) {
                                                throw ParserException.createForUnsupportedContainerFeature("Can't parse bitrate DSI.");
                                            }
                                            vorbisBitArray3.skipBits(66);
                                        }
                                        if (vorbisBitArray3.readBit()) {
                                            vorbisBitArray3.byteAlign();
                                            vorbisBitArray3.skipBytes(vorbisBitArray3.readBits(16));
                                            int bits17 = vorbisBitArray3.readBits(5);
                                            for (int i60 = 0; i60 < bits17; i60++) {
                                                vorbisBitArray3.skipBits(3);
                                                vorbisBitArray3.skipBits(8);
                                            }
                                            i20 = 8;
                                        } else {
                                            i20 = 8;
                                        }
                                    }
                                    vorbisBitArray3.byteAlign();
                                    if (bits6 == 1) {
                                        int iBitsLeft3 = ((iBitsLeft - vorbisBitArray3.bitsLeft()) / 8) - i25;
                                        if (i24 < iBitsLeft3) {
                                            throw ParserException.createForUnsupportedContainerFeature("pres_bytes is smaller than presentation bytes read.");
                                        }
                                        vorbisBitArray3.skipBytes(i24 - iBitsLeft3);
                                    }
                                    if (ac4Util$Ac4Presentation.isChannelCoded && ac4Util$Ac4Presentation.channelMode == -1) {
                                        throw ParserException.createForUnsupportedContainerFeature("Can't determine channel mode of presentation " + i48);
                                    }
                                } else {
                                    iIntValue = iIntValue;
                                    i18 = unsignedShort2;
                                    i19 = i9;
                                    i20 = 8;
                                }
                                if (ac4Util$Ac4Presentation.isChannelCoded) {
                                    int i61 = ac4Util$Ac4Presentation.channelMode;
                                    boolean z5 = ac4Util$Ac4Presentation.hasBackChannels;
                                    int i62 = ac4Util$Ac4Presentation.topChannelPairs;
                                    switch (i61) {
                                        case 0:
                                            i22 = 11;
                                            i23 = 1;
                                            break;
                                        case 1:
                                            i22 = 11;
                                            i23 = 2;
                                            break;
                                        case 2:
                                            i22 = 11;
                                            i23 = 3;
                                            break;
                                        case 3:
                                            i22 = 11;
                                            i23 = 5;
                                            break;
                                        case 4:
                                            i22 = 11;
                                            i23 = 6;
                                            break;
                                        case 5:
                                        case 7:
                                        case 9:
                                            i22 = 11;
                                            i23 = 7;
                                            break;
                                        case 6:
                                        case 8:
                                        case 10:
                                            i23 = i20;
                                            i22 = 11;
                                            break;
                                        case 11:
                                            i22 = 11;
                                            i23 = 11;
                                            break;
                                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                                            i23 = 12;
                                            i22 = 11;
                                            break;
                                        case 13:
                                            i22 = 11;
                                            i23 = 13;
                                            break;
                                        case 14:
                                            i22 = 11;
                                            i23 = 14;
                                            break;
                                        case 15:
                                            i22 = 11;
                                            i23 = 24;
                                            break;
                                        default:
                                            i22 = 11;
                                            i23 = -1;
                                            break;
                                    }
                                    if (i61 == i22 || i61 == 12 || i61 == 13 || i61 == 14) {
                                        if (!z5) {
                                            i23 -= 2;
                                        }
                                        if (i62 == 0) {
                                            i23 -= 4;
                                        } else if (i62 == 1) {
                                            i23 -= 2;
                                        }
                                    }
                                    i21 = i23;
                                } else {
                                    int i63 = ac4Util$Ac4Presentation.numOfUmxObjects;
                                    int i64 = ac4Util$Ac4Presentation.level;
                                    if (i63 > 0) {
                                        i21 = i63 + 1;
                                        if (i64 == 4 && i21 == 17) {
                                            i21 = 21;
                                        }
                                    } else if (i64 == 0) {
                                        i21 = 2;
                                    } else if (i64 == 1) {
                                        i21 = 6;
                                    } else if (i64 == 2) {
                                        i21 = i20;
                                    } else if (i64 == 3) {
                                        i21 = 10;
                                    } else if (i64 != 4) {
                                        Log.w("Ac4Util", "AC-4 level " + ac4Util$Ac4Presentation.level + " has not been defined.");
                                        i21 = 2;
                                    } else {
                                        i21 = 12;
                                    }
                                }
                                if (i21 <= 0) {
                                    throw ParserException.createForUnsupportedContainerFeature("Cannot determine channel count of presentation.");
                                }
                                Object[] objArr = {Integer.valueOf(bits7), Integer.valueOf(ac4Util$Ac4Presentation.version), Integer.valueOf(ac4Util$Ac4Presentation.level)};
                                String str9 = Util.DEVICE_DEBUG_INFO;
                                String str10 = String.format(Locale.US, "ac-4.%02d.%02d.%02d", objArr);
                                Format.Builder builder3 = new Format.Builder();
                                builder3.id = string3;
                                builder3.sampleMimeType = MimeTypes.normalizeMimeType("audio/ac4");
                                builder3.channelCount = i21;
                                builder3.sampleRate = i47;
                                builder3.drmInitData = drmInitDataCopyWithSchemeType;
                                builder3.language = str;
                                builder3.codecs = str10;
                                stsdData.format = new Format(builder3);
                                i9 = i19;
                                i15 = i18;
                                i12 = iIntValue;
                            }
                        } else {
                            i12 = iIntValue;
                            i28 = i28;
                            int i65 = unsignedShort2;
                            int i66 = i9;
                            if (i31 == 1684892784) {
                                if (i8 <= 0) {
                                    throw ParserException.createForMalformedContainer(null, "Invalid sample rate for Dolby TrueHD MLP stream: " + i8);
                                }
                                i9 = i8;
                                unsignedShort2 = 2;
                            } else if (i31 == 1684305011 || i31 == 1969517683) {
                                i12 = i12;
                                Format.Builder builder4 = new Format.Builder();
                                builder4.id = Integer.toString(i4);
                                builder4.sampleMimeType = MimeTypes.normalizeMimeType(str2);
                                i15 = i65;
                                builder4.channelCount = i15;
                                i9 = i66;
                                builder4.sampleRate = i9;
                                builder4.drmInitData = drmInitDataCopyWithSchemeType;
                                builder4.language = str;
                                stsdData.format = new Format(builder4);
                            } else if (i31 == 1682927731) {
                                int i67 = i29 - 8;
                                byte[] bArr6 = opusMagic;
                                byte[] bArrCopyOf = Arrays.copyOf(bArr6, bArr6.length + i67);
                                parsableByteArray2.setPosition(i28 + 8);
                                parsableByteArray2.readBytes(bArrCopyOf, bArr6.length, i67);
                                listOf = OpusUtil.buildInitializationData(bArrCopyOf);
                                i9 = i66;
                                unsignedShort2 = i65;
                            } else {
                                if (i31 == 1684425825) {
                                    byte[] bArr7 = new byte[i29 - 8];
                                    bArr7[0] = 102;
                                    bArr7[1] = 76;
                                    bArr7[2] = 97;
                                    bArr7[3] = 67;
                                    parsableByteArray2.setPosition(i28 + 12);
                                    parsableByteArray2.readBytes(bArr7, 4, i29 - 12);
                                    listOf = ImmutableList.of((Object) bArr7);
                                    strM = strM;
                                } else if (i31 == 1634492771) {
                                    int i68 = i29 - 12;
                                    byte[] bArr8 = new byte[i68];
                                    parsableByteArray2.setPosition(i28 + 12);
                                    parsableByteArray2.readBytes(bArr8, 0, i68);
                                    byte[] bArr9 = CodecSpecificDataUtil.NAL_START_CODE;
                                    ParsableByteArray parsableByteArray4 = new ParsableByteArray(bArr8);
                                    parsableByteArray4.setPosition(5);
                                    int unsignedByte5 = parsableByteArray4.readUnsignedByte();
                                    parsableByteArray4.setPosition(9);
                                    int unsignedByte6 = parsableByteArray4.readUnsignedByte();
                                    parsableByteArray4.setPosition(20);
                                    int[] iArr3 = {parsableByteArray4.readUnsignedIntToInt(), unsignedByte6, unsignedByte5};
                                    int i69 = iArr3[0];
                                    int i70 = iArr3[1];
                                    int i71 = iArr3[2];
                                    String str11 = Util.DEVICE_DEBUG_INFO;
                                    int pcmEncoding2 = Util.getPcmEncoding(i71, ByteOrder.LITTLE_ENDIAN);
                                    listOf = ImmutableList.of((Object) bArr8);
                                    i30 = pcmEncoding2;
                                    i9 = i69;
                                    unsignedShort2 = i70;
                                    strM = strM;
                                    str2 = str2;
                                    i28 = i28;
                                    i12 = i12;
                                    esdsFromParent = esdsFromParent;
                                } else if (i31 == 1767990114) {
                                    parsableByteArray2.setPosition(i28 + 9);
                                    int unsignedLeb128ToInt = parsableByteArray2.readUnsignedLeb128ToInt();
                                    byte[] bArr10 = new byte[unsignedLeb128ToInt];
                                    parsableByteArray2.readBytes(bArr10, 0, unsignedLeb128ToInt);
                                    byte[] bArr11 = CodecSpecificDataUtil.NAL_START_CODE;
                                    ParsableByteArray parsableByteArray5 = new ParsableByteArray(bArr10);
                                    String str12 = null;
                                    String string4 = null;
                                    while (parsableByteArray5.bytesLeft() > 0 && (str12 == null || string4 == null)) {
                                        int unsignedByte7 = parsableByteArray5.readUnsignedByte();
                                        int i72 = unsignedByte7 >> 3;
                                        boolean z6 = (unsignedByte7 & 2) != 0;
                                        boolean z7 = (unsignedByte7 & 1) != 0;
                                        int unsignedLeb128ToInt2 = parsableByteArray5.readUnsignedLeb128ToInt();
                                        if (i72 > 4 && i72 < 24 && z6) {
                                            do {
                                            } while ((parsableByteArray5.readUnsignedByte() & 128) != 0);
                                            for (i17 = 128; (parsableByteArray5.readUnsignedByte() & i17) != 0; i17 = 128) {
                                            }
                                        }
                                        if (z7) {
                                            parsableByteArray5.skipBytes(parsableByteArray5.readUnsignedLeb128ToInt());
                                        }
                                        int i73 = parsableByteArray5.position + unsignedLeb128ToInt2;
                                        if (i72 == 31) {
                                            parsableByteArray5.skipBytes(4);
                                            Object[] objArr2 = {Integer.valueOf(parsableByteArray5.readUnsignedByte()), Integer.valueOf(parsableByteArray5.readUnsignedByte())};
                                            String str13 = Util.DEVICE_DEBUG_INFO;
                                            str12 = String.format(Locale.US, "iamf.%03X.%03X", objArr2);
                                        } else {
                                            if (i72 == 0) {
                                                while ((parsableByteArray5.readUnsignedByte() & 128) != 0) {
                                                }
                                                string4 = parsableByteArray5.readString(4, StandardCharsets.UTF_8);
                                                if (string4.equals("mp4a")) {
                                                    while ((parsableByteArray5.readUnsignedByte() & 128) != 0) {
                                                    }
                                                    parsableByteArray5.skipBytes(2);
                                                    VorbisBitArray vorbisBitArray4 = new VorbisBitArray();
                                                    vorbisBitArray4.reset(parsableByteArray5);
                                                    int bits18 = vorbisBitArray4.readBits(5);
                                                    if (bits18 == 31) {
                                                        bits18 = vorbisBitArray4.readBits(6) + 32;
                                                    }
                                                    string4 = string4 + ".40." + bits18;
                                                }
                                            }
                                            parsableByteArray5.setPosition(i73);
                                        }
                                        parsableByteArray5.setPosition(i73);
                                    }
                                    strM = (str12 == null || string4 == null) ? null : IntIntPair$$ExternalSyntheticOutline0.m(str12, ".", string4);
                                    listOf = ImmutableList.of((Object) bArr10);
                                } else if (i31 == 1885564227) {
                                    parsableByteArray2.setPosition(i28 + 12);
                                    ByteOrder byteOrder = (parsableByteArray2.readUnsignedByte() & 1) != 0 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
                                    int unsignedByte8 = parsableByteArray2.readUnsignedByte();
                                    i12 = i12;
                                    if (i12 == 1768973165) {
                                        pcmEncoding = Util.getPcmEncoding(unsignedByte8, byteOrder);
                                        i16 = -1;
                                    } else {
                                        pcmEncoding = (i12 == 1718641517 && unsignedByte8 == 32 && byteOrder.equals(ByteOrder.LITTLE_ENDIAN)) ? 4 : i30;
                                        i16 = -1;
                                    }
                                    esdsFromParent = esdsFromParent;
                                    i30 = pcmEncoding;
                                    strM = strM;
                                    str2 = pcmEncoding != i16 ? "audio/raw" : str2;
                                    i28 = i28;
                                    i9 = i66;
                                    unsignedShort2 = i65;
                                } else {
                                    i12 = i12;
                                    i9 = i66;
                                    i15 = i65;
                                }
                                str2 = str2;
                                i28 = i28;
                                i9 = i66;
                                unsignedShort2 = i65;
                                i12 = i12;
                            }
                        }
                    }
                    esdsFromParent = esdsFromParent;
                    unsignedShort2 = i15;
                    strM = strM;
                    str2 = str2;
                    i28 = i28;
                }
                i28 += i29;
                i7 = 4;
                i6 = 2;
                parsableByteArray2 = parsableByteArray;
                i27 = i3;
                iIntValue = i12;
                esdsFromParent = esdsFromParent;
                i10 = i30;
                str4 = str4;
                listOf = listOf;
            }
            esdsFromParent = esdsFromParent;
            i12 = iIntValue;
            i28 += i29;
            i7 = 4;
            i6 = 2;
            parsableByteArray2 = parsableByteArray;
            i27 = i3;
            iIntValue = i12;
            esdsFromParent = esdsFromParent;
            i10 = i30;
            str4 = str4;
            listOf = listOf;
        }
        String str14 = strM;
        String str15 = str2;
        List list = listOf;
        int i74 = unsignedShort2;
        int i75 = i10;
        if (((Format) stsdData.format) != null || str15 == null) {
            return;
        }
        Format.Builder builder5 = new Format.Builder();
        builder5.id = Integer.toString(i4);
        builder5.sampleMimeType = MimeTypes.normalizeMimeType(str15);
        builder5.codecs = str14;
        builder5.channelCount = i74;
        builder5.sampleRate = i9;
        builder5.pcmEncoding = i75;
        builder5.initializationData = list;
        builder5.drmInitData = drmInitDataCopyWithSchemeType;
        builder5.language = str;
        if (esdsFromParent != null) {
            RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = esdsFromParent;
            builder5.averageBitrate = StringsKt__IndentKt.saturatedCast(realStrongMemoryCache$cache$1.maxSize);
            builder5.peakBitrate = StringsKt__IndentKt.saturatedCast(realStrongMemoryCache$cache$1.size);
        } else {
            EocdRecord eocdRecord2 = eocdRecord;
            if (eocdRecord2 != null) {
                builder5.averageBitrate = StringsKt__IndentKt.saturatedCast(eocdRecord2.entryCount);
                builder5.peakBitrate = StringsKt__IndentKt.saturatedCast(eocdRecord2.centralDirectoryOffset);
            }
        }
        stsdData.format = new Format(builder5);
    }

    public static RealStrongMemoryCache$cache$1 parseEsdsFromParent(int i, ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(i + 12);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        if ((unsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((unsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedByte());
        }
        if ((unsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if ("audio/mpeg".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts.hd".equals(mimeTypeFromMp4ObjectType)) {
            return new RealStrongMemoryCache$cache$1(mimeTypeFromMp4ObjectType, null, -1L, -1L);
        }
        parsableByteArray.skipBytes(4);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        long unsignedInt2 = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(1);
        int expandableClassSize = parseExpandableClassSize(parsableByteArray);
        long j = unsignedInt2;
        byte[] bArr = new byte[expandableClassSize];
        parsableByteArray.readBytes(bArr, 0, expandableClassSize);
        if (j <= 0) {
            j = -1;
        }
        return new RealStrongMemoryCache$cache$1(mimeTypeFromMp4ObjectType, bArr, j, unsignedInt > 0 ? unsignedInt : -1L);
    }

    public static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i = unsignedByte & 127;
        while ((unsignedByte & 128) == 128) {
            unsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (unsignedByte & 127);
        }
        return i;
    }

    public static int parseFullBoxVersion(int i) {
        return (i >> 24) & 255;
    }

    public static Metadata parseMdtaFromMeta(Mp4Box$ContainerBox mp4Box$ContainerBox) {
        MdtaMetadataEntry mdtaMetadataEntry;
        Mp4Box$LeafBox leafBoxOfType = mp4Box$ContainerBox.getLeafBoxOfType(1751411826);
        Mp4Box$LeafBox leafBoxOfType2 = mp4Box$ContainerBox.getLeafBoxOfType(1801812339);
        Mp4Box$LeafBox leafBoxOfType3 = mp4Box$ContainerBox.getLeafBoxOfType(1768715124);
        if (leafBoxOfType == null || leafBoxOfType2 == null || leafBoxOfType3 == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafBoxOfType.data;
        parsableByteArray.setPosition(16);
        if (parsableByteArray.readInt() != 1835299937) {
            return null;
        }
        ParsableByteArray parsableByteArray2 = leafBoxOfType2.data;
        parsableByteArray2.setPosition(12);
        int i = parsableByteArray2.readInt();
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = parsableByteArray2.readInt();
            parsableByteArray2.skipBytes(4);
            strArr[i2] = parsableByteArray2.readString(i3 - 8, StandardCharsets.UTF_8);
        }
        ParsableByteArray parsableByteArray3 = leafBoxOfType3.data;
        parsableByteArray3.setPosition(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray3.bytesLeft() > 8) {
            int i4 = parsableByteArray3.position;
            int i5 = parsableByteArray3.readInt();
            int i6 = parsableByteArray3.readInt() - 1;
            if (i6 < 0 || i6 >= i) {
                Format$$ExternalSyntheticOutline0.m(i6, "Skipped metadata with unknown key index: ", "BoxParsers");
            } else {
                String str = strArr[i6];
                int i7 = i4 + i5;
                while (true) {
                    int i8 = parsableByteArray3.position;
                    if (i8 < i7) {
                        int i9 = parsableByteArray3.readInt();
                        if (parsableByteArray3.readInt() == 1684108385) {
                            int i10 = parsableByteArray3.readInt();
                            int i11 = parsableByteArray3.readInt();
                            int i12 = i9 - 16;
                            byte[] bArr = new byte[i12];
                            parsableByteArray3.readBytes(bArr, 0, i12);
                            try {
                                mdtaMetadataEntry = new MdtaMetadataEntry(str, bArr, i11, i10);
                                break;
                            } catch (Exception unused) {
                                Format$$ExternalSyntheticOutline0.m("Failed to parse metadata entry with key: ", str, "MetadataUtil");
                                mdtaMetadataEntry = null;
                                break;
                            }
                        }
                        parsableByteArray3.setPosition(i8 + i9);
                    }
                    mdtaMetadataEntry = null;
                    break;
                }
                if (mdtaMetadataEntry != null) {
                    arrayList.add(mdtaMetadataEntry);
                }
            }
            parsableByteArray3.setPosition(i4 + i5);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static Mp4TimestampData parseMvhd(ParsableByteArray parsableByteArray) {
        long unsignedInt;
        long unsignedInt2;
        parsableByteArray.setPosition(8);
        if (parseFullBoxVersion(parsableByteArray.readInt()) == 0) {
            unsignedInt = parsableByteArray.readUnsignedInt();
            unsignedInt2 = parsableByteArray.readUnsignedInt();
        } else {
            unsignedInt = parsableByteArray.readLong();
            unsignedInt2 = parsableByteArray.readLong();
        }
        return new Mp4TimestampData(unsignedInt, unsignedInt2, parsableByteArray.readUnsignedInt());
    }

    public static Pair parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        TrackEncryptionBox trackEncryptionBox;
        Pair pairCreate;
        int i3;
        int i4;
        int i5 = parsableByteArray.position;
        while (i5 - i < i2) {
            parsableByteArray.setPosition(i5);
            int i6 = parsableByteArray.readInt();
            AacUtil.checkContainerInput("childAtomSize must be positive", i6 > 0);
            if (parsableByteArray.readInt() == 1936289382) {
                int i7 = i5 + 8;
                int i8 = 0;
                int i9 = -1;
                Integer numValueOf = null;
                String string = null;
                while (i7 - i5 < i6) {
                    parsableByteArray.setPosition(i7);
                    int i10 = parsableByteArray.readInt();
                    int i11 = parsableByteArray.readInt();
                    if (i11 == 1718775137) {
                        numValueOf = Integer.valueOf(parsableByteArray.readInt());
                    } else if (i11 == 1935894637) {
                        parsableByteArray.skipBytes(4);
                        string = parsableByteArray.readString(4, StandardCharsets.UTF_8);
                    } else if (i11 == 1935894633) {
                        i9 = i7;
                        i8 = i10;
                    }
                    i7 += i10;
                }
                byte[] bArr = null;
                if ("cenc".equals(string) || "cbc1".equals(string) || "cens".equals(string) || "cbcs".equals(string)) {
                    AacUtil.checkContainerInput("frma atom is mandatory", numValueOf != null);
                    AacUtil.checkContainerInput("schi atom is mandatory", i9 != -1);
                    int i12 = i9 + 8;
                    while (true) {
                        if (i12 - i9 >= i8) {
                            trackEncryptionBox = null;
                            break;
                        }
                        parsableByteArray.setPosition(i12);
                        int i13 = parsableByteArray.readInt();
                        if (parsableByteArray.readInt() == 1952804451) {
                            int fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
                            parsableByteArray.skipBytes(1);
                            if (fullBoxVersion == 0) {
                                parsableByteArray.skipBytes(1);
                                i4 = 0;
                                i3 = 0;
                            } else {
                                int unsignedByte = parsableByteArray.readUnsignedByte();
                                i3 = unsignedByte & 15;
                                i4 = (unsignedByte & 240) >> 4;
                            }
                            boolean z = parsableByteArray.readUnsignedByte() == 1;
                            int unsignedByte2 = parsableByteArray.readUnsignedByte();
                            byte[] bArr2 = new byte[16];
                            parsableByteArray.readBytes(bArr2, 0, 16);
                            if (z && unsignedByte2 == 0) {
                                int unsignedByte3 = parsableByteArray.readUnsignedByte();
                                byte[] bArr3 = new byte[unsignedByte3];
                                parsableByteArray.readBytes(bArr3, 0, unsignedByte3);
                                bArr = bArr3;
                            }
                            trackEncryptionBox = new TrackEncryptionBox(z, string, unsignedByte2, bArr2, i4, i3, bArr);
                            break;
                        }
                        i12 += i13;
                    }
                    AacUtil.checkContainerInput("tenc atom is mandatory", trackEncryptionBox != null);
                    String str = Util.DEVICE_DEBUG_INFO;
                    pairCreate = Pair.create(numValueOf, trackEncryptionBox);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            i5 += i6;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:158:0x02de  */
    /* JADX WARN: Code duplicated, block: B:443:0x0968  */
    /* JADX WARN: Code duplicated, block: B:445:0x0988  */
    /* JADX WARN: Code duplicated, block: B:447:0x098e  */
    /* JADX WARN: Code duplicated, block: B:448:0x099d  */
    /* JADX WARN: Code duplicated, block: B:453:0x09bf  */
    /* JADX WARN: Code duplicated, block: B:455:0x09cd  */
    /* JADX WARN: Code duplicated, block: B:456:0x09dc  */
    /* JADX WARN: Code duplicated, block: B:458:0x09e2  */
    /* JADX WARN: Code duplicated, block: B:459:0x09f1  */
    /* JADX WARN: Code duplicated, block: B:461:0x09f7  */
    /* JADX WARN: Code duplicated, block: B:462:0x0a07  */
    /* JADX WARN: Code duplicated, block: B:464:0x0a10  */
    /* JADX WARN: Code duplicated, block: B:466:0x0a1d  */
    /* JADX WARN: Code duplicated, block: B:470:0x0a43  */
    /* JADX WARN: Code duplicated, block: B:471:0x0a48  */
    /* JADX WARN: Code duplicated, block: B:474:0x0a52  */
    /* JADX WARN: Code duplicated, block: B:477:0x0a5c  */
    /* JADX WARN: Code duplicated, block: B:478:0x0a5f  */
    /* JADX WARN: Code duplicated, block: B:480:0x0a66  */
    /* JADX WARN: Code duplicated, block: B:485:0x0a72  */
    /* JADX WARN: Code duplicated, block: B:488:0x0a7f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:492:0x0a87  */
    /* JADX WARN: Code duplicated, block: B:495:0x0a8f  */
    /* JADX WARN: Code duplicated, block: B:498:0x0a96  */
    /* JADX WARN: Code duplicated, block: B:500:0x0aa7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:505:0x0ab1  */
    /* JADX WARN: Code duplicated, block: B:508:0x0abd  */
    /* JADX WARN: Code duplicated, block: B:509:0x0ac0  */
    /* JADX WARN: Code duplicated, block: B:511:0x0acf  */
    /* JADX WARN: Code duplicated, block: B:681:0x0a20 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:443:0x0968, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    public static StsdData parseStsd(ParsableByteArray parsableByteArray, TkhdData tkhdData, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        int i;
        DrmInitData drmInitData2;
        String str2;
        int i2;
        int i3;
        String str3;
        String str4;
        String str5;
        int iIsoTransferCharacteristicsToColorTransfer;
        int i4;
        byte[] bArr;
        int i5;
        int i6;
        byte[] bArrCopyOfRange;
        int i7;
        int i8;
        int i9;
        int bits;
        boolean bit;
        int bits2;
        int i10;
        int bits3;
        int i11;
        int i12;
        boolean bit2;
        int i13;
        int bits4;
        boolean z2;
        int i14;
        int iIsoTransferCharacteristicsToColorTransfer2;
        ColorInfo colorInfo;
        int bits5;
        int i15;
        ColorInfo colorInfo2;
        int i16;
        ConnectionPool connectionPool;
        int i17;
        int unsignedByte;
        int unsignedByte2;
        DrmInitData drmInitDataCopyWithSchemeType;
        int i18;
        String str6;
        RegularImmutableList regularImmutableListOf;
        long j;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        TkhdData tkhdData2 = tkhdData;
        String str7 = str;
        int i19 = tkhdData2.id;
        parsableByteArray2.setPosition(12);
        int i20 = parsableByteArray2.readInt();
        StsdData stsdData = new StsdData(i20);
        int i21 = 0;
        while (i21 < i20) {
            int i22 = parsableByteArray2.position;
            int i23 = parsableByteArray2.readInt();
            String str8 = "childAtomSize must be positive";
            AacUtil.checkContainerInput("childAtomSize must be positive", i23 > 0);
            int iIntValue = parsableByteArray2.readInt();
            int i24 = 8;
            byte b = 3;
            byte[] bArr2 = null;
            if (iIntValue == 1635148593 || iIntValue == 1635148595 || iIntValue == 1701733238 || iIntValue == 1831958048 || iIntValue == 1836070006 || iIntValue == 1752589105 || iIntValue == 1751479857 || iIntValue == 1987470129 || iIntValue == 1987471665 || iIntValue == 1932670515 || iIntValue == 1211250227 || iIntValue == 1748121139 || iIntValue == 1987063864 || iIntValue == 1987063865 || iIntValue == 1635135537 || iIntValue == 1685479798 || iIntValue == 1685479729 || iIntValue == 1685481573 || iIntValue == 1685481521 || iIntValue == 1634760241 || iIntValue == 1684108849) {
                int i25 = tkhdData2.rotationDegrees;
                parsableByteArray2.setPosition(i22 + 16);
                parsableByteArray2.skipBytes(16);
                int unsignedShort = parsableByteArray2.readUnsignedShort();
                int unsignedShort2 = parsableByteArray2.readUnsignedShort();
                parsableByteArray2.skipBytes(50);
                int i26 = parsableByteArray2.position;
                i = i21;
                if (iIntValue == 1701733238) {
                    Pair sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray2, i22, i23);
                    if (sampleEntryEncryptionData != null) {
                        iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                        drmInitDataCopyWithSchemeType = drmInitData == null ? null : drmInitData.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                        ((TrackEncryptionBox[]) stsdData.trackEncryptionBoxes)[i] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
                    } else {
                        i22 = i22;
                        drmInitDataCopyWithSchemeType = drmInitData;
                    }
                    parsableByteArray2.setPosition(i26);
                    drmInitData2 = drmInitDataCopyWithSchemeType;
                } else {
                    i22 = i22;
                    drmInitData2 = drmInitData;
                }
                if (iIntValue == 1831958048) {
                    str2 = "video/mpeg";
                } else {
                    str2 = iIntValue == 1211250227 ? "video/3gpp" : null;
                }
                DrmInitData drmInitData3 = drmInitData2;
                i2 = i19;
                i3 = i20;
                int i27 = i26;
                int i28 = 8;
                Dispatcher dispatcher = null;
                List listOf = null;
                ByteBuffer byteBuffer = null;
                String string = null;
                byte[] bArr3 = null;
                Joiner joiner = null;
                EocdRecord eocdRecord = null;
                RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = null;
                String str9 = str2;
                float unsignedIntToInt = 1.0f;
                int i29 = -1;
                int i30 = -1;
                int i31 = -1;
                int iIsoColorPrimariesToColorSpace = -1;
                boolean z3 = false;
                int i32 = -1;
                int i33 = -1;
                int i34 = -1;
                int i35 = -1;
                int i36 = 8;
                while (i27 - i22 < i23) {
                    parsableByteArray2.setPosition(i27);
                    int i37 = parsableByteArray2.position;
                    int i38 = i27;
                    int i39 = parsableByteArray2.readInt();
                    if (i39 == 0 && parsableByteArray2.position - i22 == i23) {
                        break;
                    }
                    AacUtil.checkContainerInput(str8, i39 > 0);
                    int i40 = parsableByteArray2.readInt();
                    int i41 = i23;
                    if (i40 == 1635148611) {
                        AacUtil.checkContainerInput(bArr2, str9 == null);
                        parsableByteArray2.setPosition(i37 + 8);
                        AvcConfig avcConfig = AvcConfig.parse(parsableByteArray2);
                        listOf = avcConfig.initializationData;
                        stsdData.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                        float f = !z3 ? avcConfig.pixelWidthHeightRatio : unsignedIntToInt;
                        String str10 = avcConfig.codecs;
                        int i42 = avcConfig.maxNumReorderFrames;
                        iIsoColorPrimariesToColorSpace = avcConfig.colorSpace;
                        int i43 = avcConfig.colorRange;
                        int i44 = avcConfig.colorTransfer;
                        int i45 = avcConfig.bitdepthLuma;
                        i28 = avcConfig.bitdepthChroma;
                        i4 = iIntValue;
                        i33 = i42;
                        str8 = str8;
                        iIsoTransferCharacteristicsToColorTransfer = i44;
                        unsignedIntToInt = f;
                        dispatcher = dispatcher;
                        i36 = i45;
                        str9 = "video/avc";
                        bArr = null;
                        string = str10;
                        i31 = i43;
                        i5 = i24;
                    } else {
                        int i46 = iIntValue;
                        if (i40 == 1752589123) {
                            AacUtil.checkContainerInput(null, str9 == null);
                            parsableByteArray2.setPosition(i37 + 8);
                            HevcConfig impl = HevcConfig.parseImpl(parsableByteArray2, false, null);
                            listOf = impl.initializationData;
                            stsdData.nalUnitLengthFieldLength = impl.nalUnitLengthFieldLength;
                            float f2 = !z3 ? impl.pixelWidthHeightRatio : unsignedIntToInt;
                            int i47 = impl.maxNumReorderPics;
                            int i48 = impl.maxSubLayers;
                            String str11 = impl.codecs;
                            int i49 = impl.stereoMode;
                            if (i49 != -1) {
                                i29 = i49;
                            }
                            int i50 = impl.decodedWidth;
                            int i51 = impl.decodedHeight;
                            iIsoColorPrimariesToColorSpace = impl.colorSpace;
                            int i52 = impl.colorRange;
                            int i53 = i29;
                            int i54 = impl.colorTransfer;
                            int i55 = impl.bitdepthLuma;
                            int i56 = impl.bitdepthChroma;
                            dispatcher = impl.vpsData;
                            i28 = i56;
                            str9 = "video/hevc";
                            str8 = str8;
                            i34 = i51;
                            i35 = i50;
                            unsignedIntToInt = f2;
                            i31 = i52;
                            i5 = i24;
                            i29 = i53;
                            iIsoTransferCharacteristicsToColorTransfer = i54;
                            i36 = i55;
                            i4 = i46;
                            i32 = i48;
                            string = str11;
                            i33 = i47;
                            bArr = null;
                        } else {
                            int i57 = i29;
                            if (i40 == 1818785347) {
                                AacUtil.checkContainerInput("lhvC must follow hvcC atom", "video/hevc".equals(str9));
                                AacUtil.checkContainerInput("must have at least two layers", dispatcher != null && ((ImmutableList) dispatcher.executorServiceOrNull).size() >= 2);
                                parsableByteArray2.setPosition(i37 + 8);
                                dispatcher.getClass();
                                HevcConfig impl2 = HevcConfig.parseImpl(parsableByteArray2, true, dispatcher);
                                AacUtil.checkContainerInput("nalUnitLengthFieldLength must be same for both hvcC and lhvC atoms", stsdData.nalUnitLengthFieldLength == impl2.nalUnitLengthFieldLength);
                                int i58 = impl2.colorSpace;
                                if (i58 != -1) {
                                    AacUtil.checkContainerInput("colorSpace must be the same for both views", iIsoColorPrimariesToColorSpace == i58);
                                }
                                int i59 = impl2.colorRange;
                                if (i59 != -1) {
                                    AacUtil.checkContainerInput("colorRange must be the same for both views", i31 == i59);
                                }
                                int i60 = impl2.colorTransfer;
                                if (i60 != -1) {
                                    AacUtil.checkContainerInput("colorTransfer must be the same for both views", i30 == i60);
                                }
                                AacUtil.checkContainerInput("bitdepthLuma must be the same for both views", i36 == impl2.bitdepthLuma);
                                AacUtil.checkContainerInput("bitdepthChroma must be the same for both views", i28 == impl2.bitdepthChroma);
                                if (listOf != null) {
                                    ImmutableList.Builder builder = ImmutableList.builder();
                                    builder.addAll(listOf);
                                    builder.addAll(impl2.initializationData);
                                    listOf = builder.build();
                                } else {
                                    AacUtil.checkContainerInput("initializationData must be already set from hvcC atom", false);
                                }
                                string = impl2.codecs;
                                str9 = "video/mv-hevc";
                                iIsoTransferCharacteristicsToColorTransfer = i30;
                                str8 = str8;
                                i36 = i36;
                                dispatcher = dispatcher;
                                i5 = i24;
                                i4 = i46;
                                i29 = i57;
                                bArr = null;
                            } else {
                                int i61 = 7;
                                if (i40 == 1987470147) {
                                    AacUtil.checkContainerInput(null, str9 == null);
                                    parsableByteArray2.setPosition(i37 + 8);
                                    try {
                                        if (parsableByteArray2.readInt() != 0) {
                                            throw ParserException.createForMalformedContainer(null, "Unsupported VVC version");
                                        }
                                        int unsignedByte3 = parsableByteArray2.readUnsignedByte();
                                        int i62 = (unsignedByte3 >> 1) & 3;
                                        boolean z4 = (unsignedByte3 & 1) != 0;
                                        int i63 = i62 + 1;
                                        String str12 = "L";
                                        if (z4) {
                                            parsableByteArray2.skipBytes(1);
                                            int unsignedByte4 = (parsableByteArray2.readUnsignedByte() >> 4) & 7;
                                            unsignedByte = (parsableByteArray2.readUnsignedByte() >> 5) & 7;
                                            int unsignedByte5 = parsableByteArray2.readUnsignedByte() & 63;
                                            int unsignedByte6 = parsableByteArray2.readUnsignedByte();
                                            int i64 = (unsignedByte6 >> 1) & 127;
                                            str12 = (unsignedByte6 & 1) != 0 ? "H" : "L";
                                            unsignedByte2 = parsableByteArray2.readUnsignedByte();
                                            parsableByteArray2.skipBytes(unsignedByte5);
                                            int i65 = 1;
                                            if (unsignedByte4 > 1) {
                                                int unsignedByte7 = parsableByteArray2.readUnsignedByte();
                                                int i66 = 0;
                                                while (i66 < unsignedByte4 - 1) {
                                                    if (((unsignedByte7 >> (7 - i66)) & i65) != 0) {
                                                        parsableByteArray2.skipBytes(i65);
                                                    }
                                                    i66++;
                                                    i65 = 1;
                                                }
                                            }
                                            parsableByteArray2.skipBytes(parsableByteArray2.readUnsignedByte() * 4);
                                            parsableByteArray2.skipBytes(6);
                                            i17 = i64;
                                        } else {
                                            i17 = 0;
                                            unsignedByte = 0;
                                            unsignedByte2 = 0;
                                        }
                                        int unsignedByte8 = parsableByteArray2.readUnsignedByte();
                                        int i67 = parsableByteArray2.position;
                                        int i68 = unsignedByte;
                                        int i69 = 0;
                                        int i70 = 0;
                                        while (i70 < unsignedByte8) {
                                            int i71 = i31;
                                            int unsignedByte9 = parsableByteArray2.readUnsignedByte() & 31;
                                            int i72 = i70;
                                            int unsignedShort3 = (unsignedByte9 == 13 || unsignedByte9 == 12) ? 1 : parsableByteArray2.readUnsignedShort();
                                            int i73 = 0;
                                            while (i73 < unsignedShort3) {
                                                int i74 = i69;
                                                int unsignedShort4 = parsableByteArray2.readUnsignedShort();
                                                parsableByteArray2.skipBytes(unsignedShort4);
                                                i73++;
                                                i69 = unsignedShort4 + 4 + i74;
                                            }
                                            i70 = i72 + 1;
                                            i31 = i71;
                                        }
                                        int i75 = i31;
                                        parsableByteArray2.setPosition(i67);
                                        byte[] bArr4 = new byte[i69];
                                        int i76 = 0;
                                        int i77 = 0;
                                        while (i76 < unsignedByte8) {
                                            int unsignedByte10 = parsableByteArray2.readUnsignedByte() & 31;
                                            int i78 = unsignedByte8;
                                            int unsignedShort5 = (unsignedByte10 == 13 || unsignedByte10 == 12) ? 1 : parsableByteArray2.readUnsignedShort();
                                            int i79 = 0;
                                            while (i79 < unsignedShort5) {
                                                int i80 = unsignedShort5;
                                                int unsignedShort6 = parsableByteArray2.readUnsignedShort();
                                                System.arraycopy(OpusUtil.NAL_START_CODE, 0, bArr4, i77, 4);
                                                int i81 = i77 + 4;
                                                parsableByteArray2.readBytes(bArr4, i81, unsignedShort6);
                                                i77 = i81 + unsignedShort6;
                                                i79++;
                                                unsignedShort5 = i80;
                                                i76 = i76;
                                                i30 = i30;
                                            }
                                            i76++;
                                            unsignedByte8 = i78;
                                        }
                                        iIsoTransferCharacteristicsToColorTransfer = i30;
                                        Locale locale = Locale.US;
                                        String str13 = "vvc1." + i17 + "." + str12 + unsignedByte2;
                                        listOf = ImmutableList.of((Object) bArr4);
                                        int i82 = i68 + 8;
                                        stsdData.nalUnitLengthFieldLength = i63;
                                        string = str13;
                                        str9 = "video/vvc";
                                        str8 = str8;
                                        i28 = i82;
                                        i36 = i28;
                                        dispatcher = dispatcher;
                                        i5 = i24;
                                        i4 = i46;
                                        i29 = i57;
                                        i31 = i75;
                                        bArr = null;
                                        i33 = 16;
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                        throw ParserException.createForMalformedContainer(e, "Error parsing VVC configuration");
                                    }
                                } else {
                                    iIsoTransferCharacteristicsToColorTransfer = i30;
                                    i31 = i31;
                                    if (i40 == 1986361461) {
                                        parsableByteArray2.setPosition(i37 + 8);
                                        int i83 = parsableByteArray2.position;
                                        ConnectionPool connectionPool2 = null;
                                        while (i83 - i37 < i39) {
                                            parsableByteArray2.setPosition(i83);
                                            int i84 = parsableByteArray2.readInt();
                                            AacUtil.checkContainerInput(str8, i84 > 0);
                                            if (parsableByteArray2.readInt() == 1702454643) {
                                                parsableByteArray2.setPosition(i83 + 8);
                                                int i85 = parsableByteArray2.position;
                                                while (true) {
                                                    if (i85 - i83 >= i84) {
                                                        connectionPool = null;
                                                        break;
                                                    }
                                                    parsableByteArray2.setPosition(i85);
                                                    int i86 = parsableByteArray2.readInt();
                                                    AacUtil.checkContainerInput(str8, i86 > 0);
                                                    if (parsableByteArray2.readInt() == 1937011305) {
                                                        parsableByteArray2.skipBytes(4);
                                                        int unsignedByte11 = parsableByteArray2.readUnsignedByte();
                                                        boolean z5 = (unsignedByte11 & 1) == 1;
                                                        boolean z6 = (unsignedByte11 & 2) == 2;
                                                        boolean z7 = (unsignedByte11 & 8) == i24;
                                                        StriData striData = new StriData();
                                                        striData.hasLeftEyeView = z5;
                                                        striData.hasRightEyeView = z6;
                                                        striData.eyeViewsReversed = z7;
                                                        connectionPool = new ConnectionPool(striData);
                                                        break;
                                                    }
                                                    i85 += i86;
                                                    i24 = 8;
                                                }
                                                connectionPool2 = connectionPool;
                                            } else {
                                                i28 = i28;
                                                i83 = i83;
                                            }
                                            i83 += i84;
                                            i28 = i28;
                                            i24 = 8;
                                        }
                                        int i87 = i28;
                                        ConnectionPool connectionPool3 = connectionPool2 == null ? null : new ConnectionPool(connectionPool2);
                                        if (connectionPool3 != null) {
                                            StriData striData2 = (StriData) ((ConnectionPool) connectionPool3.delegate).delegate;
                                            boolean z8 = striData2.eyeViewsReversed;
                                            if (dispatcher == null || ((ImmutableList) dispatcher.executorServiceOrNull).size() < 2) {
                                                i16 = i57;
                                                if (i16 == -1) {
                                                    i29 = z8 ? 5 : 4;
                                                } else {
                                                    i29 = i16;
                                                }
                                            } else {
                                                AacUtil.checkContainerInput("both eye views must be marked as available", striData2.hasLeftEyeView && striData2.hasRightEyeView);
                                                AacUtil.checkContainerInput("for MV-HEVC, eye_views_reversed must be set to false", !z8);
                                                i16 = i57;
                                                i29 = i16;
                                            }
                                        } else {
                                            i16 = i57;
                                            i29 = i16;
                                        }
                                        str8 = str8;
                                        str9 = str9;
                                        i36 = i36;
                                        dispatcher = dispatcher;
                                        i4 = i46;
                                        i28 = i87;
                                        bArr = null;
                                    } else {
                                        int i88 = i28;
                                        i29 = i57;
                                        if (i40 == 1685480259 || i40 == 1685485123 || i40 == 1685485379) {
                                            str8 = str8;
                                            str9 = str9;
                                            i36 = i36;
                                            dispatcher = dispatcher;
                                            i4 = i46;
                                            bArr = null;
                                            i5 = 8;
                                            iIsoTransferCharacteristicsToColorTransfer = iIsoTransferCharacteristicsToColorTransfer;
                                            joiner = Joiner.parse(parsableByteArray2);
                                        } else if (i40 == 1987076931) {
                                            AacUtil.checkContainerInput(null, str9 == null);
                                            String str14 = i46 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                            parsableByteArray2.setPosition(i37 + 12);
                                            byte unsignedByte12 = (byte) parsableByteArray2.readUnsignedByte();
                                            byte unsignedByte13 = (byte) parsableByteArray2.readUnsignedByte();
                                            int unsignedByte14 = parsableByteArray2.readUnsignedByte();
                                            int i89 = unsignedByte14 >> 4;
                                            byte b2 = (byte) ((unsignedByte14 >> 1) & 7);
                                            if (str14.equals("video/x-vnd.on2.vp9")) {
                                                byte[] bArr5 = CodecSpecificDataUtil.NAL_START_CODE;
                                                byte[] bArr6 = new byte[12];
                                                bArr6[0] = 1;
                                                bArr6[1] = 1;
                                                bArr6[2] = unsignedByte12;
                                                bArr6[b] = 2;
                                                bArr6[4] = 1;
                                                bArr6[5] = unsignedByte13;
                                                bArr6[6] = b;
                                                bArr6[7] = 1;
                                                bArr6[8] = (byte) i89;
                                                bArr6[9] = 4;
                                                bArr6[10] = 1;
                                                bArr6[11] = b2;
                                                listOf = ImmutableList.of((Object) bArr6);
                                            }
                                            boolean z9 = (unsignedByte14 & 1) != 0;
                                            int unsignedByte15 = parsableByteArray2.readUnsignedByte();
                                            int unsignedByte16 = parsableByteArray2.readUnsignedByte();
                                            iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(unsignedByte15);
                                            int i90 = z9 ? 1 : 2;
                                            iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(unsignedByte16);
                                            i36 = i89;
                                            i4 = i46;
                                            str9 = str14;
                                            i31 = i90;
                                            bArr = null;
                                            i5 = 8;
                                            i28 = i36;
                                        } else {
                                            i4 = i46;
                                            int i91 = 11;
                                            if (i40 == 1635135811) {
                                                int i92 = i39 - 8;
                                                byte[] bArr7 = new byte[i92];
                                                parsableByteArray2.readBytes(bArr7, 0, i92);
                                                listOf = ImmutableList.of((Object) bArr7);
                                                parsableByteArray2.setPosition(i37 + 8);
                                                byte[] bArr8 = parsableByteArray2.data;
                                                VorbisBitArray vorbisBitArray = new VorbisBitArray(bArr8, bArr8.length);
                                                vorbisBitArray.setPosition(parsableByteArray2.position * 8);
                                                vorbisBitArray.skipBytes(1);
                                                int bits6 = vorbisBitArray.readBits(b);
                                                vorbisBitArray.skipBits(6);
                                                boolean bit3 = vorbisBitArray.readBit();
                                                boolean bit4 = vorbisBitArray.readBit();
                                                int i93 = -1;
                                                if (bits6 == 2 && bit3) {
                                                    int i94 = bit4 ? 12 : 10;
                                                    i9 = bit4 ? 12 : 10;
                                                    i7 = i94;
                                                } else {
                                                    if (bits6 <= 2) {
                                                        int i95 = bit3 ? 10 : 8;
                                                        i9 = bit3 ? 10 : 8;
                                                        i7 = i95;
                                                    } else {
                                                        i7 = -1;
                                                        i8 = -1;
                                                    }
                                                    vorbisBitArray.skipBits(13);
                                                    vorbisBitArray.skipBit();
                                                    bits = vorbisBitArray.readBits(4);
                                                    if (bits != 1) {
                                                        Log.i("BoxParsers", "Unsupported obu_type: " + bits);
                                                        colorInfo2 = new ColorInfo(-1, -1, -1, null, i7, i8);
                                                    } else if (vorbisBitArray.readBit()) {
                                                        Log.i("BoxParsers", "Unsupported obu_extension_flag");
                                                        colorInfo2 = new ColorInfo(-1, -1, -1, null, i7, i8);
                                                    } else {
                                                        bit = vorbisBitArray.readBit();
                                                        vorbisBitArray.skipBit();
                                                        if (bit || vorbisBitArray.readBits(8) <= 127) {
                                                            bits2 = vorbisBitArray.readBits(3);
                                                            vorbisBitArray.skipBit();
                                                            if (vorbisBitArray.readBit()) {
                                                                Log.i("BoxParsers", "Unsupported reduced_still_picture_header");
                                                                colorInfo2 = new ColorInfo(-1, -1, -1, null, i7, i8);
                                                            } else if (vorbisBitArray.readBit()) {
                                                                Log.i("BoxParsers", "Unsupported timing_info_present_flag");
                                                                colorInfo2 = new ColorInfo(-1, -1, -1, null, i7, i8);
                                                            } else {
                                                                if (vorbisBitArray.readBit()) {
                                                                    Log.i("BoxParsers", "Unsupported initial_display_delay_present_flag");
                                                                    colorInfo2 = new ColorInfo(-1, -1, -1, null, i7, i8);
                                                                } else {
                                                                    i10 = 5;
                                                                    bits3 = vorbisBitArray.readBits(5);
                                                                    i11 = 0;
                                                                    while (i11 <= bits3) {
                                                                        vorbisBitArray.skipBits(12);
                                                                        if (vorbisBitArray.readBits(i10) > i61) {
                                                                            vorbisBitArray.skipBit();
                                                                        }
                                                                        i11++;
                                                                        i10 = 5;
                                                                        i61 = 7;
                                                                    }
                                                                    int bits7 = vorbisBitArray.readBits(4);
                                                                    int bits8 = vorbisBitArray.readBits(4);
                                                                    vorbisBitArray.skipBits(bits7 + 1);
                                                                    vorbisBitArray.skipBits(bits8 + 1);
                                                                    if (vorbisBitArray.readBit()) {
                                                                        i12 = 7;
                                                                        vorbisBitArray.skipBits(7);
                                                                    } else {
                                                                        i12 = 7;
                                                                    }
                                                                    vorbisBitArray.skipBits(i12);
                                                                    bit2 = vorbisBitArray.readBit();
                                                                    if (bit2) {
                                                                        vorbisBitArray.skipBits(2);
                                                                    }
                                                                    if (vorbisBitArray.readBit()) {
                                                                        bits4 = 2;
                                                                        i13 = 1;
                                                                    } else {
                                                                        i13 = 1;
                                                                        bits4 = vorbisBitArray.readBits(1);
                                                                    }
                                                                    if (bits4 > 0 && !vorbisBitArray.readBit()) {
                                                                        vorbisBitArray.skipBits(i13);
                                                                    }
                                                                    if (bit2) {
                                                                        vorbisBitArray.skipBits(3);
                                                                    }
                                                                    vorbisBitArray.skipBits(3);
                                                                    boolean bit5 = vorbisBitArray.readBit();
                                                                    if (bits2 == 2 && bit5) {
                                                                        vorbisBitArray.skipBit();
                                                                    }
                                                                    if (bits2 == 1 && vorbisBitArray.readBit()) {
                                                                        z2 = true;
                                                                    } else {
                                                                        z2 = false;
                                                                    }
                                                                    if (vorbisBitArray.readBit()) {
                                                                        int bits9 = vorbisBitArray.readBits(8);
                                                                        int bits10 = vorbisBitArray.readBits(8);
                                                                        int bits11 = vorbisBitArray.readBits(8);
                                                                        if (z2 && bits9 == 1 && bits10 == 13 && bits11 == 0) {
                                                                            bits5 = 1;
                                                                        } else {
                                                                            bits5 = vorbisBitArray.readBits(1);
                                                                        }
                                                                        int iIsoColorPrimariesToColorSpace2 = ColorInfo.isoColorPrimariesToColorSpace(bits9);
                                                                        if (bits5 == 1) {
                                                                            i15 = 1;
                                                                        } else {
                                                                            i15 = 2;
                                                                        }
                                                                        i14 = iIsoColorPrimariesToColorSpace2;
                                                                        iIsoTransferCharacteristicsToColorTransfer2 = ColorInfo.isoTransferCharacteristicsToColorTransfer(bits10);
                                                                        i93 = i15;
                                                                    } else {
                                                                        i14 = -1;
                                                                        iIsoTransferCharacteristicsToColorTransfer2 = -1;
                                                                    }
                                                                    colorInfo = new ColorInfo(i14, i93, iIsoTransferCharacteristicsToColorTransfer2, null, i7, i8);
                                                                }
                                                                int i96 = colorInfo.lumaBitdepth;
                                                                int i97 = colorInfo.chromaBitdepth;
                                                                iIsoColorPrimariesToColorSpace = colorInfo.colorSpace;
                                                                int i98 = colorInfo.colorRange;
                                                                iIsoTransferCharacteristicsToColorTransfer = colorInfo.colorTransfer;
                                                                str9 = "video/av01";
                                                                i4 = i4;
                                                                i31 = i98;
                                                                i36 = i96;
                                                                bArr = null;
                                                                i5 = 8;
                                                                i28 = i97;
                                                            }
                                                        } else {
                                                            Log.i("BoxParsers", "Excessive obu_size");
                                                            colorInfo2 = new ColorInfo(-1, -1, -1, null, i7, i8);
                                                        }
                                                    }
                                                    colorInfo = colorInfo2;
                                                    int i99 = colorInfo.lumaBitdepth;
                                                    int i910 = colorInfo.chromaBitdepth;
                                                    iIsoColorPrimariesToColorSpace = colorInfo.colorSpace;
                                                    int i911 = colorInfo.colorRange;
                                                    iIsoTransferCharacteristicsToColorTransfer = colorInfo.colorTransfer;
                                                    str9 = "video/av01";
                                                    i4 = i4;
                                                    i31 = i911;
                                                    i36 = i99;
                                                    bArr = null;
                                                    i5 = 8;
                                                    i28 = i910;
                                                }
                                                i8 = i9;
                                                vorbisBitArray.skipBits(13);
                                                vorbisBitArray.skipBit();
                                                bits = vorbisBitArray.readBits(4);
                                                if (bits != 1) {
                                                    Log.i("BoxParsers", "Unsupported obu_type: " + bits);
                                                    colorInfo2 = new ColorInfo(-1, -1, -1, null, i7, i8);
                                                } else if (vorbisBitArray.readBit()) {
                                                    Log.i("BoxParsers", "Unsupported obu_extension_flag");
                                                    colorInfo2 = new ColorInfo(-1, -1, -1, null, i7, i8);
                                                } else {
                                                    bit = vorbisBitArray.readBit();
                                                    vorbisBitArray.skipBit();
                                                    if (bit) {
                                                        bits2 = vorbisBitArray.readBits(3);
                                                        vorbisBitArray.skipBit();
                                                        if (vorbisBitArray.readBit()) {
                                                            Log.i("BoxParsers", "Unsupported reduced_still_picture_header");
                                                            colorInfo2 = new ColorInfo(-1, -1, -1, null, i7, i8);
                                                        } else if (vorbisBitArray.readBit()) {
                                                            Log.i("BoxParsers", "Unsupported timing_info_present_flag");
                                                            colorInfo2 = new ColorInfo(-1, -1, -1, null, i7, i8);
                                                        } else if (vorbisBitArray.readBit()) {
                                                            Log.i("BoxParsers", "Unsupported initial_display_delay_present_flag");
                                                            colorInfo2 = new ColorInfo(-1, -1, -1, null, i7, i8);
                                                        } else {
                                                            i10 = 5;
                                                            bits3 = vorbisBitArray.readBits(5);
                                                            i11 = 0;
                                                            while (i11 <= bits3) {
                                                                vorbisBitArray.skipBits(12);
                                                                if (vorbisBitArray.readBits(i10) > i61) {
                                                                    vorbisBitArray.skipBit();
                                                                }
                                                                i11++;
                                                                i10 = 5;
                                                                i61 = 7;
                                                            }
                                                            int bits12 = vorbisBitArray.readBits(4);
                                                            int bits13 = vorbisBitArray.readBits(4);
                                                            vorbisBitArray.skipBits(bits12 + 1);
                                                            vorbisBitArray.skipBits(bits13 + 1);
                                                            if (vorbisBitArray.readBit()) {
                                                                i12 = 7;
                                                                vorbisBitArray.skipBits(7);
                                                            } else {
                                                                i12 = 7;
                                                            }
                                                            vorbisBitArray.skipBits(i12);
                                                            bit2 = vorbisBitArray.readBit();
                                                            if (bit2) {
                                                                vorbisBitArray.skipBits(2);
                                                            }
                                                            if (vorbisBitArray.readBit()) {
                                                                bits4 = 2;
                                                                i13 = 1;
                                                            } else {
                                                                i13 = 1;
                                                                bits4 = vorbisBitArray.readBits(1);
                                                            }
                                                            if (bits4 > 0) {
                                                                vorbisBitArray.skipBits(i13);
                                                            }
                                                            if (bit2) {
                                                                vorbisBitArray.skipBits(3);
                                                            }
                                                            vorbisBitArray.skipBits(3);
                                                            boolean bit6 = vorbisBitArray.readBit();
                                                            if (bits2 == 2) {
                                                                vorbisBitArray.skipBit();
                                                            }
                                                            if (bits2 == 1) {
                                                                z2 = false;
                                                            } else {
                                                                z2 = false;
                                                            }
                                                            if (vorbisBitArray.readBit()) {
                                                                int bits14 = vorbisBitArray.readBits(8);
                                                                int bits15 = vorbisBitArray.readBits(8);
                                                                int bits16 = vorbisBitArray.readBits(8);
                                                                if (z2) {
                                                                    bits5 = vorbisBitArray.readBits(1);
                                                                } else {
                                                                    bits5 = vorbisBitArray.readBits(1);
                                                                }
                                                                int iIsoColorPrimariesToColorSpace3 = ColorInfo.isoColorPrimariesToColorSpace(bits14);
                                                                if (bits5 == 1) {
                                                                    i15 = 1;
                                                                } else {
                                                                    i15 = 2;
                                                                }
                                                                i14 = iIsoColorPrimariesToColorSpace3;
                                                                iIsoTransferCharacteristicsToColorTransfer2 = ColorInfo.isoTransferCharacteristicsToColorTransfer(bits15);
                                                                i93 = i15;
                                                            } else {
                                                                i14 = -1;
                                                                iIsoTransferCharacteristicsToColorTransfer2 = -1;
                                                            }
                                                            colorInfo = new ColorInfo(i14, i93, iIsoTransferCharacteristicsToColorTransfer2, null, i7, i8);
                                                        }
                                                    } else {
                                                        bits2 = vorbisBitArray.readBits(3);
                                                        vorbisBitArray.skipBit();
                                                        if (vorbisBitArray.readBit()) {
                                                            Log.i("BoxParsers", "Unsupported reduced_still_picture_header");
                                                            colorInfo2 = new ColorInfo(-1, -1, -1, null, i7, i8);
                                                        } else if (vorbisBitArray.readBit()) {
                                                            Log.i("BoxParsers", "Unsupported timing_info_present_flag");
                                                            colorInfo2 = new ColorInfo(-1, -1, -1, null, i7, i8);
                                                        } else if (vorbisBitArray.readBit()) {
                                                            Log.i("BoxParsers", "Unsupported initial_display_delay_present_flag");
                                                            colorInfo2 = new ColorInfo(-1, -1, -1, null, i7, i8);
                                                        } else {
                                                            i10 = 5;
                                                            bits3 = vorbisBitArray.readBits(5);
                                                            i11 = 0;
                                                            while (i11 <= bits3) {
                                                                vorbisBitArray.skipBits(12);
                                                                if (vorbisBitArray.readBits(i10) > i61) {
                                                                    vorbisBitArray.skipBit();
                                                                }
                                                                i11++;
                                                                i10 = 5;
                                                                i61 = 7;
                                                            }
                                                            int bits17 = vorbisBitArray.readBits(4);
                                                            int bits18 = vorbisBitArray.readBits(4);
                                                            vorbisBitArray.skipBits(bits17 + 1);
                                                            vorbisBitArray.skipBits(bits18 + 1);
                                                            if (vorbisBitArray.readBit()) {
                                                                i12 = 7;
                                                                vorbisBitArray.skipBits(7);
                                                            } else {
                                                                i12 = 7;
                                                            }
                                                            vorbisBitArray.skipBits(i12);
                                                            bit2 = vorbisBitArray.readBit();
                                                            if (bit2) {
                                                                vorbisBitArray.skipBits(2);
                                                            }
                                                            if (vorbisBitArray.readBit()) {
                                                                bits4 = 2;
                                                                i13 = 1;
                                                            } else {
                                                                i13 = 1;
                                                                bits4 = vorbisBitArray.readBits(1);
                                                            }
                                                            if (bits4 > 0) {
                                                                vorbisBitArray.skipBits(i13);
                                                            }
                                                            if (bit2) {
                                                                vorbisBitArray.skipBits(3);
                                                            }
                                                            vorbisBitArray.skipBits(3);
                                                            boolean bit7 = vorbisBitArray.readBit();
                                                            if (bits2 == 2) {
                                                                vorbisBitArray.skipBit();
                                                            }
                                                            if (bits2 == 1) {
                                                                z2 = false;
                                                            } else {
                                                                z2 = false;
                                                            }
                                                            if (vorbisBitArray.readBit()) {
                                                                int bits19 = vorbisBitArray.readBits(8);
                                                                int bits110 = vorbisBitArray.readBits(8);
                                                                int bits111 = vorbisBitArray.readBits(8);
                                                                if (z2) {
                                                                    bits5 = vorbisBitArray.readBits(1);
                                                                } else {
                                                                    bits5 = vorbisBitArray.readBits(1);
                                                                }
                                                                int iIsoColorPrimariesToColorSpace4 = ColorInfo.isoColorPrimariesToColorSpace(bits19);
                                                                if (bits5 == 1) {
                                                                    i15 = 1;
                                                                } else {
                                                                    i15 = 2;
                                                                }
                                                                i14 = iIsoColorPrimariesToColorSpace4;
                                                                iIsoTransferCharacteristicsToColorTransfer2 = ColorInfo.isoTransferCharacteristicsToColorTransfer(bits110);
                                                                i93 = i15;
                                                            } else {
                                                                i14 = -1;
                                                                iIsoTransferCharacteristicsToColorTransfer2 = -1;
                                                            }
                                                            colorInfo = new ColorInfo(i14, i93, iIsoTransferCharacteristicsToColorTransfer2, null, i7, i8);
                                                        }
                                                    }
                                                    int i912 = colorInfo.lumaBitdepth;
                                                    int i913 = colorInfo.chromaBitdepth;
                                                    iIsoColorPrimariesToColorSpace = colorInfo.colorSpace;
                                                    int i914 = colorInfo.colorRange;
                                                    iIsoTransferCharacteristicsToColorTransfer = colorInfo.colorTransfer;
                                                    str9 = "video/av01";
                                                    i4 = i4;
                                                    i31 = i914;
                                                    i36 = i912;
                                                    bArr = null;
                                                    i5 = 8;
                                                    i28 = i913;
                                                }
                                                colorInfo = colorInfo2;
                                                int i915 = colorInfo.lumaBitdepth;
                                                int i916 = colorInfo.chromaBitdepth;
                                                iIsoColorPrimariesToColorSpace = colorInfo.colorSpace;
                                                int i917 = colorInfo.colorRange;
                                                iIsoTransferCharacteristicsToColorTransfer = colorInfo.colorTransfer;
                                                str9 = "video/av01";
                                                i4 = i4;
                                                i31 = i917;
                                                i36 = i915;
                                                bArr = null;
                                                i5 = 8;
                                                i28 = i916;
                                            } else {
                                                if (i40 == 1668050025) {
                                                    ByteBuffer byteBufferOrder = byteBuffer == null ? ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN) : byteBuffer;
                                                    byteBufferOrder.position(21);
                                                    byteBufferOrder.putShort(parsableByteArray2.readShort());
                                                    byteBufferOrder.putShort(parsableByteArray2.readShort());
                                                    byteBuffer = byteBufferOrder;
                                                } else if (i40 == 1835295606) {
                                                    ByteBuffer byteBufferOrder2 = byteBuffer == null ? ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN) : byteBuffer;
                                                    short s = parsableByteArray2.readShort();
                                                    short s2 = parsableByteArray2.readShort();
                                                    short s3 = parsableByteArray2.readShort();
                                                    short s4 = parsableByteArray2.readShort();
                                                    short s5 = parsableByteArray2.readShort();
                                                    short s6 = parsableByteArray2.readShort();
                                                    short s7 = parsableByteArray2.readShort();
                                                    short s8 = parsableByteArray2.readShort();
                                                    long unsignedInt = parsableByteArray2.readUnsignedInt();
                                                    long unsignedInt2 = parsableByteArray2.readUnsignedInt();
                                                    byteBufferOrder2.position(1);
                                                    byteBufferOrder2.putShort(s5);
                                                    byteBufferOrder2.putShort(s6);
                                                    byteBufferOrder2.putShort(s);
                                                    byteBufferOrder2.putShort(s2);
                                                    byteBufferOrder2.putShort(s3);
                                                    byteBufferOrder2.putShort(s4);
                                                    byteBufferOrder2.putShort(s7);
                                                    byteBufferOrder2.putShort(s8);
                                                    byteBufferOrder2.putShort((short) (unsignedInt / 10000));
                                                    byteBufferOrder2.putShort((short) (unsignedInt2 / 10000));
                                                    byteBuffer = byteBufferOrder2;
                                                } else {
                                                    i4 = i4;
                                                    str8 = str8;
                                                    str9 = str9;
                                                    i36 = i36;
                                                    dispatcher = dispatcher;
                                                    if (i40 == 1681012275) {
                                                        bArr = null;
                                                        AacUtil.checkContainerInput(null, str9 == null);
                                                        i29 = i29;
                                                        str9 = "video/3gpp";
                                                        i28 = i88;
                                                    } else {
                                                        bArr = null;
                                                        if (i40 == 1702061171) {
                                                            AacUtil.checkContainerInput(null, str9 == null);
                                                            RealStrongMemoryCache$cache$1 esdsFromParent = parseEsdsFromParent(i37, parsableByteArray2);
                                                            String str15 = (String) esdsFromParent.map;
                                                            byte[] bArr9 = (byte[]) esdsFromParent.this$0;
                                                            if (bArr9 != null) {
                                                                listOf = ImmutableList.of((Object) bArr9);
                                                            }
                                                            realStrongMemoryCache$cache$1 = esdsFromParent;
                                                            str9 = str15;
                                                        } else {
                                                            if (i40 == 1651798644) {
                                                                parsableByteArray2.setPosition(i37 + 8);
                                                                parsableByteArray2.skipBytes(4);
                                                                i29 = i29;
                                                                eocdRecord = new EocdRecord(parsableByteArray2.readUnsignedInt(), parsableByteArray2.readUnsignedInt());
                                                            } else {
                                                                if (i40 == 1885434736) {
                                                                    parsableByteArray2.setPosition(i37 + 8);
                                                                    unsignedIntToInt = parsableByteArray2.readUnsignedIntToInt() / parsableByteArray2.readUnsignedIntToInt();
                                                                    i31 = i31;
                                                                    i5 = 8;
                                                                    z3 = true;
                                                                } else if (i40 == 1937126244) {
                                                                    int i100 = i37 + 8;
                                                                    while (true) {
                                                                        if (i100 - i37 >= i39) {
                                                                            bArrCopyOfRange = null;
                                                                            break;
                                                                        }
                                                                        parsableByteArray2.setPosition(i100);
                                                                        int i101 = parsableByteArray2.readInt();
                                                                        if (parsableByteArray2.readInt() == 1886547818) {
                                                                            bArrCopyOfRange = Arrays.copyOfRange(parsableByteArray2.data, i100, i101 + i100);
                                                                            break;
                                                                        }
                                                                        i100 += i101;
                                                                    }
                                                                    bArr3 = bArrCopyOfRange;
                                                                } else if (i40 == 1936995172) {
                                                                    int unsignedByte17 = parsableByteArray2.readUnsignedByte();
                                                                    parsableByteArray2.skipBytes(3);
                                                                    if (unsignedByte17 == 0) {
                                                                        int unsignedByte18 = parsableByteArray2.readUnsignedByte();
                                                                        if (unsignedByte18 == 0) {
                                                                            i29 = 0;
                                                                        } else if (unsignedByte18 == 1) {
                                                                            i29 = 1;
                                                                        } else if (unsignedByte18 == 2) {
                                                                            i29 = 2;
                                                                        } else if (unsignedByte18 == 3) {
                                                                            i29 = 3;
                                                                        }
                                                                    }
                                                                    i29 = i29;
                                                                } else if (i40 == 1634760259) {
                                                                    int i102 = i39 - 12;
                                                                    byte[] bArr10 = new byte[i102];
                                                                    parsableByteArray2.setPosition(i37 + 12);
                                                                    parsableByteArray2.readBytes(bArr10, 0, i102);
                                                                    byte[] bArr11 = CodecSpecificDataUtil.NAL_START_CODE;
                                                                    UtilsKt.checkArgument("Invalid APV CSD length: %s", i102, i102 >= 17);
                                                                    byte b3 = bArr10[0];
                                                                    UtilsKt.checkArgument("Invalid APV CSD version: %s", b3, b3 == 1);
                                                                    int unsignedInt3 = Byte.toUnsignedInt(bArr10[5]);
                                                                    int unsignedInt4 = Byte.toUnsignedInt(bArr10[6]);
                                                                    int unsignedInt5 = Byte.toUnsignedInt(bArr10[7]);
                                                                    String str16 = Util.DEVICE_DEBUG_INFO;
                                                                    Locale locale2 = Locale.US;
                                                                    StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(unsignedInt3, "apv1.apvf", ".apvl", unsignedInt4, ".apvb");
                                                                    sbM3m.append(unsignedInt5);
                                                                    string = sbM3m.toString();
                                                                    listOf = ImmutableList.of((Object) bArr10);
                                                                    ParsableByteArray parsableByteArray3 = new ParsableByteArray(bArr10);
                                                                    VorbisBitArray vorbisBitArray2 = new VorbisBitArray(bArr10, i102);
                                                                    i5 = 8;
                                                                    vorbisBitArray2.setPosition(parsableByteArray3.position * 8);
                                                                    vorbisBitArray2.skipBytes(1);
                                                                    int bits20 = vorbisBitArray2.readBits(8);
                                                                    int i103 = 0;
                                                                    int i104 = -1;
                                                                    int i105 = -1;
                                                                    int i106 = -1;
                                                                    int i107 = -1;
                                                                    int i108 = -1;
                                                                    while (i103 < bits20) {
                                                                        vorbisBitArray2.skipBytes(1);
                                                                        int bits21 = vorbisBitArray2.readBits(8);
                                                                        int i109 = i108;
                                                                        int i110 = i107;
                                                                        int bits22 = i106;
                                                                        int iIsoTransferCharacteristicsToColorTransfer3 = i105;
                                                                        int i111 = i104;
                                                                        int i112 = 0;
                                                                        while (i112 < bits21) {
                                                                            vorbisBitArray2.skipBits(6);
                                                                            boolean bit8 = vorbisBitArray2.readBit();
                                                                            vorbisBitArray2.skipBit();
                                                                            vorbisBitArray2.skipBytes(i91);
                                                                            vorbisBitArray2.skipBits(4);
                                                                            bits22 = vorbisBitArray2.readBits(4) + 8;
                                                                            vorbisBitArray2.skipBytes(1);
                                                                            if (bit8) {
                                                                                int bits23 = vorbisBitArray2.readBits(8);
                                                                                int bits24 = vorbisBitArray2.readBits(8);
                                                                                vorbisBitArray2.skipBytes(1);
                                                                                boolean bit9 = vorbisBitArray2.readBit();
                                                                                int iIsoColorPrimariesToColorSpace5 = ColorInfo.isoColorPrimariesToColorSpace(bits23);
                                                                                i110 = bit9 ? 1 : 2;
                                                                                iIsoTransferCharacteristicsToColorTransfer3 = ColorInfo.isoTransferCharacteristicsToColorTransfer(bits24);
                                                                                i109 = iIsoColorPrimariesToColorSpace5;
                                                                            }
                                                                            i112++;
                                                                            i111 = bits22;
                                                                            i91 = 11;
                                                                        }
                                                                        i103++;
                                                                        i104 = i111;
                                                                        i105 = iIsoTransferCharacteristicsToColorTransfer3;
                                                                        i106 = bits22;
                                                                        i107 = i110;
                                                                        i108 = i109;
                                                                        i91 = 11;
                                                                    }
                                                                    str9 = "video/apv";
                                                                    iIsoTransferCharacteristicsToColorTransfer = i105;
                                                                    i36 = i106;
                                                                    i31 = i107;
                                                                    iIsoColorPrimariesToColorSpace = i108;
                                                                    i29 = i29;
                                                                    i28 = i104;
                                                                } else {
                                                                    i5 = 8;
                                                                    if (i40 == 1668246642) {
                                                                        i6 = iIsoTransferCharacteristicsToColorTransfer;
                                                                        if (iIsoColorPrimariesToColorSpace == -1 && i6 == -1) {
                                                                            int i113 = parsableByteArray2.readInt();
                                                                            if (i113 == 1852009592 || i113 == 1852009571) {
                                                                                int unsignedShort7 = parsableByteArray2.readUnsignedShort();
                                                                                int unsignedShort8 = parsableByteArray2.readUnsignedShort();
                                                                                parsableByteArray2.skipBytes(2);
                                                                                boolean z10 = i39 == 19 && (parsableByteArray2.readUnsignedByte() & 128) != 0;
                                                                                iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(unsignedShort7);
                                                                                i31 = z10 ? 1 : 2;
                                                                                iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(unsignedShort8);
                                                                            } else {
                                                                                Log.w("BoxParsers", "Unsupported color type: ".concat(Buffer.getBoxTypeString(i113)));
                                                                            }
                                                                        }
                                                                    } else {
                                                                        i6 = iIsoTransferCharacteristicsToColorTransfer;
                                                                    }
                                                                    iIsoTransferCharacteristicsToColorTransfer = i6;
                                                                }
                                                                i29 = i29;
                                                                i28 = i88;
                                                            }
                                                            i31 = i31;
                                                            i28 = i88;
                                                            i5 = 8;
                                                        }
                                                        i5 = 8;
                                                        i29 = i29;
                                                        i28 = i88;
                                                    }
                                                }
                                                bArr = null;
                                                i5 = 8;
                                                i29 = i29;
                                                i28 = i88;
                                            }
                                        }
                                        i31 = i31;
                                        i29 = i29;
                                        i28 = i88;
                                    }
                                    i5 = 8;
                                }
                            }
                        }
                    }
                    i27 = i38 + i39;
                    bArr2 = bArr;
                    i24 = i5;
                    iIntValue = i4;
                    i23 = i41;
                    str8 = str8;
                    str9 = str9;
                    i30 = iIsoTransferCharacteristicsToColorTransfer;
                    i36 = i36;
                    dispatcher = dispatcher;
                    b = 3;
                }
                int i114 = i28;
                int i115 = i29;
                i23 = i23;
                int i116 = i30;
                String str17 = str9;
                int i117 = i36;
                int i118 = i31;
                byte[] bArr12 = bArr2;
                if (joiner != null) {
                    str3 = joiner.separator;
                    str4 = "video/dolby-vision";
                } else {
                    str3 = string;
                    str4 = str17;
                }
                if (str4 == null) {
                    str5 = str;
                } else {
                    Format.Builder builder2 = new Format.Builder();
                    builder2.id = Integer.toString(i2);
                    builder2.sampleMimeType = MimeTypes.normalizeMimeType(str4);
                    builder2.codecs = str3;
                    builder2.width = unsignedShort;
                    builder2.height = unsignedShort2;
                    builder2.decodedWidth = i35;
                    builder2.decodedHeight = i34;
                    builder2.pixelWidthHeightRatio = unsignedIntToInt;
                    builder2.rotationDegrees = i25;
                    builder2.projectionData = bArr3;
                    builder2.stereoMode = i115;
                    builder2.initializationData = listOf;
                    builder2.maxNumReorderSamples = i33;
                    builder2.maxSubLayers = i32;
                    builder2.drmInitData = drmInitData3;
                    str5 = str;
                    builder2.language = str5;
                    builder2.colorInfo = new ColorInfo(iIsoColorPrimariesToColorSpace, i118, i116, byteBuffer != null ? byteBuffer.array() : bArr12, i117, i114);
                    EocdRecord eocdRecord2 = eocdRecord;
                    if (eocdRecord2 != null) {
                        builder2.averageBitrate = StringsKt__IndentKt.saturatedCast(eocdRecord2.entryCount);
                        builder2.peakBitrate = StringsKt__IndentKt.saturatedCast(eocdRecord2.centralDirectoryOffset);
                    } else {
                        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$2 = realStrongMemoryCache$cache$1;
                        if (realStrongMemoryCache$cache$2 != null) {
                            builder2.averageBitrate = StringsKt__IndentKt.saturatedCast(realStrongMemoryCache$cache$2.maxSize);
                            builder2.peakBitrate = StringsKt__IndentKt.saturatedCast(realStrongMemoryCache$cache$2.size);
                        }
                    }
                    stsdData.format = new Format(builder2);
                }
            } else {
                if (iIntValue == 1836069985 || iIntValue == 1701733217 || iIntValue == 1633889587 || iIntValue == 1700998451 || iIntValue == 1633889588 || iIntValue == 1835823201 || iIntValue == 1685353315 || iIntValue == 1685353317 || iIntValue == 1685353320 || iIntValue == 1685353324 || iIntValue == 1685353336 || iIntValue == 1935764850 || iIntValue == 1935767394 || iIntValue == 1819304813 || iIntValue == 1936684916 || iIntValue == 1953984371 || iIntValue == 778924082 || iIntValue == 778924083 || iIntValue == 1835557169 || iIntValue == 1835560241 || iIntValue == 1634492771 || iIntValue == 1634492791 || iIntValue == 1970037111 || iIntValue == 1332770163 || iIntValue == 1716281667 || iIntValue == 1767992678 || iIntValue == 1768973165 || iIntValue == 1718641517) {
                    parsableByteArray2 = parsableByteArray;
                    parseAudioSampleEntry(parsableByteArray2, iIntValue, i22, i23, tkhdData2.id, str7, z, drmInitData, stsdData, i21);
                    str5 = str;
                    i22 = i22;
                } else if (iIntValue == 1414810956 || iIntValue == 1954034535 || iIntValue == 2004251764 || iIntValue == 1937010800 || iIntValue == 1664495672 || iIntValue == 1836070003) {
                    parsableByteArray2.setPosition(i22 + 16);
                    String str18 = "application/ttml+xml";
                    long j2 = Long.MAX_VALUE;
                    if (iIntValue != 1414810956) {
                        if (iIntValue == 1954034535) {
                            int i119 = i23 - 16;
                            byte[] bArr13 = new byte[i119];
                            parsableByteArray2.readBytes(bArr13, 0, i119);
                            regularImmutableListOf = ImmutableList.of((Object) bArr13);
                            str18 = "application/x-quicktime-tx3g";
                            i18 = i22;
                        } else {
                            if (iIntValue == 2004251764) {
                                str18 = "application/x-mp4-vtt";
                            } else if (iIntValue == 1937010800) {
                                j2 = 0;
                            } else if (iIntValue == 1664495672) {
                                stsdData.requiredSampleTransformation = true;
                                str18 = "application/x-mp4-cea-608";
                            } else {
                                if (iIntValue != 1836070003) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                    return null;
                                }
                                int i120 = parsableByteArray2.position;
                                parsableByteArray2.skipBytes(4);
                                if (parsableByteArray2.readInt() == 1702061171) {
                                    byte[] bArr14 = (byte[]) parseEsdsFromParent(i120, parsableByteArray2).this$0;
                                    if (bArr14 == null || bArr14.length != 64) {
                                        i18 = i22;
                                    } else {
                                        int i121 = tkhdData2.width;
                                        int i122 = tkhdData2.height;
                                        UtilsKt.checkState(bArr14.length == 64);
                                        ArrayList arrayList = new ArrayList(16);
                                        int i123 = 0;
                                        while (i123 < bArr14.length - 3) {
                                            byte[] bArr15 = bArr14;
                                            int iFromBytes = StringsKt__IndentKt.fromBytes(bArr14[i123], bArr14[i123 + 1], bArr14[i123 + 2], bArr15[i123 + 3]);
                                            int i124 = (iFromBytes >> 16) & 255;
                                            int i125 = ((iFromBytes >> 8) & 255) - 128;
                                            int i126 = (iFromBytes & 255) - 128;
                                            arrayList.add(String.format("%06x", Integer.valueOf(Util.constrainValue(((i126 * 17790) / 10000) + i124, 0, 255) | (Util.constrainValue((i124 - ((i126 * 3455) / 10000)) - ((i125 * 7169) / 10000), 0, 255) << 8) | (Util.constrainValue(((i125 * 14075) / 10000) + i124, 0, 255) << 16))));
                                            i123 += 4;
                                            bArr14 = bArr15;
                                            i22 = i22;
                                        }
                                        i18 = i22;
                                        StringBuilder sbM3m2 = IntIntPair$$ExternalSyntheticOutline0.m3m(i121, "size: ", "x", i122, "\npalette: ");
                                        Joiner joiner2 = new Joiner(", ");
                                        Iterator it = arrayList.iterator();
                                        StringBuilder sb = new StringBuilder();
                                        joiner2.appendTo(sb, it);
                                        sbM3m2.append(sb.toString());
                                        sbM3m2.append("\n");
                                        String string2 = sbM3m2.toString();
                                        String str19 = Util.DEVICE_DEBUG_INFO;
                                        regularImmutableListOf = ImmutableList.of((Object) string2.getBytes(StandardCharsets.UTF_8));
                                        str6 = "application/vobsub";
                                    }
                                } else {
                                    i18 = i22;
                                    str6 = null;
                                    regularImmutableListOf = null;
                                }
                                str18 = str6;
                            }
                            i18 = i22;
                            regularImmutableListOf = null;
                        }
                        j = j2;
                        if (str18 != null) {
                            Format.Builder builder3 = new Format.Builder();
                            builder3.id = Integer.toString(i19);
                            builder3.sampleMimeType = MimeTypes.normalizeMimeType(str18);
                            builder3.language = str7;
                            builder3.subsampleOffsetUs = j;
                            builder3.initializationData = regularImmutableListOf;
                            stsdData.format = new Format(builder3);
                        }
                    } else {
                        i18 = i22;
                        regularImmutableListOf = null;
                        j = j2;
                        if (str18 != null) {
                            Format.Builder builder4 = new Format.Builder();
                            builder4.id = Integer.toString(i19);
                            builder4.sampleMimeType = MimeTypes.normalizeMimeType(str18);
                            builder4.language = str7;
                            builder4.subsampleOffsetUs = j;
                            builder4.initializationData = regularImmutableListOf;
                            stsdData.format = new Format(builder4);
                        }
                    }
                    parsableByteArray2 = parsableByteArray;
                    i23 = i23;
                    str5 = str7;
                    i = i21;
                    i2 = i19;
                    i3 = i20;
                    i22 = i18;
                } else {
                    if (iIntValue == 1835365492) {
                        parsableByteArray2.setPosition(i22 + 16);
                        if (iIntValue == 1835365492) {
                            parsableByteArray2.readNullTerminatedString();
                            String nullTerminatedString = parsableByteArray2.readNullTerminatedString();
                            if (nullTerminatedString != null) {
                                Format.Builder builder5 = new Format.Builder();
                                builder5.id = Integer.toString(i19);
                                builder5.sampleMimeType = MimeTypes.normalizeMimeType(nullTerminatedString);
                                stsdData.format = new Format(builder5);
                            }
                        }
                    } else if (iIntValue == 1667329389) {
                        Format.Builder builder6 = new Format.Builder();
                        builder6.id = Integer.toString(i19);
                        builder6.sampleMimeType = MimeTypes.normalizeMimeType("application/x-camera-motion");
                        stsdData.format = new Format(builder6);
                    }
                    i22 = i22;
                    str5 = str7;
                }
                i = i21;
                i2 = i19;
                i3 = i20;
            }
            parsableByteArray2.setPosition(i22 + i23);
            i21 = i + 1;
            tkhdData2 = tkhdData;
            str7 = str5;
            i19 = i2;
            i20 = i3;
        }
        return stsdData;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:105:0x01ec A[EDGE_INSN: B:105:0x01ec->B:104:0x01e9 BREAK  A[LOOP:18: B:95:0x01cc->B:106:0x01f8]] */
    /* JADX WARN: Code duplicated, block: B:106:0x01f8 A[LOOP:18: B:95:0x01cc->B:106:0x01f8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:110:0x0225  */
    /* JADX WARN: Code duplicated, block: B:120:0x0244  */
    /* JADX WARN: Code duplicated, block: B:122:0x024f  */
    /* JADX WARN: Code duplicated, block: B:147:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:151:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:153:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:155:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:156:0x0304  */
    /* JADX WARN: Code duplicated, block: B:158:0x0318  */
    /* JADX WARN: Code duplicated, block: B:212:0x0498  */
    /* JADX WARN: Code duplicated, block: B:215:0x04a0  */
    /* JADX WARN: Code duplicated, block: B:216:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:218:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:221:0x04b3 A[LOOP:1: B:219:0x04ad->B:221:0x04b3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:224:0x04c6 A[LOOP:2: B:223:0x04c4->B:224:0x04c6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:227:0x04e7  */
    /* JADX WARN: Code duplicated, block: B:229:0x04fb A[LOOP:4: B:228:0x04f9->B:229:0x04fb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:233:0x053b  */
    /* JADX WARN: Code duplicated, block: B:235:0x053f  */
    /* JADX WARN: Code duplicated, block: B:237:0x0543  */
    /* JADX WARN: Code duplicated, block: B:239:0x0547  */
    /* JADX WARN: Code duplicated, block: B:242:0x055a  */
    /* JADX WARN: Code duplicated, block: B:244:0x055d  */
    /* JADX WARN: Code duplicated, block: B:245:0x0560  */
    /* JADX WARN: Code duplicated, block: B:248:0x0566  */
    /* JADX WARN: Code duplicated, block: B:249:0x0569  */
    /* JADX WARN: Code duplicated, block: B:252:0x056f  */
    /* JADX WARN: Code duplicated, block: B:253:0x0572  */
    /* JADX WARN: Code duplicated, block: B:256:0x0578  */
    /* JADX WARN: Code duplicated, block: B:257:0x057b  */
    /* JADX WARN: Code duplicated, block: B:260:0x059d  */
    /* JADX WARN: Code duplicated, block: B:262:0x05a1  */
    /* JADX WARN: Code duplicated, block: B:264:0x05a7 A[LOOP:14: B:261:0x059f->B:264:0x05a7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:269:0x05c5 A[EDGE_INSN: B:269:0x05c5->B:300:0x067c BREAK  A[LOOP:13: B:259:0x059b->B:298:0x0660]] */
    /* JADX WARN: Code duplicated, block: B:270:0x05df A[EDGE_INSN: B:270:0x05df->B:300:0x067c BREAK  A[LOOP:13: B:259:0x059b->B:298:0x0660]] */
    /* JADX WARN: Code duplicated, block: B:271:0x05e9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:272:0x05eb A[ADDED_TO_REGION, LOOP:15: B:272:0x05eb->B:274:0x05ef, LOOP_START, PHI: r3 r24 r25
      0x05eb: PHI (r3v14 int) = (r3v3 int), (r3v15 int) binds: [B:271:0x05e9, B:274:0x05ef] A[DONT_GENERATE, DONT_INLINE]
      0x05eb: PHI (r24v8 int) = (r24v6 int), (r24v10 int) binds: [B:271:0x05e9, B:274:0x05ef] A[DONT_GENERATE, DONT_INLINE]
      0x05eb: PHI (r25v7 int) = (r25v2 int), (r25v8 int) binds: [B:271:0x05e9, B:274:0x05ef] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:278:0x0607  */
    /* JADX WARN: Code duplicated, block: B:280:0x060a  */
    /* JADX WARN: Code duplicated, block: B:282:0x0618  */
    /* JADX WARN: Code duplicated, block: B:283:0x061a  */
    /* JADX WARN: Code duplicated, block: B:286:0x061f  */
    /* JADX WARN: Code duplicated, block: B:288:0x0630  */
    /* JADX WARN: Code duplicated, block: B:290:0x0636 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:296:0x0652 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:302:0x0681 A[DONT_INVERT, LOOP:16: B:302:0x0681->B:306:0x068b, LOOP_START, PHI: r25
      0x0681: PHI (r25v4 int) = (r25v2 int), (r25v5 int) binds: [B:301:0x067f, B:306:0x068b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:303:0x0683  */
    /* JADX WARN: Code duplicated, block: B:306:0x068b A[LOOP:16: B:302:0x0681->B:306:0x068b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:307:0x0691 A[EDGE_INSN: B:307:0x0691->B:308:0x0692 BREAK  A[LOOP:16: B:302:0x0681->B:306:0x068b]] */
    /* JADX WARN: Code duplicated, block: B:314:0x069e  */
    /* JADX WARN: Code duplicated, block: B:316:0x06d8  */
    /* JADX WARN: Code duplicated, block: B:317:0x06db  */
    /* JADX WARN: Code duplicated, block: B:322:0x06fb  */
    /* JADX WARN: Code duplicated, block: B:329:0x073d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:330:0x073f  */
    /* JADX WARN: Code duplicated, block: B:333:0x0753  */
    /* JADX WARN: Code duplicated, block: B:335:0x0759  */
    /* JADX WARN: Code duplicated, block: B:341:0x077a  */
    /* JADX WARN: Code duplicated, block: B:344:0x077e  */
    /* JADX WARN: Code duplicated, block: B:346:0x0784  */
    /* JADX WARN: Code duplicated, block: B:350:0x07a1  */
    /* JADX WARN: Code duplicated, block: B:375:0x085b  */
    /* JADX WARN: Code duplicated, block: B:378:0x0865  */
    /* JADX WARN: Code duplicated, block: B:380:0x086f  */
    /* JADX WARN: Code duplicated, block: B:383:0x0878 A[LOOP:6: B:381:0x0875->B:383:0x0878, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:385:0x08a6  */
    /* JADX WARN: Code duplicated, block: B:388:0x08b1  */
    /* JADX WARN: Code duplicated, block: B:389:0x08b3  */
    /* JADX WARN: Code duplicated, block: B:393:0x08c6  */
    /* JADX WARN: Code duplicated, block: B:395:0x08ce  */
    /* JADX WARN: Code duplicated, block: B:398:0x08f9  */
    /* JADX WARN: Code duplicated, block: B:400:0x08ff  */
    /* JADX WARN: Code duplicated, block: B:401:0x0901  */
    /* JADX WARN: Code duplicated, block: B:408:0x0915  */
    /* JADX WARN: Code duplicated, block: B:414:0x0928  */
    /* JADX WARN: Code duplicated, block: B:419:0x0936  */
    /* JADX WARN: Code duplicated, block: B:424:0x094c  */
    /* JADX WARN: Code duplicated, block: B:425:0x094e  */
    /* JADX WARN: Code duplicated, block: B:427:0x0956  */
    /* JADX WARN: Code duplicated, block: B:431:0x0974  */
    /* JADX WARN: Code duplicated, block: B:432:0x0976  */
    /* JADX WARN: Code duplicated, block: B:435:0x097c  */
    /* JADX WARN: Code duplicated, block: B:436:0x097f  */
    /* JADX WARN: Code duplicated, block: B:438:0x0982  */
    /* JADX WARN: Code duplicated, block: B:439:0x0985  */
    /* JADX WARN: Code duplicated, block: B:441:0x0988  */
    /* JADX WARN: Code duplicated, block: B:443:0x098c  */
    /* JADX WARN: Code duplicated, block: B:444:0x098f  */
    /* JADX WARN: Code duplicated, block: B:446:0x0992  */
    /* JADX WARN: Code duplicated, block: B:447:0x0998  */
    /* JADX WARN: Code duplicated, block: B:451:0x09a9  */
    /* JADX WARN: Code duplicated, block: B:453:0x09b5  */
    /* JADX WARN: Code duplicated, block: B:456:0x09c4  */
    /* JADX WARN: Code duplicated, block: B:458:0x09ee  */
    /* JADX WARN: Code duplicated, block: B:461:0x09f5  */
    /* JADX WARN: Code duplicated, block: B:465:0x09fd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:473:0x0a35  */
    /* JADX WARN: Code duplicated, block: B:493:0x0788 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:498:0x090b A[EDGE_INSN: B:498:0x090b->B:405:0x090b BREAK  A[LOOP:8: B:396:0x08f6->B:404:0x0908], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:501:0x0908 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:502:0x0922 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:504:0x0943 A[ADDED_TO_REGION, EDGE_INSN: B:504:0x0943->B:422:0x0943 BREAK  A[LOOP:10: B:417:0x0930->B:421:0x093c], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:509:0x0a0e A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:512:0x0672 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:513:0x05be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:515:0x0660 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:518:0x05b8 A[EDGE_INSN: B:518:0x05b8->B:265:0x05b8 BREAK  A[LOOP:14: B:261:0x059f->B:264:0x05a7], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:521:0x0689 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:522:0x0691 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:525:0x01d7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:526:0x01fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:528:0x0236 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x0162  */
    /* JADX WARN: Code duplicated, block: B:80:0x0165  */
    /* JADX WARN: Code duplicated, block: B:83:0x0173  */
    /* JADX WARN: Code duplicated, block: B:85:0x017b  */
    /* JADX WARN: Code duplicated, block: B:88:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:89:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:92:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:93:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:96:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:99:0x01d9  */
    public static ArrayList parseTraks(Mp4Box$ContainerBox mp4Box$ContainerBox, GaplessInfoHolder gaplessInfoHolder, long j, DrmInitData drmInitData, boolean z, boolean z2, Function function, boolean z3) {
        int i;
        int i2;
        long j2;
        long jScaleLargeValue;
        long j3;
        int i3;
        int i4;
        TkhdData tkhdData;
        long j4;
        long j5;
        long j6;
        long jScaleLargeValue2;
        ParsableByteArray parsableByteArray;
        int fullBoxVersion;
        int i5;
        long unsignedInt;
        int i6;
        int i7;
        int i8;
        long j7;
        char[] cArr;
        int i9;
        String str;
        Mp4Box$LeafBox leafBoxOfType;
        StsdData stsd;
        long[] jArr;
        long[] jArr2;
        Format format;
        int i10;
        Format format2;
        Track track;
        Mp4AlternateGroupData mp4AlternateGroupData;
        Metadata metadata;
        Metadata metadata2;
        Mp4Box$ContainerBox containerBoxOfType;
        Pair pairCreate;
        char c;
        long unsignedLongToLong;
        long j8;
        SampleSizeBox stz2SampleSizeBox;
        boolean z4;
        ArrayList arrayList;
        int unsignedIntToInt;
        int unsignedIntToInt2;
        int unsignedIntToInt3;
        int fixedSampleSize;
        ParsableByteArray parsableByteArray2;
        boolean z5;
        ArrayList arrayList2;
        boolean z6;
        long[] jArr3;
        int[] iArrCopyOf;
        SampleSizeBox sampleSizeBox;
        long[] jArr4;
        int[] iArr;
        int i11;
        int i12;
        int i13;
        int i14;
        long j9;
        long j10;
        long j11;
        int i15;
        int i16;
        int i17;
        int unsignedIntToInt4;
        int i18;
        int unsignedIntToInt5;
        ParsableByteArray parsableByteArray3;
        int i19;
        ArrayList arrayList3;
        long[] jArr5;
        long[] jArr6;
        int[] iArrCopyOf2;
        int i20;
        boolean z7;
        String str2;
        int i21;
        int[] iArr2;
        int i22;
        long j12;
        long j13;
        boolean zMoveNext;
        int i23;
        ArrayList arrayList4;
        int nextSampleSize;
        int i24;
        int[] iArr3;
        ArrayList arrayList5;
        int i25;
        long[] jArr7;
        int[] iArr4;
        long j14;
        int i26;
        long j15;
        Format format3;
        long[] jArr8;
        long[] jArr9;
        long jScaleLargeValue3;
        int[] array;
        long[] jArr10;
        long j16;
        int i27;
        int[] iArr5;
        int i28;
        boolean z8;
        int[] iArr6;
        int[] iArr7;
        int i29;
        int i30;
        boolean z9;
        int i31;
        int[] iArr8;
        int[] iArr9;
        boolean z10;
        boolean z11;
        long[] jArr11;
        int[] iArr10;
        int[] iArr11;
        ArrayList arrayList6;
        long[] jArr12;
        int i32;
        boolean z12;
        int i33;
        int i34;
        long j17;
        Format format4;
        TrackSampleTable trackSampleTable;
        long j18;
        int i35;
        int i36;
        int i37;
        int i38;
        long jScaleLargeValue4;
        int[] iArr12;
        long j19;
        int[] iArr13;
        int i39;
        long jScaleLargeValue5;
        int iBinarySearchCeil;
        int i40;
        int i41;
        int i42;
        int i43;
        int i44;
        boolean z13;
        int i45;
        long j20;
        int i46;
        TrackSampleTable trackSampleTable2;
        int i47;
        long jScaleLargeValue6;
        long jScaleLargeValue7;
        int i48;
        long[] jArr13;
        int[] iArr14;
        long j21;
        int i49;
        int i50;
        int iCeilDivide;
        int[] iArr15;
        int i51;
        int i52;
        int i53;
        int i54;
        int i55;
        long j22;
        int i56;
        int i57;
        int i58;
        Mp4Box$ContainerBox mp4Box$ContainerBox2 = mp4Box$ContainerBox;
        ArrayList arrayList7 = mp4Box$ContainerBox2.containerChildren;
        ArrayList arrayList8 = new ArrayList();
        int i59 = 0;
        while (i59 < arrayList7.size()) {
            Mp4Box$ContainerBox mp4Box$ContainerBox3 = (Mp4Box$ContainerBox) arrayList7.get(i59);
            if (mp4Box$ContainerBox3.flags != 1953653099) {
                arrayList = arrayList7;
                arrayList8 = arrayList8;
                i2 = i59;
            } else {
                Mp4Box$LeafBox leafBoxOfType2 = mp4Box$ContainerBox2.getLeafBoxOfType(1836476516);
                leafBoxOfType2.getClass();
                Mp4Box$ContainerBox containerBoxOfType2 = mp4Box$ContainerBox3.getContainerBoxOfType(1835297121);
                containerBoxOfType2.getClass();
                Mp4Box$LeafBox leafBoxOfType3 = containerBoxOfType2.getLeafBoxOfType(1751411826);
                leafBoxOfType3.getClass();
                ParsableByteArray parsableByteArray4 = leafBoxOfType3.data;
                parsableByteArray4.setPosition(16);
                int i60 = parsableByteArray4.readInt();
                if (i60 == 1936684398) {
                    i = 1;
                } else if (i60 == 1986618469) {
                    i = 2;
                } else if (i60 == 1952807028 || i60 == 1935832172 || i60 == 1937072756 || i60 == 1668047728 || i60 == 1937072752) {
                    i = 3;
                } else {
                    i = i60 == 1835365473 ? 5 : -1;
                }
                int i61 = 1;
                i2 = i59;
                if (i == -1) {
                    track = null;
                    j2 = 0;
                } else {
                    j2 = 0;
                    Mp4Box$LeafBox leafBoxOfType4 = mp4Box$ContainerBox3.getLeafBoxOfType(1953196132);
                    leafBoxOfType4.getClass();
                    ParsableByteArray parsableByteArray5 = leafBoxOfType4.data;
                    parsableByteArray5.setPosition(8);
                    int fullBoxVersion2 = parseFullBoxVersion(parsableByteArray5.readInt());
                    parsableByteArray5.skipBytes(fullBoxVersion2 != 0 ? 16 : 8);
                    int i62 = parsableByteArray5.readInt();
                    parsableByteArray5.skipBytes(4);
                    int i63 = parsableByteArray5.position;
                    int i64 = fullBoxVersion2 == 0 ? 4 : 8;
                    int i65 = 0;
                    while (true) {
                        jScaleLargeValue = -9223372036854775807L;
                        if (i65 >= i64) {
                            parsableByteArray5.skipBytes(i64);
                        } else {
                            if (parsableByteArray5.data[i63 + i65] != -1) {
                                long unsignedInt2 = fullBoxVersion2 == 0 ? parsableByteArray5.readUnsignedInt() : parsableByteArray5.readUnsignedLongToLong();
                                if (unsignedInt2 != 0) {
                                    j3 = unsignedInt2;
                                    break;
                                }
                                break;
                            }
                            i65++;
                        }
                        j3 = -9223372036854775807L;
                        break;
                    }
                    parsableByteArray5.skipBytes(10);
                    int unsignedShort = parsableByteArray5.readUnsignedShort();
                    parsableByteArray5.skipBytes(4);
                    int i66 = parsableByteArray5.readInt();
                    int i67 = parsableByteArray5.readInt();
                    parsableByteArray5.skipBytes(4);
                    int i68 = parsableByteArray5.readInt();
                    int i69 = parsableByteArray5.readInt();
                    if (i66 == 0 && i67 == 65536 && ((i68 == -65536 || i68 == 65536) && i69 == 0)) {
                        i3 = 90;
                    } else if (i66 == 0 && i67 == -65536 && ((i68 == 65536 || i68 == -65536) && i69 == 0)) {
                        i3 = 270;
                    } else {
                        if ((i66 == -65536 || i66 == 65536) && i67 == 0 && i68 == 0 && i69 == -65536) {
                            i3 = 180;
                        } else {
                            i4 = 0;
                        }
                        parsableByteArray5.skipBytes(16);
                        short s = parsableByteArray5.readShort();
                        parsableByteArray5.skipBytes(2);
                        tkhdData = new TkhdData(i62, unsignedShort, i4, s, parsableByteArray5.readShort(), j3);
                        if (j == -9223372036854775807L) {
                            j4 = j3;
                        } else {
                            j4 = j;
                        }
                        j5 = parseMvhd(leafBoxOfType2.data).timescale;
                        if (j4 == -9223372036854775807L) {
                            j6 = j5;
                            jScaleLargeValue2 = -9223372036854775807L;
                        } else {
                            String str3 = Util.DEVICE_DEBUG_INFO;
                            j6 = j5;
                            jScaleLargeValue2 = Util.scaleLargeValue(j4, 1000000L, j6, RoundingMode.DOWN);
                        }
                        Mp4Box$ContainerBox containerBoxOfType3 = containerBoxOfType2.getContainerBoxOfType(1835626086);
                        containerBoxOfType3.getClass();
                        Mp4Box$ContainerBox containerBoxOfType4 = containerBoxOfType3.getContainerBoxOfType(1937007212);
                        containerBoxOfType4.getClass();
                        Mp4Box$LeafBox leafBoxOfType5 = containerBoxOfType2.getLeafBoxOfType(1835296868);
                        leafBoxOfType5.getClass();
                        parsableByteArray = leafBoxOfType5.data;
                        parsableByteArray.setPosition(8);
                        fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
                        if (fullBoxVersion == 0) {
                            i5 = 8;
                        } else {
                            i5 = 16;
                        }
                        parsableByteArray.skipBytes(i5);
                        unsignedInt = parsableByteArray.readUnsignedInt();
                        i6 = parsableByteArray.position;
                        if (fullBoxVersion == 0) {
                            i7 = 4;
                        } else {
                            i7 = 8;
                        }
                        i8 = 0;
                        while (true) {
                            if (i8 < i7) {
                                parsableByteArray.skipBytes(i7);
                                break;
                            }
                            if (parsableByteArray.data[i6 + i8] != -1) {
                                if (fullBoxVersion == 0) {
                                    unsignedLongToLong = parsableByteArray.readUnsignedInt();
                                } else {
                                    unsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
                                }
                                j8 = unsignedLongToLong;
                                if (j8 != 0) {
                                    break;
                                }
                                String str4 = Util.DEVICE_DEBUG_INFO;
                                jScaleLargeValue = Util.scaleLargeValue(j8, 1000000L, unsignedInt, RoundingMode.DOWN);
                                break;
                            }
                            i8++;
                        }
                        j7 = jScaleLargeValue;
                        int unsignedShort2 = parsableByteArray.readUnsignedShort();
                        cArr = new char[]{(char) (((unsignedShort2 >> 10) & 31) + 96), (char) (((unsignedShort2 >> 5) & 31) + 96), (char) ((unsignedShort2 & 31) + 96)};
                        i9 = 0;
                        while (true) {
                            if (i9 < 3) {
                                str = new String(cArr);
                                break;
                            }
                            c = cArr[i9];
                            if (c >= 'a' || c > 'z') {
                                str = null;
                                break;
                            }
                            i9++;
                        }
                        leafBoxOfType = containerBoxOfType4.getLeafBoxOfType(1937011556);
                        if (leafBoxOfType == null) {
                            Log.w("BoxParsers", "Ignoring track where sample table (stbl) box is missing a sample description (stsd).");
                        } else {
                            stsd = parseStsd(leafBoxOfType.data, tkhdData, str, drmInitData, z2);
                            if (!z || (containerBoxOfType = mp4Box$ContainerBox3.getContainerBoxOfType(1701082227)) == null) {
                                jArr = null;
                                jArr2 = null;
                            } else {
                                Mp4Box$LeafBox leafBoxOfType6 = containerBoxOfType.getLeafBoxOfType(1701606260);
                                if (leafBoxOfType6 == null) {
                                    pairCreate = null;
                                } else {
                                    ParsableByteArray parsableByteArray6 = leafBoxOfType6.data;
                                    parsableByteArray6.setPosition(8);
                                    int fullBoxVersion3 = parseFullBoxVersion(parsableByteArray6.readInt());
                                    int unsignedIntToInt6 = parsableByteArray6.readUnsignedIntToInt();
                                    long[] jArr14 = new long[unsignedIntToInt6];
                                    long[] jArr15 = new long[unsignedIntToInt6];
                                    int i70 = 0;
                                    while (i70 < unsignedIntToInt6) {
                                        int i71 = i70;
                                        int i72 = i61;
                                        jArr14[i71] = fullBoxVersion3 == i72 ? parsableByteArray6.readUnsignedLongToLong() : parsableByteArray6.readUnsignedInt();
                                        jArr15[i71] = fullBoxVersion3 == i72 ? parsableByteArray6.readLong() : parsableByteArray6.readInt();
                                        if (parsableByteArray6.readShort() != 1) {
                                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Unsupported media rate.");
                                            return null;
                                        }
                                        parsableByteArray6.skipBytes(2);
                                        i70 = i71 + 1;
                                        i61 = 1;
                                    }
                                    pairCreate = Pair.create(jArr14, jArr15);
                                }
                                if (pairCreate != null) {
                                    long[] jArr16 = (long[]) pairCreate.first;
                                    jArr2 = (long[]) pairCreate.second;
                                    jArr = jArr16;
                                } else {
                                    jArr = null;
                                    jArr2 = null;
                                }
                            }
                            format = (Format) stsd.format;
                            if (format == null) {
                                i10 = tkhdData.alternateGroup;
                                if (i10 != 0) {
                                    mp4AlternateGroupData = new Mp4AlternateGroupData(i10);
                                    Format.Builder builderBuildUpon = format.buildUpon();
                                    metadata = ((Format) stsd.format).metadata;
                                    if (metadata != null) {
                                        metadata2 = metadata.copyWithAppendedEntries(mp4AlternateGroupData);
                                    } else {
                                        metadata2 = new Metadata(mp4AlternateGroupData);
                                    }
                                    builderBuildUpon.metadata = metadata2;
                                    format2 = new Format(builderBuildUpon);
                                } else {
                                    format2 = format;
                                }
                                track = new Track(tkhdData.id, i, unsignedInt, j6, jScaleLargeValue2, j7, format2, stsd.requiredSampleTransformation ? 1 : 0, (TrackEncryptionBox[]) stsd.trackEncryptionBoxes, stsd.nalUnitLengthFieldLength, jArr, jArr2);
                            }
                        }
                        track = null;
                    }
                    i4 = i3;
                    parsableByteArray5.skipBytes(16);
                    short s2 = parsableByteArray5.readShort();
                    parsableByteArray5.skipBytes(2);
                    tkhdData = new TkhdData(i62, unsignedShort, i4, s2, parsableByteArray5.readShort(), j3);
                    if (j == -9223372036854775807L) {
                        j4 = j3;
                    } else {
                        j4 = j;
                    }
                    j5 = parseMvhd(leafBoxOfType2.data).timescale;
                    if (j4 == -9223372036854775807L) {
                        j6 = j5;
                        jScaleLargeValue2 = -9223372036854775807L;
                    } else {
                        String str5 = Util.DEVICE_DEBUG_INFO;
                        j6 = j5;
                        jScaleLargeValue2 = Util.scaleLargeValue(j4, 1000000L, j6, RoundingMode.DOWN);
                    }
                    Mp4Box$ContainerBox containerBoxOfType5 = containerBoxOfType2.getContainerBoxOfType(1835626086);
                    containerBoxOfType5.getClass();
                    Mp4Box$ContainerBox containerBoxOfType6 = containerBoxOfType5.getContainerBoxOfType(1937007212);
                    containerBoxOfType6.getClass();
                    Mp4Box$LeafBox leafBoxOfType7 = containerBoxOfType2.getLeafBoxOfType(1835296868);
                    leafBoxOfType7.getClass();
                    parsableByteArray = leafBoxOfType7.data;
                    parsableByteArray.setPosition(8);
                    fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
                    if (fullBoxVersion == 0) {
                        i5 = 8;
                    } else {
                        i5 = 16;
                    }
                    parsableByteArray.skipBytes(i5);
                    unsignedInt = parsableByteArray.readUnsignedInt();
                    i6 = parsableByteArray.position;
                    if (fullBoxVersion == 0) {
                        i7 = 4;
                    } else {
                        i7 = 8;
                    }
                    i8 = 0;
                    while (true) {
                        if (i8 < i7) {
                            parsableByteArray.skipBytes(i7);
                            break;
                        }
                        if (parsableByteArray.data[i6 + i8] != -1) {
                            if (fullBoxVersion == 0) {
                                unsignedLongToLong = parsableByteArray.readUnsignedInt();
                            } else {
                                unsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
                            }
                            j8 = unsignedLongToLong;
                            if (j8 != 0) {
                                break;
                            }
                            String str6 = Util.DEVICE_DEBUG_INFO;
                            jScaleLargeValue = Util.scaleLargeValue(j8, 1000000L, unsignedInt, RoundingMode.DOWN);
                            break;
                        }
                        i8++;
                    }
                    j7 = jScaleLargeValue;
                    int unsignedShort3 = parsableByteArray.readUnsignedShort();
                    cArr = new char[]{(char) (((unsignedShort3 >> 10) & 31) + 96), (char) (((unsignedShort3 >> 5) & 31) + 96), (char) ((unsignedShort3 & 31) + 96)};
                    i9 = 0;
                    while (true) {
                        if (i9 < 3) {
                            c = cArr[i9];
                            if (c >= 'a') {
                            }
                            str = null;
                            break;
                        }
                        str = new String(cArr);
                        break;
                        i9++;
                    }
                    leafBoxOfType = containerBoxOfType6.getLeafBoxOfType(1937011556);
                    if (leafBoxOfType == null) {
                        Log.w("BoxParsers", "Ignoring track where sample table (stbl) box is missing a sample description (stsd).");
                    } else {
                        stsd = parseStsd(leafBoxOfType.data, tkhdData, str, drmInitData, z2);
                        if (z) {
                            jArr = null;
                            jArr2 = null;
                        } else {
                            jArr = null;
                            jArr2 = null;
                        }
                        format = (Format) stsd.format;
                        if (format == null) {
                            i10 = tkhdData.alternateGroup;
                            if (i10 != 0) {
                                mp4AlternateGroupData = new Mp4AlternateGroupData(i10);
                                Format.Builder builderBuildUpon2 = format.buildUpon();
                                metadata = ((Format) stsd.format).metadata;
                                if (metadata != null) {
                                    metadata2 = metadata.copyWithAppendedEntries(mp4AlternateGroupData);
                                } else {
                                    metadata2 = new Metadata(mp4AlternateGroupData);
                                }
                                builderBuildUpon2.metadata = metadata2;
                                format2 = new Format(builderBuildUpon2);
                            } else {
                                format2 = format;
                            }
                            track = new Track(tkhdData.id, i, unsignedInt, j6, jScaleLargeValue2, j7, format2, stsd.requiredSampleTransformation ? 1 : 0, (TrackEncryptionBox[]) stsd.trackEncryptionBoxes, stsd.nalUnitLengthFieldLength, jArr, jArr2);
                        }
                    }
                    track = null;
                }
                Track trackCopyWithFormat = (Track) function.apply(track);
                if (trackCopyWithFormat == null) {
                    arrayList = arrayList7;
                    arrayList8 = arrayList8;
                } else {
                    Format format5 = trackCopyWithFormat.format;
                    Mp4Box$ContainerBox containerBoxOfType7 = mp4Box$ContainerBox3.getContainerBoxOfType(1835297121);
                    containerBoxOfType7.getClass();
                    Mp4Box$ContainerBox containerBoxOfType8 = containerBoxOfType7.getContainerBoxOfType(1835626086);
                    containerBoxOfType8.getClass();
                    Mp4Box$ContainerBox containerBoxOfType9 = containerBoxOfType8.getContainerBoxOfType(1937007212);
                    containerBoxOfType9.getClass();
                    Mp4Box$LeafBox leafBoxOfType8 = containerBoxOfType9.getLeafBoxOfType(1937011578);
                    if (leafBoxOfType8 != null) {
                        stz2SampleSizeBox = new Huffman.Node(leafBoxOfType8, format5);
                    } else {
                        Mp4Box$LeafBox leafBoxOfType9 = containerBoxOfType9.getLeafBoxOfType(1937013298);
                        if (leafBoxOfType9 == null) {
                            throw ParserException.createForMalformedContainer(null, "Track has no sample table size information");
                        }
                        stz2SampleSizeBox = new Stz2SampleSizeBox(leafBoxOfType9);
                    }
                    int sampleCount = stz2SampleSizeBox.getSampleCount();
                    if (sampleCount == 0) {
                        trackSampleTable = new TrackSampleTable(trackCopyWithFormat, new long[0], new int[0], 0, new long[0], new int[0], new int[0], false, 0L, 0);
                        arrayList = arrayList7;
                    } else {
                        if (trackCopyWithFormat.type == 2) {
                            long j23 = trackCopyWithFormat.mediaDurationUs;
                            if (j23 > j2) {
                                Format.Builder builderBuildUpon3 = format5.buildUpon();
                                builderBuildUpon3.frameRate = sampleCount / (j23 / 1000000.0f);
                                trackCopyWithFormat = trackCopyWithFormat.copyWithFormat(new Format(builderBuildUpon3));
                            }
                        }
                        Format format6 = trackCopyWithFormat.format;
                        Mp4Box$LeafBox leafBoxOfType10 = containerBoxOfType9.getLeafBoxOfType(1937007471);
                        if (leafBoxOfType10 == null) {
                            leafBoxOfType10 = containerBoxOfType9.getLeafBoxOfType(1668232756);
                            leafBoxOfType10.getClass();
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        ParsableByteArray parsableByteArray7 = leafBoxOfType10.data;
                        Mp4Box$LeafBox leafBoxOfType11 = containerBoxOfType9.getLeafBoxOfType(1937011555);
                        leafBoxOfType11.getClass();
                        ParsableByteArray parsableByteArray8 = leafBoxOfType11.data;
                        Mp4Box$LeafBox leafBoxOfType12 = containerBoxOfType9.getLeafBoxOfType(1937011827);
                        leafBoxOfType12.getClass();
                        ParsableByteArray parsableByteArray9 = leafBoxOfType12.data;
                        Mp4Box$LeafBox leafBoxOfType13 = containerBoxOfType9.getLeafBoxOfType(1937011571);
                        ParsableByteArray parsableByteArray10 = leafBoxOfType13 != null ? leafBoxOfType13.data : null;
                        Mp4Box$LeafBox leafBoxOfType14 = containerBoxOfType9.getLeafBoxOfType(1668576371);
                        ParsableByteArray parsableByteArray11 = leafBoxOfType14 != null ? leafBoxOfType14.data : null;
                        ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray8, parsableByteArray7, z4);
                        parsableByteArray9.setPosition(12);
                        int unsignedIntToInt7 = parsableByteArray9.readUnsignedIntToInt() - 1;
                        int unsignedIntToInt8 = parsableByteArray9.readUnsignedIntToInt();
                        arrayList = arrayList7;
                        int unsignedIntToInt9 = parsableByteArray9.readUnsignedIntToInt();
                        if (parsableByteArray11 != null) {
                            parsableByteArray11.setPosition(12);
                            unsignedIntToInt = parsableByteArray11.readUnsignedIntToInt();
                        } else {
                            unsignedIntToInt = 0;
                        }
                        if (parsableByteArray10 != null) {
                            parsableByteArray10.setPosition(12);
                            unsignedIntToInt2 = parsableByteArray10.readUnsignedIntToInt();
                            if (unsignedIntToInt2 > 0) {
                                unsignedIntToInt3 = parsableByteArray10.readUnsignedIntToInt() - 1;
                            } else {
                                parsableByteArray10 = null;
                            }
                            fixedSampleSize = stz2SampleSizeBox.getFixedSampleSize();
                            parsableByteArray2 = parsableByteArray11;
                            String str7 = format6.sampleMimeType;
                            if (fixedSampleSize == -1 && (("audio/raw".equals(str7) || "audio/g711-mlaw".equals(str7) || "audio/g711-alaw".equals(str7)) && unsignedIntToInt7 == 0 && unsignedIntToInt == 0 && unsignedIntToInt2 == 0)) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            arrayList2 = new ArrayList();
                            if (parsableByteArray10 == null) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (z5) {
                                i48 = chunkIterator.length;
                                jArr13 = new long[i48];
                                iArr14 = new int[i48];
                                while (chunkIterator.moveNext()) {
                                    int i73 = chunkIterator.index;
                                    jArr13[i73] = chunkIterator.offset;
                                    iArr14[i73] = chunkIterator.numSamples;
                                }
                                j21 = unsignedIntToInt9;
                                i49 = 8192 / fixedSampleSize;
                                iCeilDivide = 0;
                                for (i50 = 0; i50 < i48; i50++) {
                                    iCeilDivide += Util.ceilDivide(iArr14[i50], i49);
                                }
                                jArr5 = new long[iCeilDivide];
                                iArr15 = new int[iCeilDivide];
                                jArr6 = new long[iCeilDivide];
                                iArrCopyOf2 = new int[iCeilDivide];
                                i51 = 0;
                                i52 = 0;
                                i53 = 0;
                                i54 = 0;
                                i55 = 0;
                                while (i51 < i48) {
                                    int i74 = iArr14[i51];
                                    j22 = jArr13[i51];
                                    int i75 = i55;
                                    int i76 = i51;
                                    i56 = i54;
                                    i57 = i75;
                                    int i77 = i48;
                                    i58 = i74;
                                    while (i58 > 0) {
                                        int iMin = Math.min(i49, i58);
                                        jArr5[i57] = j22;
                                        int i78 = i49;
                                        int i79 = fixedSampleSize * iMin;
                                        iArr15[i57] = i79;
                                        i53 += i79;
                                        int iMax = Math.max(i56, i79);
                                        jArr6[i57] = ((long) i52) * j21;
                                        iArrCopyOf2[i57] = 1;
                                        j22 += (long) iArr15[i57];
                                        i52 += iMin;
                                        i58 -= iMin;
                                        i57++;
                                        i49 = i78;
                                        i56 = iMax;
                                    }
                                    int i80 = i49;
                                    int i81 = i76 + 1;
                                    i55 = i57;
                                    i48 = i77;
                                    i54 = i56;
                                    i51 = i81;
                                    i49 = i80;
                                }
                                long j24 = j21 * ((long) i52);
                                j13 = i53;
                                if (z3) {
                                    jArr5 = new long[0];
                                }
                                if (z3) {
                                    iArr15 = new int[0];
                                }
                                if (z3) {
                                    jArr6 = new long[0];
                                }
                                if (z3) {
                                    iArrCopyOf2 = new int[0];
                                }
                                arrayList3 = arrayList2;
                                j12 = j24;
                                i22 = iCeilDivide;
                                iArr2 = iArr15;
                                i21 = i54;
                            } else {
                                if (z3) {
                                    jArr3 = new long[0];
                                } else {
                                    jArr3 = new long[sampleCount];
                                }
                                if (z3) {
                                    iArrCopyOf = new int[0];
                                } else {
                                    iArrCopyOf = new int[sampleCount];
                                }
                                sampleSizeBox = stz2SampleSizeBox;
                                if (z3) {
                                    jArr4 = new long[0];
                                } else {
                                    jArr4 = new long[sampleCount];
                                }
                                int i82 = unsignedIntToInt2;
                                if (z3) {
                                    iArr = new int[0];
                                } else {
                                    iArr = new int[sampleCount];
                                }
                                i11 = unsignedIntToInt7;
                                i12 = unsignedIntToInt;
                                i13 = unsignedIntToInt9;
                                i14 = i82;
                                j9 = j2;
                                j10 = j9;
                                j11 = j10;
                                i15 = 0;
                                i16 = 0;
                                i17 = 0;
                                unsignedIntToInt4 = 0;
                                i18 = unsignedIntToInt8;
                                unsignedIntToInt5 = unsignedIntToInt3;
                                parsableByteArray3 = parsableByteArray10;
                                i19 = 0;
                                while (true) {
                                    if (i19 < sampleCount) {
                                        arrayList3 = arrayList2;
                                        jArr5 = jArr3;
                                        jArr6 = jArr4;
                                        iArrCopyOf2 = iArr;
                                        i20 = i17;
                                        break;
                                    }
                                    zMoveNext = true;
                                    while (i17 == 0) {
                                        zMoveNext = chunkIterator.moveNext();
                                        if (zMoveNext) {
                                            break;
                                        }
                                        j11 = chunkIterator.offset;
                                        i17 = chunkIterator.numSamples;
                                        arrayList2 = arrayList2;
                                        i13 = i13;
                                    }
                                    i23 = i13;
                                    arrayList4 = arrayList2;
                                    if (!zMoveNext) {
                                        Log.w("BoxParsers", "Unexpected end of chunk data");
                                        if (z3) {
                                            long[] jArrCopyOf = Arrays.copyOf(jArr3, i19);
                                            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i19);
                                            long[] jArrCopyOf2 = Arrays.copyOf(jArr4, i19);
                                            jArr5 = jArrCopyOf;
                                            iArrCopyOf2 = Arrays.copyOf(iArr, i19);
                                            sampleCount = i19;
                                            i20 = i17;
                                            arrayList3 = arrayList4;
                                            jArr6 = jArrCopyOf2;
                                            break;
                                        }
                                        jArr5 = jArr3;
                                        iArrCopyOf2 = iArr;
                                        sampleCount = i19;
                                        i20 = i17;
                                        arrayList3 = arrayList4;
                                        jArr6 = jArr4;
                                        break;
                                    }
                                    if (parsableByteArray2 != null) {
                                        while (unsignedIntToInt4 == 0 && i12 > 0) {
                                            unsignedIntToInt4 = parsableByteArray2.readUnsignedIntToInt();
                                            i16 = parsableByteArray2.readInt();
                                            i12--;
                                        }
                                        unsignedIntToInt4--;
                                    }
                                    nextSampleSize = sampleSizeBox.readNextSampleSize();
                                    int i83 = sampleCount;
                                    long j25 = nextSampleSize;
                                    j10 += j25;
                                    if (nextSampleSize > i15) {
                                        i15 = nextSampleSize;
                                    }
                                    if (z3) {
                                        i24 = i15;
                                        iArr3 = iArrCopyOf;
                                    } else {
                                        jArr3[i19] = j11;
                                        iArrCopyOf[i19] = nextSampleSize;
                                        i24 = i15;
                                        iArr3 = iArrCopyOf;
                                        jArr4[i19] = j9 + ((long) i16);
                                        if (parsableByteArray3 == null) {
                                            i25 = 1;
                                        } else {
                                            i25 = 0;
                                        }
                                        iArr[i19] = i25;
                                        if (i19 == unsignedIntToInt5) {
                                            iArr[i19] = 1;
                                            arrayList5 = arrayList4;
                                            arrayList5.add(Integer.valueOf(i19));
                                        }
                                        if (parsableByteArray3 != null && i19 == unsignedIntToInt5 && (i14 = i14 - 1) > 0) {
                                            unsignedIntToInt5 = parsableByteArray3.readUnsignedIntToInt() - 1;
                                        }
                                        int i84 = i16;
                                        int i85 = i23;
                                        ArrayList arrayList9 = arrayList5;
                                        j9 += (long) i85;
                                        i18--;
                                        if (i18 != 0 && i11 > 0) {
                                            int unsignedIntToInt10 = parsableByteArray9.readUnsignedIntToInt();
                                            int i86 = parsableByteArray9.readInt();
                                            i11--;
                                            i18 = unsignedIntToInt10;
                                            i85 = i86;
                                        }
                                        j11 += j25;
                                        i17--;
                                        i19++;
                                        iArrCopyOf = iArr3;
                                        sampleCount = i83;
                                        i16 = i84;
                                        arrayList2 = arrayList9;
                                        i13 = i85;
                                        i15 = i24;
                                    }
                                    arrayList5 = arrayList4;
                                    if (parsableByteArray3 != null) {
                                        unsignedIntToInt5 = parsableByteArray3.readUnsignedIntToInt() - 1;
                                    }
                                    int i87 = i16;
                                    int i88 = i23;
                                    ArrayList arrayList10 = arrayList5;
                                    j9 += (long) i88;
                                    i18--;
                                    if (i18 != 0) {
                                    }
                                    j11 += j25;
                                    i17--;
                                    i19++;
                                    iArrCopyOf = iArr3;
                                    sampleCount = i83;
                                    i16 = i87;
                                    arrayList2 = arrayList10;
                                    i13 = i88;
                                    i15 = i24;
                                }
                                long j26 = j9 + ((long) i16);
                                if (parsableByteArray2 != null) {
                                    z7 = true;
                                    break;
                                }
                                while (true) {
                                    if (i12 > 0) {
                                        z7 = true;
                                        break;
                                    }
                                    if (parsableByteArray2.readUnsignedIntToInt() != 0) {
                                        z7 = false;
                                        break;
                                    }
                                    parsableByteArray2.readInt();
                                    i12--;
                                }
                                if (i14 == 0 || i18 != 0 || i20 != 0 || i11 != 0 || unsignedIntToInt4 != 0 || !z7) {
                                    StringBuilder sb = new StringBuilder("Inconsistent stbl box for track ");
                                    sb.append(trackCopyWithFormat.id);
                                    sb.append(": remainingSynchronizationSamples ");
                                    sb.append(i14);
                                    sb.append(", remainingSamplesAtTimestampDelta ");
                                    sb.append(i18);
                                    sb.append(", remainingSamplesInChunk ");
                                    sb.append(i20);
                                    sb.append(", remainingTimestampDeltaChanges ");
                                    sb.append(i11);
                                    sb.append(", remainingSamplesAtTimestampOffset ");
                                    sb.append(unsignedIntToInt4);
                                    if (z7) {
                                        str2 = "";
                                    } else {
                                        str2 = ", ctts invalid";
                                    }
                                    sb.append(str2);
                                    Log.w("BoxParsers", sb.toString());
                                }
                                i21 = i15;
                                iArr2 = iArrCopyOf;
                                i22 = sampleCount;
                                j12 = j26;
                                j13 = j10;
                            }
                            jArr7 = jArr5;
                            iArr4 = iArrCopyOf2;
                            j14 = trackCopyWithFormat.mediaDurationUs;
                            if (j14 > j2) {
                                jScaleLargeValue7 = Util.scaleLargeValue(j13 * 8, 1000000L, j14, RoundingMode.HALF_DOWN);
                                if (jScaleLargeValue7 > j2 && jScaleLargeValue7 < 2147483647L) {
                                    Format.Builder builderBuildUpon4 = format6.buildUpon();
                                    builderBuildUpon4.averageBitrate = (int) jScaleLargeValue7;
                                    trackCopyWithFormat = trackCopyWithFormat.copyWithFormat(new Format(builderBuildUpon4));
                                }
                            }
                            i26 = trackCopyWithFormat.type;
                            j15 = trackCopyWithFormat.timescale;
                            format3 = trackCopyWithFormat.format;
                            jArr8 = trackCopyWithFormat.editListMediaTimes;
                            jArr9 = trackCopyWithFormat.editListDurations;
                            RoundingMode roundingMode = RoundingMode.DOWN;
                            jScaleLargeValue3 = Util.scaleLargeValue(j12, 1000000L, j15, roundingMode);
                            array = StringsKt__IndentKt.toArray(arrayList3);
                            if (jArr9 == null) {
                                if (!z3) {
                                    Util.scaleLargeTimestampsInPlace(jArr6, j15);
                                }
                                trackSampleTable2 = new TrackSampleTable(trackCopyWithFormat, jArr7, iArr2, i21, jArr6, iArr4, array, z6, jScaleLargeValue3, i22);
                            } else {
                                jArr10 = jArr6;
                                if (z3) {
                                    jArr8.getClass();
                                    if (jArr9.length == 1 || jArr9[0] != j2) {
                                        for (i47 = 0; i47 < jArr9.length; i47++) {
                                            if (jArr8[i47] != -1) {
                                                j2 += jArr9[i47];
                                            }
                                        }
                                        jScaleLargeValue6 = Util.scaleLargeValue(j2, 1000000L, trackCopyWithFormat.movieTimescale, RoundingMode.DOWN);
                                    } else {
                                        jScaleLargeValue6 = Util.scaleLargeValue(j12 - jArr8[0], 1000000L, trackCopyWithFormat.timescale, roundingMode);
                                    }
                                    trackSampleTable2 = new TrackSampleTable(trackCopyWithFormat, jArr7, iArr2, i21, jArr10, iArr4, array, z6, jScaleLargeValue6, i22);
                                } else {
                                    if (jArr9.length == 1 || i26 != 1 || jArr10.length < 2) {
                                        j16 = -1;
                                    } else {
                                        jArr8.getClass();
                                        long j27 = jArr8[0];
                                        j16 = -1;
                                        long jScaleLargeValue8 = j27 + Util.scaleLargeValue(jArr9[0], trackCopyWithFormat.timescale, trackCopyWithFormat.movieTimescale, roundingMode);
                                        int length = jArr10.length - 1;
                                        int iConstrainValue = Util.constrainValue(4, 0, length);
                                        int iConstrainValue2 = Util.constrainValue(jArr10.length - 4, 0, length);
                                        if (jArr10[0] <= j27 && j27 < jArr10[iConstrainValue] && jArr10[iConstrainValue2] < jScaleLargeValue8 && jScaleLargeValue8 <= 2 + j12) {
                                            long jMax = Math.max(j2, j12 - jScaleLargeValue8);
                                            long jScaleLargeValue9 = Util.scaleLargeValue(j27 - jArr10[0], format3.sampleRate, trackCopyWithFormat.timescale, roundingMode);
                                            long jScaleLargeValue10 = Util.scaleLargeValue(jMax, format3.sampleRate, trackCopyWithFormat.timescale, roundingMode);
                                            if ((jScaleLargeValue9 != j2 || jScaleLargeValue10 != j2) && jScaleLargeValue9 <= 2147483647L && jScaleLargeValue10 <= 2147483647L) {
                                                gaplessInfoHolder.encoderDelay = (int) jScaleLargeValue9;
                                                gaplessInfoHolder.encoderPadding = (int) jScaleLargeValue10;
                                                Util.scaleLargeTimestampsInPlace(jArr10, j15);
                                                trackSampleTable2 = new TrackSampleTable(trackCopyWithFormat, jArr7, iArr2, i21, jArr10, iArr4, array, z6, Util.scaleLargeValue(jArr9[0], 1000000L, trackCopyWithFormat.movieTimescale, roundingMode), i22);
                                            }
                                        }
                                    }
                                    i27 = 1;
                                    if (jArr9.length == 1) {
                                        if (jArr9[0] == 0) {
                                            jArr8.getClass();
                                            j20 = jArr8[0];
                                            for (i46 = 0; i46 < jArr10.length; i46++) {
                                                jArr10[i46] = Util.scaleLargeValue(jArr10[i46] - j20, 1000000L, trackCopyWithFormat.timescale, RoundingMode.DOWN);
                                            }
                                            trackSampleTable2 = new TrackSampleTable(trackCopyWithFormat, jArr7, iArr2, i21, jArr10, iArr4, array, z6, Util.scaleLargeValue(j12 - j20, 1000000L, trackCopyWithFormat.timescale, RoundingMode.DOWN), i22);
                                        } else {
                                            i27 = 1;
                                        }
                                    }
                                    iArr5 = iArr2;
                                    i28 = i22;
                                    if (i26 == i27) {
                                        z8 = true;
                                    } else {
                                        z8 = false;
                                    }
                                    iArr6 = new int[jArr9.length];
                                    iArr7 = new int[jArr9.length];
                                    jArr8.getClass();
                                    i29 = 0;
                                    i30 = 0;
                                    z9 = false;
                                    i31 = 0;
                                    while (i30 < jArr9.length) {
                                        iArr12 = iArr6;
                                        j19 = jArr8[i30];
                                        if (j19 != j16) {
                                            iArr13 = iArr7;
                                            i39 = i30;
                                            jScaleLargeValue5 = Util.scaleLargeValue(jArr9[i30], trackCopyWithFormat.timescale, trackCopyWithFormat.movieTimescale, RoundingMode.DOWN) + j19;
                                            boolean z14 = z9;
                                            iArr12[i39] = Util.binarySearchFloor(jArr10, j19, true);
                                            iBinarySearchCeil = Util.binarySearchCeil(jArr10, jScaleLargeValue5, z8);
                                            i40 = iBinarySearchCeil - 1;
                                            i41 = 0;
                                            while (iBinarySearchCeil < jArr10.length) {
                                                if (jArr10[iBinarySearchCeil] >= jScaleLargeValue5) {
                                                    i41++;
                                                    if (i41 > format3.maxNumReorderSamples) {
                                                        break;
                                                    }
                                                } else {
                                                    i40 = iBinarySearchCeil;
                                                }
                                                iBinarySearchCeil++;
                                            }
                                            iArr13[i39] = i40 + 1;
                                            i42 = iArr12[i39];
                                            while (true) {
                                                i43 = iArr12[i39];
                                                if (i43 > 0 || (iArr4[i43] & 1) != 0) {
                                                    break;
                                                    break;
                                                }
                                                iArr12[i39] = i43 - 1;
                                            }
                                            if (i43 == 0 && (iArr4[0] & 1) == 0) {
                                                iArr12[i39] = i42;
                                                while (true) {
                                                    i45 = iArr12[i39];
                                                    if (i45 < iArr13[i39] || (iArr4[i45] & 1) != 0) {
                                                        break;
                                                    }
                                                    iArr12[i39] = i45 + 1;
                                                }
                                            }
                                            int i89 = iArr13[i39];
                                            i44 = iArr12[i39];
                                            int i90 = (i89 - i44) + i31;
                                            if (i29 != i44) {
                                                z13 = true;
                                            } else {
                                                z13 = false;
                                            }
                                            z9 = z14 | z13;
                                            i31 = i90;
                                            i29 = i89;
                                        } else {
                                            iArr13 = iArr7;
                                            i39 = i30;
                                        }
                                        i30 = i39 + 1;
                                        iArr6 = iArr12;
                                        iArr7 = iArr13;
                                        z8 = z8;
                                    }
                                    iArr8 = iArr6;
                                    iArr9 = iArr7;
                                    boolean z15 = z9;
                                    if (i31 != i28) {
                                        z10 = true;
                                    } else {
                                        z10 = false;
                                    }
                                    z11 = z15 | z10;
                                    if (z11) {
                                        jArr11 = new long[i31];
                                    } else {
                                        jArr11 = jArr7;
                                    }
                                    if (z11) {
                                        iArr10 = new int[i31];
                                    } else {
                                        iArr10 = iArr5;
                                    }
                                    if (z11) {
                                        i21 = 0;
                                    }
                                    if (z11) {
                                        iArr11 = new int[i31];
                                    } else {
                                        iArr11 = iArr4;
                                    }
                                    if (z11) {
                                        arrayList6 = new ArrayList();
                                    } else {
                                        arrayList6 = arrayList3;
                                    }
                                    jArr12 = new long[i31];
                                    i32 = 0;
                                    z12 = false;
                                    i33 = 0;
                                    i34 = i21;
                                    j17 = 0;
                                    while (i32 < jArr9.length) {
                                        j18 = jArr8[i32];
                                        i35 = iArr8[i32];
                                        Format format7 = format3;
                                        i36 = iArr9[i32];
                                        long[] jArr17 = jArr9;
                                        if (z11) {
                                            int i91 = i36 - i35;
                                            System.arraycopy(jArr7, i35, jArr11, i33, i91);
                                            System.arraycopy(iArr5, i35, iArr10, i33, i91);
                                            System.arraycopy(iArr4, i35, iArr11, i33, i91);
                                        }
                                        i37 = i34;
                                        while (i35 < i36) {
                                            i38 = i35;
                                            int i92 = i36;
                                            long j28 = trackCopyWithFormat.movieTimescale;
                                            RoundingMode roundingMode2 = RoundingMode.DOWN;
                                            long jScaleLargeValue11 = Util.scaleLargeValue(j17, 1000000L, j28, roundingMode2);
                                            jScaleLargeValue4 = Util.scaleLargeValue(jArr10[i38] - j18, 1000000L, trackCopyWithFormat.timescale, roundingMode2);
                                            if (jScaleLargeValue4 < 0) {
                                                z12 = true;
                                            }
                                            jArr12[i33] = jScaleLargeValue11 + jScaleLargeValue4;
                                            if (z11 && iArr10[i33] > i37) {
                                                i37 = iArr5[i38];
                                            }
                                            if (!z11 && !z6 && (iArr11[i33] & 1) != 0) {
                                                arrayList6.add(Integer.valueOf(i33));
                                            }
                                            i33++;
                                            i35 = i38 + 1;
                                            i36 = i92;
                                        }
                                        j17 += jArr17[i32];
                                        i32++;
                                        i34 = i37;
                                        format3 = format7;
                                        jArr9 = jArr17;
                                    }
                                    format4 = format3;
                                    long jScaleLargeValue12 = Util.scaleLargeValue(j17, 1000000L, trackCopyWithFormat.movieTimescale, RoundingMode.DOWN);
                                    if (z12) {
                                        Format.Builder builderBuildUpon5 = format4.buildUpon();
                                        builderBuildUpon5.hasPrerollSamples = true;
                                        trackCopyWithFormat = trackCopyWithFormat.copyWithFormat(new Format(builderBuildUpon5));
                                    }
                                    trackSampleTable = new TrackSampleTable(trackCopyWithFormat, jArr11, iArr10, i34, jArr12, iArr11, StringsKt__IndentKt.toArray(arrayList6), z6, jScaleLargeValue12, jArr11.length);
                                }
                            }
                            trackSampleTable = trackSampleTable2;
                        } else {
                            unsignedIntToInt2 = 0;
                        }
                        unsignedIntToInt3 = -1;
                        fixedSampleSize = stz2SampleSizeBox.getFixedSampleSize();
                        parsableByteArray2 = parsableByteArray11;
                        String str8 = format6.sampleMimeType;
                        if (fixedSampleSize == -1) {
                            z5 = false;
                        } else {
                            z5 = false;
                        }
                        arrayList2 = new ArrayList();
                        if (parsableByteArray10 == null) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (z5) {
                            i48 = chunkIterator.length;
                            jArr13 = new long[i48];
                            iArr14 = new int[i48];
                            while (chunkIterator.moveNext()) {
                                int i710 = chunkIterator.index;
                                jArr13[i710] = chunkIterator.offset;
                                iArr14[i710] = chunkIterator.numSamples;
                            }
                            j21 = unsignedIntToInt9;
                            i49 = 8192 / fixedSampleSize;
                            iCeilDivide = 0;
                            while (i50 < i48) {
                                iCeilDivide += Util.ceilDivide(iArr14[i50], i49);
                            }
                            jArr5 = new long[iCeilDivide];
                            iArr15 = new int[iCeilDivide];
                            jArr6 = new long[iCeilDivide];
                            iArrCopyOf2 = new int[iCeilDivide];
                            i51 = 0;
                            i52 = 0;
                            i53 = 0;
                            i54 = 0;
                            i55 = 0;
                            while (i51 < i48) {
                                int i711 = iArr14[i51];
                                j22 = jArr13[i51];
                                int i712 = i55;
                                int i713 = i51;
                                i56 = i54;
                                i57 = i712;
                                int i714 = i48;
                                i58 = i711;
                                while (i58 > 0) {
                                    int iMin2 = Math.min(i49, i58);
                                    jArr5[i57] = j22;
                                    int i715 = i49;
                                    int i716 = fixedSampleSize * iMin2;
                                    iArr15[i57] = i716;
                                    i53 += i716;
                                    int iMax2 = Math.max(i56, i716);
                                    jArr6[i57] = ((long) i52) * j21;
                                    iArrCopyOf2[i57] = 1;
                                    j22 += (long) iArr15[i57];
                                    i52 += iMin2;
                                    i58 -= iMin2;
                                    i57++;
                                    i49 = i715;
                                    i56 = iMax2;
                                }
                                int i810 = i49;
                                int i811 = i713 + 1;
                                i55 = i57;
                                i48 = i714;
                                i54 = i56;
                                i51 = i811;
                                i49 = i810;
                            }
                            long j29 = j21 * ((long) i52);
                            j13 = i53;
                            if (z3) {
                                jArr5 = new long[0];
                            }
                            if (z3) {
                                iArr15 = new int[0];
                            }
                            if (z3) {
                                jArr6 = new long[0];
                            }
                            if (z3) {
                                iArrCopyOf2 = new int[0];
                            }
                            arrayList3 = arrayList2;
                            j12 = j29;
                            i22 = iCeilDivide;
                            iArr2 = iArr15;
                            i21 = i54;
                        } else {
                            if (z3) {
                                jArr3 = new long[0];
                            } else {
                                jArr3 = new long[sampleCount];
                            }
                            if (z3) {
                                iArrCopyOf = new int[0];
                            } else {
                                iArrCopyOf = new int[sampleCount];
                            }
                            sampleSizeBox = stz2SampleSizeBox;
                            if (z3) {
                                jArr4 = new long[0];
                            } else {
                                jArr4 = new long[sampleCount];
                            }
                            int i812 = unsignedIntToInt2;
                            if (z3) {
                                iArr = new int[0];
                            } else {
                                iArr = new int[sampleCount];
                            }
                            i11 = unsignedIntToInt7;
                            i12 = unsignedIntToInt;
                            i13 = unsignedIntToInt9;
                            i14 = i812;
                            j9 = j2;
                            j10 = j9;
                            j11 = j10;
                            i15 = 0;
                            i16 = 0;
                            i17 = 0;
                            unsignedIntToInt4 = 0;
                            i18 = unsignedIntToInt8;
                            unsignedIntToInt5 = unsignedIntToInt3;
                            parsableByteArray3 = parsableByteArray10;
                            i19 = 0;
                            while (true) {
                                if (i19 < sampleCount) {
                                    arrayList3 = arrayList2;
                                    jArr5 = jArr3;
                                    jArr6 = jArr4;
                                    iArrCopyOf2 = iArr;
                                    i20 = i17;
                                    break;
                                }
                                zMoveNext = true;
                                while (i17 == 0) {
                                    zMoveNext = chunkIterator.moveNext();
                                    if (zMoveNext) {
                                        break;
                                        break;
                                    }
                                    j11 = chunkIterator.offset;
                                    i17 = chunkIterator.numSamples;
                                    arrayList2 = arrayList2;
                                    i13 = i13;
                                }
                                i23 = i13;
                                arrayList4 = arrayList2;
                                if (!zMoveNext) {
                                    Log.w("BoxParsers", "Unexpected end of chunk data");
                                    if (z3) {
                                        jArr5 = jArr3;
                                        iArrCopyOf2 = iArr;
                                        sampleCount = i19;
                                        i20 = i17;
                                        arrayList3 = arrayList4;
                                        jArr6 = jArr4;
                                        break;
                                    }
                                    long[] jArrCopyOf3 = Arrays.copyOf(jArr3, i19);
                                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i19);
                                    long[] jArrCopyOf4 = Arrays.copyOf(jArr4, i19);
                                    jArr5 = jArrCopyOf3;
                                    iArrCopyOf2 = Arrays.copyOf(iArr, i19);
                                    sampleCount = i19;
                                    i20 = i17;
                                    arrayList3 = arrayList4;
                                    jArr6 = jArrCopyOf4;
                                    break;
                                }
                                if (parsableByteArray2 != null) {
                                    while (unsignedIntToInt4 == 0) {
                                        unsignedIntToInt4 = parsableByteArray2.readUnsignedIntToInt();
                                        i16 = parsableByteArray2.readInt();
                                        i12--;
                                    }
                                    unsignedIntToInt4--;
                                }
                                nextSampleSize = sampleSizeBox.readNextSampleSize();
                                int i813 = sampleCount;
                                long j210 = nextSampleSize;
                                j10 += j210;
                                if (nextSampleSize > i15) {
                                    i15 = nextSampleSize;
                                }
                                if (z3) {
                                    jArr3[i19] = j11;
                                    iArrCopyOf[i19] = nextSampleSize;
                                    i24 = i15;
                                    iArr3 = iArrCopyOf;
                                    jArr4[i19] = j9 + ((long) i16);
                                    if (parsableByteArray3 == null) {
                                        i25 = 1;
                                    } else {
                                        i25 = 0;
                                    }
                                    iArr[i19] = i25;
                                    if (i19 == unsignedIntToInt5) {
                                        iArr[i19] = 1;
                                        arrayList5 = arrayList4;
                                        arrayList5.add(Integer.valueOf(i19));
                                    }
                                    if (parsableByteArray3 != null) {
                                        unsignedIntToInt5 = parsableByteArray3.readUnsignedIntToInt() - 1;
                                    }
                                    int i814 = i16;
                                    int i815 = i23;
                                    ArrayList arrayList11 = arrayList5;
                                    j9 += (long) i815;
                                    i18--;
                                    if (i18 != 0) {
                                    }
                                    j11 += j210;
                                    i17--;
                                    i19++;
                                    iArrCopyOf = iArr3;
                                    sampleCount = i813;
                                    i16 = i814;
                                    arrayList2 = arrayList11;
                                    i13 = i815;
                                    i15 = i24;
                                } else {
                                    i24 = i15;
                                    iArr3 = iArrCopyOf;
                                }
                                arrayList5 = arrayList4;
                                if (parsableByteArray3 != null) {
                                    unsignedIntToInt5 = parsableByteArray3.readUnsignedIntToInt() - 1;
                                }
                                int i816 = i16;
                                int i817 = i23;
                                ArrayList arrayList12 = arrayList5;
                                j9 += (long) i817;
                                i18--;
                                if (i18 != 0) {
                                }
                                j11 += j210;
                                i17--;
                                i19++;
                                iArrCopyOf = iArr3;
                                sampleCount = i813;
                                i16 = i816;
                                arrayList2 = arrayList12;
                                i13 = i817;
                                i15 = i24;
                            }
                            long j211 = j9 + ((long) i16);
                            if (parsableByteArray2 != null) {
                                z7 = true;
                                break;
                            }
                            while (true) {
                                if (i12 > 0) {
                                    z7 = true;
                                    break;
                                }
                                if (parsableByteArray2.readUnsignedIntToInt() != 0) {
                                    z7 = false;
                                    break;
                                }
                                parsableByteArray2.readInt();
                                i12--;
                            }
                            if (i14 == 0) {
                                StringBuilder sb2 = new StringBuilder("Inconsistent stbl box for track ");
                                sb2.append(trackCopyWithFormat.id);
                                sb2.append(": remainingSynchronizationSamples ");
                                sb2.append(i14);
                                sb2.append(", remainingSamplesAtTimestampDelta ");
                                sb2.append(i18);
                                sb2.append(", remainingSamplesInChunk ");
                                sb2.append(i20);
                                sb2.append(", remainingTimestampDeltaChanges ");
                                sb2.append(i11);
                                sb2.append(", remainingSamplesAtTimestampOffset ");
                                sb2.append(unsignedIntToInt4);
                                if (z7) {
                                    str2 = ", ctts invalid";
                                } else {
                                    str2 = "";
                                }
                                sb2.append(str2);
                                Log.w("BoxParsers", sb2.toString());
                            } else {
                                StringBuilder sb3 = new StringBuilder("Inconsistent stbl box for track ");
                                sb3.append(trackCopyWithFormat.id);
                                sb3.append(": remainingSynchronizationSamples ");
                                sb3.append(i14);
                                sb3.append(", remainingSamplesAtTimestampDelta ");
                                sb3.append(i18);
                                sb3.append(", remainingSamplesInChunk ");
                                sb3.append(i20);
                                sb3.append(", remainingTimestampDeltaChanges ");
                                sb3.append(i11);
                                sb3.append(", remainingSamplesAtTimestampOffset ");
                                sb3.append(unsignedIntToInt4);
                                if (z7) {
                                    str2 = ", ctts invalid";
                                } else {
                                    str2 = "";
                                }
                                sb3.append(str2);
                                Log.w("BoxParsers", sb3.toString());
                            }
                            i21 = i15;
                            iArr2 = iArrCopyOf;
                            i22 = sampleCount;
                            j12 = j211;
                            j13 = j10;
                        }
                        jArr7 = jArr5;
                        iArr4 = iArrCopyOf2;
                        j14 = trackCopyWithFormat.mediaDurationUs;
                        if (j14 > j2) {
                            jScaleLargeValue7 = Util.scaleLargeValue(j13 * 8, 1000000L, j14, RoundingMode.HALF_DOWN);
                            if (jScaleLargeValue7 > j2) {
                                Format.Builder builderBuildUpon6 = format6.buildUpon();
                                builderBuildUpon6.averageBitrate = (int) jScaleLargeValue7;
                                trackCopyWithFormat = trackCopyWithFormat.copyWithFormat(new Format(builderBuildUpon6));
                            }
                        }
                        i26 = trackCopyWithFormat.type;
                        j15 = trackCopyWithFormat.timescale;
                        format3 = trackCopyWithFormat.format;
                        jArr8 = trackCopyWithFormat.editListMediaTimes;
                        jArr9 = trackCopyWithFormat.editListDurations;
                        RoundingMode roundingMode3 = RoundingMode.DOWN;
                        jScaleLargeValue3 = Util.scaleLargeValue(j12, 1000000L, j15, roundingMode3);
                        array = StringsKt__IndentKt.toArray(arrayList3);
                        if (jArr9 == null) {
                            if (!z3) {
                                Util.scaleLargeTimestampsInPlace(jArr6, j15);
                            }
                            trackSampleTable2 = new TrackSampleTable(trackCopyWithFormat, jArr7, iArr2, i21, jArr6, iArr4, array, z6, jScaleLargeValue3, i22);
                        } else {
                            jArr10 = jArr6;
                            if (z3) {
                                jArr8.getClass();
                                if (jArr9.length == 1) {
                                    while (i47 < jArr9.length) {
                                        if (jArr8[i47] != -1) {
                                            j2 += jArr9[i47];
                                        }
                                    }
                                    jScaleLargeValue6 = Util.scaleLargeValue(j2, 1000000L, trackCopyWithFormat.movieTimescale, RoundingMode.DOWN);
                                } else {
                                    while (i47 < jArr9.length) {
                                        if (jArr8[i47] != -1) {
                                            j2 += jArr9[i47];
                                        }
                                    }
                                    jScaleLargeValue6 = Util.scaleLargeValue(j2, 1000000L, trackCopyWithFormat.movieTimescale, RoundingMode.DOWN);
                                }
                                trackSampleTable2 = new TrackSampleTable(trackCopyWithFormat, jArr7, iArr2, i21, jArr10, iArr4, array, z6, jScaleLargeValue6, i22);
                            } else if (jArr9.length == 1) {
                                j16 = -1;
                                i27 = 1;
                                if (jArr9.length == 1) {
                                    if (jArr9[0] == 0) {
                                        jArr8.getClass();
                                        j20 = jArr8[0];
                                        while (i46 < jArr10.length) {
                                            jArr10[i46] = Util.scaleLargeValue(jArr10[i46] - j20, 1000000L, trackCopyWithFormat.timescale, RoundingMode.DOWN);
                                        }
                                        trackSampleTable2 = new TrackSampleTable(trackCopyWithFormat, jArr7, iArr2, i21, jArr10, iArr4, array, z6, Util.scaleLargeValue(j12 - j20, 1000000L, trackCopyWithFormat.timescale, RoundingMode.DOWN), i22);
                                    } else {
                                        i27 = 1;
                                    }
                                }
                                iArr5 = iArr2;
                                i28 = i22;
                                if (i26 == i27) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                iArr6 = new int[jArr9.length];
                                iArr7 = new int[jArr9.length];
                                jArr8.getClass();
                                i29 = 0;
                                i30 = 0;
                                z9 = false;
                                i31 = 0;
                                while (i30 < jArr9.length) {
                                    iArr12 = iArr6;
                                    j19 = jArr8[i30];
                                    if (j19 != j16) {
                                        iArr13 = iArr7;
                                        i39 = i30;
                                        jScaleLargeValue5 = Util.scaleLargeValue(jArr9[i30], trackCopyWithFormat.timescale, trackCopyWithFormat.movieTimescale, RoundingMode.DOWN) + j19;
                                        boolean z16 = z9;
                                        iArr12[i39] = Util.binarySearchFloor(jArr10, j19, true);
                                        iBinarySearchCeil = Util.binarySearchCeil(jArr10, jScaleLargeValue5, z8);
                                        i40 = iBinarySearchCeil - 1;
                                        i41 = 0;
                                        while (iBinarySearchCeil < jArr10.length) {
                                            if (jArr10[iBinarySearchCeil] >= jScaleLargeValue5) {
                                                i41++;
                                                if (i41 > format3.maxNumReorderSamples) {
                                                    break;
                                                    break;
                                                }
                                            } else {
                                                i40 = iBinarySearchCeil;
                                            }
                                            iBinarySearchCeil++;
                                        }
                                        iArr13[i39] = i40 + 1;
                                        i42 = iArr12[i39];
                                        while (true) {
                                            i43 = iArr12[i39];
                                            if (i43 > 0) {
                                                break;
                                            }
                                            iArr12[i39] = i43 - 1;
                                        }
                                        if (i43 == 0) {
                                            iArr12[i39] = i42;
                                            while (true) {
                                                i45 = iArr12[i39];
                                                if (i45 < iArr13[i39]) {
                                                    break;
                                                }
                                                break;
                                                break;
                                                iArr12[i39] = i45 + 1;
                                            }
                                        }
                                        int i818 = iArr13[i39];
                                        i44 = iArr12[i39];
                                        int i93 = (i818 - i44) + i31;
                                        if (i29 != i44) {
                                            z13 = true;
                                        } else {
                                            z13 = false;
                                        }
                                        z9 = z16 | z13;
                                        i31 = i93;
                                        i29 = i818;
                                    } else {
                                        iArr13 = iArr7;
                                        i39 = i30;
                                    }
                                    i30 = i39 + 1;
                                    iArr6 = iArr12;
                                    iArr7 = iArr13;
                                    z8 = z8;
                                }
                                iArr8 = iArr6;
                                iArr9 = iArr7;
                                boolean z17 = z9;
                                if (i31 != i28) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                z11 = z17 | z10;
                                if (z11) {
                                    jArr11 = new long[i31];
                                } else {
                                    jArr11 = jArr7;
                                }
                                if (z11) {
                                    iArr10 = new int[i31];
                                } else {
                                    iArr10 = iArr5;
                                }
                                if (z11) {
                                    i21 = 0;
                                }
                                if (z11) {
                                    iArr11 = new int[i31];
                                } else {
                                    iArr11 = iArr4;
                                }
                                if (z11) {
                                    arrayList6 = new ArrayList();
                                } else {
                                    arrayList6 = arrayList3;
                                }
                                jArr12 = new long[i31];
                                i32 = 0;
                                z12 = false;
                                i33 = 0;
                                i34 = i21;
                                j17 = 0;
                                while (i32 < jArr9.length) {
                                    j18 = jArr8[i32];
                                    i35 = iArr8[i32];
                                    Format format8 = format3;
                                    i36 = iArr9[i32];
                                    long[] jArr18 = jArr9;
                                    if (z11) {
                                        int i94 = i36 - i35;
                                        System.arraycopy(jArr7, i35, jArr11, i33, i94);
                                        System.arraycopy(iArr5, i35, iArr10, i33, i94);
                                        System.arraycopy(iArr4, i35, iArr11, i33, i94);
                                    }
                                    i37 = i34;
                                    while (i35 < i36) {
                                        i38 = i35;
                                        int i95 = i36;
                                        long j212 = trackCopyWithFormat.movieTimescale;
                                        RoundingMode roundingMode4 = RoundingMode.DOWN;
                                        long jScaleLargeValue13 = Util.scaleLargeValue(j17, 1000000L, j212, roundingMode4);
                                        jScaleLargeValue4 = Util.scaleLargeValue(jArr10[i38] - j18, 1000000L, trackCopyWithFormat.timescale, roundingMode4);
                                        if (jScaleLargeValue4 < 0) {
                                            z12 = true;
                                        }
                                        jArr12[i33] = jScaleLargeValue13 + jScaleLargeValue4;
                                        if (z11) {
                                            i37 = iArr5[i38];
                                        }
                                        if (!z11) {
                                        }
                                        i33++;
                                        i35 = i38 + 1;
                                        i36 = i95;
                                    }
                                    j17 += jArr18[i32];
                                    i32++;
                                    i34 = i37;
                                    format3 = format8;
                                    jArr9 = jArr18;
                                }
                                format4 = format3;
                                long jScaleLargeValue14 = Util.scaleLargeValue(j17, 1000000L, trackCopyWithFormat.movieTimescale, RoundingMode.DOWN);
                                if (z12) {
                                    Format.Builder builderBuildUpon7 = format4.buildUpon();
                                    builderBuildUpon7.hasPrerollSamples = true;
                                    trackCopyWithFormat = trackCopyWithFormat.copyWithFormat(new Format(builderBuildUpon7));
                                }
                                trackSampleTable = new TrackSampleTable(trackCopyWithFormat, jArr11, iArr10, i34, jArr12, iArr11, StringsKt__IndentKt.toArray(arrayList6), z6, jScaleLargeValue14, jArr11.length);
                            } else {
                                j16 = -1;
                                i27 = 1;
                                if (jArr9.length == 1) {
                                    if (jArr9[0] == 0) {
                                        jArr8.getClass();
                                        j20 = jArr8[0];
                                        while (i46 < jArr10.length) {
                                            jArr10[i46] = Util.scaleLargeValue(jArr10[i46] - j20, 1000000L, trackCopyWithFormat.timescale, RoundingMode.DOWN);
                                        }
                                        trackSampleTable2 = new TrackSampleTable(trackCopyWithFormat, jArr7, iArr2, i21, jArr10, iArr4, array, z6, Util.scaleLargeValue(j12 - j20, 1000000L, trackCopyWithFormat.timescale, RoundingMode.DOWN), i22);
                                    } else {
                                        i27 = 1;
                                    }
                                }
                                iArr5 = iArr2;
                                i28 = i22;
                                if (i26 == i27) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                iArr6 = new int[jArr9.length];
                                iArr7 = new int[jArr9.length];
                                jArr8.getClass();
                                i29 = 0;
                                i30 = 0;
                                z9 = false;
                                i31 = 0;
                                while (i30 < jArr9.length) {
                                    iArr12 = iArr6;
                                    j19 = jArr8[i30];
                                    if (j19 != j16) {
                                        iArr13 = iArr7;
                                        i39 = i30;
                                        jScaleLargeValue5 = Util.scaleLargeValue(jArr9[i30], trackCopyWithFormat.timescale, trackCopyWithFormat.movieTimescale, RoundingMode.DOWN) + j19;
                                        boolean z18 = z9;
                                        iArr12[i39] = Util.binarySearchFloor(jArr10, j19, true);
                                        iBinarySearchCeil = Util.binarySearchCeil(jArr10, jScaleLargeValue5, z8);
                                        i40 = iBinarySearchCeil - 1;
                                        i41 = 0;
                                        while (iBinarySearchCeil < jArr10.length) {
                                            if (jArr10[iBinarySearchCeil] >= jScaleLargeValue5) {
                                                i41++;
                                                if (i41 > format3.maxNumReorderSamples) {
                                                    break;
                                                    break;
                                                }
                                            } else {
                                                i40 = iBinarySearchCeil;
                                            }
                                            iBinarySearchCeil++;
                                        }
                                        iArr13[i39] = i40 + 1;
                                        i42 = iArr12[i39];
                                        while (true) {
                                            i43 = iArr12[i39];
                                            if (i43 > 0) {
                                                break;
                                                break;
                                            }
                                            iArr12[i39] = i43 - 1;
                                        }
                                        if (i43 == 0) {
                                            iArr12[i39] = i42;
                                            while (true) {
                                                i45 = iArr12[i39];
                                                if (i45 < iArr13[i39]) {
                                                    break;
                                                    break;
                                                }
                                                break;
                                                break;
                                                iArr12[i39] = i45 + 1;
                                            }
                                        }
                                        int i819 = iArr13[i39];
                                        i44 = iArr12[i39];
                                        int i96 = (i819 - i44) + i31;
                                        if (i29 != i44) {
                                            z13 = true;
                                        } else {
                                            z13 = false;
                                        }
                                        z9 = z18 | z13;
                                        i31 = i96;
                                        i29 = i819;
                                    } else {
                                        iArr13 = iArr7;
                                        i39 = i30;
                                    }
                                    i30 = i39 + 1;
                                    iArr6 = iArr12;
                                    iArr7 = iArr13;
                                    z8 = z8;
                                }
                                iArr8 = iArr6;
                                iArr9 = iArr7;
                                boolean z19 = z9;
                                if (i31 != i28) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                z11 = z19 | z10;
                                if (z11) {
                                    jArr11 = new long[i31];
                                } else {
                                    jArr11 = jArr7;
                                }
                                if (z11) {
                                    iArr10 = new int[i31];
                                } else {
                                    iArr10 = iArr5;
                                }
                                if (z11) {
                                    i21 = 0;
                                }
                                if (z11) {
                                    iArr11 = new int[i31];
                                } else {
                                    iArr11 = iArr4;
                                }
                                if (z11) {
                                    arrayList6 = new ArrayList();
                                } else {
                                    arrayList6 = arrayList3;
                                }
                                jArr12 = new long[i31];
                                i32 = 0;
                                z12 = false;
                                i33 = 0;
                                i34 = i21;
                                j17 = 0;
                                while (i32 < jArr9.length) {
                                    j18 = jArr8[i32];
                                    i35 = iArr8[i32];
                                    Format format9 = format3;
                                    i36 = iArr9[i32];
                                    long[] jArr19 = jArr9;
                                    if (z11) {
                                        int i97 = i36 - i35;
                                        System.arraycopy(jArr7, i35, jArr11, i33, i97);
                                        System.arraycopy(iArr5, i35, iArr10, i33, i97);
                                        System.arraycopy(iArr4, i35, iArr11, i33, i97);
                                    }
                                    i37 = i34;
                                    while (i35 < i36) {
                                        i38 = i35;
                                        int i98 = i36;
                                        long j213 = trackCopyWithFormat.movieTimescale;
                                        RoundingMode roundingMode5 = RoundingMode.DOWN;
                                        long jScaleLargeValue15 = Util.scaleLargeValue(j17, 1000000L, j213, roundingMode5);
                                        jScaleLargeValue4 = Util.scaleLargeValue(jArr10[i38] - j18, 1000000L, trackCopyWithFormat.timescale, roundingMode5);
                                        if (jScaleLargeValue4 < 0) {
                                            z12 = true;
                                        }
                                        jArr12[i33] = jScaleLargeValue15 + jScaleLargeValue4;
                                        if (z11) {
                                            i37 = iArr5[i38];
                                        }
                                        if (!z11) {
                                        }
                                        i33++;
                                        i35 = i38 + 1;
                                        i36 = i98;
                                    }
                                    j17 += jArr19[i32];
                                    i32++;
                                    i34 = i37;
                                    format3 = format9;
                                    jArr9 = jArr19;
                                }
                                format4 = format3;
                                long jScaleLargeValue16 = Util.scaleLargeValue(j17, 1000000L, trackCopyWithFormat.movieTimescale, RoundingMode.DOWN);
                                if (z12) {
                                    Format.Builder builderBuildUpon8 = format4.buildUpon();
                                    builderBuildUpon8.hasPrerollSamples = true;
                                    trackCopyWithFormat = trackCopyWithFormat.copyWithFormat(new Format(builderBuildUpon8));
                                }
                                trackSampleTable = new TrackSampleTable(trackCopyWithFormat, jArr11, iArr10, i34, jArr12, iArr11, StringsKt__IndentKt.toArray(arrayList6), z6, jScaleLargeValue16, jArr11.length);
                            }
                        }
                        trackSampleTable = trackSampleTable2;
                    }
                    arrayList8.add(trackSampleTable);
                }
            }
            i59 = i2 + 1;
            mp4Box$ContainerBox2 = mp4Box$ContainerBox;
            arrayList8 = arrayList8;
            arrayList7 = arrayList;
        }
        return arrayList8;
    }

    /* JADX WARN: Code duplicated, block: B:202:0x0352  */
    /* JADX WARN: Code duplicated, block: B:205:0x0357 A[EDGE_INSN: B:205:0x0357->B:208:0x0377 BREAK  A[LOOP:4: B:166:0x02e3->B:206:0x0369]] */
    public static Metadata parseUdta(Mp4Box$LeafBox mp4Box$LeafBox) {
        int i;
        boolean z;
        Metadata metadata;
        Metadata metadata2;
        int unsignedFixedPoint1616;
        Metadata metadata3;
        Object textAttribute;
        ParsableByteArray parsableByteArray = mp4Box$LeafBox.data;
        int i2 = 8;
        parsableByteArray.setPosition(8);
        boolean z2 = false;
        Metadata metadata4 = new Metadata(new Metadata.Entry[0]);
        while (parsableByteArray.bytesLeft() >= i2) {
            int i3 = parsableByteArray.position;
            int i4 = parsableByteArray.readInt();
            int i5 = parsableByteArray.readInt();
            String str = null;
            if (i5 == 1835365473) {
                parsableByteArray.setPosition(i3);
                int i6 = i3 + i4;
                parsableByteArray.skipBytes(i2);
                maybeSkipRemainingMetaBoxHeaderBytes(parsableByteArray);
                while (true) {
                    int i7 = parsableByteArray.position;
                    if (i7 < i6) {
                        int i8 = parsableByteArray.readInt();
                        if (parsableByteArray.readInt() == 1768715124) {
                            parsableByteArray.setPosition(i7);
                            int i9 = i7 + i8;
                            parsableByteArray.skipBytes(i2);
                            ArrayList arrayList = new ArrayList();
                            while (true) {
                                int i10 = parsableByteArray.position;
                                if (i10 >= i9) {
                                    break;
                                }
                                int i11 = parsableByteArray.readInt() + i10;
                                int i12 = parsableByteArray.readInt();
                                int i13 = (i12 >> 24) & 255;
                                if (i13 == 169 || i13 == 253) {
                                    int i14 = 16777215 & i12;
                                    if (i14 == 6516084) {
                                        int i15 = parsableByteArray.readInt();
                                        if (parsableByteArray.readInt() == 1684108385) {
                                            parsableByteArray.skipBytes(8);
                                            String nullTerminatedString = parsableByteArray.readNullTerminatedString(i15 - 16);
                                            textAttribute = new CommentFrame("und", nullTerminatedString, nullTerminatedString);
                                        } else {
                                            Log.w("MetadataUtil", "Failed to parse comment attribute: ".concat(Buffer.getBoxTypeString(i12)));
                                            textAttribute = null;
                                        }
                                    } else if (i14 == 7233901 || i14 == 7631467) {
                                        textAttribute = Sniffer.parseTextAttribute(i12, parsableByteArray, "TIT2");
                                    } else if (i14 == 6516589 || i14 == 7828084) {
                                        textAttribute = Sniffer.parseTextAttribute(i12, parsableByteArray, "TCOM");
                                    } else if (i14 == 6578553) {
                                        textAttribute = Sniffer.parseTextAttribute(i12, parsableByteArray, "TDRC");
                                    } else if (i14 == 4280916) {
                                        textAttribute = Sniffer.parseTextAttribute(i12, parsableByteArray, "TPE1");
                                    } else if (i14 == 7630703) {
                                        textAttribute = Sniffer.parseTextAttribute(i12, parsableByteArray, "TSSE");
                                    } else if (i14 == 6384738) {
                                        textAttribute = Sniffer.parseTextAttribute(i12, parsableByteArray, "TALB");
                                    } else if (i14 == 7108978) {
                                        textAttribute = Sniffer.parseTextAttribute(i12, parsableByteArray, "USLT");
                                    } else if (i14 == 6776174) {
                                        textAttribute = Sniffer.parseTextAttribute(i12, parsableByteArray, "TCON");
                                    } else if (i14 == 6779504) {
                                        textAttribute = Sniffer.parseTextAttribute(i12, parsableByteArray, "TIT1");
                                    } else if (i14 == 7173742) {
                                        textAttribute = Sniffer.parseTextAttribute(i12, parsableByteArray, "MVNM");
                                    } else if (i14 == 7173737) {
                                        Object integerAttribute = Sniffer.parseIntegerAttribute(i12, "MVIN", parsableByteArray, true, false);
                                        parsableByteArray.setPosition(i11);
                                        textAttribute = integerAttribute;
                                    } else {
                                        Log.d("Skipped unknown metadata entry: ".concat(Buffer.getBoxTypeString(i12)));
                                        parsableByteArray.setPosition(i11);
                                        textAttribute = null;
                                    }
                                    parsableByteArray.setPosition(i11);
                                } else {
                                    if (i12 == 1735291493) {
                                        try {
                                            String strResolveV1Genre = Id3Util.resolveV1Genre(Sniffer.parseIntegerAttribute(parsableByteArray) - 1);
                                            if (strResolveV1Genre != null) {
                                                textAttribute = new TextInformationFrame("TCON", str, ImmutableList.of((Object) strResolveV1Genre));
                                            } else {
                                                Log.w("MetadataUtil", "Failed to parse standard genre code");
                                                textAttribute = str;
                                            }
                                        } catch (Throwable th) {
                                            parsableByteArray.setPosition(i11);
                                            throw th;
                                        }
                                    } else if (i12 == 1684632427) {
                                        textAttribute = Sniffer.parseIndexAndCountAttribute(i12, parsableByteArray, "TPOS");
                                    } else if (i12 == 1953655662) {
                                        textAttribute = Sniffer.parseIndexAndCountAttribute(i12, parsableByteArray, "TRCK");
                                    } else if (i12 == 1953329263) {
                                        textAttribute = Sniffer.parseIntegerAttribute(i12, "TBPM", parsableByteArray, true, z2);
                                    } else if (i12 == 1668311404) {
                                        textAttribute = Sniffer.parseIntegerAttribute(i12, "TCMP", parsableByteArray, true, true);
                                    } else if (i12 == 1668249202) {
                                        textAttribute = Sniffer.parseCoverArt(parsableByteArray);
                                    } else if (i12 == 1631670868) {
                                        textAttribute = Sniffer.parseTextAttribute(i12, parsableByteArray, "TPE2");
                                    } else if (i12 == 1936682605) {
                                        textAttribute = Sniffer.parseTextAttribute(i12, parsableByteArray, "TSOT");
                                    } else if (i12 == 1936679276) {
                                        textAttribute = Sniffer.parseTextAttribute(i12, parsableByteArray, "TSOA");
                                    } else if (i12 == 1936679282) {
                                        textAttribute = Sniffer.parseTextAttribute(i12, parsableByteArray, "TSOP");
                                    } else if (i12 == 1936679265) {
                                        textAttribute = Sniffer.parseTextAttribute(i12, parsableByteArray, "TSO2");
                                    } else if (i12 == 1936679791) {
                                        textAttribute = Sniffer.parseTextAttribute(i12, parsableByteArray, "TSOC");
                                    } else if (i12 == 1920233063) {
                                        textAttribute = Sniffer.parseIntegerAttribute(i12, "ITUNESADVISORY", parsableByteArray, z2, z2);
                                    } else if (i12 == 1885823344) {
                                        textAttribute = Sniffer.parseIntegerAttribute(i12, "ITUNESGAPLESS", parsableByteArray, z2, true);
                                    } else if (i12 == 1936683886) {
                                        textAttribute = Sniffer.parseTextAttribute(i12, parsableByteArray, "TVSHOWSORT");
                                    } else if (i12 == 1953919848) {
                                        textAttribute = Sniffer.parseTextAttribute(i12, parsableByteArray, "TVSHOW");
                                    } else if (i12 == 757935405) {
                                        String nullTerminatedString2 = str;
                                        String nullTerminatedString3 = nullTerminatedString2;
                                        int i16 = -1;
                                        int i17 = -1;
                                        while (true) {
                                            int i18 = parsableByteArray.position;
                                            if (i18 >= i11) {
                                                break;
                                            }
                                            int i19 = parsableByteArray.readInt();
                                            int i20 = parsableByteArray.readInt();
                                            parsableByteArray.skipBytes(4);
                                            if (i20 == 1835360622) {
                                                nullTerminatedString2 = parsableByteArray.readNullTerminatedString(i19 - 12);
                                            } else if (i20 == 1851878757) {
                                                nullTerminatedString3 = parsableByteArray.readNullTerminatedString(i19 - 12);
                                            } else {
                                                if (i20 == 1684108385) {
                                                    i16 = i18;
                                                    i17 = i19;
                                                }
                                                parsableByteArray.skipBytes(i19 - 12);
                                            }
                                        }
                                        if (nullTerminatedString2 == null || nullTerminatedString3 == null || i16 == -1) {
                                            textAttribute = null;
                                        } else {
                                            parsableByteArray.setPosition(i16);
                                            parsableByteArray.skipBytes(16);
                                            textAttribute = new InternalFrame(nullTerminatedString2, nullTerminatedString3, parsableByteArray.readNullTerminatedString(i17 - 16));
                                        }
                                        parsableByteArray.setPosition(i11);
                                    } else {
                                        Log.d("Skipped unknown metadata entry: ".concat(Buffer.getBoxTypeString(i12)));
                                        parsableByteArray.setPosition(i11);
                                        textAttribute = null;
                                    }
                                    parsableByteArray.setPosition(i11);
                                }
                                if (textAttribute != null) {
                                    arrayList.add(textAttribute);
                                }
                                z2 = false;
                                str = null;
                            }
                            if (!arrayList.isEmpty()) {
                                metadata3 = new Metadata(arrayList);
                                break;
                            }
                            break;
                        }
                        parsableByteArray.setPosition(i7 + i8);
                        i2 = 8;
                        z2 = false;
                        str = null;
                    }
                    metadata3 = null;
                    break;
                }
                metadata4 = metadata4.copyWithAppendedEntriesFrom(metadata3);
                i = 8;
            } else if (i5 == 1936553057) {
                parsableByteArray.setPosition(i3);
                int i21 = i3 + i4;
                parsableByteArray.skipBytes(12);
                while (true) {
                    int i22 = parsableByteArray.position;
                    if (i22 < i21) {
                        int i23 = parsableByteArray.readInt();
                        if (parsableByteArray.readInt() == 1935766900) {
                            if (i23 >= 16) {
                                parsableByteArray.skipBytes(4);
                                int i24 = -1;
                                int i25 = 0;
                                for (int i26 = 0; i26 < 2; i26++) {
                                    int unsignedByte = parsableByteArray.readUnsignedByte();
                                    int unsignedByte2 = parsableByteArray.readUnsignedByte();
                                    if (unsignedByte == 0) {
                                        i24 = unsignedByte2;
                                    } else if (unsignedByte == 1) {
                                        i25 = unsignedByte2;
                                    }
                                }
                                if (i24 != 12) {
                                    if (i24 != 13) {
                                        if (i24 != 21) {
                                            unsignedFixedPoint1616 = -2147483647;
                                        } else {
                                            i = 8;
                                            if (parsableByteArray.bytesLeft() < 8 || parsableByteArray.position + 8 > i21) {
                                                unsignedFixedPoint1616 = -2147483647;
                                            } else {
                                                int i27 = parsableByteArray.readInt();
                                                int i28 = parsableByteArray.readInt();
                                                if (i27 < 12 || i28 != 1936877170) {
                                                    unsignedFixedPoint1616 = -2147483647;
                                                } else {
                                                    unsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
                                                }
                                            }
                                        }
                                        if (unsignedFixedPoint1616 == -2147483647) {
                                            metadata2 = new Metadata(new SmtaMetadataEntry(i25, unsignedFixedPoint1616));
                                            break;
                                        }
                                        break;
                                    }
                                    unsignedFixedPoint1616 = 120;
                                } else {
                                    unsignedFixedPoint1616 = 240;
                                }
                                i = 8;
                                if (unsignedFixedPoint1616 == -2147483647) {
                                    metadata2 = new Metadata(new SmtaMetadataEntry(i25, unsignedFixedPoint1616));
                                    break;
                                }
                                break;
                            }
                            metadata2 = null;
                            i = 8;
                            break;
                        }
                        parsableByteArray.setPosition(i22 + i23);
                    } else {
                        i = 8;
                    }
                    metadata2 = null;
                    break;
                }
                metadata4 = metadata4.copyWithAppendedEntriesFrom(metadata2);
            } else {
                i = 8;
                if (i5 == -1451722374) {
                    short s = parsableByteArray.readShort();
                    parsableByteArray.skipBytes(2);
                    String string = parsableByteArray.readString(s, StandardCharsets.UTF_8);
                    int iMax = Math.max(string.lastIndexOf(43), string.lastIndexOf(45));
                    try {
                        try {
                            Mp4LocationData mp4LocationData = new Mp4LocationData(Float.parseFloat(string.substring(0, iMax)), Float.parseFloat(string.substring(iMax, string.length() - 1)));
                            Metadata.Entry[] entryArr = new Metadata.Entry[1];
                            z = false;
                            try {
                                entryArr[0] = mp4LocationData;
                                metadata = new Metadata(entryArr);
                            } catch (IndexOutOfBoundsException | NumberFormatException unused) {
                                metadata = null;
                            }
                        } catch (IndexOutOfBoundsException | NumberFormatException unused2) {
                            z = false;
                        }
                    } catch (IndexOutOfBoundsException | NumberFormatException unused3) {
                        z = false;
                    }
                    metadata4 = metadata4.copyWithAppendedEntriesFrom(metadata);
                }
                parsableByteArray.setPosition(i3 + i4);
                i2 = i;
                z2 = z;
            }
            z = false;
            parsableByteArray.setPosition(i3 + i4);
            i2 = i;
            z2 = z;
        }
        return metadata4;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class StsdData implements FutureCallback {
        public Object format;
        public int nalUnitLengthFieldLength;
        public boolean requiredSampleTransformation;
        public final Object trackEncryptionBoxes;

        public StsdData(Context context, AndroidComposeView$$ExternalSyntheticLambda0 androidComposeView$$ExternalSyntheticLambda0) {
            this.trackEncryptionBoxes = androidComposeView$$ExternalSyntheticLambda0;
            this.nalUnitLengthFieldLength = 0;
            this.format = new GestureDetector(context, new GestureDetector.OnGestureListener() { // from class: androidx.compose.ui.platform.IndirectPointerNavigationGestureDetector$gestureDetector$1
                @Override // android.view.GestureDetector.OnGestureListener
                public final boolean onDown(MotionEvent motionEvent) {
                    return true;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    BoxParser.StsdData stsdData = this.this$0;
                    AndroidComposeView$$ExternalSyntheticLambda0 androidComposeView$$ExternalSyntheticLambda1 = (AndroidComposeView$$ExternalSyntheticLambda0) stsdData.trackEncryptionBoxes;
                    if (!stsdData.requiredSampleTransformation) {
                        int i = stsdData.nalUnitLengthFieldLength;
                        if (i == 1) {
                            if (Math.abs(f) > Math.abs(f2)) {
                                ((FocusOwnerImpl) androidComposeView$$ExternalSyntheticLambda1.f$0.getFocusOwner()).m412moveFocusaToIllA(f > CropImageView.DEFAULT_ASPECT_RATIO ? 1 : 2, false);
                                return true;
                            }
                        } else if (i == 2 && Math.abs(f2) > Math.abs(f)) {
                            ((FocusOwnerImpl) androidComposeView$$ExternalSyntheticLambda1.f$0.getFocusOwner()).m412moveFocusaToIllA(f2 > CropImageView.DEFAULT_ASPECT_RATIO ? 1 : 2, false);
                        }
                    }
                    return true;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    return true;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public final boolean onSingleTapUp(MotionEvent motionEvent) {
                    return true;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public final void onLongPress(MotionEvent motionEvent) {
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public final void onShowPress(MotionEvent motionEvent) {
                }
            });
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onFailure(Throwable th) {
            if (this.requiredSampleTransformation) {
                return;
            }
            Log.w("NotificationProvider", "Failed to load bitmap: " + th.getMessage());
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onSuccess(Object obj) {
            Bitmap bitmap = (Bitmap) obj;
            NotificationCompat$Builder notificationCompat$Builder = (NotificationCompat$Builder) this.trackEncryptionBoxes;
            if (this.requiredSampleTransformation) {
                return;
            }
            notificationCompat$Builder.setLargeIcon(bitmap);
            ((MediaNotification$Provider.Callback) this.format).onNotificationChanged(new PriorityQueue(this.nalUnitLengthFieldLength, notificationCompat$Builder.build()));
        }

        public StsdData(boolean z, int i, String str, Bundle bundle) {
            this.requiredSampleTransformation = z;
            this.nalUnitLengthFieldLength = i;
            this.trackEncryptionBoxes = str;
            this.format = bundle == null ? Bundle.EMPTY : bundle;
        }

        public StsdData(int i) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
            this.requiredSampleTransformation = false;
        }

        public StsdData(int i, NotificationCompat$Builder notificationCompat$Builder, MediaNotification$Provider.Callback callback) {
            this.nalUnitLengthFieldLength = i;
            this.trackEncryptionBoxes = notificationCompat$Builder;
            this.format = callback;
        }
    }
}
