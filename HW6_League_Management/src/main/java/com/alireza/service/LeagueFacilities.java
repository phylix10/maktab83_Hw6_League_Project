package com.alireza.service;

import com.alireza.model.Clubs;

public interface LeagueFacilities {
    void addTeam(Clubs club);

    void deleteTeam(Clubs club);

    void showClubDetail(Clubs club);

    void showTable();
}
