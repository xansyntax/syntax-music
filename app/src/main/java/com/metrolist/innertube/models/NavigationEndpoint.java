package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0004\u0003\u0004\u0005\u0002¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/NavigationEndpoint;", "", "Companion", "DeletePrivatelyOwnedEntityCommand", "ConfirmDialogEndpoint", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class NavigationEndpoint {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final BrowseEndpoint browseEndpoint;
    public final ConfirmDialogEndpoint confirmDialogEndpoint;
    public final DeletePrivatelyOwnedEntityCommand deletePrivatelyOwnedEntityCommand;
    public final FeedbackEndpoint feedbackEndpoint;
    public final QueueAddEndpoint queueAddEndpoint;
    public final SearchEndpoint searchEndpoint;
    public final ShareEntityEndpoint shareEntityEndpoint;
    public final UrlEndpoint urlEndpoint;
    public final WatchEndpoint watchEndpoint;
    public final WatchEndpoint watchPlaylistEndpoint;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/NavigationEndpoint$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/NavigationEndpoint;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return NavigationEndpoint$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\u0002¨\u0006\t"}, d2 = {"Lcom/metrolist/innertube/models/NavigationEndpoint$ConfirmDialogEndpoint;", "", "Companion", "ConfirmDialogContent", "ConfirmDialogRenderer", "ConfirmButton", "ConfirmButtonRenderer", "ConfirmCommand", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ConfirmDialogEndpoint {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final ConfirmDialogContent content;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/NavigationEndpoint$ConfirmDialogEndpoint$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/NavigationEndpoint$ConfirmDialogEndpoint;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return NavigationEndpoint$ConfirmDialogEndpoint$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButton;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class ConfirmButton {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final ConfirmButtonRenderer buttonRenderer;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButton$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButton;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButton$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ ConfirmButton(int i, ConfirmButtonRenderer confirmButtonRenderer) {
                if ((i & 1) == 0) {
                    this.buttonRenderer = null;
                } else {
                    this.buttonRenderer = confirmButtonRenderer;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ConfirmButton) && Intrinsics.areEqual(this.buttonRenderer, ((ConfirmButton) obj).buttonRenderer);
            }

            public final int hashCode() {
                ConfirmButtonRenderer confirmButtonRenderer = this.buttonRenderer;
                if (confirmButtonRenderer == null) {
                    return 0;
                }
                return confirmButtonRenderer.hashCode();
            }

            public final String toString() {
                return "ConfirmButton(buttonRenderer=" + this.buttonRenderer + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButtonRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class ConfirmButtonRenderer {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final ConfirmCommand command;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButtonRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButtonRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButtonRenderer$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ ConfirmButtonRenderer(int i, ConfirmCommand confirmCommand) {
                if ((i & 1) == 0) {
                    this.command = null;
                } else {
                    this.command = confirmCommand;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ConfirmButtonRenderer) && Intrinsics.areEqual(this.command, ((ConfirmButtonRenderer) obj).command);
            }

            public final int hashCode() {
                ConfirmCommand confirmCommand = this.command;
                if (confirmCommand == null) {
                    return 0;
                }
                return confirmCommand.hashCode();
            }

            public final String toString() {
                return "ConfirmButtonRenderer(command=" + this.command + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/NavigationEndpoint$ConfirmDialogEndpoint$ConfirmCommand;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class ConfirmCommand {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final DeletePrivatelyOwnedEntityCommand musicDeletePrivatelyOwnedEntityCommand;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/NavigationEndpoint$ConfirmDialogEndpoint$ConfirmCommand$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/NavigationEndpoint$ConfirmDialogEndpoint$ConfirmCommand;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return NavigationEndpoint$ConfirmDialogEndpoint$ConfirmCommand$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ ConfirmCommand(int i, DeletePrivatelyOwnedEntityCommand deletePrivatelyOwnedEntityCommand) {
                if ((i & 1) == 0) {
                    this.musicDeletePrivatelyOwnedEntityCommand = null;
                } else {
                    this.musicDeletePrivatelyOwnedEntityCommand = deletePrivatelyOwnedEntityCommand;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ConfirmCommand) && Intrinsics.areEqual(this.musicDeletePrivatelyOwnedEntityCommand, ((ConfirmCommand) obj).musicDeletePrivatelyOwnedEntityCommand);
            }

            public final int hashCode() {
                DeletePrivatelyOwnedEntityCommand deletePrivatelyOwnedEntityCommand = this.musicDeletePrivatelyOwnedEntityCommand;
                if (deletePrivatelyOwnedEntityCommand == null) {
                    return 0;
                }
                return deletePrivatelyOwnedEntityCommand.entityId.hashCode();
            }

            public final String toString() {
                return "ConfirmCommand(musicDeletePrivatelyOwnedEntityCommand=" + this.musicDeletePrivatelyOwnedEntityCommand + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/NavigationEndpoint$ConfirmDialogEndpoint$ConfirmDialogContent;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class ConfirmDialogContent {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final ConfirmDialogRenderer confirmDialogRenderer;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/NavigationEndpoint$ConfirmDialogEndpoint$ConfirmDialogContent$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/NavigationEndpoint$ConfirmDialogEndpoint$ConfirmDialogContent;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return NavigationEndpoint$ConfirmDialogEndpoint$ConfirmDialogContent$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ ConfirmDialogContent(int i, ConfirmDialogRenderer confirmDialogRenderer) {
                if ((i & 1) == 0) {
                    this.confirmDialogRenderer = null;
                } else {
                    this.confirmDialogRenderer = confirmDialogRenderer;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ConfirmDialogContent) && Intrinsics.areEqual(this.confirmDialogRenderer, ((ConfirmDialogContent) obj).confirmDialogRenderer);
            }

            public final int hashCode() {
                ConfirmDialogRenderer confirmDialogRenderer = this.confirmDialogRenderer;
                if (confirmDialogRenderer == null) {
                    return 0;
                }
                return confirmDialogRenderer.hashCode();
            }

            public final String toString() {
                return "ConfirmDialogContent(confirmDialogRenderer=" + this.confirmDialogRenderer + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/NavigationEndpoint$ConfirmDialogEndpoint$ConfirmDialogRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class ConfirmDialogRenderer {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final ConfirmButton confirmButton;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/NavigationEndpoint$ConfirmDialogEndpoint$ConfirmDialogRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/NavigationEndpoint$ConfirmDialogEndpoint$ConfirmDialogRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return NavigationEndpoint$ConfirmDialogEndpoint$ConfirmDialogRenderer$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ ConfirmDialogRenderer(int i, ConfirmButton confirmButton) {
                if ((i & 1) == 0) {
                    this.confirmButton = null;
                } else {
                    this.confirmButton = confirmButton;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ConfirmDialogRenderer) && Intrinsics.areEqual(this.confirmButton, ((ConfirmDialogRenderer) obj).confirmButton);
            }

            public final int hashCode() {
                ConfirmButton confirmButton = this.confirmButton;
                if (confirmButton == null) {
                    return 0;
                }
                return confirmButton.hashCode();
            }

            public final String toString() {
                return "ConfirmDialogRenderer(confirmButton=" + this.confirmButton + ")";
            }
        }

        public /* synthetic */ ConfirmDialogEndpoint(int i, ConfirmDialogContent confirmDialogContent) {
            if ((i & 1) == 0) {
                this.content = null;
            } else {
                this.content = confirmDialogContent;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConfirmDialogEndpoint) && Intrinsics.areEqual(this.content, ((ConfirmDialogEndpoint) obj).content);
        }

        public final int hashCode() {
            ConfirmDialogContent confirmDialogContent = this.content;
            if (confirmDialogContent == null) {
                return 0;
            }
            return confirmDialogContent.hashCode();
        }

        public final String toString() {
            return "ConfirmDialogEndpoint(content=" + this.content + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/NavigationEndpoint$DeletePrivatelyOwnedEntityCommand;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class DeletePrivatelyOwnedEntityCommand {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String entityId;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/NavigationEndpoint$DeletePrivatelyOwnedEntityCommand$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/NavigationEndpoint$DeletePrivatelyOwnedEntityCommand;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return NavigationEndpoint$DeletePrivatelyOwnedEntityCommand$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ DeletePrivatelyOwnedEntityCommand(int i, String str) {
            if (1 == (i & 1)) {
                this.entityId = str;
            } else {
                EnumsKt.throwMissingFieldException(NavigationEndpoint$DeletePrivatelyOwnedEntityCommand$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeletePrivatelyOwnedEntityCommand) && Intrinsics.areEqual(this.entityId, ((DeletePrivatelyOwnedEntityCommand) obj).entityId);
        }

        public final int hashCode() {
            return this.entityId.hashCode();
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("DeletePrivatelyOwnedEntityCommand(entityId=", this.entityId, ")");
        }
    }

    public /* synthetic */ NavigationEndpoint(int i, WatchEndpoint watchEndpoint, WatchEndpoint watchEndpoint2, BrowseEndpoint browseEndpoint, SearchEndpoint searchEndpoint, QueueAddEndpoint queueAddEndpoint, ShareEntityEndpoint shareEntityEndpoint, FeedbackEndpoint feedbackEndpoint, UrlEndpoint urlEndpoint, DeletePrivatelyOwnedEntityCommand deletePrivatelyOwnedEntityCommand, ConfirmDialogEndpoint confirmDialogEndpoint) {
        if ((i & 1) == 0) {
            this.watchEndpoint = null;
        } else {
            this.watchEndpoint = watchEndpoint;
        }
        if ((i & 2) == 0) {
            this.watchPlaylistEndpoint = null;
        } else {
            this.watchPlaylistEndpoint = watchEndpoint2;
        }
        if ((i & 4) == 0) {
            this.browseEndpoint = null;
        } else {
            this.browseEndpoint = browseEndpoint;
        }
        if ((i & 8) == 0) {
            this.searchEndpoint = null;
        } else {
            this.searchEndpoint = searchEndpoint;
        }
        if ((i & 16) == 0) {
            this.queueAddEndpoint = null;
        } else {
            this.queueAddEndpoint = queueAddEndpoint;
        }
        if ((i & 32) == 0) {
            this.shareEntityEndpoint = null;
        } else {
            this.shareEntityEndpoint = shareEntityEndpoint;
        }
        if ((i & 64) == 0) {
            this.feedbackEndpoint = null;
        } else {
            this.feedbackEndpoint = feedbackEndpoint;
        }
        if ((i & 128) == 0) {
            this.urlEndpoint = null;
        } else {
            this.urlEndpoint = urlEndpoint;
        }
        if ((i & 256) == 0) {
            this.deletePrivatelyOwnedEntityCommand = null;
        } else {
            this.deletePrivatelyOwnedEntityCommand = deletePrivatelyOwnedEntityCommand;
        }
        if ((i & 512) == 0) {
            this.confirmDialogEndpoint = null;
        } else {
            this.confirmDialogEndpoint = confirmDialogEndpoint;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NavigationEndpoint)) {
            return false;
        }
        NavigationEndpoint navigationEndpoint = (NavigationEndpoint) obj;
        return Intrinsics.areEqual(this.watchEndpoint, navigationEndpoint.watchEndpoint) && Intrinsics.areEqual(this.watchPlaylistEndpoint, navigationEndpoint.watchPlaylistEndpoint) && Intrinsics.areEqual(this.browseEndpoint, navigationEndpoint.browseEndpoint) && Intrinsics.areEqual(this.searchEndpoint, navigationEndpoint.searchEndpoint) && Intrinsics.areEqual(this.queueAddEndpoint, navigationEndpoint.queueAddEndpoint) && Intrinsics.areEqual(this.shareEntityEndpoint, navigationEndpoint.shareEntityEndpoint) && Intrinsics.areEqual(this.feedbackEndpoint, navigationEndpoint.feedbackEndpoint) && Intrinsics.areEqual(this.urlEndpoint, navigationEndpoint.urlEndpoint) && Intrinsics.areEqual(this.deletePrivatelyOwnedEntityCommand, navigationEndpoint.deletePrivatelyOwnedEntityCommand) && Intrinsics.areEqual(this.confirmDialogEndpoint, navigationEndpoint.confirmDialogEndpoint);
    }

    public final String getMusicVideoType() {
        WatchEndpoint.WatchEndpointMusicSupportedConfigs watchEndpointMusicSupportedConfigs;
        WatchEndpoint.WatchEndpointMusicSupportedConfigs.WatchEndpointMusicConfig watchEndpointMusicConfig;
        WatchEndpoint watchEndpoint = this.watchEndpoint;
        if (watchEndpoint == null) {
            watchEndpoint = this.watchPlaylistEndpoint;
        }
        if (watchEndpoint == null || (watchEndpointMusicSupportedConfigs = watchEndpoint.watchEndpointMusicSupportedConfigs) == null || (watchEndpointMusicConfig = watchEndpointMusicSupportedConfigs.watchEndpointMusicConfig) == null) {
            return null;
        }
        return watchEndpointMusicConfig.musicVideoType;
    }

    public final int hashCode() {
        WatchEndpoint watchEndpoint = this.watchEndpoint;
        int iHashCode = (watchEndpoint == null ? 0 : watchEndpoint.hashCode()) * 31;
        WatchEndpoint watchEndpoint2 = this.watchPlaylistEndpoint;
        int iHashCode2 = (iHashCode + (watchEndpoint2 == null ? 0 : watchEndpoint2.hashCode())) * 31;
        BrowseEndpoint browseEndpoint = this.browseEndpoint;
        int iHashCode3 = (iHashCode2 + (browseEndpoint == null ? 0 : browseEndpoint.hashCode())) * 31;
        SearchEndpoint searchEndpoint = this.searchEndpoint;
        int iHashCode4 = (iHashCode3 + (searchEndpoint == null ? 0 : searchEndpoint.hashCode())) * 31;
        QueueAddEndpoint queueAddEndpoint = this.queueAddEndpoint;
        int iHashCode5 = (iHashCode4 + (queueAddEndpoint == null ? 0 : queueAddEndpoint.hashCode())) * 31;
        ShareEntityEndpoint shareEntityEndpoint = this.shareEntityEndpoint;
        int iHashCode6 = (iHashCode5 + (shareEntityEndpoint == null ? 0 : shareEntityEndpoint.serializedShareEntity.hashCode())) * 31;
        FeedbackEndpoint feedbackEndpoint = this.feedbackEndpoint;
        int iHashCode7 = (iHashCode6 + (feedbackEndpoint == null ? 0 : feedbackEndpoint.feedbackToken.hashCode())) * 31;
        UrlEndpoint urlEndpoint = this.urlEndpoint;
        int iHashCode8 = (iHashCode7 + (urlEndpoint == null ? 0 : urlEndpoint.hashCode())) * 31;
        DeletePrivatelyOwnedEntityCommand deletePrivatelyOwnedEntityCommand = this.deletePrivatelyOwnedEntityCommand;
        int iHashCode9 = (iHashCode8 + (deletePrivatelyOwnedEntityCommand == null ? 0 : deletePrivatelyOwnedEntityCommand.entityId.hashCode())) * 31;
        ConfirmDialogEndpoint confirmDialogEndpoint = this.confirmDialogEndpoint;
        return iHashCode9 + (confirmDialogEndpoint != null ? confirmDialogEndpoint.hashCode() : 0);
    }

    public final String toString() {
        return "NavigationEndpoint(watchEndpoint=" + this.watchEndpoint + ", watchPlaylistEndpoint=" + this.watchPlaylistEndpoint + ", browseEndpoint=" + this.browseEndpoint + ", searchEndpoint=" + this.searchEndpoint + ", queueAddEndpoint=" + this.queueAddEndpoint + ", shareEntityEndpoint=" + this.shareEntityEndpoint + ", feedbackEndpoint=" + this.feedbackEndpoint + ", urlEndpoint=" + this.urlEndpoint + ", deletePrivatelyOwnedEntityCommand=" + this.deletePrivatelyOwnedEntityCommand + ", confirmDialogEndpoint=" + this.confirmDialogEndpoint + ")";
    }
}
