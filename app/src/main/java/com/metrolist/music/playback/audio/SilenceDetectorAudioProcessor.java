package com.metrolist.music.playback.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.BaseAudioProcessor;
import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SilenceDetectorAudioProcessor extends BaseAudioProcessor {
    public int channelCount;
    public volatile long consecutiveSilentFrames;
    public volatile boolean inSilence;
    public volatile boolean instantModeEnabled;
    public boolean notifiedThisSilence;
    public final ImageLoader$Builder$$ExternalSyntheticLambda1 onLongSilence;
    public int sampleRate;

    public SilenceDetectorAudioProcessor(ImageLoader$Builder$$ExternalSyntheticLambda1 imageLoader$Builder$$ExternalSyntheticLambda1) {
        this.onLongSilence = imageLoader$Builder$$ExternalSyntheticLambda1;
    }

    public final void clearSilenceState() {
        this.consecutiveSilentFrames = 0L;
        this.inSilence = false;
        this.notifiedThisSilence = false;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.encoding != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        this.sampleRate = audioFormat.sampleRate;
        this.channelCount = audioFormat.channelCount;
        return audioFormat;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void onFlush(AudioProcessor.StreamMetadata streamMetadata) {
        streamMetadata.getClass();
        clearSilenceState();
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void onReset() {
        this.sampleRate = 0;
        this.channelCount = 0;
        clearSilenceState();
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void queueInput(ByteBuffer byteBuffer) throws Exception {
        if (byteBuffer.hasRemaining()) {
            if (!this.instantModeEnabled || this.sampleRate <= 0 || this.channelCount <= 0) {
                clearSilenceState();
            } else {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                int iRemaining = (byteBuffer.remaining() / 2) / this.channelCount;
                int iPosition = byteBuffer.position();
                for (int i = 0; i < iRemaining; i++) {
                    int i2 = this.channelCount;
                    int iMax = 0;
                    for (int i3 = 0; i3 < i2; i3++) {
                        iMax = Math.max(iMax, Math.abs((int) byteBuffer.getShort((((this.channelCount * i) + i3) * 2) + iPosition)));
                    }
                    if (iMax < 256) {
                        this.consecutiveSilentFrames++;
                        if ((this.consecutiveSilentFrames * 1000000) / ((long) this.sampleRate) >= 2000000) {
                            this.inSilence = true;
                            if (!this.notifiedThisSilence) {
                                this.notifiedThisSilence = true;
                                this.onLongSilence.invoke();
                            }
                        }
                    } else {
                        clearSilenceState();
                    }
                }
            }
            ByteBuffer byteBufferReplaceOutputBuffer = replaceOutputBuffer(byteBuffer.remaining());
            byteBufferReplaceOutputBuffer.put(byteBuffer);
            byteBufferReplaceOutputBuffer.flip();
        }
    }
}
