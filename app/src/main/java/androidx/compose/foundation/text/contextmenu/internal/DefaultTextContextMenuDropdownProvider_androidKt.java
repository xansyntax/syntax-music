package androidx.compose.foundation.text.contextmenu.internal;

import android.content.Context;
import android.os.Build;
import androidx.compose.foundation.contextmenu.ContextMenuSpec;
import androidx.compose.foundation.contextmenu.ContextMenuUiKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import com.google.common.math.IntMath;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DefaultTextContextMenuDropdownProvider_androidKt {
    public static final PopupProperties DefaultPopupProperties = new PopupProperties(true, 30);

    public static final void DefaultTextContextMenuDropdown(TextContextMenuSession textContextMenuSession, TextContextMenuData textContextMenuData, Composer composer, int i) {
        Context context;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1904307118);
        int i2 = (gapComposer.changed(textContextMenuSession) ? 4 : 2) | i | (gapComposer.changedInstance(textContextMenuData) ? 32 : 16);
        byte b = 14;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            if (Build.VERSION.SDK_INT >= 28) {
                gapComposer.startReplaceGroup(-1009482584);
                context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1009433480);
                gapComposer.end(false);
                context = null;
            }
            boolean zChangedInstance = gapComposer.changedInstance(textContextMenuData) | ((i2 & 14) == 4) | gapComposer.changedInstance(context);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new UtilsKt$$ExternalSyntheticLambda0((Object) textContextMenuData, (Object) context, (Object) textContextMenuSession, (byte) 11);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            ContextMenuUiKt.ContextMenuColumnBuilder(null, null, (Function1) objRememberedValue, gapComposer, 0, 3);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda1(textContextMenuSession, textContextMenuData, i, b);
        }
    }

    /* JADX INFO: renamed from: IconBox-RPmYEkk, reason: not valid java name */
    public static final void m209IconBoxRPmYEkk(final int i, final long j, Composer composer, final int i2) throws XmlPullParserException, IOException {
        final int i3;
        int i4;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Function2 function2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1240244237);
        if ((i2 & 6) == 0) {
            i3 = i;
            i4 = i2 | (gapComposer.changed(i3) ? 4 : 2);
        } else {
            i3 = i;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer.changed(j) ? 32 : 16;
        }
        if (gapComposer.shouldExecute(i4 & 1, (i4 & 19) != 18)) {
            Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            boolean zChanged = ((i4 & 14) == 4) | gapComposer.changed(context);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Integer.valueOf(context.obtainStyledAttributes(new int[]{i3}).getResourceId(0, -1));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            int iIntValue = ((Number) objRememberedValue).intValue();
            if (iIntValue == -1) {
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup == null) {
                    return;
                }
                final byte b = 0;
                function2 = new Function2() { // from class: androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
                        byte b2 = b;
                        Unit unit = Unit.INSTANCE;
                        int i5 = i2;
                        long j2 = j;
                        int i6 = i3;
                        Composer composer2 = (Composer) obj;
                        ((Integer) obj2).getClass();
                        switch (b2) {
                            case 0:
                                DefaultTextContextMenuDropdownProvider_androidKt.m209IconBoxRPmYEkk(i6, j2, composer2, Stack.updateChangedFlags(i5 | 1));
                                break;
                            default:
                                DefaultTextContextMenuDropdownProvider_androidKt.m209IconBoxRPmYEkk(i6, j2, composer2, Stack.updateChangedFlags(i5 | 1));
                                break;
                        }
                        return unit;
                    }
                };
            } else {
                Painter painterPainterResource = IntMath.painterResource(iIntValue, 0, gapComposer);
                boolean z = (i4 & 112) == 32;
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (z || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = j == 16 ? null : new BlendModeColorFilter(j, 5);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                BoxKt.Box(ClipKt.paint$default(SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, ContextMenuSpec.IconSize), painterPainterResource, ContentScale.Companion.Fit, CropImageView.DEFAULT_ASPECT_RATIO, (BlendModeColorFilter) objRememberedValue2, 22), gapComposer, 0);
            }
            recomposeScopeImplEndRestartGroup.block = function2;
        }
        gapComposer.skipToGroupEnd();
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final byte b2 = 1;
            function2 = new Function2() { // from class: androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
                    byte b3 = b2;
                    Unit unit = Unit.INSTANCE;
                    int i5 = i2;
                    long j2 = j;
                    int i6 = i;
                    Composer composer2 = (Composer) obj;
                    ((Integer) obj2).getClass();
                    switch (b3) {
                        case 0:
                            DefaultTextContextMenuDropdownProvider_androidKt.m209IconBoxRPmYEkk(i6, j2, composer2, Stack.updateChangedFlags(i5 | 1));
                            break;
                        default:
                            DefaultTextContextMenuDropdownProvider_androidKt.m209IconBoxRPmYEkk(i6, j2, composer2, Stack.updateChangedFlags(i5 | 1));
                            break;
                    }
                    return unit;
                }
            };
            recomposeScopeImplEndRestartGroup.block = function2;
        }
    }

    public static final void OpenContextMenu(TextContextMenuSession textContextMenuSession, TextContextMenuDataProvider textContextMenuDataProvider, Function0 function0, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-2040393164);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? gapComposer.changed(textContextMenuSession) : gapComposer.changedInstance(textContextMenuSession) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? gapComposer.changed(textContextMenuDataProvider) : gapComposer.changedInstance(textContextMenuDataProvider) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 256 : 128;
        }
        boolean z = false;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            boolean z2 = (i2 & 112) == 32 || ((i2 & 64) != 0 && gapComposer.changed(textContextMenuDataProvider));
            Object objRememberedValue = gapComposer.rememberedValue();
            byte b = 13;
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z2 || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new MaintainWindowPositionPopupPositionProvider(new ProvidableModifierLocal(new Recomposer$$ExternalSyntheticLambda6(textContextMenuDataProvider, function0, b)));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MaintainWindowPositionPopupPositionProvider maintainWindowPositionPopupPositionProvider = (MaintainWindowPositionPopupPositionProvider) objRememberedValue;
            if ((i2 & 14) == 4 || ((i2 & 8) != 0 && gapComposer.changedInstance(textContextMenuSession))) {
                z = true;
            }
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (z || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new SliderState$$ExternalSyntheticLambda0((byte) 17, textContextMenuSession);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            AndroidPopup_androidKt.Popup(maintainWindowPositionPopupPositionProvider, (Function0) objRememberedValue2, DefaultPopupProperties, Expect_jvmKt.rememberComposableLambda(1315155414, new ButtonKt$$ExternalSyntheticLambda1(textContextMenuDataProvider, textContextMenuSession, b), gapComposer), gapComposer, 3456, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda0((byte) 5, i, (Object) textContextMenuSession, (Object) textContextMenuDataProvider, (Object) function0);
        }
    }

    public static final void ProvideDefaultTextContextMenuDropdown(Modifier modifier, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1392105195);
        byte b = 2;
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            DatabaseDao_Impl.AnonymousClass17.ProvideBasicTextContextMenu(modifier, TextContextMenuProviderKt.LocalTextContextMenuDropdownProvider, composableLambdaImpl, gapComposer, ((i2 << 6) & 7168) | (i2 & 14) | 432);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda0(modifier, composableLambdaImpl, i, b);
        }
    }
}
