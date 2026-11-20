package com.metrolist.music.ui.component;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DraggableLyricsProviderItem {
    public final Painter icon;
    public final String id;
    public final String name;

    public DraggableLyricsProviderItem(String str, String str2, Painter painter) {
        painter.getClass();
        this.id = str;
        this.name = str2;
        this.icon = painter;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DraggableLyricsProviderItem)) {
            return false;
        }
        DraggableLyricsProviderItem draggableLyricsProviderItem = (DraggableLyricsProviderItem) obj;
        return this.id.equals(draggableLyricsProviderItem.id) && this.name.equals(draggableLyricsProviderItem.name) && Intrinsics.areEqual(this.icon, draggableLyricsProviderItem.icon);
    }

    public final int hashCode() {
        return this.icon.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.name);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("DraggableLyricsProviderItem(id=", this.id, ", name=", this.name, ", icon=");
        sbM.append(this.icon);
        sbM.append(")");
        return sbM.toString();
    }
}
