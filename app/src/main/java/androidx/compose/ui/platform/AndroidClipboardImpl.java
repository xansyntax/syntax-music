package androidx.compose.ui.platform;

import android.content.ClipData;
import android.os.Build;
import androidx.core.provider.CallbackWrapper;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidClipboardImpl implements Clipboard {
    public final CallbackWrapper androidClipboardManager;

    public AndroidClipboardImpl(CallbackWrapper callbackWrapper) {
        this.androidClipboardManager = callbackWrapper;
    }

    public final void setClipEntry(ClipEntry clipEntry) {
        CallbackWrapper callbackWrapper = this.androidClipboardManager;
        if (clipEntry != null) {
            callbackWrapper.getClipboardManager().setPrimaryClip(clipEntry.clipData);
        } else if (Build.VERSION.SDK_INT >= 28) {
            Api28ClipboardManagerClipClear.clearPrimaryClip(callbackWrapper.getClipboardManager());
        } else {
            callbackWrapper.getClipboardManager().setPrimaryClip(ClipData.newPlainText("", ""));
        }
    }
}
