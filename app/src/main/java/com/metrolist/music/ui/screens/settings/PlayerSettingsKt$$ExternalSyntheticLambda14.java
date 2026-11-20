package com.metrolist.music.ui.screens.settings;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.Modifier;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerSettingsKt$$ExternalSyntheticLambda14 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;

    public /* synthetic */ PlayerSettingsKt$$ExternalSyntheticLambda14(byte b, boolean z) {
        this.$r8$classId = b;
        this.f$0 = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i;
        int i2;
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        int i3 = R.drawable.close;
        Unit unit = Unit.INSTANCE;
        boolean z = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    if (z) {
                        i = 806047163;
                        i2 = R.string.audio_offload_disabled_by_crossfade;
                    } else {
                        i = 806050161;
                        i2 = R.string.audio_offload_description;
                    }
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer, i, i2, gapComposer, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer2), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer2, 56, 8);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(1 & iIntValue3, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer3), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer3, 56, 8);
                }
                break;
            case 3:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(1 & iIntValue4, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer4), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer4, 56, 8);
                }
                break;
            case 4:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(1 & iIntValue5, (iIntValue5 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer5), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer5, 56, 8);
                }
                break;
            case 5:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(1 & iIntValue6, (iIntValue6 & 3) != 2)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer6), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer6, 56, 8);
                }
                break;
            case 6:
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(1 & iIntValue7, (iIntValue7 & 3) != 2)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer7), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer7, 56, 8);
                }
                break;
            case 7:
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(1 & iIntValue8, (iIntValue8 & 3) != 2)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer8), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer8, 56, 8);
                }
                break;
            case 8:
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (!gapComposer9.shouldExecute(1 & iIntValue9, (iIntValue9 & 3) != 2)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer9), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer9, 56, 8);
                }
                break;
            case 9:
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (!gapComposer10.shouldExecute(1 & iIntValue10, (iIntValue10 & 3) != 2)) {
                    gapComposer10.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer10), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer10, 56, 8);
                }
                break;
            case 10:
                Composer composer11 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (!gapComposer11.shouldExecute(1 & iIntValue11, (iIntValue11 & 3) != 2)) {
                    gapComposer11.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer11), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer11, 56, 8);
                }
                break;
            case 11:
                Composer composer12 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (!gapComposer12.shouldExecute(1 & iIntValue12, (iIntValue12 & 3) != 2)) {
                    gapComposer12.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer12), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer12, 56, 8);
                }
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer13 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (!gapComposer13.shouldExecute(1 & iIntValue13, (iIntValue13 & 3) != 2)) {
                    gapComposer13.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer13), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer13, 56, 8);
                }
                break;
            case 13:
                Composer composer14 = (Composer) obj;
                int iIntValue14 = ((Integer) obj2).intValue();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (!gapComposer14.shouldExecute(1 & iIntValue14, (iIntValue14 & 3) != 2)) {
                    gapComposer14.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer14), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer14, 56, 8);
                }
                break;
            case 14:
                Composer composer15 = (Composer) obj;
                int iIntValue15 = ((Integer) obj2).intValue();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (!gapComposer15.shouldExecute(1 & iIntValue15, (iIntValue15 & 3) != 2)) {
                    gapComposer15.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer15), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer15, 56, 8);
                }
                break;
            case 15:
                Composer composer16 = (Composer) obj;
                int iIntValue16 = ((Integer) obj2).intValue();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (!gapComposer16.shouldExecute(1 & iIntValue16, (iIntValue16 & 3) != 2)) {
                    gapComposer16.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer16), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer16, 56, 8);
                }
                break;
            case 16:
                Composer composer17 = (Composer) obj;
                int iIntValue17 = ((Integer) obj2).intValue();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (!gapComposer17.shouldExecute(1 & iIntValue17, (iIntValue17 & 3) != 2)) {
                    gapComposer17.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer17), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer17, 56, 8);
                }
                break;
            case 17:
                Composer composer18 = (Composer) obj;
                int iIntValue18 = ((Integer) obj2).intValue();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (!gapComposer18.shouldExecute(1 & iIntValue18, (iIntValue18 & 3) != 2)) {
                    gapComposer18.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer18), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer18, 56, 8);
                }
                break;
            case 18:
                Composer composer19 = (Composer) obj;
                int iIntValue19 = ((Integer) obj2).intValue();
                GapComposer gapComposer19 = (GapComposer) composer19;
                if (!gapComposer19.shouldExecute(1 & iIntValue19, (iIntValue19 & 3) != 2)) {
                    gapComposer19.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer19), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer19, 56, 8);
                }
                break;
            case 19:
                Composer composer20 = (Composer) obj;
                int iIntValue20 = ((Integer) obj2).intValue();
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (!gapComposer20.shouldExecute(1 & iIntValue20, (iIntValue20 & 3) != 2)) {
                    gapComposer20.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer20), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer20, 56, 8);
                }
                break;
            case 20:
                Composer composer21 = (Composer) obj;
                int iIntValue21 = ((Integer) obj2).intValue();
                GapComposer gapComposer21 = (GapComposer) composer21;
                if (!gapComposer21.shouldExecute(1 & iIntValue21, (iIntValue21 & 3) != 2)) {
                    gapComposer21.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer21), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer21, 56, 8);
                }
                break;
            case 21:
                Composer composer22 = (Composer) obj;
                int iIntValue22 = ((Integer) obj2).intValue();
                GapComposer gapComposer22 = (GapComposer) composer22;
                if (!gapComposer22.shouldExecute(1 & iIntValue22, (iIntValue22 & 3) != 2)) {
                    gapComposer22.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer22), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer22, 56, 8);
                }
                break;
            case 22:
                Composer composer23 = (Composer) obj;
                int iIntValue23 = ((Integer) obj2).intValue();
                GapComposer gapComposer23 = (GapComposer) composer23;
                if (!gapComposer23.shouldExecute(1 & iIntValue23, (iIntValue23 & 3) != 2)) {
                    gapComposer23.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer23), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer23, 56, 8);
                }
                break;
            case 23:
                Composer composer24 = (Composer) obj;
                int iIntValue24 = ((Integer) obj2).intValue();
                GapComposer gapComposer24 = (GapComposer) composer24;
                if (!gapComposer24.shouldExecute(1 & iIntValue24, (iIntValue24 & 3) != 2)) {
                    gapComposer24.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer24), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer24, 56, 8);
                }
                break;
            case 24:
                Composer composer25 = (Composer) obj;
                int iIntValue25 = ((Integer) obj2).intValue();
                GapComposer gapComposer25 = (GapComposer) composer25;
                if (!gapComposer25.shouldExecute(1 & iIntValue25, (iIntValue25 & 3) != 2)) {
                    gapComposer25.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer25), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer25, 56, 8);
                }
                break;
            case 25:
                Composer composer26 = (Composer) obj;
                int iIntValue26 = ((Integer) obj2).intValue();
                GapComposer gapComposer26 = (GapComposer) composer26;
                if (!gapComposer26.shouldExecute(1 & iIntValue26, (iIntValue26 & 3) != 2)) {
                    gapComposer26.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer26), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer26, 56, 8);
                }
                break;
            case 26:
                Composer composer27 = (Composer) obj;
                int iIntValue27 = ((Integer) obj2).intValue();
                GapComposer gapComposer27 = (GapComposer) composer27;
                if (!gapComposer27.shouldExecute(1 & iIntValue27, (iIntValue27 & 3) != 2)) {
                    gapComposer27.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer27), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer27, 56, 8);
                }
                break;
            case 27:
                Composer composer28 = (Composer) obj;
                int iIntValue28 = ((Integer) obj2).intValue();
                GapComposer gapComposer28 = (GapComposer) composer28;
                if (!gapComposer28.shouldExecute(1 & iIntValue28, (iIntValue28 & 3) != 2)) {
                    gapComposer28.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer28), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer28, 56, 8);
                }
                break;
            case 28:
                Composer composer29 = (Composer) obj;
                int iIntValue29 = ((Integer) obj2).intValue();
                GapComposer gapComposer29 = (GapComposer) composer29;
                if (!gapComposer29.shouldExecute(1 & iIntValue29, (iIntValue29 & 3) != 2)) {
                    gapComposer29.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer29), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer29, 56, 8);
                }
                break;
            default:
                Composer composer30 = (Composer) obj;
                int iIntValue30 = ((Integer) obj2).intValue();
                GapComposer gapComposer30 = (GapComposer) composer30;
                if (!gapComposer30.shouldExecute(1 & iIntValue30, (iIntValue30 & 3) != 2)) {
                    gapComposer30.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer30), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer30, 56, 8);
                }
                break;
        }
        return unit;
    }
}
