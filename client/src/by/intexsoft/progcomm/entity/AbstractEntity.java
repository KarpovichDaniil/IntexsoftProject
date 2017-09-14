package by.intexsoft.progcomm.entity;

import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.AbstractPersistable;

@MappedSuperclass
public class AbstractEntity extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 8047354616127016231L;

}

