package androidx.media3.extractor.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.text.SimpleSubtitleDecoder$1;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.websocket.ControlFramesKt;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.Dispatcher$promoteAndExecute$Effects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Cea608Decoder extends CeaDecoder {
    public byte captionMode;
    public byte captionRowCount;
    public List cues;
    public boolean isCaptionValid;
    public boolean isInCaptionService;
    public long lastCueUpdateUs;
    public List lastCues;
    public final int packetLength;
    public byte repeatableControlCc1;
    public byte repeatableControlCc2;
    public boolean repeatableControlSet;
    public final boolean selectedChannel;
    public final boolean selectedField;
    public static final int[] ROW_INDICES = {11, 1, 3, 12, 14, 5, 7, 9};
    public static final int[] COLUMN_INDICES = {0, 4, 8, 12, 16, 20, 24, 28};
    public static final int[] STYLE_COLORS = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    public static final int[] BASIC_CHARACTER_SET = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    public static final int[] SPECIAL_CHARACTER_SET = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    public static final int[] SPECIAL_ES_FR_CHARACTER_SET = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    public static final int[] SPECIAL_PT_DE_CHARACTER_SET = {195, 227, 205, 204, 236, 210, 242, 213, 245, ControlFramesKt.MAX_CLOSE_REASON_MESSAGE_SIZE, ControlFramesKt.MAX_CONTROL_FRAME_PAYLOAD_SIZE, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    public static final boolean[] ODD_PARITY_BYTE_TABLE = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    public final ParsableByteArray ccData = new ParsableByteArray();
    public final ArrayList cueBuilders = new ArrayList();
    public CueBuilder currentCueBuilder = new CueBuilder(0, 4);
    public int currentChannel = 0;
    public final long validDataChannelTimeoutUs = 16000000;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CueBuilder {
        public byte captionMode;
        public byte captionRowCount;
        public final StringBuilder captionStringBuilder;
        public final ArrayList cueStyles;
        public int indent;
        public final ArrayList rolledUpCaptions;
        public int row;
        public int tabOffset;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class CueStyle {
            public int start;
            public final int style;
            public final boolean underline;

            public CueStyle(int i, boolean z, int i2) {
                this.style = i;
                this.underline = z;
                this.start = i2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CueBuilder(int i, int i2) {
            ArrayList arrayList = new ArrayList();
            this.cueStyles = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.rolledUpCaptions = arrayList2;
            StringBuilder sb = new StringBuilder();
            this.captionStringBuilder = sb;
            this.captionMode = i;
            arrayList.clear();
            arrayList2.clear();
            sb.setLength(0);
            this.row = 15;
            this.indent = 0;
            this.tabOffset = 0;
            this.captionRowCount = i2;
        }

        public final void append(char c) {
            StringBuilder sb = this.captionStringBuilder;
            if (sb.length() < 32) {
                sb.append(c);
            }
        }

        public final void backspace() {
            StringBuilder sb = this.captionStringBuilder;
            int length = sb.length();
            if (length > 0) {
                sb.delete(length - 1, length);
                ArrayList arrayList = this.cueStyles;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    CueStyle cueStyle = (CueStyle) arrayList.get(size);
                    int i = cueStyle.start;
                    if (i != length) {
                        return;
                    }
                    cueStyle.start = i - 1;
                }
            }
        }

        public final Cue build(int i) {
            float f;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int i2 = 0;
            while (true) {
                ArrayList arrayList = this.rolledUpCaptions;
                if (i2 >= arrayList.size()) {
                    break;
                }
                spannableStringBuilder.append((CharSequence) arrayList.get(i2));
                spannableStringBuilder.append('\n');
                i2++;
            }
            spannableStringBuilder.append((CharSequence) buildCurrentLine());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i3 = this.indent + this.tabOffset;
            int length = (32 - i3) - spannableStringBuilder.length();
            int i4 = i3 - length;
            int i5 = i;
            if (i5 == Integer.MIN_VALUE) {
                if (this.captionMode != 2 || (Math.abs(i4) >= 3 && length >= 0)) {
                    i5 = (this.captionMode != 2 || i4 <= 0) ? 0 : 2;
                } else {
                    i5 = 1;
                }
            }
            if (i5 != 1) {
                if (i5 == 2) {
                    i3 = 32 - length;
                }
                f = ((i3 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f = 0.5f;
            }
            int i6 = this.row;
            if (i6 > 7) {
                i6 -= 17;
            } else if (this.captionMode == 1) {
                i6 -= this.captionRowCount - 1;
            }
            return new Cue(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, null, null, i6, 1, Integer.MIN_VALUE, f, i5, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, CropImageView.DEFAULT_ASPECT_RATIO, 0);
        }

        public final SpannableString buildCurrentLine() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.captionStringBuilder);
            int length = spannableStringBuilder.length();
            int i = -1;
            int i2 = -1;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            int i6 = 0;
            boolean z = false;
            while (true) {
                ArrayList arrayList = this.cueStyles;
                if (i5 >= arrayList.size()) {
                    break;
                }
                CueStyle cueStyle = (CueStyle) arrayList.get(i5);
                boolean z2 = cueStyle.underline;
                int i7 = cueStyle.style;
                if (i7 != 8) {
                    boolean z3 = i7 == 7;
                    if (i7 != 7) {
                        i4 = Cea608Decoder.STYLE_COLORS[i7];
                    }
                    z = z3;
                }
                int i8 = cueStyle.start;
                i5++;
                if (i8 != (i5 < arrayList.size() ? ((CueStyle) arrayList.get(i5)).start : length)) {
                    if (i != -1 && !z2) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), i, i8, 33);
                        i = -1;
                    } else if (i == -1 && z2) {
                        i = i8;
                    }
                    if (i2 != -1 && !z) {
                        spannableStringBuilder.setSpan(new StyleSpan(2), i2, i8, 33);
                        i2 = -1;
                    } else if (i2 == -1 && z) {
                        i2 = i8;
                    }
                    if (i4 != i3) {
                        if (i3 != -1) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i6, i8, 33);
                        }
                        i3 = i4;
                        i6 = i8;
                    }
                }
            }
            if (i != -1 && i != length) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
            }
            if (i2 != -1 && i2 != length) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i2, length, 33);
            }
            if (i6 != length && i3 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i6, length, 33);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public final boolean isEmpty() {
            return this.cueStyles.isEmpty() && this.rolledUpCaptions.isEmpty() && this.captionStringBuilder.length() == 0;
        }
    }

    public Cea608Decoder(String str, int i) {
        this.packetLength = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i == 1) {
            this.selectedChannel = false;
            this.selectedField = false;
        } else if (i == 2) {
            this.selectedChannel = true;
            this.selectedField = false;
        } else if (i == 3) {
            this.selectedChannel = false;
            this.selectedField = true;
        } else if (i != 4) {
            Log.w("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.selectedChannel = false;
            this.selectedField = false;
        } else {
            this.selectedChannel = true;
            this.selectedField = true;
        }
        setCaptionMode(0);
        resetCueBuilders();
        this.isInCaptionService = true;
        this.lastCueUpdateUs = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    public final Dispatcher$promoteAndExecute$Effects createSubtitle() {
        List list = this.cues;
        this.lastCues = list;
        list.getClass();
        return new Dispatcher$promoteAndExecute$Effects(list);
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0198  */
    /* JADX WARN: Code duplicated, block: B:123:0x019e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:127:0x01ac A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:128:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:131:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:133:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:134:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:137:0x01c1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:138:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:140:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:141:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:142:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:143:0x01da  */
    /* JADX WARN: Code duplicated, block: B:148:0x0205 A[LOOP:1: B:146:0x01ff->B:148:0x0205, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:149:0x0209  */
    /* JADX WARN: Code duplicated, block: B:151:0x020f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:152:0x0211  */
    /* JADX WARN: Code duplicated, block: B:153:0x0216  */
    /* JADX WARN: Code duplicated, block: B:154:0x021d  */
    /* JADX WARN: Code duplicated, block: B:155:0x0228  */
    /* JADX WARN: Code duplicated, block: B:156:0x0233  */
    /* JADX WARN: Code duplicated, block: B:157:0x023e  */
    /* JADX WARN: Code duplicated, block: B:158:0x0243  */
    /* JADX WARN: Code duplicated, block: B:159:0x0248  */
    /* JADX WARN: Code duplicated, block: B:161:0x0259  */
    /* JADX WARN: Code duplicated, block: B:179:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x007e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x0014 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x0014 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x0014 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0059  */
    /* JADX WARN: Code duplicated, block: B:49:0x0092  */
    /* JADX WARN: Code duplicated, block: B:51:0x0096  */
    /* JADX WARN: Code duplicated, block: B:52:0x0098  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a6 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:64:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:75:0x00de  */
    /* JADX WARN: Code duplicated, block: B:83:0x0100 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x0102  */
    /* JADX WARN: Code duplicated, block: B:91:0x012a  */
    /* JADX WARN: Code duplicated, block: B:93:0x012e  */
    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    public final void decode(CeaDecoder.CeaInputBuffer ceaInputBuffer) {
        boolean z;
        int i;
        int[] iArr;
        int i2;
        int i3;
        byte b;
        ArrayList arrayList;
        int iMin;
        ByteBuffer byteBuffer = ceaInputBuffer.data;
        byteBuffer.getClass();
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        ParsableByteArray parsableByteArray = this.ccData;
        parsableByteArray.reset(bArrArray, iLimit);
        boolean z2 = false;
        while (true) {
            int iBytesLeft = parsableByteArray.bytesLeft();
            int i4 = this.packetLength;
            if (iBytesLeft < i4) {
                if (z2) {
                    byte b2 = this.captionMode;
                    if (b2 == 1 || b2 == 3) {
                        this.cues = getDisplayCues();
                        this.lastCueUpdateUs = this.playbackPositionUs;
                        return;
                    }
                    return;
                }
                return;
            }
            int unsignedByte = i4 == 2 ? -4 : parsableByteArray.readUnsignedByte();
            int unsignedByte2 = parsableByteArray.readUnsignedByte();
            int unsignedByte3 = parsableByteArray.readUnsignedByte();
            if ((unsignedByte & 2) == 0 && (unsignedByte & 1) == this.selectedField) {
                byte b3 = (byte) (unsignedByte2 & 127);
                byte b4 = (byte) (unsignedByte3 & 127);
                if (b3 != 0 || b4 != 0) {
                    boolean z3 = this.isCaptionValid;
                    if ((unsignedByte & 4) == 4) {
                        boolean[] zArr = ODD_PARITY_BYTE_TABLE;
                        if (zArr[unsignedByte2] && zArr[unsignedByte3]) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    this.isCaptionValid = z;
                    if (!z || (b3 & 240) != 16) {
                        this.repeatableControlSet = false;
                        if (!z) {
                            if (1 > b3 && b3 <= 15) {
                                this.isInCaptionService = false;
                            } else if ((b3 & 246) == 20) {
                                if (b4 == 32 && b4 != 47) {
                                    switch (b4) {
                                        default:
                                            switch (b4) {
                                                case 42:
                                                case 43:
                                                    this.isInCaptionService = false;
                                                    break;
                                            }
                                        case 37:
                                        case 38:
                                        case 39:
                                            this.isInCaptionService = true;
                                            break;
                                    }
                                } else {
                                    this.isInCaptionService = true;
                                }
                            }
                            if (this.isInCaptionService) {
                                i = b3 & 224;
                                if (i == 0) {
                                    this.currentChannel = (b3 >> 3) & 1;
                                }
                                if (this.currentChannel != this.selectedChannel) {
                                    if (i == 0) {
                                        i2 = b3 & 247;
                                        if (i2 == 17 || (b4 & 240) != 48) {
                                            i3 = b3 & 246;
                                            if (i3 != 18 && (b4 & 224) == 32) {
                                                this.currentCueBuilder.backspace();
                                                this.currentCueBuilder.append((char) ((b3 & 1) == 0 ? SPECIAL_ES_FR_CHARACTER_SET[b4 & 31] : SPECIAL_PT_DE_CHARACTER_SET[b4 & 31]));
                                            } else if (i2 != 17 && (b4 & 240) == 32) {
                                                this.currentCueBuilder.append(' ');
                                                boolean z4 = (b4 & 1) == 1;
                                                CueBuilder cueBuilder = this.currentCueBuilder;
                                                cueBuilder.cueStyles.add(new CueBuilder.CueStyle((b4 >> 1) & 7, z4, cueBuilder.captionStringBuilder.length()));
                                            } else if ((b3 & 240) != 16 && (b4 & 192) == 64) {
                                                int i5 = ROW_INDICES[b3 & 7];
                                                if ((b4 & 32) != 0) {
                                                    i5++;
                                                }
                                                CueBuilder cueBuilder2 = this.currentCueBuilder;
                                                if (i5 != cueBuilder2.row) {
                                                    if (this.captionMode != 1 && !cueBuilder2.isEmpty()) {
                                                        CueBuilder cueBuilder3 = new CueBuilder(this.captionMode, this.captionRowCount);
                                                        this.currentCueBuilder = cueBuilder3;
                                                        this.cueBuilders.add(cueBuilder3);
                                                    }
                                                    cueBuilder2 = this.currentCueBuilder;
                                                    cueBuilder2.row = i5;
                                                }
                                                boolean z5 = (b4 & 16) == 16;
                                                int i6 = (b4 >> 1) & 7;
                                                cueBuilder2.cueStyles.add(new CueBuilder.CueStyle(z5 ? 8 : i6, (b4 & 1) == 1, cueBuilder2.captionStringBuilder.length()));
                                                if (z5) {
                                                    this.currentCueBuilder.indent = COLUMN_INDICES[i6];
                                                }
                                            } else if (i2 != 23 && b4 >= 33 && b4 <= 35) {
                                                this.currentCueBuilder.tabOffset = b4 - 32;
                                            } else if (i3 == 20 && (b4 & 240) == 32) {
                                                if (b4 == 32) {
                                                    setCaptionMode(2);
                                                } else if (b4 != 41) {
                                                    switch (b4) {
                                                        case 37:
                                                            setCaptionMode(1);
                                                            this.captionRowCount = (byte) 2;
                                                            this.currentCueBuilder.captionRowCount = (byte) 2;
                                                            break;
                                                        case 38:
                                                            setCaptionMode(1);
                                                            this.captionRowCount = (byte) 3;
                                                            this.currentCueBuilder.captionRowCount = (byte) 3;
                                                            break;
                                                        case 39:
                                                            setCaptionMode(1);
                                                            this.captionRowCount = (byte) 4;
                                                            this.currentCueBuilder.captionRowCount = (byte) 4;
                                                            break;
                                                        default:
                                                            b = this.captionMode;
                                                            if (b != 0) {
                                                                if (b4 != 33) {
                                                                    switch (b4) {
                                                                        case 44:
                                                                            this.cues = Collections.EMPTY_LIST;
                                                                            if (b != 1 || b == 3) {
                                                                                resetCueBuilders();
                                                                            }
                                                                            break;
                                                                        case 45:
                                                                            if (b == 1 && !this.currentCueBuilder.isEmpty()) {
                                                                                CueBuilder cueBuilder4 = this.currentCueBuilder;
                                                                                arrayList = cueBuilder4.rolledUpCaptions;
                                                                                arrayList.add(cueBuilder4.buildCurrentLine());
                                                                                cueBuilder4.captionStringBuilder.setLength(0);
                                                                                cueBuilder4.cueStyles.clear();
                                                                                iMin = Math.min((int) cueBuilder4.captionRowCount, cueBuilder4.row);
                                                                                while (arrayList.size() >= iMin) {
                                                                                    arrayList.remove(0);
                                                                                }
                                                                            }
                                                                            break;
                                                                        case 46:
                                                                            resetCueBuilders();
                                                                            break;
                                                                        case 47:
                                                                            this.cues = getDisplayCues();
                                                                            resetCueBuilders();
                                                                            break;
                                                                    }
                                                                } else {
                                                                    this.currentCueBuilder.backspace();
                                                                    break;
                                                                }
                                                            }
                                                            break;
                                                    }
                                                } else {
                                                    setCaptionMode(3);
                                                }
                                            }
                                        } else {
                                            this.currentCueBuilder.append((char) SPECIAL_CHARACTER_SET[b4 & 15]);
                                        }
                                    } else {
                                        CueBuilder cueBuilder5 = this.currentCueBuilder;
                                        iArr = BASIC_CHARACTER_SET;
                                        cueBuilder5.append((char) iArr[(b3 & 127) - 32]);
                                        if ((b4 & 224) != 0) {
                                            this.currentCueBuilder.append((char) iArr[(b4 & 127) - 32]);
                                        }
                                    }
                                    z2 = true;
                                }
                            }
                        } else if (z3) {
                            resetCueBuilders();
                            z2 = true;
                        }
                    } else if (this.repeatableControlSet && this.repeatableControlCc1 == b3 && this.repeatableControlCc2 == b4) {
                        this.repeatableControlSet = false;
                    } else {
                        this.repeatableControlSet = true;
                        this.repeatableControlCc1 = b3;
                        this.repeatableControlCc2 = b4;
                        if (!z) {
                            if (1 > b3) {
                                if ((b3 & 246) == 20) {
                                    if (b4 == 32) {
                                        this.isInCaptionService = true;
                                    } else {
                                        this.isInCaptionService = true;
                                    }
                                }
                            } else if ((b3 & 246) == 20) {
                                if (b4 == 32) {
                                    this.isInCaptionService = true;
                                } else {
                                    this.isInCaptionService = true;
                                }
                            }
                            if (this.isInCaptionService) {
                                i = b3 & 224;
                                if (i == 0) {
                                    this.currentChannel = (b3 >> 3) & 1;
                                }
                                if (this.currentChannel != this.selectedChannel) {
                                    if (i == 0) {
                                        i2 = b3 & 247;
                                        if (i2 == 17) {
                                            i3 = b3 & 246;
                                            if (i3 != 18) {
                                                if (i2 != 17) {
                                                    if ((b3 & 240) != 16) {
                                                        if (i2 != 23) {
                                                            if (i3 == 20) {
                                                                if (b4 == 32) {
                                                                    setCaptionMode(2);
                                                                } else if (b4 != 41) {
                                                                    switch (b4) {
                                                                        case 37:
                                                                            setCaptionMode(1);
                                                                            this.captionRowCount = (byte) 2;
                                                                            this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                            break;
                                                                        case 38:
                                                                            setCaptionMode(1);
                                                                            this.captionRowCount = (byte) 3;
                                                                            this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                            break;
                                                                        case 39:
                                                                            setCaptionMode(1);
                                                                            this.captionRowCount = (byte) 4;
                                                                            this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                            break;
                                                                        default:
                                                                            b = this.captionMode;
                                                                            if (b != 0) {
                                                                                if (b4 != 33) {
                                                                                    switch (b4) {
                                                                                        case 44:
                                                                                            this.cues = Collections.EMPTY_LIST;
                                                                                            if (b != 1) {
                                                                                                resetCueBuilders();
                                                                                            } else {
                                                                                                resetCueBuilders();
                                                                                            }
                                                                                            break;
                                                                                        case 45:
                                                                                            if (b == 1) {
                                                                                                CueBuilder cueBuilder6 = this.currentCueBuilder;
                                                                                                arrayList = cueBuilder6.rolledUpCaptions;
                                                                                                arrayList.add(cueBuilder6.buildCurrentLine());
                                                                                                cueBuilder6.captionStringBuilder.setLength(0);
                                                                                                cueBuilder6.cueStyles.clear();
                                                                                                iMin = Math.min((int) cueBuilder6.captionRowCount, cueBuilder6.row);
                                                                                                while (arrayList.size() >= iMin) {
                                                                                                    arrayList.remove(0);
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                        case 46:
                                                                                            resetCueBuilders();
                                                                                            break;
                                                                                        case 47:
                                                                                            this.cues = getDisplayCues();
                                                                                            resetCueBuilders();
                                                                                            break;
                                                                                    }
                                                                                } else {
                                                                                    this.currentCueBuilder.backspace();
                                                                                    break;
                                                                                }
                                                                            }
                                                                            break;
                                                                    }
                                                                } else {
                                                                    setCaptionMode(3);
                                                                }
                                                            }
                                                        } else if (i3 == 20) {
                                                            if (b4 == 32) {
                                                                setCaptionMode(2);
                                                            } else if (b4 != 41) {
                                                                switch (b4) {
                                                                    case 37:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 2;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                        break;
                                                                    case 38:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 3;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                        break;
                                                                    case 39:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 4;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                        break;
                                                                    default:
                                                                        b = this.captionMode;
                                                                        if (b != 0) {
                                                                            if (b4 != 33) {
                                                                                switch (b4) {
                                                                                    case 44:
                                                                                        this.cues = Collections.EMPTY_LIST;
                                                                                        if (b != 1) {
                                                                                            resetCueBuilders();
                                                                                        } else {
                                                                                            resetCueBuilders();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (b == 1) {
                                                                                            CueBuilder cueBuilder7 = this.currentCueBuilder;
                                                                                            arrayList = cueBuilder7.rolledUpCaptions;
                                                                                            arrayList.add(cueBuilder7.buildCurrentLine());
                                                                                            cueBuilder7.captionStringBuilder.setLength(0);
                                                                                            cueBuilder7.cueStyles.clear();
                                                                                            iMin = Math.min((int) cueBuilder7.captionRowCount, cueBuilder7.row);
                                                                                            while (arrayList.size() >= iMin) {
                                                                                                arrayList.remove(0);
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        resetCueBuilders();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.cues = getDisplayCues();
                                                                                        resetCueBuilders();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.currentCueBuilder.backspace();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                setCaptionMode(3);
                                                            }
                                                        }
                                                    } else if (i2 != 23) {
                                                        if (i3 == 20) {
                                                            if (b4 == 32) {
                                                                setCaptionMode(2);
                                                            } else if (b4 != 41) {
                                                                switch (b4) {
                                                                    case 37:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 2;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                        break;
                                                                    case 38:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 3;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                        break;
                                                                    case 39:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 4;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                        break;
                                                                    default:
                                                                        b = this.captionMode;
                                                                        if (b != 0) {
                                                                            if (b4 != 33) {
                                                                                switch (b4) {
                                                                                    case 44:
                                                                                        this.cues = Collections.EMPTY_LIST;
                                                                                        if (b != 1) {
                                                                                            resetCueBuilders();
                                                                                        } else {
                                                                                            resetCueBuilders();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (b == 1) {
                                                                                            CueBuilder cueBuilder8 = this.currentCueBuilder;
                                                                                            arrayList = cueBuilder8.rolledUpCaptions;
                                                                                            arrayList.add(cueBuilder8.buildCurrentLine());
                                                                                            cueBuilder8.captionStringBuilder.setLength(0);
                                                                                            cueBuilder8.cueStyles.clear();
                                                                                            iMin = Math.min((int) cueBuilder8.captionRowCount, cueBuilder8.row);
                                                                                            while (arrayList.size() >= iMin) {
                                                                                                arrayList.remove(0);
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        resetCueBuilders();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.cues = getDisplayCues();
                                                                                        resetCueBuilders();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.currentCueBuilder.backspace();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                setCaptionMode(3);
                                                            }
                                                        }
                                                    } else if (i3 == 20) {
                                                        if (b4 == 32) {
                                                            setCaptionMode(2);
                                                        } else if (b4 != 41) {
                                                            switch (b4) {
                                                                case 37:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 2;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                    break;
                                                                case 38:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 3;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                    break;
                                                                case 39:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 4;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                    break;
                                                                default:
                                                                    b = this.captionMode;
                                                                    if (b != 0) {
                                                                        if (b4 != 33) {
                                                                            switch (b4) {
                                                                                case 44:
                                                                                    this.cues = Collections.EMPTY_LIST;
                                                                                    if (b != 1) {
                                                                                        resetCueBuilders();
                                                                                    } else {
                                                                                        resetCueBuilders();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (b == 1) {
                                                                                        CueBuilder cueBuilder9 = this.currentCueBuilder;
                                                                                        arrayList = cueBuilder9.rolledUpCaptions;
                                                                                        arrayList.add(cueBuilder9.buildCurrentLine());
                                                                                        cueBuilder9.captionStringBuilder.setLength(0);
                                                                                        cueBuilder9.cueStyles.clear();
                                                                                        iMin = Math.min((int) cueBuilder9.captionRowCount, cueBuilder9.row);
                                                                                        while (arrayList.size() >= iMin) {
                                                                                            arrayList.remove(0);
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                                case 47:
                                                                                    this.cues = getDisplayCues();
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.currentCueBuilder.backspace();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            setCaptionMode(3);
                                                        }
                                                    }
                                                } else if ((b3 & 240) != 16) {
                                                    if (i2 != 23) {
                                                        if (i3 == 20) {
                                                            if (b4 == 32) {
                                                                setCaptionMode(2);
                                                            } else if (b4 != 41) {
                                                                switch (b4) {
                                                                    case 37:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 2;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                        break;
                                                                    case 38:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 3;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                        break;
                                                                    case 39:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 4;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                        break;
                                                                    default:
                                                                        b = this.captionMode;
                                                                        if (b != 0) {
                                                                            if (b4 != 33) {
                                                                                switch (b4) {
                                                                                    case 44:
                                                                                        this.cues = Collections.EMPTY_LIST;
                                                                                        if (b != 1) {
                                                                                            resetCueBuilders();
                                                                                        } else {
                                                                                            resetCueBuilders();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (b == 1) {
                                                                                            CueBuilder cueBuilder10 = this.currentCueBuilder;
                                                                                            arrayList = cueBuilder10.rolledUpCaptions;
                                                                                            arrayList.add(cueBuilder10.buildCurrentLine());
                                                                                            cueBuilder10.captionStringBuilder.setLength(0);
                                                                                            cueBuilder10.cueStyles.clear();
                                                                                            iMin = Math.min((int) cueBuilder10.captionRowCount, cueBuilder10.row);
                                                                                            while (arrayList.size() >= iMin) {
                                                                                                arrayList.remove(0);
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        resetCueBuilders();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.cues = getDisplayCues();
                                                                                        resetCueBuilders();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.currentCueBuilder.backspace();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                setCaptionMode(3);
                                                            }
                                                        }
                                                    } else if (i3 == 20) {
                                                        if (b4 == 32) {
                                                            setCaptionMode(2);
                                                        } else if (b4 != 41) {
                                                            switch (b4) {
                                                                case 37:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 2;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                    break;
                                                                case 38:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 3;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                    break;
                                                                case 39:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 4;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                    break;
                                                                default:
                                                                    b = this.captionMode;
                                                                    if (b != 0) {
                                                                        if (b4 != 33) {
                                                                            switch (b4) {
                                                                                case 44:
                                                                                    this.cues = Collections.EMPTY_LIST;
                                                                                    if (b != 1) {
                                                                                        resetCueBuilders();
                                                                                    } else {
                                                                                        resetCueBuilders();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (b == 1) {
                                                                                        CueBuilder cueBuilder11 = this.currentCueBuilder;
                                                                                        arrayList = cueBuilder11.rolledUpCaptions;
                                                                                        arrayList.add(cueBuilder11.buildCurrentLine());
                                                                                        cueBuilder11.captionStringBuilder.setLength(0);
                                                                                        cueBuilder11.cueStyles.clear();
                                                                                        iMin = Math.min((int) cueBuilder11.captionRowCount, cueBuilder11.row);
                                                                                        while (arrayList.size() >= iMin) {
                                                                                            arrayList.remove(0);
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                                case 47:
                                                                                    this.cues = getDisplayCues();
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.currentCueBuilder.backspace();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            setCaptionMode(3);
                                                        }
                                                    }
                                                } else if (i2 != 23) {
                                                    if (i3 == 20) {
                                                        if (b4 == 32) {
                                                            setCaptionMode(2);
                                                        } else if (b4 != 41) {
                                                            switch (b4) {
                                                                case 37:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 2;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                    break;
                                                                case 38:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 3;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                    break;
                                                                case 39:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 4;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                    break;
                                                                default:
                                                                    b = this.captionMode;
                                                                    if (b != 0) {
                                                                        if (b4 != 33) {
                                                                            switch (b4) {
                                                                                case 44:
                                                                                    this.cues = Collections.EMPTY_LIST;
                                                                                    if (b != 1) {
                                                                                        resetCueBuilders();
                                                                                    } else {
                                                                                        resetCueBuilders();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (b == 1) {
                                                                                        CueBuilder cueBuilder12 = this.currentCueBuilder;
                                                                                        arrayList = cueBuilder12.rolledUpCaptions;
                                                                                        arrayList.add(cueBuilder12.buildCurrentLine());
                                                                                        cueBuilder12.captionStringBuilder.setLength(0);
                                                                                        cueBuilder12.cueStyles.clear();
                                                                                        iMin = Math.min((int) cueBuilder12.captionRowCount, cueBuilder12.row);
                                                                                        while (arrayList.size() >= iMin) {
                                                                                            arrayList.remove(0);
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                                case 47:
                                                                                    this.cues = getDisplayCues();
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.currentCueBuilder.backspace();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            setCaptionMode(3);
                                                        }
                                                    }
                                                } else if (i3 == 20) {
                                                    if (b4 == 32) {
                                                        setCaptionMode(2);
                                                    } else if (b4 != 41) {
                                                        switch (b4) {
                                                            case 37:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 2;
                                                                this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                break;
                                                            case 38:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 3;
                                                                this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                break;
                                                            case 39:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 4;
                                                                this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                break;
                                                            default:
                                                                b = this.captionMode;
                                                                if (b != 0) {
                                                                    if (b4 != 33) {
                                                                        switch (b4) {
                                                                            case 44:
                                                                                this.cues = Collections.EMPTY_LIST;
                                                                                if (b != 1) {
                                                                                    resetCueBuilders();
                                                                                } else {
                                                                                    resetCueBuilders();
                                                                                }
                                                                                break;
                                                                            case 45:
                                                                                if (b == 1) {
                                                                                    CueBuilder cueBuilder13 = this.currentCueBuilder;
                                                                                    arrayList = cueBuilder13.rolledUpCaptions;
                                                                                    arrayList.add(cueBuilder13.buildCurrentLine());
                                                                                    cueBuilder13.captionStringBuilder.setLength(0);
                                                                                    cueBuilder13.cueStyles.clear();
                                                                                    iMin = Math.min((int) cueBuilder13.captionRowCount, cueBuilder13.row);
                                                                                    while (arrayList.size() >= iMin) {
                                                                                        arrayList.remove(0);
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 46:
                                                                                resetCueBuilders();
                                                                                break;
                                                                            case 47:
                                                                                this.cues = getDisplayCues();
                                                                                resetCueBuilders();
                                                                                break;
                                                                        }
                                                                    } else {
                                                                        this.currentCueBuilder.backspace();
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        setCaptionMode(3);
                                                    }
                                                }
                                            } else if (i2 != 17) {
                                                if ((b3 & 240) != 16) {
                                                    if (i2 != 23) {
                                                        if (i3 == 20) {
                                                            if (b4 == 32) {
                                                                setCaptionMode(2);
                                                            } else if (b4 != 41) {
                                                                switch (b4) {
                                                                    case 37:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 2;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                        break;
                                                                    case 38:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 3;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                        break;
                                                                    case 39:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 4;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                        break;
                                                                    default:
                                                                        b = this.captionMode;
                                                                        if (b != 0) {
                                                                            if (b4 != 33) {
                                                                                switch (b4) {
                                                                                    case 44:
                                                                                        this.cues = Collections.EMPTY_LIST;
                                                                                        if (b != 1) {
                                                                                            resetCueBuilders();
                                                                                        } else {
                                                                                            resetCueBuilders();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (b == 1) {
                                                                                            CueBuilder cueBuilder14 = this.currentCueBuilder;
                                                                                            arrayList = cueBuilder14.rolledUpCaptions;
                                                                                            arrayList.add(cueBuilder14.buildCurrentLine());
                                                                                            cueBuilder14.captionStringBuilder.setLength(0);
                                                                                            cueBuilder14.cueStyles.clear();
                                                                                            iMin = Math.min((int) cueBuilder14.captionRowCount, cueBuilder14.row);
                                                                                            while (arrayList.size() >= iMin) {
                                                                                                arrayList.remove(0);
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        resetCueBuilders();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.cues = getDisplayCues();
                                                                                        resetCueBuilders();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.currentCueBuilder.backspace();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                setCaptionMode(3);
                                                            }
                                                        }
                                                    } else if (i3 == 20) {
                                                        if (b4 == 32) {
                                                            setCaptionMode(2);
                                                        } else if (b4 != 41) {
                                                            switch (b4) {
                                                                case 37:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 2;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                    break;
                                                                case 38:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 3;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                    break;
                                                                case 39:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 4;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                    break;
                                                                default:
                                                                    b = this.captionMode;
                                                                    if (b != 0) {
                                                                        if (b4 != 33) {
                                                                            switch (b4) {
                                                                                case 44:
                                                                                    this.cues = Collections.EMPTY_LIST;
                                                                                    if (b != 1) {
                                                                                        resetCueBuilders();
                                                                                    } else {
                                                                                        resetCueBuilders();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (b == 1) {
                                                                                        CueBuilder cueBuilder15 = this.currentCueBuilder;
                                                                                        arrayList = cueBuilder15.rolledUpCaptions;
                                                                                        arrayList.add(cueBuilder15.buildCurrentLine());
                                                                                        cueBuilder15.captionStringBuilder.setLength(0);
                                                                                        cueBuilder15.cueStyles.clear();
                                                                                        iMin = Math.min((int) cueBuilder15.captionRowCount, cueBuilder15.row);
                                                                                        while (arrayList.size() >= iMin) {
                                                                                            arrayList.remove(0);
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                                case 47:
                                                                                    this.cues = getDisplayCues();
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.currentCueBuilder.backspace();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            setCaptionMode(3);
                                                        }
                                                    }
                                                } else if (i2 != 23) {
                                                    if (i3 == 20) {
                                                        if (b4 == 32) {
                                                            setCaptionMode(2);
                                                        } else if (b4 != 41) {
                                                            switch (b4) {
                                                                case 37:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 2;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                    break;
                                                                case 38:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 3;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                    break;
                                                                case 39:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 4;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                    break;
                                                                default:
                                                                    b = this.captionMode;
                                                                    if (b != 0) {
                                                                        if (b4 != 33) {
                                                                            switch (b4) {
                                                                                case 44:
                                                                                    this.cues = Collections.EMPTY_LIST;
                                                                                    if (b != 1) {
                                                                                        resetCueBuilders();
                                                                                    } else {
                                                                                        resetCueBuilders();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (b == 1) {
                                                                                        CueBuilder cueBuilder16 = this.currentCueBuilder;
                                                                                        arrayList = cueBuilder16.rolledUpCaptions;
                                                                                        arrayList.add(cueBuilder16.buildCurrentLine());
                                                                                        cueBuilder16.captionStringBuilder.setLength(0);
                                                                                        cueBuilder16.cueStyles.clear();
                                                                                        iMin = Math.min((int) cueBuilder16.captionRowCount, cueBuilder16.row);
                                                                                        while (arrayList.size() >= iMin) {
                                                                                            arrayList.remove(0);
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                                case 47:
                                                                                    this.cues = getDisplayCues();
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.currentCueBuilder.backspace();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            setCaptionMode(3);
                                                        }
                                                    }
                                                } else if (i3 == 20) {
                                                    if (b4 == 32) {
                                                        setCaptionMode(2);
                                                    } else if (b4 != 41) {
                                                        switch (b4) {
                                                            case 37:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 2;
                                                                this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                break;
                                                            case 38:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 3;
                                                                this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                break;
                                                            case 39:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 4;
                                                                this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                break;
                                                            default:
                                                                b = this.captionMode;
                                                                if (b != 0) {
                                                                    if (b4 != 33) {
                                                                        switch (b4) {
                                                                            case 44:
                                                                                this.cues = Collections.EMPTY_LIST;
                                                                                if (b != 1) {
                                                                                    resetCueBuilders();
                                                                                } else {
                                                                                    resetCueBuilders();
                                                                                }
                                                                                break;
                                                                            case 45:
                                                                                if (b == 1) {
                                                                                    CueBuilder cueBuilder17 = this.currentCueBuilder;
                                                                                    arrayList = cueBuilder17.rolledUpCaptions;
                                                                                    arrayList.add(cueBuilder17.buildCurrentLine());
                                                                                    cueBuilder17.captionStringBuilder.setLength(0);
                                                                                    cueBuilder17.cueStyles.clear();
                                                                                    iMin = Math.min((int) cueBuilder17.captionRowCount, cueBuilder17.row);
                                                                                    while (arrayList.size() >= iMin) {
                                                                                        arrayList.remove(0);
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 46:
                                                                                resetCueBuilders();
                                                                                break;
                                                                            case 47:
                                                                                this.cues = getDisplayCues();
                                                                                resetCueBuilders();
                                                                                break;
                                                                        }
                                                                    } else {
                                                                        this.currentCueBuilder.backspace();
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        setCaptionMode(3);
                                                    }
                                                }
                                            } else if ((b3 & 240) != 16) {
                                                if (i2 != 23) {
                                                    if (i3 == 20) {
                                                        if (b4 == 32) {
                                                            setCaptionMode(2);
                                                        } else if (b4 != 41) {
                                                            switch (b4) {
                                                                case 37:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 2;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                    break;
                                                                case 38:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 3;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                    break;
                                                                case 39:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 4;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                    break;
                                                                default:
                                                                    b = this.captionMode;
                                                                    if (b != 0) {
                                                                        if (b4 != 33) {
                                                                            switch (b4) {
                                                                                case 44:
                                                                                    this.cues = Collections.EMPTY_LIST;
                                                                                    if (b != 1) {
                                                                                        resetCueBuilders();
                                                                                    } else {
                                                                                        resetCueBuilders();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (b == 1) {
                                                                                        CueBuilder cueBuilder18 = this.currentCueBuilder;
                                                                                        arrayList = cueBuilder18.rolledUpCaptions;
                                                                                        arrayList.add(cueBuilder18.buildCurrentLine());
                                                                                        cueBuilder18.captionStringBuilder.setLength(0);
                                                                                        cueBuilder18.cueStyles.clear();
                                                                                        iMin = Math.min((int) cueBuilder18.captionRowCount, cueBuilder18.row);
                                                                                        while (arrayList.size() >= iMin) {
                                                                                            arrayList.remove(0);
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                                case 47:
                                                                                    this.cues = getDisplayCues();
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.currentCueBuilder.backspace();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            setCaptionMode(3);
                                                        }
                                                    }
                                                } else if (i3 == 20) {
                                                    if (b4 == 32) {
                                                        setCaptionMode(2);
                                                    } else if (b4 != 41) {
                                                        switch (b4) {
                                                            case 37:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 2;
                                                                this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                break;
                                                            case 38:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 3;
                                                                this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                break;
                                                            case 39:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 4;
                                                                this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                break;
                                                            default:
                                                                b = this.captionMode;
                                                                if (b != 0) {
                                                                    if (b4 != 33) {
                                                                        switch (b4) {
                                                                            case 44:
                                                                                this.cues = Collections.EMPTY_LIST;
                                                                                if (b != 1) {
                                                                                    resetCueBuilders();
                                                                                } else {
                                                                                    resetCueBuilders();
                                                                                }
                                                                                break;
                                                                            case 45:
                                                                                if (b == 1) {
                                                                                    CueBuilder cueBuilder19 = this.currentCueBuilder;
                                                                                    arrayList = cueBuilder19.rolledUpCaptions;
                                                                                    arrayList.add(cueBuilder19.buildCurrentLine());
                                                                                    cueBuilder19.captionStringBuilder.setLength(0);
                                                                                    cueBuilder19.cueStyles.clear();
                                                                                    iMin = Math.min((int) cueBuilder19.captionRowCount, cueBuilder19.row);
                                                                                    while (arrayList.size() >= iMin) {
                                                                                        arrayList.remove(0);
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 46:
                                                                                resetCueBuilders();
                                                                                break;
                                                                            case 47:
                                                                                this.cues = getDisplayCues();
                                                                                resetCueBuilders();
                                                                                break;
                                                                        }
                                                                    } else {
                                                                        this.currentCueBuilder.backspace();
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        setCaptionMode(3);
                                                    }
                                                }
                                            } else if (i2 != 23) {
                                                if (i3 == 20) {
                                                    if (b4 == 32) {
                                                        setCaptionMode(2);
                                                    } else if (b4 != 41) {
                                                        switch (b4) {
                                                            case 37:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 2;
                                                                this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                break;
                                                            case 38:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 3;
                                                                this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                break;
                                                            case 39:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 4;
                                                                this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                break;
                                                            default:
                                                                b = this.captionMode;
                                                                if (b != 0) {
                                                                    if (b4 != 33) {
                                                                        switch (b4) {
                                                                            case 44:
                                                                                this.cues = Collections.EMPTY_LIST;
                                                                                if (b != 1) {
                                                                                    resetCueBuilders();
                                                                                } else {
                                                                                    resetCueBuilders();
                                                                                }
                                                                                break;
                                                                            case 45:
                                                                                if (b == 1) {
                                                                                    CueBuilder cueBuilder110 = this.currentCueBuilder;
                                                                                    arrayList = cueBuilder110.rolledUpCaptions;
                                                                                    arrayList.add(cueBuilder110.buildCurrentLine());
                                                                                    cueBuilder110.captionStringBuilder.setLength(0);
                                                                                    cueBuilder110.cueStyles.clear();
                                                                                    iMin = Math.min((int) cueBuilder110.captionRowCount, cueBuilder110.row);
                                                                                    while (arrayList.size() >= iMin) {
                                                                                        arrayList.remove(0);
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 46:
                                                                                resetCueBuilders();
                                                                                break;
                                                                            case 47:
                                                                                this.cues = getDisplayCues();
                                                                                resetCueBuilders();
                                                                                break;
                                                                        }
                                                                    } else {
                                                                        this.currentCueBuilder.backspace();
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        setCaptionMode(3);
                                                    }
                                                }
                                            } else if (i3 == 20) {
                                                if (b4 == 32) {
                                                    setCaptionMode(2);
                                                } else if (b4 != 41) {
                                                    switch (b4) {
                                                        case 37:
                                                            setCaptionMode(1);
                                                            this.captionRowCount = (byte) 2;
                                                            this.currentCueBuilder.captionRowCount = (byte) 2;
                                                            break;
                                                        case 38:
                                                            setCaptionMode(1);
                                                            this.captionRowCount = (byte) 3;
                                                            this.currentCueBuilder.captionRowCount = (byte) 3;
                                                            break;
                                                        case 39:
                                                            setCaptionMode(1);
                                                            this.captionRowCount = (byte) 4;
                                                            this.currentCueBuilder.captionRowCount = (byte) 4;
                                                            break;
                                                        default:
                                                            b = this.captionMode;
                                                            if (b != 0) {
                                                                if (b4 != 33) {
                                                                    switch (b4) {
                                                                        case 44:
                                                                            this.cues = Collections.EMPTY_LIST;
                                                                            if (b != 1) {
                                                                                resetCueBuilders();
                                                                            } else {
                                                                                resetCueBuilders();
                                                                            }
                                                                            break;
                                                                        case 45:
                                                                            if (b == 1) {
                                                                                CueBuilder cueBuilder111 = this.currentCueBuilder;
                                                                                arrayList = cueBuilder111.rolledUpCaptions;
                                                                                arrayList.add(cueBuilder111.buildCurrentLine());
                                                                                cueBuilder111.captionStringBuilder.setLength(0);
                                                                                cueBuilder111.cueStyles.clear();
                                                                                iMin = Math.min((int) cueBuilder111.captionRowCount, cueBuilder111.row);
                                                                                while (arrayList.size() >= iMin) {
                                                                                    arrayList.remove(0);
                                                                                }
                                                                            }
                                                                            break;
                                                                        case 46:
                                                                            resetCueBuilders();
                                                                            break;
                                                                        case 47:
                                                                            this.cues = getDisplayCues();
                                                                            resetCueBuilders();
                                                                            break;
                                                                    }
                                                                } else {
                                                                    this.currentCueBuilder.backspace();
                                                                    break;
                                                                }
                                                            }
                                                            break;
                                                    }
                                                } else {
                                                    setCaptionMode(3);
                                                }
                                            }
                                        } else {
                                            i3 = b3 & 246;
                                            if (i3 != 18) {
                                                if (i2 != 17) {
                                                    if ((b3 & 240) != 16) {
                                                        if (i2 != 23) {
                                                            if (i3 == 20) {
                                                                if (b4 == 32) {
                                                                    setCaptionMode(2);
                                                                } else if (b4 != 41) {
                                                                    switch (b4) {
                                                                        case 37:
                                                                            setCaptionMode(1);
                                                                            this.captionRowCount = (byte) 2;
                                                                            this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                            break;
                                                                        case 38:
                                                                            setCaptionMode(1);
                                                                            this.captionRowCount = (byte) 3;
                                                                            this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                            break;
                                                                        case 39:
                                                                            setCaptionMode(1);
                                                                            this.captionRowCount = (byte) 4;
                                                                            this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                            break;
                                                                        default:
                                                                            b = this.captionMode;
                                                                            if (b != 0) {
                                                                                if (b4 != 33) {
                                                                                    switch (b4) {
                                                                                        case 44:
                                                                                            this.cues = Collections.EMPTY_LIST;
                                                                                            if (b != 1) {
                                                                                                resetCueBuilders();
                                                                                            } else {
                                                                                                resetCueBuilders();
                                                                                            }
                                                                                            break;
                                                                                        case 45:
                                                                                            if (b == 1) {
                                                                                                CueBuilder cueBuilder112 = this.currentCueBuilder;
                                                                                                arrayList = cueBuilder112.rolledUpCaptions;
                                                                                                arrayList.add(cueBuilder112.buildCurrentLine());
                                                                                                cueBuilder112.captionStringBuilder.setLength(0);
                                                                                                cueBuilder112.cueStyles.clear();
                                                                                                iMin = Math.min((int) cueBuilder112.captionRowCount, cueBuilder112.row);
                                                                                                while (arrayList.size() >= iMin) {
                                                                                                    arrayList.remove(0);
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                        case 46:
                                                                                            resetCueBuilders();
                                                                                            break;
                                                                                        case 47:
                                                                                            this.cues = getDisplayCues();
                                                                                            resetCueBuilders();
                                                                                            break;
                                                                                    }
                                                                                } else {
                                                                                    this.currentCueBuilder.backspace();
                                                                                    break;
                                                                                }
                                                                            }
                                                                            break;
                                                                    }
                                                                } else {
                                                                    setCaptionMode(3);
                                                                }
                                                            }
                                                        } else if (i3 == 20) {
                                                            if (b4 == 32) {
                                                                setCaptionMode(2);
                                                            } else if (b4 != 41) {
                                                                switch (b4) {
                                                                    case 37:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 2;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                        break;
                                                                    case 38:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 3;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                        break;
                                                                    case 39:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 4;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                        break;
                                                                    default:
                                                                        b = this.captionMode;
                                                                        if (b != 0) {
                                                                            if (b4 != 33) {
                                                                                switch (b4) {
                                                                                    case 44:
                                                                                        this.cues = Collections.EMPTY_LIST;
                                                                                        if (b != 1) {
                                                                                            resetCueBuilders();
                                                                                        } else {
                                                                                            resetCueBuilders();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (b == 1) {
                                                                                            CueBuilder cueBuilder113 = this.currentCueBuilder;
                                                                                            arrayList = cueBuilder113.rolledUpCaptions;
                                                                                            arrayList.add(cueBuilder113.buildCurrentLine());
                                                                                            cueBuilder113.captionStringBuilder.setLength(0);
                                                                                            cueBuilder113.cueStyles.clear();
                                                                                            iMin = Math.min((int) cueBuilder113.captionRowCount, cueBuilder113.row);
                                                                                            while (arrayList.size() >= iMin) {
                                                                                                arrayList.remove(0);
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        resetCueBuilders();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.cues = getDisplayCues();
                                                                                        resetCueBuilders();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.currentCueBuilder.backspace();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                setCaptionMode(3);
                                                            }
                                                        }
                                                    } else if (i2 != 23) {
                                                        if (i3 == 20) {
                                                            if (b4 == 32) {
                                                                setCaptionMode(2);
                                                            } else if (b4 != 41) {
                                                                switch (b4) {
                                                                    case 37:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 2;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                        break;
                                                                    case 38:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 3;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                        break;
                                                                    case 39:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 4;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                        break;
                                                                    default:
                                                                        b = this.captionMode;
                                                                        if (b != 0) {
                                                                            if (b4 != 33) {
                                                                                switch (b4) {
                                                                                    case 44:
                                                                                        this.cues = Collections.EMPTY_LIST;
                                                                                        if (b != 1) {
                                                                                            resetCueBuilders();
                                                                                        } else {
                                                                                            resetCueBuilders();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (b == 1) {
                                                                                            CueBuilder cueBuilder114 = this.currentCueBuilder;
                                                                                            arrayList = cueBuilder114.rolledUpCaptions;
                                                                                            arrayList.add(cueBuilder114.buildCurrentLine());
                                                                                            cueBuilder114.captionStringBuilder.setLength(0);
                                                                                            cueBuilder114.cueStyles.clear();
                                                                                            iMin = Math.min((int) cueBuilder114.captionRowCount, cueBuilder114.row);
                                                                                            while (arrayList.size() >= iMin) {
                                                                                                arrayList.remove(0);
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        resetCueBuilders();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.cues = getDisplayCues();
                                                                                        resetCueBuilders();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.currentCueBuilder.backspace();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                setCaptionMode(3);
                                                            }
                                                        }
                                                    } else if (i3 == 20) {
                                                        if (b4 == 32) {
                                                            setCaptionMode(2);
                                                        } else if (b4 != 41) {
                                                            switch (b4) {
                                                                case 37:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 2;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                    break;
                                                                case 38:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 3;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                    break;
                                                                case 39:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 4;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                    break;
                                                                default:
                                                                    b = this.captionMode;
                                                                    if (b != 0) {
                                                                        if (b4 != 33) {
                                                                            switch (b4) {
                                                                                case 44:
                                                                                    this.cues = Collections.EMPTY_LIST;
                                                                                    if (b != 1) {
                                                                                        resetCueBuilders();
                                                                                    } else {
                                                                                        resetCueBuilders();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (b == 1) {
                                                                                        CueBuilder cueBuilder115 = this.currentCueBuilder;
                                                                                        arrayList = cueBuilder115.rolledUpCaptions;
                                                                                        arrayList.add(cueBuilder115.buildCurrentLine());
                                                                                        cueBuilder115.captionStringBuilder.setLength(0);
                                                                                        cueBuilder115.cueStyles.clear();
                                                                                        iMin = Math.min((int) cueBuilder115.captionRowCount, cueBuilder115.row);
                                                                                        while (arrayList.size() >= iMin) {
                                                                                            arrayList.remove(0);
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                                case 47:
                                                                                    this.cues = getDisplayCues();
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.currentCueBuilder.backspace();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            setCaptionMode(3);
                                                        }
                                                    }
                                                } else if ((b3 & 240) != 16) {
                                                    if (i2 != 23) {
                                                        if (i3 == 20) {
                                                            if (b4 == 32) {
                                                                setCaptionMode(2);
                                                            } else if (b4 != 41) {
                                                                switch (b4) {
                                                                    case 37:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 2;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                        break;
                                                                    case 38:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 3;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                        break;
                                                                    case 39:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 4;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                        break;
                                                                    default:
                                                                        b = this.captionMode;
                                                                        if (b != 0) {
                                                                            if (b4 != 33) {
                                                                                switch (b4) {
                                                                                    case 44:
                                                                                        this.cues = Collections.EMPTY_LIST;
                                                                                        if (b != 1) {
                                                                                            resetCueBuilders();
                                                                                        } else {
                                                                                            resetCueBuilders();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (b == 1) {
                                                                                            CueBuilder cueBuilder116 = this.currentCueBuilder;
                                                                                            arrayList = cueBuilder116.rolledUpCaptions;
                                                                                            arrayList.add(cueBuilder116.buildCurrentLine());
                                                                                            cueBuilder116.captionStringBuilder.setLength(0);
                                                                                            cueBuilder116.cueStyles.clear();
                                                                                            iMin = Math.min((int) cueBuilder116.captionRowCount, cueBuilder116.row);
                                                                                            while (arrayList.size() >= iMin) {
                                                                                                arrayList.remove(0);
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        resetCueBuilders();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.cues = getDisplayCues();
                                                                                        resetCueBuilders();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.currentCueBuilder.backspace();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                setCaptionMode(3);
                                                            }
                                                        }
                                                    } else if (i3 == 20) {
                                                        if (b4 == 32) {
                                                            setCaptionMode(2);
                                                        } else if (b4 != 41) {
                                                            switch (b4) {
                                                                case 37:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 2;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                    break;
                                                                case 38:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 3;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                    break;
                                                                case 39:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 4;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                    break;
                                                                default:
                                                                    b = this.captionMode;
                                                                    if (b != 0) {
                                                                        if (b4 != 33) {
                                                                            switch (b4) {
                                                                                case 44:
                                                                                    this.cues = Collections.EMPTY_LIST;
                                                                                    if (b != 1) {
                                                                                        resetCueBuilders();
                                                                                    } else {
                                                                                        resetCueBuilders();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (b == 1) {
                                                                                        CueBuilder cueBuilder117 = this.currentCueBuilder;
                                                                                        arrayList = cueBuilder117.rolledUpCaptions;
                                                                                        arrayList.add(cueBuilder117.buildCurrentLine());
                                                                                        cueBuilder117.captionStringBuilder.setLength(0);
                                                                                        cueBuilder117.cueStyles.clear();
                                                                                        iMin = Math.min((int) cueBuilder117.captionRowCount, cueBuilder117.row);
                                                                                        while (arrayList.size() >= iMin) {
                                                                                            arrayList.remove(0);
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                                case 47:
                                                                                    this.cues = getDisplayCues();
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.currentCueBuilder.backspace();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            setCaptionMode(3);
                                                        }
                                                    }
                                                } else if (i2 != 23) {
                                                    if (i3 == 20) {
                                                        if (b4 == 32) {
                                                            setCaptionMode(2);
                                                        } else if (b4 != 41) {
                                                            switch (b4) {
                                                                case 37:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 2;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                    break;
                                                                case 38:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 3;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                    break;
                                                                case 39:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 4;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                    break;
                                                                default:
                                                                    b = this.captionMode;
                                                                    if (b != 0) {
                                                                        if (b4 != 33) {
                                                                            switch (b4) {
                                                                                case 44:
                                                                                    this.cues = Collections.EMPTY_LIST;
                                                                                    if (b != 1) {
                                                                                        resetCueBuilders();
                                                                                    } else {
                                                                                        resetCueBuilders();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (b == 1) {
                                                                                        CueBuilder cueBuilder118 = this.currentCueBuilder;
                                                                                        arrayList = cueBuilder118.rolledUpCaptions;
                                                                                        arrayList.add(cueBuilder118.buildCurrentLine());
                                                                                        cueBuilder118.captionStringBuilder.setLength(0);
                                                                                        cueBuilder118.cueStyles.clear();
                                                                                        iMin = Math.min((int) cueBuilder118.captionRowCount, cueBuilder118.row);
                                                                                        while (arrayList.size() >= iMin) {
                                                                                            arrayList.remove(0);
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                                case 47:
                                                                                    this.cues = getDisplayCues();
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.currentCueBuilder.backspace();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            setCaptionMode(3);
                                                        }
                                                    }
                                                } else if (i3 == 20) {
                                                    if (b4 == 32) {
                                                        setCaptionMode(2);
                                                    } else if (b4 != 41) {
                                                        switch (b4) {
                                                            case 37:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 2;
                                                                this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                break;
                                                            case 38:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 3;
                                                                this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                break;
                                                            case 39:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 4;
                                                                this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                break;
                                                            default:
                                                                b = this.captionMode;
                                                                if (b != 0) {
                                                                    if (b4 != 33) {
                                                                        switch (b4) {
                                                                            case 44:
                                                                                this.cues = Collections.EMPTY_LIST;
                                                                                if (b != 1) {
                                                                                    resetCueBuilders();
                                                                                } else {
                                                                                    resetCueBuilders();
                                                                                }
                                                                                break;
                                                                            case 45:
                                                                                if (b == 1) {
                                                                                    CueBuilder cueBuilder119 = this.currentCueBuilder;
                                                                                    arrayList = cueBuilder119.rolledUpCaptions;
                                                                                    arrayList.add(cueBuilder119.buildCurrentLine());
                                                                                    cueBuilder119.captionStringBuilder.setLength(0);
                                                                                    cueBuilder119.cueStyles.clear();
                                                                                    iMin = Math.min((int) cueBuilder119.captionRowCount, cueBuilder119.row);
                                                                                    while (arrayList.size() >= iMin) {
                                                                                        arrayList.remove(0);
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 46:
                                                                                resetCueBuilders();
                                                                                break;
                                                                            case 47:
                                                                                this.cues = getDisplayCues();
                                                                                resetCueBuilders();
                                                                                break;
                                                                        }
                                                                    } else {
                                                                        this.currentCueBuilder.backspace();
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        setCaptionMode(3);
                                                    }
                                                }
                                            } else if (i2 != 17) {
                                                if ((b3 & 240) != 16) {
                                                    if (i2 != 23) {
                                                        if (i3 == 20) {
                                                            if (b4 == 32) {
                                                                setCaptionMode(2);
                                                            } else if (b4 != 41) {
                                                                switch (b4) {
                                                                    case 37:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 2;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                        break;
                                                                    case 38:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 3;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                        break;
                                                                    case 39:
                                                                        setCaptionMode(1);
                                                                        this.captionRowCount = (byte) 4;
                                                                        this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                        break;
                                                                    default:
                                                                        b = this.captionMode;
                                                                        if (b != 0) {
                                                                            if (b4 != 33) {
                                                                                switch (b4) {
                                                                                    case 44:
                                                                                        this.cues = Collections.EMPTY_LIST;
                                                                                        if (b != 1) {
                                                                                            resetCueBuilders();
                                                                                        } else {
                                                                                            resetCueBuilders();
                                                                                        }
                                                                                        break;
                                                                                    case 45:
                                                                                        if (b == 1) {
                                                                                            CueBuilder cueBuilder1110 = this.currentCueBuilder;
                                                                                            arrayList = cueBuilder1110.rolledUpCaptions;
                                                                                            arrayList.add(cueBuilder1110.buildCurrentLine());
                                                                                            cueBuilder1110.captionStringBuilder.setLength(0);
                                                                                            cueBuilder1110.cueStyles.clear();
                                                                                            iMin = Math.min((int) cueBuilder1110.captionRowCount, cueBuilder1110.row);
                                                                                            while (arrayList.size() >= iMin) {
                                                                                                arrayList.remove(0);
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        resetCueBuilders();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.cues = getDisplayCues();
                                                                                        resetCueBuilders();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.currentCueBuilder.backspace();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                setCaptionMode(3);
                                                            }
                                                        }
                                                    } else if (i3 == 20) {
                                                        if (b4 == 32) {
                                                            setCaptionMode(2);
                                                        } else if (b4 != 41) {
                                                            switch (b4) {
                                                                case 37:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 2;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                    break;
                                                                case 38:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 3;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                    break;
                                                                case 39:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 4;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                    break;
                                                                default:
                                                                    b = this.captionMode;
                                                                    if (b != 0) {
                                                                        if (b4 != 33) {
                                                                            switch (b4) {
                                                                                case 44:
                                                                                    this.cues = Collections.EMPTY_LIST;
                                                                                    if (b != 1) {
                                                                                        resetCueBuilders();
                                                                                    } else {
                                                                                        resetCueBuilders();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (b == 1) {
                                                                                        CueBuilder cueBuilder1111 = this.currentCueBuilder;
                                                                                        arrayList = cueBuilder1111.rolledUpCaptions;
                                                                                        arrayList.add(cueBuilder1111.buildCurrentLine());
                                                                                        cueBuilder1111.captionStringBuilder.setLength(0);
                                                                                        cueBuilder1111.cueStyles.clear();
                                                                                        iMin = Math.min((int) cueBuilder1111.captionRowCount, cueBuilder1111.row);
                                                                                        while (arrayList.size() >= iMin) {
                                                                                            arrayList.remove(0);
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                                case 47:
                                                                                    this.cues = getDisplayCues();
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.currentCueBuilder.backspace();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            setCaptionMode(3);
                                                        }
                                                    }
                                                } else if (i2 != 23) {
                                                    if (i3 == 20) {
                                                        if (b4 == 32) {
                                                            setCaptionMode(2);
                                                        } else if (b4 != 41) {
                                                            switch (b4) {
                                                                case 37:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 2;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                    break;
                                                                case 38:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 3;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                    break;
                                                                case 39:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 4;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                    break;
                                                                default:
                                                                    b = this.captionMode;
                                                                    if (b != 0) {
                                                                        if (b4 != 33) {
                                                                            switch (b4) {
                                                                                case 44:
                                                                                    this.cues = Collections.EMPTY_LIST;
                                                                                    if (b != 1) {
                                                                                        resetCueBuilders();
                                                                                    } else {
                                                                                        resetCueBuilders();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (b == 1) {
                                                                                        CueBuilder cueBuilder1112 = this.currentCueBuilder;
                                                                                        arrayList = cueBuilder1112.rolledUpCaptions;
                                                                                        arrayList.add(cueBuilder1112.buildCurrentLine());
                                                                                        cueBuilder1112.captionStringBuilder.setLength(0);
                                                                                        cueBuilder1112.cueStyles.clear();
                                                                                        iMin = Math.min((int) cueBuilder1112.captionRowCount, cueBuilder1112.row);
                                                                                        while (arrayList.size() >= iMin) {
                                                                                            arrayList.remove(0);
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                                case 47:
                                                                                    this.cues = getDisplayCues();
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.currentCueBuilder.backspace();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            setCaptionMode(3);
                                                        }
                                                    }
                                                } else if (i3 == 20) {
                                                    if (b4 == 32) {
                                                        setCaptionMode(2);
                                                    } else if (b4 != 41) {
                                                        switch (b4) {
                                                            case 37:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 2;
                                                                this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                break;
                                                            case 38:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 3;
                                                                this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                break;
                                                            case 39:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 4;
                                                                this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                break;
                                                            default:
                                                                b = this.captionMode;
                                                                if (b != 0) {
                                                                    if (b4 != 33) {
                                                                        switch (b4) {
                                                                            case 44:
                                                                                this.cues = Collections.EMPTY_LIST;
                                                                                if (b != 1) {
                                                                                    resetCueBuilders();
                                                                                } else {
                                                                                    resetCueBuilders();
                                                                                }
                                                                                break;
                                                                            case 45:
                                                                                if (b == 1) {
                                                                                    CueBuilder cueBuilder1113 = this.currentCueBuilder;
                                                                                    arrayList = cueBuilder1113.rolledUpCaptions;
                                                                                    arrayList.add(cueBuilder1113.buildCurrentLine());
                                                                                    cueBuilder1113.captionStringBuilder.setLength(0);
                                                                                    cueBuilder1113.cueStyles.clear();
                                                                                    iMin = Math.min((int) cueBuilder1113.captionRowCount, cueBuilder1113.row);
                                                                                    while (arrayList.size() >= iMin) {
                                                                                        arrayList.remove(0);
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 46:
                                                                                resetCueBuilders();
                                                                                break;
                                                                            case 47:
                                                                                this.cues = getDisplayCues();
                                                                                resetCueBuilders();
                                                                                break;
                                                                        }
                                                                    } else {
                                                                        this.currentCueBuilder.backspace();
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        setCaptionMode(3);
                                                    }
                                                }
                                            } else if ((b3 & 240) != 16) {
                                                if (i2 != 23) {
                                                    if (i3 == 20) {
                                                        if (b4 == 32) {
                                                            setCaptionMode(2);
                                                        } else if (b4 != 41) {
                                                            switch (b4) {
                                                                case 37:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 2;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                    break;
                                                                case 38:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 3;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                    break;
                                                                case 39:
                                                                    setCaptionMode(1);
                                                                    this.captionRowCount = (byte) 4;
                                                                    this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                    break;
                                                                default:
                                                                    b = this.captionMode;
                                                                    if (b != 0) {
                                                                        if (b4 != 33) {
                                                                            switch (b4) {
                                                                                case 44:
                                                                                    this.cues = Collections.EMPTY_LIST;
                                                                                    if (b != 1) {
                                                                                        resetCueBuilders();
                                                                                    } else {
                                                                                        resetCueBuilders();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (b == 1) {
                                                                                        CueBuilder cueBuilder1114 = this.currentCueBuilder;
                                                                                        arrayList = cueBuilder1114.rolledUpCaptions;
                                                                                        arrayList.add(cueBuilder1114.buildCurrentLine());
                                                                                        cueBuilder1114.captionStringBuilder.setLength(0);
                                                                                        cueBuilder1114.cueStyles.clear();
                                                                                        iMin = Math.min((int) cueBuilder1114.captionRowCount, cueBuilder1114.row);
                                                                                        while (arrayList.size() >= iMin) {
                                                                                            arrayList.remove(0);
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                                case 47:
                                                                                    this.cues = getDisplayCues();
                                                                                    resetCueBuilders();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.currentCueBuilder.backspace();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            setCaptionMode(3);
                                                        }
                                                    }
                                                } else if (i3 == 20) {
                                                    if (b4 == 32) {
                                                        setCaptionMode(2);
                                                    } else if (b4 != 41) {
                                                        switch (b4) {
                                                            case 37:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 2;
                                                                this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                break;
                                                            case 38:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 3;
                                                                this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                break;
                                                            case 39:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 4;
                                                                this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                break;
                                                            default:
                                                                b = this.captionMode;
                                                                if (b != 0) {
                                                                    if (b4 != 33) {
                                                                        switch (b4) {
                                                                            case 44:
                                                                                this.cues = Collections.EMPTY_LIST;
                                                                                if (b != 1) {
                                                                                    resetCueBuilders();
                                                                                } else {
                                                                                    resetCueBuilders();
                                                                                }
                                                                                break;
                                                                            case 45:
                                                                                if (b == 1) {
                                                                                    CueBuilder cueBuilder1115 = this.currentCueBuilder;
                                                                                    arrayList = cueBuilder1115.rolledUpCaptions;
                                                                                    arrayList.add(cueBuilder1115.buildCurrentLine());
                                                                                    cueBuilder1115.captionStringBuilder.setLength(0);
                                                                                    cueBuilder1115.cueStyles.clear();
                                                                                    iMin = Math.min((int) cueBuilder1115.captionRowCount, cueBuilder1115.row);
                                                                                    while (arrayList.size() >= iMin) {
                                                                                        arrayList.remove(0);
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 46:
                                                                                resetCueBuilders();
                                                                                break;
                                                                            case 47:
                                                                                this.cues = getDisplayCues();
                                                                                resetCueBuilders();
                                                                                break;
                                                                        }
                                                                    } else {
                                                                        this.currentCueBuilder.backspace();
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        setCaptionMode(3);
                                                    }
                                                }
                                            } else if (i2 != 23) {
                                                if (i3 == 20) {
                                                    if (b4 == 32) {
                                                        setCaptionMode(2);
                                                    } else if (b4 != 41) {
                                                        switch (b4) {
                                                            case 37:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 2;
                                                                this.currentCueBuilder.captionRowCount = (byte) 2;
                                                                break;
                                                            case 38:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 3;
                                                                this.currentCueBuilder.captionRowCount = (byte) 3;
                                                                break;
                                                            case 39:
                                                                setCaptionMode(1);
                                                                this.captionRowCount = (byte) 4;
                                                                this.currentCueBuilder.captionRowCount = (byte) 4;
                                                                break;
                                                            default:
                                                                b = this.captionMode;
                                                                if (b != 0) {
                                                                    if (b4 != 33) {
                                                                        switch (b4) {
                                                                            case 44:
                                                                                this.cues = Collections.EMPTY_LIST;
                                                                                if (b != 1) {
                                                                                    resetCueBuilders();
                                                                                } else {
                                                                                    resetCueBuilders();
                                                                                }
                                                                                break;
                                                                            case 45:
                                                                                if (b == 1) {
                                                                                    CueBuilder cueBuilder1116 = this.currentCueBuilder;
                                                                                    arrayList = cueBuilder1116.rolledUpCaptions;
                                                                                    arrayList.add(cueBuilder1116.buildCurrentLine());
                                                                                    cueBuilder1116.captionStringBuilder.setLength(0);
                                                                                    cueBuilder1116.cueStyles.clear();
                                                                                    iMin = Math.min((int) cueBuilder1116.captionRowCount, cueBuilder1116.row);
                                                                                    while (arrayList.size() >= iMin) {
                                                                                        arrayList.remove(0);
                                                                                    }
                                                                                }
                                                                                break;
                                                                            case 46:
                                                                                resetCueBuilders();
                                                                                break;
                                                                            case 47:
                                                                                this.cues = getDisplayCues();
                                                                                resetCueBuilders();
                                                                                break;
                                                                        }
                                                                    } else {
                                                                        this.currentCueBuilder.backspace();
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        setCaptionMode(3);
                                                    }
                                                }
                                            } else if (i3 == 20) {
                                                if (b4 == 32) {
                                                    setCaptionMode(2);
                                                } else if (b4 != 41) {
                                                    switch (b4) {
                                                        case 37:
                                                            setCaptionMode(1);
                                                            this.captionRowCount = (byte) 2;
                                                            this.currentCueBuilder.captionRowCount = (byte) 2;
                                                            break;
                                                        case 38:
                                                            setCaptionMode(1);
                                                            this.captionRowCount = (byte) 3;
                                                            this.currentCueBuilder.captionRowCount = (byte) 3;
                                                            break;
                                                        case 39:
                                                            setCaptionMode(1);
                                                            this.captionRowCount = (byte) 4;
                                                            this.currentCueBuilder.captionRowCount = (byte) 4;
                                                            break;
                                                        default:
                                                            b = this.captionMode;
                                                            if (b != 0) {
                                                                if (b4 != 33) {
                                                                    switch (b4) {
                                                                        case 44:
                                                                            this.cues = Collections.EMPTY_LIST;
                                                                            if (b != 1) {
                                                                                resetCueBuilders();
                                                                            } else {
                                                                                resetCueBuilders();
                                                                            }
                                                                            break;
                                                                        case 45:
                                                                            if (b == 1) {
                                                                                CueBuilder cueBuilder1117 = this.currentCueBuilder;
                                                                                arrayList = cueBuilder1117.rolledUpCaptions;
                                                                                arrayList.add(cueBuilder1117.buildCurrentLine());
                                                                                cueBuilder1117.captionStringBuilder.setLength(0);
                                                                                cueBuilder1117.cueStyles.clear();
                                                                                iMin = Math.min((int) cueBuilder1117.captionRowCount, cueBuilder1117.row);
                                                                                while (arrayList.size() >= iMin) {
                                                                                    arrayList.remove(0);
                                                                                }
                                                                            }
                                                                            break;
                                                                        case 46:
                                                                            resetCueBuilders();
                                                                            break;
                                                                        case 47:
                                                                            this.cues = getDisplayCues();
                                                                            resetCueBuilders();
                                                                            break;
                                                                    }
                                                                } else {
                                                                    this.currentCueBuilder.backspace();
                                                                    break;
                                                                }
                                                            }
                                                            break;
                                                    }
                                                } else {
                                                    setCaptionMode(3);
                                                }
                                            }
                                        }
                                    } else {
                                        CueBuilder cueBuilder20 = this.currentCueBuilder;
                                        iArr = BASIC_CHARACTER_SET;
                                        cueBuilder20.append((char) iArr[(b3 & 127) - 32]);
                                        if ((b4 & 224) != 0) {
                                            this.currentCueBuilder.append((char) iArr[(b4 & 127) - 32]);
                                        }
                                    }
                                    z2 = true;
                                }
                            }
                        } else if (z3) {
                            resetCueBuilders();
                            z2 = true;
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.decoder.Decoder
    public final SimpleSubtitleDecoder$1 dequeueOutputBuffer() {
        SimpleSubtitleDecoder$1 simpleSubtitleDecoder$1;
        SimpleSubtitleDecoder$1 simpleSubtitleDecoder$1DequeueOutputBuffer = super.dequeueOutputBuffer();
        if (simpleSubtitleDecoder$1DequeueOutputBuffer != null) {
            return simpleSubtitleDecoder$1DequeueOutputBuffer;
        }
        long j = this.validDataChannelTimeoutUs;
        if (j == -9223372036854775807L) {
            return null;
        }
        long j2 = this.lastCueUpdateUs;
        if (j2 == -9223372036854775807L || this.playbackPositionUs - j2 < j || (simpleSubtitleDecoder$1 = (SimpleSubtitleDecoder$1) this.availableOutputBuffers.pollFirst()) == null) {
            return null;
        }
        this.cues = Collections.EMPTY_LIST;
        this.lastCueUpdateUs = -9223372036854775807L;
        Dispatcher$promoteAndExecute$Effects dispatcher$promoteAndExecute$EffectsCreateSubtitle = createSubtitle();
        long j3 = this.playbackPositionUs;
        simpleSubtitleDecoder$1.timeUs = j3;
        simpleSubtitleDecoder$1.subtitle = dispatcher$promoteAndExecute$EffectsCreateSubtitle;
        simpleSubtitleDecoder$1.subsampleOffsetUs = j3;
        return simpleSubtitleDecoder$1;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.decoder.Decoder
    public final void flush() {
        super.flush();
        this.cues = null;
        this.lastCues = null;
        setCaptionMode(0);
        this.captionRowCount = (byte) 4;
        this.currentCueBuilder.captionRowCount = (byte) 4;
        resetCueBuilders();
        this.isCaptionValid = false;
        this.repeatableControlSet = false;
        this.repeatableControlCc1 = (byte) 0;
        this.repeatableControlCc2 = (byte) 0;
        this.currentChannel = 0;
        this.isInCaptionService = true;
        this.lastCueUpdateUs = -9223372036854775807L;
    }

    public final ArrayList getDisplayCues() {
        ArrayList arrayList = this.cueBuilders;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        int iMin = 2;
        for (int i = 0; i < size; i++) {
            Cue cueBuild = ((CueBuilder) arrayList.get(i)).build(Integer.MIN_VALUE);
            arrayList2.add(cueBuild);
            if (cueBuild != null) {
                iMin = Math.min(iMin, cueBuild.positionAnchor);
            }
        }
        ArrayList arrayList3 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            Cue cueBuild2 = (Cue) arrayList2.get(i2);
            if (cueBuild2 != null) {
                if (cueBuild2.positionAnchor != iMin) {
                    cueBuild2 = ((CueBuilder) arrayList.get(i2)).build(iMin);
                    cueBuild2.getClass();
                }
                arrayList3.add(cueBuild2);
            }
        }
        return arrayList3;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    public final boolean isNewSubtitleDataAvailable() {
        return this.cues != this.lastCues;
    }

    public final void resetCueBuilders() {
        CueBuilder cueBuilder = this.currentCueBuilder;
        cueBuilder.captionMode = this.captionMode;
        cueBuilder.cueStyles.clear();
        cueBuilder.rolledUpCaptions.clear();
        cueBuilder.captionStringBuilder.setLength(0);
        cueBuilder.row = 15;
        cueBuilder.indent = 0;
        cueBuilder.tabOffset = 0;
        ArrayList arrayList = this.cueBuilders;
        arrayList.clear();
        arrayList.add(this.currentCueBuilder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCaptionMode(int i) {
        byte b = this.captionMode;
        if (b == i) {
            return;
        }
        this.captionMode = i;
        if (i != 3) {
            resetCueBuilders();
            if (b == 3 || i == 1 || i == 0) {
                this.cues = Collections.EMPTY_LIST;
                return;
            }
            return;
        }
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.cueBuilders;
            if (i2 >= arrayList.size()) {
                return;
            }
            ((CueBuilder) arrayList.get(i2)).captionMode = i;
            i2++;
        }
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.decoder.Decoder
    public final void release() {
    }
}
