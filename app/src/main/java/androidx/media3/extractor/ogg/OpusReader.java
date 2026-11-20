package androidx.media3.extractor.ogg;

import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.OpusUtil;
import androidx.media3.extractor.AacUtil;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OpusReader extends StreamReader {
    public boolean firstCommentHeaderSeen;
    public static final byte[] OPUS_ID_HEADER_SIGNATURE = {79, 112, 117, 115, 72, 101, 97, 100};
    public static final byte[] OPUS_COMMENT_HEADER_SIGNATURE = {79, 112, 117, 115, 84, 97, 103, 115};

    public static boolean peekPacketStartsWith(ParsableByteArray parsableByteArray, byte[] bArr) {
        if (parsableByteArray.bytesLeft() < bArr.length) {
            return false;
        }
        int i = parsableByteArray.position;
        byte[] bArr2 = new byte[bArr.length];
        parsableByteArray.readBytes(bArr2, 0, bArr.length);
        parsableByteArray.setPosition(i);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    public final long preparePayload(ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.data;
        return (((long) this.sampleRate) * OpusUtil.getPacketDurationUs(bArr[0], bArr.length > 1 ? bArr[1] : (byte) 0)) / 1000000;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    public final boolean readHeaders(ParsableByteArray parsableByteArray, long j, CallbackWrapper callbackWrapper) {
        if (peekPacketStartsWith(parsableByteArray, OPUS_ID_HEADER_SIGNATURE)) {
            byte[] bArrCopyOf = Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit);
            int i = bArrCopyOf[9] & 255;
            ArrayList arrayListBuildInitializationData = OpusUtil.buildInitializationData(bArrCopyOf);
            if (((Format) callbackWrapper.mCallback) == null) {
                Format.Builder builder = new Format.Builder();
                builder.containerMimeType = MimeTypes.normalizeMimeType("audio/ogg");
                builder.sampleMimeType = MimeTypes.normalizeMimeType("audio/opus");
                builder.channelCount = i;
                builder.sampleRate = 48000;
                builder.initializationData = arrayListBuildInitializationData;
                callbackWrapper.mCallback = new Format(builder);
                return true;
            }
        } else {
            boolean zPeekPacketStartsWith = peekPacketStartsWith(parsableByteArray, OPUS_COMMENT_HEADER_SIGNATURE);
            Format format = (Format) callbackWrapper.mCallback;
            if (!zPeekPacketStartsWith) {
                format.getClass();
                return false;
            }
            format.getClass();
            if (!this.firstCommentHeaderSeen) {
                this.firstCommentHeaderSeen = true;
                parsableByteArray.skipBytes(8);
                Metadata vorbisComments = AacUtil.parseVorbisComments(ImmutableList.copyOf((String[]) AacUtil.readVorbisCommentHeader(parsableByteArray, false, false).delegate));
                if (vorbisComments != null) {
                    Format.Builder builderBuildUpon = ((Format) callbackWrapper.mCallback).buildUpon();
                    builderBuildUpon.metadata = vorbisComments.copyWithAppendedEntriesFrom(((Format) callbackWrapper.mCallback).metadata);
                    callbackWrapper.mCallback = new Format(builderBuildUpon);
                    return true;
                }
            }
        }
        return true;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    public final void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.firstCommentHeaderSeen = false;
        }
    }
}
