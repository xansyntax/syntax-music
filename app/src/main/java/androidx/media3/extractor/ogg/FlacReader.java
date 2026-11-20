package androidx.media3.extractor.ogg;

import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.FlacStreamMetadata;
import coil3.memory.RealStrongMemoryCache$cache$1;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FlacReader extends StreamReader {
    public RealStrongMemoryCache$cache$1 flacOggSeeker;
    public FlacStreamMetadata streamMetadata;

    @Override // androidx.media3.extractor.ogg.StreamReader
    public final boolean readHeaders(ParsableByteArray parsableByteArray, long j, CallbackWrapper callbackWrapper) {
        byte[] bArr = parsableByteArray.data;
        FlacStreamMetadata flacStreamMetadata = this.streamMetadata;
        if (flacStreamMetadata == null) {
            FlacStreamMetadata flacStreamMetadata2 = new FlacStreamMetadata(bArr, 17);
            this.streamMetadata = flacStreamMetadata2;
            Format.Builder builderBuildUpon = flacStreamMetadata2.getFormat(Arrays.copyOfRange(bArr, 9, parsableByteArray.limit), null).buildUpon();
            builderBuildUpon.containerMimeType = MimeTypes.normalizeMimeType("audio/ogg");
            callbackWrapper.mCallback = new Format(builderBuildUpon);
            return true;
        }
        byte b = bArr[0];
        if ((b & 127) != 3) {
            if (b != -1) {
                return true;
            }
            RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = this.flacOggSeeker;
            if (realStrongMemoryCache$cache$1 != null) {
                realStrongMemoryCache$cache$1.maxSize = j;
                callbackWrapper.mExecutor = realStrongMemoryCache$cache$1;
            }
            ((Format) callbackWrapper.mCallback).getClass();
            return false;
        }
        CallbackWrapper seekTableMetadataBlock = AacUtil.readSeekTableMetadataBlock(parsableByteArray);
        FlacStreamMetadata flacStreamMetadata3 = new FlacStreamMetadata(flacStreamMetadata.minBlockSizeSamples, flacStreamMetadata.maxBlockSizeSamples, flacStreamMetadata.minFrameSize, flacStreamMetadata.maxFrameSize, flacStreamMetadata.sampleRate, flacStreamMetadata.channels, flacStreamMetadata.bitsPerSample, flacStreamMetadata.totalSamples, seekTableMetadataBlock, flacStreamMetadata.metadata);
        this.streamMetadata = flacStreamMetadata3;
        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$2 = new RealStrongMemoryCache$cache$1();
        realStrongMemoryCache$cache$2.map = flacStreamMetadata3;
        realStrongMemoryCache$cache$2.this$0 = seekTableMetadataBlock;
        realStrongMemoryCache$cache$2.maxSize = -1L;
        realStrongMemoryCache$cache$2.size = -1L;
        this.flacOggSeeker = realStrongMemoryCache$cache$2;
        return true;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    public final void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.streamMetadata = null;
            this.flacOggSeeker = null;
        }
    }
}
