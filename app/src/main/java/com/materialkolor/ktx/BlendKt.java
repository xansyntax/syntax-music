package com.materialkolor.ktx;

import com.materialkolor.blend.Blend;
import com.materialkolor.hct.HctSolver;
import com.materialkolor.utils.MathUtils;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n\u001a)\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\b\u001a#\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"blend", "Landroidx/compose/ui/graphics/Color;", "Lcom/materialkolor/blend/Blend;", "from", "to", "amount", "", "blend-IbeAmgk", "(Lcom/materialkolor/blend/Blend;JJF)J", "blend-jxsXWHM", "(JJF)J", "blendHue", "blendHue-IbeAmgk", "blendHue-jxsXWHM", "MaterialKolor:material-kolor"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class BlendKt {
    /* JADX INFO: renamed from: blend-IbeAmgk, reason: not valid java name */
    public static final long m936blendIbeAmgk(Blend blend, long j, long j2, float f) {
        blend.getClass();
        return ((long) Blend.cam16Ucs(f, androidx.compose.ui.graphics.ColorKt.m498toArgb8_81llA(j), androidx.compose.ui.graphics.ColorKt.m498toArgb8_81llA(j2))) << 32;
    }

    /* JADX INFO: renamed from: blend-jxsXWHM, reason: not valid java name */
    public static final long m937blendjxsXWHM(long j, long j2, float f) {
        return m936blendIbeAmgk(Blend.INSTANCE, j, j2, f);
    }

    /* JADX INFO: renamed from: blend-jxsXWHM$default, reason: not valid java name */
    public static /* synthetic */ long m938blendjxsXWHM$default(long j, long j2, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.5f;
        }
        return m937blendjxsXWHM(j, j2, f);
    }

    /* JADX INFO: renamed from: blendHue-IbeAmgk, reason: not valid java name */
    public static final long m939blendHueIbeAmgk(Blend blend, long j, long j2, float f) {
        blend.getClass();
        int iM498toArgb8_81llA = androidx.compose.ui.graphics.ColorKt.m498toArgb8_81llA(j);
        int iSolveToInt = HctSolver.solveToInt(HctSolver.fromInt(Blend.cam16Ucs(f, iM498toArgb8_81llA, androidx.compose.ui.graphics.ColorKt.m498toArgb8_81llA(j2))).hue, HctSolver.fromInt(iM498toArgb8_81llA).chroma, MathUtils.lstarFromArgb(iM498toArgb8_81llA));
        HctSolver.fromInt(iSolveToInt);
        MathUtils.lstarFromArgb(iSolveToInt);
        return ((long) iSolveToInt) << 32;
    }

    /* JADX INFO: renamed from: blendHue-jxsXWHM, reason: not valid java name */
    public static final long m940blendHuejxsXWHM(long j, long j2, float f) {
        return m939blendHueIbeAmgk(Blend.INSTANCE, j, j2, f);
    }

    /* JADX INFO: renamed from: blendHue-jxsXWHM$default, reason: not valid java name */
    public static /* synthetic */ long m941blendHuejxsXWHM$default(long j, long j2, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.5f;
        }
        return m940blendHuejxsXWHM(j, j2, f);
    }
}
