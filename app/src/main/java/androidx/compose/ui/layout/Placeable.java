package androidx.compose.ui.layout;

import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.MotionReferencePlacementDelegate;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function1;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Placeable {
    public int height;
    public int width;
    public long measuredSize = 0;
    public long measurementConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15);
    public long apparentToRealOffset = 0;

    public abstract int get(AlignmentLine alignmentLine);

    public int getMeasuredHeight() {
        return (int) (this.measuredSize & 4294967295L);
    }

    public int getMeasuredWidth() {
        return (int) (this.measuredSize >> 32);
    }

    public Object getParentData() {
        return null;
    }

    public final void onMeasuredSizeChanged() {
        this.width = UuidKt.coerceIn((int) (this.measuredSize >> 32), Constraints.m786getMinWidthimpl(this.measurementConstraints), Constraints.m784getMaxWidthimpl(this.measurementConstraints));
        int iCoerceIn = UuidKt.coerceIn((int) (this.measuredSize & 4294967295L), Constraints.m785getMinHeightimpl(this.measurementConstraints), Constraints.m783getMaxHeightimpl(this.measurementConstraints));
        this.height = iCoerceIn;
        int i = this.width;
        long j = this.measuredSize;
        this.apparentToRealOffset = (((long) ((i - ((int) (j >> 32))) / 2)) << 32) | (4294967295L & ((long) ((iCoerceIn - ((int) (j & 4294967295L))) / 2)));
    }

    /* JADX INFO: renamed from: placeAt-f8xVGno, reason: not valid java name */
    public void mo616placeAtf8xVGno(long j, float f, GraphicsLayer graphicsLayer) {
        mo602placeAtf8xVGno(j, f, (Function1) null);
    }

    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public abstract void mo602placeAtf8xVGno(long j, float f, Function1 function1);

    /* JADX INFO: renamed from: setMeasuredSize-ozmzZPI, reason: not valid java name */
    public final void m617setMeasuredSizeozmzZPI(long j) {
        if (IntSize.m810equalsimpl0(this.measuredSize, j)) {
            return;
        }
        this.measuredSize = j;
        onMeasuredSizeChanged();
    }

    /* JADX INFO: renamed from: setMeasurementConstraints-BRTryo0, reason: not valid java name */
    public final void m618setMeasurementConstraintsBRTryo0(long j) {
        if (Constraints.m778equalsimpl0(this.measurementConstraints, j)) {
            return;
        }
        this.measurementConstraints = j;
        onMeasuredSizeChanged();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class PlacementScope implements Density {
        public boolean motionFrameOfReferencePlacement;

        /* JADX INFO: renamed from: place-70tqf50$default, reason: not valid java name */
        public static void m619place70tqf50$default(PlacementScope placementScope, Placeable placeable, long j) {
            placementScope.handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo602placeAtf8xVGno(IntOffset.m806plusqkQi6aY(j, placeable.apparentToRealOffset), CropImageView.DEFAULT_ASPECT_RATIO, (Function1) null);
        }

        public static void placeRelative$default(PlacementScope placementScope, Placeable placeable, int i, int i2) {
            long j = (((long) i) << 32) | (((long) i2) & 4294967295L);
            if (placementScope.getParentLayoutDirection() == LayoutDirection.Ltr || placementScope.getParentWidth() == 0) {
                placementScope.handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo602placeAtf8xVGno(IntOffset.m806plusqkQi6aY(j, placeable.apparentToRealOffset), CropImageView.DEFAULT_ASPECT_RATIO, (Function1) null);
            } else {
                int parentWidth = (placementScope.getParentWidth() - placeable.width) - ((int) (j >> 32));
                placementScope.handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo602placeAtf8xVGno(IntOffset.m806plusqkQi6aY((((long) parentWidth) << 32) | (((long) ((int) (j & 4294967295L))) & 4294967295L), placeable.apparentToRealOffset), CropImageView.DEFAULT_ASPECT_RATIO, (Function1) null);
            }
        }

        public static void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, Function1 function1, int i3) {
            if ((i3 & 8) != 0) {
                function1 = RulerKt.DefaultLayerBlock;
            }
            long j = (((long) i) << 32) | (((long) i2) & 4294967295L);
            if (placementScope.getParentLayoutDirection() == LayoutDirection.Ltr || placementScope.getParentWidth() == 0) {
                placementScope.handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo602placeAtf8xVGno(IntOffset.m806plusqkQi6aY(j, placeable.apparentToRealOffset), CropImageView.DEFAULT_ASPECT_RATIO, function1);
            } else {
                placementScope.handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo602placeAtf8xVGno(IntOffset.m806plusqkQi6aY((((long) ((placementScope.getParentWidth() - placeable.width) - ((int) (j >> 32)))) << 32) | (((long) ((int) (j & 4294967295L))) & 4294967295L), placeable.apparentToRealOffset), CropImageView.DEFAULT_ASPECT_RATIO, function1);
            }
        }

        /* JADX INFO: renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static void m620placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j) {
            ComposedModifierKt$$ExternalSyntheticLambda0 composedModifierKt$$ExternalSyntheticLambda0 = RulerKt.DefaultLayerBlock;
            if (placementScope.getParentLayoutDirection() == LayoutDirection.Ltr || placementScope.getParentWidth() == 0) {
                placementScope.handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo602placeAtf8xVGno(IntOffset.m806plusqkQi6aY(j, placeable.apparentToRealOffset), CropImageView.DEFAULT_ASPECT_RATIO, composedModifierKt$$ExternalSyntheticLambda0);
            } else {
                int parentWidth = (placementScope.getParentWidth() - placeable.width) - ((int) (j >> 32));
                placementScope.handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo602placeAtf8xVGno(IntOffset.m806plusqkQi6aY((((long) ((int) (j & 4294967295L))) & 4294967295L) | (((long) parentWidth) << 32), placeable.apparentToRealOffset), CropImageView.DEFAULT_ASPECT_RATIO, composedModifierKt$$ExternalSyntheticLambda0);
            }
        }

        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, Function1 function1, int i3) {
            if ((i3 & 8) != 0) {
                function1 = RulerKt.DefaultLayerBlock;
            }
            placementScope.placeWithLayer(placeable, i, i2, CropImageView.DEFAULT_ASPECT_RATIO, function1);
        }

        /* JADX INFO: renamed from: placeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static void m622placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j) {
            ComposedModifierKt$$ExternalSyntheticLambda0 composedModifierKt$$ExternalSyntheticLambda0 = RulerKt.DefaultLayerBlock;
            placementScope.handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo602placeAtf8xVGno(IntOffset.m806plusqkQi6aY(j, placeable.apparentToRealOffset), CropImageView.DEFAULT_ASPECT_RATIO, composedModifierKt$$ExternalSyntheticLambda0);
        }

        public abstract LayoutDirection getParentLayoutDirection();

        public abstract int getParentWidth();

        /* JADX WARN: Multi-variable type inference failed */
        public final void handleMotionFrameOfReferencePlacement(Placeable placeable) {
            if (placeable instanceof MotionReferencePlacementDelegate) {
                ((MotionReferencePlacementDelegate) placeable).updatePlacedUnderMotionFrameOfReference(this.motionFrameOfReferencePlacement);
            }
        }

        public final void place(Placeable placeable, int i, int i2, float f) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo602placeAtf8xVGno(IntOffset.m806plusqkQi6aY((((long) i2) & 4294967295L) | (((long) i) << 32), placeable.apparentToRealOffset), f, (Function1) null);
        }

        public final void placeWithLayer(Placeable placeable, int i, int i2, float f, Function1 function1) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo602placeAtf8xVGno(IntOffset.m806plusqkQi6aY((((long) i2) & 4294967295L) | (((long) i) << 32), placeable.apparentToRealOffset), f, function1);
        }

        public float current(VerticalRuler verticalRuler, float f) {
            return f;
        }

        /* JADX INFO: renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static void m621placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, GraphicsLayer graphicsLayer) {
            if (placementScope.getParentLayoutDirection() != LayoutDirection.Ltr && placementScope.getParentWidth() != 0) {
                int parentWidth = (placementScope.getParentWidth() - placeable.width) - ((int) (j >> 32));
                placementScope.handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo616placeAtf8xVGno(IntOffset.m806plusqkQi6aY((((long) ((int) (j & 4294967295L))) & 4294967295L) | (((long) parentWidth) << 32), placeable.apparentToRealOffset), CropImageView.DEFAULT_ASPECT_RATIO, graphicsLayer);
                return;
            }
            placementScope.handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo616placeAtf8xVGno(IntOffset.m806plusqkQi6aY(j, placeable.apparentToRealOffset), CropImageView.DEFAULT_ASPECT_RATIO, graphicsLayer);
        }
    }
}
