package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.ui.autofill.AndroidFillableData;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineHeightStyle;
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
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SaversKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ SaversKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                AnnotatedString annotatedString = (AnnotatedString) obj2;
                return CollectionsKt__IterablesKt.arrayListOf(annotatedString.text, SaversKt.save(annotatedString.annotations, SaversKt.AnnotationRangeListSaver, (SaveableHolder) obj));
            case 1:
                return (AndroidFillableData) obj;
            case 2:
                Boolean bool = (Boolean) obj;
                ((Boolean) obj2).getClass();
                return bool;
            case 3:
                if (obj == null && obj2 == null) {
                    return null;
                }
                PathKt$$ExternalSyntheticBUOutline0.m();
                return null;
            case 4:
                return obj == null ? obj2 : obj;
            case 5:
                SemanticsNode semanticsNode = (SemanticsNode) obj2;
                Object objValueOf = Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO);
                SemanticsConfiguration semanticsConfiguration = ((SemanticsNode) obj).unmergedConfig;
                SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.TraversalIndex;
                Object obj3 = semanticsConfiguration.props.get(semanticsPropertyKey);
                if (obj3 == null) {
                    obj3 = objValueOf;
                }
                float fFloatValue = ((Number) obj3).floatValue();
                Object obj4 = semanticsNode.unmergedConfig.props.get(semanticsPropertyKey);
                if (obj4 != null) {
                    objValueOf = obj4;
                }
                return Integer.valueOf(Float.compare(fFloatValue, ((Number) objValueOf).floatValue()));
            case 6:
                SaveableHolder saveableHolder = (SaveableHolder) obj;
                TextLinkStyles textLinkStyles = (TextLinkStyles) obj2;
                SpanStyle spanStyle = textLinkStyles.style;
                CallbackWrapper callbackWrapper = SaversKt.SpanStyleSaver;
                return CollectionsKt__IterablesKt.arrayListOf(SaversKt.save(spanStyle, callbackWrapper, saveableHolder), SaversKt.save(textLinkStyles.focusedStyle, callbackWrapper, saveableHolder), SaversKt.save(textLinkStyles.hoveredStyle, callbackWrapper, saveableHolder), SaversKt.save(textLinkStyles.pressedStyle, callbackWrapper, saveableHolder));
            case 7:
                return Integer.valueOf(((TextDecoration) obj2).mask);
            case 8:
                TextGeometricTransform textGeometricTransform = (TextGeometricTransform) obj2;
                return CollectionsKt__IterablesKt.arrayListOf(Float.valueOf(textGeometricTransform.scaleX), Float.valueOf(textGeometricTransform.skewX));
            case 9:
                SaveableHolder saveableHolder2 = (SaveableHolder) obj;
                TextIndent textIndent = (TextIndent) obj2;
                TextUnit textUnit = new TextUnit(textIndent.firstLine);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$1 = SaversKt.TextUnitSaver;
                return CollectionsKt__IterablesKt.arrayListOf(SaversKt.save(textUnit, saversKt$NonNullValueClassSaver$1, saveableHolder2), SaversKt.save(new TextUnit(textIndent.restLine), saversKt$NonNullValueClassSaver$1, saveableHolder2));
            case 10:
                return ((UrlAnnotation) obj2).url;
            case 11:
                return Integer.valueOf(((FontWeight) obj2).weight);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                SaveableHolder saveableHolder3 = (SaveableHolder) obj;
                List list = (List) obj2;
                ArrayList arrayList = new ArrayList(list.size());
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(SaversKt.save((AnnotatedString.Range) list.get(i), SaversKt.AnnotationRangeSaver, saveableHolder3));
                }
                return arrayList;
            case 13:
                return Float.valueOf(((BaselineShift) obj2).multiplier);
            case 14:
                TextRange textRange = (TextRange) obj2;
                return CollectionsKt__IterablesKt.arrayListOf(Integer.valueOf((int) (textRange.packedValue >> 32)), Integer.valueOf((int) (textRange.packedValue & 4294967295L)));
            case 15:
                SaveableHolder saveableHolder4 = (SaveableHolder) obj;
                Shadow shadow = (Shadow) obj2;
                return CollectionsKt__IterablesKt.arrayListOf(SaversKt.save(new Color(shadow.color), SaversKt.ColorSaver, saveableHolder4), SaversKt.save(new Offset(shadow.offset), SaversKt.OffsetSaver, saveableHolder4), Float.valueOf(shadow.blurRadius));
            case 16:
                return Integer.valueOf(((TextAlign) obj2).value);
            case 17:
                return Integer.valueOf(((TextDirection) obj2).value);
            case 18:
                return Integer.valueOf(((Hyphens) obj2).value);
            case 19:
                return Integer.valueOf(((FontStyle) obj2).value);
            case 20:
                return Integer.valueOf(((FontSynthesis) obj2).value);
            case 21:
                LinkAnnotation.Url url = (LinkAnnotation.Url) obj2;
                return CollectionsKt__IterablesKt.arrayListOf(url.url, SaversKt.save(url.styles, SaversKt.TextLinkStylesSaver, (SaveableHolder) obj));
            case 22:
                TextUnit textUnit2 = (TextUnit) obj2;
                return textUnit2 != null ? TextUnit.m812equalsimpl0(textUnit2.packedValue, IntMath.pack(0L, Float.NaN)) : false ? Boolean.FALSE : CollectionsKt__IterablesKt.arrayListOf(Float.valueOf(TextUnit.m814getValueimpl(textUnit2.packedValue)), SaversKt.save(new TextUnitType(TextUnit.m813getTypeUIouoOA(textUnit2.packedValue)), SaversKt.TextUnitTypeSaver, (SaveableHolder) obj));
            case 23:
                long j = ((TextUnitType) obj2).type;
                if (TextUnitType.m816equalsimpl0(j, 8589934592L)) {
                    return 0;
                }
                if (TextUnitType.m816equalsimpl0(j, 4294967296L)) {
                    return 1;
                }
                return Boolean.FALSE;
            case 24:
                AnnotatedString.Range range = (AnnotatedString.Range) obj2;
                Object obj5 = range.item;
                obj5.getClass();
                return CollectionsKt__IterablesKt.arrayListOf(SaversKt.save((AnnotatedString.Annotation) obj5, SaversKt.AnnotationSaver, (SaveableHolder) obj), Integer.valueOf(range.start), Integer.valueOf(range.end), range.tag);
            case 25:
                Offset offset = (Offset) obj2;
                return offset != null ? Offset.m434equalsimpl0(offset.packedValue, 9205357640488583168L) : false ? Boolean.FALSE : CollectionsKt__IterablesKt.arrayListOf(Float.valueOf(Float.intBitsToFloat((int) (offset.packedValue >> 32))), Float.valueOf(Float.intBitsToFloat((int) (offset.packedValue & 4294967295L))));
            case 26:
                SaveableHolder saveableHolder5 = (SaveableHolder) obj;
                List list2 = ((LocaleList) obj2).localeList;
                ArrayList arrayList2 = new ArrayList(list2.size());
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    arrayList2.add(SaversKt.save((Locale) list2.get(i2), SaversKt.LocaleSaver, saveableHolder5));
                }
                return arrayList2;
            case 27:
                return ((Locale) obj2).platformLocale.toLanguageTag();
            case 28:
                SaveableHolder saveableHolder6 = (SaveableHolder) obj;
                LineHeightStyle lineHeightStyle = (LineHeightStyle) obj2;
                return CollectionsKt__IterablesKt.arrayListOf(SaversKt.save(new LineHeightStyle.Alignment(lineHeightStyle.alignment), SaversKt.LineHeightStyleAlignmentSaver, saveableHolder6), SaversKt.save(new LineHeightStyle.Trim(lineHeightStyle.trim), SaversKt.LineHeightStyleTrimSaver, saveableHolder6), SaversKt.save(new LineHeightStyle.Mode(lineHeightStyle.mode), SaversKt.LineHeightStyleModeSaver, saveableHolder6));
            default:
                return Float.valueOf(((LineHeightStyle.Alignment) obj2).topRatio);
        }
    }
}
