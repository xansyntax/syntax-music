package coil3.fetch;

import coil3.decode.DataSource;
import coil3.decode.ImageSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SourceFetchResult implements FetchResult {
    public final DataSource dataSource;
    public final String mimeType;
    public final ImageSource source;

    public SourceFetchResult(ImageSource imageSource, String str, DataSource dataSource) {
        this.source = imageSource;
        this.mimeType = str;
        this.dataSource = dataSource;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceFetchResult)) {
            return false;
        }
        SourceFetchResult sourceFetchResult = (SourceFetchResult) obj;
        return Intrinsics.areEqual(this.source, sourceFetchResult.source) && Intrinsics.areEqual(this.mimeType, sourceFetchResult.mimeType) && this.dataSource == sourceFetchResult.dataSource;
    }

    public final int hashCode() {
        int iHashCode = this.source.hashCode() * 31;
        String str = this.mimeType;
        return this.dataSource.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        return "SourceFetchResult(source=" + this.source + ", mimeType=" + this.mimeType + ", dataSource=" + this.dataSource + ")";
    }
}
