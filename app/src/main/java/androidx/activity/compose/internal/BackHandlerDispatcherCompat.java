package androidx.activity.compose.internal;

import androidx.activity.OnBackPressedCallback$OnBackPressedEventHandler;
import androidx.activity.OnBackPressedCallbackInfo;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.fragment.app.FragmentManager;
import androidx.navigationevent.NavigationEventDispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BackHandlerDispatcherCompat {
    public final NavigationEventDispatcher navigationEventDispatcher;
    public final OnBackPressedDispatcher onBackPressedDispatcher;

    public BackHandlerDispatcherCompat(NavigationEventDispatcher navigationEventDispatcher, OnBackPressedDispatcher onBackPressedDispatcher) {
        this.navigationEventDispatcher = navigationEventDispatcher;
        this.onBackPressedDispatcher = onBackPressedDispatcher;
        if ((navigationEventDispatcher == null ? onBackPressedDispatcher : navigationEventDispatcher) != null) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("At least one dispatcher (NavigationEventDispatcher or OnBackPressedDispatcher) must be non-null.");
        throw null;
    }

    public final void addHandler(BaseMenuWrapper baseMenuWrapper) {
        NavigationEventDispatcher navigationEventDispatcher = this.navigationEventDispatcher;
        if (navigationEventDispatcher != null) {
            NavigationEventDispatcher.addHandler$default(navigationEventDispatcher, (BackHandlerCompat$navigationEventHandler$1) baseMenuWrapper.mMenuItems);
            return;
        }
        OnBackPressedDispatcher onBackPressedDispatcher = this.onBackPressedDispatcher;
        if (onBackPressedDispatcher == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Unreachable");
            return;
        }
        FragmentManager.AnonymousClass1 anonymousClass1 = (FragmentManager.AnonymousClass1) baseMenuWrapper.mContext;
        anonymousClass1.getClass();
        OnBackPressedCallback$OnBackPressedEventHandler onBackPressedCallback$OnBackPressedEventHandler = new OnBackPressedCallback$OnBackPressedEventHandler(anonymousClass1, new OnBackPressedCallbackInfo(anonymousClass1, null));
        anonymousClass1.eventHandlers.add(onBackPressedCallback$OnBackPressedEventHandler);
        NavigationEventDispatcher.addHandler$default(onBackPressedDispatcher.getEventInput().dispatcher, onBackPressedCallback$OnBackPressedEventHandler);
    }

    public final void removeHandler(BaseMenuWrapper baseMenuWrapper) throws Exception {
        if (this.navigationEventDispatcher != null) {
            ((BackHandlerCompat$navigationEventHandler$1) baseMenuWrapper.mMenuItems).remove();
        } else if (this.onBackPressedDispatcher != null) {
            ((FragmentManager.AnonymousClass1) baseMenuWrapper.mContext).remove();
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Unreachable");
        }
    }
}
