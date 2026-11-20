package androidx.compose.ui.platform;

import android.R;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Binder;
import android.os.Build;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatRange;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class InvertMatrixKt implements ViewCompositionStrategy {

    /* JADX INFO: renamed from: lambda$-1759434350, reason: not valid java name */
    public static final ComposableLambdaImpl f6lambda$1759434350 = new ComposableLambdaImpl(false, -1759434350, new Updater$$ExternalSyntheticLambda0((byte) 16));

    public static final void addPageActions(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
        Object obj = semanticsConfiguration.props.get(SemanticsProperties.Role);
        if (obj == null) {
            obj = null;
        }
        Role role = (Role) obj;
        if (enabled(semanticsNode)) {
            if (role != null && role.value == 8) {
                return;
            }
            Object obj2 = mutableScatterMap.get(SemanticsActions.PageUp);
            if (obj2 == null) {
                obj2 = null;
            }
            AccessibilityAction accessibilityAction = (AccessibilityAction) obj2;
            if (accessibilityAction != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(null, R.id.accessibilityActionPageUp, accessibilityAction.label, null));
            }
            Object obj3 = mutableScatterMap.get(SemanticsActions.PageDown);
            if (obj3 == null) {
                obj3 = null;
            }
            AccessibilityAction accessibilityAction2 = (AccessibilityAction) obj3;
            if (accessibilityAction2 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(null, R.id.accessibilityActionPageDown, accessibilityAction2.label, null));
            }
            Object obj4 = mutableScatterMap.get(SemanticsActions.PageLeft);
            if (obj4 == null) {
                obj4 = null;
            }
            AccessibilityAction accessibilityAction3 = (AccessibilityAction) obj4;
            if (accessibilityAction3 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(null, R.id.accessibilityActionPageLeft, accessibilityAction3.label, null));
            }
            Object obj5 = mutableScatterMap.get(SemanticsActions.PageRight);
            if (obj5 == null) {
                obj5 = null;
            }
            AccessibilityAction accessibilityAction4 = (AccessibilityAction) obj5;
            if (accessibilityAction4 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(null, R.id.accessibilityActionPageRight, accessibilityAction4.label, null));
            }
        }
    }

    public static final boolean canBeSavedToBundle(Object obj) {
        if (!(obj instanceof SnapshotMutableState)) {
            if ((obj instanceof Function) && (obj instanceof Serializable)) {
                return false;
            }
            return (obj instanceof Parcelable) || (obj instanceof Serializable) || (obj instanceof Binder) || (obj instanceof Size) || (obj instanceof SizeF) || (obj instanceof SparseArray);
        }
        SnapshotMutableState snapshotMutableState = (SnapshotMutableState) obj;
        NeverEqualPolicy policy = snapshotMutableState.getPolicy();
        if (policy != NeverEqualPolicy.INSTANCE && policy != NeverEqualPolicy.INSTANCE$3 && policy != NeverEqualPolicy.INSTANCE$1) {
            return false;
        }
        Object value = snapshotMutableState.getValue();
        return value == null || canBeSavedToBundle(value);
    }

    public static final boolean containsDescendant(View view, View view2) {
        if (view2.equals(view)) {
            return false;
        }
        for (ViewParent parent = view2.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == view) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: dot-p89u6pk, reason: not valid java name */
    public static final float m708dotp89u6pk(int i, int i2, float[] fArr, float[] fArr2) {
        int i3 = i * 4;
        return (fArr[i3 + 3] * fArr2[12 + i2]) + (fArr[i3 + 2] * fArr2[8 + i2]) + (fArr[i3 + 1] * fArr2[4 + i2]) + (fArr[i3] * fArr2[i2]);
    }

    public static final boolean enabled(SemanticsNode semanticsNode) {
        return !semanticsNode.getConfig().props.containsKey(SemanticsProperties.Disabled);
    }

    public static final int findDepthToTag(View view, int i) {
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        Object obj = null;
        while (view != null) {
            Object tag = view.getTag(i);
            if (tag != null) {
                if (obj != null) {
                    if (!tag.equals(obj)) {
                        break;
                    }
                } else {
                    obj = tag;
                }
                i3 = i2;
            }
            i2++;
            Object parentOrViewTreeDisjointParent = DatabaseDao_Impl.AnonymousClass17.getParentOrViewTreeDisjointParent(view);
            view = parentOrViewTreeDisjointParent instanceof View ? (View) parentOrViewTreeDisjointParent : null;
        }
        return i3;
    }

    public static View findViewByAccessibilityIdRootedAtCurrentView(View view, int i) throws NoSuchMethodException {
        if (Build.VERSION.SDK_INT < 29) {
            Method declaredMethod = AndroidComposeView.getAccessibilityViewIdMethod;
            if (declaredMethod == null) {
                declaredMethod = Class.forName("android.view.View").getDeclaredMethod("getAccessibilityViewId", null);
                AndroidComposeView.getAccessibilityViewIdMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            if (Intrinsics.areEqual(declaredMethod.invoke(view, null), Integer.valueOf(i))) {
                return view;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View viewFindViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(viewGroup.getChildAt(i2), i);
                    if (viewFindViewByAccessibilityIdRootedAtCurrentView != null) {
                        return viewFindViewByAccessibilityIdRootedAtCurrentView;
                    }
                }
            }
        }
        return null;
    }

    public static final View findViewTreeComposeViewRoot(View view) {
        if (!view.isAttachedToWindow()) {
            return view;
        }
        int iMin = Math.min(findDepthToTag(view, com.yalantis.ucrop.R.id.view_tree_lifecycle_owner), findDepthToTag(view, com.yalantis.ucrop.R.id.view_tree_saved_state_registry_owner));
        View view2 = view;
        int i = 0;
        View view3 = view2;
        while (view != null) {
            if (i == iMin) {
                if (!(view.getParent() instanceof ViewGroup)) {
                    return view2;
                }
            } else if (getComposeViewContext(view) == null) {
                i++;
                Object parentOrViewTreeDisjointParent = DatabaseDao_Impl.AnonymousClass17.getParentOrViewTreeDisjointParent(view);
                View view4 = view2;
                view2 = view;
                view = parentOrViewTreeDisjointParent instanceof View ? (View) parentOrViewTreeDisjointParent : null;
                view3 = view4;
            }
            return view;
        }
        return view3;
    }

    public static final ComposeViewContext getComposeViewContext(View view) {
        Object tag = view.getTag(com.yalantis.ucrop.R.id.androidx_compose_ui_view_compose_view_context);
        WeakReference weakReference = tag instanceof WeakReference ? (WeakReference) tag : null;
        if (weakReference != null) {
            return (ComposeViewContext) weakReference.get();
        }
        return null;
    }

    public static final boolean getInfoIsCheckable(SemanticsNode semanticsNode) {
        Object obj = semanticsNode.unmergedConfig.props.get(SemanticsProperties.ToggleableState);
        if (obj == null) {
            obj = null;
        }
        ToggleableState toggleableState = (ToggleableState) obj;
        MutableScatterMap mutableScatterMap = semanticsNode.unmergedConfig.props;
        Object obj2 = mutableScatterMap.get(SemanticsProperties.Role);
        if (obj2 == null) {
            obj2 = null;
        }
        Role role = (Role) obj2;
        boolean z = toggleableState != null;
        Object obj3 = mutableScatterMap.get(SemanticsProperties.Selected);
        if (((Boolean) (obj3 != null ? obj3 : null)) == null || (role != null && role.value == 4)) {
            return z;
        }
        return true;
    }

    public static final String getInfoStateDescriptionOrNull(SemanticsNode semanticsNode, Resources resources) {
        int iCoerceIn;
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        SemanticsConfiguration semanticsConfiguration2 = semanticsNode.unmergedConfig;
        Object string = semanticsConfiguration.props.get(SemanticsProperties.StateDescription);
        String string2 = null;
        if (string == null) {
            string = null;
        }
        MutableScatterMap mutableScatterMap = semanticsConfiguration2.props;
        Object obj = mutableScatterMap.get(SemanticsProperties.ToggleableState);
        if (obj == null) {
            obj = null;
        }
        ToggleableState toggleableState = (ToggleableState) obj;
        Object obj2 = mutableScatterMap.get(SemanticsProperties.Role);
        if (obj2 == null) {
            obj2 = null;
        }
        Role role = (Role) obj2;
        if (toggleableState != null) {
            int iOrdinal = toggleableState.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    if (string == null) {
                        string = resources.getString(com.yalantis.ucrop.R.string.indeterminate);
                    }
                } else if (role != null && role.value == 2 && string == null) {
                    string = resources.getString(com.yalantis.ucrop.R.string.state_off);
                }
            } else if (role != null && role.value == 2 && string == null) {
                string = resources.getString(com.yalantis.ucrop.R.string.state_on);
            }
        }
        Object obj3 = mutableScatterMap.get(SemanticsProperties.Selected);
        if (obj3 == null) {
            obj3 = null;
        }
        Boolean bool = (Boolean) obj3;
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            if ((role == null || role.value != 4) && string == null) {
                string = zBooleanValue ? resources.getString(com.yalantis.ucrop.R.string.selected) : resources.getString(com.yalantis.ucrop.R.string.not_selected);
            }
        }
        Object obj4 = mutableScatterMap.get(SemanticsProperties.ProgressBarRangeInfo);
        if (obj4 == null) {
            obj4 = null;
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) obj4;
        if (progressBarRangeInfo != null) {
            if (progressBarRangeInfo != ProgressBarRangeInfo.Indeterminate) {
                if (string == null) {
                    ClosedFloatRange closedFloatRange = progressBarRangeInfo.range;
                    float f = closedFloatRange._endInclusive;
                    float f2 = closedFloatRange._start;
                    float f3 = f - f2 == CropImageView.DEFAULT_ASPECT_RATIO ? 0.0f : (progressBarRangeInfo.current - f2) / (closedFloatRange._endInclusive - f2);
                    if (f3 < CropImageView.DEFAULT_ASPECT_RATIO) {
                        f3 = 0.0f;
                    }
                    if (f3 > 1.0f) {
                        f3 = 1.0f;
                    }
                    if (f3 == CropImageView.DEFAULT_ASPECT_RATIO) {
                        iCoerceIn = 0;
                    } else {
                        iCoerceIn = f3 == 1.0f ? 100 : UuidKt.coerceIn(Math.round(f3 * 100.0f), 1, 99);
                    }
                    string = resources.getString(com.yalantis.ucrop.R.string.template_percent, Integer.valueOf(iCoerceIn));
                }
            } else if (string == null) {
                string = resources.getString(com.yalantis.ucrop.R.string.in_progress);
            }
        }
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.EditableText;
        if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
            MutableScatterMap mutableScatterMap2 = new SemanticsNode(semanticsNode.outerSemanticsNode, true, semanticsNode.layoutNode, semanticsConfiguration2).getConfig().props;
            Object obj5 = mutableScatterMap2.get(SemanticsProperties.ContentDescription);
            if (obj5 == null) {
                obj5 = null;
            }
            Collection collection = (Collection) obj5;
            if (collection == null || collection.isEmpty()) {
                Object obj6 = mutableScatterMap2.get(SemanticsProperties.Text);
                if (obj6 == null) {
                    obj6 = null;
                }
                Collection collection2 = (Collection) obj6;
                if (collection2 == null || collection2.isEmpty()) {
                    Object obj7 = mutableScatterMap2.get(semanticsPropertyKey);
                    if (obj7 == null) {
                        obj7 = null;
                    }
                    CharSequence charSequence = (CharSequence) obj7;
                    if (charSequence == null || charSequence.length() == 0) {
                        Object obj8 = mutableScatterMap2.get(SemanticsProperties.HintText);
                        if (obj8 == null) {
                            obj8 = null;
                        }
                        CharSequence charSequence2 = (CharSequence) obj8;
                        if (charSequence2 == null || charSequence2.length() == 0) {
                            string2 = resources.getString(com.yalantis.ucrop.R.string.state_empty);
                        }
                    }
                }
            }
            string = string2;
        }
        return (String) string;
    }

    public static final AnnotatedString getInfoText(SemanticsNode semanticsNode) {
        Object obj = semanticsNode.unmergedConfig.props.get(SemanticsProperties.EditableText);
        if (obj == null) {
            obj = null;
        }
        AnnotatedString annotatedString = (AnnotatedString) obj;
        Object obj2 = semanticsNode.unmergedConfig.props.get(SemanticsProperties.Text);
        if (obj2 == null) {
            obj2 = null;
        }
        List list = (List) obj2;
        return annotatedString == null ? list != null ? (AnnotatedString) CollectionsKt.firstOrNull(list) : null : annotatedString;
    }

    public static boolean getIsShowingLayoutBounds() {
        try {
            if (AndroidComposeView.systemPropertiesClass == null) {
                AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
            }
            Method declaredMethod = AndroidComposeView.getBooleanMethod;
            if (declaredMethod == null) {
                Class cls = AndroidComposeView.systemPropertiesClass;
                declaredMethod = cls != null ? cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : null;
                AndroidComposeView.getBooleanMethod = declaredMethod;
            }
            Object objInvoke = declaredMethod != null ? declaredMethod.invoke(null, "debug.layout", Boolean.FALSE) : null;
            return Intrinsics.areEqual(objInvoke instanceof Boolean ? (Boolean) objInvoke : null, Boolean.TRUE);
        } catch (Exception unused) {
            return false;
        }
    }

    public static final TextLayoutResult getTextLayoutResult(SemanticsConfiguration semanticsConfiguration) {
        Function1 function1;
        ArrayList arrayList = new ArrayList();
        Object obj = semanticsConfiguration.props.get(SemanticsActions.GetTextLayoutResult);
        if (obj == null) {
            obj = null;
        }
        AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
        if (accessibilityAction == null || (function1 = (Function1) accessibilityAction.action) == null || !((Boolean) function1.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (TextLayoutResult) CollectionsKt.firstOrNull((List) arrayList);
    }

    /* JADX INFO: renamed from: invertTo-JiSxe2E, reason: not valid java name */
    public static final boolean m709invertToJiSxe2E(float[] fArr, float[] fArr2) {
        if (fArr.length < 16 || fArr2.length < 16) {
            return false;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = fArr[6];
        float f8 = fArr[7];
        float f9 = fArr[8];
        float f10 = fArr[9];
        float f11 = fArr[10];
        float f12 = fArr[11];
        float f13 = fArr[12];
        float f14 = fArr[13];
        float f15 = fArr[14];
        float f16 = fArr[15];
        float f17 = (f * f6) - (f2 * f5);
        float f18 = (f * f7) - (f3 * f5);
        float f19 = (f * f8) - (f4 * f5);
        float f20 = (f2 * f7) - (f3 * f6);
        float f21 = (f2 * f8) - (f4 * f6);
        float f22 = (f3 * f8) - (f4 * f7);
        float f23 = (f9 * f14) - (f10 * f13);
        float f24 = (f9 * f15) - (f11 * f13);
        float f25 = (f9 * f16) - (f12 * f13);
        float f26 = (f10 * f15) - (f11 * f14);
        float f27 = (f10 * f16) - (f12 * f14);
        float f28 = (f11 * f16) - (f12 * f15);
        float f29 = (f22 * f23) + (((f20 * f25) + ((f19 * f26) + ((f17 * f28) - (f18 * f27)))) - (f21 * f24));
        if (f29 != CropImageView.DEFAULT_ASPECT_RATIO) {
            float f30 = 1.0f / f29;
            fArr2[0] = ((f8 * f26) + ((f6 * f28) - (f7 * f27))) * f30;
            fArr2[1] = (((f3 * f27) + ((-f2) * f28)) - (f4 * f26)) * f30;
            fArr2[2] = ((f16 * f20) + ((f14 * f22) - (f15 * f21))) * f30;
            fArr2[3] = (((f11 * f21) + ((-f10) * f22)) - (f12 * f20)) * f30;
            float f31 = -f5;
            fArr2[4] = (((f7 * f25) + (f31 * f28)) - (f8 * f24)) * f30;
            fArr2[5] = ((f4 * f24) + ((f28 * f) - (f3 * f25))) * f30;
            float f32 = -f13;
            fArr2[6] = (((f15 * f19) + (f32 * f22)) - (f16 * f18)) * f30;
            fArr2[7] = ((f12 * f18) + ((f22 * f9) - (f11 * f19))) * f30;
            fArr2[8] = ((f8 * f23) + ((f5 * f27) - (f6 * f25))) * f30;
            fArr2[9] = (((f25 * f2) + ((-f) * f27)) - (f4 * f23)) * f30;
            fArr2[10] = ((f16 * f17) + ((f13 * f21) - (f14 * f19))) * f30;
            fArr2[11] = (((f19 * f10) + ((-f9) * f21)) - (f12 * f17)) * f30;
            fArr2[12] = (((f6 * f24) + (f31 * f26)) - (f7 * f23)) * f30;
            fArr2[13] = ((f3 * f23) + ((f * f26) - (f2 * f24))) * f30;
            fArr2[14] = (((f14 * f18) + (f32 * f20)) - (f15 * f17)) * f30;
            fArr2[15] = ((f11 * f17) + ((f9 * f20) - (f10 * f18))) * f30;
        }
        return !(f29 == CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public static final boolean isInPath(float f, float f2, AndroidPath androidPath) {
        float f3 = f - 0.005f;
        float f4 = f2 - 0.005f;
        float f5 = f + 0.005f;
        float f6 = f2 + 0.005f;
        AndroidPath androidPathPath = AndroidPath_androidKt.Path();
        if (Float.isNaN(f3) || Float.isNaN(f4) || Float.isNaN(f5) || Float.isNaN(f6)) {
            AndroidPath_androidKt.throwIllegalStateException("Invalid rectangle, make sure no value is NaN");
        }
        RectF rectF = androidPathPath.rectF;
        if (rectF == null) {
            rectF = new RectF();
            androidPathPath.rectF = rectF;
        }
        rectF.set(f3, f4, f5, f6);
        Path path = androidPathPath.internalPath;
        RectF rectF2 = androidPathPath.rectF;
        rectF2.getClass();
        path.addRect(rectF2, Path.Direction.CCW);
        AndroidPath androidPathPath2 = AndroidPath_androidKt.Path();
        androidPathPath2.m470opN5in7k0(androidPath, androidPathPath, 1);
        boolean zIsEmpty = androidPathPath2.internalPath.isEmpty();
        androidPathPath2.reset();
        androidPathPath.reset();
        return !zIsEmpty;
    }

    public static final boolean isScreenReaderFocusable(SemanticsNode semanticsNode, Resources resources, boolean z) {
        if (SemanticsNodeKt.isHidden(semanticsNode) || z) {
            return false;
        }
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        if (semanticsConfiguration.isMergingSemanticsOfDescendants) {
            return true;
        }
        Object obj = semanticsConfiguration.props.get(SemanticsProperties.ContentDescription);
        if (obj == null) {
            obj = null;
        }
        List list = (List) obj;
        return !((list != null ? (String) CollectionsKt.firstOrNull(list) : null) == null && getInfoText(semanticsNode) == null && getInfoStateDescriptionOrNull(semanticsNode, resources) == null && !getInfoIsCheckable(semanticsNode)) && isUnmergedLeafNode(semanticsNode);
    }

    public static final boolean isUnmergedLeafNode(SemanticsNode semanticsNode) {
        if (!semanticsNode.isFake$ui()) {
            List children$ui = semanticsNode.getChildren$ui((4 & 1) != 0 ? !semanticsNode.mergingEnabled : false, (4 & 2) == 0);
            int size = children$ui.size();
            for (int i = 0; i < size; i++) {
                if (SemanticsNodeKt.isAccessibilityIgnoredLink((SemanticsNode) children$ui.get(i))) {
                }
            }
            LayoutNode parent$ui = semanticsNode.layoutNode.getParent$ui();
            while (true) {
                if (parent$ui == null) {
                    parent$ui = null;
                    break;
                }
                SemanticsConfiguration semanticsConfiguration = parent$ui.getSemanticsConfiguration();
                if (semanticsConfiguration != null && semanticsConfiguration.isMergingSemanticsOfDescendants) {
                    break;
                }
                parent$ui = parent$ui.getParent$ui();
            }
            return !(parent$ui != null);
        }
        return false;
    }

    /* JADX INFO: renamed from: isWithinEllipse-VE1yxkc, reason: not valid java name */
    public static final boolean m710isWithinEllipseVE1yxkc(float f, float f2, float f3, float f4, long j) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return ((f6 * f6) / (fIntBitsToFloat2 * fIntBitsToFloat2)) + ((f5 * f5) / (fIntBitsToFloat * fIntBitsToFloat)) <= 1.0f;
    }

    /* JADX INFO: renamed from: preTransform-JiSxe2E, reason: not valid java name */
    public static final void m711preTransformJiSxe2E(float[] fArr, float[] fArr2) {
        float fM708dotp89u6pk = m708dotp89u6pk(0, 0, fArr2, fArr);
        float fM708dotp89u6pk2 = m708dotp89u6pk(0, 1, fArr2, fArr);
        float fM708dotp89u6pk3 = m708dotp89u6pk(0, 2, fArr2, fArr);
        float fM708dotp89u6pk4 = m708dotp89u6pk(0, 3, fArr2, fArr);
        float fM708dotp89u6pk5 = m708dotp89u6pk(1, 0, fArr2, fArr);
        float fM708dotp89u6pk6 = m708dotp89u6pk(1, 1, fArr2, fArr);
        float fM708dotp89u6pk7 = m708dotp89u6pk(1, 2, fArr2, fArr);
        float fM708dotp89u6pk8 = m708dotp89u6pk(1, 3, fArr2, fArr);
        float fM708dotp89u6pk9 = m708dotp89u6pk(2, 0, fArr2, fArr);
        float fM708dotp89u6pk10 = m708dotp89u6pk(2, 1, fArr2, fArr);
        float fM708dotp89u6pk11 = m708dotp89u6pk(2, 2, fArr2, fArr);
        float fM708dotp89u6pk12 = m708dotp89u6pk(2, 3, fArr2, fArr);
        float fM708dotp89u6pk13 = m708dotp89u6pk(3, 0, fArr2, fArr);
        float fM708dotp89u6pk14 = m708dotp89u6pk(3, 1, fArr2, fArr);
        float fM708dotp89u6pk15 = m708dotp89u6pk(3, 2, fArr2, fArr);
        float fM708dotp89u6pk16 = m708dotp89u6pk(3, 3, fArr2, fArr);
        fArr[0] = fM708dotp89u6pk;
        fArr[1] = fM708dotp89u6pk2;
        fArr[2] = fM708dotp89u6pk3;
        fArr[3] = fM708dotp89u6pk4;
        fArr[4] = fM708dotp89u6pk5;
        fArr[5] = fM708dotp89u6pk6;
        fArr[6] = fM708dotp89u6pk7;
        fArr[7] = fM708dotp89u6pk8;
        fArr[8] = fM708dotp89u6pk9;
        fArr[9] = fM708dotp89u6pk10;
        fArr[10] = fM708dotp89u6pk11;
        fArr[11] = fM708dotp89u6pk12;
        fArr[12] = fM708dotp89u6pk13;
        fArr[13] = fM708dotp89u6pk14;
        fArr[14] = fM708dotp89u6pk15;
        fArr[15] = fM708dotp89u6pk16;
    }

    /* JADX INFO: renamed from: preTranslate-cG2Xzmc, reason: not valid java name */
    public static final void m712preTranslatecG2Xzmc(float[] fArr, float f, float f2, float[] fArr2) {
        Matrix.m510resetimpl(fArr2);
        Matrix.m514translateimpl(fArr2, f, f2);
        m711preTransformJiSxe2E(fArr, fArr2);
    }

    public static final AndroidViewHolder semanticsIdToView(AndroidViewsHandler androidViewsHandler, int i) {
        Object next;
        Iterator<T> it = androidViewsHandler.getLayoutNodeToHolder().entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((LayoutNode) ((Map.Entry) next).getKey()).semanticsId != i);
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (AndroidViewHolder) entry.getValue();
        }
        return null;
    }

    public static final String simpleIdentityToString(Object obj) {
        return IntIntPair$$ExternalSyntheticOutline0.m(obj.getClass().isAnonymousClass() ? obj.getClass().getName() : obj.getClass().getSimpleName(), "@", String.format("%07x", Arrays.copyOf(new Object[]{Integer.valueOf(System.identityHashCode(obj))}, 1)));
    }

    /* JADX INFO: renamed from: toLegacyClassName-V4PA4sw, reason: not valid java name */
    public static final String m713toLegacyClassNameV4PA4sw(int i) {
        if (i == 0) {
            return "android.widget.Button";
        }
        if (i == 1) {
            return "android.widget.CheckBox";
        }
        if (i == 3) {
            return "android.widget.RadioButton";
        }
        if (i == 5) {
            return "android.widget.ImageView";
        }
        if (i == 6) {
            return "android.widget.Spinner";
        }
        if (i == 7) {
            return "android.widget.NumberPicker";
        }
        return null;
    }
}
