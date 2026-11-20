package com.metrolist.music.ui.screens.settings;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidComposeView;
import coil3.size.ViewSizeResolver$size$3$1;
import com.google.common.math.IntMath;
import com.metrolist.music.ui.component.Material3SettingsItem;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.screens.AccountScreenKt$AccountScreen$1$1$11$1$1;
import com.metrolist.music.ui.screens.search.OnlineSearchScreenKt;
import com.metrolist.music.ui.screens.search.OnlineSearchScreenKt$OnlineSearchScreen$3$1$7$2$1;
import com.yalantis.ucrop.R;
import dev.chrisbanes.haze.RenderScriptBlurEffect$updateSurface$2$4;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.List;
import kotlin.Function;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import org.xmlpull.v1.XmlPullParserException;
import sh.calvin.reorderable.DragGestureDetector$Press;
import sh.calvin.reorderable.ReorderableCollectionItemScopeImpl;
import sh.calvin.reorderable.ReorderableCollectionItemScopeImpl$draggableHandle$1;
import sh.calvin.reorderable.Scroller$ScrollInfo$Companion$Null$1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidAutoSettingsKt$AndroidAutoSettings$2$1$1$2$1 implements Function4 {
    public final /* synthetic */ boolean $enabled;
    public final /* synthetic */ Object $haptic;
    public final /* synthetic */ Function $onSectionsChange;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $section;
    public final /* synthetic */ Object $sections$delegate;

    public /* synthetic */ AndroidAutoSettingsKt$AndroidAutoSettings$2$1$1$2$1(Object obj, Object obj2, Function function, Object obj3, boolean z, byte b) {
        this.$r8$classId = b;
        this.$section = obj;
        this.$sections$delegate = obj2;
        this.$onSectionsChange = function;
        this.$haptic = obj3;
        this.$enabled = z;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) throws XmlPullParserException, IOException {
        int i;
        int i2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj5 = this.$section;
        Object obj6 = this.$sections$delegate;
        Function function = this.$onSectionsChange;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Object obj7 = this.$haptic;
        switch (b) {
            case 0:
                final ReorderableCollectionItemScopeImpl reorderableCollectionItemScopeImpl = (ReorderableCollectionItemScopeImpl) obj;
                ((Boolean) obj2).getClass();
                Composer composer = (Composer) obj3;
                int iIntValue = ((Number) obj4).intValue();
                final MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) function;
                final MutableState mutableState = (MutableState) obj6;
                final AndroidAutoSection androidAutoSection = (AndroidAutoSection) obj5;
                reorderableCollectionItemScopeImpl.getClass();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= ((GapComposer) composer).changed(reorderableCollectionItemScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 131) != 130)) {
                    gapComposer.skipToGroupEnd();
                    return unit;
                }
                int iOrdinal = androidAutoSection.ordinal();
                if (iOrdinal == 0) {
                    i = R.drawable.favorite;
                } else if (iOrdinal == 1) {
                    i = R.drawable.music_note;
                } else if (iOrdinal == 2) {
                    i = R.drawable.artist;
                } else if (iOrdinal == 3) {
                    i = R.drawable.album;
                } else {
                    if (iOrdinal != 4) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    i = R.drawable.queue_music;
                }
                Painter painterPainterResource = IntMath.painterResource(i, 0, gapComposer);
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(402751192, new AndroidComposeView.AndroidComposeViewNavigationSoundEffect((byte) 1, androidAutoSection), gapComposer);
                final HapticFeedback hapticFeedback = (HapticFeedback) obj7;
                final boolean z = this.$enabled;
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(-338744554, new Function2() { // from class: com.metrolist.music.ui.screens.settings.AndroidAutoSettingsKt$AndroidAutoSettings$2$1$1$2$1.2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        Composer composer2 = (Composer) obj8;
                        int iIntValue2 = ((Number) obj9).intValue();
                        GapComposer gapComposer2 = (GapComposer) composer2;
                        if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
                            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, companion);
                            ComposeUiNode.Companion.getClass();
                            gapComposer2.startReusableNode();
                            if (gapComposer2.inserting) {
                                gapComposer2.createNode(LayoutNode.Constructor);
                            } else {
                                gapComposer2.useNode();
                            }
                            Stack.m390setimpl(gapComposer2, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                            Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                            Stack.m389reconcileimpl(gapComposer2);
                            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                            Painter painterPainterResource2 = IntMath.painterResource(R.drawable.drag_handle, 0, gapComposer2);
                            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, 24.0f);
                            HapticFeedback hapticFeedback2 = hapticFeedback;
                            boolean zChangedInstance = gapComposer2.changedInstance(hapticFeedback2);
                            Object objRememberedValue = gapComposer2.rememberedValue();
                            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                            if (zChangedInstance || objRememberedValue == neverEqualPolicy2) {
                                objRememberedValue = new RenderScriptBlurEffect$updateSurface$2$4((byte) 4, hapticFeedback2);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            Function1 function1 = (Function1) objRememberedValue;
                            Scroller$ScrollInfo$Companion$Null$1 scroller$ScrollInfo$Companion$Null$1 = Scroller$ScrollInfo$Companion$Null$1.INSTANCE$2;
                            modifierM151size3ABfNKs.getClass();
                            function1.getClass();
                            IconKt.m290Iconww6aTOc(painterPainterResource2, (String) null, modifierM151size3ABfNKs.then(new ComposedModifier(new ReorderableCollectionItemScopeImpl$draggableHandle$1(reorderableCollectionItemScopeImpl, DragGestureDetector$Press.INSTANCE$1, function1, scroller$ScrollInfo$Companion$Null$1))), ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant, gapComposer2, 56, 0);
                            OffsetKt.Spacer(gapComposer2, SizeKt.m155width3ABfNKs(companion, 12.0f));
                            MutableState mutableState2 = mutableState;
                            boolean zChanged = gapComposer2.changed(mutableState2);
                            AndroidAutoSection androidAutoSection2 = androidAutoSection;
                            boolean zChanged2 = zChanged | gapComposer2.changed(androidAutoSection2.ordinal());
                            MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda1 = mimesKt$$ExternalSyntheticLambda0;
                            boolean zChanged3 = zChanged2 | gapComposer2.changed(mimesKt$$ExternalSyntheticLambda1);
                            Object objRememberedValue2 = gapComposer2.rememberedValue();
                            if (zChanged3 || objRememberedValue2 == neverEqualPolicy2) {
                                objRememberedValue2 = new ViewSizeResolver$size$3$1(mimesKt$$ExternalSyntheticLambda1, mutableState2, androidAutoSection2, (byte) 4);
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            }
                            Function1 function2 = (Function1) objRememberedValue2;
                            final boolean z2 = z;
                            MenuKt.Switch(z2, function2, null, Expect_jvmKt.rememberComposableLambda(871454830, new Function2() { // from class: com.metrolist.music.ui.screens.settings.AndroidAutoSettingsKt$AndroidAutoSettings$2$1$1$2$1$2$1$3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj10, Object obj11) {
                                    Composer composer3 = (Composer) obj10;
                                    int iIntValue3 = ((Number) obj11).intValue();
                                    GapComposer gapComposer3 = (GapComposer) composer3;
                                    if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                                        IconKt.m290Iconww6aTOc(IntMath.painterResource(z2 ? R.drawable.check : R.drawable.close, 0, gapComposer3), (String) null, SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 16.0f), 0L, gapComposer3, 56, 8);
                                    } else {
                                        gapComposer3.skipToGroupEnd();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, gapComposer2), false, null, gapComposer2, 3072, 116);
                            gapComposer2.end(true);
                        } else {
                            gapComposer2.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer);
                boolean zChanged = gapComposer.changed(mutableState) | gapComposer.changed(androidAutoSection.ordinal()) | gapComposer.changed(mimesKt$$ExternalSyntheticLambda0);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new AccountScreenKt$AccountScreen$1$1$11$1$1((Object) mimesKt$$ExternalSyntheticLambda0, (Object) mutableState, (Object) androidAutoSection, (byte) 9);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                MenuKt.Material3SettingsGroup(null, CollectionsKt__IterablesKt.listOf(new Material3SettingsItem(painterPainterResource, composableLambdaImplRememberComposableLambda, null, composableLambdaImplRememberComposableLambda2, false, false, (Function0) objRememberedValue, 234)), null, gapComposer, 64, 13);
                return unit;
            default:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                Composer composer2 = (Composer) obj3;
                int iIntValue3 = ((Number) obj4).intValue();
                Function1 function1 = (Function1) obj7;
                Function0 function0 = (Function0) function;
                Function1 function2 = (Function1) obj6;
                if ((iIntValue3 & 6) == 0) {
                    i2 = iIntValue3 | (((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2);
                } else {
                    i2 = iIntValue3;
                }
                if ((iIntValue3 & 48) == 0) {
                    i2 |= ((GapComposer) composer2).changed(iIntValue2) ? 32 : 16;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    String str = (String) ((List) obj5).get(iIntValue2);
                    gapComposer2.startReplaceGroup(-728969950);
                    boolean zChanged2 = gapComposer2.changed(function2) | gapComposer2.changed(str) | gapComposer2.changed(function0);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new AccountScreenKt$AccountScreen$1$1$11$1$1((Object) function2, (Object) str, (Object) function0, (byte) 7);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    Function0 function3 = (Function0) objRememberedValue2;
                    boolean zChanged3 = gapComposer2.changed(function1) | gapComposer2.changed(str);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new OnlineSearchScreenKt$OnlineSearchScreen$3$1$7$2$1((byte) 0, str, function1);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    OnlineSearchScreenKt.SuggestionItem(null, str, true, function3, null, (Function0) objRememberedValue3, this.$enabled, gapComposer2, 384, 17);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
        }
    }
}
