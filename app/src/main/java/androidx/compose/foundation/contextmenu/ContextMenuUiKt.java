package androidx.compose.foundation.contextmenu;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeElement;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda8;
import androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda13;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ContextMenuUiKt {
    public static final ContextMenuColors DefaultContextMenuColors;

    static {
        StaticProvidableCompositionLocal staticProvidableCompositionLocal = AndroidPopup_androidKt.LocalPopupTestTag;
        DefaultContextMenuColors = new ContextMenuColors(-4294967296L, -72057594037927936L, -72057594037927936L, ColorKt.Color(Color.m485getRedimpl(-72057594037927936L), Color.m484getGreenimpl(-72057594037927936L), Color.m482getBlueimpl(-72057594037927936L), 0.38f, Color.m483getColorSpaceimpl(-72057594037927936L)), ColorKt.Color(Color.m485getRedimpl(-72057594037927936L), Color.m484getGreenimpl(-72057594037927936L), Color.m482getBlueimpl(-72057594037927936L), 0.38f, Color.m483getColorSpaceimpl(-72057594037927936L)));
    }

    public static final void ContextMenuColumn(ContextMenuColors contextMenuColors, Modifier modifier, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        Modifier modifier2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-527864079);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(contextMenuColors) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            modifier2 = modifier;
            i2 |= gapComposer.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 256 : 128;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            BiasAlignment.Vertical vertical = ContextMenuSpec.LabelVerticalTextAlignment;
            Modifier modifierScroll$default = ImageKt.scroll$default(OffsetKt.m137paddingVpY3zN4$default(OffsetKt.width(ImageKt.m39backgroundbw27NRU(ClipKt.m399shadows4CzXII$default(modifier2, 3.0f, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(4.0f), 0L, 0L, 28), contextMenuColors.backgroundColor, ColorKt.RectangleShape), IntrinsicSize.Max), CropImageView.DEFAULT_ASPECT_RATIO, ContextMenuSpec.VerticalPadding, 1), ImageKt.rememberScrollState(gapComposer), true);
            int i3 = (i2 << 3) & 7168;
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierScroll$default);
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
            composableLambdaImpl.invoke(ColumnScopeInstance.INSTANCE, gapComposer, Integer.valueOf(((i3 >> 6) & 112) | 6));
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda0((byte) 1, i, (Object) contextMenuColors, (Object) modifier, (Object) composableLambdaImpl);
        }
    }

    public static final void ContextMenuColumnBuilder(Modifier modifier, ContextMenuColors contextMenuColors, Function1 function1, Composer composer, int i, int i2) {
        int i3;
        int i4;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-625529233);
        int i5 = i2 & 1;
        byte b = 2;
        if (i5 != 0) {
            i3 = i | 6;
        } else {
            i3 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i4 = i3 | 48;
        } else {
            i4 = i3 | (gapComposer.changed(contextMenuColors) ? 32 : 16);
        }
        int i7 = i4 | (gapComposer.changedInstance(function1) ? 256 : 128);
        if (gapComposer.shouldExecute(i7 & 1, (i7 & 147) != 146)) {
            if (i5 != 0) {
                modifier = Modifier.Companion.$$INSTANCE;
            }
            if (i6 != 0) {
                contextMenuColors = DefaultContextMenuColors;
            }
            ContextMenuColumn(contextMenuColors, modifier, Expect_jvmKt.rememberComposableLambda(-250345048, new AlbumMenuKt$$ExternalSyntheticLambda11(function1, contextMenuColors, b), gapComposer), gapComposer, ((i7 >> 3) & 14) | 384 | ((i7 << 3) & 112));
        } else {
            gapComposer.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        ContextMenuColors contextMenuColors2 = contextMenuColors;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SnackbarHostKt$$ExternalSyntheticLambda4(modifier2, contextMenuColors2, function1, i, i2);
        }
    }

    public static final void ContextMenuItem(String str, boolean z, ContextMenuColors contextMenuColors, Modifier modifier, Function3 function3, Function0 function0, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-2001167027);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(contextMenuColors) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(modifier) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changedInstance(function3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 131072 : 65536;
        }
        if (gapComposer.shouldExecute(i2 & 1, (74899 & i2) != 74898)) {
            BiasAlignment.Vertical vertical = ContextMenuSpec.LabelVerticalTextAlignment;
            float f = ContextMenuSpec.HorizontalPadding;
            Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
            boolean z2 = ((i2 & 112) == 32) | ((458752 & i2) == 131072);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z2 || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new ThumbnailKt$$ExternalSyntheticLambda13((byte) 1, function0, z);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.m153sizeInqDBjuR0(SizeKt.fillMaxWidth(ImageKt.m46clickableoSLSa3U$default(modifier, z, str, (Function0) objRememberedValue, 12), 1.0f), 112.0f, 48.0f, 280.0f, 48.0f), f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpacedAligned, vertical, gapComposer, 54);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM137paddingVpY3zN4$default);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z3 = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z3) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            if (function3 == null) {
                gapComposer.startReplaceGroup(-1597947094);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1597947093);
                float f2 = ContextMenuSpec.IconSize;
                Modifier modifierThen = Modifier.Companion.$$INSTANCE.then(new SizeElement(f2, (12 & 2) != 0 ? Float.NaN : CropImageView.DEFAULT_ASPECT_RATIO, (12 & 4) != 0 ? Float.NaN : f2, (12 & 8) != 0 ? Float.NaN : f2, false));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen);
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
                function3.invoke(new Color(z ? contextMenuColors.iconColor : contextMenuColors.disabledIconColor), gapComposer, 0);
                gapComposer.end(true);
                gapComposer.end(false);
            }
            long j = z ? contextMenuColors.textColor : contextMenuColors.disabledTextColor;
            BasicTextKt.m187BasicTextRWo7tUw(str, new LayoutWeightElement(1.0f, true), new TextStyle(j, ContextMenuSpec.FontSize, ContextMenuSpec.FontWeight, null, null, ContextMenuSpec.LetterSpacing, ContextMenuSpec.LabelHorizontalTextAlignment, ContextMenuSpec.LineHeight, null, null, 16613240), 0, false, 1, 0, gapComposer, (i2 & 14) | 1572864, 952);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new IconButtonKt$$ExternalSyntheticLambda8(str, z, contextMenuColors, modifier, function3, function0, i);
        }
    }
}
