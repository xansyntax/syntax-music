package androidx.compose.material3;

import androidx.collection.internal.Lock;
import androidx.compose.material3.tokens.TypographyTokensKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.unit.TextUnit;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.google.common.math.IntMath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Typography {
    public final TextStyle bodyLarge;
    public final TextStyle bodyLargeEmphasized;
    public final TextStyle bodyMedium;
    public final TextStyle bodyMediumEmphasized;
    public final TextStyle bodySmall;
    public final TextStyle bodySmallEmphasized;
    public final TextStyle displayLarge;
    public final TextStyle displayLargeEmphasized;
    public final TextStyle displayMedium;
    public final TextStyle displayMediumEmphasized;
    public final TextStyle displaySmall;
    public final TextStyle displaySmallEmphasized;
    public final TextStyle headlineLarge;
    public final TextStyle headlineLargeEmphasized;
    public final TextStyle headlineMedium;
    public final TextStyle headlineMediumEmphasized;
    public final TextStyle headlineSmall;
    public final TextStyle headlineSmallEmphasized;
    public final TextStyle labelLarge;
    public final TextStyle labelLargeEmphasized;
    public final TextStyle labelMedium;
    public final TextStyle labelMediumEmphasized;
    public final TextStyle labelSmall;
    public final TextStyle labelSmallEmphasized;
    public final TextStyle titleLarge;
    public final TextStyle titleLargeEmphasized;
    public final TextStyle titleMedium;
    public final TextStyle titleMediumEmphasized;
    public final TextStyle titleSmall;
    public final TextStyle titleSmallEmphasized;

    /* JADX WARN: Illegal instructions before constructor call */
    public Typography() {
        Lock lock = CardKt.typographyTokens;
        TextStyle textStyle = TypographyTokensKt.DefaultTextStyle;
        lock.getClass();
        FontWeight fontWeight = FontWeight.Normal;
        long sp = IntMath.getSp(57);
        long sp2 = IntMath.getSp(64.0d);
        long sp3 = IntMath.getSp(0.2d);
        IntMath.m898checkArithmeticR2X_6o(sp3);
        long jPack = IntMath.pack(1095216660480L & sp3, -TextUnit.m814getValueimpl(sp3));
        GenericFontFamily genericFontFamily = FontFamily.SansSerif;
        TextStyle textStyleM750copyp1EtxEg$default = TextStyle.m750copyp1EtxEg$default(textStyle, 0L, sp, fontWeight, null, genericFontFamily, null, jPack, sp2, null, null, 16645977);
        lock.getClass();
        TextStyle textStyleM750copyp1EtxEg$default2 = TextStyle.m750copyp1EtxEg$default(textStyle, 0L, IntMath.getSp(45), fontWeight, null, genericFontFamily, null, IntMath.getSp(0.0d), IntMath.getSp(52.0d), null, null, 16645977);
        lock.getClass();
        TextStyle textStyleM750copyp1EtxEg$default3 = TextStyle.m750copyp1EtxEg$default(textStyle, 0L, IntMath.getSp(36), fontWeight, null, genericFontFamily, null, IntMath.getSp(0.0d), IntMath.getSp(44.0d), null, null, 16645977);
        lock.getClass();
        TextStyle textStyleM750copyp1EtxEg$default4 = TextStyle.m750copyp1EtxEg$default(textStyle, 0L, IntMath.getSp(32), fontWeight, null, genericFontFamily, null, IntMath.getSp(0.0d), IntMath.getSp(40.0d), null, null, 16645977);
        lock.getClass();
        TextStyle textStyleM750copyp1EtxEg$default5 = TextStyle.m750copyp1EtxEg$default(textStyle, 0L, IntMath.getSp(28), fontWeight, null, genericFontFamily, null, IntMath.getSp(0.0d), IntMath.getSp(36.0d), null, null, 16645977);
        lock.getClass();
        TextStyle textStyleM750copyp1EtxEg$default6 = TextStyle.m750copyp1EtxEg$default(textStyle, 0L, IntMath.getSp(24), fontWeight, null, genericFontFamily, null, IntMath.getSp(0.0d), IntMath.getSp(32.0d), null, null, 16645977);
        lock.getClass();
        TextStyle textStyleM750copyp1EtxEg$default7 = TextStyle.m750copyp1EtxEg$default(textStyle, 0L, IntMath.getSp(22), fontWeight, null, genericFontFamily, null, IntMath.getSp(0.0d), IntMath.getSp(28.0d), null, null, 16645977);
        lock.getClass();
        FontWeight fontWeight2 = FontWeight.Medium;
        TextStyle textStyleM750copyp1EtxEg$default8 = TextStyle.m750copyp1EtxEg$default(textStyle, 0L, IntMath.getSp(16), fontWeight2, null, genericFontFamily, null, IntMath.getSp(0.2d), IntMath.getSp(24.0d), null, null, 16645977);
        lock.getClass();
        TextStyle textStyleM750copyp1EtxEg$default9 = TextStyle.m750copyp1EtxEg$default(textStyle, 0L, IntMath.getSp(14), fontWeight2, null, genericFontFamily, null, IntMath.getSp(0.1d), IntMath.getSp(20.0d), null, null, 16645977);
        lock.getClass();
        TextStyle textStyleM750copyp1EtxEg$default10 = TextStyle.m750copyp1EtxEg$default(textStyle, 0L, IntMath.getSp(16), fontWeight, null, genericFontFamily, null, IntMath.getSp(0.5d), IntMath.getSp(24.0d), null, null, 16645977);
        lock.getClass();
        TextStyle textStyleM750copyp1EtxEg$default11 = TextStyle.m750copyp1EtxEg$default(textStyle, 0L, IntMath.getSp(14), fontWeight, null, genericFontFamily, null, IntMath.getSp(0.2d), IntMath.getSp(20.0d), null, null, 16645977);
        lock.getClass();
        TextStyle textStyleM750copyp1EtxEg$default12 = TextStyle.m750copyp1EtxEg$default(textStyle, 0L, IntMath.getSp(12), fontWeight, null, genericFontFamily, null, IntMath.getSp(0.4d), IntMath.getSp(16.0d), null, null, 16645977);
        lock.getClass();
        TextStyle textStyleM750copyp1EtxEg$default13 = TextStyle.m750copyp1EtxEg$default(textStyle, 0L, IntMath.getSp(14), fontWeight2, null, genericFontFamily, null, IntMath.getSp(0.1d), IntMath.getSp(20.0d), null, null, 16645977);
        lock.getClass();
        TextStyle textStyleM750copyp1EtxEg$default14 = TextStyle.m750copyp1EtxEg$default(textStyle, 0L, IntMath.getSp(12), fontWeight2, null, genericFontFamily, null, IntMath.getSp(0.5d), IntMath.getSp(16.0d), null, null, 16645977);
        lock.getClass();
        TextStyle textStyleM750copyp1EtxEg$default15 = TextStyle.m750copyp1EtxEg$default(textStyle, 0L, IntMath.getSp(11), fontWeight2, null, genericFontFamily, null, IntMath.getSp(0.5d), IntMath.getSp(16.0d), null, null, 16645977);
        this(textStyleM750copyp1EtxEg$default, textStyleM750copyp1EtxEg$default2, textStyleM750copyp1EtxEg$default3, textStyleM750copyp1EtxEg$default4, textStyleM750copyp1EtxEg$default5, textStyleM750copyp1EtxEg$default6, textStyleM750copyp1EtxEg$default7, textStyleM750copyp1EtxEg$default8, textStyleM750copyp1EtxEg$default9, textStyleM750copyp1EtxEg$default10, textStyleM750copyp1EtxEg$default11, textStyleM750copyp1EtxEg$default12, textStyleM750copyp1EtxEg$default13, textStyleM750copyp1EtxEg$default14, textStyleM750copyp1EtxEg$default15, textStyleM750copyp1EtxEg$default, textStyleM750copyp1EtxEg$default2, textStyleM750copyp1EtxEg$default3, textStyleM750copyp1EtxEg$default4, textStyleM750copyp1EtxEg$default5, textStyleM750copyp1EtxEg$default6, textStyleM750copyp1EtxEg$default7, textStyleM750copyp1EtxEg$default8, textStyleM750copyp1EtxEg$default9, textStyleM750copyp1EtxEg$default10, textStyleM750copyp1EtxEg$default11, textStyleM750copyp1EtxEg$default12, textStyleM750copyp1EtxEg$default13, textStyleM750copyp1EtxEg$default14, textStyleM750copyp1EtxEg$default15);
    }

    public final Typography copy(TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, TextStyle textStyle14, TextStyle textStyle15) {
        return new Typography(textStyle, textStyle2, textStyle3, textStyle4, textStyle5, textStyle6, textStyle7, textStyle8, textStyle9, textStyle10, textStyle11, textStyle12, textStyle13, textStyle14, textStyle15, this.displayLargeEmphasized, this.displayMediumEmphasized, this.displaySmallEmphasized, this.headlineLargeEmphasized, this.headlineMediumEmphasized, this.headlineSmallEmphasized, this.titleLargeEmphasized, this.titleMediumEmphasized, this.titleSmallEmphasized, this.bodyLargeEmphasized, this.bodyMediumEmphasized, this.bodySmallEmphasized, this.labelLargeEmphasized, this.labelMediumEmphasized, this.labelSmallEmphasized);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Typography)) {
            return false;
        }
        Typography typography = (Typography) obj;
        return Intrinsics.areEqual(this.displayLarge, typography.displayLarge) && Intrinsics.areEqual(this.displayMedium, typography.displayMedium) && Intrinsics.areEqual(this.displaySmall, typography.displaySmall) && Intrinsics.areEqual(this.headlineLarge, typography.headlineLarge) && Intrinsics.areEqual(this.headlineMedium, typography.headlineMedium) && Intrinsics.areEqual(this.headlineSmall, typography.headlineSmall) && Intrinsics.areEqual(this.titleLarge, typography.titleLarge) && Intrinsics.areEqual(this.titleMedium, typography.titleMedium) && Intrinsics.areEqual(this.titleSmall, typography.titleSmall) && Intrinsics.areEqual(this.bodyLarge, typography.bodyLarge) && Intrinsics.areEqual(this.bodyMedium, typography.bodyMedium) && Intrinsics.areEqual(this.bodySmall, typography.bodySmall) && Intrinsics.areEqual(this.labelLarge, typography.labelLarge) && Intrinsics.areEqual(this.labelMedium, typography.labelMedium) && Intrinsics.areEqual(this.labelSmall, typography.labelSmall) && Intrinsics.areEqual(this.displayLargeEmphasized, typography.displayLargeEmphasized) && Intrinsics.areEqual(this.displayMediumEmphasized, typography.displayMediumEmphasized) && Intrinsics.areEqual(this.displaySmallEmphasized, typography.displaySmallEmphasized) && Intrinsics.areEqual(this.headlineLargeEmphasized, typography.headlineLargeEmphasized) && Intrinsics.areEqual(this.headlineMediumEmphasized, typography.headlineMediumEmphasized) && Intrinsics.areEqual(this.headlineSmallEmphasized, typography.headlineSmallEmphasized) && Intrinsics.areEqual(this.titleLargeEmphasized, typography.titleLargeEmphasized) && Intrinsics.areEqual(this.titleMediumEmphasized, typography.titleMediumEmphasized) && Intrinsics.areEqual(this.titleSmallEmphasized, typography.titleSmallEmphasized) && Intrinsics.areEqual(this.bodyLargeEmphasized, typography.bodyLargeEmphasized) && Intrinsics.areEqual(this.bodyMediumEmphasized, typography.bodyMediumEmphasized) && Intrinsics.areEqual(this.bodySmallEmphasized, typography.bodySmallEmphasized) && Intrinsics.areEqual(this.labelLargeEmphasized, typography.labelLargeEmphasized) && Intrinsics.areEqual(this.labelMediumEmphasized, typography.labelMediumEmphasized) && Intrinsics.areEqual(this.labelSmallEmphasized, typography.labelSmallEmphasized);
    }

    public final int hashCode() {
        return this.labelSmallEmphasized.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.labelMediumEmphasized, Fragment$5$$ExternalSyntheticOutline0.m(this.labelLargeEmphasized, Fragment$5$$ExternalSyntheticOutline0.m(this.bodySmallEmphasized, Fragment$5$$ExternalSyntheticOutline0.m(this.bodyMediumEmphasized, Fragment$5$$ExternalSyntheticOutline0.m(this.bodyLargeEmphasized, Fragment$5$$ExternalSyntheticOutline0.m(this.titleSmallEmphasized, Fragment$5$$ExternalSyntheticOutline0.m(this.titleMediumEmphasized, Fragment$5$$ExternalSyntheticOutline0.m(this.titleLargeEmphasized, Fragment$5$$ExternalSyntheticOutline0.m(this.headlineSmallEmphasized, Fragment$5$$ExternalSyntheticOutline0.m(this.headlineMediumEmphasized, Fragment$5$$ExternalSyntheticOutline0.m(this.headlineLargeEmphasized, Fragment$5$$ExternalSyntheticOutline0.m(this.displaySmallEmphasized, Fragment$5$$ExternalSyntheticOutline0.m(this.displayMediumEmphasized, Fragment$5$$ExternalSyntheticOutline0.m(this.displayLargeEmphasized, Fragment$5$$ExternalSyntheticOutline0.m(this.labelSmall, Fragment$5$$ExternalSyntheticOutline0.m(this.labelMedium, Fragment$5$$ExternalSyntheticOutline0.m(this.labelLarge, Fragment$5$$ExternalSyntheticOutline0.m(this.bodySmall, Fragment$5$$ExternalSyntheticOutline0.m(this.bodyMedium, Fragment$5$$ExternalSyntheticOutline0.m(this.bodyLarge, Fragment$5$$ExternalSyntheticOutline0.m(this.titleSmall, Fragment$5$$ExternalSyntheticOutline0.m(this.titleMedium, Fragment$5$$ExternalSyntheticOutline0.m(this.titleLarge, Fragment$5$$ExternalSyntheticOutline0.m(this.headlineSmall, Fragment$5$$ExternalSyntheticOutline0.m(this.headlineMedium, Fragment$5$$ExternalSyntheticOutline0.m(this.headlineLarge, Fragment$5$$ExternalSyntheticOutline0.m(this.displaySmall, Fragment$5$$ExternalSyntheticOutline0.m(this.displayMedium, this.displayLarge.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "Typography(displayLarge=" + this.displayLarge + ", displayMedium=" + this.displayMedium + ",displaySmall=" + this.displaySmall + ", headlineLarge=" + this.headlineLarge + ", headlineMedium=" + this.headlineMedium + ", headlineSmall=" + this.headlineSmall + ", titleLarge=" + this.titleLarge + ", titleMedium=" + this.titleMedium + ", titleSmall=" + this.titleSmall + ", bodyLarge=" + this.bodyLarge + ", bodyMedium=" + this.bodyMedium + ", bodySmall=" + this.bodySmall + ", labelLarge=" + this.labelLarge + ", labelMedium=" + this.labelMedium + ", labelSmall=" + this.labelSmall + ", displayLargeEmphasized=" + this.displayLargeEmphasized + ", displayMediumEmphasized=" + this.displayMediumEmphasized + ", displaySmallEmphasized=" + this.displaySmallEmphasized + ", headlineLargeEmphasized=" + this.headlineLargeEmphasized + ", headlineMediumEmphasized=" + this.headlineMediumEmphasized + ", headlineSmallEmphasized=" + this.headlineSmallEmphasized + ", titleLargeEmphasized=" + this.titleLargeEmphasized + ", titleMediumEmphasized=" + this.titleMediumEmphasized + ", titleSmallEmphasized=" + this.titleSmallEmphasized + ", bodyLargeEmphasized=" + this.bodyLargeEmphasized + ", bodyMediumEmphasized=" + this.bodyMediumEmphasized + ", bodySmallEmphasized=" + this.bodySmallEmphasized + ", labelLargeEmphasized=" + this.labelLargeEmphasized + ", labelMediumEmphasized=" + this.labelMediumEmphasized + ", labelSmallEmphasized=" + this.labelSmallEmphasized + ")";
    }

    public Typography(TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, TextStyle textStyle14, TextStyle textStyle15, TextStyle textStyle16, TextStyle textStyle17, TextStyle textStyle18, TextStyle textStyle19, TextStyle textStyle20, TextStyle textStyle21, TextStyle textStyle22, TextStyle textStyle23, TextStyle textStyle24, TextStyle textStyle25, TextStyle textStyle26, TextStyle textStyle27, TextStyle textStyle28, TextStyle textStyle29, TextStyle textStyle30) {
        this.displayLarge = textStyle;
        this.displayMedium = textStyle2;
        this.displaySmall = textStyle3;
        this.headlineLarge = textStyle4;
        this.headlineMedium = textStyle5;
        this.headlineSmall = textStyle6;
        this.titleLarge = textStyle7;
        this.titleMedium = textStyle8;
        this.titleSmall = textStyle9;
        this.bodyLarge = textStyle10;
        this.bodyMedium = textStyle11;
        this.bodySmall = textStyle12;
        this.labelLarge = textStyle13;
        this.labelMedium = textStyle14;
        this.labelSmall = textStyle15;
        this.displayLargeEmphasized = textStyle16;
        this.displayMediumEmphasized = textStyle17;
        this.displaySmallEmphasized = textStyle18;
        this.headlineLargeEmphasized = textStyle19;
        this.headlineMediumEmphasized = textStyle20;
        this.headlineSmallEmphasized = textStyle21;
        this.titleLargeEmphasized = textStyle22;
        this.titleMediumEmphasized = textStyle23;
        this.titleSmallEmphasized = textStyle24;
        this.bodyLargeEmphasized = textStyle25;
        this.bodyMediumEmphasized = textStyle26;
        this.bodySmallEmphasized = textStyle27;
        this.labelLargeEmphasized = textStyle28;
        this.labelMediumEmphasized = textStyle29;
        this.labelSmallEmphasized = textStyle30;
    }
}
