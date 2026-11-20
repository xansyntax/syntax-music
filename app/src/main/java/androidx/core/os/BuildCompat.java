package androidx.core.os;

import android.graphics.Insets;
import android.graphics.Outline;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.view.DisplayCutout;
import android.view.Surface;
import android.view.View;
import android.view.Window;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$ImageAndVideo;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$ImageOnly;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$VisualMediaType;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.media3.common.util.Log;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BuildCompat {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api30Impl {
        public static Icon createWithAdaptiveBitmapContentUri(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }

        public static void getExtensionVersion(int i) {
            SdkExtensions.getExtensionVersion(i);
        }

        public static CharSequence getStateDescription(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static String getVisualMimeType$activity(ActivityResultContracts$PickVisualMedia$VisualMediaType activityResultContracts$PickVisualMedia$VisualMediaType) {
            if (activityResultContracts$PickVisualMedia$VisualMediaType instanceof ActivityResultContracts$PickVisualMedia$ImageOnly) {
                return "image/*";
            }
            if (activityResultContracts$PickVisualMedia$VisualMediaType instanceof ActivityResultContracts$PickVisualMedia$ImageAndVideo) {
                return null;
            }
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return null;
        }

        public static Insets getWaterfallInsets(DisplayCutout displayCutout) {
            return displayCutout.getWaterfallInsets();
        }

        public static boolean isSystemPickerAvailable$activity() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 33) {
                return true;
            }
            return i >= 30 && SdkExtensions.getExtensionVersion(30) >= 2;
        }

        public static void setDecorFitsSystemWindows(Window window, boolean z) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility & (-257) : systemUiVisibility | 256);
            window.setDecorFitsSystemWindows(z);
        }

        public static void setImportantForContentCapture(View view) {
            view.setImportantForContentCapture(1);
        }

        public static void setInitialSurroundingSubText(EditorInfo editorInfo, CharSequence charSequence) {
            editorInfo.setInitialSurroundingSubText(charSequence, 0);
        }

        public static void setPath(Outline outline, AndroidPath androidPath) {
            if (androidPath instanceof AndroidPath) {
                outline.setPath(androidPath.internalPath);
            } else {
                PathKt$$ExternalSyntheticBUOutline0.m$2("Unable to obtain android.graphics.Path");
            }
        }

        public static void setStateDescription(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }

        public static void setSurfaceFrameRate(Surface surface, float f) {
            try {
                surface.setFrameRate(f, f == CropImageView.DEFAULT_ASPECT_RATIO ? 0 : 1);
            } catch (IllegalStateException e) {
                Log.e("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e);
            }
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            Api30Impl.getExtensionVersion(30);
        }
        if (i >= 30) {
            Api30Impl.getExtensionVersion(31);
        }
        if (i >= 30) {
            Api30Impl.getExtensionVersion(33);
        }
        if (i >= 30) {
            Api30Impl.getExtensionVersion(1000000);
        }
    }
}
