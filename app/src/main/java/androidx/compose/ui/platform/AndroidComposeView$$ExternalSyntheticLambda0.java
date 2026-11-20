package androidx.compose.ui.platform;

import android.os.Handler;
import android.os.Looper;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.window.PopupLayout$$ExternalSyntheticLambda5;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidComposeView$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ AndroidComposeView f$0;

    public /* synthetic */ AndroidComposeView$$ExternalSyntheticLambda0(AndroidComposeView androidComposeView, byte b) {
        this.$r8$classId = b;
        this.f$0 = androidComposeView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        AndroidComposeView androidComposeView = this.f$0;
        switch (b) {
            case 0:
                return new AndroidPlatformTextInputSession(androidComposeView, androidComposeView.getTextInputService(), (CoroutineScope) obj);
            case 1:
                Function0 function0 = (Function0) obj;
                Handler handler = androidComposeView.getHandler();
                if ((handler != null ? handler.getLooper() : null) == Looper.myLooper()) {
                    function0.invoke();
                } else {
                    Handler handler2 = androidComposeView.getHandler();
                    if (handler2 != null) {
                        handler2.post(new PopupLayout$$ExternalSyntheticLambda5(function0, (byte) 2));
                    }
                }
                return unit;
            case 2:
                ((FocusOwnerImpl) androidComposeView.getFocusOwner()).m412moveFocusaToIllA(((FocusDirection) obj).value, false);
                return unit;
            case 3:
                return androidComposeView.getSavedStateRegistry();
            case 4:
                return Boolean.valueOf(androidComposeView.getScrollCaptureInProgress());
            case 5:
                return androidComposeView.getInputModeManager();
            case 6:
                return androidComposeView.getTextInputService();
            case 7:
                return androidComposeView.getSoftwareKeyboardController();
            case 8:
                return androidComposeView.getTextToolbar();
            default:
                return androidComposeView.getPointerIconService();
        }
    }
}
