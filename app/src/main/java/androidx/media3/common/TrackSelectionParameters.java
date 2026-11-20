package androidx.media3.common;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class TrackSelectionParameters {
    public static final TrackSelectionParameters DEFAULT = new TrackSelectionParameters(new Builder());
    public static final String FIELD_AUDIO_OFFLOAD_MODE_PREFERENCE;
    public static final String FIELD_AUDIO_OFFLOAD_PREFERENCES;
    public static final String FIELD_DISABLED_TRACK_TYPE;
    public static final String FIELD_FORCE_HIGHEST_SUPPORTED_BITRATE;
    public static final String FIELD_FORCE_LOWEST_BITRATE;
    public static final String FIELD_IGNORED_TEXT_SELECTION_FLAGS;
    public static final String FIELD_IS_GAPLESS_SUPPORT_REQUIRED;
    public static final String FIELD_IS_PREFER_IMAGE_OVER_VIDEO_ENABLED;
    public static final String FIELD_IS_SPEED_CHANGE_SUPPORT_REQUIRED;
    public static final String FIELD_IS_VIEWPORT_SIZE_LIMITED_BY_PHYSICAL_DISPLAY_SIZE;
    public static final String FIELD_MAX_AUDIO_BITRATE;
    public static final String FIELD_MAX_AUDIO_CHANNEL_COUNT;
    public static final String FIELD_MAX_VIDEO_BITRATE;
    public static final String FIELD_MAX_VIDEO_FRAMERATE;
    public static final String FIELD_MAX_VIDEO_HEIGHT;
    public static final String FIELD_MAX_VIDEO_WIDTH;
    public static final String FIELD_MIN_VIDEO_BITRATE;
    public static final String FIELD_MIN_VIDEO_FRAMERATE;
    public static final String FIELD_MIN_VIDEO_HEIGHT;
    public static final String FIELD_MIN_VIDEO_WIDTH;
    public static final String FIELD_PREFERRED_AUDIO_LABELS;
    public static final String FIELD_PREFERRED_AUDIO_LANGUAGES;
    public static final String FIELD_PREFERRED_AUDIO_MIME_TYPES;
    public static final String FIELD_PREFERRED_AUDIO_ROLE_FLAGS;
    public static final String FIELD_PREFERRED_TEXT_LABELS;
    public static final String FIELD_PREFERRED_TEXT_LANGUAGES;
    public static final String FIELD_PREFERRED_TEXT_ROLE_FLAGS;
    public static final String FIELD_PREFERRED_VIDEO_LABELS;
    public static final String FIELD_PREFERRED_VIDEO_LANGUAGES;
    public static final String FIELD_PREFERRED_VIDEO_MIMETYPES;
    public static final String FIELD_PREFERRED_VIDEO_ROLE_FLAGS;
    public static final String FIELD_SELECTION_OVERRIDES;
    public static final String FIELD_SELECT_TEXT_BY_DEFAULT;
    public static final String FIELD_SELECT_UNDETERMINED_TEXT_LANGUAGE;
    public static final String FIELD_USE_PREFERRED_TEXT_LANGUAGES_AND_ROLE_FLAGS_FROM_CAPTIONING_MANAGER;
    public static final String FIELD_VIEWPORT_HEIGHT;
    public static final String FIELD_VIEWPORT_ORIENTATION_MAY_CHANGE;
    public static final String FIELD_VIEWPORT_WIDTH;
    public final AudioOffloadPreferences audioOffloadPreferences;
    public final ImmutableSet disabledTrackTypes;
    public final boolean forceHighestSupportedBitrate;
    public final boolean forceLowestBitrate;
    public final int ignoredTextSelectionFlags;
    public final boolean isPrioritizeImageOverVideoEnabled;
    public final boolean isViewportSizeLimitedByPhysicalDisplaySize;
    public final int maxAudioBitrate;
    public final int maxAudioChannelCount;
    public final int maxVideoBitrate;
    public final int maxVideoFrameRate;
    public final int maxVideoHeight;
    public final int maxVideoWidth;
    public final int minVideoBitrate;
    public final int minVideoFrameRate;
    public final int minVideoHeight;
    public final int minVideoWidth;
    public final ImmutableMap overrides;
    public final ImmutableList preferredAudioLabels;
    public final ImmutableList preferredAudioLanguages;
    public final ImmutableList preferredAudioMimeTypes;
    public final int preferredAudioRoleFlags;
    public final ImmutableList preferredTextLabels;
    public final ImmutableList preferredTextLanguages;
    public final int preferredTextRoleFlags;
    public final ImmutableList preferredVideoLabels;
    public final ImmutableList preferredVideoLanguages;
    public final ImmutableList preferredVideoMimeTypes;
    public final int preferredVideoRoleFlags;
    public final boolean selectTextByDefault;
    public final boolean selectUndeterminedTextLanguage;
    public final boolean usePreferredTextLanguagesAndRoleFlagsFromCaptioningManager;
    public final int viewportHeight;
    public final boolean viewportOrientationMayChange;
    public final int viewportWidth;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AudioOffloadPreferences {
        public static final AudioOffloadPreferences DEFAULT = new AudioOffloadPreferences(new Builder());
        public static final String FIELD_AUDIO_OFFLOAD_MODE_PREFERENCE;
        public static final String FIELD_IS_GAPLESS_SUPPORT_REQUIRED;
        public static final String FIELD_IS_SPEED_CHANGE_SUPPORT_REQUIRED;
        public final int audioOffloadMode;
        public final boolean isGaplessSupportRequired;
        public final boolean isSpeedChangeSupportRequired;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Builder {
            public int audioOffloadMode = 0;
            public boolean isGaplessSupportRequired = false;
            public boolean isSpeedChangeSupportRequired = false;
        }

        static {
            String str = Util.DEVICE_DEBUG_INFO;
            FIELD_AUDIO_OFFLOAD_MODE_PREFERENCE = Integer.toString(1, 36);
            FIELD_IS_GAPLESS_SUPPORT_REQUIRED = Integer.toString(2, 36);
            FIELD_IS_SPEED_CHANGE_SUPPORT_REQUIRED = Integer.toString(3, 36);
        }

        public AudioOffloadPreferences(Builder builder) {
            this.audioOffloadMode = builder.audioOffloadMode;
            this.isGaplessSupportRequired = builder.isGaplessSupportRequired;
            this.isSpeedChangeSupportRequired = builder.isSpeedChangeSupportRequired;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && AudioOffloadPreferences.class == obj.getClass()) {
                AudioOffloadPreferences audioOffloadPreferences = (AudioOffloadPreferences) obj;
                if (this.audioOffloadMode == audioOffloadPreferences.audioOffloadMode && this.isGaplessSupportRequired == audioOffloadPreferences.isGaplessSupportRequired && this.isSpeedChangeSupportRequired == audioOffloadPreferences.isSpeedChangeSupportRequired) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return ((((this.audioOffloadMode + 31) * 31) + (this.isGaplessSupportRequired ? 1 : 0)) * 31) + (this.isSpeedChangeSupportRequired ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class Builder {
        public AudioOffloadPreferences audioOffloadPreferences;
        public HashSet disabledTrackTypes;
        public boolean forceHighestSupportedBitrate;
        public boolean forceLowestBitrate;
        public int ignoredTextSelectionFlags;
        public boolean isPrioritizeImageOverVideoEnabled;
        public int maxAudioBitrate;
        public int maxAudioChannelCount;
        public int minVideoBitrate;
        public int minVideoFrameRate;
        public int minVideoHeight;
        public int minVideoWidth;
        public HashMap overrides;
        public ImmutableList preferredAudioLabels;
        public ImmutableList preferredAudioLanguages;
        public ImmutableList preferredAudioMimeTypes;
        public int preferredAudioRoleFlags;
        public ImmutableList preferredTextLabels;
        public ImmutableList preferredTextLanguages;
        public int preferredTextRoleFlags;
        public ImmutableList preferredVideoLabels;
        public ImmutableList preferredVideoLanguages;
        public ImmutableList preferredVideoMimeTypes;
        public int preferredVideoRoleFlags;
        public boolean selectTextByDefault;
        public boolean selectUndeterminedTextLanguage;
        public boolean usePreferredTextLanguagesAndRoleFlagsFromCaptioningManager;
        public int maxVideoWidth = Integer.MAX_VALUE;
        public int maxVideoHeight = Integer.MAX_VALUE;
        public int maxVideoFrameRate = Integer.MAX_VALUE;
        public int maxVideoBitrate = Integer.MAX_VALUE;
        public int viewportWidth = Integer.MAX_VALUE;
        public int viewportHeight = Integer.MAX_VALUE;
        public boolean isViewportSizeLimitedByPhysicalDisplaySize = true;
        public boolean viewportOrientationMayChange = true;

        public Builder() {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            RegularImmutableList regularImmutableList = RegularImmutableList.EMPTY;
            this.preferredVideoMimeTypes = regularImmutableList;
            this.preferredVideoLabels = regularImmutableList;
            this.preferredVideoLanguages = regularImmutableList;
            this.preferredVideoRoleFlags = 0;
            this.preferredAudioLanguages = regularImmutableList;
            this.preferredAudioLabels = regularImmutableList;
            this.preferredAudioRoleFlags = 0;
            this.maxAudioChannelCount = Integer.MAX_VALUE;
            this.maxAudioBitrate = Integer.MAX_VALUE;
            this.preferredAudioMimeTypes = regularImmutableList;
            this.audioOffloadPreferences = AudioOffloadPreferences.DEFAULT;
            this.selectTextByDefault = false;
            this.preferredTextLanguages = regularImmutableList;
            this.preferredTextRoleFlags = 0;
            this.usePreferredTextLanguagesAndRoleFlagsFromCaptioningManager = true;
            this.preferredTextLabels = regularImmutableList;
            this.ignoredTextSelectionFlags = 0;
            this.selectUndeterminedTextLanguage = false;
            this.isPrioritizeImageOverVideoEnabled = false;
            this.forceLowestBitrate = false;
            this.forceHighestSupportedBitrate = false;
            this.overrides = new HashMap();
            this.disabledTrackTypes = new HashSet();
        }

        public static RegularImmutableList normalizeLanguageCodes(String[] strArr) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (String str : strArr) {
                str.getClass();
                builder.add((Object) Util.normalizeLanguageCode(str));
            }
            return builder.build();
        }

        public void addOverride(TrackSelectionOverride trackSelectionOverride) {
            this.overrides.put(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
        }

        public TrackSelectionParameters build() {
            return new TrackSelectionParameters(this);
        }

        public Builder clearOverrides() {
            this.overrides.clear();
            return this;
        }

        public final void init(TrackSelectionParameters trackSelectionParameters) {
            this.maxVideoWidth = trackSelectionParameters.maxVideoWidth;
            this.maxVideoHeight = trackSelectionParameters.maxVideoHeight;
            this.maxVideoFrameRate = trackSelectionParameters.maxVideoFrameRate;
            this.maxVideoBitrate = trackSelectionParameters.maxVideoBitrate;
            this.minVideoWidth = trackSelectionParameters.minVideoWidth;
            this.minVideoHeight = trackSelectionParameters.minVideoHeight;
            this.minVideoFrameRate = trackSelectionParameters.minVideoFrameRate;
            this.minVideoBitrate = trackSelectionParameters.minVideoBitrate;
            this.viewportWidth = trackSelectionParameters.viewportWidth;
            this.viewportHeight = trackSelectionParameters.viewportHeight;
            this.isViewportSizeLimitedByPhysicalDisplaySize = trackSelectionParameters.isViewportSizeLimitedByPhysicalDisplaySize;
            this.viewportOrientationMayChange = trackSelectionParameters.viewportOrientationMayChange;
            this.preferredVideoLabels = trackSelectionParameters.preferredVideoLabels;
            this.preferredVideoMimeTypes = trackSelectionParameters.preferredVideoMimeTypes;
            this.preferredVideoLanguages = trackSelectionParameters.preferredVideoLanguages;
            this.preferredVideoRoleFlags = trackSelectionParameters.preferredVideoRoleFlags;
            this.preferredAudioLanguages = trackSelectionParameters.preferredAudioLanguages;
            this.preferredAudioRoleFlags = trackSelectionParameters.preferredAudioRoleFlags;
            this.preferredAudioLabels = trackSelectionParameters.preferredAudioLabels;
            this.maxAudioChannelCount = trackSelectionParameters.maxAudioChannelCount;
            this.maxAudioBitrate = trackSelectionParameters.maxAudioBitrate;
            this.preferredAudioMimeTypes = trackSelectionParameters.preferredAudioMimeTypes;
            this.audioOffloadPreferences = trackSelectionParameters.audioOffloadPreferences;
            this.selectTextByDefault = trackSelectionParameters.selectTextByDefault;
            this.preferredTextLanguages = trackSelectionParameters.preferredTextLanguages;
            this.preferredTextRoleFlags = trackSelectionParameters.preferredTextRoleFlags;
            this.usePreferredTextLanguagesAndRoleFlagsFromCaptioningManager = trackSelectionParameters.usePreferredTextLanguagesAndRoleFlagsFromCaptioningManager;
            this.preferredTextLabels = trackSelectionParameters.preferredTextLabels;
            this.ignoredTextSelectionFlags = trackSelectionParameters.ignoredTextSelectionFlags;
            this.selectUndeterminedTextLanguage = trackSelectionParameters.selectUndeterminedTextLanguage;
            this.isPrioritizeImageOverVideoEnabled = trackSelectionParameters.isPrioritizeImageOverVideoEnabled;
            this.forceLowestBitrate = trackSelectionParameters.forceLowestBitrate;
            this.forceHighestSupportedBitrate = trackSelectionParameters.forceHighestSupportedBitrate;
            this.disabledTrackTypes = new HashSet(trackSelectionParameters.disabledTrackTypes);
            this.overrides = new HashMap(trackSelectionParameters.overrides);
        }

        public Builder setAudioOffloadPreferences(AudioOffloadPreferences audioOffloadPreferences) {
            this.audioOffloadPreferences = audioOffloadPreferences;
            return this;
        }
    }

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_PREFERRED_AUDIO_LANGUAGES = Integer.toString(1, 36);
        FIELD_PREFERRED_AUDIO_ROLE_FLAGS = Integer.toString(2, 36);
        FIELD_PREFERRED_TEXT_LANGUAGES = Integer.toString(3, 36);
        FIELD_PREFERRED_TEXT_ROLE_FLAGS = Integer.toString(4, 36);
        FIELD_SELECT_UNDETERMINED_TEXT_LANGUAGE = Integer.toString(5, 36);
        FIELD_MAX_VIDEO_WIDTH = Integer.toString(6, 36);
        FIELD_MAX_VIDEO_HEIGHT = Integer.toString(7, 36);
        FIELD_MAX_VIDEO_FRAMERATE = Integer.toString(8, 36);
        FIELD_MAX_VIDEO_BITRATE = Integer.toString(9, 36);
        FIELD_MIN_VIDEO_WIDTH = Integer.toString(10, 36);
        FIELD_MIN_VIDEO_HEIGHT = Integer.toString(11, 36);
        FIELD_MIN_VIDEO_FRAMERATE = Integer.toString(12, 36);
        FIELD_MIN_VIDEO_BITRATE = Integer.toString(13, 36);
        FIELD_VIEWPORT_WIDTH = Integer.toString(14, 36);
        FIELD_VIEWPORT_HEIGHT = Integer.toString(15, 36);
        FIELD_VIEWPORT_ORIENTATION_MAY_CHANGE = Integer.toString(16, 36);
        FIELD_PREFERRED_VIDEO_MIMETYPES = Integer.toString(17, 36);
        FIELD_MAX_AUDIO_CHANNEL_COUNT = Integer.toString(18, 36);
        FIELD_MAX_AUDIO_BITRATE = Integer.toString(19, 36);
        FIELD_PREFERRED_AUDIO_MIME_TYPES = Integer.toString(20, 36);
        FIELD_FORCE_LOWEST_BITRATE = Integer.toString(21, 36);
        FIELD_FORCE_HIGHEST_SUPPORTED_BITRATE = Integer.toString(22, 36);
        FIELD_SELECTION_OVERRIDES = Integer.toString(23, 36);
        FIELD_DISABLED_TRACK_TYPE = Integer.toString(24, 36);
        FIELD_PREFERRED_VIDEO_ROLE_FLAGS = Integer.toString(25, 36);
        FIELD_IGNORED_TEXT_SELECTION_FLAGS = Integer.toString(26, 36);
        FIELD_AUDIO_OFFLOAD_MODE_PREFERENCE = Integer.toString(27, 36);
        FIELD_IS_GAPLESS_SUPPORT_REQUIRED = Integer.toString(28, 36);
        FIELD_IS_SPEED_CHANGE_SUPPORT_REQUIRED = Integer.toString(29, 36);
        FIELD_AUDIO_OFFLOAD_PREFERENCES = Integer.toString(30, 36);
        FIELD_IS_PREFER_IMAGE_OVER_VIDEO_ENABLED = Integer.toString(31, 36);
        FIELD_PREFERRED_VIDEO_LANGUAGES = Integer.toString(32, 36);
        FIELD_IS_VIEWPORT_SIZE_LIMITED_BY_PHYSICAL_DISPLAY_SIZE = Integer.toString(33, 36);
        FIELD_USE_PREFERRED_TEXT_LANGUAGES_AND_ROLE_FLAGS_FROM_CAPTIONING_MANAGER = Integer.toString(34, 36);
        FIELD_SELECT_TEXT_BY_DEFAULT = Integer.toString(35, 36);
        FIELD_PREFERRED_VIDEO_LABELS = Integer.toString(36, 36);
        FIELD_PREFERRED_AUDIO_LABELS = Integer.toString(37, 36);
        FIELD_PREFERRED_TEXT_LABELS = Integer.toString(38, 36);
    }

    public TrackSelectionParameters(Builder builder) {
        this.maxVideoWidth = builder.maxVideoWidth;
        this.maxVideoHeight = builder.maxVideoHeight;
        this.maxVideoFrameRate = builder.maxVideoFrameRate;
        this.maxVideoBitrate = builder.maxVideoBitrate;
        this.minVideoWidth = builder.minVideoWidth;
        this.minVideoHeight = builder.minVideoHeight;
        this.minVideoFrameRate = builder.minVideoFrameRate;
        this.minVideoBitrate = builder.minVideoBitrate;
        this.viewportWidth = builder.viewportWidth;
        this.viewportHeight = builder.viewportHeight;
        this.isViewportSizeLimitedByPhysicalDisplaySize = builder.isViewportSizeLimitedByPhysicalDisplaySize;
        this.viewportOrientationMayChange = builder.viewportOrientationMayChange;
        this.preferredVideoMimeTypes = builder.preferredVideoMimeTypes;
        this.preferredVideoLabels = builder.preferredVideoLabels;
        this.preferredVideoLanguages = builder.preferredVideoLanguages;
        this.preferredVideoRoleFlags = builder.preferredVideoRoleFlags;
        this.preferredAudioLanguages = builder.preferredAudioLanguages;
        this.preferredAudioRoleFlags = builder.preferredAudioRoleFlags;
        this.maxAudioChannelCount = builder.maxAudioChannelCount;
        this.preferredAudioLabels = builder.preferredAudioLabels;
        this.maxAudioBitrate = builder.maxAudioBitrate;
        this.preferredAudioMimeTypes = builder.preferredAudioMimeTypes;
        this.audioOffloadPreferences = builder.audioOffloadPreferences;
        this.selectTextByDefault = builder.selectTextByDefault;
        this.preferredTextLanguages = builder.preferredTextLanguages;
        this.preferredTextRoleFlags = builder.preferredTextRoleFlags;
        this.usePreferredTextLanguagesAndRoleFlagsFromCaptioningManager = builder.usePreferredTextLanguagesAndRoleFlagsFromCaptioningManager;
        this.preferredTextLabels = builder.preferredTextLabels;
        this.ignoredTextSelectionFlags = builder.ignoredTextSelectionFlags;
        this.selectUndeterminedTextLanguage = builder.selectUndeterminedTextLanguage;
        this.isPrioritizeImageOverVideoEnabled = builder.isPrioritizeImageOverVideoEnabled;
        this.forceLowestBitrate = builder.forceLowestBitrate;
        this.forceHighestSupportedBitrate = builder.forceHighestSupportedBitrate;
        this.overrides = ImmutableMap.copyOf((Map) builder.overrides);
        this.disabledTrackTypes = ImmutableSet.copyOf((Collection) builder.disabledTrackTypes);
    }

    public static TrackSelectionParameters fromBundle(Bundle bundle) {
        AudioOffloadPreferences audioOffloadPreferences;
        RegularImmutableList regularImmutableListBuild;
        Builder builder = new Builder();
        TrackSelectionParameters trackSelectionParameters = DEFAULT;
        builder.maxVideoWidth = bundle.getInt(FIELD_MAX_VIDEO_WIDTH, trackSelectionParameters.maxVideoWidth);
        builder.maxVideoHeight = bundle.getInt(FIELD_MAX_VIDEO_HEIGHT, trackSelectionParameters.maxVideoHeight);
        builder.maxVideoFrameRate = bundle.getInt(FIELD_MAX_VIDEO_FRAMERATE, trackSelectionParameters.maxVideoFrameRate);
        builder.maxVideoBitrate = bundle.getInt(FIELD_MAX_VIDEO_BITRATE, trackSelectionParameters.maxVideoBitrate);
        builder.minVideoWidth = bundle.getInt(FIELD_MIN_VIDEO_WIDTH, trackSelectionParameters.minVideoWidth);
        builder.minVideoHeight = bundle.getInt(FIELD_MIN_VIDEO_HEIGHT, trackSelectionParameters.minVideoHeight);
        builder.minVideoFrameRate = bundle.getInt(FIELD_MIN_VIDEO_FRAMERATE, trackSelectionParameters.minVideoFrameRate);
        builder.minVideoBitrate = bundle.getInt(FIELD_MIN_VIDEO_BITRATE, trackSelectionParameters.minVideoBitrate);
        builder.viewportWidth = bundle.getInt(FIELD_VIEWPORT_WIDTH, trackSelectionParameters.viewportWidth);
        int i = bundle.getInt(FIELD_VIEWPORT_HEIGHT, trackSelectionParameters.viewportHeight);
        builder.viewportHeight = i;
        builder.isViewportSizeLimitedByPhysicalDisplaySize = builder.viewportWidth == Integer.MAX_VALUE && i == Integer.MAX_VALUE && bundle.getBoolean(FIELD_IS_VIEWPORT_SIZE_LIMITED_BY_PHYSICAL_DISPLAY_SIZE, trackSelectionParameters.isViewportSizeLimitedByPhysicalDisplaySize);
        builder.viewportOrientationMayChange = bundle.getBoolean(FIELD_VIEWPORT_ORIENTATION_MAY_CHANGE, trackSelectionParameters.viewportOrientationMayChange);
        String[] stringArray = bundle.getStringArray(FIELD_PREFERRED_VIDEO_MIMETYPES);
        String[] strArr = new String[0];
        if (stringArray == null) {
            stringArray = strArr;
        }
        builder.preferredVideoMimeTypes = ImmutableList.copyOf(stringArray);
        String[] stringArray2 = bundle.getStringArray(FIELD_PREFERRED_VIDEO_LABELS);
        String[] strArr2 = new String[0];
        if (stringArray2 == null) {
            stringArray2 = strArr2;
        }
        builder.preferredVideoLabels = ImmutableList.copyOf(stringArray2);
        String[] stringArray3 = bundle.getStringArray(FIELD_PREFERRED_VIDEO_LANGUAGES);
        String[] strArr3 = new String[0];
        if (stringArray3 == null) {
            stringArray3 = strArr3;
        }
        builder.preferredVideoLanguages = ImmutableList.copyOf(stringArray3);
        builder.preferredVideoRoleFlags = bundle.getInt(FIELD_PREFERRED_VIDEO_ROLE_FLAGS, trackSelectionParameters.preferredVideoRoleFlags);
        String[] stringArray4 = bundle.getStringArray(FIELD_PREFERRED_AUDIO_LANGUAGES);
        String[] strArr4 = new String[0];
        if (stringArray4 == null) {
            stringArray4 = strArr4;
        }
        builder.preferredAudioLanguages = Builder.normalizeLanguageCodes(stringArray4);
        String[] stringArray5 = bundle.getStringArray(FIELD_PREFERRED_AUDIO_LABELS);
        String[] strArr5 = new String[0];
        if (stringArray5 == null) {
            stringArray5 = strArr5;
        }
        builder.preferredAudioLabels = ImmutableList.copyOf(stringArray5);
        builder.preferredAudioRoleFlags = bundle.getInt(FIELD_PREFERRED_AUDIO_ROLE_FLAGS, trackSelectionParameters.preferredAudioRoleFlags);
        builder.maxAudioChannelCount = bundle.getInt(FIELD_MAX_AUDIO_CHANNEL_COUNT, trackSelectionParameters.maxAudioChannelCount);
        builder.maxAudioBitrate = bundle.getInt(FIELD_MAX_AUDIO_BITRATE, trackSelectionParameters.maxAudioBitrate);
        String[] stringArray6 = bundle.getStringArray(FIELD_PREFERRED_AUDIO_MIME_TYPES);
        String[] strArr6 = new String[0];
        if (stringArray6 == null) {
            stringArray6 = strArr6;
        }
        builder.preferredAudioMimeTypes = ImmutableList.copyOf(stringArray6);
        Bundle bundle2 = bundle.getBundle(FIELD_AUDIO_OFFLOAD_PREFERENCES);
        if (bundle2 != null) {
            AudioOffloadPreferences.Builder builder2 = new AudioOffloadPreferences.Builder();
            String str = AudioOffloadPreferences.FIELD_AUDIO_OFFLOAD_MODE_PREFERENCE;
            AudioOffloadPreferences audioOffloadPreferences2 = AudioOffloadPreferences.DEFAULT;
            builder2.audioOffloadMode = bundle2.getInt(str, audioOffloadPreferences2.audioOffloadMode);
            builder2.isGaplessSupportRequired = bundle2.getBoolean(AudioOffloadPreferences.FIELD_IS_GAPLESS_SUPPORT_REQUIRED, audioOffloadPreferences2.isGaplessSupportRequired);
            builder2.isSpeedChangeSupportRequired = bundle2.getBoolean(AudioOffloadPreferences.FIELD_IS_SPEED_CHANGE_SUPPORT_REQUIRED, audioOffloadPreferences2.isSpeedChangeSupportRequired);
            audioOffloadPreferences = new AudioOffloadPreferences(builder2);
        } else {
            AudioOffloadPreferences.Builder builder3 = new AudioOffloadPreferences.Builder();
            AudioOffloadPreferences audioOffloadPreferences3 = AudioOffloadPreferences.DEFAULT;
            builder3.audioOffloadMode = bundle.getInt(FIELD_AUDIO_OFFLOAD_MODE_PREFERENCE, audioOffloadPreferences3.audioOffloadMode);
            builder3.isGaplessSupportRequired = bundle.getBoolean(FIELD_IS_GAPLESS_SUPPORT_REQUIRED, audioOffloadPreferences3.isGaplessSupportRequired);
            builder3.isSpeedChangeSupportRequired = bundle.getBoolean(FIELD_IS_SPEED_CHANGE_SUPPORT_REQUIRED, audioOffloadPreferences3.isSpeedChangeSupportRequired);
            audioOffloadPreferences = new AudioOffloadPreferences(builder3);
        }
        builder.audioOffloadPreferences = audioOffloadPreferences;
        builder.selectTextByDefault = bundle.getBoolean(FIELD_SELECT_TEXT_BY_DEFAULT, trackSelectionParameters.selectTextByDefault);
        String[] stringArray7 = bundle.getStringArray(FIELD_PREFERRED_TEXT_LANGUAGES);
        String[] strArr7 = new String[0];
        if (stringArray7 == null) {
            stringArray7 = strArr7;
        }
        builder.preferredTextLanguages = Builder.normalizeLanguageCodes(stringArray7);
        builder.preferredTextRoleFlags = bundle.getInt(FIELD_PREFERRED_TEXT_ROLE_FLAGS, trackSelectionParameters.preferredTextRoleFlags);
        builder.usePreferredTextLanguagesAndRoleFlagsFromCaptioningManager = builder.preferredTextLanguages.isEmpty() && builder.preferredTextRoleFlags == 0 && bundle.getBoolean(FIELD_USE_PREFERRED_TEXT_LANGUAGES_AND_ROLE_FLAGS_FROM_CAPTIONING_MANAGER, trackSelectionParameters.usePreferredTextLanguagesAndRoleFlagsFromCaptioningManager);
        builder.ignoredTextSelectionFlags = bundle.getInt(FIELD_IGNORED_TEXT_SELECTION_FLAGS, trackSelectionParameters.ignoredTextSelectionFlags);
        String[] stringArray8 = bundle.getStringArray(FIELD_PREFERRED_TEXT_LABELS);
        String[] strArr8 = new String[0];
        if (stringArray8 == null) {
            stringArray8 = strArr8;
        }
        builder.preferredTextLabels = ImmutableList.copyOf(stringArray8);
        builder.selectUndeterminedTextLanguage = bundle.getBoolean(FIELD_SELECT_UNDETERMINED_TEXT_LANGUAGE, trackSelectionParameters.selectUndeterminedTextLanguage);
        builder.isPrioritizeImageOverVideoEnabled = bundle.getBoolean(FIELD_IS_PREFER_IMAGE_OVER_VIDEO_ENABLED, trackSelectionParameters.isPrioritizeImageOverVideoEnabled);
        builder.forceLowestBitrate = bundle.getBoolean(FIELD_FORCE_LOWEST_BITRATE, trackSelectionParameters.forceLowestBitrate);
        builder.forceHighestSupportedBitrate = bundle.getBoolean(FIELD_FORCE_HIGHEST_SUPPORTED_BITRATE, trackSelectionParameters.forceHighestSupportedBitrate);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(FIELD_SELECTION_OVERRIDES);
        if (parcelableArrayList == null) {
            regularImmutableListBuild = RegularImmutableList.EMPTY;
        } else {
            ImmutableList.Builder builder4 = ImmutableList.builder();
            for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
                Bundle bundle3 = (Bundle) parcelableArrayList.get(i2);
                bundle3.getClass();
                Bundle bundle4 = bundle3.getBundle(TrackSelectionOverride.FIELD_TRACK_GROUP);
                bundle4.getClass();
                TrackGroup trackGroupFromBundle = TrackGroup.fromBundle(bundle4);
                int[] intArray = bundle3.getIntArray(TrackSelectionOverride.FIELD_TRACKS);
                intArray.getClass();
                builder4.add((Object) new TrackSelectionOverride(trackGroupFromBundle, StringsKt__IndentKt.asList(intArray)));
            }
            regularImmutableListBuild = builder4.build();
        }
        builder.overrides = new HashMap();
        for (int i3 = 0; i3 < regularImmutableListBuild.size; i3++) {
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) regularImmutableListBuild.get(i3);
            builder.overrides.put(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
        }
        int[] intArray2 = bundle.getIntArray(FIELD_DISABLED_TRACK_TYPE);
        int[] iArr = new int[0];
        if (intArray2 == null) {
            intArray2 = iArr;
        }
        builder.disabledTrackTypes = new HashSet();
        for (int i4 : intArray2) {
            builder.disabledTrackTypes.add(Integer.valueOf(i4));
        }
        return new TrackSelectionParameters(builder);
    }

    public Builder buildUpon() {
        Builder builder = new Builder();
        builder.init(this);
        return builder;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        return this.maxVideoWidth == trackSelectionParameters.maxVideoWidth && this.maxVideoHeight == trackSelectionParameters.maxVideoHeight && this.maxVideoFrameRate == trackSelectionParameters.maxVideoFrameRate && this.maxVideoBitrate == trackSelectionParameters.maxVideoBitrate && this.minVideoWidth == trackSelectionParameters.minVideoWidth && this.minVideoHeight == trackSelectionParameters.minVideoHeight && this.minVideoFrameRate == trackSelectionParameters.minVideoFrameRate && this.minVideoBitrate == trackSelectionParameters.minVideoBitrate && this.viewportOrientationMayChange == trackSelectionParameters.viewportOrientationMayChange && this.viewportWidth == trackSelectionParameters.viewportWidth && this.viewportHeight == trackSelectionParameters.viewportHeight && this.isViewportSizeLimitedByPhysicalDisplaySize == trackSelectionParameters.isViewportSizeLimitedByPhysicalDisplaySize && this.preferredVideoMimeTypes.equals(trackSelectionParameters.preferredVideoMimeTypes) && this.preferredVideoLabels.equals(trackSelectionParameters.preferredVideoLabels) && this.preferredVideoLanguages.equals(trackSelectionParameters.preferredVideoLanguages) && this.preferredVideoRoleFlags == trackSelectionParameters.preferredVideoRoleFlags && this.preferredAudioLanguages.equals(trackSelectionParameters.preferredAudioLanguages) && this.preferredAudioRoleFlags == trackSelectionParameters.preferredAudioRoleFlags && this.maxAudioChannelCount == trackSelectionParameters.maxAudioChannelCount && this.preferredAudioLabels.equals(trackSelectionParameters.preferredAudioLabels) && this.maxAudioBitrate == trackSelectionParameters.maxAudioBitrate && this.preferredAudioMimeTypes.equals(trackSelectionParameters.preferredAudioMimeTypes) && this.audioOffloadPreferences.equals(trackSelectionParameters.audioOffloadPreferences) && this.selectTextByDefault == trackSelectionParameters.selectTextByDefault && this.preferredTextLabels.equals(trackSelectionParameters.preferredTextLabels) && this.preferredTextLanguages.equals(trackSelectionParameters.preferredTextLanguages) && this.preferredTextRoleFlags == trackSelectionParameters.preferredTextRoleFlags && this.usePreferredTextLanguagesAndRoleFlagsFromCaptioningManager == trackSelectionParameters.usePreferredTextLanguagesAndRoleFlagsFromCaptioningManager && this.ignoredTextSelectionFlags == trackSelectionParameters.ignoredTextSelectionFlags && this.selectUndeterminedTextLanguage == trackSelectionParameters.selectUndeterminedTextLanguage && this.isPrioritizeImageOverVideoEnabled == trackSelectionParameters.isPrioritizeImageOverVideoEnabled && this.forceLowestBitrate == trackSelectionParameters.forceLowestBitrate && this.forceHighestSupportedBitrate == trackSelectionParameters.forceHighestSupportedBitrate && Maps.equalsImpl(this.overrides, trackSelectionParameters.overrides) && this.disabledTrackTypes.equals(trackSelectionParameters.disabledTrackTypes);
    }

    public int hashCode() {
        return this.disabledTrackTypes.hashCode() + ((this.overrides.hashCode() + ((((((((((((this.preferredTextLabels.hashCode() + ((((((this.preferredTextLanguages.hashCode() + ((((this.audioOffloadPreferences.hashCode() + ((this.preferredAudioMimeTypes.hashCode() + ((((this.preferredAudioLabels.hashCode() + ((((((this.preferredAudioLanguages.hashCode() + ((((this.preferredVideoLanguages.hashCode() + ((this.preferredVideoLabels.hashCode() + ((this.preferredVideoMimeTypes.hashCode() + ((((((((((((((((((((((((this.maxVideoWidth + 31) * 31) + this.maxVideoHeight) * 31) + this.maxVideoFrameRate) * 31) + this.maxVideoBitrate) * 31) + this.minVideoWidth) * 31) + this.minVideoHeight) * 31) + this.minVideoFrameRate) * 31) + this.minVideoBitrate) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight) * 31) + (this.isViewportSizeLimitedByPhysicalDisplaySize ? 1 : 0)) * 31)) * 31)) * 31)) * 31) + this.preferredVideoRoleFlags) * 31)) * 31) + this.preferredAudioRoleFlags) * 31) + this.maxAudioChannelCount) * 31)) * 31) + this.maxAudioBitrate) * 31)) * 31)) * 31) + (this.selectTextByDefault ? 1 : 0)) * 31)) * 31) + this.preferredTextRoleFlags) * 31) + (this.usePreferredTextLanguagesAndRoleFlagsFromCaptioningManager ? 1 : 0)) * 31)) * 31) + this.ignoredTextSelectionFlags) * 31) + (this.selectUndeterminedTextLanguage ? 1 : 0)) * 31) + (this.isPrioritizeImageOverVideoEnabled ? 1 : 0)) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.forceHighestSupportedBitrate ? 1 : 0)) * 31)) * 31);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_MAX_VIDEO_WIDTH, this.maxVideoWidth);
        bundle.putInt(FIELD_MAX_VIDEO_HEIGHT, this.maxVideoHeight);
        bundle.putInt(FIELD_MAX_VIDEO_FRAMERATE, this.maxVideoFrameRate);
        bundle.putInt(FIELD_MAX_VIDEO_BITRATE, this.maxVideoBitrate);
        bundle.putInt(FIELD_MIN_VIDEO_WIDTH, this.minVideoWidth);
        bundle.putInt(FIELD_MIN_VIDEO_HEIGHT, this.minVideoHeight);
        bundle.putInt(FIELD_MIN_VIDEO_FRAMERATE, this.minVideoFrameRate);
        bundle.putInt(FIELD_MIN_VIDEO_BITRATE, this.minVideoBitrate);
        bundle.putInt(FIELD_VIEWPORT_WIDTH, this.viewportWidth);
        bundle.putInt(FIELD_VIEWPORT_HEIGHT, this.viewportHeight);
        bundle.putBoolean(FIELD_IS_VIEWPORT_SIZE_LIMITED_BY_PHYSICAL_DISPLAY_SIZE, this.isViewportSizeLimitedByPhysicalDisplaySize);
        bundle.putBoolean(FIELD_VIEWPORT_ORIENTATION_MAY_CHANGE, this.viewportOrientationMayChange);
        bundle.putStringArray(FIELD_PREFERRED_VIDEO_MIMETYPES, (String[]) this.preferredVideoMimeTypes.toArray(new String[0]));
        bundle.putStringArray(FIELD_PREFERRED_VIDEO_LANGUAGES, (String[]) this.preferredVideoLanguages.toArray(new String[0]));
        bundle.putStringArray(FIELD_PREFERRED_VIDEO_LABELS, (String[]) this.preferredVideoLabels.toArray(new String[0]));
        bundle.putInt(FIELD_PREFERRED_VIDEO_ROLE_FLAGS, this.preferredVideoRoleFlags);
        bundle.putStringArray(FIELD_PREFERRED_AUDIO_LANGUAGES, (String[]) this.preferredAudioLanguages.toArray(new String[0]));
        bundle.putInt(FIELD_PREFERRED_AUDIO_ROLE_FLAGS, this.preferredAudioRoleFlags);
        bundle.putInt(FIELD_MAX_AUDIO_CHANNEL_COUNT, this.maxAudioChannelCount);
        bundle.putInt(FIELD_MAX_AUDIO_BITRATE, this.maxAudioBitrate);
        bundle.putStringArray(FIELD_PREFERRED_AUDIO_LABELS, (String[]) this.preferredAudioLabels.toArray(new String[0]));
        bundle.putStringArray(FIELD_PREFERRED_AUDIO_MIME_TYPES, (String[]) this.preferredAudioMimeTypes.toArray(new String[0]));
        bundle.putBoolean(FIELD_SELECT_TEXT_BY_DEFAULT, this.selectTextByDefault);
        bundle.putStringArray(FIELD_PREFERRED_TEXT_LANGUAGES, (String[]) this.preferredTextLanguages.toArray(new String[0]));
        bundle.putInt(FIELD_PREFERRED_TEXT_ROLE_FLAGS, this.preferredTextRoleFlags);
        bundle.putBoolean(FIELD_USE_PREFERRED_TEXT_LANGUAGES_AND_ROLE_FLAGS_FROM_CAPTIONING_MANAGER, this.usePreferredTextLanguagesAndRoleFlagsFromCaptioningManager);
        bundle.putStringArray(FIELD_PREFERRED_TEXT_LABELS, (String[]) this.preferredTextLabels.toArray(new String[0]));
        bundle.putInt(FIELD_IGNORED_TEXT_SELECTION_FLAGS, this.ignoredTextSelectionFlags);
        bundle.putBoolean(FIELD_SELECT_UNDETERMINED_TEXT_LANGUAGE, this.selectUndeterminedTextLanguage);
        AudioOffloadPreferences audioOffloadPreferences = this.audioOffloadPreferences;
        bundle.putInt(FIELD_AUDIO_OFFLOAD_MODE_PREFERENCE, audioOffloadPreferences.audioOffloadMode);
        boolean z = audioOffloadPreferences.isGaplessSupportRequired;
        bundle.putBoolean(FIELD_IS_GAPLESS_SUPPORT_REQUIRED, z);
        boolean z2 = audioOffloadPreferences.isSpeedChangeSupportRequired;
        bundle.putBoolean(FIELD_IS_SPEED_CHANGE_SUPPORT_REQUIRED, z2);
        Bundle bundle2 = new Bundle();
        bundle2.putInt(AudioOffloadPreferences.FIELD_AUDIO_OFFLOAD_MODE_PREFERENCE, audioOffloadPreferences.audioOffloadMode);
        bundle2.putBoolean(AudioOffloadPreferences.FIELD_IS_GAPLESS_SUPPORT_REQUIRED, z);
        bundle2.putBoolean(AudioOffloadPreferences.FIELD_IS_SPEED_CHANGE_SUPPORT_REQUIRED, z2);
        bundle.putBundle(FIELD_AUDIO_OFFLOAD_PREFERENCES, bundle2);
        bundle.putBoolean(FIELD_IS_PREFER_IMAGE_OVER_VIDEO_ENABLED, this.isPrioritizeImageOverVideoEnabled);
        bundle.putBoolean(FIELD_FORCE_LOWEST_BITRATE, this.forceLowestBitrate);
        bundle.putBoolean(FIELD_FORCE_HIGHEST_SUPPORTED_BITRATE, this.forceHighestSupportedBitrate);
        ImmutableCollection<TrackSelectionOverride> immutableCollectionValues = this.overrides.values();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(immutableCollectionValues.size());
        for (TrackSelectionOverride trackSelectionOverride : immutableCollectionValues) {
            trackSelectionOverride.getClass();
            Bundle bundle3 = new Bundle();
            bundle3.putBundle(TrackSelectionOverride.FIELD_TRACK_GROUP, trackSelectionOverride.mediaTrackGroup.toBundle());
            bundle3.putIntArray(TrackSelectionOverride.FIELD_TRACKS, StringsKt__IndentKt.toArray(trackSelectionOverride.trackIndices));
            arrayList.add(bundle3);
        }
        bundle.putParcelableArrayList(FIELD_SELECTION_OVERRIDES, arrayList);
        bundle.putIntArray(FIELD_DISABLED_TRACK_TYPE, StringsKt__IndentKt.toArray(this.disabledTrackTypes));
        return bundle;
    }
}
