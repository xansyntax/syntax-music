package coil3.request;

import coil3.Image;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ErrorResult implements ImageResult {
    public final Image image;
    public final ImageRequest request;
    public final Throwable throwable;

    public ErrorResult(Image image, ImageRequest imageRequest, Throwable th) {
        this.image = image;
        this.request = imageRequest;
        this.throwable = th;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorResult)) {
            return false;
        }
        ErrorResult errorResult = (ErrorResult) obj;
        return Intrinsics.areEqual(this.image, errorResult.image) && Intrinsics.areEqual(this.request, errorResult.request) && this.throwable.equals(errorResult.throwable);
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
        Image image = this.image;
        int iHashCode = image == null ? 0 : image.hashCode();
        return this.throwable.hashCode() + ((this.request.hashCode() + (iHashCode * 31)) * 31);
    }

    public final String toString() {
        return "ErrorResult(image=" + this.image + ", request=" + this.request + ", throwable=" + this.throwable + ")";
    }
}
