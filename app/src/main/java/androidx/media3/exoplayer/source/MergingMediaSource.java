package androidx.media3.exoplayer.source;

import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.extractor.text.CueDecoder;
import com.google.common.collect.CompactHashMap;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder$ArrayListSupplier;
import com.google.common.collect.Multimaps$CustomListMultimap;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import kotlin.io.FileSystemException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MergingMediaSource extends CompositeMediaSource {
    public static final MediaItem PLACEHOLDER_MEDIA_ITEM;
    public final CueDecoder compositeSequenceableLoaderFactory;
    public final ArrayList mediaPeriods;
    public final BaseMediaSource[] mediaSources;
    public FileSystemException mergeError;
    public final ArrayList pendingTimelineSources;
    public int periodCount;
    public long[][] periodTimeOffsetsUs;
    public final Timeline[] timelines;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MediaPeriodAndId {
        public final MediaPeriod mediaPeriod;
        public final MediaSource$MediaPeriodId mediaPeriodId;

        public MediaPeriodAndId(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, MediaPeriod mediaPeriod) {
            this.mediaPeriodId = mediaSource$MediaPeriodId;
            this.mediaPeriod = mediaPeriod;
        }
    }

    static {
        MediaItem.Builder builder = new MediaItem.Builder();
        builder.mediaId = "MergingMediaSource";
        PLACEHOLDER_MEDIA_ITEM = builder.build();
    }

    public MergingMediaSource(BaseMediaSource... baseMediaSourceArr) {
        CueDecoder cueDecoder = new CueDecoder((byte) 3);
        this.mediaSources = baseMediaSourceArr;
        this.compositeSequenceableLoaderFactory = cueDecoder;
        this.pendingTimelineSources = new ArrayList(Arrays.asList(baseMediaSourceArr));
        this.periodCount = -1;
        this.mediaPeriods = new ArrayList(baseMediaSourceArr.length);
        for (int i = 0; i < baseMediaSourceArr.length; i++) {
            this.mediaPeriods.add(new ArrayList());
        }
        this.timelines = new Timeline[baseMediaSourceArr.length];
        this.periodTimeOffsetsUs = new long[0][];
        new HashMap();
        Maps.checkNonnegative(8, "expectedKeys");
        Maps.checkNonnegative(2, "expectedValuesPerKey");
        CompactHashMap compactHashMap = new CompactHashMap();
        compactHashMap.init(8);
        MultimapBuilder$ArrayListSupplier multimapBuilder$ArrayListSupplier = new MultimapBuilder$ArrayListSupplier();
        Maps.checkNonnegative(2, "expectedValuesPerKey");
        new Multimaps$CustomListMultimap(compactHashMap).factory = multimapBuilder$ArrayListSupplier;
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final boolean canUpdateMediaItem(MediaItem mediaItem) {
        BaseMediaSource[] baseMediaSourceArr = this.mediaSources;
        return baseMediaSourceArr.length > 0 && baseMediaSourceArr[0].canUpdateMediaItem(mediaItem);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final MediaPeriod createPeriod(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, EmojiProcessor emojiProcessor, long j) {
        BaseMediaSource[] baseMediaSourceArr = this.mediaSources;
        int length = baseMediaSourceArr.length;
        MediaPeriod[] mediaPeriodArr = new MediaPeriod[length];
        Timeline[] timelineArr = this.timelines;
        int indexOfPeriod = timelineArr[0].getIndexOfPeriod(mediaSource$MediaPeriodId.periodUid);
        for (int i = 0; i < length; i++) {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodIdCopyWithPeriodUid = mediaSource$MediaPeriodId.copyWithPeriodUid(timelineArr[i].getUidOfPeriod(indexOfPeriod));
            mediaPeriodArr[i] = baseMediaSourceArr[i].createPeriod(mediaSource$MediaPeriodIdCopyWithPeriodUid, emojiProcessor, j - this.periodTimeOffsetsUs[indexOfPeriod][i]);
            ((List) this.mediaPeriods.get(i)).add(new MediaPeriodAndId(mediaSource$MediaPeriodIdCopyWithPeriodUid, mediaPeriodArr[i]));
        }
        return new MergingMediaPeriod(this.compositeSequenceableLoaderFactory, this.periodTimeOffsetsUs[indexOfPeriod], mediaPeriodArr);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final MediaItem getMediaItem() {
        BaseMediaSource[] baseMediaSourceArr = this.mediaSources;
        return baseMediaSourceArr.length > 0 ? baseMediaSourceArr[0].getMediaItem() : PLACEHOLDER_MEDIA_ITEM;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final MediaSource$MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Object obj, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        int iIntValue = ((Integer) obj).intValue();
        ArrayList arrayList = this.mediaPeriods;
        List list = (List) arrayList.get(iIntValue);
        for (int i = 0; i < list.size(); i++) {
            if (((MediaPeriodAndId) list.get(i)).mediaPeriodId.equals(mediaSource$MediaPeriodId)) {
                return ((MediaPeriodAndId) ((List) arrayList.get(0)).get(i)).mediaPeriodId;
            }
        }
        return null;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void maybeThrowSourceInfoRefreshError() throws FileSystemException {
        FileSystemException fileSystemException = this.mergeError;
        if (fileSystemException != null) {
            throw fileSystemException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final void onChildSourceInfoRefreshed(Object obj, BaseMediaSource baseMediaSource, Timeline timeline) {
        int periodCount;
        Integer num = (Integer) obj;
        if (this.mergeError != null) {
            return;
        }
        if (this.periodCount == -1) {
            periodCount = timeline.getPeriodCount();
            this.periodCount = periodCount;
        } else {
            int periodCount2 = timeline.getPeriodCount();
            int i = this.periodCount;
            if (periodCount2 != i) {
                this.mergeError = new FileSystemException();
                return;
            }
            periodCount = i;
        }
        int length = this.periodTimeOffsetsUs.length;
        Timeline[] timelineArr = this.timelines;
        if (length == 0) {
            this.periodTimeOffsetsUs = (long[][]) Array.newInstance((Class<?>) Long.TYPE, periodCount, timelineArr.length);
        }
        ArrayList arrayList = this.pendingTimelineSources;
        arrayList.remove(baseMediaSource);
        timelineArr[num.intValue()] = timeline;
        if (arrayList.isEmpty()) {
            refreshSourceInfo(timelineArr[0]);
        }
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void prepareSourceInternal(DefaultBandwidthMeter defaultBandwidthMeter) {
        this.mediaTransferListener = defaultBandwidthMeter;
        this.eventHandler = Util.createHandlerForCurrentLooper(null);
        int i = 0;
        while (true) {
            BaseMediaSource[] baseMediaSourceArr = this.mediaSources;
            if (i >= baseMediaSourceArr.length) {
                return;
            }
            prepareChildSource(Integer.valueOf(i), baseMediaSourceArr[i]);
            i++;
        }
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void releasePeriod(MediaPeriod mediaPeriod) {
        MergingMediaPeriod mergingMediaPeriod = (MergingMediaPeriod) mediaPeriod;
        int i = 0;
        while (true) {
            BaseMediaSource[] baseMediaSourceArr = this.mediaSources;
            if (i >= baseMediaSourceArr.length) {
                return;
            }
            List list = (List) this.mediaPeriods.get(i);
            boolean[] zArr = mergingMediaPeriod.periodsWithTimeOffsets;
            MediaPeriod[] mediaPeriodArr = mergingMediaPeriod.periods;
            MediaPeriod mediaPeriod2 = zArr[i] ? ((TimeOffsetMediaPeriod) mediaPeriodArr[i]).mediaPeriod : mediaPeriodArr[i];
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (((MediaPeriodAndId) list.get(i2)).mediaPeriod.equals(mediaPeriod2)) {
                    list.remove(i2);
                    break;
                }
            }
            baseMediaSourceArr[i].releasePeriod(mergingMediaPeriod.periodsWithTimeOffsets[i] ? ((TimeOffsetMediaPeriod) mediaPeriodArr[i]).mediaPeriod : mediaPeriodArr[i]);
            i++;
        }
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void releaseSourceInternal() {
        super.releaseSourceInternal();
        Arrays.fill(this.timelines, (Object) null);
        this.periodCount = -1;
        this.mergeError = null;
        ArrayList arrayList = this.pendingTimelineSources;
        arrayList.clear();
        Collections.addAll(arrayList, this.mediaSources);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void updateMediaItem(MediaItem mediaItem) {
        this.mediaSources[0].updateMediaItem(mediaItem);
    }
}
