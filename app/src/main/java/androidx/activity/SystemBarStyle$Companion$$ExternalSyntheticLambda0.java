package androidx.activity;

import android.content.res.Resources;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SystemBarStyle$Companion$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ SystemBarStyle$Companion$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((Resources) obj).getClass();
                return Boolean.FALSE;
            case 1:
                ((Resources) obj).getClass();
                return Boolean.TRUE;
            case 2:
                Resources resources = (Resources) obj;
                resources.getClass();
                return Boolean.valueOf((resources.getConfiguration().uiMode & 48) == 32);
            case 3:
                return null;
            case 4:
                return CrossfadeKt.togetherWith(EnterExitTransitionKt.fadeIn$default(ArcSplineKt.tween$default(220, 90, null, 4), CropImageView.DEFAULT_ASPECT_RATIO, 2).plus(EnterExitTransitionKt.m15scaleInL8ZKhE$default(ArcSplineKt.tween$default(220, 90, null, 4), 0.92f, 4)), EnterExitTransitionKt.fadeOut$default(ArcSplineKt.tween$default(90, 0, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2));
            case 5:
                return obj;
            case 6:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 7:
                return Integer.valueOf((-((Integer) obj).intValue()) / 2);
            case 8:
                ((Integer) obj).getClass();
                return 0;
            case 9:
                return ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, 7);
            case 10:
                return Integer.valueOf((-((Integer) obj).intValue()) / 2);
            case 11:
                return Integer.valueOf((-((Integer) obj).intValue()) / 2);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return Integer.valueOf((-((Integer) obj).intValue()) / 2);
            case 13:
                ((Integer) obj).getClass();
                return 0;
            case 14:
                return new IntOffset(0L);
            case 15:
                return (IntSize) obj;
            case 16:
                TransformOrigin transformOrigin = (TransformOrigin) obj;
                return new AnimationVector2D(Float.intBitsToFloat((int) (transformOrigin.packedValue >> 32)), Float.intBitsToFloat((int) (transformOrigin.packedValue & 4294967295L)));
            case 17:
                return new IntSize(0L);
            case 18:
                AnimationVector2D animationVector2D = (AnimationVector2D) obj;
                return new TransformOrigin(ColorKt.TransformOrigin(animationVector2D.v1, animationVector2D.v2));
            case 19:
                ((Integer) obj).getClass();
                return 0;
            case 20:
                return new IntSize(0L);
            case 21:
                ((Integer) obj).getClass();
                return 0;
            case 22:
                return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
            case 23:
                return unit;
            case 24:
                SeekableTransitionState seekableTransitionState = (SeekableTransitionState) obj;
                long j = seekableTransitionState.totalDurationNanos;
                SnapshotStateObserver snapshotStateObserver = seekableTransitionState.snapshotStateObserver;
                if (snapshotStateObserver != null) {
                    snapshotStateObserver.observeReads(seekableTransitionState, ArcSplineKt.SeekableTransitionStateTotalDurationChanged, seekableTransitionState.recalculateTotalDurationNanos);
                }
                long j2 = seekableTransitionState.totalDurationNanos;
                if (j != j2) {
                    SeekableTransitionState.SeekingAnimationState seekingAnimationState = seekableTransitionState.currentAnimation;
                    if (seekingAnimationState != null) {
                        if (seekingAnimationState.progressNanos > j2) {
                            seekableTransitionState.endAllAnimations();
                        } else {
                            seekingAnimationState.durationNanos = j2;
                            if (seekingAnimationState.animationSpec == null) {
                                seekingAnimationState.animationSpecDuration = MathKt.roundToLong((1.0d - ((double) seekingAnimationState.start.get$animation_core(0))) * seekableTransitionState.totalDurationNanos);
                            }
                        }
                    } else if (j2 != 0) {
                        seekableTransitionState.seekToFraction();
                    }
                }
                return unit;
            case 25:
                return new AnimationVector1D(((Float) obj).floatValue());
            case 26:
                return new AnimationVector1D(((Integer) obj).intValue());
            case 27:
                return Integer.valueOf((int) ((AnimationVector1D) obj).value);
            case 28:
                return new AnimationVector1D(((Dp) obj).value);
            default:
                return new Dp(((AnimationVector1D) obj).value);
        }
    }
}
