package com.bibliotheque.microservicemylibrary.controller;

import com.bibliotheque.microservicemylibrary.model.Reservation;
import com.bibliotheque.microservicemylibrary.service.reservation.IReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IReservationService iReservationService;

    @RequestMapping(value = "/listeDesReservations/{id}", method = RequestMethod.GET)
    public List<Reservation> afficherLaListeDesReservationsParUtilisateur(@PathVariable("id") Long id){
        List<Reservation> reservations = iReservationService.findAllByIdUtilisateur(id);
        return reservations;
    }

}
