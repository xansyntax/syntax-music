package androidx.compose.ui.window;

import android.window.OnBackInvokedCallback;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.Toolbar$$ExternalSyntheticLambda0;
import androidx.navigationevent.OnBackInvokedInput;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Api33Impl$$ExternalSyntheticLambda0 implements OnBackInvokedCallback {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Api33Impl$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    public final void onBackInvoked() {
        byte b = this.$r8$classId;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                Function0 function0 = (Function0) obj;
                if (function0 != null) {
                    function0.invoke();
                }
                break;
            case 1:
                ((AppCompatDelegateImpl) obj).onBackPressed();
                break;
            case 2:
                ((Toolbar$$ExternalSyntheticLambda0) obj).run();
                break;
            default:
                ((OnBackInvokedInput) obj).dispatchOnBackCompleted();
                break;
        }
    }
}
