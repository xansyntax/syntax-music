package androidx.compose.ui.semantics;

import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.ui.node.LayoutNode;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.materialkolor.hct.Hct;
import com.materialkolor.temperature.TemperatureCache;
import com.metrolist.innertubex.extraction.ContentHints;
import com.metrolist.innertubex.extraction.FormatSelectorsKt$special$$inlined$compareBy$1;
import com.metrolist.innertubex.extraction.strategy.ClientSelectionRequest;
import com.metrolist.innertubex.extraction.strategy.PlaybackClientManifest;
import com.metrolist.innertubex.extraction.strategy.PlaybackTransportPreference;
import com.metrolist.innertubex.extraction.strategy.SelectedClient;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.innertubex.models.response.PlayerResponse;
import com.metrolist.lrclib.LrcLib$getAllLyrics$$inlined$sortedByDescending$1;
import com.metrolist.music.ui.screens.HomeSection;
import com.metrolist.music.viewmodels.DateAgo;
import com.metrolist.music.viewmodels.HistoryViewModel;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.utils.CIOKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.XorWowRandom;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsSortKt$special$$inlined$thenBy$1 implements Comparator {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $this_thenBy;

    public /* synthetic */ SemanticsSortKt$special$$inlined$thenBy$1(byte b, Object obj) {
        this.$r8$classId = b;
        this.$this_thenBy = obj;
    }

    /* JADX WARN: Code duplicated, block: B:199:0x0341  */
    /* JADX WARN: Code duplicated, block: B:214:0x037d  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:49:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f7  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i;
        int i2;
        Integer num;
        Integer num2;
        int i3;
        Integer numValueOf;
        Integer num3;
        int i4;
        int iNextInt;
        int i5;
        int i6;
        int i7;
        int iNextInt2;
        Integer num4;
        int iIntValue;
        Integer num5;
        Long lValueOf;
        byte b = this.$r8$classId;
        int i8 = 2;
        int iIntValue2 = 0;
        Object obj3 = this.$this_thenBy;
        switch (b) {
            case 0:
                int iCompare = ((Comparator) obj3).compare(obj, obj2);
                if (iCompare != 0) {
                    return iCompare;
                }
                LayoutNode layoutNode = ((SemanticsNode) obj).layoutNode;
                LayoutNode layoutNode2 = ((SemanticsNode) obj2).layoutNode;
                return layoutNode.getZIndex$1() == layoutNode2.getZIndex$1() ? Intrinsics.compare(layoutNode.getPlaceOrder$ui(), layoutNode2.getPlaceOrder$ui()) : Float.compare(layoutNode.getZIndex$1(), layoutNode2.getZIndex$1());
            case 1:
                int iCompare2 = ((SemanticsSortKt$special$$inlined$thenBy$1) obj3).compare(obj, obj2);
                return iCompare2 != 0 ? iCompare2 : Integer.valueOf(((SemanticsNode) obj).id).compareTo(Integer.valueOf(((SemanticsNode) obj2).id));
            case 2:
                TemperatureCache temperatureCache = (TemperatureCache) obj3;
                return RegexKt.compareValues((Comparable) ((HashMap) temperatureCache.getTempsByHct()).get((Hct) obj), (Comparable) ((HashMap) temperatureCache.getTempsByHct()).get((Hct) obj2));
            case 3:
                int iCompare3 = ((FormatSelectorsKt$special$$inlined$compareBy$1) obj3).compare(obj, obj2);
                if (iCompare3 != 0) {
                    return iCompare3;
                }
                Integer num6 = ((PlayerResponse.StreamingData.Format) obj).audioChannels;
                if (num6 != null && num6.intValue() == 2) {
                    i = 2;
                } else {
                    i = num6 == null ? 1 : 0;
                }
                Integer numValueOf2 = Integer.valueOf(i);
                Integer num7 = ((PlayerResponse.StreamingData.Format) obj2).audioChannels;
                if (num7 == null || num7.intValue() != 2) {
                    i8 = num7 == null ? 1 : 0;
                }
                return numValueOf2.compareTo(Integer.valueOf(i8));
            case 4:
                int iCompare4 = ((SemanticsSortKt$special$$inlined$thenBy$1) obj3).compare(obj, obj2);
                if (iCompare4 != 0) {
                    return iCompare4;
                }
                Integer num8 = ((PlayerResponse.StreamingData.Format) obj).audioSampleRate;
                Integer numValueOf3 = Integer.valueOf(UuidKt.coerceIn(num8 != null ? num8.intValue() : 0, 0, 48000));
                Integer num9 = ((PlayerResponse.StreamingData.Format) obj2).audioSampleRate;
                return numValueOf3.compareTo(Integer.valueOf(UuidKt.coerceIn(num9 != null ? num9.intValue() : 0, 0, 48000)));
            case 5:
                int iCompare5 = ((SemanticsSortKt$special$$inlined$thenBy$1) obj3).compare(obj, obj2);
                if (iCompare5 != 0) {
                    return iCompare5;
                }
                PlayerResponse.StreamingData.Format format = (PlayerResponse.StreamingData.Format) obj;
                if (StringsKt.contains(format.mimeType, "audio/webm", false)) {
                    i2 = 2;
                } else {
                    i2 = StringsKt.contains(format.mimeType, "audio/mp4", false) ? 1 : 0;
                }
                Integer numValueOf4 = Integer.valueOf(i2);
                PlayerResponse.StreamingData.Format format2 = (PlayerResponse.StreamingData.Format) obj2;
                if (!StringsKt.contains(format2.mimeType, "audio/webm", false)) {
                    i8 = StringsKt.contains(format2.mimeType, "audio/mp4", false) ? 1 : 0;
                }
                return numValueOf4.compareTo(Integer.valueOf(i8));
            case 6:
                Integer num10 = 1;
                int iCompare6 = ((FormatSelectorsKt$special$$inlined$compareBy$1) obj3).compare(obj, obj2);
                if (iCompare6 != 0) {
                    return iCompare6;
                }
                String str = ((PlayerResponse.StreamingData.Format) obj).mimeType;
                Locale locale = Locale.ROOT;
                String lowerCase = str.toLowerCase(locale);
                lowerCase.getClass();
                if (StringsKt.contains(lowerCase, "av01", false)) {
                    num = num10;
                } else {
                    num = (StringsKt.contains(lowerCase, "avc1", false) || StringsKt.contains(lowerCase, "vp09", false) || StringsKt.contains(lowerCase, "vp9", false) || StringsKt.contains(lowerCase, "video/mp4", false) || StringsKt.contains(lowerCase, "video/webm", false)) ? 2 : 0;
                }
                String lowerCase2 = ((PlayerResponse.StreamingData.Format) obj2).mimeType.toLowerCase(locale);
                lowerCase2.getClass();
                if (!StringsKt.contains(lowerCase2, "av01", false)) {
                    num10 = (StringsKt.contains(lowerCase2, "avc1", false) || StringsKt.contains(lowerCase2, "vp09", false) || StringsKt.contains(lowerCase2, "vp9", false) || StringsKt.contains(lowerCase2, "video/mp4", false) || StringsKt.contains(lowerCase2, "video/webm", false)) ? 2 : 0;
                }
                return num.compareTo(num10);
            case 7:
                Comparable comparable = Integer.MAX_VALUE;
                int iCompare7 = ((SemanticsSortKt$special$$inlined$thenBy$1) obj3).compare(obj, obj2);
                if (iCompare7 != 0) {
                    return iCompare7;
                }
                int i9 = ((PlayerResponse.StreamingData.Format) obj2).bitrate;
                Integer numValueOf5 = Integer.valueOf(i9);
                if (i9 <= 0) {
                    num2 = numValueOf5;
                    num2 = 0;
                }
                if (num2 == 0) {
                    num2 = comparable;
                }
                int i10 = ((PlayerResponse.StreamingData.Format) obj).bitrate;
                Comparable comparableValueOf = i10 > 0 ? Integer.valueOf(i10) : null;
                return num2.compareTo(comparableValueOf != null ? comparableValueOf : Integer.MAX_VALUE);
            case 8:
                int iValueOf = 0;
                SelectedClient selectedClient = (SelectedClient) obj;
                ClientSelectionRequest clientSelectionRequest = (ClientSelectionRequest) obj3;
                ContentHints contentHints = clientSelectionRequest.hints;
                PlaybackTransportPreference playbackTransportPreference = clientSelectionRequest.transportPreference;
                int iOrdinal = playbackTransportPreference.ordinal();
                if (iOrdinal != 0) {
                    numValueOf = iOrdinal != 2 ? 0 : Integer.valueOf(!selectedClient.client.useSabr ? 1 : 0);
                } else {
                    if (selectedClient.client.useSabr) {
                        i3 = 2;
                    } else if (Intrinsics.areEqual(contentHints.isKidsContent, Boolean.TRUE)) {
                        YouTubeClient youTubeClient = selectedClient.client;
                        YouTubeClient.INSTANCE.getClass();
                        if (Intrinsics.areEqual(youTubeClient, YouTubeClient.WEB_KIDS)) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                    } else {
                        i3 = 1;
                    }
                    numValueOf = Integer.valueOf(i3);
                }
                SelectedClient selectedClient2 = (SelectedClient) obj2;
                int iOrdinal2 = playbackTransportPreference.ordinal();
                if (iOrdinal2 == 0) {
                    if (!selectedClient2.client.useSabr) {
                        if (Intrinsics.areEqual(contentHints.isKidsContent, Boolean.TRUE)) {
                            YouTubeClient youTubeClient2 = selectedClient2.client;
                            YouTubeClient.INSTANCE.getClass();
                            if (Intrinsics.areEqual(youTubeClient2, YouTubeClient.WEB_KIDS)) {
                                i8 = 0;
                            } else {
                                i8 = 1;
                            }
                        } else {
                            i8 = 1;
                        }
                    }
                    iValueOf = Integer.valueOf(i8);
                } else if (iOrdinal2 == 2) {
                    iValueOf = Integer.valueOf(!selectedClient2.client.useSabr ? 1 : 0);
                }
                return numValueOf.compareTo(iValueOf);
            case 9:
                int iCompare8 = ((SemanticsSortKt$special$$inlined$thenBy$1) obj3).compare(obj, obj2);
                if (iCompare8 != 0) {
                    return iCompare8;
                }
                PlaybackClientManifest playbackClientManifest = ((SelectedClient) obj).manifest;
                String str2 = playbackClientManifest != null ? playbackClientManifest.id : null;
                PlaybackClientManifest playbackClientManifest2 = ((SelectedClient) obj2).manifest;
                return RegexKt.compareValues(str2, playbackClientManifest2 != null ? playbackClientManifest2.id : null);
            case 10:
                int iCompare9 = ((LrcLib$getAllLyrics$$inlined$sortedByDescending$1) obj3).compare(obj, obj2);
                return iCompare9 != 0 ? iCompare9 : Integer.valueOf(((SelectedClient) obj2).score).compareTo(Integer.valueOf(((SelectedClient) obj).score));
            case 11:
                Integer num11 = 100;
                Integer numValueOf6 = Integer.valueOf(CIOKt.DEFAULT_HTTP_POOL_SIZE);
                Locale locale2 = Locale.ROOT;
                String lowerCase3 = ((String) obj2).toLowerCase(locale2);
                lowerCase3.getClass();
                String str3 = (String) obj3;
                if (str3.length() == 0) {
                    num3 = 0;
                } else if (lowerCase3.equals(str3)) {
                    num3 = 2000;
                } else {
                    num3 = StringsKt__StringsJVMKt.startsWith(lowerCase3, str3, false) ? numValueOf6 : num11;
                }
                String lowerCase4 = ((String) obj).toLowerCase(locale2);
                lowerCase4.getClass();
                if (str3.length() == 0) {
                    num11 = 0;
                } else if (lowerCase4.equals(str3)) {
                    num11 = 2000;
                } else if (StringsKt__StringsJVMKt.startsWith(lowerCase4, str3, false)) {
                    num11 = numValueOf6;
                }
                return num3.compareTo(num11);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                int iCompare10 = ((SemanticsSortKt$special$$inlined$thenBy$1) obj3).compare(obj, obj2);
                return iCompare10 != 0 ? iCompare10 : RegexKt.compareValues((String) obj, (String) obj2);
            case 13:
                HomeSection homeSection = (HomeSection) obj2;
                ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = (ParcelableSnapshotMutableLongState) obj3;
                long longValue = parcelableSnapshotMutableLongState.getLongValue() + ((long) homeSection.id.hashCode());
                XorWowRandom xorWowRandom = new XorWowRandom((int) longValue, (int) (longValue >> 32));
                HomeSection.SpeedDial speedDial = HomeSection.SpeedDial.INSTANCE;
                boolean zEquals = homeSection.equals(speedDial);
                HomeSection.FromTheCommunity fromTheCommunity = HomeSection.FromTheCommunity.INSTANCE;
                HomeSection.ForgottenFavorites forgottenFavorites = HomeSection.ForgottenFavorites.INSTANCE;
                HomeSection.AccountPlaylists accountPlaylists = HomeSection.AccountPlaylists.INSTANCE;
                HomeSection.KeepListening keepListening = HomeSection.KeepListening.INSTANCE;
                HomeSection.DailyDiscover dailyDiscover = HomeSection.DailyDiscover.INSTANCE;
                HomeSection.QuickPicks quickPicks = HomeSection.QuickPicks.INSTANCE;
                if (zEquals || homeSection.equals(quickPicks) || homeSection.equals(dailyDiscover)) {
                    i4 = CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION;
                } else {
                    i4 = (homeSection.equals(keepListening) || homeSection.equals(accountPlaylists) || homeSection.equals(forgottenFavorites) || homeSection.equals(fromTheCommunity)) ? 300 : 100;
                }
                if (homeSection.equals(speedDial) || homeSection.equals(quickPicks) || homeSection.equals(dailyDiscover)) {
                    iNextInt = xorWowRandom.nextInt(-200, 400);
                } else {
                    iNextInt = (homeSection.equals(keepListening) || homeSection.equals(accountPlaylists) || homeSection.equals(forgottenFavorites) || homeSection.equals(fromTheCommunity)) ? xorWowRandom.nextInt(-100, 400) : xorWowRandom.nextInt(-50, 50);
                }
                Integer numValueOf7 = Integer.valueOf(i4 + iNextInt);
                HomeSection homeSection2 = (HomeSection) obj;
                long longValue2 = parcelableSnapshotMutableLongState.getLongValue() + ((long) homeSection2.id.hashCode());
                XorWowRandom xorWowRandom2 = new XorWowRandom((int) longValue2, (int) (longValue2 >> 32));
                if (homeSection2.equals(speedDial) || homeSection2.equals(quickPicks) || homeSection2.equals(dailyDiscover)) {
                    i5 = CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION;
                } else {
                    i5 = (homeSection2.equals(keepListening) || homeSection2.equals(accountPlaylists) || homeSection2.equals(forgottenFavorites) || homeSection2.equals(fromTheCommunity)) ? 300 : 100;
                }
                if (!homeSection2.equals(speedDial) && !homeSection2.equals(quickPicks)) {
                    if (homeSection2.equals(dailyDiscover)) {
                        i7 = -200;
                        i6 = 400;
                    } else {
                        iNextInt2 = (homeSection2.equals(keepListening) || homeSection2.equals(accountPlaylists) || homeSection2.equals(forgottenFavorites) || homeSection2.equals(fromTheCommunity)) ? xorWowRandom2.nextInt(-100, 400) : xorWowRandom2.nextInt(-50, 50);
                    }
                    return numValueOf7.compareTo(Integer.valueOf(i5 + iNextInt2));
                }
                i6 = 400;
                i7 = -200;
                iNextInt2 = xorWowRandom2.nextInt(i7, i6);
                return numValueOf7.compareTo(Integer.valueOf(i5 + iNextInt2));
            case 14:
                Map map = (Map) obj3;
                HomeSection homeSection3 = (HomeSection) obj2;
                if (homeSection3 == null) {
                    num4 = (Integer) map.get(homeSection3);
                    if (num4 != null) {
                        iIntValue = num4.intValue();
                    } else {
                        iIntValue = 0;
                    }
                } else if (homeSection3 instanceof HomeSection.SimilarRecommendation) {
                    iIntValue = 30 - ((HomeSection.SimilarRecommendation) homeSection3).index;
                } else if (homeSection3 instanceof HomeSection.HomePageSection) {
                    iIntValue = 20 - ((HomeSection.HomePageSection) homeSection3).index;
                } else {
                    num4 = (Integer) map.get(homeSection3);
                    if (num4 != null) {
                        iIntValue = num4.intValue();
                    } else {
                        iIntValue = 0;
                    }
                }
                Integer numValueOf8 = Integer.valueOf(iIntValue);
                HomeSection homeSection4 = (HomeSection) obj;
                if (homeSection4 == null) {
                    num5 = (Integer) map.get(homeSection4);
                    if (num5 != null) {
                        iIntValue2 = num5.intValue();
                    }
                } else if (homeSection4 instanceof HomeSection.SimilarRecommendation) {
                    iIntValue2 = 30 - ((HomeSection.SimilarRecommendation) homeSection4).index;
                } else if (homeSection4 instanceof HomeSection.HomePageSection) {
                    iIntValue2 = 20 - ((HomeSection.HomePageSection) homeSection4).index;
                } else {
                    num5 = (Integer) map.get(homeSection4);
                    if (num5 != null) {
                        iIntValue2 = num5.intValue();
                    }
                }
                return numValueOf8.compareTo(Integer.valueOf(iIntValue2));
            default:
                LocalDate localDate = ((HistoryViewModel) obj3).today;
                Long lValueOf2 = 3L;
                DateAgo dateAgo = (DateAgo) obj;
                DateAgo.Today today = DateAgo.Today.INSTANCE;
                boolean zAreEqual = Intrinsics.areEqual(dateAgo, today);
                DateAgo.LastWeek lastWeek = DateAgo.LastWeek.INSTANCE;
                DateAgo.ThisWeek thisWeek = DateAgo.ThisWeek.INSTANCE;
                DateAgo.Yesterday yesterday = DateAgo.Yesterday.INSTANCE;
                if (zAreEqual) {
                    lValueOf = 0L;
                } else if (Intrinsics.areEqual(dateAgo, yesterday)) {
                    lValueOf = 1L;
                } else if (Intrinsics.areEqual(dateAgo, thisWeek)) {
                    lValueOf = 2L;
                } else {
                    if (!Intrinsics.areEqual(dateAgo, lastWeek)) {
                        if (dateAgo instanceof DateAgo.Other) {
                            lValueOf = Long.valueOf(ChronoUnit.DAYS.between(((DateAgo.Other) dateAgo).date, localDate));
                        }
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return 0;
                    }
                    lValueOf = lValueOf2;
                }
                DateAgo dateAgo2 = (DateAgo) obj2;
                if (Intrinsics.areEqual(dateAgo2, today)) {
                    lValueOf2 = 0L;
                } else if (Intrinsics.areEqual(dateAgo2, yesterday)) {
                    lValueOf2 = 1L;
                } else if (Intrinsics.areEqual(dateAgo2, thisWeek)) {
                    lValueOf2 = 2L;
                } else if (!Intrinsics.areEqual(dateAgo2, lastWeek)) {
                    if (dateAgo2 instanceof DateAgo.Other) {
                        lValueOf2 = Long.valueOf(ChronoUnit.DAYS.between(((DateAgo.Other) dateAgo2).date, localDate));
                    }
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return 0;
                }
                return lValueOf.compareTo(lValueOf2);
        }
    }
}
