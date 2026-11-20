package com.materialkolor.ktx;

import androidx.compose.material3.ColorScheme;
import com.materialkolor.blend.Blend;
import com.materialkolor.hct.Hct;
import com.materialkolor.hct.HctSolver;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007b\u0002\b\t¢\u0006\u0004\b\u0007\u0010\b\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007b\u0002\b\t¢\u0006\u0004\b\u000b\u0010\f\u001a)\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007b\u0002\b\t¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"harmonize", "Landroidx/compose/ui/graphics/Color;", "Lcom/materialkolor/blend/Blend;", "fromColor", "toColor", "matchSaturation", "", "harmonize-IbeAmgk", "(Lcom/materialkolor/blend/Blend;JJZ)J", "Landroidx/compose/runtime/Stable;", "other", "harmonize-jxsXWHM", "(JJZ)J", "harmonizeWithPrimary", "Landroidx/compose/material3/ColorScheme;", "color", "harmonizeWithPrimary-bw27NRU", "(Landroidx/compose/material3/ColorScheme;JZ)J", "MaterialKolor:material-kolor"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class HarmonizeKt {
    /* JADX INFO: renamed from: harmonize-IbeAmgk, reason: not valid java name */
    public static final long m966harmonizeIbeAmgk(Blend blend, long j, long j2, boolean z) {
        blend.getClass();
        if (z) {
            j = ColorKt.m950matchSaturationOWjLjI(j, j2);
        }
        Hct.Companion companion = Hct.Companion;
        Hct hctM972from4WTKRHQ = HctKt.m972from4WTKRHQ(companion, j);
        Hct hctM972from4WTKRHQ2 = HctKt.m972from4WTKRHQ(companion, j2);
        hctM972from4WTKRHQ.getClass();
        hctM972from4WTKRHQ2.getClass();
        double d = hctM972from4WTKRHQ.hue;
        double d2 = hctM972from4WTKRHQ2.hue;
        double dMin = Math.min((180.0d - Math.abs(Math.abs(d - d2) - 180.0d)) * 0.5d, 15.0d);
        double d3 = (d2 - d) % 360.0d;
        if (d3 < 0.0d) {
            d3 += 360.0d;
        }
        double d4 = ((dMin * (d3 <= 180.0d ? 1.0d : -1.0d)) + d) % 360.0d;
        if (d4 < 0.0d) {
            d4 += 360.0d;
        }
        return HctKt.toColor(new Hct(HctSolver.solveToInt(d4, hctM972from4WTKRHQ.chroma, hctM972from4WTKRHQ.tone)));
    }

    /* JADX INFO: renamed from: harmonize-IbeAmgk$default, reason: not valid java name */
    public static /* synthetic */ long m967harmonizeIbeAmgk$default(Blend blend, long j, long j2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return m966harmonizeIbeAmgk(blend, j, j2, z);
    }

    /* JADX INFO: renamed from: harmonize-jxsXWHM, reason: not valid java name */
    public static final long m968harmonizejxsXWHM(long j, long j2, boolean z) {
        return m966harmonizeIbeAmgk(Blend.INSTANCE, j, j2, z);
    }

    /* JADX INFO: renamed from: harmonize-jxsXWHM$default, reason: not valid java name */
    public static /* synthetic */ long m969harmonizejxsXWHM$default(long j, long j2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m968harmonizejxsXWHM(j, j2, z);
    }

    /* JADX INFO: renamed from: harmonizeWithPrimary-bw27NRU, reason: not valid java name */
    public static final long m970harmonizeWithPrimarybw27NRU(ColorScheme colorScheme, long j, boolean z) {
        colorScheme.getClass();
        return m966harmonizeIbeAmgk(Blend.INSTANCE, j, colorScheme.primary, z);
    }

    /* JADX INFO: renamed from: harmonizeWithPrimary-bw27NRU$default, reason: not valid java name */
    public static /* synthetic */ long m971harmonizeWithPrimarybw27NRU$default(ColorScheme colorScheme, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m970harmonizeWithPrimarybw27NRU(colorScheme, j, z);
    }
}
