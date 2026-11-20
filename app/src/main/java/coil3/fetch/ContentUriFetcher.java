package coil3.fetch;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import coil3.Uri;
import coil3.UriKt;
import coil3.decode.ContentMetadata;
import coil3.decode.DataSource;
import coil3.decode.SourceImageSource;
import coil3.intercept.EngineInterceptor;
import coil3.request.Options;
import coil3.size.Dimension;
import coil3.size.Size;
import io.ktor.http.ContentType;
import io.ktor.http.LinkHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.FileNotFoundException;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ContentUriFetcher implements Fetcher {
    public final Uri data;
    public final Options options;

    public ContentUriFetcher(Uri uri, Options options) {
        this.data = uri;
        this.options = options;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00a2  */
    @Override // coil3.fetch.Fetcher
    public final Object fetch(EngineInterceptor.C00531 c00531) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        List pathSegments;
        int size;
        Bundle bundle;
        Uri uri = this.data;
        android.net.Uri uri2 = android.net.Uri.parse(uri.data);
        Options options = this.options;
        ContentResolver contentResolver = options.context.getContentResolver();
        String str = uri.authority;
        if (Intrinsics.areEqual(str, "com.android.contacts") && Intrinsics.areEqual(CollectionsKt.lastOrNull(UriKt.getPathSegments(uri)), "display_photo")) {
            assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri2, "r");
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                PathKt$$ExternalSyntheticBUOutline0.m("Unable to find a contact photo associated with '", uri2, "'.");
                return null;
            }
        } else if (Build.VERSION.SDK_INT >= 29 && Intrinsics.areEqual(str, LinkHeader.Parameters.Media) && (size = (pathSegments = UriKt.getPathSegments(uri)).size()) >= 3 && Intrinsics.areEqual(pathSegments.get(size - 3), ContentType.Audio.TYPE) && Intrinsics.areEqual(pathSegments.get(size - 2), "albums")) {
            Size size2 = options.size;
            Dimension dimension = size2.width;
            Dimension.Pixels pixels = dimension instanceof Dimension.Pixels ? (Dimension.Pixels) dimension : null;
            if (pixels != null) {
                int i = pixels.px;
                Dimension dimension2 = size2.height;
                Dimension.Pixels pixels2 = dimension2 instanceof Dimension.Pixels ? (Dimension.Pixels) dimension2 : null;
                if (pixels2 != null) {
                    int i2 = pixels2.px;
                    bundle = new Bundle(1);
                    bundle.putParcelable("android.content.extra.SIZE", new Point(i, i2));
                } else {
                    bundle = null;
                }
            } else {
                bundle = null;
            }
            assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openTypedAssetFile(uri2, "image/*", bundle, null);
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                PathKt$$ExternalSyntheticBUOutline0.m("Unable to find a music thumbnail associated with '", uri2, "'.");
                return null;
            }
        } else {
            assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri2, "r");
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                PathKt$$ExternalSyntheticBUOutline0.m("Unable to open '", uri2, "'.");
                return null;
            }
        }
        return new SourceFetchResult(new SourceImageSource(new RealBufferedSource(StringsKt__IndentKt.source(assetFileDescriptorOpenAssetFileDescriptor.createInputStream())), options.fileSystem, new ContentMetadata(assetFileDescriptorOpenAssetFileDescriptor)), contentResolver.getType(uri2), DataSource.DISK);
    }
}
