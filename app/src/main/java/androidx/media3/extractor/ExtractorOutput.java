package androidx.media3.extractor;

import androidx.media3.extractor.text.CueDecoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface ExtractorOutput {
    public static final CueDecoder PLACEHOLDER = new CueDecoder(8);

    void endTracks();

    void seekMap(SeekMap seekMap);

    TrackOutput track(int i, int i2);
}
