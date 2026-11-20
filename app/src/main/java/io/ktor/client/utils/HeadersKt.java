package io.ktor.client.utils;

import io.ktor.events.Events$$ExternalSyntheticLambda0;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/Function1;", "Lio/ktor/http/HeadersBuilder;", "", "block", "Lio/ktor/http/Headers;", "buildHeaders", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/http/Headers;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HeadersKt {
    public static final Headers buildHeaders(Function1 function1) {
        function1.getClass();
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        function1.invoke(headersBuilder);
        return headersBuilder.build();
    }

    public static /* synthetic */ Headers buildHeaders$default(Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Events$$ExternalSyntheticLambda0((byte) 22);
        }
        return buildHeaders(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildHeaders$lambda$0(HeadersBuilder headersBuilder) {
        headersBuilder.getClass();
        return Unit.INSTANCE;
    }
}
