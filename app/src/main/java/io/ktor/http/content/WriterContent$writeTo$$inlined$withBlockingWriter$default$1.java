package io.ktor.http.content;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import java.io.Closeable;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.CharsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "io/ktor/http/content/BlockingBridgeKt$withBlockingWriter$2"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.http.content.WriterContent$writeTo$$inlined$withBlockingWriter$default$1", f = "WriterContent.kt", l = {67}, m = "invokeSuspend", v = 1)
public final class WriterContent$writeTo$$inlined$withBlockingWriter$default$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2 $block;
    final /* synthetic */ Charset $charset;
    final /* synthetic */ ByteWriteChannel $this_withBlockingWriter;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WriterContent$writeTo$$inlined$withBlockingWriter$default$1(ByteWriteChannel byteWriteChannel, Charset charset, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_withBlockingWriter = byteWriteChannel;
        this.$charset = charset;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        WriterContent$writeTo$$inlined$withBlockingWriter$default$1 writerContent$writeTo$$inlined$withBlockingWriter$default$1 = new WriterContent$writeTo$$inlined$withBlockingWriter$default$1(this.$this_withBlockingWriter, this.$charset, this.$block, continuation);
        writerContent$writeTo$$inlined$withBlockingWriter$default$1.L$0 = obj;
        return writerContent$writeTo$$inlined$withBlockingWriter$default$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((WriterContent$writeTo$$inlined$withBlockingWriter$default$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Closeable closeable;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            closeable = (Closeable) this.L$2;
            try {
                ResultKt.throwOnFailure(obj);
                CharsKt.closeFinally(closeable, null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                try {
                    throw th;
                } catch (Throwable th2) {
                    CharsKt.closeFinally(closeable, th);
                    throw th2;
                }
            }
        }
        ResultKt.throwOnFailure(obj);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(BlockingBridgeKt.nonClosing(BlockingKt.asOutputStream(this.$this_withBlockingWriter, AwaitKt.getJob(coroutineScope.getCoroutineContext()))), this.$charset);
        Function2 function2 = this.$block;
        try {
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = outputStreamWriter;
            this.L$3 = null;
            this.I$0 = 0;
            this.label = 1;
            Object objInvoke = function2.invoke(outputStreamWriter, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objInvoke == coroutineSingletons) {
                return coroutineSingletons;
            }
            closeable = outputStreamWriter;
            CharsKt.closeFinally(closeable, null);
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            th = th3;
            closeable = outputStreamWriter;
            throw th;
        }
    }
}
