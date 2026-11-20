package com.metrolist.music.ui.player;

import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.media3.common.Timeline;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueKt$$ExternalSyntheticLambda36 implements Function2 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda36(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((Integer) obj).intValue();
                Timeline.Window window = (Timeline.Window) obj2;
                window.getClass();
                return Integer.valueOf(window.uid.hashCode());
            case 1:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.details, gapComposer), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 2:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.details_desc, gapComposer2), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262142);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 3:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.queue_music, 0, gapComposer3), (String) null, (Modifier) null, 0L, gapComposer3, 56, 12);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 4:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.suggest_to_host, gapComposer4), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262142);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 5:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.radio, 0, gapComposer5), (String) null, (Modifier) null, 0L, gapComposer5, 56, 12);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 6:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.start_radio, gapComposer6), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 0, 0, 262142);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 7:
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.start_radio_desc, gapComposer7), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer7, 0, 0, 262142);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 8:
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.queue_music, 0, gapComposer8), (String) null, (Modifier) null, 0L, gapComposer8, 56, 12);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 9:
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.add_to_queue, gapComposer9), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer9, 0, 0, 262142);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 10:
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.remove, 0, gapComposer10), (String) null, (Modifier) null, 0L, gapComposer10, 56, 12);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 11:
                Composer composer11 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.remove_episode_from_saved, gapComposer11), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer11, 0, 0, 262142);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer12 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.playlist_add, 0, gapComposer12), (String) null, (Modifier) null, 0L, gapComposer12, 56, 12);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case 13:
                Composer composer13 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.save_episode_for_later, gapComposer13), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer13, 0, 0, 262142);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 14:
                Composer composer14 = (Composer) obj;
                int iIntValue14 = ((Integer) obj2).intValue();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (gapComposer14.shouldExecute(iIntValue14 & 1, (iIntValue14 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.save_episode_for_later_desc, gapComposer14), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer14, 0, 0, 262142);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 15:
                Composer composer15 = (Composer) obj;
                int iIntValue15 = ((Integer) obj2).intValue();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (gapComposer15.shouldExecute(iIntValue15 & 1, (iIntValue15 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.delete, 0, gapComposer15), (String) null, (Modifier) null, 0L, gapComposer15, 56, 12);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 16:
                Composer composer16 = (Composer) obj;
                int iIntValue16 = ((Integer) obj2).intValue();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (gapComposer16.shouldExecute(iIntValue16 & 1, (iIntValue16 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.remove_from_history, gapComposer16), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer16, 0, 0, 262142);
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 17:
                TextFieldValue textFieldValue = (TextFieldValue) obj2;
                ((SaveableHolder) obj).getClass();
                textFieldValue.getClass();
                return textFieldValue.annotatedString.text;
            case 18:
                Composer composer17 = (Composer) obj;
                int iIntValue17 = ((Integer) obj2).intValue();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (gapComposer17.shouldExecute(iIntValue17 & 1, (iIntValue17 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.skip_next, 0, gapComposer17), (String) null, (Modifier) null, 0L, gapComposer17, 56, 12);
                } else {
                    gapComposer17.skipToGroupEnd();
                }
                return unit;
            case 19:
                Composer composer18 = (Composer) obj;
                int iIntValue18 = ((Integer) obj2).intValue();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (gapComposer18.shouldExecute(iIntValue18 & 1, (iIntValue18 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.bedtime, 0, gapComposer18), (String) null, (Modifier) null, 0L, gapComposer18, 56, 12);
                } else {
                    gapComposer18.skipToGroupEnd();
                }
                return unit;
            case 20:
                Composer composer19 = (Composer) obj;
                int iIntValue19 = ((Integer) obj2).intValue();
                GapComposer gapComposer19 = (GapComposer) composer19;
                if (gapComposer19.shouldExecute(iIntValue19 & 1, (iIntValue19 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.sleep_timer, gapComposer19), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer19, 0, 0, 262142);
                } else {
                    gapComposer19.skipToGroupEnd();
                }
                return unit;
            case 21:
                Composer composer20 = (Composer) obj;
                int iIntValue20 = ((Integer) obj2).intValue();
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (gapComposer20.shouldExecute(iIntValue20 & 1, (iIntValue20 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.set_as_default, gapComposer20), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer20, 0, 0, 262142);
                } else {
                    gapComposer20.skipToGroupEnd();
                }
                return unit;
            case 22:
                Composer composer21 = (Composer) obj;
                int iIntValue21 = ((Integer) obj2).intValue();
                GapComposer gapComposer21 = (GapComposer) composer21;
                if (gapComposer21.shouldExecute(iIntValue21 & 1, (iIntValue21 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.set_as_default, gapComposer21), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer21, 0, 0, 262142);
                } else {
                    gapComposer21.skipToGroupEnd();
                }
                return unit;
            case 23:
                Composer composer22 = (Composer) obj;
                int iIntValue22 = ((Integer) obj2).intValue();
                GapComposer gapComposer22 = (GapComposer) composer22;
                if (gapComposer22.shouldExecute(iIntValue22 & 1, (iIntValue22 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.end_of_song, gapComposer22), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer22, 0, 0, 262142);
                } else {
                    gapComposer22.skipToGroupEnd();
                }
                return unit;
            case 24:
                Composer composer23 = (Composer) obj;
                int iIntValue23 = ((Integer) obj2).intValue();
                GapComposer gapComposer23 = (GapComposer) composer23;
                if (gapComposer23.shouldExecute(iIntValue23 & 1, (iIntValue23 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.drag_handle, 0, gapComposer23), (String) null, (Modifier) null, 0L, gapComposer23, 56, 12);
                } else {
                    gapComposer23.skipToGroupEnd();
                }
                return unit;
            case 25:
                Composer composer24 = (Composer) obj;
                int iIntValue24 = ((Integer) obj2).intValue();
                GapComposer gapComposer24 = (GapComposer) composer24;
                if (gapComposer24.shouldExecute(iIntValue24 & 1, (iIntValue24 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.playlist_play, 0, gapComposer24), (String) null, (Modifier) null, 0L, gapComposer24, 56, 12);
                } else {
                    gapComposer24.skipToGroupEnd();
                }
                return unit;
            case 26:
                Composer composer25 = (Composer) obj;
                int iIntValue25 = ((Integer) obj2).intValue();
                GapComposer gapComposer25 = (GapComposer) composer25;
                if (gapComposer25.shouldExecute(iIntValue25 & 1, (iIntValue25 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.queue_music, 0, gapComposer25), (String) null, (Modifier) null, 0L, gapComposer25, 56, 12);
                } else {
                    gapComposer25.skipToGroupEnd();
                }
                return unit;
            case 27:
                Composer composer26 = (Composer) obj;
                int iIntValue26 = ((Integer) obj2).intValue();
                GapComposer gapComposer26 = (GapComposer) composer26;
                if (gapComposer26.shouldExecute(iIntValue26 & 1, (iIntValue26 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.close, 0, gapComposer26), (String) null, (Modifier) null, 0L, gapComposer26, 56, 12);
                } else {
                    gapComposer26.skipToGroupEnd();
                }
                return unit;
            case 28:
                Composer composer27 = (Composer) obj;
                int iIntValue27 = ((Integer) obj2).intValue();
                GapComposer gapComposer27 = (GapComposer) composer27;
                if (gapComposer27.shouldExecute(iIntValue27 & 1, (iIntValue27 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer27), (String) null, (Modifier) null, ((Color) gapComposer27.consume(ContentColorKt.LocalContentColor)).value, gapComposer27, 56, 4);
                } else {
                    gapComposer27.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer28 = (Composer) obj;
                int iIntValue28 = ((Integer) obj2).intValue();
                GapComposer gapComposer28 = (GapComposer) composer28;
                if (gapComposer28.shouldExecute(iIntValue28 & 1, (iIntValue28 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer28), (String) null, (Modifier) null, 0L, gapComposer28, 56, 12);
                } else {
                    gapComposer28.skipToGroupEnd();
                }
                return unit;
        }
    }
}
