package androidx.activity;

import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.compose.ui.window.DialogWrapper$$ExternalSyntheticLambda0;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavHostController;
import androidx.navigationevent.NavigationEvent;
import androidx.navigationevent.NavigationEventHandler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedCallback$OnBackPressedEventHandler extends NavigationEventHandler {
    public boolean isLifecycleActive;
    public final FragmentManager.AnonymousClass1 onBackPressedCallback;

    public OnBackPressedCallback$OnBackPressedEventHandler(FragmentManager.AnonymousClass1 anonymousClass1, OnBackPressedCallbackInfo onBackPressedCallbackInfo) {
        boolean z = anonymousClass1.isEnabled;
        this.currentInfo = onBackPressedCallbackInfo;
        this.isBackEnabled = z;
        this.onBackPressedCallback = anonymousClass1;
        this.isLifecycleActive = true;
    }

    @Override // androidx.navigationevent.NavigationEventHandler
    public final void onBackCancelled() {
        FragmentManager.AnonymousClass1 anonymousClass1 = this.onBackPressedCallback;
        switch (anonymousClass1.$r8$classId) {
            case 2:
                ((BaseMenuWrapper) anonymousClass1.this$0).onBackCancelled();
                break;
        }
    }

    @Override // androidx.navigationevent.NavigationEventHandler
    public final void onBackCompleted() {
        FragmentManager.AnonymousClass1 anonymousClass1 = this.onBackPressedCallback;
        switch (anonymousClass1.$r8$classId) {
            case 0:
                FragmentManager fragmentManager = (FragmentManager) anonymousClass1.this$0;
                fragmentManager.execPendingActions(true);
                if (!fragmentManager.mOnBackPressedCallback.isEnabled) {
                    fragmentManager.mOnBackPressedDispatcher.getEventInput().dispatchOnBackCompleted();
                } else {
                    fragmentManager.popBackStackImmediate();
                }
                break;
            case 1:
                ((DialogWrapper$$ExternalSyntheticLambda0) anonymousClass1.this$0).invoke(anonymousClass1);
                break;
            case 2:
                ((BaseMenuWrapper) anonymousClass1.this$0).onBackCompleted();
                break;
            default:
                ((NavHostController) anonymousClass1.this$0).popBackStack();
                break;
        }
    }

    @Override // androidx.navigationevent.NavigationEventHandler
    public final void onBackProgressed(NavigationEvent navigationEvent) {
        BackEventCompat backEventCompat = new BackEventCompat(navigationEvent);
        FragmentManager.AnonymousClass1 anonymousClass1 = this.onBackPressedCallback;
        switch (anonymousClass1.$r8$classId) {
            case 2:
                ((BaseMenuWrapper) anonymousClass1.this$0).onBackProgressed(backEventCompat);
                break;
        }
    }

    @Override // androidx.navigationevent.NavigationEventHandler
    public final void onBackStarted(NavigationEvent navigationEvent) {
        navigationEvent.getClass();
        new BackEventCompat(navigationEvent);
        FragmentManager.AnonymousClass1 anonymousClass1 = this.onBackPressedCallback;
        switch (anonymousClass1.$r8$classId) {
            case 2:
                ((BaseMenuWrapper) anonymousClass1.this$0).onBackStarted();
                break;
        }
    }

    public final void setLifecycleActive(boolean z) {
        this.isLifecycleActive = z;
        setBackEnabled(z && this.onBackPressedCallback.isEnabled);
    }
}
