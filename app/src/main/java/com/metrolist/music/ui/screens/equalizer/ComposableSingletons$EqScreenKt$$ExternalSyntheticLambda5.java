package com.metrolist.music.ui.screens.equalizer;

import android.R;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.MenuKt;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda5 implements Function3 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ComposableSingletons$EqScreenKt$$ExternalSyntheticLambda5(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) throws XmlPullParserException, IOException {
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
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.cancel, gapComposer), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
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
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.ok, gapComposer2), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262142);
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
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(com.yalantis.ucrop.R.drawable.download, 0, gapComposer3), (String) null, SizeKt.m151size3ABfNKs(companion, 20.0f), 0L, gapComposer3, 440, 8);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 8.0f, gapComposer3, com.yalantis.ucrop.R.string.eq_download_db, gapComposer3), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                }
                break;
            case 3:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                lazyItemScopeImpl.getClass();
                if ((iIntValue4 & 6) == 0) {
                    iIntValue4 |= ((GapComposer) composer4).changed(lazyItemScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    MenuKt.LibrarySearchEmptyPlaceholder(0, 0, 6, gapComposer4, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), null);
                }
                break;
            case 4:
                LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj;
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                lazyGridItemScopeImpl.getClass();
                if ((iIntValue5 & 6) == 0) {
                    iIntValue5 |= ((GapComposer) composer5).changed(lazyGridItemScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    MenuKt.LibrarySearchEmptyPlaceholder(0, 0, 6, gapComposer5, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), null);
                }
                break;
            case 5:
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO, 48.0f, 1);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer6, modifierM137paddingVpY3zN4$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer6.startReusableNode();
                    if (gapComposer6.inserting) {
                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer6.useNode();
                    }
                    Stack.m390setimpl(gapComposer6, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer6, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer6);
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    String strStringResource = MathKt.stringResource(com.yalantis.ucrop.R.string.no_subscribed_channels, gapComposer6);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource, null, ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer6, 0, 0, 131066);
                    gapComposer6.end(true);
                }
                break;
            case 6:
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO, 48.0f, 1);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode2 = Long.hashCode(gapComposer7.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer7.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer7, modifierM137paddingVpY3zN4$default2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer7.startReusableNode();
                    if (gapComposer7.inserting) {
                        gapComposer7.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer7.useNode();
                    }
                    Stack.m390setimpl(gapComposer7, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer7, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer7, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer7);
                    Stack.m390setimpl(gapComposer7, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    String strStringResource2 = MathKt.stringResource(com.yalantis.ucrop.R.string.no_downloaded_episodes, gapComposer7);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource2, null, ((MaterialTheme$Values) gapComposer7.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer7.consume(staticProvidableCompositionLocal2)).typography.bodyMedium, gapComposer7, 0, 0, 131066);
                    gapComposer7.end(true);
                }
                break;
            case 7:
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(com.yalantis.ucrop.R.string.cancel, gapComposer8), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer8, 0, 0, 262142);
                }
                break;
            case 8:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                lazyItemScopeImpl2.getClass();
                if ((iIntValue9 & 6) == 0) {
                    iIntValue9 |= ((GapComposer) composer9).changed(lazyItemScopeImpl2) ? 4 : 2;
                }
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (!gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 19) != 18)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    MenuKt.LibrarySearchEmptyPlaceholder(0, 0, 6, gapComposer9, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl2, companion), null);
                }
                break;
            case 9:
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (!gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    gapComposer10.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.cancel, gapComposer10), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer10, 0, 0, 262142);
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
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.ok, gapComposer11), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer11, 0, 0, 262142);
                }
                break;
            case 11:
                Composer composer12 = (Composer) obj2;
                int iIntValue12 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (!gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 17) != 16)) {
                    gapComposer12.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(com.yalantis.ucrop.R.string.cancel, gapComposer12), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer12, 0, 0, 262142);
                }
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer13 = (Composer) obj2;
                int iIntValue13 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (!gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 17) != 16)) {
                    gapComposer13.skipToGroupEnd();
                } else {
                    DialogKt.EmptyPlaceholder(com.yalantis.ucrop.R.drawable.music_note, 0, 4, gapComposer13, null, MathKt.stringResource(com.yalantis.ucrop.R.string.playlist_is_empty, gapComposer13));
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
                    DialogKt.EmptyPlaceholder(com.yalantis.ucrop.R.drawable.music_note, 384, 0, gapComposer14, Modifier.Companion.$$INSTANCE, MathKt.stringResource(com.yalantis.ucrop.R.string.playlist_is_empty, gapComposer14));
                }
                break;
            case 14:
                Composer composer15 = (Composer) obj2;
                int iIntValue15 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (!gapComposer15.shouldExecute(iIntValue15 & 1, (iIntValue15 & 17) != 16)) {
                    gapComposer15.skipToGroupEnd();
                } else {
                    DialogKt.EmptyPlaceholder(com.yalantis.ucrop.R.drawable.search, 384, 0, gapComposer15, Modifier.Companion.$$INSTANCE, MathKt.stringResource(com.yalantis.ucrop.R.string.no_results_found, gapComposer15));
                }
                break;
            case 15:
                Composer composer16 = (Composer) obj2;
                int iIntValue16 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (!gapComposer16.shouldExecute(iIntValue16 & 1, (iIntValue16 & 17) != 16)) {
                    gapComposer16.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.cancel, gapComposer16), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer16, 0, 0, 262142);
                }
                break;
            case 16:
                Composer composer17 = (Composer) obj2;
                int iIntValue17 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (!gapComposer17.shouldExecute(iIntValue17 & 1, (iIntValue17 & 17) != 16)) {
                    gapComposer17.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.ok, gapComposer17), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer17, 0, 0, 262142);
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
                LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj;
                Composer composer20 = (Composer) obj2;
                int iIntValue20 = ((Integer) obj3).intValue();
                lazyItemScopeImpl3.getClass();
                if ((iIntValue20 & 6) == 0) {
                    iIntValue20 |= ((GapComposer) composer20).changed(lazyItemScopeImpl3) ? 4 : 2;
                }
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (!gapComposer20.shouldExecute(iIntValue20 & 1, (iIntValue20 & 19) != 18)) {
                    gapComposer20.skipToGroupEnd();
                } else {
                    DialogKt.EmptyPlaceholder(com.yalantis.ucrop.R.drawable.music_note, 0, 0, gapComposer20, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl3, companion), MathKt.stringResource(com.yalantis.ucrop.R.string.playlist_is_empty, gapComposer20));
                }
                break;
            case 20:
                Composer composer21 = (Composer) obj2;
                int iIntValue21 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer21 = (GapComposer) composer21;
                if (!gapComposer21.shouldExecute(iIntValue21 & 1, (iIntValue21 & 17) != 16)) {
                    gapComposer21.skipToGroupEnd();
                }
                break;
            case 21:
                LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj;
                Composer composer22 = (Composer) obj2;
                int iIntValue22 = ((Integer) obj3).intValue();
                lazyItemScopeImpl4.getClass();
                if ((iIntValue22 & 6) == 0) {
                    iIntValue22 |= ((GapComposer) composer22).changed(lazyItemScopeImpl4) ? 4 : 2;
                }
                GapComposer gapComposer22 = (GapComposer) composer22;
                if (!gapComposer22.shouldExecute(iIntValue22 & 1, (iIntValue22 & 19) != 18)) {
                    gapComposer22.skipToGroupEnd();
                } else {
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(LazyItemScopeImpl.fillParentMaxSize$default(lazyItemScopeImpl4), 32.0f);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode3 = Long.hashCode(gapComposer22.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer22.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer22, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer22.startReusableNode();
                    if (gapComposer22.inserting) {
                        gapComposer22.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer22.useNode();
                    }
                    Stack.m390setimpl(gapComposer22, measurePolicyMaybeCachedBoxMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer22, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer22, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer22);
                    Stack.m390setimpl(gapComposer22, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    DialogKt.m1465ContainedLoadingIndicatoreopBjH0(null, 0L, 0L, null, gapComposer22, 0);
                    gapComposer22.end(true);
                }
                break;
            case 22:
                Composer composer23 = (Composer) obj2;
                int iIntValue23 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer23 = (GapComposer) composer23;
                if (!gapComposer23.shouldExecute(iIntValue23 & 1, (iIntValue23 & 17) != 16)) {
                    gapComposer23.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(com.yalantis.ucrop.R.string.retry, gapComposer23), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer23, 0, 0, 262142);
                }
                break;
            case 23:
                LazyItemScopeImpl lazyItemScopeImpl5 = (LazyItemScopeImpl) obj;
                Composer composer24 = (Composer) obj2;
                int iIntValue24 = ((Integer) obj3).intValue();
                lazyItemScopeImpl5.getClass();
                if ((iIntValue24 & 6) == 0) {
                    iIntValue24 |= ((GapComposer) composer24).changed(lazyItemScopeImpl5) ? 4 : 2;
                }
                GapComposer gapComposer24 = (GapComposer) composer24;
                if (!gapComposer24.shouldExecute(iIntValue24 & 1, (iIntValue24 & 19) != 18)) {
                    gapComposer24.skipToGroupEnd();
                } else {
                    Modifier modifierM135padding3ABfNKs2 = OffsetKt.m135padding3ABfNKs(LazyItemScopeImpl.fillParentMaxSize$default(lazyItemScopeImpl5), 32.0f);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode4 = Long.hashCode(gapComposer24.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer24.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer24, modifierM135padding3ABfNKs2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer24.startReusableNode();
                    if (gapComposer24.inserting) {
                        gapComposer24.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer24.useNode();
                    }
                    Stack.m390setimpl(gapComposer24, measurePolicyMaybeCachedBoxMeasurePolicy4, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer24, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer24, Integer.valueOf(iHashCode4), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer24);
                    Stack.m390setimpl(gapComposer24, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(com.yalantis.ucrop.R.string.playlist_is_empty, gapComposer24), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer24.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer24, 0, 0, 131070);
                    gapComposer24.end(true);
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
                    Modifier modifierM135padding3ABfNKs3 = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode5 = Long.hashCode(gapComposer25.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer25.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer25, modifierM135padding3ABfNKs3);
                    ComposeUiNode.Companion.getClass();
                    gapComposer25.startReusableNode();
                    if (gapComposer25.inserting) {
                        gapComposer25.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer25.useNode();
                    }
                    Stack.m390setimpl(gapComposer25, measurePolicyMaybeCachedBoxMeasurePolicy5, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer25, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer25, Integer.valueOf(iHashCode5), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer25);
                    Stack.m390setimpl(gapComposer25, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda0);
                    DialogKt.m1465ContainedLoadingIndicatoreopBjH0(null, 0L, 0L, null, gapComposer25, 0);
                    gapComposer25.end(true);
                }
                break;
            case 25:
                Composer composer26 = (Composer) obj2;
                int iIntValue26 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer26 = (GapComposer) composer26;
                if (!gapComposer26.shouldExecute(iIntValue26 & 1, (iIntValue26 & 17) != 16)) {
                    gapComposer26.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.cancel, gapComposer26), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer26, 0, 0, 262142);
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
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.ok, gapComposer27), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer27, 0, 0, 262142);
                }
                break;
            case 27:
                Composer composer28 = (Composer) obj2;
                int iIntValue28 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer28 = (GapComposer) composer28;
                if (!gapComposer28.shouldExecute(iIntValue28 & 1, (iIntValue28 & 17) != 16)) {
                    gapComposer28.skipToGroupEnd();
                } else {
                    DialogKt.EmptyPlaceholder(com.yalantis.ucrop.R.drawable.music_note, 0, 4, gapComposer28, null, MathKt.stringResource(com.yalantis.ucrop.R.string.playlist_is_empty, gapComposer28));
                }
                break;
            case 28:
                Composer composer29 = (Composer) obj2;
                int iIntValue29 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer29 = (GapComposer) composer29;
                if (!gapComposer29.shouldExecute(iIntValue29 & 1, (iIntValue29 & 17) != 16)) {
                    gapComposer29.skipToGroupEnd();
                } else {
                    Modifier modifierM135padding3ABfNKs4 = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 32.0f);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode6 = Long.hashCode(gapComposer29.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer29.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer29, modifierM135padding3ABfNKs4);
                    ComposeUiNode.Companion.getClass();
                    gapComposer29.startReusableNode();
                    if (gapComposer29.inserting) {
                        gapComposer29.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer29.useNode();
                    }
                    Stack.m390setimpl(gapComposer29, measurePolicyMaybeCachedBoxMeasurePolicy6, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer29, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer29, Integer.valueOf(iHashCode6), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer29);
                    Stack.m390setimpl(gapComposer29, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda0);
                    DialogKt.m1465ContainedLoadingIndicatoreopBjH0(null, 0L, 0L, null, gapComposer29, 0);
                    gapComposer29.end(true);
                }
                break;
            default:
                Composer composer30 = (Composer) obj2;
                int iIntValue30 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer30 = (GapComposer) composer30;
                if (!gapComposer30.shouldExecute(iIntValue30 & 1, (iIntValue30 & 17) != 16)) {
                    gapComposer30.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(com.yalantis.ucrop.R.string.retry, gapComposer30), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer30, 0, 0, 262142);
                }
                break;
        }
        return unit;
    }
}
