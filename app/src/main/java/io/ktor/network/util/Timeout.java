package io.ktor.network.util;

import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0011J\r\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0011J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001aR*\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lio/ktor/network/util/Timeout;", "", "", ContentDisposition.Parameters.Name, "", "timeoutMs", "Lkotlin/Function0;", "clock", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "onTimeout", "<init>", "(Ljava/lang/String;JLkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "start", "()V", "stop", "finish", "Lkotlinx/coroutines/Job;", "initTimeoutJob", "()Lkotlinx/coroutines/Job;", "Ljava/lang/String;", "J", "Lkotlin/jvm/functions/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/jvm/functions/Function1;", "workerJob", "Lkotlinx/coroutines/Job;", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Timeout {
    private final Function0 clock;
    volatile /* synthetic */ int isStarted;
    volatile /* synthetic */ long lastActivityTime;
    private final String name;
    private final Function1 onTimeout;
    private final CoroutineScope scope;
    private final long timeoutMs;
    private Job workerJob;

    /* JADX INFO: renamed from: io.ktor.network.util.Timeout$initTimeoutJob$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.util.Timeout$initTimeoutJob$1", f = "Utils.kt", l = {54, 56, 57}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        long J$0;
        int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Timeout.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x007d A[EDGE_INSN: B:27:0x007d->B:30:0x0088 BREAK  A[LOOP:0: B:15:0x0026->B:38:?]] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            long jLongValue;
            Function1 function1;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int i = this.label;
            try {
                if (i == 0 || i == 1) {
                    ResultKt.throwOnFailure(obj);
                    do {
                        if (Timeout.this.isStarted == 0) {
                            Timeout timeout = Timeout.this;
                            timeout.lastActivityTime = ((Number) timeout.clock.invoke()).longValue();
                        }
                        jLongValue = (Timeout.this.lastActivityTime + Timeout.this.timeoutMs) - ((Number) Timeout.this.clock.invoke()).longValue();
                        if (jLongValue <= 0 && Timeout.this.isStarted != 0) {
                            this.label = 2;
                            if (AwaitKt.yield(this) != coroutineSingletons) {
                                function1 = Timeout.this.onTimeout;
                                this.label = 3;
                                if (function1.invoke(this) == coroutineSingletons) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            this.J$0 = jLongValue;
                            this.label = 1;
                        }
                    } while (AwaitKt.delay(jLongValue, this) != coroutineSingletons);
                    return coroutineSingletons;
                }
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    function1 = Timeout.this.onTimeout;
                    this.label = 3;
                    if (function1.invoke(this) == coroutineSingletons) {
                        break;
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable unused) {
            }
            return Unit.INSTANCE;
        }
    }

    public Timeout(String str, long j, Function0 function0, CoroutineScope coroutineScope, Function1 function1) {
        str.getClass();
        function0.getClass();
        coroutineScope.getClass();
        function1.getClass();
        this.name = str;
        this.timeoutMs = j;
        this.clock = function0;
        this.scope = coroutineScope;
        this.onTimeout = function1;
        this.lastActivityTime = 0L;
        this.isStarted = 0;
        this.workerJob = initTimeoutJob();
    }

    private final Job initTimeoutJob() {
        if (this.timeoutMs == Long.MAX_VALUE) {
            return null;
        }
        CoroutineScope coroutineScope = this.scope;
        return AwaitKt.launch$default(coroutineScope, coroutineScope.getCoroutineContext().plus(new CoroutineName("Timeout " + this.name)), null, new AnonymousClass1(null), 2);
    }

    public final void finish() {
        Job job = this.workerJob;
        if (job != null) {
            job.cancel(null);
        }
    }

    public final void start() {
        this.lastActivityTime = ((Number) this.clock.invoke()).longValue();
        this.isStarted = 1;
    }

    public final void stop() {
        this.isStarted = 0;
    }
}
