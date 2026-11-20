package com.metrolist.music.extensions;

import java.text.Normalizer;
import java.util.Locale;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class StringExtKt {
    public static final Regex combiningDiacriticalMarksRegex = new Regex("\\p{Mn}+");

    public static final boolean matchesNormalizedQuery(String str, String... strArr) {
        str.getClass();
        strArr.getClass();
        String string = StringsKt.trim(str).toString();
        if (!StringsKt.isBlank(string)) {
            for (String str2 : strArr) {
                if (str2 == null || !StringsKt.contains(normalizeForSearch(str2), string, false)) {
                }
            }
            return false;
        }
        return true;
    }

    public static final String normalizeForSearch(String str) {
        str.getClass();
        String strNormalize = Normalizer.normalize(StringsKt.trim(str).toString(), Normalizer.Form.NFD);
        strNormalize.getClass();
        String lowerCase = combiningDiacriticalMarksRegex.replace(strNormalize, "").toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        return lowerCase;
    }
}
