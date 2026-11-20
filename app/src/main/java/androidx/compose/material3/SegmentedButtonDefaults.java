package androidx.compose.material3;

import androidx.compose.animation.ChangeSizeConfig;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionConfig;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.animation.FadeConfig;
import androidx.compose.animation.ScaleConfig;
import androidx.compose.animation.SlideConfig;
import androidx.compose.animation.VeilConfig;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathNode;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda44;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.StringValuesKt$$ExternalSyntheticLambda1;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SegmentedButtonDefaults {
    public static final PaddingValuesImpl ContentPadding;
    public static final SegmentedButtonDefaults INSTANCE = new SegmentedButtonDefaults();

    static {
        PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
        ContentPadding = new PaddingValuesImpl(12.0f, paddingValuesImpl.top, 12.0f, paddingValuesImpl.bottom);
    }

    public static Shape itemShape(int i, GapComposer gapComposer) {
        Shape value = ShapesKt.getValue(6, gapComposer);
        value.getClass();
        RoundedCornerShape roundedCornerShape = (RoundedCornerShape) value;
        if (i == 0) {
            return ShapesKt.start$default(roundedCornerShape);
        }
        return i == 2 ? ShapesKt.end$default(roundedCornerShape) : ColorKt.RectangleShape;
    }

    public final void ActiveIcon(int i, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1273041460);
        if (gapComposer.shouldExecute(i & 1, (i & 3) != 2)) {
            ImageVector imageVectorBuild = Icons$Filled._check;
            if (imageVectorBuild == null) {
                ImageVector.Builder builder = new ImageVector.Builder("Filled.Check", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 224);
                SolidColor solidColor = new SolidColor(-72057594037927936L);
                ArrayList arrayList = new ArrayList(32);
                arrayList.add(new PathNode.MoveTo(9.0f, 16.17f));
                arrayList.add(new PathNode.LineTo(4.83f, 12.0f));
                arrayList.add(new PathNode.RelativeLineTo(-1.42f, 1.41f));
                arrayList.add(new PathNode.LineTo(9.0f, 19.0f));
                arrayList.add(new PathNode.LineTo(21.0f, 7.0f));
                arrayList.add(new PathNode.RelativeLineTo(-1.41f, -1.41f));
                arrayList.add(PathNode.Close.INSTANCE);
                ImageVector.Builder.m577addPathoIyEayM$default(builder, arrayList, solidColor);
                imageVectorBuild = builder.build();
                Icons$Filled._check = imageVectorBuild;
            }
            IconKt.m291Iconww6aTOc(imageVectorBuild, (String) null, SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 18.0f), 0L, gapComposer, 48, 8);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ComposerKt$$ExternalSyntheticLambda0(this, i, (byte) 17);
        }
    }

    public final void Icon(boolean z, Function2 function2, Composer composer, int i) {
        Function2 function3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-657462570);
        int i2 = i | (gapComposer.changed(z) ? 4 : 2) | 432;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            function3 = CardKt.lambda$1863131183;
            gapComposer.startReplaceGroup(-1416240287);
            CrossfadeKt.AnimatedVisibility(z, null, EnterExitTransitionKt.fadeIn$default(CardKt.m272valueyDoVZcs(3, gapComposer), CropImageView.DEFAULT_ASPECT_RATIO, 2).plus(new EnterTransitionImpl(new EnterExitTransitionConfig((FadeConfig) null, (SlideConfig) null, (ChangeSizeConfig) null, new ScaleConfig(CropImageView.DEFAULT_ASPECT_RATIO, ColorKt.TransformOrigin(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f), CardKt.m272valueyDoVZcs(1, gapComposer)), (VeilConfig) null, (LinkedHashMap) null, 119))), ExitTransitionImpl.None, null, Expect_jvmKt.rememberComposableLambda(2059591811, new MainActivity$$ExternalSyntheticLambda44((byte) 4), gapComposer), gapComposer, (i2 & 14) | 196608, 18);
            gapComposer.end(false);
        } else {
            gapComposer.skipToGroupEnd();
            function3 = function2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new StringValuesKt$$ExternalSyntheticLambda1(this, z, function3, i, (byte) 3);
        }
    }
}
