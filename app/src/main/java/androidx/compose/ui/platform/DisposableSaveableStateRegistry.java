package androidx.compose.ui.platform;

import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda40;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryImpl;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DisposableSaveableStateRegistry implements SaveableStateRegistry {
    public final /* synthetic */ SaveableStateRegistryImpl $$delegate_0;
    public final TimePickerKt$$ExternalSyntheticLambda40 onDispose;

    public DisposableSaveableStateRegistry(SaveableStateRegistryImpl saveableStateRegistryImpl, TimePickerKt$$ExternalSyntheticLambda40 timePickerKt$$ExternalSyntheticLambda40) {
        this.$$delegate_0 = saveableStateRegistryImpl;
        this.onDispose = timePickerKt$$ExternalSyntheticLambda40;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final boolean canBeSaved(Object obj) {
        return this.$$delegate_0.canBeSaved(obj);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final Object consumeRestored(String str) {
        return this.$$delegate_0.consumeRestored(str);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final Map performSave() {
        return this.$$delegate_0.performSave();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final SaveableStateRegistry.Entry registerProvider(String str, Function0 function0) {
        return this.$$delegate_0.registerProvider(str, function0);
    }
}
