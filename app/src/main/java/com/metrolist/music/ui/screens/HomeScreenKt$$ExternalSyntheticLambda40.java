package com.metrolist.music.ui.screens;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.RippleKt;
import androidx.compose.material3.RippleNodeFactory;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
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
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.navigation.NavHostController;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.pages.HomePage;
import com.metrolist.music.constants.PlaylistSongSortType;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.SortHeaderKt$SortHeader$1$2$1;
import com.metrolist.music.ui.component.SortHeaderKt$SortHeader$1$5;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda24;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda39;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda40 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda40(HomePage.Section section, boolean z, boolean z2, PlayerConnection playerConnection, ArrayList arrayList, NavHostController navHostController) {
        this.f$0 = section;
        this.f$1 = z;
        this.f$2 = z2;
        this.f$3 = playerConnection;
        this.f$4 = arrayList;
        this.f$5 = navHostController;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        boolean z;
        ComposableLambdaImpl composableLambdaImpl;
        Function0 function0;
        Function0 function1;
        Modifier modifierM137paddingVpY3zN4$default;
        int i;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Object obj4 = this.f$5;
        boolean z2 = this.f$2;
        Object obj5 = this.f$4;
        Object obj6 = this.f$3;
        boolean z3 = this.f$1;
        Object obj7 = this.f$0;
        switch (b) {
            case 0:
                HomePage.Section section = (HomePage.Section) obj7;
                PlayerConnection playerConnection = (PlayerConnection) obj6;
                ArrayList arrayList = (ArrayList) obj5;
                NavHostController navHostController = (NavHostController) obj4;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    Modifier modifierM1473hairlineBottomiJQMabo = DialogKt.m1473hairlineBottomiJQMabo(Modifier.Companion.$$INSTANCE, gapComposer, 6);
                    String str = section.title;
                    String str2 = section.label;
                    String str3 = section.thumbnail;
                    if (str3 == null) {
                        gapComposer.startReplaceGroup(795625431);
                        z = false;
                        gapComposer.end(false);
                        composableLambdaImpl = null;
                    } else {
                        z = false;
                        gapComposer.startReplaceGroup(795625432);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-880075625, new HomeScreenKt$$ExternalSyntheticLambda66(section, str3, (byte) 1), gapComposer);
                        gapComposer.end(false);
                        composableLambdaImpl = composableLambdaImplRememberComposableLambda;
                    }
                    BrowseEndpoint browseEndpoint = section.endpoint;
                    if (browseEndpoint == null) {
                        gapComposer.startReplaceGroup(797090491);
                        gapComposer.end(z);
                        function0 = null;
                    } else {
                        gapComposer.startReplaceGroup(797090492);
                        boolean zChangedInstance = gapComposer.changedInstance(browseEndpoint) | gapComposer.changedInstance(navHostController);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new HomeScreenKt$$ExternalSyntheticLambda67(browseEndpoint, navHostController, (byte) 1);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        gapComposer.end(false);
                        function0 = (Function0) objRememberedValue;
                    }
                    if (!z3 || z2) {
                        gapComposer.startReplaceGroup(799523031);
                        gapComposer.end(false);
                        function1 = null;
                    } else {
                        gapComposer.startReplaceGroup(798919120);
                        boolean zChangedInstance2 = gapComposer.changedInstance(playerConnection) | gapComposer.changedInstance(section) | gapComposer.changedInstance(arrayList);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new QueueKt$$ExternalSyntheticLambda24(playerConnection, (Object) section, (Object) arrayList, (byte) 3);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        gapComposer.end(false);
                        function1 = (Function0) objRememberedValue2;
                    }
                    MenuKt.NavigationTitle(str, modifierM1473hairlineBottomiJQMabo, str2, composableLambdaImpl, function0, function1, gapComposer, 0, 0);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            default:
                PlaylistSongSortType playlistSongSortType = (PlaylistSongSortType) obj7;
                Function1 function2 = (Function1) obj6;
                Function1 function3 = (Function1) obj5;
                MutableState mutableState = (MutableState) obj4;
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                lazyItemScopeImpl.getClass();
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Modifier modifierAnimateItem$default = LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, OffsetKt.m139paddingqDBjuR0$default(companion, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14));
                    Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer2, 48);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierAnimateItem$default);
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
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer2, numValueOf, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer2);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = Stack.mutableStateOf$default(Boolean.FALSE);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    MutableState mutableState2 = (MutableState) objRememberedValue3;
                    Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(layoutWeightElement, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1);
                    if (UiStyleKt.isGlassStyle(gapComposer2)) {
                        gapComposer2.startReplaceGroup(-2138758585);
                        modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(GlassComponentsKt.glass(companion, RoundedCornerShapeKt.RoundedCornerShape(50), false, gapComposer2, 6, 2), 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(-2138602190);
                        gapComposer2.end(false);
                        modifierM137paddingVpY3zN4$default = companion;
                    }
                    Modifier modifierThen = modifierM137paddingVpY3zN4$default2.then(modifierM137paddingVpY3zN4$default);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer2, 48);
                    int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierThen);
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    int iOrdinal = playlistSongSortType.ordinal();
                    if (iOrdinal == 0) {
                        i = R.string.sort_by_custom;
                    } else if (iOrdinal == 1) {
                        i = R.string.sort_by_create_date;
                    } else if (iOrdinal == 2) {
                        i = R.string.sort_by_name;
                    } else if (iOrdinal == 3) {
                        i = R.string.sort_by_artist;
                    } else {
                        if (iOrdinal != 4) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i = R.string.sort_by_play_time;
                    }
                    String upperCase = MathKt.stringResource(i, gapComposer2).toUpperCase(Locale.ROOT);
                    upperCase.getClass();
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    long j = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.primary;
                    TextStyle textStyle = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.labelMedium;
                    FontWeight fontWeight = UiStyleKt.isGlassStyle(gapComposer2) ? FontWeight.Bold : null;
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2);
                    }
                    MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue4;
                    RippleNodeFactory rippleNodeFactoryM313rippleOu1YvPQ$default = RippleKt.m313rippleOu1YvPQ$default(false, CropImageView.DEFAULT_ASPECT_RATIO, 0L, null, 254);
                    Object objRememberedValue5 = gapComposer2.rememberedValue();
                    if (objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new SortHeaderKt$SortHeader$1$2$1(mutableState2, (byte) 0);
                        gapComposer2.updateRememberedValue(objRememberedValue5);
                    }
                    TextKt.m352TextNvy7gAk(upperCase, OffsetKt.m136paddingVpY3zN4(ImageKt.m45clickableO2vRcR0$default(companion, mutableInteractionSourceImpl, rippleNodeFactoryM313rippleOu1YvPQ$default, false, null, (Function0) objRememberedValue5, 28), 4.0f, 8.0f), j, 0L, null, fontWeight, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer2, 0, 0, 131000);
                    boolean zM1492SortHeader$lambda1 = MenuKt.m1492SortHeader$lambda1(mutableState2);
                    Object objRememberedValue6 = gapComposer2.rememberedValue();
                    if (objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new SortHeaderKt$SortHeader$1$2$1(mutableState2, (byte) 1);
                        gapComposer2.updateRememberedValue(objRememberedValue6);
                    }
                    CardKt.m256DropdownMenuIlH_yew(zM1492SortHeader$lambda1, (Function0) objRememberedValue6, SizeKt.m157widthInVpY3zN4$default(companion, 172.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, null, null, null, 0L, CropImageView.DEFAULT_ASPECT_RATIO, Expect_jvmKt.rememberComposableLambda(-1229424361, new LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1((byte) 9, mutableState2, playlistSongSortType, function2), gapComposer2), gapComposer2, 432, 2040);
                    if (playlistSongSortType != PlaylistSongSortType.CUSTOM) {
                        gapComposer2.startReplaceGroup(-413182842);
                        MenuKt.m1491ResizableIconButtonFU0evQE(z3 ? R.drawable.arrow_downward : R.drawable.arrow_upward, OffsetKt.m135padding3ABfNKs(SizeKt.m151size3ABfNKs(companion, 32.0f), 8.0f), ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.primary, false, new SortHeaderKt$SortHeader$1$5(function3, z3), gapComposer2, 48);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(-412803898);
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(true);
                    if (z2) {
                        gapComposer2.startReplaceGroup(-568439194);
                        boolean zChanged = gapComposer2.changed(mutableState);
                        Object objRememberedValue7 = gapComposer2.rememberedValue();
                        if (zChanged || objRememberedValue7 == neverEqualPolicy) {
                            objRememberedValue7 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState, (byte) 17);
                            gapComposer2.updateRememberedValue(objRememberedValue7);
                        }
                        CardKt.IconButton((Function0) objRememberedValue7, OffsetKt.m137paddingVpY3zN4$default(companion, 6.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), false, null, null, Expect_jvmKt.rememberComposableLambda(-1442503443, new QueueKt$$ExternalSyntheticLambda39(mutableState, (byte) 13), gapComposer2), gapComposer2, 1572912, 60);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(-567895268);
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(true);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda40(PlaylistSongSortType playlistSongSortType, boolean z, Function1 function1, Function1 function2, boolean z2, MutableState mutableState) {
        this.f$0 = playlistSongSortType;
        this.f$1 = z;
        this.f$3 = function1;
        this.f$4 = function2;
        this.f$2 = z2;
        this.f$5 = mutableState;
    }
}
