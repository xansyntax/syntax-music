package androidx.media3.exoplayer.mediacodec;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil$H265ProfileTierLevel;
import androidx.media3.container.OpusUtil;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.extractor.Ac4Util$SyncFrameInfo;
import androidx.media3.extractor.wav.WavFormat;
import androidx.tracing.TraceApi29Impl;
import coil3.util.FileSystemsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaCodecInfo {
    public final boolean adaptive;
    public final android.media.MediaCodecInfo.CodecCapabilities capabilities;
    public final String codecMimeType;
    public final boolean detachedSurfaceSupported;
    public final boolean hardwareAccelerated;
    public final boolean isVideo;
    public float maxFrameRate;
    public int maxFrameRateHeight;
    public int maxFrameRateWidth;
    public final String mimeType;
    public final String name;
    public final boolean secure;

    public MediaCodecInfo(String str, String str2, String str3, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        str.getClass();
        this.name = str;
        this.mimeType = str2;
        this.codecMimeType = str3;
        this.capabilities = codecCapabilities;
        this.hardwareAccelerated = z;
        this.adaptive = z4;
        this.secure = z5;
        this.detachedSurfaceSupported = z6;
        this.isVideo = MimeTypes.isVideo(str2);
        this.maxFrameRate = -3.4028235E38f;
        this.maxFrameRateWidth = -1;
        this.maxFrameRateHeight = -1;
    }

    public static boolean areSizeAndRateSupported(android.media.MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        Point point = new Point(Util.ceilDivide(i, widthAlignment) * widthAlignment, Util.ceilDivide(i2, heightAlignment) * heightAlignment);
        int i3 = point.x;
        int i4 = point.y;
        if (d == -1.0d || d < 1.0d) {
            return videoCapabilities.isSizeSupported(i3, i4);
        }
        double dFloor = Math.floor(d);
        if (!videoCapabilities.areSizeAndRateSupported(i3, i4, dFloor)) {
            return false;
        }
        Range<Double> achievableFrameRatesFor = videoCapabilities.getAchievableFrameRatesFor(i3, i4);
        return achievableFrameRatesFor == null || dFloor <= ((Double) achievableFrameRatesFor.getUpper()).doubleValue();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0059  */
    public static MediaCodecInfo newInstance(String str, String str2, String str3, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean zIsFeatureSupported = codecCapabilities.isFeatureSupported("adaptive-playback");
        codecCapabilities.isFeatureSupported("tunneled-playback");
        boolean zIsFeatureSupported2 = codecCapabilities.isFeatureSupported("secure-playback");
        if (Build.VERSION.SDK_INT < 35 || !codecCapabilities.isFeatureSupported("detached-surface")) {
            z4 = false;
        } else {
            String str4 = Build.MANUFACTURER;
            if (str4.equals("Xiaomi") || str4.equals("OPPO") || str4.equals("realme") || str4.equals("motorola") || str4.equals("LENOVO")) {
                z4 = false;
            } else {
                z4 = true;
            }
        }
        return new MediaCodecInfo(str, str2, str3, codecCapabilities, z, z2, z3, zIsFeatureSupported, zIsFeatureSupported2, z4);
    }

    public final DecoderReuseEvaluation canReuseCodec(Format format, Format format2) {
        Format format3;
        Format format4;
        int i;
        String str = format.sampleMimeType;
        ColorInfo colorInfo = format.colorInfo;
        String str2 = format2.sampleMimeType;
        ColorInfo colorInfo2 = format2.colorInfo;
        int i2 = !Objects.equals(str, str2) ? 8 : 0;
        if (this.isVideo) {
            if (format.rotationDegrees != format2.rotationDegrees) {
                i2 |= 1024;
            }
            boolean z = (format.width == format2.width && format.height == format2.height) ? false : true;
            if (!this.adaptive && z) {
                i2 |= 512;
            }
            if ((!ColorInfo.isEquivalentToAssumedSdrDefault(colorInfo) || !ColorInfo.isEquivalentToAssumedSdrDefault(colorInfo2)) && !Objects.equals(colorInfo, colorInfo2)) {
                i2 |= 2048;
            }
            if (Build.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(this.name) && !format.initializationDataEquals(format2)) {
                i2 |= 2;
            }
            int i3 = format.decodedWidth;
            if (i3 != -1 && (i = format.decodedHeight) != -1 && i3 == format2.decodedWidth && i == format2.decodedHeight && z) {
                i2 |= 2;
            }
            if (i2 == 0 && Objects.equals(format2.sampleMimeType, "video/dolby-vision")) {
                Pair codecProfileAndLevel = CodecSpecificDataUtil.getCodecProfileAndLevel(format);
                Pair codecProfileAndLevel2 = CodecSpecificDataUtil.getCodecProfileAndLevel(format2);
                if (codecProfileAndLevel == null || codecProfileAndLevel2 == null || !((Integer) codecProfileAndLevel.first).equals(codecProfileAndLevel2.first)) {
                    i2 |= 2;
                }
            }
            if (i2 == 0) {
                return new DecoderReuseEvaluation(this.name, format, format2, format.initializationDataEquals(format2) ? 3 : 2, 0);
            }
            format3 = format;
            format4 = format2;
        } else {
            format3 = format;
            format4 = format2;
            if (format3.channelCount != format4.channelCount) {
                i2 |= 4096;
            }
            if (format3.sampleRate != format4.sampleRate) {
                i2 |= 8192;
            }
            if (format3.pcmEncoding != format4.pcmEncoding) {
                i2 |= 16384;
            }
            String str3 = this.mimeType;
            if (i2 == 0 && (str3.equals("audio/mp4a-latm") || str3.equals("audio/ac4"))) {
                Pair codecProfileAndLevel3 = CodecSpecificDataUtil.getCodecProfileAndLevel(format3);
                Pair codecProfileAndLevel4 = CodecSpecificDataUtil.getCodecProfileAndLevel(format4);
                if (codecProfileAndLevel3 != null && codecProfileAndLevel4 != null) {
                    int iIntValue = ((Integer) codecProfileAndLevel3.first).intValue();
                    int iIntValue2 = ((Integer) codecProfileAndLevel4.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new DecoderReuseEvaluation(this.name, format3, format4, 3, 0);
                    }
                    if (str3.equals("audio/ac4") && codecProfileAndLevel3.equals(codecProfileAndLevel4)) {
                        return new DecoderReuseEvaluation(this.name, format3, format4, 3, 0);
                    }
                }
            }
            if (i2 == 0 && (str3.equals("audio/eac3-joc") || str3.equals("audio/eac3"))) {
                return new DecoderReuseEvaluation(this.name, format3, format4, 3, 0);
            }
            if (!format3.initializationDataEquals(format4)) {
                i2 |= 32;
            }
            if ("audio/opus".equals(str3)) {
                i2 |= 2;
            }
            if (i2 == 0) {
                return new DecoderReuseEvaluation(this.name, format3, format4, 1, 0);
            }
        }
        return new DecoderReuseEvaluation(this.name, format3, format4, 0, i2);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00c2 A[PHI: r2
      0x00c2: PHI (r2v1 android.util.Pair) = (r2v0 android.util.Pair), (r2v0 android.util.Pair), (r2v0 android.util.Pair), (r2v14 android.util.Pair) binds: [B:3:0x000f, B:5:0x0018, B:10:0x002c, B:37:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    public final boolean isCodecProfileAndLevelSupported(Context context, Format format, boolean z) {
        Pair pair;
        String strBuildHevcCodecString;
        Pair codecProfileAndLevel = CodecSpecificDataUtil.getCodecProfileAndLevel(format);
        String str = format.sampleMimeType;
        String str2 = this.codecMimeType;
        if (str != null && str.equals("video/mv-hevc")) {
            String strNormalizeMimeType = MimeTypes.normalizeMimeType(str2);
            if (strNormalizeMimeType.equals("video/mv-hevc")) {
                return true;
            }
            if (strNormalizeMimeType.equals("video/hevc")) {
                HashMap map = MediaCodecUtil.decoderInfosCache;
                List list = format.initializationData;
                int i = 0;
                loop0: while (true) {
                    if (i >= list.size()) {
                        pair = null;
                        strBuildHevcCodecString = null;
                        break;
                    }
                    byte[] bArr = (byte[]) list.get(i);
                    int length = bArr.length;
                    if (length > 3) {
                        boolean[] zArr = new boolean[3];
                        ImmutableList.Builder builder = ImmutableList.builder();
                        int i2 = 0;
                        while (i2 < bArr.length) {
                            int iFindNalUnit = OpusUtil.findNalUnit(bArr, i2, bArr.length, zArr);
                            if (iFindNalUnit != bArr.length) {
                                builder.add((Object) Integer.valueOf(iFindNalUnit));
                            }
                            i2 = iFindNalUnit + 3;
                        }
                        RegularImmutableList regularImmutableListBuild = builder.build();
                        for (int i3 = 0; i3 < regularImmutableListBuild.size; i3++) {
                            if (((Integer) regularImmutableListBuild.get(i3)).intValue() + 3 < length) {
                                WavFormat wavFormat = new WavFormat(bArr, ((Integer) regularImmutableListBuild.get(i3)).intValue() + 3, length);
                                Ac4Util$SyncFrameInfo h265NalHeader = OpusUtil.parseH265NalHeader(wavFormat);
                                if (h265NalHeader.sampleRate == 33 && h265NalHeader.frameSize == 0) {
                                    wavFormat.skipBits(4);
                                    int bits = wavFormat.readBits(3);
                                    wavFormat.skipBit();
                                    pair = null;
                                    NalUnitUtil$H265ProfileTierLevel h265ProfileTierLevel = OpusUtil.parseH265ProfileTierLevel(wavFormat, true, bits, null);
                                    strBuildHevcCodecString = CodecSpecificDataUtil.buildHevcCodecString(h265ProfileTierLevel.generalProfileSpace, h265ProfileTierLevel.generalTierFlag, h265ProfileTierLevel.generalProfileIdc, h265ProfileTierLevel.generalProfileCompatibilityFlags, h265ProfileTierLevel.constraintBytes, h265ProfileTierLevel.generalLevelIdc);
                                    break loop0;
                                }
                            }
                        }
                    }
                    i++;
                }
                if (strBuildHevcCodecString == null) {
                    codecProfileAndLevel = pair;
                } else {
                    String strTrim = strBuildHevcCodecString.trim();
                    String str3 = Util.DEVICE_DEBUG_INFO;
                    codecProfileAndLevel = CodecSpecificDataUtil.getHevcProfileAndLevel(strBuildHevcCodecString, strTrim.split("\\.", -1), format.colorInfo);
                }
            }
        }
        if (codecProfileAndLevel == null) {
            return true;
        }
        int iIntValue = ((Integer) codecProfileAndLevel.first).intValue();
        int iIntValue2 = ((Integer) codecProfileAndLevel.second).intValue();
        boolean zEquals = "video/dolby-vision".equals(str);
        String str4 = this.mimeType;
        if (zEquals) {
            str4.getClass();
            switch (str4) {
                case "video/av01":
                case "video/hevc":
                    iIntValue = 2;
                    break;
                case "video/avc":
                    iIntValue = 8;
                    break;
            }
            iIntValue2 = 0;
        }
        if (!this.isVideo && !str4.equals("audio/ac4") && iIntValue != 42) {
            return true;
        }
        android.media.MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        android.media.MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = codecCapabilities.profileLevels;
        if (codecProfileLevelArr == null) {
            codecProfileLevelArr = new android.media.MediaCodecInfo.CodecProfileLevel[0];
        }
        if (str4.equals("audio/ac4") && codecProfileLevelArr.length == 0) {
            android.media.MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            int i4 = (audioCapabilities != null ? audioCapabilities.getMaxInputChannelCount() : 2) > 18 ? 16 : 8;
            codecProfileLevelArr = context.getPackageManager().hasSystemFeature("android.hardware.type.automotive") ? new android.media.MediaCodecInfo.CodecProfileLevel[]{MediaCodecUtil.createCodecProfileLevel(1026, i4)} : new android.media.MediaCodecInfo.CodecProfileLevel[]{MediaCodecUtil.createCodecProfileLevel(257, i4), MediaCodecUtil.createCodecProfileLevel(513, i4), MediaCodecUtil.createCodecProfileLevel(514, i4), MediaCodecUtil.createCodecProfileLevel(1026, i4), MediaCodecUtil.createCodecProfileLevel(1028, i4)};
        }
        for (android.media.MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
            if (codecProfileLevel.profile == iIntValue && (codecProfileLevel.level >= iIntValue2 || !z)) {
                if (!"video/hevc".equals(str4) || 2 != iIntValue) {
                    return true;
                }
                String str5 = Build.DEVICE;
                if (!"sailfish".equals(str5) && !"marlin".equals(str5)) {
                    return true;
                }
            }
        }
        logNoSupport("codec.profileLevel, " + format.codecs + ", " + str2);
        return false;
    }

    public final boolean isCompressedAudioBitDepthSupported(Format format) {
        return (Objects.equals(format.sampleMimeType, "audio/flac") && format.pcmEncoding == 22 && Build.VERSION.SDK_INT < 34 && this.name.equals("c2.android.flac.decoder")) ? false : true;
    }

    public final boolean isFormatSupported(Context context, Format format) {
        int i;
        int i2;
        String str = format.sampleMimeType;
        String str2 = this.mimeType;
        if ((!str2.equals(str) && !str2.equals(MediaCodecUtil.getAlternativeCodecMimeType(format))) || !isCodecProfileAndLevelSupported(context, format, true) || !isCompressedAudioBitDepthSupported(format)) {
            return false;
        }
        if (this.isVideo) {
            int i3 = format.width;
            if (i3 > 0 && (i2 = format.height) > 0) {
                return isVideoSizeAndRateSupportedV21(format.frameRate, i3, i2);
            }
        } else {
            int i4 = format.sampleRate;
            android.media.MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
            if (i4 != -1) {
                android.media.MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
                if (audioCapabilities == null) {
                    logNoSupport("sampleRate.aCaps");
                    return false;
                }
                if (!audioCapabilities.isSampleRateSupported(i4)) {
                    logNoSupport("sampleRate.support, " + i4);
                    return false;
                }
            }
            int i5 = format.channelCount;
            if (i5 != -1) {
                android.media.MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities.getAudioCapabilities();
                if (audioCapabilities2 == null) {
                    logNoSupport("channelCount.aCaps");
                    return false;
                }
                int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                if (maxInputChannelCount <= 1 && maxInputChannelCount <= 0 && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2)) {
                    if ("audio/ac3".equals(str2)) {
                        i = 6;
                    } else {
                        i = "audio/eac3".equals(str2) ? 16 : 30;
                    }
                    Log.w("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + this.name + ", [" + maxInputChannelCount + " to " + i + "]");
                    maxInputChannelCount = i;
                }
                if (maxInputChannelCount < i5) {
                    logNoSupport("channelCount.support, " + i5);
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean isSeamlessAdaptationSupported(Format format) {
        if (this.isVideo) {
            return this.adaptive;
        }
        Pair codecProfileAndLevel = CodecSpecificDataUtil.getCodecProfileAndLevel(format);
        return codecProfileAndLevel != null && ((Integer) codecProfileAndLevel.first).intValue() == 42;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x004e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0050  */
    public final boolean isVideoSizeAndRateSupportedV21(double d, int i, int i2) {
        String str;
        Boolean bool;
        android.media.MediaCodecInfo.VideoCapabilities videoCapabilities = this.capabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            logNoSupport("sizeAndRate.vCaps");
            return false;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            int iAreResolutionAndFrameRateCovered = (i3 < 29 || ((bool = FileSystemsKt.shouldIgnorePerformancePoints) != null && bool.booleanValue())) ? 0 : TraceApi29Impl.areResolutionAndFrameRateCovered(videoCapabilities, i, i2, d);
            if (iAreResolutionAndFrameRateCovered != 2) {
                if (iAreResolutionAndFrameRateCovered == 1) {
                    StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(i, "sizeAndRate.cover, ", "x", i2, "@");
                    sbM3m.append(d);
                    logNoSupport(sbM3m.toString());
                    return false;
                }
                if (!areSizeAndRateSupported(videoCapabilities, i, i2, d)) {
                    if (i < i2) {
                        str = this.name;
                        if ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str)) {
                            StringBuilder sbM3m2 = IntIntPair$$ExternalSyntheticOutline0.m3m(i, "sizeAndRate.rotated, ", "x", i2, "@");
                            sbM3m2.append(d);
                            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("AssumedSupport [", sbM3m2.toString(), "] [", str, ", ");
                            sbM.append(this.mimeType);
                            sbM.append("] [");
                            sbM.append(Util.DEVICE_DEBUG_INFO);
                            sbM.append("]");
                            Log.d(sbM.toString());
                            return true;
                        }
                        StringBuilder sbM3m3 = IntIntPair$$ExternalSyntheticOutline0.m3m(i, "sizeAndRate.rotated, ", "x", i2, "@");
                        sbM3m3.append(d);
                        StringBuilder sbM2 = IntIntPair$$ExternalSyntheticOutline0.m("AssumedSupport [", sbM3m3.toString(), "] [", str, ", ");
                        sbM2.append(this.mimeType);
                        sbM2.append("] [");
                        sbM2.append(Util.DEVICE_DEBUG_INFO);
                        sbM2.append("]");
                        Log.d(sbM2.toString());
                        return true;
                    }
                    StringBuilder sbM3m4 = IntIntPair$$ExternalSyntheticOutline0.m3m(i, "sizeAndRate.support, ", "x", i2, "@");
                    sbM3m4.append(d);
                    logNoSupport(sbM3m4.toString());
                    return false;
                }
            }
        } else if (!areSizeAndRateSupported(videoCapabilities, i, i2, d)) {
            if (i < i2) {
                str = this.name;
                if (("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) || !"mcv5a".equals(Build.DEVICE)) && areSizeAndRateSupported(videoCapabilities, i2, i, d)) {
                    StringBuilder sbM3m5 = IntIntPair$$ExternalSyntheticOutline0.m3m(i, "sizeAndRate.rotated, ", "x", i2, "@");
                    sbM3m5.append(d);
                    StringBuilder sbM3 = IntIntPair$$ExternalSyntheticOutline0.m("AssumedSupport [", sbM3m5.toString(), "] [", str, ", ");
                    sbM3.append(this.mimeType);
                    sbM3.append("] [");
                    sbM3.append(Util.DEVICE_DEBUG_INFO);
                    sbM3.append("]");
                    Log.d(sbM3.toString());
                    return true;
                }
            }
            StringBuilder sbM3m6 = IntIntPair$$ExternalSyntheticOutline0.m3m(i, "sizeAndRate.support, ", "x", i2, "@");
            sbM3m6.append(d);
            logNoSupport(sbM3m6.toString());
            return false;
        }
        return true;
    }

    public final void logNoSupport(String str) {
        StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("NoSupport [", str, "] [");
        sbM4m.append(this.name);
        sbM4m.append(", ");
        sbM4m.append(this.mimeType);
        sbM4m.append("] [");
        sbM4m.append(Util.DEVICE_DEBUG_INFO);
        sbM4m.append("]");
        Log.d(sbM4m.toString());
    }

    public final String toString() {
        return this.name;
    }
}
