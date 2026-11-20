package com.metrolist.innertube.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/Button;", "", "Companion", "ButtonRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class Button {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final ButtonRenderer buttonRenderer;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/Button$ButtonRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ButtonRenderer {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final NavigationEndpoint command;
        public final Icon icon;
        public final NavigationEndpoint navigationEndpoint;
        public final Runs text;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Button$ButtonRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Button$ButtonRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return Button$ButtonRenderer$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ButtonRenderer(int i, Runs runs, NavigationEndpoint navigationEndpoint, NavigationEndpoint navigationEndpoint2, Icon icon) {
            if (15 != (i & 15)) {
                EnumsKt.throwMissingFieldException(Button$ButtonRenderer$$serializer.INSTANCE.getDescriptor(), i, 15);
                throw null;
            }
            this.text = runs;
            this.navigationEndpoint = navigationEndpoint;
            this.command = navigationEndpoint2;
            this.icon = icon;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ButtonRenderer)) {
                return false;
            }
            ButtonRenderer buttonRenderer = (ButtonRenderer) obj;
            return Intrinsics.areEqual(this.text, buttonRenderer.text) && Intrinsics.areEqual(this.navigationEndpoint, buttonRenderer.navigationEndpoint) && Intrinsics.areEqual(this.command, buttonRenderer.command) && Intrinsics.areEqual(this.icon, buttonRenderer.icon);
        }

        public final int hashCode() {
            int iHashCode = this.text.hashCode() * 31;
            NavigationEndpoint navigationEndpoint = this.navigationEndpoint;
            int iHashCode2 = (iHashCode + (navigationEndpoint == null ? 0 : navigationEndpoint.hashCode())) * 31;
            NavigationEndpoint navigationEndpoint2 = this.command;
            int iHashCode3 = (iHashCode2 + (navigationEndpoint2 == null ? 0 : navigationEndpoint2.hashCode())) * 31;
            Icon icon = this.icon;
            return iHashCode3 + (icon != null ? icon.iconType.hashCode() : 0);
        }

        public final String toString() {
            return "ButtonRenderer(text=" + this.text + ", navigationEndpoint=" + this.navigationEndpoint + ", command=" + this.command + ", icon=" + this.icon + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Button$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Button;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return Button$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Button(int i, ButtonRenderer buttonRenderer) {
        if (1 == (i & 1)) {
            this.buttonRenderer = buttonRenderer;
        } else {
            EnumsKt.throwMissingFieldException(Button$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Button) && Intrinsics.areEqual(this.buttonRenderer, ((Button) obj).buttonRenderer);
    }

    public final int hashCode() {
        return this.buttonRenderer.hashCode();
    }

    public final String toString() {
        return "Button(buttonRenderer=" + this.buttonRenderer + ")";
    }
}
