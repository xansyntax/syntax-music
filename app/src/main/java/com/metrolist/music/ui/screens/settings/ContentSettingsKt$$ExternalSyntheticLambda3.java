package com.metrolist.music.ui.screens.settings;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.constants.AudioQuality;
import com.metrolist.music.constants.LoudnessLevel;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.constants.QuickPicks;
import com.metrolist.music.ui.utils.AppBarKt;
import com.yalantis.ucrop.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ContentSettingsKt$$ExternalSyntheticLambda3 implements Function3 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ContentSettingsKt$$ExternalSyntheticLambda3(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                String str = (String) obj;
                ((Integer) obj3).getClass();
                str.getClass();
                GapComposer gapComposer = (GapComposer) ((Composer) obj2);
                gapComposer.startReplaceGroup(-1949891069);
                Object objStringResource = PreferenceKeysKt.LanguageCodeToName.get(str);
                if (objStringResource == null) {
                    objStringResource = MathKt.stringResource(R.string.system_default, gapComposer);
                }
                String str2 = (String) objStringResource;
                gapComposer.end(false);
                return str2;
            case 1:
                String str3 = (String) obj;
                ((Integer) obj3).getClass();
                str3.getClass();
                GapComposer gapComposer2 = (GapComposer) ((Composer) obj2);
                gapComposer2.startReplaceGroup(371910849);
                Object objStringResource2 = PreferenceKeysKt.LanguageCodeToName.get(str3);
                if (objStringResource2 == null) {
                    objStringResource2 = MathKt.stringResource(R.string.system_default, gapComposer2);
                }
                String str4 = (String) objStringResource2;
                gapComposer2.end(false);
                return str4;
            case 2:
                QuickPicks quickPicks = (QuickPicks) obj;
                ((Integer) obj3).getClass();
                quickPicks.getClass();
                GapComposer gapComposer3 = (GapComposer) ((Composer) obj2);
                gapComposer3.startReplaceGroup(1098026611);
                int iOrdinal = quickPicks.ordinal();
                if (iOrdinal == 0) {
                    i = -1358379177;
                    i2 = R.string.quick_picks;
                } else {
                    if (iOrdinal != 1) {
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer3, -1358380867, false);
                    }
                    i = -1358376514;
                    i2 = R.string.last_song_listened;
                }
                String strM = Format$$ExternalSyntheticOutline0.m(gapComposer3, i, i2, gapComposer3, false);
                gapComposer3.end(false);
                return strM;
            case 3:
                AddToPlaylistPosition addToPlaylistPosition = (AddToPlaylistPosition) obj;
                ((Integer) obj3).getClass();
                addToPlaylistPosition.getClass();
                GapComposer gapComposer4 = (GapComposer) ((Composer) obj2);
                gapComposer4.startReplaceGroup(-845156690);
                int iOrdinal2 = addToPlaylistPosition.ordinal();
                if (iOrdinal2 == 0) {
                    i3 = -446757374;
                    i4 = R.string.playlist_position_beginning;
                } else {
                    if (iOrdinal2 != 1) {
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer4, -446759337, false);
                    }
                    i3 = -446754116;
                    i4 = R.string.playlist_position_end;
                }
                String strM2 = Format$$ExternalSyntheticOutline0.m(gapComposer4, i3, i4, gapComposer4, false);
                gapComposer4.end(false);
                return strM2;
            case 4:
                AddToPlaylistPosition addToPlaylistPosition2 = (AddToPlaylistPosition) obj;
                ((Integer) obj3).getClass();
                addToPlaylistPosition2.getClass();
                GapComposer gapComposer5 = (GapComposer) ((Composer) obj2);
                gapComposer5.startReplaceGroup(1511271309);
                int iOrdinal3 = addToPlaylistPosition2.ordinal();
                if (iOrdinal3 == 0) {
                    i5 = 632784678;
                    i6 = R.string.playlist_position_beginning_desc;
                } else {
                    if (iOrdinal3 != 1) {
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer5, 632782720, false);
                    }
                    i5 = 632788096;
                    i6 = R.string.playlist_position_end_desc;
                }
                String strM3 = Format$$ExternalSyntheticOutline0.m(gapComposer5, i5, i6, gapComposer5, false);
                gapComposer5.end(false);
                return strM3;
            case 5:
                String str5 = (String) obj;
                ((Integer) obj3).getClass();
                str5.getClass();
                GapComposer gapComposer6 = (GapComposer) ((Composer) obj2);
                gapComposer6.startReplaceGroup(1358493538);
                Object objStringResource3 = PreferenceKeysKt.CountryCodeToName.get(str5);
                if (objStringResource3 == null) {
                    objStringResource3 = MathKt.stringResource(R.string.system_default, gapComposer6);
                }
                String str6 = (String) objStringResource3;
                gapComposer6.end(false);
                return str6;
            case 6:
                AudioQuality audioQuality = (AudioQuality) obj;
                ((Integer) obj3).getClass();
                audioQuality.getClass();
                GapComposer gapComposer7 = (GapComposer) ((Composer) obj2);
                gapComposer7.startReplaceGroup(-1974184020);
                int iOrdinal4 = audioQuality.ordinal();
                if (iOrdinal4 == 0) {
                    i7 = 1184703927;
                    i8 = R.string.audio_quality_auto;
                } else if (iOrdinal4 == 1) {
                    i7 = 1184709334;
                    i8 = R.string.audio_quality_low;
                } else {
                    if (iOrdinal4 != 2) {
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer7, 1184702470, false);
                    }
                    i7 = 1184706647;
                    i8 = R.string.audio_quality_high;
                }
                String strM4 = Format$$ExternalSyntheticOutline0.m(gapComposer7, i7, i8, gapComposer7, false);
                gapComposer7.end(false);
                return strM4;
            case 7:
                LoudnessLevel loudnessLevel = (LoudnessLevel) obj;
                ((Integer) obj3).intValue();
                loudnessLevel.getClass();
                GapComposer gapComposer8 = (GapComposer) ((Composer) obj2);
                gapComposer8.startReplaceGroup(808582289);
                String loudnessLevelLabel = AppBarKt.getLoudnessLevelLabel(loudnessLevel, gapComposer8);
                gapComposer8.end(false);
                return loudnessLevelLabel;
            case 8:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer9 = (GapComposer) composer;
                if (gapComposer9.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.dismiss, gapComposer9), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer9, 0, 0, 262142);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 9:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer2;
                if (gapComposer10.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.dismiss, gapComposer10), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer10, 0, 0, 262142);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 10:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer11 = (GapComposer) composer3;
                if (gapComposer11.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.cancel, gapComposer11), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer11, 0, 0, 262142);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case 11:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer12 = (GapComposer) composer4;
                if (gapComposer12.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.ok, gapComposer12), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer12, 0, 0, 262142);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer13 = (GapComposer) composer5;
                if (gapComposer13.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.action_logout, gapComposer13), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer13, 0, 0, 262142);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 13:
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer14 = (GapComposer) composer6;
                if (gapComposer14.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.action_login, gapComposer14), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer14, 0, 0, 262142);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 14:
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer15 = (GapComposer) composer7;
                if (gapComposer15.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.login, gapComposer15), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer15, 0, 0, 262142);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 15:
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer16 = (GapComposer) composer8;
                if (gapComposer16.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.ok, gapComposer16), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer16, 0, 0, 262142);
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 16:
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer17 = (GapComposer) composer9;
                if (gapComposer17.shouldExecute(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.cancel, gapComposer17), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer17, 0, 0, 262142);
                } else {
                    gapComposer17.skipToGroupEnd();
                }
                return unit;
            case 17:
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer18 = (GapComposer) composer10;
                if (gapComposer18.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.action_logout, gapComposer18), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer18, 0, 0, 262142);
                } else {
                    gapComposer18.skipToGroupEnd();
                }
                return unit;
            case 18:
                Composer composer11 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer19 = (GapComposer) composer11;
                if (gapComposer19.shouldExecute(iIntValue11 & 1, (iIntValue11 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.action_login, gapComposer19), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer19, 0, 0, 262142);
                } else {
                    gapComposer19.skipToGroupEnd();
                }
                return unit;
            case 19:
                Composer composer12 = (Composer) obj2;
                int iIntValue12 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer20 = (GapComposer) composer12;
                if (gapComposer20.shouldExecute(iIntValue12 & 1, (iIntValue12 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.reset, gapComposer20), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer20, 0, 0, 262142);
                } else {
                    gapComposer20.skipToGroupEnd();
                }
                return unit;
            case 20:
                Composer composer13 = (Composer) obj2;
                int iIntValue13 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer21 = (GapComposer) composer13;
                if (gapComposer21.shouldExecute(iIntValue13 & 1, (iIntValue13 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.cancel, gapComposer21), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer21, 0, 0, 262142);
                } else {
                    gapComposer21.skipToGroupEnd();
                }
                return unit;
            case 21:
                Composer composer14 = (Composer) obj2;
                int iIntValue14 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer22 = (GapComposer) composer14;
                if (gapComposer22.shouldExecute(iIntValue14 & 1, (iIntValue14 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.ok, gapComposer22), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer22, 0, 0, 262142);
                } else {
                    gapComposer22.skipToGroupEnd();
                }
                return unit;
            case 22:
                Composer composer15 = (Composer) obj2;
                int iIntValue15 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer23 = (GapComposer) composer15;
                if (gapComposer23.shouldExecute(iIntValue15 & 1, (iIntValue15 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.reset, gapComposer23), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer23, 0, 0, 262142);
                } else {
                    gapComposer23.skipToGroupEnd();
                }
                return unit;
            case 23:
                Composer composer16 = (Composer) obj2;
                int iIntValue16 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer24 = (GapComposer) composer16;
                if (gapComposer24.shouldExecute(iIntValue16 & 1, (iIntValue16 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.cancel, gapComposer24), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer24, 0, 0, 262142);
                } else {
                    gapComposer24.skipToGroupEnd();
                }
                return unit;
            case 24:
                Composer composer17 = (Composer) obj2;
                int iIntValue17 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer25 = (GapComposer) composer17;
                if (gapComposer25.shouldExecute(iIntValue17 & 1, (iIntValue17 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.ok, gapComposer25), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer25, 0, 0, 262142);
                } else {
                    gapComposer25.skipToGroupEnd();
                }
                return unit;
            case 25:
                Composer composer18 = (Composer) obj2;
                int iIntValue18 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer26 = (GapComposer) composer18;
                if (gapComposer26.shouldExecute(iIntValue18 & 1, (iIntValue18 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.reset, gapComposer26), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer26, 0, 0, 262142);
                } else {
                    gapComposer26.skipToGroupEnd();
                }
                return unit;
            case 26:
                Composer composer19 = (Composer) obj2;
                int iIntValue19 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer27 = (GapComposer) composer19;
                if (gapComposer27.shouldExecute(iIntValue19 & 1, (iIntValue19 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.cancel, gapComposer27), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer27, 0, 0, 262142);
                } else {
                    gapComposer27.skipToGroupEnd();
                }
                return unit;
            case 27:
                Composer composer20 = (Composer) obj2;
                int iIntValue20 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer28 = (GapComposer) composer20;
                if (gapComposer28.shouldExecute(iIntValue20 & 1, (iIntValue20 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.create, gapComposer28), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer28, 0, 0, 262142);
                } else {
                    gapComposer28.skipToGroupEnd();
                }
                return unit;
            case 28:
                Composer composer21 = (Composer) obj2;
                int iIntValue21 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer29 = (GapComposer) composer21;
                if (gapComposer29.shouldExecute(iIntValue21 & 1, (iIntValue21 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.reset, gapComposer29), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer29, 0, 0, 262142);
                } else {
                    gapComposer29.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer22 = (Composer) obj2;
                int iIntValue22 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer30 = (GapComposer) composer22;
                if (gapComposer30.shouldExecute(iIntValue22 & 1, (iIntValue22 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.copy, gapComposer30), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer30, 0, 0, 262142);
                } else {
                    gapComposer30.skipToGroupEnd();
                }
                return unit;
        }
    }
}
