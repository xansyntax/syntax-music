package com.metrolist.innertube.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/AutomixPreviewVideoRenderer;", "", "Companion", "Content", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class AutomixPreviewVideoRenderer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final Content content;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/AutomixPreviewVideoRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/AutomixPreviewVideoRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return AutomixPreviewVideoRenderer$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/AutomixPreviewVideoRenderer$Content;", "", "Companion", "AutomixPlaylistVideoRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Content {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final AutomixPlaylistVideoRenderer automixPlaylistVideoRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/AutomixPreviewVideoRenderer$Content$AutomixPlaylistVideoRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class AutomixPlaylistVideoRenderer {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final NavigationEndpoint navigationEndpoint;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/AutomixPreviewVideoRenderer$Content$AutomixPlaylistVideoRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/AutomixPreviewVideoRenderer$Content$AutomixPlaylistVideoRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return AutomixPreviewVideoRenderer$Content$AutomixPlaylistVideoRenderer$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ AutomixPlaylistVideoRenderer(int i, NavigationEndpoint navigationEndpoint) {
                if (1 == (i & 1)) {
                    this.navigationEndpoint = navigationEndpoint;
                } else {
                    EnumsKt.throwMissingFieldException(AutomixPreviewVideoRenderer$Content$AutomixPlaylistVideoRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof AutomixPlaylistVideoRenderer) && Intrinsics.areEqual(this.navigationEndpoint, ((AutomixPlaylistVideoRenderer) obj).navigationEndpoint);
            }

            public final int hashCode() {
                return this.navigationEndpoint.hashCode();
            }

            public final String toString() {
                return "AutomixPlaylistVideoRenderer(navigationEndpoint=" + this.navigationEndpoint + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/AutomixPreviewVideoRenderer$Content$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/AutomixPreviewVideoRenderer$Content;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return AutomixPreviewVideoRenderer$Content$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Content(int i, AutomixPlaylistVideoRenderer automixPlaylistVideoRenderer) {
            if (1 == (i & 1)) {
                this.automixPlaylistVideoRenderer = automixPlaylistVideoRenderer;
            } else {
                EnumsKt.throwMissingFieldException(AutomixPreviewVideoRenderer$Content$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Content) && Intrinsics.areEqual(this.automixPlaylistVideoRenderer, ((Content) obj).automixPlaylistVideoRenderer);
        }

        public final int hashCode() {
            return this.automixPlaylistVideoRenderer.navigationEndpoint.hashCode();
        }

        public final String toString() {
            return "Content(automixPlaylistVideoRenderer=" + this.automixPlaylistVideoRenderer + ")";
        }
    }

    public /* synthetic */ AutomixPreviewVideoRenderer(int i, Content content) {
        if (1 == (i & 1)) {
            this.content = content;
        } else {
            EnumsKt.throwMissingFieldException(AutomixPreviewVideoRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AutomixPreviewVideoRenderer) && Intrinsics.areEqual(this.content, ((AutomixPreviewVideoRenderer) obj).content);
    }

    public final int hashCode() {
        return this.content.hashCode();
    }

    public final String toString() {
        return "AutomixPreviewVideoRenderer(content=" + this.content + ")";
    }
}
