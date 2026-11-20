package com.metrolist.music.ui.player;

import android.R;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SliderState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.Modifier;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComposableSingletons$PlayerKt$$ExternalSyntheticLambda0 implements Function3 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ComposableSingletons$PlayerKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.ok, gapComposer), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.cancel, gapComposer2), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262142);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.ok, gapComposer3), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                }
                break;
            case 3:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(com.yalantis.ucrop.R.string.remove_download_playlist_confirm, new Object[]{"selection"}, gapComposer4), OffsetKt.m137paddingVpY3zN4$default(companion, 18.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer4, 48, 0, 131068);
                }
                break;
            case 4:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    OffsetKt.Spacer(gapComposer5, SizeKt.m145height3ABfNKs(companion, 12.0f));
                }
                break;
            case 5:
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.cancel, gapComposer6), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 0, 0, 262142);
                }
                break;
            case 6:
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(com.yalantis.ucrop.R.string.delete, gapComposer7), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer7, 0, 0, 262142);
                }
                break;
            case 7:
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    OffsetKt.Spacer(gapComposer8, SizeKt.m145height3ABfNKs(companion, 12.0f));
                }
                break;
            case 8:
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (!gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    OffsetKt.Spacer(gapComposer9, SizeKt.m145height3ABfNKs(companion, 12.0f));
                }
                break;
            case 9:
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (!gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    gapComposer10.skipToGroupEnd();
                } else {
                    OffsetKt.Spacer(gapComposer10, SizeKt.m145height3ABfNKs(companion, 12.0f));
                }
                break;
            case 10:
                Composer composer11 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (!gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 17) != 16)) {
                    gapComposer11.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(com.yalantis.ucrop.R.string.cancel, gapComposer11), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer11, 0, 0, 262142);
                }
                break;
            case 11:
                Composer composer12 = (Composer) obj2;
                int iIntValue12 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (!gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 17) != 16)) {
                    gapComposer12.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(com.yalantis.ucrop.R.string.delete_uploaded_song_confirm, gapComposer12), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer12.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, gapComposer12, 0, 0, 131070);
                }
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer13 = (Composer) obj2;
                int iIntValue13 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (!gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 17) != 16)) {
                    gapComposer13.skipToGroupEnd();
                }
                break;
            case 13:
                Composer composer14 = (Composer) obj2;
                int iIntValue14 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (!gapComposer14.shouldExecute(iIntValue14 & 1, (iIntValue14 & 17) != 16)) {
                    gapComposer14.skipToGroupEnd();
                } else {
                    OffsetKt.Spacer(gapComposer14, SizeKt.m145height3ABfNKs(companion, 12.0f));
                }
                break;
            case 14:
                Composer composer15 = (Composer) obj2;
                int iIntValue15 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (!gapComposer15.shouldExecute(iIntValue15 & 1, (iIntValue15 & 17) != 16)) {
                    gapComposer15.skipToGroupEnd();
                }
                break;
            case 15:
                Composer composer16 = (Composer) obj2;
                int iIntValue16 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (!gapComposer16.shouldExecute(iIntValue16 & 1, (iIntValue16 & 17) != 16)) {
                    gapComposer16.skipToGroupEnd();
                } else {
                    OffsetKt.Spacer(gapComposer16, SizeKt.m145height3ABfNKs(companion, 12.0f));
                }
                break;
            case 16:
                Composer composer17 = (Composer) obj2;
                int iIntValue17 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (!gapComposer17.shouldExecute(iIntValue17 & 1, (iIntValue17 & 17) != 16)) {
                    gapComposer17.skipToGroupEnd();
                }
                break;
            case 17:
                Composer composer18 = (Composer) obj2;
                int iIntValue18 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (!gapComposer18.shouldExecute(iIntValue18 & 1, (iIntValue18 & 17) != 16)) {
                    gapComposer18.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.cancel, gapComposer18), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer18, 0, 0, 262142);
                }
                break;
            case 18:
                Composer composer19 = (Composer) obj2;
                int iIntValue19 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer19 = (GapComposer) composer19;
                if (!gapComposer19.shouldExecute(iIntValue19 & 1, (iIntValue19 & 17) != 16)) {
                    gapComposer19.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.ok, gapComposer19), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer19, 0, 0, 262142);
                }
                break;
            case 19:
                Composer composer20 = (Composer) obj2;
                int iIntValue20 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (!gapComposer20.shouldExecute(iIntValue20 & 1, (iIntValue20 & 17) != 16)) {
                    gapComposer20.skipToGroupEnd();
                } else {
                    OffsetKt.Spacer(gapComposer20, SizeKt.m145height3ABfNKs(companion, 12.0f));
                }
                break;
            case 20:
                Composer composer21 = (Composer) obj2;
                int iIntValue21 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer21 = (GapComposer) composer21;
                if (!gapComposer21.shouldExecute(iIntValue21 & 1, (iIntValue21 & 17) != 16)) {
                    gapComposer21.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.cancel, gapComposer21), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer21, 0, 0, 262142);
                }
                break;
            case 21:
                Composer composer22 = (Composer) obj2;
                int iIntValue22 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer22 = (GapComposer) composer22;
                if (!gapComposer22.shouldExecute(iIntValue22 & 1, (iIntValue22 & 17) != 16)) {
                    gapComposer22.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.ok, gapComposer22), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer22, 0, 0, 262142);
                }
                break;
            case 22:
                Composer composer23 = (Composer) obj2;
                int iIntValue23 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer23 = (GapComposer) composer23;
                if (!gapComposer23.shouldExecute(iIntValue23 & 1, (iIntValue23 & 17) != 16)) {
                    gapComposer23.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(com.yalantis.ucrop.R.string.remove_download_playlist_confirm, new Object[]{"selection"}, gapComposer23), OffsetKt.m137paddingVpY3zN4$default(companion, 18.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer23.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer23, 48, 0, 131068);
                }
                break;
            case 23:
                Composer composer24 = (Composer) obj2;
                int iIntValue24 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer24 = (GapComposer) composer24;
                if (!gapComposer24.shouldExecute(iIntValue24 & 1, (iIntValue24 & 17) != 16)) {
                    gapComposer24.skipToGroupEnd();
                } else {
                    OffsetKt.Spacer(gapComposer24, SizeKt.m145height3ABfNKs(companion, 12.0f));
                }
                break;
            case 24:
                Composer composer25 = (Composer) obj2;
                int iIntValue25 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer25 = (GapComposer) composer25;
                if (!gapComposer25.shouldExecute(iIntValue25 & 1, (iIntValue25 & 17) != 16)) {
                    gapComposer25.skipToGroupEnd();
                } else {
                    OffsetKt.Spacer(gapComposer25, SizeKt.m145height3ABfNKs(companion, 12.0f));
                }
                break;
            case 25:
                Composer composer26 = (Composer) obj2;
                int iIntValue26 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer26 = (GapComposer) composer26;
                if (!gapComposer26.shouldExecute(iIntValue26 & 1, (iIntValue26 & 17) != 16)) {
                    gapComposer26.skipToGroupEnd();
                } else {
                    OffsetKt.Spacer(gapComposer26, SizeKt.m145height3ABfNKs(companion, 12.0f));
                }
                break;
            case 26:
                Composer composer27 = (Composer) obj2;
                int iIntValue27 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer27 = (GapComposer) composer27;
                if (!gapComposer27.shouldExecute(iIntValue27 & 1, (iIntValue27 & 17) != 16)) {
                    gapComposer27.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(com.yalantis.ucrop.R.drawable.replay, 0, gapComposer27), (String) null, SizeKt.m151size3ABfNKs(companion, 18.0f), 0L, gapComposer27, 440, 8);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 6.0f, gapComposer27, com.yalantis.ucrop.R.string.retry, gapComposer27), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer27, 0, 0, 262142);
                }
                break;
            case 27:
                Composer composer28 = (Composer) obj2;
                int iIntValue28 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer28 = (GapComposer) composer28;
                if (!gapComposer28.shouldExecute(iIntValue28 & 1, (iIntValue28 & 17) != 16)) {
                    gapComposer28.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(com.yalantis.ucrop.R.drawable.content_copy, 0, gapComposer28), (String) null, SizeKt.m151size3ABfNKs(companion, 18.0f), 0L, gapComposer28, 440, 8);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 6.0f, gapComposer28, com.yalantis.ucrop.R.string.copy, gapComposer28), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer28, 0, 0, 262142);
                }
                break;
            case 28:
                Composer composer29 = (Composer) obj2;
                int iIntValue29 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer29 = (GapComposer) composer29;
                if (!gapComposer29.shouldExecute(iIntValue29 & 1, (iIntValue29 & 17) != 16)) {
                    gapComposer29.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.cancel, gapComposer29), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer29, 0, 0, 262142);
                }
                break;
            default:
                Composer composer30 = (Composer) obj2;
                int iIntValue30 = ((Integer) obj3).intValue();
                ((SliderState) obj).getClass();
                GapComposer gapComposer30 = (GapComposer) composer30;
                if (!gapComposer30.shouldExecute(iIntValue30 & 1, (iIntValue30 & 17) != 16)) {
                    gapComposer30.skipToGroupEnd();
                } else {
                    OffsetKt.Spacer(gapComposer30, SizeKt.m151size3ABfNKs(companion, CropImageView.DEFAULT_ASPECT_RATIO));
                }
                break;
        }
        return unit;
    }
}
