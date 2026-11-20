package androidx.media3.common;

import android.text.TextUtils;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import com.google.common.math.DoubleMath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Format {
    public static final String FIELD_ACCESSIBILITY_CHANNEL;
    public static final String FIELD_AUXILIARY_TRACK_TYPE;
    public static final String FIELD_CHANNEL_COUNT;
    public static final String FIELD_COLOR_INFO;
    public static final String FIELD_CONTAINER_MIME_TYPE;
    public static final String FIELD_CRYPTO_TYPE;
    public static final String FIELD_DECODED_HEIGHT;
    public static final String FIELD_DECODED_WIDTH;
    public static final String FIELD_DRM_INIT_DATA;
    public static final String FIELD_ENCODER_DELAY;
    public static final String FIELD_ENCODER_PADDING;
    public static final String FIELD_FRAME_RATE;
    public static final String FIELD_HEIGHT;
    public static final String FIELD_INITIALIZATION_DATA;
    public static final String FIELD_LABELS;
    public static final String FIELD_MAX_INPUT_SIZE;
    public static final String FIELD_MAX_SUB_LAYERS;
    public static final String FIELD_PCM_ENCODING;
    public static final String FIELD_PIXEL_WIDTH_HEIGHT_RATIO;
    public static final String FIELD_PRIMARY_TRACK_GROUP_ID;
    public static final String FIELD_PROJECTION_DATA;
    public static final String FIELD_ROTATION_DEGREES;
    public static final String FIELD_SAMPLE_MIME_TYPE;
    public static final String FIELD_SAMPLE_RATE;
    public static final String FIELD_STEREO_MODE;
    public static final String FIELD_SUBSAMPLE_OFFSET_US;
    public static final String FIELD_TILE_COUNT_HORIZONTAL;
    public static final String FIELD_TILE_COUNT_VERTICAL;
    public static final String FIELD_WIDTH;
    public final int accessibilityChannel;
    public final int auxiliaryTrackType;
    public final int averageBitrate;
    public final int bitrate;
    public final int channelCount;
    public final String codecs;
    public final ColorInfo colorInfo;
    public final String containerMimeType;
    public final int cryptoType;
    public final int cueReplacementBehavior;
    public final int decodedHeight;
    public final int decodedWidth;
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final float frameRate;
    public final boolean hasPrerollSamples;
    public int hashCode;
    public final int height;
    public final String id;
    public final List initializationData;
    public final String label;
    public final ImmutableList labels;
    public final String language;
    public final int maxInputSize;
    public final int maxNumReorderSamples;
    public final int maxSubLayers;
    public final Metadata metadata;
    public final int pcmEncoding;
    public final int peakBitrate;
    public final float pixelWidthHeightRatio;
    public final String primaryTrackGroupId;
    public final byte[] projectionData;
    public final int roleFlags;
    public final int rotationDegrees;
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int tileCountHorizontal;
    public final int tileCountVertical;
    public final int width;
    public static final Format DEFAULT = new Format(new Builder());
    public static final String FIELD_ID = Integer.toString(0, 36);
    public static final String FIELD_LABEL = Integer.toString(1, 36);
    public static final String FIELD_LANGUAGE = Integer.toString(2, 36);
    public static final String FIELD_SELECTION_FLAGS = Integer.toString(3, 36);
    public static final String FIELD_ROLE_FLAGS = Integer.toString(4, 36);
    public static final String FIELD_AVERAGE_BITRATE = Integer.toString(5, 36);
    public static final String FIELD_PEAK_BITRATE = Integer.toString(6, 36);
    public static final String FIELD_CODECS = Integer.toString(7, 36);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder {
        public int accessibilityChannel;
        public int auxiliaryTrackType;
        public int averageBitrate;
        public int channelCount;
        public String codecs;
        public ColorInfo colorInfo;
        public String containerMimeType;
        public int cryptoType;
        public int cueReplacementBehavior;
        public int decodedHeight;
        public int decodedWidth;
        public DrmInitData drmInitData;
        public int encoderDelay;
        public int encoderPadding;
        public float frameRate;
        public boolean hasPrerollSamples;
        public int height;
        public String id;
        public List initializationData;
        public String label;
        public ImmutableList labels;
        public String language;
        public int maxInputSize;
        public int maxNumReorderSamples;
        public int maxSubLayers;
        public Metadata metadata;
        public int pcmEncoding;
        public int peakBitrate;
        public float pixelWidthHeightRatio;
        public String primaryTrackGroupId;
        public byte[] projectionData;
        public int roleFlags;
        public int rotationDegrees;
        public String sampleMimeType;
        public int sampleRate;
        public int selectionFlags;
        public int stereoMode;
        public long subsampleOffsetUs;
        public int tileCountHorizontal;
        public int tileCountVertical;
        public int width;

        public Builder() {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            this.labels = RegularImmutableList.EMPTY;
            this.averageBitrate = -1;
            this.peakBitrate = -1;
            this.maxInputSize = -1;
            this.maxNumReorderSamples = -1;
            this.subsampleOffsetUs = Long.MAX_VALUE;
            this.width = -1;
            this.height = -1;
            this.decodedWidth = -1;
            this.decodedHeight = -1;
            this.frameRate = -1.0f;
            this.pixelWidthHeightRatio = 1.0f;
            this.stereoMode = -1;
            this.maxSubLayers = -1;
            this.channelCount = -1;
            this.sampleRate = -1;
            this.pcmEncoding = -1;
            this.accessibilityChannel = -1;
            this.cueReplacementBehavior = 1;
            this.tileCountHorizontal = -1;
            this.tileCountVertical = -1;
            this.cryptoType = 0;
            this.auxiliaryTrackType = 0;
        }
    }

    static {
        Integer.toString(8, 36);
        FIELD_CONTAINER_MIME_TYPE = Integer.toString(9, 36);
        FIELD_SAMPLE_MIME_TYPE = Integer.toString(10, 36);
        FIELD_MAX_INPUT_SIZE = Integer.toString(11, 36);
        FIELD_INITIALIZATION_DATA = Integer.toString(12, 36);
        FIELD_DRM_INIT_DATA = Integer.toString(13, 36);
        FIELD_SUBSAMPLE_OFFSET_US = Integer.toString(14, 36);
        FIELD_WIDTH = Integer.toString(15, 36);
        FIELD_HEIGHT = Integer.toString(16, 36);
        FIELD_FRAME_RATE = Integer.toString(17, 36);
        FIELD_ROTATION_DEGREES = Integer.toString(18, 36);
        FIELD_PIXEL_WIDTH_HEIGHT_RATIO = Integer.toString(19, 36);
        FIELD_PROJECTION_DATA = Integer.toString(20, 36);
        FIELD_STEREO_MODE = Integer.toString(21, 36);
        FIELD_COLOR_INFO = Integer.toString(22, 36);
        FIELD_CHANNEL_COUNT = Integer.toString(23, 36);
        FIELD_SAMPLE_RATE = Integer.toString(24, 36);
        FIELD_PCM_ENCODING = Integer.toString(25, 36);
        FIELD_ENCODER_DELAY = Integer.toString(26, 36);
        FIELD_ENCODER_PADDING = Integer.toString(27, 36);
        FIELD_ACCESSIBILITY_CHANNEL = Integer.toString(28, 36);
        FIELD_CRYPTO_TYPE = Integer.toString(29, 36);
        FIELD_TILE_COUNT_HORIZONTAL = Integer.toString(30, 36);
        FIELD_TILE_COUNT_VERTICAL = Integer.toString(31, 36);
        FIELD_LABELS = Integer.toString(32, 36);
        FIELD_AUXILIARY_TRACK_TYPE = Integer.toString(33, 36);
        FIELD_MAX_SUB_LAYERS = Integer.toString(34, 36);
        FIELD_DECODED_WIDTH = Integer.toString(35, 36);
        FIELD_DECODED_HEIGHT = Integer.toString(36, 36);
        FIELD_PRIMARY_TRACK_GROUP_ID = Integer.toString(37, 36);
    }

    public Format(Builder builder) {
        boolean z;
        String str;
        this.id = builder.id;
        String strNormalizeLanguageCode = Util.normalizeLanguageCode(builder.language);
        this.language = strNormalizeLanguageCode;
        if (builder.labels.isEmpty() && builder.label != null) {
            this.labels = ImmutableList.of((Object) new Label(strNormalizeLanguageCode, builder.label));
            this.label = builder.label;
        } else if (builder.labels.isEmpty() || builder.label != null) {
            if (!builder.labels.isEmpty() || builder.label != null) {
                int i = 0;
                while (true) {
                    if (i >= builder.labels.size()) {
                        z = false;
                        break;
                    } else {
                        if (((Label) builder.labels.get(i)).value.equals(builder.label)) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                }
            } else {
                z = true;
                break;
            }
            UtilsKt.checkState(z);
            this.labels = builder.labels;
            this.label = builder.label;
        } else {
            ImmutableList immutableList = builder.labels;
            this.labels = immutableList;
            int size = immutableList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    str = ((Label) immutableList.get(0)).value;
                    break;
                }
                Object obj = immutableList.get(i2);
                i2++;
                Label label = (Label) obj;
                if (TextUtils.equals(label.language, strNormalizeLanguageCode)) {
                    str = label.value;
                    break;
                }
            }
            this.label = str;
        }
        this.selectionFlags = builder.selectionFlags;
        UtilsKt.checkState("Auxiliary track type must only be set to a value other than AUXILIARY_TRACK_TYPE_UNDEFINED only when ROLE_FLAG_AUXILIARY is set", builder.auxiliaryTrackType == 0 || (builder.roleFlags & 32768) != 0);
        this.roleFlags = builder.roleFlags;
        this.auxiliaryTrackType = builder.auxiliaryTrackType;
        int i3 = builder.averageBitrate;
        this.averageBitrate = i3;
        int i4 = builder.peakBitrate;
        this.peakBitrate = i4;
        this.bitrate = i4 != -1 ? i4 : i3;
        this.codecs = builder.codecs;
        this.metadata = builder.metadata;
        this.primaryTrackGroupId = builder.primaryTrackGroupId;
        this.containerMimeType = builder.containerMimeType;
        this.sampleMimeType = builder.sampleMimeType;
        this.maxInputSize = builder.maxInputSize;
        this.maxNumReorderSamples = builder.maxNumReorderSamples;
        List list = builder.initializationData;
        this.initializationData = list == null ? Collections.EMPTY_LIST : list;
        DrmInitData drmInitData = builder.drmInitData;
        this.drmInitData = drmInitData;
        this.subsampleOffsetUs = builder.subsampleOffsetUs;
        this.hasPrerollSamples = builder.hasPrerollSamples;
        this.width = builder.width;
        this.height = builder.height;
        this.decodedWidth = builder.decodedWidth;
        this.decodedHeight = builder.decodedHeight;
        this.frameRate = builder.frameRate;
        int i5 = builder.rotationDegrees;
        this.rotationDegrees = i5 == -1 ? 0 : i5;
        float f = builder.pixelWidthHeightRatio;
        this.pixelWidthHeightRatio = f == -1.0f ? 1.0f : f;
        this.projectionData = builder.projectionData;
        this.stereoMode = builder.stereoMode;
        this.colorInfo = builder.colorInfo;
        this.maxSubLayers = builder.maxSubLayers;
        this.channelCount = builder.channelCount;
        this.sampleRate = builder.sampleRate;
        this.pcmEncoding = builder.pcmEncoding;
        int i6 = builder.encoderDelay;
        this.encoderDelay = i6 == -1 ? 0 : i6;
        int i7 = builder.encoderPadding;
        this.encoderPadding = i7 != -1 ? i7 : 0;
        this.accessibilityChannel = builder.accessibilityChannel;
        this.cueReplacementBehavior = builder.cueReplacementBehavior;
        this.tileCountHorizontal = builder.tileCountHorizontal;
        this.tileCountVertical = builder.tileCountVertical;
        int i8 = builder.cryptoType;
        if (i8 != 0 || drmInitData == null) {
            this.cryptoType = i8;
        } else {
            this.cryptoType = 1;
        }
    }

    public static String toLogString(Format format) {
        int i;
        String str;
        String strM;
        if (format == null) {
            return "null";
        }
        int i2 = format.selectionFlags;
        ImmutableList immutableList = format.labels;
        String str2 = format.language;
        int i3 = format.sampleRate;
        int i4 = format.channelCount;
        int i5 = format.maxSubLayers;
        float f = format.frameRate;
        ColorInfo colorInfo = format.colorInfo;
        float f2 = format.pixelWidthHeightRatio;
        int i6 = format.decodedHeight;
        int i7 = format.decodedWidth;
        int i8 = format.height;
        int i9 = format.width;
        DrmInitData drmInitData = format.drmInitData;
        String str3 = format.codecs;
        int i10 = format.bitrate;
        String str4 = format.primaryTrackGroupId;
        String str5 = format.containerMimeType;
        int i11 = format.roleFlags;
        Joiner joiner = new Joiner(String.valueOf(','));
        StringBuilder sbM = Format$$ExternalSyntheticOutline0.m("id=");
        sbM.append(format.id);
        sbM.append(", mimeType=");
        sbM.append(format.sampleMimeType);
        if (str5 != null) {
            sbM.append(", container=");
            sbM.append(str5);
        }
        if (str4 != null) {
            sbM.append(", primaryGroupId=");
            sbM.append(str4);
        }
        if (i10 != -1) {
            sbM.append(", bitrate=");
            sbM.append(i10);
        }
        if (str3 != null) {
            sbM.append(", codecs=");
            sbM.append(str3);
        }
        if (drmInitData != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i12 = 0; i12 < drmInitData.schemeDataCount; i12++) {
                UUID uuid = drmInitData.schemeDatas[i12].uuid;
                if (uuid.equals(C.COMMON_PSSH_UUID)) {
                    linkedHashSet.add("cenc");
                } else if (uuid.equals(C.CLEARKEY_UUID)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(C.PLAYREADY_UUID)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(C.WIDEVINE_UUID)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(C.UUID_NIL)) {
                    linkedHashSet.add("universal");
                } else {
                    linkedHashSet.add("unknown (" + uuid + ")");
                }
            }
            sbM.append(", drm=[");
            joiner.appendTo(sbM, linkedHashSet.iterator());
            sbM.append(']');
        }
        if (i9 != -1 && i8 != -1) {
            sbM.append(", res=");
            sbM.append(i9);
            sbM.append("x");
            sbM.append(i8);
        }
        if (i7 != -1 && i6 != -1) {
            sbM.append(", decRes=");
            sbM.append(i7);
            sbM.append("x");
            sbM.append(i6);
        }
        double d = f2;
        int i13 = DoubleMath.$r8$clinit;
        if (Math.copySign(d - 1.0d, 1.0d) > 0.001d && d != 1.0d && (!Double.isNaN(d) || !Double.isNaN(1.0d))) {
            sbM.append(", par=");
            Object[] objArr = {Float.valueOf(f2)};
            String str6 = Util.DEVICE_DEBUG_INFO;
            sbM.append(String.format(Locale.US, "%.3f", objArr));
        }
        if (colorInfo != null) {
            int i14 = colorInfo.chromaBitdepth;
            int i15 = colorInfo.lumaBitdepth;
            if ((i15 != -1 && i14 != -1) || colorInfo.isDataSpaceValid()) {
                sbM.append(", color=");
                if (colorInfo.isDataSpaceValid()) {
                    String strColorSpaceToString = ColorInfo.colorSpaceToString(colorInfo.colorSpace);
                    String strColorRangeToString = ColorInfo.colorRangeToString(colorInfo.colorRange);
                    String strColorTransferToString = ColorInfo.colorTransferToString(colorInfo.colorTransfer);
                    String str7 = Util.DEVICE_DEBUG_INFO;
                    Locale locale = Locale.US;
                    strM = Fragment$5$$ExternalSyntheticOutline0.m(strColorSpaceToString, "/", strColorRangeToString, "/", strColorTransferToString);
                } else {
                    strM = "NA/NA/NA";
                }
                sbM.append(strM + "/" + ((i15 == -1 || i14 == -1) ? "NA/NA" : i15 + "/" + i14));
            }
        }
        if (f != -1.0f) {
            sbM.append(", fps=");
            sbM.append(f);
        }
        if (i5 != -1) {
            sbM.append(", maxSubLayers=");
            sbM.append(i5);
        }
        if (i4 != -1) {
            sbM.append(", channels=");
            sbM.append(i4);
        }
        if (i3 != -1) {
            sbM.append(", sample_rate=");
            sbM.append(i3);
        }
        if (str2 != null) {
            sbM.append(", language=");
            sbM.append(str2);
        }
        if (!immutableList.isEmpty()) {
            sbM.append(", labels=[");
            joiner.appendTo(sbM, Maps.transform(new Format$$ExternalSyntheticLambda1((byte) 0), immutableList).iterator());
            sbM.append("]");
        }
        if (i2 != 0) {
            sbM.append(", selectionFlags=[");
            String str8 = Util.DEVICE_DEBUG_INFO;
            ArrayList arrayList = new ArrayList();
            if ((i2 & 4) != 0) {
                arrayList.add("auto");
            }
            if ((i2 & 1) != 0) {
                arrayList.add("default");
            }
            if ((i2 & 2) != 0) {
                arrayList.add("forced");
            }
            joiner.appendTo(sbM, arrayList.iterator());
            sbM.append("]");
        }
        if (i11 != 0) {
            sbM.append(", roleFlags=[");
            String str9 = Util.DEVICE_DEBUG_INFO;
            ArrayList arrayList2 = new ArrayList();
            if ((i11 & 1) != 0) {
                arrayList2.add("main");
            }
            if ((i11 & 2) != 0) {
                arrayList2.add("alt");
            }
            if ((i11 & 4) != 0) {
                arrayList2.add("supplementary");
            }
            if ((i11 & 8) != 0) {
                arrayList2.add("commentary");
            }
            if ((i11 & 16) != 0) {
                arrayList2.add("dub");
            }
            if ((i11 & 32) != 0) {
                arrayList2.add("emergency");
            }
            if ((i11 & 64) != 0) {
                arrayList2.add("caption");
            }
            i = i11;
            if ((i & 128) != 0) {
                arrayList2.add("subtitle");
            }
            if ((i & 256) != 0) {
                arrayList2.add("sign");
            }
            if ((i & 512) != 0) {
                arrayList2.add("describes-video");
            }
            if ((i & 1024) != 0) {
                arrayList2.add("describes-music");
            }
            if ((i & 2048) != 0) {
                arrayList2.add("enhanced-intelligibility");
            }
            if ((i & 4096) != 0) {
                arrayList2.add("transcribes-dialog");
            }
            if ((i & 8192) != 0) {
                arrayList2.add("easy-read");
            }
            if ((i & 16384) != 0) {
                arrayList2.add("trick-play");
            }
            if ((i & 32768) != 0) {
                arrayList2.add("auxiliary");
            }
            joiner.appendTo(sbM, arrayList2.iterator());
            sbM.append("]");
        } else {
            i = i11;
        }
        if ((i & 32768) != 0) {
            sbM.append(", auxiliaryTrackType=");
            int i16 = format.auxiliaryTrackType;
            String str10 = Util.DEVICE_DEBUG_INFO;
            if (i16 == 0) {
                str = "undefined";
            } else if (i16 == 1) {
                str = "original";
            } else if (i16 == 2) {
                str = "depth-linear";
            } else if (i16 == 3) {
                str = "depth-inverse";
            } else {
                if (i16 != 4) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Unsupported auxiliary track type");
                    return null;
                }
                str = "depth metadata";
            }
            sbM.append(str);
        }
        return sbM.toString();
    }

    public final Builder buildUpon() {
        Builder builder = new Builder();
        builder.id = this.id;
        builder.label = this.label;
        builder.labels = this.labels;
        builder.language = this.language;
        builder.selectionFlags = this.selectionFlags;
        builder.roleFlags = this.roleFlags;
        builder.averageBitrate = this.averageBitrate;
        builder.peakBitrate = this.peakBitrate;
        builder.codecs = this.codecs;
        builder.metadata = this.metadata;
        builder.primaryTrackGroupId = this.primaryTrackGroupId;
        builder.containerMimeType = this.containerMimeType;
        builder.sampleMimeType = this.sampleMimeType;
        builder.maxInputSize = this.maxInputSize;
        builder.maxNumReorderSamples = this.maxNumReorderSamples;
        builder.initializationData = this.initializationData;
        builder.drmInitData = this.drmInitData;
        builder.subsampleOffsetUs = this.subsampleOffsetUs;
        builder.hasPrerollSamples = this.hasPrerollSamples;
        builder.width = this.width;
        builder.height = this.height;
        builder.decodedWidth = this.decodedWidth;
        builder.decodedHeight = this.decodedHeight;
        builder.frameRate = this.frameRate;
        builder.rotationDegrees = this.rotationDegrees;
        builder.pixelWidthHeightRatio = this.pixelWidthHeightRatio;
        builder.projectionData = this.projectionData;
        builder.stereoMode = this.stereoMode;
        builder.colorInfo = this.colorInfo;
        builder.maxSubLayers = this.maxSubLayers;
        builder.channelCount = this.channelCount;
        builder.sampleRate = this.sampleRate;
        builder.pcmEncoding = this.pcmEncoding;
        builder.encoderDelay = this.encoderDelay;
        builder.encoderPadding = this.encoderPadding;
        builder.accessibilityChannel = this.accessibilityChannel;
        builder.cueReplacementBehavior = this.cueReplacementBehavior;
        builder.tileCountHorizontal = this.tileCountHorizontal;
        builder.tileCountVertical = this.tileCountVertical;
        builder.cryptoType = this.cryptoType;
        return builder;
    }

    public final boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj == null || Format.class != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        int i2 = this.hashCode;
        return (i2 == 0 || (i = format.hashCode) == 0 || i2 == i) && this.selectionFlags == format.selectionFlags && this.roleFlags == format.roleFlags && this.auxiliaryTrackType == format.auxiliaryTrackType && this.averageBitrate == format.averageBitrate && this.peakBitrate == format.peakBitrate && this.maxInputSize == format.maxInputSize && this.subsampleOffsetUs == format.subsampleOffsetUs && this.width == format.width && this.height == format.height && this.decodedWidth == format.decodedWidth && this.decodedHeight == format.decodedHeight && this.rotationDegrees == format.rotationDegrees && this.stereoMode == format.stereoMode && this.maxSubLayers == format.maxSubLayers && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.accessibilityChannel == format.accessibilityChannel && this.tileCountHorizontal == format.tileCountHorizontal && this.tileCountVertical == format.tileCountVertical && this.cryptoType == format.cryptoType && Float.compare(this.frameRate, format.frameRate) == 0 && Float.compare(this.pixelWidthHeightRatio, format.pixelWidthHeightRatio) == 0 && Objects.equals(this.id, format.id) && Objects.equals(this.label, format.label) && this.labels.equals(format.labels) && Objects.equals(this.codecs, format.codecs) && Objects.equals(this.primaryTrackGroupId, format.primaryTrackGroupId) && Objects.equals(this.containerMimeType, format.containerMimeType) && Objects.equals(this.sampleMimeType, format.sampleMimeType) && Objects.equals(this.language, format.language) && Arrays.equals(this.projectionData, format.projectionData) && Objects.equals(this.metadata, format.metadata) && Objects.equals(this.colorInfo, format.colorInfo) && Objects.equals(this.drmInitData, format.drmInitData) && initializationDataEquals(format);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.id;
        int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.label;
        int iHashCode2 = (this.labels.hashCode() + ((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31;
        String str3 = this.language;
        int iHashCode3 = (((((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31) + this.auxiliaryTrackType) * 31) + this.averageBitrate) * 31) + this.peakBitrate) * 31;
        String str4 = this.codecs;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Metadata metadata = this.metadata;
        int iHashCode5 = (iHashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 961;
        String str5 = this.primaryTrackGroupId;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.containerMimeType;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.sampleMimeType;
        int iFloatToIntBits = ((((((((((((((((((((((Float.floatToIntBits(this.pixelWidthHeightRatio) + ((((Float.floatToIntBits(this.frameRate) + ((((((((((((((iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31) + this.maxInputSize) * 31) + ((int) this.subsampleOffsetUs)) * 31) + this.width) * 31) + this.height) * 31) + this.decodedWidth) * 31) + this.decodedHeight) * 31)) * 31) + this.rotationDegrees) * 31)) * 31) + this.stereoMode) * 31) + this.maxSubLayers) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.pcmEncoding) * 31) + this.encoderDelay) * 31) + this.encoderPadding) * 31) + this.accessibilityChannel) * 31) + this.tileCountHorizontal) * 31) + this.tileCountVertical) * 31) + this.cryptoType;
        this.hashCode = iFloatToIntBits;
        return iFloatToIntBits;
    }

    public final boolean initializationDataEquals(Format format) {
        List list = this.initializationData;
        if (list.size() != format.initializationData.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) format.initializationData.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Format(");
        sb.append(this.id);
        sb.append(", ");
        sb.append(this.label);
        sb.append(", ");
        sb.append(this.containerMimeType);
        sb.append(", ");
        sb.append(this.sampleMimeType);
        sb.append(", ");
        sb.append(this.codecs);
        sb.append(", ");
        sb.append(this.bitrate);
        sb.append(", ");
        sb.append(this.language);
        sb.append(", [");
        sb.append(this.width);
        sb.append(", ");
        sb.append(this.height);
        sb.append(", ");
        sb.append(this.frameRate);
        sb.append(", ");
        sb.append(this.colorInfo);
        sb.append("], [");
        sb.append(this.channelCount);
        sb.append(", ");
        return Fragment$5$$ExternalSyntheticOutline0.m(sb, this.sampleRate, "])");
    }
}
