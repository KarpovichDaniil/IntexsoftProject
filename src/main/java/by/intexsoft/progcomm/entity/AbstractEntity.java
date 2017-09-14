package by.intexsoft.progcomm.entity;

import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.AbstractPersistable;

@MappedSuperclass
public class AbstractEntity extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 6565441273610785315L;

}

