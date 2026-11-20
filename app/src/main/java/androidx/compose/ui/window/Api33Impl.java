package androidx.compose.ui.window;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Api33Impl {
    public static final void maybeRegisterBackCallback(PopupLayout popupLayout, Object obj) {
        OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
        if (!(obj instanceof OnBackInvokedCallback) || (onBackInvokedDispatcherFindOnBackInvokedDispatcher = popupLayout.findOnBackInvokedDispatcher()) == null) {
            return;
        }
        onBackInvokedDispatcherFindOnBackInvokedDispatcher.registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj);
    }

    public static final void maybeUnregisterBackCallback(PopupLayout popupLayout, Api33Impl$$ExternalSyntheticLambda0 api33Impl$$ExternalSyntheticLambda0) {
        OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
        if (api33Impl$$ExternalSyntheticLambda0 == null || (onBackInvokedDispatcherFindOnBackInvokedDispatcher = popupLayout.findOnBackInvokedDispatcher()) == null) {
            return;
        }
        onBackInvokedDispatcherFindOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(api33Impl$$ExternalSyntheticLambda0);
    }
}
