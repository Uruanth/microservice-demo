package org.example.domain.command;

import org.example.domain.value.AccountId;
import org.example.domain.value.Name;
import org.example.generic.domain.Command;

public class EditAccountNameCommand extends Command {

    private final AccountId accountId;
    private final Name name;

    public EditAccountNameCommand(AccountId accountId, Name name) {
        this.accountId = accountId;
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public AccountId getAccountId() {
        return accountId;
    }
}
