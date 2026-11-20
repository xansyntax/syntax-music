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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/Menu;", "", "Companion", "MenuRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class Menu {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final MenuRenderer menuRenderer;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Menu$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Menu;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return Menu$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0004\u0003\u0004\u0005\u0002¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Menu$MenuRenderer;", "", "Companion", "Item", "TopLevelButton", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class MenuRenderer {
        public static final Lazy[] $childSerializers;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final List items;
        public final List topLevelButtons;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Menu$MenuRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Menu$MenuRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return Menu$MenuRenderer$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0002¨\u0006\u0007"}, d2 = {"Lcom/metrolist/innertube/models/Menu$MenuRenderer$Item;", "", "Companion", "MenuNavigationItemRenderer", "MenuServiceItemRenderer", "ToggleMenuServiceRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Item {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final MenuNavigationItemRenderer menuNavigationItemRenderer;
            public final MenuServiceItemRenderer menuServiceItemRenderer;
            public final ToggleMenuServiceRenderer toggleMenuServiceItemRenderer;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Menu$MenuRenderer$Item$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Menu$MenuRenderer$Item;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return Menu$MenuRenderer$Item$$serializer.INSTANCE;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/Menu$MenuRenderer$Item$MenuNavigationItemRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class MenuNavigationItemRenderer {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion();
                public final Icon icon;
                public final NavigationEndpoint navigationEndpoint;
                public final Runs text;

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Menu$MenuRenderer$Item$MenuNavigationItemRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Menu$MenuRenderer$Item$MenuNavigationItemRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public final KSerializer serializer() {
                        return Menu$MenuRenderer$Item$MenuNavigationItemRenderer$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ MenuNavigationItemRenderer(int i, Runs runs, Icon icon, NavigationEndpoint navigationEndpoint) {
                    if (7 != (i & 7)) {
                        EnumsKt.throwMissingFieldException(Menu$MenuRenderer$Item$MenuNavigationItemRenderer$$serializer.INSTANCE.getDescriptor(), i, 7);
                        throw null;
                    }
                    this.text = runs;
                    this.icon = icon;
                    this.navigationEndpoint = navigationEndpoint;
                }

                public final boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof MenuNavigationItemRenderer)) {
                        return false;
                    }
                    MenuNavigationItemRenderer menuNavigationItemRenderer = (MenuNavigationItemRenderer) obj;
                    return Intrinsics.areEqual(this.text, menuNavigationItemRenderer.text) && Intrinsics.areEqual(this.icon, menuNavigationItemRenderer.icon) && Intrinsics.areEqual(this.navigationEndpoint, menuNavigationItemRenderer.navigationEndpoint);
                }

                public final int hashCode() {
                    return this.navigationEndpoint.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.text.hashCode() * 31, 31, this.icon.iconType);
                }

                public final String toString() {
                    return "MenuNavigationItemRenderer(text=" + this.text + ", icon=" + this.icon + ", navigationEndpoint=" + this.navigationEndpoint + ")";
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/Menu$MenuRenderer$Item$MenuServiceItemRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class MenuServiceItemRenderer {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion();
                public final Icon icon;
                public final NavigationEndpoint serviceEndpoint;
                public final Runs text;

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Menu$MenuRenderer$Item$MenuServiceItemRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Menu$MenuRenderer$Item$MenuServiceItemRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public final KSerializer serializer() {
                        return Menu$MenuRenderer$Item$MenuServiceItemRenderer$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ MenuServiceItemRenderer(int i, Runs runs, Icon icon, NavigationEndpoint navigationEndpoint) {
                    if (7 != (i & 7)) {
                        EnumsKt.throwMissingFieldException(Menu$MenuRenderer$Item$MenuServiceItemRenderer$$serializer.INSTANCE.getDescriptor(), i, 7);
                        throw null;
                    }
                    this.text = runs;
                    this.icon = icon;
                    this.serviceEndpoint = navigationEndpoint;
                }

                public final boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof MenuServiceItemRenderer)) {
                        return false;
                    }
                    MenuServiceItemRenderer menuServiceItemRenderer = (MenuServiceItemRenderer) obj;
                    return Intrinsics.areEqual(this.text, menuServiceItemRenderer.text) && Intrinsics.areEqual(this.icon, menuServiceItemRenderer.icon) && Intrinsics.areEqual(this.serviceEndpoint, menuServiceItemRenderer.serviceEndpoint);
                }

                public final int hashCode() {
                    return this.serviceEndpoint.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.text.hashCode() * 31, 31, this.icon.iconType);
                }

                public final String toString() {
                    return "MenuServiceItemRenderer(text=" + this.text + ", icon=" + this.icon + ", serviceEndpoint=" + this.serviceEndpoint + ")";
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/Menu$MenuRenderer$Item$ToggleMenuServiceRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class ToggleMenuServiceRenderer {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion();
                public final Icon defaultIcon;
                public final DefaultServiceEndpoint defaultServiceEndpoint;
                public final boolean isSelected;
                public final ToggledServiceEndpoint toggledServiceEndpoint;

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Menu$MenuRenderer$Item$ToggleMenuServiceRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Menu$MenuRenderer$Item$ToggleMenuServiceRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public final KSerializer serializer() {
                        return Menu$MenuRenderer$Item$ToggleMenuServiceRenderer$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ ToggleMenuServiceRenderer(int i, Icon icon, DefaultServiceEndpoint defaultServiceEndpoint, ToggledServiceEndpoint toggledServiceEndpoint, boolean z) {
                    if (7 != (i & 7)) {
                        EnumsKt.throwMissingFieldException(Menu$MenuRenderer$Item$ToggleMenuServiceRenderer$$serializer.INSTANCE.getDescriptor(), i, 7);
                        throw null;
                    }
                    this.defaultIcon = icon;
                    this.defaultServiceEndpoint = defaultServiceEndpoint;
                    this.toggledServiceEndpoint = toggledServiceEndpoint;
                    if ((i & 8) == 0) {
                        this.isSelected = false;
                    } else {
                        this.isSelected = z;
                    }
                }

                public final boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof ToggleMenuServiceRenderer)) {
                        return false;
                    }
                    ToggleMenuServiceRenderer toggleMenuServiceRenderer = (ToggleMenuServiceRenderer) obj;
                    return Intrinsics.areEqual(this.defaultIcon, toggleMenuServiceRenderer.defaultIcon) && Intrinsics.areEqual(this.defaultServiceEndpoint, toggleMenuServiceRenderer.defaultServiceEndpoint) && Intrinsics.areEqual(this.toggledServiceEndpoint, toggleMenuServiceRenderer.toggledServiceEndpoint) && this.isSelected == toggleMenuServiceRenderer.isSelected;
                }

                public final int hashCode() {
                    int iHashCode = (this.defaultServiceEndpoint.hashCode() + (this.defaultIcon.iconType.hashCode() * 31)) * 31;
                    ToggledServiceEndpoint toggledServiceEndpoint = this.toggledServiceEndpoint;
                    return Boolean.hashCode(this.isSelected) + ((iHashCode + (toggledServiceEndpoint == null ? 0 : toggledServiceEndpoint.hashCode())) * 31);
                }

                public final String toString() {
                    return "ToggleMenuServiceRenderer(defaultIcon=" + this.defaultIcon + ", defaultServiceEndpoint=" + this.defaultServiceEndpoint + ", toggledServiceEndpoint=" + this.toggledServiceEndpoint + ", isSelected=" + this.isSelected + ")";
                }
            }

            public /* synthetic */ Item(int i, MenuNavigationItemRenderer menuNavigationItemRenderer, MenuServiceItemRenderer menuServiceItemRenderer, ToggleMenuServiceRenderer toggleMenuServiceRenderer) {
                if (7 != (i & 7)) {
                    EnumsKt.throwMissingFieldException(Menu$MenuRenderer$Item$$serializer.INSTANCE.getDescriptor(), i, 7);
                    throw null;
                }
                this.menuNavigationItemRenderer = menuNavigationItemRenderer;
                this.menuServiceItemRenderer = menuServiceItemRenderer;
                this.toggleMenuServiceItemRenderer = toggleMenuServiceRenderer;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Item)) {
                    return false;
                }
                Item item = (Item) obj;
                return Intrinsics.areEqual(this.menuNavigationItemRenderer, item.menuNavigationItemRenderer) && Intrinsics.areEqual(this.menuServiceItemRenderer, item.menuServiceItemRenderer) && Intrinsics.areEqual(this.toggleMenuServiceItemRenderer, item.toggleMenuServiceItemRenderer);
            }

            public final int hashCode() {
                MenuNavigationItemRenderer menuNavigationItemRenderer = this.menuNavigationItemRenderer;
                int iHashCode = (menuNavigationItemRenderer == null ? 0 : menuNavigationItemRenderer.hashCode()) * 31;
                MenuServiceItemRenderer menuServiceItemRenderer = this.menuServiceItemRenderer;
                int iHashCode2 = (iHashCode + (menuServiceItemRenderer == null ? 0 : menuServiceItemRenderer.hashCode())) * 31;
                ToggleMenuServiceRenderer toggleMenuServiceRenderer = this.toggleMenuServiceItemRenderer;
                return iHashCode2 + (toggleMenuServiceRenderer != null ? toggleMenuServiceRenderer.hashCode() : 0);
            }

            public final String toString() {
                return "Item(menuNavigationItemRenderer=" + this.menuNavigationItemRenderer + ", menuServiceItemRenderer=" + this.menuServiceItemRenderer + ", toggleMenuServiceItemRenderer=" + this.toggleMenuServiceItemRenderer + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/Menu$MenuRenderer$TopLevelButton;", "", "Companion", "ButtonRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class TopLevelButton {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final ButtonRenderer buttonRenderer;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/Menu$MenuRenderer$TopLevelButton$ButtonRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class ButtonRenderer {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion();
                public final Icon icon;
                public final NavigationEndpoint navigationEndpoint;

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Menu$MenuRenderer$TopLevelButton$ButtonRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Menu$MenuRenderer$TopLevelButton$ButtonRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public final KSerializer serializer() {
                        return Menu$MenuRenderer$TopLevelButton$ButtonRenderer$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ ButtonRenderer(int i, Icon icon, NavigationEndpoint navigationEndpoint) {
                    if (3 != (i & 3)) {
                        EnumsKt.throwMissingFieldException(Menu$MenuRenderer$TopLevelButton$ButtonRenderer$$serializer.INSTANCE.getDescriptor(), i, 3);
                        throw null;
                    }
                    this.icon = icon;
                    this.navigationEndpoint = navigationEndpoint;
                }

                public final boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof ButtonRenderer)) {
                        return false;
                    }
                    ButtonRenderer buttonRenderer = (ButtonRenderer) obj;
                    return Intrinsics.areEqual(this.icon, buttonRenderer.icon) && Intrinsics.areEqual(this.navigationEndpoint, buttonRenderer.navigationEndpoint);
                }

                public final int hashCode() {
                    return this.navigationEndpoint.hashCode() + (this.icon.iconType.hashCode() * 31);
                }

                public final String toString() {
                    return "ButtonRenderer(icon=" + this.icon + ", navigationEndpoint=" + this.navigationEndpoint + ")";
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Menu$MenuRenderer$TopLevelButton$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Menu$MenuRenderer$TopLevelButton;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return Menu$MenuRenderer$TopLevelButton$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ TopLevelButton(int i, ButtonRenderer buttonRenderer) {
                if (1 == (i & 1)) {
                    this.buttonRenderer = buttonRenderer;
                } else {
                    EnumsKt.throwMissingFieldException(Menu$MenuRenderer$TopLevelButton$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof TopLevelButton) && Intrinsics.areEqual(this.buttonRenderer, ((TopLevelButton) obj).buttonRenderer);
            }

            public final int hashCode() {
                ButtonRenderer buttonRenderer = this.buttonRenderer;
                if (buttonRenderer == null) {
                    return 0;
                }
                return buttonRenderer.hashCode();
            }

            public final String toString() {
                return "TopLevelButton(buttonRenderer=" + this.buttonRenderer + ")";
            }
        }

        static {
            Runs$$ExternalSyntheticLambda0 runs$$ExternalSyntheticLambda0 = new Runs$$ExternalSyntheticLambda0((byte) 4);
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
            $childSerializers = new Lazy[]{ResultKt.lazy(lazyThreadSafetyMode, runs$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new Runs$$ExternalSyntheticLambda0((byte) 5))};
        }

        public /* synthetic */ MenuRenderer(int i, List list, List list2) {
            if (3 != (i & 3)) {
                EnumsKt.throwMissingFieldException(Menu$MenuRenderer$$serializer.INSTANCE.getDescriptor(), i, 3);
                throw null;
            }
            this.items = list;
            this.topLevelButtons = list2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MenuRenderer)) {
                return false;
            }
            MenuRenderer menuRenderer = (MenuRenderer) obj;
            return Intrinsics.areEqual(this.items, menuRenderer.items) && Intrinsics.areEqual(this.topLevelButtons, menuRenderer.topLevelButtons);
        }

        public final int hashCode() {
            List list = this.items;
            int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
            List list2 = this.topLevelButtons;
            return iHashCode + (list2 != null ? list2.hashCode() : 0);
        }

        public final String toString() {
            return "MenuRenderer(items=" + this.items + ", topLevelButtons=" + this.topLevelButtons + ")";
        }
    }

    public /* synthetic */ Menu(int i, MenuRenderer menuRenderer) {
        if (1 == (i & 1)) {
            this.menuRenderer = menuRenderer;
        } else {
            EnumsKt.throwMissingFieldException(Menu$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Menu) && Intrinsics.areEqual(this.menuRenderer, ((Menu) obj).menuRenderer);
    }

    public final int hashCode() {
        return this.menuRenderer.hashCode();
    }

    public final String toString() {
        return "Menu(menuRenderer=" + this.menuRenderer + ")";
    }
}
