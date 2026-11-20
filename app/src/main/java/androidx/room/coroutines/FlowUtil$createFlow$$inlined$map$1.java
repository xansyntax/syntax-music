package androidx.room.coroutines;

import androidx.room.RoomDatabase;
import com.metrolist.music.db.DatabaseDao_Impl;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FlowUtil$createFlow$$inlined$map$1 implements Flow {
    public final /* synthetic */ Function1 $block$inlined;
    public final /* synthetic */ RoomDatabase $db$inlined;
    public final /* synthetic */ boolean $inTransaction$inlined;
    public final /* synthetic */ Flow $this_unsafeTransform$inlined;

    /* JADX INFO: renamed from: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements FlowCollector {
        public final /* synthetic */ Function1 $block$inlined;
        public final /* synthetic */ RoomDatabase $db$inlined;
        public final /* synthetic */ boolean $inTransaction$inlined;
        public final /* synthetic */ FlowCollector $this_unsafeFlow;

        /* JADX INFO: renamed from: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class AnonymousClass1 extends ContinuationImpl {
            public FlowCollector L$0;
            public int label;
            public /* synthetic */ Object result;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(FlowCollector flowCollector, RoomDatabase roomDatabase, boolean z, Function1 function1) {
            this.$this_unsafeFlow = flowCollector;
            this.$db$inlined = roomDatabase;
            this.$inTransaction$inlined = z;
            this.$block$inlined = function1;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
        
            if (r6.emit(r8, r0) == r5) goto L22;
         */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1;
            FlowCollector flowCollector;
            if (continuation instanceof AnonymousClass1) {
                anonymousClass1 = (AnonymousClass1) continuation;
                int i = anonymousClass1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    anonymousClass1.label = i - Integer.MIN_VALUE;
                } else {
                    anonymousClass1 = new AnonymousClass1(continuation);
                }
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
            Object objPerformSuspending = anonymousClass1.result;
            int i2 = anonymousClass1.label;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (i2 != 0) {
                if (i2 == 1) {
                    flowCollector = anonymousClass1.L$0;
                    ResultKt.throwOnFailure(objPerformSuspending);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objPerformSuspending);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(objPerformSuspending);
            FlowCollector flowCollector2 = this.$this_unsafeFlow;
            anonymousClass1.L$0 = flowCollector2;
            anonymousClass1.label = 1;
            objPerformSuspending = DatabaseDao_Impl.AnonymousClass17.performSuspending(this.$db$inlined, true, this.$inTransaction$inlined, this.$block$inlined, anonymousClass1);
            if (objPerformSuspending != coroutineSingletons) {
                flowCollector = flowCollector2;
            }
            return coroutineSingletons;
            anonymousClass1.L$0 = null;
            anonymousClass1.label = 2;
        }
    }

    public FlowUtil$createFlow$$inlined$map$1(Flow flow, RoomDatabase roomDatabase, boolean z, Function1 function1) {
        this.$this_unsafeTransform$inlined = flow;
        this.$db$inlined = roomDatabase;
        this.$inTransaction$inlined = z;
        this.$block$inlined = function1;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object objCollect = this.$this_unsafeTransform$inlined.collect(new AnonymousClass2(flowCollector, this.$db$inlined, this.$inTransaction$inlined, this.$block$inlined), continuation);
        return objCollect == CoroutineSingletons.COROUTINE_SUSPENDED ? objCollect : Unit.INSTANCE;
    }
}
