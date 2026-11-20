package kotlin.io;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class FileSystemException extends IOException {
    public FileSystemException(File file, File file2, String str) {
        file.getClass();
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        sb.append(": ".concat(str));
        super(sb.toString());
    }

    public /* synthetic */ FileSystemException(IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FileSystemException(int i, int i2, int i3, IndexOutOfBoundsException indexOutOfBoundsException) {
        Locale locale = Locale.US;
        StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(i, "Pos: ", ", limit: ");
        sbM.append(i2);
        sbM.append(", len: ");
        sbM.append(i3);
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(sbM.toString()), indexOutOfBoundsException);
    }
}
