package androidx.compose.ui.semantics;

import android.view.autofill.AutofillValue;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.compose.ui.autofill.AndroidAutofillManager;
import androidx.compose.ui.autofill.AndroidContentDataType;
import androidx.compose.ui.autofill.AndroidFillableData;
import androidx.compose.ui.autofill.ContentDataType$Companion;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import com.google.common.math.IntMath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsOwner {
    public final MutableObjectList listeners = new MutableObjectList(2);
    public final IntObjectMap nodes;
    public final EmptySemanticsModifier outerSemanticsNode;
    public final LayoutNode rootNode;

    public SemanticsOwner(LayoutNode layoutNode, EmptySemanticsModifier emptySemanticsModifier, MutableIntObjectMap mutableIntObjectMap) {
        this.rootNode = layoutNode;
        this.outerSemanticsNode = emptySemanticsModifier;
        this.nodes = mutableIntObjectMap;
    }

    public final SemanticsNode getUnmergedRootSemanticsNode() {
        return new SemanticsNode(this.outerSemanticsNode, false, this.rootNode, new SemanticsConfiguration());
    }

    /* JADX WARN: Code duplicated, block: B:34:0x007a  */
    /* JADX WARN: Code duplicated, block: B:42:0x008f  */
    public final void notifySemanticsChange$ui(LayoutNode layoutNode, SemanticsConfiguration semanticsConfiguration) {
        AndroidContentDataType androidContentDataType;
        AndroidContentDataType androidContentDataType2;
        String str;
        String str2;
        ToggleableState toggleableState;
        ToggleableState toggleableState2;
        AndroidFillableData androidFillableData;
        AndroidFillableData androidFillableData2;
        MutableObjectList mutableObjectList = this.listeners;
        Object[] objArr = mutableObjectList.content;
        int i = mutableObjectList._size;
        for (int i2 = 0; i2 < i; i2++) {
            AndroidAutofillManager androidAutofillManager = (AndroidAutofillManager) objArr[i2];
            androidAutofillManager.getClass();
            SemanticsConfiguration semanticsConfiguration2 = layoutNode.getSemanticsConfiguration();
            int i3 = layoutNode.semanticsId;
            WeakCache weakCache = androidAutofillManager.platformAutofillManager;
            AndroidComposeView androidComposeView = androidAutofillManager.view;
            if (semanticsConfiguration != null) {
                Object obj = semanticsConfiguration.props.get(SemanticsProperties.ContentDataType);
                if (obj == null) {
                    obj = null;
                }
                androidContentDataType = (AndroidContentDataType) obj;
            } else {
                androidContentDataType = null;
            }
            if (semanticsConfiguration2 != null) {
                Object obj2 = semanticsConfiguration2.props.get(SemanticsProperties.ContentDataType);
                if (obj2 == null) {
                    obj2 = null;
                }
                androidContentDataType2 = (AndroidContentDataType) obj2;
            } else {
                androidContentDataType2 = null;
            }
            AndroidContentDataType androidContentDataType3 = ContentDataType$Companion.None;
            if (!Intrinsics.areEqual(androidContentDataType2, androidContentDataType3)) {
                if (Intrinsics.areEqual(androidContentDataType, androidContentDataType3) && !Intrinsics.areEqual(androidContentDataType2, androidContentDataType3)) {
                    weakCache.notifyViewVisibilityChanged(androidComposeView, i3, true);
                }
                if (semanticsConfiguration != null) {
                    Object obj3 = semanticsConfiguration.props.get(SemanticsProperties.InputText);
                    if (obj3 == null) {
                        obj3 = null;
                    }
                    AnnotatedString annotatedString = (AnnotatedString) obj3;
                    if (annotatedString != null) {
                        str = annotatedString.text;
                    } else {
                        str = null;
                    }
                } else {
                    str = null;
                }
                if (semanticsConfiguration2 != null) {
                    Object obj4 = semanticsConfiguration2.props.get(SemanticsProperties.InputText);
                    if (obj4 == null) {
                        obj4 = null;
                    }
                    AnnotatedString annotatedString2 = (AnnotatedString) obj4;
                    if (annotatedString2 != null) {
                        str2 = annotatedString2.text;
                    } else {
                        str2 = null;
                    }
                } else {
                    str2 = null;
                }
                if (str != str2) {
                    if (str == null) {
                        weakCache.notifyViewVisibilityChanged(androidComposeView, i3, true);
                    } else if (str2 == null) {
                        weakCache.notifyViewVisibilityChanged(androidComposeView, i3, false);
                    } else if (Intrinsics.areEqual(androidContentDataType2, ContentDataType$Companion.Text)) {
                        weakCache.getPlatformAndroidManager().notifyValueChanged(androidComposeView, i3, AutofillValue.forText(IntMath.trimToSafeLength(str2)));
                    }
                }
                if (semanticsConfiguration != null) {
                    Object obj5 = semanticsConfiguration.props.get(SemanticsProperties.ToggleableState);
                    if (obj5 == null) {
                        obj5 = null;
                    }
                    toggleableState = (ToggleableState) obj5;
                } else {
                    toggleableState = null;
                }
                if (semanticsConfiguration2 != null) {
                    Object obj6 = semanticsConfiguration2.props.get(SemanticsProperties.ToggleableState);
                    if (obj6 == null) {
                        obj6 = null;
                    }
                    toggleableState2 = (ToggleableState) obj6;
                } else {
                    toggleableState2 = null;
                }
                if (toggleableState != toggleableState2) {
                    if (toggleableState == null) {
                        weakCache.notifyViewVisibilityChanged(androidComposeView, i3, true);
                    } else if (toggleableState2 == null) {
                        weakCache.notifyViewVisibilityChanged(androidComposeView, i3, false);
                    } else if (Intrinsics.areEqual(androidContentDataType2, ContentDataType$Companion.Toggle)) {
                        int iOrdinal = toggleableState2.ordinal();
                        Boolean bool = iOrdinal != 0 ? iOrdinal != 1 ? null : Boolean.FALSE : Boolean.TRUE;
                        if (bool != null) {
                            weakCache.getPlatformAndroidManager().notifyValueChanged(androidComposeView, i3, AutofillValue.forToggle(bool.booleanValue()));
                        }
                    }
                }
                if (semanticsConfiguration != null) {
                    Object obj7 = semanticsConfiguration.props.get(SemanticsProperties.FillableData);
                    if (obj7 == null) {
                        obj7 = null;
                    }
                    androidFillableData = (AndroidFillableData) obj7;
                } else {
                    androidFillableData = null;
                }
                if (semanticsConfiguration2 != null) {
                    Object obj8 = semanticsConfiguration2.props.get(SemanticsProperties.FillableData);
                    if (obj8 == null) {
                        obj8 = null;
                    }
                    androidFillableData2 = (AndroidFillableData) obj8;
                } else {
                    androidFillableData2 = null;
                }
                if (!Intrinsics.areEqual(androidFillableData, androidFillableData2)) {
                    if (androidFillableData == null) {
                        weakCache.notifyViewVisibilityChanged(androidComposeView, i3, true);
                    } else if (androidFillableData2 == null) {
                        weakCache.notifyViewVisibilityChanged(androidComposeView, i3, false);
                    } else {
                        weakCache.getPlatformAndroidManager().notifyValueChanged(androidComposeView, i3, androidFillableData2.autofillValue);
                    }
                }
            } else if (!Intrinsics.areEqual(androidContentDataType, androidContentDataType3)) {
                weakCache.notifyViewVisibilityChanged(androidComposeView, i3, false);
            }
            boolean z = semanticsConfiguration != null && semanticsConfiguration.props.contains(SemanticsProperties.ContentType);
            boolean z2 = semanticsConfiguration2 != null && semanticsConfiguration2.props.contains(SemanticsProperties.ContentType);
            if (z != z2) {
                MutableIntSet mutableIntSet = androidAutofillManager.currentlyDisplayedIDs;
                if (z2) {
                    mutableIntSet.add(i3);
                } else {
                    mutableIntSet.remove(i3);
                }
            }
        }
    }
}
