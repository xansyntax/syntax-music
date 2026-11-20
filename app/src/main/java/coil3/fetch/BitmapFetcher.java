package coil3.fetch;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import coil3.BitmapImage;
import coil3.RealImageLoader;
import coil3.Uri;
import coil3.UriKt;
import coil3.decode.DataSource;
import coil3.intercept.EngineInterceptor;
import coil3.request.Options;
import coil3.util.Utils_androidKt;
import java.nio.ByteBuffer;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapFetcher implements Fetcher {
    public final Bitmap data;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Factory implements Fetcher.Factory {
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ Factory(byte b) {
            this.$r8$classId = b;
        }

        @Override // coil3.fetch.Fetcher.Factory
        public final Fetcher create(Object obj, Options options, RealImageLoader realImageLoader) {
            byte b = 1;
            byte b2 = 0;
            byte b3 = 2;
            switch (this.$r8$classId) {
                case 0:
                    return new BitmapFetcher((Bitmap) obj);
                case 1:
                    Uri uri = (Uri) obj;
                    Bitmap.Config[] configArr = Utils_androidKt.VALID_TRANSFORMATION_CONFIGS;
                    if (Intrinsics.areEqual(uri.scheme, "file") && Intrinsics.areEqual(CollectionsKt.firstOrNull(UriKt.getPathSegments(uri)), "android_asset")) {
                        return new DataUriFetcher(uri, options, b);
                    }
                    return null;
                case 2:
                    return new DrawableFetcher((byte[]) obj, options, b);
                case 3:
                    return new DrawableFetcher((ByteBuffer) obj, options, b3);
                case 4:
                    Uri uri2 = (Uri) obj;
                    if (Intrinsics.areEqual(uri2.scheme, "content")) {
                        return new ContentUriFetcher(uri2, options);
                    }
                    return null;
                case 5:
                    Uri uri3 = (Uri) obj;
                    if (Intrinsics.areEqual(uri3.scheme, "data")) {
                        return new DataUriFetcher(uri3, options, b2);
                    }
                    return null;
                case 6:
                    return new DrawableFetcher((Drawable) obj, options, b2);
                case 7:
                    Uri uri4 = (Uri) obj;
                    String str = uri4.scheme;
                    if ((str != null && !str.equals("file")) || uri4.path == null) {
                        return null;
                    }
                    Bitmap.Config[] configArr2 = Utils_androidKt.VALID_TRANSFORMATION_CONFIGS;
                    if (Intrinsics.areEqual(uri4.scheme, "file") && Intrinsics.areEqual(CollectionsKt.firstOrNull(UriKt.getPathSegments(uri4)), "android_asset")) {
                        return null;
                    }
                    return new DataUriFetcher(uri4, options, b3);
                case 8:
                    Uri uri5 = (Uri) obj;
                    if (Intrinsics.areEqual(uri5.scheme, "jar:file")) {
                        return new DataUriFetcher(uri5, options, (byte) 3);
                    }
                    return null;
                default:
                    Uri uri6 = (Uri) obj;
                    if (Intrinsics.areEqual(uri6.scheme, "android.resource")) {
                        return new DataUriFetcher(uri6, options, (byte) 4);
                    }
                    return null;
            }
        }
    }

    public BitmapFetcher(Bitmap bitmap) {
        this.data = bitmap;
    }

    @Override // coil3.fetch.Fetcher
    public final Object fetch(EngineInterceptor.C00531 c00531) {
        return new ImageFetchResult(new BitmapImage(this.data), false, DataSource.MEMORY);
    }
}
