package androidx.media3.extractor.text.cea;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda1;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.VorbisBitArray;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.websocket.ControlFramesKt;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.Dispatcher$promoteAndExecute$Effects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Cea708Decoder extends CeaDecoder {
    public final CueInfoBuilder[] cueInfoBuilders;
    public List cues;
    public CueInfoBuilder currentCueInfoBuilder;
    public VorbisBitArray currentDtvCcPacket;
    public int currentWindow;
    public List lastCues;
    public final int selectedServiceNumber;
    public final ParsableByteArray ccData = new ParsableByteArray();
    public final VorbisBitArray captionChannelPacketData = new VorbisBitArray();
    public int previousSequenceNumber = -1;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Cea708CueInfo {
        public static final LayoutNode$$ExternalSyntheticLambda1 LEAST_IMPORTANT_FIRST = new LayoutNode$$ExternalSyntheticLambda1((byte) 20);
        public final Cue cue;
        public final int priority;

        public Cea708CueInfo(SpannableStringBuilder spannableStringBuilder, Layout.Alignment alignment, float f, int i, float f2, int i2, boolean z, int i3, int i4) {
            this.cue = new Cue(spannableStringBuilder, alignment, null, null, f, 0, i, f2, i2, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, z, z ? i3 : -16777216, Integer.MIN_VALUE, CropImageView.DEFAULT_ASPECT_RATIO, 0);
            this.priority = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CueInfoBuilder {
        public static final int COLOR_SOLID_BLACK;
        public static final int COLOR_SOLID_WHITE = getArgbColorFromCeaColor(2, 2, 2, 0);
        public static final int[] PEN_STYLE_BACKGROUND;
        public static final int[] PEN_STYLE_EDGE_TYPE;
        public static final int[] PEN_STYLE_FONT_STYLE;
        public static final int[] WINDOW_STYLE_FILL;
        public static final int[] WINDOW_STYLE_JUSTIFICATION;
        public static final int[] WINDOW_STYLE_PRINT_DIRECTION;
        public static final int[] WINDOW_STYLE_SCROLL_DIRECTION;
        public static final boolean[] WINDOW_STYLE_WORD_WRAP;
        public int anchorId;
        public int backgroundColor;
        public int backgroundColorStartPosition;
        public boolean defined;
        public int foregroundColor;
        public int foregroundColorStartPosition;
        public int horizontalAnchor;
        public int italicsStartPosition;
        public int justification;
        public int penStyleId;
        public int priority;
        public boolean relativePositioning;
        public int row;
        public int rowCount;
        public int underlineStartPosition;
        public int verticalAnchor;
        public boolean visible;
        public int windowFillColor;
        public int windowStyleId;
        public final ArrayList rolledUpCaptions = new ArrayList();
        public final SpannableStringBuilder captionStringBuilder = new SpannableStringBuilder();

        static {
            int argbColorFromCeaColor = getArgbColorFromCeaColor(0, 0, 0, 0);
            COLOR_SOLID_BLACK = argbColorFromCeaColor;
            int argbColorFromCeaColor2 = getArgbColorFromCeaColor(0, 0, 0, 3);
            WINDOW_STYLE_JUSTIFICATION = new int[]{0, 0, 0, 0, 0, 2, 0};
            WINDOW_STYLE_PRINT_DIRECTION = new int[]{0, 0, 0, 0, 0, 0, 2};
            WINDOW_STYLE_SCROLL_DIRECTION = new int[]{3, 3, 3, 3, 3, 3, 1};
            WINDOW_STYLE_WORD_WRAP = new boolean[]{false, false, false, true, true, true, false};
            WINDOW_STYLE_FILL = new int[]{argbColorFromCeaColor, argbColorFromCeaColor2, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor2, argbColorFromCeaColor, argbColorFromCeaColor};
            PEN_STYLE_FONT_STYLE = new int[]{0, 1, 2, 3, 4, 3, 4};
            PEN_STYLE_EDGE_TYPE = new int[]{0, 0, 0, 0, 0, 3, 3};
            PEN_STYLE_BACKGROUND = new int[]{argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor2, argbColorFromCeaColor2};
        }

        public CueInfoBuilder() {
            reset();
        }

        /* JADX WARN: Code duplicated, block: B:9:0x001b  */
        public static int getArgbColorFromCeaColor(int i, int i2, int i3, int i4) {
            int i5;
            UtilsKt.checkElementIndex(i, 4);
            UtilsKt.checkElementIndex(i2, 4);
            UtilsKt.checkElementIndex(i3, 4);
            UtilsKt.checkElementIndex(i4, 4);
            if (i4 == 0 || i4 == 1) {
                i5 = 255;
            } else if (i4 == 2) {
                i5 = 127;
            } else if (i4 != 3) {
                i5 = 255;
            } else {
                i5 = 0;
            }
            return Color.argb(i5, i > 1 ? 255 : 0, i2 > 1 ? 255 : 0, i3 > 1 ? 255 : 0);
        }

        public final void append(char c) {
            SpannableStringBuilder spannableStringBuilder = this.captionStringBuilder;
            if (c != '\n') {
                spannableStringBuilder.append(c);
                return;
            }
            SpannableString spannableStringBuildSpannableString = buildSpannableString();
            ArrayList arrayList = this.rolledUpCaptions;
            arrayList.add(spannableStringBuildSpannableString);
            spannableStringBuilder.clear();
            if (this.italicsStartPosition != -1) {
                this.italicsStartPosition = 0;
            }
            if (this.underlineStartPosition != -1) {
                this.underlineStartPosition = 0;
            }
            if (this.foregroundColorStartPosition != -1) {
                this.foregroundColorStartPosition = 0;
            }
            if (this.backgroundColorStartPosition != -1) {
                this.backgroundColorStartPosition = 0;
            }
            while (true) {
                if (arrayList.size() < this.rowCount && arrayList.size() < 15) {
                    this.row = arrayList.size();
                    return;
                }
                arrayList.remove(0);
            }
        }

        public final SpannableString buildSpannableString() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.captionStringBuilder);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.italicsStartPosition != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.italicsStartPosition, length, 33);
                }
                if (this.underlineStartPosition != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, length, 33);
                }
                if (this.foregroundColorStartPosition != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, length, 33);
                }
                if (this.backgroundColorStartPosition != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public final void reset() {
            this.rolledUpCaptions.clear();
            this.captionStringBuilder.clear();
            this.italicsStartPosition = -1;
            this.underlineStartPosition = -1;
            this.foregroundColorStartPosition = -1;
            this.backgroundColorStartPosition = -1;
            this.row = 0;
            this.defined = false;
            this.visible = false;
            this.priority = 4;
            this.relativePositioning = false;
            this.verticalAnchor = 0;
            this.horizontalAnchor = 0;
            this.anchorId = 0;
            this.rowCount = 15;
            this.justification = 0;
            this.windowStyleId = 0;
            this.penStyleId = 0;
            int i = COLOR_SOLID_BLACK;
            this.windowFillColor = i;
            this.foregroundColor = COLOR_SOLID_WHITE;
            this.backgroundColor = i;
        }

        public final void setPenAttributes(boolean z, boolean z2) {
            int i = this.italicsStartPosition;
            SpannableStringBuilder spannableStringBuilder = this.captionStringBuilder;
            if (i != -1) {
                if (!z) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.italicsStartPosition, spannableStringBuilder.length(), 33);
                    this.italicsStartPosition = -1;
                }
            } else if (z) {
                this.italicsStartPosition = spannableStringBuilder.length();
            }
            if (this.underlineStartPosition == -1) {
                if (z2) {
                    this.underlineStartPosition = spannableStringBuilder.length();
                }
            } else {
                if (z2) {
                    return;
                }
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, spannableStringBuilder.length(), 33);
                this.underlineStartPosition = -1;
            }
        }

        public final void setPenColor(int i, int i2) {
            int i3 = this.foregroundColorStartPosition;
            SpannableStringBuilder spannableStringBuilder = this.captionStringBuilder;
            if (i3 != -1 && this.foregroundColor != i) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, spannableStringBuilder.length(), 33);
            }
            if (i != COLOR_SOLID_WHITE) {
                this.foregroundColorStartPosition = spannableStringBuilder.length();
                this.foregroundColor = i;
            }
            if (this.backgroundColorStartPosition != -1 && this.backgroundColor != i2) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, spannableStringBuilder.length(), 33);
            }
            if (i2 != COLOR_SOLID_BLACK) {
                this.backgroundColorStartPosition = spannableStringBuilder.length();
                this.backgroundColor = i2;
            }
        }
    }

    public Cea708Decoder(int i, List list) {
        this.selectedServiceNumber = i == -1 ? 1 : i;
        if (list != null) {
            byte[] bArr = CodecSpecificDataUtil.NAL_START_CODE;
            if (list.size() == 1 && ((byte[]) list.get(0)).length == 1) {
                byte b = ((byte[]) list.get(0))[0];
            }
        }
        this.cueInfoBuilders = new CueInfoBuilder[8];
        int i2 = 0;
        while (true) {
            CueInfoBuilder[] cueInfoBuilderArr = this.cueInfoBuilders;
            if (i2 >= 8) {
                this.currentCueInfoBuilder = cueInfoBuilderArr[0];
                return;
            } else {
                cueInfoBuilderArr[i2] = new CueInfoBuilder();
                i2++;
            }
        }
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    public final Dispatcher$promoteAndExecute$Effects createSubtitle() {
        List list = this.cues;
        this.lastCues = list;
        list.getClass();
        return new Dispatcher$promoteAndExecute$Effects(list);
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    public final void decode(CeaDecoder.CeaInputBuffer ceaInputBuffer) {
        VorbisBitArray vorbisBitArray;
        ByteBuffer byteBuffer = ceaInputBuffer.data;
        byteBuffer.getClass();
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        ParsableByteArray parsableByteArray = this.ccData;
        parsableByteArray.reset(bArrArray, iLimit);
        while (parsableByteArray.bytesLeft() >= 3) {
            int unsignedByte = parsableByteArray.readUnsignedByte();
            int i = unsignedByte & 3;
            boolean z = (unsignedByte & 4) == 4;
            byte unsignedByte2 = (byte) parsableByteArray.readUnsignedByte();
            byte unsignedByte3 = (byte) parsableByteArray.readUnsignedByte();
            if (i == 2 || i == 3) {
                if (z) {
                    if (i == 3) {
                        finalizeCurrentPacket();
                        int i2 = (unsignedByte2 & 192) >> 6;
                        int i3 = this.previousSequenceNumber;
                        if (i3 != -1 && i2 != (i3 + 1) % 4) {
                            resetCueBuilders$1();
                            Log.w("Cea708Decoder", "Sequence number discontinuity. previous=" + this.previousSequenceNumber + " current=" + i2);
                        }
                        this.previousSequenceNumber = i2;
                        int i4 = unsignedByte2 & 63;
                        if (i4 == 0) {
                            i4 = 64;
                        }
                        vorbisBitArray = new VorbisBitArray(i2, i4);
                        this.currentDtvCcPacket = vorbisBitArray;
                        byte[] bArr = vorbisBitArray.data;
                        vorbisBitArray.bitOffset = 1;
                        bArr[0] = unsignedByte3;
                    } else {
                        UtilsKt.checkArgument(i == 2);
                        vorbisBitArray = this.currentDtvCcPacket;
                        if (vorbisBitArray == null) {
                            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = vorbisBitArray.data;
                            int i5 = vorbisBitArray.bitOffset;
                            int i6 = i5 + 1;
                            vorbisBitArray.bitOffset = i6;
                            bArr2[i5] = unsignedByte2;
                            vorbisBitArray.bitOffset = i5 + 2;
                            bArr2[i6] = unsignedByte3;
                        }
                    }
                    if (vorbisBitArray.bitOffset == (vorbisBitArray.byteOffset * 2) - 1) {
                        finalizeCurrentPacket();
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:228:0x053d  */
    public final void finalizeCurrentPacket() {
        char c;
        boolean z;
        VorbisBitArray vorbisBitArray = this.currentDtvCcPacket;
        if (vorbisBitArray == null) {
            return;
        }
        int i = 2;
        if (vorbisBitArray.bitOffset != (vorbisBitArray.byteOffset * 2) - 1) {
            Log.d("DtvCcPacket ended prematurely; size is " + ((this.currentDtvCcPacket.byteOffset * 2) - 1) + ", but current index is " + this.currentDtvCcPacket.bitOffset + " (sequence number " + this.currentDtvCcPacket.byteLimit + ");");
        }
        VorbisBitArray vorbisBitArray2 = this.currentDtvCcPacket;
        byte[] bArr = vorbisBitArray2.data;
        int i2 = vorbisBitArray2.bitOffset;
        VorbisBitArray vorbisBitArray3 = this.captionChannelPacketData;
        vorbisBitArray3.reset(bArr, i2);
        boolean z2 = false;
        while (vorbisBitArray3.bitsLeft() > 0) {
            int i3 = 3;
            int bits = vorbisBitArray3.readBits(3);
            int bits2 = vorbisBitArray3.readBits(5);
            if (bits == 7) {
                vorbisBitArray3.skipBits(i);
                bits = vorbisBitArray3.readBits(6);
                if (bits < 7) {
                    Format$$ExternalSyntheticOutline0.m(bits, "Invalid extended service number: ", "Cea708Decoder");
                }
            }
            if (bits2 == 0) {
                if (bits != 0) {
                    Log.w("Cea708Decoder", "serviceNumber is non-zero (" + bits + ") when blockSize is 0");
                }
                if (z2) {
                    this.cues = getDisplayCues$1();
                }
                this.currentDtvCcPacket = null;
            }
            if (bits != this.selectedServiceNumber) {
                vorbisBitArray3.skipBytes(bits2);
            } else {
                int position = (bits2 * 8) + vorbisBitArray3.getPosition();
                while (vorbisBitArray3.getPosition() < position) {
                    int bits3 = vorbisBitArray3.readBits(8);
                    if (bits3 != 16) {
                        if (bits3 <= 31) {
                            if (bits3 != 0) {
                                if (bits3 == i3) {
                                    this.cues = getDisplayCues$1();
                                } else if (bits3 != 8) {
                                    switch (bits3) {
                                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                                            resetCueBuilders$1();
                                            break;
                                        case 13:
                                            this.currentCueInfoBuilder.append('\n');
                                            break;
                                        case 14:
                                            break;
                                        default:
                                            if (bits3 >= 17 && bits3 <= 23) {
                                                Log.w("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + bits3);
                                                vorbisBitArray3.skipBits(8);
                                            } else if (bits3 < 24 || bits3 > 31) {
                                                Format$$ExternalSyntheticOutline0.m(bits3, "Invalid C0 command: ", "Cea708Decoder");
                                            } else {
                                                Log.w("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + bits3);
                                                vorbisBitArray3.skipBits(16);
                                            }
                                            break;
                                    }
                                } else {
                                    SpannableStringBuilder spannableStringBuilder = this.currentCueInfoBuilder.captionStringBuilder;
                                    int length = spannableStringBuilder.length();
                                    if (length > 0) {
                                        spannableStringBuilder.delete(length - 1, length);
                                    }
                                }
                            }
                        } else if (bits3 <= 127) {
                            CueInfoBuilder cueInfoBuilder = this.currentCueInfoBuilder;
                            if (bits3 == 127) {
                                cueInfoBuilder.append((char) 9835);
                            } else {
                                cueInfoBuilder.append((char) (bits3 & 255));
                            }
                            z2 = true;
                        } else {
                            if (bits3 <= 159) {
                                CueInfoBuilder[] cueInfoBuilderArr = this.cueInfoBuilders;
                                switch (bits3) {
                                    case 128:
                                    case 129:
                                    case 130:
                                    case 131:
                                    case 132:
                                    case 133:
                                    case 134:
                                    case 135:
                                        z = true;
                                        int i4 = bits3 - 128;
                                        if (this.currentWindow != i4) {
                                            this.currentWindow = i4;
                                            this.currentCueInfoBuilder = cueInfoBuilderArr[i4];
                                        }
                                        break;
                                    case 136:
                                        z = true;
                                        for (int i5 = 1; i5 <= 8; i5++) {
                                            if (vorbisBitArray3.readBit()) {
                                                CueInfoBuilder cueInfoBuilder2 = cueInfoBuilderArr[8 - i5];
                                                cueInfoBuilder2.rolledUpCaptions.clear();
                                                cueInfoBuilder2.captionStringBuilder.clear();
                                                cueInfoBuilder2.italicsStartPosition = -1;
                                                cueInfoBuilder2.underlineStartPosition = -1;
                                                cueInfoBuilder2.foregroundColorStartPosition = -1;
                                                cueInfoBuilder2.backgroundColorStartPosition = -1;
                                                cueInfoBuilder2.row = 0;
                                            }
                                        }
                                        break;
                                    case 137:
                                        for (int i6 = 1; i6 <= 8; i6++) {
                                            if (vorbisBitArray3.readBit()) {
                                                cueInfoBuilderArr[8 - i6].visible = true;
                                            }
                                        }
                                        z = true;
                                        break;
                                    case 138:
                                        for (int i7 = 1; i7 <= 8; i7++) {
                                            if (vorbisBitArray3.readBit()) {
                                                cueInfoBuilderArr[8 - i7].visible = false;
                                            }
                                        }
                                        z = true;
                                        break;
                                    case 139:
                                        for (int i8 = 1; i8 <= 8; i8++) {
                                            if (vorbisBitArray3.readBit()) {
                                                CueInfoBuilder cueInfoBuilder3 = cueInfoBuilderArr[8 - i8];
                                                cueInfoBuilder3.visible = !cueInfoBuilder3.visible;
                                            }
                                        }
                                        z = true;
                                        break;
                                    case 140:
                                        for (int i9 = 1; i9 <= 8; i9++) {
                                            if (vorbisBitArray3.readBit()) {
                                                cueInfoBuilderArr[8 - i9].reset();
                                            }
                                        }
                                        z = true;
                                        break;
                                    case 141:
                                        vorbisBitArray3.skipBits(8);
                                        z = true;
                                        break;
                                    case 142:
                                        z = true;
                                        break;
                                    case 143:
                                        resetCueBuilders$1();
                                        z = true;
                                        break;
                                    case 144:
                                        int i10 = i;
                                        if (this.currentCueInfoBuilder.defined) {
                                            vorbisBitArray3.readBits(4);
                                            vorbisBitArray3.readBits(i10);
                                            vorbisBitArray3.readBits(i10);
                                            boolean bit = vorbisBitArray3.readBit();
                                            boolean bit2 = vorbisBitArray3.readBit();
                                            i3 = 3;
                                            vorbisBitArray3.readBits(3);
                                            vorbisBitArray3.readBits(3);
                                            this.currentCueInfoBuilder.setPenAttributes(bit, bit2);
                                            z = true;
                                        } else {
                                            vorbisBitArray3.skipBits(16);
                                            z = true;
                                            i3 = 3;
                                        }
                                        break;
                                    case 145:
                                        if (this.currentCueInfoBuilder.defined) {
                                            int argbColorFromCeaColor = CueInfoBuilder.getArgbColorFromCeaColor(vorbisBitArray3.readBits(2), vorbisBitArray3.readBits(2), vorbisBitArray3.readBits(2), vorbisBitArray3.readBits(2));
                                            int argbColorFromCeaColor2 = CueInfoBuilder.getArgbColorFromCeaColor(vorbisBitArray3.readBits(2), vorbisBitArray3.readBits(2), vorbisBitArray3.readBits(2), vorbisBitArray3.readBits(2));
                                            vorbisBitArray3.skipBits(2);
                                            CueInfoBuilder.getArgbColorFromCeaColor(vorbisBitArray3.readBits(2), vorbisBitArray3.readBits(2), vorbisBitArray3.readBits(2), 0);
                                            this.currentCueInfoBuilder.setPenColor(argbColorFromCeaColor, argbColorFromCeaColor2);
                                        } else {
                                            vorbisBitArray3.skipBits(24);
                                        }
                                        z = true;
                                        i3 = 3;
                                        break;
                                    case 146:
                                        if (this.currentCueInfoBuilder.defined) {
                                            vorbisBitArray3.skipBits(4);
                                            int bits4 = vorbisBitArray3.readBits(4);
                                            vorbisBitArray3.skipBits(2);
                                            vorbisBitArray3.readBits(6);
                                            CueInfoBuilder cueInfoBuilder4 = this.currentCueInfoBuilder;
                                            if (cueInfoBuilder4.row != bits4) {
                                                cueInfoBuilder4.append('\n');
                                            }
                                            cueInfoBuilder4.row = bits4;
                                        } else {
                                            vorbisBitArray3.skipBits(16);
                                        }
                                        z = true;
                                        i3 = 3;
                                        break;
                                    case 147:
                                    case 148:
                                    case 149:
                                    case 150:
                                    default:
                                        Format$$ExternalSyntheticOutline0.m(bits3, "Invalid C1 command: ", "Cea708Decoder");
                                        z = true;
                                        break;
                                    case 151:
                                        if (this.currentCueInfoBuilder.defined) {
                                            int argbColorFromCeaColor3 = CueInfoBuilder.getArgbColorFromCeaColor(vorbisBitArray3.readBits(2), vorbisBitArray3.readBits(2), vorbisBitArray3.readBits(2), vorbisBitArray3.readBits(2));
                                            vorbisBitArray3.readBits(2);
                                            CueInfoBuilder.getArgbColorFromCeaColor(vorbisBitArray3.readBits(2), vorbisBitArray3.readBits(2), vorbisBitArray3.readBits(2), 0);
                                            vorbisBitArray3.readBit();
                                            vorbisBitArray3.readBit();
                                            vorbisBitArray3.readBits(2);
                                            vorbisBitArray3.readBits(2);
                                            int bits5 = vorbisBitArray3.readBits(2);
                                            vorbisBitArray3.skipBits(8);
                                            CueInfoBuilder cueInfoBuilder5 = this.currentCueInfoBuilder;
                                            cueInfoBuilder5.windowFillColor = argbColorFromCeaColor3;
                                            cueInfoBuilder5.justification = bits5;
                                        } else {
                                            vorbisBitArray3.skipBits(32);
                                        }
                                        z = true;
                                        i3 = 3;
                                        break;
                                    case 152:
                                    case 153:
                                    case 154:
                                    case 155:
                                    case 156:
                                    case 157:
                                    case 158:
                                    case 159:
                                        int i11 = bits3 - 152;
                                        CueInfoBuilder cueInfoBuilder6 = cueInfoBuilderArr[i11];
                                        vorbisBitArray3.skipBits(i);
                                        boolean bit3 = vorbisBitArray3.readBit();
                                        vorbisBitArray3.skipBits(i);
                                        int bits6 = vorbisBitArray3.readBits(i3);
                                        boolean bit4 = vorbisBitArray3.readBit();
                                        int bits7 = vorbisBitArray3.readBits(7);
                                        int bits8 = vorbisBitArray3.readBits(8);
                                        int bits9 = vorbisBitArray3.readBits(4);
                                        int bits10 = vorbisBitArray3.readBits(4);
                                        vorbisBitArray3.skipBits(i);
                                        vorbisBitArray3.skipBits(6);
                                        vorbisBitArray3.skipBits(i);
                                        int bits11 = vorbisBitArray3.readBits(3);
                                        int bits12 = vorbisBitArray3.readBits(3);
                                        ArrayList arrayList = cueInfoBuilder6.rolledUpCaptions;
                                        cueInfoBuilder6.defined = true;
                                        cueInfoBuilder6.visible = bit3;
                                        cueInfoBuilder6.priority = bits6;
                                        cueInfoBuilder6.relativePositioning = bit4;
                                        cueInfoBuilder6.verticalAnchor = bits7;
                                        cueInfoBuilder6.horizontalAnchor = bits8;
                                        cueInfoBuilder6.anchorId = bits9;
                                        int i12 = bits10 + 1;
                                        if (cueInfoBuilder6.rowCount != i12) {
                                            cueInfoBuilder6.rowCount = i12;
                                            while (true) {
                                                if (arrayList.size() >= cueInfoBuilder6.rowCount || arrayList.size() >= 15) {
                                                    arrayList.remove(0);
                                                }
                                            }
                                        }
                                        if (bits11 != 0 && cueInfoBuilder6.windowStyleId != bits11) {
                                            cueInfoBuilder6.windowStyleId = bits11;
                                            int i13 = bits11 - 1;
                                            int i14 = CueInfoBuilder.WINDOW_STYLE_FILL[i13];
                                            boolean z3 = CueInfoBuilder.WINDOW_STYLE_WORD_WRAP[i13];
                                            int i15 = CueInfoBuilder.WINDOW_STYLE_PRINT_DIRECTION[i13];
                                            int i16 = CueInfoBuilder.WINDOW_STYLE_SCROLL_DIRECTION[i13];
                                            int i17 = CueInfoBuilder.WINDOW_STYLE_JUSTIFICATION[i13];
                                            cueInfoBuilder6.windowFillColor = i14;
                                            cueInfoBuilder6.justification = i17;
                                        }
                                        if (bits12 != 0 && cueInfoBuilder6.penStyleId != bits12) {
                                            cueInfoBuilder6.penStyleId = bits12;
                                            int i18 = bits12 - 1;
                                            int i19 = CueInfoBuilder.PEN_STYLE_EDGE_TYPE[i18];
                                            int i20 = CueInfoBuilder.PEN_STYLE_FONT_STYLE[i18];
                                            cueInfoBuilder6.setPenAttributes(false, false);
                                            cueInfoBuilder6.setPenColor(CueInfoBuilder.COLOR_SOLID_WHITE, CueInfoBuilder.PEN_STYLE_BACKGROUND[i18]);
                                        }
                                        if (this.currentWindow != i11) {
                                            this.currentWindow = i11;
                                            this.currentCueInfoBuilder = cueInfoBuilderArr[i11];
                                        }
                                        z = true;
                                        i3 = 3;
                                        break;
                                }
                            } else {
                                z = true;
                                if (bits3 <= 255) {
                                    this.currentCueInfoBuilder.append((char) (bits3 & 255));
                                } else {
                                    Format$$ExternalSyntheticOutline0.m(bits3, "Invalid base command: ", "Cea708Decoder");
                                }
                                i = 2;
                                c = 7;
                            }
                            z2 = z;
                            i = 2;
                            c = 7;
                        }
                        c = 7;
                    } else {
                        int bits13 = vorbisBitArray3.readBits(8);
                        if (bits13 <= 31) {
                            c = 7;
                            if (bits13 > 7) {
                                if (bits13 <= 15) {
                                    vorbisBitArray3.skipBits(8);
                                } else if (bits13 <= 23) {
                                    vorbisBitArray3.skipBits(16);
                                } else if (bits13 <= 31) {
                                    vorbisBitArray3.skipBits(24);
                                }
                            }
                        } else {
                            c = 7;
                            if (bits13 <= 127) {
                                if (bits13 == 32) {
                                    this.currentCueInfoBuilder.append(' ');
                                } else if (bits13 == 33) {
                                    this.currentCueInfoBuilder.append((char) 160);
                                } else if (bits13 == 37) {
                                    this.currentCueInfoBuilder.append((char) 8230);
                                } else if (bits13 == 42) {
                                    this.currentCueInfoBuilder.append((char) 352);
                                } else if (bits13 == 44) {
                                    this.currentCueInfoBuilder.append((char) 338);
                                } else if (bits13 == 63) {
                                    this.currentCueInfoBuilder.append((char) 376);
                                } else if (bits13 == 57) {
                                    this.currentCueInfoBuilder.append((char) 8482);
                                } else if (bits13 == 58) {
                                    this.currentCueInfoBuilder.append((char) 353);
                                } else if (bits13 == 60) {
                                    this.currentCueInfoBuilder.append((char) 339);
                                } else if (bits13 != 61) {
                                    switch (bits13) {
                                        case 48:
                                            this.currentCueInfoBuilder.append((char) 9608);
                                            break;
                                        case 49:
                                            this.currentCueInfoBuilder.append((char) 8216);
                                            break;
                                        case 50:
                                            this.currentCueInfoBuilder.append((char) 8217);
                                            break;
                                        case 51:
                                            this.currentCueInfoBuilder.append((char) 8220);
                                            break;
                                        case 52:
                                            this.currentCueInfoBuilder.append((char) 8221);
                                            break;
                                        case 53:
                                            this.currentCueInfoBuilder.append((char) 8226);
                                            break;
                                        default:
                                            switch (bits13) {
                                                case 118:
                                                    this.currentCueInfoBuilder.append((char) 8539);
                                                    break;
                                                case 119:
                                                    this.currentCueInfoBuilder.append((char) 8540);
                                                    break;
                                                case 120:
                                                    this.currentCueInfoBuilder.append((char) 8541);
                                                    break;
                                                case 121:
                                                    this.currentCueInfoBuilder.append((char) 8542);
                                                    break;
                                                case 122:
                                                    this.currentCueInfoBuilder.append((char) 9474);
                                                    break;
                                                case ControlFramesKt.MAX_CLOSE_REASON_MESSAGE_SIZE /* 123 */:
                                                    this.currentCueInfoBuilder.append((char) 9488);
                                                    break;
                                                case 124:
                                                    this.currentCueInfoBuilder.append((char) 9492);
                                                    break;
                                                case ControlFramesKt.MAX_CONTROL_FRAME_PAYLOAD_SIZE /* 125 */:
                                                    this.currentCueInfoBuilder.append((char) 9472);
                                                    break;
                                                case 126:
                                                    this.currentCueInfoBuilder.append((char) 9496);
                                                    break;
                                                case 127:
                                                    this.currentCueInfoBuilder.append((char) 9484);
                                                    break;
                                                default:
                                                    Format$$ExternalSyntheticOutline0.m(bits13, "Invalid G2 character: ", "Cea708Decoder");
                                                    break;
                                            }
                                            break;
                                    }
                                } else {
                                    this.currentCueInfoBuilder.append((char) 8480);
                                }
                                i = 2;
                                z2 = true;
                            } else if (bits13 > 159) {
                                i = 2;
                                if (bits13 <= 255) {
                                    if (bits13 == 160) {
                                        this.currentCueInfoBuilder.append((char) 13252);
                                    } else {
                                        Format$$ExternalSyntheticOutline0.m(bits13, "Invalid G3 character: ", "Cea708Decoder");
                                        this.currentCueInfoBuilder.append('_');
                                    }
                                    z2 = true;
                                } else {
                                    Format$$ExternalSyntheticOutline0.m(bits13, "Invalid extended command: ", "Cea708Decoder");
                                }
                            } else if (bits13 <= 135) {
                                vorbisBitArray3.skipBits(32);
                            } else if (bits13 <= 143) {
                                vorbisBitArray3.skipBits(40);
                            } else if (bits13 <= 159) {
                                i = 2;
                                vorbisBitArray3.skipBits(2);
                                vorbisBitArray3.skipBits(vorbisBitArray3.readBits(6) * 8);
                            }
                        }
                        i = 2;
                    }
                    i = i;
                }
            }
        }
        if (z2) {
            this.cues = getDisplayCues$1();
        }
        this.currentDtvCcPacket = null;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.decoder.Decoder
    public final void flush() {
        super.flush();
        this.cues = null;
        this.lastCues = null;
        this.currentWindow = 0;
        this.currentCueInfoBuilder = this.cueInfoBuilders[0];
        resetCueBuilders$1();
        this.currentDtvCcPacket = null;
    }

    public final List getDisplayCues$1() {
        Cea708CueInfo cea708CueInfo;
        Layout.Alignment alignment;
        float f;
        float f2;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            CueInfoBuilder[] cueInfoBuilderArr = this.cueInfoBuilders;
            CueInfoBuilder cueInfoBuilder = cueInfoBuilderArr[i];
            if (cueInfoBuilder.defined && (!cueInfoBuilder.rolledUpCaptions.isEmpty() || cueInfoBuilder.captionStringBuilder.length() != 0)) {
                CueInfoBuilder cueInfoBuilder2 = cueInfoBuilderArr[i];
                if (cueInfoBuilder2.visible) {
                    ArrayList arrayList2 = cueInfoBuilder2.rolledUpCaptions;
                    if (!cueInfoBuilder2.defined || (arrayList2.isEmpty() && cueInfoBuilder2.captionStringBuilder.length() == 0)) {
                        cea708CueInfo = null;
                    } else {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                            spannableStringBuilder.append((CharSequence) arrayList2.get(i2));
                            spannableStringBuilder.append('\n');
                        }
                        spannableStringBuilder.append((CharSequence) cueInfoBuilder2.buildSpannableString());
                        int i3 = cueInfoBuilder2.justification;
                        if (i3 == 0) {
                            alignment = Layout.Alignment.ALIGN_NORMAL;
                        } else if (i3 == 1) {
                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                        } else if (i3 != 2) {
                            if (i3 != 3) {
                                throw new IllegalArgumentException("Unexpected justification value: " + cueInfoBuilder2.justification);
                            }
                            alignment = Layout.Alignment.ALIGN_NORMAL;
                        } else {
                            alignment = Layout.Alignment.ALIGN_CENTER;
                        }
                        Layout.Alignment alignment2 = alignment;
                        boolean z = cueInfoBuilder2.relativePositioning;
                        int i4 = cueInfoBuilder2.horizontalAnchor;
                        int i5 = cueInfoBuilder2.verticalAnchor;
                        if (z) {
                            f = i4 / 99.0f;
                            f2 = i5 / 99.0f;
                        } else {
                            f = i4 / 209.0f;
                            f2 = i5 / 74.0f;
                        }
                        float f3 = (f * 0.9f) + 0.05f;
                        float f4 = (f2 * 0.9f) + 0.05f;
                        int i6 = cueInfoBuilder2.anchorId;
                        int i7 = i6 / 3;
                        int i8 = i7 == 0 ? 0 : i7 == 1 ? 1 : 2;
                        int i9 = i6 % 3;
                        int i10 = i9 == 0 ? 0 : i9 == 1 ? 1 : 2;
                        int i11 = cueInfoBuilder2.windowFillColor;
                        cea708CueInfo = new Cea708CueInfo(spannableStringBuilder, alignment2, f4, i8, f3, i10, i11 != CueInfoBuilder.COLOR_SOLID_BLACK, i11, cueInfoBuilder2.priority);
                    }
                    if (cea708CueInfo != null) {
                        arrayList.add(cea708CueInfo);
                    }
                } else {
                    continue;
                }
            }
        }
        Collections.sort(arrayList, Cea708CueInfo.LEAST_IMPORTANT_FIRST);
        ArrayList arrayList3 = new ArrayList(arrayList.size());
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            arrayList3.add(((Cea708CueInfo) arrayList.get(i12)).cue);
        }
        return Collections.unmodifiableList(arrayList3);
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    public final boolean isNewSubtitleDataAvailable() {
        return this.cues != this.lastCues;
    }

    public final void resetCueBuilders$1() {
        for (int i = 0; i < 8; i++) {
            this.cueInfoBuilders[i].reset();
        }
    }
}
