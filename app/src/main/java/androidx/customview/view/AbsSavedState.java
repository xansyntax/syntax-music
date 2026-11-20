package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.SmallPersistentVector;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateSet;
import androidx.fragment.app.Fragment;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbsSavedState implements Parcelable {
    public final Parcelable mSuperState;
    public static final AnonymousClass1 EMPTY_STATE = new AnonymousClass1();
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new AnonymousClass2(0);

    /* JADX INFO: renamed from: androidx.customview.view.AbsSavedState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends AbsSavedState {
    }

    public AbsSavedState(Parcelable parcelable) {
        if (parcelable != null) {
            this.mSuperState = parcelable == EMPTY_STATE ? null : parcelable;
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("superState must not be null");
            throw null;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mSuperState, i);
    }

    public AbsSavedState() {
        this.mSuperState = null;
    }

    public AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.mSuperState = parcelable == null ? EMPTY_STATE : parcelable;
    }

    /* JADX INFO: renamed from: androidx.customview.view.AbsSavedState$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements Parcelable.ClassLoaderCreator {
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ AnonymousClass2(byte b) {
            this.$r8$classId = b;
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            switch (this.$r8$classId) {
                case 0:
                    if (parcel.readParcelable(null) == null) {
                        return AbsSavedState.EMPTY_STATE;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("superState must be null");
                    return null;
                case 1:
                    return createFromParcel(parcel, (ClassLoader) null);
                case 2:
                    return new Toolbar.SavedState(parcel, null);
                case 3:
                    return m830createFromParcel(parcel, (ClassLoader) null);
                default:
                    return new Fragment.SavedState(parcel, null);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            switch (this.$r8$classId) {
                case 0:
                    return new AbsSavedState[i];
                case 1:
                    return new SnapshotStateList[i];
                case 2:
                    return new Toolbar.SavedState[i];
                case 3:
                    return new SnapshotStateSet[i];
                default:
                    return new Fragment.SavedState[i];
            }
        }

        public static SnapshotStateList createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (classLoader == null) {
                classLoader = AnonymousClass2.class.getClassLoader();
            }
            int i = parcel.readInt();
            if (i == 0) {
                return new SnapshotStateList();
            }
            PersistentVectorBuilder persistentVectorBuilderBuilder = SmallPersistentVector.EMPTY.builder();
            for (int i2 = 0; i2 < i; i2++) {
                persistentVectorBuilderBuilder.add(parcel.readValue(classLoader));
            }
            return new SnapshotStateList(persistentVectorBuilderBuilder.build());
        }

        /* JADX INFO: renamed from: createFromParcel, reason: collision with other method in class */
        public static SnapshotStateSet m830createFromParcel(Parcel parcel, ClassLoader classLoader) {
            SnapshotStateSet snapshotStateSet = new SnapshotStateSet();
            if (classLoader == null) {
                classLoader = SnapshotStateSet.class.getClassLoader();
            }
            int i = parcel.readInt();
            for (int i2 = 0; i2 < i; i2++) {
                snapshotStateSet.add(parcel.readValue(classLoader));
            }
            return snapshotStateSet;
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            switch (this.$r8$classId) {
                case 0:
                    if (parcel.readParcelable(classLoader) == null) {
                        return AbsSavedState.EMPTY_STATE;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("superState must be null");
                    return null;
                case 1:
                    return createFromParcel(parcel, classLoader);
                case 2:
                    return new Toolbar.SavedState(parcel, classLoader);
                case 3:
                    return m830createFromParcel(parcel, classLoader);
                default:
                    return new Fragment.SavedState(parcel, classLoader);
            }
        }
    }
}
