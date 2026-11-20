package androidx.compose.ui.geometry;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableRect {
    public float left = CropImageView.DEFAULT_ASPECT_RATIO;
    public float top = CropImageView.DEFAULT_ASPECT_RATIO;
    public float right = CropImageView.DEFAULT_ASPECT_RATIO;
    public float bottom = CropImageView.DEFAULT_ASPECT_RATIO;

    public final void intersect(float f, float f2, float f3, float f4) {
        this.left = Math.max(f, this.left);
        this.top = Math.max(f2, this.top);
        this.right = Math.min(f3, this.right);
        this.bottom = Math.min(f4, this.bottom);
    }

    public final boolean isEmpty() {
        return (this.left >= this.right) | (this.top >= this.bottom);
    }

    public final String toString() {
        String stringAsFixed = DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(this.left);
        String stringAsFixed2 = DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(this.top);
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("MutableRect(", stringAsFixed, ", ", stringAsFixed2, ", "), DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(this.right), ", ", DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(this.bottom), ")");
    }

    /* JADX INFO: renamed from: translate-k-4lQ0M, reason: not valid java name */
    public final void m432translatek4lQ0M(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        this.left += fIntBitsToFloat;
        this.top += fIntBitsToFloat2;
        this.right += fIntBitsToFloat;
        this.bottom += fIntBitsToFloat2;
    }
}
