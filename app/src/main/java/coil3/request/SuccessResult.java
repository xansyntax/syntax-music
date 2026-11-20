package coil3.request;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import coil3.Image;
import coil3.decode.DataSource;
import coil3.memory.MemoryCache$Key;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SuccessResult implements ImageResult {
    public final DataSource dataSource;
    public final String diskCacheKey;
    public final Image image;
    public final boolean isPlaceholderCached;
    public final boolean isSampled;
    public final MemoryCache$Key memoryCacheKey;
    public final ImageRequest request;

    public SuccessResult(Image image, ImageRequest imageRequest, DataSource dataSource, MemoryCache$Key memoryCache$Key, String str, boolean z, boolean z2) {
        this.image = image;
        this.request = imageRequest;
        this.dataSource = dataSource;
        this.memoryCacheKey = memoryCache$Key;
        this.diskCacheKey = str;
        this.isSampled = z;
        this.isPlaceholderCached = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuccessResult)) {
            return false;
        }
        SuccessResult successResult = (SuccessResult) obj;
        return Intrinsics.areEqual(this.image, successResult.image) && Intrinsics.areEqual(this.request, successResult.request) && this.dataSource == successResult.dataSource && Intrinsics.areEqual(this.memoryCacheKey, successResult.memoryCacheKey) && Intrinsics.areEqual(this.diskCacheKey, successResult.diskCacheKey) && this.isSampled == successResult.isSampled && this.isPlaceholderCached == successResult.isPlaceholderCached;
    }

    @Override // coil3.request.ImageResult
    public final Image getImage() {
        return this.image;
    }

    @Override // coil3.request.ImageResult
    public final ImageRequest getRequest() {
        return this.request;
    }

    public final int hashCode() {
        int iHashCode = (this.dataSource.hashCode() + ((this.request.hashCode() + (this.image.hashCode() * 31)) * 31)) * 31;
        MemoryCache$Key memoryCache$Key = this.memoryCacheKey;
        int iHashCode2 = (iHashCode + (memoryCache$Key == null ? 0 : memoryCache$Key.hashCode())) * 31;
        String str = this.diskCacheKey;
        return Boolean.hashCode(this.isPlaceholderCached) + IntIntPair$$ExternalSyntheticOutline0.m((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31, this.isSampled, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SuccessResult(image=");
        sb.append(this.image);
        sb.append(", request=");
        sb.append(this.request);
        sb.append(", dataSource=");
        sb.append(this.dataSource);
        sb.append(", memoryCacheKey=");
        sb.append(this.memoryCacheKey);
        sb.append(", diskCacheKey=");
        sb.append(this.diskCacheKey);
        sb.append(", isSampled=");
        sb.append(this.isSampled);
        sb.append(", isPlaceholderCached=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.isPlaceholderCached, ")");
    }
}
