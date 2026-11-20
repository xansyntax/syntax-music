package androidx.compose.ui.platform;

import android.os.Build;
import android.os.LocaleList;
import android.os.StrictMode;
import android.view.View;
import androidx.collection.MutableObjectList;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.os.LocaleListCompat;
import androidx.core.os.LocaleListPlatformWrapper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidComposeView$$ExternalSyntheticLambda4 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ AndroidComposeView f$0;

    public /* synthetic */ AndroidComposeView$$ExternalSyntheticLambda4(AndroidComposeView androidComposeView, byte b) {
        this.$r8$classId = b;
        this.f$0 = androidComposeView;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        int i = 0;
        AndroidComposeView androidComposeView = this.f$0;
        switch (b) {
            case 0:
                Boolean bool = (Boolean) androidComposeView.isAttached$delegate.getValue();
                bool.getClass();
                return bool;
            case 1:
                AndroidViewsHandler androidViewsHandler = androidComposeView._androidViewsHandler;
                if (androidViewsHandler != null) {
                    int childCount = androidViewsHandler.getChildCount();
                    while (i < childCount) {
                        View childAt = androidViewsHandler.getChildAt(i);
                        AndroidViewHolder androidViewHolder = childAt instanceof AndroidViewHolder ? (AndroidViewHolder) childAt : null;
                        if (androidViewHolder != null && androidViewHolder.isLayoutRequested()) {
                            androidViewHolder.layout(androidViewHolder.getLeft(), androidViewHolder.getTop(), androidViewHolder.getRight(), androidViewHolder.getBottom());
                        }
                        i++;
                    }
                }
                return Unit.INSTANCE;
            case 2:
                if (Build.VERSION.SDK_INT > 28 && androidComposeView.isAttachedToWindow()) {
                    if (AndroidComposeView.systemPropertiesChangedRunnable == null) {
                        AndroidComposeView$Companion$$ExternalSyntheticLambda0 androidComposeView$Companion$$ExternalSyntheticLambda0 = new AndroidComposeView$Companion$$ExternalSyntheticLambda0();
                        AndroidComposeView.systemPropertiesChangedRunnable = androidComposeView$Companion$$ExternalSyntheticLambda0;
                        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
                        try {
                            if (AndroidComposeView.systemPropertiesClass == null) {
                                AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                            }
                            Method declaredMethod = AndroidComposeView.addChangeCallbackMethod;
                            if (declaredMethod == null) {
                                StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
                                Class cls = AndroidComposeView.systemPropertiesClass;
                                declaredMethod = cls != null ? cls.getDeclaredMethod("addChangeCallback", Runnable.class) : null;
                                AndroidComposeView.addChangeCallbackMethod = declaredMethod;
                            }
                            if (declaredMethod != null) {
                                declaredMethod.invoke(null, androidComposeView$Companion$$ExternalSyntheticLambda0);
                            }
                            break;
                        } catch (Throwable unused) {
                        }
                        StrictMode.setVmPolicy(vmPolicy);
                    }
                    MutableObjectList mutableObjectList = AndroidComposeView.composeViews;
                    synchronized (mutableObjectList) {
                        mutableObjectList.add(androidComposeView);
                    }
                }
                return Unit.INSTANCE;
            case 3:
                LocaleList locales = androidComposeView.getConfiguration().getLocales();
                LocaleListCompat localeListCompat = new LocaleListCompat(new LocaleListPlatformWrapper(locales));
                if (locales.isEmpty()) {
                    localeListCompat = new LocaleListCompat(new LocaleListPlatformWrapper(LocaleList.getDefault()));
                }
                LocaleListPlatformWrapper localeListPlatformWrapper = localeListCompat.mImpl;
                int size = localeListPlatformWrapper.mLocaleList.size();
                ArrayList arrayList = new ArrayList(size);
                while (i < size) {
                    Locale locale = localeListPlatformWrapper.mLocaleList.get(i);
                    locale.getClass();
                    arrayList.add(new androidx.compose.ui.text.intl.Locale(locale));
                    i++;
                }
                return new androidx.compose.ui.text.intl.LocaleList(arrayList);
            default:
                AndroidComposeView.resendMotionEventOnLayout$lambda$0(androidComposeView);
                return Unit.INSTANCE;
        }
    }
}
