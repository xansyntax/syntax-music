package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerElement;
import androidx.compose.ui.graphics.LayerOutsets;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda84;
import com.metrolist.music.utils.DataStoreKt$dataStore$2$2;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.StringValuesKt$$ExternalSyntheticLambda1;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldDefaults {
    public static final TextFieldDefaults INSTANCE$1 = new TextFieldDefaults();
    public static final /* synthetic */ TextFieldDefaults $$INSTANCE = new TextFieldDefaults();
    public static final TextFieldDefaults INSTANCE$2 = new TextFieldDefaults();
    public static final TextFieldDefaults INSTANCE$3 = new TextFieldDefaults();
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();

    public static TextFieldColors colors(Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        return defaultTextFieldColors$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme, (TextSelectionColors) gapComposer.consume(TextSelectionColorsKt.LocalTextSelectionColors));
    }

    /* JADX INFO: renamed from: colors-0hiis_0, reason: not valid java name */
    public static TextFieldColors m347colors0hiis_0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, TextSelectionColors textSelectionColors, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, Composer composer, int i, int i2, int i3) {
        long jColor = (i2 & 1) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j;
        long jColor2 = (i2 & 2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j2;
        long jColor3 = (i2 & 4) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j3;
        long jColor4 = (i2 & 8) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j4;
        long jColor5 = (i2 & 16) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j5;
        long jColor6 = (i2 & 32) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j6;
        long jColor7 = (i2 & 64) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : 0L;
        long jColor8 = (i2 & 128) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : 0L;
        long jColor9 = (i2 & 256) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j7;
        long jColor10 = (i2 & 512) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j8;
        TextSelectionColors textSelectionColors2 = (i2 & 1024) != 0 ? null : textSelectionColors;
        long jColor11 = (i2 & 2048) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j9;
        long jColor12 = (i2 & 4096) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j10;
        long jColor13 = (i2 & 8192) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j11;
        long jColor14 = (i2 & 16384) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j12;
        long jColor15 = (32768 & i2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j13;
        long jColor16 = (65536 & i2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j14;
        long jColor17 = (131072 & i2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j15;
        long jColor18 = (262144 & i2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j16;
        long jColor19 = (524288 & i2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j17;
        long jColor20 = (1048576 & i2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j18;
        long jColor21 = (2097152 & i2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j19;
        long jColor22 = (4194304 & i2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j20;
        long jColor23 = (8388608 & i2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j21;
        long jColor24 = (16777216 & i2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j22;
        long jColor25 = (33554432 & i2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j23;
        long jColor26 = (67108864 & i2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j24;
        long jColor27 = (134217728 & i2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j25;
        long jColor28 = (268435456 & i2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j26;
        long jColor29 = (536870912 & i2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j27;
        long jColor30 = (i2 & 1073741824) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j28;
        Rgb rgb = ColorSpaces.Unspecified;
        GapComposer gapComposer = (GapComposer) composer;
        return getDefaultOutlinedTextFieldColors(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme, gapComposer).m344copyejIjP34(jColor, jColor2, jColor3, jColor4, jColor5, jColor6, jColor7, jColor8, jColor9, jColor10, textSelectionColors2, jColor11, jColor12, jColor13, jColor14, jColor15, jColor16, jColor17, jColor18, jColor19, jColor20, jColor21, jColor22, jColor23, jColor24, jColor25, jColor26, jColor27, jColor28, jColor29, jColor30, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb), ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb), ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb), ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb), (i3 & 16) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb) : j29, (i3 & 32) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb) : j30, (i3 & 64) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb) : j31, (i3 & 128) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb) : j32, (i3 & 256) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb) : j33, (i3 & 512) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb) : j34, (i3 & 1024) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb) : j35, (i3 & 2048) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb) : j36);
    }

    public static TextFieldColors defaultTextFieldColors$material3(ColorScheme colorScheme, TextSelectionColors textSelectionColors) {
        TextFieldColors textFieldColors = colorScheme.defaultTextFieldColorsCached;
        if (textFieldColors != null) {
            if (Intrinsics.areEqual(textFieldColors.textSelectionColors, textSelectionColors)) {
                return textFieldColors;
            }
            TextFieldColors textFieldColorsM344copyejIjP34 = textFieldColors.m344copyejIjP34(textFieldColors.focusedTextColor, textFieldColors.unfocusedTextColor, textFieldColors.disabledTextColor, textFieldColors.errorTextColor, textFieldColors.focusedContainerColor, textFieldColors.unfocusedContainerColor, textFieldColors.disabledContainerColor, textFieldColors.errorContainerColor, textFieldColors.cursorColor, textFieldColors.errorCursorColor, textSelectionColors, textFieldColors.focusedIndicatorColor, textFieldColors.unfocusedIndicatorColor, textFieldColors.disabledIndicatorColor, textFieldColors.errorIndicatorColor, textFieldColors.focusedLeadingIconColor, textFieldColors.unfocusedLeadingIconColor, textFieldColors.disabledLeadingIconColor, textFieldColors.errorLeadingIconColor, textFieldColors.focusedTrailingIconColor, textFieldColors.unfocusedTrailingIconColor, textFieldColors.disabledTrailingIconColor, textFieldColors.errorTrailingIconColor, textFieldColors.focusedLabelColor, textFieldColors.unfocusedLabelColor, textFieldColors.disabledLabelColor, textFieldColors.errorLabelColor, textFieldColors.focusedPlaceholderColor, textFieldColors.unfocusedPlaceholderColor, textFieldColors.disabledPlaceholderColor, textFieldColors.errorPlaceholderColor, textFieldColors.focusedSupportingTextColor, textFieldColors.unfocusedSupportingTextColor, textFieldColors.disabledSupportingTextColor, textFieldColors.errorSupportingTextColor, textFieldColors.focusedPrefixColor, textFieldColors.unfocusedPrefixColor, textFieldColors.disabledPrefixColor, textFieldColors.errorPrefixColor, textFieldColors.focusedSuffixColor, textFieldColors.unfocusedSuffixColor, textFieldColors.disabledSuffixColor, textFieldColors.errorSuffixColor);
            colorScheme.defaultTextFieldColorsCached = textFieldColorsM344copyejIjP34;
            return textFieldColorsM344copyejIjP34;
        }
        long jM284fromToken_Htp75A = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jM284fromToken_Htp75A2 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jM284fromToken_Htp75A3 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A3), Color.m484getGreenimpl(jM284fromToken_Htp75A3), Color.m482getBlueimpl(jM284fromToken_Htp75A3), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A3));
        long jM284fromToken_Htp75A4 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jM284fromToken_Htp75A5 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 38);
        long jM284fromToken_Htp75A6 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 38);
        long jM284fromToken_Htp75A7 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 38);
        long jM284fromToken_Htp75A8 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 38);
        long jM284fromToken_Htp75A9 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25);
        long jM284fromToken_Htp75A10 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 1);
        long jM284fromToken_Htp75A11 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25);
        long jM284fromToken_Htp75A12 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A13 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor2 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A13), Color.m484getGreenimpl(jM284fromToken_Htp75A13), Color.m482getBlueimpl(jM284fromToken_Htp75A13), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A13));
        long jM284fromToken_Htp75A14 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 1);
        long jM284fromToken_Htp75A15 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A16 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A17 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor3 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A17), Color.m484getGreenimpl(jM284fromToken_Htp75A17), Color.m482getBlueimpl(jM284fromToken_Htp75A17), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A17));
        long jM284fromToken_Htp75A18 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A19 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A20 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A21 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor4 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A21), Color.m484getGreenimpl(jM284fromToken_Htp75A21), Color.m482getBlueimpl(jM284fromToken_Htp75A21), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A21));
        long jM284fromToken_Htp75A22 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 1);
        long jM284fromToken_Htp75A23 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25);
        long jM284fromToken_Htp75A24 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A25 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor5 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A25), Color.m484getGreenimpl(jM284fromToken_Htp75A25), Color.m482getBlueimpl(jM284fromToken_Htp75A25), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A25));
        long jM284fromToken_Htp75A26 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 1);
        long jM284fromToken_Htp75A27 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A28 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A29 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor6 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A29), Color.m484getGreenimpl(jM284fromToken_Htp75A29), Color.m482getBlueimpl(jM284fromToken_Htp75A29), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A29));
        long jM284fromToken_Htp75A30 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A31 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A32 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A33 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor7 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A33), Color.m484getGreenimpl(jM284fromToken_Htp75A33), Color.m482getBlueimpl(jM284fromToken_Htp75A33), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A33));
        long jM284fromToken_Htp75A34 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 1);
        long jM284fromToken_Htp75A35 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A36 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A37 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jColor8 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A37), Color.m484getGreenimpl(jM284fromToken_Htp75A37), Color.m482getBlueimpl(jM284fromToken_Htp75A37), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A37));
        long jM284fromToken_Htp75A38 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A39 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A40 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A41 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        TextFieldColors textFieldColors2 = new TextFieldColors(jM284fromToken_Htp75A, jM284fromToken_Htp75A2, jColor, jM284fromToken_Htp75A4, jM284fromToken_Htp75A5, jM284fromToken_Htp75A6, jM284fromToken_Htp75A7, jM284fromToken_Htp75A8, jM284fromToken_Htp75A9, jM284fromToken_Htp75A10, textSelectionColors, jM284fromToken_Htp75A11, jM284fromToken_Htp75A12, jColor2, jM284fromToken_Htp75A14, jM284fromToken_Htp75A15, jM284fromToken_Htp75A16, jColor3, jM284fromToken_Htp75A18, jM284fromToken_Htp75A19, jM284fromToken_Htp75A20, jColor4, jM284fromToken_Htp75A22, jM284fromToken_Htp75A23, jM284fromToken_Htp75A24, jColor5, jM284fromToken_Htp75A26, jM284fromToken_Htp75A27, jM284fromToken_Htp75A28, jColor6, jM284fromToken_Htp75A30, jM284fromToken_Htp75A31, jM284fromToken_Htp75A32, jColor7, jM284fromToken_Htp75A34, jM284fromToken_Htp75A35, jM284fromToken_Htp75A36, jColor8, jM284fromToken_Htp75A38, jM284fromToken_Htp75A39, jM284fromToken_Htp75A40, ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A41), Color.m484getGreenimpl(jM284fromToken_Htp75A41), Color.m482getBlueimpl(jM284fromToken_Htp75A41), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A41)), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18));
        colorScheme.defaultTextFieldColorsCached = textFieldColors2;
        return textFieldColors2;
    }

    public static TextFieldColors getDefaultOutlinedTextFieldColors(ColorScheme colorScheme, Composer composer) {
        TextFieldColors textFieldColorsM344copyejIjP34 = colorScheme.defaultOutlinedTextFieldColorsCached;
        if (textFieldColorsM344copyejIjP34 == null) {
            GapComposer gapComposer = (GapComposer) composer;
            gapComposer.startReplaceGroup(390452338);
            gapComposer.end(false);
            textFieldColorsM344copyejIjP34 = null;
        } else {
            GapComposer gapComposer2 = (GapComposer) composer;
            gapComposer2.startReplaceGroup(390452339);
            TextSelectionColors textSelectionColors = (TextSelectionColors) gapComposer2.consume(TextSelectionColorsKt.LocalTextSelectionColors);
            if (!Intrinsics.areEqual(textFieldColorsM344copyejIjP34.textSelectionColors, textSelectionColors)) {
                textFieldColorsM344copyejIjP34 = textFieldColorsM344copyejIjP34.m344copyejIjP34(textFieldColorsM344copyejIjP34.focusedTextColor, textFieldColorsM344copyejIjP34.unfocusedTextColor, textFieldColorsM344copyejIjP34.disabledTextColor, textFieldColorsM344copyejIjP34.errorTextColor, textFieldColorsM344copyejIjP34.focusedContainerColor, textFieldColorsM344copyejIjP34.unfocusedContainerColor, textFieldColorsM344copyejIjP34.disabledContainerColor, textFieldColorsM344copyejIjP34.errorContainerColor, textFieldColorsM344copyejIjP34.cursorColor, textFieldColorsM344copyejIjP34.errorCursorColor, textSelectionColors, textFieldColorsM344copyejIjP34.focusedIndicatorColor, textFieldColorsM344copyejIjP34.unfocusedIndicatorColor, textFieldColorsM344copyejIjP34.disabledIndicatorColor, textFieldColorsM344copyejIjP34.errorIndicatorColor, textFieldColorsM344copyejIjP34.focusedLeadingIconColor, textFieldColorsM344copyejIjP34.unfocusedLeadingIconColor, textFieldColorsM344copyejIjP34.disabledLeadingIconColor, textFieldColorsM344copyejIjP34.errorLeadingIconColor, textFieldColorsM344copyejIjP34.focusedTrailingIconColor, textFieldColorsM344copyejIjP34.unfocusedTrailingIconColor, textFieldColorsM344copyejIjP34.disabledTrailingIconColor, textFieldColorsM344copyejIjP34.errorTrailingIconColor, textFieldColorsM344copyejIjP34.focusedLabelColor, textFieldColorsM344copyejIjP34.unfocusedLabelColor, textFieldColorsM344copyejIjP34.disabledLabelColor, textFieldColorsM344copyejIjP34.errorLabelColor, textFieldColorsM344copyejIjP34.focusedPlaceholderColor, textFieldColorsM344copyejIjP34.unfocusedPlaceholderColor, textFieldColorsM344copyejIjP34.disabledPlaceholderColor, textFieldColorsM344copyejIjP34.errorPlaceholderColor, textFieldColorsM344copyejIjP34.focusedSupportingTextColor, textFieldColorsM344copyejIjP34.unfocusedSupportingTextColor, textFieldColorsM344copyejIjP34.disabledSupportingTextColor, textFieldColorsM344copyejIjP34.errorSupportingTextColor, textFieldColorsM344copyejIjP34.focusedPrefixColor, textFieldColorsM344copyejIjP34.unfocusedPrefixColor, textFieldColorsM344copyejIjP34.disabledPrefixColor, textFieldColorsM344copyejIjP34.errorPrefixColor, textFieldColorsM344copyejIjP34.focusedSuffixColor, textFieldColorsM344copyejIjP34.unfocusedSuffixColor, textFieldColorsM344copyejIjP34.disabledSuffixColor, textFieldColorsM344copyejIjP34.errorSuffixColor);
                colorScheme.defaultOutlinedTextFieldColorsCached = textFieldColorsM344copyejIjP34;
            }
            gapComposer2.end(false);
        }
        if (textFieldColorsM344copyejIjP34 != null) {
            GapComposer gapComposer3 = (GapComposer) composer;
            gapComposer3.startReplaceGroup(-1788515437);
            gapComposer3.end(false);
            return textFieldColorsM344copyejIjP34;
        }
        GapComposer gapComposer4 = (GapComposer) composer;
        gapComposer4.startReplaceGroup(-1788321191);
        long jM284fromToken_Htp75A = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jM284fromToken_Htp75A2 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jM284fromToken_Htp75A3 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A3), Color.m484getGreenimpl(jM284fromToken_Htp75A3), Color.m482getBlueimpl(jM284fromToken_Htp75A3), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A3));
        long jM284fromToken_Htp75A4 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jM284fromToken_Htp75A5 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25);
        long jM284fromToken_Htp75A6 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 1);
        TextSelectionColors textSelectionColors2 = (TextSelectionColors) gapComposer4.consume(TextSelectionColorsKt.LocalTextSelectionColors);
        long jM284fromToken_Htp75A7 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25);
        long jM284fromToken_Htp75A8 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 23);
        long jM284fromToken_Htp75A9 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor2 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A9), Color.m484getGreenimpl(jM284fromToken_Htp75A9), Color.m482getBlueimpl(jM284fromToken_Htp75A9), 0.12f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A9));
        long jM284fromToken_Htp75A10 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 1);
        long jM284fromToken_Htp75A11 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A12 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A13 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor3 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A13), Color.m484getGreenimpl(jM284fromToken_Htp75A13), Color.m482getBlueimpl(jM284fromToken_Htp75A13), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A13));
        long jM284fromToken_Htp75A14 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A15 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A16 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A17 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor4 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A17), Color.m484getGreenimpl(jM284fromToken_Htp75A17), Color.m482getBlueimpl(jM284fromToken_Htp75A17), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A17));
        long jM284fromToken_Htp75A18 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 1);
        long jM284fromToken_Htp75A19 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25);
        long jM284fromToken_Htp75A20 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A21 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor5 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A21), Color.m484getGreenimpl(jM284fromToken_Htp75A21), Color.m482getBlueimpl(jM284fromToken_Htp75A21), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A21));
        long jM284fromToken_Htp75A22 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 1);
        long jM284fromToken_Htp75A23 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A24 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A25 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor6 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A25), Color.m484getGreenimpl(jM284fromToken_Htp75A25), Color.m482getBlueimpl(jM284fromToken_Htp75A25), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A25));
        long jM284fromToken_Htp75A26 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A27 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A28 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A29 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
        long jColor7 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A29), Color.m484getGreenimpl(jM284fromToken_Htp75A29), Color.m482getBlueimpl(jM284fromToken_Htp75A29), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A29));
        long jM284fromToken_Htp75A30 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 1);
        long jM284fromToken_Htp75A31 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A32 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A33 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jColor8 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A33), Color.m484getGreenimpl(jM284fromToken_Htp75A33), Color.m482getBlueimpl(jM284fromToken_Htp75A33), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A33));
        long jM284fromToken_Htp75A34 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A35 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A36 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        long jM284fromToken_Htp75A37 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18);
        TextFieldColors textFieldColors = new TextFieldColors(jM284fromToken_Htp75A, jM284fromToken_Htp75A2, jColor, jM284fromToken_Htp75A4, 0L, 0L, 0L, 0L, jM284fromToken_Htp75A5, jM284fromToken_Htp75A6, textSelectionColors2, jM284fromToken_Htp75A7, jM284fromToken_Htp75A8, jColor2, jM284fromToken_Htp75A10, jM284fromToken_Htp75A11, jM284fromToken_Htp75A12, jColor3, jM284fromToken_Htp75A14, jM284fromToken_Htp75A15, jM284fromToken_Htp75A16, jColor4, jM284fromToken_Htp75A18, jM284fromToken_Htp75A19, jM284fromToken_Htp75A20, jColor5, jM284fromToken_Htp75A22, jM284fromToken_Htp75A23, jM284fromToken_Htp75A24, jColor6, jM284fromToken_Htp75A26, jM284fromToken_Htp75A27, jM284fromToken_Htp75A28, jColor7, jM284fromToken_Htp75A30, jM284fromToken_Htp75A31, jM284fromToken_Htp75A32, jColor8, jM284fromToken_Htp75A34, jM284fromToken_Htp75A35, jM284fromToken_Htp75A36, ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A37), Color.m484getGreenimpl(jM284fromToken_Htp75A37), Color.m482getBlueimpl(jM284fromToken_Htp75A37), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A37)), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18));
        colorScheme.defaultOutlinedTextFieldColorsCached = textFieldColors;
        gapComposer4.end(false);
        return textFieldColors;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x005b  */
    /* JADX WARN: Code duplicated, block: B:28:0x005e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0067  */
    /* JADX WARN: Code duplicated, block: B:32:0x006a  */
    /* JADX WARN: Code duplicated, block: B:35:0x0072  */
    /* JADX WARN: Code duplicated, block: B:37:0x0076  */
    /* JADX WARN: Code duplicated, block: B:39:0x007e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0081  */
    /* JADX WARN: Code duplicated, block: B:43:0x0087  */
    /* JADX WARN: Code duplicated, block: B:46:0x008e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0092  */
    /* JADX WARN: Code duplicated, block: B:50:0x009a  */
    /* JADX WARN: Code duplicated, block: B:51:0x009d  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:57:0x00af  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:73:0x00de A[PHI: r0 r7 r8
      0x00de: PHI (r0v19 int) = (r0v14 int), (r0v22 int) binds: [B:82:0x00f3, B:72:0x00dc] A[DONT_GENERATE, DONT_INLINE]
      0x00de: PHI (r7v14 androidx.compose.ui.Modifier) = (r7v10 androidx.compose.ui.Modifier), (r7v17 androidx.compose.ui.Modifier) binds: [B:82:0x00f3, B:72:0x00dc] A[DONT_GENERATE, DONT_INLINE]
      0x00de: PHI (r8v11 float) = (r8v7 float), (r8v12 float) binds: [B:82:0x00f3, B:72:0x00dc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:74:0x00e1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:79:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:86:0x011e  */
    /* JADX WARN: Code duplicated, block: B:88:0x0135  */
    /* JADX WARN: Code duplicated, block: B:91:0x0151  */
    /* JADX WARN: Code duplicated, block: B:93:0x0159  */
    /* JADX WARN: Code duplicated, block: B:95:0x015c  */
    /* JADX WARN: Code duplicated, block: B:97:0x016c  */
    /* JADX WARN: Code duplicated, block: B:99:0x01e1  */
    /* JADX INFO: renamed from: Container-4EFweAY, reason: not valid java name */
    public void m350Container4EFweAY(final boolean z, final InteractionSource interactionSource, Modifier modifier, final TextFieldColors textFieldColors, final Shape shape, float f, float f2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        int i4;
        int i5;
        float f3;
        float f4;
        boolean z2;
        final Modifier modifier3;
        final float f5;
        final float f6;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Modifier modifier4;
        float f7;
        int i6;
        float f8;
        boolean zBooleanValue;
        long jM345indicatorColorXeAY9LY;
        FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs;
        State stateRememberUpdatedState;
        FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs2;
        State stateRememberUpdatedState2;
        float f9;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1035477640);
        int i7 = (gapComposer.changed(z) ? 4 : 2) | i | (gapComposer.changed(false) ? 32 : 16) | (gapComposer.changed(interactionSource) ? 256 : 128);
        int i8 = i2 & 8;
        if (i8 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i7 |= gapComposer.changed(modifier2) ? 2048 : 1024;
            }
            if (gapComposer.changed(textFieldColors)) {
                i3 = 16384;
            } else {
                i3 = 8192;
            }
            int i9 = i7 | i3;
            if (gapComposer.changed(shape)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i5 = i9 | i4;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    f3 = f;
                    int i10 = gapComposer.changed(f3) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
                    i5 |= i10;
                } else {
                    f3 = f;
                }
                i5 |= i10;
            } else {
                f3 = f;
            }
            if ((12582912 & i) == 0) {
                if ((i2 & 128) == 0) {
                    f4 = f2;
                    int i11 = gapComposer.changed(f4) ? 8388608 : 4194304;
                    i5 |= i11;
                } else {
                    f4 = f2;
                }
                i5 |= i11;
            } else {
                f4 = f2;
            }
            if ((38347923 & i5) != 38347922) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (gapComposer.shouldExecute(i5 & 1, z2)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                    if (i8 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i2 & 64) != 0) {
                        i5 &= -3670017;
                        f7 = 2.0f;
                    } else {
                        f7 = f3;
                    }
                    if ((i2 & 128) != 0) {
                        i6 = i5 & (-29360129);
                        f8 = 1.0f;
                    }
                    gapComposer.endDefaults();
                    zBooleanValue = ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(interactionSource, gapComposer, (i6 >> 6) & 14).getValue()).booleanValue();
                    jM345indicatorColorXeAY9LY = textFieldColors.m345indicatorColorXeAY9LY(z, zBooleanValue);
                    finiteAnimationSpecM272valueyDoVZcs = CardKt.m272valueyDoVZcs(4, gapComposer);
                    if (z) {
                        gapComposer.startReplaceGroup(-1674528831);
                        stateRememberUpdatedState = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(jM345indicatorColorXeAY9LY, finiteAnimationSpecM272valueyDoVZcs, null, gapComposer, 0, 12);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-1674448076);
                        stateRememberUpdatedState = Stack.rememberUpdatedState(new Color(jM345indicatorColorXeAY9LY), gapComposer);
                        gapComposer.end(false);
                    }
                    State state = stateRememberUpdatedState;
                    finiteAnimationSpecM272valueyDoVZcs2 = CardKt.m272valueyDoVZcs(1, gapComposer);
                    if (z) {
                        gapComposer.startReplaceGroup(-1674266664);
                        if (zBooleanValue) {
                            f9 = f7;
                        } else {
                            f9 = f8;
                        }
                        stateRememberUpdatedState2 = AnimateAsStateKt.m18animateDpAsStateAjpBEmI(f9, finiteAnimationSpecM272valueyDoVZcs2, null, gapComposer, 0, 12);
                        gapComposer = gapComposer;
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-1674084601);
                        stateRememberUpdatedState2 = Stack.rememberUpdatedState(new Dp(f8), gapComposer);
                        gapComposer.end(false);
                    }
                    MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(ImageKt.m38BorderStrokecXLIe8U(((Color) state.getValue()).value, ((Dp) stateRememberUpdatedState2.getValue()).value), gapComposer);
                    AnimateAsState animateAsStateM17animateColorAsStateeuL9pac = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(textFieldColors.m343containerColorXeAY9LY(z, r14), CardKt.m272valueyDoVZcs(4, gapComposer), null, gapComposer, 0, 12);
                    BorderStroke borderStroke = (BorderStroke) mutableStateRememberUpdatedState.getValue();
                    BoxKt.Box(ClipKt.drawWithCache(ImageKt.m43borderziNgDLE(modifier4, borderStroke.width, borderStroke.brush, shape), new ZIndexNode$$ExternalSyntheticLambda0((Object) shape, (Object) new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new DataStoreKt$dataStore$2$2(animateAsStateM17animateColorAsStateeuL9pac, State.class, "value", "getValue()Ljava/lang/Object;", 0, (byte) 4)), (byte) 18)), gapComposer, 0);
                    modifier3 = modifier4;
                    f5 = f7;
                    f6 = f8;
                } else {
                    gapComposer.skipToGroupEnd();
                    if ((i2 & 64) != 0) {
                        i5 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i5 &= -29360129;
                    }
                    modifier4 = modifier2;
                    f7 = f3;
                }
                i6 = i5;
                f8 = f4;
                gapComposer.endDefaults();
                zBooleanValue = ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(interactionSource, gapComposer, (i6 >> 6) & 14).getValue()).booleanValue();
                jM345indicatorColorXeAY9LY = textFieldColors.m345indicatorColorXeAY9LY(z, zBooleanValue);
                finiteAnimationSpecM272valueyDoVZcs = CardKt.m272valueyDoVZcs(4, gapComposer);
                if (z) {
                    gapComposer.startReplaceGroup(-1674528831);
                    stateRememberUpdatedState = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(jM345indicatorColorXeAY9LY, finiteAnimationSpecM272valueyDoVZcs, null, gapComposer, 0, 12);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-1674448076);
                    stateRememberUpdatedState = Stack.rememberUpdatedState(new Color(jM345indicatorColorXeAY9LY), gapComposer);
                    gapComposer.end(false);
                }
                State state2 = stateRememberUpdatedState;
                finiteAnimationSpecM272valueyDoVZcs2 = CardKt.m272valueyDoVZcs(1, gapComposer);
                if (z) {
                    gapComposer.startReplaceGroup(-1674266664);
                    if (zBooleanValue) {
                        f9 = f7;
                    } else {
                        f9 = f8;
                    }
                    stateRememberUpdatedState2 = AnimateAsStateKt.m18animateDpAsStateAjpBEmI(f9, finiteAnimationSpecM272valueyDoVZcs2, null, gapComposer, 0, 12);
                    gapComposer = gapComposer;
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-1674084601);
                    stateRememberUpdatedState2 = Stack.rememberUpdatedState(new Dp(f8), gapComposer);
                    gapComposer.end(false);
                }
                MutableState mutableStateRememberUpdatedState2 = Stack.rememberUpdatedState(ImageKt.m38BorderStrokecXLIe8U(((Color) state2.getValue()).value, ((Dp) stateRememberUpdatedState2.getValue()).value), gapComposer);
                AnimateAsState animateAsStateM17animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(textFieldColors.m343containerColorXeAY9LY(z, r14), CardKt.m272valueyDoVZcs(4, gapComposer), null, gapComposer, 0, 12);
                BorderStroke borderStroke2 = (BorderStroke) mutableStateRememberUpdatedState2.getValue();
                BoxKt.Box(ClipKt.drawWithCache(ImageKt.m43borderziNgDLE(modifier4, borderStroke2.width, borderStroke2.brush, shape), new ZIndexNode$$ExternalSyntheticLambda0((Object) shape, (Object) new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new DataStoreKt$dataStore$2$2(animateAsStateM17animateColorAsStateeuL9pac2, State.class, "value", "getValue()Ljava/lang/Object;", 0, (byte) 4)), (byte) 18)), gapComposer, 0);
                modifier3 = modifier4;
                f5 = f7;
                f6 = f8;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier2;
                f5 = f3;
                f6 = f4;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        this.f$0.m350Container4EFweAY(z, interactionSource, modifier3, textFieldColors, shape, f5, f6, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i7 |= 3072;
        modifier2 = modifier;
        if (gapComposer.changed(textFieldColors)) {
            i3 = 16384;
        } else {
            i3 = 8192;
        }
        int i12 = i7 | i3;
        if (gapComposer.changed(shape)) {
            i4 = 131072;
        } else {
            i4 = 65536;
        }
        i5 = i12 | i4;
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                f3 = f;
                if (gapComposer.changed(f3)) {
                }
                i5 |= i10;
            } else {
                f3 = f;
            }
            i5 |= i10;
        } else {
            f3 = f;
        }
        if ((12582912 & i) == 0) {
            if ((i2 & 128) == 0) {
                f4 = f2;
                if (gapComposer.changed(f4)) {
                }
                i5 |= i11;
            } else {
                f4 = f2;
            }
            i5 |= i11;
        } else {
            f4 = f2;
        }
        if ((38347923 & i5) != 38347922) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (gapComposer.shouldExecute(i5 & 1, z2)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i2 & 64) != 0) {
                    i5 &= -3670017;
                    f7 = 2.0f;
                } else {
                    f7 = f3;
                }
                if ((i2 & 128) != 0) {
                    i6 = i5 & (-29360129);
                    f8 = 1.0f;
                } else {
                    i6 = i5;
                    f8 = f4;
                }
            } else {
                if (i8 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i2 & 64) != 0) {
                    i5 &= -3670017;
                    f7 = 2.0f;
                } else {
                    f7 = f3;
                }
                if ((i2 & 128) != 0) {
                    i6 = i5 & (-29360129);
                    f8 = 1.0f;
                } else {
                    i6 = i5;
                    f8 = f4;
                }
            }
            gapComposer.endDefaults();
            zBooleanValue = ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(interactionSource, gapComposer, (i6 >> 6) & 14).getValue()).booleanValue();
            jM345indicatorColorXeAY9LY = textFieldColors.m345indicatorColorXeAY9LY(z, zBooleanValue);
            finiteAnimationSpecM272valueyDoVZcs = CardKt.m272valueyDoVZcs(4, gapComposer);
            if (z) {
                gapComposer.startReplaceGroup(-1674528831);
                stateRememberUpdatedState = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(jM345indicatorColorXeAY9LY, finiteAnimationSpecM272valueyDoVZcs, null, gapComposer, 0, 12);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1674448076);
                stateRememberUpdatedState = Stack.rememberUpdatedState(new Color(jM345indicatorColorXeAY9LY), gapComposer);
                gapComposer.end(false);
            }
            State state3 = stateRememberUpdatedState;
            finiteAnimationSpecM272valueyDoVZcs2 = CardKt.m272valueyDoVZcs(1, gapComposer);
            if (z) {
                gapComposer.startReplaceGroup(-1674266664);
                if (zBooleanValue) {
                    f9 = f7;
                } else {
                    f9 = f8;
                }
                stateRememberUpdatedState2 = AnimateAsStateKt.m18animateDpAsStateAjpBEmI(f9, finiteAnimationSpecM272valueyDoVZcs2, null, gapComposer, 0, 12);
                gapComposer = gapComposer;
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1674084601);
                stateRememberUpdatedState2 = Stack.rememberUpdatedState(new Dp(f8), gapComposer);
                gapComposer.end(false);
            }
            MutableState mutableStateRememberUpdatedState3 = Stack.rememberUpdatedState(ImageKt.m38BorderStrokecXLIe8U(((Color) state3.getValue()).value, ((Dp) stateRememberUpdatedState2.getValue()).value), gapComposer);
            AnimateAsState animateAsStateM17animateColorAsStateeuL9pac3 = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(textFieldColors.m343containerColorXeAY9LY(z, r14), CardKt.m272valueyDoVZcs(4, gapComposer), null, gapComposer, 0, 12);
            BorderStroke borderStroke3 = (BorderStroke) mutableStateRememberUpdatedState3.getValue();
            BoxKt.Box(ClipKt.drawWithCache(ImageKt.m43borderziNgDLE(modifier4, borderStroke3.width, borderStroke3.brush, shape), new ZIndexNode$$ExternalSyntheticLambda0((Object) shape, (Object) new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new DataStoreKt$dataStore$2$2(animateAsStateM17animateColorAsStateeuL9pac3, State.class, "value", "getValue()Ljava/lang/Object;", 0, (byte) 4)), (byte) 18)), gapComposer, 0);
            modifier3 = modifier4;
            f5 = f7;
            f6 = f8;
        } else {
            gapComposer.skipToGroupEnd();
            modifier3 = modifier2;
            f5 = f3;
            f6 = f4;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    this.f$0.m350Container4EFweAY(z, interactionSource, modifier3, textFieldColors, shape, f5, f6, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public void DecorationBox(final String str, final Function2 function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, final Function2 function3, final Function2 function4, final Shape shape, final TextFieldColors textFieldColors, PaddingValues paddingValues, Function2 function5, Composer composer, final int i) {
        int i2;
        Function2 function6;
        boolean z3;
        boolean z4;
        InteractionSource interactionSource2;
        GapComposer gapComposer;
        final PaddingValues paddingValues2;
        final Function2 function7;
        PaddingValues paddingValuesImpl;
        int i3;
        Function2 function2RememberComposableLambda;
        ComposableLambdaImpl composableLambdaImpl;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1806980801);
        if ((i & 6) == 0) {
            i2 = (gapComposer2.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            function6 = function2;
            i2 |= gapComposer2.changedInstance(function6) ? 32 : 16;
        } else {
            function6 = function2;
        }
        if ((i & 384) == 0) {
            z3 = z;
            i2 |= gapComposer2.changed(z3) ? 256 : 128;
        } else {
            z3 = z;
        }
        if ((i & 3072) == 0) {
            z4 = z2;
            i2 |= gapComposer2.changed(z4) ? 2048 : 1024;
        } else {
            z4 = z2;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer2.changed(visualTransformation) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            interactionSource2 = interactionSource;
            i2 |= gapComposer2.changed(interactionSource2) ? 131072 : 65536;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((i & 1572864) == 0) {
            i2 |= gapComposer2.changed(false) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((i & 12582912) == 0) {
            i2 |= gapComposer2.changedInstance(function3) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= gapComposer2.changedInstance(function4) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i2 |= gapComposer2.changedInstance(null) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        int i4 = 100663296 | (gapComposer2.changedInstance(null) ? 4 : 2) | (gapComposer2.changedInstance(null) ? 32 : 16) | (gapComposer2.changedInstance(null) ? 256 : 128) | (gapComposer2.changedInstance(null) ? 2048 : 1024) | (gapComposer2.changed(shape) ? 16384 : 8192) | (gapComposer2.changed(textFieldColors) ? 131072 : 65536) | 13107200;
        if (gapComposer2.shouldExecute(i2 & 1, ((i2 & 306783379) == 306783378 && (38347923 & i4) == 38347922) ? false : true)) {
            gapComposer2.startDefaults();
            if ((i & 1) == 0 || gapComposer2.getDefaultsInvalid()) {
                paddingValuesImpl = function3 == null ? new PaddingValuesImpl(16.0f, 16.0f, 16.0f, 16.0f) : new PaddingValuesImpl(16.0f, 8.0f, 16.0f, 8.0f);
                i3 = i4 & (-3670017);
                function2RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(417908150, new PlayerKt$$ExternalSyntheticLambda84((byte) 2, (Object) interactionSource2, (Object) textFieldColors, (Object) shape, z3), gapComposer2);
            } else {
                gapComposer2.skipToGroupEnd();
                i3 = i4 & (-3670017);
                paddingValuesImpl = paddingValues;
                function2RememberComposableLambda = function5;
                i2 = i2;
            }
            gapComposer2.endDefaults();
            boolean z5 = ((i2 & 14) == 4) | ((i2 & 57344) == 16384);
            Object objRememberedValue = gapComposer2.rememberedValue();
            if (z5 || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = visualTransformation.filter(new AnnotatedString(str));
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            String str2 = ((TransformedText) objRememberedValue).text.text;
            TextFieldLabelPosition$Inside textFieldLabelPosition$Inside = new TextFieldLabelPosition$Inside();
            if (function3 == null) {
                gapComposer2.startReplaceGroup(-1353189719);
                gapComposer2.end(false);
                composableLambdaImpl = null;
            } else {
                gapComposer2.startReplaceGroup(-1353189718);
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(1243762560, new TextFieldDefaults$$ExternalSyntheticLambda1(function3, (byte) 0), gapComposer2);
                gapComposer2.end(false);
                composableLambdaImpl = composableLambdaImplRememberComposableLambda;
            }
            int i5 = i2 >> 12;
            int i6 = i3 << 18;
            int i7 = (i2 & 112) | (57344 & i5) | (i5 & 458752) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6) | (i6 & 1879048192);
            int i8 = ((i2 >> 9) & 14) | ((i2 >> 3) & 112) | (i5 & 896) | ((i2 >> 6) & 7168) | (458752 & i3) | 1572864;
            gapComposer = gapComposer2;
            PaddingValues paddingValues3 = paddingValuesImpl;
            Icons$Filled.CommonDecorationBox(str2, function6, textFieldLabelPosition$Inside, composableLambdaImpl, function4, null, null, null, z4, z, interactionSource, paddingValues3, textFieldColors, function2RememberComposableLambda, gapComposer, i7, i8);
            paddingValues2 = paddingValues3;
            function7 = function2RememberComposableLambda;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            paddingValues2 = paddingValues;
            function7 = function5;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextFieldDefaults$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    this.f$0.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, function3, function4, shape, textFieldColors, paddingValues2, function7, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: DragHandle-lgZ2HuY, reason: not valid java name */
    public void m351DragHandlelgZ2HuY(Modifier modifier, float f, float f2, Shape shape, long j, Composer composer, final int i) {
        GapComposer gapComposer;
        final Modifier modifier2;
        final float f3;
        final float f4;
        final Shape shape2;
        final long j2;
        Modifier modifier3;
        final float f5;
        Shape shape3;
        long j3;
        final float f6;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-1364277227);
        int i2 = i | 9366;
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 9363) != 9362)) {
            gapComposer2.startDefaults();
            if ((i & 1) == 0 || gapComposer2.getDefaultsInvalid()) {
                RoundedCornerShape roundedCornerShape = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes.extraLarge;
                long value = ColorSchemeKt.getValue(18, gapComposer2);
                modifier3 = Modifier.Companion.$$INSTANCE;
                f5 = 32.0f;
                shape3 = roundedCornerShape;
                j3 = value;
                f6 = 4.0f;
            } else {
                gapComposer2.skipToGroupEnd();
                modifier3 = modifier;
                f5 = f;
                f6 = f2;
                shape3 = shape;
                j3 = j;
            }
            gapComposer2.endDefaults();
            String strM373getString2EP1pXo = Icons$Filled.m373getString2EP1pXo(R.string.m3c_bottom_sheet_drag_handle_description, gapComposer2);
            int i3 = SheetDefaultsKt.$r8$clinit;
            Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(modifier3, CropImageView.DEFAULT_ASPECT_RATIO, 22.0f, 1);
            boolean zChanged = gapComposer2.changed(strM373getString2EP1pXo);
            Object objRememberedValue = gapComposer2.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new IconKt$$ExternalSyntheticLambda1(strM373getString2EP1pXo, (byte) 3);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            gapComposer = gapComposer2;
            SurfaceKt.m337SurfaceT9BRK9s(SemanticsModifierKt.semantics(modifierM137paddingVpY3zN4$default, false, (Function1) objRememberedValue), shape3, j3, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(-1039573072, new Function2() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Composer composer2 = (Composer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    GapComposer gapComposer3 = (GapComposer) composer2;
                    if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        BoxKt.Box(SizeKt.m152sizeVpY3zN4(Modifier.Companion.$$INSTANCE, f5, f6), gapComposer3, 0);
                    } else {
                        gapComposer3.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer2), gapComposer, 12582912, 120);
            f4 = f6;
            modifier2 = modifier3;
            f3 = f5;
            shape2 = shape3;
            j2 = j3;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            f3 = f;
            f4 = f2;
            shape2 = shape;
            j2 = j;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(modifier2, f3, f4, shape2, j2, i) { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda2
                public final /* synthetic */ Modifier f$1;
                public final /* synthetic */ float f$2;
                public final /* synthetic */ float f$3;
                public final /* synthetic */ Shape f$4;
                public final /* synthetic */ long f$5;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(196609);
                    this.f$0.m351DragHandlelgZ2HuY(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public void TrailingIcon(boolean z, Modifier modifier, Composer composer, int i) {
        Modifier modifier2;
        Modifier.Companion companion;
        Modifier modifierThen;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1732824199);
        int i2 = i | (gapComposer.changed(z) ? 4 : 2) | 48;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            ImageVector imageVectorBuild = Icons$Filled._arrowDropDown;
            if (imageVectorBuild == null) {
                ImageVector.Builder builder = new ImageVector.Builder("Filled.ArrowDropDown", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 224);
                SolidColor solidColor = new SolidColor(-72057594037927936L);
                ArrayList arrayList = new ArrayList(32);
                arrayList.add(new PathNode.MoveTo(7.0f, 10.0f));
                arrayList.add(new PathNode.RelativeLineTo(5.0f, 5.0f));
                arrayList.add(new PathNode.RelativeLineTo(5.0f, -5.0f));
                arrayList.add(PathNode.Close.INSTANCE);
                ImageVector.Builder.m577addPathoIyEayM$default(builder, arrayList, solidColor);
                imageVectorBuild = builder.build();
                Icons$Filled._arrowDropDown = imageVectorBuild;
            }
            ImageVector imageVector = imageVectorBuild;
            float f = z ? 180.0f : 0.0f;
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            if (f == CropImageView.DEFAULT_ASPECT_RATIO) {
                companion = companion2;
                modifierThen = companion;
            } else {
                companion = companion2;
                modifierThen = companion2.then(new GraphicsLayerElement((1048319 & 1) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 2) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 4) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 32) != 0 ? 0.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 256) != 0 ? 0.0f : f, ColorKt.TransformOrigin(0.5f, 0.5f), (1048319 & 2048) != 0 ? ColorKt.RectangleShape : null, (1048319 & 4096) != 0 ? false : false, LayerOutsets.Zero));
            }
            IconKt.m291Iconww6aTOc(imageVector, (String) null, modifierThen, 0L, gapComposer, 48, 8);
            modifier2 = companion;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new StringValuesKt$$ExternalSyntheticLambda1(this, z, modifier2, i, (byte) 1);
        }
    }

    public static TextFieldColors colors(int i, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        return getDefaultOutlinedTextFieldColors(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme, gapComposer);
    }

    /* JADX INFO: renamed from: colors-0hiis_0, reason: not valid java name */
    public static TextFieldColors m348colors0hiis_0(long j, long j2, long j3, long j4, Composer composer, int i) {
        Rgb rgb = ColorSpaces.Unspecified;
        long jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor2 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor3 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor4 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor5 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor6 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor7 = (i & 256) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb) : j;
        long jColor8 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor9 = (i & 16384) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb) : j4;
        long jColor10 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor11 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor12 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor13 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor14 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor15 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor16 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor17 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor18 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor19 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor20 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor21 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor22 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor23 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor24 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor25 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor26 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor27 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor28 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor29 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor30 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor31 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor32 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor33 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor34 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor35 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor36 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        long jColor37 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        GapComposer gapComposer = (GapComposer) composer;
        return defaultTextFieldColors$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme, (TextSelectionColors) gapComposer.consume(TextSelectionColorsKt.LocalTextSelectionColors)).m344copyejIjP34(jColor, jColor2, jColor3, jColor4, 0L, 0L, jColor5, jColor6, jColor7, jColor8, null, j2, j3, 0L, jColor9, jColor10, jColor11, jColor12, jColor13, jColor14, jColor15, jColor16, jColor17, jColor18, jColor19, jColor20, jColor21, jColor22, jColor23, jColor24, jColor25, jColor26, jColor27, jColor28, jColor29, jColor30, jColor31, jColor32, jColor33, jColor34, jColor35, jColor36, jColor37);
    }

    /* JADX INFO: renamed from: Container-4EFweAY, reason: not valid java name */
    public void m349Container4EFweAY(boolean z, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-818661242);
        int i2 = i | (gapComposer.changed(z) ? 4 : 2) | (gapComposer.changed(false) ? 32 : 16) | (gapComposer.changed(interactionSource) ? 256 : 128) | (gapComposer.changed(textFieldColors) ? 16384 : 8192) | (gapComposer.changed(shape) ? 131072 : 65536);
        if (gapComposer.shouldExecute(i2 & 1, (38347923 & i2) != 38347922)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            BoxKt.Box(ClipKt.drawWithCache(Modifier.Companion.$$INSTANCE, new ZIndexNode$$ExternalSyntheticLambda0((Object) shape, (Object) new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new DataStoreKt$dataStore$2$2(SingleValueAnimationKt.m17animateColorAsStateeuL9pac(textFieldColors.m343containerColorXeAY9LY(z, ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(interactionSource, gapComposer, (i2 >> 6) & 14).getValue()).booleanValue()), CardKt.m272valueyDoVZcs(4, gapComposer), null, gapComposer, 0, 12), State.class, "value", "getValue()Ljava/lang/Object;", 0, (byte) 5)), (byte) 18)).then(new IndicatorLineElement(z, interactionSource, textFieldColors, shape)), gapComposer, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MenuKt$$ExternalSyntheticLambda0(this, z, interactionSource, textFieldColors, shape, i);
        }
    }

    public void DecorationBox(final String str, final Function2 function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, final Function2 function3, final Function2 function4, final Function2 function5, final Function2 function6, final Function2 function7, final TextFieldColors textFieldColors, PaddingValues paddingValues, final ComposableLambdaImpl composableLambdaImpl, Composer composer, final int i) {
        int i2;
        Function2 function8;
        boolean z3;
        InteractionSource interactionSource2;
        GapComposer gapComposer;
        final PaddingValues paddingValues2;
        PaddingValues paddingValuesImpl;
        int i3;
        ComposableLambdaImpl composableLambdaImplRememberComposableLambda;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-1732281618);
        if ((i & 6) == 0) {
            i2 = (gapComposer2.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            function8 = function2;
            i2 |= gapComposer2.changedInstance(function8) ? 32 : 16;
        } else {
            function8 = function2;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer2.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            z3 = z2;
            i2 |= gapComposer2.changed(z3) ? 2048 : 1024;
        } else {
            z3 = z2;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer2.changed(visualTransformation) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            interactionSource2 = interactionSource;
            i2 |= gapComposer2.changed(interactionSource2) ? 131072 : 65536;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((i & 1572864) == 0) {
            i2 |= gapComposer2.changed(false) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((i & 12582912) == 0) {
            i2 |= gapComposer2.changedInstance(function3) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= gapComposer2.changedInstance(function4) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i2 |= gapComposer2.changedInstance(function5) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        int i4 = 14155776 | (gapComposer2.changedInstance(function6) ? 4 : 2) | (gapComposer2.changedInstance(null) ? 32 : 16) | (gapComposer2.changedInstance(null) ? 256 : 128) | (gapComposer2.changedInstance(function7) ? 2048 : 1024) | (gapComposer2.changed(textFieldColors) ? 16384 : 8192) | 65536;
        int i5 = i2;
        if (gapComposer2.shouldExecute(i5 & 1, ((i2 & 306783379) == 306783378 && (i4 & 4793491) == 4793490) ? false : true)) {
            gapComposer2.startDefaults();
            if ((i & 1) != 0 && !gapComposer2.getDefaultsInvalid()) {
                gapComposer2.skipToGroupEnd();
                i3 = i4 & (-458753);
                paddingValuesImpl = paddingValues;
            } else {
                paddingValuesImpl = new PaddingValuesImpl(16.0f, 16.0f, 16.0f, 16.0f);
                i3 = i4 & (-458753);
            }
            gapComposer2.endDefaults();
            PaddingValues paddingValues3 = paddingValuesImpl;
            boolean z4 = ((i5 & 14) == 4) | ((i5 & 57344) == 16384);
            Object objRememberedValue = gapComposer2.rememberedValue();
            if (z4 || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = visualTransformation.filter(new AnnotatedString(str));
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            String str2 = ((TransformedText) objRememberedValue).text.text;
            TextFieldLabelPosition$Cutout textFieldLabelPosition$Cutout = new TextFieldLabelPosition$Cutout();
            if (function3 == null) {
                gapComposer2.startReplaceGroup(1927010204);
                gapComposer2.end(false);
                composableLambdaImplRememberComposableLambda = null;
            } else {
                gapComposer2.startReplaceGroup(1927010205);
                composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1819131923, new TextFieldDefaults$$ExternalSyntheticLambda1(function3, (byte) 1), gapComposer2);
                gapComposer2.end(false);
            }
            ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImplRememberComposableLambda;
            int i6 = i5 >> 12;
            int i7 = i3 << 18;
            gapComposer = gapComposer2;
            Icons$Filled.CommonDecorationBox(str2, function8, textFieldLabelPosition$Cutout, composableLambdaImpl2, function4, function5, function6, function7, z3, z, interactionSource2, paddingValues3, textFieldColors, composableLambdaImpl, gapComposer, (i5 & 112) | (i6 & 57344) | (i6 & 458752) | (i7 & 3670016) | (i7 & 29360128) | (i7 & 234881024) | (i7 & 1879048192), (i6 & 896) | ((i5 >> 9) & 14) | ((i5 >> 3) & 112) | ((i5 >> 6) & 7168) | ((i3 << 3) & 458752) | 1572864);
            paddingValues2 = paddingValues3;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            paddingValues2 = paddingValues;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    this.f$0.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, function3, function4, function5, function6, function7, textFieldColors, paddingValues2, composableLambdaImpl, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
