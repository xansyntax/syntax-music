package androidx.media3.extractor.mp3;

import androidx.media3.extractor.SeekMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface Seeker extends SeekMap {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UnseekableSeeker extends SeekMap.Unseekable implements Seeker {
        @Override // androidx.media3.extractor.mp3.Seeker
        public final int getAverageBitrate() {
            return -2147483647;
        }

        @Override // androidx.media3.extractor.mp3.Seeker
        public final long getDataEndPosition() {
            return -1L;
        }

        @Override // androidx.media3.extractor.mp3.Seeker
        public final long getTimeUs(long j) {
            return 0L;
        }
    }

    int getAverageBitrate();

    long getDataEndPosition();

    long getTimeUs(long j);
}
