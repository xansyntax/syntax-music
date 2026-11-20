package androidx.media3.extractor.text.cea;

import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.SimpleSubtitleDecoder$1;
import androidx.media3.extractor.text.SubtitleDecoder;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import coil3.util.UtilsKt;
import java.util.ArrayDeque;
import okhttp3.Dispatcher$promoteAndExecute$Effects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CeaDecoder implements SubtitleDecoder {
    public final ArrayDeque availableInputBuffers = new ArrayDeque();
    public final ArrayDeque availableOutputBuffers;
    public CeaInputBuffer dequeuedInputBuffer;
    public long outputStartTimeUs;
    public long playbackPositionUs;
    public long queuedInputBufferCount;
    public final ArrayDeque queuedInputBuffers;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CeaInputBuffer extends SubtitleInputBuffer implements Comparable {
        public long queuedInputBufferCount;

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) obj;
            if (getFlag(4) != ceaInputBuffer.getFlag(4)) {
                return getFlag(4) ? 1 : -1;
            }
            long j = this.timeUs - ceaInputBuffer.timeUs;
            if (j == 0) {
                j = this.queuedInputBufferCount - ceaInputBuffer.queuedInputBufferCount;
                if (j == 0) {
                    return 0;
                }
            }
            return j > 0 ? 1 : -1;
        }
    }

    public CeaDecoder() {
        for (int i = 0; i < 10; i++) {
            this.availableInputBuffers.add(new CeaInputBuffer(1));
        }
        this.availableOutputBuffers = new ArrayDeque();
        for (int i2 = 0; i2 < 2; i2++) {
            ArrayDeque arrayDeque = this.availableOutputBuffers;
            OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 = new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 24, (Object) this);
            SimpleSubtitleDecoder$1 simpleSubtitleDecoder$1 = new SimpleSubtitleDecoder$1();
            simpleSubtitleDecoder$1.this$0 = onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
            arrayDeque.add(simpleSubtitleDecoder$1);
        }
        this.queuedInputBuffers = new ArrayDeque();
        this.outputStartTimeUs = -9223372036854775807L;
    }

    public abstract Dispatcher$promoteAndExecute$Effects createSubtitle();

    public abstract void decode(CeaInputBuffer ceaInputBuffer);

    @Override // androidx.media3.decoder.Decoder
    public final Object dequeueInputBuffer() {
        UtilsKt.checkState(this.dequeuedInputBuffer == null);
        ArrayDeque arrayDeque = this.availableInputBuffers;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) arrayDeque.pollFirst();
        this.dequeuedInputBuffer = ceaInputBuffer;
        return ceaInputBuffer;
    }

    @Override // androidx.media3.decoder.Decoder
    public SimpleSubtitleDecoder$1 dequeueOutputBuffer() {
        ArrayDeque arrayDeque = this.availableOutputBuffers;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        while (true) {
            ArrayDeque arrayDeque2 = this.queuedInputBuffers;
            if (arrayDeque2.isEmpty()) {
                return null;
            }
            CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) arrayDeque2.peek();
            String str = Util.DEVICE_DEBUG_INFO;
            if (ceaInputBuffer.timeUs > this.playbackPositionUs) {
                return null;
            }
            CeaInputBuffer ceaInputBuffer2 = (CeaInputBuffer) arrayDeque2.poll();
            boolean flag = ceaInputBuffer2.getFlag(4);
            ArrayDeque arrayDeque3 = this.availableInputBuffers;
            if (flag) {
                SimpleSubtitleDecoder$1 simpleSubtitleDecoder$1 = (SimpleSubtitleDecoder$1) arrayDeque.pollFirst();
                simpleSubtitleDecoder$1.addFlag(4);
                ceaInputBuffer2.clear();
                arrayDeque3.add(ceaInputBuffer2);
                return simpleSubtitleDecoder$1;
            }
            decode(ceaInputBuffer2);
            if (isNewSubtitleDataAvailable()) {
                Dispatcher$promoteAndExecute$Effects dispatcher$promoteAndExecute$EffectsCreateSubtitle = createSubtitle();
                SimpleSubtitleDecoder$1 simpleSubtitleDecoder$2 = (SimpleSubtitleDecoder$1) arrayDeque.pollFirst();
                long j = ceaInputBuffer2.timeUs;
                simpleSubtitleDecoder$2.timeUs = j;
                simpleSubtitleDecoder$2.subtitle = dispatcher$promoteAndExecute$EffectsCreateSubtitle;
                simpleSubtitleDecoder$2.subsampleOffsetUs = j;
                ceaInputBuffer2.clear();
                arrayDeque3.add(ceaInputBuffer2);
                return simpleSubtitleDecoder$2;
            }
            ceaInputBuffer2.clear();
            arrayDeque3.add(ceaInputBuffer2);
        }
    }

    @Override // androidx.media3.decoder.Decoder
    public void flush() {
        ArrayDeque arrayDeque;
        this.queuedInputBufferCount = 0L;
        this.playbackPositionUs = 0L;
        while (true) {
            ArrayDeque arrayDeque2 = this.queuedInputBuffers;
            boolean zIsEmpty = arrayDeque2.isEmpty();
            arrayDeque = this.availableInputBuffers;
            if (zIsEmpty) {
                break;
            }
            CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) arrayDeque2.poll();
            String str = Util.DEVICE_DEBUG_INFO;
            ceaInputBuffer.clear();
            arrayDeque.add(ceaInputBuffer);
        }
        CeaInputBuffer ceaInputBuffer2 = this.dequeuedInputBuffer;
        if (ceaInputBuffer2 != null) {
            ceaInputBuffer2.clear();
            arrayDeque.add(ceaInputBuffer2);
            this.dequeuedInputBuffer = null;
        }
    }

    public abstract boolean isNewSubtitleDataAvailable();

    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    @Override // androidx.media3.decoder.Decoder
    public final void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) {
        UtilsKt.checkArgument(subtitleInputBuffer == this.dequeuedInputBuffer);
        CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) subtitleInputBuffer;
        if (ceaInputBuffer.getFlag(4)) {
            long j = this.queuedInputBufferCount;
            this.queuedInputBufferCount = 1 + j;
            ceaInputBuffer.queuedInputBufferCount = j;
            this.queuedInputBuffers.add(ceaInputBuffer);
        } else {
            long j2 = ceaInputBuffer.timeUs;
            if (j2 != Long.MIN_VALUE) {
                long j3 = this.outputStartTimeUs;
                if (j3 == -9223372036854775807L || j2 >= j3) {
                    long j4 = this.queuedInputBufferCount;
                    this.queuedInputBufferCount = 1 + j4;
                    ceaInputBuffer.queuedInputBufferCount = j4;
                    this.queuedInputBuffers.add(ceaInputBuffer);
                } else {
                    ceaInputBuffer.clear();
                    this.availableInputBuffers.add(ceaInputBuffer);
                }
            } else {
                long j5 = this.queuedInputBufferCount;
                this.queuedInputBufferCount = 1 + j5;
                ceaInputBuffer.queuedInputBufferCount = j5;
                this.queuedInputBuffers.add(ceaInputBuffer);
            }
        }
        this.dequeuedInputBuffer = null;
    }

    @Override // androidx.media3.decoder.Decoder
    public final void setOutputStartTimeUs(long j) {
        this.outputStartTimeUs = j;
    }

    @Override // androidx.media3.extractor.text.SubtitleDecoder
    public final void setPositionUs(long j) {
        this.playbackPositionUs = j;
    }

    @Override // androidx.media3.decoder.Decoder
    public void release() {
    }
}
