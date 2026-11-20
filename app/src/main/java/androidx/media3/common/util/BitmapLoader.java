package androidx.media3.common.util;

import android.net.Uri;
import androidx.media3.common.MediaMetadata;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface BitmapLoader {
    ListenableFuture decodeBitmap(byte[] bArr);

    ListenableFuture loadBitmap(Uri uri);

    default ListenableFuture loadBitmapFromMetadata(MediaMetadata mediaMetadata) {
        byte[] bArr = mediaMetadata.artworkData;
        if (bArr != null) {
            return decodeBitmap(bArr);
        }
        Uri uri = mediaMetadata.artworkUri;
        if (uri != null) {
            return loadBitmap(uri);
        }
        return null;
    }
}
