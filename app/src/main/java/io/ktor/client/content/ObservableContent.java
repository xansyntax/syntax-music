package io.ktor.client.content;

import io.ktor.client.call.UnsupportedContentTypeException;
import io.ktor.client.utils.ByteChannelUtilsKt;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u000e*\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u0015\u001a\u00020\u0014\"\b\b\u0000\u0010\u000e*\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u0016\u0010!\u001a\u0004\u0018\u00010\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u0004\u0018\u00010\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u0004\u0018\u00010&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"Lio/ktor/client/content/ObservableContent;", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Lio/ktor/http/content/OutgoingContent;", "delegate", "Lkotlin/coroutines/CoroutineContext;", "callContext", "Lio/ktor/client/content/ProgressListener;", "listener", "<init>", "(Lio/ktor/http/content/OutgoingContent;Lkotlin/coroutines/CoroutineContext;Lio/ktor/client/content/ProgressListener;)V", "Lio/ktor/utils/io/ByteReadChannel;", "getContent", "(Lio/ktor/http/content/OutgoingContent;)Lio/ktor/utils/io/ByteReadChannel;", "", "T", "Lio/ktor/util/AttributeKey;", "key", "getProperty", "(Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", "value", "", "setProperty", "(Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "readFrom", "()Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/http/content/OutgoingContent;", "getDelegate", "()Lio/ktor/http/content/OutgoingContent;", "Lkotlin/coroutines/CoroutineContext;", "Lio/ktor/client/content/ProgressListener;", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "contentType", "", "getContentLength", "()Ljava/lang/Long;", "contentLength", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "status", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "headers", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ObservableContent extends OutgoingContent.ReadChannelContent {
    private final CoroutineContext callContext;
    private final OutgoingContent delegate;
    private final ProgressListener listener;

    /* JADX INFO: renamed from: io.ktor.client.content.ObservableContent$getContent$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.content.ObservableContent$getContent$1", f = "ObservableContent.kt", l = {58}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ OutgoingContent $delegate;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OutgoingContent outgoingContent, Continuation continuation) {
            super(2, continuation);
            this.$delegate = outgoingContent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$delegate, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WriterScope writerScope = (WriterScope) this.L$0;
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                OutgoingContent.WriteChannelContent writeChannelContent = (OutgoingContent.WriteChannelContent) this.$delegate;
                ByteWriteChannel channel = writerScope.getChannel();
                this.L$0 = null;
                this.label = 1;
                Object objWriteTo = writeChannelContent.writeTo(channel, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objWriteTo == coroutineSingletons) {
                    return coroutineSingletons;
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

    public ObservableContent(OutgoingContent outgoingContent, CoroutineContext coroutineContext, ProgressListener progressListener) {
        outgoingContent.getClass();
        coroutineContext.getClass();
        progressListener.getClass();
        this.delegate = outgoingContent;
        this.callContext = coroutineContext;
        this.listener = progressListener;
    }

    private final ByteReadChannel getContent(OutgoingContent delegate) {
        if (delegate instanceof OutgoingContent.ContentWrapper) {
            return getContent(((OutgoingContent.ContentWrapper) delegate).getDelegate());
        }
        if (delegate instanceof OutgoingContent.ByteArrayContent) {
            return ByteChannelCtorKt.ByteReadChannel$default(((OutgoingContent.ByteArrayContent) delegate).getBytes(), 0, 0, 6, null);
        }
        if (delegate instanceof OutgoingContent.ProtocolUpgrade) {
            throw new UnsupportedContentTypeException(delegate);
        }
        if (delegate instanceof OutgoingContent.NoContent) {
            return ByteReadChannel.INSTANCE.getEmpty();
        }
        if (delegate instanceof OutgoingContent.ReadChannelContent) {
            return ((OutgoingContent.ReadChannelContent) delegate).readFrom();
        }
        if (!(delegate instanceof OutgoingContent.WriteChannelContent)) {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return null;
        }
        return ByteWriteChannelOperationsKt.writer((CoroutineScope) GlobalScope.INSTANCE, this.callContext, true, (Function2) new AnonymousClass1(delegate, null)).getChannel();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        return this.delegate.getContentLength();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.delegate.getContentType();
    }

    public final OutgoingContent getDelegate() {
        return this.delegate;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Headers getHeaders() {
        return this.delegate.getHeaders();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public <T> T getProperty(AttributeKey<T> key) {
        key.getClass();
        return (T) this.delegate.getProperty(key);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public HttpStatusCode getStatus() {
        return this.delegate.getStatus();
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public ByteReadChannel readFrom() {
        return ByteChannelUtilsKt.observable(getContent(this.delegate), this.callContext, getContentLength(), this.listener);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public <T> void setProperty(AttributeKey<T> key, T value) {
        key.getClass();
        this.delegate.setProperty(key, value);
    }
}
