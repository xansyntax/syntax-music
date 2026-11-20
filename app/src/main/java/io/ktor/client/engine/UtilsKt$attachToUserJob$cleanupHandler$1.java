package io.ktor.client.engine;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 176)
public final class UtilsKt$attachToUserJob$cleanupHandler$1 implements Function1 {
    final /* synthetic */ Job $callJob;

    public UtilsKt$attachToUserJob$cleanupHandler$1(Job job) {
        this.$callJob = job;
    }

    public final void invoke(Throwable th) {
        if (th == null) {
            return;
        }
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            cancellationException = new CancellationException(th.getMessage());
        }
        this.$callJob.cancel(cancellationException);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }
}
