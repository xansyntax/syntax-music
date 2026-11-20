package coil3.decode;

import android.content.res.AssetFileDescriptor;
import com.google.common.math.IntMath;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ContentMetadata extends IntMath {
    public final AssetFileDescriptor assetFileDescriptor;

    public ContentMetadata(AssetFileDescriptor assetFileDescriptor) {
        this.assetFileDescriptor = assetFileDescriptor;
    }
}
