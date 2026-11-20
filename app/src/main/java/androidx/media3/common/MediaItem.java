package androidx.media3.common;

import android.net.Uri;
import android.os.Bundle;
import androidx.datastore.core.AtomicInt;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Util;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableMap;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaItem {
    public final ClippingProperties clippingConfiguration;
    public final LiveConfiguration liveConfiguration;
    public final LocalConfiguration localConfiguration;
    public final String mediaId;
    public final MediaMetadata mediaMetadata;
    public final RequestMetadata requestMetadata;
    public static final MediaItem EMPTY = new Builder().build();
    public static final String FIELD_MEDIA_ID = Integer.toString(0, 36);
    public static final String FIELD_LIVE_CONFIGURATION = Integer.toString(1, 36);
    public static final String FIELD_MEDIA_METADATA = Integer.toString(2, 36);
    public static final String FIELD_CLIPPING_PROPERTIES = Integer.toString(3, 36);
    public static final String FIELD_REQUEST_METADATA = Integer.toString(4, 36);
    public static final String FIELD_LOCAL_CONFIGURATION = Integer.toString(5, 36);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AdsConfiguration {
        public static final String FIELD_AD_TAG_URI;
        public final Uri adTagUri;

        static {
            String str = Util.DEVICE_DEBUG_INFO;
            FIELD_AD_TAG_URI = Integer.toString(0, 36);
        }

        public AdsConfiguration(AtomicInt atomicInt) {
            this.adTagUri = (Uri) atomicInt.delegate;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AdsConfiguration) && this.adTagUri.equals(((AdsConfiguration) obj).adTagUri);
        }

        public final int hashCode() {
            return this.adTagUri.hashCode() * 31;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder {
        public AdsConfiguration adsConfiguration;
        public String customCacheKey;
        public long imageDurationMs;
        public LiveConfiguration.Builder liveConfiguration;
        public String mediaId;
        public MediaMetadata mediaMetadata;
        public String mimeType;
        public RequestMetadata requestMetadata;
        public ImmutableList subtitleConfigurations;
        public Object tag;
        public Uri uri;
        public ClippingConfiguration.Builder clippingConfiguration = new ClippingConfiguration.Builder();
        public SavedStateRegistryImpl drmConfiguration = new SavedStateRegistryImpl();
        public List streamKeys = Collections.EMPTY_LIST;

        public Builder() {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            this.subtitleConfigurations = RegularImmutableList.EMPTY;
            this.liveConfiguration = new LiveConfiguration.Builder();
            this.requestMetadata = RequestMetadata.EMPTY;
            this.imageDurationMs = -9223372036854775807L;
        }

        public final MediaItem build() {
            LocalConfiguration localConfiguration;
            SavedStateRegistryImpl savedStateRegistryImpl = this.drmConfiguration;
            UtilsKt.checkState(((Uri) savedStateRegistryImpl.onAttach) == null || ((UUID) savedStateRegistryImpl.owner) != null);
            Uri uri = this.uri;
            DrmConfiguration drmConfiguration = null;
            if (uri != null) {
                String str = this.mimeType;
                SavedStateRegistryImpl savedStateRegistryImpl2 = this.drmConfiguration;
                if (((UUID) savedStateRegistryImpl2.owner) != null) {
                    savedStateRegistryImpl2.getClass();
                    drmConfiguration = new DrmConfiguration(savedStateRegistryImpl2);
                }
                localConfiguration = new LocalConfiguration(uri, str, drmConfiguration, this.adsConfiguration, this.streamKeys, this.customCacheKey, this.subtitleConfigurations, this.tag, this.imageDurationMs);
            } else {
                localConfiguration = null;
            }
            String str2 = this.mediaId;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            ClippingConfiguration.Builder builder = this.clippingConfiguration;
            builder.getClass();
            ClippingProperties clippingProperties = new ClippingProperties(builder);
            LiveConfiguration.Builder builder2 = this.liveConfiguration;
            builder2.getClass();
            LiveConfiguration liveConfiguration = new LiveConfiguration(builder2);
            MediaMetadata mediaMetadata = this.mediaMetadata;
            if (mediaMetadata == null) {
                mediaMetadata = MediaMetadata.EMPTY;
            }
            return new MediaItem(str3, clippingProperties, localConfiguration, liveConfiguration, mediaMetadata, this.requestMetadata);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class ClippingConfiguration {
        public final boolean allowUnseekableMedia;
        public final long endPositionMs;
        public final long endPositionUs;
        public final boolean relativeToDefaultPosition;
        public final boolean relativeToLiveWindow;
        public final long startPositionMs;
        public final long startPositionUs;
        public final boolean startsAtKeyFrame;
        public static final ClippingConfiguration UNSET = new ClippingConfiguration(new Builder());
        public static final String FIELD_START_POSITION_MS = Integer.toString(0, 36);
        public static final String FIELD_END_POSITION_MS = Integer.toString(1, 36);
        public static final String FIELD_RELATIVE_TO_LIVE_WINDOW = Integer.toString(2, 36);
        public static final String FIELD_RELATIVE_TO_DEFAULT_POSITION = Integer.toString(3, 36);
        public static final String FIELD_STARTS_AT_KEY_FRAME = Integer.toString(4, 36);
        public static final String FIELD_START_POSITION_US = Integer.toString(5, 36);
        public static final String FIELD_END_POSITION_US = Integer.toString(6, 36);
        public static final String FIELD_ALLOW_UNSEEKABLE_MEDIA = Integer.toString(7, 36);

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Builder {
            public boolean allowUnseekableMedia;
            public long endPositionUs = Long.MIN_VALUE;
            public boolean relativeToDefaultPosition;
            public boolean relativeToLiveWindow;
            public long startPositionUs;
            public boolean startsAtKeyFrame;
        }

        public ClippingConfiguration(Builder builder) {
            this.startPositionMs = Util.usToMs(builder.startPositionUs);
            this.endPositionMs = Util.usToMs(builder.endPositionUs);
            this.startPositionUs = builder.startPositionUs;
            this.endPositionUs = builder.endPositionUs;
            this.relativeToLiveWindow = builder.relativeToLiveWindow;
            this.relativeToDefaultPosition = builder.relativeToDefaultPosition;
            this.startsAtKeyFrame = builder.startsAtKeyFrame;
            this.allowUnseekableMedia = builder.allowUnseekableMedia;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClippingConfiguration)) {
                return false;
            }
            ClippingConfiguration clippingConfiguration = (ClippingConfiguration) obj;
            return this.startPositionUs == clippingConfiguration.startPositionUs && this.endPositionUs == clippingConfiguration.endPositionUs && this.relativeToLiveWindow == clippingConfiguration.relativeToLiveWindow && this.relativeToDefaultPosition == clippingConfiguration.relativeToDefaultPosition && this.startsAtKeyFrame == clippingConfiguration.startsAtKeyFrame && this.allowUnseekableMedia == clippingConfiguration.allowUnseekableMedia;
        }

        public final int hashCode() {
            long j = this.startPositionUs;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            long j2 = this.endPositionUs;
            return ((((((((i + ((int) ((j2 >>> 32) ^ j2))) * 31) + (this.relativeToLiveWindow ? 1 : 0)) * 31) + (this.relativeToDefaultPosition ? 1 : 0)) * 31) + (this.startsAtKeyFrame ? 1 : 0)) * 31) + (this.allowUnseekableMedia ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ClippingProperties extends ClippingConfiguration {
        public static final ClippingProperties UNSET = new ClippingProperties(new ClippingConfiguration.Builder());
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DrmConfiguration {
        public static final String FIELD_FORCED_SESSION_TRACK_TYPES;
        public static final String FIELD_FORCE_DEFAULT_LICENSE_URI;
        public static final String FIELD_KEY_SET_ID;
        public static final String FIELD_LICENSE_REQUEST_HEADERS;
        public static final String FIELD_LICENSE_URI;
        public static final String FIELD_MULTI_SESSION;
        public static final String FIELD_PLAY_CLEAR_CONTENT_WITHOUT_KEY;
        public static final String FIELD_SCHEME;
        public final boolean forceDefaultLicenseUri;
        public final ImmutableList forcedSessionTrackTypes;
        public final byte[] keySetId;
        public final ImmutableMap licenseRequestHeaders;
        public final Uri licenseUri;
        public final boolean multiSession;
        public final boolean playClearContentWithoutKey;
        public final UUID scheme;

        static {
            String str = Util.DEVICE_DEBUG_INFO;
            FIELD_SCHEME = Integer.toString(0, 36);
            FIELD_LICENSE_URI = Integer.toString(1, 36);
            FIELD_LICENSE_REQUEST_HEADERS = Integer.toString(2, 36);
            FIELD_MULTI_SESSION = Integer.toString(3, 36);
            FIELD_PLAY_CLEAR_CONTENT_WITHOUT_KEY = Integer.toString(4, 36);
            FIELD_FORCE_DEFAULT_LICENSE_URI = Integer.toString(5, 36);
            FIELD_FORCED_SESSION_TRACK_TYPES = Integer.toString(6, 36);
            FIELD_KEY_SET_ID = Integer.toString(7, 36);
        }

        public DrmConfiguration(SavedStateRegistryImpl savedStateRegistryImpl) {
            UtilsKt.checkState((savedStateRegistryImpl.isAllowingSavingState && ((Uri) savedStateRegistryImpl.onAttach) == null) ? false : true);
            UUID uuid = (UUID) savedStateRegistryImpl.owner;
            uuid.getClass();
            this.scheme = uuid;
            this.licenseUri = (Uri) savedStateRegistryImpl.onAttach;
            this.licenseRequestHeaders = (ImmutableMap) savedStateRegistryImpl.lock;
            this.multiSession = savedStateRegistryImpl.attached;
            this.forceDefaultLicenseUri = savedStateRegistryImpl.isAllowingSavingState;
            this.playClearContentWithoutKey = savedStateRegistryImpl.isRestored;
            this.forcedSessionTrackTypes = (ImmutableList) savedStateRegistryImpl.keyToProviders;
            byte[] bArr = (byte[]) savedStateRegistryImpl.restoredState;
            this.keySetId = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrmConfiguration)) {
                return false;
            }
            DrmConfiguration drmConfiguration = (DrmConfiguration) obj;
            return this.scheme.equals(drmConfiguration.scheme) && Objects.equals(this.licenseUri, drmConfiguration.licenseUri) && Objects.equals(this.licenseRequestHeaders, drmConfiguration.licenseRequestHeaders) && this.multiSession == drmConfiguration.multiSession && this.forceDefaultLicenseUri == drmConfiguration.forceDefaultLicenseUri && this.playClearContentWithoutKey == drmConfiguration.playClearContentWithoutKey && this.forcedSessionTrackTypes.equals(drmConfiguration.forcedSessionTrackTypes) && Arrays.equals(this.keySetId, drmConfiguration.keySetId);
        }

        public final int hashCode() {
            int iHashCode = this.scheme.hashCode() * 31;
            Uri uri = this.licenseUri;
            return Arrays.hashCode(this.keySetId) + ((this.forcedSessionTrackTypes.hashCode() + ((((((((this.licenseRequestHeaders.hashCode() + ((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31)) * 31) + (this.multiSession ? 1 : 0)) * 31) + (this.forceDefaultLicenseUri ? 1 : 0)) * 31) + (this.playClearContentWithoutKey ? 1 : 0)) * 31)) * 31);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LiveConfiguration {
        public static final String FIELD_MAX_OFFSET_MS;
        public static final String FIELD_MAX_PLAYBACK_SPEED;
        public static final String FIELD_MIN_OFFSET_MS;
        public static final String FIELD_MIN_PLAYBACK_SPEED;
        public static final String FIELD_TARGET_OFFSET_MS;
        public static final LiveConfiguration UNSET = new LiveConfiguration(new Builder());
        public final long maxOffsetMs;
        public final float maxPlaybackSpeed;
        public final long minOffsetMs;
        public final float minPlaybackSpeed;
        public final long targetOffsetMs;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Builder {
            public long targetOffsetMs = -9223372036854775807L;
            public long minOffsetMs = -9223372036854775807L;
            public long maxOffsetMs = -9223372036854775807L;
            public float minPlaybackSpeed = -3.4028235E38f;
            public float maxPlaybackSpeed = -3.4028235E38f;
        }

        static {
            String str = Util.DEVICE_DEBUG_INFO;
            FIELD_TARGET_OFFSET_MS = Integer.toString(0, 36);
            FIELD_MIN_OFFSET_MS = Integer.toString(1, 36);
            FIELD_MAX_OFFSET_MS = Integer.toString(2, 36);
            FIELD_MIN_PLAYBACK_SPEED = Integer.toString(3, 36);
            FIELD_MAX_PLAYBACK_SPEED = Integer.toString(4, 36);
        }

        public LiveConfiguration(Builder builder) {
            long j = builder.targetOffsetMs;
            long j2 = builder.minOffsetMs;
            long j3 = builder.maxOffsetMs;
            float f = builder.minPlaybackSpeed;
            float f2 = builder.maxPlaybackSpeed;
            this.targetOffsetMs = j;
            this.minOffsetMs = j2;
            this.maxOffsetMs = j3;
            this.minPlaybackSpeed = f;
            this.maxPlaybackSpeed = f2;
        }

        public static LiveConfiguration fromBundle(Bundle bundle) {
            Builder builder = new Builder();
            LiveConfiguration liveConfiguration = UNSET;
            builder.targetOffsetMs = bundle.getLong(FIELD_TARGET_OFFSET_MS, liveConfiguration.targetOffsetMs);
            builder.minOffsetMs = bundle.getLong(FIELD_MIN_OFFSET_MS, liveConfiguration.minOffsetMs);
            builder.maxOffsetMs = bundle.getLong(FIELD_MAX_OFFSET_MS, liveConfiguration.maxOffsetMs);
            builder.minPlaybackSpeed = bundle.getFloat(FIELD_MIN_PLAYBACK_SPEED, liveConfiguration.minPlaybackSpeed);
            builder.maxPlaybackSpeed = bundle.getFloat(FIELD_MAX_PLAYBACK_SPEED, liveConfiguration.maxPlaybackSpeed);
            return new LiveConfiguration(builder);
        }

        public final Builder buildUpon() {
            Builder builder = new Builder();
            builder.targetOffsetMs = this.targetOffsetMs;
            builder.minOffsetMs = this.minOffsetMs;
            builder.maxOffsetMs = this.maxOffsetMs;
            builder.minPlaybackSpeed = this.minPlaybackSpeed;
            builder.maxPlaybackSpeed = this.maxPlaybackSpeed;
            return builder;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LiveConfiguration)) {
                return false;
            }
            LiveConfiguration liveConfiguration = (LiveConfiguration) obj;
            return this.targetOffsetMs == liveConfiguration.targetOffsetMs && this.minOffsetMs == liveConfiguration.minOffsetMs && this.maxOffsetMs == liveConfiguration.maxOffsetMs && this.minPlaybackSpeed == liveConfiguration.minPlaybackSpeed && this.maxPlaybackSpeed == liveConfiguration.maxPlaybackSpeed;
        }

        public final int hashCode() {
            long j = this.targetOffsetMs;
            long j2 = this.minOffsetMs;
            int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.maxOffsetMs;
            int i2 = (i + ((int) ((j3 >>> 32) ^ j3))) * 31;
            float f = this.minPlaybackSpeed;
            int iFloatToIntBits = (i2 + (f != CropImageView.DEFAULT_ASPECT_RATIO ? Float.floatToIntBits(f) : 0)) * 31;
            float f2 = this.maxPlaybackSpeed;
            return iFloatToIntBits + (f2 != CropImageView.DEFAULT_ASPECT_RATIO ? Float.floatToIntBits(f2) : 0);
        }

        public final Bundle toBundle() {
            Bundle bundle = new Bundle();
            LiveConfiguration liveConfiguration = UNSET;
            long j = liveConfiguration.targetOffsetMs;
            long j2 = this.targetOffsetMs;
            if (j2 != j) {
                bundle.putLong(FIELD_TARGET_OFFSET_MS, j2);
            }
            long j3 = liveConfiguration.minOffsetMs;
            long j4 = this.minOffsetMs;
            if (j4 != j3) {
                bundle.putLong(FIELD_MIN_OFFSET_MS, j4);
            }
            long j5 = liveConfiguration.maxOffsetMs;
            long j6 = this.maxOffsetMs;
            if (j6 != j5) {
                bundle.putLong(FIELD_MAX_OFFSET_MS, j6);
            }
            float f = liveConfiguration.minPlaybackSpeed;
            float f2 = this.minPlaybackSpeed;
            if (f2 != f) {
                bundle.putFloat(FIELD_MIN_PLAYBACK_SPEED, f2);
            }
            float f3 = liveConfiguration.maxPlaybackSpeed;
            float f4 = this.maxPlaybackSpeed;
            if (f4 != f3) {
                bundle.putFloat(FIELD_MAX_PLAYBACK_SPEED, f4);
            }
            return bundle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LocalConfiguration {
        public static final String FIELD_ADS_CONFIGURATION;
        public static final String FIELD_CUSTOM_CACHE_KEY;
        public static final String FIELD_DRM_CONFIGURATION;
        public static final String FIELD_IMAGE_DURATION_MS;
        public static final String FIELD_MIME_TYPE;
        public static final String FIELD_STREAM_KEYS;
        public static final String FIELD_SUBTITLE_CONFIGURATION;
        public static final String FIELD_URI;
        public final AdsConfiguration adsConfiguration;
        public final String customCacheKey;
        public final DrmConfiguration drmConfiguration;
        public final long imageDurationMs;
        public final String mimeType;
        public final List streamKeys;
        public final ImmutableList subtitleConfigurations;
        public final Object tag;
        public final Uri uri;

        static {
            String str = Util.DEVICE_DEBUG_INFO;
            FIELD_URI = Integer.toString(0, 36);
            FIELD_MIME_TYPE = Integer.toString(1, 36);
            FIELD_DRM_CONFIGURATION = Integer.toString(2, 36);
            FIELD_ADS_CONFIGURATION = Integer.toString(3, 36);
            FIELD_STREAM_KEYS = Integer.toString(4, 36);
            FIELD_CUSTOM_CACHE_KEY = Integer.toString(5, 36);
            FIELD_SUBTITLE_CONFIGURATION = Integer.toString(6, 36);
            FIELD_IMAGE_DURATION_MS = Integer.toString(7, 36);
        }

        public LocalConfiguration(Uri uri, String str, DrmConfiguration drmConfiguration, AdsConfiguration adsConfiguration, List list, String str2, ImmutableList immutableList, Object obj, long j) {
            this.uri = uri;
            this.mimeType = MimeTypes.normalizeMimeType(str);
            this.drmConfiguration = drmConfiguration;
            this.adsConfiguration = adsConfiguration;
            this.streamKeys = list;
            this.customCacheKey = str2;
            this.subtitleConfigurations = immutableList;
            ImmutableList.Builder builder = ImmutableList.builder();
            for (int i = 0; i < immutableList.size(); i++) {
                SubtitleConfiguration subtitleConfiguration = (SubtitleConfiguration) immutableList.get(i);
                SubtitleConfiguration.Builder builder2 = new SubtitleConfiguration.Builder();
                builder2.uri = subtitleConfiguration.uri;
                builder2.mimeType = subtitleConfiguration.mimeType;
                builder2.language = subtitleConfiguration.language;
                builder2.selectionFlags = subtitleConfiguration.selectionFlags;
                builder2.roleFlags = subtitleConfiguration.roleFlags;
                builder2.label = subtitleConfiguration.label;
                builder2.id = subtitleConfiguration.id;
                builder.add((Object) new Subtitle(builder2));
            }
            builder.build();
            this.tag = obj;
            this.imageDurationMs = j;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocalConfiguration)) {
                return false;
            }
            LocalConfiguration localConfiguration = (LocalConfiguration) obj;
            return this.uri.equals(localConfiguration.uri) && Objects.equals(this.mimeType, localConfiguration.mimeType) && Objects.equals(this.drmConfiguration, localConfiguration.drmConfiguration) && Objects.equals(this.adsConfiguration, localConfiguration.adsConfiguration) && this.streamKeys.equals(localConfiguration.streamKeys) && Objects.equals(this.customCacheKey, localConfiguration.customCacheKey) && this.subtitleConfigurations.equals(localConfiguration.subtitleConfigurations) && Objects.equals(this.tag, localConfiguration.tag) && this.imageDurationMs == localConfiguration.imageDurationMs;
        }

        public final int hashCode() {
            int iHashCode = this.uri.hashCode() * 31;
            String str = this.mimeType;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            DrmConfiguration drmConfiguration = this.drmConfiguration;
            int iHashCode3 = (iHashCode2 + (drmConfiguration == null ? 0 : drmConfiguration.hashCode())) * 31;
            AdsConfiguration adsConfiguration = this.adsConfiguration;
            int iHashCode4 = (this.streamKeys.hashCode() + ((iHashCode3 + (adsConfiguration == null ? 0 : adsConfiguration.hashCode())) * 31)) * 31;
            String str2 = this.customCacheKey;
            int iHashCode5 = (this.subtitleConfigurations.hashCode() + ((iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31;
            Object obj = this.tag;
            return (int) ((((long) (iHashCode5 + (obj != null ? obj.hashCode() : 0))) * 31) + this.imageDurationMs);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RequestMetadata {
        public static final RequestMetadata EMPTY = new RequestMetadata(new EmojiProcessor((byte) 20));
        public static final String FIELD_EXTRAS;
        public static final String FIELD_MEDIA_URI;
        public static final String FIELD_SEARCH_QUERY;
        public final Bundle extras;
        public final Uri mediaUri;
        public final String searchQuery;

        static {
            String str = Util.DEVICE_DEBUG_INFO;
            FIELD_MEDIA_URI = Integer.toString(0, 36);
            FIELD_SEARCH_QUERY = Integer.toString(1, 36);
            FIELD_EXTRAS = Integer.toString(2, 36);
        }

        public RequestMetadata(EmojiProcessor emojiProcessor) {
            this.mediaUri = (Uri) emojiProcessor.mSpanFactory;
            this.searchQuery = (String) emojiProcessor.mMetadataRepo;
            this.extras = (Bundle) emojiProcessor.mGlyphChecker;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestMetadata)) {
                return false;
            }
            RequestMetadata requestMetadata = (RequestMetadata) obj;
            if (Objects.equals(this.mediaUri, requestMetadata.mediaUri) && Objects.equals(this.searchQuery, requestMetadata.searchQuery)) {
                if ((this.extras == null) == (requestMetadata.extras == null)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Uri uri = this.mediaUri;
            int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.searchQuery;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + (this.extras != null ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Subtitle extends SubtitleConfiguration {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class SubtitleConfiguration {
        public static final String FIELD_ID;
        public static final String FIELD_LABEL;
        public static final String FIELD_LANGUAGE;
        public static final String FIELD_MIME_TYPE;
        public static final String FIELD_ROLE_FLAGS;
        public static final String FIELD_SELECTION_FLAGS;
        public static final String FIELD_URI;
        public final String id;
        public final String label;
        public final String language;
        public final String mimeType;
        public final int roleFlags;
        public final int selectionFlags;
        public final Uri uri;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Builder {
            public String id;
            public String label;
            public String language;
            public String mimeType;
            public int roleFlags;
            public int selectionFlags;
            public Uri uri;
        }

        static {
            String str = Util.DEVICE_DEBUG_INFO;
            FIELD_URI = Integer.toString(0, 36);
            FIELD_MIME_TYPE = Integer.toString(1, 36);
            FIELD_LANGUAGE = Integer.toString(2, 36);
            FIELD_SELECTION_FLAGS = Integer.toString(3, 36);
            FIELD_ROLE_FLAGS = Integer.toString(4, 36);
            FIELD_LABEL = Integer.toString(5, 36);
            FIELD_ID = Integer.toString(6, 36);
        }

        public SubtitleConfiguration(Builder builder) {
            this.uri = builder.uri;
            this.mimeType = builder.mimeType;
            this.language = builder.language;
            this.selectionFlags = builder.selectionFlags;
            this.roleFlags = builder.roleFlags;
            this.label = builder.label;
            this.id = builder.id;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubtitleConfiguration)) {
                return false;
            }
            SubtitleConfiguration subtitleConfiguration = (SubtitleConfiguration) obj;
            return this.uri.equals(subtitleConfiguration.uri) && Objects.equals(this.mimeType, subtitleConfiguration.mimeType) && Objects.equals(this.language, subtitleConfiguration.language) && this.selectionFlags == subtitleConfiguration.selectionFlags && this.roleFlags == subtitleConfiguration.roleFlags && Objects.equals(this.label, subtitleConfiguration.label) && Objects.equals(this.id, subtitleConfiguration.id);
        }

        public final int hashCode() {
            int iHashCode = this.uri.hashCode() * 31;
            String str = this.mimeType;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.language;
            int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31;
            String str3 = this.label;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.id;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }
    }

    public MediaItem(String str, ClippingProperties clippingProperties, LocalConfiguration localConfiguration, LiveConfiguration liveConfiguration, MediaMetadata mediaMetadata, RequestMetadata requestMetadata) {
        this.mediaId = str;
        this.localConfiguration = localConfiguration;
        this.liveConfiguration = liveConfiguration;
        this.mediaMetadata = mediaMetadata;
        this.clippingConfiguration = clippingProperties;
        this.requestMetadata = requestMetadata;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26, types: [java.lang.Cloneable] */
    /* JADX WARN: Type inference failed for: r1v59 */
    public static MediaItem fromBundle(int i, Bundle bundle) {
        ClippingProperties clippingProperties;
        RequestMetadata requestMetadata;
        Map mapCopyOf;
        DrmConfiguration drmConfiguration;
        AdsConfiguration adsConfiguration;
        RegularImmutableList regularImmutableListBuild;
        RegularImmutableList regularImmutableListFromBundleList;
        LocalConfiguration localConfiguration;
        String string = bundle.getString(FIELD_MEDIA_ID, "");
        string.getClass();
        Bundle bundle2 = bundle.getBundle(FIELD_LIVE_CONFIGURATION);
        LiveConfiguration liveConfigurationFromBundle = bundle2 == null ? LiveConfiguration.UNSET : LiveConfiguration.fromBundle(bundle2);
        Bundle bundle3 = bundle.getBundle(FIELD_MEDIA_METADATA);
        MediaMetadata mediaMetadataFromBundle = bundle3 == null ? MediaMetadata.EMPTY : MediaMetadata.fromBundle(i, bundle3);
        Bundle bundle4 = bundle.getBundle(FIELD_CLIPPING_PROPERTIES);
        if (bundle4 == null) {
            clippingProperties = ClippingProperties.UNSET;
        } else {
            ClippingConfiguration.Builder builder = new ClippingConfiguration.Builder();
            String str = ClippingConfiguration.FIELD_START_POSITION_MS;
            ClippingConfiguration clippingConfiguration = ClippingConfiguration.UNSET;
            long j = clippingConfiguration.startPositionMs;
            long j2 = clippingConfiguration.endPositionUs;
            long j3 = clippingConfiguration.startPositionUs;
            long jMsToUs = Util.msToUs(bundle4.getLong(str, j));
            boolean z = true;
            UtilsKt.checkArgument(jMsToUs >= 0);
            builder.startPositionUs = jMsToUs;
            long jMsToUs2 = Util.msToUs(bundle4.getLong(ClippingConfiguration.FIELD_END_POSITION_MS, clippingConfiguration.endPositionMs));
            UtilsKt.checkArgument(jMsToUs2 == Long.MIN_VALUE || jMsToUs2 >= 0);
            builder.endPositionUs = jMsToUs2;
            builder.relativeToLiveWindow = bundle4.getBoolean(ClippingConfiguration.FIELD_RELATIVE_TO_LIVE_WINDOW, clippingConfiguration.relativeToLiveWindow);
            builder.relativeToDefaultPosition = bundle4.getBoolean(ClippingConfiguration.FIELD_RELATIVE_TO_DEFAULT_POSITION, clippingConfiguration.relativeToDefaultPosition);
            builder.startsAtKeyFrame = bundle4.getBoolean(ClippingConfiguration.FIELD_STARTS_AT_KEY_FRAME, clippingConfiguration.startsAtKeyFrame);
            builder.allowUnseekableMedia = bundle4.getBoolean(ClippingConfiguration.FIELD_ALLOW_UNSEEKABLE_MEDIA, clippingConfiguration.allowUnseekableMedia);
            long j4 = bundle4.getLong(ClippingConfiguration.FIELD_START_POSITION_US, j3);
            if (j4 != j3) {
                UtilsKt.checkArgument(j4 >= 0);
                builder.startPositionUs = j4;
            }
            long j5 = bundle4.getLong(ClippingConfiguration.FIELD_END_POSITION_US, j2);
            if (j5 != j2) {
                if (j5 != Long.MIN_VALUE && j5 < 0) {
                    z = false;
                }
                UtilsKt.checkArgument(z);
                builder.endPositionUs = j5;
            }
            clippingProperties = new ClippingProperties(builder);
        }
        ClippingProperties clippingProperties2 = clippingProperties;
        Bundle bundle5 = bundle.getBundle(FIELD_REQUEST_METADATA);
        if (bundle5 == null) {
            requestMetadata = RequestMetadata.EMPTY;
        } else {
            EmojiProcessor emojiProcessor = new EmojiProcessor((byte) 20);
            emojiProcessor.mSpanFactory = (Uri) bundle5.getParcelable(RequestMetadata.FIELD_MEDIA_URI);
            emojiProcessor.mMetadataRepo = bundle5.getString(RequestMetadata.FIELD_SEARCH_QUERY);
            emojiProcessor.mGlyphChecker = Util.convertToNullIfInvalid(bundle5.getBundle(RequestMetadata.FIELD_EXTRAS));
            requestMetadata = new RequestMetadata(emojiProcessor);
        }
        RequestMetadata requestMetadata2 = requestMetadata;
        Bundle bundle6 = bundle.getBundle(FIELD_LOCAL_CONFIGURATION);
        if (bundle6 == null) {
            localConfiguration = null;
        } else {
            Bundle bundle7 = bundle6.getBundle(LocalConfiguration.FIELD_DRM_CONFIGURATION);
            if (bundle7 == null) {
                drmConfiguration = null;
            } else {
                String string2 = bundle7.getString(DrmConfiguration.FIELD_SCHEME);
                string2.getClass();
                UUID uuidFromString = UUID.fromString(string2);
                Uri uri = (Uri) bundle7.getParcelable(DrmConfiguration.FIELD_LICENSE_URI);
                String str2 = DrmConfiguration.FIELD_LICENSE_REQUEST_HEADERS;
                Bundle bundle8 = Bundle.EMPTY;
                Bundle bundle9 = bundle7.getBundle(str2);
                if (bundle9 == null) {
                    bundle9 = bundle8;
                }
                if (bundle9 == bundle8) {
                    mapCopyOf = RegularImmutableMap.EMPTY;
                } else {
                    HashMap map = new HashMap();
                    if (bundle9 != bundle8) {
                        for (String str3 : bundle9.keySet()) {
                            String string3 = bundle9.getString(str3);
                            if (string3 != null) {
                                map.put(str3, string3);
                            }
                        }
                    }
                    mapCopyOf = ImmutableMap.copyOf((Map) map);
                }
                boolean z2 = bundle7.getBoolean(DrmConfiguration.FIELD_MULTI_SESSION, false);
                boolean z3 = bundle7.getBoolean(DrmConfiguration.FIELD_PLAY_CLEAR_CONTENT_WITHOUT_KEY, false);
                boolean z4 = bundle7.getBoolean(DrmConfiguration.FIELD_FORCE_DEFAULT_LICENSE_URI, false);
                String str4 = DrmConfiguration.FIELD_FORCED_SESSION_TRACK_TYPES;
                ArrayList<Integer> arrayList = new ArrayList<>();
                ArrayList<Integer> integerArrayList = bundle7.getIntegerArrayList(str4);
                if (integerArrayList != null) {
                    arrayList = integerArrayList;
                }
                ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) arrayList);
                byte[] byteArray = bundle7.getByteArray(DrmConfiguration.FIELD_KEY_SET_ID);
                SavedStateRegistryImpl savedStateRegistryImpl = new SavedStateRegistryImpl();
                savedStateRegistryImpl.owner = uuidFromString;
                savedStateRegistryImpl.onAttach = uri;
                savedStateRegistryImpl.lock = ImmutableMap.copyOf(mapCopyOf);
                savedStateRegistryImpl.attached = z2;
                savedStateRegistryImpl.isAllowingSavingState = z4;
                savedStateRegistryImpl.isRestored = z3;
                savedStateRegistryImpl.keyToProviders = ImmutableList.copyOf((Collection) immutableListCopyOf);
                savedStateRegistryImpl.restoredState = byteArray != null ? Arrays.copyOf(byteArray, byteArray.length) : 0;
                drmConfiguration = new DrmConfiguration(savedStateRegistryImpl);
            }
            Bundle bundle10 = bundle6.getBundle(LocalConfiguration.FIELD_ADS_CONFIGURATION);
            if (bundle10 == null) {
                adsConfiguration = null;
            } else {
                Uri uri2 = (Uri) bundle10.getParcelable(AdsConfiguration.FIELD_AD_TAG_URI);
                uri2.getClass();
                AtomicInt atomicInt = new AtomicInt();
                atomicInt.delegate = uri2;
                adsConfiguration = new AdsConfiguration(atomicInt);
            }
            ArrayList parcelableArrayList = bundle6.getParcelableArrayList(LocalConfiguration.FIELD_STREAM_KEYS);
            if (parcelableArrayList == null) {
                ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
                regularImmutableListBuild = RegularImmutableList.EMPTY;
            } else {
                ImmutableList.Builder builder2 = ImmutableList.builder();
                int i2 = 0;
                while (i2 < parcelableArrayList.size()) {
                    Bundle bundle11 = (Bundle) parcelableArrayList.get(i2);
                    bundle11.getClass();
                    builder2.add((Object) new StreamKey(bundle11.getInt(StreamKey.FIELD_PERIOD_INDEX, 0), bundle11.getInt(StreamKey.FIELD_GROUP_INDEX, 0), bundle11.getInt(StreamKey.FIELD_STREAM_INDEX, 0)));
                    i2++;
                    parcelableArrayList = parcelableArrayList;
                }
                regularImmutableListBuild = builder2.build();
            }
            RegularImmutableList regularImmutableList = regularImmutableListBuild;
            ArrayList parcelableArrayList2 = bundle6.getParcelableArrayList(LocalConfiguration.FIELD_SUBTITLE_CONFIGURATION);
            if (parcelableArrayList2 == null) {
                ImmutableList.Itr itr2 = ImmutableList.EMPTY_ITR;
                regularImmutableListFromBundleList = RegularImmutableList.EMPTY;
            } else {
                regularImmutableListFromBundleList = GlUtil.fromBundleList(new Format$$ExternalSyntheticLambda1((byte) 3), parcelableArrayList2);
            }
            RegularImmutableList regularImmutableList2 = regularImmutableListFromBundleList;
            long j6 = bundle6.getLong(LocalConfiguration.FIELD_IMAGE_DURATION_MS, -9223372036854775807L);
            Uri uri3 = (Uri) bundle6.getParcelable(LocalConfiguration.FIELD_URI);
            uri3.getClass();
            localConfiguration = new LocalConfiguration(uri3, bundle6.getString(LocalConfiguration.FIELD_MIME_TYPE), drmConfiguration, adsConfiguration, regularImmutableList, bundle6.getString(LocalConfiguration.FIELD_CUSTOM_CACHE_KEY), regularImmutableList2, null, j6);
        }
        return new MediaItem(string, clippingProperties2, localConfiguration, liveConfigurationFromBundle, mediaMetadataFromBundle, requestMetadata2);
    }

    /* JADX WARN: Type inference failed for: r1v15, types: [byte[], java.lang.Cloneable] */
    public final Builder buildUpon() {
        SavedStateRegistryImpl savedStateRegistryImpl;
        Builder builder = new Builder();
        ClippingConfiguration.Builder builder2 = new ClippingConfiguration.Builder();
        ClippingProperties clippingProperties = this.clippingConfiguration;
        builder2.startPositionUs = clippingProperties.startPositionUs;
        builder2.endPositionUs = clippingProperties.endPositionUs;
        builder2.relativeToLiveWindow = clippingProperties.relativeToLiveWindow;
        builder2.relativeToDefaultPosition = clippingProperties.relativeToDefaultPosition;
        builder2.startsAtKeyFrame = clippingProperties.startsAtKeyFrame;
        builder2.allowUnseekableMedia = clippingProperties.allowUnseekableMedia;
        builder.clippingConfiguration = builder2;
        builder.mediaId = this.mediaId;
        builder.mediaMetadata = this.mediaMetadata;
        builder.liveConfiguration = this.liveConfiguration.buildUpon();
        builder.requestMetadata = this.requestMetadata;
        LocalConfiguration localConfiguration = this.localConfiguration;
        if (localConfiguration != null) {
            builder.customCacheKey = localConfiguration.customCacheKey;
            builder.mimeType = localConfiguration.mimeType;
            builder.uri = localConfiguration.uri;
            builder.streamKeys = localConfiguration.streamKeys;
            builder.subtitleConfigurations = localConfiguration.subtitleConfigurations;
            builder.tag = localConfiguration.tag;
            DrmConfiguration drmConfiguration = localConfiguration.drmConfiguration;
            if (drmConfiguration != null) {
                savedStateRegistryImpl = new SavedStateRegistryImpl();
                savedStateRegistryImpl.owner = drmConfiguration.scheme;
                savedStateRegistryImpl.onAttach = drmConfiguration.licenseUri;
                savedStateRegistryImpl.lock = drmConfiguration.licenseRequestHeaders;
                savedStateRegistryImpl.attached = drmConfiguration.multiSession;
                savedStateRegistryImpl.isRestored = drmConfiguration.playClearContentWithoutKey;
                savedStateRegistryImpl.isAllowingSavingState = drmConfiguration.forceDefaultLicenseUri;
                savedStateRegistryImpl.keyToProviders = drmConfiguration.forcedSessionTrackTypes;
                savedStateRegistryImpl.restoredState = drmConfiguration.keySetId;
            } else {
                savedStateRegistryImpl = new SavedStateRegistryImpl();
            }
            builder.drmConfiguration = savedStateRegistryImpl;
            builder.adsConfiguration = localConfiguration.adsConfiguration;
            builder.imageDurationMs = localConfiguration.imageDurationMs;
        }
        return builder;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaItem)) {
            return false;
        }
        MediaItem mediaItem = (MediaItem) obj;
        return Objects.equals(this.mediaId, mediaItem.mediaId) && this.clippingConfiguration.equals(mediaItem.clippingConfiguration) && Objects.equals(this.localConfiguration, mediaItem.localConfiguration) && this.liveConfiguration.equals(mediaItem.liveConfiguration) && Objects.equals(this.mediaMetadata, mediaItem.mediaMetadata) && Objects.equals(this.requestMetadata, mediaItem.requestMetadata);
    }

    public final int hashCode() {
        int iHashCode = this.mediaId.hashCode() * 31;
        LocalConfiguration localConfiguration = this.localConfiguration;
        return this.requestMetadata.hashCode() + ((this.mediaMetadata.hashCode() + ((this.clippingConfiguration.hashCode() + ((this.liveConfiguration.hashCode() + ((iHashCode + (localConfiguration != null ? localConfiguration.hashCode() : 0)) * 31)) * 31)) * 31)) * 31);
    }

    public final Bundle toBundle(int i, boolean z) {
        LocalConfiguration localConfiguration;
        Bundle bundle = new Bundle();
        String str = this.mediaId;
        if (!str.equals("")) {
            bundle.putString(FIELD_MEDIA_ID, str);
        }
        LiveConfiguration liveConfiguration = LiveConfiguration.UNSET;
        LiveConfiguration liveConfiguration2 = this.liveConfiguration;
        if (!liveConfiguration2.equals(liveConfiguration)) {
            bundle.putBundle(FIELD_LIVE_CONFIGURATION, liveConfiguration2.toBundle());
        }
        MediaMetadata mediaMetadata = MediaMetadata.EMPTY;
        MediaMetadata mediaMetadata2 = this.mediaMetadata;
        if (!mediaMetadata2.equals(mediaMetadata)) {
            bundle.putBundle(FIELD_MEDIA_METADATA, mediaMetadata2.toBundle(i));
        }
        ClippingConfiguration clippingConfiguration = ClippingConfiguration.UNSET;
        ClippingProperties clippingProperties = this.clippingConfiguration;
        if (!clippingProperties.equals(clippingConfiguration)) {
            Bundle bundle2 = new Bundle();
            long j = clippingProperties.startPositionMs;
            if (j != clippingConfiguration.startPositionMs) {
                bundle2.putLong(ClippingConfiguration.FIELD_START_POSITION_MS, j);
            }
            long j2 = clippingProperties.endPositionMs;
            if (j2 != clippingConfiguration.endPositionMs) {
                bundle2.putLong(ClippingConfiguration.FIELD_END_POSITION_MS, j2);
            }
            long j3 = clippingProperties.startPositionUs;
            if (j3 != clippingConfiguration.startPositionUs) {
                bundle2.putLong(ClippingConfiguration.FIELD_START_POSITION_US, j3);
            }
            long j4 = clippingProperties.endPositionUs;
            if (j4 != clippingConfiguration.endPositionUs) {
                bundle2.putLong(ClippingConfiguration.FIELD_END_POSITION_US, j4);
            }
            boolean z2 = clippingProperties.relativeToLiveWindow;
            if (z2 != clippingConfiguration.relativeToLiveWindow) {
                bundle2.putBoolean(ClippingConfiguration.FIELD_RELATIVE_TO_LIVE_WINDOW, z2);
            }
            boolean z3 = clippingProperties.relativeToDefaultPosition;
            if (z3 != clippingConfiguration.relativeToDefaultPosition) {
                bundle2.putBoolean(ClippingConfiguration.FIELD_RELATIVE_TO_DEFAULT_POSITION, z3);
            }
            boolean z4 = clippingProperties.startsAtKeyFrame;
            if (z4 != clippingConfiguration.startsAtKeyFrame) {
                bundle2.putBoolean(ClippingConfiguration.FIELD_STARTS_AT_KEY_FRAME, z4);
            }
            boolean z5 = clippingProperties.allowUnseekableMedia;
            if (z5 != clippingConfiguration.allowUnseekableMedia) {
                bundle2.putBoolean(ClippingConfiguration.FIELD_ALLOW_UNSEEKABLE_MEDIA, z5);
            }
            bundle.putBundle(FIELD_CLIPPING_PROPERTIES, bundle2);
        }
        RequestMetadata requestMetadata = RequestMetadata.EMPTY;
        RequestMetadata requestMetadata2 = this.requestMetadata;
        if (!requestMetadata2.equals(requestMetadata)) {
            Bundle bundle3 = new Bundle();
            Uri uri = requestMetadata2.mediaUri;
            if (uri != null) {
                bundle3.putParcelable(RequestMetadata.FIELD_MEDIA_URI, uri);
            }
            String str2 = requestMetadata2.searchQuery;
            if (str2 != null) {
                bundle3.putString(RequestMetadata.FIELD_SEARCH_QUERY, str2);
            }
            Bundle bundle4 = requestMetadata2.extras;
            if (bundle4 != null) {
                bundle3.putBundle(RequestMetadata.FIELD_EXTRAS, bundle4);
            }
            bundle.putBundle(FIELD_REQUEST_METADATA, bundle3);
        }
        if (z && (localConfiguration = this.localConfiguration) != null) {
            ImmutableList immutableList = localConfiguration.subtitleConfigurations;
            List list = localConfiguration.streamKeys;
            Bundle bundle5 = new Bundle();
            bundle5.putParcelable(LocalConfiguration.FIELD_URI, localConfiguration.uri);
            String str3 = localConfiguration.mimeType;
            if (str3 != null) {
                bundle5.putString(LocalConfiguration.FIELD_MIME_TYPE, str3);
            }
            DrmConfiguration drmConfiguration = localConfiguration.drmConfiguration;
            if (drmConfiguration != null) {
                String str4 = LocalConfiguration.FIELD_DRM_CONFIGURATION;
                ImmutableList immutableList2 = drmConfiguration.forcedSessionTrackTypes;
                ImmutableMap immutableMap = drmConfiguration.licenseRequestHeaders;
                Bundle bundle6 = new Bundle();
                bundle6.putString(DrmConfiguration.FIELD_SCHEME, drmConfiguration.scheme.toString());
                Uri uri2 = drmConfiguration.licenseUri;
                if (uri2 != null) {
                    bundle6.putParcelable(DrmConfiguration.FIELD_LICENSE_URI, uri2);
                }
                if (!immutableMap.isEmpty()) {
                    String str5 = DrmConfiguration.FIELD_LICENSE_REQUEST_HEADERS;
                    Bundle bundle7 = new Bundle();
                    for (Map.Entry entry : immutableMap.entrySet()) {
                        bundle7.putString((String) entry.getKey(), (String) entry.getValue());
                    }
                    bundle6.putBundle(str5, bundle7);
                }
                boolean z6 = drmConfiguration.multiSession;
                if (z6) {
                    bundle6.putBoolean(DrmConfiguration.FIELD_MULTI_SESSION, z6);
                }
                boolean z7 = drmConfiguration.playClearContentWithoutKey;
                if (z7) {
                    bundle6.putBoolean(DrmConfiguration.FIELD_PLAY_CLEAR_CONTENT_WITHOUT_KEY, z7);
                }
                boolean z8 = drmConfiguration.forceDefaultLicenseUri;
                if (z8) {
                    bundle6.putBoolean(DrmConfiguration.FIELD_FORCE_DEFAULT_LICENSE_URI, z8);
                }
                if (!immutableList2.isEmpty()) {
                    bundle6.putIntegerArrayList(DrmConfiguration.FIELD_FORCED_SESSION_TRACK_TYPES, new ArrayList<>(immutableList2));
                }
                byte[] bArr = drmConfiguration.keySetId;
                if (bArr != null) {
                    bundle6.putByteArray(DrmConfiguration.FIELD_KEY_SET_ID, bArr);
                }
                bundle5.putBundle(str4, bundle6);
            }
            AdsConfiguration adsConfiguration = localConfiguration.adsConfiguration;
            if (adsConfiguration != null) {
                String str6 = LocalConfiguration.FIELD_ADS_CONFIGURATION;
                Bundle bundle8 = new Bundle();
                bundle8.putParcelable(AdsConfiguration.FIELD_AD_TAG_URI, adsConfiguration.adTagUri);
                bundle5.putBundle(str6, bundle8);
            }
            if (!list.isEmpty()) {
                bundle5.putParcelableArrayList(LocalConfiguration.FIELD_STREAM_KEYS, GlUtil.toBundleArrayList(list, new Format$$ExternalSyntheticLambda1((byte) 1)));
            }
            String str7 = localConfiguration.customCacheKey;
            if (str7 != null) {
                bundle5.putString(LocalConfiguration.FIELD_CUSTOM_CACHE_KEY, str7);
            }
            if (!immutableList.isEmpty()) {
                bundle5.putParcelableArrayList(LocalConfiguration.FIELD_SUBTITLE_CONFIGURATION, GlUtil.toBundleArrayList(immutableList, new Format$$ExternalSyntheticLambda1((byte) 2)));
            }
            long j5 = localConfiguration.imageDurationMs;
            if (j5 != -9223372036854775807L) {
                bundle5.putLong(LocalConfiguration.FIELD_IMAGE_DURATION_MS, j5);
            }
            bundle.putBundle(FIELD_LOCAL_CONFIGURATION, bundle5);
        }
        return bundle;
    }
}
