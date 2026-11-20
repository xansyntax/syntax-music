package okhttp3.internal.http1;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ForwardingSeekMap;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import coil3.util.UtilsKt;
import com.metrolist.music.listentogether.ListenTogetherClient$serverClock$1;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class HeadersReader implements ExtractorInput, ExtractorOutput {
    public long headerLimit;
    public Object source;

    public HeadersReader(ExtractorInput extractorInput, long j) {
        this.source = extractorInput;
        UtilsKt.checkArgument(extractorInput.getPosition() >= j);
        this.headerLimit = j;
    }

    /* JADX INFO: renamed from: getPostSlopOffset-qto3Fdw$default, reason: not valid java name */
    public static long m1911getPostSlopOffsetqto3Fdw$default(HeadersReader headersReader, long j, float f) {
        long jM439plusMKHz9U = Offset.m439plusMKHz9U(headersReader.headerLimit, j);
        headersReader.headerLimit = jM439plusMKHz9U;
        float fM435getDistanceimpl = ((Orientation) headersReader.source) == null ? Offset.m435getDistanceimpl(jM439plusMKHz9U) : Math.abs(headersReader.m1912mainAxisk4lQ0M(jM439plusMKHz9U));
        if (fM435getDistanceimpl <= CropImageView.DEFAULT_ASPECT_RATIO || fM435getDistanceimpl < f) {
            return 9205357640488583168L;
        }
        Orientation orientation = (Orientation) headersReader.source;
        long j2 = headersReader.headerLimit;
        if (orientation == null) {
            float fM435getDistanceimpl2 = Offset.m435getDistanceimpl(j2);
            return Offset.m438minusMKHz9U(headersReader.headerLimit, Offset.m440timestuRUvjQ((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 >> 32)) / fM435getDistanceimpl2)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L)) / fM435getDistanceimpl2)) & 4294967295L), f));
        }
        float fM1912mainAxisk4lQ0M = headersReader.m1912mainAxisk4lQ0M(j2) - (Math.signum(headersReader.m1912mainAxisk4lQ0M(headersReader.headerLimit)) * f);
        long j3 = headersReader.headerLimit;
        Orientation orientation2 = (Orientation) headersReader.source;
        Orientation orientation3 = Orientation.Horizontal;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (orientation2 == orientation3 ? j3 & 4294967295L : j3 >> 32));
        if (((Orientation) headersReader.source) == orientation3) {
            return (((long) Float.floatToRawIntBits(fM1912mainAxisk4lQ0M)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L);
        }
        return (((long) Float.floatToRawIntBits(fM1912mainAxisk4lQ0M)) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public void advancePeekPosition(int i) {
        ((ExtractorInput) this.source).advancePeekPosition(i);
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public void endTracks() {
        ((ExtractorOutput) this.source).endTracks();
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public long getLength() {
        return ((ExtractorInput) this.source).getLength() - this.headerLimit;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public long getPeekPosition() {
        return ((ExtractorInput) this.source).getPeekPosition() - this.headerLimit;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public long getPosition() {
        return ((ExtractorInput) this.source).getPosition() - this.headerLimit;
    }

    /* JADX INFO: renamed from: mainAxis-k-4lQ0M, reason: not valid java name */
    public float m1912mainAxisk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (((Orientation) this.source) == Orientation.Horizontal ? j >> 32 : j & 4294967295L));
    }

    public synchronized Long now() {
        Long lValueOf;
        Double d = (Double) this.source;
        if (d != null) {
            lValueOf = Long.valueOf((long) (((Number) ListenTogetherClient$serverClock$1.INSTANCE.invoke()).doubleValue() + d.doubleValue()));
        } else {
            lValueOf = null;
        }
        return lValueOf;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public int peek(byte[] bArr, int i, int i2) {
        return ((ExtractorInput) this.source).peek(bArr, i, i2);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public boolean peekFully(byte[] bArr, int i, int i2, boolean z) {
        return ((ExtractorInput) this.source).peekFully(bArr, i, i2, z);
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i, int i2) {
        return ((ExtractorInput) this.source).read(bArr, i, i2);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public boolean readFully(byte[] bArr, int i, int i2, boolean z) {
        return ((ExtractorInput) this.source).readFully(bArr, 0, i2, z);
    }

    public synchronized boolean recordPong(long j, long j2, long j3) {
        Double dValueOf;
        try {
            long jLongValue = ((Number) ListenTogetherClient$serverClock$1.INSTANCE.invoke()).longValue();
            if (j > 0 && j <= jLongValue) {
                long j4 = jLongValue - j;
                if (j4 <= 60000) {
                    if (j2 > 0 && j3 >= j2) {
                        long jMax = Math.max(0L, j4 - (j3 - j2));
                        double d = ((jMax / 2.0d) + j3) - jLongValue;
                        Double d2 = (Double) this.source;
                        long j5 = this.headerLimit;
                        if (jMax < j5) {
                            this.headerLimit = jMax;
                            j5 = jMax;
                        }
                        double d3 = jMax <= j5 + 50 ? 0.25d : 0.05d;
                        if (d2 != null) {
                            double dDoubleValue = d2.doubleValue();
                            dValueOf = Double.valueOf(((d - dDoubleValue) * d3) + dDoubleValue);
                        } else {
                            dValueOf = Double.valueOf(d);
                        }
                        this.source = dValueOf;
                        return d2 == null;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void reset() {
        this.source = null;
        this.headerLimit = Long.MAX_VALUE;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public void resetPeekPosition() {
        ((ExtractorInput) this.source).resetPeekPosition();
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public void seekMap(final SeekMap seekMap) {
        ((ExtractorOutput) this.source).seekMap(new ForwardingSeekMap(seekMap) { // from class: androidx.media3.extractor.StartOffsetExtractorOutput$1
            @Override // androidx.media3.extractor.ForwardingSeekMap, androidx.media3.extractor.SeekMap
            public final SeekMap.SeekPoints getSeekPoints(long j) {
                SeekMap.SeekPoints seekPoints = seekMap.getSeekPoints(j);
                SeekPoint seekPoint = seekPoints.first;
                long j2 = seekPoint.timeUs;
                long j3 = seekPoint.position;
                long j4 = this.this$0.headerLimit;
                SeekPoint seekPoint2 = new SeekPoint(j2, j3 + j4);
                SeekPoint seekPoint3 = seekPoints.second;
                return new SeekMap.SeekPoints(seekPoint2, new SeekPoint(seekPoint3.timeUs, seekPoint3.position + j4));
            }
        });
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public int skip(int i) {
        return ((ExtractorInput) this.source).skip(i);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public boolean skipFully(int i, boolean z) {
        return ((ExtractorInput) this.source).skipFully(i, true);
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public TrackOutput track(int i, int i2) {
        return ((ExtractorOutput) this.source).track(i, i2);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public void peekFully(byte[] bArr, int i, int i2) {
        ((ExtractorInput) this.source).peekFully(bArr, i, i2);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public void readFully(byte[] bArr, int i, int i2) {
        ((ExtractorInput) this.source).readFully(bArr, i, i2);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public void skipFully(int i) {
        ((ExtractorInput) this.source).skipFully(i);
    }

    public /* synthetic */ HeadersReader(Orientation orientation) {
        this(0L, orientation);
    }

    public /* synthetic */ HeadersReader(long j, Object obj) {
        this.headerLimit = j;
        this.source = obj;
    }

    public HeadersReader(long j, Orientation orientation) {
        this.source = orientation;
        this.headerLimit = j;
    }
}
