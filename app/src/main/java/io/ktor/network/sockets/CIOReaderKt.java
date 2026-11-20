package io.ktor.network.sockets;

import com.yalantis.ucrop.UCrop;
import io.ktor.network.selector.SelectInterest;
import io.ktor.network.selector.Selectable;
import io.ktor.network.selector.SelectorManager;
import io.ktor.util.cio.FileChannelsKt$$ExternalSyntheticLambda1;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannelOperations_jvmKt;
import io.ktor.utils.io.WriterJob;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aM\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a?\u0010\u0011\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001c\u0010\u0015\u001a\u00020\u0014*\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016\u001a \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lio/ktor/utils/io/ByteChannel;", "channel", "Ljava/nio/channels/ReadableByteChannel;", "nioChannel", "Lio/ktor/network/selector/Selectable;", "selectable", "Lio/ktor/network/selector/SelectorManager;", "selector", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "pool", "Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "socketOptions", "Lio/ktor/utils/io/WriterJob;", "attachForReadingImpl", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteChannel;Ljava/nio/channels/ReadableByteChannel;Lio/ktor/network/selector/Selectable;Lio/ktor/network/selector/SelectorManager;Lio/ktor/utils/io/pool/ObjectPool;Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;)Lio/ktor/utils/io/WriterJob;", "attachForReadingDirectImpl", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteChannel;Ljava/nio/channels/ReadableByteChannel;Lio/ktor/network/selector/Selectable;Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;)Lio/ktor/utils/io/WriterJob;", "Lio/ktor/utils/io/ByteWriteChannel;", "", "readFrom", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/channels/ReadableByteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "selectForRead", "(Lio/ktor/network/selector/Selectable;Lio/ktor/network/selector/SelectorManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-network"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CIOReaderKt {

    /* JADX INFO: renamed from: io.ktor.network.sockets.CIOReaderKt$attachForReadingDirectImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.CIOReaderKt$attachForReadingDirectImpl$1", f = "CIOReader.kt", l = {UCrop.RESULT_ERROR, 105, 108, 109, UCrop.RESULT_ERROR, 105, 108, 109}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ ByteChannel $channel;
        final /* synthetic */ ReadableByteChannel $nioChannel;
        final /* synthetic */ Selectable $selectable;
        final /* synthetic */ SelectorManager $selector;
        final /* synthetic */ SocketOptions.TCPClientSocketOptions $socketOptions;
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
        public AnonymousClass1(Selectable selectable, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, ByteChannel byteChannel, ReadableByteChannel readableByteChannel, SelectorManager selectorManager, Continuation continuation) {
            super(2, continuation);
            this.$selectable = selectable;
            this.$socketOptions = tCPClientSocketOptions;
            this.$channel = byteChannel;
            this.$nioChannel = readableByteChannel;
            this.$selector = selectorManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$selectable, this.$socketOptions, this.$channel, this.$nioChannel, this.$selector, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:58:0x01d7 A[Catch: all -> 0x00ce, PHI: r0 r1 r2 r3 r4 r5 r6 r7
          0x01d7: PHI (r0v18 int) = (r0v9 int), (r0v16 int), (r0v19 int) binds: [B:29:0x0113, B:65:0x021b, B:56:0x01d3] A[DONT_GENERATE, DONT_INLINE]
          0x01d7: PHI (r1v14 int) = (r1v4 int), (r1v12 int), (r1v15 int) binds: [B:29:0x0113, B:65:0x021b, B:56:0x01d3] A[DONT_GENERATE, DONT_INLINE]
          0x01d7: PHI (r2v16 int) = (r2v5 int), (r2v14 int), (r2v17 int) binds: [B:29:0x0113, B:65:0x021b, B:56:0x01d3] A[DONT_GENERATE, DONT_INLINE]
          0x01d7: PHI (r3v20 io.ktor.network.selector.SelectorManager) = 
          (r3v5 io.ktor.network.selector.SelectorManager)
          (r3v18 io.ktor.network.selector.SelectorManager)
          (r3v21 io.ktor.network.selector.SelectorManager)
         binds: [B:29:0x0113, B:65:0x021b, B:56:0x01d3] A[DONT_GENERATE, DONT_INLINE]
          0x01d7: PHI (r4v19 io.ktor.network.selector.Selectable) = 
          (r4v4 io.ktor.network.selector.Selectable)
          (r4v17 io.ktor.network.selector.Selectable)
          (r4v20 io.ktor.network.selector.Selectable)
         binds: [B:29:0x0113, B:65:0x021b, B:56:0x01d3] A[DONT_GENERATE, DONT_INLINE]
          0x01d7: PHI (r5v20 java.nio.channels.ReadableByteChannel) = 
          (r5v5 java.nio.channels.ReadableByteChannel)
          (r5v18 java.nio.channels.ReadableByteChannel)
          (r5v21 java.nio.channels.ReadableByteChannel)
         binds: [B:29:0x0113, B:65:0x021b, B:56:0x01d3] A[DONT_GENERATE, DONT_INLINE]
          0x01d7: PHI (r6v23 io.ktor.utils.io.ByteChannel) = (r6v7 io.ktor.utils.io.ByteChannel), (r6v21 io.ktor.utils.io.ByteChannel), (r6v24 io.ktor.utils.io.ByteChannel) binds: [B:29:0x0113, B:65:0x021b, B:56:0x01d3] A[DONT_GENERATE, DONT_INLINE]
          0x01d7: PHI (r7v25 io.ktor.network.util.Timeout) = (r7v7 io.ktor.network.util.Timeout), (r7v23 io.ktor.network.util.Timeout), (r7v26 io.ktor.network.util.Timeout) binds: [B:29:0x0113, B:65:0x021b, B:56:0x01d3] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {all -> 0x00ce, blocks: (B:87:0x02b8, B:43:0x0174, B:45:0x017c, B:47:0x0186, B:51:0x01aa, B:53:0x01b2, B:55:0x01b8, B:58:0x01d7, B:61:0x01f6, B:64:0x0215, B:67:0x021f, B:91:0x02c4, B:92:0x02c7, B:94:0x02cf, B:104:0x02f4, B:88:0x02be, B:89:0x02c1, B:21:0x00c9, B:26:0x00f0, B:29:0x0113, B:32:0x0134, B:35:0x0143, B:37:0x014e, B:40:0x015b, B:7:0x0033, B:85:0x02b0, B:79:0x0273, B:82:0x0291, B:68:0x0222, B:72:0x0247, B:74:0x024f, B:76:0x0255, B:12:0x005a, B:15:0x007d, B:18:0x009f), top: B:115:0x000c, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:60:0x01f4  */
        /* JADX WARN: Code duplicated, block: B:61:0x01f6 A[Catch: all -> 0x00ce, PHI: r0 r1 r2 r3 r4 r5 r6 r7
          0x01f6: PHI (r0v17 int) = (r0v10 int), (r0v18 int) binds: [B:26:0x00f0, B:59:0x01f2] A[DONT_GENERATE, DONT_INLINE]
          0x01f6: PHI (r1v13 int) = (r1v5 int), (r1v14 int) binds: [B:26:0x00f0, B:59:0x01f2] A[DONT_GENERATE, DONT_INLINE]
          0x01f6: PHI (r2v15 int) = (r2v6 int), (r2v16 int) binds: [B:26:0x00f0, B:59:0x01f2] A[DONT_GENERATE, DONT_INLINE]
          0x01f6: PHI (r3v19 io.ktor.network.selector.SelectorManager) = (r3v7 io.ktor.network.selector.SelectorManager), (r3v20 io.ktor.network.selector.SelectorManager) binds: [B:26:0x00f0, B:59:0x01f2] A[DONT_GENERATE, DONT_INLINE]
          0x01f6: PHI (r4v18 io.ktor.network.selector.Selectable) = (r4v6 io.ktor.network.selector.Selectable), (r4v19 io.ktor.network.selector.Selectable) binds: [B:26:0x00f0, B:59:0x01f2] A[DONT_GENERATE, DONT_INLINE]
          0x01f6: PHI (r5v19 java.nio.channels.ReadableByteChannel) = (r5v7 java.nio.channels.ReadableByteChannel), (r5v20 java.nio.channels.ReadableByteChannel) binds: [B:26:0x00f0, B:59:0x01f2] A[DONT_GENERATE, DONT_INLINE]
          0x01f6: PHI (r6v22 io.ktor.utils.io.ByteChannel) = (r6v9 io.ktor.utils.io.ByteChannel), (r6v23 io.ktor.utils.io.ByteChannel) binds: [B:26:0x00f0, B:59:0x01f2] A[DONT_GENERATE, DONT_INLINE]
          0x01f6: PHI (r7v24 io.ktor.network.util.Timeout) = (r7v11 io.ktor.network.util.Timeout), (r7v25 io.ktor.network.util.Timeout) binds: [B:26:0x00f0, B:59:0x01f2] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {all -> 0x00ce, blocks: (B:87:0x02b8, B:43:0x0174, B:45:0x017c, B:47:0x0186, B:51:0x01aa, B:53:0x01b2, B:55:0x01b8, B:58:0x01d7, B:61:0x01f6, B:64:0x0215, B:67:0x021f, B:91:0x02c4, B:92:0x02c7, B:94:0x02cf, B:104:0x02f4, B:88:0x02be, B:89:0x02c1, B:21:0x00c9, B:26:0x00f0, B:29:0x0113, B:32:0x0134, B:35:0x0143, B:37:0x014e, B:40:0x015b, B:7:0x0033, B:85:0x02b0, B:79:0x0273, B:82:0x0291, B:68:0x0222, B:72:0x0247, B:74:0x024f, B:76:0x0255, B:12:0x005a, B:15:0x007d, B:18:0x009f), top: B:115:0x000c, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:63:0x0213  */
        /* JADX WARN: Code duplicated, block: B:64:0x0215 A[Catch: all -> 0x00ce, PHI: r0 r1 r2 r3 r4 r5 r6 r7 r14
          0x0215: PHI (r0v16 int) = (r0v11 int), (r0v17 int) binds: [B:21:0x00c9, B:62:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r1v12 int) = (r1v6 int), (r1v13 int) binds: [B:21:0x00c9, B:62:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r2v14 int) = (r2v7 int), (r2v15 int) binds: [B:21:0x00c9, B:62:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r3v18 io.ktor.network.selector.SelectorManager) = (r3v9 io.ktor.network.selector.SelectorManager), (r3v19 io.ktor.network.selector.SelectorManager) binds: [B:21:0x00c9, B:62:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r4v17 io.ktor.network.selector.Selectable) = (r4v8 io.ktor.network.selector.Selectable), (r4v18 io.ktor.network.selector.Selectable) binds: [B:21:0x00c9, B:62:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r5v18 java.nio.channels.ReadableByteChannel) = (r5v9 java.nio.channels.ReadableByteChannel), (r5v19 java.nio.channels.ReadableByteChannel) binds: [B:21:0x00c9, B:62:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r6v21 io.ktor.utils.io.ByteChannel) = (r6v11 io.ktor.utils.io.ByteChannel), (r6v22 io.ktor.utils.io.ByteChannel) binds: [B:21:0x00c9, B:62:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r7v23 io.ktor.network.util.Timeout) = (r7v15 io.ktor.network.util.Timeout), (r7v24 io.ktor.network.util.Timeout) binds: [B:21:0x00c9, B:62:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r14v17 java.lang.Object) = (r14v0 java.lang.Object), (r14v21 java.lang.Object) binds: [B:21:0x00c9, B:62:0x0211] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {all -> 0x00ce, blocks: (B:87:0x02b8, B:43:0x0174, B:45:0x017c, B:47:0x0186, B:51:0x01aa, B:53:0x01b2, B:55:0x01b8, B:58:0x01d7, B:61:0x01f6, B:64:0x0215, B:67:0x021f, B:91:0x02c4, B:92:0x02c7, B:94:0x02cf, B:104:0x02f4, B:88:0x02be, B:89:0x02c1, B:21:0x00c9, B:26:0x00f0, B:29:0x0113, B:32:0x0134, B:35:0x0143, B:37:0x014e, B:40:0x015b, B:7:0x0033, B:85:0x02b0, B:79:0x0273, B:82:0x0291, B:68:0x0222, B:72:0x0247, B:74:0x024f, B:76:0x0255, B:12:0x005a, B:15:0x007d, B:18:0x009f), top: B:115:0x000c, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:66:0x021d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x01b2 -> B:43:0x0174). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x01b6 -> B:43:0x0174). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x021b -> B:58:0x01d7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x021d -> B:43:0x0174). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x024f -> B:87:0x02b8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0253 -> B:87:0x02b8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x02ad -> B:85:0x02b0). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 810
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.CIOReaderKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: io.ktor.network.sockets.CIOReaderKt$attachForReadingImpl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.CIOReaderKt$attachForReadingImpl$1", f = "CIOReader.kt", l = {42, 44, 42, 44, 55}, m = "invokeSuspend", v = 1)
    public static final class C03181 extends SuspendLambda implements Function2 {
        final /* synthetic */ ByteBuffer $buffer;
        final /* synthetic */ ByteChannel $channel;
        final /* synthetic */ ReadableByteChannel $nioChannel;
        final /* synthetic */ ObjectPool<ByteBuffer> $pool;
        final /* synthetic */ Selectable $selectable;
        final /* synthetic */ SelectorManager $selector;
        final /* synthetic */ SocketOptions.TCPClientSocketOptions $socketOptions;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03181(SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, ByteChannel byteChannel, Selectable selectable, ByteBuffer byteBuffer, ObjectPool<ByteBuffer> objectPool, ReadableByteChannel readableByteChannel, SelectorManager selectorManager, Continuation continuation) {
            super(2, continuation);
            this.$socketOptions = tCPClientSocketOptions;
            this.$channel = byteChannel;
            this.$selectable = selectable;
            this.$buffer = byteBuffer;
            this.$pool = objectPool;
            this.$nioChannel = readableByteChannel;
            this.$selector = selectorManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C03181 c03181 = new C03181(this.$socketOptions, this.$channel, this.$selectable, this.$buffer, this.$pool, this.$nioChannel, this.$selector, continuation);
            c03181.L$0 = obj;
            return c03181;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation continuation) {
            return ((C03181) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:58:0x01cc A[Catch: all -> 0x023b, TRY_LEAVE, TryCatch #4 {all -> 0x023b, blocks: (B:56:0x01c4, B:58:0x01cc, B:71:0x0240), top: B:112:0x01c4 }] */
        /* JADX WARN: Code duplicated, block: B:61:0x01ec  */
        /* JADX WARN: Code duplicated, block: B:70:0x023f  */
        /* JADX WARN: Code duplicated, block: B:73:0x0244 A[Catch: all -> 0x0031, TRY_ENTER, TryCatch #0 {all -> 0x0031, blocks: (B:10:0x0025, B:91:0x02aa, B:38:0x0135, B:41:0x0148, B:43:0x0150, B:47:0x0181, B:51:0x01b7, B:74:0x0247, B:76:0x024c, B:78:0x0253, B:88:0x027d, B:54:0x01be, B:73:0x0244, B:93:0x02b8, B:94:0x02bb, B:25:0x00c3, B:28:0x00f4, B:31:0x0104, B:33:0x0108, B:36:0x0115), top: B:105:0x0011 }] */
        /* JADX WARN: Code duplicated, block: B:92:0x02b3  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0 */
        /* JADX WARN: Type inference failed for: r10v7 */
        /* JADX WARN: Type inference failed for: r10v9 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x014e -> B:51:0x01b7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x01a2 -> B:50:0x01a6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0244 -> B:74:0x0247). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:92:0x02b3 -> B:112:0x01c4). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instruction units count: 737
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.CIOReaderKt.C03181.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: io.ktor.network.sockets.CIOReaderKt$readFrom$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.CIOReaderKt", f = "CIOReader.kt", l = {133}, m = "readFrom", v = 1)
    public static final class C03191 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03191(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOReaderKt.readFrom(null, null, this);
        }
    }

    public static final WriterJob attachForReadingDirectImpl(CoroutineScope coroutineScope, ByteChannel byteChannel, ReadableByteChannel readableByteChannel, Selectable selectable, SelectorManager selectorManager, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions) {
        coroutineScope.getClass();
        byteChannel.getClass();
        readableByteChannel.getClass();
        selectable.getClass();
        selectorManager.getClass();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return ByteWriteChannelOperationsKt.writer(coroutineScope, DefaultIoScheduler.INSTANCE.plus(new CoroutineName("cio-from-nio-reader")), byteChannel, new AnonymousClass1(selectable, tCPClientSocketOptions, byteChannel, readableByteChannel, selectorManager, null));
    }

    public static /* synthetic */ WriterJob attachForReadingDirectImpl$default(CoroutineScope coroutineScope, ByteChannel byteChannel, ReadableByteChannel readableByteChannel, Selectable selectable, SelectorManager selectorManager, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, int i, Object obj) {
        if ((i & 16) != 0) {
            tCPClientSocketOptions = null;
        }
        return attachForReadingDirectImpl(coroutineScope, byteChannel, readableByteChannel, selectable, selectorManager, tCPClientSocketOptions);
    }

    public static final WriterJob attachForReadingImpl(CoroutineScope coroutineScope, ByteChannel byteChannel, ReadableByteChannel readableByteChannel, Selectable selectable, SelectorManager selectorManager, ObjectPool<ByteBuffer> objectPool, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions) {
        coroutineScope.getClass();
        byteChannel.getClass();
        readableByteChannel.getClass();
        selectable.getClass();
        selectorManager.getClass();
        objectPool.getClass();
        ByteBuffer byteBufferBorrow = objectPool.borrow();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return ByteWriteChannelOperationsKt.writer(coroutineScope, DefaultIoScheduler.INSTANCE.plus(new CoroutineName("cio-from-nio-reader")), byteChannel, new C03181(tCPClientSocketOptions, byteChannel, selectable, byteBufferBorrow, objectPool, readableByteChannel, selectorManager, null));
    }

    public static /* synthetic */ WriterJob attachForReadingImpl$default(CoroutineScope coroutineScope, ByteChannel byteChannel, ReadableByteChannel readableByteChannel, Selectable selectable, SelectorManager selectorManager, ObjectPool objectPool, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, int i, Object obj) {
        if ((i & 32) != 0) {
            tCPClientSocketOptions = null;
        }
        return attachForReadingImpl(coroutineScope, byteChannel, readableByteChannel, selectable, selectorManager, objectPool, tCPClientSocketOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static final Object readFrom(ByteWriteChannel byteWriteChannel, ReadableByteChannel readableByteChannel, Continuation continuation) {
        C03191 c03191;
        Ref$IntRef ref$IntRef;
        if (continuation instanceof C03191) {
            c03191 = (C03191) continuation;
            int i = c03191.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03191.label = i - Integer.MIN_VALUE;
            } else {
                c03191 = new C03191(continuation);
            }
        } else {
            c03191 = new C03191(continuation);
        }
        C03191 c03192 = c03191;
        Object obj = c03192.result;
        int i2 = c03192.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref$IntRef ref$IntRef2 = new Ref$IntRef();
            FileChannelsKt$$ExternalSyntheticLambda1 fileChannelsKt$$ExternalSyntheticLambda1 = new FileChannelsKt$$ExternalSyntheticLambda1(ref$IntRef2, readableByteChannel, (byte) 8);
            c03192.L$0 = null;
            c03192.L$1 = null;
            c03192.L$2 = ref$IntRef2;
            c03192.label = 1;
            Object objWrite$default = ByteWriteChannelOperations_jvmKt.write$default(byteWriteChannel, 0, fileChannelsKt$$ExternalSyntheticLambda1, c03192, 1, null);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWrite$default == coroutineSingletons) {
                return coroutineSingletons;
            }
            ref$IntRef = ref$IntRef2;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ref$IntRef = (Ref$IntRef) c03192.L$2;
            ResultKt.throwOnFailure(obj);
        }
        return new Integer(ref$IntRef.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit readFrom$lambda$0(Ref$IntRef ref$IntRef, ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        ref$IntRef.element = readableByteChannel.read(byteBuffer);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object selectForRead(Selectable selectable, SelectorManager selectorManager, Continuation continuation) {
        SelectInterest selectInterest = SelectInterest.READ;
        selectable.interestOp(selectInterest, true);
        Object objSelect = selectorManager.select(selectable, selectInterest, continuation);
        return objSelect == CoroutineSingletons.COROUTINE_SUSPENDED ? objSelect : Unit.INSTANCE;
    }
}
