package com.metrolist.music.ui.component;

import androidx.compose.material3.CardColors;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Material3MenuItemData {
    public final CardColors cardColors;
    public final Function2 description;
    public final Function2 icon;
    public final Function0 onClick;
    public final Function2 title;
    public final Function2 trailingContent;

    public Material3MenuItemData(Function2 function2, Function2 function3, Function2 function4, Function0 function0, CardColors cardColors, ComposableLambdaImpl composableLambdaImpl, int i) {
        function4 = (i & 4) != 0 ? null : function4;
        cardColors = (i & 16) != 0 ? null : cardColors;
        composableLambdaImpl = (i & 32) != 0 ? null : composableLambdaImpl;
        function3.getClass();
        this.icon = function2;
        this.title = function3;
        this.description = function4;
        this.onClick = function0;
        this.cardColors = cardColors;
        this.trailingContent = composableLambdaImpl;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Material3MenuItemData)) {
            return false;
        }
        Material3MenuItemData material3MenuItemData = (Material3MenuItemData) obj;
        return Intrinsics.areEqual(this.icon, material3MenuItemData.icon) && Intrinsics.areEqual(this.title, material3MenuItemData.title) && Intrinsics.areEqual(this.description, material3MenuItemData.description) && Intrinsics.areEqual(this.onClick, material3MenuItemData.onClick) && Intrinsics.areEqual(this.cardColors, material3MenuItemData.cardColors) && Intrinsics.areEqual(this.trailingContent, material3MenuItemData.trailingContent);
    }

    public final int hashCode() {
        Function2 function2 = this.icon;
        int iHashCode = (this.title.hashCode() + ((function2 == null ? 0 : function2.hashCode()) * 31)) * 31;
        Function2 function3 = this.description;
        int iHashCode2 = (iHashCode + (function3 == null ? 0 : function3.hashCode())) * 31;
        Function0 function0 = this.onClick;
        int iHashCode3 = (iHashCode2 + (function0 == null ? 0 : function0.hashCode())) * 31;
        CardColors cardColors = this.cardColors;
        int iHashCode4 = (iHashCode3 + (cardColors == null ? 0 : cardColors.hashCode())) * 31;
        Function2 function4 = this.trailingContent;
        return iHashCode4 + (function4 != null ? function4.hashCode() : 0);
    }

    public final String toString() {
        return "Material3MenuItemData(icon=" + this.icon + ", title=" + this.title + ", description=" + this.description + ", onClick=" + this.onClick + ", cardColors=" + this.cardColors + ", trailingContent=" + this.trailingContent + ")";
    }
}
