package com.metrolist.music.ui.component;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IntegrationCardItem {
    public final Function2 description;
    public final Painter icon;
    public final Function0 onClick;
    public final ComposableLambdaImpl title;
    public final Function2 trailingContent;

    public IntegrationCardItem(Painter painter, ComposableLambdaImpl composableLambdaImpl, ComposableLambdaImpl composableLambdaImpl2, ComposableLambdaImpl composableLambdaImpl3, Function0 function0, int i) {
        composableLambdaImpl2 = (i & 4) != 0 ? null : composableLambdaImpl2;
        composableLambdaImpl3 = (i & 8) != 0 ? null : composableLambdaImpl3;
        this.icon = painter;
        this.title = composableLambdaImpl;
        this.description = composableLambdaImpl2;
        this.trailingContent = composableLambdaImpl3;
        this.onClick = function0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IntegrationCardItem) {
            IntegrationCardItem integrationCardItem = (IntegrationCardItem) obj;
            if (Intrinsics.areEqual(this.icon, integrationCardItem.icon) && this.title == integrationCardItem.title && Intrinsics.areEqual(this.description, integrationCardItem.description) && Intrinsics.areEqual(this.trailingContent, integrationCardItem.trailingContent) && Intrinsics.areEqual(this.onClick, integrationCardItem.onClick)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Painter painter = this.icon;
        int iHashCode = (this.title.hashCode() + ((painter == null ? 0 : painter.hashCode()) * 31)) * 31;
        Function2 function2 = this.description;
        int iHashCode2 = (iHashCode + (function2 == null ? 0 : function2.hashCode())) * 31;
        Function2 function3 = this.trailingContent;
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((iHashCode2 + (function3 == null ? 0 : function3.hashCode())) * 31, false, 31), false, 31);
        Function0 function0 = this.onClick;
        return iM + (function0 != null ? function0.hashCode() : 0);
    }

    public final String toString() {
        return "IntegrationCardItem(icon=" + this.icon + ", title=" + this.title + ", description=" + this.description + ", trailingContent=" + this.trailingContent + ", showBadge=false, isHighlighted=false, onClick=" + this.onClick + ")";
    }
}
