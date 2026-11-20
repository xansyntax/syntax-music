package dev.chrisbanes.haze;

import android.os.Build;
import androidx.compose.ui.unit.Dp;
import com.metrolist.shazamkit.Shazam$$ExternalSyntheticLambda0;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.ResultKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class HazeEffectNodeKt {
    public static final Lazy renderEffectCache$delegate = ResultKt.lazy(LazyThreadSafetyMode.NONE, new Shazam$$ExternalSyntheticLambda0(19));

    /* JADX INFO: renamed from: calculateInputScaleFactor-3ABfNKs$default, reason: not valid java name */
    public static float m1544calculateInputScaleFactor3ABfNKs$default(HazeEffectNode hazeEffectNode) {
        float fResolveBlurRadius = resolveBlurRadius(hazeEffectNode);
        HazeInputScale$None hazeInputScale$None = hazeEffectNode.inputScale;
        if (Intrinsics.areEqual(hazeInputScale$None, HazeInputScale$None.INSTANCE)) {
            return 1.0f;
        }
        if (Intrinsics.areEqual(hazeInputScale$None, HazeInputScale$Auto.INSTANCE)) {
            return Dp.m795compareTo0680j_4(fResolveBlurRadius, 7.0f) < 0 ? 1.0f : 0.3334f;
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public static final boolean resolveBlurEnabled(HazeEffectNode hazeEffectNode) {
        HazeState hazeState = hazeEffectNode.state;
        if (hazeState != null) {
            return ((Boolean) hazeState.blurEnabled$delegate.getValue()).booleanValue();
        }
        return Build.VERSION.SDK_INT >= 31;
    }

    public static final float resolveBlurRadius(HazeEffectNode hazeEffectNode) {
        float f = hazeEffectNode.blurRadius;
        if (Float.isNaN(f)) {
            f = hazeEffectNode.style.blurRadius;
        }
        return !Float.isNaN(f) ? f : hazeEffectNode.compositionLocalStyle.blurRadius;
    }

    public static final float resolveNoiseFactor(HazeEffectNode hazeEffectNode) {
        float f = hazeEffectNode.noiseFactor;
        if (CropImageView.DEFAULT_ASPECT_RATIO > f || f > 1.0f) {
            f = hazeEffectNode.style.noiseFactor;
        }
        return (CropImageView.DEFAULT_ASPECT_RATIO > f || f > 1.0f) ? hazeEffectNode.compositionLocalStyle.noiseFactor : f;
    }

    public static final List resolveTints(HazeEffectNode hazeEffectNode) {
        hazeEffectNode.tints.getClass();
        List list = hazeEffectNode.style.tints;
        if (list.isEmpty()) {
            list = null;
        }
        if (list != null) {
            return list;
        }
        List list2 = hazeEffectNode.compositionLocalStyle.tints;
        List list3 = list2.isEmpty() ? null : list2;
        return list3 == null ? EmptyList.INSTANCE : list3;
    }
}
