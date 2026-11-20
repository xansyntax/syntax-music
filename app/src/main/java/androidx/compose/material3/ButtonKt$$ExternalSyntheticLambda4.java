package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.text.TextStyle;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.component.BottomSheetMenuKt;
import com.metrolist.music.ui.component.BottomSheetPageKt;
import com.metrolist.music.ui.component.BottomSheetPageState;
import com.metrolist.music.ui.component.MenuState;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ButtonKt$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ long f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda4(long j, Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = j;
        this.f$1 = obj;
        this.f$2 = obj2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        byte b2 = 2;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        switch (b) {
            case 0:
                PaddingValues paddingValues = (PaddingValues) obj4;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Icons$Filled.m370ProvideContentColorTextStyle3JVO9M(this.f$0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.labelLarge, Expect_jvmKt.rememberComposableLambda(-2115100680, new ButtonKt$$ExternalSyntheticLambda1(paddingValues, composableLambdaImpl, (byte) 17), gapComposer), gapComposer, 384);
                }
                break;
            case 1:
                ((Integer) obj2).getClass();
                BasicTextKt.m189CursorHandleUSBMPiE((OffsetProvider) obj4, (Modifier) obj3, this.f$0, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 2:
                PaddingValues paddingValues2 = (PaddingValues) obj4;
                Function3 function3 = (Function3) obj3;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Icons$Filled.m370ProvideContentColorTextStyle3JVO9M(this.f$0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelLarge, Expect_jvmKt.rememberComposableLambda(417635459, new ButtonKt$$ExternalSyntheticLambda1(paddingValues2, function3, (byte) 0), gapComposer2), gapComposer2, 384);
                }
                break;
            case 3:
                TextStyle textStyle = (TextStyle) obj4;
                ComposableLambdaImpl composableLambdaImpl2 = (ComposableLambdaImpl) obj3;
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    Icons$Filled.m370ProvideContentColorTextStyle3JVO9M(this.f$0, textStyle, Expect_jvmKt.rememberComposableLambda(-1767363041, new CardKt$$ExternalSyntheticLambda1(composableLambdaImpl2, (byte) 4), gapComposer3), gapComposer3, 384);
                }
                break;
            case 4:
                SnackbarHostState.SnackbarDataImpl snackbarDataImpl = (SnackbarHostState.SnackbarDataImpl) obj4;
                String str = (String) obj3;
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(1 & iIntValue4, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                    Rgb rgb = ColorSpaces.Unspecified;
                    ButtonColors buttonColorsM246copyjRlVdoo = ButtonDefaults.getDefaultTextButtonColors$material3(((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).colorScheme).m246copyjRlVdoo(ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb), this.f$0, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb), ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb));
                    boolean zChanged = gapComposer4.changed(snackbarDataImpl);
                    Object objRememberedValue = gapComposer4.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new SnackbarKt$$ExternalSyntheticLambda3(snackbarDataImpl, (byte) 0);
                        gapComposer4.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.TextButton((Function0) objRememberedValue, null, false, null, buttonColorsM246copyjRlVdoo, null, Expect_jvmKt.rememberComposableLambda(521110564, new MainActivity$$ExternalSyntheticLambda7(str, b2), gapComposer4), gapComposer4, 805306368, 494);
                }
                break;
            case 5:
                TextStyle textStyle2 = (TextStyle) obj4;
                Function2 function2 = (Function2) obj3;
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    Icons$Filled.m368Decoration3JVO9M(this.f$0, textStyle2, function2, gapComposer5, 0);
                }
                break;
            case 6:
                ((Integer) obj2).getClass();
                BottomSheetMenuKt.m1454BottomSheetMenuFNF3uiM((Modifier) obj4, (MenuState) obj3, this.f$0, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            default:
                ((Integer) obj2).getClass();
                BottomSheetPageKt.m1455BottomSheetPageFNF3uiM((Modifier) obj4, (BottomSheetPageState) obj3, this.f$0, (Composer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda4(Object obj, Object obj2, long j, int i, byte b) {
        this.$r8$classId = b;
        this.f$1 = obj;
        this.f$2 = obj2;
        this.f$0 = j;
    }
}
