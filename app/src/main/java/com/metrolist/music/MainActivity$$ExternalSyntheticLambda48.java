package com.metrolist.music;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.gestures.UpdatableAnimationState;
import androidx.compose.foundation.pager.PagerScrollScopeKt$LazyLayoutScrollScope$1;
import androidx.compose.material3.ThumbNode;
import androidx.compose.runtime.State;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.Dp;
import androidx.emoji2.text.EmojiProcessor;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.ui.component.BottomSheetState;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda48 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ float f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda48(UpdatableAnimationState updatableAnimationState, float f, Function1 function1) {
        this.$r8$classId = (byte) 1;
        this.f$1 = updatableAnimationState;
        this.f$0 = f;
        this.f$2 = function1;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0080  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        float fFloatValue = CropImageView.DEFAULT_ASPECT_RATIO;
        Unit unit = Unit.INSTANCE;
        float f = this.f$0;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        switch (b) {
            case 0:
                BottomSheetState bottomSheetState = (BottomSheetState) obj3;
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                int i = MainActivity.$r8$clinit;
                reusableGraphicsLayerScope.getClass();
                float density = reusableGraphicsLayerScope.graphicsDensity.getDensity() * ((Dp) ((State) obj2).getValue()).value;
                float density2 = reusableGraphicsLayerScope.graphicsDensity.getDensity() * f;
                if (density != CropImageView.DEFAULT_ASPECT_RATIO) {
                    float fCoerceIn = UuidKt.coerceIn(bottomSheetState.getProgress(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f) * density2;
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    density2 = ((1.0f - (density / (reusableGraphicsLayerScope.graphicsDensity.getDensity() * 80.0f))) * density2) + fCoerceIn;
                }
                reusableGraphicsLayerScope.setTranslationY(density2);
                return unit;
            case 1:
                UpdatableAnimationState updatableAnimationState = (UpdatableAnimationState) obj3;
                Function1 function1 = (Function1) obj2;
                long jLongValue = ((Long) obj).longValue();
                long j = updatableAnimationState.lastFrameTime;
                if (j == Long.MIN_VALUE) {
                    updatableAnimationState.lastFrameTime = jLongValue;
                    j = jLongValue;
                }
                float f2 = updatableAnimationState.value;
                AnimationVector1D animationVector1D = new AnimationVector1D(f2);
                AnimationVector1D animationVector1D2 = UpdatableAnimationState.ZeroVector;
                long durationNanos = f == CropImageView.DEFAULT_ASPECT_RATIO ? updatableAnimationState.vectorizedSpec.getDurationNanos(new AnimationVector1D(f2), animationVector1D2, updatableAnimationState.lastVelocity) : MathKt.roundToLong((jLongValue - j) / f);
                float f3 = ((AnimationVector1D) updatableAnimationState.vectorizedSpec.getValueFromNanos(durationNanos, animationVector1D, animationVector1D2, updatableAnimationState.lastVelocity)).value;
                updatableAnimationState.lastVelocity = (AnimationVector1D) updatableAnimationState.vectorizedSpec.getVelocityFromNanos(durationNanos, animationVector1D, animationVector1D2, updatableAnimationState.lastVelocity);
                updatableAnimationState.lastFrameTime = jLongValue;
                float f4 = updatableAnimationState.value - f3;
                updatableAnimationState.value = f3;
                function1.invoke(Float.valueOf(f4));
                return unit;
            case 2:
                Ref$FloatRef ref$FloatRef = (Ref$FloatRef) obj3;
                PagerScrollScopeKt$LazyLayoutScrollScope$1 pagerScrollScopeKt$LazyLayoutScrollScope$1 = (PagerScrollScopeKt$LazyLayoutScrollScope$1) obj2;
                AnimationScope animationScope = (AnimationScope) obj;
                if (f > CropImageView.DEFAULT_ASPECT_RATIO) {
                    fFloatValue = ((Number) animationScope.value$delegate.getValue()).floatValue();
                    if (fFloatValue > f) {
                        fFloatValue = f;
                    }
                } else if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
                    fFloatValue = ((Number) animationScope.value$delegate.getValue()).floatValue();
                    if (fFloatValue < f) {
                        fFloatValue = f;
                    }
                }
                float f5 = fFloatValue - ref$FloatRef.element;
                if (f5 != pagerScrollScopeKt$LazyLayoutScrollScope$1.scrollBy(f5) || fFloatValue != ((Number) animationScope.value$delegate.getValue()).floatValue()) {
                    animationScope.cancelAnimation();
                }
                ref$FloatRef.element += f5;
                return unit;
            case 3:
                ImageBitmap imageBitmap = (ImageBitmap) obj3;
                BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) obj2;
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope.drawContent();
                EmojiProcessor emojiProcessor = layoutNodeDrawScope.canvasDrawScope.drawContext;
                long jM831getSizeNHjbRc = emojiProcessor.m831getSizeNHjbRc();
                emojiProcessor.getCanvas().save();
                try {
                    DrawResult drawResult = (DrawResult) emojiProcessor.mSpanFactory;
                    drawResult.translate(f, CropImageView.DEFAULT_ASPECT_RATIO);
                    drawResult.m402rotateUv8p0NA(0L, 45.0f);
                    DrawScope.m545drawImagegbVJVH8$default(layoutNodeDrawScope, imageBitmap, blendModeColorFilter, 46);
                    return unit;
                } finally {
                    IntIntPair$$ExternalSyntheticOutline0.m(emojiProcessor, jM831getSizeNHjbRc);
                }
            default:
                Placeable placeable = (Placeable) obj3;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                Animatable animatable = ((ThumbNode) obj2).offsetAnim;
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, animatable != null ? (int) ((Number) animatable.getValue()).floatValue() : (int) f, 0);
                return unit;
        }
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda48(float f, Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = f;
        this.f$1 = obj;
        this.f$2 = obj2;
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda48(Placeable placeable, ThumbNode thumbNode, float f) {
        this.$r8$classId = (byte) 4;
        this.f$1 = placeable;
        this.f$2 = thumbNode;
        this.f$0 = f;
    }
}
