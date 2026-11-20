package com.metrolist.music.ui.screens.settings;

import androidx.compose.ui.graphics.Color;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ThemePalette {
    public final int nameRes;
    public final long seedColor;

    public ThemePalette(int i, long j) {
        this.nameRes = i;
        this.seedColor = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThemePalette)) {
            return false;
        }
        ThemePalette themePalette = (ThemePalette) obj;
        return this.nameRes == themePalette.nameRes && ULong.m1869equalsimpl0(this.seedColor, themePalette.seedColor);
    }

    public final int hashCode() {
        return Long.hashCode(this.seedColor) + (Integer.hashCode(this.nameRes) * 31);
    }

    public final String toString() {
        return "ThemePalette(nameRes=" + this.nameRes + ", seedColor=" + Color.m486toStringimpl(this.seedColor) + ")";
    }
}
