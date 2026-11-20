package com.metrolist.music.lyrics;

import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LyricsFormatKt {
    public static final Regex LRC_TIMESTAMP_HINT = new Regex("\\[\\d{1,2}:\\d{2}");

    public static final boolean lyricsTextLooksSynced(String str) {
        if (str == null || StringsKt.isBlank(str)) {
            return false;
        }
        String string = StringsKt.trimStart(StringsKt.removePrefix(StringsKt.trim(str).toString(), "\ufeff")).toString();
        if (StringsKt.startsWith$default(string, '[')) {
            return true;
        }
        return LRC_TIMESTAMP_HINT.containsMatchIn(StringsKt.take(4096, string));
    }
}
