package com.metrolist.innertube.models.response;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.AccountInfo;
import com.metrolist.innertube.models.Run;
import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.Thumbnail;
import com.metrolist.innertube.models.Thumbnails;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/AccountMenuResponse;", "", "Companion", "Action", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class AccountMenuResponse {
    public final List actions;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BrowseResponse$$ExternalSyntheticLambda0((byte) 6))};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/AccountMenuResponse$Action;", "", "Companion", "OpenPopupAction", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Action {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final OpenPopupAction openPopupAction;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/AccountMenuResponse$Action$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/AccountMenuResponse$Action;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return AccountMenuResponse$Action$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/AccountMenuResponse$Action$OpenPopupAction;", "", "Companion", "Popup", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class OpenPopupAction {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final Popup popup;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/AccountMenuResponse$Action$OpenPopupAction$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/AccountMenuResponse$Action$OpenPopupAction;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return AccountMenuResponse$Action$OpenPopupAction$$serializer.INSTANCE;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/AccountMenuResponse$Action$OpenPopupAction$Popup;", "", "Companion", "MultiPageMenuRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class Popup {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion();
                public final MultiPageMenuRenderer multiPageMenuRenderer;

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/AccountMenuResponse$Action$OpenPopupAction$Popup$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/AccountMenuResponse$Action$OpenPopupAction$Popup;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public final KSerializer serializer() {
                        return AccountMenuResponse$Action$OpenPopupAction$Popup$$serializer.INSTANCE;
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer;", "", "Companion", "Header", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                @Serializable
                public static final /* data */ class MultiPageMenuRenderer {

                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                    public static final Companion INSTANCE = new Companion();
                    public final Header header;

                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    public static final class Companion {
                        public final KSerializer serializer() {
                            return AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$$serializer.INSTANCE;
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$Header;", "", "Companion", "ActiveAccountHeaderRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    @Serializable
                    public static final /* data */ class Header {

                        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                        public static final Companion INSTANCE = new Companion();
                        public final ActiveAccountHeaderRenderer activeAccountHeaderRenderer;

                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$Header$ActiveAccountHeaderRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                        @Serializable
                        public static final /* data */ class ActiveAccountHeaderRenderer {

                            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                            public static final Companion INSTANCE = new Companion();
                            public final Runs accountName;
                            public final Thumbnails accountPhoto;
                            public final Runs channelHandle;
                            public final Runs email;

                            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$Header$ActiveAccountHeaderRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$Header$ActiveAccountHeaderRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                            public static final class Companion {
                                public final KSerializer serializer() {
                                    return AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$Header$ActiveAccountHeaderRenderer$$serializer.INSTANCE;
                                }
                            }

                            public /* synthetic */ ActiveAccountHeaderRenderer(int i, Runs runs, Runs runs2, Runs runs3, Thumbnails thumbnails) {
                                if (15 != (i & 15)) {
                                    EnumsKt.throwMissingFieldException(AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$Header$ActiveAccountHeaderRenderer$$serializer.INSTANCE.getDescriptor(), i, 15);
                                    throw null;
                                }
                                this.accountName = runs;
                                this.email = runs2;
                                this.channelHandle = runs3;
                                this.accountPhoto = thumbnails;
                            }

                            public final boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (!(obj instanceof ActiveAccountHeaderRenderer)) {
                                    return false;
                                }
                                ActiveAccountHeaderRenderer activeAccountHeaderRenderer = (ActiveAccountHeaderRenderer) obj;
                                return Intrinsics.areEqual(this.accountName, activeAccountHeaderRenderer.accountName) && Intrinsics.areEqual(this.email, activeAccountHeaderRenderer.email) && Intrinsics.areEqual(this.channelHandle, activeAccountHeaderRenderer.channelHandle) && Intrinsics.areEqual(this.accountPhoto, activeAccountHeaderRenderer.accountPhoto);
                            }

                            public final int hashCode() {
                                int iHashCode = this.accountName.hashCode() * 31;
                                Runs runs = this.email;
                                int iHashCode2 = (iHashCode + (runs == null ? 0 : runs.hashCode())) * 31;
                                Runs runs2 = this.channelHandle;
                                return this.accountPhoto.thumbnails.hashCode() + ((iHashCode2 + (runs2 != null ? runs2.hashCode() : 0)) * 31);
                            }

                            public final AccountInfo toAccountInfo() {
                                List list;
                                Run run;
                                List list2;
                                Run run2;
                                List list3 = this.accountName.runs;
                                list3.getClass();
                                String str = ((Run) CollectionsKt.first(list3)).text;
                                Runs runs = this.email;
                                String str2 = (runs == null || (list2 = runs.runs) == null || (run2 = (Run) CollectionsKt.first(list2)) == null) ? null : run2.text;
                                Runs runs2 = this.channelHandle;
                                String str3 = (runs2 == null || (list = runs2.runs) == null || (run = (Run) CollectionsKt.first(list)) == null) ? null : run.text;
                                Thumbnail thumbnail = (Thumbnail) CollectionsKt.lastOrNull(this.accountPhoto.thumbnails);
                                return new AccountInfo(str, str2, str3, thumbnail != null ? thumbnail.url : null);
                            }

                            public final String toString() {
                                return "ActiveAccountHeaderRenderer(accountName=" + this.accountName + ", email=" + this.email + ", channelHandle=" + this.channelHandle + ", accountPhoto=" + this.accountPhoto + ")";
                            }
                        }

                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$Header$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$Header;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                        public static final class Companion {
                            public final KSerializer serializer() {
                                return AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$Header$$serializer.INSTANCE;
                            }
                        }

                        public /* synthetic */ Header(int i, ActiveAccountHeaderRenderer activeAccountHeaderRenderer) {
                            if (1 == (i & 1)) {
                                this.activeAccountHeaderRenderer = activeAccountHeaderRenderer;
                            } else {
                                EnumsKt.throwMissingFieldException(AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$Header$$serializer.INSTANCE.getDescriptor(), i, 1);
                                throw null;
                            }
                        }

                        public final boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return (obj instanceof Header) && Intrinsics.areEqual(this.activeAccountHeaderRenderer, ((Header) obj).activeAccountHeaderRenderer);
                        }

                        public final int hashCode() {
                            return this.activeAccountHeaderRenderer.hashCode();
                        }

                        public final String toString() {
                            return "Header(activeAccountHeaderRenderer=" + this.activeAccountHeaderRenderer + ")";
                        }
                    }

                    public /* synthetic */ MultiPageMenuRenderer(int i, Header header) {
                        if (1 == (i & 1)) {
                            this.header = header;
                        } else {
                            EnumsKt.throwMissingFieldException(AccountMenuResponse$Action$OpenPopupAction$Popup$MultiPageMenuRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
                            throw null;
                        }
                    }

                    public final boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof MultiPageMenuRenderer) && Intrinsics.areEqual(this.header, ((MultiPageMenuRenderer) obj).header);
                    }

                    public final int hashCode() {
                        Header header = this.header;
                        if (header == null) {
                            return 0;
                        }
                        return header.activeAccountHeaderRenderer.hashCode();
                    }

                    public final String toString() {
                        return "MultiPageMenuRenderer(header=" + this.header + ")";
                    }
                }

                public /* synthetic */ Popup(int i, MultiPageMenuRenderer multiPageMenuRenderer) {
                    if (1 == (i & 1)) {
                        this.multiPageMenuRenderer = multiPageMenuRenderer;
                    } else {
                        EnumsKt.throwMissingFieldException(AccountMenuResponse$Action$OpenPopupAction$Popup$$serializer.INSTANCE.getDescriptor(), i, 1);
                        throw null;
                    }
                }

                public final boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof Popup) && Intrinsics.areEqual(this.multiPageMenuRenderer, ((Popup) obj).multiPageMenuRenderer);
                }

                public final int hashCode() {
                    return this.multiPageMenuRenderer.hashCode();
                }

                public final String toString() {
                    return "Popup(multiPageMenuRenderer=" + this.multiPageMenuRenderer + ")";
                }
            }

            public /* synthetic */ OpenPopupAction(int i, Popup popup) {
                if (1 == (i & 1)) {
                    this.popup = popup;
                } else {
                    EnumsKt.throwMissingFieldException(AccountMenuResponse$Action$OpenPopupAction$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof OpenPopupAction) && Intrinsics.areEqual(this.popup, ((OpenPopupAction) obj).popup);
            }

            public final int hashCode() {
                return this.popup.multiPageMenuRenderer.hashCode();
            }

            public final String toString() {
                return "OpenPopupAction(popup=" + this.popup + ")";
            }
        }

        public /* synthetic */ Action(int i, OpenPopupAction openPopupAction) {
            if (1 == (i & 1)) {
                this.openPopupAction = openPopupAction;
            } else {
                EnumsKt.throwMissingFieldException(AccountMenuResponse$Action$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Action) && Intrinsics.areEqual(this.openPopupAction, ((Action) obj).openPopupAction);
        }

        public final int hashCode() {
            return this.openPopupAction.hashCode();
        }

        public final String toString() {
            return "Action(openPopupAction=" + this.openPopupAction + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/AccountMenuResponse$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/AccountMenuResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return AccountMenuResponse$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AccountMenuResponse(int i, List list) {
        if (1 == (i & 1)) {
            this.actions = list;
        } else {
            EnumsKt.throwMissingFieldException(AccountMenuResponse$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AccountMenuResponse) && Intrinsics.areEqual(this.actions, ((AccountMenuResponse) obj).actions);
    }

    public final int hashCode() {
        return this.actions.hashCode();
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("AccountMenuResponse(actions=", ")", this.actions);
    }
}
