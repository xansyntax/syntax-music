package com.metrolist.innertubex.cipher;

import kotlin.collections.ReversedListReadOnly;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RemotePlayerConfigParserKt {
    public static final Regex LOCALIZED_IAS_PLAYER_URL = new Regex("^https://www\\.youtube\\.com/s/player/([A-Za-z0-9_-]+)/player_ias\\.vflset/[A-Za-z]{2,3}(?:_[A-Za-z]{2,4})?/base\\.js$");

    public static final String canonicalPlayerUrl(String str) {
        str.getClass();
        MatcherMatchResult matcherMatchResultMatchEntire = LOCALIZED_IAS_PLAYER_URL.matchEntire(str);
        if (matcherMatchResultMatchEntire == null) {
            return str;
        }
        return "https://www.youtube.com/s/player/" + ((ReversedListReadOnly) matcherMatchResultMatchEntire.getGroupValues()).get(1) + "/player_ias.vflset/en_GB/base.js";
    }
}
