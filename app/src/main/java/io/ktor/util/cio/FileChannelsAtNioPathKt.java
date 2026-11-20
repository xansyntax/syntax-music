package io.ktor.util.cio;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.WriterScope;
import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.CharsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ljava/nio/file/Path;", "", "start", "endInclusive", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/utils/io/ByteReadChannel;", "readChannel", "(Ljava/nio/file/Path;JJLkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteReadChannel;", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class FileChannelsAtNioPathKt {

    /* JADX INFO: renamed from: io.ktor.util.cio.FileChannelsAtNioPathKt$readChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.cio.FileChannelsAtNioPathKt$readChannel$1", f = "FileChannelsAtNioPath.kt", l = {36}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ long $endInclusive;
        final /* synthetic */ long $fileLength;
        final /* synthetic */ long $start;
        final /* synthetic */ Path $this_readChannel;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, long j3, Path path, Continuation continuation) {
            super(2, continuation);
            this.$start = j;
            this.$endInclusive = j2;
            this.$fileLength = j3;
            this.$this_readChannel = path;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$start, this.$endInclusive, this.$fileLength, this.$this_readChannel, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            SeekableByteChannel seekableByteChannel;
            Throwable th;
            Closeable closeable;
            WriterScope writerScope = (WriterScope) this.L$0;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                closeable = (Closeable) this.L$1;
                try {
                    ResultKt.throwOnFailure(obj);
                    CharsKt.closeFinally(closeable, null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        CharsKt.closeFinally(closeable, th);
                        throw th3;
                    }
                }
            }
            ResultKt.throwOnFailure(obj);
            long j = this.$start;
            if (!(j >= 0)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "start position shouldn't be negative but it is "));
                return null;
            }
            long j2 = this.$endInclusive;
            long j3 = this.$fileLength;
            if (!(j2 <= j3 - 1)) {
                StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(j3, "endInclusive points to the position out of the file: file size = ", ", endInclusive = ");
                sbM.append(j2);
                throw new IllegalArgumentException(sbM.toString().toString());
            }
            SeekableByteChannel seekableByteChannelNewByteChannel = Files.newByteChannel(this.$this_readChannel, new OpenOption[0]);
            long j4 = this.$start;
            long j5 = this.$endInclusive;
            try {
                seekableByteChannelNewByteChannel.getClass();
                this.L$0 = null;
                this.L$1 = seekableByteChannelNewByteChannel;
                this.L$2 = null;
                this.I$0 = 0;
                this.label = 1;
                seekableByteChannel = seekableByteChannelNewByteChannel;
                try {
                    Object objWriteToScope = FileChannelsKt.writeToScope(seekableByteChannel, writerScope, j4, j5, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objWriteToScope == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    closeable = seekableByteChannel;
                    CharsKt.closeFinally(closeable, null);
                    return Unit.INSTANCE;
                } catch (Throwable th4) {
                    th = th4;
                    th = th;
                    closeable = seekableByteChannel;
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                seekableByteChannel = seekableByteChannelNewByteChannel;
            }
        }
    }

    public static final ByteReadChannel readChannel(Path path, long j, long j2, CoroutineContext coroutineContext) throws IOException {
        path.getClass();
        coroutineContext.getClass();
        return ByteWriteChannelOperationsKt.writer((CoroutineScope) AwaitKt.CoroutineScope(coroutineContext), new CoroutineName("file-reader").plus(coroutineContext), false, (Function2) new AnonymousClass1(j, j2, Files.size(path), path, null)).getChannel();
    }

    public static ByteReadChannel readChannel$default(Path path, long j, long j2, CoroutineContext coroutineContext, int i, Object obj) {
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
        return readChannel(path, j3, j4, coroutineContext);
    }
}
