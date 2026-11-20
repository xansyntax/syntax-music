package androidx.media3.exoplayer.video;

import android.media.MediaFormat;
import androidx.media3.common.Format;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface VideoFrameMetadataListener {
    void onVideoFrameAboutToBeRendered(long j, long j2, Format format, MediaFormat mediaFormat);
}
