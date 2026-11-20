package androidx.media3.session;

import androidx.media3.common.Format;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleTranscodingTrackOutput;
import coil3.util.UtilsKt;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionStub$$ExternalSyntheticLambda20 implements ListenerSet.Event, Consumer, MediaControllerImplBase.RemoteSessionTask, MediaSessionStub.ControllerPlayerTask, MediaSessionStub.SessionTask {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda20(int i, long j, Object obj) {
        this.f$0 = obj;
        this.f$1 = i;
        this.f$2 = j;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        SubtitleTranscodingTrackOutput subtitleTranscodingTrackOutput = (SubtitleTranscodingTrackOutput) this.f$0;
        CuesWithTiming cuesWithTiming = (CuesWithTiming) obj;
        subtitleTranscodingTrackOutput.currentFormat.getClass();
        byte[] bArrEncode = CueDecoder.encode(cuesWithTiming.cues, cuesWithTiming.durationUs);
        ParsableByteArray parsableByteArray = subtitleTranscodingTrackOutput.parsableScratch;
        parsableByteArray.reset(bArrEncode, bArrEncode.length);
        subtitleTranscodingTrackOutput.delegate.sampleData(bArrEncode.length, parsableByteArray);
        long j = cuesWithTiming.startTimeUs;
        Format format = subtitleTranscodingTrackOutput.currentFormat;
        long j2 = this.f$2;
        if (j == -9223372036854775807L) {
            UtilsKt.checkState(format.subsampleOffsetUs == Long.MAX_VALUE);
        } else {
            long j3 = format.subsampleOffsetUs;
            j2 = j3 == Long.MAX_VALUE ? j2 + j : j + j3;
        }
        subtitleTranscodingTrackOutput.delegate.sampleMetadata(j2, this.f$1 | 1, bArrEncode.length, 0, null);
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        ((AnalyticsListener) obj).onBandwidthEstimate((AnalyticsListener.EventTime) this.f$0, this.f$1, this.f$2);
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object run(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        List list = (List) this.f$0;
        int i2 = this.f$1;
        return mediaLibrarySessionImpl.onSetMediaItemsOnHandler(mediaSession$ControllerInfo, list, i2 == -1 ? mediaLibrarySessionImpl.playerWrapper.getCurrentMediaItemIndex() : i2, i2 == -1 ? mediaLibrarySessionImpl.playerWrapper.getCurrentPosition() : this.f$2);
    }

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda20(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        this.f$0 = eventTime;
        this.f$1 = i;
        this.f$2 = j;
    }

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda20(SubtitleTranscodingTrackOutput subtitleTranscodingTrackOutput, long j, int i) {
        this.f$0 = subtitleTranscodingTrackOutput;
        this.f$2 = j;
        this.f$1 = i;
    }

    @Override // androidx.media3.session.MediaSessionStub.ControllerPlayerTask
    public void run(PlayerWrapper playerWrapper, MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        MediaSessionStub mediaSessionStub = (MediaSessionStub) this.f$0;
        playerWrapper.seekTo(mediaSessionStub.maybeCorrectMediaItemIndex(mediaSession$ControllerInfo, playerWrapper, this.f$1), this.f$2);
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void run(IMediaSession iMediaSession, int i) {
        MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) this.f$0;
        iMediaSession.seekToWithMediaItemIndex(mediaControllerImplBase.controllerStub, i, this.f$1, this.f$2);
    }
}
