package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements Function3 {
    public final /* synthetic */ Flow $this_debounceInternal;
    public final /* synthetic */ FlowKt__DelayKt$$ExternalSyntheticLambda0 $timeoutMillisSelector;
    public /* synthetic */ CoroutineScope L$0;
    public /* synthetic */ FlowCollector L$1;
    public ReceiveChannel L$2;
    public Ref$ObjectRef L$3;
    public Ref$LongRef L$4;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1(FlowKt__DelayKt$$ExternalSyntheticLambda0 flowKt__DelayKt$$ExternalSyntheticLambda0, Flow flow, Continuation continuation) {
        super(3, continuation);
        this.$timeoutMillisSelector = flowKt__DelayKt$$ExternalSyntheticLambda0;
        this.$this_debounceInternal = flow;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, (Continuation) obj3);
        flowKt__DelayKt$debounceInternal$1.L$0 = (CoroutineScope) obj;
        flowKt__DelayKt$debounceInternal$1.L$1 = (FlowCollector) obj2;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0049  */
    /* JADX WARN: Code duplicated, block: B:30:0x0088 A[PHI: r3 r9 r10
      0x0088: PHI (r3v3 kotlin.jvm.internal.Ref$ObjectRef) = 
      (r3v5 kotlin.jvm.internal.Ref$ObjectRef)
      (r3v6 kotlin.jvm.internal.Ref$ObjectRef)
      (r3v6 kotlin.jvm.internal.Ref$ObjectRef)
     binds: [B:29:0x0085, B:15:0x004e, B:21:0x0069] A[DONT_GENERATE, DONT_INLINE]
      0x0088: PHI (r9v2 kotlinx.coroutines.channels.ReceiveChannel) = 
      (r9v14 kotlinx.coroutines.channels.ReceiveChannel)
      (r9v15 kotlinx.coroutines.channels.ReceiveChannel)
      (r9v15 kotlinx.coroutines.channels.ReceiveChannel)
     binds: [B:29:0x0085, B:15:0x004e, B:21:0x0069] A[DONT_GENERATE, DONT_INLINE]
      0x0088: PHI (r10v1 kotlin.jvm.internal.Ref$LongRef) = 
      (r10v6 kotlin.jvm.internal.Ref$LongRef)
      (r10v8 kotlin.jvm.internal.Ref$LongRef)
      (r10v8 kotlin.jvm.internal.Ref$LongRef)
     binds: [B:29:0x0085, B:15:0x004e, B:21:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:35:0x009f  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:39:0x010b  */
    /* JADX WARN: Code duplicated, block: B:40:0x0110  */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
