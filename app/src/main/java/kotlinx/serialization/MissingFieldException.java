package kotlinx.serialization;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class MissingFieldException extends SerializationException {
    public final List missingFields;
    public final String serialName;

    public MissingFieldException(String str, MissingFieldException missingFieldException, List list, String str2) {
        super(str, missingFieldException);
        this.missingFields = list;
        this.serialName = str2;
    }
}
