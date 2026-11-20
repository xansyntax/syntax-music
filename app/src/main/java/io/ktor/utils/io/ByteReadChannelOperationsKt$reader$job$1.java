package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobSupport;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt$reader$job$1", f = "ByteReadChannelOperations.kt", l = {351, 361, 361, 361}, m = "invokeSuspend", v = 1)
public final class ByteReadChannelOperationsKt$reader$job$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2 $block;
    final /* synthetic */ ByteChannel $channel;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteReadChannelOperationsKt$reader$job$1(Function2 function2, ByteChannel byteChannel, Continuation continuation) {
        super(2, continuation);
        this.$block = function2;
        this.$channel = byteChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ByteReadChannelOperationsKt$reader$job$1 byteReadChannelOperationsKt$reader$job$1 = new ByteReadChannelOperationsKt$reader$job$1(this.$block, this.$channel, continuation);
        byteReadChannelOperationsKt$reader$job$1.L$0 = obj;
        return byteReadChannelOperationsKt$reader$job$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ByteReadChannelOperationsKt$reader$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a0, code lost:
    
        if (r12.join(r11) == r7) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c0, code lost:
    
        if (((kotlinx.coroutines.JobSupport) r1).join(r11) == r7) goto L40;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r4v1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        JobImpl jobImpl;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        ?? r1 = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (r1 == 0) {
                    ResultKt.throwOnFailure(obj);
                    JobImpl jobImpl2 = new JobImpl(AwaitKt.getJob(coroutineScope.getCoroutineContext()));
                    Function2 function2 = this.$block;
                    ReaderScope readerScope = new ReaderScope(this.$channel, coroutineScope.getCoroutineContext().plus(jobImpl2));
                    this.L$0 = coroutineScope;
                    this.L$1 = jobImpl2;
                    this.label = 1;
                    r1 = jobImpl2;
                    if (function2.invoke(readerScope, this) == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (r1 == 1) {
                    CompletableJob completableJob = (CompletableJob) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    r1 = completableJob;
                } else {
                    if (r1 != 2 && r1 != 3) {
                        if (r1 != 4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        Throwable th = (Throwable) this.L$2;
                        ResultKt.throwOnFailure(obj);
                        throw th;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
                if (AwaitKt.getJob(coroutineScope.getCoroutineContext()).isCancelled()) {
                    this.$channel.cancel(AwaitKt.getJob(coroutineScope.getCoroutineContext()).getCancellationException());
                }
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
            } catch (Throwable th2) {
                r1 = jobImpl;
                th = th2;
                try {
                    ((JobSupport) r1).cancel(AwaitKt.CancellationException("Exception thrown while reading from channel", th));
                    ByteWriteChannelOperationsKt.close(this.$channel, th);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 3;
                } catch (Throwable th3) {
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = th3;
                    this.label = 4;
                    if (((JobSupport) r1).join(this) != coroutineSingletons) {
                        throw th3;
                    }
                }
            }
            jobImpl = (JobImpl) r1;
            jobImpl.complete$1();
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
