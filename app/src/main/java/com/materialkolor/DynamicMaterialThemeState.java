package com.materialkolor;

import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.graphics.Color;
import com.dokar.quickjs.QuickJs$$ExternalSyntheticLambda1;
import com.materialkolor.dynamiccolor.ColorSpec$SpecVersion;
import com.materialkolor.ktx.DynamicSchemeKt;
import com.materialkolor.scheme.DynamicScheme;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DynamicMaterialThemeState {
    public final ParcelableSnapshotMutableState contrastLevel$delegate;
    public final ParcelableSnapshotMutableState error$delegate;
    public final ParcelableSnapshotMutableState isAmoled$delegate;
    public final ParcelableSnapshotMutableState isDark$delegate;
    public final Function2 modifyColorScheme;
    public final ParcelableSnapshotMutableState neutral$delegate;
    public final ParcelableSnapshotMutableState neutralVariant$delegate;
    public final ParcelableSnapshotMutableState platform$delegate;
    public final ParcelableSnapshotMutableState primary$delegate;
    public final ParcelableSnapshotMutableState secondary$delegate;
    public final ParcelableSnapshotMutableState seedColor$delegate;
    public final ParcelableSnapshotMutableState specVersion$delegate;
    public final ParcelableSnapshotMutableState style$delegate;
    public final ParcelableSnapshotMutableState tertiary$delegate;

    public DynamicMaterialThemeState(long j, boolean z, boolean z2, PaletteStyle paletteStyle, double d, ColorSpec$SpecVersion colorSpec$SpecVersion, DynamicScheme.Platform platform, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, Function2 function2) {
        paletteStyle.getClass();
        colorSpec$SpecVersion.getClass();
        platform.getClass();
        this.modifyColorScheme = function2;
        this.seedColor$delegate = Stack.mutableStateOf$default(new Color(j));
        this.isDark$delegate = Stack.mutableStateOf$default(Boolean.valueOf(z));
        this.isAmoled$delegate = Stack.mutableStateOf$default(Boolean.valueOf(z2));
        this.style$delegate = Stack.mutableStateOf$default(paletteStyle);
        this.contrastLevel$delegate = Stack.mutableStateOf$default(Double.valueOf(d));
        this.specVersion$delegate = Stack.mutableStateOf$default(colorSpec$SpecVersion);
        this.platform$delegate = Stack.mutableStateOf$default(platform);
        this.primary$delegate = Stack.mutableStateOf$default(color);
        this.secondary$delegate = Stack.mutableStateOf$default(color2);
        this.tertiary$delegate = Stack.mutableStateOf$default(color3);
        this.neutral$delegate = Stack.mutableStateOf$default(color4);
        this.neutralVariant$delegate = Stack.mutableStateOf$default(color5);
        this.error$delegate = Stack.mutableStateOf$default(color6);
    }

    public final ColorScheme getColorScheme(int i, GapComposer gapComposer) {
        Function1 function1;
        Color color = (Color) this.primary$delegate.getValue();
        Function2 function2 = this.modifyColorScheme;
        if (function2 == null) {
            gapComposer.startReplaceGroup(-20094885);
            gapComposer.end(false);
            function1 = null;
        } else {
            gapComposer.startReplaceGroup(-20094884);
            boolean zChanged = gapComposer.changed(function2) | ((((i & 14) ^ 6) > 4 && gapComposer.changed(this)) || (i & 6) == 4);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new QuickJs$$ExternalSyntheticLambda1(function2, this, (byte) 8);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
            gapComposer.end(false);
        }
        Function1 function3 = function1;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.error$delegate;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = this.neutralVariant$delegate;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState3 = this.neutral$delegate;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState4 = this.tertiary$delegate;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState5 = this.secondary$delegate;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState6 = this.isAmoled$delegate;
        if (color != null) {
            gapComposer.startReplaceGroup(137903459);
            ColorScheme colorSchemeM927rememberDynamicColorSchemeCdFbwI = DynamicColorSchemeKt.m927rememberDynamicColorSchemeCdFbwI(color.value, isDark(), ((Boolean) parcelableSnapshotMutableState6.getValue()).booleanValue(), (Color) parcelableSnapshotMutableState5.getValue(), (Color) parcelableSnapshotMutableState4.getValue(), (Color) parcelableSnapshotMutableState3.getValue(), (Color) parcelableSnapshotMutableState2.getValue(), (Color) parcelableSnapshotMutableState.getValue(), getStyle(), getContrastLevel(), getSpecVersion(), getPlatform(), function3, gapComposer, 0, 0, 0);
            gapComposer.end(false);
            return colorSchemeM927rememberDynamicColorSchemeCdFbwI;
        }
        if (isCustomScheme()) {
            gapComposer.startReplaceGroup(137923726);
            ColorScheme colorSchemeM928rememberDynamicColorSchemeUQznLDA = DynamicColorSchemeKt.m928rememberDynamicColorSchemeUQznLDA(m933getSeedColor0d7_KjU(), isDark(), ((Boolean) parcelableSnapshotMutableState6.getValue()).booleanValue(), color, (Color) parcelableSnapshotMutableState5.getValue(), (Color) parcelableSnapshotMutableState4.getValue(), (Color) parcelableSnapshotMutableState3.getValue(), (Color) parcelableSnapshotMutableState2.getValue(), (Color) parcelableSnapshotMutableState.getValue(), getStyle(), getContrastLevel(), getSpecVersion(), getPlatform(), function3, gapComposer, 0, 0, 0);
            gapComposer.end(false);
            return colorSchemeM928rememberDynamicColorSchemeUQznLDA;
        }
        gapComposer.startReplaceGroup(137944792);
        ColorScheme colorSchemeM928rememberDynamicColorSchemeUQznLDA2 = DynamicColorSchemeKt.m928rememberDynamicColorSchemeUQznLDA(m933getSeedColor0d7_KjU(), isDark(), ((Boolean) parcelableSnapshotMutableState6.getValue()).booleanValue(), null, null, null, null, null, null, getStyle(), getContrastLevel(), getSpecVersion(), getPlatform(), function3, gapComposer, 3072, 0, 496);
        gapComposer.end(false);
        return colorSchemeM928rememberDynamicColorSchemeUQznLDA2;
    }

    public final double getContrastLevel() {
        return ((Number) this.contrastLevel$delegate.getValue()).doubleValue();
    }

    public final DynamicScheme getDynamicScheme(Composer composer) {
        Color color = (Color) this.primary$delegate.getValue();
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.error$delegate;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = this.neutralVariant$delegate;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState3 = this.neutral$delegate;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState4 = this.tertiary$delegate;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState5 = this.secondary$delegate;
        if (color != null) {
            GapComposer gapComposer = (GapComposer) composer;
            gapComposer.startReplaceGroup(-311275072);
            DynamicScheme dynamicSchemeM963rememberDynamicSchemek1ZVges = DynamicSchemeKt.m963rememberDynamicSchemek1ZVges(color.value, isDark(), color, (Color) parcelableSnapshotMutableState5.getValue(), (Color) parcelableSnapshotMutableState4.getValue(), (Color) parcelableSnapshotMutableState3.getValue(), (Color) parcelableSnapshotMutableState2.getValue(), (Color) parcelableSnapshotMutableState.getValue(), getStyle(), getContrastLevel(), getSpecVersion(), getPlatform(), gapComposer, 0, 0, 0);
            gapComposer.end(false);
            return dynamicSchemeM963rememberDynamicSchemek1ZVges;
        }
        if (isCustomScheme()) {
            GapComposer gapComposer2 = (GapComposer) composer;
            gapComposer2.startReplaceGroup(-311256606);
            DynamicScheme dynamicSchemeM963rememberDynamicSchemek1ZVges2 = DynamicSchemeKt.m963rememberDynamicSchemek1ZVges(m933getSeedColor0d7_KjU(), isDark(), color, (Color) parcelableSnapshotMutableState5.getValue(), (Color) parcelableSnapshotMutableState4.getValue(), (Color) parcelableSnapshotMutableState3.getValue(), (Color) parcelableSnapshotMutableState2.getValue(), (Color) parcelableSnapshotMutableState.getValue(), getStyle(), getContrastLevel(), getSpecVersion(), getPlatform(), gapComposer2, 0, 0, 0);
            gapComposer2.end(false);
            return dynamicSchemeM963rememberDynamicSchemek1ZVges2;
        }
        GapComposer gapComposer3 = (GapComposer) composer;
        gapComposer3.startReplaceGroup(-311238648);
        DynamicScheme dynamicSchemeM963rememberDynamicSchemek1ZVges3 = DynamicSchemeKt.m963rememberDynamicSchemek1ZVges(m933getSeedColor0d7_KjU(), isDark(), null, null, null, null, null, null, getStyle(), getContrastLevel(), getSpecVersion(), getPlatform(), gapComposer3, 0, 0, 252);
        gapComposer3.end(false);
        return dynamicSchemeM963rememberDynamicSchemek1ZVges3;
    }

    public final DynamicScheme.Platform getPlatform() {
        return (DynamicScheme.Platform) this.platform$delegate.getValue();
    }

    /* JADX INFO: renamed from: getSeedColor-0d7_KjU, reason: not valid java name */
    public final long m933getSeedColor0d7_KjU() {
        return ((Color) this.seedColor$delegate.getValue()).value;
    }

    public final ColorSpec$SpecVersion getSpecVersion() {
        return (ColorSpec$SpecVersion) this.specVersion$delegate.getValue();
    }

    public final PaletteStyle getStyle() {
        return (PaletteStyle) this.style$delegate.getValue();
    }

    public final boolean isCustomScheme() {
        List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{(Color) this.primary$delegate.getValue(), (Color) this.secondary$delegate.getValue(), (Color) this.tertiary$delegate.getValue(), (Color) this.neutral$delegate.getValue(), (Color) this.neutralVariant$delegate.getValue(), (Color) this.error$delegate.getValue()});
        if (listListOf.isEmpty()) {
            return false;
        }
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            if (((Color) it.next()) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean isDark() {
        return ((Boolean) this.isDark$delegate.getValue()).booleanValue();
    }
}
