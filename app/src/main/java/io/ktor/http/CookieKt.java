package io.ktor.http;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.events.Events$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.TextKt;
import io.ktor.util.date.GMTDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.TransformingSequence;
import kotlin.text.CharsKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.MatcherMatchResult;
import kotlin.text.MatcherMatchResult$groups$1;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a1\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\b0\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\n\u001a1\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\b0\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\r\u001a+\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0013\u001a\u008d\u0001\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000e2\b\b\u0002\u0010\"\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010#\u001a\u001d\u0010$\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b$\u0010%\u001a\u001d\u0010'\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b'\u0010%\u001a\u0013\u0010(\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b(\u0010)\u001a\u0013\u0010+\u001a\u00020\u0005*\u00020*H\u0002¢\u0006\u0004\b+\u0010,\u001a*\u0010.\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010-2\u0006\u0010\u0018\u001a\u00020\u0017H\u0082\b¢\u0006\u0004\b.\u0010/\u001a\"\u00100\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010-H\u0082\b¢\u0006\u0004\b0\u00101\u001a \u00102\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0005H\u0082\b¢\u0006\u0004\b2\u00103\u001a\"\u00104\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0000H\u0082\b¢\u0006\u0004\b4\u00105\u001a\u0015\u00106\u001a\u0004\u0018\u00010\u0019*\u00020\u0000H\u0002¢\u0006\u0004\b6\u00107\"\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u0000088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:\"\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=\"\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020*088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010:¨\u0006?"}, d2 = {"", "cookiesHeader", "Lio/ktor/http/Cookie;", "parseServerSetCookieHeader", "(Ljava/lang/String;)Lio/ktor/http/Cookie;", "", "skipEscaped", "Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "clientCookies", "(Ljava/lang/String;Z)Lkotlin/sequences/Sequence;", "", "parseClientCookies", "(Ljava/lang/String;Z)Ljava/util/List;", "", "parseClientCookiesHeader", "(Ljava/lang/String;Z)Ljava/util/Map;", "cookie", "renderSetCookieHeader", "(Lio/ktor/http/Cookie;)Ljava/lang/String;", "renderCookieHeader", ContentDisposition.Parameters.Name, "value", "Lio/ktor/http/CookieEncoding;", "encoding", "", "maxAge", "Lio/ktor/util/date/GMTDate;", "expires", "domain", "path", "secure", "httpOnly", "extensions", "includeEncoding", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/CookieEncoding;Ljava/lang/Integer;Lio/ktor/util/date/GMTDate;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;Z)Ljava/lang/String;", "encodeCookieValue", "(Ljava/lang/String;Lio/ktor/http/CookieEncoding;)Ljava/lang/String;", "encodedValue", "decodeCookieValue", "assertCookieName", "(Ljava/lang/String;)Ljava/lang/String;", "", "shouldEscapeInCookies", "(C)Z", "", "cookiePart", "(Ljava/lang/String;Ljava/lang/Object;Lio/ktor/http/CookieEncoding;)Ljava/lang/String;", "cookiePartUnencoded", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;", "cookiePartFlag", "(Ljava/lang/String;Z)Ljava/lang/String;", "cookiePartExt", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "toMaxAgeOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "", "loweredPartNames", "Ljava/util/Set;", "Lkotlin/text/Regex;", "clientCookieHeaderPattern", "Lkotlin/text/Regex;", "cookieCharsShouldBeEscaped", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CookieKt {
    private static final Set<String> loweredPartNames = ArraysKt.toSet(new String[]{io.ktor.client.utils.CacheControl.MAX_AGE, "expires", "domain", "path", "secure", "httponly", "$x-enc"});
    private static final Regex clientCookieHeaderPattern = new Regex("(^|;)\\s*([^;=\\{\\}\\s]+)\\s*(=\\s*(\"[^\"]*\"|[^;]*))?");
    private static final Set<Character> cookieCharsShouldBeEscaped = ArraysKt.toSet(new Character[]{';', ',', '\"'});

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CookieEncoding.values().length];
            try {
                iArr[CookieEncoding.RAW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CookieEncoding.DQUOTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CookieEncoding.BASE64_ENCODING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CookieEncoding.URI_ENCODING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final String assertCookieName(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (shouldEscapeInCookies(str.charAt(i))) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m("Cookie name is not valid: ", str));
                return null;
            }
        }
        return str;
    }

    private static final Sequence clientCookies(String str, boolean z) {
        return new TransformingSequence(new FilteringSequence(new TransformingSequence(Regex.findAll$default(clientCookieHeaderPattern, str), new Events$$ExternalSyntheticLambda0((byte) 27)), true, new CookieKt$$ExternalSyntheticLambda3((byte) 0, z)), new Events$$ExternalSyntheticLambda0((byte) 28));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair clientCookies$lambda$0(MatchResult matchResult) {
        matchResult.getClass();
        MatcherMatchResult$groups$1 matcherMatchResult$groups$1 = ((MatcherMatchResult) matchResult).groups;
        MatchGroup matchGroup = matcherMatchResult$groups$1.get(2);
        String str = matchGroup != null ? matchGroup.value : "";
        MatchGroup matchGroup2 = matcherMatchResult$groups$1.get(4);
        return new Pair(str, matchGroup2 != null ? matchGroup2.value : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clientCookies$lambda$1(boolean z, Pair pair) {
        pair.getClass();
        return (z && StringsKt__StringsJVMKt.startsWith((String) pair.first, "$", false)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair clientCookies$lambda$2(Pair pair) {
        pair.getClass();
        String str = (String) pair.second;
        if (!StringsKt__StringsJVMKt.startsWith(str, "\"", false) || !StringsKt__StringsJVMKt.endsWith(str, "\"", false)) {
            return pair;
        }
        str.getClass();
        return Pair.copy$default(pair, null, StringsKt.removeSurrounding(str, "\"", "\""), 1);
    }

    private static final String cookiePart(String str, Object obj, CookieEncoding cookieEncoding) {
        if (obj == null) {
            return "";
        }
        return str + '=' + encodeCookieValue(obj.toString(), cookieEncoding);
    }

    private static final String cookiePartExt(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        return str + '=' + encodeCookieValue(str2.toString(), CookieEncoding.RAW);
    }

    private static final String cookiePartFlag(String str, boolean z) {
        return z ? str : "";
    }

    private static final String cookiePartUnencoded(String str, Object obj) {
        if (obj == null) {
            return "";
        }
        return str + '=' + obj;
    }

    public static final String decodeCookieValue(String str, CookieEncoding cookieEncoding) {
        str.getClass();
        cookieEncoding.getClass();
        int i = WhenMappings.$EnumSwitchMapping$0[cookieEncoding.ordinal()];
        if (i == 1 || i == 2) {
            if (!StringsKt__StringsJVMKt.startsWith(StringsKt.trimStart(str).toString(), "\"", false) || !StringsKt__StringsJVMKt.endsWith(StringsKt.trimEnd(str).toString(), "\"", false)) {
                return str;
            }
            String string = StringsKt.trim(str).toString();
            string.getClass();
            return StringsKt.removeSurrounding(string, "\"", "\"");
        }
        if (i == 3) {
            return StringsKt__StringsJVMKt.decodeToString(Base64.decode$default(Base64.Default, str, 0, 6));
        }
        if (i == 4) {
            return CodecsKt.decodeURLQueryComponent$default(str, 0, 0, true, null, 11, null);
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return null;
    }

    public static final String encodeCookieValue(String str, CookieEncoding cookieEncoding) {
        str.getClass();
        cookieEncoding.getClass();
        int i = WhenMappings.$EnumSwitchMapping$0[cookieEncoding.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return Base64.encode$default(Base64.Default, StringsKt__StringsJVMKt.encodeToByteArray(str));
                }
                if (i == 4) {
                    return CodecsKt.encodeURLParameter(str, true);
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            }
            if (StringsKt.contains$default(str, '\"')) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("The cookie value contains characters that cannot be encoded in DQUOTES format. Consider URL_ENCODING mode");
                return null;
            }
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (shouldEscapeInCookies(str.charAt(i2))) {
                    return Format$$ExternalSyntheticOutline0.m('\"', "\"", str);
                }
            }
        }
        return str;
    }

    public static final List<Pair> parseClientCookies(String str, boolean z) {
        str.getClass();
        return SequencesKt.toList(clientCookies(str, z));
    }

    public static /* synthetic */ List parseClientCookies$default(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return parseClientCookies(str, z);
    }

    public static final Map<String, String> parseClientCookiesHeader(String str, boolean z) {
        str.getClass();
        Sequence<Pair> sequenceClientCookies = clientCookies(str, z);
        sequenceClientCookies.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : sequenceClientCookies) {
            linkedHashMap.put(pair.first, pair.second);
        }
        return MapsKt__MapsKt.optimizeReadOnlyMap(linkedHashMap);
    }

    public static /* synthetic */ Map parseClientCookiesHeader$default(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return parseClientCookiesHeader(str, z);
    }

    public static final Cookie parseServerSetCookieHeader(String str) {
        Map.Entry entry;
        CookieEncoding cookieEncodingValueOf;
        Object failure;
        str.getClass();
        Map<String, String> clientCookiesHeader = parseClientCookiesHeader(str, false);
        Iterator<T> it = clientCookiesHeader.entrySet().iterator();
        do {
            if (!it.hasNext()) {
                PathKt$$ExternalSyntheticBUOutline0.m$1("Collection contains no element matching the predicate.");
                return null;
            }
            entry = (Map.Entry) it.next();
        } while (StringsKt__StringsJVMKt.startsWith((String) entry.getKey(), "$", false));
        String str2 = clientCookiesHeader.get("$x-enc");
        if (str2 == null || (cookieEncodingValueOf = CookieEncoding.valueOf(str2)) == null) {
            cookieEncodingValueOf = CookieEncoding.RAW;
        }
        CookieEncoding cookieEncoding = cookieEncodingValueOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.mapCapacity(clientCookiesHeader.size()));
        Iterator<T> it2 = clientCookiesHeader.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            linkedHashMap.put(TextKt.toLowerCasePreservingASCIIRules((String) entry2.getKey()), entry2.getValue());
        }
        String str3 = (String) entry.getKey();
        String strDecodeCookieValue = decodeCookieValue((String) entry.getValue(), cookieEncoding);
        String str4 = (String) linkedHashMap.get(io.ktor.client.utils.CacheControl.MAX_AGE);
        Integer maxAgeOrNull = str4 != null ? toMaxAgeOrNull(str4) : null;
        try {
            String str5 = (String) linkedHashMap.get("expires");
            failure = str5 != null ? DateUtilsKt.fromCookieToGmtDate(str5) : null;
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        GMTDate gMTDate = (GMTDate) (failure instanceof Result.Failure ? null : failure);
        String str6 = (String) linkedHashMap.get("domain");
        String str7 = (String) linkedHashMap.get("path");
        boolean zContainsKey = linkedHashMap.containsKey("secure");
        boolean zContainsKey2 = linkedHashMap.containsKey("httponly");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, String> entry3 : clientCookiesHeader.entrySet()) {
            String key = entry3.getKey();
            if (!loweredPartNames.contains(TextKt.toLowerCasePreservingASCIIRules(key)) && !Intrinsics.areEqual(key, entry.getKey())) {
                linkedHashMap2.put(entry3.getKey(), entry3.getValue());
            }
        }
        return new Cookie(str3, strDecodeCookieValue, cookieEncoding, maxAgeOrNull, gMTDate, str6, str7, zContainsKey, zContainsKey2, linkedHashMap2);
    }

    public static final String renderCookieHeader(Cookie cookie) {
        cookie.getClass();
        return cookie.getName() + '=' + encodeCookieValue(cookie.getValue(), cookie.getEncoding());
    }

    public static final String renderSetCookieHeader(String str, String str2, CookieEncoding cookieEncoding, Integer num, GMTDate gMTDate, String str3, String str4, boolean z, boolean z2, Map<String, String> map, boolean z3) {
        str.getClass();
        str2.getClass();
        cookieEncoding.getClass();
        map.getClass();
        String str5 = assertCookieName(str) + '=' + encodeCookieValue(str2.toString(), cookieEncoding);
        String str6 = "";
        String str7 = num != null ? "Max-Age=" + num : "";
        String httpDate = gMTDate != null ? DateUtilsKt.toHttpDate(gMTDate) : null;
        String str8 = httpDate != null ? "Expires=" + ((Object) httpDate) : "";
        CookieEncoding cookieEncoding2 = CookieEncoding.RAW;
        List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{str5, str7, str8, str3 != null ? "Domain=" + encodeCookieValue(str3.toString(), cookieEncoding2) : "", str4 != null ? "Path=" + encodeCookieValue(str4.toString(), cookieEncoding2) : "", z ? "Secure" : "", z2 ? "HttpOnly" : ""});
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String strAssertCookieName = assertCookieName(entry.getKey());
            String value = entry.getValue();
            if (value != null) {
                strAssertCookieName = strAssertCookieName + '=' + encodeCookieValue(value.toString(), CookieEncoding.RAW);
            }
            arrayList.add(strAssertCookieName);
        }
        ArrayList arrayListPlus = CollectionsKt.plus((Iterable) arrayList, (Collection) listListOf);
        if (z3) {
            String strName = cookieEncoding.name();
            str6 = strName == null ? "$x-enc" : "$x-enc=" + encodeCookieValue(strName.toString(), CookieEncoding.RAW);
        }
        ArrayList arrayListPlus2 = CollectionsKt.plus(str6, arrayListPlus);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayListPlus2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListPlus2.get(i);
            i++;
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList2, "; ", null, null, null, 62);
    }

    public static /* synthetic */ String renderSetCookieHeader$default(String str, String str2, CookieEncoding cookieEncoding, Integer num, GMTDate gMTDate, String str3, String str4, boolean z, boolean z2, Map map, boolean z3, int i, Object obj) {
        return renderSetCookieHeader(str, str2, (i & 4) != 0 ? CookieEncoding.URI_ENCODING : cookieEncoding, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : gMTDate, (i & 32) != 0 ? null : str3, (i & 64) == 0 ? str4 : null, (i & 128) != 0 ? false : z, (i & 256) == 0 ? z2 : false, (i & 512) != 0 ? EmptyMap.INSTANCE : map, (i & 1024) != 0 ? true : z3);
    }

    private static final boolean shouldEscapeInCookies(char c) {
        return CharsKt.isWhitespace(c) || Intrinsics.compare((int) c, 32) < 0 || cookieCharsShouldBeEscaped.contains(Character.valueOf(c));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    private static final Integer toMaxAgeOrNull(String str) {
        int i;
        ?? StartsWith$default = StringsKt.startsWith$default(str, '-');
        if (StartsWith$default > StringsKt.getLastIndex(str)) {
            return null;
        }
        int length = str.length() - 1;
        if (StartsWith$default <= length) {
            int i2 = StartsWith$default == true ? 1 : 0;
            while (true) {
                char cCharAt = str.charAt(i2);
                if ('0' <= cCharAt && cCharAt < ':') {
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                } else {
                    return null;
                }
            }
        }
        if (StartsWith$default == 1) {
            return 0;
        }
        Long longOrNull = StringsKt__StringsJVMKt.toLongOrNull(10, str);
        if (longOrNull != null) {
            long jLongValue = longOrNull.longValue();
            if (jLongValue > 2147483647L) {
                jLongValue = 2147483647L;
            }
            i = (int) jLongValue;
        } else {
            i = Integer.MAX_VALUE;
        }
        return Integer.valueOf(i);
    }

    public static final String renderSetCookieHeader(Cookie cookie) {
        cookie.getClass();
        return renderSetCookieHeader$default(cookie.getName(), cookie.getValue(), cookie.getEncoding(), cookie.getMaxAgeInt(), cookie.getExpires(), cookie.getDomain(), cookie.getPath(), cookie.getSecure(), cookie.getHttpOnly(), cookie.getExtensions(), false, 1024, null);
    }
}
