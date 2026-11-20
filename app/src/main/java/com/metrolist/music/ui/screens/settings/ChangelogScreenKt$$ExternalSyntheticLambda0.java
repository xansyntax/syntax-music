package com.metrolist.music.ui.screens.settings;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import com.metrolist.music.utils.ReleaseInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ChangelogScreenKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ ReleaseInfo f$0;

    public /* synthetic */ ChangelogScreenKt$$ExternalSyntheticLambda0(ReleaseInfo releaseInfo) {
        this.f$0 = releaseInfo;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ReleaseInfo releaseInfo = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    String str = releaseInfo.tagName;
                    Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(Modifier.Companion.$$INSTANCE, 12.0f, 4.0f);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(str, modifierM136paddingVpY3zN4, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSecondaryContainer, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.labelLarge, gapComposer, 48, 0, 131064);
                }
                break;
            default:
                ((Integer) obj2).getClass();
                ChangelogScreenKt.ReleaseItem(releaseInfo, (Composer) obj, Stack.updateChangedFlags(9));
                break;
        }
        return unit;
    }

    public /* synthetic */ ChangelogScreenKt$$ExternalSyntheticLambda0(ReleaseInfo releaseInfo, int i) {
        this.f$0 = releaseInfo;
    }
}
