package androidx.compose.runtime.saveable;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.core.provider.CallbackWrapper;
import androidx.savedstate.compose.LocalSavedStateRegistryOwnerKt;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SaveableStateHolderImpl implements SaveableStateHolder {
    public static final CallbackWrapper Saver = new CallbackWrapper(new Updater$$ExternalSyntheticLambda0((byte) 7), new TextKt$$ExternalSyntheticLambda0(28), 7);
    public final TextKt$$ExternalSyntheticLambda2 canBeSaved;
    public SaveableStateRegistry parentSaveableStateRegistry;
    public final MutableScatterMap registries;
    public final Map savedStates;

    public SaveableStateHolderImpl(Map map) {
        this.savedStates = map;
        long[] jArr = ScatterMapKt.EmptyGroup;
        this.registries = new MutableScatterMap();
        this.canBeSaved = new TextKt$$ExternalSyntheticLambda2((byte) 16, this);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public final void SaveableStateProvider(Object obj, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(533563200);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(obj) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(this) ? 256 : 128;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            gapComposer.startReusableGroup(obj);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2 = this.canBeSaved;
                if (!((Boolean) textKt$$ExternalSyntheticLambda2.invoke(obj)).booleanValue()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m("Type of the key ", obj, " is not supported. On Android you can only use types which can be stored inside the Bundle.");
                    return;
                }
                Map map = (Map) this.savedStates.get(obj);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = SaveableStateRegistryKt.LocalSaveableStateRegistry;
                SaveableStateRegistryWrapper saveableStateRegistryWrapper = new SaveableStateRegistryWrapper(new SaveableStateRegistryImpl(map, textKt$$ExternalSyntheticLambda2));
                gapComposer.updateRememberedValue(saveableStateRegistryWrapper);
                objRememberedValue = saveableStateRegistryWrapper;
            }
            SaveableStateRegistryWrapper saveableStateRegistryWrapper2 = (SaveableStateRegistryWrapper) objRememberedValue;
            Stack.CompositionLocalProvider(new ProvidedValue[]{SaveableStateRegistryKt.LocalSaveableStateRegistry.defaultProvidedValue$runtime(saveableStateRegistryWrapper2), LocalSavedStateRegistryOwnerKt.LocalSavedStateRegistryOwner.defaultProvidedValue$runtime(saveableStateRegistryWrapper2)}, composableLambdaImpl, gapComposer, (i2 & 112) | 8);
            boolean zChangedInstance = gapComposer.changedInstance(this) | gapComposer.changedInstance(obj) | gapComposer.changedInstance(saveableStateRegistryWrapper2);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new UtilsKt$$ExternalSyntheticLambda0((Object) this, obj, (Object) saveableStateRegistryWrapper2, (byte) 21);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Stack.DisposableEffect(Unit.INSTANCE, (Function1) objRememberedValue2, gapComposer);
            if (gapComposer.reusing && gapComposer.reader.parent == gapComposer.reusingGroup) {
                gapComposer.reusingGroup = -1;
                gapComposer.reusing = false;
            }
            gapComposer.end(false);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda0((byte) 10, i, (Object) this, obj, (Object) composableLambdaImpl);
        }
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateHolder
    public final void removeState(Object obj) {
        if (this.registries.remove(obj) == null) {
            this.savedStates.remove(obj);
        }
    }
}
