package com.valentinilk.shimmer;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.metrolist.shazamkit.Shazam$$ExternalSyntheticLambda0;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.collections.CollectionsKt__IterablesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ShimmerThemeKt {
    public static final StaticProvidableCompositionLocal LocalShimmerTheme;
    public static final ShimmerTheme defaultShimmerTheme;

    static {
        MarqueeSpacing$Companion$$ExternalSyntheticLambda0 marqueeSpacing$Companion$$ExternalSyntheticLambda0 = EasingKt.LinearEasing;
        marqueeSpacing$Companion$$ExternalSyntheticLambda0.getClass();
        KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig = new KeyframesSpec.KeyframesSpecConfig();
        Float fValueOf = Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO);
        keyframesSpecConfig.at(0, fValueOf).easing = marqueeSpacing$Companion$$ExternalSyntheticLambda0;
        Float fValueOf2 = Float.valueOf(1.0f);
        keyframesSpecConfig.at(800, fValueOf2);
        keyframesSpecConfig.at(2300, fValueOf2);
        keyframesSpecConfig.durationMillis = 2300;
        defaultShimmerTheme = new ShimmerTheme(ArcSplineKt.m19infiniteRepeatable9IiC70o$default(new KeyframesSpec(keyframesSpecConfig), RepeatMode.Restart, 0L, 4), 6, 15.0f, CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{new Color(ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.25f, Color.m483getColorSpaceimpl(-4294967296L))), new Color(ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 1.0f, Color.m483getColorSpaceimpl(-4294967296L))), new Color(ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.25f, Color.m483getColorSpaceimpl(-4294967296L)))}), CollectionsKt__IterablesKt.listOf((Object[]) new Float[]{fValueOf, Float.valueOf(0.5f), fValueOf2}), 400.0f);
        LocalShimmerTheme = new StaticProvidableCompositionLocal(new Shazam$$ExternalSyntheticLambda0((byte) 17), (byte) 0);
    }
}
