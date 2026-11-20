package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.compose.ui.text.input.GapBuffer;
import androidx.datastore.core.AtomicInt;
import androidx.media3.exoplayer.ExoPlayerImplInternal;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AsynchronousMediaCodecCallback extends MediaCodec.Callback {
    public final HandlerThread callbackThread;
    public MediaFormat currentFormat;
    public Handler handler;
    public IllegalStateException internalException;
    public MediaCodec.CryptoException mediaCodecCryptoException;
    public MediaCodec.CodecException mediaCodecException;
    public AtomicInt onBufferAvailableListener;
    public long pendingFlushCount;
    public MediaFormat pendingOutputFormat;
    public boolean shutDown;
    public final Object lock = new Object();
    public final GapBuffer availableInputBuffers = new GapBuffer((byte) 5);
    public final GapBuffer availableOutputBuffers = new GapBuffer((byte) 5);
    public final ArrayDeque bufferInfos = new ArrayDeque();
    public final ArrayDeque formats = new ArrayDeque();

    public AsynchronousMediaCodecCallback(HandlerThread handlerThread) {
        this.callbackThread = handlerThread;
    }

    public final void flushInternal() {
        ArrayDeque arrayDeque = this.formats;
        if (!arrayDeque.isEmpty()) {
            this.pendingOutputFormat = (MediaFormat) arrayDeque.getLast();
        }
        GapBuffer gapBuffer = this.availableInputBuffers;
        gapBuffer.gapStart = gapBuffer.capacity;
        GapBuffer gapBuffer2 = this.availableOutputBuffers;
        gapBuffer2.gapStart = gapBuffer2.capacity;
        this.bufferInfos.clear();
        arrayDeque.clear();
    }

    public final void maybeThrowException() {
        IllegalStateException illegalStateException = this.internalException;
        if (illegalStateException != null) {
            this.internalException = null;
            throw illegalStateException;
        }
        MediaCodec.CodecException codecException = this.mediaCodecException;
        if (codecException != null) {
            this.mediaCodecException = null;
            throw codecException;
        }
        MediaCodec.CryptoException cryptoException = this.mediaCodecCryptoException;
        if (cryptoException == null) {
            return;
        }
        this.mediaCodecCryptoException = null;
        throw cryptoException;
    }

    @Override // android.media.MediaCodec.Callback
    public final void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.lock) {
            this.mediaCodecCryptoException = cryptoException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.lock) {
            this.mediaCodecException = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        ExoPlayerImplInternal.AnonymousClass1 anonymousClass1;
        synchronized (this.lock) {
            this.availableInputBuffers.addLast(i);
            AtomicInt atomicInt = this.onBufferAvailableListener;
            if (atomicInt != null && (anonymousClass1 = ((MediaCodecRenderer) atomicInt.delegate).wakeupListener) != null) {
                anonymousClass1.onWakeup();
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        ExoPlayerImplInternal.AnonymousClass1 anonymousClass1;
        synchronized (this.lock) {
            try {
                MediaFormat mediaFormat = this.pendingOutputFormat;
                if (mediaFormat != null) {
                    this.availableOutputBuffers.addLast(-2);
                    this.formats.add(mediaFormat);
                    this.pendingOutputFormat = null;
                }
                this.availableOutputBuffers.addLast(i);
                this.bufferInfos.add(bufferInfo);
                AtomicInt atomicInt = this.onBufferAvailableListener;
                if (atomicInt != null && (anonymousClass1 = ((MediaCodecRenderer) atomicInt.delegate).wakeupListener) != null) {
                    anonymousClass1.onWakeup();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.lock) {
            this.availableOutputBuffers.addLast(-2);
            this.formats.add(mediaFormat);
            this.pendingOutputFormat = null;
        }
    }
}
