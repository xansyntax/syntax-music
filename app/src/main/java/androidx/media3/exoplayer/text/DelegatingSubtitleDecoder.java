package androidx.media3.exoplayer.text;

import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.DecoderOutputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import androidx.media3.extractor.text.SimpleSubtitleDecoder$1;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoder;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleParser;
import coil3.util.UtilsKt;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DelegatingSubtitleDecoder extends SimpleDecoder implements SubtitleDecoder {
    public final SubtitleParser subtitleParser;

    public DelegatingSubtitleDecoder(SubtitleParser subtitleParser) {
        super(new SubtitleInputBuffer[2], new SimpleSubtitleDecoder$1[2]);
        int i = this.availableInputBufferCount;
        DecoderInputBuffer[] decoderInputBufferArr = this.availableInputBuffers;
        UtilsKt.checkState(i == decoderInputBufferArr.length);
        for (DecoderInputBuffer decoderInputBuffer : decoderInputBufferArr) {
            decoderInputBuffer.ensureSpaceForWrite(1024);
        }
        this.subtitleParser = subtitleParser;
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    public final DecoderInputBuffer createInputBuffer() {
        return new SubtitleInputBuffer(1);
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    public final DecoderOutputBuffer createOutputBuffer() {
        return new SimpleSubtitleDecoder$1(this);
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    public final DecoderException createUnexpectedDecodeException(Throwable th) {
        return new SubtitleDecoderException("Unexpected decode error", th);
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    public final DecoderException decode(DecoderInputBuffer decoderInputBuffer, DecoderOutputBuffer decoderOutputBuffer, boolean z) {
        SubtitleInputBuffer subtitleInputBuffer = (SubtitleInputBuffer) decoderInputBuffer;
        SimpleSubtitleDecoder$1 simpleSubtitleDecoder$1 = (SimpleSubtitleDecoder$1) decoderOutputBuffer;
        try {
            ByteBuffer byteBuffer = subtitleInputBuffer.data;
            byteBuffer.getClass();
            byte[] bArrArray = byteBuffer.array();
            int iLimit = byteBuffer.limit();
            SubtitleParser subtitleParser = this.subtitleParser;
            if (z) {
                subtitleParser.reset();
            }
            Subtitle toLegacySubtitle = subtitleParser.parseToLegacySubtitle(bArrArray, 0, iLimit);
            long j = subtitleInputBuffer.timeUs;
            long j2 = subtitleInputBuffer.subsampleOffsetUs;
            simpleSubtitleDecoder$1.timeUs = j;
            simpleSubtitleDecoder$1.subtitle = toLegacySubtitle;
            if (j2 != Long.MAX_VALUE) {
                j = j2;
            }
            simpleSubtitleDecoder$1.subsampleOffsetUs = j;
            simpleSubtitleDecoder$1.shouldBeSkipped = false;
            return null;
        } catch (SubtitleDecoderException e) {
            return e;
        }
    }

    @Override // androidx.media3.extractor.text.SubtitleDecoder
    public final void setPositionUs(long j) {
    }
}
