package androidx.media3.exoplayer.trackselection;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda1;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticLambda1;
import androidx.media3.common.Label;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.ExoPlayerImplInternal;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.exoplayer.util.SpatializerWrapper;
import androidx.media3.extractor.text.CueDecoder;
import coil3.util.UtilsKt;
import com.google.common.collect.ComparatorOrdering;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.NaturalOrdering;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableList;
import io.ktor.client.utils.CIOKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultTrackSelector {
    public static final Ordering FORMAT_VALUE_ORDERING = new ComparatorOrdering(new LayoutNode$$ExternalSyntheticLambda1((byte) 11));
    public AudioAttributes audioAttributes;
    public DefaultBandwidthMeter bandwidthMeter;
    public final Context context;
    public Boolean deviceIsTV;
    public ExoPlayerImplInternal listener;
    public final Object lock;
    public Parameters parameters;
    public Thread playbackThread;
    public SpatializerWrapper spatializer;
    public final CueDecoder trackSelectionFactory;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AudioTrackInfo extends TrackInfo implements Comparable {
        public final boolean allowMixedMimeTypes;
        public final int bitrate;
        public final int channelCount;
        public final boolean hasMainOrNoRoleFlag;
        public final boolean isDefaultSelectionFlag;
        public final boolean isObjectBasedAudio;
        public final boolean isWithinConstraints;
        public final boolean isWithinRendererCapabilities;
        public final String language;
        public final int localeLanguageMatchIndex;
        public final int localeLanguageScore;
        public final Parameters parameters;
        public final int preferredLabelMatchIndex;
        public final int preferredLanguageIndex;
        public final int preferredLanguageScore;
        public final int preferredMimeTypeMatchIndex;
        public final int preferredRoleFlagsScore;
        public final int sampleRate;
        public final int selectionEligibility;
        public final boolean usesHardwareAcceleration;
        public final boolean usesPrimaryDecoder;

        /* JADX WARN: Code duplicated, block: B:120:0x0190  */
        /* JADX WARN: Code duplicated, block: B:32:0x0084  */
        /* JADX WARN: Code duplicated, block: B:85:0x013a  */
        /* JADX WARN: Code duplicated, block: B:86:0x013c  */
        /* JADX WARN: Code duplicated, block: B:89:0x0145  */
        /* JADX WARN: Code duplicated, block: B:90:0x0147  */
        public AudioTrackInfo(int i, TrackGroup trackGroup, int i2, Parameters parameters, int i3, boolean z, DefaultTrackSelector$$ExternalSyntheticLambda10 defaultTrackSelector$$ExternalSyntheticLambda10, int i4) {
            int i5;
            int formatLanguageScore;
            boolean z2;
            int formatLanguageScore2;
            boolean z3;
            boolean z4;
            boolean z5;
            super(i, trackGroup, i2);
            this.parameters = parameters;
            boolean z6 = parameters.allowAudioNonSeamlessAdaptiveness;
            ImmutableList immutableList = parameters.preferredAudioMimeTypes;
            ImmutableList immutableList2 = parameters.preferredAudioLanguages;
            int i6 = z6 ? 24 : 16;
            int i7 = 0;
            this.allowMixedMimeTypes = false;
            this.language = DefaultTrackSelector.normalizeUndeterminedLanguageToNull(this.format.language);
            this.isWithinRendererCapabilities = BaseRenderer.isFormatSupported(i3, false);
            int i8 = 0;
            while (true) {
                i5 = Integer.MAX_VALUE;
                if (i8 >= immutableList2.size()) {
                    formatLanguageScore = 0;
                    i8 = Integer.MAX_VALUE;
                    break;
                } else {
                    formatLanguageScore = DefaultTrackSelector.getFormatLanguageScore(this.format, (String) immutableList2.get(i8), false);
                    if (formatLanguageScore > 0) {
                        break;
                    } else {
                        i8++;
                    }
                }
            }
            this.preferredLanguageIndex = i8;
            this.preferredLanguageScore = formatLanguageScore;
            int i9 = this.format.roleFlags;
            int i10 = parameters.preferredAudioRoleFlags;
            this.preferredRoleFlagsScore = (i9 == 0 || i9 != i10) ? Integer.bitCount(i9 & i10) : Integer.MAX_VALUE;
            this.preferredLabelMatchIndex = DefaultTrackSelector.getBestLabelMatchIndex(this.format, parameters.preferredAudioLabels);
            Format format = this.format;
            int i11 = format.roleFlags;
            this.hasMainOrNoRoleFlag = i11 == 0 || (i11 & 1) != 0;
            this.isDefaultSelectionFlag = (format.selectionFlags & 1) != 0;
            String str = format.sampleMimeType;
            if (str != null) {
                switch (str) {
                    case "audio/eac3-joc":
                    case "audio/ac4":
                    case "audio/iamf":
                        z2 = true;
                        break;
                    default:
                        z2 = false;
                        break;
                }
            } else {
                z2 = false;
            }
            this.isObjectBasedAudio = z2;
            int i12 = format.channelCount;
            this.channelCount = i12;
            this.sampleRate = format.sampleRate;
            int i13 = format.bitrate;
            this.bitrate = i13;
            this.isWithinConstraints = (i13 == -1 || i13 <= parameters.maxAudioBitrate) && (i12 == -1 || i12 <= parameters.maxAudioChannelCount) && defaultTrackSelector$$ExternalSyntheticLambda10.apply(format);
            String[] strArrSplit = Resources.getSystem().getConfiguration().getLocales().toLanguageTags().split(",", -1);
            for (int i14 = 0; i14 < strArrSplit.length; i14++) {
                strArrSplit[i14] = Util.normalizeLanguageCode(strArrSplit[i14]);
            }
            int i15 = 0;
            while (true) {
                if (i15 < strArrSplit.length) {
                    formatLanguageScore2 = DefaultTrackSelector.getFormatLanguageScore(this.format, strArrSplit[i15], false);
                    if (formatLanguageScore2 <= 0) {
                        i15++;
                    }
                } else {
                    formatLanguageScore2 = 0;
                    i15 = Integer.MAX_VALUE;
                }
            }
            this.localeLanguageMatchIndex = i15;
            this.localeLanguageScore = formatLanguageScore2;
            for (int i16 = 0; i16 < immutableList.size(); i16++) {
                String str2 = this.format.sampleMimeType;
                if (str2 != null && str2.equals(immutableList.get(i16))) {
                    i5 = i16;
                    this.preferredMimeTypeMatchIndex = i5;
                    if ((i3 & 384) == 128) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    this.usesPrimaryDecoder = z3;
                    if ((i3 & 64) == 64) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    this.usesHardwareAcceleration = z4;
                    Format format2 = this.format;
                    boolean z7 = this.isWithinConstraints;
                    Parameters parameters2 = this.parameters;
                    z5 = parameters2.exceedRendererCapabilitiesIfNecessary;
                    TrackSelectionParameters.AudioOffloadPreferences audioOffloadPreferences = parameters2.audioOffloadPreferences;
                    if (BaseRenderer.isFormatSupported(i3, z5) && ((z7 || parameters2.exceedAudioConstraintsIfNecessary) && (audioOffloadPreferences.audioOffloadMode != 2 || DefaultTrackSelector.rendererSupportsOffload(parameters2, i3, format2)))) {
                        if (BaseRenderer.isFormatSupported(i3, false) || !z7 || format2.bitrate == -1 || parameters2.forceHighestSupportedBitrate || parameters2.forceLowestBitrate || ((!parameters2.allowMultipleAdaptiveSelections && z) || audioOffloadPreferences.audioOffloadMode == 2 || (i6 & i3) == 0)) {
                            i7 = 1;
                        } else {
                            i7 = 2;
                        }
                    }
                    this.selectionEligibility = i7;
                }
            }
            this.preferredMimeTypeMatchIndex = i5;
            if ((i3 & 384) == 128) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.usesPrimaryDecoder = z3;
            if ((i3 & 64) == 64) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.usesHardwareAcceleration = z4;
            Format format3 = this.format;
            boolean z8 = this.isWithinConstraints;
            Parameters parameters3 = this.parameters;
            z5 = parameters3.exceedRendererCapabilitiesIfNecessary;
            TrackSelectionParameters.AudioOffloadPreferences audioOffloadPreferences2 = parameters3.audioOffloadPreferences;
            if (BaseRenderer.isFormatSupported(i3, z5)) {
                if (BaseRenderer.isFormatSupported(i3, false)) {
                    i7 = 1;
                } else {
                    i7 = 1;
                }
            }
            this.selectionEligibility = i7;
        }

        @Override // java.lang.Comparable
        public final int compareTo(AudioTrackInfo audioTrackInfo) {
            Ordering ordering;
            Ordering orderingReverse;
            boolean z = this.isWithinRendererCapabilities;
            boolean z2 = this.isWithinConstraints;
            if (z2 && z) {
                orderingReverse = DefaultTrackSelector.FORMAT_VALUE_ORDERING;
                ordering = orderingReverse;
            } else {
                Ordering ordering2 = DefaultTrackSelector.FORMAT_VALUE_ORDERING;
                ordering = ordering2;
                orderingReverse = ordering2.reverse();
            }
            boolean z3 = audioTrackInfo.isWithinRendererCapabilities;
            int i = audioTrackInfo.bitrate;
            ComparisonChain comparisonChainCompareFalseFirst = ComparisonChain.ACTIVE.compareFalseFirst(z, z3);
            Integer numValueOf = Integer.valueOf(this.preferredLanguageIndex);
            Integer numValueOf2 = Integer.valueOf(audioTrackInfo.preferredLanguageIndex);
            NaturalOrdering naturalOrdering = NaturalOrdering.INSTANCE$1;
            ComparisonChain comparisonChainCompare = comparisonChainCompareFalseFirst.compare(numValueOf, numValueOf2, naturalOrdering).compare(this.preferredLanguageScore, audioTrackInfo.preferredLanguageScore).compare(this.preferredRoleFlagsScore, audioTrackInfo.preferredRoleFlagsScore).compare(Integer.valueOf(this.preferredLabelMatchIndex), Integer.valueOf(audioTrackInfo.preferredLabelMatchIndex), naturalOrdering).compareFalseFirst(this.isDefaultSelectionFlag, audioTrackInfo.isDefaultSelectionFlag).compareFalseFirst(this.hasMainOrNoRoleFlag, audioTrackInfo.hasMainOrNoRoleFlag).compare(Integer.valueOf(this.localeLanguageMatchIndex), Integer.valueOf(audioTrackInfo.localeLanguageMatchIndex), naturalOrdering).compare(this.localeLanguageScore, audioTrackInfo.localeLanguageScore).compareFalseFirst(z2, audioTrackInfo.isWithinConstraints).compare(Integer.valueOf(this.preferredMimeTypeMatchIndex), Integer.valueOf(audioTrackInfo.preferredMimeTypeMatchIndex), naturalOrdering);
            boolean z4 = this.parameters.forceLowestBitrate;
            int i2 = this.bitrate;
            if (z4) {
                comparisonChainCompare = comparisonChainCompare.compare(Integer.valueOf(i2), Integer.valueOf(i), ordering.reverse());
            }
            ComparisonChain comparisonChainCompare2 = comparisonChainCompare.compareFalseFirst(this.usesPrimaryDecoder, audioTrackInfo.usesPrimaryDecoder).compareFalseFirst(this.usesHardwareAcceleration, audioTrackInfo.usesHardwareAcceleration).compareFalseFirst(this.isObjectBasedAudio, audioTrackInfo.isObjectBasedAudio).compare(Integer.valueOf(this.channelCount), Integer.valueOf(audioTrackInfo.channelCount), orderingReverse).compare(Integer.valueOf(this.sampleRate), Integer.valueOf(audioTrackInfo.sampleRate), orderingReverse);
            if (Objects.equals(this.language, audioTrackInfo.language)) {
                comparisonChainCompare2 = comparisonChainCompare2.compare(Integer.valueOf(i2), Integer.valueOf(i), orderingReverse);
            }
            return comparisonChainCompare2.result();
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public final int getSelectionEligibility() {
            return this.selectionEligibility;
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public final boolean isCompatibleForAdaptationWith(TrackInfo trackInfo) {
            int i;
            String str;
            AudioTrackInfo audioTrackInfo = (AudioTrackInfo) trackInfo;
            Format format = audioTrackInfo.format;
            this.parameters.getClass();
            Format format2 = this.format;
            int i2 = format2.channelCount;
            if (i2 == -1 || i2 != format.channelCount) {
                return false;
            }
            return (this.allowMixedMimeTypes || ((str = format2.sampleMimeType) != null && TextUtils.equals(str, format.sampleMimeType))) && (i = format2.sampleRate) != -1 && i == format.sampleRate && this.usesPrimaryDecoder == audioTrackInfo.usesPrimaryDecoder && this.usesHardwareAcceleration == audioTrackInfo.usesHardwareAcceleration;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ImageTrackInfo extends TrackInfo implements Comparable {
        public final int pixelCount;
        public final int selectionEligibility;

        public ImageTrackInfo(int i, TrackGroup trackGroup, int i2, Parameters parameters, int i3) {
            int i4;
            super(i, trackGroup, i2);
            this.selectionEligibility = BaseRenderer.isFormatSupported(i3, parameters.exceedRendererCapabilitiesIfNecessary) ? 1 : 0;
            Format format = this.format;
            int i5 = format.width;
            int i6 = -1;
            if (i5 != -1 && (i4 = format.height) != -1) {
                i6 = i5 * i4;
            }
            this.pixelCount = i6;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return Integer.compare(this.pixelCount, ((ImageTrackInfo) obj).pixelCount);
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public final int getSelectionEligibility() {
            return this.selectionEligibility;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class OtherTrackScore implements Comparable {
        public final boolean isDefault;
        public final boolean isWithinRendererCapabilities;

        public OtherTrackScore(Format format, int i) {
            this.isDefault = (format.selectionFlags & 1) != 0;
            this.isWithinRendererCapabilities = BaseRenderer.isFormatSupported(i, false);
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            OtherTrackScore otherTrackScore = (OtherTrackScore) obj;
            return ComparisonChain.ACTIVE.compareFalseFirst(this.isWithinRendererCapabilities, otherTrackScore.isWithinRendererCapabilities).compareFalseFirst(this.isDefault, otherTrackScore.isDefault).result();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TextTrackInfo extends TrackInfo implements Comparable {
        public final boolean hasCaptionRoleFlags;
        public final boolean isDefault;
        public final boolean isForced;
        public final boolean isWithinRendererCapabilities;
        public final int preferredLabelMatchIndex;
        public final int preferredLanguageIndex;
        public final int preferredLanguageScore;
        public final int preferredRoleFlagsScore;
        public final int selectedAudioLanguageScore;
        public final int selectionEligibility;

        public TextTrackInfo(int i, TrackGroup trackGroup, int i2, Parameters parameters, int i3, String str, String str2) {
            int formatLanguageScore;
            super(i, trackGroup, i2);
            int i4 = 0;
            this.isWithinRendererCapabilities = BaseRenderer.isFormatSupported(i3, false);
            int i5 = this.format.selectionFlags;
            int i6 = parameters.ignoredTextSelectionFlags;
            ImmutableList immutableList = parameters.preferredTextLanguages;
            int i7 = i5 & (~i6);
            this.isDefault = (i7 & 1) != 0;
            this.isForced = (i7 & 2) != 0;
            ImmutableList immutableListOf = str2 != null ? ImmutableList.of((Object) str2) : immutableList.isEmpty() ? ImmutableList.of((Object) "") : immutableList;
            int i8 = 0;
            while (true) {
                if (i8 >= immutableListOf.size()) {
                    formatLanguageScore = 0;
                    i8 = Integer.MAX_VALUE;
                    break;
                } else {
                    formatLanguageScore = DefaultTrackSelector.getFormatLanguageScore(this.format, (String) immutableListOf.get(i8), parameters.selectUndeterminedTextLanguage);
                    if (formatLanguageScore > 0) {
                        break;
                    } else {
                        i8++;
                    }
                }
            }
            this.preferredLanguageIndex = i8;
            this.preferredLanguageScore = formatLanguageScore;
            int i9 = str2 != null ? 1088 : parameters.preferredTextRoleFlags;
            int i10 = this.format.roleFlags;
            Ordering ordering = DefaultTrackSelector.FORMAT_VALUE_ORDERING;
            int iBitCount = (i10 == 0 || i10 != i9) ? Integer.bitCount(i9 & i10) : Integer.MAX_VALUE;
            this.preferredRoleFlagsScore = iBitCount;
            Format format = this.format;
            this.hasCaptionRoleFlags = (1088 & format.roleFlags) != 0;
            int bestLabelMatchIndex = DefaultTrackSelector.getBestLabelMatchIndex(format, parameters.preferredTextLabels);
            this.preferredLabelMatchIndex = bestLabelMatchIndex;
            int formatLanguageScore2 = DefaultTrackSelector.getFormatLanguageScore(this.format, str, DefaultTrackSelector.normalizeUndeterminedLanguageToNull(str) == null);
            this.selectedAudioLanguageScore = formatLanguageScore2;
            boolean z = formatLanguageScore > 0 || (immutableList.isEmpty() && iBitCount > 0) || ((immutableList.isEmpty() && bestLabelMatchIndex != Integer.MAX_VALUE) || this.isDefault || ((this.isForced && formatLanguageScore2 > 0) || parameters.selectTextByDefault));
            if (BaseRenderer.isFormatSupported(i3, parameters.exceedRendererCapabilitiesIfNecessary) && z) {
                i4 = 1;
            }
            this.selectionEligibility = i4;
        }

        @Override // java.lang.Comparable
        public final int compareTo(TextTrackInfo textTrackInfo) {
            ComparisonChain comparisonChainCompareFalseFirst = ComparisonChain.ACTIVE.compareFalseFirst(this.isWithinRendererCapabilities, textTrackInfo.isWithinRendererCapabilities);
            Integer numValueOf = Integer.valueOf(this.preferredLanguageIndex);
            Integer numValueOf2 = Integer.valueOf(textTrackInfo.preferredLanguageIndex);
            NaturalOrdering naturalOrdering = NaturalOrdering.INSTANCE;
            NaturalOrdering naturalOrdering2 = NaturalOrdering.INSTANCE$1;
            ComparisonChain comparisonChainCompare = comparisonChainCompareFalseFirst.compare(numValueOf, numValueOf2, naturalOrdering2);
            int i = textTrackInfo.preferredLanguageScore;
            int i2 = this.preferredLanguageScore;
            ComparisonChain comparisonChainCompare2 = comparisonChainCompare.compare(i2, i);
            int i3 = textTrackInfo.preferredRoleFlagsScore;
            int i4 = this.preferredRoleFlagsScore;
            ComparisonChain comparisonChainCompareFalseFirst2 = comparisonChainCompare2.compare(i4, i3).compare(Integer.valueOf(this.preferredLabelMatchIndex), Integer.valueOf(textTrackInfo.preferredLabelMatchIndex), naturalOrdering2).compareFalseFirst(this.isDefault, textTrackInfo.isDefault);
            Boolean boolValueOf = Boolean.valueOf(this.isForced);
            Boolean boolValueOf2 = Boolean.valueOf(textTrackInfo.isForced);
            if (i2 != 0) {
                naturalOrdering = naturalOrdering2;
            }
            ComparisonChain comparisonChainCompare3 = comparisonChainCompareFalseFirst2.compare(boolValueOf, boolValueOf2, naturalOrdering).compare(this.selectedAudioLanguageScore, textTrackInfo.selectedAudioLanguageScore);
            if (i4 == 0) {
                comparisonChainCompare3 = comparisonChainCompare3.compareTrueFirst(this.hasCaptionRoleFlags, textTrackInfo.hasCaptionRoleFlags);
            }
            return comparisonChainCompare3.result();
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public final int getSelectionEligibility() {
            return this.selectionEligibility;
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public final boolean isCompatibleForAdaptationWith(TrackInfo trackInfo) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class TrackInfo {
        public final Format format;
        public final int rendererIndex;
        public final TrackGroup trackGroup;
        public final int trackIndex;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public interface Factory {
            RegularImmutableList create(int i, TrackGroup trackGroup, int[] iArr);
        }

        public TrackInfo(int i, TrackGroup trackGroup, int i2) {
            this.rendererIndex = i;
            this.trackGroup = trackGroup;
            this.trackIndex = i2;
            this.format = trackGroup.formats[i2];
        }

        public abstract int getSelectionEligibility();

        public boolean isCompatibleForAdaptationWith(TrackInfo trackInfo) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class VideoTrackInfo extends TrackInfo {
        public final boolean allowMixedMimeTypes;
        public final int bitrate;
        public final int codecPreferenceScore;
        public final boolean hasMainOrNoRoleFlag;
        public final boolean hasReasonableFrameRate;
        public final boolean isHdr;
        public final boolean isWithinMaxConstraints;
        public final boolean isWithinMinConstraints;
        public final boolean isWithinRendererCapabilities;
        public final Parameters parameters;
        public final int pixelCount;
        public final int preferredLabelMatchIndex;
        public final int preferredLanguageIndex;
        public final int preferredLanguageScore;
        public final int preferredMimeTypeMatchIndex;
        public final int preferredRoleFlagsScore;
        public final String resolvedMimeType;
        public final int selectedAudioLanguageScore;
        public final int selectionEligibility;
        public final boolean usesHardwareAcceleration;
        public final boolean usesPrimaryDecoder;
        public final boolean usesPrimaryOrFallbackDecoder;

        /* JADX WARN: Code duplicated, block: B:112:0x014f  */
        /* JADX WARN: Code duplicated, block: B:25:0x0044  */
        /* JADX WARN: Code duplicated, block: B:45:0x0072  */
        public VideoTrackInfo(int i, TrackGroup trackGroup, int i2, Parameters parameters, int i3, String str, int i4, boolean z) {
            boolean z2;
            boolean z3;
            int i5;
            int formatLanguageScore;
            int i6;
            boolean z4;
            String alternativeCodecMimeType;
            int i7;
            Format format;
            int i8;
            int i9;
            int i10;
            Format format2;
            int i11;
            int i12;
            int i13;
            super(i, trackGroup, i2);
            this.parameters = parameters;
            boolean z5 = parameters.allowVideoNonSeamlessAdaptiveness;
            ImmutableList immutableList = parameters.preferredVideoMimeTypes;
            ImmutableList immutableList2 = parameters.preferredVideoLanguages;
            int i14 = z5 ? 24 : 16;
            int i15 = 0;
            this.allowMixedMimeTypes = false;
            if (!z || (((i11 = (format2 = this.format).width) != -1 && i11 > parameters.maxVideoWidth) || ((i12 = format2.height) != -1 && i12 > parameters.maxVideoHeight))) {
                z2 = false;
            } else {
                float f = format2.frameRate;
                if ((f == -1.0f || f <= parameters.maxVideoFrameRate) && ((i13 = format2.bitrate) == -1 || i13 <= parameters.maxVideoBitrate)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            this.isWithinMaxConstraints = z2;
            if (!z || (((i8 = (format = this.format).width) != -1 && i8 < parameters.minVideoWidth) || ((i9 = format.height) != -1 && i9 < parameters.minVideoHeight))) {
                z3 = false;
            } else {
                float f2 = format.frameRate;
                if ((f2 == -1.0f || f2 >= parameters.minVideoFrameRate) && ((i10 = format.bitrate) == -1 || i10 >= parameters.minVideoBitrate)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            }
            this.isWithinMinConstraints = z3;
            this.isWithinRendererCapabilities = BaseRenderer.isFormatSupported(i3, false);
            Format format3 = this.format;
            float f3 = format3.frameRate;
            this.hasReasonableFrameRate = f3 != -1.0f && f3 >= 10.0f;
            this.bitrate = format3.bitrate;
            int i16 = format3.width;
            this.pixelCount = (i16 == -1 || (i7 = format3.height) == -1) ? -1 : i16 * i7;
            int i17 = 0;
            while (true) {
                i5 = Integer.MAX_VALUE;
                if (i17 >= immutableList2.size()) {
                    formatLanguageScore = 0;
                    i17 = Integer.MAX_VALUE;
                    break;
                } else {
                    formatLanguageScore = DefaultTrackSelector.getFormatLanguageScore(this.format, (String) immutableList2.get(i17), false);
                    if (formatLanguageScore > 0) {
                        break;
                    } else {
                        i17++;
                    }
                }
            }
            this.preferredLanguageIndex = i17;
            this.preferredLanguageScore = formatLanguageScore;
            int i18 = this.format.roleFlags;
            int i19 = parameters.preferredVideoRoleFlags;
            Ordering ordering = DefaultTrackSelector.FORMAT_VALUE_ORDERING;
            this.preferredRoleFlagsScore = (i18 == 0 || i18 != i19) ? Integer.bitCount(i18 & i19) : Integer.MAX_VALUE;
            int i20 = this.format.roleFlags;
            this.hasMainOrNoRoleFlag = i20 == 0 || (i20 & 1) != 0;
            this.selectedAudioLanguageScore = DefaultTrackSelector.getFormatLanguageScore(this.format, str, DefaultTrackSelector.normalizeUndeterminedLanguageToNull(str) == null);
            Format format4 = this.format;
            String str2 = format4.sampleMimeType;
            int i21 = i3 & 384;
            if (i21 == 256 && (alternativeCodecMimeType = MediaCodecUtil.getAlternativeCodecMimeType(format4)) != null) {
                str2 = alternativeCodecMimeType;
            }
            for (int i22 = 0; i22 < immutableList.size(); i22++) {
                if (str2 != null && str2.equals(immutableList.get(i22))) {
                    i5 = i22;
                    break;
                }
            }
            this.preferredMimeTypeMatchIndex = i5;
            this.preferredLabelMatchIndex = DefaultTrackSelector.getBestLabelMatchIndex(this.format, parameters.preferredVideoLabels);
            this.usesPrimaryOrFallbackDecoder = i21 == 128 || i21 == 256;
            boolean z6 = i21 == 128;
            this.usesPrimaryDecoder = z6;
            this.usesHardwareAcceleration = (i3 & 64) == 64;
            this.resolvedMimeType = str2;
            if (str2 != null) {
                i6 = 4;
                switch (str2) {
                    case "video/dolby-vision":
                        i6 = 5;
                        break;
                    case "video/av01":
                        break;
                    case "video/hevc":
                        i6 = 3;
                        break;
                    case "video/avc":
                        i6 = 1;
                        break;
                    case "video/x-vnd.on2.vp9":
                        i6 = 2;
                        break;
                    default:
                        i6 = 0;
                        break;
                }
            } else {
                i6 = 0;
            }
            this.codecPreferenceScore = i6;
            if (z6) {
                ColorInfo colorInfo = this.format.colorInfo;
                if (colorInfo != null) {
                    int i23 = colorInfo.colorTransfer;
                    z4 = (i23 == 7 || i23 == 6) ? true : z4;
                } else {
                    ColorInfo colorInfo2 = ColorInfo.SDR_BT709_LIMITED;
                }
                z4 = false;
            } else {
                z4 = false;
            }
            this.isHdr = z4;
            boolean z7 = this.isWithinMaxConstraints;
            Parameters parameters2 = this.parameters;
            Format format5 = this.format;
            if ((format5.roleFlags & 16384) == 0 && BaseRenderer.isFormatSupported(i3, parameters2.exceedRendererCapabilitiesIfNecessary) && (z7 || parameters2.exceedVideoConstraintsIfNecessary)) {
                i15 = (!BaseRenderer.isFormatSupported(i3, false) || !this.isWithinMinConstraints || !z7 || format5.bitrate == -1 || parameters2.forceHighestSupportedBitrate || parameters2.forceLowestBitrate || (i14 & i3) == 0) ? 1 : 2;
            }
            this.selectionEligibility = i15;
        }

        public static int compareNonQualityPreferences(VideoTrackInfo videoTrackInfo, VideoTrackInfo videoTrackInfo2) {
            ComparisonChain comparisonChainCompareFalseFirst = ComparisonChain.ACTIVE.compareFalseFirst(videoTrackInfo.isWithinRendererCapabilities, videoTrackInfo2.isWithinRendererCapabilities);
            Integer numValueOf = Integer.valueOf(videoTrackInfo.preferredLanguageIndex);
            Integer numValueOf2 = Integer.valueOf(videoTrackInfo2.preferredLanguageIndex);
            NaturalOrdering naturalOrdering = NaturalOrdering.INSTANCE$1;
            return comparisonChainCompareFalseFirst.compare(numValueOf, numValueOf2, naturalOrdering).compare(videoTrackInfo.preferredLanguageScore, videoTrackInfo2.preferredLanguageScore).compare(videoTrackInfo.preferredRoleFlagsScore, videoTrackInfo2.preferredRoleFlagsScore).compare(Integer.valueOf(videoTrackInfo.preferredLabelMatchIndex), Integer.valueOf(videoTrackInfo2.preferredLabelMatchIndex), naturalOrdering).compareFalseFirst(videoTrackInfo.hasMainOrNoRoleFlag, videoTrackInfo2.hasMainOrNoRoleFlag).compare(videoTrackInfo.selectedAudioLanguageScore, videoTrackInfo2.selectedAudioLanguageScore).compareFalseFirst(videoTrackInfo.hasReasonableFrameRate, videoTrackInfo2.hasReasonableFrameRate).compareFalseFirst(videoTrackInfo.isWithinMaxConstraints, videoTrackInfo2.isWithinMaxConstraints).compareFalseFirst(videoTrackInfo.isWithinMinConstraints, videoTrackInfo2.isWithinMinConstraints).compare(Integer.valueOf(videoTrackInfo.preferredMimeTypeMatchIndex), Integer.valueOf(videoTrackInfo2.preferredMimeTypeMatchIndex), naturalOrdering).compareFalseFirst(videoTrackInfo.usesPrimaryOrFallbackDecoder, videoTrackInfo2.usesPrimaryOrFallbackDecoder).compareFalseFirst(videoTrackInfo.usesHardwareAcceleration, videoTrackInfo2.usesHardwareAcceleration).result();
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public final int getSelectionEligibility() {
            return this.selectionEligibility;
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public final boolean isCompatibleForAdaptationWith(TrackInfo trackInfo) {
            VideoTrackInfo videoTrackInfo = (VideoTrackInfo) trackInfo;
            if (!this.allowMixedMimeTypes && !Objects.equals(this.resolvedMimeType, videoTrackInfo.resolvedMimeType)) {
                return false;
            }
            this.parameters.getClass();
            return this.usesPrimaryOrFallbackDecoder == videoTrackInfo.usesPrimaryOrFallbackDecoder && this.usesHardwareAcceleration == videoTrackInfo.usesHardwareAcceleration;
        }
    }

    public DefaultTrackSelector(Context context) {
        CueDecoder cueDecoder = new CueDecoder((byte) 5);
        Parameters parameters = Parameters.DEFAULT;
        this.lock = new Object();
        this.context = context != null ? context.getApplicationContext() : null;
        this.trackSelectionFactory = cueDecoder;
        if (parameters != null) {
            this.parameters = parameters;
        } else {
            parameters.getClass();
            Parameters.Builder builder = new Parameters.Builder(parameters);
            builder.init(parameters);
            parameters = new Parameters(builder);
            this.parameters = parameters;
        }
        this.audioAttributes = AudioAttributes.DEFAULT;
        if (parameters.constrainAudioChannelCountToDeviceCapabilities && context == null) {
            Log.w("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    public static void applyLegacyRendererOverrides(MappingTrackSelector$MappedTrackInfo mappingTrackSelector$MappedTrackInfo, Parameters parameters, ExoTrackSelection.Definition[] definitionArr) {
        int i = mappingTrackSelector$MappedTrackInfo.rendererCount;
        for (int i2 = 0; i2 < i; i2++) {
            TrackGroupArray trackGroupArray = mappingTrackSelector$MappedTrackInfo.rendererTrackGroups[i2];
            Map map = (Map) parameters.selectionOverrides.get(i2);
            if (map != null && map.containsKey(trackGroupArray)) {
                Map map2 = (Map) parameters.selectionOverrides.get(i2);
                if (map2 != null && map2.get(trackGroupArray) != null) {
                    PathKt$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                definitionArr[i2] = null;
            }
        }
    }

    public static void applyRendererDisableOverrides(MappingTrackSelector$MappedTrackInfo mappingTrackSelector$MappedTrackInfo, Parameters parameters, ExoTrackSelection.Definition[] definitionArr) {
        for (int i = 0; i < mappingTrackSelector$MappedTrackInfo.rendererCount; i++) {
            int i2 = mappingTrackSelector$MappedTrackInfo.rendererTrackTypes[i];
            if (parameters.rendererDisabledFlags.get(i) || parameters.disabledTrackTypes.contains(Integer.valueOf(i2))) {
                definitionArr[i] = null;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0050  */
    public static void applyTrackSelectionOverrides(MappingTrackSelector$MappedTrackInfo mappingTrackSelector$MappedTrackInfo, TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Definition[] definitionArr) {
        ExoTrackSelection.Definition definition;
        int i = mappingTrackSelector$MappedTrackInfo.rendererCount;
        TrackGroupArray[] trackGroupArrayArr = mappingTrackSelector$MappedTrackInfo.rendererTrackGroups;
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < i; i2++) {
            collectTrackSelectionOverrides(trackGroupArrayArr[i2], trackSelectionParameters, map);
        }
        collectTrackSelectionOverrides(mappingTrackSelector$MappedTrackInfo.unmappedTrackGroups, trackSelectionParameters, map);
        for (int i3 = 0; i3 < i; i3++) {
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) map.get(Integer.valueOf(mappingTrackSelector$MappedTrackInfo.rendererTrackTypes[i3]));
            if (trackSelectionOverride != null) {
                TrackGroup trackGroup = trackSelectionOverride.mediaTrackGroup;
                ImmutableList immutableList = trackSelectionOverride.trackIndices;
                if (immutableList.isEmpty()) {
                    definition = null;
                } else {
                    int iIndexOf = trackGroupArrayArr[i3].trackGroups.indexOf(trackGroup);
                    if (iIndexOf < 0) {
                        iIndexOf = -1;
                    }
                    if (iIndexOf != -1) {
                        definition = new ExoTrackSelection.Definition(trackGroup, StringsKt__IndentKt.toArray(immutableList));
                    } else {
                        definition = null;
                    }
                }
                definitionArr[i3] = definition;
            }
        }
    }

    public static void collectTrackSelectionOverrides(TrackGroupArray trackGroupArray, TrackSelectionParameters trackSelectionParameters, HashMap map) {
        for (int i = 0; i < trackGroupArray.length; i++) {
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) trackSelectionParameters.overrides.get(trackGroupArray.get(i));
            if (trackSelectionOverride != null) {
                int i2 = trackSelectionOverride.mediaTrackGroup.type;
                TrackSelectionOverride trackSelectionOverride2 = (TrackSelectionOverride) map.get(Integer.valueOf(i2));
                if (trackSelectionOverride2 == null || (trackSelectionOverride2.trackIndices.isEmpty() && !trackSelectionOverride.trackIndices.isEmpty())) {
                    map.put(Integer.valueOf(i2), trackSelectionOverride);
                }
            }
        }
    }

    public static Pair findDefinitionForType(ExoTrackSelection.Definition[] definitionArr, int i) {
        for (int i2 = 0; i2 < definitionArr.length; i2++) {
            ExoTrackSelection.Definition definition = definitionArr[i2];
            if (definition != null && definition.group.type == i) {
                return Pair.create(definition, Integer.valueOf(i2));
            }
        }
        return null;
    }

    public static int getBestLabelMatchIndex(Format format, ImmutableList immutableList) {
        for (int i = 0; i < immutableList.size(); i++) {
            for (int i2 = 0; i2 < format.labels.size(); i2++) {
                if (((Label) format.labels.get(i2)).value.equals(immutableList.get(i))) {
                    return i;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static int getFormatLanguageScore(Format format, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(format.language)) {
            return 4;
        }
        String strNormalizeUndeterminedLanguageToNull = normalizeUndeterminedLanguageToNull(str);
        String strNormalizeUndeterminedLanguageToNull2 = normalizeUndeterminedLanguageToNull(format.language);
        if (strNormalizeUndeterminedLanguageToNull2 == null || strNormalizeUndeterminedLanguageToNull == null) {
            return (z && strNormalizeUndeterminedLanguageToNull2 == null) ? 1 : 0;
        }
        if (strNormalizeUndeterminedLanguageToNull2.startsWith(strNormalizeUndeterminedLanguageToNull) || strNormalizeUndeterminedLanguageToNull.startsWith(strNormalizeUndeterminedLanguageToNull2)) {
            return 3;
        }
        String str2 = Util.DEVICE_DEBUG_INFO;
        return strNormalizeUndeterminedLanguageToNull2.split("-", 2)[0].equals(strNormalizeUndeterminedLanguageToNull.split("-", 2)[0]) ? 2 : 0;
    }

    public static String normalizeUndeterminedLanguageToNull(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static boolean rendererSupportsOffload(Parameters parameters, int i, Format format) {
        if ((i & 3584) == 0) {
            return false;
        }
        TrackSelectionParameters.AudioOffloadPreferences audioOffloadPreferences = parameters.audioOffloadPreferences;
        if (audioOffloadPreferences.isSpeedChangeSupportRequired && (i & 2048) == 0) {
            return false;
        }
        if (audioOffloadPreferences.isGaplessSupportRequired) {
            boolean z = (format.encoderDelay == 0 && format.encoderPadding == 0) ? false : true;
            boolean z2 = (i & 1024) != 0;
            if (z && !z2) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004c  */
    public static ExoTrackSelection.Definition selectOtherTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) {
        if (parameters.audioOffloadPreferences.audioOffloadMode != 2) {
            int i = 0;
            TrackGroup trackGroup = null;
            OtherTrackScore otherTrackScore = null;
            for (int i2 = 0; i2 < trackGroupArray.length; i2++) {
                TrackGroup trackGroup2 = trackGroupArray.get(i2);
                int[] iArr2 = iArr[i2];
                for (int i3 = 0; i3 < trackGroup2.length; i3++) {
                    if (BaseRenderer.isFormatSupported(iArr2[i3], parameters.exceedRendererCapabilitiesIfNecessary)) {
                        OtherTrackScore otherTrackScore2 = new OtherTrackScore(trackGroup2.formats[i3], iArr2[i3]);
                        if (otherTrackScore != null) {
                            if (ComparisonChain.ACTIVE.compareFalseFirst(otherTrackScore2.isWithinRendererCapabilities, otherTrackScore.isWithinRendererCapabilities).compareFalseFirst(otherTrackScore2.isDefault, otherTrackScore.isDefault).result() > 0) {
                                trackGroup = trackGroup2;
                                i = i3;
                                otherTrackScore = otherTrackScore2;
                            }
                        } else {
                            trackGroup = trackGroup2;
                            i = i3;
                            otherTrackScore = otherTrackScore2;
                        }
                    }
                }
            }
            if (trackGroup != null) {
                return new ExoTrackSelection.Definition(trackGroup, i);
            }
        }
        return null;
    }

    public static Pair selectTracksForType(int i, MappingTrackSelector$MappedTrackInfo mappingTrackSelector$MappedTrackInfo, int[][][] iArr, TrackInfo.Factory factory, Comparator comparator) {
        int i2;
        RandomAccess randomAccessOf;
        MappingTrackSelector$MappedTrackInfo mappingTrackSelector$MappedTrackInfo2 = mappingTrackSelector$MappedTrackInfo;
        ArrayList arrayList = new ArrayList();
        int i3 = mappingTrackSelector$MappedTrackInfo2.rendererCount;
        int i4 = 0;
        while (i4 < i3) {
            if (i == mappingTrackSelector$MappedTrackInfo2.rendererTrackTypes[i4]) {
                TrackGroupArray trackGroupArray = mappingTrackSelector$MappedTrackInfo2.rendererTrackGroups[i4];
                for (int i5 = 0; i5 < trackGroupArray.length; i5++) {
                    TrackGroup trackGroup = trackGroupArray.get(i5);
                    RegularImmutableList regularImmutableListCreate = factory.create(i4, trackGroup, iArr[i4][i5]);
                    int i6 = trackGroup.length;
                    boolean[] zArr = new boolean[i6];
                    int i7 = 0;
                    while (i7 < i6) {
                        TrackInfo trackInfo = (TrackInfo) regularImmutableListCreate.get(i7);
                        int selectionEligibility = trackInfo.getSelectionEligibility();
                        if (zArr[i7] || selectionEligibility == 0) {
                            i2 = i3;
                        } else {
                            if (selectionEligibility == 1) {
                                randomAccessOf = ImmutableList.of((Object) trackInfo);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(trackInfo);
                                int i8 = i7 + 1;
                                while (i8 < i6) {
                                    TrackInfo trackInfo2 = (TrackInfo) regularImmutableListCreate.get(i8);
                                    int i9 = i3;
                                    if (trackInfo2.getSelectionEligibility() == 2 && trackInfo.isCompatibleForAdaptationWith(trackInfo2)) {
                                        arrayList2.add(trackInfo2);
                                        zArr[i8] = true;
                                    }
                                    i8++;
                                    i3 = i9;
                                }
                                randomAccessOf = arrayList2;
                            }
                            i2 = i3;
                            arrayList.add(randomAccessOf);
                        }
                        i7++;
                        i3 = i2;
                    }
                }
            }
            i4++;
            mappingTrackSelector$MappedTrackInfo2 = mappingTrackSelector$MappedTrackInfo;
            i3 = i3;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            iArr2[i10] = ((TrackInfo) list.get(i10)).trackIndex;
        }
        TrackInfo trackInfo3 = (TrackInfo) list.get(0);
        return Pair.create(new ExoTrackSelection.Definition(trackInfo3.trackGroup, iArr2), Integer.valueOf(trackInfo3.rendererIndex));
    }

    public final Parameters getParameters() {
        Parameters parameters;
        synchronized (this.lock) {
            parameters = this.parameters;
        }
        return parameters;
    }

    public final void maybeInvalidateForAudioChannelCountConstraints() {
        boolean z;
        ExoPlayerImplInternal exoPlayerImplInternal;
        SpatializerWrapper spatializerWrapper;
        synchronized (this.lock) {
            try {
                z = this.parameters.constrainAudioChannelCountToDeviceCapabilities && Build.VERSION.SDK_INT >= 32 && (spatializerWrapper = this.spatializer) != null && spatializerWrapper.spatializationSupported;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z || (exoPlayerImplInternal = this.listener) == null) {
            return;
        }
        exoPlayerImplInternal.handler.sendEmptyMessage(10);
    }

    public final void release() {
        SpatializerWrapper spatializerWrapper;
        synchronized (this.lock) {
            try {
                Thread thread = this.playbackThread;
                if (thread != null) {
                    UtilsKt.checkState("DefaultTrackSelector is accessed on the wrong thread.", thread == Thread.currentThread());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (Build.VERSION.SDK_INT >= 32 && (spatializerWrapper = this.spatializer) != null) {
            spatializerWrapper.release();
            this.spatializer = null;
        }
        this.listener = null;
        this.bandwidthMeter = null;
    }

    public final void setParametersInternal(Parameters parameters) {
        boolean zEquals;
        synchronized (this.lock) {
            zEquals = this.parameters.equals(parameters);
            this.parameters = parameters;
        }
        if (zEquals) {
            return;
        }
        if (parameters.constrainAudioChannelCountToDeviceCapabilities && this.context == null) {
            Log.w("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
        ExoPlayerImplInternal exoPlayerImplInternal = this.listener;
        if (exoPlayerImplInternal != null) {
            exoPlayerImplInternal.handler.sendEmptyMessage(10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Parameters extends TrackSelectionParameters {
        public static final Parameters DEFAULT = new Parameters(new Builder());
        public static final String FIELD_ALLOW_AUDIO_MIXED_CHANNEL_COUNT_ADAPTIVENESS;
        public static final String FIELD_ALLOW_AUDIO_MIXED_DECODER_SUPPORT_ADAPTIVENESS;
        public static final String FIELD_ALLOW_AUDIO_MIXED_MIME_TYPE_ADAPTIVENESS;
        public static final String FIELD_ALLOW_AUDIO_MIXED_SAMPLE_RATE_ADAPTIVENESS;
        public static final String FIELD_ALLOW_AUDIO_NON_SEAMLESS_ADAPTIVENESS;
        public static final String FIELD_ALLOW_INVALIDATE_SELECTIONS_ON_RENDERER_CAPABILITIES_CHANGE;
        public static final String FIELD_ALLOW_MULTIPLE_ADAPTIVE_SELECTIONS;
        public static final String FIELD_ALLOW_VIDEO_MIXED_DECODER_SUPPORT_ADAPTIVENESS;
        public static final String FIELD_ALLOW_VIDEO_MIXED_MIME_TYPE_ADAPTIVENESS;
        public static final String FIELD_ALLOW_VIDEO_NON_SEAMLESS_ADAPTIVENESS;
        public static final String FIELD_CONSTRAIN_AUDIO_CHANNEL_COUNT_TO_DEVICE_CAPABILITIES;
        public static final String FIELD_EXCEED_AUDIO_CONSTRAINTS_IF_NECESSARY;
        public static final String FIELD_EXCEED_RENDERER_CAPABILITIES_IF_NECESSARY;
        public static final String FIELD_EXCEED_VIDEO_CONSTRAINTS_IF_NECESSARY;
        public static final String FIELD_RENDERER_DISABLED_INDICES;
        public static final String FIELD_SELECTION_OVERRIDES;
        public static final String FIELD_SELECTION_OVERRIDES_RENDERER_INDICES;
        public static final String FIELD_SELECTION_OVERRIDES_TRACK_GROUP_ARRAYS;
        public static final String FIELD_TUNNELING_ENABLED;
        public final boolean allowAudioNonSeamlessAdaptiveness;
        public final boolean allowMultipleAdaptiveSelections;
        public final boolean allowVideoNonSeamlessAdaptiveness;
        public final boolean constrainAudioChannelCountToDeviceCapabilities;
        public final boolean exceedAudioConstraintsIfNecessary;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        public final SparseBooleanArray rendererDisabledFlags;
        public final SparseArray selectionOverrides;

        static {
            String str = Util.DEVICE_DEBUG_INFO;
            FIELD_EXCEED_VIDEO_CONSTRAINTS_IF_NECESSARY = Integer.toString(CIOKt.DEFAULT_HTTP_POOL_SIZE, 36);
            FIELD_ALLOW_VIDEO_MIXED_MIME_TYPE_ADAPTIVENESS = Integer.toString(1001, 36);
            FIELD_ALLOW_VIDEO_NON_SEAMLESS_ADAPTIVENESS = Integer.toString(1002, 36);
            FIELD_EXCEED_AUDIO_CONSTRAINTS_IF_NECESSARY = Integer.toString(1003, 36);
            FIELD_ALLOW_AUDIO_MIXED_MIME_TYPE_ADAPTIVENESS = Integer.toString(1004, 36);
            FIELD_ALLOW_AUDIO_MIXED_SAMPLE_RATE_ADAPTIVENESS = Integer.toString(1005, 36);
            FIELD_ALLOW_AUDIO_MIXED_CHANNEL_COUNT_ADAPTIVENESS = Integer.toString(1006, 36);
            FIELD_EXCEED_RENDERER_CAPABILITIES_IF_NECESSARY = Integer.toString(1007, 36);
            FIELD_TUNNELING_ENABLED = Integer.toString(1008, 36);
            FIELD_ALLOW_MULTIPLE_ADAPTIVE_SELECTIONS = Integer.toString(1009, 36);
            FIELD_SELECTION_OVERRIDES_RENDERER_INDICES = Integer.toString(1010, 36);
            FIELD_SELECTION_OVERRIDES_TRACK_GROUP_ARRAYS = Integer.toString(1011, 36);
            FIELD_SELECTION_OVERRIDES = Integer.toString(1012, 36);
            FIELD_RENDERER_DISABLED_INDICES = Integer.toString(1013, 36);
            FIELD_ALLOW_VIDEO_MIXED_DECODER_SUPPORT_ADAPTIVENESS = Integer.toString(1014, 36);
            FIELD_ALLOW_AUDIO_MIXED_DECODER_SUPPORT_ADAPTIVENESS = Integer.toString(1015, 36);
            FIELD_CONSTRAIN_AUDIO_CHANNEL_COUNT_TO_DEVICE_CAPABILITIES = Integer.toString(1016, 36);
            FIELD_ALLOW_INVALIDATE_SELECTIONS_ON_RENDERER_CAPABILITIES_CHANGE = Integer.toString(1017, 36);
            FIELD_ALLOW_AUDIO_NON_SEAMLESS_ADAPTIVENESS = Integer.toString(1018, 36);
        }

        public Parameters(Builder builder) {
            super(builder);
            this.exceedVideoConstraintsIfNecessary = builder.exceedVideoConstraintsIfNecessary;
            this.allowVideoNonSeamlessAdaptiveness = builder.allowVideoNonSeamlessAdaptiveness;
            this.exceedAudioConstraintsIfNecessary = builder.exceedAudioConstraintsIfNecessary;
            this.allowAudioNonSeamlessAdaptiveness = builder.allowAudioNonSeamlessAdaptiveness;
            this.constrainAudioChannelCountToDeviceCapabilities = builder.constrainAudioChannelCountToDeviceCapabilities;
            this.exceedRendererCapabilitiesIfNecessary = builder.exceedRendererCapabilitiesIfNecessary;
            this.allowMultipleAdaptiveSelections = builder.allowMultipleAdaptiveSelections;
            this.selectionOverrides = builder.selectionOverrides;
            this.rendererDisabledFlags = builder.rendererDisabledFlags;
        }

        @Override // androidx.media3.common.TrackSelectionParameters
        public final TrackSelectionParameters.Builder buildUpon() {
            return new Builder(this);
        }

        @Override // androidx.media3.common.TrackSelectionParameters
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Parameters.class == obj.getClass()) {
                Parameters parameters = (Parameters) obj;
                if (super.equals(parameters) && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.allowVideoNonSeamlessAdaptiveness == parameters.allowVideoNonSeamlessAdaptiveness && this.exceedAudioConstraintsIfNecessary == parameters.exceedAudioConstraintsIfNecessary && this.allowAudioNonSeamlessAdaptiveness == parameters.allowAudioNonSeamlessAdaptiveness && this.constrainAudioChannelCountToDeviceCapabilities == parameters.constrainAudioChannelCountToDeviceCapabilities && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.allowMultipleAdaptiveSelections == parameters.allowMultipleAdaptiveSelections) {
                    SparseBooleanArray sparseBooleanArray = parameters.rendererDisabledFlags;
                    SparseBooleanArray sparseBooleanArray2 = this.rendererDisabledFlags;
                    int size = sparseBooleanArray2.size();
                    if (sparseBooleanArray.size() == size) {
                        for (int i = 0; i < size; i++) {
                            if (sparseBooleanArray.indexOfKey(sparseBooleanArray2.keyAt(i)) >= 0) {
                            }
                        }
                        SparseArray sparseArray = parameters.selectionOverrides;
                        SparseArray sparseArray2 = this.selectionOverrides;
                        int size2 = sparseArray2.size();
                        if (sparseArray.size() == size2) {
                            for (int i2 = 0; i2 < size2; i2++) {
                                int iIndexOfKey = sparseArray.indexOfKey(sparseArray2.keyAt(i2));
                                if (iIndexOfKey >= 0) {
                                    Map map = (Map) sparseArray2.valueAt(i2);
                                    Map map2 = (Map) sparseArray.valueAt(iIndexOfKey);
                                    if (map2.size() == map.size()) {
                                        for (Map.Entry entry : map.entrySet()) {
                                            TrackGroupArray trackGroupArray = (TrackGroupArray) entry.getKey();
                                            if (!map2.containsKey(trackGroupArray) || !Objects.equals(entry.getValue(), map2.get(trackGroupArray))) {
                                            }
                                        }
                                    }
                                }
                            }
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        @Override // androidx.media3.common.TrackSelectionParameters
        public final int hashCode() {
            return (((((((((((((((super.hashCode() + 31) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 961) + (this.allowVideoNonSeamlessAdaptiveness ? 1 : 0)) * 961) + (this.exceedAudioConstraintsIfNecessary ? 1 : 0)) * 28629151) + (this.allowAudioNonSeamlessAdaptiveness ? 1 : 0)) * 31) + (this.constrainAudioChannelCountToDeviceCapabilities ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 961) + (this.allowMultipleAdaptiveSelections ? 1 : 0)) * 31;
        }

        @Override // androidx.media3.common.TrackSelectionParameters
        public final Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putBoolean(FIELD_EXCEED_VIDEO_CONSTRAINTS_IF_NECESSARY, this.exceedVideoConstraintsIfNecessary);
            bundle.putBoolean(FIELD_ALLOW_VIDEO_MIXED_MIME_TYPE_ADAPTIVENESS, false);
            bundle.putBoolean(FIELD_ALLOW_VIDEO_NON_SEAMLESS_ADAPTIVENESS, this.allowVideoNonSeamlessAdaptiveness);
            bundle.putBoolean(FIELD_ALLOW_VIDEO_MIXED_DECODER_SUPPORT_ADAPTIVENESS, false);
            bundle.putBoolean(FIELD_EXCEED_AUDIO_CONSTRAINTS_IF_NECESSARY, this.exceedAudioConstraintsIfNecessary);
            bundle.putBoolean(FIELD_ALLOW_AUDIO_MIXED_MIME_TYPE_ADAPTIVENESS, false);
            bundle.putBoolean(FIELD_ALLOW_AUDIO_MIXED_SAMPLE_RATE_ADAPTIVENESS, false);
            bundle.putBoolean(FIELD_ALLOW_AUDIO_MIXED_CHANNEL_COUNT_ADAPTIVENESS, false);
            bundle.putBoolean(FIELD_ALLOW_AUDIO_MIXED_DECODER_SUPPORT_ADAPTIVENESS, false);
            bundle.putBoolean(FIELD_ALLOW_AUDIO_NON_SEAMLESS_ADAPTIVENESS, this.allowAudioNonSeamlessAdaptiveness);
            bundle.putBoolean(FIELD_CONSTRAIN_AUDIO_CHANNEL_COUNT_TO_DEVICE_CAPABILITIES, this.constrainAudioChannelCountToDeviceCapabilities);
            bundle.putBoolean(FIELD_EXCEED_RENDERER_CAPABILITIES_IF_NECESSARY, this.exceedRendererCapabilitiesIfNecessary);
            bundle.putBoolean(FIELD_TUNNELING_ENABLED, false);
            bundle.putBoolean(FIELD_ALLOW_MULTIPLE_ADAPTIVE_SELECTIONS, this.allowMultipleAdaptiveSelections);
            bundle.putBoolean(FIELD_ALLOW_INVALIDATE_SELECTIONS_ON_RENDERER_CAPABILITIES_CHANGE, false);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray = new SparseArray();
            int i = 0;
            while (true) {
                SparseArray sparseArray2 = this.selectionOverrides;
                if (i >= sparseArray2.size()) {
                    SparseBooleanArray sparseBooleanArray = this.rendererDisabledFlags;
                    int[] iArr = new int[sparseBooleanArray.size()];
                    for (int i2 = 0; i2 < sparseBooleanArray.size(); i2++) {
                        iArr[i2] = sparseBooleanArray.keyAt(i2);
                    }
                    bundle.putIntArray(FIELD_RENDERER_DISABLED_INDICES, iArr);
                    return bundle;
                }
                int iKeyAt = sparseArray2.keyAt(i);
                for (Map.Entry entry : ((Map) sparseArray2.valueAt(i)).entrySet()) {
                    if (entry.getValue() != null) {
                        PathKt$$ExternalSyntheticBUOutline0.m();
                        return null;
                    }
                    arrayList2.add((TrackGroupArray) entry.getKey());
                    arrayList.add(Integer.valueOf(iKeyAt));
                }
                bundle.putIntArray(FIELD_SELECTION_OVERRIDES_RENDERER_INDICES, StringsKt__IndentKt.toArray(arrayList));
                bundle.putParcelableArrayList(FIELD_SELECTION_OVERRIDES_TRACK_GROUP_ARRAYS, GlUtil.toBundleArrayList(arrayList2, new Format$$ExternalSyntheticLambda1((byte) 15)));
                SparseArray<? extends Parcelable> sparseArray3 = new SparseArray<>(sparseArray.size());
                if (sparseArray.size() > 0) {
                    sparseArray.keyAt(0);
                    Fragment$5$$ExternalSyntheticOutline0.m833m(sparseArray.valueAt(0));
                    throw null;
                }
                bundle.putSparseParcelableArray(FIELD_SELECTION_OVERRIDES, sparseArray3);
                i++;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Builder extends TrackSelectionParameters.Builder {
            public final boolean allowAudioNonSeamlessAdaptiveness;
            public final boolean allowMultipleAdaptiveSelections;
            public final boolean allowVideoNonSeamlessAdaptiveness;
            public final boolean constrainAudioChannelCountToDeviceCapabilities;
            public final boolean exceedAudioConstraintsIfNecessary;
            public final boolean exceedRendererCapabilitiesIfNecessary;
            public final boolean exceedVideoConstraintsIfNecessary;
            public final SparseBooleanArray rendererDisabledFlags;
            public final SparseArray selectionOverrides;

            public Builder(Parameters parameters) {
                init(parameters);
                this.exceedVideoConstraintsIfNecessary = parameters.exceedVideoConstraintsIfNecessary;
                this.allowVideoNonSeamlessAdaptiveness = parameters.allowVideoNonSeamlessAdaptiveness;
                this.exceedAudioConstraintsIfNecessary = parameters.exceedAudioConstraintsIfNecessary;
                this.allowAudioNonSeamlessAdaptiveness = parameters.allowAudioNonSeamlessAdaptiveness;
                this.constrainAudioChannelCountToDeviceCapabilities = parameters.constrainAudioChannelCountToDeviceCapabilities;
                this.exceedRendererCapabilitiesIfNecessary = parameters.exceedRendererCapabilitiesIfNecessary;
                this.allowMultipleAdaptiveSelections = parameters.allowMultipleAdaptiveSelections;
                SparseArray sparseArray = parameters.selectionOverrides;
                SparseArray sparseArray2 = new SparseArray();
                for (int i = 0; i < sparseArray.size(); i++) {
                    sparseArray2.put(sparseArray.keyAt(i), new HashMap((Map) sparseArray.valueAt(i)));
                }
                this.selectionOverrides = sparseArray2;
                this.rendererDisabledFlags = parameters.rendererDisabledFlags.clone();
            }

            @Override // androidx.media3.common.TrackSelectionParameters.Builder
            public final void addOverride(TrackSelectionOverride trackSelectionOverride) {
                this.overrides.put(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
            }

            @Override // androidx.media3.common.TrackSelectionParameters.Builder
            public final TrackSelectionParameters build() {
                return new Parameters(this);
            }

            @Override // androidx.media3.common.TrackSelectionParameters.Builder
            public final TrackSelectionParameters.Builder clearOverrides() {
                super.clearOverrides();
                return this;
            }

            @Override // androidx.media3.common.TrackSelectionParameters.Builder
            public final TrackSelectionParameters.Builder setAudioOffloadPreferences(TrackSelectionParameters.AudioOffloadPreferences audioOffloadPreferences) {
                this.audioOffloadPreferences = audioOffloadPreferences;
                return this;
            }

            public Builder() {
                this.selectionOverrides = new SparseArray();
                this.rendererDisabledFlags = new SparseBooleanArray();
                this.exceedVideoConstraintsIfNecessary = true;
                this.allowVideoNonSeamlessAdaptiveness = true;
                this.exceedAudioConstraintsIfNecessary = true;
                this.allowAudioNonSeamlessAdaptiveness = true;
                this.constrainAudioChannelCountToDeviceCapabilities = true;
                this.exceedRendererCapabilitiesIfNecessary = true;
                this.allowMultipleAdaptiveSelections = true;
            }
        }
    }
}
