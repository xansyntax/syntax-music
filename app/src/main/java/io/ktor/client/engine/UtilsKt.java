package io.ktor.client.engine;

import io.ktor.client.utils.HeadersKt;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.PlatformUtils;
import io.ktor.util.StringValuesKt$$ExternalSyntheticLambda0;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0003\u001a9\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0010\u0010\u000b\u001a\u00020\nH\u0087@¢\u0006\u0004\b\u000b\u0010\f\u001a\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0080H¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\" \u0010\u0014\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\"\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lio/ktor/http/Headers;", "requestHeaders", "Lio/ktor/http/content/OutgoingContent;", "content", "Lkotlin/Function2;", "", "", "block", "mergeHeaders", "(Lio/ktor/http/Headers;Lio/ktor/http/content/OutgoingContent;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/coroutines/CoroutineContext;", "callContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Job;", "callJob", "attachToUserJob", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "needUserAgent", "()Z", "KTOR_DEFAULT_USER_AGENT", "Ljava/lang/String;", "getKTOR_DEFAULT_USER_AGENT", "()Ljava/lang/String;", "getKTOR_DEFAULT_USER_AGENT$annotations", "()V", "", "DATE_HEADERS", "Ljava/util/Set;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UtilsKt {
    private static final Set<String> DATE_HEADERS = ArraysKt.toSet(new String[]{HttpHeaders.Date, HttpHeaders.Expires, HttpHeaders.LastModified, HttpHeaders.IfModifiedSince, HttpHeaders.IfUnmodifiedSince});
    private static final String KTOR_DEFAULT_USER_AGENT = "ktor-client";

    public static final Object attachToUserJob(Job job, Continuation continuation) {
        Job job2 = (Job) continuation.getContext().get(Job.Key.$$INSTANCE);
        Unit unit = Unit.INSTANCE;
        if (job2 == null) {
            return unit;
        }
        job.invokeOnCompletion(new AnonymousClass2(job2.invokeOnCompletion(true, true, new UtilsKt$attachToUserJob$cleanupHandler$1(job))));
        return unit;
    }

    private static final Object attachToUserJob$$forInline(Job job, Continuation continuation) {
        throw null;
    }

    public static final Object callContext(Continuation continuation) {
        CoroutineContext.Element element = continuation.getContext().get(KtorCallContextElement.INSTANCE);
        element.getClass();
        return ((KtorCallContextElement) element).getCallContext();
    }

    public static final String getKTOR_DEFAULT_USER_AGENT() {
        return KTOR_DEFAULT_USER_AGENT;
    }

    public static final void mergeHeaders(Headers headers, OutgoingContent outgoingContent, Function2 function2) {
        String string;
        String strValueOf;
        headers.getClass();
        outgoingContent.getClass();
        function2.getClass();
        HeadersKt.buildHeaders(new UtilsKt$$ExternalSyntheticLambda0(headers, outgoingContent, (byte) 0)).forEach(new StringValuesKt$$ExternalSyntheticLambda0(function2, (byte) 11));
        if (headers.get(HttpHeaders.UserAgent) == null && outgoingContent.getHeaders().get(HttpHeaders.UserAgent) == null && needUserAgent()) {
            function2.invoke(HttpHeaders.UserAgent, KTOR_DEFAULT_USER_AGENT);
        }
        ContentType contentType = outgoingContent.getContentType();
        if ((contentType == null || (string = contentType.toString()) == null) && (string = outgoingContent.getHeaders().get(HttpHeaders.ContentType)) == null) {
            string = headers.get(HttpHeaders.ContentType);
        }
        Long contentLength = outgoingContent.getContentLength();
        if ((contentLength == null || (strValueOf = String.valueOf(contentLength.longValue())) == null) && (strValueOf = outgoingContent.getHeaders().get(HttpHeaders.ContentLength)) == null) {
            strValueOf = headers.get(HttpHeaders.ContentLength);
        }
        if (string != null) {
            function2.invoke(HttpHeaders.ContentType, string);
        }
        if (strValueOf != null) {
            function2.invoke(HttpHeaders.ContentLength, strValueOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mergeHeaders$lambda$0(Headers headers, OutgoingContent outgoingContent, HeadersBuilder headersBuilder) {
        headersBuilder.getClass();
        headersBuilder.appendAll(headers);
        headersBuilder.appendAll(outgoingContent.getHeaders());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mergeHeaders$lambda$1(Function2 function2, String str, List list) {
        str.getClass();
        list.getClass();
        boolean zEquals = HttpHeaders.ContentLength.equals(str);
        Unit unit = Unit.INSTANCE;
        if (!zEquals && !HttpHeaders.ContentType.equals(str)) {
            if (!DATE_HEADERS.contains(str)) {
                function2.invoke(str, CollectionsKt.joinToString$default(list, HttpHeaders.Cookie.equals(str) ? "; " : ",", null, null, null, 62));
                return unit;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                function2.invoke(str, (String) it.next());
            }
        }
        return unit;
    }

    private static final boolean needUserAgent() {
        return !PlatformUtils.INSTANCE.getIS_BROWSER();
    }

    /* JADX INFO: renamed from: io.ktor.client.engine.UtilsKt$attachToUserJob$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 176)
    public static final class AnonymousClass2 implements Function1 {
        final /* synthetic */ DisposableHandle $cleanupHandler;

        public AnonymousClass2(DisposableHandle disposableHandle) {
            this.$cleanupHandler = disposableHandle;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(Throwable th) {
            this.$cleanupHandler.dispose();
        }
    }

    public static /* synthetic */ void getKTOR_DEFAULT_USER_AGENT$annotations() {
    }
}
