package okhttp3.internal.http;

import io.ktor.client.utils.CacheControl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.ByteString;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class HttpHeaders {
    static {
        ByteString byteString = ByteString.EMPTY;
        Path.Companion.encodeUtf8("\"\\");
        Path.Companion.encodeUtf8("\t ,=");
    }

    public static final boolean promisesBody(Response response) {
        if (Intrinsics.areEqual(response.request.method, "HEAD")) {
            return false;
        }
        int i = response.code;
        return (((i >= 100 && i < 200) || i == 204 || i == 304) && _UtilJvmKt.headersContentLength(response) == -1 && !"chunked".equalsIgnoreCase(Response.header$default(io.ktor.http.HttpHeaders.TransferEncoding, response))) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:18:0x0071  */
    public static final void receiveHeaders(Protocol.Companion companion, HttpUrl httpUrl, Headers headers) {
        List listUnmodifiableList;
        Cookie cookie;
        Cookie cookie2;
        String strSubstring;
        companion.getClass();
        httpUrl.getClass();
        headers.getClass();
        if (companion == Protocol.Companion.NO_COOKIES) {
            return;
        }
        Pattern pattern = Cookie.YEAR_PATTERN;
        List listValues = headers.values(io.ktor.http.HttpHeaders.SetCookie);
        int size = listValues.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            String str = (String) listValues.get(i);
            str.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            char c = ';';
            int iDelimiterOffset$default = _UtilCommonKt.delimiterOffset$default(str, ';', 0, 0, 6);
            char c2 = '=';
            int iDelimiterOffset$default2 = _UtilCommonKt.delimiterOffset$default(str, '=', 0, iDelimiterOffset$default, 2);
            if (iDelimiterOffset$default2 == iDelimiterOffset$default) {
                cookie = null;
            } else {
                int iIndexOfFirstNonAsciiWhitespace = _UtilCommonKt.indexOfFirstNonAsciiWhitespace(0, iDelimiterOffset$default2, str);
                String strSubstring2 = str.substring(iIndexOfFirstNonAsciiWhitespace, _UtilCommonKt.indexOfLastNonAsciiWhitespace(iIndexOfFirstNonAsciiWhitespace, iDelimiterOffset$default2, str));
                if (strSubstring2.length() != 0 && _UtilCommonKt.indexOfControlOrNonAscii(strSubstring2) == -1) {
                    int iIndexOfFirstNonAsciiWhitespace2 = _UtilCommonKt.indexOfFirstNonAsciiWhitespace(iDelimiterOffset$default2 + 1, iDelimiterOffset$default, str);
                    String strSubstring3 = str.substring(iIndexOfFirstNonAsciiWhitespace2, _UtilCommonKt.indexOfLastNonAsciiWhitespace(iIndexOfFirstNonAsciiWhitespace2, iDelimiterOffset$default, str));
                    if (_UtilCommonKt.indexOfControlOrNonAscii(strSubstring3) == -1) {
                        int i2 = iDelimiterOffset$default + 1;
                        int length = str.length();
                        long j = 253402300799999L;
                        boolean z = false;
                        boolean z2 = false;
                        boolean z3 = false;
                        long expires = 253402300799999L;
                        String str2 = null;
                        String strSubstring4 = null;
                        long j2 = -1;
                        boolean z4 = true;
                        String str3 = null;
                        while (true) {
                            if (i2 >= length) {
                                if (j2 == Long.MIN_VALUE) {
                                    j = Long.MIN_VALUE;
                                } else if (j2 != -1) {
                                    long j3 = jCurrentTimeMillis + (j2 <= 9223372036854775L ? j2 * 1000 : Long.MAX_VALUE);
                                    if (j3 >= jCurrentTimeMillis && j3 <= 253402300799999L) {
                                        j = j3;
                                    }
                                } else {
                                    j = expires;
                                }
                                String str4 = httpUrl.host;
                                if (str2 != null) {
                                    if (!Intrinsics.areEqual(str4, str2) && (!StringsKt__StringsJVMKt.endsWith(str4, str2, false) || str4.charAt((str4.length() - str2.length()) - 1) != '.' || _HostnamesCommonKt.VERIFY_AS_IP_ADDRESS.matches(str4))) {
                                        cookie2 = null;
                                    }
                                    cookie = cookie2;
                                    break;
                                }
                                str2 = str4;
                                if (str4.length() == str2.length() || PublicSuffixDatabase.instance.getEffectiveTldPlusOne(str2) != null) {
                                    if (strSubstring4 == null || !StringsKt__StringsJVMKt.startsWith(strSubstring4, "/", false)) {
                                        String strEncodedPath = httpUrl.encodedPath();
                                        int iLastIndexOf$default = StringsKt.lastIndexOf$default(strEncodedPath, '/', 0, 6);
                                        strSubstring4 = iLastIndexOf$default != 0 ? strEncodedPath.substring(0, iLastIndexOf$default) : "/";
                                    }
                                    cookie2 = new Cookie(strSubstring2, strSubstring3, j, str2, strSubstring4, z, z2, z3, z4, str3);
                                } else {
                                    cookie2 = null;
                                }
                                cookie = cookie2;
                                break;
                            }
                            int iDelimiterOffset = _UtilCommonKt.delimiterOffset(str, i2, length, c);
                            int iDelimiterOffset2 = _UtilCommonKt.delimiterOffset(str, i2, iDelimiterOffset, c2);
                            int iIndexOfFirstNonAsciiWhitespace3 = _UtilCommonKt.indexOfFirstNonAsciiWhitespace(i2, iDelimiterOffset2, str);
                            String strSubstring5 = str.substring(iIndexOfFirstNonAsciiWhitespace3, _UtilCommonKt.indexOfLastNonAsciiWhitespace(iIndexOfFirstNonAsciiWhitespace3, iDelimiterOffset2, str));
                            if (iDelimiterOffset2 < iDelimiterOffset) {
                                int iIndexOfFirstNonAsciiWhitespace4 = _UtilCommonKt.indexOfFirstNonAsciiWhitespace(iDelimiterOffset2 + 1, iDelimiterOffset, str);
                                strSubstring = str.substring(iIndexOfFirstNonAsciiWhitespace4, _UtilCommonKt.indexOfLastNonAsciiWhitespace(iIndexOfFirstNonAsciiWhitespace4, iDelimiterOffset, str));
                            } else {
                                strSubstring = "";
                            }
                            if (strSubstring5.equalsIgnoreCase("expires")) {
                                try {
                                    expires = RegexKt.parseExpires(strSubstring.length(), strSubstring);
                                    z3 = true;
                                } catch (NumberFormatException | IllegalArgumentException unused) {
                                }
                            } else if (strSubstring5.equalsIgnoreCase(CacheControl.MAX_AGE)) {
                                try {
                                    j2 = Long.parseLong(strSubstring);
                                    if (j2 <= 0) {
                                        j2 = Long.MIN_VALUE;
                                    }
                                } catch (NumberFormatException e) {
                                    Pattern patternCompile = Pattern.compile("-?\\d+");
                                    patternCompile.getClass();
                                    if (!patternCompile.matcher(strSubstring).matches()) {
                                        throw e;
                                    }
                                    j2 = StringsKt__StringsJVMKt.startsWith(strSubstring, "-", false) ? Long.MIN_VALUE : Long.MAX_VALUE;
                                }
                                z3 = true;
                            } else if (strSubstring5.equalsIgnoreCase("domain")) {
                                if (StringsKt__StringsJVMKt.endsWith(strSubstring, ".", false)) {
                                    throw new IllegalArgumentException("Failed requirement.");
                                }
                                String canonicalHost = _HostnamesCommonKt.toCanonicalHost(StringsKt.removePrefix(strSubstring, "."));
                                if (canonicalHost == null) {
                                    throw new IllegalArgumentException();
                                }
                                str2 = canonicalHost;
                                z4 = false;
                            } else if (strSubstring5.equalsIgnoreCase("path")) {
                                strSubstring4 = strSubstring;
                            } else if (strSubstring5.equalsIgnoreCase("secure")) {
                                z = true;
                            } else if (strSubstring5.equalsIgnoreCase("httponly")) {
                                z2 = true;
                            } else if (strSubstring5.equalsIgnoreCase("samesite")) {
                                str3 = strSubstring;
                            }
                            i2 = iDelimiterOffset + 1;
                            c = ';';
                            c2 = '=';
                        }
                    } else {
                        cookie = null;
                    }
                } else {
                    cookie = null;
                }
            }
            if (cookie != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(cookie);
            }
        }
        if (arrayList != null) {
            listUnmodifiableList = Collections.unmodifiableList(arrayList);
            listUnmodifiableList.getClass();
        } else {
            listUnmodifiableList = null;
        }
        if (listUnmodifiableList == null) {
            listUnmodifiableList = EmptyList.INSTANCE;
        }
        listUnmodifiableList.isEmpty();
    }
}
