package androidx.media3.extractor.ogg;

import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.SeekMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface OggSeeker {
    SeekMap createSeekMap();

    long read(ExtractorInput extractorInput);

    void startSeek(long j);
}
