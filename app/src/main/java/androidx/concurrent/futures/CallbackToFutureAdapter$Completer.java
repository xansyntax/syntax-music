package androidx.concurrent.futures;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CallbackToFutureAdapter$Completer {
    public boolean attemptedSetting;
    public ResolvableFuture cancellationFuture;
    public CallbackToFutureAdapter$SafeFuture future;
    public Object tag;

    public final void finalize() {
        ResolvableFuture resolvableFuture;
        CallbackToFutureAdapter$SafeFuture callbackToFutureAdapter$SafeFuture = this.future;
        if (callbackToFutureAdapter$SafeFuture != null) {
            CallbackToFutureAdapter$SafeFuture.AnonymousClass1 anonymousClass1 = callbackToFutureAdapter$SafeFuture.delegate;
            if (!anonymousClass1.isDone()) {
                anonymousClass1.setException(new AbstractResolvableFuture.Failure.AnonymousClass1("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.tag, (byte) 1));
            }
        }
        if (this.attemptedSetting || (resolvableFuture = this.cancellationFuture) == null) {
            return;
        }
        resolvableFuture.set(null);
    }

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
    public final void set(Boolean bool) {
        Object obj;
        this.attemptedSetting = true;
        CallbackToFutureAdapter$SafeFuture callbackToFutureAdapter$SafeFuture = this.future;
        if (callbackToFutureAdapter$SafeFuture != null) {
            CallbackToFutureAdapter$SafeFuture.AnonymousClass1 anonymousClass1 = callbackToFutureAdapter$SafeFuture.delegate;
            anonymousClass1.getClass();
            if (bool == null) {
                obj = bool;
                obj = AbstractResolvableFuture.NULL;
            }
            obj = bool;
            if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(anonymousClass1, null, obj)) {
                AbstractResolvableFuture.complete(anonymousClass1);
                this.tag = null;
                this.future = null;
                this.cancellationFuture = null;
            }
        }
    }
}
