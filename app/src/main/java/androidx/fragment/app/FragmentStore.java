package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentStore implements CancellationSignal.OnCancelListener {
    public final Object mActive;
    public final Object mAdded;
    public Object mNonConfig;
    public final Object mSavedState;

    public FragmentStore() {
        this.mAdded = new ArrayList();
        this.mActive = new HashMap();
        this.mSavedState = new HashMap();
    }

    public void addFragment(Fragment fragment) {
        if (((ArrayList) this.mAdded).contains(fragment)) {
            PathKt$$ExternalSyntheticBUOutline0.m$1(fragment, "Fragment already added: ");
            return;
        }
        synchronized (((ArrayList) this.mAdded)) {
            ((ArrayList) this.mAdded).add(fragment);
        }
        fragment.mAdded = true;
    }

    public Fragment findActiveFragment(String str) {
        FragmentStateManager fragmentStateManager = (FragmentStateManager) ((HashMap) this.mActive).get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager.mFragment;
        }
        return null;
    }

    public Fragment findFragmentByWho(String str) {
        Fragment fragmentFindFragmentByWho;
        for (FragmentStateManager fragmentStateManager : ((HashMap) this.mActive).values()) {
            if (fragmentStateManager != null && (fragmentFindFragmentByWho = fragmentStateManager.mFragment.findFragmentByWho(str)) != null) {
                return fragmentFindFragmentByWho;
            }
        }
        return null;
    }

    public ArrayList getActiveFragmentStateManagers() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager fragmentStateManager : ((HashMap) this.mActive).values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager);
            }
        }
        return arrayList;
    }

    public ArrayList getActiveFragments() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager fragmentStateManager : ((HashMap) this.mActive).values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager.mFragment);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public List getFragments() {
        ArrayList arrayList;
        if (((ArrayList) this.mAdded).isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (((ArrayList) this.mAdded)) {
            arrayList = new ArrayList((ArrayList) this.mAdded);
        }
        return arrayList;
    }

    public void makeActive(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.mFragment;
        String str = fragment.mWho;
        HashMap map = (HashMap) this.mActive;
        if (map.get(str) != null) {
            return;
        }
        map.put(fragment.mWho, fragmentStateManager);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            boolean z = fragment.mRetainInstance;
            FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) this.mNonConfig;
            if (z) {
                fragmentManagerViewModel.addRetainedFragment(fragment);
            } else {
                fragmentManagerViewModel.removeRetainedFragment(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            fragment.toString();
        }
    }

    public void makeInactive(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.mFragment;
        if (fragment.mRetainInstance) {
            ((FragmentManagerViewModel) this.mNonConfig).removeRetainedFragment(fragment);
        }
        if (((FragmentStateManager) ((HashMap) this.mActive).put(fragment.mWho, null)) != null && FragmentManager.isLoggingEnabled(2)) {
            fragment.toString();
        }
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        View view = (View) this.mAdded;
        view.clearAnimation();
        ((ViewGroup) this.mActive).endViewTransition(view);
        ((DefaultSpecialEffectsController.AnimationInfo) this.mSavedState).completeSpecialEffect();
        if (FragmentManager.isLoggingEnabled(2)) {
            Objects.toString((SpecialEffectsController$FragmentStateManagerOperation) this.mNonConfig);
        }
    }

    public FragmentStore(View view, ViewGroup viewGroup, DefaultSpecialEffectsController.AnimationInfo animationInfo, SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation) {
        this.mAdded = view;
        this.mActive = viewGroup;
        this.mSavedState = animationInfo;
        this.mNonConfig = specialEffectsController$FragmentStateManagerOperation;
    }
}
