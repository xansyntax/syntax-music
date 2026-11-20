package io.ktor.utils.io;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.utils.io.core.BytePacketBuilderExtensions_jvmKt;
import io.ktor.utils.io.core.ByteReadPacketExtensions_jvmKt;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$LongRef;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.Utf8Kt;
import kotlinx.io.bytestring.ByteString;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a&\u0010\u0010\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0014\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0014\u0010\b\u001a\u001c\u0010\u0014\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0016\u0010\b\u001a%\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0017¢\u0006\u0004\b\u0007\u0010\u0019\u001a4\u0010\u001c\u001a\u00020\u0013*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00062\u0014\b\b\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00130\u0017H\u0086H¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Ljava/nio/ByteBuffer;", "content", "Lio/ktor/utils/io/ByteReadChannel;", "ByteReadChannel", "(Ljava/nio/ByteBuffer;)Lio/ktor/utils/io/ByteReadChannel;", "buffer", "", "readAvailable", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/io/bytestring/ByteString;", "ByteString", "(Ljava/nio/ByteBuffer;)Lkotlinx/io/bytestring/ByteString;", "Ljava/nio/channels/WritableByteChannel;", "channel", "", "limit", "copyTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/channels/WritableByteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delimiter", "", "skipDelimiter", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/io/bytestring/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFully", "Lkotlin/Function1;", "block", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/jvm/functions/Function1;)I", "min", "consumer", "read", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ByteReadChannelOperations_jvmKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperations_jvmKt$copyTo$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperations_jvmKt", f = "ByteReadChannelOperations.jvm.kt", l = {213, 217}, m = "copyTo", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperations_jvmKt.copyTo(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperations_jvmKt$read$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperations_jvmKt", f = "ByteReadChannelOperations.jvm.kt", l = {200, 204}, m = "read", v = 1)
    public static final class C03611 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03611(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperations_jvmKt.read(null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readAvailable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperations_jvmKt", f = "ByteReadChannelOperations.jvm.kt", l = {43}, m = "readAvailable", v = 1)
    public static final class C03621 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03621(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperations_jvmKt.readAvailable(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readFully$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperations_jvmKt", f = "ByteReadChannelOperations.jvm.kt", l = {134}, m = "readFully", v = 1)
    public static final class C03631 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03631(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperations_jvmKt.readFully(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperations_jvmKt$skipDelimiter$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperations_jvmKt", f = "ByteReadChannelOperations.jvm.kt", l = {116}, m = "skipDelimiter", v = 1)
    public static final class AnonymousClass2 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return ByteReadChannelOperations_jvmKt.skipDelimiter((ByteReadChannel) null, (ByteString) null, this);
        }
    }

    public static final ByteReadChannel ByteReadChannel(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        Buffer buffer = new Buffer();
        BytePacketBuilderExtensions_jvmKt.writeFully(buffer, byteBuffer);
        return ByteChannelCtorKt.ByteReadChannel(buffer);
    }

    public static final ByteString ByteString(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.mark();
        byteBuffer.get(bArr);
        byteBuffer.reset();
        return new ByteString(bArr, 0, iRemaining);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x010c  */
    /* JADX WARN: Code duplicated, block: B:51:0x011c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0124  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0100 -> B:45:0x0104). Please report as a decompilation issue!!! */
    public static final Object copyTo(ByteReadChannel byteReadChannel, final WritableByteChannel writableByteChannel, final long j, Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Function1 function1;
        Ref$LongRef ref$LongRef;
        Throwable closedCause;
        ByteReadChannel byteReadChannel2;
        long j2;
        Function1 function2;
        ByteReadChannel byteReadChannel3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objAwaitContent$default = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                int i3 = anonymousClass1.I$0;
                long j3 = anonymousClass1.J$0;
                Function1 function3 = (Function1) anonymousClass1.L$5;
                ByteReadChannel byteReadChannel4 = (ByteReadChannel) anonymousClass1.L$4;
                Function1 function4 = (Function1) anonymousClass1.L$3;
                Ref$LongRef ref$LongRef2 = (Ref$LongRef) anonymousClass1.L$2;
                ByteReadChannel byteReadChannel5 = (ByteReadChannel) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objAwaitContent$default);
                if (!((Boolean) objAwaitContent$default).booleanValue()) {
                    StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(i3, "Not enough bytes available: required ", " but ");
                    sbM2m.append(ByteReadChannelOperationsKt.getAvailableForRead(byteReadChannel4));
                    sbM2m.append(" available");
                    throw new EOFException(sbM2m.toString());
                }
                ByteReadPacketExtensions_jvmKt.read(byteReadChannel4.getReadBuffer(), function3);
                j = j3;
                function1 = function4;
                ref$LongRef = ref$LongRef2;
                byteReadChannel = byteReadChannel5;
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                j2 = anonymousClass1.J$0;
                function2 = (Function1) anonymousClass1.L$5;
                byteReadChannel3 = (ByteReadChannel) anonymousClass1.L$4;
                function1 = (Function1) anonymousClass1.L$3;
                ref$LongRef = (Ref$LongRef) anonymousClass1.L$2;
                byteReadChannel2 = (ByteReadChannel) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objAwaitContent$default);
            }
            if (((Boolean) objAwaitContent$default).booleanValue()) {
                ByteReadPacketExtensions_jvmKt.read(byteReadChannel3.getReadBuffer(), function2);
            }
            j = j2;
            byteReadChannel = byteReadChannel2;
        } else {
            ResultKt.throwOnFailure(objAwaitContent$default);
            if (j < 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "Limit shouldn't be negative: "));
                return null;
            }
            if ((writableByteChannel instanceof SelectableChannel) && !((SelectableChannel) writableByteChannel).isBlocking()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Non-blocking channels are not supported");
                return null;
            }
            if (byteReadChannel.isClosedForRead()) {
                Throwable closedCause2 = byteReadChannel.getClosedCause();
                if (closedCause2 == null) {
                    return new Long(0L);
                }
                throw closedCause2;
            }
            final Ref$LongRef ref$LongRef3 = new Ref$LongRef();
            function1 = new Function1() { // from class: io.ktor.utils.io.ByteReadChannelOperations_jvmKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ByteReadChannelOperations_jvmKt.copyTo$lambda$2(j, ref$LongRef3, writableByteChannel, (ByteBuffer) obj);
                }
            };
            ref$LongRef = ref$LongRef3;
        }
        if (ref$LongRef.element < j || byteReadChannel.isClosedForRead()) {
            closedCause = byteReadChannel.getClosedCause();
            if (closedCause == null) {
                return new Long(ref$LongRef.element);
            }
            throw closedCause;
        }
        anonymousClass1.L$0 = byteReadChannel;
        anonymousClass1.L$1 = null;
        anonymousClass1.L$2 = ref$LongRef;
        anonymousClass1.L$3 = function1;
        anonymousClass1.L$4 = byteReadChannel;
        anonymousClass1.L$5 = function1;
        anonymousClass1.J$0 = j;
        anonymousClass1.I$0 = 0;
        anonymousClass1.I$1 = 0;
        anonymousClass1.label = 2;
        objAwaitContent$default = ByteReadChannel.awaitContent$default(byteReadChannel, 0, anonymousClass1, 1, null);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (objAwaitContent$default == coroutineSingletons) {
            return coroutineSingletons;
        }
        byteReadChannel2 = byteReadChannel;
        j2 = j;
        function2 = function1;
        byteReadChannel3 = byteReadChannel2;
        if (((Boolean) objAwaitContent$default).booleanValue()) {
            ByteReadPacketExtensions_jvmKt.read(byteReadChannel3.getReadBuffer(), function2);
        }
        j = j2;
        byteReadChannel = byteReadChannel2;
        if (ref$LongRef.element < j) {
        }
        closedCause = byteReadChannel.getClosedCause();
        if (closedCause == null) {
            return new Long(ref$LongRef.element);
        }
        throw closedCause;
    }

    public static /* synthetic */ Object copyTo$default(ByteReadChannel byteReadChannel, WritableByteChannel writableByteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(byteReadChannel, writableByteChannel, j, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copyTo$lambda$2(long j, Ref$LongRef ref$LongRef, WritableByteChannel writableByteChannel, ByteBuffer byteBuffer) throws IOException {
        byteBuffer.getClass();
        long j2 = j - ref$LongRef.element;
        if (j2 < byteBuffer.remaining()) {
            int iLimit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + ((int) j2));
            while (byteBuffer.hasRemaining()) {
                writableByteChannel.write(byteBuffer);
            }
            byteBuffer.limit(iLimit);
            ref$LongRef.element += j2;
        } else {
            long jWrite = 0;
            while (byteBuffer.hasRemaining()) {
                jWrite += (long) writableByteChannel.write(byteBuffer);
            }
            ref$LongRef.element += jWrite;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
    
        if (r8 == r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009e, code lost:
    
        if (r8 == r1) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object read(ByteReadChannel byteReadChannel, int i, Function1 function1, Continuation continuation) throws EOFException {
        C03611 c03611;
        if (continuation instanceof C03611) {
            c03611 = (C03611) continuation;
            int i2 = c03611.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c03611.label = i2 - Integer.MIN_VALUE;
            } else {
                c03611 = new C03611(continuation);
            }
        } else {
            c03611 = new C03611(continuation);
        }
        Object objAwaitContent$default = c03611.result;
        int i3 = c03611.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objAwaitContent$default);
            if (i < 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("min should be positive or zero");
                return null;
            }
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (i > 0) {
                c03611.L$0 = byteReadChannel;
                c03611.L$1 = function1;
                c03611.I$0 = i;
                c03611.I$1 = 0;
                c03611.label = 1;
                objAwaitContent$default = byteReadChannel.awaitContent(i, c03611);
            } else {
                c03611.L$0 = byteReadChannel;
                c03611.L$1 = function1;
                c03611.I$0 = i;
                c03611.I$1 = 0;
                c03611.label = 2;
                objAwaitContent$default = ByteReadChannel.awaitContent$default(byteReadChannel, 0, c03611, 1, null);
            }
            return coroutineSingletons;
        }
        if (i3 == 1) {
            i = c03611.I$0;
            function1 = (Function1) c03611.L$1;
            byteReadChannel = (ByteReadChannel) c03611.L$0;
            ResultKt.throwOnFailure(objAwaitContent$default);
            if (!((Boolean) objAwaitContent$default).booleanValue()) {
                StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Not enough bytes available: required ", " but ");
                sbM2m.append(ByteReadChannelOperationsKt.getAvailableForRead(byteReadChannel));
                sbM2m.append(" available");
                throw new EOFException(sbM2m.toString());
            }
            ByteReadPacketExtensions_jvmKt.read(byteReadChannel.getReadBuffer(), function1);
        } else {
            if (i3 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            function1 = (Function1) c03611.L$1;
            byteReadChannel = (ByteReadChannel) c03611.L$0;
            ResultKt.throwOnFailure(objAwaitContent$default);
            if (((Boolean) objAwaitContent$default).booleanValue()) {
                ByteReadPacketExtensions_jvmKt.read(byteReadChannel.getReadBuffer(), function1);
            }
        }
        return Unit.INSTANCE;
    }

    private static final Object read$$forInline(ByteReadChannel byteReadChannel, int i, Function1 function1, Continuation continuation) throws EOFException {
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("min should be positive or zero");
            return null;
        }
        if (i > 0) {
            if (!((Boolean) byteReadChannel.awaitContent(i, continuation)).booleanValue()) {
                StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Not enough bytes available: required ", " but ");
                sbM2m.append(ByteReadChannelOperationsKt.getAvailableForRead(byteReadChannel));
                sbM2m.append(" available");
                throw new EOFException(sbM2m.toString());
            }
            ByteReadPacketExtensions_jvmKt.read(byteReadChannel.getReadBuffer(), function1);
        } else if (((Boolean) ByteReadChannel.awaitContent$default(byteReadChannel, 0, continuation, 1, null)).booleanValue()) {
            ByteReadPacketExtensions_jvmKt.read(byteReadChannel.getReadBuffer(), function1);
        }
        return Unit.INSTANCE;
    }

    public static Object read$default(ByteReadChannel byteReadChannel, int i, Function1 function1, Continuation continuation, int i2, Object obj) throws EOFException {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("min should be positive or zero");
            return null;
        }
        if (i > 0) {
            if (!((Boolean) byteReadChannel.awaitContent(i, continuation)).booleanValue()) {
                StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Not enough bytes available: required ", " but ");
                sbM2m.append(ByteReadChannelOperationsKt.getAvailableForRead(byteReadChannel));
                sbM2m.append(" available");
                throw new EOFException(sbM2m.toString());
            }
            ByteReadPacketExtensions_jvmKt.read(byteReadChannel.getReadBuffer(), function1);
        } else if (((Boolean) ByteReadChannel.awaitContent$default(byteReadChannel, 0, continuation, 1, null)).booleanValue()) {
            ByteReadPacketExtensions_jvmKt.read(byteReadChannel.getReadBuffer(), function1);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object readAvailable(ByteReadChannel byteReadChannel, ByteBuffer byteBuffer, Continuation continuation) {
        C03621 c03621;
        if (continuation instanceof C03621) {
            c03621 = (C03621) continuation;
            int i = c03621.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03621.label = i - Integer.MIN_VALUE;
            } else {
                c03621 = new C03621(continuation);
            }
        } else {
            c03621 = new C03621(continuation);
        }
        Object obj = c03621.result;
        int i2 = c03621.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (byteReadChannel.isClosedForRead()) {
                return new Integer(-1);
            }
            if (byteReadChannel.getReadBuffer().exhausted()) {
                c03621.L$0 = byteReadChannel;
                c03621.L$1 = byteBuffer;
                c03621.label = 1;
                Object objAwaitContent$default = ByteReadChannel.awaitContent$default(byteReadChannel, 0, c03621, 1, null);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objAwaitContent$default == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            byteBuffer = (ByteBuffer) c03621.L$1;
            byteReadChannel = (ByteReadChannel) c03621.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return byteReadChannel.isClosedForRead() ? new Integer(-1) : new Integer(Utf8Kt.readAtMostTo(byteReadChannel.getReadBuffer(), byteBuffer));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0040  */
    /* JADX WARN: Code duplicated, block: B:19:0x004f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0058  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004d -> B:20:0x0050). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object readFully(io.ktor.utils.io.ByteReadChannel r5, java.nio.ByteBuffer r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteReadChannelOperations_jvmKt.C03631
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readFully$1 r0 = (io.ktor.utils.io.ByteReadChannelOperations_jvmKt.C03631) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readFully$1 r0 = new io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readFully$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            int r1 = r0.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L37
            if (r1 != r3) goto L31
            java.lang.Object r5 = r0.L$1
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6
            kotlin.ResultKt.throwOnFailure(r7)
            r4 = r6
            r6 = r5
            r5 = r4
            goto L50
        L31:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r5)
            return r2
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
        L3a:
            boolean r7 = r6.hasRemaining()
            if (r7 == 0) goto L7d
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            r7 = 0
            java.lang.Object r7 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r5, r7, r0, r3, r2)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r7 != r1) goto L50
            return r1
        L50:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L60
            kotlinx.io.Source r7 = r5.getReadBuffer()
            kotlinx.io.Utf8Kt.readAtMostTo(r7, r6)
            goto L3a
        L60:
            java.io.EOFException r5 = new java.io.EOFException
            int r6 = r6.remaining()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Not enough bytes available: expected "
            r7.<init>(r0)
            r7.append(r6)
            java.lang.String r6 = " more bytes"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.<init>(r6)
            throw r5
        L7d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperations_jvmKt.readFully(io.ktor.utils.io.ByteReadChannel, java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    /* JADX WARN: Code duplicated, block: B:18:0x0057 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x0058  */
    /* JADX WARN: Code duplicated, block: B:22:0x0069  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0058 -> B:20:0x005d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object skipDelimiter(io.ktor.utils.io.ByteReadChannel r7, kotlinx.io.bytestring.ByteString r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteReadChannelOperations_jvmKt.AnonymousClass2
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$skipDelimiter$2 r0 = (io.ktor.utils.io.ByteReadChannelOperations_jvmKt.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$skipDelimiter$2 r0 = new io.ktor.utils.io.ByteReadChannelOperations_jvmKt$skipDelimiter$2
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            int r1 = r0.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L38
            if (r1 != r3) goto L32
            int r7 = r0.I$1
            int r8 = r0.I$0
            java.lang.Object r1 = r0.L$1
            kotlinx.io.bytestring.ByteString r1 = (kotlinx.io.bytestring.ByteString) r1
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5d
        L32:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r7)
            return r2
        L38:
            kotlin.ResultKt.throwOnFailure(r9)
            byte[] r9 = r8.data
            int r9 = r9.length
            r1 = 0
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L43:
            if (r1 >= r7) goto L75
            r0.L$0 = r8
            r0.L$1 = r9
            r0.I$0 = r1
            r0.I$1 = r7
            r0.label = r3
            java.lang.Object r4 = io.ktor.utils.io.ByteReadChannelOperationsKt.readByte(r8, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r4 != r5) goto L58
            return r5
        L58:
            r6 = r4
            r4 = r8
            r8 = r1
            r1 = r9
            r9 = r6
        L5d:
            java.lang.Number r9 = (java.lang.Number) r9
            byte r9 = r9.byteValue()
            byte r5 = r1.get(r8)
            if (r9 != r5) goto L6f
            int r8 = r8 + 1
            r9 = r1
            r1 = r8
            r8 = r4
            goto L43
        L6f:
            java.lang.String r7 = "Delimiter is not found"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r7)
            return r2
        L75:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperations_jvmKt.skipDelimiter(io.ktor.utils.io.ByteReadChannel, kotlinx.io.bytestring.ByteString, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object skipDelimiter(ByteReadChannel byteReadChannel, ByteBuffer byteBuffer, Continuation continuation) {
        Object objSkipDelimiter = skipDelimiter(byteReadChannel, ByteString(byteBuffer), continuation);
        return objSkipDelimiter == CoroutineSingletons.COROUTINE_SUSPENDED ? objSkipDelimiter : Unit.INSTANCE;
    }

    public static final int readAvailable(ByteReadChannel byteReadChannel, Function1 function1) {
        byteReadChannel.getClass();
        function1.getClass();
        if (byteReadChannel.isClosedForRead() || byteReadChannel.getReadBuffer().exhausted()) {
            return -1;
        }
        Buffer buffer = byteReadChannel.getReadBuffer().getBuffer();
        if (!buffer.exhausted()) {
            Segment segment = buffer.head;
            segment.getClass();
            byte[] bArr = segment.data;
            int i = segment.pos;
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, segment.limit - i);
            byteBufferWrap.getClass();
            int iIntValue = ((Number) function1.invoke(byteBufferWrap)).intValue();
            if (iIntValue == 0) {
                return iIntValue;
            }
            if (iIntValue >= 0) {
                if (iIntValue <= segment.getSize()) {
                    buffer.skip(iIntValue);
                    return iIntValue;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned too many bytes");
                return 0;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned negative read bytes count");
            return 0;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Buffer is empty");
        return 0;
    }
}
