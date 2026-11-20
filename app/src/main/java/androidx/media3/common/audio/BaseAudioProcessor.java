package androidx.media3.common.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseAudioProcessor implements AudioProcessor {
    public ByteBuffer buffer;
    public AudioProcessor.AudioFormat inputAudioFormat;
    public boolean inputEnded;
    public AudioProcessor.AudioFormat outputAudioFormat;
    public ByteBuffer outputBuffer;
    public AudioProcessor.AudioFormat pendingInputAudioFormat;
    public AudioProcessor.AudioFormat pendingOutputAudioFormat;

    public BaseAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.outputBuffer = byteBuffer;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.pendingInputAudioFormat = audioFormat;
        this.pendingOutputAudioFormat = audioFormat;
        this.inputAudioFormat = audioFormat;
        this.outputAudioFormat = audioFormat;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final AudioProcessor.AudioFormat configure(AudioProcessor.AudioFormat audioFormat) {
        this.pendingInputAudioFormat = audioFormat;
        this.pendingOutputAudioFormat = onConfigure(audioFormat);
        return isActive() ? this.pendingOutputAudioFormat : AudioProcessor.AudioFormat.NOT_SET;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void flush(AudioProcessor.StreamMetadata streamMetadata) {
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        this.inputEnded = false;
        this.inputAudioFormat = this.pendingInputAudioFormat;
        this.outputAudioFormat = this.pendingOutputAudioFormat;
        onFlush(streamMetadata);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.outputBuffer;
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean isActive() {
        return this.pendingOutputAudioFormat != AudioProcessor.AudioFormat.NOT_SET;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean isEnded() {
        return this.inputEnded && this.outputBuffer == AudioProcessor.EMPTY_BUFFER;
    }

    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int i = audioFormat.encoding;
        if (i == 3 || i == 2 || i == 268435456 || i == 21 || i == 1342177280 || i == 22 || i == 1610612736 || i == 4 || i == 1879048192) {
            return i != 2 ? new AudioProcessor.AudioFormat(audioFormat.sampleRate, audioFormat.channelCount, 2) : AudioProcessor.AudioFormat.NOT_SET;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void queueEndOfStream() {
        this.inputEnded = true;
        onQueueEndOfStream();
    }

    public final ByteBuffer replaceOutputBuffer(int i) {
        if (this.buffer.capacity() < i) {
            this.buffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        ByteBuffer byteBuffer = this.buffer;
        this.outputBuffer = byteBuffer;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void reset() {
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.outputBuffer = byteBuffer;
        this.inputEnded = false;
        this.buffer = byteBuffer;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.pendingInputAudioFormat = audioFormat;
        this.pendingOutputAudioFormat = audioFormat;
        this.inputAudioFormat = audioFormat;
        this.outputAudioFormat = audioFormat;
        onReset();
    }

    public void onQueueEndOfStream() {
    }

    public void onReset() {
    }

    public void onFlush(AudioProcessor.StreamMetadata streamMetadata) {
    }
}
