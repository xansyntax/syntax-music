package com.metrolist.innertube.models;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicTwoRowItemRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class MusicTwoRowItemRenderer {
    public final Menu menu;
    public final NavigationEndpoint navigationEndpoint;
    public final Runs subtitle;
    public final List subtitleBadges;
    public final MusicResponsiveListItemRenderer.Overlay thumbnailOverlay;
    public final ThumbnailRenderer thumbnailRenderer;
    public final Runs title;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Runs$$ExternalSyntheticLambda0(18)), null, null, null, null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicTwoRowItemRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicTwoRowItemRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return MusicTwoRowItemRenderer$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ MusicTwoRowItemRenderer(int i, Runs runs, Runs runs2, List list, Menu menu, ThumbnailRenderer thumbnailRenderer, NavigationEndpoint navigationEndpoint, MusicResponsiveListItemRenderer.Overlay overlay) {
        if (127 != (i & 127)) {
            EnumsKt.throwMissingFieldException(MusicTwoRowItemRenderer$$serializer.INSTANCE.getDescriptor(), i, 127);
            throw null;
        }
        this.title = runs;
        this.subtitle = runs2;
        this.subtitleBadges = list;
        this.menu = menu;
        this.thumbnailRenderer = thumbnailRenderer;
        this.navigationEndpoint = navigationEndpoint;
        this.thumbnailOverlay = overlay;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicTwoRowItemRenderer)) {
            return false;
        }
        MusicTwoRowItemRenderer musicTwoRowItemRenderer = (MusicTwoRowItemRenderer) obj;
        return Intrinsics.areEqual(this.title, musicTwoRowItemRenderer.title) && Intrinsics.areEqual(this.subtitle, musicTwoRowItemRenderer.subtitle) && Intrinsics.areEqual(this.subtitleBadges, musicTwoRowItemRenderer.subtitleBadges) && Intrinsics.areEqual(this.menu, musicTwoRowItemRenderer.menu) && Intrinsics.areEqual(this.thumbnailRenderer, musicTwoRowItemRenderer.thumbnailRenderer) && Intrinsics.areEqual(this.navigationEndpoint, musicTwoRowItemRenderer.navigationEndpoint) && Intrinsics.areEqual(this.thumbnailOverlay, musicTwoRowItemRenderer.thumbnailOverlay);
    }

    public final String getMusicVideoType() {
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
        NavigationEndpoint navigationEndpoint;
        String musicVideoType;
        MusicResponsiveListItemRenderer.Overlay overlay = this.thumbnailOverlay;
        return (overlay == null || (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) == null || (content = musicItemThumbnailOverlayRenderer.content) == null || (musicPlayButtonRenderer = content.musicPlayButtonRenderer) == null || (navigationEndpoint = musicPlayButtonRenderer.playNavigationEndpoint) == null || (musicVideoType = navigationEndpoint.getMusicVideoType()) == null) ? this.navigationEndpoint.getMusicVideoType() : musicVideoType;
    }

    public final int hashCode() {
        int iHashCode = this.title.hashCode() * 31;
        Runs runs = this.subtitle;
        int iHashCode2 = (iHashCode + (runs == null ? 0 : runs.hashCode())) * 31;
        List list = this.subtitleBadges;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Menu menu = this.menu;
        int iHashCode4 = (this.navigationEndpoint.hashCode() + ((this.thumbnailRenderer.hashCode() + ((iHashCode3 + (menu == null ? 0 : menu.menuRenderer.hashCode())) * 31)) * 31)) * 31;
        MusicResponsiveListItemRenderer.Overlay overlay = this.thumbnailOverlay;
        return iHashCode4 + (overlay != null ? overlay.musicItemThumbnailOverlayRenderer.hashCode() : 0);
    }

    public final boolean isAlbum() {
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs2;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig2;
        NavigationEndpoint navigationEndpoint = this.navigationEndpoint;
        BrowseEndpoint browseEndpoint = navigationEndpoint.browseEndpoint;
        String str = null;
        if (Intrinsics.areEqual((browseEndpoint == null || (browseEndpointContextSupportedConfigs2 = browseEndpoint.browseEndpointContextSupportedConfigs) == null || (browseEndpointContextMusicConfig2 = browseEndpointContextSupportedConfigs2.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig2.pageType, "MUSIC_PAGE_TYPE_ALBUM")) {
            return true;
        }
        BrowseEndpoint browseEndpoint2 = navigationEndpoint.browseEndpoint;
        if (browseEndpoint2 != null && (browseEndpointContextSupportedConfigs = browseEndpoint2.browseEndpointContextSupportedConfigs) != null && (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) != null) {
            str = browseEndpointContextMusicConfig.pageType;
        }
        return Intrinsics.areEqual(str, "MUSIC_PAGE_TYPE_AUDIOBOOK");
    }

    public final boolean isArtist() {
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
        BrowseEndpoint browseEndpoint = this.navigationEndpoint.browseEndpoint;
        return Intrinsics.areEqual((browseEndpoint == null || (browseEndpointContextSupportedConfigs = browseEndpoint.browseEndpointContextSupportedConfigs) == null || (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig.pageType, "MUSIC_PAGE_TYPE_ARTIST");
    }

    public final boolean isEpisode() {
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
        BrowseEndpoint browseEndpoint = this.navigationEndpoint.browseEndpoint;
        return Intrinsics.areEqual((browseEndpoint == null || (browseEndpointContextSupportedConfigs = browseEndpoint.browseEndpointContextSupportedConfigs) == null || (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig.pageType, "MUSIC_PAGE_TYPE_NON_MUSIC_AUDIO_TRACK_PAGE");
    }

    public final boolean isPlaylist() {
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
        BrowseEndpoint browseEndpoint = this.navigationEndpoint.browseEndpoint;
        return Intrinsics.areEqual((browseEndpoint == null || (browseEndpointContextSupportedConfigs = browseEndpoint.browseEndpointContextSupportedConfigs) == null || (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig.pageType, "MUSIC_PAGE_TYPE_PLAYLIST");
    }

    public final boolean isPodcast() {
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
        BrowseEndpoint browseEndpoint = this.navigationEndpoint.browseEndpoint;
        return Intrinsics.areEqual((browseEndpoint == null || (browseEndpointContextSupportedConfigs = browseEndpoint.browseEndpointContextSupportedConfigs) == null || (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig.pageType, "MUSIC_PAGE_TYPE_PODCAST_SHOW_DETAIL_PAGE");
    }

    public final boolean isSong() {
        NavigationEndpoint navigationEndpoint = this.navigationEndpoint;
        Endpoint endpoint = navigationEndpoint.watchEndpoint;
        if (endpoint == null && (endpoint = navigationEndpoint.watchPlaylistEndpoint) == null && (endpoint = navigationEndpoint.browseEndpoint) == null && (endpoint = navigationEndpoint.searchEndpoint) == null && (endpoint = navigationEndpoint.queueAddEndpoint) == null) {
            endpoint = navigationEndpoint.shareEntityEndpoint;
        }
        return endpoint instanceof WatchEndpoint;
    }

    public final String toString() {
        return "MusicTwoRowItemRenderer(title=" + this.title + ", subtitle=" + this.subtitle + ", subtitleBadges=" + this.subtitleBadges + ", menu=" + this.menu + ", thumbnailRenderer=" + this.thumbnailRenderer + ", navigationEndpoint=" + this.navigationEndpoint + ", thumbnailOverlay=" + this.thumbnailOverlay + ")";
    }
}
