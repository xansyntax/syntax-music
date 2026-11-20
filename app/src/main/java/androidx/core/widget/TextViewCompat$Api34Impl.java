package androidx.core.widget;

import android.app.ActivityOptions;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.CursorAnchorInfo;
import android.widget.TextView;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextViewCompat$Api34Impl {
    public static final void addVisibleLineBounds(CursorAnchorInfo.Builder builder, TextLayoutResult textLayoutResult, Rect rect) {
        if (rect.isEmpty()) {
            return;
        }
        MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
        int i = multiParagraph.lineCount - 1;
        if (i < 0) {
            i = 0;
        }
        int iCoerceIn = UuidKt.coerceIn(multiParagraph.getLineForVerticalPosition(rect.top), 0, i);
        int iCoerceIn2 = UuidKt.coerceIn(multiParagraph.getLineForVerticalPosition(rect.bottom), 0, i);
        if (iCoerceIn > iCoerceIn2) {
            return;
        }
        while (true) {
            builder.addVisibleLineBounds(textLayoutResult.getLineLeft(iCoerceIn), multiParagraph.getLineTop(iCoerceIn), textLayoutResult.getLineRight(iCoerceIn), multiParagraph.getLineBottom(iCoerceIn));
            if (iCoerceIn == iCoerceIn2) {
                return;
            } else {
                iCoerceIn++;
            }
        }
    }

    public static AccessibilityNodeInfo.AccessibilityAction getActionScrollInDirection() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
    }

    public static float getAxisVelocity(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getAxisVelocity(i);
    }

    public static void getBoundsInWindow(AccessibilityNodeInfo accessibilityNodeInfo, android.graphics.Rect rect) {
        accessibilityNodeInfo.getBoundsInWindow(rect);
    }

    public static CharSequence getContainerTitle(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getContainerTitle();
    }

    public static int getScaledMaximumFlingVelocity(ViewConfiguration viewConfiguration, int i, int i2, int i3) {
        return viewConfiguration.getScaledMaximumFlingVelocity(i, i2, i3);
    }

    public static int getScaledMinimumFlingVelocity(ViewConfiguration viewConfiguration, int i, int i2, int i3) {
        return viewConfiguration.getScaledMinimumFlingVelocity(i, i2, i3);
    }

    public static boolean isAccessibilityDataSensitive(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isAccessibilityDataSensitive();
    }

    public static boolean isRequestFromAccessibilityTool(AccessibilityManager accessibilityManager) {
        return accessibilityManager.isRequestFromAccessibilityTool();
    }

    public static void setAccessibilityDataSensitive(AccessibilityEvent accessibilityEvent, boolean z) {
        accessibilityEvent.setAccessibilityDataSensitive(z);
    }

    public static void setLineHeight(TextView textView, int i, float f) {
        textView.setLineHeight(i, f);
    }

    public static void setShareIdentityEnabled(ActivityOptions activityOptions) {
        activityOptions.setShareIdentityEnabled(false);
    }

    public static void setAccessibilityDataSensitive(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        accessibilityNodeInfo.setAccessibilityDataSensitive(z);
    }
}
