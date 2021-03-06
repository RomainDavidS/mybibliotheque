package com.bibliotheque.microservicemyclient.proxies;

import com.bibliotheque.microservicemyclient.bean.UtilisateurBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "microservice-myusers")
@RibbonClient(name = "microservice-myusers")
public interface IMicroserviceMyUsersProxy {

    @GetMapping("/{pseudo}/connexion")
    UtilisateurBean connexionUtilisateur(@PathVariable String pseudo);

    @GetMapping("/connexion/{id}")
    UtilisateurBean findById(@PathVariable("id") Long id);
}
