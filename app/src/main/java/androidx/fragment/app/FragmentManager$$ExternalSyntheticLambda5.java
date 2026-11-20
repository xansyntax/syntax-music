package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FragmentManager$$ExternalSyntheticLambda5 implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ FragmentManager$$ExternalSyntheticLambda5(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        byte b = this.$r8$classId;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                return ((FragmentManager) obj).saveAllStateInternal();
            default:
                FragmentActivity fragmentActivity = (FragmentActivity) obj;
                fragmentActivity.markFragmentsCreated();
                fragmentActivity.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
                return new Bundle();
        }
    }
}
