package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldLabelPosition$Inside extends ScrimKt {
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldLabelPosition$Inside)) {
            return false;
        }
        BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
        return horizontal.equals(horizontal) && horizontal.equals(horizontal);
    }

    public final int hashCode() {
        return Float.hashCode(-1.0f) + IntIntPair$$ExternalSyntheticOutline0.m(-1.0f, Boolean.hashCode(false) * 31, 31);
    }

    public final String toString() {
        BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
        return "Inside(isAlwaysMinimized=false, minimizedAlignment=" + horizontal + ", expandedAlignment=" + horizontal + ")";
    }
}
