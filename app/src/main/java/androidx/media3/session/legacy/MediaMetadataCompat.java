package androidx.media3.session.legacy;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import androidx.core.provider.CallbackWrapper;
import androidx.fragment.app.FragmentState;
import androidx.media3.common.util.Log;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;
    public static final ArrayMap METADATA_KEYS_TYPE;
    public static final String[] PREFERRED_DESCRIPTION_ORDER;
    public final Bundle bundle;
    public byte[] compressedArtworkData;
    public MediaMetadata metadataFwk;

    static {
        ArrayMap arrayMap = new ArrayMap(0);
        METADATA_KEYS_TYPE = arrayMap;
        arrayMap.put("android.media.metadata.TITLE", 1);
        arrayMap.put("android.media.metadata.ARTIST", 1);
        arrayMap.put("android.media.metadata.DURATION", 0);
        arrayMap.put("android.media.metadata.ALBUM", 1);
        arrayMap.put("android.media.metadata.AUTHOR", 1);
        arrayMap.put("android.media.metadata.WRITER", 1);
        arrayMap.put("android.media.metadata.COMPOSER", 1);
        arrayMap.put("android.media.metadata.COMPILATION", 1);
        arrayMap.put("android.media.metadata.DATE", 1);
        arrayMap.put("android.media.metadata.YEAR", 0);
        arrayMap.put("android.media.metadata.GENRE", 1);
        arrayMap.put("android.media.metadata.TRACK_NUMBER", 0);
        arrayMap.put("android.media.metadata.NUM_TRACKS", 0);
        arrayMap.put("android.media.metadata.DISC_NUMBER", 0);
        arrayMap.put("android.media.metadata.ALBUM_ARTIST", 1);
        arrayMap.put("android.media.metadata.ART", 2);
        arrayMap.put("android.media.metadata.ART_URI", 1);
        arrayMap.put("android.media.metadata.ALBUM_ART", 2);
        arrayMap.put("android.media.metadata.ALBUM_ART_URI", 1);
        arrayMap.put("android.media.metadata.USER_RATING", 3);
        arrayMap.put("android.media.metadata.RATING", 3);
        arrayMap.put("android.media.metadata.DISPLAY_TITLE", 1);
        arrayMap.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        arrayMap.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        arrayMap.put("android.media.metadata.DISPLAY_ICON", 2);
        arrayMap.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        arrayMap.put("android.media.metadata.MEDIA_ID", 1);
        arrayMap.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        arrayMap.put("android.media.metadata.MEDIA_URI", 1);
        arrayMap.put("android.media.metadata.ADVERTISEMENT", 0);
        arrayMap.put("android.media.metadata.DOWNLOAD_STATUS", 0);
        PREFERRED_DESCRIPTION_ORDER = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER", "android.media.metadata.DISPLAY_SUBTITLE", "android.media.metadata.DISPLAY_DESCRIPTION"};
        CREATOR = new FragmentState.AnonymousClass1((byte) 20);
    }

    public MediaMetadataCompat(Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        this.bundle = bundle2;
        ClassLoader classLoader = CallbackWrapper.class.getClassLoader();
        classLoader.getClass();
        bundle2.setClassLoader(classLoader);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final long getLong(String str) {
        return this.bundle.getLong(str, 0L);
    }

    public final Bitmap getMostRelevantArtworkBitmap() {
        String[] strArr = {"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ALBUM_ART", "android.media.metadata.ART"};
        for (int i = 0; i < 3; i++) {
            String str = strArr[i];
            Bundle bundle = this.bundle;
            if (bundle.containsKey(str)) {
                try {
                    return (Bitmap) bundle.getParcelable(str);
                } catch (Exception e) {
                    Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", e);
                    return null;
                }
            }
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.bundle);
    }

    public MediaMetadataCompat(Parcel parcel) {
        Bundle bundle = parcel.readBundle(CallbackWrapper.class.getClassLoader());
        bundle.getClass();
        this.bundle = bundle;
    }
}
