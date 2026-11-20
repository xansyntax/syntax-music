package com.metrolist.music.ui.screens.playlist;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.ui.screens.recognition.RecognitionScreenKt;
import com.yalantis.ucrop.R;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TopPlaylistScreenKt$$ExternalSyntheticLambda8 implements Function2 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ TopPlaylistScreenKt$$ExternalSyntheticLambda8(int i) {
        this.$r8$classId = (byte) 26;
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
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.search, gapComposer), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer, 0, 0, 131070);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 2:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer2), (String) null, (Modifier) null, 0L, gapComposer2, 56, 12);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 3:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.search, 0, gapComposer3), (String) null, (Modifier) null, 0L, gapComposer3, 56, 12);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 4:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    FillElement fillElement = SizeKt.FillWholeMaxSize;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode = Long.hashCode(gapComposer4.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer4, fillElement);
                    ComposeUiNode.Companion.getClass();
                    gapComposer4.startReusableNode();
                    if (gapComposer4.inserting) {
                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer4.useNode();
                    }
                    Stack.m390setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer4);
                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.shuffle, 0, gapComposer4), MathKt.stringResource(R.string.shuffle, gapComposer4), SizeKt.m151size3ABfNKs(companion, 24.0f), 0L, gapComposer4, 392, 8);
                    gapComposer4.end(true);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 5:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    BiasAlignment biasAlignment = Alignment.Companion.Center;
                    FillElement fillElement2 = SizeKt.FillWholeMaxSize;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                    int iHashCode2 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer5.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer5, fillElement2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer5.startReusableNode();
                    if (gapComposer5.inserting) {
                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer5.useNode();
                    }
                    Stack.m390setimpl(gapComposer5, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer5, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer5);
                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.play, 0, gapComposer5), MathKt.stringResource(R.string.play, gapComposer5), SizeKt.m151size3ABfNKs(companion, 32.0f), ((MaterialTheme$Values) gapComposer5.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onPrimary, gapComposer5, 392, 0);
                    gapComposer5.end(true);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 6:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    FillElement fillElement3 = SizeKt.FillWholeMaxSize;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode3 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer6, fillElement3);
                    ComposeUiNode.Companion.getClass();
                    gapComposer6.startReusableNode();
                    if (gapComposer6.inserting) {
                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer6.useNode();
                    }
                    Stack.m390setimpl(gapComposer6, measurePolicyMaybeCachedBoxMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer6, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer6);
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer6), (String) null, SizeKt.m151size3ABfNKs(companion, 24.0f), 0L, gapComposer6, 440, 8);
                    gapComposer6.end(true);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 7:
                ((Integer) obj).getClass();
                PlaylistSong playlistSong = (PlaylistSong) obj2;
                playlistSong.getClass();
                return Integer.valueOf(playlistSong.map.id);
            case 8:
                int iIntValue7 = ((Integer) obj).intValue();
                Pair pair = (Pair) obj2;
                pair.getClass();
                return ((SongItem) pair.second).id + "_" + iIntValue7;
            case 9:
                int iIntValue8 = ((Integer) obj).intValue();
                Song song = (Song) obj2;
                song.getClass();
                return song.song.id + "_" + iIntValue8;
            case 10:
                Composer composer7 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer7), (String) null, (Modifier) null, 0L, gapComposer7, 56, 12);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 11:
                Composer composer8 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.search, gapComposer8), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer8.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer8, 0, 0, 131070);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer9 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(iIntValue11 & 1, (iIntValue11 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.arrow_back, 0, gapComposer9), (String) null, (Modifier) null, 0L, gapComposer9, 56, 12);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 13:
                Composer composer10 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (gapComposer10.shouldExecute(iIntValue12 & 1, (iIntValue12 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.search, 0, gapComposer10), MathKt.stringResource(R.string.search, gapComposer10), (Modifier) null, 0L, gapComposer10, 8, 12);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 14:
                ((Integer) obj).intValue();
                EpisodeItem episodeItem = (EpisodeItem) obj2;
                episodeItem.getClass();
                return episodeItem.id;
            case 15:
                Composer composer11 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (gapComposer11.shouldExecute(iIntValue13 & 1, (iIntValue13 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.delete, 0, gapComposer11), (String) null, (Modifier) null, 0L, gapComposer11, 56, 12);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case 16:
                Composer composer12 = (Composer) obj;
                int iIntValue14 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (gapComposer12.shouldExecute(iIntValue14 & 1, (iIntValue14 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.recognition_history, gapComposer12), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer12, 0, 0, 262142);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case 17:
                Composer composer13 = (Composer) obj;
                int iIntValue15 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (gapComposer13.shouldExecute(iIntValue15 & 1, (iIntValue15 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.arrow_back, 0, gapComposer13), (String) null, (Modifier) null, 0L, gapComposer13, 56, 12);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 18:
                Composer composer14 = (Composer) obj;
                int iIntValue16 = ((Integer) obj2).intValue();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (gapComposer14.shouldExecute(iIntValue16 & 1, (iIntValue16 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.clear_all, 0, gapComposer14), MathKt.stringResource(R.string.clear_recognition_history, gapComposer14), (Modifier) null, 0L, gapComposer14, 8, 12);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 19:
                Composer composer15 = (Composer) obj;
                int iIntValue17 = ((Integer) obj2).intValue();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (gapComposer15.shouldExecute(iIntValue17 & 1, (iIntValue17 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.delete, 0, gapComposer15), MathKt.stringResource(R.string.delete_from_history, gapComposer15), (Modifier) null, ((MaterialTheme$Values) gapComposer15.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant, gapComposer15, 8, 4);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 20:
                Composer composer16 = (Composer) obj;
                int iIntValue18 = ((Integer) obj2).intValue();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (gapComposer16.shouldExecute(iIntValue18 & 1, (iIntValue18 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.clear_recognition_history, gapComposer16), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer16, 0, 0, 262142);
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 21:
                Composer composer17 = (Composer) obj;
                int iIntValue19 = ((Integer) obj2).intValue();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (gapComposer17.shouldExecute(iIntValue19 & 1, (iIntValue19 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.delete, 0, gapComposer17), (String) null, (Modifier) null, 0L, gapComposer17, 56, 12);
                } else {
                    gapComposer17.skipToGroupEnd();
                }
                return unit;
            case 22:
                Composer composer18 = (Composer) obj;
                int iIntValue20 = ((Integer) obj2).intValue();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (gapComposer18.shouldExecute(iIntValue20 & 1, (iIntValue20 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.delete, gapComposer18), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer18, 0, 0, 262142);
                } else {
                    gapComposer18.skipToGroupEnd();
                }
                return unit;
            case 23:
                Composer composer19 = (Composer) obj;
                int iIntValue21 = ((Integer) obj2).intValue();
                GapComposer gapComposer19 = (GapComposer) composer19;
                if (gapComposer19.shouldExecute(iIntValue21 & 1, (iIntValue21 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.recognize_music, gapComposer19), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer19, 0, 0, 262142);
                } else {
                    gapComposer19.skipToGroupEnd();
                }
                return unit;
            case 24:
                Composer composer20 = (Composer) obj;
                int iIntValue22 = ((Integer) obj2).intValue();
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (gapComposer20.shouldExecute(iIntValue22 & 1, (iIntValue22 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.arrow_back, 0, gapComposer20), (String) null, (Modifier) null, 0L, gapComposer20, 56, 12);
                } else {
                    gapComposer20.skipToGroupEnd();
                }
                return unit;
            case 25:
                Composer composer21 = (Composer) obj;
                int iIntValue23 = ((Integer) obj2).intValue();
                GapComposer gapComposer21 = (GapComposer) composer21;
                if (gapComposer21.shouldExecute(iIntValue23 & 1, (iIntValue23 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.history, 0, gapComposer21), MathKt.stringResource(R.string.recognition_history, gapComposer21), (Modifier) null, 0L, gapComposer21, 8, 12);
                } else {
                    gapComposer21.skipToGroupEnd();
                }
                return unit;
            case 26:
                ((Integer) obj2).getClass();
                RecognitionScreenKt.ProcessingState(Stack.updateChangedFlags(1), (Composer) obj);
                return unit;
            case 27:
                Composer composer22 = (Composer) obj;
                int iIntValue24 = ((Integer) obj2).intValue();
                GapComposer gapComposer22 = (GapComposer) composer22;
                if (gapComposer22.shouldExecute(iIntValue24 & 1, (iIntValue24 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer22), (String) null, (Modifier) null, 0L, gapComposer22, 56, 12);
                } else {
                    gapComposer22.skipToGroupEnd();
                }
                return unit;
            case 28:
                Composer composer23 = (Composer) obj;
                int iIntValue25 = ((Integer) obj2).intValue();
                GapComposer gapComposer23 = (GapComposer) composer23;
                if (gapComposer23.shouldExecute(iIntValue25 & 1, (iIntValue25 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer23), (String) null, (Modifier) null, 0L, gapComposer23, 56, 12);
                } else {
                    gapComposer23.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer24 = (Composer) obj;
                int iIntValue26 = ((Integer) obj2).intValue();
                GapComposer gapComposer24 = (GapComposer) composer24;
                if (gapComposer24.shouldExecute(iIntValue26 & 1, (iIntValue26 & 3) != 2)) {
                    String strStringResource = MathKt.stringResource(R.string.search_yt_music, gapComposer24);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource, null, ((MaterialTheme$Values) gapComposer24.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer24.consume(staticProvidableCompositionLocal)).typography.bodyLarge, gapComposer24, 0, 0, 131066);
                } else {
                    gapComposer24.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ TopPlaylistScreenKt$$ExternalSyntheticLambda8(byte b) {
        this.$r8$classId = b;
    }
}
