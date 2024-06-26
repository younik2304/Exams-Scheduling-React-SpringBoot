package org.examschedulemanagement.Controllers;

import org.examschedulemanagement.Entities.Professor;
import org.examschedulemanagement.Service.Groups.GroupService;
import org.examschedulemanagement.Service.Professor.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.List;

@RestController
@RequestMapping("Professors")
public class ProfessorController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private ProfessorService professorService;
    @GetMapping("List")
    public ResponseEntity<List<Professor>> GetProfessors(){
        List<Professor> Professors =professorService.getProfessors();

        if(Professors!=null){
            return ResponseEntity.ok(Professors);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Professor> GetProfessorById(@PathVariable Long id ){
        Professor Professor =professorService.getProfessorById(id);
        if(Professor!=null){
            return ResponseEntity.ok(Professor);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor Professor) {
        System.out.println(Professor);
        // Logic to create resource
        Professor savedProfessor = professorService.getProfessorByEmail(Professor.getEmail());
        if(savedProfessor!=null){
            //TODO repond with email already exists
        }
        return ResponseEntity.ok().body(professorService.addProfessor(Professor));
    }
    @PostMapping("{id}/filiere/{filiere}/departement/{departement}")
    public ResponseEntity<Professor>assignFiliereDepartement (@PathVariable Long id ,@PathVariable String filiere,@PathVariable String departement){
        professorService.assignFiliereToProfessor(id,filiere);
        professorService.assignDepartementToProfessor(id,departement);
        return ResponseEntity.ok().body(professorService.getProfessorById(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Professor> updateResource(@PathVariable Long id, @RequestBody Professor updatedProfessor) {
        // Logic to update resource
        Professor Professorupdated=professorService.updateProfessor(id,updatedProfessor);
        if(Professorupdated!=null){
            return ResponseEntity.ok(Professorupdated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Example of a DELETE method
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Professor> deleteResource(@PathVariable Long id) {
        // Logic to delete resource
        Professor Professor = professorService.getProfessorById(id);
        if (Professor != null) {
            Professor removedProfessor=professorService.deleteProfessor(professorService.getProfessorById(id));
            return ResponseEntity.ok(removedProfessor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
