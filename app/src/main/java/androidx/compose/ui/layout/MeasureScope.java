package androidx.compose.ui.layout;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface MeasureScope extends IntrinsicMeasureScope {
    default MeasureResult layout(int i, int i2, Map map, Function1 function1, Function1 function2) {
        if ((i & (-16777216)) != 0 || ((-16777216) & i2) != 0) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult(i, i2, map, function1, this, function2) { // from class: androidx.compose.ui.layout.MeasureScope.layout.1
            public final /* synthetic */ Function1 $placementBlock;
            public final /* synthetic */ int $width;
            public final Map alignmentLines;
            public final int height;
            public final Function1 rulers;
            public final /* synthetic */ MeasureScope this$0;
            public final int width;

            {
                this.$width = i;
                this.this$0 = this;
                this.$placementBlock = function2;
                this.width = i;
                this.height = i2;
                this.alignmentLines = map;
                this.rulers = function1;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public final Map getAlignmentLines() {
                return this.alignmentLines;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public final int getHeight() {
                return this.height;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public final Function1 getRulers() {
                return this.rulers;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public final int getWidth() {
                return this.width;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public final void placeChildren() {
                MeasureScope measureScope = this.this$0;
                boolean z = measureScope instanceof LookaheadCapablePlaceable;
                Function1 function3 = this.$placementBlock;
                if (z) {
                    function3.invoke(((LookaheadCapablePlaceable) measureScope).placementScope);
                    return;
                }
                function3.invoke(new SimplePlacementScope(this.$width, measureScope.getLayoutDirection(), measureScope.getDensity(), measureScope.getFontScale()));
            }
        };
    }

    default MeasureResult layout(int i, int i2, Map map, Function1 function1) {
        return layout(i, i2, map, null, function1);
    }
}
