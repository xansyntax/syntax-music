package androidx.media3.exoplayer.offline;

import coil3.util.UtilsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Download {
    public final long contentLength;
    public final int failureReason;
    public final DownloadProgress progress;
    public final DownloadRequest request;
    public final long startTimeMs;
    public final int state;
    public final int stopReason;
    public final long updateTimeMs;

    public Download(DownloadRequest downloadRequest, int i, long j, long j2, long j3, int i2, int i3, DownloadProgress downloadProgress) {
        downloadProgress.getClass();
        boolean z = false;
        UtilsKt.checkArgument((i3 == 0) == (i != 4));
        if (i2 != 0) {
            if (i != 2 && i != 0) {
                z = true;
            }
            UtilsKt.checkArgument(z);
        }
        this.request = downloadRequest;
        this.state = i;
        this.startTimeMs = j;
        this.updateTimeMs = j2;
        this.contentLength = j3;
        this.stopReason = i2;
        this.failureReason = i3;
        this.progress = downloadProgress;
    }

    public Download(DownloadRequest downloadRequest, int i, long j, long j2, int i2) {
        this(downloadRequest, i, j, j2, -1L, i2, 0, new DownloadProgress());
    }
}
