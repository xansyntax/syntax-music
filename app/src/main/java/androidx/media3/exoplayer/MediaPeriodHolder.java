package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Build;
import android.util.Pair;
import android.view.accessibility.CaptioningManager;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda1;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.ClippingMediaPeriod;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection$AdaptationCheckpoint;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.FixedTrackSelection;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector$MappedTrackInfo;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.util.SpatializerWrapper;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda24;
import androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda81;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder$ArrayListSupplier;
import com.google.common.collect.Multimaps$CustomListMultimap;
import com.google.common.collect.NaturalOrdering;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaPeriodHolder {
    public boolean allRenderersInCorrectState;
    public boolean hasEnabledTracks;
    public MediaPeriodInfo info;
    public final boolean[] mayRetainStreamFlags;
    public final MediaPeriod mediaPeriod;
    public final MediaSourceList mediaSourceList;
    public MediaPeriodHolder next;
    public boolean prepareCalled;
    public boolean prepared;
    public final BaseRenderer[] rendererCapabilities;
    public long rendererPositionOffsetUs;
    public final SampleStream[] sampleStreams;
    public TrackGroupArray trackGroups;
    public final DefaultTrackSelector trackSelector;
    public TrackSelectorResult trackSelectorResult;
    public final Object uid;

    public MediaPeriodHolder(BaseRenderer[] baseRendererArr, long j, DefaultTrackSelector defaultTrackSelector, EmojiProcessor emojiProcessor, MediaSourceList mediaSourceList, MediaPeriodInfo mediaPeriodInfo, TrackSelectorResult trackSelectorResult) {
        this.rendererCapabilities = baseRendererArr;
        this.rendererPositionOffsetUs = j;
        this.trackSelector = defaultTrackSelector;
        this.mediaSourceList = mediaSourceList;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = mediaPeriodInfo.id;
        Object obj = mediaSource$MediaPeriodId.periodUid;
        this.uid = obj;
        this.info = mediaPeriodInfo;
        this.trackGroups = TrackGroupArray.EMPTY;
        this.trackSelectorResult = trackSelectorResult;
        this.sampleStreams = new SampleStream[baseRendererArr.length];
        this.mayRetainStreamFlags = new boolean[baseRendererArr.length];
        long j2 = mediaPeriodInfo.startPositionUs;
        long j3 = mediaPeriodInfo.endPositionUs;
        boolean z = mediaPeriodInfo.isPrecededByTransitionFromSameStream;
        mediaSourceList.getClass();
        int i = PlaylistTimeline.$r8$clinit;
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodIdCopyWithPeriodUid = mediaSource$MediaPeriodId.copyWithPeriodUid(pair.second);
        MediaSourceList.MediaSourceHolder mediaSourceHolder = (MediaSourceList.MediaSourceHolder) mediaSourceList.mediaSourceByUid.get(obj2);
        mediaSourceHolder.getClass();
        mediaSourceList.enabledMediaSourceHolders.add(mediaSourceHolder);
        MediaSourceList.MediaSourceAndListener mediaSourceAndListener = (MediaSourceList.MediaSourceAndListener) mediaSourceList.childSources.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.mediaSource.enable(mediaSourceAndListener.caller);
        }
        mediaSourceHolder.activeMediaPeriodIds.add(mediaSource$MediaPeriodIdCopyWithPeriodUid);
        MediaPeriod mediaPeriodCreatePeriod = mediaSourceHolder.mediaSource.createPeriod(mediaSource$MediaPeriodIdCopyWithPeriodUid, emojiProcessor, j2);
        mediaSourceList.mediaSourceByMediaPeriod.put(mediaPeriodCreatePeriod, mediaSourceHolder);
        mediaSourceList.disableUnusedMediaSources();
        this.mediaPeriod = j3 != -9223372036854775807L ? new ClippingMediaPeriod(mediaPeriodCreatePeriod, !z, 0L, j3, 0) : mediaPeriodCreatePeriod;
    }

    public final long applyTrackSelection(TrackSelectorResult trackSelectorResult, long j, boolean z, boolean[] zArr) {
        boolean[] zArr2;
        BaseRenderer[] baseRendererArr;
        boolean[] zArr3;
        SampleStream[] sampleStreamArr;
        ExoTrackSelection[] exoTrackSelectionArr = trackSelectorResult.selections;
        int i = 0;
        while (true) {
            int i2 = trackSelectorResult.length;
            zArr2 = this.mayRetainStreamFlags;
            boolean z2 = true;
            if (i >= i2) {
                break;
            }
            if (z || !trackSelectorResult.isEquivalent(this.trackSelectorResult, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        int i3 = 0;
        while (true) {
            baseRendererArr = this.rendererCapabilities;
            int length = baseRendererArr.length;
            zArr3 = zArr2;
            sampleStreamArr = this.sampleStreams;
            if (i3 >= length) {
                break;
            }
            if (baseRendererArr[i3].trackType == -2) {
                sampleStreamArr[i3] = null;
            }
            i3++;
            zArr2 = zArr3;
        }
        disableTrackSelectionsInResult();
        this.trackSelectorResult = trackSelectorResult;
        enableTrackSelectionsInResult();
        long jSelectTracks = this.mediaPeriod.selectTracks(exoTrackSelectionArr, zArr3, sampleStreamArr, zArr, j);
        for (int i4 = 0; i4 < baseRendererArr.length; i4++) {
            if (baseRendererArr[i4].trackType == -2 && this.trackSelectorResult.isRendererEnabled(i4)) {
                sampleStreamArr[i4] = new CueDecoder((byte) 4);
            }
        }
        this.hasEnabledTracks = false;
        for (int i5 = 0; i5 < sampleStreamArr.length; i5++) {
            if (sampleStreamArr[i5] != null) {
                UtilsKt.checkState(trackSelectorResult.isRendererEnabled(i5));
                if (baseRendererArr[i5].trackType != -2) {
                    this.hasEnabledTracks = true;
                }
            } else {
                UtilsKt.checkState(exoTrackSelectionArr[i5] == null);
            }
        }
        return jSelectTracks;
    }

    public final void disableTrackSelectionsInResult() {
        if (this.next != null) {
            return;
        }
        int i = 0;
        while (true) {
            TrackSelectorResult trackSelectorResult = this.trackSelectorResult;
            if (i >= trackSelectorResult.length) {
                return;
            }
            boolean zIsRendererEnabled = trackSelectorResult.isRendererEnabled(i);
            ExoTrackSelection exoTrackSelection = this.trackSelectorResult.selections[i];
            if (zIsRendererEnabled && exoTrackSelection != null) {
                exoTrackSelection.disable();
            }
            i++;
        }
    }

    public final void enableTrackSelectionsInResult() {
        if (this.next != null) {
            return;
        }
        int i = 0;
        while (true) {
            TrackSelectorResult trackSelectorResult = this.trackSelectorResult;
            if (i >= trackSelectorResult.length) {
                return;
            }
            boolean zIsRendererEnabled = trackSelectorResult.isRendererEnabled(i);
            ExoTrackSelection exoTrackSelection = this.trackSelectorResult.selections[i];
            if (zIsRendererEnabled && exoTrackSelection != null) {
                exoTrackSelection.enable();
            }
            i++;
        }
    }

    public final long getBufferedPositionUs() {
        if (!this.prepared) {
            return this.info.startPositionUs;
        }
        long bufferedPositionUs = this.hasEnabledTracks ? this.mediaPeriod.getBufferedPositionUs() : Long.MIN_VALUE;
        return bufferedPositionUs == Long.MIN_VALUE ? this.info.durationUs : bufferedPositionUs;
    }

    public final long getStartPositionRendererTime() {
        return this.info.startPositionUs + this.rendererPositionOffsetUs;
    }

    public final void handlePrepared(float f, Timeline timeline, boolean z) {
        this.prepared = true;
        this.trackGroups = this.mediaPeriod.getTrackGroups();
        TrackSelectorResult trackSelectorResultSelectTracks = selectTracks(f, timeline, z);
        MediaPeriodInfo mediaPeriodInfo = this.info;
        long jMax = mediaPeriodInfo.startPositionUs;
        long j = mediaPeriodInfo.durationUs;
        if (j != -9223372036854775807L && jMax >= j) {
            jMax = Math.max(0L, j - 1);
        }
        long jApplyTrackSelection = applyTrackSelection(trackSelectorResultSelectTracks, jMax, false, new boolean[this.rendererCapabilities.length]);
        long j2 = this.rendererPositionOffsetUs;
        MediaPeriodInfo mediaPeriodInfo2 = this.info;
        this.rendererPositionOffsetUs = (mediaPeriodInfo2.startPositionUs - jApplyTrackSelection) + j2;
        this.info = mediaPeriodInfo2.copyWithStartPositionUs(jApplyTrackSelection, mediaPeriodInfo2.liveStreamStartPositionProjectionUs);
    }

    public final boolean isFullyBuffered() {
        if (this.prepared) {
            return !this.hasEnabledTracks || this.mediaPeriod.getBufferedPositionUs() == Long.MIN_VALUE;
        }
        return false;
    }

    public final boolean isFullyPreloaded() {
        if (this.prepared) {
            return isFullyBuffered() || getBufferedPositionUs() - this.info.startPositionUs >= -9223372036854775807L;
        }
        return false;
    }

    public final void release() {
        disableTrackSelectionsInResult();
        MediaPeriod mediaPeriod = this.mediaPeriod;
        try {
            boolean z = mediaPeriod instanceof ClippingMediaPeriod;
            MediaSourceList mediaSourceList = this.mediaSourceList;
            if (z) {
                mediaSourceList.releasePeriod(((ClippingMediaPeriod) mediaPeriod).mediaPeriod);
            } else {
                mediaSourceList.releasePeriod(mediaPeriod);
            }
        } catch (RuntimeException e) {
            Log.e("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:145:0x02f7  */
    /* JADX WARN: Type inference failed for: r12v0, types: [int[], java.lang.Cloneable] */
    public final TrackSelectorResult selectTracks(float f, Timeline timeline, boolean z) {
        final DefaultTrackSelector.Parameters parameters;
        String str;
        int[] iArr;
        TrackGroupArray[] trackGroupArrayArr;
        int[][][] iArr2;
        int[] iArr3;
        TrackGroupArray[] trackGroupArrayArr2;
        int i;
        RegularImmutableList regularImmutableListOf;
        FixedTrackSelection fixedTrackSelection;
        int i2;
        int[] iArr4;
        String languageTag;
        Pair pairSelectTracksForType;
        CaptioningManager captioningManager;
        Locale locale;
        final boolean z2;
        Context context;
        int[] iArr5;
        final DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        BaseRenderer[] baseRendererArr = this.rendererCapabilities;
        TrackGroupArray trackGroupArray = this.trackGroups;
        defaultTrackSelector.getClass();
        int i3 = 1;
        int[] iArr6 = new int[baseRendererArr.length + 1];
        int length = baseRendererArr.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr7 = new int[baseRendererArr.length + 1][][];
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = trackGroupArray.length;
            trackGroupArr[i4] = new TrackGroup[i5];
            iArr7[i4] = new int[i5][];
        }
        int length2 = baseRendererArr.length;
        final ?? r12 = new int[length2];
        for (int i6 = 0; i6 < length2; i6++) {
            r12[i6] = baseRendererArr[i6].supportsMixedMimeTypeAdaptation();
        }
        int i7 = 0;
        while (i7 < trackGroupArray.length) {
            TrackGroup trackGroup = trackGroupArray.get(i7);
            int i8 = trackGroup.type == 5 ? i3 : 0;
            int length3 = baseRendererArr.length;
            int i9 = i3;
            int i10 = 0;
            int i11 = 0;
            while (i10 < baseRendererArr.length) {
                BaseRenderer baseRenderer = baseRendererArr[i10];
                TrackGroupArray trackGroupArray2 = trackGroupArray;
                int[] iArr8 = iArr6;
                int i12 = i3;
                int iMax = 0;
                for (int i13 = 0; i13 < trackGroup.length; i13++) {
                    iMax = Math.max(iMax, baseRenderer.supportsFormat(trackGroup.formats[i13]) & 7);
                }
                int i14 = iArr8[i10] == 0 ? i12 : 0;
                if (iMax > i11 || (iMax == i11 && i8 != 0 && i9 == 0 && i14 != 0)) {
                    i11 = iMax;
                    i9 = i14;
                    length3 = i10;
                }
                i10++;
                i3 = i12;
                trackGroupArray = trackGroupArray2;
                iArr6 = iArr8;
            }
            TrackGroupArray trackGroupArray3 = trackGroupArray;
            int[] iArr9 = iArr6;
            int i15 = i3;
            if (length3 == baseRendererArr.length) {
                iArr5 = new int[trackGroup.length];
            } else {
                BaseRenderer baseRenderer2 = baseRendererArr[length3];
                int[] iArr10 = new int[trackGroup.length];
                for (int i16 = 0; i16 < trackGroup.length; i16++) {
                    iArr10[i16] = baseRenderer2.supportsFormat(trackGroup.formats[i16]);
                }
                iArr5 = iArr10;
            }
            int i17 = iArr9[length3];
            trackGroupArr[length3][i17] = trackGroup;
            iArr7[length3][i17] = iArr5;
            iArr9[length3] = i17 + 1;
            i7++;
            i3 = i15;
            trackGroupArray = trackGroupArray3;
            iArr6 = iArr9;
        }
        int[] iArr11 = iArr6;
        int i18 = i3;
        TrackGroupArray[] trackGroupArrayArr3 = new TrackGroupArray[baseRendererArr.length];
        String[] strArr = new String[baseRendererArr.length];
        int[] iArr12 = new int[baseRendererArr.length];
        for (int i19 = 0; i19 < baseRendererArr.length; i19++) {
            int i20 = iArr11[i19];
            trackGroupArrayArr3[i19] = new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(i20, trackGroupArr[i19]));
            iArr7[i19] = (int[][]) Util.nullSafeArrayCopy(i20, iArr7[i19]);
            strArr[i19] = baseRendererArr[i19].getName();
            iArr12[i19] = baseRendererArr[i19].trackType;
        }
        MappingTrackSelector$MappedTrackInfo mappingTrackSelector$MappedTrackInfo = new MappingTrackSelector$MappedTrackInfo(iArr12, trackGroupArrayArr3, r12, iArr7, new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(iArr11[baseRendererArr.length], trackGroupArr[baseRendererArr.length])));
        synchronized (defaultTrackSelector.lock) {
            defaultTrackSelector.playbackThread = Thread.currentThread();
            parameters = defaultTrackSelector.parameters;
        }
        Boolean boolValueOf = defaultTrackSelector.deviceIsTV;
        if (boolValueOf == null && (context = defaultTrackSelector.context) != null) {
            boolValueOf = Boolean.valueOf(Util.isTv(context));
            defaultTrackSelector.deviceIsTV = boolValueOf;
        }
        if (parameters.constrainAudioChannelCountToDeviceCapabilities && Build.VERSION.SDK_INT >= 32 && defaultTrackSelector.spatializer == null) {
            defaultTrackSelector.spatializer = new SpatializerWrapper(defaultTrackSelector.context, new ActivityCompat$$ExternalSyntheticLambda0((byte) 27, (Object) defaultTrackSelector), boolValueOf);
        }
        int i21 = mappingTrackSelector$MappedTrackInfo.rendererCount;
        ExoTrackSelection.Definition[] definitionArr = new ExoTrackSelection.Definition[i21];
        DefaultTrackSelector.applyTrackSelectionOverrides(mappingTrackSelector$MappedTrackInfo, parameters, definitionArr);
        DefaultTrackSelector.applyLegacyRendererOverrides(mappingTrackSelector$MappedTrackInfo, parameters, definitionArr);
        DefaultTrackSelector.applyRendererDisableOverrides(mappingTrackSelector$MappedTrackInfo, parameters, definitionArr);
        Context context2 = defaultTrackSelector.context;
        int i22 = mappingTrackSelector$MappedTrackInfo.rendererCount;
        Pair pairFindDefinitionForType = DefaultTrackSelector.findDefinitionForType(definitionArr, i18);
        if (pairFindDefinitionForType == null) {
            int i23 = 0;
            while (true) {
                if (i23 >= i22) {
                    z2 = false;
                    break;
                }
                if (2 == iArr12[i23] && trackGroupArrayArr3[i23].length > 0) {
                    z2 = true;
                    break;
                }
                i23++;
            }
            pairFindDefinitionForType = DefaultTrackSelector.selectTracksForType(1, mappingTrackSelector$MappedTrackInfo, iArr7, new DefaultTrackSelector.TrackInfo.Factory() { // from class: androidx.media3.exoplayer.trackselection.DefaultTrackSelector$$ExternalSyntheticLambda6
                @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo.Factory
                public final RegularImmutableList create(int i24, TrackGroup trackGroup2, int[] iArr13) {
                    DefaultTrackSelector defaultTrackSelector2 = defaultTrackSelector;
                    defaultTrackSelector2.getClass();
                    DefaultTrackSelector.Parameters parameters2 = parameters;
                    DefaultTrackSelector$$ExternalSyntheticLambda10 defaultTrackSelector$$ExternalSyntheticLambda10 = new DefaultTrackSelector$$ExternalSyntheticLambda10(defaultTrackSelector2, parameters2);
                    int i25 = r12[i24];
                    ImmutableList.Builder builder = ImmutableList.builder();
                    for (int i26 = 0; i26 < trackGroup2.length; i26++) {
                        builder.add((Object) new DefaultTrackSelector.AudioTrackInfo(i24, trackGroup2, i26, parameters2, iArr13[i26], z2, defaultTrackSelector$$ExternalSyntheticLambda10, i25));
                    }
                    return builder.build();
                }
            }, new LayoutNode$$ExternalSyntheticLambda1((byte) 14));
            if (pairFindDefinitionForType != null) {
                definitionArr[((Integer) pairFindDefinitionForType.second).intValue()] = (ExoTrackSelection.Definition) pairFindDefinitionForType.first;
            }
        }
        if (pairFindDefinitionForType == null) {
            str = null;
        } else {
            ExoTrackSelection.Definition definition = (ExoTrackSelection.Definition) pairFindDefinitionForType.first;
            str = definition.group.formats[definition.tracks[0]].language;
        }
        Pair pairFindDefinitionForType2 = DefaultTrackSelector.findDefinitionForType(definitionArr, 2);
        Pair pairFindDefinitionForType3 = DefaultTrackSelector.findDefinitionForType(definitionArr, 4);
        if (pairFindDefinitionForType2 == null && pairFindDefinitionForType3 == null) {
            Pair pairSelectTracksForType2 = parameters.audioOffloadPreferences.audioOffloadMode == 2 ? null : DefaultTrackSelector.selectTracksForType(2, mappingTrackSelector$MappedTrackInfo, iArr7, new MediaSessionLegacyStub$$ExternalSyntheticLambda24(parameters, str, r12, (!parameters.isViewportSizeLimitedByPhysicalDisplaySize || context2 == null) ? null : Util.getCurrentDisplayModeSize(context2)), new LayoutNode$$ExternalSyntheticLambda1((byte) 13));
            Pair pairSelectTracksForType3 = ((parameters.isPrioritizeImageOverVideoEnabled || pairSelectTracksForType2 == null) && parameters.audioOffloadPreferences.audioOffloadMode != 2) ? DefaultTrackSelector.selectTracksForType(4, mappingTrackSelector$MappedTrackInfo, iArr7, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 19, parameters), new LayoutNode$$ExternalSyntheticLambda1((byte) 12)) : null;
            if (pairSelectTracksForType3 != null) {
                definitionArr[((Integer) pairSelectTracksForType3.second).intValue()] = (ExoTrackSelection.Definition) pairSelectTracksForType3.first;
            } else if (pairSelectTracksForType2 != null) {
                definitionArr[((Integer) pairSelectTracksForType2.second).intValue()] = (ExoTrackSelection.Definition) pairSelectTracksForType2.first;
            }
        }
        if (DefaultTrackSelector.findDefinitionForType(definitionArr, 3) == null) {
            if (parameters.audioOffloadPreferences.audioOffloadMode == 2) {
                pairSelectTracksForType = null;
            } else {
                if (!parameters.usePreferredTextLanguagesAndRoleFlagsFromCaptioningManager || context2 == null || (captioningManager = (CaptioningManager) context2.getSystemService("captioning")) == null || !captioningManager.isEnabled() || (locale = captioningManager.getLocale()) == null) {
                    languageTag = null;
                } else {
                    String str2 = Util.DEVICE_DEBUG_INFO;
                    languageTag = locale.toLanguageTag();
                }
                pairSelectTracksForType = DefaultTrackSelector.selectTracksForType(3, mappingTrackSelector$MappedTrackInfo, iArr7, new MediaSessionStub$$ExternalSyntheticLambda81(parameters, str, languageTag, (byte) 1), new LayoutNode$$ExternalSyntheticLambda1((byte) 15));
            }
            if (pairSelectTracksForType != null) {
                definitionArr[((Integer) pairSelectTracksForType.second).intValue()] = (ExoTrackSelection.Definition) pairSelectTracksForType.first;
            }
        }
        int iCreate = BaseRenderer.create(0, 0, 0, 0);
        if (parameters.audioOffloadPreferences.audioOffloadMode == 2) {
            iArr = iArr12;
            trackGroupArrayArr = trackGroupArrayArr3;
            iArr2 = iArr7;
        } else {
            int i24 = ImmutableSet.$r8$clinit;
            ImmutableSet.Builder builder = new ImmutableSet.Builder(4);
            int i25 = 0;
            while (i25 < i21) {
                ExoTrackSelection.Definition definition2 = definitionArr[i25];
                if (definition2 != null) {
                    TrackGroup trackGroup2 = definition2.group;
                    if (parameters.rendererDisabledFlags.get(i25)) {
                        iArr3 = iArr12;
                    } else {
                        iArr3 = iArr12;
                        if (!parameters.disabledTrackTypes.contains(Integer.valueOf(trackGroup2.type))) {
                            builder.add$1(trackGroup2.id);
                            int i26 = 0;
                            while (true) {
                                int[] iArr13 = definition2.tracks;
                                trackGroupArrayArr2 = trackGroupArrayArr3;
                                if (i26 < iArr13.length) {
                                    String str3 = trackGroup2.formats[iArr13[i26]].primaryTrackGroupId;
                                    if (str3 != null) {
                                        builder.add((Object) str3);
                                    }
                                    i26++;
                                    trackGroupArrayArr3 = trackGroupArrayArr2;
                                }
                            }
                        }
                    }
                    trackGroupArrayArr2 = trackGroupArrayArr3;
                } else {
                    iArr3 = iArr12;
                    trackGroupArrayArr2 = trackGroupArrayArr3;
                }
                i25++;
                iArr12 = iArr3;
                trackGroupArrayArr3 = trackGroupArrayArr2;
            }
            iArr = iArr12;
            trackGroupArrayArr = trackGroupArrayArr3;
            ImmutableSet immutableSetBuild = builder.build();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i27 = 0;
            while (i27 < i22) {
                if (iArr[i27] == 5) {
                    TrackGroupArray trackGroupArray4 = trackGroupArrayArr[i27];
                    int i28 = 0;
                    while (i28 < trackGroupArray4.length) {
                        TrackGroup trackGroup3 = trackGroupArray4.get(i28);
                        arrayList.add(trackGroup3);
                        int i29 = i27;
                        int[] iArr14 = (int[]) iArr7[i27][i28].clone();
                        TrackGroupArray trackGroupArray5 = trackGroupArray4;
                        int[][][] iArr15 = iArr7;
                        for (int i30 = 0; i30 < iArr14.length; i30++) {
                            String str4 = trackGroup3.formats[i30].primaryTrackGroupId;
                            if (str4 != null && !immutableSetBuild.contains(str4)) {
                                iArr14[i30] = iCreate;
                            }
                        }
                        arrayList2.add(iArr14);
                        i28++;
                        trackGroupArray4 = trackGroupArray5;
                        i27 = i29;
                        iArr7 = iArr15;
                    }
                }
                i27++;
                iArr7 = iArr7;
            }
            iArr2 = iArr7;
            int size = arrayList.size();
            TrackGroup[] trackGroupArr2 = new TrackGroup[size];
            UtilsKt.checkState(arrayList.size() == size);
            arrayList.toArray(trackGroupArr2);
            TrackGroupArray trackGroupArray6 = new TrackGroupArray(trackGroupArr2);
            int size2 = arrayList2.size();
            int[][] iArr16 = new int[size2][];
            UtilsKt.checkState(arrayList2.size() == size2);
            arrayList2.toArray(iArr16);
            for (int i31 = 0; i31 < i22; i31++) {
                if (iArr[i31] == 5) {
                    ExoTrackSelection.Definition definitionSelectOtherTrack = DefaultTrackSelector.selectOtherTrack(trackGroupArray6, iArr16, parameters);
                    definitionArr[i31] = definitionSelectOtherTrack;
                    if (definitionSelectOtherTrack == null) {
                        break;
                    }
                    int iIndexOf = trackGroupArray6.trackGroups.indexOf(definitionSelectOtherTrack.group);
                    if (iIndexOf < 0) {
                        iIndexOf = -1;
                    }
                    Arrays.fill(iArr16[iIndexOf], iCreate);
                }
            }
        }
        for (int i32 = 0; i32 < i22; i32++) {
            int i33 = iArr[i32];
            if (i33 != 2 && i33 != 1) {
                if (i33 != 3 && i33 != 4) {
                    if (i33 != 5 && definitionArr[i32] == null) {
                        definitionArr[i32] = DefaultTrackSelector.selectOtherTrack(trackGroupArrayArr[i32], iArr2[i32], parameters);
                    }
                }
            }
        }
        DefaultTrackSelector.applyTrackSelectionOverrides(mappingTrackSelector$MappedTrackInfo, parameters, definitionArr);
        DefaultTrackSelector.applyLegacyRendererOverrides(mappingTrackSelector$MappedTrackInfo, parameters, definitionArr);
        DefaultTrackSelector.applyRendererDisableOverrides(mappingTrackSelector$MappedTrackInfo, parameters, definitionArr);
        CueDecoder cueDecoder = defaultTrackSelector.trackSelectionFactory;
        defaultTrackSelector.bandwidthMeter.getClass();
        ArrayList arrayList3 = new ArrayList();
        for (ExoTrackSelection.Definition definition3 : definitionArr) {
            if (definition3 == null || definition3.tracks.length <= 1) {
                arrayList3.add(null);
            } else {
                ImmutableList.Builder builder2 = ImmutableList.builder();
                builder2.add((Object) new AdaptiveTrackSelection$AdaptationCheckpoint(0L, 0L));
                arrayList3.add(builder2);
            }
        }
        int length4 = definitionArr.length;
        long[][] jArr = new long[length4][];
        for (int i34 = 0; i34 < definitionArr.length; i34++) {
            ExoTrackSelection.Definition definition4 = definitionArr[i34];
            if (definition4 == null) {
                jArr[i34] = new long[0];
            } else {
                int[] iArr17 = definition4.tracks;
                jArr[i34] = new long[iArr17.length];
                for (int i35 = 0; i35 < iArr17.length; i35++) {
                    long j = definition4.group.formats[iArr17[i35]].bitrate;
                    long[] jArr2 = jArr[i34];
                    if (j == -1) {
                        j = 0;
                    }
                    jArr2[i35] = j;
                }
                Arrays.sort(jArr[i34]);
            }
        }
        int[] iArr18 = new int[length4];
        long[] jArr3 = new long[length4];
        for (int i36 = 0; i36 < length4; i36++) {
            long[] jArr4 = jArr[i36];
            jArr3[i36] = jArr4.length == 0 ? 0L : jArr4[0];
        }
        FixedTrackSelection.addCheckpoint(arrayList3, jArr3);
        Maps.checkNonnegative(2, "expectedValuesPerKey");
        TreeMap treeMap = new TreeMap(NaturalOrdering.INSTANCE);
        MultimapBuilder$ArrayListSupplier multimapBuilder$ArrayListSupplier = new MultimapBuilder$ArrayListSupplier();
        Maps.checkNonnegative(2, "expectedValuesPerKey");
        Multimaps$CustomListMultimap multimaps$CustomListMultimap = new Multimaps$CustomListMultimap(treeMap);
        multimaps$CustomListMultimap.factory = multimapBuilder$ArrayListSupplier;
        int i37 = 0;
        while (i37 < length4) {
            long[] jArr5 = jArr[i37];
            if (jArr5.length <= 1) {
                i2 = length4;
                iArr4 = iArr18;
            } else {
                int length5 = jArr5.length;
                double[] dArr = new double[length5];
                int i38 = 0;
                while (true) {
                    long[] jArr6 = jArr[i37];
                    i2 = length4;
                    double dLog = 0.0d;
                    if (i38 >= jArr6.length) {
                        break;
                    }
                    int[] iArr19 = iArr18;
                    long j2 = jArr6[i38];
                    if (j2 != -1) {
                        dLog = Math.log(j2);
                    }
                    dArr[i38] = dLog;
                    i38++;
                    length4 = i2;
                    iArr18 = iArr19;
                }
                iArr4 = iArr18;
                int i39 = length5 - 1;
                double d = dArr[i39] - dArr[0];
                int i40 = 0;
                while (i40 < i39) {
                    double d2 = dArr[i40];
                    i40++;
                    multimaps$CustomListMultimap.put(Double.valueOf(d == 0.0d ? 1.0d : (((d2 + dArr[i40]) * 0.5d) - dArr[0]) / d), Integer.valueOf(i37));
                    d = d;
                }
            }
            i37++;
            length4 = i2;
            iArr18 = iArr4;
        }
        int[] iArr20 = iArr18;
        Collection values = multimaps$CustomListMultimap.values;
        if (values == null) {
            i = 2;
            values = new Maps.Values((byte) 2, multimaps$CustomListMultimap);
            multimaps$CustomListMultimap.values = values;
        } else {
            i = 2;
        }
        ImmutableList immutableListCopyOf = ImmutableList.copyOf(values);
        for (int i41 = 0; i41 < immutableListCopyOf.size(); i41++) {
            int iIntValue = ((Integer) immutableListCopyOf.get(i41)).intValue();
            int i42 = iArr20[iIntValue] + 1;
            iArr20[iIntValue] = i42;
            jArr3[iIntValue] = jArr[iIntValue][i42];
            FixedTrackSelection.addCheckpoint(arrayList3, jArr3);
        }
        for (int i43 = 0; i43 < definitionArr.length; i43++) {
            if (arrayList3.get(i43) != null) {
                jArr3[i43] = jArr3[i43] * 2;
            }
        }
        FixedTrackSelection.addCheckpoint(arrayList3, jArr3);
        ImmutableList.Builder builder3 = ImmutableList.builder();
        for (int i44 = 0; i44 < arrayList3.size(); i44++) {
            ImmutableList.Builder builder4 = (ImmutableList.Builder) arrayList3.get(i44);
            builder3.add((Object) (builder4 == null ? RegularImmutableList.EMPTY : builder4.build()));
        }
        RegularImmutableList regularImmutableListBuild = builder3.build();
        ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
        for (int i45 = 0; i45 < definitionArr.length; i45++) {
            ExoTrackSelection.Definition definition5 = definitionArr[i45];
            if (definition5 != null) {
                int[] iArr21 = definition5.tracks;
                if (iArr21.length != 0) {
                    int length6 = iArr21.length;
                    TrackGroup trackGroup4 = definition5.group;
                    if (length6 == 1) {
                        fixedTrackSelection = new FixedTrackSelection(trackGroup4, new int[]{iArr21[0]}, (byte) 0);
                    } else {
                        ImmutableList immutableList = (ImmutableList) regularImmutableListBuild.get(i45);
                        FixedTrackSelection fixedTrackSelection2 = new FixedTrackSelection(trackGroup4, iArr21, (byte) 1);
                        ImmutableList.copyOf((Collection) immutableList);
                        fixedTrackSelection = fixedTrackSelection2;
                    }
                    exoTrackSelectionArr[i45] = fixedTrackSelection;
                }
            }
        }
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[i21];
        for (int i46 = 0; i46 < i21; i46++) {
            rendererConfigurationArr[i46] = (parameters.rendererDisabledFlags.get(i46) || parameters.disabledTrackTypes.contains(Integer.valueOf(mappingTrackSelector$MappedTrackInfo.rendererTrackTypes[i46])) || (mappingTrackSelector$MappedTrackInfo.rendererTrackTypes[i46] != -2 && exoTrackSelectionArr[i46] == null)) ? null : RendererConfiguration.DEFAULT;
        }
        if (parameters.audioOffloadPreferences.audioOffloadMode != 0) {
            int i47 = 0;
            int i48 = 0;
            int i49 = -1;
            while (true) {
                if (i47 >= mappingTrackSelector$MappedTrackInfo.rendererCount) {
                    if (i48 != 1) {
                        break;
                    }
                    if (parameters.audioOffloadPreferences.isGaplessSupportRequired) {
                        i = 1;
                    }
                    RendererConfiguration rendererConfiguration = rendererConfigurationArr[i49];
                    rendererConfigurationArr[i49] = new RendererConfiguration(i, rendererConfiguration != null && rendererConfiguration.tunneling);
                    break;
                }
                int i50 = mappingTrackSelector$MappedTrackInfo.rendererTrackTypes[i47];
                ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i47];
                if (i50 != 1 && exoTrackSelection != null) {
                    break;
                }
                if (i50 == 1 && exoTrackSelection != null && exoTrackSelection.length() == 1) {
                    int iIndexOf2 = mappingTrackSelector$MappedTrackInfo.rendererTrackGroups[i47].trackGroups.indexOf(exoTrackSelection.getTrackGroup());
                    if (iIndexOf2 < 0) {
                        iIndexOf2 = -1;
                    }
                    if (DefaultTrackSelector.rendererSupportsOffload(parameters, iArr2[i47][iIndexOf2][exoTrackSelection.getIndexInTrackGroup(0)], exoTrackSelection.getSelectedFormat())) {
                        i48++;
                        i49 = i47;
                    }
                }
                i47++;
            }
        }
        Pair pairCreate = Pair.create(rendererConfigurationArr, exoTrackSelectionArr);
        ExoTrackSelection[] exoTrackSelectionArr2 = (ExoTrackSelection[]) pairCreate.second;
        int length7 = exoTrackSelectionArr2.length;
        List[] listArr = new List[length7];
        for (int i51 = 0; i51 < exoTrackSelectionArr2.length; i51++) {
            ExoTrackSelection exoTrackSelection2 = exoTrackSelectionArr2[i51];
            if (exoTrackSelection2 != null) {
                regularImmutableListOf = ImmutableList.of((Object) exoTrackSelection2);
            } else {
                ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
                regularImmutableListOf = RegularImmutableList.EMPTY;
            }
            listArr[i51] = regularImmutableListOf;
        }
        ImmutableList.Builder builder5 = new ImmutableList.Builder(4);
        int i52 = 0;
        while (true) {
            int i53 = mappingTrackSelector$MappedTrackInfo.rendererCount;
            TrackGroupArray[] trackGroupArrayArr4 = mappingTrackSelector$MappedTrackInfo.rendererTrackGroups;
            if (i52 >= i53) {
                break;
            }
            TrackGroupArray trackGroupArray7 = trackGroupArrayArr4[i52];
            int i54 = 0;
            while (i54 < trackGroupArray7.length) {
                TrackGroup trackGroup5 = trackGroupArray7.get(i54);
                int i55 = trackGroupArrayArr4[i52].get(i54).length;
                int[] iArr22 = new int[i55];
                int i56 = 0;
                int i57 = 0;
                while (i56 < i55) {
                    List[] listArr2 = listArr;
                    if ((mappingTrackSelector$MappedTrackInfo.rendererFormatSupports[i52][i54][i56] & 7) == 4) {
                        iArr22[i57] = i56;
                        i57++;
                    }
                    i56++;
                    listArr = listArr2;
                }
                List[] listArr3 = listArr;
                int[] iArrCopyOf = Arrays.copyOf(iArr22, i57);
                int i58 = i52;
                int iMin = 16;
                String str5 = null;
                int i59 = 0;
                boolean z3 = false;
                int i60 = 0;
                while (i59 < iArrCopyOf.length) {
                    String str6 = trackGroupArrayArr4[i58].get(i54).formats[iArrCopyOf[i59]].sampleMimeType;
                    int i61 = i60 + 1;
                    if (i60 == 0) {
                        str5 = str6;
                    } else {
                        z3 = (!Objects.equals(str5, str6)) | z3;
                    }
                    iMin = Math.min(iMin, mappingTrackSelector$MappedTrackInfo.rendererFormatSupports[i58][i54][i59] & 24);
                    i59++;
                    i60 = i61;
                }
                if (z3) {
                    iMin = Math.min(iMin, mappingTrackSelector$MappedTrackInfo.rendererMixedMimeTypeAdaptiveSupports[i58]);
                }
                boolean z4 = iMin != 0;
                int i62 = trackGroup5.length;
                int[] iArr23 = new int[i62];
                boolean[] zArr = new boolean[i62];
                int i63 = 0;
                while (i63 < trackGroup5.length) {
                    iArr23[i63] = mappingTrackSelector$MappedTrackInfo.rendererFormatSupports[i58][i54][i63] & 7;
                    int i64 = 0;
                    boolean z5 = false;
                    while (i64 < length7) {
                        List list = listArr3[i64];
                        int i65 = length7;
                        TrackGroupArray trackGroupArray8 = trackGroupArray7;
                        int i66 = 0;
                        while (i66 < list.size()) {
                            ExoTrackSelection exoTrackSelection3 = (ExoTrackSelection) list.get(i66);
                            int i67 = i66;
                            if (exoTrackSelection3.getTrackGroup().equals(trackGroup5) && exoTrackSelection3.indexOf(i63) != -1) {
                                z5 = true;
                                break;
                            }
                            i66 = i67 + 1;
                        }
                        i64++;
                        length7 = i65;
                        trackGroupArray7 = trackGroupArray8;
                    }
                    zArr[i63] = z5;
                    i63++;
                    trackGroupArray7 = trackGroupArray7;
                }
                builder5.add((Object) new Tracks.Group(trackGroup5, z4, iArr23, zArr));
                i54++;
                listArr = listArr3;
                i52 = i58;
                length7 = length7;
                trackGroupArray7 = trackGroupArray7;
            }
            i52++;
        }
        TrackGroupArray trackGroupArray9 = mappingTrackSelector$MappedTrackInfo.unmappedTrackGroups;
        for (int i68 = 0; i68 < trackGroupArray9.length; i68++) {
            TrackGroup trackGroup6 = trackGroupArray9.get(i68);
            int[] iArr24 = new int[trackGroup6.length];
            Arrays.fill(iArr24, 0);
            builder5.add((Object) new Tracks.Group(trackGroup6, false, iArr24, new boolean[trackGroup6.length]));
        }
        TrackSelectorResult trackSelectorResult = new TrackSelectorResult((RendererConfiguration[]) pairCreate.first, (ExoTrackSelection[]) pairCreate.second, new Tracks(builder5.build()), mappingTrackSelector$MappedTrackInfo);
        for (int i69 = 0; i69 < trackSelectorResult.length; i69++) {
            boolean zIsRendererEnabled = trackSelectorResult.isRendererEnabled(i69);
            ExoTrackSelection[] exoTrackSelectionArr3 = trackSelectorResult.selections;
            if (zIsRendererEnabled) {
                UtilsKt.checkState(exoTrackSelectionArr3[i69] != null || this.rendererCapabilities[i69].trackType == -2);
            } else {
                UtilsKt.checkState(exoTrackSelectionArr3[i69] == null);
            }
        }
        for (ExoTrackSelection exoTrackSelection4 : trackSelectorResult.selections) {
            if (exoTrackSelection4 != null) {
                exoTrackSelection4.onPlaybackSpeed(f);
                exoTrackSelection4.onPlayWhenReadyChanged(z);
            }
        }
        return trackSelectorResult;
    }

    public final void updateClipping() {
        MediaPeriod mediaPeriod = this.mediaPeriod;
        if (mediaPeriod instanceof ClippingMediaPeriod) {
            long j = this.info.endPositionUs;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ClippingMediaPeriod clippingMediaPeriod = (ClippingMediaPeriod) mediaPeriod;
            clippingMediaPeriod.startUs = 0L;
            clippingMediaPeriod.endUs = j;
        }
    }
}
