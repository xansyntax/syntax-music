package io.ktor.utils.io;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda8;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.core.StringsKt__StringsKt;
import java.nio.charset.Charset;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.io.Buffer;
import kotlinx.io.RawSource;
import kotlinx.io.RealSource;
import kotlinx.io.Segment;
import kotlinx.io.Sink;
import kotlinx.io.SinksKt;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Ó\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0007*\u0001Z\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\tH\u0086@¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\fH\u0086@¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0010\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001c\u0010\u0017\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001c\u0010\u001b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001dH\u0086@¢\u0006\u0004\b\u001e\u0010\u001f\u001a0\u0010\"\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00152\b\b\u0002\u0010 \u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020\tH\u0086@¢\u0006\u0004\b\"\u0010#\u001a\u001c\u0010%\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u001a\u001a\u00020$H\u0086@¢\u0006\u0004\b%\u0010&\u001a$\u0010%\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020$2\u0006\u0010'\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b%\u0010(\u001a\u001c\u0010)\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001dH\u0086@¢\u0006\u0004\b)\u0010\u001f\u001a\u001c\u0010,\u001a\u00020\u0003*\u00020\u00002\u0006\u0010+\u001a\u00020*H\u0086@¢\u0006\u0004\b,\u0010-\u001a\u001c\u0010,\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@¢\u0006\u0004\b,\u0010\u001c\u001a\u001b\u00100\u001a\u00020\u0003*\u00020\u00002\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b0\u00101\u001a\u0014\u00103\u001a\u00020\u0003*\u000202H\u0086@¢\u0006\u0004\b3\u00104\u001a\u0015\u00107\u001a\u000605j\u0002`6*\u000202¢\u0006\u0004\b7\u00108\u001a'\u0010<\u001a\u00020;*\u0002022\u0014\u0010:\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0004\u0012\u00020\u000309¢\u0006\u0004\b<\u0010=\u001a!\u0010<\u001a\u00020\u0003*\u0002022\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00030>H\u0007¢\u0006\u0004\b<\u0010?\u001a\u0011\u0010@\u001a\u00020\u0003*\u000202¢\u0006\u0004\b@\u0010A\u001aI\u0010L\u001a\u00020K*\u00020B2\b\b\u0002\u0010D\u001a\u00020C2\b\b\u0002\u0010F\u001a\u00020E2\"\u0010:\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020H\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030I\u0012\u0006\u0012\u0004\u0018\u00010J0G¢\u0006\u0004\bL\u0010M\u001aG\u0010L\u001a\u00020K*\u00020B2\b\b\u0002\u0010D\u001a\u00020C2\u0006\u0010O\u001a\u00020N2\"\u0010:\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020H\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030I\u0012\u0006\u0012\u0004\u0018\u00010J0G¢\u0006\u0004\bL\u0010P\u001a>\u0010S\u001a\u00020\t*\u00020\u00002\b\b\u0002\u0010Q\u001a\u00020\t2\u001e\u0010:\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0RH\u0086@¢\u0006\u0004\bS\u0010T\u001a\u0014\u0010U\u001a\u00020\u0003*\u00020\u0000H\u0086@¢\u0006\u0004\bU\u0010V\u001a/\u0010X\u001a\u00020\u0003\"\u0004\b\u0000\u0010W*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000I\u0012\u0006\u0012\u0004\u0018\u00010J09H\u0000¢\u0006\u0004\bX\u0010Y\"\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\\"\u0015\u0010]\u001a\u00020E*\u0002028F¢\u0006\u0006\u001a\u0004\b]\u0010^\"\u0015\u0010_\u001a\u00020E*\u0002028F¢\u0006\u0006\u001a\u0004\b_\u0010^¨\u0006`"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "", "value", "", "writeByte", "(Lio/ktor/utils/io/ByteWriteChannel;BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "writeShort", "(Lio/ktor/utils/io/ByteWriteChannel;SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "writeInt", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "writeFloat", "(Lio/ktor/utils/io/ByteWriteChannel;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "writeDouble", "(Lio/ktor/utils/io/ByteWriteChannel;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "writeLong", "(Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "array", "writeByteArray", "(Lio/ktor/utils/io/ByteWriteChannel;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/io/Source;", "source", "writeSource", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlinx/io/Source;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "writeString", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startIndex", "endIndex", "writeFully", "(Lio/ktor/utils/io/ByteWriteChannel;[BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/io/RawSource;", "writeBuffer", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlinx/io/RawSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "length", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlinx/io/RawSource;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeStringUtf8", "Lkotlinx/io/Buffer;", "copy", "writePacket", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlinx/io/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "close", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/Throwable;)V", "Lio/ktor/utils/io/ChannelJob;", "join", "(Lio/ktor/utils/io/ChannelJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lio/ktor/utils/io/CancellationException;", "getCancellationException", "(Lio/ktor/utils/io/ChannelJob;)Ljava/util/concurrent/CancellationException;", "Lkotlin/Function1;", "block", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(Lio/ktor/utils/io/ChannelJob;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlin/Function0;", "(Lio/ktor/utils/io/ChannelJob;Lkotlin/jvm/functions/Function0;)V", "cancel", "(Lio/ktor/utils/io/ChannelJob;)V", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "", "autoFlush", "Lkotlin/Function2;", "Lio/ktor/utils/io/WriterScope;", "Lkotlin/coroutines/Continuation;", "", "Lio/ktor/utils/io/WriterJob;", "writer", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ZLkotlin/jvm/functions/Function2;)Lio/ktor/utils/io/WriterJob;", "Lio/ktor/utils/io/ByteChannel;", "channel", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lio/ktor/utils/io/ByteChannel;Lkotlin/jvm/functions/Function2;)Lio/ktor/utils/io/WriterJob;", "desiredSpace", "Lkotlin/Function3;", "write", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFreeSpace", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "fireAndForget", "(Lkotlin/jvm/functions/Function1;)V", "io/ktor/utils/io/ByteWriteChannelOperationsKt$NO_CALLBACK$1", "NO_CALLBACK", "Lio/ktor/utils/io/ByteWriteChannelOperationsKt$NO_CALLBACK$1;", "isCompleted", "(Lio/ktor/utils/io/ChannelJob;)Z", "isCancelled", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ByteWriteChannelOperationsKt {
    private static final ByteWriteChannelOperationsKt$NO_CALLBACK$1 NO_CALLBACK = new Continuation() { // from class: io.ktor.utils.io.ByteWriteChannelOperationsKt$NO_CALLBACK$1
        private final CoroutineContext context = EmptyCoroutineContext.INSTANCE;

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.context;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object result) {
        }
    };

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteWriteChannelOperationsKt$close$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1 {
        public AnonymousClass1(Object obj) {
            super(1, obj, ByteWriteChannel.class, "flushAndClose", "flushAndClose(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((ByteWriteChannel) this.receiver).flushAndClose(continuation);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteWriteChannelOperationsKt$write$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteWriteChannelOperationsKt", f = "ByteWriteChannelOperations.kt", l = {226}, m = "write", v = 1)
    public static final class C03641 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03641(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteWriteChannelOperationsKt.write(null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteWriteChannelOperationsKt$writePacket$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteWriteChannelOperationsKt", f = "ByteWriteChannelOperations.kt", l = {119}, m = "writePacket", v = 1)
    public static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteWriteChannelOperationsKt.writePacket((ByteWriteChannel) null, (Source) null, this);
        }
    }

    public static final Object awaitFreeSpace(ByteWriteChannel byteWriteChannel, Continuation continuation) {
        Object objFlush = byteWriteChannel.flush(continuation);
        return objFlush == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlush : Unit.INSTANCE;
    }

    public static final void cancel(ChannelJob channelJob) {
        channelJob.getClass();
        channelJob.getJob().cancel(null);
    }

    public static final void close(ByteWriteChannel byteWriteChannel, Throwable th) throws Throwable {
        byteWriteChannel.getClass();
        if (th == null) {
            fireAndForget(new AnonymousClass1(byteWriteChannel));
        } else {
            byteWriteChannel.cancel(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R> void fireAndForget(final Function1 function1) throws Throwable {
        Continuation continuationCreate;
        function1.getClass();
        final ByteWriteChannelOperationsKt$NO_CALLBACK$1 byteWriteChannelOperationsKt$NO_CALLBACK$1 = NO_CALLBACK;
        try {
            byteWriteChannelOperationsKt$NO_CALLBACK$1.getClass();
            if (function1 instanceof BaseContinuationImpl) {
                continuationCreate = ((BaseContinuationImpl) function1).create(byteWriteChannelOperationsKt$NO_CALLBACK$1);
            } else {
                final CoroutineContext context = byteWriteChannelOperationsKt$NO_CALLBACK$1.getContext();
                continuationCreate = context == EmptyCoroutineContext.INSTANCE ? new RestrictedContinuationImpl(byteWriteChannelOperationsKt$NO_CALLBACK$1) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
                    public byte label;

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        byte b = this.label;
                        if (b == 0) {
                            this.label = (byte) 1;
                            ResultKt.throwOnFailure(obj);
                            Function1 function2 = function1;
                            TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, function2);
                            return function2.invoke(this);
                        }
                        if (b != 1) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This coroutine had already completed");
                            return null;
                        }
                        this.label = (byte) 2;
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                } : new ContinuationImpl(byteWriteChannelOperationsKt$NO_CALLBACK$1, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
                    public byte label;

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        byte b = this.label;
                        if (b == 0) {
                            this.label = (byte) 1;
                            ResultKt.throwOnFailure(obj);
                            Function1 function2 = function1;
                            TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, function2);
                            return function2.invoke(this);
                        }
                        if (b != 1) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This coroutine had already completed");
                            return null;
                        }
                        this.label = (byte) 2;
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                };
            }
            InlineList.resumeCancellableWithInternal(Unit.INSTANCE, Okio__OkioKt.intercepted(continuationCreate));
        } catch (Throwable th) {
            StringsKt__IndentKt.dispatcherFailure(th, byteWriteChannelOperationsKt$NO_CALLBACK$1);
            throw null;
        }
    }

    public static final CancellationException getCancellationException(ChannelJob channelJob) {
        channelJob.getClass();
        return channelJob.getJob().getCancellationException();
    }

    @Deprecated
    public static final /* synthetic */ void invokeOnCompletion(ChannelJob channelJob, Function0 function0) {
        channelJob.getClass();
        function0.getClass();
        channelJob.getJob().invokeOnCompletion(new AppBarKt$$ExternalSyntheticLambda8(function0, (byte) 14));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeOnCompletion$lambda$0(Function0 function0, Throwable th) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final boolean isCancelled(ChannelJob channelJob) {
        channelJob.getClass();
        return channelJob.getJob().isCancelled();
    }

    public static final boolean isCompleted(ChannelJob channelJob) {
        channelJob.getClass();
        return channelJob.getJob().isCompleted();
    }

    public static final Object join(ChannelJob channelJob, Continuation continuation) {
        Object objJoin = channelJob.getJob().join(continuation);
        return objJoin == CoroutineSingletons.COROUTINE_SUSPENDED ? objJoin : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object write(ByteWriteChannel byteWriteChannel, int i, Function3 function3, Continuation continuation) {
        C03641 c03641;
        int i2;
        if (continuation instanceof C03641) {
            c03641 = (C03641) continuation;
            int i3 = c03641.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c03641.label = i3 - Integer.MIN_VALUE;
            } else {
                c03641 = new C03641(continuation);
            }
        } else {
            c03641 = new C03641(continuation);
        }
        Object obj = c03641.result;
        int i4 = c03641.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            int size = BytePacketBuilderKt.getSize(byteWriteChannel.getWriteBuffer());
            Buffer buffer = byteWriteChannel.getWriteBuffer().getBuffer();
            Segment segmentWritableSegment = buffer.writableSegment(i);
            byte[] bArr = segmentWritableSegment.data;
            int iIntValue = ((Number) function3.invoke(bArr, new Integer(segmentWritableSegment.limit), new Integer(bArr.length))).intValue();
            if (iIntValue == i) {
                segmentWritableSegment.limit += iIntValue;
                buffer.sizeMut += (long) iIntValue;
            } else {
                if (iIntValue < 0 || iIntValue > segmentWritableSegment.getRemainingCapacity()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(iIntValue, "Invalid number of bytes written: ", ". Should be in 0.."), segmentWritableSegment.getRemainingCapacity());
                    return null;
                }
                if (iIntValue != 0) {
                    segmentWritableSegment.limit += iIntValue;
                    buffer.sizeMut += (long) iIntValue;
                } else if (Utf8Kt.isEmpty(segmentWritableSegment)) {
                    buffer.recycleTail();
                }
            }
            int size2 = BytePacketBuilderKt.getSize(byteWriteChannel.getWriteBuffer());
            int i5 = size2 - size;
            c03641.L$0 = null;
            c03641.L$1 = null;
            c03641.I$0 = i;
            c03641.I$1 = size;
            c03641.I$2 = size2;
            c03641.I$3 = i5;
            c03641.label = 1;
            Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, c03641);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objFlushIfNeeded == coroutineSingletons) {
                return coroutineSingletons;
            }
            i2 = i5;
        } else {
            if (i4 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i2 = c03641.I$3;
            ResultKt.throwOnFailure(obj);
        }
        return new Integer(i2);
    }

    public static /* synthetic */ Object write$default(ByteWriteChannel byteWriteChannel, int i, Function3 function3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return write(byteWriteChannel, i, function3, continuation);
    }

    public static final Object writeBuffer(ByteWriteChannel byteWriteChannel, RawSource rawSource, Continuation continuation) {
        rawSource.getClass();
        Object objWritePacket = writePacket(byteWriteChannel, new RealSource(rawSource), continuation);
        return objWritePacket == CoroutineSingletons.COROUTINE_SUSPENDED ? objWritePacket : Unit.INSTANCE;
    }

    public static final Object writeByte(ByteWriteChannel byteWriteChannel, byte b, Continuation continuation) {
        byteWriteChannel.getWriteBuffer().writeByte(b);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeByteArray(ByteWriteChannel byteWriteChannel, byte[] bArr, Continuation continuation) {
        byteWriteChannel.getWriteBuffer().write(bArr, 0, bArr.length);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeDouble(ByteWriteChannel byteWriteChannel, double d, Continuation continuation) {
        Sink writeBuffer = byteWriteChannel.getWriteBuffer();
        byte[] bArr = SinksKt.HEX_DIGIT_BYTES;
        writeBuffer.getClass();
        writeBuffer.writeLong(Double.doubleToLongBits(d));
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeFloat(ByteWriteChannel byteWriteChannel, float f, Continuation continuation) {
        Sink writeBuffer = byteWriteChannel.getWriteBuffer();
        byte[] bArr = SinksKt.HEX_DIGIT_BYTES;
        writeBuffer.getClass();
        writeBuffer.writeInt(Float.floatToIntBits(f));
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeFully(ByteWriteChannel byteWriteChannel, byte[] bArr, int i, int i2, Continuation continuation) {
        byteWriteChannel.getWriteBuffer().write(bArr, i, i2);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static /* synthetic */ Object writeFully$default(ByteWriteChannel byteWriteChannel, byte[] bArr, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return writeFully(byteWriteChannel, bArr, i, i2, continuation);
    }

    public static final Object writeInt(ByteWriteChannel byteWriteChannel, int i, Continuation continuation) {
        byteWriteChannel.getWriteBuffer().writeInt(i);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeLong(ByteWriteChannel byteWriteChannel, long j, Continuation continuation) {
        byteWriteChannel.getWriteBuffer().writeLong(j);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlushIfNeeded : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object writePacket(ByteWriteChannel byteWriteChannel, Source source, Continuation continuation) {
        AnonymousClass2 anonymousClass2;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            int i = anonymousClass2.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuation);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(continuation);
        }
        Object obj = anonymousClass2.result;
        int i2 = anonymousClass2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Source source2 = (Source) anonymousClass2.L$1;
            ByteWriteChannel byteWriteChannel2 = (ByteWriteChannel) anonymousClass2.L$0;
            ResultKt.throwOnFailure(obj);
            source = source2;
            byteWriteChannel = byteWriteChannel2;
        }
        while (!source.exhausted()) {
            byteWriteChannel.getWriteBuffer().write(source, ByteReadPacketKt.getRemaining(source));
            anonymousClass2.L$0 = byteWriteChannel;
            anonymousClass2.L$1 = source;
            anonymousClass2.label = 1;
            Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, anonymousClass2);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objFlushIfNeeded == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    public static final Object writeShort(ByteWriteChannel byteWriteChannel, short s, Continuation continuation) {
        byteWriteChannel.getWriteBuffer().writeShort(s);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeSource(ByteWriteChannel byteWriteChannel, Source source, Continuation continuation) {
        Object objWritePacket = writePacket(byteWriteChannel, source, continuation);
        return objWritePacket == CoroutineSingletons.COROUTINE_SUSPENDED ? objWritePacket : Unit.INSTANCE;
    }

    public static final Object writeString(ByteWriteChannel byteWriteChannel, String str, Continuation continuation) {
        StringsKt__StringsKt.writeText$default(byteWriteChannel.getWriteBuffer(), str, 0, 0, (Charset) null, 14, (Object) null);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeStringUtf8(ByteWriteChannel byteWriteChannel, String str, Continuation continuation) {
        StringsKt__StringsKt.writeText$default(byteWriteChannel.getWriteBuffer(), str, 0, 0, (Charset) null, 14, (Object) null);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static final WriterJob writer(CoroutineScope coroutineScope, CoroutineContext coroutineContext, ByteChannel byteChannel, Function2 function2) {
        coroutineScope.getClass();
        coroutineContext.getClass();
        byteChannel.getClass();
        function2.getClass();
        StandaloneCoroutine standaloneCoroutineLaunch$default = AwaitKt.launch$default(coroutineScope, coroutineContext, null, new ByteWriteChannelOperationsKt$writer$job$1(function2, byteChannel, null), 2);
        standaloneCoroutineLaunch$default.invokeOnCompletion(new ByteChannelUtilsKt$$ExternalSyntheticLambda1(byteChannel, (byte) 2));
        return new WriterJob(byteChannel, standaloneCoroutineLaunch$default);
    }

    public static /* synthetic */ WriterJob writer$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return writer(coroutineScope, coroutineContext, z, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writer$lambda$0$0(ByteChannel byteChannel, Throwable th) {
        if (th != null && !byteChannel.isClosedForWrite()) {
            byteChannel.cancel(th);
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ WriterJob writer$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, ByteChannel byteChannel, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return writer(coroutineScope, coroutineContext, byteChannel, function2);
    }

    public static final Object writeBuffer(ByteWriteChannel byteWriteChannel, RawSource rawSource, long j, Continuation continuation) {
        byteWriteChannel.getWriteBuffer().write(rawSource, j);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static final DisposableHandle invokeOnCompletion(ChannelJob channelJob, Function1 function1) {
        channelJob.getClass();
        function1.getClass();
        return channelJob.getJob().invokeOnCompletion(function1);
    }

    public static final WriterJob writer(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z, Function2 function2) {
        coroutineScope.getClass();
        coroutineContext.getClass();
        function2.getClass();
        return writer(coroutineScope, coroutineContext, new ByteChannel(z), function2);
    }

    public static final Object writePacket(ByteWriteChannel byteWriteChannel, Buffer buffer, Continuation continuation) {
        byteWriteChannel.getWriteBuffer().transferFrom(buffer);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlushIfNeeded : Unit.INSTANCE;
    }
}
