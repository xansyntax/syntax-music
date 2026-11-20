package androidx.media3.extractor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BinarySearchSeeker$TimestampSearchResult {
    public static final BinarySearchSeeker$TimestampSearchResult NO_TIMESTAMP_IN_RANGE_RESULT = new BinarySearchSeeker$TimestampSearchResult(-3, -9223372036854775807L, -1);
    public final long bytePositionToUpdate;
    public final long timestampToUpdate;
    public final int type;

    public BinarySearchSeeker$TimestampSearchResult(int i, long j, long j2) {
        this.type = i;
        this.timestampToUpdate = j;
        this.bytePositionToUpdate = j2;
    }
}
