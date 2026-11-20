package coil3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import coil3.request.Disposable;
import coil3.request.ImageRequest;
import coil3.request.Options;
import coil3.request.ViewTargetDisposable;
import coil3.request.ViewTargetRequestManager;
import coil3.target.GenericViewTarget;
import coil3.target.Target;
import coil3.util.Utils_androidKt;
import com.metrolist.music.db.DatabaseDao_Impl;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.DeferredCoroutine;
import kotlinx.coroutines.StandaloneCoroutine;
import okhttp3.ConnectionPool;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UriKt {
    public static final Extras.Key serviceLoaderEnabledKey = new Extras.Key(Boolean.TRUE);

    public static Uri Uri$default(String str) {
        String str2 = Path.DIRECTORY_SEPARATOR;
        StringBuilder sbM = Format$$ExternalSyntheticOutline0.m("file:");
        if (str != null) {
            sbM.append(str);
        }
        return new Uri(sbM.toString(), str2, "file", null, str);
    }

    public static final Drawable asDrawable(Image image, Resources resources) {
        if (image instanceof DrawableImage) {
            return ((DrawableImage) image).drawable;
        }
        return image instanceof BitmapImage ? new BitmapDrawable(resources, ((BitmapImage) image).bitmap) : new ImageDrawable((byte) 0, image);
    }

    public static final Image asImage(Drawable drawable) {
        return drawable instanceof BitmapDrawable ? new BitmapImage(((BitmapDrawable) drawable).getBitmap()) : new DrawableImage(drawable);
    }

    public static final Disposable getDisposable(ImageRequest imageRequest, DeferredCoroutine deferredCoroutine) {
        Target target = imageRequest.target;
        if (!(target instanceof GenericViewTarget)) {
            return new ConnectionPool(deferredCoroutine);
        }
        ViewTargetRequestManager requestManager = DatabaseDao_Impl.AnonymousClass17.getRequestManager(((GenericViewTarget) target).getView());
        synchronized (requestManager) {
            ViewTargetDisposable viewTargetDisposable = requestManager.currentDisposable;
            if (viewTargetDisposable != null) {
                Bitmap.Config[] configArr = Utils_androidKt.VALID_TRANSFORMATION_CONFIGS;
                if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) && requestManager.isRestart) {
                    requestManager.isRestart = false;
                    viewTargetDisposable.job = deferredCoroutine;
                    return viewTargetDisposable;
                }
            }
            StandaloneCoroutine standaloneCoroutine = requestManager.pendingClear;
            if (standaloneCoroutine != null) {
                standaloneCoroutine.cancel(null);
            }
            requestManager.pendingClear = null;
            ViewTargetDisposable viewTargetDisposable2 = new ViewTargetDisposable();
            viewTargetDisposable2.job = deferredCoroutine;
            requestManager.currentDisposable = viewTargetDisposable2;
            return viewTargetDisposable2;
        }
    }

    public static final Object getExtra(ImageRequest imageRequest, Extras.Key key) {
        Object obj = imageRequest.extras.data.get(key);
        if (obj != null) {
            return obj;
        }
        Object obj2 = imageRequest.defaults.extras.data.get(key);
        return obj2 == null ? key.f9default : obj2;
    }

    public static final String getFilePath(Uri uri) {
        List pathSegments = getPathSegments(uri);
        String str = uri.separator;
        if (pathSegments.isEmpty()) {
            return null;
        }
        String str2 = uri.path;
        str2.getClass();
        if (!StringsKt__StringsJVMKt.startsWith(str2, str, false)) {
            str = "";
        }
        return CollectionsKt.joinToString$default(pathSegments, uri.separator, str, null, null, 60);
    }

    public static final List getPathSegments(Uri uri) {
        String str = uri.path;
        if (str == null) {
            return EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        int i = -1;
        while (i < str.length()) {
            int i2 = i + 1;
            int iIndexOf$default = StringsKt.indexOf$default(str, '/', i2, 4);
            if (iIndexOf$default == -1) {
                iIndexOf$default = str.length();
            }
            String strSubstring = str.substring(i2, iIndexOf$default);
            if (strSubstring.length() > 0) {
                arrayList.add(strSubstring);
            }
            i = iIndexOf$default;
        }
        return arrayList;
    }

    public static final String percentDecode(String str, byte[] bArr) {
        int length = str.length();
        int iMax = Math.max(0, length - 2);
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= iMax) {
                if (i == i2) {
                    return str;
                }
                if (i >= length) {
                    return StringsKt__StringsJVMKt.decodeToString$default(0, i2, 5, bArr);
                }
            } else if (str.charAt(i) == '%') {
                int i3 = i + 3;
                try {
                    String strSubstring = str.substring(i + 1, i3);
                    CharsKt.checkRadix(16);
                    bArr[i2] = (byte) Integer.parseInt(strSubstring, 16);
                    i2++;
                    i = i3;
                } catch (NumberFormatException unused) {
                    bArr[i2] = (byte) str.charAt(i);
                    i2++;
                    i++;
                }
            }
            bArr[i2] = (byte) str.charAt(i);
            i2++;
            i++;
        }
    }

    public static Bitmap toBitmap$default(Image image) {
        int width = image.getWidth();
        int height = image.getHeight();
        boolean z = image instanceof BitmapImage;
        Bitmap.Config config = z ? ((BitmapImage) image).bitmap.getConfig() : null;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        if (z) {
            Bitmap bitmap = ((BitmapImage) image).bitmap;
            if (bitmap.getWidth() == width && bitmap.getHeight() == height && bitmap.getConfig() == config) {
                return bitmap;
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, config);
        image.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public static Uri toUri$default(String str) {
        String strSubstring;
        String strSubstring2;
        String str2 = Path.DIRECTORY_SEPARATOR;
        String strReplace = !Intrinsics.areEqual(str2, "/") ? StringsKt__StringsJVMKt.replace(str, str2, "/", false) : str;
        boolean z = true;
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        while (i < strReplace.length()) {
            char cCharAt = strReplace.charAt(i);
            if (cCharAt != '#') {
                if (cCharAt != '/') {
                    if (cCharAt != ':') {
                        if (cCharAt == '?' && i4 == -1 && i2 == -1) {
                            i4 = i + 1;
                        }
                    } else if (z && i4 == -1 && i2 == -1) {
                        int i7 = i + 2;
                        if (i7 < str.length() && str.charAt(i + 1) == '/' && str.charAt(i7) == '/' && i3 == -1) {
                            i5 = i + 3;
                            z = false;
                            i6 = i;
                            i = i7;
                        } else if (strReplace.equals(str)) {
                            i3 = i + 1;
                            i6 = i;
                            i = i3;
                            i5 = i;
                        }
                    }
                } else if (i3 == -1 && i4 == -1 && i2 == -1) {
                    i3 = i5 == -1 ? 0 : i;
                    z = false;
                }
            } else if (i2 == -1) {
                i2 = i + 1;
            }
            i++;
        }
        int iMin = Math.min(i2 == -1 ? Integer.MAX_VALUE : i2 - 1, strReplace.length());
        int iMin2 = Math.min(i4 == -1 ? Integer.MAX_VALUE : i4 - 1, iMin);
        if (i5 != -1) {
            strSubstring2 = strReplace.substring(0, i6);
            strSubstring = strReplace.substring(i5, Math.min(i3 != -1 ? i3 : Integer.MAX_VALUE, iMin2));
        } else {
            strSubstring = null;
            strSubstring2 = null;
        }
        String strSubstring3 = i3 != -1 ? strReplace.substring(i3, iMin2) : null;
        String strSubstring4 = i4 != -1 ? strReplace.substring(i4, iMin) : null;
        String strSubstring5 = i2 != -1 ? strReplace.substring(i2, strReplace.length()) : null;
        byte[] bArr = new byte[Math.max(0, Math.max(strSubstring2 != null ? strSubstring2.length() : 0, Math.max(strSubstring != null ? strSubstring.length() : 0, Math.max(strSubstring3 != null ? strSubstring3.length() : 0, Math.max(strSubstring4 != null ? strSubstring4.length() : 0, strSubstring5 != null ? strSubstring5.length() : 0)))) - 2)];
        String str3 = strSubstring4;
        String strPercentDecode = strSubstring2 != null ? percentDecode(strSubstring2, bArr) : null;
        String strPercentDecode2 = strSubstring != null ? percentDecode(strSubstring, bArr) : null;
        String strPercentDecode3 = strSubstring3 != null ? percentDecode(strSubstring3, bArr) : null;
        if (str3 != null) {
            percentDecode(str3, bArr);
        }
        if (strSubstring5 != null) {
            percentDecode(strSubstring5, bArr);
        }
        return new Uri(strReplace, str2, strPercentDecode, strPercentDecode2, strPercentDecode3);
    }

    public static final Object getExtra(Options options, Extras.Key key) {
        Object obj = options.extras.data.get(key);
        return obj == null ? key.f9default : obj;
    }
}
