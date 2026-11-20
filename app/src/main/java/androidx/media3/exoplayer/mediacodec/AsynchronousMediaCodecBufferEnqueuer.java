package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.HandlerThread;
import androidx.appcompat.app.AlertController;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AsynchronousMediaCodecBufferEnqueuer implements MediaCodecBufferEnqueuer {
    public static final ArrayDeque MESSAGE_PARAMS_INSTANCE_POOL = new ArrayDeque();
    public static final Object QUEUE_SECURE_LOCK = new Object();
    public final MediaCodec codec;
    public final ConditionVariable conditionVariable;
    public AlertController.ButtonHandler handler;
    public final HandlerThread handlerThread;
    public final AtomicReference pendingRuntimeException;
    public boolean started;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MessageParams {
        public final MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        public int flags;
        public int index;
        public long presentationTimeUs;
        public int size;
    }

    public AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, HandlerThread handlerThread) {
        ConditionVariable conditionVariable = new ConditionVariable(0);
        this.codec = mediaCodec;
        this.handlerThread = handlerThread;
        this.conditionVariable = conditionVariable;
        this.pendingRuntimeException = new AtomicReference();
    }

    public static MessageParams getMessageParams() {
        ArrayDeque arrayDeque = MESSAGE_PARAMS_INSTANCE_POOL;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new MessageParams();
                }
                return (MessageParams) arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void flush() {
        if (this.started) {
            try {
                AlertController.ButtonHandler buttonHandler = this.handler;
                buttonHandler.getClass();
                buttonHandler.removeCallbacksAndMessages(null);
                ConditionVariable conditionVariable = this.conditionVariable;
                synchronized (conditionVariable) {
                    conditionVariable.isOpen = false;
                }
                AlertController.ButtonHandler buttonHandler2 = this.handler;
                buttonHandler2.getClass();
                buttonHandler2.obtainMessage(3).sendToTarget();
                conditionVariable.block();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void maybeThrowException() {
        RuntimeException runtimeException = (RuntimeException) this.pendingRuntimeException.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void queueInputBuffer(int i, int i2, int i3, long j) {
        maybeThrowException();
        MessageParams messageParams = getMessageParams();
        messageParams.index = i;
        messageParams.size = i2;
        messageParams.presentationTimeUs = j;
        messageParams.flags = i3;
        AlertController.ButtonHandler buttonHandler = this.handler;
        String str = Util.DEVICE_DEBUG_INFO;
        buttonHandler.obtainMessage(1, messageParams).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void queueSecureInputBuffer(int i, CryptoInfo cryptoInfo, long j, int i2) {
        maybeThrowException();
        MessageParams messageParams = getMessageParams();
        messageParams.index = i;
        messageParams.size = 0;
        messageParams.presentationTimeUs = j;
        messageParams.flags = i2;
        MediaCodec.CryptoInfo cryptoInfo2 = messageParams.cryptoInfo;
        cryptoInfo2.numSubSamples = cryptoInfo.numSubSamples;
        int[] iArr = cryptoInfo.numBytesOfClearData;
        int[] iArrCopyOf = cryptoInfo2.numBytesOfClearData;
        if (iArr != null) {
            if (iArrCopyOf == null || iArrCopyOf.length < iArr.length) {
                iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            } else {
                System.arraycopy(iArr, 0, iArrCopyOf, 0, iArr.length);
            }
        }
        cryptoInfo2.numBytesOfClearData = iArrCopyOf;
        int[] iArr2 = cryptoInfo.numBytesOfEncryptedData;
        int[] iArrCopyOf2 = cryptoInfo2.numBytesOfEncryptedData;
        if (iArr2 != null) {
            if (iArrCopyOf2 == null || iArrCopyOf2.length < iArr2.length) {
                iArrCopyOf2 = Arrays.copyOf(iArr2, iArr2.length);
            } else {
                System.arraycopy(iArr2, 0, iArrCopyOf2, 0, iArr2.length);
            }
        }
        cryptoInfo2.numBytesOfEncryptedData = iArrCopyOf2;
        byte[] bArr = cryptoInfo.key;
        byte[] bArrCopyOf = cryptoInfo2.key;
        if (bArr != null) {
            if (bArrCopyOf == null || bArrCopyOf.length < bArr.length) {
                bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            } else {
                System.arraycopy(bArr, 0, bArrCopyOf, 0, bArr.length);
            }
        }
        bArrCopyOf.getClass();
        cryptoInfo2.key = bArrCopyOf;
        byte[] bArr2 = cryptoInfo.iv;
        byte[] bArrCopyOf2 = cryptoInfo2.iv;
        if (bArr2 != null) {
            if (bArrCopyOf2 == null || bArrCopyOf2.length < bArr2.length) {
                bArrCopyOf2 = Arrays.copyOf(bArr2, bArr2.length);
            } else {
                System.arraycopy(bArr2, 0, bArrCopyOf2, 0, bArr2.length);
            }
        }
        bArrCopyOf2.getClass();
        cryptoInfo2.iv = bArrCopyOf2;
        cryptoInfo2.mode = cryptoInfo.mode;
        cryptoInfo2.setPattern(new MediaCodec.CryptoInfo.Pattern(cryptoInfo.encryptedBlocks, cryptoInfo.clearBlocks));
        AlertController.ButtonHandler buttonHandler = this.handler;
        String str = Util.DEVICE_DEBUG_INFO;
        buttonHandler.obtainMessage(2, messageParams).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void setParameters(Bundle bundle) {
        maybeThrowException();
        AlertController.ButtonHandler buttonHandler = this.handler;
        String str = Util.DEVICE_DEBUG_INFO;
        buttonHandler.obtainMessage(4, bundle).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void shutdown() {
        if (this.started) {
            flush();
            this.handlerThread.quit();
        }
        this.started = false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void start() {
        if (this.started) {
            return;
        }
        HandlerThread handlerThread = this.handlerThread;
        handlerThread.start();
        this.handler = new AlertController.ButtonHandler(this, handlerThread.getLooper(), (byte) 3);
        this.started = true;
    }
}
