package com.metrolist.music;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TooltipKt;
import androidx.compose.material3.TooltipScopeImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontWeight;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.ui.theme.UiStyleKt$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.utils.AppBarKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda7 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda7(String str, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) throws XmlPullParserException, IOException {
        byte b = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        String str = this.f$0;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                int i = MainActivity.$r8$clinit;
                ((BoxScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else if (!Intrinsics.areEqual(str, "4.1.0")) {
                    gapComposer.startReplaceGroup(-1386411356);
                    CardKt.m252BadgeeopBjH0(null, 0L, 0L, gapComposer, 0, 15);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-1386296997);
                    gapComposer.end(false);
                }
                break;
            case 1:
                TooltipScopeImpl tooltipScopeImpl = (TooltipScopeImpl) obj;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= (iIntValue2 & 8) == 0 ? ((GapComposer) composer2).changed(tooltipScopeImpl) : ((GapComposer) composer2).changedInstance(tooltipScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    String str2 = this.f$0;
                    TooltipKt.m362PlainTooltipInternalkw8QeXY(tooltipScopeImpl, str2, null, CropImageView.DEFAULT_ASPECT_RATIO, null, 0L, 0L, Expect_jvmKt.rememberComposableLambda(660974002, new MainActivity$$ExternalSyntheticLambda6(str2, (byte) 1), gapComposer2), gapComposer2, iIntValue2 & 14);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                }
                break;
            case 3:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((BoxWithConstraintsScopeImpl) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    MenuKt.LocalThumbnail(this.f$0, false, false, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(18.0f, 10.0f, gapComposer4)), Modifier.Companion.$$INSTANCE, false, false, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer4, 1769904);
                }
                break;
            case 4:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.CenterHorizontally, gapComposer5, 48);
                    int iHashCode = Long.hashCode(gapComposer5.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer5.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer5, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer5.startReusableNode();
                    if (gapComposer5.inserting) {
                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer5.useNode();
                    }
                    Stack.m390setimpl(gapComposer5, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer5, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer5);
                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    String strStringResource = MathKt.stringResource(R.string.sleep_timer_start_time, gapComposer5);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).typography.labelSmall, gapComposer5, 0, 0, 131070);
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).typography.bodyLarge, gapComposer5, 0, 0, 131070);
                    gapComposer5.end(true);
                }
                break;
            case 5:
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.CenterHorizontally, gapComposer6, 48);
                    int iHashCode2 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer6, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer6.startReusableNode();
                    if (gapComposer6.inserting) {
                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer6.useNode();
                    }
                    Stack.m390setimpl(gapComposer6, columnMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer6, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer6);
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    String strStringResource2 = MathKt.stringResource(R.string.sleep_timer_end_time, gapComposer6);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource2, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal2)).typography.labelSmall, gapComposer6, 0, 0, 131070);
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal2)).typography.bodyLarge, gapComposer6, 0, 0, 131070);
                    gapComposer6.end(true);
                }
                break;
            case 6:
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    AppBarKt.ShowMediaInfo(str, gapComposer7, 0);
                }
                break;
            case 7:
                PaddingValues paddingValues = (PaddingValues) obj;
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                paddingValues.getClass();
                if ((iIntValue8 & 6) == 0) {
                    iIntValue8 |= ((GapComposer) composer8).changed(paddingValues) ? 4 : 2;
                }
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    Modifier modifierScroll$default = ImageKt.scroll$default(OffsetKt.m137paddingVpY3zN4$default(OffsetKt.padding(SizeKt.FillWholeMaxSize, paddingValues), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), ImageKt.rememberScrollState(gapComposer8), true);
                    ColumnMeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer8, 0);
                    int iHashCode3 = Long.hashCode(gapComposer8.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer8.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer8, modifierScroll$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer8.startReusableNode();
                    if (gapComposer8.inserting) {
                        gapComposer8.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer8.useNode();
                    }
                    Stack.m390setimpl(gapComposer8, columnMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer8, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer8, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer8);
                    Stack.m390setimpl(gapComposer8, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    String strStringResource3 = MathKt.stringResource(R.string.crash_description, gapComposer8);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource3, null, ((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal3)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal3)).typography.bodyLarge, gapComposer8, 0, 0, 131066);
                    OffsetKt.Spacer(gapComposer8, SizeKt.m145height3ABfNKs(companion, 16.0f));
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(ImageKt.m39backgroundbw27NRU(ClipKt.clip(SizeKt.fillMaxWidth(companion, 1.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f)), ((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal3)).colorScheme.surfaceContainerHighest, ColorKt.RectangleShape), 16.0f);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode4 = Long.hashCode(gapComposer8.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer8.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer8, modifierM135padding3ABfNKs);
                    gapComposer8.startReusableNode();
                    if (gapComposer8.inserting) {
                        gapComposer8.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer8.useNode();
                    }
                    Stack.m390setimpl(gapComposer8, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer8, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer8, updater$$ExternalSyntheticLambda1, gapComposer8);
                    Stack.m390setimpl(gapComposer8, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                    TextKt.m352TextNvy7gAk(this.f$0, ImageKt.scroll$default(companion, ImageKt.rememberScrollState(gapComposer8), false), ((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal3)).colorScheme.onSurface, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, TextStyle.m750copyp1EtxEg$default(((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal3)).typography.bodySmall, 0L, IntMath.getSp(11), null, null, FontFamily.Monospace, null, 0L, IntMath.getSp(16), null, null, 16646109), gapComposer8, 0, 0, 131064);
                    gapComposer8.end(true);
                    OffsetKt.Spacer(gapComposer8, SizeKt.m145height3ABfNKs(companion, 88.0f));
                    gapComposer8.end(true);
                }
                break;
            case 8:
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (!gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    SurfaceKt.m337SurfaceT9BRK9s(SizeKt.fillMaxWidth(companion, 1.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f), ((MaterialTheme$Values) gapComposer9.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primaryContainer, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(1763633978, new MainActivity$$ExternalSyntheticLambda6(str, (byte) 20), gapComposer9), gapComposer9, 12582918, 120);
                }
                break;
            case 9:
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (!gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    gapComposer10.skipToGroupEnd();
                } else {
                    SurfaceKt.m337SurfaceT9BRK9s(SizeKt.fillMaxWidth(companion, 1.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f), ((MaterialTheme$Values) gapComposer10.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.errorContainer, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(1138250851, new MainActivity$$ExternalSyntheticLambda6(str, (byte) 21), gapComposer10), gapComposer10, 12582918, 120);
                }
                break;
            case 10:
                Composer composer11 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (!gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 17) != 16)) {
                    gapComposer11.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.wizard_select_eq_profiles, new Object[]{str}, gapComposer11), OffsetKt.m139paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 7), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer11.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium, gapComposer11, 48, 0, 131068);
                }
                break;
            case 11:
                Composer composer12 = (Composer) obj2;
                int iIntValue12 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (!gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 17) != 16)) {
                    gapComposer12.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.remove_download_playlist_confirm, new Object[]{str}, gapComposer12), OffsetKt.m137paddingVpY3zN4$default(companion, 18.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer12.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer12, 48, 0, 131068);
                }
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer13 = (Composer) obj2;
                int iIntValue13 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (!gapComposer13.shouldExecute(iIntValue13 & 1, (iIntValue13 & 17) != 16)) {
                    gapComposer13.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.remove_download_playlist_confirm, new Object[]{str}, gapComposer13), OffsetKt.m137paddingVpY3zN4$default(companion, 18.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer13.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer13, 48, 0, 131068);
                }
                break;
            case 13:
                Composer composer14 = (Composer) obj2;
                int iIntValue14 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (!gapComposer14.shouldExecute(iIntValue14 & 1, (iIntValue14 & 17) != 16)) {
                    gapComposer14.skipToGroupEnd();
                } else {
                    Modifier modifierM135padding3ABfNKs2 = OffsetKt.m135padding3ABfNKs(companion, 16.0f);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer14, 48);
                    int iHashCode5 = Long.hashCode(gapComposer14.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer14.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer14, modifierM135padding3ABfNKs2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer14.startReusableNode();
                    if (gapComposer14.inserting) {
                        gapComposer14.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer14.useNode();
                    }
                    Stack.m390setimpl(gapComposer14, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer14, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer14, Integer.valueOf(iHashCode5), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer14);
                    Stack.m390setimpl(gapComposer14, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda0);
                    Painter painterPainterResource = IntMath.painterResource(R.drawable.warning, 0, gapComposer14);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = MaterialThemeKt._localMaterialTheme;
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(companion, 24.0f), ((MaterialTheme$Values) gapComposer14.consume(staticProvidableCompositionLocal4)).colorScheme.onErrorContainer, gapComposer14, 440, 0);
                    OffsetKt.Spacer(gapComposer14, SizeKt.m155width3ABfNKs(companion, 12.0f));
                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                    ColumnMeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer14, 0);
                    int iHashCode6 = Long.hashCode(gapComposer14.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer14.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer14, layoutWeightElement);
                    gapComposer14.startReusableNode();
                    if (gapComposer14.inserting) {
                        gapComposer14.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer14.useNode();
                    }
                    Stack.m390setimpl(gapComposer14, columnMeasurePolicy4, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer14, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode6, gapComposer14, updater$$ExternalSyntheticLambda1, gapComposer14);
                    Stack.m390setimpl(gapComposer14, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda0);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.discord_error_banner_title, gapComposer14), null, ((MaterialTheme$Values) gapComposer14.consume(staticProvidableCompositionLocal4)).colorScheme.onErrorContainer, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer14.consume(staticProvidableCompositionLocal4)).typography.titleSmall, gapComposer14, 1572864, 0, 131002);
                    OffsetKt.Spacer(gapComposer14, SizeKt.m145height3ABfNKs(companion, 4.0f));
                    TextKt.m352TextNvy7gAk(this.f$0, null, ((MaterialTheme$Values) gapComposer14.consume(staticProvidableCompositionLocal4)).colorScheme.onErrorContainer, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer14.consume(staticProvidableCompositionLocal4)).typography.bodyMedium, gapComposer14, 0, 0, 131066);
                    OffsetKt.Spacer(gapComposer14, SizeKt.m145height3ABfNKs(companion, 8.0f));
                    Object objRememberedValue = gapComposer14.rememberedValue();
                    if (objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new UiStyleKt$$ExternalSyntheticLambda0((byte) 10);
                        gapComposer14.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.TextButton((Function0) objRememberedValue, new HorizontalAlignElement(Alignment.Companion.End), false, null, null, null, LastFMSettingsKt.lambda$1387155308, gapComposer14, 805306374, 508);
                    gapComposer14.end(true);
                    gapComposer14.end(true);
                }
                break;
            case 14:
                Composer composer15 = (Composer) obj2;
                int iIntValue15 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (!gapComposer15.shouldExecute(iIntValue15 & 1, (iIntValue15 & 17) != 16)) {
                    gapComposer15.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer15, 0, 0, 262142);
                }
                break;
            default:
                Composer composer16 = (Composer) obj2;
                int iIntValue16 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (!gapComposer16.shouldExecute(iIntValue16 & 1, (iIntValue16 & 17) != 16)) {
                    gapComposer16.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer16, 0, 0, 262142);
                }
                break;
        }
        return unit;
    }
}
