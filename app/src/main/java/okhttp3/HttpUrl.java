package okhttp3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.websocket.ControlFramesKt;
import java.io.EOFException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.url._UrlKt;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class HttpUrl {
    public final String fragment;
    public final String host;
    public final String password;
    public final int port;
    public final List queryNamesAndValues;
    public final String scheme;
    public final String url;
    public final String username;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder {
        public String encodedFragment;
        public ArrayList encodedQueryNamesAndValues;
        public String host;
        public String scheme;
        public String encodedUsername = "";
        public String encodedPassword = "";
        public int port = -1;
        public final ArrayList encodedPathSegments = CollectionsKt__IterablesKt.mutableListOf("");

        public static ArrayList toQueryNamesAndValues(String str) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int iIndexOf$default = StringsKt.indexOf$default(str, '&', i, 4);
                if (iIndexOf$default == -1) {
                    iIndexOf$default = str.length();
                }
                int iIndexOf$default2 = StringsKt.indexOf$default(str, '=', i, 4);
                if (iIndexOf$default2 == -1 || iIndexOf$default2 > iIndexOf$default) {
                    arrayList.add(str.substring(i, iIndexOf$default));
                    arrayList.add(null);
                } else {
                    arrayList.add(str.substring(i, iIndexOf$default2));
                    arrayList.add(str.substring(iIndexOf$default2 + 1, iIndexOf$default));
                }
                i = iIndexOf$default + 1;
            }
            return arrayList;
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("scheme == null");
                return null;
            }
            String strPercentDecode$default = _UrlKt.percentDecode$default(0, 0, 7, this.encodedUsername);
            String strPercentDecode$default2 = _UrlKt.percentDecode$default(0, 0, 7, this.encodedPassword);
            String str2 = this.host;
            if (str2 == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("host == null");
                return null;
            }
            int iEffectivePort = effectivePort();
            ArrayList arrayList2 = this.encodedPathSegments;
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                arrayList3.add(_UrlKt.percentDecode$default(0, 0, 7, (String) obj));
            }
            ArrayList arrayList4 = this.encodedQueryNamesAndValues;
            if (arrayList4 != null) {
                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4, 10));
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList4.get(i2);
                    i2++;
                    String str3 = (String) obj2;
                    arrayList.add(str3 != null ? _UrlKt.percentDecode$default(0, 0, 3, str3) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new HttpUrl(str, strPercentDecode$default, strPercentDecode$default2, str2, iEffectivePort, arrayList, str4 != null ? _UrlKt.percentDecode$default(0, 0, 7, str4) : null, toString());
        }

        public final int effectivePort() {
            int i = this.port;
            if (i != -1) {
                return i;
            }
            String str = this.scheme;
            str.getClass();
            if (str.equals("http")) {
                return 80;
            }
            return str.equals("https") ? 443 : -1;
        }

        /* JADX WARN: Code duplicated, block: B:4:0x0025  */
        public final void parse$okhttp(HttpUrl httpUrl, String str) throws EOFException {
            int i;
            int i2;
            int iDelimiterOffset;
            int i3;
            int i4;
            char cCharAt;
            byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
            int iIndexOfFirstNonAsciiWhitespace = _UtilCommonKt.indexOfFirstNonAsciiWhitespace(0, str.length(), str);
            int iIndexOfLastNonAsciiWhitespace = _UtilCommonKt.indexOfLastNonAsciiWhitespace(iIndexOfFirstNonAsciiWhitespace, str.length(), str);
            byte b = -1;
            if (iIndexOfLastNonAsciiWhitespace - iIndexOfFirstNonAsciiWhitespace >= 2) {
                char cCharAt2 = str.charAt(iIndexOfFirstNonAsciiWhitespace);
                if ((Intrinsics.compare((int) cCharAt2, 97) >= 0 && Intrinsics.compare((int) cCharAt2, 122) <= 0) || (Intrinsics.compare((int) cCharAt2, 65) >= 0 && Intrinsics.compare((int) cCharAt2, 90) <= 0)) {
                    i = iIndexOfFirstNonAsciiWhitespace + 1;
                    while (true) {
                        if (i < iIndexOfLastNonAsciiWhitespace) {
                            char cCharAt3 = str.charAt(i);
                            if (('a' > cCharAt3 || cCharAt3 >= '{') && (('A' > cCharAt3 || cCharAt3 >= '[') && !(('0' <= cCharAt3 && cCharAt3 < ':') || cCharAt3 == '+' || cCharAt3 == '-' || cCharAt3 == '.'))) {
                                if (cCharAt3 == ':') {
                                    break;
                                } else {
                                    break;
                                }
                            }
                            i++;
                        }
                        i = -1;
                        break;
                    }
                } else {
                    i = -1;
                    break;
                }
            } else {
                i = -1;
                break;
            }
            int i5 = 1;
            if (i != -1) {
                if (StringsKt__StringsJVMKt.startsWith(iIndexOfFirstNonAsciiWhitespace, str, "https:", true)) {
                    this.scheme = "https";
                    iIndexOfFirstNonAsciiWhitespace += 6;
                } else {
                    if (!StringsKt__StringsJVMKt.startsWith(iIndexOfFirstNonAsciiWhitespace, str, "http:", true)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, i) + '\'');
                    }
                    this.scheme = "http";
                    iIndexOfFirstNonAsciiWhitespace += 5;
                }
            } else {
                if (httpUrl == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Expected URL scheme 'http' or 'https' but no scheme was found for ".concat(str.length() > 6 ? StringsKt.take(6, str).concat("...") : str));
                    return;
                }
                this.scheme = httpUrl.scheme;
            }
            int i6 = iIndexOfFirstNonAsciiWhitespace;
            int i7 = 0;
            while (true) {
                i2 = i5;
                if (i6 >= iIndexOfLastNonAsciiWhitespace || !((cCharAt = str.charAt(i6)) == '/' || cCharAt == '\\')) {
                    break;
                }
                i7++;
                i6++;
                i5 = i2;
            }
            ArrayList arrayList = this.encodedPathSegments;
            byte b2 = 35;
            if (i7 >= 2 || httpUrl == null || !Intrinsics.areEqual(httpUrl.scheme, this.scheme)) {
                int i8 = iIndexOfFirstNonAsciiWhitespace + i7;
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    iDelimiterOffset = _UtilCommonKt.delimiterOffset(i8, iIndexOfLastNonAsciiWhitespace, str, "@/\\?#");
                    byte bCharAt = iDelimiterOffset != iIndexOfLastNonAsciiWhitespace ? str.charAt(iDelimiterOffset) : b;
                    if (bCharAt == b || bCharAt == b2 || bCharAt == 47 || bCharAt == 92 || bCharAt == 63) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (i9 == 0) {
                            int iDelimiterOffset2 = _UtilCommonKt.delimiterOffset(str, i8, iDelimiterOffset, ':');
                            String strCanonicalize$default = _UrlKt.canonicalize$default(str, i8, iDelimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", 112);
                            if (i10 != 0) {
                                strCanonicalize$default = IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(this.encodedUsername), "%40", strCanonicalize$default);
                            }
                            this.encodedUsername = strCanonicalize$default;
                            if (iDelimiterOffset2 != iDelimiterOffset) {
                                this.encodedPassword = _UrlKt.canonicalize$default(str, iDelimiterOffset2 + 1, iDelimiterOffset, " \"':;<=>@[]^`{}|/\\?#", 112);
                                i9 = i2;
                            }
                            i10 = i2;
                        } else {
                            this.encodedPassword += "%40" + _UrlKt.canonicalize$default(str, i8, iDelimiterOffset, " \"':;<=>@[]^`{}|/\\?#", 112);
                        }
                        i8 = iDelimiterOffset + 1;
                        b2 = 35;
                        b = -1;
                    }
                }
                int i11 = i8;
                while (true) {
                    if (i11 < iDelimiterOffset) {
                        char cCharAt4 = str.charAt(i11);
                        if (cCharAt4 == ':') {
                            break;
                        }
                        if (cCharAt4 == '[') {
                            do {
                                i11++;
                                if (i11 >= iDelimiterOffset) {
                                    break;
                                }
                            } while (str.charAt(i11) != ']');
                        }
                        i11++;
                    } else {
                        i11 = iDelimiterOffset;
                        break;
                    }
                }
                int i12 = i11 + 1;
                if (i12 < iDelimiterOffset) {
                    this.host = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(i8, i11, 4, str));
                    try {
                        i4 = Integer.parseInt(_UrlKt.canonicalize$default(str, i12, iDelimiterOffset, "", 120));
                        if (i2 > i4 || i4 >= 65536) {
                            i4 = -1;
                        }
                    } catch (NumberFormatException unused) {
                    }
                    this.port = i4;
                    if (i4 == -1) {
                        throw new IllegalArgumentException(("Invalid URL port: \"" + str.substring(i12, iDelimiterOffset) + '\"').toString());
                    }
                } else {
                    this.host = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(i8, i11, 4, str));
                    String str2 = this.scheme;
                    str2.getClass();
                    if (str2.equals("http")) {
                        i3 = 80;
                    } else {
                        i3 = str2.equals("https") ? 443 : -1;
                    }
                    this.port = i3;
                }
                if (this.host == null) {
                    throw new IllegalArgumentException(("Invalid URL host: \"" + str.substring(i8, i11) + '\"').toString());
                }
                iIndexOfFirstNonAsciiWhitespace = iDelimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host;
                this.port = httpUrl.port;
                arrayList.clear();
                arrayList.addAll(httpUrl.encodedPathSegments());
                if (iIndexOfFirstNonAsciiWhitespace == iIndexOfLastNonAsciiWhitespace || str.charAt(iIndexOfFirstNonAsciiWhitespace) == '#') {
                    String strEncodedQuery = httpUrl.encodedQuery();
                    this.encodedQueryNamesAndValues = strEncodedQuery != null ? toQueryNamesAndValues(_UrlKt.canonicalize$default(strEncodedQuery, 0, 0, " \"'<>#", 83)) : null;
                }
            }
            int iDelimiterOffset3 = _UtilCommonKt.delimiterOffset(iIndexOfFirstNonAsciiWhitespace, iIndexOfLastNonAsciiWhitespace, str, "?#");
            if (iIndexOfFirstNonAsciiWhitespace != iDelimiterOffset3) {
                char cCharAt5 = str.charAt(iIndexOfFirstNonAsciiWhitespace);
                if (cCharAt5 == '/' || cCharAt5 == '\\') {
                    arrayList.clear();
                    arrayList.add("");
                    iIndexOfFirstNonAsciiWhitespace++;
                } else {
                    arrayList.set(arrayList.size() - 1, "");
                }
                while (iIndexOfFirstNonAsciiWhitespace < iDelimiterOffset3) {
                    int iDelimiterOffset4 = _UtilCommonKt.delimiterOffset(iIndexOfFirstNonAsciiWhitespace, iDelimiterOffset3, str, "/\\");
                    boolean z = iDelimiterOffset4 < iDelimiterOffset3;
                    String strCanonicalize$default2 = _UrlKt.canonicalize$default(str, iIndexOfFirstNonAsciiWhitespace, iDelimiterOffset4, " \"<>^`{}|/\\?#", 112);
                    if (!strCanonicalize$default2.equals(".") && !strCanonicalize$default2.equalsIgnoreCase("%2e")) {
                        if (!strCanonicalize$default2.equals("..") && !strCanonicalize$default2.equalsIgnoreCase("%2e.") && !strCanonicalize$default2.equalsIgnoreCase(".%2e") && !strCanonicalize$default2.equalsIgnoreCase("%2e%2e")) {
                            if (((CharSequence) arrayList.get(arrayList.size() - 1)).length() == 0) {
                                arrayList.set(arrayList.size() - 1, strCanonicalize$default2);
                            } else {
                                arrayList.add(strCanonicalize$default2);
                            }
                            if (z) {
                                arrayList.add("");
                            }
                        } else if (((String) arrayList.remove(arrayList.size() - 1)).length() != 0 || arrayList.isEmpty()) {
                            arrayList.add("");
                        } else {
                            arrayList.set(arrayList.size() - 1, "");
                        }
                    }
                    iIndexOfFirstNonAsciiWhitespace = z ? iDelimiterOffset4 + 1 : iDelimiterOffset4;
                }
            }
            if (iDelimiterOffset3 < iIndexOfLastNonAsciiWhitespace && str.charAt(iDelimiterOffset3) == '?') {
                int iDelimiterOffset5 = _UtilCommonKt.delimiterOffset(str, iDelimiterOffset3, iIndexOfLastNonAsciiWhitespace, '#');
                this.encodedQueryNamesAndValues = toQueryNamesAndValues(_UrlKt.canonicalize$default(str, iDelimiterOffset3 + 1, iDelimiterOffset5, " \"'<>#", 80));
                iDelimiterOffset3 = iDelimiterOffset5;
            }
            if (iDelimiterOffset3 >= iIndexOfLastNonAsciiWhitespace || str.charAt(iDelimiterOffset3) != '#') {
                return;
            }
            this.encodedFragment = _UrlKt.canonicalize$default(str, iDelimiterOffset3 + 1, iIndexOfLastNonAsciiWhitespace, "", 48);
        }

        /* JADX WARN: Code duplicated, block: B:34:0x008b  */
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (this.encodedUsername.length() > 0 || this.encodedPassword.length() > 0) {
                sb.append(this.encodedUsername);
                if (this.encodedPassword.length() > 0) {
                    sb.append(':');
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            }
            String str2 = this.host;
            if (str2 != null) {
                if (StringsKt.contains$default(str2, ':')) {
                    sb.append('[');
                    sb.append(this.host);
                    sb.append(']');
                } else {
                    sb.append(this.host);
                }
            }
            int i = -1;
            if (this.port != -1 || this.scheme != null) {
                int iEffectivePort = effectivePort();
                String str3 = this.scheme;
                if (str3 == null) {
                    sb.append(':');
                    sb.append(iEffectivePort);
                } else {
                    if (str3.equals("http")) {
                        i = 80;
                    } else if (str3.equals("https")) {
                        i = 443;
                    }
                    if (iEffectivePort != i) {
                        sb.append(':');
                        sb.append(iEffectivePort);
                    }
                }
            }
            ArrayList arrayList = this.encodedPathSegments;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append('/');
                sb.append((String) arrayList.get(i2));
            }
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                ArrayList arrayList2 = this.encodedQueryNamesAndValues;
                arrayList2.getClass();
                Okio__OkioKt.toQueryString(sb, arrayList2);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            return sb.toString();
        }
    }

    public HttpUrl(String str, String str2, String str3, String str4, int i, ArrayList arrayList, String str5, String str6) {
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = i;
        this.queryNamesAndValues = arrayList;
        this.fragment = str5;
        this.url = str6;
    }

    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        return str.substring(StringsKt.indexOf$default(str, ':', length, 4) + 1, StringsKt.indexOf$default(str, '@', 0, 6));
    }

    public final String encodedPath() {
        int length = this.scheme.length() + 3;
        String str = this.url;
        int iIndexOf$default = StringsKt.indexOf$default(str, '/', length, 4);
        return str.substring(iIndexOf$default, _UtilCommonKt.delimiterOffset(iIndexOf$default, str.length(), str, "?#"));
    }

    public final ArrayList encodedPathSegments() {
        int length = this.scheme.length() + 3;
        String str = this.url;
        int iIndexOf$default = StringsKt.indexOf$default(str, '/', length, 4);
        int iDelimiterOffset = _UtilCommonKt.delimiterOffset(iIndexOf$default, str.length(), str, "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf$default < iDelimiterOffset) {
            int i = iIndexOf$default + 1;
            int iDelimiterOffset2 = _UtilCommonKt.delimiterOffset(str, i, iDelimiterOffset, '/');
            arrayList.add(str.substring(i, iDelimiterOffset2));
            iIndexOf$default = iDelimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        String str = this.url;
        int iIndexOf$default = StringsKt.indexOf$default(str, '?', 0, 6) + 1;
        return str.substring(iIndexOf$default, _UtilCommonKt.delimiterOffset(str, iIndexOf$default, str.length(), '#'));
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        return str.substring(length, _UtilCommonKt.delimiterOffset(length, str.length(), str, ":@"));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).url.equals(this.url);
    }

    public final int hashCode() {
        return this.url.hashCode();
    }

    public final boolean isHttps() {
        return Intrinsics.areEqual(this.scheme, "https");
    }

    public final String redact() throws EOFException {
        Builder builder;
        try {
            builder = new Builder();
            builder.parse$okhttp(this, "/...");
        } catch (IllegalArgumentException unused) {
            builder = null;
        }
        builder.getClass();
        builder.encodedUsername = _UrlKt.canonicalize$default("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", ControlFramesKt.MAX_CLOSE_REASON_MESSAGE_SIZE);
        builder.encodedPassword = _UrlKt.canonicalize$default("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", ControlFramesKt.MAX_CLOSE_REASON_MESSAGE_SIZE);
        return builder.build().url;
    }

    public final String toString() {
        return this.url;
    }

    public final URI uri() {
        String strSubstring;
        String strReplaceAll;
        Builder builder = new Builder();
        String str = this.scheme;
        builder.scheme = str;
        builder.encodedUsername = encodedUsername();
        builder.encodedPassword = encodedPassword();
        builder.host = this.host;
        str.getClass();
        int i = str.equals("http") ? 80 : str.equals("https") ? 443 : -1;
        int i2 = this.port;
        builder.port = i2 != i ? i2 : -1;
        ArrayList arrayList = builder.encodedPathSegments;
        arrayList.clear();
        arrayList.addAll(encodedPathSegments());
        String strEncodedQuery = encodedQuery();
        builder.encodedQueryNamesAndValues = strEncodedQuery != null ? Builder.toQueryNamesAndValues(_UrlKt.canonicalize$default(strEncodedQuery, 0, 0, " \"'<>#", 83)) : null;
        if (this.fragment == null) {
            strSubstring = null;
        } else {
            String str2 = this.url;
            strSubstring = str2.substring(StringsKt.indexOf$default(str2, '#', 0, 6) + 1);
        }
        builder.encodedFragment = strSubstring;
        String str3 = builder.host;
        if (str3 != null) {
            Pattern patternCompile = Pattern.compile("[\"<>^`{|}]");
            patternCompile.getClass();
            strReplaceAll = patternCompile.matcher(str3).replaceAll("");
            strReplaceAll.getClass();
        } else {
            strReplaceAll = null;
        }
        builder.host = strReplaceAll;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.set(i3, _UrlKt.canonicalize$default((String) arrayList.get(i3), 0, 0, "[]", 99));
        }
        ArrayList arrayList2 = builder.encodedQueryNamesAndValues;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                String str4 = (String) arrayList2.get(i4);
                arrayList2.set(i4, str4 != null ? _UrlKt.canonicalize$default(str4, 0, 0, "\\^`{|}", 67) : null);
            }
        }
        String str5 = builder.encodedFragment;
        builder.encodedFragment = str5 != null ? _UrlKt.canonicalize$default(str5, 0, 0, " \"#<>\\^`{|}", 35) : null;
        String string = builder.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                Pattern patternCompile2 = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                patternCompile2.getClass();
                String strReplaceAll2 = patternCompile2.matcher(string).replaceAll("");
                strReplaceAll2.getClass();
                URI uriCreate = URI.create(strReplaceAll2);
                uriCreate.getClass();
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }
}
