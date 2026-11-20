package kotlinx.coroutines;

import com.google.common.base.Joiner;
import kotlin.Deprecated;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public interface CancellableContinuation extends Continuation {
    boolean cancel(Throwable th);

    void completeResume(Object obj);

    boolean isCancelled();

    @Deprecated
    void resume(Object obj, Function1 function1);

    <R> void resume(R r, Function3 function3);

    Joiner tryResume(Object obj, Function3 function3);
}
