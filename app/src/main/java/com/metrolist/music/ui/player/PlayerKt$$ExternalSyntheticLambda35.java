package com.metrolist.music.ui.player;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.google.common.math.IntMath;
import com.metrolist.music.db.entities.Artist;
import com.yalantis.ucrop.R;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerKt$$ExternalSyntheticLambda35 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ State f$0;

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda35(State state, byte b) {
        this.$r8$classId = b;
        this.f$0 = state;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String str;
        String strM;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        State state = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.shuffle, 0, gapComposer), MathKt.stringResource(R.string.shuffle, gapComposer), SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 26.0f), ((Color) state.getValue()).value, gapComposer, 392, 0);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    String str2 = (String) state.getValue();
                    TextKt.m352TextNvy7gAk(str2 == null ? "" : str2, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262142);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    Artist artist = (Artist) state.getValue();
                    str = artist != null ? artist.artist.name : null;
                    TextKt.m352TextNvy7gAk(str == null ? "" : str, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                }
                break;
            case 3:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk((String) state.getValue(), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262142);
                }
                break;
            case 4:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    Artist artist2 = (Artist) state.getValue();
                    str = artist2 != null ? artist2.artist.name : null;
                    TextKt.m352TextNvy7gAk(str == null ? "" : str, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262142);
                }
                break;
            case 5:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(((Boolean) state.getValue()).booleanValue() ? R.drawable.remove : R.drawable.add, 0, gapComposer6), (String) null, (Modifier) null, 0L, gapComposer6, 56, 12);
                }
                break;
            case 6:
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(((Boolean) state.getValue()).booleanValue() ? R.string.unpin_from_speed_dial : R.string.pin_to_speed_dial, gapComposer7), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer7, 0, 0, 262142);
                }
                break;
            default:
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    if (((Set) state.getValue()).isEmpty()) {
                        strM = Format$$ExternalSyntheticOutline0.m(gapComposer8, -1468743294, R.string.listen_together_no_blocked_users, gapComposer8, false);
                    } else {
                        gapComposer8.startReplaceGroup(-1468910136);
                        strM = MathKt.stringResource(R.string.listen_together_blocked_users_count, new Object[]{Integer.valueOf(((Set) state.getValue()).size())}, gapComposer8);
                        gapComposer8.end(false);
                    }
                    TextKt.m352TextNvy7gAk(strM, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer8, 0, 0, 262142);
                }
                break;
        }
        return unit;
    }
}
