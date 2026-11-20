package io.ktor.client.engine.okhttp;

import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import io.ktor.client.call.UnsupportedContentTypeException;
import io.ktor.client.engine.UtilsKt;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethodKt;
import io.ktor.http.Url$$ExternalSyntheticLambda1;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.OutgoingContentKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannelOperations_jvmKt;
import io.ktor.utils.io.WriterScope;
import java.io.Closeable;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.text.Regex;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.BufferedSource;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a#\u0010\u0011\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a#\u0010\u0015\u001a\u00020\u0014*\u00020\u00132\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001b\u0010\u001a\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lokio/BufferedSource;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lio/ktor/client/request/HttpRequestData;", "requestData", "Lio/ktor/utils/io/ByteReadChannel;", "toChannel", "(Lokio/BufferedSource;Lkotlin/coroutines/CoroutineContext;Lio/ktor/client/request/HttpRequestData;)Lio/ktor/utils/io/ByteReadChannel;", "", "cause", "request", "mapExceptions", "(Ljava/lang/Throwable;Lio/ktor/client/request/HttpRequestData;)Ljava/lang/Throwable;", "callContext", "Lio/ktor/client/engine/okhttp/OkHttpConfig;", "config", "Lokhttp3/Request;", "convertToOkHttpRequest", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/CoroutineContext;Lio/ktor/client/engine/okhttp/OkHttpConfig;)Lokhttp3/Request;", "Lio/ktor/http/content/OutgoingContent;", "Lokhttp3/RequestBody;", "convertToOkHttpBody", "(Lio/ktor/http/content/OutgoingContent;Lkotlin/coroutines/CoroutineContext;Lio/ktor/client/engine/okhttp/OkHttpConfig;)Lokhttp3/RequestBody;", "Lokhttp3/OkHttpClient$Builder;", "Lio/ktor/client/plugins/HttpTimeoutConfig;", "timeoutAttributes", "setupTimeoutAttributes", "(Lokhttp3/OkHttpClient$Builder;Lio/ktor/client/plugins/HttpTimeoutConfig;)Lokhttp3/OkHttpClient$Builder;", "ktor-client-okhttp"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class OkHttpEngineKt {

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1", f = "OkHttpEngine.kt", l = {194}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ CoroutineContext $context;
        final /* synthetic */ HttpRequestData $requestData;
        final /* synthetic */ ByteChannel $responseChannel;
        final /* synthetic */ BufferedSource $this_toChannel;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BufferedSource bufferedSource, CoroutineContext coroutineContext, ByteChannel byteChannel, HttpRequestData httpRequestData, Continuation continuation) {
            super(2, continuation);
            this.$this_toChannel = bufferedSource;
            this.$context = coroutineContext;
            this.$responseChannel = byteChannel;
            this.$requestData = httpRequestData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$0(Ref$IntRef ref$IntRef, BufferedSource bufferedSource, WriterScope writerScope, HttpRequestData httpRequestData, CoroutineContext coroutineContext, ByteBuffer byteBuffer) throws Throwable {
            Object failure;
            try {
                ref$IntRef.element = bufferedSource.read(byteBuffer);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                try {
                    failure = AwaitKt.getJob(coroutineContext).getCancellationException();
                } catch (Throwable th2) {
                    failure = new Result.Failure(th2);
                }
                if (!(failure instanceof Result.Failure)) {
                    th = failure;
                }
                throw OkHttpEngineKt.mapExceptions((Throwable) th, httpRequestData);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_toChannel, this.$context, this.$responseChannel, this.$requestData, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.nio.channels.Channel, okio.BufferedSource] */
        /* JADX WARN: Type inference failed for: r3v4 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Closeable closeable;
            final Ref$IntRef ref$IntRef;
            final CoroutineContext coroutineContext;
            ByteChannel byteChannel;
            final HttpRequestData httpRequestData;
            int i;
            int i2;
            final ?? r3;
            final WriterScope writerScope = (WriterScope) this.L$0;
            int i3 = this.label;
            Throwable th = null;
            try {
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    closeable = this.$this_toChannel;
                    CoroutineContext coroutineContext2 = this.$context;
                    ByteChannel byteChannel2 = this.$responseChannel;
                    HttpRequestData httpRequestData2 = this.$requestData;
                    ref$IntRef = new Ref$IntRef();
                    coroutineContext = coroutineContext2;
                    byteChannel = byteChannel2;
                    httpRequestData = httpRequestData2;
                    i = 0;
                    i2 = 0;
                    r3 = closeable;
                } else {
                    if (i3 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    i2 = this.I$1;
                    int i4 = this.I$0;
                    ref$IntRef = (Ref$IntRef) this.L$6;
                    BufferedSource bufferedSource = (BufferedSource) this.L$5;
                    httpRequestData = (HttpRequestData) this.L$4;
                    ByteChannel byteChannel3 = (ByteChannel) this.L$3;
                    CoroutineContext coroutineContext3 = (CoroutineContext) this.L$2;
                    closeable = (Closeable) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    byteChannel = byteChannel3;
                    coroutineContext = coroutineContext3;
                    i = i4;
                    r3 = bufferedSource;
                }
                while (r3.isOpen() && AwaitKt.isActive(coroutineContext) && ref$IntRef.element >= 0) {
                    int iWriteAvailable$default = ByteWriteChannelOperations_jvmKt.writeAvailable$default(byteChannel, 0, new Function1() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return OkHttpEngineKt.AnonymousClass1.invokeSuspend$lambda$0$0(ref$IntRef, r3, writerScope, httpRequestData, coroutineContext, (ByteBuffer) obj2);
                        }
                    }, 1, null);
                    ByteReadChannelOperationsKt.rethrowCloseCauseIfNeeded(byteChannel);
                    if (iWriteAvailable$default == -1) {
                        break;
                    }
                    byteChannel.flushWriteBuffer();
                    if (!byteChannel.getHasFreeSpace()) {
                        this.L$0 = writerScope;
                        this.L$1 = closeable;
                        this.L$2 = coroutineContext;
                        this.L$3 = byteChannel;
                        this.L$4 = httpRequestData;
                        this.L$5 = r3;
                        this.L$6 = ref$IntRef;
                        this.I$0 = i;
                        this.I$1 = i2;
                        this.I$2 = iWriteAvailable$default;
                        this.label = 1;
                        Object objFlush = byteChannel.flush(this);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objFlush == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                }
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (Throwable th4) {
                        ResultKt.addSuppressed(th3, th4);
                    }
                }
                th = th3;
            }
            if (th == null) {
                return Unit.INSTANCE;
            }
            throw th;
        }
    }

    public static final RequestBody convertToOkHttpBody(OutgoingContent outgoingContent, CoroutineContext coroutineContext, OkHttpConfig okHttpConfig) {
        outgoingContent.getClass();
        coroutineContext.getClass();
        okHttpConfig.getClass();
        MediaType mediaType = null;
        if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
            byte[] bArrBytes = ((OutgoingContent.ByteArrayContent) outgoingContent).getContent();
            RequestBody.Companion companion = RequestBody.Companion;
            Regex regex = MediaType.TYPE_SUBTYPE;
            try {
                mediaType = CollectionsKt__IterablesKt.get(String.valueOf(outgoingContent.getContentType()));
            } catch (IllegalArgumentException unused) {
            }
            int length = bArrBytes.length;
            companion.getClass();
            return RequestBody.Companion.create(mediaType, bArrBytes, 0, length);
        }
        if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
            return new StreamRequestBody(coroutineContext, outgoingContent.getContentLength(), okHttpConfig.getDuplexStreamingEnabled(), new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 23, outgoingContent));
        }
        if (outgoingContent instanceof OutgoingContent.WriteChannelContent) {
            return new StreamRequestBody(coroutineContext, outgoingContent.getContentLength(), okHttpConfig.getDuplexStreamingEnabled(), new Url$$ExternalSyntheticLambda1(coroutineContext, outgoingContent, (byte) 1));
        }
        if (outgoingContent instanceof OutgoingContent.NoContent) {
            RequestBody.Companion.getClass();
            return RequestBody.Companion.create(null, new byte[0], 0, 0);
        }
        if (outgoingContent instanceof OutgoingContent.ContentWrapper) {
            return convertToOkHttpBody(((OutgoingContent.ContentWrapper) outgoingContent).getDelegate(), coroutineContext, okHttpConfig);
        }
        if (outgoingContent instanceof OutgoingContent.ProtocolUpgrade) {
            throw new UnsupportedContentTypeException(outgoingContent);
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel convertToOkHttpBody$lambda$1(OutgoingContent outgoingContent) {
        return ((OutgoingContent.ReadChannelContent) outgoingContent).readFrom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel convertToOkHttpBody$lambda$2(CoroutineContext coroutineContext, OutgoingContent outgoingContent) {
        return ByteWriteChannelOperationsKt.writer$default((CoroutineScope) GlobalScope.INSTANCE, coroutineContext, false, (Function2) new OkHttpEngineKt$convertToOkHttpBody$3$1(outgoingContent, null), 2, (Object) null).getChannel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Request convertToOkHttpRequest(HttpRequestData httpRequestData, CoroutineContext coroutineContext, OkHttpConfig okHttpConfig) {
        final Request.Builder builder = new Request.Builder();
        builder.url(httpRequestData.getUrl().getUrlString());
        final boolean z = !HttpMethodKt.getSupportsRequestBody(httpRequestData.getMethod()) && OutgoingContentKt.isEmpty(httpRequestData.getBody());
        UtilsKt.mergeHeaders(httpRequestData.getHeaders(), httpRequestData.getBody(), new Function2() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpRequest$lambda$0$$inlined$forEachHeader$1
            public final void invoke(String str, String str2) {
                str.getClass();
                str2.getClass();
                if (z && str.equals(HttpHeaders.ContentLength)) {
                    return;
                }
                builder.addHeader(str, str2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, (String) obj2);
                return Unit.INSTANCE;
            }
        });
        builder.method(httpRequestData.getMethod().getValue(), Okio__OkioKt.permitsRequestBody(httpRequestData.getMethod().getValue()) ? convertToOkHttpBody(httpRequestData.getBody(), coroutineContext, okHttpConfig) : null);
        return new Request(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable mapExceptions(Throwable th, HttpRequestData httpRequestData) {
        return th instanceof SocketTimeoutException ? HttpTimeoutKt.SocketTimeoutException(httpRequestData, th) : th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient.Builder setupTimeoutAttributes(OkHttpClient.Builder builder, HttpTimeoutConfig httpTimeoutConfig) {
        Long connectTimeoutMillis = httpTimeoutConfig.get_connectTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (connectTimeoutMillis != null) {
            builder.connectTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(connectTimeoutMillis.longValue()), timeUnit);
        }
        Long socketTimeoutMillis = httpTimeoutConfig.get_socketTimeoutMillis();
        if (socketTimeoutMillis != null) {
            long jLongValue = socketTimeoutMillis.longValue();
            builder.readTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(jLongValue), timeUnit);
            builder.writeTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(jLongValue), timeUnit);
        }
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel toChannel(BufferedSource bufferedSource, CoroutineContext coroutineContext, HttpRequestData httpRequestData) {
        ByteChannel byteChannel = new ByteChannel(false, 1, null);
        return ByteWriteChannelOperationsKt.writer(GlobalScope.INSTANCE, coroutineContext, byteChannel, new AnonymousClass1(bufferedSource, coroutineContext, byteChannel, httpRequestData, null)).getChannel();
    }
}
