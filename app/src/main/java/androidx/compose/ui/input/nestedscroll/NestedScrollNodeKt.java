package androidx.compose.ui.input.nestedscroll;

import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NestedScrollNodeKt {
    public static final TextKt$$ExternalSyntheticLambda3 CancelledNestedScope = new TextKt$$ExternalSyntheticLambda3(21);
    public static final ContextScope CancelledScope;

    static {
        ContextScope contextScopeCoroutineScope = AwaitKt.CoroutineScope(EmptyCoroutineContext.INSTANCE);
        AwaitKt.cancel(contextScopeCoroutineScope, (CancellationException) null);
        CancelledScope = contextScopeCoroutineScope;
    }
}
