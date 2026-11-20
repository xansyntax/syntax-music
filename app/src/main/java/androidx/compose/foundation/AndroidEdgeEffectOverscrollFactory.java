package androidx.compose.foundation;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.ui.unit.Density;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollFactory {
    public final Context context;
    public final Density density;
    public final PaddingValuesImpl glowDrawPadding;

    public AndroidEdgeEffectOverscrollFactory(Context context, Density density, PaddingValuesImpl paddingValuesImpl) {
        this.context = context;
        this.density = density;
        this.glowDrawPadding = paddingValuesImpl;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AndroidEdgeEffectOverscrollFactory.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        AndroidEdgeEffectOverscrollFactory androidEdgeEffectOverscrollFactory = (AndroidEdgeEffectOverscrollFactory) obj;
        return Intrinsics.areEqual(this.context, androidEdgeEffectOverscrollFactory.context) && Intrinsics.areEqual(this.density, androidEdgeEffectOverscrollFactory.density) && ULong.m1869equalsimpl0(-43234558140743680L, -43234558140743680L) && this.glowDrawPadding.equals(androidEdgeEffectOverscrollFactory.glowDrawPadding);
    }

    public final int hashCode() {
        return this.glowDrawPadding.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m((this.density.hashCode() + (this.context.hashCode() * 31)) * 31, 31, -43234558140743680L);
    }
}
