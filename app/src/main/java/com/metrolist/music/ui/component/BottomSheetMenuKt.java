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
public abstract class BottomSheetMenuKt {
    public static final StaticProvidableCompositionLocal LocalMenuState = new StaticProvidableCompositionLocal(new CachedItem$$ExternalSyntheticLambda0((byte) 11), (byte) 1);

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r16v0 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    /* JADX INFO: renamed from: AnimatedBottomSheet-ockOeQw, reason: not valid java name */
    public static final void m1453AnimatedBottomSheetockOeQw(boolean r24, kotlin.jvm.functions.Function0 r25, androidx.compose.ui.Modifier r26, androidx.compose.material3.SheetState r27, float r28, androidx.compose.ui.graphics.Shape r29, long r30, long r32, long r34, androidx.compose.runtime.internal.ComposableLambdaImpl r36, kotlin.jvm.functions.Function2 r37, androidx.compose.material3.ModalBottomSheetProperties r38, androidx.compose.runtime.internal.ComposableLambdaImpl r39, androidx.compose.runtime.Composer r40, int r41) {
        /*
            Method dump skipped, instruction units count: 555
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.component.BottomSheetMenuKt.m1453AnimatedBottomSheetockOeQw(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.SheetState, float, androidx.compose.ui.graphics.Shape, long, long, long, androidx.compose.runtime.internal.ComposableLambdaImpl, kotlin.jvm.functions.Function2, androidx.compose.material3.ModalBottomSheetProperties, androidx.compose.runtime.internal.ComposableLambdaImpl, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: renamed from: BottomSheetMenu-FNF3uiM, reason: not valid java name */
    public static final void m1454BottomSheetMenuFNF3uiM(Modifier modifier, MenuState menuState, long j, Composer composer, int i) {
        GapComposer gapComposer;
        long j2;
        long j3;
        int i2;
        menuState.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-878106736);
        int i3 = i | (gapComposer2.changed(modifier) ? 4 : 2) | (gapComposer2.changed(menuState) ? 32 : 16) | 128;
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
            boolean zBooleanValue = ((Boolean) menuState.isVisible$delegate.getValue()).booleanValue();
            long j4 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface;
            Modifier modifierThen = modifier.then(SizeKt.FillWholeMaxHeight);
            boolean zChangedInstance = gapComposer2.changedInstance(focusOwner) | ((i2 & 112) == 32);
            Object objRememberedValue = gapComposer2.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new ComponentRegistry$Builder$$ExternalSyntheticLambda2(focusOwner, menuState, (byte) 11);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            gapComposer = gapComposer2;
            m1453AnimatedBottomSheetockOeQw(zBooleanValue, (Function0) objRememberedValue, modifierThen, sheetStateRememberBottomSheetState, CropImageView.DEFAULT_ASPECT_RATIO, null, j3, j4, 0L, DialogKt.lambda$2082406657, null, null, Expect_jvmKt.rememberComposableLambda(-1851244428, new ListItemKt$$ExternalSyntheticLambda17((byte) 3, (Object) menuState), gapComposer2), gapComposer, 0);
            j2 = j3;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            j2 = j;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda4(modifier, menuState, j2, i, (byte) 6);
        }
    }
}
