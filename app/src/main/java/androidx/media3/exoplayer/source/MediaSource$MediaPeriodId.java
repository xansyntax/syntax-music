package androidx.media3.exoplayer.source;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSource$MediaPeriodId {
    public final int adGroupIndex;
    public final int adIndexInAdGroup;
    public final int nextAdGroupIndex;
    public final Object periodUid;
    public final long windowSequenceNumber;

    public MediaSource$MediaPeriodId(Object obj, int i, int i2, long j, int i3) {
        this.periodUid = obj;
        this.adGroupIndex = i;
        this.adIndexInAdGroup = i2;
        this.windowSequenceNumber = j;
        this.nextAdGroupIndex = i3;
    }

    public final MediaSource$MediaPeriodId copyWithPeriodUid(Object obj) {
        if (this.periodUid.equals(obj)) {
            return this;
        }
        return new MediaSource$MediaPeriodId(obj, this.adGroupIndex, this.adIndexInAdGroup, this.windowSequenceNumber, this.nextAdGroupIndex);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSource$MediaPeriodId)) {
            return false;
        }
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = (MediaSource$MediaPeriodId) obj;
        return this.periodUid.equals(mediaSource$MediaPeriodId.periodUid) && this.adGroupIndex == mediaSource$MediaPeriodId.adGroupIndex && this.adIndexInAdGroup == mediaSource$MediaPeriodId.adIndexInAdGroup && this.windowSequenceNumber == mediaSource$MediaPeriodId.windowSequenceNumber && this.nextAdGroupIndex == mediaSource$MediaPeriodId.nextAdGroupIndex;
    }

    public final int hashCode() {
        return ((((((((this.periodUid.hashCode() + 527) * 31) + this.adGroupIndex) * 31) + this.adIndexInAdGroup) * 31) + ((int) this.windowSequenceNumber)) * 31) + this.nextAdGroupIndex;
    }

    public final boolean isAd() {
        return this.adGroupIndex != -1;
    }

    public MediaSource$MediaPeriodId(long j, Object obj) {
        this(obj, -1, -1, j, -1);
    }

    public MediaSource$MediaPeriodId(int i, long j, Object obj) {
        this(obj, -1, -1, j, i);
    }

    public MediaSource$MediaPeriodId(Object obj) {
        this(-1L, obj);
    }
}
