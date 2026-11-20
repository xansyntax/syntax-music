package androidx.media3.extractor;

import androidx.media3.common.Metadata;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticLambda0;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.webvtt.WebvttCueParser;
import coil3.util.UtilsKt;
import java.io.EOFException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Id3Peeker implements SubtitleParser {
    public final ParsableByteArray scratch;

    public Id3Peeker(byte b) {
        switch (b) {
            case 1:
                this.scratch = new ParsableByteArray();
                break;
            default:
                this.scratch = new ParsableByteArray(10);
                break;
        }
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public void parse(byte[] bArr, int i, int i2, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        Cue cueBuild;
        ParsableByteArray parsableByteArray = this.scratch;
        parsableByteArray.reset(bArr, i2 + i);
        parsableByteArray.setPosition(i);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.bytesLeft() > 0) {
            UtilsKt.checkArgument("Incomplete Mp4Webvtt Top Level box header found.", parsableByteArray.bytesLeft() >= 8);
            int i3 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1987343459) {
                int i4 = i3 - 8;
                CharSequence cueText = null;
                Cue.Builder cueBuilder = null;
                while (i4 > 0) {
                    UtilsKt.checkArgument("Incomplete vtt cue box header found.", i4 >= 8);
                    int i5 = parsableByteArray.readInt();
                    int i6 = parsableByteArray.readInt();
                    int i7 = i5 - 8;
                    byte[] bArr2 = parsableByteArray.data;
                    int i8 = parsableByteArray.position;
                    String str = Util.DEVICE_DEBUG_INFO;
                    String str2 = new String(bArr2, i8, i7, StandardCharsets.UTF_8);
                    parsableByteArray.skipBytes(i7);
                    i4 = (i4 - 8) - i7;
                    if (i6 == 1937011815) {
                        WebvttCueParser.WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueParser.WebvttCueInfoBuilder();
                        WebvttCueParser.parseCueSettingsList(str2, webvttCueInfoBuilder);
                        cueBuilder = webvttCueInfoBuilder.toCueBuilder();
                    } else if (i6 == 1885436268) {
                        cueText = WebvttCueParser.parseCueText(null, str2.trim(), Collections.EMPTY_LIST);
                    }
                }
                if (cueText == null) {
                    cueText = "";
                }
                if (cueBuilder != null) {
                    cueBuilder.text = cueText;
                    cueBuilder.bitmap = null;
                    cueBuild = cueBuilder.build();
                } else {
                    Pattern pattern = WebvttCueParser.CUE_HEADER_PATTERN;
                    WebvttCueParser.WebvttCueInfoBuilder webvttCueInfoBuilder2 = new WebvttCueParser.WebvttCueInfoBuilder();
                    webvttCueInfoBuilder2.text = cueText;
                    cueBuild = webvttCueInfoBuilder2.toCueBuilder().build();
                }
                arrayList.add(cueBuild);
            } else {
                parsableByteArray.skipBytes(i3 - 8);
            }
        }
        consumer.accept(new CuesWithTiming(-9223372036854775807L, -9223372036854775807L, arrayList));
    }

    public Metadata peekId3Data(ExtractorInput extractorInput, FrameworkMediaDrm$$ExternalSyntheticLambda0 frameworkMediaDrm$$ExternalSyntheticLambda0, int i) {
        ParsableByteArray parsableByteArray;
        int i2;
        int i3 = 0;
        Metadata metadataDecode = null;
        while (true) {
            int i4 = 0;
            while (true) {
                int i5 = i4 % 10;
                int i6 = i5 + 10;
                parsableByteArray = this.scratch;
                if (i5 == 0 && i4 != 0) {
                    byte[] bArr = parsableByteArray.data;
                    System.arraycopy(bArr, 10, bArr, 0, 9);
                }
                int i7 = i4 == 0 ? 10 : 1;
                try {
                    extractorInput.peekFully(parsableByteArray.data, i6 - i7, i7);
                    parsableByteArray.setPosition(i5);
                    parsableByteArray.setLimit(i6);
                    if (parsableByteArray.bytesLeft() < 3) {
                        FrameworkMediaDrm$$ExternalSyntheticLambda0.m(parsableByteArray.position, parsableByteArray.limit);
                        return null;
                    }
                    int unsignedInt24 = parsableByteArray.readUnsignedInt24();
                    i2 = parsableByteArray.position - 3;
                    parsableByteArray.position = i2;
                    if (unsignedInt24 == 4801587) {
                        break;
                    }
                    if (AacUtil.getFrameSize(parsableByteArray.peekInt()) == -1) {
                        if (i4 == 0) {
                            parsableByteArray.ensureCapacity(20);
                        }
                        i4++;
                        if (i4 > i) {
                        }
                    }
                    extractorInput.resetPeekPosition();
                    extractorInput.advancePeekPosition(i3);
                    return metadataDecode;
                } catch (EOFException unused) {
                }
            }
            parsableByteArray.skipBytes(6);
            int synchSafeInt = parsableByteArray.readSynchSafeInt();
            int i8 = synchSafeInt + 10;
            if (metadataDecode == null) {
                byte[] bArr2 = new byte[i8];
                System.arraycopy(parsableByteArray.data, i2, bArr2, 0, 10);
                extractorInput.peekFully(bArr2, 10, synchSafeInt);
                metadataDecode = new Id3Decoder(frameworkMediaDrm$$ExternalSyntheticLambda0).decode(bArr2, i8);
            } else {
                extractorInput.advancePeekPosition(synchSafeInt);
            }
            i3 += i8;
        }
    }
}
