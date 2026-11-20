package kotlinx.coroutines.flow.internal;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import com.google.common.base.Joiner;
import com.metrolist.music.widget.PlaylistWidgetManager;
import com.metrolist.music.widget.PlaylistWidgetReceiver;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.InlineList;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CombineKt {
    public static final Continuation[] EMPTY_RESUMES = new Continuation[0];
    public static final Joiner NULL = new Joiner("NULL", (byte) 5);
    public static final Joiner UNINITIALIZED = new Joiner("UNINITIALIZED", (byte) 5);
    public static final Joiner DONE = new Joiner("DONE", (byte) 5);

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Flow[] $flows;
        public final /* synthetic */ FlowCollector $this_combineInternal;
        public final /* synthetic */ Function3 $transform;
        public int I$0;
        public int I$1;
        public int I$2;
        public /* synthetic */ Object L$0;
        public Object[] L$1;
        public Channel L$2;
        public byte[] L$4;
        public byte label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        /* JADX INFO: loaded from: classes.dex */
        public final class AnonymousClass1 extends SuspendLambda implements Function2 {
            public final /* synthetic */ Object $flows;
            public final /* synthetic */ int $i;
            public final /* synthetic */ Object $nonClosed;
            public final /* synthetic */ byte $r8$classId;
            public final /* synthetic */ Object $resultChannel;
            public boolean label;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            /* JADX INFO: loaded from: classes2.dex */
            public final class C00151 implements FlowCollector {
                public final /* synthetic */ int $i;
                public final /* synthetic */ BufferedChannel $resultChannel;

                public C00151(BufferedChannel bufferedChannel, int i) {
                    this.$resultChannel = bufferedChannel;
                    this.$i = i;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
                
                    if (kotlinx.coroutines.AwaitKt.yield(r0) == r4) goto L21;
                 */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    CombineKt$combineInternal$2$1$1$emit$1 combineKt$combineInternal$2$1$1$emit$1;
                    if (continuation instanceof CombineKt$combineInternal$2$1$1$emit$1) {
                        combineKt$combineInternal$2$1$1$emit$1 = (CombineKt$combineInternal$2$1$1$emit$1) continuation;
                        int i = combineKt$combineInternal$2$1$1$emit$1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            combineKt$combineInternal$2$1$1$emit$1.label = i - Integer.MIN_VALUE;
                        } else {
                            combineKt$combineInternal$2$1$1$emit$1 = new CombineKt$combineInternal$2$1$1$emit$1(this, continuation);
                        }
                    } else {
                        combineKt$combineInternal$2$1$1$emit$1 = new CombineKt$combineInternal$2$1$1$emit$1(this, continuation);
                    }
                    Object obj2 = combineKt$combineInternal$2$1$1$emit$1.result;
                    int i2 = combineKt$combineInternal$2$1$1$emit$1.label;
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        IndexedValue indexedValue = new IndexedValue(this.$i, obj);
                        combineKt$combineInternal$2$1$1$emit$1.label = 1;
                        if (this.$resultChannel.send(indexedValue, combineKt$combineInternal$2$1$1$emit$1) != coroutineSingletons) {
                        }
                        return coroutineSingletons;
                    }
                    if (i2 == 1) {
                        ResultKt.throwOnFailure(obj2);
                    } else {
                        if (i2 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                    combineKt$combineInternal$2$1$1$emit$1.label = 2;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ AnonymousClass1(Object obj, int i, Object obj2, Object obj3, Continuation continuation, byte b) {
                super(2, continuation);
                this.$r8$classId = b;
                this.$flows = obj;
                this.$i = i;
                this.$nonClosed = obj2;
                this.$resultChannel = obj3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                byte b = this.$r8$classId;
                Object obj2 = this.$resultChannel;
                Object obj3 = this.$nonClosed;
                Object obj4 = this.$flows;
                switch (b) {
                    case 0:
                        return new AnonymousClass1((Flow[]) obj4, this.$i, (AtomicInteger) obj3, (BufferedChannel) obj2, continuation, (byte) 0);
                    default:
                        return new AnonymousClass1((PlaylistWidgetReceiver) obj4, this.$i, (Bundle) obj3, (BroadcastReceiver.PendingResult) obj2, continuation, (byte) 1);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                byte b = this.$r8$classId;
                Unit unit = Unit.INSTANCE;
                CoroutineScope coroutineScope = (CoroutineScope) obj;
                Continuation continuation = (Continuation) obj2;
                switch (b) {
                    case 0:
                        break;
                }
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                byte b = this.$r8$classId;
                Unit unit = Unit.INSTANCE;
                Object obj2 = this.$nonClosed;
                int i = this.$i;
                Object obj3 = this.$flows;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                Object obj4 = this.$resultChannel;
                switch (b) {
                    case 0:
                        AtomicInteger atomicInteger = (AtomicInteger) obj2;
                        BufferedChannel bufferedChannel = (BufferedChannel) obj4;
                        boolean z = this.label;
                        try {
                            if (!z) {
                                ResultKt.throwOnFailure(obj);
                                Flow flow = ((Flow[]) obj3)[i];
                                C00151 c00151 = new C00151(bufferedChannel, i);
                                this.label = true;
                                if (flow.collect(c00151, this) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            } else {
                                if (!z) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                    return null;
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            if (atomicInteger.decrementAndGet() != 0) {
                                return unit;
                            }
                            bufferedChannel.close(null);
                            return unit;
                        } catch (Throwable th) {
                            if (atomicInteger.decrementAndGet() == 0) {
                                bufferedChannel.close(null);
                            }
                            throw th;
                        }
                    default:
                        BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) obj4;
                        boolean z2 = this.label;
                        try {
                            if (!z2) {
                                ResultKt.throwOnFailure(obj);
                                PlaylistWidgetManager playlistWidgetManager = ((PlaylistWidgetReceiver) obj3).playlistWidgetManager;
                                if (playlistWidgetManager == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("playlistWidgetManager");
                                    throw null;
                                }
                                this.label = true;
                                if (playlistWidgetManager.updateIdleWidget(i, (Bundle) obj2, this) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            } else {
                                if (!z2) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                    return null;
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                        } catch (Exception unused) {
                            Timber.Forest.tag("PlaylistWidgetReceiver");
                            ConnectionPool.e$1(new Object[0]);
                        } finally {
                            pendingResult.finish();
                        }
                        return unit;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Continuation continuation, Function3 function3, FlowCollector flowCollector, Flow[] flowArr) {
            super(2, continuation);
            this.$flows = flowArr;
            this.$transform = function3;
            this.$this_combineInternal = flowCollector;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation, this.$transform, this.$this_combineInternal, this.$flows);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x00a7  */
        /* JADX WARN: Code duplicated, block: B:30:0x00ad  */
        /* JADX WARN: Code duplicated, block: B:32:0x00bc A[DONT_INVERT, EDGE_INSN: B:32:0x00bc->B:18:0x0079 BREAK  A[LOOP:0: B:25:0x009d->B:38:?]] */
        /* JADX WARN: Code duplicated, block: B:33:0x00be  */
        /* JADX WARN: Code duplicated, block: B:37:0x00bc A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:38:? A[LOOP:0: B:25:0x009d->B:38:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00d6 -> B:18:0x0079). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instruction units count: 217
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Object combineInternal(Continuation continuation, Function3 function3, FlowCollector flowCollector, Flow[] flowArr) throws Throwable {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(null, function3, flowCollector, flowArr);
        FlowCoroutine flowCoroutine = new FlowCoroutine(continuation, continuation.getContext());
        Object objStartUndispatched = Okio__OkioKt.startUndispatched(flowCoroutine, true, flowCoroutine, anonymousClass2);
        return objStartUndispatched == CoroutineSingletons.COROUTINE_SUSPENDED ? objStartUndispatched : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object withContextUndispatched(CoroutineContext coroutineContext, Object obj, Object obj2, Function2 function2, Continuation continuation) throws Throwable {
        ChannelFlowKt$withContextUndispatched$1 channelFlowKt$withContextUndispatched$1;
        Object objUpdateThreadContext;
        Object objInvoke;
        if (continuation instanceof ChannelFlowKt$withContextUndispatched$1) {
            channelFlowKt$withContextUndispatched$1 = (ChannelFlowKt$withContextUndispatched$1) continuation;
            int i = channelFlowKt$withContextUndispatched$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                channelFlowKt$withContextUndispatched$1.label = i - Integer.MIN_VALUE;
            } else {
                channelFlowKt$withContextUndispatched$1 = new ChannelFlowKt$withContextUndispatched$1(continuation);
            }
        } else {
            channelFlowKt$withContextUndispatched$1 = new ChannelFlowKt$withContextUndispatched$1(continuation);
        }
        Object obj3 = channelFlowKt$withContextUndispatched$1.result;
        int i2 = channelFlowKt$withContextUndispatched$1.label;
        if (i2 != 0) {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Object obj4 = channelFlowKt$withContextUndispatched$1.L$6;
            CoroutineContext coroutineContext2 = channelFlowKt$withContextUndispatched$1.L$4;
            try {
                ResultKt.throwOnFailure(obj3);
                objUpdateThreadContext = obj4;
                coroutineContext = coroutineContext2;
                InlineList.restoreThreadContext(coroutineContext, objUpdateThreadContext);
                return obj3;
            } catch (Throwable th) {
                objUpdateThreadContext = obj4;
                coroutineContext = coroutineContext2;
                th = th;
                InlineList.restoreThreadContext(coroutineContext, objUpdateThreadContext);
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj3);
        objUpdateThreadContext = InlineList.updateThreadContext(coroutineContext, obj2);
        try {
            channelFlowKt$withContextUndispatched$1.L$1 = obj;
            channelFlowKt$withContextUndispatched$1.L$4 = coroutineContext;
            channelFlowKt$withContextUndispatched$1.L$6 = objUpdateThreadContext;
            channelFlowKt$withContextUndispatched$1.label = 1;
            StackFrameContinuation stackFrameContinuation = new StackFrameContinuation(channelFlowKt$withContextUndispatched$1, coroutineContext);
            if (function2 == null) {
                objInvoke = Okio__OkioKt.wrapWithContinuationImpl(function2, obj, stackFrameContinuation);
            } else {
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
                objInvoke = function2.invoke(obj, stackFrameContinuation);
            }
            obj3 = objInvoke;
            Object obj5 = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (obj3 == obj5) {
                return obj5;
            }
            InlineList.restoreThreadContext(coroutineContext, objUpdateThreadContext);
            return obj3;
        } catch (Throwable th2) {
            th = th2;
            InlineList.restoreThreadContext(coroutineContext, objUpdateThreadContext);
            throw th;
        }
    }
}
