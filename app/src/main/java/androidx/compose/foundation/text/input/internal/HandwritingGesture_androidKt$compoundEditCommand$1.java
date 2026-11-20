package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.text.input.EditCommand;
import androidx.media3.common.util.LongArrayQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HandwritingGesture_androidKt$compoundEditCommand$1 implements EditCommand {
    public final /* synthetic */ EditCommand[] $editCommands;

    public HandwritingGesture_androidKt$compoundEditCommand$1(EditCommand[] editCommandArr) {
        this.$editCommands = editCommandArr;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final void applyTo(LongArrayQueue longArrayQueue) {
        for (EditCommand editCommand : this.$editCommands) {
            editCommand.applyTo(longArrayQueue);
        }
    }
}
