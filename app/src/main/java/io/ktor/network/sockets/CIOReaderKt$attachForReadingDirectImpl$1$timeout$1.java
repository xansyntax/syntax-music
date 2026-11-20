package io.ktor.network.sockets;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.network.sockets.CIOReaderKt$attachForReadingDirectImpl$1$timeout$1", f = "CIOReader.kt", l = {}, m = "invokeSuspend", v = 1)
public final class CIOReaderKt$attachForReadingDirectImpl$1$timeout$1 extends SuspendLambda implements Function1 {
    final /* synthetic */ ByteChannel $channel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CIOReaderKt$attachForReadingDirectImpl$1$timeout$1(ByteChannel byteChannel, Continuation continuation) {
        super(1, continuation);
        this.$channel = byteChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new CIOReaderKt$attachForReadingDirectImpl$1$timeout$1(this.$channel, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((CIOReaderKt$attachForReadingDirectImpl$1$timeout$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        if (this.label != 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        ByteWriteChannelOperationsKt.close(this.$channel, new SocketTimeoutException());
        return Unit.INSTANCE;
    }
}
