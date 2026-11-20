package com.metrolist.music.ui.screens.equalizer.wizard;

import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import com.metrolist.music.ui.component.MenuKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WizardScreenKt$$ExternalSyntheticLambda7 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ WizardState f$0;
    public final /* synthetic */ Function0 f$1;
    public final /* synthetic */ Function0 f$2;

    public /* synthetic */ WizardScreenKt$$ExternalSyntheticLambda7(WizardState wizardState, Function0 function0, Function0 function1, byte b) {
        this.$r8$classId = b;
        this.f$0 = wizardState;
        this.f$1 = function0;
        this.f$2 = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function0 function0 = this.f$2;
        Function0 function1 = this.f$1;
        WizardState wizardState = this.f$0;
        byte b2 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1501169265, new WizardScreenKt$$ExternalSyntheticLambda12(wizardState, (byte) 1), gapComposer);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(-1000966707, new WizardScreenKt$$ExternalSyntheticLambda7(wizardState, function1, function0, b2), gapComposer);
                    PaddingValuesImpl paddingValuesImpl = TopAppBarDefaults.ContentPadding;
                    MenuKt.m1493TopAppBarGHTll3U(composableLambdaImplRememberComposableLambda, null, composableLambdaImplRememberComposableLambda2, null, CropImageView.DEFAULT_ASPECT_RATIO, null, TopAppBarDefaults.m363topAppBarColors5tl4gsc(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface, 0L, 0L, 0L, 0L, gapComposer, 62), null, gapComposer, 390, 186);
                }
                break;
            default:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    CardKt.IconButton(wizardState.currentStep != WizardStep.MODEL_SELECTION ? function1 : function0, null, false, null, null, WizardScreenKt.f363lambda$2088387345, gapComposer2, 1572864, 62);
                }
                break;
        }
        return unit;
    }
}
