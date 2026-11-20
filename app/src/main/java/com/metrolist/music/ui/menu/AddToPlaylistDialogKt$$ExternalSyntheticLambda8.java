package com.metrolist.music.ui.menu;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.FlowRowScopeInstance;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.FilterChipDefaults;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SelectableChipColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.font.FontWeight;
import com.metrolist.music.constants.PlaylistSortType;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda25;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.enums.EnumEntriesList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AddToPlaylistDialogKt$$ExternalSyntheticLambda8 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ MimesKt$$ExternalSyntheticLambda0 f$1;
    public final /* synthetic */ PlaylistSortType f$2;
    public final /* synthetic */ Function1 f$3;

    public /* synthetic */ AddToPlaylistDialogKt$$ExternalSyntheticLambda8(boolean z, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0, PlaylistSortType playlistSortType, Function1 function1, byte b) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = mimesKt$$ExternalSyntheticLambda0;
        this.f$2 = playlistSortType;
        this.f$3 = function1;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        StaticProvidableCompositionLocal staticProvidableCompositionLocal;
        long j;
        long j2;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal2;
        long j3;
        long j4;
        byte b = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        final Function1 function1 = this.f$3;
        final PlaylistSortType playlistSortType = this.f$2;
        final MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = this.f$1;
        final byte b2 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    FlowRowOverflow flowRowOverflow = OffsetKt.SpaceBetween;
                    Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 12.0f, 4.0f);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer, 54);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM136paddingVpY3zN4);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    final byte b3 = 0;
                    OffsetKt.FlowRow(new LayoutWeightElement(1.0f, true), new Arrangement$SpacedAligned(6.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), new Arrangement$SpacedAligned(6.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), null, 0, 0, Expect_jvmKt.rememberComposableLambda(1671297145, new Function3() { // from class: com.metrolist.music.ui.menu.AddToPlaylistDialogKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj4, Object obj5, Object obj6) {
                            final byte b4;
                            final byte b5;
                            byte b6 = b3;
                            Unit unit = Unit.INSTANCE;
                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                            int i = 60;
                            float f = 8.0f;
                            EnumEntriesList<PlaylistSortType> enumEntriesList = PlaylistSortType.$ENTRIES;
                            final Function1 function2 = function1;
                            PlaylistSortType playlistSortType2 = playlistSortType;
                            boolean z = true;
                            switch (b6) {
                                case 0:
                                    Composer composer2 = (Composer) obj5;
                                    int iIntValue2 = ((Integer) obj6).intValue();
                                    ((FlowRowScopeInstance) obj4).getClass();
                                    boolean z2 = true;
                                    GapComposer gapComposer2 = (GapComposer) composer2;
                                    if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                        for (final PlaylistSortType playlistSortType3 : enumEntriesList) {
                                            boolean z3 = playlistSortType2 == playlistSortType3 ? z2 : false;
                                            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                                            BorderStroke borderStrokeM287filterChipBorder_7El2pE = FilterChipDefaults.m287filterChipBorder_7El2pE(z3, gapComposer2, 60);
                                            StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                                            final boolean z4 = z3;
                                            SelectableChipColors selectableChipColorsM288filterChipColorsXqyqHi0 = FilterChipDefaults.m288filterChipColorsXqyqHi0(((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal3)).colorScheme.surfaceVariant, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal3)).colorScheme.onSurfaceVariant, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal3)).colorScheme.primary, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal3)).colorScheme.onPrimary, 0L, gapComposer2, 3452);
                                            boolean zChanged = gapComposer2.changed(function2) | gapComposer2.changed(playlistSortType3.ordinal());
                                            Object objRememberedValue = gapComposer2.rememberedValue();
                                            if (zChanged || objRememberedValue == neverEqualPolicy) {
                                                b4 = 0;
                                                objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.menu.AddToPlaylistDialogKt$$ExternalSyntheticLambda17
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        byte b7 = b4;
                                                        Unit unit2 = Unit.INSTANCE;
                                                        PlaylistSortType playlistSortType4 = playlistSortType3;
                                                        Function1 function3 = function2;
                                                        switch (b7) {
                                                            case 0:
                                                                function3.invoke(playlistSortType4);
                                                                break;
                                                            default:
                                                                function3.invoke(playlistSortType4);
                                                                break;
                                                        }
                                                        return unit2;
                                                    }
                                                };
                                                gapComposer2.updateRememberedValue(objRememberedValue);
                                            } else {
                                                b4 = 0;
                                            }
                                            ChipKt.FilterChip(z4, (Function0) objRememberedValue, Expect_jvmKt.rememberComposableLambda(1473693155, new Function2() { // from class: com.metrolist.music.ui.menu.AddToPlaylistDialogKt$$ExternalSyntheticLambda18
                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(Object obj7, Object obj8) {
                                                    byte b7 = b4;
                                                    Unit unit2 = Unit.INSTANCE;
                                                    int i2 = R.string.sort_by_create_date;
                                                    boolean z5 = z4;
                                                    PlaylistSortType playlistSortType4 = playlistSortType3;
                                                    switch (b7) {
                                                        case 0:
                                                            Composer composer3 = (Composer) obj7;
                                                            int iIntValue3 = ((Integer) obj8).intValue();
                                                            GapComposer gapComposer3 = (GapComposer) composer3;
                                                            if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                                                                gapComposer3.skipToGroupEnd();
                                                                return unit2;
                                                            }
                                                            int iOrdinal = playlistSortType4.ordinal();
                                                            if (iOrdinal != 0) {
                                                                if (iOrdinal == 1) {
                                                                    i2 = R.string.sort_by_name;
                                                                } else if (iOrdinal == 2) {
                                                                    i2 = R.string.sort_by_song_count;
                                                                } else {
                                                                    if (iOrdinal != 3) {
                                                                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                                                                        return null;
                                                                    }
                                                                    i2 = R.string.sort_by_last_updated;
                                                                }
                                                            }
                                                            TextKt.m352TextNvy7gAk(MathKt.stringResource(i2, gapComposer3), null, 0L, 0L, null, z5 ? FontWeight.Bold : FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262078);
                                                            return unit2;
                                                        default:
                                                            Composer composer4 = (Composer) obj7;
                                                            int iIntValue4 = ((Integer) obj8).intValue();
                                                            GapComposer gapComposer4 = (GapComposer) composer4;
                                                            if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                                                                gapComposer4.skipToGroupEnd();
                                                                return unit2;
                                                            }
                                                            int iOrdinal2 = playlistSortType4.ordinal();
                                                            if (iOrdinal2 != 0) {
                                                                if (iOrdinal2 == 1) {
                                                                    i2 = R.string.sort_by_name;
                                                                } else if (iOrdinal2 == 2) {
                                                                    i2 = R.string.sort_by_song_count;
                                                                } else {
                                                                    if (iOrdinal2 != 3) {
                                                                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                                                                        return null;
                                                                    }
                                                                    i2 = R.string.sort_by_last_updated;
                                                                }
                                                            }
                                                            TextKt.m352TextNvy7gAk(MathKt.stringResource(i2, gapComposer4), null, 0L, 0L, null, z5 ? FontWeight.Bold : FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262078);
                                                            return unit2;
                                                    }
                                                }
                                            }, gapComposer2), null, false, null, roundedCornerShapeM185RoundedCornerShape0680j_4, selectableChipColorsM288filterChipColorsXqyqHi0, null, borderStrokeM287filterChipBorder_7El2pE, null, null, gapComposer2, 384, 0, 14968);
                                            z2 = true;
                                        }
                                    } else {
                                        gapComposer2.skipToGroupEnd();
                                    }
                                    break;
                                default:
                                    Composer composer3 = (Composer) obj5;
                                    int iIntValue3 = ((Integer) obj6).intValue();
                                    ((FlowRowScopeInstance) obj4).getClass();
                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                    if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                        Iterator it = enumEntriesList.iterator();
                                        while (it.hasNext()) {
                                            final PlaylistSortType playlistSortType4 = (PlaylistSortType) it.next();
                                            final boolean z5 = playlistSortType2 == playlistSortType4 ? z : false;
                                            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(f);
                                            BorderStroke borderStrokeM287filterChipBorder_7El2pE2 = FilterChipDefaults.m287filterChipBorder_7El2pE(z5, gapComposer3, i);
                                            StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = MaterialThemeKt._localMaterialTheme;
                                            float f2 = f;
                                            Iterator it2 = it;
                                            Unit unit2 = unit;
                                            SelectableChipColors selectableChipColorsM288filterChipColorsXqyqHi1 = FilterChipDefaults.m288filterChipColorsXqyqHi0(((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal4)).colorScheme.surfaceVariant, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal4)).colorScheme.onSurfaceVariant, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal4)).colorScheme.primary, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal4)).colorScheme.onPrimary, 0L, gapComposer3, 3452);
                                            boolean zChanged2 = gapComposer3.changed(function2) | gapComposer3.changed(playlistSortType4.ordinal());
                                            Object objRememberedValue2 = gapComposer3.rememberedValue();
                                            if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                                                b5 = 1;
                                                objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.menu.AddToPlaylistDialogKt$$ExternalSyntheticLambda17
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        byte b7 = b5;
                                                        Unit unit3 = Unit.INSTANCE;
                                                        PlaylistSortType playlistSortType5 = playlistSortType4;
                                                        Function1 function3 = function2;
                                                        switch (b7) {
                                                            case 0:
                                                                function3.invoke(playlistSortType5);
                                                                break;
                                                            default:
                                                                function3.invoke(playlistSortType5);
                                                                break;
                                                        }
                                                        return unit3;
                                                    }
                                                };
                                                gapComposer3.updateRememberedValue(objRememberedValue2);
                                            } else {
                                                b5 = 1;
                                            }
                                            ChipKt.FilterChip(z5, (Function0) objRememberedValue2, Expect_jvmKt.rememberComposableLambda(1987077635, new Function2() { // from class: com.metrolist.music.ui.menu.AddToPlaylistDialogKt$$ExternalSyntheticLambda18
                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(Object obj7, Object obj8) {
                                                    byte b7 = b5;
                                                    Unit unit3 = Unit.INSTANCE;
                                                    int i2 = R.string.sort_by_create_date;
                                                    boolean z6 = z5;
                                                    PlaylistSortType playlistSortType5 = playlistSortType4;
                                                    switch (b7) {
                                                        case 0:
                                                            Composer composer4 = (Composer) obj7;
                                                            int iIntValue4 = ((Integer) obj8).intValue();
                                                            GapComposer gapComposer4 = (GapComposer) composer4;
                                                            if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                                                                gapComposer4.skipToGroupEnd();
                                                                return unit3;
                                                            }
                                                            int iOrdinal = playlistSortType5.ordinal();
                                                            if (iOrdinal != 0) {
                                                                if (iOrdinal == 1) {
                                                                    i2 = R.string.sort_by_name;
                                                                } else if (iOrdinal == 2) {
                                                                    i2 = R.string.sort_by_song_count;
                                                                } else {
                                                                    if (iOrdinal != 3) {
                                                                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                                                                        return null;
                                                                    }
                                                                    i2 = R.string.sort_by_last_updated;
                                                                }
                                                            }
                                                            TextKt.m352TextNvy7gAk(MathKt.stringResource(i2, gapComposer4), null, 0L, 0L, null, z6 ? FontWeight.Bold : FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262078);
                                                            return unit3;
                                                        default:
                                                            Composer composer5 = (Composer) obj7;
                                                            int iIntValue5 = ((Integer) obj8).intValue();
                                                            GapComposer gapComposer5 = (GapComposer) composer5;
                                                            if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                                                                gapComposer5.skipToGroupEnd();
                                                                return unit3;
                                                            }
                                                            int iOrdinal2 = playlistSortType5.ordinal();
                                                            if (iOrdinal2 != 0) {
                                                                if (iOrdinal2 == 1) {
                                                                    i2 = R.string.sort_by_name;
                                                                } else if (iOrdinal2 == 2) {
                                                                    i2 = R.string.sort_by_song_count;
                                                                } else {
                                                                    if (iOrdinal2 != 3) {
                                                                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                                                                        return null;
                                                                    }
                                                                    i2 = R.string.sort_by_last_updated;
                                                                }
                                                            }
                                                            TextKt.m352TextNvy7gAk(MathKt.stringResource(i2, gapComposer5), null, 0L, 0L, null, z6 ? FontWeight.Bold : FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262078);
                                                            return unit3;
                                                    }
                                                }
                                            }, gapComposer3), null, false, null, roundedCornerShapeM185RoundedCornerShape0680j_5, selectableChipColorsM288filterChipColorsXqyqHi1, null, borderStrokeM287filterChipBorder_7El2pE2, null, null, gapComposer3, 384, 0, 14968);
                                            it = it2;
                                            f = f2;
                                            unit = unit2;
                                            i = 60;
                                            z = true;
                                        }
                                    } else {
                                        gapComposer3.skipToGroupEnd();
                                    }
                                    break;
                            }
                            return unit;
                        }
                    }, gapComposer), gapComposer, 1573296, 56);
                    boolean z = this.f$0;
                    if (z) {
                        gapComposer.startReplaceGroup(1479386063);
                        staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                        j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.tertiaryContainer;
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(1479388524);
                        staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                        j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surfaceVariant;
                        gapComposer.end(false);
                    }
                    AnimateAsState animateAsStateM17animateColorAsStateeuL9pac = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(j, ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, null, 5), "arrowBg", gapComposer, 432, 8);
                    if (z) {
                        gapComposer.startReplaceGroup(1479398993);
                        j2 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onTertiaryContainer;
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(1479401518);
                        j2 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant;
                        gapComposer.end(false);
                    }
                    AnimateAsState animateAsStateM17animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(j2, ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, null, 5), "arrowFg", gapComposer, 432, 8);
                    boolean zChanged = gapComposer.changed(mimesKt$$ExternalSyntheticLambda0);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                        final byte b4 = 0;
                        objRememberedValue = new Function1() { // from class: com.metrolist.music.ui.menu.AddToPlaylistDialogKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj4) {
                                byte b5 = b4;
                                Unit unit = Unit.INSTANCE;
                                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda1 = mimesKt$$ExternalSyntheticLambda0;
                                Boolean bool = (Boolean) obj4;
                                bool.getClass();
                                switch (b5) {
                                    case 0:
                                        mimesKt$$ExternalSyntheticLambda1.invoke(bool);
                                        break;
                                    default:
                                        mimesKt$$ExternalSyntheticLambda1.invoke(bool);
                                        break;
                                }
                                return unit;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.IconToggleButton(z, (Function1) objRememberedValue, SizeKt.m151size3ABfNKs(ImageKt.m39backgroundbw27NRU(ClipKt.clip(companion, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f)), ((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value, ColorKt.RectangleShape), 36.0f), false, null, null, Expect_jvmKt.rememberComposableLambda(-1262578229, new QueueKt$$ExternalSyntheticLambda25(z, animateAsStateM17animateColorAsStateeuL9pac2, (byte) 1), gapComposer), gapComposer, 12582912);
                    gapComposer.end(true);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            default:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    BiasAlignment.Vertical vertical2 = Alignment.Companion.CenterVertically;
                    FlowRowOverflow flowRowOverflow2 = OffsetKt.SpaceBetween;
                    Modifier modifierM136paddingVpY3zN5 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 12.0f, 4.0f);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(flowRowOverflow2, vertical2, gapComposer2, 54);
                    int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM136paddingVpY3zN5);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    OffsetKt.FlowRow(new LayoutWeightElement(1.0f, true), new Arrangement$SpacedAligned(6.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), new Arrangement$SpacedAligned(6.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), null, 0, 0, Expect_jvmKt.rememberComposableLambda(842852633, new Function3() { // from class: com.metrolist.music.ui.menu.AddToPlaylistDialogKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj4, Object obj5, Object obj6) {
                            final byte b5;
                            final byte b6;
                            byte b7 = b2;
                            Unit unit = Unit.INSTANCE;
                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                            int i = 60;
                            float f = 8.0f;
                            EnumEntriesList<PlaylistSortType> enumEntriesList = PlaylistSortType.$ENTRIES;
                            final Function1 function2 = function1;
                            PlaylistSortType playlistSortType2 = playlistSortType;
                            boolean z2 = true;
                            switch (b7) {
                                case 0:
                                    Composer composer3 = (Composer) obj5;
                                    int iIntValue3 = ((Integer) obj6).intValue();
                                    ((FlowRowScopeInstance) obj4).getClass();
                                    boolean z3 = true;
                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                    if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                        for (final PlaylistSortType playlistSortType3 : enumEntriesList) {
                                            boolean z4 = playlistSortType2 == playlistSortType3 ? z3 : false;
                                            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                                            BorderStroke borderStrokeM287filterChipBorder_7El2pE = FilterChipDefaults.m287filterChipBorder_7El2pE(z4, gapComposer3, 60);
                                            StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                                            final boolean z5 = z4;
                                            SelectableChipColors selectableChipColorsM288filterChipColorsXqyqHi0 = FilterChipDefaults.m288filterChipColorsXqyqHi0(((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal3)).colorScheme.surfaceVariant, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal3)).colorScheme.onSurfaceVariant, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal3)).colorScheme.primary, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal3)).colorScheme.onPrimary, 0L, gapComposer3, 3452);
                                            boolean zChanged2 = gapComposer3.changed(function2) | gapComposer3.changed(playlistSortType3.ordinal());
                                            Object objRememberedValue2 = gapComposer3.rememberedValue();
                                            if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                                                b5 = 0;
                                                objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.menu.AddToPlaylistDialogKt$$ExternalSyntheticLambda17
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        byte b8 = b5;
                                                        Unit unit3 = Unit.INSTANCE;
                                                        PlaylistSortType playlistSortType5 = playlistSortType3;
                                                        Function1 function3 = function2;
                                                        switch (b8) {
                                                            case 0:
                                                                function3.invoke(playlistSortType5);
                                                                break;
                                                            default:
                                                                function3.invoke(playlistSortType5);
                                                                break;
                                                        }
                                                        return unit3;
                                                    }
                                                };
                                                gapComposer3.updateRememberedValue(objRememberedValue2);
                                            } else {
                                                b5 = 0;
                                            }
                                            ChipKt.FilterChip(z5, (Function0) objRememberedValue2, Expect_jvmKt.rememberComposableLambda(1473693155, new Function2() { // from class: com.metrolist.music.ui.menu.AddToPlaylistDialogKt$$ExternalSyntheticLambda18
                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(Object obj7, Object obj8) {
                                                    byte b8 = b5;
                                                    Unit unit3 = Unit.INSTANCE;
                                                    int i2 = R.string.sort_by_create_date;
                                                    boolean z6 = z5;
                                                    PlaylistSortType playlistSortType5 = playlistSortType3;
                                                    switch (b8) {
                                                        case 0:
                                                            Composer composer4 = (Composer) obj7;
                                                            int iIntValue4 = ((Integer) obj8).intValue();
                                                            GapComposer gapComposer4 = (GapComposer) composer4;
                                                            if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                                                                gapComposer4.skipToGroupEnd();
                                                                return unit3;
                                                            }
                                                            int iOrdinal = playlistSortType5.ordinal();
                                                            if (iOrdinal != 0) {
                                                                if (iOrdinal == 1) {
                                                                    i2 = R.string.sort_by_name;
                                                                } else if (iOrdinal == 2) {
                                                                    i2 = R.string.sort_by_song_count;
                                                                } else {
                                                                    if (iOrdinal != 3) {
                                                                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                                                                        return null;
                                                                    }
                                                                    i2 = R.string.sort_by_last_updated;
                                                                }
                                                            }
                                                            TextKt.m352TextNvy7gAk(MathKt.stringResource(i2, gapComposer4), null, 0L, 0L, null, z6 ? FontWeight.Bold : FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262078);
                                                            return unit3;
                                                        default:
                                                            Composer composer5 = (Composer) obj7;
                                                            int iIntValue5 = ((Integer) obj8).intValue();
                                                            GapComposer gapComposer5 = (GapComposer) composer5;
                                                            if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                                                                gapComposer5.skipToGroupEnd();
                                                                return unit3;
                                                            }
                                                            int iOrdinal2 = playlistSortType5.ordinal();
                                                            if (iOrdinal2 != 0) {
                                                                if (iOrdinal2 == 1) {
                                                                    i2 = R.string.sort_by_name;
                                                                } else if (iOrdinal2 == 2) {
                                                                    i2 = R.string.sort_by_song_count;
                                                                } else {
                                                                    if (iOrdinal2 != 3) {
                                                                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                                                                        return null;
                                                                    }
                                                                    i2 = R.string.sort_by_last_updated;
                                                                }
                                                            }
                                                            TextKt.m352TextNvy7gAk(MathKt.stringResource(i2, gapComposer5), null, 0L, 0L, null, z6 ? FontWeight.Bold : FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262078);
                                                            return unit3;
                                                    }
                                                }
                                            }, gapComposer3), null, false, null, roundedCornerShapeM185RoundedCornerShape0680j_4, selectableChipColorsM288filterChipColorsXqyqHi0, null, borderStrokeM287filterChipBorder_7El2pE, null, null, gapComposer3, 384, 0, 14968);
                                            z3 = true;
                                        }
                                    } else {
                                        gapComposer3.skipToGroupEnd();
                                    }
                                    break;
                                default:
                                    Composer composer4 = (Composer) obj5;
                                    int iIntValue4 = ((Integer) obj6).intValue();
                                    ((FlowRowScopeInstance) obj4).getClass();
                                    GapComposer gapComposer4 = (GapComposer) composer4;
                                    if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                                        Iterator it = enumEntriesList.iterator();
                                        while (it.hasNext()) {
                                            final PlaylistSortType playlistSortType4 = (PlaylistSortType) it.next();
                                            final boolean z6 = playlistSortType2 == playlistSortType4 ? z2 : false;
                                            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(f);
                                            BorderStroke borderStrokeM287filterChipBorder_7El2pE2 = FilterChipDefaults.m287filterChipBorder_7El2pE(z6, gapComposer4, i);
                                            StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = MaterialThemeKt._localMaterialTheme;
                                            float f2 = f;
                                            Iterator it2 = it;
                                            Unit unit2 = unit;
                                            SelectableChipColors selectableChipColorsM288filterChipColorsXqyqHi1 = FilterChipDefaults.m288filterChipColorsXqyqHi0(((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal4)).colorScheme.surfaceVariant, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal4)).colorScheme.onSurfaceVariant, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal4)).colorScheme.primary, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal4)).colorScheme.onPrimary, 0L, gapComposer4, 3452);
                                            boolean zChanged3 = gapComposer4.changed(function2) | gapComposer4.changed(playlistSortType4.ordinal());
                                            Object objRememberedValue3 = gapComposer4.rememberedValue();
                                            if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                                                b6 = 1;
                                                objRememberedValue3 = new Function0() { // from class: com.metrolist.music.ui.menu.AddToPlaylistDialogKt$$ExternalSyntheticLambda17
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        byte b8 = b6;
                                                        Unit unit3 = Unit.INSTANCE;
                                                        PlaylistSortType playlistSortType5 = playlistSortType4;
                                                        Function1 function3 = function2;
                                                        switch (b8) {
                                                            case 0:
                                                                function3.invoke(playlistSortType5);
                                                                break;
                                                            default:
                                                                function3.invoke(playlistSortType5);
                                                                break;
                                                        }
                                                        return unit3;
                                                    }
                                                };
                                                gapComposer4.updateRememberedValue(objRememberedValue3);
                                            } else {
                                                b6 = 1;
                                            }
                                            ChipKt.FilterChip(z6, (Function0) objRememberedValue3, Expect_jvmKt.rememberComposableLambda(1987077635, new Function2() { // from class: com.metrolist.music.ui.menu.AddToPlaylistDialogKt$$ExternalSyntheticLambda18
                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(Object obj7, Object obj8) {
                                                    byte b8 = b6;
                                                    Unit unit3 = Unit.INSTANCE;
                                                    int i2 = R.string.sort_by_create_date;
                                                    boolean z7 = z6;
                                                    PlaylistSortType playlistSortType5 = playlistSortType4;
                                                    switch (b8) {
                                                        case 0:
                                                            Composer composer5 = (Composer) obj7;
                                                            int iIntValue5 = ((Integer) obj8).intValue();
                                                            GapComposer gapComposer5 = (GapComposer) composer5;
                                                            if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                                                                gapComposer5.skipToGroupEnd();
                                                                return unit3;
                                                            }
                                                            int iOrdinal = playlistSortType5.ordinal();
                                                            if (iOrdinal != 0) {
                                                                if (iOrdinal == 1) {
                                                                    i2 = R.string.sort_by_name;
                                                                } else if (iOrdinal == 2) {
                                                                    i2 = R.string.sort_by_song_count;
                                                                } else {
                                                                    if (iOrdinal != 3) {
                                                                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                                                                        return null;
                                                                    }
                                                                    i2 = R.string.sort_by_last_updated;
                                                                }
                                                            }
                                                            TextKt.m352TextNvy7gAk(MathKt.stringResource(i2, gapComposer5), null, 0L, 0L, null, z7 ? FontWeight.Bold : FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262078);
                                                            return unit3;
                                                        default:
                                                            Composer composer6 = (Composer) obj7;
                                                            int iIntValue6 = ((Integer) obj8).intValue();
                                                            GapComposer gapComposer6 = (GapComposer) composer6;
                                                            if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                                                                gapComposer6.skipToGroupEnd();
                                                                return unit3;
                                                            }
                                                            int iOrdinal2 = playlistSortType5.ordinal();
                                                            if (iOrdinal2 != 0) {
                                                                if (iOrdinal2 == 1) {
                                                                    i2 = R.string.sort_by_name;
                                                                } else if (iOrdinal2 == 2) {
                                                                    i2 = R.string.sort_by_song_count;
                                                                } else {
                                                                    if (iOrdinal2 != 3) {
                                                                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                                                                        return null;
                                                                    }
                                                                    i2 = R.string.sort_by_last_updated;
                                                                }
                                                            }
                                                            TextKt.m352TextNvy7gAk(MathKt.stringResource(i2, gapComposer6), null, 0L, 0L, null, z7 ? FontWeight.Bold : FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 0, 0, 262078);
                                                            return unit3;
                                                    }
                                                }
                                            }, gapComposer4), null, false, null, roundedCornerShapeM185RoundedCornerShape0680j_5, selectableChipColorsM288filterChipColorsXqyqHi1, null, borderStrokeM287filterChipBorder_7El2pE2, null, null, gapComposer4, 384, 0, 14968);
                                            it = it2;
                                            f = f2;
                                            unit = unit2;
                                            i = 60;
                                            z2 = true;
                                        }
                                    } else {
                                        gapComposer4.skipToGroupEnd();
                                    }
                                    break;
                            }
                            return unit;
                        }
                    }, gapComposer2), gapComposer2, 1573296, 56);
                    boolean z2 = this.f$0;
                    if (z2) {
                        gapComposer2.startReplaceGroup(951476239);
                        staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                        j3 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.tertiaryContainer;
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(951478700);
                        staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                        j3 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.surfaceVariant;
                        gapComposer2.end(false);
                    }
                    AnimateAsState animateAsStateM17animateColorAsStateeuL9pac3 = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(j3, ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, null, 5), "arrowBg", gapComposer2, 432, 8);
                    if (z2) {
                        gapComposer2.startReplaceGroup(951489169);
                        j4 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.onTertiaryContainer;
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(951491694);
                        j4 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant;
                        gapComposer2.end(false);
                    }
                    AnimateAsState animateAsStateM17animateColorAsStateeuL9pac4 = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(j4, ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, null, 5), "arrowFg", gapComposer2, 432, 8);
                    boolean zChanged2 = gapComposer2.changed(mimesKt$$ExternalSyntheticLambda0);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer.Companion.Empty) {
                        final byte b5 = 1;
                        objRememberedValue2 = new Function1() { // from class: com.metrolist.music.ui.menu.AddToPlaylistDialogKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj4) {
                                byte b6 = b5;
                                Unit unit = Unit.INSTANCE;
                                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda1 = mimesKt$$ExternalSyntheticLambda0;
                                Boolean bool = (Boolean) obj4;
                                bool.getClass();
                                switch (b6) {
                                    case 0:
                                        mimesKt$$ExternalSyntheticLambda1.invoke(bool);
                                        break;
                                    default:
                                        mimesKt$$ExternalSyntheticLambda1.invoke(bool);
                                        break;
                                }
                                return unit;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    CardKt.IconToggleButton(z2, (Function1) objRememberedValue2, SizeKt.m151size3ABfNKs(ImageKt.m39backgroundbw27NRU(ClipKt.clip(companion, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f)), ((Color) animateAsStateM17animateColorAsStateeuL9pac3.getValue()).value, ColorKt.RectangleShape), 36.0f), false, null, null, Expect_jvmKt.rememberComposableLambda(1855628267, new QueueKt$$ExternalSyntheticLambda25(z2, animateAsStateM17animateColorAsStateeuL9pac4, (byte) 2), gapComposer2), gapComposer2, 12582912);
                    gapComposer2.end(true);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
