package kotlinx.coroutines.flow;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Recomposer$join$2;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.internal.SubscriptionCountStateFlow;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class StartedWhileSubscribed implements SharingStarted {
    public final long replayExpiration;
    public final long stopTimeout;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function3 {
        public /* synthetic */ int I$0;
        public /* synthetic */ FlowCollector L$0;
        public byte label;

        public AnonymousClass1(Continuation continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            int iIntValue = ((Number) obj2).intValue();
            AnonymousClass1 anonymousClass1 = StartedWhileSubscribed.this.new AnonymousClass1((Continuation) obj3);
            anonymousClass1.L$0 = (FlowCollector) obj;
            anonymousClass1.I$0 = iIntValue;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0060  */
        /* JADX WARN: Code duplicated, block: B:29:0x006f  */
        /* JADX WARN: Code duplicated, block: B:32:0x007c  */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
        
            if (r4.emit(kotlinx.coroutines.flow.SharingCommand.START, r16) == r13) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
        
            if (r4.emit(kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE, r16) == r13) goto L34;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            StartedWhileSubscribed startedWhileSubscribed = StartedWhileSubscribed.this;
            long j = startedWhileSubscribed.replayExpiration;
            FlowCollector flowCollector = this.L$0;
            int i = this.I$0;
            byte b = this.label;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (b == 0) {
                ResultKt.throwOnFailure(obj);
                if (i > 0) {
                    this.L$0 = null;
                    this.I$0 = i;
                    this.label = (byte) 1;
                } else {
                    long j2 = startedWhileSubscribed.stopTimeout;
                    this.L$0 = flowCollector;
                    this.I$0 = i;
                    this.label = (byte) 2;
                    if (AwaitKt.delay(j2, this) != coroutineSingletons) {
                        if (j > 0) {
                            this.L$0 = flowCollector;
                            this.I$0 = i;
                            this.label = (byte) 3;
                            if (flowCollector.emit(SharingCommand.STOP, this) != coroutineSingletons) {
                                this.L$0 = flowCollector;
                                this.I$0 = i;
                                this.label = (byte) 4;
                                if (AwaitKt.delay(j, this) != coroutineSingletons) {
                                    this.L$0 = null;
                                    this.I$0 = i;
                                    this.label = (byte) 5;
                                }
                            }
                        } else {
                            this.L$0 = null;
                            this.I$0 = i;
                            this.label = (byte) 5;
                        }
                    }
                }
                return coroutineSingletons;
            }
            if (b != 1) {
                if (b == 2) {
                    ResultKt.throwOnFailure(obj);
                    if (j > 0) {
                        this.L$0 = flowCollector;
                        this.I$0 = i;
                        this.label = (byte) 3;
                        if (flowCollector.emit(SharingCommand.STOP, this) != coroutineSingletons) {
                            this.L$0 = flowCollector;
                            this.I$0 = i;
                            this.label = (byte) 4;
                            if (AwaitKt.delay(j, this) != coroutineSingletons) {
                            }
                        }
                    }
                    return coroutineSingletons;
                }
                if (b == 3) {
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = flowCollector;
                    this.I$0 = i;
                    this.label = (byte) 4;
                    if (AwaitKt.delay(j, this) != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b == 4) {
                    ResultKt.throwOnFailure(obj);
                } else if (b != 5) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                this.L$0 = null;
                this.I$0 = i;
                this.label = (byte) 5;
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    public StartedWhileSubscribed(long j, long j2) {
        this.stopTimeout = j;
        this.replayExpiration = j2;
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(j, "stopTimeout(", " ms) cannot be negative"));
            throw null;
        }
        if (j2 >= 0) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(j2, "replayExpiration(", " ms) cannot be negative"));
        throw null;
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public final Flow command(SubscriptionCountStateFlow subscriptionCountStateFlow) {
        return StateFlowKt.distinctUntilChanged(new FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1(FlowKt__MergeKt.transformLatest(subscriptionCountStateFlow, new AnonymousClass1(null)), new Recomposer$join$2(2, null, (byte) 12)));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof StartedWhileSubscribed)) {
            return false;
        }
        StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) obj;
        return this.stopTimeout == startedWhileSubscribed.stopTimeout && this.replayExpiration == startedWhileSubscribed.replayExpiration;
    }

    public final int hashCode() {
        return Long.hashCode(this.replayExpiration) + (Long.hashCode(this.stopTimeout) * 31);
    }

    public final String toString() {
        ListBuilder listBuilder = new ListBuilder(2);
        long j = this.stopTimeout;
        if (j > 0) {
            listBuilder.add("stopTimeout=" + j + "ms");
        }
        long j2 = this.replayExpiration;
        if (j2 < Long.MAX_VALUE) {
            listBuilder.add("replayExpiration=" + j2 + "ms");
        }
        return Format$$ExternalSyntheticOutline0.m(new StringBuilder("SharingStarted.WhileSubscribed("), CollectionsKt.joinToString$default(CollectionsKt__IterablesKt.build(listBuilder), null, null, null, null, 63), ')');
    }
}
