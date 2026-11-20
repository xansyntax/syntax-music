package androidx.media3.exoplayer.source;

import androidx.compose.ui.platform.WeakCache;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    public MediaPeriod.Callback callback;
    public ClippingMediaSource.IllegalClippingException clippingError;
    public long endUs;
    public long lastReportedDiscontinuityUs;
    public final MediaPeriod mediaPeriod;
    public long pendingInitialDiscontinuityPositionUs;
    public ClippingSampleStream[] sampleStreams = new ClippingSampleStream[0];
    public long startUs;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ClippingSampleStream implements SampleStream {
        public final SampleStream childStream;
        public boolean sentEos;

        public ClippingSampleStream(SampleStream sampleStream) {
            this.childStream = sampleStream;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final boolean isReady() {
            return !ClippingMediaPeriod.this.isPendingInitialDiscontinuity() && this.childStream.isReady();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final void maybeThrowError() {
            this.childStream.maybeThrowError();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int readData(WeakCache weakCache, DecoderInputBuffer decoderInputBuffer, int i) {
            ClippingMediaPeriod clippingMediaPeriod = ClippingMediaPeriod.this;
            if (clippingMediaPeriod.isPendingInitialDiscontinuity()) {
                return -3;
            }
            if (this.sentEos) {
                decoderInputBuffer.flags = 4;
                return -4;
            }
            long bufferedPositionUs = clippingMediaPeriod.getBufferedPositionUs();
            int data = this.childStream.readData(weakCache, decoderInputBuffer, i);
            if (clippingMediaPeriod.lastReportedDiscontinuityUs != -9223372036854775807L && data != -3) {
                clippingMediaPeriod.lastReportedDiscontinuityUs = -9223372036854775807L;
            }
            if (data != -5) {
                long j = clippingMediaPeriod.endUs;
                if (j == Long.MIN_VALUE || ((data != -4 || decoderInputBuffer.timeUs < j) && !(data == -3 && bufferedPositionUs == Long.MIN_VALUE && !decoderInputBuffer.waitingForKeys))) {
                    return data;
                }
                decoderInputBuffer.clear();
                decoderInputBuffer.flags = 4;
                this.sentEos = true;
                return -4;
            }
            long j2 = clippingMediaPeriod.startUs;
            long j3 = clippingMediaPeriod.endUs;
            Format format = (Format) weakCache.referenceQueue;
            format.getClass();
            int i2 = format.encoderPadding;
            int i3 = format.encoderDelay;
            if (i3 != 0 || i2 != 0) {
                if (j2 != 0) {
                    i3 = 0;
                }
                if (j3 != Long.MIN_VALUE) {
                    i2 = 0;
                }
                Format.Builder builderBuildUpon = format.buildUpon();
                builderBuildUpon.encoderDelay = i3;
                builderBuildUpon.encoderPadding = i2;
                weakCache.referenceQueue = new Format(builderBuildUpon);
            }
            return -5;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int skipData(long j) {
            if (ClippingMediaPeriod.this.isPendingInitialDiscontinuity()) {
                return -3;
            }
            return this.childStream.skipData(j);
        }
    }

    public ClippingMediaPeriod(MediaPeriod mediaPeriod, boolean z, long j, long j2, int i) {
        this.mediaPeriod = mediaPeriod;
        this.pendingInitialDiscontinuityPositionUs = z ? j : -9223372036854775807L;
        this.lastReportedDiscontinuityUs = -9223372036854775807L;
        this.startUs = j;
        this.endUs = j2;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean continueLoading(LoadingInfo loadingInfo) {
        return this.mediaPeriod.continueLoading(loadingInfo);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void discardBuffer(long j) {
        this.mediaPeriod.discardBuffer(j);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        long j2 = this.startUs;
        if (j == j2) {
            return j2;
        }
        long jConstrainValue = Util.constrainValue(seekParameters.toleranceBeforeUs, 0L, j - j2);
        long j3 = seekParameters.toleranceAfterUs;
        long j4 = this.endUs;
        long jConstrainValue2 = Util.constrainValue(j3, 0L, j4 == Long.MIN_VALUE ? Long.MAX_VALUE : j4 - j);
        if (jConstrainValue != seekParameters.toleranceBeforeUs || jConstrainValue2 != seekParameters.toleranceAfterUs) {
            seekParameters = new SeekParameters(jConstrainValue, jConstrainValue2);
        }
        return this.mediaPeriod.getAdjustedSeekPositionUs(j, seekParameters);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j = this.endUs;
            if (j == Long.MIN_VALUE || bufferedPositionUs < j) {
                return bufferedPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.mediaPeriod.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j = this.endUs;
            if (j == Long.MIN_VALUE || nextLoadPositionUs < j) {
                return nextLoadPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean isLoading() {
        return this.mediaPeriod.isLoading();
    }

    public final boolean isPendingInitialDiscontinuity() {
        return this.pendingInitialDiscontinuityPositionUs != -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void maybeThrowPrepareError() throws ClippingMediaSource.IllegalClippingException {
        ClippingMediaSource.IllegalClippingException illegalClippingException = this.clippingError;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        this.mediaPeriod.maybeThrowPrepareError();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public final void onContinueLoadingRequested(SequenceableLoader sequenceableLoader) {
        MediaPeriod.Callback callback = this.callback;
        callback.getClass();
        callback.onContinueLoadingRequested(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public final void onPrepared(MediaPeriod mediaPeriod) {
        if (this.clippingError != null) {
            return;
        }
        MediaPeriod.Callback callback = this.callback;
        callback.getClass();
        callback.onPrepared(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void prepare(MediaPeriod.Callback callback, long j) {
        this.callback = callback;
        this.mediaPeriod.prepare(this, j);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long readDiscontinuity() {
        if (isPendingInitialDiscontinuity()) {
            long j = this.pendingInitialDiscontinuityPositionUs;
            this.pendingInitialDiscontinuityPositionUs = -9223372036854775807L;
            this.lastReportedDiscontinuityUs = j;
            long discontinuity = readDiscontinuity();
            return discontinuity != -9223372036854775807L ? discontinuity : j;
        }
        long discontinuity2 = this.mediaPeriod.readDiscontinuity();
        if (discontinuity2 != -9223372036854775807L) {
            long j2 = this.startUs;
            long j3 = this.endUs;
            long jMax = Math.max(discontinuity2, j2);
            if (j3 != Long.MIN_VALUE) {
                jMax = Math.min(jMax, j3);
            }
            if (jMax != this.lastReportedDiscontinuityUs) {
                this.lastReportedDiscontinuityUs = jMax;
                return jMax;
            }
        }
        return -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void reevaluateBuffer(long j) {
        this.mediaPeriod.reevaluateBuffer(j);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long seekToUs(long j) {
        this.pendingInitialDiscontinuityPositionUs = -9223372036854775807L;
        for (ClippingSampleStream clippingSampleStream : this.sampleStreams) {
            if (clippingSampleStream != null) {
                clippingSampleStream.sentEos = false;
            }
        }
        long jSeekToUs = this.mediaPeriod.seekToUs(j);
        long j2 = this.startUs;
        long j3 = this.endUs;
        long jMax = Math.max(jSeekToUs, j2);
        return j3 != Long.MIN_VALUE ? Math.min(jMax, j3) : jMax;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long j2;
        this.sampleStreams = new ClippingSampleStream[sampleStreamArr.length];
        SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
        for (int i = 0; i < sampleStreamArr.length; i++) {
            ClippingSampleStream[] clippingSampleStreamArr = this.sampleStreams;
            ClippingSampleStream clippingSampleStream = (ClippingSampleStream) sampleStreamArr[i];
            clippingSampleStreamArr[i] = clippingSampleStream;
            sampleStreamArr2[i] = clippingSampleStream != null ? clippingSampleStream.childStream : null;
        }
        long jSelectTracks = this.mediaPeriod.selectTracks(exoTrackSelectionArr, zArr, sampleStreamArr2, zArr2, j);
        long j3 = this.endUs;
        long jMax = Math.max(jSelectTracks, j);
        if (j3 != Long.MIN_VALUE) {
            jMax = Math.min(jMax, j3);
        }
        if (isPendingInitialDiscontinuity()) {
            if (jSelectTracks >= j) {
                if (jSelectTracks != 0) {
                    int length = exoTrackSelectionArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i2];
                            if (exoTrackSelection != null) {
                                Format selectedFormat = exoTrackSelection.getSelectedFormat();
                                if (!MimeTypes.allSamplesAreSyncSamples(selectedFormat.sampleMimeType, selectedFormat.codecs)) {
                                }
                            }
                            i2++;
                        }
                    }
                }
                j2 = -9223372036854775807L;
            }
            j2 = jMax;
        } else {
            j2 = -9223372036854775807L;
        }
        this.pendingInitialDiscontinuityPositionUs = j2;
        for (int i3 = 0; i3 < sampleStreamArr.length; i3++) {
            SampleStream sampleStream = sampleStreamArr2[i3];
            ClippingSampleStream[] clippingSampleStreamArr2 = this.sampleStreams;
            if (sampleStream == null) {
                clippingSampleStreamArr2[i3] = null;
            } else {
                ClippingSampleStream clippingSampleStream2 = clippingSampleStreamArr2[i3];
                if (clippingSampleStream2 == null || clippingSampleStream2.childStream != sampleStream) {
                    clippingSampleStreamArr2[i3] = new ClippingSampleStream(sampleStream);
                }
            }
            sampleStreamArr[i3] = clippingSampleStreamArr2[i3];
        }
        return jMax;
    }
}
