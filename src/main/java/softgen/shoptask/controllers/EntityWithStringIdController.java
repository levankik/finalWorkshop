package softgen.shoptask.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import softgen.shoptask.configurations.SecUser;
import softgen.shoptask.entities.EntityWithStringId;
import softgen.shoptask.services.EntityWithStringIdService;


@RestController
@RequestMapping("/shproducts")
@RequiredArgsConstructor
@PreAuthorize("hasRole('MANAGER')")
public class EntityWithStringIdController  {
    public final EntityWithStringIdService entityWithStringIdService;

    @PostMapping("")
    public EntityWithStringId addEntityWithStringId(@RequestParam String  name, @AuthenticationPrincipal SecUser user) {
        return entityWithStringIdService.addEntityWithStringId(name, user);
    }
}
