package androidx.media3.container;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NalUnitUtil$H265VideoSignalInfosAndIndices {
    public final int[] indices;
    public final ImmutableList videoSignalInfos;

    public NalUnitUtil$H265VideoSignalInfosAndIndices(RegularImmutableList regularImmutableList, int[] iArr, byte b) {
        switch (b) {
            case 1:
                this.videoSignalInfos = ImmutableList.copyOf((Collection) regularImmutableList);
                this.indices = iArr;
                break;
            default:
                this.videoSignalInfos = ImmutableList.copyOf((Collection) regularImmutableList);
                this.indices = iArr;
                break;
        }
    }
}
