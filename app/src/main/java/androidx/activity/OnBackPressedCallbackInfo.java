package androidx.activity;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import coil3.util.UtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedCallbackInfo extends UtilsKt {
    public final FragmentManager.AnonymousClass1 callback;
    public final LifecycleOwner owner;

    public OnBackPressedCallbackInfo(FragmentManager.AnonymousClass1 anonymousClass1, LifecycleOwner lifecycleOwner) {
        anonymousClass1.getClass();
        this.callback = anonymousClass1;
        this.owner = lifecycleOwner;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnBackPressedCallbackInfo)) {
            return false;
        }
        OnBackPressedCallbackInfo onBackPressedCallbackInfo = (OnBackPressedCallbackInfo) obj;
        return Intrinsics.areEqual(this.callback, onBackPressedCallbackInfo.callback) && Intrinsics.areEqual(this.owner, onBackPressedCallbackInfo.owner);
    }

    public final int hashCode() {
        int iHashCode = this.callback.hashCode() * 31;
        LifecycleOwner lifecycleOwner = this.owner;
        return iHashCode + (lifecycleOwner == null ? 0 : lifecycleOwner.hashCode());
    }

    public final String toString() {
        return "OnBackPressedCallbackInfo(callback=" + this.callback + ", owner=" + this.owner + ')';
    }
}
