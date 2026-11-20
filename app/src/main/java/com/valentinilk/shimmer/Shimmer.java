package com.valentinilk.shimmer;

import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Shimmer {
    public final StateFlowImpl boundsFlow;
    public final ShimmerEffect effect;
    public final ShimmerTheme theme;

    public Shimmer(ShimmerTheme shimmerTheme, ShimmerEffect shimmerEffect, Rect rect) {
        shimmerEffect.getClass();
        this.theme = shimmerTheme;
        this.effect = shimmerEffect;
        this.boundsFlow = StateFlowKt.MutableStateFlow(rect);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Shimmer.class != obj.getClass()) {
            return false;
        }
        Shimmer shimmer = (Shimmer) obj;
        return this.theme.equals(shimmer.theme) && Intrinsics.areEqual(this.effect, shimmer.effect);
    }

    public final int hashCode() {
        return this.effect.hashCode() + (this.theme.hashCode() * 31);
    }
}
