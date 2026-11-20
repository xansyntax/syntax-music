package com.metrolist.music.ui.player;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.R;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueKt$$ExternalSyntheticLambda25 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ State f$1;

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda25(boolean z, State state, byte b) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = state;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        int i;
        byte b = this.$r8$classId;
        int i2 = R.string.sort_ascending;
        int i3 = R.drawable.arrow_upward;
        Unit unit = Unit.INSTANCE;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        State state = this.f$1;
        boolean z = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.shuffle, 0, gapComposer), (String) null, ClipKt.alpha(companion, z ? 0.3f : ((Boolean) state.getValue()).booleanValue() ? 1.0f : 0.5f), 0L, gapComposer, 56, 8);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    if (z) {
                        i3 = R.drawable.arrow_downward;
                    }
                    Painter painterPainterResource = IntMath.painterResource(i3, 0, gapComposer2);
                    if (z) {
                        i2 = R.string.sort_descending;
                    }
                    IconKt.m290Iconww6aTOc(painterPainterResource, MathKt.stringResource(i2, gapComposer2), SizeKt.m151size3ABfNKs(companion, 18.0f), ((Color) state.getValue()).value, gapComposer2, 392, 0);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 2:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    if (z) {
                        i3 = R.drawable.arrow_downward;
                    }
                    Painter painterPainterResource2 = IntMath.painterResource(i3, 0, gapComposer3);
                    if (z) {
                        i2 = R.string.sort_descending;
                    }
                    IconKt.m290Iconww6aTOc(painterPainterResource2, MathKt.stringResource(i2, gapComposer3), SizeKt.m151size3ABfNKs(companion, 18.0f), ((Color) state.getValue()).value, gapComposer3, 392, 0);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                    return unit;
                }
                float f = z ? 0.3f : ((Number) state.getValue()).intValue() == 0 ? 0.5f : 1.0f;
                int iIntValue5 = ((Number) state.getValue()).intValue();
                if (iIntValue5 == 0) {
                    i = R.drawable.repeat;
                } else if (iIntValue5 != 1) {
                    if (iIntValue5 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m();
                        return null;
                    }
                    i = R.drawable.repeat;
                } else {
                    i = R.drawable.repeat_one;
                }
                IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer4), (String) null, ClipKt.alpha(companion, f), 0L, gapComposer4, 56, 8);
                return unit;
        }
    }
}
