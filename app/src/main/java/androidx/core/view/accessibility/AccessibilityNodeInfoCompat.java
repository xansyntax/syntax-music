package androidx.core.view.accessibility;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.os.BuildCompat;
import androidx.core.os.BuildCompat$$ExternalSyntheticBackportWithForwarding1;
import androidx.core.os.BundleCompat$Api33Impl;
import androidx.core.widget.TextViewCompat$Api34Impl;
import androidx.navigationevent.NavigationEvent_androidKt;
import io.ktor.utils.io.ByteChannelKt;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityNodeInfoCompat {
    public final AccessibilityNodeInfo mInfo;
    public int mParentVirtualDescendantId = -1;
    public int mVirtualDescendantId = -1;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api36MinorImpl {
        public static AccessibilityNodeInfo.AccessibilityAction getActionSetExtendedSelection() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_EXTENDED_SELECTION;
        }
    }

    public AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.mInfo = accessibilityNodeInfo;
    }

    public static String getActionSymbolicName(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        switch (i) {
                                            case R.id.accessibilityActionScrollInDirection:
                                                return "ACTION_SCROLL_IN_DIRECTION";
                                            case R.id.ALT:
                                                return "ACTION_SET_EXTENDED_SELECTION";
                                            default:
                                                return "ACTION_UNKNOWN";
                                        }
                                }
                        }
                }
        }
    }

    public final void addAction(AccessibilityActionCompat accessibilityActionCompat) {
        this.mInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.mAction);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityNodeInfoCompat)) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2 = this.mInfo;
        if (accessibilityNodeInfo2 == null) {
            if (accessibilityNodeInfo != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo2.equals(accessibilityNodeInfo)) {
            return false;
        }
        return this.mVirtualDescendantId == accessibilityNodeInfoCompat.mVirtualDescendantId && this.mParentVirtualDescendantId == accessibilityNodeInfoCompat.mParentVirtualDescendantId;
    }

    public final ArrayList extrasIntList(String str) {
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        ArrayList<Integer> integerArrayList = accessibilityNodeInfo.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        accessibilityNodeInfo.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public final boolean getBooleanProperty(int i) {
        Bundle extras = this.mInfo.getExtras();
        return extras != null && (extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i) == i;
    }

    public final CharSequence getText() {
        boolean zIsEmpty = extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (zIsEmpty) {
            return accessibilityNodeInfo.getText();
        }
        ArrayList arrayListExtrasIntList = extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        ArrayList arrayListExtrasIntList2 = extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        ArrayList arrayListExtrasIntList3 = extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        ArrayList arrayListExtrasIntList4 = extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(accessibilityNodeInfo.getText(), 0, accessibilityNodeInfo.getText().length()));
        for (int i = 0; i < arrayListExtrasIntList.size(); i++) {
            spannableString.setSpan(new AccessibilityClickableSpanCompat(((Integer) arrayListExtrasIntList4.get(i)).intValue(), this, accessibilityNodeInfo.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) arrayListExtrasIntList.get(i)).intValue(), ((Integer) arrayListExtrasIntList2.get(i)).intValue(), ((Integer) arrayListExtrasIntList3.get(i)).intValue());
        }
        return spannableString;
    }

    public final int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public final void setBooleanProperty(int i, boolean z) {
        Bundle extras = this.mInfo.getExtras();
        if (extras != null) {
            int i2 = extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i);
            if (!z) {
                i = 0;
            }
            extras.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }

    public final void setClassName(String str) {
        this.mInfo.setClassName(str);
    }

    public final void setHeading(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setHeading(z);
        } else {
            setBooleanProperty(2, z);
        }
    }

    public final void setPaneTitle(CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (i >= 28) {
            accessibilityNodeInfo.setPaneTitle(charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public final void setScreenReaderFocusable(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setScreenReaderFocusable(z);
        } else {
            setBooleanProperty(1, z);
        }
    }

    public final void setTextEntryKey() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.mInfo.setTextEntryKey(true);
        } else {
            setBooleanProperty(8, true);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        accessibilityNodeInfo.getBoundsInParent(rect);
        sb.append("; boundsInParent: " + rect);
        accessibilityNodeInfo.getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            TextViewCompat$Api34Impl.getBoundsInWindow(accessibilityNodeInfo, rect);
        } else {
            Rect rect2 = (Rect) accessibilityNodeInfo.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
            if (rect2 != null) {
                rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
            }
        }
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(accessibilityNodeInfo.getPackageName());
        sb.append("; className: ");
        sb.append(accessibilityNodeInfo.getClassName());
        sb.append("; text: ");
        sb.append(getText());
        sb.append("; error: ");
        sb.append(accessibilityNodeInfo.getError());
        sb.append("; maxTextLength: ");
        sb.append(accessibilityNodeInfo.getMaxTextLength());
        sb.append("; stateDescription: ");
        sb.append(i >= 30 ? BuildCompat.Api30Impl.getStateDescription(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY"));
        sb.append("; contentDescription: ");
        sb.append(accessibilityNodeInfo.getContentDescription());
        sb.append("; supplementalDescription: ");
        sb.append(i >= 36 ? NavigationEvent_androidKt.getSupplementalDescription(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.SUPPLEMENTAL_DESCRIPTION_KEY"));
        sb.append("; tooltipText: ");
        sb.append(i >= 28 ? accessibilityNodeInfo.getTooltipText() : accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY"));
        sb.append("; viewIdResName: ");
        sb.append(accessibilityNodeInfo.getViewIdResourceName());
        sb.append("; uniqueId: ");
        sb.append(i >= 33 ? BundleCompat$Api33Impl.getUniqueId(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY"));
        sb.append("; checkable: ");
        sb.append(accessibilityNodeInfo.isCheckable());
        sb.append("; checked: ");
        int checked = i >= 36 ? NavigationEvent_androidKt.getChecked(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.CHECKED_KEY", accessibilityNodeInfo.isChecked() ? 1 : 0);
        String str = "PARTIAL";
        sb.append(checked == 1 ? "TRUE" : checked == 2 ? "PARTIAL" : "FALSE");
        sb.append("; fieldRequired: ");
        sb.append(i >= 36 ? NavigationEvent_androidKt.isFieldRequired(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getBoolean("androidx.view.accessibility.AccessibilityNodeInfoCompat.IS_REQUIRED_KEY"));
        sb.append("; focusable: ");
        sb.append(accessibilityNodeInfo.isFocusable());
        sb.append("; focused: ");
        sb.append(accessibilityNodeInfo.isFocused());
        sb.append("; selected: ");
        sb.append(accessibilityNodeInfo.isSelected());
        sb.append("; clickable: ");
        sb.append(accessibilityNodeInfo.isClickable());
        sb.append("; longClickable: ");
        sb.append(accessibilityNodeInfo.isLongClickable());
        sb.append("; contextClickable: ");
        sb.append(accessibilityNodeInfo.isContextClickable());
        sb.append("; expandedState: ");
        int expandedState = i >= 36 ? NavigationEvent_androidKt.getExpandedState(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.EXPANDED_STATE_KEY", 0);
        if (expandedState == 0) {
            str = "UNDEFINED";
        } else if (expandedState == 1) {
            str = "COLLAPSED";
        } else if (expandedState != 2) {
            str = expandedState != 3 ? "UNKNOWN" : "FULL";
        }
        sb.append(str);
        sb.append("; enabled: ");
        sb.append(accessibilityNodeInfo.isEnabled());
        sb.append("; password: ");
        sb.append(accessibilityNodeInfo.isPassword());
        sb.append("; scrollable: " + accessibilityNodeInfo.isScrollable());
        sb.append("; containerTitle: ");
        sb.append(i >= 34 ? TextViewCompat$Api34Impl.getContainerTitle(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY"));
        sb.append("; granularScrollingSupported: ");
        sb.append(getBooleanProperty(67108864));
        sb.append("; importantForAccessibility: ");
        sb.append(accessibilityNodeInfo.isImportantForAccessibility());
        sb.append("; visible: ");
        sb.append(accessibilityNodeInfo.isVisibleToUser());
        sb.append("; isTextSelectable: ");
        sb.append(i >= 33 ? BundleCompat$Api33Impl.isTextSelectable(accessibilityNodeInfo) : getBooleanProperty(8388608));
        sb.append("; accessibilityDataSensitive: ");
        sb.append(i >= 34 ? TextViewCompat$Api34Impl.isAccessibilityDataSensitive(accessibilityNodeInfo) : getBooleanProperty(64));
        sb.append("; [");
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = accessibilityNodeInfo.getActionList();
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new AccessibilityActionCompat(actionList.get(i2), 0, null, null));
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            AccessibilityActionCompat accessibilityActionCompat = (AccessibilityActionCompat) arrayList.get(i3);
            Object obj = accessibilityActionCompat.mAction;
            Object obj2 = accessibilityActionCompat.mAction;
            String actionSymbolicName = getActionSymbolicName(((AccessibilityNodeInfo.AccessibilityAction) obj).getId());
            if (actionSymbolicName.equals("ACTION_UNKNOWN") && ((AccessibilityNodeInfo.AccessibilityAction) obj2).getLabel() != null) {
                actionSymbolicName = ((AccessibilityNodeInfo.AccessibilityAction) obj2).getLabel().toString();
            }
            sb.append(actionSymbolicName);
            if (i3 != arrayList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AccessibilityActionCompat {
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
        public static final AccessibilityActionCompat ACTION_SCROLL_DOWN;
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD;
        public static final AccessibilityActionCompat ACTION_SCROLL_LEFT;
        public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT;
        public static final AccessibilityActionCompat ACTION_SCROLL_UP;
        public final Object mAction;
        public final int mId;

        static {
            new AccessibilityActionCompat(null, 1, null, null);
            new AccessibilityActionCompat(null, 2, null, null);
            new AccessibilityActionCompat(null, 4, null, null);
            new AccessibilityActionCompat(null, 8, null, null);
            new AccessibilityActionCompat(null, 16, null, null);
            new AccessibilityActionCompat(null, 32, null, null);
            ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(null, 64, null, null);
            ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(null, 128, null, null);
            new AccessibilityActionCompat(null, 256, null, AccessibilityViewCommand$MoveAtGranularityArguments.class);
            new AccessibilityActionCompat(null, 512, null, AccessibilityViewCommand$MoveAtGranularityArguments.class);
            new AccessibilityActionCompat(null, 1024, null, AccessibilityViewCommand$MoveHtmlArguments.class);
            new AccessibilityActionCompat(null, 2048, null, AccessibilityViewCommand$MoveHtmlArguments.class);
            ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(null, 4096, null, null);
            ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(null, 8192, null, null);
            new AccessibilityActionCompat(null, 16384, null, null);
            new AccessibilityActionCompat(null, 32768, null, null);
            new AccessibilityActionCompat(null, 65536, null, null);
            new AccessibilityActionCompat(null, 131072, null, AccessibilityViewCommand$SetSelectionArguments.class);
            new AccessibilityActionCompat(null, 262144, null, null);
            new AccessibilityActionCompat(null, 524288, null, null);
            new AccessibilityActionCompat(null, ByteChannelKt.CHANNEL_MAX_SIZE, null, null);
            new AccessibilityActionCompat(null, 2097152, null, AccessibilityViewCommand$SetTextArguments.class);
            new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null);
            new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, AccessibilityViewCommand$ScrollToPositionArguments.class);
            ACTION_SCROLL_UP = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null);
            ACTION_SCROLL_LEFT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null);
            ACTION_SCROLL_DOWN = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null);
            ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null);
            int i = Build.VERSION.SDK_INT;
            new AccessibilityActionCompat(i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null);
            new AccessibilityActionCompat(i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null);
            new AccessibilityActionCompat(i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null);
            new AccessibilityActionCompat(i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null);
            new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null);
            new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, AccessibilityViewCommand$SetProgressArguments.class);
            new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, AccessibilityViewCommand$MoveWindowArguments.class);
            new AccessibilityActionCompat(i >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null);
            new AccessibilityActionCompat(i >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null);
            new AccessibilityActionCompat(i >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null);
            new AccessibilityActionCompat(i >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null);
            new AccessibilityActionCompat(i >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null);
            new AccessibilityActionCompat(i >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null);
            new AccessibilityActionCompat(i >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null);
            new AccessibilityActionCompat(i >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null);
            new AccessibilityActionCompat(i >= 34 ? TextViewCompat$Api34Impl.getActionScrollInDirection() : null, R.id.accessibilityActionScrollInDirection, null, null);
            int i2 = BuildCompat.$r8$clinit;
            new AccessibilityActionCompat((i < 36 || BuildCompat$$ExternalSyntheticBackportWithForwarding1.m() < 3600001) ? null : Api36MinorImpl.getActionSetExtendedSelection(), R.id.ALT, null, null);
        }

        public AccessibilityActionCompat(Object obj, int i, CharSequence charSequence, Class cls) {
            this.mId = i;
            if (obj == null) {
                this.mAction = new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
            } else {
                this.mAction = obj;
            }
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof AccessibilityActionCompat)) {
                return false;
            }
            Object obj2 = ((AccessibilityActionCompat) obj).mAction;
            Object obj3 = this.mAction;
            if (obj3 == null) {
                return obj2 == null;
            }
            return obj3.equals(obj2);
        }

        public final int hashCode() {
            Object obj = this.mAction;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
            String actionSymbolicName = AccessibilityNodeInfoCompat.getActionSymbolicName(this.mId);
            if (actionSymbolicName.equals("ACTION_UNKNOWN")) {
                Object obj = this.mAction;
                if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                    actionSymbolicName = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
                }
            }
            sb.append(actionSymbolicName);
            return sb.toString();
        }

        public AccessibilityActionCompat(int i, String str) {
            this(null, i, str, null);
        }
    }
}
