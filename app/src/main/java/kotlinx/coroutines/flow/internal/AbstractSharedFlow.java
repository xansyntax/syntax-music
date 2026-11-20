package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.StateFlowSlot;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractSharedFlow {
    public SubscriptionCountStateFlow _subscriptionCount;
    public int nCollectors;
    public int nextIndex;
    public AbstractSharedFlowSlot[] slots;

    public final AbstractSharedFlowSlot allocateSlot() {
        AbstractSharedFlowSlot abstractSharedFlowSlotCreateSlot;
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            try {
                AbstractSharedFlowSlot[] abstractSharedFlowSlotArrCreateSlotArray = this.slots;
                if (abstractSharedFlowSlotArrCreateSlotArray == null) {
                    abstractSharedFlowSlotArrCreateSlotArray = createSlotArray();
                    this.slots = abstractSharedFlowSlotArrCreateSlotArray;
                } else if (this.nCollectors >= abstractSharedFlowSlotArrCreateSlotArray.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(abstractSharedFlowSlotArrCreateSlotArray, abstractSharedFlowSlotArrCreateSlotArray.length * 2);
                    this.slots = (AbstractSharedFlowSlot[]) objArrCopyOf;
                    abstractSharedFlowSlotArrCreateSlotArray = (AbstractSharedFlowSlot[]) objArrCopyOf;
                }
                int i = this.nextIndex;
                do {
                    abstractSharedFlowSlotCreateSlot = abstractSharedFlowSlotArrCreateSlotArray[i];
                    if (abstractSharedFlowSlotCreateSlot == null) {
                        abstractSharedFlowSlotCreateSlot = createSlot();
                        abstractSharedFlowSlotArrCreateSlotArray[i] = abstractSharedFlowSlotCreateSlot;
                    }
                    i++;
                    if (i >= abstractSharedFlowSlotArrCreateSlotArray.length) {
                        i = 0;
                    }
                } while (!abstractSharedFlowSlotCreateSlot.allocateLocked(this));
                this.nextIndex = i;
                this.nCollectors++;
                subscriptionCountStateFlow = this._subscriptionCount;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (subscriptionCountStateFlow != null) {
            subscriptionCountStateFlow.increment(1);
        }
        return abstractSharedFlowSlotCreateSlot;
    }

    public AbstractSharedFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    public AbstractSharedFlowSlot[] createSlotArray() {
        return new StateFlowSlot[2];
    }

    public final void freeSlot(AbstractSharedFlowSlot abstractSharedFlowSlot) {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        int i;
        Continuation[] continuationArrFreeLocked;
        synchronized (this) {
            try {
                int i2 = this.nCollectors - 1;
                this.nCollectors = i2;
                subscriptionCountStateFlow = this._subscriptionCount;
                if (i2 == 0) {
                    this.nextIndex = 0;
                }
                abstractSharedFlowSlot.getClass();
                continuationArrFreeLocked = abstractSharedFlowSlot.freeLocked(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation continuation : continuationArrFreeLocked) {
            if (continuation != null) {
                continuation.resumeWith(Unit.INSTANCE);
            }
        }
        if (subscriptionCountStateFlow != null) {
            subscriptionCountStateFlow.increment(-1);
        }
    }

    public final SubscriptionCountStateFlow getSubscriptionCount() {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            subscriptionCountStateFlow = this._subscriptionCount;
            if (subscriptionCountStateFlow == null) {
                int i = this.nCollectors;
                subscriptionCountStateFlow = new SubscriptionCountStateFlow(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);
                subscriptionCountStateFlow.tryEmit(Integer.valueOf(i));
                this._subscriptionCount = subscriptionCountStateFlow;
            }
        }
        return subscriptionCountStateFlow;
    }
}
