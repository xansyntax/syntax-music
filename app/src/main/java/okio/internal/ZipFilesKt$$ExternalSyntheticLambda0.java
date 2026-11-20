package okio.internal;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ZipFilesKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ RealBufferedSource f$0;
    public final /* synthetic */ Ref$ObjectRef f$1;
    public final /* synthetic */ Ref$ObjectRef f$2;
    public final /* synthetic */ Ref$ObjectRef f$3;

    public /* synthetic */ ZipFilesKt$$ExternalSyntheticLambda0(Ref$ObjectRef ref$ObjectRef, RealBufferedSource realBufferedSource, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3) {
        this.f$1 = ref$ObjectRef;
        this.f$0 = realBufferedSource;
        this.f$2 = ref$ObjectRef2;
        this.f$3 = ref$ObjectRef3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws IOException {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Ref$ObjectRef ref$ObjectRef = this.f$3;
        Ref$ObjectRef ref$ObjectRef2 = this.f$2;
        RealBufferedSource realBufferedSource = this.f$0;
        Ref$ObjectRef ref$ObjectRef3 = this.f$1;
        switch (b) {
            case 0:
                int iIntValue = ((Integer) obj).intValue();
                long jLongValue = ((Long) obj2).longValue();
                if (iIntValue != 21589) {
                    return unit;
                }
                if (jLongValue >= 1) {
                    byte b2 = realBufferedSource.readByte();
                    boolean z = (b2 & 1) == 1;
                    boolean z2 = (b2 & 2) == 2;
                    boolean z3 = (b2 & 4) == 4;
                    long j = z ? 5L : 1L;
                    if (z2) {
                        j += 4;
                    }
                    if (z3) {
                        j += 4;
                    }
                    if (jLongValue >= j) {
                        if (z) {
                            ref$ObjectRef3.element = Integer.valueOf(realBufferedSource.readIntLe());
                        }
                        if (z2) {
                            ref$ObjectRef2.element = Integer.valueOf(realBufferedSource.readIntLe());
                        }
                        if (!z3) {
                            return unit;
                        }
                        ref$ObjectRef.element = Integer.valueOf(realBufferedSource.readIntLe());
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$3("bad zip: extended timestamp extra too short");
                } else {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$3("bad zip: extended timestamp extra too short");
                }
                return null;
            default:
                int iIntValue2 = ((Integer) obj).intValue();
                long jLongValue2 = ((Long) obj2).longValue();
                if (iIntValue2 != 1) {
                    return unit;
                }
                if (ref$ObjectRef3.element != null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$3("bad zip: NTFS extra attribute tag 0x0001 repeated");
                } else {
                    if (jLongValue2 == 24) {
                        ref$ObjectRef3.element = Long.valueOf(realBufferedSource.readLongLe());
                        ref$ObjectRef2.element = Long.valueOf(realBufferedSource.readLongLe());
                        ref$ObjectRef.element = Long.valueOf(realBufferedSource.readLongLe());
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$3("bad zip: NTFS extra attribute tag 0x0001 size != 24");
                }
                return null;
        }
    }

    public /* synthetic */ ZipFilesKt$$ExternalSyntheticLambda0(RealBufferedSource realBufferedSource, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3) {
        this.f$0 = realBufferedSource;
        this.f$1 = ref$ObjectRef;
        this.f$2 = ref$ObjectRef2;
        this.f$3 = ref$ObjectRef3;
    }
}
