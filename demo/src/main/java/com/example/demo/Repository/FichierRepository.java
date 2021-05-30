package com.example.demo.Repository;

import com.example.demo.Model.FileEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface FichierRepository extends JpaRepository<FileEntity, String> {


    @Query("select v.id,v.name,v.contentType,v.size,v.date,v.user.lastName,v.user.firstName from FileEntity f  inner join Versions v on f.id=v.fileEntity.id and f.id=:id")
    List<Object> getVersionFile(String id);


    @Query("select f.id,f.name,f.contentType,f.size,f.date,f.privilege from FileEntity f where f.user.id=:id ")
    List<Object> getAllFilesP(long id);


    @Query(value = "Update FileEntity f set f.archive.id=:archive_id where f.id=:id")
    @Modifying
    void ajouterFilesArchive(String id, String archive_id);

    @Query("select f.name from FileEntity f where f.id=:id")
    List<String> findFileById(String id);

    @Query("select f.id,f.name,f.contentType,f.size,f.date,f.user.id ,f.user.firstName,f.user.lastName from FileEntity f where f.groupe.id=:id ")
    List<Object> getAllFilesG(long id);


    @Query("select f.id,f.name,f.contentType,f.size,f.date,f.user.id ,f.user.firstName,f.user.lastName from FileEntity f where f.privilege='PUBLIC' ")
    List<Object> getAllFilesPublic();

    @Query("update FileEntity f set  f.user.id=NULL where f.user.id=:id")
    @Modifying
    void updat(long id);

    @Query("update FileEntity f set  f.groupe.id=NULL where f.groupe.id=:id")
    @Modifying
    void updatG(long id);


    @Query("select f.id,f.name,f.contentType,f.size,f.date from FileEntity f ")
    List<Object> getAllFiles();
}