package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.R$styleable;
import androidx.fragment.app.strictmode.FragmentReuseViolation;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {
    public final FragmentManager mFragmentManager;

    public FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        int i;
        final FragmentStateManager fragmentStateManagerCreateOrGetFragmentStateManager;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        FragmentManager fragmentManager = this.mFragmentManager;
        if (zEquals) {
            return new FragmentContainerView(context, attributeSet, fragmentManager);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Fragment);
            if (attributeValue == null) {
                attributeValue = typedArrayObtainStyledAttributes.getString(0);
            }
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
            int i2 = 2;
            String string = typedArrayObtainStyledAttributes.getString(2);
            typedArrayObtainStyledAttributes.recycle();
            if (attributeValue != null) {
                try {
                    zIsAssignableFrom = Fragment.class.isAssignableFrom(FragmentManager.AnonymousClass3.loadClass(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    zIsAssignableFrom = false;
                }
                if (zIsAssignableFrom) {
                    int id = view != null ? view.getId() : 0;
                    if (id == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    Fragment fragmentFindFragmentById = resourceId != -1 ? fragmentManager.findFragmentById(resourceId) : null;
                    if (fragmentFindFragmentById == null && string != null) {
                        FragmentStore fragmentStore = fragmentManager.mFragmentStore;
                        ArrayList arrayList = (ArrayList) fragmentStore.mAdded;
                        int size = arrayList.size() - 1;
                        while (true) {
                            if (size < 0) {
                                i = i2;
                                Iterator it = ((HashMap) fragmentStore.mActive).values().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        fragmentFindFragmentById = null;
                                        break;
                                    }
                                    FragmentStateManager fragmentStateManager = (FragmentStateManager) it.next();
                                    if (fragmentStateManager != null) {
                                        Fragment fragment = fragmentStateManager.mFragment;
                                        if (string.equals(fragment.mTag)) {
                                            fragmentFindFragmentById = fragment;
                                            break;
                                        }
                                    }
                                }
                            } else {
                                Fragment fragment2 = (Fragment) arrayList.get(size);
                                i = i2;
                                if (fragment2 != null && string.equals(fragment2.mTag)) {
                                    fragmentFindFragmentById = fragment2;
                                    break;
                                }
                                size--;
                                i2 = i;
                            }
                        }
                    } else {
                        i = 2;
                    }
                    if (fragmentFindFragmentById == null && id != -1) {
                        fragmentFindFragmentById = fragmentManager.findFragmentById(id);
                    }
                    if (fragmentFindFragmentById == null) {
                        FragmentManager.AnonymousClass3 fragmentFactory = fragmentManager.getFragmentFactory();
                        context.getClassLoader();
                        fragmentFindFragmentById = Fragment.instantiate(FragmentManager.this.mHost.mContext, attributeValue, null);
                        fragmentFindFragmentById.mFromLayout = true;
                        fragmentFindFragmentById.mFragmentId = resourceId != 0 ? resourceId : id;
                        fragmentFindFragmentById.mContainerId = id;
                        fragmentFindFragmentById.mTag = string;
                        fragmentFindFragmentById.mInLayout = true;
                        fragmentFindFragmentById.mFragmentManager = fragmentManager;
                        FragmentHostCallback fragmentHostCallback = fragmentManager.mHost;
                        fragmentFindFragmentById.mHost = fragmentHostCallback;
                        fragmentFindFragmentById.onInflate(fragmentHostCallback.mContext, attributeSet, fragmentFindFragmentById.mSavedFragmentState);
                        fragmentStateManagerCreateOrGetFragmentStateManager = fragmentManager.addFragment(fragmentFindFragmentById);
                        if (FragmentManager.isLoggingEnabled(i)) {
                            fragmentFindFragmentById.toString();
                            Integer.toHexString(resourceId);
                        }
                    } else {
                        if (fragmentFindFragmentById.mInLayout) {
                            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                        }
                        fragmentFindFragmentById.mInLayout = true;
                        fragmentFindFragmentById.mFragmentManager = fragmentManager;
                        FragmentHostCallback fragmentHostCallback2 = fragmentManager.mHost;
                        fragmentFindFragmentById.mHost = fragmentHostCallback2;
                        fragmentFindFragmentById.onInflate(fragmentHostCallback2.mContext, attributeSet, fragmentFindFragmentById.mSavedFragmentState);
                        fragmentStateManagerCreateOrGetFragmentStateManager = fragmentManager.createOrGetFragmentStateManager(fragmentFindFragmentById);
                        if (FragmentManager.isLoggingEnabled(i)) {
                            fragmentFindFragmentById.toString();
                            Integer.toHexString(resourceId);
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
                    FragmentStrictMode.logIfDebuggingEnabled(new FragmentReuseViolation(fragmentFindFragmentById, "Attempting to use <fragment> tag to add fragment " + fragmentFindFragmentById + " to container " + viewGroup));
                    FragmentStrictMode.getNearestPolicy(fragmentFindFragmentById).getClass();
                    fragmentFindFragmentById.mContainer = viewGroup;
                    fragmentStateManagerCreateOrGetFragmentStateManager.moveToExpectedState();
                    fragmentStateManagerCreateOrGetFragmentStateManager.ensureInflatedView();
                    View view2 = fragmentFindFragmentById.mView;
                    if (view2 == null) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(IntIntPair$$ExternalSyntheticOutline0.m("Fragment ", attributeValue, " did not create a view."));
                        return null;
                    }
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (fragmentFindFragmentById.mView.getTag() == null) {
                        fragmentFindFragmentById.mView.setTag(string);
                    }
                    fragmentFindFragmentById.mView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.FragmentLayoutInflaterFactory.1
                        @Override // android.view.View.OnAttachStateChangeListener
                        public final void onViewAttachedToWindow(View view3) {
                            FragmentStateManager fragmentStateManager2 = fragmentStateManagerCreateOrGetFragmentStateManager;
                            Fragment fragment3 = fragmentStateManager2.mFragment;
                            fragmentStateManager2.moveToExpectedState();
                            DefaultSpecialEffectsController.getOrCreateController((ViewGroup) fragment3.mView.getParent(), FragmentLayoutInflaterFactory.this.mFragmentManager.getSpecialEffectsControllerFactory()).forceCompleteAllOperations();
                        }

                        @Override // android.view.View.OnAttachStateChangeListener
                        public final void onViewDetachedFromWindow(View view3) {
                        }
                    });
                    return fragmentFindFragmentById.mView;
                }
            }
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
