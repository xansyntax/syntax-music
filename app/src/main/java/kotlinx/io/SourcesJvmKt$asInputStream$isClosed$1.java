package kotlinx.io;

import androidx.compose.runtime.MutableState;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SourcesJvmKt$asInputStream$isClosed$1 extends MutablePropertyReference0Impl {
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SourcesJvmKt$asInputStream$isClosed$1(Object obj, Class cls, String str, String str2, int i, byte b) {
        super(obj, cls, str, str2, i);
        this.$r8$classId = b;
    }

    @Override // kotlin.reflect.KProperty0
    public final Object get() {
        switch (this.$r8$classId) {
            case 0:
                return Boolean.valueOf(((RealSource) this.receiver).closed);
            default:
                return ((MutableState) this.receiver).getValue();
        }
    }

    @Override // kotlin.reflect.KMutableProperty0
    public final void set(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((RealSource) this.receiver).closed = ((Boolean) obj).booleanValue();
                break;
            default:
                ((MutableState) this.receiver).setValue(obj);
                break;
        }
    }
}
