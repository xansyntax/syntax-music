package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.layout.IntrinsicSizeModifier;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.metrolist.music.ui.component.LyricsLineKt$WordLevelLyrics$2$1;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SizeAnimationModifierNode extends IntrinsicSizeModifier {
    public final ParcelableSnapshotMutableState animData$delegate;
    public AnimationSpec animationSpec;
    public long lookaheadConstraints;
    public boolean lookaheadConstraintsAvailable;
    public long lookaheadSize;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnimData {
        public final Animatable anim;
        public long startSize;

        public AnimData(Animatable animatable, long j) {
            this.anim = animatable;
            this.startSize = j;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AnimData) {
                AnimData animData = (AnimData) obj;
                if (this.anim == animData.anim && IntSize.m810equalsimpl0(this.startSize, animData.startSize)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Long.hashCode(this.startSize) + (this.anim.hashCode() * 31);
        }

        public final String toString() {
            return "AnimData(anim=" + this.anim + ", startSize=" + IntSize.m811toStringimpl(this.startSize) + ")";
        }
    }

    public SizeAnimationModifierNode(AnimationSpec animationSpec) {
        super((byte) 1);
        this.animationSpec = animationSpec;
        this.lookaheadSize = -9223372034707292160L;
        this.lookaheadConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15);
        this.animData$delegate = Stack.mutableStateOf$default(null);
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier, androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
        Placeable placeableMo598measureBRTryo0;
        AnimData animData;
        long jM789constrain4WqzIAM;
        AnimData animData2;
        if (measureScope.isLookingAhead()) {
            this.lookaheadConstraints = j;
            this.lookaheadConstraintsAvailable = true;
            placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(j);
        } else {
            placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(this.lookaheadConstraintsAvailable ? this.lookaheadConstraints : j);
        }
        final Placeable placeable = placeableMo598measureBRTryo0;
        char c = ' ';
        long j2 = (((long) placeable.height) & 4294967295L) | (((long) placeable.width) << 32);
        if (measureScope.isLookingAhead()) {
            this.lookaheadSize = j2;
            c = ' ';
            jM789constrain4WqzIAM = j2;
            j2 = jM789constrain4WqzIAM;
        } else {
            long j3 = !IntSize.m810equalsimpl0(this.lookaheadSize, -9223372034707292160L) ? this.lookaheadSize : j2;
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.animData$delegate;
            AnimData animData3 = (AnimData) parcelableSnapshotMutableState.getValue();
            if (animData3 != null) {
                Animatable animatable = animData3.anim;
                boolean z = (IntSize.m810equalsimpl0(j3, ((IntSize) animatable.getValue()).packedValue) || animatable.isRunning()) ? false : true;
                if (!IntSize.m810equalsimpl0(j3, ((IntSize) animatable.targetValue$delegate.getValue()).packedValue) || z) {
                    animData3.startSize = ((IntSize) animatable.getValue()).packedValue;
                    animData2 = animData3;
                    AwaitKt.launch$default(getCoroutineScope(), null, null, new LyricsLineKt$WordLevelLyrics$2$1(animData2, j3, this, null), 3);
                } else {
                    animData2 = animData3;
                }
                animData = animData2;
            } else {
                long j4 = j3;
                animData = new AnimData(new Animatable(new IntSize(j4), ArcSplineKt.IntSizeToVector, new IntSize(4294967297L), 8), j4);
            }
            parcelableSnapshotMutableState.setValue(animData);
            jM789constrain4WqzIAM = ConstraintsKt.m789constrain4WqzIAM(j, ((IntSize) animData.anim.getValue()).packedValue);
        }
        final int i = (int) (jM789constrain4WqzIAM >> c);
        final int i2 = (int) (jM789constrain4WqzIAM & 4294967295L);
        final long j5 = j2;
        return measureScope.layout(i, i2, EmptyMap.INSTANCE, new Function1(this) { // from class: androidx.compose.animation.SizeAnimationModifierNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                long j6 = (((long) i) << 32) | (((long) i2) & 4294967295L);
                LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                long j7 = j5;
                float f = (((int) (j6 >> 32)) - ((int) (j7 >> 32))) / 2.0f;
                float f2 = (((int) (j6 & 4294967295L)) - ((int) (j7 & 4294967295L))) / 2.0f;
                float f3 = layoutDirection == LayoutDirection.Ltr ? -1.0f : (-1.0f) * (-1.0f);
                float f4 = (1.0f - 1.0f) * f2;
                int iRound = Math.round((f3 + 1.0f) * f);
                Placeable.PlacementScope.m619place70tqf50$default(placementScope, placeable, (((long) Math.round(f4)) & 4294967295L) | (((long) iRound) << 32));
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        this.lookaheadSize = -9223372034707292160L;
        this.lookaheadConstraintsAvailable = false;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onReset() {
        this.animData$delegate.setValue(null);
    }
}
