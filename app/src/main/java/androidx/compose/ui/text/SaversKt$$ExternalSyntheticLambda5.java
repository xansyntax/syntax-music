package androidx.compose.ui.text;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.compose.ui.viewinterop.ViewFactoryHolder;
import androidx.core.provider.CallbackWrapper;
import androidx.datastore.core.Message$Update;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavBackStackEntryState;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.internal.NavBackStackEntryImpl;
import androidx.navigation.internal.NavControllerImpl;
import androidx.savedstate.SavedStateRegistryOwner;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.github.ajalt.colormath.model.RGB;
import com.github.ajalt.colormath.model.RGBColorSpaceImpl;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.R;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.serialization.json.internal.JsonPath;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SaversKt$$ExternalSyntheticLambda5 implements Function2 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ SaversKt$$ExternalSyntheticLambda5(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        AnnotationType annotationType;
        Object objSave;
        byte b = this.$r8$classId;
        Bundle bundleBundleOf = null;
        int i = 0;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                LinkAnnotation.Clickable clickable = (LinkAnnotation.Clickable) obj2;
                return CollectionsKt__IterablesKt.arrayListOf(clickable.tag, SaversKt.save(clickable.styles, SaversKt.TextLinkStylesSaver, (SaveableHolder) obj));
            case 1:
                return Integer.valueOf(((LineHeightStyle.Trim) obj2).value);
            case 2:
                return Integer.valueOf(((LineHeightStyle.Mode) obj2).value);
            case 3:
                SaveableHolder saveableHolder = (SaveableHolder) obj;
                AnnotatedString.Annotation annotation = (AnnotatedString.Annotation) obj2;
                if (annotation instanceof ParagraphStyle) {
                    annotationType = AnnotationType.Paragraph;
                } else if (annotation instanceof SpanStyle) {
                    annotationType = AnnotationType.Span;
                } else if (annotation instanceof VerbatimTtsAnnotation) {
                    annotationType = AnnotationType.VerbatimTts;
                } else if (annotation instanceof UrlAnnotation) {
                    annotationType = AnnotationType.Url;
                } else if (annotation instanceof LinkAnnotation.Url) {
                    annotationType = AnnotationType.Link;
                } else if (annotation instanceof LinkAnnotation.Clickable) {
                    annotationType = AnnotationType.Clickable;
                } else {
                    if (!(annotation instanceof StringAnnotation)) {
                        throw new UnsupportedOperationException();
                    }
                    annotationType = AnnotationType.String;
                }
                switch (annotationType.ordinal()) {
                    case 0:
                        annotation.getClass();
                        objSave = SaversKt.save((ParagraphStyle) annotation, SaversKt.ParagraphStyleSaver, saveableHolder);
                        break;
                    case 1:
                        annotation.getClass();
                        objSave = SaversKt.save((SpanStyle) annotation, SaversKt.SpanStyleSaver, saveableHolder);
                        break;
                    case 2:
                        annotation.getClass();
                        objSave = SaversKt.save((VerbatimTtsAnnotation) annotation, SaversKt.VerbatimTtsAnnotationSaver, saveableHolder);
                        break;
                    case 3:
                        annotation.getClass();
                        objSave = SaversKt.save((UrlAnnotation) annotation, SaversKt.UrlAnnotationSaver, saveableHolder);
                        break;
                    case 4:
                        annotation.getClass();
                        objSave = SaversKt.save((LinkAnnotation.Url) annotation, SaversKt.LinkSaver, saveableHolder);
                        break;
                    case 5:
                        annotation.getClass();
                        objSave = SaversKt.save((LinkAnnotation.Clickable) annotation, SaversKt.ClickableSaver, saveableHolder);
                        break;
                    case 6:
                        annotation.getClass();
                        objSave = ((StringAnnotation) annotation).value;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                }
                return CollectionsKt__IterablesKt.arrayListOf(annotationType, objSave);
            case 4:
                return ((VerbatimTtsAnnotation) obj2).verbatim;
            case 5:
                SaveableHolder saveableHolder2 = (SaveableHolder) obj;
                ParagraphStyle paragraphStyle = (ParagraphStyle) obj2;
                Object objSave2 = SaversKt.save(new TextAlign(paragraphStyle.textAlign), SaversKt.TextAlignSaver, saveableHolder2);
                Object objSave3 = SaversKt.save(new TextDirection(paragraphStyle.textDirection), SaversKt.TextDirectionSaver, saveableHolder2);
                Object objSave4 = SaversKt.save(new TextUnit(paragraphStyle.lineHeight), SaversKt.TextUnitSaver, saveableHolder2);
                TextIndent textIndent = paragraphStyle.textIndent;
                TextIndent textIndent2 = TextIndent.None;
                Object objSave5 = SaversKt.save(textIndent, SaversKt.TextIndentSaver, saveableHolder2);
                Object objSave6 = SaversKt.save(paragraphStyle.platformStyle, TextRangeKt.PlatformParagraphStyleSaver, saveableHolder2);
                LineHeightStyle lineHeightStyle = paragraphStyle.lineHeightStyle;
                LineHeightStyle lineHeightStyle2 = LineHeightStyle.Default;
                return CollectionsKt__IterablesKt.arrayListOf(objSave2, objSave3, objSave4, objSave5, objSave6, SaversKt.save(lineHeightStyle, SaversKt.LineHeightStyleSaver, saveableHolder2), SaversKt.save(new LineBreak(paragraphStyle.lineBreak), TextRangeKt.LineBreakSaver, saveableHolder2), SaversKt.save(new Hyphens(paragraphStyle.hyphens), SaversKt.HyphensSaver, saveableHolder2), SaversKt.save(paragraphStyle.textMotion, TextRangeKt.TextMotionSaver, saveableHolder2));
            case 6:
                SaveableHolder saveableHolder3 = (SaveableHolder) obj;
                SpanStyle spanStyle = (SpanStyle) obj2;
                Color color = new Color(spanStyle.textForegroundStyle.mo768getColor0d7_KjU());
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$1 = SaversKt.ColorSaver;
                Object objSave7 = SaversKt.save(color, saversKt$NonNullValueClassSaver$1, saveableHolder3);
                TextUnit textUnit = new TextUnit(spanStyle.fontSize);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$2 = SaversKt.TextUnitSaver;
                Object objSave8 = SaversKt.save(textUnit, saversKt$NonNullValueClassSaver$2, saveableHolder3);
                FontWeight fontWeight = spanStyle.fontWeight;
                FontWeight fontWeight2 = FontWeight.W400;
                Object objSave9 = SaversKt.save(fontWeight, SaversKt.FontWeightSaver, saveableHolder3);
                Object objSave10 = SaversKt.save(spanStyle.fontStyle, SaversKt.FontStyleSaver, saveableHolder3);
                Object objSave11 = SaversKt.save(spanStyle.fontSynthesis, SaversKt.FontSynthesisSaver, saveableHolder3);
                String str = spanStyle.fontFeatureSettings;
                Object objSave12 = SaversKt.save(new TextUnit(spanStyle.letterSpacing), saversKt$NonNullValueClassSaver$2, saveableHolder3);
                Object objSave13 = SaversKt.save(spanStyle.baselineShift, SaversKt.BaselineShiftSaver, saveableHolder3);
                Object objSave14 = SaversKt.save(spanStyle.textGeometricTransform, SaversKt.TextGeometricTransformSaver, saveableHolder3);
                LocaleList localeList = spanStyle.localeList;
                LocaleList localeList2 = LocaleList.Empty;
                return CollectionsKt__IterablesKt.arrayListOf(objSave7, objSave8, objSave9, objSave10, objSave11, -1, str, objSave12, objSave13, objSave14, SaversKt.save(localeList, SaversKt.LocaleListSaver, saveableHolder3), SaversKt.save(new Color(spanStyle.background), saversKt$NonNullValueClassSaver$1, saveableHolder3), SaversKt.save(spanStyle.textDecoration, SaversKt.TextDecorationSaver, saveableHolder3), SaversKt.save(spanStyle.shadow, SaversKt.ShadowSaver, saveableHolder3));
            case 7:
                PlatformParagraphStyle platformParagraphStyle = (PlatformParagraphStyle) obj2;
                Boolean boolValueOf = Boolean.valueOf(platformParagraphStyle.includeFontPadding);
                CallbackWrapper callbackWrapper = SaversKt.AnnotatedStringSaver;
                return CollectionsKt__IterablesKt.arrayListOf(boolValueOf, SaversKt.save(new EmojiSupportMatch(platformParagraphStyle.emojiSupportMatch), TextRangeKt.emojiSupportMatchSaver, (SaveableHolder) obj));
            case 8:
                return Integer.valueOf(((EmojiSupportMatch) obj2).value);
            case 9:
                return Integer.valueOf(((LineBreak) obj2).mask);
            case 10:
                TextMotion textMotion = (TextMotion) obj2;
                return CollectionsKt__IterablesKt.arrayListOf(SaversKt.save(new TextMotion.Linearity(textMotion.linearity), TextRangeKt.TextMotionLinearitySaver, (SaveableHolder) obj), Boolean.valueOf(textMotion.subpixelTextPositioning));
            case 11:
                return Integer.valueOf(((TextMotion.Linearity) obj2).value);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                SaveableHolder saveableHolder4 = (SaveableHolder) obj;
                TextFieldValue textFieldValue = (TextFieldValue) obj2;
                return CollectionsKt__IterablesKt.arrayListOf(SaversKt.save(textFieldValue.annotatedString, SaversKt.AnnotatedStringSaver, saveableHolder4), SaversKt.save(new TextRange(textFieldValue.selection), SaversKt.TextRangeSaver, saveableHolder4));
            case 13:
                ViewFactoryHolder viewFactoryHolderRequireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder((LayoutNode) obj);
                int iOrdinal = ((LayoutDirection) obj2).ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    i = 1;
                }
                viewFactoryHolderRequireViewFactoryHolder.setLayoutDirection(i);
                return unit;
            case 14:
                AndroidView_androidKt.requireViewFactoryHolder((LayoutNode) obj).setUpdateBlock((Function1) obj2);
                return unit;
            case 15:
                AndroidView_androidKt.requireViewFactoryHolder((LayoutNode) obj).setReleaseBlock((Function1) obj2);
                return unit;
            case 16:
                AndroidView_androidKt.requireViewFactoryHolder((LayoutNode) obj).setModifier((Modifier) obj2);
                return unit;
            case 17:
                AndroidView_androidKt.requireViewFactoryHolder((LayoutNode) obj).setDensity((Density) obj2);
                return unit;
            case 18:
                AndroidView_androidKt.requireViewFactoryHolder((LayoutNode) obj).setLifecycleOwner((LifecycleOwner) obj2);
                return unit;
            case 19:
                AndroidView_androidKt.requireViewFactoryHolder((LayoutNode) obj).setSavedStateRegistryOwner((SavedStateRegistryOwner) obj2);
                return unit;
            case 20:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 21:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 22:
                Message$Update message$Update = (Message$Update) obj;
                Throwable cancellationException = (Throwable) obj2;
                message$Update.getClass();
                CompletableDeferredImpl completableDeferredImpl = message$Update.ack;
                if (cancellationException == null) {
                    cancellationException = new CancellationException("DataStore scope was cancelled before updateData could complete");
                }
                completableDeferredImpl.completeExceptionally(cancellationException);
                return unit;
            case 23:
                NavHostController navHostController = (NavHostController) obj2;
                NavControllerImpl navControllerImpl = navHostController.impl;
                LinkedHashMap linkedHashMap = navControllerImpl.backStackStates;
                ArrayDeque<NavBackStackEntry> arrayDeque = navControllerImpl.backQueue;
                LinkedHashMap linkedHashMap2 = navControllerImpl.backStackMap;
                ArrayList arrayList = new ArrayList();
                Bundle bundleBundleOf2 = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                for (Map.Entry entry : MapsKt__MapsKt.toMap(navControllerImpl._navigatorProvider._navigators).entrySet()) {
                    ((Navigator) entry.getValue()).getClass();
                }
                if (!arrayList.isEmpty()) {
                    bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    LifecyclesKt.m887putStringListimpl(bundleBundleOf2, "android-support-nav:controller:navigatorState:names", arrayList);
                    bundleBundleOf.putBundle("android-support-nav:controller:navigatorState", bundleBundleOf2);
                }
                if (!arrayDeque.isEmpty()) {
                    if (bundleBundleOf == null) {
                        bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    }
                    ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                    for (NavBackStackEntry navBackStackEntry : arrayDeque) {
                        navBackStackEntry.getClass();
                        int i2 = navBackStackEntry.destination.impl.size;
                        String str2 = navBackStackEntry.id;
                        NavBackStackEntryImpl navBackStackEntryImpl = navBackStackEntry.impl;
                        Bundle arguments$navigation_common_release = navBackStackEntryImpl.getArguments$navigation_common_release();
                        Bundle bundleBundleOf3 = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                        navBackStackEntryImpl.savedStateRegistryController.performSave(bundleBundleOf3);
                        Bundle bundleBundleOf4 = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                        bundleBundleOf4.putString("nav-entry-state:id", str2);
                        bundleBundleOf4.putInt("nav-entry-state:destination-id", i2);
                        if (arguments$navigation_common_release == null) {
                            arguments$navigation_common_release = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                        }
                        bundleBundleOf4.putBundle("nav-entry-state:args", arguments$navigation_common_release);
                        bundleBundleOf4.putBundle("nav-entry-state:saved-state", bundleBundleOf3);
                        arrayList2.add(bundleBundleOf4);
                    }
                    bundleBundleOf.putParcelableArrayList("android-support-nav:controller:backStack", arrayList2);
                }
                if (!linkedHashMap2.isEmpty()) {
                    if (bundleBundleOf == null) {
                        bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    }
                    int[] iArr = new int[linkedHashMap2.size()];
                    ArrayList arrayList3 = new ArrayList();
                    int i3 = 0;
                    for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                        int iIntValue3 = ((Number) entry2.getKey()).intValue();
                        String str3 = (String) entry2.getValue();
                        int i4 = i3 + 1;
                        iArr[i3] = iIntValue3;
                        if (str3 == null) {
                            str3 = "";
                        }
                        arrayList3.add(str3);
                        i3 = i4;
                    }
                    bundleBundleOf.putIntArray("android-support-nav:controller:backStackDestIds", iArr);
                    LifecyclesKt.m887putStringListimpl(bundleBundleOf, "android-support-nav:controller:backStackIds", arrayList3);
                }
                if (!linkedHashMap.isEmpty()) {
                    if (bundleBundleOf == null) {
                        bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                        String str4 = (String) entry3.getKey();
                        ArrayDeque arrayDeque2 = (ArrayDeque) entry3.getValue();
                        arrayList4.add(str4);
                        ArrayList<? extends Parcelable> arrayList5 = new ArrayList<>();
                        Iterator it = arrayDeque2.iterator();
                        while (it.hasNext()) {
                            JsonPath jsonPath = ((NavBackStackEntryState) it.next()).impl;
                            Bundle bundleBundleOf5 = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                            bundleBundleOf5.putString("nav-entry-state:id", (String) jsonPath.configuration);
                            bundleBundleOf5.putInt("nav-entry-state:destination-id", jsonPath.currentDepth);
                            Bundle bundleBundleOf6 = (Bundle) jsonPath.currentObjectPath;
                            if (bundleBundleOf6 == null) {
                                bundleBundleOf6 = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                            }
                            bundleBundleOf5.putBundle("nav-entry-state:args", bundleBundleOf6);
                            bundleBundleOf5.putBundle("nav-entry-state:saved-state", (Bundle) jsonPath.indicies);
                            arrayList5.add(bundleBundleOf5);
                        }
                        bundleBundleOf.putParcelableArrayList("android-support-nav:controller:backStackStates:" + str4, arrayList5);
                    }
                    LifecyclesKt.m887putStringListimpl(bundleBundleOf, "android-support-nav:controller:backStackStates", arrayList4);
                }
                if (navHostController.deepLinkHandled) {
                    if (bundleBundleOf == null) {
                        bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    }
                    bundleBundleOf.putBoolean("android-support-nav:controller:deepLinkHandled", navHostController.deepLinkHandled);
                }
                return bundleBundleOf;
            case 24:
                com.github.ajalt.colormath.Color color2 = (com.github.ajalt.colormath.Color) obj2;
                ((RGBColorSpaceImpl) obj).getClass();
                color2.getClass();
                return color2.toSRGB();
            case 25:
                RGBColorSpaceImpl rGBColorSpaceImpl = (RGBColorSpaceImpl) obj;
                com.github.ajalt.colormath.Color color3 = (com.github.ajalt.colormath.Color) obj2;
                rGBColorSpaceImpl.getClass();
                color3.getClass();
                return color3 instanceof RGB ? ((RGB) color3).convertTo(rGBColorSpaceImpl) : color3.toXYZ().toRGB(rGBColorSpaceImpl);
            case 26:
                RGBColorSpaceImpl rGBColorSpaceImpl2 = (RGBColorSpaceImpl) obj;
                com.github.ajalt.colormath.Color color4 = (com.github.ajalt.colormath.Color) obj2;
                rGBColorSpaceImpl2.getClass();
                color4.getClass();
                return color4 instanceof RGB ? ((RGB) color4).convertTo(rGBColorSpaceImpl2) : color4.toXYZ().toRGB(rGBColorSpaceImpl2);
            case 27:
                Composer composer3 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.history, 0, gapComposer3), MathKt.stringResource(R.string.history, gapComposer3), (Modifier) null, 0L, gapComposer3, 8, 12);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 28:
                Composer composer4 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.stats, 0, gapComposer4), MathKt.stringResource(R.string.stats, gapComposer4), (Modifier) null, 0L, gapComposer4, 8, 12);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer5 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.group_outlined, 0, gapComposer5), MathKt.stringResource(R.string.together, gapComposer5), (Modifier) null, 0L, gapComposer5, 8, 12);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
        }
    }
}
