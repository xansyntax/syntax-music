package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.text.TextRange;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HandwritingGestureApi34$$ExternalSyntheticLambda0 implements CancellationSignal.OnCancelListener {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ HandwritingGestureApi34$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    @Override // android.os.CancellationSignal.OnCancelListener
    public final void onCancel() {
        byte b = this.$r8$classId;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) obj;
                if (textFieldSelectionManager != null) {
                    LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
                    if (legacyTextFieldState != null) {
                        legacyTextFieldState.m198setDeletionPreviewHighlightRange5zctL8(TextRange.Zero);
                    }
                    LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager.state;
                    if (legacyTextFieldState2 != null) {
                        legacyTextFieldState2.m199setSelectionPreviewHighlightRange5zctL8(TextRange.Zero);
                    }
                }
                break;
            default:
                ((StandaloneCoroutine) obj).cancel(null);
                break;
        }
    }
}
