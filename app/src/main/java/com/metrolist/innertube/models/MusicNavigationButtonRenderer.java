package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0004\u0003\u0004\u0005\u0002¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicNavigationButtonRenderer;", "", "Companion", "Solid", "IconStyle", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class MusicNavigationButtonRenderer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final Runs buttonText;
    public final NavigationEndpoint clickCommand;
    public final IconStyle iconStyle;
    public final Solid solid;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicNavigationButtonRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicNavigationButtonRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return MusicNavigationButtonRenderer$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicNavigationButtonRenderer$IconStyle;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class IconStyle {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final Icon icon;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicNavigationButtonRenderer$IconStyle$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicNavigationButtonRenderer$IconStyle;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return MusicNavigationButtonRenderer$IconStyle$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ IconStyle(int i, Icon icon) {
            if (1 == (i & 1)) {
                this.icon = icon;
            } else {
                EnumsKt.throwMissingFieldException(MusicNavigationButtonRenderer$IconStyle$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IconStyle) && Intrinsics.areEqual(this.icon, ((IconStyle) obj).icon);
        }

        public final int hashCode() {
            return this.icon.iconType.hashCode();
        }

        public final String toString() {
            return "IconStyle(icon=" + this.icon + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicNavigationButtonRenderer$Solid;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Solid {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final long leftStripeColor;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicNavigationButtonRenderer$Solid$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicNavigationButtonRenderer$Solid;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return MusicNavigationButtonRenderer$Solid$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Solid(int i, long j) {
            if (1 == (i & 1)) {
                this.leftStripeColor = j;
            } else {
                EnumsKt.throwMissingFieldException(MusicNavigationButtonRenderer$Solid$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Solid) && this.leftStripeColor == ((Solid) obj).leftStripeColor;
        }

        public final int hashCode() {
            return Long.hashCode(this.leftStripeColor);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m(this.leftStripeColor, "Solid(leftStripeColor=", ")");
        }
    }

    public /* synthetic */ MusicNavigationButtonRenderer(int i, Runs runs, Solid solid, IconStyle iconStyle, NavigationEndpoint navigationEndpoint) {
        if (15 != (i & 15)) {
            EnumsKt.throwMissingFieldException(MusicNavigationButtonRenderer$$serializer.INSTANCE.getDescriptor(), i, 15);
            throw null;
        }
        this.buttonText = runs;
        this.solid = solid;
        this.iconStyle = iconStyle;
        this.clickCommand = navigationEndpoint;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicNavigationButtonRenderer)) {
            return false;
        }
        MusicNavigationButtonRenderer musicNavigationButtonRenderer = (MusicNavigationButtonRenderer) obj;
        return Intrinsics.areEqual(this.buttonText, musicNavigationButtonRenderer.buttonText) && Intrinsics.areEqual(this.solid, musicNavigationButtonRenderer.solid) && Intrinsics.areEqual(this.iconStyle, musicNavigationButtonRenderer.iconStyle) && Intrinsics.areEqual(this.clickCommand, musicNavigationButtonRenderer.clickCommand);
    }

    public final int hashCode() {
        int iHashCode = this.buttonText.hashCode() * 31;
        Solid solid = this.solid;
        int iHashCode2 = (iHashCode + (solid == null ? 0 : Long.hashCode(solid.leftStripeColor))) * 31;
        IconStyle iconStyle = this.iconStyle;
        return this.clickCommand.hashCode() + ((iHashCode2 + (iconStyle != null ? iconStyle.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "MusicNavigationButtonRenderer(buttonText=" + this.buttonText + ", solid=" + this.solid + ", iconStyle=" + this.iconStyle + ", clickCommand=" + this.clickCommand + ")";
    }
}
