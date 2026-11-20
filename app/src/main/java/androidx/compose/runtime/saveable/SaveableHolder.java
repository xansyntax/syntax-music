package androidx.compose.runtime.saveable;

import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.emoji2.text.EmojiProcessor;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SaveableHolder implements RememberObserver {
    public SaveableStateRegistry.Entry entry;
    public Object[] inputs;
    public String key;
    public SaveableStateRegistry registry;
    public Saver saver;
    public Object value;
    public final RoomDatabase$$ExternalSyntheticLambda0 valueProvider = new RoomDatabase$$ExternalSyntheticLambda0(3, this);

    public SaveableHolder(Saver saver, SaveableStateRegistry saveableStateRegistry, String str, Object obj, Object[] objArr) {
        this.saver = saver;
        this.registry = saveableStateRegistry;
        this.key = str;
        this.value = obj;
        this.inputs = objArr;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        SaveableStateRegistry.Entry entry = this.entry;
        if (entry != null) {
            ((EmojiProcessor) entry).unregister();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        SaveableStateRegistry.Entry entry = this.entry;
        if (entry != null) {
            ((EmojiProcessor) entry).unregister();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
        register$1();
    }

    public final void register$1() {
        String strGenerateCannotBeSavedErrorMessage;
        SaveableStateRegistry saveableStateRegistry = this.registry;
        SaveableStateRegistry.Entry entry = this.entry;
        if (entry != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m("entry(", entry, ") is not null");
            return;
        }
        if (saveableStateRegistry != null) {
            RoomDatabase$$ExternalSyntheticLambda0 roomDatabase$$ExternalSyntheticLambda0 = this.valueProvider;
            Object objInvoke = roomDatabase$$ExternalSyntheticLambda0.invoke();
            if (objInvoke == null || saveableStateRegistry.canBeSaved(objInvoke)) {
                this.entry = saveableStateRegistry.registerProvider(this.key, roomDatabase$$ExternalSyntheticLambda0);
                return;
            }
            if (objInvoke instanceof SnapshotMutableState) {
                SnapshotMutableState snapshotMutableState = (SnapshotMutableState) objInvoke;
                if (snapshotMutableState.getPolicy() == NeverEqualPolicy.INSTANCE || snapshotMutableState.getPolicy() == NeverEqualPolicy.INSTANCE$3 || snapshotMutableState.getPolicy() == NeverEqualPolicy.INSTANCE$1) {
                    strGenerateCannotBeSavedErrorMessage = "MutableState containing " + snapshotMutableState.getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
                } else {
                    strGenerateCannotBeSavedErrorMessage = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
                }
            } else {
                strGenerateCannotBeSavedErrorMessage = SaverKt.generateCannotBeSavedErrorMessage(objInvoke);
            }
            throw new IllegalArgumentException(strGenerateCannotBeSavedErrorMessage);
        }
    }
}
