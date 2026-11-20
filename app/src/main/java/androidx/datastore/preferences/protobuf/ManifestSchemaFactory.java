package androidx.datastore.preferences.protobuf;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.nio.charset.Charset;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ManifestSchemaFactory {
    public static final AnonymousClass1 EMPTY_FACTORY = new AnonymousClass1(0);
    public final Object messageInfoFactory;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.ManifestSchemaFactory$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements MessageInfoFactory {
        public static final AnonymousClass1 instance = new AnonymousClass1(1);
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ AnonymousClass1(byte b) {
            this.$r8$classId = b;
        }

        @Override // androidx.datastore.preferences.protobuf.MessageInfoFactory
        public final boolean isSupported(Class cls) {
            switch (this.$r8$classId) {
                case 0:
                    return false;
                default:
                    return GeneratedMessageLite.class.isAssignableFrom(cls);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.MessageInfoFactory
        public final RawMessageInfo messageInfoFor(Class cls) {
            switch (this.$r8$classId) {
                case 0:
                    throw new IllegalStateException("This should never be called.");
                default:
                    if (!GeneratedMessageLite.class.isAssignableFrom(cls)) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Unsupported message type: ".concat(cls.getName()));
                        return null;
                    }
                    try {
                        return (RawMessageInfo) GeneratedMessageLite.getDefaultInstance(cls.asSubclass(GeneratedMessageLite.class)).dynamicMethod(3);
                    } catch (Exception e) {
                        PathKt$$ExternalSyntheticBUOutline0.m("Unable to get message info for ".concat(cls.getName()), (Throwable) e);
                        return null;
                    }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CompositeMessageInfoFactory implements MessageInfoFactory {
        public MessageInfoFactory[] factories;

        @Override // androidx.datastore.preferences.protobuf.MessageInfoFactory
        public final boolean isSupported(Class cls) {
            for (MessageInfoFactory messageInfoFactory : this.factories) {
                if (messageInfoFactory.isSupported(cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.MessageInfoFactory
        public final RawMessageInfo messageInfoFor(Class cls) {
            for (MessageInfoFactory messageInfoFactory : this.factories) {
                if (messageInfoFactory.isSupported(cls)) {
                    return messageInfoFactory.messageInfoFor(cls);
                }
            }
            PathKt$$ExternalSyntheticBUOutline0.m$2("No factory is available for message type: ".concat(cls.getName()));
            return null;
        }
    }

    public ManifestSchemaFactory() {
        MessageInfoFactory messageInfoFactory;
        Protobuf protobuf = Protobuf.INSTANCE;
        try {
            messageInfoFactory = (MessageInfoFactory) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            messageInfoFactory = EMPTY_FACTORY;
        }
        MessageInfoFactory[] messageInfoFactoryArr = {AnonymousClass1.instance, messageInfoFactory};
        CompositeMessageInfoFactory compositeMessageInfoFactory = new CompositeMessageInfoFactory();
        compositeMessageInfoFactory.factories = messageInfoFactoryArr;
        Charset charset = Internal.UTF_8;
        this.messageInfoFactory = compositeMessageInfoFactory;
    }

    public void writeGroup(int i, Object obj, Schema schema) {
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = (CodedOutputStream$OutputStreamEncoder) this.messageInfoFactory;
        codedOutputStream$OutputStreamEncoder.writeTag(i, 3);
        schema.writeTo((AbstractMessageLite) obj, codedOutputStream$OutputStreamEncoder.wrapper);
        codedOutputStream$OutputStreamEncoder.writeTag(i, 4);
    }

    public ManifestSchemaFactory(CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder) {
        Charset charset = Internal.UTF_8;
        this.messageInfoFactory = codedOutputStream$OutputStreamEncoder;
        codedOutputStream$OutputStreamEncoder.wrapper = this;
    }
}
