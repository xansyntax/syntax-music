package androidx.compose.material3;

import android.os.Build;
import android.view.View;
import android.view.textclassifier.TextClassifier;
import androidx.activity.compose.ComposePredictiveBackHandler;
import androidx.collection.MutableIntList;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.Transition$animateTo$1$1$1;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.DefaultDraggableState;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.ScrollableNode;
import androidx.compose.foundation.gestures.ScrollingLogic;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.DragInteraction$Cancel;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.DragInteraction$Stop;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.relocation.BringIntoViewRequesterImpl;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda7;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNode;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.SliderState;
import androidx.compose.material3.internal.AnimatedShapeState;
import androidx.compose.material3.ripple.AndroidRippleNode;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Latch$await$2$2;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.ProduceStateScopeImpl;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.Recomposer$join$2;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.AndroidAccessibilityManager;
import androidx.compose.ui.platform.AndroidPlatformTextInputSession;
import androidx.compose.ui.platform.InputMethodSession;
import androidx.compose.ui.platform.MotionDurationScaleImpl;
import androidx.compose.ui.platform.PlatformTextInputModifierNodeKt;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback;
import androidx.compose.ui.scrollcapture.RelativeScroller;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PlatformTextInputService;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.viewinterop.BringIntoViewNode;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.session.legacy.MediaSessionCompat$Callback;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import androidx.room.InvalidationTracker$createFlow$2;
import coil3.size.SizeKt;
import coil3.util.LifecyclesKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.dokar.quickjs.QuickJs;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.metrolist.music.playback.DownloadUtil$getDownload$$inlined$map$1;
import com.metrolist.music.playback.MusicService$onShuffleModeEnabledChanged$1$1;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$podcastEntity$2$1$1;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.viewmodels.ArtistViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.ClosedFloatRange;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NotCompleted;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.flow.ChannelAsFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SliderState implements DraggableState {
    public final SliderState$dragScope$1 dragScope;
    public final SliderState draggableState;
    public final SliderState$$ExternalSyntheticLambda0 gestureEndAction;
    public final ParcelableSnapshotMutableState isDragging$delegate;
    public final ParcelableSnapshotMutableState isFocused$delegate;
    public boolean isRtl;
    public Function0 onValueChangeFinishedInternal;
    public Function1 onValueChangeInternal;
    public final Orientation orientation;
    public final ParcelableSnapshotMutableFloatState pressOffset$delegate;
    public final ParcelableSnapshotMutableFloatState rawOffset$delegate;
    public final MutatorMutex scrollMutex;
    public final boolean shouldAutoSnap;
    public final int steps;
    public final ParcelableSnapshotMutableIntState thumbHeight$delegate;
    public final ParcelableSnapshotMutableIntState thumbWidth$delegate;
    public final float[] tickFractions;
    public final ParcelableSnapshotMutableIntState totalHeight$delegate;
    public final ParcelableSnapshotMutableIntState totalWidth$delegate;
    public final ClosedFloatRange trackRange;
    public final ParcelableSnapshotMutableFloatState valueState$delegate;

    public SliderState(float f, int i, ClosedFloatRange closedFloatRange) {
        float[] fArr;
        this.steps = i;
        this.trackRange = closedFloatRange;
        this.valueState$delegate = new ParcelableSnapshotMutableFloatState(f);
        this.draggableState = this;
        this.shouldAutoSnap = true;
        VerticalAlignmentLine verticalAlignmentLine = SliderKt.CornerSizeAlignmentLine;
        byte b = 0;
        if (i == 0) {
            fArr = new float[0];
        } else {
            int i2 = i + 2;
            float[] fArr2 = new float[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                fArr2[i3] = i3 / (i + 1);
            }
            fArr = fArr2;
        }
        this.tickFractions = fArr;
        this.totalWidth$delegate = new ParcelableSnapshotMutableIntState(0);
        this.totalHeight$delegate = new ParcelableSnapshotMutableIntState(0);
        Boolean bool = Boolean.FALSE;
        this.isFocused$delegate = Stack.mutableStateOf$default(bool);
        this.thumbWidth$delegate = new ParcelableSnapshotMutableIntState(0);
        this.thumbHeight$delegate = new ParcelableSnapshotMutableIntState(0);
        this.orientation = Orientation.Horizontal;
        this.isDragging$delegate = Stack.mutableStateOf$default(bool);
        this.gestureEndAction = new SliderState$$ExternalSyntheticLambda0(b, this);
        ClosedFloatRange closedFloatRange2 = this.trackRange;
        float f2 = closedFloatRange2._start;
        float f3 = closedFloatRange2._endInclusive - f2;
        this.rawOffset$delegate = new ParcelableSnapshotMutableFloatState(LifecyclesKt.lerp(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, UuidKt.coerceIn(f3 == CropImageView.DEFAULT_ASPECT_RATIO ? 0.0f : (f - f2) / f3, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f)));
        this.pressOffset$delegate = new ParcelableSnapshotMutableFloatState(CropImageView.DEFAULT_ASPECT_RATIO);
        this.dragScope = new SliderState$dragScope$1(this, (byte) 0);
        this.scrollMutex = new MutatorMutex();
    }

    public final void dispatchRawDeltaInternal$material3(float f) {
        float fMax;
        float fMin;
        if (isVertical()) {
            float intValue = this.totalHeight$delegate.getIntValue();
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.thumbHeight$delegate;
            fMax = Math.max(intValue - (parcelableSnapshotMutableIntState.getIntValue() / 2.0f), CropImageView.DEFAULT_ASPECT_RATIO);
            fMin = Math.min(parcelableSnapshotMutableIntState.getIntValue() / 2.0f, fMax);
        } else {
            float intValue2 = this.totalWidth$delegate.getIntValue();
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = this.thumbWidth$delegate;
            fMax = Math.max(intValue2 - (parcelableSnapshotMutableIntState2.getIntValue() / 2.0f), CropImageView.DEFAULT_ASPECT_RATIO);
            fMin = Math.min(parcelableSnapshotMutableIntState2.getIntValue() / 2.0f, fMax);
        }
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.rawOffset$delegate;
        float floatValue = parcelableSnapshotMutableFloatState.getFloatValue() + f;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState2 = this.pressOffset$delegate;
        parcelableSnapshotMutableFloatState.setFloatValue(parcelableSnapshotMutableFloatState2.getFloatValue() + floatValue);
        parcelableSnapshotMutableFloatState2.setFloatValue(CropImageView.DEFAULT_ASPECT_RATIO);
        float fSnapValueToTick = SliderKt.snapValueToTick(parcelableSnapshotMutableFloatState.getFloatValue(), fMin, fMax, this.tickFractions);
        ClosedFloatRange closedFloatRange = this.trackRange;
        float f2 = fMax - fMin;
        float fLerp = LifecyclesKt.lerp(closedFloatRange._start, closedFloatRange._endInclusive, UuidKt.coerceIn(f2 == CropImageView.DEFAULT_ASPECT_RATIO ? 0.0f : (fSnapValueToTick - fMin) / f2, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
        if (fLerp == this.valueState$delegate.getFloatValue()) {
            return;
        }
        Function1 function1 = this.onValueChangeInternal;
        if (function1 != null) {
            function1.invoke(Float.valueOf(fLerp));
        } else {
            setValue(fLerp);
        }
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final Object drag(InnerTube$feedback$2 innerTube$feedback$2, NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1) {
        Object objCoroutineScope = AwaitKt.coroutineScope(new AnonymousClass2(this, innerTube$feedback$2, null, (byte) 0), navHostKt$NavHost$29$1);
        return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
    }

    public final float getCoercedValueAsFraction() {
        ClosedFloatRange closedFloatRange = this.trackRange;
        float f = closedFloatRange._start;
        float f2 = closedFloatRange._endInclusive;
        float fCoerceIn = UuidKt.coerceIn(this.valueState$delegate.getFloatValue(), closedFloatRange._start, f2);
        VerticalAlignmentLine verticalAlignmentLine = SliderKt.CornerSizeAlignmentLine;
        float f3 = f2 - f;
        return UuidKt.coerceIn(f3 == CropImageView.DEFAULT_ASPECT_RATIO ? 0.0f : (fCoerceIn - f) / f3, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
    }

    public final boolean isVertical() {
        return this.orientation == Orientation.Vertical;
    }

    public final void setValue(float f) {
        if (this.shouldAutoSnap) {
            ClosedFloatRange closedFloatRange = this.trackRange;
            float f2 = closedFloatRange._start;
            float f3 = closedFloatRange._endInclusive;
            f = SliderKt.snapValueToTick(UuidKt.coerceIn(f, f2, f3), closedFloatRange._start, f3, this.tickFractions);
        }
        this.valueState$delegate.setFloatValue(f);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SliderState$drag$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Object $block;
        public final /* synthetic */ byte $r8$classId;
        public boolean label;
        public Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Object obj2, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = obj;
            this.$block = obj2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj2 = this.$block;
            switch (b) {
                case 0:
                    return new AnonymousClass2((SliderState) this.this$0, (InnerTube$feedback$2) obj2, continuation, (byte) 0);
                case 1:
                    return new AnonymousClass2((ComposePredictiveBackHandler) obj2, continuation, (byte) 1);
                case 2:
                    return new AnonymousClass2((MutableInteractionSourceImpl) this.this$0, (HoverInteraction$Enter) obj2, continuation, (byte) 2);
                case 3:
                    return new AnonymousClass2((MutableInteractionSourceImpl) this.this$0, (HoverInteraction$Exit) obj2, continuation, (byte) 3);
                case 4:
                    return new AnonymousClass2((DefaultDraggableState) this.this$0, (InnerTube$feedback$2) obj2, continuation, (byte) 4);
                case 5:
                    return new AnonymousClass2((MediaSessionCompat$Callback) this.this$0, (Function2) obj2, continuation, (byte) 5);
                case 6:
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2((BufferedChannel) obj2, continuation, (byte) 6);
                    anonymousClass2.this$0 = obj;
                    return anonymousClass2;
                case 7:
                    return new AnonymousClass2((DragEvent.DragStopped) this.this$0, (ScrollableNode) obj2, continuation, (byte) 7);
                case 8:
                    return new AnonymousClass2((PointerInputScope) this.this$0, (PagerState) obj2, continuation, (byte) 8);
                case 9:
                    return new AnonymousClass2((BringIntoViewResponderNode) this.this$0, (GapComposer$$ExternalSyntheticLambda0) obj2, continuation, (byte) 9);
                case 10:
                    return new AnonymousClass2((TextFieldSelectionManager) this.this$0, (BringIntoViewRequesterImpl) obj2, continuation, (byte) 10);
                case 11:
                    return new AnonymousClass2((PointerInputScope) this.this$0, (TextFieldSelectionManager) obj2, continuation, (byte) 11);
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return new AnonymousClass2((LegacyAdaptingPlatformTextInputModifierNode) this.this$0, (InnerTube$feedback$2) obj2, continuation, (byte) 12);
                case 13:
                    return new AnonymousClass2((TextClassifier) this.this$0, (Function2) obj2, continuation, (byte) 13);
                case 14:
                    return new AnonymousClass2((AnalogTimePickerState) this.this$0, (AnimationSpec) obj2, continuation, (byte) 14);
                case 15:
                    return new AnonymousClass2((FloatingActionButtonElevationAnimatable) this.this$0, (FloatingActionButtonElevation) obj2, continuation, (byte) 15);
                case 16:
                    return new AnonymousClass2((FloatingActionButtonElevationAnimatable) this.this$0, (Interaction) obj2, continuation, (byte) 16);
                case 17:
                    return new AnonymousClass2((InteractionSource) this.this$0, (ParcelableSnapshotMutableIntState) obj2, continuation, (byte) 17);
                case 18:
                    return new AnonymousClass2((MutableInteractionSourceImpl) this.this$0, (SnapshotStateList) obj2, continuation, (byte) 18);
                case 19:
                    return new AnonymousClass2((SnackbarHostState.SnackbarDataImpl) this.this$0, (AccessibilityManager) obj2, continuation, (byte) 19);
                case 20:
                    return new AnonymousClass2((MutableInteractionSourceImpl) this.this$0, (MutableState) obj2, continuation, (byte) 20);
                case 21:
                    return new AnonymousClass2((AnimatedShapeState) this.this$0, (RoundedCornerShape) obj2, continuation, (byte) 21);
                case 22:
                    return new AnonymousClass2((AndroidRippleNode) this.this$0, (AnimationSpec) obj2, continuation, (byte) 22);
                case 23:
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2((AndroidRippleNode) obj2, continuation, (byte) 23);
                    anonymousClass3.this$0 = obj;
                    return anonymousClass3;
                case 24:
                    return new AnonymousClass2((Flow) this.this$0, (ProduceStateScopeImpl) obj2, continuation, (byte) 24);
                case 25:
                    AnonymousClass2 anonymousClass4 = new AnonymousClass2((AndroidPlatformTextInputSession) obj2, continuation, (byte) 25);
                    anonymousClass4.this$0 = obj;
                    return anonymousClass4;
                case 26:
                    return new AnonymousClass2((StateFlow) this.this$0, (MotionDurationScaleImpl) obj2, continuation, (byte) 26);
                case 27:
                    return new AnonymousClass2((Recomposer) this.this$0, (View) obj2, continuation, (byte) 27);
                case 28:
                    return new AnonymousClass2((ComposeScrollCaptureCallback) this.this$0, (Runnable) obj2, continuation, (byte) 28);
                default:
                    return new AnonymousClass2((BringIntoViewNode) this.this$0, (Rect) obj2, continuation, (byte) 29);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) throws Throwable {
            byte b = this.$r8$classId;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 1:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 2:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 3:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 4:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 5:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 6:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 7:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 8:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 9:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 10:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 11:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return coroutineSingletons;
                case 13:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 14:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 15:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 16:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 17:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 18:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 19:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 20:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 21:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 22:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 23:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 24:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 25:
                    ((AnonymousClass2) create((InputMethodSession) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return coroutineSingletons;
                case 26:
                    ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return coroutineSingletons;
                case 27:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 28:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                default:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            }
        }

        /* JADX WARN: Code duplicated, block: B:152:0x0297  */
        /* JADX WARN: Code duplicated, block: B:158:0x02ac  */
        /* JADX WARN: Code duplicated, block: B:211:0x03c0  */
        /* JADX WARN: Code duplicated, block: B:413:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v5, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r1v68 */
        /* JADX WARN: Type inference failed for: r1v69 */
        /* JADX WARN: Type inference failed for: r1v8, types: [kotlinx.coroutines.Job] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Ref$BooleanRef ref$BooleanRef;
            Object objReceive;
            Object objMutate;
            long j;
            CancellableContinuationImpl cancellableContinuationImpl;
            byte b = this.$r8$classId;
            ?? r1 = 4;
            char c = 4;
            char c2 = 4;
            byte b2 = 3;
            int i = 2;
            byte b3 = 0;
            Unit unit = Unit.INSTANCE;
            Object obj2 = this.$block;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            byte b4 = 1;
            boolean z = true;
            boolean z2 = true;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            switch (b) {
                case 0:
                    SliderState sliderState = (SliderState) this.this$0;
                    ParcelableSnapshotMutableState parcelableSnapshotMutableState = sliderState.isDragging$delegate;
                    boolean z7 = this.label;
                    try {
                        if (!z7) {
                            ResultKt.throwOnFailure(obj);
                            parcelableSnapshotMutableState.setValue(Boolean.TRUE);
                            MutatorMutex mutatorMutex = sliderState.scrollMutex;
                            SliderState$dragScope$1 sliderState$dragScope$1 = sliderState.dragScope;
                            this.label = true;
                            mutatorMutex.getClass();
                            if (AwaitKt.coroutineScope(new QuickJs.AnonymousClass3(MutatePriority.UserInput, mutatorMutex, (InnerTube$feedback$2) obj2, sliderState$dragScope$1, null, (byte) 1), this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else {
                            if (!z7) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        parcelableSnapshotMutableState.setValue(Boolean.FALSE);
                        return unit;
                    } catch (Throwable th) {
                        parcelableSnapshotMutableState.setValue(Boolean.FALSE);
                        throw th;
                    }
                case 1:
                    ComposePredictiveBackHandler composePredictiveBackHandler = (ComposePredictiveBackHandler) obj2;
                    boolean z8 = this.label;
                    if (z8) {
                        if (z8) {
                            ref$BooleanRef = (Ref$BooleanRef) this.this$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        }
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    if (!composePredictiveBackHandler.isBackEnabled()) {
                        return unit;
                    }
                    ref$BooleanRef = new Ref$BooleanRef();
                    Function2 function2 = composePredictiveBackHandler.currentOnBack;
                    BufferedChannel bufferedChannel = composePredictiveBackHandler.activeChannel;
                    bufferedChannel.getClass();
                    DownloadUtil$getDownload$$inlined$map$1 downloadUtil$getDownload$$inlined$map$1 = new DownloadUtil$getDownload$$inlined$map$1(new ChannelAsFlow(bufferedChannel, z2 ? 1 : 0), new InvalidationTracker$createFlow$2(ref$BooleanRef, z3 ? 1 : 0, z ? 1 : 0), (byte) 5);
                    this.this$0 = ref$BooleanRef;
                    this.label = true;
                    if (function2.invoke(downloadUtil$getDownload$$inlined$map$1, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    if (ref$BooleanRef.element) {
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("You must collect the progress flow");
                    return null;
                case 2:
                    boolean z9 = this.label;
                    if (!z9) {
                        ResultKt.throwOnFailure(obj);
                        this.label = true;
                        return ((MutableInteractionSourceImpl) this.this$0).emit((HoverInteraction$Enter) obj2, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z9) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 3:
                    boolean z10 = this.label;
                    if (!z10) {
                        ResultKt.throwOnFailure(obj);
                        this.label = true;
                        return ((MutableInteractionSourceImpl) this.this$0).emit((HoverInteraction$Exit) obj2, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z10) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 4:
                    boolean z11 = this.label;
                    if (z11) {
                        if (z11) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    DefaultDraggableState defaultDraggableState = (DefaultDraggableState) this.this$0;
                    MutatorMutex mutatorMutex2 = defaultDraggableState.scrollMutex;
                    SliderState$dragScope$1 sliderState$dragScope$2 = defaultDraggableState.dragScope;
                    this.label = true;
                    mutatorMutex2.getClass();
                    return AwaitKt.coroutineScope(new QuickJs.AnonymousClass3(MutatePriority.UserInput, mutatorMutex2, (InnerTube$feedback$2) obj2, sliderState$dragScope$2, null, (byte) 1), this) == coroutineSingletons ? coroutineSingletons : unit;
                case 5:
                    boolean z12 = this.label;
                    if (!z12) {
                        ResultKt.throwOnFailure(obj);
                        this.label = true;
                        return ((ScrollingLogic) ((MediaSessionCompat$Callback) this.this$0).lock).scroll(MutatePriority.UserInput, (Function2) obj2, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z12) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 6:
                    boolean z13 = this.label;
                    try {
                        if (!z13) {
                            ResultKt.throwOnFailure(obj);
                            StandaloneCoroutine standaloneCoroutineLaunch$default = AwaitKt.launch$default((CoroutineScope) this.this$0, null, null, new MusicService$onShuffleModeEnabledChanged$1$1(i, (Continuation) (z4 ? 1 : 0)), 3);
                            this.this$0 = standaloneCoroutineLaunch$default;
                            this.label = true;
                            objReceive = ((BufferedChannel) obj2).receive(this);
                            r1 = standaloneCoroutineLaunch$default;
                            if (objReceive == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else {
                            if (!z13) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            Job job = (Job) this.this$0;
                            ResultKt.throwOnFailure(obj);
                            objReceive = obj;
                            r1 = job;
                        }
                        r1.cancel(null);
                        return objReceive;
                    } catch (Throwable th2) {
                        r1.cancel(null);
                        throw th2;
                    }
                case 7:
                    boolean z14 = this.label;
                    if (z14) {
                        if (z14) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    DragEvent.DragStopped dragStopped = (DragEvent.DragStopped) this.this$0;
                    float f = dragStopped.isIndirectPointerEvent ? -1.0f : 1.0f;
                    ScrollingLogic scrollingLogic = ((ScrollableNode) obj2).scrollLogic;
                    long jM823timesadjELrA = Velocity.m823timesadjELrA(dragStopped.velocity, f);
                    this.label = true;
                    return scrollingLogic.m102onScrollStoppedBMRW4eQ(jM823timesadjELrA, false, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 8:
                    boolean z15 = this.label;
                    if (z15) {
                        if (z15) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    PointerInputScope pointerInputScope = (PointerInputScope) this.this$0;
                    LazyLayoutPagerKt$dragDirectionDetector$1$1$1 lazyLayoutPagerKt$dragDirectionDetector$1$1$1 = new LazyLayoutPagerKt$dragDirectionDetector$1$1$1((PagerState) obj2, z5 ? 1 : 0, b3);
                    this.label = true;
                    return ScrollableKt.awaitEachGesture(pointerInputScope, lazyLayoutPagerKt$dragDirectionDetector$1$1$1, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 9:
                    boolean z16 = this.label;
                    if (!z16) {
                        ResultKt.throwOnFailure(obj);
                        this.label = true;
                        return SizeKt.bringIntoView((BringIntoViewResponderNode) this.this$0, (GapComposer$$ExternalSyntheticLambda0) obj2, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z16) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 10:
                    boolean z17 = this.label;
                    if (z17) {
                        if (z17) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.this$0;
                    OffsetMapping offsetMapping = textFieldSelectionManager.offsetMapping;
                    long j2 = textFieldSelectionManager.getValue$foundation().selection;
                    int i2 = TextRange.$r8$clinit;
                    int iOriginalToTransformed = offsetMapping.originalToTransformed((int) (j2 >> 32));
                    LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
                    TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
                    layoutResult.getClass();
                    TextLayoutResult textLayoutResult = layoutResult.value;
                    Rect cursorRect = textLayoutResult.getCursorRect(UuidKt.coerceIn(iOriginalToTransformed, 0, textLayoutResult.layoutInput.text.text.length()));
                    this.label = true;
                    return ((BringIntoViewRequesterImpl) obj2).bringIntoView(cursorRect, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 11:
                    boolean z18 = this.label;
                    if (z18) {
                        if (z18) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    PointerInputScope pointerInputScope2 = (PointerInputScope) this.this$0;
                    CoreTextFieldKt$$ExternalSyntheticLambda7 coreTextFieldKt$$ExternalSyntheticLambda7 = new CoreTextFieldKt$$ExternalSyntheticLambda7((TextFieldSelectionManager) obj2, b4);
                    this.label = true;
                    return TapGestureDetectorKt.detectTapGestures$default(pointerInputScope2, null, null, coreTextFieldKt$$ExternalSyntheticLambda7, this, 7) == coroutineSingletons ? coroutineSingletons : unit;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    boolean z19 = this.label;
                    if (z19) {
                        if (z19) {
                            throw Fragment$5$$ExternalSyntheticOutline0.m(obj);
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    PlatformTextInputModifierNodeKt.establishTextInputSession((LegacyAdaptingPlatformTextInputModifierNode) this.this$0, (InnerTube$feedback$2) obj2, this);
                    return coroutineSingletons;
                case 13:
                    boolean z20 = this.label;
                    if (z20) {
                        if (z20) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    TextClassifier textClassifier = (TextClassifier) this.this$0;
                    if (textClassifier == null) {
                        return null;
                    }
                    this.label = true;
                    Object objInvoke = ((Function2) obj2).invoke(textClassifier, this);
                    return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
                case 14:
                    boolean z21 = this.label;
                    if (z21) {
                        if (z21) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    AnalogTimePickerState analogTimePickerState = (AnalogTimePickerState) this.this$0;
                    AnimationSpec animationSpec = (AnimationSpec) obj2;
                    this.label = true;
                    TimePickerState timePickerState = analogTimePickerState.state;
                    if ((timePickerState.mo241getSelectionyecRtBI() == 0 && AnalogTimePickerState.normalize(((Number) analogTimePickerState.anim.targetValue$delegate.getValue()).floatValue()) == AnalogTimePickerState.normalize(analogTimePickerState.hourAngle)) || (timePickerState.mo241getSelectionyecRtBI() == 1 && AnalogTimePickerState.normalize(((Number) analogTimePickerState.anim.targetValue$delegate.getValue()).floatValue()) == AnalogTimePickerState.normalize(analogTimePickerState.minuteAngle))) {
                        objMutate = unit;
                    } else {
                        objMutate = analogTimePickerState.mutex.mutate(MutatePriority.PreventUserInput, new AnalogTimePickerState$onGestureEnd$2(analogTimePickerState, timePickerState.mo241getSelectionyecRtBI() == 0 ? analogTimePickerState.endValueForAnimation(analogTimePickerState.hourAngle) : analogTimePickerState.endValueForAnimation(analogTimePickerState.minuteAngle), animationSpec, null, (byte) 1), this);
                        if (objMutate != coroutineSingletons) {
                            objMutate = unit;
                        }
                    }
                    return objMutate == coroutineSingletons ? coroutineSingletons : unit;
                case 15:
                    boolean z22 = this.label;
                    if (z22) {
                        if (z22) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable = (FloatingActionButtonElevationAnimatable) this.this$0;
                    FloatingActionButtonElevation floatingActionButtonElevation = (FloatingActionButtonElevation) obj2;
                    float f2 = floatingActionButtonElevation.defaultElevation;
                    float f3 = floatingActionButtonElevation.pressedElevation;
                    float f4 = floatingActionButtonElevation.hoveredElevation;
                    float f5 = floatingActionButtonElevation.focusedElevation;
                    this.label = true;
                    floatingActionButtonElevationAnimatable.defaultElevation = f2;
                    floatingActionButtonElevationAnimatable.pressedElevation = f3;
                    floatingActionButtonElevationAnimatable.hoveredElevation = f4;
                    floatingActionButtonElevationAnimatable.focusedElevation = f5;
                    Object objSnapElevation = floatingActionButtonElevationAnimatable.snapElevation(this);
                    if (objSnapElevation != coroutineSingletons) {
                        objSnapElevation = unit;
                    }
                    return objSnapElevation == coroutineSingletons ? coroutineSingletons : unit;
                case 16:
                    boolean z23 = this.label;
                    if (!z23) {
                        ResultKt.throwOnFailure(obj);
                        this.label = true;
                        return ((FloatingActionButtonElevationAnimatable) this.this$0).animateElevation((Interaction) obj2, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z23) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 17:
                    boolean z24 = this.label;
                    if (z24) {
                        if (z24) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Flow interactions = ((InteractionSource) this.this$0).getInteractions();
                    ArtistViewModel.AnonymousClass1.AnonymousClass2 anonymousClass2 = new ArtistViewModel.AnonymousClass1.AnonymousClass2(b2, (ParcelableSnapshotMutableIntState) obj2);
                    this.label = true;
                    return interactions.collect(anonymousClass2, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 18:
                    boolean z25 = this.label;
                    if (z25) {
                        if (z25) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    SharedFlowImpl sharedFlowImpl = ((MutableInteractionSourceImpl) this.this$0).interactions;
                    SliderKt$ThumbContent$1$1$1 sliderKt$ThumbContent$1$1$1 = new SliderKt$ThumbContent$1$1$1((SnapshotStateList) obj2, b3);
                    this.label = true;
                    sharedFlowImpl.collect(sliderKt$ThumbContent$1$1$1, this);
                    return coroutineSingletons;
                case 19:
                    SnackbarHostState.SnackbarDataImpl snackbarDataImpl = (SnackbarHostState.SnackbarDataImpl) this.this$0;
                    boolean z26 = this.label;
                    if (z26) {
                        if (!z26) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        cancellableContinuationImpl = snackbarDataImpl.continuation;
                        if (cancellableContinuationImpl.getState$kotlinx_coroutines_core() instanceof NotCompleted) {
                            return unit;
                        }
                        cancellableContinuationImpl.resumeWith(SnackbarResult.Dismissed);
                        return unit;
                    }
                    ResultKt.throwOnFailure(obj);
                    if (snackbarDataImpl == null) {
                        return unit;
                    }
                    SnackbarHostState.SnackbarVisualsImpl snackbarVisualsImpl = snackbarDataImpl.visuals;
                    SnackbarDuration snackbarDuration = snackbarVisualsImpl.duration;
                    b3 = snackbarVisualsImpl.actionLabel != null ? (byte) 1 : (byte) 0;
                    AccessibilityManager accessibilityManager = (AccessibilityManager) obj2;
                    int iOrdinal = snackbarDuration.ordinal();
                    long j3 = Long.MAX_VALUE;
                    if (iOrdinal == 0) {
                        j = 4000;
                    } else if (iOrdinal == 1) {
                        j = 10000;
                    } else {
                        if (iOrdinal != 2) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        j = Long.MAX_VALUE;
                    }
                    if (accessibilityManager == null) {
                        j3 = j;
                    } else {
                        android.view.accessibility.AccessibilityManager accessibilityManager2 = ((AndroidAccessibilityManager) accessibilityManager).accessibilityManager;
                        if (j < 2147483647L) {
                            b2 = b3 != 0 ? (byte) 7 : (byte) 3;
                            if (Build.VERSION.SDK_INT >= 29) {
                                int recommendedTimeoutMillis = AndroidAccessibilityManager.Api29Impl.getRecommendedTimeoutMillis(accessibilityManager2, (int) j, b2);
                                if (recommendedTimeoutMillis != Integer.MAX_VALUE) {
                                    j3 = recommendedTimeoutMillis;
                                }
                            } else if (b3 == 0 || !accessibilityManager2.isTouchExplorationEnabled()) {
                                j3 = j;
                            }
                        } else {
                            j3 = j;
                        }
                    }
                    this.label = true;
                    if (AwaitKt.delay(j3, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    cancellableContinuationImpl = snackbarDataImpl.continuation;
                    if (cancellableContinuationImpl.getState$kotlinx_coroutines_core() instanceof NotCompleted) {
                        return unit;
                    }
                    cancellableContinuationImpl.resumeWith(SnackbarResult.Dismissed);
                    return unit;
                case 20:
                    boolean z27 = this.label;
                    if (z27) {
                        if (z27) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) this.this$0;
                    MutableIntList mutableIntList = TimePickerKt.Minutes;
                    PressInteraction.Release release = new PressInteraction.Release(new PressInteraction.Press(((Offset) ((MutableState) obj2).getValue()).packedValue));
                    this.label = true;
                    return mutableInteractionSourceImpl.emit(release, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 21:
                    boolean z28 = this.label;
                    if (!z28) {
                        ResultKt.throwOnFailure(obj);
                        this.label = true;
                        return ((AnimatedShapeState) this.this$0).animateToShape((RoundedCornerShape) obj2, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z28) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 22:
                    boolean z29 = this.label;
                    if (!z29) {
                        ResultKt.throwOnFailure(obj);
                        this.label = true;
                        return Animatable.animateTo$default(((AndroidRippleNode) this.this$0).animatedAlpha, new Float(CropImageView.DEFAULT_ASPECT_RATIO), (AnimationSpec) obj2, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z29) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 23:
                    final AndroidRippleNode androidRippleNode = (AndroidRippleNode) obj2;
                    boolean z30 = this.label;
                    if (z30) {
                        if (z30) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    final CoroutineScope coroutineScope = (CoroutineScope) this.this$0;
                    final ArrayList arrayList = new ArrayList();
                    final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                    final Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
                    Flow interactions2 = androidRippleNode.interactionSource.getInteractions();
                    FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.material3.ripple.RippleNode$onAttach$1$1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj3, Continuation continuation) {
                            Interaction interaction = (Interaction) obj3;
                            boolean z31 = interaction instanceof PressInteraction;
                            AndroidRippleNode androidRippleNode2 = androidRippleNode;
                            if (z31) {
                                if (androidRippleNode2.hasValidSize) {
                                    androidRippleNode2.handlePressInteraction((PressInteraction) interaction);
                                } else {
                                    androidRippleNode2.pendingInteractions.add(interaction);
                                }
                            }
                            boolean z32 = interaction instanceof HoverInteraction$Enter;
                            Unit unit2 = Unit.INSTANCE;
                            ArrayList arrayList2 = arrayList;
                            if (z32) {
                                arrayList2.add(interaction);
                            } else if (interaction instanceof HoverInteraction$Exit) {
                                arrayList2.remove(((HoverInteraction$Exit) interaction).enter);
                            } else {
                                boolean z33 = interaction instanceof FocusInteraction.Focus;
                                Ref$BooleanRef ref$BooleanRef3 = ref$BooleanRef2;
                                if (z33) {
                                    arrayList2.add(interaction);
                                    ref$BooleanRef3.element = true;
                                } else if (interaction instanceof FocusInteraction.Unfocus) {
                                    arrayList2.remove(((FocusInteraction.Unfocus) interaction).focus);
                                    int size = arrayList2.size();
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= size) {
                                            ref$BooleanRef3.element = false;
                                            break;
                                        }
                                        if (((Interaction) arrayList2.get(i3)) instanceof FocusInteraction.Focus) {
                                            break;
                                        }
                                        i3++;
                                    }
                                } else if (interaction instanceof DragInteraction$Start) {
                                    arrayList2.add(interaction);
                                } else {
                                    if (!(interaction instanceof DragInteraction$Stop)) {
                                        if (interaction instanceof DragInteraction$Cancel) {
                                            arrayList2.remove(((DragInteraction$Cancel) interaction).start);
                                        }
                                        return unit2;
                                    }
                                    arrayList2.remove(((DragInteraction$Stop) interaction).start);
                                }
                            }
                            Interaction interaction2 = (Interaction) CollectionsKt.lastOrNull(arrayList2);
                            RippleNodeConfiguration rippleNodeConfiguration = androidRippleNode2.getRippleNodeConfiguration(false);
                            Ref$ObjectRef ref$ObjectRef2 = ref$ObjectRef;
                            if (!Intrinsics.areEqual(ref$ObjectRef2.element, interaction2)) {
                                CoroutineScope coroutineScope2 = coroutineScope;
                                Continuation continuation2 = null;
                                if (interaction2 != null) {
                                    boolean z34 = interaction2 instanceof HoverInteraction$Enter;
                                    float f6 = CropImageView.DEFAULT_ASPECT_RATIO;
                                    if (z34) {
                                        if (rippleNodeConfiguration.hoverConfiguration instanceof RippleNodeConfiguration.HoverConfiguration.Opacity) {
                                            f6 = 0.08f;
                                        }
                                    } else if (interaction2 instanceof FocusInteraction.Focus) {
                                        if (rippleNodeConfiguration.focusConfiguration instanceof RippleNodeConfiguration.FocusConfiguration.Opacity) {
                                            f6 = 0.1f;
                                        }
                                    } else if ((interaction2 instanceof DragInteraction$Start) && (rippleNodeConfiguration.dragConfiguration instanceof RippleNodeConfiguration.DragConfiguration.Opacity)) {
                                        f6 = 0.16f;
                                    }
                                    TweenSpec tweenSpec = RippleKt.DefaultTweenSpec;
                                    if (!z34 && ((interaction2 instanceof FocusInteraction.Focus) || (interaction2 instanceof DragInteraction$Start))) {
                                        tweenSpec = new TweenSpec(45, 0, EasingKt.LinearEasing);
                                    }
                                    AwaitKt.launch$default(coroutineScope2, null, null, new Transition$animateTo$1$1$1(androidRippleNode2, f6, tweenSpec, (Continuation) null), 3);
                                } else {
                                    Interaction interaction3 = (Interaction) ref$ObjectRef2.element;
                                    TweenSpec tweenSpec2 = RippleKt.DefaultTweenSpec;
                                    if (!(interaction3 instanceof HoverInteraction$Enter) && !(interaction3 instanceof FocusInteraction.Focus) && (interaction3 instanceof DragInteraction$Start)) {
                                        tweenSpec2 = new TweenSpec(150, 0, EasingKt.LinearEasing);
                                    }
                                    AwaitKt.launch$default(coroutineScope2, null, null, new SliderState.AnonymousClass2(androidRippleNode2, tweenSpec2, continuation2, (byte) 22), 3);
                                }
                                if (interaction instanceof FocusInteraction) {
                                    AwaitKt.launch$default(coroutineScope2, null, null, new SyncUtils.AnonymousClass2(androidRippleNode2, continuation2, (byte) 13), 3);
                                }
                                ref$ObjectRef2.element = interaction2;
                            }
                            return unit2;
                        }
                    };
                    this.label = true;
                    return interactions2.collect(flowCollector, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 24:
                    boolean z31 = this.label;
                    if (z31) {
                        if (z31) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Flow flow = (Flow) this.this$0;
                    SongMenuKt$SongMenu$podcastEntity$2$1$1 songMenuKt$SongMenu$podcastEntity$2$1$1 = new SongMenuKt$SongMenu$podcastEntity$2$1$1((ProduceStateScopeImpl) obj2, (byte) 2);
                    this.label = true;
                    return flow.collect(songMenuKt$SongMenu$podcastEntity$2$1$1, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 25:
                    boolean z32 = this.label;
                    if (z32) {
                        if (!z32) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj);
                        }
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    InputMethodSession inputMethodSession = (InputMethodSession) this.this$0;
                    AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) obj2;
                    this.this$0 = inputMethodSession;
                    this.label = true;
                    CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(this));
                    cancellableContinuationImpl2.initCancellability();
                    TextInputService textInputService = androidPlatformTextInputSession.textInputService;
                    PlatformTextInputService platformTextInputService = textInputService.platformTextInputService;
                    platformTextInputService.startInput();
                    textInputService._currentInputSession.set(new TextInputSession(textInputService, platformTextInputService));
                    cancellableContinuationImpl2.invokeOnCancellation(new Latch$await$2$2(inputMethodSession, androidPlatformTextInputSession, c));
                    if (cancellableContinuationImpl2.getResult() == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                    return null;
                case 26:
                    boolean z33 = this.label;
                    if (z33) {
                        if (!z33) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj);
                        }
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    StateFlow stateFlow = (StateFlow) this.this$0;
                    ArtistViewModel.AnonymousClass1.AnonymousClass2 anonymousClass3 = new ArtistViewModel.AnonymousClass1.AnonymousClass2(c2, (MotionDurationScaleImpl) obj2);
                    this.label = true;
                    if (stateFlow.collect(anonymousClass3, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                    return null;
                case 27:
                    Recomposer recomposer = (Recomposer) this.this$0;
                    View view = (View) obj2;
                    boolean z34 = this.label;
                    try {
                        if (!z34) {
                            ResultKt.throwOnFailure(obj);
                            this.label = true;
                            Object objFirst = StateFlowKt.first(recomposer._state, new Recomposer$join$2(i, z6 ? 1 : 0, b3), this);
                            if (objFirst != coroutineSingletons) {
                                objFirst = unit;
                            }
                            if (objFirst == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else {
                            if (!z34) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        if (WindowRecomposer_androidKt.getCompositionContext(view) != recomposer) {
                            return unit;
                        }
                        view.setTag(R.id.androidx_compose_ui_view_composition_context, null);
                        return unit;
                    } catch (Throwable th3) {
                        if (WindowRecomposer_androidKt.getCompositionContext(view) == recomposer) {
                            view.setTag(R.id.androidx_compose_ui_view_composition_context, null);
                        }
                        throw th3;
                    }
                case 28:
                    ComposeScrollCaptureCallback composeScrollCaptureCallback = (ComposeScrollCaptureCallback) this.this$0;
                    boolean z35 = this.label;
                    if (!z35) {
                        ResultKt.throwOnFailure(obj);
                        RelativeScroller relativeScroller = composeScrollCaptureCallback.scrollTracker;
                        this.label = true;
                        Object objScrollBy = relativeScroller.scrollBy(CropImageView.DEFAULT_ASPECT_RATIO - relativeScroller.scrollAmount, this);
                        if (objScrollBy != coroutineSingletons) {
                            objScrollBy = unit;
                        }
                        if (objScrollBy == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z35) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    ((ParcelableSnapshotMutableState) composeScrollCaptureCallback.listener.scrollCaptureInProgress$delegate).setValue(Boolean.FALSE);
                    ((Runnable) obj2).run();
                    return unit;
                default:
                    boolean z36 = this.label;
                    if (z36) {
                        if (z36) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    BringIntoViewNode bringIntoViewNode = (BringIntoViewNode) this.this$0;
                    SliderState$$ExternalSyntheticLambda0 sliderState$$ExternalSyntheticLambda0 = new SliderState$$ExternalSyntheticLambda0((byte) 10, (Rect) obj2);
                    this.label = true;
                    return SizeKt.bringIntoView(bringIntoViewNode, sliderState$$ExternalSyntheticLambda0, this) == coroutineSingletons ? coroutineSingletons : unit;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$block = obj;
        }
    }

    public SliderState(float f, ClosedFloatRange closedFloatRange, int i) {
        this(f, 0, (i & 4) != 0 ? new ClosedFloatRange(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f) : closedFloatRange);
    }
}
