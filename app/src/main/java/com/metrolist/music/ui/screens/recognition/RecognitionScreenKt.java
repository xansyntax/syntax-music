package com.metrolist.music.ui.screens.recognition;

import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda4;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.core.app.NavUtils;
import androidx.fragment.app.FragmentManager;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import coil3.compose.AsyncImageKt;
import coil3.util.FileSystemsKt;
import coil3.util.LifecyclesKt;
import com.google.common.math.IntMath;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.metrolist.music.App$Companion$forgetAccount$2;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda21;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda39;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.alarm.MusicAlarmStore$loadBlocking$1;
import com.metrolist.music.recognition.MusicRecognitionService;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.screens.ListenTogetherScreenKt$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.screens.LoginScreenKt$$ExternalSyntheticLambda3;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.screens.search.LocalSearchScreenKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.shazamkit.models.RecognitionResult;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RecognitionScreenKt {
    public static final void ErrorState(String str, Function0 function0, Composer composer, int i) throws XmlPullParserException, IOException {
        String str2;
        Function0 function1;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1808904694);
        int i2 = (gapComposer.changed(str) ? 4 : 2) | i | (gapComposer.changedInstance(function0) ? 32 : 16);
        byte b = 0;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            str2 = str;
            function1 = function0;
            RecognitionMessageState(R.drawable.error, MathKt.stringResource(R.string.recognition_error, gapComposer), str2, function1, gapComposer, (i2 << 6) & 8064);
        } else {
            str2 = str;
            function1 = function0;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new RecognitionScreenKt$$ExternalSyntheticLambda21(str2, function1, i, b);
        }
    }

    public static final void ListeningState(Function0 function0, Composer composer, int i) throws XmlPullParserException, IOException {
        Function0 function1;
        BorderStroke borderStrokeM38BorderStrokecXLIe8U;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-578252432);
        if (gapComposer.shouldExecute(i & 1, (i & 3) != 2)) {
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(20.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterHorizontally, gapComposer, 54);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, Modifier.Companion.$$INSTANCE);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            RecognitionMicButton(54, gapComposer, function0, true);
            String strStringResource = MathKt.stringResource(R.string.listening, gapComposer);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            DialogKt.m1469MicroLabelFNF3uiM(strStringResource, null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer, 0, 2);
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer));
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(1844365304);
                borderStrokeM38BorderStrokecXLIe8U = new BorderStroke(1.0f, GlassComponentsKt.glassRim(gapComposer));
            } else {
                gapComposer.startReplaceGroup(1844366486);
                borderStrokeM38BorderStrokecXLIe8U = ImageKt.m38BorderStrokecXLIe8U(((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.outlineVariant, 1.0f);
            }
            gapComposer.end(false);
            function1 = function0;
            CardKt.OutlinedButton(function1, null, false, roundedCornerShapeM185RoundedCornerShape0680j_4, null, borderStrokeM38BorderStrokecXLIe8U, null, RecognitionHistoryScreenKt.f419lambda$484560248, gapComposer, 805306374, 438);
            gapComposer = gapComposer;
            gapComposer.end(true);
        } else {
            function1 = function0;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda39(function1, i, (byte) 12);
        }
    }

    public static final void NoMatchState(String str, Function0 function0, Composer composer, int i) throws XmlPullParserException, IOException {
        String str2;
        Function0 function1;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1141530118);
        int i2 = (gapComposer.changed(str) ? 4 : 2) | i | (gapComposer.changedInstance(function0) ? 32 : 16);
        byte b = 1;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            str2 = str;
            function1 = function0;
            RecognitionMessageState(R.drawable.close, MathKt.stringResource(R.string.no_match_found, gapComposer), str2, function1, gapComposer, (i2 << 6) & 8064);
        } else {
            str2 = str;
            function1 = function0;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new RecognitionScreenKt$$ExternalSyntheticLambda21(str2, function1, i, b);
        }
    }

    public static final void ProcessingState(int i, Composer composer) {
        GapComposer gapComposer;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-31271436);
        if (gapComposer2.shouldExecute(i & 1, i != 0)) {
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(20.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterHorizontally, gapComposer2, 54);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, companion);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            boolean z = gapComposer2.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer2, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer2, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer2);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, 176.0f);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            Modifier modifierM42borderxT4_qwU = ImageKt.m42borderxT4_qwU(modifierM151size3ABfNKs, 1.0f, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.outlineVariant, RoundedCornerShapeKt.CircleShape);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM42borderxT4_qwU);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            gapComposer = gapComposer2;
            DialogKt.m1464CircularProgressIndicatorLxG7B9w(2.0f, 0, 390, 16, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.primary, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.outlineVariant, gapComposer, SizeKt.m151size3ABfNKs(companion, 96.0f));
            IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.music_note, 0, gapComposer), (String) null, SizeKt.m151size3ABfNKs(companion, 40.0f), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer, 440, 0);
            gapComposer.end(true);
            DialogKt.m1469MicroLabelFNF3uiM(MathKt.stringResource(R.string.processing, gapComposer), null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer, 0, 2);
            gapComposer.end(true);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TopPlaylistScreenKt$$ExternalSyntheticLambda8(i);
        }
    }

    public static final void ReadyState(Function0 function0, Composer composer, int i) throws XmlPullParserException, IOException {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-130701176);
        int i2 = (gapComposer.changedInstance(function0) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(20.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterHorizontally, gapComposer, 54);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, Modifier.Companion.$$INSTANCE);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            RecognitionMicButton((i2 & 14) | 48, gapComposer, function0, false);
            String strStringResource = MathKt.stringResource(R.string.recognize_music, gapComposer);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            DialogKt.m1469MicroLabelFNF3uiM(strStringResource, null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer, 0, 2);
            TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.tap_to_recognize, gapComposer), null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, 0L, null, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.headlineSmall, gapComposer, 0, 0, 130042);
            gapComposer = gapComposer;
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda39(function0, i, (byte) 13);
        }
    }

    public static final void RecognitionMessageState(int i, String str, String str2, Function0 function0, Composer composer, int i2) throws XmlPullParserException, IOException {
        int i3;
        String str3;
        String str4;
        Function0 function1;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1238483170);
        if ((i2 & 6) == 0) {
            i3 = (gapComposer.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            str3 = str;
            i3 |= gapComposer.changed(str3) ? 32 : 16;
        } else {
            str3 = str;
        }
        if ((i2 & 384) == 0) {
            str4 = str2;
            i3 |= gapComposer.changed(str4) ? 256 : 128;
        } else {
            str4 = str2;
        }
        if ((i2 & 3072) == 0) {
            function1 = function0;
            i3 |= gapComposer.changedInstance(function1) ? 2048 : 1024;
        } else {
            function1 = function0;
        }
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 1171) != 1170)) {
            BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
            Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(DialogKt.m1472editorialPaneleaDK9VM(SizeKt.fillMaxWidth(companion, 1.0f), null, gapComposer, 6, 7), 20.0f);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$SpacedAligned, horizontal, gapComposer, 54);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM135padding3ABfNKs);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            Painter painterPainterResource = IntMath.painterResource(i, i3 & 14, gapComposer);
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, 28.0f);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, modifierM151size3ABfNKs, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.error, gapComposer, 440, 0);
            int i4 = i3;
            TextKt.m352TextNvy7gAk(str3, null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.headlineSmall, gapComposer, (i3 >> 3) & 14, 0, 131066);
            TextKt.m352TextNvy7gAk(str4, null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer, (i4 >> 6) & 14, 0, 131066);
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 4.0f));
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer));
            PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
            CardKt.Button(function1, null, false, roundedCornerShapeM185RoundedCornerShape0680j_4, ButtonDefaults.m247buttonColorsro_MJ88(((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onPrimary, 0L, gapComposer, 12), null, null, null, null, RecognitionHistoryScreenKt.f424lambda$924272312, gapComposer, ((i4 >> 9) & 14) | 805306368, 486);
            gapComposer = gapComposer;
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda2(i, str, str2, function0, i2);
        }
    }

    public static final void RecognitionMicButton(final int i, Composer composer, final Function0 function0, final boolean z) throws XmlPullParserException, IOException {
        int i2;
        Modifier modifierM42borderxT4_qwU;
        RoundedCornerShape roundedCornerShape;
        long j;
        long j2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1981582824);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, 176.0f);
            if (UiStyleKt.isGlassStyle(gapComposer)) {
                gapComposer.startReplaceGroup(-1630572694);
                roundedCornerShape = RoundedCornerShapeKt.CircleShape;
                modifierM42borderxT4_qwU = GlassComponentsKt.glass(companion, roundedCornerShape, false, gapComposer, 6, 2);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1630571589);
                long j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant;
                RoundedCornerShape roundedCornerShape2 = RoundedCornerShapeKt.CircleShape;
                modifierM42borderxT4_qwU = ImageKt.m42borderxT4_qwU(companion, 1.0f, j3, roundedCornerShape2);
                gapComposer.end(false);
                roundedCornerShape = roundedCornerShape2;
            }
            Modifier modifierClip = ClipKt.clip(OffsetKt.m135padding3ABfNKs(modifierM151size3ABfNKs.then(modifierM42borderxT4_qwU), 16.0f), roundedCornerShape);
            if (z) {
                gapComposer.startReplaceGroup(-1630565183);
                j = CardKt.getColorScheme(gapComposer).onSurface;
            } else {
                gapComposer.startReplaceGroup(-1630563873);
                j = CardKt.getColorScheme(gapComposer).primary;
            }
            gapComposer.end(false);
            Modifier modifierM46clickableoSLSa3U$default = ImageKt.m46clickableoSLSa3U$default(ImageKt.m39backgroundbw27NRU(modifierClip, j, ColorKt.RectangleShape), false, null, function0, 15);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM46clickableoSLSa3U$default);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            Painter painterPainterResource = IntMath.painterResource(R.drawable.mic, 0, gapComposer);
            Modifier modifierM151size3ABfNKs2 = SizeKt.m151size3ABfNKs(companion, 56.0f);
            if (z) {
                gapComposer.startReplaceGroup(28516953);
                j2 = CardKt.getColorScheme(gapComposer).surface;
            } else {
                gapComposer.startReplaceGroup(28518203);
                j2 = CardKt.getColorScheme(gapComposer).onPrimary;
            }
            gapComposer.end(false);
            IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, modifierM151size3ABfNKs2, j2, gapComposer, 440, 0);
            gapComposer = gapComposer;
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.screens.recognition.RecognitionScreenKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
                    ((Integer) obj2).getClass();
                    RecognitionScreenKt.RecognitionMicButton(Stack.updateChangedFlags(i | 1), (Composer) obj, function0, z);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void RecognitionScreen(NavHostController navHostController, boolean z, Composer composer, int i) {
        GapComposer gapComposer;
        byte b;
        ManagedActivityResultLauncher managedActivityResultLauncher;
        Object innerTube$feedback$2;
        boolean z2 = z;
        navHostController.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-1550153180);
        int i2 = 2;
        int i3 = (gapComposer2.changedInstance(navHostController) ? 4 : 2) | i | (gapComposer2.changed(z2) ? 32 : 16);
        if (gapComposer2.shouldExecute(i3 & 1, (i3 & 19) != 18)) {
            Context context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
            MusicDatabase musicDatabase = (MusicDatabase) gapComposer2.consume(MainActivityKt.LocalDatabase);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new App$Companion$forgetAccount$2(i2, null, (byte) 10);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            Unit unit = Unit.INSTANCE;
            Stack.LaunchedEffect(gapComposer2, unit, (Function2) objRememberedValue2);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 22);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            Stack.DisposableEffect(unit, (Function1) objRememberedValue3, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(MusicRecognitionService.recognitionStatus, gapComposer2);
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = Stack.mutableStateOf$default(Boolean.valueOf(NavUtils.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0));
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            MutableState mutableState = (MutableState) objRememberedValue4;
            FragmentManager.FragmentIntentSenderContract fragmentIntentSenderContract = new FragmentManager.FragmentIntentSenderContract((byte) 7);
            boolean zChangedInstance = gapComposer2.changedInstance(coroutineScope) | gapComposer2.changedInstance(context);
            Object objRememberedValue5 = gapComposer2.rememberedValue();
            if (zChangedInstance || objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new MainActivity$$ExternalSyntheticLambda21((Object) coroutineScope, (Object) mutableState, (Object) context, (byte) 25);
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = LifecyclesKt.rememberLauncherForActivityResult(fragmentIntentSenderContract, (Function1) objRememberedValue5, gapComposer2, 0);
            boolean zChangedInstance2 = gapComposer2.changedInstance(coroutineScope) | ((i3 & 112) == 32) | gapComposer2.changedInstance(context) | gapComposer2.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
            Object objRememberedValue6 = gapComposer2.rememberedValue();
            if (zChangedInstance2 || objRememberedValue6 == neverEqualPolicy) {
                managedActivityResultLauncher = managedActivityResultLauncherRememberLauncherForActivityResult;
                innerTube$feedback$2 = new InnerTube$feedback$2(z2, coroutineScope, managedActivityResultLauncher, mutableState, context, (Continuation) null);
                gapComposer2.updateRememberedValue(innerTube$feedback$2);
            } else {
                managedActivityResultLauncher = managedActivityResultLauncherRememberLauncherForActivityResult;
                innerTube$feedback$2 = objRememberedValue6;
            }
            Stack.LaunchedEffect(gapComposer2, unit, (Function2) innerTube$feedback$2);
            gapComposer = gapComposer2;
            b = 2;
            ScrimKt.m317ScaffoldTvnljyQ(null, Expect_jvmKt.rememberComposableLambda(-2059935000, new LoginScreenKt$$ExternalSyntheticLambda3(navHostController, (byte) 15), gapComposer2), null, null, null, 0, 0L, 0L, null, Expect_jvmKt.rememberComposableLambda(-1805140813, new SongMenuKt$$ExternalSyntheticLambda8(mutableStateCollectAsStateWithLifecycle, coroutineScope, context, managedActivityResultLauncher, navHostController, musicDatabase, mutableState), gapComposer2), gapComposer, 805306416, 509);
        } else {
            z2 = z2;
            gapComposer = gapComposer2;
            b = 2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ListenTogetherScreenKt$$ExternalSyntheticLambda0(navHostController, z2, i, b);
        }
    }

    public static final void RecognitionScreen$startRecognition(CoroutineScope coroutineScope, ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, Context context) {
        if (!((Boolean) mutableState.getValue()).booleanValue()) {
            managedActivityResultLauncher.launch("android.permission.RECORD_AUDIO");
        } else {
            AwaitKt.launch$default(coroutineScope, null, null, new MusicAlarmStore$loadBlocking$1(context, (Continuation) null, (byte) 3), 3);
        }
    }

    public static final void SuccessState(RecognitionResult recognitionResult, Function1 function1, Function0 function0, Function0 function2, Function1 function3, Composer composer, int i) {
        int i2;
        GapComposer gapComposer;
        boolean z;
        BorderStroke borderStrokeM38BorderStrokecXLIe8U;
        boolean z2;
        BorderStroke borderStrokeM38BorderStrokecXLIe8U2;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(582718966);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? gapComposer2.changed(recognitionResult) : gapComposer2.changedInstance(recognitionResult) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer2.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer2.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer2.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer2.changedInstance(function3) ? 16384 : 8192;
        }
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 9363) != 9362)) {
            int i3 = i2 & 14;
            boolean z3 = ((57344 & i2) == 16384) | (i3 == 4 || ((i2 & 8) != 0 && gapComposer2.changedInstance(recognitionResult)));
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            byte b = 6;
            if (z3 || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new InterruptibleKt$runInterruptible$2(function3, recognitionResult, null, b);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            Stack.LaunchedEffect(gapComposer2, recognitionResult, (Function2) objRememberedValue);
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(24.0f, 8.0f, gapComposer2));
            BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
            Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            int i4 = i2;
            Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 4.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$SpacedAligned, horizontal, gapComposer2, 54);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM137paddingVpY3zN4$default);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            boolean z4 = gapComposer2.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z4) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer2, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer2, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer2);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            String coverArtHqUrl = recognitionResult.getCoverArtHqUrl();
            if (coverArtHqUrl == null) {
                coverArtHqUrl = recognitionResult.getCoverArtUrl();
            }
            AsyncImageKt.m849AsyncImage10Xjiaw(coverArtHqUrl, ImageKt.m42borderxT4_qwU(ClipKt.clip(SizeKt.m151size3ABfNKs(companion, 180.0f), roundedCornerShapeM185RoundedCornerShape0680j_4), 1.0f, CardKt.getColorScheme(gapComposer2).outlineVariant, roundedCornerShapeM185RoundedCornerShape0680j_4), ContentScale.Companion.Crop, gapComposer2, 1572912, 1976);
            byte b2 = 5;
            DialogKt.m1469MicroLabelFNF3uiM(Format$$ExternalSyntheticOutline0.m$1(companion, 8.0f, gapComposer2, R.string.recognize_music, gapComposer2), null, CardKt.getColorScheme(gapComposer2).primary, gapComposer2, 0, 2);
            TextKt.m352TextNvy7gAk(recognitionResult.getTitle(), null, CardKt.getColorScheme(gapComposer2).onSurface, 0L, null, null, null, 0L, null, 0L, 2, false, 2, 0, CardKt.getTypography(gapComposer2).headlineMedium, gapComposer2, 0, 24960, 110586);
            TextKt.m352TextNvy7gAk(recognitionResult.getArtist(), null, CardKt.getColorScheme(gapComposer2).onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, CardKt.getTypography(gapComposer2).titleMedium, gapComposer2, 0, 24960, 110586);
            GapComposer gapComposer3 = gapComposer2;
            String album = recognitionResult.getAlbum();
            if (album == null) {
                gapComposer3.startReplaceGroup(297294650);
                gapComposer3.end(false);
            } else {
                gapComposer3.startReplaceGroup(297294651);
                TextKt.m352TextNvy7gAk(album, null, CardKt.getColorScheme(gapComposer3).onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, CardKt.getTypography(gapComposer3).bodyMedium, gapComposer3, 0, 24960, 110586);
                gapComposer3 = gapComposer3;
                gapComposer3.end(false);
            }
            OffsetKt.Spacer(gapComposer3, SizeKt.m145height3ABfNKs(companion, 16.0f));
            Arrangement$SpacedAligned arrangement$SpacedAligned2 = new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0(b2));
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement$SpacedAligned2, horizontal, gapComposer3, 6);
            int iHashCode2 = Long.hashCode(gapComposer3.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierFillMaxWidth);
            gapComposer3.startReusableNode();
            if (gapComposer3.inserting) {
                gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer3.useNode();
            }
            Stack.m390setimpl(gapComposer3, columnMeasurePolicy2, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
            Stack.m390setimpl(gapComposer3, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer3));
            PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
            GapComposer gapComposer4 = gapComposer3;
            ButtonColors buttonColorsM247buttonColorsro_MJ88 = ButtonDefaults.m247buttonColorsro_MJ88(CardKt.getColorScheme(gapComposer3).primary, CardKt.getColorScheme(gapComposer3).onPrimary, 0L, gapComposer4, 12);
            Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 48.0f);
            boolean z5 = (i3 == 4 || ((i4 & 8) != 0 && gapComposer4.changedInstance(recognitionResult))) | ((i4 & 112) == 32);
            Object objRememberedValue2 = gapComposer4.rememberedValue();
            if (z5 || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new QueueKt$$ExternalSyntheticLambda16(function1, recognitionResult, (byte) 19);
                gapComposer4.updateRememberedValue(objRememberedValue2);
            }
            CardKt.Button((Function0) objRememberedValue2, modifierM145height3ABfNKs, false, roundedCornerShapeM185RoundedCornerShape0680j_5, buttonColorsM247buttonColorsro_MJ88, null, null, null, null, RecognitionHistoryScreenKt.lambda$1394527898, gapComposer4, 805306416, 484);
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_6 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer4));
            if (UiStyleKt.isGlassStyle(gapComposer4)) {
                gapComposer4.startReplaceGroup(-520229752);
                borderStrokeM38BorderStrokecXLIe8U = new BorderStroke(1.0f, GlassComponentsKt.glassRim(gapComposer4));
                z = false;
            } else {
                z = false;
                gapComposer4.startReplaceGroup(-520228570);
                borderStrokeM38BorderStrokecXLIe8U = ImageKt.m38BorderStrokecXLIe8U(CardKt.getColorScheme(gapComposer4).outlineVariant, 1.0f);
            }
            gapComposer4.end(z);
            CardKt.OutlinedButton(function0, SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 48.0f), false, roundedCornerShapeM185RoundedCornerShape0680j_6, null, borderStrokeM38BorderStrokecXLIe8U, null, RecognitionHistoryScreenKt.lambda$349393112, gapComposer4, ((i4 >> 6) & 14) | 805306416, 436);
            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_7 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer4));
            if (UiStyleKt.isGlassStyle(gapComposer4)) {
                gapComposer4.startReplaceGroup(-520202808);
                borderStrokeM38BorderStrokecXLIe8U2 = new BorderStroke(1.0f, GlassComponentsKt.glassRim(gapComposer4));
                z2 = false;
            } else {
                z2 = false;
                gapComposer4.startReplaceGroup(-520201626);
                borderStrokeM38BorderStrokecXLIe8U2 = ImageKt.m38BorderStrokecXLIe8U(CardKt.getColorScheme(gapComposer4).outlineVariant, 1.0f);
            }
            gapComposer4.end(z2);
            CardKt.OutlinedButton(function2, SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 48.0f), false, roundedCornerShapeM185RoundedCornerShape0680j_7, null, borderStrokeM38BorderStrokecXLIe8U2, null, RecognitionHistoryScreenKt.f413lambda$1265990463, gapComposer4, ((i4 >> 9) & 14) | 805306416, 436);
            gapComposer = gapComposer4;
            gapComposer.end(true);
            gapComposer.end(true);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CrossfadeKt$$ExternalSyntheticLambda4(recognitionResult, function1, function0, function2, function3, i);
        }
    }
}
