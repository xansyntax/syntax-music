package com.metrolist.music;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.style.TextAlign;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.lyrics.LyricsEntry;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.DraggableLyricsProviderItem;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda30 implements Function2 {
    public final /* synthetic */ byte $r8$classId;

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        long jColor;
        long jColor2;
        long jColor3;
        byte b = this.$r8$classId;
        RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = ColorKt.RectangleShape;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int i = MainActivity.$r8$clinit;
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                    return unit;
                }
                Modifier modifierScroll$default = ImageKt.scroll$default(SizeKt.m147heightInVpY3zN4$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, 480.0f, 1), ImageKt.rememberScrollState(gapComposer), true);
                ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
                int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierScroll$default);
                ComposeUiNode.Companion.getClass();
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(LayoutNode.Constructor);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                Stack.m389reconcileimpl(gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                throw null;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.update_available_title, gapComposer2), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262142);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 2:
                MediaMetadata mediaMetadata = (MediaMetadata) obj;
                MediaMetadata mediaMetadata2 = (MediaMetadata) obj2;
                return Boolean.valueOf(Intrinsics.areEqual(mediaMetadata != null ? mediaMetadata.id : null, mediaMetadata2 != null ? mediaMetadata2.id : null));
            case 3:
                ((Integer) obj2).getClass();
                GapComposer gapComposer3 = (GapComposer) ((Composer) obj);
                gapComposer3.startReplaceGroup(-1352765746);
                WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                LimitInsets limitInsets = new LimitInsets(OffsetKt.current(gapComposer3).safeDrawing, 48);
                gapComposer3.end(false);
                return limitInsets;
            case 4:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer3;
                if (gapComposer4.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    Modifier modifierClip = ClipKt.clip(SizeKt.m152sizeVpY3zN4(OffsetKt.m137paddingVpY3zN4$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, 1), 40.0f, 4.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(2.0f));
                    if (UiStyleKt.isGlassStyle(gapComposer4)) {
                        gapComposer4.startReplaceGroup(-19632693);
                        gapComposer4.end(false);
                        jColor = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.7f, Color.m483getColorSpaceimpl(-4294967296L));
                    } else {
                        gapComposer4.startReplaceGroup(-19631097);
                        jColor = ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
                        gapComposer4.end(false);
                    }
                    BoxKt.Box(ImageKt.m39backgroundbw27NRU(modifierClip, jColor, rectangleShapeKt$RectangleShape$1), gapComposer4, 0);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 5:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer4;
                if (gapComposer5.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    Modifier modifierClip2 = ClipKt.clip(SizeKt.m152sizeVpY3zN4(OffsetKt.m137paddingVpY3zN4$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, 1), 40.0f, 4.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(2.0f));
                    if (UiStyleKt.isGlassStyle(gapComposer5)) {
                        gapComposer5.startReplaceGroup(-261953837);
                        gapComposer5.end(false);
                        jColor2 = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.7f, Color.m483getColorSpaceimpl(-4294967296L));
                    } else {
                        gapComposer5.startReplaceGroup(-261952241);
                        jColor2 = ((MaterialTheme$Values) gapComposer5.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
                        gapComposer5.end(false);
                    }
                    BoxKt.Box(ImageKt.m39backgroundbw27NRU(modifierClip2, jColor2, rectangleShapeKt$RectangleShape$1), gapComposer5, 0);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 6:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer5;
                if (gapComposer6.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    Modifier modifierClip3 = ClipKt.clip(SizeKt.m152sizeVpY3zN4(OffsetKt.m137paddingVpY3zN4$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, 1), 32.0f, 4.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(2.0f));
                    if (UiStyleKt.isGlassStyle(gapComposer6)) {
                        gapComposer6.startReplaceGroup(-1842258575);
                        gapComposer6.end(false);
                        jColor3 = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.7f, Color.m483getColorSpaceimpl(-4294967296L));
                    } else {
                        gapComposer6.startReplaceGroup(-1842256979);
                        jColor3 = ((MaterialTheme$Values) gapComposer6.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
                        gapComposer6.end(false);
                    }
                    BoxKt.Box(ImageKt.m39backgroundbw27NRU(modifierClip3, jColor3, rectangleShapeKt$RectangleShape$1), gapComposer6, 0);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 7:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer6;
                if (gapComposer7.shouldExecute(1 & iIntValue6, (iIntValue6 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.add, 0, gapComposer7), (String) null, (Modifier) null, 0L, gapComposer7, 56, 12);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 8:
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer7;
                if (gapComposer8.shouldExecute(1 & iIntValue7, (iIntValue7 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.create_playlist, gapComposer8), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer8, 0, 0, 262142);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 9:
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer8;
                if (gapComposer9.shouldExecute(1 & iIntValue8, (iIntValue8 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.drag_handle, 0, gapComposer9), (String) null, (Modifier) null, ((MaterialTheme$Values) gapComposer9.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant, gapComposer9, 56, 4);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 10:
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer9;
                if (gapComposer10.shouldExecute(1 & iIntValue9, (iIntValue9 & 3) != 2)) {
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    CardKt.Card(null, ((MaterialTheme$Values) gapComposer10.consume(staticProvidableCompositionLocal)).shapes.medium, CardKt.m267cardColorsro_MJ88(((MaterialTheme$Values) gapComposer10.consume(staticProvidableCompositionLocal)).colorScheme.surface, 0L, gapComposer10, 14), null, null, DialogKt.f21lambda$1502782614, gapComposer10, 196608, 25);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 11:
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer10;
                if (gapComposer11.shouldExecute(1 & iIntValue10, (iIntValue10 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.mic, 0, gapComposer11), MathKt.stringResource(R.string.recognize_music, gapComposer11), SizeKt.m151size3ABfNKs(companion, 20.0f), 0L, gapComposer11, 392, 8);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer11 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer11;
                if (gapComposer12.shouldExecute(1 & iIntValue11, (iIntValue11 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer12), (String) null, (Modifier) null, 0L, gapComposer12, 56, 12);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case 13:
                Composer composer12 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer12;
                if (gapComposer13.shouldExecute(1 & iIntValue12, (iIntValue12 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer13), (String) null, (Modifier) null, 0L, gapComposer13, 56, 12);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 14:
                Composer composer13 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer14 = (GapComposer) composer13;
                if (gapComposer14.shouldExecute(1 & iIntValue13, (iIntValue13 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer14), (String) null, (Modifier) null, 0L, gapComposer14, 56, 12);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 15:
                Composer composer14 = (Composer) obj;
                int iIntValue14 = ((Integer) obj2).intValue();
                GapComposer gapComposer15 = (GapComposer) composer14;
                if (gapComposer15.shouldExecute(1 & iIntValue14, (iIntValue14 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.search_library, gapComposer15), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer15.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium, gapComposer15, 0, 0, 131070);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 16:
                Composer composer15 = (Composer) obj;
                int iIntValue15 = ((Integer) obj2).intValue();
                GapComposer gapComposer16 = (GapComposer) composer15;
                if (gapComposer16.shouldExecute(1 & iIntValue15, (iIntValue15 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.close, 0, gapComposer16), MathKt.stringResource(R.string.close, gapComposer16), (Modifier) null, 0L, gapComposer16, 8, 12);
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 17:
                Composer composer16 = (Composer) obj;
                int iIntValue16 = ((Integer) obj2).intValue();
                GapComposer gapComposer17 = (GapComposer) composer16;
                if (gapComposer17.shouldExecute(1 & iIntValue16, (iIntValue16 & 3) != 2)) {
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    CardKt.Card(null, ((MaterialTheme$Values) gapComposer17.consume(staticProvidableCompositionLocal2)).shapes.medium, CardKt.m267cardColorsro_MJ88(((MaterialTheme$Values) gapComposer17.consume(staticProvidableCompositionLocal2)).colorScheme.surface, 0L, gapComposer17, 14), CardKt.m268cardElevationaqJV_2Y(8.0f), null, DialogKt.lambda$1007107521, gapComposer17, 196608, 17);
                } else {
                    gapComposer17.skipToGroupEnd();
                }
                return unit;
            case 18:
                Composer composer17 = (Composer) obj;
                int iIntValue17 = ((Integer) obj2).intValue();
                GapComposer gapComposer18 = (GapComposer) composer17;
                if (gapComposer18.shouldExecute(1 & iIntValue17, (iIntValue17 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.sleep_timer_daily, gapComposer18), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer18, 0, 0, 262142);
                } else {
                    gapComposer18.skipToGroupEnd();
                }
                return unit;
            case 19:
                Composer composer18 = (Composer) obj;
                int iIntValue18 = ((Integer) obj2).intValue();
                GapComposer gapComposer19 = (GapComposer) composer18;
                if (gapComposer19.shouldExecute(1 & iIntValue18, (iIntValue18 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.sleep_timer_weekdays_weekends, gapComposer19), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer19, 0, 0, 262142);
                } else {
                    gapComposer19.skipToGroupEnd();
                }
                return unit;
            case 20:
                Composer composer19 = (Composer) obj;
                int iIntValue19 = ((Integer) obj2).intValue();
                GapComposer gapComposer20 = (GapComposer) composer19;
                if (gapComposer20.shouldExecute(1 & iIntValue19, (iIntValue19 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.sleep_timer_custom, gapComposer20), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer20, 0, 0, 262142);
                } else {
                    gapComposer20.skipToGroupEnd();
                }
                return unit;
            case 21:
                Composer composer20 = (Composer) obj;
                int iIntValue20 = ((Integer) obj2).intValue();
                GapComposer gapComposer21 = (GapComposer) composer20;
                if (!gapComposer21.shouldExecute(1 & iIntValue20, (iIntValue20 & 3) != 2)) {
                    gapComposer21.skipToGroupEnd();
                }
                return unit;
            case 22:
                Composer composer21 = (Composer) obj;
                int iIntValue21 = ((Integer) obj2).intValue();
                GapComposer gapComposer22 = (GapComposer) composer21;
                if (gapComposer22.shouldExecute(1 & iIntValue21, (iIntValue21 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.time_transfer_title, gapComposer22), SizeKt.fillMaxWidth(companion, 1.0f), 0L, 0L, null, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, null, gapComposer22, 48, 0, 261116);
                } else {
                    gapComposer22.skipToGroupEnd();
                }
                return unit;
            case 23:
                ((Integer) obj).getClass();
                DraggableLyricsProviderItem draggableLyricsProviderItem = (DraggableLyricsProviderItem) obj2;
                draggableLyricsProviderItem.getClass();
                return draggableLyricsProviderItem.id;
            case 24:
                int iIntValue22 = ((Integer) obj).intValue();
                LyricsEntry lyricsEntry = (LyricsEntry) obj2;
                lyricsEntry.getClass();
                return iIntValue22 + "-" + lyricsEntry.time;
            case 25:
                Composer composer22 = (Composer) obj;
                int iIntValue23 = ((Integer) obj2).intValue();
                GapComposer gapComposer23 = (GapComposer) composer22;
                if (gapComposer23.shouldExecute(1 & iIntValue23, (iIntValue23 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.duplicates, gapComposer23), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer23, 0, 0, 262142);
                } else {
                    gapComposer23.skipToGroupEnd();
                }
                return unit;
            case 26:
                Composer composer23 = (Composer) obj;
                int iIntValue24 = ((Integer) obj2).intValue();
                GapComposer gapComposer24 = (GapComposer) composer23;
                if (gapComposer24.shouldExecute(1 & iIntValue24, (iIntValue24 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.duplicates, gapComposer24), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer24, 0, 0, 262142);
                } else {
                    gapComposer24.skipToGroupEnd();
                }
                return unit;
            case 27:
                Composer composer24 = (Composer) obj;
                int iIntValue25 = ((Integer) obj2).intValue();
                GapComposer gapComposer25 = (GapComposer) composer24;
                if (gapComposer25.shouldExecute(1 & iIntValue25, (iIntValue25 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.action_download, gapComposer25), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer25, 0, 0, 262142);
                } else {
                    gapComposer25.skipToGroupEnd();
                }
                return unit;
            case 28:
                Composer composer25 = (Composer) obj;
                int iIntValue26 = ((Integer) obj2).intValue();
                GapComposer gapComposer26 = (GapComposer) composer25;
                if (gapComposer26.shouldExecute(1 & iIntValue26, (iIntValue26 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.play, 0, gapComposer26), (String) null, SizeKt.m151size3ABfNKs(companion, 28.0f), ((MaterialTheme$Values) gapComposer26.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant, gapComposer26, 440, 0);
                } else {
                    gapComposer26.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer26 = (Composer) obj;
                int iIntValue27 = ((Integer) obj2).intValue();
                GapComposer gapComposer27 = (GapComposer) composer26;
                if (gapComposer27.shouldExecute(1 & iIntValue27, (iIntValue27 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.download_desc, gapComposer27), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer27, 0, 0, 262142);
                } else {
                    gapComposer27.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda30(byte b) {
        this.$r8$classId = b;
    }
}
