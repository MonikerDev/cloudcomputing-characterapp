package com.moniker.ccbase.controllers;

import com.moniker.ccbase.models.Character;
import com.moniker.ccbase.models.UserModel;
import com.moniker.ccbase.services.CharacterRepository;
import com.sun.jna.WString;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/characters")
@Controller
public class CharacterController {

    @Autowired
    CharacterRepository characterRepository;

    @GetMapping("/index")
    public String showCharacterList(Model model){
        model.addAttribute("characters", characterRepository.findAll());
        return "characters/index";
    }

    @GetMapping("/create")
    public String createCharacter(Model model){
        model.addAttribute("character", new Character());
        return "characters/create-character";
    }

    @PostMapping("/newcharacter")
    public String addCharacter(@Valid Character character, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "characters/create-character";
        }
        characterRepository.save(character);
        return "redirect:index";
    }

    @GetMapping("/editcharacter")
    public String showUpdateForm(@RequestParam Long id, Model model){
        Character character = characterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No character with that id"));

        model.addAttribute("character", character);
        return "characters/edit-character";
    }

    @PostMapping("updatedcharacter")
    public String updateCharacter(@RequestParam Long id, @Valid Character character,
                                  BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "characters/edit-character";
        }
        characterRepository.save(character);
        return "redirect:index";
    }

    @GetMapping("/delete")
    public String deleteCharacter(@RequestParam Long id, Model model){
        Character character = characterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid character id " + id));
        characterRepository.delete(character);
        return "redirect:index";
    }
}
