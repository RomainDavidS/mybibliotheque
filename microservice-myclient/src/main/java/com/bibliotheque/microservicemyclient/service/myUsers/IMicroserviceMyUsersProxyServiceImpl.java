package com.bibliotheque.microservicemyclient.service.myUsers;

import com.bibliotheque.microservicemyclient.bean.UtilisateurBean;
import com.bibliotheque.microservicemyclient.proxies.IMicroserviceMyUsersProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IMicroserviceMyUsersProxyServiceImpl implements IMicroserviceMyUsersProxyService {

    @Autowired
    private IMicroserviceMyUsersProxy iMicroserviceMyUsersProxy;

    @Override
    public UtilisateurBean connexionUtilisateur(String pseudo){
        return iMicroserviceMyUsersProxy.connexionUtilisateur(pseudo);
    }
}
