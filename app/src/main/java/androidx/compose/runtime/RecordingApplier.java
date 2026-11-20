package androidx.compose.runtime;

import androidx.collection.MutableIntList;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.compose.ui.node.UiApplier;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RecordingApplier implements Applier {
    public final Object current;
    public final MutableIntList operations = new MutableIntList();
    public final MutableObjectList instances = new MutableObjectList();

    public RecordingApplier(Object obj) {
        this.current = obj;
    }

    @Override // androidx.compose.runtime.Applier
    public final void apply(Object obj, Function2 function2) {
        this.operations.add(7);
        MutableObjectList mutableObjectList = this.instances;
        mutableObjectList.add(function2);
        mutableObjectList.add(obj);
    }

    @Override // androidx.compose.runtime.Applier
    public final void down(Object obj) {
        this.operations.add(1);
        this.instances.add(obj);
    }

    @Override // androidx.compose.runtime.Applier
    public final Object getCurrent() {
        return this.current;
    }

    @Override // androidx.compose.runtime.Applier
    public final void insertBottomUp(int i, Object obj) {
        MutableIntList mutableIntList = this.operations;
        mutableIntList.add(5);
        mutableIntList.add(i);
        this.instances.add(obj);
    }

    @Override // androidx.compose.runtime.Applier
    public final void insertTopDown(int i, Object obj) {
        MutableIntList mutableIntList = this.operations;
        mutableIntList.add(6);
        mutableIntList.add(i);
        this.instances.add(obj);
    }

    @Override // androidx.compose.runtime.Applier
    public final void move(int i, int i2, int i3) {
        MutableIntList mutableIntList = this.operations;
        mutableIntList.add(3);
        mutableIntList.add(i);
        mutableIntList.add(i2);
        mutableIntList.add(i3);
    }

    public final void playTo(UiApplier uiApplier, RememberEventDispatcher rememberEventDispatcher) {
        Exception exc;
        MutableIntList mutableIntList = this.operations;
        int i = mutableIntList._size;
        MutableObjectList mutableObjectList = new MutableObjectList();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            MutableObjectList mutableObjectList2 = this.instances;
            if (i2 >= i) {
                if (i3 != mutableObjectList2._size) {
                    ComposerKt.composeImmediateRuntimeError("Applier operation size mismatch");
                }
                mutableObjectList2.clear();
                mutableIntList._size = 0;
                uiApplier.onEndChanges();
                return;
            }
            int i4 = i2 + 1;
            try {
                try {
                    switch (mutableIntList.get(i2)) {
                        case 0:
                            uiApplier.up();
                            i2 = i4;
                            break;
                        case 1:
                            int i5 = i3 + 1;
                            uiApplier.down(mutableObjectList2.get(i3));
                            i3 = i5;
                            i2 = i4;
                            break;
                        case 2:
                            int i6 = i2 + 2;
                            i2 += 3;
                            uiApplier.remove(mutableIntList.get(i4), mutableIntList.get(i6));
                            break;
                        case 3:
                            int i7 = i2 + 2;
                            try {
                                int i8 = i2 + 3;
                                try {
                                    i2 += 4;
                                    uiApplier.move(mutableIntList.get(i4), mutableIntList.get(i7), mutableIntList.get(i8));
                                } catch (Exception e) {
                                    exc = e;
                                    i2 = i8;
                                }
                            } catch (Exception e2) {
                                exc = e2;
                                i2 = i7;
                            }
                            break;
                        case 4:
                            uiApplier.clear();
                            i2 = i4;
                            break;
                        case 5:
                            i2 += 2;
                            int i9 = i3 + 1;
                            uiApplier.insertBottomUp(mutableIntList.get(i4), mutableObjectList2.get(i3));
                            i3 = i9;
                            break;
                        case 6:
                            i2 += 2;
                            try {
                                mutableIntList.get(i4);
                                int i10 = i3 + 1;
                                i3 = i10;
                            } catch (Exception e3) {
                                exc = e3;
                            }
                            break;
                        case 7:
                            int i11 = i3 + 1;
                            Object obj = mutableObjectList2.get(i3);
                            obj.getClass();
                            TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, obj);
                            i3 += 2;
                            uiApplier.apply(mutableObjectList2.get(i11), (Function2) obj);
                            i2 = i4;
                            break;
                        case 8:
                            Object obj2 = uiApplier.current;
                            if (obj2 instanceof ComposeNodeLifecycleCallback) {
                                ComposeNodeLifecycleCallback composeNodeLifecycleCallback = (ComposeNodeLifecycleCallback) obj2;
                                if (rememberEventDispatcher.leaving.remove(composeNodeLifecycleCallback)) {
                                    composeNodeLifecycleCallback.onDeactivate();
                                }
                            }
                            mutableObjectList.add(obj2);
                            uiApplier.reuse();
                            i2 = i4;
                            break;
                        default:
                            i2 = i4;
                            break;
                    }
                } catch (Throwable th) {
                    uiApplier.onEndChanges();
                    throw th;
                }
            } catch (Exception e4) {
                exc = e4;
                i2 = i4;
            }
            exc = e3;
            throw new ComposePausableCompositionException(mutableObjectList2, mutableObjectList, mutableIntList, i2 - 1, exc);
        }
    }

    @Override // androidx.compose.runtime.Applier
    public final void remove(int i, int i2) {
        MutableIntList mutableIntList = this.operations;
        mutableIntList.add(2);
        mutableIntList.add(i);
        mutableIntList.add(i2);
    }

    @Override // androidx.compose.runtime.Applier
    public final void reuse() {
        this.operations.add(8);
    }

    @Override // androidx.compose.runtime.Applier
    public final void up() {
        this.operations.add(0);
    }
}
