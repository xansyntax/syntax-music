package com.metrolist.music.ui.component;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.Modifier;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda1;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Icon {
    public static final Icon INSTANCE = new Icon();

    public final void Download(Integer num, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(332943692);
        int i2 = (gapComposer.changed(num) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (num != null && num.intValue() == 3) {
                gapComposer.startReplaceGroup(2131310967);
                IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.offline, 0, gapComposer), (String) null, OffsetKt.m139paddingqDBjuR0$default(SizeKt.m151size3ABfNKs(companion, 18.0f), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 2.0f, CropImageView.DEFAULT_ASPECT_RATIO, 11), 0L, gapComposer, 440, 8);
                gapComposer.end(false);
            } else if ((num != null && num.intValue() == 0) || (num != null && num.intValue() == 2)) {
                gapComposer.startReplaceGroup(1646409756);
                DialogKt.m1464CircularProgressIndicatorLxG7B9w(2.0f, 0, 390, 26, 0L, 0L, gapComposer, OffsetKt.m139paddingqDBjuR0$default(SizeKt.m151size3ABfNKs(companion, 16.0f), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 2.0f, CropImageView.DEFAULT_ASPECT_RATIO, 11));
                gapComposer = gapComposer;
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1646609861);
                gapComposer.end(false);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda1(this, num, i, (byte) 9);
        }
    }

    public final void Explicit(int i, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1160236029);
        int i2 = i & 1;
        if (gapComposer.shouldExecute(i2, i2 != 0)) {
            IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.explicit, 0, gapComposer), (String) null, OffsetKt.m139paddingqDBjuR0$default(SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 18.0f), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 2.0f, CropImageView.DEFAULT_ASPECT_RATIO, 11), 0L, gapComposer, 440, 8);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Icon$$ExternalSyntheticLambda0(this, i, (byte) 0);
        }
    }

    public final void Favorite(int i, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-2120850581);
        int i2 = i & 1;
        if (gapComposer.shouldExecute(i2, i2 != 0)) {
            IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.favorite, 0, gapComposer), (String) null, OffsetKt.m139paddingqDBjuR0$default(SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 18.0f), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 2.0f, CropImageView.DEFAULT_ASPECT_RATIO, 11), ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error, gapComposer, 440, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Icon$$ExternalSyntheticLambda0(this, i, (byte) 1);
        }
    }

    public final void Library(int i, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1257607698);
        int i2 = i & 1;
        if (gapComposer.shouldExecute(i2, i2 != 0)) {
            IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.library_add_check, 0, gapComposer), (String) null, OffsetKt.m139paddingqDBjuR0$default(SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 18.0f), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 2.0f, CropImageView.DEFAULT_ASPECT_RATIO, 11), 0L, gapComposer, 440, 8);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Icon$$ExternalSyntheticLambda0(this, i, (byte) 2);
        }
    }
}
