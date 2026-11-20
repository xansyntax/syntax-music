package androidx.compose.ui.text;

import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.DensityWithConverter;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.compose.ui.window.PopupLayout;
import androidx.compose.ui.window.PopupLayout$$ExternalSyntheticLambda5;
import androidx.core.provider.CallbackWrapper;
import androidx.datastore.core.SingleProcessCoordinator;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.File;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SaversKt$$ExternalSyntheticLambda6 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ SaversKt$$ExternalSyntheticLambda6(DensityWithConverter densityWithConverter) {
        this.$r8$classId = (byte) 14;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        emojiSupportMatch = null;
        EmojiSupportMatch emojiSupportMatch = null;
        textMotion = null;
        TextMotion textMotion = null;
        annotation = null;
        AnnotatedString.Annotation annotation = null;
        annotation = null;
        AnnotatedString.Annotation annotation2 = null;
        annotation = null;
        AnnotatedString.Annotation annotation3 = null;
        annotation = null;
        AnnotatedString.Annotation annotation4 = null;
        annotation = null;
        AnnotatedString.Annotation annotation5 = null;
        annotation = null;
        AnnotatedString.Annotation annotation6 = null;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                obj.getClass();
                List list = (List) obj;
                Object obj2 = list.get(0);
                String str = obj2 != null ? (String) obj2 : null;
                str.getClass();
                Object obj3 = list.get(1);
                return new LinkAnnotation.Clickable(str, (Intrinsics.areEqual(obj3, Boolean.FALSE) || obj3 == null) ? null : (TextLinkStyles) ((Function1) SaversKt.TextLinkStylesSaver.mExecutor).invoke(obj3), null);
            case 1:
                obj.getClass();
                List list2 = (List) obj;
                Object obj4 = list2.get(0);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$1 = SaversKt.LineHeightStyleAlignmentSaver;
                Boolean bool = Boolean.FALSE;
                Intrinsics.areEqual(obj4, bool);
                LineHeightStyle.Alignment alignment = obj4 != null ? (LineHeightStyle.Alignment) saversKt$NonNullValueClassSaver$1.$restore.invoke(obj4) : null;
                alignment.getClass();
                float f = alignment.topRatio;
                Object obj5 = list2.get(1);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$2 = SaversKt.LineHeightStyleTrimSaver;
                Intrinsics.areEqual(obj5, bool);
                LineHeightStyle.Trim trim = obj5 != null ? (LineHeightStyle.Trim) saversKt$NonNullValueClassSaver$2.$restore.invoke(obj5) : null;
                trim.getClass();
                int i = trim.value;
                Object obj6 = list2.get(2);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$3 = SaversKt.LineHeightStyleModeSaver;
                Intrinsics.areEqual(obj6, bool);
                LineHeightStyle.Mode mode = obj6 != null ? (LineHeightStyle.Mode) saversKt$NonNullValueClassSaver$3.$restore.invoke(obj6) : null;
                mode.getClass();
                return new LineHeightStyle(f, i, mode.value);
            case 2:
                obj.getClass();
                float fFloatValue = ((Float) obj).floatValue();
                LineHeightStyle.Alignment.m771constructorimpl(fFloatValue);
                return new LineHeightStyle.Alignment(fFloatValue);
            case 3:
                obj.getClass();
                List list3 = (List) obj;
                Object obj7 = list3.get(0);
                AnnotatedString.Annotation annotation7 = (Intrinsics.areEqual(obj7, Boolean.FALSE) || obj7 == null) ? null : (AnnotatedString.Annotation) ((Function1) SaversKt.AnnotationSaver.mExecutor).invoke(obj7);
                annotation7.getClass();
                Object obj8 = list3.get(1);
                Integer num = obj8 != null ? (Integer) obj8 : null;
                num.getClass();
                int iIntValue = num.intValue();
                Object obj9 = list3.get(2);
                Integer num2 = obj9 != null ? (Integer) obj9 : null;
                num2.getClass();
                int iIntValue2 = num2.intValue();
                Object obj10 = list3.get(3);
                String str2 = obj10 != null ? (String) obj10 : null;
                str2.getClass();
                return new AnnotatedString.Range(annotation7, iIntValue, iIntValue2, str2);
            case 4:
                obj.getClass();
                return new LineHeightStyle.Trim(((Integer) obj).intValue());
            case 5:
                obj.getClass();
                return new LineHeightStyle.Mode(((Integer) obj).intValue());
            case 6:
                obj.getClass();
                List list4 = (List) obj;
                Object obj11 = list4.get(0);
                AnnotationType annotationType = obj11 != null ? (AnnotationType) obj11 : null;
                annotationType.getClass();
                switch (annotationType.ordinal()) {
                    case 0:
                        Object obj12 = list4.get(1);
                        CallbackWrapper callbackWrapper = SaversKt.ParagraphStyleSaver;
                        if (!Intrinsics.areEqual(obj12, Boolean.FALSE) && obj12 != null) {
                            annotation6 = (AnnotatedString.Annotation) ((Function1) callbackWrapper.mExecutor).invoke(obj12);
                        }
                        annotation6.getClass();
                        return annotation6;
                    case 1:
                        Object obj13 = list4.get(1);
                        CallbackWrapper callbackWrapper2 = SaversKt.SpanStyleSaver;
                        if (!Intrinsics.areEqual(obj13, Boolean.FALSE) && obj13 != null) {
                            annotation5 = (AnnotatedString.Annotation) ((Function1) callbackWrapper2.mExecutor).invoke(obj13);
                        }
                        annotation5.getClass();
                        return annotation5;
                    case 2:
                        Object obj14 = list4.get(1);
                        CallbackWrapper callbackWrapper3 = SaversKt.VerbatimTtsAnnotationSaver;
                        if (!Intrinsics.areEqual(obj14, Boolean.FALSE) && obj14 != null) {
                            annotation4 = (AnnotatedString.Annotation) ((Function1) callbackWrapper3.mExecutor).invoke(obj14);
                        }
                        annotation4.getClass();
                        return annotation4;
                    case 3:
                        Object obj15 = list4.get(1);
                        CallbackWrapper callbackWrapper4 = SaversKt.UrlAnnotationSaver;
                        if (!Intrinsics.areEqual(obj15, Boolean.FALSE) && obj15 != null) {
                            annotation3 = (AnnotatedString.Annotation) ((Function1) callbackWrapper4.mExecutor).invoke(obj15);
                        }
                        annotation3.getClass();
                        return annotation3;
                    case 4:
                        Object obj16 = list4.get(1);
                        CallbackWrapper callbackWrapper5 = SaversKt.LinkSaver;
                        if (!Intrinsics.areEqual(obj16, Boolean.FALSE) && obj16 != null) {
                            annotation2 = (AnnotatedString.Annotation) ((Function1) callbackWrapper5.mExecutor).invoke(obj16);
                        }
                        annotation2.getClass();
                        return annotation2;
                    case 5:
                        Object obj17 = list4.get(1);
                        CallbackWrapper callbackWrapper6 = SaversKt.ClickableSaver;
                        if (!Intrinsics.areEqual(obj17, Boolean.FALSE) && obj17 != null) {
                            annotation = (AnnotatedString.Annotation) ((Function1) callbackWrapper6.mExecutor).invoke(obj17);
                        }
                        annotation.getClass();
                        return annotation;
                    case 6:
                        Object obj18 = list4.get(1);
                        String str3 = obj18 != null ? (String) obj18 : null;
                        str3.getClass();
                        return new StringAnnotation(str3);
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                }
            case 7:
                String str4 = obj != null ? (String) obj : null;
                str4.getClass();
                return new VerbatimTtsAnnotation(str4);
            case 8:
                obj.getClass();
                List list5 = (List) obj;
                Object obj19 = list5.get(0);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$4 = SaversKt.TextAlignSaver;
                Boolean bool2 = Boolean.FALSE;
                Intrinsics.areEqual(obj19, bool2);
                TextAlign textAlign = obj19 != null ? (TextAlign) saversKt$NonNullValueClassSaver$4.$restore.invoke(obj19) : null;
                textAlign.getClass();
                int i2 = textAlign.value;
                Object obj20 = list5.get(1);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$5 = SaversKt.TextDirectionSaver;
                Intrinsics.areEqual(obj20, bool2);
                TextDirection textDirection = obj20 != null ? (TextDirection) saversKt$NonNullValueClassSaver$5.$restore.invoke(obj20) : null;
                textDirection.getClass();
                int i3 = textDirection.value;
                Object obj21 = list5.get(2);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$6 = SaversKt.TextUnitSaver;
                Intrinsics.areEqual(obj21, bool2);
                TextUnit textUnit = obj21 != null ? (TextUnit) saversKt$NonNullValueClassSaver$6.$restore.invoke(obj21) : null;
                textUnit.getClass();
                long j = textUnit.packedValue;
                Object obj22 = list5.get(3);
                TextIndent textIndent = TextIndent.None;
                TextIndent textIndent2 = (Intrinsics.areEqual(obj22, bool2) || obj22 == null) ? null : (TextIndent) ((Function1) SaversKt.TextIndentSaver.mExecutor).invoke(obj22);
                Object obj23 = list5.get(4);
                PlatformParagraphStyle platformParagraphStyle = (Intrinsics.areEqual(obj23, bool2) || obj23 == null) ? null : (PlatformParagraphStyle) ((Function1) TextRangeKt.PlatformParagraphStyleSaver.mExecutor).invoke(obj23);
                Object obj24 = list5.get(5);
                LineHeightStyle lineHeightStyle = LineHeightStyle.Default;
                LineHeightStyle lineHeightStyle2 = (Intrinsics.areEqual(obj24, bool2) || obj24 == null) ? null : (LineHeightStyle) ((Function1) SaversKt.LineHeightStyleSaver.mExecutor).invoke(obj24);
                Object obj25 = list5.get(6);
                LineBreak lineBreak = (Intrinsics.areEqual(obj25, bool2) || obj25 == null) ? null : (LineBreak) ((Function1) TextRangeKt.LineBreakSaver.mExecutor).invoke(obj25);
                lineBreak.getClass();
                int i4 = lineBreak.mask;
                Object obj26 = list5.get(7);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$7 = SaversKt.HyphensSaver;
                Intrinsics.areEqual(obj26, bool2);
                Hyphens hyphens = obj26 != null ? (Hyphens) saversKt$NonNullValueClassSaver$7.$restore.invoke(obj26) : null;
                hyphens.getClass();
                int i5 = hyphens.value;
                Object obj27 = list5.get(8);
                boolean zAreEqual = Intrinsics.areEqual(obj27, bool2);
                CallbackWrapper callbackWrapper7 = TextRangeKt.TextMotionSaver;
                if (!zAreEqual && obj27 != null) {
                    textMotion = (TextMotion) ((Function1) callbackWrapper7.mExecutor).invoke(obj27);
                }
                return new ParagraphStyle(i2, i3, j, textIndent2, platformParagraphStyle, lineHeightStyle2, i4, i5, textMotion);
            case 9:
                obj.getClass();
                List list6 = (List) obj;
                Object obj28 = list6.get(0);
                Boolean bool3 = obj28 != null ? (Boolean) obj28 : null;
                bool3.getClass();
                boolean zBooleanValue = bool3.booleanValue();
                Object obj29 = list6.get(1);
                boolean zAreEqual2 = Intrinsics.areEqual(obj29, Boolean.FALSE);
                CallbackWrapper callbackWrapper8 = TextRangeKt.emojiSupportMatchSaver;
                if (!zAreEqual2 && obj29 != null) {
                    emojiSupportMatch = (EmojiSupportMatch) ((Function1) callbackWrapper8.mExecutor).invoke(obj29);
                }
                emojiSupportMatch.getClass();
                return new PlatformParagraphStyle(emojiSupportMatch.value, zBooleanValue);
            case 10:
                obj.getClass();
                return new EmojiSupportMatch(((Integer) obj).intValue());
            case 11:
                obj.getClass();
                return new LineBreak(((Integer) obj).intValue());
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                obj.getClass();
                List list7 = (List) obj;
                Object obj30 = list7.get(0);
                TextMotion.Linearity linearity = (Intrinsics.areEqual(obj30, Boolean.FALSE) || obj30 == null) ? null : (TextMotion.Linearity) ((Function1) TextRangeKt.TextMotionLinearitySaver.mExecutor).invoke(obj30);
                linearity.getClass();
                int i6 = linearity.value;
                Object obj31 = list7.get(1);
                Boolean bool4 = obj31 != null ? (Boolean) obj31 : null;
                bool4.getClass();
                return new TextMotion(i6, bool4.booleanValue());
            case 13:
                obj.getClass();
                return new TextMotion.Linearity(((Integer) obj).intValue());
            case 14:
                FontVariation.SettingInt settingInt = (FontVariation.SettingInt) obj;
                return "'" + settingInt.getAxisName() + "' " + settingInt.toVariationValue();
            case 15:
                obj.getClass();
                List list8 = (List) obj;
                Object obj32 = list8.get(0);
                CallbackWrapper callbackWrapper9 = SaversKt.AnnotatedStringSaver;
                Boolean bool5 = Boolean.FALSE;
                AnnotatedString annotatedString = (Intrinsics.areEqual(obj32, bool5) || obj32 == null) ? null : (AnnotatedString) ((Function1) callbackWrapper9.mExecutor).invoke(obj32);
                annotatedString.getClass();
                Object obj33 = list8.get(1);
                int i7 = TextRange.$r8$clinit;
                TextRange textRange = (Intrinsics.areEqual(obj33, bool5) || obj33 == null) ? null : (TextRange) ((Function1) SaversKt.TextRangeSaver.mExecutor).invoke(obj33);
                textRange.getClass();
                return new TextFieldValue(annotatedString, textRange.packedValue, (TextRange) null);
            case 16:
                return unit;
            case 17:
                return unit;
            case 18:
                return unit;
            case 19:
                return unit;
            case 20:
                AndroidViewHolder androidViewHolder = (AndroidViewHolder) obj;
                androidViewHolder.getHandler().post(new PopupLayout$$ExternalSyntheticLambda5(androidViewHolder.runUpdate, (byte) 5));
                return unit;
            case 21:
                return unit;
            case 22:
                return unit;
            case 23:
                return unit;
            case 24:
                KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                ((SemanticsPropertyReceiver) obj).set(SemanticsProperties.IsDialog, unit);
                return unit;
            case 25:
                KProperty[] kPropertyArr2 = SemanticsPropertiesKt.$$delegatedProperties;
                ((SemanticsPropertyReceiver) obj).set(SemanticsProperties.IsPopup, unit);
                return unit;
            case 26:
                ((Long) obj).getClass();
                return unit;
            case 27:
                return unit;
            case 28:
                PopupLayout popupLayout = (PopupLayout) obj;
                if (popupLayout.isAttachedToWindow()) {
                    popupLayout.updatePosition();
                }
                return unit;
            default:
                File file = (File) obj;
                file.getClass();
                String absolutePath = file.getCanonicalFile().getAbsolutePath();
                absolutePath.getClass();
                return new SingleProcessCoordinator(absolutePath);
        }
    }

    public /* synthetic */ SaversKt$$ExternalSyntheticLambda6(byte b) {
        this.$r8$classId = b;
    }
}
