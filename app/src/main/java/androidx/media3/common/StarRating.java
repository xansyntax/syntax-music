package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StarRating extends Rating {
    public static final String FIELD_MAX_STARS;
    public static final String FIELD_STAR_RATING;
    public final int maxStars;
    public final float starRating;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_MAX_STARS = Integer.toString(1, 36);
        FIELD_STAR_RATING = Integer.toString(2, 36);
    }

    public StarRating(int i, float f) {
        boolean z = false;
        UtilsKt.checkArgument("maxStars must be a positive integer", i > 0);
        if (f >= CropImageView.DEFAULT_ASPECT_RATIO && f <= i) {
            z = true;
        }
        UtilsKt.checkArgument("starRating is out of range [0, maxStars]", z);
        this.maxStars = i;
        this.starRating = f;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof StarRating)) {
            return false;
        }
        StarRating starRating = (StarRating) obj;
        return this.maxStars == starRating.maxStars && this.starRating == starRating.starRating;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.maxStars), Float.valueOf(this.starRating));
    }

    @Override // androidx.media3.common.Rating
    public final boolean isRated() {
        return this.starRating != -1.0f;
    }

    @Override // androidx.media3.common.Rating
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.FIELD_RATING_TYPE, 2);
        bundle.putInt(FIELD_MAX_STARS, this.maxStars);
        bundle.putFloat(FIELD_STAR_RATING, this.starRating);
        return bundle;
    }

    public StarRating(int i) {
        UtilsKt.checkArgument("maxStars must be a positive integer", i > 0);
        this.maxStars = i;
        this.starRating = -1.0f;
    }
}
