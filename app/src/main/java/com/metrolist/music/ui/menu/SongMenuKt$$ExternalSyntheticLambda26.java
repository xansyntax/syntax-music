package com.metrolist.music.ui.menu;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SegmentedButtonDefaults;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.text.font.FontWeight;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.ui.screens.ListenTogetherScreenKt;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt;
import com.yalantis.ucrop.R;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda26 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda26(byte b, boolean z) {
        this.$r8$classId = b;
        this.f$0 = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        long j;
        long j2;
        long j3;
        long jColor;
        byte b = this.$r8$classId;
        int i = R.drawable.library_add_check;
        int i2 = R.drawable.favorite_border;
        int i3 = R.drawable.album;
        int i4 = R.string.view_album;
        int i5 = R.drawable.close;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
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
                        i2 = R.drawable.favorite;
                    }
                    Painter painterPainterResource = IntMath.painterResource(i2, 0, gapComposer);
                    if (z) {
                        gapComposer.startReplaceGroup(1727669594);
                        j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error;
                    } else {
                        gapComposer.startReplaceGroup(1727670524);
                        j = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
                    }
                    gapComposer.end(false);
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, (Modifier) null, j, gapComposer, 56, 4);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    SegmentedButtonDefaults.INSTANCE.Icon(z, null, gapComposer2, 3072);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    if (z) {
                        i5 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer3), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer3, 56, 8);
                }
                break;
            case 3:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.mic;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer4), (String) null, SizeKt.m151size3ABfNKs(companion, 24.0f), 0L, gapComposer4, 440, 8);
                }
                break;
            case 4:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    if (z) {
                        i4 = R.string.view_podcast;
                    }
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(i4, gapComposer5), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262142);
                }
                break;
            case 5:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    if (!z) {
                        i = R.drawable.library_add;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer6), (String) null, SizeKt.m151size3ABfNKs(companion, 24.0f), 0L, gapComposer6, 440, 8);
                }
                break;
            case 6:
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(z ? R.string.remove_from_library : R.string.add_to_library, gapComposer7), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer7, 0, 0, 262142);
                }
                break;
            case 7:
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    if (z) {
                        i2 = R.drawable.favorite;
                    }
                    Painter painterPainterResource2 = IntMath.painterResource(i2, 0, gapComposer8);
                    if (z) {
                        gapComposer8.startReplaceGroup(657937037);
                        j2 = ((MaterialTheme$Values) gapComposer8.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error;
                        gapComposer8.end(false);
                    } else {
                        gapComposer8.startReplaceGroup(657938607);
                        j2 = ((Color) gapComposer8.consume(ContentColorKt.LocalContentColor)).value;
                        gapComposer8.end(false);
                    }
                    IconKt.m290Iconww6aTOc(painterPainterResource2, (String) null, (Modifier) null, j2, gapComposer8, 56, 4);
                }
                break;
            case 8:
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (!gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    if (!z) {
                        i = R.drawable.library_add;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer9), (String) null, (Modifier) null, 0L, gapComposer9, 56, 12);
                }
                break;
            case 9:
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (!gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                    gapComposer10.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(z ? R.string.remove_episode_from_saved : R.string.save_episode_for_later, gapComposer10), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer10, 0, 0, 262142);
                }
                break;
            case 10:
                Composer composer11 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (!gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 3) != 2)) {
                    gapComposer11.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.mic;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer11), (String) null, (Modifier) null, 0L, gapComposer11, 56, 12);
                }
                break;
            case 11:
                Composer composer12 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (!gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 3) != 2)) {
                    gapComposer12.skipToGroupEnd();
                } else {
                    if (z) {
                        i4 = R.string.view_podcast;
                    }
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(i4, gapComposer12), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer12, 0, 0, 262142);
                }
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer13 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (!gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 3) != 2)) {
                    gapComposer13.skipToGroupEnd();
                } else {
                    if (!z) {
                        i = R.drawable.library_add;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer13), (String) null, (Modifier) null, 0L, gapComposer13, 56, 12);
                }
                break;
            case 13:
                Composer composer14 = (Composer) obj;
                int iIntValue14 = ((Integer) obj2).intValue();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (!gapComposer14.shouldExecute(iIntValue14 & 1, (iIntValue14 & 3) != 2)) {
                    gapComposer14.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(z ? R.string.subscribed : R.string.subscribe_to_podcast, gapComposer14), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer14, 0, 0, 262142);
                }
                break;
            case 14:
                Composer composer15 = (Composer) obj;
                int iIntValue15 = ((Integer) obj2).intValue();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (!gapComposer15.shouldExecute(iIntValue15 & 1, (iIntValue15 & 3) != 2)) {
                    gapComposer15.skipToGroupEnd();
                } else {
                    if (z) {
                        i2 = R.drawable.favorite;
                    }
                    Painter painterPainterResource3 = IntMath.painterResource(i2, 0, gapComposer15);
                    if (z) {
                        gapComposer15.startReplaceGroup(-116622128);
                        j3 = ((MaterialTheme$Values) gapComposer15.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error;
                    } else {
                        gapComposer15.startReplaceGroup(-116621198);
                        j3 = ((Color) gapComposer15.consume(ContentColorKt.LocalContentColor)).value;
                    }
                    gapComposer15.end(false);
                    IconKt.m290Iconww6aTOc(painterPainterResource3, (String) null, (Modifier) null, j3, gapComposer15, 56, 4);
                }
                break;
            case 15:
                Composer composer16 = (Composer) obj;
                int iIntValue16 = ((Integer) obj2).intValue();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (!gapComposer16.shouldExecute(iIntValue16 & 1, (iIntValue16 & 3) != 2)) {
                    gapComposer16.skipToGroupEnd();
                } else {
                    if (z) {
                        i3 = R.drawable.mic;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i3, 0, gapComposer16), (String) null, (Modifier) null, 0L, gapComposer16, 56, 12);
                }
                break;
            case 16:
                Composer composer17 = (Composer) obj;
                int iIntValue17 = ((Integer) obj2).intValue();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (!gapComposer17.shouldExecute(iIntValue17 & 1, (iIntValue17 & 3) != 2)) {
                    gapComposer17.skipToGroupEnd();
                } else {
                    if (z) {
                        i4 = R.string.view_podcast;
                    }
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(i4, gapComposer17), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer17, 0, 0, 262142);
                }
                break;
            case 17:
                Composer composer18 = (Composer) obj;
                int iIntValue18 = ((Integer) obj2).intValue();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (!gapComposer18.shouldExecute(iIntValue18 & 1, (iIntValue18 & 3) != 2)) {
                    gapComposer18.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer18), MathKt.stringResource(R.string.more_options, gapComposer18), SizeKt.m151size3ABfNKs(companion, z ? 22.0f : 24.0f), ((MaterialTheme$Values) gapComposer18.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface, gapComposer18, 8, 0);
                }
                break;
            case 18:
                ((Integer) obj2).getClass();
                ListenTogetherScreenKt.HeaderSection(z, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 19:
                ((Integer) obj2).getClass();
                ListenTogetherScreenKt.HeaderSection(z, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 20:
                Composer composer19 = (Composer) obj;
                int iIntValue19 = ((Integer) obj2).intValue();
                GapComposer gapComposer19 = (GapComposer) composer19;
                if (!gapComposer19.shouldExecute(iIntValue19 & 1, (iIntValue19 & 3) != 2)) {
                    gapComposer19.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(z ? R.string.switch_youtube_channel : R.string.login, gapComposer19), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer19, 0, 0, 262142);
                }
                break;
            case 21:
                Composer composer20 = (Composer) obj;
                int iIntValue20 = ((Integer) obj2).intValue();
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (!gapComposer20.shouldExecute(iIntValue20 & 1, (iIntValue20 & 3) != 2)) {
                    gapComposer20.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.eq_disabled, gapComposer20), null, 0L, 0L, null, z ? FontWeight.SemiBold : FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer20, 0, 0, 262078);
                }
                break;
            case 22:
                Composer composer21 = (Composer) obj;
                int iIntValue21 = ((Integer) obj2).intValue();
                GapComposer gapComposer21 = (GapComposer) composer21;
                if (!gapComposer21.shouldExecute(iIntValue21 & 1, (iIntValue21 & 3) != 2)) {
                    gapComposer21.skipToGroupEnd();
                } else {
                    if (z) {
                        i5 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer21), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer21, 56, 8);
                }
                break;
            case 23:
                ((Integer) obj2).getClass();
                AlarmSettingsKt.AlarmSettingsSection(z, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 24:
                Composer composer22 = (Composer) obj;
                int iIntValue22 = ((Integer) obj2).intValue();
                GapComposer gapComposer22 = (GapComposer) composer22;
                if (!gapComposer22.shouldExecute(iIntValue22 & 1, (iIntValue22 & 3) != 2)) {
                    gapComposer22.skipToGroupEnd();
                } else {
                    if (z) {
                        i5 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer22), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer22, 56, 8);
                }
                break;
            case 25:
                Composer composer23 = (Composer) obj;
                int iIntValue23 = ((Integer) obj2).intValue();
                GapComposer gapComposer23 = (GapComposer) composer23;
                if (!gapComposer23.shouldExecute(iIntValue23 & 1, (iIntValue23 & 3) != 2)) {
                    gapComposer23.skipToGroupEnd();
                } else {
                    String strStringResource = MathKt.stringResource(R.string.mini_player_background_style, gapComposer23);
                    if (z) {
                        gapComposer23.startReplaceGroup(-1972054005);
                        jColor = ((MaterialTheme$Values) gapComposer23.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface;
                        gapComposer23.end(false);
                    } else {
                        gapComposer23.startReplaceGroup(-1972201193);
                        long j4 = ((MaterialTheme$Values) gapComposer23.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface;
                        jColor = ColorKt.Color(Color.m485getRedimpl(j4), Color.m484getGreenimpl(j4), Color.m482getBlueimpl(j4), 0.38f, Color.m483getColorSpaceimpl(j4));
                        gapComposer23.end(false);
                    }
                    TextKt.m352TextNvy7gAk(strStringResource, null, jColor, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer23, 0, 0, 262138);
                }
                break;
            case 26:
                Composer composer24 = (Composer) obj;
                int iIntValue24 = ((Integer) obj2).intValue();
                GapComposer gapComposer24 = (GapComposer) composer24;
                if (!gapComposer24.shouldExecute(iIntValue24 & 1, (iIntValue24 & 3) != 2)) {
                    gapComposer24.skipToGroupEnd();
                } else {
                    if (z) {
                        i5 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer24), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer24, 56, 8);
                }
                break;
            case 27:
                Composer composer25 = (Composer) obj;
                int iIntValue25 = ((Integer) obj2).intValue();
                GapComposer gapComposer25 = (GapComposer) composer25;
                if (!gapComposer25.shouldExecute(iIntValue25 & 1, (iIntValue25 & 3) != 2)) {
                    gapComposer25.skipToGroupEnd();
                } else {
                    if (z) {
                        i5 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer25), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer25, 56, 8);
                }
                break;
            case 28:
                Composer composer26 = (Composer) obj;
                int iIntValue26 = ((Integer) obj2).intValue();
                GapComposer gapComposer26 = (GapComposer) composer26;
                if (!gapComposer26.shouldExecute(iIntValue26 & 1, (iIntValue26 & 3) != 2)) {
                    gapComposer26.skipToGroupEnd();
                } else {
                    if (z) {
                        i5 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer26), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer26, 56, 8);
                }
                break;
            default:
                Composer composer27 = (Composer) obj;
                int iIntValue27 = ((Integer) obj2).intValue();
                GapComposer gapComposer27 = (GapComposer) composer27;
                if (!gapComposer27.shouldExecute(iIntValue27 & 1, (iIntValue27 & 3) != 2)) {
                    gapComposer27.skipToGroupEnd();
                } else {
                    if (z) {
                        i5 = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i5, 0, gapComposer27), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer27, 56, 8);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda26(boolean z, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = z;
    }
}
