package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2 {
    public int I$0;
    public int I$1;
    public /* synthetic */ Object L$0;
    public NodeList L$3;
    public ChildHandleNode L$4;
    public byte label;
    public final /* synthetic */ JobSupport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobSupport$children$1(Continuation continuation, JobSupport jobSupport) {
        super(2, continuation);
        this.this$0 = jobSupport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(continuation, this.this$0);
        jobSupport$children$1.L$0 = obj;
        return jobSupport$children$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((JobSupport$children$1) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x005f  */
    /* JADX WARN: Code duplicated, block: B:23:0x0063  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0061 -> B:25:0x0077). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.L$0
            kotlin.sequences.SequenceScope r0 = (kotlin.sequences.SequenceScope) r0
            byte r1 = r7.label
            r2 = 2
            r3 = 1
            r4 = 0
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 == 0) goto L27
            if (r1 == r3) goto L23
            if (r1 != r2) goto L1d
            int r1 = r7.I$1
            int r3 = r7.I$0
            kotlinx.coroutines.ChildHandleNode r4 = r7.L$4
            kotlinx.coroutines.NodeList r6 = r7.L$3
            kotlin.ResultKt.throwOnFailure(r8)
            goto L77
        L1d:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r7)
            return r4
        L23:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7c
        L27:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.JobSupport r8 = r7.this$0
            java.lang.Object r8 = r8.getState$kotlinx_coroutines_core()
            boolean r1 = r8 instanceof kotlinx.coroutines.ChildHandleNode
            if (r1 == 0) goto L40
            kotlinx.coroutines.ChildHandleNode r8 = (kotlinx.coroutines.ChildHandleNode) r8
            kotlinx.coroutines.JobSupport r8 = r8.childJob
            r7.L$0 = r4
            r7.label = r3
            r0.yield(r8, r7)
            return r5
        L40:
            boolean r1 = r8 instanceof kotlinx.coroutines.Incomplete
            if (r1 == 0) goto L7c
            kotlinx.coroutines.Incomplete r8 = (kotlinx.coroutines.Incomplete) r8
            kotlinx.coroutines.NodeList r8 = r8.getList()
            if (r8 == 0) goto L7c
            java.lang.Object r1 = r8.getNext()
            r1.getClass()
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            r3 = 0
            r6 = r8
            r4 = r1
            r1 = r3
        L59:
            boolean r8 = r4.equals(r6)
            if (r8 != 0) goto L7c
            boolean r8 = r4 instanceof kotlinx.coroutines.ChildHandleNode
            if (r8 == 0) goto L77
            kotlinx.coroutines.ChildHandleNode r4 = (kotlinx.coroutines.ChildHandleNode) r4
            kotlinx.coroutines.JobSupport r8 = r4.childJob
            r7.L$0 = r0
            r7.L$3 = r6
            r7.L$4 = r4
            r7.I$0 = r3
            r7.I$1 = r1
            r7.label = r2
            r0.yield(r8, r7)
            return r5
        L77:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = r4.getNextNode()
            goto L59
        L7c:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport$children$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
