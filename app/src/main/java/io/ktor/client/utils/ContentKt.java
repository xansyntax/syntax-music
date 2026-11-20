package io.ktor.client.utils;

import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.LongRange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/http/content/OutgoingContent;", "Lkotlin/Function1;", "Lio/ktor/http/Headers;", "block", "wrapHeaders", "(Lio/ktor/http/content/OutgoingContent;Lkotlin/jvm/functions/Function1;)Lio/ktor/http/content/OutgoingContent;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ContentKt {
    public static final OutgoingContent wrapHeaders(OutgoingContent outgoingContent, Function1 function1) {
        outgoingContent.getClass();
        function1.getClass();
        if (outgoingContent instanceof OutgoingContent.NoContent) {
            return new OutgoingContent.NoContent(function1, outgoingContent) { // from class: io.ktor.client.utils.ContentKt.wrapHeaders.1
                final /* synthetic */ OutgoingContent $this_wrapHeaders;
                private final Headers headers;

                {
                    this.$this_wrapHeaders = outgoingContent;
                    this.headers = (Headers) function1.invoke(outgoingContent.getHeaders());
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Long getContentLength() {
                    return this.$this_wrapHeaders.getContentLength();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public ContentType getContentType() {
                    return this.$this_wrapHeaders.getContentType();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Headers getHeaders() {
                    return this.headers;
                }

                @Override // io.ktor.http.content.OutgoingContent
                public HttpStatusCode getStatus() {
                    return this.$this_wrapHeaders.getStatus();
                }
            };
        }
        if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
            return new OutgoingContent.ReadChannelContent(function1, outgoingContent) { // from class: io.ktor.client.utils.ContentKt.wrapHeaders.2
                final /* synthetic */ OutgoingContent $this_wrapHeaders;
                private final Headers headers;

                {
                    this.$this_wrapHeaders = outgoingContent;
                    this.headers = (Headers) function1.invoke(outgoingContent.getHeaders());
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Long getContentLength() {
                    return this.$this_wrapHeaders.getContentLength();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public ContentType getContentType() {
                    return this.$this_wrapHeaders.getContentType();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Headers getHeaders() {
                    return this.headers;
                }

                @Override // io.ktor.http.content.OutgoingContent
                public HttpStatusCode getStatus() {
                    return this.$this_wrapHeaders.getStatus();
                }

                @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                public ByteReadChannel readFrom(LongRange range) {
                    range.getClass();
                    return ((OutgoingContent.ReadChannelContent) this.$this_wrapHeaders).readFrom(range);
                }

                @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                public ByteReadChannel readFrom() {
                    return ((OutgoingContent.ReadChannelContent) this.$this_wrapHeaders).readFrom();
                }
            };
        }
        if (outgoingContent instanceof OutgoingContent.WriteChannelContent) {
            return new OutgoingContent.WriteChannelContent(function1, outgoingContent) { // from class: io.ktor.client.utils.ContentKt.wrapHeaders.3
                final /* synthetic */ OutgoingContent $this_wrapHeaders;
                private final Headers headers;

                {
                    this.$this_wrapHeaders = outgoingContent;
                    this.headers = (Headers) function1.invoke(outgoingContent.getHeaders());
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Long getContentLength() {
                    return this.$this_wrapHeaders.getContentLength();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public ContentType getContentType() {
                    return this.$this_wrapHeaders.getContentType();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Headers getHeaders() {
                    return this.headers;
                }

                @Override // io.ktor.http.content.OutgoingContent
                public HttpStatusCode getStatus() {
                    return this.$this_wrapHeaders.getStatus();
                }

                @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
                public Object writeTo(ByteWriteChannel byteWriteChannel, Continuation continuation) {
                    Object objWriteTo = ((OutgoingContent.WriteChannelContent) this.$this_wrapHeaders).writeTo(byteWriteChannel, continuation);
                    return objWriteTo == CoroutineSingletons.COROUTINE_SUSPENDED ? objWriteTo : Unit.INSTANCE;
                }
            };
        }
        if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
            return new OutgoingContent.ByteArrayContent(function1, outgoingContent) { // from class: io.ktor.client.utils.ContentKt.wrapHeaders.4
                final /* synthetic */ OutgoingContent $this_wrapHeaders;
                private final Headers headers;

                {
                    this.$this_wrapHeaders = outgoingContent;
                    this.headers = (Headers) function1.invoke(outgoingContent.getHeaders());
                }

                @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
                /* JADX INFO: renamed from: bytes */
                public byte[] getBytes() {
                    return ((OutgoingContent.ByteArrayContent) this.$this_wrapHeaders).getBytes();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Long getContentLength() {
                    return this.$this_wrapHeaders.getContentLength();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public ContentType getContentType() {
                    return this.$this_wrapHeaders.getContentType();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Headers getHeaders() {
                    return this.headers;
                }

                @Override // io.ktor.http.content.OutgoingContent
                public HttpStatusCode getStatus() {
                    return this.$this_wrapHeaders.getStatus();
                }
            };
        }
        if (outgoingContent instanceof OutgoingContent.ProtocolUpgrade) {
            return new OutgoingContent.ProtocolUpgrade(function1, outgoingContent) { // from class: io.ktor.client.utils.ContentKt.wrapHeaders.5
                final /* synthetic */ OutgoingContent $this_wrapHeaders;
                private final Headers headers;

                {
                    this.$this_wrapHeaders = outgoingContent;
                    this.headers = (Headers) function1.invoke(outgoingContent.getHeaders());
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Long getContentLength() {
                    return this.$this_wrapHeaders.getContentLength();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public ContentType getContentType() {
                    return this.$this_wrapHeaders.getContentType();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Headers getHeaders() {
                    return this.headers;
                }

                @Override // io.ktor.http.content.OutgoingContent.ProtocolUpgrade
                public Object upgrade(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, Continuation continuation) {
                    return ((OutgoingContent.ProtocolUpgrade) this.$this_wrapHeaders).upgrade(byteReadChannel, byteWriteChannel, coroutineContext, coroutineContext2, continuation);
                }
            };
        }
        if (outgoingContent instanceof OutgoingContent.ContentWrapper) {
            return wrapHeaders(((OutgoingContent.ContentWrapper) outgoingContent).getDelegate(), function1);
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return null;
    }
}
