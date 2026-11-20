package com.google.protobuf;

import androidx.collection.IntIntPair;
import androidx.compose.foundation.layout.FlowLayoutBuildingBlocks$WrapInfo;
import androidx.compose.foundation.layout.FlowLayoutOverflowState;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.ui.unit.Constraints;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArrayDecoders$Registers {
    public int int1;
    public long long1;
    public Object object1;
    public int recursionDepth;

    public ArrayDecoders$Registers(FlowLayoutOverflowState flowLayoutOverflowState, long j, int i, int i2) {
        this.object1 = flowLayoutOverflowState;
        this.long1 = j;
        this.int1 = i;
        this.recursionDepth = i2;
    }

    public OffsetKt getWrapEllipsisInfo(FlowLayoutBuildingBlocks$WrapInfo flowLayoutBuildingBlocks$WrapInfo, boolean z, int i, int i2, int i3, int i4) {
        if (!flowLayoutBuildingBlocks$WrapInfo.isLastItemInContainer) {
            return null;
        }
        ((FlowLayoutOverflowState) this.object1).getClass();
        return null;
    }

    /* JADX INFO: renamed from: getWrapInfo-OpUlnko, reason: not valid java name */
    public FlowLayoutBuildingBlocks$WrapInfo m913getWrapInfoOpUlnko(boolean z, int i, long j, IntIntPair intIntPair, int i2, int i3, int i4, boolean z2, boolean z3) {
        int i5 = this.int1;
        int i6 = this.recursionDepth;
        long j2 = this.long1;
        FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) this.object1;
        int i7 = i3 + i4;
        if (intIntPair == null) {
            return new FlowLayoutBuildingBlocks$WrapInfo(true, true);
        }
        long j3 = intIntPair.packedValue;
        flowLayoutOverflowState.getClass();
        if (i2 >= Integer.MAX_VALUE || ((int) (j & 4294967295L)) - ((int) (j3 & 4294967295L)) < 0) {
            return new FlowLayoutBuildingBlocks$WrapInfo(true, true);
        }
        if (i != 0 && (i >= Integer.MAX_VALUE || ((int) (j >> 32)) - ((int) (j3 >> 32)) < 0)) {
            return z2 ? new FlowLayoutBuildingBlocks$WrapInfo(true, true) : new FlowLayoutBuildingBlocks$WrapInfo(true, m913getWrapInfoOpUlnko(z, 0, IntIntPair.m1constructorimpl(Constraints.m784getMaxWidthimpl(j2), (((int) (j & 4294967295L)) - i6) - i4), new IntIntPair(IntIntPair.m1constructorimpl(((int) (j3 >> 32)) - i5, (int) (j3 & 4294967295L))), i2 + 1, i7, 0, true, false).isLastItemInContainer);
        }
        return new FlowLayoutBuildingBlocks$WrapInfo(false, false);
    }

    public ArrayDecoders$Registers(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.getClass();
    }
}
