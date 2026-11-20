package kotlin.text;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.http.URLParserKt$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IndexingIterable;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public abstract class StringsKt extends StringsKt__StringsJVMKt {
    public static boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        charSequence.getClass();
        charSequence2.getClass();
        if (charSequence2 instanceof String) {
            if (indexOf$default(charSequence, (String) charSequence2, 0, z, 2) >= 0) {
                return true;
            }
        } else if (indexOf$StringsKt__StringsKt(charSequence, charSequence2, 0, charSequence.length(), z, false) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean contains$default(CharSequence charSequence, char c) {
        charSequence.getClass();
        return indexOf$default(charSequence, c, 0, 2) >= 0;
    }

    public static String drop(int i, String str) {
        str.getClass();
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Requested character count ", " is less than zero."));
            return null;
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        return str.substring(i);
    }

    public static boolean endsWith$default(CharSequence charSequence, String str) {
        charSequence.getClass();
        return charSequence instanceof String ? StringsKt__StringsJVMKt.endsWith((String) charSequence, str, false) : regionMatchesImpl(charSequence, charSequence.length() - str.length(), str, 0, str.length(), false);
    }

    public static int getLastIndex(CharSequence charSequence) {
        charSequence.getClass();
        return charSequence.length() - 1;
    }

    public static Character getOrNull(int i, String str) {
        if (i < 0 || i >= str.length()) {
            return null;
        }
        return Character.valueOf(str.charAt(i));
    }

    public static final boolean hasSurrogatePairAt(int i, String str) {
        return i >= 0 && i <= str.length() + (-2) && Character.isHighSurrogate(str.charAt(i)) && Character.isLowSurrogate(str.charAt(i + 1));
    }

    public static final int indexOf(int i, CharSequence charSequence, String str, boolean z) {
        charSequence.getClass();
        str.getClass();
        return (z || !(charSequence instanceof String)) ? indexOf$StringsKt__StringsKt(charSequence, str, i, charSequence.length(), z, false) : ((String) charSequence).indexOf(str, i);
    }

    public static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        IntProgression intProgression;
        if (z2) {
            int lastIndex = getLastIndex(charSequence);
            if (i > lastIndex) {
                i = lastIndex;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            intProgression = new IntProgression(i, i2, -1);
        } else {
            if (i < 0) {
                i = 0;
            }
            int length = charSequence.length();
            if (i2 > length) {
                i2 = length;
            }
            intProgression = new IntRange(i, i2, 1);
        }
        boolean z3 = charSequence instanceof String;
        int i3 = intProgression.step;
        int i4 = intProgression.last;
        int i5 = intProgression.first;
        if (!z3 || !(charSequence2 instanceof String)) {
            boolean z4 = z;
            if ((i3 > 0 && i5 <= i4) || (i3 < 0 && i4 <= i5)) {
                while (true) {
                    CharSequence charSequence3 = charSequence;
                    CharSequence charSequence4 = charSequence2;
                    boolean z5 = z4;
                    z4 = z5;
                    if (regionMatchesImpl(charSequence4, 0, charSequence3, i5, charSequence2.length(), z5)) {
                        return i5;
                    }
                    if (i5 != i4) {
                        i5 += i3;
                        charSequence2 = charSequence4;
                        charSequence = charSequence3;
                    }
                }
            }
        } else if ((i3 > 0 && i5 <= i4) || (i3 < 0 && i4 <= i5)) {
            int i6 = i5;
            while (true) {
                String str = (String) charSequence2;
                boolean z6 = z;
                if (StringsKt__StringsJVMKt.regionMatches(0, i6, str.length(), str, (String) charSequence, z6)) {
                    return i6;
                }
                if (i6 != i4) {
                    i6 += i3;
                    z = z6;
                }
            }
        }
        return -1;
    }

    public static int indexOf$default(CharSequence charSequence, char c, int i, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        charSequence.getClass();
        return !(charSequence instanceof String) ? indexOfAny(charSequence, new char[]{c}, i, false) : ((String) charSequence).indexOf(c, i);
    }

    public static final int indexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        charSequence.getClass();
        cArr.getClass();
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ArraysKt.single(cArr), i);
        }
        if (i < 0) {
            i = 0;
        }
        int length = charSequence.length() - 1;
        if (i > length) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i);
            for (char c : cArr) {
                if (CharsKt.equals(c, cCharAt, z)) {
                    return i;
                }
            }
            if (i == length) {
                return -1;
            }
            i++;
        }
    }

    public static boolean isBlank(CharSequence charSequence) {
        charSequence.getClass();
        for (int i = 0; i < charSequence.length(); i++) {
            if (!CharsKt.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static char last(CharSequence charSequence) {
        if (charSequence.length() != 0) {
            return charSequence.charAt(charSequence.length() - 1);
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1("Char sequence is empty.");
        return (char) 0;
    }

    public static int lastIndexOf$default(CharSequence charSequence, String str, int i) {
        int lastIndex = (i & 2) != 0 ? getLastIndex(charSequence) : 0;
        charSequence.getClass();
        str.getClass();
        return !(charSequence instanceof String) ? indexOf$StringsKt__StringsKt(charSequence, str, lastIndex, 0, false, true) : ((String) charSequence).lastIndexOf(str, lastIndex);
    }

    public static final int lastIndexOfAny(CharSequence charSequence, char[] cArr, int i) {
        charSequence.getClass();
        cArr.getClass();
        if (cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(ArraysKt.single(cArr), i);
        }
        int length = charSequence.length() - 1;
        if (i > length) {
            i = length;
        }
        while (-1 < i) {
            char cCharAt = charSequence.charAt(i);
            for (char c : cArr) {
                if (CharsKt.equals(c, cCharAt, false)) {
                    return i;
                }
            }
            i--;
        }
        return -1;
    }

    public static List lines(CharSequence charSequence) {
        charSequence.getClass();
        LinesIterator linesIterator = new LinesIterator(charSequence);
        if (!linesIterator.hasNext()) {
            return EmptyList.INSTANCE;
        }
        Object next = linesIterator.next();
        if (!linesIterator.hasNext()) {
            return CollectionsKt__IterablesKt.listOf(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (linesIterator.hasNext()) {
            arrayList.add(linesIterator.next());
        }
        return arrayList;
    }

    public static String padStart(int i, String str) {
        CharSequence charSequenceSubSequence;
        str.getClass();
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "Desired length ", " is less than zero."));
            return null;
        }
        if (i <= str.length()) {
            charSequenceSubSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            int length = i - str.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append('0');
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb.append((CharSequence) str);
            charSequenceSubSequence = sb;
        }
        return charSequenceSubSequence.toString();
    }

    public static DelimitedRangesSequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, boolean z, int i) {
        requireNonNegativeLimit(i);
        List listAsList = Arrays.asList(strArr);
        listAsList.getClass();
        return new DelimitedRangesSequence(charSequence, i, new StringsKt__StringsKt$$ExternalSyntheticLambda1((Object) listAsList, z, (byte) 0));
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        charSequence.getClass();
        charSequence2.getClass();
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!CharsKt.equals(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static String removePrefix(String str, String str2) {
        str.getClass();
        return startsWith((CharSequence) str, str2, false) ? str.substring(str2.length()) : str;
    }

    public static String removeSuffix(String str, String str2) {
        str.getClass();
        return endsWith$default(str, str2) ? str.substring(0, str.length() - str2.length()) : str;
    }

    public static String removeSurrounding(String str, String str2, String str3) {
        str.getClass();
        return (str.length() >= str3.length() + str2.length() && startsWith((CharSequence) str, str2, false) && endsWith$default(str, str3)) ? str.substring(str2.length(), str.length() - str3.length()) : str;
    }

    public static StringBuilder replaceRange(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        charSequence.getClass();
        charSequence2.getClass();
        if (i2 < i) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m(i2, "End index (", ") is less than start index (", i, ")."));
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence, 0, i);
        sb.append(charSequence2);
        sb.append(charSequence, i2, charSequence.length());
        return sb;
    }

    public static final void requireNonNegativeLimit(int i) {
        if (i >= 0) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Limit must be non-negative, but was "));
    }

    public static char single(String str) {
        str.getClass();
        int length = str.length();
        if (length == 0) {
            PathKt$$ExternalSyntheticBUOutline0.m$1("Char sequence is empty.");
            return (char) 0;
        }
        if (length == 1) {
            return str.charAt(0);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Char sequence has more than one element.");
        return (char) 0;
    }

    public static List split(CharSequence charSequence, String[] strArr, boolean z, int i) {
        charSequence.getClass();
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() > 0) {
                return split$StringsKt__StringsKt(i, charSequence, str, z);
            }
        }
        IndexingIterable indexingIterable = new IndexingIterable((byte) 2, rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, z, i));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(indexingIterable, 10));
        Iterator it = indexingIterable.iterator();
        while (true) {
            DelimitedRangesSequence.AnonymousClass1 anonymousClass1 = (DelimitedRangesSequence.AnonymousClass1) it;
            if (!anonymousClass1.hasNext()) {
                return arrayList;
            }
            arrayList.add(substring(charSequence, (IntRange) anonymousClass1.next()));
        }
    }

    public static final List split$StringsKt__StringsKt(int i, CharSequence charSequence, String str, boolean z) {
        requireNonNegativeLimit(i);
        int length = 0;
        int iIndexOf = indexOf(0, charSequence, str, z);
        if (iIndexOf == -1 || i == 1) {
            return CollectionsKt__IterablesKt.listOf(charSequence.toString());
        }
        boolean z2 = i > 0;
        int i2 = 10;
        if (z2 && i <= 10) {
            i2 = i;
        }
        ArrayList arrayList = new ArrayList(i2);
        do {
            arrayList.add(charSequence.subSequence(length, iIndexOf).toString());
            length = str.length() + iIndexOf;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            iIndexOf = indexOf(length, charSequence, str, z);
        } while (iIndexOf != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static List split$default(CharSequence charSequence, char[] cArr) {
        charSequence.getClass();
        if (cArr.length == 1) {
            return split$StringsKt__StringsKt(0, charSequence, String.valueOf(cArr[0]), false);
        }
        requireNonNegativeLimit(0);
        IndexingIterable indexingIterable = new IndexingIterable((byte) 2, new DelimitedRangesSequence(charSequence, 0, new URLParserKt$$ExternalSyntheticLambda0((byte) 10, cArr)));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(indexingIterable, 10));
        Iterator it = indexingIterable.iterator();
        while (true) {
            DelimitedRangesSequence.AnonymousClass1 anonymousClass1 = (DelimitedRangesSequence.AnonymousClass1) it;
            if (!anonymousClass1.hasNext()) {
                return arrayList;
            }
            arrayList.add(substring(charSequence, (IntRange) anonymousClass1.next()));
        }
    }

    public static boolean startsWith(CharSequence charSequence, String str, boolean z) {
        return (z || !(charSequence instanceof String)) ? regionMatchesImpl(charSequence, 0, str, 0, str.length(), z) : StringsKt__StringsJVMKt.startsWith((String) charSequence, str, false);
    }

    public static boolean startsWith$default(String str, char c) {
        str.getClass();
        return str.length() > 0 && CharsKt.equals(str.charAt(0), c, false);
    }

    public static final String substring(CharSequence charSequence, IntRange intRange) {
        charSequence.getClass();
        intRange.getClass();
        return charSequence.subSequence(intRange.first, intRange.last + 1).toString();
    }

    public static String substringAfter(char c, String str, String str2) {
        str.getClass();
        str2.getClass();
        int iIndexOf$default = indexOf$default(str, c, 0, 6);
        return iIndexOf$default == -1 ? str2 : str.substring(iIndexOf$default + 1, str.length());
    }

    public static String substringAfterLast(char c, String str, String str2) {
        str.getClass();
        str2.getClass();
        int iLastIndexOf$default = lastIndexOf$default(str, c, 0, 6);
        return iLastIndexOf$default == -1 ? str2 : str.substring(iLastIndexOf$default + 1, str.length());
    }

    public static String substringBefore$default(String str, char c) {
        str.getClass();
        str.getClass();
        int iIndexOf$default = indexOf$default(str, c, 0, 6);
        return iIndexOf$default == -1 ? str : str.substring(0, iIndexOf$default);
    }

    public static String substringBeforeLast$default(String str, char c) {
        int iLastIndexOf$default = lastIndexOf$default(str, c, 0, 6);
        return iLastIndexOf$default == -1 ? str : str.substring(0, iLastIndexOf$default);
    }

    public static CharSequence take(CharSequence charSequence, int i) {
        charSequence.getClass();
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Requested character count ", " is less than zero."));
            return null;
        }
        int length = charSequence.length();
        if (i > length) {
            i = length;
        }
        return charSequence.subSequence(0, i);
    }

    public static String trim(String str, char... cArr) {
        str.getClass();
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zContains = ArraysKt.contains(cArr, str.charAt(!z ? i : length));
            if (z) {
                if (!zContains) {
                    break;
                }
                length--;
            } else if (zContains) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1).toString();
    }

    public static CharSequence trimEnd(String str) {
        int length = str.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i = length - 1;
            if (!CharsKt.isWhitespace(str.charAt(length))) {
                return str.subSequence(0, length + 1);
            }
            if (i < 0) {
                return "";
            }
            length = i;
        }
    }

    public static CharSequence trimStart(String str) {
        str.getClass();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!CharsKt.isWhitespace(str.charAt(i))) {
                return str.subSequence(i, str.length());
            }
        }
        return "";
    }

    public static String substring(String str, IntRange intRange) {
        intRange.getClass();
        return str.substring(intRange.first, intRange.last + 1);
    }

    public static String substringBefore$default(String str, String str2) {
        str.getClass();
        str.getClass();
        int iIndexOf$default = indexOf$default(str, str2, 0, false, 6);
        return iIndexOf$default == -1 ? str : str.substring(0, iIndexOf$default);
    }

    public static String substringAfter(String str, String str2, String str3) {
        str.getClass();
        int iIndexOf$default = indexOf$default(str, str2, 0, false, 6);
        return iIndexOf$default == -1 ? str3 : str.substring(str2.length() + iIndexOf$default, str.length());
    }

    public static String substringAfterLast(String str, String str2, String str3) {
        int iLastIndexOf$default = lastIndexOf$default(str, str2, 6);
        return iLastIndexOf$default == -1 ? str3 : str.substring(str2.length() + iLastIndexOf$default, str.length());
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(i, charSequence, str, z);
    }

    public static String take(int i, String str) {
        str.getClass();
        if (i >= 0) {
            int length = str.length();
            if (i > length) {
                i = length;
            }
            return str.substring(0, i);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Requested character count ", " is less than zero."));
        return null;
    }

    public static boolean endsWith$default(CharSequence charSequence, char c) {
        charSequence.getClass();
        return charSequence.length() > 0 && CharsKt.equals(charSequence.charAt(charSequence.length() - 1), c, false);
    }

    public static int lastIndexOf$default(CharSequence charSequence, char c, int i, int i2) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        charSequence.getClass();
        return !(charSequence instanceof String) ? lastIndexOfAny(charSequence, new char[]{c}, i) : ((String) charSequence).lastIndexOf(c, i);
    }

    public static CharSequence trim(CharSequence charSequence) {
        charSequence.getClass();
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zIsWhitespace = CharsKt.isWhitespace(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!zIsWhitespace) {
                    break;
                }
                length--;
            } else if (zIsWhitespace) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, int i, int i2) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, strArr, false, i);
    }
}
