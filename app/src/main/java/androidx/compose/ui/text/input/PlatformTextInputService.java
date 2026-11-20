package androidx.compose.ui.text.input;

import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import coil3.network.okhttp.internal.CallsKt$await$2$1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface PlatformTextInputService {
    void hideSoftwareKeyboard();

    void notifyFocusedRect(Rect rect);

    void showSoftwareKeyboard();

    void startInput();

    void startInput(TextFieldValue textFieldValue, ImeOptions imeOptions, UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0, CoreTextFieldKt$$ExternalSyntheticLambda1 coreTextFieldKt$$ExternalSyntheticLambda1);

    void stopInput();

    void updateState(TextFieldValue textFieldValue, TextFieldValue textFieldValue2);

    void updateTextLayoutResult(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, CallsKt$await$2$1 callsKt$await$2$1, Rect rect, Rect rect2);
}
