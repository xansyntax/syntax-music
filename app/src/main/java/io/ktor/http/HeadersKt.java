package io.ktor.http;

import io.ktor.http.header.UtilsKt;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001d\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0001\u0010\u0006\u001a#\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\u0001\u0010\t\u001aE\u0010\u0001\u001a\u00020\u000026\u0010\f\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00070\u000b0\n\"\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00070\u000b¢\u0006\u0004\b\u0001\u0010\r\u001a!\u0010\u0012\u001a\u00020\u00002\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0012\u0010\u0013\u001a5\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/http/Headers;", "headersOf", "()Lio/ktor/http/Headers;", "", ContentDisposition.Parameters.Name, "value", "(Ljava/lang/String;Ljava/lang/String;)Lio/ktor/http/Headers;", "", "values", "(Ljava/lang/String;Ljava/util/List;)Lio/ktor/http/Headers;", "", "Lkotlin/Pair;", "pairs", "([Lkotlin/Pair;)Lio/ktor/http/Headers;", "Lkotlin/Function1;", "Lio/ktor/http/HeadersBuilder;", "", "builder", "headers", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/http/Headers;", "", "separator", "", "splitInsideQuotes", "getSplitValues", "(Lio/ktor/http/Headers;Ljava/lang/String;CZ)Ljava/util/List;", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HeadersKt {
    public static final List<String> getSplitValues(Headers headers, String str, char c, boolean z) {
        headers.getClass();
        str.getClass();
        List<String> all = headers.getAll(str);
        if (all == null) {
            return null;
        }
        return UtilsKt.splitHeaderValues(all, c, z);
    }

    public static /* synthetic */ List getSplitValues$default(Headers headers, String str, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            c = ',';
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return getSplitValues(headers, str, c, z);
    }

    public static final Headers headers(Function1 function1) {
        function1.getClass();
        Headers.Companion companion = Headers.INSTANCE;
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        function1.invoke(headersBuilder);
        return headersBuilder.build();
    }

    public static final Headers headersOf(Pair... pairArr) {
        pairArr.getClass();
        List listAsList = Arrays.asList(pairArr);
        listAsList.getClass();
        return new HeadersImpl(MapsKt__MapsKt.toMap(listAsList));
    }

    public static final Headers headersOf(String str, String str2) {
        str.getClass();
        str2.getClass();
        return new HeadersSingleImpl(str, CollectionsKt__IterablesKt.listOf(str2));
    }

    public static final Headers headersOf(String str, List<String> list) {
        str.getClass();
        list.getClass();
        return new HeadersSingleImpl(str, list);
    }

    public static final Headers headersOf() {
        return Headers.INSTANCE.getEmpty();
    }
}
