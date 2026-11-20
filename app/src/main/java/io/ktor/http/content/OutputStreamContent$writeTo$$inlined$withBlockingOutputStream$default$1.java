package io.ktor.http.content;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "io/ktor/http/content/BlockingBridgeKt$withBlockingOutputStream$2"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.http.content.OutputStreamContent$writeTo$$inlined$withBlockingOutputStream$default$1", f = "OutputStreamContent.kt", l = {46}, m = "invokeSuspend", v = 1)
public final class OutputStreamContent$writeTo$$inlined$withBlockingOutputStream$default$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2 $block;
    final /* synthetic */ ByteWriteChannel $this_withBlockingOutputStream;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutputStreamContent$writeTo$$inlined$withBlockingOutputStream$default$1(ByteWriteChannel byteWriteChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_withBlockingOutputStream = byteWriteChannel;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        OutputStreamContent$writeTo$$inlined$withBlockingOutputStream$default$1 outputStreamContent$writeTo$$inlined$withBlockingOutputStream$default$1 = new OutputStreamContent$writeTo$$inlined$withBlockingOutputStream$default$1(this.$this_withBlockingOutputStream, this.$block, continuation);
        outputStreamContent$writeTo$$inlined$withBlockingOutputStream$default$1.L$0 = obj;
        return outputStreamContent$writeTo$$inlined$withBlockingOutputStream$default$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OutputStreamContent$writeTo$$inlined$withBlockingOutputStream$default$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            OutputStream outputStreamAsOutputStream = BlockingKt.asOutputStream(this.$this_withBlockingOutputStream, AwaitKt.getJob(coroutineScope.getCoroutineContext()));
            Function2 function2 = this.$block;
            this.L$0 = null;
            this.L$1 = null;
            this.label = 1;
            Object objInvoke = function2.invoke(outputStreamAsOutputStream, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objInvoke == coroutineSingletons) {
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
