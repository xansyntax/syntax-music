package androidx.media3.extractor.mp4;

import androidx.media3.common.Format;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Track {
    public final long durationUs;
    public final long[] editListDurations;
    public final long[] editListMediaTimes;
    public final Format format;
    public final int id;
    public final long mediaDurationUs;
    public final long movieTimescale;
    public final int nalUnitLengthFieldLength;
    public final TrackEncryptionBox[] sampleDescriptionEncryptionBoxes;
    public final boolean sampleTransformation;
    public final long timescale;
    public final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public Track(int i, int i2, long j, long j2, long j3, long j4, Format format, int i3, TrackEncryptionBox[] trackEncryptionBoxArr, int i4, long[] jArr, long[] jArr2) {
        this.id = i;
        this.type = i2;
        this.timescale = j;
        this.movieTimescale = j2;
        this.durationUs = j3;
        this.mediaDurationUs = j4;
        this.format = format;
        this.sampleTransformation = i3;
        this.sampleDescriptionEncryptionBoxes = trackEncryptionBoxArr;
        this.nalUnitLengthFieldLength = i4;
        this.editListDurations = jArr;
        this.editListMediaTimes = jArr2;
    }

    public final Track copyWithFormat(Format format) {
        long[] jArr = this.editListDurations;
        long[] jArr2 = this.editListMediaTimes;
        int i = this.id;
        int i2 = this.type;
        long j = this.timescale;
        long j2 = this.movieTimescale;
        long j3 = this.durationUs;
        long j4 = this.mediaDurationUs;
        boolean z = this.sampleTransformation;
        return new Track(i, i2, j, j2, j3, j4, format, z ? 1 : 0, this.sampleDescriptionEncryptionBoxes, this.nalUnitLengthFieldLength, jArr, jArr2);
    }
}
