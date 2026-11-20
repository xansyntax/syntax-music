package com.metrolist.music.ui.screens.settings;

import android.content.Context;
import android.graphics.Matrix;
import android.net.Uri;
import android.view.TextureView;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.internal.Lock;
import androidx.compose.foundation.BackgroundElement;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialShapes;
import androidx.compose.material3.MaterialShapes$Companion$PointNRound;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda35;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.PathParser;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.AndroidUriHandler;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.graphics.shapes.CornerRounding;
import androidx.graphics.shapes.RoundedPolygon;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.MediaItem;
import androidx.media3.datasource.RawResourceDataSource;
import androidx.media3.exoplayer.ExoPlayer$Builder;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.navigation.NavHostController;
import coil3.size.SizeKt;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.screens.LoginScreenKt$$ExternalSyntheticLambda3;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.uuid.UuidKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AboutScreenKt {
    public static final Contributor leadDeveloper;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        RoundedPolygon roundedPolygonNormalized = MaterialShapes._cookie9Sided;
        if (roundedPolygonNormalized == null) {
            roundedPolygonNormalized = IntMath.star$default(9, MaterialShapes.cornerRound50).transformed(new PathParser(MaterialShapes.rotateNeg90)).normalized();
            MaterialShapes._cookie9Sided = roundedPolygonNormalized;
        }
        leadDeveloper = new Contributor("DAPZ.DEV", R.string.credits_developer, "", null, roundedPolygonNormalized, "Mh2JWGWvy_Y", 56);
        RoundedPolygon roundedPolygonNormalized2 = MaterialShapes._cookie4Sided;
        if (roundedPolygonNormalized2 == null) {
            char c = ' ';
            long j = 4294967295L;
            char c2 = 2;
            List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new MaterialShapes$Companion$PointNRound[]{new MaterialShapes$Companion$PointNRound((((long) Float.floatToRawIntBits(1.237f)) << 32) | (((long) Float.floatToRawIntBits(1.236f)) & 4294967295L), new CornerRounding(2, 0.258f)), new MaterialShapes$Companion$PointNRound((((long) Float.floatToRawIntBits(0.5f)) << 32) | (((long) Float.floatToRawIntBits(0.918f)) & 4294967295L), new CornerRounding(2, 0.233f))});
            long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(0.5f)) & 4294967295L) | (((long) Float.floatToRawIntBits(0.5f)) << 32);
            int size = listListOf.size();
            IntRange intRangeUntil = UuidKt.until(0, size * 4);
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator it = intRangeUntil.iterator();
            while (((IntProgressionIterator) it).hasNext) {
                int iNextInt = ((IntIterator) it).nextInt();
                CornerRounding cornerRounding = MaterialShapes.cornerRound50;
                int i = iNextInt % size;
                long jM438minusMKHz9U = Offset.m438minusMKHz9U(((MaterialShapes$Companion$PointNRound) listListOf.get(i)).o, jFloatToRawIntBits);
                char c3 = c2;
                char c4 = c;
                int i2 = (int) (jM438minusMKHz9U >> c4);
                long j2 = j;
                double d = ((((iNextInt / size) * 360.0f) / 4.0f) / 360.0f) * 2.0f * 3.1415927f;
                ArrayList arrayList2 = arrayList;
                int i3 = (int) (jM438minusMKHz9U & j2);
                arrayList2.add(new MaterialShapes$Companion$PointNRound(Offset.m439plusMKHz9U((((long) Float.floatToRawIntBits((Float.intBitsToFloat(i2) * ((float) Math.cos(d))) - (Float.intBitsToFloat(i3) * ((float) Math.sin(d))))) << c4) | (((long) Float.floatToRawIntBits((Float.intBitsToFloat(i3) * ((float) Math.cos(d))) + (Float.intBitsToFloat(i2) * ((float) Math.sin(d))))) & j2), jFloatToRawIntBits), ((MaterialShapes$Companion$PointNRound) listListOf.get(i)).r));
                arrayList = arrayList2;
                c = c4;
                c2 = c3;
                j = j2;
            }
            char c5 = c;
            long j3 = j;
            ArrayList arrayList3 = arrayList;
            int size2 = arrayList3.size() * 2;
            float[] fArr = new float[size2];
            for (int i4 = 0; i4 < size2; i4++) {
                long j4 = ((MaterialShapes$Companion$PointNRound) arrayList3.get(i4 / 2)).o;
                fArr[i4] = Float.intBitsToFloat((int) (i4 % 2 == 0 ? j4 >> c5 : j4 & j3));
            }
            ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
            int size3 = arrayList3.size();
            int i5 = 0;
            while (i5 < size3) {
                Object obj = arrayList3.get(i5);
                i5++;
                listBuilderCreateListBuilder.add(((MaterialShapes$Companion$PointNRound) obj).r);
            }
            roundedPolygonNormalized2 = SizeKt.RoundedPolygon(fArr, CornerRounding.Unrounded, CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder), Float.intBitsToFloat((int) (jFloatToRawIntBits >> c5)), Float.intBitsToFloat((int) (jFloatToRawIntBits & j3))).normalized();
            MaterialShapes._cookie4Sided = roundedPolygonNormalized2;
        }
        Contributor contributor = new Contributor("Adriel O'Connel", R.string.credits_collaborator, "adrielGGmotion", "https://github.com/sponsors/adrielGGmotion", roundedPolygonNormalized2, "m2zUrruKjDQ", 24);
        RoundedPolygon roundedPolygonNormalized3 = MaterialShapes._cookie12Sided;
        if (roundedPolygonNormalized3 == null) {
            roundedPolygonNormalized3 = IntMath.star$default(12, MaterialShapes.cornerRound50).transformed(new PathParser(MaterialShapes.rotateNeg90)).normalized();
            MaterialShapes._cookie12Sided = roundedPolygonNormalized3;
        }
        CollectionsKt__IterablesKt.listOf((Object[]) new Contributor[]{contributor, new Contributor("Nyx", R.string.credits_collaborator, "nyxiereal", "https://github.com/sponsors/nyxiereal", roundedPolygonNormalized3, "zselaN6zPXw", 24)});
        CollectionsKt__IterablesKt.listOf(new CommunityLink());
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0441  */
    /* JADX WARN: Code duplicated, block: B:51:0x0445  */
    /* JADX WARN: Code duplicated, block: B:56:0x0461  */
    /* JADX WARN: Code duplicated, block: B:59:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:61:0x04c8  */
    public static final void AboutScreen(NavHostController navHostController, Composer composer, int i) throws XmlPullParserException, IOException {
        NavHostController navHostController2;
        NeverEqualPolicy neverEqualPolicy;
        RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4;
        boolean zChangedInstance;
        Object objRememberedValue;
        navHostController.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1720759730);
        int i2 = i | (gapComposer.changedInstance(navHostController) ? 4 : 2);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            final UriHandler uriHandler = (UriHandler) gapComposer.consume(CompositionLocalsKt.LocalUriHandler);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
            if (objRememberedValue2 == neverEqualPolicy2) {
                objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy2) {
                objRememberedValue3 = new SnackbarHostState();
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue3;
            MathKt.stringResource(R.string.wanna_play_favorite_song, gapComposer);
            MathKt.stringResource(R.string.yeah, gapComposer);
            WindowInsets windowInsets = (WindowInsets) gapComposer.consume(MainActivityKt.LocalPlayerAwareWindowInsets);
            FillElement fillElement = androidx.compose.foundation.layout.SizeKt.FillWholeMaxSize;
            Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(ImageKt.scroll$default(OffsetKt.windowInsetsPadding(fillElement, new LimitInsets(windowInsets, 47)), ImageKt.rememberScrollState(gapComposer), true), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
            BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
            Arrangement$Top$1 arrangement$Top$1 = OffsetKt.Top;
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer, 48);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM137paddingVpY3zN4$default);
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
            LimitInsets limitInsets = new LimitInsets(windowInsets, 16);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            OffsetKt.Spacer(gapComposer, OffsetKt.windowInsetsPadding(companion, limitInsets));
            OffsetKt.Spacer(gapComposer, androidx.compose.foundation.layout.SizeKt.m145height3ABfNKs(companion, 16.0f));
            CardKt.OutlinedCard(androidx.compose.foundation.layout.SizeKt.fillMaxWidth(companion, 1.0f), GlassComponentsKt.m1480glassShapeixp7dh8(22.0f, 12.0f, gapComposer), null, null, null, AiSettingsKt.f559lambda$623235576, gapComposer, 196614, 28);
            OffsetKt.Spacer(gapComposer, androidx.compose.foundation.layout.SizeKt.m145height3ABfNKs(companion, 24.0f));
            long j = CardKt.getColorScheme(gapComposer).surface;
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(ClipKt.clip(androidx.compose.foundation.layout.SizeKt.m145height3ABfNKs(androidx.compose.foundation.layout.SizeKt.fillMaxWidth(companion, 1.0f), 380.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f)), CardKt.getColorScheme(gapComposer).surfaceContainerHigh, ColorKt.RectangleShape);
            BiasAlignment biasAlignment = Alignment.Companion.TopStart;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM39backgroundbw27NRU);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            DevBannerVideo(fillElement, gapComposer, 6);
            Pair[] pairArr = {new Pair(Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO), new Color(0L)), new Pair(Float.valueOf(0.38f), new Color(0L)), new Pair(Float.valueOf(0.72f), new Color(ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.85f, Color.m483getColorSpaceimpl(j)))), new Pair(Float.valueOf(0.92f), new Color(j)), new Pair(Float.valueOf(1.0f), new Color(j))};
            BoxKt.Box(fillElement.then(new BackgroundElement(0L, Lock.m9linearGradientmHitzGk((Pair[]) Arrays.copyOf(pairArr, pairArr.length), (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) & 4294967295L), (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits(Float.POSITIVE_INFINITY)) & 4294967295L)), ColorKt.RectangleShape, 1)), gapComposer, 0);
            BiasAlignment biasAlignment2 = Alignment.Companion.BottomStart;
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(OffsetKt.m137paddingVpY3zN4$default(androidx.compose.foundation.layout.SizeKt.fillMaxWidth(boxScopeInstance.align(companion, biasAlignment2), 1.0f), 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, 7);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Bottom, gapComposer, 48);
            int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM139paddingqDBjuR0$default);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
            ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, Alignment.Companion.Start, gapComposer, 0);
            int iHashCode4 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer, layoutWeightElement);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, columnMeasurePolicy2, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda3);
            Contributor contributor = leadDeveloper;
            TextKt.m352TextNvy7gAk(contributor.name, null, CardKt.getColorScheme(gapComposer).onSurface, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer).displaySmall, gapComposer, 1572864, 0, 131002);
            String strStringResource = MathKt.stringResource(R.string.credits_developer, gapComposer);
            Locale locale = Locale.ROOT;
            String upperCase = strStringResource.toUpperCase(locale);
            upperCase.getClass();
            TextKt.m352TextNvy7gAk(upperCase, null, CardKt.getColorScheme(gapComposer).primary, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer).labelMedium, gapComposer, 0, 0, 131066);
            gapComposer.end(true);
            Painter painterPainterResource = IntMath.painterResource(R.drawable.dapz_avatar, 0, gapComposer);
            String str = contributor.name;
            Modifier modifierM151size3ABfNKs = androidx.compose.foundation.layout.SizeKt.m151size3ABfNKs(companion, 104.0f);
            RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.CircleShape;
            ImageKt.Image(painterPainterResource, str, ClipKt.clip(OffsetKt.m135padding3ABfNKs(ImageKt.m42borderxT4_qwU(modifierM151size3ABfNKs, 3.0f, j, roundedCornerShape), 3.0f), roundedCornerShape), null, ContentScale.Companion.Crop, CropImageView.DEFAULT_ASPECT_RATIO, null, gapComposer, 24584, 104);
            gapComposer.end(true);
            gapComposer.end(true);
            OffsetKt.Spacer(gapComposer, androidx.compose.foundation.layout.SizeKt.m145height3ABfNKs(companion, 20.0f));
            String upperCase2 = MathKt.stringResource(R.string.dapz_social_title, gapComposer).toUpperCase(locale);
            upperCase2.getClass();
            TextKt.m352TextNvy7gAk(upperCase2, null, CardKt.getColorScheme(gapComposer).onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer).labelSmall, gapComposer, 0, 0, 131066);
            gapComposer = gapComposer;
            OffsetKt.Spacer(gapComposer, androidx.compose.foundation.layout.SizeKt.m145height3ABfNKs(companion, 8.0f));
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = UiStyleKt.isGlassStyle(gapComposer) ? roundedCornerShape : RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
            Modifier modifierM145height3ABfNKs = androidx.compose.foundation.layout.SizeKt.m145height3ABfNKs(androidx.compose.foundation.layout.SizeKt.fillMaxWidth(companion, 1.0f), 48.0f);
            boolean zChangedInstance2 = gapComposer.changedInstance(uriHandler);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChangedInstance2) {
                neverEqualPolicy = neverEqualPolicy2;
            } else {
                neverEqualPolicy = neverEqualPolicy2;
                if (objRememberedValue4 == neverEqualPolicy) {
                }
                NeverEqualPolicy neverEqualPolicy3 = neverEqualPolicy;
                CardKt.OutlinedButton((Function0) objRememberedValue4, modifierM145height3ABfNKs, false, roundedCornerShapeM185RoundedCornerShape0680j_5, null, null, null, AiSettingsKt.f553lambda$50008374, gapComposer, 805306416, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
                OffsetKt.Spacer(gapComposer, androidx.compose.foundation.layout.SizeKt.m145height3ABfNKs(companion, 8.0f));
                if (UiStyleKt.isGlassStyle(gapComposer)) {
                    roundedCornerShapeM185RoundedCornerShape0680j_4 = roundedCornerShape;
                } else {
                    roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                }
                Modifier modifierM145height3ABfNKs2 = androidx.compose.foundation.layout.SizeKt.m145height3ABfNKs(androidx.compose.foundation.layout.SizeKt.fillMaxWidth(companion, 1.0f), 48.0f);
                zChangedInstance = gapComposer.changedInstance(uriHandler);
                objRememberedValue = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue == neverEqualPolicy3) {
                    final byte b = 1;
                    objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.screens.settings.AboutScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            byte b2 = b;
                            Unit unit = Unit.INSTANCE;
                            UriHandler uriHandler2 = uriHandler;
                            switch (b2) {
                                case 0:
                                    ((AndroidUriHandler) uriHandler2).openUri("https://t.me/ryuzinetshh");
                                    break;
                                default:
                                    ((AndroidUriHandler) uriHandler2).openUri("https://www.tiktok.com/@dappxml29");
                                    break;
                            }
                            return unit;
                        }
                    };
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                CardKt.OutlinedButton((Function0) objRememberedValue, modifierM145height3ABfNKs2, false, roundedCornerShapeM185RoundedCornerShape0680j_4, null, null, null, AiSettingsKt.f518lambda$2021397005, gapComposer, 805306416, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
                OffsetKt.Spacer(gapComposer, androidx.compose.foundation.layout.SizeKt.m145height3ABfNKs(companion, 48.0f));
                gapComposer.end(true);
                navHostController2 = navHostController;
                MenuKt.m1493TopAppBarGHTll3U(AiSettingsKt.lambda$1903789174, null, Expect_jvmKt.rememberComposableLambda(-462245896, new LoginScreenKt$$ExternalSyntheticLambda3(navHostController2, (byte) 19), gapComposer), null, CropImageView.DEFAULT_ASPECT_RATIO, null, null, null, gapComposer, 390, 250);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                int iHashCode5 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer, fillElement);
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda3);
                ScrimKt.SnackbarHost(snackbarHostState, OffsetKt.windowInsetsPadding(boxScopeInstance.align(companion, Alignment.Companion.BottomCenter), new LimitInsets(windowInsets, 47)), null, gapComposer, 6, 4);
                gapComposer.end(true);
            }
            final byte b2 = 0;
            objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.screens.settings.AboutScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    byte b3 = b2;
                    Unit unit = Unit.INSTANCE;
                    UriHandler uriHandler2 = uriHandler;
                    switch (b3) {
                        case 0:
                            ((AndroidUriHandler) uriHandler2).openUri("https://t.me/ryuzinetshh");
                            break;
                        default:
                            ((AndroidUriHandler) uriHandler2).openUri("https://www.tiktok.com/@dappxml29");
                            break;
                    }
                    return unit;
                }
            };
            gapComposer.updateRememberedValue(objRememberedValue4);
            NeverEqualPolicy neverEqualPolicy4 = neverEqualPolicy;
            CardKt.OutlinedButton((Function0) objRememberedValue4, modifierM145height3ABfNKs, false, roundedCornerShapeM185RoundedCornerShape0680j_5, null, null, null, AiSettingsKt.f553lambda$50008374, gapComposer, 805306416, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
            OffsetKt.Spacer(gapComposer, androidx.compose.foundation.layout.SizeKt.m145height3ABfNKs(companion, 8.0f));
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                roundedCornerShapeM185RoundedCornerShape0680j_4 = roundedCornerShape;
            } else {
                roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
            }
            Modifier modifierM145height3ABfNKs3 = androidx.compose.foundation.layout.SizeKt.m145height3ABfNKs(androidx.compose.foundation.layout.SizeKt.fillMaxWidth(companion, 1.0f), 48.0f);
            zChangedInstance = gapComposer.changedInstance(uriHandler);
            objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance) {
                final byte b3 = 1;
                objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.screens.settings.AboutScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        byte b4 = b3;
                        Unit unit = Unit.INSTANCE;
                        UriHandler uriHandler2 = uriHandler;
                        switch (b4) {
                            case 0:
                                ((AndroidUriHandler) uriHandler2).openUri("https://t.me/ryuzinetshh");
                                break;
                            default:
                                ((AndroidUriHandler) uriHandler2).openUri("https://www.tiktok.com/@dappxml29");
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                final byte b4 = 1;
                objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.screens.settings.AboutScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        byte b5 = b4;
                        Unit unit = Unit.INSTANCE;
                        UriHandler uriHandler2 = uriHandler;
                        switch (b5) {
                            case 0:
                                ((AndroidUriHandler) uriHandler2).openUri("https://t.me/ryuzinetshh");
                                break;
                            default:
                                ((AndroidUriHandler) uriHandler2).openUri("https://www.tiktok.com/@dappxml29");
                                break;
                        }
                        return unit;
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CardKt.OutlinedButton((Function0) objRememberedValue, modifierM145height3ABfNKs3, false, roundedCornerShapeM185RoundedCornerShape0680j_4, null, null, null, AiSettingsKt.f518lambda$2021397005, gapComposer, 805306416, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
            OffsetKt.Spacer(gapComposer, androidx.compose.foundation.layout.SizeKt.m145height3ABfNKs(companion, 48.0f));
            gapComposer.end(true);
            navHostController2 = navHostController;
            MenuKt.m1493TopAppBarGHTll3U(AiSettingsKt.lambda$1903789174, null, Expect_jvmKt.rememberComposableLambda(-462245896, new LoginScreenKt$$ExternalSyntheticLambda3(navHostController2, (byte) 19), gapComposer), null, CropImageView.DEFAULT_ASPECT_RATIO, null, null, null, gapComposer, 390, 250);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            int iHashCode6 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer, fillElement);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy3, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode6, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda3);
            ScrimKt.SnackbarHost(snackbarHostState, OffsetKt.windowInsetsPadding(boxScopeInstance.align(companion, Alignment.Companion.BottomCenter), new LimitInsets(windowInsets, 47)), null, gapComposer, 6, 4);
            gapComposer.end(true);
        } else {
            navHostController2 = navHostController;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LoginScreenKt$$ExternalSyntheticLambda3(navHostController2, i, (byte) 20);
        }
    }

    public static final void DevBannerVideo(Modifier modifier, Composer composer, int i) {
        Object failure;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(2072945597);
        byte b = 2;
        if (gapComposer.shouldExecute(i & 1, (i & 3) != 2)) {
            Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            LifecycleOwner lifecycleOwner = (LifecycleOwner) gapComposer.consume(LocalLifecycleOwnerKt.LocalLifecycleOwner);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                try {
                    ExoPlayer$Builder exoPlayer$Builder = new ExoPlayer$Builder(context);
                    AudioAttributes audioAttributes = AudioAttributes.DEFAULT;
                    UtilsKt.checkState(!exoPlayer$Builder.buildCalled);
                    exoPlayer$Builder.audioAttributes = audioAttributes;
                    UtilsKt.checkState(!exoPlayer$Builder.buildCalled);
                    exoPlayer$Builder.buildCalled = true;
                    ExoPlayerImpl exoPlayerImpl = new ExoPlayerImpl(exoPlayer$Builder);
                    exoPlayerImpl.setVolume(CropImageView.DEFAULT_ASPECT_RATIO);
                    exoPlayerImpl.setRepeatMode(1);
                    Uri uriBuildRawResourceUri = RawResourceDataSource.buildRawResourceUri(R.raw.dev_banner);
                    MediaItem.Builder builder = new MediaItem.Builder();
                    builder.uri = uriBuildRawResourceUri;
                    exoPlayerImpl.setMediaItem(builder.build());
                    exoPlayerImpl.prepare();
                    exoPlayerImpl.setPlayWhenReady(true);
                    failure = exoPlayerImpl;
                } catch (Throwable th) {
                    failure = new Result.Failure(th);
                }
                boolean z = failure instanceof Result.Failure;
                Object obj = failure;
                if (z) {
                    obj = null;
                }
                objRememberedValue = (ExoPlayerImpl) obj;
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            ExoPlayerImpl exoPlayerImpl2 = (ExoPlayerImpl) objRememberedValue;
            boolean zChangedInstance = gapComposer.changedInstance(exoPlayerImpl2) | gapComposer.changedInstance(lifecycleOwner);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new SongMenuKt$$ExternalSyntheticLambda4((Object) lifecycleOwner, (Object) exoPlayerImpl2, (byte) 23);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Stack.DisposableEffect(lifecycleOwner, exoPlayerImpl2, (Function1) objRememberedValue2, gapComposer);
            if (exoPlayerImpl2 != null) {
                gapComposer.startReplaceGroup(2084069762);
                boolean zChangedInstance2 = gapComposer.changedInstance(exoPlayerImpl2);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new MimesKt$$ExternalSyntheticLambda0((byte) 16, exoPlayerImpl2);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue3, modifier, null, gapComposer, 48);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(2085271973);
                gapComposer.end(false);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda35(modifier, i, b);
        }
    }

    public static final void DevBannerVideo$lambda$2$0$applyCover(TextureView textureView, Ref$FloatRef ref$FloatRef, Ref$FloatRef ref$FloatRef2) {
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width == CropImageView.DEFAULT_ASPECT_RATIO || height == CropImageView.DEFAULT_ASPECT_RATIO) {
            return;
        }
        float f = ref$FloatRef.element;
        if (f == CropImageView.DEFAULT_ASPECT_RATIO) {
            return;
        }
        float f2 = ref$FloatRef2.element;
        if (f2 == CropImageView.DEFAULT_ASPECT_RATIO) {
            return;
        }
        float fMax = Math.max(width / f, height / f2);
        Matrix matrix = new Matrix();
        matrix.setScale((ref$FloatRef.element * fMax) / width, (ref$FloatRef2.element * fMax) / height, width / 2.0f, height / 2.0f);
        textureView.setTransform(matrix);
    }
}
