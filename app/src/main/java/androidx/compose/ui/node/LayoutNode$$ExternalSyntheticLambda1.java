package androidx.compose.ui.node;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.foundation.lazy.layout.PriorityTask;
import androidx.compose.ui.semantics.SemanticsSortKt;
import androidx.media3.common.Format;
import androidx.media3.exoplayer.offline.Download;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.upstream.SlidingPercentile;
import androidx.media3.extractor.text.cea.Cea708Decoder;
import androidx.media3.extractor.text.webvtt.WebvttCueInfo;
import androidx.media3.extractor.text.webvtt.WebvttCueParser;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LayoutNode$$ExternalSyntheticLambda1 implements Comparator {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ LayoutNode$$ExternalSyntheticLambda1(byte b) {
        this.$r8$classId = b;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Ordering ordering;
        Ordering orderingReverse;
        switch (this.$r8$classId) {
            case 0:
                LayoutNode layoutNode = (LayoutNode) obj;
                LayoutNode layoutNode2 = (LayoutNode) obj2;
                float f = layoutNode.layoutDelegate.measurePassDelegate.zIndex;
                float f2 = layoutNode2.layoutDelegate.measurePassDelegate.zIndex;
                return f == f2 ? Intrinsics.compare(layoutNode.getPlaceOrder$ui(), layoutNode2.getPlaceOrder$ui()) : Float.compare(f, f2);
            case 1:
                return Intrinsics.compare(((PriorityTask) obj2).priority ? 1 : 0, ((PriorityTask) obj).priority ? 1 : 0);
            case 2:
                return Intrinsics.compare(((LazyLayoutMeasuredItem) obj).getIndex(), ((LazyLayoutMeasuredItem) obj2).getIndex());
            case 3:
                return Intrinsics.compare(((androidx.compose.runtime.Invalidation) obj).location, ((androidx.compose.runtime.Invalidation) obj2).location);
            case 4:
                return ((Number) SemanticsSortKt.UnmergedConfigComparator.invoke(obj, obj2)).intValue();
            case 5:
                return ((Number) SemanticsSortKt.UnmergedConfigComparator.invoke(obj, obj2)).intValue();
            case 6:
                IntRange intRange = (IntRange) obj;
                IntRange intRange2 = (IntRange) obj2;
                return (intRange.last - intRange.first) - (intRange2.last - intRange2.first);
            case 7:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i = 0; i < bArr.length; i++) {
                    byte b = bArr[i];
                    byte b2 = bArr2[i];
                    if (b != b2) {
                        return b - b2;
                    }
                }
                return 0;
            case 8:
                return Integer.bitCount(((Integer) obj2).intValue()) - Integer.bitCount(((Integer) obj).intValue());
            case 9:
                return Long.compare(((Download) obj).startTimeMs, ((Download) obj2).startTimeMs);
            case 10:
                return ((Format) obj2).bitrate - ((Format) obj).bitrate;
            case 11:
                Integer num = (Integer) obj;
                Integer num2 = (Integer) obj2;
                if (num.intValue() == -1) {
                    return num2.intValue() == -1 ? 0 : -1;
                }
                if (num2.intValue() == -1) {
                    return 1;
                }
                return num.intValue() - num2.intValue();
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return Integer.compare(((DefaultTrackSelector.ImageTrackInfo) ((List) obj).get(0)).pixelCount, ((DefaultTrackSelector.ImageTrackInfo) ((List) obj2).get(0)).pixelCount);
            case 13:
                List list = (List) obj;
                List list2 = (List) obj2;
                byte b3 = 16;
                byte b4 = 17;
                return ComparisonChain.AnonymousClass1.classify(DefaultTrackSelector.VideoTrackInfo.compareNonQualityPreferences((DefaultTrackSelector.VideoTrackInfo) Collections.max(list, new LayoutNode$$ExternalSyntheticLambda1(b3)), (DefaultTrackSelector.VideoTrackInfo) Collections.max(list2, new LayoutNode$$ExternalSyntheticLambda1(b3)))).compare(list.size(), list2.size()).compare((DefaultTrackSelector.VideoTrackInfo) Collections.max(list, new LayoutNode$$ExternalSyntheticLambda1(b4)), (DefaultTrackSelector.VideoTrackInfo) Collections.max(list2, new LayoutNode$$ExternalSyntheticLambda1(b4)), new LayoutNode$$ExternalSyntheticLambda1(b4)).result();
            case 14:
                return ((DefaultTrackSelector.AudioTrackInfo) Collections.max((List) obj)).compareTo((DefaultTrackSelector.AudioTrackInfo) Collections.max((List) obj2));
            case 15:
                return ((DefaultTrackSelector.TextTrackInfo) ((List) obj).get(0)).compareTo((DefaultTrackSelector.TextTrackInfo) ((List) obj2).get(0));
            case 16:
                return DefaultTrackSelector.VideoTrackInfo.compareNonQualityPreferences((DefaultTrackSelector.VideoTrackInfo) obj, (DefaultTrackSelector.VideoTrackInfo) obj2);
            case 17:
                DefaultTrackSelector.VideoTrackInfo videoTrackInfo = (DefaultTrackSelector.VideoTrackInfo) obj;
                DefaultTrackSelector.VideoTrackInfo videoTrackInfo2 = (DefaultTrackSelector.VideoTrackInfo) obj2;
                boolean z = videoTrackInfo.isWithinMaxConstraints;
                int i2 = videoTrackInfo.bitrate;
                if (z && videoTrackInfo.isWithinRendererCapabilities) {
                    orderingReverse = DefaultTrackSelector.FORMAT_VALUE_ORDERING;
                    ordering = orderingReverse;
                } else {
                    Ordering ordering2 = DefaultTrackSelector.FORMAT_VALUE_ORDERING;
                    ordering = ordering2;
                    orderingReverse = ordering2.reverse();
                }
                boolean z2 = videoTrackInfo.parameters.forceLowestBitrate;
                ComparisonChain comparisonChainCompare = ComparisonChain.ACTIVE;
                if (z2) {
                    comparisonChainCompare = comparisonChainCompare.compare(Integer.valueOf(i2), Integer.valueOf(videoTrackInfo2.bitrate), ordering.reverse());
                }
                ComparisonChain comparisonChainCompare2 = comparisonChainCompare.compareFalseFirst(videoTrackInfo.isHdr, videoTrackInfo2.isHdr).compare(Integer.valueOf(videoTrackInfo.pixelCount), Integer.valueOf(videoTrackInfo2.pixelCount), orderingReverse);
                if (videoTrackInfo.usesPrimaryOrFallbackDecoder && videoTrackInfo.usesHardwareAcceleration) {
                    comparisonChainCompare2 = comparisonChainCompare2.compare(videoTrackInfo.codecPreferenceScore, videoTrackInfo2.codecPreferenceScore);
                }
                return comparisonChainCompare2.compareFalseFirst(videoTrackInfo.usesPrimaryDecoder, videoTrackInfo2.usesPrimaryDecoder).compare(Integer.valueOf(i2), Integer.valueOf(videoTrackInfo2.bitrate), orderingReverse).result();
            case 18:
                return ((SlidingPercentile.Sample) obj).index - ((SlidingPercentile.Sample) obj2).index;
            case 19:
                return Float.compare(((SlidingPercentile.Sample) obj).value, ((SlidingPercentile.Sample) obj2).value);
            case 20:
                return Integer.compare(((Cea708Decoder.Cea708CueInfo) obj2).priority, ((Cea708Decoder.Cea708CueInfo) obj).priority);
            case 21:
                return Integer.compare(((WebvttCueParser.Element) obj).startTag.position, ((WebvttCueParser.Element) obj2).startTag.position);
            default:
                return Long.compare(((WebvttCueInfo) obj).startTimeUs, ((WebvttCueInfo) obj2).startTimeUs);
        }
    }
}
