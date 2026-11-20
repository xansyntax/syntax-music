package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TopAppBarDefaults {
    public static final PaddingValuesImpl ContentPadding = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
    public static final float TopAppBarExpandedHeight = 64.0f;

    public static TopAppBarColors getDefaultTopAppBarColors$material3(ColorScheme colorScheme) {
        TopAppBarColors topAppBarColors = colorScheme.defaultTopAppBarColorsCached;
        if (topAppBarColors != null) {
            return topAppBarColors;
        }
        TopAppBarColors topAppBarColors2 = new TopAppBarColors(ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 34), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 36), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18), ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 18));
        colorScheme.defaultTopAppBarColorsCached = topAppBarColors2;
        return topAppBarColors2;
    }

    /* JADX INFO: renamed from: topAppBarColors-5tl4gsc, reason: not valid java name */
    public static TopAppBarColors m363topAppBarColors5tl4gsc(long j, long j2, long j3, long j4, long j5, Composer composer, int i) {
        long jColor = (i & 2) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j2;
        long jColor2 = (i & 4) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j3;
        long jColor3 = (i & 8) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j4;
        long jColor4 = (i & 16) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j5;
        long jColor5 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
        TopAppBarColors defaultTopAppBarColors$material3 = getDefaultTopAppBarColors$material3(((MaterialTheme$Values) ((GapComposer) composer).consume(MaterialThemeKt._localMaterialTheme)).colorScheme);
        long j6 = j != 16 ? j : defaultTopAppBarColors$material3.containerColor;
        if (jColor == 16) {
            jColor = defaultTopAppBarColors$material3.scrolledContainerColor;
        }
        long j7 = jColor;
        if (jColor2 == 16) {
            jColor2 = defaultTopAppBarColors$material3.navigationIconContentColor;
        }
        long j8 = jColor2;
        if (jColor3 == 16) {
            jColor3 = defaultTopAppBarColors$material3.titleContentColor;
        }
        long j9 = jColor3;
        if (jColor4 == 16) {
            jColor4 = defaultTopAppBarColors$material3.actionIconContentColor;
        }
        long j10 = jColor4;
        if (jColor5 == 16) {
            jColor5 = defaultTopAppBarColors$material3.subtitleContentColor;
        }
        return new TopAppBarColors(j6, j7, j8, j9, j10, jColor5);
    }
}
