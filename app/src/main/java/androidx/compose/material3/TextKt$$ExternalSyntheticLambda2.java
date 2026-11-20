package androidx.compose.material3;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.runtime.CompositionImpl;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.SingleSubscriptionSnapshotFlowManager;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.draganddrop.DragAndDropNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.draw.ShadowGraphicsLayerElement;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.LayerOutsets;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SimpleGraphicsLayerModifier;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.vector.GroupComponent;
import androidx.compose.ui.graphics.vector.VNode;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.InsetsListener;
import androidx.compose.ui.layout.RectRulersImpl;
import androidx.compose.ui.layout.WindowInsetsRulers;
import androidx.compose.ui.layout.WindowInsetsRulersImpl;
import androidx.compose.ui.layout.WindowInsetsRulersOld_androidKt;
import androidx.compose.ui.layout.WindowWindowInsetsAnimationValues;
import androidx.compose.ui.node.AlignmentLinesOwner;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LookaheadAlignmentLines;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.AndroidSoundEffect;
import androidx.compose.ui.platform.ComposeViewContext;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.viewinterop.AndroidViewHolder$$ExternalSyntheticLambda4;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1;
import androidx.emoji2.text.EmojiProcessor;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.utils.io.ByteChannelKt;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatRange;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextKt$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ TextKt$$ExternalSyntheticLambda2(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v12, types: [androidx.compose.ui.text.AnnotatedString] */
    /* JADX WARN: Type inference failed for: r7v22 */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        AnnotatedString annotatedString;
        boolean z = false;
        ?? annotatedString2 = 0;
        Object objRestore = null;
        switch (this.$r8$classId) {
            case 0:
                TextLinkStyles textLinkStyles = (TextLinkStyles) this.f$0;
                AnnotatedString.Range range = (AnnotatedString.Range) obj;
                AnnotatedString.Annotation annotation = (AnnotatedString.Annotation) range.item;
                if (annotation instanceof LinkAnnotation.Url) {
                    LinkAnnotation.Url url = (LinkAnnotation.Url) annotation;
                    if (url.styles == null) {
                        return AnnotatedString.Range.copy$default(range, new LinkAnnotation.Url(url.url, textLinkStyles, url.linkInteractionListener), 0, 14);
                    }
                }
                if (!(annotation instanceof LinkAnnotation.Clickable)) {
                    return range;
                }
                LinkAnnotation.Clickable clickable = (LinkAnnotation.Clickable) annotation;
                return clickable.styles == null ? AnnotatedString.Range.copy$default(range, new LinkAnnotation.Clickable(clickable.tag, textLinkStyles, clickable.linkInteractionListener), 0, 14) : range;
            case 1:
                TopAppBarState topAppBarState = (TopAppBarState) this.f$0;
                topAppBarState.heightOffsetLimit = -(((int) (((IntSize) obj).packedValue & 4294967295L)) - topAppBarState._heightOffset.getFloatValue());
                return Unit.INSTANCE;
            case 2:
                ClockDialNode clockDialNode = (ClockDialNode) this.f$0;
                ((FocusOwnerImpl) ((FocusOwner) HitTestResultKt.currentValueOf(clockDialNode, CompositionLocalsKt.LocalFocusManager))).m409clearFocusI7lrPNg(8, false, true);
                AwaitKt.launch$default(clockDialNode.getCoroutineScope(), null, null, new ClockDialNode$pointerInputTapNode$1$2$1(clockDialNode, (Offset) obj, annotatedString2, z ? 1 : 0), 3);
                return Unit.INSTANCE;
            case 3:
                IndicatorLineNode indicatorLineNode = (IndicatorLineNode) this.f$0;
                CacheDrawScope cacheDrawScope = (CacheDrawScope) obj;
                float density = cacheDrawScope.getDensity() * ((Dp) indicatorLineNode.widthAnimatable.getValue()).value;
                AndroidPath androidPathPath = AndroidPath_androidKt.Path();
                Shape shapeM325fromTokenCLvlw10 = indicatorLineNode._shape;
                if (shapeM325fromTokenCLvlw10 == null) {
                    shapeM325fromTokenCLvlw10 = ShapesKt.m325fromTokenCLvlw10(((MaterialTheme$Values) HitTestResultKt.currentValueOf(indicatorLineNode, MaterialThemeKt._localMaterialTheme)).shapes, 5);
                }
                ColorKt.addOutline(androidPathPath, shapeM325fromTokenCLvlw10.mo56createOutlinePq9zytI(cacheDrawScope.cacheParams.mo398getSizeNHjbRc(), cacheDrawScope.cacheParams.getLayoutDirection(), cacheDrawScope));
                AndroidPath androidPathPath2 = AndroidPath_androidKt.Path();
                float fIntBitsToFloat = Float.intBitsToFloat((int) (cacheDrawScope.cacheParams.mo398getSizeNHjbRc() & 4294967295L)) - density;
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (cacheDrawScope.cacheParams.mo398getSizeNHjbRc() >> 32));
                float fIntBitsToFloat3 = Float.intBitsToFloat((int) (4294967295L & cacheDrawScope.cacheParams.mo398getSizeNHjbRc()));
                if (Float.isNaN(CropImageView.DEFAULT_ASPECT_RATIO) || Float.isNaN(fIntBitsToFloat) || Float.isNaN(fIntBitsToFloat2) || Float.isNaN(fIntBitsToFloat3)) {
                    AndroidPath_androidKt.throwIllegalStateException("Invalid rectangle, make sure no value is NaN");
                }
                RectF rectF = androidPathPath2.rectF;
                if (rectF == null) {
                    rectF = new RectF();
                    androidPathPath2.rectF = rectF;
                }
                rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3);
                Path path = androidPathPath2.internalPath;
                RectF rectF2 = androidPathPath2.rectF;
                rectF2.getClass();
                path.addRect(rectF2, Path.Direction.CCW);
                AndroidPath androidPathPath3 = AndroidPath_androidKt.Path();
                androidPathPath3.m470opN5in7k0(androidPathPath2, androidPathPath, 1);
                return cacheDrawScope.onDrawWithContent(new ZIndexNode$$ExternalSyntheticLambda0((Object) androidPathPath3, (Object) indicatorLineNode, (byte) 11));
            case 4:
                ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper = (ModalBottomSheetDialogWrapper) this.f$0;
                modalBottomSheetDialogWrapper.show();
                return new AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1((byte) 12, modalBottomSheetDialogWrapper);
            case 5:
                ClosedFloatRange closedFloatRange = (ClosedFloatRange) this.f$0;
                Object obj2 = ((List) obj).get(0);
                obj2.getClass();
                return new SliderState(((Float) obj2).floatValue(), 0, closedFloatRange);
            case 6:
                return Boolean.valueOf(Intrinsics.areEqual(((FadeInFadeOutAnimationItem) obj).key, (SnackbarHostState.SnackbarDataImpl) this.f$0));
            case 7:
                return new AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1((byte) 13, (TooltipStateImpl) this.f$0);
            case 8:
                CharSequence charSequence = (CharSequence) this.f$0;
                SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj;
                if (charSequence instanceof AnnotatedString) {
                    annotatedString = (AnnotatedString) charSequence;
                }
                if (annotatedString2 == 0) {
                    annotatedString2 = annotatedString;
                    annotatedString2 = new AnnotatedString(charSequence.toString());
                }
                annotatedString2 = annotatedString;
                KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                semanticsPropertyReceiver.set(SemanticsProperties.Text, CollectionsKt__IterablesKt.listOf((Object) annotatedString2));
                return Unit.INSTANCE;
            case 9:
                FloatProducer floatProducer = (FloatProducer) this.f$0;
                SemanticsPropertyReceiver semanticsPropertyReceiver2 = (SemanticsPropertyReceiver) obj;
                if (floatProducer.invoke() > CropImageView.DEFAULT_ASPECT_RATIO) {
                    SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver2, new ProgressBarRangeInfo(floatProducer.invoke(), new ClosedFloatRange(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f), 0));
                }
                return Unit.INSTANCE;
            case 10:
                ((CompositionImpl) this.f$0).recordReadOf(obj);
                return Unit.INSTANCE;
            case 11:
                Recomposer recomposer = (Recomposer) this.f$0;
                Throwable th = (Throwable) obj;
                CancellationException CancellationException = AwaitKt.CancellationException("Recomposer effect job completed", th);
                synchronized (recomposer.stateLock) {
                    try {
                        Job job = recomposer.runnerJob;
                        if (job != null) {
                            StateFlowImpl stateFlowImpl = recomposer._state;
                            Recomposer.State state = Recomposer.State.ShuttingDown;
                            stateFlowImpl.getClass();
                            stateFlowImpl.updateState(null, state);
                            job.cancel(CancellationException);
                            recomposer.workContinuation = null;
                            job.invokeOnCompletion(new ZIndexNode$$ExternalSyntheticLambda0((Object) recomposer, (Object) th, (byte) 23));
                        } else {
                            recomposer.closeCause = CancellationException;
                            StateFlowImpl stateFlowImpl2 = recomposer._state;
                            Recomposer.State state2 = Recomposer.State.ShutDown;
                            stateFlowImpl2.getClass();
                            stateFlowImpl2.updateState(null, state2);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return Unit.INSTANCE;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                SingleSubscriptionSnapshotFlowManager singleSubscriptionSnapshotFlowManager = (SingleSubscriptionSnapshotFlowManager) this.f$0;
                SendChannel sendChannel = singleSubscriptionSnapshotFlowManager.subscribedChannel;
                sendChannel.getClass();
                if (!Intrinsics.areEqual(singleSubscriptionSnapshotFlowManager.subscribedChannel, sendChannel)) {
                    PreconditionsKt.throwIllegalStateException("Requested a SingleSubscriptionSnapshotFlowManager to manage multiple subscriptions");
                }
                MutableScatterSet mutableScatterSet = singleSubscriptionSnapshotFlowManager.workingWatchSet;
                Object obj3 = singleSubscriptionSnapshotFlowManager.workingSoleWatchedObject;
                if (mutableScatterSet != null) {
                    if (obj3 != null) {
                        PreconditionsKt.throwIllegalStateException("workingSoleWatchedObject must be null when workingWatchSet is non-null");
                    }
                    mutableScatterSet.add(obj);
                } else if (obj3 == null) {
                    singleSubscriptionSnapshotFlowManager.workingSoleWatchedObject = obj;
                } else {
                    MutableScatterSet mutableScatterSet2 = ScatterSetKt.EmptyScatterSet;
                    MutableScatterSet mutableScatterSet3 = new MutableScatterSet();
                    mutableScatterSet3.add(obj3);
                    mutableScatterSet3.add(obj);
                    singleSubscriptionSnapshotFlowManager.workingWatchSet = mutableScatterSet3;
                    singleSubscriptionSnapshotFlowManager.workingSoleWatchedObject = null;
                }
                return Unit.INSTANCE;
            case 13:
                ((ParcelableSnapshotMutableLongState) this.f$0).setLongValue(((Long) obj).longValue());
                return Unit.INSTANCE;
            case 14:
                ((ParcelableSnapshotMutableState) this.f$0).setValue(obj);
                return Unit.INSTANCE;
            case 15:
                Saver saver = (Saver) this.f$0;
                MutableState mutableState = (MutableState) obj;
                if (!(mutableState instanceof SnapshotMutableState)) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
                    return null;
                }
                SnapshotMutableState snapshotMutableState = (SnapshotMutableState) mutableState;
                if (snapshotMutableState.getValue() != null) {
                    Object value = snapshotMutableState.getValue();
                    value.getClass();
                    objRestore = saver.restore(value);
                }
                NeverEqualPolicy policy = snapshotMutableState.getPolicy();
                policy.getClass();
                return new ParcelableSnapshotMutableState(objRestore, policy);
            case 16:
                SaveableStateRegistry saveableStateRegistry = ((SaveableStateHolderImpl) this.f$0).parentSaveableStateRegistry;
                return Boolean.valueOf(saveableStateRegistry != null ? saveableStateRegistry.canBeSaved(obj) : true);
            case 17:
                SnapshotStateObserver snapshotStateObserver = (SnapshotStateObserver) this.f$0;
                synchronized (snapshotStateObserver.observedScopeMapsLock) {
                    SnapshotStateObserver.ObservedScopeMap observedScopeMap = snapshotStateObserver.currentMap;
                    observedScopeMap.getClass();
                    Object obj4 = observedScopeMap.currentScope;
                    obj4.getClass();
                    int i = observedScopeMap.currentToken;
                    MutableObjectIntMap mutableObjectIntMap = observedScopeMap.currentScopeReads;
                    if (mutableObjectIntMap == null) {
                        mutableObjectIntMap = new MutableObjectIntMap();
                        observedScopeMap.currentScopeReads = mutableObjectIntMap;
                        observedScopeMap.getScopeToValues().set(obj4, mutableObjectIntMap);
                    }
                    observedScopeMap.recordRead(obj, i, obj4, mutableObjectIntMap);
                }
                return Unit.INSTANCE;
            case 18:
                TraversableNode$Companion$TraverseDescendantsAction traversableNode$Companion$TraverseDescendantsAction = TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
                DrawResult drawResult = (DrawResult) this.f$0;
                DragAndDropNode dragAndDropNode = (DragAndDropNode) obj;
                if (!dragAndDropNode.node.isAttached) {
                    return TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
                }
                DragAndDropNode dragAndDropNode2 = dragAndDropNode.thisDragAndDropTarget;
                if (dragAndDropNode2 != null) {
                    TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2 = new TextKt$$ExternalSyntheticLambda2((byte) 18, drawResult);
                    if (textKt$$ExternalSyntheticLambda2.invoke(dragAndDropNode2) == traversableNode$Companion$TraverseDescendantsAction) {
                        HitTestResultKt.traverseDescendants(dragAndDropNode2, textKt$$ExternalSyntheticLambda2);
                    }
                }
                dragAndDropNode.thisDragAndDropTarget = null;
                dragAndDropNode.lastChildDragAndDropModifierNode = null;
                return traversableNode$Companion$TraverseDescendantsAction;
            case 19:
                ShadowGraphicsLayerElement shadowGraphicsLayerElement = (ShadowGraphicsLayerElement) this.f$0;
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope.setShadowElevation(reusableGraphicsLayerScope.graphicsDensity.getDensity() * shadowGraphicsLayerElement.elevation);
                reusableGraphicsLayerScope.setShape(shadowGraphicsLayerElement.shape);
                reusableGraphicsLayerScope.setClip(shadowGraphicsLayerElement.clip);
                reusableGraphicsLayerScope.m515setAmbientShadowColor8_81llA(shadowGraphicsLayerElement.ambientColor);
                reusableGraphicsLayerScope.m516setSpotShadowColor8_81llA(shadowGraphicsLayerElement.spotColor);
                return Unit.INSTANCE;
            case 20:
                SimpleGraphicsLayerModifier simpleGraphicsLayerModifier = (SimpleGraphicsLayerModifier) this.f$0;
                ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope2.setScaleX(simpleGraphicsLayerModifier.scaleX);
                reusableGraphicsLayerScope2.setScaleY(simpleGraphicsLayerModifier.scaleY);
                reusableGraphicsLayerScope2.setAlpha(simpleGraphicsLayerModifier.alpha);
                reusableGraphicsLayerScope2.setTranslationX(CropImageView.DEFAULT_ASPECT_RATIO);
                reusableGraphicsLayerScope2.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
                reusableGraphicsLayerScope2.setShadowElevation(simpleGraphicsLayerModifier.shadowElevation);
                float f = simpleGraphicsLayerModifier.rotationZ;
                if (reusableGraphicsLayerScope2.rotationZ != f) {
                    reusableGraphicsLayerScope2.mutatedFields |= 1024;
                    reusableGraphicsLayerScope2.rotationZ = f;
                }
                float f2 = simpleGraphicsLayerModifier.cameraDistance;
                if (reusableGraphicsLayerScope2.cameraDistance != f2) {
                    reusableGraphicsLayerScope2.mutatedFields |= 2048;
                    reusableGraphicsLayerScope2.cameraDistance = f2;
                }
                reusableGraphicsLayerScope2.m517setTransformOrigin__ExYCQ(simpleGraphicsLayerModifier.transformOrigin);
                reusableGraphicsLayerScope2.setShape(simpleGraphicsLayerModifier.shape);
                reusableGraphicsLayerScope2.setClip(simpleGraphicsLayerModifier.clip);
                reusableGraphicsLayerScope2.setRenderEffect(null);
                reusableGraphicsLayerScope2.m515setAmbientShadowColor8_81llA(simpleGraphicsLayerModifier.ambientShadowColor);
                reusableGraphicsLayerScope2.m516setSpotShadowColor8_81llA(simpleGraphicsLayerModifier.spotShadowColor);
                byte b = simpleGraphicsLayerModifier.blendMode;
                if (reusableGraphicsLayerScope2.blendMode != b) {
                    reusableGraphicsLayerScope2.mutatedFields |= 524288;
                    reusableGraphicsLayerScope2.blendMode = b;
                }
                LayerOutsets layerOutsets = simpleGraphicsLayerModifier.outsets;
                if (!Intrinsics.areEqual(reusableGraphicsLayerScope2.outsets, layerOutsets)) {
                    reusableGraphicsLayerScope2.mutatedFields |= ByteChannelKt.CHANNEL_MAX_SIZE;
                    reusableGraphicsLayerScope2.outsets = layerOutsets;
                }
                return Unit.INSTANCE;
            case 21:
                GraphicsLayer graphicsLayer = (GraphicsLayer) this.f$0;
                DrawScope drawScope = (DrawScope) obj;
                AndroidPath androidPath = graphicsLayer.outlinePath;
                if (graphicsLayer.usePathForClip && graphicsLayer.clip && androidPath != null) {
                    EmojiProcessor drawContext = drawScope.getDrawContext();
                    long jM831getSizeNHjbRc = drawContext.m831getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    try {
                        ((EmojiProcessor) ((DrawResult) drawContext.mSpanFactory).block).getCanvas().mo452clipPathmtrdDE(androidPath);
                        graphicsLayer.drawWithChildTracking(drawScope);
                    } finally {
                        IntIntPair$$ExternalSyntheticOutline0.m(drawContext, jM831getSizeNHjbRc);
                    }
                } else {
                    graphicsLayer.drawWithChildTracking(drawScope);
                }
                return Unit.INSTANCE;
            case 22:
                GroupComponent groupComponent = (GroupComponent) this.f$0;
                VNode vNode = (VNode) obj;
                groupComponent.markTintForVNode(vNode);
                Function1 function1 = groupComponent.invalidateListener;
                if (function1 != null) {
                    function1.invoke(vNode);
                }
                return Unit.INSTANCE;
            case 23:
                ((AndroidViewHolder$$ExternalSyntheticLambda4) ((PointerInteropFilter) this.f$0).getOnTouchEvent()).invoke((MotionEvent) obj);
                return Unit.INSTANCE;
            case 24:
                LookaheadAlignmentLines lookaheadAlignmentLines = (LookaheadAlignmentLines) this.f$0;
                AlignmentLinesOwner alignmentLinesOwner = (AlignmentLinesOwner) obj;
                Unit unit = Unit.INSTANCE;
                if (alignmentLinesOwner.getPlaceOrder() != Integer.MAX_VALUE) {
                    if (alignmentLinesOwner.getAlignmentLines().dirty) {
                        alignmentLinesOwner.layoutChildren();
                    }
                    for (Map.Entry entry : alignmentLinesOwner.getAlignmentLines().alignmentLineMap.entrySet()) {
                        lookaheadAlignmentLines.addAlignmentLine((AlignmentLine) entry.getKey(), ((Number) entry.getValue()).intValue(), alignmentLinesOwner.getInnerCoordinator());
                    }
                    NodeCoordinator nodeCoordinator = alignmentLinesOwner.getInnerCoordinator().wrappedBy;
                    nodeCoordinator.getClass();
                    while (!nodeCoordinator.equals(lookaheadAlignmentLines.alignmentLinesOwner.getInnerCoordinator())) {
                        for (AlignmentLine alignmentLine : lookaheadAlignmentLines.getAlignmentLinesMap(nodeCoordinator).keySet()) {
                            lookaheadAlignmentLines.addAlignmentLine(alignmentLine, lookaheadAlignmentLines.getPositionFor(nodeCoordinator, alignmentLine), nodeCoordinator);
                        }
                        nodeCoordinator = nodeCoordinator.wrappedBy;
                        nodeCoordinator.getClass();
                    }
                }
                return unit;
            case 25:
                ((MutableObjectList) this.f$0).add((Modifier.Element) obj);
                return Boolean.TRUE;
            case 26:
                return Boolean.valueOf(((FocusTargetNode) obj).m418requestFocus3ESFkO8(((FocusDirection) this.f$0).value));
            case 27:
                LookaheadCapablePlaceable.ResettableRulerScope resettableRulerScope = (LookaheadCapablePlaceable.ResettableRulerScope) obj;
                AndroidComposeView androidComposeView = AndroidComposeView.this;
                InsetsListener insetsListener = androidComposeView.getInsetsListener();
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = insetsListener != null ? insetsListener.generation : null;
                if (parcelableSnapshotMutableIntState != null && parcelableSnapshotMutableIntState.getIntValue() > 0) {
                    MutableIntObjectMap mutableIntObjectMap = WindowInsetsRulersOld_androidKt.WindowInsetsTypeMap;
                    long jMo603getSizeYbymL2g = resettableRulerScope.getCoordinates().mo603getSizeYbymL2g();
                    InsetsListener insetsListener2 = androidComposeView.getInsetsListener();
                    MutableScatterMap mutableScatterMap = insetsListener2 != null ? insetsListener2.insetsValues : null;
                    mutableScatterMap.getClass();
                    int i2 = (int) (jMo603getSizeYbymL2g >> 32);
                    int i3 = (int) (jMo603getSizeYbymL2g & 4294967295L);
                    for (WindowInsetsRulers windowInsetsRulers : WindowInsetsRulersOld_androidKt.AnimatableInsetsRulers) {
                        Object obj5 = mutableScatterMap.get(windowInsetsRulers);
                        obj5.getClass();
                        WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = (WindowWindowInsetsAnimationValues) obj5;
                        WindowInsetsRulersOld_androidKt.m626provideInsetsValuescytEWk0(resettableRulerScope, ((WindowInsetsRulersImpl) windowInsetsRulers).current, windowWindowInsetsAnimationValues.current, i2, i3);
                        if (((Boolean) windowWindowInsetsAnimationValues.isAnimating$delegate.getValue()).booleanValue()) {
                            WindowInsetsRulersOld_androidKt.m626provideInsetsValuescytEWk0(resettableRulerScope, windowWindowInsetsAnimationValues.source, windowWindowInsetsAnimationValues.sourceValueInsets, i2, i3);
                            WindowInsetsRulersOld_androidKt.m626provideInsetsValuescytEWk0(resettableRulerScope, windowWindowInsetsAnimationValues.target, windowWindowInsetsAnimationValues.targetValueInsets, i2, i3);
                        }
                        WindowInsetsRulersOld_androidKt.m626provideInsetsValuescytEWk0(resettableRulerScope, ((WindowInsetsRulersImpl) windowInsetsRulers).maximum, windowWindowInsetsAnimationValues.maximum, i2, i3);
                    }
                    InsetsListener insetsListener3 = androidComposeView.getInsetsListener();
                    MutableObjectList mutableObjectList = insetsListener3 != null ? insetsListener3.displayCutouts : null;
                    mutableObjectList.getClass();
                    if (mutableObjectList.isNotEmpty()) {
                        InsetsListener insetsListener4 = androidComposeView.getInsetsListener();
                        SnapshotStateList snapshotStateList = insetsListener4 != null ? insetsListener4.displayCutoutRulers : null;
                        snapshotStateList.getClass();
                        Object[] objArr = mutableObjectList.content;
                        int i4 = mutableObjectList._size;
                        for (int i5 = 0; i5 < i4; i5++) {
                            Rect rect = (Rect) ((MutableState) objArr[i5]).getValue();
                            RectRulersImpl rectRulersImpl = (RectRulersImpl) snapshotStateList.get(i5);
                            float f3 = rect.left;
                            float f4 = rect.top;
                            float f5 = rect.right;
                            float f6 = rect.bottom;
                            resettableRulerScope.provides(rectRulersImpl.getLeft(), f3);
                            resettableRulerScope.provides(rectRulersImpl.getTop(), f4);
                            resettableRulerScope.provides(rectRulersImpl.getRight(), f5);
                            resettableRulerScope.provides(rectRulersImpl.getBottom(), f6);
                        }
                    }
                }
                return Unit.INSTANCE;
            case 28:
                return Boolean.valueOf(((IntObjectMap) this.f$0).containsKey(((SemanticsNode) obj).id));
            default:
                ComposeViewContext composeViewContext = (ComposeViewContext) this.f$0;
                AndroidSoundEffect androidSoundEffect = composeViewContext._soundEffect;
                if (androidSoundEffect != null) {
                    return androidSoundEffect;
                }
                AndroidSoundEffect androidSoundEffect2 = new AndroidSoundEffect(composeViewContext.view);
                composeViewContext._soundEffect = androidSoundEffect2;
                return androidSoundEffect2;
        }
    }
}
