package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorOutput;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface ElementaryStreamReader {
    void consume(ParsableByteArray parsableByteArray);

    void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator);

    void packetFinished(boolean z);

    void packetStarted(int i, long j);

    void seek();
}
