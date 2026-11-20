package com.metrolist.music.recognition;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ShazamSignatureGenerator {
    public static final double[] HANNING;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class FrequencyPeak {
        public final int correctedPeakFrequencyBin;
        public final int fftPassNumber;
        public final int peakMagnitude;

        public FrequencyPeak(int i, int i2, int i3) {
            this.fftPassNumber = i;
            this.peakMagnitude = i2;
            this.correctedPeakFrequencyBin = i3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FrequencyPeak)) {
                return false;
            }
            FrequencyPeak frequencyPeak = (FrequencyPeak) obj;
            return this.fftPassNumber == frequencyPeak.fftPassNumber && this.peakMagnitude == frequencyPeak.peakMagnitude && this.correctedPeakFrequencyBin == frequencyPeak.correctedPeakFrequencyBin;
        }

        public final int hashCode() {
            return Integer.hashCode(this.correctedPeakFrequencyBin) + IntIntPair$$ExternalSyntheticOutline0.m(this.peakMagnitude, Integer.hashCode(this.fftPassNumber) * 31, 31);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m3m(this.fftPassNumber, "FrequencyPeak(fftPassNumber=", ", peakMagnitude=", this.peakMagnitude, ", correctedPeakFrequencyBin="), this.correctedPeakFrequencyBin, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SignatureGeneratorState {
        public final List[] bandPeaks;
        public final double[][] fftOutputs;
        public int fftPos;
        public int numSamples;
        public int samplesPos;
        public final int[] samplesRing = new int[2048];
        public final double[][] spreadFfts;
        public int spreadNumWritten;
        public int spreadPos;
        public int totalPeaks;

        public SignatureGeneratorState() {
            double[][] dArr = new double[256][];
            for (int i = 0; i < 256; i++) {
                dArr[i] = new double[1025];
            }
            this.fftOutputs = dArr;
            double[][] dArr2 = new double[256][];
            for (int i2 = 0; i2 < 256; i2++) {
                dArr2[i2] = new double[1025];
            }
            this.spreadFfts = dArr2;
            List[] listArr = new List[4];
            for (int i3 = 0; i3 < 4; i3++) {
                listArr[i3] = new ArrayList();
            }
            this.bandPeaks = listArr;
        }
    }

    static {
        double[] dArr = new double[2048];
        int i = 0;
        while (i < 2048) {
            int i2 = i + 1;
            dArr[i] = (1.0d - Math.cos((((double) i2) * 6.283185307179586d) / 2049.0d)) * 0.5d;
            i = i2;
        }
        HANNING = dArr;
    }

    public static void writeLittleEndian32(ByteArrayOutputStream byteArrayOutputStream, int i) {
        byteArrayOutputStream.write(i & 255);
        byteArrayOutputStream.write((i >>> 8) & 255);
        byteArrayOutputStream.write((i >>> 16) & 255);
        byteArrayOutputStream.write((i >>> 24) & 255);
    }
}
