package androidx.compose.material3;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.NotCompleted;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SnackbarKt$$ExternalSyntheticLambda3 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SnackbarHostState.SnackbarDataImpl f$0;

    public /* synthetic */ SnackbarKt$$ExternalSyntheticLambda3(SnackbarHostState.SnackbarDataImpl snackbarDataImpl, byte b) {
        this.$r8$classId = b;
        this.f$0 = snackbarDataImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        SnackbarHostState.SnackbarDataImpl snackbarDataImpl = this.f$0;
        switch (b) {
            case 0:
                CancellableContinuationImpl cancellableContinuationImpl = snackbarDataImpl.continuation;
                if (cancellableContinuationImpl.getState$kotlinx_coroutines_core() instanceof NotCompleted) {
                    cancellableContinuationImpl.resumeWith(SnackbarResult.ActionPerformed);
                }
                return Unit.INSTANCE;
            default:
                CancellableContinuationImpl cancellableContinuationImpl2 = snackbarDataImpl.continuation;
                if (cancellableContinuationImpl2.getState$kotlinx_coroutines_core() instanceof NotCompleted) {
                    cancellableContinuationImpl2.resumeWith(SnackbarResult.Dismissed);
                }
                return Boolean.TRUE;
        }
    }
}
