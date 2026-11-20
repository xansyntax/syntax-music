package com.metrolist.music.ui.utils;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.collections.ReversedListReadOnly;
import kotlin.math.MathKt;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class YouTubeUtilsKt {
    public static final Regex GOOGLEUSERCONTENT_SIZE_PATTERN = new Regex("^(https://(?:lh3|yt3)\\.googleusercontent\\.com/[^?]*?)=w(\\d+)-h(\\d+)[^?]*(\\?.*)?$");
    public static final Regex GGPHT_SIZE_PATTERN = new Regex("^(https://yt3\\.ggpht\\.com/[^?=]+)=(?:s\\d+|w\\d+-h\\d+)[^?]*(\\?.*)?$");

    public static final String resize(String str, Integer num, Integer num2) {
        str.getClass();
        MatcherMatchResult matcherMatchResultMatchEntire = GOOGLEUSERCONTENT_SIZE_PATTERN.matchEntire(str);
        if (matcherMatchResultMatchEntire != null) {
            ReversedListReadOnly reversedListReadOnly = (ReversedListReadOnly) matcherMatchResultMatchEntire.getGroupValues();
            int i = Integer.parseInt((String) reversedListReadOnly.get(2));
            int i2 = Integer.parseInt((String) reversedListReadOnly.get(3));
            String str2 = (String) reversedListReadOnly.get(4);
            int iIntValue = num.intValue();
            int iIntValue2 = num2 != null ? num2.intValue() : MathKt.roundToInt((((double) num.intValue()) * ((double) i2)) / ((double) i));
            Object obj = reversedListReadOnly.get(1);
            if (iIntValue < 1) {
                iIntValue = 1;
            }
            int i3 = iIntValue2 >= 1 ? iIntValue2 : 1;
            StringBuilder sb = new StringBuilder();
            sb.append(obj);
            sb.append("=w");
            sb.append(iIntValue);
            sb.append("-h");
            sb.append(i3);
            return IntIntPair$$ExternalSyntheticOutline0.m(sb, "-p-l90-rj", str2);
        }
        MatcherMatchResult matcherMatchResultMatchEntire2 = GGPHT_SIZE_PATTERN.matchEntire(str);
        if (matcherMatchResultMatchEntire2 == null) {
            return str;
        }
        ReversedListReadOnly reversedListReadOnly2 = (ReversedListReadOnly) matcherMatchResultMatchEntire2.getGroupValues();
        String str3 = (String) reversedListReadOnly2.get(2);
        if (num2 == null) {
            return reversedListReadOnly2.get(1) + "=s" + num + str3;
        }
        Object obj2 = reversedListReadOnly2.get(1);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(obj2);
        sb2.append("=w");
        sb2.append(num);
        sb2.append("-h");
        sb2.append(num2);
        return IntIntPair$$ExternalSyntheticOutline0.m(sb2, "-p-l90-rj", str3);
    }
}
