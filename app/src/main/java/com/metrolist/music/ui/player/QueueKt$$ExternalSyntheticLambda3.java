package com.metrolist.music.ui.player;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MediaItem;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.db.entities.Song;
import com.yalantis.ucrop.R;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda3(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                List list = (List) obj2;
                ((SaveableHolder) obj).getClass();
                list.getClass();
                return CollectionsKt.toList(list);
            case 1:
                ((Integer) obj).intValue();
                MediaItem mediaItem = (MediaItem) obj2;
                mediaItem.getClass();
                String str = mediaItem.mediaId;
                str.getClass();
                return str;
            case 2:
                return Float.valueOf((((Float) obj).floatValue() / 2.0f) - (((Float) obj2).floatValue() / 2.0f));
            case 3:
                ((Integer) obj).intValue();
                PodcastEntity podcastEntity = (PodcastEntity) obj2;
                podcastEntity.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("podcast_", podcastEntity.id);
            case 4:
                ((Integer) obj).intValue();
                ArtistItem artistItem = (ArtistItem) obj2;
                artistItem.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("channel_", artistItem.id);
            case 5:
                ((Integer) obj2).intValue();
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 6:
                int iIntValue = ((Integer) obj).intValue();
                Song song = (Song) obj2;
                song.getClass();
                return song.song.id + "_" + iIntValue;
            case 7:
                List list2 = (List) obj2;
                ((SaveableHolder) obj).getClass();
                list2.getClass();
                return CollectionsKt.toList(list2);
            case 8:
                ((Integer) obj).intValue();
                SongItem songItem = (SongItem) obj2;
                songItem.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("charts_song_", songItem.id);
            case 9:
                Composer composer = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.account, gapComposer), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 10:
                Composer composer2 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.arrow_back, 0, gapComposer2), (String) null, (Modifier) null, 0L, gapComposer2, 56, 12);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 11:
                Composer composer3 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    FillElement fillElement = SizeKt.FillWholeMaxSize;
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Center, Alignment.Companion.CenterVertically, gapComposer3, 54);
                    int iHashCode = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer3, fillElement);
                    ComposeUiNode.Companion.getClass();
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer3, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.play, 0, gapComposer3), (String) null, SizeKt.m151size3ABfNKs(companion, 20.0f), 0L, gapComposer3, 440, 8);
                    String upperCase = Format$$ExternalSyntheticOutline0.m(companion, 8.0f, gapComposer3, R.string.play, gapComposer3).toUpperCase(Locale.ROOT);
                    upperCase.getClass();
                    TextKt.m352TextNvy7gAk(upperCase, null, 0L, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).typography.labelLarge, gapComposer3, 1572864, 0, 131006);
                    gapComposer3.end(true);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer4 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    FillElement fillElement2 = SizeKt.FillWholeMaxSize;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode2 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer4, fillElement2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer4.startReusableNode();
                    if (gapComposer4.inserting) {
                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer4.useNode();
                    }
                    Stack.m390setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer4);
                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer4), (String) null, SizeKt.m151size3ABfNKs(companion, 22.0f), ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface, gapComposer4, 440, 0);
                    gapComposer4.end(true);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 13:
                Composer composer5 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer5), (String) null, (Modifier) null, 0L, gapComposer5, 56, 12);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 14:
                Composer composer6 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.close, 0, gapComposer6), (String) null, (Modifier) null, 0L, gapComposer6, 56, 12);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 15:
                Composer composer7 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.arrow_back, 0, gapComposer7), (String) null, (Modifier) null, 0L, gapComposer7, 56, 12);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 16:
                Composer composer8 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer8), (String) null, (Modifier) null, 0L, gapComposer8, 56, 12);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 17:
                Composer composer9 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.arrow_back, 0, gapComposer9), (String) null, (Modifier) null, 0L, gapComposer9, 56, 12);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 18:
                Composer composer10 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (gapComposer10.shouldExecute(iIntValue11 & 1, (iIntValue11 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.charts, gapComposer10), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer10, 0, 0, 262142);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 19:
                Composer composer11 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (gapComposer11.shouldExecute(iIntValue12 & 1, (iIntValue12 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.arrow_back, 0, gapComposer11), (String) null, (Modifier) null, 0L, gapComposer11, 56, 12);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case 20:
                Composer composer12 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (gapComposer12.shouldExecute(iIntValue13 & 1, (iIntValue13 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer12), (String) null, (Modifier) null, 0L, gapComposer12, 56, 12);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case 21:
                Composer composer13 = (Composer) obj;
                int iIntValue14 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (gapComposer13.shouldExecute(iIntValue14 & 1, (iIntValue14 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.crash_title, gapComposer13), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer13.consume(MaterialThemeKt._localMaterialTheme)).typography.headlineSmall, gapComposer13, 0, 0, 131070);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 22:
                Composer composer14 = (Composer) obj;
                int iIntValue15 = ((Integer) obj2).intValue();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (gapComposer14.shouldExecute(iIntValue15 & 1, (iIntValue15 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.close, 0, gapComposer14), MathKt.stringResource(R.string.crash_close, gapComposer14), (Modifier) null, 0L, gapComposer14, 8, 12);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 23:
                Composer composer15 = (Composer) obj;
                int iIntValue16 = ((Integer) obj2).intValue();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (gapComposer15.shouldExecute(iIntValue16 & 1, (iIntValue16 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.crash_share_logs, gapComposer15), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer15, 0, 0, 262142);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 24:
                Composer composer16 = (Composer) obj;
                int iIntValue17 = ((Integer) obj2).intValue();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (gapComposer16.shouldExecute(iIntValue17 & 1, (iIntValue17 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.share, 0, gapComposer16), (String) null, (Modifier) null, 0L, gapComposer16, 56, 12);
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 25:
                Composer composer17 = (Composer) obj;
                int iIntValue18 = ((Integer) obj2).intValue();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (gapComposer17.shouldExecute(iIntValue18 & 1, (iIntValue18 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer17), (String) null, (Modifier) null, 0L, gapComposer17, 56, 12);
                } else {
                    gapComposer17.skipToGroupEnd();
                }
                return unit;
            case 26:
                Composer composer18 = (Composer) obj;
                int iIntValue19 = ((Integer) obj2).intValue();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (gapComposer18.shouldExecute(iIntValue19 & 1, (iIntValue19 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer18), (String) null, (Modifier) null, 0L, gapComposer18, 56, 12);
                } else {
                    gapComposer18.skipToGroupEnd();
                }
                return unit;
            case 27:
                Composer composer19 = (Composer) obj;
                int iIntValue20 = ((Integer) obj2).intValue();
                GapComposer gapComposer19 = (GapComposer) composer19;
                if (gapComposer19.shouldExecute(iIntValue20 & 1, (iIntValue20 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.search, gapComposer19), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer19.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer19, 0, 0, 131070);
                } else {
                    gapComposer19.skipToGroupEnd();
                }
                return unit;
            case 28:
                Composer composer20 = (Composer) obj;
                int iIntValue21 = ((Integer) obj2).intValue();
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (gapComposer20.shouldExecute(iIntValue21 & 1, (iIntValue21 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.close, 0, gapComposer20), (String) null, (Modifier) null, 0L, gapComposer20, 56, 12);
                } else {
                    gapComposer20.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer21 = (Composer) obj;
                int iIntValue22 = ((Integer) obj2).intValue();
                GapComposer gapComposer21 = (GapComposer) composer21;
                if (gapComposer21.shouldExecute(iIntValue22 & 1, (iIntValue22 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.arrow_back, 0, gapComposer21), (String) null, (Modifier) null, 0L, gapComposer21, 56, 12);
                } else {
                    gapComposer21.skipToGroupEnd();
                }
                return unit;
        }
    }
}
