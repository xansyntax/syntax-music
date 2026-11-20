package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.disk.UtilsKt$$ExternalSyntheticLambda0;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\f\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u0002¨\u0006\u000e"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel;", "", "Companion", "Avatar", "AvatarViewModel", "AvatarImage", "ImageSource", "AvatarText", "RendererContext", "CommandContext", "OnTap", "InnerTubeBrowseCommand", "BrowseEndpoint", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class AvatarStackViewModel {
    public final List avatars;
    public final RendererContext rendererContext;
    public final AvatarText text;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new UtilsKt$$ExternalSyntheticLambda0((byte) 26)), null, null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$Avatar;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Avatar {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final AvatarViewModel avatarViewModel;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$Avatar$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/AvatarStackViewModel$Avatar;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return AvatarStackViewModel$Avatar$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Avatar(int i, AvatarViewModel avatarViewModel) {
            if (1 == (i & 1)) {
                this.avatarViewModel = avatarViewModel;
            } else {
                EnumsKt.throwMissingFieldException(AvatarStackViewModel$Avatar$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Avatar) && Intrinsics.areEqual(this.avatarViewModel, ((Avatar) obj).avatarViewModel);
        }

        public final int hashCode() {
            AvatarViewModel avatarViewModel = this.avatarViewModel;
            if (avatarViewModel == null) {
                return 0;
            }
            return avatarViewModel.hashCode();
        }

        public final String toString() {
            return "Avatar(avatarViewModel=" + this.avatarViewModel + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$AvatarImage;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class AvatarImage {
        public final List sources;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new UtilsKt$$ExternalSyntheticLambda0((byte) 27))};

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$AvatarImage$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/AvatarStackViewModel$AvatarImage;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return AvatarStackViewModel$AvatarImage$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ AvatarImage(int i, List list) {
            if (1 == (i & 1)) {
                this.sources = list;
            } else {
                EnumsKt.throwMissingFieldException(AvatarStackViewModel$AvatarImage$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AvatarImage) && Intrinsics.areEqual(this.sources, ((AvatarImage) obj).sources);
        }

        public final int hashCode() {
            List list = this.sources;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("AvatarImage(sources=", ")", this.sources);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$AvatarText;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class AvatarText {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String content;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$AvatarText$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/AvatarStackViewModel$AvatarText;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return AvatarStackViewModel$AvatarText$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ AvatarText(int i, String str) {
            if (1 == (i & 1)) {
                this.content = str;
            } else {
                EnumsKt.throwMissingFieldException(AvatarStackViewModel$AvatarText$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AvatarText) && Intrinsics.areEqual(this.content, ((AvatarText) obj).content);
        }

        public final int hashCode() {
            String str = this.content;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("AvatarText(content=", this.content, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$AvatarViewModel;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class AvatarViewModel {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final AvatarImage image;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$AvatarViewModel$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/AvatarStackViewModel$AvatarViewModel;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return AvatarStackViewModel$AvatarViewModel$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ AvatarViewModel(int i, AvatarImage avatarImage) {
            if (1 == (i & 1)) {
                this.image = avatarImage;
            } else {
                EnumsKt.throwMissingFieldException(AvatarStackViewModel$AvatarViewModel$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AvatarViewModel) && Intrinsics.areEqual(this.image, ((AvatarViewModel) obj).image);
        }

        public final int hashCode() {
            AvatarImage avatarImage = this.image;
            if (avatarImage == null) {
                return 0;
            }
            return avatarImage.hashCode();
        }

        public final String toString() {
            return "AvatarViewModel(image=" + this.image + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$BrowseEndpoint;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class BrowseEndpoint {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String browseId;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$BrowseEndpoint$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/AvatarStackViewModel$BrowseEndpoint;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return AvatarStackViewModel$BrowseEndpoint$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ BrowseEndpoint(int i, String str) {
            if (1 == (i & 1)) {
                this.browseId = str;
            } else {
                EnumsKt.throwMissingFieldException(AvatarStackViewModel$BrowseEndpoint$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BrowseEndpoint) && Intrinsics.areEqual(this.browseId, ((BrowseEndpoint) obj).browseId);
        }

        public final int hashCode() {
            String str = this.browseId;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("BrowseEndpoint(browseId=", this.browseId, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$CommandContext;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class CommandContext {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final OnTap onTap;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$CommandContext$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/AvatarStackViewModel$CommandContext;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return AvatarStackViewModel$CommandContext$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ CommandContext(int i, OnTap onTap) {
            if (1 == (i & 1)) {
                this.onTap = onTap;
            } else {
                EnumsKt.throwMissingFieldException(AvatarStackViewModel$CommandContext$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CommandContext) && Intrinsics.areEqual(this.onTap, ((CommandContext) obj).onTap);
        }

        public final int hashCode() {
            OnTap onTap = this.onTap;
            if (onTap == null) {
                return 0;
            }
            return onTap.hashCode();
        }

        public final String toString() {
            return "CommandContext(onTap=" + this.onTap + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/AvatarStackViewModel;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return AvatarStackViewModel$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$ImageSource;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ImageSource {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String url;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$ImageSource$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/AvatarStackViewModel$ImageSource;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return AvatarStackViewModel$ImageSource$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ImageSource(int i, String str) {
            if (1 == (i & 1)) {
                this.url = str;
            } else {
                EnumsKt.throwMissingFieldException(AvatarStackViewModel$ImageSource$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ImageSource) && Intrinsics.areEqual(this.url, ((ImageSource) obj).url);
        }

        public final int hashCode() {
            String str = this.url;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("ImageSource(url=", this.url, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$InnerTubeBrowseCommand;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class InnerTubeBrowseCommand {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final BrowseEndpoint browseEndpoint;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$InnerTubeBrowseCommand$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/AvatarStackViewModel$InnerTubeBrowseCommand;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return AvatarStackViewModel$InnerTubeBrowseCommand$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ InnerTubeBrowseCommand(int i, BrowseEndpoint browseEndpoint) {
            if (1 == (i & 1)) {
                this.browseEndpoint = browseEndpoint;
            } else {
                EnumsKt.throwMissingFieldException(AvatarStackViewModel$InnerTubeBrowseCommand$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InnerTubeBrowseCommand) && Intrinsics.areEqual(this.browseEndpoint, ((InnerTubeBrowseCommand) obj).browseEndpoint);
        }

        public final int hashCode() {
            BrowseEndpoint browseEndpoint = this.browseEndpoint;
            if (browseEndpoint == null) {
                return 0;
            }
            return browseEndpoint.hashCode();
        }

        public final String toString() {
            return "InnerTubeBrowseCommand(browseEndpoint=" + this.browseEndpoint + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$OnTap;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class OnTap {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final InnerTubeBrowseCommand innertubeCommand;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$OnTap$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/AvatarStackViewModel$OnTap;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return AvatarStackViewModel$OnTap$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ OnTap(int i, InnerTubeBrowseCommand innerTubeBrowseCommand) {
            if (1 == (i & 1)) {
                this.innertubeCommand = innerTubeBrowseCommand;
            } else {
                EnumsKt.throwMissingFieldException(AvatarStackViewModel$OnTap$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnTap) && Intrinsics.areEqual(this.innertubeCommand, ((OnTap) obj).innertubeCommand);
        }

        public final int hashCode() {
            InnerTubeBrowseCommand innerTubeBrowseCommand = this.innertubeCommand;
            if (innerTubeBrowseCommand == null) {
                return 0;
            }
            return innerTubeBrowseCommand.hashCode();
        }

        public final String toString() {
            return "OnTap(innertubeCommand=" + this.innertubeCommand + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$RendererContext;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class RendererContext {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final CommandContext commandContext;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/AvatarStackViewModel$RendererContext$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/AvatarStackViewModel$RendererContext;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return AvatarStackViewModel$RendererContext$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ RendererContext(int i, CommandContext commandContext) {
            if (1 == (i & 1)) {
                this.commandContext = commandContext;
            } else {
                EnumsKt.throwMissingFieldException(AvatarStackViewModel$RendererContext$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RendererContext) && Intrinsics.areEqual(this.commandContext, ((RendererContext) obj).commandContext);
        }

        public final int hashCode() {
            CommandContext commandContext = this.commandContext;
            if (commandContext == null) {
                return 0;
            }
            return commandContext.hashCode();
        }

        public final String toString() {
            return "RendererContext(commandContext=" + this.commandContext + ")";
        }
    }

    public /* synthetic */ AvatarStackViewModel(int i, List list, AvatarText avatarText, RendererContext rendererContext) {
        if (7 != (i & 7)) {
            EnumsKt.throwMissingFieldException(AvatarStackViewModel$$serializer.INSTANCE.getDescriptor(), i, 7);
            throw null;
        }
        this.avatars = list;
        this.text = avatarText;
        this.rendererContext = rendererContext;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AvatarStackViewModel)) {
            return false;
        }
        AvatarStackViewModel avatarStackViewModel = (AvatarStackViewModel) obj;
        return Intrinsics.areEqual(this.avatars, avatarStackViewModel.avatars) && Intrinsics.areEqual(this.text, avatarStackViewModel.text) && Intrinsics.areEqual(this.rendererContext, avatarStackViewModel.rendererContext);
    }

    public final int hashCode() {
        List list = this.avatars;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        AvatarText avatarText = this.text;
        int iHashCode2 = (iHashCode + (avatarText == null ? 0 : avatarText.hashCode())) * 31;
        RendererContext rendererContext = this.rendererContext;
        return iHashCode2 + (rendererContext != null ? rendererContext.hashCode() : 0);
    }

    public final String toString() {
        return "AvatarStackViewModel(avatars=" + this.avatars + ", text=" + this.text + ", rendererContext=" + this.rendererContext + ")";
    }
}
