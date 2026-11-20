package androidx.compose.material3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.foundation.contextmenu.ContextMenuColors;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.lazy.grid.GridCells$Adaptive;
import androidx.compose.foundation.lazy.grid.GridCells$Fixed;
import androidx.compose.foundation.lazy.grid.LazyGridSlots;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScopeImpl;
import androidx.compose.foundation.lazy.layout.LazySaveableStateHolder;
import androidx.compose.foundation.pager.PagerScrollScopeKt$LazyLayoutScrollScope$1;
import androidx.compose.foundation.text.contextmenu.ProcessTextApi23Impl;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt;
import androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors_androidKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.internal.TextFieldImplKt$DecoratedLabel$labelScope$1$1;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.ReusableGapRememberObserverHolder;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.Operation;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeCoordinator$$ExternalSyntheticLambda2;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.SemanticsNodeCopy;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.room.RoomDatabase$closeBarrier$1;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import coil3.util.LifecyclesKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ButtonKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda1(Function3 function3, TextFieldImplKt$DecoratedLabel$labelScope$1$1 textFieldImplKt$DecoratedLabel$labelScope$1$1) {
        this.$r8$classId = (byte) 25;
        this.f$1 = function3;
        this.f$0 = textFieldImplKt$DecoratedLabel$labelScope$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        int i;
        byte b = this.$r8$classId;
        Object obj3 = RowScopeInstance.INSTANCE;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        byte b2 = 6;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                PaddingValues paddingValues = (PaddingValues) obj5;
                Function3 function3 = (Function3) obj4;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                    Modifier modifierPadding = OffsetKt.padding(SizeKt.m143defaultMinSizeVpY3zN4(companion, ButtonDefaults.MinWidth, ButtonDefaults.m250getMinHeightD9Ej5fM()), paddingValues);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Center, Alignment.Companion.CenterVertically, gapComposer, 54);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierPadding);
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
                    function3.invoke(obj3, gapComposer, 6);
                    gapComposer.end(true);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                ((Integer) obj2).getClass();
                EnterExitTransitionKt.DeferredTransitionCleanupEffect((Transition) obj5, (Function0) obj4, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 2:
                ((Integer) obj2).getClass();
                ((ContextMenuScope) obj5).Content$foundation((ContextMenuColors) obj4, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 3:
                float fFloatValue = ((Float) obj).floatValue();
                ((AnchoredDraggableState$anchoredDragScope$1) obj5).dragTo(fFloatValue, ((Float) obj2).floatValue());
                ((Ref$FloatRef) obj4).element = fFloatValue;
                return unit;
            case 4:
                Ref$FloatRef ref$FloatRef = (Ref$FloatRef) obj5;
                float fFloatValue2 = ((Float) obj).floatValue();
                ((Float) obj2).getClass();
                float f = ref$FloatRef.element;
                ref$FloatRef.element = ((ScrollScope) obj4).scrollBy(fFloatValue2 - f) + f;
                return unit;
            case 5:
                SubcomposeMeasureScope subcomposeMeasureScope = (SubcomposeMeasureScope) obj;
                Constraints constraints = (Constraints) obj2;
                return ((MeasurePolicy) obj5).mo13measure3p2s80s(subcomposeMeasureScope, subcomposeMeasureScope.subcompose(unit, new ComposableLambdaImpl(true, -431986394, new ButtonKt$$ExternalSyntheticLambda1((ComposableLambdaImpl) obj4, new BoxWithConstraintsScopeImpl(subcomposeMeasureScope, constraints.value), b2))), constraints.value);
            case 6:
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj5;
                Object obj6 = (BoxWithConstraintsScopeImpl) obj4;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    composableLambdaImpl.invoke(obj6, (Object) gapComposer2, (Object) 0);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 7:
                GridCells$Adaptive gridCells$Adaptive = (GridCells$Adaptive) obj5;
                Arrangement$Horizontal arrangement$Horizontal = (Arrangement$Horizontal) obj4;
                Density density = (Density) obj;
                Constraints constraints2 = (Constraints) obj2;
                if (Constraints.m784getMaxWidthimpl(constraints2.value) == Integer.MAX_VALUE) {
                    InlineClassHelperKt.throwIllegalArgumentException("LazyVerticalGrid's width should be bound by parent.");
                }
                int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(constraints2.value);
                int iMo75roundToPx0680j_4 = density.mo75roundToPx0680j_4(arrangement$Horizontal.mo112getSpacingD9Ej5fM());
                int[] intArray = CollectionsKt.toIntArray(LifecyclesKt.calculateCellsCrossAxisSizeImpl(iM784getMaxWidthimpl, Math.max((iM784getMaxWidthimpl + iMo75roundToPx0680j_4) / (density.mo75roundToPx0680j_4(gridCells$Adaptive.minSize) + iMo75roundToPx0680j_4), 1), iMo75roundToPx0680j_4));
                int[] iArr = new int[intArray.length];
                arrangement$Horizontal.arrange(density, iM784getMaxWidthimpl, intArray, LayoutDirection.Ltr, iArr);
                return new LazyGridSlots(intArray, iArr);
            case 8:
                GridCells$Fixed gridCells$Fixed = (GridCells$Fixed) obj5;
                Arrangement$Vertical arrangement$Vertical = (Arrangement$Vertical) obj4;
                Density density2 = (Density) obj;
                Constraints constraints3 = (Constraints) obj2;
                if (Constraints.m783getMaxHeightimpl(constraints3.value) == Integer.MAX_VALUE) {
                    InlineClassHelperKt.throwIllegalArgumentException("LazyHorizontalGrid's height should be bound by parent.");
                }
                int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(constraints3.value);
                int[] intArray2 = CollectionsKt.toIntArray(LifecyclesKt.calculateCellsCrossAxisSizeImpl(iM783getMaxHeightimpl, gridCells$Fixed.count, density2.mo75roundToPx0680j_4(arrangement$Vertical.mo112getSpacingD9Ej5fM())));
                int[] iArr2 = new int[intArray2.length];
                arrangement$Vertical.arrange(density2, iM783getMaxHeightimpl, intArray2, iArr2);
                return new LazyGridSlots(intArray2, iArr2);
            case 9:
                LazyLayoutItemContentFactory lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) obj5;
                LazyLayoutItemContentFactory.CachedItemContent cachedItemContent = (LazyLayoutItemContentFactory.CachedItemContent) obj4;
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) lazyLayoutItemContentFactory.itemProvider.invoke();
                    int index = cachedItemContent.index;
                    Object obj7 = cachedItemContent.key;
                    if (index >= lazyLayoutItemProvider.getItemCount() || !lazyLayoutItemProvider.getKey(index).equals(obj7)) {
                        index = lazyLayoutItemProvider.getIndex(obj7);
                        i = -1;
                        if (index != -1) {
                            cachedItemContent.index = index;
                        }
                    } else {
                        i = -1;
                    }
                    int i2 = index;
                    if (i2 != i) {
                        gapComposer3.startReplaceGroup(-1664741271);
                        LazyLayoutKt.m174SkippableItemJVlU9Rs(lazyLayoutItemProvider, lazyLayoutItemContentFactory.saveableStateHolder, i2, cachedItemContent.key, gapComposer3, 0);
                        gapComposer3.end(false);
                    } else {
                        gapComposer3.startReplaceGroup(-1664505826);
                        gapComposer3.end(false);
                    }
                    boolean zChangedInstance = gapComposer3.changedInstance(cachedItemContent);
                    Object objRememberedValue = gapComposer3.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new ScrollState$$ExternalSyntheticLambda0((byte) 17, cachedItemContent);
                        gapComposer3.updateRememberedValue(objRememberedValue);
                    }
                    Stack.DisposableEffect(obj7, (Function1) objRememberedValue, gapComposer3);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 10:
                return ((LazyLayoutMeasurePolicy) obj4).mo159measure0kLqBqw(new LazyLayoutMeasureScopeImpl((LazyLayoutItemContentFactory) obj5, (SubcomposeMeasureScope) obj), ((Constraints) obj2).value);
            case 11:
                ComposableLambdaImpl composableLambdaImpl2 = (ComposableLambdaImpl) obj5;
                Object obj8 = (LazySaveableStateHolder) obj4;
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    composableLambdaImpl2.invoke(obj8, (Object) gapComposer4, (Object) 0);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Ref$FloatRef ref$FloatRef2 = (Ref$FloatRef) obj5;
                float fFloatValue3 = ((Float) obj).floatValue();
                ((Float) obj2).getClass();
                ref$FloatRef2.element += ((PagerScrollScopeKt$LazyLayoutScrollScope$1) obj4).$$delegate_0.scrollBy(fFloatValue3 - ref$FloatRef2.element);
                return unit;
            case 13:
                TextContextMenuDataProvider textContextMenuDataProvider = (TextContextMenuDataProvider) obj5;
                TextContextMenuSession textContextMenuSession = (TextContextMenuSession) obj4;
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    boolean zChanged = gapComposer5.changed(textContextMenuDataProvider);
                    Object objRememberedValue2 = gapComposer5.rememberedValue();
                    if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new RoomDatabase$closeBarrier$1(0, textContextMenuDataProvider, TextContextMenuDataProvider.class, "data", "data()Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", 0, (byte) 2));
                        gapComposer5.updateRememberedValue(objRememberedValue2);
                    }
                    DefaultTextContextMenuDropdownProvider_androidKt.DefaultTextContextMenuDropdown(textContextMenuSession, (TextContextMenuData) ((State) objRememberedValue2).getValue(), gapComposer5, 0);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 14:
                ((Integer) obj2).getClass();
                DefaultTextContextMenuDropdownProvider_androidKt.DefaultTextContextMenuDropdown((TextContextMenuSession) obj5, (TextContextMenuData) obj4, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 15:
                ((Integer) obj2).getClass();
                ((TextContextMenuHelperApi28) obj5).IconBox((Drawable) obj4, (Composer) obj, Stack.updateChangedFlags(49));
                return unit;
            case 16:
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) obj5;
                CoroutineScope coroutineScope = (CoroutineScope) obj4;
                TextContextMenuBuilderScope textContextMenuBuilderScope = (TextContextMenuBuilderScope) obj;
                Context context = (Context) obj2;
                boolean editable = textFieldSelectionManager.getEditable();
                AnnotatedString transformedText$foundation = textFieldSelectionManager.getTransformedText$foundation();
                TextRange textRange = null;
                String str = transformedText$foundation != null ? transformedText$foundation.text : null;
                TextRange textRange2 = textFieldSelectionManager.latestSelection;
                if (textRange2 != null) {
                    long j = textRange2.packedValue;
                    OffsetMapping offsetMapping = textFieldSelectionManager.offsetMapping;
                    textRange = new TextRange(TextRangeKt.TextRange(offsetMapping.originalToTransformed((int) (j >> 32)), offsetMapping.originalToTransformed((int) (j & 4294967295L))));
                }
                PlatformSelectionBehaviors platformSelectionBehaviors = textFieldSelectionManager.platformSelectionBehaviors;
                UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0 = new UtilsKt$$ExternalSyntheticLambda0((Object) textFieldSelectionManager, (Object) coroutineScope, (Object) context, (byte) 13);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = PlatformSelectionBehaviors_androidKt.LocalTextClassifierCoroutineContext;
                if (Build.VERSION.SDK_INT < 28 || str == null || textRange == null || platformSelectionBehaviors == null || !(platformSelectionBehaviors instanceof PlatformSelectionBehaviorsImpl)) {
                    utilsKt$$ExternalSyntheticLambda0.invoke(textContextMenuBuilderScope);
                    if (str != null && textRange != null) {
                        ProcessTextApi23Impl.m208addProcessedTextContextMenuItemsUAq72N0(textContextMenuBuilderScope, context, editable, str, textRange.packedValue);
                    }
                } else {
                    String str2 = str;
                    ((PlatformSelectionBehaviorsImpl) platformSelectionBehaviors).m226addSmartSelectionTextContextMenuItemsYmzfRxQ$foundation(textContextMenuBuilderScope, str2, textRange.packedValue, utilsKt$$ExternalSyntheticLambda0);
                    ProcessTextApi23Impl.m208addProcessedTextContextMenuItemsUAq72N0(textContextMenuBuilderScope, context, editable, str2, textRange.packedValue);
                }
                return unit;
            case 17:
                PaddingValues paddingValues2 = (PaddingValues) obj5;
                ComposableLambdaImpl composableLambdaImpl3 = (ComposableLambdaImpl) obj4;
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    PaddingValuesImpl paddingValuesImpl2 = ButtonDefaults.ContentPadding;
                    Modifier modifierPadding2 = OffsetKt.padding(SizeKt.m143defaultMinSizeVpY3zN4(companion, ButtonDefaults.MinWidth, ButtonDefaults.m250getMinHeightD9Ej5fM()), paddingValues2);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Center, Alignment.Companion.CenterVertically, gapComposer6, 54);
                    int iHashCode2 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer6, modifierPadding2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer6.startReusableNode();
                    if (gapComposer6.inserting) {
                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer6.useNode();
                    }
                    Stack.m390setimpl(gapComposer6, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer6, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer6);
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    composableLambdaImpl3.invoke(obj3, (Object) gapComposer6, (Object) 6);
                    gapComposer6.end(true);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 18:
                Function2 function2 = (Function2) obj5;
                State state = (State) obj4;
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    ListItemKt.m303SupportingDecoratorrcwGITA(((Color) state.getValue()).value, function2, gapComposer7, 0);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 19:
                ComposableLambdaImpl composableLambdaImpl4 = (ComposableLambdaImpl) obj5;
                Transition.TransitionAnimationState transitionAnimationState = (Transition.TransitionAnimationState) obj4;
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    ListItemKt.m299ContentDecoratorrcwGITA(((Color) transitionAnimationState.getValue()).value, composableLambdaImpl4, gapComposer8, 0);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 20:
                WindowInsets windowInsets = (WindowInsets) obj5;
                ComposableLambdaImpl composableLambdaImpl5 = (ComposableLambdaImpl) obj4;
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    Modifier modifierSemantics = SemanticsModifierKt.semantics(OffsetKt.m137paddingVpY3zN4$default(SizeKt.m157widthInVpY3zN4$default(OffsetKt.windowInsetsPadding(SizeKt.FillWholeMaxHeight, windowInsets), 80.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, 1), false, new OffsetKt$$ExternalSyntheticLambda0((byte) 22));
                    Object objRememberedValue3 = gapComposer9.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new ChipKt$$ExternalSyntheticLambda3((byte) 29);
                        gapComposer9.updateRememberedValue(objRememberedValue3);
                    }
                    Modifier modifierSemantics2 = SemanticsModifierKt.semantics(modifierSemantics, false, (Function1) objRememberedValue3);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(4.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterHorizontally, gapComposer9, 48);
                    int iHashCode3 = Long.hashCode(gapComposer9.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer9.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer9, modifierSemantics2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer9.startReusableNode();
                    if (gapComposer9.inserting) {
                        gapComposer9.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer9.useNode();
                    }
                    Stack.m390setimpl(gapComposer9, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer9, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer9, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer9);
                    Stack.m390setimpl(gapComposer9, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    gapComposer9.startReplaceGroup(-381406283);
                    gapComposer9.end(false);
                    composableLambdaImpl5.invoke(ColumnScopeInstance.INSTANCE, (Object) gapComposer9, (Object) 6);
                    gapComposer9.end(true);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 21:
                Shape shape = (Shape) obj5;
                MappedInteractionSource mappedInteractionSource = (MappedInteractionSource) obj4;
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                    BoxKt.Box(IndicationKt.indication(ClipKt.clip(RulerKt.layoutId(companion, "indicatorRipple"), shape), mappedInteractionSource, RippleKt.m313rippleOu1YvPQ$default(false, CropImageView.DEFAULT_ASPECT_RATIO, 0L, shape, 247)), gapComposer10, 0);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 22:
                ComposableLambdaImpl composableLambdaImpl6 = (ComposableLambdaImpl) obj5;
                Object obj9 = (ScaffoldKt$ScaffoldLayout$contentPadding$1$1) obj4;
                Composer composer11 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 3) != 2)) {
                    composableLambdaImpl6.invoke(obj9, (Object) gapComposer11, (Object) 6);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case 23:
                MutableState mutableState = (MutableState) obj5;
                ComposableLambdaImpl composableLambdaImpl7 = (ComposableLambdaImpl) obj4;
                Composer composer12 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 3) != 2)) {
                    Object objRememberedValue4 = gapComposer12.rememberedValue();
                    if (objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new TooltipKt$$ExternalSyntheticLambda5(mutableState, false ? (byte) 1 : (byte) 0);
                        gapComposer12.updateRememberedValue(objRememberedValue4);
                    }
                    Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(companion, (Function1) objRememberedValue4);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode4 = Long.hashCode(gapComposer12.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer12.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer12, modifierOnGloballyPositioned);
                    ComposeUiNode.Companion.getClass();
                    gapComposer12.startReusableNode();
                    if (gapComposer12.inserting) {
                        gapComposer12.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer12.useNode();
                    }
                    Stack.m390setimpl(gapComposer12, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer12, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer12, Integer.valueOf(iHashCode4), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer12);
                    Stack.m390setimpl(gapComposer12, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                    Fragment$5$$ExternalSyntheticOutline0.m(0, composableLambdaImpl7, gapComposer12, true);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case 24:
                String str3 = (String) obj5;
                ComposableLambdaImpl composableLambdaImpl8 = (ComposableLambdaImpl) obj4;
                Composer composer13 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 3) != 2)) {
                    boolean zChanged2 = gapComposer13.changed(str3);
                    Object objRememberedValue5 = gapComposer13.rememberedValue();
                    if (zChanged2 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new IconKt$$ExternalSyntheticLambda1(str3, (byte) 10);
                        gapComposer13.updateRememberedValue(objRememberedValue5);
                    }
                    Modifier modifierSemantics3 = SemanticsModifierKt.semantics(companion, false, (Function1) objRememberedValue5);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode5 = Long.hashCode(gapComposer13.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer13.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer13, modifierSemantics3);
                    ComposeUiNode.Companion.getClass();
                    gapComposer13.startReusableNode();
                    if (gapComposer13.inserting) {
                        gapComposer13.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer13.useNode();
                    }
                    Stack.m390setimpl(gapComposer13, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer13, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer13, Integer.valueOf(iHashCode5), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer13);
                    Stack.m390setimpl(gapComposer13, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda0);
                    Fragment$5$$ExternalSyntheticOutline0.m(0, composableLambdaImpl8, gapComposer13, true);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 25:
                Function3 function4 = (Function3) obj4;
                Object obj10 = (TextFieldImplKt$DecoratedLabel$labelScope$1$1) obj5;
                Composer composer14 = (Composer) obj;
                int iIntValue14 = ((Integer) obj2).intValue();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (gapComposer14.shouldExecute(iIntValue14 & 1, (iIntValue14 & 3) != 2)) {
                    function4.invoke(obj10, gapComposer14, 6);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 26:
                RememberEventDispatcher rememberEventDispatcher = (RememberEventDispatcher) obj5;
                SlotWriter slotWriter = (SlotWriter) obj4;
                int iIntValue15 = ((Integer) obj).intValue();
                if (obj2 instanceof ComposeNodeLifecycleCallback) {
                    rememberEventDispatcher.leaving.add((ComposeNodeLifecycleCallback) obj2);
                } else if (!(obj2 instanceof ReusableGapRememberObserverHolder)) {
                    if (obj2 instanceof RememberObserverHolder) {
                        Stack.removeData(slotWriter, iIntValue15, obj2);
                        rememberEventDispatcher.forgetting((RememberObserverHolder) obj2);
                    } else if (obj2 instanceof RecomposeScopeImpl) {
                        Stack.removeData(slotWriter, iIntValue15, obj2);
                        ((RecomposeScopeImpl) obj2).release();
                    }
                }
                return unit;
            case 27:
                AndroidContentCaptureManager androidContentCaptureManager = (AndroidContentCaptureManager) obj4;
                int iIntValue16 = ((Integer) obj).intValue();
                SemanticsNode semanticsNode = (SemanticsNode) obj2;
                if (!((SemanticsNodeCopy) obj5).children.contains(semanticsNode.id)) {
                    androidContentCaptureManager.updateBuffersOnAppeared(iIntValue16, semanticsNode);
                    androidContentCaptureManager.boundsUpdateChannel.mo1712trySendJP2dKIU(unit);
                }
                return unit;
            case 28:
                LayoutNodeSubcompositionsState.NodeState nodeState = (LayoutNodeSubcompositionsState.NodeState) obj5;
                Function2 function5 = (Function2) obj4;
                Composer composer15 = (Composer) obj;
                int iIntValue17 = ((Integer) obj2).intValue();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (gapComposer15.shouldExecute(iIntValue17 & 1, (iIntValue17 & 3) != 2)) {
                    Boolean bool = (Boolean) nodeState.activeState.getValue();
                    boolean zBooleanValue = bool.booleanValue();
                    gapComposer15.startReusableGroup(bool);
                    boolean zChanged3 = gapComposer15.changed(zBooleanValue);
                    if (zBooleanValue) {
                        function5.invoke(gapComposer15, 0);
                    } else {
                        if (gapComposer15.groupNodeCount != 0) {
                            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling deactivateToEndGroup");
                        }
                        if (!gapComposer15.inserting) {
                            if (zChanged3) {
                                SlotReader slotReader = gapComposer15.reader;
                                int i3 = slotReader.currentGroup;
                                int i4 = slotReader.currentEnd;
                                ComposerChangeListWriter composerChangeListWriter = gapComposer15.changeListWriter;
                                composerChangeListWriter.getClass();
                                composerChangeListWriter.realizeOperationLocation(false);
                                composerChangeListWriter.changeList.operations.pushOp(Operation.DeactivateCurrentGroup.INSTANCE);
                                Stack.removeRange(i3, i4, gapComposer15.invalidations);
                                gapComposer15.reader.skipToGroupEnd();
                            } else {
                                gapComposer15.skipReaderToGroupEnd();
                            }
                        }
                    }
                    if (gapComposer15.reusing && gapComposer15.reader.parent == gapComposer15.reusingGroup) {
                        gapComposer15.reusingGroup = -1;
                        gapComposer15.reusing = false;
                    }
                    gapComposer15.end(false);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            default:
                NodeCoordinator nodeCoordinator = (NodeCoordinator) obj5;
                NodeCoordinator$$ExternalSyntheticLambda2 nodeCoordinator$$ExternalSyntheticLambda2 = (NodeCoordinator$$ExternalSyntheticLambda2) obj4;
                Canvas canvas = (Canvas) obj;
                GraphicsLayer graphicsLayer = (GraphicsLayer) obj2;
                LayoutNode layoutNode = nodeCoordinator.layoutNode;
                if (layoutNode.isPlaced()) {
                    nodeCoordinator.drawBlockCanvas = canvas;
                    nodeCoordinator.drawBlockParentLayer = graphicsLayer;
                    ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getSnapshotObserver().observer.observeReads(nodeCoordinator, NodeCoordinator.onCommitAffectingLayer, nodeCoordinator$$ExternalSyntheticLambda2);
                    nodeCoordinator.lastLayerDrawingWasSkipped = false;
                } else {
                    nodeCoordinator.lastLayerDrawingWasSkipped = true;
                }
                return unit;
        }
    }

    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda1(Object obj, Object obj2, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda1(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }
}
