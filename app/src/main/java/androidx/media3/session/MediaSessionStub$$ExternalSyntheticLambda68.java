package androidx.media3.session;

import android.os.Handler;
import androidx.datastore.core.AtomicInt;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher;
import androidx.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.audio.MediaCodecAudioRenderer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionStub$$ExternalSyntheticLambda68 implements ListenerSet.Event, Consumer {
    public final /* synthetic */ long f$0;

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        ((PlayerWrapper) obj).seekTo(this.f$0);
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        AtomicInt atomicInt;
        DefaultAudioSink.AudioOutputListener audioOutputListener = (DefaultAudioSink.AudioOutputListener) obj;
        DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
        if (audioOutputListener == defaultAudioSink.audioOutputListener && (atomicInt = defaultAudioSink.listener) != null) {
            MediaCodecAudioRenderer mediaCodecAudioRenderer = (MediaCodecAudioRenderer) atomicInt.delegate;
            mediaCodecAudioRenderer.hasReportedAudioPositionAdvancing = true;
            AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = mediaCodecAudioRenderer.eventDispatcher;
            Handler handler = audioRendererEventListener$EventDispatcher.handler;
            if (handler != null) {
                handler.post(new AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(audioRendererEventListener$EventDispatcher, this.f$0));
            }
        }
    }
}
