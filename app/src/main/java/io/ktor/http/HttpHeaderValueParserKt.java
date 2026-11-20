package io.ktor.http;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\b\u0010\u0005\u001a%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\b\u0010\u000b\u001a)\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0002*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\r0\f¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0011*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a#\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001aE\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u001c\u0010\u001c\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u001aj\b\u0012\u0004\u0012\u00020\u0003`\u001b0\u00122\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001a=\u0010 \u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u001c\u0010\u001f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\u001aj\b\u0012\u0004\u0012\u00020\u000e`\u001b0\u0012H\u0002¢\u0006\u0004\b \u0010!\u001a+\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00000\r2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b#\u0010$\u001a+\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00000\r2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b%\u0010$\u001a\u001b\u0010&\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b&\u0010'¨\u0006("}, d2 = {"", "header", "", "Lio/ktor/http/HeaderValue;", "parseAndSortHeader", "(Ljava/lang/String;)Ljava/util/List;", "parseAndSortContentTypeHeader", ContentType.Text.TYPE, "parseHeaderValue", "", "parametersOnly", "(Ljava/lang/String;Z)Ljava/util/List;", "", "Lkotlin/Pair;", "Lio/ktor/http/HeaderValueParam;", "toHeaderParamsList", "(Ljava/lang/Iterable;)Ljava/util/List;", "T", "Lkotlin/Lazy;", "valueOrEmpty", "(Lkotlin/Lazy;)Ljava/util/List;", "", "start", "end", "subtrim", "(Ljava/lang/String;II)Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "items", "parseHeaderValueItem", "(Ljava/lang/String;ILkotlin/Lazy;Z)I", "parameters", "parseHeaderValueParameter", "(Ljava/lang/String;ILkotlin/Lazy;)I", "value", "parseHeaderValueParameterValue", "(Ljava/lang/String;I)Lkotlin/Pair;", "parseHeaderValueParameterValueQuoted", "nextIsDelimiterOrEnd", "(Ljava/lang/String;I)Z", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpHeaderValueParserKt {
    private static final boolean nextIsDelimiterOrEnd(String str, int i) {
        int i2 = i + 1;
        while (i2 < str.length() && str.charAt(i2) == ' ') {
            i2++;
        }
        return i2 == str.length() || str.charAt(i2) == ';' || str.charAt(i2) == ',';
    }

    public static final List<HeaderValue> parseAndSortContentTypeHeader(String str) {
        List<HeaderValue> headerValue = parseHeaderValue(str);
        final Comparator comparator = new Comparator() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseAndSortContentTypeHeader$$inlined$compareByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return Double.valueOf(((HeaderValue) t2).getQuality()).compareTo(Double.valueOf(((HeaderValue) t).getQuality()));
            }
        };
        final Comparator comparator2 = new Comparator() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseAndSortContentTypeHeader$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                if (iCompare != 0) {
                    return iCompare;
                }
                ContentType.Companion companion = ContentType.INSTANCE;
                ContentType contentType = companion.parse(((HeaderValue) t).getValue());
                int i = Intrinsics.areEqual(contentType.getContentType(), "*") ? 2 : 0;
                if (Intrinsics.areEqual(contentType.getContentSubtype(), "*")) {
                    i++;
                }
                Integer numValueOf = Integer.valueOf(i);
                ContentType contentType2 = companion.parse(((HeaderValue) t2).getValue());
                int i2 = Intrinsics.areEqual(contentType2.getContentType(), "*") ? 2 : 0;
                if (Intrinsics.areEqual(contentType2.getContentSubtype(), "*")) {
                    i2++;
                }
                return numValueOf.compareTo(Integer.valueOf(i2));
            }
        };
        return CollectionsKt.sortedWith(headerValue, new Comparator() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseAndSortContentTypeHeader$$inlined$thenByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator2.compare(t, t2);
                return iCompare != 0 ? iCompare : Integer.valueOf(((HeaderValue) t2).getParams().size()).compareTo(Integer.valueOf(((HeaderValue) t).getParams().size()));
            }
        });
    }

    public static final List<HeaderValue> parseAndSortHeader(String str) {
        return CollectionsKt.sortedWith(parseHeaderValue(str), new Comparator() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseAndSortHeader$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return Double.valueOf(((HeaderValue) t2).getQuality()).compareTo(Double.valueOf(((HeaderValue) t).getQuality()));
            }
        });
    }

    public static final List<HeaderValue> parseHeaderValue(String str, boolean z) {
        if (str == null) {
            return EmptyList.INSTANCE;
        }
        Lazy lazy = ResultKt.lazy(LazyThreadSafetyMode.NONE, new Cookie$$ExternalSyntheticLambda1((byte) 16));
        int headerValueItem = 0;
        while (headerValueItem <= str.length() - 1) {
            headerValueItem = parseHeaderValueItem(str, headerValueItem, lazy, z);
        }
        return valueOrEmpty(lazy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList parseHeaderValue$lambda$0() {
        return new ArrayList();
    }

    private static final int parseHeaderValueItem(String str, int i, Lazy lazy, boolean z) {
        Lazy lazy2 = ResultKt.lazy(LazyThreadSafetyMode.NONE, new Cookie$$ExternalSyntheticLambda1((byte) 17));
        Integer numValueOf = z ? Integer.valueOf(i) : null;
        int headerValueParameter = i;
        while (headerValueParameter <= StringsKt.getLastIndex(str)) {
            char cCharAt = str.charAt(headerValueParameter);
            if (cCharAt == ',') {
                ((ArrayList) lazy.getValue()).add(new HeaderValue(subtrim(str, i, numValueOf != null ? numValueOf.intValue() : headerValueParameter), valueOrEmpty(lazy2)));
                return headerValueParameter + 1;
            }
            if (cCharAt != ';') {
                headerValueParameter = z ? parseHeaderValueParameter(str, headerValueParameter, lazy2) : headerValueParameter + 1;
            } else {
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(headerValueParameter);
                }
                headerValueParameter = parseHeaderValueParameter(str, headerValueParameter + 1, lazy2);
            }
        }
        ((ArrayList) lazy.getValue()).add(new HeaderValue(subtrim(str, i, numValueOf != null ? numValueOf.intValue() : headerValueParameter), valueOrEmpty(lazy2)));
        return headerValueParameter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList parseHeaderValueItem$lambda$0() {
        return new ArrayList();
    }

    private static final int parseHeaderValueParameter(String str, int i, Lazy lazy) {
        int i2 = i;
        while (i2 <= StringsKt.getLastIndex(str)) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == ',' || cCharAt == ';') {
                parseHeaderValueParameter$addParam(lazy, str, i, i2, "");
                return i2;
            }
            if (cCharAt == '=') {
                Pair headerValueParameterValue = parseHeaderValueParameterValue(str, i2 + 1);
                int iIntValue = ((Number) headerValueParameterValue.first).intValue();
                parseHeaderValueParameter$addParam(lazy, str, i, i2, (String) headerValueParameterValue.second);
                return iIntValue;
            }
            i2++;
        }
        parseHeaderValueParameter$addParam(lazy, str, i, i2, "");
        return i2;
    }

    private static final void parseHeaderValueParameter$addParam(Lazy lazy, String str, int i, int i2, String str2) {
        String strSubtrim = subtrim(str, i, i2);
        if (strSubtrim.length() == 0) {
            return;
        }
        ((ArrayList) lazy.getValue()).add(new HeaderValueParam(strSubtrim, str2));
    }

    private static final Pair parseHeaderValueParameterValue(String str, int i) {
        if (str.length() == i) {
            return new Pair(Integer.valueOf(i), "");
        }
        if (str.charAt(i) == '\"') {
            return parseHeaderValueParameterValueQuoted(str, i + 1);
        }
        int i2 = i;
        while (i2 <= str.length() - 1) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == ',' || cCharAt == ';') {
                return new Pair(Integer.valueOf(i2), subtrim(str, i, i2));
            }
            i2++;
        }
        return new Pair(Integer.valueOf(i2), subtrim(str, i, i2));
    }

    private static final Pair parseHeaderValueParameterValueQuoted(String str, int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = i;
        while (i2 <= StringsKt.getLastIndex(str)) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '\"' && nextIsDelimiterOrEnd(str, i2)) {
                return new Pair(Integer.valueOf(i2 + 1), sb.toString());
            }
            if (cCharAt != '\\' || i2 >= str.length() - 1) {
                sb.append(cCharAt);
                i2++;
            } else {
                sb.append(str.charAt(i2 + 1));
                i2 += 2;
            }
        }
        return new Pair(Integer.valueOf(i2), str.substring(i - 1, i2));
    }

    private static final String subtrim(String str, int i, int i2) {
        return StringsKt.trim(str.substring(i, i2)).toString();
    }

    public static final List<HeaderValueParam> toHeaderParamsList(Iterable<Pair> iterable) {
        iterable.getClass();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Pair pair : iterable) {
            arrayList.add(new HeaderValueParam((String) pair.first, (String) pair.second));
        }
        return arrayList;
    }

    private static final <T> List<T> valueOrEmpty(Lazy lazy) {
        return lazy.isInitialized() ? (List) lazy.getValue() : EmptyList.INSTANCE;
    }

    public static final List<HeaderValue> parseHeaderValue(String str) {
        return parseHeaderValue(str, false);
    }
}
