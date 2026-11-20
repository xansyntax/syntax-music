package androidx.compose.ui.semantics;

import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsPropertyKey {
    public final boolean isImportantForAccessibility;
    public final Function2 mergePolicy;
    public final String name;

    public /* synthetic */ SemanticsPropertyKey(String str) {
        this(str, new SaversKt$$ExternalSyntheticLambda0((byte) 4));
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("AccessibilityKey: ", this.name);
    }

    public SemanticsPropertyKey(String str, Function2 function2) {
        this.name = str;
        this.mergePolicy = function2;
    }

    public SemanticsPropertyKey(String str, int i) {
        this(str);
        this.isImportantForAccessibility = true;
    }

    public SemanticsPropertyKey(String str, boolean z, Function2 function2) {
        this(str, function2);
        this.isImportantForAccessibility = z;
    }
}
