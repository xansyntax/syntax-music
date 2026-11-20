package com.metrolist.music.ui.screens.settings.integrations;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.music.listentogether.LogEntry;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ListenTogetherSettingsKt$$ExternalSyntheticLambda80 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ LogEntry f$0;

    public /* synthetic */ ListenTogetherSettingsKt$$ExternalSyntheticLambda80(LogEntry logEntry) {
        this.f$0 = logEntry;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        long j;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        LogEntry logEntry = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    String strName = logEntry.level.name();
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.labelSmall;
                    Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(Modifier.Companion.$$INSTANCE, 4.0f, 1.0f);
                    int iOrdinal = logEntry.level.ordinal();
                    if (iOrdinal == 0) {
                        gapComposer.startReplaceGroup(474825038);
                        j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onPrimaryContainer;
                        gapComposer.end(false);
                    } else if (iOrdinal == 1) {
                        gapComposer.startReplaceGroup(474819341);
                        gapComposer.end(false);
                        j = -34511453792763904L;
                    } else if (iOrdinal == 2) {
                        gapComposer.startReplaceGroup(474817260);
                        j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onErrorContainer;
                        gapComposer.end(false);
                    } else {
                        if (iOrdinal != 3) {
                            throw Format$$ExternalSyntheticOutline0.m(gapComposer, 474814710, false);
                        }
                        gapComposer.startReplaceGroup(474822220);
                        j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant;
                        gapComposer.end(false);
                    }
                    TextKt.m352TextNvy7gAk(strName, modifierM136paddingVpY3zN4, j, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, 48, 0, 131064);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            default:
                ((Integer) obj2).getClass();
                ListenTogetherSettingsKt.LogEntryItem(logEntry, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
        }
    }

    public /* synthetic */ ListenTogetherSettingsKt$$ExternalSyntheticLambda80(LogEntry logEntry, int i) {
        this.f$0 = logEntry;
    }
}
