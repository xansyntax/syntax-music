package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticLambda0;
import coil3.util.LifecyclesKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MediaCodecUtil {
    public static final HashMap decoderInfosCache = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CodecKey {
        public final String mimeType;
        public final boolean secure;
        public final boolean tunneling;

        public CodecKey(String str, boolean z, boolean z2) {
            this.mimeType = str;
            this.secure = z;
            this.tunneling = z2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == CodecKey.class) {
                CodecKey codecKey = (CodecKey) obj;
                if (TextUtils.equals(this.mimeType, codecKey.mimeType) && this.secure == codecKey.secure && this.tunneling == codecKey.tunneling) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return ((Fragment$5$$ExternalSyntheticOutline0.m(31, 31, this.mimeType) + (this.secure ? 1231 : 1237)) * 31) + (this.tunneling ? 1231 : 1237);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DecoderQueryException extends Exception {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    /* JADX INFO: loaded from: classes2.dex */
    public interface ScoreProvider {
        int getScore(Object obj);
    }

    public static void applyWorkarounds(String str, ArrayList arrayList) {
        byte b = 1;
        if ("audio/raw".equals(str)) {
            Collections.sort(arrayList, new ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0(b, new FrameworkMediaDrm$$ExternalSyntheticLambda0((byte) 10)));
        }
        if (Build.VERSION.SDK_INT >= 32 || arrayList.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(((MediaCodecInfo) arrayList.get(0)).name)) {
            return;
        }
        arrayList.add((MediaCodecInfo) arrayList.remove(0));
    }

    public static android.media.MediaCodecInfo.CodecProfileLevel createCodecProfileLevel(int i, int i2) {
        android.media.MediaCodecInfo.CodecProfileLevel codecProfileLevel = new android.media.MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = i;
        codecProfileLevel.level = i2;
        return codecProfileLevel;
    }

    public static String getAlternativeCodecMimeType(Format format) {
        Pair codecProfileAndLevel;
        String str = format.sampleMimeType;
        String str2 = format.sampleMimeType;
        if ("audio/eac3-joc".equals(str)) {
            return "audio/eac3";
        }
        if ("video/dolby-vision".equals(str2) && (codecProfileAndLevel = CodecSpecificDataUtil.getCodecProfileAndLevel(format)) != null) {
            int iIntValue = ((Integer) codecProfileAndLevel.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                return "video/hevc";
            }
            if (iIntValue == 512) {
                return "video/avc";
            }
            if (iIntValue == 1024) {
                ColorInfo colorInfo = format.colorInfo;
                if (colorInfo != null && colorInfo.colorTransfer == 6 && colorInfo.colorRange == 1) {
                    return null;
                }
                return "video/av01";
            }
        }
        if ("video/mv-hevc".equals(str2)) {
            return "video/hevc";
        }
        return null;
    }

    public static String getCodecMimeType(android.media.MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals("video/mv-hevc")) {
            if ("c2.qti.mvhevc.decoder".equals(str) || "c2.qti.mvhevc.decoder.secure".equals(str)) {
                return "video/x-mvhevc";
            }
            return null;
        }
        if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals("audio/ac3") && "OMX.lge.ac3.decoder".equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    public static synchronized List getDecoderInfos(String str, boolean z, boolean z2) {
        try {
            CodecKey codecKey = new CodecKey(str, z, z2);
            HashMap map = decoderInfosCache;
            List list = (List) map.get(codecKey);
            if (list != null) {
                return list;
            }
            ArrayList decoderInfosInternal = getDecoderInfosInternal(codecKey, new PriorityQueue(z, z2, str.equals("video/mv-hevc")));
            if (z) {
                decoderInfosInternal.isEmpty();
            }
            applyWorkarounds(str, decoderInfosInternal);
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) decoderInfosInternal);
            map.put(codecKey, immutableListCopyOf);
            return immutableListCopyOf;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0057  */
    public static ArrayList getDecoderInfosInternal(CodecKey codecKey, PriorityQueue priorityQueue) throws DecoderQueryException {
        String codecMimeType;
        String str;
        int i;
        CodecKey codecKey2 = codecKey;
        int i2 = priorityQueue.size;
        try {
            ArrayList arrayList = new ArrayList();
            String str2 = codecKey2.mimeType;
            boolean z = codecKey2.secure;
            android.media.MediaCodecInfo[] codecInfos = (android.media.MediaCodecInfo[]) priorityQueue.array;
            if (codecInfos == null) {
                codecInfos = new MediaCodecList(i2).getCodecInfos();
                priorityQueue.array = codecInfos;
            }
            int length = codecInfos.length;
            int i3 = 0;
            while (i3 < length) {
                android.media.MediaCodecInfo[] codecInfos2 = (android.media.MediaCodecInfo[]) priorityQueue.array;
                if (codecInfos2 == null) {
                    codecInfos2 = new MediaCodecList(i2).getCodecInfos();
                    priorityQueue.array = codecInfos2;
                }
                android.media.MediaCodecInfo mediaCodecInfo = codecInfos2[i3];
                int i4 = Build.VERSION.SDK_INT;
                if (i4 < 29 || !mediaCodecInfo.isAlias()) {
                    int i5 = i3;
                    String name = mediaCodecInfo.getName();
                    if (mediaCodecInfo.isEncoder() || (codecMimeType = getCodecMimeType(mediaCodecInfo, name, str2)) == null) {
                        i = i5;
                    } else {
                        try {
                            android.media.MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(codecMimeType);
                            boolean zIsFeatureSupported = capabilitiesForType.isFeatureSupported("tunneled-playback");
                            boolean zIsFeatureRequired = capabilitiesForType.isFeatureRequired("tunneled-playback");
                            boolean z2 = codecKey2.tunneling;
                            if ((z2 || !zIsFeatureRequired) && (!z2 || zIsFeatureSupported)) {
                                boolean zIsFeatureSupported2 = capabilitiesForType.isFeatureSupported("secure-playback");
                                boolean zIsFeatureRequired2 = capabilitiesForType.isFeatureRequired("secure-playback");
                                if ((z || !zIsFeatureRequired2) && (!z || zIsFeatureSupported2)) {
                                    boolean zIsVendor = true;
                                    boolean zIsHardwareAccelerated = i4 >= 29 ? mediaCodecInfo.isHardwareAccelerated() : !isSoftwareOnly(mediaCodecInfo, str2);
                                    i = i5;
                                    boolean zIsSoftwareOnly = isSoftwareOnly(mediaCodecInfo, str2);
                                    boolean z3 = zIsHardwareAccelerated;
                                    if (i4 >= 29) {
                                        zIsVendor = mediaCodecInfo.isVendor();
                                    } else {
                                        String lowerCase = LifecyclesKt.toLowerCase(mediaCodecInfo.getName());
                                        if (lowerCase.startsWith("omx.google.") || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.")) {
                                            zIsVendor = false;
                                        }
                                    }
                                    if (z != zIsFeatureSupported2) {
                                        continue;
                                    } else {
                                        str = codecMimeType;
                                        try {
                                            arrayList.add(MediaCodecInfo.newInstance(name, str2, str, capabilitiesForType, z3, zIsSoftwareOnly, zIsVendor));
                                        } catch (Exception e) {
                                            e = e;
                                            Log.e("MediaCodecUtil", "Failed to query codec " + name + " (" + str + ")");
                                            throw e;
                                        }
                                    }
                                } else {
                                    i = i5;
                                }
                            } else {
                                i = i5;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str = codecMimeType;
                        }
                    }
                } else {
                    i = i3;
                }
                i3 = i + 1;
                codecKey2 = codecKey;
            }
            return arrayList;
        } catch (Exception e3) {
            throw new DecoderQueryException("Failed to query underlying media codecs", e3);
        }
    }

    public static RegularImmutableList getDecoderInfosSoftMatch(Format format, boolean z, boolean z2) {
        Iterable decoderInfos;
        List decoderInfos2 = getDecoderInfos(format.sampleMimeType, z, z2);
        String alternativeCodecMimeType = getAlternativeCodecMimeType(format);
        if (alternativeCodecMimeType == null) {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            decoderInfos = RegularImmutableList.EMPTY;
        } else {
            decoderInfos = getDecoderInfos(alternativeCodecMimeType, z, z2);
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        builder.addAll(decoderInfos2);
        builder.addAll(decoderInfos);
        return builder.build();
    }

    public static boolean isSoftwareOnly(android.media.MediaCodecInfo mediaCodecInfo, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (MimeTypes.isAudio(str)) {
            return true;
        }
        String lowerCase = LifecyclesKt.toLowerCase(mediaCodecInfo.getName());
        if (lowerCase.startsWith("arc.")) {
            return false;
        }
        if (lowerCase.startsWith("omx.google.") || lowerCase.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((lowerCase.startsWith("omx.sec.") && lowerCase.contains(".sw.")) || lowerCase.equals("omx.qcom.video.decoder.hevcswvdec") || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.")) {
            return true;
        }
        return (lowerCase.startsWith("omx.") || lowerCase.startsWith("c2.")) ? false : true;
    }
}
