package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PercentageRating extends Rating {
    public static final String FIELD_PERCENT;
    public final float percent;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_PERCENT = Integer.toString(1, 36);
    }

    public PercentageRating(float f) {
        UtilsKt.checkArgument("percent must be in the range of [0, 100]", f >= CropImageView.DEFAULT_ASPECT_RATIO && f <= 100.0f);
        this.percent = f;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof PercentageRating) {
            return this.percent == ((PercentageRating) obj).percent;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Float.valueOf(this.percent));
    }

    @Override // androidx.media3.common.Rating
    public final boolean isRated() {
        return this.percent != -1.0f;
    }

    @Override // androidx.media3.common.Rating
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.FIELD_RATING_TYPE, 1);
        bundle.putFloat(FIELD_PERCENT, this.percent);
        return bundle;
    }

    public PercentageRating() {
        this.percent = -1.0f;
    }
}
