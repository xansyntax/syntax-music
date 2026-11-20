package androidx.media3.decoder;

import androidx.media3.exoplayer.image.ImageDecoderException;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import coil3.util.UtilsKt;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SimpleDecoder implements Decoder {
    public int availableInputBufferCount;
    public final DecoderInputBuffer[] availableInputBuffers;
    public int availableOutputBufferCount;
    public final DecoderOutputBuffer[] availableOutputBuffers;
    public final AnonymousClass1 decodeThread;
    public DecoderInputBuffer dequeuedInputBuffer;
    public DecoderException exception;
    public boolean flushed;
    public final Object lock = new Object();
    public long outputStartTimeUs = -9223372036854775807L;
    public final ArrayDeque queuedInputBuffers = new ArrayDeque();
    public final ArrayDeque queuedOutputBuffers = new ArrayDeque();
    public boolean released;

    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.media3.decoder.SimpleDecoder$1, java.lang.Thread] */
    public SimpleDecoder(DecoderInputBuffer[] decoderInputBufferArr, DecoderOutputBuffer[] decoderOutputBufferArr) {
        this.availableInputBuffers = decoderInputBufferArr;
        this.availableInputBufferCount = decoderInputBufferArr.length;
        for (int i = 0; i < this.availableInputBufferCount; i++) {
            this.availableInputBuffers[i] = createInputBuffer();
        }
        this.availableOutputBuffers = decoderOutputBufferArr;
        this.availableOutputBufferCount = decoderOutputBufferArr.length;
        for (int i2 = 0; i2 < this.availableOutputBufferCount; i2++) {
            this.availableOutputBuffers[i2] = createOutputBuffer();
        }
        ?? r4 = new Thread() { // from class: androidx.media3.decoder.SimpleDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                do {
                    try {
                    } catch (InterruptedException e) {
                        throw new IllegalStateException(e);
                    }
                } while (SimpleDecoder.this.decode());
            }
        };
        this.decodeThread = r4;
        r4.start();
    }

    public DecoderInputBuffer createInputBuffer() {
        return new DecoderInputBuffer(1);
    }

    public abstract DecoderOutputBuffer createOutputBuffer();

    public DecoderException createUnexpectedDecodeException(Throwable th) {
        return new ImageDecoderException("Unexpected decode error", th);
    }

    public abstract DecoderException decode(DecoderInputBuffer decoderInputBuffer, DecoderOutputBuffer decoderOutputBuffer, boolean z);

    public final boolean decode() {
        boolean z;
        DecoderException decoderExceptionCreateUnexpectedDecodeException;
        synchronized (this.lock) {
            while (!this.released) {
                try {
                    if (!this.queuedInputBuffers.isEmpty() && this.availableOutputBufferCount > 0) {
                        break;
                    }
                    this.lock.wait();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.released) {
                return false;
            }
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) this.queuedInputBuffers.removeFirst();
            DecoderOutputBuffer[] decoderOutputBufferArr = this.availableOutputBuffers;
            int i = this.availableOutputBufferCount - 1;
            this.availableOutputBufferCount = i;
            DecoderOutputBuffer decoderOutputBuffer = decoderOutputBufferArr[i];
            boolean z2 = this.flushed;
            this.flushed = false;
            if (decoderInputBuffer.getFlag(4)) {
                decoderOutputBuffer.addFlag(4);
            } else {
                decoderOutputBuffer.timeUs = decoderInputBuffer.timeUs;
                if (decoderInputBuffer.getFlag(134217728)) {
                    decoderOutputBuffer.addFlag(134217728);
                }
                long j = decoderInputBuffer.timeUs;
                synchronized (this.lock) {
                    long j2 = this.outputStartTimeUs;
                    z = j2 == -9223372036854775807L || j >= j2;
                }
                if (!z) {
                    decoderOutputBuffer.shouldBeSkipped = true;
                }
                try {
                    decoderExceptionCreateUnexpectedDecodeException = decode(decoderInputBuffer, decoderOutputBuffer, z2);
                } catch (OutOfMemoryError e) {
                    decoderExceptionCreateUnexpectedDecodeException = createUnexpectedDecodeException(e);
                } catch (RuntimeException e2) {
                    decoderExceptionCreateUnexpectedDecodeException = createUnexpectedDecodeException(e2);
                }
                if (decoderExceptionCreateUnexpectedDecodeException != null) {
                    synchronized (this.lock) {
                        this.exception = decoderExceptionCreateUnexpectedDecodeException;
                    }
                    return false;
                }
            }
            synchronized (this.lock) {
                try {
                    if (this.flushed || decoderOutputBuffer.shouldBeSkipped) {
                        decoderOutputBuffer.release();
                    } else {
                        this.queuedOutputBuffers.addLast(decoderOutputBuffer);
                    }
                    decoderInputBuffer.clear();
                    DecoderInputBuffer[] decoderInputBufferArr = this.availableInputBuffers;
                    int i2 = this.availableInputBufferCount;
                    this.availableInputBufferCount = i2 + 1;
                    decoderInputBufferArr[i2] = decoderInputBuffer;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return true;
        }
    }

    @Override // androidx.media3.decoder.Decoder
    public final Object dequeueInputBuffer() {
        DecoderInputBuffer decoderInputBuffer;
        synchronized (this.lock) {
            try {
                DecoderException decoderException = this.exception;
                if (decoderException != null) {
                    throw decoderException;
                }
                UtilsKt.checkState(this.dequeuedInputBuffer == null);
                int i = this.availableInputBufferCount;
                if (i == 0) {
                    decoderInputBuffer = null;
                } else {
                    DecoderInputBuffer[] decoderInputBufferArr = this.availableInputBuffers;
                    int i2 = i - 1;
                    this.availableInputBufferCount = i2;
                    decoderInputBuffer = decoderInputBufferArr[i2];
                }
                this.dequeuedInputBuffer = decoderInputBuffer;
            } catch (Throwable th) {
                throw th;
            }
        }
        return decoderInputBuffer;
    }

    @Override // androidx.media3.decoder.Decoder
    public final DecoderOutputBuffer dequeueOutputBuffer() {
        synchronized (this.lock) {
            try {
                DecoderException decoderException = this.exception;
                if (decoderException != null) {
                    throw decoderException;
                }
                if (this.queuedOutputBuffers.isEmpty()) {
                    return null;
                }
                return (DecoderOutputBuffer) this.queuedOutputBuffers.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.decoder.Decoder
    public final void flush() {
        synchronized (this.lock) {
            try {
                this.flushed = true;
                DecoderInputBuffer decoderInputBuffer = this.dequeuedInputBuffer;
                if (decoderInputBuffer != null) {
                    decoderInputBuffer.clear();
                    DecoderInputBuffer[] decoderInputBufferArr = this.availableInputBuffers;
                    int i = this.availableInputBufferCount;
                    this.availableInputBufferCount = i + 1;
                    decoderInputBufferArr[i] = decoderInputBuffer;
                    this.dequeuedInputBuffer = null;
                }
                while (!this.queuedInputBuffers.isEmpty()) {
                    DecoderInputBuffer decoderInputBuffer2 = (DecoderInputBuffer) this.queuedInputBuffers.removeFirst();
                    decoderInputBuffer2.clear();
                    DecoderInputBuffer[] decoderInputBufferArr2 = this.availableInputBuffers;
                    int i2 = this.availableInputBufferCount;
                    this.availableInputBufferCount = i2 + 1;
                    decoderInputBufferArr2[i2] = decoderInputBuffer2;
                }
                while (!this.queuedOutputBuffers.isEmpty()) {
                    ((DecoderOutputBuffer) this.queuedOutputBuffers.removeFirst()).release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        synchronized (this.lock) {
            try {
                DecoderException decoderException = this.exception;
                if (decoderException != null) {
                    throw decoderException;
                }
                UtilsKt.checkArgument(decoderInputBuffer == this.dequeuedInputBuffer);
                this.queuedInputBuffers.addLast(decoderInputBuffer);
                if (!this.queuedInputBuffers.isEmpty() && this.availableOutputBufferCount > 0) {
                    this.lock.notify();
                }
                this.dequeuedInputBuffer = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.decoder.Decoder
    public final void release() {
        synchronized (this.lock) {
            this.released = true;
            this.lock.notify();
        }
        try {
            join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public final void releaseOutputBuffer(DecoderOutputBuffer decoderOutputBuffer) {
        synchronized (this.lock) {
            decoderOutputBuffer.clear();
            DecoderOutputBuffer[] decoderOutputBufferArr = this.availableOutputBuffers;
            int i = this.availableOutputBufferCount;
            this.availableOutputBufferCount = i + 1;
            decoderOutputBufferArr[i] = decoderOutputBuffer;
            if (!this.queuedInputBuffers.isEmpty() && this.availableOutputBufferCount > 0) {
                this.lock.notify();
            }
        }
    }

    @Override // androidx.media3.decoder.Decoder
    public final void setOutputStartTimeUs(long j) {
        synchronized (this.lock) {
            try {
                UtilsKt.checkState(this.availableInputBufferCount == this.availableInputBuffers.length || this.flushed);
                this.outputStartTimeUs = j;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.decoder.Decoder
    public final /* bridge */ /* synthetic */ void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) {
        queueInputBuffer((DecoderInputBuffer) subtitleInputBuffer);
    }
}
