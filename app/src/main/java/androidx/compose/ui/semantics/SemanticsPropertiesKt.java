package androidx.compose.ui.semantics;

import androidx.compose.ui.autofill.AndroidContentDataType;
import androidx.compose.ui.autofill.AndroidFillableData;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.state.ToggleableState;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SemanticsPropertiesKt {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "hintText", "getHintText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "stateDescription", "getStateDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "progressBarRangeInfo", "getProgressBarRangeInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "paneTitle", "getPaneTitle(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "liveRegion", "getLiveRegion(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "focused", "getFocused(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isContainer", "isContainer(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isTraversalGroup", "isTraversalGroup(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isSensitiveData", "isSensitiveData(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "contentType", "getContentType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentType;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "contentDataType", "getContentDataType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentDataType;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "fillableData", "getFillableData(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/FillableData;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "traversalIndex", "getTraversalIndex(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)F", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "horizontalScrollAxisRange", "getHorizontalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "verticalScrollAxisRange", "getVerticalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "role", "getRole(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "testTag", "getTestTag(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "textSubstitution", "getTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isShowingTextSubstitution", "isShowingTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "inputText", "getInputText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "editableText", "getEditableText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "textSelectionRange", "getTextSelectionRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "textCompositionRange", "getTextCompositionRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/TextRange;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "imeAction", "getImeAction(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "selected", "getSelected(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "collectionInfo", "getCollectionInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "collectionItemInfo", "getCollectionItemInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "toggleableState", "getToggleableState(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "inputTextSuggestionState", "getInputTextSuggestionState(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/InputTextSuggestionState;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "isEditable", "isEditable(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "maxTextLength", "getMaxTextLength(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "shape", "getShape(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/graphics/Shape;", 1), new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "customActions", "getCustomActions(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", 1)};

    static {
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
        SemanticsPropertyKey semanticsPropertyKey2 = SemanticsActions.GetTextLayoutResult;
    }

    public static final void setContentDataType(SemanticsPropertyReceiver semanticsPropertyReceiver, AndroidContentDataType androidContentDataType) {
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDataType;
        KProperty kProperty = $$delegatedProperties[10];
        semanticsPropertyKey.getClass();
        semanticsPropertyReceiver.set(semanticsPropertyKey, androidContentDataType);
    }

    public static final void setContentDescription(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
        semanticsPropertyReceiver.set(SemanticsProperties.ContentDescription, CollectionsKt__IterablesKt.listOf(str));
    }

    public static final void setContentType(SemanticsPropertyReceiver semanticsPropertyReceiver, ContentType contentType) {
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
        SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.ContentType;
        KProperty kProperty = $$delegatedProperties[9];
        semanticsPropertyKey2.getClass();
        semanticsPropertyReceiver.set(semanticsPropertyKey2, contentType);
    }

    public static final void setFillableData(SemanticsPropertyReceiver semanticsPropertyReceiver, AndroidFillableData androidFillableData) {
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.FillableData;
        KProperty kProperty = $$delegatedProperties[11];
        semanticsPropertyKey.getClass();
        semanticsPropertyReceiver.set(semanticsPropertyKey, androidFillableData);
    }

    /* JADX INFO: renamed from: setLiveRegion-hR3wRGc, reason: not valid java name */
    public static final void m717setLiveRegionhR3wRGc(SemanticsPropertyReceiver semanticsPropertyReceiver, int i) {
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.LiveRegion;
        KProperty kProperty = $$delegatedProperties[4];
        LiveRegionMode liveRegionMode = new LiveRegionMode(i);
        semanticsPropertyKey.getClass();
        semanticsPropertyReceiver.set(semanticsPropertyKey, liveRegionMode);
    }

    public static final void setPaneTitle(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
        SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.PaneTitle;
        KProperty kProperty = $$delegatedProperties[3];
        semanticsPropertyKey2.getClass();
        semanticsPropertyReceiver.set(semanticsPropertyKey2, str);
    }

    public static final void setProgressBarRangeInfo(SemanticsPropertyReceiver semanticsPropertyReceiver, ProgressBarRangeInfo progressBarRangeInfo) {
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
        SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.ProgressBarRangeInfo;
        KProperty kProperty = $$delegatedProperties[2];
        semanticsPropertyKey2.getClass();
        semanticsPropertyReceiver.set(semanticsPropertyKey2, progressBarRangeInfo);
    }

    /* JADX INFO: renamed from: setRole-kuIjeqM, reason: not valid java name */
    public static final void m718setRolekuIjeqM(SemanticsPropertyReceiver semanticsPropertyReceiver, int i) {
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.Role;
        KProperty kProperty = $$delegatedProperties[15];
        Role role = new Role(i);
        semanticsPropertyKey.getClass();
        semanticsPropertyReceiver.set(semanticsPropertyKey, role);
    }

    public static final void setSelected(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z) {
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
        SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.Selected;
        KProperty kProperty = $$delegatedProperties[24];
        Boolean boolValueOf = Boolean.valueOf(z);
        semanticsPropertyKey2.getClass();
        semanticsPropertyReceiver.set(semanticsPropertyKey2, boolValueOf);
    }

    public static final void setShape(SemanticsPropertyReceiver semanticsPropertyReceiver, Shape shape) {
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
        SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.Shape;
        KProperty kProperty = $$delegatedProperties[31];
        semanticsPropertyKey2.getClass();
        semanticsPropertyReceiver.set(semanticsPropertyKey2, shape);
    }

    public static final void setToggleableState(SemanticsPropertyReceiver semanticsPropertyReceiver, ToggleableState toggleableState) {
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
        SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.ToggleableState;
        KProperty kProperty = $$delegatedProperties[27];
        semanticsPropertyKey2.getClass();
        semanticsPropertyReceiver.set(semanticsPropertyKey2, toggleableState);
    }

    public static final void setTraversalGroup(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.IsTraversalGroup;
        KProperty kProperty = $$delegatedProperties[7];
        Boolean bool = Boolean.TRUE;
        semanticsPropertyKey.getClass();
        semanticsPropertyReceiver.set(semanticsPropertyKey, bool);
    }

    public static final void setTraversalIndex(SemanticsPropertyReceiver semanticsPropertyReceiver, float f) {
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
        SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.TraversalIndex;
        KProperty kProperty = $$delegatedProperties[12];
        Float fValueOf = Float.valueOf(f);
        semanticsPropertyKey2.getClass();
        semanticsPropertyReceiver.set(semanticsPropertyKey2, fValueOf);
    }
}
