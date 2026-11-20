package com.metrolist.music.ui.component;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SheetDefaultsKt;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.platform.CompositionLocalsKt;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import com.metrolist.music.db.entities.CachedItem$$ExternalSyntheticLambda0;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BottomSheetPageKt {
    public static final StaticProvidableCompositionLocal LocalBottomSheetPageState = new StaticProvidableCompositionLocal(new CachedItem$$ExternalSyntheticLambda0((byte) 12), (byte) 1);

    /* JADX INFO: renamed from: BottomSheetPage-FNF3uiM, reason: not valid java name */
    public static final void m1455BottomSheetPageFNF3uiM(Modifier modifier, BottomSheetPageState bottomSheetPageState, long j, Composer composer, int i) {
        GapComposer gapComposer;
        long j2;
        long j3;
        int i2;
        bottomSheetPageState.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1186201904);
        byte b = 4;
        int i3 = i | (gapComposer2.changed(modifier) ? 4 : 2) | (gapComposer2.changed(bottomSheetPageState) ? 32 : 16) | 128;
        if (gapComposer2.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
            gapComposer2.startDefaults();
            if ((i & 1) == 0 || gapComposer2.getDefaultsInvalid()) {
                j3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface;
                i2 = i3 & (-897);
            } else {
                gapComposer2.skipToGroupEnd();
                i2 = i3 & (-897);
                j3 = j;
            }
            gapComposer2.endDefaults();
            FocusOwner focusOwner = (FocusOwner) gapComposer2.consume(CompositionLocalsKt.LocalFocusManager);
            SheetState sheetStateRememberBottomSheetState = SheetDefaultsKt.rememberBottomSheetState(gapComposer2);
            boolean zBooleanValue = ((Boolean) bottomSheetPageState.isVisible$delegate.getValue()).booleanValue();
            long j4 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface;
            Modifier modifierThen = modifier.then(SizeKt.FillWholeMaxHeight);
            boolean zChangedInstance = gapComposer2.changedInstance(focusOwner) | ((i2 & 112) == 32);
            Object objRememberedValue = gapComposer2.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new ComponentRegistry$Builder$$ExternalSyntheticLambda2(focusOwner, bottomSheetPageState, (byte) 12);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            long j5 = j3;
            gapComposer = gapComposer2;
            BottomSheetMenuKt.m1453AnimatedBottomSheetockOeQw(zBooleanValue, (Function0) objRememberedValue, modifierThen, sheetStateRememberBottomSheetState, CropImageView.DEFAULT_ASPECT_RATIO, null, j5, j4, 0L, DialogKt.lambda$632719135, null, null, Expect_jvmKt.rememberComposableLambda(-1660079668, new ListItemKt$$ExternalSyntheticLambda17(b, bottomSheetPageState), gapComposer2), gapComposer, 0);
            j2 = j5;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            j2 = j;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda4(modifier, bottomSheetPageState, j2, i, (byte) 7);
        }
    }
}
