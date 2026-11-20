package androidx.compose.ui.platform;

import android.os.Build;
import androidx.collection.MutableObjectList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidComposeView$Companion$$ExternalSyntheticLambda0 implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        MutableObjectList mutableObjectList = AndroidComposeView.composeViews;
        synchronized (mutableObjectList) {
            try {
                int i = Build.VERSION.SDK_INT;
                Object[] objArr = mutableObjectList.content;
                int i2 = mutableObjectList._size;
                int i3 = 0;
                if (i < 30) {
                    while (i3 < i2) {
                        AndroidComposeView androidComposeView = (AndroidComposeView) objArr[i3];
                        boolean showLayoutBounds = androidComposeView.getShowLayoutBounds();
                        Class cls = AndroidComposeView.systemPropertiesClass;
                        androidComposeView.setShowLayoutBounds(InvertMatrixKt.getIsShowingLayoutBounds());
                        if (showLayoutBounds != androidComposeView.getShowLayoutBounds()) {
                            androidComposeView.post(new AndroidComposeView$$ExternalSyntheticLambda3(androidComposeView, (byte) 2));
                        }
                        i3++;
                    }
                } else {
                    while (i3 < i2) {
                        AndroidComposeView androidComposeView2 = (AndroidComposeView) objArr[i3];
                        androidComposeView2.post(new AndroidComposeView$$ExternalSyntheticLambda3(androidComposeView2, (byte) 3));
                        i3++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
