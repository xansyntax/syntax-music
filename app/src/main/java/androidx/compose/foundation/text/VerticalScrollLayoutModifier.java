package androidx.compose.foundation.text;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ScrollNode$$ExternalSyntheticLambda2;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.unit.Constraints;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VerticalScrollLayoutModifier implements LayoutModifier {
    public final int cursorOffset;
    public final TextFieldScrollerPosition scrollerPosition;
    public final Function0 textLayoutResultProvider;
    public final TransformedText transformedText;

    public VerticalScrollLayoutModifier(TextFieldScrollerPosition textFieldScrollerPosition, int i, TransformedText transformedText, Function0 function0) {
        this.scrollerPosition = textFieldScrollerPosition;
        this.cursorOffset = i;
        this.transformedText = transformedText;
        this.textLayoutResultProvider = function0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VerticalScrollLayoutModifier) {
            VerticalScrollLayoutModifier verticalScrollLayoutModifier = (VerticalScrollLayoutModifier) obj;
            if (this.scrollerPosition == verticalScrollLayoutModifier.scrollerPosition && this.cursorOffset == verticalScrollLayoutModifier.cursorOffset && this.transformedText.equals(verticalScrollLayoutModifier.transformedText) && Intrinsics.areEqual(this.textLayoutResultProvider, verticalScrollLayoutModifier.textLayoutResultProvider)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.textLayoutResultProvider.hashCode() + ((this.transformedText.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.cursorOffset, this.scrollerPosition.hashCode() * 31, 31)) * 31);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo195measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(Constraints.m777copyZbe2FdA$default(0, 0, 0, Integer.MAX_VALUE, 7, j));
        int iMin = Math.min(placeableMo598measureBRTryo0.height, Constraints.m783getMaxHeightimpl(j));
        return measureScope.layout(placeableMo598measureBRTryo0.width, iMin, EmptyMap.INSTANCE, new ScrollNode$$ExternalSyntheticLambda2(this, placeableMo598measureBRTryo0, iMin, (byte) 1));
    }

    public final String toString() {
        return "VerticalScrollLayoutModifier(scrollerPosition=" + this.scrollerPosition + ", cursorOffset=" + this.cursorOffset + ", transformedText=" + this.transformedText + ", textLayoutResultProvider=" + this.textLayoutResultProvider + ")";
    }
}
