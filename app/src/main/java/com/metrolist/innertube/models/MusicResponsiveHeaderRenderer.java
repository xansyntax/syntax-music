package com.metrolist.innertube.models;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveHeaderRenderer;", "", "Companion", "Button", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class MusicResponsiveHeaderRenderer {
    public final List buttons;
    public final DescriptionWrapper description;
    public final FacepileWrapper facepile;
    public final Runs secondSubtitle;
    public final Runs straplineTextOne;
    public final Runs subtitle;
    public final ThumbnailRenderer thumbnail;
    public final Runs title;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Runs$$ExternalSyntheticLambda0(12)), null, null, null, null, null, null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0004\u0003\u0004\u0005\u0002¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveHeaderRenderer$Button;", "", "Companion", "MusicPlayButtonRenderer", "ToggleButtonRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Button {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final Menu.MenuRenderer menuRenderer;
        public final MusicPlayButtonRenderer musicPlayButtonRenderer;
        public final ToggleButtonRenderer toggleButtonRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveHeaderRenderer$Button$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicResponsiveHeaderRenderer$Button;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return MusicResponsiveHeaderRenderer$Button$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveHeaderRenderer$Button$MusicPlayButtonRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class MusicPlayButtonRenderer {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final NavigationEndpoint playNavigationEndpoint;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveHeaderRenderer$Button$MusicPlayButtonRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicResponsiveHeaderRenderer$Button$MusicPlayButtonRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return MusicResponsiveHeaderRenderer$Button$MusicPlayButtonRenderer$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ MusicPlayButtonRenderer(int i, NavigationEndpoint navigationEndpoint) {
                if ((i & 1) == 0) {
                    this.playNavigationEndpoint = null;
                } else {
                    this.playNavigationEndpoint = navigationEndpoint;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof MusicPlayButtonRenderer) && Intrinsics.areEqual(this.playNavigationEndpoint, ((MusicPlayButtonRenderer) obj).playNavigationEndpoint);
            }

            public final int hashCode() {
                NavigationEndpoint navigationEndpoint = this.playNavigationEndpoint;
                if (navigationEndpoint == null) {
                    return 0;
                }
                return navigationEndpoint.hashCode();
            }

            public final String toString() {
                return "MusicPlayButtonRenderer(playNavigationEndpoint=" + this.playNavigationEndpoint + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveHeaderRenderer$Button$ToggleButtonRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class ToggleButtonRenderer {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final Icon defaultIcon;
            public final DefaultServiceEndpoint defaultServiceEndpoint;
            public final ToggledServiceEndpoint toggledServiceEndpoint;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveHeaderRenderer$Button$ToggleButtonRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicResponsiveHeaderRenderer$Button$ToggleButtonRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return MusicResponsiveHeaderRenderer$Button$ToggleButtonRenderer$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ ToggleButtonRenderer(int i, Icon icon, DefaultServiceEndpoint defaultServiceEndpoint, ToggledServiceEndpoint toggledServiceEndpoint) {
                if ((i & 1) == 0) {
                    this.defaultIcon = null;
                } else {
                    this.defaultIcon = icon;
                }
                if ((i & 2) == 0) {
                    this.defaultServiceEndpoint = null;
                } else {
                    this.defaultServiceEndpoint = defaultServiceEndpoint;
                }
                if ((i & 4) == 0) {
                    this.toggledServiceEndpoint = null;
                } else {
                    this.toggledServiceEndpoint = toggledServiceEndpoint;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ToggleButtonRenderer)) {
                    return false;
                }
                ToggleButtonRenderer toggleButtonRenderer = (ToggleButtonRenderer) obj;
                return Intrinsics.areEqual(this.defaultIcon, toggleButtonRenderer.defaultIcon) && Intrinsics.areEqual(this.defaultServiceEndpoint, toggleButtonRenderer.defaultServiceEndpoint) && Intrinsics.areEqual(this.toggledServiceEndpoint, toggleButtonRenderer.toggledServiceEndpoint);
            }

            public final int hashCode() {
                Icon icon = this.defaultIcon;
                int iHashCode = (icon == null ? 0 : icon.iconType.hashCode()) * 31;
                DefaultServiceEndpoint defaultServiceEndpoint = this.defaultServiceEndpoint;
                int iHashCode2 = (iHashCode + (defaultServiceEndpoint == null ? 0 : defaultServiceEndpoint.hashCode())) * 31;
                ToggledServiceEndpoint toggledServiceEndpoint = this.toggledServiceEndpoint;
                return iHashCode2 + (toggledServiceEndpoint != null ? toggledServiceEndpoint.hashCode() : 0);
            }

            public final String toString() {
                return "ToggleButtonRenderer(defaultIcon=" + this.defaultIcon + ", defaultServiceEndpoint=" + this.defaultServiceEndpoint + ", toggledServiceEndpoint=" + this.toggledServiceEndpoint + ")";
            }
        }

        public /* synthetic */ Button(int i, MusicPlayButtonRenderer musicPlayButtonRenderer, Menu.MenuRenderer menuRenderer, ToggleButtonRenderer toggleButtonRenderer) {
            if ((i & 1) == 0) {
                this.musicPlayButtonRenderer = null;
            } else {
                this.musicPlayButtonRenderer = musicPlayButtonRenderer;
            }
            if ((i & 2) == 0) {
                this.menuRenderer = null;
            } else {
                this.menuRenderer = menuRenderer;
            }
            if ((i & 4) == 0) {
                this.toggleButtonRenderer = null;
            } else {
                this.toggleButtonRenderer = toggleButtonRenderer;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Button)) {
                return false;
            }
            Button button = (Button) obj;
            return Intrinsics.areEqual(this.musicPlayButtonRenderer, button.musicPlayButtonRenderer) && Intrinsics.areEqual(this.menuRenderer, button.menuRenderer) && Intrinsics.areEqual(this.toggleButtonRenderer, button.toggleButtonRenderer);
        }

        public final int hashCode() {
            MusicPlayButtonRenderer musicPlayButtonRenderer = this.musicPlayButtonRenderer;
            int iHashCode = (musicPlayButtonRenderer == null ? 0 : musicPlayButtonRenderer.hashCode()) * 31;
            Menu.MenuRenderer menuRenderer = this.menuRenderer;
            int iHashCode2 = (iHashCode + (menuRenderer == null ? 0 : menuRenderer.hashCode())) * 31;
            ToggleButtonRenderer toggleButtonRenderer = this.toggleButtonRenderer;
            return iHashCode2 + (toggleButtonRenderer != null ? toggleButtonRenderer.hashCode() : 0);
        }

        public final String toString() {
            return "Button(musicPlayButtonRenderer=" + this.musicPlayButtonRenderer + ", menuRenderer=" + this.menuRenderer + ", toggleButtonRenderer=" + this.toggleButtonRenderer + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveHeaderRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicResponsiveHeaderRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return MusicResponsiveHeaderRenderer$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ MusicResponsiveHeaderRenderer(int i, ThumbnailRenderer thumbnailRenderer, List list, Runs runs, Runs runs2, Runs runs3, Runs runs4, DescriptionWrapper descriptionWrapper, FacepileWrapper facepileWrapper) {
        if ((i & 1) == 0) {
            this.thumbnail = null;
        } else {
            this.thumbnail = thumbnailRenderer;
        }
        if ((i & 2) == 0) {
            this.buttons = EmptyList.INSTANCE;
        } else {
            this.buttons = list;
        }
        if ((i & 4) == 0) {
            this.title = new Runs();
        } else {
            this.title = runs;
        }
        if ((i & 8) == 0) {
            this.subtitle = new Runs();
        } else {
            this.subtitle = runs2;
        }
        if ((i & 16) == 0) {
            this.secondSubtitle = null;
        } else {
            this.secondSubtitle = runs3;
        }
        if ((i & 32) == 0) {
            this.straplineTextOne = null;
        } else {
            this.straplineTextOne = runs4;
        }
        if ((i & 64) == 0) {
            this.description = null;
        } else {
            this.description = descriptionWrapper;
        }
        if ((i & 128) == 0) {
            this.facepile = null;
        } else {
            this.facepile = facepileWrapper;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicResponsiveHeaderRenderer)) {
            return false;
        }
        MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer = (MusicResponsiveHeaderRenderer) obj;
        return Intrinsics.areEqual(this.thumbnail, musicResponsiveHeaderRenderer.thumbnail) && Intrinsics.areEqual(this.buttons, musicResponsiveHeaderRenderer.buttons) && Intrinsics.areEqual(this.title, musicResponsiveHeaderRenderer.title) && Intrinsics.areEqual(this.subtitle, musicResponsiveHeaderRenderer.subtitle) && Intrinsics.areEqual(this.secondSubtitle, musicResponsiveHeaderRenderer.secondSubtitle) && Intrinsics.areEqual(this.straplineTextOne, musicResponsiveHeaderRenderer.straplineTextOne) && Intrinsics.areEqual(this.description, musicResponsiveHeaderRenderer.description) && Intrinsics.areEqual(this.facepile, musicResponsiveHeaderRenderer.facepile);
    }

    public final int hashCode() {
        ThumbnailRenderer thumbnailRenderer = this.thumbnail;
        int iHashCode = (this.subtitle.hashCode() + ((this.title.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m((thumbnailRenderer == null ? 0 : thumbnailRenderer.hashCode()) * 31, 31, this.buttons)) * 31)) * 31;
        Runs runs = this.secondSubtitle;
        int iHashCode2 = (iHashCode + (runs == null ? 0 : runs.hashCode())) * 31;
        Runs runs2 = this.straplineTextOne;
        int iHashCode3 = (iHashCode2 + (runs2 == null ? 0 : runs2.hashCode())) * 31;
        DescriptionWrapper descriptionWrapper = this.description;
        int iHashCode4 = (iHashCode3 + (descriptionWrapper == null ? 0 : descriptionWrapper.hashCode())) * 31;
        FacepileWrapper facepileWrapper = this.facepile;
        return iHashCode4 + (facepileWrapper != null ? facepileWrapper.hashCode() : 0);
    }

    public final String toString() {
        return "MusicResponsiveHeaderRenderer(thumbnail=" + this.thumbnail + ", buttons=" + this.buttons + ", title=" + this.title + ", subtitle=" + this.subtitle + ", secondSubtitle=" + this.secondSubtitle + ", straplineTextOne=" + this.straplineTextOne + ", description=" + this.description + ", facepile=" + this.facepile + ")";
    }
}
