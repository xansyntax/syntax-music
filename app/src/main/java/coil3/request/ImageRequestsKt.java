package coil3.request;

import coil3.Extras;
import coil3.size.SizeKt;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ImageRequestsKt {
    public static final Extras.Key transformationsKey = new Extras.Key(EmptyList.INSTANCE);
    public static final Extras.Key maxBitmapSizeKey = new Extras.Key(SizeKt.Size(4096, 4096));
    public static final Extras.Key addLastModifiedToFileCacheKeyKey = new Extras.Key(Boolean.FALSE);
    public static final Extras.Key allowConversionToBitmapKey = new Extras.Key(Boolean.TRUE);
}
