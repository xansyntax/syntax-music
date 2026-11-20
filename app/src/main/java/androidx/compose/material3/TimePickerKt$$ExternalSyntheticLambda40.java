package androidx.compose.material3;

import androidx.media3.extractor.text.CueDecoder;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TimePickerKt$$ExternalSyntheticLambda40 implements Function0 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda40(int i, TimePickerState timePickerState, Function0 function0) {
        this.f$0 = i;
        this.f$1 = timePickerState;
        this.f$2 = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                boolean z = this.f$0;
                TimePickerState timePickerState = (TimePickerState) this.f$1;
                Function0 function0 = (Function0) this.f$2;
                if (z != timePickerState.mo241getSelectionyecRtBI()) {
                    timePickerState.mo242setSelection6_8s6DQ(z ? 1 : 0);
                }
                function0.invoke();
                return Unit.INSTANCE;
            default:
                boolean z2 = this.f$0;
                SavedStateRegistry savedStateRegistry = (SavedStateRegistry) this.f$1;
                String str = (String) this.f$2;
                if (z2) {
                    SavedStateRegistryImpl savedStateRegistryImpl = savedStateRegistry.impl;
                    synchronized (((CueDecoder) savedStateRegistryImpl.lock)) {
                    }
                }
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda40(boolean z, SavedStateRegistry savedStateRegistry, String str) {
        this.f$0 = z;
        this.f$1 = savedStateRegistry;
        this.f$2 = str;
    }
}
