package com.metrolist.music.ui.player;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda22;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.utils.AppBarKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerKt$$ExternalSyntheticLambda74 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ State f$0;

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda74(State state, byte b) {
        this.$r8$classId = b;
        this.f$0 = state;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) throws XmlPullParserException, IOException {
        byte b = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        byte b2 = 18;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        State state = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    boolean zChanged = gapComposer.changed(state);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new MainActivity$$ExternalSyntheticLambda22(state, b2);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    AppBarKt.ShowOffsetDialog((Function0) objRememberedValue, gapComposer, 0);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyGridItemScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(companion, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer2, 48);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM137paddingVpY3zN4$default);
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
                    OffsetKt.Spacer(gapComposer2, new LayoutWeightElement(1.0f, true));
                    String strPluralStringResource = MathKt.pluralStringResource(R.plurals.n_album, ((List) state.getValue()).size(), new Object[]{Integer.valueOf(((List) state.getValue()).size())}, gapComposer2);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strPluralStringResource, null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.secondary, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.titleSmall, gapComposer2, 0, 0, 131066);
                    gapComposer2.end(true);
                }
                break;
            case 2:
                LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                lazyGridItemScopeImpl.getClass();
                if ((iIntValue3 & 6) == 0) {
                    iIntValue3 |= ((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                    gapComposer3.skipToGroupEnd();
                } else if (!StringsKt.isBlank((String) state.getValue())) {
                    gapComposer3.startReplaceGroup(-763068539);
                    MenuKt.LibrarySearchEmptyPlaceholder(R.drawable.search, 0, 0, gapComposer3, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), MathKt.stringResource(R.string.no_results_found, gapComposer3));
                    gapComposer3.end(false);
                } else {
                    gapComposer3.startReplaceGroup(-762694431);
                    MenuKt.LibrarySearchEmptyPlaceholder(R.drawable.artist, 0, 0, gapComposer3, LazyGridItemScopeImpl.animateItem$default(lazyGridItemScopeImpl, companion), MathKt.stringResource(R.string.library_artist_empty, gapComposer3));
                    gapComposer3.end(false);
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
                } else if (!StringsKt.isBlank((String) state.getValue())) {
                    gapComposer4.startReplaceGroup(149546010);
                    MenuKt.LibrarySearchEmptyPlaceholder(R.drawable.search, 0, 0, gapComposer4, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), MathKt.stringResource(R.string.no_results_found, gapComposer4));
                    gapComposer4.end(false);
                } else {
                    gapComposer4.startReplaceGroup(149920118);
                    MenuKt.LibrarySearchEmptyPlaceholder(R.drawable.artist, 0, 0, gapComposer4, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), MathKt.stringResource(R.string.library_artist_empty, gapComposer4));
                    gapComposer4.end(false);
                }
                break;
            default:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    BiasAlignment.Vertical vertical2 = Alignment.Companion.CenterVertically;
                    Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, 4.0f);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical2, gapComposer5, 48);
                    int iHashCode2 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer5.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer5, modifierM136paddingVpY3zN4);
                    ComposeUiNode.Companion.getClass();
                    gapComposer5.startReusableNode();
                    if (gapComposer5.inserting) {
                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer5.useNode();
                    }
                    Stack.m390setimpl(gapComposer5, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer5, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer5);
                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    String strPluralStringResource2 = MathKt.pluralStringResource(R.plurals.n_channel, ((List) state.getValue()).size(), new Object[]{Integer.valueOf(((List) state.getValue()).size())}, gapComposer5);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strPluralStringResource2, null, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal2)).typography.titleSmall, gapComposer5, 0, 0, 131066);
                    gapComposer5.end(true);
                }
                break;
        }
        return unit;
    }
}
