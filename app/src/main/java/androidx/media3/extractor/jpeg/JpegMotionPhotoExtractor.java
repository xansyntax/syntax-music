package androidx.media3.extractor.jpeg;

import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.metadata.MotionPhotoMetadata;
import androidx.media3.extractor.mp4.Mp4Extractor;
import androidx.media3.extractor.text.CueDecoder;
import com.google.common.collect.RegularImmutableList;
import java.util.Objects;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http1.HeadersReader;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class JpegMotionPhotoExtractor implements Extractor {
    public ExtractorOutput extractorOutput;
    public ExtractorInput lastExtractorInput;
    public int marker;
    public MotionPhotoMetadata motionPhotoMetadata;
    public Mp4Extractor mp4Extractor;
    public HeadersReader mp4ExtractorStartOffsetExtractorInput;
    public int segmentLength;
    public byte state;
    public final ParsableByteArray scratch = new ParsableByteArray(2);
    public long mp4StartPosition = -1;

    public final void endReading$1() {
        ExtractorOutput extractorOutput = this.extractorOutput;
        extractorOutput.getClass();
        extractorOutput.endTracks();
        this.extractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
        this.state = (byte) 6;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00fe  */
    @Override // androidx.media3.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        String nullTerminatedString;
        HeadersReader internal;
        RegularImmutableList regularImmutableList;
        int i;
        MotionPhotoMetadata motionPhotoMetadata;
        long j;
        byte b = this.state;
        long j2 = -1;
        ParsableByteArray parsableByteArray = this.scratch;
        if (b == 0) {
            parsableByteArray.reset(2);
            extractorInput.readFully(parsableByteArray.data, 0, 2);
            int unsignedShort = parsableByteArray.readUnsignedShort();
            this.marker = unsignedShort;
            if (unsignedShort == 65498) {
                if (this.mp4StartPosition != -1) {
                    this.state = (byte) 4;
                    return 0;
                }
                endReading$1();
                return 0;
            }
            if ((unsignedShort < 65488 || unsignedShort > 65497) && unsignedShort != 65281) {
                this.state = (byte) 1;
            }
            return 0;
        }
        if (b == 1) {
            parsableByteArray.reset(2);
            extractorInput.peekFully(parsableByteArray.data, 0, 2);
            this.segmentLength = parsableByteArray.readUnsignedShort() - 2;
            extractorInput.skipFully(2);
            this.state = (byte) 2;
            return 0;
        }
        if (b != 2) {
            if (b != 4) {
                if (b != 5) {
                    if (b == 6) {
                        return -1;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                    return 0;
                }
                if (this.mp4ExtractorStartOffsetExtractorInput == null || extractorInput != this.lastExtractorInput) {
                    this.lastExtractorInput = extractorInput;
                    this.mp4ExtractorStartOffsetExtractorInput = new HeadersReader(extractorInput, this.mp4StartPosition);
                }
                Mp4Extractor mp4Extractor = this.mp4Extractor;
                mp4Extractor.getClass();
                int i2 = mp4Extractor.read(this.mp4ExtractorStartOffsetExtractorInput, positionHolder);
                if (i2 == 1) {
                    positionHolder.position += this.mp4StartPosition;
                }
                return i2;
            }
            long position = extractorInput.getPosition();
            long j3 = this.mp4StartPosition;
            if (position != j3) {
                positionHolder.position = j3;
                return 1;
            }
            if (!extractorInput.peekFully(parsableByteArray.data, 0, 1, true)) {
                endReading$1();
                return 0;
            }
            extractorInput.resetPeekPosition();
            if (this.mp4Extractor == null) {
                this.mp4Extractor = new Mp4Extractor(8, CueDecoder.UNSUPPORTED);
            }
            HeadersReader headersReader = new HeadersReader(extractorInput, this.mp4StartPosition);
            this.mp4ExtractorStartOffsetExtractorInput = headersReader;
            if (!this.mp4Extractor.sniff(headersReader)) {
                endReading$1();
                return 0;
            }
            Mp4Extractor mp4Extractor2 = this.mp4Extractor;
            long j4 = this.mp4StartPosition;
            ExtractorOutput extractorOutput = this.extractorOutput;
            extractorOutput.getClass();
            mp4Extractor2.init(new HeadersReader(j4, extractorOutput));
            MotionPhotoMetadata motionPhotoMetadata2 = this.motionPhotoMetadata;
            motionPhotoMetadata2.getClass();
            ExtractorOutput extractorOutput2 = this.extractorOutput;
            extractorOutput2.getClass();
            TrackOutput trackOutputTrack = extractorOutput2.track(1024, 4);
            Format.Builder builder = new Format.Builder();
            builder.containerMimeType = MimeTypes.normalizeMimeType("image/jpeg");
            builder.metadata = new Metadata(motionPhotoMetadata2);
            Format$$ExternalSyntheticOutline0.m(builder, trackOutputTrack);
            this.state = (byte) 5;
            return 0;
        }
        if (this.marker == 65505) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray(this.segmentLength);
            extractorInput.readFully(parsableByteArray2.data, 0, this.segmentLength);
            if (this.motionPhotoMetadata == null && "http://ns.adobe.com/xap/1.0/".equals(parsableByteArray2.readNullTerminatedString()) && (nullTerminatedString = parsableByteArray2.readNullTerminatedString()) != null) {
                long length = extractorInput.getLength();
                if (length == -1) {
                    motionPhotoMetadata = null;
                } else {
                    try {
                        internal = XmpMotionPhotoDescriptionParser.parseInternal(nullTerminatedString);
                    } catch (ParserException | NumberFormatException | XmlPullParserException unused) {
                        Log.w("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
                        internal = null;
                    }
                    if (internal != null && (i = (regularImmutableList = (RegularImmutableList) internal.source).size) >= 2) {
                        int i3 = i - 1;
                        long j5 = -1;
                        long j6 = -1;
                        long j7 = -1;
                        long j8 = -1;
                        while (i3 >= 0) {
                            MotionPhotoDescription$ContainerItem motionPhotoDescription$ContainerItem = (MotionPhotoDescription$ContainerItem) regularImmutableList.get(i3);
                            String str = motionPhotoDescription$ContainerItem.mime;
                            boolean z = str.equals("video/mp4") || str.equals("video/quicktime");
                            if (i3 == 0) {
                                length -= motionPhotoDescription$ContainerItem.padding;
                                j = 0;
                            } else {
                                j = length - motionPhotoDescription$ContainerItem.length;
                            }
                            long j9 = length;
                            length = j;
                            if (z && length != j9) {
                                j8 = j9 - length;
                                j7 = length;
                            }
                            if (i3 == 0) {
                                j6 = j9;
                                j5 = length;
                            }
                            i3--;
                            j2 = j2;
                        }
                        long j10 = j2;
                        if (j7 == j10 || j8 == j10 || j5 == j10 || j6 == j10) {
                            motionPhotoMetadata = null;
                        } else {
                            motionPhotoMetadata = new MotionPhotoMetadata(j5, j6, internal.headerLimit, j7, j8);
                        }
                    } else {
                        motionPhotoMetadata = null;
                    }
                }
                this.motionPhotoMetadata = motionPhotoMetadata;
                if (motionPhotoMetadata != null) {
                    this.mp4StartPosition = motionPhotoMetadata.videoStartPosition;
                }
            }
        } else {
            extractorInput.skipFully(this.segmentLength);
        }
        this.state = (byte) 0;
        return 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
        Mp4Extractor mp4Extractor = this.mp4Extractor;
        if (mp4Extractor != null) {
            mp4Extractor.getClass();
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void seek(long j, long j2) {
        if (j == 0) {
            this.state = (byte) 0;
            this.mp4Extractor = null;
        } else if (this.state == 5) {
            Mp4Extractor mp4Extractor = this.mp4Extractor;
            mp4Extractor.getClass();
            mp4Extractor.seek(j, j2);
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        String nullTerminatedString;
        DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) extractorInput;
        ParsableByteArray parsableByteArray = this.scratch;
        parsableByteArray.reset(2);
        defaultExtractorInput.peekFully(parsableByteArray.data, 0, 2, false);
        if (parsableByteArray.readUnsignedShort() == 65496) {
            while (true) {
                parsableByteArray.reset(2);
                defaultExtractorInput.peekFully(parsableByteArray.data, 0, 2, false);
                int unsignedShort = parsableByteArray.readUnsignedShort();
                this.marker = unsignedShort;
                if (unsignedShort == 65498) {
                    break;
                }
                parsableByteArray.reset(2);
                defaultExtractorInput.peekFully(parsableByteArray.data, 0, 2);
                int unsignedShort2 = parsableByteArray.readUnsignedShort() - 2;
                if (unsignedShort2 < 0) {
                    break;
                }
                if (this.marker != 65505) {
                    defaultExtractorInput.advancePeekPosition(unsignedShort2, false);
                } else {
                    parsableByteArray.reset(unsignedShort2);
                    defaultExtractorInput.peekFully(parsableByteArray.data, 0, unsignedShort2, false);
                    if (Objects.equals(parsableByteArray.readNullTerminatedString(), "http://ns.adobe.com/xap/1.0/") && (nullTerminatedString = parsableByteArray.readNullTerminatedString()) != null) {
                        for (int i = 0; i < 4; i++) {
                            if (nullTerminatedString.contains(XmpMotionPhotoDescriptionParser.MOTION_PHOTO_ATTRIBUTE_NAMES[i] + "=\"1\"")) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
