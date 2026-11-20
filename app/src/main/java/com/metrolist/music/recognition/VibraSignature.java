package com.metrolist.music.recognition;

import android.util.Base64;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.zip.CRC32;
import kotlin.Metadata;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007b\u0002\b\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000Ê\u0001\f\b\f\u0012\b\b\r\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000b"}, d2 = {"Lcom/metrolist/music/recognition/VibraSignature;", "", "<init>", "()V", "REQUIRED_SAMPLE_RATE", "", "fromI16", "", "samples", "", "Lkotlin/jvm/JvmStatic;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class VibraSignature {
    public static final int $stable = 0;
    public static final VibraSignature INSTANCE = new VibraSignature();
    public static final int REQUIRED_SAMPLE_RATE = 16000;

    private VibraSignature() {
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0202  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v42 */
    public static final String fromI16(byte[] samples) throws IOException {
        List[] listArr;
        boolean z;
        int i;
        int[] iArr;
        double[][] dArr;
        int i2;
        double[] dArr2;
        int i3;
        ?? r1;
        samples.getClass();
        double[] dArr3 = ShazamSignatureGenerator.HANNING;
        int i4 = 2;
        if (samples.length < 2 || samples.length % 2 != 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("samples must be a non-empty byte array with even length (16-bit PCM)");
            return null;
        }
        int length = samples.length / 2;
        short[] sArr = new short[length];
        ByteBuffer.wrap(samples).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr);
        String str = "ShazamSigGen";
        Timber.Forest.tag("ShazamSigGen");
        ConnectionPool.d(Integer.valueOf(samples.length));
        ShazamSignatureGenerator.SignatureGeneratorState signatureGeneratorState = new ShazamSignatureGenerator.SignatureGeneratorState();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6 + 128;
            listArr = signatureGeneratorState.bandPeaks;
            if (i7 > length) {
                break;
            }
            int i8 = signatureGeneratorState.numSamples;
            if (((double) i8) / 16000.0d >= 12.0d && signatureGeneratorState.totalPeaks >= 255) {
                break;
            }
            signatureGeneratorState.numSamples = i8 + 128;
            while (true) {
                z = true;
                i = 2048;
                iArr = signatureGeneratorState.samplesRing;
                if (i6 >= i7) {
                    break;
                }
                int i9 = signatureGeneratorState.samplesPos;
                iArr[i9] = sArr[i6];
                signatureGeneratorState.samplesPos = (i9 + 1) % 2048;
                i6++;
            }
            double[] dArr4 = new double[2048];
            for (int i10 = i5; i10 < 2048; i10++) {
                dArr4[i10] = ((double) iArr[(signatureGeneratorState.samplesPos + i10) % 2048]) * ShazamSignatureGenerator.HANNING[i10];
            }
            double[] dArrCopyOf = Arrays.copyOf(dArr4, 2048);
            double[] dArr5 = new double[2048];
            int i11 = i5;
            for (int i12 = 1; i12 < 2048; i12++) {
                int i13 = 1024;
                while ((i11 & i13) != 0) {
                    i11 ^= i13;
                    i13 >>>= 1;
                }
                i11 ^= i13;
                if (i12 < i11) {
                    double d = dArrCopyOf[i12];
                    dArrCopyOf[i12] = dArrCopyOf[i11];
                    dArrCopyOf[i11] = d;
                    double d2 = dArr5[i12];
                    dArr5[i12] = dArr5[i11];
                    dArr5[i11] = d2;
                }
            }
            int i14 = i4;
            while (i14 <= i) {
                boolean z2 = z;
                int i15 = i14 >>> 1;
                double d3 = (-3.141592653589793d) / ((double) i15);
                double dCos = Math.cos(d3);
                double dSin = Math.sin(d3);
                int i16 = i5;
                while (i16 < i) {
                    double d4 = 1.0d;
                    int i17 = i5;
                    double d5 = 0.0d;
                    while (i17 < i15) {
                        int i18 = i16 + i17;
                        int i19 = i18 + i15;
                        double d6 = dArrCopyOf[i18];
                        double d7 = dArr5[i18];
                        double d8 = dArrCopyOf[i19];
                        double d9 = dArr5[i19];
                        double d10 = (d8 * d4) - (d9 * d5);
                        double d11 = (d9 * d4) + (d8 * d5);
                        dArrCopyOf[i18] = d6 + d10;
                        dArr5[i18] = d7 + d11;
                        dArrCopyOf[i19] = d6 - d10;
                        dArr5[i19] = d7 - d11;
                        double d12 = (d4 * dCos) - (d5 * dSin);
                        d5 = (d5 * dCos) + (d4 * dSin);
                        i17++;
                        d4 = d12;
                    }
                    i16 += i14;
                    i = 2048;
                }
                i14 <<= 1;
                z = z2;
                i = 2048;
            }
            boolean z3 = z;
            int i20 = 1025;
            double[] dArr6 = new double[1025];
            for (int i21 = i5; i21 < 1025; i21++) {
                double d13 = dArrCopyOf[i21];
                double d14 = dArr5[i21];
                double d15 = ((d14 * d14) + (d13 * d13)) * 7.62939453125E-6d;
                if (d15 < 1.0E-10d) {
                    d15 = 1.0E-10d;
                }
                dArr6[i21] = d15;
            }
            int i22 = signatureGeneratorState.fftPos;
            double[][] dArr7 = signatureGeneratorState.fftOutputs;
            double[] dArr8 = dArr7[i22];
            dArr8.getClass();
            System.arraycopy(dArr6, i5, dArr8, i5, 1025);
            int i23 = (signatureGeneratorState.fftPos + 1) % 256;
            signatureGeneratorState.fftPos = i23;
            double[] dArr9 = dArr7[(i23 + 255) % 256];
            double[] dArrCopyOf2 = Arrays.copyOf(dArr9, dArr9.length);
            int i24 = i5;
            while (i24 < 1023) {
                int i25 = i24 + 1;
                dArrCopyOf2[i24] = Math.max(dArrCopyOf2[i24], Math.max(dArrCopyOf2[i25], dArrCopyOf2[i24 + 2]));
                i24 = i25;
                listArr = listArr;
                str = str;
            }
            String str2 = str;
            List[] listArr2 = listArr;
            int i26 = 0;
            while (true) {
                dArr = signatureGeneratorState.spreadFfts;
                if (i26 >= i20) {
                    break;
                }
                double d16 = dArrCopyOf2[i26];
                int[] iArr2 = {-1, -3, -6};
                for (int i27 = 0; i27 < 3; i27++) {
                    double[] dArr10 = dArr[(((signatureGeneratorState.spreadPos + iArr2[i27]) % 256) + 256) % 256];
                    double d17 = dArr10[i26];
                    if (d17 > d16) {
                        d16 = d17;
                    }
                    dArr10[i26] = d16;
                }
                i26++;
                i20 = 1025;
            }
            double[] dArr11 = dArr[signatureGeneratorState.spreadPos];
            int length2 = dArrCopyOf2.length;
            dArr11.getClass();
            System.arraycopy(dArrCopyOf2, 0, dArr11, 0, length2);
            int i28 = (signatureGeneratorState.spreadPos + 1) % 256;
            signatureGeneratorState.spreadPos = i28;
            int i29 = signatureGeneratorState.spreadNumWritten + 1;
            signatureGeneratorState.spreadNumWritten = i29;
            if (i29 >= 47) {
                double[] dArr12 = dArr7[(signatureGeneratorState.fftPos + 466) % 256];
                double[] dArr13 = dArr[(i28 + 463) % 256];
                int i30 = 14;
                int[] iArr3 = {-53, -45, 165, 172, 179, 186, 193, 200, 214, 221, 228, 235, 242, 249};
                int i31 = 10;
                while (i31 < 1017) {
                    double d18 = dArr12[i31];
                    if (d18 < 0.015625d || d18 < dArr13[i31]) {
                        i2 = length;
                        dArr2 = dArr13;
                        i3 = i7;
                    } else {
                        int[] iArr4 = {-10, -7, -4, -3, 1, 2, 5, 8};
                        int i32 = 0;
                        double d19 = 0.0d;
                        for (int i33 = 8; i32 < i33; i33 = 8) {
                            double d20 = dArr13[iArr4[i32] + i31];
                            if (d20 > d19) {
                                d19 = d20;
                            }
                            i32++;
                        }
                        if (d18 > d19) {
                            for (int i34 = 0; i34 < i30; i34++) {
                                double d21 = dArr[(((signatureGeneratorState.spreadPos + iArr3[i34]) % 256) + 256) % 256][i31 - 1];
                                if (d21 > d19) {
                                    d19 = d21;
                                }
                            }
                            if (d18 > d19) {
                                int i35 = signatureGeneratorState.spreadNumWritten - 46;
                                double dLog = (Math.log(Math.max(0.015625d, d18)) * 1477.3d) + 6144.0d;
                                i3 = i7;
                                double dLog2 = (Math.log(Math.max(0.015625d, dArr12[i31 - 1])) * 1477.3d) + 6144.0d;
                                i2 = length;
                                dArr2 = dArr13;
                                double dLog3 = (Math.log(Math.max(0.015625d, dArr12[i31 + 1])) * 1477.3d) + 6144.0d;
                                double d22 = (((double) i31) * 64.0d) + (((dLog3 - dLog2) * 32.0d) / (((2.0d * dLog) - dLog2) - dLog3));
                                double d23 = 0.1220703125d * d22;
                                if (d23 >= 250.0d) {
                                    if (d23 < 520.0d) {
                                        r1 = 0;
                                    } else if (d23 < 1450.0d) {
                                        r1 = z3;
                                    } else if (d23 < 3500.0d) {
                                        r1 = 2;
                                    } else if (d23 <= 5500.0d) {
                                        r1 = 3;
                                    }
                                    listArr2[r1].add(new ShazamSignatureGenerator.FrequencyPeak(i35, (int) dLog, (int) d22));
                                    signatureGeneratorState.totalPeaks++;
                                }
                            } else {
                                i2 = length;
                                dArr2 = dArr13;
                                i3 = i7;
                            }
                        } else {
                            i2 = length;
                            dArr2 = dArr13;
                            i3 = i7;
                        }
                    }
                    i31++;
                    i7 = i3;
                    length = i2;
                    dArr13 = dArr2;
                    i30 = 14;
                }
            }
            str = str2;
            i6 = i7;
            length = length;
            i4 = 2;
            i5 = 0;
        }
        Timber.Forest.tag(str);
        ConnectionPool.d(Integer.valueOf(signatureGeneratorState.numSamples), Integer.valueOf(signatureGeneratorState.totalPeaks));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i36 = 0; i36 < 4; i36++) {
            List<ShazamSignatureGenerator.FrequencyPeak> list = listArr[i36];
            if (!list.isEmpty()) {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                int i37 = 0;
                for (ShazamSignatureGenerator.FrequencyPeak frequencyPeak : list) {
                    int i38 = frequencyPeak.fftPassNumber;
                    if (i38 - i37 >= 255) {
                        byteArrayOutputStream2.write(255);
                        ShazamSignatureGenerator.writeLittleEndian32(byteArrayOutputStream2, i38);
                        i37 = i38;
                    }
                    byteArrayOutputStream2.write(i38 - i37);
                    int i39 = frequencyPeak.peakMagnitude;
                    byteArrayOutputStream2.write(i39 & 255);
                    byteArrayOutputStream2.write((i39 >>> 8) & 255);
                    int i40 = frequencyPeak.correctedPeakFrequencyBin;
                    byteArrayOutputStream2.write(i40 & 255);
                    byteArrayOutputStream2.write((i40 >>> 8) & 255);
                    i37 = i38;
                }
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                ShazamSignatureGenerator.writeLittleEndian32(byteArrayOutputStream, 1610809408 + i36);
                ShazamSignatureGenerator.writeLittleEndian32(byteArrayOutputStream, byteArray.length);
                byteArrayOutputStream.write(byteArray);
                int length3 = (4 - (byteArray.length % 4)) % 4;
                for (int i41 = 0; i41 < length3; i41++) {
                    byteArrayOutputStream.write(0);
                }
            }
        }
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        int length4 = byteArray2.length + 8;
        int i42 = (int) (((double) signatureGeneratorState.numSamples) + 3840.0d);
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(48).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putInt(-889313920);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(length4);
        byteBufferOrder.putInt(-1810785280);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(402653184);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(i42);
        byteBufferOrder.putInt(8126464);
        byte[] bArrArray = byteBufferOrder.array();
        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream(byteArray2.length + 56);
        byteArrayOutputStream3.write(bArrArray);
        ShazamSignatureGenerator.writeLittleEndian32(byteArrayOutputStream3, 1073741824);
        ShazamSignatureGenerator.writeLittleEndian32(byteArrayOutputStream3, byteArray2.length + 8);
        byteArrayOutputStream3.write(byteArray2);
        byte[] byteArray3 = byteArrayOutputStream3.toByteArray();
        CRC32 crc32 = new CRC32();
        crc32.update(byteArray3, 8, byteArray3.length - 8);
        int value = (int) crc32.getValue();
        byteArray3[4] = (byte) (value & 255);
        byteArray3[5] = (byte) ((value >> 8) & 255);
        byteArray3[6] = (byte) ((value >> 16) & 255);
        byteArray3[7] = (byte) ((value >> 24) & 255);
        return Fragment$5$$ExternalSyntheticOutline0.m("data:audio/vnd.shazam.sig;base64,", Base64.encodeToString(byteArray3, 2));
    }
}
