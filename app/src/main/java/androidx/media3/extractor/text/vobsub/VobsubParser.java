package androidx.media3.extractor.text.vobsub;

import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.VorbisBitArray;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.yalantis.ucrop.view.CropImageView;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VobsubParser implements SubtitleParser {
    public static final CuesWithTiming EMPTY_CUES;
    public final CueBuilder cueBuilder;
    public Inflater inflater;
    public final ParsableByteArray scratch = new ParsableByteArray();
    public final ParsableByteArray inflatedScratch = new ParsableByteArray();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CueBuilder {
        public Rect boundingBox;
        public boolean hasColors;
        public boolean hasPlane;
        public int[] palette;
        public int planeHeight;
        public int planeWidth;
        public long startTimeUs = -9223372036854775807L;
        public long endTimeUs = -9223372036854775807L;
        public final int[] colors = new int[4];
        public int dataOffset0 = -1;
        public int dataOffset1 = -1;

        public static int getColor(int i, int[] iArr) {
            return (i < 0 || i >= iArr.length) ? iArr[0] : iArr[i];
        }

        public static int setAlpha(int i, int i2) {
            return (i & 16777215) | ((i2 * 17) << 24);
        }

        public final void parseRleData(VorbisBitArray vorbisBitArray, boolean z, Rect rect, int[] iArr) {
            int i;
            int i2;
            int iWidth = rect.width();
            int iHeight = rect.height();
            int i3 = !z ? 1 : 0;
            int i4 = i3 * iWidth;
            while (true) {
                int i5 = 0;
                do {
                    int i6 = 1;
                    int bits = 0;
                    while (true) {
                        if (bits >= i6 || i6 > 64) {
                            i = bits & 3;
                            if (bits >= 4) {
                                i2 = bits >> 2;
                                break;
                            } else {
                                i2 = iWidth;
                                break;
                            }
                        }
                        if (vorbisBitArray.bitsLeft() < 4) {
                            i = -1;
                            i2 = 0;
                            break;
                        } else {
                            bits = (bits << 4) | vorbisBitArray.readBits(4);
                            i6 <<= 2;
                        }
                    }
                    int iMin = Math.min(i2, iWidth - i5);
                    if (iMin > 0) {
                        int i7 = i4 + iMin;
                        Arrays.fill(iArr, i4, i7, this.colors[i]);
                        i5 += iMin;
                        i4 = i7;
                    }
                } while (i5 < iWidth);
                i3 += 2;
                if (i3 >= iHeight) {
                    return;
                }
                i4 = i3 * iWidth;
                vorbisBitArray.byteAlign();
            }
        }
    }

    static {
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        EMPTY_CUES = new CuesWithTiming(-9223372036854775807L, -9223372036854775807L, RegularImmutableList.EMPTY);
    }

    public VobsubParser(List list) {
        int i;
        CueBuilder cueBuilder = new CueBuilder();
        this.cueBuilder = cueBuilder;
        String strTrim = new String((byte[]) list.get(0), StandardCharsets.UTF_8).trim();
        String str = Util.DEVICE_DEBUG_INFO;
        for (String str2 : strTrim.split("\\r?\\n", -1)) {
            if (str2.startsWith("palette: ")) {
                String[] strArrSplit = str2.substring(9).split(",", -1);
                cueBuilder.palette = new int[strArrSplit.length];
                for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                    int[] iArr = cueBuilder.palette;
                    try {
                        i = Integer.parseInt(strArrSplit[i2].trim(), 16);
                    } catch (RuntimeException e) {
                        Log.w("VobsubParser", "Parsing color failed", e);
                        i = 0;
                    }
                    iArr[i2] = i;
                }
            } else if (str2.startsWith("size: ")) {
                String[] strArrSplit2 = str2.substring(6).trim().split("x", -1);
                if (strArrSplit2.length != 2) {
                    Log.w("VobsubParser", "Ignoring malformed IDX size line: '" + str2 + "'");
                } else {
                    try {
                        cueBuilder.planeWidth = Integer.parseInt(strArrSplit2[0]);
                        cueBuilder.planeHeight = Integer.parseInt(strArrSplit2[1]);
                        cueBuilder.hasPlane = true;
                    } catch (RuntimeException e2) {
                        Log.w("VobsubParser", "Parsing IDX failed", e2);
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x0282  */
    /* JADX WARN: Code duplicated, block: B:102:0x0288  */
    /* JADX WARN: Code duplicated, block: B:88:0x0268  */
    /* JADX WARN: Code duplicated, block: B:91:0x026f  */
    /* JADX WARN: Code duplicated, block: B:97:0x027c  */
    /* JADX WARN: Failed to find 'out' block for switch in B:40:0x00b9. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.media3.extractor.text.SubtitleParser
    public final void parse(byte[] bArr, int i, int i2, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        CuesWithTiming cuesWithTiming;
        char c;
        long j;
        char c2;
        Cue cue;
        long j2;
        long j3;
        RegularImmutableList regularImmutableListOf;
        long j4;
        Rect rect;
        ParsableByteArray parsableByteArray = this.scratch;
        parsableByteArray.reset(bArr, i + i2);
        parsableByteArray.setPosition(i);
        Inflater inflater = this.inflater;
        if (inflater == null) {
            inflater = new Inflater();
            this.inflater = inflater;
        }
        ParsableByteArray parsableByteArray2 = this.inflatedScratch;
        if (Util.maybeInflate(parsableByteArray, parsableByteArray2, inflater)) {
            parsableByteArray.reset(parsableByteArray2.data, parsableByteArray2.limit);
        }
        CueBuilder cueBuilder = this.cueBuilder;
        long j5 = -9223372036854775807L;
        cueBuilder.startTimeUs = -9223372036854775807L;
        cueBuilder.endTimeUs = -9223372036854775807L;
        char c3 = 0;
        cueBuilder.hasColors = false;
        cueBuilder.boundingBox = null;
        cueBuilder.dataOffset0 = -1;
        cueBuilder.dataOffset1 = -1;
        int iBytesLeft = parsableByteArray.bytesLeft();
        if (iBytesLeft < 2 || parsableByteArray.readUnsignedShort() != iBytesLeft) {
            cuesWithTiming = EMPTY_CUES;
        } else {
            if (cueBuilder.palette == null) {
                Log.w("VobsubParser", "Skipping SPU (no palette)");
            } else {
                if (cueBuilder.hasPlane) {
                    int i3 = parsableByteArray.position - 2;
                    parsableByteArray.setPosition(parsableByteArray.readUnsignedShort() + i3);
                    while (true) {
                        if (parsableByteArray.bytesLeft() < 4) {
                            j = j5;
                            c2 = c3;
                            c = c2;
                        } else {
                            int i4 = parsableByteArray.position;
                            int unsignedShort = parsableByteArray.readUnsignedShort() * 10000;
                            int unsignedShort2 = parsableByteArray.readUnsignedShort() + i3;
                            c = (unsignedShort2 == i4 || unsignedShort2 >= parsableByteArray.limit) ? c3 : (char) 1;
                            int i5 = c != 0 ? unsignedShort2 : parsableByteArray.limit;
                            j = j5;
                            char c4 = 1;
                            while (parsableByteArray.position < i5 && c4 != 0) {
                                long j6 = unsignedShort;
                                int[] iArr = cueBuilder.colors;
                                char c5 = c3;
                                int unsignedByte = parsableByteArray.readUnsignedByte();
                                if (unsignedByte != 255) {
                                    switch (unsignedByte) {
                                        case 0:
                                            c4 = 1;
                                            break;
                                        case 1:
                                            cueBuilder.startTimeUs = j6;
                                            c4 = 1;
                                            break;
                                        case 2:
                                            cueBuilder.endTimeUs = j6;
                                            c4 = 1;
                                            break;
                                        case 3:
                                            if (parsableByteArray.bytesLeft() >= 2) {
                                                int unsignedByte2 = parsableByteArray.readUnsignedByte();
                                                int unsignedByte3 = parsableByteArray.readUnsignedByte();
                                                iArr[3] = CueBuilder.getColor(unsignedByte2 >> 4, cueBuilder.palette);
                                                iArr[2] = CueBuilder.getColor(unsignedByte2 & 15, cueBuilder.palette);
                                                iArr[1] = CueBuilder.getColor(unsignedByte3 >> 4, cueBuilder.palette);
                                                iArr[c5] = CueBuilder.getColor(unsignedByte3 & 15, cueBuilder.palette);
                                                cueBuilder.hasColors = true;
                                                c4 = 1;
                                            } else {
                                                Log.w("VobsubParser", "Incomplete color command");
                                                c4 = c5;
                                            }
                                            break;
                                        case 4:
                                            if (parsableByteArray.bytesLeft() < 2) {
                                                Log.w("VobsubParser", "Incomplete alpha command");
                                            } else if (cueBuilder.hasColors) {
                                                int unsignedByte4 = parsableByteArray.readUnsignedByte();
                                                int unsignedByte5 = parsableByteArray.readUnsignedByte();
                                                iArr[3] = CueBuilder.setAlpha(iArr[3], unsignedByte4 >> 4);
                                                iArr[2] = CueBuilder.setAlpha(iArr[2], unsignedByte4 & 15);
                                                iArr[1] = CueBuilder.setAlpha(iArr[1], unsignedByte5 >> 4);
                                                iArr[c5] = CueBuilder.setAlpha(iArr[c5], unsignedByte5 & 15);
                                                c4 = 1;
                                            } else {
                                                Log.w("VobsubParser", "Ignoring alpha command before color command");
                                            }
                                            c4 = c5;
                                            break;
                                        case 5:
                                            if (parsableByteArray.bytesLeft() >= 6) {
                                                int unsignedByte6 = parsableByteArray.readUnsignedByte();
                                                int unsignedByte7 = parsableByteArray.readUnsignedByte();
                                                int i6 = (unsignedByte6 << 4) | (unsignedByte7 >> 4);
                                                int unsignedByte8 = ((unsignedByte7 & 15) << 8) | parsableByteArray.readUnsignedByte();
                                                int unsignedByte9 = parsableByteArray.readUnsignedByte();
                                                int unsignedByte10 = parsableByteArray.readUnsignedByte();
                                                cueBuilder.boundingBox = new Rect(i6, (unsignedByte9 << 4) | (unsignedByte10 >> 4), unsignedByte8 + 1, (((unsignedByte10 & 15) << 8) | parsableByteArray.readUnsignedByte()) + 1);
                                                c4 = 1;
                                            } else {
                                                Log.w("VobsubParser", "Incomplete area command");
                                                c4 = c5;
                                            }
                                            break;
                                        case 6:
                                            if (parsableByteArray.bytesLeft() >= 4) {
                                                cueBuilder.dataOffset0 = parsableByteArray.readUnsignedShort();
                                                cueBuilder.dataOffset1 = parsableByteArray.readUnsignedShort();
                                                c4 = 1;
                                            } else {
                                                Log.w("VobsubParser", "Incomplete offsets command");
                                                c4 = c5;
                                            }
                                            break;
                                        default:
                                            Format$$ExternalSyntheticOutline0.m(unsignedByte, "Unrecognized command: ", "VobsubParser");
                                            c4 = c5;
                                            break;
                                    }
                                } else {
                                    c4 = c5;
                                }
                                c3 = c5;
                            }
                            c2 = c3;
                            if (c != 0) {
                                parsableByteArray.setPosition(unsignedShort2);
                            }
                        }
                        if (c != 0) {
                            j5 = j;
                            c3 = c2;
                        }
                    }
                } else {
                    Log.w("VobsubParser", "Skipping SPU (no plane)");
                }
                if (cueBuilder.palette != null || !cueBuilder.hasPlane || !cueBuilder.hasColors || (rect = cueBuilder.boundingBox) == null || cueBuilder.dataOffset0 == -1 || cueBuilder.dataOffset1 == -1 || rect.width() < 2 || cueBuilder.boundingBox.height() < 2) {
                    cue = null;
                } else {
                    Rect rect2 = cueBuilder.boundingBox;
                    int[] iArr2 = new int[rect2.height() * rect2.width()];
                    VorbisBitArray vorbisBitArray = new VorbisBitArray();
                    parsableByteArray.setPosition(cueBuilder.dataOffset0);
                    vorbisBitArray.reset(parsableByteArray);
                    cueBuilder.parseRleData(vorbisBitArray, true, rect2, iArr2);
                    parsableByteArray.setPosition(cueBuilder.dataOffset1);
                    vorbisBitArray.reset(parsableByteArray);
                    cueBuilder.parseRleData(vorbisBitArray, c2, rect2, iArr2);
                    cue = new Cue(null, null, null, Bitmap.createBitmap(iArr2, rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888), rect2.top / cueBuilder.planeHeight, 0, 0, rect2.left / cueBuilder.planeWidth, 0, Integer.MIN_VALUE, -3.4028235E38f, rect2.width() / cueBuilder.planeWidth, rect2.height() / cueBuilder.planeHeight, false, -16777216, Integer.MIN_VALUE, CropImageView.DEFAULT_ASPECT_RATIO, 0);
                }
                j2 = cueBuilder.endTimeUs;
                if (j2 != j) {
                    j4 = cueBuilder.startTimeUs;
                    if (j4 != j && j2 > j4) {
                        j2 -= j4;
                    }
                    j3 = j2;
                } else {
                    j3 = j;
                }
                if (cue != null) {
                    regularImmutableListOf = ImmutableList.of((Object) cue);
                } else {
                    ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
                    regularImmutableListOf = RegularImmutableList.EMPTY;
                }
                cuesWithTiming = new CuesWithTiming(cueBuilder.startTimeUs, j3, regularImmutableListOf);
            }
            j = -9223372036854775807L;
            c2 = 0;
            if (cueBuilder.palette != null) {
                cue = null;
            } else {
                cue = null;
            }
            j2 = cueBuilder.endTimeUs;
            if (j2 != j) {
                j4 = cueBuilder.startTimeUs;
                if (j4 != j) {
                    j2 -= j4;
                }
                j3 = j2;
            } else {
                j3 = j;
            }
            if (cue != null) {
                regularImmutableListOf = ImmutableList.of((Object) cue);
            } else {
                ImmutableList.Itr itr2 = ImmutableList.EMPTY_ITR;
                regularImmutableListOf = RegularImmutableList.EMPTY;
            }
            cuesWithTiming = new CuesWithTiming(cueBuilder.startTimeUs, j3, regularImmutableListOf);
        }
        consumer.accept(cuesWithTiming);
    }
}
