package androidx.media3.common;

import android.os.Bundle;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Rating {
    public static final String FIELD_RATING_TYPE;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_RATING_TYPE = Integer.toString(0, 36);
    }

    public static Rating fromBundle(Bundle bundle) {
        String str = FIELD_RATING_TYPE;
        int i = bundle.getInt(str, -1);
        if (i == 0) {
            String str2 = HeartRating.FIELD_RATED;
            UtilsKt.checkArgument(bundle.getInt(str, -1) == 0);
            return bundle.getBoolean(HeartRating.FIELD_RATED, false) ? new HeartRating(bundle.getBoolean(HeartRating.FIELD_IS_HEART, false)) : new HeartRating();
        }
        if (i == 1) {
            String str3 = PercentageRating.FIELD_PERCENT;
            UtilsKt.checkArgument(bundle.getInt(str, -1) == 1);
            float f = bundle.getFloat(PercentageRating.FIELD_PERCENT, -1.0f);
            return f == -1.0f ? new PercentageRating() : new PercentageRating(f);
        }
        if (i == 2) {
            String str4 = StarRating.FIELD_MAX_STARS;
            UtilsKt.checkArgument(bundle.getInt(str, -1) == 2);
            int i2 = bundle.getInt(StarRating.FIELD_MAX_STARS, 5);
            float f2 = bundle.getFloat(StarRating.FIELD_STAR_RATING, -1.0f);
            return f2 == -1.0f ? new StarRating(i2) : new StarRating(i2, f2);
        }
        if (i != 3) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "Unknown RatingType: "));
            return null;
        }
        String str5 = ThumbRating.FIELD_RATED;
        UtilsKt.checkArgument(bundle.getInt(str, -1) == 3);
        return bundle.getBoolean(ThumbRating.FIELD_RATED, false) ? new ThumbRating(bundle.getBoolean(ThumbRating.FIELD_IS_THUMBS_UP, false)) : new ThumbRating();
    }

    public abstract boolean isRated();

    public abstract Bundle toBundle();
}
