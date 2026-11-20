package androidx.compose.ui.semantics;

import kotlin.Function;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsPropertiesKt$ActionPropertyKey$1 implements Function2 {
    public static final SemanticsPropertiesKt$ActionPropertyKey$1 INSTANCE = new SemanticsPropertiesKt$ActionPropertyKey$1();

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String str;
        Function function;
        AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
        AccessibilityAction accessibilityAction2 = (AccessibilityAction) obj2;
        if (accessibilityAction == null || (str = accessibilityAction.label) == null) {
            str = accessibilityAction2.label;
        }
        if (accessibilityAction == null || (function = accessibilityAction.action) == null) {
            function = accessibilityAction2.action;
        }
        return new AccessibilityAction(str, function);
    }
}
