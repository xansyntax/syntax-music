package io.ktor.client.engine.okhttp;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.jvm.javaio.WritingKt;
import io.ktor.utils.io.streams.StreamsKt;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.BufferedSink;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001c¨\u0006\u001d"}, d2 = {"Lio/ktor/client/engine/okhttp/StreamRequestBody;", "Lokhttp3/RequestBody;", "Lkotlin/coroutines/CoroutineContext;", "callContext", "", "contentLength", "", "duplex", "Lkotlin/Function0;", "Lio/ktor/utils/io/ByteReadChannel;", "block", "<init>", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Long;ZLkotlin/jvm/functions/Function0;)V", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "Lokio/BufferedSink;", "sink", "", "writeTo", "(Lokio/BufferedSink;)V", "()J", "isOneShot", "()Z", "isDuplex", "Lkotlin/coroutines/CoroutineContext;", "Ljava/lang/Long;", "Z", "Lkotlin/jvm/functions/Function0;", "ktor-client-okhttp"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StreamRequestBody extends RequestBody {
    private final Function0 block;
    private final CoroutineContext callContext;
    private final Long contentLength;
    private final boolean duplex;

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.StreamRequestBody$writeTo$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.StreamRequestBody$writeTo$1", f = "StreamRequestBody.kt", l = {37}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ BufferedSink $sink;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BufferedSink bufferedSink, Continuation continuation) {
            super(2, continuation);
            this.$sink = bufferedSink;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = StreamRequestBody.this.new AnonymousClass1(this.$sink, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int, java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r5v11 */
        /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Throwable] */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Throwable] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            BufferedSink bufferedSink;
            Closeable closeable;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ?? r1 = this.label;
            Long th = null;
            try {
                try {
                    if (r1 == 0) {
                        ResultKt.throwOnFailure(obj);
                        ByteReadChannel byteReadChannel = (ByteReadChannel) StreamRequestBody.this.block.invoke();
                        BufferedSink bufferedSink2 = this.$sink;
                        try {
                            ByteWriteChannel byteWriteChannelAsByteWriteChannel = StreamsKt.asByteWriteChannel(bufferedSink2.outputStream());
                            this.L$0 = coroutineScope;
                            this.L$1 = null;
                            this.L$2 = bufferedSink2;
                            this.L$3 = bufferedSink2;
                            this.I$0 = 0;
                            this.I$1 = 0;
                            this.label = 1;
                            obj = ByteReadChannelOperationsKt.copyTo(byteReadChannel, byteWriteChannelAsByteWriteChannel, this);
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            if (obj == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            bufferedSink = bufferedSink2;
                            closeable = bufferedSink2;
                        } catch (CancellationException e) {
                            e = e;
                            bufferedSink = bufferedSink2;
                            bufferedSink.flush();
                            throw e;
                        }
                    } else {
                        if (r1 != 1) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        bufferedSink = (BufferedSink) this.L$3;
                        Closeable closeable2 = (Closeable) this.L$2;
                        try {
                            ResultKt.throwOnFailure(obj);
                            bufferedSink = bufferedSink;
                            closeable = closeable2;
                        } catch (CancellationException e2) {
                            e = e2;
                            try {
                                bufferedSink.flush();
                            } catch (Throwable unused) {
                            }
                            throw e;
                        }
                    }
                    Long l = new Long(((Number) obj).longValue());
                    if (closeable != null) {
                        try {
                            closeable.close();
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    th = th;
                    th = l;
                } catch (Throwable th3) {
                    th = th3;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (Throwable th4) {
                            ResultKt.addSuppressed(th, th4);
                        }
                    }
                }
                if (th != 0) {
                    throw th;
                }
                th.getClass();
                return Unit.INSTANCE;
            } catch (IOException e3) {
                throw e3;
            } catch (Throwable th5) {
                throw new StreamAdapterIOException(th5);
            }
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.StreamRequestBody$writeTo$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.StreamRequestBody$writeTo$2", f = "StreamRequestBody.kt", l = {57}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ ByteReadChannel $channel;
        final /* synthetic */ BufferedSink $sink;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ByteReadChannel byteReadChannel, BufferedSink bufferedSink, Continuation continuation) {
            super(2, continuation);
            this.$channel = byteReadChannel;
            this.$sink = bufferedSink;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$channel, this.$sink, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            ByteReadChannel byteReadChannel = this.$channel;
            OutputStream outputStream = this.$sink.outputStream();
            this.label = 1;
            Object objCopyTo$default = WritingKt.copyTo$default(byteReadChannel, outputStream, 0L, this, 2, null);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return objCopyTo$default == coroutineSingletons ? coroutineSingletons : objCopyTo$default;
        }
    }

    public StreamRequestBody(CoroutineContext coroutineContext, Long l, boolean z, Function0 function0) {
        coroutineContext.getClass();
        function0.getClass();
        this.callContext = coroutineContext;
        this.contentLength = l;
        this.duplex = z;
        this.block = function0;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        Long l = this.contentLength;
        if (l != null) {
            return l.longValue();
        }
        return -1L;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return null;
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: isDuplex, reason: from getter */
    public boolean getDuplex() {
        return this.duplex;
    }

    @Override // okhttp3.RequestBody
    public boolean isOneShot() {
        return true;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        sink.getClass();
        if (this.duplex) {
            ContextScope contextScopeCoroutineScope = AwaitKt.CoroutineScope(this.callContext);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            AwaitKt.launch$default(contextScopeCoroutineScope, DefaultIoScheduler.INSTANCE, null, new AnonymousClass1(sink, null), 2);
            return;
        }
        try {
            ByteReadChannel byteReadChannel = (ByteReadChannel) this.block.invoke();
            try {
                ((Number) AwaitKt.runBlockingK(AwaitKt.getJob(this.callContext), new AnonymousClass2(byteReadChannel, sink, null))).longValue();
            } catch (Throwable th) {
                byteReadChannel.cancel(th);
                throw th;
            }
        } catch (IOException e) {
            throw e;
        } catch (Throwable th2) {
            throw new StreamAdapterIOException(th2);
        }
    }
}
