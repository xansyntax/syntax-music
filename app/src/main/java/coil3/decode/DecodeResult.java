package coil3.decode;

import coil3.Image;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DecodeResult {
    public final Image image;
    public final boolean isSampled;

    public DecodeResult(Image image, boolean z) {
        this.image = image;
        this.isSampled = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecodeResult)) {
            return false;
        }
        DecodeResult decodeResult = (DecodeResult) obj;
        return this.image.equals(decodeResult.image) && this.isSampled == decodeResult.isSampled;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.isSampled) + (this.image.hashCode() * 31);
    }

    public final String toString() {
        return "DecodeResult(image=" + this.image + ", isSampled=" + this.isSampled + ")";
    }
}
