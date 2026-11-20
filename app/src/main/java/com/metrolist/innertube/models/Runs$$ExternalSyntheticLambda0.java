package com.metrolist.innertube.models;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.internal.HashSetSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Runs$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ Runs$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                Runs.Companion companion = Runs.INSTANCE;
                return new HashSetSerializer(Run$$serializer.INSTANCE, (byte) 1);
            case 1:
                GridRenderer.Companion companion2 = GridRenderer.INSTANCE;
                return new HashSetSerializer(GridRenderer$Item$$serializer.INSTANCE, (byte) 1);
            case 2:
                GridRenderer.Companion companion3 = GridRenderer.INSTANCE;
                return new HashSetSerializer(Continuation$$serializer.INSTANCE, (byte) 1);
            case 3:
                ItemSectionRenderer.Companion companion4 = ItemSectionRenderer.INSTANCE;
                return new HashSetSerializer(ItemSectionRenderer$Content$$serializer.INSTANCE, (byte) 1);
            case 4:
                Menu.MenuRenderer.Companion companion5 = Menu.MenuRenderer.INSTANCE;
                return new HashSetSerializer(Menu$MenuRenderer$Item$$serializer.INSTANCE, (byte) 1);
            case 5:
                Menu.MenuRenderer.Companion companion6 = Menu.MenuRenderer.INSTANCE;
                return new HashSetSerializer(Menu$MenuRenderer$TopLevelButton$$serializer.INSTANCE, (byte) 1);
            case 6:
                MusicCardShelfRenderer.Companion companion7 = MusicCardShelfRenderer.INSTANCE;
                return new HashSetSerializer(MusicCardShelfRenderer$Content$$serializer.INSTANCE, (byte) 1);
            case 7:
                MusicCardShelfRenderer.Companion companion8 = MusicCardShelfRenderer.INSTANCE;
                return new HashSetSerializer(Button$$serializer.INSTANCE, (byte) 1);
            case 8:
                MusicCardShelfRenderer.Companion companion9 = MusicCardShelfRenderer.INSTANCE;
                return new HashSetSerializer(Badges$$serializer.INSTANCE, (byte) 1);
            case 9:
                MusicCarouselShelfRenderer.Companion companion10 = MusicCarouselShelfRenderer.INSTANCE;
                return new HashSetSerializer(MusicCarouselShelfRenderer$Content$$serializer.INSTANCE, (byte) 1);
            case 10:
                MusicPlaylistShelfRenderer.Companion companion11 = MusicPlaylistShelfRenderer.INSTANCE;
                return new HashSetSerializer(MusicShelfRenderer$Content$$serializer.INSTANCE, (byte) 1);
            case 11:
                MusicPlaylistShelfRenderer.Companion companion12 = MusicPlaylistShelfRenderer.INSTANCE;
                return new HashSetSerializer(Continuation$$serializer.INSTANCE, (byte) 1);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                MusicResponsiveHeaderRenderer.Companion companion13 = MusicResponsiveHeaderRenderer.INSTANCE;
                return new HashSetSerializer(MusicResponsiveHeaderRenderer$Button$$serializer.INSTANCE, (byte) 1);
            case 13:
                MusicResponsiveListItemRenderer.Companion companion14 = MusicResponsiveListItemRenderer.INSTANCE;
                return new HashSetSerializer(Badges$$serializer.INSTANCE, (byte) 1);
            case 14:
                MusicResponsiveListItemRenderer.Companion companion15 = MusicResponsiveListItemRenderer.INSTANCE;
                return new HashSetSerializer(MusicResponsiveListItemRenderer$FlexColumn$$serializer.INSTANCE, (byte) 1);
            case 15:
                MusicResponsiveListItemRenderer.Companion companion16 = MusicResponsiveListItemRenderer.INSTANCE;
                return new HashSetSerializer(MusicResponsiveListItemRenderer$FlexColumn$$serializer.INSTANCE, (byte) 1);
            case 16:
                MusicShelfRenderer.Companion companion17 = MusicShelfRenderer.INSTANCE;
                return new HashSetSerializer(MusicShelfRenderer$Content$$serializer.INSTANCE, (byte) 1);
            case 17:
                MusicShelfRenderer.Companion companion18 = MusicShelfRenderer.INSTANCE;
                return new HashSetSerializer(Continuation$$serializer.INSTANCE, (byte) 1);
            case 18:
                MusicTwoRowItemRenderer.Companion companion19 = MusicTwoRowItemRenderer.INSTANCE;
                return new HashSetSerializer(Badges$$serializer.INSTANCE, (byte) 1);
            case 19:
                PlaylistPanelRenderer.Companion companion20 = PlaylistPanelRenderer.INSTANCE;
                return new HashSetSerializer(PlaylistPanelRenderer$Content$$serializer.INSTANCE, (byte) 1);
            case 20:
                PlaylistPanelRenderer.Companion companion21 = PlaylistPanelRenderer.INSTANCE;
                return new HashSetSerializer(Continuation$$serializer.INSTANCE, (byte) 1);
            case 21:
                PlaylistPanelVideoRenderer.Companion companion22 = PlaylistPanelVideoRenderer.INSTANCE;
                return new HashSetSerializer(Badges$$serializer.INSTANCE, (byte) 1);
            case 22:
                ResponseContext.Companion companion23 = ResponseContext.INSTANCE;
                return new HashSetSerializer(ResponseContext$ServiceTrackingParam$$serializer.INSTANCE, (byte) 1);
            case 23:
                ResponseContext.ServiceTrackingParam.Companion companion24 = ResponseContext.ServiceTrackingParam.INSTANCE;
                return new HashSetSerializer(ResponseContext$ServiceTrackingParam$Param$$serializer.INSTANCE, (byte) 1);
            case 24:
                SearchSuggestionsSectionRenderer.Companion companion25 = SearchSuggestionsSectionRenderer.INSTANCE;
                return new HashSetSerializer(SearchSuggestionsSectionRenderer$Content$$serializer.INSTANCE, (byte) 1);
            case 25:
                SectionListRenderer.Companion companion26 = SectionListRenderer.INSTANCE;
                return new HashSetSerializer(SectionListRenderer$Content$$serializer.INSTANCE, (byte) 1);
            case 26:
                SectionListRenderer.Companion companion27 = SectionListRenderer.INSTANCE;
                return new HashSetSerializer(Continuation$$serializer.INSTANCE, (byte) 1);
            case 27:
                SectionListRenderer.Header.ChipCloudRenderer.Companion companion28 = SectionListRenderer.Header.ChipCloudRenderer.INSTANCE;
                return new HashSetSerializer(SectionListRenderer$Header$ChipCloudRenderer$Chip$$serializer.INSTANCE, (byte) 1);
            case 28:
                Tabs.Companion companion29 = Tabs.INSTANCE;
                return new HashSetSerializer(Tabs$Tab$$serializer.INSTANCE, (byte) 1);
            default:
                Thumbnails.Companion companion30 = Thumbnails.INSTANCE;
                return new HashSetSerializer(Thumbnail$$serializer.INSTANCE, (byte) 1);
        }
    }
}
