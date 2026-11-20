package androidx.compose.ui.graphics.vector;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.google.protobuf.kotlin.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VectorGroup extends VectorNode implements Iterable, KMappedMarker {
    public final ArrayList children;
    public final List clipPathData;
    public final String name;
    public final float pivotX;
    public final float pivotY;
    public final float rotation;
    public final float scaleX;
    public final float scaleY;
    public final float translationX;
    public final float translationY;

    public VectorGroup(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List list, ArrayList arrayList) {
        this.name = str;
        this.rotation = f;
        this.pivotX = f2;
        this.pivotY = f3;
        this.scaleX = f4;
        this.scaleY = f5;
        this.translationX = f6;
        this.translationY = f7;
        this.clipPathData = list;
        this.children = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VectorGroup)) {
            return false;
        }
        VectorGroup vectorGroup = (VectorGroup) obj;
        return Intrinsics.areEqual(this.name, vectorGroup.name) && this.rotation == vectorGroup.rotation && this.pivotX == vectorGroup.pivotX && this.pivotY == vectorGroup.pivotY && this.scaleX == vectorGroup.scaleX && this.scaleY == vectorGroup.scaleY && this.translationX == vectorGroup.translationX && this.translationY == vectorGroup.translationY && Intrinsics.areEqual(this.clipPathData, vectorGroup.clipPathData) && this.children.equals(vectorGroup.children);
    }

    public final int hashCode() {
        return this.children.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.translationY, IntIntPair$$ExternalSyntheticOutline0.m(this.translationX, IntIntPair$$ExternalSyntheticOutline0.m(this.scaleY, IntIntPair$$ExternalSyntheticOutline0.m(this.scaleX, IntIntPair$$ExternalSyntheticOutline0.m(this.pivotY, IntIntPair$$ExternalSyntheticOutline0.m(this.pivotX, IntIntPair$$ExternalSyntheticOutline0.m(this.rotation, this.name.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31, this.clipPathData);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new UnmodifiableIterator(this);
    }
}
