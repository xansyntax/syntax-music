package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/PlaylistPanelVideoRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class PlaylistPanelVideoRenderer {
    public final List badges;
    public final Runs lengthText;
    public final Runs longBylineText;
    public final Menu menu;
    public final NavigationEndpoint navigationEndpoint;
    public final String playlistSetVideoId;
    public final boolean selected;
    public final Runs shortBylineText;
    public final Thumbnails thumbnail;
    public final Runs title;
    public final Runs unplayableText;
    public final String videoId;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, null, null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Runs$$ExternalSyntheticLambda0(21)), null, null, null, null, null, null, null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/PlaylistPanelVideoRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/PlaylistPanelVideoRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return PlaylistPanelVideoRenderer$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ PlaylistPanelVideoRenderer(int i, Runs runs, Runs runs2, Runs runs3, Runs runs4, List list, String str, String str2, boolean z, Thumbnails thumbnails, Runs runs5, Menu menu, NavigationEndpoint navigationEndpoint) {
        if (4095 != (i & 4095)) {
            EnumsKt.throwMissingFieldException(PlaylistPanelVideoRenderer$$serializer.INSTANCE.getDescriptor(), i, 4095);
            throw null;
        }
        this.title = runs;
        this.lengthText = runs2;
        this.longBylineText = runs3;
        this.shortBylineText = runs4;
        this.badges = list;
        this.videoId = str;
        this.playlistSetVideoId = str2;
        this.selected = z;
        this.thumbnail = thumbnails;
        this.unplayableText = runs5;
        this.menu = menu;
        this.navigationEndpoint = navigationEndpoint;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaylistPanelVideoRenderer)) {
            return false;
        }
        PlaylistPanelVideoRenderer playlistPanelVideoRenderer = (PlaylistPanelVideoRenderer) obj;
        return Intrinsics.areEqual(this.title, playlistPanelVideoRenderer.title) && Intrinsics.areEqual(this.lengthText, playlistPanelVideoRenderer.lengthText) && Intrinsics.areEqual(this.longBylineText, playlistPanelVideoRenderer.longBylineText) && Intrinsics.areEqual(this.shortBylineText, playlistPanelVideoRenderer.shortBylineText) && Intrinsics.areEqual(this.badges, playlistPanelVideoRenderer.badges) && Intrinsics.areEqual(this.videoId, playlistPanelVideoRenderer.videoId) && Intrinsics.areEqual(this.playlistSetVideoId, playlistPanelVideoRenderer.playlistSetVideoId) && this.selected == playlistPanelVideoRenderer.selected && Intrinsics.areEqual(this.thumbnail, playlistPanelVideoRenderer.thumbnail) && Intrinsics.areEqual(this.unplayableText, playlistPanelVideoRenderer.unplayableText) && Intrinsics.areEqual(this.menu, playlistPanelVideoRenderer.menu) && Intrinsics.areEqual(this.navigationEndpoint, playlistPanelVideoRenderer.navigationEndpoint);
    }

    public final int hashCode() {
        Runs runs = this.title;
        int iHashCode = (runs == null ? 0 : runs.hashCode()) * 31;
        Runs runs2 = this.lengthText;
        int iHashCode2 = (iHashCode + (runs2 == null ? 0 : runs2.hashCode())) * 31;
        Runs runs3 = this.longBylineText;
        int iHashCode3 = (iHashCode2 + (runs3 == null ? 0 : runs3.hashCode())) * 31;
        Runs runs4 = this.shortBylineText;
        int iHashCode4 = (iHashCode3 + (runs4 == null ? 0 : runs4.hashCode())) * 31;
        List list = this.badges;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.videoId;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.playlistSetVideoId;
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31, this.selected, 31), 31, this.thumbnail.thumbnails);
        Runs runs5 = this.unplayableText;
        int iHashCode7 = (iM + (runs5 == null ? 0 : runs5.hashCode())) * 31;
        Menu menu = this.menu;
        return this.navigationEndpoint.hashCode() + ((iHashCode7 + (menu != null ? menu.menuRenderer.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "PlaylistPanelVideoRenderer(title=" + this.title + ", lengthText=" + this.lengthText + ", longBylineText=" + this.longBylineText + ", shortBylineText=" + this.shortBylineText + ", badges=" + this.badges + ", videoId=" + this.videoId + ", playlistSetVideoId=" + this.playlistSetVideoId + ", selected=" + this.selected + ", thumbnail=" + this.thumbnail + ", unplayableText=" + this.unplayableText + ", menu=" + this.menu + ", navigationEndpoint=" + this.navigationEndpoint + ")";
    }
}
