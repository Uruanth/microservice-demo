package org.example.domain.events;

import org.example.domain.value.AccountId;
import org.example.domain.value.Name;
import org.example.generic.domain.DomainEvent;

public class AccountNameEdited extends DomainEvent {
    private final Name name;

    public AccountNameEdited(Name name) {
        super("org.example.AccountNameEdited");
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
