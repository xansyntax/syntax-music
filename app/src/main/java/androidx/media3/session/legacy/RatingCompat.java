package androidx.media3.session.legacy;

import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;
import androidx.media3.common.util.Log;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new FragmentState.AnonymousClass1((byte) 25);
    public Object ratingObj;
    public final int ratingStyle;
    public final float ratingValue;

    public RatingCompat(int i, float f) {
        this.ratingStyle = i;
        this.ratingValue = f;
    }

    public static RatingCompat fromRating(Parcelable parcelable) {
        RatingCompat ratingCompat;
        RatingCompat ratingCompat2 = null;
        if (parcelable != null) {
            Rating rating = (Rating) parcelable;
            int ratingStyle = rating.getRatingStyle();
            if (!rating.isRated()) {
                switch (ratingStyle) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        ratingCompat2 = new RatingCompat(ratingStyle, -1.0f);
                        break;
                }
            } else {
                float f = CropImageView.DEFAULT_ASPECT_RATIO;
                switch (ratingStyle) {
                    case 1:
                        if (rating.hasHeart()) {
                            f = 1.0f;
                        }
                        ratingCompat = new RatingCompat(1, f);
                        break;
                    case 2:
                        if (rating.isThumbUp()) {
                            f = 1.0f;
                        }
                        ratingCompat = new RatingCompat(2, f);
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompat2 = newStarRating(ratingStyle, rating.getStarRating());
                        break;
                    case 6:
                        ratingCompat2 = newPercentageRating(rating.getPercentRating());
                        break;
                }
                ratingCompat2 = ratingCompat;
            }
            ratingCompat2.getClass();
            ratingCompat2.ratingObj = parcelable;
        }
        return ratingCompat2;
    }

    public static RatingCompat newPercentageRating(float f) {
        if (f >= CropImageView.DEFAULT_ASPECT_RATIO && f <= 100.0f) {
            return new RatingCompat(6, f);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat newStarRating(int i, float f) {
        float f2;
        if (i == 3) {
            f2 = 3.0f;
        } else if (i == 4) {
            f2 = 4.0f;
        } else {
            if (i != 5) {
                Log.e("Rating", "Invalid rating style (" + i + ") for a star rating");
                return null;
            }
            f2 = 5.0f;
        }
        if (f >= CropImageView.DEFAULT_ASPECT_RATIO && f <= f2) {
            return new RatingCompat(i, f);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.ratingStyle;
    }

    public final float getStarRating() {
        int i = this.ratingStyle;
        if ((i == 3 || i == 4 || i == 5) && isRated()) {
            return this.ratingValue;
        }
        return -1.0f;
    }

    public final boolean isRated() {
        return this.ratingValue >= CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.ratingStyle);
        sb.append(" rating=");
        float f = this.ratingValue;
        sb.append(f < CropImageView.DEFAULT_ASPECT_RATIO ? "unrated" : String.valueOf(f));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.ratingStyle);
        parcel.writeFloat(this.ratingValue);
    }
}
