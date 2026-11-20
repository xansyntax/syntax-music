package com.metrolist.music.ui.component;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.google.common.math.IntMath;
import com.metrolist.music.lyrics.LyricsTranslationHelper;
import com.yalantis.ucrop.R;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class OriginalLyricsKt$$ExternalSyntheticLambda21 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ LyricsTranslationHelper.TranslationStatus f$0;

    public /* synthetic */ OriginalLyricsKt$$ExternalSyntheticLambda21(LyricsTranslationHelper.TranslationStatus translationStatus, byte b) {
        this.$r8$classId = b;
        this.f$0 = translationStatus;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x013e  */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) throws XmlPullParserException, IOException {
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        LyricsTranslationHelper.TranslationStatus translationStatus = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(companion, 16.0f, 8.0f);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterVertically, gapComposer, 54);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM136paddingVpY3zN4);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    Painter painterPainterResource = IntMath.painterResource(R.drawable.error, 0, gapComposer);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onErrorContainer, gapComposer, 440, 0);
                    TextKt.m352TextNvy7gAk(((LyricsTranslationHelper.TranslationStatus.Error) translationStatus).message, null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onErrorContainer, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.labelMedium, gapComposer, 0, 0, 131066);
                    gapComposer.end(true);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else if (translationStatus == null) {
                    gapComposer2.startReplaceGroup(-269914564);
                    gapComposer2.end(false);
                } else if (translationStatus instanceof LyricsTranslationHelper.TranslationStatus.Translating) {
                    gapComposer2.startReplaceGroup(-272053781);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    MenuKt.m1494TranslationCarddgg9oW8(((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.primaryContainer, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.onPrimaryContainer, DialogKt.f28lambda$2215896, gapComposer2, 384);
                    gapComposer2.end(false);
                } else if (translationStatus instanceof LyricsTranslationHelper.TranslationStatus.Error) {
                    gapComposer2.startReplaceGroup(-271272953);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                    MenuKt.m1494TranslationCarddgg9oW8(((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal3)).colorScheme.errorContainer, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal3)).colorScheme.onErrorContainer, Expect_jvmKt.rememberComposableLambda(-1872632303, new OriginalLyricsKt$$ExternalSyntheticLambda21(translationStatus, (byte) 2), gapComposer2), gapComposer2, 384);
                    gapComposer2.end(false);
                } else if (!(translationStatus instanceof LyricsTranslationHelper.TranslationStatus.Success)) {
                    gapComposer2.startReplaceGroup(-269914564);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.startReplaceGroup(-270577406);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = MaterialThemeKt._localMaterialTheme;
                    MenuKt.m1494TranslationCarddgg9oW8(((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal4)).colorScheme.tertiaryContainer, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal4)).colorScheme.onTertiaryContainer, DialogKt.lambda$1988371312, gapComposer2, 384);
                    gapComposer2.end(false);
                }
                break;
            default:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.error, 0, gapComposer3), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer3, 440, 8);
                    TextKt.m352TextNvy7gAk(((LyricsTranslationHelper.TranslationStatus.Error) translationStatus).message, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).typography.labelMedium, gapComposer3, 0, 0, 131070);
                }
                break;
        }
        return unit;
    }
}
