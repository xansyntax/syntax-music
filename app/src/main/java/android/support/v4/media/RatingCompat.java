package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new FragmentState.AnonymousClass1(4);
    public final int mRatingStyle;
    public final float mRatingValue;

    public RatingCompat(int i, float f) {
        this.mRatingStyle = i;
        this.mRatingValue = f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.mRatingStyle;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.mRatingStyle);
        sb.append(" rating=");
        float f = this.mRatingValue;
        sb.append(f < CropImageView.DEFAULT_ASPECT_RATIO ? "unrated" : String.valueOf(f));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mRatingStyle);
        parcel.writeFloat(this.mRatingValue);
    }
}
