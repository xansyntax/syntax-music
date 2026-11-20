package okhttp3.internal.dns;

import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.Dns;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskRunner;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class LookupDnsCall extends Task {
    public final Dns delegate;
    public final Dns.Request request;
    public final AtomicReference state;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface State {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Idle implements State {
            public static final Idle INSTANCE$1 = new Idle();
            public static final Idle INSTANCE = new Idle();
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public abstract class Running implements State {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LookupDnsCall(TaskRunner taskRunner, Dns dns, Dns.Request request) {
        super(request.hostname.concat(" dns"), false);
        taskRunner.getClass();
        this.delegate = dns;
        this.request = request;
        this.state = new AtomicReference(State.Idle.INSTANCE);
    }

    @Override // okhttp3.internal.concurrent.Task
    public final long runOnce() {
        Object obj;
        State.Idle idle = State.Idle.INSTANCE$1;
        AtomicReference atomicReference = this.state;
        try {
            this.delegate.lookup(this.request.hostname);
            loop0: while (true) {
                obj = atomicReference.get();
                State state = (State) obj;
                state.getClass();
                if (!(state instanceof State.Running)) {
                    break;
                }
                do {
                    if (atomicReference.compareAndSet(obj, idle)) {
                        break loop0;
                    }
                } while (atomicReference.get() == obj);
            }
            return -1L;
        } catch (UnknownHostException unused) {
            while (true) {
                Object obj2 = atomicReference.get();
                State state2 = (State) obj2;
                state2.getClass();
                if (!(state2 instanceof State.Running)) {
                    return -1L;
                }
                while (!atomicReference.compareAndSet(obj2, idle)) {
                    if (atomicReference.get() != obj2) {
                    }
                }
                return -1L;
            }
        }
    }
}
