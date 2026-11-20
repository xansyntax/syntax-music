package com.metrolist.innertubex.cipher;

import io.ktor.http.Url;
import io.ktor.sse.ServerSentEventKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class EjsChallengeSolverKt {
    public static final Regex PREPROCESSED_CACHE_KEY_REGEX = new Regex("[a-f0-9]{40}");

    public static final String preprocessedPlayerCacheKey(String str, String str2) {
        Object failure;
        str.getClass();
        str2.getClass();
        if (!PREPROCESSED_CACHE_KEY_REGEX.matches(str2)) {
            return null;
        }
        try {
            failure = StringsKt__IndentKt.validatedPlayerScriptUrl(str);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (failure instanceof Result.Failure) {
            failure = null;
        }
        if (((Url) failure) == null) {
            return null;
        }
        return CharsKt.sha1(str + ServerSentEventKt.COLON + str2);
    }

    public static final boolean solvesAll(EjsChallengeSolver.SolveResult solveResult, List list) {
        Map map;
        if (list != null && list.isEmpty()) {
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            String str = (String) pair.first;
            List list2 = (List) pair.second;
            if (Intrinsics.areEqual(str, "sig")) {
                map = solveResult.sigByChallenge;
            } else {
                if (!Intrinsics.areEqual(str, "n")) {
                    return false;
                }
                map = solveResult.nByChallenge;
            }
            if (list2 == null || !list2.isEmpty()) {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (!map.containsKey((String) it2.next())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
