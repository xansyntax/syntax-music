package io.ktor.http.cio.internals;

import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import io.ktor.http.cio.HttpParserKt$$ExternalSyntheticLambda0;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\u001a'\u0010\u0004\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\b\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u0001H\u0082\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\r\u001a\u00020\f*\u00020\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u000f\u001a\u00020\f*\u00020\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u000e\u001a\u001c\u0010\u0013\u001a\u00020\u0012*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001f\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0017\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u001b\u0010\u001d\"\u0014\u0010\u001f\u001a\u00020\u001e8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001f\u0010 \" \u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u001a\u0010(\u001a\u00020'8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u001a\u0010-\u001a\u00020,8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"", "", "start", "end", "hashCodeLowerCase", "(Ljava/lang/CharSequence;II)I", "other", "", "equalsLowerCase", "(Ljava/lang/CharSequence;IILjava/lang/CharSequence;)Z", "toLowerCase", "(I)I", "", "parseDecLong", "(Ljava/lang/CharSequence;)J", "parseDecLongWithCheck", "Lio/ktor/utils/io/ByteWriteChannel;", "value", "", "writeIntHex", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s", "idx", "", "hexNumberFormatException", "(Ljava/lang/CharSequence;I)Ljava/lang/Void;", "cs", "numberFormatException", "(Ljava/lang/CharSequence;I)V", "(Ljava/lang/CharSequence;)V", "", "HTAB", "C", "Lio/ktor/http/cio/internals/AsciiCharTree;", "Lio/ktor/http/HttpMethod;", "DefaultHttpMethods", "Lio/ktor/http/cio/internals/AsciiCharTree;", "getDefaultHttpMethods", "()Lio/ktor/http/cio/internals/AsciiCharTree;", "", "HexTable", "[J", "getHexTable", "()[J", "", "HexLetterTable", "[B", "getHexLetterTable", "()[B", "ktor-http-cio"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CharsKt {
    private static final AsciiCharTree<HttpMethod> DefaultHttpMethods = AsciiCharTree.INSTANCE.build(HttpMethod.DefaultMethods, new URLUtilsKt$$ExternalSyntheticLambda0(8), new HttpParserKt$$ExternalSyntheticLambda0(15));
    public static final char HTAB = '\t';
    private static final byte[] HexLetterTable;
    private static final long[] HexTable;

    /* JADX INFO: renamed from: io.ktor.http.cio.internals.CharsKt$writeIntHex$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.internals.CharsKt", f = "Chars.kt", l = {97, 105}, m = "writeIntHex", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CharsKt.writeIntHex(null, 0, this);
        }
    }

    static {
        long j;
        long j2;
        long j3;
        IntRange intRange = new IntRange(0, 255, 1);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange, 10));
        Iterator it = intRange.iterator();
        while (((IntProgressionIterator) it).hasNext) {
            int iNextInt = ((IntIterator) it).nextInt();
            if (48 > iNextInt || iNextInt >= 58) {
                j = iNextInt;
                if (j < 97 || j > 102) {
                    if (j < 65 || j > 70) {
                        j2 = -1;
                    } else {
                        j3 = 55;
                    }
                    arrayList.add(Long.valueOf(j2));
                } else {
                    j3 = 87;
                }
            } else {
                j = iNextInt;
                j3 = 48;
            }
            j2 = j - j3;
            arrayList.add(Long.valueOf(j2));
        }
        long[] jArr = new long[arrayList.size()];
        Iterator it2 = arrayList.iterator();
        int i = 0;
        while (it2.hasNext()) {
            jArr[i] = ((Number) it2.next()).longValue();
            i++;
        }
        HexTable = jArr;
        IntRange intRange2 = new IntRange(0, 15, 1);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange2, 10));
        Iterator it3 = intRange2.iterator();
        while (((IntProgressionIterator) it3).hasNext) {
            int iNextInt2 = ((IntIterator) it3).nextInt();
            arrayList2.add(Byte.valueOf((byte) (iNextInt2 < 10 ? iNextInt2 + 48 : (char) (((char) (iNextInt2 + 97)) - '\n'))));
        }
        HexLetterTable = CollectionsKt.toByteArray(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int DefaultHttpMethods$lambda$0(HttpMethod httpMethod) {
        httpMethod.getClass();
        return httpMethod.getValue().length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final char DefaultHttpMethods$lambda$1(HttpMethod httpMethod, int i) {
        httpMethod.getClass();
        return httpMethod.getValue().charAt(i);
    }

    public static final boolean equalsLowerCase(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        charSequence.getClass();
        charSequence2.getClass();
        if (i2 - i != charSequence2.length()) {
            return false;
        }
        for (int i3 = i; i3 < i2; i3++) {
            int iCharAt = charSequence.charAt(i3);
            if (65 <= iCharAt && iCharAt < 91) {
                iCharAt += 32;
            }
            int iCharAt2 = charSequence2.charAt(i3 - i);
            if (65 <= iCharAt2 && iCharAt2 < 91) {
                iCharAt2 += 32;
            }
            if (iCharAt != iCharAt2) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean equalsLowerCase$default(CharSequence charSequence, int i, int i2, CharSequence charSequence2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = charSequence.length();
        }
        return equalsLowerCase(charSequence, i, i2, charSequence2);
    }

    public static final AsciiCharTree<HttpMethod> getDefaultHttpMethods() {
        return DefaultHttpMethods;
    }

    public static final byte[] getHexLetterTable() {
        return HexLetterTable;
    }

    public static final long[] getHexTable() {
        return HexTable;
    }

    public static final int hashCodeLowerCase(CharSequence charSequence, int i, int i2) {
        charSequence.getClass();
        int i3 = 0;
        while (i < i2) {
            int iCharAt = charSequence.charAt(i);
            if (65 <= iCharAt && iCharAt < 91) {
                iCharAt += 32;
            }
            i3 = (i3 * 31) + iCharAt;
            i++;
        }
        return i3;
    }

    public static /* synthetic */ int hashCodeLowerCase$default(CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = charSequence.length();
        }
        return hashCodeLowerCase(charSequence, i, i2);
    }

    private static final Void hexNumberFormatException(CharSequence charSequence, int i) {
        throw new NumberFormatException("Invalid HEX number: " + ((Object) charSequence) + ", wrong digit: " + charSequence.charAt(i));
    }

    private static final void numberFormatException(CharSequence charSequence, int i) {
        throw new NumberFormatException("Invalid number: " + ((Object) charSequence) + ", wrong digit: " + charSequence.charAt(i) + " at position " + i);
    }

    public static final long parseDecLong(CharSequence charSequence) {
        charSequence.getClass();
        int length = charSequence.length();
        if (length > 19) {
            numberFormatException(charSequence);
        }
        if (length == 19) {
            return parseDecLongWithCheck(charSequence);
        }
        long j = 0;
        for (int i = 0; i < length; i++) {
            long jCharAt = ((long) charSequence.charAt(i)) - 48;
            if (jCharAt < 0 || jCharAt > 9) {
                numberFormatException(charSequence, i);
            }
            j = (j << 3) + (j << 1) + jCharAt;
        }
        return j;
    }

    private static final long parseDecLongWithCheck(CharSequence charSequence) {
        int length = charSequence.length();
        long j = 0;
        for (int i = 0; i < length; i++) {
            long jCharAt = ((long) charSequence.charAt(i)) - 48;
            if (jCharAt < 0 || jCharAt > 9) {
                numberFormatException(charSequence, i);
            }
            j = (j << 3) + (j << 1) + jCharAt;
            if (j < 0) {
                numberFormatException(charSequence);
            }
        }
        return j;
    }

    private static final int toLowerCase(int i) {
        return (65 > i || i >= 91) ? i : i + 32;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object writeIntHex(ByteWriteChannel byteWriteChannel, int i, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        byte[] bArr;
        int i2;
        int i3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i4 = anonymousClass1.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i4 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        int i5 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i5 != 0) {
            if (i5 != 1 && i5 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            int i6 = anonymousClass1.I$2;
            int i7 = anonymousClass1.I$1;
            int i8 = anonymousClass1.I$0;
            bArr = (byte[]) anonymousClass1.L$1;
            ByteWriteChannel byteWriteChannel2 = (ByteWriteChannel) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            i2 = i7;
            i = i8;
            i3 = i6;
            byteWriteChannel = byteWriteChannel2;
            break;
        }
        ResultKt.throwOnFailure(obj);
        if (i <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Does only work for positive numbers");
            return null;
        }
        bArr = HexLetterTable;
        int i9 = 0;
        i2 = i;
        while (true) {
            i3 = i9 + 1;
            if (i9 < 8) {
                int i10 = i2 >>> 28;
                i2 <<= 4;
                if (i10 != 0) {
                    byte b = bArr[i10];
                    anonymousClass1.L$0 = byteWriteChannel;
                    anonymousClass1.L$1 = bArr;
                    anonymousClass1.I$0 = i;
                    anonymousClass1.I$1 = i2;
                    anonymousClass1.I$2 = i3;
                    anonymousClass1.I$3 = i10;
                    anonymousClass1.label = 1;
                    if (ByteWriteChannelOperationsKt.writeByte(byteWriteChannel, b, anonymousClass1) != coroutineSingletons) {
                        break;
                    }
                } else {
                    i9 = i3;
                }
            }
            return coroutineSingletons;
        }
        while (true) {
            int i11 = i3 + 1;
            if (i3 >= 8) {
                return Unit.INSTANCE;
            }
            int i12 = i2 >>> 28;
            i2 <<= 4;
            byte b2 = bArr[i12];
            anonymousClass1.L$0 = byteWriteChannel;
            anonymousClass1.L$1 = bArr;
            anonymousClass1.I$0 = i;
            anonymousClass1.I$1 = i2;
            anonymousClass1.I$2 = i11;
            anonymousClass1.I$3 = i12;
            anonymousClass1.label = 2;
            if (ByteWriteChannelOperationsKt.writeByte(byteWriteChannel, b2, anonymousClass1) == coroutineSingletons) {
                return coroutineSingletons;
            }
            i3 = i11;
        }
    }

    private static final void numberFormatException(CharSequence charSequence) {
        throw new NumberFormatException("Invalid number " + ((Object) charSequence) + ": too large for Long type");
    }
}
