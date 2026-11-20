package androidx.media3.extractor.text.dvb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.VorbisBitArray;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.ssa.SsaDialogueFormat;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.http2.Huffman;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DvbParser implements SubtitleParser {
    public static final byte[] defaultMap2To4 = {0, 7, 8, 15};
    public static final byte[] defaultMap2To8 = {0, 119, -120, -1};
    public static final byte[] defaultMap4To8 = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    public Bitmap bitmap;
    public final Canvas canvas;
    public final ClutDefinition defaultClutDefinition;
    public final SsaDialogueFormat defaultDisplayDefinition;
    public final Paint defaultPaint;
    public final Paint fillRegionPaint;
    public final SubtitleService subtitleService;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ClutDefinition {
        public final int[] clutEntries2Bit;
        public final int[] clutEntries4Bit;
        public final int[] clutEntries8Bit;
        public final int id;

        public ClutDefinition(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.id = i;
            this.clutEntries2Bit = iArr;
            this.clutEntries4Bit = iArr2;
            this.clutEntries8Bit = iArr3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ObjectData {
        public final byte[] bottomFieldData;
        public final int id;
        public final boolean nonModifyingColorFlag;
        public final byte[] topFieldData;

        public ObjectData(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.id = i;
            this.nonModifyingColorFlag = z;
            this.topFieldData = bArr;
            this.bottomFieldData = bArr2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PageRegion {
        public final int horizontalAddress;
        public final int verticalAddress;

        public PageRegion(int i, int i2) {
            this.horizontalAddress = i;
            this.verticalAddress = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RegionComposition {
        public final int clutId;
        public final int depth;
        public final boolean fillFlag;
        public final int height;
        public final int id;
        public final int pixelCode2Bit;
        public final int pixelCode4Bit;
        public final int pixelCode8Bit;
        public final SparseArray regionObjects;
        public final int width;

        public RegionComposition(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, SparseArray sparseArray) {
            this.id = i;
            this.fillFlag = z;
            this.width = i2;
            this.height = i3;
            this.depth = i4;
            this.clutId = i5;
            this.pixelCode8Bit = i6;
            this.pixelCode4Bit = i7;
            this.pixelCode2Bit = i8;
            this.regionObjects = sparseArray;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RegionObject {
        public final int horizontalPosition;
        public final int verticalPosition;

        public RegionObject(int i, int i2) {
            this.horizontalPosition = i;
            this.verticalPosition = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SubtitleService {
        public final int ancillaryPageId;
        public SsaDialogueFormat displayDefinition;
        public Huffman.Node pageComposition;
        public final int subtitlePageId;
        public final SparseArray regions = new SparseArray();
        public final SparseArray cluts = new SparseArray();
        public final SparseArray objects = new SparseArray();
        public final SparseArray ancillaryCluts = new SparseArray();
        public final SparseArray ancillaryObjects = new SparseArray();

        public SubtitleService(int i, int i2) {
            this.subtitlePageId = i;
            this.ancillaryPageId = i2;
        }
    }

    public DvbParser(List list) {
        ParsableByteArray parsableByteArray = new ParsableByteArray((byte[]) list.get(0));
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedShort2 = parsableByteArray.readUnsignedShort();
        Paint paint = new Paint();
        this.defaultPaint = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.fillRegionPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.canvas = new Canvas();
        this.defaultDisplayDefinition = new SsaDialogueFormat(719, 575, 0, 719, 0, 575);
        this.defaultClutDefinition = new ClutDefinition(0, new int[]{0, -1, -16777216, -8421505}, generateDefault4BitClutEntries(), generateDefault8BitClutEntries());
        this.subtitleService = new SubtitleService(unsignedShort, unsignedShort2);
    }

    public static byte[] buildClutMapTable(int i, int i2, VorbisBitArray vorbisBitArray) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) vorbisBitArray.readBits(i2);
        }
        return bArr;
    }

    public static int[] generateDefault4BitClutEntries() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            if (i < 8) {
                iArr[i] = getColor(255, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                iArr[i] = getColor(255, (i & 1) != 0 ? 127 : 0, (i & 2) != 0 ? 127 : 0, (i & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    public static int[] generateDefault8BitClutEntries() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            if (i < 8) {
                iArr[i] = getColor(63, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) == 0 ? 0 : 255);
            } else {
                int i2 = i & 136;
                if (i2 == 0) {
                    iArr[i] = getColor(255, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 8) {
                    iArr[i] = getColor(127, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 128) {
                    iArr[i] = getColor(255, ((i & 1) != 0 ? 43 : 0) + 127 + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + 127 + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + 127 + ((i & 64) == 0 ? 0 : 85));
                } else if (i2 == 136) {
                    iArr[i] = getColor(255, ((i & 1) != 0 ? 43 : 0) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + ((i & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public static int getColor(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    /* JADX WARN: Code duplicated, block: B:115:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:119:0x0203 A[LOOP:3: B:87:0x0156->B:119:0x0203, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:133:0x01ff A[SYNTHETIC] */
    public static void paintPixelDataSubBlock(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        byte[] bArr2;
        char c;
        char c2;
        int bits;
        int bits2;
        boolean z;
        int bits3;
        int bits4;
        int bits5;
        int i4;
        int i5;
        boolean z2;
        int bits6;
        VorbisBitArray vorbisBitArray = new VorbisBitArray(bArr, bArr.length);
        int i6 = i2;
        int i7 = i3;
        byte[] bArrBuildClutMapTable = null;
        byte[] bArrBuildClutMapTable2 = null;
        byte[] bArrBuildClutMapTable3 = null;
        while (vorbisBitArray.bitsLeft() != 0) {
            int i8 = 8;
            int bits7 = vorbisBitArray.readBits(8);
            if (bits7 != 240) {
                int i9 = 3;
                int i10 = 2;
                int i11 = 4;
                switch (bits7) {
                    case 16:
                        if (i == 3) {
                            bArr2 = bArrBuildClutMapTable == null ? defaultMap2To8 : bArrBuildClutMapTable;
                        } else if (i == 2) {
                            bArr2 = bArrBuildClutMapTable3 == null ? defaultMap2To4 : bArrBuildClutMapTable3;
                        } else {
                            bArr2 = null;
                        }
                        boolean z3 = false;
                        while (true) {
                            int bits8 = vorbisBitArray.readBits(2);
                            if (bits8 != 0) {
                                bits = bits8;
                                bits2 = 1;
                            } else {
                                if (vorbisBitArray.readBit()) {
                                    int bits9 = vorbisBitArray.readBits(3) + 3;
                                    bits = vorbisBitArray.readBits(2);
                                    bits2 = bits9;
                                } else {
                                    if (vorbisBitArray.readBit()) {
                                        bits2 = 1;
                                        c = '\b';
                                        c2 = 4;
                                    } else {
                                        int bits10 = vorbisBitArray.readBits(2);
                                        if (bits10 == 0) {
                                            c = '\b';
                                            c2 = 4;
                                            z3 = true;
                                        } else if (bits10 == 1) {
                                            c = '\b';
                                            c2 = 4;
                                            bits2 = 2;
                                        } else if (bits10 == 2) {
                                            c = '\b';
                                            c2 = 4;
                                            bits2 = vorbisBitArray.readBits(4) + 12;
                                            bits = vorbisBitArray.readBits(2);
                                            z3 = z3;
                                        } else if (bits10 != 3) {
                                            z3 = z3;
                                            c = '\b';
                                            c2 = 4;
                                        } else {
                                            c = '\b';
                                            int bits11 = vorbisBitArray.readBits(8) + 29;
                                            bits = vorbisBitArray.readBits(2);
                                            z3 = z3;
                                            bits2 = bits11;
                                            c2 = 4;
                                        }
                                        bits = 0;
                                        bits2 = 0;
                                    }
                                    bits = 0;
                                }
                                if (bits2 == 0 && paint != null) {
                                    if (bArr2 != 0) {
                                        bits = bArr2[bits];
                                    }
                                    paint.setColor(iArr[bits]);
                                    canvas.drawRect(i6, i7, i6 + bits2, i7 + 1, paint);
                                }
                                i6 += bits2;
                                if (z3) {
                                    vorbisBitArray.byteAlign();
                                } else {
                                    paint = paint;
                                    z3 = z3;
                                }
                            }
                            c = '\b';
                            c2 = 4;
                            if (bits2 == 0) {
                            }
                            i6 += bits2;
                            if (z3) {
                                vorbisBitArray.byteAlign();
                            } else {
                                paint = paint;
                                z3 = z3;
                            }
                            break;
                        }
                        break;
                    case 17:
                        byte[] bArr3 = i == 3 ? bArrBuildClutMapTable2 == null ? defaultMap4To8 : bArrBuildClutMapTable2 : null;
                        boolean z4 = false;
                        while (true) {
                            int bits12 = vorbisBitArray.readBits(i11);
                            if (bits12 != 0) {
                                z = z4;
                                bits5 = bits12;
                                bits3 = 1;
                            } else if (vorbisBitArray.readBit()) {
                                if (vorbisBitArray.readBit()) {
                                    int bits13 = vorbisBitArray.readBits(i10);
                                    if (bits13 == 0) {
                                        z = z4;
                                        bits3 = 1;
                                    } else if (bits13 != 1) {
                                        if (bits13 == i10) {
                                            bits3 = vorbisBitArray.readBits(i11) + 9;
                                            bits4 = vorbisBitArray.readBits(i11);
                                        } else if (bits13 != i9) {
                                            z = z4;
                                            bits3 = 0;
                                        } else {
                                            bits3 = vorbisBitArray.readBits(i8) + 25;
                                            bits4 = vorbisBitArray.readBits(i11);
                                        }
                                        bits5 = bits4;
                                    } else {
                                        z = z4;
                                        bits3 = i10;
                                    }
                                    bits5 = 0;
                                } else {
                                    bits3 = vorbisBitArray.readBits(i10) + 4;
                                    bits5 = vorbisBitArray.readBits(i11);
                                }
                                z = z4;
                            } else {
                                int bits14 = vorbisBitArray.readBits(i9);
                                if (bits14 != 0) {
                                    bits3 = bits14 + 2;
                                    z = z4;
                                } else {
                                    z = true;
                                    bits3 = 0;
                                }
                                bits5 = 0;
                            }
                            if (bits3 == 0 || paint == 0) {
                                i4 = i9;
                                i5 = i10;
                            } else {
                                if (bArr3 != 0) {
                                    bits5 = bArr3[bits5];
                                }
                                paint.setColor(iArr[bits5]);
                                i4 = i9;
                                i5 = 2;
                                canvas.drawRect(i6, i7, i6 + bits3, i7 + 1, paint);
                            }
                            i6 += bits3;
                            if (z) {
                                vorbisBitArray.byteAlign();
                            } else {
                                z4 = z;
                                i9 = i4;
                                i10 = i5;
                                i11 = 4;
                                i8 = 8;
                            }
                            break;
                        }
                        break;
                    case 18:
                        boolean z5 = false;
                        while (true) {
                            int bits15 = vorbisBitArray.readBits(8);
                            if (bits15 != 0) {
                                z2 = z5;
                                bits6 = 1;
                            } else if (vorbisBitArray.readBit()) {
                                z2 = z5;
                                bits6 = vorbisBitArray.readBits(7);
                                bits15 = vorbisBitArray.readBits(8);
                            } else {
                                int bits16 = vorbisBitArray.readBits(7);
                                if (bits16 != 0) {
                                    z2 = z5;
                                    bits6 = bits16;
                                    bits15 = 0;
                                } else {
                                    z2 = true;
                                    bits15 = 0;
                                    bits6 = 0;
                                }
                            }
                            if (bits6 != 0 && paint != 0) {
                                paint.setColor(iArr[bits15]);
                                canvas.drawRect(i6, i7, i6 + bits6, i7 + 1, paint);
                            }
                            i6 += bits6;
                            if (!z2) {
                                z5 = z2;
                            }
                            break;
                        }
                        break;
                    default:
                        switch (bits7) {
                            case 32:
                                bArrBuildClutMapTable3 = buildClutMapTable(4, 4, vorbisBitArray);
                                break;
                            case 33:
                                bArrBuildClutMapTable = buildClutMapTable(4, 8, vorbisBitArray);
                                break;
                            case 34:
                                bArrBuildClutMapTable2 = buildClutMapTable(16, 8, vorbisBitArray);
                                break;
                        }
                        break;
                }
            } else {
                i7 += 2;
                i6 = i2;
            }
        }
    }

    public static ClutDefinition parseClutDefinition(VorbisBitArray vorbisBitArray, int i) {
        int[] iArr;
        int bits;
        int i2;
        int bits2;
        int bits3;
        int bits4;
        int i3 = 8;
        int bits5 = vorbisBitArray.readBits(8);
        vorbisBitArray.skipBits(8);
        int i4 = 2;
        int i5 = i - 2;
        int i6 = 0;
        int[] iArr2 = {0, -1, -16777216, -8421505};
        int[] iArrGenerateDefault4BitClutEntries = generateDefault4BitClutEntries();
        int[] iArrGenerateDefault8BitClutEntries = generateDefault8BitClutEntries();
        while (i5 > 0) {
            int bits6 = vorbisBitArray.readBits(i3);
            int bits7 = vorbisBitArray.readBits(i3);
            if ((bits7 & 128) != 0) {
                iArr = iArr2;
            } else {
                iArr = (bits7 & 64) != 0 ? iArrGenerateDefault4BitClutEntries : iArrGenerateDefault8BitClutEntries;
            }
            if ((bits7 & 1) != 0) {
                bits3 = vorbisBitArray.readBits(i3);
                bits4 = vorbisBitArray.readBits(i3);
                bits = vorbisBitArray.readBits(i3);
                bits2 = vorbisBitArray.readBits(i3);
                i2 = i5 - 6;
            } else {
                int bits8 = vorbisBitArray.readBits(6) << i4;
                int bits9 = vorbisBitArray.readBits(4) << 4;
                bits = vorbisBitArray.readBits(4) << 4;
                i2 = i5 - 4;
                bits2 = vorbisBitArray.readBits(i4) << 6;
                bits3 = bits8;
                bits4 = bits9;
            }
            if (bits3 == 0) {
                bits4 = i6;
                bits = bits4;
                bits2 = 255;
            }
            double d = bits3;
            double d2 = bits4 - 128;
            double d3 = bits - 128;
            iArr[bits6] = getColor((byte) (255 - (bits2 & 255)), Util.constrainValue((int) ((1.402d * d2) + d), 0, 255), Util.constrainValue((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 0, 255), Util.constrainValue((int) ((d3 * 1.772d) + d), 0, 255));
            i5 = i2;
            i6 = 0;
            bits5 = bits5;
            iArrGenerateDefault8BitClutEntries = iArrGenerateDefault8BitClutEntries;
            i3 = 8;
            i4 = 2;
        }
        return new ClutDefinition(bits5, iArr2, iArrGenerateDefault4BitClutEntries, iArrGenerateDefault8BitClutEntries);
    }

    public static ObjectData parseObjectData(VorbisBitArray vorbisBitArray) {
        byte[] bArr;
        int bits = vorbisBitArray.readBits(16);
        vorbisBitArray.skipBits(4);
        int bits2 = vorbisBitArray.readBits(2);
        boolean bit = vorbisBitArray.readBit();
        vorbisBitArray.skipBits(1);
        byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
        if (bits2 != 1) {
            if (bits2 == 0) {
                int bits3 = vorbisBitArray.readBits(16);
                int bits4 = vorbisBitArray.readBits(16);
                if (bits3 > 0) {
                    bArr2 = new byte[bits3];
                    vorbisBitArray.readBytes(bArr2, bits3);
                }
                if (bits4 > 0) {
                    bArr = new byte[bits4];
                    vorbisBitArray.readBytes(bArr, bits4);
                }
            }
            return new ObjectData(bits, bit, bArr2, bArr);
        }
        vorbisBitArray.skipBits(vorbisBitArray.readBits(8) * 16);
        bArr = bArr2;
        return new ObjectData(bits, bit, bArr2, bArr);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x0067  */
    @Override // androidx.media3.extractor.text.SubtitleParser
    public final void parse(byte[] bArr, int i, int i2, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        CuesWithTiming cuesWithTiming;
        char c;
        Canvas canvas;
        RegionComposition regionComposition;
        int i3;
        int i4;
        RegionComposition regionComposition2;
        int i5;
        int bits;
        int i6;
        int i7;
        VorbisBitArray vorbisBitArray = new VorbisBitArray(bArr, i + i2);
        vorbisBitArray.setPosition(i);
        SubtitleService subtitleService = this.subtitleService;
        SparseArray sparseArray = subtitleService.ancillaryCluts;
        SparseArray sparseArray2 = subtitleService.ancillaryObjects;
        int i8 = subtitleService.ancillaryPageId;
        SparseArray sparseArray3 = subtitleService.regions;
        SparseArray sparseArray4 = subtitleService.cluts;
        SparseArray sparseArray5 = subtitleService.objects;
        int i9 = subtitleService.subtitlePageId;
        while (vorbisBitArray.bitsLeft() >= 48 && vorbisBitArray.readBits(8) == 15) {
            int bits2 = vorbisBitArray.readBits(8);
            int bits3 = vorbisBitArray.readBits(16);
            int bits4 = vorbisBitArray.readBits(16);
            int bytePosition = vorbisBitArray.getBytePosition() + bits4;
            if (bits4 * 8 > vorbisBitArray.bitsLeft()) {
                Log.w("DvbParser", "Data field length exceeds limit");
                vorbisBitArray.skipBits(vorbisBitArray.bitsLeft());
                i3 = i8;
                i4 = i9;
            } else {
                switch (bits2) {
                    case 16:
                        i3 = i8;
                        if (bits3 == i9) {
                            Huffman.Node node = subtitleService.pageComposition;
                            int i10 = 8;
                            vorbisBitArray.readBits(8);
                            int bits5 = vorbisBitArray.readBits(4);
                            int bits6 = vorbisBitArray.readBits(2);
                            vorbisBitArray.skipBits(2);
                            int i11 = bits4 - 2;
                            SparseArray sparseArray6 = new SparseArray();
                            while (i11 > 0) {
                                int bits7 = vorbisBitArray.readBits(i10);
                                vorbisBitArray.skipBits(i10);
                                sparseArray6.put(bits7, new PageRegion(vorbisBitArray.readBits(16), vorbisBitArray.readBits(16)));
                                i9 = i9;
                                i11 -= 6;
                                i10 = 8;
                            }
                            i4 = i9;
                            Huffman.Node node2 = new Huffman.Node(bits5, bits6, sparseArray6);
                            if (bits6 != 0) {
                                subtitleService.pageComposition = node2;
                                sparseArray3.clear();
                                sparseArray4.clear();
                                sparseArray5.clear();
                            } else if (node != null && node.symbol != bits5) {
                                subtitleService.pageComposition = node2;
                            }
                        } else {
                            i4 = i9;
                        }
                        break;
                    case 17:
                        Huffman.Node node3 = subtitleService.pageComposition;
                        if (bits3 != i9 || node3 == null) {
                            i3 = i8;
                        } else {
                            int bits8 = vorbisBitArray.readBits(8);
                            vorbisBitArray.skipBits(4);
                            boolean bit = vorbisBitArray.readBit();
                            vorbisBitArray.skipBits(3);
                            int bits9 = vorbisBitArray.readBits(16);
                            int bits10 = vorbisBitArray.readBits(16);
                            vorbisBitArray.readBits(3);
                            int bits11 = vorbisBitArray.readBits(3);
                            int i12 = 2;
                            vorbisBitArray.skipBits(2);
                            int bits12 = vorbisBitArray.readBits(8);
                            int bits13 = vorbisBitArray.readBits(8);
                            int bits14 = vorbisBitArray.readBits(4);
                            int bits15 = vorbisBitArray.readBits(2);
                            vorbisBitArray.skipBits(2);
                            int i13 = bits4 - 10;
                            SparseArray sparseArray7 = new SparseArray();
                            while (i13 > 0) {
                                int bits16 = vorbisBitArray.readBits(16);
                                int bits17 = vorbisBitArray.readBits(i12);
                                vorbisBitArray.readBits(i12);
                                int i14 = i8;
                                int bits18 = vorbisBitArray.readBits(12);
                                int i15 = i13;
                                vorbisBitArray.skipBits(4);
                                int bits19 = vorbisBitArray.readBits(12);
                                int i16 = i15 - 6;
                                if (bits17 == 1 || bits17 == 2) {
                                    vorbisBitArray.readBits(8);
                                    vorbisBitArray.readBits(8);
                                    i13 = i15 - 8;
                                } else {
                                    i13 = i16;
                                }
                                sparseArray7.put(bits16, new RegionObject(bits18, bits19));
                                i8 = i14;
                                i12 = 2;
                            }
                            i3 = i8;
                            RegionComposition regionComposition3 = new RegionComposition(bits8, bit, bits9, bits10, bits11, bits12, bits13, bits14, bits15, sparseArray7);
                            if (node3.terminalBitCount == 0 && (regionComposition2 = (RegionComposition) sparseArray3.get(bits8)) != null) {
                                SparseArray sparseArray8 = regionComposition2.regionObjects;
                                for (int i17 = 0; i17 < sparseArray8.size(); i17++) {
                                    regionComposition3.regionObjects.put(sparseArray8.keyAt(i17), (RegionObject) sparseArray8.valueAt(i17));
                                }
                            }
                            sparseArray3.put(regionComposition3.id, regionComposition3);
                        }
                        i4 = i9;
                        break;
                    case 18:
                        if (bits3 == i9) {
                            ClutDefinition clutDefinition = parseClutDefinition(vorbisBitArray, bits4);
                            sparseArray4.put(clutDefinition.id, clutDefinition);
                        } else if (bits3 == i8) {
                            ClutDefinition clutDefinition2 = parseClutDefinition(vorbisBitArray, bits4);
                            sparseArray.put(clutDefinition2.id, clutDefinition2);
                        }
                        i3 = i8;
                        i4 = i9;
                        break;
                    case 19:
                        if (bits3 == i9) {
                            ObjectData objectData = parseObjectData(vorbisBitArray);
                            sparseArray5.put(objectData.id, objectData);
                        } else if (bits3 == i8) {
                            ObjectData objectData2 = parseObjectData(vorbisBitArray);
                            sparseArray2.put(objectData2.id, objectData2);
                        }
                        i3 = i8;
                        i4 = i9;
                        break;
                    case 20:
                        if (bits3 == i9) {
                            vorbisBitArray.skipBits(4);
                            boolean bit2 = vorbisBitArray.readBit();
                            vorbisBitArray.skipBits(3);
                            int bits20 = vorbisBitArray.readBits(16);
                            int bits21 = vorbisBitArray.readBits(16);
                            if (bit2) {
                                int bits22 = vorbisBitArray.readBits(16);
                                int bits23 = vorbisBitArray.readBits(16);
                                int bits24 = vorbisBitArray.readBits(16);
                                i5 = bits23;
                                bits = vorbisBitArray.readBits(16);
                                i7 = bits24;
                                i6 = bits22;
                            } else {
                                i5 = bits20;
                                bits = bits21;
                                i6 = 0;
                                i7 = 0;
                            }
                            subtitleService.displayDefinition = new SsaDialogueFormat(bits20, bits21, i6, i5, i7, bits);
                        }
                        i3 = i8;
                        i4 = i9;
                        break;
                    default:
                        i3 = i8;
                        i4 = i9;
                        break;
                }
                vorbisBitArray.skipBytes(bytePosition - vorbisBitArray.getBytePosition());
            }
            i9 = i4;
            i8 = i3;
        }
        Huffman.Node node4 = subtitleService.pageComposition;
        if (node4 == null) {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            cuesWithTiming = new CuesWithTiming(-9223372036854775807L, -9223372036854775807L, RegularImmutableList.EMPTY);
        } else {
            SsaDialogueFormat ssaDialogueFormat = subtitleService.displayDefinition;
            if (ssaDialogueFormat == null) {
                ssaDialogueFormat = this.defaultDisplayDefinition;
            }
            int i18 = ssaDialogueFormat.startTimeIndex;
            int i19 = ssaDialogueFormat.layerIndex;
            Bitmap bitmap = this.bitmap;
            Canvas canvas2 = this.canvas;
            if (bitmap == null || i19 + 1 != bitmap.getWidth() || i18 + 1 != this.bitmap.getHeight()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i19 + 1, i18 + 1, Bitmap.Config.ARGB_8888);
                this.bitmap = bitmapCreateBitmap;
                canvas2.setBitmap(bitmapCreateBitmap);
            }
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray9 = (SparseArray) node4.children;
            int i20 = 0;
            while (i20 < sparseArray9.size()) {
                canvas2.save();
                PageRegion pageRegion = (PageRegion) sparseArray9.valueAt(i20);
                RegionComposition regionComposition4 = (RegionComposition) sparseArray3.get(sparseArray9.keyAt(i20));
                SparseArray sparseArray10 = sparseArray9;
                int i21 = pageRegion.horizontalAddress + ssaDialogueFormat.endTimeIndex;
                int i22 = pageRegion.verticalAddress + ssaDialogueFormat.textIndex;
                int i23 = regionComposition4.width;
                SparseArray sparseArray11 = sparseArray3;
                int i24 = regionComposition4.clutId;
                int i25 = i20;
                int i26 = regionComposition4.height;
                ArrayList arrayList2 = arrayList;
                int i27 = i21 + i23;
                int i28 = i23;
                int i29 = i18;
                int i30 = i22 + i26;
                int i31 = i19;
                canvas2.clipRect(i21, i22, Math.min(i27, ssaDialogueFormat.styleIndex), Math.min(i30, ssaDialogueFormat.length));
                ClutDefinition clutDefinition3 = (ClutDefinition) sparseArray4.get(i24);
                if (clutDefinition3 == null && (clutDefinition3 = (ClutDefinition) sparseArray.get(i24)) == null) {
                    clutDefinition3 = this.defaultClutDefinition;
                }
                int[] iArr = clutDefinition3.clutEntries2Bit;
                int[] iArr2 = clutDefinition3.clutEntries4Bit;
                int[] iArr3 = clutDefinition3.clutEntries8Bit;
                SsaDialogueFormat ssaDialogueFormat2 = ssaDialogueFormat;
                SparseArray sparseArray12 = regionComposition4.regionObjects;
                SparseArray sparseArray13 = sparseArray;
                int i32 = 0;
                while (i32 < sparseArray12.size()) {
                    int iKeyAt = sparseArray12.keyAt(i32);
                    SparseArray sparseArray14 = sparseArray12;
                    RegionObject regionObject = (RegionObject) sparseArray12.valueAt(i32);
                    ObjectData objectData3 = (ObjectData) sparseArray5.get(iKeyAt);
                    if (objectData3 == null) {
                        objectData3 = (ObjectData) sparseArray2.get(iKeyAt);
                    }
                    ObjectData objectData4 = objectData3;
                    int i33 = i32;
                    if (objectData4 != null) {
                        Paint paint = objectData4.nonModifyingColorFlag ? null : this.defaultPaint;
                        RegionComposition regionComposition5 = regionComposition4;
                        int i34 = regionComposition5.depth;
                        int i35 = regionObject.horizontalPosition + i21;
                        int i36 = regionObject.verticalPosition + i22;
                        if (i34 == 3) {
                            iArr2 = iArr3;
                        } else if (i34 != 2) {
                            iArr2 = iArr;
                        }
                        canvas = canvas2;
                        regionComposition = regionComposition5;
                        paintPixelDataSubBlock(objectData4.topFieldData, iArr2, i34, i35, r19, paint, canvas);
                        paintPixelDataSubBlock(objectData4.bottomFieldData, iArr2, i34, i35, i36 + 1, paint, canvas);
                    } else {
                        canvas = canvas2;
                        regionComposition = regionComposition4;
                    }
                    i28 = i28;
                    regionComposition4 = regionComposition;
                    i32 = i33 + 1;
                    canvas2 = canvas;
                    sparseArray12 = sparseArray14;
                    iArr2 = iArr2;
                }
                Canvas canvas3 = canvas2;
                int[] iArr4 = iArr2;
                RegionComposition regionComposition6 = regionComposition4;
                int i37 = i28;
                if (regionComposition6.fillFlag) {
                    int i38 = regionComposition6.depth;
                    int i39 = i38 == 3 ? iArr3[regionComposition6.pixelCode8Bit] : i38 == 2 ? iArr4[regionComposition6.pixelCode4Bit] : iArr[regionComposition6.pixelCode2Bit];
                    Paint paint2 = this.fillRegionPaint;
                    paint2.setColor(i39);
                    c = 3;
                    canvas2 = canvas3;
                    canvas2.drawRect(i21, i22, i27, i30, paint2);
                } else {
                    canvas2 = canvas3;
                    c = 3;
                }
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.bitmap, i21, i22, i37, i26);
                float f = i21;
                float f2 = i31;
                float f3 = f / f2;
                i18 = i29;
                float f4 = i18;
                arrayList2.add(new Cue(null, null, null, bitmapCreateBitmap2, i22 / f4, 0, 0, f3, 0, Integer.MIN_VALUE, -3.4028235E38f, i37 / f2, i26 / f4, false, -16777216, Integer.MIN_VALUE, CropImageView.DEFAULT_ASPECT_RATIO, 0));
                canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas2.restore();
                i20 = i25 + 1;
                i19 = i31;
                sparseArray9 = sparseArray10;
                sparseArray3 = sparseArray11;
                sparseArray = sparseArray13;
                arrayList = arrayList2;
                ssaDialogueFormat = ssaDialogueFormat2;
            }
            cuesWithTiming = new CuesWithTiming(-9223372036854775807L, -9223372036854775807L, arrayList);
        }
        consumer.accept(cuesWithTiming);
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final void reset() {
        SubtitleService subtitleService = this.subtitleService;
        subtitleService.regions.clear();
        subtitleService.cluts.clear();
        subtitleService.objects.clear();
        subtitleService.ancillaryCluts.clear();
        subtitleService.ancillaryObjects.clear();
        subtitleService.displayDefinition = null;
        subtitleService.pageComposition = null;
    }
}
