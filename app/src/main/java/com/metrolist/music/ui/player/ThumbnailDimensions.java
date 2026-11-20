package com.metrolist.music.ui.player;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ThumbnailDimensions {
    public final float containerSize;
    public final float itemWidth;
    public final float thumbnailSize;

    public ThumbnailDimensions(float f, float f2, float f3) {
        this.itemWidth = f;
        this.containerSize = f2;
        this.thumbnailSize = f3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThumbnailDimensions)) {
            return false;
        }
        ThumbnailDimensions thumbnailDimensions = (ThumbnailDimensions) obj;
        return Dp.m796equalsimpl0(this.itemWidth, thumbnailDimensions.itemWidth) && Dp.m796equalsimpl0(this.containerSize, thumbnailDimensions.containerSize) && Dp.m796equalsimpl0(this.thumbnailSize, thumbnailDimensions.thumbnailSize) && Dp.m796equalsimpl0(16.0f, 16.0f);
    }

    public final int hashCode() {
        return Float.hashCode(16.0f) + IntIntPair$$ExternalSyntheticOutline0.m(this.thumbnailSize, IntIntPair$$ExternalSyntheticOutline0.m(this.containerSize, Float.hashCode(this.itemWidth) * 31, 31), 31);
    }

    public final String toString() {
        String strM797toStringimpl = Dp.m797toStringimpl(this.itemWidth);
        String strM797toStringimpl2 = Dp.m797toStringimpl(this.containerSize);
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("ThumbnailDimensions(itemWidth=", strM797toStringimpl, ", containerSize=", strM797toStringimpl2, ", thumbnailSize="), Dp.m797toStringimpl(this.thumbnailSize), ", cornerRadius=", Dp.m797toStringimpl(16.0f), ")");
    }
}
