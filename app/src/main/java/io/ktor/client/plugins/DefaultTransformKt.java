package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.UtilsKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.cio.CIOMultipartDataBase;
import io.ktor.http.content.MultiPartData;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteChannelUtilsKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.DeprecationKt;
import io.ktor.utils.io.WriterJob;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobImpl;
import kotlinx.io.Source;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0006\u001a\u00060\u0004j\u0002`\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/client/HttpClient;", "", "defaultTransformers", "(Lio/ktor/client/HttpClient;)V", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DefaultTransformKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.defaultTransformers");

    /* JADX INFO: renamed from: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "body"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1", f = "DefaultTransform.kt", l = {64}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function3 {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        Object L$3;
        int label;

        public AnonymousClass1(Continuation continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = pipelineContext;
            anonymousClass1.L$1 = obj;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            OutgoingContent outgoingContentPlatformRequestDefaultTransform;
            final PipelineContext pipelineContext = (PipelineContext) this.L$0;
            final Object obj2 = this.L$1;
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().get(HttpHeaders.Accept) == null) {
                    ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().append(HttpHeaders.Accept, "*/*");
                }
                final ContentType contentType = HttpMessagePropertiesKt.contentType((HttpMessageBuilder) pipelineContext.getContext());
                if (obj2 instanceof String) {
                    String str = (String) obj2;
                    if (contentType == null) {
                        contentType = ContentType.Text.INSTANCE.getPlain();
                    }
                    outgoingContentPlatformRequestDefaultTransform = new TextContent(str, contentType, null, 4, null);
                } else if (obj2 instanceof byte[]) {
                    outgoingContentPlatformRequestDefaultTransform = new OutgoingContent.ByteArrayContent(contentType, obj2) { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$1
                        final /* synthetic */ Object $body;
                        private final long contentLength;
                        private final ContentType contentType;

                        {
                            this.$body = obj2;
                            this.contentType = contentType == null ? ContentType.Application.INSTANCE.getOctetStream() : contentType;
                            this.contentLength = ((byte[]) obj2).length;
                        }

                        @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
                        /* JADX INFO: renamed from: bytes */
                        public byte[] getContent() {
                            return (byte[]) this.$body;
                        }

                        @Override // io.ktor.http.content.OutgoingContent
                        public Long getContentLength() {
                            return Long.valueOf(this.contentLength);
                        }

                        @Override // io.ktor.http.content.OutgoingContent
                        public ContentType getContentType() {
                            return this.contentType;
                        }
                    };
                } else if (obj2 instanceof ByteReadChannel) {
                    outgoingContentPlatformRequestDefaultTransform = new OutgoingContent.ReadChannelContent(pipelineContext, contentType, obj2) { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$2
                        final /* synthetic */ Object $body;
                        private final Long contentLength;
                        private final ContentType contentType;

                        {
                            this.$body = obj2;
                            String str2 = pipelineContext.getContext().getHeaders().get(HttpHeaders.ContentLength);
                            this.contentLength = str2 != null ? Long.valueOf(Long.parseLong(str2)) : null;
                            this.contentType = contentType == null ? ContentType.Application.INSTANCE.getOctetStream() : contentType;
                        }

                        @Override // io.ktor.http.content.OutgoingContent
                        public Long getContentLength() {
                            return this.contentLength;
                        }

                        @Override // io.ktor.http.content.OutgoingContent
                        public ContentType getContentType() {
                            return this.contentType;
                        }

                        @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                        public ByteReadChannel readFrom() {
                            return (ByteReadChannel) this.$body;
                        }
                    };
                } else {
                    outgoingContentPlatformRequestDefaultTransform = obj2 instanceof OutgoingContent ? (OutgoingContent) obj2 : DefaultTransformersJvmKt.platformRequestDefaultTransform(contentType, (HttpRequestBuilder) pipelineContext.getContext(), obj2);
                }
                if ((outgoingContentPlatformRequestDefaultTransform != null ? outgoingContentPlatformRequestDefaultTransform.getContentType() : null) != null) {
                    ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().remove(HttpHeaders.ContentType);
                    Logger logger = DefaultTransformKt.LOGGER;
                    if (LoggerJvmKt.isTraceEnabled(logger)) {
                        logger.trace("Transformed with default transformers request body for " + ((HttpRequestBuilder) pipelineContext.getContext()).getUrl() + " from " + Reflection.getOrCreateKotlinClass(obj2.getClass()));
                    }
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 1;
                    Object objProceedWith = pipelineContext.proceedWith(outgoingContentPlatformRequestDefaultTransform, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objProceedWith == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            } else {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "<destruct>"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2", f = "DefaultTransform.kt", l = {75, 79, 79, 84, 84, 88, 95, 121, 126, 142}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function3 {
        final /* synthetic */ HttpClient $this_defaultTransformers;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(HttpClient httpClient, Continuation continuation) {
            super(3, continuation);
            this.$this_defaultTransformers = httpClient;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$0(CompletableJob completableJob, Throwable th) {
            ((JobImpl) completableJob).complete$1();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_defaultTransformers, continuation);
            anonymousClass2.L$0 = pipelineContext;
            anonymousClass2.L$1 = httpResponseContainer;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:89:0x0388  */
        /* JADX WARN: Code duplicated, block: B:91:0x0392  */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0130, code lost:
        
            if (r0 == r10) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x018b, code lost:
        
            if (r0 == r10) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x020b, code lost:
        
            if (r0 == r10) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x026c, code lost:
        
            if (r0 == r10) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x02a1, code lost:
        
            if (r0 == r10) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0335, code lost:
        
            if (r0 == r10) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x037e, code lost:
        
            if (r0 == r10) goto L86;
         */
        /* JADX WARN: Instruction removed from duplicated block: B:91:0x0392, please report this as an issue */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            TypeInfo expectedType;
            Object buffer;
            PipelineContext pipelineContext;
            TypeInfo typeInfo;
            Object objProceedWith;
            Object objProceedWith2;
            Object objProceedWith3;
            Object byteArray;
            Object buffer2;
            PipelineContext pipelineContext2;
            Object objProceedWith4;
            Object objProceedWith5;
            Object objProceedWith6;
            Object objProceedWith7;
            Logger logger;
            PipelineContext pipelineContext3 = (PipelineContext) this.L$0;
            HttpResponseContainer httpResponseContainer = (HttpResponseContainer) this.L$1;
            int i = this.label;
            Unit unit = Unit.INSTANCE;
            HttpResponseContainer httpResponseContainer2 = null;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (i) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    expectedType = httpResponseContainer.getExpectedType();
                    Object response = httpResponseContainer.getResponse();
                    if (response instanceof ByteReadChannel) {
                        HttpResponse response2 = ((HttpClientCall) pipelineContext3.getContext()).getResponse();
                        KClass<?> type = expectedType.getType();
                        byte b = 1;
                        if (!Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Unit.class))) {
                            if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                this.L$0 = pipelineContext3;
                                this.L$1 = null;
                                this.L$2 = expectedType;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = pipelineContext3;
                                this.L$6 = expectedType;
                                this.label = 2;
                                buffer2 = ByteReadChannelOperationsKt.readBuffer((ByteReadChannel) response, this);
                                if (buffer2 != coroutineSingletons) {
                                    pipelineContext2 = pipelineContext3;
                                    typeInfo = expectedType;
                                    HttpResponseContainer httpResponseContainer3 = new HttpResponseContainer(expectedType, new Integer(Integer.parseInt(DeprecationKt.readText((Source) buffer2))));
                                    this.L$0 = pipelineContext3;
                                    this.L$1 = null;
                                    this.L$2 = typeInfo;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.L$5 = null;
                                    this.L$6 = null;
                                    this.label = 3;
                                    objProceedWith5 = pipelineContext2.proceedWith(httpResponseContainer3, this);
                                }
                            } else if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Source.class)) || Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Source.class))) {
                                this.L$0 = pipelineContext3;
                                this.L$1 = null;
                                this.L$2 = expectedType;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = pipelineContext3;
                                this.L$6 = expectedType;
                                this.label = 4;
                                buffer = ByteReadChannelOperationsKt.readBuffer((ByteReadChannel) response, this);
                                if (buffer != coroutineSingletons) {
                                    pipelineContext = pipelineContext3;
                                    typeInfo = expectedType;
                                    HttpResponseContainer httpResponseContainer4 = new HttpResponseContainer(expectedType, buffer);
                                    this.L$0 = pipelineContext3;
                                    this.L$1 = null;
                                    this.L$2 = typeInfo;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.L$5 = null;
                                    this.L$6 = null;
                                    this.label = 5;
                                    objProceedWith6 = pipelineContext.proceedWith(httpResponseContainer4, this);
                                }
                            } else if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(byte[].class))) {
                                this.L$0 = pipelineContext3;
                                this.L$1 = null;
                                this.L$2 = expectedType;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.label = 6;
                                byteArray = ByteReadChannelOperationsKt.toByteArray((ByteReadChannel) response, this);
                                if (byteArray != coroutineSingletons) {
                                    byte[] bArr = (byte[]) byteArray;
                                    UtilsKt.checkContentLength(HttpMessagePropertiesKt.contentLength(((HttpClientCall) pipelineContext3.getContext()).getResponse()), bArr.length, ((HttpClientCall) pipelineContext3.getContext()).getRequest().getMethod());
                                    HttpResponseContainer httpResponseContainer5 = new HttpResponseContainer(expectedType, bArr);
                                    this.L$0 = pipelineContext3;
                                    this.L$1 = null;
                                    this.L$2 = expectedType;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.L$5 = null;
                                    this.label = 7;
                                    objProceedWith7 = pipelineContext3.proceedWith(httpResponseContainer5, this);
                                }
                            } else if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(ByteReadChannel.class))) {
                                JobImpl jobImpl = new JobImpl(AwaitKt.getJob(response2.getCoroutineContext()));
                                WriterJob writerJobWriter$default = ByteWriteChannelOperationsKt.writer$default((CoroutineScope) pipelineContext3, this.$this_defaultTransformers.getCoroutineContext(), false, (Function2) new DefaultTransformKt$defaultTransformers$2$result$channel$1(response, response2, null), 2, (Object) null);
                                ByteWriteChannelOperationsKt.invokeOnCompletion(writerJobWriter$default, new HttpTimeoutKt$$ExternalSyntheticLambda1(b, jobImpl));
                                ByteChannelUtilsKt.attachWriterJob((ByteReadChannel) response, writerJobWriter$default);
                                HttpResponseContainer httpResponseContainer6 = new HttpResponseContainer(expectedType, writerJobWriter$default.getChannel());
                                this.L$0 = pipelineContext3;
                                this.L$1 = null;
                                this.L$2 = expectedType;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.L$6 = null;
                                this.label = 8;
                                objProceedWith3 = pipelineContext3.proceedWith(httpResponseContainer6, this);
                            } else if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(HttpStatusCode.class))) {
                                ByteReadChannelKt.cancel((ByteReadChannel) response);
                                HttpResponseContainer httpResponseContainer7 = new HttpResponseContainer(expectedType, response2.getStatus());
                                this.L$0 = pipelineContext3;
                                this.L$1 = null;
                                this.L$2 = expectedType;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.label = 9;
                                objProceedWith2 = pipelineContext3.proceedWith(httpResponseContainer7, this);
                            } else if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(MultiPartData.class))) {
                                String str = ((HttpClientCall) pipelineContext3.getContext()).getResponse().getHeaders().get(HttpHeaders.ContentType);
                                if (str == null) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No content type provided for multipart");
                                    return null;
                                }
                                ContentType contentType = ContentType.INSTANCE.parse(str);
                                if (!contentType.match(ContentType.MultiPart.INSTANCE.getFormData())) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$2(contentType, "Expected multipart/form-data, got ");
                                    return null;
                                }
                                String str2 = ((HttpClientCall) pipelineContext3.getContext()).getResponse().getHeaders().get(HttpHeaders.ContentLength);
                                HttpResponseContainer httpResponseContainer8 = new HttpResponseContainer(expectedType, new CIOMultipartDataBase(pipelineContext3.getCoroutineContext(), (ByteReadChannel) response, str, str2 != null ? new Long(Long.parseLong(str2)) : null, 0L, 16, null));
                                this.L$0 = pipelineContext3;
                                this.L$1 = null;
                                this.L$2 = expectedType;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.L$6 = null;
                                this.L$7 = null;
                                this.L$8 = null;
                                this.L$9 = null;
                                this.label = 10;
                                objProceedWith = pipelineContext3.proceedWith(httpResponseContainer8, this);
                            } else if (httpResponseContainer2 != null) {
                                logger = DefaultTransformKt.LOGGER;
                                if (LoggerJvmKt.isTraceEnabled(logger)) {
                                    logger.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext3.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                                }
                            }
                            break;
                        } else {
                            ByteReadChannelKt.cancel((ByteReadChannel) response);
                            HttpResponseContainer httpResponseContainer9 = new HttpResponseContainer(expectedType, unit);
                            this.L$0 = pipelineContext3;
                            this.L$1 = null;
                            this.L$2 = expectedType;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.label = 1;
                            objProceedWith4 = pipelineContext3.proceedWith(httpResponseContainer9, this);
                            break;
                        }
                        return coroutineSingletons;
                    }
                    return unit;
                case 1:
                    TypeInfo typeInfo2 = (TypeInfo) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    expectedType = typeInfo2;
                    objProceedWith4 = obj;
                    httpResponseContainer2 = (HttpResponseContainer) objProceedWith4;
                    if (httpResponseContainer2 != null) {
                        logger = DefaultTransformKt.LOGGER;
                        if (LoggerJvmKt.isTraceEnabled(logger)) {
                            logger.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext3.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                        }
                    }
                    return unit;
                case 2:
                    TypeInfo typeInfo3 = (TypeInfo) this.L$6;
                    pipelineContext2 = (PipelineContext) this.L$5;
                    typeInfo = (TypeInfo) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    expectedType = typeInfo3;
                    buffer2 = obj;
                    HttpResponseContainer httpResponseContainer10 = new HttpResponseContainer(expectedType, new Integer(Integer.parseInt(DeprecationKt.readText((Source) buffer2))));
                    this.L$0 = pipelineContext3;
                    this.L$1 = null;
                    this.L$2 = typeInfo;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.L$6 = null;
                    this.label = 3;
                    objProceedWith5 = pipelineContext2.proceedWith(httpResponseContainer10, this);
                    break;
                case 3:
                    TypeInfo typeInfo4 = (TypeInfo) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    typeInfo = typeInfo4;
                    objProceedWith5 = obj;
                    httpResponseContainer2 = (HttpResponseContainer) objProceedWith5;
                    expectedType = typeInfo;
                    if (httpResponseContainer2 != null) {
                        logger = DefaultTransformKt.LOGGER;
                        if (LoggerJvmKt.isTraceEnabled(logger)) {
                            logger.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext3.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                        }
                    }
                    return unit;
                case 4:
                    TypeInfo typeInfo5 = (TypeInfo) this.L$6;
                    pipelineContext = (PipelineContext) this.L$5;
                    typeInfo = (TypeInfo) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    expectedType = typeInfo5;
                    buffer = obj;
                    HttpResponseContainer httpResponseContainer11 = new HttpResponseContainer(expectedType, buffer);
                    this.L$0 = pipelineContext3;
                    this.L$1 = null;
                    this.L$2 = typeInfo;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.L$6 = null;
                    this.label = 5;
                    objProceedWith6 = pipelineContext.proceedWith(httpResponseContainer11, this);
                    break;
                case 5:
                    TypeInfo typeInfo6 = (TypeInfo) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    typeInfo = typeInfo6;
                    objProceedWith6 = obj;
                    httpResponseContainer2 = (HttpResponseContainer) objProceedWith6;
                    expectedType = typeInfo;
                    if (httpResponseContainer2 != null) {
                        logger = DefaultTransformKt.LOGGER;
                        if (LoggerJvmKt.isTraceEnabled(logger)) {
                            logger.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext3.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                        }
                    }
                    return unit;
                case 6:
                    TypeInfo typeInfo7 = (TypeInfo) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    expectedType = typeInfo7;
                    byteArray = obj;
                    byte[] bArr2 = (byte[]) byteArray;
                    UtilsKt.checkContentLength(HttpMessagePropertiesKt.contentLength(((HttpClientCall) pipelineContext3.getContext()).getResponse()), bArr2.length, ((HttpClientCall) pipelineContext3.getContext()).getRequest().getMethod());
                    HttpResponseContainer httpResponseContainer12 = new HttpResponseContainer(expectedType, bArr2);
                    this.L$0 = pipelineContext3;
                    this.L$1 = null;
                    this.L$2 = expectedType;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.label = 7;
                    objProceedWith7 = pipelineContext3.proceedWith(httpResponseContainer12, this);
                    break;
                case 7:
                    TypeInfo typeInfo8 = (TypeInfo) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    expectedType = typeInfo8;
                    objProceedWith7 = obj;
                    httpResponseContainer2 = (HttpResponseContainer) objProceedWith7;
                    if (httpResponseContainer2 != null) {
                        logger = DefaultTransformKt.LOGGER;
                        if (LoggerJvmKt.isTraceEnabled(logger)) {
                            logger.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext3.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                        }
                    }
                    return unit;
                case 8:
                    TypeInfo typeInfo9 = (TypeInfo) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    expectedType = typeInfo9;
                    objProceedWith3 = obj;
                    httpResponseContainer2 = (HttpResponseContainer) objProceedWith3;
                    if (httpResponseContainer2 != null) {
                        logger = DefaultTransformKt.LOGGER;
                        if (LoggerJvmKt.isTraceEnabled(logger)) {
                            logger.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext3.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                        }
                    }
                    return unit;
                case 9:
                    TypeInfo typeInfo10 = (TypeInfo) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    expectedType = typeInfo10;
                    objProceedWith2 = obj;
                    httpResponseContainer2 = (HttpResponseContainer) objProceedWith2;
                    if (httpResponseContainer2 != null) {
                        logger = DefaultTransformKt.LOGGER;
                        if (LoggerJvmKt.isTraceEnabled(logger)) {
                            logger.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext3.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                        }
                    }
                    return unit;
                case 10:
                    TypeInfo typeInfo11 = (TypeInfo) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    expectedType = typeInfo11;
                    objProceedWith = obj;
                    httpResponseContainer2 = (HttpResponseContainer) objProceedWith;
                    if (httpResponseContainer2 != null) {
                        logger = DefaultTransformKt.LOGGER;
                        if (LoggerJvmKt.isTraceEnabled(logger)) {
                            logger.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext3.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                        }
                    }
                    return unit;
                default:
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        }
    }

    public static final void defaultTransformers(HttpClient httpClient) {
        httpClient.getClass();
        httpClient.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getRender(), new AnonymousClass1(null));
        httpClient.getResponsePipeline().intercept(HttpResponsePipeline.INSTANCE.getParse(), new AnonymousClass2(httpClient, null));
        DefaultTransformersJvmKt.platformResponseDefaultTransformers(httpClient);
    }
}
