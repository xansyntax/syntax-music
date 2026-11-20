package com.metrolist.music;

import androidx.collection.MutableIntList;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.AddedInsets;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.AnalogTimePickerState;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda7;
import androidx.compose.material3.LayoutId;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TimePickerKt;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda36;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavHostController;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.theme.UiStyle;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda31 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Object f$10;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ boolean f$7;
    public final /* synthetic */ Object f$8;
    public final /* synthetic */ boolean f$9;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda31(MutableIntList mutableIntList, boolean z, AnalogTimePickerState analogTimePickerState, boolean z2, FocusRequester focusRequester, FocusRequester focusRequester2, boolean z3, FocusOwner focusOwner, boolean z4, FocusRequester focusRequester3, FocusRequester focusRequester4) {
        this.f$0 = mutableIntList;
        this.f$1 = z;
        this.f$3 = analogTimePickerState;
        this.f$2 = z2;
        this.f$4 = focusRequester;
        this.f$5 = focusRequester2;
        this.f$7 = z3;
        this.f$6 = focusOwner;
        this.f$9 = z4;
        this.f$8 = focusRequester3;
        this.f$10 = focusRequester4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        boolean z;
        final FocusRequester focusRequester;
        boolean z2;
        int i;
        FocusRequester focusRequester2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        boolean z3 = true;
        Object obj3 = this.f$10;
        Object obj4 = this.f$8;
        Object obj5 = this.f$6;
        Object obj6 = this.f$5;
        Object obj7 = this.f$4;
        Object obj8 = this.f$3;
        Object obj9 = this.f$0;
        switch (b) {
            case 0:
                MutableState mutableState = (MutableState) obj9;
                final WindowInsets windowInsets = (WindowInsets) obj8;
                final NavDeepLinkRequest navDeepLinkRequest = (NavDeepLinkRequest) obj7;
                final MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 = (MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4) obj6;
                final Integer num = (Integer) obj5;
                final NavHostController navHostController = (NavHostController) obj4;
                final String str = (String) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int i2 = MainActivity.$r8$clinit;
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
                    EnterTransitionImpl enterTransitionImplFadeIn$default = EnterExitTransitionKt.fadeIn$default(ArcSplineKt.tween$default(300, 0, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    ExitTransitionImpl exitTransitionImplFadeOut$default = EnterExitTransitionKt.fadeOut$default(ArcSplineKt.tween$default(200, 0, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    final boolean z4 = this.f$1;
                    final boolean z5 = this.f$2;
                    final boolean z6 = this.f$7;
                    final boolean z7 = this.f$9;
                    CrossfadeKt.AnimatedVisibility(zBooleanValue, null, enterTransitionImplFadeIn$default, exitTransitionImplFadeOut$default, null, Expect_jvmKt.rememberComposableLambda(-1416799975, new Function3() { // from class: com.metrolist.music.MainActivity$$ExternalSyntheticLambda45
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj10, Object obj11, Object obj12) {
                            long j;
                            WindowInsets limitInsets;
                            Composer composer2 = (Composer) obj11;
                            int iIntValue2 = ((Integer) obj12).intValue();
                            int i3 = MainActivity.$r8$clinit;
                            ((AnimatedVisibilityScope) obj10).getClass();
                            GapComposer gapComposer2 = (GapComposer) composer2;
                            if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer2, 0);
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
                                PaddingValuesImpl paddingValuesImpl = TopAppBarDefaults.ContentPadding;
                                UiStyle uiStyle = UiStyle.GLASS;
                                boolean z8 = z4;
                                MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$5 = mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4;
                                long j2 = 0;
                                long j3 = -72057594037927936L;
                                if (z8) {
                                    gapComposer2.startReplaceGroup(924716026);
                                    gapComposer2.end(false);
                                    j = -72057594037927936L;
                                } else if (((UiStyle) mainActivity$MetrolistApp$$inlined$rememberEnumPreference$5.getValue()) == uiStyle) {
                                    gapComposer2.startReplaceGroup(924717536);
                                    gapComposer2.end(false);
                                    j = 0;
                                } else {
                                    gapComposer2.startReplaceGroup(924718908);
                                    j = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface;
                                    gapComposer2.end(false);
                                }
                                if (z8) {
                                    gapComposer2.startReplaceGroup(924722202);
                                    gapComposer2.end(false);
                                } else {
                                    if (((UiStyle) mainActivity$MetrolistApp$$inlined$rememberEnumPreference$5.getValue()) == uiStyle) {
                                        gapComposer2.startReplaceGroup(924723712);
                                    } else {
                                        gapComposer2.startReplaceGroup(924725084);
                                        j2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface;
                                    }
                                    gapComposer2.end(false);
                                    j3 = j2;
                                }
                                StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                                TopAppBarColors topAppBarColorsM363topAppBarColors5tl4gsc = TopAppBarDefaults.m363topAppBarColors5tl4gsc(j, j3, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, gapComposer2, 32);
                                boolean z9 = z5;
                                WindowInsets windowInsets2 = windowInsets;
                                if (z9) {
                                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                                    limitInsets = new AddedInsets(OffsetKt.m129WindowInsetsa9UjIt4$default(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14), new LimitInsets(windowInsets2, 9));
                                } else {
                                    limitInsets = new LimitInsets(windowInsets2, 15);
                                }
                                Modifier modifierWindowInsetsPadding = OffsetKt.windowInsetsPadding(companion, limitInsets);
                                ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1185900295, new MainActivity$$ExternalSyntheticLambda0((byte) 4, num), gapComposer2);
                                final boolean z10 = z6;
                                final NavHostController navHostController2 = navHostController;
                                final boolean z11 = z7;
                                final String str2 = str;
                                MenuKt.m1493TopAppBarGHTll3U(composableLambdaImplRememberComposableLambda, modifierWindowInsetsPadding, null, Expect_jvmKt.rememberComposableLambda(879180964, new Function3() { // from class: com.metrolist.music.MainActivity$$ExternalSyntheticLambda64
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj13, Object obj14, Object obj15) {
                                        Composer composer3 = (Composer) obj14;
                                        int iIntValue3 = ((Integer) obj15).intValue();
                                        int i4 = MainActivity.$r8$clinit;
                                        ((RowScope) obj13).getClass();
                                        byte b2 = 0;
                                        GapComposer gapComposer3 = (GapComposer) composer3;
                                        if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                            boolean z12 = z10;
                                            NavHostController navHostController3 = navHostController2;
                                            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                                            if (z12) {
                                                gapComposer3.startReplaceGroup(969612489);
                                                boolean zChangedInstance = gapComposer3.changedInstance(navHostController3);
                                                Object objRememberedValue = gapComposer3.rememberedValue();
                                                if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                                                    objRememberedValue = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 0);
                                                    gapComposer3.updateRememberedValue(objRememberedValue);
                                                }
                                                CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, ComposableSingletons$MainActivityKt.lambda$1777745291, gapComposer3, 1572864, 62);
                                                gapComposer3.end(false);
                                            } else {
                                                gapComposer3.startReplaceGroup(970124702);
                                                gapComposer3.end(false);
                                            }
                                            boolean zChangedInstance2 = gapComposer3.changedInstance(navHostController3);
                                            Object objRememberedValue2 = gapComposer3.rememberedValue();
                                            if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                                                objRememberedValue2 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 2);
                                                gapComposer3.updateRememberedValue(objRememberedValue2);
                                            }
                                            CardKt.IconButton((Function0) objRememberedValue2, null, false, null, null, ComposableSingletons$MainActivityKt.lambda$1775857094, gapComposer3, 1572864, 62);
                                            if (z11) {
                                                gapComposer3.startReplaceGroup(970666861);
                                                boolean zChangedInstance3 = gapComposer3.changedInstance(navHostController3);
                                                Object objRememberedValue3 = gapComposer3.rememberedValue();
                                                if (zChangedInstance3 || objRememberedValue3 == neverEqualPolicy) {
                                                    objRememberedValue3 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 5);
                                                    gapComposer3.updateRememberedValue(objRememberedValue3);
                                                }
                                                CardKt.IconButton((Function0) objRememberedValue3, null, false, null, null, ComposableSingletons$MainActivityKt.f11lambda$228981068, gapComposer3, 1572864, 62);
                                                gapComposer3.end(false);
                                            } else {
                                                gapComposer3.startReplaceGroup(971205982);
                                                gapComposer3.end(false);
                                            }
                                            boolean zChangedInstance4 = gapComposer3.changedInstance(navHostController3);
                                            Object objRememberedValue4 = gapComposer3.rememberedValue();
                                            if (zChangedInstance4 || objRememberedValue4 == neverEqualPolicy) {
                                                objRememberedValue4 = new MainActivity$$ExternalSyntheticLambda2(navHostController3, (byte) 8);
                                                gapComposer3.updateRememberedValue(objRememberedValue4);
                                            }
                                            CardKt.IconButton((Function0) objRememberedValue4, null, false, null, null, Expect_jvmKt.rememberComposableLambda(-2043538385, new MainActivity$$ExternalSyntheticLambda6(str2, b2), gapComposer3), gapComposer3, 1572864, 62);
                                        } else {
                                            gapComposer3.skipToGroupEnd();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, gapComposer2), CropImageView.DEFAULT_ASPECT_RATIO, null, topAppBarColorsM363topAppBarColors5tl4gsc, navDeepLinkRequest, gapComposer2, 3078, 52);
                                gapComposer2.end(true);
                            } else {
                                gapComposer2.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer), gapComposer, 200064, 18);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            default:
                final MutableIntList mutableIntList = (MutableIntList) obj9;
                AnalogTimePickerState analogTimePickerState = (AnalogTimePickerState) obj8;
                FocusRequester focusRequester3 = (FocusRequester) obj7;
                final FocusRequester focusRequester4 = (FocusRequester) obj6;
                FocusOwner focusOwner = (FocusOwner) obj5;
                FocusRequester focusRequester5 = (FocusRequester) obj4;
                final FocusRequester focusRequester6 = (FocusRequester) obj3;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                    return unit;
                }
                gapComposer2.startReplaceGroup(1866274136);
                int i3 = mutableIntList._size;
                int i4 = 0;
                while (true) {
                    Modifier modifierFocusRequester = Modifier.Companion.$$INSTANCE;
                    boolean z8 = this.f$7;
                    boolean z9 = this.f$9;
                    if (i4 >= i3) {
                        Unit unit2 = unit;
                        FocusRequester focusRequester7 = focusRequester3;
                        FocusRequester focusRequester8 = focusRequester5;
                        FocusRequester focusRequester9 = focusRequester6;
                        gapComposer2.end(false);
                        if (!this.f$1) {
                            gapComposer2.startReplaceGroup(2024928041);
                            gapComposer2.end(false);
                            return unit2;
                        }
                        gapComposer2.startReplaceGroup(2022552449);
                        TimePickerKt.CircularLayout(ImageKt.m39backgroundbw27NRU(SizeKt.m151size3ABfNKs(RulerKt.layoutId(modifierFocusRequester, LayoutId.InnerCircle), 256.0f), 0L, RoundedCornerShapeKt.CircleShape), 0.26953125f, Expect_jvmKt.rememberComposableLambda(-1385767514, new ChipKt$$ExternalSyntheticLambda7(focusRequester9, focusRequester8, analogTimePickerState, z8, focusOwner, z9, focusRequester4, focusRequester7), gapComposer2), gapComposer2, 384);
                        gapComposer2.end(false);
                        return unit2;
                    }
                    boolean z10 = z3;
                    boolean zIs24hour = analogTimePickerState.state.is24hour();
                    final boolean z11 = this.f$2;
                    int i5 = (!zIs24hour || z11) ? mutableIntList.get(i4) : mutableIntList.get(i4) % 12;
                    boolean zChanged = gapComposer2.changed(i4);
                    Unit unit3 = unit;
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    int i6 = i3;
                    NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        z = false;
                        objRememberedValue = new TimePickerKt$$ExternalSyntheticLambda36((byte) 0, i4);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    } else {
                        z = false;
                    }
                    Modifier modifierThen = SemanticsModifierKt.semantics(modifierFocusRequester, z, (Function1) objRememberedValue).then(i4 == 0 ? FocusTraversalKt.focusRequester(modifierFocusRequester, focusRequester3) : modifierFocusRequester);
                    if (i4 == mutableIntList._size - 1) {
                        modifierFocusRequester = FocusTraversalKt.focusRequester(modifierFocusRequester, focusRequester4);
                    }
                    Modifier modifierThen2 = modifierThen.then(modifierFocusRequester);
                    boolean zChanged2 = gapComposer2.changed(i4) | gapComposer2.changedInstance(analogTimePickerState) | gapComposer2.changed(z11) | gapComposer2.changedInstance(mutableIntList);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        focusRequester = focusRequester3;
                        final FocusRequester focusRequester10 = focusRequester5;
                        z2 = z9;
                        final AnalogTimePickerState analogTimePickerState2 = analogTimePickerState;
                        final int i7 = i4;
                        Function1 function1 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda37
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj10) {
                                FocusProperties focusProperties = (FocusProperties) obj10;
                                int i8 = i7;
                                AnalogTimePickerState analogTimePickerState3 = analogTimePickerState2;
                                boolean z12 = z11;
                                if (i8 == 0) {
                                    focusProperties.setPrevious((!analogTimePickerState3.state.is24hour() || z12) ? focusRequester4 : focusRequester10);
                                }
                                if (i8 == mutableIntList._size - 1) {
                                    focusProperties.setNext((!analogTimePickerState3.state.is24hour() || z12) ? focusRequester : focusRequester6);
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        i = i7;
                        analogTimePickerState = analogTimePickerState2;
                        focusRequester2 = focusRequester10;
                        gapComposer2.updateRememberedValue(function1);
                        objRememberedValue2 = function1;
                    } else {
                        i = i4;
                        focusRequester = focusRequester3;
                        z2 = z9;
                        focusRequester2 = focusRequester5;
                    }
                    TimePickerKt.ClockText(FocusTraversalKt.focusProperties(modifierThen2, (Function1) objRememberedValue2), analogTimePickerState, i5, z8, focusOwner, z2, gapComposer2, 0);
                    i3 = i6;
                    focusRequester5 = focusRequester2;
                    focusRequester6 = focusRequester6;
                    focusRequester3 = focusRequester;
                    z3 = z10;
                    i4 = i + 1;
                    unit = unit3;
                }
                break;
        }
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda31(MutableState mutableState, boolean z, boolean z2, WindowInsets windowInsets, NavDeepLinkRequest navDeepLinkRequest, MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4, Integer num, boolean z3, NavHostController navHostController, boolean z4, String str) {
        this.f$0 = mutableState;
        this.f$1 = z;
        this.f$2 = z2;
        this.f$3 = windowInsets;
        this.f$4 = navDeepLinkRequest;
        this.f$5 = mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4;
        this.f$6 = num;
        this.f$7 = z3;
        this.f$8 = navHostController;
        this.f$9 = z4;
        this.f$10 = str;
    }
}
