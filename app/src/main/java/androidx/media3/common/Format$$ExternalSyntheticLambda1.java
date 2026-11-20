package androidx.media3.common;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.StreamVolumeManager$StreamVolumeState;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.mp4.Track;
import androidx.media3.extractor.text.CuesWithTiming;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.ObjectCountHashMap;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableMultiset;
import com.google.common.collect.RegularImmutableMultiset.ElementSet;
import com.google.common.net.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Format$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: Code duplicated, block: B:54:0x0116  */
    /* JADX WARN: Code duplicated, block: B:58:0x0124  */
    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        RegularImmutableList regularImmutableListBuild;
        StringBuilder sb;
        char cCharAt;
        int size;
        boolean z = true;
        int i = 0;
        switch (this.$r8$classId) {
            case 0:
                Label label = (Label) obj;
                return label.language + ": " + label.value;
            case 1:
                StreamKey streamKey = (StreamKey) obj;
                streamKey.getClass();
                Bundle bundle = new Bundle();
                int i2 = streamKey.periodIndex;
                if (i2 != 0) {
                    bundle.putInt(StreamKey.FIELD_PERIOD_INDEX, i2);
                }
                int i3 = streamKey.groupIndex;
                if (i3 != 0) {
                    bundle.putInt(StreamKey.FIELD_GROUP_INDEX, i3);
                }
                int i4 = streamKey.streamIndex;
                if (i4 != 0) {
                    bundle.putInt(StreamKey.FIELD_STREAM_INDEX, i4);
                }
                return bundle;
            case 2:
                MediaItem.SubtitleConfiguration subtitleConfiguration = (MediaItem.SubtitleConfiguration) obj;
                subtitleConfiguration.getClass();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(MediaItem.SubtitleConfiguration.FIELD_URI, subtitleConfiguration.uri);
                String str = subtitleConfiguration.mimeType;
                if (str != null) {
                    bundle2.putString(MediaItem.SubtitleConfiguration.FIELD_MIME_TYPE, str);
                }
                String str2 = subtitleConfiguration.language;
                if (str2 != null) {
                    bundle2.putString(MediaItem.SubtitleConfiguration.FIELD_LANGUAGE, str2);
                }
                int i5 = subtitleConfiguration.selectionFlags;
                if (i5 != 0) {
                    bundle2.putInt(MediaItem.SubtitleConfiguration.FIELD_SELECTION_FLAGS, i5);
                }
                int i6 = subtitleConfiguration.roleFlags;
                if (i6 != 0) {
                    bundle2.putInt(MediaItem.SubtitleConfiguration.FIELD_ROLE_FLAGS, i6);
                }
                String str3 = subtitleConfiguration.label;
                if (str3 != null) {
                    bundle2.putString(MediaItem.SubtitleConfiguration.FIELD_LABEL, str3);
                }
                String str4 = subtitleConfiguration.id;
                if (str4 != null) {
                    bundle2.putString(MediaItem.SubtitleConfiguration.FIELD_ID, str4);
                }
                return bundle2;
            case 3:
                Bundle bundle3 = (Bundle) obj;
                Uri uri = (Uri) bundle3.getParcelable(MediaItem.SubtitleConfiguration.FIELD_URI);
                uri.getClass();
                String string = bundle3.getString(MediaItem.SubtitleConfiguration.FIELD_MIME_TYPE);
                String string2 = bundle3.getString(MediaItem.SubtitleConfiguration.FIELD_LANGUAGE);
                int i7 = bundle3.getInt(MediaItem.SubtitleConfiguration.FIELD_SELECTION_FLAGS, 0);
                int i8 = bundle3.getInt(MediaItem.SubtitleConfiguration.FIELD_ROLE_FLAGS, 0);
                String string3 = bundle3.getString(MediaItem.SubtitleConfiguration.FIELD_LABEL);
                String string4 = bundle3.getString(MediaItem.SubtitleConfiguration.FIELD_ID);
                MediaItem.SubtitleConfiguration.Builder builder = new MediaItem.SubtitleConfiguration.Builder();
                builder.uri = uri;
                builder.mimeType = MimeTypes.normalizeMimeType(string);
                builder.language = string2;
                builder.selectionFlags = i7;
                builder.roleFlags = i8;
                builder.label = string3;
                builder.id = string4;
                return new MediaItem.SubtitleConfiguration(builder);
            case 4:
                Bundle bundle4 = (Bundle) obj;
                Format format = Format.DEFAULT;
                Format.Builder builder2 = new Format.Builder();
                if (bundle4 != null) {
                    ClassLoader classLoader = GlUtil.class.getClassLoader();
                    String str5 = Util.DEVICE_DEBUG_INFO;
                    bundle4.setClassLoader(classLoader);
                }
                String string5 = bundle4.getString(Format.FIELD_ID);
                String str6 = format.id;
                if (string5 == null) {
                    string5 = str6;
                }
                builder2.id = string5;
                String string6 = bundle4.getString(Format.FIELD_LABEL);
                String str7 = format.label;
                if (string6 == null) {
                    string6 = str7;
                }
                builder2.label = string6;
                ArrayList parcelableArrayList = bundle4.getParcelableArrayList(Format.FIELD_LABELS);
                if (parcelableArrayList == null) {
                    ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
                    regularImmutableListBuild = RegularImmutableList.EMPTY;
                } else {
                    ImmutableList.Builder builder3 = ImmutableList.builder();
                    for (int i9 = 0; i9 < parcelableArrayList.size(); i9++) {
                        Bundle bundle5 = (Bundle) parcelableArrayList.get(i9);
                        bundle5.getClass();
                        String string7 = bundle5.getString(Label.FIELD_LANGUAGE_INDEX);
                        String string8 = bundle5.getString(Label.FIELD_VALUE_INDEX);
                        string8.getClass();
                        builder3.add((Object) new Label(string7, string8));
                    }
                    regularImmutableListBuild = builder3.build();
                }
                builder2.labels = ImmutableList.copyOf((Collection) regularImmutableListBuild);
                String string9 = bundle4.getString(Format.FIELD_LANGUAGE);
                String str8 = format.language;
                if (string9 == null) {
                    string9 = str8;
                }
                builder2.language = string9;
                builder2.selectionFlags = bundle4.getInt(Format.FIELD_SELECTION_FLAGS, format.selectionFlags);
                builder2.roleFlags = bundle4.getInt(Format.FIELD_ROLE_FLAGS, format.roleFlags);
                builder2.auxiliaryTrackType = bundle4.getInt(Format.FIELD_AUXILIARY_TRACK_TYPE, format.auxiliaryTrackType);
                builder2.averageBitrate = bundle4.getInt(Format.FIELD_AVERAGE_BITRATE, format.averageBitrate);
                builder2.peakBitrate = bundle4.getInt(Format.FIELD_PEAK_BITRATE, format.peakBitrate);
                String string10 = bundle4.getString(Format.FIELD_CODECS);
                String str9 = format.codecs;
                if (string10 == null) {
                    string10 = str9;
                }
                builder2.codecs = string10;
                String string11 = bundle4.getString(Format.FIELD_PRIMARY_TRACK_GROUP_ID);
                String str10 = format.primaryTrackGroupId;
                if (string11 == null) {
                    string11 = str10;
                }
                builder2.primaryTrackGroupId = string11;
                String string12 = bundle4.getString(Format.FIELD_CONTAINER_MIME_TYPE);
                String str11 = format.containerMimeType;
                if (string12 == null) {
                    string12 = str11;
                }
                builder2.containerMimeType = MimeTypes.normalizeMimeType(string12);
                String string13 = bundle4.getString(Format.FIELD_SAMPLE_MIME_TYPE);
                String str12 = format.sampleMimeType;
                if (string13 == null) {
                    string13 = str12;
                }
                builder2.sampleMimeType = MimeTypes.normalizeMimeType(string13);
                builder2.maxInputSize = bundle4.getInt(Format.FIELD_MAX_INPUT_SIZE, format.maxInputSize);
                ArrayList arrayList = new ArrayList();
                while (true) {
                    byte[] byteArray = bundle4.getByteArray(Format.FIELD_INITIALIZATION_DATA + "_" + Integer.toString(i, 36));
                    if (byteArray == null) {
                        builder2.initializationData = arrayList;
                        builder2.drmInitData = (DrmInitData) bundle4.getParcelable(Format.FIELD_DRM_INIT_DATA);
                        builder2.subsampleOffsetUs = bundle4.getLong(Format.FIELD_SUBSAMPLE_OFFSET_US, format.subsampleOffsetUs);
                        builder2.width = bundle4.getInt(Format.FIELD_WIDTH, format.width);
                        builder2.height = bundle4.getInt(Format.FIELD_HEIGHT, format.height);
                        builder2.decodedWidth = bundle4.getInt(Format.FIELD_DECODED_WIDTH, format.decodedWidth);
                        builder2.decodedHeight = bundle4.getInt(Format.FIELD_DECODED_HEIGHT, format.decodedHeight);
                        builder2.frameRate = bundle4.getFloat(Format.FIELD_FRAME_RATE, format.frameRate);
                        builder2.rotationDegrees = bundle4.getInt(Format.FIELD_ROTATION_DEGREES, format.rotationDegrees);
                        builder2.pixelWidthHeightRatio = bundle4.getFloat(Format.FIELD_PIXEL_WIDTH_HEIGHT_RATIO, format.pixelWidthHeightRatio);
                        builder2.projectionData = bundle4.getByteArray(Format.FIELD_PROJECTION_DATA);
                        builder2.stereoMode = bundle4.getInt(Format.FIELD_STEREO_MODE, format.stereoMode);
                        builder2.maxSubLayers = bundle4.getInt(Format.FIELD_MAX_SUB_LAYERS, format.maxSubLayers);
                        Bundle bundle6 = bundle4.getBundle(Format.FIELD_COLOR_INFO);
                        if (bundle6 != null) {
                            builder2.colorInfo = new ColorInfo(bundle6.getInt(ColorInfo.FIELD_COLOR_SPACE, -1), bundle6.getInt(ColorInfo.FIELD_COLOR_RANGE, -1), bundle6.getInt(ColorInfo.FIELD_COLOR_TRANSFER, -1), bundle6.getByteArray(ColorInfo.FIELD_HDR_STATIC_INFO), bundle6.getInt(ColorInfo.FIELD_LUMA_BITDEPTH, -1), bundle6.getInt(ColorInfo.FIELD_CHROMA_BITDEPTH, -1));
                        }
                        builder2.channelCount = bundle4.getInt(Format.FIELD_CHANNEL_COUNT, format.channelCount);
                        builder2.sampleRate = bundle4.getInt(Format.FIELD_SAMPLE_RATE, format.sampleRate);
                        builder2.pcmEncoding = bundle4.getInt(Format.FIELD_PCM_ENCODING, format.pcmEncoding);
                        builder2.encoderDelay = bundle4.getInt(Format.FIELD_ENCODER_DELAY, format.encoderDelay);
                        builder2.encoderPadding = bundle4.getInt(Format.FIELD_ENCODER_PADDING, format.encoderPadding);
                        builder2.accessibilityChannel = bundle4.getInt(Format.FIELD_ACCESSIBILITY_CHANNEL, format.accessibilityChannel);
                        builder2.tileCountHorizontal = bundle4.getInt(Format.FIELD_TILE_COUNT_HORIZONTAL, format.tileCountHorizontal);
                        builder2.tileCountVertical = bundle4.getInt(Format.FIELD_TILE_COUNT_VERTICAL, format.tileCountVertical);
                        builder2.cryptoType = bundle4.getInt(Format.FIELD_CRYPTO_TYPE, format.cryptoType);
                        return new Format(builder2);
                    }
                    arrayList.add(byteArray);
                    i++;
                }
                break;
            case 5:
                Tracks.Group group = (Tracks.Group) obj;
                group.getClass();
                Bundle bundle7 = new Bundle();
                bundle7.putBundle(Tracks.Group.FIELD_TRACK_GROUP, group.mediaTrackGroup.toBundle());
                bundle7.putIntArray(Tracks.Group.FIELD_TRACK_SUPPORT, group.trackSupport);
                bundle7.putBooleanArray(Tracks.Group.FIELD_TRACK_SELECTED, group.trackSelected);
                bundle7.putBoolean(Tracks.Group.FIELD_ADAPTIVE_SUPPORTED, group.adaptiveSupported);
                return bundle7;
            case 6:
                Bundle bundle8 = (Bundle) obj;
                Bundle bundle9 = bundle8.getBundle(Tracks.Group.FIELD_TRACK_GROUP);
                bundle9.getClass();
                TrackGroup trackGroupFromBundle = TrackGroup.fromBundle(bundle9);
                int[] intArray = bundle8.getIntArray(Tracks.Group.FIELD_TRACK_SUPPORT);
                int i10 = trackGroupFromBundle.length;
                int[] iArr = new int[i10];
                if (intArray == null) {
                    intArray = iArr;
                }
                boolean[] booleanArray = bundle8.getBooleanArray(Tracks.Group.FIELD_TRACK_SELECTED);
                boolean[] zArr = new boolean[i10];
                if (booleanArray == null) {
                    booleanArray = zArr;
                }
                return new Tracks.Group(trackGroupFromBundle, bundle8.getBoolean(Tracks.Group.FIELD_ADAPTIVE_SUPPORTED, false), intArray, booleanArray);
            case 7:
                return Integer.valueOf(((Cue) obj).zIndex);
            case 8:
                return new DefaultAnalyticsCollector((SystemClock) obj);
            case 9:
                StreamVolumeManager$StreamVolumeState streamVolumeManager$StreamVolumeState = (StreamVolumeManager$StreamVolumeState) obj;
                int i11 = streamVolumeManager$StreamVolumeState.streamType;
                int i12 = streamVolumeManager$StreamVolumeState.volume;
                int i13 = streamVolumeManager$StreamVolumeState.minVolume;
                return new StreamVolumeManager$StreamVolumeState(i12 <= 1, i11, i12 > i13 ? i12 - 1 : i13, i13, streamVolumeManager$StreamVolumeState.maxVolume);
            case 10:
                Extractor extractor = (Extractor) obj;
                extractor.getClass();
                return extractor.getClass().getSimpleName();
            case 11:
                return ImmutableList.copyOf((Collection) Maps.transform(new Format$$ExternalSyntheticLambda1((byte) 12), ((MediaPeriod) obj).getTrackGroups().trackGroups));
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return Integer.valueOf(((TrackGroup) obj).type);
            case 13:
                return Long.valueOf(((CuesWithTiming) obj).startTimeUs);
            case 14:
                return Long.valueOf(((CuesWithTiming) obj).durationUs);
            case 15:
                TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
                trackGroupArray.getClass();
                Bundle bundle10 = new Bundle();
                String str13 = TrackGroupArray.FIELD_TRACK_GROUPS;
                RegularImmutableList regularImmutableList = trackGroupArray.trackGroups;
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(regularImmutableList.size);
                ImmutableList.Itr itrListIterator = regularImmutableList.listIterator(0);
                while (itrListIterator.hasNext()) {
                    arrayList2.add(((TrackGroup) itrListIterator.next()).toBundle());
                }
                bundle10.putParcelableArrayList(str13, arrayList2);
                return bundle10;
            case 16:
                return (Track) obj;
            case 17:
                return (Track) obj;
            case 18:
                long j = ((CuesWithTiming) obj).startTimeUs;
                if (j == -9223372036854775807L) {
                    j = 0;
                }
                return Long.valueOf(j);
            case 19:
                String str14 = (String) obj;
                CharMatcher.And and = MediaType.TOKEN_MATCHER;
                and.getClass();
                for (int length = str14.length() - 1; length >= 0; length--) {
                    if (!and.matches(str14.charAt(length))) {
                        z = false;
                        if (!z && !str14.isEmpty()) {
                            return str14;
                        }
                        sb = new StringBuilder(str14.length() + 16);
                        sb.append('\"');
                        while (i < str14.length()) {
                            cCharAt = str14.charAt(i);
                            if (cCharAt != '\r' || cCharAt == '\\' || cCharAt == '\"') {
                                sb.append('\\');
                            }
                            sb.append(cCharAt);
                            i++;
                        }
                        sb.append('\"');
                        return sb.toString();
                    }
                }
                if (!z) {
                }
                sb = new StringBuilder(str14.length() + 16);
                sb.append('\"');
                while (i < str14.length()) {
                    cCharAt = str14.charAt(i);
                    if (cCharAt != '\r') {
                        sb.append('\\');
                    } else {
                        sb.append('\\');
                    }
                    sb.append(cCharAt);
                    i++;
                }
                sb.append('\"');
                return sb.toString();
            default:
                Collection collection = (Collection) obj;
                int i14 = ImmutableMultiset.$r8$clinit;
                if (collection instanceof ImmutableMultiset) {
                    return (ImmutableMultiset) collection;
                }
                boolean z2 = collection instanceof ImmutableMultiset;
                if (z2) {
                    RegularImmutableMultiset regularImmutableMultiset = (RegularImmutableMultiset) ((ImmutableMultiset) collection);
                    RegularImmutableMultiset.ElementSet elementSet = regularImmutableMultiset.elementSet;
                    if (elementSet == null) {
                        elementSet = regularImmutableMultiset.new ElementSet();
                        regularImmutableMultiset.elementSet = elementSet;
                    }
                    size = elementSet.size();
                } else {
                    size = 11;
                }
                ImmutableMultiset.Builder builder4 = new ImmutableMultiset.Builder();
                builder4.buildInvoked = false;
                ObjectCountHashMap objectCountHashMap = new ObjectCountHashMap();
                objectCountHashMap.init(size);
                builder4.contents = objectCountHashMap;
                if (z2) {
                    ImmutableMultiset immutableMultiset = (ImmutableMultiset) collection;
                    ObjectCountHashMap objectCountHashMap2 = immutableMultiset instanceof RegularImmutableMultiset ? ((RegularImmutableMultiset) immutableMultiset).contents : null;
                    if (objectCountHashMap2 != null) {
                        objectCountHashMap.ensureCapacity(Math.max(objectCountHashMap.size, objectCountHashMap2.size));
                        i = objectCountHashMap2.size == 0 ? -1 : 0;
                        while (i >= 0) {
                            UtilsKt.checkElementIndex(i, objectCountHashMap2.size);
                            Object obj2 = objectCountHashMap2.keys[i];
                            UtilsKt.checkElementIndex(i, objectCountHashMap2.size);
                            builder4.addCopies(objectCountHashMap2.values[i], obj2);
                            i++;
                            if (i >= objectCountHashMap2.size) {
                                i = -1;
                            }
                        }
                    } else {
                        ImmutableSet immutableSetEntrySet = immutableMultiset.entrySet();
                        ObjectCountHashMap objectCountHashMap3 = builder4.contents;
                        objectCountHashMap3.ensureCapacity(Math.max(objectCountHashMap3.size, immutableSetEntrySet.size()));
                        for (ObjectCountHashMap.MapEntry mapEntry : immutableMultiset.entrySet()) {
                            builder4.addCopies(mapEntry.getCount(), mapEntry.key);
                        }
                    }
                } else {
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        builder4.add(it.next());
                    }
                }
                Objects.requireNonNull(builder4.contents);
                if (builder4.contents.size == 0) {
                    return RegularImmutableMultiset.EMPTY;
                }
                builder4.buildInvoked = true;
                return new RegularImmutableMultiset(builder4.contents);
        }
    }

    public /* synthetic */ Format$$ExternalSyntheticLambda1(byte b) {
        this.$r8$classId = b;
    }
}
