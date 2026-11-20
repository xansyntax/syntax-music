package com.metrolist.music.ui.theme;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.StaticProvidableCompositionLocal;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UiStyleKt {
    public static final StaticProvidableCompositionLocal LocalUiStyle = new StaticProvidableCompositionLocal(new UiStyleKt$$ExternalSyntheticLambda0(0), (byte) 0);

    public static final boolean isGlassStyle(Composer composer) {
        return ((GapComposer) composer).consume(LocalUiStyle) == UiStyle.GLASS;
    }

    /* JADX INFO: renamed from: styledRadius-i1RSzL4, reason: not valid java name */
    public static final float m1516styledRadiusi1RSzL4(float f, float f2, Composer composer) {
        return ((GapComposer) composer).consume(LocalUiStyle) == UiStyle.GLASS ? f : f2;
    }
}
