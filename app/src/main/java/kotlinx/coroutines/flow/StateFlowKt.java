package kotlinx.coroutines.flow;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import androidx.room.concurrent.FileLock;
import com.google.common.base.Joiner;
import com.metrolist.music.playback.DownloadUtil$getDownload$$inlined$map$1;
import com.metrolist.music.viewmodels.HomeViewModel$2$1;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.Serializable;
import java.util.concurrent.CancellationException;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CombinedContext$$ExternalSyntheticLambda0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.CharsKt;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.CombineKt;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NopCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StateFlowKt {
    public static final Joiner NONE;
    public static final Joiner NO_VALUE;
    public static final Joiner PENDING;
    public static final InstantKt$$ExternalSyntheticLambda0 defaultKeySelector = new InstantKt$$ExternalSyntheticLambda0((byte) 18);
    public static final CombinedContext$$ExternalSyntheticLambda0 defaultAreEquivalent = new CombinedContext$$ExternalSyntheticLambda0(12);

    static {
        byte b = 5;
        NO_VALUE = new Joiner("NO_VALUE", b);
        NONE = new Joiner("NONE", b);
        PENDING = new Joiner("PENDING", b);
    }

    public static final SharedFlowImpl MutableSharedFlow(int i, int i2, BufferOverflow bufferOverflow) {
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "replay cannot be negative, but was "));
            return null;
        }
        if (i2 < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i2, "extraBufferCapacity cannot be negative, but was "));
            return null;
        }
        if (i <= 0 && i2 <= 0 && bufferOverflow != BufferOverflow.SUSPEND) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$4(bufferOverflow, "replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy ");
            return null;
        }
        int i3 = i2 + i;
        if (i3 < 0) {
            i3 = Integer.MAX_VALUE;
        }
        return new SharedFlowImpl(i, i3, bufferOverflow);
    }

    public static /* synthetic */ SharedFlowImpl MutableSharedFlow$default(int i, int i2, BufferOverflow bufferOverflow) {
        int i3 = (i2 & 1) != 0 ? 0 : 1;
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return MutableSharedFlow(i3, i, bufferOverflow);
    }

    public static final StateFlowImpl MutableStateFlow(Object obj) {
        if (obj == null) {
            obj = CombineKt.NULL;
        }
        return new StateFlowImpl(obj);
    }

    public static final ReadonlyStateFlow asStateFlow(MutableStateFlow mutableStateFlow) {
        return new ReadonlyStateFlow(mutableStateFlow, null);
    }

    public static Flow buffer$default(Flow flow, int i) {
        BufferOverflow bufferOverflow;
        if (i < 0 && i != -2 && i != -1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Buffer size should be non-negative, BUFFERED, or CONFLATED, but was "));
            return null;
        }
        if (i == -1) {
            i = 0;
            bufferOverflow = BufferOverflow.DROP_OLDEST;
        } else {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        int i2 = i;
        BufferOverflow bufferOverflow2 = bufferOverflow;
        return flow instanceof FusibleFlow ? FusibleFlow.fuse$default((FusibleFlow) flow, null, i2, bufferOverflow2, 1) : new ChannelFlowOperatorImpl(flow, null, i2, bufferOverflow2, 2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Serializable catchImpl(SafeFlow safeFlow, FlowCollector flowCollector, ContinuationImpl continuationImpl) throws Throwable {
        FlowKt__ErrorsKt$catchImpl$1 flowKt__ErrorsKt$catchImpl$1;
        Ref$ObjectRef ref$ObjectRef;
        Job job;
        CancellationException cancellationException;
        if (continuationImpl instanceof FlowKt__ErrorsKt$catchImpl$1) {
            flowKt__ErrorsKt$catchImpl$1 = (FlowKt__ErrorsKt$catchImpl$1) continuationImpl;
            int i = flowKt__ErrorsKt$catchImpl$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__ErrorsKt$catchImpl$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__ErrorsKt$catchImpl$1 = new FlowKt__ErrorsKt$catchImpl$1(continuationImpl);
            }
        } else {
            flowKt__ErrorsKt$catchImpl$1 = new FlowKt__ErrorsKt$catchImpl$1(continuationImpl);
        }
        Object obj = flowKt__ErrorsKt$catchImpl$1.result;
        int i2 = flowKt__ErrorsKt$catchImpl$1.label;
        if (i2 == 0) {
            Ref$ObjectRef ref$ObjectRefM5m = IntIntPair$$ExternalSyntheticOutline0.m5m(obj);
            try {
                FlowCollector homeViewModel$2$1 = new HomeViewModel$2$1(flowCollector, ref$ObjectRefM5m, (byte) 9);
                flowKt__ErrorsKt$catchImpl$1.L$2 = ref$ObjectRefM5m;
                flowKt__ErrorsKt$catchImpl$1.label = 1;
                Object objCollect = safeFlow.collect(homeViewModel$2$1, flowKt__ErrorsKt$catchImpl$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objCollect == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return null;
            } catch (Throwable th) {
                th = th;
                ref$ObjectRef = ref$ObjectRefM5m;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ref$ObjectRef = flowKt__ErrorsKt$catchImpl$1.L$2;
            try {
                ResultKt.throwOnFailure(obj);
                return null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        Throwable th3 = (Throwable) ref$ObjectRef.element;
        if ((th3 != null && th3.equals(th)) || ((job = (Job) flowKt__ErrorsKt$catchImpl$1.getContext().get(Job.Key.$$INSTANCE)) != null && job.isCancelled() && (cancellationException = job.getCancellationException()) != null && cancellationException.equals(th))) {
            throw th;
        }
        if (th3 == null) {
            return th;
        }
        if (th instanceof CancellationException) {
            ResultKt.addSuppressed(th3, th);
            throw th3;
        }
        ResultKt.addSuppressed(th, th3);
        throw th;
    }

    public static final Object collectLatest(Flow flow, Function2 function2, Continuation continuation) {
        int i = FlowKt__MergeKt.$r8$clinit;
        Object objCollect = buffer$default(FlowKt__MergeKt.transformLatest(flow, new FlowKt__ZipKt$combine$1$1((Function) function2, (Continuation) null, (byte) 1)), 0).collect(NopCollector.INSTANCE, continuation);
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (objCollect != coroutineSingletons) {
            objCollect = unit;
        }
        return objCollect == coroutineSingletons ? objCollect : unit;
    }

    public static final DownloadUtil$getDownload$$inlined$map$1 combine(Flow flow, Flow flow2, Flow flow3, Function4 function4) {
        return new DownloadUtil$getDownload$$inlined$map$1(new Flow[]{flow, flow2, flow3}, function4, (byte) 9);
    }

    public static final Flow debounce(Flow flow, long j) {
        if (j < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Debounce timeout should not be negative");
            return null;
        }
        if (j == 0) {
            return flow;
        }
        return new SafeFlow((byte) 6, new FlowKt__DelayKt$debounceInternal$1(new FlowKt__DelayKt$$ExternalSyntheticLambda0(j), flow, null));
    }

    public static final Flow distinctUntilChanged(Flow flow) {
        return flow instanceof StateFlow ? flow : distinctUntilChangedBy$FlowKt__DistinctKt(flow, defaultKeySelector, defaultAreEquivalent);
    }

    public static final DistinctFlowImpl distinctUntilChangedBy$FlowKt__DistinctKt(Flow flow, Function1 function1, Function2 function2) {
        if (flow instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) flow;
            if (distinctFlowImpl.keySelector == function1 && distinctFlowImpl.areEquivalent == function2) {
                return distinctFlowImpl;
            }
        }
        return new DistinctFlowImpl(flow, function1, function2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final void emitAbort$FlowKt__LimitKt(FlowCollector flowCollector, Object obj, Object obj2, ContinuationImpl continuationImpl) {
        FlowKt__LimitKt$emitAbort$1 flowKt__LimitKt$emitAbort$1;
        if (continuationImpl instanceof FlowKt__LimitKt$emitAbort$1) {
            flowKt__LimitKt$emitAbort$1 = (FlowKt__LimitKt$emitAbort$1) continuationImpl;
            int i = flowKt__LimitKt$emitAbort$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$emitAbort$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__LimitKt$emitAbort$1 = new FlowKt__LimitKt$emitAbort$1(continuationImpl);
            }
        } else {
            flowKt__LimitKt$emitAbort$1 = new FlowKt__LimitKt$emitAbort$1(continuationImpl);
        }
        Object obj3 = flowKt__LimitKt$emitAbort$1.result;
        int i2 = flowKt__LimitKt$emitAbort$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj3);
            flowKt__LimitKt$emitAbort$1.L$2 = obj2;
            flowKt__LimitKt$emitAbort$1.label = 1;
            if (flowCollector.emit(obj, flowKt__LimitKt$emitAbort$1) == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return;
            }
        } else if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return;
        } else {
            obj2 = flowKt__LimitKt$emitAbort$1.L$2;
            ResultKt.throwOnFailure(obj3);
        }
        throw new AbortFlowException(obj2);
    }

    public static final Object emitAll(FlowCollector flowCollector, Flow flow, Continuation continuation) throws Throwable {
        if (flowCollector instanceof ThrowingCollector) {
            throw ((ThrowingCollector) flowCollector).e;
        }
        Object objCollect = flow.collect(flowCollector, continuation);
        return objCollect == CoroutineSingletons.COROUTINE_SUSPENDED ? objCollect : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0066  */
    /* JADX WARN: Code duplicated, block: B:28:0x0067  */
    /* JADX WARN: Code duplicated, block: B:31:0x0073 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x002f, B:25:0x0054, B:29:0x006b, B:31:0x0073, B:20:0x0045, B:24:0x0050), top: B:47:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x008a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x008c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
    
        if (r1.emit(r10, r0) == r5) goto L33;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0087 -> B:14:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object emitAllImpl$FlowKt__ChannelsKt(FlowCollector flowCollector, ReceiveChannel receiveChannel, boolean z, Continuation continuation) throws Throwable {
        FlowKt__ChannelsKt$emitAllImpl$1 flowKt__ChannelsKt$emitAllImpl$1;
        ChannelIterator channelIterator;
        FlowCollector flowCollector2;
        BufferedChannel.BufferedChannelIterator bufferedChannelIterator;
        ChannelIterator it;
        BufferedChannel.BufferedChannelIterator bufferedChannelIterator2;
        Object objHasNext;
        ChannelIterator channelIterator2;
        if (continuation instanceof FlowKt__ChannelsKt$emitAllImpl$1) {
            flowKt__ChannelsKt$emitAllImpl$1 = (FlowKt__ChannelsKt$emitAllImpl$1) continuation;
            int i = flowKt__ChannelsKt$emitAllImpl$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__ChannelsKt$emitAllImpl$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__ChannelsKt$emitAllImpl$1 = new FlowKt__ChannelsKt$emitAllImpl$1(continuation);
            }
        } else {
            flowKt__ChannelsKt$emitAllImpl$1 = new FlowKt__ChannelsKt$emitAllImpl$1(continuation);
        }
        Object obj = flowKt__ChannelsKt$emitAllImpl$1.result;
        int i2 = flowKt__ChannelsKt$emitAllImpl$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if (flowCollector instanceof ThrowingCollector) {
                    throw ((ThrowingCollector) flowCollector).e;
                }
                it = receiveChannel.iterator();
                flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector;
                flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                flowKt__ChannelsKt$emitAllImpl$1.L$2 = it;
                flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z;
                flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                bufferedChannelIterator2 = (BufferedChannel.BufferedChannelIterator) it;
                objHasNext = bufferedChannelIterator2.hasNext(flowKt__ChannelsKt$emitAllImpl$1);
                if (objHasNext == coroutineSingletons) {
                    flowCollector2 = flowCollector;
                    channelIterator = bufferedChannelIterator2;
                    obj = objHasNext;
                    if (!((Boolean) obj).booleanValue()) {
                        if (z) {
                            receiveChannel.cancel((CancellationException) null);
                        }
                        return Unit.INSTANCE;
                    }
                    bufferedChannelIterator = (BufferedChannel.BufferedChannelIterator) channelIterator;
                    Object next = bufferedChannelIterator.next();
                    flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector2;
                    flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                    flowKt__ChannelsKt$emitAllImpl$1.L$2 = bufferedChannelIterator;
                    flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z;
                    flowKt__ChannelsKt$emitAllImpl$1.label = 2;
                }
                channelIterator2 = bufferedChannelIterator;
                return coroutineSingletons;
            }
            if (i2 == 1) {
                z = flowKt__ChannelsKt$emitAllImpl$1.Z$0;
                channelIterator = flowKt__ChannelsKt$emitAllImpl$1.L$2;
                receiveChannel = flowKt__ChannelsKt$emitAllImpl$1.L$1;
                flowCollector2 = flowKt__ChannelsKt$emitAllImpl$1.L$0;
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) obj).booleanValue()) {
                    if (z) {
                        receiveChannel.cancel((CancellationException) null);
                    }
                    return Unit.INSTANCE;
                }
                bufferedChannelIterator = (BufferedChannel.BufferedChannelIterator) channelIterator;
                Object next2 = bufferedChannelIterator.next();
                flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector2;
                flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                flowKt__ChannelsKt$emitAllImpl$1.L$2 = bufferedChannelIterator;
                flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z;
                flowKt__ChannelsKt$emitAllImpl$1.label = 2;
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                z = flowKt__ChannelsKt$emitAllImpl$1.Z$0;
                ChannelIterator channelIterator3 = flowKt__ChannelsKt$emitAllImpl$1.L$2;
                receiveChannel = flowKt__ChannelsKt$emitAllImpl$1.L$1;
                flowCollector2 = flowKt__ChannelsKt$emitAllImpl$1.L$0;
                ResultKt.throwOnFailure(obj);
                channelIterator2 = channelIterator3;
            }
            channelIterator2 = bufferedChannelIterator;
            it = channelIterator2;
            flowCollector = flowCollector2;
            flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector;
            flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
            flowKt__ChannelsKt$emitAllImpl$1.L$2 = it;
            flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z;
            flowKt__ChannelsKt$emitAllImpl$1.label = 1;
            bufferedChannelIterator2 = (BufferedChannel.BufferedChannelIterator) it;
            objHasNext = bufferedChannelIterator2.hasNext(flowKt__ChannelsKt$emitAllImpl$1);
            if (objHasNext == coroutineSingletons) {
                flowCollector2 = flowCollector;
                channelIterator = bufferedChannelIterator2;
                obj = objHasNext;
                if (!((Boolean) obj).booleanValue()) {
                    if (z) {
                        receiveChannel.cancel((CancellationException) null);
                    }
                    return Unit.INSTANCE;
                }
                bufferedChannelIterator = (BufferedChannel.BufferedChannelIterator) channelIterator;
                Object next3 = bufferedChannelIterator.next();
                flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector2;
                flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                flowKt__ChannelsKt$emitAllImpl$1.L$2 = bufferedChannelIterator;
                flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z;
                flowKt__ChannelsKt$emitAllImpl$1.label = 2;
            }
            channelIterator2 = bufferedChannelIterator;
            return coroutineSingletons;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (z) {
                    CharsKt.cancelConsumed(receiveChannel, th);
                }
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x006b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public static final Object first(Flow flow, Function2 function2, ContinuationImpl continuationImpl) {
        FlowKt__ReduceKt$first$3 flowKt__ReduceKt$first$3;
        Ref$ObjectRef ref$ObjectRef;
        AbortFlowException e;
        FlowKt__ReduceKt$first$$inlined$collectWhile$2 flowKt__ReduceKt$first$$inlined$collectWhile$2;
        Joiner joiner = CombineKt.NULL;
        if (continuationImpl instanceof FlowKt__ReduceKt$first$3) {
            flowKt__ReduceKt$first$3 = (FlowKt__ReduceKt$first$3) continuationImpl;
            int i = flowKt__ReduceKt$first$3.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$first$3.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__ReduceKt$first$3 = new FlowKt__ReduceKt$first$3(continuationImpl);
            }
        } else {
            flowKt__ReduceKt$first$3 = new FlowKt__ReduceKt$first$3(continuationImpl);
        }
        Object obj = flowKt__ReduceKt$first$3.result;
        int i2 = flowKt__ReduceKt$first$3.label;
        if (i2 == 0) {
            Ref$ObjectRef ref$ObjectRefM5m = IntIntPair$$ExternalSyntheticOutline0.m5m(obj);
            ref$ObjectRefM5m.element = joiner;
            FlowKt__ReduceKt$first$$inlined$collectWhile$2 flowKt__ReduceKt$first$$inlined$collectWhile$3 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2(function2, ref$ObjectRefM5m, (byte) 0);
            try {
                flowKt__ReduceKt$first$3.L$2 = ref$ObjectRefM5m;
                flowKt__ReduceKt$first$3.L$4 = flowKt__ReduceKt$first$$inlined$collectWhile$3;
                flowKt__ReduceKt$first$3.label = 1;
                Object objCollect = flow.collect(flowKt__ReduceKt$first$$inlined$collectWhile$3, flowKt__ReduceKt$first$3);
                Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objCollect == obj2) {
                    return obj2;
                }
                ref$ObjectRef = ref$ObjectRefM5m;
            } catch (AbortFlowException e2) {
                ref$ObjectRef = ref$ObjectRefM5m;
                e = e2;
                flowKt__ReduceKt$first$$inlined$collectWhile$2 = flowKt__ReduceKt$first$$inlined$collectWhile$3;
                if (e.owner == flowKt__ReduceKt$first$$inlined$collectWhile$2) {
                    throw e;
                }
                AwaitKt.ensureActive(flowKt__ReduceKt$first$3.getContext());
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            flowKt__ReduceKt$first$$inlined$collectWhile$2 = flowKt__ReduceKt$first$3.L$4;
            ref$ObjectRef = flowKt__ReduceKt$first$3.L$2;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                if (e.owner == flowKt__ReduceKt$first$$inlined$collectWhile$2) {
                    throw e;
                }
                AwaitKt.ensureActive(flowKt__ReduceKt$first$3.getContext());
            }
        }
        Object obj3 = ref$ObjectRef.element;
        if (obj3 != joiner) {
            return obj3;
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1("Expected at least one element matching the predicate");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object firstOrNull(Flow flow, Function2 function2, ContinuationImpl continuationImpl) {
        FlowKt__ReduceKt$firstOrNull$3 flowKt__ReduceKt$firstOrNull$3;
        Ref$ObjectRef ref$ObjectRef;
        AbortFlowException e;
        FlowKt__ReduceKt$first$$inlined$collectWhile$2 flowKt__ReduceKt$first$$inlined$collectWhile$2;
        if (continuationImpl instanceof FlowKt__ReduceKt$firstOrNull$3) {
            flowKt__ReduceKt$firstOrNull$3 = (FlowKt__ReduceKt$firstOrNull$3) continuationImpl;
            int i = flowKt__ReduceKt$firstOrNull$3.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$firstOrNull$3.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__ReduceKt$firstOrNull$3 = new FlowKt__ReduceKt$firstOrNull$3(continuationImpl);
            }
        } else {
            flowKt__ReduceKt$firstOrNull$3 = new FlowKt__ReduceKt$firstOrNull$3(continuationImpl);
        }
        Object obj = flowKt__ReduceKt$firstOrNull$3.result;
        int i2 = flowKt__ReduceKt$firstOrNull$3.label;
        byte b = 1;
        if (i2 == 0) {
            Ref$ObjectRef ref$ObjectRefM5m = IntIntPair$$ExternalSyntheticOutline0.m5m(obj);
            FlowKt__ReduceKt$first$$inlined$collectWhile$2 flowKt__ReduceKt$first$$inlined$collectWhile$3 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2(function2, ref$ObjectRefM5m, b);
            try {
                flowKt__ReduceKt$firstOrNull$3.L$2 = ref$ObjectRefM5m;
                flowKt__ReduceKt$firstOrNull$3.L$4 = flowKt__ReduceKt$first$$inlined$collectWhile$3;
                flowKt__ReduceKt$firstOrNull$3.label = 1;
                Object objCollect = flow.collect(flowKt__ReduceKt$first$$inlined$collectWhile$3, flowKt__ReduceKt$firstOrNull$3);
                Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objCollect == obj2) {
                    return obj2;
                }
                ref$ObjectRef = ref$ObjectRefM5m;
            } catch (AbortFlowException e2) {
                ref$ObjectRef = ref$ObjectRefM5m;
                e = e2;
                flowKt__ReduceKt$first$$inlined$collectWhile$2 = flowKt__ReduceKt$first$$inlined$collectWhile$3;
                if (e.owner == flowKt__ReduceKt$first$$inlined$collectWhile$2) {
                    throw e;
                }
                AwaitKt.ensureActive(flowKt__ReduceKt$firstOrNull$3.getContext());
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            flowKt__ReduceKt$first$$inlined$collectWhile$2 = flowKt__ReduceKt$firstOrNull$3.L$4;
            ref$ObjectRef = flowKt__ReduceKt$firstOrNull$3.L$2;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                if (e.owner == flowKt__ReduceKt$first$$inlined$collectWhile$2) {
                    throw e;
                }
                AwaitKt.ensureActive(flowKt__ReduceKt$firstOrNull$3.getContext());
            }
        }
        return ref$ObjectRef.element;
    }

    public static final Flow flowOn(Flow flow, CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.Key.$$INSTANCE) != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$4(coroutineContext, "Flow context cannot contain job in it. Had ");
            return null;
        }
        if (coroutineContext.equals(EmptyCoroutineContext.INSTANCE)) {
            return flow;
        }
        return flow instanceof FusibleFlow ? FusibleFlow.fuse$default((FusibleFlow) flow, coroutineContext, 0, null, 6) : new ChannelFlowOperatorImpl(flow, coroutineContext, 0, null, 12);
    }

    public static final Flow fuseSharedFlow(SharedFlow sharedFlow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return ((i == 0 || i == -3) && bufferOverflow == BufferOverflow.SUSPEND) ? sharedFlow : new ChannelFlowOperatorImpl(sharedFlow, coroutineContext, i, bufferOverflow);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object invokeSafely$FlowKt__EmittersKt(ThrowingCollector throwingCollector, Function3 function3, Throwable th, ContinuationImpl continuationImpl) {
        FlowKt__EmittersKt$invokeSafely$1 flowKt__EmittersKt$invokeSafely$1;
        if (continuationImpl instanceof FlowKt__EmittersKt$invokeSafely$1) {
            flowKt__EmittersKt$invokeSafely$1 = (FlowKt__EmittersKt$invokeSafely$1) continuationImpl;
            int i = flowKt__EmittersKt$invokeSafely$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__EmittersKt$invokeSafely$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__EmittersKt$invokeSafely$1 = new FlowKt__EmittersKt$invokeSafely$1(continuationImpl);
            }
        } else {
            flowKt__EmittersKt$invokeSafely$1 = new FlowKt__EmittersKt$invokeSafely$1(continuationImpl);
        }
        Object obj = flowKt__EmittersKt$invokeSafely$1.result;
        int i2 = flowKt__EmittersKt$invokeSafely$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                flowKt__EmittersKt$invokeSafely$1.L$2 = th;
                flowKt__EmittersKt$invokeSafely$1.label = 1;
                Object objInvoke = function3.invoke(throwingCollector, th, flowKt__EmittersKt$invokeSafely$1);
                Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objInvoke == obj2) {
                    return obj2;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                th = flowKt__EmittersKt$invokeSafely$1.L$2;
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            if (th != null && th != th2) {
                ResultKt.addSuppressed(th2, th);
            }
            throw th2;
        }
    }

    public static final void setBufferAt(Object[] objArr, long j, Object obj) {
        objArr[((int) j) & (objArr.length - 1)] = obj;
    }

    public static final ReadonlyStateFlow stateIn(Flow flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, Object obj) {
        FileLock fileLock;
        ChannelFlow channelFlow;
        Flow flowDropChannelOperators;
        Channel.Factory.getClass();
        Channel.Factory factory = Channel.Factory.$$INSTANCE;
        if (!(flow instanceof ChannelFlow) || (flowDropChannelOperators = (channelFlow = (ChannelFlow) flow).dropChannelOperators()) == null) {
            fileLock = new FileLock(flow, EmptyCoroutineContext.INSTANCE);
        } else {
            if (channelFlow.capacity != -3) {
            }
            fileLock = new FileLock(flowDropChannelOperators, channelFlow.context);
        }
        StateFlowImpl stateFlowImplMutableStateFlow = MutableStateFlow(obj);
        return new ReadonlyStateFlow(stateFlowImplMutableStateFlow, AwaitKt.launch(coroutineScope, (CoroutineContext) fileLock.lockChannel, sharingStarted.equals(SharingStarted.Companion.Eagerly) ? CoroutineStart.DEFAULT : CoroutineStart.UNDISPATCHED, new NavHostKt$NavHost$29$1(sharingStarted, (Flow) fileLock.lockFilename, stateFlowImplMutableStateFlow, obj, (Continuation) null)));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x005c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object firstOrNull(Flow flow, Continuation continuation) {
        FlowKt__ReduceKt$firstOrNull$1 flowKt__ReduceKt$firstOrNull$1;
        Ref$ObjectRef ref$ObjectRefM5m;
        AbortFlowException e;
        FlowKt__ReduceKt$first$$inlined$collectWhile$1 flowKt__ReduceKt$first$$inlined$collectWhile$1;
        if (continuation instanceof FlowKt__ReduceKt$firstOrNull$1) {
            flowKt__ReduceKt$firstOrNull$1 = (FlowKt__ReduceKt$firstOrNull$1) continuation;
            int i = flowKt__ReduceKt$firstOrNull$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$firstOrNull$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__ReduceKt$firstOrNull$1 = new FlowKt__ReduceKt$firstOrNull$1(continuation);
            }
        } else {
            flowKt__ReduceKt$firstOrNull$1 = new FlowKt__ReduceKt$firstOrNull$1(continuation);
        }
        Object obj = flowKt__ReduceKt$firstOrNull$1.result;
        int i2 = flowKt__ReduceKt$firstOrNull$1.label;
        byte b = 1;
        if (i2 == 0) {
            ref$ObjectRefM5m = IntIntPair$$ExternalSyntheticOutline0.m5m(obj);
            FlowKt__ReduceKt$first$$inlined$collectWhile$1 flowKt__ReduceKt$first$$inlined$collectWhile$2 = new FlowKt__ReduceKt$first$$inlined$collectWhile$1(ref$ObjectRefM5m, b);
            try {
                flowKt__ReduceKt$firstOrNull$1.L$1 = ref$ObjectRefM5m;
                flowKt__ReduceKt$firstOrNull$1.L$3 = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                flowKt__ReduceKt$firstOrNull$1.label = 1;
                Object objCollect = flow.collect(flowKt__ReduceKt$first$$inlined$collectWhile$2, flowKt__ReduceKt$firstOrNull$1);
                Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objCollect == obj2) {
                    return obj2;
                }
            } catch (AbortFlowException e2) {
                e = e2;
                flowKt__ReduceKt$first$$inlined$collectWhile$1 = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                if (e.owner == flowKt__ReduceKt$first$$inlined$collectWhile$1) {
                    AwaitKt.ensureActive(flowKt__ReduceKt$firstOrNull$1.getContext());
                } else {
                    throw e;
                }
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            flowKt__ReduceKt$first$$inlined$collectWhile$1 = flowKt__ReduceKt$firstOrNull$1.L$3;
            ref$ObjectRefM5m = flowKt__ReduceKt$firstOrNull$1.L$1;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                if (e.owner == flowKt__ReduceKt$first$$inlined$collectWhile$1) {
                    AwaitKt.ensureActive(flowKt__ReduceKt$firstOrNull$1.getContext());
                } else {
                    throw e;
                }
            }
        }
        return ref$ObjectRefM5m.element;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0057  */
    /* JADX WARN: Code duplicated, block: B:33:0x0069  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public static final Object first(Flow flow, Continuation continuation) {
        FlowKt__ReduceKt$first$1 flowKt__ReduceKt$first$1;
        Ref$ObjectRef ref$ObjectRefM5m;
        AbortFlowException e;
        FlowKt__ReduceKt$first$$inlined$collectWhile$1 flowKt__ReduceKt$first$$inlined$collectWhile$1;
        Joiner joiner = CombineKt.NULL;
        if (continuation instanceof FlowKt__ReduceKt$first$1) {
            flowKt__ReduceKt$first$1 = (FlowKt__ReduceKt$first$1) continuation;
            int i = flowKt__ReduceKt$first$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$first$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__ReduceKt$first$1 = new FlowKt__ReduceKt$first$1(continuation);
            }
        } else {
            flowKt__ReduceKt$first$1 = new FlowKt__ReduceKt$first$1(continuation);
        }
        Object obj = flowKt__ReduceKt$first$1.result;
        int i2 = flowKt__ReduceKt$first$1.label;
        if (i2 == 0) {
            ref$ObjectRefM5m = IntIntPair$$ExternalSyntheticOutline0.m5m(obj);
            ref$ObjectRefM5m.element = joiner;
            FlowKt__ReduceKt$first$$inlined$collectWhile$1 flowKt__ReduceKt$first$$inlined$collectWhile$2 = new FlowKt__ReduceKt$first$$inlined$collectWhile$1(ref$ObjectRefM5m, (byte) 0);
            try {
                flowKt__ReduceKt$first$1.L$1 = ref$ObjectRefM5m;
                flowKt__ReduceKt$first$1.L$3 = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                flowKt__ReduceKt$first$1.label = 1;
                Object objCollect = flow.collect(flowKt__ReduceKt$first$$inlined$collectWhile$2, flowKt__ReduceKt$first$1);
                Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objCollect == obj2) {
                    return obj2;
                }
            } catch (AbortFlowException e2) {
                e = e2;
                flowKt__ReduceKt$first$$inlined$collectWhile$1 = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                if (e.owner == flowKt__ReduceKt$first$$inlined$collectWhile$1) {
                    AwaitKt.ensureActive(flowKt__ReduceKt$first$1.getContext());
                } else {
                    throw e;
                }
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            flowKt__ReduceKt$first$$inlined$collectWhile$1 = flowKt__ReduceKt$first$1.L$3;
            ref$ObjectRefM5m = flowKt__ReduceKt$first$1.L$1;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                if (e.owner == flowKt__ReduceKt$first$$inlined$collectWhile$1) {
                    AwaitKt.ensureActive(flowKt__ReduceKt$first$1.getContext());
                } else {
                    throw e;
                }
            }
        }
        Object obj3 = ref$ObjectRefM5m.element;
        if (obj3 != joiner) {
            return obj3;
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1("Expected at least one element");
        return null;
    }
}
