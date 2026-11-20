package com.metrolist.music;

import android.content.Context;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
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
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import coil3.Extras;
import coil3.compose.AsyncImageKt;
import coil3.request.CachePolicy;
import coil3.request.ImageRequest;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.screens.settings.ChangelogScreenKt;
import com.yalantis.ucrop.R;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda6 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda6(String str, int i) {
        this.$r8$classId = (byte) 25;
        this.f$0 = str;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        Object objStringResource;
        Object objStringResource2;
        Object objStringResource3;
        byte b = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        String str = this.f$0;
        Unit unit = Unit.INSTANCE;
        boolean z = false;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int i = MainActivity.$r8$clinit;
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    CardKt.BadgedBox(Expect_jvmKt.rememberComposableLambda(1936300199, new MainActivity$$ExternalSyntheticLambda7(str, z ? (byte) 1 : (byte) 0), gapComposer), null, ComposableSingletons$MainActivityKt.lambda$1698199593, gapComposer, 390);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262142);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(1 & iIntValue3, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                }
                break;
            case 3:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(1 & iIntValue4, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262142);
                }
                break;
            case 4:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(1 & iIntValue5, (iIntValue5 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer5.consume(MaterialThemeKt._localMaterialTheme)).typography.headlineSmall, gapComposer5, 0, 24960, 110590);
                }
                break;
            case 5:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(1 & iIntValue6, (iIntValue6 & 3) != 2)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, SizeKt.fillMaxWidth(companion, 1.0f), 0L, 0L, null, null, null, 0L, new TextAlign(5), 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer6.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium, gapComposer6, 48, 24960, 109564);
                }
                break;
            case 6:
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(1 & iIntValue7, (iIntValue7 & 3) != 2)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(this.f$0, null, ((MaterialTheme$Values) gapComposer7.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer7.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer7, 0, 24960, 110586);
                }
                break;
            case 7:
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(1 & iIntValue8, (iIntValue8 & 3) != 2)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer8.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium, gapComposer8, 0, 24960, 110590);
                }
                break;
            case 8:
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (!gapComposer9.shouldExecute(1 & iIntValue9, (iIntValue9 & 3) != 2)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(this.f$0, null, ((MaterialTheme$Values) gapComposer9.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer9.consume(staticProvidableCompositionLocal2)).typography.bodySmall, gapComposer9, 0, 24960, 110586);
                }
                break;
            case 9:
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (!gapComposer10.shouldExecute(1 & iIntValue10, (iIntValue10 & 3) != 2)) {
                    gapComposer10.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer10.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium, gapComposer10, 0, 24960, 110590);
                }
                break;
            case 10:
                Composer composer11 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (!gapComposer11.shouldExecute(1 & iIntValue11, (iIntValue11 & 3) != 2)) {
                    gapComposer11.skipToGroupEnd();
                } else {
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(this.f$0, null, ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal3)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal3)).typography.bodySmall, gapComposer11, 0, 24960, 110586);
                }
                break;
            case 11:
                Composer composer12 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (!gapComposer12.shouldExecute(1 & iIntValue12, (iIntValue12 & 3) != 2)) {
                    gapComposer12.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer12.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium, gapComposer12, 0, 24960, 110590);
                }
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Composer composer13 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (!gapComposer13.shouldExecute(1 & iIntValue13, (iIntValue13 & 3) != 2)) {
                    gapComposer13.skipToGroupEnd();
                } else {
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(this.f$0, null, ((MaterialTheme$Values) gapComposer13.consume(staticProvidableCompositionLocal4)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer13.consume(staticProvidableCompositionLocal4)).typography.bodySmall, gapComposer13, 0, 24960, 110586);
                }
                break;
            case 13:
                Composer composer14 = (Composer) obj;
                int iIntValue14 = ((Integer) obj2).intValue();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (!gapComposer14.shouldExecute(1 & iIntValue14, (iIntValue14 & 3) != 2)) {
                    gapComposer14.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer14, 0, 0, 262142);
                }
                break;
            case 14:
                Composer composer15 = (Composer) obj;
                int iIntValue15 = ((Integer) obj2).intValue();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (!gapComposer15.shouldExecute(1 & iIntValue15, (iIntValue15 & 3) != 2)) {
                    gapComposer15.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer15, 0, 0, 262142);
                }
                break;
            case 15:
                Composer composer16 = (Composer) obj;
                int iIntValue16 = ((Integer) obj2).intValue();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (!gapComposer16.shouldExecute(1 & iIntValue16, (iIntValue16 & 3) != 2)) {
                    gapComposer16.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer16, 0, 0, 262142);
                }
                break;
            case 16:
                Composer composer17 = (Composer) obj;
                int iIntValue17 = ((Integer) obj2).intValue();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (!gapComposer17.shouldExecute(1 & iIntValue17, (iIntValue17 & 3) != 2)) {
                    gapComposer17.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer17, 0, 0, 262142);
                }
                break;
            case 17:
                Composer composer18 = (Composer) obj;
                int iIntValue18 = ((Integer) obj2).intValue();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (!gapComposer18.shouldExecute(iIntValue18 & 1, (iIntValue18 & 3) != 2)) {
                    gapComposer18.skipToGroupEnd();
                } else {
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    FlowRowOverflow flowRowOverflow = OffsetKt.Center;
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 12.0f);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer18, 54);
                    int iHashCode = Long.hashCode(gapComposer18.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer18.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer18, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer18.startReusableNode();
                    if (gapComposer18.inserting) {
                        gapComposer18.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer18.useNode();
                    }
                    Stack.m390setimpl(gapComposer18, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer18, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer18, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer18);
                    Stack.m390setimpl(gapComposer18, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    Painter painterPainterResource = IntMath.painterResource(R.drawable.error, 0, gapComposer18);
                    Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, 18.0f);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal5 = MaterialThemeKt._localMaterialTheme;
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, modifierM151size3ABfNKs, ((MaterialTheme$Values) gapComposer18.consume(staticProvidableCompositionLocal5)).colorScheme.error, gapComposer18, 440, 0);
                    OffsetKt.Spacer(gapComposer18, SizeKt.m155width3ABfNKs(companion, 8.0f));
                    TextKt.m352TextNvy7gAk(this.f$0, null, ((MaterialTheme$Values) gapComposer18.consume(staticProvidableCompositionLocal5)).colorScheme.error, 0L, null, FontWeight.Medium, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer18.consume(staticProvidableCompositionLocal5)).typography.bodyMedium, gapComposer18, 1572864, 0, 131002);
                    gapComposer18.end(true);
                }
                break;
            case 18:
                Composer composer19 = (Composer) obj;
                int iIntValue19 = ((Integer) obj2).intValue();
                GapComposer gapComposer19 = (GapComposer) composer19;
                if (!gapComposer19.shouldExecute(iIntValue19 & 1, (iIntValue19 & 3) != 2)) {
                    gapComposer19.skipToGroupEnd();
                } else if (str == null) {
                    gapComposer19.startReplaceGroup(2038246279);
                    Painter painterPainterResource2 = IntMath.painterResource(R.drawable.person, 0, gapComposer19);
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    IconKt.m290Iconww6aTOc(painterPainterResource2, (String) null, SizeKt.m151size3ABfNKs(companion, 48.0f), 0L, gapComposer19, 56, 8);
                    gapComposer19.end(false);
                } else {
                    gapComposer19.startReplaceGroup(2036890742);
                    ImageRequest.Builder builder = new ImageRequest.Builder((Context) gapComposer19.consume(AndroidCompositionLocals_androidKt.LocalContext));
                    builder.data = str;
                    builder.diskCachePolicy = CachePolicy.ENABLED;
                    builder.diskCacheKey = str;
                    Extras.Key key = ImageRequestsKt.transformationsKey;
                    ImageRequests_androidKt.crossfade(builder, 0);
                    ImageRequest imageRequestBuild = builder.build();
                    Painter painterPainterResource3 = IntMath.painterResource(R.drawable.person, 0, gapComposer19);
                    Painter painterPainterResource4 = IntMath.painterResource(R.drawable.person, 0, gapComposer19);
                    SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
                    AsyncImageKt.m851AsyncImagex1rPTaM(imageRequestBuild, ClipKt.clip(SizeKt.m151size3ABfNKs(companion, 48.0f), RoundedCornerShapeKt.CircleShape), painterPainterResource3, painterPainterResource4, ContentScale.Companion.Crop, gapComposer19, 6);
                    gapComposer19.end(false);
                }
                break;
            case 19:
                Composer composer20 = (Composer) obj;
                int iIntValue20 = ((Integer) obj2).intValue();
                GapComposer gapComposer20 = (GapComposer) composer20;
                if (!gapComposer20.shouldExecute(iIntValue20 & 1, (iIntValue20 & 3) != 2)) {
                    gapComposer20.skipToGroupEnd();
                } else {
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.CenterHorizontally, gapComposer20, 48);
                    int iHashCode2 = Long.hashCode(gapComposer20.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer20.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer20, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer20.startReusableNode();
                    if (gapComposer20.inserting) {
                        gapComposer20.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer20.useNode();
                    }
                    Stack.m390setimpl(gapComposer20, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer20, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer20, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer20);
                    Stack.m390setimpl(gapComposer20, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.manage_user, gapComposer20), null, 0L, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer20, 1572864, 0, 262078);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal6 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(this.f$0, null, ((MaterialTheme$Values) gapComposer20.consume(staticProvidableCompositionLocal6)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer20.consume(staticProvidableCompositionLocal6)).typography.bodyMedium, gapComposer20, 0, 0, 131066);
                    gapComposer20.end(true);
                }
                break;
            case 20:
                Composer composer21 = (Composer) obj;
                int iIntValue21 = ((Integer) obj2).intValue();
                GapComposer gapComposer21 = (GapComposer) composer21;
                if (!gapComposer21.shouldExecute(iIntValue21 & 1, (iIntValue21 & 3) != 2)) {
                    gapComposer21.skipToGroupEnd();
                } else {
                    BiasAlignment.Vertical vertical2 = Alignment.Companion.CenterVertically;
                    FlowRowOverflow flowRowOverflow2 = OffsetKt.Center;
                    Modifier modifierM135padding3ABfNKs2 = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(flowRowOverflow2, vertical2, gapComposer21, 54);
                    int iHashCode3 = Long.hashCode(gapComposer21.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer21.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer21, modifierM135padding3ABfNKs2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer21.startReusableNode();
                    if (gapComposer21.inserting) {
                        gapComposer21.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer21.useNode();
                    }
                    Stack.m390setimpl(gapComposer21, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer21, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer21, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer21);
                    Stack.m390setimpl(gapComposer21, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    Modifier modifierM151size3ABfNKs2 = SizeKt.m151size3ABfNKs(companion, 20.0f);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal7 = MaterialThemeKt._localMaterialTheme;
                    DialogKt.m1464CircularProgressIndicatorLxG7B9w(2.0f, 0, 390, 24, ((MaterialTheme$Values) gapComposer21.consume(staticProvidableCompositionLocal7)).colorScheme.primary, 0L, gapComposer21, modifierM151size3ABfNKs2);
                    OffsetKt.Spacer(gapComposer21, SizeKt.m155width3ABfNKs(companion, 12.0f));
                    TextKt.m352TextNvy7gAk(this.f$0, null, ((MaterialTheme$Values) gapComposer21.consume(staticProvidableCompositionLocal7)).colorScheme.onPrimaryContainer, 0L, null, FontWeight.Medium, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer21.consume(staticProvidableCompositionLocal7)).typography.bodyMedium, gapComposer21, 1572864, 0, 129978);
                    gapComposer21.end(true);
                }
                break;
            case 21:
                Composer composer22 = (Composer) obj;
                int iIntValue22 = ((Integer) obj2).intValue();
                GapComposer gapComposer22 = (GapComposer) composer22;
                if (!gapComposer22.shouldExecute(iIntValue22 & 1, (iIntValue22 & 3) != 2)) {
                    gapComposer22.skipToGroupEnd();
                } else {
                    BiasAlignment.Vertical vertical3 = Alignment.Companion.CenterVertically;
                    FlowRowOverflow flowRowOverflow3 = OffsetKt.Center;
                    Modifier modifierM135padding3ABfNKs3 = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f);
                    RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(flowRowOverflow3, vertical3, gapComposer22, 54);
                    int iHashCode4 = Long.hashCode(gapComposer22.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer22.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer22, modifierM135padding3ABfNKs3);
                    ComposeUiNode.Companion.getClass();
                    gapComposer22.startReusableNode();
                    if (gapComposer22.inserting) {
                        gapComposer22.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer22.useNode();
                    }
                    Stack.m390setimpl(gapComposer22, rowMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer22, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer22, Integer.valueOf(iHashCode4), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer22);
                    Stack.m390setimpl(gapComposer22, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                    Painter painterPainterResource5 = IntMath.painterResource(R.drawable.error, 0, gapComposer22);
                    Modifier modifierM151size3ABfNKs3 = SizeKt.m151size3ABfNKs(companion, 20.0f);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal8 = MaterialThemeKt._localMaterialTheme;
                    IconKt.m290Iconww6aTOc(painterPainterResource5, (String) null, modifierM151size3ABfNKs3, ((MaterialTheme$Values) gapComposer22.consume(staticProvidableCompositionLocal8)).colorScheme.onErrorContainer, gapComposer22, 440, 0);
                    OffsetKt.Spacer(gapComposer22, SizeKt.m155width3ABfNKs(companion, 12.0f));
                    if (str == null) {
                        str = "";
                    }
                    TextKt.m352TextNvy7gAk(str, null, ((MaterialTheme$Values) gapComposer22.consume(staticProvidableCompositionLocal8)).colorScheme.onErrorContainer, 0L, null, FontWeight.Medium, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer22.consume(staticProvidableCompositionLocal8)).typography.bodyMedium, gapComposer22, 1572864, 0, 129978);
                    gapComposer22.end(true);
                }
                break;
            case 22:
                Composer composer23 = (Composer) obj;
                int iIntValue23 = ((Integer) obj2).intValue();
                GapComposer gapComposer23 = (GapComposer) composer23;
                if (!gapComposer23.shouldExecute(1 & iIntValue23, (iIntValue23 & 3) != 2)) {
                    gapComposer23.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer23, 0, 0, 262142);
                }
                break;
            case 23:
                Composer composer24 = (Composer) obj;
                int iIntValue24 = ((Integer) obj2).intValue();
                GapComposer gapComposer24 = (GapComposer) composer24;
                if (!gapComposer24.shouldExecute(1 & iIntValue24, (iIntValue24 & 3) != 2)) {
                    gapComposer24.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer24, 0, 0, 262142);
                }
                break;
            case 24:
                Composer composer25 = (Composer) obj;
                int iIntValue25 = ((Integer) obj2).intValue();
                GapComposer gapComposer25 = (GapComposer) composer25;
                if (!gapComposer25.shouldExecute(1 & iIntValue25, (iIntValue25 & 3) != 2)) {
                    gapComposer25.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer25, 0, 0, 262142);
                }
                break;
            case 25:
                ((Integer) obj2).getClass();
                ChangelogScreenKt.MarkdownText(str, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 26:
                Composer composer26 = (Composer) obj;
                int iIntValue26 = ((Integer) obj2).intValue();
                GapComposer gapComposer26 = (GapComposer) composer26;
                if (!gapComposer26.shouldExecute(iIntValue26 & 1, (iIntValue26 & 3) != 2)) {
                    gapComposer26.skipToGroupEnd();
                } else {
                    gapComposer26.startReplaceGroup(1565011011);
                    Object obj3 = PreferenceKeysKt.LanguageCodeToName.get(str);
                    if (obj3 == null) {
                        objStringResource = obj3;
                        objStringResource = MathKt.stringResource(R.string.system_default, gapComposer26);
                    }
                    objStringResource = obj3;
                    gapComposer26.end(false);
                    TextKt.m352TextNvy7gAk((String) objStringResource, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer26, 0, 0, 262142);
                }
                break;
            case 27:
                Composer composer27 = (Composer) obj;
                int iIntValue27 = ((Integer) obj2).intValue();
                GapComposer gapComposer27 = (GapComposer) composer27;
                if (!gapComposer27.shouldExecute(iIntValue27 & 1, (iIntValue27 & 3) != 2)) {
                    gapComposer27.skipToGroupEnd();
                } else {
                    gapComposer27.startReplaceGroup(-194348893);
                    Object obj4 = PreferenceKeysKt.CountryCodeToName.get(str);
                    if (obj4 == null) {
                        objStringResource2 = obj4;
                        objStringResource2 = MathKt.stringResource(R.string.system_default, gapComposer27);
                    }
                    objStringResource2 = obj4;
                    gapComposer27.end(false);
                    TextKt.m352TextNvy7gAk((String) objStringResource2, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer27, 0, 0, 262142);
                }
                break;
            case 28:
                Composer composer28 = (Composer) obj;
                int iIntValue28 = ((Integer) obj2).intValue();
                GapComposer gapComposer28 = (GapComposer) composer28;
                if (!gapComposer28.shouldExecute(iIntValue28 & 1, (iIntValue28 & 3) != 2)) {
                    gapComposer28.skipToGroupEnd();
                } else {
                    gapComposer28.startReplaceGroup(448731553);
                    Object obj5 = PreferenceKeysKt.LanguageCodeToName.get(str);
                    if (obj5 == null) {
                        objStringResource3 = obj5;
                        objStringResource3 = MathKt.stringResource(R.string.system_default, gapComposer28);
                    }
                    objStringResource3 = obj5;
                    gapComposer28.end(false);
                    TextKt.m352TextNvy7gAk((String) objStringResource3, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer28, 0, 0, 262142);
                }
                break;
            default:
                Composer composer29 = (Composer) obj;
                int iIntValue29 = ((Integer) obj2).intValue();
                GapComposer gapComposer29 = (GapComposer) composer29;
                if (!gapComposer29.shouldExecute(1 & iIntValue29, (iIntValue29 & 3) != 2)) {
                    gapComposer29.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(this.f$0, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer29, 0, 0, 262142);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda6(String str, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
    }
}
