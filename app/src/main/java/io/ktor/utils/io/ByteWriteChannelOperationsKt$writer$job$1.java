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
@DebugMetadata(c = "io.ktor.utils.io.ByteWriteChannelOperationsKt$writer$job$1", f = "ByteWriteChannelOperations.kt", l = {181, 191, 192, 191, 192, 191, 192}, m = "invokeSuspend", v = 1)
public final class ByteWriteChannelOperationsKt$writer$job$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2 $block;
    final /* synthetic */ ByteChannel $channel;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteWriteChannelOperationsKt$writer$job$1(Function2 function2, ByteChannel byteChannel, Continuation continuation) {
        super(2, continuation);
        this.$block = function2;
        this.$channel = byteChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ByteWriteChannelOperationsKt$writer$job$1 byteWriteChannelOperationsKt$writer$job$1 = new ByteWriteChannelOperationsKt$writer$job$1(this.$block, this.$channel, continuation);
        byteWriteChannelOperationsKt$writer$job$1.L$0 = obj;
        return byteWriteChannelOperationsKt$writer$job$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ByteWriteChannelOperationsKt$writer$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x009f A[Catch: all -> 0x00b1, TRY_LEAVE, TryCatch #1 {all -> 0x00b1, blocks: (B:25:0x0091, B:27:0x009f), top: B:62:0x0091 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00c5  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d6, code lost:
    
        if (r10.flushAndClose(r9) == r4) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x010b, code lost:
    
        if (r10.flushAndClose(r9) == r4) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0138, code lost:
    
        if (r10.flushAndClose(r9) == r4) goto L56;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        JobImpl jobImpl;
        ?? r0 = (CoroutineScope) this.L$0;
        ?? r1 = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                try {
                    switch (r1) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            JobImpl jobImpl2 = new JobImpl(AwaitKt.getJob(r0.getCoroutineContext()));
                            Function2 function2 = this.$block;
                            WriterScope writerScope = new WriterScope(this.$channel, r0.getCoroutineContext().plus(jobImpl2));
                            this.L$0 = r0;
                            this.L$1 = jobImpl2;
                            this.label = 1;
                            r1 = jobImpl2;
                            if (function2.invoke(writerScope, this) != coroutineSingletons) {
                                jobImpl = (JobImpl) r1;
                                jobImpl.complete$1();
                                try {
                                    if (AwaitKt.getJob(r0.getCoroutineContext()).isCancelled()) {
                                        this.$channel.cancel(AwaitKt.getJob(r0.getCoroutineContext()).getCancellationException());
                                    }
                                    this.L$0 = r0;
                                    this.L$1 = null;
                                    this.label = 2;
                                    if (jobImpl.join(this) != coroutineSingletons) {
                                        ByteChannel byteChannel = this.$channel;
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.I$0 = 0;
                                        this.label = 3;
                                    }
                                } catch (Throwable th2) {
                                    r1 = jobImpl;
                                    th = th2;
                                    try {
                                        ((JobSupport) r1).cancel(AwaitKt.CancellationException("Exception thrown while writing to channel", th));
                                        this.$channel.cancel(th);
                                        this.L$0 = r0;
                                        this.L$1 = null;
                                        this.label = 4;
                                        if (((JobSupport) r1).join(this) != coroutineSingletons) {
                                            ByteChannel byteChannel2 = this.$channel;
                                            this.L$0 = null;
                                            this.L$1 = null;
                                            this.L$2 = null;
                                            this.I$0 = 0;
                                            this.label = 5;
                                        }
                                    } catch (Throwable th3) {
                                        this.L$0 = r0;
                                        this.L$1 = null;
                                        this.L$2 = th3;
                                        this.label = 6;
                                        if (((JobSupport) r1).join(this) != coroutineSingletons) {
                                            th = th3;
                                            ByteChannel byteChannel3 = this.$channel;
                                            this.L$0 = null;
                                            this.L$1 = null;
                                            this.L$2 = th;
                                            this.L$3 = null;
                                            this.I$0 = 0;
                                            this.label = 7;
                                            r0 = th;
                                        }
                                    }
                                }
                                break;
                            }
                            return coroutineSingletons;
                        case 1:
                            CompletableJob completableJob = (CompletableJob) this.L$1;
                            ResultKt.throwOnFailure(obj);
                            r1 = completableJob;
                            jobImpl = (JobImpl) r1;
                            jobImpl.complete$1();
                            if (AwaitKt.getJob(r0.getCoroutineContext()).isCancelled()) {
                                this.$channel.cancel(AwaitKt.getJob(r0.getCoroutineContext()).getCancellationException());
                                break;
                            }
                            this.L$0 = r0;
                            this.L$1 = null;
                            this.label = 2;
                            if (jobImpl.join(this) != coroutineSingletons) {
                                ByteChannel byteChannel4 = this.$channel;
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.I$0 = 0;
                                this.label = 3;
                                break;
                            }
                            return coroutineSingletons;
                        case 2:
                            ResultKt.throwOnFailure(obj);
                            ByteChannel byteChannel5 = this.$channel;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.I$0 = 0;
                            this.label = 3;
                            break;
                        case 3:
                        case 5:
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        case 4:
                            ResultKt.throwOnFailure(obj);
                            ByteChannel byteChannel6 = this.$channel;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.I$0 = 0;
                            this.label = 5;
                            break;
                        case 6:
                            Throwable th4 = (Throwable) this.L$2;
                            ResultKt.throwOnFailure(obj);
                            th = th4;
                            ByteChannel byteChannel7 = this.$channel;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = th;
                            this.L$3 = null;
                            this.I$0 = 0;
                            this.label = 7;
                            r0 = th;
                            break;
                        case 7:
                            Throwable th5 = (Throwable) this.L$2;
                            ResultKt.throwOnFailure(obj);
                            r0 = th5;
                            throw r0;
                        default:
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable unused) {
                throw r0;
            }
        } catch (Throwable unused2) {
        }
    }
}
