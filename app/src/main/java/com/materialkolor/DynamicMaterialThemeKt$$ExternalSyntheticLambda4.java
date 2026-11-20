package com.materialkolor;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.material3.MotionScheme;
import androidx.compose.material3.Shapes;
import androidx.compose.material3.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.graphics.Color;
import com.materialkolor.dynamiccolor.ColorSpec$SpecVersion;
import com.materialkolor.scheme.DynamicScheme;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DynamicMaterialThemeKt$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ long f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ double f$10;
    public final /* synthetic */ ColorSpec$SpecVersion f$11;
    public final /* synthetic */ DynamicScheme.Platform f$12;
    public final /* synthetic */ Shapes f$13;
    public final /* synthetic */ Typography f$14;
    public final /* synthetic */ boolean f$15;
    public final /* synthetic */ FiniteAnimationSpec f$16;
    public final /* synthetic */ Function2 f$17;
    public final /* synthetic */ int f$18;
    public final /* synthetic */ int f$19;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ int f$20;
    public final /* synthetic */ Color f$3;
    public final /* synthetic */ Color f$4;
    public final /* synthetic */ Color f$5;
    public final /* synthetic */ Color f$6;
    public final /* synthetic */ Color f$7;
    public final /* synthetic */ Object f$8;
    public final /* synthetic */ PaletteStyle f$9;

    public /* synthetic */ DynamicMaterialThemeKt$$ExternalSyntheticLambda4(long j, MotionScheme motionScheme, boolean z, boolean z2, Color color, Color color2, Color color3, Color color4, Color color5, PaletteStyle paletteStyle, double d, ColorSpec$SpecVersion colorSpec$SpecVersion, DynamicScheme.Platform platform, Shapes shapes, Typography typography, boolean z3, FiniteAnimationSpec finiteAnimationSpec, Function2 function2, int i, int i2, int i3) {
        this.f$0 = j;
        this.f$8 = motionScheme;
        this.f$1 = z;
        this.f$2 = z2;
        this.f$3 = color;
        this.f$4 = color2;
        this.f$5 = color3;
        this.f$6 = color4;
        this.f$7 = color5;
        this.f$9 = paletteStyle;
        this.f$10 = d;
        this.f$11 = colorSpec$SpecVersion;
        this.f$12 = platform;
        this.f$13 = shapes;
        this.f$14 = typography;
        this.f$15 = z3;
        this.f$16 = finiteAnimationSpec;
        this.f$17 = function2;
        this.f$18 = i;
        this.f$19 = i2;
        this.f$20 = i3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$19;
        int i2 = this.f$18;
        Object obj3 = this.f$8;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i2 | 1);
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i);
                DynamicMaterialThemeKt.m932DynamicMaterialThemebLGS3X0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, (Color) obj3, this.f$9, this.f$10, this.f$11, this.f$12, this.f$13, this.f$14, this.f$15, this.f$16, this.f$17, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, this.f$20);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(i2 | 1);
                int iUpdateChangedFlags4 = Stack.updateChangedFlags(i);
                DynamicMaterialExpressiveThemeKt.m930DynamicMaterialExpressiveThemeaFsTsbY(this.f$0, (MotionScheme) obj3, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$9, this.f$10, this.f$11, this.f$12, this.f$13, this.f$14, this.f$15, this.f$16, this.f$17, (Composer) obj, iUpdateChangedFlags3, iUpdateChangedFlags4, this.f$20);
                break;
        }
        return unit;
    }

    public /* synthetic */ DynamicMaterialThemeKt$$ExternalSyntheticLambda4(long j, boolean z, boolean z2, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, PaletteStyle paletteStyle, double d, ColorSpec$SpecVersion colorSpec$SpecVersion, DynamicScheme.Platform platform, Shapes shapes, Typography typography, boolean z3, FiniteAnimationSpec finiteAnimationSpec, Function2 function2, int i, int i2, int i3) {
        this.f$0 = j;
        this.f$1 = z;
        this.f$2 = z2;
        this.f$3 = color;
        this.f$4 = color2;
        this.f$5 = color3;
        this.f$6 = color4;
        this.f$7 = color5;
        this.f$8 = color6;
        this.f$9 = paletteStyle;
        this.f$10 = d;
        this.f$11 = colorSpec$SpecVersion;
        this.f$12 = platform;
        this.f$13 = shapes;
        this.f$14 = typography;
        this.f$15 = z3;
        this.f$16 = finiteAnimationSpec;
        this.f$17 = function2;
        this.f$18 = i;
        this.f$19 = i2;
        this.f$20 = i3;
    }
}
