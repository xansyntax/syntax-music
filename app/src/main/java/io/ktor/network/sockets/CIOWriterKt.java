package io.ktor.network.sockets;

import io.ktor.network.selector.Selectable;
import io.ktor.network.selector.SelectorManager;
import io.ktor.network.util.Timeout;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ReaderJob;
import io.ktor.utils.io.ReaderScope;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a?\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lio/ktor/utils/io/ByteChannel;", "channel", "Ljava/nio/channels/WritableByteChannel;", "nioChannel", "Lio/ktor/network/selector/Selectable;", "selectable", "Lio/ktor/network/selector/SelectorManager;", "selector", "Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "socketOptions", "Lio/ktor/utils/io/ReaderJob;", "attachForWritingDirectImpl", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteChannel;Ljava/nio/channels/WritableByteChannel;Lio/ktor/network/selector/Selectable;Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;)Lio/ktor/utils/io/ReaderJob;", "ktor-network"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CIOWriterKt {

    /* JADX INFO: renamed from: io.ktor.network.sockets.CIOWriterKt$attachForWritingDirectImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/ReaderScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.CIOWriterKt$attachForWritingDirectImpl$1", f = "CIOWriter.kt", l = {33, 74, 78, 50}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ ByteChannel $channel;
        final /* synthetic */ WritableByteChannel $nioChannel;
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
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Selectable selectable, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, ByteChannel byteChannel, SelectorManager selectorManager, WritableByteChannel writableByteChannel, Continuation continuation) {
            super(2, continuation);
            this.$selectable = selectable;
            this.$socketOptions = tCPClientSocketOptions;
            this.$channel = byteChannel;
            this.$selector = selectorManager;
            this.$nioChannel = writableByteChannel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(Timeout timeout, Ref$IntRef ref$IntRef, WritableByteChannel writableByteChannel, ByteBuffer byteBuffer) {
            while (byteBuffer.hasRemaining()) {
                if (timeout == null) {
                    do {
                        ref$IntRef.element = writableByteChannel.write(byteBuffer);
                        if (!byteBuffer.hasRemaining()) {
                            break;
                        }
                    } while (ref$IntRef.element > 0);
                } else {
                    timeout.start();
                    do {
                        try {
                            ref$IntRef.element = writableByteChannel.write(byteBuffer);
                            if (!byteBuffer.hasRemaining()) {
                                break;
                            }
                        } catch (Throwable th) {
                            timeout.stop();
                            throw th;
                        }
                    } while (ref$IntRef.element > 0);
                    timeout.stop();
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$selectable, this.$socketOptions, this.$channel, this.$selector, this.$nioChannel, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ReaderScope readerScope, Continuation continuation) {
            return ((AnonymousClass1) create(readerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:36:0x00b6 A[Catch: all -> 0x0028, TryCatch #1 {all -> 0x0028, blocks: (B:10:0x0023, B:34:0x00ae, B:36:0x00b6, B:38:0x00be, B:41:0x00d3, B:45:0x00fb, B:47:0x0103, B:48:0x010c, B:50:0x0110, B:53:0x012e, B:54:0x0155, B:56:0x0158, B:17:0x0041, B:19:0x004e, B:22:0x006a, B:26:0x0083, B:28:0x0087, B:31:0x0094), top: B:79:0x0010 }] */
        /* JADX WARN: Code duplicated, block: B:38:0x00be A[Catch: all -> 0x0028, TryCatch #1 {all -> 0x0028, blocks: (B:10:0x0023, B:34:0x00ae, B:36:0x00b6, B:38:0x00be, B:41:0x00d3, B:45:0x00fb, B:47:0x0103, B:48:0x010c, B:50:0x0110, B:53:0x012e, B:54:0x0155, B:56:0x0158, B:17:0x0041, B:19:0x004e, B:22:0x006a, B:26:0x0083, B:28:0x0087, B:31:0x0094), top: B:79:0x0010 }] */
        /* JADX WARN: Code duplicated, block: B:43:0x00f7 A[EDGE_INSN: B:43:0x00f7->B:52:0x012d BREAK  A[LOOP:0: B:34:0x00ae->B:87:?]] */
        /* JADX WARN: Code duplicated, block: B:44:0x00f8  */
        /* JADX WARN: Code duplicated, block: B:47:0x0103 A[Catch: all -> 0x0028, TryCatch #1 {all -> 0x0028, blocks: (B:10:0x0023, B:34:0x00ae, B:36:0x00b6, B:38:0x00be, B:41:0x00d3, B:45:0x00fb, B:47:0x0103, B:48:0x010c, B:50:0x0110, B:53:0x012e, B:54:0x0155, B:56:0x0158, B:17:0x0041, B:19:0x004e, B:22:0x006a, B:26:0x0083, B:28:0x0087, B:31:0x0094), top: B:79:0x0010 }] */
        /* JADX WARN: Code duplicated, block: B:50:0x0110 A[Catch: all -> 0x0028, TryCatch #1 {all -> 0x0028, blocks: (B:10:0x0023, B:34:0x00ae, B:36:0x00b6, B:38:0x00be, B:41:0x00d3, B:45:0x00fb, B:47:0x0103, B:48:0x010c, B:50:0x0110, B:53:0x012e, B:54:0x0155, B:56:0x0158, B:17:0x0041, B:19:0x004e, B:22:0x006a, B:26:0x0083, B:28:0x0087, B:31:0x0094), top: B:79:0x0010 }] */
        /* JADX WARN: Code duplicated, block: B:56:0x0158 A[Catch: all -> 0x0028, TRY_LEAVE, TryCatch #1 {all -> 0x0028, blocks: (B:10:0x0023, B:34:0x00ae, B:36:0x00b6, B:38:0x00be, B:41:0x00d3, B:45:0x00fb, B:47:0x0103, B:48:0x010c, B:50:0x0110, B:53:0x012e, B:54:0x0155, B:56:0x0158, B:17:0x0041, B:19:0x004e, B:22:0x006a, B:26:0x0083, B:28:0x0087, B:31:0x0094), top: B:79:0x0010 }] */
        /* JADX WARN: Code duplicated, block: B:62:0x0170 A[Catch: ClosedChannelException -> 0x017f, TRY_ENTER, TryCatch #2 {ClosedChannelException -> 0x017f, blocks: (B:59:0x0168, B:62:0x0170, B:63:0x0176), top: B:81:0x0168 }] */
        /* JADX WARN: Code duplicated, block: B:63:0x0176 A[Catch: ClosedChannelException -> 0x017f, TRY_LEAVE, TryCatch #2 {ClosedChannelException -> 0x017f, blocks: (B:59:0x0168, B:62:0x0170, B:63:0x0176), top: B:81:0x0168 }] */
        /* JADX WARN: Code duplicated, block: B:81:0x0168 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:83:0x0156 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:84:0x00d3 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:86:? A[PHI: r5
          PHI (r5v4 io.ktor.network.util.Timeout) = (r5v0 io.ktor.network.util.Timeout), (r5v0 io.ktor.network.util.Timeout), (r5v6 io.ktor.network.util.Timeout) binds: [B:49:0x010e, B:51:0x012b, B:33:0x00ad] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x010e -> B:34:0x00ae). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x012b -> B:34:0x00ae). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instruction units count: 423
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.CIOWriterKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final ReaderJob attachForWritingDirectImpl(CoroutineScope coroutineScope, ByteChannel byteChannel, WritableByteChannel writableByteChannel, Selectable selectable, SelectorManager selectorManager, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions) {
        coroutineScope.getClass();
        byteChannel.getClass();
        writableByteChannel.getClass();
        selectable.getClass();
        selectorManager.getClass();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return ByteReadChannelOperationsKt.reader(coroutineScope, DefaultIoScheduler.INSTANCE.plus(new CoroutineName("cio-to-nio-writer")), byteChannel, new AnonymousClass1(selectable, tCPClientSocketOptions, byteChannel, selectorManager, writableByteChannel, null));
    }

    public static /* synthetic */ ReaderJob attachForWritingDirectImpl$default(CoroutineScope coroutineScope, ByteChannel byteChannel, WritableByteChannel writableByteChannel, Selectable selectable, SelectorManager selectorManager, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, int i, Object obj) {
        if ((i & 16) != 0) {
            tCPClientSocketOptions = null;
        }
        return attachForWritingDirectImpl(coroutineScope, byteChannel, writableByteChannel, selectable, selectorManager, tCPClientSocketOptions);
    }
}
