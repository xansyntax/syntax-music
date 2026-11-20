package com.metrolist.music.ui.screens.settings;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.Expect_jvmKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda26;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ContentSettingsKt$$ExternalSyntheticLambda41 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Function1 f$1;

    public /* synthetic */ ContentSettingsKt$$ExternalSyntheticLambda41(byte b, Function1 function1, boolean z) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    boolean z = this.f$0;
                    MenuKt.Switch(z, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-1937881820, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 24, z), gapComposer), false, null, gapComposer, 3072, 116);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    boolean z2 = this.f$0;
                    MenuKt.Switch(z2, this.f$1, null, Expect_jvmKt.rememberComposableLambda(1655175327, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 16, z2), gapComposer2), false, null, gapComposer2, 3072, 116);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    boolean z3 = this.f$0;
                    MenuKt.Switch(z3, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-1139262619, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 9, z3), gapComposer3), false, null, gapComposer3, 3072, 116);
                }
                break;
            case 3:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    boolean z4 = this.f$0;
                    MenuKt.Switch(z4, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-169988957, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 18, z4), gapComposer4), false, null, gapComposer4, 3072, 116);
                }
                break;
            case 4:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    boolean z5 = this.f$0;
                    MenuKt.Switch(z5, this.f$1, null, Expect_jvmKt.rememberComposableLambda(314647874, new SongMenuKt$$ExternalSyntheticLambda26((byte) 26, z5), gapComposer5), false, null, gapComposer5, 3072, 116);
                }
                break;
            case 5:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    boolean z6 = this.f$0;
                    MenuKt.Switch(z6, this.f$1, null, Expect_jvmKt.rememberComposableLambda(1768558367, new SongMenuKt$$ExternalSyntheticLambda26((byte) 27, z6), gapComposer6), false, null, gapComposer6, 3072, 116);
                }
                break;
            case 6:
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    boolean z7 = this.f$0;
                    MenuKt.Switch(z7, this.f$1, null, Expect_jvmKt.rememberComposableLambda(797153080, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 7, z7), gapComposer7), false, null, gapComposer7, 3072, 116);
                }
                break;
            case 7:
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    boolean z8 = this.f$0;
                    MenuKt.Switch(z8, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-2064557796, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 15, z8), gapComposer8), false, null, gapComposer8, 3072, 116);
                }
                break;
            case 8:
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (!gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    boolean z9 = this.f$0;
                    MenuKt.Switch(z9, this.f$1, null, Expect_jvmKt.rememberComposableLambda(1229353629, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 19, z9), gapComposer9), false, null, gapComposer9, 3072, 116);
                }
                break;
            case 9:
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (!gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                    gapComposer10.skipToGroupEnd();
                } else {
                    boolean z10 = this.f$0;
                    MenuKt.Switch(z10, this.f$1, null, Expect_jvmKt.rememberComposableLambda(228297758, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 22, z10), gapComposer10), false, null, gapComposer10, 3072, 116);
                }
                break;
            case 10:
                Composer composer11 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (!gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 3) != 2)) {
                    gapComposer11.skipToGroupEnd();
                } else {
                    boolean z11 = this.f$0;
                    MenuKt.Switch(z11, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-772758113, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 2, z11), gapComposer11), false, null, gapComposer11, 3072, 116);
                }
                break;
            case 11:
                Composer composer12 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (!gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 3) != 2)) {
                    gapComposer12.skipToGroupEnd();
                } else {
                    boolean z12 = this.f$0;
                    MenuKt.Switch(z12, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-1773813984, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 20, z12), gapComposer12), false, null, gapComposer12, 3072, 116);
                }
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer13 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (!gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 3) != 2)) {
                    gapComposer13.skipToGroupEnd();
                } else {
                    boolean z13 = this.f$0;
                    MenuKt.Switch(z13, this.f$1, null, Expect_jvmKt.rememberComposableLambda(753873621, new SongMenuKt$$ExternalSyntheticLambda26((byte) 28, z13), gapComposer13), false, null, gapComposer13, 3072, 116);
                }
                break;
            case 13:
                Composer composer14 = (Composer) obj;
                int iIntValue14 = ((Integer) obj2).intValue();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (!gapComposer14.shouldExecute(iIntValue14 & 1, (iIntValue14 & 3) != 2)) {
                    gapComposer14.skipToGroupEnd();
                } else {
                    boolean z14 = this.f$0;
                    MenuKt.Switch(z14, this.f$1, null, Expect_jvmKt.rememberComposableLambda(699435257, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 21, z14), gapComposer14), false, null, gapComposer14, 3072, 116);
                }
                break;
            case 14:
                Composer composer15 = (Composer) obj;
                int iIntValue15 = ((Integer) obj2).intValue();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (!gapComposer15.shouldExecute(iIntValue15 & 1, (iIntValue15 & 3) != 2)) {
                    gapComposer15.skipToGroupEnd();
                } else {
                    boolean z15 = this.f$0;
                    MenuKt.Switch(z15, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-301620614, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 12, z15), gapComposer15), false, null, gapComposer15, 3072, 116);
                }
                break;
            case 15:
                Composer composer16 = (Composer) obj;
                int iIntValue16 = ((Integer) obj2).intValue();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (!gapComposer16.shouldExecute(iIntValue16 & 1, (iIntValue16 & 3) != 2)) {
                    gapComposer16.skipToGroupEnd();
                } else {
                    boolean z16 = this.f$0;
                    MenuKt.Switch(z16, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-1302676485, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 1, z16), gapComposer16), false, null, gapComposer16, 3072, 116);
                }
                break;
            case 16:
                Composer composer17 = (Composer) obj;
                int iIntValue17 = ((Integer) obj2).intValue();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (!gapComposer17.shouldExecute(iIntValue17 & 1, (iIntValue17 & 3) != 2)) {
                    gapComposer17.skipToGroupEnd();
                } else {
                    boolean z17 = this.f$0;
                    MenuKt.Switch(z17, this.f$1, null, Expect_jvmKt.rememberComposableLambda(1991234940, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 4, z17), gapComposer17), false, null, gapComposer17, 3072, 116);
                }
                break;
            case 17:
                Composer composer18 = (Composer) obj;
                int iIntValue18 = ((Integer) obj2).intValue();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (!gapComposer18.shouldExecute(iIntValue18 & 1, (iIntValue18 & 3) != 2)) {
                    gapComposer18.skipToGroupEnd();
                } else {
                    boolean z18 = this.f$0;
                    MenuKt.Switch(z18, this.f$1, null, Expect_jvmKt.rememberComposableLambda(990179069, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 11, z18), gapComposer18), false, null, gapComposer18, 3072, 116);
                }
                break;
            case 18:
                Composer composer19 = (Composer) obj;
                int iIntValue19 = ((Integer) obj2).intValue();
                GapComposer gapComposer19 = (GapComposer) composer19;
                if (!gapComposer19.shouldExecute(iIntValue19 & 1, (iIntValue19 & 3) != 2)) {
                    gapComposer19.skipToGroupEnd();
                } else {
                    boolean z19 = this.f$0;
                    MenuKt.Switch(z19, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-1285589866, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 8, z19), gapComposer19), false, null, gapComposer19, 3072, 116);
                }
                break;
            case 19:
                Composer composer20 = (Composer) obj;
                int iIntValue20 = ((Integer) obj2).intValue();
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (!gapComposer20.shouldExecute(iIntValue20 & 1, (iIntValue20 & 3) != 2)) {
                    gapComposer20.skipToGroupEnd();
                } else {
                    boolean z20 = this.f$0;
                    MenuKt.Switch(z20, this.f$1, null, Expect_jvmKt.rememberComposableLambda(969913943, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 14, z20), gapComposer20), false, null, gapComposer20, 3072, 116);
                }
                break;
            case 20:
                Composer composer21 = (Composer) obj;
                int iIntValue21 = ((Integer) obj2).intValue();
                GapComposer gapComposer21 = (GapComposer) composer21;
                if (!gapComposer21.shouldExecute(iIntValue21 & 1, (iIntValue21 & 3) != 2)) {
                    gapComposer21.skipToGroupEnd();
                } else {
                    boolean z21 = this.f$0;
                    MenuKt.Switch(z21, this.f$1, null, Expect_jvmKt.rememberComposableLambda(1027559697, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 5, z21), gapComposer21), false, null, gapComposer21, 3072, 116);
                }
                break;
            case 21:
                Composer composer22 = (Composer) obj;
                int iIntValue22 = ((Integer) obj2).intValue();
                GapComposer gapComposer22 = (GapComposer) composer22;
                if (!gapComposer22.shouldExecute(iIntValue22 & 1, (iIntValue22 & 3) != 2)) {
                    gapComposer22.skipToGroupEnd();
                } else {
                    boolean z22 = this.f$0;
                    MenuKt.Switch(z22, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-1069549544, new SongMenuKt$$ExternalSyntheticLambda26((byte) 29, z22), gapComposer22), false, null, gapComposer22, 3072, 116);
                }
                break;
            case 22:
                Composer composer23 = (Composer) obj;
                int iIntValue23 = ((Integer) obj2).intValue();
                GapComposer gapComposer23 = (GapComposer) composer23;
                if (!gapComposer23.shouldExecute(iIntValue23 & 1, (iIntValue23 & 3) != 2)) {
                    gapComposer23.skipToGroupEnd();
                } else {
                    boolean z23 = this.f$0;
                    MenuKt.Switch(z23, this.f$1, null, Expect_jvmKt.rememberComposableLambda(1405055469, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 3, z23), gapComposer23), false, null, gapComposer23, 3072, 116);
                }
                break;
            case 23:
                Composer composer24 = (Composer) obj;
                int iIntValue24 = ((Integer) obj2).intValue();
                GapComposer gapComposer24 = (GapComposer) composer24;
                if (!gapComposer24.shouldExecute(iIntValue24 & 1, (iIntValue24 & 3) != 2)) {
                    gapComposer24.skipToGroupEnd();
                } else {
                    boolean z24 = this.f$0;
                    MenuKt.Switch(z24, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-1792593938, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 17, z24), gapComposer24), false, null, gapComposer24, 3072, 116);
                }
                break;
            case 24:
                Composer composer25 = (Composer) obj;
                int iIntValue25 = ((Integer) obj2).intValue();
                GapComposer gapComposer25 = (GapComposer) composer25;
                if (!gapComposer25.shouldExecute(iIntValue25 & 1, (iIntValue25 & 3) != 2)) {
                    gapComposer25.skipToGroupEnd();
                } else {
                    boolean z25 = this.f$0;
                    MenuKt.Switch(z25, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-976729400, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 10, z25), gapComposer25), false, null, gapComposer25, 3072, 116);
                }
                break;
            case 25:
                Composer composer26 = (Composer) obj;
                int iIntValue26 = ((Integer) obj2).intValue();
                GapComposer gapComposer26 = (GapComposer) composer26;
                if (!gapComposer26.shouldExecute(iIntValue26 & 1, (iIntValue26 & 3) != 2)) {
                    gapComposer26.skipToGroupEnd();
                } else {
                    boolean z26 = this.f$0;
                    MenuKt.Switch(z26, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-695276049, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 13, z26), gapComposer26), false, null, gapComposer26, 3072, 116);
                }
                break;
            case 26:
                Composer composer27 = (Composer) obj;
                int iIntValue27 = ((Integer) obj2).intValue();
                GapComposer gapComposer27 = (GapComposer) composer27;
                if (!gapComposer27.shouldExecute(iIntValue27 & 1, (iIntValue27 & 3) != 2)) {
                    gapComposer27.skipToGroupEnd();
                } else {
                    boolean z27 = this.f$0;
                    MenuKt.Switch(z27, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-719602203, new PlayerSettingsKt$$ExternalSyntheticLambda14((byte) 7, z27), gapComposer27), false, null, gapComposer27, 3072, 116);
                }
                break;
            case 27:
                Composer composer28 = (Composer) obj;
                int iIntValue28 = ((Integer) obj2).intValue();
                GapComposer gapComposer28 = (GapComposer) composer28;
                if (!gapComposer28.shouldExecute(iIntValue28 & 1, (iIntValue28 & 3) != 2)) {
                    gapComposer28.skipToGroupEnd();
                } else {
                    boolean z28 = this.f$0;
                    MenuKt.Switch(z28, this.f$1, null, Expect_jvmKt.rememberComposableLambda(498677414, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 25, z28), gapComposer28), false, null, gapComposer28, 3072, 116);
                }
                break;
            case 28:
                Composer composer29 = (Composer) obj;
                int iIntValue29 = ((Integer) obj2).intValue();
                GapComposer gapComposer29 = (GapComposer) composer29;
                if (!gapComposer29.shouldExecute(iIntValue29 & 1, (iIntValue29 & 3) != 2)) {
                    gapComposer29.skipToGroupEnd();
                } else {
                    boolean z29 = this.f$0;
                    MenuKt.Switch(z29, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-1098503638, new PlayerSettingsKt$$ExternalSyntheticLambda14((byte) 5, z29), gapComposer29), false, null, gapComposer29, 3072, 116);
                }
                break;
            default:
                Composer composer30 = (Composer) obj;
                int iIntValue30 = ((Integer) obj2).intValue();
                GapComposer gapComposer30 = (GapComposer) composer30;
                if (!gapComposer30.shouldExecute(iIntValue30 & 1, (iIntValue30 & 3) != 2)) {
                    gapComposer30.skipToGroupEnd();
                } else {
                    boolean z30 = this.f$0;
                    MenuKt.Switch(z30, this.f$1, null, Expect_jvmKt.rememberComposableLambda(1437103787, new ContentSettingsKt$$ExternalSyntheticLambda82((byte) 23, z30), gapComposer30), false, null, gapComposer30, 3072, 116);
                }
                break;
        }
        return unit;
    }
}
