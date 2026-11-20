package androidx.compose.ui;

import android.content.res.Resources;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.activity.compose.BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.ExcludeInsets;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.LinkStateInteractionSourceObserver;
import androidx.compose.foundation.text.TextAnnotatorScope;
import androidx.compose.foundation.text.TextLinkScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest;
import androidx.compose.material3.AnalogTimePickerState;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1;
import androidx.compose.material3.IndicatorLineNode;
import androidx.compose.material3.SliderKt$SliderImpl$3$1;
import androidx.compose.material3.TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0;
import androidx.compose.material3.TimePickerColors;
import androidx.compose.material3.TimePickerKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.Listener;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.CompositionImpl;
import androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.BlockGraphicsLayerModifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SimpleGraphicsLayerModifier;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.platform.AndroidPlatformTextInputSession;
import androidx.compose.ui.platform.ComposeViewContext;
import androidx.compose.ui.platform.InputMethodSession;
import androidx.compose.ui.platform.InvertMatrixKt;
import androidx.compose.ui.platform.WrappedComposition;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.AdjustedSemanticsNode;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder$$ExternalSyntheticLambda4;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1;
import androidx.emoji2.text.EmojiProcessor;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import coil3.util.FileSystemsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda9;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.math.MathKt;
import kotlin.text.MatchResult;
import kotlin.text.MatcherMatchResult;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.io.SourcesJvmKt$asInputStream$isClosed$1;
import okhttp3.Dispatcher;
import okhttp3.Handshake$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ZIndexNode$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ ZIndexNode$$ExternalSyntheticLambda0(TextLinkScope textLinkScope, AnnotatedString.Range range, LinkStateInteractionSourceObserver linkStateInteractionSourceObserver) {
        this.$r8$classId = (byte) 5;
        this.f$0 = range;
        this.f$1 = linkStateInteractionSourceObserver;
    }

    /* JADX WARN: Code duplicated, block: B:152:0x0526  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        TextLinkStyles styles;
        TextLinkStyles styles2;
        TextLinkStyles styles3;
        TextLayoutResult textLayoutResult;
        final AndroidPath pathForRange;
        TextLayoutInput textLayoutInput;
        byte b = 8;
        byte b2 = 11;
        SpanStyle spanStyleMerge = null;
        spanStyleMerge = null;
        z = false;
        boolean z = false;
        switch (this.$r8$classId) {
            case 0:
                ((Placeable.PlacementScope) obj).place((Placeable) this.f$0, 0, 0, ((ZIndexNode) this.f$1).zIndex);
                return Unit.INSTANCE;
            case 1:
                TextFieldValue textFieldValue = (TextFieldValue) this.f$0;
                Function1 function1 = (Function1) this.f$1;
                TextFieldValue textFieldValue2 = (TextFieldValue) obj;
                if (!Intrinsics.areEqual(textFieldValue, textFieldValue2)) {
                    function1.invoke(textFieldValue2);
                }
                return Unit.INSTANCE;
            case 2:
                LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) this.f$0;
                Brush brush = (Brush) this.f$1;
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope.drawContent();
                if (((Boolean) legacyTextFieldState.autofillHighlightOn$delegate.getValue()).booleanValue() || ((Boolean) legacyTextFieldState.justAutofilled$delegate.getValue()).booleanValue()) {
                    DrawScope.m549drawRectAsUm42w$default(layoutNodeDrawScope, brush, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, null, null, 0, 126);
                }
                return Unit.INSTANCE;
            case 3:
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                ArrayList arrayListMeasureWithTextRangeMeasureConstraints = BasicTextKt.measureWithTextRangeMeasureConstraints((Function0) ((SliderKt$SliderImpl$3$1) this.f$1).$state, (List) this.f$0);
                if (arrayListMeasureWithTextRangeMeasureConstraints != null) {
                    int size = arrayListMeasureWithTextRangeMeasureConstraints.size();
                    for (int i = 0; i < size; i++) {
                        Pair pair = (Pair) arrayListMeasureWithTextRangeMeasureConstraints.get(i);
                        Placeable placeable = (Placeable) pair.first;
                        Function0 function0 = (Function0) pair.second;
                        Placeable.PlacementScope.m619place70tqf50$default(placementScope, placeable, function0 != null ? ((IntOffset) function0.invoke()).packedValue : 0L);
                    }
                }
                return Unit.INSTANCE;
            case 4:
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1((MutableState) this.f$0, (MutableInteractionSourceImpl) this.f$1, b);
            case 5:
                AnnotatedString.Range range = (AnnotatedString.Range) this.f$0;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = ((LinkStateInteractionSourceObserver) this.f$1).interactionState;
                TextAnnotatorScope textAnnotatorScope = (TextAnnotatorScope) obj;
                LinkAnnotation linkAnnotation = (LinkAnnotation) range.item;
                TextLinkStyles styles4 = linkAnnotation.getStyles();
                SpanStyle spanStyle = styles4 != null ? styles4.style : null;
                SpanStyle spanStyleMerge2 = ((parcelableSnapshotMutableIntState.getIntValue() & 1) == 0 || (styles3 = linkAnnotation.getStyles()) == null) ? null : styles3.focusedStyle;
                if (spanStyle != null) {
                    spanStyleMerge2 = spanStyle.merge(spanStyleMerge2);
                }
                SpanStyle spanStyleMerge3 = ((parcelableSnapshotMutableIntState.getIntValue() & 2) == 0 || (styles2 = linkAnnotation.getStyles()) == null) ? null : styles2.hoveredStyle;
                if (spanStyleMerge2 != null) {
                    spanStyleMerge3 = spanStyleMerge2.merge(spanStyleMerge3);
                }
                if ((parcelableSnapshotMutableIntState.getIntValue() & 4) != 0 && (styles = linkAnnotation.getStyles()) != null) {
                    spanStyleMerge = styles.pressedStyle;
                }
                if (spanStyleMerge3 != null) {
                    spanStyleMerge = spanStyleMerge3.merge(spanStyleMerge);
                }
                textAnnotatorScope.styledText = textAnnotatorScope.initialText.mapAnnotations(new UtilsKt$$ExternalSyntheticLambda0(new Ref$BooleanRef(), range, spanStyleMerge, b));
                return Unit.INSTANCE;
            case 6:
                TextLinkScope textLinkScope = (TextLinkScope) this.f$0;
                AnnotatedString.Range range2 = (AnnotatedString.Range) this.f$1;
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                AnnotatedString annotatedString = textLinkScope.text;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = textLinkScope.textLayoutResult$delegate;
                TextLayoutResult textLayoutResult2 = (TextLayoutResult) parcelableSnapshotMutableState.getValue();
                if (Intrinsics.areEqual(annotatedString, (textLayoutResult2 == null || (textLayoutInput = textLayoutResult2.layoutInput) == null) ? null : textLayoutInput.text) && (textLayoutResult = (TextLayoutResult) parcelableSnapshotMutableState.getValue()) != null) {
                    MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
                    AnnotatedString.Range rangeCalculateVisibleLinkRange = TextLinkScope.calculateVisibleLinkRange(range2, textLayoutResult);
                    if (rangeCalculateVisibleLinkRange == null) {
                        pathForRange = null;
                    } else {
                        int i2 = rangeCalculateVisibleLinkRange.end;
                        int i3 = rangeCalculateVisibleLinkRange.start;
                        pathForRange = textLayoutResult.getPathForRange(i3, i2);
                        Rect boundingBox = textLayoutResult.getBoundingBox(i3);
                        int i4 = i2 - 1;
                        pathForRange.m472translatek4lQ0M(((((long) Float.floatToRawIntBits(multiParagraph.getLineForOffset(i3) == multiParagraph.getLineForOffset(i4) ? Math.min(textLayoutResult.getBoundingBox(i4).left, boundingBox.left) : 0.0f)) << 32) | (((long) Float.floatToRawIntBits(boundingBox.top)) & 4294967295L)) ^ (-9223372034707292160L));
                    }
                } else {
                    pathForRange = null;
                }
                Shape shape = pathForRange != null ? new Shape() { // from class: androidx.compose.foundation.text.TextLinkScope$shapeForRange$1$1
                    @Override // androidx.compose.ui.graphics.Shape
                    /* JADX INFO: renamed from: createOutline-Pq9zytI */
                    public final ColorKt mo56createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
                        return new Outline$Generic(pathForRange);
                    }
                } : null;
                if (shape != null) {
                    reusableGraphicsLayerScope.setShape(shape);
                    reusableGraphicsLayerScope.setClip(true);
                }
                return Unit.INSTANCE;
            case 7:
                Ref$IntRef ref$IntRef = (Ref$IntRef) this.f$0;
                Ref$IntRef ref$IntRef2 = (Ref$IntRef) this.f$1;
                MatchResult matchResult = (MatchResult) obj;
                if (ref$IntRef.element == -1) {
                    ref$IntRef.element = ((MatcherMatchResult) matchResult).getRange().first;
                }
                ref$IntRef2.element = ((MatcherMatchResult) matchResult).getRange().last + 1;
                return "";
            case 8:
                Function0 function2 = (Function0) this.f$0;
                Function0 function3 = (Function0) this.f$1;
                TextContextMenuSession textContextMenuSession = (TextContextMenuSession) obj;
                function2.invoke();
                if (function3 != null ? ((Boolean) function3.invoke()).booleanValue() : true) {
                    textContextMenuSession.close();
                }
                return Unit.INSTANCE;
            case 9:
                Placeable placeable2 = (Placeable) this.f$0;
                Placeable placeable3 = (Placeable) this.f$1;
                Placeable.PlacementScope placementScope2 = (Placeable.PlacementScope) obj;
                boolean z2 = placeable2.width > placementScope2.mo75roundToPx0680j_4(6.0f);
                float f = z2 ? 12.0f : 6.0f;
                float f2 = z2 ? 14.0f : 6.0f;
                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable3, 0, 0);
                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, Math.min(placeable3.width - placementScope2.mo75roundToPx0680j_4(f), ((int) placementScope2.current(CardKt.BadgeEndRuler, Float.POSITIVE_INFINITY)) - placeable2.width), Math.max(placementScope2.mo75roundToPx0680j_4(f2) + (-placeable2.height), (int) placementScope2.current(CardKt.BadgeTopRuler, Float.NEGATIVE_INFINITY)));
                return Unit.INSTANCE;
            case 10:
                return new AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1(b2, new ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1((View) this.f$0, (Function0) this.f$1));
            case 11:
                AndroidPath androidPath = (AndroidPath) this.f$0;
                IndicatorLineNode indicatorLineNode = (IndicatorLineNode) this.f$1;
                LayoutNodeDrawScope layoutNodeDrawScope2 = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope2.drawContent();
                Animatable animatable = indicatorLineNode.colorAnimatable;
                animatable.getClass();
                DrawScope.m547drawPathGBMwjPU$default(layoutNodeDrawScope2, androidPath, new SolidColor(((Color) animatable.getValue()).value), CropImageView.DEFAULT_ASPECT_RATIO, null, 60);
                return Unit.INSTANCE;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((Placeable.PlacementScope) obj).place((Placeable) this.f$0, 0, 0, ((FloatProducer) this.f$1).invoke());
                return Unit.INSTANCE;
            case 13:
                SourcesJvmKt$asInputStream$isClosed$1 sourcesJvmKt$asInputStream$isClosed$1 = (SourcesJvmKt$asInputStream$isClosed$1) this.f$0;
                PaddingValues paddingValues = (PaddingValues) this.f$1;
                LayoutNodeDrawScope layoutNodeDrawScope3 = (LayoutNodeDrawScope) obj;
                long j = ((Size) sourcesJvmKt$asInputStream$isClosed$1.get()).packedValue;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
                if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                    float fMo81toPx0680j_4 = layoutNodeDrawScope3.mo81toPx0680j_4(4.0f);
                    CanvasDrawScope canvasDrawScope = layoutNodeDrawScope3.canvasDrawScope;
                    float fMo81toPx0680j_5 = layoutNodeDrawScope3.mo81toPx0680j_4(paddingValues.mo123calculateLeftPaddingu2uoSUM(layoutNodeDrawScope3.getLayoutDirection()));
                    float fRoundToInt = (MathKt.roundToInt((Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() >> 32)) - fMo81toPx0680j_5) - layoutNodeDrawScope3.mo81toPx0680j_4(paddingValues.mo124calculateRightPaddingu2uoSUM(layoutNodeDrawScope3.getLayoutDirection()))) - MathKt.roundToInt(fIntBitsToFloat)) / 2.0f;
                    float f3 = fIntBitsToFloat / 2.0f;
                    float fRound = Math.round((1.0f + (layoutNodeDrawScope3.getLayoutDirection() != LayoutDirection.Ltr ? (-1.0f) * (-1.0f) : -1.0f)) * fRoundToInt) + fMo81toPx0680j_5 + f3;
                    float f4 = (fRound - f3) - fMo81toPx0680j_4;
                    float f5 = f4 < CropImageView.DEFAULT_ASPECT_RATIO ? 0.0f : f4;
                    float f6 = fRound + f3 + fMo81toPx0680j_4;
                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() >> 32));
                    float f7 = f6 > fIntBitsToFloat2 ? fIntBitsToFloat2 : f6;
                    float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j & 4294967295L));
                    float f8 = (-fIntBitsToFloat3) / 2.0f;
                    float f9 = fIntBitsToFloat3 / 2.0f;
                    EmojiProcessor emojiProcessor = canvasDrawScope.drawContext;
                    long jM831getSizeNHjbRc = emojiProcessor.m831getSizeNHjbRc();
                    emojiProcessor.getCanvas().save();
                    try {
                        ((DrawResult) emojiProcessor.mSpanFactory).m401clipRectN_I0leg(f5, f8, f7, f9, 0);
                        layoutNodeDrawScope3.drawContent();
                    } finally {
                        IntIntPair$$ExternalSyntheticOutline0.m(emojiProcessor, jM831getSizeNHjbRc);
                    }
                } else {
                    layoutNodeDrawScope3.drawContent();
                }
                return Unit.INSTANCE;
            case 14:
                ((MutableWindowInsets) this.f$0).insets$delegate.setValue(new ExcludeInsets((WindowInsets) this.f$1, (WindowInsets) obj));
                return Unit.INSTANCE;
            case 15:
                String str = (String) this.f$0;
                Function0 function4 = (Function0) this.f$1;
                SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj;
                SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, 1.0f);
                if (str != null) {
                    SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
                }
                semanticsPropertyReceiver.set(SemanticsActions.OnClick, new AccessibilityAction(null, new Handshake$$ExternalSyntheticLambda0(function4, (byte) 5)));
                return Unit.INSTANCE;
            case 16:
                AnalogTimePickerState analogTimePickerState = (AnalogTimePickerState) this.f$0;
                TimePickerColors timePickerColors = (TimePickerColors) this.f$1;
                LayoutNodeDrawScope layoutNodeDrawScope4 = (LayoutNodeDrawScope) obj;
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(layoutNodeDrawScope4.mo81toPx0680j_4(DpOffset.m798getXD9Ej5fM(TimePickerKt.getSelectorPos(analogTimePickerState))))) << 32) | (((long) Float.floatToRawIntBits(layoutNodeDrawScope4.mo81toPx0680j_4(DpOffset.m799getYD9Ej5fM(TimePickerKt.getSelectorPos(analogTimePickerState))))) & 4294967295L);
                float fMo81toPx0680j_6 = layoutNodeDrawScope4.mo81toPx0680j_4(48.0f) / 2.0f;
                float fM240getCurrentDiameterD9Ej5fM = analogTimePickerState.m240getCurrentDiameterD9Ej5fM();
                CanvasDrawScope canvasDrawScope2 = layoutNodeDrawScope4.canvasDrawScope;
                float fMo75roundToPx0680j_4 = (fMo81toPx0680j_6 * canvasDrawScope2.mo75roundToPx0680j_4(fM240getCurrentDiameterD9Ej5fM)) / canvasDrawScope2.mo75roundToPx0680j_4(256.0f);
                long j2 = timePickerColors.selectorColor;
                DrawScope.m543drawCircleVaOC9Bg$default(layoutNodeDrawScope4, -72057594037927936L, fMo75roundToPx0680j_4, jFloatToRawIntBits, null, 0, 56);
                layoutNodeDrawScope4.drawContent();
                DrawScope.m543drawCircleVaOC9Bg$default(layoutNodeDrawScope4, j2, fMo75roundToPx0680j_4, jFloatToRawIntBits, null, 11, 56);
                layoutNodeDrawScope4.mo535drawLineNGM6Ib0(j2, FileSystemsKt.m881getCenteruvyYCjk(canvasDrawScope2.mo556getSizeNHjbRc()), Offset.m438minusMKHz9U(jFloatToRawIntBits, (((long) Float.floatToRawIntBits(((float) Math.sin(((Number) analogTimePickerState.anim.getValue()).floatValue())) * fMo75roundToPx0680j_4)) & 4294967295L) | (((long) Float.floatToRawIntBits(fMo75roundToPx0680j_4 * ((float) Math.cos(((Number) analogTimePickerState.anim.getValue()).floatValue())))) << 32)), layoutNodeDrawScope4.mo81toPx0680j_4(2.0f), (496 & 16) != 0 ? 0 : 0, 3);
                DrawScope.m543drawCircleVaOC9Bg$default(layoutNodeDrawScope4, j2, layoutNodeDrawScope4.mo81toPx0680j_4(8.0f) / 2.0f, FileSystemsKt.m881getCenteruvyYCjk(canvasDrawScope2.mo556getSizeNHjbRc()), null, 0, 120);
                DrawScope.m543drawCircleVaOC9Bg$default(layoutNodeDrawScope4, timePickerColors.clockDialSelectedContentColor, fMo75roundToPx0680j_4, jFloatToRawIntBits, null, 4, 56);
                return Unit.INSTANCE;
            case 17:
                Listener listener = (Listener) this.f$0;
                AccessibilityManager accessibilityManager = (AccessibilityManager) this.f$1;
                if (((Lifecycle.Event) obj) == Lifecycle.Event.ON_RESUME) {
                    listener.register(accessibilityManager);
                }
                return Unit.INSTANCE;
            case 18:
                CacheDrawScope cacheDrawScope = (CacheDrawScope) obj;
                return cacheDrawScope.onDrawWithContent(new CodecsKt$$ExternalSyntheticLambda0(new ZIndexNode$$ExternalSyntheticLambda0((Object) ((Shape) this.f$0).mo56createOutlinePq9zytI(cacheDrawScope.cacheParams.mo398getSizeNHjbRc(), cacheDrawScope.cacheParams.getLayoutDirection(), cacheDrawScope), this.f$1, (byte) 19), (byte) 11));
            case 19:
                ColorKt.m490drawOutlinewDX37Ww$default((DrawScope) obj, (ColorKt) this.f$0, ((TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0) this.f$1).mo314invoke0d7_KjU());
                return Unit.INSTANCE;
            case 20:
                Function0 function5 = (Function0) this.f$0;
                MutableState mutableState = (MutableState) this.f$1;
                Size size2 = (Size) obj;
                float fFloatValue = ((Number) function5.invoke()).floatValue();
                float fIntBitsToFloat4 = Float.intBitsToFloat((int) (size2.packedValue >> 32)) * fFloatValue;
                float fIntBitsToFloat5 = Float.intBitsToFloat((int) (size2.packedValue & 4294967295L)) * fFloatValue;
                if (Float.intBitsToFloat((int) (((Size) mutableState.getValue()).packedValue >> 32)) != fIntBitsToFloat4 || Float.intBitsToFloat((int) (((Size) mutableState.getValue()).packedValue & 4294967295L)) != fIntBitsToFloat5) {
                    mutableState.setValue(new Size((((long) Float.floatToRawIntBits(fIntBitsToFloat4)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat5)) & 4294967295L)));
                }
                return Unit.INSTANCE;
            case 21:
                ((MultiSubscriptionSnapshotFlowManager) this.f$0).pendingChanges.add(new MultiSubscriptionSnapshotFlowManager.Add(obj, (SendChannel) this.f$1));
                return Unit.INSTANCE;
            case 22:
                CompositionImpl compositionImpl = (CompositionImpl) this.f$0;
                MutableScatterSet mutableScatterSet = (MutableScatterSet) this.f$1;
                compositionImpl.recordWriteOf(obj);
                if (mutableScatterSet != null) {
                    mutableScatterSet.add(obj);
                }
                return Unit.INSTANCE;
            case 23:
                Recomposer recomposer = (Recomposer) this.f$0;
                Throwable th = (Throwable) this.f$1;
                Throwable th2 = (Throwable) obj;
                synchronized (recomposer.stateLock) {
                    if (th == null) {
                        th = null;
                    } else if (th2 != null) {
                        try {
                            if (th2 instanceof CancellationException) {
                                th2 = null;
                            }
                            if (th2 != null) {
                                ResultKt.addSuppressed(th, th2);
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    recomposer.closeCause = th;
                    StateFlowImpl stateFlowImpl = recomposer._state;
                    Recomposer.State state = Recomposer.State.ShutDown;
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, state);
                }
                return Unit.INSTANCE;
            case 24:
                Placeable.PlacementScope.placeWithLayer$default((Placeable.PlacementScope) obj, (Placeable) this.f$0, 0, 0, ((BlockGraphicsLayerModifier) this.f$1).layerBlock, 4);
                return Unit.INSTANCE;
            case 25:
                Placeable.PlacementScope.placeWithLayer$default((Placeable.PlacementScope) obj, (Placeable) this.f$0, 0, 0, ((SimpleGraphicsLayerModifier) this.f$1).layerBlock, 4);
                return Unit.INSTANCE;
            case 26:
                Dispatcher dispatcher = (Dispatcher) this.f$0;
                PointerInteropFilter pointerInteropFilter = (PointerInteropFilter) this.f$1;
                MotionEvent motionEvent = (MotionEvent) obj;
                if (motionEvent.getActionMasked() == 0) {
                    dispatcher.readyAsyncCalls = ((Boolean) ((AndroidViewHolder$$ExternalSyntheticLambda4) pointerInteropFilter.getOnTouchEvent()).invoke(motionEvent)).booleanValue() ? PointerInteropFilter.DispatchToViewState.Dispatching : PointerInteropFilter.DispatchToViewState.NotDispatching;
                } else {
                    ((AndroidViewHolder$$ExternalSyntheticLambda4) pointerInteropFilter.getOnTouchEvent()).invoke(motionEvent);
                }
                return Unit.INSTANCE;
            case 27:
                Resources resources = (Resources) this.f$0;
                SemanticsNode semanticsNode = (SemanticsNode) obj;
                AdjustedSemanticsNode adjustedSemanticsNode = (AdjustedSemanticsNode) ((IntObjectMap) this.f$1).get(semanticsNode.id);
                if (adjustedSemanticsNode != null && adjustedSemanticsNode.isInMergingHiddenSubtree) {
                    z = true;
                }
                return Boolean.valueOf(InvertMatrixKt.isScreenReaderFocusable(semanticsNode, resources, z));
            case 28:
                return new InputMethodSession((LegacyTextInputMethodRequest) this.f$0, new RoomDatabase$$ExternalSyntheticLambda0((byte) 13, (AndroidPlatformTextInputSession) this.f$1));
            default:
                WrappedComposition wrappedComposition = (WrappedComposition) this.f$0;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) this.f$1;
                ComposeViewContext composeViewContext = (ComposeViewContext) obj;
                if (!wrappedComposition.disposed) {
                    LifecycleOwner lifecycleOwner$ui = composeViewContext.getLifecycleOwner$ui();
                    View view = composeViewContext.view;
                    Lifecycle lifecycle = lifecycleOwner$ui.getLifecycle();
                    wrappedComposition.lastContent = composableLambdaImpl;
                    if (wrappedComposition.addedToLifecycle == null) {
                        if (Intrinsics.areEqual(Looper.myLooper(), view.getHandler().getLooper())) {
                            wrappedComposition.addedToLifecycle = lifecycle;
                            lifecycle.addObserver(wrappedComposition);
                        } else {
                            view.post(new ComponentActivity$$ExternalSyntheticLambda10(wrappedComposition, lifecycle, (byte) 3));
                        }
                    } else if (((LifecycleRegistry) lifecycle).state.compareTo(Lifecycle.State.CREATED) >= 0) {
                        wrappedComposition.original.setContent(new ComposableLambdaImpl(true, -1723985096, new MainActivity$$ExternalSyntheticLambda9((Object) wrappedComposition, (Object) composeViewContext, (Object) composableLambdaImpl, (byte) 12)));
                    }
                }
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ ZIndexNode$$ExternalSyntheticLambda0(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }
}
