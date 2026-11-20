package com.metrolist.music.ui.component;

import android.app.ActivityManager;
import android.content.Context;
import androidx.collection.internal.Lock;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.shape.DpCornerSize;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.ListItemColors;
import androidx.compose.material3.ListItemDefaults;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.LinearGradient;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda21;
import com.metrolist.music.db.entities.CachedItem$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.theme.UiStyle;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.CanvasKt;
import dev.chrisbanes.haze.HazeState;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GlassComponentsKt {
    public static final StaticProvidableCompositionLocal LocalHazeState = new StaticProvidableCompositionLocal(new CachedItem$$ExternalSyntheticLambda0((byte) 21), (byte) 0);
    public static final StaticProvidableCompositionLocal LocalGlassBlurEnabled = new StaticProvidableCompositionLocal(new CachedItem$$ExternalSyntheticLambda0((byte) 22), (byte) 1);

    static {
        RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(24.0f);
        RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(32.0f);
    }

    public static final Modifier ambientGlow(Composer composer, Modifier modifier) {
        modifier.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(-1610554221);
        if (!isGlass(gapComposer)) {
            gapComposer.end(false);
            return modifier;
        }
        ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
        boolean zIsDarkSurface = isDarkSurface(gapComposer);
        TweenSpec tweenSpecTween$default = ArcSplineKt.tween$default(900, 0, null, 6);
        long j = colorScheme.primary;
        AnimateAsState animateAsStateM17animateColorAsStateeuL9pac = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), zIsDarkSurface ? 0.4f : 0.3f, Color.m483getColorSpaceimpl(j)), tweenSpecTween$default, "glowA", gapComposer, 432, 8);
        long j2 = colorScheme.secondary;
        AnimateAsState animateAsStateM17animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(ColorKt.Color(Color.m485getRedimpl(j2), Color.m484getGreenimpl(j2), Color.m482getBlueimpl(j2), zIsDarkSurface ? 0.2f : 0.3f, Color.m483getColorSpaceimpl(j2)), tweenSpecTween$default, "glowB", gapComposer, 432, 8);
        long j3 = colorScheme.tertiary;
        AnimateAsState animateAsStateM17animateColorAsStateeuL9pac3 = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(ColorKt.Color(Color.m485getRedimpl(j3), Color.m484getGreenimpl(j3), Color.m482getBlueimpl(j3), zIsDarkSurface ? 0.26f : 0.22f, Color.m483getColorSpaceimpl(j3)), tweenSpecTween$default, "glowC", gapComposer, 432, 8);
        boolean zChanged = gapComposer.changed(animateAsStateM17animateColorAsStateeuL9pac) | gapComposer.changed(animateAsStateM17animateColorAsStateeuL9pac2) | gapComposer.changed(animateAsStateM17animateColorAsStateeuL9pac3);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new MainActivity$$ExternalSyntheticLambda21((Object) animateAsStateM17animateColorAsStateeuL9pac, (Object) animateAsStateM17animateColorAsStateeuL9pac2, (Object) animateAsStateM17animateColorAsStateeuL9pac3, (byte) 10);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        Modifier modifierDrawWithCache = ClipKt.drawWithCache(modifier, (Function1) objRememberedValue);
        gapComposer.end(false);
        return modifierDrawWithCache;
    }

    /* JADX INFO: renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m1477compositeOverOWjLjI(long j, long j2) {
        float fM481getAlphaimpl = Color.m481getAlphaimpl(j);
        float f = 1.0f - fM481getAlphaimpl;
        return ColorKt.Color((Color.m485getRedimpl(j2) * f) + (Color.m485getRedimpl(j) * fM481getAlphaimpl), (Color.m484getGreenimpl(j2) * f) + (Color.m484getGreenimpl(j) * fM481getAlphaimpl), (Color.m482getBlueimpl(j2) * f) + (Color.m482getBlueimpl(j) * fM481getAlphaimpl), 1.0f, ColorSpaces.Srgb);
    }

    public static final Modifier glass(Modifier modifier, Shape shape, boolean z, Composer composer, int i, int i2) {
        Modifier modifierM43borderziNgDLE;
        modifier.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(513319823);
        if ((i2 & 2) != 0) {
            z = false;
        }
        boolean zIsGlass = isGlass(gapComposer);
        RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = ColorKt.RectangleShape;
        if (zIsGlass) {
            gapComposer.startReplaceGroup(-2067378605);
            gapComposer.end(false);
            long jGlassFill = glassFill(z, gapComposer, 0);
            Brush brushGlassRim = glassRim(gapComposer);
            Brush brushGlassSheen = glassSheen(gapComposer);
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(ClipKt.clip(modifier, shape), jGlassFill, rectangleShapeKt$RectangleShape$1);
            boolean zChanged = gapComposer.changed(brushGlassSheen);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new GlassComponentsKt$$ExternalSyntheticLambda0(brushGlassSheen, (byte) 0);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            modifierM43borderziNgDLE = ImageKt.m43borderziNgDLE(ClipKt.drawBehind(modifierM39backgroundbw27NRU, (Function1) objRememberedValue), 1.0f, brushGlassRim, shape);
        } else {
            gapComposer.startReplaceGroup(-2067574649);
            ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
            modifierM43borderziNgDLE = ImageKt.m42borderxT4_qwU(ImageKt.m39backgroundbw27NRU(ClipKt.clip(modifier, shape), colorScheme.surfaceContainer, rectangleShapeKt$RectangleShape$1), 1.0f, colorScheme.outlineVariant, shape);
            gapComposer.end(false);
        }
        gapComposer.end(false);
        return modifierM43borderziNgDLE;
    }

    /* JADX INFO: renamed from: glassBlur-942rkJo, reason: not valid java name */
    public static final Modifier m1478glassBlur942rkJo(Modifier modifier, RoundedCornerShape roundedCornerShape, Composer composer, int i) {
        Modifier modifierM43borderziNgDLE;
        modifier.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(1372326696);
        ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
        if (isGlass(gapComposer)) {
            HazeState hazeState = (HazeState) gapComposer.consume(LocalHazeState);
            boolean zBooleanValue = true;
            if (hazeState == null) {
                gapComposer.startReplaceGroup(-808665893);
            } else {
                gapComposer.startReplaceGroup(251009158);
                zBooleanValue = true ^ ((Boolean) gapComposer.consume(LocalGlassBlurEnabled)).booleanValue();
            }
            gapComposer.end(false);
            if (zBooleanValue) {
                gapComposer.startReplaceGroup(-808613554);
                long j = colorScheme.surface;
                modifierM43borderziNgDLE = glass(ImageKt.m39backgroundbw27NRU(modifier, ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.86f, Color.m483getColorSpaceimpl(j)), roundedCornerShape), roundedCornerShape, true, gapComposer, i & 112, 0);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-808417510);
                gapComposer.end(false);
                long jGlassFill = glassFill(true, gapComposer, 0);
                Brush brushGlassRim = glassRim(gapComposer);
                Brush brushGlassSheen = glassSheen(gapComposer);
                Modifier modifierClip = ClipKt.clip(modifier, roundedCornerShape);
                boolean zChanged = gapComposer.changed(colorScheme) | gapComposer.changed(jGlassFill) | gapComposer.changed(16.0f);
                Object objRememberedValue = gapComposer.rememberedValue();
                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                if (zChanged || objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new ScrimKt$$ExternalSyntheticLambda1((Object) colorScheme, jGlassFill, (byte) 4);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierHazeEffect$default = CanvasKt.hazeEffect$default(modifierClip, hazeState, (Function1) objRememberedValue);
                boolean zChanged2 = gapComposer.changed(brushGlassSheen);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new GlassComponentsKt$$ExternalSyntheticLambda0(brushGlassSheen, (byte) 2);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                modifierM43borderziNgDLE = ImageKt.m43borderziNgDLE(ClipKt.drawBehind(modifierHazeEffect$default, (Function1) objRememberedValue2), 1.0f, brushGlassRim, roundedCornerShape);
            }
        } else {
            modifierM43borderziNgDLE = ImageKt.m42borderxT4_qwU(ImageKt.m39backgroundbw27NRU(ClipKt.clip(modifier, roundedCornerShape), m1477compositeOverOWjLjI(colorScheme.surfaceContainerHigh, colorScheme.surface), ColorKt.RectangleShape), 1.0f, colorScheme.outlineVariant, roundedCornerShape);
        }
        gapComposer.end(false);
        return modifierM43borderziNgDLE;
    }

    public static final boolean glassBlurDefault(Context context) {
        context.getClass();
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null) {
            return true;
        }
        return !activityManager.isLowRamDevice() && activityManager.getMemoryClass() >= 192;
    }

    public static final Modifier glassCard(Modifier modifier, Shape shape, Composer composer) {
        Modifier modifierM42borderxT4_qwU;
        modifier.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(1175121891);
        ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
        boolean zIsGlass = isGlass(gapComposer);
        RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = ColorKt.RectangleShape;
        if (zIsGlass) {
            boolean zIsDarkSurface = isDarkSurface(gapComposer);
            modifierM42borderxT4_qwU = ImageKt.m42borderxT4_qwU(ImageKt.m39backgroundbw27NRU(ClipKt.clip(modifier, shape), ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), zIsDarkSurface ? 0.075f : 0.72f, Color.m483getColorSpaceimpl(-4294967296L)), rectangleShapeKt$RectangleShape$1), 0.8f, ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), zIsDarkSurface ? 0.1f : 0.85f, Color.m483getColorSpaceimpl(-4294967296L)), shape);
        } else {
            modifierM42borderxT4_qwU = ImageKt.m42borderxT4_qwU(ImageKt.m39backgroundbw27NRU(ClipKt.clip(modifier, shape), colorScheme.surfaceContainer, rectangleShapeKt$RectangleShape$1), 1.0f, colorScheme.outlineVariant, shape);
        }
        gapComposer.end(false);
        return modifierM42borderxT4_qwU;
    }

    public static final long glassFill(boolean z, Composer composer, int i) {
        if ((i & 1) != 0) {
            z = false;
        }
        if (isDarkSurface(composer)) {
            return ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), z ? 0.13f : 0.08f, Color.m483getColorSpaceimpl(-4294967296L));
        }
        return ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), z ? 0.78f : 0.55f, Color.m483getColorSpaceimpl(-4294967296L));
    }

    public static final ListItemColors glassListItemColors(Composer composer) {
        PaddingValuesImpl paddingValuesImpl = ListItemDefaults.ContentPadding;
        long jColor = isGlass(composer) ? 0L : ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
        Rgb rgb = ColorSpaces.Unspecified;
        long jColor2 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor3 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor4 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor5 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor6 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor7 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor8 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor9 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        ColorScheme colorScheme = ((MaterialTheme$Values) ((GapComposer) composer).consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
        ListItemColors listItemColors = colorScheme.defaultListItemColorsCached;
        if (listItemColors == null) {
            long jM284fromToken_Htp75A = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 34);
            long jM284fromToken_Htp75A2 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
            long jM284fromToken_Htp75A3 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
            long jM284fromToken_Htp75A4 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
            long jM284fromToken_Htp75A5 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
            long jM284fromToken_Htp75A6 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
            long jM284fromToken_Htp75A7 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 31);
            long jM284fromToken_Htp75A8 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 14);
            long jM284fromToken_Htp75A9 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 14);
            long jM284fromToken_Htp75A10 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 14);
            long jM284fromToken_Htp75A11 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 14);
            long jM284fromToken_Htp75A12 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 14);
            long jM284fromToken_Htp75A13 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 34);
            long jM284fromToken_Htp75A14 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
            long jColor10 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A14), Color.m484getGreenimpl(jM284fromToken_Htp75A14), Color.m482getBlueimpl(jM284fromToken_Htp75A14), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A14));
            long jM284fromToken_Htp75A15 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
            long jColor11 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A15), Color.m484getGreenimpl(jM284fromToken_Htp75A15), Color.m482getBlueimpl(jM284fromToken_Htp75A15), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A15));
            long jM284fromToken_Htp75A16 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
            long jColor12 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A16), Color.m484getGreenimpl(jM284fromToken_Htp75A16), Color.m482getBlueimpl(jM284fromToken_Htp75A16), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A16));
            long jM284fromToken_Htp75A17 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
            long jColor13 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A17), Color.m484getGreenimpl(jM284fromToken_Htp75A17), Color.m482getBlueimpl(jM284fromToken_Htp75A17), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A17));
            long jM284fromToken_Htp75A18 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
            listItemColors = new ListItemColors(jM284fromToken_Htp75A, jM284fromToken_Htp75A2, jM284fromToken_Htp75A3, jM284fromToken_Htp75A4, jM284fromToken_Htp75A5, jM284fromToken_Htp75A6, jM284fromToken_Htp75A13, jColor10, jColor11, jColor12, jColor13, ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A18), Color.m484getGreenimpl(jM284fromToken_Htp75A18), Color.m482getBlueimpl(jM284fromToken_Htp75A18), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A18)), jM284fromToken_Htp75A7, jM284fromToken_Htp75A8, jM284fromToken_Htp75A9, jM284fromToken_Htp75A10, jM284fromToken_Htp75A11, jM284fromToken_Htp75A12, ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 45), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 20), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 20), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 20), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 20), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 20));
            colorScheme.defaultListItemColorsCached = listItemColors;
        }
        long j = listItemColors.disabledContainerColor;
        long j2 = listItemColors.disabledOverlineContentColor;
        long j3 = listItemColors.disabledSupportingContentColor;
        long j4 = listItemColors.selectedContainerColor;
        long j5 = listItemColors.selectedContentColor;
        long j6 = listItemColors.selectedLeadingContentColor;
        long j7 = listItemColors.selectedTrailingContentColor;
        long j8 = listItemColors.selectedOverlineContentColor;
        long j9 = listItemColors.selectedSupportingContentColor;
        long j10 = listItemColors.draggedContainerColor;
        long j11 = listItemColors.draggedContentColor;
        long j12 = listItemColors.draggedLeadingContentColor;
        long j13 = listItemColors.draggedTrailingContentColor;
        long j14 = listItemColors.draggedOverlineContentColor;
        long j15 = listItemColors.draggedSupportingContentColor;
        long j16 = jColor != 16 ? jColor : listItemColors.containerColor;
        long j17 = jColor2 != 16 ? jColor2 : listItemColors.contentColor;
        if (jColor3 == 16) {
            jColor3 = listItemColors.leadingContentColor;
        }
        long j18 = jColor3;
        if (jColor6 == 16) {
            jColor6 = listItemColors.trailingContentColor;
        }
        long j19 = jColor6;
        if (jColor4 == 16) {
            jColor4 = listItemColors.overlineContentColor;
        }
        long j20 = jColor4;
        if (jColor5 == 16) {
            jColor5 = listItemColors.supportingContentColor;
        }
        long j21 = jColor5;
        if (jColor7 == 16) {
            jColor7 = listItemColors.disabledContentColor;
        }
        return new ListItemColors(j16, j17, j18, j19, j20, j21, j, jColor7, jColor8 != 16 ? jColor8 : listItemColors.disabledLeadingContentColor, jColor9 != 16 ? jColor9 : listItemColors.disabledTrailingContentColor, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15);
    }

    /* JADX INFO: renamed from: glassOverlay-6a0pyJM, reason: not valid java name */
    public static final Modifier m1479glassOverlay6a0pyJM(Modifier modifier, Shape shape, Composer composer) {
        Modifier modifierM43borderziNgDLE;
        modifier.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(-445078967);
        ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
        boolean zIsGlass = isGlass(gapComposer);
        RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = ColorKt.RectangleShape;
        if (zIsGlass) {
            Brush brushGlassRim = glassRim(gapComposer);
            Brush brushGlassSheen = glassSheen(gapComposer);
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(ambientGlow(gapComposer, ImageKt.m39backgroundbw27NRU(ClipKt.clip(modifier, shape), colorScheme.surface, rectangleShapeKt$RectangleShape$1)), glassFill(true, gapComposer, 0), rectangleShapeKt$RectangleShape$1);
            boolean zChanged = gapComposer.changed(brushGlassSheen);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new GlassComponentsKt$$ExternalSyntheticLambda0(brushGlassSheen, (byte) 1);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            modifierM43borderziNgDLE = ImageKt.m43borderziNgDLE(ClipKt.drawBehind(modifierM39backgroundbw27NRU, (Function1) objRememberedValue), 1.0f, brushGlassRim, shape);
        } else {
            modifierM43borderziNgDLE = ImageKt.m42borderxT4_qwU(ImageKt.m39backgroundbw27NRU(ClipKt.clip(modifier, shape), m1477compositeOverOWjLjI(colorScheme.surfaceContainerHigh, colorScheme.surface), rectangleShapeKt$RectangleShape$1), 1.0f, colorScheme.outlineVariant, shape);
        }
        gapComposer.end(false);
        return modifierM43borderziNgDLE;
    }

    public static final Brush glassRim(Composer composer) {
        LinearGradient linearGradient;
        boolean zIsGlass = isGlass(composer);
        boolean zIsDarkSurface = isDarkSurface(composer);
        GapComposer gapComposer = (GapComposer) composer;
        long j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
        boolean zChanged = gapComposer.changed(zIsGlass) | gapComposer.changed(zIsDarkSurface) | gapComposer.changed(j);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            if (zIsGlass) {
                long jColor = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), zIsDarkSurface ? 0.48f : 0.95f, Color.m483getColorSpaceimpl(-4294967296L));
                long jColor2 = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), zIsDarkSurface ? 0.05f : 0.25f, Color.m483getColorSpaceimpl(-4294967296L));
                linearGradient = new LinearGradient((((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) & 4294967295L), (((long) Float.floatToRawIntBits(Float.POSITIVE_INFINITY)) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.POSITIVE_INFINITY)) << 32), CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{new Color(jColor), new Color(jColor2), new Color(jColor2), new Color(ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), zIsDarkSurface ? 0.22f : 0.65f, Color.m483getColorSpaceimpl(-4294967296L)))}), null);
            } else {
                linearGradient = new LinearGradient(0L, 9187343241974906880L, CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{new Color(j), new Color(j)}), null);
            }
            objRememberedValue = linearGradient;
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (Brush) objRememberedValue;
    }

    /* JADX INFO: renamed from: glassShape-ixp7dh8, reason: not valid java name */
    public static final RoundedCornerShape m1480glassShapeixp7dh8(float f, float f2, Composer composer) {
        if (!isGlass(composer)) {
            f = f2;
        }
        return RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(f);
    }

    public static final Brush glassSheen(Composer composer) {
        boolean zIsDarkSurface = isDarkSurface(composer);
        GapComposer gapComposer = (GapComposer) composer;
        boolean zChanged = gapComposer.changed(zIsDarkSurface);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            Pair[] pairArr = {new Pair(Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO), new Color(ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), zIsDarkSurface ? 0.1f : 0.35f, Color.m483getColorSpaceimpl(-4294967296L)))), new Pair(Float.valueOf(0.5f), new Color(0L))};
            objRememberedValue = Lock.m9linearGradientmHitzGk((Pair[]) Arrays.copyOf(pairArr, pairArr.length), (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) & 4294967295L), (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits(Float.POSITIVE_INFINITY)) & 4294967295L));
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (Brush) objRememberedValue;
    }

    /* JADX INFO: renamed from: glassTinted-FNF3uiM, reason: not valid java name */
    public static final Modifier m1481glassTintedFNF3uiM(Modifier modifier, Shape shape, Composer composer) {
        Modifier modifierM43borderziNgDLE;
        modifier.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(1657455300);
        long j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
        boolean zIsGlass = isGlass(gapComposer);
        RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = ColorKt.RectangleShape;
        if (zIsGlass) {
            Brush brushGlassRim = glassRim(gapComposer);
            Pair[] pairArr = {new Pair(Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO), new Color(ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.38f, Color.m483getColorSpaceimpl(-4294967296L)))), new Pair(Float.valueOf(0.55f), new Color(0L))};
            LinearGradient linearGradientM9linearGradientmHitzGk = Lock.m9linearGradientmHitzGk((Pair[]) Arrays.copyOf(pairArr, pairArr.length), (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) & 4294967295L), (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits(Float.POSITIVE_INFINITY)) & 4294967295L));
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(ClipKt.clip(modifier, shape), ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.86f, Color.m483getColorSpaceimpl(j)), rectangleShapeKt$RectangleShape$1);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new DiskLruCache$$ExternalSyntheticLambda0((byte) 26, linearGradientM9linearGradientmHitzGk);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            modifierM43borderziNgDLE = ImageKt.m43borderziNgDLE(ClipKt.drawBehind(modifierM39backgroundbw27NRU, (Function1) objRememberedValue), 1.0f, brushGlassRim, shape);
        } else {
            modifierM43borderziNgDLE = ImageKt.m39backgroundbw27NRU(ClipKt.clip(modifier, shape), j, rectangleShapeKt$RectangleShape$1);
        }
        gapComposer.end(false);
        return modifierM43borderziNgDLE;
    }

    /* JADX INFO: renamed from: glassTopShape-ixp7dh8, reason: not valid java name */
    public static final RoundedCornerShape m1482glassTopShapeixp7dh8(float f, Composer composer) {
        if (isGlass(composer)) {
            f = 32.0f;
        }
        return new RoundedCornerShape(new DpCornerSize(f), new DpCornerSize(f), new DpCornerSize(CropImageView.DEFAULT_ASPECT_RATIO), new DpCornerSize(CropImageView.DEFAULT_ASPECT_RATIO));
    }

    public static final boolean isDarkSurface(Composer composer) {
        return ColorKt.m494luminance8_81llA(((MaterialTheme$Values) ((GapComposer) composer).consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface) < 0.5f;
    }

    public static final boolean isGlass(Composer composer) {
        return ((GapComposer) composer).consume(UiStyleKt.LocalUiStyle) == UiStyle.GLASS;
    }
}
