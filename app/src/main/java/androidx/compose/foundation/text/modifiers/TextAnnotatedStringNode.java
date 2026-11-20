package androidx.compose.foundation.text.modifiers;

import android.os.Trace;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidTextPaint_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import coil3.util.FileSystemsKt;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextAnnotatedStringNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    public MultiParagraphLayoutCache _layoutCache;
    public Map baselineCache;
    public FontFamily.Resolver fontFamilyResolver;
    public int maxLines;
    public int minLines;
    public Function1 onPlaceholderLayout;
    public Function1 onShowTranslation;
    public Function1 onTextLayout;
    public int overflow;
    public List placeholders;
    public TextAnnotatedStringNode$$ExternalSyntheticLambda1 semanticsTextLayoutResult;
    public boolean softWrap;
    public TextStyle style;
    public AnnotatedString text;
    public TextSubstitutionValue textSubstitution;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TextSubstitutionValue {
        public boolean isShowingSubstitution = false;
        public MultiParagraphLayoutCache layoutCache = null;
        public final AnnotatedString original;
        public AnnotatedString substitution;

        public TextSubstitutionValue(AnnotatedString annotatedString, AnnotatedString annotatedString2) {
            this.original = annotatedString;
            this.substitution = annotatedString2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TextSubstitutionValue)) {
                return false;
            }
            TextSubstitutionValue textSubstitutionValue = (TextSubstitutionValue) obj;
            return Intrinsics.areEqual(this.original, textSubstitutionValue.original) && Intrinsics.areEqual(this.substitution, textSubstitutionValue.substitution) && this.isShowingSubstitution == textSubstitutionValue.isShowingSubstitution && Intrinsics.areEqual(this.layoutCache, textSubstitutionValue.layoutCache);
        }

        public final int hashCode() {
            int iM = IntIntPair$$ExternalSyntheticOutline0.m((this.substitution.hashCode() + (this.original.hashCode() * 31)) * 31, this.isShowingSubstitution, 31);
            MultiParagraphLayoutCache multiParagraphLayoutCache = this.layoutCache;
            return iM + (multiParagraphLayoutCache == null ? 0 : multiParagraphLayoutCache.hashCode());
        }

        public final String toString() {
            AnnotatedString annotatedString = this.substitution;
            return "TextSubstitutionValue(original=" + ((Object) this.original) + ", substitution=" + ((Object) annotatedString) + ", isShowingSubstitution=" + this.isShowingSubstitution + ", layoutCache=" + this.layoutCache + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$$ExternalSyntheticLambda1] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        TextAnnotatedStringNode$$ExternalSyntheticLambda1 textAnnotatedStringNode$$ExternalSyntheticLambda1 = this.semanticsTextLayoutResult;
        ?? r0 = textAnnotatedStringNode$$ExternalSyntheticLambda1;
        if (textAnnotatedStringNode$$ExternalSyntheticLambda1 == null) {
            final byte b = 0;
            ?? r1 = new Function1(this) { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$$ExternalSyntheticLambda1
                public final /* synthetic */ TextAnnotatedStringNode f$0;

                {
                    this.f$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    TextLayoutResult textLayoutResult;
                    boolean z;
                    byte b2 = b;
                    TextAnnotatedStringNode textAnnotatedStringNode = this.f$0;
                    switch (b2) {
                        case 0:
                            List list = (List) obj;
                            TextLayoutResult textLayoutResult2 = textAnnotatedStringNode.getLayoutCache().layoutCache;
                            if (textLayoutResult2 != null) {
                                TextLayoutInput textLayoutInput = textLayoutResult2.layoutInput;
                                textLayoutResult = new TextLayoutResult(new TextLayoutInput(textLayoutInput.text, TextStyle.m751mergedA7vx0o$default(textAnnotatedStringNode.style, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified), 0L, null, null, null, 0L, 0, 0L, 16777214), textLayoutInput.placeholders, textLayoutInput.maxLines, textLayoutInput.softWrap, textLayoutInput.overflow, textLayoutInput.density, textLayoutInput.layoutDirection, textLayoutInput.fontFamilyResolver, textLayoutInput.constraints), textLayoutResult2.multiParagraph, textLayoutResult2.size);
                                list.add(textLayoutResult);
                            } else {
                                textLayoutResult = null;
                            }
                            return Boolean.valueOf(textLayoutResult != null);
                        case 1:
                            AnnotatedString annotatedString = (AnnotatedString) obj;
                            TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue = textAnnotatedStringNode.textSubstitution;
                            EmptyList emptyList = EmptyList.INSTANCE;
                            if (textSubstitutionValue == null) {
                                TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue2 = new TextAnnotatedStringNode.TextSubstitutionValue(textAnnotatedStringNode.text, annotatedString);
                                MultiParagraphLayoutCache multiParagraphLayoutCache = new MultiParagraphLayoutCache(annotatedString, textAnnotatedStringNode.style, textAnnotatedStringNode.fontFamilyResolver, textAnnotatedStringNode.overflow, textAnnotatedStringNode.softWrap, textAnnotatedStringNode.maxLines, textAnnotatedStringNode.minLines, emptyList);
                                multiParagraphLayoutCache.setDensity$foundation(textAnnotatedStringNode.getLayoutCache().density);
                                textSubstitutionValue2.layoutCache = multiParagraphLayoutCache;
                                textAnnotatedStringNode.textSubstitution = textSubstitutionValue2;
                            } else if (!Intrinsics.areEqual(annotatedString, textSubstitutionValue.substitution)) {
                                textSubstitutionValue.substitution = annotatedString;
                                MultiParagraphLayoutCache multiParagraphLayoutCache2 = textSubstitutionValue.layoutCache;
                                if (multiParagraphLayoutCache2 != null) {
                                    multiParagraphLayoutCache2.m222updateJ2qo7bo(annotatedString, textAnnotatedStringNode.style, textAnnotatedStringNode.fontFamilyResolver, textAnnotatedStringNode.overflow, textAnnotatedStringNode.softWrap, textAnnotatedStringNode.maxLines, textAnnotatedStringNode.minLines, emptyList);
                                }
                            }
                            HitTestResultKt.invalidateSemantics(textAnnotatedStringNode);
                            HitTestResultKt.invalidateMeasurement(textAnnotatedStringNode);
                            HitTestResultKt.invalidateDraw(textAnnotatedStringNode);
                            return Boolean.TRUE;
                        default:
                            boolean zBooleanValue = ((Boolean) obj).booleanValue();
                            TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue3 = textAnnotatedStringNode.textSubstitution;
                            if (textSubstitutionValue3 == null) {
                                z = false;
                            } else {
                                Function1 function1 = textAnnotatedStringNode.onShowTranslation;
                                if (function1 != null) {
                                    function1.invoke(textSubstitutionValue3);
                                }
                                TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue4 = textAnnotatedStringNode.textSubstitution;
                                if (textSubstitutionValue4 != null) {
                                    textSubstitutionValue4.isShowingSubstitution = zBooleanValue;
                                }
                                HitTestResultKt.invalidateSemantics(textAnnotatedStringNode);
                                HitTestResultKt.invalidateMeasurement(textAnnotatedStringNode);
                                HitTestResultKt.invalidateDraw(textAnnotatedStringNode);
                                z = true;
                            }
                            return Boolean.valueOf(z);
                    }
                }
            };
            this.semanticsTextLayoutResult = r1;
            r0 = r1;
        }
        AnnotatedString annotatedString = this.text;
        KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
        semanticsPropertyReceiver.set(SemanticsProperties.Text, CollectionsKt__IterablesKt.listOf(annotatedString));
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue != null) {
            AnnotatedString annotatedString2 = textSubstitutionValue.substitution;
            SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.TextSubstitution;
            KProperty[] kPropertyArr2 = SemanticsPropertiesKt.$$delegatedProperties;
            KProperty kProperty = kPropertyArr2[17];
            semanticsPropertyKey.getClass();
            semanticsPropertyReceiver.set(semanticsPropertyKey, annotatedString2);
            boolean z = textSubstitutionValue.isShowingSubstitution;
            SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.IsShowingTextSubstitution;
            KProperty kProperty2 = kPropertyArr2[18];
            Boolean boolValueOf = Boolean.valueOf(z);
            semanticsPropertyKey2.getClass();
            semanticsPropertyReceiver.set(semanticsPropertyKey2, boolValueOf);
        }
        final byte b2 = 1;
        semanticsPropertyReceiver.set(SemanticsActions.SetTextSubstitution, new AccessibilityAction(null, new Function1(this) { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$$ExternalSyntheticLambda1
            public final /* synthetic */ TextAnnotatedStringNode f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                TextLayoutResult textLayoutResult;
                boolean z2;
                byte b3 = b2;
                TextAnnotatedStringNode textAnnotatedStringNode = this.f$0;
                switch (b3) {
                    case 0:
                        List list = (List) obj;
                        TextLayoutResult textLayoutResult2 = textAnnotatedStringNode.getLayoutCache().layoutCache;
                        if (textLayoutResult2 != null) {
                            TextLayoutInput textLayoutInput = textLayoutResult2.layoutInput;
                            textLayoutResult = new TextLayoutResult(new TextLayoutInput(textLayoutInput.text, TextStyle.m751mergedA7vx0o$default(textAnnotatedStringNode.style, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified), 0L, null, null, null, 0L, 0, 0L, 16777214), textLayoutInput.placeholders, textLayoutInput.maxLines, textLayoutInput.softWrap, textLayoutInput.overflow, textLayoutInput.density, textLayoutInput.layoutDirection, textLayoutInput.fontFamilyResolver, textLayoutInput.constraints), textLayoutResult2.multiParagraph, textLayoutResult2.size);
                            list.add(textLayoutResult);
                        } else {
                            textLayoutResult = null;
                        }
                        return Boolean.valueOf(textLayoutResult != null);
                    case 1:
                        AnnotatedString annotatedString3 = (AnnotatedString) obj;
                        TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue2 = textAnnotatedStringNode.textSubstitution;
                        EmptyList emptyList = EmptyList.INSTANCE;
                        if (textSubstitutionValue2 == null) {
                            TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue3 = new TextAnnotatedStringNode.TextSubstitutionValue(textAnnotatedStringNode.text, annotatedString3);
                            MultiParagraphLayoutCache multiParagraphLayoutCache = new MultiParagraphLayoutCache(annotatedString3, textAnnotatedStringNode.style, textAnnotatedStringNode.fontFamilyResolver, textAnnotatedStringNode.overflow, textAnnotatedStringNode.softWrap, textAnnotatedStringNode.maxLines, textAnnotatedStringNode.minLines, emptyList);
                            multiParagraphLayoutCache.setDensity$foundation(textAnnotatedStringNode.getLayoutCache().density);
                            textSubstitutionValue3.layoutCache = multiParagraphLayoutCache;
                            textAnnotatedStringNode.textSubstitution = textSubstitutionValue3;
                        } else if (!Intrinsics.areEqual(annotatedString3, textSubstitutionValue2.substitution)) {
                            textSubstitutionValue2.substitution = annotatedString3;
                            MultiParagraphLayoutCache multiParagraphLayoutCache2 = textSubstitutionValue2.layoutCache;
                            if (multiParagraphLayoutCache2 != null) {
                                multiParagraphLayoutCache2.m222updateJ2qo7bo(annotatedString3, textAnnotatedStringNode.style, textAnnotatedStringNode.fontFamilyResolver, textAnnotatedStringNode.overflow, textAnnotatedStringNode.softWrap, textAnnotatedStringNode.maxLines, textAnnotatedStringNode.minLines, emptyList);
                            }
                        }
                        HitTestResultKt.invalidateSemantics(textAnnotatedStringNode);
                        HitTestResultKt.invalidateMeasurement(textAnnotatedStringNode);
                        HitTestResultKt.invalidateDraw(textAnnotatedStringNode);
                        return Boolean.TRUE;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue4 = textAnnotatedStringNode.textSubstitution;
                        if (textSubstitutionValue4 == null) {
                            z2 = false;
                        } else {
                            Function1 function1 = textAnnotatedStringNode.onShowTranslation;
                            if (function1 != null) {
                                function1.invoke(textSubstitutionValue4);
                            }
                            TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue5 = textAnnotatedStringNode.textSubstitution;
                            if (textSubstitutionValue5 != null) {
                                textSubstitutionValue5.isShowingSubstitution = zBooleanValue;
                            }
                            HitTestResultKt.invalidateSemantics(textAnnotatedStringNode);
                            HitTestResultKt.invalidateMeasurement(textAnnotatedStringNode);
                            HitTestResultKt.invalidateDraw(textAnnotatedStringNode);
                            z2 = true;
                        }
                        return Boolean.valueOf(z2);
                }
            }
        }));
        final byte b3 = 2;
        semanticsPropertyReceiver.set(SemanticsActions.ShowTextSubstitution, new AccessibilityAction(null, new Function1(this) { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$$ExternalSyntheticLambda1
            public final /* synthetic */ TextAnnotatedStringNode f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                TextLayoutResult textLayoutResult;
                boolean z2;
                byte b4 = b3;
                TextAnnotatedStringNode textAnnotatedStringNode = this.f$0;
                switch (b4) {
                    case 0:
                        List list = (List) obj;
                        TextLayoutResult textLayoutResult2 = textAnnotatedStringNode.getLayoutCache().layoutCache;
                        if (textLayoutResult2 != null) {
                            TextLayoutInput textLayoutInput = textLayoutResult2.layoutInput;
                            textLayoutResult = new TextLayoutResult(new TextLayoutInput(textLayoutInput.text, TextStyle.m751mergedA7vx0o$default(textAnnotatedStringNode.style, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified), 0L, null, null, null, 0L, 0, 0L, 16777214), textLayoutInput.placeholders, textLayoutInput.maxLines, textLayoutInput.softWrap, textLayoutInput.overflow, textLayoutInput.density, textLayoutInput.layoutDirection, textLayoutInput.fontFamilyResolver, textLayoutInput.constraints), textLayoutResult2.multiParagraph, textLayoutResult2.size);
                            list.add(textLayoutResult);
                        } else {
                            textLayoutResult = null;
                        }
                        return Boolean.valueOf(textLayoutResult != null);
                    case 1:
                        AnnotatedString annotatedString3 = (AnnotatedString) obj;
                        TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue2 = textAnnotatedStringNode.textSubstitution;
                        EmptyList emptyList = EmptyList.INSTANCE;
                        if (textSubstitutionValue2 == null) {
                            TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue3 = new TextAnnotatedStringNode.TextSubstitutionValue(textAnnotatedStringNode.text, annotatedString3);
                            MultiParagraphLayoutCache multiParagraphLayoutCache = new MultiParagraphLayoutCache(annotatedString3, textAnnotatedStringNode.style, textAnnotatedStringNode.fontFamilyResolver, textAnnotatedStringNode.overflow, textAnnotatedStringNode.softWrap, textAnnotatedStringNode.maxLines, textAnnotatedStringNode.minLines, emptyList);
                            multiParagraphLayoutCache.setDensity$foundation(textAnnotatedStringNode.getLayoutCache().density);
                            textSubstitutionValue3.layoutCache = multiParagraphLayoutCache;
                            textAnnotatedStringNode.textSubstitution = textSubstitutionValue3;
                        } else if (!Intrinsics.areEqual(annotatedString3, textSubstitutionValue2.substitution)) {
                            textSubstitutionValue2.substitution = annotatedString3;
                            MultiParagraphLayoutCache multiParagraphLayoutCache2 = textSubstitutionValue2.layoutCache;
                            if (multiParagraphLayoutCache2 != null) {
                                multiParagraphLayoutCache2.m222updateJ2qo7bo(annotatedString3, textAnnotatedStringNode.style, textAnnotatedStringNode.fontFamilyResolver, textAnnotatedStringNode.overflow, textAnnotatedStringNode.softWrap, textAnnotatedStringNode.maxLines, textAnnotatedStringNode.minLines, emptyList);
                            }
                        }
                        HitTestResultKt.invalidateSemantics(textAnnotatedStringNode);
                        HitTestResultKt.invalidateMeasurement(textAnnotatedStringNode);
                        HitTestResultKt.invalidateDraw(textAnnotatedStringNode);
                        return Boolean.TRUE;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue4 = textAnnotatedStringNode.textSubstitution;
                        if (textSubstitutionValue4 == null) {
                            z2 = false;
                        } else {
                            Function1 function1 = textAnnotatedStringNode.onShowTranslation;
                            if (function1 != null) {
                                function1.invoke(textSubstitutionValue4);
                            }
                            TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue5 = textAnnotatedStringNode.textSubstitution;
                            if (textSubstitutionValue5 != null) {
                                textSubstitutionValue5.isShowingSubstitution = zBooleanValue;
                            }
                            HitTestResultKt.invalidateSemantics(textAnnotatedStringNode);
                            HitTestResultKt.invalidateMeasurement(textAnnotatedStringNode);
                            HitTestResultKt.invalidateDraw(textAnnotatedStringNode);
                            z2 = true;
                        }
                        return Boolean.valueOf(z2);
                }
            }
        }));
        semanticsPropertyReceiver.set(SemanticsActions.ClearTextSubstitution, new AccessibilityAction(null, new SliderState$$ExternalSyntheticLambda0((byte) 23, this)));
        semanticsPropertyReceiver.set(SemanticsActions.GetTextLayoutResult, new AccessibilityAction(null, r0));
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        List list;
        if (this.isAttached) {
            Canvas canvas = layoutNodeDrawScope.canvasDrawScope.drawContext.getCanvas();
            MultiParagraphLayoutCache layoutCache = getLayoutCache(layoutNodeDrawScope);
            TextLayoutResult textLayoutResult = layoutCache.layoutCache;
            if (textLayoutResult == null) {
                PathKt$$ExternalSyntheticBUOutline0.m$1(layoutCache, "Internal Error: MultiParagraphLayoutCache could not provide TextLayoutResult during the draw phase. Please report this bug on the official Issue Tracker with the following diagnostic information: ");
                return;
            }
            MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
            boolean z = textLayoutResult.getHasVisualOverflow() && this.overflow != 3;
            if (z) {
                long j = textLayoutResult.size;
                Rect rectM896Recttz77jQw = IntMath.m896Recttz77jQw(0L, (((long) Float.floatToRawIntBits((int) (j >> 32))) << 32) | (((long) Float.floatToRawIntBits((int) (j & 4294967295L))) & 4294967295L));
                canvas.save();
                canvas.mo453clipRectN_I0leg(rectM896Recttz77jQw.left, rectM896Recttz77jQw.top, rectM896Recttz77jQw.right, rectM896Recttz77jQw.bottom, 1);
            }
            try {
                SpanStyle spanStyle = this.style.spanStyle;
                TextDecoration textDecoration = spanStyle.textDecoration;
                if (textDecoration == null) {
                    textDecoration = TextDecoration.None;
                }
                TextDecoration textDecoration2 = textDecoration;
                Shadow shadow = spanStyle.shadow;
                if (shadow == null) {
                    shadow = Shadow.None;
                }
                Shadow shadow2 = shadow;
                DrawStyle drawStyle = spanStyle.drawStyle;
                if (drawStyle == null) {
                    drawStyle = Fill.INSTANCE;
                }
                DrawStyle drawStyle2 = drawStyle;
                Brush brush = spanStyle.textForegroundStyle.getBrush();
                if (brush != null) {
                    AndroidTextPaint_androidKt.m766drawMultiParagraph7AXcY_I(multiParagraph, canvas, brush, this.style.spanStyle.textForegroundStyle.getAlpha(), shadow2, textDecoration2, drawStyle2);
                } else {
                    long jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    if (jColor == 16) {
                        jColor = this.style.m752getColor0d7_KjU() != 16 ? this.style.m752getColor0d7_KjU() : -72057594037927936L;
                    }
                    multiParagraph.m731paintLG529CI(canvas, jColor, shadow2, textDecoration2, drawStyle2);
                }
                if (z) {
                    canvas.restore();
                }
                TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
                if (((textSubstitutionValue == null || !textSubstitutionValue.isShowingSubstitution) ? MathKt.hasLinks(this.text) : false) || !((list = this.placeholders) == null || list.isEmpty())) {
                    layoutNodeDrawScope.drawContent();
                }
            } catch (Throwable th) {
                if (!z) {
                    throw th;
                }
                canvas.restore();
                throw th;
            }
        }
    }

    public final MultiParagraphLayoutCache getLayoutCache() {
        MultiParagraphLayoutCache multiParagraphLayoutCache = this._layoutCache;
        if (multiParagraphLayoutCache != null) {
            return multiParagraphLayoutCache;
        }
        MultiParagraphLayoutCache multiParagraphLayoutCache2 = new MultiParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders);
        this._layoutCache = multiParagraphLayoutCache2;
        return multiParagraphLayoutCache2;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return getLayoutCache(lookaheadCapablePlaceable).intrinsicHeight(i, lookaheadCapablePlaceable.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return BasicTextKt.ceilToIntPx(getLayoutCache(lookaheadCapablePlaceable).setLayoutDirection(lookaheadCapablePlaceable.getLayoutDirection()).getMaxIntrinsicWidth());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Trace.beginSection("TextAnnotatedStringNode:measure");
        try {
            MultiParagraphLayoutCache layoutCache = getLayoutCache(measureScope);
            boolean zM220layoutWithConstraintsK40F9xA = layoutCache.m220layoutWithConstraintsK40F9xA(j, measureScope.getLayoutDirection());
            TextLayoutResult textLayoutResult = layoutCache.layoutCache;
            if (textLayoutResult == null) {
                throw new IllegalStateException("Internal Error: MultiParagraphLayoutCache could not provide TextLayoutResult during the draw phase. Please report this bug on the official Issue Tracker with the following diagnostic information: " + layoutCache);
            }
            long j2 = textLayoutResult.size;
            textLayoutResult.multiParagraph.intrinsics.getHasStaleResolvedFonts();
            if (zM220layoutWithConstraintsK40F9xA) {
                HitTestResultKt.m646requireCoordinator64DMado(this, 2).invalidateLayer();
                Function1 function1 = this.onTextLayout;
                if (function1 != null) {
                    function1.invoke(textLayoutResult);
                }
                Map linkedHashMap = this.baselineCache;
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap(2);
                }
                linkedHashMap.put(AlignmentLineKt.FirstBaseline, Integer.valueOf(Math.round(textLayoutResult.firstBaseline)));
                linkedHashMap.put(AlignmentLineKt.LastBaseline, Integer.valueOf(Math.round(textLayoutResult.lastBaseline)));
                this.baselineCache = linkedHashMap;
            }
            Function1 function2 = this.onPlaceholderLayout;
            if (function2 != null) {
                function2.invoke(textLayoutResult.placeholderRects);
            }
            int i = (int) (j2 >> 32);
            int i2 = (int) (j2 & 4294967295L);
            Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(FileSystemsKt.m880fitPrioritizingWidthZbe2FdA(i, i, i2, i2));
            Map map = this.baselineCache;
            map.getClass();
            MeasureResult measureResultLayout = measureScope.layout(i, i2, map, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 14));
            Trace.endSection();
            return measureResultLayout;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return getLayoutCache(lookaheadCapablePlaceable).intrinsicHeight(i, lookaheadCapablePlaceable.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return BasicTextKt.ceilToIntPx(getLayoutCache(lookaheadCapablePlaceable).setLayoutDirection(lookaheadCapablePlaceable.getLayoutDirection()).getMinIntrinsicWidth());
    }

    public final MultiParagraphLayoutCache getLayoutCache(Density density) {
        MultiParagraphLayoutCache multiParagraphLayoutCache;
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue != null && textSubstitutionValue.isShowingSubstitution && (multiParagraphLayoutCache = textSubstitutionValue.layoutCache) != null) {
            multiParagraphLayoutCache.setDensity$foundation(density);
            return multiParagraphLayoutCache;
        }
        MultiParagraphLayoutCache layoutCache = getLayoutCache();
        layoutCache.setDensity$foundation(density);
        return layoutCache;
    }
}
