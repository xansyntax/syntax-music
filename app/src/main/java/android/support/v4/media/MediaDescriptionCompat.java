package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new FragmentState.AnonymousClass1((byte) 2);
    public final CharSequence mDescription;
    public MediaDescription mDescriptionFwk;
    public final Bundle mExtras;
    public final Bitmap mIcon;
    public final Uri mIconUri;
    public final String mMediaId;
    public final Uri mMediaUri;
    public final CharSequence mSubtitle;
    public final CharSequence mTitle;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api21Impl {
        public static MediaDescription build(MediaDescription.Builder builder) {
            return builder.build();
        }

        public static MediaDescription.Builder createBuilder() {
            return new MediaDescription.Builder();
        }

        public static CharSequence getDescription(MediaDescription mediaDescription) {
            return mediaDescription.getDescription();
        }

        public static Bundle getExtras(MediaDescription mediaDescription) {
            return mediaDescription.getExtras();
        }

        public static Bitmap getIconBitmap(MediaDescription mediaDescription) {
            return mediaDescription.getIconBitmap();
        }

        public static Uri getIconUri(MediaDescription mediaDescription) {
            return mediaDescription.getIconUri();
        }

        public static String getMediaId(MediaDescription mediaDescription) {
            return mediaDescription.getMediaId();
        }

        public static CharSequence getSubtitle(MediaDescription mediaDescription) {
            return mediaDescription.getSubtitle();
        }

        public static CharSequence getTitle(MediaDescription mediaDescription) {
            return mediaDescription.getTitle();
        }

        public static void setDescription(MediaDescription.Builder builder, CharSequence charSequence) {
            builder.setDescription(charSequence);
        }

        public static void setExtras(MediaDescription.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }

        public static void setIconBitmap(MediaDescription.Builder builder, Bitmap bitmap) {
            builder.setIconBitmap(bitmap);
        }

        public static void setIconUri(MediaDescription.Builder builder, Uri uri) {
            builder.setIconUri(uri);
        }

        public static void setMediaId(MediaDescription.Builder builder, String str) {
            builder.setMediaId(str);
        }

        public static void setSubtitle(MediaDescription.Builder builder, CharSequence charSequence) {
            builder.setSubtitle(charSequence);
        }

        public static void setTitle(MediaDescription.Builder builder, CharSequence charSequence) {
            builder.setTitle(charSequence);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api23Impl {
        public static Uri getMediaUri(MediaDescription mediaDescription) {
            return mediaDescription.getMediaUri();
        }

        public static void setMediaUri(MediaDescription.Builder builder, Uri uri) {
            builder.setMediaUri(uri);
        }
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.mMediaId = str;
        this.mTitle = charSequence;
        this.mSubtitle = charSequence2;
        this.mDescription = charSequence3;
        this.mIcon = bitmap;
        this.mIconUri = uri;
        this.mExtras = bundle;
        this.mMediaUri = uri2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.mTitle) + ", " + ((Object) this.mSubtitle) + ", " + ((Object) this.mDescription);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        MediaDescription mediaDescriptionBuild = this.mDescriptionFwk;
        if (mediaDescriptionBuild == null) {
            MediaDescription.Builder builderCreateBuilder = Api21Impl.createBuilder();
            Api21Impl.setMediaId(builderCreateBuilder, this.mMediaId);
            Api21Impl.setTitle(builderCreateBuilder, this.mTitle);
            Api21Impl.setSubtitle(builderCreateBuilder, this.mSubtitle);
            Api21Impl.setDescription(builderCreateBuilder, this.mDescription);
            Api21Impl.setIconBitmap(builderCreateBuilder, this.mIcon);
            Api21Impl.setIconUri(builderCreateBuilder, this.mIconUri);
            Api21Impl.setExtras(builderCreateBuilder, this.mExtras);
            Api23Impl.setMediaUri(builderCreateBuilder, this.mMediaUri);
            mediaDescriptionBuild = Api21Impl.build(builderCreateBuilder);
            this.mDescriptionFwk = mediaDescriptionBuild;
        }
        mediaDescriptionBuild.writeToParcel(parcel, i);
    }
}
