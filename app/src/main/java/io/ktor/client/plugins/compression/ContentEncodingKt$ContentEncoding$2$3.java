package io.ktor.client.plugins.compression;

import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.util.ContentEncoder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/statement/HttpResponse;", "response"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.compression.ContentEncodingKt$ContentEncoding$2$3", f = "ContentEncoding.kt", l = {}, m = "invokeSuspend", v = 1)
public final class ContentEncodingKt$ContentEncoding$2$3 extends SuspendLambda implements Function2 {
    final /* synthetic */ Map<String, ContentEncoder> $encoders;
    final /* synthetic */ ContentEncodingConfig.Mode $mode;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContentEncodingKt$ContentEncoding$2$3(ContentEncodingConfig.Mode mode, Map<String, ? extends ContentEncoder> map, Continuation continuation) {
        super(2, continuation);
        this.$mode = mode;
        this.$encoders = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ContentEncodingKt$ContentEncoding$2$3 contentEncodingKt$ContentEncoding$2$3 = new ContentEncodingKt$ContentEncoding$2$3(this.$mode, this.$encoders, continuation);
        contentEncodingKt$ContentEncoding$2$3.L$0 = obj;
        return contentEncodingKt$ContentEncoding$2$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(HttpResponse httpResponse, Continuation continuation) {
        return ((ContentEncodingKt$ContentEncoding$2$3) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HttpResponse httpResponse = (HttpResponse) this.L$0;
        if (this.label != 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        if (!this.$mode.getResponse()) {
            return null;
        }
        HttpMethod method = HttpResponseKt.getRequest(httpResponse).getMethod();
        Long lContentLength = HttpMessagePropertiesKt.contentLength(httpResponse);
        if (lContentLength != null && lContentLength.longValue() == 0) {
            return null;
        }
        if (lContentLength == null && Intrinsics.areEqual(method, HttpMethod.Head)) {
            return null;
        }
        return ContentEncodingKt.ContentEncoding$lambda$0$decode(this.$encoders, httpResponse);
    }
}
