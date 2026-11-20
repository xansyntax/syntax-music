package androidx.media3.session.legacy;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new FragmentState.AnonymousClass1((byte) 19);
    public byte[] compressedIcon;
    public final CharSequence description;
    public MediaDescription descriptionFwk;
    public final Bundle extras;
    public final Bitmap icon;
    public final Uri iconUri;
    public final String mediaId;
    public final Uri mediaUri;
    public final CharSequence subtitle;
    public final CharSequence title;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.mediaId = str;
        this.title = charSequence;
        this.subtitle = charSequence2;
        this.description = charSequence3;
        this.icon = bitmap;
        this.iconUri = uri;
        this.extras = bundle;
        this.mediaUri = uri2;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0053  */
    public static MediaDescriptionCompat fromMediaDescription(MediaDescription mediaDescription) {
        Uri mediaUri;
        String mediaId = mediaDescription.getMediaId();
        CharSequence title = mediaDescription.getTitle();
        CharSequence subtitle = mediaDescription.getSubtitle();
        CharSequence description = mediaDescription.getDescription();
        Bitmap iconBitmap = mediaDescription.getIconBitmap();
        Uri iconUri = mediaDescription.getIconUri();
        Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(mediaDescription.getExtras());
        if (bundleConvertToNullIfInvalid != null) {
            bundleConvertToNullIfInvalid = new Bundle(bundleConvertToNullIfInvalid);
        }
        Bundle bundle = null;
        if (bundleConvertToNullIfInvalid != null) {
            mediaUri = (Uri) bundleConvertToNullIfInvalid.getParcelable("android.support.v4.media.description.MEDIA_URI");
            if (mediaUri != null) {
                if (!bundleConvertToNullIfInvalid.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") || bundleConvertToNullIfInvalid.size() != 2) {
                    bundleConvertToNullIfInvalid.remove("android.support.v4.media.description.MEDIA_URI");
                    bundleConvertToNullIfInvalid.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                }
            }
            if (mediaUri == null) {
                mediaUri = mediaDescription.getMediaUri();
            }
            MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(mediaId, title, subtitle, description, iconBitmap, iconUri, bundle, mediaUri);
            mediaDescriptionCompat.descriptionFwk = mediaDescription;
            return mediaDescriptionCompat;
        }
        mediaUri = null;
        bundle = bundleConvertToNullIfInvalid;
        if (mediaUri == null) {
            mediaUri = mediaDescription.getMediaUri();
        }
        MediaDescriptionCompat mediaDescriptionCompat2 = new MediaDescriptionCompat(mediaId, title, subtitle, description, iconBitmap, iconUri, bundle, mediaUri);
        mediaDescriptionCompat2.descriptionFwk = mediaDescription;
        return mediaDescriptionCompat2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final MediaDescription getMediaDescription() {
        MediaDescription mediaDescription = this.descriptionFwk;
        if (mediaDescription != null) {
            return mediaDescription;
        }
        MediaDescription.Builder builder = new MediaDescription.Builder();
        builder.setMediaId(this.mediaId);
        builder.setTitle(this.title);
        builder.setSubtitle(this.subtitle);
        builder.setDescription(this.description);
        builder.setIconBitmap(this.icon);
        builder.setIconUri(this.iconUri);
        builder.setExtras(this.extras);
        builder.setMediaUri(this.mediaUri);
        MediaDescription mediaDescriptionBuild = builder.build();
        this.descriptionFwk = mediaDescriptionBuild;
        return mediaDescriptionBuild;
    }

    public final String toString() {
        return ((Object) this.title) + ", " + ((Object) this.subtitle) + ", " + ((Object) this.description);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        getMediaDescription().writeToParcel(parcel, i);
    }
}
