package androidx.activity;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda1;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.navigationevent.DirectNavigationEventInput;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ComponentActivity f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda1(ComponentActivity componentActivity, byte b) {
        this.$r8$classId = b;
        this.f$0 = componentActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        ComponentActivity componentActivity = this.f$0;
        switch (b) {
            case 0:
                return ComponentActivity.fullyDrawnReporter_delegate$lambda$0(componentActivity);
            case 1:
                componentActivity.reportFullyDrawn();
                return Unit.INSTANCE;
            case 2:
                DirectNavigationEventInput directNavigationEventInput = new DirectNavigationEventInput();
                componentActivity.getNavigationEventDispatcher().addInput(directNavigationEventInput);
                return directNavigationEventInput;
            case 3:
                return new SavedStateViewModelFactory(componentActivity.getApplication(), componentActivity, componentActivity.getIntent() != null ? componentActivity.getIntent().getExtras() : null);
            default:
                byte b2 = 1;
                OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(new ComponentActivity$$ExternalSyntheticLambda0(componentActivity, (byte) 1));
                if (Build.VERSION.SDK_INT >= 33) {
                    if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                        componentActivity.getLifecycle().addObserver(new MenuHostHelper$$ExternalSyntheticLambda1(onBackPressedDispatcher, componentActivity, b2));
                    } else {
                        new Handler(Looper.getMainLooper()).post(new ComponentActivity$$ExternalSyntheticLambda10(componentActivity, onBackPressedDispatcher, (byte) 0));
                    }
                }
                return onBackPressedDispatcher;
        }
    }
}
