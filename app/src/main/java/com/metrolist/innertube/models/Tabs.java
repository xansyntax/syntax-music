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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/Tabs;", "", "Companion", "Tab", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class Tabs {
    public final List tabs;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Runs$$ExternalSyntheticLambda0(28))};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Tabs$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Tabs;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return Tabs$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/Tabs$Tab;", "", "Companion", "TabRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Tab {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final TabRenderer tabRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Tabs$Tab$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Tabs$Tab;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return Tabs$Tab$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/Tabs$Tab$TabRenderer;", "", "Companion", "Content", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class TabRenderer {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final Content content;
            public final NavigationEndpoint endpoint;
            public final String title;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Tabs$Tab$TabRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Tabs$Tab$TabRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return Tabs$Tab$TabRenderer$$serializer.INSTANCE;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/Tabs$Tab$TabRenderer$Content;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class Content {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion();
                public final MusicQueueRenderer musicQueueRenderer;
                public final SectionListRenderer sectionListRenderer;

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Tabs$Tab$TabRenderer$Content$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Tabs$Tab$TabRenderer$Content;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public final KSerializer serializer() {
                        return Tabs$Tab$TabRenderer$Content$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ Content(int i, SectionListRenderer sectionListRenderer, MusicQueueRenderer musicQueueRenderer) {
                    if (3 != (i & 3)) {
                        EnumsKt.throwMissingFieldException(Tabs$Tab$TabRenderer$Content$$serializer.INSTANCE.getDescriptor(), i, 3);
                        throw null;
                    }
                    this.sectionListRenderer = sectionListRenderer;
                    this.musicQueueRenderer = musicQueueRenderer;
                }

                public final boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Content)) {
                        return false;
                    }
                    Content content = (Content) obj;
                    return Intrinsics.areEqual(this.sectionListRenderer, content.sectionListRenderer) && Intrinsics.areEqual(this.musicQueueRenderer, content.musicQueueRenderer);
                }

                public final int hashCode() {
                    SectionListRenderer sectionListRenderer = this.sectionListRenderer;
                    int iHashCode = (sectionListRenderer == null ? 0 : sectionListRenderer.hashCode()) * 31;
                    MusicQueueRenderer musicQueueRenderer = this.musicQueueRenderer;
                    return iHashCode + (musicQueueRenderer != null ? musicQueueRenderer.hashCode() : 0);
                }

                public final String toString() {
                    return "Content(sectionListRenderer=" + this.sectionListRenderer + ", musicQueueRenderer=" + this.musicQueueRenderer + ")";
                }
            }

            public /* synthetic */ TabRenderer(int i, String str, Content content, NavigationEndpoint navigationEndpoint) {
                if (7 != (i & 7)) {
                    EnumsKt.throwMissingFieldException(Tabs$Tab$TabRenderer$$serializer.INSTANCE.getDescriptor(), i, 7);
                    throw null;
                }
                this.title = str;
                this.content = content;
                this.endpoint = navigationEndpoint;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof TabRenderer)) {
                    return false;
                }
                TabRenderer tabRenderer = (TabRenderer) obj;
                return Intrinsics.areEqual(this.title, tabRenderer.title) && Intrinsics.areEqual(this.content, tabRenderer.content) && Intrinsics.areEqual(this.endpoint, tabRenderer.endpoint);
            }

            public final int hashCode() {
                String str = this.title;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                Content content = this.content;
                int iHashCode2 = (iHashCode + (content == null ? 0 : content.hashCode())) * 31;
                NavigationEndpoint navigationEndpoint = this.endpoint;
                return iHashCode2 + (navigationEndpoint != null ? navigationEndpoint.hashCode() : 0);
            }

            public final String toString() {
                return "TabRenderer(title=" + this.title + ", content=" + this.content + ", endpoint=" + this.endpoint + ")";
            }
        }

        public /* synthetic */ Tab(int i, TabRenderer tabRenderer) {
            if (1 == (i & 1)) {
                this.tabRenderer = tabRenderer;
            } else {
                EnumsKt.throwMissingFieldException(Tabs$Tab$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Tab) && Intrinsics.areEqual(this.tabRenderer, ((Tab) obj).tabRenderer);
        }

        public final int hashCode() {
            return this.tabRenderer.hashCode();
        }

        public final String toString() {
            return "Tab(tabRenderer=" + this.tabRenderer + ")";
        }
    }

    public /* synthetic */ Tabs(int i, List list) {
        if (1 == (i & 1)) {
            this.tabs = list;
        } else {
            EnumsKt.throwMissingFieldException(Tabs$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Tabs) && Intrinsics.areEqual(this.tabs, ((Tabs) obj).tabs);
    }

    public final int hashCode() {
        return this.tabs.hashCode();
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("Tabs(tabs=", ")", this.tabs);
    }
}
