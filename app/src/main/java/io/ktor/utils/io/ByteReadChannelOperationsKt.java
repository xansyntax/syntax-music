package io.ktor.utils.io;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import coil3.network.HttpException;
import com.yalantis.ucrop.UCrop;
import io.ktor.utils.io.charsets.TooLongLineException;
import io.ktor.utils.io.core.BuffersKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.core.InputKt;
import java.io.EOFException;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.io.Buffer;
import kotlinx.io.RawSink;
import kotlinx.io.Segment;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import kotlinx.io.bytestring.ByteString;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u0000H\u0086@¢\u0006\u0004\b\t\u0010\u0003\u001a\u0014\u0010\u000b\u001a\u00020\n*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000b\u0010\u0003\u001a\u0014\u0010\r\u001a\u00020\f*\u00020\u0000H\u0086@¢\u0006\u0004\b\r\u0010\u0003\u001a\u0014\u0010\u000f\u001a\u00020\u000e*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000f\u0010\u0003\u001a\u0014\u0010\u0011\u001a\u00020\u0010*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0011\u0010\u0003\u001a\u001c\u0010\u0014\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0014\u0010\u0017\u001a\u00020\u0016*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0017\u0010\u0003\u001a\u001c\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\nH\u0087@¢\u0006\u0004\b\u0017\u0010\u0015\u001a\u001c\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0017\u0010\u0019\u001a\u001c\u0010\u001c\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aH\u0086@¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u001e\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aH\u0086@¢\u0006\u0004\b\u001e\u0010\u001d\u001a&\u0010\"\u001a\u00020\u000e*\u00020\u00002\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\"\u0010#\u001a$\u0010\u001e\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u001e\u0010$\u001a\u001c\u0010&\u001a\u00020\u0004*\u00020\u00002\u0006\u0010%\u001a\u00020\nH\u0086@¢\u0006\u0004\b&\u0010\u0015\u001a\u0014\u0010(\u001a\u00020'*\u00020\u0000H\u0087@¢\u0006\u0004\b(\u0010\u0003\u001a\u001c\u0010(\u001a\u00020'*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000eH\u0087@¢\u0006\u0004\b(\u0010\u0019\u001a0\u0010,\u001a\u00020\n*\u00020\u00002\u0006\u0010)\u001a\u00020\u00042\b\b\u0002\u0010*\u001a\u00020\n2\b\b\u0002\u0010+\u001a\u00020\nH\u0086@¢\u0006\u0004\b,\u0010-\u001a-\u0010,\u001a\u00020\n*\u00020\u00002\u0006\u0010.\u001a\u00020\n2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0/¢\u0006\u0004\b,\u00101\u001aI\u0010;\u001a\u00020:*\u0002022\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00012\"\u00100\u001a\u001e\b\u0001\u0012\u0004\u0012\u000207\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001308\u0012\u0006\u0012\u0004\u0018\u00010906¢\u0006\u0004\b;\u0010<\u001aE\u0010;\u001a\u00020:*\u0002022\u0006\u00104\u001a\u0002032\u0006\u0010\u001b\u001a\u00020=2\"\u00100\u001a\u001e\b\u0001\u0012\u0004\u0012\u000207\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001308\u0012\u0006\u0012\u0004\u0018\u00010906¢\u0006\u0004\b;\u0010>\u001a\u001c\u0010@\u001a\u00020'*\u00020\u00002\u0006\u0010?\u001a\u00020\nH\u0086@¢\u0006\u0004\b@\u0010\u0015\u001a\u001c\u0010B\u001a\u00020\u0013*\u00020\u00002\u0006\u0010A\u001a\u00020\u000eH\u0086@¢\u0006\u0004\bB\u0010\u0019\u001a\u001e\u0010C\u001a\u00020\u000e*\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u000eH\u0086@¢\u0006\u0004\bC\u0010\u0019\u001a \u0010E\u001a\u0004\u0018\u00010D*\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\nH\u0087@¢\u0006\u0004\bE\u0010\u0015\u001a*\u0010I\u001a\u00020\u0001*\u00020\u00002\n\u0010H\u001a\u00060Fj\u0002`G2\b\b\u0002\u0010\u0018\u001a\u00020\nH\u0087@¢\u0006\u0004\bI\u0010J\u001a4\u0010I\u001a\u00020\u0001*\u00020\u00002\n\u0010H\u001a\u00060Fj\u0002`G2\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010L\u001a\u00020KH\u0087@¢\u0006\u0004\bM\u0010N\u001a \u0010P\u001a\u0004\u0018\u00010D*\u00020\u00002\b\b\u0002\u0010L\u001a\u00020OH\u0086@¢\u0006\u0004\bP\u0010Q\u001a*\u0010R\u001a\u00020\u000e*\u00020\u00002\n\u0010H\u001a\u00060Fj\u0002`G2\b\b\u0002\u0010L\u001a\u00020OH\u0086@¢\u0006\u0004\bR\u0010S\u001a*\u0010T\u001a\u0004\u0018\u00010D*\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010L\u001a\u00020OH\u0086@¢\u0006\u0004\bT\u0010U\u001a4\u0010V\u001a\u00020\u000e*\u00020\u00002\n\u0010H\u001a\u00060Fj\u0002`G2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010L\u001a\u00020OH\u0086@¢\u0006\u0004\bV\u0010W\u001a8\u0010Z\u001a\u00020\u000e*\u00020\u00002\n\u0010H\u001a\u00060Fj\u0002`G2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010X\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0001H\u0082@¢\u0006\u0004\bZ\u0010[\u001a\u0017\u0010]\u001a\u00020\\2\u0006\u0010!\u001a\u00020\u000eH\u0002¢\u0006\u0004\b]\u0010^\u001a\u0017\u0010`\u001a\u00020\\2\u0006\u0010_\u001a\u00020\u000eH\u0002¢\u0006\u0004\b`\u0010^\u001aF\u0010b\u001a\u00020\n*\u00020\u000020\b\u0004\u00100\u001a*\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n08\u0012\u0006\u0012\u0004\u0018\u0001090aH\u0086H¢\u0006\u0004\bb\u0010c\u001a0\u0010f\u001a\u00020\u0013*\u00020\u00002\u0006\u0010H\u001a\u00020\u00042\b\b\u0002\u0010d\u001a\u00020\n2\b\b\u0002\u0010e\u001a\u00020\nH\u0086@¢\u0006\u0004\bf\u0010-\u001a\u0013\u0010g\u001a\u00020\u0013*\u00020\u0000H\u0007¢\u0006\u0004\bg\u0010h\u001a\u0013\u0010g\u001a\u00020\u0013*\u00020\u001aH\u0007¢\u0006\u0004\bg\u0010i\u001a\u0013\u0010g\u001a\u00020\u0013*\u00020=H\u0007¢\u0006\u0004\bg\u0010j\u001a8\u0010o\u001a\u00020\u000e*\u00020\u00002\u0006\u0010l\u001a\u00020k2\u0006\u0010m\u001a\u00020\u001a2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010n\u001a\u00020\u0001H\u0086@¢\u0006\u0004\bo\u0010p\u001a\u001c\u0010r\u001a\u00020\u0001*\u00020\u00002\u0006\u0010q\u001a\u00020kH\u0086@¢\u0006\u0004\br\u0010s\u001a\u001e\u0010t\u001a\u0004\u0018\u00010k*\u00020\u00002\u0006\u0010%\u001a\u00020\nH\u0086@¢\u0006\u0004\bt\u0010\u0015\"\u0014\u0010u\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bu\u0010v\"\u0014\u0010w\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bw\u0010v\"\u001b\u0010{\u001a\u00020\n*\u00020\u001a8F¢\u0006\f\u0012\u0004\bz\u0010i\u001a\u0004\bx\u0010y\"\u001b\u0010\u007f\u001a\u00020\n*\u00020\u00008F¢\u0006\f\u0012\u0004\b~\u0010h\u001a\u0004\b|\u0010}¨\u0006\u0080\u0001"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "", "exhausted", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "toByteArray", "", "readByte", "", "readShort", "", "readInt", "", "readFloat", "", "readLong", "", "readDouble", "numberOfBytes", "", "awaitUntilReadable", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/io/Buffer;", "readBuffer", "max", "(Lio/ktor/utils/io/ByteReadChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "copyAndClose", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyTo", "Lkotlinx/io/RawSink;", "sink", "limit", "readTo", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/io/RawSink;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "count", "readByteArray", "Lkotlinx/io/Source;", "readRemaining", "buffer", "offset", "length", "readAvailable", "(Lio/ktor/utils/io/ByteReadChannel;[BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "min", "Lkotlin/Function1;", "block", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/jvm/functions/Function1;)I", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "autoFlush", "Lkotlin/Function2;", "Lio/ktor/utils/io/ReaderScope;", "Lkotlin/coroutines/Continuation;", "", "Lio/ktor/utils/io/ReaderJob;", "reader", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ZLkotlin/jvm/functions/Function2;)Lio/ktor/utils/io/ReaderJob;", "Lio/ktor/utils/io/ByteChannel;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lio/ktor/utils/io/ByteChannel;Lkotlin/jvm/functions/Function2;)Lio/ktor/utils/io/ReaderJob;", "packet", "readPacket", "value", "discardExact", "discard", "", "readUTF8Line", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "readUTF8LineTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/LineEndingMode;", "lineEnding", "readUTF8LineTo-RRvyBJ8", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/LineEnding;", "readLine", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/LineEnding;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readLineTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;Lio/ktor/utils/io/LineEnding;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readLineStrict", "(Lio/ktor/utils/io/ByteReadChannel;JLio/ktor/utils/io/LineEnding;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readLineStrictTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;JLio/ktor/utils/io/LineEnding;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lenientLineEnding", "throwOnIncompleteLine", "internalReadLineTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;JZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "throwTooLongLineException", "(J)Ljava/lang/Void;", "consumed", "throwEndOfStreamException", "Lkotlin/Function4;", "read", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "end", "readFully", "rethrowCloseCauseIfNeeded", "(Lio/ktor/utils/io/ByteReadChannel;)V", "(Lio/ktor/utils/io/ByteWriteChannel;)V", "(Lio/ktor/utils/io/ByteChannel;)V", "Lkotlinx/io/bytestring/ByteString;", "matchString", "writeChannel", "ignoreMissing", "readUntil", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/io/bytestring/ByteString;Lio/ktor/utils/io/ByteWriteChannel;JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "byteString", "skipIfFound", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/io/bytestring/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "peek", "CR", "B", "LF", "getAvailableForWrite", "(Lio/ktor/utils/io/ByteWriteChannel;)I", "getAvailableForWrite$annotations", "availableForWrite", "getAvailableForRead", "(Lio/ktor/utils/io/ByteReadChannel;)I", "getAvailableForRead$annotations", "availableForRead", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ByteReadChannelOperationsKt {
    private static final byte CR = 13;
    private static final byte LF = 10;

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$awaitUntilReadable$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {91}, m = "awaitUntilReadable", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.awaitUntilReadable(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$copyAndClose$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {160, 161, 170, 170}, m = "copyAndClose", v = 1)
    public static final class C03341 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03341(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.copyAndClose(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$copyTo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {182, 183, 190, 190}, m = "copyTo", v = 1)
    public static final class C03351 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03351(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.copyTo(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$copyTo$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {233, 237, 244, 244}, m = "copyTo", v = 1)
    public static final class AnonymousClass2 extends ContinuationImpl {
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.copyTo(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$discard$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {410}, m = "discard", v = 1)
    public static final class C03361 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03361(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.discard(null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$discardExact$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {402}, m = "discardExact", v = 1)
    public static final class C03371 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03371(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.discardExact(null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$exhausted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {33}, m = "exhausted", v = 1)
    public static final class C03381 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03381(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.exhausted(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$internalReadLineTo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {702, 793, 803, 815, 824}, m = "internalReadLineTo", v = 1)
    public static final class C03391 extends ContinuationImpl {
        long J$0;
        long J$1;
        long J$2;
        long J$3;
        long J$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        public C03391(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.internalReadLineTo(null, null, 0L, false, false, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$peek$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {964}, m = "peek", v = 1)
    public static final class C03401 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03401(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.peek(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$read$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {850, 855}, m = "read", v = 1)
    public static final class C03411 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public C03411(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.read(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readAvailable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {279}, m = "readAvailable", v = 1)
    public static final class C03421 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03421(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readAvailable(null, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {108}, m = "readBuffer", v = 1)
    public static final class C03431 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03431(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readBuffer(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {144}, m = "readBuffer", v = 1)
    public static final class AnonymousClass3 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readBuffer((ByteReadChannel) null, 0L, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readByte$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {44}, m = "readByte", v = 1)
    public static final class C03441 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03441(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readByte(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readByteArray$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {252}, m = "readByteArray", v = 1)
    public static final class C03451 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03451(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readByteArray(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readDouble$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {86}, m = "readDouble", v = 1)
    public static final class C03461 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03461(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readDouble(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readFloat$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {UCrop.REQUEST_CROP}, m = "readFloat", v = 1)
    public static final class C03471 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03471(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readFloat(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readFully$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {883}, m = "readFully", v = 1)
    public static final class C03481 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03481(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readFully(null, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readInt$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {58}, m = "readInt", v = 1)
    public static final class C03491 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03491(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readInt(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readLine$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {598}, m = "readLine", v = 1)
    public static final class C03501 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03501(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readLine(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readLineStrict$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {653}, m = "readLineStrict", v = 1)
    public static final class C03511 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03511(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readLineStrict(null, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readLong$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {75}, m = "readLong", v = 1)
    public static final class C03521 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03521(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readLong(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readPacket$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {385}, m = "readPacket", v = 1)
    public static final class C03531 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03531(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readPacket(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readShort$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {52}, m = "readShort", v = 1)
    public static final class C03541 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03541(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readShort(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readTo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {212}, m = "readTo", v = 1)
    public static final class C03551 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03551(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readTo(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readUTF8Line$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {477}, m = "readUTF8Line", v = 1)
    public static final class C03561 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03561(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readUTF8Line(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readUTF8LineTo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {570}, m = "readUTF8LineTo-RRvyBJ8", v = 1)
    public static final class C03572 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03572(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.m1837readUTF8LineToRRvyBJ8(null, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$reader$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt$reader$1", f = "ByteReadChannelOperations.kt", l = {371}, m = "invokeSuspend", v = 1)
    public static final class C03581 extends SuspendLambda implements Function1 {
        final /* synthetic */ Job $job;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03581(Job job, Continuation continuation) {
            super(1, continuation);
            this.$job = job;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new C03581(this.$job, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C03581) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Job job = this.$job;
                this.label = 1;
                Object objJoin = job.join(this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objJoin == coroutineSingletons) {
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

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$skipIfFound$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {945, 946}, m = "skipIfFound", v = 1)
    public static final class C03591 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03591(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.skipIfFound(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$toByteArray$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", l = {38}, m = "toByteArray", v = 1)
    public static final class C03601 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03601(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.toByteArray(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object awaitUntilReadable(ByteReadChannel byteReadChannel, int i, Continuation continuation) throws EOFException {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objAwaitContent = anonymousClass1.result;
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objAwaitContent);
            anonymousClass1.L$0 = null;
            anonymousClass1.I$0 = i;
            anonymousClass1.label = 1;
            objAwaitContent = byteReadChannel.awaitContent(i, anonymousClass1);
            Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAwaitContent == obj) {
                return obj;
            }
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objAwaitContent);
        }
        if (((Boolean) objAwaitContent).booleanValue()) {
            return Unit.INSTANCE;
        }
        throw new EOFException("Not enough data available");
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0089 A[Catch: all -> 0x00b9, TRY_LEAVE, TryCatch #2 {all -> 0x00b9, blocks: (B:27:0x0083, B:29:0x0089, B:38:0x00bf, B:46:0x00db), top: B:59:0x0083 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:38:0x00bf A[Catch: all -> 0x00b9, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00b9, blocks: (B:27:0x0083, B:29:0x0089, B:38:0x00bf, B:46:0x00db), top: B:59:0x0083 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:46:0x00db A[Catch: all -> 0x00b9, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00b9, blocks: (B:27:0x0083, B:29:0x0089, B:38:0x00bf, B:46:0x00db), top: B:59:0x0083 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b6, code lost:
    
        if (io.ktor.utils.io.ByteReadChannel.awaitContent$default(r11, 0, r1, 1, null) == r8) goto L52;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00b6 -> B:20:0x0062). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object copyAndClose(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, Continuation continuation) {
        C03341 c03341;
        ByteReadChannel byteReadChannel2;
        long j;
        long j2;
        C03341 c03342;
        ByteReadChannel byteReadChannel3;
        Throwable closedCause;
        long j3;
        long jTransferTo;
        ?? r2;
        if (continuation instanceof C03341) {
            c03341 = (C03341) continuation;
            int i = c03341.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03341.label = i - Integer.MIN_VALUE;
            } else {
                c03341 = new C03341(continuation);
            }
        } else {
            c03341 = new C03341(continuation);
        }
        Object obj = c03341.result;
        ?? r3 = c03341.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (r3 == 0) {
                ResultKt.throwOnFailure(obj);
                r3 = byteWriteChannel;
                j2 = 0;
                c03342 = c03341;
                byteReadChannel3 = byteReadChannel;
                if (byteReadChannel3.isClosedForRead()) {
                    closedCause = byteReadChannel3.getClosedCause();
                    if (closedCause == null) {
                        throw closedCause;
                    }
                    c03342.L$0 = null;
                    c03342.L$1 = null;
                    c03342.J$0 = j2;
                    c03342.label = 3;
                    if (r3.flushAndClose(c03342) != coroutineSingletons) {
                        j3 = j2;
                    }
                } else {
                    jTransferTo = j2 + byteReadChannel3.getReadBuffer().transferTo(r3.getWriteBuffer());
                    c03342.L$0 = byteReadChannel3;
                    c03342.L$1 = r3;
                    c03342.J$0 = jTransferTo;
                    c03342.label = 1;
                    if (r3.flush(c03342) != coroutineSingletons) {
                        byteReadChannel2 = byteReadChannel3;
                        c03341 = c03342;
                        j = jTransferTo;
                        r3 = r3;
                        c03341.L$0 = byteReadChannel2;
                        c03341.L$1 = r3;
                        c03341.J$0 = j;
                        c03341.label = 2;
                        r2 = r3;
                    }
                }
                return coroutineSingletons;
            }
            if (r3 == 1) {
                j = c03341.J$0;
                ByteWriteChannel byteWriteChannel2 = (ByteWriteChannel) c03341.L$1;
                byteReadChannel2 = (ByteReadChannel) c03341.L$0;
                ResultKt.throwOnFailure(obj);
                r3 = byteWriteChannel2;
                c03341.L$0 = byteReadChannel2;
                c03341.L$1 = r3;
                c03341.J$0 = j;
                c03341.label = 2;
                r2 = r3;
            } else if (r3 == 2) {
                j = c03341.J$0;
                ByteWriteChannel byteWriteChannel3 = (ByteWriteChannel) c03341.L$1;
                byteReadChannel2 = (ByteReadChannel) c03341.L$0;
                ResultKt.throwOnFailure(obj);
                r2 = byteWriteChannel3;
                try {
                    long j4 = j;
                    c03342 = c03341;
                    byteReadChannel3 = byteReadChannel2;
                    j2 = j4;
                    r3 = r2;
                    if (byteReadChannel3.isClosedForRead()) {
                        jTransferTo = j2 + byteReadChannel3.getReadBuffer().transferTo(r3.getWriteBuffer());
                        c03342.L$0 = byteReadChannel3;
                        c03342.L$1 = r3;
                        c03342.J$0 = jTransferTo;
                        c03342.label = 1;
                        if (r3.flush(c03342) != coroutineSingletons) {
                            byteReadChannel2 = byteReadChannel3;
                            c03341 = c03342;
                            j = jTransferTo;
                            r3 = r3;
                            c03341.L$0 = byteReadChannel2;
                            c03341.L$1 = r3;
                            c03341.J$0 = j;
                            c03341.label = 2;
                            r2 = r3;
                        }
                    } else {
                        closedCause = byteReadChannel3.getClosedCause();
                        if (closedCause == null) {
                            throw closedCause;
                        }
                        c03342.L$0 = null;
                        c03342.L$1 = null;
                        c03342.J$0 = j2;
                        c03342.label = 3;
                        if (r3.flushAndClose(c03342) != coroutineSingletons) {
                            j3 = j2;
                        }
                    }
                    return coroutineSingletons;
                } catch (Throwable th) {
                    th = th;
                    byteReadChannel2 = byteReadChannel3;
                    c03341 = c03342;
                    j = j2;
                    try {
                        byteReadChannel2.cancel(th);
                        ByteWriteChannelOperationsKt.close(r3, th);
                        throw th;
                    } catch (Throwable th2) {
                        c03341.L$0 = null;
                        c03341.L$1 = null;
                        c03341.L$2 = th2;
                        c03341.J$0 = j;
                        c03341.label = 4;
                        if (r3.flushAndClose(c03341) != coroutineSingletons) {
                            throw th2;
                        }
                    }
                }
            } else {
                if (r3 != 3) {
                    if (r3 != 4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Throwable th3 = (Throwable) c03341.L$2;
                    ResultKt.throwOnFailure(obj);
                    throw th3;
                }
                j3 = c03341.J$0;
                ResultKt.throwOnFailure(obj);
            }
            return new Long(j3);
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:46:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b0, code lost:
    
        if (io.ktor.utils.io.ByteReadChannel.awaitContent$default(r1, 0, r13, r6, null) == r8) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e8, code lost:
    
        if (r0 == r8) goto L54;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00e8 -> B:20:0x0066). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object copyTo(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation continuation) throws Throwable {
        AnonymousClass2 anonymousClass2;
        ByteReadChannel byteReadChannel2;
        long j2;
        long j3;
        AnonymousClass2 anonymousClass3;
        ByteReadChannel byteReadChannel3;
        long j4;
        long j5;
        ?? r2;
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
        ?? r3 = anonymousClass2.label;
        int i2 = 1;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (r3 == 0) {
                ResultKt.throwOnFailure(obj);
                r3 = byteWriteChannel;
                j3 = j;
                j2 = j3;
                anonymousClass3 = anonymousClass2;
                byteReadChannel3 = byteReadChannel;
                if (byteReadChannel3.isClosedForRead()) {
                    anonymousClass3.L$0 = null;
                    anonymousClass3.L$1 = null;
                    anonymousClass3.J$0 = j2;
                    anonymousClass3.J$1 = j3;
                    anonymousClass3.label = 3;
                    if (r3.flush(anonymousClass3) != coroutineSingletons) {
                        j4 = j3;
                        j5 = j2;
                    }
                } else {
                    anonymousClass3.L$0 = null;
                    anonymousClass3.L$1 = null;
                    anonymousClass3.J$0 = j2;
                    anonymousClass3.J$1 = j3;
                    anonymousClass3.label = 3;
                    if (r3.flush(anonymousClass3) != coroutineSingletons) {
                        j4 = j3;
                        j5 = j2;
                    }
                }
                return coroutineSingletons;
            }
            if (r3 == 1) {
                j3 = anonymousClass2.J$1;
                j2 = anonymousClass2.J$0;
                ByteWriteChannel byteWriteChannel2 = (ByteWriteChannel) anonymousClass2.L$1;
                byteReadChannel2 = (ByteReadChannel) anonymousClass2.L$0;
                ResultKt.throwOnFailure(obj);
                r3 = byteWriteChannel2;
                long jMin = Math.min(j3, ByteReadPacketKt.getRemaining(byteReadChannel2.getReadBuffer()));
                byteReadChannel2.getReadBuffer().readTo(r3.getWriteBuffer(), jMin);
                j3 -= jMin;
                anonymousClass2.L$0 = byteReadChannel2;
                anonymousClass2.L$1 = r3;
                anonymousClass2.J$0 = j2;
                anonymousClass2.J$1 = j3;
                anonymousClass2.J$2 = jMin;
                anonymousClass2.label = 2;
                Object objFlush = r3.flush(anonymousClass2);
                r2 = r3;
            } else if (r3 == 2) {
                j3 = anonymousClass2.J$1;
                j2 = anonymousClass2.J$0;
                ByteWriteChannel byteWriteChannel3 = (ByteWriteChannel) anonymousClass2.L$1;
                byteReadChannel2 = (ByteReadChannel) anonymousClass2.L$0;
                ResultKt.throwOnFailure(obj);
                r2 = byteWriteChannel3;
                try {
                    ByteReadChannel byteReadChannel4 = byteReadChannel2;
                    anonymousClass3 = anonymousClass2;
                    byteReadChannel3 = byteReadChannel4;
                    i2 = 1;
                    r3 = r2;
                    if (byteReadChannel3.isClosedForRead() || j3 <= 0) {
                        anonymousClass3.L$0 = null;
                        anonymousClass3.L$1 = null;
                        anonymousClass3.J$0 = j2;
                        anonymousClass3.J$1 = j3;
                        anonymousClass3.label = 3;
                        if (r3.flush(anonymousClass3) != coroutineSingletons) {
                            j4 = j3;
                            j5 = j2;
                        }
                    } else {
                        if (byteReadChannel3.getReadBuffer().exhausted()) {
                            anonymousClass3.L$0 = byteReadChannel3;
                            anonymousClass3.L$1 = r3;
                            anonymousClass3.J$0 = j2;
                            anonymousClass3.J$1 = j3;
                            anonymousClass3.label = i2;
                        }
                        AnonymousClass2 anonymousClass4 = anonymousClass3;
                        byteReadChannel2 = byteReadChannel3;
                        anonymousClass2 = anonymousClass4;
                        r3 = r3;
                        long jMin2 = Math.min(j3, ByteReadPacketKt.getRemaining(byteReadChannel2.getReadBuffer()));
                        byteReadChannel2.getReadBuffer().readTo(r3.getWriteBuffer(), jMin2);
                        j3 -= jMin2;
                        anonymousClass2.L$0 = byteReadChannel2;
                        anonymousClass2.L$1 = r3;
                        anonymousClass2.J$0 = j2;
                        anonymousClass2.J$1 = j3;
                        anonymousClass2.J$2 = jMin2;
                        anonymousClass2.label = 2;
                        Object objFlush2 = r3.flush(anonymousClass2);
                        r2 = r3;
                    }
                    return coroutineSingletons;
                } catch (Throwable th) {
                    th = th;
                    AnonymousClass2 anonymousClass5 = anonymousClass3;
                    byteReadChannel2 = byteReadChannel3;
                    anonymousClass2 = anonymousClass5;
                    try {
                        byteReadChannel2.cancel(th);
                        ByteWriteChannelOperationsKt.close(r3, th);
                        throw th;
                    } catch (Throwable th2) {
                        anonymousClass2.L$0 = null;
                        anonymousClass2.L$1 = null;
                        anonymousClass2.L$2 = th2;
                        anonymousClass2.J$0 = j2;
                        anonymousClass2.J$1 = j3;
                        anonymousClass2.label = 4;
                        if (r3.flush(anonymousClass2) != coroutineSingletons) {
                            throw th2;
                        }
                    }
                }
            } else {
                if (r3 != 3) {
                    if (r3 != 4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Throwable th3 = (Throwable) anonymousClass2.L$2;
                    ResultKt.throwOnFailure(obj);
                    throw th3;
                }
                j4 = anonymousClass2.J$1;
                j5 = anonymousClass2.J$0;
                ResultKt.throwOnFailure(obj);
            }
            return new Long(j5 - j4);
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0049 -> B:26:0x0067). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005d -> B:25:0x0062). Please report as a decompilation issue!!! */
    public static final Object discard(ByteReadChannel byteReadChannel, long j, Continuation continuation) {
        C03361 c03361;
        C03361 c03362;
        long j2;
        ByteReadChannel byteReadChannel2;
        long j3;
        long j4;
        if (continuation instanceof C03361) {
            c03361 = (C03361) continuation;
            int i = c03361.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03361.label = i - Integer.MIN_VALUE;
            } else {
                c03361 = new C03361(continuation);
            }
        } else {
            c03361 = new C03361(continuation);
        }
        Object obj = c03361.result;
        int i2 = c03361.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c03362 = c03361;
            j2 = j;
            if (j > 0 || byteReadChannel.isClosedForRead()) {
                return new Long(j2 - j);
            }
            if (getAvailableForRead(byteReadChannel) == 0) {
                c03362.L$0 = byteReadChannel;
                c03362.J$0 = j2;
                c03362.J$1 = j;
                c03362.label = 1;
                Object objAwaitContent$default = ByteReadChannel.awaitContent$default(byteReadChannel, 0, c03362, 1, null);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objAwaitContent$default == coroutineSingletons) {
                    return coroutineSingletons;
                }
                byteReadChannel2 = byteReadChannel;
                j3 = j;
                j4 = j2;
                c03361 = c03362;
            }
            long jMin = Math.min(j, ByteReadPacketKt.getRemaining(byteReadChannel.getReadBuffer()));
            ByteReadPacketKt.discard(byteReadChannel.getReadBuffer(), jMin);
            j -= jMin;
            if (j > 0) {
            }
            return new Long(j2 - j);
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        j3 = c03361.J$1;
        j4 = c03361.J$0;
        byteReadChannel2 = (ByteReadChannel) c03361.L$0;
        ResultKt.throwOnFailure(obj);
        long j5 = j3;
        byteReadChannel = byteReadChannel2;
        j = j5;
        c03362 = c03361;
        j2 = j4;
        long jMin2 = Math.min(j, ByteReadPacketKt.getRemaining(byteReadChannel.getReadBuffer()));
        ByteReadPacketKt.discard(byteReadChannel.getReadBuffer(), jMin2);
        j -= jMin2;
        if (j > 0) {
        }
        return new Long(j2 - j);
    }

    public static /* synthetic */ Object discard$default(ByteReadChannel byteReadChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        return discard(byteReadChannel, j, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object discardExact(ByteReadChannel byteReadChannel, long j, Continuation continuation) throws EOFException {
        C03371 c03371;
        if (continuation instanceof C03371) {
            c03371 = (C03371) continuation;
            int i = c03371.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03371.label = i - Integer.MIN_VALUE;
            } else {
                c03371 = new C03371(continuation);
            }
        } else {
            c03371 = new C03371(continuation);
        }
        Object objDiscard = c03371.result;
        int i2 = c03371.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objDiscard);
            c03371.L$0 = null;
            c03371.J$0 = j;
            c03371.label = 1;
            objDiscard = discard(byteReadChannel, j, c03371);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objDiscard == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j = c03371.J$0;
            ResultKt.throwOnFailure(objDiscard);
        }
        if (((Number) objDiscard).longValue() >= j) {
            return Unit.INSTANCE;
        }
        throw new EOFException(IntIntPair$$ExternalSyntheticOutline0.m(j, "Unable to discard ", " bytes"));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object exhausted(ByteReadChannel byteReadChannel, Continuation continuation) {
        C03381 c03381;
        if (continuation instanceof C03381) {
            c03381 = (C03381) continuation;
            int i = c03381.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03381.label = i - Integer.MIN_VALUE;
            } else {
                c03381 = new C03381(continuation);
            }
        } else {
            c03381 = new C03381(continuation);
        }
        Object obj = c03381.result;
        int i2 = c03381.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (byteReadChannel.getReadBuffer().exhausted()) {
                c03381.L$0 = byteReadChannel;
                c03381.label = 1;
                Object objAwaitContent$default = ByteReadChannel.awaitContent$default(byteReadChannel, 0, c03381, 1, null);
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
            byteReadChannel = (ByteReadChannel) c03381.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boolean.valueOf(byteReadChannel.getReadBuffer().exhausted());
    }

    public static final int getAvailableForRead(ByteReadChannel byteReadChannel) {
        byteReadChannel.getClass();
        return (int) byteReadChannel.getReadBuffer().getBuffer().sizeMut;
    }

    public static final int getAvailableForWrite(ByteWriteChannel byteWriteChannel) {
        byteWriteChannel.getClass();
        return ByteChannelKt.CHANNEL_MAX_SIZE - BytePacketBuilderKt.getSize(byteWriteChannel.getWriteBuffer());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:106:0x02a9 A[Catch: all -> 0x02c3, TRY_LEAVE, TryCatch #3 {all -> 0x02c3, blocks: (B:104:0x02a1, B:106:0x02a9, B:115:0x02cb), top: B:211:0x02a1 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:114:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:122:0x0303 A[Catch: all -> 0x0354, TryCatch #4 {all -> 0x0354, blocks: (B:120:0x02fd, B:122:0x0303, B:124:0x030b), top: B:213:0x02fd }] */
    /* JADX WARN: Code duplicated, block: B:130:0x0345  */
    /* JADX WARN: Code duplicated, block: B:132:0x034c  */
    /* JADX WARN: Code duplicated, block: B:137:0x0359  */
    /* JADX WARN: Code duplicated, block: B:141:0x036f A[Catch: all -> 0x0052, TryCatch #2 {all -> 0x0052, blocks: (B:16:0x004d, B:180:0x042f, B:182:0x0437, B:188:0x0450, B:189:0x0458, B:158:0x03c3, B:161:0x03d3, B:162:0x03dd, B:139:0x0369, B:141:0x036f, B:143:0x0375, B:148:0x038c, B:153:0x039d, B:155:0x03a5, B:190:0x0459, B:191:0x0460, B:193:0x0463, B:198:0x0478, B:199:0x0480, B:200:0x0481, B:201:0x04aa), top: B:210:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:150:0x0392 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:151:0x0394  */
    /* JADX WARN: Code duplicated, block: B:153:0x039d A[Catch: all -> 0x0052, TryCatch #2 {all -> 0x0052, blocks: (B:16:0x004d, B:180:0x042f, B:182:0x0437, B:188:0x0450, B:189:0x0458, B:158:0x03c3, B:161:0x03d3, B:162:0x03dd, B:139:0x0369, B:141:0x036f, B:143:0x0375, B:148:0x038c, B:153:0x039d, B:155:0x03a5, B:190:0x0459, B:191:0x0460, B:193:0x0463, B:198:0x0478, B:199:0x0480, B:200:0x0481, B:201:0x04aa), top: B:210:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:155:0x03a5 A[Catch: all -> 0x0052, TryCatch #2 {all -> 0x0052, blocks: (B:16:0x004d, B:180:0x042f, B:182:0x0437, B:188:0x0450, B:189:0x0458, B:158:0x03c3, B:161:0x03d3, B:162:0x03dd, B:139:0x0369, B:141:0x036f, B:143:0x0375, B:148:0x038c, B:153:0x039d, B:155:0x03a5, B:190:0x0459, B:191:0x0460, B:193:0x0463, B:198:0x0478, B:199:0x0480, B:200:0x0481, B:201:0x04aa), top: B:210:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:157:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:158:0x03c3 A[Catch: all -> 0x0052, PHI: r0 r1 r2 r3 r5 r6 r7 r8 r9 r12 r14
      0x03c3: PHI (r0v44 boolean) = (r0v26 boolean), (r0v68 boolean) binds: [B:156:0x03bf, B:24:0x0078] A[DONT_GENERATE, DONT_INLINE]
      0x03c3: PHI (r1v50 java.lang.Object) = (r1v37 java.lang.Object), (r1v1 java.lang.Object) binds: [B:156:0x03bf, B:24:0x0078] A[DONT_GENERATE, DONT_INLINE]
      0x03c3: PHI (r2v30 io.ktor.utils.io.ByteReadChannelOperationsKt$internalReadLineTo$1) = 
      (r2v24 io.ktor.utils.io.ByteReadChannelOperationsKt$internalReadLineTo$1)
      (r2v2 io.ktor.utils.io.ByteReadChannelOperationsKt$internalReadLineTo$1)
     binds: [B:156:0x03bf, B:24:0x0078] A[DONT_GENERATE, DONT_INLINE]
      0x03c3: PHI (r3v26 boolean) = (r3v21 boolean), (r3v34 boolean) binds: [B:156:0x03bf, B:24:0x0078] A[DONT_GENERATE, DONT_INLINE]
      0x03c3: PHI (r5v21 ??) = (r5v36 ??), (r5v31 ??) binds: [B:156:0x03bf, B:24:0x0078] A[DONT_GENERATE, DONT_INLINE]
      0x03c3: PHI (r6v30 java.lang.Appendable) = (r6v21 java.lang.Appendable), (r6v39 java.lang.Appendable) binds: [B:156:0x03bf, B:24:0x0078] A[DONT_GENERATE, DONT_INLINE]
      0x03c3: PHI (r7v15 io.ktor.utils.io.ByteReadChannel) = (r7v10 io.ktor.utils.io.ByteReadChannel), (r7v24 io.ktor.utils.io.ByteReadChannel) binds: [B:156:0x03bf, B:24:0x0078] A[DONT_GENERATE, DONT_INLINE]
      0x03c3: PHI (r8v19 kotlin.jvm.internal.Ref$LongRef) = (r8v15 kotlin.jvm.internal.Ref$LongRef), (r8v26 kotlin.jvm.internal.Ref$LongRef) binds: [B:156:0x03bf, B:24:0x0078] A[DONT_GENERATE, DONT_INLINE]
      0x03c3: PHI (r9v13 ??) = (r9v18 ??), (r9v17 ??) binds: [B:156:0x03bf, B:24:0x0078] A[DONT_GENERATE, DONT_INLINE]
      0x03c3: PHI (r12v10 long) = (r12v7 long), (r12v15 long) binds: [B:156:0x03bf, B:24:0x0078] A[DONT_GENERATE, DONT_INLINE]
      0x03c3: PHI (r14v9 kotlinx.io.Source) = (r14v6 kotlinx.io.Source), (r14v13 kotlinx.io.Source) binds: [B:156:0x03bf, B:24:0x0078] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {all -> 0x0052, blocks: (B:16:0x004d, B:180:0x042f, B:182:0x0437, B:188:0x0450, B:189:0x0458, B:158:0x03c3, B:161:0x03d3, B:162:0x03dd, B:139:0x0369, B:141:0x036f, B:143:0x0375, B:148:0x038c, B:153:0x039d, B:155:0x03a5, B:190:0x0459, B:191:0x0460, B:193:0x0463, B:198:0x0478, B:199:0x0480, B:200:0x0481, B:201:0x04aa), top: B:210:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:160:0x03cb A[PHI: r0 r2 r3 r5 r6 r7 r8 r9 r12 r14
      0x03cb: PHI (r0v37 boolean) = (r0v26 boolean), (r0v44 boolean) binds: [B:154:0x03a3, B:159:0x03c9] A[DONT_GENERATE, DONT_INLINE]
      0x03cb: PHI (r2v28 io.ktor.utils.io.ByteReadChannelOperationsKt$internalReadLineTo$1) = 
      (r2v24 io.ktor.utils.io.ByteReadChannelOperationsKt$internalReadLineTo$1)
      (r2v30 io.ktor.utils.io.ByteReadChannelOperationsKt$internalReadLineTo$1)
     binds: [B:154:0x03a3, B:159:0x03c9] A[DONT_GENERATE, DONT_INLINE]
      0x03cb: PHI (r3v23 boolean) = (r3v21 boolean), (r3v26 boolean) binds: [B:154:0x03a3, B:159:0x03c9] A[DONT_GENERATE, DONT_INLINE]
      0x03cb: PHI (r5v16 ??) = (r5v37 ??), (r5v38 ??) binds: [B:154:0x03a3, B:159:0x03c9] A[DONT_GENERATE, DONT_INLINE]
      0x03cb: PHI (r6v25 java.lang.Appendable) = (r6v21 java.lang.Appendable), (r6v30 java.lang.Appendable) binds: [B:154:0x03a3, B:159:0x03c9] A[DONT_GENERATE, DONT_INLINE]
      0x03cb: PHI (r7v13 io.ktor.utils.io.ByteReadChannel) = (r7v10 io.ktor.utils.io.ByteReadChannel), (r7v15 io.ktor.utils.io.ByteReadChannel) binds: [B:154:0x03a3, B:159:0x03c9] A[DONT_GENERATE, DONT_INLINE]
      0x03cb: PHI (r8v17 kotlin.jvm.internal.Ref$LongRef) = (r8v15 kotlin.jvm.internal.Ref$LongRef), (r8v19 kotlin.jvm.internal.Ref$LongRef) binds: [B:154:0x03a3, B:159:0x03c9] A[DONT_GENERATE, DONT_INLINE]
      0x03cb: PHI (r9v12 ??) = (r9v19 ??), (r9v20 ??) binds: [B:154:0x03a3, B:159:0x03c9] A[DONT_GENERATE, DONT_INLINE]
      0x03cb: PHI (r12v9 long) = (r12v7 long), (r12v10 long) binds: [B:154:0x03a3, B:159:0x03c9] A[DONT_GENERATE, DONT_INLINE]
      0x03cb: PHI (r14v8 kotlinx.io.Source) = (r14v6 kotlinx.io.Source), (r14v9 kotlinx.io.Source) binds: [B:154:0x03a3, B:159:0x03c9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:161:0x03d3 A[Catch: all -> 0x0052, TryCatch #2 {all -> 0x0052, blocks: (B:16:0x004d, B:180:0x042f, B:182:0x0437, B:188:0x0450, B:189:0x0458, B:158:0x03c3, B:161:0x03d3, B:162:0x03dd, B:139:0x0369, B:141:0x036f, B:143:0x0375, B:148:0x038c, B:153:0x039d, B:155:0x03a5, B:190:0x0459, B:191:0x0460, B:193:0x0463, B:198:0x0478, B:199:0x0480, B:200:0x0481, B:201:0x04aa), top: B:210:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:165:0x03ec A[Catch: all -> 0x040c, TRY_LEAVE, TryCatch #7 {all -> 0x040c, blocks: (B:163:0x03de, B:165:0x03ec, B:176:0x0413), top: B:218:0x03de }] */
    /* JADX WARN: Code duplicated, block: B:168:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:173:0x040e  */
    /* JADX WARN: Code duplicated, block: B:175:0x0412  */
    /* JADX WARN: Code duplicated, block: B:179:0x042d  */
    /* JADX WARN: Code duplicated, block: B:182:0x0437 A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #2 {all -> 0x0052, blocks: (B:16:0x004d, B:180:0x042f, B:182:0x0437, B:188:0x0450, B:189:0x0458, B:158:0x03c3, B:161:0x03d3, B:162:0x03dd, B:139:0x0369, B:141:0x036f, B:143:0x0375, B:148:0x038c, B:153:0x039d, B:155:0x03a5, B:190:0x0459, B:191:0x0460, B:193:0x0463, B:198:0x0478, B:199:0x0480, B:200:0x0481, B:201:0x04aa), top: B:210:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:185:0x0442  */
    /* JADX WARN: Code duplicated, block: B:187:0x044e  */
    /* JADX WARN: Code duplicated, block: B:190:0x0459 A[Catch: all -> 0x0052, TryCatch #2 {all -> 0x0052, blocks: (B:16:0x004d, B:180:0x042f, B:182:0x0437, B:188:0x0450, B:189:0x0458, B:158:0x03c3, B:161:0x03d3, B:162:0x03dd, B:139:0x0369, B:141:0x036f, B:143:0x0375, B:148:0x038c, B:153:0x039d, B:155:0x03a5, B:190:0x0459, B:191:0x0460, B:193:0x0463, B:198:0x0478, B:199:0x0480, B:200:0x0481, B:201:0x04aa), top: B:210:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:192:0x0461 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:193:0x0463 A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #2 {all -> 0x0052, blocks: (B:16:0x004d, B:180:0x042f, B:182:0x0437, B:188:0x0450, B:189:0x0458, B:158:0x03c3, B:161:0x03d3, B:162:0x03dd, B:139:0x0369, B:141:0x036f, B:143:0x0375, B:148:0x038c, B:153:0x039d, B:155:0x03a5, B:190:0x0459, B:191:0x0460, B:193:0x0463, B:198:0x0478, B:199:0x0480, B:200:0x0481, B:201:0x04aa), top: B:210:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:196:0x046c  */
    /* JADX WARN: Code duplicated, block: B:198:0x0478 A[Catch: all -> 0x0052, TRY_ENTER, TryCatch #2 {all -> 0x0052, blocks: (B:16:0x004d, B:180:0x042f, B:182:0x0437, B:188:0x0450, B:189:0x0458, B:158:0x03c3, B:161:0x03d3, B:162:0x03dd, B:139:0x0369, B:141:0x036f, B:143:0x0375, B:148:0x038c, B:153:0x039d, B:155:0x03a5, B:190:0x0459, B:191:0x0460, B:193:0x0463, B:198:0x0478, B:199:0x0480, B:200:0x0481, B:201:0x04aa), top: B:210:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:200:0x0481 A[Catch: all -> 0x0052, TryCatch #2 {all -> 0x0052, blocks: (B:16:0x004d, B:180:0x042f, B:182:0x0437, B:188:0x0450, B:189:0x0458, B:158:0x03c3, B:161:0x03d3, B:162:0x03dd, B:139:0x0369, B:141:0x036f, B:143:0x0375, B:148:0x038c, B:153:0x039d, B:155:0x03a5, B:190:0x0459, B:191:0x0460, B:193:0x0463, B:198:0x0478, B:199:0x0480, B:200:0x0481, B:201:0x04aa), top: B:210:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:204:0x04af  */
    /* JADX WARN: Code duplicated, block: B:51:0x0174 A[Catch: all -> 0x01cc, TryCatch #6 {all -> 0x01cc, blocks: (B:49:0x016e, B:51:0x0174, B:53:0x017a, B:59:0x01ae, B:73:0x01dc, B:80:0x01fa, B:88:0x0220, B:93:0x023a, B:99:0x0265, B:118:0x02ee), top: B:217:0x016e }] */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x016e, code lost:
    
        r7 = r8;
        r8 = r10;
        r10 = r13;
        r6 = r14;
        r12 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0148, code lost:
    
        if (io.ktor.utils.io.ByteReadChannel.awaitContent$default(r0, 0, r2, 1, null) == r9) goto L178;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:200:0x0481, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r31v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r31v4, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r31v5, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlin.coroutines.intrinsics.CoroutineSingletons] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Appendable] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v26, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:127:0x0336 -> B:206:0x033d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object internalReadLineTo(ByteReadChannel byteReadChannel, Appendable appendable, long j, boolean z, boolean z2, Continuation continuation) throws Throwable {
        C03391 c03391;
        ?? r5;
        Object obj;
        ?? r9;
        Source readBuffer;
        Appendable appendable2;
        long j2;
        boolean z3;
        boolean z4;
        ?? r10;
        Ref$LongRef ref$LongRef;
        ?? ref$ObjectRef;
        long j3;
        boolean z5;
        ?? r11;
        long j4;
        long j5;
        long j6;
        Source source;
        ?? r13;
        Ref$LongRef ref$LongRef2;
        boolean z6;
        long j7;
        long j8;
        boolean z7;
        long j9;
        boolean z8;
        Object objInternalReadLineTo$discardCrlfOrCr;
        long j10;
        long j11;
        Appendable appendable3;
        ?? r12;
        Ref$LongRef ref$LongRef3;
        long jMin;
        ByteReadChannel byteReadChannel2;
        Source source2;
        Object obj2;
        Source source3;
        ByteReadChannel byteReadChannel3;
        boolean z9;
        Appendable appendable4;
        ?? r31;
        ?? r14;
        ?? r15;
        ?? r6;
        long j12;
        Object obj3;
        ?? r16;
        ?? r17;
        ?? r7;
        boolean z10;
        Ref$LongRef ref$LongRef4;
        ByteReadChannel byteReadChannel4;
        Appendable appendable5;
        ?? r8;
        boolean z11;
        long j13;
        byte b;
        ?? r18;
        Appendable appendable6;
        Object obj4;
        ?? r19;
        ?? r20;
        Object obj5;
        int i;
        ByteReadChannel byteReadChannel5 = byteReadChannel;
        if (!(continuation instanceof C03391) || (r5 = (i = (c03391 = (C03391) continuation).label) & Integer.MIN_VALUE) == 0) {
            c03391 = new C03391(continuation);
        } else {
            c03391.label = i - Integer.MIN_VALUE;
        }
        Object objAwaitContent$default = c03391.result;
        int i2 = c03391.label;
        ?? r21 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                r9 = r21;
                ResultKt.throwOnFailure(objAwaitContent$default);
                readBuffer = byteReadChannel5.getReadBuffer();
                if (readBuffer.exhausted()) {
                    c03391.L$0 = byteReadChannel5;
                    appendable2 = appendable;
                    c03391.L$1 = appendable2;
                    c03391.L$2 = readBuffer;
                    j2 = j;
                    c03391.J$0 = j2;
                    z3 = z;
                    c03391.Z$0 = z3;
                    z4 = z2;
                    c03391.Z$1 = z4;
                    c03391.label = 1;
                } else {
                    appendable2 = appendable;
                    j2 = j;
                    z3 = z;
                    z4 = z2;
                    r10 = r9;
                }
            } else {
                if (i2 != 1) {
                    if (i2 == 2) {
                        jMin = c03391.J$4;
                        long j14 = c03391.J$3;
                        long j15 = c03391.J$2;
                        r12 = r21;
                        long j16 = c03391.J$1;
                        boolean z12 = c03391.Z$1;
                        boolean z13 = c03391.Z$0;
                        long j17 = c03391.J$0;
                        Ref$ObjectRef ref$ObjectRef2 = (Ref$ObjectRef) c03391.L$4;
                        z8 = z12;
                        Ref$LongRef ref$LongRef5 = (Ref$LongRef) c03391.L$3;
                        Source source4 = (Source) c03391.L$2;
                        Appendable appendable7 = (Appendable) c03391.L$1;
                        ByteReadChannel byteReadChannel6 = (ByteReadChannel) c03391.L$0;
                        try {
                            ResultKt.throwOnFailure(objAwaitContent$default);
                            z7 = z13;
                            objInternalReadLineTo$discardCrlfOrCr = objAwaitContent$default;
                            byteReadChannel2 = byteReadChannel6;
                            source2 = source4;
                            ref$LongRef3 = ref$LongRef5;
                            j7 = j16;
                            r5 = ref$ObjectRef2;
                            appendable3 = appendable7;
                            j9 = j17;
                            j11 = j14;
                            j10 = j15;
                            if (((Boolean) objInternalReadLineTo$discardCrlfOrCr).booleanValue()) {
                                Long l = new Long(ref$LongRef3.element);
                                obj2 = r5.element;
                                if (obj2 != null) {
                                    Buffer buffer = (Buffer) obj2;
                                    appendable3.append(Utf8Kt.commonReadUtf8(buffer, buffer.sizeMut));
                                }
                                return l;
                            }
                            ByteReadChannel byteReadChannel7 = byteReadChannel2;
                            C03391 c03392 = c03391;
                            internalReadLineTo$bufferBytes(r5, source2, ref$LongRef3, 1L);
                            c03391 = c03392;
                            appendable2 = appendable3;
                            ref$LongRef2 = ref$LongRef3;
                            z6 = z8;
                            j6 = jMin;
                            z5 = z7;
                            j4 = j10;
                            source = source2;
                            r13 = r5;
                            j8 = j9;
                            byteReadChannel5 = byteReadChannel7;
                            j5 = j11;
                            r10 = r12;
                            if (ref$LongRef2.element < j8) {
                                z4 = z6;
                                ref$LongRef = ref$LongRef2;
                                ref$ObjectRef = r13;
                                readBuffer = source;
                                j3 = j8;
                            } else {
                                z4 = z6;
                                ref$LongRef = ref$LongRef2;
                                ref$ObjectRef = r13;
                                readBuffer = source;
                                j3 = j8;
                            }
                            if (ref$LongRef.element < j3) {
                            }
                            boolean z14 = z5;
                            source3 = readBuffer;
                            boolean z15 = z4;
                            byteReadChannel3 = byteReadChannel5;
                            z9 = z15;
                            appendable4 = appendable2;
                            z5 = z14;
                            r15 = r10;
                            r14 = ref$ObjectRef;
                            r6 = r14;
                            if (ref$LongRef.element != 0) {
                            }
                            j12 = ref$LongRef.element;
                            if (j12 > j3) {
                                throw new IllegalStateException(("Consumed bytes exceed the limit: " + ref$LongRef.element + " > " + j3 + ". It's an implementation bug, please report it.").toString());
                            }
                            if (j12 != j3) {
                                if (z9) {
                                    throwEndOfStreamException(j12);
                                    throw new HttpException();
                                }
                                Long l2 = new Long(j12);
                                obj3 = r6.element;
                                if (obj3 != null) {
                                    Buffer buffer2 = (Buffer) obj3;
                                    appendable4.append(Utf8Kt.commonReadUtf8(buffer2, buffer2.sizeMut));
                                }
                                return l2;
                            }
                            if (j3 == Long.MAX_VALUE) {
                                throw new TooLongLineException("Max line length exceeded");
                            }
                            if (ByteReadPacketKt.getRemaining(source3) != 0) {
                                r7 = r6;
                                r17 = r15;
                                z10 = z9;
                                ref$LongRef4 = ref$LongRef;
                                byteReadChannel4 = byteReadChannel3;
                                appendable5 = appendable4;
                                r8 = r7;
                                z11 = z5;
                                j13 = j3;
                                b = source3.getBuffer().get(0L);
                                if (b == 10) {
                                    ByteReadPacketKt.discard(source3, 1L);
                                    Long l3 = new Long(ref$LongRef4.element);
                                    obj4 = r8.element;
                                    if (obj4 != null) {
                                        Buffer buffer3 = (Buffer) obj4;
                                        appendable5.append(Utf8Kt.commonReadUtf8(buffer3, buffer3.sizeMut));
                                    }
                                    return l3;
                                }
                                if (b == 13) {
                                    c03391.L$0 = null;
                                    c03391.L$1 = appendable5;
                                    c03391.L$2 = null;
                                    c03391.L$3 = ref$LongRef4;
                                    c03391.L$4 = r8;
                                    c03391.J$0 = j13;
                                    c03391.Z$0 = z11;
                                    c03391.Z$1 = z10;
                                    c03391.label = 5;
                                    objAwaitContent$default = internalReadLineTo$discardCrlfOrCr(source3, byteReadChannel4, z11, c03391);
                                    r16 = r17;
                                    if (objAwaitContent$default != r17) {
                                        r18 = r8;
                                        appendable6 = appendable5;
                                        if (((Boolean) objAwaitContent$default).booleanValue()) {
                                            Long l4 = new Long(ref$LongRef4.element);
                                            obj5 = r18.element;
                                            if (obj5 != null) {
                                                Buffer buffer4 = (Buffer) obj5;
                                                appendable6.append(Utf8Kt.commonReadUtf8(buffer4, buffer4.sizeMut));
                                            }
                                            return l4;
                                        }
                                    }
                                }
                                throwTooLongLineException(j13);
                                throw new HttpException();
                            }
                            c03391.L$0 = byteReadChannel3;
                            c03391.L$1 = appendable4;
                            c03391.L$2 = source3;
                            c03391.L$3 = ref$LongRef;
                            c03391.L$4 = r6;
                            c03391.J$0 = j3;
                            c03391.Z$0 = z5;
                            c03391.Z$1 = z9;
                            c03391.label = 4;
                            objAwaitContent$default = ByteReadChannel.awaitContent$default(byteReadChannel3, 0, c03391, 1, null);
                            if (objAwaitContent$default != r15) {
                                r7 = r6;
                                r17 = r15;
                                r20 = r6;
                                r19 = r15;
                                r7 = r20;
                                r17 = r19;
                                if (!((Boolean) objAwaitContent$default).booleanValue()) {
                                    throwEndOfStreamException(ref$LongRef.element);
                                    throw new HttpException();
                                }
                                r7 = r6;
                                r17 = r15;
                                z10 = z9;
                                ref$LongRef4 = ref$LongRef;
                                byteReadChannel4 = byteReadChannel3;
                                appendable5 = appendable4;
                                r8 = r7;
                                z11 = z5;
                                j13 = j3;
                                b = source3.getBuffer().get(0L);
                                if (b == 10) {
                                    ByteReadPacketKt.discard(source3, 1L);
                                    Long l5 = new Long(ref$LongRef4.element);
                                    obj4 = r8.element;
                                    if (obj4 != null) {
                                        Buffer buffer5 = (Buffer) obj4;
                                        appendable5.append(Utf8Kt.commonReadUtf8(buffer5, buffer5.sizeMut));
                                    }
                                    return l5;
                                }
                                if (b == 13) {
                                    c03391.L$0 = null;
                                    c03391.L$1 = appendable5;
                                    c03391.L$2 = null;
                                    c03391.L$3 = ref$LongRef4;
                                    c03391.L$4 = r8;
                                    c03391.J$0 = j13;
                                    c03391.Z$0 = z11;
                                    c03391.Z$1 = z10;
                                    c03391.label = 5;
                                    objAwaitContent$default = internalReadLineTo$discardCrlfOrCr(source3, byteReadChannel4, z11, c03391);
                                    r16 = r17;
                                    if (objAwaitContent$default != r17) {
                                        r18 = r8;
                                        appendable6 = appendable5;
                                        if (((Boolean) objAwaitContent$default).booleanValue()) {
                                            Long l6 = new Long(ref$LongRef4.element);
                                            obj5 = r18.element;
                                            if (obj5 != null) {
                                                Buffer buffer6 = (Buffer) obj5;
                                                appendable6.append(Utf8Kt.commonReadUtf8(buffer6, buffer6.sizeMut));
                                            }
                                            return l6;
                                        }
                                    }
                                }
                                throwTooLongLineException(j13);
                                throw new HttpException();
                            }
                            r7 = r6;
                            r17 = r15;
                            r20 = r6;
                            r19 = r15;
                            r16 = r15;
                            r16 = r9;
                            r10 = r9;
                            r16 = r10;
                            return r16;
                        } catch (Throwable th) {
                            th = th;
                            r5 = ref$ObjectRef2;
                            r21 = appendable7;
                        }
                    } else {
                        if (i2 != 3) {
                            if (i2 == 4) {
                                z9 = c03391.Z$1;
                                z5 = c03391.Z$0;
                                long j18 = c03391.J$0;
                                Ref$ObjectRef ref$ObjectRef3 = (Ref$ObjectRef) c03391.L$4;
                                Ref$LongRef ref$LongRef6 = (Ref$LongRef) c03391.L$3;
                                source3 = (Source) c03391.L$2;
                                Appendable appendable8 = (Appendable) c03391.L$1;
                                byteReadChannel3 = (ByteReadChannel) c03391.L$0;
                                try {
                                    ResultKt.throwOnFailure(objAwaitContent$default);
                                    ref$LongRef = ref$LongRef6;
                                    j3 = j18;
                                    r19 = r21;
                                    r20 = ref$ObjectRef3;
                                    appendable4 = appendable8;
                                    r7 = r6;
                                    r17 = r15;
                                    r20 = r6;
                                    r19 = r15;
                                    r7 = r20;
                                    r17 = r19;
                                    if (!((Boolean) objAwaitContent$default).booleanValue()) {
                                        throwEndOfStreamException(ref$LongRef.element);
                                        throw new HttpException();
                                    }
                                    r7 = r6;
                                    r17 = r15;
                                    z10 = z9;
                                    ref$LongRef4 = ref$LongRef;
                                    byteReadChannel4 = byteReadChannel3;
                                    appendable5 = appendable4;
                                    r8 = r7;
                                    z11 = z5;
                                    j13 = j3;
                                    try {
                                        b = source3.getBuffer().get(0L);
                                        if (b == 10) {
                                            ByteReadPacketKt.discard(source3, 1L);
                                            Long l7 = new Long(ref$LongRef4.element);
                                            obj4 = r8.element;
                                            if (obj4 != null) {
                                                Buffer buffer7 = (Buffer) obj4;
                                                appendable5.append(Utf8Kt.commonReadUtf8(buffer7, buffer7.sizeMut));
                                            }
                                            return l7;
                                        }
                                        if (b == 13) {
                                            c03391.L$0 = null;
                                            c03391.L$1 = appendable5;
                                            c03391.L$2 = null;
                                            c03391.L$3 = ref$LongRef4;
                                            c03391.L$4 = r8;
                                            c03391.J$0 = j13;
                                            c03391.Z$0 = z11;
                                            c03391.Z$1 = z10;
                                            c03391.label = 5;
                                            objAwaitContent$default = internalReadLineTo$discardCrlfOrCr(source3, byteReadChannel4, z11, c03391);
                                            r16 = r17;
                                            if (objAwaitContent$default != r17) {
                                                r18 = r8;
                                                appendable6 = appendable5;
                                            }
                                            r16 = r9;
                                            r10 = r9;
                                            r16 = r10;
                                            return r16;
                                        }
                                        throwTooLongLineException(j13);
                                        throw new HttpException();
                                    } catch (Throwable th2) {
                                        th = th2;
                                        r5 = r8;
                                        r21 = appendable5;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    r5 = ref$ObjectRef3;
                                    r21 = appendable8;
                                }
                            } else {
                                if (i2 != 5) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                    return null;
                                }
                                j13 = c03391.J$0;
                                Ref$ObjectRef ref$ObjectRef4 = (Ref$ObjectRef) c03391.L$4;
                                ref$LongRef4 = (Ref$LongRef) c03391.L$3;
                                appendable6 = (Appendable) c03391.L$1;
                                ResultKt.throwOnFailure(objAwaitContent$default);
                                r18 = ref$ObjectRef4;
                            }
                            if (((Boolean) objAwaitContent$default).booleanValue()) {
                                Long l8 = new Long(ref$LongRef4.element);
                                obj5 = r18.element;
                                if (obj5 != null) {
                                    Buffer buffer8 = (Buffer) obj5;
                                    appendable6.append(Utf8Kt.commonReadUtf8(buffer8, buffer8.sizeMut));
                                }
                                return l8;
                            }
                            throwTooLongLineException(j13);
                            throw new HttpException();
                        }
                        boolean z16 = c03391.Z$1;
                        z5 = c03391.Z$0;
                        long j19 = c03391.J$0;
                        Ref$ObjectRef ref$ObjectRef5 = (Ref$ObjectRef) c03391.L$4;
                        Ref$LongRef ref$LongRef7 = (Ref$LongRef) c03391.L$3;
                        Source source5 = (Source) c03391.L$2;
                        Appendable appendable9 = (Appendable) c03391.L$1;
                        ByteReadChannel byteReadChannel8 = (ByteReadChannel) c03391.L$0;
                        try {
                            ResultKt.throwOnFailure(objAwaitContent$default);
                            ref$ObjectRef = ref$ObjectRef5;
                            j3 = j19;
                            ref$LongRef = ref$LongRef7;
                            z4 = z16;
                            byteReadChannel5 = byteReadChannel8;
                            r10 = r21;
                            try {
                                if (((Boolean) objAwaitContent$default).booleanValue()) {
                                    try {
                                        appendable2 = appendable9;
                                        readBuffer = source5;
                                        if (ref$LongRef.element < j3 || byteReadChannel5.isClosedForRead()) {
                                            boolean z17 = z5;
                                            source3 = readBuffer;
                                            boolean z18 = z4;
                                            byteReadChannel3 = byteReadChannel5;
                                            z9 = z18;
                                            appendable4 = appendable2;
                                            z5 = z17;
                                            r15 = r10;
                                            r14 = ref$ObjectRef;
                                        } else {
                                            long j20 = j3 - ref$LongRef.element;
                                            long jIndexOf$default = Utf8Kt.indexOf$default(readBuffer, LF, j20, 2);
                                            boolean z19 = z5;
                                            Source source6 = readBuffer;
                                            long jInternalReadLineTo$scanForSoleCr = internalReadLineTo$scanForSoleCr(source6, z19, jIndexOf$default, j20);
                                            source = source6;
                                            if (jInternalReadLineTo$scanForSoleCr >= 0) {
                                                internalReadLineTo$appendOrBuffer(ref$ObjectRef, appendable2, source, ref$LongRef, jInternalReadLineTo$scanForSoleCr);
                                                ByteReadPacketKt.discard(source, 1L);
                                                Long l9 = new Long(ref$LongRef.element);
                                                Object obj6 = ref$ObjectRef.element;
                                                if (obj6 != null) {
                                                    Buffer buffer9 = (Buffer) obj6;
                                                    appendable2.append(Utf8Kt.commonReadUtf8(buffer9, buffer9.sizeMut));
                                                }
                                                return l9;
                                            }
                                            if (jIndexOf$default == 0) {
                                                ByteReadPacketKt.discard(source, 1L);
                                                Long l10 = new Long(ref$LongRef.element);
                                                Object obj7 = ref$ObjectRef.element;
                                                if (obj7 != null) {
                                                    Buffer buffer10 = (Buffer) obj7;
                                                    appendable2.append(Utf8Kt.commonReadUtf8(buffer10, buffer10.sizeMut));
                                                }
                                                return l10;
                                            }
                                            if (jIndexOf$default > 0) {
                                                long j21 = source.getBuffer().get(jIndexOf$default - 1) == 13 ? 1L : 0L;
                                                internalReadLineTo$appendOrBuffer(ref$ObjectRef, appendable2, source, ref$LongRef, jIndexOf$default - j21);
                                                ByteReadPacketKt.discard(source, j21 + 1);
                                                Long l11 = new Long(ref$LongRef.element);
                                                Object obj8 = ref$ObjectRef.element;
                                                if (obj8 != null) {
                                                    Buffer buffer11 = (Buffer) obj8;
                                                    appendable2.append(Utf8Kt.commonReadUtf8(buffer11, buffer11.sizeMut));
                                                }
                                                return l11;
                                            }
                                            jMin = Math.min(j20, ByteReadPacketKt.getRemaining(source));
                                            Ref$LongRef ref$LongRef8 = ref$LongRef;
                                            ?? r110 = r10;
                                            long j22 = jMin - 1;
                                            Appendable appendable10 = appendable2;
                                            if (source.getBuffer().get(j22) == 13) {
                                                try {
                                                    r31 = ref$ObjectRef;
                                                    internalReadLineTo$appendOrBuffer(r31, appendable10, source, ref$LongRef8, j22);
                                                    ref$LongRef3 = ref$LongRef8;
                                                    c03391.L$0 = byteReadChannel5;
                                                    c03391.L$1 = appendable10;
                                                    c03391.L$2 = source;
                                                    c03391.L$3 = ref$LongRef3;
                                                    c03391.L$4 = ref$ObjectRef;
                                                    c03391.J$0 = j3;
                                                    c03391.Z$0 = z19;
                                                    c03391.Z$1 = z4;
                                                    c03391.J$1 = j20;
                                                    c03391.J$2 = jIndexOf$default;
                                                    c03391.J$3 = jInternalReadLineTo$scanForSoleCr;
                                                    c03391.J$4 = jMin;
                                                    c03391.label = 2;
                                                    objInternalReadLineTo$discardCrlfOrCr = internalReadLineTo$discardCrlfOrCr(source, byteReadChannel5, z19, c03391);
                                                    ?? r22 = r110;
                                                    r16 = r22;
                                                    if (objInternalReadLineTo$discardCrlfOrCr != r22) {
                                                        try {
                                                            z8 = z4;
                                                            z7 = z19;
                                                            j9 = j3;
                                                            j11 = jInternalReadLineTo$scanForSoleCr;
                                                            r5 = ref$ObjectRef;
                                                            j7 = j20;
                                                            appendable3 = appendable10;
                                                            byteReadChannel2 = byteReadChannel5;
                                                            source2 = source;
                                                            j10 = jIndexOf$default;
                                                            r12 = r22;
                                                            if (((Boolean) objInternalReadLineTo$discardCrlfOrCr).booleanValue()) {
                                                                Long l12 = new Long(ref$LongRef3.element);
                                                                obj2 = r5.element;
                                                                if (obj2 != null) {
                                                                    Buffer buffer12 = (Buffer) obj2;
                                                                    appendable3.append(Utf8Kt.commonReadUtf8(buffer12, buffer12.sizeMut));
                                                                }
                                                                return l12;
                                                            }
                                                            try {
                                                                ByteReadChannel byteReadChannel9 = byteReadChannel2;
                                                                C03391 c03393 = c03391;
                                                                internalReadLineTo$bufferBytes(r5, source2, ref$LongRef3, 1L);
                                                                c03391 = c03393;
                                                                appendable2 = appendable3;
                                                                ref$LongRef2 = ref$LongRef3;
                                                                z6 = z8;
                                                                j6 = jMin;
                                                                z5 = z7;
                                                                j4 = j10;
                                                                source = source2;
                                                                r13 = r5;
                                                                j8 = j9;
                                                                byteReadChannel5 = byteReadChannel9;
                                                                j5 = j11;
                                                                r10 = r12;
                                                                if (ref$LongRef2.element < j8 || ByteReadPacketKt.getRemaining(source) != 0) {
                                                                    z4 = z6;
                                                                    ref$LongRef = ref$LongRef2;
                                                                    ref$ObjectRef = r13;
                                                                    readBuffer = source;
                                                                    j3 = j8;
                                                                    if (ref$LongRef.element < j3) {
                                                                    }
                                                                    boolean z110 = z5;
                                                                    source3 = readBuffer;
                                                                    boolean z111 = z4;
                                                                    byteReadChannel3 = byteReadChannel5;
                                                                    z9 = z111;
                                                                    appendable4 = appendable2;
                                                                    z5 = z110;
                                                                    r15 = r10;
                                                                    r14 = ref$ObjectRef;
                                                                } else {
                                                                    c03391.L$0 = byteReadChannel5;
                                                                    c03391.L$1 = appendable2;
                                                                    c03391.L$2 = source;
                                                                    c03391.L$3 = ref$LongRef2;
                                                                    c03391.L$4 = r13;
                                                                    c03391.J$0 = j8;
                                                                    c03391.Z$0 = z5;
                                                                    c03391.Z$1 = z6;
                                                                    c03391.J$1 = j7;
                                                                    c03391.J$2 = j4;
                                                                    c03391.J$3 = j5;
                                                                    c03391.J$4 = j6;
                                                                    c03391.label = 3;
                                                                    Object objAwaitContent$default2 = ByteReadChannel.awaitContent$default(byteReadChannel5, 0, c03391, 1, null);
                                                                    if (objAwaitContent$default2 != r10) {
                                                                        r16 = r10;
                                                                        z4 = z6;
                                                                        ref$LongRef = ref$LongRef2;
                                                                        ref$ObjectRef = r13;
                                                                        source5 = source;
                                                                        j3 = j8;
                                                                        appendable9 = appendable2;
                                                                        objAwaitContent$default = objAwaitContent$default2;
                                                                        r10 = r10;
                                                                        if (((Boolean) objAwaitContent$default).booleanValue()) {
                                                                            boolean z20 = z4;
                                                                            byteReadChannel3 = byteReadChannel5;
                                                                            z9 = z20;
                                                                            appendable4 = appendable9;
                                                                            source3 = source5;
                                                                            r15 = r10;
                                                                            r14 = ref$ObjectRef;
                                                                        } else {
                                                                            appendable2 = appendable9;
                                                                            readBuffer = source5;
                                                                            if (ref$LongRef.element < j3) {
                                                                            }
                                                                            boolean z112 = z5;
                                                                            source3 = readBuffer;
                                                                            boolean z113 = z4;
                                                                            byteReadChannel3 = byteReadChannel5;
                                                                            z9 = z113;
                                                                            appendable4 = appendable2;
                                                                            z5 = z112;
                                                                            r15 = r10;
                                                                            r14 = ref$ObjectRef;
                                                                        }
                                                                    }
                                                                }
                                                            } catch (Throwable th4) {
                                                                th = th4;
                                                                r21 = appendable2;
                                                                r5 = r13;
                                                            }
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            r21 = appendable3;
                                                        }
                                                    }
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    ref$ObjectRef = r31;
                                                    appendable2 = appendable10;
                                                    r21 = appendable2;
                                                    r11 = ref$ObjectRef;
                                                    r5 = r11;
                                                    obj = r5.element;
                                                    if (obj != null) {
                                                        Buffer buffer13 = (Buffer) obj;
                                                        r21.append(Utf8Kt.commonReadUtf8(buffer13, buffer13.sizeMut));
                                                    }
                                                    throw th;
                                                }
                                            } else {
                                                appendable2 = appendable10;
                                                r10 = r110;
                                                internalReadLineTo$bufferBytes(ref$ObjectRef, source, ref$LongRef8, jMin);
                                                j4 = jIndexOf$default;
                                                j6 = jMin;
                                                j5 = jInternalReadLineTo$scanForSoleCr;
                                                z5 = z19;
                                                j8 = j3;
                                                r13 = ref$ObjectRef;
                                                ref$LongRef2 = ref$LongRef8;
                                                z6 = z4;
                                                j7 = j20;
                                                if (ref$LongRef2.element < j8) {
                                                    z4 = z6;
                                                    ref$LongRef = ref$LongRef2;
                                                    ref$ObjectRef = r13;
                                                    readBuffer = source;
                                                    j3 = j8;
                                                } else {
                                                    z4 = z6;
                                                    ref$LongRef = ref$LongRef2;
                                                    ref$ObjectRef = r13;
                                                    readBuffer = source;
                                                    j3 = j8;
                                                }
                                                if (ref$LongRef.element < j3) {
                                                }
                                                boolean z114 = z5;
                                                source3 = readBuffer;
                                                boolean z115 = z4;
                                                byteReadChannel3 = byteReadChannel5;
                                                z9 = z115;
                                                appendable4 = appendable2;
                                                z5 = z114;
                                                r15 = r10;
                                                r14 = ref$ObjectRef;
                                            }
                                        }
                                        r16 = r9;
                                        r10 = r9;
                                        r16 = r10;
                                        return r16;
                                    } catch (Throwable th7) {
                                        th = th7;
                                    }
                                } else {
                                    boolean z21 = z4;
                                    byteReadChannel3 = byteReadChannel5;
                                    z9 = z21;
                                    appendable4 = appendable9;
                                    source3 = source5;
                                    r15 = r10;
                                    r14 = ref$ObjectRef;
                                }
                                r6 = r14;
                                if (ref$LongRef.element != 0 && byteReadChannel3.isClosedForRead()) {
                                    Long l13 = new Long(-1L);
                                    Object obj9 = r6.element;
                                    if (obj9 != null) {
                                        Buffer buffer14 = (Buffer) obj9;
                                        appendable4.append(Utf8Kt.commonReadUtf8(buffer14, buffer14.sizeMut));
                                    }
                                    return l13;
                                }
                                j12 = ref$LongRef.element;
                                if (j12 > j3) {
                                    throw new IllegalStateException(("Consumed bytes exceed the limit: " + ref$LongRef.element + " > " + j3 + ". It's an implementation bug, please report it.").toString());
                                }
                                if (j12 != j3) {
                                    if (z9) {
                                        throwEndOfStreamException(j12);
                                        throw new HttpException();
                                    }
                                    Long l14 = new Long(j12);
                                    obj3 = r6.element;
                                    if (obj3 != null) {
                                        Buffer buffer15 = (Buffer) obj3;
                                        appendable4.append(Utf8Kt.commonReadUtf8(buffer15, buffer15.sizeMut));
                                    }
                                    return l14;
                                }
                                if (j3 == Long.MAX_VALUE) {
                                    throw new TooLongLineException("Max line length exceeded");
                                }
                                if (ByteReadPacketKt.getRemaining(source3) != 0) {
                                    r7 = r6;
                                    r17 = r15;
                                    z10 = z9;
                                    ref$LongRef4 = ref$LongRef;
                                    byteReadChannel4 = byteReadChannel3;
                                    appendable5 = appendable4;
                                    r8 = r7;
                                    z11 = z5;
                                    j13 = j3;
                                    b = source3.getBuffer().get(0L);
                                    if (b == 10) {
                                        ByteReadPacketKt.discard(source3, 1L);
                                        Long l15 = new Long(ref$LongRef4.element);
                                        obj4 = r8.element;
                                        if (obj4 != null) {
                                            Buffer buffer16 = (Buffer) obj4;
                                            appendable5.append(Utf8Kt.commonReadUtf8(buffer16, buffer16.sizeMut));
                                        }
                                        return l15;
                                    }
                                    if (b == 13) {
                                        c03391.L$0 = null;
                                        c03391.L$1 = appendable5;
                                        c03391.L$2 = null;
                                        c03391.L$3 = ref$LongRef4;
                                        c03391.L$4 = r8;
                                        c03391.J$0 = j13;
                                        c03391.Z$0 = z11;
                                        c03391.Z$1 = z10;
                                        c03391.label = 5;
                                        objAwaitContent$default = internalReadLineTo$discardCrlfOrCr(source3, byteReadChannel4, z11, c03391);
                                        r16 = r17;
                                        if (objAwaitContent$default != r17) {
                                            r18 = r8;
                                            appendable6 = appendable5;
                                            if (((Boolean) objAwaitContent$default).booleanValue()) {
                                                Long l16 = new Long(ref$LongRef4.element);
                                                obj5 = r18.element;
                                                if (obj5 != null) {
                                                    Buffer buffer17 = (Buffer) obj5;
                                                    appendable6.append(Utf8Kt.commonReadUtf8(buffer17, buffer17.sizeMut));
                                                }
                                                return l16;
                                            }
                                        }
                                    }
                                    throwTooLongLineException(j13);
                                    throw new HttpException();
                                }
                                c03391.L$0 = byteReadChannel3;
                                c03391.L$1 = appendable4;
                                c03391.L$2 = source3;
                                c03391.L$3 = ref$LongRef;
                                c03391.L$4 = r6;
                                c03391.J$0 = j3;
                                c03391.Z$0 = z5;
                                c03391.Z$1 = z9;
                                c03391.label = 4;
                                objAwaitContent$default = ByteReadChannel.awaitContent$default(byteReadChannel3, 0, c03391, 1, null);
                                if (objAwaitContent$default != r15) {
                                    r7 = r6;
                                    r17 = r15;
                                    r20 = r6;
                                    r19 = r15;
                                    r7 = r20;
                                    r17 = r19;
                                    if (!((Boolean) objAwaitContent$default).booleanValue()) {
                                        throwEndOfStreamException(ref$LongRef.element);
                                        throw new HttpException();
                                    }
                                    r7 = r6;
                                    r17 = r15;
                                    z10 = z9;
                                    ref$LongRef4 = ref$LongRef;
                                    byteReadChannel4 = byteReadChannel3;
                                    appendable5 = appendable4;
                                    r8 = r7;
                                    z11 = z5;
                                    j13 = j3;
                                    b = source3.getBuffer().get(0L);
                                    if (b == 10) {
                                        ByteReadPacketKt.discard(source3, 1L);
                                        Long l17 = new Long(ref$LongRef4.element);
                                        obj4 = r8.element;
                                        if (obj4 != null) {
                                            Buffer buffer18 = (Buffer) obj4;
                                            appendable5.append(Utf8Kt.commonReadUtf8(buffer18, buffer18.sizeMut));
                                        }
                                        return l17;
                                    }
                                    if (b == 13) {
                                        c03391.L$0 = null;
                                        c03391.L$1 = appendable5;
                                        c03391.L$2 = null;
                                        c03391.L$3 = ref$LongRef4;
                                        c03391.L$4 = r8;
                                        c03391.J$0 = j13;
                                        c03391.Z$0 = z11;
                                        c03391.Z$1 = z10;
                                        c03391.label = 5;
                                        objAwaitContent$default = internalReadLineTo$discardCrlfOrCr(source3, byteReadChannel4, z11, c03391);
                                        r16 = r17;
                                        if (objAwaitContent$default != r17) {
                                            r18 = r8;
                                            appendable6 = appendable5;
                                            if (((Boolean) objAwaitContent$default).booleanValue()) {
                                                Long l18 = new Long(ref$LongRef4.element);
                                                obj5 = r18.element;
                                                if (obj5 != null) {
                                                    Buffer buffer19 = (Buffer) obj5;
                                                    appendable6.append(Utf8Kt.commonReadUtf8(buffer19, buffer19.sizeMut));
                                                }
                                                return l18;
                                            }
                                        }
                                    }
                                    throwTooLongLineException(j13);
                                    throw new HttpException();
                                }
                                r7 = r6;
                                r17 = r15;
                                r20 = r6;
                                r19 = r15;
                                r16 = r15;
                                r16 = r9;
                                r10 = r9;
                                r16 = r10;
                                return r16;
                            } catch (Throwable th8) {
                                th = th8;
                                r21 = appendable9;
                                r11 = ref$ObjectRef;
                                r5 = r11;
                                obj = r5.element;
                                if (obj != null) {
                                    Buffer buffer110 = (Buffer) obj;
                                    r21.append(Utf8Kt.commonReadUtf8(buffer110, buffer110.sizeMut));
                                }
                                throw th;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            r21 = appendable9;
                            r5 = ref$ObjectRef5;
                        }
                    }
                    obj = r5.element;
                    if (obj != null) {
                        Buffer buffer111 = (Buffer) obj;
                        r21.append(Utf8Kt.commonReadUtf8(buffer111, buffer111.sizeMut));
                    }
                    throw th;
                }
                r10 = r21;
                boolean z22 = c03391.Z$1;
                boolean z23 = c03391.Z$0;
                long j23 = c03391.J$0;
                readBuffer = (Source) c03391.L$2;
                Appendable appendable11 = (Appendable) c03391.L$1;
                ByteReadChannel byteReadChannel10 = (ByteReadChannel) c03391.L$0;
                ResultKt.throwOnFailure(objAwaitContent$default);
                z3 = z23;
                j2 = j23;
                appendable2 = appendable11;
                z4 = z22;
                byteReadChannel5 = byteReadChannel10;
            }
            r16 = r9;
            r10 = r9;
            if (byteReadChannel5.isClosedForRead()) {
                return new Long(-1L);
            }
            ref$LongRef = new Ref$LongRef();
            ref$ObjectRef = new Ref$ObjectRef();
            j3 = j2;
            z5 = z3;
            if (ref$LongRef.element < j3) {
            }
            boolean z116 = z5;
            source3 = readBuffer;
            boolean z117 = z4;
            byteReadChannel3 = byteReadChannel5;
            z9 = z117;
            appendable4 = appendable2;
            z5 = z116;
            r15 = r10;
            r14 = ref$ObjectRef;
            r6 = r14;
            if (ref$LongRef.element != 0) {
            }
            j12 = ref$LongRef.element;
            if (j12 > j3) {
                throw new IllegalStateException(("Consumed bytes exceed the limit: " + ref$LongRef.element + " > " + j3 + ". It's an implementation bug, please report it.").toString());
            }
            if (j12 != j3) {
                if (z9) {
                    throwEndOfStreamException(j12);
                    throw new HttpException();
                }
                Long l19 = new Long(j12);
                obj3 = r6.element;
                if (obj3 != null) {
                    Buffer buffer112 = (Buffer) obj3;
                    appendable4.append(Utf8Kt.commonReadUtf8(buffer112, buffer112.sizeMut));
                }
                return l19;
            }
            if (j3 == Long.MAX_VALUE) {
                throw new TooLongLineException("Max line length exceeded");
            }
            if (ByteReadPacketKt.getRemaining(source3) != 0) {
                r7 = r6;
                r17 = r15;
                z10 = z9;
                ref$LongRef4 = ref$LongRef;
                byteReadChannel4 = byteReadChannel3;
                appendable5 = appendable4;
                r8 = r7;
                z11 = z5;
                j13 = j3;
                b = source3.getBuffer().get(0L);
                if (b == 10) {
                    ByteReadPacketKt.discard(source3, 1L);
                    Long l110 = new Long(ref$LongRef4.element);
                    obj4 = r8.element;
                    if (obj4 != null) {
                        Buffer buffer113 = (Buffer) obj4;
                        appendable5.append(Utf8Kt.commonReadUtf8(buffer113, buffer113.sizeMut));
                    }
                    return l110;
                }
                if (b == 13) {
                    c03391.L$0 = null;
                    c03391.L$1 = appendable5;
                    c03391.L$2 = null;
                    c03391.L$3 = ref$LongRef4;
                    c03391.L$4 = r8;
                    c03391.J$0 = j13;
                    c03391.Z$0 = z11;
                    c03391.Z$1 = z10;
                    c03391.label = 5;
                    objAwaitContent$default = internalReadLineTo$discardCrlfOrCr(source3, byteReadChannel4, z11, c03391);
                    r16 = r17;
                    if (objAwaitContent$default != r17) {
                        r18 = r8;
                        appendable6 = appendable5;
                        if (((Boolean) objAwaitContent$default).booleanValue()) {
                            Long l111 = new Long(ref$LongRef4.element);
                            obj5 = r18.element;
                            if (obj5 != null) {
                                Buffer buffer114 = (Buffer) obj5;
                                appendable6.append(Utf8Kt.commonReadUtf8(buffer114, buffer114.sizeMut));
                            }
                            return l111;
                        }
                    }
                }
                throwTooLongLineException(j13);
                throw new HttpException();
            }
            c03391.L$0 = byteReadChannel3;
            c03391.L$1 = appendable4;
            c03391.L$2 = source3;
            c03391.L$3 = ref$LongRef;
            c03391.L$4 = r6;
            c03391.J$0 = j3;
            c03391.Z$0 = z5;
            c03391.Z$1 = z9;
            c03391.label = 4;
            objAwaitContent$default = ByteReadChannel.awaitContent$default(byteReadChannel3, 0, c03391, 1, null);
            if (objAwaitContent$default != r15) {
                r7 = r6;
                r17 = r15;
                r20 = r6;
                r19 = r15;
                r7 = r20;
                r17 = r19;
                if (!((Boolean) objAwaitContent$default).booleanValue()) {
                    throwEndOfStreamException(ref$LongRef.element);
                    throw new HttpException();
                }
                r7 = r6;
                r17 = r15;
                z10 = z9;
                ref$LongRef4 = ref$LongRef;
                byteReadChannel4 = byteReadChannel3;
                appendable5 = appendable4;
                r8 = r7;
                z11 = z5;
                j13 = j3;
                b = source3.getBuffer().get(0L);
                if (b == 10) {
                    ByteReadPacketKt.discard(source3, 1L);
                    Long l112 = new Long(ref$LongRef4.element);
                    obj4 = r8.element;
                    if (obj4 != null) {
                        Buffer buffer115 = (Buffer) obj4;
                        appendable5.append(Utf8Kt.commonReadUtf8(buffer115, buffer115.sizeMut));
                    }
                    return l112;
                }
                if (b == 13) {
                    c03391.L$0 = null;
                    c03391.L$1 = appendable5;
                    c03391.L$2 = null;
                    c03391.L$3 = ref$LongRef4;
                    c03391.L$4 = r8;
                    c03391.J$0 = j13;
                    c03391.Z$0 = z11;
                    c03391.Z$1 = z10;
                    c03391.label = 5;
                    objAwaitContent$default = internalReadLineTo$discardCrlfOrCr(source3, byteReadChannel4, z11, c03391);
                    r16 = r17;
                    if (objAwaitContent$default != r17) {
                        r18 = r8;
                        appendable6 = appendable5;
                        if (((Boolean) objAwaitContent$default).booleanValue()) {
                            Long l113 = new Long(ref$LongRef4.element);
                            obj5 = r18.element;
                            if (obj5 != null) {
                                Buffer buffer116 = (Buffer) obj5;
                                appendable6.append(Utf8Kt.commonReadUtf8(buffer116, buffer116.sizeMut));
                            }
                            return l113;
                        }
                    }
                }
                throwTooLongLineException(j13);
                throw new HttpException();
            }
            r7 = r6;
            r17 = r15;
            r20 = r6;
            r19 = r15;
            r16 = r15;
            r16 = r9;
            r10 = r9;
            r16 = r10;
            return r16;
        } catch (Throwable th10) {
            th = th10;
        }
    }

    private static final void internalReadLineTo$appendOrBuffer(Ref$ObjectRef ref$ObjectRef, Appendable appendable, Source source, Ref$LongRef ref$LongRef, long j) throws IOException {
        if (ref$ObjectRef.element != null) {
            internalReadLineTo$bufferBytes(ref$ObjectRef, source, ref$LongRef, j);
        } else if (j > 0) {
            appendable.append(Utf8Kt.readString(source, j));
            ref$LongRef.element += j;
        }
    }

    private static final void internalReadLineTo$bufferBytes(Ref$ObjectRef ref$ObjectRef, Source source, Ref$LongRef ref$LongRef, long j) throws EOFException {
        if (j > 0) {
            Object buffer = ref$ObjectRef.element;
            if (buffer == null) {
                buffer = new Buffer();
                ref$ObjectRef.element = buffer;
            }
            ((Buffer) buffer).write(source, j);
            ref$LongRef.element += j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x005f A[PHI: r10 r12
      0x005f: PHI (r10v4 kotlinx.io.Source) = (r10v0 kotlinx.io.Source), (r10v6 kotlinx.io.Source) binds: [B:15:0x0043, B:20:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x005f: PHI (r12v2 boolean) = (r12v0 boolean), (r12v3 boolean) binds: [B:15:0x0043, B:20:0x005d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:23:0x006b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0073  */
    /* JADX WARN: Code duplicated, block: B:28:0x0079  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object internalReadLineTo$discardCrlfOrCr(Source source, ByteReadChannel byteReadChannel, boolean z, Continuation continuation) {
        ByteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1 byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1;
        if (continuation instanceof ByteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1) {
            byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1 = (ByteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1) continuation;
            int i = byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.label = i - Integer.MIN_VALUE;
            } else {
                byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1 = new ByteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1(continuation);
            }
        } else {
            byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1 = new ByteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1(continuation);
        }
        Object objAwaitContent = byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.result;
        int i2 = byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwaitContent);
            if (ByteReadPacketKt.getRemaining(source) < 2) {
                byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.L$0 = source;
                byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.L$1 = null;
                byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.Z$0 = z;
                byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.label = 1;
                objAwaitContent = byteReadChannel.awaitContent(2, byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1);
                Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objAwaitContent == obj) {
                    return obj;
                }
            } else if (source.getBuffer().get(1L) == 10) {
                ByteReadPacketKt.discard(source, 2L);
                return Boolean.TRUE;
            }
            if (z) {
                return Boolean.FALSE;
            }
            ByteReadPacketKt.discard(source, 1L);
            return Boolean.TRUE;
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        z = byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.Z$0;
        source = (Source) byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.L$0;
        ResultKt.throwOnFailure(objAwaitContent);
        if (((Boolean) objAwaitContent).booleanValue()) {
            if (source.getBuffer().get(1L) == 10) {
                ByteReadPacketKt.discard(source, 2L);
                return Boolean.TRUE;
            }
        }
        if (z) {
            return Boolean.FALSE;
        }
        ByteReadPacketKt.discard(source, 1L);
        return Boolean.TRUE;
    }

    private static final long internalReadLineTo$scanForSoleCr(Source source, boolean z, long j, long j2) {
        long jMin;
        if (!z) {
            return -1L;
        }
        if (j == -1) {
            jMin = Math.min(j2, ByteReadPacketKt.getRemaining(source) - 1);
        } else {
            jMin = j == 0 ? 0L : j - 1;
        }
        return Utf8Kt.indexOf$default(source, CR, jMin, 2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object peek(ByteReadChannel byteReadChannel, int i, Continuation continuation) {
        C03401 c03401;
        if (continuation instanceof C03401) {
            c03401 = (C03401) continuation;
            int i2 = c03401.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c03401.label = i2 - Integer.MIN_VALUE;
            } else {
                c03401 = new C03401(continuation);
            }
        } else {
            c03401 = new C03401(continuation);
        }
        Object objAwaitContent = c03401.result;
        int i3 = c03401.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objAwaitContent);
            if (!byteReadChannel.isClosedForRead()) {
                c03401.L$0 = byteReadChannel;
                c03401.I$0 = i;
                c03401.label = 1;
                objAwaitContent = byteReadChannel.awaitContent(i, c03401);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objAwaitContent == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return null;
        }
        if (i3 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        i = c03401.I$0;
        byteReadChannel = (ByteReadChannel) c03401.L$0;
        ResultKt.throwOnFailure(objAwaitContent);
        if (((Boolean) objAwaitContent).booleanValue()) {
            return new ByteString(Utf8Kt.readByteArray(byteReadChannel.getReadBuffer().peek(), i));
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x009a  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:37:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:40:0x00fb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:43:0x0103  */
    /* JADX WARN: Code duplicated, block: B:44:0x0108  */
    /* JADX WARN: Code duplicated, block: B:46:0x010e  */
    /* JADX WARN: Code duplicated, block: B:50:0x011c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object read(ByteReadChannel byteReadChannel, Function4 function4, Continuation continuation) {
        C03411 c03411;
        int i;
        Function4 function5;
        int i2;
        Ref$IntRef ref$IntRef;
        Buffer buffer;
        Segment segment;
        Segment segment2;
        Ref$IntRef ref$IntRef2;
        Buffer buffer2;
        Ref$IntRef ref$IntRef3;
        int i3;
        if (continuation instanceof C03411) {
            c03411 = (C03411) continuation;
            int i4 = c03411.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c03411.label = i4 - Integer.MIN_VALUE;
            } else {
                c03411 = new C03411(continuation);
            }
        } else {
            c03411 = new C03411(continuation);
        }
        Object objInvoke = c03411.result;
        int i5 = c03411.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i5 != 0) {
            if (i5 == 1) {
                int i6 = c03411.I$0;
                Function4 function6 = (Function4) c03411.L$1;
                ByteReadChannel byteReadChannel2 = (ByteReadChannel) c03411.L$0;
                ResultKt.throwOnFailure(objInvoke);
                function5 = function6;
                i2 = i6;
                byteReadChannel = byteReadChannel2;
            } else {
                if (i5 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ref$IntRef3 = (Ref$IntRef) c03411.L$7;
                segment2 = (Segment) c03411.L$5;
                buffer2 = (Buffer) c03411.L$4;
                ref$IntRef2 = (Ref$IntRef) c03411.L$2;
                ResultKt.throwOnFailure(objInvoke);
            }
            ref$IntRef3.element = ((Number) objInvoke).intValue();
            i3 = ref$IntRef2.element;
            if (i3 != 0) {
                if (i3 < 0) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned negative read bytes count");
                    return null;
                }
                if (i3 > segment2.getSize()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned too many bytes");
                    return null;
                }
                buffer2.skip(i3);
            }
            return new Integer(ref$IntRef2.element);
        }
        ResultKt.throwOnFailure(objInvoke);
        if (byteReadChannel.isClosedForRead()) {
            return new Integer(-1);
        }
        if (byteReadChannel.getReadBuffer().exhausted()) {
            c03411.L$0 = byteReadChannel;
            c03411.L$1 = function4;
            c03411.I$0 = 0;
            c03411.label = 1;
            if (ByteReadChannel.awaitContent$default(byteReadChannel, 0, c03411, 1, null) != coroutineSingletons) {
                function5 = function4;
                i2 = 0;
            }
        } else {
            i = 0;
            if (byteReadChannel.isClosedForRead()) {
                return new Integer(-1);
            }
            ref$IntRef = new Ref$IntRef();
            buffer = byteReadChannel.getReadBuffer().getBuffer();
            if (!buffer.exhausted()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Buffer is empty");
                return null;
            }
            segment = buffer.head;
            segment.getClass();
            byte[] bArr = segment.data;
            int i7 = segment.pos;
            int i8 = segment.limit;
            Integer num = new Integer(i7);
            Integer num2 = new Integer(i8);
            c03411.L$0 = null;
            c03411.L$1 = null;
            c03411.L$2 = ref$IntRef;
            c03411.L$3 = null;
            c03411.L$4 = buffer;
            c03411.L$5 = segment;
            c03411.L$6 = null;
            c03411.L$7 = ref$IntRef;
            c03411.I$0 = i;
            c03411.I$1 = 0;
            c03411.I$2 = i8;
            c03411.I$3 = i7;
            c03411.I$4 = 0;
            c03411.label = 2;
            objInvoke = function4.invoke(bArr, num, num2, c03411);
            if (objInvoke != coroutineSingletons) {
                segment2 = segment;
                ref$IntRef2 = ref$IntRef;
                buffer2 = buffer;
                ref$IntRef3 = ref$IntRef2;
                ref$IntRef3.element = ((Number) objInvoke).intValue();
                i3 = ref$IntRef2.element;
                if (i3 != 0) {
                    if (i3 < 0) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned negative read bytes count");
                        return null;
                    }
                    if (i3 > segment2.getSize()) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned too many bytes");
                        return null;
                    }
                    buffer2.skip(i3);
                }
                return new Integer(ref$IntRef2.element);
            }
        }
        return coroutineSingletons;
        Function4 function7 = function5;
        i = i2;
        function4 = function7;
        if (byteReadChannel.isClosedForRead()) {
            return new Integer(-1);
        }
        ref$IntRef = new Ref$IntRef();
        buffer = byteReadChannel.getReadBuffer().getBuffer();
        if (!buffer.exhausted()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Buffer is empty");
            return null;
        }
        segment = buffer.head;
        segment.getClass();
        byte[] bArr2 = segment.data;
        int i9 = segment.pos;
        int i10 = segment.limit;
        Integer num3 = new Integer(i9);
        Integer num4 = new Integer(i10);
        c03411.L$0 = null;
        c03411.L$1 = null;
        c03411.L$2 = ref$IntRef;
        c03411.L$3 = null;
        c03411.L$4 = buffer;
        c03411.L$5 = segment;
        c03411.L$6 = null;
        c03411.L$7 = ref$IntRef;
        c03411.I$0 = i;
        c03411.I$1 = 0;
        c03411.I$2 = i10;
        c03411.I$3 = i9;
        c03411.I$4 = 0;
        c03411.label = 2;
        objInvoke = function4.invoke(bArr2, num3, num4, c03411);
        if (objInvoke != coroutineSingletons) {
            segment2 = segment;
            ref$IntRef2 = ref$IntRef;
            buffer2 = buffer;
            ref$IntRef3 = ref$IntRef2;
            ref$IntRef3.element = ((Number) objInvoke).intValue();
            i3 = ref$IntRef2.element;
            if (i3 != 0) {
                if (i3 < 0) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned negative read bytes count");
                    return null;
                }
                if (i3 > segment2.getSize()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned too many bytes");
                    return null;
                }
                buffer2.skip(i3);
            }
            return new Integer(ref$IntRef2.element);
        }
        return coroutineSingletons;
    }

    private static final Object read$$forInline(ByteReadChannel byteReadChannel, Function4 function4, Continuation continuation) {
        if (!byteReadChannel.isClosedForRead()) {
            if (byteReadChannel.getReadBuffer().exhausted()) {
                ByteReadChannel.awaitContent$default(byteReadChannel, 0, continuation, 1, null);
            }
            if (!byteReadChannel.isClosedForRead()) {
                Buffer buffer = byteReadChannel.getReadBuffer().getBuffer();
                if (buffer.exhausted()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Buffer is empty");
                    return null;
                }
                Segment segment = buffer.head;
                segment.getClass();
                int iIntValue = ((Number) function4.invoke(segment.data, Integer.valueOf(segment.pos), Integer.valueOf(segment.limit), null)).intValue();
                if (iIntValue != 0) {
                    if (iIntValue < 0) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned negative read bytes count");
                        return null;
                    }
                    if (iIntValue > segment.getSize()) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Returned too many bytes");
                        return null;
                    }
                    buffer.skip(iIntValue);
                }
                return Integer.valueOf(iIntValue);
            }
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object readAvailable(ByteReadChannel byteReadChannel, byte[] bArr, int i, int i2, Continuation continuation) {
        C03421 c03421;
        if (continuation instanceof C03421) {
            c03421 = (C03421) continuation;
            int i3 = c03421.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c03421.label = i3 - Integer.MIN_VALUE;
            } else {
                c03421 = new C03421(continuation);
            }
        } else {
            c03421 = new C03421(continuation);
        }
        Object obj = c03421.result;
        int i4 = c03421.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            if (byteReadChannel.isClosedForRead()) {
                return new Integer(-1);
            }
            if (byteReadChannel.getReadBuffer().exhausted()) {
                c03421.L$0 = byteReadChannel;
                c03421.L$1 = bArr;
                c03421.I$0 = i;
                c03421.I$1 = i2;
                c03421.label = 1;
                Object objAwaitContent$default = ByteReadChannel.awaitContent$default(byteReadChannel, 0, c03421, 1, null);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objAwaitContent$default == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        } else {
            if (i4 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i2 = c03421.I$1;
            i = c03421.I$0;
            bArr = (byte[]) c03421.L$1;
            byteReadChannel = (ByteReadChannel) c03421.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return byteReadChannel.isClosedForRead() ? new Integer(-1) : new Integer(InputKt.readAvailable(byteReadChannel.getReadBuffer(), bArr, i, i2));
    }

    public static /* synthetic */ Object readAvailable$default(ByteReadChannel byteReadChannel, byte[] bArr, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        return readAvailable(byteReadChannel, bArr, i, i2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0056 -> B:26:0x0078). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x006c -> B:25:0x0072). Please report as a decompilation issue!!! */
    public static final Object readBuffer(ByteReadChannel byteReadChannel, long j, Continuation continuation) throws EOFException {
        AnonymousClass3 anonymousClass3;
        Buffer buffer;
        AnonymousClass3 anonymousClass4;
        long j2;
        long j3;
        ByteReadChannel byteReadChannel2;
        long j4;
        Buffer buffer2;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            int i = anonymousClass3.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        } else {
            anonymousClass3 = new AnonymousClass3(continuation);
        }
        Object obj = anonymousClass3.result;
        int i2 = anonymousClass3.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            buffer = new Buffer();
            anonymousClass4 = anonymousClass3;
            j2 = j;
            if (j > 0 || byteReadChannel.isClosedForRead()) {
                return buffer;
            }
            if (byteReadChannel.getReadBuffer().exhausted()) {
                anonymousClass4.L$0 = byteReadChannel;
                anonymousClass4.L$1 = buffer;
                anonymousClass4.J$0 = j2;
                anonymousClass4.J$1 = j;
                anonymousClass4.label = 1;
                Object objAwaitContent$default = ByteReadChannel.awaitContent$default(byteReadChannel, 0, anonymousClass4, 1, null);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objAwaitContent$default == coroutineSingletons) {
                    return coroutineSingletons;
                }
                long j5 = j2;
                anonymousClass3 = anonymousClass4;
                j3 = j5;
                byteReadChannel2 = byteReadChannel;
                j4 = j;
                buffer2 = buffer;
            }
            long jMin = Math.min(j, ByteReadPacketKt.getRemaining(byteReadChannel.getReadBuffer()));
            buffer.write(byteReadChannel.getReadBuffer(), jMin);
            j -= jMin;
            if (j > 0) {
            }
            return buffer;
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        j4 = anonymousClass3.J$1;
        j3 = anonymousClass3.J$0;
        buffer2 = (Buffer) anonymousClass3.L$1;
        byteReadChannel2 = (ByteReadChannel) anonymousClass3.L$0;
        ResultKt.throwOnFailure(obj);
        buffer = buffer2;
        j = j4;
        byteReadChannel = byteReadChannel2;
        long j6 = j3;
        anonymousClass4 = anonymousClass3;
        j2 = j6;
        long jMin2 = Math.min(j, ByteReadPacketKt.getRemaining(byteReadChannel.getReadBuffer()));
        buffer.write(byteReadChannel.getReadBuffer(), jMin2);
        j -= jMin2;
        if (j > 0) {
        }
        return buffer;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object readByte(ByteReadChannel byteReadChannel, Continuation continuation) {
        C03441 c03441;
        Source readBuffer;
        Source source;
        if (continuation instanceof C03441) {
            c03441 = (C03441) continuation;
            int i = c03441.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03441.label = i - Integer.MIN_VALUE;
            } else {
                c03441 = new C03441(continuation);
            }
        } else {
            c03441 = new C03441(continuation);
        }
        Object obj = c03441.result;
        int i2 = c03441.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            readBuffer = byteReadChannel.getReadBuffer();
            if (readBuffer.exhausted()) {
                c03441.L$0 = null;
                c03441.L$1 = readBuffer;
                c03441.label = 1;
                Object objAwaitContent$default = ByteReadChannel.awaitContent$default(byteReadChannel, 0, c03441, 1, null);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objAwaitContent$default == coroutineSingletons) {
                    return coroutineSingletons;
                }
                obj = objAwaitContent$default;
                source = readBuffer;
            }
            return Byte.valueOf(readBuffer.readByte());
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        source = (Source) c03441.L$1;
        ResultKt.throwOnFailure(obj);
        if (!((Boolean) obj).booleanValue()) {
            throw new EOFException("Not enough data available");
        }
        readBuffer = source;
        return Byte.valueOf(readBuffer.readByte());
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0059  */
    /* JADX WARN: Code duplicated, block: B:20:0x0075 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0076  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, kotlinx.io.Source] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0076 -> B:12:0x003e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object readByteArray(io.ktor.utils.io.ByteReadChannel r8, int r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C03451
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.ByteReadChannelOperationsKt$readByteArray$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C03451) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readByteArray$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readByteArray$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L47
            if (r1 != r2) goto L40
            int r8 = r0.I$2
            int r9 = r0.I$1
            int r1 = r0.I$0
            java.lang.Object r3 = r0.L$2
            kotlinx.io.Sink r3 = (kotlinx.io.Sink) r3
            java.lang.Object r4 = r0.L$1
            kotlinx.io.Buffer r4 = (kotlinx.io.Buffer) r4
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r5 = (io.ktor.utils.io.ByteReadChannel) r5
            kotlin.ResultKt.throwOnFailure(r10)
            r7 = r3
            r3 = r8
            r8 = r5
            r5 = r4
            r4 = r7
            r7 = r0
            r0 = r9
            r9 = r1
        L3e:
            r1 = r7
            goto L7d
        L40:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r8)
            r8 = 0
            return r8
        L47:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.io.Buffer r10 = new kotlinx.io.Buffer
            r10.<init>()
            r1 = 0
            r3 = r10
            r4 = r3
            r10 = r1
        L53:
            int r5 = io.ktor.utils.io.core.BytePacketBuilderKt.getSize(r3)
            if (r5 >= r9) goto L88
            int r5 = io.ktor.utils.io.core.BytePacketBuilderKt.getSize(r3)
            int r5 = r9 - r5
            r0.L$0 = r8
            r0.L$1 = r4
            r0.L$2 = r3
            r0.I$0 = r9
            r0.I$1 = r10
            r0.I$2 = r1
            r0.label = r2
            java.lang.Object r5 = readPacket(r8, r5, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r5 != r6) goto L76
            return r6
        L76:
            r7 = r0
            r0 = r10
            r10 = r5
            r5 = r4
            r4 = r3
            r3 = r1
            goto L3e
        L7d:
            kotlinx.io.Source r10 = (kotlinx.io.Source) r10
            io.ktor.utils.io.core.BytePacketBuilderKt.writePacket(r4, r10)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r4 = r5
            goto L53
        L88:
            byte[] r8 = kotlinx.io.Utf8Kt.readByteArray(r4)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readByteArray(io.ktor.utils.io.ByteReadChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object readDouble(ByteReadChannel byteReadChannel, Continuation continuation) throws EOFException {
        C03461 c03461;
        if (continuation instanceof C03461) {
            c03461 = (C03461) continuation;
            int i = c03461.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03461.label = i - Integer.MIN_VALUE;
            } else {
                c03461 = new C03461(continuation);
            }
        } else {
            c03461 = new C03461(continuation);
        }
        Object obj = c03461.result;
        int i2 = c03461.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c03461.L$0 = byteReadChannel;
            c03461.label = 1;
            Object objAwaitUntilReadable = awaitUntilReadable(byteReadChannel, 8, c03461);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAwaitUntilReadable == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            byteReadChannel = (ByteReadChannel) c03461.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Source readBuffer = byteReadChannel.getReadBuffer();
        readBuffer.getClass();
        return new Double(Double.longBitsToDouble(readBuffer.readLong()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object readFloat(ByteReadChannel byteReadChannel, Continuation continuation) throws EOFException {
        C03471 c03471;
        if (continuation instanceof C03471) {
            c03471 = (C03471) continuation;
            int i = c03471.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03471.label = i - Integer.MIN_VALUE;
            } else {
                c03471 = new C03471(continuation);
            }
        } else {
            c03471 = new C03471(continuation);
        }
        Object obj = c03471.result;
        int i2 = c03471.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c03471.L$0 = byteReadChannel;
            c03471.label = 1;
            Object objAwaitUntilReadable = awaitUntilReadable(byteReadChannel, 4, c03471);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAwaitUntilReadable == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            byteReadChannel = (ByteReadChannel) c03471.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Source readBuffer = byteReadChannel.getReadBuffer();
        readBuffer.getClass();
        return new Float(Float.intBitsToFloat(readBuffer.readInt()));
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0052  */
    /* JADX WARN: Code duplicated, block: B:25:0x005c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0071 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0072  */
    /* JADX WARN: Code duplicated, block: B:32:0x0082  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005a -> B:30:0x007c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0072 -> B:29:0x0077). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object readFully(io.ktor.utils.io.ByteReadChannel r7, byte[] r8, int r9, int r10, kotlin.coroutines.Continuation r11) {
        /*
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C03481
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.utils.io.ByteReadChannelOperationsKt$readFully$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C03481) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readFully$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readFully$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            int r1 = r0.label
            r2 = 0
            java.lang.String r3 = "Channel is already closed"
            r4 = 1
            if (r1 == 0) goto L3c
            if (r1 != r4) goto L36
            int r7 = r0.I$2
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$1
            byte[] r10 = (byte[]) r10
            java.lang.Object r1 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r1 = (io.ktor.utils.io.ByteReadChannel) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L77
        L36:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r7)
            return r2
        L3c:
            kotlin.ResultKt.throwOnFailure(r11)
            if (r10 <= r9) goto L4e
            boolean r11 = r7.isClosedForRead()
            if (r11 != 0) goto L48
            goto L4e
        L48:
            java.io.EOFException r7 = new java.io.EOFException
            r7.<init>(r3)
            throw r7
        L4e:
            r11 = r10
            r10 = r9
        L50:
            if (r9 >= r11) goto La1
            kotlinx.io.Source r1 = r7.getReadBuffer()
            boolean r1 = r1.exhausted()
            if (r1 == 0) goto L7c
            r0.L$0 = r7
            r0.L$1 = r8
            r0.I$0 = r10
            r0.I$1 = r11
            r0.I$2 = r9
            r0.label = r4
            r1 = 0
            java.lang.Object r1 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r7, r1, r0, r4, r2)
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 != r5) goto L72
            return r5
        L72:
            r1 = r7
            r7 = r9
            r9 = r10
            r10 = r8
            r8 = r11
        L77:
            r11 = r8
            r8 = r10
            r10 = r9
            r9 = r7
            r7 = r1
        L7c:
            boolean r1 = r7.isClosedForRead()
            if (r1 != 0) goto L9b
            int r1 = r11 - r9
            kotlinx.io.Source r5 = r7.getReadBuffer()
            long r5 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r5)
            int r5 = (int) r5
            int r1 = java.lang.Math.min(r1, r5)
            kotlinx.io.Source r5 = r7.getReadBuffer()
            int r1 = r1 + r9
            kotlinx.io.Utf8Kt.readTo(r5, r8, r9, r1)
            r9 = r1
            goto L50
        L9b:
            java.io.EOFException r7 = new java.io.EOFException
            r7.<init>(r3)
            throw r7
        La1:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readFully(io.ktor.utils.io.ByteReadChannel, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object readFully$default(ByteReadChannel byteReadChannel, byte[] bArr, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return readFully(byteReadChannel, bArr, i, i2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object readInt(ByteReadChannel byteReadChannel, Continuation continuation) throws EOFException {
        C03491 c03491;
        if (continuation instanceof C03491) {
            c03491 = (C03491) continuation;
            int i = c03491.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03491.label = i - Integer.MIN_VALUE;
            } else {
                c03491 = new C03491(continuation);
            }
        } else {
            c03491 = new C03491(continuation);
        }
        Object obj = c03491.result;
        int i2 = c03491.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c03491.L$0 = byteReadChannel;
            c03491.label = 1;
            Object objAwaitUntilReadable = awaitUntilReadable(byteReadChannel, 4, c03491);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAwaitUntilReadable == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            byteReadChannel = (ByteReadChannel) c03491.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return new Integer(byteReadChannel.getReadBuffer().readInt());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object readLine(ByteReadChannel byteReadChannel, LineEnding lineEnding, Continuation continuation) {
        C03501 c03501;
        StringBuilder sb;
        if (continuation instanceof C03501) {
            c03501 = (C03501) continuation;
            int i = c03501.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03501.label = i - Integer.MIN_VALUE;
            } else {
                c03501 = new C03501(continuation);
            }
        } else {
            c03501 = new C03501(continuation);
        }
        Object obj = c03501.result;
        int i2 = c03501.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            StringBuilder sb2 = new StringBuilder();
            c03501.L$0 = null;
            c03501.L$1 = null;
            c03501.L$2 = sb2;
            c03501.label = 1;
            Object lineTo = readLineTo(byteReadChannel, sb2, lineEnding, c03501);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (lineTo == coroutineSingletons) {
                return coroutineSingletons;
            }
            obj = lineTo;
            sb = sb2;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            sb = (StringBuilder) c03501.L$2;
            ResultKt.throwOnFailure(obj);
        }
        if (((Number) obj).longValue() >= 0) {
            return sb.toString();
        }
        return null;
    }

    public static /* synthetic */ Object readLine$default(ByteReadChannel byteReadChannel, LineEnding lineEnding, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            lineEnding = LineEnding.Default;
        }
        return readLine(byteReadChannel, lineEnding, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static final Object readLineStrict(ByteReadChannel byteReadChannel, long j, LineEnding lineEnding, Continuation continuation) {
        C03511 c03511;
        StringBuilder sb;
        if (continuation instanceof C03511) {
            c03511 = (C03511) continuation;
            int i = c03511.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03511.label = i - Integer.MIN_VALUE;
            } else {
                c03511 = new C03511(continuation);
            }
        } else {
            c03511 = new C03511(continuation);
        }
        C03511 c03512 = c03511;
        Object lineStrictTo = c03512.result;
        int i2 = c03512.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(lineStrictTo);
            StringBuilder sb2 = new StringBuilder();
            c03512.L$0 = null;
            c03512.L$1 = null;
            c03512.L$2 = sb2;
            c03512.J$0 = j;
            c03512.label = 1;
            lineStrictTo = readLineStrictTo(byteReadChannel, sb2, j, lineEnding, c03512);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (lineStrictTo == coroutineSingletons) {
                return coroutineSingletons;
            }
            sb = sb2;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            sb = (StringBuilder) c03512.L$2;
            ResultKt.throwOnFailure(lineStrictTo);
        }
        if (((Number) lineStrictTo).longValue() >= 0) {
            return sb.toString();
        }
        return null;
    }

    public static /* synthetic */ Object readLineStrict$default(ByteReadChannel byteReadChannel, long j, LineEnding lineEnding, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        if ((i & 2) != 0) {
            lineEnding = LineEnding.Default;
        }
        return readLineStrict(byteReadChannel, j, lineEnding, continuation);
    }

    public static final Object readLineStrictTo(ByteReadChannel byteReadChannel, Appendable appendable, long j, LineEnding lineEnding, Continuation continuation) {
        if (j >= 0) {
            return internalReadLineTo(byteReadChannel, appendable, j, lineEnding == LineEnding.Lenient, true, continuation);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(j, "Limit (", ") should be non-negative"));
        return null;
    }

    public static /* synthetic */ Object readLineStrictTo$default(ByteReadChannel byteReadChannel, Appendable appendable, long j, LineEnding lineEnding, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            lineEnding = LineEnding.Default;
        }
        return readLineStrictTo(byteReadChannel, appendable, j2, lineEnding, continuation);
    }

    public static final Object readLineTo(ByteReadChannel byteReadChannel, Appendable appendable, LineEnding lineEnding, Continuation continuation) {
        return internalReadLineTo(byteReadChannel, appendable, Long.MAX_VALUE, lineEnding == LineEnding.Lenient, false, continuation);
    }

    public static /* synthetic */ Object readLineTo$default(ByteReadChannel byteReadChannel, Appendable appendable, LineEnding lineEnding, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            lineEnding = LineEnding.Default;
        }
        return readLineTo(byteReadChannel, appendable, lineEnding, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object readLong(ByteReadChannel byteReadChannel, Continuation continuation) throws EOFException {
        C03521 c03521;
        if (continuation instanceof C03521) {
            c03521 = (C03521) continuation;
            int i = c03521.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03521.label = i - Integer.MIN_VALUE;
            } else {
                c03521 = new C03521(continuation);
            }
        } else {
            c03521 = new C03521(continuation);
        }
        Object obj = c03521.result;
        int i2 = c03521.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c03521.L$0 = byteReadChannel;
            c03521.label = 1;
            Object objAwaitUntilReadable = awaitUntilReadable(byteReadChannel, 8, c03521);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAwaitUntilReadable == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            byteReadChannel = (ByteReadChannel) c03521.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return new Long(byteReadChannel.getReadBuffer().readLong());
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    /* JADX WARN: Code duplicated, block: B:19:0x0052  */
    /* JADX WARN: Code duplicated, block: B:21:0x0063 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0064  */
    /* JADX WARN: Code duplicated, block: B:24:0x0068 A[PHI: r11 r12 r13
      0x0068: PHI (r11v5 io.ktor.utils.io.ByteReadChannel) = (r11v3 io.ktor.utils.io.ByteReadChannel), (r11v7 io.ktor.utils.io.ByteReadChannel) binds: [B:18:0x0050, B:23:0x0066] A[DONT_GENERATE, DONT_INLINE]
      0x0068: PHI (r12v6 kotlinx.io.Buffer) = (r12v5 kotlinx.io.Buffer), (r12v7 kotlinx.io.Buffer) binds: [B:18:0x0050, B:23:0x0066] A[DONT_GENERATE, DONT_INLINE]
      0x0068: PHI (r13v7 int) = (r13v6 int), (r13v8 int) binds: [B:18:0x0050, B:23:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x006e  */
    /* JADX WARN: Code duplicated, block: B:28:0x007f  */
    /* JADX WARN: Code duplicated, block: B:29:0x008a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0050 -> B:24:0x0068). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0064 -> B:23:0x0066). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object readPacket(io.ktor.utils.io.ByteReadChannel r11, int r12, kotlin.coroutines.Continuation r13) throws java.io.EOFException {
        /*
            boolean r0 = r13 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C03531
            if (r0 == 0) goto L13
            r0 = r13
            io.ktor.utils.io.ByteReadChannelOperationsKt$readPacket$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C03531) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readPacket$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readPacket$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            int r1 = r0.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L36
            if (r1 != r3) goto L30
            int r11 = r0.I$0
            java.lang.Object r12 = r0.L$1
            kotlinx.io.Buffer r12 = (kotlinx.io.Buffer) r12
            java.lang.Object r1 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r1 = (io.ktor.utils.io.ByteReadChannel) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L66
        L30:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r11)
            return r2
        L36:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlinx.io.Buffer r13 = new kotlinx.io.Buffer
            r13.<init>()
            r10 = r13
            r13 = r12
            r12 = r10
        L41:
            long r4 = r12.sizeMut
            long r6 = (long) r13
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 >= 0) goto L96
            kotlinx.io.Source r1 = r11.getReadBuffer()
            boolean r1 = r1.exhausted()
            if (r1 == 0) goto L68
            r0.L$0 = r11
            r0.L$1 = r12
            r0.I$0 = r13
            r0.label = r3
            r1 = 0
            java.lang.Object r1 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r11, r1, r0, r3, r2)
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 != r4) goto L64
            return r4
        L64:
            r1 = r11
            r11 = r13
        L66:
            r13 = r11
            r11 = r1
        L68:
            boolean r1 = r11.isClosedForRead()
            if (r1 != 0) goto L96
            kotlinx.io.Source r1 = r11.getReadBuffer()
            long r4 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r1)
            long r6 = (long) r13
            long r8 = r12.sizeMut
            long r8 = r6 - r8
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 <= 0) goto L8a
            kotlinx.io.Source r1 = r11.getReadBuffer()
            long r4 = r12.sizeMut
            long r6 = r6 - r4
            r1.readTo(r12, r6)
            goto L41
        L8a:
            kotlinx.io.Source r1 = r11.getReadBuffer()
            long r4 = r1.transferTo(r12)
            kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
            goto L41
        L96:
            long r0 = r12.sizeMut
            long r2 = (long) r13
            int r11 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r11 < 0) goto L9e
            return r12
        L9e:
            java.io.EOFException r11 = new java.io.EOFException
            java.lang.String r0 = "Not enough data available, required "
            java.lang.String r1 = " bytes but only "
            java.lang.StringBuilder r13 = androidx.collection.IntIntPair$$ExternalSyntheticOutline0.m2m(r13, r0, r1)
            long r0 = r12.sizeMut
            java.lang.String r12 = " available"
            java.lang.String r12 = androidx.collection.IntIntPair$$ExternalSyntheticOutline0.m(r13, r0, r12)
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readPacket(io.ktor.utils.io.ByteReadChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated
    public static final Object readRemaining(ByteReadChannel byteReadChannel, Continuation continuation) {
        return readBuffer(byteReadChannel, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object readShort(ByteReadChannel byteReadChannel, Continuation continuation) throws EOFException {
        C03541 c03541;
        if (continuation instanceof C03541) {
            c03541 = (C03541) continuation;
            int i = c03541.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03541.label = i - Integer.MIN_VALUE;
            } else {
                c03541 = new C03541(continuation);
            }
        } else {
            c03541 = new C03541(continuation);
        }
        Object obj = c03541.result;
        int i2 = c03541.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c03541.L$0 = byteReadChannel;
            c03541.label = 1;
            Object objAwaitUntilReadable = awaitUntilReadable(byteReadChannel, 2, c03541);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAwaitUntilReadable == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            byteReadChannel = (ByteReadChannel) c03541.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return new Short(byteReadChannel.getReadBuffer().readShort());
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0046  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0054 -> B:41:0x007c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x006a -> B:30:0x0070). Please report as a decompilation issue!!! */
    public static final Object readTo(ByteReadChannel byteReadChannel, RawSink rawSink, long j, Continuation continuation) throws Throwable {
        C03551 c03551;
        C03551 c03552;
        long j2;
        Throwable th;
        if (continuation instanceof C03551) {
            c03551 = (C03551) continuation;
            int i = c03551.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03551.label = i - Integer.MIN_VALUE;
            } else {
                c03551 = new C03551(continuation);
            }
        } else {
            c03551 = new C03551(continuation);
        }
        Object obj = c03551.result;
        int i2 = c03551.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c03552 = c03551;
            j2 = j;
            if (byteReadChannel.isClosedForRead()) {
            }
            rethrowCloseCauseIfNeeded(byteReadChannel);
            return new Long(j2 - j);
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        long j3 = c03551.J$1;
        long j4 = c03551.J$0;
        RawSink rawSink2 = (RawSink) c03551.L$1;
        ByteReadChannel byteReadChannel2 = (ByteReadChannel) c03551.L$0;
        try {
            ResultKt.throwOnFailure(obj);
            try {
                c03552 = c03551;
                long j5 = j3;
                rawSink = rawSink2;
                j2 = j4;
                byteReadChannel = byteReadChannel2;
                j = j5;
                long jMin = Math.min(j, ByteReadPacketKt.getRemaining(byteReadChannel.getReadBuffer()));
                byteReadChannel.getReadBuffer().readTo(rawSink, jMin);
                j -= jMin;
                rawSink.flush();
                if (!byteReadChannel.isClosedForRead() || j <= 0) {
                    rethrowCloseCauseIfNeeded(byteReadChannel);
                    return new Long(j2 - j);
                }
                if (byteReadChannel.getReadBuffer().exhausted()) {
                    c03552.L$0 = byteReadChannel;
                    c03552.L$1 = rawSink;
                    c03552.J$0 = j2;
                    c03552.J$1 = j;
                    c03552.label = 1;
                    Object objAwaitContent$default = ByteReadChannel.awaitContent$default(byteReadChannel, 0, c03552, 1, null);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objAwaitContent$default == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    byteReadChannel2 = byteReadChannel;
                    long j6 = j2;
                    rawSink2 = rawSink;
                    j3 = j;
                    c03551 = c03552;
                    j4 = j6;
                    c03552 = c03551;
                    long j7 = j3;
                    rawSink = rawSink2;
                    j2 = j4;
                    byteReadChannel = byteReadChannel2;
                    j = j7;
                }
                long jMin2 = Math.min(j, ByteReadPacketKt.getRemaining(byteReadChannel.getReadBuffer()));
                byteReadChannel.getReadBuffer().readTo(rawSink, jMin2);
                j -= jMin2;
                rawSink.flush();
                if (byteReadChannel.isClosedForRead()) {
                }
                rethrowCloseCauseIfNeeded(byteReadChannel);
                return new Long(j2 - j);
            } catch (Throwable th2) {
                byteReadChannel2 = byteReadChannel;
                rawSink2 = rawSink;
                th = th2;
                byteReadChannel2.cancel(th);
                rawSink2.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            byteReadChannel2.cancel(th);
            rawSink2.close();
            throw th;
        }
    }

    public static /* synthetic */ Object readTo$default(ByteReadChannel byteReadChannel, RawSink rawSink, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return readTo(byteReadChannel, rawSink, j, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Deprecated
    public static final Object readUTF8Line(ByteReadChannel byteReadChannel, int i, Continuation continuation) {
        C03561 c03561;
        StringBuilder sb;
        if (continuation instanceof C03561) {
            c03561 = (C03561) continuation;
            int i2 = c03561.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c03561.label = i2 - Integer.MIN_VALUE;
            } else {
                c03561 = new C03561(continuation);
            }
        } else {
            c03561 = new C03561(continuation);
        }
        Object obj = c03561.result;
        int i3 = c03561.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            StringBuilder sb2 = new StringBuilder();
            c03561.L$0 = null;
            c03561.L$1 = sb2;
            c03561.I$0 = i;
            c03561.label = 1;
            Object uTF8LineTo = readUTF8LineTo(byteReadChannel, sb2, i, c03561);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (uTF8LineTo == coroutineSingletons) {
                return coroutineSingletons;
            }
            obj = uTF8LineTo;
            sb = sb2;
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            sb = (StringBuilder) c03561.L$1;
            ResultKt.throwOnFailure(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            return sb.toString();
        }
        return null;
    }

    public static /* synthetic */ Object readUTF8Line$default(ByteReadChannel byteReadChannel, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8Line(byteReadChannel, i, continuation);
    }

    @Deprecated
    public static final Object readUTF8LineTo(ByteReadChannel byteReadChannel, Appendable appendable, int i, Continuation continuation) {
        return m1837readUTF8LineToRRvyBJ8(byteReadChannel, appendable, i, LineEndingMode.INSTANCE.m1850getAnyf0jXZW8(), continuation);
    }

    public static /* synthetic */ Object readUTF8LineTo$default(ByteReadChannel byteReadChannel, Appendable appendable, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8LineTo(byteReadChannel, appendable, i, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    @Deprecated
    /* JADX INFO: renamed from: readUTF8LineTo-RRvyBJ8, reason: not valid java name */
    public static final Object m1837readUTF8LineToRRvyBJ8(ByteReadChannel byteReadChannel, Appendable appendable, int i, int i2, Continuation continuation) throws EOFException {
        C03572 c03572;
        if (continuation instanceof C03572) {
            c03572 = (C03572) continuation;
            int i3 = c03572.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c03572.label = i3 - Integer.MIN_VALUE;
            } else {
                c03572 = new C03572(continuation);
            }
        } else {
            c03572 = new C03572(continuation);
        }
        C03572 c03573 = c03572;
        Object lineStrictTo = c03573.result;
        int i4 = c03573.label;
        try {
            if (i4 == 0) {
                ResultKt.throwOnFailure(lineStrictTo);
                long j = i;
                LineEnding lineEnding = LineEndingMode.m1843containslTjpP64(i2, LineEndingMode.INSTANCE.m1851getCRf0jXZW8()) ? LineEnding.Lenient : LineEnding.Default;
                c03573.L$0 = null;
                c03573.L$1 = null;
                c03573.I$0 = i;
                c03573.I$1 = i2;
                c03573.label = 1;
                lineStrictTo = readLineStrictTo(byteReadChannel, appendable, j, lineEnding, c03573);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (lineStrictTo == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i4 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(lineStrictTo);
            }
            return Boolean.valueOf(((Number) lineStrictTo).longValue() >= 0);
        } catch (EOFException e) {
            String message = e.getMessage();
            if (message == null || !StringsKt__StringsJVMKt.startsWith(message, "Unexpected end of stream after reading", false)) {
                throw e;
            }
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: readUTF8LineTo-RRvyBJ8$default, reason: not valid java name */
    public static /* synthetic */ Object m1838readUTF8LineToRRvyBJ8$default(ByteReadChannel byteReadChannel, Appendable appendable, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i3 & 4) != 0) {
            i2 = LineEndingMode.INSTANCE.m1850getAnyf0jXZW8();
        }
        return m1837readUTF8LineToRRvyBJ8(byteReadChannel, appendable, i, i2, continuation);
    }

    public static final Object readUntil(ByteReadChannel byteReadChannel, ByteString byteString, ByteWriteChannel byteWriteChannel, long j, boolean z, Continuation continuation) {
        return new ByteChannelScanner(byteReadChannel, byteString, byteWriteChannel, j).findNext$ktor_io(z, continuation);
    }

    public static /* synthetic */ Object readUntil$default(ByteReadChannel byteReadChannel, ByteString byteString, ByteWriteChannel byteWriteChannel, long j, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            j = Long.MAX_VALUE;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            z = false;
        }
        return readUntil(byteReadChannel, byteString, byteWriteChannel, j2, z, continuation);
    }

    public static final ReaderJob reader(CoroutineScope coroutineScope, CoroutineContext coroutineContext, ByteChannel byteChannel, Function2 function2) {
        coroutineScope.getClass();
        coroutineContext.getClass();
        byteChannel.getClass();
        function2.getClass();
        StandaloneCoroutine standaloneCoroutineLaunch$default = AwaitKt.launch$default(coroutineScope, coroutineContext, null, new ByteReadChannelOperationsKt$reader$job$1(function2, byteChannel, null), 2);
        standaloneCoroutineLaunch$default.invokeOnCompletion(new ByteChannelUtilsKt$$ExternalSyntheticLambda1(byteChannel, (byte) 1));
        return new ReaderJob(CloseHookByteWriteChannelKt.onClose(byteChannel, new C03581(standaloneCoroutineLaunch$default, null)), standaloneCoroutineLaunch$default);
    }

    public static /* synthetic */ ReaderJob reader$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return reader(coroutineScope, coroutineContext, z, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reader$lambda$0$0(ByteChannel byteChannel, Throwable th) {
        if (th != null && !byteChannel.isClosedForRead()) {
            byteChannel.cancel(th);
        }
        return Unit.INSTANCE;
    }

    public static final void rethrowCloseCauseIfNeeded(ByteReadChannel byteReadChannel) {
        byteReadChannel.getClass();
        Throwable closedCause = byteReadChannel.getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
    
        if (discard(r6, r7, r0) == r5) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object skipIfFound(ByteReadChannel byteReadChannel, ByteString byteString, Continuation continuation) {
        C03591 c03591;
        if (continuation instanceof C03591) {
            c03591 = (C03591) continuation;
            int i = c03591.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03591.label = i - Integer.MIN_VALUE;
            } else {
                c03591 = new C03591(continuation);
            }
        } else {
            c03591 = new C03591(continuation);
        }
        Object objPeek = c03591.result;
        int i2 = c03591.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objPeek);
            int length = byteString.data.length;
            c03591.L$0 = byteReadChannel;
            c03591.L$1 = byteString;
            c03591.label = 1;
            objPeek = peek(byteReadChannel, length, c03591);
            if (objPeek != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            byteString = (ByteString) c03591.L$1;
            byteReadChannel = (ByteReadChannel) c03591.L$0;
            ResultKt.throwOnFailure(objPeek);
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objPeek);
        }
        return Boolean.TRUE;
        if (!Intrinsics.areEqual(objPeek, byteString)) {
            return Boolean.FALSE;
        }
        long length2 = byteString.data.length;
        c03591.L$0 = null;
        c03591.L$1 = null;
        c03591.label = 2;
    }

    private static final Void throwEndOfStreamException(long j) throws EOFException {
        throw new EOFException(IntIntPair$$ExternalSyntheticOutline0.m(j, "Unexpected end of stream after reading ", " bytes"));
    }

    private static final Void throwTooLongLineException(long j) throws TooLongLineException {
        throw new TooLongLineException(IntIntPair$$ExternalSyntheticOutline0.m(j, "Line exceeds limit of ", " bytes"));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object toByteArray(ByteReadChannel byteReadChannel, Continuation continuation) {
        C03601 c03601;
        if (continuation instanceof C03601) {
            c03601 = (C03601) continuation;
            int i = c03601.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03601.label = i - Integer.MIN_VALUE;
            } else {
                c03601 = new C03601(continuation);
            }
        } else {
            c03601 = new C03601(continuation);
        }
        Object buffer = c03601.result;
        int i2 = c03601.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(buffer);
            c03601.L$0 = null;
            c03601.label = 1;
            buffer = readBuffer(byteReadChannel, c03601);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (buffer == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(buffer);
        }
        return BuffersKt.readBytes$default((Buffer) buffer, 0, 1, null);
    }

    @Deprecated
    public static final Object readRemaining(ByteReadChannel byteReadChannel, long j, Continuation continuation) {
        return readBuffer(byteReadChannel, j, continuation);
    }

    public static final void rethrowCloseCauseIfNeeded(ByteWriteChannel byteWriteChannel) throws Throwable {
        byteWriteChannel.getClass();
        Throwable closedCause = byteWriteChannel.getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    public static final void rethrowCloseCauseIfNeeded(ByteChannel byteChannel) throws Throwable {
        byteChannel.getClass();
        Throwable closedCause = byteChannel.getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    public static final ReaderJob reader(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z, Function2 function2) {
        coroutineScope.getClass();
        coroutineContext.getClass();
        function2.getClass();
        return reader(coroutineScope, coroutineContext, new ByteChannel(z), function2);
    }

    public static /* synthetic */ void getAvailableForRead$annotations(ByteReadChannel byteReadChannel) {
    }

    public static /* synthetic */ void getAvailableForWrite$annotations(ByteWriteChannel byteWriteChannel) {
    }

    public static final int readAvailable(ByteReadChannel byteReadChannel, int i, Function1 function1) {
        byteReadChannel.getClass();
        function1.getClass();
        if (i <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("min should be positive");
            return 0;
        }
        if (i <= 1048576) {
            if (getAvailableForRead(byteReadChannel) < i) {
                return -1;
            }
            return ((Number) function1.invoke(byteReadChannel.getReadBuffer().getBuffer())).intValue();
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Min(", ") shouldn't be greater than 1048576"));
        return 0;
    }

    @Deprecated
    public static final Object readBuffer(ByteReadChannel byteReadChannel, int i, Continuation continuation) {
        return readBuffer(byteReadChannel, i, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0042  */
    /* JADX WARN: Code duplicated, block: B:19:0x004c  */
    /* JADX WARN: Code duplicated, block: B:21:0x005b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x005c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0068  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004a -> B:24:0x0060). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005c -> B:23:0x005e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:19:0x004c
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object readBuffer(io.ktor.utils.io.ByteReadChannel r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C03431
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C03431) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            int r1 = r0.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L34
            if (r1 != r3) goto L2e
            java.lang.Object r5 = r0.L$1
            kotlinx.io.Buffer r5 = (kotlinx.io.Buffer) r5
            java.lang.Object r1 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r1 = (io.ktor.utils.io.ByteReadChannel) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5e
        L2e:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r5)
            return r2
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.io.Buffer r6 = new kotlinx.io.Buffer
            r6.<init>()
        L3c:
            boolean r1 = r5.isClosedForRead()
            if (r1 != 0) goto L68
            kotlinx.io.Source r1 = r5.getReadBuffer()
            boolean r1 = r1.exhausted()
            if (r1 == 0) goto L60
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            r1 = 0
            java.lang.Object r1 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r5, r1, r0, r3, r2)
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 != r4) goto L5c
            return r4
        L5c:
            r1 = r5
            r5 = r6
        L5e:
            r6 = r5
            r5 = r1
        L60:
            kotlinx.io.Source r1 = r5.getReadBuffer()
            r6.transferFrom(r1)
            goto L3c
        L68:
            rethrowCloseCauseIfNeeded(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readBuffer(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0089 A[Catch: all -> 0x00b9, TRY_LEAVE, TryCatch #1 {all -> 0x00b9, blocks: (B:27:0x0083, B:29:0x0089), top: B:54:0x0083 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:38:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b6, code lost:
    
        if (io.ktor.utils.io.ByteReadChannel.awaitContent$default(r11, 0, r1, 1, null) == r8) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00b6 -> B:20:0x0062). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object copyTo(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, Continuation continuation) throws Throwable {
        C03351 c03351;
        ByteReadChannel byteReadChannel2;
        long j;
        long jTransferTo;
        C03351 c03352;
        ByteReadChannel byteReadChannel3;
        long j2;
        ?? r2;
        if (continuation instanceof C03351) {
            c03351 = (C03351) continuation;
            int i = c03351.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03351.label = i - Integer.MIN_VALUE;
            } else {
                c03351 = new C03351(continuation);
            }
        } else {
            c03351 = new C03351(continuation);
        }
        Object obj = c03351.result;
        ?? r3 = c03351.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (r3 == 0) {
                ResultKt.throwOnFailure(obj);
                r3 = byteWriteChannel;
                jTransferTo = 0;
                c03352 = c03351;
                byteReadChannel3 = byteReadChannel;
                if (!byteReadChannel3.isClosedForRead()) {
                    jTransferTo += byteReadChannel3.getReadBuffer().transferTo(r3.getWriteBuffer());
                    c03352.L$0 = byteReadChannel3;
                    c03352.L$1 = r3;
                    c03352.J$0 = jTransferTo;
                    c03352.label = 1;
                    if (r3.flush(c03352) != coroutineSingletons) {
                        byteReadChannel2 = byteReadChannel3;
                        c03351 = c03352;
                        j = jTransferTo;
                        r3 = r3;
                        c03351.L$0 = byteReadChannel2;
                        c03351.L$1 = r3;
                        c03351.J$0 = j;
                        c03351.label = 2;
                        r2 = r3;
                    }
                } else {
                    c03352.L$0 = null;
                    c03352.L$1 = null;
                    c03352.J$0 = jTransferTo;
                    c03352.label = 3;
                    if (r3.flush(c03352) != coroutineSingletons) {
                        j2 = jTransferTo;
                    }
                }
                return coroutineSingletons;
            }
            if (r3 == 1) {
                j = c03351.J$0;
                ByteWriteChannel byteWriteChannel2 = (ByteWriteChannel) c03351.L$1;
                byteReadChannel2 = (ByteReadChannel) c03351.L$0;
                ResultKt.throwOnFailure(obj);
                r3 = byteWriteChannel2;
                c03351.L$0 = byteReadChannel2;
                c03351.L$1 = r3;
                c03351.J$0 = j;
                c03351.label = 2;
                r2 = r3;
            } else if (r3 == 2) {
                j = c03351.J$0;
                ByteWriteChannel byteWriteChannel3 = (ByteWriteChannel) c03351.L$1;
                byteReadChannel2 = (ByteReadChannel) c03351.L$0;
                ResultKt.throwOnFailure(obj);
                r2 = byteWriteChannel3;
                try {
                    long j3 = j;
                    c03352 = c03351;
                    byteReadChannel3 = byteReadChannel2;
                    jTransferTo = j3;
                    r3 = r2;
                    if (!byteReadChannel3.isClosedForRead()) {
                        jTransferTo += byteReadChannel3.getReadBuffer().transferTo(r3.getWriteBuffer());
                        c03352.L$0 = byteReadChannel3;
                        c03352.L$1 = r3;
                        c03352.J$0 = jTransferTo;
                        c03352.label = 1;
                        if (r3.flush(c03352) != coroutineSingletons) {
                            byteReadChannel2 = byteReadChannel3;
                            c03351 = c03352;
                            j = jTransferTo;
                            r3 = r3;
                            c03351.L$0 = byteReadChannel2;
                            c03351.L$1 = r3;
                            c03351.J$0 = j;
                            c03351.label = 2;
                            r2 = r3;
                        }
                    } else {
                        c03352.L$0 = null;
                        c03352.L$1 = null;
                        c03352.J$0 = jTransferTo;
                        c03352.label = 3;
                        if (r3.flush(c03352) != coroutineSingletons) {
                            j2 = jTransferTo;
                        }
                    }
                    return coroutineSingletons;
                } catch (Throwable th) {
                    th = th;
                    byteReadChannel2 = byteReadChannel3;
                    c03351 = c03352;
                    j = jTransferTo;
                    try {
                        byteReadChannel2.cancel(th);
                        ByteWriteChannelOperationsKt.close(r3, th);
                        throw th;
                    } catch (Throwable th2) {
                        c03351.L$0 = null;
                        c03351.L$1 = null;
                        c03351.L$2 = th2;
                        c03351.J$0 = j;
                        c03351.label = 4;
                        if (r3.flush(c03351) != coroutineSingletons) {
                            throw th2;
                        }
                    }
                }
            } else {
                if (r3 != 3) {
                    if (r3 != 4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Throwable th3 = (Throwable) c03351.L$2;
                    ResultKt.throwOnFailure(obj);
                    throw th3;
                }
                j2 = c03351.J$0;
                ResultKt.throwOnFailure(obj);
            }
            return new Long(j2);
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
