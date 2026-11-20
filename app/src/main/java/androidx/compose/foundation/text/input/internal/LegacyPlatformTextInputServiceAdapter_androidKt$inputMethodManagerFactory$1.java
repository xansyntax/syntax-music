package androidx.compose.foundation.text.input.internal;

import android.view.View;
import androidx.compose.ui.platform.WeakCache;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LegacyPlatformTextInputServiceAdapter_androidKt$inputMethodManagerFactory$1 extends FunctionReferenceImpl implements Function1 {
    public static final LegacyPlatformTextInputServiceAdapter_androidKt$inputMethodManagerFactory$1 INSTANCE = new LegacyPlatformTextInputServiceAdapter_androidKt$inputMethodManagerFactory$1(1, WeakCache.class, "<init>", "<init>(Landroid/view/View;)V", 0);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return new WeakCache((View) obj);
    }
}
