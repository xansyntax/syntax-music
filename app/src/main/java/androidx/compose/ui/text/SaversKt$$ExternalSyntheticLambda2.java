package androidx.compose.ui.text;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InvertMatrixKt;
import androidx.compose.ui.scrollcapture.ScrollCaptureCandidate;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.core.provider.CallbackWrapper;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SaversKt$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ SaversKt$$ExternalSyntheticLambda2(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Color color;
        spanStyle = null;
        SpanStyle spanStyle = null;
        shadow = null;
        Shadow shadow = null;
        int i = 0;
        switch (this.$r8$classId) {
            case 0:
                String str = obj != null ? (String) obj : null;
                str.getClass();
                return new UrlAnnotation(str);
            case 1:
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = (PersistentCompositionLocalHashMap) obj;
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = CompositionLocalsKt.LocalOwner;
                persistentCompositionLocalHashMap.getClass();
                return ((AndroidComposeView) ((Owner) Stack.read(persistentCompositionLocalHashMap, staticProvidableCompositionLocal))).getUriHandler();
            case 2:
                return Boolean.valueOf(InvertMatrixKt.canBeSavedToBundle(obj));
            case 3:
                ((Long) obj).getClass();
                return Unit.INSTANCE;
            case 4:
                return Integer.valueOf(((ScrollCaptureCandidate) obj).depth);
            case 5:
                return Integer.valueOf(((ScrollCaptureCandidate) obj).viewportBoundsInWindow.getHeight());
            case 6:
                return Boolean.valueOf(!(((AnnotatedString.Annotation) obj) instanceof ParagraphStyle));
            case 7:
                ParagraphInfo paragraphInfo = (ParagraphInfo) obj;
                return IntIntPair$$ExternalSyntheticOutline0.m(paragraphInfo.startIndex, "[", ", ", paragraphInfo.endIndex, ")");
            case 8:
                obj.getClass();
                List list = (List) obj;
                Object obj2 = list.get(0);
                Boolean bool = Boolean.FALSE;
                Intrinsics.areEqual(obj2, bool);
                SaversKt$ColorSaver$2 saversKt$ColorSaver$2 = SaversKt$ColorSaver$2.INSTANCE;
                Color color2 = obj2 != null ? (Color) saversKt$ColorSaver$2.invoke(obj2) : null;
                color2.getClass();
                long j = color2.value;
                Object obj3 = list.get(1);
                Function1 function1 = SaversKt.TextUnitSaver.$restore;
                Intrinsics.areEqual(obj3, bool);
                TextUnit textUnit = obj3 != null ? (TextUnit) function1.invoke(obj3) : null;
                textUnit.getClass();
                long j2 = textUnit.packedValue;
                Object obj4 = list.get(2);
                FontWeight fontWeight = FontWeight.W400;
                FontWeight fontWeight2 = (Intrinsics.areEqual(obj4, bool) || obj4 == null) ? null : (FontWeight) ((Function1) SaversKt.FontWeightSaver.mExecutor).invoke(obj4);
                Object obj5 = list.get(3);
                FontStyle fontStyle = (Intrinsics.areEqual(obj5, bool) || obj5 == null) ? null : (FontStyle) ((Function1) SaversKt.FontStyleSaver.mExecutor).invoke(obj5);
                Object obj6 = list.get(4);
                FontSynthesis fontSynthesis = (Intrinsics.areEqual(obj6, bool) || obj6 == null) ? null : (FontSynthesis) ((Function1) SaversKt.FontSynthesisSaver.mExecutor).invoke(obj6);
                Object obj7 = list.get(6);
                String str2 = obj7 != null ? (String) obj7 : null;
                Object obj8 = list.get(7);
                Intrinsics.areEqual(obj8, bool);
                TextUnit textUnit2 = obj8 != null ? (TextUnit) function1.invoke(obj8) : null;
                textUnit2.getClass();
                long j3 = textUnit2.packedValue;
                Object obj9 = list.get(8);
                BaselineShift baselineShift = (Intrinsics.areEqual(obj9, bool) || obj9 == null) ? null : (BaselineShift) ((Function1) SaversKt.BaselineShiftSaver.mExecutor).invoke(obj9);
                Object obj10 = list.get(9);
                TextGeometricTransform textGeometricTransform = (Intrinsics.areEqual(obj10, bool) || obj10 == null) ? null : (TextGeometricTransform) ((Function1) SaversKt.TextGeometricTransformSaver.mExecutor).invoke(obj10);
                Object obj11 = list.get(10);
                LocaleList localeList = LocaleList.Empty;
                LocaleList localeList2 = (Intrinsics.areEqual(obj11, bool) || obj11 == null) ? null : (LocaleList) ((Function1) SaversKt.LocaleListSaver.mExecutor).invoke(obj11);
                Object obj12 = list.get(11);
                Intrinsics.areEqual(obj12, bool);
                Color color3 = obj12 != null ? (Color) saversKt$ColorSaver$2.invoke(obj12) : null;
                color3.getClass();
                long j4 = color3.value;
                Object obj13 = list.get(12);
                TextDecoration textDecoration = (Intrinsics.areEqual(obj13, bool) || obj13 == null) ? null : (TextDecoration) ((Function1) SaversKt.TextDecorationSaver.mExecutor).invoke(obj13);
                Object obj14 = list.get(13);
                CallbackWrapper callbackWrapper = SaversKt.ShadowSaver;
                if (!Intrinsics.areEqual(obj14, bool) && obj14 != null) {
                    shadow = (Shadow) ((Function1) callbackWrapper.mExecutor).invoke(obj14);
                }
                return new SpanStyle(j, j2, fontWeight2, fontStyle, fontSynthesis, (FontFamily) null, str2, j3, baselineShift, textGeometricTransform, localeList2, j4, textDecoration, shadow, 49184);
            case 9:
                obj.getClass();
                List list2 = (List) obj;
                Object obj15 = list2.get(1);
                List list3 = (Intrinsics.areEqual(obj15, Boolean.FALSE) || obj15 == null) ? null : (List) ((Function1) SaversKt.AnnotationRangeListSaver.mExecutor).invoke(obj15);
                Object obj16 = list2.get(0);
                String str3 = obj16 != null ? (String) obj16 : null;
                str3.getClass();
                return new AnnotatedString(list3, str3);
            case 10:
                obj.getClass();
                List list4 = (List) obj;
                Object obj17 = list4.get(0);
                Function1 function2 = (Function1) SaversKt.SpanStyleSaver.mExecutor;
                Boolean bool2 = Boolean.FALSE;
                SpanStyle spanStyle2 = (Intrinsics.areEqual(obj17, bool2) || obj17 == null) ? null : (SpanStyle) function2.invoke(obj17);
                Object obj18 = list4.get(1);
                SpanStyle spanStyle3 = (Intrinsics.areEqual(obj18, bool2) || obj18 == null) ? null : (SpanStyle) function2.invoke(obj18);
                Object obj19 = list4.get(2);
                SpanStyle spanStyle4 = (Intrinsics.areEqual(obj19, bool2) || obj19 == null) ? null : (SpanStyle) function2.invoke(obj19);
                Object obj20 = list4.get(3);
                if (!Intrinsics.areEqual(obj20, bool2) && obj20 != null) {
                    spanStyle = (SpanStyle) function2.invoke(obj20);
                }
                return new TextLinkStyles(spanStyle2, spanStyle3, spanStyle4, spanStyle);
            case 11:
                obj.getClass();
                return new TextDecoration(((Integer) obj).intValue());
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                obj.getClass();
                List list5 = (List) obj;
                return new TextGeometricTransform(((Number) list5.get(0)).floatValue(), ((Number) list5.get(1)).floatValue());
            case 13:
                obj.getClass();
                List list6 = (List) obj;
                Object obj21 = list6.get(0);
                Function1 function3 = SaversKt.TextUnitSaver.$restore;
                Boolean bool3 = Boolean.FALSE;
                Intrinsics.areEqual(obj21, bool3);
                TextUnit textUnit3 = obj21 != null ? (TextUnit) function3.invoke(obj21) : null;
                textUnit3.getClass();
                long j5 = textUnit3.packedValue;
                Object obj22 = list6.get(1);
                Intrinsics.areEqual(obj22, bool3);
                TextUnit textUnit4 = obj22 != null ? (TextUnit) function3.invoke(obj22) : null;
                textUnit4.getClass();
                return new TextIndent(j5, textUnit4.packedValue);
            case 14:
                obj.getClass();
                return new FontWeight(((Integer) obj).intValue());
            case 15:
                obj.getClass();
                return new BaselineShift(((Float) obj).floatValue());
            case 16:
                obj.getClass();
                List list7 = (List) obj;
                Object obj23 = list7.get(0);
                Integer num = obj23 != null ? (Integer) obj23 : null;
                num.getClass();
                int iIntValue = num.intValue();
                Object obj24 = list7.get(1);
                Integer num2 = obj24 != null ? (Integer) obj24 : null;
                num2.getClass();
                return new TextRange(TextRangeKt.TextRange(iIntValue, num2.intValue()));
            case 17:
                obj.getClass();
                List list8 = (List) obj;
                Object obj25 = list8.get(0);
                Boolean bool4 = Boolean.FALSE;
                Intrinsics.areEqual(obj25, bool4);
                if (obj25 != null) {
                    color = Intrinsics.areEqual(obj25, Boolean.FALSE) ? new Color(ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified)) : new Color(((long) ((Integer) obj25).intValue()) << 32);
                } else {
                    color = null;
                }
                color.getClass();
                long j6 = color.value;
                Object obj26 = list8.get(1);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$1 = SaversKt.OffsetSaver;
                Intrinsics.areEqual(obj26, bool4);
                Offset offset = obj26 != null ? (Offset) saversKt$NonNullValueClassSaver$1.$restore.invoke(obj26) : null;
                offset.getClass();
                long j7 = offset.packedValue;
                Object obj27 = list8.get(2);
                Float f = obj27 != null ? (Float) obj27 : null;
                f.getClass();
                return new Shadow(j6, j7, f.floatValue());
            case 18:
                obj.getClass();
                return new TextAlign(((Integer) obj).intValue());
            case 19:
                obj.getClass();
                return new TextDirection(((Integer) obj).intValue());
            case 20:
                obj.getClass();
                List list9 = (List) obj;
                ArrayList arrayList = new ArrayList(list9.size());
                int size = list9.size();
                while (i < size) {
                    Object obj28 = list9.get(i);
                    AnnotatedString.Range range = (Intrinsics.areEqual(obj28, Boolean.FALSE) || obj28 == null) ? null : (AnnotatedString.Range) ((Function1) SaversKt.AnnotationRangeSaver.mExecutor).invoke(obj28);
                    range.getClass();
                    arrayList.add(range);
                    i++;
                }
                return arrayList;
            case 21:
                obj.getClass();
                return new Hyphens(((Integer) obj).intValue());
            case 22:
                obj.getClass();
                return new FontStyle(((Integer) obj).intValue());
            case 23:
                obj.getClass();
                return new FontSynthesis(((Integer) obj).intValue());
            case 24:
                Boolean bool5 = Boolean.FALSE;
                if (Intrinsics.areEqual(obj, bool5)) {
                    return new TextUnit(IntMath.pack(0L, Float.NaN));
                }
                obj.getClass();
                List list10 = (List) obj;
                Object obj29 = list10.get(0);
                Float f2 = obj29 != null ? (Float) obj29 : null;
                f2.getClass();
                float fFloatValue = f2.floatValue();
                Object obj30 = list10.get(1);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$2 = SaversKt.TextUnitTypeSaver;
                Intrinsics.areEqual(obj30, bool5);
                TextUnitType textUnitType = obj30 != null ? (TextUnitType) saversKt$NonNullValueClassSaver$2.$restore.invoke(obj30) : null;
                textUnitType.getClass();
                return new TextUnit(IntMath.pack(textUnitType.type, fFloatValue));
            case 25:
                if (Intrinsics.areEqual(obj, (Object) 0)) {
                    return new TextUnitType(8589934592L);
                }
                return Intrinsics.areEqual(obj, (Object) 1) ? new TextUnitType(4294967296L) : new TextUnitType(0L);
            case 26:
                if (Intrinsics.areEqual(obj, Boolean.FALSE)) {
                    return new Offset(9205357640488583168L);
                }
                obj.getClass();
                List list11 = (List) obj;
                Object obj31 = list11.get(0);
                Float f3 = obj31 != null ? (Float) obj31 : null;
                f3.getClass();
                float fFloatValue2 = f3.floatValue();
                Object obj32 = list11.get(1);
                Float f4 = obj32 != null ? (Float) obj32 : null;
                f4.getClass();
                return new Offset((((long) Float.floatToRawIntBits(fFloatValue2)) << 32) | (((long) Float.floatToRawIntBits(f4.floatValue())) & 4294967295L));
            case 27:
                obj.getClass();
                List list12 = (List) obj;
                ArrayList arrayList2 = new ArrayList(list12.size());
                int size2 = list12.size();
                while (i < size2) {
                    Object obj33 = list12.get(i);
                    Locale locale = (Intrinsics.areEqual(obj33, Boolean.FALSE) || obj33 == null) ? null : (Locale) ((Function1) SaversKt.LocaleSaver.mExecutor).invoke(obj33);
                    locale.getClass();
                    arrayList2.add(locale);
                    i++;
                }
                return new LocaleList(arrayList2);
            case 28:
                obj.getClass();
                List list13 = (List) obj;
                Object obj34 = list13.get(0);
                String str4 = obj34 != null ? (String) obj34 : null;
                str4.getClass();
                Object obj35 = list13.get(1);
                return new LinkAnnotation.Url(str4, (Intrinsics.areEqual(obj35, Boolean.FALSE) || obj35 == null) ? null : (TextLinkStyles) ((Function1) SaversKt.TextLinkStylesSaver.mExecutor).invoke(obj35), null);
            default:
                obj.getClass();
                String str5 = (String) obj;
                java.util.Locale localeForLanguageTag = java.util.Locale.forLanguageTag(str5);
                if (Intrinsics.areEqual(localeForLanguageTag.toLanguageTag(), "und")) {
                    System.err.println("The language tag " + str5 + " is not well-formed. Locale is resolved to Undetermined. Note that underscore '_' is not a valid subtag delimiter and must be replaced with '-'.");
                }
                return new Locale(localeForLanguageTag);
        }
    }
}
