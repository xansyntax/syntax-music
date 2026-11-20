package androidx.media3.exoplayer.source;

import android.media.MediaCodec;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.text.input.GapBuffer;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.image.ImageRenderer;
import androidx.media3.exoplayer.upstream.Allocation;
import androidx.media3.extractor.TrackOutput;
import coil3.memory.RealStrongMemoryCache$cache$1;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SampleDataQueue {
    public final int allocationLength;
    public final EmojiProcessor allocator;
    public RealStrongMemoryCache$cache$1 firstAllocationNode;
    public RealStrongMemoryCache$cache$1 readAllocationNode;
    public final ParsableByteArray scratch;
    public long totalBytesWritten;
    public RealStrongMemoryCache$cache$1 writeAllocationNode;

    public SampleDataQueue(EmojiProcessor emojiProcessor) {
        this.allocator = emojiProcessor;
        synchronized (emojiProcessor) {
            GapBuffer gapBuffer = ((DefaultLoadControl) emojiProcessor.mGlyphChecker).allocator;
        }
        this.allocationLength = 65536;
        this.scratch = new ParsableByteArray(32);
        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = new RealStrongMemoryCache$cache$1(0L, 65536);
        this.firstAllocationNode = realStrongMemoryCache$cache$1;
        this.readAllocationNode = realStrongMemoryCache$cache$1;
        this.writeAllocationNode = realStrongMemoryCache$cache$1;
    }

    public static RealStrongMemoryCache$cache$1 readData(RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1, long j, byte[] bArr, int i) {
        while (j >= realStrongMemoryCache$cache$1.size) {
            realStrongMemoryCache$cache$1 = (RealStrongMemoryCache$cache$1) realStrongMemoryCache$cache$1.this$0;
        }
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (realStrongMemoryCache$cache$1.size - j));
            Allocation allocation = (Allocation) realStrongMemoryCache$cache$1.map;
            System.arraycopy(allocation.data, ((int) (j - realStrongMemoryCache$cache$1.maxSize)) + allocation.offset, bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == realStrongMemoryCache$cache$1.size) {
                realStrongMemoryCache$cache$1 = (RealStrongMemoryCache$cache$1) realStrongMemoryCache$cache$1.this$0;
            }
        }
        return realStrongMemoryCache$cache$1;
    }

    public static RealStrongMemoryCache$cache$1 readSampleData(RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1, DecoderInputBuffer decoderInputBuffer, ImageRenderer.TileInfo tileInfo, ParsableByteArray parsableByteArray) {
        if (decoderInputBuffer.getFlag(1073741824)) {
            long j = tileInfo.presentationTimeUs;
            int unsignedShort = 1;
            parsableByteArray.reset(1);
            RealStrongMemoryCache$cache$1 data = readData(realStrongMemoryCache$cache$1, j, parsableByteArray.data, 1);
            long j2 = j + 1;
            byte b = parsableByteArray.data[0];
            boolean z = (b & 128) != 0;
            int i = b & 127;
            CryptoInfo cryptoInfo = decoderInputBuffer.cryptoInfo;
            byte[] bArr = cryptoInfo.iv;
            if (bArr == null) {
                cryptoInfo.iv = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            realStrongMemoryCache$cache$1 = readData(data, j2, cryptoInfo.iv, i);
            long j3 = j2 + ((long) i);
            if (z) {
                parsableByteArray.reset(2);
                realStrongMemoryCache$cache$1 = readData(realStrongMemoryCache$cache$1, j3, parsableByteArray.data, 2);
                j3 += 2;
                unsignedShort = parsableByteArray.readUnsignedShort();
            }
            int[] iArr = cryptoInfo.numBytesOfClearData;
            if (iArr == null || iArr.length < unsignedShort) {
                iArr = new int[unsignedShort];
            }
            int[] iArr2 = cryptoInfo.numBytesOfEncryptedData;
            if (iArr2 == null || iArr2.length < unsignedShort) {
                iArr2 = new int[unsignedShort];
            }
            if (z) {
                int i2 = unsignedShort * 6;
                parsableByteArray.reset(i2);
                realStrongMemoryCache$cache$1 = readData(realStrongMemoryCache$cache$1, j3, parsableByteArray.data, i2);
                j3 += (long) i2;
                parsableByteArray.setPosition(0);
                for (int i3 = 0; i3 < unsignedShort; i3++) {
                    iArr[i3] = parsableByteArray.readUnsignedShort();
                    iArr2[i3] = parsableByteArray.readUnsignedIntToInt();
                }
            } else {
                iArr[0] = 0;
                iArr2[0] = tileInfo.tileIndex - ((int) (j3 - tileInfo.presentationTimeUs));
            }
            TrackOutput.CryptoData cryptoData = (TrackOutput.CryptoData) tileInfo.tileBitmap;
            String str = Util.DEVICE_DEBUG_INFO;
            byte[] bArr2 = cryptoData.encryptionKey;
            byte[] bArr3 = cryptoInfo.iv;
            int i4 = cryptoData.cryptoMode;
            int i5 = cryptoData.encryptedBlocks;
            int i6 = cryptoData.clearBlocks;
            cryptoInfo.numSubSamples = unsignedShort;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr2;
            cryptoInfo.iv = bArr3;
            cryptoInfo.mode = i4;
            cryptoInfo.encryptedBlocks = i5;
            cryptoInfo.clearBlocks = i6;
            MediaCodec.CryptoInfo cryptoInfo2 = cryptoInfo.frameworkCryptoInfo;
            cryptoInfo2.numSubSamples = unsignedShort;
            cryptoInfo2.numBytesOfClearData = iArr;
            cryptoInfo2.numBytesOfEncryptedData = iArr2;
            cryptoInfo2.key = bArr2;
            cryptoInfo2.iv = bArr3;
            cryptoInfo2.mode = i4;
            WeakCache weakCache = cryptoInfo.patternHolder;
            MediaCodec.CryptoInfo.Pattern pattern = (MediaCodec.CryptoInfo.Pattern) weakCache.referenceQueue;
            pattern.set(i5, i6);
            ((MediaCodec.CryptoInfo) weakCache.values).setPattern(pattern);
            long j4 = tileInfo.presentationTimeUs;
            int i7 = (int) (j3 - j4);
            tileInfo.presentationTimeUs = j4 + ((long) i7);
            tileInfo.tileIndex -= i7;
        }
        if (!decoderInputBuffer.getFlag(WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE)) {
            decoderInputBuffer.ensureSpaceForWrite(tileInfo.tileIndex);
            return readData(realStrongMemoryCache$cache$1, tileInfo.presentationTimeUs, decoderInputBuffer.data, tileInfo.tileIndex);
        }
        parsableByteArray.reset(4);
        RealStrongMemoryCache$cache$1 data2 = readData(realStrongMemoryCache$cache$1, tileInfo.presentationTimeUs, parsableByteArray.data, 4);
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        tileInfo.presentationTimeUs += 4;
        tileInfo.tileIndex -= 4;
        decoderInputBuffer.ensureSpaceForWrite(unsignedIntToInt);
        RealStrongMemoryCache$cache$1 data3 = readData(data2, tileInfo.presentationTimeUs, decoderInputBuffer.data, unsignedIntToInt);
        tileInfo.presentationTimeUs += (long) unsignedIntToInt;
        int i8 = tileInfo.tileIndex - unsignedIntToInt;
        tileInfo.tileIndex = i8;
        ByteBuffer byteBuffer = decoderInputBuffer.supplementalData;
        if (byteBuffer == null || byteBuffer.capacity() < i8) {
            decoderInputBuffer.supplementalData = ByteBuffer.allocate(i8);
        } else {
            decoderInputBuffer.supplementalData.clear();
        }
        return readData(data3, tileInfo.presentationTimeUs, decoderInputBuffer.supplementalData, tileInfo.tileIndex);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0042 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void discardDownstreamTo(long j) {
        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1;
        if (j == -1) {
            return;
        }
        while (true) {
            realStrongMemoryCache$cache$1 = this.firstAllocationNode;
            if (j < realStrongMemoryCache$cache$1.size) {
                break;
            }
            EmojiProcessor emojiProcessor = this.allocator;
            Allocation allocation = (Allocation) realStrongMemoryCache$cache$1.map;
            synchronized (emojiProcessor) {
                GapBuffer gapBuffer = ((DefaultLoadControl) emojiProcessor.mGlyphChecker).allocator;
                synchronized (gapBuffer) {
                    try {
                        Allocation[] allocationArr = (Allocation[]) gapBuffer.buffer;
                        int i = gapBuffer.gapEnd;
                        gapBuffer.gapEnd = i + 1;
                        allocationArr[i] = allocation;
                        gapBuffer.gapStart--;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                emojiProcessor.releaseInternal(allocation);
            }
            RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$2 = this.firstAllocationNode;
            realStrongMemoryCache$cache$2.map = null;
            RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$3 = (RealStrongMemoryCache$cache$1) realStrongMemoryCache$cache$2.this$0;
            realStrongMemoryCache$cache$2.this$0 = null;
            this.firstAllocationNode = realStrongMemoryCache$cache$3;
        }
        if (this.readAllocationNode.maxSize < realStrongMemoryCache$cache$1.maxSize) {
            this.readAllocationNode = realStrongMemoryCache$cache$1;
        }
    }

    public final int preAppend(int i) {
        Allocation allocationAllocate;
        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = this.writeAllocationNode;
        if (((Allocation) realStrongMemoryCache$cache$1.map) == null) {
            EmojiProcessor emojiProcessor = this.allocator;
            synchronized (emojiProcessor) {
                allocationAllocate = ((DefaultLoadControl) emojiProcessor.mGlyphChecker).allocator.allocate();
                ((HashMap) emojiProcessor.mSpanFactory).put(allocationAllocate, (PlayerId) emojiProcessor.mMetadataRepo);
                DefaultLoadControl.PlayerLoadingState playerLoadingState = (DefaultLoadControl.PlayerLoadingState) ((DefaultLoadControl) emojiProcessor.mGlyphChecker).loadingStates.get((PlayerId) emojiProcessor.mMetadataRepo);
                if (playerLoadingState != null) {
                    synchronized (playerLoadingState) {
                        playerLoadingState.allocatedCounts++;
                    }
                }
            }
            RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$2 = new RealStrongMemoryCache$cache$1(this.writeAllocationNode.size, this.allocationLength);
            realStrongMemoryCache$cache$1.map = allocationAllocate;
            realStrongMemoryCache$cache$1.this$0 = realStrongMemoryCache$cache$2;
        }
        return Math.min(i, (int) (this.writeAllocationNode.size - this.totalBytesWritten));
    }

    public static RealStrongMemoryCache$cache$1 readData(RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1, long j, ByteBuffer byteBuffer, int i) {
        while (j >= realStrongMemoryCache$cache$1.size) {
            realStrongMemoryCache$cache$1 = (RealStrongMemoryCache$cache$1) realStrongMemoryCache$cache$1.this$0;
        }
        while (i > 0) {
            int iMin = Math.min(i, (int) (realStrongMemoryCache$cache$1.size - j));
            Allocation allocation = (Allocation) realStrongMemoryCache$cache$1.map;
            byteBuffer.put(allocation.data, ((int) (j - realStrongMemoryCache$cache$1.maxSize)) + allocation.offset, iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == realStrongMemoryCache$cache$1.size) {
                realStrongMemoryCache$cache$1 = (RealStrongMemoryCache$cache$1) realStrongMemoryCache$cache$1.this$0;
            }
        }
        return realStrongMemoryCache$cache$1;
    }
}
