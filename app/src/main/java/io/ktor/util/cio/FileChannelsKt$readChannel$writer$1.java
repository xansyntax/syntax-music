package io.ktor.util.cio;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.utils.io.WriterScope;
import java.io.Closeable;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.CharsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt$readChannel$writer$1", f = "FileChannels.kt", l = {42}, m = "invokeSuspend", v = 1)
public final class FileChannelsKt$readChannel$writer$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ long $endInclusive;
    final /* synthetic */ long $fileLength;
    final /* synthetic */ Lazy $randomAccessFile;
    final /* synthetic */ long $start;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileChannelsKt$readChannel$writer$1(long j, long j2, long j3, Lazy lazy, Continuation continuation) {
        super(2, continuation);
        this.$start = j;
        this.$endInclusive = j2;
        this.$fileLength = j3;
        this.$randomAccessFile = lazy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FileChannelsKt$readChannel$writer$1 fileChannelsKt$readChannel$writer$1 = new FileChannelsKt$readChannel$writer$1(this.$start, this.$endInclusive, this.$fileLength, this.$randomAccessFile, continuation);
        fileChannelsKt$readChannel$writer$1.L$0 = obj;
        return fileChannelsKt$readChannel$writer$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation continuation) {
        return ((FileChannelsKt$readChannel$writer$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
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
        Closeable closeable2 = (Closeable) this.$randomAccessFile.getValue();
        long j4 = this.$start;
        long j5 = this.$endInclusive;
        try {
            FileChannel channel = ((RandomAccessFile) closeable2).getChannel();
            channel.getClass();
            this.L$0 = null;
            this.L$1 = closeable2;
            this.L$2 = null;
            this.L$3 = null;
            this.I$0 = 0;
            this.label = 1;
            Object objWriteToScope = FileChannelsKt.writeToScope(channel, writerScope, j4, j5, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWriteToScope == coroutineSingletons) {
                return coroutineSingletons;
            }
            closeable = closeable2;
            CharsKt.closeFinally(closeable, null);
            return Unit.INSTANCE;
        } catch (Throwable th4) {
            th = th4;
            closeable = closeable2;
            throw th;
        }
    }
}
