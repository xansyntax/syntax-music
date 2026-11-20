package kotlinx.coroutines.flow;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.internal.InlineList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class FlowKt__MergeKt {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        InlineList.systemProp("kotlinx.coroutines.flow.defaultConcurrency", 16L, 1L, 2147483647L);
    }

    public static final ChannelFlowTransformLatest transformLatest(Flow flow, Function3 function3) {
        return new ChannelFlowTransformLatest(function3, flow, EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND);
    }
}
