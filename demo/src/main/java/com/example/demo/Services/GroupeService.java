package com.example.demo.Services;

import com.example.demo.Model.Groupe;
import com.example.demo.Model.Users;
import com.example.demo.Repository.FichierRepository;
import com.example.demo.Repository.GroupeRepository;
import com.example.demo.Repository.UsersRepository;
import com.example.demo.Repository.VersionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class GroupeService {
    private final GroupeRepository groupeRepository;

    public void ajouterGroupe(String name) {
        Groupe groupe = new Groupe();
        groupe.setName(name);
        groupeRepository.save(groupe);
    }

    public void modifierName(String name, long id) {
        groupeRepository.modifiername(id, name);
    }

    public List<Groupe> getAllGroupes() {
        return groupeRepository.findAll();
    }

   public List<Object> getGroupes(long id) {
        return groupeRepository.findGroupes(id);
    }

    VersionRepository versionRepository;
    FichierRepository fichierRepository;
    UsersRepository usersRepository;
   public void updateG(long id) {
        usersRepository.updatG(id);
        fichierRepository.updatG(id);
        versionRepository.updatG(id);
    }
    public void delete(Groupe groupe) {
        groupeRepository.delete(groupe);
    }
}
