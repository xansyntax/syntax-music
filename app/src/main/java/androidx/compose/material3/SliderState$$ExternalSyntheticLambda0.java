package androidx.compose.material3;

import android.app.PendingIntent;
import android.app.RemoteAction;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.animation.EnterExitState;
import androidx.compose.animation.MutationPhase;
import androidx.compose.animation.SharedMutableTransformState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.AndroidEdgeEffectOverscrollFactory;
import androidx.compose.foundation.CombinedClickableNode;
import androidx.compose.foundation.MarqueeAnimationMode;
import androidx.compose.foundation.MarqueeModifierNode;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.ScrollableAreaNode;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.DisplayingDisappearingItemsNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.selection.ToggleableNode;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextFieldScrollerPosition;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.internal.TextClassificationHelper34;
import androidx.compose.foundation.text.contextmenu.modifier.AddTextContextMenuDataComponentsWithContextNode;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerNode;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.foundation.text.modifiers.TextStringSimpleNode;
import androidx.compose.material3.carousel.CarouselPageSize;
import androidx.compose.material3.internal.DropdownMenuPositionProvider;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda49;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SliderState$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ SliderState$$ExternalSyntheticLambda0(FocusRequester focusRequester, PlayerKt$$ExternalSyntheticLambda49 playerKt$$ExternalSyntheticLambda49, SoftwareKeyboardController softwareKeyboardController) {
        this.$r8$classId = (byte) 28;
        this.f$0 = playerKt$$ExternalSyntheticLambda49;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws PendingIntent.CanceledException {
        Function0 function0;
        byte b = this.$r8$classId;
        Object[] objArr = 0;
        Unit unit = Unit.INSTANCE;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                SliderState sliderState = (SliderState) obj;
                if (!((Boolean) sliderState.isDragging$delegate.getValue()).booleanValue() && (function0 = sliderState.onValueChangeFinishedInternal) != null) {
                    function0.invoke();
                }
                return unit;
            case 1:
                return new OnBackPressedDispatcher.OnBackPressedEventInput((OnBackPressedDispatcher) obj);
            case 2:
                TransitionInstance transitionInstance = (TransitionInstance) obj;
                Object currentState = transitionInstance.transitionState.getCurrentState();
                EnterExitState enterExitState = EnterExitState.PostExit;
                return Boolean.valueOf(currentState == enterExitState && transitionInstance.targetState$delegate.getValue() == enterExitState);
            case 3:
                SharedMutableTransformState sharedMutableTransformState = (SharedMutableTransformState) obj;
                sharedMutableTransformState.mutationPhase$delegate.setValue(MutationPhase.Idle);
                sharedMutableTransformState.transformScope.reset();
                sharedMutableTransformState.lastVeil = 0L;
                sharedMutableTransformState.lastAlpha = 1.0f;
                sharedMutableTransformState.lastScale = 1.0f;
                VelocityTracker velocityTracker = sharedMutableTransformState.scaleVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.resetTracking();
                }
                sharedMutableTransformState.lastTransformOrigin = ColorKt.TransformOrigin(0.5f, 0.5f);
                sharedMutableTransformState.lastSlide = 0L;
                sharedMutableTransformState.scaleHandoffVelocity = null;
                sharedMutableTransformState.slideHandoffVelocity = null;
                sharedMutableTransformState.mutableData = null;
                return unit;
            case 4:
                return Float.valueOf(ArcSplineKt.getDurationScale(((CoroutineScope) obj).getCoroutineContext()));
            case 5:
                SeekableTransitionState seekableTransitionState = (SeekableTransitionState) obj;
                Transition transition = seekableTransitionState.transition;
                seekableTransitionState.totalDurationNanos = transition != null ? ((Number) transition.totalDurationNanos$delegate.getValue()).longValue() : 0L;
                return unit;
            case 6:
                Function0 function1 = ((CombinedClickableNode) obj).onLongClick;
                if (function1 != null) {
                    function1.invoke();
                }
                return Boolean.TRUE;
            case 7:
                MarqueeModifierNode marqueeModifierNode = (MarqueeModifierNode) obj;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = marqueeModifierNode.contentWidth$delegate;
                if (parcelableSnapshotMutableIntState.getIntValue() <= marqueeModifierNode.containerWidth$delegate.getIntValue()) {
                    return null;
                }
                ((MarqueeAnimationMode) marqueeModifierNode.animationMode$delegate.getValue()).getClass();
                return Float.valueOf(marqueeModifierNode.getSpacingPx() + parcelableSnapshotMutableIntState.getIntValue());
            case 8:
                ScrollableAreaNode scrollableAreaNode = (ScrollableAreaNode) obj;
                AndroidEdgeEffectOverscrollFactory androidEdgeEffectOverscrollFactory = (AndroidEdgeEffectOverscrollFactory) HitTestResultKt.currentValueOf(scrollableAreaNode, OverscrollKt.LocalOverscrollFactory);
                scrollableAreaNode.localOverscrollFactory = androidEdgeEffectOverscrollFactory;
                scrollableAreaNode.localOverscrollFactoryCreatedOverscrollEffect = androidEdgeEffectOverscrollFactory != null ? new AndroidEdgeEffectOverscrollEffect(androidEdgeEffectOverscrollFactory.context, androidEdgeEffectOverscrollFactory.density, androidEdgeEffectOverscrollFactory.glowDrawPadding) : null;
                return unit;
            case 9:
                DisplayingDisappearingItemsNode displayingDisappearingItemsNode = ((LazyLayoutItemAnimator) obj).displayingNode;
                if (displayingDisappearingItemsNode != null) {
                    HitTestResultKt.invalidateDraw(displayingDisappearingItemsNode);
                }
                return unit;
            case 10:
                return (Rect) obj;
            case 11:
                ToggleableNode toggleableNode = (ToggleableNode) obj;
                toggleableNode.onValueChange.invoke(Boolean.valueOf(!toggleableNode.value));
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return (AnnotatedString) obj;
            case 13:
                return ((LegacyTextFieldState) obj).getLayoutResult();
            case 14:
                return new TextFieldScrollerPosition((Orientation) obj, CropImageView.DEFAULT_ASPECT_RATIO);
            case 15:
                return new IntOffset(((IntRect) obj).m809getTopLeftnOccac());
            case 16:
                return ((TextContextMenuDataProvider) obj).data();
            case 17:
                ((TextContextMenuSession) obj).close();
                return unit;
            case 18:
                PendingIntent actionIntent = ((RemoteAction) obj).getActionIntent();
                if (Build.VERSION.SDK_INT >= 34) {
                    TextClassificationHelper34.sendIntentAllowBackgroundActivityStart(actionIntent);
                } else {
                    actionIntent.send();
                }
                return unit;
            case 19:
                AddTextContextMenuDataComponentsWithContextNode addTextContextMenuDataComponentsWithContextNode = (AddTextContextMenuDataComponentsWithContextNode) obj;
                addTextContextMenuDataComponentsWithContextNode.configuration$delegate.setValue((Configuration) HitTestResultKt.currentValueOf(addTextContextMenuDataComponentsWithContextNode, AndroidCompositionLocals_androidKt.LocalConfiguration));
                addTextContextMenuDataComponentsWithContextNode.context$delegate.setValue((Context) HitTestResultKt.currentValueOf(addTextContextMenuDataComponentsWithContextNode, AndroidCompositionLocals_androidKt.LocalContext));
                return unit;
            case 20:
                TextContextMenuToolbarHandlerNode textContextMenuToolbarHandlerNode = (TextContextMenuToolbarHandlerNode) obj;
                return textContextMenuToolbarHandlerNode.isAttached ? TextContextMenuModifierKt.collectTextContextMenuData(textContextMenuToolbarHandlerNode) : TextContextMenuData.Empty;
            case 21:
                Object systemService = ((View) ((WeakCache) obj).values).getContext().getSystemService("input_method");
                systemService.getClass();
                return (InputMethodManager) systemService;
            case 22:
                return new BaseInputConnection(((LegacyTextInputMethodRequest) obj).view, false);
            case 23:
                TextAnnotatedStringNode textAnnotatedStringNode = (TextAnnotatedStringNode) obj;
                textAnnotatedStringNode.textSubstitution = null;
                HitTestResultKt.invalidateSemantics(textAnnotatedStringNode);
                HitTestResultKt.invalidateMeasurement(textAnnotatedStringNode);
                HitTestResultKt.invalidateDraw(textAnnotatedStringNode);
                return Boolean.TRUE;
            case 24:
                TextStringSimpleNode textStringSimpleNode = (TextStringSimpleNode) obj;
                textStringSimpleNode.textSubstitution = null;
                HitTestResultKt.invalidateSemantics(textStringSimpleNode);
                HitTestResultKt.invalidateMeasurement(textStringSimpleNode);
                HitTestResultKt.invalidateDraw(textStringSimpleNode);
                return Boolean.TRUE;
            case 25:
                TransformOrigin transformOrigin = (TransformOrigin) ((DropdownMenuPositionProvider) obj).transformOrigin$delegate.getValue();
                long j = transformOrigin.packedValue;
                return transformOrigin;
            case 26:
                ClockDialNode clockDialNode = (ClockDialNode) obj;
                AwaitKt.launch$default(clockDialNode.getCoroutineScope(), null, null, new SyncUtils.AnonymousClass2(clockDialNode, objArr == true ? 1 : 0, (byte) 10), 3);
                return unit;
            case 27:
                TransformOrigin transformOrigin2 = (TransformOrigin) ((ExposedDropdownMenuPositionProvider) obj).transformOrigin$delegate.getValue();
                long j2 = transformOrigin2.packedValue;
                return transformOrigin2;
            case 28:
                ((PlayerKt$$ExternalSyntheticLambda49) obj).invoke();
                return Boolean.TRUE;
            default:
                return ((CarouselPageSize) obj).getStrategyState();
        }
    }

    public /* synthetic */ SliderState$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }
}
