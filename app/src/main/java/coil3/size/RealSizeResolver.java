package coil3.size;

import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RealSizeResolver implements SizeResolver {
    public final Size size;

    public RealSizeResolver(Size size) {
        this.size = size;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RealSizeResolver) && this.size.equals(((RealSizeResolver) obj).size);
    }

    public final int hashCode() {
        return this.size.hashCode();
    }

    @Override // coil3.size.SizeResolver
    public final Object size(Continuation continuation) {
        return this.size;
    }

    public final String toString() {
        return "RealSizeResolver(size=" + this.size + ")";
    }
}
