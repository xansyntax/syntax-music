package com.metrolist.innertube.models.response;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.Continuation$$serializer;
import com.metrolist.innertube.models.GridRenderer$Item$$serializer;
import com.metrolist.innertube.models.MusicShelfRenderer$Content$$serializer;
import com.metrolist.innertube.models.SectionListRenderer$Content$$serializer;
import com.metrolist.innertube.models.Tabs$Tab$$serializer;
import com.metrolist.innertube.models.Thumbnail$$serializer;
import com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults;
import com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$$serializer;
import com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$$serializer;
import com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Title$Run$$serializer;
import com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Title$Run$$serializer;
import com.metrolist.innertubex.extraction.strategy.ClientFailureKind;
import com.metrolist.innertubex.extraction.strategy.ClientHealthContent;
import com.metrolist.innertubex.extraction.strategy.ClientHealthScope;
import kotlin.jvm.functions.Function0;
import kotlin.text.HexFormatKt;
import kotlin.time.InstantJvmKt;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.HashSetSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BrowseResponse$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ BrowseResponse$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                BrowseResponse.Companion companion = BrowseResponse.Companion;
                return new HashSetSerializer(BrowseResponse$ResponseAction$$serializer.INSTANCE, (byte) 1);
            case 1:
                YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Companion companion2 = YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Companion;
                return new HashSetSerializer(HexFormatKt.getNullable(YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$$serializer.INSTANCE), (byte) 1);
            case 2:
                YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.ItemSectionRenderer.Companion companion3 = YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.ItemSectionRenderer.Companion;
                return new HashSetSerializer(HexFormatKt.getNullable(YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$$serializer.INSTANCE), (byte) 1);
            case 3:
                YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.Title.Companion companion4 = YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoPrimaryInfoRenderer.Title.Companion;
                return new HashSetSerializer(YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Title$Run$$serializer.INSTANCE, (byte) 1);
            case 4:
                YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Thumbnail.Companion companion5 = YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Thumbnail.Companion;
                return new HashSetSerializer(Thumbnail$$serializer.INSTANCE, (byte) 1);
            case 5:
                YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Title.Companion companion6 = YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Title.Companion;
                return new HashSetSerializer(YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Title$Run$$serializer.INSTANCE, (byte) 1);
            case 6:
                AccountMenuResponse.Companion companion7 = AccountMenuResponse.Companion;
                return new HashSetSerializer(AccountMenuResponse$Action$$serializer.INSTANCE, (byte) 1);
            case 7:
                BrowseResponse.ContinuationContents.GridContinuation.Companion companion8 = BrowseResponse.ContinuationContents.GridContinuation.Companion;
                return new HashSetSerializer(GridRenderer$Item$$serializer.INSTANCE, (byte) 1);
            case 8:
                BrowseResponse.ContinuationContents.GridContinuation.Companion companion9 = BrowseResponse.ContinuationContents.GridContinuation.Companion;
                return new HashSetSerializer(Continuation$$serializer.INSTANCE, (byte) 1);
            case 9:
                BrowseResponse.ContinuationContents.MusicPlaylistShelfContinuation.Companion companion10 = BrowseResponse.ContinuationContents.MusicPlaylistShelfContinuation.Companion;
                return new HashSetSerializer(MusicShelfRenderer$Content$$serializer.INSTANCE, (byte) 1);
            case 10:
                BrowseResponse.ContinuationContents.MusicPlaylistShelfContinuation.Companion companion11 = BrowseResponse.ContinuationContents.MusicPlaylistShelfContinuation.Companion;
                return new HashSetSerializer(Continuation$$serializer.INSTANCE, (byte) 1);
            case 11:
                BrowseResponse.ContinuationContents.SectionListContinuation.Companion companion12 = BrowseResponse.ContinuationContents.SectionListContinuation.Companion;
                return new HashSetSerializer(SectionListRenderer$Content$$serializer.INSTANCE, (byte) 1);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                BrowseResponse.ContinuationContents.SectionListContinuation.Companion companion13 = BrowseResponse.ContinuationContents.SectionListContinuation.Companion;
                return new HashSetSerializer(Continuation$$serializer.INSTANCE, (byte) 1);
            case 13:
                BrowseResponse.Header.MusicHeaderRenderer.Companion companion14 = BrowseResponse.Header.MusicHeaderRenderer.Companion;
                return new HashSetSerializer(BrowseResponse$Header$Buttons$$serializer.INSTANCE, (byte) 1);
            case 14:
                BrowseResponse.Header.MusicThumbnailRenderer.Companion companion15 = BrowseResponse.Header.MusicThumbnailRenderer.Companion;
                return new HashSetSerializer(BrowseResponse$Header$MusicThumbnail$$serializer.INSTANCE, (byte) 1);
            case 15:
                BrowseResponse.ResponseAction.ContinuationItems.Companion companion16 = BrowseResponse.ResponseAction.ContinuationItems.Companion;
                return new HashSetSerializer(MusicShelfRenderer$Content$$serializer.INSTANCE, (byte) 1);
            case 16:
                BrowseResponse.TwoColumnBrowseResultsRenderer.Companion companion17 = BrowseResponse.TwoColumnBrowseResultsRenderer.Companion;
                return new HashSetSerializer(HexFormatKt.getNullable(Tabs$Tab$$serializer.INSTANCE), (byte) 1);
            case 17:
                FeedbackResponse.Companion companion18 = FeedbackResponse.Companion;
                return new HashSetSerializer(FeedbackResponse$Status$$serializer.INSTANCE, (byte) 1);
            case 18:
                GetQueueResponse.Companion companion19 = GetQueueResponse.Companion;
                return new HashSetSerializer(GetQueueResponse$QueueData$$serializer.INSTANCE, (byte) 1);
            case 19:
                GetSearchSuggestionsResponse.Companion companion20 = GetSearchSuggestionsResponse.Companion;
                return new HashSetSerializer(GetSearchSuggestionsResponse$Content$$serializer.INSTANCE, (byte) 1);
            case 20:
                GetTranscriptResponse.Companion companion21 = GetTranscriptResponse.Companion;
                return new HashSetSerializer(GetTranscriptResponse$Action$$serializer.INSTANCE, (byte) 1);
            case 21:
                GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.Companion companion22 = GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.Companion;
                return new HashSetSerializer(GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$$serializer.INSTANCE, (byte) 1);
            case 22:
                GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup.TranscriptCueGroupRenderer.Companion companion23 = GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer.CueGroup.TranscriptCueGroupRenderer.Companion;
                return new HashSetSerializer(GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$$serializer.INSTANCE, (byte) 1);
            case 23:
                NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer.TabbedRenderer.WatchNextTabbedResultsRenderer.Companion companion24 = NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer.TabbedRenderer.WatchNextTabbedResultsRenderer.Companion;
                return new HashSetSerializer(Tabs$Tab$$serializer.INSTANCE, (byte) 1);
            case 24:
                SearchResponse.ContinuationContents.MusicShelfContinuation.Companion companion25 = SearchResponse.ContinuationContents.MusicShelfContinuation.Companion;
                return new HashSetSerializer(SearchResponse$ContinuationContents$MusicShelfContinuation$Content$$serializer.INSTANCE, (byte) 1);
            case 25:
                SearchResponse.ContinuationContents.MusicShelfContinuation.Companion companion26 = SearchResponse.ContinuationContents.MusicShelfContinuation.Companion;
                return new HashSetSerializer(Continuation$$serializer.INSTANCE, (byte) 1);
            case 26:
                return Long.valueOf(InstantJvmKt.systemClock.now().toEpochMilliseconds());
            case 27:
                ClientFailureKind[] clientFailureKindArrValues = ClientFailureKind.values();
                clientFailureKindArrValues.getClass();
                return new EnumSerializer("com.metrolist.innertubex.extraction.strategy.ClientFailureKind", clientFailureKindArrValues);
            case 28:
                ClientHealthContent[] clientHealthContentArrValues = ClientHealthContent.values();
                clientHealthContentArrValues.getClass();
                return new EnumSerializer("com.metrolist.innertubex.extraction.strategy.ClientHealthContent", clientHealthContentArrValues);
            default:
                ClientHealthScope.Companion companion27 = ClientHealthScope.Companion;
                return ClientHealthContent.Companion.serializer();
        }
    }
}
