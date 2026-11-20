package androidx.compose.ui.platform;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat f$0;

    public /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda2(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, byte b) {
        this.$r8$classId = b;
        this.f$0 = androidComposeViewAccessibilityDelegateCompat;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.f$0;
        switch (b) {
            case 0:
                View view = androidComposeViewAccessibilityDelegateCompat.view;
                return Boolean.valueOf(view.getParent().requestSendAccessibilityEvent(view, (AccessibilityEvent) obj));
            default:
                ScrollObservationScope scrollObservationScope = (ScrollObservationScope) obj;
                if (scrollObservationScope.allScopes.contains(scrollObservationScope)) {
                    OwnerSnapshotObserver snapshotObserver = androidComposeViewAccessibilityDelegateCompat.view.getSnapshotObserver();
                    snapshotObserver.observer.observeReads(scrollObservationScope, androidComposeViewAccessibilityDelegateCompat.scheduleScrollEventIfNeededLambda, new ComponentRegistry$Builder$$ExternalSyntheticLambda2((Object) scrollObservationScope, (Object) androidComposeViewAccessibilityDelegateCompat, (byte) 1));
                }
                return Unit.INSTANCE;
        }
    }
}
