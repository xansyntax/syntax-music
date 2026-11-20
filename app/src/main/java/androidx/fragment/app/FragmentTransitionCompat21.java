package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentTransitionCompat21 {
    public static void addTargets(Transition transition, ArrayList arrayList) {
        if (transition == null) {
            return;
        }
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                addTargets(transitionSet.getTransitionAt(i), arrayList);
                i++;
            }
            return;
        }
        if (hasSimpleTarget(transition)) {
            return;
        }
        List<View> targets = transition.getTargets();
        if (targets == null || targets.isEmpty()) {
            int size = arrayList.size();
            while (i < size) {
                transition.addTarget((View) arrayList.get(i));
                i++;
            }
        }
    }

    public static void getBoundsOnScreen(View view, Rect rect) {
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (view.isAttachedToWindow()) {
            RectF rectF = new RectF();
            rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            int[] iArr = new int[2];
            view.getRootView().getLocationOnScreen(iArr);
            rectF.offset(iArr[0], iArr[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public static boolean hasSimpleTarget(Transition transition) {
        List<Integer> targetIds = transition.getTargetIds();
        if (targetIds != null && !targetIds.isEmpty()) {
            return true;
        }
        List<String> targetNames = transition.getTargetNames();
        if (targetNames != null && !targetNames.isEmpty()) {
            return true;
        }
        List<Class> targetTypes = transition.getTargetTypes();
        return (targetTypes == null || targetTypes.isEmpty()) ? false : true;
    }

    public static void replaceTargets(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        List<View> targets;
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                replaceTargets(transitionSet.getTransitionAt(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (hasSimpleTarget(transition) || (targets = transition.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
            return;
        }
        int size = arrayList2 == null ? 0 : arrayList2.size();
        while (i < size) {
            transition.addTarget((View) arrayList2.get(i));
            i++;
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            transition.removeTarget((View) arrayList.get(size2));
        }
    }
}
