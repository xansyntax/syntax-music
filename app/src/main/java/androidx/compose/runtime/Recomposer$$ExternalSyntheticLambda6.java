package androidx.compose.runtime;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.textclassifier.TextClassification;
import androidx.activity.compose.ComposeBackHandler;
import androidx.activity.compose.ComposePredictiveBackHandler;
import androidx.collection.MutableScatterSet;
import androidx.compose.foundation.BackgroundNode;
import androidx.compose.foundation.FocusableNode;
import androidx.compose.foundation.MarqueeModifierNode;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.lazy.grid.LazyGridIntervalContent;
import androidx.compose.foundation.lazy.grid.LazyGridItemProviderImpl;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.layout.LazySaveableStateHolder;
import androidx.compose.foundation.pager.PagerLayoutIntervalContent;
import androidx.compose.foundation.pager.PagerLazyLayoutItemProvider;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextAnnotatorScope;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.TextLinkScope;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.internal.TextClassificationHelper34;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$WhenMappings;
import androidx.compose.material3.BottomSheetKt$BottomSheetImpl$6$1$1$1$1;
import androidx.compose.material3.FadeInFadeOutState;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SheetValue;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.material3.internal.BasicTooltipKt$anchorSemantics$1$1$1;
import androidx.compose.material3.internal.Listener;
import androidx.compose.material3.ripple.AndroidRippleNode;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotTableKt;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.tooling.ComposeStackTrace;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import androidx.compose.runtime.tooling.ObjectLocation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawModifierNodeImpl;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HitPathTracker;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.PinnableContainerKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.platform.AndroidUriHandler;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.emoji2.text.EmojiProcessor;
import androidx.sqlite.SQLite;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.discord.DiscordRpcManager$authorize$completeWith$1;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Recomposer$$ExternalSyntheticLambda6 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ Recomposer$$ExternalSyntheticLambda6(TextLinkScope textLinkScope, AnnotatedString.Range range, UriHandler uriHandler) {
        this.$r8$classId = (byte) 11;
        this.f$0 = range;
        this.f$1 = uriHandler;
    }

    /* JADX WARN: Code duplicated, block: B:240:0x049d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:241:0x049f A[LOOP:6: B:231:0x046c->B:241:0x049f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:270:0x04a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x0142  */
    /* JADX WARN: Code duplicated, block: B:98:0x015f  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v100 */
    /* JADX WARN: Type inference failed for: r0v101 */
    /* JADX WARN: Type inference failed for: r0v19, types: [androidx.compose.runtime.snapshots.SnapshotStateList] */
    /* JADX WARN: Type inference failed for: r0v90 */
    /* JADX WARN: Type inference failed for: r0v91, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v93 */
    /* JADX WARN: Type inference failed for: r0v94, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v95, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v96 */
    /* JADX WARN: Type inference failed for: r0v97 */
    /* JADX WARN: Type inference failed for: r0v98 */
    /* JADX WARN: Type inference failed for: r0v99 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r6v0, types: [byte] */
    /* JADX WARN: Type inference failed for: r6v1, types: [int] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        TextLinkScope$$ExternalSyntheticLambda10 textLinkScope$$ExternalSyntheticLambda10;
        long j;
        TextLayoutResultProxy layoutResult;
        LegacyTextFieldState legacyTextFieldState;
        AnnotatedString annotatedString;
        List listPlus;
        SlotReader slotReaderOpenReader;
        byte b = this.$r8$classId;
        ObjectLocation objectLocation = null;
        boolean z = false;
        boolean z2 = false;
        ?? r6 = 0;
        Unit unit = Unit.INSTANCE;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (b) {
            case 0:
                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                CompositionImpl compositionImpl = (CompositionImpl) obj;
                Object[] objArr = mutableScatterSet.elements;
                long[] jArr = mutableScatterSet.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j2 = jArr[i];
                        if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j2) < 128) {
                                    compositionImpl.recordWriteOf(objArr[(i << 3) + i3]);
                                }
                                j2 >>= 8;
                            }
                            if (i2 == 8) {
                                if (i != length) {
                                    i++;
                                }
                            }
                        } else if (i != length) {
                            i++;
                        }
                    }
                }
                return unit;
            case 1:
                ((ComposeBackHandler) obj2).currentOnBackCompleted = (Function0) obj;
                return unit;
            case 2:
                ((ComposePredictiveBackHandler) obj2).currentOnBack = (Function2) obj;
                return unit;
            case 3:
                BackgroundNode backgroundNode = (BackgroundNode) obj2;
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                backgroundNode.tmpOutline = backgroundNode.shape.mo56createOutlinePq9zytI(layoutNodeDrawScope.canvasDrawScope.mo556getSizeNHjbRc(), layoutNodeDrawScope.getLayoutDirection(), layoutNodeDrawScope);
                return unit;
            case 4:
                ((Ref$ObjectRef) obj2).element = HitTestResultKt.currentValueOf((FocusableNode) obj, PinnableContainerKt.LocalPinnableContainer);
                return unit;
            case 5:
                MarqueeModifierNode marqueeModifierNode = (MarqueeModifierNode) obj;
                Density density = HitTestResultKt.requireLayoutNode(marqueeModifierNode).density;
                marqueeModifierNode.contentWidth$delegate.getIntValue();
                int intValue = marqueeModifierNode.containerWidth$delegate.getIntValue();
                ((MarqueeSpacing$Companion$$ExternalSyntheticLambda0) obj2).getClass();
                return Integer.valueOf(MathKt.roundToInt(0.33333334f * intValue));
            case 6:
                LazyGridState lazyGridState = (LazyGridState) obj;
                LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) ((DerivedSnapshotState) obj2).getValue();
                return new LazyGridItemProviderImpl(lazyGridState, lazyGridIntervalContent, new StatusLine((IntRange) lazyGridState.scrollPosition.nearestRangeState.getValue(), lazyGridIntervalContent));
            case 7:
                return new LazySaveableStateHolder((SaveableStateRegistry) obj2, EmptyMap.INSTANCE, (SaveableStateHolder) obj);
            case 8:
                PagerState pagerState = (PagerState) obj;
                PagerLayoutIntervalContent pagerLayoutIntervalContent = (PagerLayoutIntervalContent) ((DerivedSnapshotState) obj2).getValue();
                return new PagerLazyLayoutItemProvider(pagerState, pagerLayoutIntervalContent, new StatusLine((IntRange) pagerState.scrollPosition.nearestRangeState.getValue(), pagerLayoutIntervalContent));
            case 9:
                TextFieldValue textFieldValue = (TextFieldValue) obj2;
                MutableState mutableState = (MutableState) obj;
                if (!TextRange.m740equalsimpl0(textFieldValue.selection, ((TextFieldValue) mutableState.getValue()).selection) || !Intrinsics.areEqual(textFieldValue.composition, ((TextFieldValue) mutableState.getValue()).composition)) {
                    mutableState.setValue(textFieldValue);
                }
                return unit;
            case 10:
                TextLinkScope textLinkScope = (TextLinkScope) obj2;
                AnnotatedString annotatedString2 = (AnnotatedString) obj;
                if (textLinkScope == null) {
                    return annotatedString2;
                }
                ?? r0 = textLinkScope.annotators;
                boolean zIsEmpty = r0.isEmpty();
                AnnotatedString annotatedString3 = textLinkScope.text;
                if (!zIsEmpty) {
                    TextAnnotatorScope textAnnotatorScope = new TextAnnotatorScope(annotatedString3);
                    int size = r0.size();
                    while (r6 < size) {
                        ((Function1) r0.get(r6)).invoke(textAnnotatorScope);
                        r6++;
                    }
                    annotatedString3 = textAnnotatorScope.styledText;
                }
                textLinkScope.text = annotatedString3;
                return annotatedString3 == null ? annotatedString2 : annotatedString3;
            case 11:
                UriHandler uriHandler = (UriHandler) obj;
                LinkAnnotation linkAnnotation = (LinkAnnotation) ((AnnotatedString.Range) obj2).item;
                if (linkAnnotation instanceof LinkAnnotation.Url) {
                    TextLinkScope$$ExternalSyntheticLambda10 textLinkScope$$ExternalSyntheticLambda11 = ((LinkAnnotation.Url) linkAnnotation).linkInteractionListener;
                    if (textLinkScope$$ExternalSyntheticLambda11 != null) {
                        textLinkScope$$ExternalSyntheticLambda11.onClick(linkAnnotation);
                    } else {
                        try {
                            ((AndroidUriHandler) uriHandler).openUri(((LinkAnnotation.Url) linkAnnotation).url);
                            break;
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                } else if ((linkAnnotation instanceof LinkAnnotation.Clickable) && (textLinkScope$$ExternalSyntheticLambda10 = ((LinkAnnotation.Clickable) linkAnnotation).linkInteractionListener) != null) {
                    textLinkScope$$ExternalSyntheticLambda10.onClick(linkAnnotation);
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((Ref$ObjectRef) obj2).element = ((Function0) obj).invoke();
                return unit;
            case 13:
                return new IntOffset(SQLite.m847roundk4lQ0M(((TextContextMenuDataProvider) obj2).mo211positiontuRUvjQ((LayoutCoordinates) ((Function0) obj).invoke())));
            case 14:
                ((TextContextMenuItem) obj2).onClick.invoke((TextContextMenuSession) obj);
                return unit;
            case 15:
                Context context = (Context) obj2;
                TextClassification textClassification = (TextClassification) obj;
                String text = textClassification.getText();
                PendingIntent activity = PendingIntent.getActivity(context, text != null ? text.hashCode() : 0, textClassification.getIntent(), 201326592);
                if (Build.VERSION.SDK_INT >= 34) {
                    TextClassificationHelper34.sendIntentAllowBackgroundActivityStart(activity);
                } else {
                    activity.send();
                }
                return unit;
            case 16:
                AwaitKt.launch$default((CoroutineScope) obj2, null, CoroutineStart.UNDISPATCHED, new DiscordRpcManager$authorize$completeWith$1((Function1) obj, null), 1);
                return unit;
            case 17:
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) obj2;
                long j3 = ((IntSize) ((MutableState) obj).getValue()).packedValue;
                Offset offsetM232getCurrentDragPosition_m7T9E = textFieldSelectionManager.m232getCurrentDragPosition_m7T9E();
                long jFloatToRawIntBits = 9205357640488583168L;
                if (offsetM232getCurrentDragPosition_m7T9E != null) {
                    long j4 = offsetM232getCurrentDragPosition_m7T9E.packedValue;
                    AnnotatedString transformedText$foundation = textFieldSelectionManager.getTransformedText$foundation();
                    if (transformedText$foundation != null && transformedText$foundation.text.length() != 0) {
                        Handle handle = (Handle) textFieldSelectionManager.draggingHandle$delegate.getValue();
                        int i4 = handle == null ? -1 : TextFieldSelectionManagerKt$WhenMappings.$EnumSwitchMapping$0[handle.ordinal()];
                        if (i4 != -1) {
                            if (i4 == 1 || i4 == 2) {
                                long j5 = textFieldSelectionManager.getValue$foundation().selection;
                                int i5 = TextRange.$r8$clinit;
                                j = j5 >> 32;
                            } else {
                                if (i4 != 3) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                long j6 = textFieldSelectionManager.getValue$foundation().selection;
                                int i6 = TextRange.$r8$clinit;
                                j = j6 & 4294967295L;
                            }
                            int i7 = (int) j;
                            LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager.state;
                            if (legacyTextFieldState2 != null && (layoutResult = legacyTextFieldState2.getLayoutResult()) != null && (legacyTextFieldState = textFieldSelectionManager.state) != null && (annotatedString = (AnnotatedString) legacyTextFieldState.textDelegate.text) != null) {
                                int iCoerceIn = UuidKt.coerceIn(textFieldSelectionManager.offsetMapping.originalToTransformed(i7), 0, annotatedString.text.length());
                                float fIntBitsToFloat = Float.intBitsToFloat((int) (layoutResult.m206translateDecorationToInnerCoordinatesMKHz9U$foundation(j4) >> 32));
                                TextLayoutResult textLayoutResult = layoutResult.value;
                                MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
                                int lineForOffset = multiParagraph.getLineForOffset(iCoerceIn);
                                float lineLeft = textLayoutResult.getLineLeft(lineForOffset);
                                float lineRight = textLayoutResult.getLineRight(lineForOffset);
                                float fCoerceIn = UuidKt.coerceIn(fIntBitsToFloat, Math.min(lineLeft, lineRight), Math.max(lineLeft, lineRight));
                                if (IntSize.m810equalsimpl0(j3, 0L) || Math.abs(fIntBitsToFloat - fCoerceIn) <= ((int) (j3 >> 32)) / 2) {
                                    float lineTop = multiParagraph.getLineTop(lineForOffset);
                                    jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fCoerceIn)) << 32) | (((long) Float.floatToRawIntBits(((multiParagraph.getLineBottom(lineForOffset) - lineTop) / 2.0f) + lineTop)) & 4294967295L);
                                }
                            }
                        }
                    }
                }
                return new Offset(jFloatToRawIntBits);
            case 18:
                SheetState sheetState = (SheetState) obj2;
                CoroutineScope coroutineScope = (CoroutineScope) obj;
                if (((Boolean) sheetState.confirmValueChange.invoke(SheetValue.PartiallyExpanded)).booleanValue()) {
                    AwaitKt.launch$default(coroutineScope, null, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, z ? 1 : 0, (byte) 5), 3);
                }
                return Boolean.TRUE;
            case 19:
                SnackbarHostState.SnackbarDataImpl snackbarDataImpl = (SnackbarHostState.SnackbarDataImpl) obj2;
                FadeInFadeOutState fadeInFadeOutState = (FadeInFadeOutState) obj;
                if (!Intrinsics.areEqual(snackbarDataImpl, fadeInFadeOutState.current)) {
                    CollectionsKt__MutableCollectionsKt.removeAll(fadeInFadeOutState.items, new TextKt$$ExternalSyntheticLambda2((byte) 6, snackbarDataImpl));
                    RecomposeScopeImpl recomposeScopeImpl = fadeInFadeOutState.scope;
                    if (recomposeScopeImpl != null) {
                        recomposeScopeImpl.invalidate();
                    }
                }
                return unit;
            case 20:
                ((Listener) obj2).unregister((AccessibilityManager) obj);
                return unit;
            case 21:
                AwaitKt.launch$default((CoroutineScope) obj2, null, null, new BasicTooltipKt$anchorSemantics$1$1$1((TooltipStateImpl) obj, z2 ? 1 : 0, r6), 3);
                return Boolean.TRUE;
            case 22:
                ((Ref$ObjectRef) obj2).element = ((AndroidRippleNode) obj).rippleNodeConfiguration.invoke();
                return unit;
            case 23:
                Recomposer$$ExternalSyntheticLambda1 recomposer$$ExternalSyntheticLambda1 = (Recomposer$$ExternalSyntheticLambda1) obj;
                if (((AtomicInt) ((EmojiProcessor) obj2).mSpanFactory).get() == 0) {
                    recomposer$$ExternalSyntheticLambda1.invoke();
                }
                return unit;
            case 24:
                GapComposer gapComposer = ((CompositionErrorContextImpl) obj2).composer;
                SlotTable slotTable = gapComposer.slotTable;
                SlotReader slotReaderOpenReader2 = slotTable.openReader();
                int i8 = 0;
                while (true) {
                    try {
                        if (i8 < slotTable.groupsSize) {
                            if (slotReaderOpenReader2.isNode(i8)) {
                                Object objNode = slotReaderOpenReader2.node(i8);
                                if (objNode != obj) {
                                    RememberObserverHolder rememberObserverHolder = objNode instanceof RememberObserverHolder ? (RememberObserverHolder) objNode : null;
                                    if ((rememberObserverHolder != null ? rememberObserverHolder.getWrapped() : null) == obj) {
                                    }
                                }
                                ObjectLocation objectLocation2 = new ObjectLocation(i8, null);
                                slotReaderOpenReader2.close();
                                objectLocation = objectLocation2;
                                if (objectLocation != null) {
                                    int i9 = objectLocation.group;
                                    Integer num = objectLocation.dataOffset;
                                    slotReaderOpenReader = slotTable.openReader();
                                    try {
                                        ArrayList arrayListTraceForGroup = UtilsKt.traceForGroup(slotReaderOpenReader, i9, num);
                                        slotReaderOpenReader.close();
                                        listPlus = CollectionsKt.plus((Iterable) gapComposer.parentStackTrace$runtime(), (Collection) arrayListTraceForGroup);
                                    } catch (Throwable th) {
                                        slotReaderOpenReader.close();
                                        throw th;
                                    }
                                } else {
                                    listPlus = EmptyList.INSTANCE;
                                }
                                return new ComposeStackTrace(listPlus, gapComposer.sourceMarkersEnabled);
                            }
                            int[] iArr = slotReaderOpenReader2.groups;
                            int i10 = i8 + 1;
                            int iSlotAnchor = (i10 < slotReaderOpenReader2.groupsSize ? iArr[(i10 * 5) + 4] : slotReaderOpenReader2.slotsSize) - SlotTableKt.slotAnchor(i8, iArr);
                            int i11 = 0;
                            while (true) {
                                if (i11 >= iSlotAnchor) {
                                    i8 = i10;
                                } else {
                                    Object objGroupGet = slotReaderOpenReader2.groupGet(i8, i11);
                                    if (objGroupGet != obj) {
                                        RememberObserverHolder rememberObserverHolder2 = objGroupGet instanceof RememberObserverHolder ? (RememberObserverHolder) objGroupGet : null;
                                        if ((rememberObserverHolder2 != null ? rememberObserverHolder2.getWrapped() : null) != obj) {
                                            i11++;
                                        }
                                    }
                                    objectLocation = new ObjectLocation(i8, Integer.valueOf(i11));
                                }
                            }
                        }
                        slotReaderOpenReader2.close();
                        if (objectLocation != null) {
                            int i12 = objectLocation.group;
                            Integer num2 = objectLocation.dataOffset;
                            slotReaderOpenReader = slotTable.openReader();
                            ArrayList arrayListTraceForGroup2 = UtilsKt.traceForGroup(slotReaderOpenReader, i12, num2);
                            slotReaderOpenReader.close();
                            listPlus = CollectionsKt.plus((Iterable) gapComposer.parentStackTrace$runtime(), (Collection) arrayListTraceForGroup2);
                        } else {
                            listPlus = EmptyList.INSTANCE;
                        }
                        return new ComposeStackTrace(listPlus, gapComposer.sourceMarkersEnabled);
                    } catch (Throwable th2) {
                        slotReaderOpenReader2.close();
                        throw th2;
                    }
                }
            case 25:
                ((CacheDrawModifierNodeImpl) obj2).block.invoke((CacheDrawScope) obj);
                return unit;
            case 26:
                ((Ref$ObjectRef) obj2).element = ((FocusTargetNode) obj).fetchFocusProperties$ui();
                return unit;
            case 27:
                ((HitPathTracker) obj2).removePointerInputModifierNode((Modifier.Node) obj);
                return unit;
            case 28:
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) obj;
                NodeChain nodeChain = ((LayoutNode) obj2).nodes;
                if ((((Modifier.Node) nodeChain.head).aggregateChildKindSet & 8) != 0) {
                    for (Modifier.Node node = (TailModifierNode) nodeChain.tail; node != null; node = node.parent) {
                        if ((node.kindSet & 8) != 0) {
                            ?? Pop = node;
                            ?? mutableVector = 0;
                            while (Pop != 0) {
                                if (Pop instanceof SemanticsModifierNode) {
                                    SemanticsModifierNode semanticsModifierNode = (SemanticsModifierNode) Pop;
                                    if (semanticsModifierNode.getShouldClearDescendantSemantics()) {
                                        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
                                        ref$ObjectRef.element = semanticsConfiguration;
                                        semanticsConfiguration.isClearingSemantics = true;
                                    }
                                    if (semanticsModifierNode.getShouldMergeDescendantSemantics()) {
                                        ((SemanticsConfiguration) ref$ObjectRef.element).isMergingSemanticsOfDescendants = true;
                                    }
                                    semanticsModifierNode.applySemantics((SemanticsPropertyReceiver) ref$ObjectRef.element);
                                } else if ((Pop.kindSet & 8) != 0 && (Pop instanceof DelegatingNode)) {
                                    Modifier.Node node2 = ((DelegatingNode) Pop).delegate;
                                    int i13 = 0;
                                    while (node2 != null) {
                                        if ((node2.kindSet & 8) != 0) {
                                            i13++;
                                            if (i13 == 1) {
                                                Pop = Pop;
                                                mutableVector = mutableVector;
                                                mutableVector = mutableVector;
                                                Pop = node2;
                                            } else {
                                                if (mutableVector == 0) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (Pop != 0) {
                                                    mutableVector.add(Pop);
                                                    Pop = 0;
                                                }
                                                mutableVector.add(node2);
                                            }
                                        } else {
                                            Pop = Pop;
                                            mutableVector = mutableVector;
                                        }
                                        node2 = node2.child;
                                        Pop = Pop;
                                        mutableVector = mutableVector;
                                    }
                                    if (i13 == 1) {
                                        Pop = Pop;
                                        mutableVector = mutableVector;
                                    } else {
                                        Pop = Pop;
                                        mutableVector = mutableVector;
                                    }
                                }
                                Pop = HitTestResultKt.pop(mutableVector);
                            }
                        }
                    }
                }
                return unit;
            default:
                return Boolean.valueOf(super/*android.view.ViewGroup*/.dispatchKeyEvent((KeyEvent) obj));
        }
    }

    public /* synthetic */ Recomposer$$ExternalSyntheticLambda6(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }
}
