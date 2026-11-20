package kotlinx.serialization.descriptors;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ClassSerialDescriptorBuilder {
    public final String serialName;
    public List annotations = EmptyList.INSTANCE;
    public final ArrayList elementNames = new ArrayList();
    public final HashSet uniqueNames = new HashSet();
    public final ArrayList elementDescriptors = new ArrayList();
    public final ArrayList elementAnnotations = new ArrayList();
    public final ArrayList elementOptionality = new ArrayList();

    public ClassSerialDescriptorBuilder(String str) {
        this.serialName = str;
    }

    public final void element(String str, SerialDescriptor serialDescriptor) {
        str.getClass();
        serialDescriptor.getClass();
        if (!this.uniqueNames.add(str)) {
            StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("Element with name '", str, "' is already registered in ");
            sbM4m.append(this.serialName);
            throw new IllegalArgumentException(sbM4m.toString().toString());
        }
        this.elementNames.add(str);
        this.elementDescriptors.add(serialDescriptor);
        this.elementAnnotations.add(EmptyList.INSTANCE);
        this.elementOptionality.add(Boolean.FALSE);
    }
}
