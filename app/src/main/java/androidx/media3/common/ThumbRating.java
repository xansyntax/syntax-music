package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.util.Util;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ThumbRating extends Rating {
    public static final String FIELD_IS_THUMBS_UP;
    public static final String FIELD_RATED;
    public final boolean isThumbsUp;
    public final boolean rated;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_RATED = Integer.toString(1, 36);
        FIELD_IS_THUMBS_UP = Integer.toString(2, 36);
    }

    public ThumbRating() {
        this.rated = false;
        this.isThumbsUp = false;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ThumbRating)) {
            return false;
        }
        ThumbRating thumbRating = (ThumbRating) obj;
        return this.isThumbsUp == thumbRating.isThumbsUp && this.rated == thumbRating.rated;
    }

    public final int hashCode() {
        return Objects.hash(Boolean.valueOf(this.rated), Boolean.valueOf(this.isThumbsUp));
    }

    @Override // androidx.media3.common.Rating
    public final boolean isRated() {
        return this.rated;
    }

    @Override // androidx.media3.common.Rating
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.FIELD_RATING_TYPE, 3);
        bundle.putBoolean(FIELD_RATED, this.rated);
        bundle.putBoolean(FIELD_IS_THUMBS_UP, this.isThumbsUp);
        return bundle;
    }

    public ThumbRating(boolean z) {
        this.rated = true;
        this.isThumbsUp = z;
    }
}
