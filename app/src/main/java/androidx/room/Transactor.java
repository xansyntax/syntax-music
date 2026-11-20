package androidx.room;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface Transactor extends PooledConnection {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SQLiteTransactionType {
        public static final /* synthetic */ SQLiteTransactionType[] $VALUES;
        public static final SQLiteTransactionType DEFERRED;
        public static final SQLiteTransactionType IMMEDIATE;

        static {
            SQLiteTransactionType sQLiteTransactionType = new SQLiteTransactionType("DEFERRED", 0);
            DEFERRED = sQLiteTransactionType;
            SQLiteTransactionType sQLiteTransactionType2 = new SQLiteTransactionType("IMMEDIATE", 1);
            IMMEDIATE = sQLiteTransactionType2;
            $VALUES = new SQLiteTransactionType[]{sQLiteTransactionType, sQLiteTransactionType2, new SQLiteTransactionType("EXCLUSIVE", 2)};
        }

        public static SQLiteTransactionType valueOf(String str) {
            return (SQLiteTransactionType) Enum.valueOf(SQLiteTransactionType.class, str);
        }

        public static SQLiteTransactionType[] values() {
            return (SQLiteTransactionType[]) $VALUES.clone();
        }
    }

    Boolean inTransaction(Continuation continuation);

    Object withTransaction(SQLiteTransactionType sQLiteTransactionType, Function2 function2, SuspendLambda suspendLambda);
}
