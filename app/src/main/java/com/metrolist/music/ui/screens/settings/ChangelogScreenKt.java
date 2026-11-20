package com.metrolist.music.ui.screens.settings;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.SheetDefaultsKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda39;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda6;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda34;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.utils.ReleaseInfo;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.sequences.SubSequence;
import kotlin.text.MatchResult;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ChangelogScreenKt {
    public static final Regex markdownLinkRegex = new Regex("(@[a-zA-Z0-9_-]+)|(https?://[\\w-]+(\\.[\\w-]+)+[\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])");

    public static final void ChangelogScreen(Function0 function0, Composer composer, int i) {
        GapComposer gapComposer;
        function0.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-283750709);
        int i2 = i | (gapComposer2.changedInstance(function0) ? 4 : 2);
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(EmptyList.INSTANCE);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.mutableStateOf$default(Boolean.TRUE);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue2;
            UriHandler uriHandler = (UriHandler) gapComposer2.consume(CompositionLocalsKt.LocalUriHandler);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new DataStoreKt$get$1((Object) mutableState, (Object) mutableState2, (Continuation) null, (byte) 17);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            Stack.LaunchedEffect(gapComposer2, Unit.INSTANCE, (Function2) objRememberedValue3);
            SheetState sheetStateRememberBottomSheetState = SheetDefaultsKt.rememberBottomSheetState(gapComposer2);
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ModalBottomSheetKt$$ExternalSyntheticLambda3(sheetStateRememberBottomSheetState, (byte) 1));
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            gapComposer = gapComposer2;
            CardKt.m262ModalBottomSheetYbuCTN8(function0, null, sheetStateRememberBottomSheetState, CropImageView.DEFAULT_ASPECT_RATIO, false, GlassComponentsKt.m1482glassTopShapeixp7dh8(16.0f, gapComposer2), 0L, 0L, 0L, AiSettingsKt.f554lambda$534408512, null, null, Expect_jvmKt.rememberComposableLambda(-1500938963, new SongMenuKt$$ExternalSyntheticLambda34(mutableState2, mutableState, (State) objRememberedValue4, uriHandler), gapComposer2), gapComposer, (i2 & 14) | 102236160, 3078, 6810);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda39(function0, i, (byte) 14);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void MarkdownText(String str, Composer composer, int i) {
        int i2;
        boolean z;
        ArrayList arrayList;
        char c;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3;
        AnnotatedString annotatedString;
        Modifier.Companion companion;
        UriHandler uriHandler;
        boolean z2;
        int i3;
        String strSubstring;
        char c2;
        boolean z3;
        TextStyle textStyle;
        BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-238904578);
        int i4 = i | (gapComposer.changed(str) ? 4 : 2);
        boolean z4 = true;
        boolean z5 = false;
        if (gapComposer.shouldExecute(i4 & 1, (i4 & 3) != 2)) {
            List listSplit$default = StringsKt.split$default(str, new String[]{"\n"}, 0, 6);
            UriHandler uriHandler2 = (UriHandler) gapComposer.consume(CompositionLocalsKt.LocalUriHandler);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), horizontal, gapComposer, 6);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, companion2);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z6 = gapComposer.inserting;
            UriHandler uriHandler3 = uriHandler2;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda4 = LayoutNode.Constructor;
            if (z6) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda4);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda4);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda5 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda5);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda6 = ComposeUiNode.Companion.SetCompositeKeyHash;
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode, gapComposer, updater$$ExternalSyntheticLambda6, gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda7 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda7);
            gapComposer.startReplaceGroup(-1499552937);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : listSplit$default) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList2.add(obj);
                }
            }
            int size = arrayList2.size();
            int i5 = 0;
            while (i5 < size) {
                int i6 = i5 + 1;
                String string = StringsKt.trim((String) arrayList2.get(i5)).toString();
                if (StringsKt__StringsJVMKt.startsWith(string, "#", z5)) {
                    gapComposer.startReplaceGroup(-1747093221);
                    int length = string.length();
                    int i7 = z5 ? 1 : 0;
                    while (true) {
                        if (i7 >= length) {
                            i3 = size;
                            strSubstring = string;
                            break;
                        }
                        i3 = size;
                        if (string.charAt(i7) != '#') {
                            strSubstring = string.substring(0, i7);
                            break;
                        } else {
                            i7++;
                            size = i3;
                            z5 = false;
                        }
                    }
                    int length2 = strSubstring.length();
                    String string2 = StringsKt.trim(string.substring(length2)).toString();
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion2, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda8 = updater$$ExternalSyntheticLambda5;
                    int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM137paddingVpY3zN4$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda4);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda4);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda8);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda6, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda7);
                    if (length2 != 1) {
                        c2 = 2;
                        if (length2 != 2) {
                            gapComposer.startReplaceGroup(1847744484);
                            textStyle = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium;
                            z3 = false;
                            gapComposer.end(false);
                        } else {
                            z3 = false;
                            gapComposer.startReplaceGroup(1847742086);
                            textStyle = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.headlineSmall;
                            gapComposer.end(false);
                        }
                    } else {
                        c2 = 2;
                        z3 = false;
                        gapComposer.startReplaceGroup(1847739751);
                        textStyle = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.headlineMedium;
                        gapComposer.end(false);
                    }
                    GapComposer gapComposer2 = gapComposer;
                    updater$$ExternalSyntheticLambda2 = updater$$ExternalSyntheticLambda6;
                    updater$$ExternalSyntheticLambda1 = updater$$ExternalSyntheticLambda8;
                    updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda4;
                    arrayList = arrayList2;
                    c = 0;
                    i2 = i3;
                    updater$$ExternalSyntheticLambda3 = updater$$ExternalSyntheticLambda7;
                    z = z3;
                    textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                    TextKt.m352TextNvy7gAk(string2, null, 0L, 0L, null, FontWeight.Bold, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, textStyle, gapComposer2, 1572864, 0, 129982);
                    gapComposer = gapComposer2;
                    gapComposer.end(true);
                    gapComposer.end(z);
                    z2 = true;
                    horizontal = horizontal;
                    uriHandler = uriHandler3;
                    companion = companion2;
                } else {
                    UriHandler uriHandler4 = uriHandler3;
                    i2 = size;
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda9 = updater$$ExternalSyntheticLambda5;
                    z = z5 ? 1 : 0;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda5 = textKt$$ExternalSyntheticLambda4;
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda10 = updater$$ExternalSyntheticLambda7;
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda11 = updater$$ExternalSyntheticLambda6;
                    Modifier.Companion companion3 = companion2;
                    arrayList = arrayList2;
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda12 = updater$$ExternalSyntheticLambda4;
                    c = 0;
                    gapComposer.startReplaceGroup(-1746242364);
                    Object[] objArr = (StringsKt__StringsJVMKt.startsWith(string, "- ", z) || StringsKt__StringsJVMKt.startsWith(string, "* ", z)) ? 1 : z ? 1 : 0;
                    if (objArr != 0) {
                        string = StringsKt.trim(string.substring(2)).toString();
                    }
                    gapComposer.startReplaceGroup(913509149);
                    AnnotatedString.Builder builder = new AnnotatedString.Builder();
                    SubSequence.AnonymousClass1 anonymousClass1 = new SubSequence.AnonymousClass1(Regex.findAll$default(markdownLinkRegex, string));
                    int i8 = z ? 1 : 0;
                    while (anonymousClass1.hasNext()) {
                        MatcherMatchResult matcherMatchResult = (MatcherMatchResult) ((MatchResult) anonymousClass1.next());
                        builder.append(string.substring(i8, matcherMatchResult.getRange().first));
                        String value = matcherMatchResult.getValue();
                        builder.pushStringAnnotation("URL", StringsKt__StringsJVMKt.startsWith(value, "@", z) ? "https://github.com/".concat(value.substring(1)) : value);
                        int iPushStyle = builder.pushStyle(new SpanStyle(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary, 0L, StringsKt__StringsJVMKt.startsWith(value, "@", z) ? FontWeight.Bold : FontWeight.Normal, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, StringsKt__StringsJVMKt.startsWith(value, "@", z) ? TextDecoration.None : TextDecoration.Underline, (Shadow) null, 61434));
                        try {
                            builder.append(value);
                            builder.pop(iPushStyle);
                            builder.pop();
                            i8 = matcherMatchResult.getRange().last + 1;
                        } catch (Throwable th) {
                            builder.pop(iPushStyle);
                            throw th;
                        }
                    }
                    builder.append(string.substring(i8));
                    AnnotatedString annotatedString2 = builder.toAnnotatedString();
                    gapComposer.end(z);
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion3, 1.0f);
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, horizontal, gapComposer, z ? 1 : 0);
                    int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, modifierFillMaxWidth);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda5;
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda5;
                        gapComposer.useNode();
                    }
                    updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda12;
                    Stack.m390setimpl(gapComposer, columnMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                    updater$$ExternalSyntheticLambda1 = updater$$ExternalSyntheticLambda9;
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                    updater$$ExternalSyntheticLambda2 = updater$$ExternalSyntheticLambda11;
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                    updater$$ExternalSyntheticLambda3 = updater$$ExternalSyntheticLambda10;
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion3, 1.0f);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer, z ? 1 : 0);
                    int iHashCode4 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer, modifierFillMaxWidth2);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda3);
                    if (objArr != 0) {
                        gapComposer.startReplaceGroup(1501826000);
                        GapComposer gapComposer3 = gapComposer;
                        annotatedString = annotatedString2;
                        companion = companion3;
                        TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.list_bullet, gapComposer), OffsetKt.m139paddingqDBjuR0$default(companion3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 11), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer3, 48, 0, 131068);
                        gapComposer = gapComposer3;
                        gapComposer.end(z);
                    } else {
                        annotatedString = annotatedString2;
                        companion = companion3;
                        gapComposer.startReplaceGroup(1502129676);
                        gapComposer.end(z);
                    }
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextStyle textStyleM750copyp1EtxEg$default = TextStyle.m750copyp1EtxEg$default(((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyLarge, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, 0L, null, null, null, null, 0L, 0L, null, null, 16777214);
                    uriHandler = uriHandler4;
                    boolean zChanged = gapComposer.changed(annotatedString) | gapComposer.changedInstance(uriHandler);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new SongMenuKt$$ExternalSyntheticLambda4((Object) annotatedString, (Object) uriHandler, (byte) 27);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    GapComposer gapComposer4 = gapComposer;
                    BasicTextKt.m188ClickableText4YKlhWE(annotatedString, null, textStyleM750copyp1EtxEg$default, false, 0, 0, null, (Function1) objRememberedValue, gapComposer4, 0, 122);
                    gapComposer = gapComposer4;
                    gapComposer.end(true);
                    if (objArr != 0) {
                        gapComposer.startReplaceGroup(-1994762365);
                        OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 4.0f));
                        long j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.outlineVariant;
                        CardKt.m261HorizontalDivider9IZ8Weo(null, 0.5f, ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.3f, Color.m483getColorSpaceimpl(j)), gapComposer, 48, 1);
                        gapComposer.end(z);
                    } else {
                        gapComposer.startReplaceGroup(-1994473104);
                        gapComposer.end(z);
                    }
                    z2 = true;
                    gapComposer.end(true);
                    gapComposer.end(z);
                }
                z5 = z;
                companion2 = companion;
                z4 = z2;
                uriHandler3 = uriHandler;
                i5 = i6;
                horizontal = horizontal;
                updater$$ExternalSyntheticLambda6 = updater$$ExternalSyntheticLambda2;
                updater$$ExternalSyntheticLambda5 = updater$$ExternalSyntheticLambda1;
                arrayList2 = arrayList;
                updater$$ExternalSyntheticLambda4 = updater$$ExternalSyntheticLambda0;
                size = i2;
                updater$$ExternalSyntheticLambda7 = updater$$ExternalSyntheticLambda3;
                textKt$$ExternalSyntheticLambda4 = textKt$$ExternalSyntheticLambda3;
            }
            gapComposer.end(z5 ? 1 : 0);
            gapComposer.end(z4);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda6(str, i);
        }
    }

    public static final void ReleaseItem(ReleaseInfo releaseInfo, Composer composer, int i) {
        ReleaseInfo releaseInfo2;
        long jColor;
        releaseInfo.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1147799188);
        int i2 = i | (gapComposer.changedInstance(releaseInfo) ? 4 : 2);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierFillMaxWidth);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.SpaceBetween, Alignment.Companion.CenterVertically, gapComposer, 54);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierFillMaxWidth2);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            SurfaceKt.m337SurfaceT9BRK9s(null, RoundedCornerShapeKt.CircleShape, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.secondaryContainer, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(-546852545, new ChangelogScreenKt$$ExternalSyntheticLambda0(releaseInfo), gapComposer), gapComposer, 12582912, 121);
            String str = (String) CollectionsKt.firstOrNull(StringsKt.split$default(releaseInfo.releaseDate, new String[]{"T"}, 0, 6));
            if (str == null) {
                str = "";
            }
            TextKt.m352TextNvy7gAk(str, null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer, 0, 0, 131066);
            gapComposer.end(true);
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 12.0f));
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(-1051245647);
                gapComposer.end(false);
                jColor = ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.45f, Color.m483getColorSpaceimpl(-4294967296L));
            } else {
                gapComposer.startReplaceGroup(-1051243156);
                jColor = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.outlineVariant;
                gapComposer.end(false);
            }
            releaseInfo2 = releaseInfo;
            CardKt.Card(SizeKt.fillMaxWidth(companion, 1.0f), GlassComponentsKt.m1480glassShapeixp7dh8(22.0f, 16.0f, gapComposer), CardKt.m267cardColorsro_MJ88(((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surfaceContainer, 0L, gapComposer, 14), null, ImageKt.m38BorderStrokecXLIe8U(jColor, 1.0f), Expect_jvmKt.rememberComposableLambda(1958747564, new ListItemKt$$ExternalSyntheticLambda17((byte) 22, (Object) releaseInfo2), gapComposer), gapComposer, 196614, 8);
            gapComposer = gapComposer;
            gapComposer.end(true);
        } else {
            releaseInfo2 = releaseInfo;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ChangelogScreenKt$$ExternalSyntheticLambda0(releaseInfo2, i);
        }
    }
}
