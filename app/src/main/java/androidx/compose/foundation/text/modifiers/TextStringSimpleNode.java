package androidx.compose.foundation.text.modifiers;

import android.os.Trace;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
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
import androidx.compose.ui.text.AndroidParagraph;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.ImageLoader$Builder;
import coil3.util.FileSystemsKt;
import com.yalantis.ucrop.view.CropImageView;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextStringSimpleNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    public ParagraphLayoutCache _layoutCache;
    public HashMap baselineCache;
    public FontFamily.Resolver fontFamilyResolver;
    public int maxLines;
    public int minLines;
    public int overflow;
    public TextStringSimpleNode$$ExternalSyntheticLambda0 semanticsTextLayoutResult;
    public boolean softWrap;
    public TextStyle style;
    public String text;
    public TextSubstitutionValue textSubstitution;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TextSubstitutionValue {
        public boolean isShowingSubstitution = false;
        public ParagraphLayoutCache layoutCache = null;
        public final String original;
        public String substitution;

        public TextSubstitutionValue(String str, String str2) {
            this.original = str;
            this.substitution = str2;
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
            int iM = IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.original.hashCode() * 31, 31, this.substitution), this.isShowingSubstitution, 31);
            ParagraphLayoutCache paragraphLayoutCache = this.layoutCache;
            return iM + (paragraphLayoutCache == null ? 0 : paragraphLayoutCache.hashCode());
        }

        public final String toString() {
            return "TextSubstitution(layoutCache=" + this.layoutCache + ", isShowingSubstitution=" + this.isShowingSubstitution + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.foundation.text.modifiers.TextStringSimpleNode$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        TextStringSimpleNode$$ExternalSyntheticLambda0 textStringSimpleNode$$ExternalSyntheticLambda0 = this.semanticsTextLayoutResult;
        ?? r0 = textStringSimpleNode$$ExternalSyntheticLambda0;
        if (textStringSimpleNode$$ExternalSyntheticLambda0 == null) {
            final byte b = 0;
            ?? r1 = new Function1(this) { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$$ExternalSyntheticLambda0
                public final /* synthetic */ TextStringSimpleNode f$0;

                {
                    this.f$0 = this;
                }

                /* JADX WARN: Code duplicated, block: B:23:0x00c1  */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Density density;
                    TextLayoutResult textLayoutResult;
                    byte b2 = b;
                    boolean z = true;
                    TextStringSimpleNode textStringSimpleNode = this.f$0;
                    switch (b2) {
                        case 0:
                            List list = (List) obj;
                            ParagraphLayoutCache layoutCache = textStringSimpleNode.getLayoutCache();
                            TextStyle textStyleM751mergedA7vx0o$default = TextStyle.m751mergedA7vx0o$default(textStringSimpleNode.style, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified), 0L, null, null, null, 0L, 0, 0L, 16777214);
                            LayoutDirection layoutDirection = layoutCache.intrinsicsLayoutDirection;
                            TextLayoutResult textLayoutResult2 = null;
                            if (layoutDirection == null || (density = layoutCache.density) == null) {
                                textLayoutResult = null;
                            } else {
                                AnnotatedString annotatedString = new AnnotatedString(layoutCache.text);
                                if (layoutCache.paragraph == null || layoutCache.paragraphIntrinsics == null) {
                                    textLayoutResult = null;
                                } else {
                                    long j = layoutCache.prevConstraints & (-8589934589L);
                                    int i = layoutCache.maxLines;
                                    boolean z2 = layoutCache.softWrap;
                                    int i2 = layoutCache.overflow;
                                    FontFamily.Resolver resolver = layoutCache.fontFamilyResolver;
                                    EmptyList emptyList = EmptyList.INSTANCE;
                                    textLayoutResult = new TextLayoutResult(new TextLayoutInput(annotatedString, textStyleM751mergedA7vx0o$default, emptyList, i, z2, i2, density, layoutDirection, resolver, j), new MultiParagraph(new ImageLoader$Builder(annotatedString, textStyleM751mergedA7vx0o$default, resolver, density, emptyList, z2), j, layoutCache.maxLines, layoutCache.overflow), layoutCache.layoutSize);
                                }
                            }
                            if (textLayoutResult != null) {
                                list.add(textLayoutResult);
                                textLayoutResult2 = textLayoutResult;
                            }
                            return Boolean.valueOf(textLayoutResult2 != null);
                        case 1:
                            String str = ((AnnotatedString) obj).text;
                            TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue = textStringSimpleNode.textSubstitution;
                            if (textSubstitutionValue == null) {
                                TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue2 = new TextStringSimpleNode.TextSubstitutionValue(textStringSimpleNode.text, str);
                                ParagraphLayoutCache paragraphLayoutCache = new ParagraphLayoutCache(str, textStringSimpleNode.style, textStringSimpleNode.fontFamilyResolver, textStringSimpleNode.overflow, textStringSimpleNode.softWrap, textStringSimpleNode.maxLines, textStringSimpleNode.minLines);
                                paragraphLayoutCache.setDensity$foundation(textStringSimpleNode.getLayoutCache().density);
                                textSubstitutionValue2.layoutCache = paragraphLayoutCache;
                                textStringSimpleNode.textSubstitution = textSubstitutionValue2;
                            } else if (!Intrinsics.areEqual(str, textSubstitutionValue.substitution)) {
                                textSubstitutionValue.substitution = str;
                                ParagraphLayoutCache paragraphLayoutCache2 = textSubstitutionValue.layoutCache;
                                if (paragraphLayoutCache2 != null) {
                                    TextStyle textStyle = textStringSimpleNode.style;
                                    FontFamily.Resolver resolver2 = textStringSimpleNode.fontFamilyResolver;
                                    int i3 = textStringSimpleNode.overflow;
                                    boolean z3 = textStringSimpleNode.softWrap;
                                    int i4 = textStringSimpleNode.maxLines;
                                    int i5 = textStringSimpleNode.minLines;
                                    paragraphLayoutCache2.text = str;
                                    paragraphLayoutCache2.style = textStyle;
                                    paragraphLayoutCache2.fontFamilyResolver = resolver2;
                                    paragraphLayoutCache2.overflow = i3;
                                    paragraphLayoutCache2.softWrap = z3;
                                    paragraphLayoutCache2.maxLines = i4;
                                    paragraphLayoutCache2.minLines = i5;
                                    paragraphLayoutCache2.historyFlag = (paragraphLayoutCache2.historyFlag << 2) | 2;
                                    paragraphLayoutCache2.markDirty();
                                }
                            }
                            HitTestResultKt.invalidateSemantics(textStringSimpleNode);
                            HitTestResultKt.invalidateMeasurement(textStringSimpleNode);
                            HitTestResultKt.invalidateDraw(textStringSimpleNode);
                            return Boolean.TRUE;
                        default:
                            boolean zBooleanValue = ((Boolean) obj).booleanValue();
                            TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue3 = textStringSimpleNode.textSubstitution;
                            if (textSubstitutionValue3 == null) {
                                z = false;
                            } else {
                                textSubstitutionValue3.isShowingSubstitution = zBooleanValue;
                                HitTestResultKt.invalidateSemantics(textStringSimpleNode);
                                HitTestResultKt.invalidateMeasurement(textStringSimpleNode);
                                HitTestResultKt.invalidateDraw(textStringSimpleNode);
                            }
                            return Boolean.valueOf(z);
                    }
                }
            };
            this.semanticsTextLayoutResult = r1;
            r0 = r1;
        }
        AnnotatedString annotatedString = new AnnotatedString(this.text);
        KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
        semanticsPropertyReceiver.set(SemanticsProperties.Text, CollectionsKt__IterablesKt.listOf(annotatedString));
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue != null) {
            boolean z = textSubstitutionValue.isShowingSubstitution;
            SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.IsShowingTextSubstitution;
            KProperty[] kPropertyArr2 = SemanticsPropertiesKt.$$delegatedProperties;
            KProperty kProperty = kPropertyArr2[18];
            Boolean boolValueOf = Boolean.valueOf(z);
            semanticsPropertyKey.getClass();
            semanticsPropertyReceiver.set(semanticsPropertyKey, boolValueOf);
            AnnotatedString annotatedString2 = new AnnotatedString(textSubstitutionValue.substitution);
            SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.TextSubstitution;
            KProperty kProperty2 = kPropertyArr2[17];
            semanticsPropertyKey2.getClass();
            semanticsPropertyReceiver.set(semanticsPropertyKey2, annotatedString2);
        }
        final byte b2 = 1;
        semanticsPropertyReceiver.set(SemanticsActions.SetTextSubstitution, new AccessibilityAction(null, new Function1(this) { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$$ExternalSyntheticLambda0
            public final /* synthetic */ TextStringSimpleNode f$0;

            {
                this.f$0 = this;
            }

            /* JADX WARN: Code duplicated, block: B:23:0x00c1  */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Density density;
                TextLayoutResult textLayoutResult;
                byte b3 = b2;
                boolean z2 = true;
                TextStringSimpleNode textStringSimpleNode = this.f$0;
                switch (b3) {
                    case 0:
                        List list = (List) obj;
                        ParagraphLayoutCache layoutCache = textStringSimpleNode.getLayoutCache();
                        TextStyle textStyleM751mergedA7vx0o$default = TextStyle.m751mergedA7vx0o$default(textStringSimpleNode.style, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified), 0L, null, null, null, 0L, 0, 0L, 16777214);
                        LayoutDirection layoutDirection = layoutCache.intrinsicsLayoutDirection;
                        TextLayoutResult textLayoutResult2 = null;
                        if (layoutDirection == null || (density = layoutCache.density) == null) {
                            textLayoutResult = null;
                        } else {
                            AnnotatedString annotatedString3 = new AnnotatedString(layoutCache.text);
                            if (layoutCache.paragraph == null || layoutCache.paragraphIntrinsics == null) {
                                textLayoutResult = null;
                            } else {
                                long j = layoutCache.prevConstraints & (-8589934589L);
                                int i = layoutCache.maxLines;
                                boolean z3 = layoutCache.softWrap;
                                int i2 = layoutCache.overflow;
                                FontFamily.Resolver resolver = layoutCache.fontFamilyResolver;
                                EmptyList emptyList = EmptyList.INSTANCE;
                                textLayoutResult = new TextLayoutResult(new TextLayoutInput(annotatedString3, textStyleM751mergedA7vx0o$default, emptyList, i, z3, i2, density, layoutDirection, resolver, j), new MultiParagraph(new ImageLoader$Builder(annotatedString3, textStyleM751mergedA7vx0o$default, resolver, density, emptyList, z3), j, layoutCache.maxLines, layoutCache.overflow), layoutCache.layoutSize);
                            }
                        }
                        if (textLayoutResult != null) {
                            list.add(textLayoutResult);
                            textLayoutResult2 = textLayoutResult;
                        }
                        return Boolean.valueOf(textLayoutResult2 != null);
                    case 1:
                        String str = ((AnnotatedString) obj).text;
                        TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue2 = textStringSimpleNode.textSubstitution;
                        if (textSubstitutionValue2 == null) {
                            TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue3 = new TextStringSimpleNode.TextSubstitutionValue(textStringSimpleNode.text, str);
                            ParagraphLayoutCache paragraphLayoutCache = new ParagraphLayoutCache(str, textStringSimpleNode.style, textStringSimpleNode.fontFamilyResolver, textStringSimpleNode.overflow, textStringSimpleNode.softWrap, textStringSimpleNode.maxLines, textStringSimpleNode.minLines);
                            paragraphLayoutCache.setDensity$foundation(textStringSimpleNode.getLayoutCache().density);
                            textSubstitutionValue3.layoutCache = paragraphLayoutCache;
                            textStringSimpleNode.textSubstitution = textSubstitutionValue3;
                        } else if (!Intrinsics.areEqual(str, textSubstitutionValue2.substitution)) {
                            textSubstitutionValue2.substitution = str;
                            ParagraphLayoutCache paragraphLayoutCache2 = textSubstitutionValue2.layoutCache;
                            if (paragraphLayoutCache2 != null) {
                                TextStyle textStyle = textStringSimpleNode.style;
                                FontFamily.Resolver resolver2 = textStringSimpleNode.fontFamilyResolver;
                                int i3 = textStringSimpleNode.overflow;
                                boolean z4 = textStringSimpleNode.softWrap;
                                int i4 = textStringSimpleNode.maxLines;
                                int i5 = textStringSimpleNode.minLines;
                                paragraphLayoutCache2.text = str;
                                paragraphLayoutCache2.style = textStyle;
                                paragraphLayoutCache2.fontFamilyResolver = resolver2;
                                paragraphLayoutCache2.overflow = i3;
                                paragraphLayoutCache2.softWrap = z4;
                                paragraphLayoutCache2.maxLines = i4;
                                paragraphLayoutCache2.minLines = i5;
                                paragraphLayoutCache2.historyFlag = (paragraphLayoutCache2.historyFlag << 2) | 2;
                                paragraphLayoutCache2.markDirty();
                            }
                        }
                        HitTestResultKt.invalidateSemantics(textStringSimpleNode);
                        HitTestResultKt.invalidateMeasurement(textStringSimpleNode);
                        HitTestResultKt.invalidateDraw(textStringSimpleNode);
                        return Boolean.TRUE;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue4 = textStringSimpleNode.textSubstitution;
                        if (textSubstitutionValue4 == null) {
                            z2 = false;
                        } else {
                            textSubstitutionValue4.isShowingSubstitution = zBooleanValue;
                            HitTestResultKt.invalidateSemantics(textStringSimpleNode);
                            HitTestResultKt.invalidateMeasurement(textStringSimpleNode);
                            HitTestResultKt.invalidateDraw(textStringSimpleNode);
                        }
                        return Boolean.valueOf(z2);
                }
            }
        }));
        final byte b3 = 2;
        semanticsPropertyReceiver.set(SemanticsActions.ShowTextSubstitution, new AccessibilityAction(null, new Function1(this) { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$$ExternalSyntheticLambda0
            public final /* synthetic */ TextStringSimpleNode f$0;

            {
                this.f$0 = this;
            }

            /* JADX WARN: Code duplicated, block: B:23:0x00c1  */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Density density;
                TextLayoutResult textLayoutResult;
                byte b4 = b3;
                boolean z2 = true;
                TextStringSimpleNode textStringSimpleNode = this.f$0;
                switch (b4) {
                    case 0:
                        List list = (List) obj;
                        ParagraphLayoutCache layoutCache = textStringSimpleNode.getLayoutCache();
                        TextStyle textStyleM751mergedA7vx0o$default = TextStyle.m751mergedA7vx0o$default(textStringSimpleNode.style, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified), 0L, null, null, null, 0L, 0, 0L, 16777214);
                        LayoutDirection layoutDirection = layoutCache.intrinsicsLayoutDirection;
                        TextLayoutResult textLayoutResult2 = null;
                        if (layoutDirection == null || (density = layoutCache.density) == null) {
                            textLayoutResult = null;
                        } else {
                            AnnotatedString annotatedString3 = new AnnotatedString(layoutCache.text);
                            if (layoutCache.paragraph == null || layoutCache.paragraphIntrinsics == null) {
                                textLayoutResult = null;
                            } else {
                                long j = layoutCache.prevConstraints & (-8589934589L);
                                int i = layoutCache.maxLines;
                                boolean z3 = layoutCache.softWrap;
                                int i2 = layoutCache.overflow;
                                FontFamily.Resolver resolver = layoutCache.fontFamilyResolver;
                                EmptyList emptyList = EmptyList.INSTANCE;
                                textLayoutResult = new TextLayoutResult(new TextLayoutInput(annotatedString3, textStyleM751mergedA7vx0o$default, emptyList, i, z3, i2, density, layoutDirection, resolver, j), new MultiParagraph(new ImageLoader$Builder(annotatedString3, textStyleM751mergedA7vx0o$default, resolver, density, emptyList, z3), j, layoutCache.maxLines, layoutCache.overflow), layoutCache.layoutSize);
                            }
                        }
                        if (textLayoutResult != null) {
                            list.add(textLayoutResult);
                            textLayoutResult2 = textLayoutResult;
                        }
                        return Boolean.valueOf(textLayoutResult2 != null);
                    case 1:
                        String str = ((AnnotatedString) obj).text;
                        TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue2 = textStringSimpleNode.textSubstitution;
                        if (textSubstitutionValue2 == null) {
                            TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue3 = new TextStringSimpleNode.TextSubstitutionValue(textStringSimpleNode.text, str);
                            ParagraphLayoutCache paragraphLayoutCache = new ParagraphLayoutCache(str, textStringSimpleNode.style, textStringSimpleNode.fontFamilyResolver, textStringSimpleNode.overflow, textStringSimpleNode.softWrap, textStringSimpleNode.maxLines, textStringSimpleNode.minLines);
                            paragraphLayoutCache.setDensity$foundation(textStringSimpleNode.getLayoutCache().density);
                            textSubstitutionValue3.layoutCache = paragraphLayoutCache;
                            textStringSimpleNode.textSubstitution = textSubstitutionValue3;
                        } else if (!Intrinsics.areEqual(str, textSubstitutionValue2.substitution)) {
                            textSubstitutionValue2.substitution = str;
                            ParagraphLayoutCache paragraphLayoutCache2 = textSubstitutionValue2.layoutCache;
                            if (paragraphLayoutCache2 != null) {
                                TextStyle textStyle = textStringSimpleNode.style;
                                FontFamily.Resolver resolver2 = textStringSimpleNode.fontFamilyResolver;
                                int i3 = textStringSimpleNode.overflow;
                                boolean z4 = textStringSimpleNode.softWrap;
                                int i4 = textStringSimpleNode.maxLines;
                                int i5 = textStringSimpleNode.minLines;
                                paragraphLayoutCache2.text = str;
                                paragraphLayoutCache2.style = textStyle;
                                paragraphLayoutCache2.fontFamilyResolver = resolver2;
                                paragraphLayoutCache2.overflow = i3;
                                paragraphLayoutCache2.softWrap = z4;
                                paragraphLayoutCache2.maxLines = i4;
                                paragraphLayoutCache2.minLines = i5;
                                paragraphLayoutCache2.historyFlag = (paragraphLayoutCache2.historyFlag << 2) | 2;
                                paragraphLayoutCache2.markDirty();
                            }
                        }
                        HitTestResultKt.invalidateSemantics(textStringSimpleNode);
                        HitTestResultKt.invalidateMeasurement(textStringSimpleNode);
                        HitTestResultKt.invalidateDraw(textStringSimpleNode);
                        return Boolean.TRUE;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        TextStringSimpleNode.TextSubstitutionValue textSubstitutionValue4 = textStringSimpleNode.textSubstitution;
                        if (textSubstitutionValue4 == null) {
                            z2 = false;
                        } else {
                            textSubstitutionValue4.isShowingSubstitution = zBooleanValue;
                            HitTestResultKt.invalidateSemantics(textStringSimpleNode);
                            HitTestResultKt.invalidateMeasurement(textStringSimpleNode);
                            HitTestResultKt.invalidateDraw(textStringSimpleNode);
                        }
                        return Boolean.valueOf(z2);
                }
            }
        }));
        semanticsPropertyReceiver.set(SemanticsActions.ClearTextSubstitution, new AccessibilityAction(null, new SliderState$$ExternalSyntheticLambda0((byte) 24, this)));
        semanticsPropertyReceiver.set(SemanticsActions.GetTextLayoutResult, new AccessibilityAction(null, r0));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0016  */
    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        ParagraphLayoutCache layoutCache;
        if (this.isAttached) {
            TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
            if (textSubstitutionValue == null) {
                layoutCache = getLayoutCache();
            } else {
                if (!textSubstitutionValue.isShowingSubstitution) {
                    textSubstitutionValue = null;
                }
                if (textSubstitutionValue == null || (layoutCache = textSubstitutionValue.layoutCache) == null) {
                    layoutCache = getLayoutCache();
                }
            }
            AndroidParagraph androidParagraph = layoutCache.paragraph;
            if (androidParagraph == null) {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Internal Error: ParagraphLayoutCache could not provide a Paragraph during the draw phase. Please report this bug on the official Issue Tracker with the following diagnostic information: (layoutCache=" + this._layoutCache + ", textSubstitution=" + this.textSubstitution + ")");
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return;
            }
            Canvas canvas = layoutNodeDrawScope.canvasDrawScope.drawContext.getCanvas();
            boolean z = layoutCache.didOverflow;
            if (z) {
                long j = layoutCache.layoutSize;
                canvas.save();
                canvas.mo453clipRectN_I0leg(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (int) (j >> 32), (int) (j & 4294967295L), 1);
            }
            try {
                TextStyle textStyle = this.style;
                SpanStyle spanStyle = textStyle.spanStyle;
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
                    androidParagraph.m726painthn5TExg(canvas, brush, textStyle.spanStyle.textForegroundStyle.getAlpha(), shadow2, textDecoration2, drawStyle2);
                } else {
                    long jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    if (jColor == 16) {
                        jColor = textStyle.m752getColor0d7_KjU() != 16 ? textStyle.m752getColor0d7_KjU() : -72057594037927936L;
                    }
                    androidParagraph.m725paintLG529CI(canvas, jColor, shadow2, textDecoration2, drawStyle2);
                }
            } finally {
                if (z) {
                    canvas.restore();
                }
            }
        }
    }

    public final ParagraphLayoutCache getLayoutCache() {
        TextStyle textStyle = this.style;
        ParagraphLayoutCache paragraphLayoutCache = this._layoutCache;
        if (paragraphLayoutCache == null) {
            paragraphLayoutCache = new ParagraphLayoutCache(this.text, textStyle, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines);
            this._layoutCache = paragraphLayoutCache;
        }
        paragraphLayoutCache.getClass();
        return paragraphLayoutCache;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0010  */
    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        ParagraphLayoutCache layoutCache;
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue == null) {
            layoutCache = getLayoutCache();
        } else {
            if (!textSubstitutionValue.isShowingSubstitution) {
                textSubstitutionValue = null;
            }
            if (textSubstitutionValue == null || (layoutCache = textSubstitutionValue.layoutCache) == null) {
                layoutCache = getLayoutCache();
            }
        }
        layoutCache.setDensity$foundation(lookaheadCapablePlaceable);
        return layoutCache.intrinsicHeight(i, lookaheadCapablePlaceable.getLayoutDirection());
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0010  */
    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        ParagraphLayoutCache layoutCache;
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue == null) {
            layoutCache = getLayoutCache();
        } else {
            if (!textSubstitutionValue.isShowingSubstitution) {
                textSubstitutionValue = null;
            }
            if (textSubstitutionValue == null || (layoutCache = textSubstitutionValue.layoutCache) == null) {
                layoutCache = getLayoutCache();
            }
        }
        layoutCache.setDensity$foundation(lookaheadCapablePlaceable);
        return BasicTextKt.ceilToIntPx(layoutCache.setLayoutDirection(lookaheadCapablePlaceable.getLayoutDirection()).getMaxIntrinsicWidth());
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0015 A[Catch: all -> 0x0098, TryCatch #0 {all -> 0x0098, blocks: (B:3:0x0005, B:5:0x0009, B:10:0x0011, B:13:0x0019, B:15:0x0028, B:16:0x002b, B:18:0x0034, B:20:0x0040, B:21:0x0047, B:22:0x0070, B:12:0x0015), top: B:28:0x0005 }] */
    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        ParagraphLayoutCache layoutCache;
        Trace.beginSection("TextStringSimpleNode::measure");
        try {
            TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
            if (textSubstitutionValue == null) {
                layoutCache = getLayoutCache();
            } else {
                if (!textSubstitutionValue.isShowingSubstitution) {
                    textSubstitutionValue = null;
                }
                if (textSubstitutionValue == null || (layoutCache = textSubstitutionValue.layoutCache) == null) {
                    layoutCache = getLayoutCache();
                }
            }
            layoutCache.setDensity$foundation(measureScope);
            boolean zM225layoutWithConstraintsK40F9xA = layoutCache.m225layoutWithConstraintsK40F9xA(j, measureScope.getLayoutDirection());
            ParagraphIntrinsics paragraphIntrinsics = layoutCache.paragraphIntrinsics;
            if (paragraphIntrinsics != null) {
                paragraphIntrinsics.getHasStaleResolvedFonts();
            }
            AndroidParagraph androidParagraph = layoutCache.paragraph;
            androidParagraph.getClass();
            long j2 = layoutCache.layoutSize;
            if (zM225layoutWithConstraintsK40F9xA) {
                HitTestResultKt.m646requireCoordinator64DMado(this, 2).invalidateLayer();
                HashMap map = this.baselineCache;
                if (map == null) {
                    map = new HashMap(2);
                    this.baselineCache = map;
                }
                map.put(AlignmentLineKt.FirstBaseline, Integer.valueOf(Math.round(androidParagraph.getLineBaseline(0))));
                map.put(AlignmentLineKt.LastBaseline, Integer.valueOf(Math.round(androidParagraph.getLineBaseline(androidParagraph.layout.lineCount - 1))));
            }
            int i = (int) (j2 >> 32);
            int i2 = (int) (j2 & 4294967295L);
            Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(FileSystemsKt.m880fitPrioritizingWidthZbe2FdA(i, i, i2, i2));
            HashMap map2 = this.baselineCache;
            map2.getClass();
            return measureScope.layout(i, i2, map2, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 15));
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0010  */
    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        ParagraphLayoutCache layoutCache;
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue == null) {
            layoutCache = getLayoutCache();
        } else {
            if (!textSubstitutionValue.isShowingSubstitution) {
                textSubstitutionValue = null;
            }
            if (textSubstitutionValue == null || (layoutCache = textSubstitutionValue.layoutCache) == null) {
                layoutCache = getLayoutCache();
            }
        }
        layoutCache.setDensity$foundation(lookaheadCapablePlaceable);
        return layoutCache.intrinsicHeight(i, lookaheadCapablePlaceable.getLayoutDirection());
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0010  */
    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        ParagraphLayoutCache layoutCache;
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue == null) {
            layoutCache = getLayoutCache();
        } else {
            if (!textSubstitutionValue.isShowingSubstitution) {
                textSubstitutionValue = null;
            }
            if (textSubstitutionValue == null || (layoutCache = textSubstitutionValue.layoutCache) == null) {
                layoutCache = getLayoutCache();
            }
        }
        layoutCache.setDensity$foundation(lookaheadCapablePlaceable);
        return BasicTextKt.ceilToIntPx(layoutCache.setLayoutDirection(lookaheadCapablePlaceable.getLayoutDirection()).getMinIntrinsicWidth());
    }
}
