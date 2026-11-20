package androidx.room;

import androidx.room.coroutines.PooledConnectionImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Transactor $connection;
    public final /* synthetic */ ObservedTableStates.ObserveOp[] $tablesToSync;
    public int I$0;
    public int I$1;
    public int I$2;
    public ObservedTableStates.ObserveOp[] L$0;
    public TriggerBasedInvalidationTracker L$1;
    public Transactor L$2;
    public byte label;
    public final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1(ObservedTableStates.ObserveOp[] observeOpArr, TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, Transactor transactor, Continuation continuation) {
        super(2, continuation);
        this.$tablesToSync = observeOpArr;
        this.this$0 = triggerBasedInvalidationTracker;
        this.$connection = transactor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1(this.$tablesToSync, this.this$0, this.$connection, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1) create((PooledConnectionImpl.TransactionImpl) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0031  */
    /* JADX WARN: Code duplicated, block: B:13:0x003b  */
    /* JADX WARN: Code duplicated, block: B:15:0x003f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0041  */
    /* JADX WARN: Code duplicated, block: B:19:0x0056  */
    /* JADX WARN: Code duplicated, block: B:21:0x0059  */
    /* JADX WARN: Code duplicated, block: B:23:0x005d  */
    /* JADX WARN: Code duplicated, block: B:26:0x0072  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0072 -> B:27:0x0073). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            byte r0 = r11.label
            r1 = 0
            r2 = 2
            r3 = 1
            if (r0 == 0) goto L21
            if (r0 == r3) goto Lb
            if (r0 != r2) goto L1b
        Lb:
            int r0 = r11.I$2
            int r4 = r11.I$1
            int r5 = r11.I$0
            androidx.room.Transactor r6 = r11.L$2
            androidx.room.TriggerBasedInvalidationTracker r7 = r11.L$1
            androidx.room.ObservedTableStates$ObserveOp[] r8 = r11.L$0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L57
        L1b:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r11)
            return r1
        L21:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.room.ObservedTableStates$ObserveOp[] r12 = r11.$tablesToSync
            int r0 = r12.length
            r4 = 0
            androidx.room.TriggerBasedInvalidationTracker r5 = r11.this$0
            androidx.room.Transactor r6 = r11.$connection
            r8 = r12
            r12 = r4
            r7 = r5
        L2f:
            if (r4 >= r0) goto L75
            r5 = r8[r4]
            int r9 = r12 + 1
            int r5 = r5.ordinal()
            if (r5 == 0) goto L72
            kotlin.coroutines.intrinsics.CoroutineSingletons r10 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r5 == r3) goto L5d
            if (r5 != r2) goto L59
            r11.L$0 = r8
            r11.L$1 = r7
            r11.L$2 = r6
            r11.I$0 = r9
            r11.I$1 = r4
            r11.I$2 = r0
            r11.label = r2
            java.lang.Object r12 = r7.stopTrackingTable(r6, r12, r11)
            if (r12 != r10) goto L56
            goto L71
        L56:
            r5 = r9
        L57:
            r12 = r5
            goto L73
        L59:
            io.ktor.util.PathKt$$ExternalSyntheticBUOutline0.m$1()
            return r1
        L5d:
            r11.L$0 = r8
            r11.L$1 = r7
            r11.L$2 = r6
            r11.I$0 = r9
            r11.I$1 = r4
            r11.I$2 = r0
            r11.label = r3
            java.lang.Object r12 = r7.startTrackingTable(r6, r12, r11)
            if (r12 != r10) goto L56
        L71:
            return r10
        L72:
            r12 = r9
        L73:
            int r4 = r4 + r3
            goto L2f
        L75:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
