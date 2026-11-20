package okhttp3.internal.http2;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.internal.EnumDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class Http2Connection$$ExternalSyntheticLambda3 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ Http2Connection$$ExternalSyntheticLambda3(int i, String str, EnumDescriptor enumDescriptor) {
        this.$r8$classId = (byte) 2;
        this.f$1 = i;
        this.f$0 = str;
        this.f$2 = enumDescriptor;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj = this.f$2;
        Object obj2 = this.f$0;
        int i = this.f$1;
        switch (b) {
            case 0:
                Http2Connection http2Connection = (Http2Connection) obj2;
                try {
                    http2Connection.writer.rstStream(i, (ErrorCode) obj);
                    break;
                } catch (IOException e) {
                    ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
                    http2Connection.close$okhttp(errorCode, errorCode, e);
                }
                return unit;
            case 1:
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj2;
                MutableState mutableState = (MutableState) obj;
                if (!((Boolean) mutableState.getValue()).booleanValue()) {
                    mutableState.setValue(Boolean.TRUE);
                    snapshotStateList.add(Integer.valueOf(i));
                }
                return unit;
            default:
                String str = (String) obj2;
                EnumDescriptor enumDescriptor = (EnumDescriptor) obj;
                SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[i];
                for (int i2 = 0; i2 < i; i2++) {
                    serialDescriptorArr[i2] = StringsKt__IndentKt.buildSerialDescriptor$default(str + '.' + enumDescriptor.names[i2], StructureKind$MAP.INSTANCE$3, new SerialDescriptor[0]);
                }
                return serialDescriptorArr;
        }
    }

    public /* synthetic */ Http2Connection$$ExternalSyntheticLambda3(Object obj, int i, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = i;
        this.f$2 = obj2;
    }
}
