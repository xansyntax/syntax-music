package androidx.sqlite.driver;

import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import io.ktor.util.date.GMTDateParser;
import java.io.IOException;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SupportSQLiteConnection implements SQLiteConnection {
    public final FrameworkSQLiteDatabase db;

    public SupportSQLiteConnection(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        frameworkSQLiteDatabase.getClass();
        this.db = frameworkSQLiteDatabase;
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        this.db.close();
    }

    @Override // androidx.sqlite.SQLiteConnection
    public final boolean inTransaction() {
        return this.db.inTransaction();
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00ca  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.sqlite.SQLiteConnection
    public final SQLiteStatement prepare(String str) {
        SupportSQLiteStatement$Companion$TransactionOperation supportSQLiteStatement$Companion$TransactionOperation;
        int i;
        str.getClass();
        FrameworkSQLiteDatabase frameworkSQLiteDatabase = this.db;
        SupportSQLiteStatement$Companion$SpecialOperation$JournalModeOperation supportSQLiteStatement$Companion$SpecialOperation$JournalModeOperation = null;
        if (!frameworkSQLiteDatabase.isOpen()) {
            SQLite.throwSQLiteException(21, "connection is closed");
            throw null;
        }
        String upperCase = StringsKt.trim(str).toString().toUpperCase(Locale.ROOT);
        upperCase.getClass();
        int length = upperCase.length() - 2;
        int i2 = -1;
        if (length >= 0) {
            int iIndexOf$default = 0;
            loop0: while (iIndexOf$default < length) {
                char cCharAt = upperCase.charAt(iIndexOf$default);
                if (Intrinsics.compare((int) cCharAt, 32) > 0) {
                    if (cCharAt != '-') {
                        if (cCharAt == '/') {
                            int iIndexOf$default2 = iIndexOf$default + 1;
                            if (upperCase.charAt(iIndexOf$default2) == '*') {
                                do {
                                    iIndexOf$default2 = StringsKt.indexOf$default(upperCase, GMTDateParser.ANY, iIndexOf$default2 + 1, 4);
                                    if (iIndexOf$default2 < 0) {
                                        break loop0;
                                    }
                                    i = iIndexOf$default2 + 1;
                                    if (i >= length) {
                                        break;
                                    }
                                } while (upperCase.charAt(i) != '/');
                                iIndexOf$default = iIndexOf$default2 + 2;
                            }
                        }
                        i2 = iIndexOf$default;
                        break;
                    }
                    if (upperCase.charAt(iIndexOf$default + 1) != '-') {
                        i2 = iIndexOf$default;
                        break;
                    }
                    iIndexOf$default = StringsKt.indexOf$default(upperCase, '\n', iIndexOf$default + 2, 4);
                    if (iIndexOf$default < 0) {
                        break;
                    }
                }
                iIndexOf$default++;
            }
        }
        String strSubstring = (i2 < 0 || i2 > upperCase.length()) ? null : upperCase.substring(i2, Math.min(i2 + 3, upperCase.length()));
        if (strSubstring == null) {
            return new SupportSQLiteStatement.OtherSQLiteStatement(frameworkSQLiteDatabase, str);
        }
        switch (strSubstring.hashCode()) {
            case 65636:
                if (!strSubstring.equals("BEG")) {
                    supportSQLiteStatement$Companion$TransactionOperation = null;
                } else if (!StringsKt.contains(upperCase, "EXCLUSIVE", false)) {
                    supportSQLiteStatement$Companion$TransactionOperation = !StringsKt.contains(upperCase, "IMMEDIATE", false) ? SupportSQLiteStatement$Companion$TransactionOperation.BEGIN_DEFERRED : SupportSQLiteStatement$Companion$TransactionOperation.BEGIN_IMMEDIATE;
                } else {
                    supportSQLiteStatement$Companion$TransactionOperation = SupportSQLiteStatement$Companion$TransactionOperation.BEGIN_EXCLUSIVE;
                }
                break;
            case 66913:
                if (!strSubstring.equals("COM")) {
                    supportSQLiteStatement$Companion$TransactionOperation = null;
                } else {
                    supportSQLiteStatement$Companion$TransactionOperation = SupportSQLiteStatement$Companion$TransactionOperation.END;
                }
                break;
            case 68795:
                if (!strSubstring.equals("END")) {
                    supportSQLiteStatement$Companion$TransactionOperation = null;
                } else {
                    supportSQLiteStatement$Companion$TransactionOperation = SupportSQLiteStatement$Companion$TransactionOperation.END;
                }
                break;
            case 81327:
                supportSQLiteStatement$Companion$TransactionOperation = (!strSubstring.equals("ROL") || StringsKt.contains(upperCase, " TO ", false)) ? null : SupportSQLiteStatement$Companion$TransactionOperation.ROLLBACK;
                break;
            default:
                supportSQLiteStatement$Companion$TransactionOperation = null;
                break;
        }
        if (supportSQLiteStatement$Companion$TransactionOperation != null) {
            return new SupportSQLiteStatement.OtherSQLiteStatement(frameworkSQLiteDatabase, str, supportSQLiteStatement$Companion$TransactionOperation);
        }
        if (strSubstring.equals("PRA")) {
            String lowerCase = upperCase.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            if (StringsKt.contains(StringsKt.substringAfter(lowerCase, "journal_mode", ""), "=", false)) {
                supportSQLiteStatement$Companion$SpecialOperation$JournalModeOperation = SupportSQLiteStatement$Companion$SpecialOperation$JournalModeOperation.INSTANCE;
            }
        }
        if (supportSQLiteStatement$Companion$SpecialOperation$JournalModeOperation != null) {
            return new SupportSQLiteStatement.OtherSQLiteStatement(frameworkSQLiteDatabase, str, new SupportSQLiteStatement.RowSQLiteStatement(frameworkSQLiteDatabase, str));
        }
        int iHashCode = strSubstring.hashCode();
        return (iHashCode == 79487 ? !strSubstring.equals("PRA") : iHashCode == 81978 ? !strSubstring.equals("SEL") : !(iHashCode == 85954 && strSubstring.equals("WIT"))) ? new SupportSQLiteStatement.OtherSQLiteStatement(frameworkSQLiteDatabase, str) : new SupportSQLiteStatement.RowSQLiteStatement(frameworkSQLiteDatabase, str);
    }
}
