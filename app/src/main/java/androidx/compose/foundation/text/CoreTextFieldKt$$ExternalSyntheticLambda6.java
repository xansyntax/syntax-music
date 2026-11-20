package androidx.compose.foundation.text;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.LazyWindowInfo;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.core.content.FileProvider;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import coil3.size.SizeKt;
import com.metrolist.music.viewmodels.HomeViewModel;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CoreTextFieldKt$$ExternalSyntheticLambda6 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;

    public /* synthetic */ CoreTextFieldKt$$ExternalSyntheticLambda6(Context context, ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, String str, boolean z, ColorScheme colorScheme) {
        this.$r8$classId = (byte) 2;
        this.f$0 = context;
        this.f$2 = managedActivityResultLauncher;
        this.f$3 = mutableState;
        this.f$4 = str;
        this.f$1 = z;
        this.f$5 = colorScheme;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        TextInputSession textInputSession;
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2;
        byte b = this.$r8$classId;
        boolean z = this.f$1;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$5;
        Object obj3 = this.f$4;
        Object obj4 = this.f$3;
        Object obj5 = this.f$2;
        Object obj6 = this.f$0;
        switch (b) {
            case 0:
                LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) obj6;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = legacyTextFieldState.showCursorHandle$delegate;
                WindowInfo windowInfo = (WindowInfo) obj5;
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) obj4;
                TextFieldValue textFieldValue = (TextFieldValue) obj3;
                OffsetMapping offsetMapping = (OffsetMapping) obj2;
                LayoutCoordinates layoutCoordinates3 = (LayoutCoordinates) obj;
                legacyTextFieldState._layoutCoordinates = layoutCoordinates3;
                TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                if (layoutResult != null) {
                    layoutResult.innerTextFieldCoordinates = layoutCoordinates3;
                }
                if (z) {
                    if (legacyTextFieldState.getHandleState() == HandleState.Selection) {
                        if (((Boolean) legacyTextFieldState.showFloatingToolbar$delegate.getValue()).booleanValue() && ((LazyWindowInfo) windowInfo).isWindowFocused()) {
                            textFieldSelectionManager.showSelectionToolbar$foundation();
                        } else {
                            textFieldSelectionManager.hideSelectionToolbar$foundation();
                        }
                        legacyTextFieldState.showSelectionHandleStart$delegate.setValue(Boolean.valueOf(MathKt.isSelectionHandleInVisibleBoundDefault(textFieldSelectionManager, true)));
                        legacyTextFieldState.showSelectionHandleEnd$delegate.setValue(Boolean.valueOf(MathKt.isSelectionHandleInVisibleBoundDefault(textFieldSelectionManager, false)));
                        parcelableSnapshotMutableState.setValue(Boolean.valueOf(TextRange.m741getCollapsedimpl(textFieldValue.selection)));
                    } else if (legacyTextFieldState.getHandleState() == HandleState.Cursor) {
                        parcelableSnapshotMutableState.setValue(Boolean.valueOf(MathKt.isSelectionHandleInVisibleBoundDefault(textFieldSelectionManager, true)));
                    }
                    BasicTextKt.notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
                    TextLayoutResultProxy layoutResult2 = legacyTextFieldState.getLayoutResult();
                    if (layoutResult2 != null && (textInputSession = legacyTextFieldState.inputSession) != null && legacyTextFieldState.getHasFocus() && (layoutCoordinates = layoutResult2.innerTextFieldCoordinates) != null && layoutCoordinates.isAttached$1() && (layoutCoordinates2 = layoutResult2.decorationBoxCoordinates) != null) {
                        TextLayoutResult textLayoutResult = layoutResult2.value;
                        CallsKt$await$2$1 callsKt$await$2$1 = new CallsKt$await$2$1((byte) 3, layoutCoordinates);
                        Rect rectVisibleBounds = SizeKt.visibleBounds(layoutCoordinates);
                        Rect rectLocalBoundingBoxOf = layoutCoordinates.localBoundingBoxOf(layoutCoordinates2, false);
                        if (Intrinsics.areEqual((TextInputSession) textInputSession.textInputService._currentInputSession.get(), textInputSession)) {
                            textInputSession.platformTextInputService.updateTextLayoutResult(textFieldValue, offsetMapping, textLayoutResult, callsKt$await$2$1, rectVisibleBounds, rectLocalBoundingBoxOf);
                        }
                    }
                }
                break;
            case 1:
                ((Boolean) obj).getClass();
                AwaitKt.launch$default((CoroutineScope) obj6, null, null, new HomeViewModel.AnonymousClass2(this.f$1, (Context) obj5, (String) obj4, (String) obj3, (MutableState) obj2, null, (byte) 1), 3);
                break;
            default:
                Context context = (Context) obj6;
                ManagedActivityResultLauncher managedActivityResultLauncher = (ManagedActivityResultLauncher) obj5;
                MutableState mutableState = (MutableState) obj4;
                String str = (String) obj3;
                ColorScheme colorScheme = (ColorScheme) obj2;
                Uri uri = (Uri) obj;
                if (uri != null) {
                    Uri uriForFile = FileProvider.getUriForFile(context, new File(context.getCacheDir(), IntIntPair$$ExternalSyntheticOutline0.m(System.currentTimeMillis(), "playlist_cover_crop_", ".jpg")), context.getPackageName() + ".FileProvider");
                    mutableState.setValue(uriForFile);
                    UCrop.Options options = new UCrop.Options();
                    options.setCompressionFormat(Bitmap.CompressFormat.JPEG);
                    options.setCompressionQuality(90);
                    options.setHideBottomControls(true);
                    options.setToolbarTitle(str);
                    options.setStatusBarLight(!z);
                    long j = colorScheme.surface;
                    options.setToolbarColor(ColorKt.m498toArgb8_81llA(j));
                    options.setToolbarWidgetColor(ColorKt.m498toArgb8_81llA(colorScheme.inverseSurface));
                    options.setRootViewBackgroundColor(ColorKt.m498toArgb8_81llA(j));
                    options.setLogoColor(ColorKt.m498toArgb8_81llA(j));
                    Intent intent = UCrop.of(uri, uriForFile).withAspectRatio(1.0f, 1.0f).withOptions(options).getIntent(context);
                    intent.addFlags(1);
                    intent.addFlags(2);
                    managedActivityResultLauncher.launch(intent);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ CoreTextFieldKt$$ExternalSyntheticLambda6(byte b, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, boolean z) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = z;
        this.f$2 = obj2;
        this.f$3 = obj3;
        this.f$4 = obj4;
        this.f$5 = obj5;
    }
}
