package com.bibliotheque.microservicemyclient.proxies;

import com.bibliotheque.microservicemyclient.bean.CopieBean;
import com.bibliotheque.microservicemyclient.bean.LivreBean;
import com.bibliotheque.microservicemyclient.bean.ReservationBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@FeignClient(name ="microservice-mylibrary")
@RibbonClient(name ="microservice-mylibrary")
public interface IMicroserviceMyLibraryProxy {

    @GetMapping(value = "/livres")
    List<LivreBean> ListeDeLivres();

    @GetMapping(value = "/livre/{id}")
    LivreBean afficherUnLivre(@PathVariable("id") Long id);

    @GetMapping(value = "/copies/{id}")
    List<CopieBean> afficherLesCopiesDunLivre(@PathVariable("id")Long id);

    @GetMapping(value = "/copie/{id}")
    CopieBean afficherUneCopie(@PathVariable("id")Long id);

    @GetMapping(value = "/copies/dispos/{id}")
    List<CopieBean> afficherLesCopiesDisponibles(@PathVariable("id") Long id);

    @GetMapping(value = "/listeDesReservations/{id}")
    List<ReservationBean> afficherLaListeDesReservationsParUtilisateur(@PathVariable("id")Long id);

    @PostMapping(value = "/reserver")
    void demandeDeReservation(@RequestParam Long id, @RequestParam Long idUtilisateur);

    @PostMapping(value = "/prolonger/{id}")
    void prolongerPret(@PathVariable("id") Long id, ReservationBean reservationBean);

}