package androidx.core.view;

import android.view.ViewParent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ViewKt$ancestors$1 extends FunctionReferenceImpl implements Function1 {
    public static final ViewKt$ancestors$1 INSTANCE = new ViewKt$ancestors$1(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((ViewParent) obj).getParent();
    }
}
