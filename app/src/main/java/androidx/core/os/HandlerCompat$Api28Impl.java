package androidx.core.os;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Icon;
import android.icu.text.DecimalFormatSymbols;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.PrecomputedText;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStructure;
import android.view.textclassifier.TextClassificationContext;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.compose.foundation.text.selection.SelectedTextType;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import io.ktor.http.ContentType;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class HandlerCompat$Api28Impl {
    public static AudioManager audioManager;

    public static Typeface create(Typeface typeface, int i, boolean z) {
        return Typeface.create(typeface, i, z);
    }

    public static Handler createAsync(Looper looper) {
        return Handler.createAsync(looper);
    }

    public static TextClassifier createTextClassificationSession(Context context, SelectedTextType selectedTextType) {
        String str;
        TextClassificationManager textClassificationManager = (TextClassificationManager) context.getSystemService(TextClassificationManager.class);
        int iOrdinal = selectedTextType.ordinal();
        if (iOrdinal == 0) {
            str = "edittext";
        } else {
            if (iOrdinal != 1) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            }
            str = "textview";
        }
        return textClassificationManager.createTextClassificationSession(new TextClassificationContext.Builder(context.getPackageName(), str).build());
    }

    public static synchronized AudioManager getAudioManager(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                audioManager = null;
            }
            AudioManager audioManager2 = audioManager;
            if (audioManager2 != null) {
                return audioManager2;
            }
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper != null && looperMyLooper != Looper.getMainLooper()) {
                ConditionVariable conditionVariable = new ConditionVariable(0);
                Log.get().execute(new ComponentActivity$$ExternalSyntheticLambda10(applicationContext, conditionVariable, (byte) 5));
                conditionVariable.blockUninterruptible();
                AudioManager audioManager3 = audioManager;
                audioManager3.getClass();
                return audioManager3;
            }
            AudioManager audioManager4 = (AudioManager) applicationContext.getSystemService(ContentType.Audio.TYPE);
            audioManager = audioManager4;
            audioManager4.getClass();
            return audioManager4;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static List getBoundingRects(DisplayCutout displayCutout) {
        return displayCutout.getBoundingRects();
    }

    public static final DisplayCutout getCutoutForDisplay(Display display) throws Exception {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(null);
            constructor.setAccessible(true);
            Object objNewInstance = constructor.newInstance(null);
            Method declaredMethod = display.getClass().getDeclaredMethod("getDisplayInfo", objNewInstance.getClass());
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(display, objNewInstance);
            Field declaredField = objNewInstance.getClass().getDeclaredField("displayCutout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objNewInstance);
            if (obj instanceof DisplayCutout) {
                return (DisplayCutout) obj;
            }
            return null;
        } catch (Exception e) {
            if (!(e instanceof ClassNotFoundException) && !(e instanceof NoSuchMethodException) && !(e instanceof NoSuchFieldException) && !(e instanceof IllegalAccessException) && !(e instanceof InvocationTargetException) && !(e instanceof InstantiationException)) {
                throw e;
            }
            android.util.Log.w("BoundsHelper", e);
            return null;
        }
    }

    public static String[] getDigitStrings(DecimalFormatSymbols decimalFormatSymbols) {
        return decimalFormatSymbols.getDigitStrings();
    }

    public static int getResId(Object obj) {
        return ((Icon) obj).getResId();
    }

    public static String getResPackage(Object obj) {
        return ((Icon) obj).getResPackage();
    }

    public static int getSafeInsetBottom(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetBottom();
    }

    public static int getSafeInsetLeft(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetLeft();
    }

    public static int getSafeInsetRight(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetRight();
    }

    public static int getSafeInsetTop(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetTop();
    }

    public static int getStreamMinVolume(AudioManager audioManager2, int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return audioManager2.getStreamMinVolume(i);
        }
        return 0;
    }

    public static PrecomputedText.Params getTextMetricsParams(AppCompatTextView appCompatTextView) {
        return appCompatTextView.getTextMetricsParams();
    }

    public static int getType(Object obj) {
        return ((Icon) obj).getType();
    }

    public static Uri getUri(Object obj) {
        return ((Icon) obj).getUri();
    }

    public static int safeInsetBottom(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetBottom();
    }

    public static int safeInsetLeft(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetLeft();
    }

    public static int safeInsetRight(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetRight();
    }

    public static int safeInsetTop(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetTop();
    }

    public static void setFirstBaselineToTopHeight(TextView textView, int i) {
        textView.setFirstBaselineToTopHeight(i);
    }

    public static void setMaxTextLength(ViewStructure viewStructure, int i) {
        viewStructure.setMaxTextLength(i);
    }

    public static void setOutlineAmbientShadowColor(View view, int i) {
        view.setOutlineAmbientShadowColor(i);
    }

    public static void setOutlineSpotShadowColor(View view, int i) {
        view.setOutlineSpotShadowColor(i);
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration viewConfiguration) {
        return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    }
}
