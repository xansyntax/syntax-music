package androidx.media3.common;

import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AuxEffectInfo {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuxEffectInfo.class != obj.getClass()) {
            return false;
        }
        return Float.compare(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) == 0;
    }

    public final int hashCode() {
        return Float.floatToIntBits(CropImageView.DEFAULT_ASPECT_RATIO) + 16337;
    }
}
