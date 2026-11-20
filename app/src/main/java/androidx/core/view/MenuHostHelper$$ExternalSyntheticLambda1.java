package androidx.core.view;

import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.runtime.MutableState;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MenuHostHelper$$ExternalSyntheticLambda1 implements LifecycleEventObserver {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ MenuHostHelper$$ExternalSyntheticLambda1(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        byte b = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (b) {
            case 0:
                MenuHostHelper menuHostHelper = (MenuHostHelper) obj2;
                MenuProvider menuProvider = (MenuProvider) obj;
                menuHostHelper.getClass();
                if (event == Lifecycle.Event.ON_DESTROY) {
                    menuHostHelper.removeMenuProvider(menuProvider);
                }
                break;
            case 1:
                ComponentActivity.addObserverForBackInvoker$lambda$0((OnBackPressedDispatcher) obj2, (ComponentActivity) obj, lifecycleOwner, event);
                break;
            default:
                ((MutableState) obj).setValue(Boolean.valueOf(((LifecycleRegistry) ((Lifecycle) obj2)).state.compareTo(Lifecycle.State.STARTED) >= 0));
                break;
        }
    }
}
