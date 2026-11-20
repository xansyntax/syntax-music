package com.metrolist.music.ui.component;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Material3SettingsItem {
    public final Function2 description;
    public final boolean enabled;
    public final Painter icon;
    public final boolean isHighlighted;
    public final Function0 onClick;
    public final boolean showBadge;
    public final Function2 title;
    public final Function2 trailingContent;

    public Material3SettingsItem(Painter painter, Function2 function2, Function2 function3, Function2 function4, boolean z, boolean z2, Function0 function0, int i) {
        painter = (i & 1) != 0 ? null : painter;
        function3 = (i & 8) != 0 ? null : function3;
        function4 = (i & 16) != 0 ? null : function4;
        z = (i & 32) != 0 ? false : z;
        z2 = (i & 128) != 0 ? true : z2;
        function0 = (i & 256) != 0 ? null : function0;
        function2.getClass();
        this.icon = painter;
        this.title = function2;
        this.description = function3;
        this.trailingContent = function4;
        this.showBadge = z;
        this.isHighlighted = false;
        this.enabled = z2;
        this.onClick = function0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Material3SettingsItem)) {
            return false;
        }
        Material3SettingsItem material3SettingsItem = (Material3SettingsItem) obj;
        return Intrinsics.areEqual(this.icon, material3SettingsItem.icon) && Intrinsics.areEqual(this.title, material3SettingsItem.title) && Intrinsics.areEqual(this.description, material3SettingsItem.description) && Intrinsics.areEqual(this.trailingContent, material3SettingsItem.trailingContent) && this.showBadge == material3SettingsItem.showBadge && this.isHighlighted == material3SettingsItem.isHighlighted && this.enabled == material3SettingsItem.enabled && Intrinsics.areEqual(this.onClick, material3SettingsItem.onClick);
    }

    public final int hashCode() {
        Painter painter = this.icon;
        int iHashCode = (this.title.hashCode() + ((painter == null ? 0 : painter.hashCode()) * 961)) * 31;
        Function2 function2 = this.description;
        int iHashCode2 = (iHashCode + (function2 == null ? 0 : function2.hashCode())) * 31;
        Function2 function3 = this.trailingContent;
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((iHashCode2 + (function3 == null ? 0 : function3.hashCode())) * 31, this.showBadge, 31), this.isHighlighted, 31), this.enabled, 31);
        Function0 function0 = this.onClick;
        return iM + (function0 != null ? function0.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Material3SettingsItem(icon=");
        sb.append(this.icon);
        sb.append(", leadingContent=null, title=");
        sb.append(this.title);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", trailingContent=");
        sb.append(this.trailingContent);
        sb.append(", showBadge=");
        Fragment$5$$ExternalSyntheticOutline0.m(sb, this.showBadge, ", isHighlighted=", this.isHighlighted, ", enabled=");
        sb.append(this.enabled);
        sb.append(", onClick=");
        sb.append(this.onClick);
        sb.append(")");
        return sb.toString();
    }
}
