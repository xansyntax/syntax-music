package androidx.media3.decoder;

import androidx.media3.extractor.text.SubtitleInputBuffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface Decoder {
    Object dequeueInputBuffer();

    Object dequeueOutputBuffer();

    void flush();

    void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer);

    void release();

    void setOutputStartTimeUs(long j);
}
