package androidx.compose.ui.semantics;

import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SemanticsProperties {
    public static final SemanticsPropertyKey ContentDescription = new SemanticsPropertyKey("ContentDescription", true, new Updater$$ExternalSyntheticLambda0((byte) 18));
    public static final SemanticsPropertyKey StateDescription = new SemanticsPropertyKey("StateDescription", 0);
    public static final SemanticsPropertyKey ProgressBarRangeInfo = new SemanticsPropertyKey("ProgressBarRangeInfo", 0);
    public static final SemanticsPropertyKey PaneTitle = new SemanticsPropertyKey("PaneTitle", true, new Updater$$ExternalSyntheticLambda0((byte) 27));
    public static final SemanticsPropertyKey SelectableGroup = new SemanticsPropertyKey("SelectableGroup", 0);
    public static final SemanticsPropertyKey CollectionInfo = new SemanticsPropertyKey("CollectionInfo", 0);
    public static final SemanticsPropertyKey CollectionItemInfo = new SemanticsPropertyKey("CollectionItemInfo", 0);
    public static final SemanticsPropertyKey Heading = new SemanticsPropertyKey("Heading", 0);
    public static final SemanticsPropertyKey TextEntryKey = new SemanticsPropertyKey("TextEntryKey", 0);
    public static final SemanticsPropertyKey Disabled = new SemanticsPropertyKey("Disabled", 0);
    public static final SemanticsPropertyKey LiveRegion = new SemanticsPropertyKey("LiveRegion", 0);
    public static final SemanticsPropertyKey Focused = new SemanticsPropertyKey("Focused", 0);
    public static final SemanticsPropertyKey IsContainer = new SemanticsPropertyKey("IsContainer", 0);
    public static final SemanticsPropertyKey IsTraversalGroup = new SemanticsPropertyKey("IsTraversalGroup");
    public static final SemanticsPropertyKey IsSensitiveData = new SemanticsPropertyKey("IsSensitiveData");
    public static final SemanticsPropertyKey InvisibleToUser = new SemanticsPropertyKey("InvisibleToUser", new Updater$$ExternalSyntheticLambda0((byte) 24));
    public static final SemanticsPropertyKey HideFromAccessibility = new SemanticsPropertyKey("HideFromAccessibility", new Updater$$ExternalSyntheticLambda0((byte) 24));
    public static final SemanticsPropertyKey ContentType = new SemanticsPropertyKey("ContentType", new Updater$$ExternalSyntheticLambda0((byte) 28));
    public static final SemanticsPropertyKey ContentDataType = new SemanticsPropertyKey("ContentDataType", new Updater$$ExternalSyntheticLambda0((byte) 29));
    public static final SemanticsPropertyKey FillableData = new SemanticsPropertyKey("FillableData", new SaversKt$$ExternalSyntheticLambda0(1));
    public static final SemanticsPropertyKey TraversalIndex = new SemanticsPropertyKey("TraversalIndex", new Updater$$ExternalSyntheticLambda0((byte) 19));
    public static final SemanticsPropertyKey HintText = new SemanticsPropertyKey("HintText", 0);
    public static final SemanticsPropertyKey HorizontalScrollAxisRange = new SemanticsPropertyKey("HorizontalScrollAxisRange", 0);
    public static final SemanticsPropertyKey VerticalScrollAxisRange = new SemanticsPropertyKey("VerticalScrollAxisRange", 0);
    public static final SemanticsPropertyKey IsPopup = new SemanticsPropertyKey("IsPopup", true, new Updater$$ExternalSyntheticLambda0((byte) 20));
    public static final SemanticsPropertyKey IsDialog = new SemanticsPropertyKey("IsDialog", true, new Updater$$ExternalSyntheticLambda0((byte) 21));
    public static final SemanticsPropertyKey Role = new SemanticsPropertyKey("Role", true, new Updater$$ExternalSyntheticLambda0((byte) 22));
    public static final SemanticsPropertyKey TestTag = new SemanticsPropertyKey("TestTag", false, new Updater$$ExternalSyntheticLambda0((byte) 23));
    public static final SemanticsPropertyKey LinkTestMarker = new SemanticsPropertyKey("LinkTestMarker", false, new Updater$$ExternalSyntheticLambda0((byte) 24));
    public static final SemanticsPropertyKey Text = new SemanticsPropertyKey("Text", true, new Updater$$ExternalSyntheticLambda0((byte) 25));
    public static final SemanticsPropertyKey TextSubstitution = new SemanticsPropertyKey("TextSubstitution");
    public static final SemanticsPropertyKey IsShowingTextSubstitution = new SemanticsPropertyKey("IsShowingTextSubstitution");
    public static final SemanticsPropertyKey InputText = new SemanticsPropertyKey("InputText", 0);
    public static final SemanticsPropertyKey EditableText = new SemanticsPropertyKey("EditableText", 0);
    public static final SemanticsPropertyKey TextSelectionRange = new SemanticsPropertyKey("TextSelectionRange", 0);
    public static final SemanticsPropertyKey TextCompositionRange = new SemanticsPropertyKey("TextCompositionRange", 0);
    public static final SemanticsPropertyKey ImeAction = new SemanticsPropertyKey("ImeAction", 0);
    public static final SemanticsPropertyKey Selected = new SemanticsPropertyKey("Selected", 0);
    public static final SemanticsPropertyKey ToggleableState = new SemanticsPropertyKey("ToggleableState", 0);
    public static final SemanticsPropertyKey InputTextSuggestionState = new SemanticsPropertyKey("InputTextSuggestionState", 0);
    public static final SemanticsPropertyKey Password = new SemanticsPropertyKey("Password", 0);
    public static final SemanticsPropertyKey Error = new SemanticsPropertyKey("Error", 0);
    public static final SemanticsPropertyKey IndexForKey = new SemanticsPropertyKey("IndexForKey");
    public static final SemanticsPropertyKey IsEditable = new SemanticsPropertyKey("IsEditable");
    public static final SemanticsPropertyKey MaxTextLength = new SemanticsPropertyKey("MaxTextLength");
    public static final SemanticsPropertyKey Shape = new SemanticsPropertyKey("Shape", false, new Updater$$ExternalSyntheticLambda0((byte) 26));
}
