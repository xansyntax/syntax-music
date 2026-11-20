package androidx.media3.container;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.sqlite.SQLite;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.google.common.base.Joiner;
import com.google.common.io.BaseEncoding$Alphabet;
import com.google.common.io.BaseEncoding$Base16Encoding;
import com.google.common.io.BaseEncoding$StandardBaseEncoding;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MdtaMetadataEntry implements Metadata.Entry {
    public final String key;
    public final int localeIndicator;
    public final int typeIndicator;
    public final byte[] value;

    public MdtaMetadataEntry(String str, byte[] bArr, int i, int i2) {
        byte b;
        str.getClass();
        boolean z = false;
        switch (str) {
            case "com.android.capture.fps":
                if (i2 == 23 && bArr.length == 4) {
                    z = true;
                }
                UtilsKt.checkArgument(z);
                break;
            case "auxiliary.tracks.interleaved":
                if (i2 == 75 && bArr.length == 1 && ((b = bArr[0]) == 0 || b == 1)) {
                    z = true;
                }
                UtilsKt.checkArgument(z);
                break;
            case "auxiliary.tracks.length":
            case "auxiliary.tracks.offset":
                if (i2 == 78 && bArr.length == 8) {
                    z = true;
                }
                UtilsKt.checkArgument(z);
                break;
            case "auxiliary.tracks.map":
                UtilsKt.checkArgument(i2 == 0);
                break;
        }
        this.key = str;
        this.value = bArr;
        this.localeIndicator = i;
        this.typeIndicator = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MdtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
        return this.key.equals(mdtaMetadataEntry.key) && Arrays.equals(this.value, mdtaMetadataEntry.value) && this.localeIndicator == mdtaMetadataEntry.localeIndicator && this.typeIndicator == mdtaMetadataEntry.typeIndicator;
    }

    public final ArrayList getAuxiliaryTrackTypesFromMap() {
        UtilsKt.checkState("Metadata is not an auxiliary tracks map", this.key.equals("auxiliary.tracks.map"));
        byte[] bArr = this.value;
        byte b = bArr[1];
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < b; i++) {
            arrayList.add(Integer.valueOf(bArr[i + 2]));
        }
        return arrayList;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.value) + Fragment$5$$ExternalSyntheticOutline0.m(527, 31, this.key)) * 31) + this.localeIndicator) * 31) + this.typeIndicator;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:54:0x0114  */
    /* JADX WARN: Code duplicated, block: B:57:0x011b  */
    /* JADX WARN: Code duplicated, block: B:60:0x0126  */
    /* JADX WARN: Code duplicated, block: B:62:0x012f  */
    /* JADX WARN: Code duplicated, block: B:63:0x0132 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x0134  */
    /* JADX WARN: Code duplicated, block: B:65:0x0136  */
    /* JADX WARN: Code duplicated, block: B:68:0x013b  */
    /* JADX WARN: Code duplicated, block: B:73:0x016c A[EDGE_INSN: B:73:0x016c->B:75:0x0172 BREAK  A[LOOP:0: B:33:0x00c3->B:74:0x016e]] */
    /* JADX WARN: Code duplicated, block: B:74:0x016e A[LOOP:0: B:33:0x00c3->B:74:0x016e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x0176  */
    /* JADX WARN: Code duplicated, block: B:78:0x0178  */
    /* JADX WARN: Code duplicated, block: B:91:0x00cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x00e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x00f9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x0140 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:32:0x00bd, please report this as an issue */
    public final String toString() {
        String string;
        BaseEncoding$Base16Encoding baseEncoding$Base16Encoding;
        BaseEncoding$StandardBaseEncoding baseEncoding$Base16Encoding2;
        BaseEncoding$Alphabet baseEncoding$Alphabet;
        char[] cArr;
        int i;
        int length;
        int i2;
        boolean z;
        char[] cArr2;
        int i3;
        BaseEncoding$Alphabet baseEncoding$Alphabet2;
        byte[] bArr;
        byte[] bArrCopyOf;
        int i4;
        int i5;
        byte b;
        byte b2;
        boolean z2;
        char c;
        char c2;
        char c3;
        char c4;
        int i6 = this.typeIndicator;
        if (i6 != 0) {
            if (i6 == 1) {
                string = Util.fromUtf8Bytes(this.value);
            } else if (i6 == 23) {
                byte[] bArr2 = this.value;
                UtilsKt.checkArgument("array too small: %s < %s", bArr2.length, 4, bArr2.length >= 4);
                string = String.valueOf(Float.intBitsToFloat(StringsKt__IndentKt.fromBytes(bArr2[0], bArr2[1], bArr2[2], bArr2[3])));
            } else if (i6 == 67) {
                byte[] bArr3 = this.value;
                UtilsKt.checkArgument("array too small: %s < %s", bArr3.length, 4, bArr3.length >= 4);
                string = String.valueOf(StringsKt__IndentKt.fromBytes(bArr3[0], bArr3[1], bArr3[2], bArr3[3]));
            } else if (i6 == 75) {
                string = String.valueOf(Byte.toUnsignedInt(this.value[0]));
            } else if (i6 != 78) {
                byte[] bArr4 = this.value;
                String str = Util.DEVICE_DEBUG_INFO;
                baseEncoding$Base16Encoding = BaseEncoding$StandardBaseEncoding.BASE16;
                baseEncoding$Base16Encoding2 = baseEncoding$Base16Encoding.lowerCase;
                if (baseEncoding$Base16Encoding2 == null) {
                    baseEncoding$Alphabet = baseEncoding$Base16Encoding.alphabet;
                    cArr = baseEncoding$Alphabet.chars;
                    for (char c5 : cArr) {
                        if (LifecyclesKt.isUpperCase(c5)) {
                            length = cArr.length;
                            i2 = 0;
                            while (true) {
                                if (i2 >= length) {
                                    z = false;
                                    break;
                                }
                                c4 = cArr[i2];
                                if (c4 < 'a' && c4 <= 'z') {
                                    z = true;
                                    break;
                                }
                                i2++;
                            }
                            UtilsKt.checkState("Cannot call lowerCase() on a mixed-case alphabet", !z);
                            cArr2 = new char[cArr.length];
                            for (i3 = 0; i3 < cArr.length; i3++) {
                                c3 = cArr[i3];
                                if (LifecyclesKt.isUpperCase(c3)) {
                                    c3 = (char) (c3 ^ ' ');
                                }
                                cArr2[i3] = c3;
                            }
                            baseEncoding$Alphabet2 = new BaseEncoding$Alphabet(IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(), baseEncoding$Alphabet.name, ".lowerCase()"), cArr2);
                            if (baseEncoding$Alphabet.ignoreCase) {
                                baseEncoding$Alphabet = baseEncoding$Alphabet2;
                                break;
                            }
                            bArr = baseEncoding$Alphabet2.decodabet;
                            if (baseEncoding$Alphabet2.ignoreCase) {
                                bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                                for (i4 = 65; i4 <= 90; i4++) {
                                    i5 = i4 | 32;
                                    b = bArr[i4];
                                    b2 = bArr[i5];
                                    if (b == -1) {
                                        bArrCopyOf[i4] = b2;
                                    } else {
                                        if (b2 == -1) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        c = (char) i4;
                                        c2 = (char) i5;
                                        if (z2) {
                                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2(SQLite.lenientFormat("Can't ignoreCase() since '%s' and '%s' encode different values", Character.valueOf(c), Character.valueOf(c2)));
                                            return null;
                                        }
                                        bArrCopyOf[i5] = b;
                                    }
                                }
                                baseEncoding$Alphabet = new BaseEncoding$Alphabet(IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(), baseEncoding$Alphabet2.name, ".ignoreCase()"), baseEncoding$Alphabet2.chars, bArrCopyOf, true);
                                break;
                            }
                            baseEncoding$Alphabet = baseEncoding$Alphabet2;
                            break;
                        }
                    }
                    if (baseEncoding$Alphabet == baseEncoding$Base16Encoding.alphabet) {
                        baseEncoding$Base16Encoding2 = baseEncoding$Base16Encoding;
                    } else {
                        baseEncoding$Base16Encoding2 = new BaseEncoding$Base16Encoding(baseEncoding$Alphabet);
                    }
                    baseEncoding$Base16Encoding.lowerCase = baseEncoding$Base16Encoding2;
                }
                int length2 = bArr4.length;
                UtilsKt.checkPositionIndexes(0, length2, bArr4.length);
                BaseEncoding$Alphabet baseEncoding$Alphabet3 = baseEncoding$Base16Encoding2.alphabet;
                int i7 = baseEncoding$Alphabet3.charsPerChunk;
                int i8 = baseEncoding$Alphabet3.bytesPerChunk;
                RoundingMode roundingMode = RoundingMode.CEILING;
                StringBuilder sb = new StringBuilder(IntMath.divide(length2, i8) * i7);
                try {
                    baseEncoding$Base16Encoding2.encodeTo(sb, bArr4, length2);
                    string = sb.toString();
                } catch (IOException e) {
                    throw new AssertionError(e);
                }
            } else {
                string = String.valueOf(new ParsableByteArray(this.value).readUnsignedLongToLong());
            }
        } else if (this.key.equals("auxiliary.tracks.map")) {
            ArrayList auxiliaryTrackTypesFromMap = getAuxiliaryTrackTypesFromMap();
            StringBuilder sbM = Format$$ExternalSyntheticOutline0.m("track types = ");
            new Joiner(String.valueOf(',')).appendTo(sbM, auxiliaryTrackTypesFromMap.iterator());
            string = sbM.toString();
        } else {
            byte[] bArr5 = this.value;
            String str2 = Util.DEVICE_DEBUG_INFO;
            baseEncoding$Base16Encoding = BaseEncoding$StandardBaseEncoding.BASE16;
            baseEncoding$Base16Encoding2 = baseEncoding$Base16Encoding.lowerCase;
            if (baseEncoding$Base16Encoding2 == null) {
                baseEncoding$Alphabet = baseEncoding$Base16Encoding.alphabet;
                cArr = baseEncoding$Alphabet.chars;
                while (i < r6) {
                    if (LifecyclesKt.isUpperCase(c5)) {
                        length = cArr.length;
                        i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                z = false;
                                break;
                            }
                            c4 = cArr[i2];
                            if (c4 < 'a') {
                            }
                            i2++;
                        }
                        UtilsKt.checkState("Cannot call lowerCase() on a mixed-case alphabet", !z);
                        cArr2 = new char[cArr.length];
                        while (i3 < cArr.length) {
                            c3 = cArr[i3];
                            if (LifecyclesKt.isUpperCase(c3)) {
                                c3 = (char) (c3 ^ ' ');
                            }
                            cArr2[i3] = c3;
                        }
                        baseEncoding$Alphabet2 = new BaseEncoding$Alphabet(IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(), baseEncoding$Alphabet.name, ".lowerCase()"), cArr2);
                        if (baseEncoding$Alphabet.ignoreCase) {
                            baseEncoding$Alphabet = baseEncoding$Alphabet2;
                            break;
                        }
                        bArr = baseEncoding$Alphabet2.decodabet;
                        if (baseEncoding$Alphabet2.ignoreCase) {
                            bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                            while (i4 <= 90) {
                                i5 = i4 | 32;
                                b = bArr[i4];
                                b2 = bArr[i5];
                                if (b == -1) {
                                    bArrCopyOf[i4] = b2;
                                } else {
                                    if (b2 == -1) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    c = (char) i4;
                                    c2 = (char) i5;
                                    if (z2) {
                                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(SQLite.lenientFormat("Can't ignoreCase() since '%s' and '%s' encode different values", Character.valueOf(c), Character.valueOf(c2)));
                                        return null;
                                    }
                                    bArrCopyOf[i5] = b;
                                }
                            }
                            baseEncoding$Alphabet = new BaseEncoding$Alphabet(IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(), baseEncoding$Alphabet2.name, ".ignoreCase()"), baseEncoding$Alphabet2.chars, bArrCopyOf, true);
                            break;
                        }
                        baseEncoding$Alphabet = baseEncoding$Alphabet2;
                        break;
                    }
                }
                if (baseEncoding$Alphabet == baseEncoding$Base16Encoding.alphabet) {
                    baseEncoding$Base16Encoding2 = baseEncoding$Base16Encoding;
                } else {
                    baseEncoding$Base16Encoding2 = new BaseEncoding$Base16Encoding(baseEncoding$Alphabet);
                }
                baseEncoding$Base16Encoding.lowerCase = baseEncoding$Base16Encoding2;
            }
            int length3 = bArr5.length;
            UtilsKt.checkPositionIndexes(0, length3, bArr5.length);
            BaseEncoding$Alphabet baseEncoding$Alphabet4 = baseEncoding$Base16Encoding2.alphabet;
            int i9 = baseEncoding$Alphabet4.charsPerChunk;
            int i10 = baseEncoding$Alphabet4.bytesPerChunk;
            RoundingMode roundingMode2 = RoundingMode.CEILING;
            StringBuilder sb2 = new StringBuilder(IntMath.divide(length3, i10) * i9);
            baseEncoding$Base16Encoding2.encodeTo(sb2, bArr5, length3);
            string = sb2.toString();
        }
        return "mdta: key=" + this.key + ", value=" + string;
    }
}
