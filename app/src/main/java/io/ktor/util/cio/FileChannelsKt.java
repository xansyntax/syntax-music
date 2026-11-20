package io.ktor.util.cio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteReadChannelOperations_jvmKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ReaderScope;
import io.ktor.utils.io.WriterJob;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.CharsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a,\u0010\r\u001a\u00020\f*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\r\u0010\u000e\u001a\u001b\u0010\u0010\u001a\u00020\u000f*\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ljava/io/File;", "", "start", "endInclusive", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/utils/io/ByteReadChannel;", "readChannel", "(Ljava/io/File;JJLkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteReadChannel;", "Ljava/nio/channels/SeekableByteChannel;", "Lio/ktor/utils/io/WriterScope;", "writerScope", "", "writeToScope", "(Ljava/nio/channels/SeekableByteChannel;Lio/ktor/utils/io/WriterScope;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "writeChannel", "(Ljava/io/File;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteWriteChannel;", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class FileChannelsKt {

    /* JADX INFO: renamed from: io.ktor.util.cio.FileChannelsKt$writeChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/ReaderScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt$writeChannel$1", f = "FileChannels.kt", l = {111}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ File $this_writeChannel;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(File file, Continuation continuation) {
            super(2, continuation);
            this.$this_writeChannel = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_writeChannel, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ReaderScope readerScope, Continuation continuation) {
            return ((AnonymousClass1) create(readerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Throwable th;
            Closeable closeable;
            RandomAccessFile randomAccessFile;
            ReaderScope readerScope = (ReaderScope) this.L$0;
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.$this_writeChannel, "rw");
                try {
                    ByteReadChannel channel = readerScope.getChannel();
                    FileChannel channel2 = randomAccessFile2.getChannel();
                    channel2.getClass();
                    this.L$0 = null;
                    this.L$1 = randomAccessFile2;
                    this.L$2 = randomAccessFile2;
                    this.I$0 = 0;
                    this.label = 1;
                    Object objCopyTo$default = ByteReadChannelOperations_jvmKt.copyTo$default(channel, channel2, 0L, this, 2, null);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objCopyTo$default == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    randomAccessFile = randomAccessFile2;
                    obj = objCopyTo$default;
                    closeable = randomAccessFile;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = randomAccessFile2;
                    throw th;
                }
            } else {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                randomAccessFile = (RandomAccessFile) this.L$2;
                closeable = (Closeable) this.L$1;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        CharsKt.closeFinally(closeable, th);
                        throw th4;
                    }
                }
            }
            randomAccessFile.setLength(((Number) obj).longValue());
            CharsKt.closeFinally(closeable, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: io.ktor.util.cio.FileChannelsKt$writeToScope$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt", f = "FileChannels.kt", l = {149, 185}, m = "writeToScope", v = 1)
    public static final class C03281 extends ContinuationImpl {
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C03281(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileChannelsKt.writeToScope(null, null, 0L, 0L, this);
        }
    }

    public static final ByteReadChannel readChannel(File file, long j, long j2, CoroutineContext coroutineContext) {
        file.getClass();
        coroutineContext.getClass();
        long length = file.length();
        byte b = 0;
        SynchronizedLazyImpl synchronizedLazyImpl = new SynchronizedLazyImpl(new FileChannelsKt$$ExternalSyntheticLambda0(file, b));
        WriterJob writerJobWriter = ByteWriteChannelOperationsKt.writer((CoroutineScope) AwaitKt.CoroutineScope(coroutineContext), new CoroutineName("file-reader").plus(coroutineContext), false, (Function2) new FileChannelsKt$readChannel$writer$1(j, j2, length, synchronizedLazyImpl, null));
        ByteWriteChannelOperationsKt.invokeOnCompletion(writerJobWriter, new FileChannelsKt$$ExternalSyntheticLambda1(synchronizedLazyImpl, file, b));
        return writerJobWriter.getChannel();
    }

    public static ByteReadChannel readChannel$default(File file, long j, long j2, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = -1;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            coroutineContext = DefaultIoScheduler.INSTANCE;
        }
        return readChannel(file, j3, j4, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RandomAccessFile readChannel$lambda$0(File file) {
        return new RandomAccessFile(file, "r");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit readChannel$lambda$1(Lazy lazy, File file, Throwable th) {
        if (lazy.isInitialized()) {
            try {
                ((RandomAccessFile) lazy.getValue()).close();
            } catch (Throwable unused) {
            }
        }
        return Unit.INSTANCE;
    }

    public static final ByteWriteChannel writeChannel(File file, CoroutineContext coroutineContext) {
        file.getClass();
        coroutineContext.getClass();
        return ByteReadChannelOperationsKt.reader((CoroutineScope) GlobalScope.INSTANCE, new CoroutineName("file-writer").plus(coroutineContext), true, (Function2) new AnonymousClass1(file, null)).getChannel();
    }

    public static ByteWriteChannel writeChannel$default(File file, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            coroutineContext = DefaultIoScheduler.INSTANCE;
        }
        return writeChannel(file, coroutineContext);
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0177  */
    /* JADX WARN: Code duplicated, block: B:52:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:53:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:55:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:57:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:59:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:63:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:66:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:67:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:68:0x0200  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x013e -> B:44:0x0143). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0239 -> B:78:0x023c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object writeToScope(java.nio.channels.SeekableByteChannel r27, io.ktor.utils.io.WriterScope r28, long r29, long r31, kotlin.coroutines.Continuation r33) {
        /*
            Method dump skipped, instruction units count: 600
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.cio.FileChannelsKt.writeToScope(java.nio.channels.SeekableByteChannel, io.ktor.utils.io.WriterScope, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
