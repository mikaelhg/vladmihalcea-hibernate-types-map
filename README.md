# Hibernate issue POC

```
Caused by: org.hibernate.type.SerializationException: could not serialize
	at org.hibernate.internal.util.SerializationHelper.serialize(SerializationHelper.java:119)
	at org.hibernate.internal.util.SerializationHelper.serialize(SerializationHelper.java:144)
	at org.hibernate.internal.util.SerializationHelper.clone(SerializationHelper.java:75)
	at com.vladmihalcea.hibernate.type.util.ObjectMapperJsonSerializer.clone(ObjectMapperJsonSerializer.java:21)
	at com.vladmihalcea.hibernate.type.util.ObjectMapperWrapper.clone(ObjectMapperWrapper.java:73)
	at com.vladmihalcea.hibernate.type.json.internal.JsonTypeDescriptor$2.deepCopyNotNull(JsonTypeDescriptor.java:41)
	at org.hibernate.type.descriptor.java.MutableMutabilityPlan.deepCopy(MutableMutabilityPlan.java:35)
	at org.hibernate.type.AbstractStandardBasicType.deepCopy(AbstractStandardBasicType.java:308)
	at org.hibernate.type.AbstractStandardBasicType.deepCopy(AbstractStandardBasicType.java:304)
	at org.hibernate.type.TypeHelper.deepCopy(TypeHelper.java:54)
	at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:281)
	at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:196)
	at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:127)
	at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:192)
	at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:135)
	at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:62)
	at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:800)
```
