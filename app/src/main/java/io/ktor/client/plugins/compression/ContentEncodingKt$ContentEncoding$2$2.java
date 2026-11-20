package io.ktor.client.plugins.compression;

import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.content.CompressedContentKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.ContentEncoder;
import io.ktor.util.logging.LoggerJvmKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lio/ktor/http/content/OutgoingContent;", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "content"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.compression.ContentEncodingKt$ContentEncoding$2$2", f = "ContentEncoding.kt", l = {}, m = "invokeSuspend", v = 1)
public final class ContentEncodingKt$ContentEncoding$2$2 extends SuspendLambda implements Function3 {
    final /* synthetic */ Map<String, ContentEncoder> $encoders;
    final /* synthetic */ ContentEncodingConfig.Mode $mode;
    final /* synthetic */ ClientPluginBuilder<ContentEncodingConfig> $this_createClientPlugin;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContentEncodingKt$ContentEncoding$2$2(ContentEncodingConfig.Mode mode, ClientPluginBuilder<ContentEncodingConfig> clientPluginBuilder, Map<String, ? extends ContentEncoder> map, Continuation continuation) {
        super(3, continuation);
        this.$mode = mode;
        this.$this_createClientPlugin = clientPluginBuilder;
        this.$encoders = map;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(HttpRequestBuilder httpRequestBuilder, OutgoingContent outgoingContent, Continuation continuation) {
        ContentEncodingKt$ContentEncoding$2$2 contentEncodingKt$ContentEncoding$2$2 = new ContentEncodingKt$ContentEncoding$2$2(this.$mode, this.$this_createClientPlugin, this.$encoders, continuation);
        contentEncodingKt$ContentEncoding$2$2.L$0 = httpRequestBuilder;
        contentEncodingKt$ContentEncoding$2$2.L$1 = outgoingContent;
        return contentEncodingKt$ContentEncoding$2$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$0;
        OutgoingContent outgoingContent = (OutgoingContent) this.L$1;
        if (this.label != 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        if (!this.$mode.getRequest()) {
            return null;
        }
        List<String> list = (List) httpRequestBuilder.getAttributes().getOrNull(ContentEncodingKt.getCompressionListAttribute());
        if (list == null) {
            Logger logger = ContentEncodingKt.LOGGER;
            if (LoggerJvmKt.isTraceEnabled(logger)) {
                logger.trace("Skipping request compression for " + httpRequestBuilder.getUrl() + " because no compressions set");
            }
            return null;
        }
        Logger logger2 = ContentEncodingKt.LOGGER;
        if (LoggerJvmKt.isTraceEnabled(logger2)) {
            logger2.trace("Compressing request body for " + httpRequestBuilder.getUrl() + " using " + list);
        }
        Map<String, ContentEncoder> map = this.$encoders;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            ContentEncoder contentEncoder = map.get(str);
            if (contentEncoder == null) {
                throw new UnsupportedContentEncodingException(str);
            }
            arrayList.add(contentEncoder);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            OutgoingContent outgoingContentCompressed = CompressedContentKt.compressed(outgoingContent, (ContentEncoder) obj2, httpRequestBuilder.getExecutionContext());
            if (outgoingContentCompressed != null) {
                outgoingContent = outgoingContentCompressed;
            }
        }
        return outgoingContent;
    }
}
