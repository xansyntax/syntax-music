package io.ktor.openapi;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aK\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "U", "Lkotlin/Pair;", "Lkotlin/Function1;", "transform", "mapValue", "(Lkotlin/Pair;Lkotlin/jvm/functions/Function1;)Lkotlin/Pair;", "ktor-openapi-schema"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UtilsKt {
    public static final <T, U> Pair mapValue(Pair pair, Function1 function1) {
        pair.getClass();
        function1.getClass();
        return new Pair(function1.invoke(pair.first), function1.invoke(pair.second));
    }
}
