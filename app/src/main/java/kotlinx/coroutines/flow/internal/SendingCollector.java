package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class SendingCollector implements FlowCollector {
    public final SendChannel channel;

    public SendingCollector(ProducerScope producerScope) {
        this.channel = producerScope;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        Object objSend = this.channel.send(obj, continuation);
        return objSend == CoroutineSingletons.COROUTINE_SUSPENDED ? objSend : Unit.INSTANCE;
    }
}
