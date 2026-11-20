package androidx.compose.material3;

import androidx.collection.internal.Lock;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.relocation.BringIntoViewRequesterImpl;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.SliderState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.LazyWindowInfo;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import coil3.ImageLoader$Builder;
import coil3.util.FileSystemsKt;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SegmentedButtonKt$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Object f$10;
    public final /* synthetic */ Object f$11;
    public final /* synthetic */ int f$12;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ boolean f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ Object f$8;

    public /* synthetic */ SegmentedButtonKt$$ExternalSyntheticLambda4(TextFieldSelectionManager textFieldSelectionManager, LegacyTextFieldState legacyTextFieldState, boolean z, boolean z2, WindowInfo windowInfo, CoroutineScope coroutineScope, Function1 function1, TextFieldValue textFieldValue, OffsetMapping offsetMapping, Density density, BringIntoViewRequesterImpl bringIntoViewRequesterImpl, int i) {
        this.f$0 = textFieldSelectionManager;
        this.f$2 = legacyTextFieldState;
        this.f$1 = z;
        this.f$5 = z2;
        this.f$3 = windowInfo;
        this.f$4 = coroutineScope;
        this.f$6 = function1;
        this.f$7 = textFieldValue;
        this.f$8 = offsetMapping;
        this.f$10 = density;
        this.f$11 = bringIntoViewRequesterImpl;
        this.f$12 = i;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00c8  */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        boolean z;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$11;
        Object obj4 = this.f$10;
        Object obj5 = this.f$8;
        Object obj6 = this.f$7;
        Object obj7 = this.f$6;
        Object obj8 = this.f$4;
        Object obj9 = this.f$3;
        Object obj10 = this.f$2;
        Object obj11 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                ScrimKt.SegmentedButton((SingleChoiceSegmentedButtonScopeWrapper) obj11, this.f$1, (Function0) obj10, (Shape) obj9, (Modifier) obj8, this.f$5, (SegmentedButtonColors) obj7, (BorderStroke) obj6, (PaddingValues) obj5, (Function2) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(this.f$12 | 1));
                break;
            default:
                final TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) obj11;
                final LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) obj10;
                final WindowInfo windowInfo = (WindowInfo) obj9;
                final CoroutineScope coroutineScope = (CoroutineScope) obj8;
                final Function1 function1 = (Function1) obj7;
                final TextFieldValue textFieldValue = (TextFieldValue) obj6;
                final OffsetMapping offsetMapping = (OffsetMapping) obj5;
                final Density density = (Density) obj4;
                final BringIntoViewRequesterImpl bringIntoViewRequesterImpl = (BringIntoViewRequesterImpl) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    final int i = this.f$12;
                    MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$8$1$1$2
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i2) {
                            LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                            legacyTextFieldState2.textDelegate.layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                            ImageLoader$Builder imageLoader$Builder = (ImageLoader$Builder) legacyTextFieldState2.textDelegate.paragraphIntrinsics;
                            if (imageLoader$Builder != null) {
                                return BasicTextKt.ceilToIntPx(imageLoader$Builder.getMaxIntrinsicWidth());
                            }
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("layoutIntrinsics must be called first");
                            return 0;
                        }

                        /* JADX WARN: Code duplicated, block: B:100:0x02ba  */
                        /* JADX WARN: Code duplicated, block: B:47:0x0106  */
                        /* JADX WARN: Code duplicated, block: B:57:0x0122  */
                        /* JADX WARN: Code duplicated, block: B:59:0x0128  */
                        /* JADX WARN: Code duplicated, block: B:62:0x013e  */
                        /* JADX WARN: Code duplicated, block: B:98:0x02b4  */
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j) {
                            TextLayoutResult textLayoutResult;
                            int iM786getMinWidthimpl;
                            ImageLoader$Builder imageLoader$Builder;
                            TextLayoutResult textLayoutResult2;
                            TextLayoutResult textLayoutResult3;
                            ImageLoader$Builder imageLoader$Builder2;
                            CoreTextFieldKt$CoreTextField$8$1$1$2 coreTextFieldKt$CoreTextField$8$1$1$2;
                            LegacyTextFieldState legacyTextFieldState2;
                            TextLayoutInput textLayoutInput;
                            LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState;
                            Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                            Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                            try {
                                TextLayoutResultProxy layoutResult = legacyTextFieldState3.getLayoutResult();
                                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                TextLayoutResult textLayoutResult4 = layoutResult != null ? layoutResult.value : null;
                                TextDelegate textDelegate = legacyTextFieldState3.textDelegate;
                                LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                                boolean z2 = textDelegate.softWrap;
                                int iCoerceIn = Integer.MAX_VALUE;
                                if (textLayoutResult4 != null) {
                                    MultiParagraph multiParagraph = textLayoutResult4.multiParagraph;
                                    TextLayoutInput textLayoutInput2 = textLayoutResult4.layoutInput;
                                    AnnotatedString annotatedString = (AnnotatedString) textDelegate.text;
                                    TextStyle textStyle = (TextStyle) textDelegate.style;
                                    List list2 = (List) textDelegate.placeholders;
                                    Density density2 = (Density) textDelegate.density;
                                    FontFamily.Resolver resolver = (FontFamily.Resolver) textDelegate.fontFamilyResolver;
                                    if (multiParagraph.intrinsics.getHasStaleResolvedFonts()) {
                                        textLayoutResult = textLayoutResult4;
                                    } else {
                                        AnnotatedString annotatedString2 = textLayoutInput2.text;
                                        TextLayoutResult textLayoutResult5 = textLayoutResult4;
                                        long j2 = textLayoutInput2.constraints;
                                        if (Intrinsics.areEqual(annotatedString2, annotatedString) && textLayoutInput2.style.hasSameLayoutAffectingAttributes(textStyle) && Intrinsics.areEqual(textLayoutInput2.placeholders, list2) && textLayoutInput2.maxLines == Integer.MAX_VALUE && textLayoutInput2.softWrap == z2 && textLayoutInput2.overflow == 1 && Intrinsics.areEqual(textLayoutInput2.density, density2) && textLayoutInput2.layoutDirection == layoutDirection && Intrinsics.areEqual(textLayoutInput2.fontFamilyResolver, resolver) && Constraints.m786getMinWidthimpl(j) == Constraints.m786getMinWidthimpl(j2) && (!z2 || (Constraints.m784getMaxWidthimpl(j) == Constraints.m784getMaxWidthimpl(j2) && Constraints.m783getMaxHeightimpl(j) == Constraints.m783getMaxHeightimpl(j2)))) {
                                            textLayoutResult3 = new TextLayoutResult(new TextLayoutInput(textLayoutInput2.text, (TextStyle) textDelegate.style, textLayoutInput2.placeholders, textLayoutInput2.maxLines, textLayoutInput2.softWrap, textLayoutInput2.overflow, textLayoutInput2.density, textLayoutInput2.layoutDirection, textLayoutInput2.fontFamilyResolver, j), multiParagraph, ConstraintsKt.m789constrain4WqzIAM(j, (((long) BasicTextKt.ceilToIntPx(multiParagraph.height)) & 4294967295L) | (((long) BasicTextKt.ceilToIntPx(multiParagraph.width)) << 32)));
                                            textLayoutResult2 = textLayoutResult5;
                                        } else {
                                            textLayoutResult = textLayoutResult5;
                                        }
                                    }
                                    textDelegate.layoutIntrinsics(layoutDirection);
                                    iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(j);
                                    if (z2 && Constraints.m780getHasBoundedWidthimpl(j)) {
                                        iCoerceIn = Constraints.m784getMaxWidthimpl(j);
                                    }
                                    if (iM786getMinWidthimpl != iCoerceIn) {
                                        imageLoader$Builder2 = (ImageLoader$Builder) textDelegate.paragraphIntrinsics;
                                        if (imageLoader$Builder2 != null) {
                                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("layoutIntrinsics must be called first");
                                            return null;
                                        }
                                        iCoerceIn = UuidKt.coerceIn(BasicTextKt.ceilToIntPx(imageLoader$Builder2.getMaxIntrinsicWidth()), iM786getMinWidthimpl, iCoerceIn);
                                    }
                                    imageLoader$Builder = (ImageLoader$Builder) textDelegate.paragraphIntrinsics;
                                    if (imageLoader$Builder != null) {
                                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("layoutIntrinsics must be called first");
                                        return null;
                                    }
                                    MultiParagraph multiParagraph2 = new MultiParagraph(imageLoader$Builder, FileSystemsKt.m880fitPrioritizingWidthZbe2FdA(0, iCoerceIn, 0, Constraints.m783getMaxHeightimpl(j)), Integer.MAX_VALUE, 1);
                                    textLayoutResult2 = textLayoutResult;
                                    textLayoutResult3 = new TextLayoutResult(new TextLayoutInput((AnnotatedString) textDelegate.text, (TextStyle) textDelegate.style, (List) textDelegate.placeholders, Integer.MAX_VALUE, textDelegate.softWrap, 1, (Density) textDelegate.density, layoutDirection, (FontFamily.Resolver) textDelegate.fontFamilyResolver, j), multiParagraph2, ConstraintsKt.m789constrain4WqzIAM(j, (((long) BasicTextKt.ceilToIntPx(multiParagraph2.width)) << 32) | (((long) BasicTextKt.ceilToIntPx(multiParagraph2.height)) & 4294967295L)));
                                } else {
                                    textLayoutResult = textLayoutResult4;
                                    textDelegate.layoutIntrinsics(layoutDirection);
                                    iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(j);
                                    if (z2) {
                                        iCoerceIn = Constraints.m784getMaxWidthimpl(j);
                                    }
                                    if (iM786getMinWidthimpl != iCoerceIn) {
                                        imageLoader$Builder2 = (ImageLoader$Builder) textDelegate.paragraphIntrinsics;
                                        if (imageLoader$Builder2 != null) {
                                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("layoutIntrinsics must be called first");
                                            return null;
                                        }
                                        iCoerceIn = UuidKt.coerceIn(BasicTextKt.ceilToIntPx(imageLoader$Builder2.getMaxIntrinsicWidth()), iM786getMinWidthimpl, iCoerceIn);
                                    }
                                    imageLoader$Builder = (ImageLoader$Builder) textDelegate.paragraphIntrinsics;
                                    if (imageLoader$Builder != null) {
                                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("layoutIntrinsics must be called first");
                                        return null;
                                    }
                                    MultiParagraph multiParagraph3 = new MultiParagraph(imageLoader$Builder, FileSystemsKt.m880fitPrioritizingWidthZbe2FdA(0, iCoerceIn, 0, Constraints.m783getMaxHeightimpl(j)), Integer.MAX_VALUE, 1);
                                    textLayoutResult2 = textLayoutResult;
                                    textLayoutResult3 = new TextLayoutResult(new TextLayoutInput((AnnotatedString) textDelegate.text, (TextStyle) textDelegate.style, (List) textDelegate.placeholders, Integer.MAX_VALUE, textDelegate.softWrap, 1, (Density) textDelegate.density, layoutDirection, (FontFamily.Resolver) textDelegate.fontFamilyResolver, j), multiParagraph3, ConstraintsKt.m789constrain4WqzIAM(j, (((long) BasicTextKt.ceilToIntPx(multiParagraph3.width)) << 32) | (((long) BasicTextKt.ceilToIntPx(multiParagraph3.height)) & 4294967295L)));
                                }
                                long j3 = textLayoutResult3.size;
                                Integer numValueOf = Integer.valueOf((int) (j3 >> 32));
                                Integer numValueOf2 = Integer.valueOf((int) (j3 & 4294967295L));
                                int iIntValue2 = numValueOf.intValue();
                                int iIntValue3 = numValueOf2.intValue();
                                MultiParagraph multiParagraph4 = textLayoutResult3.multiParagraph;
                                multiParagraph4.intrinsics.getHasStaleResolvedFonts();
                                TextLayoutResult textLayoutResult6 = textLayoutResult2;
                                if (Intrinsics.areEqual(textLayoutResult6, textLayoutResult3)) {
                                    coreTextFieldKt$CoreTextField$8$1$1$2 = this;
                                    legacyTextFieldState2 = legacyTextFieldState3;
                                } else {
                                    legacyTextFieldState2 = legacyTextFieldState3;
                                    legacyTextFieldState2.layoutResultState.setValue(new TextLayoutResultProxy(textLayoutResult3, layoutResult != 0 ? layoutResult.decorationBoxCoordinates : null));
                                    legacyTextFieldState2.isLayoutResultStale = false;
                                    coreTextFieldKt$CoreTextField$8$1$1$2 = this;
                                    TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                    if (textFieldSelectionManager2.getEnabled() && textFieldSelectionManager2.getEditable() && ((LazyWindowInfo) windowInfo).isWindowFocused() && TextRange.m741getCollapsedimpl(((TextRange) legacyTextFieldState2.selectionPreviewHighlightRange$delegate.getValue()).packedValue) && TextRange.m741getCollapsedimpl(((TextRange) legacyTextFieldState2.deletionPreviewHighlightRange$delegate.getValue()).packedValue) && legacyTextFieldState2.getHasFocus()) {
                                        if (!Intrinsics.areEqual((textLayoutResult6 == null || (textLayoutInput = textLayoutResult6.layoutInput) == null) ? null : textLayoutInput.text, textLayoutResult3.layoutInput.text)) {
                                            AwaitKt.launch$default(coroutineScope, null, null, new SliderState.AnonymousClass2(textFieldSelectionManager2, bringIntoViewRequesterImpl, null, (byte) 10), 3);
                                        }
                                    }
                                    function1.invoke(textLayoutResult3);
                                    BasicTextKt.notifyFocusedRect(legacyTextFieldState2, textFieldValue, offsetMapping);
                                }
                                legacyTextFieldState2.heightForSingleLineField$delegate.setValue(new Dp(density.mo78toDpu2uoSUM(i == 1 ? BasicTextKt.ceilToIntPx(multiParagraph4.getLineBottom(0)) : 0)));
                                return measureScope.layout(iIntValue2, iIntValue3, MapsKt__MapsKt.mapOf(new Pair(AlignmentLineKt.FirstBaseline, Integer.valueOf(Math.round(textLayoutResult3.firstBaseline))), new Pair(AlignmentLineKt.LastBaseline, Integer.valueOf(Math.round(textLayoutResult3.lastBaseline)))), new OffsetKt$$ExternalSyntheticLambda0((byte) 26));
                            } catch (Throwable th) {
                                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                throw th;
                            }
                        }
                    };
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, Modifier.Companion.$$INSTANCE);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, measurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    gapComposer.end(true);
                    HandleState handleState = legacyTextFieldState.getHandleState();
                    HandleState handleState2 = HandleState.None;
                    boolean z2 = this.f$1;
                    if (handleState != handleState2 && legacyTextFieldState.getLayoutCoordinates() != null) {
                        LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
                        layoutCoordinates.getClass();
                        z = layoutCoordinates.isAttached$1() && z2;
                    }
                    BasicTextKt.SelectionToolbarAndHandles(textFieldSelectionManager, z, gapComposer, 0);
                    if (legacyTextFieldState.getHandleState() == HandleState.Cursor && !this.f$5 && z2) {
                        gapComposer.startReplaceGroup(-713510518);
                        BasicTextKt.TextFieldCursorHandle(textFieldSelectionManager, gapComposer, 0);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-713433638);
                        gapComposer.end(false);
                    }
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ SegmentedButtonKt$$ExternalSyntheticLambda4(SingleChoiceSegmentedButtonScopeWrapper singleChoiceSegmentedButtonScopeWrapper, boolean z, Function0 function0, Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, PaddingValues paddingValues, Function2 function2, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$0 = singleChoiceSegmentedButtonScopeWrapper;
        this.f$1 = z;
        this.f$2 = function0;
        this.f$3 = shape;
        this.f$4 = modifier;
        this.f$5 = z2;
        this.f$6 = segmentedButtonColors;
        this.f$7 = borderStroke;
        this.f$8 = paddingValues;
        this.f$10 = function2;
        this.f$11 = composableLambdaImpl;
        this.f$12 = i;
    }
}
