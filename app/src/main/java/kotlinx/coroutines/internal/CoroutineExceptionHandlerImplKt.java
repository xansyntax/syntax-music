package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.List;
import java.util.ServiceConfigurationError;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.android.AndroidExceptionPreHandler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CoroutineExceptionHandlerImplKt {
    public static final List platformExceptionHandlers;

    static {
        try {
            platformExceptionHandlers = SequencesKt.toList(SequencesKt.asSequence(Arrays.asList(new AndroidExceptionPreHandler()).iterator()));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
