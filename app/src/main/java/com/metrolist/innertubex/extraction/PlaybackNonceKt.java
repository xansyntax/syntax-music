package com.metrolist.innertubex.extraction;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PlaybackNonceKt {
    static {
        Pattern.compile("([?&])cpn=[^&#]*").getClass();
    }

    public static final String appendClientPlaybackNonce(String str, String str2) {
        Object failure;
        str.getClass();
        str2.getClass();
        if (str2.length() != 16) {
            return str;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (!StringsKt.contains$default("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_", str2.charAt(i))) {
                return str;
            }
        }
        try {
            failure = URLUtilsKt.Url(str);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        Url url = null;
        if (failure instanceof Result.Failure) {
            failure = null;
        }
        Url url2 = (Url) failure;
        if (url2 != null && Intrinsics.areEqual(url2.getProtocol().getName(), "https") && url2.getPort() == 443 && ((Intrinsics.areEqual(url2.getHost(), "googlevideo.com") || StringsKt__StringsJVMKt.endsWith(url2.getHost(), ".googlevideo.com", false)) && Intrinsics.areEqual(url2.getEncodedPath(), "/videoplayback") && url2.getUser() == null && url2.getPassword() == null)) {
            url = url2;
        }
        if (url == null || url.getParameters().contains("cpn")) {
            return str;
        }
        String strConcat = "cpn=".concat(str2);
        int iIndexOf$default = StringsKt.indexOf$default(str, '#', 0, 6);
        String strSubstring = iIndexOf$default < 0 ? str : str.substring(0, iIndexOf$default);
        return IntIntPair$$ExternalSyntheticOutline0.m(strSubstring, (StringsKt.contains$default(strSubstring, '?') ? "&" : "?").concat(strConcat), iIndexOf$default < 0 ? "" : str.substring(iIndexOf$default));
    }

    public static final String generateClientPlaybackNonce() {
        StringBuilder sb = new StringBuilder(16);
        for (int i = 0; i < 16; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_".charAt(Random.defaultRandom.nextInt(64)));
        }
        return sb.toString();
    }
}
