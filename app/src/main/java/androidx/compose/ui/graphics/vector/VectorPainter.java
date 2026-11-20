package androidx.compose.ui.graphics.vector;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.emoji2.text.EmojiProcessor;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VectorPainter extends Painter {
    public float currentAlpha;
    public BlendModeColorFilter currentColorFilter;
    public final ParcelableSnapshotMutableState drawInvalidation$delegate;
    public final VectorComponent vector;
    public final ParcelableSnapshotMutableState size$delegate = Stack.mutableStateOf$default(new Size(0));
    public final ParcelableSnapshotMutableState autoMirror$delegate = Stack.mutableStateOf$default(Boolean.FALSE);

    public VectorPainter(GroupComponent groupComponent) {
        VectorComponent vectorComponent = new VectorComponent(groupComponent);
        vectorComponent.invalidateCallback = new RoomDatabase$$ExternalSyntheticLambda0((byte) 7, this);
        this.vector = vectorComponent;
        this.drawInvalidation$delegate = new ParcelableSnapshotMutableState(Unit.INSTANCE, NeverEqualPolicy.INSTANCE);
        this.currentAlpha = 1.0f;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyAlpha(float f) {
        this.currentAlpha = f;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyColorFilter(BlendModeColorFilter blendModeColorFilter) {
        this.currentColorFilter = blendModeColorFilter;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public final long mo573getIntrinsicSizeNHjbRc() {
        return ((Size) this.size$delegate.getValue()).packedValue;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0050  */
    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(LayoutNodeDrawScope layoutNodeDrawScope) {
        BlendModeColorFilter blendModeColorFilter = this.currentColorFilter;
        VectorComponent vectorComponent = this.vector;
        if (blendModeColorFilter == null) {
            blendModeColorFilter = (BlendModeColorFilter) vectorComponent.intrinsicColorFilter$delegate.getValue();
        }
        if (((Boolean) this.autoMirror$delegate.getValue()).booleanValue()) {
            CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
            if (layoutNodeDrawScope.getLayoutDirection() == LayoutDirection.Rtl) {
                long jMo555getCenterF1C5BW0 = canvasDrawScope.mo555getCenterF1C5BW0();
                EmojiProcessor emojiProcessor = canvasDrawScope.drawContext;
                long jM831getSizeNHjbRc = emojiProcessor.m831getSizeNHjbRc();
                emojiProcessor.getCanvas().save();
                try {
                    ((DrawResult) emojiProcessor.mSpanFactory).m403scale0AR0LA0(-1.0f, 1.0f, jMo555getCenterF1C5BW0);
                    vectorComponent.draw(layoutNodeDrawScope, this.currentAlpha, blendModeColorFilter);
                    IntIntPair$$ExternalSyntheticOutline0.m(emojiProcessor, jM831getSizeNHjbRc);
                } catch (Throwable th) {
                    IntIntPair$$ExternalSyntheticOutline0.m(emojiProcessor, jM831getSizeNHjbRc);
                    throw th;
                }
            } else {
                vectorComponent.draw(layoutNodeDrawScope, this.currentAlpha, blendModeColorFilter);
            }
        } else {
            vectorComponent.draw(layoutNodeDrawScope, this.currentAlpha, blendModeColorFilter);
        }
        this.drawInvalidation$delegate.getValue();
    }
}
