package kotlinx.serialization.json.internal;

import androidx.room.RoomDatabase$createConnectionManager$2;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.ElementMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class JsonElementMarker {
    public boolean isUnmarkedNull;
    public final ElementMarker origin;

    public JsonElementMarker(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        this.origin = new ElementMarker(serialDescriptor, new RoomDatabase$createConnectionManager$2(2, this, JsonElementMarker.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0, (byte) 5));
    }
}
