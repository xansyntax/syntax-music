package com.metrolist.music.ui.menu;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.navigation.NavHostController;
import coil3.compose.AsyncImageKt;
import com.google.common.math.IntMath;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.db.entities.ArtistEntity;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SongMenuKt$SongMenu$lambda$46$0$$inlined$items$default$4 implements Function4 {
    public final /* synthetic */ ArrayList $items;
    public final /* synthetic */ NavHostController $navController$inlined;
    public final /* synthetic */ Function0 $onDismiss$inlined;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState $showSelectArtistDialog$delegate$inlined;

    public /* synthetic */ SongMenuKt$SongMenu$lambda$46$0$$inlined$items$default$4(ArrayList arrayList, NavHostController navHostController, MutableState mutableState, Function0 function0, byte b) {
        this.$r8$classId = b;
        this.$items = arrayList;
        this.$navController$inlined = navHostController;
        this.$showSelectArtistDialog$delegate$inlined = mutableState;
        this.$onDismiss$inlined = function0;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        int i;
        int i2;
        byte b = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        ArrayList arrayList = this.$items;
        switch (b) {
            case 0:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                int iIntValue = ((Number) obj2).intValue();
                Composer composer = (Composer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                if ((iIntValue2 & 6) == 0) {
                    i = iIntValue2 | (((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2);
                } else {
                    i = iIntValue2;
                }
                if ((iIntValue2 & 48) == 0) {
                    i |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                    ArtistEntity artistEntity = (ArtistEntity) arrayList.get(iIntValue);
                    gapComposer.startReplaceGroup(1024258665);
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(companion, 64.0f);
                    NavHostController navHostController = this.$navController$inlined;
                    boolean zChangedInstance = gapComposer.changedInstance(navHostController) | gapComposer.changed(artistEntity);
                    MutableState mutableState = this.$showSelectArtistDialog$delegate$inlined;
                    boolean zChanged = zChangedInstance | gapComposer.changed(mutableState);
                    Function0 function0 = this.$onDismiss$inlined;
                    boolean zChanged2 = zChanged | gapComposer.changed(function0);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged2 || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new SongMenuKt$SongMenu$12$1$3$1$1(navHostController, artistEntity, function0, mutableState, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(modifierM145height3ABfNKs, false, null, (Function0) objRememberedValue, 15), 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer, 48);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM137paddingVpY3zN4$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda0);
                    Stack.m389reconcileimpl(gapComposer);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 8.0f);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM135padding3ABfNKs);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda0, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    AsyncImageKt.m849AsyncImage10Xjiaw(artistEntity.thumbnailUrl, ClipKt.clip(SizeKt.m151size3ABfNKs(companion, 48.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f)), null, gapComposer, 48, 2040);
                    gapComposer.end(true);
                    TextKt.m352TextNvy7gAk(artistEntity.name, OffsetKt.m137paddingVpY3zN4$default(new LayoutWeightElement(1.0f, true), 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, IntMath.getSp(18), null, FontWeight.Bold, null, 0L, null, 0L, 2, false, 1, 0, null, gapComposer, 1597440, 24960, 241580);
                    gapComposer.end(true);
                    gapComposer.end(false);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            default:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                Composer composer2 = (Composer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                if ((iIntValue4 & 6) == 0) {
                    i2 = iIntValue4 | (((GapComposer) composer2).changed(lazyItemScopeImpl2) ? 4 : 2);
                } else {
                    i2 = iIntValue4;
                }
                if ((iIntValue4 & 48) == 0) {
                    i2 |= ((GapComposer) composer2).changed(iIntValue3) ? 32 : 16;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    ArtistEntity artistEntity2 = (ArtistEntity) arrayList.get(iIntValue3);
                    gapComposer2.startReplaceGroup(1310311437);
                    BiasAlignment.Vertical vertical2 = Alignment.Companion.CenterVertically;
                    SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
                    Modifier modifierM145height3ABfNKs2 = SizeKt.m145height3ABfNKs(companion, 64.0f);
                    NavHostController navHostController2 = this.$navController$inlined;
                    boolean zChangedInstance2 = gapComposer2.changedInstance(navHostController2) | gapComposer2.changed(artistEntity2);
                    MutableState mutableState2 = this.$showSelectArtistDialog$delegate$inlined;
                    boolean zChanged3 = zChangedInstance2 | gapComposer2.changed(mutableState2);
                    Function0 function1 = this.$onDismiss$inlined;
                    boolean zChanged4 = zChanged3 | gapComposer2.changed(function1);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged4 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new SongMenuKt$SongMenu$12$1$3$1$1(navHostController2, artistEntity2, function1, mutableState2, (byte) 1);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(modifierM145height3ABfNKs2, false, null, (Function0) objRememberedValue2, 15), 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical2, gapComposer2, 48);
                    int iHashCode3 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM137paddingVpY3zN4$default2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda0);
                    Stack.m389reconcileimpl(gapComposer2);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda4);
                    Modifier modifierM135padding3ABfNKs2 = OffsetKt.m135padding3ABfNKs(companion, 8.0f);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode4 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM135padding3ABfNKs2);
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer2, updater$$ExternalSyntheticLambda0, gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda4);
                    AsyncImageKt.m849AsyncImage10Xjiaw(artistEntity2.thumbnailUrl, ClipKt.clip(SizeKt.m151size3ABfNKs(companion, 48.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f)), null, gapComposer2, 48, 2040);
                    gapComposer2.end(true);
                    TextKt.m352TextNvy7gAk(artistEntity2.name, OffsetKt.m137paddingVpY3zN4$default(new LayoutWeightElement(1.0f, true), 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, IntMath.getSp(18), null, FontWeight.Bold, null, 0L, null, 0L, 2, false, 1, 0, null, gapComposer2, 1597440, 24960, 241580);
                    gapComposer2.end(true);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
