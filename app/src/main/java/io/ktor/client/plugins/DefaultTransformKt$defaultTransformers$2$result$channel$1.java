package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2$result$channel$1", f = "DefaultTransform.kt", l = {105}, m = "invokeSuspend", v = 1)
public final class DefaultTransformKt$defaultTransformers$2$result$channel$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Object $body;
    final /* synthetic */ HttpResponse $response;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultTransformKt$defaultTransformers$2$result$channel$1(Object obj, HttpResponse httpResponse, Continuation continuation) {
        super(2, continuation);
        this.$body = obj;
        this.$response = httpResponse;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DefaultTransformKt$defaultTransformers$2$result$channel$1 defaultTransformKt$defaultTransformers$2$result$channel$1 = new DefaultTransformKt$defaultTransformers$2$result$channel$1(this.$body, this.$response, continuation);
        defaultTransformKt$defaultTransformers$2$result$channel$1.L$0 = obj;
        return defaultTransformKt$defaultTransformers$2$result$channel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation continuation) {
        return ((DefaultTransformKt$defaultTransformers$2$result$channel$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WriterScope writerScope = (WriterScope) this.L$0;
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ByteReadChannel byteReadChannel = (ByteReadChannel) this.$body;
                ByteWriteChannel channel = writerScope.getChannel();
                this.L$0 = null;
                this.label = 1;
                Object objCopyTo = ByteReadChannelOperationsKt.copyTo(byteReadChannel, channel, Long.MAX_VALUE, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objCopyTo == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            ByteReadChannelOperationsKt.rethrowCloseCauseIfNeeded((ByteReadChannel) this.$body);
            return Unit.INSTANCE;
        } catch (CancellationException e) {
            AwaitKt.cancel(this.$response, e);
            throw e;
        } catch (Throwable th) {
            AwaitKt.cancel(this.$response, AwaitKt.CancellationException("Receive failed", th));
            throw th;
        }
    }
}
