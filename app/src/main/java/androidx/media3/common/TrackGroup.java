package androidx.media3.common;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TrackGroup {
    public static final String FIELD_FORMATS;
    public static final String FIELD_ID;
    public final Format[] formats;
    public int hashCode;
    public final String id;
    public final int length;
    public final int type;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_FORMATS = Integer.toString(0, 36);
        FIELD_ID = Integer.toString(1, 36);
    }

    public TrackGroup(String str, Format... formatArr) {
        UtilsKt.checkArgument(formatArr.length > 0);
        this.id = str;
        this.formats = formatArr;
        this.length = formatArr.length;
        String str2 = formatArr[0].sampleMimeType;
        this.type = TextUtils.isEmpty(str2) ? MimeTypes.getTrackType(formatArr[0].containerMimeType) : MimeTypes.getTrackType(str2);
        String str3 = formatArr[0].language;
        str3 = (str3 == null || str3.equals("und")) ? "" : str3;
        int i = formatArr[0].roleFlags | 16384;
        for (int i2 = 1; i2 < formatArr.length; i2++) {
            String str4 = formatArr[i2].language;
            if (!str3.equals((str4 == null || str4.equals("und")) ? "" : str4)) {
                logErrorMessage(i2, "languages", formatArr[0].language, formatArr[i2].language);
                return;
            } else {
                if (i != (formatArr[i2].roleFlags | 16384)) {
                    logErrorMessage(i2, "role flags", Integer.toBinaryString(formatArr[0].roleFlags), Integer.toBinaryString(formatArr[i2].roleFlags));
                    return;
                }
            }
        }
    }

    public static TrackGroup fromBundle(Bundle bundle) {
        RegularImmutableList regularImmutableListFromBundleList;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(FIELD_FORMATS);
        if (parcelableArrayList == null) {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            regularImmutableListFromBundleList = RegularImmutableList.EMPTY;
        } else {
            regularImmutableListFromBundleList = GlUtil.fromBundleList(new Format$$ExternalSyntheticLambda1((byte) 4), parcelableArrayList);
        }
        return new TrackGroup(bundle.getString(FIELD_ID, ""), (Format[]) regularImmutableListFromBundleList.toArray(new Format[0]));
    }

    public static void logErrorMessage(int i, String str, String str2, String str3) {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Different ", str, " combined in one TrackGroup: '", str2, "' (track 0) and '");
        sbM.append(str3);
        sbM.append("' (track ");
        sbM.append(i);
        sbM.append(")");
        Log.e("TrackGroup", "", new IllegalStateException(sbM.toString()));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TrackGroup.class == obj.getClass()) {
            TrackGroup trackGroup = (TrackGroup) obj;
            if (this.id.equals(trackGroup.id) && Arrays.equals(this.formats, trackGroup.formats)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.formats) + Fragment$5$$ExternalSyntheticOutline0.m(527, 31, this.id);
        this.hashCode = iHashCode;
        return iHashCode;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        Format[] formatArr = this.formats;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(formatArr.length);
        int length = formatArr.length;
        int i = 0;
        while (i < length) {
            Format format = formatArr[i];
            List list = format.initializationData;
            Bundle bundle2 = new Bundle();
            bundle2.putString(Format.FIELD_ID, format.id);
            bundle2.putString(Format.FIELD_LABEL, format.label);
            String str = Format.FIELD_LABELS;
            ImmutableList immutableList = format.labels;
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(immutableList.size());
            int size = immutableList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = immutableList.get(i2);
                i2++;
                Label label = (Label) obj;
                label.getClass();
                Bundle bundle3 = new Bundle();
                Format[] formatArr2 = formatArr;
                String str2 = label.language;
                int i3 = length;
                if (str2 != null) {
                    bundle3.putString(Label.FIELD_LANGUAGE_INDEX, str2);
                }
                bundle3.putString(Label.FIELD_VALUE_INDEX, label.value);
                arrayList2.add(bundle3);
                formatArr = formatArr2;
                length = i3;
            }
            Format[] formatArr3 = formatArr;
            int i4 = length;
            bundle2.putParcelableArrayList(str, arrayList2);
            bundle2.putString(Format.FIELD_LANGUAGE, format.language);
            bundle2.putInt(Format.FIELD_SELECTION_FLAGS, format.selectionFlags);
            bundle2.putInt(Format.FIELD_ROLE_FLAGS, format.roleFlags);
            int i5 = format.auxiliaryTrackType;
            if (i5 != Format.DEFAULT.auxiliaryTrackType) {
                bundle2.putInt(Format.FIELD_AUXILIARY_TRACK_TYPE, i5);
            }
            bundle2.putInt(Format.FIELD_AVERAGE_BITRATE, format.averageBitrate);
            bundle2.putInt(Format.FIELD_PEAK_BITRATE, format.peakBitrate);
            bundle2.putString(Format.FIELD_CODECS, format.codecs);
            String str3 = format.primaryTrackGroupId;
            if (str3 != null) {
                bundle2.putString(Format.FIELD_PRIMARY_TRACK_GROUP_ID, str3);
            }
            bundle2.putString(Format.FIELD_CONTAINER_MIME_TYPE, format.containerMimeType);
            bundle2.putString(Format.FIELD_SAMPLE_MIME_TYPE, format.sampleMimeType);
            bundle2.putInt(Format.FIELD_MAX_INPUT_SIZE, format.maxInputSize);
            for (int i6 = 0; i6 < list.size(); i6++) {
                bundle2.putByteArray(Format.FIELD_INITIALIZATION_DATA + "_" + Integer.toString(i6, 36), (byte[]) list.get(i6));
            }
            bundle2.putParcelable(Format.FIELD_DRM_INIT_DATA, format.drmInitData);
            bundle2.putLong(Format.FIELD_SUBSAMPLE_OFFSET_US, format.subsampleOffsetUs);
            bundle2.putInt(Format.FIELD_WIDTH, format.width);
            bundle2.putInt(Format.FIELD_HEIGHT, format.height);
            bundle2.putInt(Format.FIELD_DECODED_WIDTH, format.decodedWidth);
            bundle2.putInt(Format.FIELD_DECODED_HEIGHT, format.decodedHeight);
            bundle2.putFloat(Format.FIELD_FRAME_RATE, format.frameRate);
            bundle2.putInt(Format.FIELD_ROTATION_DEGREES, format.rotationDegrees);
            bundle2.putFloat(Format.FIELD_PIXEL_WIDTH_HEIGHT_RATIO, format.pixelWidthHeightRatio);
            bundle2.putByteArray(Format.FIELD_PROJECTION_DATA, format.projectionData);
            bundle2.putInt(Format.FIELD_STEREO_MODE, format.stereoMode);
            ColorInfo colorInfo = format.colorInfo;
            if (colorInfo != null) {
                String str4 = Format.FIELD_COLOR_INFO;
                Bundle bundle4 = new Bundle();
                bundle4.putInt(ColorInfo.FIELD_COLOR_SPACE, colorInfo.colorSpace);
                bundle4.putInt(ColorInfo.FIELD_COLOR_RANGE, colorInfo.colorRange);
                bundle4.putInt(ColorInfo.FIELD_COLOR_TRANSFER, colorInfo.colorTransfer);
                bundle4.putByteArray(ColorInfo.FIELD_HDR_STATIC_INFO, colorInfo.hdrStaticInfo);
                bundle4.putInt(ColorInfo.FIELD_LUMA_BITDEPTH, colorInfo.lumaBitdepth);
                bundle4.putInt(ColorInfo.FIELD_CHROMA_BITDEPTH, colorInfo.chromaBitdepth);
                bundle2.putBundle(str4, bundle4);
            }
            bundle2.putInt(Format.FIELD_MAX_SUB_LAYERS, format.maxSubLayers);
            bundle2.putInt(Format.FIELD_CHANNEL_COUNT, format.channelCount);
            bundle2.putInt(Format.FIELD_SAMPLE_RATE, format.sampleRate);
            bundle2.putInt(Format.FIELD_PCM_ENCODING, format.pcmEncoding);
            bundle2.putInt(Format.FIELD_ENCODER_DELAY, format.encoderDelay);
            bundle2.putInt(Format.FIELD_ENCODER_PADDING, format.encoderPadding);
            bundle2.putInt(Format.FIELD_ACCESSIBILITY_CHANNEL, format.accessibilityChannel);
            bundle2.putInt(Format.FIELD_TILE_COUNT_HORIZONTAL, format.tileCountHorizontal);
            bundle2.putInt(Format.FIELD_TILE_COUNT_VERTICAL, format.tileCountVertical);
            bundle2.putInt(Format.FIELD_CRYPTO_TYPE, format.cryptoType);
            arrayList.add(bundle2);
            i++;
            formatArr = formatArr3;
            length = i4;
        }
        bundle.putParcelableArrayList(FIELD_FORMATS, arrayList);
        bundle.putString(FIELD_ID, this.id);
        return bundle;
    }

    public final String toString() {
        return this.id + ": " + Arrays.toString(this.formats);
    }
}
