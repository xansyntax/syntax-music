package coil3.fetch;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import coil3.Image;
import coil3.decode.DataSource;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ImageFetchResult implements FetchResult {
    public final DataSource dataSource;
    public final Image image;
    public final boolean isSampled;

    public ImageFetchResult(Image image, boolean z, DataSource dataSource) {
        this.image = image;
        this.isSampled = z;
        this.dataSource = dataSource;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageFetchResult)) {
            return false;
        }
        ImageFetchResult imageFetchResult = (ImageFetchResult) obj;
        return this.image.equals(imageFetchResult.image) && this.isSampled == imageFetchResult.isSampled && this.dataSource == imageFetchResult.dataSource;
    }

    public final int hashCode() {
        return this.dataSource.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.image.hashCode() * 31, this.isSampled, 31);
    }

    public final String toString() {
        return "ImageFetchResult(image=" + this.image + ", isSampled=" + this.isSampled + ", dataSource=" + this.dataSource + ")";
    }
}
