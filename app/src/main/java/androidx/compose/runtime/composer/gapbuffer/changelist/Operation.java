package androidx.compose.runtime.composer.gapbuffer.changelist;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.GapRememberObserverHolder;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotTableKt;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.PausedCompositionRemembers;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.text.input.GapBuffer;
import com.metrolist.music.db.DatabaseDao_Impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http2.Huffman;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Operation {
    public final int ints;
    public final int objects;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AdvanceSlotsBy extends Operation {
        public static final AdvanceSlotsBy INSTANCE = new AdvanceSlotsBy(1, 0, 2);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AppendValue extends Operation {
        public static final AppendValue INSTANCE = new AppendValue(0, 2, 1);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            GapAnchor gapAnchor = (GapAnchor) gapBuffer.m758getObjectPtLUHM(0);
            Object objM758getObjectPtLUHM = gapBuffer.m758getObjectPtLUHM(1);
            if (objM758getObjectPtLUHM instanceof RememberObserverHolder) {
                rememberEventDispatcher.remembering((RememberObserverHolder) objM758getObjectPtLUHM);
            }
            if (slotWriter.insertCount != 0) {
                ComposerKt.composeImmediateRuntimeError("Can only append a slot if not current inserting");
            }
            int i = slotWriter.currentSlot;
            int i2 = slotWriter.currentSlotEnd;
            int iAnchorIndex = slotWriter.anchorIndex(gapAnchor);
            int iDataIndex = slotWriter.dataIndex(slotWriter.groupIndexToAddress(iAnchorIndex + 1), slotWriter.groups);
            slotWriter.currentSlot = iDataIndex;
            slotWriter.currentSlotEnd = iDataIndex;
            slotWriter.insertSlots(1, iAnchorIndex);
            if (i >= iDataIndex) {
                i++;
                i2++;
            }
            slotWriter.slots[iDataIndex] = objM758getObjectPtLUHM;
            slotWriter.currentSlot = i;
            slotWriter.currentSlotEnd = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ApplyChangeList extends Operation {
        public static final ApplyChangeList INSTANCE = new ApplyChangeList(0, 2, 1);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            IntRef intRef = (IntRef) gapBuffer.m758getObjectPtLUHM(1);
            int i = intRef != null ? intRef.element : 0;
            ChangeList changeList = (ChangeList) gapBuffer.m758getObjectPtLUHM(0);
            if (i > 0) {
                applier = new Huffman.Node(applier, i);
            }
            changeList.executeAndFlushAllPendingChanges(applier, slotWriter, rememberEventDispatcher, operationErrorContext != null ? new WeakCache((Object) operationErrorContext, (Object) slotWriter, (byte) 7) : null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CopyNodesToNewAnchorLocation extends Operation {
        public static final CopyNodesToNewAnchorLocation INSTANCE = new CopyNodesToNewAnchorLocation(0, 2, 1);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            int i = ((IntRef) gapBuffer.m758getObjectPtLUHM(0)).element;
            List list = (List) gapBuffer.m758getObjectPtLUHM(1);
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = list.get(i2);
                int i3 = i + i2;
                applier.insertBottomUp(i3, obj);
                applier.insertTopDown(i3, obj);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CopySlotTableToAnchorLocation extends Operation {
        public static final CopySlotTableToAnchorLocation INSTANCE = new CopySlotTableToAnchorLocation(0, 4, 1);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            MovableContentStateReference movableContentStateReference = (MovableContentStateReference) gapBuffer.m758getObjectPtLUHM(2);
            CompositionContext compositionContext = (CompositionContext) gapBuffer.m758getObjectPtLUHM(1);
            compositionContext.movableContentStateResolve$runtime(movableContentStateReference);
            ComposerKt.composeRuntimeError("Could not resolve state for movable content");
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DeactivateCurrentGroup extends Operation {
        public static final DeactivateCurrentGroup INSTANCE;

        static {
            int i = 0;
            INSTANCE = new DeactivateCurrentGroup(i, i, 3);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            slotWriter.forAllDataInRememberOrder(slotWriter.currentGroup, new ButtonKt$$ExternalSyntheticLambda1(rememberEventDispatcher, slotWriter, (byte) 26));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DetermineMovableContentNodeIndex extends Operation {
        public static final DetermineMovableContentNodeIndex INSTANCE = new DetermineMovableContentNodeIndex(0, 2, 1);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            int i;
            IntRef intRef = (IntRef) gapBuffer.m758getObjectPtLUHM(0);
            int iAnchorIndex = slotWriter.anchorIndex((GapAnchor) gapBuffer.m758getObjectPtLUHM(1));
            if (slotWriter.currentGroup >= iAnchorIndex) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            DatabaseDao_Impl.AnonymousClass17.positionToParentOf(slotWriter, applier, iAnchorIndex);
            int i2 = slotWriter.currentGroup;
            int iParent = slotWriter.parent;
            while (iParent >= 0 && !slotWriter.isNode(iParent)) {
                iParent = slotWriter.parent(iParent, slotWriter.groups);
            }
            int iGroupSize = iParent + 1;
            int iSkipGroup = 0;
            while (iGroupSize < i2) {
                if (slotWriter.indexInGroup(i2, iGroupSize)) {
                    if (slotWriter.isNode(iGroupSize)) {
                        iSkipGroup = 0;
                    }
                    iGroupSize++;
                } else {
                    iSkipGroup += slotWriter.isNode(iGroupSize) ? 1 : slotWriter.groups[(slotWriter.groupIndexToAddress(iGroupSize) * 5) + 1] & 67108863;
                    iGroupSize += slotWriter.groupSize(iGroupSize);
                }
            }
            while (true) {
                i = slotWriter.currentGroup;
                if (i >= iAnchorIndex) {
                    break;
                }
                if (slotWriter.indexInGroup(iAnchorIndex, i)) {
                    int i3 = slotWriter.currentGroup;
                    if (i3 < slotWriter.currentGroupEnd && (slotWriter.groups[(slotWriter.groupIndexToAddress(i3) * 5) + 1] & 1073741824) != 0) {
                        applier.down(slotWriter.node(slotWriter.currentGroup));
                        iSkipGroup = 0;
                    }
                    slotWriter.startGroup();
                } else {
                    iSkipGroup += slotWriter.skipGroup();
                }
            }
            if (i != iAnchorIndex) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            intRef.element = iSkipGroup;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Downs extends Operation {
        public static final Downs INSTANCE;

        static {
            int i = 1;
            INSTANCE = new Downs(0, i, i);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            for (Object obj : (Object[]) gapBuffer.m758getObjectPtLUHM(0)) {
                applier.down(obj);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class EndCompositionScope extends Operation {
        public static final EndCompositionScope INSTANCE = new EndCompositionScope(0, 2, 1);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            ((Function1) gapBuffer.m758getObjectPtLUHM(0)).invoke((Composition) gapBuffer.m758getObjectPtLUHM(1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class EndCurrentGroup extends Operation {
        public static final EndCurrentGroup INSTANCE;

        static {
            int i = 0;
            INSTANCE = new EndCurrentGroup(i, i, 3);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            slotWriter.endGroup();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class EndMovableContentPlacement extends Operation {
        public static final EndMovableContentPlacement INSTANCE;

        static {
            int i = 0;
            INSTANCE = new EndMovableContentPlacement(i, i, 3);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            DatabaseDao_Impl.AnonymousClass17.positionToParentOf(slotWriter, applier, 0);
            slotWriter.endGroup();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class EndResumingScope extends Operation {
        public static final EndResumingScope INSTANCE;

        static {
            int i = 1;
            INSTANCE = new EndResumingScope(0, i, i);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            MutableVector mutableVector;
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) gapBuffer.m758getObjectPtLUHM(0);
            MutableScatterMap mutableScatterMap = rememberEventDispatcher.pausedPlaceholders;
            if (mutableScatterMap == null || ((PausedCompositionRemembers) mutableScatterMap.get(recomposeScopeImpl)) == null) {
                return;
            }
            ArrayList arrayList = rememberEventDispatcher.nestedRemembersLists;
            if (arrayList != null && (mutableVector = (MutableVector) arrayList.remove(arrayList.size() - 1)) != null) {
                rememberEventDispatcher.currentRememberingList = mutableVector;
            }
            mutableScatterMap.remove(recomposeScopeImpl);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class EnsureGroupStarted extends Operation {
        public static final EnsureGroupStarted INSTANCE;

        static {
            int i = 1;
            INSTANCE = new EnsureGroupStarted(0, i, i);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            GapAnchor gapAnchor = (GapAnchor) gapBuffer.m758getObjectPtLUHM(0);
            gapAnchor.getClass();
            slotWriter.ensureStarted(slotWriter.anchorIndex(gapAnchor));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class EnsureRootGroupStarted extends Operation {
        public static final EnsureRootGroupStarted INSTANCE;

        static {
            int i = 0;
            INSTANCE = new EnsureRootGroupStarted(i, i, 3);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            slotWriter.ensureStarted(0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class InsertSlots extends Operation {
        public static final InsertSlots INSTANCE = new InsertSlots(0, 2, 1);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            SlotTable slotTable = (SlotTable) gapBuffer.m758getObjectPtLUHM(1);
            GapAnchor gapAnchor = (GapAnchor) gapBuffer.m758getObjectPtLUHM(0);
            slotWriter.beginInsert();
            gapAnchor.getClass();
            slotWriter.moveFrom(slotTable, slotTable.anchorIndex(gapAnchor));
            slotWriter.endInsert();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class InsertSlotsWithFixups extends Operation {
        public static final InsertSlotsWithFixups INSTANCE = new InsertSlotsWithFixups(0, 3, 1);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            WeakCache weakCache;
            SlotTable slotTable = (SlotTable) gapBuffer.m758getObjectPtLUHM(1);
            GapAnchor gapAnchor = (GapAnchor) gapBuffer.m758getObjectPtLUHM(0);
            FixupList fixupList = (FixupList) gapBuffer.m758getObjectPtLUHM(2);
            SlotWriter slotWriterOpenWriter = slotTable.openWriter();
            if (operationErrorContext != null) {
                try {
                    weakCache = new WeakCache((Object) operationErrorContext, (Object) slotWriter, (byte) 7);
                } catch (Throwable th) {
                    slotWriterOpenWriter.close(false);
                    throw th;
                }
            } else {
                weakCache = null;
            }
            if (!fixupList.pendingOperations.isEmpty()) {
                ComposerKt.composeImmediateRuntimeError("FixupList has pending fixup operations that were not realized. Were there mismatched insertNode() and endNodeInsert() calls?");
            }
            fixupList.operations.executeAndFlushAllPendingOperations(applier, slotWriterOpenWriter, rememberEventDispatcher, weakCache);
            slotWriterOpenWriter.close(true);
            slotWriter.beginInsert();
            gapAnchor.getClass();
            slotWriter.moveFrom(slotTable, slotTable.anchorIndex(gapAnchor));
            slotWriter.endInsert();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MoveCurrentGroup extends Operation {
        public static final MoveCurrentGroup INSTANCE = new MoveCurrentGroup(1, 0, 2);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            int[] iArr;
            GapAnchor gapAnchor;
            int iAnchorIndex;
            int i = gapBuffer.getInt(0);
            if (slotWriter.insertCount != 0) {
                ComposerKt.composeImmediateRuntimeError("Cannot move a group while inserting");
            }
            if (i < 0) {
                ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
            }
            if (i == 0) {
                return;
            }
            int i2 = slotWriter.currentGroup;
            int i3 = slotWriter.parent;
            int i4 = slotWriter.currentGroupEnd;
            int i5 = i2;
            while (true) {
                iArr = slotWriter.groups;
                if (i <= 0) {
                    break;
                }
                i5 += iArr[(slotWriter.groupIndexToAddress(i5) * 5) + 3];
                if (i5 > i4) {
                    ComposerKt.composeImmediateRuntimeError("Parameter offset is out of bounds");
                }
                i--;
            }
            int i6 = iArr[(slotWriter.groupIndexToAddress(i5) * 5) + 3];
            int iDataIndex = slotWriter.dataIndex(slotWriter.groupIndexToAddress(slotWriter.currentGroup), slotWriter.groups);
            int iDataIndex2 = slotWriter.dataIndex(slotWriter.groupIndexToAddress(i5), slotWriter.groups);
            int i7 = i5 + i6;
            int iDataIndex3 = slotWriter.dataIndex(slotWriter.groupIndexToAddress(i7), slotWriter.groups);
            int i8 = iDataIndex3 - iDataIndex2;
            slotWriter.insertSlots(i8, Math.max(slotWriter.currentGroup - 1, 0));
            slotWriter.insertGroups(i6);
            int[] iArr2 = slotWriter.groups;
            int iGroupIndexToAddress = slotWriter.groupIndexToAddress(i7) * 5;
            ArraysKt.copyInto(slotWriter.groupIndexToAddress(i2) * 5, iGroupIndexToAddress, (i6 * 5) + iGroupIndexToAddress, iArr2, iArr2);
            if (i8 > 0) {
                Object[] objArr = slotWriter.slots;
                int iDataIndexToDataAddress = slotWriter.dataIndexToDataAddress(iDataIndex2 + i8);
                System.arraycopy(objArr, iDataIndexToDataAddress, objArr, iDataIndex, slotWriter.dataIndexToDataAddress(iDataIndex3 + i8) - iDataIndexToDataAddress);
            }
            int i9 = iDataIndex2 + i8;
            int i10 = i9 - iDataIndex;
            int i11 = slotWriter.slotsGapStart;
            int i12 = slotWriter.slotsGapLen;
            int length = slotWriter.slots.length;
            int i13 = slotWriter.slotsGapOwner;
            int i14 = i2 + i6;
            int i15 = i2;
            while (i15 < i14) {
                int iGroupIndexToAddress2 = slotWriter.groupIndexToAddress(i15);
                int i16 = i10;
                int[] iArr3 = iArr2;
                iArr3[(iGroupIndexToAddress2 * 5) + 4] = SlotWriter.dataIndexToDataAnchor(SlotWriter.dataIndexToDataAnchor(slotWriter.dataIndex(iGroupIndexToAddress2, iArr2) - i16, i13 < iGroupIndexToAddress2 ? 0 : i11, i12, length), slotWriter.slotsGapStart, slotWriter.slotsGapLen, slotWriter.slots.length);
                i15++;
                i10 = i16;
                iArr2 = iArr3;
                i11 = i11;
            }
            int i17 = i7 + i6;
            int size$runtime = slotWriter.getSize$runtime();
            int iLocationOf = SlotTableKt.locationOf(slotWriter.anchors, i7, size$runtime);
            ArrayList arrayList = new ArrayList();
            if (iLocationOf >= 0) {
                while (iLocationOf < slotWriter.anchors.size() && (iAnchorIndex = slotWriter.anchorIndex((gapAnchor = (GapAnchor) slotWriter.anchors.get(iLocationOf)))) >= i7 && iAnchorIndex < i17) {
                    arrayList.add(gapAnchor);
                }
            }
            int i18 = i2 - i7;
            int size = arrayList.size();
            for (int i19 = 0; i19 < size; i19++) {
                GapAnchor gapAnchor2 = (GapAnchor) arrayList.get(i19);
                int iAnchorIndex2 = slotWriter.anchorIndex(gapAnchor2) + i18;
                if (iAnchorIndex2 >= slotWriter.groupGapStart) {
                    gapAnchor2.location = -(size$runtime - iAnchorIndex2);
                } else {
                    gapAnchor2.location = iAnchorIndex2;
                }
                slotWriter.anchors.add(SlotTableKt.locationOf(slotWriter.anchors, iAnchorIndex2, size$runtime), gapAnchor2);
            }
            if (slotWriter.removeGroups(i7, i6)) {
                ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
            }
            slotWriter.fixParentAnchorsFor(i3, slotWriter.currentGroupEnd, i2);
            if (i8 > 0) {
                slotWriter.removeSlots(i9, i8, i7 - 1);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MoveNode extends Operation {
        public static final MoveNode INSTANCE = new MoveNode(3, 0, 2);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            applier.move(gapBuffer.getInt(0), gapBuffer.getInt(1), gapBuffer.getInt(2));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Remember extends Operation {
        public static final Remember INSTANCE;

        static {
            int i = 1;
            INSTANCE = new Remember(0, i, i);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            rememberEventDispatcher.remembering((RememberObserverHolder) gapBuffer.m758getObjectPtLUHM(0));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RememberPausingScope extends Operation {
        public static final RememberPausingScope INSTANCE;

        static {
            int i = 1;
            INSTANCE = new RememberPausingScope(0, i, i);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) gapBuffer.m758getObjectPtLUHM(0);
            Set set = rememberEventDispatcher.abandoning;
            if (set == null) {
                return;
            }
            PausedCompositionRemembers pausedCompositionRemembers = new PausedCompositionRemembers(set);
            MutableScatterMap mutableScatterMap = rememberEventDispatcher.pausedPlaceholders;
            if (mutableScatterMap == null) {
                long[] jArr = ScatterMapKt.EmptyGroup;
                mutableScatterMap = new MutableScatterMap();
                rememberEventDispatcher.pausedPlaceholders = mutableScatterMap;
            }
            mutableScatterMap.set(recomposeScopeImpl, pausedCompositionRemembers);
            rememberEventDispatcher.currentRememberingList.add(new GapRememberObserverHolder(pausedCompositionRemembers, -1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RemoveCurrentGroup extends Operation {
        public static final RemoveCurrentGroup INSTANCE;

        static {
            int i = 0;
            INSTANCE = new RemoveCurrentGroup(i, i, 3);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            slotWriter.forAllDataInRememberOrder(slotWriter.currentGroup, new ComposerKt$$ExternalSyntheticLambda0((byte) 0, rememberEventDispatcher));
            slotWriter.removeGroup();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RemoveNode extends Operation {
        public static final RemoveNode INSTANCE;

        static {
            int i = 2;
            INSTANCE = new RemoveNode(i, 0, i);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            applier.remove(gapBuffer.getInt(0), gapBuffer.getInt(1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ResetSlots extends Operation {
        public static final ResetSlots INSTANCE;

        static {
            int i = 0;
            INSTANCE = new ResetSlots(i, i, 3);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            if (slotWriter.insertCount != 0) {
                ComposerKt.composeImmediateRuntimeError("Cannot reset when inserting");
            }
            slotWriter.recalculateMarks();
            slotWriter.currentGroup = 0;
            slotWriter.currentGroupEnd = slotWriter.getCapacity() - slotWriter.groupGapLen;
            slotWriter.currentSlot = 0;
            slotWriter.currentSlotEnd = 0;
            slotWriter.nodeCount = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SideEffect extends Operation {
        public static final SideEffect INSTANCE;

        static {
            int i = 1;
            INSTANCE = new SideEffect(0, i, i);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            rememberEventDispatcher.sideEffects.add((Function0) gapBuffer.m758getObjectPtLUHM(0));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SkipToEndOfCurrentGroup extends Operation {
        public static final SkipToEndOfCurrentGroup INSTANCE;

        static {
            int i = 0;
            INSTANCE = new SkipToEndOfCurrentGroup(i, i, 3);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            slotWriter.skipToGroupEnd();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class StartResumingScope extends Operation {
        public static final StartResumingScope INSTANCE;

        static {
            int i = 1;
            INSTANCE = new StartResumingScope(0, i, i);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) gapBuffer.m758getObjectPtLUHM(0);
            MutableScatterMap mutableScatterMap = rememberEventDispatcher.pausedPlaceholders;
            PausedCompositionRemembers pausedCompositionRemembers = mutableScatterMap != null ? (PausedCompositionRemembers) mutableScatterMap.get(recomposeScopeImpl) : null;
            if (pausedCompositionRemembers != null) {
                ArrayList arrayList = rememberEventDispatcher.nestedRemembersLists;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    rememberEventDispatcher.nestedRemembersLists = arrayList;
                }
                arrayList.add(rememberEventDispatcher.currentRememberingList);
                rememberEventDispatcher.currentRememberingList = pausedCompositionRemembers.pausedRemembers;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TrimParentValues extends Operation {
        public static final TrimParentValues INSTANCE = new TrimParentValues(1, 0, 2);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            int i = gapBuffer.getInt(0);
            int i2 = slotWriter.parent;
            int iSlotIndex = slotWriter.slotIndex(slotWriter.groupIndexToAddress(i2), slotWriter.groups);
            int iDataIndex = slotWriter.dataIndex(slotWriter.groupIndexToAddress(i2 + 1), slotWriter.groups);
            for (int iMax = Math.max(iSlotIndex, iDataIndex - i); iMax < iDataIndex; iMax++) {
                Object obj = slotWriter.slots[slotWriter.dataIndexToDataAddress(iMax)];
                if (obj instanceof RememberObserverHolder) {
                    rememberEventDispatcher.forgetting((RememberObserverHolder) obj);
                } else if (obj instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj).release();
                }
            }
            if (i <= 0) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            int i3 = slotWriter.parent;
            int iSlotIndex2 = slotWriter.slotIndex(slotWriter.groupIndexToAddress(i3), slotWriter.groups);
            int iDataIndex2 = slotWriter.dataIndex(slotWriter.groupIndexToAddress(i3 + 1), slotWriter.groups) - i;
            if (iDataIndex2 < iSlotIndex2) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            slotWriter.removeSlots(iDataIndex2, i, i3);
            int i4 = slotWriter.currentSlot;
            if (i4 >= iSlotIndex2) {
                slotWriter.currentSlot = i4 - i;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UpdateAuxData extends Operation {
        public static final UpdateAuxData INSTANCE;

        static {
            int i = 1;
            INSTANCE = new UpdateAuxData(0, i, i);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            slotWriter.updateAux(gapBuffer.m758getObjectPtLUHM(0));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UpdateNode extends Operation {
        public static final UpdateNode INSTANCE = new UpdateNode(0, 2, 1);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            applier.apply(gapBuffer.m758getObjectPtLUHM(0), (Function2) gapBuffer.m758getObjectPtLUHM(1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UpdateValue extends Operation {
        public static final UpdateValue INSTANCE;
        public static final UpdateValue INSTANCE$1;
        public static final UpdateValue INSTANCE$2;
        public static final UpdateValue INSTANCE$3;
        public final /* synthetic */ byte $r8$classId;

        static {
            int i = 1;
            INSTANCE$1 = new UpdateValue(i, 2, (byte) 1);
            int i2 = 1;
            INSTANCE$2 = new UpdateValue(i2, i2, (byte) 2);
            INSTANCE$3 = new UpdateValue(i, 2, (byte) 3);
            int i3 = 1;
            INSTANCE = new UpdateValue(i3, i3, (byte) 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UpdateValue(int i, int i2, byte b) {
            super(i, i2);
            this.$r8$classId = b;
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            switch (this.$r8$classId) {
                case 0:
                    Object objM758getObjectPtLUHM = gapBuffer.m758getObjectPtLUHM(0);
                    int i = gapBuffer.getInt(0);
                    if (objM758getObjectPtLUHM instanceof RememberObserverHolder) {
                        rememberEventDispatcher.remembering((RememberObserverHolder) objM758getObjectPtLUHM);
                    }
                    Object obj = slotWriter.set(slotWriter.currentGroup, i, objM758getObjectPtLUHM);
                    if (obj instanceof RememberObserverHolder) {
                        rememberEventDispatcher.forgetting((RememberObserverHolder) obj);
                    } else if (obj instanceof RecomposeScopeImpl) {
                        ((RecomposeScopeImpl) obj).release();
                    }
                    break;
                case 1:
                    Object objInvoke = ((Function0) gapBuffer.m758getObjectPtLUHM(0)).invoke();
                    GapAnchor gapAnchor = (GapAnchor) gapBuffer.m758getObjectPtLUHM(1);
                    int i2 = gapBuffer.getInt(0);
                    gapAnchor.getClass();
                    slotWriter.updateNodeOfGroup(slotWriter.anchorIndex(gapAnchor), objInvoke);
                    applier.insertTopDown(i2, objInvoke);
                    applier.down(objInvoke);
                    break;
                case 2:
                    GapAnchor gapAnchor2 = (GapAnchor) gapBuffer.m758getObjectPtLUHM(0);
                    int i3 = gapBuffer.getInt(0);
                    applier.up();
                    gapAnchor2.getClass();
                    applier.insertBottomUp(i3, slotWriter.node(slotWriter.anchorIndex(gapAnchor2)));
                    break;
                default:
                    Object objM758getObjectPtLUHM2 = gapBuffer.m758getObjectPtLUHM(0);
                    GapAnchor gapAnchor3 = (GapAnchor) gapBuffer.m758getObjectPtLUHM(1);
                    int i4 = gapBuffer.getInt(0);
                    if (objM758getObjectPtLUHM2 instanceof RememberObserverHolder) {
                        rememberEventDispatcher.remembering((RememberObserverHolder) objM758getObjectPtLUHM2);
                    }
                    Object obj2 = slotWriter.set(slotWriter.anchorIndex(gapAnchor3), i4, objM758getObjectPtLUHM2);
                    if (obj2 instanceof RememberObserverHolder) {
                        rememberEventDispatcher.forgetting((RememberObserverHolder) obj2);
                    } else if (obj2 instanceof RecomposeScopeImpl) {
                        ((RecomposeScopeImpl) obj2).release();
                    }
                    break;
            }
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public GapAnchor getGroupAnchor(GapBuffer gapBuffer) {
            switch (this.$r8$classId) {
                case 1:
                    return (GapAnchor) gapBuffer.m758getObjectPtLUHM(1);
                case 2:
                    return (GapAnchor) gapBuffer.m758getObjectPtLUHM(0);
                default:
                    return super.getGroupAnchor(gapBuffer);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Ups extends Operation {
        public static final Ups INSTANCE = new Ups(1, 0, 2);

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            int i = gapBuffer.getInt(0);
            for (int i2 = 0; i2 < i; i2++) {
                applier.up();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UseCurrentNode extends Operation {
        public static final UseCurrentNode INSTANCE;

        static {
            int i = 0;
            INSTANCE = new UseCurrentNode(i, i, 3);
        }

        @Override // androidx.compose.runtime.composer.gapbuffer.changelist.Operation
        public final void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
            applier.reuse();
        }
    }

    public /* synthetic */ Operation(int i, int i2, int i3) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public void execute(GapBuffer gapBuffer, Applier applier, SlotWriter slotWriter, RememberEventDispatcher rememberEventDispatcher, OperationErrorContext operationErrorContext) {
        slotWriter.advanceBy(gapBuffer.getInt(0));
    }

    public GapAnchor getGroupAnchor(GapBuffer gapBuffer) {
        return null;
    }

    public final String toString() {
        String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        return simpleName == null ? "" : simpleName;
    }

    public Operation(int i, int i2) {
        this.ints = i;
        this.objects = i2;
    }
}
