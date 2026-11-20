package androidx.media3.extractor.flv;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.OpusUtil;
import androidx.media3.extractor.TrackOutput;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VideoTagPayloadReader extends TagPayloadReader {
    public int frameType;
    public boolean hasOutputFormat;
    public boolean hasOutputKeyframe;
    public final ParsableByteArray nalLength;
    public final ParsableByteArray nalStartCode;
    public int nalUnitLengthFieldLength;

    public VideoTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
        this.nalStartCode = new ParsableByteArray(OpusUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
    }
}
