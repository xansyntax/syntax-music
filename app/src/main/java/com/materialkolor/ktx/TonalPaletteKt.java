package com.materialkolor.ktx;

import com.materialkolor.hct.Hct;
import com.materialkolor.palettes.TonalPalette;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n\u001a\u0017\u0010\u000b\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"from", "Lcom/materialkolor/palettes/TonalPalette;", "Lcom/materialkolor/palettes/TonalPalette$Companion;", "color", "Landroidx/compose/ui/graphics/Color;", "from-4WTKRHQ", "(Lcom/materialkolor/palettes/TonalPalette$Companion;J)Lcom/materialkolor/palettes/TonalPalette;", "argb", "", "hct", "Lcom/materialkolor/hct/Hct;", "toneColor", "tone", "(Lcom/materialkolor/palettes/TonalPalette;I)J", "MaterialKolor:material-kolor"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class TonalPaletteKt {
    public static final TonalPalette from(TonalPalette.Companion companion, int i) {
        companion.getClass();
        Hct hct = new Hct(i);
        return new TonalPalette(hct.hue, hct.chroma, hct);
    }

    /* JADX INFO: renamed from: from-4WTKRHQ, reason: not valid java name */
    public static final TonalPalette m984from4WTKRHQ(TonalPalette.Companion companion, long j) {
        companion.getClass();
        return from(companion, androidx.compose.ui.graphics.ColorKt.m498toArgb8_81llA(j));
    }

    public static final long toneColor(TonalPalette tonalPalette, int i) {
        tonalPalette.getClass();
        return ((long) tonalPalette.tone(i)) << 32;
    }

    public static final TonalPalette from(TonalPalette.Companion companion, Hct hct) {
        companion.getClass();
        hct.getClass();
        return new TonalPalette(hct.hue, hct.chroma, hct);
    }
}
