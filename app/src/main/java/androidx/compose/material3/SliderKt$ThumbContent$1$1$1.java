package androidx.compose.material3;

import androidx.compose.foundation.interaction.DragInteraction$Cancel;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.DragInteraction$Stop;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SliderKt$ThumbContent$1$1$1 implements FlowCollector {
    public final /* synthetic */ SnapshotStateList $interactions;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ SliderKt$ThumbContent$1$1$1(SnapshotStateList snapshotStateList, byte b) {
        this.$r8$classId = b;
        this.$interactions = snapshotStateList;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SnapshotStateList snapshotStateList = this.$interactions;
        switch (b) {
            case 0:
                Interaction interaction = (Interaction) obj;
                if (interaction instanceof FocusInteraction.Focus) {
                    snapshotStateList.add(interaction);
                } else if (interaction instanceof FocusInteraction.Unfocus) {
                    snapshotStateList.remove(((FocusInteraction.Unfocus) interaction).focus);
                } else if (interaction instanceof PressInteraction.Press) {
                    snapshotStateList.add(interaction);
                } else if (interaction instanceof PressInteraction.Release) {
                    snapshotStateList.remove(((PressInteraction.Release) interaction).press);
                } else if (interaction instanceof PressInteraction.Cancel) {
                    snapshotStateList.remove(((PressInteraction.Cancel) interaction).press);
                } else if (interaction instanceof DragInteraction$Start) {
                    snapshotStateList.add(interaction);
                } else if (interaction instanceof DragInteraction$Stop) {
                    snapshotStateList.remove(((DragInteraction$Stop) interaction).start);
                } else if (interaction instanceof DragInteraction$Cancel) {
                    snapshotStateList.remove(((DragInteraction$Cancel) interaction).start);
                }
                break;
            case 1:
                Interaction interaction2 = (Interaction) obj;
                if (interaction2 instanceof HoverInteraction$Enter) {
                    snapshotStateList.add(interaction2);
                } else if (interaction2 instanceof HoverInteraction$Exit) {
                    snapshotStateList.remove(((HoverInteraction$Exit) interaction2).enter);
                } else if (interaction2 instanceof FocusInteraction.Focus) {
                    snapshotStateList.add(interaction2);
                } else if (interaction2 instanceof FocusInteraction.Unfocus) {
                    snapshotStateList.remove(((FocusInteraction.Unfocus) interaction2).focus);
                } else if (interaction2 instanceof PressInteraction.Press) {
                    snapshotStateList.add(interaction2);
                } else if (interaction2 instanceof PressInteraction.Release) {
                    snapshotStateList.remove(((PressInteraction.Release) interaction2).press);
                } else if (interaction2 instanceof PressInteraction.Cancel) {
                    snapshotStateList.remove(((PressInteraction.Cancel) interaction2).press);
                }
                break;
            case 2:
                Interaction interaction3 = (Interaction) obj;
                if (interaction3 instanceof HoverInteraction$Enter) {
                    snapshotStateList.add(interaction3);
                } else if (interaction3 instanceof HoverInteraction$Exit) {
                    snapshotStateList.remove(((HoverInteraction$Exit) interaction3).enter);
                } else if (interaction3 instanceof FocusInteraction.Focus) {
                    snapshotStateList.add(interaction3);
                } else if (interaction3 instanceof FocusInteraction.Unfocus) {
                    snapshotStateList.remove(((FocusInteraction.Unfocus) interaction3).focus);
                } else if (interaction3 instanceof PressInteraction.Press) {
                    snapshotStateList.add(interaction3);
                } else if (interaction3 instanceof PressInteraction.Release) {
                    snapshotStateList.remove(((PressInteraction.Release) interaction3).press);
                } else if (interaction3 instanceof PressInteraction.Cancel) {
                    snapshotStateList.remove(((PressInteraction.Cancel) interaction3).press);
                } else if (interaction3 instanceof DragInteraction$Start) {
                    snapshotStateList.add(interaction3);
                } else if (interaction3 instanceof DragInteraction$Stop) {
                    snapshotStateList.remove(((DragInteraction$Stop) interaction3).start);
                } else if (interaction3 instanceof DragInteraction$Cancel) {
                    snapshotStateList.remove(((DragInteraction$Cancel) interaction3).start);
                }
                break;
            case 3:
                Interaction interaction4 = (Interaction) obj;
                if (interaction4 instanceof HoverInteraction$Enter) {
                    snapshotStateList.add(interaction4);
                } else if (interaction4 instanceof HoverInteraction$Exit) {
                    snapshotStateList.remove(((HoverInteraction$Exit) interaction4).enter);
                } else if (interaction4 instanceof FocusInteraction.Focus) {
                    snapshotStateList.add(interaction4);
                } else if (interaction4 instanceof FocusInteraction.Unfocus) {
                    snapshotStateList.remove(((FocusInteraction.Unfocus) interaction4).focus);
                } else if (interaction4 instanceof PressInteraction.Press) {
                    snapshotStateList.add(interaction4);
                } else if (interaction4 instanceof PressInteraction.Release) {
                    snapshotStateList.remove(((PressInteraction.Release) interaction4).press);
                } else if (interaction4 instanceof PressInteraction.Cancel) {
                    snapshotStateList.remove(((PressInteraction.Cancel) interaction4).press);
                } else if (interaction4 instanceof DragInteraction$Start) {
                    snapshotStateList.add(interaction4);
                } else if (interaction4 instanceof DragInteraction$Stop) {
                    snapshotStateList.remove(((DragInteraction$Stop) interaction4).start);
                } else if (interaction4 instanceof DragInteraction$Cancel) {
                    snapshotStateList.remove(((DragInteraction$Cancel) interaction4).start);
                }
                break;
            case 4:
                Interaction interaction5 = (Interaction) obj;
                if (interaction5 instanceof HoverInteraction$Enter) {
                    snapshotStateList.add(interaction5);
                } else if (interaction5 instanceof HoverInteraction$Exit) {
                    snapshotStateList.remove(((HoverInteraction$Exit) interaction5).enter);
                } else if (interaction5 instanceof FocusInteraction.Focus) {
                    snapshotStateList.add(interaction5);
                } else if (interaction5 instanceof FocusInteraction.Unfocus) {
                    snapshotStateList.remove(((FocusInteraction.Unfocus) interaction5).focus);
                } else if (interaction5 instanceof PressInteraction.Press) {
                    snapshotStateList.add(interaction5);
                } else if (interaction5 instanceof PressInteraction.Release) {
                    snapshotStateList.remove(((PressInteraction.Release) interaction5).press);
                } else if (interaction5 instanceof PressInteraction.Cancel) {
                    snapshotStateList.remove(((PressInteraction.Cancel) interaction5).press);
                } else if (interaction5 instanceof DragInteraction$Start) {
                    snapshotStateList.add(interaction5);
                } else if (interaction5 instanceof DragInteraction$Stop) {
                    snapshotStateList.remove(((DragInteraction$Stop) interaction5).start);
                } else if (interaction5 instanceof DragInteraction$Cancel) {
                    snapshotStateList.remove(((DragInteraction$Cancel) interaction5).start);
                }
                break;
            default:
                Interaction interaction6 = (Interaction) obj;
                if (interaction6 instanceof HoverInteraction$Enter) {
                    snapshotStateList.add(interaction6);
                } else if (interaction6 instanceof HoverInteraction$Exit) {
                    snapshotStateList.remove(((HoverInteraction$Exit) interaction6).enter);
                } else if (interaction6 instanceof FocusInteraction.Focus) {
                    snapshotStateList.add(interaction6);
                } else if (interaction6 instanceof FocusInteraction.Unfocus) {
                    snapshotStateList.remove(((FocusInteraction.Unfocus) interaction6).focus);
                } else if (interaction6 instanceof PressInteraction.Press) {
                    snapshotStateList.add(interaction6);
                } else if (interaction6 instanceof PressInteraction.Release) {
                    snapshotStateList.remove(((PressInteraction.Release) interaction6).press);
                } else if (interaction6 instanceof PressInteraction.Cancel) {
                    snapshotStateList.remove(((PressInteraction.Cancel) interaction6).press);
                }
                break;
        }
        return unit;
    }
}
