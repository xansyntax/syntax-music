package androidx.compose.runtime.saveable;

import androidx.activity.SystemBarStyle$Companion$$ExternalSyntheticLambda0;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.core.provider.CallbackWrapper;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda73;
import io.ktor.util.StringValuesKt$$ExternalSyntheticLambda0;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SaverKt {
    public static final CallbackWrapper AutoSaver = new CallbackWrapper(new Updater$$ExternalSyntheticLambda0((byte) 8), new SystemBarStyle$Companion$$ExternalSyntheticLambda0(5), 7);

    public static final String generateCannotBeSavedErrorMessage(Object obj) {
        return obj + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
    }

    public static final CallbackWrapper listSaver(Function2 function2, Function1 function1) {
        StringValuesKt$$ExternalSyntheticLambda0 stringValuesKt$$ExternalSyntheticLambda0 = new StringValuesKt$$ExternalSyntheticLambda0(function2, (byte) 6);
        function1.getClass();
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, function1);
        return new CallbackWrapper(stringValuesKt$$ExternalSyntheticLambda0, function1, (byte) 7);
    }

    public static final Object rememberSaveable(Object[] objArr, Saver saver, Function0 function0, Composer composer, int i, int i2) {
        Object[] objArr2;
        Saver saver2;
        Object obj;
        Object objConsumeRestored;
        GapComposer gapComposer = (GapComposer) composer;
        long j = gapComposer.compositeKeyHashCode;
        CharsKt.checkRadix(36);
        String string = Long.toString(j, 36);
        string.getClass();
        saver.getClass();
        SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) gapComposer.consume(SaveableStateRegistryKt.LocalSaveableStateRegistry);
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (objRememberedValue == neverEqualPolicy) {
            Object objRestore = (saveableStateRegistry == null || (objConsumeRestored = saveableStateRegistry.consumeRestored(string)) == null) ? null : saver.restore(objConsumeRestored);
            if (objRestore == null) {
                objRestore = function0.invoke();
            }
            objArr2 = objArr;
            saver2 = saver;
            SaveableHolder saveableHolder = new SaveableHolder(saver2, saveableStateRegistry, string, objRestore, objArr2);
            gapComposer.updateRememberedValue(saveableHolder);
            objRememberedValue = saveableHolder;
        } else {
            objArr2 = objArr;
            saver2 = saver;
        }
        SaveableHolder saveableHolder2 = (SaveableHolder) objRememberedValue;
        Object objInvoke = Arrays.equals(objArr2, saveableHolder2.inputs) ? saveableHolder2.value : null;
        if (objInvoke == null) {
            objInvoke = function0.invoke();
        }
        boolean zChangedInstance = gapComposer.changedInstance(saveableHolder2) | ((((i & 112) ^ 48) > 32 && gapComposer.changedInstance(saver2)) || (i & 48) == 32) | gapComposer.changedInstance(saveableStateRegistry) | gapComposer.changed(string) | gapComposer.changedInstance(objInvoke) | gapComposer.changedInstance(objArr2);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
            Object[] objArr3 = objArr2;
            obj = objInvoke;
            SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda73 = new SongMenuKt$$ExternalSyntheticLambda73((Object) saveableHolder2, (Object) saver2, (Object) saveableStateRegistry, string, obj, (Object) objArr3, (byte) 2);
            gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda73);
            objRememberedValue2 = songMenuKt$$ExternalSyntheticLambda73;
        } else {
            obj = objInvoke;
        }
        Stack.SideEffect((Function0) objRememberedValue2, gapComposer);
        return obj;
    }

    public static final SaveableStateHolderImpl rememberSaveableStateHolder(Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(1967007413);
        Object[] objArr = new Object[0];
        Object objRememberedValue = gapComposer.rememberedValue();
        if (objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new TextKt$$ExternalSyntheticLambda3((byte) 15);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        SaveableStateHolderImpl saveableStateHolderImpl = (SaveableStateHolderImpl) m393rememberSaveable(objArr, (Saver) SaveableStateHolderImpl.Saver, (Function0) objRememberedValue, (Composer) gapComposer, 384);
        saveableStateHolderImpl.parentSaveableStateRegistry = (SaveableStateRegistry) gapComposer.consume(SaveableStateRegistryKt.LocalSaveableStateRegistry);
        gapComposer.end(false);
        return saveableStateHolderImpl;
    }

    /* JADX INFO: renamed from: rememberSaveable, reason: collision with other method in class */
    public static final Object m393rememberSaveable(Object[] objArr, Saver saver, Function0 function0, Composer composer, int i) {
        return rememberSaveable(Arrays.copyOf(objArr, objArr.length), saver, function0, composer, 384 | ((i << 3) & 7168), 0);
    }

    public static final MutableState rememberSaveable(Object[] objArr, Saver saver, Function0 function0, Composer composer, int i) {
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        saver.getClass();
        return (MutableState) rememberSaveable(objArrCopyOf, new CallbackWrapper(new ComposerKt$$ExternalSyntheticLambda0((byte) 23, saver), new TextKt$$ExternalSyntheticLambda2((byte) 15, saver), (byte) 7), function0, composer, ((i << 3) & 7168) | 384, 0);
    }

    public static final Object rememberSaveable(Object[] objArr, Function0 function0, Composer composer, int i) {
        return rememberSaveable(Arrays.copyOf(objArr, objArr.length), AutoSaver, function0, composer, ((i << 6) & 7168) | 384, 0);
    }
}
