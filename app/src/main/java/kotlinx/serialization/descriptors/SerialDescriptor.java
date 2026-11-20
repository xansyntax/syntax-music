package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.collections.EmptyList;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public interface SerialDescriptor {
    default List getAnnotations() {
        return EmptyList.INSTANCE;
    }

    List getElementAnnotations(int i);

    SerialDescriptor getElementDescriptor(int i);

    int getElementIndex(String str);

    String getElementName(int i);

    int getElementsCount();

    Okio__OkioKt getKind();

    String getSerialName();

    boolean isElementOptional(int i);

    default boolean isInline() {
        return false;
    }

    default boolean isNullable() {
        return false;
    }
}
