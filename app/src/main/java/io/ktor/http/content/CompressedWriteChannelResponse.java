package io.ktor.http.content;

import com.yalantis.ucrop.UCrop;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.AttributeKey;
import io.ktor.util.ContentEncoder;
import io.ktor.util.StringValuesKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\r\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\n*\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0011\u001a\u00020\u0010\"\b\b\u0000\u0010\n*\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u0004\u0018\u00010&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010-\u001a\u0004\u0018\u00010*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u0004\u0018\u00010.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lio/ktor/http/content/CompressedWriteChannelResponse;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "original", "Lio/ktor/util/ContentEncoder;", "encoder", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Lio/ktor/http/content/OutgoingContent$WriteChannelContent;Lio/ktor/util/ContentEncoder;Lkotlin/coroutines/CoroutineContext;)V", "", "T", "Lio/ktor/util/AttributeKey;", "key", "getProperty", "(Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", "value", "", "setProperty", "(Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "writeTo", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "getOriginal", "()Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "Lio/ktor/util/ContentEncoder;", "getEncoder", "()Lio/ktor/util/ContentEncoder;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lio/ktor/http/Headers;", "headers$delegate", "Lkotlin/Lazy;", "getHeaders", "()Lio/ktor/http/Headers;", "headers", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "status", "", "getContentLength", "()Ljava/lang/Long;", "contentLength", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class CompressedWriteChannelResponse extends OutgoingContent.WriteChannelContent {
    private final CoroutineContext coroutineContext;
    private final ContentEncoder encoder;

    /* JADX INFO: renamed from: headers$delegate, reason: from kotlin metadata */
    private final Lazy headers;
    private final OutgoingContent.WriteChannelContent original;

    /* JADX INFO: renamed from: io.ktor.http.content.CompressedWriteChannelResponse$writeTo$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.content.CompressedWriteChannelResponse$writeTo$2", f = "CompressedContent.kt", l = {UCrop.RESULT_ERROR}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ ByteWriteChannel $channel;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ByteWriteChannel byteWriteChannel, Continuation continuation) {
            super(2, continuation);
            this.$channel = byteWriteChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = CompressedWriteChannelResponse.this.new AnonymousClass2(this.$channel, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Throwable th;
            ByteWriteChannel byteWriteChannel;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                byteWriteChannel = (ByteWriteChannel) this.L$1;
                try {
                    ResultKt.throwOnFailure(obj);
                    ByteWriteChannelKt.close(byteWriteChannel);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        ByteWriteChannelOperationsKt.close(byteWriteChannel, th);
                        throw th;
                    } catch (Throwable th3) {
                        ByteWriteChannelKt.close(byteWriteChannel);
                        throw th3;
                    }
                }
            }
            ResultKt.throwOnFailure(obj);
            ByteWriteChannel byteWriteChannelEncode = CompressedWriteChannelResponse.this.getEncoder().encode(this.$channel, coroutineScope.getCoroutineContext());
            try {
                OutgoingContent.WriteChannelContent original = CompressedWriteChannelResponse.this.getOriginal();
                this.L$0 = null;
                this.L$1 = byteWriteChannelEncode;
                this.L$2 = null;
                this.I$0 = 0;
                this.I$1 = 0;
                this.label = 1;
                Object objWriteTo = original.writeTo(byteWriteChannelEncode, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objWriteTo == coroutineSingletons) {
                    return coroutineSingletons;
                }
                byteWriteChannel = byteWriteChannelEncode;
                ByteWriteChannelKt.close(byteWriteChannel);
                return Unit.INSTANCE;
            } catch (Throwable th4) {
                th = th4;
                byteWriteChannel = byteWriteChannelEncode;
                ByteWriteChannelOperationsKt.close(byteWriteChannel, th);
                throw th;
            }
        }
    }

    public CompressedWriteChannelResponse(OutgoingContent.WriteChannelContent writeChannelContent, ContentEncoder contentEncoder, CoroutineContext coroutineContext) {
        writeChannelContent.getClass();
        contentEncoder.getClass();
        coroutineContext.getClass();
        this.original = writeChannelContent;
        this.encoder = contentEncoder;
        this.coroutineContext = coroutineContext;
        this.headers = ResultKt.lazy(LazyThreadSafetyMode.NONE, new MultipartJvmKt$$ExternalSyntheticLambda0((byte) 2, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Headers headers_delegate$lambda$0(CompressedWriteChannelResponse compressedWriteChannelResponse) {
        Headers.Companion companion = Headers.INSTANCE;
        byte b = 1;
        HeadersBuilder headersBuilder = new HeadersBuilder(0, b, null);
        StringValuesKt.appendFiltered$default(headersBuilder, compressedWriteChannelResponse.original.getHeaders(), false, new CompressedReadChannelResponse$$ExternalSyntheticLambda1(b), 2, null);
        headersBuilder.append(HttpHeaders.ContentEncoding, compressedWriteChannelResponse.encoder.getName());
        String str = compressedWriteChannelResponse.original.getHeaders().get(HttpHeaders.Vary);
        headersBuilder.append(HttpHeaders.Vary, str != null ? str.concat(", Accept-Encoding") : HttpHeaders.AcceptEncoding);
        return headersBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean headers_delegate$lambda$0$0$0(String str, String str2) {
        str.getClass();
        str2.getClass();
        return !str.equalsIgnoreCase(HttpHeaders.ContentLength);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        Long contentLength = this.original.getContentLength();
        if (contentLength != null) {
            Long lPredictCompressedLength = this.encoder.predictCompressedLength(contentLength.longValue());
            if (lPredictCompressedLength != null && lPredictCompressedLength.longValue() >= 0) {
                return lPredictCompressedLength;
            }
        }
        return null;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.original.getContentType();
    }

    public final CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final ContentEncoder getEncoder() {
        return this.encoder;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Headers getHeaders() {
        return (Headers) this.headers.getValue();
    }

    public final OutgoingContent.WriteChannelContent getOriginal() {
        return this.original;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public <T> T getProperty(AttributeKey<T> key) {
        key.getClass();
        return (T) this.original.getProperty(key);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public HttpStatusCode getStatus() {
        return this.original.getStatus();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public <T> void setProperty(AttributeKey<T> key, T value) {
        key.getClass();
        this.original.setProperty(key, value);
    }

    @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
    public Object writeTo(ByteWriteChannel byteWriteChannel, Continuation continuation) {
        Object objWithContext = AwaitKt.withContext(this.coroutineContext, new AnonymousClass2(byteWriteChannel, null), continuation);
        return objWithContext == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithContext : Unit.INSTANCE;
    }
}
