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
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
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
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import coil3.compose.AsyncImageKt;
import com.google.common.math.IntMath;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.component.BottomSheetState;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueMenuKt$$ExternalSyntheticLambda5 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ NavHostController f$1;
    public final /* synthetic */ MutableState f$2;
    public final /* synthetic */ BottomSheetState f$3;
    public final /* synthetic */ Function0 f$4;

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda5(List list, NavHostController navHostController, MutableState mutableState, BottomSheetState bottomSheetState, Function0 function0, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$1 = navHostController;
        this.f$2 = mutableState;
        this.f$3 = bottomSheetState;
        this.f$4 = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
        switch (b) {
            case 0:
                lazyListIntervalContent.getClass();
                final List list = this.f$0;
                int size = list.size();
                SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3 songMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3 = new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list, (byte) 11);
                final byte b2 = 0;
                final NavHostController navHostController = this.f$1;
                final MutableState mutableState = this.f$2;
                final BottomSheetState bottomSheetState = this.f$3;
                final Function0 function0 = this.f$4;
                lazyListIntervalContent.items(size, null, songMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3, new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.menu.QueueMenuKt$QueueMenu$lambda$19$0$$inlined$items$default$4
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                        int i;
                        int i2;
                        byte b3 = b2;
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetMeasurePolicy;
                        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                        Function0 function1 = function0;
                        NavHostController navHostController2 = navHostController;
                        List list2 = list;
                        switch (b3) {
                            case 0:
                                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj2;
                                int iIntValue = ((Number) obj3).intValue();
                                Composer composer = (Composer) obj4;
                                int iIntValue2 = ((Number) obj5).intValue();
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
                                    final MediaMetadata.Artist artist = (MediaMetadata.Artist) list2.get(iIntValue);
                                    gapComposer.startReplaceGroup(1314049868);
                                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                    Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(companion, 64.0f);
                                    boolean zChangedInstance = gapComposer.changedInstance(navHostController2) | gapComposer.changedInstance(artist);
                                    final MutableState mutableState2 = mutableState;
                                    boolean zChanged = zChangedInstance | gapComposer.changed(mutableState2);
                                    final BottomSheetState bottomSheetState2 = bottomSheetState;
                                    boolean zChanged2 = gapComposer.changed(function1) | zChanged | gapComposer.changed(bottomSheetState2);
                                    Object objRememberedValue = gapComposer.rememberedValue();
                                    if (zChanged2 || objRememberedValue == neverEqualPolicy) {
                                        final Function0 function2 = function0;
                                        final byte b4 = 0;
                                        final NavHostController navHostController3 = navHostController;
                                        Function0 function3 = new Function0() { // from class: com.metrolist.music.ui.menu.QueueMenuKt$QueueMenu$6$1$1$1$1
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                byte b5 = b4;
                                                Unit unit2 = Unit.INSTANCE;
                                                Function0 function4 = function2;
                                                BottomSheetState bottomSheetState3 = bottomSheetState2;
                                                MutableState mutableState3 = mutableState2;
                                                MediaMetadata.Artist artist2 = artist;
                                                NavHostController navHostController4 = navHostController3;
                                                switch (b5) {
                                                    case 0:
                                                        Format$$ExternalSyntheticOutline0.m("artist/", artist2.id, navHostController4);
                                                        mutableState3.setValue(Boolean.FALSE);
                                                        bottomSheetState3.collapseSoft();
                                                        function4.invoke();
                                                        break;
                                                    default:
                                                        Format$$ExternalSyntheticOutline0.m("artist/", artist2.id, navHostController4);
                                                        mutableState3.setValue(Boolean.FALSE);
                                                        bottomSheetState3.collapseSoft();
                                                        function4.invoke();
                                                        break;
                                                }
                                                return unit2;
                                            }
                                        };
                                        gapComposer.updateRememberedValue(function3);
                                        objRememberedValue = function3;
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
                                    AsyncImageKt.m849AsyncImage10Xjiaw(null, ClipKt.clip(SizeKt.m151size3ABfNKs(companion, 48.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f)), null, gapComposer, 54, 2040);
                                    gapComposer.end(true);
                                    TextKt.m352TextNvy7gAk(artist.name, OffsetKt.m137paddingVpY3zN4$default(new LayoutWeightElement(1.0f, true), 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, IntMath.getSp(18), null, FontWeight.Bold, null, 0L, null, 0L, 2, false, 1, 0, null, gapComposer, 1597440, 24960, 241580);
                                    gapComposer.end(true);
                                    gapComposer.end(false);
                                } else {
                                    gapComposer.skipToGroupEnd();
                                }
                                break;
                            default:
                                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj2;
                                int iIntValue3 = ((Number) obj3).intValue();
                                Composer composer2 = (Composer) obj4;
                                int iIntValue4 = ((Number) obj5).intValue();
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
                                    final MediaMetadata.Artist artist2 = (MediaMetadata.Artist) list2.get(iIntValue3);
                                    gapComposer2.startReplaceGroup(1619493832);
                                    BiasAlignment biasAlignment = Alignment.Companion.CenterStart;
                                    Modifier modifierFillParentMaxWidth$default = LazyItemScopeImpl.fillParentMaxWidth$default(lazyItemScopeImpl2);
                                    SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
                                    Modifier modifierM145height3ABfNKs2 = SizeKt.m145height3ABfNKs(modifierFillParentMaxWidth$default, 64.0f);
                                    boolean zChangedInstance2 = gapComposer2.changedInstance(navHostController2) | gapComposer2.changedInstance(artist2);
                                    final MutableState mutableState3 = mutableState;
                                    boolean zChanged3 = zChangedInstance2 | gapComposer2.changed(mutableState3);
                                    final BottomSheetState bottomSheetState3 = bottomSheetState;
                                    boolean zChanged4 = gapComposer2.changed(function1) | zChanged3 | gapComposer2.changed(bottomSheetState3);
                                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                                    if (zChanged4 || objRememberedValue2 == neverEqualPolicy) {
                                        final Function0 function4 = function0;
                                        final byte b5 = 1;
                                        final NavHostController navHostController4 = navHostController;
                                        objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.menu.QueueMenuKt$QueueMenu$6$1$1$1$1
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                byte b6 = b5;
                                                Unit unit2 = Unit.INSTANCE;
                                                Function0 function5 = function4;
                                                BottomSheetState bottomSheetState4 = bottomSheetState3;
                                                MutableState mutableState4 = mutableState3;
                                                MediaMetadata.Artist artist3 = artist2;
                                                NavHostController navHostController5 = navHostController4;
                                                switch (b6) {
                                                    case 0:
                                                        Format$$ExternalSyntheticOutline0.m("artist/", artist3.id, navHostController5);
                                                        mutableState4.setValue(Boolean.FALSE);
                                                        bottomSheetState4.collapseSoft();
                                                        function5.invoke();
                                                        break;
                                                    default:
                                                        Format$$ExternalSyntheticOutline0.m("artist/", artist3.id, navHostController5);
                                                        mutableState4.setValue(Boolean.FALSE);
                                                        bottomSheetState4.collapseSoft();
                                                        function5.invoke();
                                                        break;
                                                }
                                                return unit2;
                                            }
                                        };
                                        gapComposer2.updateRememberedValue(objRememberedValue2);
                                    }
                                    Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(modifierM145height3ABfNKs2, false, null, (Function0) objRememberedValue2, 15), 24.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
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
                                    Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda2);
                                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda0);
                                    Stack.m389reconcileimpl(gapComposer2);
                                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier3, ComposeUiNode.Companion.SetModifier);
                                    TextKt.m352TextNvy7gAk(artist2.name, null, 0L, IntMath.getSp(18), null, FontWeight.Bold, null, 0L, null, 0L, 2, false, 1, 0, null, gapComposer2, 1597440, 24960, 241582);
                                    gapComposer2.end(true);
                                    gapComposer2.end(false);
                                } else {
                                    gapComposer2.skipToGroupEnd();
                                }
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                }));
                break;
            default:
                lazyListIntervalContent.getClass();
                final List list2 = this.f$0;
                int size2 = list2.size();
                SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3 songMenuKt$SongMenu$lambda$33$0$$inlined$items$default$4 = new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list2, (byte) 10);
                final byte b3 = 1;
                final NavHostController navHostController2 = this.f$1;
                final MutableState mutableState2 = this.f$2;
                final BottomSheetState bottomSheetState2 = this.f$3;
                final Function0 function1 = this.f$4;
                lazyListIntervalContent.items(size2, null, songMenuKt$SongMenu$lambda$33$0$$inlined$items$default$4, new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.menu.QueueMenuKt$QueueMenu$lambda$19$0$$inlined$items$default$4
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                        int i;
                        int i2;
                        byte b4 = b3;
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetMeasurePolicy;
                        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                        Function0 function2 = function1;
                        NavHostController navHostController3 = navHostController2;
                        List list3 = list2;
                        switch (b4) {
                            case 0:
                                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj2;
                                int iIntValue = ((Number) obj3).intValue();
                                Composer composer = (Composer) obj4;
                                int iIntValue2 = ((Number) obj5).intValue();
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
                                    final MediaMetadata.Artist artist = (MediaMetadata.Artist) list3.get(iIntValue);
                                    gapComposer.startReplaceGroup(1314049868);
                                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                    Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(companion, 64.0f);
                                    boolean zChangedInstance = gapComposer.changedInstance(navHostController3) | gapComposer.changedInstance(artist);
                                    final MutableState mutableState3 = mutableState2;
                                    boolean zChanged = zChangedInstance | gapComposer.changed(mutableState3);
                                    final BottomSheetState bottomSheetState3 = bottomSheetState2;
                                    boolean zChanged2 = gapComposer.changed(function2) | zChanged | gapComposer.changed(bottomSheetState3);
                                    Object objRememberedValue = gapComposer.rememberedValue();
                                    if (zChanged2 || objRememberedValue == neverEqualPolicy) {
                                        final Function0 function3 = function1;
                                        final byte b5 = 0;
                                        final NavHostController navHostController4 = navHostController2;
                                        Function0 function4 = new Function0() { // from class: com.metrolist.music.ui.menu.QueueMenuKt$QueueMenu$6$1$1$1$1
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                byte b6 = b5;
                                                Unit unit2 = Unit.INSTANCE;
                                                Function0 function5 = function3;
                                                BottomSheetState bottomSheetState4 = bottomSheetState3;
                                                MutableState mutableState4 = mutableState3;
                                                MediaMetadata.Artist artist3 = artist;
                                                NavHostController navHostController5 = navHostController4;
                                                switch (b6) {
                                                    case 0:
                                                        Format$$ExternalSyntheticOutline0.m("artist/", artist3.id, navHostController5);
                                                        mutableState4.setValue(Boolean.FALSE);
                                                        bottomSheetState4.collapseSoft();
                                                        function5.invoke();
                                                        break;
                                                    default:
                                                        Format$$ExternalSyntheticOutline0.m("artist/", artist3.id, navHostController5);
                                                        mutableState4.setValue(Boolean.FALSE);
                                                        bottomSheetState4.collapseSoft();
                                                        function5.invoke();
                                                        break;
                                                }
                                                return unit2;
                                            }
                                        };
                                        gapComposer.updateRememberedValue(function4);
                                        objRememberedValue = function4;
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
                                    AsyncImageKt.m849AsyncImage10Xjiaw(null, ClipKt.clip(SizeKt.m151size3ABfNKs(companion, 48.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f)), null, gapComposer, 54, 2040);
                                    gapComposer.end(true);
                                    TextKt.m352TextNvy7gAk(artist.name, OffsetKt.m137paddingVpY3zN4$default(new LayoutWeightElement(1.0f, true), 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, IntMath.getSp(18), null, FontWeight.Bold, null, 0L, null, 0L, 2, false, 1, 0, null, gapComposer, 1597440, 24960, 241580);
                                    gapComposer.end(true);
                                    gapComposer.end(false);
                                } else {
                                    gapComposer.skipToGroupEnd();
                                }
                                break;
                            default:
                                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj2;
                                int iIntValue3 = ((Number) obj3).intValue();
                                Composer composer2 = (Composer) obj4;
                                int iIntValue4 = ((Number) obj5).intValue();
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
                                    final MediaMetadata.Artist artist2 = (MediaMetadata.Artist) list3.get(iIntValue3);
                                    gapComposer2.startReplaceGroup(1619493832);
                                    BiasAlignment biasAlignment = Alignment.Companion.CenterStart;
                                    Modifier modifierFillParentMaxWidth$default = LazyItemScopeImpl.fillParentMaxWidth$default(lazyItemScopeImpl2);
                                    SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
                                    Modifier modifierM145height3ABfNKs2 = SizeKt.m145height3ABfNKs(modifierFillParentMaxWidth$default, 64.0f);
                                    boolean zChangedInstance2 = gapComposer2.changedInstance(navHostController3) | gapComposer2.changedInstance(artist2);
                                    final MutableState mutableState4 = mutableState2;
                                    boolean zChanged3 = zChangedInstance2 | gapComposer2.changed(mutableState4);
                                    final BottomSheetState bottomSheetState4 = bottomSheetState2;
                                    boolean zChanged4 = gapComposer2.changed(function2) | zChanged3 | gapComposer2.changed(bottomSheetState4);
                                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                                    if (zChanged4 || objRememberedValue2 == neverEqualPolicy) {
                                        final Function0 function5 = function1;
                                        final byte b6 = 1;
                                        final NavHostController navHostController5 = navHostController2;
                                        objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.menu.QueueMenuKt$QueueMenu$6$1$1$1$1
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                byte b7 = b6;
                                                Unit unit2 = Unit.INSTANCE;
                                                Function0 function6 = function5;
                                                BottomSheetState bottomSheetState5 = bottomSheetState4;
                                                MutableState mutableState5 = mutableState4;
                                                MediaMetadata.Artist artist3 = artist2;
                                                NavHostController navHostController6 = navHostController5;
                                                switch (b7) {
                                                    case 0:
                                                        Format$$ExternalSyntheticOutline0.m("artist/", artist3.id, navHostController6);
                                                        mutableState5.setValue(Boolean.FALSE);
                                                        bottomSheetState5.collapseSoft();
                                                        function6.invoke();
                                                        break;
                                                    default:
                                                        Format$$ExternalSyntheticOutline0.m("artist/", artist3.id, navHostController6);
                                                        mutableState5.setValue(Boolean.FALSE);
                                                        bottomSheetState5.collapseSoft();
                                                        function6.invoke();
                                                        break;
                                                }
                                                return unit2;
                                            }
                                        };
                                        gapComposer2.updateRememberedValue(objRememberedValue2);
                                    }
                                    Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(modifierM145height3ABfNKs2, false, null, (Function0) objRememberedValue2, 15), 24.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
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
                                    Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda2);
                                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda0);
                                    Stack.m389reconcileimpl(gapComposer2);
                                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier3, ComposeUiNode.Companion.SetModifier);
                                    TextKt.m352TextNvy7gAk(artist2.name, null, 0L, IntMath.getSp(18), null, FontWeight.Bold, null, 0L, null, 0L, 2, false, 1, 0, null, gapComposer2, 1597440, 24960, 241582);
                                    gapComposer2.end(true);
                                    gapComposer2.end(false);
                                } else {
                                    gapComposer2.skipToGroupEnd();
                                }
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                }));
                break;
        }
        return unit;
    }
}
