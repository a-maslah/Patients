package com.example.demo.Controller;

import com.example.demo.Repository.PatientRepository;
import com.example.demo.entites.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;
    @GetMapping(path = "/patients")
    public String listePatients(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "5") int size,
                                @RequestParam(name = "keyword", defaultValue = "") String mc) {
        Page<Patient> patients = patientRepository.findByNomContains(mc, PageRequest.of(page, size));
        model.addAttribute("listePatients", patients.getContent());
        model.addAttribute("pages", new int[patients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", mc);
        model.addAttribute("size", size);
        return "patients";
    }


    @GetMapping(path = "/formPatient")
    public String formPatient(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("mode", "new");
        return "formPatient";
    }

    @PostMapping(path = "/savePatient")
    public String savePatient(@Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "formPatient";
        patientRepository.save(patient);
        return "formPatient";
    }
    @GetMapping(path = "/editPatient")
    public String editPatient(Model model, Long id) {
        Patient p = patientRepository.findById(id).get();
        model.addAttribute("patient", p);
        model.addAttribute("mode", "edit");
        return "formPatient";
    }



    @GetMapping(path = "/deletePatient")
    public String delete(Long id, String keyword, int page, int size) {

        patientRepository.deleteById(id);
        return "redirect:/patients?page=" + page + "&size=" + size + "&keyword=" + keyword;
    }
}
