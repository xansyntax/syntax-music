package com.metrolist.music;

import android.content.Context;
import android.content.Intent;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.ScrollingLogic;
import androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.AnalogTimePickerState;
import androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda11;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.NavigationRailItemColors;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SegmentedButtonContentMeasurePolicy;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TimePickerColors;
import androidx.compose.material3.TimePickerKt;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda20;
import androidx.compose.material3.TimePickerState;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda5;
import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyImpl;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ComposeViewContext;
import androidx.compose.ui.platform.WrappedComposition;
import androidx.compose.ui.platform.WrappedComposition$setContent$1$2$1$1;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.common.MediaItem;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.compose.NavHostKt$NavHost$29$1$1$1;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.dokar.quickjs.QuickJs$$ExternalSyntheticLambda1;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda37;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda9 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda9(float f, TimePickerState timePickerState, TimePickerColors timePickerColors, Function0 function0) {
        this.$r8$classId = (byte) 9;
        this.f$0 = timePickerState;
        this.f$1 = timePickerColors;
        this.f$2 = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Exception {
        byte b = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Continuation continuation = null;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        byte b2 = 1;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                MainActivity mainActivity = (MainActivity) obj5;
                ComposeView composeView = (ComposeView) obj4;
                MutableState mutableState = (MutableState) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int i = MainActivity.$r8$clinit;
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    boolean zChangedInstance = gapComposer.changedInstance(mainActivity);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 5, mainActivity);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    boolean zChangedInstance2 = gapComposer.changedInstance(composeView);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2((Object) composeView, (Object) mutableState, (byte) 6);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    DialogKt.AuralysSplash(function0, (Function0) objRememberedValue2, null, gapComposer, 0);
                }
                break;
            case 1:
                Ref$FloatRef ref$FloatRef = (Ref$FloatRef) obj5;
                ScrollingLogic scrollingLogic = (ScrollingLogic) obj4;
                float fFloatValue = ((Float) obj).floatValue();
                ((Float) obj2).getClass();
                long jM106toOffsettuRUvjQ = scrollingLogic.m106toOffsettuRUvjQ(scrollingLogic.reverseIfNeeded(fFloatValue - ref$FloatRef.element));
                ScrollingLogic scrollingLogic2 = ((ScrollingLogic$nestedScrollScope$1) obj3).this$0;
                ref$FloatRef.element += scrollingLogic.reverseIfNeeded(scrollingLogic.m105toFloatk4lQ0M(scrollingLogic2.m103performScroll3eAAhYA(scrollingLogic2.outerStateScope, jM106toOffsettuRUvjQ, 1)));
                break;
            case 2:
                ((Integer) obj2).getClass();
                BasicTextKt.CoreTextFieldRootBox((Modifier) obj5, (TextFieldSelectionManager) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(385));
                break;
            case 3:
                Modifier modifier = (Modifier) obj5;
                MutableState mutableState2 = (MutableState) obj3;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj4;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new TooltipKt$$ExternalSyntheticLambda5(mutableState2, (byte) 6);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(modifier, (Function1) objRememberedValue3);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierOnGloballyPositioned);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    Fragment$5$$ExternalSyntheticOutline0.m(0, composableLambdaImpl, gapComposer2, true);
                }
                break;
            case 4:
                ((Integer) obj2).getClass();
                CardKt.BadgedBox((ComposableLambdaImpl) obj5, (Modifier) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(391));
                break;
            case 5:
                Modifier modifier2 = (Modifier) obj5;
                ScrollState scrollState = (ScrollState) obj4;
                ComposableLambdaImpl composableLambdaImpl2 = (ComposableLambdaImpl) obj3;
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    Modifier modifierScroll$default = ImageKt.scroll$default(OffsetKt.width(OffsetKt.m137paddingVpY3zN4$default(modifier2, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1), IntrinsicSize.Max), scrollState, true);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer3, 0);
                    int iHashCode2 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierScroll$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer3, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    composableLambdaImpl2.invoke((Object) ColumnScopeInstance.INSTANCE, (Object) gapComposer3, (Object) 6);
                    gapComposer3.end(true);
                }
                break;
            case 6:
                Function2 function2 = (Function2) obj5;
                Function2 function3 = (Function2) obj4;
                ComposableLambdaImpl composableLambdaImpl3 = (ComposableLambdaImpl) obj3;
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    if (1.0f <= 0.0d) {
                        InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                    }
                    Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(new LayoutWeightElement(1.0f > Float.MAX_VALUE ? Float.MAX_VALUE : 1.0f, true), function2 != null ? 12.0f : 0.0f, CropImageView.DEFAULT_ASPECT_RATIO, function3 != null ? 12.0f : 0.0f, CropImageView.DEFAULT_ASPECT_RATIO, 10);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode3 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM139paddingqDBjuR0$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer4.startReusableNode();
                    if (gapComposer4.inserting) {
                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer4.useNode();
                    }
                    Stack.m390setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer4);
                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    Fragment$5$$ExternalSyntheticOutline0.m(0, composableLambdaImpl3, gapComposer4, true);
                }
                break;
            case 7:
                State state = (State) obj5;
                NavigationRailItemColors navigationRailItemColors = (NavigationRailItemColors) obj4;
                Shape shape = (Shape) obj3;
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    Modifier modifierLayoutId = RulerKt.layoutId(Modifier.Companion.$$INSTANCE, "indicator");
                    boolean zChanged = gapComposer5.changed(state);
                    Object objRememberedValue4 = gapComposer5.rememberedValue();
                    if (zChanged || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new AppBarKt$$ExternalSyntheticLambda3(state, (byte) 2);
                        gapComposer5.updateRememberedValue(objRememberedValue4);
                    }
                    BoxKt.Box(ImageKt.m39backgroundbw27NRU(ColorKt.graphicsLayer(modifierLayoutId, (Function1) objRememberedValue4), navigationRailItemColors.selectedIndicatorColor, shape), gapComposer5, 0);
                }
                break;
            case 8:
                Function2 function4 = (Function2) obj5;
                ComposableLambdaImpl composableLambdaImpl4 = (ComposableLambdaImpl) obj4;
                FiniteAnimationSpec finiteAnimationSpec = (FiniteAnimationSpec) obj3;
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    Object objRememberedValue5 = gapComposer6.rememberedValue();
                    if (objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = Stack.createCompositionCoroutineScope(gapComposer6);
                        gapComposer6.updateRememberedValue(objRememberedValue5);
                    }
                    CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue5;
                    Object objRememberedValue6 = gapComposer6.rememberedValue();
                    if (objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new SegmentedButtonContentMeasurePolicy(coroutineScope, finiteAnimationSpec);
                        gapComposer6.updateRememberedValue(objRememberedValue6);
                    }
                    SegmentedButtonContentMeasurePolicy segmentedButtonContentMeasurePolicy = (SegmentedButtonContentMeasurePolicy) objRememberedValue6;
                    Modifier modifierHeight = OffsetKt.height();
                    ComposableLambdaImpl composableLambdaImpl5 = new ComposableLambdaImpl(true, 1271844412, new LayoutKt$$ExternalSyntheticLambda0(CollectionsKt__IterablesKt.listOf((Object[]) new Function2[]{function4, composableLambdaImpl4}), (byte) 0));
                    Object objRememberedValue7 = gapComposer6.rememberedValue();
                    if (objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new MultiContentMeasurePolicyImpl(segmentedButtonContentMeasurePolicy);
                        gapComposer6.updateRememberedValue(objRememberedValue7);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue7;
                    int iHashCode4 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer6, modifierHeight);
                    ComposeUiNode.Companion.getClass();
                    gapComposer6.startReusableNode();
                    if (gapComposer6.inserting) {
                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer6.useNode();
                    }
                    Stack.m390setimpl(gapComposer6, measurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer6, Integer.valueOf(iHashCode4), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer6);
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                    Fragment$5$$ExternalSyntheticOutline0.m(0, composableLambdaImpl5, gapComposer6, true);
                }
                break;
            case 9:
                TimePickerState timePickerState = (TimePickerState) obj5;
                TimePickerColors timePickerColors = (TimePickerColors) obj4;
                Function0 function1 = (Function0) obj3;
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer7, 0);
                    int iHashCode5 = Long.hashCode(gapComposer7.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer7.currentCompositionLocalScope();
                    Modifier modifierFocusRequester = Modifier.Companion.$$INSTANCE;
                    Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer7, modifierFocusRequester);
                    ComposeUiNode.Companion.getClass();
                    gapComposer7.startReusableNode();
                    if (gapComposer7.inserting) {
                        gapComposer7.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer7.useNode();
                    }
                    Stack.m390setimpl(gapComposer7, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer7, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer7, Integer.valueOf(iHashCode5), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer7);
                    Stack.m390setimpl(gapComposer7, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda0);
                    Modifier modifierM152sizeVpY3zN4 = SizeKt.m152sizeVpY3zN4(modifierFocusRequester, 96.0f, 80.0f);
                    boolean zChangedInstance3 = gapComposer7.changedInstance(timePickerState);
                    Object objRememberedValue8 = gapComposer7.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new TimePickerKt$$ExternalSyntheticLambda20(timePickerState, (byte) 0);
                        gapComposer7.updateRememberedValue(objRememberedValue8);
                    }
                    TimePickerKt.m356TimeSelectoriO60bNI(FocusTraversalKt.onFocusChanged(modifierM152sizeVpY3zN4, (Function1) objRememberedValue8).then(timePickerState instanceof AnalogTimePickerState ? FocusTraversalKt.focusRequester(modifierFocusRequester, ((AnalogTimePickerState) timePickerState).hourNodeFocusRequester) : modifierFocusRequester), TimePickerKt.getHourForDisplay(timePickerState), timePickerState, 0, TimePickerKt.toTimeInputColors(timePickerColors, gapComposer7), function1, gapComposer7, 196608);
                    TimePickerKt.DisplaySeparator(SizeKt.m152sizeVpY3zN4(modifierFocusRequester, 24.0f, 80.0f), gapComposer7, 0);
                    Modifier modifierM152sizeVpY3zN5 = SizeKt.m152sizeVpY3zN4(modifierFocusRequester, 96.0f, 80.0f);
                    boolean zChangedInstance4 = gapComposer7.changedInstance(timePickerState);
                    Object objRememberedValue9 = gapComposer7.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = new TimePickerKt$$ExternalSyntheticLambda20(timePickerState, (byte) 1);
                        gapComposer7.updateRememberedValue(objRememberedValue9);
                    }
                    Modifier modifierOnFocusChanged = FocusTraversalKt.onFocusChanged(modifierM152sizeVpY3zN5, (Function1) objRememberedValue9);
                    boolean zChangedInstance5 = gapComposer7.changedInstance(timePickerState);
                    Object objRememberedValue10 = gapComposer7.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue10 == neverEqualPolicy) {
                        objRememberedValue10 = new TimePickerKt$$ExternalSyntheticLambda20(timePickerState, (byte) 2);
                        gapComposer7.updateRememberedValue(objRememberedValue10);
                    }
                    Modifier modifierFocusProperties = FocusTraversalKt.focusProperties(modifierOnFocusChanged, (Function1) objRememberedValue10);
                    if (timePickerState instanceof AnalogTimePickerState) {
                        modifierFocusRequester = FocusTraversalKt.focusRequester(modifierFocusRequester, ((AnalogTimePickerState) timePickerState).minuteNodeFocusRequester);
                    }
                    TimePickerKt.m356TimeSelectoriO60bNI(modifierFocusProperties.then(modifierFocusRequester), timePickerState.getMinute(), timePickerState, 1, TimePickerKt.toTimeInputColors(timePickerColors, gapComposer7), function1, gapComposer7, 196608);
                    gapComposer7.end(true);
                }
                break;
            case 10:
                ((Integer) obj2).getClass();
                Icons$Filled.ObserveState((LifecycleOwner) obj5, (Function1) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 11:
                ((Integer) obj2).getClass();
                ((ComposeViewContext) obj5).ProvideCompositionLocals$ui((AndroidComposeView) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                WrappedComposition wrappedComposition = (WrappedComposition) obj5;
                ComposeViewContext composeViewContext = (ComposeViewContext) obj4;
                ComposableLambdaImpl composableLambdaImpl6 = (ComposableLambdaImpl) obj3;
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    AndroidComposeView androidComposeView = wrappedComposition.owner;
                    boolean zChangedInstance6 = gapComposer8.changedInstance(wrappedComposition);
                    Object objRememberedValue11 = gapComposer8.rememberedValue();
                    if (zChangedInstance6 || objRememberedValue11 == neverEqualPolicy) {
                        objRememberedValue11 = new WrappedComposition$setContent$1$2$1$1(wrappedComposition, continuation, (byte) 0);
                        gapComposer8.updateRememberedValue(objRememberedValue11);
                    }
                    Stack.LaunchedEffect(gapComposer8, androidComposeView, (Function2) objRememberedValue11);
                    boolean zChangedInstance7 = gapComposer8.changedInstance(wrappedComposition);
                    Object objRememberedValue12 = gapComposer8.rememberedValue();
                    if (zChangedInstance7 || objRememberedValue12 == neverEqualPolicy) {
                        objRememberedValue12 = new WrappedComposition$setContent$1$2$1$1(wrappedComposition, continuation, b2);
                        gapComposer8.updateRememberedValue(objRememberedValue12);
                    }
                    Stack.LaunchedEffect(gapComposer8, androidComposeView, (Function2) objRememberedValue12);
                    composeViewContext.ProvideCompositionLocals$ui(androidComposeView, composableLambdaImpl6, gapComposer8, 0);
                }
                break;
            case 13:
                ((Integer) obj2).getClass();
                DatabaseDao_Impl.AnonymousClass17.LocalOwnersProvider((NavBackStackEntry) obj5, (SaveableStateHolder) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(385));
                break;
            case 14:
                float fFloatValue2 = ((Float) obj).floatValue();
                ((Float) obj2).getClass();
                AwaitKt.launch$default((CoroutineScope) obj5, null, null, new NavHostKt$NavHost$29$1$1$1(fFloatValue2, (SeekableTransitionState) obj4, (NavBackStackEntry) obj3, null), 3);
                break;
            case 15:
                ((Integer) obj2).getClass();
                DialogKt.AuralysSplash((Function0) obj5, (Function0) obj4, (Modifier) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 16:
                ((Integer) obj2).getClass();
                DialogKt.DraggableLyricsProviderList((List) obj5, (Function1) obj4, (Modifier) obj3, (Composer) obj, Stack.updateChangedFlags(7));
                break;
            case 17:
                ((Integer) obj2).getClass();
                MenuKt.SwipeToSongBox((Modifier) obj5, (MediaItem) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(391));
                break;
            case 18:
                ((Integer) obj2).getClass();
                MenuKt.MediaMetadataListItem((MediaMetadata) obj5, (Modifier) obj4, (Function3) obj3, (Composer) obj, Stack.updateChangedFlags(196609));
                break;
            case 19:
                ((Integer) obj2).getClass();
                MenuKt.SongSelectDropdown((String) obj5, (List) obj4, (MutableState) obj3, (Composer) obj, Stack.updateChangedFlags(385));
                break;
            case 20:
                Function0 function5 = (Function0) obj5;
                Context context = (Context) obj4;
                Album album = (Album) obj3;
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (!gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    function5.invoke();
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", "https://music.youtube.com/playlist?list=" + album.album.playlistId);
                    context.startActivity(Intent.createChooser(intent, null));
                }
                break;
            case 21:
                Function0 function6 = (Function0) obj5;
                Context context2 = (Context) obj4;
                Artist artist = (Artist) obj3;
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (!gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                    gapComposer10.skipToGroupEnd();
                } else {
                    function6.invoke();
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.SEND");
                    intent2.setType("text/plain");
                    intent2.putExtra("android.intent.extra.TEXT", "https://music.youtube.com/channel/" + artist.artist.id);
                    context2.startActivity(Intent.createChooser(intent2, null));
                }
                break;
            case 22:
                Function0 function7 = (Function0) obj5;
                MusicDatabase musicDatabase = (MusicDatabase) obj4;
                State state2 = (State) obj3;
                Composer composer11 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (!gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 3) != 2)) {
                    gapComposer11.skipToGroupEnd();
                } else {
                    boolean zBooleanValue = ((Boolean) state2.getValue()).booleanValue();
                    boolean zChanged2 = gapComposer11.changed(function7) | gapComposer11.changedInstance(musicDatabase);
                    Object objRememberedValue13 = gapComposer11.rememberedValue();
                    if (zChanged2 || objRememberedValue13 == neverEqualPolicy) {
                        objRememberedValue13 = new QuickJs$$ExternalSyntheticLambda1(function7, musicDatabase, (byte) 29);
                        gapComposer11.updateRememberedValue(objRememberedValue13);
                    }
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-18824168, new ListItemKt$$ExternalSyntheticLambda11(state2, (byte) 6), gapComposer11);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    MenuKt.Switch(zBooleanValue, (Function1) objRememberedValue13, null, composableLambdaImplRememberComposableLambda, false, ScrimKt.m324colorsV1nXRL4(((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal)).colorScheme.onPrimary, ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal)).colorScheme.primary, ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal)).colorScheme.primaryContainer, gapComposer11), gapComposer11, 3072, 84);
                }
                break;
            case 23:
                Function0 function8 = (Function0) obj5;
                MusicDatabase musicDatabase2 = (MusicDatabase) obj4;
                MutableState mutableState3 = (MutableState) obj3;
                Composer composer12 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (!gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 3) != 2)) {
                    gapComposer12.skipToGroupEnd();
                } else {
                    boolean zBooleanValue2 = ((Boolean) mutableState3.getValue()).booleanValue();
                    boolean zChanged3 = gapComposer12.changed(function8) | gapComposer12.changedInstance(musicDatabase2);
                    Object objRememberedValue14 = gapComposer12.rememberedValue();
                    if (zChanged3 || objRememberedValue14 == neverEqualPolicy) {
                        objRememberedValue14 = new MainActivity$$ExternalSyntheticLambda21((Object) function8, (Object) mutableState3, (Object) musicDatabase2, (byte) 14);
                        gapComposer12.updateRememberedValue(objRememberedValue14);
                    }
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(140443766, new SongMenuKt$$ExternalSyntheticLambda37(mutableState3, (byte) 11), gapComposer12);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    MenuKt.Switch(zBooleanValue2, (Function1) objRememberedValue14, null, composableLambdaImplRememberComposableLambda2, false, ScrimKt.m324colorsV1nXRL4(((MaterialTheme$Values) gapComposer12.consume(staticProvidableCompositionLocal2)).colorScheme.onPrimary, ((MaterialTheme$Values) gapComposer12.consume(staticProvidableCompositionLocal2)).colorScheme.primary, ((MaterialTheme$Values) gapComposer12.consume(staticProvidableCompositionLocal2)).colorScheme.primaryContainer, gapComposer12), gapComposer12, 3072, 84);
                }
                break;
            case 24:
                Function0 function9 = (Function0) obj5;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) obj4;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) obj3;
                Composer composer13 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (!gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 3) != 2)) {
                    gapComposer13.skipToGroupEnd();
                } else {
                    boolean zChanged4 = gapComposer13.changed(function9);
                    Object objRememberedValue15 = gapComposer13.rememberedValue();
                    if (zChanged4 || objRememberedValue15 == neverEqualPolicy) {
                        objRememberedValue15 = new GapComposer$$ExternalSyntheticLambda0(function9, parcelableSnapshotMutableFloatState, parcelableSnapshotMutableIntState, (byte) 18);
                        gapComposer13.updateRememberedValue(objRememberedValue15);
                    }
                    CardKt.TextButton((Function0) objRememberedValue15, null, false, null, null, null, AlbumMenuKt.lambda$980050462, gapComposer13, 805306368, 510);
                }
                break;
            case 25:
                Boolean bool = Boolean.FALSE;
                ((Integer) obj2).getClass();
                AlbumMenuKt.PlaylistMenu((Playlist) obj5, (CoroutineScope) obj4, (Function0) obj3, bool, bool, EmptyList.INSTANCE, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 26:
                Function0 function10 = (Function0) obj5;
                Context context3 = (Context) obj4;
                State state3 = (State) obj3;
                Composer composer14 = (Composer) obj;
                int iIntValue14 = ((Integer) obj2).intValue();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (!gapComposer14.shouldExecute(iIntValue14 & 1, (iIntValue14 & 3) != 2)) {
                    gapComposer14.skipToGroupEnd();
                } else {
                    function10.invoke();
                    Intent intent3 = new Intent();
                    intent3.setAction("android.intent.action.SEND");
                    intent3.setType("text/plain");
                    Playlist playlist = (Playlist) state3.getValue();
                    intent3.putExtra("android.intent.extra.TEXT", "https://music.youtube.com/playlist?list=" + (playlist != null ? playlist.playlist.browseId : null));
                    context3.startActivity(Intent.createChooser(intent3, null));
                }
                break;
            case 27:
                Function0 function11 = (Function0) obj5;
                PlayerConnection playerConnection = (PlayerConnection) obj4;
                MediaMetadata mediaMetadata = (MediaMetadata) obj3;
                Composer composer15 = (Composer) obj;
                int iIntValue15 = ((Integer) obj2).intValue();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (!gapComposer15.shouldExecute(iIntValue15 & 1, (iIntValue15 & 3) != 2)) {
                    gapComposer15.skipToGroupEnd();
                } else {
                    function11.invoke();
                    String str = playerConnection.getPlayerSafe().getMediaItemAt(playerConnection.getPlayerSafe().getCurrentMediaItemIndex()).mediaId;
                    str.getClass();
                    if (!Intrinsics.areEqual(mediaMetadata.id, str)) {
                        playerConnection.playQueue(YouTubeQueue.INSTANCE.radio(mediaMetadata));
                    } else {
                        playerConnection.startRadioSeamlessly();
                    }
                }
                break;
            case 28:
                Function0 function12 = (Function0) obj5;
                Context context4 = (Context) obj4;
                Song song = (Song) obj3;
                Composer composer16 = (Composer) obj;
                int iIntValue16 = ((Integer) obj2).intValue();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (!gapComposer16.shouldExecute(iIntValue16 & 1, (iIntValue16 & 3) != 2)) {
                    gapComposer16.skipToGroupEnd();
                } else {
                    function12.invoke();
                    Intent intent4 = new Intent();
                    intent4.setAction("android.intent.action.SEND");
                    intent4.setType("text/plain");
                    intent4.putExtra("android.intent.extra.TEXT", "https://music.youtube.com/watch?v=" + song.song.id);
                    context4.startActivity(Intent.createChooser(intent4, null));
                }
                break;
            default:
                Function0 function13 = (Function0) obj5;
                Context context5 = (Context) obj4;
                AlbumItem albumItem = (AlbumItem) obj3;
                Composer composer17 = (Composer) obj;
                int iIntValue17 = ((Integer) obj2).intValue();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (!gapComposer17.shouldExecute(iIntValue17 & 1, (iIntValue17 & 3) != 2)) {
                    gapComposer17.skipToGroupEnd();
                } else {
                    function13.invoke();
                    Intent intent5 = new Intent();
                    intent5.setAction("android.intent.action.SEND");
                    intent5.setType("text/plain");
                    intent5.putExtra("android.intent.extra.TEXT", "https://music.youtube.com/playlist?list=" + albumItem.playlistId);
                    context5.startActivity(Intent.createChooser(intent5, null));
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda9(byte b, int i, Object obj, Object obj2, Object obj3) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda9(Modifier modifier, MutableState mutableState, ComposableLambdaImpl composableLambdaImpl) {
        this.$r8$classId = (byte) 3;
        this.f$0 = modifier;
        this.f$2 = mutableState;
        this.f$1 = composableLambdaImpl;
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda9(Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }
}
