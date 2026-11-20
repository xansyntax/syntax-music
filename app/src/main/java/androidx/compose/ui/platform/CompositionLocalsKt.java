package androidx.compose.ui.platform;

import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComputedProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapPending$keyMap$2;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.retain.LocalRetainedValuesStoreKt;
import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda2;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda1;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CompositionLocalsKt {
    public static final StaticProvidableCompositionLocal LocalAccessibilityManager;
    public static final StaticProvidableCompositionLocal LocalAutofill;
    public static final StaticProvidableCompositionLocal LocalAutofillManager;
    public static final StaticProvidableCompositionLocal LocalAutofillTree;
    public static final StaticProvidableCompositionLocal LocalClipboard;
    public static final StaticProvidableCompositionLocal LocalClipboardManager;
    public static final StaticProvidableCompositionLocal LocalCursorBlinkEnabled;
    public static final StaticProvidableCompositionLocal LocalDensity;
    public static final StaticProvidableCompositionLocal LocalFocusManager;
    public static final StaticProvidableCompositionLocal LocalFontFamilyResolver;
    public static final StaticProvidableCompositionLocal LocalFontLoader;
    public static final StaticProvidableCompositionLocal LocalGraphicsContext;
    public static final StaticProvidableCompositionLocal LocalHapticFeedback;
    public static final StaticProvidableCompositionLocal LocalInputModeManager;
    public static final StaticProvidableCompositionLocal LocalLayoutDirection;
    public static final ComputedProvidableCompositionLocal LocalLocale;
    public static final StaticProvidableCompositionLocal LocalOwner = new StaticProvidableCompositionLocal(new TextKt$$ExternalSyntheticLambda3(28), (byte) 0);
    public static final StaticProvidableCompositionLocal LocalPointerIconService;
    public static final StaticProvidableCompositionLocal LocalProvidableLocaleList;
    public static final StaticProvidableCompositionLocal LocalProvidableScrollCaptureInProgress;
    public static final StaticProvidableCompositionLocal LocalSoftwareKeyboardController;
    public static final StaticProvidableCompositionLocal LocalSoundEffect;
    public static final StaticProvidableCompositionLocal LocalTextInputService;
    public static final StaticProvidableCompositionLocal LocalTextToolbar;
    public static final ComputedProvidableCompositionLocal LocalUriHandler;
    public static final StaticProvidableCompositionLocal LocalViewConfiguration;
    public static final StaticProvidableCompositionLocal LocalWindowInfo;

    static {
        CompositionLocalsKt$computedNullableDefaultOf$2 compositionLocalsKt$computedNullableDefaultOf$2 = CompositionLocalsKt$computedNullableDefaultOf$2.INSTANCE;
        LocalAccessibilityManager = new StaticProvidableCompositionLocal(compositionLocalsKt$computedNullableDefaultOf$2, (byte) 0);
        LocalAutofill = new StaticProvidableCompositionLocal(compositionLocalsKt$computedNullableDefaultOf$2, (byte) 0);
        LocalAutofillTree = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 2, "LocalAutofillTree"), (byte) 0);
        LocalAutofillManager = new StaticProvidableCompositionLocal(compositionLocalsKt$computedNullableDefaultOf$2, (byte) 0);
        LocalClipboardManager = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 2, "LocalClipboardManager"), (byte) 0);
        LocalClipboard = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 2, "LocalClipboard"), (byte) 0);
        LocalGraphicsContext = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 2, "LocalGraphicsContext"), (byte) 0);
        LocalDensity = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 2, "LocalDensity"), (byte) 0);
        LocalFocusManager = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 2, "LocalFocusManager"), (byte) 0);
        LocalFontLoader = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 2, "LocalFontLoader"), (byte) 0);
        LocalFontFamilyResolver = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 2, "LocalFontFamilyResolver"), (byte) 0);
        LocalHapticFeedback = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 2, "LocalHapticFeedback"), (byte) 0);
        LocalInputModeManager = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 2, "LocalInputModeManager"), (byte) 0);
        LocalLayoutDirection = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 2, "LocalLayoutDirection"), (byte) 0);
        LocalProvidableLocaleList = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 2, "LocalProvidableLocaleList"), (byte) 0);
        byte b = 29;
        LocalLocale = new ComputedProvidableCompositionLocal(new ComposedModifierKt$$ExternalSyntheticLambda0(b));
        LocalTextInputService = new StaticProvidableCompositionLocal(compositionLocalsKt$computedNullableDefaultOf$2, (byte) 0);
        LocalSoftwareKeyboardController = new StaticProvidableCompositionLocal(compositionLocalsKt$computedNullableDefaultOf$2, (byte) 0);
        LocalTextToolbar = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 2, "LocalTextToolbar"), (byte) 0);
        LocalUriHandler = new ComputedProvidableCompositionLocal(new SaversKt$$ExternalSyntheticLambda2((byte) 1));
        LocalViewConfiguration = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 2, "LocalViewConfiguration"), (byte) 0);
        LocalWindowInfo = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 2, "LocalWindowInfo"), (byte) 0);
        LocalSoundEffect = new StaticProvidableCompositionLocal(new TextKt$$ExternalSyntheticLambda3(b), (byte) 0);
        LocalPointerIconService = new StaticProvidableCompositionLocal(compositionLocalsKt$computedNullableDefaultOf$2, (byte) 0);
        LocalProvidableScrollCaptureInProgress = new StaticProvidableCompositionLocal(new TextKt$$ExternalSyntheticLambda3((byte) 4), (byte) 1);
        LocalCursorBlinkEnabled = new StaticProvidableCompositionLocal(new ScrollKt$$ExternalSyntheticLambda0((byte) 7), (byte) 0);
    }

    public static final void ProvideCommonCompositionLocals(Owner owner, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(915119540);
        int i2 = (gapComposer.changed(owner) ? 4 : 2) | i | (gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            gapComposer.startReplaceGroup(-2125775525);
            AndroidComposeView androidComposeView = (AndroidComposeView) owner;
            ProvidedValue providedValueDefaultProvidedValue$runtime = LocalAccessibilityManager.defaultProvidedValue$runtime(androidComposeView.getAccessibilityManager());
            ProvidedValue providedValueDefaultProvidedValue$runtime2 = LocalAutofill.defaultProvidedValue$runtime(androidComposeView.m693getAutofill());
            ProvidedValue providedValueDefaultProvidedValue$runtime3 = LocalAutofillManager.defaultProvidedValue$runtime(androidComposeView.m694getAutofillManager());
            ProvidedValue providedValueDefaultProvidedValue$runtime4 = LocalAutofillTree.defaultProvidedValue$runtime(androidComposeView.getAutofillTree());
            ProvidedValue providedValueDefaultProvidedValue$runtime5 = LocalClipboardManager.defaultProvidedValue$runtime(androidComposeView.getClipboardManager());
            ProvidedValue providedValueDefaultProvidedValue$runtime6 = LocalClipboard.defaultProvidedValue$runtime(androidComposeView.getClipboard());
            ProvidedValue providedValueDefaultProvidedValue$runtime7 = LocalDensity.defaultProvidedValue$runtime(androidComposeView.getDensity());
            ProvidedValue providedValueDefaultProvidedValue$runtime8 = LocalFocusManager.defaultProvidedValue$runtime(androidComposeView.getFocusOwner());
            ProvidedValue providedValueDefaultProvidedValue$runtime9 = LocalFontLoader.defaultProvidedValue$runtime(androidComposeView.getFontLoader());
            providedValueDefaultProvidedValue$runtime9.canOverride = false;
            ProvidedValue providedValueDefaultProvidedValue$runtime10 = LocalFontFamilyResolver.defaultProvidedValue$runtime(androidComposeView.getFontFamilyResolver());
            providedValueDefaultProvidedValue$runtime10.canOverride = false;
            ProvidedValue providedValueDefaultProvidedValue$runtime11 = LocalHapticFeedback.defaultProvidedValue$runtime(androidComposeView.getHapticFeedBack());
            int i3 = i2 & 14;
            boolean z = i3 == 4;
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new AndroidComposeView$$ExternalSyntheticLambda0(androidComposeView, (byte) 5);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            ProvidedValue providedValueProvidesComputed = LocalInputModeManager.providesComputed((Function1) objRememberedValue);
            ProvidedValue providedValueDefaultProvidedValue$runtime12 = LocalLayoutDirection.defaultProvidedValue$runtime(androidComposeView.getLayoutDirection());
            boolean z2 = i3 == 4;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (z2 || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new AndroidComposeView$$ExternalSyntheticLambda0(androidComposeView, (byte) 6);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            ProvidedValue providedValueProvidesComputed2 = LocalTextInputService.providesComputed((Function1) objRememberedValue2);
            boolean z3 = i3 == 4;
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (z3 || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new AndroidComposeView$$ExternalSyntheticLambda0(androidComposeView, (byte) 7);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            ProvidedValue providedValueProvidesComputed3 = LocalSoftwareKeyboardController.providesComputed((Function1) objRememberedValue3);
            boolean z4 = i3 == 4;
            Object objRememberedValue4 = gapComposer.rememberedValue();
            byte b = 8;
            if (z4 || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new AndroidComposeView$$ExternalSyntheticLambda0(androidComposeView, b);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            ProvidedValue providedValueProvidesComputed4 = LocalTextToolbar.providesComputed((Function1) objRememberedValue4);
            ProvidedValue providedValueDefaultProvidedValue$runtime13 = LocalUriHandler.defaultProvidedValue$runtime(androidComposeView.getUriHandler());
            ProvidedValue providedValueDefaultProvidedValue$runtime14 = LocalViewConfiguration.defaultProvidedValue$runtime(androidComposeView.getViewConfiguration());
            ProvidedValue providedValueDefaultProvidedValue$runtime15 = LocalWindowInfo.defaultProvidedValue$runtime(androidComposeView.getWindowInfo());
            boolean z5 = i3 == 4;
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (z5 || objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new AndroidComposeView$$ExternalSyntheticLambda0(androidComposeView, (byte) 9);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            Stack.CompositionLocalProvider(new ProvidedValue[]{providedValueDefaultProvidedValue$runtime, providedValueDefaultProvidedValue$runtime2, providedValueDefaultProvidedValue$runtime3, providedValueDefaultProvidedValue$runtime4, providedValueDefaultProvidedValue$runtime5, providedValueDefaultProvidedValue$runtime6, providedValueDefaultProvidedValue$runtime7, providedValueDefaultProvidedValue$runtime8, providedValueDefaultProvidedValue$runtime9, providedValueDefaultProvidedValue$runtime10, providedValueDefaultProvidedValue$runtime11, providedValueProvidesComputed, providedValueDefaultProvidedValue$runtime12, providedValueProvidesComputed2, providedValueProvidesComputed3, providedValueProvidesComputed4, providedValueDefaultProvidedValue$runtime13, providedValueDefaultProvidedValue$runtime14, providedValueDefaultProvidedValue$runtime15, LocalPointerIconService.providesComputed((Function1) objRememberedValue5), LocalGraphicsContext.defaultProvidedValue$runtime(androidComposeView.getGraphicsContext()), LocalRetainedValuesStoreKt.LocalRetainedValuesStore.defaultProvidedValue$runtime(androidComposeView.getRetainedValuesStore()), LocalProvidableLocaleList.defaultProvidedValue$runtime(androidComposeView.getLocaleList())}, composableLambdaImpl, gapComposer, 8 | (i2 & 112));
            gapComposer.end(false);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda1(owner, composableLambdaImpl, i, (byte) 2);
        }
    }

    public static final void noLocalProvidedFor(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }
}
