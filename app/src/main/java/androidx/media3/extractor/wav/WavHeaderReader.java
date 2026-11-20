package androidx.media3.extractor.wav;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import kotlin.time.InstantParseResult;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WavHeaderReader {
    public static final byte[] WAVEEXT_SUBFORMAT = {0, 0, 0, 0, 16, 0, -128, 0, 0, -86, 0, 56, -101, 113};
    public static final byte[] AMBISONIC_SUBFORMAT = {0, 0, 33, 7, -45, 17, -122, 68, -56, -63, -54, 0, 0, 0};

    public static boolean checkFileType(ExtractorInput extractorInput) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        int i = InstantParseResult.Success.peek(extractorInput, parsableByteArray).nanosecondsOfSecond;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        extractorInput.peekFully(parsableByteArray.data, 0, 4);
        parsableByteArray.setPosition(0);
        int i2 = parsableByteArray.readInt();
        if (i2 == 1463899717) {
            return true;
        }
        Log.e("WavHeaderReader", "Unsupported form type: " + i2);
        return false;
    }

    public static InstantParseResult.Success skipToChunk(int i, ExtractorInput extractorInput, ParsableByteArray parsableByteArray) {
        InstantParseResult.Success successPeek = InstantParseResult.Success.peek(extractorInput, parsableByteArray);
        while (true) {
            int i2 = successPeek.nanosecondsOfSecond;
            if (i2 == i) {
                return successPeek;
            }
            Format$$ExternalSyntheticOutline0.m(i2, "Ignoring unknown WAV chunk: ", "WavHeaderReader");
            long j = successPeek.epochSeconds;
            long j2 = 8 + j;
            if (j % 2 != 0) {
                j2 = 9 + j;
            }
            if (j2 > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Chunk is too large (~2GB+) to skip; id: " + i2);
            }
            extractorInput.skipFully((int) j2);
            successPeek = InstantParseResult.Success.peek(extractorInput, parsableByteArray);
        }
    }
}
