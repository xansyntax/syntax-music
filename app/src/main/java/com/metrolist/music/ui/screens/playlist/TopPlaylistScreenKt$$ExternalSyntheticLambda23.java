package com.metrolist.music.ui.screens.playlist;

import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.ui.Modifier;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda17;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TopPlaylistScreenKt$$ExternalSyntheticLambda23 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ MenuState f$2;
    public final /* synthetic */ MutableState f$3;
    public final /* synthetic */ ParcelableSnapshotMutableIntState f$4;
    public final /* synthetic */ MutableState f$5;

    public /* synthetic */ TopPlaylistScreenKt$$ExternalSyntheticLambda23(String str, int i, MenuState menuState, MutableState mutableState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState2, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
        this.f$1 = i;
        this.f$2 = menuState;
        this.f$3 = mutableState;
        this.f$4 = parcelableSnapshotMutableIntState;
        this.f$5 = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        MutableState mutableState = this.f$5;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.f$4;
        MutableState mutableState2 = this.f$3;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    List list = (List) mutableState2.getValue();
                    list.getClass();
                    int intValue = parcelableSnapshotMutableIntState.getIntValue();
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState, (byte) 24);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    TopPlaylistScreenKt.TopPlaylistHeader(this.f$0, list, this.f$1, intValue, (Function0) objRememberedValue, this.f$2, DialogKt.m1476riseInwH6b6FI$default(companion, 0), gapComposer, 24576);
                }
                break;
            default:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    List list2 = (List) mutableState2.getValue();
                    list2.getClass();
                    int intValue2 = parcelableSnapshotMutableIntState.getIntValue();
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState, (byte) 5);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    TopPlaylistScreenKt.AutoPlaylistHeader(this.f$0, list2, this.f$1, intValue2, (Function0) objRememberedValue2, this.f$2, DialogKt.m1476riseInwH6b6FI$default(companion, 0), gapComposer2, 24576);
                }
                break;
        }
        return unit;
    }
}
