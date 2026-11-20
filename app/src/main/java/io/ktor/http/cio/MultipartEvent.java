package io.ktor.http.cio;

import com.yalantis.ucrop.BuildConfig;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.JobSupport;
import kotlinx.io.Source;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\u0005\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lio/ktor/http/cio/MultipartEvent;", "", "<init>", "()V", "", BuildConfig.BUILD_TYPE, "releaseSuspend", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Preamble", "MultipartPart", "Epilogue", "Lio/ktor/http/cio/MultipartEvent$Epilogue;", "Lio/ktor/http/cio/MultipartEvent$MultipartPart;", "Lio/ktor/http/cio/MultipartEvent$Preamble;", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class MultipartEvent {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/http/cio/MultipartEvent$Epilogue;", "Lio/ktor/http/cio/MultipartEvent;", "Lkotlinx/io/Source;", "body", "<init>", "(Lkotlinx/io/Source;)V", "", BuildConfig.BUILD_TYPE, "()V", "releaseSuspend", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/io/Source;", "getBody", "()Lkotlinx/io/Source;", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Epilogue extends MultipartEvent {
        private final Source body;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Epilogue(Source source) {
            super(null);
            source.getClass();
            this.body = source;
        }

        public final Source getBody() {
            return this.body;
        }

        @Override // io.ktor.http.cio.MultipartEvent
        @Deprecated
        public void release() throws Exception {
            this.body.close();
        }

        @Override // io.ktor.http.cio.MultipartEvent
        public Object releaseSuspend(Continuation continuation) throws Exception {
            this.body.close();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tH\u0096@¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/http/cio/MultipartEvent$MultipartPart;", "Lio/ktor/http/cio/MultipartEvent;", "Lkotlinx/coroutines/Deferred;", "Lio/ktor/http/cio/HttpHeadersMap;", "headers", "Lio/ktor/utils/io/ByteReadChannel;", "body", "<init>", "(Lkotlinx/coroutines/Deferred;Lio/ktor/utils/io/ByteReadChannel;)V", "", BuildConfig.BUILD_TYPE, "()V", "releaseSuspend", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Deferred;", "getHeaders", "()Lkotlinx/coroutines/Deferred;", "Lio/ktor/utils/io/ByteReadChannel;", "getBody", "()Lio/ktor/utils/io/ByteReadChannel;", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class MultipartPart extends MultipartEvent {
        private final ByteReadChannel body;
        private final Deferred headers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultipartPart(Deferred deferred, ByteReadChannel byteReadChannel) {
            super(null);
            deferred.getClass();
            byteReadChannel.getClass();
            this.headers = deferred;
            this.body = byteReadChannel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit release$lambda$0(MultipartPart multipartPart, Throwable th) {
            if (th == null) {
                ((HttpHeadersMap) multipartPart.headers.getCompleted()).release();
            }
            return Unit.INSTANCE;
        }

        public final ByteReadChannel getBody() {
            return this.body;
        }

        public final Deferred getHeaders() {
            return this.headers;
        }

        @Override // io.ktor.http.cio.MultipartEvent
        @Deprecated
        public void release() {
            ((JobSupport) this.headers).invokeOnCompletion(new MimesKt$$ExternalSyntheticLambda0((byte) 28, this));
            MultipartJvmAndPosixKt.discardBlocking(this.body);
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0014  */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
        
            if (io.ktor.utils.io.ByteReadChannelOperationsKt.discard$default(r1, 0, r4, 1, null) == r7) goto L34;
         */
        @Override // io.ktor.http.cio.MultipartEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object releaseSuspend(Continuation continuation) throws Throwable {
            MultipartEvent$MultipartPart$releaseSuspend$1 multipartEvent$MultipartPart$releaseSuspend$1;
            if (continuation instanceof MultipartEvent$MultipartPart$releaseSuspend$1) {
                multipartEvent$MultipartPart$releaseSuspend$1 = (MultipartEvent$MultipartPart$releaseSuspend$1) continuation;
                int i = multipartEvent$MultipartPart$releaseSuspend$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    multipartEvent$MultipartPart$releaseSuspend$1.label = i - Integer.MIN_VALUE;
                } else {
                    multipartEvent$MultipartPart$releaseSuspend$1 = new MultipartEvent$MultipartPart$releaseSuspend$1(this, continuation);
                }
            } else {
                multipartEvent$MultipartPart$releaseSuspend$1 = new MultipartEvent$MultipartPart$releaseSuspend$1(this, continuation);
            }
            MultipartEvent$MultipartPart$releaseSuspend$1 multipartEvent$MultipartPart$releaseSuspend$2 = multipartEvent$MultipartPart$releaseSuspend$1;
            Object objAwait = multipartEvent$MultipartPart$releaseSuspend$2.result;
            int i2 = multipartEvent$MultipartPart$releaseSuspend$2.label;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objAwait);
                    Deferred deferred = this.headers;
                    multipartEvent$MultipartPart$releaseSuspend$2.label = 1;
                    objAwait = deferred.await(multipartEvent$MultipartPart$releaseSuspend$2);
                    if (objAwait == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objAwait);
                } else {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        Throwable th = (Throwable) multipartEvent$MultipartPart$releaseSuspend$2.L$0;
                        ResultKt.throwOnFailure(objAwait);
                        throw th;
                    }
                    ResultKt.throwOnFailure(objAwait);
                }
                return Unit.INSTANCE;
                ((HttpHeadersMap) objAwait).release();
                ByteReadChannel byteReadChannel = this.body;
                multipartEvent$MultipartPart$releaseSuspend$2.label = 2;
            } catch (Throwable th2) {
                ByteReadChannel byteReadChannel2 = this.body;
                multipartEvent$MultipartPart$releaseSuspend$2.L$0 = th2;
                multipartEvent$MultipartPart$releaseSuspend$2.label = 3;
                if (ByteReadChannelOperationsKt.discard$default(byteReadChannel2, 0L, multipartEvent$MultipartPart$releaseSuspend$2, 1, null) != coroutineSingletons) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/http/cio/MultipartEvent$Preamble;", "Lio/ktor/http/cio/MultipartEvent;", "Lkotlinx/io/Source;", "body", "<init>", "(Lkotlinx/io/Source;)V", "", BuildConfig.BUILD_TYPE, "()V", "releaseSuspend", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/io/Source;", "getBody", "()Lkotlinx/io/Source;", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Preamble extends MultipartEvent {
        private final Source body;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Preamble(Source source) {
            super(null);
            source.getClass();
            this.body = source;
        }

        public final Source getBody() {
            return this.body;
        }

        @Override // io.ktor.http.cio.MultipartEvent
        @Deprecated
        public void release() throws Exception {
            this.body.close();
        }

        @Override // io.ktor.http.cio.MultipartEvent
        public Object releaseSuspend(Continuation continuation) throws Exception {
            this.body.close();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ MultipartEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Deprecated
    public abstract void release();

    public abstract Object releaseSuspend(Continuation continuation);

    private MultipartEvent() {
    }
}
