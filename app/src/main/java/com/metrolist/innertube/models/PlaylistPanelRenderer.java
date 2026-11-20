package com.metrolist.innertube.models;

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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/PlaylistPanelRenderer;", "", "Companion", "Content", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class PlaylistPanelRenderer {
    public static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final List contents;
    public final List continuations;
    public final Boolean isInfinite;
    public final Integer numItemsToShow;
    public final String playlistId;
    public final Runs shortBylineText;
    public final String title;
    public final Runs titleText;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/PlaylistPanelRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/PlaylistPanelRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return PlaylistPanelRenderer$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/PlaylistPanelRenderer$Content;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Content {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final AutomixPreviewVideoRenderer automixPreviewVideoRenderer;
        public final PlaylistPanelVideoRenderer playlistPanelVideoRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/PlaylistPanelRenderer$Content$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/PlaylistPanelRenderer$Content;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return PlaylistPanelRenderer$Content$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Content(int i, PlaylistPanelVideoRenderer playlistPanelVideoRenderer, AutomixPreviewVideoRenderer automixPreviewVideoRenderer) {
            if (3 != (i & 3)) {
                EnumsKt.throwMissingFieldException(PlaylistPanelRenderer$Content$$serializer.INSTANCE.getDescriptor(), i, 3);
                throw null;
            }
            this.playlistPanelVideoRenderer = playlistPanelVideoRenderer;
            this.automixPreviewVideoRenderer = automixPreviewVideoRenderer;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Content)) {
                return false;
            }
            Content content = (Content) obj;
            return Intrinsics.areEqual(this.playlistPanelVideoRenderer, content.playlistPanelVideoRenderer) && Intrinsics.areEqual(this.automixPreviewVideoRenderer, content.automixPreviewVideoRenderer);
        }

        public final int hashCode() {
            PlaylistPanelVideoRenderer playlistPanelVideoRenderer = this.playlistPanelVideoRenderer;
            int iHashCode = (playlistPanelVideoRenderer == null ? 0 : playlistPanelVideoRenderer.hashCode()) * 31;
            AutomixPreviewVideoRenderer automixPreviewVideoRenderer = this.automixPreviewVideoRenderer;
            return iHashCode + (automixPreviewVideoRenderer != null ? automixPreviewVideoRenderer.content.hashCode() : 0);
        }

        public final String toString() {
            return "Content(playlistPanelVideoRenderer=" + this.playlistPanelVideoRenderer + ", automixPreviewVideoRenderer=" + this.automixPreviewVideoRenderer + ")";
        }
    }

    static {
        Runs$$ExternalSyntheticLambda0 runs$$ExternalSyntheticLambda0 = new Runs$$ExternalSyntheticLambda0((byte) 19);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, ResultKt.lazy(lazyThreadSafetyMode, runs$$ExternalSyntheticLambda0), null, null, null, ResultKt.lazy(lazyThreadSafetyMode, new Runs$$ExternalSyntheticLambda0((byte) 20))};
    }

    public /* synthetic */ PlaylistPanelRenderer(int i, String str, Runs runs, Runs runs2, List list, Boolean bool, Integer num, String str2, List list2) {
        if (255 != (i & 255)) {
            EnumsKt.throwMissingFieldException(PlaylistPanelRenderer$$serializer.INSTANCE.getDescriptor(), i, 255);
            throw null;
        }
        this.title = str;
        this.titleText = runs;
        this.shortBylineText = runs2;
        this.contents = list;
        this.isInfinite = bool;
        this.numItemsToShow = num;
        this.playlistId = str2;
        this.continuations = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaylistPanelRenderer)) {
            return false;
        }
        PlaylistPanelRenderer playlistPanelRenderer = (PlaylistPanelRenderer) obj;
        return Intrinsics.areEqual(this.title, playlistPanelRenderer.title) && Intrinsics.areEqual(this.titleText, playlistPanelRenderer.titleText) && Intrinsics.areEqual(this.shortBylineText, playlistPanelRenderer.shortBylineText) && Intrinsics.areEqual(this.contents, playlistPanelRenderer.contents) && Intrinsics.areEqual(this.isInfinite, playlistPanelRenderer.isInfinite) && Intrinsics.areEqual(this.numItemsToShow, playlistPanelRenderer.numItemsToShow) && Intrinsics.areEqual(this.playlistId, playlistPanelRenderer.playlistId) && Intrinsics.areEqual(this.continuations, playlistPanelRenderer.continuations);
    }

    public final int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Runs runs = this.titleText;
        int iHashCode2 = (iHashCode + (runs == null ? 0 : runs.hashCode())) * 31;
        Runs runs2 = this.shortBylineText;
        int iM = Fragment$5$$ExternalSyntheticOutline0.m((iHashCode2 + (runs2 == null ? 0 : runs2.hashCode())) * 31, 31, this.contents);
        Boolean bool = this.isInfinite;
        int iHashCode3 = (iM + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.numItemsToShow;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.playlistId;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List list = this.continuations;
        return iHashCode5 + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "PlaylistPanelRenderer(title=" + this.title + ", titleText=" + this.titleText + ", shortBylineText=" + this.shortBylineText + ", contents=" + this.contents + ", isInfinite=" + this.isInfinite + ", numItemsToShow=" + this.numItemsToShow + ", playlistId=" + this.playlistId + ", continuations=" + this.continuations + ")";
    }
}
