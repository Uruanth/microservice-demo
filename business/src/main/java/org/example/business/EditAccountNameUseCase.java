package org.example.business;

import org.example.business.gateway.ValidOwnerOfAccountService;
import org.example.domain.Account;
import org.example.domain.command.EditAccountNameCommand;
import org.example.generic.business.EventStoreRepository;
import org.example.generic.domain.DomainEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class EditAccountNameUseCase implements Function<Mono<EditAccountNameCommand>, Flux<DomainEvent>> {

    private final EventStoreRepository repository;

    public EditAccountNameUseCase(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<EditAccountNameCommand> commandMono) {
        return commandMono
                .flatMapMany(command -> {
                    var id = command.getAccountId();
                    System.out.println("id = " + id);
                    return repository
                            .getEventsBy("account", id.value())
                            .log()
                            .switchIfEmpty(error -> {
                                throw new IllegalArgumentException("Business Exception");
                            })
                            .collectList()
                            .flatMapIterable(events -> {
                                var account = Account.from(id, events);
                                account.UpdateName(command.getName());
                                return account.getUncommittedChanges();
                            });
                });

    }
}
