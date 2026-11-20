package com.metrolist.music.ui.screens.equalizer;

import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.FilterChipDefaults;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.metrolist.music.constants.AlbumFilter;
import com.metrolist.music.constants.ArtistFilter;
import com.metrolist.music.constants.PodcastFilter;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda3;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.yalantis.ucrop.R;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class EqScreenKt$$ExternalSyntheticLambda35 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ EqScreenKt$$ExternalSyntheticLambda35(Function0 function0, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        boolean z;
        long jColor;
        long j;
        long j2;
        boolean z2;
        boolean z3;
        long jColor2;
        long j3;
        long j4;
        boolean z4;
        long jColor3;
        long j5;
        long j6;
        byte b = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        MutableState mutableState = this.f$1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Function0 function0 = this.f$0;
                    boolean zChanged = gapComposer.changed(function0);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new SongMenuKt$$ExternalSyntheticLambda3(function0, mutableState, (byte) 6);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, EqScreenKt.f357lambda$2131017022, gapComposer, 805306368, 510);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer2, 0);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    OffsetKt.Spacer(gapComposer2, SizeKt.m155width3ABfNKs(companion, 12.0f));
                    PaddingValuesImpl paddingValuesImpl = FilterChipDefaults.ContentPadding;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    long j7 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.surfaceContainer;
                    if (UiStyleKt.isGlassStyle(gapComposer2)) {
                        gapComposer2.startReplaceGroup(-41808241);
                        long j8 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.primary;
                        jColor = ColorKt.Color(Color.m485getRedimpl(j8), Color.m484getGreenimpl(j8), Color.m482getBlueimpl(j8), 0.24f, Color.m483getColorSpaceimpl(j8));
                        z = false;
                    } else {
                        z = false;
                        gapComposer2.startReplaceGroup(-41806619);
                        jColor = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurface;
                    }
                    gapComposer2.end(z);
                    long j9 = jColor;
                    if (UiStyleKt.isGlassStyle(gapComposer2)) {
                        gapComposer2.startReplaceGroup(-41803549);
                        j = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.primary;
                    } else {
                        gapComposer2.startReplaceGroup(-41802301);
                        j = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.surface;
                    }
                    gapComposer2.end(z);
                    long j10 = j;
                    if (UiStyleKt.isGlassStyle(gapComposer2)) {
                        gapComposer2.startReplaceGroup(-41799101);
                        j2 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.primary;
                    } else {
                        gapComposer2.startReplaceGroup(-41797853);
                        j2 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.surface;
                    }
                    gapComposer2.end(z);
                    ChipKt.FilterChip(true, this.f$0, LibraryScreenKt.f371lambda$1550870679, null, false, LibraryScreenKt.lambda$768255174, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer2)), FilterChipDefaults.m288filterChipColorsXqyqHi0(j7, 0L, j9, j10, j2, gapComposer2, 2430), null, null, null, null, gapComposer2, 196998, 6, 14936);
                    List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{new Pair(AlbumFilter.LIKED, MathKt.stringResource(R.string.filter_liked, gapComposer2)), new Pair(AlbumFilter.LIBRARY, MathKt.stringResource(R.string.filter_library, gapComposer2)), new Pair(AlbumFilter.UPLOADED, MathKt.stringResource(R.string.filter_uploaded, gapComposer2))});
                    AlbumFilter albumFilter = (AlbumFilter) mutableState.getValue();
                    boolean zChanged2 = gapComposer2.changed(mutableState);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        z2 = true;
                        objRememberedValue2 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState, (byte) 1);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        z2 = true;
                    }
                    DialogKt.m1461ChipsRowyrwZFoE(listListOf, albumFilter, (Function1) objRememberedValue2, new LayoutWeightElement(1.0f, z2), 0L, gapComposer2, 0, 16);
                    gapComposer2.end(z2);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer3, 0);
                    int iHashCode2 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer3, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer3, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    OffsetKt.Spacer(gapComposer3, SizeKt.m155width3ABfNKs(companion, 12.0f));
                    PaddingValuesImpl paddingValuesImpl2 = FilterChipDefaults.ContentPadding;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    long j11 = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal2)).colorScheme.surfaceContainer;
                    if (UiStyleKt.isGlassStyle(gapComposer3)) {
                        gapComposer3.startReplaceGroup(-887775111);
                        long j12 = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal2)).colorScheme.primary;
                        jColor2 = ColorKt.Color(Color.m485getRedimpl(j12), Color.m484getGreenimpl(j12), Color.m482getBlueimpl(j12), 0.24f, Color.m483getColorSpaceimpl(j12));
                        z3 = false;
                    } else {
                        z3 = false;
                        gapComposer3.startReplaceGroup(-887773489);
                        jColor2 = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal2)).colorScheme.onSurface;
                    }
                    gapComposer3.end(z3);
                    long j13 = jColor2;
                    if (UiStyleKt.isGlassStyle(gapComposer3)) {
                        gapComposer3.startReplaceGroup(-887770419);
                        j3 = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal2)).colorScheme.primary;
                    } else {
                        gapComposer3.startReplaceGroup(-887769171);
                        j3 = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal2)).colorScheme.surface;
                    }
                    gapComposer3.end(z3);
                    long j14 = j3;
                    if (UiStyleKt.isGlassStyle(gapComposer3)) {
                        gapComposer3.startReplaceGroup(-887765971);
                        j4 = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal2)).colorScheme.primary;
                    } else {
                        gapComposer3.startReplaceGroup(-887764723);
                        j4 = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal2)).colorScheme.surface;
                    }
                    gapComposer3.end(z3);
                    ChipKt.FilterChip(true, this.f$0, LibraryScreenKt.lambda$1780954809, null, false, LibraryScreenKt.lambda$2015318076, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer3)), FilterChipDefaults.m288filterChipColorsXqyqHi0(j11, 0L, j13, j14, j4, gapComposer3, 2430), null, null, null, null, gapComposer3, 196998, 6, 14936);
                    List listListOf2 = CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{new Pair(ArtistFilter.LIKED, MathKt.stringResource(R.string.filter_liked, gapComposer3)), new Pair(ArtistFilter.LIBRARY, MathKt.stringResource(R.string.filter_library, gapComposer3))});
                    ArtistFilter artistFilter = (ArtistFilter) mutableState.getValue();
                    boolean zChanged3 = gapComposer3.changed(mutableState);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState, (byte) 2);
                        gapComposer3.updateRememberedValue(objRememberedValue3);
                    }
                    DialogKt.m1461ChipsRowyrwZFoE(listListOf2, artistFilter, (Function1) objRememberedValue3, new LayoutWeightElement(1.0f, true), 0L, gapComposer3, 0, 16);
                    gapComposer3.end(true);
                }
                break;
            default:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer4, 0);
                    int iHashCode3 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer4, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer4.startReusableNode();
                    if (gapComposer4.inserting) {
                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer4.useNode();
                    }
                    Stack.m390setimpl(gapComposer4, rowMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer4);
                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    OffsetKt.Spacer(gapComposer4, SizeKt.m155width3ABfNKs(companion, 12.0f));
                    PaddingValuesImpl paddingValuesImpl3 = FilterChipDefaults.ContentPadding;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                    long j15 = ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal3)).colorScheme.surfaceContainer;
                    if (UiStyleKt.isGlassStyle(gapComposer4)) {
                        gapComposer4.startReplaceGroup(-415151019);
                        long j16 = ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal3)).colorScheme.primary;
                        jColor3 = ColorKt.Color(Color.m485getRedimpl(j16), Color.m484getGreenimpl(j16), Color.m482getBlueimpl(j16), 0.24f, Color.m483getColorSpaceimpl(j16));
                        z4 = false;
                    } else {
                        z4 = false;
                        gapComposer4.startReplaceGroup(-415149397);
                        jColor3 = ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal3)).colorScheme.onSurface;
                    }
                    gapComposer4.end(z4);
                    long j17 = jColor3;
                    if (UiStyleKt.isGlassStyle(gapComposer4)) {
                        gapComposer4.startReplaceGroup(-415146071);
                        j5 = ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal3)).colorScheme.primary;
                    } else {
                        gapComposer4.startReplaceGroup(-415144823);
                        j5 = ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal3)).colorScheme.surface;
                    }
                    gapComposer4.end(z4);
                    long j18 = j5;
                    if (UiStyleKt.isGlassStyle(gapComposer4)) {
                        gapComposer4.startReplaceGroup(-415141367);
                        j6 = ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal3)).colorScheme.primary;
                    } else {
                        gapComposer4.startReplaceGroup(-415140119);
                        j6 = ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal3)).colorScheme.surface;
                    }
                    gapComposer4.end(z4);
                    ChipKt.FilterChip(true, this.f$0, LibraryScreenKt.lambda$1605724367, null, false, LibraryScreenKt.f376lambda$549649172, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer4)), FilterChipDefaults.m288filterChipColorsXqyqHi0(j15, 0L, j17, j18, j6, gapComposer4, 2430), null, null, null, null, gapComposer4, 196998, 6, 14936);
                    List listListOf3 = CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{new Pair(PodcastFilter.EPISODES, MathKt.stringResource(R.string.filter_episodes, gapComposer4)), new Pair(PodcastFilter.CHANNELS, MathKt.stringResource(R.string.filter_channels, gapComposer4)), new Pair(PodcastFilter.DOWNLOADED, MathKt.stringResource(R.string.filter_downloaded, gapComposer4))});
                    PodcastFilter podcastFilter = (PodcastFilter) mutableState.getValue();
                    boolean zChanged4 = gapComposer4.changed(mutableState);
                    Object objRememberedValue4 = gapComposer4.rememberedValue();
                    if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState, (byte) 3);
                        gapComposer4.updateRememberedValue(objRememberedValue4);
                    }
                    DialogKt.m1461ChipsRowyrwZFoE(listListOf3, podcastFilter, (Function1) objRememberedValue4, new LayoutWeightElement(1.0f, true), 0L, gapComposer4, 0, 16);
                    gapComposer4.end(true);
                }
                break;
        }
        return unit;
    }
}
