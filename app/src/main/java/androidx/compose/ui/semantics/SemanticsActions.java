package androidx.compose.ui.semantics;

import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SemanticsActions {
    public static final SemanticsPropertyKey ClearTextSubstitution;
    public static final SemanticsPropertyKey Collapse;
    public static final SemanticsPropertyKey CopyText;
    public static final SemanticsPropertyKey CustomActions;
    public static final SemanticsPropertyKey CutText;
    public static final SemanticsPropertyKey Dismiss;
    public static final SemanticsPropertyKey Expand;
    public static final SemanticsPropertyKey GetScrollViewportLength;
    public static final SemanticsPropertyKey GetTextLayoutResult;
    public static final SemanticsPropertyKey InsertTextAtCursor;
    public static final SemanticsPropertyKey OnAutofillText;
    public static final SemanticsPropertyKey OnClick;
    public static final SemanticsPropertyKey OnFillData;
    public static final SemanticsPropertyKey OnImeAction;
    public static final SemanticsPropertyKey OnLongClick;
    public static final SemanticsPropertyKey PageDown;
    public static final SemanticsPropertyKey PageLeft;
    public static final SemanticsPropertyKey PageRight;
    public static final SemanticsPropertyKey PageUp;
    public static final SemanticsPropertyKey PasteText;
    public static final SemanticsPropertyKey RequestFocus;
    public static final SemanticsPropertyKey ScrollBy;
    public static final SemanticsPropertyKey ScrollByOffset;
    public static final SemanticsPropertyKey ScrollToIndex;
    public static final SemanticsPropertyKey SetProgress;
    public static final SemanticsPropertyKey SetSelection;
    public static final SemanticsPropertyKey SetText;
    public static final SemanticsPropertyKey SetTextSubstitution;
    public static final SemanticsPropertyKey ShowTextSubstitution;

    static {
        SemanticsPropertiesKt$ActionPropertyKey$1 semanticsPropertiesKt$ActionPropertyKey$1 = SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE;
        GetTextLayoutResult = new SemanticsPropertyKey("GetTextLayoutResult", true, semanticsPropertiesKt$ActionPropertyKey$1);
        OnClick = new SemanticsPropertyKey("OnClick", true, semanticsPropertiesKt$ActionPropertyKey$1);
        OnLongClick = new SemanticsPropertyKey("OnLongClick", true, semanticsPropertiesKt$ActionPropertyKey$1);
        ScrollBy = new SemanticsPropertyKey("ScrollBy", true, semanticsPropertiesKt$ActionPropertyKey$1);
        ScrollByOffset = new SemanticsPropertyKey("ScrollByOffset");
        ScrollToIndex = new SemanticsPropertyKey("ScrollToIndex", true, semanticsPropertiesKt$ActionPropertyKey$1);
        OnAutofillText = new SemanticsPropertyKey("OnAutofillText", true, semanticsPropertiesKt$ActionPropertyKey$1);
        OnFillData = new SemanticsPropertyKey("OnFillData", true, semanticsPropertiesKt$ActionPropertyKey$1);
        SetProgress = new SemanticsPropertyKey("SetProgress", true, semanticsPropertiesKt$ActionPropertyKey$1);
        SetSelection = new SemanticsPropertyKey("SetSelection", true, semanticsPropertiesKt$ActionPropertyKey$1);
        SetText = new SemanticsPropertyKey("SetText", true, semanticsPropertiesKt$ActionPropertyKey$1);
        SetTextSubstitution = new SemanticsPropertyKey("SetTextSubstitution", true, semanticsPropertiesKt$ActionPropertyKey$1);
        ShowTextSubstitution = new SemanticsPropertyKey("ShowTextSubstitution", true, semanticsPropertiesKt$ActionPropertyKey$1);
        ClearTextSubstitution = new SemanticsPropertyKey("ClearTextSubstitution", true, semanticsPropertiesKt$ActionPropertyKey$1);
        InsertTextAtCursor = new SemanticsPropertyKey("InsertTextAtCursor", true, semanticsPropertiesKt$ActionPropertyKey$1);
        OnImeAction = new SemanticsPropertyKey("PerformImeAction", true, semanticsPropertiesKt$ActionPropertyKey$1);
        CopyText = new SemanticsPropertyKey("CopyText", true, semanticsPropertiesKt$ActionPropertyKey$1);
        CutText = new SemanticsPropertyKey("CutText", true, semanticsPropertiesKt$ActionPropertyKey$1);
        PasteText = new SemanticsPropertyKey("PasteText", true, semanticsPropertiesKt$ActionPropertyKey$1);
        Expand = new SemanticsPropertyKey("Expand", true, semanticsPropertiesKt$ActionPropertyKey$1);
        Collapse = new SemanticsPropertyKey("Collapse", true, semanticsPropertiesKt$ActionPropertyKey$1);
        Dismiss = new SemanticsPropertyKey("Dismiss", true, semanticsPropertiesKt$ActionPropertyKey$1);
        RequestFocus = new SemanticsPropertyKey("RequestFocus", true, semanticsPropertiesKt$ActionPropertyKey$1);
        CustomActions = new SemanticsPropertyKey("CustomActions", true, new Updater$$ExternalSyntheticLambda0((byte) 17));
        PageUp = new SemanticsPropertyKey("PageUp", true, semanticsPropertiesKt$ActionPropertyKey$1);
        PageLeft = new SemanticsPropertyKey("PageLeft", true, semanticsPropertiesKt$ActionPropertyKey$1);
        PageDown = new SemanticsPropertyKey("PageDown", true, semanticsPropertiesKt$ActionPropertyKey$1);
        PageRight = new SemanticsPropertyKey("PageRight", true, semanticsPropertiesKt$ActionPropertyKey$1);
        GetScrollViewportLength = new SemanticsPropertyKey("GetScrollViewportLength", true, semanticsPropertiesKt$ActionPropertyKey$1);
    }
}
