package com.metrolist.music.ui.screens;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda34;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HistoryScreenKt$$ExternalSyntheticLambda4 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ MenuState f$2;
    public final /* synthetic */ Function0 f$3;
    public final /* synthetic */ MutableState f$4;
    public final /* synthetic */ MutableState f$5;

    public /* synthetic */ HistoryScreenKt$$ExternalSyntheticLambda4(List list, List list2, MenuState menuState, Function0 function0, MutableState mutableState, MutableState mutableState2, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$1 = list2;
        this.f$2 = menuState;
        this.f$3 = function0;
        this.f$4 = mutableState;
        this.f$5 = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        MutableState mutableState = this.f$5;
        MutableState mutableState2 = this.f$4;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else if (AlbumScreenKt.HistoryScreen$lambda$4(mutableState)) {
                    gapComposer.startReplaceGroup(1258503198);
                    List list = this.f$0;
                    int size = list.size();
                    List list2 = this.f$1;
                    boolean z = size == list2.size() && !list.isEmpty();
                    boolean zChangedInstance = gapComposer.changedInstance(list) | gapComposer.changedInstance(list2);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new AlbumScreenKt$$ExternalSyntheticLambda13(list, list2, (byte) 2);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.Checkbox(z, (Function1) objRememberedValue, null, false, null, gapComposer, 0);
                    boolean z2 = !list.isEmpty();
                    MenuState menuState = this.f$2;
                    boolean zChanged = gapComposer.changed(menuState) | gapComposer.changedInstance(list) | gapComposer.changedInstance(list2);
                    Function0 function0 = this.f$3;
                    boolean zChanged2 = gapComposer.changed(function0) | zChanged;
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        QueueKt$$ExternalSyntheticLambda34 queueKt$$ExternalSyntheticLambda34 = new QueueKt$$ExternalSyntheticLambda34((byte) 2, menuState, list, list2, function0);
                        gapComposer.updateRememberedValue(queueKt$$ExternalSyntheticLambda34);
                        objRememberedValue2 = queueKt$$ExternalSyntheticLambda34;
                    }
                    CardKt.IconButton((Function0) objRememberedValue2, null, z2, null, null, AlbumScreenKt.lambda$156564127, gapComposer, 1572864, 58);
                    gapComposer.end(false);
                } else if (!((Boolean) mutableState2.getValue()).booleanValue()) {
                    gapComposer.startReplaceGroup(1260116314);
                    boolean zChanged3 = gapComposer.changed(mutableState2);
                    Object objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new PlayerKt$$ExternalSyntheticLambda7(mutableState2, (byte) 7);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.IconButton((Function0) objRememberedValue3, null, false, null, null, AlbumScreenKt.lambda$1696378774, gapComposer, 1572864, 62);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(1260408458);
                    gapComposer.end(false);
                }
                break;
            default:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else if (TopPlaylistScreenKt.TopPlaylistScreen$lambda$15(mutableState2)) {
                    gapComposer2.startReplaceGroup(828271861);
                    List list3 = this.f$0;
                    int size2 = list3.size();
                    List list4 = this.f$1;
                    boolean z3 = size2 == list4.size() && !list3.isEmpty();
                    boolean zChangedInstance2 = gapComposer2.changedInstance(list3) | gapComposer2.changedInstance(list4);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new AlbumScreenKt$$ExternalSyntheticLambda13(list3, list4, (byte) 5);
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    CardKt.Checkbox(z3, (Function1) objRememberedValue4, null, false, null, gapComposer2, 0);
                    boolean z4 = !list3.isEmpty();
                    MenuState menuState2 = this.f$2;
                    boolean zChanged4 = gapComposer2.changed(menuState2) | gapComposer2.changedInstance(list4) | gapComposer2.changedInstance(list3);
                    Function0 function1 = this.f$3;
                    boolean zChanged5 = gapComposer2.changed(function1) | zChanged4;
                    Object objRememberedValue5 = gapComposer2.rememberedValue();
                    if (zChanged5 || objRememberedValue5 == neverEqualPolicy) {
                        QueueKt$$ExternalSyntheticLambda34 queueKt$$ExternalSyntheticLambda35 = new QueueKt$$ExternalSyntheticLambda34((byte) 3, menuState2, list4, list3, function1);
                        gapComposer2.updateRememberedValue(queueKt$$ExternalSyntheticLambda35);
                        objRememberedValue5 = queueKt$$ExternalSyntheticLambda35;
                    }
                    CardKt.IconButton((Function0) objRememberedValue5, null, z4, null, null, TopPlaylistScreenKt.lambda$1117948844, gapComposer2, 1572864, 58);
                    gapComposer2.end(false);
                } else if (!((Boolean) mutableState.getValue()).booleanValue()) {
                    gapComposer2.startReplaceGroup(829591965);
                    Object objRememberedValue6 = gapComposer2.rememberedValue();
                    if (objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState, (byte) 22);
                        gapComposer2.updateRememberedValue(objRememberedValue6);
                    }
                    CardKt.IconButton((Function0) objRememberedValue6, null, false, null, null, TopPlaylistScreenKt.lambda$2030884693, gapComposer2, 1572870, 62);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.startReplaceGroup(829916783);
                    gapComposer2.end(false);
                }
                break;
        }
        return unit;
    }
}
