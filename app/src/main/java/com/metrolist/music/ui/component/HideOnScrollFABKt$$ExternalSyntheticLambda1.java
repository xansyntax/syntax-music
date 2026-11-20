package com.metrolist.music.ui.component;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.FloatingActionButtonElevation;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.navigation.NavHostController;
import com.metrolist.innertube.pages.MoodAndGenres;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HideOnScrollFABKt$$ExternalSyntheticLambda1 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ HideOnScrollFABKt$$ExternalSyntheticLambda1(Function0 function0, Function0 function1, int i) {
        this.$r8$classId = (byte) 0;
        this.f$0 = function0;
        this.f$1 = function1;
        this.f$2 = i;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        GapComposer gapComposer;
        long j;
        boolean z;
        Modifier modifierM151size3ABfNKs;
        byte b = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.f$1;
        int i = this.f$2;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                Function0 function0 = (Function0) obj5;
                Function0 function1 = (Function0) obj4;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer;
                if (!gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 16.0f);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, horizontal, gapComposer2, 48);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    if (function0 != null) {
                        gapComposer2.startReplaceGroup(-319476994);
                        if (UiStyleKt.isGlassStyle(gapComposer2)) {
                            gapComposer2.startReplaceGroup(1652266304);
                            gapComposer2.end(false);
                            j = 0;
                        } else {
                            gapComposer2.startReplaceGroup(1652267689);
                            j = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainerHigh;
                            gapComposer2.end(false);
                        }
                        long j2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface;
                        RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = UiStyleKt.isGlassStyle(gapComposer2) ? RoundedCornerShapeKt.CircleShape : RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                        FloatingActionButtonElevation floatingActionButtonElevation = new FloatingActionButtonElevation(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                        if (UiStyleKt.isGlassStyle(gapComposer2)) {
                            gapComposer2.startReplaceGroup(1652278870);
                            modifierM151size3ABfNKs = GlassComponentsKt.glass(SizeKt.m151size3ABfNKs(companion, 48.0f), RoundedCornerShapeKt.CircleShape, true, gapComposer2, 390, 0);
                            gapComposer = gapComposer2;
                            z = false;
                            gapComposer.end(false);
                        } else {
                            gapComposer = gapComposer2;
                            z = false;
                            gapComposer.startReplaceGroup(1652280384);
                            gapComposer.end(false);
                            modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, 40.0f);
                        }
                        CardKt.m265SmallFloatingActionButtonXz6DiA(function0, modifierM151size3ABfNKs, roundedCornerShapeM185RoundedCornerShape0680j_4, j, j2, floatingActionButtonElevation, DialogKt.lambda$1502905431, gapComposer, 12582912, 64);
                        OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 12.0f));
                        gapComposer.end(z);
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.startReplaceGroup(-318540019);
                        gapComposer.end(false);
                    }
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    CardKt.m259FloatingActionButtonXz6DiA(function1, null, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(20.0f, 12.0f, gapComposer)), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onPrimary, new FloatingActionButtonElevation(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO), Expect_jvmKt.rememberComposableLambda(-516182669, new HideOnScrollFABKt$$ExternalSyntheticLambda3((byte) 0, i), gapComposer), gapComposer, 12582912, 66);
                    gapComposer.end(true);
                }
                break;
            case 1:
                Pair pair = (Pair) obj5;
                MutableState mutableState = (MutableState) obj4;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer2;
                if (!gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    String str = (String) pair.first;
                    String str2 = (String) pair.second;
                    boolean zChanged = gapComposer3.changed(i);
                    Object objRememberedValue = gapComposer3.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new SettingsSleepTimerDialogKt$$ExternalSyntheticLambda34(i, mutableState, (byte) 1);
                        gapComposer3.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function2 = (Function0) objRememberedValue;
                    boolean zChanged2 = gapComposer3.changed(i);
                    Object objRememberedValue2 = gapComposer3.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new SettingsSleepTimerDialogKt$$ExternalSyntheticLambda34(i, mutableState, (byte) 2);
                        gapComposer3.updateRememberedValue(objRememberedValue2);
                    }
                    SettingsSleepTimerDialogKt.TimeRangeRow(str, str2, function2, (Function0) objRememberedValue2, OffsetKt.m139paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, 7), gapComposer3, 24576, 0);
                }
                break;
            default:
                MoodAndGenres moodAndGenres = (MoodAndGenres) obj5;
                NavHostController navHostController = (NavHostController) obj4;
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                lazyItemScopeImpl.getClass();
                boolean z2 = true;
                if ((iIntValue3 & 6) == 0) {
                    iIntValue3 |= ((GapComposer) composer3).changed(lazyItemScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer4 = (GapComposer) composer3;
                if (!gapComposer4.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), 6.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer4, 0);
                    int iHashCode2 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM137paddingVpY3zN4$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer4.startReusableNode();
                    if (gapComposer4.inserting) {
                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer4.useNode();
                    }
                    Stack.m390setimpl(gapComposer4, columnMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer4);
                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    MenuKt.NavigationTitle(moodAndGenres.title, null, null, null, null, null, gapComposer4, 0, 62);
                    gapComposer4.startReplaceGroup(-541074544);
                    ArrayList arrayListChunked = CollectionsKt.chunked(i, moodAndGenres.items);
                    int size = arrayListChunked.size();
                    int i2 = 0;
                    while (i2 < size) {
                        List list = (List) arrayListChunked.get(i2);
                        ArrayList arrayList = arrayListChunked;
                        int i3 = size;
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer4, 0);
                        int i4 = i2 + 1;
                        int iHashCode3 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer4.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer4, companion);
                        ComposeUiNode.Companion.getClass();
                        gapComposer4.startReusableNode();
                        if (gapComposer4.inserting) {
                            gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer4.useNode();
                        }
                        Stack.m390setimpl(gapComposer4, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                        Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                        Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda2);
                        Stack.m389reconcileimpl(gapComposer4);
                        Stack.m390setimpl(gapComposer4, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                        gapComposer4.startReplaceGroup(1169547410);
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            MoodAndGenres.Item item = (MoodAndGenres.Item) it.next();
                            String str3 = item.title;
                            boolean zChangedInstance = gapComposer4.changedInstance(navHostController) | gapComposer4.changedInstance(item);
                            Iterator it2 = it;
                            Object objRememberedValue3 = gapComposer4.rememberedValue();
                            if (zChangedInstance || objRememberedValue3 == neverEqualPolicy) {
                                objRememberedValue3 = new QueueKt$$ExternalSyntheticLambda16(navHostController, item, (byte) 10);
                                gapComposer4.updateRememberedValue(objRememberedValue3);
                            }
                            Function0 function3 = (Function0) objRememberedValue3;
                            int i5 = i4;
                            if (1.0f <= 0.0d) {
                                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                            }
                            AlbumScreenKt.MoodAndGenresButton(str3, function3, OffsetKt.m135padding3ABfNKs(new LayoutWeightElement(1.0f > Float.MAX_VALUE ? Float.MAX_VALUE : 1.0f, z2), 6.0f), gapComposer4, 0);
                            it = it2;
                            i4 = i5;
                            z2 = true;
                        }
                        int i6 = i4;
                        gapComposer4.end(false);
                        gapComposer4.startReplaceGroup(1169567123);
                        int size2 = i - list.size();
                        int i7 = 0;
                        while (i7 < size2) {
                            int i8 = i7;
                            if (1.0f <= 0.0d) {
                                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                            }
                            OffsetKt.Spacer(gapComposer4, new LayoutWeightElement(1.0f > Float.MAX_VALUE ? Float.MAX_VALUE : 1.0f, true));
                            i7 = i8 + 1;
                        }
                        gapComposer4.end(false);
                        gapComposer4.end(true);
                        arrayListChunked = arrayList;
                        size = i3;
                        z2 = true;
                        i2 = i6;
                    }
                    gapComposer4.end(false);
                    gapComposer4.end(z2);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ HideOnScrollFABKt$$ExternalSyntheticLambda1(Object obj, int i, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$2 = i;
        this.f$1 = obj2;
    }
}
