package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.Segment;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelSegment extends Segment {
    public final BufferedChannel _channel;
    public final /* synthetic */ AtomicReferenceArray data;

    public ChannelSegment(long j, ChannelSegment channelSegment, BufferedChannel bufferedChannel, int i) {
        super(j, channelSegment, i);
        this._channel = bufferedChannel;
        this.data = new AtomicReferenceArray(BufferedChannelKt.SEGMENT_SIZE * 2);
    }

    public final boolean casState$kotlinx_coroutines_core(int i, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray;
        int i2 = (i * 2) + 1;
        do {
            atomicReferenceArray = this.data;
            if (atomicReferenceArray.compareAndSet(i2, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceArray.get(i2) == obj);
        return false;
    }

    @Override // kotlinx.coroutines.internal.Segment
    public final int getNumberOfSlots() {
        return BufferedChannelKt.SEGMENT_SIZE;
    }

    public final Object getState$kotlinx_coroutines_core(int i) {
        return this.data.get((i * 2) + 1);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public final void onCancellation(int i, CoroutineContext coroutineContext) {
        BufferedChannel bufferedChannel;
        int i2 = BufferedChannelKt.SEGMENT_SIZE;
        boolean z = i >= i2;
        if (z) {
            i -= i2;
        }
        Object obj = this.data.get(i * 2);
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core(i);
            boolean z2 = state$kotlinx_coroutines_core instanceof Waiter;
            bufferedChannel = this._channel;
            if (z2 || (state$kotlinx_coroutines_core instanceof WaiterEB)) {
                if (casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, z ? BufferedChannelKt.INTERRUPTED_SEND : BufferedChannelKt.INTERRUPTED_RCV)) {
                    setElementLazy(i, null);
                    onCancelledRequest(i, !z);
                    if (z) {
                        bufferedChannel.getClass();
                        Function1 function1 = bufferedChannel.onUndeliveredElement;
                        if (function1 != null) {
                            InlineList.callUndeliveredElement(function1, obj, coroutineContext);
                            return;
                        }
                        return;
                    }
                    return;
                }
            } else {
                if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND || state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_RCV) {
                    break;
                }
                if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_EB && state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_RCV) {
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED || state$kotlinx_coroutines_core == BufferedChannelKt.CHANNEL_CLOSED) {
                        return;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$3(state$kotlinx_coroutines_core, "unexpected state: ");
                    return;
                }
            }
        }
        setElementLazy(i, null);
        if (z) {
            bufferedChannel.getClass();
            Function1 function2 = bufferedChannel.onUndeliveredElement;
            if (function2 != null) {
                InlineList.callUndeliveredElement(function2, obj, coroutineContext);
            }
        }
    }

    public final void onCancelledRequest(int i, boolean z) {
        if (z) {
            BufferedChannel bufferedChannel = this._channel;
            bufferedChannel.getClass();
            bufferedChannel.waitExpandBufferCompletion$kotlinx_coroutines_core((this.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i));
        }
        onSlotCleaned();
    }

    public final void setElementLazy(int i, Object obj) {
        this.data.set(i * 2, obj);
    }

    public final void setState$kotlinx_coroutines_core(int i, Object obj) {
        this.data.set((i * 2) + 1, obj);
    }
}
