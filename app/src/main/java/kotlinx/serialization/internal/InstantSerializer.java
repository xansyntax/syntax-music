package kotlinx.serialization.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.google.common.base.Splitter;
import kotlin.time.Instant;
import kotlin.time.InstantKt;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;
import kotlin.time.InstantParseResult;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind$INT;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class InstantSerializer implements KSerializer {
    public static final InstantSerializer INSTANCE = new InstantSerializer();
    public static final PrimitiveSerialDescriptor descriptor = new PrimitiveSerialDescriptor("kotlin.time.Instant", PrimitiveKind$INT.INSTANCE$8);

    /* JADX WARN: Code duplicated, block: B:194:0x0466 A[EDGE_INSN: B:194:0x0466->B:196:0x048e BREAK  A[LOOP:1: B:54:0x012b->B:58:0x0142]] */
    /* JADX WARN: Code duplicated, block: B:195:0x047c A[EDGE_INSN: B:195:0x047c->B:196:0x048e BREAK  A[LOOP:1: B:54:0x012b->B:58:0x0142]] */
    /* JADX WARN: Instruction removed from duplicated block: B:195:0x047c, please report this as an issue */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        int i;
        InstantParseResult iso$expect;
        int i2;
        int i3;
        int i4;
        char cCharAt;
        char cCharAt2;
        Instant instant = Instant.MIN;
        String strDecodeString = decoder.decodeString();
        strDecodeString.getClass();
        if (strDecodeString.length() == 0) {
            iso$expect = new Splitter("An empty string is not a valid Instant", strDecodeString, (byte) 11);
        } else {
            char cCharAt3 = strDecodeString.charAt(0);
            if (cCharAt3 == '+' || cCharAt3 == '-') {
                i = 1;
            } else {
                i = 0;
                cCharAt3 = ' ';
            }
            int iCharAt = 0;
            int i5 = i;
            while (i5 < strDecodeString.length() && '0' <= (cCharAt2 = strDecodeString.charAt(i5)) && cCharAt2 < ':') {
                iCharAt = (iCharAt * 10) + (strDecodeString.charAt(i5) - '0');
                i5++;
            }
            int i6 = i5 - i;
            if (i6 > 10) {
                iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "Expected at most 10 digits for the year number, got " + i6 + " digits");
            } else if (i6 == 10 && strDecodeString.charAt(i) >= '2') {
                iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "Expected at most 9 digits for the year number or year 1000000000, got " + i6 + " digits");
            } else if (i6 < 4) {
                iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "The year number must be padded to 4 digits, got " + i6 + " digits");
            } else if (cCharAt3 == '+' && i6 == 4) {
                iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "The '+' sign at the start is only valid for year numbers longer than 4 digits");
            } else if (cCharAt3 != ' ' || i6 == 4) {
                if (cCharAt3 == '-') {
                    iCharAt = -iCharAt;
                }
                int i7 = i5 + 16;
                if (strDecodeString.length() >= i7) {
                    Splitter iso$expect2 = InstantKt.parseIso$expect(strDecodeString, "'-'", i5, new InstantKt$$ExternalSyntheticLambda0((byte) 0));
                    if (iso$expect2 != null) {
                        iso$expect = iso$expect2;
                        break;
                    }
                    iso$expect = InstantKt.parseIso$expect(strDecodeString, "'-'", i5 + 3, new InstantKt$$ExternalSyntheticLambda0((byte) 20));
                    if (iso$expect == null && (iso$expect = InstantKt.parseIso$expect(strDecodeString, "'T' or 't'", i5 + 6, new InstantKt$$ExternalSyntheticLambda0((byte) 21))) == null && (iso$expect = InstantKt.parseIso$expect(strDecodeString, "':'", i5 + 9, new InstantKt$$ExternalSyntheticLambda0((byte) 22))) == null && (iso$expect = InstantKt.parseIso$expect(strDecodeString, "':'", i5 + 12, new InstantKt$$ExternalSyntheticLambda0((byte) 23))) == null) {
                        int i8 = 0;
                        while (true) {
                            if (i8 >= 10) {
                                int iso$twoDigitNumber = InstantKt.parseIso$twoDigitNumber(i5 + 1, strDecodeString);
                                int iso$twoDigitNumber2 = InstantKt.parseIso$twoDigitNumber(i5 + 4, strDecodeString);
                                int iso$twoDigitNumber3 = InstantKt.parseIso$twoDigitNumber(i5 + 7, strDecodeString);
                                int iso$twoDigitNumber4 = InstantKt.parseIso$twoDigitNumber(i5 + 10, strDecodeString);
                                int iso$twoDigitNumber5 = InstantKt.parseIso$twoDigitNumber(i5 + 13, strDecodeString);
                                int i9 = i5 + 15;
                                if (strDecodeString.charAt(i9) == '.') {
                                    i9 = i7;
                                    int iCharAt2 = 0;
                                    while (i9 < strDecodeString.length() && '0' <= (cCharAt = strDecodeString.charAt(i9)) && cCharAt < ':') {
                                        iCharAt2 = (iCharAt2 * 10) + (strDecodeString.charAt(i9) - '0');
                                        i9++;
                                    }
                                    int i10 = i9 - i7;
                                    if (1 > i10 || i10 >= 10) {
                                        iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "1..9 digits are supported for the fraction of the second, got " + i10 + " digits");
                                        break;
                                    }
                                    i2 = iCharAt2 * InstantKt.POWERS_OF_TEN[9 - i10];
                                } else {
                                    i2 = 0;
                                }
                                if (i9 < strDecodeString.length()) {
                                    char cCharAt4 = strDecodeString.charAt(i9);
                                    if (cCharAt4 != '+' && cCharAt4 != '-') {
                                        if (cCharAt4 != 'Z' && cCharAt4 != 'z') {
                                            iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "Expected the UTC offset at position " + i9 + ", got '" + cCharAt4 + '\'');
                                            break;
                                        }
                                        int i11 = i9 + 1;
                                        if (strDecodeString.length() != i11) {
                                            iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "Extra text after the instant at position " + i11);
                                            break;
                                        }
                                        i3 = 0;
                                        if (1 <= iso$twoDigitNumber) {
                                            iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "Expected a month number in 1..12, got " + iso$twoDigitNumber);
                                            break;
                                        }
                                        iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "Expected a month number in 1..12, got " + iso$twoDigitNumber);
                                        break;
                                    }
                                    int length = strDecodeString.length() - i9;
                                    if (length <= 9) {
                                        if (length % 3 == 0) {
                                            int i12 = 0;
                                            for (int i13 = 2; i12 < i13; i13 = 2) {
                                                int i14 = i9 + InstantKt.colonsInIsoOffsetString[i12];
                                                if (i14 >= strDecodeString.length()) {
                                                    break;
                                                }
                                                if (strDecodeString.charAt(i14) != ':') {
                                                    StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(i14, "Expected ':' at index ", ", got '");
                                                    sbM2m.append(strDecodeString.charAt(i14));
                                                    sbM2m.append('\'');
                                                    iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, sbM2m.toString());
                                                    break;
                                                }
                                                i12++;
                                            }
                                            int i15 = 0;
                                            while (i15 < 6 && (i4 = InstantKt.asciiDigitsInIsoOffsetString[i15] + i9) < strDecodeString.length()) {
                                                char cCharAt5 = strDecodeString.charAt(i4);
                                                int i16 = i15;
                                                if ('0' > cCharAt5 || cCharAt5 >= ':') {
                                                    StringBuilder sbM2m2 = IntIntPair$$ExternalSyntheticOutline0.m2m(i4, "Expected an ASCII digit at index ", ", got '");
                                                    sbM2m2.append(strDecodeString.charAt(i4));
                                                    sbM2m2.append('\'');
                                                    iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, sbM2m2.toString());
                                                    break;
                                                }
                                                i15 = i16 + 1;
                                            }
                                            int iso$twoDigitNumber6 = InstantKt.parseIso$twoDigitNumber(i9 + 1, strDecodeString);
                                            int iso$twoDigitNumber7 = length > 3 ? InstantKt.parseIso$twoDigitNumber(i9 + 4, strDecodeString) : 0;
                                            int iso$twoDigitNumber8 = length > 6 ? InstantKt.parseIso$twoDigitNumber(i9 + 7, strDecodeString) : 0;
                                            if (iso$twoDigitNumber7 <= 59) {
                                                if (iso$twoDigitNumber8 <= 59) {
                                                    if (iso$twoDigitNumber6 > 17 && (iso$twoDigitNumber6 != 18 || iso$twoDigitNumber7 != 0 || iso$twoDigitNumber8 != 0)) {
                                                        iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "Expected an offset in -18:00..+18:00, got " + strDecodeString.subSequence(i9, strDecodeString.length()).toString());
                                                        break;
                                                    }
                                                    i3 = ((iso$twoDigitNumber7 * 60) + (iso$twoDigitNumber6 * 3600) + iso$twoDigitNumber8) * (cCharAt4 == '-' ? -1 : 1);
                                                    if (1 <= iso$twoDigitNumber && iso$twoDigitNumber < 13) {
                                                        if (1 <= iso$twoDigitNumber2) {
                                                            int i17 = iCharAt & 3;
                                                            if (iso$twoDigitNumber2 > (iso$twoDigitNumber != 2 ? (iso$twoDigitNumber == 4 || iso$twoDigitNumber == 6 || iso$twoDigitNumber == 9 || iso$twoDigitNumber == 11) ? 30 : 31 : i17 == 0 && (iCharAt % 100 != 0 || iCharAt % 400 == 0) ? 29 : 28)) {
                                                                StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(iso$twoDigitNumber, "Expected a valid day-of-month for month ", " of year ", iCharAt, ", got ");
                                                                sbM3m.append(iso$twoDigitNumber2);
                                                                iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, sbM3m.toString());
                                                                break;
                                                            }
                                                            if (iso$twoDigitNumber3 <= 23) {
                                                                if (iso$twoDigitNumber4 <= 59) {
                                                                    if (iso$twoDigitNumber5 <= 59) {
                                                                        long j = iCharAt;
                                                                        long j2 = 365 * j;
                                                                        long j3 = (j >= 0 ? ((j + 399) / 400) + (((j + 3) / 4) - ((j + 99) / 100)) + j2 : j2 - ((j / (-400)) + ((j / (-4)) - (j / (-100))))) + ((long) (((iso$twoDigitNumber * 367) - 362) / 12)) + ((long) (iso$twoDigitNumber2 - 1));
                                                                        if (iso$twoDigitNumber > 2) {
                                                                            j3 = (i17 != 0 || (iCharAt % 100 == 0 && iCharAt % 400 != 0)) ? j3 - 2 : (-1) + j3;
                                                                        }
                                                                        iso$expect = new InstantParseResult.Success((((j3 - 719528) * 86400) + ((long) (((iso$twoDigitNumber4 * 60) + (iso$twoDigitNumber3 * 3600)) + iso$twoDigitNumber5))) - ((long) i3), i2);
                                                                        break;
                                                                    }
                                                                    iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "Expected second-of-minute in 0..59, got " + iso$twoDigitNumber5);
                                                                    break;
                                                                }
                                                                iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "Expected minute-of-hour in 0..59, got " + iso$twoDigitNumber4);
                                                                break;
                                                            }
                                                            iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "Expected hour in 0..23, got " + iso$twoDigitNumber3);
                                                            break;
                                                        }
                                                        StringBuilder sbM3m2 = IntIntPair$$ExternalSyntheticOutline0.m3m(iso$twoDigitNumber, "Expected a valid day-of-month for month ", " of year ", iCharAt, ", got ");
                                                        sbM3m2.append(iso$twoDigitNumber2);
                                                        iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, sbM3m2.toString());
                                                        break;
                                                    }
                                                    iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "Expected a month number in 1..12, got " + iso$twoDigitNumber);
                                                    break;
                                                }
                                                iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "Expected offset-second-of-minute in 0..59, got " + iso$twoDigitNumber8);
                                                break;
                                            }
                                            iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "Expected offset-minute-of-hour in 0..59, got " + iso$twoDigitNumber7);
                                            break;
                                        }
                                        iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "Invalid UTC offset string \"" + strDecodeString.subSequence(i9, strDecodeString.length()).toString() + '\"');
                                        break;
                                    }
                                    iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "The UTC offset string \"" + InstantKt.truncateForErrorMessage(16, strDecodeString.subSequence(i9, strDecodeString.length()).toString()) + "\" is too long");
                                    break;
                                }
                                iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "The UTC offset at the end of the string is missing");
                                break;
                            }
                            iso$expect2 = InstantKt.parseIso$expect(strDecodeString, "an ASCII digit", InstantKt.asciiDigitPositionsInIsoStringAfterYear[i8] + i5, new InstantKt$$ExternalSyntheticLambda0((byte) 24));
                            if (iso$expect2 != null) {
                                iso$expect = iso$expect2;
                                break;
                            }
                            i8++;
                        }
                    }
                } else {
                    iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "The input string is too short");
                }
            } else {
                iso$expect = InstantKt.parseIso$parseFailure(strDecodeString, "A '+' or '-' sign is required for year numbers longer than 4 digits");
            }
        }
        return iso$expect.toInstant();
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Instant instant = (Instant) obj;
        instant.getClass();
        encoder.encodeString(instant.toString());
    }
}
