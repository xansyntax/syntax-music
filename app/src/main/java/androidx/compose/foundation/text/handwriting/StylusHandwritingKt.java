package androidx.compose.foundation.text.handwriting;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.StylusHoverIconModifierElement;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class StylusHandwritingKt {
    public static final DpTouchBoundsExpansion HandwritingBoundsExpansion = new DpTouchBoundsExpansion();

    public static final Modifier stylusHandwriting(boolean z, boolean z2, Function0 function0) {
        Modifier stylusHoverIconModifierElement = Modifier.Companion.$$INSTANCE;
        if (!z || !StylusHandwriting_androidKt.isStylusHandwritingSupported) {
            return stylusHoverIconModifierElement;
        }
        if (z2) {
            stylusHoverIconModifierElement = new StylusHoverIconModifierElement(HandwritingBoundsExpansion);
        }
        return stylusHoverIconModifierElement.then(new StylusHandwritingElement(function0));
    }
}
