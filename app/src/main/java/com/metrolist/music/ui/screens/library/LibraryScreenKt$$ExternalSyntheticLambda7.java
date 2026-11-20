package com.metrolist.music.ui.screens.library;

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
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.db.entities.Song;
import com.yalantis.ucrop.R;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LibraryScreenKt$$ExternalSyntheticLambda7 implements Function2 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ LibraryScreenKt$$ExternalSyntheticLambda7(int i) {
        this.$r8$classId = (byte) 0;
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
                ((Integer) obj2).getClass();
                LibraryScreenKt.LibraryScreen(Stack.updateChangedFlags(1), (Composer) obj);
                return unit;
            case 1:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(1 & iIntValue, (iIntValue & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.filter_podcasts, gapComposer), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 2:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.close, 0, gapComposer2), MathKt.stringResource(R.string.close_chip, gapComposer2), (Modifier) null, 0L, gapComposer2, 8, 12);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 3:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(1 & iIntValue3, (iIntValue3 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer3), MathKt.stringResource(R.string.more_options, gapComposer3), (Modifier) null, 0L, gapComposer3, 8, 12);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 4:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(1 & iIntValue4, (iIntValue4 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer4), MathKt.stringResource(R.string.more_options, gapComposer4), (Modifier) null, 0L, gapComposer4, 8, 12);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 5:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(1 & iIntValue5, (iIntValue5 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.delete, 0, gapComposer5), (String) null, (Modifier) null, 0L, gapComposer5, 56, 12);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 6:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(1 & iIntValue6, (iIntValue6 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.remove_from_library, gapComposer6), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 0, 0, 262142);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 7:
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(1 & iIntValue7, (iIntValue7 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.share, 0, gapComposer7), (String) null, (Modifier) null, 0L, gapComposer7, 56, 12);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 8:
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(1 & iIntValue8, (iIntValue8 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.share, gapComposer8), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer8, 0, 0, 262142);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 9:
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(1 & iIntValue9, (iIntValue9 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.upload, 0, gapComposer9), (String) null, (Modifier) null, 0L, gapComposer9, 56, 12);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 10:
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (gapComposer10.shouldExecute(1 & iIntValue10, (iIntValue10 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.uploading, gapComposer10), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer10, 0, 0, 262142);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 11:
                Composer composer11 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (gapComposer11.shouldExecute(1 & iIntValue11, (iIntValue11 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.songs, gapComposer11), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer11, 0, 0, 262142);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer12 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (gapComposer12.shouldExecute(1 & iIntValue12, (iIntValue12 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.close, 0, gapComposer12), "", (Modifier) null, 0L, gapComposer12, 56, 12);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case 13:
                Composer composer13 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (gapComposer13.shouldExecute(1 & iIntValue13, (iIntValue13 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.search, 0, gapComposer13), MathKt.stringResource(R.string.search, gapComposer13), (Modifier) null, 0L, gapComposer13, 8, 12);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 14:
                Composer composer14 = (Composer) obj;
                int iIntValue14 = ((Integer) obj2).intValue();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (gapComposer14.shouldExecute(1 & iIntValue14, (iIntValue14 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer14), (String) null, (Modifier) null, 0L, gapComposer14, 56, 12);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 15:
                ((Integer) obj).intValue();
                PodcastEntity podcastEntity = (PodcastEntity) obj2;
                podcastEntity.getClass();
                return podcastEntity.id;
            case 16:
                int iIntValue15 = ((Integer) obj).intValue();
                Song song = (Song) obj2;
                song.getClass();
                return song.song.id + "_" + iIntValue15;
            case 17:
                ((Integer) obj).intValue();
                ArtistItem artistItem = (ArtistItem) obj2;
                artistItem.getClass();
                return artistItem.id;
            case 18:
                int iIntValue16 = ((Integer) obj).intValue();
                Song song2 = (Song) obj2;
                song2.getClass();
                return song2.song.id + "_" + iIntValue16;
            case 19:
                List list = (List) obj2;
                ((SaveableHolder) obj).getClass();
                list.getClass();
                return CollectionsKt.toList(list);
            case 20:
                int iIntValue17 = ((Integer) obj).intValue();
                Song song3 = (Song) obj2;
                song3.getClass();
                return song3.song.id + "_" + iIntValue17;
            case 21:
                int iIntValue18 = ((Integer) obj).intValue();
                Song song4 = (Song) obj2;
                song4.getClass();
                return song4.song.id + "_" + iIntValue18;
            case 22:
                List list2 = (List) obj2;
                ((SaveableHolder) obj).getClass();
                list2.getClass();
                return CollectionsKt.toList(list2);
            case 23:
                Composer composer15 = (Composer) obj;
                int iIntValue19 = ((Integer) obj2).intValue();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (gapComposer15.shouldExecute(1 & iIntValue19, (iIntValue19 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer15), (String) null, (Modifier) null, 0L, gapComposer15, 56, 12);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 24:
                Composer composer16 = (Composer) obj;
                int iIntValue20 = ((Integer) obj2).intValue();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (gapComposer16.shouldExecute(1 & iIntValue20, (iIntValue20 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.upload, 0, gapComposer16), MathKt.stringResource(R.string.upload_songs, gapComposer16), (Modifier) null, 0L, gapComposer16, 8, 12);
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 25:
                Composer composer17 = (Composer) obj;
                int iIntValue21 = ((Integer) obj2).intValue();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (gapComposer17.shouldExecute(1 & iIntValue21, (iIntValue21 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.search, gapComposer17), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer17.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer17, 0, 0, 131070);
                } else {
                    gapComposer17.skipToGroupEnd();
                }
                return unit;
            case 26:
                Composer composer18 = (Composer) obj;
                int iIntValue22 = ((Integer) obj2).intValue();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (gapComposer18.shouldExecute(1 & iIntValue22, (iIntValue22 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer18), (String) null, (Modifier) null, 0L, gapComposer18, 56, 12);
                } else {
                    gapComposer18.skipToGroupEnd();
                }
                return unit;
            case 27:
                Composer composer19 = (Composer) obj;
                int iIntValue23 = ((Integer) obj2).intValue();
                GapComposer gapComposer19 = (GapComposer) composer19;
                if (gapComposer19.shouldExecute(1 & iIntValue23, (iIntValue23 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.search, 0, gapComposer19), (String) null, (Modifier) null, 0L, gapComposer19, 56, 12);
                } else {
                    gapComposer19.skipToGroupEnd();
                }
                return unit;
            case 28:
                Composer composer20 = (Composer) obj;
                int iIntValue24 = ((Integer) obj2).intValue();
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (gapComposer20.shouldExecute(iIntValue24 & 1, (iIntValue24 & 3) != 2)) {
                    FillElement fillElement = SizeKt.FillWholeMaxSize;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode = Long.hashCode(gapComposer20.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer20.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer20, fillElement);
                    ComposeUiNode.Companion.getClass();
                    gapComposer20.startReusableNode();
                    if (gapComposer20.inserting) {
                        gapComposer20.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer20.useNode();
                    }
                    Stack.m390setimpl(gapComposer20, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer20, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer20, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer20);
                    Stack.m390setimpl(gapComposer20, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.shuffle, 0, gapComposer20), MathKt.stringResource(R.string.shuffle, gapComposer20), SizeKt.m151size3ABfNKs(companion, 24.0f), 0L, gapComposer20, 392, 8);
                    gapComposer20.end(true);
                } else {
                    gapComposer20.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer21 = (Composer) obj;
                int iIntValue25 = ((Integer) obj2).intValue();
                GapComposer gapComposer21 = (GapComposer) composer21;
                if (gapComposer21.shouldExecute(iIntValue25 & 1, (iIntValue25 & 3) != 2)) {
                    BiasAlignment biasAlignment = Alignment.Companion.Center;
                    FillElement fillElement2 = SizeKt.FillWholeMaxSize;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                    int iHashCode2 = Long.hashCode(gapComposer21.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer21.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer21, fillElement2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer21.startReusableNode();
                    if (gapComposer21.inserting) {
                        gapComposer21.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer21.useNode();
                    }
                    Stack.m390setimpl(gapComposer21, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer21, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer21, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer21);
                    Stack.m390setimpl(gapComposer21, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.play, 0, gapComposer21), MathKt.stringResource(R.string.play, gapComposer21), SizeKt.m151size3ABfNKs(companion, 32.0f), ((MaterialTheme$Values) gapComposer21.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onPrimary, gapComposer21, 392, 0);
                    gapComposer21.end(true);
                } else {
                    gapComposer21.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ LibraryScreenKt$$ExternalSyntheticLambda7(byte b) {
        this.$r8$classId = b;
    }
}
