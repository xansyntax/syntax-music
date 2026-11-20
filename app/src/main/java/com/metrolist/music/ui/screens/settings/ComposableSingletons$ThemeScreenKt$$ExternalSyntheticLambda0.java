package com.metrolist.music.ui.screens.settings;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.AspectRatioElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComposableSingletons$ThemeScreenKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ComposableSingletons$ThemeScreenKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
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
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.theme_colors, gapComposer), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.content, gapComposer2), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262142);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.ai_lyrics_translation, gapComposer3), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                }
                break;
            case 3:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.android_auto, gapComposer4), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262142);
                }
                break;
            case 4:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.privacy, gapComposer5), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262142);
                }
                break;
            case 5:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.cache_size_warning_title, gapComposer6), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 0, 0, 262142);
                }
                break;
            case 6:
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.downloaded_songs, gapComposer7), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer7, 0, 0, 262142);
                }
                break;
            case 7:
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.clear_all_downloads, gapComposer8), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer8, 0, 0, 262142);
                }
                break;
            case 8:
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (!gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.enable_song_cache, gapComposer9), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer9, 0, 0, 262142);
                }
                break;
            case 9:
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (!gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                    gapComposer10.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.enable_song_cache_desc, gapComposer10), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer10, 0, 0, 262142);
                }
                break;
            case 10:
                Composer composer11 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (!gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 3) != 2)) {
                    gapComposer11.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.max_song_cache_size, gapComposer11), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer11, 0, 0, 262142);
                }
                break;
            case 11:
                Composer composer12 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (!gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 3) != 2)) {
                    gapComposer12.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.clear_song_cache, gapComposer12), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer12, 0, 0, 262142);
                }
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer13 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (!gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 3) != 2)) {
                    gapComposer13.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.max_image_cache_size, gapComposer13), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer13, 0, 0, 262142);
                }
                break;
            case 13:
                Composer composer14 = (Composer) obj;
                int iIntValue14 = ((Integer) obj2).intValue();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (!gapComposer14.shouldExecute(iIntValue14 & 1, (iIntValue14 & 3) != 2)) {
                    gapComposer14.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.clear_image_cache, gapComposer14), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer14, 0, 0, 262142);
                }
                break;
            case 14:
                Composer composer15 = (Composer) obj;
                int iIntValue15 = ((Integer) obj2).intValue();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (!gapComposer15.shouldExecute(iIntValue15 & 1, (iIntValue15 & 3) != 2)) {
                    gapComposer15.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.storage, gapComposer15), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer15, 0, 0, 262142);
                }
                break;
            case 15:
                Composer composer16 = (Composer) obj;
                int iIntValue16 = ((Integer) obj2).intValue();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (!gapComposer16.shouldExecute(iIntValue16 & 1, (iIntValue16 & 3) != 2)) {
                    gapComposer16.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.arrow_back, 0, gapComposer16), (String) null, (Modifier) null, 0L, gapComposer16, 56, 12);
                }
                break;
            case 16:
                Composer composer17 = (Composer) obj;
                int iIntValue17 = ((Integer) obj2).intValue();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (!gapComposer17.shouldExecute(iIntValue17 & 1, (iIntValue17 & 3) != 2)) {
                    gapComposer17.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.arrow_back, 0, gapComposer17), MathKt.stringResource(R.string.cd_back, gapComposer17), (Modifier) null, 0L, gapComposer17, 8, 12);
                }
                break;
            case 17:
                Composer composer18 = (Composer) obj;
                int iIntValue18 = ((Integer) obj2).intValue();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (!gapComposer18.shouldExecute(iIntValue18 & 1, (iIntValue18 & 3) != 2)) {
                    gapComposer18.skipToGroupEnd();
                } else {
                    Modifier modifierThen = SizeKt.FillWholeMaxSize.then(new AspectRatioElement(0.5f));
                    RoundedCornerShape roundedCornerShapeM1480glassShapeixp7dh8 = GlassComponentsKt.m1480glassShapeixp7dh8(22.0f, 16.0f, gapComposer18);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    CardKt.Card(modifierThen, roundedCornerShapeM1480glassShapeixp7dh8, CardKt.m267cardColorsro_MJ88(((MaterialTheme$Values) gapComposer18.consume(staticProvidableCompositionLocal)).colorScheme.surface, 0L, gapComposer18, 14), CardKt.m268cardElevationaqJV_2Y(CropImageView.DEFAULT_ASPECT_RATIO), ImageKt.m38BorderStrokecXLIe8U(((MaterialTheme$Values) gapComposer18.consume(staticProvidableCompositionLocal)).colorScheme.outlineVariant, 1.0f), AiSettingsKt.lambda$1805130297, gapComposer18, 196614, 0);
                }
                break;
            case 18:
                Composer composer19 = (Composer) obj;
                int iIntValue19 = ((Integer) obj2).intValue();
                GapComposer gapComposer19 = (GapComposer) composer19;
                if (!gapComposer19.shouldExecute(iIntValue19 & 1, (iIntValue19 & 3) != 2)) {
                    gapComposer19.skipToGroupEnd();
                } else {
                    FillElement fillElement = SizeKt.FillWholeMaxSize;
                    RoundedCornerShape roundedCornerShapeM1480glassShapeixp7dh9 = GlassComponentsKt.m1480glassShapeixp7dh8(22.0f, 12.0f, gapComposer19);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    CardKt.Card(fillElement, roundedCornerShapeM1480glassShapeixp7dh9, CardKt.m267cardColorsro_MJ88(((MaterialTheme$Values) gapComposer19.consume(staticProvidableCompositionLocal2)).colorScheme.surface, 0L, gapComposer19, 14), CardKt.m268cardElevationaqJV_2Y(CropImageView.DEFAULT_ASPECT_RATIO), ImageKt.m38BorderStrokecXLIe8U(((MaterialTheme$Values) gapComposer19.consume(staticProvidableCompositionLocal2)).colorScheme.outlineVariant, 1.0f), AiSettingsKt.lambda$748570228, gapComposer19, 196614, 0);
                }
                break;
            case 19:
                Composer composer20 = (Composer) obj;
                int iIntValue20 = ((Integer) obj2).intValue();
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (!gapComposer20.shouldExecute(iIntValue20 & 1, (iIntValue20 & 3) != 2)) {
                    gapComposer20.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.version_format, new Object[]{"4.1.0"}, gapComposer20), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer20, 0, 0, 262142);
                }
                break;
            case 20:
                Composer composer21 = (Composer) obj;
                int iIntValue21 = ((Integer) obj2).intValue();
                GapComposer gapComposer21 = (GapComposer) composer21;
                if (!gapComposer21.shouldExecute(iIntValue21 & 1, (iIntValue21 & 3) != 2)) {
                    gapComposer21.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk("universal - FOSS", null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer21, 0, 0, 262142);
                }
                break;
            case 21:
                Composer composer22 = (Composer) obj;
                int iIntValue22 = ((Integer) obj2).intValue();
                GapComposer gapComposer22 = (GapComposer) composer22;
                if (!gapComposer22.shouldExecute(iIntValue22 & 1, (iIntValue22 & 3) != 2)) {
                    gapComposer22.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.check_for_updates, gapComposer22), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer22, 0, 0, 262142);
                }
                break;
            case 22:
                Composer composer23 = (Composer) obj;
                int iIntValue23 = ((Integer) obj2).intValue();
                GapComposer gapComposer23 = (GapComposer) composer23;
                if (!gapComposer23.shouldExecute(iIntValue23 & 1, (iIntValue23 & 3) != 2)) {
                    gapComposer23.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.update_notifications, gapComposer23), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer23, 0, 0, 262142);
                }
                break;
            case 23:
                Composer composer24 = (Composer) obj;
                int iIntValue24 = ((Integer) obj2).intValue();
                GapComposer gapComposer24 = (GapComposer) composer24;
                if (!gapComposer24.shouldExecute(iIntValue24 & 1, (iIntValue24 & 3) != 2)) {
                    gapComposer24.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.updater, gapComposer24), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer24, 0, 0, 262142);
                }
                break;
            case 24:
                Composer composer25 = (Composer) obj;
                int iIntValue25 = ((Integer) obj2).intValue();
                GapComposer gapComposer25 = (GapComposer) composer25;
                if (!gapComposer25.shouldExecute(iIntValue25 & 1, (iIntValue25 & 3) != 2)) {
                    gapComposer25.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.arrow_back, 0, gapComposer25), (String) null, (Modifier) null, 0L, gapComposer25, 56, 12);
                }
                break;
            case 25:
                Composer composer26 = (Composer) obj;
                int iIntValue26 = ((Integer) obj2).intValue();
                GapComposer gapComposer26 = (GapComposer) composer26;
                if (!gapComposer26.shouldExecute(iIntValue26 & 1, (iIntValue26 & 3) != 2)) {
                    gapComposer26.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.arrow_back, 0, gapComposer26), (String) null, (Modifier) null, 0L, gapComposer26, 56, 12);
                }
                break;
            case 26:
                Composer composer27 = (Composer) obj;
                int iIntValue27 = ((Integer) obj2).intValue();
                GapComposer gapComposer27 = (GapComposer) composer27;
                if (!gapComposer27.shouldExecute(iIntValue27 & 1, (iIntValue27 & 3) != 2)) {
                    gapComposer27.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.enable_discord_rpc, gapComposer27), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer27, 0, 0, 262142);
                }
                break;
            case 27:
                Composer composer28 = (Composer) obj;
                int iIntValue28 = ((Integer) obj2).intValue();
                GapComposer gapComposer28 = (GapComposer) composer28;
                if (!gapComposer28.shouldExecute(iIntValue28 & 1, (iIntValue28 & 3) != 2)) {
                    gapComposer28.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.discord_advanced_mode, gapComposer28), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer28, 0, 0, 262142);
                }
                break;
            case 28:
                Composer composer29 = (Composer) obj;
                int iIntValue29 = ((Integer) obj2).intValue();
                GapComposer gapComposer29 = (GapComposer) composer29;
                if (!gapComposer29.shouldExecute(iIntValue29 & 1, (iIntValue29 & 3) != 2)) {
                    gapComposer29.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.discord_advanced_mode_description, gapComposer29), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer29, 0, 0, 262142);
                }
                break;
            default:
                Composer composer30 = (Composer) obj;
                int iIntValue30 = ((Integer) obj2).intValue();
                GapComposer gapComposer30 = (GapComposer) composer30;
                if (!gapComposer30.shouldExecute(iIntValue30 & 1, (iIntValue30 & 3) != 2)) {
                    gapComposer30.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.discord_activity_type, gapComposer30), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer30, 0, 0, 262142);
                }
                break;
        }
        return unit;
    }
}
