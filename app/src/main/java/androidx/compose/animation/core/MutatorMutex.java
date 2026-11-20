package androidx.compose.animation.core;

import coil3.network.NetworkFetcher$doFetch$fetchResult$1;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MutatorMutex {
    public final AtomicReference currentMutator = new AtomicReference(null);
    public final MutexImpl mutex = new MutexImpl();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Mutator {
        public final Job job;

        public Mutator(Job job) {
            this.job = job;
        }
    }

    public static Object mutate$default(MutatorMutex mutatorMutex, Function1 function1, Continuation continuation) {
        mutatorMutex.getClass();
        return AwaitKt.coroutineScope(new NetworkFetcher$doFetch$fetchResult$1(mutatorMutex, function1, null), continuation);
    }
}
